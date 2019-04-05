<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>

<%
Map<String, Object> map=new HashMap<String, Object>();
List<MmServiceRequest> mmServiceRequest=new ArrayList<MmServiceRequest>();
int preventive=0;
int corrective=0;
boolean flag=true;
long diff=0;
Calendar calendar1=Calendar.getInstance();
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
if(request.getAttribute("map")!=null){
	map = (Map<String ,Object>) request.getAttribute("map");
}
if(map.get("mmServiceRequest")!=null){
	mmServiceRequest=(List<MmServiceRequest>)map.get("mmServiceRequest");
}
for(MmServiceRequest mmServiceRequest2:mmServiceRequest){
	//  For Down Time 
	Calendar closeDate=Calendar.getInstance();
	Calendar requestDate=Calendar.getInstance();
	System.out.println(mmServiceRequest2.getCloseDate()+""+mmServiceRequest2.getCloseTime());
	if(mmServiceRequest2.getCloseDate()!=null && mmServiceRequest2.getCloseTime()!=null)
		
	closeDate.set(mmServiceRequest2.getCloseDate().getYear()+1900, mmServiceRequest2.getCloseDate().getMonth(), mmServiceRequest2.getCloseDate().getDate(), Integer.parseInt(mmServiceRequest2.getCloseTime().split(":")[0]), Integer.parseInt(mmServiceRequest2.getCloseTime().split(":")[1]), 00);
	requestDate.set(mmServiceRequest2.getRequestDate().getYear()+1900, mmServiceRequest2.getRequestDate().getMonth(), mmServiceRequest2.getRequestDate().getDate(), Integer.parseInt(mmServiceRequest2.getRequestTime().split(":")[0]), Integer.parseInt(mmServiceRequest2.getRequestTime().split(":")[1]),00);
	calendar1.setTimeInMillis(closeDate.getTime().getTime()-requestDate.getTime().getTime());
	diff+=(closeDate.getTime().getTime()-requestDate.getTime().getTime());
	//    For Up Time
	long diffHours1 = (closeDate.getTime().getTime()-closeDate.getTime().getDate())/ (60 * 60 * 1000) % 24;
	
	if(mmServiceRequest2.getRequestType().equalsIgnoreCase("Preventive")){
		preventive=preventive+1;
	}else{
		corrective=corrective+1;
	}
}
//     Down Time Calculation
long diffSecondsDownTime = diff / 1000 % 60;
long diffMinutesDownTime = diff / (60 * 1000) % 60;
long diffHoursDownTime = diff / (60 * 60 * 1000) % 24;
long diffDaysDownTime = diff / (24 * 60 * 60 * 1000);
//     Up Time Calculation
long diffSecondsUpTime = (60-diffSecondsDownTime);
long diffMinutesUpTime = (59-diffMinutesDownTime);
long diffHoursUpTime = (23-diffHoursDownTime);

%>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
	String userName = "";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	
	%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
	
		function checkData(){
		var start= new Date(document.getElementById("fromDate").value);
		 var end= new Date(document.getElementById("toDate").value);
		 if(start<=end){
			 return true;
		 }else{alert("Date is Incorrect.");return false;}
}
	

</script>

<div class="titleBg">
<h2>Equipment Dash Board</h2>
</div>
<div class="clear"></div>
<form name="Search" method="post">
<div class="Block">
	 <label><span>* </span>From Date</label> 
	 <input id="fromDate" class="date" type="text" maxlength="30" validate="fromDate,date,yes" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="fromDate">
	 <img width="16" height="16" border="0" onclick="javascript:setdate('',document.Search.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
		<label><span>* </span>To Date</label>
		 <input id="toDate" class="date" type="text" maxlength="30" validate="toDate,date,yes" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="toDate">
	 <img width="16" height="16" border="0" onclick="javascript:setdate('',document.Search.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">

</div>
<input type="button" class="button" onclick="submitForm('Search', 'maintenance?method=showEquipmentDashBoard')" value="Search" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<h4>Equipment Details</h4>
<div class="clear"></div>
<div class="Block">
<%-- 	<%if(mmServiceRequest2.getCloseDate()!=null){ %> --%>
	<label>Up Time</label>
	<input type="text" readonly="readonly" value="<%=diffHoursUpTime %>:<%=diffMinutesUpTime %>:<%=diffSecondsUpTime %> Hours" />
	<label>Down Time</label>
	<input type="text" readonly="readonly" value="<%=diffDaysDownTime %> Day, <%=diffHoursDownTime %>:<%=diffMinutesDownTime %>:<%=diffSecondsDownTime %> Hours" />
<%-- 	<%}else{ %><label>Open Request</label><%} %> --%>
	<label>No. Of Preventive</label>
	<input type="text" readonly="readonly" value="<%=preventive %>" />
	<div class="clear"></div>
	<label>No. Of Corrective</label>
	<input type="text" readonly="readonly" value="<%= corrective%>" />
	
</div>
<div class="clear"></div>
<input type="button" onclick="javascript: history.go(-1);" class="button" value="Back" /> 
<div class="clear"></div>
	<div class="bottom">
		<label>Changed By:</label>
		<label class="value"><%=userName%></label>
		<label>Changed Date:</label>
		<label class="value"><%=currentDate%></label>
		<label>Changed Time:</label>
		<label class="value"><%=currentTime%></label>
	</div>
<!--Block Two Ends-->
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<!--Bottom labels starts-->
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	</div>
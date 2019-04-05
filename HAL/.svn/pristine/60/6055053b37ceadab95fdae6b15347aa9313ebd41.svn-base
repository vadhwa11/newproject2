<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HesEquipmentAmcDetailsEntry"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasPriorityCodes"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<%@page import="java.util.*"%>
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
	%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
</script>

<%
String entryNo = "";
String userName = "";
String el="";
Map<String,Object> utilMap = new HashMap<String,Object>();
Map<String ,Object> map = new HashMap<String ,Object>();
List<HesEquipmentMaster> hesEquipmentMaster = new ArrayList<HesEquipmentMaster>();
List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
List<MmServiceRequest> serviceRequest = new ArrayList<MmServiceRequest>();
if(request.getAttribute("map")!=null)
{
	map = (Map<String ,Object>) request.getAttribute("map");
}
if (map.get("equipmentMaster")!= null){
	hesEquipmentMaster = (List<HesEquipmentMaster>)map.get("equipmentMaster");
}if (map.get("serviceDetail")!= null){
	serviceRequest = (List<MmServiceRequest>)map.get("serviceDetail");
}
if (map.get("hesEquipmentAmcDetailsEntry")!= null){
	hesEquipmentAmcDetailsEntry = (List<HesEquipmentAmcDetailsEntry>)map.get("hesEquipmentAmcDetailsEntry");
}
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

//     for(HesEquipmentMaster equipmentMaster:hesEquipmentMaster){
// 	SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd");
// 	Date wD=sd.parse(equipmentMaster.getWarrentyEndDate().toString()); 
// 	Date currentDate=new Date();
// 	String status="";
// 	String s="";
// 	if(wD.after(currentDate)){status="AMC";s="Y";}else{status="None";s="N";}
	
%>
<div class="titleBg">
<h2>Equipment History</h2>
</div>
<div class="clear"></div>
<h4>Equipment Details</h4>
<form name="mServiceRequest" target="_blank" method="post" action="">
<div class="Block">

	<%@include file="mEquipmentDetail.jsp" %>
</div>
<%//} %>
<h4>Repair Details</h4>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="Block">
	<% int  counter=0;
	if(serviceRequest.size()>0){ %>
	<table class="cmntable">
	<tr><th>S.No </th><th>Request Date</th><th>Request No</th><th>Priority</th><th>Request Type</th><th>Request By</th><th>Request From</th><th>Remarks</th><th>Closed Date</th><th>Status</th></tr>
	<% 
		for(MmServiceRequest serviceDetail:serviceRequest){
		String requestType="";
		if(requestType.equals("P")){requestType="Preventive";}else{requestType="Corrective";}
	%>
			<tr><td><%= counter+1%></td>
			<td><%=HMSUtil.changeDateToddMMyyyy(serviceDetail.getRequestDate())%></td>
			<td><%=serviceDetail.getServiceRequestNo()%></td>
			<td><%=serviceDetail.getPriority().getCodesName()%></td>
			<td><%=serviceDetail.getRequestType()%></td>
			<td><%=serviceDetail.getLastChgBy().getEmployee().getFirstName()%></td>
			<td><%=serviceDetail.getEquipment().getDepartment().getDepartmentName()%></td>
			<td><%if(serviceDetail.getRemarks()!=null){%><%=serviceDetail.getRemarks()%><%} %></td>
			<td><%=serviceDetail.getCloseDate()!=null?serviceDetail.getCloseDate():""%></td>
			<td><%=serviceDetail.getRequestStatus().getStatusName()%></td></tr>
			
<%		++counter;
				}
	%>
	</table>
	<%}else{ %>
	No Records Available.
	<%} %>
 </div> 
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
	<input type="hidden" name="eL" id="eL" value="<%=el %>" />
	</div>

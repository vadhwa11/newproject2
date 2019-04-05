<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.AccomAllotment"%>
<script>
function chkLength(field,maxLimit)
{
	if(field.value.length > maxLimit)
	{
	 alert('you crossed the maximum limit of '+maxLimit+' characters');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}
 function resetResult(){
 
	   document.getElementById('<%=REMARKS%>').value="";
	   document.getElementById('<%=MAINTENANCE%>').value="y";
   }
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
 %>
serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<%
Map<String,Object> map = new HashMap<String,Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map<String,Object>) request.getAttribute("map");
}
utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
String currentDate = (String) utilMap.get("currentDate");
String userName="";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
int deptId =0;
if(session.getAttribute("deptId") != null){
	deptId = (Integer)session.getAttribute("deptId");
}
int hospitalId =0;
if(session.getAttribute("hospitalId") != null){
	hospitalId = (Integer)session.getAttribute("hospitalId");
}

List<AccomAllotment> smqVacationDetailList = new ArrayList<AccomAllotment>();
AccomAllotment accomAllot = new AccomAllotment();
try{
	if(map.get("smqVacationDetailList") != null){
		smqVacationDetailList=(List)map.get("smqVacationDetailList");
	}
}catch(Exception e){
	e.printStackTrace();
}
 if(smqVacationDetailList != null){
	 accomAllot = (AccomAllotment)smqVacationDetailList.get(0);
 }
 String vacationNo="";
 if(map.get("vacationNo")!= null){
	 vacationNo= (String)map.get("vacationNo");
 }
	String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
	 	System.out.println("message  :  "+message);
%>
<h2><%=message %></h2>

<%} %>

<div id="contentHolder">
<h6>Smq Vacation For Officers</h6>
<form name="searchSmq" method="post" action="">
<div class="Clear"></div>
<div class="blockTitle">Marriage Accomodation Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<input type="hidden" name="accomRegId" id="accomRegId"
	value="<%=accomAllot.getAccom().getId() %>"> <label>Registration
No.</label> <%if(accomAllot.getAccom()!= null){ %> <label class="value"><%= accomAllot.getAccom().getRegistrationNo()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Registration
Date</label> <%if(accomAllot.getAccom()!= null){ %> <label class="value"><%=HMSUtil.convertDateToStringWithoutTime(accomAllot.getAccom().getRegistrationDate())%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Registration
Time</label> <%if(accomAllot.getAccom()!= null){ %> <label class="value"><%= accomAllot.getAccom().getRegistrationTime()%></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="Clear"></div>

<label>Service No.</label> <%if(accomAllot.getAccom()!= null){ %> <label
	class="value"><%= accomAllot.getAccom().getServiceNo()%></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Service Person Name</label> <%if(accomAllot.getAccom()!= null){ %>
<label class="value"><%= accomAllot.getAccom().getServicePersonName()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Service
Type</label> <%if(accomAllot.getAccom().getServiceType()!= null){ %> <label
	class="value"><%= accomAllot.getAccom().getServiceType().getServiceTypeName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="Clear"></div>

<label>Rank</label> <%if(accomAllot.getAccom()!= null){ %> <label
	class="value"><%= accomAllot.getAccom().getRank().getRankName()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Trade</label> <%if(accomAllot.getAccom()!= null){ %>
<label class="value"><%= accomAllot.getAccom().getTrade().getTradeName()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Suffix</label> <%if(accomAllot.getAccom()!= null){ %>
<label class="value"><%= accomAllot.getAccom().getSfx()%></label> <%}else{ %>
<label class="value">-</label> <%} %>

<div class="Clear"></div>

<label>Allocation No.</label> <%if(accomAllot.getAllotmentNo()!= null){ %>
<label class="value"><%= accomAllot.getAllotmentNo()%></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Allocation Date</label> <%if(accomAllot.getAllotmentDate()!= null){ %>
<label class="value"><%= HMSUtil.convertDateToStringWithoutTime(accomAllot.getAllotmentDate())%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Allocation
Time</label> <%if(accomAllot.getAllotmentTime()!= null){ %> <label class="value"><%=accomAllot.getAllotmentTime()%></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="Clear"></div>


</div>

<div class="blockTitle">Vacation Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>

<label>Vacation No</label> <label class="value"><%=vacationNo %></label>

<label>Vacation Date</label> <label class="value"><%=date%></label> <label>Vacation
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>

<label>Pool Code</label> <%if(accomAllot.getAccom()!= null){ %> <label
	class="value"><%= accomAllot.getAccom().getPool().getPoolName()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>SMQ No.</label> <%if(accomAllot.getAccom()!= null){ %>
<label class="value"><%= accomAllot.getSmq().getSmqName()%></label> <input
	type="hidden" value="<%=accomAllot.getSmq().getId() %>"
	name="<%=SMQ_ID %>" id="<%=SMQ_ID %>" /> <%}else{ %> <label class="value">-</label>
<input type="hidden" value="" name="<%=SMQ_ID %>" id="<%=SMQ_ID %>" /> <%} %>
<label>Vacated HO_To</label> <input type="text" class="calDate"
	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currentDate %>"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.searchSmq.<%=FROM_DATE%>,event)" />

<div class="Clear"></div>

<label> Remarks</label> <textarea value="" onkeyup="chkLength(this,50);"
	name="<%=REMARKS %>" id="<%=REMARKS %>" tabindex="1" class="large"></textarea>
<label>Maintenance</label> <input type="checkbox"
	name="<%=MAINTENANCE%>" id="<%=MAINTENANCE%>" value="y" class="radio"
	tabindex="1" />
<div class="Clear"></div>
</div>

<div class="Height10"></div>
<div class="division"></div>
<!-- Table Ends --> <!--Bottom labels starts-->
<div class="bottom"><input type="button" class="button"
	value="Submit"
	onclick="submitForm('searchSmq','accom?method=submitSmqVacationForOfficer')"
	align="right" /> <input name="Button" type="button" class="button"
	value="Reset" onclick="resetResult();" /> <input name="Button"
	type="button" class="button" value="Back" onclick="" />
<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input type="hidden"
	name="<%=ACCOM_ID %>" value="<%=accomAllot.getId()%>" /> <input
	type="hidden" name="<%=VACATION_NO %>" value="<%=vacationNo%>" /> <input
	type="hidden" name="<%=VACATION_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=VACATION_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=deptId%>" /> <input
	type="hidden" name="<%=HOSPITAL_ID %>" value="<%=hospitalId%>" />

<div class="Clear"></div>


</div>
</form>
</div>
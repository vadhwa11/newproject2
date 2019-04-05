<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasSmq"%>
<%@page import="jkt.hms.masters.business.AccomAllotment"%>
<%@page import="jkt.hms.masters.business.MasPool"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script>
function resetValue(){
document.getElementById('poolId').value ='0';
document.getElementById('alotmentNo').value ="";
document.getElementById('smqId').value ='0';

}
</script>
<script>
function checkSubmit(){

if(document.getElementById('counter').value==0 || document.getElementById('counter').value ==""){

	  	alert(" There should be atleast one row to submit records ");
	  	return false;
	  	}else
	  	{
	  
	  	return true;
	  	}
	  	
}
</script>
<script type="text/javascript" language="javascript">
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
Map<String, Object> utilMap = new HashMap<String, Object>();
Map<String, Object> detailsMap = new HashMap<String, Object>();
utilMap = (Map<String,Object>) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
date = (String) utilMap.get("currentDate");
String userName = "";
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
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
map = (Map<String, Object>)request.getAttribute("map");
}

if(map.get("detailsMap") !=null){
detailsMap=(Map<String, Object>)map.get("detailsMap");
}
List<MasPool> poolList = new ArrayList<MasPool>();
if(detailsMap.get("poolList") != null){
	poolList = (List<MasPool>)detailsMap.get("poolList");
}
List<MasSmq> smqList=  new ArrayList<MasSmq>();
if(detailsMap.get("smqList") != null){
smqList = (List<MasSmq>)detailsMap.get("smqList");
}
Map<String, Object> patientMap = new HashMap<String, Object>();
List<AccomAllotment> allotmentList = new ArrayList<AccomAllotment>();
if(map.get("patientMap") != null){
	patientMap= (Map<String, Object>)map.get("patientMap");
	}
if(patientMap.get("allotmentList") != null){
	allotmentList= (List<AccomAllotment>)patientMap.get("allotmentList");
	}
%>
<% 
String message ="";
if (map.get("message") != null) {
	message = (String) map.get("message");
 }
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>


<div id="contentHolder">
<form name="smqSearch" action="" method="post">
<h6>Occupancy / Vacation Return for Officer</h6>
<div class="Clear"></div>
<div class="blockTitle">Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>

<label>HO_TO From Date</label> <input type="text" class="calDate"
	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currentDate %>"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.smqSearch.<%=FROM_DATE%>,event)" />

<label>HO_TO To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"
	readonly="readonly" validate="To Date,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.smqSearch.<%=TO_DATE%>,event)" />

<div class="Clear"></div>
<label>Allotment From Date</label> <input type="text" class="calDate"
	id="<%=ALLOTMENT_DATE%>" name="<%=ALLOTMENT_DATE%>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.smqSearch.<%=ALLOTMENT_DATE%>,event)" />

<label>Allotment To Date</label> <input type="text"
	id="<%=ALLOTMENT_FILE_DATE %>" name="<%=ALLOTMENT_FILE_DATE %>"
	value="<%=currentDate %>" class="calDate" readonly="readonly"
	validate="To Date,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.smqSearch.<%=ALLOTMENT_FILE_DATE%>,event)" />


<div class="Clear"></div>
<label>Allotment No</label> <input type="text" name="<%=ALLOTMENT_NO %>"
	id="<%=ALLOTMENT_NO %>" value="" MAXLENGTH="20"
	onkeypress="return submitenter(this,event,'accom?method=searchOccVacOfficer')" />

<label>Pool</label> <select id="poolId" name="<%=POOL_ID %>">
	<option value="0">Select</option>
	<%
					for(MasPool masPool : poolList){
				%>
	<option value="<%=masPool.getId() %>"><%=masPool.getPoolName() %></option>
	<%}%>
</select> <label>SMQ No</label> <select id="smqId" name="<%=SMQ_ID %>">
	<option value="0">Select</option>
	<%
					for(MasSmq masSmq : smqList){
				%>
	<option value="<%=masSmq.getId() %>"><%=masSmq.getSmqName() %></option>
	<%}%>
</select>

<div class="Clear"></div>
<input type="radio" class="radio" name="<%=PREVIOUS_SMQ %>" value="o"
	checked="checked" /> <label class="valueNoWidth">Occupancy Wise</label>
<input type="radio" class="radio" name="<%=PREVIOUS_SMQ %>" value="v" />
<label class="valueNoWidth">Vacation Wise</label>
<div class="Clear"></div>
<input type="button"
	onclick="submitFormForButton('smqSearch','/hms/hms/accom?method=searchOccVacOfficer','checkFromNTodata');"
	value="Search" class="cmnButton" accesskey="a" /></div>
</form>
<form name="grid" action="" method="post">
<div class="Clear"></div>


<div class="tableHolderAuto">

<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">

	<tr>
		<th width="2%">Allotment Order File No.</th>
		<th>Allotment Order File Date</th>
		<th>SMQ No.</th>
		<th>Pool Code</th>
		<th>Service No</th>
		<th>Name</th>
		<th>Allotment/vacation Date</th>
		<th>Physical occupancy Date/Physical vacation date</th>
	</tr>

	<%int inc =0;
    System.out.println("allotmentList   "+allotmentList.size());
    if(allotmentList.size() >0 && allotmentList != null){
    	for(AccomAllotment accomAllot :allotmentList){
    		inc++;
    	%>

	<tr>

		<td><label name="<%=ALLOTMENT_FILE_NO %>"
			id="<%=ALLOTMENT_FILE_NO %><%=inc %>"><%=accomAllot.getAllotmentNo() %></label>
		<input type="hidden" name="<%=ALLOTMENT_ID %>"
			id="<%=ALLOTMENT_ID %><%=inc %>" value="<%=accomAllot.getId() %>" />
		<input type="hidden" name="<%=ALLOTMENT_FILE_NO %>"
			id="<%=ALLOTMENT_FILE_NO %><%=inc %>"
			value="<%=accomAllot.getAllotmentNo() %>" /> <input type="hidden"
			name="<%=DEPARTMENT_ID %>" id="<%=DEPARTMENT_ID %><%=inc %>"
			value="<%=deptId %>" /> <input type="hidden" name="<%=HOSPITAL_ID %>"
			id="<%=HOSPITAL_ID %><%=inc %>" value="<%=hospitalId %>" /> <input
			type="hidden" name="<%=CHANGED_BY%>" id="<%=CHANGED_BY%><%=inc %>"
			value="<%=userName%>" /> <input type="hidden"
			name="<%=CHANGED_DATE %>" id="<%=CHANGED_DATE %><%=inc %>"
			value="<%=date%>" /> <input type="hidden" name="<%=CHANGED_TIME %>"
			id="<%=CHANGED_TIME %><%=inc %>" value="<%=time%>" /> <input
			type="hidden" name="<%=REGISTRATION_ID %>"
			id="<%=REGISTRATION_ID %><%=inc %>"
			value="<%=accomAllot.getAccom().getId() %>" /></td>

		<td><label name="<%=ALLOTMENT_DATE %>"
			id="<%=ALLOTMENT_DATE %><%=inc %>"><%=HMSUtil.convertDateToStringWithoutTime(accomAllot.getAllotmentDate()) %></label>
		<input type="hidden" name="<%=ALLOTMENT_TIME %>"
			id="<%=ALLOTMENT_TIME %>" value="<%=accomAllot.getAllotmentTime() %>"</td>

		<td><label name="<%=SMQ_ID %>" id="<%=SMQ_ID %><%=inc %>"><%=accomAllot.getSmq().getSmqName() %></label>
		</td>

		<td><label name="<%=POOL_ID %>" id="<%=POOL_ID %><%=inc %>"><%=accomAllot.getPool().getPoolCode() %></label>
		</td>

		<td><label name="<%=SERVICE_NO %>" id="<%=SERVICE_NO %><%=inc %>"><%=accomAllot.getAccom().getServiceNo()%></label>
		</td>

		<td><label name="<%=SERVICE_PERSON_NAME %>"
			id="<%=SERVICE_PERSON_NAME %><%=inc %>"><%=accomAllot.getAccom().getServicePersonName()%></label>
		</td>

		<td><label name="<%=DATE %>" id="<%=DATE %><%=inc %>"><%=HMSUtil.convertDateToStringWithoutTime(accomAllot.getAllotmentDate())%></label>
		</td>

		<td><input type="text" class="calDate"
			id="<%=ENTRY_DATE %><%=inc %>" name="<%=ENTRY_DATE %>"
			value="<%=date %>" readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=date %>',document.grid.<%=ENTRY_DATE%><%=inc%>,event)" />
		</td>
	</tr>
	<%} }%>

</table>
</div>
<div class="division"></div>
<input type="hidden" name="counter" id="counter" value="<%=inc %>" /> <input
	type="button" class="cmnButton" value="Submit" align="left"
	onClick="if(checkSubmit()){submitForm('grid','accom?method=submitRecordsForOccVacOfficer');}"
	tabindex="1" /> <input type="button" class="cmnButton" value="Reset"
	align="left" onClick="resetValue();" tabindex="1" /></form>
</div>
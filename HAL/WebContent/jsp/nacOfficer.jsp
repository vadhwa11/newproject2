<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasSmq"%>
<%@page import="jkt.hms.masters.business.AccomAllotment"%>
<%@page import="jkt.hms.masters.business.AccomRegistration"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder">
<form name="smqSearch" action="" method="post"><script
	type="text/javascript" language="javascript">
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
</script> <script>
function checkSubmit(){

if(document.getElementById('counter').value==0 || document.getElementById('counter').value ==""){

	  	alert(" There should be atleast one row to submit records ");
	  	return false;
	  	}else
	  	{
	  
	  	return true;
	  	}
	  	
}


function check(){
	var inc=0;
for(var i = 0; i < document.getElementsByName('<%=VALIDATED%>').length; i++){
var msg="";

	if(document.getElementsByName('<%=VALIDATED%>')[i].checked == false){
	  	msg =" Please Accept before submitting records ";
	  	}else{
	  		break;
	  	}
} 	
	
 if(msg !=""){
	 alert(msg)
	 return false;
 }else{
	 return true;
	}
}

</script> <script>

function chkLength(field,maxLimit)
{
	if(field.value.length > maxLimit)
	{
	 alert('you crossed the maximum limit of '+maxLimit+' characters');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}

function resetValue(){
document.getElementById('serviceNo').value="";
document.getElementById('remarks').value="";
for(i=1;i<document.getElementById('counter').value;i++)
{
document.getElementById('<%=VALIDATED%>'+i).checked = false;
document.getElementById('<%=SMQ_NAME%>'+i).value ="";
}
}
</script> <%
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

Map<String, Object> patientMap = new HashMap<String, Object>();
List<AccomRegistration> nacList = new ArrayList<AccomRegistration>();
if(map.get("patientMap") != null){
	patientMap= (Map<String, Object>)map.get("patientMap");
	}
if(patientMap.get("nacList") != null){
	nacList= (List<AccomRegistration>)patientMap.get("nacList");
	}
List<AccomAllotment> accomList = new ArrayList<AccomAllotment>();
if(patientMap.get("accomList") != null){
	accomList= (List<AccomAllotment>)patientMap.get("accomList");
	}
List<MasSmq> smqlist = new ArrayList<MasSmq>();
if(patientMap.get("smqlist") != null){
	smqlist= (List<MasSmq>)patientMap.get("smqlist");
	}
%>

<h6>Non Availability Certificate for Officers(NAC)</h6>
<div class="Clear"></div>
<div class="blockTitle">Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>

<label class="large">Registration From Date</label> <input type="text"
	class="calDate" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.smqSearch.<%=FROM_DATE%>,event)" />

<label class="large">Registration To Date</label> <input type="text"
	id="ToDateId" name="<%=TO_DATE %>" value="<%=currentDate %>"
	class="calDate" readonly="readonly" validate="To Date,date,yes"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.smqSearch.<%=TO_DATE%>,event)" />

<div class="Clear"></div>
<label class="large">Service No.</label> <input type="text"
	name="<%=SERVICE_NO %>" id="<%=SERVICE_NO %>" value="" MAXLENGTH="10"
	onkeypress="return submitenter(this,event,'accom?method=nacOfficer')" />


<div class="Clear"></div>
<input type="button"
	onclick="submitFormForButton('smqSearch','/hms/hms/accom?method=nacOfficer','checkFromNTodata');"
	value="Search" class="cmnButton" accesskey="a" /></div>
</form>
<form name="grid" action="" method="post">
<div class="Clear"></div>


<div class="tableHolderAuto">

<table width="100%" colspan="7" cellpadding="0" cellspacing="0">

	<tr>
		<th>Register No.</th>
		<th>Register Date</th>
		<th>Service No.</th>
		<th>Name</th>
		<th>Rank</th>
		<th>Smq No</th>
		<th>Issue</th>
		<th>Accepted</th>
	</tr>

	<%int inc=0;
    if(nacList.size() >0 && nacList != null){
    	for(AccomRegistration accomReg :nacList){
    		inc++;
    	%>

	<tr>

		<td><label name="<%=REGISTRATION_NO %>"
			id="<%=REGISTRATION_NO %><%=inc %>"><%=accomReg.getRegistrationNo()%></label>
		<input type="hidden" name="<%=REGISTRATION_ID %>"
			id="<%=REGISTRATION_ID %><%=inc %>" value="<%=accomReg.getId() %>" />
		<input type="hidden" name="<%=CHANGED_BY%>"
			id="<%=CHANGED_BY%><%=inc %>" value="<%=userName%>" /> <input
			type="hidden" name="<%=CHANGED_DATE %>"
			id="<%=CHANGED_DATE %><%=inc %>" value="<%=date%>" /> <input
			type="hidden" name="<%=CHANGED_TIME %>"
			id="<%=CHANGED_TIME %><%=inc %>" value="<%=time%>" /></td>

		<td><label name="<%=REGISTRATION_DATE %>"
			id="<%=REGISTRATION_DATE %><%=inc %>"><%=HMSUtil.convertDateToStringWithoutTime(accomReg.getRegistrationDate()) %></label>
		</td>

		<td><label name="<%=SERVICE_NO %>" id="<%=SERVICE_NO %><%=inc %>"><%=accomReg.getServiceNo()%></label>
		</td>

		<td><label name="<%=SERVICE_PERSON_NAME %>"
			id="<%=SERVICE_PERSON_NAME %><%=inc %>"><%=accomReg.getServicePersonName()%></label>
		</td>

		<td><label name="<%=RANK_NAME %>" id="<%=RANK_NAME %><%=inc %>"><%=accomReg.getRank().getRankName()%></label>
		</td>

		<td><select name="<%=SMQ_NAME %>" id="<%=SMQ_NAME %><%=inc%>" />

			<% 	if(smqlist!= null)
 	{
  		for(MasSmq masSmq : smqlist)
  		{
  			if(masSmq.getId() != null && masSmq.getSmqStatus().equalsIgnoreCase("o"))
  			{ 
  				 %>
			<option value="<%=masSmq.getId() %>"><%=masSmq.getSmqName() %></option>

			<%
  			}
  		}
  	}
    	%>
		</td>

		<td><input type="button" class="cmnButton"
			value="NAC Certificate" name="issue" id="issue<%=inc%>"
			onclick="submitFormForButton('grid','accom?method=generateNacReport')" />
		</td>

		<td><input type="checkbox" class="radio" name="<%=VALIDATED%>"
			id="<%=VALIDATED%><%=inc %>" value="1" /></td>
	</tr>
	<%} }%>

</table>
</div>
<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
<div class="divsion"></div>
<div class="blockFrame"><label>Remarks</label> <textarea value=""
	class="large" name="<%=REMARKS %>" id="<%=REMARKS %>" maxlength="50"
	onkeyup="chkLength(this,50);" validate="Remarks,string,no" tabindex="1"></textarea>
</div>
<div class="Height10"></div>
<div class="division"></div>
<!-- Table Ends --> <!--Bottom labels starts-->
<div class="bottom"><input type="button" class="cmnButton"
	value="Submit" align="left"
	onClick="if(checkSubmit()&& check()){submitForm('grid','accom?method=submitNac');}" />
<input name="Button" type="button" class="cmnButton" value="Reset"
	onclick="resetValue();" />

<div class="Clear"></div>

<div class="division"></div>


<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label></div>
<div class="Clear"></div>


</form>
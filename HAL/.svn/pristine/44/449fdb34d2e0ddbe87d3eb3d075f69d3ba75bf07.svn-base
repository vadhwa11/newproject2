<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.HrLeaveTypeMaster"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@ page import="jkt.hms.masters.business.PostedOutEntry"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<form name="postedOutEntry" method="post" action="">
<body onload="changeButton();">
<script type="text/javascript">

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
	function postedTypeValidation(){
	var postedType= document.getElementById('postedType').value
	if(postedType!='transfer'){
	document.getElementById('<%=UNIT_POSTED_TO%>').value='0'
	}
	
	}
	function sorsdate(){
	var dateofposting = document.getElementById('date').value
	document.getElementById('sors').value=dateofposting
	
	}
	
</script>

<%
Map<String,Object> map = new HashMap<String,Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
String userName = "";
List<PostedOutEntry> postedoutentryList = null;
PostedOutEntry postedOutEntry = null;
if(session.getAttribute("userName") != null)
{
	userName = (String)session.getAttribute("userName");
}
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
	}

List<HrLeaveTypeMaster> leaveTypeList=new ArrayList<HrLeaveTypeMaster>();
List<MasUnit> unitList=new ArrayList<MasUnit>();
List<MasEmployee> employeeList=new ArrayList<MasEmployee>();

if(map.get("leaveTypeList") != null){
	leaveTypeList = (List<HrLeaveTypeMaster>)map.get("leaveTypeList");
	}
if(map.get("unitList") != null){
	unitList = (List<MasUnit>)map.get("unitList");
	}
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
	}
if(map.get("postedoutentryList")!=null){
	postedoutentryList =(List<PostedOutEntry>)map.get("postedoutentryList");
}
if(postedoutentryList !=null && postedoutentryList.size()>0){
postedOutEntry = (PostedOutEntry)postedoutentryList.get(0);
}

String entryNo ="";
if(map.get("entryNo") != null){
	entryNo = (String)map.get("entryNo");
}else if (postedOutEntry !=null){
	entryNo = (String)postedOutEntry.getEntryNo();
}

int id = 0;
if(map.get("Id") != null)
{
	id = (Integer)map.get("Id");
}

String message="";
if(map.get("message") != null){
 	message = (String)map.get("message");
%>
<br />

<h2><%=message %></h2>

<%}%>
<script type="text/javascript">
function changeButton()
{
var discipline = document.getElementById('disciplinepending').value;
if(discipline=='1'|| discipline=='y'){
document.getElementById('add').style.display='none';
document.getElementById('reset').style.display='none';
}else{
document.getElementById('add').style.display='block';
document.getElementById('reset').style.display='block';
}
}
</script>
<div class="Clear"></div>
<div id="contentHolder">
<h6>Posted Out Entry(Clearence Form)</h6>
<div class="Clear"></div>
<div class="blockTitle">Employee Credential</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<%if(employeeList.get(0).getServiceType()!=null){ %> 
<label>Service Type:-</label> 
<label><%=employeeList.get(0).getServiceType().getServiceTypeName() %></label>
<%}%> 
<%if(employeeList.get(0).getServiceNo()!=null){ %> 
<label>Service No:- <%=employeeList.get(0).getServiceNo() %></label> 
<%} %> 
<%if(employeeList.get(0).getRank()!=null){ %>
<label>Rank:- <%=employeeList.get(0).getRank().getRankName() %></label>
<%} %>
<div class="Clear"></div>
<label>Name Of Employee:-</label> 
<label>
<%if(employeeList.get(0).getFirstName()!=null){%> <%=employeeList.get(0).getFirstName() %>&nbsp
&nbsp <%}if(employeeList.get(0).getMiddleName()!=null){ %> <%=employeeList.get(0).getMiddleName() %>&nbsp
&nbsp <%}if(employeeList.get(0).getLastName()!=null){ %> <%=employeeList.get(0).getLastName() %>
<%} %> 
</label>
<div class="Clear"></div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="blockFrame">
<% for(MasEmployee masemployee : employeeList){%> 
<input type="hidden" id="disciplinepending" value="<%=masemployee.getDisciplinePending() %>" />
<input type=hidden name="<%=ENTRY_NO %>" value="<%=entryNo %>" />
<%if(postedOutEntry!=null){ %>
<input type=hidden name="postedoutId" value="<%=postedOutEntry.getId() %>" />
<%}else{ %>
<input type=hidden name="postedoutId" value="" />
<%} %>
<%if( (masemployee.getDisciplinePending()!=null && (masemployee.getDisciplinePending().equals("0") || masemployee.getDisciplinePending().equals("n"))) || masemployee.getDisciplinePending()==null ){		
		%>
<!-- Start of posted out for clearence  -->
<label><span>*</span>Posted Out Type</label> 
<select id="postedType" name="<%=POSTED_TYPE %>" validate="Posted Type,string,yes" onchange="handleRem()" onblur="postedTypeValidation();" tabindex="1">
	<option value="0">Select</option>
	<%if(postedOutEntry !=null && postedOutEntry.getPostedType().equalsIgnoreCase("transfer")){ %>
	<option value="transfer" selected="selected">Transfer</option>
	<option value="retirement">Retirement</option>
	<%}else if(postedOutEntry !=null && postedOutEntry.getPostedType().equalsIgnoreCase("retirement")){ %>
	<option value="transfer" >Transfer</option>
	<option value="retirement" selected="selected">Retirement</option>
	<%}else{ %>
	<option value="transfer" >Transfer</option>
	<option value="retirement">Retirement</option>
	<%} %>
</select> 
<label><span>*</span>Entry No.</label> 
<label class="value"><%=entryNo %></label>
<div class="Clear"></div>
<div id="abc" style="display: none;"><label>Unit Posted To</label>
<select id="<%=UNIT_POSTED_TO%>" name="<%=UNIT_POSTED_TO%>" tabindex="1">
	<option value="0">Select</option>
	<% if(postedOutEntry !=null && postedOutEntry.getUnitPostedTo()!=null){
		for(MasUnit masUnit : unitList){
			if(masUnit!=null && masUnit.getId().equals(postedOutEntry.getUnitPostedTo().getId())){
			%>
			<option value="<%=masUnit.getId() %>" selected="selected"><%=masUnit.getUnitName()%></option>			
	<%}else{%>
           <option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName()%></option>
	<%}}}else{
	for(MasUnit masUnit : unitList){
		if(masUnit!=null){
	%>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName()%></option>
    
<%}}} %>    
</select> <IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer;" onClick="javascript:openPopupWindowForUnit();"
	title="Click here to Search Posted From"></div>


<label><span>*</span>Authority</label>
<%if(postedOutEntry !=null && postedOutEntry.getAuthority()!=null){ %> 
<input type="text" maxlength="50" name="<%=AUTHORITY %>" value="<%=postedOutEntry.getAuthority()%>" validate="Authority,string,yes" maxlength="75" tabindex="1" />
<%}else{ %>
<input type="text" maxlength="50" name="<%=AUTHORITY %>" value="" validate="Authority,string,yes" maxlength="75" tabindex="1" />
<%}%>

<div class="Clear"></div>

<label> <span>*</span>Date Of Posting Out</label>
<%if(postedOutEntry !=null && postedOutEntry.getDate()!=null){ %> 
<input type="text" class="calDate" id="date" name="<%=DATE %>" value="<%=HMSUtil.changeDateToddMMyyyy(postedOutEntry.getDate()) %>" onchange="sorsdate();" onblur="sorsdate();"
	validate="Date of Posting ,string,yes" readonly="readonly" MAXLENGTH="30" tabindex="1" />
<%}else{ %>
<input type="text" class="calDate" id="date" name="<%=DATE %>" value="" onchange="sorsdate();" onblur="sorsdate();"
	validate="Date of Posting ,string,yes" readonly="readonly" MAXLENGTH="30" tabindex="1" /> 
<%} %>		 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,yes"
	onClick="setdate('<%=date %>',document.postedOutEntry.<%=DATE%>,event)" />

<label> <span>*</span>SORS/SOS</label>
<%if(postedOutEntry !=null && postedOutEntry.getSors()!=null){ %>  
<input type="text" class="calDate" id="sors" name="<%=SORS %>" value="<%=HMSUtil.changeDateToddMMyyyy(postedOutEntry.getDate()) %>" readonly="readonly" MAXLENGTH="30" tabindex="1" />
<%}else{ %>
<input type="text" class="calDate" id="sors" name="<%=SORS %>" value="" readonly="readonly" MAXLENGTH="30" tabindex="1" />
<%} %> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a SORS,date,yes"
	onClick="setdate('<%=date %>',document.postedOutEntry.<%=SORS%>,event)" />

<div class="Clear"></div>

<label><span>*</span>POR SL NO.</label>
<%if(postedOutEntry !=null && postedOutEntry.getPorSlno()!=null){ %>   
<input type="text" maxlength="20" name="<%=POR_SLNO %>" value="<%=postedOutEntry.getPorSlno() %>" validate="POR SLNO,string,yes" tabindex="1" />
<%}else{ %>
<input type="text" maxlength="20" name="<%=POR_SLNO %>" value="" validate="POR SLNO,string,yes" tabindex="1" />
<%} %>

<div class="Clear"></div>

<label>Remarks</label>
<%if(postedOutEntry !=null && postedOutEntry.getRemarks()!=null){ %> 
<textarea rows="5" cols="100" name="<%=REMARKS%>" value="" tabindex="1"><%=postedOutEntry.getRemarks()%></textarea>
<%}else{ %>
<textarea rows="5" cols="100" name="<%=REMARKS%>" value="" tabindex="1"></textarea>
<%} %>

<div class="Clear"></div>

<label>For Officers:</label>

<div class="Clear"></div>

<label>Appraisal report/NIR last raised on:</label>
<%if(postedOutEntry !=null && postedOutEntry.getAppraisalReport()!=null){ %> 
<input type="text" class="calDate" id="fromDateId" name="<%=APPRAISAL_REPORT %>" value="<%=date %>" MAXLENGTH="30" tabindex="1" />
<%}else{ %>
<input type="text" class="calDate" id="fromDateId" name="<%=APPRAISAL_REPORT %>" value="<%=date %>" MAXLENGTH="30" tabindex="1" />
<%} %>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="setdate('<%=date %>',document.postedOutEntry.<%=APPRAISAL_REPORT%>,event)" />
<label style="width:150px;">Clearence Completed :</label>
<input type="checkbox" name="clearenceCompleted" id="clearenceCompleted" value="<%=dateCal+"/"+month+"/"+year%>"> 

<!-- End of posted out for clearence -->
	
<%}else{ %>
<h3>Your Discipline Is Pending</h3>
<%}}%>
<div class="clear"></div>
<div class="bottom"><input type="button" id="add" name="sub"
	class="button" value="Submit"
	onclick="submitForm('postedOutEntry','hrOrderly?method=addPostedOutEntry');"
	align="right" /> <input class=button id="reset" accessKey=r
	style="display: block" onclick=resetCheck(); type=reset value=Reset
	name=Reset /> <input name="Button" type="button" class="button"
	value="Close" onClick="javascript:history.back();" /> <input
	name="Button" type="button" class="button" value="Search"
	onclick="window.open('hrOrderly?method=searchPostedOutEntry');" />
<div class="Clear"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input type="hidden"
	name="id" value="<%=id %>" /></div>
<div class="Clear"></div>
</div>
</div>
<script type="text/javascript">
<%if(postedOutEntry !=null && postedOutEntry.getPostedType().equalsIgnoreCase("transfer")){%>
document.getElementById('abc').style.display = "block";
<%}%>
function makeChoice()
{


if(document.postedOutEntry.<%=POSTED_TYPE %>.value ==  'r')
{
 document.postedOutEntry.<%=UNIT_POSTED_TO%>.disabled=true;
}
else if(document.postedOutEntry.<%=POSTED_TYPE %>.value ==  't')
{
document.postedOutEntry.<%=UNIT_POSTED_TO%>.disabled=false;
}
}

function handleRem() {
  if(document.getElementById('postedType').value == "transfer")
  {
  document.getElementById('abc').style.display = "block";
  }
  else{
  document.getElementById('abc').style.display = "none";
  }
  }
 
  function openPopupWindowForUnit()
	{
	 var url="/hms/hms/adt?method=showUnitSearchJsp";
	 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	}
	
function jsSetUnitData(unitId,unitAddress)
	{
	 for(var i=0;i<document.getElementById("<%=UNIT_POSTED_TO%>").length;i++)
	 {
		 if (document.getElementById("<%=UNIT_POSTED_TO%>").options[i].value==unitId)
		 {
		 	document.getElementById("<%=UNIT_POSTED_TO%>").selectedIndex = i;
		 }
	 }
	
	}

</script>
</body>
</form>

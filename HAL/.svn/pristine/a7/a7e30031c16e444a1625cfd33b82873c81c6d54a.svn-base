<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.HrLeaveTypeMaster"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PostedOutEntry"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<form name="updatePostedOut" method="post" action=""><script
	type="text/javascript">

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
</script> <%
Map<String,Object> map = new HashMap<String,Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
String userName = "";
if(session.getAttribute("userName") != null)
{
	userName = (String)session.getAttribute("userName");
}
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
	}

List<HrLeaveTypeMaster> leaveTypeList=new ArrayList<HrLeaveTypeMaster>();
List<MasUnit> unitList=new ArrayList<MasUnit>();
List<MasState> stateList=new ArrayList<MasState>();
List<PostedOutEntry> postedOutList = new ArrayList<PostedOutEntry>();

if(map.get("leaveTypeList") != null){
	leaveTypeList = (List<HrLeaveTypeMaster>)map.get("leaveTypeList");
	}
if(map.get("unitList") != null){
	unitList = (List<MasUnit>)map.get("unitList");
	}
if(map.get("stateList") != null){
	stateList = (List<MasState>)map.get("stateList");
	}
if(map.get("postedOutList") != null){
	postedOutList = (List<PostedOutEntry>)map.get("postedOutList");
	}

String entryNo ="";
if(map.get("entryNo") != null){
	entryNo = (String)map.get("entryNo");
	}

String sors = "";
if(postedOutList.get(0).getSors() != null)
{
	sors = HMSUtil.convertDateToStringWithoutTime(postedOutList.get(0).getSors());
}
else
{
	sors = "";
}

String postedDate = "";
if(postedOutList.get(0).getDate() != null)
{
	postedDate = HMSUtil.convertDateToStringWithoutTime(postedOutList.get(0).getDate());
}
else
{
	postedDate = "";
}

String appraisal = "";
if(postedOutList.get(0).getAppraisalReport() != null)
{
	appraisal = HMSUtil.convertDateToStringWithoutTime(postedOutList.get(0).getAppraisalReport());
}
else
{
	appraisal = "";
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

<h2><%=message %></h2>

<%} %>
<div class="Clear"></div>

<div id="contentHolder">
<h6>Posted Out Entry
<h6>
<div class="Clear"></div>
<div class="blockFrame"><label><span>*</span>Posted Type</label> <select
	id="postedType" name="<%=POSTED_TYPE %>"
	validate="Posted Type,string,yes" onchange="handleRem()" tabindex="1">

	<%for(PostedOutEntry posted : postedOutList){%>
	<%if(postedOutList.get(0).getPostedType()==posted.getPostedType()){%>


	<option value="transfer" selected="selected">Transfer</option>
	<option value="retirement">Retirement</option>
	<%}else{ %>

	<option value="transfer">Transfer</option>
	<option value="retirement" selected="selected">Retirement</option>
	<%} %>
	<%} %>
</select> <label><span>*</span>Entry No.</label> <label class="value"><%=postedOutList.get(0).getEntryNo() %></label>
<input type=hidden name="abc"
	value="<%=postedOutList.get(0).getEmployee().getRank().getId() %>" />
<input type=hidden name="empId"
	value="<%=postedOutList.get(0).getEmployee().getId() %>" />
<div class="Clear"></div>


<div id="abc" style="display: none;"><label>Unit Posted To</label>
<select name="<%= UNIT_POSTED_TO %>" tabindex=1>
	<option value=""></option>
	<%
		for (MasUnit masUnit : unitList) {
			if(postedOutList.get(0).getUnitPostedTo()!=null){
				if(true){
			if(postedOutList.get(0).getUnitPostedTo().getId() == masUnit.getId()){		

	%>

	<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>

	<%}else %>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>

	<%
}}}

	%>

</select></div>


<label><span>*</span>Authority</label> <%if(postedOutList.get(0).getAuthority() != null){ %>
<input type="text" maxlength="50" name="<%=AUTHORITY %>"
	value="<%=postedOutList.get(0).getAuthority() %>"
	validate="Authority,string,yes" /> <%}else{ %> <input type="text"
	maxlength="50" name="<%=AUTHORITY %>" value=""
	validate="Authority,string,yes" /> <%} %>
<div class="Clear"></div>

<label> <span>*</span>Dated</label> <input type="text" class="calDate"
	id="date" name="<%=DATE %>" value="<%=postedDate%>" readonly="readonly"
	MAXLENGTH="30" tabindex="1" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date,date,yes"
	onClick="setdate('<%=date %>',document.updatePostedOut.<%=DATE%>,event)" />

<label> <span>*</span>SORS/SOS</label> <input type="text"
	class="calDate" id="sors" name="<%=SORS %>" value="<%=sors%>"
	readonly="readonly" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a SORS,date,yes"
	onClick="setdate('<%=date %>',document.updatePostedOut.<%=SORS%>,event)" />

<div class="Clear"></div>

<label><span>*</span>POR SL NO.</label> <%if(postedOutList.get(0).getPorSlno() != null){ %>
<input type="text" maxlength="20" name="<%=POR_SLNO %>"
	value="<%=postedOutList.get(0).getPorSlno() %>"
	validate="POR SLNO,string,yes" /> <%}else{ %> <input type="text"
	maxlength="20" name="<%=POR_SLNO %>" value=""
	validate="POR SLNO,string,yes" /> <%} %>
<div class="Clear"></div>

<label>Remarks</label> <%if(postedOutList.get(0).getRemarks() != null){ %>
<input type="text" maxlength="50" name="<%=REMARKS%>"
	value="<%=postedOutList.get(0).getRemarks() %>" /> <%}else{ %> <input
	type="text" maxlength="50" name="<%=REMARKS%>" value="" /> <%} %>

<div class="Clear"></div>

<label>For Officers:</label>

<div class="Clear"></div>

<label>Appraisal report/NIR last raised on:</label> <input type="text"
	class="calDate" id="fromDateId" name="<%=APPRAISAL_REPORT %>"
	value="<%=appraisal%>" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	onClick="setdate('<%=date %>',document.updatePostedOut.<%=APPRAISAL_REPORT%>,event)" />

<div class="clear"></div>
<div class="bottom"><input type="button" class="button"
	value="Update"
	onclick="submitForm('updatePostedOut','hrOrderly?method=editPostedOutUpdate');"
	align="right" /> <input class=button id=reset accessKey=r
	onclick=resetCheck(); type=reset value=Reset name=Reset> <input
	class=button id=reset accessKey=r type=reset
	value=PrintClearanceCertificate
	onclick="submitForm('updatePostedOut','hrOrderly?method=printClearanceCertificate');">
<input name="Button" type="button" class="button" value="Close"
	onClick="javascript:history.back();" /> <label>Changed By</label> <label
	class="value"><%=userName%></label> <label>Changed Date</label> <label
	class="value"><%=date%></label> <label>Changed Time</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input type="hidden"
	name="<%=REG_TYPE %>" value="a" /> <input type="hidden" name="id"
	value="<%=id %>" /></div>
<div class="Clear"></div>
</div>

<script type="text/javascript">


function handleRem() {
  if(document.getElementById('postedType').value == "transfer")
  {
  document.getElementById('abc').style.display = "block";
  }
  else{
  document.getElementById('abc').style.display = "none";
  }
  }

</script>
</form>

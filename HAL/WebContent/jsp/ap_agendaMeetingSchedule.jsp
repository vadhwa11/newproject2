<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : agendaMeetingSehdule.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 11.05.2009    Name: Vineet Kumar
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasAgendaPointForWorkServices"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.ApAgendaRequest"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>

<script type="text/javascript" language="JavaScript">
function checkForm(form)
{
if (document.form.searchField1.value == "") {
alert( "Please enter data" );
document.form.T1.focus();
return false;
}
}
</script>
<script type="text/javascript">
    function removeRow()
	{
	  var tbl = document.getElementById('amcDetailId');
	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	  else 
	  alert("There should be at least one row filled");
	  
	}
</script>
<%
	Calendar calendar = Calendar.getInstance();
	String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
	String dateCal = String.valueOf(calendar.get(Calendar.DATE));
	int year = calendar.get(calendar.YEAR);
	if (month.length() < 2) {
		month = "0" + month;
	}
	if (dateCal.length() < 2) {
		dateCal = "0" + dateCal;
	}

	Map map = new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
	if (map.get("masEmployee") != null) {
		masEmployeeList = (List) map.get("masEmployee");
	}

	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if (map.get("departmentList") != null) {
		departmentList = (List) map.get("departmentList");
	}
	List<ApAgendaRequest> agendaRequestList = new ArrayList<ApAgendaRequest>();
	if (map.get("agendaRequestList") != null) {
		agendaRequestList = (List) map.get("agendaRequestList");
	}
	String message = "";
	if (map.get("message") != null) {
		message = (String) map.get("message");

	}
	
	String meetingNo = "";
	if (map.get("meetingNo") != null) {
		meetingNo = (String) map.get("meetingNo");

	}
	if (!message.equalsIgnoreCase("")) {
%>
<script language="javascript" type="text/javascript">
			serverdate = '<%=dateCal+"/"+month+"/"+year%>'			
		</script>

<h2><%=message%></h2>
<%
	}
%>
<div class="Clear"></div>

<div id="contentHolder">
<h6>Agenda Points Meeting Scheduling</h6>
<div class="Clear"></div>
<form name="agendaPointsSearch1" action="" method="post">
<div class="blockFrame"><label>Meeting No.</label> <Label
	class="value"><%=meetingNo %></Label> <input type="hidden"
	name="<%=MEETING_NO%>" value="<%=meetingNo%>" /> <label>Proposed
Date</label> <input id="searchField1" type="text" name="<%=PROPOSED_DATE %>"
	value="<%=currentDate%>" class="calDate" tabindex=1
	validate="From Date,date,no" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',document.agendaPointsSearch1.<%=PROPOSED_DATE%>,event)" ; />


<Label><span>*</span> Proposed From Time</Label> <input tabindex="1"
	type="text" maxlength="5" name="<%=PROPOSED_TIME_FROM %>" value=""
	validate="Agenda Time,string,yes"
	onKeyUp="mask(this.value,this,'2',':');"
	onBlur="checkTimeAgendaPoints('updateAgendaPoints','agendaTime');">
<div class="Clear"></div>
<Label><span>*</span> Proposed To Time</Label> <input tabindex="1"
	type="text" maxlength="5" name="<%=PROPOSED_TIME_TO%>" value=""
	validate="Agenda Time,string,yes"
	onKeyUp="mask(this.value,this,'2',':');"
	onBlur="checkTimeAgendaPoints('updateAgendaPoints','agendaTime');">



<label>Venue</label> <input type="text" name="<%= AGENDA_VENUE %>"
	value="" MAXLENGTH="300" tabindex=1 /> <label>Meeting Title</label> <input
	type="text" name="<%= MEETING_TITLE %>" value="" MAXLENGTH="100"
	tabindex=1 />
<div class="Clear"></div>
<label><span>*</span>Members</label> <select
	style="width: 200px; height: 200px" name="<%= EMPLOYEE_ID %>"
	id="dept_id" multiple class="list" validate="Employee Name,string,yes"
	tabindex=1>

	<option value="0">Select</option>
	<%
		if (masEmployeeList != null) {
			for (MasEmployee masEmployee : masEmployeeList) {
	%>

	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()%>
	<%=masEmployee.getMiddleName()%> <%=masEmployee.getLastName()%></option>

	<%
		}
		}
	%>
</select> <label><span>*</span>Chaired By</label> <select
	name="<%= CHAIRED_BY %>" validate="Chaired By,string,yes" tabindex=1>

	<option value="0">Select</option>
	<%
		if (masEmployeeList != null) {
			for (MasEmployee masEmployee : masEmployeeList) {
	%>

	<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName()%>
	<%=masEmployee.getMiddleName()%> <%=masEmployee.getLastName()%></option>

	<%
		}
		}
	%>
</select>
<div class="Clear"></div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>

<div class="Clear"></div>
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" />
<div class="Clear"></div>
<div
	style="overflow: scroll; overflow-x: scroll; width: auto; height: auto; BORDER: #202020 1px solid;">
<div class="tableHolderAuto">
<table width="100%" border="0" id="amcDetailId" cellspacing="0"
	cellpadding="0">
	<thead>
		<tr>
			<th scope="col" style="display: none">Sr. No.</th>
			<th scope="col">Department</th>
			<th scope="col">Agenda Points</th>
			<th scope="col" style="display: none">Employee Name</th>

			<th scope="col">Select</th>
			<th scope="col">Reject</th>
			<th scope="col">Description</th>
		</tr>
	</thead>
	<tbody>
		<%
  
 
  	int inc=1;
  	for ( ;inc<=agendaRequestList.size(); inc++) {
  if(agendaRequestList.get(inc-1).getStatus().equalsIgnoreCase("o")){	
  		System.out.println("incggggggggggggg   "+inc+"agendaRequestList.size()        "+agendaRequestList.size());
  %>
		<tr>
			<td width="5%" style="display: none"><input type="text" size="2"
				value="<%=inc%>" name="<%=SR_NO%>" readonly="readonly" tabindex="1" />
			<input type="hidden" size="30" id="agendaRequestId<%=inc%>"
				value="<%=agendaRequestList.get(inc-1).getId()%>"
				name="<%=AGENDA_POINT_ID%>" tabindex="1" maxlength="30" /> <input
				type="hidden" size="30" value="" id="selectedId<%=inc%>"
				name="selectedId" tabindex="1" maxlength="30" /> <input
				type="hidden" size="30" value="" id="rejectedId<%=inc%>"
				name="rejectedId" tabindex="1" maxlength="30" /></td>
			<td width="10%"><input type="text" size="30"
				value="<%=agendaRequestList.get(inc-1).getDepartmentId().getDepartmentName()%>"
				name="department" tabindex="1" maxlength="30" /></td>

			<td width="10%"><input type="text" size="30"
				value="<%=agendaRequestList.get(inc-1).getAgendaPoint()%>"
				name="<%=AGENDA_POINTS%>" tabindex="1" maxlength="30" /></td>

			<td width="10%" style="display: none"><input type="text"
				size="30"
				value="<%=agendaRequestList.get(inc-1).getEmpId().getFirstName()%> <%=agendaRequestList.get(inc-1).getEmpId().getMiddleName()%> <%=agendaRequestList.get(inc-1).getEmpId().getLastName()%>"
				name="<%=EMPLOYEE_CODE %>" tabindex="1" maxlength="30" /></td>


			<td width="10%"><input type="checkbox"
				name="<%=SELECT_REQUEST%>" id="selectRequest<%=inc%>"
				onclick="deSelectRadio('select',<%=inc %>)" tabindex="1" /></td>
			<td width="10%"><input type="checkbox" name="rejectRequest"
				id="rejectRequest<%=inc%>"
				onclick="deSelectRadio('reject',<%=inc %>)" tabindex="1" /></td>
			<td width="30%">
			<%if(agendaRequestList.get(inc-1).getAgendaDetail()!= null){ %> <textarea
				readonly="readonly" style="width: 250px; height: 50px;" type="text"
				size="30" value="" name="<%=AGENDA_POINTS_DETAILS %>" tabindex="1"
				maxlength="30"><%=agendaRequestList.get(inc-1).getAgendaDetail()%> </textarea>
			<%}else{ %> <textarea readonly="readonly" type="text" size="30"
				value=" " name="<%=AGENDA_POINTS_DETAILS %>" tabindex="1"
				maxlength="30"> </textarea> <%} %>
			</td>
		</tr>
		<%
   	}
  	}
   %>
	</tbody>

</table>
<input type="hidden" name="rows" id="rr" value="1" /></div>
<script type="text/javascript">
function deSelectRadio(con,rowVal)
{
if(con == "select"){
//alert("inside select");
if(document.getElementById('selectRequest'+rowVal).checked){
//alert('con:::::'+con+":::::::::"+rowVal)
document.getElementById('rejectRequest'+rowVal).checked = false;
document.getElementById('rejectRequest'+rowVal).value="off";
document.getElementById('selectRequest'+rowVal).value="on";
document.getElementById('selectedId'+rowVal).value=document.getElementById('agendaRequestId'+rowVal).value;
document.getElementById('rejectedId'+rowVal).value="";
//alert("end select");
}
else{
document.getElementById('selectedId'+rowVal).value="";
}
}

if(con == "reject"){
//alert("inside select");
if(document.getElementById('rejectRequest'+rowVal).checked){
//alert('con:::::'+con+":::::::::"+rowVal)
document.getElementById('selectRequest'+rowVal).checked = false;
document.getElementById('selectRequest'+rowVal).value="off";
document.getElementById('rejectRequest'+rowVal).value="on";
document.getElementById('rejectedId'+rowVal).value=document.getElementById('agendaRequestId'+rowVal).value;
document.getElementById('selectedId'+rowVal).value="";
//alert("end select");
}
else
{
document.getElementById('rejectedId'+rowVal).value="";
}
}
}
</script></div>
<!--Block Two Starts--> <!--table-->
<div class="division"></div>
<div class="bottom"><input name="Button" type="button"
	class="button" value="Submit" tabindex="1"
	onClick="submitForm('agendaPointsSearch1','agenda?method=addAgendaMeetingSchedule');" />
<input name="Button" type="button" class="button" value="Reset"
	tabindex="1" onclick=resetCheck(); /> <input name="Button"
	type="button" class="button" value="Search" tabindex="1"
	onClick="submitForMedicalBoard('agendaPointsRequest');" />
<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=currentTime%></label> <input type="hidden"
	value="1" name="hiddenValue" id="hiddenValue" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /></div>

</form>

</div>

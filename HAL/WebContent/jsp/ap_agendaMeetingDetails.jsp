
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>

<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.masters.business.MasComplaintRegister"%>
<%@ page import="jkt.hms.masters.business.MasComplaintsType"%>

<%@page import="jkt.hms.masters.business.MasSmq"%>
<%@page import="jkt.hms.masters.business.ApMeetingSchedule"%>
<%@page import="jkt.hms.masters.business.ApMeetingAgenda"%>
<%@page import="jkt.hms.masters.business.ApMeetingEmployee"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>



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
<script language="javascript" type="text/javascript">
			serverdate = '<%=dateCal+"/"+month+"/"+year%>'			
		</script>

<script>
var poolSelected=false;
function chkLength(field,maxLimit)
	{
	if(field.value.length > maxLimit)
	{
	 alert('Maximum Limit is '+maxLimit+' characters.');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}
function isAlphabet(field){
	var alphaExp = /^[a-zA-Z]+$/;
	if(field.value.match(alphaExp)){
		return true;
	}else{
		alert('Please Enter Only Letters ');
		elem.focus();
		return false;
	}
}
  function isNumber1(field) { 
       var i=14;
        var re = /^[0-9-'.'-',']*$/; 
        if (!re.test(field.value)) { 
            alert('please enter only numeric data'); 
            field.value = field.value.replace(/[^0-9-'.'-',']/g,""); 
       
        } 
     var aa=field.value[1];
    if(field.value.indexOf(".")<15)
    {
 return true;
 }
 else
 {
     alert('please enter less than 14 digit before decimal point'+aa); 
		 field.value=''; 
 
	}




}

function checkTime(formName,timeFieldName){
  
 objTime = eval('document.'+formName+'.'+timeFieldName);
   var chtime=objTime.value;
 if(chtime.trim()!=""){ 
    
 try{
   var indx = chtime.indexOf(':');
   
   if (indx != -1) {
   var pairs2 = chtime.substring(0,chtime.length).split(':');
   }
      
   if (pairs2.length!=2) { 
    alert("Invalid Time Format.It should be HH:MM")
    objTime.value=""
   return false;
   }
   
   if (pairs2[0].length != 2 || pairs2[1].length != 2 ) {
      alert("Invalid Time Format.It should be HH:MM")
      objTime.value=""
      return false;
    }
   
      val2=eval(pairs2[0]);
     
        if (val2<0 || val2>23) {
         alert("Hours should 00-23")
         objTime.value=""
         return false;}
         
         val3=eval(pairs2[1]);
     
         if (val3<0 || val3>59) {
         alert("Min should 00-59")
         objTime.value=""
         return false;}
       
     
 }catch(e2)
 { alert("Invalid Time")
 objTime.value=""
  return false;
 }
  }
return true;
}

function getRecords(formName)
{
var deptId=document.getElementById('dept').value
if(deptId=="0"){
alert()
return false;
}
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/complaint?method=getRecordsForWorkCompletion&deptId="+deptId+"";
  obj.submit();
}

function getComplaint(formName)
{
var complaintType = document.getElementById('complaint').value
if(complaintType=="0"){
alert()
return false;
}
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/complaint?method=getRecordsForWorkCompletion&complaintType="+complaintType+"";
  obj.submit();
}

function checkManadatory()
{
var completionDate=document.getElementById('CompletionDate').value;
var pdc =document.getElementById('pdc').value;
if(completionDate =="" && pdc=="" )
{
alert("Please enter either Completion date or PDC");
return false;
}
else
{
return true;
}
}
			</script>


<%
	 int detailCounter=1;
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
			
		}
		
		Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
	

		List<ApMeetingSchedule> apAgendaMeetingList = new ArrayList<ApMeetingSchedule>();
		if(map.get("apAgendameetingList") != null)
		{
			apAgendaMeetingList = (ArrayList) map.get("apAgendameetingList");			
		}			
		List<ApMeetingAgenda> selectedAgendaPointsOfMeetingList = new ArrayList<ApMeetingAgenda>();
		if (map.get("agendaPointsOfMeetingList") != null) {
			selectedAgendaPointsOfMeetingList = (List) map.get("agendaPointsOfMeetingList");
		}
		List<ApMeetingEmployee> meetingEmployeeList = new ArrayList<ApMeetingEmployee>();
		if (map.get("meetingEmployeeList") != null) {
			meetingEmployeeList = (List<ApMeetingEmployee>) map.get("meetingEmployeeList");
			
		}		
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();	
	
		if(map.get("masEmployee") != null)
		{
			masEmployeeList = (List)map.get("masEmployee");
		}
		String meetingNo = "";
		if (map.get("meetingNo") != null) {
			meetingNo = (String) map.get("meetingNo");

		}	
	
		
	
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
			String message = "";		
	%>
<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>
<div id="contentHolder">
<h6>Agenda Points Meeting Details</h6>
<div class="Clear"></div>
<form name="agendaPointsSearch1" action="" method="post">
<div class="blockFrame"><label>Meeting No.</label> <Label
	class="value"><%=apAgendaMeetingList.get(0).getMeetingNo() %></Label> <input
	type="hidden" name="<%=apAgendaMeetingList.get(0).getMeetingNo()%>"
	value="<%=meetingNo%>" /> <label>Meeting Title</label> <input
	type="text" name="<%= MEETING_TITLE %>"
	value="<%= apAgendaMeetingList.get(0).getMeetingTitle()%>"
	MAXLENGTH="100" tabindex=1 /> <label>Venue</label> <textarea
	name="<%=AGENDA_VENUE%>" tabindex="1" onkeyup="chkLength(this,500);"><%= apAgendaMeetingList.get(0).getVenue()%></textarea>

<div class="Clear"></div>
<label>Proposed Date</label> <input id="searchField1" type="text"
	name="<%=PROPOSED_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(apAgendaMeetingList.get(0).getProposedDate())%>"
	class="calDate" tabindex=1 validate="From Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.agendaPointsSearch1.<%=PROPOSED_DATE%>,event)" ; />


<Label><span>*</span> Proposed From Time</Label> <input tabindex="1"
	type="text" maxlength="5" name="<%=PROPOSED_TIME_FROM %>"
	value="<%= apAgendaMeetingList.get(0).getProposedTimeFrom()%>"
	validate="Agenda Time,string,yes"
	onKeyUp="mask(this.value,this,'2',':');"
	onBlur="checkTime('agendaPointsSearch1','<%=PROPOSED_TIME_FROM %>');">

<Label><span>*</span> Proposed To Time</Label> <input tabindex="1"
	type="text" maxlength="5" name="<%=PROPOSED_TIME_TO%>"
	value="<%= apAgendaMeetingList.get(0).getProposedTimeTo()%>"
	validate="Agenda Time,string,yes"
	onKeyUp="mask(this.value,this,'2',':');"
	onBlur="checkTime('agendaPointsSearch1','<%=PROPOSED_TIME_TO%>');">
<div class="Clear"></div>
<label><span>*</span>Actual Date</label> <input id="searchField1"
	type="text" name="<%=MEETING_ACTAUL_DATE %>" value="<%=date%>"
	class="calDate" tabindex=1 validate="Actual Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.agendaPointsSearch1.<%=MEETING_ACTAUL_DATE%>,event)" ; />


<Label><span>*</span> Actual From Time</Label> 
<% if(apAgendaMeetingList!= null && apAgendaMeetingList.size()>0 && apAgendaMeetingList.get(0).getActualTimeFrom()!=null){%>
<input tabindex="1" type="text" maxlength="5"
	name="<%=MEETING_ACTAUL_TIME_FROM %>"
	value="<%=apAgendaMeetingList.get(0).getActualTimeFrom()%>"
	validate="Actual From Time,string,yes"
	onKeyUp="mask(this.value,this,'2',':');"
	onBlur="checkTime('agendaPointsSearch1','agendaTime');" /> <%}else{ %>
<input tabindex="1" type="text" maxlength="5"
	name="<%=MEETING_ACTAUL_TIME_FROM %>" value="<%=apAgendaMeetingList.get(0).getProposedTimeFrom()%>"
	validate="Actual From Time,string,yes"
	onKeyUp="mask(this.value,this,'2',':');"
	onBlur="checkTime('agendaPointsSearch1','agendaTime');">
<%} %> <Label><span>*</span> Actual To Time</Label> <% if(apAgendaMeetingList!= null && apAgendaMeetingList.size()>0 && apAgendaMeetingList.get(0).getActualTimeTo()!=null){%>

<input tabindex="1" type="text" maxlength="5"
	name="<%=MEETING_ACTAUL_TIME_TO%>"
	value="<%=apAgendaMeetingList.get(0).getActualTimeTo()%>"
	validate="Actual To Time,string,yes"
	onKeyUp="mask(this.value,this,'2',':');"
	onBlur="checkTimeAgendaPoints('updateAgendaPoints','agendaTime');">
<%}else{ %> <input tabindex="1" type="text" maxlength="5"
	name="<%=MEETING_ACTAUL_TIME_TO%>" value="<%= apAgendaMeetingList.get(0).getProposedTimeTo()%>"
	validate="Actual To Time,string,yes"
	onKeyUp="mask(this.value,this,'2',':');"
	onBlur="checkTimeAgendaPoints('updateAgendaPoints','agendaTime');">
<%} %>
<div class="Clear"></div>
<label><span>*</span>Chaired By</label> <select name="<%= CHAIRED_BY %>"
	validate="Chaired By,string,yes" tabindex=1>
	<option value="<%=apAgendaMeetingList.get(0).getChairedBy().getId() %>"><%=apAgendaMeetingList.get(0).getChairedBy().getFirstName() %><%=apAgendaMeetingList.get(0).getChairedBy().getLastName() %></option>
	<option value="0">Select</option>
	<%
		if (masEmployeeList != null) {
			for (MasEmployee masEmployee : masEmployeeList) {
	%>

	<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName()%>
	<%=masEmployee.getLastName()%></option>

	<%
		}
		}
	%>
</select> <label><span>*</span>Members Attendees</label> <select
	style="width: 150px; height: 100px" name="<%= EMPLOYEE_ID %>"
	id="dept_id" multiple class="list" tabindex=1>

	<option value="0">Select</option>
	<%
		if (meetingEmployeeList != null) {
			for (ApMeetingEmployee masEmployee : meetingEmployeeList) {
	%>

	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getEmp().getFirstName()%>
	<%=masEmployee.getEmp().getLastName()%></option>

	<%
		}
		}
	%>
</select> <label><span>*</span>Other Attendees Employees</label> <select
	style="width: 150px; height: 100px" name="<%= EMPLOYEE_ID2 %>"
	id="dept_id" multiple class="list" tabindex=1>

	<option value="0">Select</option>
	<%
	List<MasEmployee> masEmployeeList1= new ArrayList<MasEmployee>();	
	if (masEmployeeList != null){
	for (MasEmployee masEmployee : masEmployeeList)
	{
		masEmployeeList1.add(masEmployee);
	}
	}
		if (masEmployeeList != null) {
			for (MasEmployee masEmployee : masEmployeeList) {
				if (meetingEmployeeList != null && meetingEmployeeList.size()!=0){
				for(ApMeetingEmployee masEmployee1 : meetingEmployeeList){
					if(masEmployee1.getEmp().getId()==masEmployee.getId()){
						masEmployeeList1.remove(masEmployee);
					}
					%>

	<%}}
				}}
			if (masEmployeeList1 != null) {
			for (MasEmployee masEmployee2 : masEmployeeList1) {%>
	<option value="<%=masEmployee2.getId()%>"><%=masEmployee2.getFirstName()%><%=masEmployee2.getLastName()%></option>


	<%
			}
		}
	%>
</select>
<div class="Clear"></div>
<label>Other Attendees</label> <% if(apAgendaMeetingList!= null && apAgendaMeetingList.size()>0 && apAgendaMeetingList.get(0).getOtherAttendees()!=null){%>

<textarea name="<%=MOM__ATTENDEES%>" tabindex="1"
	onkeyup="chkLength(this,500);"><%=apAgendaMeetingList.get(0).getOtherAttendees() %></textarea>
<%}else{ %> <textarea name="<%=MOM__ATTENDEES%>" tabindex="1"
	onkeyup="chkLength(this,500);"></textarea> <%} %> 
	<!-- <label><span>*</span>Members Absentees</label> <select style="width:150px;height:100px"
	name="<%= EMPLOYEE_ID3 %>" id="dept_id" multiple class="list" tabindex=1>

	<option value="0">Select</option>
	<%
		if (meetingEmployeeList != null) {
			for (ApMeetingEmployee masEmployee : meetingEmployeeList) {
	%>

	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getEmp().getFirstName()%>
	<%=masEmployee.getEmp().getLastName()%></option>

	<%
		}
		}
	%>
</select>
 -->

<div class="Clear"></div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>

<div class="Clear"></div>
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" />
<div class="Clear"></div>
<%if(selectedAgendaPointsOfMeetingList!=null || selectedAgendaPointsOfMeetingList.size()!=0){ %>
<div
	style="overflow: scroll; overflow-x: scroll; width: auto; height: auto; BORDER: #202020 1px solid;">
<div class="tableHolderAuto">
<table width="100%" border="0" id="amcDetailId" cellspacing="0"
	cellpadding="0">
	<thead>
		<tr>
			<th scope="col" style="display: none">Sr. No.</th>
			<th scope="col" title="Department Name" >Department</th>
			<th scope="col" title="Agenda Points">Agenda Point</th>
			<th scope="col" title="Agenda Points Descriptions">Agenda Description</th>
			<th scope="col" title="Decision in meeting">Decision</th>
			<th scope="col" title="Agenda Points Information">Info</th>
			<th scope="col" title="Action taken in meeting">Action</th>
		</tr>
	</thead>
	<tbody>
		<%
  	int inc=1;
  for ( ;inc<=selectedAgendaPointsOfMeetingList.size(); inc++) {

  	//	System.out.println("incggggggggggggg   "+inc+"selectedAgendaPointsOfMeetingList.size()        "+selectedAgendaPointsOfMeetingList.size());
  %>
		<tr>
			<td width="5%" style="display: none">
			<input type="text" size="2" value="<%=inc%>" name="<%=SR_NO%>" readonly="readonly" tabindex="1" />
			<input type="hidden" size="30" id="agendaRequestId<%=inc%>" value="<%=selectedAgendaPointsOfMeetingList.get(inc-1).getAgendaRequest().getId()%>" name="<%=AGENDA_POINT_ID%>" tabindex="1" maxlength="30" /> 
			<input type="hidden" size="30" value="" id="selectedId<%=inc%>" name="selectedId" tabindex="1" maxlength="30" /> 
			<input type="hidden" size="30" value="" id="rejectedId<%=inc%>" name="rejectedId" tabindex="1" maxlength="30" /></td> 
			<td width="10%"> 
				<input type="text" size="50" value="<%=selectedAgendaPointsOfMeetingList.get(inc-1).getAgendaRequest().getDepartmentId().getDepartmentName()%>" readonly="readonly" name="<%=DEPARTMENT_ID %>" tabindex="1" maxlength="30" />
			</td> 
			<td width="10%">
				<input type="text" size="30" value="<%=selectedAgendaPointsOfMeetingList.get(inc-1).getAgendaRequest().getAgendaPoint()%>" readonly="readonly" name="<%=AGENDA_POINTS%>" tabindex="1" maxlength="30" />
			</td>
			<td width="10%">
			<%if(selectedAgendaPointsOfMeetingList.get(inc-1).getAgendaRequest().getAgendaDetail()!=null && !selectedAgendaPointsOfMeetingList.get(inc-1).getAgendaRequest().getAgendaDetail().equalsIgnoreCase("")){ %>
				<input type="text" size="30" readonly="readonly" value="<%=selectedAgendaPointsOfMeetingList.get(inc-1).getAgendaRequest().getAgendaDetail()%>" name="<%=AGENDA_POINTS_DETAILS%>" tabindex="1" maxlength="30" /> 
			<%}else{ %>
				<input type="text" size="30" readonly="readonly" value="" name="<%=AGENDA_POINTS_DETAILS%>" tabindex="1" maxlength="30" /> 
			<%}%>
			</td>
			<td width="10%">
			<%if(selectedAgendaPointsOfMeetingList.get(inc-1).getAgendaRequest().getDecisionInMeeting()!=null && !selectedAgendaPointsOfMeetingList.get(inc-1).getAgendaRequest().getDecisionInMeeting().equalsIgnoreCase("")){ %>
				<textarea style="width: 250px; height: 50px;"  validate="Decision In Meeting,string,yes" type="text" size="30" value="" name="<%=DECISION_IN_MEETING %>" tabindex="1" maxlength="500"><%=selectedAgendaPointsOfMeetingList.get(inc-1).getAgendaRequest().getDecisionInMeeting()%></textarea> 
			<%}else{ %>
				<!--   <input validate="Decision In Meeting,string,yes" type="text" size="30" value="" name="<%=DECISION_IN_MEETING %>" tabindex="1" maxlength="500" /> --> 
				<textarea style="width: 250px; height: 50px;"  validate="Decision In Meeting,string,yes" type="text" size="30" value="" name="<%=DECISION_IN_MEETING %>" tabindex="1" maxlength="500"></textarea>
			<%} %>
			</td>

			<td width="10%">
			<%if(selectedAgendaPointsOfMeetingList.get(inc-1).getAgendaRequest().getActionBy()!=null && !selectedAgendaPointsOfMeetingList.get(inc-1).getAgendaRequest().getActionBy().equalsIgnoreCase("")){ %>
				<input type="text" size="30" value="<%=selectedAgendaPointsOfMeetingList.get(inc-1).getAgendaRequest().getActionTo()%>" name="<%=ACTIONED_TO %>" tabindex="1" maxlength="30" /> 
			<%}else{ %> 
				<input type="text" size="30" value="" name="<%=ACTIONED_TO %>" tabindex="1" maxlength="30" /> 
			<%}%>
			</td>

			<td width="30%">
			<%if(selectedAgendaPointsOfMeetingList.get(inc-1).getAgendaRequest().getActionBy()!=null && !selectedAgendaPointsOfMeetingList.get(inc-1).getAgendaRequest().getActionBy().equalsIgnoreCase("")){ %>
    			<textarea style="width: 250px; height: 50px;" type="text" size="30" value="" name="<%=ACTIONED_BY %>" tabindex="1" maxlength="30"><%=selectedAgendaPointsOfMeetingList.get(inc-1).getAgendaRequest().getActionBy()%> </textarea>
    		<%}else{ %> 
    		<textarea style="width: 250px; height: 50px;" type="text" size="30" value="" name="<%=ACTIONED_BY %>" tabindex="1" maxlength="30"> </textarea> 
    		<%}%>
			</td>
		</tr>
		<%   	
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
<%}else{ %> <label style="font: bold; font-size: 12;">No Agenda
Points selected for this meeting</label> <%} %> <!--Block Two Starts--> <!--table-->
<div class="division"></div>
<div class="bottom"><input name="Button" type="button"
	class="button" value="Update" tabindex="1"
	onClick="submitForm('agendaPointsSearch1','agenda?method=editMeetingDetails');" />
<input name="Button" type="button" class="button" value="Reset"
	tabindex="1" onclick=resetCheck(); />
<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>

<label class="value"><%=time%></label> <input type="hidden" value="1"
	name="hiddenValue" id="hiddenValue" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input type="hidden"
	name="<%=ID %>" value="<%=apAgendaMeetingList.get(0).getId()%>" /></div>

</form>

</div>


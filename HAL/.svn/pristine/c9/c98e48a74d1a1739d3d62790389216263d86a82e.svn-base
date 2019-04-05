<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientAppointment.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%@page import="jkt.hms.masters.business.PatientAppointment"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.Box"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>

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
<form name="patientAppointment" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = null;
		List<MasRelation> relationList = null;
		List<MasAdministrativeSex> sexList = null;
		List<Object[]> unitList = null;
		List<MasEmployee> employeeList = null;
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("rankList") != null){
			rankList= (List<MasRank>)map.get("rankList");
		}
		if(map.get("sexList") != null){
			sexList= (List<MasAdministrativeSex>)map.get("sexList");
		}
		if(map.get("relationList") != null){
			relationList= (List<MasRelation>)map.get("relationList");
		}
		if(map.get("unitList") != null){
			unitList= (List<Object[]>)map.get("unitList");
		}
		if(map.get("employeeList") != null){
			employeeList= (List<MasEmployee>)map.get("employeeList");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String currentTime = (String)utilMap.get("currentTimeWithoutSc");  
		
		Map<String, Object> dtmap = new HashMap<String, Object>();
		String message = "";
		if(map.get("message")!= null){
			message = (String)map.get("message");
		}
		if(map.get("dtmap") != null){
			dtmap = (Map<String, Object>)map.get("dtmap");
		}
		List<PatientAppointment> appointmentList = new ArrayList<PatientAppointment>();
		if(dtmap.get("appointmentList") != null){
			appointmentList= (List<PatientAppointment>)dtmap.get("appointmentList");
		}
		Box box = HMSUtil.getBox(request);
	%> 

<h4><%=message %></h4>
<div class="Clear"></div>
<div class="titleBg">
<h2>Patient Appointment</h2></div>
<div class="Clear"></div>
<div id="searchId" style="display: none;">
<div class="Block">

<label>Service No.</label>
<!--<input type="text" name="<%=SERVICE_NO %>" value="" MAXLENGTH="20"	id="serviceNo" onblur="submitProtoAjaxWithDivName('patientAppointment','/hms/hms/adt?method=getHinForAppointment','hinDiv')"/>
-->

<input type="text" name="searchServNo" value="" MAXLENGTH="30"	id="searchServNo"/>

<div id="hinDiv">
<label>HIN</label>
<input type="text"	name="<%=HIN_NO %>" value="" MAXLENGTH="30" id="hinNo" />
</div>
<div id="testDiv">
<label> Patient Name </label> 
<input type="text"	name="<%=P_FIRST_NAME %>" value="" validate="Patient Name,string,no" MAXLENGTH="50" id="<%=P_FIRST_NAME %>" />
<div class="Clear"></div>
	
<label> Relation</label> 
 <select name="<%=RELATION_ID %>" id="rankId">
	<option value="0">Select</option>
	<% for(MasRelation masRelation : relationList)
			{
			%>
	<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName()%></option>
	<%
			}
			%>
</select>
	

<label>Rank</label>
 <select name="<%=RANK_ID %>" id="rankId">
	<option value="0">Select</option>
	<% for(MasRank masRank : rankList)
			{
			%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			}
			%>
</select>
<label> Name</label> 
<input type="text"	name="<%=S_FIRST_NAME %>" value="" MAXLENGTH="50" id="fName" />
<div class="Clear"></div>
	
<label> Age </label>
<select id="ageId"	name="<%=AGE%>"  tabindex="1" validate="Age,string,no" 	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="ageUnitId" name="<%=AGE_UNIT %>"	tabindex="1" class="small">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<label> Gender</label> 
<select	name="<%=SEX_ID %>" id="gender" 	tabindex="1">
<option value="">Select</option>
<%
		   	 		for(MasAdministrativeSex masAdministrativeSex : sexList){
			%>
	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName().trim() %></option>
	<%
		   	 	} %>
</select>
</div>

<div class="Clear"></div>
<label class=""> Date : &nbsp;&nbsp;&nbsp;&nbsp;From <span>*</span></label>
<input type="text" name="fromAppDate" value="<%=currentDate %>" MAXLENGTH="20" class="date"	id="fromAppDate" validate="From Date,string,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.patientAppointment.fromAppDate,event)" /> 
<label>To <span>*</span></label>
<input type="text" name="toAppDate" value="<%=currentDate %>" MAXLENGTH="20" class="date"	id="toAppDate" validate="To Date,string,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.patientAppointment.toAppDate,event)" /> 

<label>Time </label> 
<input type="text" id="appTimeId" name="<%=APPOINTMENT_TIME %>" value="" maxlength="5" validate="Time,string,no" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" />
<div class="Clear"></div>
<label>Department </label> 
<select	name="<%=DEPARTMENT_NAME %>" id="dept" tabindex="1" validate="Department,string,no" >
<option value="">Select</option>
<option value="OPD">OPD</option>
<option value="FollowUp">Follow Up</option>
<option value="MedExam">Med Exam</option>
<option value="MedBoard">Med Board</option>
<option value="Physiotherapy">Physio</option>
<option value="TreatmentRoom">Treatment Rm</option>
<option value="FamilyWC">F W C</option>
<option value="Dental">Dental</option>
<option value="Radiology">Radiology</option>
</select>
	
<label> Medical Officer </label> 
<select name="<%= DOCTOR_NAME %>" validate="Medical Officer,string,no" >
<option value="0">Select</option>
<%
	for(MasEmployee employee : employeeList){
%>
<option value="<%= employee.getId() %>"><%=employee.getRank().getRankName()+" "+employee.getFirstName()+" "+(employee.getMiddleName()!=null?employee.getMiddleName():"")+" "+(employee.getLastName()!=null?employee.getLastName():"") %></option>
<%} %>
</select>
<div class="Clear"></div>
</div>


<div class="Clear"></div>
<input type="button" name="search" 	onclick="validateServiceNoSearch();"	value="Search" class="button"/>
<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" accesskey="r" />
</div>

<div class="Clear"></div>
<h4>Patient Appointment Details</h4>
<div class="Clear"></div>
<div class="Block">
<label>Date </label> 
<input type="text" id="appDateId" name="<%=APPOINTMENT_DATE %>" value="" readonly="readonly" validate="Date,string,no"  onblur="if(this.value!=''){checkDate(this.value)}"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.patientAppointment.<%=APPOINTMENT_DATE %>,event)" /> 
<input type="button" name="go" value="Go" class="buttonSm" onclick="submitFormForButton('patientAppointment','/hms/hms/adt?method=searchAppointments&flag=appointment','validateAppDate');">
<% if(box.getString("flag").equals("appointment")){ %>
<input type="button" name="add" class="buttonAdd" onclick="addRow('appTable');" />	

<%} %>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="appTable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Date</th>
		<th scope="col">Time</th>
		<th scope="col">Department</th>
		<th scope="col">MO</th>
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Unit</th>
		
		
	</tr>
	
	<%int i=1;
		if(appointmentList.size() > 0){
	%>
	<%
		for(PatientAppointment appointment : appointmentList){
	%>
	<tr>
	<td><input type="radio" name="radioAppId" value="<%= appointment.getId() %>" onclick="setHinId(<%=i %>)"/>
		<input type="hidden" name="appId<%=i %>" value="<%= appointment.getId() %>" />
	<input type="hidden" id="hinId<%=i %>" name="hinId<%=i %>" value="<%= (appointment.getHin()!=null ? appointment.getHin().getId() : 0) %>"/>
	<input type="hidden" id="serviceNo<%=i %>" name="serviceNo<%=i %>" value="<%= (appointment.getHin()!=null && appointment.getHin().getServiceNo()!=null ? appointment.getHin().getServiceNo() : 0) %>"/>
	<input type="hidden" id="serviceTypeId<%=i %>" name="serviceTypeId<%=i %>" value="<%= (appointment.getHin()!=null ? appointment.getHin().getServiceType().getId() : 0) %>"/></td>
	<td><input type="text" name="appDate<%=i %>" size="8" value="<%=appointment.getAppointmentDate()!=null?(HMSUtil.convertDateToStringWithoutTime(appointment.getAppointmentDate())):"" %>"/></td>
	<td><input type="text" name="appTime<%=i %>" size="6" value="<%=appointment.getAppointmentTime()!=null?appointment.getAppointmentTime():"" %>" /></td>
	<td><input type="text" name="department<%=i %>"  size="20" value="<%=appointment.getDepartment()!=null?appointment.getDepartment():"" %>" /></td>
<%
if(appointment.getMedicalOfficer()!=null){
%>
	<td><input type="text" name="mo<%=i %>" size="20" value="<%=appointment.getMedicalOfficer().getRank().getRankName()+" "+appointment.getMedicalOfficer().getFirstName()+" "+(appointment.getMedicalOfficer().getMiddleName()!=null?appointment.getMedicalOfficer().getMiddleName():"")+" "+(appointment.getMedicalOfficer().getLastName()!=null?appointment.getMedicalOfficer().getLastName():"") %>"/>
	<input type="hidden" name="deptId<%=i %>" id="deptId<%=i%>" size="20" value=""/></td>
	<%}else{ %>
	<td><input type="text" name="mo<%=i %>" size="20" value="" readonly="readonly"/>
		<input type="hidden" name="deptId<%=i %>" id="deptId<%=i%>" size="20" value=""/></td>
	<%} %>
	<td><input type="text" name="serviceNo<%=i %>" size="6" value="<%=appointment.getServiceNo()!=null?appointment.getServiceNo():"" %>" /></td>
	<td><input type="text" name="patientNameHin<%=i %>" id="patientNameHin<%=i %>" size="20" value="<%=appointment.getPatientName()!=null?appointment.getPatientName() :"" %>" /></td>
	<%
	if(appointment.getRelation()!=null){
		String relName = ""; 
		for(MasRelation relation : relationList){
			if(appointment.getRelation().getId().equals(relation.getId())){
				relName = relation.getRelationName();
				break;
			}
		}
	%>
	<td><input type="text" name="relation<%=i %>" size="10" value="<%=relName %>"/></td>
	<%}else{ %>
	<td><input type="text" name="relation<%=i %>" size="10" value=""/></td>
	<%} %>
	<%
	if(appointment.getRank()!=null){
		String rankName = ""; 
		for(MasRank rank: rankList){
			if(appointment.getRank().getId().equals(rank.getId())){
				rankName = rank.getRankName();
				break;
			}
		}
	%>
	<td><input type="text" name="rank<%=i %>" size="6" value="<%=rankName%>" /></td>
	<%}else{ %>
	<td><input type="text" name="rank<%=i %>" size="6" value=""/></td>
	<%} %>
	<%
	if(appointment.getServPersName()!=null){
	%>
	<td><input type="text" name="servPersName<%=i %>" size="12" value="<%=appointment.getServPersName() %>"/></td>
	<%}else{ %>
	<td><input type="text" name="servPersName<%=i %>" size="12" value=""/></td>
	<%} %>
	<%
		if(appointment.getHin()!= null && appointment.getHin().getUnit()!=null){
			String unitName = ""; 
			for(Object[] unit: unitList){
				if(appointment.getHin().getUnit().getId().equals(unit[0])){
					unitName = (String)unit[1];
					break;
				}
			}
	%>
	<td><input type="text" name="unit<%=i %>" size="10" value="<%=unitName %>" /></td>
	<%}else{ %>
	<td><input type="text" name="unit<%=i %>" size="10" value=""/></td>
	<%} %>
	</tr>
	<%i++;} 
	}%>
</table>
</div>
<div class="paddingTop15"></div>
<input type="hidden" id="cnt" name="cnt" value="<%=i-1 %>"/>
<% if(box.getString("flag").equals("appointment")){ %>
<input type="button" name="save" 	onclick="submitForm('patientAppointment','/hms/hms/adt?method=submitPatientAppointment');"	value="Submit" class="button" accesskey="a" />
<%} %>
<input type="hidden" id="hinId" name="hinId" value="0"/>
<input type="hidden" id="serviceNo" name="serviceNo" value=""/>
<input type="hidden" id="serviceTypeId" name="serviceTypeId" value="0"/>
<input type="button" name="registration" value="Registration" class="button" onclick="submitFormForButton('patientAppointment','/hms/hms/registration?method=showRegistrationJsp','validateRadio');"/>

<input type="button" name="cancel" value="Cancel Appointment" class="buttonBig" onclick="submitFormForButton('patientAppointment','/hms/hms/adt?method=cancelPatientAppointment','validateRadio');"/>
<input type="button" name="sear" value="Search" class="button" onclick="displaySearchBlock();"/>

</form>
<script>
function displaySearchBlock(){
document.getElementById('searchId').style.display='block';
	
}

function validateRadio(){
	
	 for(var i = 0; i < document.getElementsByName('radioAppId').length; i++){
	  if(document.getElementsByName('radioAppId')[i].checked == true)
     {
		return true;
	  }		
	}
	alert("Please select one record.")
return false;

}

function checkBlankField(){
	if(document.getElementById('fromAppDate').value == '' && document.getElementById('toAppDate').value == ''){
		alert("Please enter Appointment From Date and To Date");
		return false;
	}
	return true;
}
function setHinId(cnt){
	if(document.getElementById('hinId'+cnt) && document.getElementById('hinId'+cnt).value!=''){
	document.getElementById('hinId').value = document.getElementById('hinId'+cnt).value
	document.getElementById('serviceTypeId').value = document.getElementById('serviceTypeId'+cnt).value
	document.getElementById('serviceNo').value = document.getElementById('serviceNo'+cnt).value
	}
}

function addRow(idName) {
	  var tbl = document.getElementById(idName);
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('cnt');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cell0 = row.insertCell(0);
	 var e0 = document.createElement('input');
	  e0.type = 'radio';
	  e0.name='radioAppId';
	  e0.id='radioAppId'+iteration
	  e0.onclick=function(){setHinId(iteration)};
	  cell0.appendChild(e0);

	  var cell1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size='8';
	  e1.name='appDate'+iteration;
	  e1.id='appDate'+iteration
	  e1.value='<%=box.getString("appointmentDate")%>'
	  cell1.appendChild(e1);
	  var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/cal.gif';
	  eImg.className = 'calender';
	  eImg.style.display ='none';
	  eImg.id = 'calId'+iteration;
	  eImg.onclick = function(event){
					setdate('',document.getElementById('appDate'+iteration),event) };
	  cell1.appendChild(eImg);	

	  var cell2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='appTime'+iteration;
	  e2.size='6';
	  e2.maxLength = "5"
	  e2.id='appTime'+iteration
	  e2.onkeyup=function(){mask(this.value,this,'2',':');}
	  e2.onblur=function(){IsValidTimeWithBlankCheck(this.value,this.id),checkValidTime(this.value,iteration);}
	  cell2.appendChild(e2);

	  var cell3 = row.insertCell(3);
	  var e3 = document.createElement('select');
	  e3.options[0] = new Option('Select', '');
	  e3.options[1] = new Option('OPD', 'OPD');
	  e3.options[2] = new Option('Follow Up', 'FollowUp');
	  e3.options[3] = new Option('Med Exam', 'MedExam');
	  e3.options[4] = new Option('Med Board', 'MedBoard');
	  e3.options[5] = new Option('Physio', 'Physiotherapy');
	  e3.options[6] = new Option('TreatmentRoom', 'Treatment Rm');
	  e3.options[7] = new Option('F W C', 'FamilyWC');
	  e3.options[8] = new Option('Dental', 'Dental');
	  e3.options[9] = new Option('Radiology', 'Radiology');
	  e3.name='department'+iteration;
	  e3.id='department'+iteration
	  cell3.appendChild(e3);

	  var cell4 = row.insertCell(4);
	  var e4 = document.createElement('select');
	  e4.options[0] = new Option('Select', '0');
	 var i=1;
	 <%
	 
	 	for(MasEmployee employee : employeeList){
	 %>
	 	e4.options[i] = new Option('<%=employee.getRank().getRankName()+" "+ employee.getFirstName()+" "+(employee.getMiddleName()!=null?employee.getMiddleName():"")+" "+(employee.getLastName()!=null?employee.getLastName():"")%>','<%=employee.getId()%>');
	 	i++;
	 <%}%>
	  e4.name='mo'+iteration;
	  e4.id='mo'+iteration
	  e4.className='auto'
	  e4.onchange = function(){setDepartmentValue(this.value,iteration)};
	  cell4.appendChild(e4);

	  var e41 = document.createElement('input');
	  e41.type = 'hidden';
	  e41.name='deptId'+iteration;
	  e41.id = 'deptId'+iteration;
	  cell4.appendChild(e41);
	  
	  var cell5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.size='6';
	  e5.name='serviceNo'+iteration;
	  e5.id='serviceNo'+iteration
	  e5.onblur=function(){validateServiceNoAlfa(this.value,iteration)};
	  cell5.appendChild(e5);
	  
	  var cell6 = row.insertCell(6);
	  cell6.id="pName"+iteration;
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.size='20';
	  e6.name='patientNameHin'+iteration;
	  e6.id='patientNameHin'+iteration
	  cell6.appendChild(e6);

	  var cell7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.size='10';
	  e7.name='relation'+iteration;
	  e7.id='relation'+iteration
	  cell7.appendChild(e7);

	  var cell8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.size='6';
	  e8.name='rank'+iteration;
	  e8.id='rank'+iteration
	  cell8.appendChild(e8);

	  var cell9 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.size='12';
	  e9.name='servPersName'+iteration;
	  e9.id='servPersName'+iteration
	  cell9.appendChild(e9);

	  var cell10 = row.insertCell(10);
	  var e10 = document.createElement('input');
	  e10.type = 'text';
	  e10.size='10';
	  e10.name='unit'+iteration;
	  e10.id='unit'+iteration
	  cell10.appendChild(e10);

	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name='patientName'+iteration;
	  e11.id='patientName'+iteration
	  cell10.appendChild(e11);

	  var e12 = document.createElement('input');
	  e12.type = 'hidden';
	  e12.name='age'+iteration;
	  e12.id='age'+iteration
	  cell10.appendChild(e12);

	  var e13 = document.createElement('input');
	  e13.type = 'hidden';
	  e13.name='sex'+iteration;
	  e13.id='sex'+iteration
	  cell10.appendChild(e13);

	  var e14 = document.createElement('input');
	  e14.type = 'hidden';
	  e14.name='relationId'+iteration;
	  e14.id='relationId'+iteration
	  cell10.appendChild(e14);

	  var e15 = document.createElement('input');
	  e15.type = 'hidden';
	  e15.name='rankId'+iteration;
	  e15.id='rankId'+iteration
	  cell10.appendChild(e15);

	  var e16 = document.createElement('input');
	  e16.type = 'hidden';
	  e16.name='serviceTypeId'+iteration;
	  e16.id='serviceTypeId'+iteration
	  cell10.appendChild(e16);

	  var e15 = document.createElement('input');
	  e15.type = 'hidden';
	  e15.name='hinId'+iteration;
	  e15.id='hinId'+iteration
	  cell10.appendChild(e15);
}

function checkValidTime(time,inc){
	var curDate = '<%=currentDate%>';
	if(document.getElementById('appDate'+inc).value == curDate){
		var curTime = '<%=currentTime%>';
		if(document.getElementById('appTime'+inc).value < curTime){
			alert("Appointment Time can not be less than current time.");
			document.getElementById('appTime'+inc).value = '';
			return false;
		}
	}
	
}

function checkDate(appDate){
	currentDate = new Date();
	 var month = currentDate.getMonth() + 1
	 var day = currentDate.getDate()
	 var year = currentDate.getFullYear()
	 var seperator = "/"
	 currentDate = new Date(month + seperator + day + seperator + year);
	var appointmentDate = new Date(appDate.substring(6),(appDate.substring(3,5) - 1) ,appDate.substring(0,2));
	
	if(currentDate > appointmentDate){
		alert("Appointment Date can not be less than current date.");
		document.getElementById('appDateId').value = "";
		return false;
	}
	return true;	
}

function validateAppDate(){
	if(document.getElementById('appDateId').value==''){
		alert("Please select date");	
		return false;
	}
	return true;
}

function setDepartmentValue(doctorId,inc){
	var dcId;
	var deptId = 0;
	
	<%
		for(MasEmployee emp : employeeList){
	%>			
		dcId = '<%=emp.getId()%>';
		if(doctorId == dcId){
			<%
				if(emp.getDepartment()!= null){
			%>
			deptId = '<%=emp.getDepartment().getId()%>';
			<%}%>
		}	
	<%}%>
	
	document.getElementById('deptId'+inc).value=deptId;
}
/*
 * Code By Mukesh 
 * Date 14 Aug 2012
 * User for AlphaNumeric Service No
 */
function validateServiceNoAlfa(serviceNo,iteration){
	//alert("serviceNo-->"+serviceNo);
	 if(trimAll(serviceNo) != ''){
	 	if(validateMetaCharacters(serviceNo)){
	 	var serNo = trimAll(serviceNo);
	 	
	 	if(serNo != 0){
	 		submitProtoAjaxWithDivName('patientAppointment','/hms/hms/adt?method=getPatientNamesForApp&serviceNo='+serviceNo+'&counter='+iteration,'pName'+iteration)
	 		return true;
	 	}else{
	 			alert("Service No. can not be 0.")
	 			document.getElementById('serviceNo'+iteration).value = "";
	 			return false;
	 	}
	 	}else{
	 		alert("Service No is not valid.")
	 		document.getElementById('serviceNo'+iteration).value = "";
	 		return false;
	 	}
	 }
	 }
function validateServiceNoSearch(){
	//alert("serviceNo-->"+serviceNo);
	var searchServNo="";
	searchServNo=document.getElementById('searchServNo').value;
	var pFirstName="";
	pFirstName=document.getElementById('pFirstName').value;
	var fName="";
	fName=document.getElementById('fName').value;
	 var loopErrorList=new Array();
		var counter=0;
	 if(trimAll(searchServNo) == "" || trimAll(pFirstName) == "" || trimAll(fName) == "" )
		{
		 if(trimAll(searchServNo) != ""){
			if(validateMetaCharacters(searchServNo)==false){
				loopErrorList[counter]="Service No is not valid.";
				++counter;
			}
		 }

			if(trimAll(pFirstName) != ""){
				if(validateGoodString(pFirstName)==false){
					loopErrorList[counter]="Patient Name is not valid.";
					++counter;
				}
			}
			if(trimAll(fName) != ""){
				if(validateGoodString(fName)==false){
					loopErrorList[counter]="Name is not valid.";
					++counter;
				}
			}
		}
	 if(counter>0){
		 var msg="";
		 for(i=0;i<loopErrorList.length;i++){
			 msg=msg+"\n "+loopErrorList[i];	
			}
			alert(msg);
			return false;	
		}else{
			submitFormForButton('patientAppointment','/hms/hms/adt?method=searchAppointments&flag=search','checkBlankField');
	 		return true;
		}
	 }

</script>
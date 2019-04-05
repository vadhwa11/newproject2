
<%-- 
			 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
			 * Use is subject to license terms.
			 * File Name           : appointmentPatientCancel.jsp 
			 * Tables Used         : 
			 * Description         : 
			 * @author  Create Date: 01.09.2008    Name: Priyanka Garg
			 * Revision Date:      Revision By: 
			 * @version 1.0  
		--%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.AppPatientAppointments;"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>


<div id="contentHolder">
<form name="patientSearch" action="" method="post"><script
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
			</script> <%
			    Box box = HMSUtil.getBox(request);
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<AppPatientAppointments> patientList = new ArrayList<AppPatientAppointments>();
				Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
				String userName = "";
				if(request.getAttribute("map") != null){
					map = (Map<String, Object>)request.getAttribute("map");
				}
				if(map.get("patientList") != null){
					patientList= (List<AppPatientAppointments>)map.get("patientList");
				}
				if(map.get("departmentList") != null){
					departmentList= (List<MasDepartment>)map.get("departmentList");
				}
				
				if(session.getAttribute("userName") != null){
				 userName = (String)session.getAttribute("userName");
				}
						 	
			 %> </script>
<h6>Cancellation for Patient Appointments</h6>
<div class="Clear"></div>
<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label> Service No.</label> <input type="text" name="<%=SERVICE_NO %>"
	value="" MAXLENGTH="20" /> <label>Hin:</label> <input type="text"
	name="<%=HIN_NO %>" value="" MAXLENGTH="50" /> <label>Department</label>
<select id="departmentId" name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
							int deptId=(Integer)session.getAttribute("deptId");
							if(departmentList!= null){
							for (MasDepartment masDepartment : departmentList) {
								if(masDepartment.getId()==deptId){
						%>
	<option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%	
								}
							}
						}
						%>
</select>

<div class="Clear"></div>

<label> Patient Name:</label> <input type="text"
	name="<%=PATIENT_NAME %>" value="" MAXLENGTH="30" /> <label>
Age:</label> <input type="text" name="<%=AGE %>" value="" MAXLENGTH="2" /> <label>Appointment
Date:</label> <input type="text" class="calDate" id="fromDateId"
	name="<%=APPOINTMENT_DATE %>" value="" readonly="readonly"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate %>',document.patientSearch.<%=APPOINTMENT_DATE%>,event);" />


<div class="Clear"></div>

<label> Appointment No:</label> <input type="text"
	name="<%=APPOINTMENT_NO %>" value="" MAXLENGTH="40" /> <label>&nbsp;</label>

</div>
<!--Block Three Starts-->
<div class="Clear"></div>
<input type="button" name="Submit" id="searchButton"
	onclick="submitForm('patientSearch','/hms/hms/appointment?method=patientAppointmentList');"
	value="Search" class="button" accesskey="a" /> <input name=""
	type="reset" class="button" value="Reset" />
	<div class="Clear"></div>
<div class="colsHolder">
<div class="Clear"></div>
<%
			    int  counter=0;
				if (patientList != null && patientList.size() > 0) { 
			%>

<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col"></th>
		<th scope="col">Department</th>
		<th scope="col">Service No.</th>
		<th scope="col">Hin No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Age</th>
		<th scope="col">Appointment No.</th>
		<th scope="col">Appointment <br />
		Date</th>
		<th scope="col">Timings</th>
	</tr>


	<% 	
				for(AppPatientAppointments appPatientAppointments: patientList){
					//AppPatientAppointments appPatientAppointments = appPatientAppointments.getHin();
			%>
	<tr>
		<td><input type="checkbox" id="parent<%=counter%>"
			name="<%=APPOINTMENT_ID %>"
			value="<%=appPatientAppointments.getId()%>" /></td>
		<td><input type="text" id="wardId<%=counter %>"
			name="<%=WARD_ID%>"
			value="<%=appPatientAppointments.getDepartment().getDepartmentName()%>"
			readonly="readonly" /></td>
		<td>
		<%if(appPatientAppointments.getServiceNo()!=null){ %> <input type="text"
			size="8" id="serviceNo<%=counter %>" name="<%=SERVICE_NO%>"
			value="<%=appPatientAppointments.getServiceNo()%>"
			readonly="readonly" /> <%}else{ %> <input type="text" size="8"
			id="serviceNo<%=counter %>" name="<%=SERVICE_NO%>" value=""
			readonly="readonly" /> <%} %>
		</td>
		<td>
		<%if(appPatientAppointments.getHin()!=null){ %> <input type="text"
			size="8" id="hinNo<%=counter %>" name="<%=HIN_NO%>"
			value="<%=appPatientAppointments.getHin().getHinNo()%>"
			readonly="readonly" /> <%}else{%> <input type="text" size="8"
			id="hinNo<%=counter %>" name="<%=HIN_NO%>" value=""
			readonly="readonly" /> <%} %>
		</td>
		<td><input type="text" id="patientName<%=counter %>"
			name="<%=PATIENT_NAME%>"
			value="<%=appPatientAppointments.getPatientName()%>"
			readonly="readonly" /></td>
		<td><input type="text" size="8" id="age<%=counter %>"
			name="<%=AGE%>" value="<%=appPatientAppointments.getAge()%>"
			readonly="readonly" /></td>
		<td><input type="text" id="appointmentNo<%=counter %>"
			name="<%=APPOINTMENT_NO%>"
			value="<%=appPatientAppointments.getAppointmentNo()%>"
			readonly="readonly" /></td>
		<td><input type="text" id="appointmentDate<%=counter %>"
			name="apptDate"
			value="<%=HMSUtil.changeDateToddMMyyyy(appPatientAppointments.getAppointmentDate())%>"
			readonly="readonly" /></td>
		<td><input type="text" id="appointmentDate<%=counter %>"
			name="<%=FROM_TIME%>"
			value="<%=appPatientAppointments.getFromTimeSlot()%> - <%=appPatientAppointments.getToTimeSlot()%>"
			readonly="readonly" /></td>
	</tr>
	<%	     counter++;
				    	}	
			
					
			%>
</table>
</div>
<div class="Clear"></div>
<!--Bottom labels starts-->
<input name="" type="button" class="buttonBig"
	value="Cancel Appointment"
	onclick="submitForm('patientSearch','appointment?method=submitCancelPatientAppointment');" />
<%} else { 
					if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
<label class="noWidth"><span><%=message %></span></label>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By </label> <label
	class="value"><%=userName %></label> <label>Changed Date </label> <label
	class="value"><%=currentDate %></label> <label>Changed Time </label> <label
	class="value"><%=time%></label>
	</div>
<%    
					   
			   		}	
			 }	 	%>
</div>
</form>
</div>

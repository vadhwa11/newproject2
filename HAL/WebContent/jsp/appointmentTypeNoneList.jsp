
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.AppPatientAppointments"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">

<div id="contentHolder">
<form name="registeredPatients" method="post" action="">

<h6>OPD Patient Appointment</h6>
<div class="Clear"></div>

<%
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	boolean noRecordFound=false;
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	List<AppPatientAppointments> appPatientAppointmentsList = new ArrayList<AppPatientAppointments>();
			 	int counter=0;
			 
			 	
				if (map.get("appPatientAppointmentsList") != null) {
					appPatientAppointmentsList = (List<AppPatientAppointments>) map.get("appPatientAppointmentsList");
			 		
			 	}
			 %>

<div class="division"></div>


<!--Block Three Starts-->
<div class="colsHolder">


<div class="tableHholderCmnLarge">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th></th>
		<th scope="col">Service No.</th>
		<th scope="col">Service Person <br />
		Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Patient <br />
		Name</th>
		<th scope="col">Mobile <br />
		No.</th>
		<th scope="col">Age</th>
		<th scope="col">Appointment No</th>
	</tr>

	<%
        
     	int inc = 0;  
     	if(appPatientAppointmentsList!=null)
     	{
    		for(AppPatientAppointments appPatientAppointments : appPatientAppointmentsList){
    	%>
	<tr>
		<td style="background: lightgreen;"><input type="radio"
			id="parent" name="parent" value="<%=appPatientAppointments.getId()%>"
			id="parent" /></td>

		<td style="background: lightgreen;">
		<%if(appPatientAppointments.getServiceNo() != null){ %> <input
			type="text" id="ServiceNo<%=inc%>" size="18"
			style="background: lightgreen;"
			value="<%=appPatientAppointments.getServiceNo()%>"
			readonly="readonly" disabled="disabled" /> <%}else{ %> <input
			type="text" id=ServiceNo <%=inc%>" size="18"
			style="background: lightgreen;" value="" readonly="readonly"
			disabled="disabled" /> <%} %>
		</td>
		<td>
		<%if(appPatientAppointments.getServicePersonName() != null){ %> <input
			type="text" id="servicePersonName<%=inc%>" size="18"
			style="background: lightgreen;"
			value="<%=appPatientAppointments.getServicePersonName()%>"
			readonly="readonly" disabled="disabled" /> <%}else{ %> <input
			type="text" id="servicePersonName<%=inc%>" size="18"
			style="background: lightgreen;" value="" readonly="readonly"
			disabled="disabled" /> <%} %>
		</td>
		<td>
		<%if(appPatientAppointments.getRelation() != null){ %> <input
			type="text" id="relation<%=inc%>" size="8"
			style="background: lightgreen;"
			value="<%=appPatientAppointments.getRelation().getRelationName()%>"
			readonly="readonly" disabled="disabled" /> <%}else{ %> <input
			type="text" id="relation<%=inc%>" size="8"
			style="background: lightgreen;" value="" readonly="readonly"
			disabled="disabled" /> <%} %>
		</td>

		<td>
		<%if(appPatientAppointments.getPatientName() != null){ %> <input
			type="text" size="18" id="patientName<%=inc%>"
			style="background: lightgreen;"
			value="<%=appPatientAppointments.getPatientName()%>"
			readonly="readonly" disabled="disabled" /> <%}else{ %> <input
			type="text" size="18" id="patientName<%=inc%>"
			style="background: lightgreen;" value="" readonly="readonly"
			disabled="disabled" /> <%} %>
		</td>

		<td>
		<%if(appPatientAppointments.getMobileNo()!=null){ %> <input type="text"
			size="10" id="mobileNo<%=inc%>" style="background: lightgreen;"
			value="<%=appPatientAppointments.getMobileNo()%>" readonly="readonly"
			disabled="disabled" /> <%}else{ %> <input type="text" size="10"
			id="mobileNo<%=inc%>" style="background: lightgreen;" value=""
			readonly="readonly" disabled="disabled" /> <%} %>
		</td>
		<td>
		<%if(appPatientAppointments.getAge()!=null){ %> <input type="text"
			id="age<%=inc%>" size="5" style="background: lightgreen;"
			value="<%=appPatientAppointments.getAge()%>" readonly="readonly"
			disabled="disabled" /> <%}else{ %> <input type="text" id="age<%=inc%>"
			size="5" style="background: lightgreen;"
			value="<%=appPatientAppointments.getAge()%>" readonly="readonly"
			disabled="disabled" /> <%} %>
		</td>

		<td><input type="text" id="appointmentNo<%=inc%>" size="20"
			style="background: lightgreen;"
			value="<%=appPatientAppointments.getAppointmentNo()%>"
			readonly="readonly" disabled="disabled" /></td>

	</tr>

	<%   }
    	}
	%>
</table>
</div>

</div>



<!--Bottom labels starts-->
<div class="bottom">
<div class="Clear"></div>

<input name="" type="button" class="button" value="Submit" onclick="" />
<input name="" type="button" class="button" value="Back"
	onclick="window.close();" /></div>
<!--Bottom labels ends--></form>
</div>

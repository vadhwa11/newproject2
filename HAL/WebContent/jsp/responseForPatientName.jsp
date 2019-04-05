
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		List<Patient> patientList = new ArrayList<Patient>();
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
		int counter = 0;
		if(map.get("counter")!=null){
			counter = (Integer)map.get("counter");
		}
		%>
		
		<select name="patientNameHin<%=counter %>" id="patientNameHin<%=counter %>" onchange="displayOtherInfo(this.value,<%=counter %>)" tabindex='1'>
		<option value="0">Select</option>
		<%
			for(Patient patient : patientList){
		%>
		<option value="<%=patient.getId() %>"><%=patient.getPFirstName()+" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"")+" "+(patient.getPLastName()!=null?patient.getPLastName():"") %></option>
		
		<%} %>
		</select>
	
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<Patient> patientList= new ArrayList<Patient>();
if(map.get("patientList") != null){
	patientList = (List<Patient>)map.get("patientList");
}
%>
<%@page import="jkt.hms.masters.business.Patient"%>
<ul>
	<%	if(patientList.size() !=0){
	for(Patient patient2 : patientList){%>
	<li><%=patient2.getHinNo()%></li>

	<%}}else{%>
	<li>----------HIN No not found-------------</li>
	<%} %>
</ul>
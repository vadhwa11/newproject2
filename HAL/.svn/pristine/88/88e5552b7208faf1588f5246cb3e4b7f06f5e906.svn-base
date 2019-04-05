<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%Map map = new HashMap();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		List<Patient> patientList = new ArrayList<Patient>();
		if (map.get("patientList") != null)
			patientList =(List)map.get("patientList");
			%>
<form name="fatalDocumentPanchnamaReport" target="_blank" method="post"
	action=""><label class="">Hin No: </label> <select
	name="<%=HIN_NO%>" validate="Admission No,string,yes"
	onchange="submitProtoAjaxWithDivName('bdReport','mis?method=getHiAdListForBD&hinId='+this.value+'&flag=ad','testDiv')">
	<option value="">Select</option>
	<%for(Patient patient :patientList){ %>
	<option value="<%=patient.getId() %>"><%=patient.getHinNo() %></option>
	<%} %>
</select></form>

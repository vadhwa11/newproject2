<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Medicinenet"%>

<%
List<Symptom> symptomList = new ArrayList<Symptom>();
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

if(map.get("MedicinenetList") != null){
	symptomList=( List<Symptom>)map.get("MedicinenetList");
}	

%>


<%@page import="jkt.hms.masters.business.Symptom"%><ul>
	<%if (symptomList != null && symptomList.size() > 0) { %>

	<% for(int i=0;i<symptomList.size();i++)
{
		Symptom symptom = (Symptom)symptomList.get(i);
			if(symptom.getComplaintDescription()!=null)
			{
				String symptomName=symptom.getComplaintDescription()+"["+symptom.getId()+"]";	
			%>
	<li style="width: auto; font: normal 11px tahoma; text-align: left;"><%=symptomName%></li>
	<%}}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




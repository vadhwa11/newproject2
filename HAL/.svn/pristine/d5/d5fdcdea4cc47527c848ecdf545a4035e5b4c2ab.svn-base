<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Medicinenet"%>

<%
List<SymptomSubComplains> symptomSubComplainsList = new ArrayList<SymptomSubComplains>();
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
if(map.get("symptomSubComplainsList") != null){
	symptomSubComplainsList=( List<SymptomSubComplains>)map.get("symptomSubComplainsList");
}	

%>


<%@page import="jkt.hms.masters.business.Symptom"%>
<%@page import="jkt.hms.masters.business.SymptomSubComplains"%><ul>
	<%if (symptomSubComplainsList != null && symptomSubComplainsList.size() > 0) { %>

	<% for(int i=0;i<symptomSubComplainsList.size();i++)
{
		SymptomSubComplains symptomSubComplains = (SymptomSubComplains)symptomSubComplainsList.get(i);
			if(symptomSubComplains.getSubSymptomName()!=null)
			{
				String subSymptomName=symptomSubComplains.getSubSymptomName()+"["+symptomSubComplains.getId()+"]";
			%>
	<li style="width: auto; font: normal 11px tahoma; text-align: left;"><%=subSymptomName%></li>
	<%}}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




<%@page import="java.util.*"%>

<%
List<OpdMasSymptom> symptomList = new ArrayList<OpdMasSymptom>();
//DifferentialDiagnosis diagnosisdetail = new DifferentialDiagnosis();

Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

if(map.get("symptomList") != null){
	symptomList=( List<OpdMasSymptom>)map.get("symptomList");
}	
//System.out.println("jsp diagnosisDetailList response---"+differentialDiagnosisList.size());	
%>


<%@page import="jkt.hms.masters.business.DifferentialDiagnosis"%>
<%@page import="jkt.hms.masters.business.OpdMasSymptom"%><ul>
	<%	
if(symptomList.size() !=0)
{
	for (Iterator iterator = symptomList.iterator(); iterator.hasNext();) 
	{
			OpdMasSymptom symptom=(OpdMasSymptom)iterator.next();
			String symptomName=symptom.getSymptomName();
		   int symptomId=symptom.getId();
		   
		 
%>
	<li style="width: auto;"><%=symptomName%>[<%=symptomId%>]</li>

	<%
	}
}
else
{%>
	<li>----------No Items found-------------</li>
	<%}%>
</ul>



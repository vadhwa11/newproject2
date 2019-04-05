<%@page import="java.util.*"%>

<%
//List<MasSystemDiagnosis> systemDiagnosisList = new ArrayList<MasSystemDiagnosis>();
//DifferentialDiagnosis diagnosisdetail = new DifferentialDiagnosis();
List<MasIcd> systemDiagnosisList = new ArrayList<MasIcd>();
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

if(map.get("systemDiagnosisList") != null){
	systemDiagnosisList=( List<MasIcd>)map.get("systemDiagnosisList");
}	
%>
<%@page import="jkt.hms.masters.business.MasSystemDiagnosis"%>
<%@page import="jkt.hms.masters.business.MasIcd"%><ul>
	<%	
if(systemDiagnosisList.size() !=0)
{
	for (Iterator iterator = systemDiagnosisList.iterator(); iterator.hasNext();) 
	{
			MasSystemDiagnosis systemDiagnosis=(MasSystemDiagnosis)iterator.next();
%>

<li style="width: auto;"><%=systemDiagnosis.getSystemDiagnosisName()%>[<%=systemDiagnosis.getId()%>]</li> 
<%----<li style="width: auto;"><%=systemDiagnosis.getIcdName()%>[<%=systemDiagnosis.getIcdCode() %>][<%=systemDiagnosis.getId()%>]</li>--%>
<%
	}
}
else
{%>
	<li>----------No Items found-------------</li>
	<%}%>
</ul>
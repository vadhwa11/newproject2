<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

<%
//List<MasSystemDiagnosis> systemDiagnosisList = new ArrayList<MasSystemDiagnosis>();
//DifferentialDiagnosis diagnosisdetail = new DifferentialDiagnosis();
List<MasIcd> icdDiagnosisList = new ArrayList<MasIcd>();
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

if(map.get("icdDiagnosisList") != null){
	icdDiagnosisList=( List<MasIcd>)map.get("icdDiagnosisList");
}	
%>
<ul>
<%if(icdDiagnosisList.size() !=0)
{
	for (Iterator iterator = icdDiagnosisList.iterator(); iterator.hasNext();) 
	{
			MasIcd icdDiagnosis=(MasIcd)iterator.next();
%>
<li style="width: auto;"><%=icdDiagnosis.getIcdName()%>[<%=icdDiagnosis.getIcdCode() %>][<%=icdDiagnosis.getId()%>]</li>
<%
	}
}
else
{%>
	<li>----------No Items found-------------</li>
	<%}%>
</ul>
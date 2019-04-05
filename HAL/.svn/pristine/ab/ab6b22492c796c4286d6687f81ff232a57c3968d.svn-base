<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
List<IpdPatientDiet> dietDetailsList = new ArrayList<IpdPatientDiet>();
if(map.get("dietDetailsList") != null)
{
	dietDetailsList=(List<IpdPatientDiet>)map.get("dietDetailsList");
}
if(dietDetailsList.size() >0){
	for(IpdPatientDiet ipdDiet : dietDetailsList){
%>

<%@page import="jkt.hms.masters.business.IpdPatientDiet"%>
<h6><%= HMSUtil.convertDateToStringWithoutTime(ipdDiet.getOpdPatientDetails().getOpdDate())+" "+(ipdDiet.getOpdPatientDetails().getOpdTime())+" "+(ipdDiet.getOpdPatientDetails().getDepartment()!=null?ipdDiet.getOpdPatientDetails().getDepartment().getDepartmentName():"")%></h6>
<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="opdinvestigationGrid">
	<tr>
		<th scope="col">Diet</th>
	<th scope="col">Spl. Instructions</th>
	</tr>
	<%
	
	%>
	<tr>
	<td><%=ipdDiet.getDiet()!=null?ipdDiet.getDiet().getDietName():""%></td>
	<td><%=ipdDiet.getSplInstructions()!=null?ipdDiet.getSplInstructions():""%></td>
	</tr>

</table>
</div>
<div class="paddingTop15"></div>
<%}
}
	%>
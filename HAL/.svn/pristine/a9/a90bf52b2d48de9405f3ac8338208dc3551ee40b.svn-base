<%@page import="java.util.*"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List treatmentList= new ArrayList();
if(map.get("treatmentList") != null){
	treatmentList = (List)map.get("treatmentList");
}
%>

<%@page import="jkt.hms.masters.business.MasPhysiotherapyTreatment"%>
<ul>
	<%	if(treatmentList.size() !=0){
		for (Iterator iterator = treatmentList.iterator(); iterator.hasNext();) {
			MasPhysiotherapyTreatment masTreatment = (MasPhysiotherapyTreatment) iterator.next();
		    String treatmentName=masTreatment.getTreatmentName();
		    int  treatmentId=masTreatment.getId();
%>
	<li><%=treatmentName%>[<%=treatmentId%>]</li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




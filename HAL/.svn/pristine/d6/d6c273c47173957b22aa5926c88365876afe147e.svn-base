<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasNursingCare> procedureList  = new ArrayList<MasNursingCare>();
if(map.get("procedureList") != null){
	procedureList = (List)map.get("procedureList");
}
%>


<ul>
	<%	if(procedureList.size() !=0){
		for (Iterator iterator = procedureList.iterator(); iterator.hasNext();) {
			MasNursingCare masNursingCare= (MasNursingCare) iterator.next();
		    String procedureName = masNursingCare.getNursingName();
		    int  procedureId = masNursingCare.getId();
		    String procedureCode = masNursingCare.getNursingCode();
%>
	<li style="width: auto; font: normal 11px tahoma; text-align: left;"><%=procedureName%>[<%=procedureId%>]</li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




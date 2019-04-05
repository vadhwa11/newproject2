<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>


<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		
		}
		List<MasNursingCare> procedureList  = new ArrayList<MasNursingCare>();
		if(map.get("procedureList") != null){
			procedureList = (List<MasNursingCare>)map.get("procedureList");
		}
		System.out.println("procedureList---"+procedureList.size());
%>


<ul>
	<%	if(procedureList.size() !=0){
	
		for (MasNursingCare nursingCare : procedureList) {
					
%>
	<li><%=nursingCare.getNursingName()%>[<%=nursingCare.getId()%>]</li>

	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		
		}
		List investigationList= new ArrayList();
		if(map.get("investigationList") != null){
			investigationList = (List)map.get("investigationList");
		}
%>


<ul>
	<%	if(investigationList.size() !=0){
	
		for (Iterator iterator = investigationList.iterator(); iterator.hasNext();) {
			DgMasInvestigation dgMasInvestigation = (DgMasInvestigation)iterator.next();
					
%>
	<li><%=dgMasInvestigation.getInvestigationName()%>[<%=dgMasInvestigation.getId()%>]</li>

	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>
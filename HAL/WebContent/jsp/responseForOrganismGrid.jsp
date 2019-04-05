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
		List<DgMasOrganism> organismList= new ArrayList<DgMasOrganism>();
		if(map.get("organismList") != null){
			organismList = (List)map.get("organismList");
		}
%>


<%@page import="jkt.hms.masters.business.DgMasOrganism"%>
<ul>
	<%	for (DgMasOrganism dgMasOrganism : organismList) { %>

	<li><%=dgMasOrganism.getOrganismName()%>[<%=dgMasOrganism.getId()%>]</li>

	<%}
 if(organismList.size() == 0){%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>
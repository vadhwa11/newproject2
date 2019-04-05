<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		}
		List diagnosisList= new ArrayList();
		if(map.get("diagnosisList") != null){
			diagnosisList = (List)map.get("diagnosisList");
		}
%>

<ul>
	<%	if(diagnosisList.size() !=0){
	
		for (Iterator iterator = diagnosisList.iterator(); iterator.hasNext();) {
			MasIcd masIcd = (MasIcd)iterator.next();
%>
	<li><%=masIcd.getIcdName()%>[<%=masIcd.getId()%>]</li>

	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




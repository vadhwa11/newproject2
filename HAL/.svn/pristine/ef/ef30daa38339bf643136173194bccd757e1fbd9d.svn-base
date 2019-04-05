<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		}
		List bloodComponentList= new ArrayList();
		if(map.get("componentList") != null){
			bloodComponentList = (List)map.get("componentList");
		}
%>
<ul>
	<%	if(bloodComponentList.size() !=0){
	
		for (Iterator iterator = bloodComponentList.iterator(); iterator.hasNext();) {
			BloodMasComponent bloodMasComponent = (BloodMasComponent)iterator.next();
%>
	<li><%=bloodMasComponent.getComponentName()%>[<%=bloodMasComponent.getId()%>]</li>

	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>
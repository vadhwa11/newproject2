<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>


<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		
		}
		List unitList= new ArrayList();
		if(map.get("unitList") != null){
			unitList = (List)map.get("unitList");
		}
%>
<ul>
	<%	if(unitList.size() !=0){
	
		for (Iterator iterator = unitList.iterator(); iterator.hasNext();) {
			MasUnit masUnit = (MasUnit)iterator.next();
%>
	<li>
	<%if(masUnit.getUnitName() !=null && !(masUnit.getUnitName().equals(""))) {%>
	<%=masUnit.getUnitName()%>[<%=masUnit.getId()%>]</li>

	<%}}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




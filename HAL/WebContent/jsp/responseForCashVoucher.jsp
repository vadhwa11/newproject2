<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");

		}
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		if(map.get("accList") != null){
			accList = (List)map.get("accList");
		}
		
%>

<ul>
	<%	if(accList.size() !=0){

		for (FaMasAccount faMasAccount :accList) {


%>
	<li><%=faMasAccount.getAccDesc()%>[<%=faMasAccount.getAccCode()%>]</li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




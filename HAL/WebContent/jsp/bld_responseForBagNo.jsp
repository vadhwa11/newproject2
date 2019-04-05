<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		}
		List stockList= new ArrayList();
		if(map.get("stockList") != null){
			stockList = (List)map.get("stockList");
		}
%>
<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<ul>
	<%	if(stockList.size() !=0){
	
		for (Iterator iterator = stockList.iterator(); iterator.hasNext();) {
			BloodStockDetail bloodStockDetail = (BloodStockDetail)iterator.next();
%>
	<li><%=bloodStockDetail.getBloodBagNo()%>[<%=bloodStockDetail.getId()%>]</li>

	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>
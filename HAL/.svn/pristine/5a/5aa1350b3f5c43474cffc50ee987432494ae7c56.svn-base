<%@page import="jkt.hms.masters.business.MasStoreItem"%>
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
		List<MasStoreItem> masStoreItems=new ArrayList<MasStoreItem>();
		if(map.get("masStoreItems") != null){
			masStoreItems = (List)map.get("masStoreItems");
		} 
%>

<%@page import="jkt.hms.masters.business.MasChargeCode"%><ul>
	<%	if(masStoreItems!=null && masStoreItems.size()>0){
	
		for (MasStoreItem masStoreItem:masStoreItems) { 
					
%>
	<input type="hidden" name="masStoreItemId" id="masStoreItemId" value="<%=masStoreItem.getId() %>" />
	<input type="hidden" name="masStoreItemName" id="masStoreItemName" value="<%=masStoreItem.getNomenclature() %>" />
	<input type="hidden" name="masStoreItemPvsmNo" id="masStoreItemPvsmNo" value="<%=masStoreItem.getPvmsNo() %>" />
	<li><%=masStoreItem.getNomenclature()%>[<%=masStoreItem.getId()%>](<%=masStoreItem.getPvmsNo()%>)</li>

	<%}}else{ %>
		<li>----------No Items found-------------</li>
	<%} %>
</ul>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

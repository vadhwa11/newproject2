<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}System.out.println("---in resp --jsp---");
List<StoreItemBatchStock> batchItemList = new ArrayList<StoreItemBatchStock>();
if(map.get("batchItemList") != null){
	batchItemList = (List)map.get("batchItemList");
}
%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%><ul>

	<%	 
	if(batchItemList.size() !=0)
	{
		for (Iterator iterator = batchItemList.iterator(); iterator.hasNext();) {
			StoreItemBatchStock batchStock = (StoreItemBatchStock) iterator.next();
		    String itemName = batchStock.getItem().getNomenclature();
		    String pvms_no  = batchStock.getItem().getPvmsNo();
%>
	<% if(map.get("forMMf")!=null){%>
	<li style="width: auto;"><%=itemName%></li>
	<% }else{%>
	<li style="width: auto;"><%=itemName%>[<%=pvms_no%>]</li>
	<%}%>
	<%}
	}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>
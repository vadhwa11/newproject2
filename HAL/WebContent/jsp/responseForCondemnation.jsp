<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<StoreItemBatchStock> itemList= new ArrayList<StoreItemBatchStock>();
if(map.get("itemList") != null){
	itemList = (List)map.get("itemList");
}
%>

<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%><ul>
	<%	 
	
	if(itemList.size() !=0)
	{
		for (StoreItemBatchStock storeItemBatchStock :itemList) {
			
		    String itemName = storeItemBatchStock.getItem().getNomenclature();
		    String pvms_no  = storeItemBatchStock.getItem().getPvmsNo();
%>
	
	<li style="width: auto;"><%=itemName%>[<%=pvms_no%>]</li>
	
	<%}
	}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




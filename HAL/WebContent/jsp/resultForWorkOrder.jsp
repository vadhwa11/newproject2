<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
/*
List<StoreItemBatchStock> itemList = new ArrayList<StoreItemBatchStock>();
if(map.get("itemList") != null){
	itemList = (List<StoreItemBatchStock>)map.get("itemList");
	System.out.println(itemList+"itemList----jsp--->"+itemList.size());
}*/
List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
if(map.get("itemList") != null){
	itemList = (List<MasStoreItem>)map.get("itemList");
	
}
%>
<ul>
	<%	
	if(itemList.size() !=0)
	{
	for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
		//StoreItemBatchStock storeItem = (StoreItemBatchStock) iterator.next();
	   // String itemName = storeItem.getItem().getNomenclature();
	    //String pvms_no  = storeItem.getItem().getPvmsNo();
	   // int itemId= storeItem.getItem().getId();
	   MasStoreItem masStoreItem = (MasStoreItem) iterator.next();
	   String itemName = masStoreItem.getNomenclature();
	   String pvms_no  = masStoreItem.getPvmsNo();
	  
%>
	<%---<li style="width: auto;"><%=storeItem[1]%>(<%=storeItem[0]%>)[<%=storeItem[2]%>]</li> --%>
	
	<li style="width: auto;"><%=itemName%>[<%=pvms_no%>]</li>
	<%}
	}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>

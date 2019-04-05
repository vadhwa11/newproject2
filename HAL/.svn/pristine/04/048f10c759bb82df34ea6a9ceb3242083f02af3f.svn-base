
<%@page import="java.util.*"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List itemList= new ArrayList();
if(map.get("itemList") != null){
	itemList = (List)map.get("itemList");
}
System.out.println("itemList --------- "+itemList.size());
%>


<%@page import="java.util.Iterator"%>


<%@page import="jkt.hms.masters.business.MasStoreItem;"%>
<ul>
	<%	if(itemList.size() !=0){
	
		for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
			
			//Object[] pair = (Object[]) iterator.next();
			MasStoreItem masStoreItem=(MasStoreItem)iterator.next();
			
		    String nomenclature=masStoreItem.getNomenclature();
		    String pvms=masStoreItem.getPvmsNo();
		    int itemId=masStoreItem.getId();
			System.out.println("itemId i-------"+itemId);
		System.out.println("nomenclature i-------"+nomenclature);
	
		
%>
	<li style="width: auto;"><%=nomenclature%>[<%=itemId%>]</li>



	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




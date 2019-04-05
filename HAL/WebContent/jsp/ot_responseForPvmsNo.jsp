
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List storeItemList= new ArrayList();
if(map.get("storeItemList") != null){
	storeItemList = (List)map.get("storeItemList");
}
System.out.println("storeItemList --------- "+storeItemList.size());
%>


<%@page import="java.util.Iterator"%>


<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<ul>
	<%	if(storeItemList.size() !=0){
	
		for (Iterator iterator = storeItemList.iterator(); iterator.hasNext();) {
			
			//Object[] pair = (Object[]) iterator.next();
			MasStoreItem masStoreItem=(MasStoreItem)iterator.next();
			
		    String storeItemName=masStoreItem.getPvmsNo();
		    String nomenclature=masStoreItem.getNomenclature();
		    int storeItemId=masStoreItem.getId();
		System.out.println("nomenclature i-------"+storeItemName);
	
		
%>
	<li style="width: auto;"><%=nomenclature%>[<%=storeItemId%>]</li>



	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




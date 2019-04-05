<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List itemList= new ArrayList();
if(map.get("itemList") != null){
	itemList = (List)map.get("itemList");
}
%>
<ul>
	<%	
	if(itemList.size() !=0)
	{
		for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
			System.out.println("itemList in jsp1111 >"+itemList.size());
			StorePoDetail masStoreItem = (StorePoDetail) iterator.next();
		    String itemName = masStoreItem.getItem().getNomenclature();
		    String pvms_no  = masStoreItem.getItem().getPvmsNo();
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




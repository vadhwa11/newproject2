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
List<Object> itemList = new ArrayList<Object>();
if(map.get("itemList") != null){
	itemList = (List<Object>)map.get("itemList");
}
%>

<ul>
	<%	if(itemList.size() !=0){
		for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
			//MasStoreItem masStoreItem = (MasStoreItem) iterator.next();
			Object[] object = (Object[]) iterator.next();

		    String itemName = (String)object[2];
		    String pvms_no  = (String)object[1];
%>
	<li style="width: auto;"><%=itemName%>[<%=pvms_no%>]</li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




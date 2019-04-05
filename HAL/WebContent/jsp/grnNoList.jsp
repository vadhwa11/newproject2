<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
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
	<%	if(itemList.size() !=0){
		for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
			StoreGrnM storeGrnM = (StoreGrnM) iterator.next();
		    String grnNo = storeGrnM.getGrnNo();
		    
%>

	<li style="width: auto;"><%=grnNo%></li>
	<% }%>
	<%}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




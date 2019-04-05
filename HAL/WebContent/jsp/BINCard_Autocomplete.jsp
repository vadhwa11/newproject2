<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
if(map.get("itemList") != null){
	itemList = (List<MasStoreItem>)map.get("itemList");
}
%>
<ul>
	<%	if(itemList.size() !=0){
	for(MasStoreItem item : itemList){
		if(item.getStrength() != null){%>
	<li style="width: auto;"><%=item.getNomenclature()+item.getStrength()%>[<%=item.getId()%>](<%=item.getPvmsNo()%>)</li>
	<%}else{%>
	<li><%=item.getNomenclature()%>[<%=item.getId()%>](<%=item.getPvmsNo()%>)</li>

	<%}}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>
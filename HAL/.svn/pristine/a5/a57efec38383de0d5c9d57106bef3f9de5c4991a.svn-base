<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasIcd> itemList = new ArrayList<MasIcd>();
if(map.get("itemList") != null){
	itemList = (List<MasIcd>)map.get("itemList");
}
%>

<ul>
	<%	if(itemList.size() !=0){
		for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
			MasIcd masIcd = (MasIcd) iterator.next();
		    String itemName = masIcd.getIcdName();
		    Integer id=masIcd.getId();
	%>
	<li  style="width: 250;"><%=itemName%>[<%=id%>]</li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




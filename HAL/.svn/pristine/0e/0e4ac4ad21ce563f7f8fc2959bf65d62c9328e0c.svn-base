<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasLinenWeight"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasLinenWeight> itemList= new ArrayList<MasLinenWeight>();
if(map.get("itemList") != null){
	itemList = (List<MasLinenWeight>)map.get("itemList");
}
%>

<ul>
	<%	if(itemList.size() !=0){
	for(MasLinenWeight application1 : itemList){
		%>
	<li style="width: auto;"><%=application1.getItemName()%>[<%=application1.getId()%>]</li>


	<%}}else{%>
	<li style="width: auto;">----------No items found-------------</li>
	<%} %>
</ul>

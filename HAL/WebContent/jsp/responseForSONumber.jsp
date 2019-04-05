<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%

Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<StorePoHeader> soList = new ArrayList<StorePoHeader>();
if(map.get("soList") !=null){
	soList=(List<StorePoHeader>)map.get("soList");
}
%>

<ul>
	<%
	if(soList.size() !=0){
		for (StorePoHeader storePoHeader :soList) {

%>
	<li style="width: auto; BACKGROUND-COLOR: #D7D7D7;"><%=storePoHeader.getPoNumber()%></li>
	<%}}else{%>
	<li style="width: auto; BACKGROUND-COLOR: #D7D7D7;">----------No
	Items found-------------</li>
	<%} %>
</ul>




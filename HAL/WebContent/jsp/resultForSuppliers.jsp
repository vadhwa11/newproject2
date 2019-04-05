<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasStoreSupplier> suppliersList= new ArrayList<MasStoreSupplier>();
if(map.get("suppliersList") != null){
	suppliersList = (List<MasStoreSupplier>)map.get("suppliersList");
}
%>

<ul>
	<%	if(suppliersList.size() !=0){
	for(MasStoreSupplier suppliers1 : suppliersList){
		%>
	<li style="width: auto;"><%=suppliers1.getSupplierName()%></li>


	<%}}else{%>
	<li style="width: auto;">----------No suppliers found-------------</li>
	<%} %>
</ul>

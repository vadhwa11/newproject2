
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	if(map.get("itemList")!=null){
		itemList = (List<MasStoreItem>)map.get("itemList");
	}
	
%>

<div class="titleBg">
<h2>Drug List</h2>
</div>
<div class="Clear"></div>
<form name="drugs" method="post" action="">
<% if(itemList.size() >0){ %>
<div class="Clear"></div>
<table  width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">PVMS/NIV No.</th>
		<th scope="col">Nomenclature</th>
	</tr>
		<tbody id="tableData">
<%
	int i=1;
	for(MasStoreItem storeItem : itemList){
		%>
		<tr>
		<td><%= i %></td>
		<td><%= storeItem.getPvmsNo() %></td>
		<td><%= storeItem.getNomenclature() %></td>
		
		</tr>
	<%i++;}
%>
</tbody>
</table>

	<%}else{ %>
	<h4>No Records Found</h4>
	
	<%} %>
<div class="Clear"></div>
<div class="division"></div>
<input type="button" name="close" value="Close" class="button" onClick="window.close();" />


</form>

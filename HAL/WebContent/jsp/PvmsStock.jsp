<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.math.BigDecimal"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/tabcontent.css" />
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.6.pack.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
Map map = new HashMap();
List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
if (request.getAttribute("map") != null) 
	map = (Map) request.getAttribute("map");
System.out.println("this is view part map size"+map.size());
if (map.get("objectList") != null) {
	itemList = (List)map.get("objectList");
	System.out.println("this is view part size"+itemList.size());
}
%>

<div id="country1">
<div class="cmntableWithHeight">
<table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
<tr>
<thead>
<th>PVMS No.</th>
<th>Nomenclature</th>
<th>Section</th>
<th>A/U</th>
<th>MF</th>
<th>Life</th>
<th>Rate</th>
<th>UOM</th>
<th>Source</th>
<th>Remarks</th>
<th>Min Stock</th>
<th>ABC Analysis</th>
<th>VD Analysis</th></thead>
</tr>

<div class="clear"></div>
<%
if (itemList != null && itemList.size() > 0) { 
for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
				Object[] objects = (Object[]) iterator.next();
%>
<tr>
<td><%=objects[0]%></td>
<td><%=objects[1]%></td>
<td><%=objects[2]%></td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
<td>a</td>
</tr>
<%}}%>
</table>
</div>

</div>
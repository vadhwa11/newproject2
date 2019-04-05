<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 *   
 * Purpose of the JSP 
 * @author  Othivadivel K R
* Create Date: 25.05.2009
 * Revision Date:      
 * Revision By:  
 * 
--%>


<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.CssdMaterialStockM"%>
<%@page import="jkt.hms.masters.business.CssdMaterialStockT"%>


<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	

	int pageno=0;
	int totalPages = 0;
	int totalRecords=0;
	int numOfRows=0;
	
	if (map.get("pageno")!=null)
	{
		 pageno = Integer.parseInt(map.get("pageno").toString());
	}
	
	if (map.get("totalPages")!=null)
	{
		 totalPages = Integer.parseInt(map.get("totalPages").toString());
	}
	
	if (map.get("totalRecords")!=null)
	{
		totalRecords = Integer.parseInt(map.get("totalRecords").toString());
	}
	
	if (map.get("numOfRows")!=null)
	{
		numOfRows = Integer.parseInt(map.get("numOfRows").toString());
	}
	
	int i = (pageno - 1) * numOfRows;
	
	int approvedBy = 0;
	List<CssdMaterialStockT> cssdMaterialStockTList = (ArrayList<CssdMaterialStockT>)map.get("cssdMaterialStockTList");
	List<CssdMaterialStockM> cssdMaterialStockMList = (ArrayList<CssdMaterialStockM>)map.get("cssdMaterialStockMList");
	if (cssdMaterialStockMList!=null && cssdMaterialStockMList.size() > 0)
	{
		approvedBy = cssdMaterialStockMList.get(0).getApprovedBy().getId();	
	}
	
%>

<script language="javascript">

</script>

<div id="testDiv"><input type="hidden" name="pageno"
	value=<%=pageno%> /> <input type="hidden" name="totalPages"
	value=<%=totalPages%> /> <input type="hidden" name="totalRecords"
	value=<%=totalRecords%> /> <input type="hidden" name="numOfRows"
	value=5 />


<div class="division"></div>
<div class="blockTitle">Stock Entry Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Height10"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>S.No.</th>
		<th>Material Code</th>
		<th>Material Name</th>
		<th>Quantity</th>
		<th>Remarks</th>
	</tr>

	<%
  for(CssdMaterialStockT cssdMaterialStockT : cssdMaterialStockTList)
  { %>
	<tr>
		<td><%=++i%></td>
		<td><%=cssdMaterialStockT.getMaterial().getMaterialCode()%></td>
		<td><%=cssdMaterialStockT.getMaterial().getMaterialName() %></td>
		<td><%=cssdMaterialStockT.getQty()%></td>
		<td><%=cssdMaterialStockT.getRemarks()%></td>
	</tr>
	<% } %>
</table>
</div>
</div>
<div id="pagination">
<% if (totalPages > 0 ) { %> <label>Page <%=pageno %> of <%=totalPages %></label>
<label><a href="javascript:goPrevious()">Prev<<</a>&nbsp;&nbsp;</label>
<label><a href="javascript:goNext()">>>Next</a></label> <input
	type="text" name="gopage" size="3" /> <label><input
	type="button" name="Go Page" class="cmnButton" type="submit"
	value="Go Page" onclick="javascript:GoPage();"></label> <% } %>
</div>

</div>
<div class="Clear"></div>


<script>
window.document.getElementById('materialCode').value="";
window.document.getElementById('materialName').value="";
window.document.getElementById('qty').value="";
window.document.getElementById('remarks').value="";
for(var i=0;i<document.getElementById('approvedBy').length;i++)
 {
	 if (document.getElementById('approvedBy').options[i].value=="<%=approvedBy%>")
	 {
	 	document.getElementById('approvedBy').selectedIndex = i;
	 }
 }

</script>
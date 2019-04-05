<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Age.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDietIndentItem"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<MasDietIndentItem> itemList = new ArrayList<MasDietIndentItem>();
	
	if(map.get("itemList") != null){
		itemList = (List<MasDietIndentItem>)map.get("itemList");
	}
		
%>
<label>Item Details:</label>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>Description Of Items</th>
		<th>Denominations</th>
		<th>Quantity Demand</th>
		<th>Total Group Item Quantity</th>
		<th>Remarks</th>
	</tr>
	<%
    	for(int i=0;i<itemList.size();i++){
    %>
	<tr>
		<td><%=itemList.get(i).getIndentItemName() %> <input
			type="hidden" name="<%=ITEM_ID%>"
			value="<%=itemList.get(i).getId() %>" /></td>
		<td><%= itemList.get(i).getDenominations()%></td>
		<td><input type="text" name="<%=QUANTITY_DEMANDED %>" value=""
			maxlength="7" /></td>
		<td>
		<%
     	if(i < itemList.size()-1){
     		if(!itemList.get(i).getIndentGroup().equals(itemList.get(i+1).getIndentGroup())){
     	%> <input type="text" name="<%=GROUP_QUANTITY %>" value=""
			maxlength="7" /> <%	}
     	}else{%> <input type="text" name="<%=GROUP_QUANTITY %>" value=""
			maxlength="7" /> <%} %>
		</td>

		<td><input type="text" name="<%=REMARKS %>" value=""
			maxlength="50" /></td>
	</tr>

	<%
 }%>
</table>


</div>
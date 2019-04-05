<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<StorePoDetail> poDetailsList = new ArrayList<StorePoDetail>();
if(map.get("poDetailsList") !=null){
	poDetailsList=(List<StorePoDetail>)map.get("poDetailsList");
}
%>



<%@page import="java.math.BigDecimal"%><div class="tableHholderCmnLarge">
<table cellspacing="0" cellpadding="0">
<tr>
<th>&nbsp;</th>
<th>PVMS No.</th>
<th>Nomenclature</th>
<th>SO Quantity</th>
<th>Quantity Received</th>
<th>Quantity Pending</th>
<th>Status</th>
</tr>
<%
	int i=1;
	int poHdId = 0;
	if(poDetailsList.size() > 0){
		for(StorePoDetail poDetail: poDetailsList){
			poHdId = poDetail.getPo().getId();
			%>
		<tr>
		<td>
		<%	String closeStatus = "";
			if((poDetail.getClosed() != null && poDetail.getClosed().equals("y"))||(poDetail.getCancelled()!=null && poDetail.getCancelled().equals("y"))){
					closeStatus = "Closed";
					if(poDetail.getCancelled()!=null && poDetail.getCancelled().equals("y"))
				    closeStatus = "Cancelled";	

		%>
		<input type="checkBox" name="poDetailsId" id ="poDetailsId<%=i %>"  value="<%=poDetail.getId() %>" disabled="disabled"/>
		<%}else{ %>
		<input type="checkBox" name="poDetailsId" id ="poDetailsId<%=i %>" value="<%=poDetail.getId() %>"/>
		<%} %></td>
		<td><%=poDetail.getItem().getPvmsNo() %></td>
		<td><%=poDetail.getItem().getNomenclature() %></td>
		<td><%=poDetail.getQuantityOrdered() %>
		<input type="hidden" name="orderedQty<%=i %>" id ="orderedQty<%=i %>" value="<%=poDetail.getQuantityOrdered() %>">
		</td>
		<%
			BigDecimal qtyRecvd = new BigDecimal(0);
			if(poDetail.getQuantityReceived() != null){
				qtyRecvd = poDetail.getQuantityReceived();
			}
		%>

		<td><%=qtyRecvd %>
		<input type="hidden" name="receivedQty<%=i %>" id ="receivedQty<%=i %>" value="<%=qtyRecvd.doubleValue()%>">
		</td>
		<td><%=poDetail.getQuantityOrdered().subtract(qtyRecvd) %></td>

		<td><%=closeStatus %></td>
		</tr>

	<%	i++;}
	}
%>

</table>

</div>
<input type="hidden" name="counter" value="<%=i %>"/>
<input type="hidden" name="poId" value="<%=poHdId %>"/>
<input name="Button2" type="button" class="button" value="Close" onclick="if(checkForClose(<%=i %>)){submitForm('closeCancelSO','/hms/hms/purchaseOrder?method=closePOItem');}"/>
<input name="Button" type="button" class="button" value="Cancel SO" onclick="if(checkForCancelation(<%=i %>)){submitForm('closeCancelSO','/hms/hms/purchaseOrder?method=cancelPOItem');}"/>
<script type="text/javascript">

</script>

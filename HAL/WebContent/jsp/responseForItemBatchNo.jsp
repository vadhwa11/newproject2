<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("batchList")!= null){
			batchList = (List<StoreItemBatchStock>)map.get("batchList");
		}
		int counter = 0;
		if(map.get("counter") != null){
			counter = (Integer)map.get("counter");
		}
			
	

%>
<select name="batchId<%=counter %>" id="batchId<%=counter %>" onchange="getExpiryDate(this.value,<%=counter %>);" tabindex="1">
<option value="0">Select</option>
<%	
int itemId = 0;
if(batchList.size() > 0){ 
		for(StoreItemBatchStock batchStock:batchList){
			itemId = batchStock.getItem().getId();
%>
<option value="<%=batchStock.getId() %>"><%=batchStock.getBatchNo() %></option>

<%}
		}%>
</select>
<input type="hidden" id="itemId<%=counter %>" name="itemId<%=counter %>" value="<%=itemId%>" />

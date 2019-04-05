<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
	
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
		
		if(map.get("batchList")!=null)
		{
			batchList = (List)map.get("batchList");
		}
%>
<select name="batchId" id="batchId" tabindex="1">
<option value="0">Select</option>
<%	
if(batchList.size() > 0){ 
		for(StoreItemBatchStock batchStock:batchList){
%>
<option value="<%=batchStock.getId() %>"><%=batchStock.getBatchNo() %></option>

<%}
		}%>
</select>
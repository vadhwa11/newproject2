<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
	//	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();	
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
	/*	if(map.get("itemList")!= null){
			itemList = (List<MasStoreItem>)map.get("itemList");
		}*/
		int counter = 0;
		if(map.get("counter") != null){
			counter = (Integer)map.get("counter");
		}
		
		String flag = "";
		if(map.get("flag") != null){
			flag = (String)map.get("flag");
		}
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
		
		if(map.get("batchList")!=null)
		{
			batchList = (List)map.get("batchList");
		}
	//	MasStoreItem storeItem = itemList.get(0);
%>
<select name="batchId<%=counter %>" id="batchId<%=counter %>" tabindex="1">
<option value="0">Select</option>
<%	
int itemId = 0;
int itemCategoryId = 0;
String expDate = "";
String batchNo = "";
if(batchList.size() > 0){ 
		for(StoreItemBatchStock batchStock:batchList){
			itemId = batchStock.getItem().getId();
			itemCategoryId = batchStock.getItem().getItemCategory()!=null?batchStock.getItem().getItemCategory().getId():0;
			expDate = batchStock.getExpiryDate()!=null?(HMSUtil.convertDateToStringWithoutTime( batchStock.getExpiryDate())):"";
			batchNo = batchStock.getBatchNo();
%>
<option value="<%=batchStock.getId() %>"><%=batchStock.getBatchNo() %></option>

<%}
		}%>
</select>
<input type="hidden" id="batchNo<%=counter %>" name="batchNo<%=counter %>" value="<%=batchNo%>" />
<input type="hidden" id="itemId<%=counter %>" name="itemId<%=counter %>" value="<%=itemId%>" />
<input type="hidden" id="itemCategoryId<%=counter %>" name="itemCategoryId<%=counter %>" value="<%= itemCategoryId %>">
<input type="hidden" name="expDate<%=counter %>" id="expDate<%=counter %>" value="<%=expDate %>">
<input type="hidden" name="costPrice<%=counter %>" id="costPrice<%=counter %>" value="">
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
	Map<String,Object> map = new HashMap<String,Object>();	
    if (request.getAttribute("map") != null) 
	map = (Map) request.getAttribute("map");
    List<StoreItemBatchStock> serialNoList= new ArrayList<StoreItemBatchStock>();
	if(map.get("serialNoList")!=null)
		serialNoList = (List) map.get("serialNoList");
	
%>

<div id="serialDiv"><label class="bodytextB2">Serial No :</label>
<select name="<%=RequestConstants.SERIAL_NUMBER%>">
	<option value="">Select</option>
	<%
			  	for (StoreItemBatchStock storeItemBatchStock:serialNoList ){
			  	
		  	 %>
	<option value="<%=storeItemBatchStock.getBatchNo()%>"><%=storeItemBatchStock.getBatchNo()%></option>
	<% } %>
</select></div>

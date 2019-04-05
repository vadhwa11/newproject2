<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * demandListAjax.jsp  
 * Purpose of the JSP -  This is for getting dynamic Demand List.
 * @author  Vivek
 * Create Date: 29th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.8
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>

<%
	Map map = new HashMap();
	List<StoreIndentT> storeIndentTList = new ArrayList<StoreIndentT>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("storeIndentTList")!=null){
		storeIndentTList=(List)map.get("storeIndentTList");
	}
	
%>
<%@page import="jkt.hms.util.RequestConstants"%>
<select name="<%= RequestConstants.NOMENCLATURE%>" id="itemId"
	tabindex="1" class="bigselect"
	onchange="checkAndCallAjaxSubmit(this.value);">
	<option value="0">Select</option>
	<%for(StoreIndentT  storeIndentT : storeIndentTList){%>
	<option value="<%=storeIndentT.getItem().getId()%>"><%=storeIndentT.getItem().getNomenclature() %></option>
	<%}	%>
</select>



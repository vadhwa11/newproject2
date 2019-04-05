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
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>

<%
	Map map = new HashMap();
	List<StoreIndentM> storeIndentMList = new ArrayList<StoreIndentM>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("storeIndentMList")!=null){
		storeIndentMList=(List)map.get("storeIndentMList");
	}	
%>
<%@page import="jkt.hms.util.RequestConstants"%>
<select name="<%= RequestConstants.INDENT_ID%>" tabindex="1"
	id="indentId"
	onchange="submitProtoAjaxDynamic('indentSocTracker','stores?method=getItemListForSocTracker&departmentIdTemp='+this.value,'itemDiv');">
	<option value="0">Select</option>
	<%for(StoreIndentM  storeIndentM : storeIndentMList){%>
	<option value="<%=storeIndentM.getId() %>"><%=storeIndentM.getIndentNo() %></option>
	<%}	%>
</select>
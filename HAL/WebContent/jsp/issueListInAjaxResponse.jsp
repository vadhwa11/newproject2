
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
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>

<%
		Map map = new HashMap();
		List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		if(map.get("storeIssueMList")!=null){
			storeIssueMList=(List<StoreIssueM>)map.get("storeIssueMList");
		}
		
	%>
<%@page import="jkt.hms.util.RequestConstants"%>
<select name=<%= RequestConstants.ISSUE_UNIT_ID %>
	id="<%= RequestConstants.ISSUE_UNIT_ID %>">
	<option value="">Select</option>
	<%for(StoreIssueM  storeIssueM : storeIssueMList){%>
	<option value="<%=storeIssueM.getId() %>"><%=storeIssueM.getIssueNo() %></option>
	<%}	%>
</select>



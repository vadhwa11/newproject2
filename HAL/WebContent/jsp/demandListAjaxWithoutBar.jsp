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
<%@page import="jkt.hms.util.RequestConstants"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>

<%
	Map map = new HashMap();
	//List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
	List<Object[]> storeInternalIndentMList = new ArrayList<Object[]>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("storeInternalIndentMList")!=null){
		storeInternalIndentMList=(List<Object[]>)map.get("storeInternalIndentMList");
		
		System.out.println("----------  "+storeInternalIndentMList.size());
	}

System.out.println("------------hi is this Without Bar--------------");
%>

<div id="testDiv">
<%-- <select name="requestNo" id="requestNo"
	onchange="if(testForAdjustLoanOut()&&cheackForSelect())submitForm('issueDispensaryForm','stores?method=searchInternalIndentDetails');"> --%>
	<select name="requestNo" id="requestNo" onblur="getdpt();"
	>

	<option value="">Select</option>
	<%for(Object[]  obj : storeInternalIndentMList){%>
	<option value="<%=obj[0] %>"><%=obj[1] %></option>
	<%}	%>
</select>
</div>

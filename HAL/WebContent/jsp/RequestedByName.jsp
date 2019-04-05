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
String Employee_id="";
String Employee_name="";
Map map = new HashMap();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
if(map.get("Employee_id")!=null){
	Employee_id=map.get("Employee_id").toString();
}
if(map.get("Employee_name")!=null){
	Employee_name=map.get("Employee_name").toString();	
}
%>

<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<div id="testDivR">
<label>Requested By<span>*</span></label><label class="value"  onclick="if(testForAdjustLoanOut()&&cheackForSelect())submitForm('issueDispensaryForm','stores?method=searchIndentDetails');"><%=Employee_name%></label>
<input type="hidden" name="<%= REQUEST_BY%>" id="requestBy" validate="Request By,string,no" value="<%=Employee_id%>"/>
<input type="hidden" name="<%= REQUEST_BY_NAME%>" id="requestByName" validate="Request By,string,no" value="<%=Employee_name%>"/>
</div>


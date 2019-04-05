<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for ADT Message.
 * @author  Ritu
 * Create Date: 14th Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}

%>
<div id="contentHolder">
<form name="messageDiet" method="post">
	<label><span><%=message %></span></label>
<div class="Clear"></div>
<%
			if(map.get("forDate") != null){
				String forDate = (String)map.get("forDate");
		%>
		<input type="button" class="cmnButton" value="Print Daily Diet Extra Requisition Report" onClick="submitForm('messageDiet','diet?method=printDailyDietAndExtraReqisitionReport&date=<%=forDate %>');" />
		<%} %>
		<% if(map.get("dietChange") != null){%>
			<input type="button" class="cmnButton" value="Daily Diet & Extra Requisition" onClick="submitForm('messageDiet','diet?method=showDailyDietExtraRequisitionJsp');" />
		<%} %>
		
		<% if(map.get("breakfast") != null){
			if(map.get("summaryDate") != null){
				String date = (String)map.get("summaryDate");
		%>
		
			<input type="button" class="cmnButton" value="Print Breakfast Summary Report" onClick="submitForm('messageDiet','diet?method=printDietSummaryReport&flag=breakfastSummary&date=<%=date %>');" />
		<%}
			}%>
		
</form>
</div>


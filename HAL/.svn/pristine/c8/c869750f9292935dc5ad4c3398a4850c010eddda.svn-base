<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for Lab Message.
 * @author  Dipali
 * Create Date: 14th August,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
String hinNo = "";
String orderNo = "";
String backUrl = "";
String deptType ="";
int inpatientId=0;

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
if(map.get("backUrl") != null){
	backUrl = (String)map.get("backUrl");
}
if(map.get("deptType") != null){
	deptType = (String)map.get("deptType");
}

%>
<form name="messageLab" method="post" target="_blank">
<div id="contentHolder"><h4><%=message %></h4>
<%
	if(map.get("hinNo") != null){
		hinNo = (String)map.get("hinNo");
	}
	if(map.get("inpatientId") != null){
		inpatientId = (Integer)map.get("inpatientId");
	}
	if(map.get("orderSeqNo") != null){
		orderNo = (String)map.get("orderSeqNo");
	}
%>
<div class="Clear"></div>
<input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('messageLab','/hms/hms/lab?method=printOrderBookingIPD&hinNo=<%=hinNo %>&orderNo=<%=orderNo %>&inpatientId=<%=inpatientId %>');" />
<%if(deptType.equalsIgnoreCase("RADIO") || deptType.equalsIgnoreCase("DIAG")){ %>
<input type="button" name="no" value="No" class="button"
	onclick="submitForm('messageLab','/hms/hms/lab?method=showIPDOrderBookingSearchJsp','checkTargetForNo');" />
<%}else{ %> <input type="button" name="no" value="No" class="button"
	onclick="submitForm('messageLab','/hms/hms/ipd?method=showPatientListJsp','checkTargetForNo');" />
<%} %> <!--
 <input type="button" value="PendingSampleCollection" class="button" onclick="submitForm('messageLab','/hms/hms/lab?method=showPendingSampleCollectionJsp');" />
 --> <%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>
</div>
</form>

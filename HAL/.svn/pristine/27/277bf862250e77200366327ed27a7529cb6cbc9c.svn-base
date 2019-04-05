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
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
String visitNo = "";
Integer visitId = 0;
String hinNo = "";
String orderNo = "";
String backUrl = "";

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
%>
<form name="messageLab" method="post" target="_blank"><br />
<br />
<h2><font id="error"><%=message %></font></h2>
<br />
<br />
<%
	if(map.get("visitNo") != null){
		visitNo = (String)map.get("visitNo");
	}
	if(map.get("visitId") != null){
		visitId = (Integer)map.get("visitId");
	}

	if(map.get("hinNo") != null){
		hinNo = (String)map.get("hinNo");
	}
	if(map.get("orderSeqNo") != null){
		orderNo = (String)map.get("orderSeqNo");
	}
%> <input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('messageLab','/hms/hms/lab?method=printOrderBooking&hinNo=<%=hinNo %>&visitNo=<%=visitNo %>&orderNo=<%=orderNo %>');" />
<input type="button" name="no" value="No" class="button"
	onclick="submitForm('messageLab','/hms/hms/opd?method=getPatientDetailsForOPDOrderBooking&visitId=<%=visitId%>','checkTargetForNo');" />
<!--
 <input type="button" value="PendingSampleCollection" class="button" onclick="submitForm('messageLab','/hms/hms/lab?method=showPendingSampleCollectionJsp');" />
 --> <br />
<%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>
</form>

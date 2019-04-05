<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for OrderBooking For Inpatient.
 * @author  Dipali
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
String hinNo = "";
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
<form name="messageLab" method="post"><br />
<br />
<h2><font id="error"><%=message %></font></h2>
<br />
<br />
<%
	if(map.get("hinNo") != null){
		hinNo = (String)map.get("hinNo");
	}
%> <input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('messageLab','/hms/hms/lab?method=printOrderBooking&hinNo=<%=hinNo %>,'checkTargetForYes');" />
<input type="button" name="no" value="No" class="button"
	onclick="submitForm('messageLab','ipd?method=showPatientListJsp','checkTargetForNo');" />
<!--
 <input type="button" value="PendingSampleCollection" class="button" onclick="submitForm('messageLab','/hms/hms/lab?method=showPendingSampleCollectionJsp');" />
 --> <br />
<%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>
</form>

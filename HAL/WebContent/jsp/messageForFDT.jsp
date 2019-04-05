<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for Birth Message.
 * @author  Diapli
 * Create Date: 26 April,2008 
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
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<form name="FDT" method="post"><br />
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String flag="";
int inpatientId=0;
String adNo = "";
String messageType="";
String serviceNo ="";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("serviceNo") != null){
	serviceNo = (String)map.get("serviceNo");
}
if(map.get("inpatientId") != null){
	inpatientId =Integer.parseInt(""+map.get("inpatientId")) ;
}
if(map.get("messageType") != null){
	messageType = (String)map.get("messageType");
}
%> <%if(!message.equals("")){
	if(messageType.equals("success")){
	%>
<h4><%=message %></h4>

<%}%> <%if(messageType.equals("failure")){%>

<h4><%=message %></h4>
<%}}%> <div class="clear"></div>
<input type="hidden" name="<%=AD_NO%>" value="<%=inpatientId %>" />
 <input
	type="hidden" name="yes" value="Print" class="button"
	onclick="submitForm('FDT','/hms/hms/mis?method=printFDTReport');" /> <input
	type="button" name="no" value="Back" class="button"
	onclick="submitForm('FDT','/hms/hms/mis?method=showFatalCasejsp');" />
<br />
<br />
</form>

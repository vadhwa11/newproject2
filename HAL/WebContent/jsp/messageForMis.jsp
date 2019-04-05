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

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String message1="";
String formName = "";
String flag="";
int inpatientId=0;
String adNo = "";
String messageType ="";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}

if(map.get("inpatientId") != null){
	inpatientId = (Integer)map.get("inpatientId");
}
if(map.get("flag") != null){
	flag = (String)map.get("flag");
}

if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
%>

<form name="messageMisBirth" target="_blank" method="post">
<%
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("messageType") != null){
	messageType = (String)map.get("messageType");
}


	%> <%if(!message.equals(""))
	{
	if(messageType.equals("success")){
	%> <h4><span><%=message %></span></h4>

<div class="Clear"></div>
<%}%> <%if(messageType.equals("failure")){%> <h4><span><%=message %></span></h4>

<div class="Clear"></div>
<%}%>
<div class="Clear"></div>
<input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('messageMisBirth','/hms/hms/mis?method=printBDCertificate&adNo=<%=inpatientId %>&selectedRadio=<%=flag%>');" />
<input type="button" name="no" value="No" class="button"
	onclick="submitForm('messageMisBirth','/hms/hms/mis?method=showBirthCertificateJsp','checkTargetForNo');" />
<%}%>
<div class="Clear"></div>
<%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>
</form>

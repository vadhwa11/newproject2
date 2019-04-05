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
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
int hinId = 0;
String adNo = "";
String backUrl = "";
String printUrl="";
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
if(map.get("printUrl") !=null){
	printUrl=""+map.get("printUrl");
}
int visitId = 0;
if(map.get("visitId") != null){
	visitId = (Integer)map.get("visitId");
}
%>
<form name="messageFwc" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>
<%
	
	if(map.get("hinId") != null){
		
		hinId = (Integer)map.get("hinId");
		
%> 
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="yes" value="Yes" class="button"	onclick="submitForm('messageFwc','/hms/hms/fwc?method=printImmunisation&hinId=<%=hinId %>&visitId=<%=visitId %>','checkTargetForYes');" />
<input type="button" name="no" value="No" class="button" onclick="submitForm('messageFwc','/hms/hms/fwc?method=showWaitingPatientListJsp','checkTargetForNo');" />



<div class="clear"></div>
<div class="division"></div>
<%} %>

 <%
if(formName != ""){
%>
<input type="button" value="Close" class="button"	onclick="window.close()"> <%} %>

</form>

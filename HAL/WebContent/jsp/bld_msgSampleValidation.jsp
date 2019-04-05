<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * message.jsp  
 * Purpose of the JSP -  This is for Message.
 * @author  Dipali
 * Create Date: 21 Nov,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 

	Map<String,Object> map = new HashMap<String,Object>();
	
	String url="";
	String url1="";
	String formName = "";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	if(map.get("url1") !=null){
		url1=""+map.get("url1");
	}
	if(map.get("formName") != null){
		formName = (String)map.get("formName");
	}
%>
<form name="message" method="post">
<% 
String message="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		 %>
<h2><%=message %></h2>
<%} %>
<div id="contentHolder">
<div class="Clear"></div>
<input type="button" class="cmnButton" name="back" value="Back"
	onClick="submitForm('message','<%=url%>');" /> <input type="button"
	class="cmnButton" name="Screening"
	value="Pending Grouping & Cross Matching"
	onClick="submitForm('message','/hms/hms/bloodBank?method=showPendingSampleScreeningTestJsp');" />
<div class="clear"></div>
<%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>
</div>
</form>
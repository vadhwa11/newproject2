<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * message.jsp  
 * Purpose of the JSP -  This is for Message.
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.Map"%>
<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 

	System.out.println("message jsp");
	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	String url="";
	String combinedIds = "";
	String hroEntryId="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	if(map.get("hroEntryId") !=null){
		hroEntryId=(String)map.get("hroEntryId");
	}
	

	System.out.println("hroEntryId is------"+hroEntryId);
	
	
%>

		<div id="contentHolder">
		<form name="message" method="post" target="_blank">
		<br/><br/>
		<h5><%=message %></h5>
		<div class="Clear"></div>
		<input type=hidden name="hroEntryId" value="<%=hroEntryId %>"  />
		
		<input type="button" name="yes" value="Yes" class="cmnButton" onclick="submitForm('message','/hms/hms/hrOrderly?method=printHroDetail');"/>
		
		<input type="button" name="no" value="No" class="cmnButton" onClick="" />
		
		</form>
		</div>
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
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 

	System.out.println("message jsp");
	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	String url="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		message=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	String resultNo="";
	if(map.get("resultNo") != null){
		resultNo = (String)map.get("resultNo");
	}
	String resultType="";
	if(map.get("resultType") != null){
		resultType = (String)map.get("resultType");
	}

	System.out.println("resultType is------"+resultType);
	
	
%>
<script type="text/javascript">
function checkTargetForYesTemp(){
	var aTags = document.getElementsByTagName('input');
	for (i=0; i < aTags.length; i++) {
			aTags[i].setAttribute("target", "_blank");
		}
	return true;
}
</script>
<div id="contentHolder">
<form name="message" method="post" target="_blank"><br />
<br />
<h5><%=message %></h5>
<div class="Clear"></div>
<input type=hidden name="<%=RESULT_NO %>" value="<%=resultNo %>" /> <input
	type=hidden name="<%=RESULT_TYPE %>" value="<%=resultType %>" /> <% if(resultType.equalsIgnoreCase("t")){%>
<input type="button" name="yes" value="yes" id="buttonTemplate"
	class="cmnButton"
	onclick="submitForm('message','/hms/hms/investigation?method=showPrintResultEntry');" />
<%}else{ %> <input type="button" name="yes" value="Yes" class="cmnButton"
	onclick="submitForm('message','/hms/hms/investigation?method=printResultEntryReport');" />
<% }%> <input type="button" name="no" value="No" class="cmnButton"
	onClick="submitForm('message','<%=url%>','checkTargetForNo');" /></form>
</div>
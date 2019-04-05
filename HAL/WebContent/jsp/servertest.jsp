<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Header.jsp  
 * Purpose of the JSP -  This is for Header.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.7
--%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>



<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Hospital Management System</title>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hstyle.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />


</head>
<script type="text/javascript">
function adding(){
var status = document.getElementById('serverstatus').value;
if(status == 'y'){
server.method="post";	
submitForm('server','/hms/hms/login?method=addingNew');
}
}

function changeSerStatus(status){
document.getElementById('serverstatus').value = status;
}
</script>
<%
String serverstatus = "n";
Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	if (map.get("servertestStart") != null) {
		serverstatus = (String) map.get("servertestStart");
 		
 	}
%>
<form name="server" method="post">


<div class="titleBg">
<h2>Server Test</h2>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="serverstatus" id="serverstatus" value="<%=serverstatus%>"> 
<input type="button" name="serverstart" id="serverstart" class="button" value="Start" onclick="changeSerStatus('y')"> 
<input type="button" name="serverstop" id="serverstop" class="button" value="Stop" onclick="changeSerStatus('n')">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<script type="text/javascript">
	window.setInterval('adding()',1000);
</script>
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForResult.jsp  
 * Purpose of the JSP -  This is for ResultEntry
 * @author  Abha

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
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String url = "";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
Map<String,Object> infoMap = new HashMap<String,Object>();
if(map.get("messageTOBeVisibleToTheUser") !=null){
	message=""+map.get("messageTOBeVisibleToTheUser");
}
if(map.get("url") != null){
url = (String)map.get("url");
}
%>
<form name="messageResult" method="post"><br />
<h2><font id="error"><%=message %></font></h2>
<br />
<br />


<input type="button" name="yes" value="Yes" class="button" onclick="" />
<input type="button" name="no" value="No" class="button"
	onclick="submitForm('messageResult','/hms/hms/investigation?method=searchPatientForResultValidationOrderNo');" />
<input type="button" name="next" value="Next" class="button"
	onclick="submitForm('messageResult','/hms/hms/investigation?method=nextForResultValidation');" />
<input type="button" value="View Result" class="button"
	onClick="submitFormForButton('messageResult','/hms/hms/investigation?method=showReportCollectionJsp');" />
<br />
</form>

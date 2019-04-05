<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hospital.jsp  
 * Purpose of the JSP -  This is for All Hospital Master.
 * @author  Mansi
 * Create Date: 04 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@ page import="java.util.*"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<style>
#contentspace label {
	text-align: right;
	padding-right: 10px;
	width: 130px;
	float: left;
	height: 9px;
}
</style>


<div id="contentspace">
<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}


if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
	  }

%>
<form name="back" method="post" action="">




&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" name="Back"
	id="clearbutton" value="Back" class="button"
	onClick="submitForm('back','user?method=showUserHospitalMaintenanceJsp');"
	accesskey="a" tabindex=1 /></form>
</div>
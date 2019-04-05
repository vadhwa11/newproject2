<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for Lab Message.
 * @author  Naresh
 * Create Date: 5 March,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
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
String[] orderStatusMsg = null;


if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("orderStatusMsg") != null){
	orderStatusMsg = (String[])map.get("orderStatusMsg");
}


%>
<br />
<%if(orderStatusMsg != null){ 
	for(String msg : orderStatusMsg){%>
<label class="value"
	style="FONT-WEIGHT: bold; FONT-SIZE: 11px; COLOR: #F71818; width: 100%; text-align: center; float: right; font-family: Verdana, Arial, Helvetica, sans-serif;">
<%=msg%> </label>
<br />

<%	}
} %>

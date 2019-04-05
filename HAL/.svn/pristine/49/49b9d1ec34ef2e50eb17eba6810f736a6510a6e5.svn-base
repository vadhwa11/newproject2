<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * ajaxMessage.jsp  
 * Purpose of the JSP -  This is for Messages.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 17th Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4  
--%>


<%@ page import="java.util.*"%>
<%
Map map = new HashMap();
if(request.getAttribute("map") != null)
	map = (Map) request.getAttribute("map");
String message="";
if(map.get("message")!=null && !(map.get("message").equals(""))){
	message=(String)map.get("message");
}
out.println(message); %>

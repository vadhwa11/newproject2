<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Age.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	String consultationRoom = "";
	if(map.get("consultationRoom") != null){
		consultationRoom = (String)map.get("consultationRoom");
	}
	
%>
<div style="float: left;"><input type="text" name="CR" value=""
	maxlength="3" value="<%=consultationRoom %>" disabled="disabled">
<input type="hidden" name="<%=CONSULTATION_ROOM%>"
	value="<%=consultationRoom %>" maxlength="3" readonly="readonly">
</div>

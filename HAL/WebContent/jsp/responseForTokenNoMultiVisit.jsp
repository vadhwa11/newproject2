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
	
	String tokenMsg = "";
	int row = 0;
	
	if(map.get("tokenMsg") != null){
		tokenMsg = (String)map.get("tokenMsg");
		
		if(map.get("row") != null){
			row = (Integer)map.get("row");
		}
		
	
%>


    <label class="value" style="padding-left: 3px; margin-left: -2px;"><%=tokenMsg %></label> <input
	id="tokenNoId<%=row%>" type="hidden" name="<%=TOKEN_NO %><%=row%>"
	value="<%=tokenMsg %>" validate="Token no.,int,no" maxlength="3"
	class="readOnly">
<%}%>

<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * index.jsp  
 * Purpose of the JSP -  This is for index.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 11th Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@ page errorPage="error.jsp"%>
<%@ page import="java.util.Map"%>
<%@ page import="jkt.hms.masters.business.MasApplication"%>

<%@ include file="header.jsp"%>
<div class="clear"></div>
<%
        Map mainMap=(Map)request.getAttribute("map");
		String contentJsp=(String)mainMap.get("contentJsp").toString();
		if(contentJsp != null){  
%>
<%@ include file="navigation1.jsp"%>
<div class="clear"></div>
 <jsp:include page="<%=contentJsp%>" flush="true" />
<%}
		else{%>




<jsp:include page="newDefault.jsp" flush="true" />




<% 		}

%>

<%@ include file="footer.jsp"%>
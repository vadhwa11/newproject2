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
	String name = "";
	if(map.get("name") != null){
		name = (String)map.get("name");
%>
<label>Patient Name</label>
<input type="text" name="<%=PATIENT_NAME%>" value="<%=name %>"
	readonly="readonly" MAXLENGTH="15" />
<%}%>
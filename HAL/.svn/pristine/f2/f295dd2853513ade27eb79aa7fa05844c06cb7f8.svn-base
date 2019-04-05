<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp
 * Purpose of the JSP -  This is for ADT Message.
 * @author  Ritu
 * Create Date: 14th Jan,2008
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
int visitId=0;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("visitId")!=null){
	visitId = (Integer)map.get("visitId");
}
%>
<%
		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		 %>
<h2><%=message %></h2>
<%} %>
<div id="contentHolder">
<div class="Clear"></div>
<form name="patientAD" method="post">
<div class="Clear"></div>
<input name="Back" type="button" alt="Back" value="Back" class="button"
		onclick="submitForm('patientAD','opd?method=showOPDMainJsp&visitId=<%=visitId%>');"align="right" />
		<div class="Clear"></div>
</form>
</div>

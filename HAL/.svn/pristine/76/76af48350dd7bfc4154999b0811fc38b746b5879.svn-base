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
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/hms.js"></script>
<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
String serviceNo = "";
if (request.getParameter("serviceNo") != null) {
	serviceNo = (request.getParameter("serviceNo"));
}
System.out.println("serviceNo:::"+serviceNo);
%>
<form name="msgAmeLmc" method="post"><br />
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
<div class="blockFrame">
<label >AME:</label> 
	<input type="radio" id="ame" name="<%=AME_LMC %>" value="a"  class="radio" tabindex="1" checked="checked"/>
	<label >LMC:</label> 
	<input type="radio"	id="ame" name="<%=AME_LMC %>" value="l" class="radio" tabindex="1"/>
	<div class="Clear"></div>
	</div>
 <input type="button" name="yes" value="Yes" class="button"	onclick="submitForm('msgAmeLmc','/hms/hms/mis?method=printAmeLmc&serviceNo=<%=serviceNo %>','checkTargetForNo');" />
<input type="button" name="no" value="No" class="button"	onclick="submitForm('msgAmeLmc','/hms/hms/mis?method=showAfmsfAnnualMedicalExaminationjsp','checkTargetForNo');" />
</div>
</form>


<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for Birth Message.
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
int disposalId=0;
String formName = "";
String flag="";
int hinId=0;
String ad_no = "";
String messageType="";
String serviceNo ="";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}


if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
%>
<form name="messageMisBirth" target="_blank" method="post">
<div class="Block">
<%
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("serviceNo") != null){
	serviceNo = (String)map.get("serviceNo");
}
if(map.get("hinId") != null){
	hinId =Integer.parseInt(""+map.get("hinId")) ;
}
if(map.get("messageType") != null){
	messageType = (String)map.get("messageType");
}
if(map.get("disposalId") != null){
	disposalId = (Integer)map.get("disposalId");
}
if(map.get("ad_no") != null){
	ad_no = (String)map.get("ad_no");
}

%> 
<%if(!message.equals("")){
	if(messageType.equals("success")){
	%> <h4 class="auto"> <%=message %></h4>
<div class="Clear"></div>
<%}%> <%if(messageType.equals("failure")){%> <label class="auto">
<span><%=message %> </span> </label> <%}}%>

<div class="Clear"></div>
<input type="hidden" name="<%=HIN_ID%>" value="<%=hinId %>" /> 
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input
	type="button" name="yes" value="Print" class="button"
	onclick="submitForm('messageMisBirth','/hms/hms/mis?method=printFRW','checkTargetForYes');" />
<input type="button" name="no" value="Back" class="button"
	onclick="submitForm('messageMisBirth','/hms/hms/mis?method=showFrwCasesJsp','checkTargetForYes');" />
<input type="button" name="no" value="P M O " class="button"
	onclick="submitForm('messageMisBirth','/hms/hms/mis?method=printPMO&AdNo=<%=ad_no%>','checkTargetForYes');" />

<div class="Clear"></div>
<%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>
	<div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>
<jsp:include page="currentUserDetails.jsp"></jsp:include>
	
</form>


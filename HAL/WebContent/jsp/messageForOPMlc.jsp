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
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
String hinNo = "";
String adNo = "";
String backUrl = "";

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
if(map.get("backUrl") != null){
	backUrl = (String)map.get("backUrl");
}
String mlcNo ="";
if(map.get("mlcNo") != null){
	mlcNo = (String)map.get("mlcNo");
}
Box box = HMSUtil.getBox(request);

adNo=box.getString("adNo");
String backFlag = "";

if(map.get("backFlag") != null){
	backFlag = (String)map.get("backFlag");
}
%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%><form name="messageOpMcl" method="post">
<h4><span><%=message %></span></h4>

<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="yes" value="Yes" class="button" onClick="submitForm('messageOpMcl','adt?method=showMedicoLegalReport&mlcNo=<%=mlcNo%>');" />
<%
if(adNo.equals("")){
	if(backFlag.equals("OPD")){
%>
<input name="close" type="button" value="close" class="button" onclick="window.close();"/>
<%}else{ %>
<input type="button" name="no" value="No" class="button" onClick="submitForm('messageOpMcl','adt?method=showMlcJsp');" />
<%} %>
<%}else{ %>
<input type="button" name="no" value="No" class="button" onClick="submitForm('messageOpMcl','/hms/hms/ipd?method=showPatientListJsp');" />
<%} %>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="Clear"></div>
<%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>
<div class="clear"></div>
</form>

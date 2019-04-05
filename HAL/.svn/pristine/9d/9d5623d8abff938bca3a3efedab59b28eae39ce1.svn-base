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

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
String hinNo = "";
String adNo = "";
String backUrl = "";
String printUrl="";
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
if(map.get("printUrl") !=null){
	printUrl=""+map.get("printUrl");
}
%>
<form name="messageAdt" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>
<%
	if(!printUrl.equals("")){
%>
<div class="division"></div>
<input type="button" value="Print" class="button" onClick="submitForm('messageAdt','<%=printUrl%>');" />
<%} %>
<%
 
	if(map.get("hinNo") != null){
		
		hinNo = (String)map.get("hinNo");
		
%> 
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="yes" value="Yes" class="button"	onclick="submitForm('messageAdt','/hms/hms/registration?method=printRegistrationCard&hinNo=<%=hinNo %>','checkTargetForYes');" />
<input type="button" name="no" value="No" class="button"	onclick="submitForm('messageAdt','/hms/hms/registration?method=showRegistrationJsp','checkTargetForNo');" />
<div class="clear"></div>
<div class="division"></div>
<%} 

if(map.get("adNo") != null){
	adNo = (String)map.get("adNo");
	
%>
<div class="clear"></div>
<div class="division"></div>
 <input type="button" name="yes" value="Yes" class="button" onclick="submitForm('messageAdt','/hms/hms/adt?method=showIPAdmissionReport&adNo=<%=adNo %>');" />
 <%-- <input type="button" name="no" value="No" class="button"	onclick="submitForm('messageAdt','/hms/hms/adt?method=showAdmissionJsp','checkTargetForNo');" />--%>
 <input type="button" name="no" value="No" class="button"	onclick="submitForm('messageAdt','/hms/hms/adt?method=showPatientAdmissionJsp','checkTargetForNo');" />
 <!--
 <input type="button" name="SIL/DIL" value="SIL/DIL" class="button"	onClick="submitForm('messageAdt','/hms/hms/adt?method=showSiDiReport&<%=AD_NO%>=<%=adNo%>');" />
 <input type="button" name="Label_Print" value="Label Print" class="button"	onClick="submitForm('messageAdt','/hms/hms/adt?method=showLabelReport&<%=AD_NO%>=<%=adNo%>');" />
 
--><%} %> <%
if(map.get("uadNo") != null){
	adNo = (String)map.get("uadNo");
%> <input type="button" name="yes" value="Yes" class="button"	onclick="submitForm('messageAdt','/hms/hms/adt?method=showIPAdmissionReport&adNo=<%=adNo %>','checkTargetForYes');" />
<input type="button" name="no" value="No" class="button"	onclick="submitForm('messageAdt','/hms/hms/adt?method=showUpdateSearchJsp&jsp=admission','checkTargetForNo');" />
<%} %> <%
if(formName != ""){
%>
<input type="button" value="Close" class="button"	onclick="window.close()"> <%} %>

</form>

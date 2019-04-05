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
int hinId = 0;
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
int visitId = 0;
if(map.get("visitId") != null){
	visitId = (Integer)map.get("visitId");
}
%>
<form name="messageFwc" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>
<%
String chieldGender="";
if(map.get("chieldGender") != null){
	chieldGender= (String)map.get("chieldGender");
	System.out.println("chieldGender--in jsp-->"+chieldGender);
}
	
	if(map.get("hinId") != null){
		
		hinId = (Integer)map.get("hinId");
		
%> 
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="yes" value="Yes" class="button"	onclick="submitForm('messageFwc','/hms/hms/fwc?method=printpediatricCardTest&hinId=<%=hinId %>&visitId=<%=visitId %>&chieldGender=<%=chieldGender %>','checkTargetForYes');" />
<input type="button" name="no" value="No" class="button" onclick="submitForm('messageFwc','/hms/hms/fwc?method=showWaitingPatientListJsp','checkTargetForNo');" />

<%if(chieldGender.equals("Female")){ %>
<input type="button" class="buttonBig2" value="Weight for age Girls" onClick="submitForm('messageFwc','fwc?method=printHealthCard&hinId=<%=hinId %>&visitId=<%=visitId %>');" />
<input type="button" class="buttonBig2" value="Length/Height for age Girls" onClick="submitForm('messageFwc','fwc?method=printHealthCardHeight&hinId=<%=hinId %>&visitId=<%=visitId %>');" />
<input type="button" class="buttonBig2" value="Head Circumference for age Girls" onClick="submitForm('messageFwc','fwc?method=printHealthCardHeadCircumference&hinId=<%=hinId %>&visitId=<%=visitId %>');" />
<%}else{ %>
<input type="button" class="buttonBig2" value="Weight for age Boys" onClick="submitForm('messageFwc','fwc?method=printHealthCardB&hinId=<%=hinId %>&visitId=<%=visitId %>');" />
<input type="button" class="buttonBig2" value="Length/Height for age Boys" onClick="submitForm('messageFwc','fwc?method=printHealthCardHeightB&hinId=<%=hinId %>&visitId=<%=visitId %>');" />
<input type="button" class="buttonBig2" value="Head Circumference for age Boys" onClick="submitForm('messageFwc','fwc?method=printHealthCardHeadCircumferenceB&hinId=<%=hinId %>&visitId=<%=visitId %>');" />

<%} %>


<div class="clear"></div>
<div class="division"></div>
<%} %>

 <%
if(formName != ""){
%>
<input type="button" value="Close" class="button"	onclick="window.close()"> <%} %>

</form>

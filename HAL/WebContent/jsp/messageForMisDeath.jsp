<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for Birth Message.
 * @author  Diapli
 * Create Date: 26 April,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String message1="";
String formName = "";
String flag="";
int inpatientId=0;
String adNo = "";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("inpatientId") != null){
	inpatientId = (Integer)map.get("inpatientId");
}
if(map.get("flag") != null){
	flag = (String)map.get("flag");
}

if(map.get("formName") != null){
	formName = (String)map.get("formName");
	
}
%>
<form name="messageMisDeath" target="_blank" method="post"><br />
<%
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("message1") != null){
	message1 = (String)map.get("message1");
}
if(!message.equals("false")){%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message %>
</div>
</div>
<input type="button" name="no" value="Back" class="button"
	onclick="submitForm('messageMisDeath','/hms/hms/mis?method=showDeathCertificateJsp');" />

<%}else if(!message1.equals("false")){%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message1%>
</div>
</div>
<input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('messageMisDeath','/hms/hms/mis?method=showBirthDeathCertificate&inpatientId=<%=inpatientId %>&flag=<%=flag%>','checkTargetForYes');" />
<input type="button" name="no" value="No" class="button"
	onclick="submitForm('messageMisDeath','/hms/hms/mis?method=showDeathCertificateJsp','checkTargetForNo');" />
<%}	%> <br />


<br />
<%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>
</form>

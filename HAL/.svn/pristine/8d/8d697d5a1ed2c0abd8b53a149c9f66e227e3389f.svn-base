<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForResult.jsp  
 * Purpose of the JSP -  This is for ResultEntry
 * @author  Abha

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
String url = "";
int deptId= 0;

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
Map<String,Object> infoMap = new HashMap<String,Object>();
if(map.get("messageTOBeVisibleToTheUser") !=null){
	message=""+map.get("messageTOBeVisibleToTheUser");
}
if(map.get("url") != null){
url = (String)map.get("url");
}
if(session.getAttribute("deptId") != null){
	deptId = (Integer)session.getAttribute("deptId");
}
%>
<%
String resultType="";
String resultNo="";
	if(map.get("resultNo") != null){
		resultNo = (String)map.get("resultNo");
	}
	if(map.get("resultType") != null){
		resultType = (String)map.get("resultType");
		System.out.println("resultType"+resultType);
	}
	int resultId=0;
	if(map.get("resultId")!= null){
		resultId= (Integer)map.get("resultId");
	}
%>
<div id="contentHolder">
<form name="messageResult" method="post" target="_blank"><br />
<br />
<h5><%=message %></h5>
<div class="Clear"></div>


<%if(resultType.equalsIgnoreCase("t")) {%> <input type="button" name="yes"
	value="Yes" class="cmnButton"
	onclick="submitForm('messageResult','/hms/hms/investigation?method=showPrintResultValidation&resultNo=<%=resultNo %>&resultType=<%=resultType %>');" />
<% }else{%> <input type="button" name="yes" value="Yes" class="cmnButton"
	onclick="submitForm('messageResult','/hms/hms/investigation?method=printResultValidationReport&resultNo=<%=resultNo %>&resultType=<%=resultType %>');" />
<%} %> <input type="button" name="no" value="No" class="cmnButton"
	onclick="submitForm('messageResult','/hms/hms/investigation?method=searchPatientForResultValidationLab','checkTargetForNo');" />
<input type="button" name="next" value="Next" class="cmnButton"
	onclick="submitForm('messageResult','/hms/hms/investigation?method=nextForResultValidation&resultId=<%=resultId %>','checkTargetForNo');" />

<input type="button" value="Report Delivery" class="cmnButton"
	onClick="submitFormForButton('messageResult','/hms/hms/investigation?method=showReportCollectionJsp','checkTargetForNo');" />
<br />
</form>
</div>

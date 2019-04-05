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
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
String hinNo = "";
String adNo = "";
String backUrl = "";
int inpatientId =0;
String andNo="";
String deptName="";
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

if(map.get("andNo") != null){
	andNo = (String)map.get("andNo");
}
if(map.get("deptName") != null){
	deptName = (String)map.get("deptName");
}
if(map.get("hinNo") != null){
	hinNo = (String)map.get("hinNo");
}
if(map.get("inpatientId") != null){
	inpatientId = Integer.parseInt(""+map.get("inpatientId")) ;
}
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currenDate = (String) utilMap.get("currentDate");
%>
<form name="silDilStatusMessage" method="post"><input
	type="hidden" name="<%=ADMISSION_NUMBER %>" value="<%=andNo%>" /> <input
	type="hidden" name="deptName" value="<%=deptName%>" /> <input
	type="hidden" name="<%=FROM_DATE%>" value="<%=currenDate%>" /> <input
	type="hidden" name="<%=TO_DATE%>" value="<%=currenDate%>" />

<h4><%=message %></h4>
<div class="Clear"></div>

<input type="button" name="yes" value="Yes" class="button"	onClick="submitForm('silDilStatusMessage','/hms/hms/ipd?method=showIntakeOutputChartReport&reportType=summary&adNo=<%=andNo%>&<%=HIN_NO%>=<%=hinNo%>');" />
<input type="button" name="no" value="No" class="button"	onclick="submitForm('silDilStatusMessage','/hms/hms/ipd?method=showPatientListJsp');" />
<div class="Clear"></div>
</form>

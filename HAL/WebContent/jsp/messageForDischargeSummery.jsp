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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
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
String serviceNo = "";
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
if(map.get("serviceNo") != null){
	serviceNo = (String)map.get("serviceNo");
}
%>
<form name="silDilStatusMessage" method="post">
<input type="hidden" name="parent"	value="<%=andNo%>" />
<input type="hidden" name="deptName"	value="<%=deptName%>" />
<h4><%=message%></h4>
<div class="Clear"></div>
<input type="button" name="yes" value="Yes" class="buttonSm" onClick="submitFormForCaseSheetReport()" />
<input type="button" name="no" value="No" class="buttonSm" onclick="submitForm('silDilStatusMessage','/hms/hms/ipd?method=showPatientListJsp');" />
</form>
<script>
function submitFormForCaseSheetReport(){
	submitForm('silDilStatusMessage','discharge?method=showDischargeSummaryReport&adNo=<%=andNo%>','checkTargetForYes');
	checkTargetForNo();
}
</script>
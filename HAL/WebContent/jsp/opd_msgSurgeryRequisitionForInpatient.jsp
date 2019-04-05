<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * opd_msgSurgeryRequisitionForInpatient.jsp  
 * Purpose of the JSP -  This is for OT Message.
 * @author  Dipali
 * Create Date: 1st Jan,2009
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>



<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script> 
	
<script type="text/javascript">

function showBack(formName)
{
  obj = eval('document.'+formName)
  //obj.action = "/hms/hms/opd?method=showOPDPatientSearchJsp";
  obj.action = "/hms/hms/opd?method=showSurgeryRequisitionJspFromPatientList1";
  obj.submit();
}
</script>
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
int orderNo = 0;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("orderNo") != null && !map.get("orderNo").equals("")){
	orderNo = (Integer)map.get("orderNo");
}
%>
<form name="message" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Clear"></div>
<div class="division"></div>
<h4><span><%=message%></span></h4>
<div class="division"></div>
<input type="button" name="yes" value="Yes" class="button"	onclick="submitForm('message','/hms/hms/opd?method=printSurgeryRequisitionForInPatient&orderNo=<%=orderNo %>');" />
<input type="button" name="no" class="button" value="No" onclick="submitFormForButton('message','/hms/hms/ipd?method=showPatientListJsp');" /></form>

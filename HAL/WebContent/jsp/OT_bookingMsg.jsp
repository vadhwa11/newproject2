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
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hstyle.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />

<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript">

function showBack(formName)
{
  checkTargetForNo();
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=showPACClearanceList";
  obj.submit();
}
</script>
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
int orderNo = 0;
int hinId=0;
String pastRecords="";
String presentHistory="";
String drugTherapy="";
int bookingId=0;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("bookingId") != null){
	bookingId = (Integer)map.get("bookingId");
}
%>
<div id="contentHolder">
<form name="message" method="post">
<div class="Clear"></div>
<div class="division"></div>
<h4><span><%=message%></span></h4>
<div class="division"></div>
<%-- <div class="bottom"><input type="button" name="yes" value="Yes"
	class="button"
	onclick="submitForm('message','/hms/hms/ot?method=printPAC&orderNo=<%=orderNo %>&pastRecords=<%=pastRecords.trim()%>&presentHistory=<%=presentHistory.trim()%>&drugTherapy=<%=drugTherapy.trim()%>','checkTargetForYes');" />
<input type="button" name="no" class="button" value="No"
	onclick="showBack('message')" /></div> --%>
	<input type="button" name="yes" value="Print"	class="button"	onclick="submitForm('message','/hms/hms/ot?method=generateSurgeryDetailsPrint&bookingId=<%=bookingId %>');" />
</form>
</div>
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
  obj.action = "/hms/hms/ot?method=showOtPostAnaesthesiaPatientSearchJsp";
  obj.submit();
}
</script>
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String YearlySrNo = "";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("yearlySlNo") != null){
	YearlySrNo = (String)map.get("yearlySlNo");
}
int postAnaesthesiaProcedureId=0;
if(map.get("postAnaesthesiaProcedureId") != null){
	postAnaesthesiaProcedureId = (Integer)map.get("postAnaesthesiaProcedureId");
}
%>
<div id="contentHolder">
<form name="message" method="post" action="">
<div class="Clear"></div>
<div class="division"></div>
<h4><span><%=message%></span></h4>
<div class="division"></div>
<%-- <div class="bottom"><input type="button" name="yes" value="Yes"
	class="button"
	onclick="submitForm('message','/hms/hms/ot?method=printOtPostAnesthesiaProcedureReport&yearlySlNo=<%=YearlySrNo %>','checkTargetForYes');" />
<input type="button" name="no" class="button" value="No"
	onclick="showBack('message')" /></div> --%>
	<input type="button" name="yes" value="Print"	class="button"	onclick="submitForm('message','/hms/hms/ot?method=generateOtPostAnesthesiaProcedurePrint&mainId=<%=postAnaesthesiaProcedureId %>');" />
	
</form>
</div>
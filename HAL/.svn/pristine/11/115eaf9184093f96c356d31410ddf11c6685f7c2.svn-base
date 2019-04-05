
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
Map<String, Object> map = new HashMap<String, Object>();
String formName = "";
String hinNo = "";
String entryNo = "";

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
if(map.get("entrySeqNo") != null){
	entryNo = (String)map.get("entrySeqNo");
}
%>
<% 

String message ="";
if (map.get("message") != null) {
             message = (String) map.get("message");
      }
if(!message.equalsIgnoreCase("")){
 %>
<h2><%=message %></h2>
<%} %>
<form name="msgCoveringLetter" method="post">

<div id="contentHolder">
<div class="Clear"></div>
<input type="hidden" name="back" class="cmnButton"
	value="PrintGeneralCoveringLetter"
	onclick="submitForm('msgCoveringLetter','/hms/hms/mediClaim?method=printReimbursementmedicalClaim&entryNo=<%=entryNo %>','checkTargetForYes');" />
<input type="button" name="back" class="cmnButton" value="Back"
	onclick="submitForm('msgCoveringLetter','/hms/hms/mediClaim?method=showGeneralClaimCoveringLetter');" />

<%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>
</div>
</form>

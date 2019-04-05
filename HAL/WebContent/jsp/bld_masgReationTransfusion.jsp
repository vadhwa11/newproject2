
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
%>
<form name="msgReqEntry" method="post">
<% 
	if (map.get("message") != null) {
             message = (String) map.get("message");
      }
	if(!message.equalsIgnoreCase("")){

%>
<h2><%=message %></h2>
<%} %>
<div id="contentHolder">
<div class="Clear"></div>
<input type="button" name="back" value="Back" class="cmnButton"
	onclick="submitForm('msgReqEntry','/hms/hms/bloodBank?method=showPendingForTransfussionReaction','checkTargetForNo');" />
<%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>
</div>

</form>

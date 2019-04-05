<%----Message Jsp for board(MID) by dipali --%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
%>
<form name="messageBoard" method="post">
<div class="clear"></div>
<h4><%=message %></h4>

<input name="Back" type="button" value="Back" class="button" 
	onclick="submitForm('messageBoard','/hms/hms/medicalBoard?method=showMidData');"/>
	<div class="clear"></div>
</form>

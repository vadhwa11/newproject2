<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}String message="";
if(map.get("message") != null){
	message = (String)map.get("message");
}

%>

<form name="sroEntry" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>

<input type="button" name="Yes" value="Yes" onclick="submitForm('sroEntry','/hms/hms/mis?method=printSroEntry');" />
<input type="button" name="No" value="No" class="button"	onclick="submitForm('sroEntry','/hms/hms/mis?method=showSanitaryDefectNotes');" />

<div class="clear"></div>
<div class="division"></div>
</form>
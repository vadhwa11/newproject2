<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
String message="";
if(map.get("message") != null){
	message = (String)map.get("message");
}
//int hinId=(Integer) map.get("hinId");
//System.out.println("hinId in message for notification"+hinId);
%>

<form name="messageForIndentToDepot" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>

<!--<input type="button" name="Yes" value="Yes" onclick="submitForm('messageForFreeFromInfection','/hms/hms/mis?method=printmessageForVectorControl');" />
-->
<input type="button" name="No" value="Back" class="button"	onclick="submitForm('messageForIndentToDepot','/hms/hms/nonExp?method=showIndentJspSOC');" />
<div class="clear"></div>
<div class="division"></div>
</form>
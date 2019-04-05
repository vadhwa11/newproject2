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
int hinId=(Integer) map.get("hinNumber");
System.out.println("hinId in message for notification-->"+hinId);

int notifiableId = 0;
if(map.get("notifiableId")!=null)
{
	notifiableId= (Integer)map.get("notifiableId");
}
%>

<form name="notifiableDisease" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="notifiableId" value="<%=notifiableId%>" />
<input type="button" name="Yes" value="Yes" onclick="submitForm('notifiableDisease','/hms/hms/mis?method=printNotifiableDisease');" />
<input type="button" name="No" value="No" class="button"	onclick="submitForm('notifiableDisease','/hms/hms/mis?method=showNotifiableDiseaseJsp');" />
<input type="hidden" name="hinId" value=<%=hinId%> />
<div class="clear"></div>
<div class="division"></div>
</form>
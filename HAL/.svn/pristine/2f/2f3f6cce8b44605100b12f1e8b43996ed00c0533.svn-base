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

int vId = 0;
if(map.get("vId")!=null)
{
	vId= (Integer)map.get("vId");
}
%>

<form name="form44" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="vId" value="<%=vId%>" />
<input type="button" name="Yes" value="Yes" onclick="submitForm('form44','/hms/hms/medicalExam?method=showForm44Report');" />
<input type="button" name="No" value="No" class="button"	onclick="history.back();" />
<input type="hidden" name="hinId" value=<%=hinId%> />
<div class="clear"></div>
<div class="division"></div>
</form>
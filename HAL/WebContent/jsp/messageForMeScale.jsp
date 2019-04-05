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
int meScaleNumber = 0;
if(map.get("meScaleNumber") != null){
	meScaleNumber = (Integer)map.get("meScaleNumber");
}
//int hinId=(Integer) map.get("hinId");
//System.out.println("hinId in message for notification"+hinId);
%>

<form name="messageForMeScale" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="meScaleNumber" value="<%=meScaleNumber %>">

<input type="button" name="Yes" value="Yes" onclick="submitForm('messageForMeScale','/hms/hms/neStores?method=printForMeScaleReport');" />

<input type="button" name="No" value="Back" class="button"	onclick="submitForm('messageForMeScale','/hms/hms/neStores?method=viewMeScaleJsp');" />
<div class="clear"></div>
<div class="division"></div>
</form>
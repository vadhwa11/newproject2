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

int accidentId=0;
if(map.get("accidentId") != null){
	accidentId = (Integer)map.get("accidentId");
	System.out.println("accidentId--JSp->"+accidentId);
}
//int hinId=(Integer) map.get("hinId");
//System.out.println("hinId in message for notification"+hinId);
%>

<form name="messageForAccidentalDetail" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>

<input type="hidden" name="accidentId" value="<%=accidentId%>" />

<input type="button" name="Yes" value="Print" onclick="submitForm('messageForAccidentalDetail','/hms/hms/mis?method=printPerformaAccidentDetail');" />

<input type="button" name="No" value="Back" class="button"	onclick="history.back();" />

<div class="clear"></div>
<div class="division"></div>
</form>
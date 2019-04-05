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
int suicideId=0;
if(map.get("suicideId") != null){
	suicideId = (Integer)map.get("suicideId");
	System.out.println("suicideId--jsp->"+suicideId);
}
%>

<form name="caseOfAttemptSuicide" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<!--<input type="button" name="Yes" value="Print" onclick="submitForm('caseOfAttemptSuicide','/hms/hms/mis?method=printAttamptSuicideDetail');" />
<input type="button" name="No" value="No" class="button"	onclick="history.back();" />

--><div class="clear"></div>
<div class="division"></div>
</form>
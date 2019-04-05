<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null)
{
	map = (Map<String, Object>)request.getAttribute("map");
}String message="";
if(map.get("message") != null){
	message = (String)map.get("message");
}
int visitId =0;
if(map.get("visitId") != null)
{
	visitId = (Integer)(map.get("visitId"));	
}

%>

<form name="messageForPerusingAuthority" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>
<input type="button" name="Yes" value="Yes" onclick="submitForm('messageForPerusingAuthority','/hms/hms/medicalBoard?method=generateProceedingInitialAFMSFReport&visitId=<%=visitId%>');" />
<input type="button" name="No" value="No" class="button"	onclick="submitForm('messageForPerusingAuthority','/hms/hms/medicalBoard?method=showMedicalBoardPerusingAuthority');" />

<div class="clear"></div>
<div class="division"></div>
</form>
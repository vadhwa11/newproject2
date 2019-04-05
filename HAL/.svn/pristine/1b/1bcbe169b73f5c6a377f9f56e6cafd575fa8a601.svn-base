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
<form name="messageMedicalExamRejectedPA" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>
<input type="button" name="yes" value="Back" class="button"	onclick="submitForm('messageMedicalExamRejectedPA','/hms/hms/medicalExam?method=showMedicalExamPerAuthority');" />
<div class="clear"></div>
<div class="division"></div>
</form>
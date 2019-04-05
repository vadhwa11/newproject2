<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date" %>
<%
Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}String message="";
if(map.get("message") != null){
	message = (String)map.get("message");
}
String activityDate = "";
if(map.get("activityDate")!= null)
  {
	activityDate = (String)map.get("activityDate");
	
  } 

%>

<form name="activityDetail" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>

<input type="button" name="Yes" value="Yes" onclick="submitForm('activityDetail','/hms/hms/mis?method=printActivityDetail&activityDate=<%=activityDate %>');" />
<input type="button" name="No" value="No" class="button"	onclick="submitForm('activityDetail','/hms/hms/mis?method=showActivityAgainstHiv');" />

<div class="clear"></div>
<div class="division"></div>
</form>
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
int feedBackId=0;
if(map.get("feedBackId")!=null)
{
	feedBackId= (Integer)map.get("feedBackId");
}
%>

<form name="feedBackCounselor" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="feedBackId" value="<%=feedBackId%>" />
		

<input type="button" name="Yes" value="Print" onclick="submitForm('feedBackCounselor','/hms/hms/mis?method=printFeedBackCounselorDetail');" />

<input type="button" name="No" value="No" class="button" onclick="history.back();" />

<div class="clear"></div>
<div class="division"></div>
</form>
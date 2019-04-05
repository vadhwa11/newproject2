<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<%
Map<String,Object> map = new HashMap<String,Object>();
String message="";
String url="";
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
if(map.get("message") !=null){
	message=""+map.get("message");
}
if(map.get("url") !=null){
	url=""+map.get("url");
}
%>

<form name="message" method="post">
<div id="contentHolder">
<h6>&nbsp;</h6>
<div class="Clear"></div>
<h5><span><%=message %></span></h5>
<div class="Clear"></div>
<input type="button" value="Back" class="cmnButton"
	onClick="submitForm('message','<%=url%>');" /></div>
</form>

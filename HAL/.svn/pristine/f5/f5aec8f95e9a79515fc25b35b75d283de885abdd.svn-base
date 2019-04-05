
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	String message = "";
	String formName = "";
	String hinNo = "";
	int id=0;
	int entryNo = 0;
	
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>)request.getAttribute("map");
	}
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	if(!message.equalsIgnoreCase("")){
	%>
<h4><%=message %></h4>

<%} %>
<form name="message" method="post">
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>	

<input class=button id=back accessKey=b	onClick="javascript:history.back()" tabindex="1" type=button value=Back	name=back />


	
</form>

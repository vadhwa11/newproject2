<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 

	System.out.println("message jsp");
	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	String url="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		message=""+map.get("messageTOBeVisibleToTheUser");
	}
	
%>
<div id="contentspace">
<form name="message" method="post"><br />
<h2 align="left" class="style1"><%=message %></h2>
<input type="button" value="Close" class="button"
	onClick="window.close();" /></form>
</div>
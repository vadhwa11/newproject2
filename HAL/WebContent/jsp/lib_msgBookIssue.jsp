
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	String message = "";
	String formName = "";
	String hinNo = "";
	String adNo="";
	int entryNo = 0;
	
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>)request.getAttribute("map");
	}
		if(map.get("message") !=null){
		message=""+map.get("message");
	}
	
	%>



<form name="message" method="post">
<div id="contentHolder">
<h6>&nbsp;</h6>
<div class="Clear"></div>
<h5><span><%=message %></span></h5>
<div class="Clear"></div>
<input type="button" name="back" value="back" class="cmnButton"
	onclick="submitForm('message','/hms/hms/lib?method=showBookIssueJsp');" />
<div class="Clear"></div>

</div>
</form>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 

	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	String url="";
	String printUrl="";
	boolean appointmentFlag = false;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	int physioRequisitionHeaderId = 0;
	
	if(map.get("message") !=null){
		message=""+map.get("message");
	}

	
	int hinId = 0;
	if(map.get("hinId")!=null){
		hinId = (Integer)map.get("hinId");
	}
	
	
%>
<form name="message" method="post">
<div class="clear"></div>
<div class="division"></div>


<h4><%=message %></h4>
<input type="button" class="button" value="Back" align="right" onClick="submitForm('message','/hms/hms/fwc?method=showRegForIUD')" />
</form>

<div class="clear"></div>

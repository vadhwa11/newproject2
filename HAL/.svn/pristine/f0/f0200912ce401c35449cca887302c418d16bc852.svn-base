<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 

	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	String url="";
	String printUrl="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	if(map.get("message") !=null){
		message=""+map.get("message");
	}
	int appointmentHeaderId = 0;
	if(map.get("appointmentHeaderId")!=null){
		appointmentHeaderId = (Integer)map.get("appointmentHeaderId");
	}

%>
<form name="message" method="post">
<h4><%=message %></h4>
<div class="clear"></div>
<div class="division"></div>

<input type="button" value="Injection Appointment" class="buttonBig" onClick="submitForm('message','/hms/hms/registration?method=showInjectionAppointment&flag=afterSave&appointmentId=<%=appointmentHeaderId %>');" />

</form>
<div class="clear"></div>
<div class="division"></div>
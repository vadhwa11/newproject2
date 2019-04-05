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

	if(map.get("physioRequisitionHeaderId")!=null){
		physioRequisitionHeaderId = (Integer)map.get("physioRequisitionHeaderId");
	}
	if(map.get("appointmentFlag") != null){
		appointmentFlag = (Boolean)map.get("appointmentFlag");
	}
	int hinId = 0;
	if(map.get("hinId")!=null){
		hinId = (Integer)map.get("hinId");
	}
	String msg = "";
	msg = "Do You want to take Appointment.";
	String flag = "";
	if(map.get("flag") != null){
		flag = (String)map.get("flag");
	}
	
%>
<form name="message" method="post">
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="flag" value="<%=flag %>">
<input type="hidden" name="physioRequisitionHeaderId" value="<%=physioRequisitionHeaderId %>">
<%if(flag.equals("OPD")){ %>
<%if(appointmentFlag){ %>
<h4><%=message %></h4>
<input type="button" value="Appointment" class="buttonBig" onClick="submitForm('message','/hms/hms/physiotherapy?method=showPhysiotherapyAppointmentJsp&physioRequisitionHeaderId=<%=physioRequisitionHeaderId %>');" />
<%}else{ %>
<h4><%=message %></h4>
<%} %>
<%}else{ %>
<h4><%=message+""+msg %></h4>
<input type="button" value="Yes" class="button" onClick="submitForm('message','/hms/hms/physiotherapy?method=showPhysiotherapyAppointmentJsp&hinId=<%=hinId %>');" />
<input type="button" value="No" class="button" onClick="submitForm('message','/hms/hms/physiotherapy?method=showDirectTherapyVisitEntryJps&hinId=<%=hinId %>');" />
<%} %>
</form>
<div class="clear"></div>

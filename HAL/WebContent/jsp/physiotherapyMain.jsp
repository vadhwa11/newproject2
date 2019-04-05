


<%@page import="java.util.*"%>
<form name="physiotherapyMain" method="post">

	<div class="titleBg">
	<h2>Physiotherapy </h2></div>
	<div class="clear"></div>
<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
int visitId = 0;
if(map.get("visitId")!=null){
	visitId = (Integer)map.get("visitId");
}

%>
	
<div class="Block">
			<label>Visit Entry</label>
		  <input type="radio" name="phy" value="visit" onclick="submitForm('physiotherapyMain','/hms/hms/physiotherapy?method=showPhysiotherapyJsp&visitId=<%=visitId %>')">
		
		<label>Next Appointment</label>
		<input type="radio" name="phy" value="apptmnt" onclick="submitForm('physiotherapyMain','/hms/hms/physiotherapy?method=showPhysiotherapyAppointmentJsp&visitId=<%=visitId %>')">
		
	</div>
	</form>
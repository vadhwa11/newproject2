<%@page import="java.util.Map"%>
<%@page import="java.util.*" %>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	String message = "";
	String formName = "";
	String hinNo = "";
	String data = "";

	int medExamId=0;
	int entryNo = 0;
	int visitId=0;
	String hinNoForreport=null;
	int visitNumberForReport=0;
	String serviceNoForReport=null;
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>)request.getAttribute("map");
	}
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	int hin_id=0;
	if(map.get("hin_id") != null)
	  {
		hin_id= (Integer)map.get("hin_id");
	  }
	

	if(map.get("formName") != null){
		formName = (String)map.get("formName");
	}
	if (map.get("message") != null) {
	             message = (String) map.get("message");
	 }
	if (map.get("serviceNo") != null) {
		serviceNoForReport = (String) map.get("serviceNo");

		 System.out.println("serNo--->"+serviceNoForReport);
 	}
	if (map.get("hinNoForreport") != null) {
		hinNoForreport = (String) map.get("hinNoForreport");
 	}
	if (map.get("data") != null) {
		data = (String) map.get("data");
 	}
	if (map.get("visitNumberForReport") != null) {
		visitNumberForReport = (Integer) map.get("visitNumberForReport");
 	}
	if (map.get("visitId") != null) {
		visitId = (Integer) map.get("visitId");
 	}
	String dgOrderNO="";
	 if (map.get("dgOrderNO") != null) {
		 dgOrderNO = (String) map.get("dgOrderNO");
	}
	String admissionStatus="n";
	if (map.get("admissionStatus") != null) {
		admissionStatus = (String) map.get("admissionStatus");
	}
	String directFlag="";
	if (map.get("directFlag") != null) {
		directFlag = (String) map.get("directFlag");
	}
	if(map.get("medExamId") != null){
		medExamId = (Integer)map.get("medExamId");
	}

	if(!message.equalsIgnoreCase("")){
%>	
<h2><%=message %></h2>
<%} %>
<form name="message" method="post">
<h2>Do you want to Print</h4>
 <input type="button" name="report" class="button" id="report" value="Ok" accesskey="a"
 onclick="submitForm('message','medicalBoard?method=printMedicalBoardForm10&medExamId=<%=medExamId %>&visitId=<%=visitId%>');"/>
</form>


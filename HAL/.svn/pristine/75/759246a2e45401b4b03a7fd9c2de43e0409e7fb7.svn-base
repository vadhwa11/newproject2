<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
String hinNo = "";
int id=0;
int entryNo = 0;
int visitId=0;
int medExamId=0;
String hinNoForreport=null;
int visitNumberForReport=0;
String serviceNoForReport=null;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
if (map.get("message") != null) {
             message = (String) map.get("message");
      }
if (map.get("serviceNo") != null) {
	serviceNoForReport = (String) map.get("serviceNo");
}
if (map.get("hinNoForreport") != null) {
	hinNoForreport = (String) map.get("hinNoForreport");
	System.out.println("jsp  hinNoForreport---"+hinNoForreport);
}
if (map.get("visitNumberForReport") != null) {
	visitNumberForReport = (Integer) map.get("visitNumberForReport");
}
if (map.get("visitId") != null) {
	visitId = (Integer) map.get("visitId");
}
if(map.get("medExamId")!= null){
	medExamId = (Integer)map.get("medExamId");
	
}
String dgOrderNO="";
if (map.get("dgOrderNO") != null) {
 dgOrderNO = (String) map.get("dgOrderNO");
}

%>
<form name="messageForPrimaryExtension" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>
<label class="large2">Certificates regarding night blindness</label>
<input type="checkbox" id="NightBlindness" name="NightBlindness" value="nb" tabindex="1" />
<input type="hidden" name="NightBlindness" id="NightBlindness" value="nb" />

<div class="clear"></div>
<label class="large2">Medical Interrogation form for recruitment to Air Force</label>
<input type="checkbox" id="Interrogationform" name="Interrogationform" value="if" tabindex="1">
<input type="hidden" name="Interrogationform" id="Interrogationform" value="if" />
<div class="clear"></div>
<label class="large2">Certificate by candidate prior to recruitment Medical Exam</label>
<input type="checkbox" id="PriorRecruit" name="PriorRecruit" value="pr" tabindex="1">
<input type="hidden" name="PriorRecruit" id="PriorRecruit" value="pr" />
<div class="clear"></div>
<input type="button" name="yes" value="Print" class="button"	onclick="submitForm('messageForPrimaryExtension','/hms/hms/medicalExam?method=printPrimaryExtensionReport&medExamId=<%=medExamId %>&order_no=<%=dgOrderNO %>');" />
<input type="button" name="no" value="No" class="button"	onclick="submitForm('messageForPrimaryExtension','/hms/hms/medicalExam?method=showMedicalExamPerAuthority');" />
</form>
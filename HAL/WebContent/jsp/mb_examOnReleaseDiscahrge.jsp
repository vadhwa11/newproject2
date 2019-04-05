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
<form name="messageForExamOnReleaseDischarge" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="yes" value="Yes" class="button"	onclick="submitForm('messageForExamOnReleaseDischarge','/hms/hms/medicalExam?method=printExamOnReleaseDischarge&medExamId=<%=medExamId %>&order_no=<%=dgOrderNO %>');" />
<input type="button" name="no" value="No" class="button"	onclick="submitForm('messageForExamOnReleaseDischarge','/hms/hms/medicalExam?method=showMedicalExamPerAuthorityAFRO');" />
<div class="clear"></div>
<div class="division"></div>

</form>

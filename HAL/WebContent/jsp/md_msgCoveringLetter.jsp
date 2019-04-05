
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
Map<String, Object> map = new HashMap<String, Object>();
String formName = "";
String hinNo = "";
String entryNo = "";
int contingentHdId=0; 
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
if(map.get("entrySeqNo") != null){
	entryNo = (String)map.get("entrySeqNo");
}
if(map.get("covering_hd_id") != null && !map.get("covering_hd_id").equals("")){
	contingentHdId = (Integer)map.get("covering_hd_id");
}
String message ="";
if (map.get("message") != null) {
             message = (String) map.get("message");
      }
if(!message.equalsIgnoreCase("")){
 %>
<h4><%=message %></h4>
<%} %>
<form name="msgCoveringLetter" method="post">

<div class="Clear"></div>
<input type="button" name="print" class="buttonBig2"
	value="Print Advance Covering Letter"
	onclick="submitForm('msgCoveringLetter','/hms/hms/mediClaim?method=printCoveringLetter&coveringHdId=<%=contingentHdId %>');" />
<input type="button" name="back" class="cmnButton" value="Back"
	onclick="submitForm('msgCoveringLetter','/hms/hms/mediClaim?method=showPatientForCoveringLetterUnit');" />

<%
if(formName != ""){
%> <input type="button" value="Close" class="button" onclick="window.close()"> <%} %>
</form>

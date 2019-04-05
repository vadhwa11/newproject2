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
String yearlySrNo="";
if(request.getAttribute("map") != null){
map = (Map<String, Object>)request.getAttribute("map");
}
Map<String,Object> infoMap = new HashMap<String,Object>();
if(map.get("message") !=null){
message=""+map.get("message");
}
if(map.get("yearlySrNo")!= null){
yearlySrNo =(String)map.get("yearlySrNo");	
}
%>

<form name="messageResult" method="post"><br />
<h2><font id="error"><%=message %></font></h2>
<br />
<br />


<input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('messageResult','/hms/hms/ot?method=printPreAneaesthesiaProcNotesReport&yearlySrNo=<%=yearlySrNo %>','checkTargetForYes');" />
<input type="button" name="Back" value="Back" class="button"
	onclick="submitForm('messageResult','/hms/hms/ot?method=showOtPatientDetails','checkTargetForNo');" />
<br />
</form>

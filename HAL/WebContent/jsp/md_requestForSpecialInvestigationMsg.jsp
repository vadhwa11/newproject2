
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
	int  id=0;
	int entryNo = 0;
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>)request.getAttribute("map");
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
	if(!message.equalsIgnoreCase("")){
	%>
<h4><%=message %></h4>

<%} %>
<form name="message" method="post">
<div class="Clear"></div>
<div id="contentHolder">
<%
		if(map.get("ID") != null){
			id = (Integer)map.get("ID");
		}
	     
		if(map.get("hinNo") != null){
			hinNo = (String)map.get("hinNo");
		}
		
		if(map.get("entrySeqNo") != null){
			entryNo = (Integer)map.get("entrySeqNo");
		}
	%> <input type="button" name="yes" value="Yes" class="cmnButton"
	onclick="submitForm('message','/hms/hms/mediClaim?method=printSpecialInvestigation&Id=<%=id%>');" />
<input type="button" name="no" value="No" class="cmnButton"
	onclick="submitForm('message','/hms/hms/mediClaim?method=showPatientSearchForSpecialinvestigationJsp','checkTargetForNo');" />
<div class="Clear"></div>
<%
		if(formName != ""){
	%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>
</div>
</form>

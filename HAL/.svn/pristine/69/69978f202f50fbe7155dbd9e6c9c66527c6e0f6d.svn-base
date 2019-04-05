<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<%
Map<String,Object> map = new HashMap<String,Object>();
String message="";
String url="";
String reportMsg="";
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
if(map.get("message") !=null){
	message=""+map.get("message");
}
if(map.get("url") !=null){
	url=""+map.get("url");
}
if(map.get("reportMsg") !=null){
	reportMsg=""+map.get("reportMsg");
}
String allotmentNo ="";
if(map.get("allotmentNo") !=null){
	allotmentNo=""+map.get("allotmentNo");
}
String cancelNo ="";
if(map.get("cancelNo") !=null){
	cancelNo=""+map.get("cancelNo");
}
String vacationNo ="";
if(map.get("vacationNo") !=null){
	vacationNo=""+map.get("vacationNo");
}
%>

<form name="message" method="post">
<div id="contentHolder">
<h6>&nbsp;</h6>
<div class="Clear"></div>
<h5><span><%=message %></span></h5>
<%if(allotmentNo != null){ %> <input type="hidden" name="allotmentNo"
	id="allotmentNo" value="<%=allotmentNo %>" /> <%}else{ %> <input
	type="hidden" name="allotmentNo" id="allotmentNo" value="" /> <%} %> <%if(vacationNo != null){ %>
<input type="hidden" name="vacationNo" id="vacationNo"
	value="<%=vacationNo %>" /> <%}else{ %> <input type="hidden"
	name="vacationNo" id="vacationNo" value="" /> <%} %> <%if(cancelNo != null){ %>
<input type="hidden" name="cancelNo" id="cancelNo"
	value="<%=cancelNo %>" /> <%}else{ %> <input type="hidden"
	name="cancelNo" id="cancelNo" value="" /> <%} %>
<div class="Clear"></div>
<input type="button" value="Back" class="cmnButton"
	onClick="submitForm('message','<%=url%>','checkTargetForNo');" /> <input
	name="Button" type="button" class="cmnButton" value="Print Report"
	onclick="submitFormForButton('message','<%=reportMsg %>','checkTargetForYes');" />
</div>
</form>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
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
if(map.get("messageTOBeVisibleToTheUser") !=null){
	message=""+map.get("messageTOBeVisibleToTheUser");
}
if(map.get("url") !=null){
	url=""+map.get("url");
}

String grnNo="";
if(map.get("grnNo") !=null){
	grnNo=""+map.get("grnNo");
}
String sourceOfSupply ="";
if(map.get("souceOfSupply") !=null){
	sourceOfSupply=""+map.get("souceOfSupply");
}

%>

<form name="message" method="post">
<div id="contentHolder">
<h6>&nbsp;</h6>
<div class="Clear"></div>
<h5><span><%=message %></span></h5>
 <input type="text" name="<%=GRN_NO %>"	value="<%=grnNo %>" /> 
 <input
	type="text" name="<%=SOURCE_OF_SUPPLY %>" id="sourceOfSupply" value="<%=sourceOfSupply %>" /> 
	

	<div class="Clear"></div>
<input type="button" value="Back" class="cmnButton"
	onClick="submitForm('message','<%=url%>);" /> <input
	name="Button" type="button" class="cmnButton" value="Print Report"
	onclick="submitForm('message','stores?method=printGrn&grnNo='<%=grnNo %>'+&deptId=1');" />
</div>
</form>

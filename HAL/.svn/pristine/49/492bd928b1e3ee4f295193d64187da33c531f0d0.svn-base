
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	String message = "";
	int employee_id = 0;
	int rankCategoryId=0;
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	if(map.get("employee_id") != null){
		employee_id = (Integer)map.get("employee_id");
	}
	if(map.get("rankCategoryId") != null){
		rankCategoryId = (Integer)map.get("rankCategoryId");
	}
		
	%>

<br />
<h2><font id="error"><%=message %></font></h2>
<br />

<br />
<div id="contentHolder">
<form name="printLeaveApplication" method="post"><input
	type="hidden" name="empId" id="empId" value="<%=employee_id%>" /> <input
	type="hidden" name="rankCategoryId" id="rankCategoryId"
	value="<%=rankCategoryId%>" />
<div class="division"></div>
<div class="bottom"><input type="button"
	name="Print Leave Application" style="width: 100px;"
	id="Print Leave Application" class="cmnbutton"
	value="Print Leave Application "
	onclick="submitForm('printLeaveApplication','hrOrderly?method=generateLeaveApplicationReport');" />
<input class="cmnbutton" id=reset accessKey=r type=reset
	value="Print Application For CV Family"
	onclick="submitForm('printLeaveApplication','hrOrderly?method=printApplicationForCV');">
<input class="cmnbutton" id=reset accessKey=r type=reset
	value="Print Issue of FRW For LTC"
	onclick="submitForm('printLeaveApplication','hrOrderly?method=printIssueofFRW');">
<input type="button" name="Back" id="Back" value="Back"
	class="cmnbutton"
	onclick="submitForm('printLeaveApplication','hrOrderly?method=showLeaveApplicationJsp');" />
</div>
<div class="division"></div>

</form>
</div>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
int hin_id=0;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("hin_id") != null){
	hin_id = Integer.parseInt(""+map.get("hin_id"));
}
if(map.get("message") != null){
	message = (String)map.get("message");
}


%>
<h4 class="auto"><%=message %></h4>
<form name="messageFatalDocument" method="post" >
<!-- <label class="auto">Do you want to print Report ?</label> -->
<input	type="hidden" id="hin_id" name="hin_id"	 value="<%=hin_id %>"  />
<div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%--<input	type="button" name="Print" value="Submit" class="button" tabindex="1" 	onClick="submitForm('messageFatalDocument','/hms/hms/mis?method=genrateFatalDocument')" /> --%>
<input	type="button" name="Cancel" value="Back" class="button"	onClick="submitForm('messageFatalDocument','mis?method=showFatalDocumentJsp');" />
<div class="Clear"></div>
<div class="division"></div>
<%--
<jsp:include page="currentUserDetails.jsp"></jsp:include> --%>
</form>


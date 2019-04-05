
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	String message = "";
	String formName = "";
	String hinNo = "";
	int id=0;
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
<h2><%=message %></h2>

<%} %>
<form name="message" method="post">
<div class="Clear"></div>
<div id="contentHolder">
<%
		if(map.get("id") != null){
			id = Integer.parseInt(map.get("id").toString());
		//	System.out.println("id-----------in JSP MSG"+ id);
		}
		if(map.get("hinNo") != null){
			hinNo = (String)map.get("hinNo");
		}
		
		if(map.get("entrySeqNo") != null){
			entryNo = (Integer)map.get("entrySeqNo");
		}
	%> <input type="button" name="yes" value="Print" class="cmnButton"
	onclick="submitForm('message','/hms/hms/agenda?method=printAgendaReport&Id=<%=id%>','checkTargetForYes');" />
<input type="button" name="no" value="No" class="cmnButton"
	onclick="submitForm('message','/hms/hms/agenda?method=showAgendaMeetingDetailSearchJsp','checkTargetForNo');" />
<div class="Clear"></div>
<%
		if(formName != ""){
	%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>
</div>
</form>

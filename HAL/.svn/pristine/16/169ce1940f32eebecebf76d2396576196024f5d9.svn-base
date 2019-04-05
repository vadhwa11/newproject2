<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> addOrEdit = new HashMap<String, Object>();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("addOrEdit")!= null){
			addOrEdit = (Map)map.get("addOrEdit");
		}
		Boolean teamSkills=false;
		if(addOrEdit.get("teamSkills")!= null){
			teamSkills = (Boolean)addOrEdit.get("teamSkills");
		}
%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<form name="<%=LEAVE_DETAILS%>" method="post" action="">
	<div class="titleBg"><h2>Leave Details  </h2></div>
	<div class="clear"></div>
	<div class="Block">

 	<h4><a href="javascript:void(0)" onclick="submitForm('leaveDetails','leave?method=showMyDetails');">My Details</a></h4> 
 		<div class="clear"></div>
 	<% if(teamSkills){ %>
 	<!-- <h4><a href="javascript:void(0)" onclick="submitForm('leaveDetails','leave?method=showTeamDetails');">Team Member Leave Details</a></h4> -->
 		<div class="clear"></div> 
 	<% }%>
 	</div>
</form>

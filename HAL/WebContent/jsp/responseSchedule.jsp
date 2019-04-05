
<%@ page import="java.util.*" %>
<%@page import="jkt.hms.masters.business.MasScheduleMaster"%>
<script type="text/javascript" language="javascript" src="/erp/jsp/js/proto.js"></script>
<link href="/erp/jsp/css/style.css" rel="stylesheet" type="text/css"/>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasScheduleMaster> scheduleList= new ArrayList<MasScheduleMaster>();
if(map.get("scheduleList") != null){
	scheduleList = (List)map.get("scheduleList");
	
}

%>
<div id="nameDiv" >
<label> Schedule </label>
<select name="schedule" id="scheduleId" validate="Schedule,string,no"  tabindex=1>
<%	if(scheduleList.size() !=0){
%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = scheduleList.iterator(); iterator.hasNext();) {
					 MasScheduleMaster msm = (MasScheduleMaster) iterator.next();
				  %>
				  <option value="<%=msm.getScheduleCode()%>"><%=msm.getScheduleCode()%></option>
				  <%
				  	 	}
				   %>
		
	<%}else{%>
	<option value="0">Select</option>
	<%
			for(int i=1; i<=20; i++){ %>
				<option value="<%=i%>"><%=i %></option>
		<%} %>
	<%} %>
	</select>
</div>
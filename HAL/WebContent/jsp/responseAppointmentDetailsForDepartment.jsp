
<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	List<AppSetup> appSetupList = new ArrayList<AppSetup>();

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
				if (map.get("appSetupList") != null) {
					appSetupList = (List<AppSetup>) map.get("appSetupList");
			 		
			 	}
%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%@page import="java.util.ArrayList"%>
<div class="Clear"></div>
<% if(appSetupList.size() > 0){ %>
<label class="common" style="width: auto; float: none; color: red;">
APPOINTMENT AVAILABLE ON DAYS : </label>
<% }else{ %>
<label class="common" style="width: auto; float: none; color: red;">
NO APPOINTMENT SETUP FOR THIS DEPARTMENT </label>
<% } %>

<label class="large" style="color: red; width: 100%; float: none;">
<%for(AppSetup appSetup : appSetupList){ 
		if(appSetupList.size() == 1){ %> <%=appSetup.getDays().toUpperCase()%>
<% }else{%> <%=appSetup.getDays().toUpperCase()%>, <%} %> <% } %> </label>

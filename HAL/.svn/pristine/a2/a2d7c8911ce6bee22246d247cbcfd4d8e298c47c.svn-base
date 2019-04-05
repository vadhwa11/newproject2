
<%
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	List<AppInvestigationSetup> appInvestigationSetupList = new ArrayList<AppInvestigationSetup>();

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	if (map.get("appInvestigationSetupList") != null) {
					appInvestigationSetupList = (List<AppInvestigationSetup>) map.get("appInvestigationSetupList");
			 	}
%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.AppInvestigationSetup"%>
<div class="Clear"></div>
<div class="Clear"></div>
<% if(appInvestigationSetupList.size() > 0){ %>
<label class="common" style="width: auto; float: none; color: red;">
APPOINTMENT AVAILABLE ON DAYS : </label>
<% }else{ %>
<label class="common" style="width: auto; float: none; color: red;">
NO APPOINTMENT SETUP FOR THIS EQUIPMENT </label>
<% } %>

<label class="large" style="color: red; width: 100%; float: none;">
<%if(appInvestigationSetupList.size() == 1){ %> <%=appInvestigationSetupList.get(0).getDays().toUpperCase()%>.
<% }else{
								for(int i=0;i < appInvestigationSetupList.size(); i++){%> <% if(i == appInvestigationSetupList.size()-1){ %>
<%=appInvestigationSetupList.get(i).getDays().toUpperCase()%>. <% }else{ %>
<%=appInvestigationSetupList.get(i).getDays().toUpperCase()%>, <% } %> <%} %>
<% } %> </label>

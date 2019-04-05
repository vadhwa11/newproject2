<%@page import="jkt.hms.masters.business.EmpScMapping"%>
<%@page import="jkt.hms.masters.business.UserDepartment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
	Map<String, Object> map=new HashMap<String, Object>();
	List<EmpScMapping> empScMappings=new ArrayList<EmpScMapping>();
	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("empScMappings")!=null){
		empScMappings=(List<EmpScMapping>)map.get("empScMappings");
	}
%>
<select name="Resource" id="Resource" validate="Resource,string,yes">
<option value="">Select</option>
<%for(EmpScMapping userDepartment:empScMappings){ 
%>
<option value="<%= userDepartment.getEmployee().getId()%>"><%= userDepartment.getEmployee().getFirstName()%></option>
<%} %>
</select>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

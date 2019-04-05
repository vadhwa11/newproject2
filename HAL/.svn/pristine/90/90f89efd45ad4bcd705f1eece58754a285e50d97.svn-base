<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForHospital.jsp  
 * Purpose of the JSP   This is for Response for Hospital.
 * @author  Ritu
 * Create Date: 29th Nov,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>
<%@page import="jkt.hms.masters.business.MasSession"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="java.util.*"%>

<%@ page import = "static jkt.hms.util.RequestConstants.EMPLOYEE_ID" %>
<%@ page import = "static jkt.hms.util.RequestConstants.SESSION_ID" %>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<%

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	List<MasSession> sessionList = new ArrayList<MasSession>();
	
 if(map.get("doctorList") != null){
	 
	 doctorList=(List)map.get("doctorList");
 }
 
 if(map.get("sessionList") != null){
	 sessionList=(List)map.get("sessionList");
	
 }
 
%>


<label>Doctor List<span>*</span> </label>
<select id="doctorId" name="<%=EMPLOYEE_ID%>"  validate="" tabindex="1">
<option value="0">Select</option>
	<%
		if(doctorList.size() > 0){
			for(MasEmployee employee : doctorList){
	%>
	<option value="<%=employee.getId() %>"> <%= employee.getFirstName()+" "+employee.getLastName() %> </option>
	<%}
			}%>
</select>


<label>Session<span>*</span> </label>
<select  id="sesId" name="<%=SESSION_ID%>"  validate="" tabindex="1" onchange="resetShowButton();">
<option value="0">Select</option>
	<%
		if(sessionList.size() > 0){
			for(MasSession employee : sessionList){
	%>
	<option value="<%=employee.getId() %>"> <%= employee.getSessionName() %> </option>
	<%}
			}%>
</select>
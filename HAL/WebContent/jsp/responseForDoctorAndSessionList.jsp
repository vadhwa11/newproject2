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
	int divcount = 1;
	
 if(map.get("doctorList") != null){
	 
	 doctorList=(List)map.get("doctorList");
 }
 
 if(map.get("sessionList") != null){
	 sessionList=(List)map.get("sessionList");
	
 }
 
 if(map.get("divcount") != null){
	 divcount=(Integer)map.get("divcount");
	
 }
 
 Date dt = new Date();
 int hours = dt.getHours();
 System.out.println(hours);
 if(dt.getMinutes() >0)
	 hours++;
 
 System.out.println("hours="+hours);
 int sesFromHour=0;
 int sesFromMinute=0;
 int sesToHour=0;
 int sesToMinute=0;
 
%>

<label>Doctor List<span>*</span> </label>
<select id="doctorId<%=divcount%>" name="consultingDoctor<%=divcount%>"  validate="" tabindex="1">
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
<select  id="sesId<%=divcount%>" name="<%=SESSION_ID%><%=divcount%>"  validate="" tabindex="1">
<option value="0">Select</option>
	<%if(sessionList.size() > 0){
			for(MasSession employee : sessionList){
				sesFromHour = Integer.parseInt(employee.getFromTime().substring(0, 2));
				if(Integer.parseInt(employee.getFromTime().substring(3, 5))>0)
					sesFromHour++;
				sesToHour = Integer.parseInt(employee.getToTime().substring(0, 2));
				if(Integer.parseInt(employee.getToTime().substring(3, 5)) >0)
					sesToHour++;
				
	%>
	<option value="<%=employee.getId() %>" <%=(hours> sesFromHour && hours<=sesToHour)?"selected":""%>> <%= employee.getSessionName() %> </option>
	<%}
			}%>
</select>
 <label  class="medium"> Priority</label>
            <select name="priority<%=divcount%>" id="priority<%=divcount%>" class="smallest" tabindex="1" style="width: 65px;">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3" selected="selected">3</option>
            </select>
            <div id="displayToken<%=divcount%>" >
		</div>
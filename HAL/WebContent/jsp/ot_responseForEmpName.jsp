<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Age.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<MasEmployee> storeItemList= new ArrayList<MasEmployee>(); 
	if(map.get("nomenclatureList") != null){
		storeItemList = (List)map.get("nomenclatureList");
	}
	String rowVal= null;
	if(map.get("rowVal") != null){
		rowVal = (String)map.get("rowVal");
	}
		
%>

<%@page import="jkt.hms.masters.business.*"%>
<%
   MasEmployee masEmployee=(MasEmployee)storeItemList.get(0);
       String empName=masEmployee.getFirstName();
       int empId=masEmployee.getId();
   %>
<input type="text" name="employeeId" value="<%=empId%>" />








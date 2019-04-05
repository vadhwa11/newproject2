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
<%@page import="jkt.hms.masters.business.StoreMaterialPurchaseReqM"%>
<%@ page import="java.util.*"%>

<%@ page import = "static jkt.hms.util.RequestConstants.EMPLOYEE_ID" %>
<%@ page import = "static jkt.hms.util.RequestConstants.SESSION_ID" %>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<%

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<StoreMaterialPurchaseReqM> mprList = new ArrayList<StoreMaterialPurchaseReqM>();

	
 if(map.get("mprList") != null){
	 
	 mprList=(List<StoreMaterialPurchaseReqM>)map.get("mprList");
 }
 

 
%>


<label> MPR No  <span>*</span></label>
	<select	class="" name="mprNo" id="mprNo" validate="MPR No,String,yes" tabindex=1 onchange="getMPRDetails();" >
		<option value="">Select MPR No</option>
<%
	for (StoreMaterialPurchaseReqM list :mprList ) 
	{
		
		%>		
		<option value=<%=list.getId()%>><%=list.getMprNo()%></option>
		<%   
	}
%>

</select>
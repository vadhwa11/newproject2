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
	List<MasChargeCode> chargeCodeList= new ArrayList<MasChargeCode>(); 
	if(map.get("chargeCodeList") != null){
		chargeCodeList = (List)map.get("chargeCodeList");
	}
	String rowVal= null;
	if(map.get("rowVal") != null){
		rowVal = (String)map.get("rowVal");
	}
		
%>

<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%
       MasChargeCode masChargeCode=(MasChargeCode)chargeCodeList.get(0);
       String chargeCode=masChargeCode.getChargeCodeCode();
       int chargeCodeId=masChargeCode.getId();
   %>
<input id="chargeCode<%=rowVal %>" size="10" type="text"
	id="chargeCode<%=rowVal%>" name="chargeCode<%=rowVal%>"
	value="<%=chargeCode %>" readonly />
<input type="hidden" name="chargeCodeId" value="<%=chargeCodeId%>" />








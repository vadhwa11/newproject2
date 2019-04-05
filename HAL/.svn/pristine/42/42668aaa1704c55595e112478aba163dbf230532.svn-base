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
	List<MasStoreItem> storeItemList= new ArrayList<MasStoreItem>(); 
	if(map.get("storeItemList") != null){
		storeItemList = (List)map.get("storeItemList");
	}
	String rowVal= null;
	if(map.get("rowVal") != null){
		rowVal = (String)map.get("rowVal");
	}
		
%>

<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%
   MasStoreItem masStoreItem=(MasStoreItem)storeItemList.get(0);
       String pvms=masStoreItem.getPvmsNo();
       int itemId=masStoreItem.getId();
   %>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<input size="10" type="text" id="pvms<%=rowVal%>" name="pvms<%=rowVal%>"
	value="<%=pvms%>" readonly />
<input type="hidden" name="itemId" value="<%=itemId%>" />








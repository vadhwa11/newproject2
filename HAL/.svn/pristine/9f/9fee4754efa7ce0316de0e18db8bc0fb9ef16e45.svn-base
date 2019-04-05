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
   MasStoreItem masStoreItem=(MasStoreItem)storeItemList.get(0);
       String storeItem=masStoreItem.getPvmsNo();
       int storeItemId=masStoreItem.getId();
   %>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<input id="nomenclature<%=rowVal %>" type="text" size="10"
	name="nomenclature<%=rowVal%>" value="<%=storeItem %>" readonly />
<input type="hidden" name="pvmsNoId" value="<%=storeItemId%>" />








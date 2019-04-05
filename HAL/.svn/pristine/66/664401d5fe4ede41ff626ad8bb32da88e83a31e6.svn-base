<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * breadCrumb.jsp  
 * Purpose of the JSP -  This is for Bread Crumb
 * @author  Deepali
 * @author  Mansi
 * Create Date: 02nd Nov,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.4  
--%>

<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasApplication"%>

<%
	Map mapBc = new HashMap();
	Map breadCrumbMap = new HashMap();
	String jspName ="";
	String breadCrumbs = "";
	MasApplication selectedApp = new MasApplication();
    List remainingDataList = new ArrayList();
    if(request.getAttribute("map")!=null)
    {
    	mapBc = (Map)request.getAttribute("map");
    	if(mapBc.get("breadCrumbMap") != null)
    	{
    		breadCrumbMap = (Map)mapBc.get("breadCrumbMap");
     	}
	    jspName = (String)breadCrumbMap.get("jspName");
	    remainingDataList = (List)breadCrumbMap.get("remainingDataList");
	    selectedApp = (MasApplication)breadCrumbMap.get("selectedApp"); 
	    breadCrumbs = (String)breadCrumbMap.get("breadCrumbs");
	     
     }
%>
<label id="crumbs"><%= breadCrumbs+" > "+selectedApp.getName() %></label>
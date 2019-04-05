<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForDischarge.jsp  
 * Purpose of the JSP -  This is for Response Discharge.
 * @author  Ritu
 * Create Date: 22nd Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<MasIcd> icdNoList = new ArrayList<MasIcd>();
	if(map.get("icdNoList") != null){

%>


<select name="<%=RequestConstants.ICD_ID %>">
	<option value="0">Select</option>
	<%    
			icdNoList = (List<MasIcd>)map.get("icdNoList");
			MasIcd masIcd = new MasIcd();
   			for(Iterator iterator = icdNoList.iterator(); iterator.hasNext();) {
   				masIcd = (MasIcd)iterator.next();
   			
   %>
	<option value="<%=masIcd.getId()%>"><%=masIcd.getIcdName()%></option>
	<%	
}
%>
</select>
<%
	}%>

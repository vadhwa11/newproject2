<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForDischarge.jsp  
 * Purpose of the JSP -  This is for Response Discharge.
 * @author  Abha
* Create Date: 27th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<script>
 var flag;
</script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<StorePoHeader> poList= new ArrayList<StorePoHeader>();
	List<StoreIndentM> indentMList= new ArrayList<StoreIndentM>();
	String choice="";
	

	
		poList=(List)map.get("first_combo");
	
	
%>

<div id=suppNoDiv>

<label>SO  No.</label>
<select name="supplierName" id="supplierId" onchange="getSOItems(this.value);">
<option value="0">Select</option>
<% for (StorePoHeader poHeader : poList)
	  	   {   %>
	<option value="<%=poHeader.getId ()%>"><%=poHeader.getPoNumber()%></option>
	<% } %>
</select>
</div>



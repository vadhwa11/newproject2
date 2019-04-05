<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * local_po_format.jsp  
 * Purpose of the JSP -  This is for local_po_format.
 * @author  Deepti Tevatia
 * Create Date: 19th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasManufacturer"%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<StorePoHeader> poNumberList = new ArrayList<StorePoHeader>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("poNumberList")!=null){
		poNumberList =(List) map.get("poNumberList");
	}
%>
<div id="contentspace">
<form name="poFormat" method="post" action="">

<div class="panelbar">
<div class="paneltext"">Local PO Format Report</div>
</div>
<br />
<label>PO Number : </label> <select name="<%= PO_NO%>">
	<option value="0">Select</option>
	<%
	for (StorePoHeader storePoHeader : poNumberList) {
	%>
	<option value="<%=storePoHeader.getPoNumber()%>"><%=storePoHeader.getPoNumber() %></option>
	<%
	}
	%>
</select> <input type="button" name="add" id="addbutton" value="Submit"
	class="button"
	onClick="submitForm('poFormat','purchaseOrder?method=generateLocalPoFormatReport');"
	accesskey="a" tabindex=1 /></form>
</div>







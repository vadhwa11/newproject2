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
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script>
 var flag;
</script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	

	List<StoreIndentM> indentMList= new ArrayList<StoreIndentM>();
	
	
	String choice="";
	if(map.get("choice") != null)
	{
	choice=(String)map.get("choice");		
	}

	if (choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("d"))
	{
		indentMList=(List)map.get("indentMList");
	}
	
%>

<div id=indentDiv>

<label>Vendor Name</label> <select
	name="<%=RequestConstants.SUPPLIER_ID %>" id="indentCombo" tabindex=1 onchange="getgridItemForIndent(this.value);" disabled="disabled">
	<option value="0">Select</option>
	
</select>
<label>Indent No</label> <select
	name="<%=INDENT_ID %>" id="indentCombo" tabindex=1 onchange="getgridItemForIndent(this.value);">
	<option value="0">Select</option>
	<%for(StoreIndentM storeIndentM:indentMList){ %>
	<option value="<%=storeIndentM.getId()%>" ><%=storeIndentM.getIndentNo()%></option>
<%} %>
</select>


</div>

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
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

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
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<link href="/hms/jsp/css/phaseII.css" rel="stylesheet" type="text/css">
<link href="/hms/jsp/css/hstyle.css" rel="stylesheet" type="text/css">


<%
	Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
ArrayList  <MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
subChargecodeList = (ArrayList)map.get("subChargecodeList");
	if(request.getAttribute("map") != null)
	{
		map = (Map<String, Object>)request.getAttribute("map");
		
	}
%>
<form name="chargeCode" method="post">
<div id=testDiv><label class="bodytextB1_blue">Lab Group
Name</label> <select id="subChargeName" name="<%=SUB_CHARGECODE_ID %>"
	class="select_adt"
	onchange="submitProtoAjaxforSupplier('chargeCode','/hms/hms/investigation?method=responseForCharge');">
	<option value="0">Select</option>
	<%    
	
		for(MasSubChargecode grpObj: subChargecodeList){
	   			
%>
	<option value="<%=grpObj.getId()%>"><%=grpObj.getSubChargecodeName()%></option>
	<%	
}
%>
</select></div>
</form>
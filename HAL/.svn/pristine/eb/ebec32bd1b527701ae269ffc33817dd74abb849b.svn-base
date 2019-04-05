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
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
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
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script>
 var flag;
 </script>

<%
	Map map = new HashMap();
	List<StoreIndentM> indentList= new ArrayList<StoreIndentM>();
	//List<StoreIndentM> indentForAfmsdList= new ArrayList<StoreIndentM>();
	List<StorePoHeader> poList= new ArrayList<StorePoHeader>();
	String choice = "";

	if(request.getAttribute("map") != null)
	{
		map = (Map)request.getAttribute("map");
		if (map.get("choice")!=null)
			
			choice = map.get("choice").toString();
		System.out.println("choice " + choice);
		
		if (choice.equalsIgnoreCase("a"))
		{
			indentList=(List)map.get("second_combo");
		}
		else if (choice.equalsIgnoreCase("S"))
		{
			indentList=(List)map.get("second_combo");
		}
		
		System.out.println("list inside jsp" + indentList.size());
	}
%>

<div id=indentDiv>
<%
		if (choice.equalsIgnoreCase("a") )
		{ %> <label>Indent No.</label> 
<select name="<%=RequestConstants.INDENT_ID %>" id="indentCombo"
	onchange="submitProtoAjaxforGrid('grnGrid','/hms/hms/neStores?method=responseGridList');">
	<option value="0">Select</option>
	<% for (StoreIndentM indentList1 : indentList)
		  	   { System.out.println(indentList1.getIndentNo()+" <<<<<<<<<indentList1.getId()>>>>>>>>>> " + indentList1.getId());  %>
	<option value="<%=indentList1.getId()%>"><%=indentList1.getIndentNo()%></option>
	<% } %>
</select> <%}%>
</div>

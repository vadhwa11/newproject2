<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : ADT_ICD_Search.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 04.08.2008    Name: Othivadivel K R   
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 * @see 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.masters.business.MasIcd"%>

<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.StoreTenderCommBidM"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<SCRIPT LANGUAGE="JavaScript">
<!--
	function jsSelData(nomenclature) {
		opener.jsSetNomenclature(nomenclature);
		self.close();
	}
	
	function sub()
	{
		//var tenderId=document.pvmsNomenclatureSearchForm.tenderId.value;
		//var groupId=document.pvmsNomenclatureSearchForm.groupId.value;
		submitForm('pvmsNomenclatureSearchForm','/hms/hms/tender?method=showPvmsNomencaltureSearchJsp');
	}
	
//-->
</SCRIPT>


<style type="text/css">
<!--
BODY {
	MARGIN-TOP: 0px;
	MARGIN-BOTTOM: 0px;
	MARGIN-LEFT: 0px;
	MARGIN-RIGHT: 0px;
}

.schInput {
	BACKGROUND-COLOR: #ffffff;
	BORDER-BOTTOM: #bfbfbf 1px solid;
	BORDER-LEFT: #bfbfbf 1px solid;
	BORDER-RIGHT: #bfbfbf 1px solid;
	BORDER-TOP: #bfbfbf 1px solid;
	COLOR: #4a4a4a;
	FONT-FAMILY: Arial;
	FONT-SIZE: 11px;
	height: 15px;
}

#linetblhdr {
	BACKGROUND-COLOR: #EBE7E7;
	BORDER-BOTTOM: #d1bfe8 1px solid;
	BORDER-LEFT: #d1bfe8 1px solid;
	BORDER-RIGHT: #d1bfe8 1px solid;
	BORDER-TOP: #d1bfe8 1px solid;
	COLOR: #000000;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif;
	FONT-SIZE: 8pt;
	font-weight: 400;
	MARGIN: 1px;
	vertical-align: middle;
	cursor: hand
}

#sel {
	BACKGROUND-COLOR: #CAE7EF;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif;
	FONT-SIZE: 8pt;
	cursor: hand
}
-->
</style>
<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	List<StoreTenderCommBidM> masStoreItemList = new ArrayList<StoreTenderCommBidM>();
	MasUnit masUnit = new MasUnit();
	int groupId=0;
	int tenderId=0;
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("masStoreItemList")!=null)
			masStoreItemList = (List)map.get("masStoreItemList");
		if (map.get("tenderId")!=null)
			tenderId = (Integer)map.get("tenderId");
		if (map.get("groupId")!=null)
			groupId = (Integer)map.get("groupId");
	}
	
%>


<div id="contentHolder">
<form name="pvmsNomenclatureSearchForm" action="" method="post">
<div class="blockTitle">Item Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrameSm"><label>Nomenclature</label> <input
	type="text" name="nomenclature" value="<%=box.get("unit_name")%>" />
<label>PVMS/NIV</label> <input type="text" name="pvms"
	value="<%=box.get("unit_name")%>" /> <input type="button"
	name="Submit" id="addbutton" onClick="sub();" value="Search"
	class="button" accesskey="a" /> <input type="hidden" name="SearchFlag"
	value="true" /> <input type="hidden" name="groupId"
	value="<%=groupId %>" /> <input type="hidden" name="tenderId"
	value="<%=tenderId %>" />
<div class="Clear"></div>
</div>
<div class="Clear"></div>

<div class="tableHolderPopup">
<table width="100%" border="0" cellpadding="0" cellspacing="0">

	<thead>
		<tr>

			<th width="52" class="gridheaderlabel">Pvms/NIV</th>
			<th width="87" class="gridheaderlabel">Nomenclature</th>
		</tr>

	</thead>
	<tbody>

		<%
	String icdNameString ="";
	if (masStoreItemList != null && masStoreItemList.size() > 0) { 
	%>

		<% for(int i=0;i<masStoreItemList.size();i++)
	{
		StoreTenderCommBidM storeItem = (StoreTenderCommBidM)masStoreItemList.get(i);
		MasStoreItem masStoreItem=storeItem.getItem();
	%>
		<tr id="linetblhdr" onmouseover="this.id='sel'"
			onmouseout="this.id='linetblhdr'"
			onclick="javascript:jsSelData('<%=masStoreItem.getId()%>');">
			<td height="12"><%=masStoreItem.getPvmsNo()%></td>
			<td align="left"><%=masStoreItem.getNomenclature()%></td>

		</tr>
		<%
	}
	%>
		<% } 
		else
		{
		%>
		<tr>
			<td height="16" colspan=6 align="center">No Data Found</td>
		</tr>
		<% } %>
	</tbody>
</table>
</div>
</form>
</div>

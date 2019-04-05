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
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
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
	function jsSelData(item,nomenclature) {
		opener.jsSetNomenclature(item,nomenclature);
		self.close();
	}
	
	function sub()
	{
		submitForm('ItemNameSearchForm','/hms/hms/stores?method=showPvmsNomencaltureSearchJsp');
	}
	
//-->
</SCRIPT>

<title>Unit Name Search</title>

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
</head>
<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
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


<div id="contentspace"><br />
<form name="ItemNameSearchForm" action="" method="post">


<div style="padding-left: 15px;">


<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Item Search</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 760px; height: 85px; background-color: #f4f9fe;">


<div style="height: auto; width: auto;"><br />


<label class="bodytextB">Nomenclature</label> <input type="text"
	name="nomenclature" value="<%=box.get("unit_name")%>"
	class="bigcaption1" /> <label class="bodytextB">PVMS/NIV</label> <input
	type="text" name="pvms" value="<%=box.get("unit_name")%>"
	class="textbox_size20" /> <input type="button" name="Submit"
	id="addbutton" onClick="sub();" value="Search" class="button"
	accesskey="a" /> <input type="hidden" name="SearchFlag" value="true" />
<input type="hidden" name="groupId" value="<%=groupId %>" /> <input
	type="hidden" name="tenderId" value="<%=tenderId %>" /> <br />
</div>
</div>

<br />


<br />
<br />




<div style="overflow: scroll; width: 780px; height: 500px;">
<table width="100%" border="0" cellpadding="2" cellspacing="2"
	class="grid_header">

	<thead>
		<tr>

			<td width="52" class="gridheaderlabel">Pvms/NIV</td>
			<td width="87" class="gridheaderlabel">Nomenclature</td>
		</tr>

	</thead>
	<tbody>

		<%
	String icdNameString ="";
	if (masStoreItemList != null && masStoreItemList.size() > 0) { 
	%>

		<% for(MasStoreItem masStoreItem : masStoreItemList)
	{
		
		
	%>
		<tr id="linetblhdr" onmouseover="this.id='sel'"
			onmouseout="this.id='linetblhdr'"
			onclick="javascript:jsSelData('<%=masStoreItem.getId() %>','<%=masStoreItem.getNomenclature()%>');">
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
</div>
</form>
</div>

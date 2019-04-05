<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * supplierOrderEntry.jsp  
 * Purpose of the JSP -  This is for Supplier Order Entry.
 * @author  Deepti
 * @author  Abha
 * Create Date: 04th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.7
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
		List<StoreIndentM> searchStoreIndentMList = new ArrayList<StoreIndentM>();
		if (request.getAttribute("map") != null) {
		map = (Map)request.getAttribute("map");

	}
	if(map.get("searchStoreIndentMList")!=null)
		searchStoreIndentMList = (List)map.get("searchStoreIndentMList");
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
<br>
<br>
<%
		   out.println(message);
		  }
%>

<div id="contentspace">
<form name="zzzz" action="" method="post"><br />

<table class="tborder" width="100%" align="center">
	<tr>

		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" value="Add"
					class="toolbutton"
					onclick="submitForm('zzzz','stores?method=addSupplyOrderEntry');"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onclick="submitForm('zzzz','stores?method=updateSupplyOrderEntry');"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="Reset" name="Reset" value="Reset" class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value=" " onClick=""></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<br />


<label class="bodytextB_blue">Indent No:</label> <select
	name="<%= RequestConstants.INDENT_ID%>"
	onchange="submitProtoAjax('zzzz','/hms/hms/stores?method=searchSupplyOrderEntry');">
	<option value="0">Select</option>
	<%
					for (StoreIndentM storeIndentM :searchStoreIndentMList ) {
				%>

	<option value=<%=storeIndentM.getId()%>><%=storeIndentM.getIndentNo()%></option>

	<% 
					}
				%>
</select> <br>
<div id="testDiv">
<fieldset style="width: 99%; padding-left: 9px;"><legend>Supply
Order Entry</legend>


<div
	style="overflow: auto; width: 100%; height: 150px; padding-left: 9px;">
<table width="98%" colspan="7" id="tblSample" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">

	<thead>
		<tr>
			<td width="10%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>

			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">MMF</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Vendor
			Name</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Supply
			Order No.</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Supply
			Order Date</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Rate</label></td>


		</tr>
	</thead>
	<tbody>





	</tbody>
</table>
</br>
</fieldset>

</div>
</div>


</div>
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
<input type="hidden" name="rows" id="rr" value="1" />




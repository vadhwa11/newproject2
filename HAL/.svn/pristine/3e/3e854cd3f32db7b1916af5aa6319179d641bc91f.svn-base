<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * modifyQuotationRequest.jsp  
 * Purpose of the JSP -  This is for modify quotation Request.
 * @author  Vivek
 * @author  Deepti
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.PoDetail"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.*"%>
<%@page import="jkt.hms.masters.business.PoHeader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>


<%@page import="jkt.hms.masters.business.StoreQuotationRequestM"%>
<%@page import="jkt.hms.masters.business.StoreQuotationRequestT"%>
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
<script type="text/javascript" language="javascript">
var tempItemArray = new Array();
var tempManufacturerArray= new Array();
var tempUomArray= new Array();

function addRowToTable()
{
  var tbl = document.getElementById('tblSample');
  var lastRow = tbl.rows.length;
  // if there's no header row in the table, then iteration = lastRow + 1
  var iteration = lastRow;
  var row = tbl.insertRow(lastRow);
  alert(iteration)
  var hdb = document.getElementById('hdb');
  hdb.value=iteration
  // left cell

  
   var cellRight0 = row.insertCell(0);
  var e0 = document.createElement('input');
  e0.type = 'text';
   e0.value = iteration;
  e0.name = 'SRNo' + iteration;
  alert('SRNo' + iteration)
  e0.id = 'txtRow' + iteration;
  e0.size = 8;
  cellRight0.appendChild(e0);
  
   // select cell
  var cellRightSel = row.insertCell(1);
  var sel = document.createElement('select');
  sel.name = 'item_id' + iteration;
  sel.options[0] = new Option('Select', 'value0');
  for(var i = 0;i<tempItemArray.length;i++ ){
  
  	sel.options[tempItemArray[i][0]] = new Option(tempItemArray[i][1],tempItemArray[i][0]);
  }
  cellRightSel.appendChild(sel);
  
  // right cell
  var cellRight1 = row.insertCell(2);
  var el = document.createElement('input');
  el.type = 'text';
   el.value = 'text';
  el.name = 'Nomenclature' + iteration;
  el.id = 'txtRow' + iteration;
  el.size = 8;
  cellRight1.appendChild(el);
  
   // right cell
  var cellRight2 = row.insertCell(3);
  var e2 = document.createElement('input');
  e2.type = 'text';
  e2.value = 'text2';
  e2.name = 'quantityOrdered' + iteration;
  e2.id = 'txtRow' + iteration;
  e2.size = 8;
  cellRight2.appendChild(e2);
  
  
   // select cell
  var cellRightSel = row.insertCell(4);
  var sel = document.createElement('select');
  sel.name = 'unit_of_measurement_id' + iteration;
  sel.options[0] = new Option('Select', 'value0');
  for(var i = 0;i<tempUomArray.length;i++ ){
  
  	sel.options[tempUomArray[i][0]] = new Option(tempUomArray[i][1],tempUomArray[i][0]);
  }
  cellRightSel.appendChild(sel);
 
 // select cell
  var cellRightSel = row.insertCell(5);
  var sel = document.createElement('select');
  sel.name = 'manufacturer_id' + iteration;
  sel.options[0] = new Option('Select', 'value0');
  for(var i = 0;i<tempManufacturerArray.length;i++ ){
  
  	sel.options[tempManufacturerArray[i][0]] = new Option(tempManufacturerArray[i][1],tempManufacturerArray[i][0]);
  }
    cellRightSel.appendChild(sel);
 
}
function removeRowFromTable()
{
  var tbl = document.getElementById('tblSample');
  var lastRow = tbl.rows.length;
  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
}

	
</script>
<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else {
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else {
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>


<%
	int masterId = 0;
	Map map = new HashMap();
	List<StoreQuotationRequestM> searchQuotationRequestList = new ArrayList<StoreQuotationRequestM>();
	List<StoreQuotationRequestM> gridQuotationRequestMList = new ArrayList<StoreQuotationRequestM>();
	List<StoreQuotationRequestT> gridQuotationRequestTList = new ArrayList<StoreQuotationRequestT>();
	String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if (map.get("searchQuotationRequestList") != null)
		searchQuotationRequestList = (List) map.get("searchQuotationRequestList");
	if (map.get("gridQuotationRequestMList") != null)
		gridQuotationRequestMList = (List) map.get("gridQuotationRequestMList");
	System.out.println("ABHA gridQuotationRequestMList   "+gridQuotationRequestMList.size());
	if (map.get("masterId") != null)
		masterId = (Integer) map.get("masterId");
	if (map.get("gridQuotationRequestTList") != null)
		gridQuotationRequestTList = (List) map.get("gridQuotationRequestTList");
%>

<div id="contentspace">
<form name="modifyQuo" method="post"><br />

<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>


		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" value="Add"
					class="toolbutton"
					onClick="submitForm('modifyQuo','stores?method=showQuotationRequestJsp');" /></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('modifyQuo','stores?method=quotationRequestModify');" /></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="toolbutton"></td>
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



<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form action="searchPanel" method="post">
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><input type="hidden"
			name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
			type="hidden" name="do" value="process" /> <input type="hidden"
			name="searchthread" value="1" /> <input type="hidden"
			name="showposts" value="1" /> <input type="hidden"
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">From
		Date :</label> <input type="text" name="<%= RequestConstants.FROM_DATE %>"
			class="textbox_date" MAXLENGTH="30" / tabindex=1 /> <img
			id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.poMain.<%= RequestConstants.FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= RequestConstants.TO_DATE %>"
			class="textbox_date" MAXLENGTH="30" / tabindex=1 /> <img
			id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.poMain.<%= RequestConstants.TO_DATE%>,true);"
			class="calender" /> <br />
		<label class="bodytextB_blue">Quotation Request No:</label> <select
			name="<%= RequestConstants.QUOTATION_REQUEST_NO%>">
			<option value="0">Select</option>
			<%
					for (StoreQuotationRequestM storeQuotationRequestM :searchQuotationRequestList ) {
				%>

			<option value=<%=storeQuotationRequestM.getRequestNo()%>><%=storeQuotationRequestM.getRequestNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('modifyQuo','stores?method=searchQuotationRequest');" />
		</td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<jsp:include page="searchResultPO.jsp" /> <br />
<div id="testDiv">
<%
			for (StoreQuotationRequestM grQuotationRequestM : gridQuotationRequestMList) {
				
		%> <input type="hidden" name="<%=RequestConstants.MASTER_ID%>"
	value="<%=grQuotationRequestM.getId()%>" /> <br />
<div id=biglabel class="bodytextB_blue">Request type</div>
<input type="radio" name="<%=RequestConstants.REQUEST_TYPE %>" value="0"
	class="checkbox" checked="checked" /> <font class="bodytextB_blue">Regular</font>
<input type="radio" name="radio1" value="1" class="checkbox" /> <font
	class="bodytextB_blue">Annual</font> <label class="bodytextB_blue"><font
	id="error"></font> Qut Request No: </label> <input type="text" name=""
	<%=RequestConstants.QUOTATION_REQUEST_NO_SEARCH%>"" value="<%=grQuotationRequestM.getRequestNo()%>"
	class="textbox_size20"/  > <label class="bodytextB_blue"><font
	id="error"></font>Quotation Date:</label> <input type="text"
	name="<%=RequestConstants.QUOTATION_DATE %>"
	value="<%=HMSUtil.changeDateToddMMyyyy(grQuotationRequestM.getRequestDate())%>"
	class="textbox_size20" MAXLENGTH="20" /> <label class="bodytextB_blue"><font
	id="error"></font>Expected Delivery Date:</label> <input type="text"
	name="<%=RequestConstants.EXPECTED_DELIVERY_DATE%>"
	value="<%=HMSUtil.changeDateToddMMyyyy(grQuotationRequestM.getExpectedDeliveryDate())%>"
	class="textbox_size20" MAXLENGTH="30" /> <br />
<label class="bodytextB_blue"><font id="error"></font>Validity
End Date:</label> <input type="text"
	name="<%=RequestConstants.VALIDITY_END_DATE%>"
	value="<%=HMSUtil.changeDateToddMMyyyy(grQuotationRequestM.getValidityEndDate())%>"
	class="textbox_size20" MAXLENGTH="30" /> <label class="bodytextB_blue"><font
	id="error"></font>Vendor:</label> <input type="text"
	name="<%= RequestConstants.STORE_SUPPLIER_ID%>"
	value="<%=grQuotationRequestM.getSupplierIdAll() %>"
	class="textbox_size20" MAXLENGTH="30"/ > <%
				}
			%> <input type="hidden" name="<%=RequestConstants.NO_OF_ROWS%>"
	id="rr" value="1" /></div>


<br />

<input type="button" class="button" value="Add Row"
	onclick="addRowToTable();" align="right" /> <input type="button"
	class="button" value="Remove" onclick="removeRowFromTable();"
	align="right" /> <br />

<fieldset style="width: 98%;"><legend>Quotation
Request details</legend>

<div style="overflow: auto; width: 100%; height: 150px;">

<table width="98%" colspan="7" id="indentDetails">
	<thead>

		<tr>

			<td width="10%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS/NIV
			No</label></td>

			<td width="10%"><label valign="left" class="smalllabel">Description</label></td>


			<td width="13%"><label valign="left" class="smalllabel">Requested
			Qty</label></td>


			<td width="13%"><label valign="left" class="smalllabel">UOM</label></td>


			<td width="13%"><label valign="left" class="smalllabel">Manufacturer</label></td>




		</tr>
	</thead>
	<tbody>

		<%
		int rowsValue=0;
			for (StoreQuotationRequestT storeQuotationRequestT : gridQuotationRequestTList) {
			
				if (storeQuotationRequestT.getMaster().getId()==masterId){
					rowsValue++;
				
		%>
		<tr>
			<input type="hidden" class="textbox_size20"
				value="<%=storeQuotationRequestT.getId()%>"
				name="<%=RequestConstants.MASTER_ID%>" id="" />
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeQuotationRequestT.getSerialNo()%>"
				name="<%=RequestConstants.SR_NO%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeQuotationRequestT.getItem().getPvmsNo()%>"
				name="<%=RequestConstants.PVMS_NO%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeQuotationRequestT.getItem().getNomenclature()%>"
				name="<%=RequestConstants.NOMENCLATURE%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeQuotationRequestT.getRequestedQty()%>"
				name="<%=RequestConstants.QUANTITY_ORDERED%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeQuotationRequestT.getUnitOfMeasurement().getUnitOfMeasurementName()%>"
				name="<%=RequestConstants.UNIT_OF_MEASUREMENT_ID%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeQuotationRequestT.getManufacturer().getManufacturerName()%>"
				name="<%=RequestConstants.MANUFACTURER_ID%>" id="" /></td>

			<%
				}}
						%><br />
	</tbody>
</table>
</br>
</fieldset>

<input type="text" name="hdb" value="<%=rowsValue %>" id="hdb" />
</div>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
<input type="hidden" name="rows" id="rr" value="1" />
<input type="button" name="submit" align="right" class="button"
	value="Update"
	onclick="submitForm('modifyQuo','stores?method=updateQuotationRequest');" />
</form>


<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * quotationReceipt.jsp  
 * Purpose of the JSP -  This is for Quotation Receipt.
 * @author  Deepti
 * @author  Mansi
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.PoDetail"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.PoHeader"%>
<%@page import="jkt.hms.masters.business.MasUnitOfMeasurement"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreQuotationReceiptM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
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


<script type="text/javascript" language="javascript">
 var numLinesAdded = 1;
 function removeRow(obj)
 		
	{
	
		var d=document.getElementById("vendorReturnDetails");
		if(document.getElementById("vendorReturnDetails").childNodes[1].childNodes.length>1)	
		{
			
			document.getElementById("vendorReturnDetails").childNodes[1].removeChild(obj.parentNode.parentNode);
		}
		else
		{
			
		 	alert("It should have atleast one row");
		}
		numLinesAdded--;
	}
 
	function generateRow() {
	
		var d=document.getElementById("vendorReturnDetails").getElementsByTagName("tr");
		lastTr = d[d.length-1]		
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		numLinesAdded++;
			obj1 = document.getElementById('rr');          
     		  obj1.value=numLinesAdded; 
			
		
			lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
	}

	
</script>

<%
	Map map = new HashMap();
	String includedJsp = null;
		List<MasStoreSection> sectionList= new ArrayList<MasStoreSection>();
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
		int maxQuotationReceiptNo=0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	List<MasUnitOfMeasurement> uomList = new ArrayList<MasUnitOfMeasurement>();
	if(map.get("uomList") != null){
		uomList = (ArrayList) map.get("uomList");
		session.setAttribute("uomList",uomList);
	}else if(session.getAttribute("uomList") != null){
		uomList = (ArrayList)session.getAttribute("uomList");
		
	}
	List<StoreQuotationReceiptM> searchQuotationList = new ArrayList<StoreQuotationReceiptM>();
	if(map.get("searchQuotationList") != null){
		searchQuotationList = (ArrayList) map.get("searchQuotationList");
		session.setAttribute("searchQuotationList",searchQuotationList);
	}else if(session.getAttribute("searchQuotationList") != null){
		searchQuotationList = (ArrayList)session.getAttribute("searchQuotationList");
		
	}
	List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
	if(map.get("manufacturerList") != null){
		manufacturerList = (ArrayList) map.get("manufacturerList");
		session.setAttribute("manufacturerList",manufacturerList);
	}else if(session.getAttribute("manufacturerList") != null){
		manufacturerList = (ArrayList)session.getAttribute("manufacturerList");
		
	}
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	if(map.get("supplierList") != null){
		supplierList = (ArrayList) map.get("supplierList");
		session.setAttribute("supplierList",supplierList);
	}else if(session.getAttribute("supplierList") != null){
		supplierList = (ArrayList)session.getAttribute("supplierList");
		
	}
	if(map.get("maxQuotationReceiptNo")!=null)
		maxQuotationReceiptNo=Integer.parseInt(""+map.get("maxQuotationReceiptNo"));
	
	if(map.get("sectionList")!=null)
	sectionList=(List) map.get("sectionList");
	
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");
%>

<div id="contentspace">
<form name="indent" method="post"><br />

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
					class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');"></td>
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

<form name="searchPanel" method="post">
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
			onClick="setdate('<%=currentDate%>',document.indent.<%= RequestConstants.FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= RequestConstants.TO_DATE %>"
			class="textbox_date" MAXLENGTH="30" / tabindex=1 /> <img
			id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.indent.<%= RequestConstants.TO_DATE%>,true);"
			class="calender" /> <br />
		<label class="bodytextB_blue">Quotation No:</label> <select
			name="<%=RequestConstants.QUOTATION_NO%>">
			<option value="0">Select</option>
			<%
				for (StoreQuotationReceiptM storeQuotationM :searchQuotationList ) {
			%>

			<option value=<%=storeQuotationM.getQuotationNo()%>><%=storeQuotationM.getQuotationNo()%></option>

			<%
				}
			%>
		</select> <br />
		<input type="button" class="smbutton" value="Go!"
			onClick="submitForm('indent','stores?method=searchQuotation');" /></td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<jsp:include page="searchResultPO.jsp" /> <br />
<div id="searcharea">
<div class="search">
<form name="searchIndent" method="post" action=""><font
	class="bodytextB_blue">Quotation type</font> <input type="radio"
	name="<%=RequestConstants.REQUEST_TYPE %>" value="0" class="checkbox"
	checked="checked" /> <font class="bodytextB_blue">Regular</font> <input
	type="radio" name="<%=RequestConstants.REQUEST_TYPE %>" value="1"
	class="checkbox" /> <font class="bodytextB_blue">Annual</font></form>
</div>
</div>



<form name="zzzz" method="post"><span class="bodytextB_blue">Qut
Request No: </span> <input type="text"
	name="<%=RequestConstants.QUOTATION_REQUEST_NO %>" value="45"
	class="textbox_size20" MAXLENGTH="8"/  > <span
	class="bodytextB_blue">Quotation Date:</span> <input type="text"
	name="<%=RequestConstants.QUOTATION_DATE %>" class="textbox_date"
	readonly="readonly" MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.zzzz.<%= RequestConstants.QUOTATION_DATE%>,true);"
	class="calender" /> <span class="bodytextB_blue">Quotation No:</span>
<input type="text" name="<%=RequestConstants.QUOTATION_NO%>" value=""
	class="textbox_size20" MAXLENGTH="30" /> <br />

<span class="bodytextB_blue">Vendor Name:</span> <select
	name="<%=RequestConstants.STORE_SUPPLIER_ID%>">
	<option value="0">Select</option>
	<%
				for (MasStoreSupplier storeSupplier :supplierList ) {
			%>

	<option value=<%=storeSupplier.getSupplierName()%>><%=storeSupplier.getSupplierName()%></option>

	<%
				}
			%>
</select> <span class="bodytextB_blue">Delivery Terms:</span> <textarea
	name="<%=RequestConstants.DELIVERY_TERMS%>" cols="25" rows="3"
	validate="Remarks,string,no"></textarea> <span class="bodytextB_blue">Payment
Terms:</span> <textarea name="<%=RequestConstants.PAY_TERMS%>" cols="25"
	rows="3" validate="PayTerms,string,no"></textarea> <input type="hidden"
	name="<%=RequestConstants.NO_OF_ROWS%>" id="rr" value="22" /> <br />
<input type="button" class="button" value="Add Row"
	onclick="generateRow();" align="right" /> <input type="button"
	class="button" value="Remove" onclick="removeRow();" align="right" />

<input type="hidden" name="hdb" value="1" id="hdb" />

<fieldset style="width: 99%; padding-left: 9px;"><legend>QuotationReceipt
details</legend>


<div
	style="overflow: auto; width: 100%; height: 200px; padding-left: 9px;">
<table width="85%" colspan="7" id="vendorReturnDetails"
	class="grid_header" border="1" cellpadding="0" cellspacing="0">

	<thead>
		<tr>

			<td width="5%">&nbsp;</td>
			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>

			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">Quoted
			Qty</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Free
			Qty</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Unit
			Rate</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Discount</label>
			<td width="13%"><label valign="left" class="smalllabel">Tax</label>
			<td width="13%"><label valign="left" class="smalllabel">Final
			Amount</label>
			<td width="13%"><label valign="left" class="smalllabel">Free
			Item</label>
			<td width="13%"><label valign="left" class="smalllabel">Manufacturer</label>
			<td width="13%"><label valign="left" class="smalllabel"></label>
		</tr>
	</thead>
	<tbody>

		<tr>
			<td width="5%"><input type="checkbox" class="checkbox"
				name="checkbox" value="checkbox" tabindex=2 /></td>
			<td width="5%"><input type="text" size="2" class="smcaption"
				value="1" name="<%=RequestConstants.SR_NO%>" /></td>
			<td width="10%"><select name="<%= RequestConstants.ITEM_ID%>"
				class="selectgrid" tabindex=2>
				<option value="0">Select</option>
				<%
					for (MasStoreItem masItem :itemList ) {
				%>

				<option value=<%=masItem.getId()%>><%=masItem.getNomenclature()%></option>

				<%
					
					}
				%>
			</select>
			<td width="10%"><input type="text" class="bigcaption" value="1"
				name="<%=RequestConstants.NOMENCLATURE%>" id="" tabindex=2 /></td>
			<td width="10%">
			<td width="8%"><select
				name="<%= RequestConstants.UNIT_OF_MEASUREMENT_ID %>"
				class="selectgrid">
				<option value="">Select</option>
				<%
				  	for (MasUnitOfMeasurement masUnitOfMeasurement : uomList) {
				  	%>
				<option value="<%=masUnitOfMeasurement.getId ()%>"><%=masUnitOfMeasurement.getUnitOfMeasurementName()%></option>
				<%
				  		  		}
  		  				  %>
				<% 
				MasUnitOfMeasurement  masUnitOfMeasurement = new MasUnitOfMeasurement();
 				if (uomList.size() != 0 && uomList != null)
 					for (int i = 0; i < uomList.size(); i++) {
 						masUnitOfMeasurement = (MasUnitOfMeasurement) uomList.get(i);
 			%>



				<%} %>
			</select></td>

			<td width="10%"><input type="text" class="medcaption" value="2"
				name="<%=RequestConstants.QUANTITY_ORDERED%>" id="" tabindex=2 /></td>
			<td width="10%"><input type="text" class="medcaption" value="2"
				name="<%=RequestConstants.FREE_QTY%>" id="" tabindex=2 /></td>
			<td width="10%"><input type="text" class="medcaption" value="2"
				name="<%=RequestConstants.RATE%>" id="" tabindex=2 /></td>
			<td width="10%"><input type="text" class="medcaption" value="2"
				name="<%=RequestConstants.DISCOUNT%>" id="" tabindex=2 /></td>
			<td width="10%"><input type="text" class="medcaption" value="2"
				name="<%=RequestConstants.TAX%>" id="" tabindex=2 /></td>
			<td width="10%"><input type="text" class="medcaption" value="2"
				name="<%=RequestConstants.AMOUNT%>" id="" tabindex=2 /></td>
			<td width="10%"><input type="text" class="medcaption" value="2"
				name="<%=RequestConstants.FREE_ITEM%>" id="" tabindex=2 /></td>

			<td width="8%"><select
				name="<%= RequestConstants.MANUFACTURER_ID %>" class="selectgrid">
				<option value="">Select</option>
				<%
				  	for (MasManufacturer masManufacturer : manufacturerList) {
				  	%>
				<option value="<%=masManufacturer.getId()%>"><%=masManufacturer.getManufacturerName()%></option>
				<%
				  		  		}
  		  				  %>
				<% 
			MasManufacturer  masManufacturer = new MasManufacturer();
 				if (manufacturerList.size() != 0 && manufacturerList != null)
 					for (int i = 0; i < manufacturerList.size(); i++) {
 						masManufacturer = (MasManufacturer) manufacturerList.get(i);
 			%>


				<%} %>
			</select></td>
			<td width="10%"><input type="button" onclick="removeRow(this)"
				name="Submit" value="Delete" class="smbutton" /></td>
	</tbody>
</table>
</br>
</fieldset>
</div>
<br />
<br />
<br />
<input type="button" name="sss" align="right" class="button"
	value="Submit"
	onclick="submitForm('zzzz','stores?method=addQuotationReceipt');" />
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
<input type="hidden" name="rows" id="rr" value="1" />

</form>

</div>
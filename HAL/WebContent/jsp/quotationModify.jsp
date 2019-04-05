<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * quotationModify.jsp  
 * Purpose of the JSP -  This is for Quotation Modify.
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
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.StoreQuotationReceiptM"%>
<%@page import="jkt.hms.masters.business.StoreQuotationReceiptT"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

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
	List<StoreQuotationReceiptM> searchQuotationList = new ArrayList<StoreQuotationReceiptM>();
	List<StoreQuotationReceiptM> gridQuotationMList = new ArrayList<StoreQuotationReceiptM>();
	List<StoreQuotationReceiptT> gridQuotationTList = new ArrayList<StoreQuotationReceiptT>();
	String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if (map.get("searchQuotationList") != null)
		searchQuotationList = (List) map.get("searchQuotationList");
	if (map.get("gridQuotationMList") != null)
		gridQuotationMList = (List) map.get("gridQuotationMList");
	if (map.get("masterId") != null)
		masterId = (Integer) map.get("masterId");
	if (map.get("gridQuotationTList") != null)
		gridQuotationTList = (List) map.get("gridQuotationTList");

	System.out.println("masterId                 " + masterId);
	System.out.println("gridQuotationMList gridQuotationMList "
			+ gridQuotationMList.size());
%>

<div id="contentspace">
<form name="indent" method="post" action=""><br />

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
					onClick="submitForm('searchIndent','stores?method=showIndentJsp');" /></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');" /></td>
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









<br />

<%
			for (StoreQuotationReceiptM grStoreQuotationM : gridQuotationMList) {
		%> <input type="hidden" name="<%=RequestConstants.MASTER_ID%>"
	value="<%=grStoreQuotationM.getId()%>"> <label
	class="bodytextB_blue"><font id="error"></font> Quotation
Receipt No.: </label> <input type="text" name=""
	value="<%=grStoreQuotationM.getQuotationRequestId()%>"
	class="textbox_size20"/  > <label class="bodytextB_blue"><font
	id="error"></font>Quotation No:</label> <input type="text"
	name="<%=RequestConstants.QUOTATION_NO %>"
	value="<%=grStoreQuotationM.getQuotationNo()%>" class="textbox_size20"
	MAXLENGTH="20" /> <label class="bodytextB_blue"><font
	id="error"></font>Quotation Date:</label> <input type="text"
	name="<%=RequestConstants.QUOTATION_DATE %>"
	value="<%=grStoreQuotationM.getQuotationDate()%>"
	class="textbox_size20" MAXLENGTH="30" /> <label class="bodytextB_blue"><font
	id="error"></font>Vendor Name</label> <input type="text"
	name="<%= RequestConstants.STORE_SUPPLIER_ID%>"
	value="<%=grStoreQuotationM.getSupplier().getSupplierName()%>"
	class="textbox_size20" MAXLENGTH="30"/ > <br />
<label class="bodytextB_blue"><font id="error"></font>Delivery
Terms:</label> <input type="text" name="<%=RequestConstants.DELIVERY_TERMS %>"
	value="<%=grStoreQuotationM.getDeliveryTerms()%>"
	class="textbox_size20" MAXLENGTH="20" /> <label class="bodytextB_blue"><font
	id="error"></font>Payment Terms:</label> <input type="text"
	name="<%=RequestConstants.PAY_TERMS %>"
	value="<%=grStoreQuotationM.getPaymentTerms()%>" class="textbox_size20"
	MAXLENGTH="20" /> <input type="hidden"
	name="<%=RequestConstants.NO_OF_ROWS%>" id="rr" value="" /> <%
				}
			%> <br />

<a href="#" onclick="removeRow('2');"><u>Delete</u></a>

<fieldset style="width: 98%;"><legend>Quotation
details</legend>

<div style="overflow: auto; width: 100%; height: 150px;">

<table width="98%" colspan="7" id="indentDetails">
	<thead>

		<tr>

			<td width="8%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="8%"><label valign="left" class="smalllabel">Item
			Code</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Item
			Name</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Quoted
			Quantity</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Free
			Quantity</label></td>

			<td width="9%"><label valign="left" class="smalllabel">UOM</label>
			</td>

			<td width="9%"><label valign="left" class="smalllabel">Rate</label>
			</td>
			<td width="9%"><label valign="left" class="smalllabel">Discount(%)</label>
			</td>
			<td width="9%"><label valign="left" class="smalllabel">Sales
			Tax(%)</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Amount</label>
			</td>
			<td width="9%"><label valign="left" class="smalllabel">Free
			Item</label></td>
			<td width="11%"><label valign="left" class="smalllabel">Manufacturer</label>
			</td>
		</tr>
	</thead>
	<tbody>
		<%
			for (StoreQuotationReceiptT storeQuotationReceiptT: gridQuotationTList) {
				if (storeQuotationReceiptT.getMaster().getId()== masterId){
					System.out.println("MASTER ID AFTER IF LOOP   "+masterId);
		%>
		<tr>
			<td width="10%"><input type="hidden" class="textbox_size20"
				value="<%=storeQuotationReceiptT.getId() %>"
				name="<%=RequestConstants.DETAIL_ID %>" id="" /> <input type="text"
				class="textbox_size20" value="2" name="<%=RequestConstants.SR_NO %>"
				id="" /></td>

			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeQuotationReceiptT.getItem().getPvmsNo()%>"
				name="<%=RequestConstants.ITEM_CODE%>" id="" /></td>
			<td width="10%"><input type="hidden" class="textbox_size20"
				value="<%=storeQuotationReceiptT.getItem().getId()%>"
				name="<%=RequestConstants.ITEM_ID %>" id="" /> <input type="text"
				class="textbox_size20"
				value="<%=storeQuotationReceiptT.getItem().getNomenclature()%>"
				name="<%=RequestConstants.ITEM_NAME%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeQuotationReceiptT.getQuotedQty()%>"
				name="<%=RequestConstants.QUANTITY_ORDERED%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeQuotationReceiptT.getFreeQty()%>"
				name="<%=RequestConstants.FREE_QTY%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeQuotationReceiptT.getUnitOfMeasurement().getUnitOfMeasurementName()%>"
				id="" /> <input type="hidden" class="textbox_size20"
				value="<%=storeQuotationReceiptT.getUnitOfMeasurement().getId()%>"
				name="<%=RequestConstants.UNIT_OF_MEASUREMENT_ID %>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeQuotationReceiptT.getUnitPrice()%>"
				name="<%=RequestConstants.RATE%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeQuotationReceiptT.getDiscount()%>"
				name="<%=RequestConstants.DISCOUNT%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeQuotationReceiptT.getTax()%>"
				name="<%=RequestConstants.TAX%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeQuotationReceiptT.getNetPrice()%>"
				name="<%=RequestConstants.NET_PRICE%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeQuotationReceiptT.getFreeItem()%>"
				name="<%=RequestConstants.FREE_ITEM%>" id="" /></td>
			<td width="10%"><input type="hidden" class="textbox_size20"
				value="<%=storeQuotationReceiptT.getManufacturer().getId()%>"
				name="<%=RequestConstants.MANUFACTURER_ID %>" id="" /> <input
				type="text" class="textbox_size20"
				value="<%=storeQuotationReceiptT.getManufacturer().getManufacturerName()%>"
				id="" /></td>
			<%
				}
				 }
						%><br />
	</tbody>
</table>
</br>
</fieldset>
</div>


<input type="hidden" name="rows" id="rr" value="1" />
<input type="submit" name="submit" align="right" class="button"
	value="Update"
	onclick="submitForm('indent','stores?method=updateQuotationReceipt');" />
</form>

</div>
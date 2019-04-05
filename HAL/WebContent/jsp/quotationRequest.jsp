<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * quotationRequest.jsp  
 * Purpose of the JSP -  This is for Quotation Request .
 * @author  Deepti
 * @author  Mansi
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.4
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.PoDetail"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasUnitOfMeasurement"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>

<%@page import="jkt.hms.masters.business.StoreQuotationRequestM"%>
<%@page import="jkt.hms.util.RequestConstants"%>
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

 var numLinesAdded = 1;
  var tt;
   function removeRow(obj)
 		
	{
	    alert(" obj "+obj)
		var d=document.getElementById("indentDetails");
		alert(" d "+d)
		if(document.getElementById("indentDetails").childNodes[1].childNodes.length>1)	
		{
			alert(" if")
			//tt = document.getElementById("indentDetails");
		    //tt = document.getElementById("indentDetails").childNodes[1].removeChild(obj.parentNode.parentNode);
			//tt.deleteRow(document.getElementById("indentDetails").childNodes[1])
			
			document.getElementById('indentDetails').deleteRow(2)
			
      		alert(" ifww")
      		
      		
		}
		else
		{
			
		 	alert("Bill should have atleast one row");
		}
		numLinesAdded--;
	}
 
	function generateRow() {
	
		var d=document.getElementById("indentDetails").getElementsByTagName("tr");
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
<div id="contentspace">
<form name="indent" method="post">
<% 
	Map map= new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
		
			
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	if(map.get("supplierList") != null){
		supplierList = (ArrayList) map.get("supplierList");
		session.setAttribute("supplierList",supplierList);
	}else if(session.getAttribute("supplierList") != null){
		supplierList = (ArrayList)session.getAttribute("supplierList");
		
	}
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	if(map.get("itemList") != null){
		itemList = (ArrayList) map.get("itemList");
		session.setAttribute("itemList",itemList);
	}else if(session.getAttribute("itemList") != null){
		itemList = (ArrayList)session.getAttribute("itemList");
		System.out.println("itemList   "+itemList.size());

		
	}
	List<MasUnitOfMeasurement> uomList = new ArrayList<MasUnitOfMeasurement>();
	if(map.get("uomList") != null){
		uomList = (ArrayList) map.get("uomList");
		session.setAttribute("uomList",uomList);
	}else if(session.getAttribute("uomList") != null){
		uomList = (ArrayList)session.getAttribute("uomList");
		
	}
	List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
	if(map.get("manufacturerList") != null){
		manufacturerList = (ArrayList) map.get("manufacturerList");
		session.setAttribute("manufacturerList",manufacturerList);
	}else if(session.getAttribute("manufacturerList") != null){
		manufacturerList = (ArrayList)session.getAttribute("manufacturerList");
		
	}
	List<StoreQuotationRequestM> searchQuotationRequestList = new ArrayList<StoreQuotationRequestM>();
	if(map.get("searchQuotationRequestList")!=null)
		searchQuotationRequestList = (List) map.get("searchQuotationRequestList");
	int maxIndentNo=0;
	List<StoreQuotationRequestM> requestList = new ArrayList<StoreQuotationRequestM>();
	if(map.get("requestList")!=null)
		requestList= (List)map.get("requestList");
	%> <br />

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
					onClick="submitForm('request','stores?method=showQuotationRequestJsp');"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('request','stores?method=modifyQuotationRequest');"></td>
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
		Date :</label> <input type="text" name="<%= FROM_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.poMain.<%= FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= TO_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.poMain.<%= TO_DATE%>,true);"
			class="calender" /> <br />

		<label class="bodytextB_blue">Quotation Request No:</label> <select
			name="<%=REQUEST_NO%>">
			<option value="0">Select</option>
			<%
					for (StoreQuotationRequestM storeQuotationRequestM :searchQuotationRequestList ) {
				%>

			<option value=<%=storeQuotationRequestM.getRequestNo()%>><%=storeQuotationRequestM.getRequestNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('indent','stores?method=searchQuotationRequest');" />
		</td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<jsp:include page="searchResultPO.jsp" />


<div id="searcharea">
<div class="search">
<form name="searchIndent" method="post" action=""><font
	class="bodytextB_blue" style="font-weight: bold;">Request type</font> <input
	type="radio" name="<%=REQUEST_TYPE %>" value="0" class="checkbox"
	checked="checked" /> <font class="bodytextB_blue">Regular</font> <input
	type="radio" name="<%=REQUEST_TYPE %>" value="1" class="checkbox" /> <font
	class="bodytextB_blue">Annual</font></form>
</div>
</div>

<br />

<form name="request" method="post"><span class="bodytextB_blue">Qut
Request No: </span> <input type="text" name="ghfghhj" value=""
	class="textbox_size20" MAXLENGTH="8"/  > <span
	class="bodytextB_blue">Quotation Date:</span> <input type="text"
	name="<%=RequestConstants.QUOTATION_DATE %>" class="textbox_date"
	readonly="readonly" MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.request.<%= RequestConstants.QUOTATION_DATE%>,true);"
	class="calender" /> <span class="bodytextB_blue">Exp Del date:</span>
<input type="text" name="<%=RequestConstants.EXPECTED_DELIVERY_DATE %>"
	class="textbox_date" readonly="readonly" MAXLENGTH="30" / tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.request.<%= RequestConstants.EXPECTED_DELIVERY_DATE%>,true);"
	class="calender" /> <br>
<span class="bodytextB_blue">Validity End date:</span> <input
	type="text" name="<%=RequestConstants.VALIDITY_END_DATE %>"
	class="textbox_date" readonly="readonly" MAXLENGTH="30" / tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.request.<%= RequestConstants.VALIDITY_END_DATE%>,true);"
	class="calender" /> <span class="bodytextB_blue">Vendor Name:</span> <select
	name="<%= STORE_SUPPLIER_ID%>" property="metrics" size="4"
	multiple="true">
	<option value="0">Select</option>
	<%
				for (MasStoreSupplier storeSupplier :supplierList ) {
			%>

	<option value=<%=storeSupplier.getSupplierName()%>><%=storeSupplier.getSupplierName()%></option>

	<%
				}
			%>
</select> <br />


<input type="hidden" name="<%=NO_OF_ROWS%>" id="rr" value="22" /> <input
	type="button" class="button" value="Add Row" onclick="generateRow();"
	align="right" /> <input type="hidden" name="hdb" value="1" id="hdb" />

<fieldset style="width: 98%;"><legend>Quotation
Request details</legend>

<div style="overflow: auto; width: 100%; height: 150px;">

<table width="64%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="2%">&nbsp;</td>
			<td width="3%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">PVMS/NIV
			No</label></td>

			<td width="15%"><label valign="left" class="smalllabel">Description</label></td>


			<td width="15%"><label valign="left" class="smalllabel">Requested
			Qty</label></td>


			<td width="8%"><label valign="left" class="smalllabel">UOM</label></td>


			<td width="9%"><label valign="left" class="smalllabel">Manufacturer</label></td>
			<td width="34%">&nbsp;</td>
		</tr>
	</thead>
	<tbody>

		<tr>
			<td width="2%"><input type="checkbox" class="checkbox"
				name="checkbox" value="checkbox" /></td>
			<td width="3%"><input type="text" class="smcaption" size="2"
				value="1" name="<%=SR_NO%>" id="<%=SR_NO%>" /></td>
			<td width="9%"><select name="<%= ITEM_ID%>">
				<option value="0">Select</option>
				<%
					for (MasStoreItem masItem :itemList ) {
						System.out.println("itemList !!!!  "+itemList.size());

				%>

				<option value=<%=masItem.getId()%>><%=masItem.getPvmsNo()%></option>

				<%
					
					}
				%>
			</select> <% 
			MasStoreItem  masItem = new MasStoreItem();
 				if (itemList.size() != 0 && itemList != null)
 					for (int i = 0; i < itemList.size(); i++) {
 						masItem = (MasStoreItem) itemList.get(i);
 			%> <%} %>
			</td>
			<td width="15%"><input type="text" class="bigcaption" value="1"
				name="<%=NOMENCLATURE%>" id="" /></td>
			<td width="15%"><input type="text" class="medcaption" value="1"
				name="<%=QUANTITY_ORDERED%>" id="" /></td>
			<td width="8%"><select name="<%= UNIT_OF_MEASUREMENT_ID %>"
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

			<td width="9%"><select name="<%= MANUFACTURER_ID %>">
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
			<td width="34%"><input type="button" onclick="removeRow(this)"
				name="Submit" value="Delete" class="smbutton" /></td>
	</tbody>
</table>
</div>
</br>

</fieldset>

<br />
<input type="button" name="sss" align="right" class="button"
	value="Submit"
	onclick="submitForm('request','stores?method=addQuotationRequest');" />
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" /></form>
</div>
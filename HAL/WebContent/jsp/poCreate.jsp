<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * poCreate.jsp  
 * Purpose of the JSP -  This is for PO Create .
 * @author  Deepti Tevatia
 * Create Date: 11th Jan,2008 
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
<%@page import="jkt.hms.masters.business.MasDepartment"%>
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
<script>
 var numLinesAdded = 1;
  
   function removeRow(obj)
  // alert(" obj "+obj)
	{
		var d=document.getElementById("poDetails");
		if(document.getElementById("poDetails").childNodes[1].childNodes.length>1)	
		{
			document.getElementById("poDetails").childNodes[1].removeChild(obj.parentNode.parentNode);
		}
		else
		{
		 	alert("Bill should have atleast one row");
		}
		numLinesAdded--;
	}
  
	function generateRow() {
	alert(" generateRow after function call ")
	
		var d=document.getElementById("poDetails");
		lastTr = d.childNodes[1].childNodes[d.childNodes[1].childNodes.length-1];
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		numLinesAdded++;
		for(i=0;i<clone.childNodes.length;i++)
		{
		
			objec = clone.childNodes[i].childNodes[0];
			
			if(objec.nodeName == 'SELECT' || objec.nodeName == 'INPUT')
			{
		//clone.childNodes[i].childNodes[0].name=objec.name.substring(0,(objec.name.indexOf('_')+1))+clone.id
				clone.childNodes[i].childNodes[0].name = objec.name;
				
				if(objec.nodeName == 'INPUT')
				{
					clone.childNodes[i].childNodes[0].value=0;
					if(objec.name=='quantity')
					{
					   clone.childNodes[i].childNodes[0].value=1.0;
					}
				}else
				{
					clone.childNodes[i].childNodes[0].value="";
				}	
				clone.childNodes[i].childNodes[0].id= objec.name + "_" + numLinesAdded;
				//alert("name" + clone.childNodes[i].childNodes[0].name);
				//alert("id" + clone.childNodes[i].childNodes[0].id);
		}	
		}
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
	}
	
	
</script>
<%
	Map map = new HashMap();
	String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	List<MasStoreSupplier> supplierListForSearch = new ArrayList<MasStoreSupplier>();
	List<PoDetail> poDetailListForSearch = new ArrayList<PoDetail>();
	List<PoHeader> poHeaderListForSearch = new ArrayList<PoHeader>(); 
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<PoDetail> poDetailList = new ArrayList<PoDetail>();
	List<PoHeader> poHeaderList = new ArrayList<PoHeader>();
	List storeList = new ArrayList();
	 includedJsp = (String) map.get("includedJsp");
	
	try {
		supplierList = (List) map.get("supplierList");
		poDetailList = (List) map.get("poDetailList");
		poHeaderList = (List) map.get("poHeaderList");

	} catch (Exception exp) {
		out.println("-------------------------------------------"+ exp);
		exp.printStackTrace();
	}
	

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
%>
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
<form name="poMain" method="post"><br />

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
<div class="page" style="width: 100%; text-align: left">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form action="" method="post">
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
		<label class="bodytextB_blue">Store Code Wise :</label> <input
			type="text" name="<%= RequestConstants.STORE_CODE_WISE %>"
			MAXLENGTH="30" / tabindex=1 /> <label class="bodytextB_blue">P.O.No:</label>
		<select name="<%=RequestConstants.PO_NO%>">
			<option value="0">Select</option>
		</select> <br />


		<label class="bodytextB_blue">Supplier Name:</label> <select
			name=<%=RequestConstants.SUPPLIER1%> id="supplierId">
			<option value="0">--Select--</option>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('poMain','purchaseOrder?method=searchPO');" /></td>
	</tr>

</table>
</form>
</div>

</div>
</div>
</div>
<jsp:include page="searchResultPO.jsp" />
<div id="NewNew"><input type="hidden"
	name="<%= RequestConstants.POJO_NAME %>" value="PoHeader"> <input
	type="hidden" name="title" value="PurchaseOrder"> <input
	type="hidden" name="<%=RequestConstants.JSP_NAME %>" value="poCreate">




<div id=biglabel class="bodytextB_blue">Quotations:</div>
<input type="text" class="textbox_size20"
	name="<%= RequestConstants.QUOTATION_ID %>" tabindex=1 />
<div id=biglabel class="bodytextB_blue">Supplier:</div>
<select name="<%= RequestConstants.SUPPLIER1 %>"
	validate="Supplier,string,no" tabindex=1>
	<option value="">Select</option>

</select>

<div id=biglabel class="bodytextB_blue">G.R.N. No.:</div>
<input type="text" class="textbox_size20"
	name="<%= RequestConstants.GRN_NO %>" value=""
	validate="Grn No,string,no" class="textbox_size20" MAXLENGTH="30"
	tabindex=1 /> <br>

<div id=biglabel class="bodytextB_blue">Store:</div>
<select name="<%= RequestConstants.DEPARTMENT_ID %>"
	validate="Department,string,no" tabindex=1>
	<option value="">Select</option>

</select>
<div id=biglabel class="bodytextB_blue">P.O.Reference No:</div>
<input type="text" name="<%= RequestConstants.PO_REFERENCE_NO %>"
	validate="Po Reference,string,no" class="textbox_size20" MAXLENGTH="30"
	tabindex=1 /> <br />


<div id=biglabel class="bodytextB_blue">P.O.Date :</div>
<input type="text" class="textbox_size20"
	name="<%= RequestConstants.PO_DATE %>" tabindex=1 />

<div id=biglabel class="bodytextB_blue">P.O. Time</div>
<input type="text" class="textbox_size20"
	name="<%= RequestConstants.PO_TIME %>" tabindex=1 /> <br />
<fieldset style="width: 98%;"><legend>Purchase Order</legend>

<div style="overflow: auto; width: 100%; height: 150px;">

<table width="98%" colspan="7" id="poDetails">
	<thead>
		<tr>
			<td width="10%"><label valign="left" class="smalllabel">Item
			Name</label></td>
			<td width="13%"><label valign="left" class="smalllabel">UOM</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">Quantity</label>
			</td>

			<td width="13%"><label valign="left" class="smalllabel">Rate</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">Discount
			Amount</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Sales
			Tax Amount</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Amount</label>
			</td>


		</tr>
	</thead>
	<tbody>

		<tr>
			<td width="10%"><select name="<%= RequestConstants.ITEM_ID %>"
				validate="itemGeneric,string,no" class="select_small">
				<option value="0">Select11</option>
			</select></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="0" name="<%=RequestConstants.UNIT_OF_MEASUREMENT_ID%>" id="" />
			</td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="1" name="<%=RequestConstants.QUANTITY%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="2" name="<%=RequestConstants.RATE%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="3" name="<%=RequestConstants.DISCOUNT_AMOUNT%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="4" name="<%=RequestConstants.SALES_TYPE_NAME%>" id="" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="5" name="<%=RequestConstants.AMOUNT%>" id=""
				onblur="generateRow();" /></td>
	</tbody>
</table>
</br>
</fieldset>

</div>


<div id=biglabel class="bodytextB_blue">Item Generic</div>
<select name="<%= RequestConstants.SUPPLIER1 %>"
	validate="Supplier,string,no" tabindex=1>
	<option value="">Select</option>

</select>
<div id=biglabel class="bodytextB_blue">Indent Qty:</div>
<input type="text" class="textbox_size20"
	name="<%= RequestConstants.QUOTATION_ID %>" tabindex=1 /> <br>

<div id=biglabel class="bodytextB_blue">Item Class:</div>
<select name="<%= RequestConstants.DEPARTMENT_ID %>"
	validate="Department,string,no" tabindex=1>
	<option value="">Select</option>

</select>
<div id=biglabel class="bodytextB_blue">Item Category:</div>
<select name="<%= RequestConstants.DEPARTMENT_ID %>"
	validate="Department,string,no" tabindex=1>
	<option value="">Select</option>

</select> <label>&nbsp;</label> <input type="button" name="submit" align="right"
	class="button" value="Submit"
	onclick="submitForm('indent','stores?method=addIndent');" /> <br />
<div id=biglabel class="bodytextB_blue">Manufacturer :</div>
<input type="text" class="textbox_size20"
	name="<%= RequestConstants.PO_DATE %>" tabindex=1 /> <br />
<br />
<div id=biglabel class="bodytextB_blue">Terms of payment:</div>
<input type="text" class="textbox_size20"
	name="<%= RequestConstants.PO_TIME %>" tabindex=1 />
</div>

<div id=biglabel class="bodytextB_blue">Remarks:</div>
<input type="text" class="textbox_size20"
	name="<%= RequestConstants.PO_TIME %>" tabindex=1 />
</div>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>


</form>


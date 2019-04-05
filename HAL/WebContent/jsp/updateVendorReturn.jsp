<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * updateVendorReturn.jsp  
 * Purpose of the JSP -  This is for Updating Vendor Return.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 06th Feb,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>


<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%System.out.println("-------------------------------------------------------------------This is Vendor Return Jsp"); %>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreGrnReturnM"%>
<%@page import="jkt.hms.masters.business.StoreGrnReturnT"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<script type="text/javascript" src="/hms/jsp/js/addRow.js"></script>
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
<%System.out.println("This is Vendor Return Jsp");
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
<script type="text/javascript">
var itemsArray1=new Array();
	function fill(val){
	for(i=0;i<itemsArray1.length;i++){
		if(itemsArray1[i][0]==val){
		document.getElementById('Nomenclature').value=itemsArray1[i][2]
		document.getElementById('uom').value=itemsArray1[i][3]
		}
		}
	}
</script>

<%
	System.out.println("This is Vendor Return Jsp");
	Map map = new HashMap();
	int grnMaxNo=0;
	String time="";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	try{
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	String includedJsp = null;
	}catch(Exception e){
		System.out.println("This is Vendor Return Jsp            "+e);
	}
		List<MasStoreSection> gridSectionList= new ArrayList<MasStoreSection>();
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
		List<MasStoreSupplier> masStoreSupplierList=new ArrayList<MasStoreSupplier>();
		List<MasEmployee> masEmployeeList=new ArrayList<MasEmployee>();
		List<StoreGrnReturnM>  gridStoreGrnReturnMList=new ArrayList<StoreGrnReturnM>();
		List<StoreGrnReturnT>  gridStoreGrnReturnTList=new ArrayList<StoreGrnReturnT>();
		int maxIndentNo=0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if(map.get("grnMaxNo")!=null)
		grnMaxNo=Integer.parseInt(""+map.get("grnMaxNo"));


	if(map.get("gridStoreGrnReturnMList")!=null)
		gridStoreGrnReturnMList=(List)map.get("gridStoreGrnReturnMList");
	
	if(map.get("gridStoreGrnReturnTList")!=null)
	gridStoreGrnReturnTList=(List)map.get("gridStoreGrnReturnTList");

	
	if(map.get("masStoreSupplierList")!=null)
		masStoreSupplierList=(List)map.get("masStoreSupplierList");
	if(map.get("masEmployeeList")!=null)
		masEmployeeList=(List)map.get("masEmployeeList");
	System.out.print("grnMaxNo    "+grnMaxNo);
	if(map.get("gridSectionList")!=null)
		gridSectionList=(List) map.get("gridSectionList");
	
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");
%>
<% 
			int k=0;
  					if(itemList.size()>0)
  						
 						for (MasStoreItem masStoreItem:itemList){
 							System.out.print("-----------   ----------------          "+itemList.size());
 			%>
<script>
         		 
         		itemsArray1[<%=k%>]= new Array();
         		itemsArray1[<%=k%>][0] = "<%=masStoreItem.getId()%>";
				itemsArray1[<%=k%>][1] = "<%=masStoreItem.getPvmsNo()%>";
				itemsArray1[<%=k%>][2] = "<%=masStoreItem.getNomenclature()%>";
				itemsArray1[<%=k%>][3] = "<%=masStoreItem.getItemConversion().getItemUnitName()%>";
         		
         		</script>
<%
          k++;
 						} %>
<div id="contentspace"><br />

<form name="updateVendorReturnForm" method="post">

<h2 align="left" class="style1">Vendor Return</h2>
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
			onClick="setdate('<%=currentDate%>',document.vendorReturnForm.<%= RequestConstants.FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= RequestConstants.TO_DATE %>"
			class="textbox_date" MAXLENGTH="30" / tabindex=1 /> <img
			id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.indent.<%= RequestConstants.TO_DATE%>,true);"
			class="calender" /> <br />

		<label class="bodytextB_blue">Return No:</label> <select
			name="<%= RequestConstants.RETURN_NO_TEMP%>">
			<option value="0">Select</option>

			<%
					for (StoreGrnReturnM storeGrnReturnM :gridStoreGrnReturnMList ) {
				%>

			<option value=<%=storeGrnReturnM.getReturnNo()%>><%=storeGrnReturnM.getReturnNo()%></option>

			<%
					
					}
				%>

		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('vendorReturnForm','stores?method=searchVendorReturn');" />
		</td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<jsp:include page="searchResultPO.jsp" /> <br />






<div id="testDiv">
<form name="vendorReturnFormGrid" method="post" action=""><input
	type="hidden" name="<%=RequestConstants.CHANGED_BY_HIDDEN %>"
	value="admin" /> <input type="hidden"
	name="<%=RequestConstants.CHANGED_DATE_HIDDEN %>"
	value="<%=currentDate%>" /> <input type="hidden"
	name="<%=RequestConstants.CHANGED_TIME_HIDDEN %>" value="<%=time %>" />

<%
		Date returnDate=new Date(); 
	String date4MySQL="";
		for(StoreGrnReturnM   storeGrnReturnM :gridStoreGrnReturnMList ){
			try{
		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
		  date4MySQL=formatterOut.format(formatterIn.parse(""+storeGrnReturnM.getReturnDate()));
		System.out.println("returnDate     "+date4MySQL);
		 //returnDate = java.sql.Date.valueOf(date4MySQL);
			}catch(Exception e){
				System.out.println("Exception     "+e);
			}
	%> <input type="hidden" name="<%=RequestConstants.VENDOR_RETURN_ID %>"
	value="<%=storeGrnReturnM.getId() %>" /> <label class="bodytextB_blue"><font
	id="error"></font> Return No: </label> <input type="text"
	name="<%=RequestConstants.RETURN_NO %>"
	value="<%=storeGrnReturnM.getReturnNo() %>" readonly="readonly"
	class="textbox_size20" MAXLENGTH="8"/  > <label
	class="bodytextB_blue"><font id="error"></font>Return Date:</label> <input
	type="text" name="<%= RequestConstants.RETURN_DATE %>"
	value="<%= date4MySQL%>" class="textbox_size20" MAXLENGTH="30"
	/ tabindex=1 /> <label class="bodytextB_blue"><font id="error"></font>Vendor
Name:</label> <select name="<%= RequestConstants.VENDOR_NAME%>">
	<option value="0">Select</option>
	<%
					for(MasStoreSupplier   masStoreSupplier :masStoreSupplierList ) {
						if(masStoreSupplier.getId().equals(storeGrnReturnM.getSupplier().getId()))
						
					{
						%>

	<option value="<%=masStoreSupplier.getId()%>" selected="selected"><%=masStoreSupplier.getSupplierName()%></option>
	<%
					}else{
				%>
	<option value="<%=masStoreSupplier.getId()%>"><%=masStoreSupplier.getSupplierName()%></option>
	<%
					}}
				%>

</select> <br />
<label class="bodytextB_blue"><font id="error"></font>Return By:</label>

<select name="<%= RequestConstants.RETURNED_BY%>">
	<option value="0">Select</option>
	<%
					for(MasEmployee   masEmployee :masEmployeeList ) 
					{
						if(masEmployee.getId().equals(storeGrnReturnM.getReturnBy().getId())){
						%>
	<option value="<%=masEmployee.getId()%>" selected="selected"><%=masEmployee.getEmployeeCode()%></option>
	<%
					}else{
						%>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getEmployeeCode()%></option>
	<%
					}
						
					}
					 %>
</select> <label class="bodytextB_blue"><font id="error"></font>Reference
Doc No:</label> <input type="text"
	name="<%=RequestConstants.REFERENCE_DOC_NO %>"
	value="<%=storeGrnReturnM.getRefDocNo() %>" class="textbox_size20"
	MAXLENGTH="30" /> <br />
<label class="bodytextB_blue"><font id="error"></font>Reason:</label> <textarea
	name="<%=RequestConstants.REASON %>" rows="2" cols="30"><%=storeGrnReturnM.getReason() %></textarea>


<%} %> <br />
<br />
<input type="button" class="button" value="Add Row"
	onclick="generateRow('vendorReturnDetails');" align="right" /> <input
	type="button" class="button" value="Remove"
	onclick="removeRow(this,'vendorReturnDetails')" align="right" /> <input
	type="button" name="sss" align="right" class="button" value="Submit"
	onclick="submitForm('vendorReturnFormGrid','stores?method=updateVendorReturn');" />
<input type="hidden" name="hdb" value="1" id="hdb" />

<fieldset style="width: 99%; padding-left: 9px;"><legend>Vendor
Return details</legend>


<div
	style="overflow: auto; width: 100%; height: 150px; padding-left: 9px;">
<table width="98%" colspan="7" id="vendorReturnDetails"
	class="grid_header" border="1" cellpadding="0" cellspacing="0">

	<thead>
		<tr>
			<td width="3%">&nbsp;</td>
			<td width="10%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>

			<td width="13%"><label valign="left" class="smalllabel">Return
			Qty</label></td>
			<td width="13%"><label valign="left" class="smalllabel">UOM</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Unit
			Rate</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Batch
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Expiry
			Date</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Return
			Amount</label></td>


		</tr>
	</thead>
	<tbody>
		<%
					for (StoreGrnReturnT storeGrnReturnT :gridStoreGrnReturnTList ) {
				%>
		<tr>
			<td width="5%"><input type="checkbox" class="checkbox"
				name="checkbox" value="" /> <input type="hidden"
				name="<%=RequestConstants.DETAIL_ID %>"
				value="<%=storeGrnReturnT.getId() %>" /></td>
			<td width="10%"><input type="text" size="2"
				value="<%=storeGrnReturnT.getSrNo() %>"
				name="<%=RequestConstants.SR_NO%>" id="SRNo" /> <in</td>
			<td width="10%"><select name="<%= RequestConstants.ITEM_ID%>"
				onchange="fill(this.value);">
				<option value="0">Select</option>
				<%
					for (MasStoreItem masItem :itemList ) {
						if(masItem.getId().equals(storeGrnReturnT.getItem().getId())){
				%>

				<option value=<%=masItem.getId()%> selected="selected"><%=masItem.getPvmsNo()%></option>

				<%
					
						}else{
							%>
				<option value=<%=masItem.getId()%>><%=masItem.getPvmsNo()%></option>
				<% }
						
					}
				%>
			</select></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeGrnReturnT.getItem().getNomenclature() %>"
				name="<%=RequestConstants.NOMENCLATURE%>" id="Nomenclature" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeGrnReturnT.getReturnQty() %>"
				name="<%=RequestConstants.RETURN_QTY%>" id="returnQty" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeGrnReturnT.getItem().getItemConversion().getItemUnitName() %>"
				name="<%=RequestConstants.UNIT_OF_MEASUREMENT_ID%>" id="uom" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeGrnReturnT.getUnitRate() %>"
				name="<%=RequestConstants.UNIT_RATE%>" id="unitRate" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeGrnReturnT.getBatchNo() %>"
				name="<%=RequestConstants.BATCH_NO%>" id="batchNo" /></td>
			<td width="10%">
			<%
							SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
							 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
							  date4MySQL=formatterOut.format(formatterIn.parse(""+storeGrnReturnT.getExpiryDate() ));
							
							%> <input type="text" class="textbox_size20"
				value="<%=date4MySQL%>" name="<%=RequestConstants.EXPIRY_DATE%>"
				id="expDate" onblur="addRowToTable();" /></td>
			<td width="10%"><input type="text" class="textbox_size20"
				value="<%=storeGrnReturnT.getReturnAmount() %>"
				name="<%=RequestConstants.RETURN_AMOUNT%>" id="returnAmount"
				onblur="addRowToTable();" /></td>
		</tr>
		<%} %>
	</tbody>
</table>
</br>
</fieldset>
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

</form>


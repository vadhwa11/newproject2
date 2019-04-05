<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * soDetails.jsp  
 * Purpose of the JSP -  This is showing SO Details.
 * @author  Deepali
 * @author  Mansi
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

<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreSupplyOrderEntry"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<script>
<%
 Calendar calendar=Calendar.getInstance();
 String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
 String dateCal=String.valueOf(calendar.get(Calendar.DATE));
 int year=calendar.get(calendar.YEAR);
 if(month.length()<2){
  month="0"+month;
 }
 if(dateCal.length()<2){
  dateCal="0"+dateCal;
 }
%>
 serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<%

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
	Map<String,Object> map = new HashMap<String,Object>();
	List<StoreIndentM> searchStoreIndentMList = new ArrayList<StoreIndentM>();

		List<StoreIndentT> searchStoreIndentTList = new ArrayList<StoreIndentT>();
		List<MasStoreSupplier> supplierList= new ArrayList<MasStoreSupplier>();
		List<StoreSupplyOrderEntry> searchSupplyOrderList= new ArrayList<StoreSupplyOrderEntry>();
		int indentId=0;
		if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
		if(map.get("supplierList")!=null)
			supplierList=(List) map.get("supplierList");
		if(map.get("searchStoreIndentMList")!=null)
			searchStoreIndentMList = (List)map.get("searchStoreIndentMList");
	if(map.get("searchStoreIndentTList")!=null)
		searchStoreIndentTList = (List) map.get("searchStoreIndentTList");
	if(map.get("searchSupplyOrderList")!=null)
		searchSupplyOrderList = (List) map.get("searchSupplyOrderList");

	if(map.get("indentId")!=null)
		indentId = (Integer) map.get("indentId");
	


%>
<form name="supplyOrderEntry" method="post"><input type="hidden"
	name="<%=RequestConstants.INDENT_ID_SUPPLY%>" value="<%=indentId %>">



<br>
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

		<%
		
		
		StoreIndentT  storeIndentT = new StoreIndentT();
		if (searchStoreIndentTList.size() != 0 && searchStoreIndentTList != null)
		
				for (int i = 0; i < searchStoreIndentTList.size(); i++) {
				storeIndentT = (StoreIndentT) searchStoreIndentTList.get(i);
				if(storeIndentT.getIndent().getId()==indentId){
		
		%>
		<tr>


			<td width="10%"><input type="text" size="2" class="smalllabel"
				value="<%=storeIndentT.getSerialNo()%>"
				name="<%=RequestConstants.SR_NO%>" readonly="readonly" id="" /></td>

			<td width="13%"><input type="text" class="smalllabel" size="2"
				name="<%=RequestConstants.ITEM_PVMS_NO%>"
				value="<%=storeIndentT.getItem().getPvmsNo()%>" readonly="readonly"
				id="" /> <input type="hidden"
				name="<%=RequestConstants.ITEM_ID_PVMS_NO%>"
				value="<%=storeIndentT.getItem().getId()%>"></td>

			<td width="10%"><input type="text" class="smalllabel" size="2"
				value="<%=storeIndentT.getItem().getNomenclature()%>"
				name="<%=RequestConstants.ITEM_NOMENCLATURE%>" readonly="readonly"
				id="" /> <input type="hidden"
				name="<%=RequestConstants.ITEM_ID_NOMENCLATURE%>"
				value="<%=storeIndentT.getItem().getId()%>"></td>


			<td width="13%"><input type="text" class="smalllabel" size="2"
				value="<%=storeIndentT.getItem().getItemConversion().getItemUnitName() %>"
				name="<%=RequestConstants.ITEM_AV%>" readonly="readonly" id="" /> <input
				type="hidden" name="<%=RequestConstants.ITEM_ID_AV%>"
				value="<%=storeIndentT.getItem().getItemConversion().getId()%>">
			</td>

			<td width="13%"><input type="text" class="smalllabel" size="2"
				value="<%=storeIndentT.getQtyInMmf()%>"
				name="<%=RequestConstants.INDENT_T_QTY_IN_MMF%>" readonly="readonly"
				id="" /> <input type="hidden"
				name="<%=RequestConstants.INDENT_T_ID_QTY_IN_MMF%>"
				value="<%=storeIndentT.getId()%>"></td>


			<%	
				int supplierId=0;
				if(storeIndentT.getItem().getSupplier() != null){
					supplierId = storeIndentT.getItem().getSupplier().getId();
				}
			%>
			<td width="13%"><select
				name="<%=RequestConstants.SUPPLIER_ID_VENDOR_NAME%>"
				validate="Supplier,string,yes">
				<option value="0">Select</option>
				<%
						for (MasStoreSupplier masStoreSupplier :supplierList ) {
							if(supplierId == masStoreSupplier.getId()){
					%>
				<option value="<%=masStoreSupplier.getId()%>" selected="selected"><%=masStoreSupplier.getSupplierName()%></option>
				<%}else{ %>
				<option value="<%=masStoreSupplier.getId()%>"><%=masStoreSupplier.getSupplierName()%></option>
				<%}
					} %>
			</select> <input type="hidden"
				name="<%=RequestConstants.SUPPLIER_ID_VENDOR_NAME%>"
				value="<%=supplierId%>"></td>

			<%} } %>
			<%
			String SupplyOrderStatus="no";
			if (searchSupplyOrderList.size() != 0 && searchSupplyOrderList != null)
				
			for (StoreSupplyOrderEntry storeSupplyOrderEntry : searchSupplyOrderList) {
				if(storeSupplyOrderEntry.getIndent().getId()==indentId){
					SupplyOrderStatus="yes";
				
				%>
			<input type="hidden" name="<%=RequestConstants.SUPPLY_ORDER_ID %>"
				value="<%=storeSupplyOrderEntry.getId() %>" />
			<td width="13%"><input type="text"
				validate="Supply Order No,string,yes" class="smalllabel"
				value="<%=storeSupplyOrderEntry.getSupplyOrderNo()%>"
				name="<%=RequestConstants.SUPPLY_ORDER_NO%>" id="" /></td>




			<td width="13%"><input type="text"
				name="<%=RequestConstants.FIRST_REC_DATE%>"
				value="<%=HMSUtil.changeDateToddMMyyyy(storeSupplyOrderEntry.getSupplyOrderDate())%>"
				class="textbox_date" validate="Supply Order Date,date,yes"
				MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				tabindex="1"
				onClick="setdate('<%=date%>',document.supplyOrderEntry.<%=RequestConstants.FIRST_REC_DATE%>,event)" />
			</td>


			<td width="13%"><input type="text" validate="Rate,num,yes"
				class="smalllabel" value="<%=storeSupplyOrderEntry.getRate()%>"
				name="<%=RequestConstants.RATE%>" id="" /></td>


			<input type="hidden" name="<%=RequestConstants.CHANGED_BY %>"
				value="<%=userName%>" />
			<input type="hidden" name="<%=RequestConstants.CHANGED_DATE %>"
				value="<%=date%>" />
			<input type="hidden" name="<%=RequestConstants.CHANGED_TIME %>"
				value="<%=time%>" />
			<%
				} 
				
				}
			
			if(SupplyOrderStatus.equals("no")) { 	
			%>
			<td width="13%"><input type="text"
				validate="Supply Order No,string,yes" class="smalllabel"
				name="<%=RequestConstants.SUPPLY_ORDER_NO%>" value="" id="" /></td>


			<td width="13%"><input type="text"
				name="<%=RequestConstants.FIRST_REC_DATE%>" class="textbox_date"
				validate="Supply Order Date,date,yes" MAXLENGTH="30" /> <img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender" tabindex="1"
				onClick="setdate('<%=date%>',document.supplyOrderEntry.<%=RequestConstants.FIRST_REC_DATE%>,event)" />


			</td>




			<td width="13%"><input type="text" validate="Rate,num,yes"
				class="smalllabel" name="<%=RequestConstants.RATE%>" id="" /></td>


			<input type="hidden" name="<%=RequestConstants.CHANGED_BY %>"
				value="<%=userName%>" />
			<input type="hidden" name="<%=RequestConstants.CHANGED_DATE %>"
				value="<%=date%>" />
			<input type="hidden" name="<%=RequestConstants.CHANGED_TIME %>"
				value="<%=time%>" />


			<%		
				 }
			%>
		</tr>

	</tbody>
</table>
</br>
</fieldset>
</form>



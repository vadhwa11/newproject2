<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * poMain.jsp  
 * Purpose of the JSP -  This is for PO Main form .
 * Revision Date:      
 * Revision By:  
 * @version 1.5
--%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css" id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
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
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
	List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();
	includedJsp = (String) map.get("includedJsp");

	try {
		supplierList = (List<MasStoreSupplier>) map.get("supplierList");
		poDetailList = (List<StorePoDetail>) map.get("poDetailList");
		poHeaderList = (List<StorePoHeader>) map.get("poNumberList");
	} catch (Exception exp) {
		exp.printStackTrace();
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>
<script type="text/javascript" language="javascript">
function requiredFields(){
 for(var i = 0; i < document.getElementsByName('parent').length; i++){
			  if(document.getElementsByName('parent')[i].checked == true)
              {
                return true;
			  }		
  		}
  		alert("Please select the Local Supply Order !!")
		return false;
}
function showReport()
{
  var poNo;
  
 	for(var i = 0; i < document.getElementsByName('parent').length; i++){
			  if(document.getElementsByName('parent')[i].checked == true)
              {
                submitForm('poMain','neStores?method=printLocalSupplyOrder&po_id='+document.getElementsByName('parent')[i].value);
                return true;
			  }		
  		}
  		alert("Please select the Local Supply Order!!!")
		return false;
  //if(requiredFields()){
  //submitForm('poMain','purchaseOrder?method=printLocalSupplyOrder');
 
 // }
}  
</script>
<div id="contentHolder">
<form name="poMain" method="post">
<div align="center">
<div class="page" style="width: 100%; text-align: left">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form action="" method="post">
<table width="684" border="0" cellpadding="0" cellspacing="0" style="border: 1px solid #7f9db7;">
<tr>
	<td height="35" colspan="9" class="thead">Search Panel<a name="goto_threadsearch"></a></td>
</tr>
	<tr class="vbmenu_option">
		<td width="74" height="24" valign="middle" title="nohilite"><input
			type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
			type="hidden" name="do" value="process" /> <input type="hidden"
			name="searchthread" value="1" /> <input type="hidden"
			name="showposts" value="1" /> <input type="hidden"
			name="searchthreadid" value="85875" /> <span >From Date</span></td>
		<td width="174" valign="middle" title="nohilite"><input
			type="text" name="<%=FROM_DATE%>" value="" class="textbox_date"
			validate="From Date,dateOfAdmission,no" MAXLENGTH="30" /></td>
		<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date" class="calender"
			tabindex="1"
			onClick="setdate('<%=currentDate%>',document.poMain.<%=FROM_DATE%>,event)" />
		</td>

		<td width="144" valign="middle" title="nohilite"><span>To Date</span></td>
		<td width="144" valign="middle" title="nohilite"><input
			type="text" name="<%=TO_DATE%>" value="" class="textbox_date"
			validate="To Date,dateOfAdmission,no" MAXLENGTH="30" /></td>
		<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date" class="calender"
			tabindex="1"
			onClick="setdate('<%=currentDate%>',document.poMain.<%=TO_DATE%>,event)" />
		</td>
	</tr>
	<tr class="vbmenu_option">
		<td><span>SO No.</span></td>
		<td width="144" valign="middle" title="nohilite"><select
			name="<%=PO_ID%>">
			<option value="0">Select</option>
			<%
				for(StorePoHeader obj: poHeaderList){
			%>
			<option value="<%=obj.getId() %>"><%=obj.getPoNumber() %></option>
			<%} %>
		</select></td>
		<td></td>
		<!-- -
		<td><span>Supplier Name:</span></td>
		<td width="144" valign="middle" title="nohilite"><select
			name="<%= SUPPLIER_ID %>" id="supplierId"
			validate="Vendor Name,String,no">
			<option value="0">--Select--</option>
			<%
			for (MasStoreSupplier masStoreSupplier :supplierList ) {
%>
			<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%></option>
			<%	}%>
		</select></td> -->
<td width="144" valign="middle" title="nohilite">
<input type="button" class="smbutton" value="Go!" onClick="submitForm('poMain','purchaseOrder?method=searchPO');" /> 
<!-- onkeypress="return submitenter(this,event,'purchaseOrder?method=searchPO')" -->
</td>
	</tr>
</table>
</form>
</div>
<br>
</div>
</div>
</div>
<jsp:include page="searchResultBlock.jsp" /> <%
 	if (includedJsp != null) {
 %> <jsp:include page="non_poDetail.jsp" /> <%
 	} %>
</div>
<script type="text/javascript">
<!-- 
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
<div class="clear"></div>
<div class="clear"></div>
<input type="hidden" name="print" type="submit" class="button" value="print" onClick="showReport();">
<input type="hidden" name="Add" type="submit" value="Add" class="button">				
<input type="hidden" name="Modify" type="submit" value="Modify" 	class="button" onClick="if(requiredFields()){submitForm('poMain','purchaseOrder?method=poModifyJsp');}">			
<input type="hidden" name="Reset" type="submit" value="Reset" class="button">				
<input type="hidden" name="Delete" type="submit" value="Delete" class="button">	
<div class="clear"></div>
</form>
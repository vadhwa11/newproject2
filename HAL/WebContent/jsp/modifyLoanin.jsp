<%@page import=" static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreLoaninM"%>
<%@page import="jkt.hms.masters.business.StoreLoaninT"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">


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
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>
<script type="text/javascript" language="javascript">
var itemsArray1=new Array();
 var numLinesAdded = 1;
  var tt;
 
 
  
  function checkForSubmit(){
  if(document.getElementById('noOfRows').value==0)
  {alert("There must be one detail row");
  return false;
  }else{
  return true;
  }
  }
function get_value(rowNo,detailId)
{

 var url="/hms/hms/stores?method=showMoreInfoLoanIn&detailId="+detailId+"&rowNo="+rowNo;
   popwindow(url);
 } 
var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name',"height=500,width=600,status=1");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();

}

function fillSrNo(rowVal){
	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%10
   		if(rowVal==0){
   			rowVal=10
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}
	
	
	
function checkForLoanIn(val,a,inc)
{
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*10)+1;
    	var end=((pageNo-1)*10)+10;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	   
		ajaxFunctionForAutoCompleteInLoanIn('grnGrid','stores?method=fillItemsForLoanIn&requiredField=' + pvms , inc);
		
}
	
	
</script>
<%
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage="no";
	int pageNo=1;
	int loanInId=0;
		List<StoreLoaninM>searchLoanInList= new ArrayList<StoreLoaninM>();
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
		List<StoreGrnM> previousStoreGrnMList=new ArrayList<StoreGrnM>();
		List<StoreLoaninT> storeLoanInTList = new ArrayList<StoreLoaninT>();
		List<StoreLoaninM> storeLoanInMList = new ArrayList<StoreLoaninM>();
		int maxLoaninNo=0;
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
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if(map.get("employeeList") != null){
		employeeList = (ArrayList) map.get("employeeList");
		session.setAttribute("employeeList",employeeList);
	}else if(session.getAttribute("employeeList") != null){
		employeeList = (ArrayList)session.getAttribute("employeeList");
		
	}
	List<StorePoHeader> poList = new ArrayList<StorePoHeader>();
	if(map.get("poList") != null){
		poList = (ArrayList) map.get("poList");
		session.setAttribute("poList",poList);
	}else if(session.getAttribute("poList") != null){
		poList = (ArrayList)session.getAttribute("poList");
		
	}
	
	List<StoreIndentM> indentList = new ArrayList<StoreIndentM>();
	if(map.get("indentList") != null){
		indentList = (ArrayList) map.get("indentList");
		session.setAttribute("indentList",indentList);
	}else if(session.getAttribute("indentList") != null){
		indentList = (ArrayList)session.getAttribute("indentList");
		
	}
	List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
	if(map.get("brandList") != null){
		brandList = (ArrayList) map.get("brandList");
		session.setAttribute("brandList",brandList);
	}else if(session.getAttribute("brandList") != null){
		brandList = (ArrayList)session.getAttribute("brandList");
		
	}
	if(map.get("loanInId")!=null){
		loanInId=Integer.parseInt(""+map.get("loanInId"));
		System.out.print(" loanInId    "+loanInId);
	}
	int poId = 0;
	if(map.get("poId")!=null){
		poId=Integer.parseInt(""+map.get("poId"));
		System.out.print(" poId "+poId);
	}
	
	
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}

	if(map.get("maxLoaninNo")!=null)
		maxLoaninNo=Integer.parseInt(""+map.get("maxLoaninNo"));
	

	
	if(map.get("previousStoreGrnMList")!=null)
		previousStoreGrnMList=(List) map.get("previousStoreGrnMList");
	
	if(map.get("storeLoanInTList")!=null){
		storeLoanInTList=(List) map.get("storeLoanInTList");
	}
	if(map.get("storeLoanInMList")!=null)
		storeLoanInMList=(List) map.get("storeLoanInMList");
	
	String noDetailRecords="no";
	if(map.get("noDetailRecords")!=null){
		noDetailRecords=(""+map.get("noDetailRecords"));
	}
	
	if(map.get("searchLoanInList")!=null)
		searchLoanInList = (List) map.get("searchLoanInList");
	
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	String time="";
	String date="";
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
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
					class="toolbutton"></td>
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
		Date :</label> <input type="text" name="<%= FROM_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img src="/hms/jsp/images/cal.gif"
			id="calendar" width="16" height="16" border="0"
			validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.indent.<%= FROM_DATE%>,event)" />
		<label class="bodytextB_blue">To Date :</label> <input type="text"
			name="<%= TO_DATE %>" class="textbox_date" MAXLENGTH="30"
			/ tabindex=1 /> <img src="/hms/jsp/images/cal.gif" id="calendar"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.indent.<%= TO_DATE%>,event)" />



		<br />
		<label class="bodytextB_blue">Grn No:</label> <select
			name="<%= GRN_NO%>">
			<option value="0">Select</option>
			<%
					if(searchLoanInList!=null && searchLoanInList.size()>0)
					for (StoreLoaninM storeLoaninM :searchLoanInList ) {
				%>

			<option value=<%=storeLoaninM.getLoaninNo()%>><%=storeLoaninM.getLoaninNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('indent','stores?method=searchLoanin');" /></td>
	</tr>

</table>
</form>
</div>
</div>
</div>

<br />

</form>

<form name="indentGrid" method="post">


<div id="testDiv" size="height:500px;">
<%if(previousPage.equals("no")){ %> <%
	if (map.get("storeLoanInMList") != null) {
		storeLoanInMList = (List<StoreLoaninM>)map.get("storeLoanInMList");
	}
	StoreLoaninM grnMObj = null;
	
	if(storeLoanInMList.size() > 0){
		grnMObj = (StoreLoaninM)storeLoanInMList.get(0);
		
		loanInId = grnMObj.getId();
	}
		
	%>

<div class="Clear"></div>
<div class="blockTitle">Loan In Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 185px; background-color: #f4f9fe;">
<br />

<table>
	<tr>
		<td><label class="bodytextB">Source Of Supply:</label> <input
			type="text" class="textbox_size20" name="<%= SOURCE_OF_SUPPLY %>"
			value="Local Purchase" readonly="readonly" tabindex=1 /></td>
		<td><label class="bodytextB">Loan In Number</label> <% if(grnMObj != null){ %>
		<input type="text" class="textbox_size20" name="<%= LOANIN_NO %>"
			value="<%=grnMObj.getLoaninNo()%>" readonly="readonly"
			validate="GRN Number ,String,no" tabindex=1 /> <%}else{ %> <input
			type="text" class="textbox_size20" name="<%= LOANIN_NO %>" value=""
			validate="GRN Number ,String,no" tabindex=1 /> <%} %>
		</td>
		<td><label class="bodytextB">Loan In Date :</label> <%if(grnMObj != null){ %>
		<input type="text" class="textbox_size20" name="<%= LOANIN_DATE %>"
			value="<%=grnMObj.getLoaninDate() %>" readonly="readonly" tabindex=1
			validate="GRN Date ,String,no" /> <%}else{ %> <input type="text"
			class="textbox_size20" name="<%= LOANIN_DATE %>"
			value="<%=currentDate %>" readonly="readonly" tabindex=1
			validate="GRN Date ,String,no" /> <%} %>
		</td>
	</tr>
	<tr>
		<td><label class="bodytextB">Vendor Name:</label> <select
			name="<%= SUPPLIER_ID %>" validate="Vendor Name,string,no" tabindex=1>
			<option value="">Select</option>
			<%System.out.println("supplierList" + supplierList);
	for (MasStoreSupplier masStoreSupplier :supplierList ) {
		if(grnMObj != null){
		 	if(grnMObj.getSupplier().getId().equals(masStoreSupplier.getId())){
%>

			<option value=<%=masStoreSupplier.getId()%> selected="selected"><%=masStoreSupplier.getSupplierName()%></option>
			<%      	}else{ 
%>


			<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%></option>
			<%
}}}
%>
		</select></td>
		<td><label class="bodytextB">Po Number:</label> <% if(grnMObj.getPo() != null){ %>
		<input type="text" class="textbox_size20" name="<%= PO_ID %>"
			value="<%=grnMObj.getPo().getPoNumber()%>" readonly="readonly"
			tabindex=1 /> <%}else{ %> <input type="text" class="textbox_size20"
			name="<%= PO_ID %>" value="" tabindex=1 /> <%} %>
		</td>
		<td><label class="bodytextB">Challan Number :</label> <% if(grnMObj != null){ %>
		<input type="text" class="textbox_size20" name="<%= CHALLAN_NO %>"
			value="<%=grnMObj.getChallanNo()%>" readonly="readonly" tabindex=1 />
		<%}else{ %> <input type="text" class="textbox_size20"
			name="<%= CHALLAN_NO %>" value="" tabindex=1 /> <%} %>
		</td>
	</tr>
	<tr>
		<td><label class="bodytextB">Employee Name:</label> <select
			name="<%= EMPLOYEE_ID %>" validate="Employee Name,string,no"
			tabindex=1>
			<option value="">Select</option>
			<%
	for (MasEmployee masEmployee :employeeList ) {
		if(grnMObj != null){
		 	if(grnMObj.getEmployee().getId().equals(masEmployee.getId())){
%>
			<option value=<%=masEmployee.getId()%> selected="selected"><%=masEmployee.getFirstName()+""+masEmployee.getLastName()%></option>
			<%      	}else{ 
%>
			<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName()+""+masEmployee.getLastName()%></option>
			<%
}}}
%>
		</select></td>
		<td><label class="bodytextB">Challan Date :</label> <input
			type="text" class="textbox_size20" name="<%=CHALLAN_DATE%>"
			value="<%=grnMObj.getChallanDate()%>" readonly="readonly" tabindex=1
			validate="GRN Date ,String,no" /></td>
		<td><label class="bodytextB">Remarks :</label> <% if(grnMObj != null){ %>
		<textarea value="<%=grnMObj.getRemarks()%>" name="<%=REMARKS %>"
			validate="Remarks ,String,no" tabindex=1 style="width: 310px;"
			maxlength="45" /></textarea> <%}else{ %> <textarea value="" name="<%=REMARKS %>"
			validate="Remarks ,String,no" tabindex=1 style="width: 310px;"
			maxlength="45" /></textarea> <%} %>
		</td>
	</tr>
</table>
</div>


<%
	} %>



<div style="float: left; padding-left: 15px;"><!-- 
		 <input type="button" name="sss" align="right" class="button" value="Submit" onclick="if(checkForSubmit()){submitForm('indentGrid','stores?method=updateLoanIn');}"/>
		 --></div>
<input type="hidden" name="<%=NO_DETAIL_RECORDS%>"
	value="<%=noDetailRecords%>" /> <input type="hidden" size="2"
	value="10" name="<%=NO_OF_ROWS %>" id="<%=NO_OF_ROWS %>" /> <input
	type="hidden" name="<%=LOANIN_ID %>" value="<%=loanInId%>" id="hdb" />
<input type="hidden" value="<%=poId%>" id="poId" /> <br />
<br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Loan In Details </font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />


<div
	style="overflow: auto; width: 100%; height: 280px; padding-left: 9px;">
<table width="200px" colspan="7" id="purchaseDetails"
	class="grid_header" border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="gridsmlabel">SR
			No</label></td>
			<td width="8%"><label valign="left" class="smalllabel">PVMS/NIV
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Nomenclature</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Brand
			Name</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Manufacturer
			Name</label></td>
			<td width="9%"><label valign="left" class="smalllabel">A/U</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Qty
			Recd</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Free
			Qty</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Dispen.Type</label></td>
			<td width="9%"><label valign="left" class="smalllabel">MDQ</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Rate
			Per MDQ</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Batch
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Lot
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Unit
			Rate</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Disc(%)</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Tax(%)</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Amt
			Value</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Free
			Item</label></td>
			<td width="20%"><label valign="left" class="smalllabel">Manuf.
			Date</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Expiry
			Date</label></td>

		</tr>

	</thead>
	<tbody>
		<td width="10%">
		<%
  		int detailCounter=10; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	String idBrand="idBrand";
    	String quantityInVar="quantityInVar";
    	String lotNoVar="lotNoVar";
    	String batchNoVar="batchNoVar";
    	String taxVar="taxVar";
    	String amountVar="amountVar";
    	String unitRateVar="unitRateVar";
    	String discountVar="discountVar";
    	
    	String quantityInVarTemp="quantityInVarTemp";
    	String lotNoTemp="lotNoTemp";
    	String batchNoTemp="batchNoTemp";
    	String taxVarTemp="taxVarTemp";
    	String amountVarTemp="amountVarTemp";
    	String unitRateVarTemp="unitRateVarTemp";
    	String discountVarTemp="discountVarTemp";
    	String incVar="incVar";
    	
    	String freeQty="freeQty";
    	String manufacturerId="manufacturerId";
    	String freeItem="freeItem";
    	String manufacturingDate="manufacturingDate";
    	String expiryDate="expiryDate";
    	String brandId="brandId";
    	
    	String dispenseType = "dispenseType";
    	String mdq = "mdq";
    	String ratePerMdq = "ratePerMdq";
    
    	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";
    	String idBrand2="idBrand";
	   	String quantityInVar2="quantityInVar";
		String lotNoVar2="lotNoVar";
		String batchNoVar2="batchNoVar";
    	String taxVar2="taxVar";
    	String amountVar2="amountVar";
    	String unitRateVar2="unitRateVar";
    	String discountVar2="discountVar";
    	
    	String freeQty2="freeQty";
    	String manufacturerId2="manufacturerId";
    	String freeItem2="freeItem";
    	String manufacturingDate2="manufacturingDate";
    	String expiryDate2="expiryDate";
    	
    	
    	String quantityInVarTemp2="quantityInVarTemp";
    	String lotNoTemp2="lotNoTemp";
    	String batchNoTemp2="batchNoTemp";
    	String taxVarTemp2="taxVarTemp";
    	String amountVarTemp2="amountVarTemp";
    	String unitRateVarTemp2="unitRateVarTemp";
    	String discountVarTemp2="discountVarTemp";
    	String incVar2="incVar2";
    	String brandId2="brandId";
    	
    	String dispenseType2 = "dispenseType";
    	String mdq2 = "mdq";
    	String ratePerMdq2 = "ratePerMdq";
	
    	
    	if(previousPage.equals("no")){ 
			int inc=((pageNo-1)*10)+1;
	    	   System.out.println("--------------inc -----------   "+inc);
	    	   int incTemp2=inc+10;
	    	   
	    	   for(StoreLoaninT storeGrnT : storeLoanInTList){
	    		   
	    	 	
	    		  if(inc<incTemp2){
   %>
		<td width="10%">
		<%
    	
    	
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idAu=idAu2+(""+inc);
     		idBrand=idBrand2+(""+inc);
     		quantityInVar=quantityInVar2+(""+inc);
     		lotNoVar=lotNoVar2+(""+inc);
     		taxVar=taxVar2+(""+inc);
     		amountVar=amountVar2+(""+inc);
     		unitRateVar=unitRateVar2+(""+inc);
     		discountVar=discountVar2+(""+inc);
     		brandId=brandId2+(""+inc);

     		freeQty=freeQty2+(""+inc);     		
     		freeItem=freeItem2+(""+inc);
     		manufacturerId=manufacturerId2+(""+inc);
     		manufacturingDate=manufacturingDate2+(""+inc);
     		expiryDate=expiryDate2+(""+inc);
     		
     		quantityInVarTemp=quantityInVarTemp2+(""+inc);
     		lotNoTemp=lotNoTemp2+(""+inc);
     		taxVarTemp=taxVarTemp2+(""+inc);
     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
     		discountVarTemp=discountVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
     		
     		dispenseType = dispenseType2 +(""+inc);
        	mdq = mdq2 +(""+inc);
        	ratePerMdq = ratePerMdq2 +(""+inc);
        	
        	
     		System.out.println("== storeGrnT.getId(======="+storeGrnT.getId());
    %>
		<tr>

			<td width="5%"><input type="text" size="2"
				value="<%=storeGrnT.getSerialNo()%>" class="smcaption"
				name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%">
			<%if(storeGrnT.getItem()!=null){ %> <input type="text"
				value="<%=storeGrnT.getItem().getPvmsNo() %>" class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <%}else{ %>
			<input type="text" value=" " class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <%} %>
			<input type="hidden" name="<%=DETAIL_ID %>"
				value="<%=storeGrnT.getId() %>" id="hdb" /></td>

			<td width="10%"><input type="text"
				value="<%=storeGrnT.getItem().getNomenclature()%>"
				id="<%=nameItem%>" class="bigcaption" tabindex="2"
				readonly="readonly" /></td>

			<td width="10%"><select name="<%=BRAND_ID%>" id="<%=brandId%>">
				<option value="<%=storeGrnT.getBrand().getId()%>"><%=storeGrnT.getBrand().getBrandName()%></option>
			</select></td>

			<td width="10%"><select name="<%=MANUFACTURER_ID %>"
				id=<%=manufacturerId%> tabindex="1">
				<option value="<%=storeGrnT.getManufacturer().getId()%>"><%=storeGrnT.getManufacturer().getManufacturerName()%></option>
			</select>


			<td width="10%"><input type="text"
				value="<%=storeGrnT.getItem().getItemConversion().getItemUnitName() %>"
				class="smcaption" readonly="readonly" name="<%=AV%>" id="<%=idAu%>" />
			</td>

			<td width="10%"><input type="text"
				value="<%=storeGrnT.getReceivedQty() %>" class="medcaption" name=""
				id="<%=quantityInVarTemp %>" tabindex="2" readonly="readonly" /> <input
				type="hidden" value="<%=storeGrnT.getReceivedQty() %>"
				class="medcaption" name="<%=QUANTITY_RECEIVED %>" tabindex="2"
				id="<%=quantityInVar%>" /></td>

			<td width="10%"><input type="text" class="medcaption"
				value="<%=storeGrnT.getFreeQty()%>" name="<%=FREE_QTY %>"
				id="<%= freeQty %>" readonly="readonly" /></td>


			<td width="10%"><select name="dipenseType" id=<%=dispenseType%>
				tabindex="1" class="medcaption">
				<option value="">Select Type</option>
				<option value="Bottle of (gm)"
					<%=HMSUtil.isSelected(storeGrnT.getDispType(),"Bottle of (gm)")%>>Bottle
				of (gm)</option>
				<option value="Bottle of (ml)"
					<%=HMSUtil.isSelected(storeGrnT.getDispType(),"Bottle of (ml)")%>>Bottle
				of (ml)</option>
				<option value="Each"
					<%=HMSUtil.isSelected(storeGrnT.getDispType(),"Each")%>>Each</option>
				<option value="Jar of (gm)"
					<%=HMSUtil.isSelected(storeGrnT.getDispType(),"Jar of (gm)")%>>Jar
				of (gm)</option>
				<option value="Kit of (Tests)"
					<%=HMSUtil.isSelected(storeGrnT.getDispType(),"Kit of (Tests)")%>>Kit
				of (Tests)</option>
				<option value="No"
					<%=HMSUtil.isSelected(storeGrnT.getDispType(),"No")%>>No</option>
				<option value="Pack of (No)"
					<%=HMSUtil.isSelected(storeGrnT.getDispType(),"Pack of (No)")%>>Pack
				of (No)</option>
				<option value="Reel of (Mtr)"
					<%=HMSUtil.isSelected(storeGrnT.getDispType(),"Reel of (Mtr)")%>>Reel
				of (Mtr)</option>
				<option value="Strip of (No)"
					<%=HMSUtil.isSelected(storeGrnT.getDispType(),"Strip of (No)")%>>Strip
				of (No)</option>
				<option value="Tests"
					<%=HMSUtil.isSelected(storeGrnT.getDispType(),"Tests")%>>Tests</option>
				<option value="Tube of (gm)"
					<%=HMSUtil.isSelected(storeGrnT.getDispType(),"Tube of (gm)")%>>Tube
				of (gm)</option>
			</select>

			<td width="10%"><input type="text" class="medcaption" name="mdq"
				id="<%=mdq%>" value=<%=storeGrnT.getMdqValue()%> readonly="readonly"
				tabindex="1" /></td>

			<td width="10%"><input type="text" class="medcaption"
				name="ratePerMdq" value="<%=storeGrnT.getRatePerMdq()%>"
				id="<%=ratePerMdq%>" readonly="readonly" tabindex="1" /></td>

			<td width="10%"><input type="text"
				value="<%=storeGrnT.getBatchNo() %>" class="medcaption" name=""
				id="<%=batchNoTemp %>" tabindex="2" readonly="readonly" /> <input
				type="hidden" value="<%=storeGrnT.getBatchNo() %>"
				class="medcaption" name="<%=BATCH_NO %>" tabindex="2"
				id="<%=batchNoVar%>" /></td>

			<td width="10%"><input type="text"
				value="<%=storeGrnT.getLotNo() %>" class="medcaption" name=""
				id="<%=lotNoTemp %>" tabindex="2" readonly="readonly" /> <input
				type="hidden" value="<%=storeGrnT.getLotNo() %>" class="medcaption"
				name="<%=LOT_NO %>" tabindex="2" id="<%=lotNoVar%>" /></td>

			<td width="3%"><input type="text" class="medcaption"
				value="<%=storeGrnT.getUnitRate() %>" name="" tabindex="2"
				id="<%=unitRateVarTemp%>" readonly="readonly" /> <input
				type="hidden" class="medcaption"
				value="<%=storeGrnT.getUnitRate() %>" name="<%=UNIT_RATE%>"
				tabindex="2" id="<%=unitRateVar%>" /></td>

			<td width="3%"><input type="text" class="medcaption"
				value="<%=storeGrnT.getDiscount() %>" name="" tabindex="2"
				id="<%=discountVarTemp%>" readonly="readonly" /> <input
				type="hidden" class="medcaption"
				value="<%=storeGrnT.getDiscount() %>"
				name="<%=DISCOUNT_PERCENTAGE%>" tabindex="2" id="<%=discountVar%>" />
			</td>

			<td width="10%"><input type="text"
				value="<%=storeGrnT.getTax() %>" class="medcaption" name=""
				tabindex="2" id="<%=taxVarTemp%>" onblur="fillValues(<%=inc%>);"
				readonly="readonly" /> <input type="hidden"
				value="<%=storeGrnT.getTax() %>" class="medcaption"
				name="<%=TAX_PERCENT %>" tabindex="2" id="<%=taxVar%>" /></td>

			<td width="10%"><input type="text"
				value="<%=storeGrnT.getAmountValue() %>" class="medcaption" name=""
				tabindex="2" id="<%=amountVarTemp%>" onblur="fillValues(<%=inc%>);"
				readonly="readonly" /> <input type="hidden"
				value="<%=storeGrnT.getAmountValue() %>" class="medcaption"
				name="<%=AMOUNT %>" tabindex="2" id="<%=amountVar%>" /></td>


			<td width="10%"><select class="smcaption"
				value="<%=storeGrnT.getFreeItem() %>" name="<%=FREE_ITEM %>"
				id="<%=freeItem %>" tabindex="2">
				<option value="n">No</option>
				<option value="y">Yes</option>
			</select></td>

			<td width="40%"><input type="text"
				value="<%=storeGrnT.getManufacturerDate()%>"
				name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate%>"
				class="medcaption" MAXLENGTH="30" tabindex="2" /></td>


			<td width="40%"><input type="text"
				value="<%=storeGrnT.getExpiryDate()%>" name="<%=EXPIRY_DATE%>"
				id="<%=expiryDate %>" class="medcaption" MAXLENGTH="30" tabindex="2" />
			</td>
		</tr>

		<% inc++;
     	 }
     	 }
	    	   %> <script>
	    	   
	    	 document.indentGrid.noOfRows.value=<%=inc-((pageNo-1)*10)-1%>
	    	 </script> <%
	    	 detailCounter=10; 
	         temp=0;
	       	 idItem="idItem";
	    	 codeItem="codeItem";
	    	 nameItem="nameItem";
	    	 idAu="idAu";
	    	 idBrand="idBrand";
	    	 quantityInVar="quantityInVar";
	    	 lotNoVar="lotNoVar";
	    	 batchNoVar="batchNoVar";
	    	 taxVar="taxVar";
	    	 amountVar="amountVar";
	    	 unitRateVar="unitRateVar";
	    	 discountVar="discountVar";
	    	
	    	 quantityInVarTemp="quantityInVarTemp";
	    	 lotNoTemp="lotNoTemp";
	    	 batchNoTemp="batchNoTemp";
	    	 taxVarTemp="taxVarTemp";
	    	 amountVarTemp="amountVarTemp";
	    	 unitRateVarTemp="unitRateVarTemp";
	    	 discountVarTemp="discountVarTemp";
	    	 incVar="incVar";
	    	
	    	 freeQty="freeQty";
	    	 manufacturerId="manufacturerId";
	    	 freeItem="freeItem";
	    	 manufacturingDate="manufacturingDate";
	     	 expiryDate="expiryDate";
	     	
	    	 dispenseType = "dispenseType";
	    	 mdq = "mdq";
	    	 ratePerMdq = "ratePerMdq";
	    	
	    	 idItem2="idItem";
	    	 codeItem2="codeItem";
	    	 nameItem2="nameItem";
	    	 idAu2="idAu";
	    	 idBrand2="idBrand";
		   	 quantityInVar2="quantityInVar";
			 lotNoVar2="lotNoVar";
			 batchNoVar2="batchNoVar";
	    	 taxVar2="taxVar";
	    	 amountVar2="amountVar";
	    	 unitRateVar2="unitRateVar";
	    	 discountVar2="discountVar";
	    	
	    	 freeQty2="freeQty";
	    	 manufacturerId2="manufacturerId";
	    	 freeItem2="freeItem";
	    	 manufacturingDate2="manufacturingDate";
	     	expiryDate2="expiryDate";
	    	
	    	
	    	 quantityInVarTemp2="quantityInVarTemp";
	    	 lotNoTemp2="lotNoTemp";
	    	 batchNoTemp2="batchNoTemp";
	    	 taxVarTemp2="taxVarTemp";
	    	 amountVarTemp2="amountVarTemp";
	    	 unitRateVarTemp2="unitRateVarTemp";
	    	 discountVarTemp2="discountVarTemp";
	    	 incVar2="incVar2";
	    	 
	     	 dispenseType2 = "dispenseType";
	         mdq2 = "mdq";
	         ratePerMdq2 = "ratePerMdq";
	    	
	    		  if(inc<incTemp2){
	    			  for(;inc<incTemp2;inc++){
	    				  idItem=idItem2+(""+inc);
	    		     		codeItem=codeItem2+(""+inc);
	    		     		nameItem=nameItem2+(""+inc);
	    		     		idAu=idAu2+(""+inc);
	    		     		idBrand=idBrand2+(""+inc);
	    		     		quantityInVar=quantityInVar2+(""+inc);
	    		     		lotNoVar=lotNoVar2+(""+inc);
	    		     		taxVar=taxVar2+(""+inc);
	    		     		amountVar=amountVar2+(""+inc);
	    		     		unitRateVar=unitRateVar2+(""+inc);
	    		     		discountVar=discountVar2+(""+inc);

	    		     		freeQty=freeQty2+(""+inc);     		
	    		     		freeItem=freeItem2+(""+inc);
	    		     		manufacturerId=manufacturerId2+(""+inc);
	    		     		manufacturingDate=manufacturingDate2+(""+inc);
	    		     		expiryDate=expiryDate2+(""+inc);
	    		     		
	    		     		quantityInVarTemp=quantityInVarTemp2+(""+inc);
	    		     		lotNoTemp=lotNoTemp2+(""+inc);
	    		     		taxVarTemp=taxVarTemp2+(""+inc);
	    		     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
	    		     		discountVarTemp=discountVarTemp2+(""+inc);
	    		     		incVar=incVar2+(""+inc);
	    		     		
	    		     		dispenseType = dispenseType2 +(""+inc);
	    		        	mdq = mdq2 +(""+inc);
	    		        	ratePerMdq = ratePerMdq2 +(""+inc);
	    			  %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>

			<td width="10%"><input type="text" class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>"
				value="" /></td>
			<input type="hidden" size="2" value="0" class="smcaption"
				name="<%=ITEM_ID%>" id="<%=idItem%>" />


			<td width="10%"><input type="text" value="" tabindex="1"
				id="<%=nameItem%>" class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForPurchase(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" readonly="readonly" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=<%=nameItem%>&poId='+document.getElementById('poId').value });
			</script></td>
			<td width="10%"><select name="<%=BRAND_ID%>" id="<%=brandId%>">

				<option value="0">Select</option>
			</select></td>

			<td width="10%"><select name="<%=MANUFACTURER_ID %>"
				id=<%=manufacturerId%> tabindex="1">
				<option value="">--select manuf--</option>
			</select>


			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=AV%>" id="<%=idAu%>" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="" id="<%=quantityInVarTemp %>" tabindex="2"
				readonly="readonly" /> <input type="hidden" value=""
				class="medcaption" name="<%=QUANTITY_RECEIVED %>" tabindex="2"
				id="<%=quantityInVar%>" /></td>


			<td width="10%"><input type="text" class="medcaption" value="0"
				name="<%=FREE_QTY %>" id="<%= freeQty %>" /></td>


			<td width="10%"><select name="dipenseType" id=<%=dispenseType%>
				tabindex="1" class="medcaption">
				<option value="">Select Type</option>
				<option value="Bottle of (gm)">Bottle of (gm)</option>
				<option value="Bottle of (ml)">Bottle of (ml)</option>
				<option value="Each">Each</option>
				<option value="Jar of (gm)">Jar of (gm)</option>
				<option value="Kit of (Tests)">Kit of (Tests)</option>
				<option value="No">No</option>
				<option value="Pack of (No)">Pack of (No)</option>
				<option value="Reel of (Mtr)">Reel of (Mtr)</option>
				<option value="Strip of (No)">Strip of (No)</option>
				<option value="Tests">Tests</option>
				<option value="Tube of (gm)">Tube of (gm)</option>
			</select>

			<td width="10%"><input type="text" class="medcaption" name="mdq"
				id="<%=mdq%>" readonly="readonly" tabindex="1" /></td>

			<td width="10%"><input type="text" class="medcaption"
				name="ratePerMdq" id="<%=ratePerMdq%>" readonly="readonly"
				tabindex="1" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="" id="<%=batchNoTemp %>" tabindex="2" readonly="readonly" />
			<input type="hidden" value="" class="medcaption"
				name="<%=BATCH_NO %>" tabindex="2" id="<%=batchNoVar%>" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				name="" id="<%=lotNoTemp %>" tabindex="2" readonly="readonly" /> <input
				type="hidden" value="" class="medcaption" name="<%=LOT_NO %>"
				tabindex="2" id="<%=lotNoVar%>" /></td>


			<td width="3%"><input type="text" class="medcaption" value=""
				name="" tabindex="2" id="<%=unitRateVarTemp%>" readonly="readonly" />
			<input type="hidden" class="medcaption" value="0"
				name="<%=UNIT_RATE%>" tabindex="2" id="<%=unitRateVar%>" /></td>

			<td width="3%"><input type="text" class="medcaption" value=""
				name="" tabindex="2" id="<%=discountVarTemp%>" readonly="readonly" />
			<input type="hidden" class="medcaption" value="0"
				name="<%=DISCOUNT_PERCENTAGE%>" tabindex="2" id="<%=discountVar%>" />
			</td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="" tabindex="2" id="<%=taxVarTemp%>" readonly="readonly" /> <input
				type="hidden" value="0" class="medcaption" name="<%=TAX_PERCENT %>"
				tabindex="2" id="<%=taxVar%>" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				name="" tabindex="2" id="<%=amountVarTemp%>"
				onblur="fillValues(<%=inc%>);" readonly="readonly" /> <input
				type="hidden" value="" class="medcaption" name="<%=AMOUNT %>"
				tabindex="2" id="<%=amountVar%>" /></td>

			<td width="10%"><select class="smcaption" name="<%=FREE_ITEM %>"
				id="<%=freeItem %>" tabindex="2">
				<option value="n">No</option>
				<option value="y">Yes</option>
			</select></td>

			<td width="40%"><input type="text"
				name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate%>"
				class="medcaption" MAXLENGTH="30" tabindex="2" /></td>


			<td width="40%"><input type="text" name="<%=EXPIRY_DATE%>"
				id="<%=expiryDate %>" class="medcaption" MAXLENGTH="30" tabindex="2" />
			</td>
		</tr>

		<% }
   		  }
     	    %> <%}//this is if(previousPage.equals("no")) end
       else{}%>
		
	</tbody>

</table>
</div>
</fieldset>
</div>
<%
	if (map.get("storeLoanInMList") != null) {
		storeLoanInMList = (List<StoreLoaninM>)map.get("storeLoanInMList");
	}
		StoreLoaninM grnMObj = null;
	
	if(storeLoanInMList.size() > 0){
		System.out.println("if(storeLoanInMList.size() >>>>>> 0)");
		grnMObj = (StoreLoaninM)storeLoanInMList.get(0);
		loanInId = grnMObj.getId();
		System.out.println("Getting the grnMObj---"+grnMObj.getLoaninNo());
	}
		
	%> <label class="bodytextB_blue"></font>CRV Value</label> <input type="text"
	name="<%=GRN_VALUE %>" value="<%=grnMObj.getLoaninValue() %>"
	class="textbox_size20" MAXLENGTH="20" readonly="readonly" /> <label
	class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" /></div>


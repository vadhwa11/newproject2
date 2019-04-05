<%@page import=" static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.masters.business.MasStoreMeScale"%>
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

 var url="/hms/hms/neStores?method=showInfoOfNeLoanInJsp&detailId="+detailId+"&rowNo="+rowNo;
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
	
	List<MasStoreAirForceDepot> unitList = new ArrayList<MasStoreAirForceDepot>();
	if(map.get("unitList") != null){
		unitList = (ArrayList) map.get("unitList");
		session.setAttribute("unitList",unitList);
	}else if(session.getAttribute("unitList") != null){
		unitList = (ArrayList)session.getAttribute("unitList");
		
	}
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if(map.get("employeeList") != null){
		employeeList = (ArrayList) map.get("employeeList");
		session.setAttribute("employeeList",employeeList);
	}else if(session.getAttribute("employeeList") != null){
		employeeList = (ArrayList)session.getAttribute("employeeList");
		
	}
	List<MasStoreMeScale> meScaleList = new ArrayList<MasStoreMeScale>();
	if(map.get("meScaleList") != null){
		meScaleList = (ArrayList) map.get("meScaleList");
		session.setAttribute("meScaleList",meScaleList);
	}else if(session.getAttribute("meScaleList") != null){
		meScaleList = (ArrayList)session.getAttribute("meScaleList");
		
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
<h2 align="left" class="style1">LOAN IN -View</h2>
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
					onClick="submitForm('indent','stores?method=modifyGrn');"></td>
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
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.indent.<%= FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= TO_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.indent.<%= TO_DATE%>,true);"
			class="calender" /> <br />
		<label class="bodytextB_blue">LoanIn No:</label> <select
			name="<%= LOANIN_NO%>">
			<option value="0">Select</option>
			<%
					if(searchLoanInList.size()!=0)
					for (StoreLoaninM storeLoaninM :searchLoanInList ) {
				%>

			<option value=<%=storeLoaninM.getLoaninNo()%>><%=storeLoaninM.getLoaninNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('indent','stores?method=searchGrn');" /></td>
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
	StoreLoaninM storeLoaninObj = null;
	
	if(storeLoanInMList.size() > 0){
		storeLoaninObj = (StoreLoaninM)storeLoanInMList.get(0);
		loanInId = storeLoaninObj.getId();
	}
		
	%>

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Loan In Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 180px; background-color: #f4f9fe;">
<br />

<label class="bodytextB">Source Of Supply:</label> <input type="text"
	class="textbox_size20" name="<%= SOURCE_OF_SUPPLY %>"
	value="Transferred From AFMRC" readonly="readonly" tabindex=1 /> <label
	class="bodytextB">Loan In Number</label> <% if(storeLoaninObj != null){ %>
<input type="text" class="textbox_size20" name="<%= LOANIN_NO %>"
	value="<%=storeLoaninObj.getLoaninNo()%>" readonly="readonly"
	validate="GRN Number ,String,no" tabindex=1 /> <%}else{ %> <input
	type="text" class="textbox_size20" name="<%= LOANIN_NO %>" value=""
	validate="GRN Number ,String,no" tabindex=1 /> <%} %> <label
	class="bodytextB">Loan In Date :</label> <%if(storeLoaninObj != null){ %>
<input type="text" class="textbox_size20" name="<%= LOANIN_DATE %>"
	value="<%=storeLoaninObj.getLoaninDate() %>" readonly="readonly"
	tabindex=1 validate="GRN Date ,String,no" /> <%}else{ %> <input
	type="text" class="textbox_size20" name="<%= LOANIN_DATE %>"
	value="<%=currentDate %>" readonly="readonly" tabindex=1
	validate="GRN Date ,String,no" /> <%} %> <br />
<br />

<label class="bodytextB">Unit Name:</label> <select
	name="<%= SUPPLIER_ID %>" validate="Vendor Name,string,no" tabindex=1>
	<option value="">Select</option>
	<%
	for (MasStoreAirForceDepot masStoreAirForceDepot : unitList ) {
		if(storeLoaninObj != null){
		 	if(storeLoaninObj.getUnit().getId().equals(masStoreAirForceDepot.getId())){
%>

	<option value=<%=masStoreAirForceDepot.getId()%> selected="selected"><%=masStoreAirForceDepot.getAirForceDepotName()%></option>
	<%      	}else{ 
%>


	<option value=<%=masStoreAirForceDepot.getId()%>><%=masStoreAirForceDepot.getAirForceDepotName()%></option>
	<%
}
		 	}
		}
%>
</select> <label class="bodytextB">Date Rec/Surp:</label> <input type="text"
	name="<%=RECEIVED_DATE%>" value="<%=currentDate %>"
	class="textbox_date" MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currentDate%>',document.grnGrid.<%=RECEIVED_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <label class="bodytextB">Unpac-Chk
By:</label> <select name="<%= EMPLOYEE_ID %>" validate="Employee Name,string,no"
	tabindex=1>
	<option value="">Select</option>
	<%
	for (MasEmployee masEmployee :employeeList ) {
		if(storeLoaninObj != null){
		 	if(storeLoaninObj.getEmployee().getId().equals(masEmployee.getId())){
%>

	<option value=<%=masEmployee.getId()%> selected="selected"><%=masEmployee.getFirstName()+""+masEmployee.getLastName()%></option>
	<%      	}else{ 
%>


	<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName()+""+masEmployee.getLastName()%></option>
	<%
}}}
%>
</select> <label class="bodytextB">ExtnIV No.</label> <%if(storeLoaninObj != null){ %>
<textarea value="<%=storeLoaninObj.getExtnIvNo() %>" readOnly
	name="<%=EXTN_IV %>" tabindex=1 onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="20" />
</textarea> <script>document.indentGrid.<%=EXTN_IV%>.innerHTML = "<%=storeLoaninObj.getExtnIvNo() %>"</script>
<%}else{ %> <textarea value="" name="<%=EXTN_IV %>" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="20" />
</textarea> <script>document.indentGrid.<%=EXTN_IV%>.innerHTML = "<%=storeLoaninObj.getExtnIvNo() %>"</script>
<%} %> <label class="bodytextB">Period From </label> <%if(storeLoaninObj != null){ %>
<textarea value="<%=storeLoaninObj.getPeriodFrom() %>" readOnly
	name="<%=PERIOD_FROM %>" tabindex=1 onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="20" />
</textarea> <script>document.indentGrid.<%=PERIOD_FROM%>.innerHTML = "<%=storeLoaninObj.getPeriodFrom() %>"</script>
<%}else{ %> <textarea value="" name="<%=PERIOD_FROM %>" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="20" />
</textarea> <script>document.indentGrid.<%=PERIOD_FROM%>.innerHTML = "<%=storeLoaninObj.getPeriodFrom() %>"</script>
<%} %> <label class="bodytextB">ME SCALE </label> <select
	name="<%=ME_SCALE_ID %>" validate="ME SCALE,string,yes">
	<option value="">Select</option>
	<%
			  	for (MasStoreMeScale masStoreMeScale : meScaleList) {
			  		if(storeLoaninObj != null){
					 	if(storeLoaninObj.getMeScale().getId().equals(masStoreMeScale.getId())){
			%>

	<option value=<%=masStoreMeScale.getId()%> selected="selected"><%=masStoreMeScale.getMeScaleDescription()%></option>
	<%      	}else{ 
			%>


	<option value=<%=masStoreMeScale.getId()%>><%=masStoreMeScale.getMeScaleDescription()%></option>
	<%
			}}}
			%>
</select> <label class="bodytextB">Remarks</label> <%if(storeLoaninObj != null){ 
		%> <textarea value="<%=storeLoaninObj.getRemarks()%>"
	name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" style="width: 310px;"
	onkeyup="finalCheck(this)" maxlength="45">
		</textarea> <script>document.indentGrid.<%=REMARKS%>.innerHTML = "<%=storeLoaninObj.getRemarks() %>"</script>
<%}else{ %> <textarea value="" name="<%=REMARKS %>"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	style="width: 310px;" maxlength="45">
		</textarea> <script>document.indentGrid.<%=REMARKS%>.innerHTML = "<%=storeLoaninObj.getRemarks() %>"</script>
<%} %> <br />

<%
	} %> <br />
</div>
<div style="float: left; padding-left: 15px;"></div>
<input type="hidden" name="<%=NO_DETAIL_RECORDS%>"
	value="<%=noDetailRecords%>" /> <input type="hidden" size="2"
	value="10" name="<%=NO_OF_ROWS %>" id="<%=NO_OF_ROWS %>" /> <input
	type="hidden" name="<%=LOANIN_ID %>" value="<%=loanInId%>" id="hdb" />
<br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Loan In </font></div>

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
			<td width="9%"><label valign="left" class="smalllabel">A/U</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Serial
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Accepted
			Model</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Lot
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Quan
			Rec</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Unit
			Rate</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Disc(%)</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Tax(%)</label>
			</td>
			<td width="9%"><label valign="left" class="smalllabel">Amt
			Value</label></td>
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
    	String installationDate2="installationDate";
    	String amcStartDate2="amcStartDate";
    	String  amcEndDate2 = "amcEndDate";
     	String warrantyDate2 = "warrantyDate";
    	
    	
    	String quantityInVarTemp2="quantityInVarTemp";
    	String lotNoTemp2="lotNoTemp";
    	String batchNoTemp2="batchNoTemp";
    	String taxVarTemp2="taxVarTemp";
    	String amountVarTemp2="amountVarTemp";
    	String unitRateVarTemp2="unitRateVarTemp";
    	String discountVarTemp2="discountVarTemp";
    	String incVar2="incVar2";
    	String brandId2="brandId";
    	String installationDate ="installationDate";
    	String amcStartDate="amcStartDate";
    	String  amcEndDate = "amcEndDate";
     	String warrantyDate = "warrantyDate";
    	
    	if(previousPage.equals("no")){ 
			int inc=((pageNo-1)*10)+1;
	    	   System.out.println("--------------inc -----------   "+inc);
	    	   int incTemp2=inc+10;
	    	   
	    	   for(StoreLoaninT storeLoaninT : storeLoanInTList){
	    		   
	    	 	
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
     		installationDate =installationDate2+(""+inc);
     		amcStartDate=amcStartDate2+(""+inc);
     		 amcEndDate = amcEndDate2+(""+inc);
 	     	warrantyDate = warrantyDate+(""+inc);
    %>
		<tr>

			<td width="5%"><input type="text" size="2"
				value="<%=storeLoaninT.getSerialNo()%>" class="smcaption"
				name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%">
			<%if(storeLoaninT.getItem().getPvmsNo()!=null){ %> <input type="text"
				value="<%=storeLoaninT.getItem().getPvmsNo() %>" class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <%}else{ %>
			<input type="text" value=" " class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <%} %>
			<input type="hidden" name="<%=DETAIL_ID %>"
				value="<%=storeLoaninT.getId() %>" id="hdb" /></td>

			<td width="10%"><input type="text"
				value="<%=storeLoaninT.getItem().getNomenclature() %>"
				id="<%=nameItem%>" class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&poId='+document.getElementById('poId').value});
		</script></td>


			<td width="10%"><input type="text"
				value="<%=storeLoaninT.getItem().getItemConversion().getItemUnitName() %>"
				class="smcaption" readonly="readonly" name="<%=AV%>" id="<%=idAu%>" /></td>

			<td width="10%"><input type="text"
				value="<%=storeLoaninT.getBatchNo() %>" class="medcaption" name=""
				id="<%=batchNoTemp %>" tabindex="2" /> <input type="hidden"
				value="<%=storeLoaninT.getBatchNo() %>" class="medcaption"
				name="<%=BATCH_NO %>" tabindex="2" id="<%=batchNoVar%>" /></td>

			<td width="10%"><input type="text"
				value="<%=storeLoaninT.getAcceptedModel() %>" class="medcaption"
				name="<%=ACCEPTED_MODEL_TEMP %>" tabindex="2"
				onblur="fillModelForGrn(<%=inc%>)" /> <input type="hidden"
				value="<%=storeLoaninT.getAcceptedModel() %>" class="medcaption"
				name="<%=ACCEPTED_MODEL %>" tabindex="2" /></td>

			<td width="10%"><input type="text"
				value="<%=storeLoaninT.getLotNo() %>" class="medcaption" name=""
				id="<%=lotNoTemp %>" tabindex="2" /> <input type="hidden"
				value="<%=storeLoaninT.getLotNo() %>" class="medcaption"
				name="<%=LOT_NO %>" tabindex="2" id="<%=lotNoVar%>" /></td>
			<td width="10%"><input type="text"
				value="<%=storeLoaninT.getReceivedQty() %>" class="medcaption"
				name="" id="<%=quantityInVarTemp %>" tabindex="2" /> <input
				type="hidden" value="<%=storeLoaninT.getReceivedQty() %>"
				class="medcaption" name="<%=QUANTITY_RECEIVED %>" tabindex="2"
				id="<%=quantityInVar%>" /></td>

			<td width="3%"><input type="text" class="medcaption"
				value="<%=storeLoaninT.getUnitRate() %>" name="" tabindex="2"
				id="<%=unitRateVarTemp%>" /> <input type="hidden"
				class="medcaption" value="<%=storeLoaninT.getUnitRate() %>"
				name="<%=UNIT_RATE%>" tabindex="2" id="<%=unitRateVar%>" /></td>

			<td width="3%"><input type="text" class="medcaption"
				value="<%=storeLoaninT.getDiscount() %>" name="" tabindex="2"
				id="<%=discountVarTemp%>" /> <input type="hidden"
				class="medcaption" value="<%=storeLoaninT.getDiscount() %>"
				name="<%=DISCOUNT_PERCENTAGE%>" tabindex="2" id="<%=discountVar%>" />
			</td>

			<td width="10%"><input type="text"
				value="<%=storeLoaninT.getTax() %>" class="medcaption" name=""
				tabindex="2" id="<%=taxVarTemp%>" onblur="fillValues(<%=inc%>);" />
			<input type="hidden" value="<%=storeLoaninT.getTax() %>"
				class="medcaption" name="<%=TAX_PERCENT %>" tabindex="2"
				id="<%=taxVar%>" /></td>
			<td width="10%"><input type="text"
				value="<%=storeLoaninT.getAmountValue() %>" class="medcaption"
				name="" tabindex="2" id="<%=amountVarTemp%>"
				onblur="fillValues(<%=inc%>);" /> <input type="hidden"
				value="<%=storeLoaninT.getAmountValue() %>" class="medcaption"
				name="<%=AMOUNT %>" tabindex="2" id="<%=amountVar%>" /> <input
				type="hidden" value="<%=storeLoaninT.getFreeQty() %>"
				name="<%=FREE_QTY %>" id="<%=freeQty %>" /> <input type="hidden"
				value="<%=storeLoaninT.getManufacturerDate() %>"
				name="<%=MANUFACTURING_DATE %>" id="<%=manufacturingDate %>" /> <input
				type="hidden" value="<%=storeLoaninT.getWarrantyDate() %>"
				name="<%=WARRANTY_DATE %>" id="<%=warrantyDate %>" /> <input
				type="hidden" value="<%=storeLoaninT.getInstallationDate() %>"
				name="<%=INSTALLATION_DATE %>" id="<%=installationDate %>" /> <input
				type="hidden" value="<%=storeLoaninT.getAmcStartDate() %>"
				name="<%=AMC_START_DATE %>" id="<%=amcStartDate %>" /> <input
				type="hidden" value="<%=storeLoaninT.getAmcEndDate() %>"
				name="<%=AMC_END_DATE %>" id="<%=amcEndDate %>" /> <%if(storeLoaninT.getManufacturer() != null){%>
			<input type="hidden"
				value="<%=storeLoaninT.getManufacturer().getId() %>"
				name="<%=MANUFACTURER_ID %>" id="<%=manufacturerId %>" /> <%}else{ %>
			<input type="hidden" value="0" name="<%=MANUFACTURER_ID %>"
				id="<%=manufacturerId %>" /> <%} %> <input type="hidden"
				value="<%=storeLoaninT.getFreeItem() %>" name="<%=FREE_ITEM %>"
				id="<%=freeItem %>" /></td>
			<td width="3%"><input type="button"
				onclick="get_value(<%=temp+inc%>,<%=storeLoaninT.getId() %>);"
				name="Submit2" value="" class="morebutton" /></td>
		</tr>
		<% inc++;
     	 }
     	 }
	    	   System.out.println("inc indc "+inc);
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
	     	installationDate="installationDate";
	     	amcStartDate="amcStartDate";
	     	 amcEndDate = "amcEndDate";
		     	warrantyDate = "warrantyDate";
	    	
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
	    	 incVar2="incVar";
	    	 installationDate2="installationDate";
	    	 amcStartDate2="amcStartDate";
	    	 amcEndDate2 = "amcEndDate";
	     	warrantyDate2 = "warrantyDate";
	    	
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
	    		     		installationDate = installationDate2+(""+inc);
	    		     		
	    		     		quantityInVarTemp=quantityInVarTemp2+(""+inc);
	    		     		lotNoTemp=lotNoTemp2+(""+inc);
	    		     		taxVarTemp=taxVarTemp2+(""+inc);
	    		     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
	    		     		discountVarTemp=discountVarTemp2+(""+inc);
	    		     		incVar=incVar2+(""+inc);
	    		     		amcStartDate =amcStartDate2+(""+inc);
	    		     		amcEndDate = amcEndDate2+(""+inc);
	    		     		warrantyDate = warrantyDate2+(""+inc);
	    		     		
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
				name="<%=nameItem%>" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=<%=nameItem%>&poId='+document.getElementById('poId').value });
			</script></td>
		</td>
		<td width="10%"><input type="text" value="" class="smcaption"
			readonly="readonly" name="<%=AV%>" id="<%=idAu%>" /></td>

		<td width="10%"><input type="text" value="" class="medcaption"
			name="" id="<%=batchNoTemp %>" tabindex="2" /> <input type="hidden"
			value="" class="medcaption" name="<%=BATCH_NO %>" tabindex="2"
			id="<%=batchNoVar%>" /></td>

		<td width="10%"><input type="text" value="" class="medcaption"
			name="<%=ACCEPTED_MODEL_TEMP %>" tabindex="2" /> <input type="hidden"
			value="" class="medcaption" name="<%=ACCEPTED_MODEL %>" tabindex="2" />
		</td>

		<td width="10%"><input type="text" value="" class="medcaption"
			name="" id="<%=lotNoTemp %>" tabindex="2" /> <input type="hidden"
			value="" class="medcaption" name="<%=LOT_NO %>" tabindex="2"
			id="<%=lotNoVar%>" /></td>
		<td width="10%"><input type="text" value="" class="medcaption"
			name="" id="<%=quantityInVarTemp %>" tabindex="2" /> <input
			type="hidden" value="" class="medcaption"
			name="<%=QUANTITY_RECEIVED %>" tabindex="2" id="<%=quantityInVar%>" />
		</td>


		<td width="3%"><input type="text" class="medcaption" value=""
			name="" tabindex="2" id="<%=unitRateVarTemp%>" /> <input
			type="hidden" class="medcaption" value="0" name="<%=UNIT_RATE%>"
			tabindex="2" id="<%=unitRateVar%>" /></td>

		<td width="3%"><input type="text" class="medcaption" value=""
			name="" tabindex="2" id="<%=discountVarTemp%>" /> <input
			type="hidden" class="medcaption" value="0"
			name="<%=DISCOUNT_PERCENTAGE%>" tabindex="2" id="<%=discountVar%>" />
		</td>

		<td width="10%"><input type="text" value="" class="medcaption"
			name="" tabindex="2" id="<%=taxVarTemp%>" /> <input type="hidden"
			value="0" class="medcaption" name="<%=TAX_PERCENT %>" tabindex="2"
			id="<%=taxVar%>" /></td>
		<td width="10%"><input type="text" value="" class="medcaption"
			name="" tabindex="2" id="<%=amountVarTemp%>"
			onblur="fillValues(<%=inc%>);" /> <input type="hidden" value=""
			class="medcaption" name="<%=AMOUNT %>" tabindex="2"
			id="<%=amountVar%>" /> <input type="hidden" value="0"
			name="<%=FREE_QTY %>" id="<%= freeQty %>" /> <input type="hidden"
			value="0" name="<%=MANUFACTURING_DATE %>"
			id="<%=manufacturingDate %>" /> <input type="hidden" value="0"
			name="<%=MANUFACTURER_ID %>" id="<%=manufacturerId %>" /> <input
			type="hidden" value="0" name="<%=FREE_ITEM %>" id="<%=freeItem %>" />
		<input type="hidden" value="0" name="<%=INSTALLATION_DATE %>"
			id="<%=installationDate %>" /> <input type="hidden" value="0"
			name="<%=AMC_START_DATE %>" id="<%=amcStartDate %>" /> <input
			type="hidden" value="0" name="<%=AMC_END_DATE %>"
			id="<%=amcEndDate %>" /> <input type="hidden" value="0"
			name="<%=WARRANTY_DATE %>" id="<%=warrantyDate %>" /></td>

		<td width="3%"><input type="button"
			onclick="get_value(<%=temp+inc%>,0);" name="Submit2" value=""
			class="morebutton" /></td>
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
		grnMObj = (StoreLoaninM)storeLoanInMList.get(0);
		loanInId = grnMObj.getId();
	}
		
	%> <label class="bodytextB"></font>CRV Value</label> <input type="text"
	name="<%=GRN_VALUE %>" value="<%=grnMObj.getLoaninValue() %>"
	class="textbox_size20" MAXLENGTH="8"/  > <br />
<br />
<label class="bodytextB">Changed By:</label>
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


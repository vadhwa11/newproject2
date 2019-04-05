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
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="jkt.hms.util.HMSUtil"%>
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
	src="/hms/jsp/js/calendar.js"></script>
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

 var url="/hms/hms/neStores?method=showInfoOfNeGrnJsp&detailId="+detailId+"&rowNo="+rowNo;
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
	int grnId=0;
		List<StoreGrnM> searchGrnList = new ArrayList<StoreGrnM>();
		List<MasStoreSection> sectionList= new ArrayList<MasStoreSection>();
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
		List<StoreGrnM> previousStoreGrnMList=new ArrayList<StoreGrnM>();
		List<StoreGrnT> gridGrnTList=new ArrayList<StoreGrnT>();
		List<StoreGrnM> gridGrnMList= new ArrayList<StoreGrnM>();
		int maxGrnNo=0;
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
	List<StoreIndentM> indentList = new ArrayList<StoreIndentM>();
	if(map.get("indentList") != null){
		indentList = (ArrayList) map.get("indentList");
		session.setAttribute("indentList",indentList);
	}else if(session.getAttribute("indentList") != null){
		indentList = (ArrayList)session.getAttribute("indentList");
		
	}
	if(map.get("grnId")!=null){
		grnId=Integer.parseInt(""+map.get("grnId"));
		System.out.print(" grnId    "+grnId);
	}
	
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}

	if(map.get("maxGrnNo")!=null)
		maxGrnNo=Integer.parseInt(""+map.get("maxGrnNo"));
	
	if(map.get("sectionList")!=null)
	sectionList=(List) map.get("sectionList");
	
	if(map.get("previousStoreGrnMList")!=null)
		previousStoreGrnMList=(List) map.get("previousStoreGrnMList");
	
	if(map.get("gridGrnTList")!=null){
		gridGrnTList=(List) map.get("gridGrnTList");
		
	}
	if(map.get("gridGrnMList")!=null)
		gridGrnMList=(List) map.get("gridGrnMList");
	String noDetailRecords="no";
	if(map.get("noDetailRecords")!=null){
		noDetailRecords=(""+map.get("noDetailRecords"));
	}
	
	if(map.get("searchGrnList")!=null)
		searchGrnList = (List) map.get("searchGrnList");
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


<h2 align="left" class="style1">CRV -View</h2>
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
			validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.indent.<%= FROM_DATE%>,event)" />
		<label class="bodytextB_blue">To Date :</label> <input type="text"
			name="<%= TO_DATE %>" class="textbox_date" MAXLENGTH="30"
			/ tabindex=1 /> <img id="calendar" src="/hms/jsp/images/cal.gif"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.indent.<%= TO_DATE%>,event)" />
		<br />
		<label class="bodytextB_blue">CRV No:</label> <select
			name="<%= GRN_NO%>">
			<option value="0">Select</option>
			<%
					if(searchGrnList.size()!=0)
					for (StoreGrnM storeGrnM :searchGrnList ) {
				%>

			<option value=<%=storeGrnM.getGrnNo()%>><%=storeGrnM.getGrnNo()%></option>

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
	if (map.get("gridGrnMList") != null) {
		gridGrnMList = (List<StoreGrnM>)map.get("gridGrnMList");
	}
	StoreGrnM grnMObj = null;
	
	if(gridGrnMList.size() > 0){
		grnMObj = (StoreGrnM)gridGrnMList.get(0);
		grnId = grnMObj.getId();
	}
		
	%>

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">CRV Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 255px; background-color: #f4f9fe;">
<br />

<label class="bodytextB">Source Of Supply:</label> <% if(grnMObj != null){ 
		if(grnMObj.getReceiveType().equals("d")){
	%>
<option value=<%=grnMObj.getReceiveType()%>><%="AFMSD replacement indent"%></option>
<%}else if(grnMObj.getReceiveType().equals("p")){ %>
<option value=<%=grnMObj.getReceiveType()%>><%="Procurement from NDF fund"%></option>
<%}else if(grnMObj.getReceiveType().equals("s")){ %>
<option value=<%=grnMObj.getReceiveType()%>><%="SOC"%></option>
<%}else if(grnMObj.getReceiveType().equals("g")){ %>
<option value=<%=grnMObj.getReceiveType()%>><%="Gifted Items Transferred From AFMRC project"%></option>
<%}else if(grnMObj.getReceiveType().equals("m")){ %>
<option value=<%=grnMObj.getReceiveType()%>><%="Under Modernization Plan"%></option>
<% }
		}%> <br />
<label class="bodytextB">CRV Number</label> <% if(grnMObj != null){ %> <input
	type="text" class="textbox_size20" name="<%= GRN_NO %>"
	value="<%=grnMObj.getGrnNo()%>" readonly="readonly"
	validate="GRN Number ,String,no" tabindex=1 /> <%}else{ %> <input
	type="text" class="textbox_size20" name="<%= GRN_NO %>" value=""
	validate="GRN Number ,String,no" tabindex=1 /> <%} %> <label
	class="bodytextB">CRV Date :</label> <%if(grnMObj != null){ %> <input
	type="text" class="textbox_size20" name="<%= GRN_DATE %>"
	value="<%=grnMObj.getGrnDate() %>" readonly="readonly" tabindex=1
	validate="GRN Date ,String,no" /> <%}else{ %> <input type="text"
	class="textbox_size20" name="<%= GRN_DATE %>" value="<%=currentDate %>"
	readonly="readonly" tabindex=1 validate="GRN Date ,String,no" /> <%} %> <label
	class="bodytextB">AT SO Number</label> <% if(grnMObj != null){ %> <input
	type="text" class="textbox_size20" name="<%= SUPPLY_ORDER_NO %>"
	value="<%=grnMObj.getAtSoNo()%>" readonly="readonly"
	validate="P.O. Number ,String,no" tabindex=1 /> <%}else{ %> <input
	type="text" class="textbox_size20" name="<%= SUPPLY_ORDER_NO %>"
	value="" validate="AT SO Number ,String,no" tabindex=1 /> <%} %> <br />
<label class="bodytextB">AT/SO Date :</label> <input type="text"
	class="textbox_size20" name="<%=AT_SO_DATE%>" value="<%=currentDate%>"
	readonly="readonly" tabindex=1 validate="GRN Date ,String,no" /> <label
	class="bodytextB">Date Rec/Surp:<label class="bodytextB">
<%if(grnMObj!= null) {%> <input type="text" class="textbox_size20"
	name="<%=RECEIVED_DATE%>" value="<%=grnMObj.getDateReceivedSurplus()%>"
	tabindex=1 validate="surplus Date ,String,no" /> <%}else{ %> <input
	type="text" class="textbox_size20" name="<%=RECEIVED_DATE%>" value=""
	readonly="readonly" tabindex=1 validate="surplus Date ,String,no" /> <%} %>



<label class="bodytextB">Employee Name:</label> <select
	name="<%= EMPLOYEE_ID %>" validate="Employee Name,string,no" tabindex=1>
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
</select> <br />
<label class="bodytextB">R/R No </label> <% if(grnMObj != null){ %> <input
	type="text" class="textbox_size20" name="<%=RR_NO %>"
	value="<%=grnMObj.getRrNo()%>" validate="rr Number ,String,no"
	tabindex=1 /> <%}else{ %> <input type="text" class="textbox_size20"
	name="<%=RR_NO %>" value="" tabindex=1 /> <%} %> <label
	class="bodytextB">Mode Of Convey.</label> <% if(grnMObj != null){ 
		if(grnMObj.getModeOfConveyance().equals("1")){
	%>
<option value=<%=grnMObj.getModeOfConveyance()%>><%="Air"%></option>
<%}else if(grnMObj.getModeOfConveyance().equals("2")){ %>
<option value=<%=grnMObj.getModeOfConveyance()%>><%="Bus"%></option>
<%}else if(grnMObj.getModeOfConveyance().equals("3")){ %>
<option value=<%=grnMObj.getModeOfConveyance()%>><%="Train"%></option>
<%}else if(grnMObj.getModeOfConveyance().equals("4")){ %>
<option value=<%=grnMObj.getModeOfConveyance()%>><%="By Hand"%></option>
<%}
		} %> <br />
<label class="bodytextB">How Received</label> <% if(grnMObj != null){ %> <input
	type="text" class="textbox_size20" name="<%= HOW_RECEIVED %>"
	value="<%=grnMObj.getHowReceived()%>" readonly="readonly" tabindex=1 />
<%}else{ %> <input type="text" class="textbox_size20"
	name="<%= HOW_RECEIVED %>" value="" tabindex=1 /> <%} %> <br />
<label class="bodytextB">Remarks</label> <%if(grnMObj != null){ %> <textarea
	value="<%=grnMObj.getRemarks()%>" name="<%=REMARKS %>"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" style="width: 310px;"
	onkeyup="finalCheck(this)" maxlength="250">
		</textarea> <script>document.indentGrid.<%=REMARKS%>.innerHTML = "<%=grnMObj.getRemarks() %>"</script>
<%}else{ %> <textarea value="" name="<%=REMARKS %>"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	style="width: 310px;" maxlength="250">
		</textarea> <script>document.indentGrid.<%=REMARKS%>.innerHTML = "<%=grnMObj.getRemarks() %>"</script>
<%} %> <label class="bodytextB">Invoice No</label> <% if(grnMObj != null){ %>
<input type="text" class="textbox_size20" name="<%= INVOICE_NO %>"
	value="<%=grnMObj.getInvoiceNo()%>" readonly="readonly" tabindex=1 />
<%}else{ %> <input type="text" class="textbox_size20"
	name="<%= INVOICE_NO %>" value="" tabindex=1 /> <%} %> <label
	class="bodytextB">Invoice Date</label> <% if(grnMObj != null){ %> <input
	type="text" class="textbox_size20" name="<%= INVOICE_DATE %>"
	value="<%=grnMObj.getInvoiceDate()%>" readonly="readonly" tabindex=1 />
<%}else{ %> <input type="text" class="textbox_size20"
	name="<%= INVOICE_DATE %>" value="" tabindex=1 /> <%} %> <label
	class="bodytextB">Invoice Amount</label> <% if(grnMObj != null){ %> <input
	type="text" class="textbox_size20" name="<%= INVOICE_AMOUNT %>"
	value="<%=grnMObj.getInvoiceAmount()%>" readonly="readonly" tabindex=1 />
<%}else{ %> <input type="text" class="textbox_size20"
	name="<%= INVOICE_AMOUNT %>" value="" tabindex=1 /> <%} %> <br />


<label class="bodytextB">Freight Duty</label> <input type="text"
	name="<%=FREIGHT_DUTY %>" value="<%=grnMObj.getFreightDuty() %>"
	class="textbox_size20" MAXLENGTH="8"/  > <label
	class="bodytextB">Excise Duty</label> <input type="text"
	name="<%=EXCISE_DUTY %>" value="<%=grnMObj.getExciseDuty() %>"
	class="textbox_size20" MAXLENGTH="8"/  > <label
	class="bodytextB"></font>Octori</label> <input type="text" name="<%=OCTROI %>"
	value="<%= grnMObj.getOctroi()%>" class="textbox_size20" MAXLENGTH="8"/  >
<br />

<label class="bodytextB">Insurance Charge</label> <input type="text"
	name="<%=INSURANCE_CHARGES %>"
	value="<%=grnMObj.getInsuranceCharge() %>" class="textbox_size20"
	MAXLENGTH="8"/  > <label class="bodytextB"></font>Other
Charges</label> <input type="text" name="<%=OTHER_CHARGES %>"
	value="<%=grnMObj.getOtherCharges() %>" class="textbox_size20"
	MAXLENGTH="8"/  > <label class="bodytextB">Custom Duty</label>
<input type="text" name="<%=CUSTOM_DUTY %>"
	value="<%=grnMObj.getCustomDuty() %>" class="textbox_size20"
	MAXLENGTH="8"/  > <%
	} %>
</div>
<br />



<input type="hidden" name="<%=NO_DETAIL_RECORDS%>"
	value="<%=noDetailRecords%>" /> <input type="hidden" size="2"
	value="10" name="<%=NO_OF_ROWS %>" id="<%=NO_OF_ROWS %>" /> <input
	type="hidden" name="<%=GRN_ID %>" value="<%=grnId%>" id="hdb" /> <br />
<br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">CRV</font></div>

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
			<td width="9%"><label valign="left" class="smalllabel">Tax(%)</label></td>
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
    	String installationDate = "installationDate";
    	String amcStartDate = "amcStartDate";
    	String amcEndDate = "amcEndDate";
    	String warrantyDate = "warrantyDate";
    	
    	
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
    	String incVar2="incVar";
    	String brandId2="brandId";
    	String installationDate2 = "installationDate";
    	String amcStartDate2 = "amcStartDate";
    	String amcEndDate2 = "amcEndDate";
    	String warrantyDate2 = "warrantyDate";
    	
    	if(previousPage.equals("no")){ 
			int inc=((pageNo-1)*10)+1;
	    	   int incTemp2=inc+10;
	    	   
	    	   for(StoreGrnT storeGrnT : gridGrnTList){
	    		   
	    	 	
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
     		installationDate = installationDate2+(""+inc);
     		amcStartDate = amcStartDate2+(""+inc);
     		amcEndDate = amcEndDate2+(""+inc);
     		warrantyDate = warrantyDate2+(""+inc);
    %>
		<tr>

			<td width="5%"><input type="text" size="2"
				value="<%=storeGrnT.getSerialNo()%>" class="smcaption"
				name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%">
			<%if(storeGrnT.getItem().getPvmsNo()!=null){ %> <input type="text"
				value="<%=storeGrnT.getItem().getPvmsNo() %>" class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <%}else{ %>
			<input type="text" value=" " class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <%} %>
			<input type="hidden" name="<%=DETAIL_ID %>"
				value="<%=storeGrnT.getId() %>" id="hdb" /></td>

			<td width="10%"><input type="text"
				value="<%=storeGrnT.getItem().getNomenclature() %>"
				id="<%=nameItem%>" class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
		</script></td>

			<td width="10%"><input type="text"
				value="<%=storeGrnT.getItem().getItemConversion().getItemUnitName() %>"
				class="smcaption" readonly="readonly" name="<%=AV%>" id="<%=idAu%>" /></td>

			<td width="10%"><input type="text"
				value="<%=storeGrnT.getBatchNo() %>" class="medcaption" name=""
				id="<%=batchNoTemp %>" tabindex="2" /> <input type="hidden"
				value="<%=storeGrnT.getBatchNo() %>" class="medcaption"
				name="<%=BATCH_NO %>" tabindex="2" id="<%=batchNoVar%>" /></td>

			<td width="10%"><input type="text"
				value="<%=storeGrnT.getAcceptedModel() %>" class="medcaption"
				name="<%=ACCEPTED_MODEL_TEMP %>" tabindex="2"
				onblur="fillModelForGrn(<%=inc%>)" /> <input type="hidden"
				value="<%=storeGrnT.getAcceptedModel() %>" class="medcaption"
				name="<%=ACCEPTED_MODEL %>" tabindex="2" /></td>
			<td width="10%"><input type="text"
				value="<%=storeGrnT.getLotNo() %>" class="medcaption" name=""
				id="<%=lotNoTemp %>" tabindex="2" /> <input type="hidden"
				value="<%=storeGrnT.getLotNo() %>" class="medcaption"
				name="<%=LOT_NO %>" tabindex="2" id="<%=lotNoVar%>" /></td>
			<td width="10%"><input type="text"
				value="<%=storeGrnT.getReceivedQty() %>" class="medcaption" name=""
				id="<%=quantityInVarTemp %>" tabindex="2" /> <input type="hidden"
				value="<%=storeGrnT.getReceivedQty() %>" class="medcaption"
				name="<%=QUANTITY_RECEIVED %>" tabindex="2" id="<%=quantityInVar%>" />
			</td>

			<td width="3%"><input type="text" class="medcaption"
				value="<%=storeGrnT.getUnitRate() %>" name="" tabindex="2"
				id="<%=unitRateVarTemp%>" /> <input type="hidden"
				class="medcaption" value="<%=storeGrnT.getUnitRate() %>"
				name="<%=UNIT_RATE%>" tabindex="2" id="<%=unitRateVar%>" /></td>

			<td width="3%"><input type="text" class="medcaption"
				value="<%=storeGrnT.getDiscount() %>" name="" tabindex="2"
				id="<%=discountVarTemp%>" /> <input type="hidden"
				class="medcaption" value="<%=storeGrnT.getDiscount() %>"
				name="<%=DISCOUNT_PERCENTAGE%>" tabindex="2" id="<%=discountVar%>" />
			</td>

			<td width="10%"><input type="text"
				value="<%=storeGrnT.getTax() %>" class="medcaption" name=""
				tabindex="2" id="<%=taxVarTemp%>" onblur="fillValues(<%=inc%>);" />
			<input type="hidden" value="<%=storeGrnT.getTax() %>"
				class="medcaption" name="<%=TAX_PERCENT %>" tabindex="2"
				id="<%=taxVar%>" /></td>
			<td width="10%"><input type="text"
				value="<%=storeGrnT.getAmountValue() %>" class="medcaption" name=""
				tabindex="2" id="<%=amountVarTemp%>" onblur="fillValues(<%=inc%>);" />
			<input type="hidden" value="<%=storeGrnT.getAmountValue() %>"
				class="medcaption" name="<%=AMOUNT %>" tabindex="2"
				id="<%=amountVar%>" /> <input type="hidden"
				value="<%=storeGrnT.getFreeQty() %>" name="<%=FREE_QTY %>"
				id="<%=freeQty %>" /> <input type="hidden"
				value="<%=storeGrnT.getManufacturerDate() %>"
				name="<%=MANUFACTURING_DATE %>" id="<%=manufacturingDate %>" /> <input
				type="hidden" value="<%=storeGrnT.getWarrantyDate() %>"
				name="<%=WARRANTY_DATE %>" id="<%=warrantyDate %>" /> <input
				type="hidden" value="<%=storeGrnT.getInstallationDate() %>"
				name="<%=INSTALLATION_DATE %>" id="<%=installationDate %>" /> <input
				type="hidden" value="<%=storeGrnT.getAmcStartDate() %>"
				name="<%=AMC_START_DATE %>" id="<%=amcStartDate %>" /> <input
				type="hidden" value="<%=storeGrnT.getAmcEndDate() %>"
				name="<%=AMC_END_DATE %>" id="<%=amcEndDate %>" /> <%if(storeGrnT.getManufacturer() != null){%>
			<input type="hidden"
				value="<%=storeGrnT.getManufacturer().getId() %>"
				name="<%=MANUFACTURER_ID %>" id="<%=manufacturerId %>" /> <%}else{ %>
			<input type="hidden" value="0" name="<%=MANUFACTURER_ID %>"
				id="<%=manufacturerId %>" /> <%} %> <input type="hidden"
				value="<%=storeGrnT.getFreeItem() %>" name="<%=FREE_ITEM %>"
				id="<%=freeItem %>" /></td>
			<td width="3%"><input type="button"
				onclick="get_value(<%=temp+inc%>,<%=storeGrnT.getId() %>);"
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
	     	installationDate = "installationDate";
	     	amcStartDate = "amcStartDate";
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
	    	 installationDate2 = "installationDate";
	    	 amcStartDate2 = "amcStartDate";
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
	    		     		
	    		     		quantityInVarTemp=quantityInVarTemp2+(""+inc);
	    		     		lotNoTemp=lotNoTemp2+(""+inc);
	    		     		taxVarTemp=taxVarTemp2+(""+inc);
	    		     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
	    		     		discountVarTemp=discountVarTemp2+(""+inc);
	    		     		incVar=incVar2+(""+inc);
	    		     		installationDate = installationDate2+(""+inc);
	    		     		amcStartDate = amcStartDate2+(""+inc);
	    		     		amcEndDate = amcEndDate2+(""+inc);
	    		     		warrantyDate = warrantyDate2+(""+inc);
	    			  %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <input
				type="hidden" size="2" value="0" class="smcaption"
				name="<%=ITEM_ID%>" id="<%=idItem%>" /></td>
			<td width="10%"><input type="text" value="" id="<%=nameItem%>"
				class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
										  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
										</script></td>

			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=AV%>" id="<%=idAu%>" tabindex="1" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="" id="<%=batchNoTemp %>" tabindex="2" /> <input type="hidden"
				value="" class="medcaption" name="<%=BATCH_NO %>" tabindex="2"
				id="<%=batchNoVar%>" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="" tabindex="2" /> <input type="hidden" value=""
				class="medcaption" name="<%=ACCEPTED_MODEL %>" tabindex="2" /></td>
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
	if (map.get("gridGrnMList") != null) {
		gridGrnMList = (List<StoreGrnM>)map.get("gridGrnMList");
	}
		StoreGrnM grnMObj = null;
	
	if(gridGrnMList.size() > 0){
		grnMObj = (StoreGrnM)gridGrnMList.get(0);
		grnId = grnMObj.getId();
	}
		
	%> <label class="bodytextB"></font>CRV Value</label> <input type="text"
	name="<%=GRN_VALUE %>" value="<%=grnMObj.getGrnValue() %>"
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


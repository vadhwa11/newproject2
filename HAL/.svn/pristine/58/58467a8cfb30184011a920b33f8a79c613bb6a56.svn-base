<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasUnitOfMeasurement"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StoreSupplyOrderEntry"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreUnit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreMeScale"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<style>
#contentspace label {
	text-align: right;
	padding-right: 0px;
	width: 95px;
	float: left;
	height: 9px;
}
</style>
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
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>

<script type="text/javascript" language="javascript">
var itemsArray1=new Array();

 var brandArray = new Array();
  function fillValuesInGrn(inc)
  {
  		var batchNo="batchNo";
  	 	var quanRec = "quanRec";
    	var taxVar = "taxVar";
    	var amtVar = "amtVar";
    	var unitRateVar = "unitRateVar";
    	var discountVar = "discountVar";
    	var batchNoTemp="batchNoTemp";
    	var quanRecTemp = "quanRecTemp";
    	var taxVarTemp = "taxVarTemp";
    	var unitRateVarTemp = "unitRateVarTemp";
    	var discountVarTemp = "discountVarTemp";
    	var amtVarTemp = "amtVarTemp";
    	
    	if(document.getElementById('batchNoTemp').value != ""){
    	document.getElementById(batchNo+inc).value=document.getElementById(batchNoTemp+inc).value
    	}
    	else
    	{
    	document.getElementById(batchNo+inc).value =0;
    	}
    	
    	document.getElementById(quanRec+inc).value=document.getElementById(quanRecTemp+inc).value
    	
    	if(document.getElementById(taxVarTemp+inc).value != ""){
    	document.getElementById(taxVar+inc).value=document.getElementById(taxVarTemp+inc).value
    	}
    	else
    	{
    	document.getElementById(taxVar+inc).value = 0;
    	}
    	
    	document.getElementById(unitRateVar+inc).value=document.getElementById(unitRateVarTemp+inc).value
    
    	
    	if(document.getElementById(discountVarTemp+inc).value != ""){
    		document.getElementById(discountVar+inc).value=document.getElementById(discountVarTemp+inc).value
    	}
    	else
    	{
    		document.getElementById(discountVar+inc).value = 0;
    	}
    	
    	if(document.getElementById(amtVarTemp+inc).value != ""){
    		document.getElementById(amtVar+inc).value=document.getElementById(amtVarTemp+inc).value
    	}
    	else
    	{
    		document.getElementById(amtVar+inc).value = 0;
    	} 
  }
  

    function checkForNext(){
  if(document.getElementById('noOfRows').value<10)
  {
  	alert("All rows are not filled.To continue press Submit ")
  	return false;
  }
  else
  {
  return true;
  }
  }
 //==== function to add pvms/niv item
 function get_valueForItem()
{
 var url="/hms/hms/pharmacy?method=showItemJsp";
   popwindow(url);
 }  
 
function get_value(rowNo)
{
 var url="/hms/hms/neStores?method=showInfoOfNeGrnJsp&rowNo="+rowNo;
   popwindow(url);
 }  

var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name',"height=600,width=600,status=1");
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

</script>
<script language="javascript">

function checkForGrn(val,a,inc)
{
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*10)+1;
    	var end=((pageNo-1)*10)+10;
    	var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	  	ajaxFunctionForAutoCompleteInNeGrn('grnGrid','neStores?method=fillItemsForGrn&requiredField=' + pvms , inc);
		
}
</script>

<% 
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
	
	int grnId=0;	
	if(map.get("grnId")!=null)
	{
		grnId=Integer.parseInt(""+map.get("grnId"));
	}	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	

	String messageTOBeVisibleToTheUser="";
	
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		messageTOBeVisibleToTheUser=""+map.get("messageTOBeVisibleToTheUser");
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
			}
			
			List<MasStoreMeScale> meScaleList = new ArrayList<MasStoreMeScale>();
			if(map.get("meScaleList") != null){
				meScaleList = (ArrayList) map.get("meScaleList");
				session.setAttribute("meScaleList",meScaleList);
			}else if(session.getAttribute("meScaleList") != null){
				meScaleList = (ArrayList)session.getAttribute("meScaleList");
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
			
			StoreGrnM storeGrnObj = null;
			List<StoreIndentM> indentForAfmsdList = new ArrayList<StoreIndentM>();
			if(map.get("indentForAfmsdList") != null){
				indentForAfmsdList = (ArrayList) map.get("indentForAfmsdList");
				session.setAttribute("indentForAfmsdList",indentForAfmsdList);
			}else if(session.getAttribute("indentForAfmsdList") != null){
				indentForAfmsdList = (ArrayList)session.getAttribute("indentForAfmsdList");
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
			
			List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
			if(map.get("brandList") != null){
				brandList = (ArrayList) map.get("brandList");
				session.setAttribute("brandList",brandList);
			}else if(session.getAttribute("brandList") != null){
				brandList = (ArrayList)session.getAttribute("brandList");
			}
			
			List<StoreSupplyOrderEntry> supplyOrderList = new ArrayList<StoreSupplyOrderEntry>();
			if(map.get("supplyOrderList") != null){
				supplyOrderList = (ArrayList) map.get("supplyOrderList");
				session.setAttribute("supplyOrderList",supplyOrderList);
			}else if(session.getAttribute("supplyOrderList") != null){
				supplyOrderList = (ArrayList)session.getAttribute("supplyOrderList");
			}
			
			List<StoreGrnM> searchGrnList= new ArrayList<StoreGrnM>();
			if(map.get("searchGrnList")!=null)
				searchGrnList = (List) map.get("searchGrnList");
			
			List<StoreGrnM> grnList= new ArrayList<StoreGrnM>();
			if(map.get("grnList")!=null)
				grnList = (List) map.get("grnList");
			
			String message="";
			if(map.get("message") != null){
				message = (String)map.get("message"); 
			}
			
			String max="";
			if(map.get("max") != null){
				max = (String) map.get("max");
			}
			
			String userName = "";
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}
			
			String time="";
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			 date = (String)utilMap.get("currentDate");	 
			 time = (String)utilMap.get("currentTime");
			int pageNo=1;
			if (map.get("pageNo") != null) {
				pageNo = Integer.parseInt(""+map.get("pageNo"));
			}
			String includedJsp = null;
			if (request.getAttribute("map") != null) {
				map = (Map) request.getAttribute("map");
			}
			includedJsp = (String) map.get("includedJsp");
			%>

<script>
 var nameArray=new Array();
 var itemsArray1=new Array();
</script>

<div id="contentspace">
<form name="createGrn" method="post" action="">

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
					type="button" id="addbutton" name="Add" type="submit" value="Add"
					class="toolbutton"
					onClick="submitForm('createGrn','neStores?method=showNeGrnJsp');"></td>
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
					value="Print"
					onClick="submitForm('createGrn','neStores?method=showGrnReportJsp');">
				</td>
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
			MAXLENGTH="30" / tabindex=1 /> <label class="bodytextB_blue">To
		Date :</label> <img id="calendar" src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date" class="calender"
			tabindex="1"
			onClick="setdate('<%=currentDate%>',document.createGrn.<%= FROM_DATE%>,event)" />
		<input type="text" name="<%= TO_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.createGrn.<%= TO_DATE%>,event)" />

		<br />

		<label class="bodytextB_blue">CRV No:</label> <select
			name="<%=GRN_NO%>">
			<%
					for (StoreGrnM storeGrnM :searchGrnList ) {
				%>

			<option value=<%=storeGrnM.getGrnNo()%>><%=storeGrnM.getGrnNo()%></option>

			<%
					}
				%>

		</select> </select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('createGrn','neStores?method=searchGrn');" /> <br />
		</td>
	</tr>

</table>
</form>
</div>
</div>
</form>
</div>

<form name="grnGrid" method="post">
<div>
<div>
<h2 align="left" class="style1"><%=messageTOBeVisibleToTheUser %></h2>
</div>

<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> <input
	type="hidden" name="deptId" value="<%=deptId%>" />

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">CRV Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />
<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 310px; background-color: #f4f9fe;">

<label class="bodytextB">Source of Supply:</label> <select
	name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo"
	onchange="onChangeSrc(this.value);">
	<option value="0">Select</option>
	<option value="d">AFMSD replacement indent</option>
	<option value="p">Procurement from NDF fund</option>
	<option value="s">SOC</option>
	<option value="g">Gifted Items Transferred From AFMRC project</option>
	<option value="m">Under Modernization Plan</option>
</select> <label class="bodytextB"><font id="error">*</font>CRV No.</label> <% if(storeGrnObj != null){%>
<input type="text" class="textbox_size20" name="<%=GRN_NO %>"
	value="<%=storeGrnObj.getGrnNo()%>" readonly="readonly"
	validate="CRV Number ,String,yes" tabindex=1 /> <%}else{ %> <input
	type="text" class="textbox_size20" name="<%=GRN_NO %>"
	value="<%=max %>" readonly="readonly" validate="CRV Number ,String,yes"
	tabindex=1 /> <%} %> <label class="bodytextB"> <font id="error">*</font>CRV
Date:</label> <input type="text" name="<%=GRN_DATE%>" value="<%=currentDate %>"
	class="textbox_date" validate="CRV Date,dateOfAdmission,yes"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	tabindex="1"
	onClick="setdate('<%=currentDate%>',document.grnGrid.<%=GRN_DATE%>,event)" />
<input name="<%=BOO_ENTRY %>" class="button" value="BOO Entry"
	type="button"
	onclick="submitFormForButton('grnGrid','stores?method=showBooJsp');" />
<br />

<div id=suppDiv><label class="bodytextB">Unit/Ven.Name</label> <select
	name="<%= SUPPLIER_ID%>" id="supplierCombo">
</select></div>


<div id=indentDiv><label class="bodytextB">Indent No/Po No</label>
<select name="<%=INDENT_ID %>" id="indentCombo">
</select></div>



<label class="bodytextB">Technical Details</label> <%if(storeGrnObj != null){ %>
<textarea value="<%=storeGrnObj.getTechnicalDetails()%>" readOnly
	name="<%=TECHNICAL_DETAILS %>" validate="Technical Details ,String,no"
	tabindex=1 onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="45" />
		</textarea> <%}else{ %> <textarea value="" name="<%=TECHNICAL_DETAILS %>"
	validate="Technical Details ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="45" />
		</textarea> <%} %> <br />

<label class="bodytextB">At/SO Date:</label> <input type="text"
	name="<%=AT_SO_DATE%>" value="<%=currentDate %>" class="textbox_date"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	tabindex="1"
	onClick="setdate('<%=currentDate%>',document.grnGrid.<%=AT_SO_DATE%>,event)" />

<label class="bodytextB">Date Rec/Surp:</label> <input type="text"
	name="<%=RECEIVED_DATE%>" value="<%=currentDate %>"
	class="textbox_date" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.grnGrid.<%=RECEIVED_DATE%>,event)" />
<label class="bodytextB">R/R No </label> <% if(storeGrnObj != null){%> <input
	type="text" name="<%=RR_NO %>" value="<%=storeGrnObj.getRrNo() %>"
	class="textbox_size20" MAXLENGTH="30"/  > <%}else{ %> <input
	type="text" name="<%=RR_NO %>" value="" class="textbox_size20"
	MAXLENGTH="30"/  > <%} %> <br />

<label class="bodytextB">Mode Of Conv:</label> <select
	name="<%=MODE_OF_CONVEYANCE%>" validate="Mode Of Conveyance,string,yes"
	tabindex=1>
	<option value="0">Select</option>
	<option value="1">Air</option>
	<option value="2">Bus</option>
	<option value="3">Train</option>
	<option value="4">By Hand</option>
</select> <label class="bodytextB">Unpac-Chk By:</label> <select
	name="<%= EMPLOYEE_ID %>" validate="Employee,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
			  	for (MasEmployee masEmployee : employeeList) {
			%>

	<option value="<%=masEmployee.getId ()%>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<% } %>
</select> <label class="bodytextB">AT/So No.</label> <% if(storeGrnObj != null){%>
<input id="test" type="text" name="<%=SUPPLY_ORDER_NO %>"
	value="<%=storeGrnObj.getAtSoNo() %>" class="textbox_size20"
	MAXLENGTH="15" style="width: 250px;"> <%}else{ %> <input
	id="test" type="text" name="<%=SUPPLY_ORDER_NO %>" value=""
	class="textbox_size20" MAXLENGTH="15" style="width: 350px;">
<%} %> <br />

<label class="bodytextB">Technical Spec</label> <%if(storeGrnObj != null){ %>
<textarea value="<%=storeGrnObj.getTechnicalSpecification()%>" readOnly
	name="<%=TECHNICAL_SPECIFICATION %>"
	validate="Technical Specification ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="45" />
		</textarea> <%}else{ %> <textarea value="" name="<%=TECHNICAL_SPECIFICATION %>"
	validate="Technical Specification,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="45" />
		</textarea> <%} %> <label class="bodytextB">AMC Contract</label> <%if(storeGrnObj != null){ %>
<textarea value="<%=storeGrnObj.getAmcContract()%>" readOnly
	name="<%=AMC_CONTRACT %>" validate="AMC Contract ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="512" />
		</textarea> <%}else{ %> <textarea value="" name="<%=AMC_CONTRACT %>"
	validate="AMC Contract ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="512" />
		</textarea> <%} %> <label class="bodytextB"><font id="error"></font>How
Received </label> <% if(storeGrnObj != null){%> <input type="text"
	name="<%=HOW_RECEIVED %>" value="<%=storeGrnObj.getHowReceived()%>"
	class="textbox_size20" MAXLENGTH="50" style="width: 130px;" /> <%}else{ %>
<input type="text" name="<%=HOW_RECEIVED %>" value=""
	class="textbox_size20" MAXLENGTH="50" style="width: 130px;" /> <%} %> <br />

<label class="bodytextB">ME SCALE </label> <select
	name="<%=ME_SCALE_ID %>" validate="ME Scale,string,yes">
	<option value="">Select</option>
	<%
			  	for (MasStoreMeScale masStoreMeScale : meScaleList) {
			%>

	<option value="<%=masStoreMeScale.getId ()%>"><%=masStoreMeScale.getMeScaleDescription()%></option>
	<% } %>
</select> <label class="bodytextB">Remarks</label> <%if(storeGrnObj != null){ %> <textarea
	value="<%=storeGrnObj.getRemarks()%>" readOnly name="<%=REMARKS %>"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" />
		</textarea> <%}else{ %> <textarea value="" name="<%=REMARKS %>"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" />
		</textarea> <%} %> <label class="bodytextB"><font id="error">*</font>Invoice
No</label> <%if(storeGrnObj != null){ %> <input type="text"
	name="<%=INVOICE_NO %>" value="<%=storeGrnObj.getInvoiceNo() %>"
	validate="Invoice No, String, no" class="textbox_size20" MAXLENGTH="20"/  >
<%}else{ %> <input type="text" name="<%=INVOICE_NO %>" value=""
	validate="Invoice No,String,no" class="textbox_size20" MAXLENGTH="20"/  >
<%} %> <label class="bodytextB">Invoice Date:</label> <input type="text"
	name="<%=INVOICE_DATE%>" value="" class="textbox_date" MAXLENGTH="30" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.grnGrid.<%=INVOICE_DATE%>,event)" />
<label class="bodytextB">Invoice Amount</label> <%if(storeGrnObj != null){ %>
<input type="text" name="<%=INVOICE_AMOUNT %>" id="<%=INVOICE_AMOUNT %>"
	value="<%=storeGrnObj.getInvoiceAmount() %>" class="textbox_size20"
	MAXLENGTH="15"/  > <%}else{ %> <input type="text"
	name="<%=INVOICE_AMOUNT %>" id="<%=INVOICE_AMOUNT %>" value=""
	class="textbox_size20" MAXLENGTH="15"/  > <%} %> <br />

<label class="bodytextB">Freight Duty</label> <%if(storeGrnObj != null){ %>
<input type="text" name="<%=FREIGHT_DUTY %>"
	value="<%=storeGrnObj.getFreightDuty()%>" id="<%=FREIGHT_DUTY %>"
	validate="Freight Duty,float,no" class="textbox_size20" MAXLENGTH="15"/  >
<%}else{ %> <input type="text" name="<%=FREIGHT_DUTY %>"
	id="<%=FREIGHT_DUTY %>" value="" validate="Freight Duty,float,no"
	class="textbox_size20" MAXLENGTH="15"/  > <%} %> <label
	class="bodytextB">Excise Duty</label> <%if(storeGrnObj != null){ %> <input
	type="text" name="<%=EXCISE_DUTY %>"
	value="<%=storeGrnObj.getExciseDuty()%>" id="<%=EXCISE_DUTY %>"
	validate="Excise Duty,float,no" class="textbox_size20" MAXLENGTH="15"/  >
<%}else{ %> <input type="text" name="<%=EXCISE_DUTY %>"
	id="<%=EXCISE_DUTY %>" value="" class="textbox_size20"
	validate="Excise,float,no" MAXLENGTH="15"/  > <%} %> <label
	class="bodytextB"></font>Octroi</label> <%if(storeGrnObj != null){ %> <input
	type="text" name="<%=OCTROI %>" value="<%=storeGrnObj.getOctroi()%>"
	id="<%=OCTROI %>" validate="Octroi,float,no" class="textbox_size20"
	MAXLENGTH="15"/  > <%}else{ %> <input type="text"
	name="<%=OCTROI %>" id="<%=OCTROI %>" value="" class="textbox_size20"
	validate="Octroi,float,no" MAXLENGTH="15"/  > <%} %> <br />

<label class="bodytextB">Insurance Charge</label> <%if(storeGrnObj != null){ %>
<input type="text" name="<%=INSURANCE_CHARGES %>"
	value="<%=storeGrnObj.getInsuranceCharge()%>"
	id="<%=INSURANCE_CHARGES %>" validate="Insurance Charges,float,no"
	class="textbox_size20" MAXLENGTH="15"/  > <%}else{ %> <input
	type="text" name="<%=INSURANCE_CHARGES %>" id="<%=INSURANCE_CHARGES %>"
	value="" class="textbox_size20" validate="Insurance Charges,float,no"
	MAXLENGTH="15"/  > <%} %> <label class="bodytextB"></font>Other
Charges</label> <%if(storeGrnObj != null){ %> <input type="text"
	name="<%=OTHER_CHARGES %>" value="<%=storeGrnObj.getOtherCharges()%>"
	id="<%=OTHER_CHARGES %>" validate="Other Charges,float,no"
	class="textbox_size20" MAXLENGTH="15"/  > <%}else{ %> <input
	type="text" name="<%=OTHER_CHARGES %>" id="<%=OTHER_CHARGES %>"
	value="" class="textbox_size20" validate="Other Charges,float,no"
	MAXLENGTH="15"/  > <%} %> <label class="bodytextB">Custom
Duty</label> <%if(storeGrnObj != null){ %> <input type="text"
	name="<%=CUSTOM_DUTY %>" value="<%=storeGrnObj.getCustomDuty()%>"
	id="<%=CUSTOM_DUTY %>" validate="Custom Duty,float,no"
	class="textbox_size20" MAXLENGTH="15"/  > <%}else{ %> <input
	type="text" name="<%=CUSTOM_DUTY %>" id="<%=CUSTOM_DUTY %>" value=""
	class="textbox_size20" validate="Custom Duty,float,no" MAXLENGTH="15"/  >
<%} %>
</div>
<br />
<br />
<input type="button" name="sss" align="right" class="button"
	value="Submit"
	onclick="if(validationForSerial()&& checkForSubmit()){submitForm('grnGrid','neStores?method=submitGrn');}" />
<input type="button" name="sss" align="right" class="button"
	value="Add PVMS/NIV item" onclick="get_valueForItem();" /> <input
	type="hidden" size="2" value="0" name="noOfRows" id="noOfRows" /> <input
	type="hidden" name="<%=GRN_ID %>" value="<%=grnId%>" id="hdb" />


<div id="gridDiv">
<fieldset style="width: 99%; height: 200px; padding-left: 9px;"><legend
	class="bodytextB">CRV</legend> <label class="bodytextB"></label></fieldset>
</div>
<br>

<label class="bodytextB"><font id="error"></font>CRV Value</label> <input
	type="text" name="<%=GRN_VALUE %>" id="<%=GRN_VALUE %>" value=""
	class="textbox_size20" MAXLENGTH="15"/  > <input type="hidden"
	name="<%=TOTAL_AMOUNT %>" id="<%=TOTAL_AMOUNT %>" value=""
	class="textbox_size20" MAXLENGTH="15"/  > <br />
<br />
<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" /> <br />
<br />

</div>
</form>
</div>
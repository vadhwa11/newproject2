<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
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
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreMeScale"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.masters.business.StoreLoaninM"%>
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
	src="/hms/jsp/js/calendar.js"></script>
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
    	
		document.getElementById(quanRec+inc).value=document.getElementById(quanRecTemp+inc).value
    	 	if(document.getElementById(taxVarTemp+inc).value != ""){
    		document.getElementById(taxVar+inc).value=document.getElementById(taxVarTemp+inc).value
    	}else{
    		document.getElementById(taxVar+inc).value = 0;
    	}
    	
    	document.getElementById(unitRateVar+inc).value=document.getElementById(unitRateVarTemp+inc).value
		
		if(document.getElementById(discountVarTemp+inc).value != ""){
    		document.getElementById(discountVar+inc).value=document.getElementById(discountVarTemp+inc).value
    	}else{
    		document.getElementById(discountVar+inc).value = 0;
    	}
    				if(document.getElementById(amtVarTemp+inc).value != ""){
    		document.getElementById(amtVar+inc).value=document.getElementById(amtVarTemp+inc).value
    	}else{
    		document.getElementById(amtVar+inc).value = 0;
    	}  
    	}
  
  

    function checkForNext(){
  if(document.getElementById('noOfRows').value<10)
  {
  	alert("All rows are not filled.To continue press Submit ")
  	return false;
  }else{
  return true;
  }
  }
  
  function checkForSubmit()
  {
  if(document.getElementById('noOfRows').value==0)
  {
  alert("There must be one detail row");
  return false;
  }
  else
  {
  return true;
  }
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
   
 //==== function to add pvms/niv item
 function get_valueForItem()
{
 var url="/hms/hms/pharmacy?method=showItemJsp";
   popwindow(url);
 }  
 

function get_value(rowNo)
{
 var url="/hms/hms/neStores?method=showInfoOfNeLoanInJsp&rowNo="+rowNo;
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
</script>
<script language="javascript">

function checkForLoanIn(val,a,inc)
{

		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*10)+1;
    	var end=((pageNo-1)*10)+10;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	     ajaxFunctionForAutoCompleteInNeLoanIn('grnGrid','neStores?method=fillItemsForLoanIn&requiredField=' + pvms , inc);
		
}
  
 </script>
<% 
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	int grnId=0;	
	if(map.get("grnId")!=null){
		grnId=Integer.parseInt(""+map.get("grnId"));
	}	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	if(map.get("supplierList") != null){
		supplierList = (ArrayList) map.get("supplierList");
		session.setAttribute("supplierList",supplierList);
	}else if(session.getAttribute("supplierList") != null){
		supplierList = (ArrayList)session.getAttribute("supplierList");
		
	}
	Box box=HMSUtil.getBox(request);
	if(map.get("box")!=null){
		box=(Box)map.get("box");
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
			StoreLoaninM storeLoaninObj = null;
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
			List<MasStoreAirForceDepot> unitList = new ArrayList<MasStoreAirForceDepot>();
			if(map.get("unitList") != null){
				unitList = (ArrayList) map.get("unitList");
				session.setAttribute("unitList",unitList);
			}else if(session.getAttribute("unitList") != null){
				unitList = (ArrayList)session.getAttribute("unitList");
				
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
			List<StoreLoaninM> searchLoanInList = new ArrayList<StoreLoaninM>();
			if (map.get("searchLoanInList") != null)
				searchLoanInList = (List) map.get("searchLoanInList");
		
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
			String messageTOBeVisibleToTheUser="";
			
			if(map.get("messageTOBeVisibleToTheUser") !=null){
				messageTOBeVisibleToTheUser=""+map.get("messageTOBeVisibleToTheUser");
			}
			
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
					onClick="submitForm('createGrn','neStores?method=showNeLoanInJsp');"></td>
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
			MAXLENGTH="30" / tabindex=1 /> <img src="/hms/jsp/images/cal.gif"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.createGrn.<%= FROM_DATE%>,event)" />
		<label class="bodytextB_blue">To Date :</label> <input type="text"
			name="<%= TO_DATE %>" class="textbox_date" MAXLENGTH="30"
			/ tabindex=1 /> <img src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date" class="calender"
			tabindex="1"
			onClick="setdate('<%=currentDate%>',document.createGrn.<%= TO_DATE%>,event)" />
		<br />

		<label class="bodytextB_blue">Loan In No:</label> <select
			name="<%=LOANIN_NO%>">
			<%
			 	for (StoreLoaninM storeLoaninM : searchLoanInList) {
			 %>

			<option value=<%=storeLoaninM.getLoaninNo()%>><%=storeLoaninM.getLoaninNo()%></option>

			<%
						}
					%>

		</select> <br />

		<input type="button" class="smbutton" value="Go!"
			onClick="submitForm('createGrn','neStores?method=searchLoanin');" />



		<br />
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

<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Loan In Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 130px; background-color: #f4f9fe;">
<br />
<label class="bodytextB">Source of Supply:</label> <input type="text"
	class="textbox_size20" name="<%= SOURCE_OF_SUPPLY %>"
	value="Transferred From AFMRC" readonly="readonly" tabindex=1 /> <label
	class="bodytextB"><font id="error">*</font>LoanIn No.</label> <% if(storeLoaninObj != null){%>
<input type="text" class="textbox_size20" name="<%=LOANIN_NO %>"
	value="<%=storeLoaninObj.getLoaninNo()%>" readonly="readonly"
	validate="LoanIn Number ,String,yes" tabindex=1 /> <%}else{ %> <input
	type="text" class="textbox_size20" name="<%=LOANIN_NO %>"
	value="<%=max %>" readonly="readonly"
	validate="LoanIn Number ,String,yes" tabindex=1 /> <%} %> <label
	class="bodytextB"> <font id="error">*</font>Loan In Date:</label> <input
	type="text" name="<%=LOANIN_DATE%>" value="<%=currentDate %>"
	class="textbox_date" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.grnGrid.<%=LOANIN_DATE %>,event)" />

<br />

<label class="bodytextB">Unit Name</label> <select
	name="<%=SUPPLIER_ID%>" validate="Unit,string,yes">
	<option value="">Select</option>

	<%
			  	for (MasStoreAirForceDepot masStoreAirForceDepot : unitList) {
			%>

	<option value="<%=masStoreAirForceDepot.getId ()%>"><%=masStoreAirForceDepot.getAirForceDepotName() %></option>
	<% } %>
</select> <label class="bodytextB">Date Rec/Surp:</label> <input type="text"
	name="<%=RECEIVED_DATE%>" value="<%=currentDate %>"
	class="textbox_date" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.grnGrid.<%=RECEIVED_DATE %>,event)" />
<label class="bodytextB">Unpac-Chk By:</label> <select
	name="<%= EMPLOYEE_ID %>" validate="Employee,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
			  	for (MasEmployee masEmployee : employeeList) {
			%>

	<option value="<%=masEmployee.getId ()%>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<% } %>
</select> <br />

<label class="bodytextB">ExtnIV No.</label> <%if(storeLoaninObj != null){ %>
<textarea value="" name="<%=EXTN_IV %>" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="20" />
	</textarea> <%}else{ %> <textarea value="" name="<%=EXTN_IV %>" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="20" />
	</textarea> <%} %> <label class="bodytextB">Period From </label> <%if(storeLoaninObj != null){ %>
<textarea value="" readOnly name="<%=PERIOD_FROM %>" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="20" />
	</textarea> <%}else{ %> <textarea value="" name="<%=PERIOD_FROM %>" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="20" />
	</textarea> <%} %> <label class="bodytextB">ME SCALE </label> <select
	name="<%=ME_SCALE_ID %>" validate="ME SCALE,string,yes">
	<option value="">Select</option>
	<%
			  	for (MasStoreMeScale masStoreMeScale : meScaleList) {
			%>

	<option value="<%=masStoreMeScale.getId ()%>"><%=masStoreMeScale.getMeScaleDescription()%></option>
	<% } %>
</select> <label class="bodytextB">Remarks</label> <%if(storeLoaninObj != null){ %>
<textarea value="<%=storeLoaninObj.getRemarks()%>" readOnly
	name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1
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
		</textarea> <%} %> <br />
</div>
<br />
<input type="button" name="sss" align="right" class="button"
	value="Submit"
	onclick="if(checkForSubmit()){submitForm('grnGrid','neStores?method=submitLoanIn');}" />
<input type="button" name="sss" align="right" class="button"
	value="Add PVMS/NIV item" onclick="get_valueForItem();" /> <input
	type="hidden" size="2" value="0" name="noOfRows" id="noOfRows" /> <input
	type="hidden" name="<%=GRN_ID %>" value="<%=grnId%>" id="hdb" /> <br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">LOAN IN </font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="98%" colspan="7" id="grnDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
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



		<%
    	int detailCounter=10; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idSection="idSection";
    	String nameBrand="nameBrand";
    	String idBrand="idBrand";
    	String idAu="idAu";
    	String batchNo="batchNo";
    	String batchNoTemp="batchNoTemp";
    	String lotNoTemp="lotNoTemp";
    	String quanRec="quanRec";
    	String quanRecTemp="quanRecTemp";
    	String taxVar="taxVar";
    	String unitRateVar="unitRateVar";
    	String discountVar="discountVar";
    	String amtVar="amtVar";
    	String taxVarTemp="taxVarTemp";
    	String unitRateVarTemp="unitRateVarTemp";
    	String discountVarTemp="discountVarTemp";
    	String amtVarTemp="amtVarTemp";
    	String stockInVarTemp="stockInVarTemp";
    	String mmfVarTemp="mmfVarTemp";
    	String demandVarTemp="demandVarTemp";
    	String incVar="incVar";
    	String quantityInVar="quantityInVar";
      	String quantityInVarTemp="quantityInVarTemp";
      	String freeQty="freeQty";
    	String freeItem="freeItem";
    	String expiryDate="expiryDate";
    	String manufacturerId="manufacturerId";
    	String lotNo="lotNo";
    	String acceptedModel="acceptedModel";
    	String acceptedModelTemp="acceptedModelTemp";
    	String shelfLife="shelfLife";
    	String installationDate="installationDate";
    	String amcStartDate ="amcStartDate";
    	String amcEndDate = "amcEndDate";
    	String warrantyDate = "warrantyDate";
    	String costPrice ="costPrice";
    	String costPriceTemp ="costPriceTemp";
    	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idSection2="idSection";
    	String nameBrand2="nameBrand";
    	String idBrand2="idBrand";
    	String idAu2="idAu";
    	String freeItem2="freeItem";
    	String expiryDate2="expiryDate";
    	String batchNo2="batchNo";
    	String batchNoTemp2="batchNoTemp";
    	String lotNoTemp2="lotNoTemp";
    	String quanRec2="quanRec";
    	String quanRecTemp2="quanRecTemp";
    	String taxVar2="taxVar";
    	String unitRateVar2="unitRateVar";
    	String discountVar2="discountVar";
    	String amtVar2="amtVar";
    	String quantityInVar2="quantityInVar";
    	String freeQty2="freeQty";
    	String taxVarTemp2="taxVarTemp";
    	String unitRateVarTemp2="unitRateVarTemp";
    	String discountVarTemp2="discountVarTemp";
    	String amtVarTemp2="amtVarTemp";
    	String quantityInVarTemp2="quantityInVarTemp";
    	String stockInVarTemp2="stockInVarTemp";
    	String mmfVarTemp2="mmfVarTemp";
    	String demandVarTemp2="demandVarTemp";
    	String incVar2="incVar2";
    	String manufacturerId2="manufacturerId";
    	String lotNo2="lotNo";
    	String acceptedModel2="acceptedModel";
    	String acceptedModelTemp2="acceptedModelTemp";
    	String shelfLife2 ="shelfLife";
    	String installationDate2 = "installationDate";
    	String amcStartDate2="amcStartDate";
    	String amcEndDate2 = "amcEndDate";
    	String warrantyDate2 = "warrantyDate";
    	String costPrice2 = "costPrice";
    	String costPriceTemp2 ="costPriceTemp";
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=10;inc++){
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idSection=idSection2+(""+inc);
     		nameBrand=nameBrand2+(""+inc);
     		idBrand=idBrand2+(""+inc);
     		idAu=idAu2+(""+inc);
     		taxVar=taxVar2+(""+inc);
     		unitRateVar=unitRateVar2+(""+inc);
     		discountVar=discountVar2+(""+inc);
     		amtVar=amtVar2+(""+inc);
     		batchNo=batchNo2+(""+inc);
     		batchNoTemp=batchNoTemp2+(""+inc);
     		lotNo=lotNo2+(""+inc);
     		lotNoTemp=lotNoTemp2+(""+inc);
     		acceptedModel=acceptedModel2+(""+inc);
     		acceptedModelTemp=acceptedModelTemp2+(""+inc);
     		quanRec=quanRec2+(""+inc);
     		quanRecTemp=quanRecTemp2+(""+inc);
     		taxVarTemp=taxVarTemp2+(""+inc);
     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
     		discountVarTemp=discountVarTemp2+(""+inc);
     		amtVarTemp=amtVarTemp2+(""+inc);
     		stockInVarTemp=stockInVarTemp2+(""+inc);
     		mmfVarTemp=mmfVarTemp2+(""+inc);
     		demandVarTemp=demandVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
     		freeQty=freeQty2+(""+inc);     		
     		freeItem=freeItem2+(""+inc);
     		expiryDate=expiryDate2+(""+inc);
     		manufacturerId=manufacturerId2+(""+inc);
     		shelfLife = shelfLife2+(""+inc);
     		installationDate=installationDate2+(""+inc);
     		amcStartDate=amcStartDate2+(""+inc);
     		amcEndDate = amcEndDate2+(""+inc);
     		warrantyDate= warrantyDate2+(""+inc);
     		costPrice =costPrice2+(""+inc);
     		costPriceTemp =costPriceTemp2+(""+inc);
     		
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
				onblur="if(fillSrNo('<%=inc %>')){checkForLoanIn(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" tabindex="2" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','neStores?method=getItemListForLoanInByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});
		</script></td>

			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=AV%>" id="<%=idAu%>"
				validate="A/U ,String,no" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=BATCH_NO_TEMP %>" id="<%=batchNoTemp%>" tabindex="2"
				maxlength="10" validate="Serial Number ,String,no"
				onblur="if(checkForSerialNo(this.value,<%=inc%>)){enterQuantityForSerial(<%=inc %>);fillBatchForGrn(<%=inc%>)}" />
			<input type="hidden" value="0" class="medcaption"
				name="<%=BATCH_NO %>" tabindex="2"
				validate="Serial Number ,String,no" id="<%=batchNo%>" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=ACCEPTED_MODEL_TEMP %>" id="<%=acceptedModelTemp%>"
				tabindex="2" onblur="fillModelForGrn(<%=inc%>)" maxlength="40" /> <input
				type="hidden" value="0" class="medcaption"
				name="<%=ACCEPTED_MODEL %>" tabindex="2" id="<%=acceptedModel%>"
				maxlength="40" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=LOT_NO_TEMP %>" id="<%=lotNoTemp%>" tabindex="2"
				onblur="fillLotForGrn(<%=inc%>)" maxlength="50" /> <input
				type="hidden" value="0" class="medcaption" name="<%=LOT_NO %>"
				tabindex="2" id="<%=lotNo%>" maxlength="50" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="" id="<%=quanRecTemp%>" tabindex="2"
				validate="Quantity,float,no" onblur="fillQuantityForGrn(<%=inc %>)"
				maxlength="15" /> <input type="hidden" value="0" class="medcaption"
				name="<%=QUANTITY_RECEIVED %>" tabindex="2" id="<%=quanRec%>"
				maxlength="15" /></td>

			<td width="3%"><input type="text" class="medcaption" value=""
				name="" tabindex="2" id="<%=unitRateVarTemp%>"
				validate="Unit Rate,float,no"
				maxonblur="fillUnitForGrn(<%=inc%>);calculateAmountForLoanIn(<%=inc%>);"
				maxlength="12" /> <input type="hidden" class="medcaption" value="0"
				name="<%=UNIT_RATE%>" tabindex="2" id="<%=unitRateVar%>"
				maxlength="12" /></td>

			<td width="3%"><input type="text" class="medcaption" value=""
				name="" tabindex="2" id="<%=discountVarTemp%>"
				validate="Discount,float,no"
				onblur="fillDiscountForGrn(<%=inc %>);calculateAmountForLoanIn(<%=inc%>);"
				maxlength="15" /> <input type="hidden" class="medcaption" value="0"
				name="<%=DISCOUNT_PERCENTAGE%>" tabindex="2" id="<%=discountVar%>"
				maxlength="15" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="" tabindex="2" id="<%=taxVarTemp%>" validate="Tax,float,no"
				onblur="fillTaxForGrn(<%=inc %>);calculateAmountForLoanIn(<%=inc%>);" />
			<input type="hidden" value="0" class="medcaption"
				name="<%=TAX_PERCENT %>" tabindex="2" id="<%=taxVar%>" /></td>

			<td width="10%"><input type="hidden" value="" class="medcaption"
				name="" tabindex="2" id="<%=costPriceTemp%>" readonly="readonly"
				onblur="fillCostPriceForGrn(<%=inc %>)" maxlength="10" /> <input
				type="hidden" value="0" class="medcaption" name="<%=COST_PRICE%>"
				tabindex="2" id="<%=costPrice%>" maxlength="10" /> <input
				type="text" value="" class="medcaption" name="" tabindex="2"
				id="<%=amtVarTemp%>" readonly="readonly"
				onblur="fillAmountForGrn(<%=inc %>)" maxlength="15" /> <input
				type="hidden" value="0" class="medcaption" name="<%=AMOUNT%>"
				tabindex="2" id="<%=amtVar%>" maxlength="15" /> <input type="hidden"
				value="0" name="<%=FREE_QTY %>" id="<%= freeQty %>" /> <input
				type="hidden" value="0" name="<%=MANUFACTURER_ID %>"
				id="<%=manufacturerId %>" /> <input type="hidden" value="0"
				name="<%=FREE_ITEM %>" id="<%=freeItem %>" /> <input type="hidden"
				value="0" name="<%=INSTALLATION_DATE %>" id="<%=installationDate %>" />
			<input type="hidden" value="0" name="<%=AMC_START_DATE %>"
				id="<%=amcStartDate %>" /> <input type="hidden" value="0"
				name="<%=AMC_END_DATE %>" id="<%=amcEndDate %>" /> <input
				type="hidden" value="0" name="<%=WARRANTY_DATE %>"
				id="<%=warrantyDate %>" /></td>

			<td width="3%"><input type="button"
				onclick="get_value(<%=temp+inc%>);" name="Submit2" value=""
				class="morebutton" /></td>
		</tr>
		<%
     	 }   %>


	</tbody>
</table>
</br>

<label class="bodytextB"><font id="error"></font>CRV Value</label> <input
	type="text" name="<%=GRN_VALUE %>" id="<%=GRN_VALUE %>" value=""
	class="textbox_size20" MAXLENGTH="8"/  > <input type="hidden"
	name="<%=TOTAL_AMOUNT %>" id="<%=TOTAL_AMOUNT%>" value=""> <br />
<br />
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
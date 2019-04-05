<%@page import="static jkt.hms.util.RequestConstants.*"%>
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
<%@page import="java.text.SimpleDateFormat" %>


<%@page import="java.math.BigDecimal"%>
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>	
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>



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
	
	
	
function checkForLoanIn1(val,a,inc)
{
		var pageNo = 1//parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*10)+1;
    	var end=((pageNo-1)*10)+10;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	   
	    for(i=1;i<=10;i++)
	    {
	    	if(pvms !="" && i!=inc)
	    	{
	    		if (document.getElementById('codeItem'+i).value==pvms)
	    		{
	    	    	alert("Item already selected...!")
	    			document.getElementById('nameItem'+inc).value=""
	    			document.getElementById('codeItem'+inc).value=""
	    			return false;
	    		}
	    	}
	    }
	   
		ajaxFunctionForAutoCompleteInLoanIn1('indentGrid','stores?method=fillItemsForLoanIn&requiredField=' + pvms , inc);
		
}
function autocompleteBasedOnPvms(val,inc)
{

		ajaxFunctionForAutoCompleteForLoanIn('indentGrid','stores?method=fillItemsCommon&pvmsNo=' +  val , inc);
}	
function ajaxFunctionForAutoCompleteForLoanIn(formName,action,rowVal) 
{
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    var url=action
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
     
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	
      	for (loop = 0; loop < items.childNodes.length; loop++) 
      	{
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var name  = item.getElementsByTagName("name")[0];
	       
	       // document.getElementById('codeItem'+rowval).value = pvms.childNodes[0].nodeValue 
        	document.getElementById('nameItem'+rowVal).value = name.childNodes[0].nodeValue + "[" + pvms.childNodes[0].nodeValue + "]"
      }
    }
  }
}
function removePreviousData(rowVal){
		document.getElementById('brandId'+rowVal).selectedIndex = 0;
		document.getElementById('manufacturerId'+rowVal).selectedIndex = 0;
		var brandId=document.getElementById('brandId'+rowVal);
		var manufacturerId = document.getElementById('manufacturerId'+rowVal);
		for(i=1 ; brandId.length > 1 ;++i){
		brandId.remove(1);
		}
		for(j=1 ;manufacturerId.length > 1 ;j++){
		manufacturerId.remove(1);
		}
		document.getElementById('brandId'+rowVal).focus();
		}
	
</script>
<%
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage = "no";
	int pageNo = 1;
	int loanInId = 0;
	List<StoreLoaninM> searchLoanInList = new ArrayList<StoreLoaninM>();
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<StoreGrnM> previousStoreGrnMList = new ArrayList<StoreGrnM>();
	List<StoreLoaninT> storeLoanInTList = new ArrayList<StoreLoaninT>();
	List<StoreLoaninM> storeLoanInMList = new ArrayList<StoreLoaninM>();
	int maxLoaninNo = 0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}

	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	if (map.get("supplierList") != null) {
		supplierList = (ArrayList) map.get("supplierList");
		session.setAttribute("supplierList", supplierList);
	} else if (session.getAttribute("supplierList") != null) {
		supplierList = (ArrayList) session.getAttribute("supplierList");

	}
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if (map.get("employeeList") != null) {
		employeeList = (ArrayList) map.get("employeeList");
		session.setAttribute("employeeList", employeeList);
	} else if (session.getAttribute("employeeList") != null) {
		employeeList = (ArrayList) session.getAttribute("employeeList");

	}
	List<StorePoHeader> poList = new ArrayList<StorePoHeader>();
	if (map.get("poList") != null) {
		poList = (ArrayList) map.get("poList");
		session.setAttribute("poList", poList);
	} else if (session.getAttribute("poList") != null) {
		poList = (ArrayList) session.getAttribute("poList");

	}

	List<StoreIndentM> indentList = new ArrayList<StoreIndentM>();
	if (map.get("indentList") != null) {
		indentList = (ArrayList) map.get("indentList");
		session.setAttribute("indentList", indentList);
	} else if (session.getAttribute("indentList") != null) {
		indentList = (ArrayList) session.getAttribute("indentList");

	}
	List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
	if (map.get("brandList") != null) {
		brandList = (ArrayList) map.get("brandList");
		session.setAttribute("brandList", brandList);
	} else if (session.getAttribute("brandList") != null) {
		brandList = (ArrayList) session.getAttribute("brandList");

	}
	if (map.get("loanInId") != null) {
		loanInId = Integer.parseInt("" + map.get("loanInId"));
		System.out.print(" loanInId    " + loanInId);
	}
	int poId = 0;
	if (map.get("poId") != null) {
		poId = Integer.parseInt("" + map.get("poId"));
		System.out.print(" poId " + poId);
	}

	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt("" + map.get("pageNo"));
	}

	if (map.get("maxLoaninNo") != null)
		maxLoaninNo = Integer.parseInt("" + map.get("maxLoaninNo"));

	if (map.get("previousStoreGrnMList") != null)
		previousStoreGrnMList = (List) map.get("previousStoreGrnMList");

	if (map.get("storeLoanInTList") != null) {
		storeLoanInTList = (List) map.get("storeLoanInTList");
	}
	if (map.get("storeLoanInMList") != null)
		storeLoanInMList = (List) map.get("storeLoanInMList");

	String noDetailRecords = "no";
	if (map.get("noDetailRecords") != null) {
		noDetailRecords = ("" + map.get("noDetailRecords"));
	}

	if (map.get("searchLoanInList") != null)
		searchLoanInList = (List) map.get("searchLoanInList");

	if (map.get("itemList") != null)
		itemList = (List) map.get("itemList");

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String msg = "";
	if(map.get("messageTOBeVisibleToTheUser")!= null){
		msg = (String)map.get("messageTOBeVisibleToTheUser");
	}

	String time = "";
	String date = "";
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	date = (String) utilMap.get("currentDate");
	time = (String) utilMap.get("currentTime");
%>



<div id="contentHolder">
<h3><%=msg %></h3>
<form name="indentGrid" method="post">

<div id="testDiv">
<%
	if (previousPage.equals("no")) {
%> <%
 	if (map.get("storeLoanInMList") != null) {
 			storeLoanInMList = (List<StoreLoaninM>) map
 					.get("storeLoanInMList");
 		}
 		StoreLoaninM grnMObj = null;

 		if (storeLoanInMList.size() > 0) {
 			grnMObj = (StoreLoaninM) storeLoanInMList.get(0);

 			loanInId = grnMObj.getId();
 		}
 %>

<div class="Clear"></div>
<div class="blockTitle">Loan In Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
		<label class="bodytextB" >Source Of Supply:</label> 
		<input type="text" class="textbox_size20" name="<%= SOURCE_OF_SUPPLY %>" value="Local Purchase" readonly="readonly" tabindex=1 />
		<!-- -
		<label class="bodytextB" ><span>*</span> Loan In Number</label> <%
 	//if (grnMObj.getLoaninNo() != null) {
 %>
		<input type="text" class="textbox_size20" name="<%= LOANIN_NO %>"
			value="<%=grnMObj.getLoaninNo()%>" readonly="readonly"
			validate="GRN Number ,String,no" tabindex=1 /> <%
 	//} else {
 %> <input
			type="text" class="textbox_size20" name="<%= LOANIN_NO %>" value=""
			validate="GRN Number ,String,no" tabindex=1 /> <%
 	//}
 %>
		<label class="bodytextB" ><span>*</span> Loan In Date :</label>  <%
 	//if (grnMObj.getLoaninDate() != null) {
 %>
		<input type="text" class="textbox_size20" name="<%= LOANIN_DATE %>" id="<%= LOANIN_DATE %>"
			value="<%=HMSUtil.convertDateToStringWithoutTime(grnMObj.getLoaninDate()) %>" readonly="readonly" tabindex=1
			validate="GRN Date ,String,no" />
				
			 <%
 	//} else {
 %> <input type="text"
			class="textbox_size20" name="<%= LOANIN_DATE %>" id="<%= LOANIN_DATE %>"
			value="<%=currentDate %>" readonly="readonly" tabindex=1
			validate="GRN Date ,String,no" /> <%
 //	}
 %>
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate%>',document.getElementById('<%= LOANIN_DATE %>'),event)" />
		-->
 <div class="Clear"></div>
		<label class="bodytextB" ><span>*</span> Vendor Name:</label>
		 <select name="<%= SUPPLIER_ID %>" validate="Vendor Name,string,no" tabindex=1>
			<option value="">Select</option>
			<%
				System.out.println("supplierList" + supplierList);
					for (MasStoreSupplier masStoreSupplier : supplierList) {
						if (grnMObj != null) {
							if (grnMObj.getSupplier().getId().equals(
									masStoreSupplier.getId())) {
			%>

			<option value=<%=masStoreSupplier.getId()%> selected="selected"><%=masStoreSupplier.getSupplierName()%></option>
			<%
				} else {
			%>


			<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%></option>
			<%
				}
						}
					}
			%>
		</select>
		<label class="bodytextB" >Po Number:</label> <%
 	if (grnMObj.getPo() != null) {
 %>
		<input type="text" class="textbox_size20" name="<%= PO_ID %>"
			value="<%=grnMObj.getPo().getPoNumber()%>" readonly="readonly"
			tabindex=1 /> <%
 	} else {
 %> <input type="text" class="textbox_size20"
			name="<%= PO_ID %>" value="" tabindex=1 readonly="readonly" /> <%
 	}
 %>
		<label class="bodytextB" ><span>*</span> Challan Number :</label> <%
 	if (grnMObj.getChallanNo() != null) {
 %>
		<input type="text" class="calDate" name="<%= CHALLAN_NO %>"
			value="<%=grnMObj.getChallanNo()%>"  tabindex=1 />
		<%
			} else {
		%> <input type="text" class="textbox_size20"
			name="<%= CHALLAN_NO %>" value="" tabindex=1 /> <%
 	}
 %>
 <div class="Clear"></div>
		<label class="bodytextB" >Employee Name:</label> <select
			name="<%= EMPLOYEE_ID %>" validate="Employee Name,string,no"
			tabindex=1>
			<option value="">Select</option>
			<%
				for (MasEmployee masEmployee : employeeList) {
						if (grnMObj != null) {
							if (grnMObj.getEmployee().getId().equals(
									masEmployee.getId())) {
			%>
			<option value=<%=masEmployee.getId()%> selected="selected"><%=masEmployee.getFirstName() + ""
									+ masEmployee.getLastName()%></option>
			<%
				} else {
			%>
			<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName() + ""
									+ masEmployee.getLastName()%></option>
			<%
				}
						}
					}
			%>
		</select>
		<label class="bodytextB">Challan Date :</label> <input
			type="text" class="textbox_size20" name="<%=CHALLAN_DATE%>" id="<%=CHALLAN_DATE%>"
			value="<%=HMSUtil.convertDateToStringWithoutTime(grnMObj.getChallanDate())%>" readonly="readonly" tabindex=1
			validate="GRN Date ,String,no" />
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate%>',document.getElementById('<%=CHALLAN_DATE%>'),event)" />
		
		<label class="bodytextB">Remarks :</label> <%
 	if (grnMObj.getRemarks() != null) {
 %>
		<textarea value="<%=grnMObj.getRemarks()%>" name="<%=REMARKS %>"
			validate="Remarks ,String,no" tabindex=1 maxlength="45" /><%=grnMObj.getRemarks()%></textarea> <%
 	} else {
 %> <textarea value="" name="<%=REMARKS %>"	validate="Remarks ,String,no" tabindex=1 maxlength="45" /></textarea> <%
 	}
 %>
		
</div>


<%
	}
%>
<div class="Clear"></div>
<input type="button" name="sss" align="right" class="button" value="Update"
onclick="if(checkForLoanInGrid() && testForLoanIn()&& checkSave()&& checkForSubmit()){submitForm('indentGrid','stores?method=updateForLoanIn');}" />

<div class="Clear"></div>
<input type="hidden" name="<%=NO_DETAIL_RECORDS%>"	value="<%=noDetailRecords%>" /> 
<input type="hidden" size="2" value="10" name="<%=NO_OF_ROWS %>" id="<%=NO_OF_ROWS %>" /> 
<input type="hidden" name="<%=LOANIN_ID %>" value="<%=loanInId%>" id="hdb" />
<input type="hidden" value="<%=poId%>" id="poId" />
<input type="hidden" value="1" name="pageNo" id="pageNo" /> <br />

<div class="blockTitle">Loan In Details</div><div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="tableHholderCmnLarge2">
<table  colspan="7" id="purchaseDetails"  cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="5%">SR	No</th>
			<th width="8%">PVMS/NIV
			No</th>
			<th width="9%">Nomenclature</th>
			<th width="9%">Brand
			Name</th>
			<th width="9%">Manufacturer
			Name</th>
			<th width="9%">A/U</th>
			<th width="9%">Qty
			Recd</th>
			<th width="9%">Free
			Qty</th>
			<th width="9%">Dispen.Type</th>
			<th width="9%">MDQ</th>
			<th width="9%">Rate
			Per MDQ</th>
			<th width="9%">Batch
			No</th>
			<th width="9%">Unit
			Rate</th>
			<th width="9%">Converted
			Stock</label></th>
			<th width="9%">Disc(%)</th>
			<th width="9%">Tax(%)</th>
			<th width="9%">Amt
			Value</th>
			<th width="9%">Free
			Item</th>
			<th width="20%" colspan="2">Manuf.
			Date</th>
			<th width="9%" colspan="2">Expiry
			Date</th>

		</tr>

	</thead>
	<tbody>
		<%
			int detailCounter = 10;
			int temp = 0;
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			String idItem = "idItem";
			String codeItem = "codeItem";
			String nameItem = "nameItem";
			String idAu = "idAu";
			String idBrand = "idBrand";
			String quantityInVar = "quantityInVar";
			String lotNoVar = "lotNoVar";
			String batchNoVar = "batchNoVar";
			String taxVar = "taxVar";
			String amountVar = "amountVar";
			String unitRateVar = "unitRateVar";
			String discountVar = "discountVar";
			String costPrice ="costPrice";
			String quantityInVarTemp = "quantityInVarTemp";
			String lotNo = "lotNo";
			String batchNoTemp = "batchNoTemp";
			String taxVarTemp = "taxVarTemp";
			String amountVarTemp = "amountVarTemp";
			String unitRateVarTemp = "unitRateVarTemp";
			String discountVarTemp = "discountVarTemp";
			String incVar = "incVar";
			String discountAmount = "discountAmount";
			String freeQty = "freeQty";
			String manufacturerId = "manufacturerId";
			String freeItem = "freeItem";
			String manufacturingDate = "manufacturingDate";
			String expiryDate = "expiryDate";
			String expiry ="expiry";
			String expiry2 ="expiry";
			String formula = "formula";
			String formula2 = "formula";
			String conversionFactor = "conversionFactor";
			String conversionFactor2 = "conversionFactor";
			String brandId = "brandId";
			String amtVar="amtVar";
			String dispenseType = "dispenseType";
			String mdq = "mdq";
			String ratePerMdq = "ratePerMdq";
			String costPrice2 ="costPrice";
			String idItem2 = "idItem";
			String codeItem2 = "codeItem";
			String nameItem2 = "nameItem";
			String idAu2 = "idAu";
			String idBrand2 = "idBrand";
			String quantityInVar2 = "quantityInVar";
			String lotNoVar2 = "lotNoVar";
			String batchNoVar2 = "batchNoVar";
			String taxVar2 = "taxVar";
			String amountVar2 = "amountVar";
			String unitRateVar2 = "unitRateVar";
			String discountVar2 = "discountVar";
			String quanRec="quanRec"; 
			String freeQty2 = "freeQty";
			String manufacturerId2 = "manufacturerId";
			String freeItem2 = "freeItem";
			String manufacturingDate2 = "manufacturingDate";
			String expiryDate2 = "expiryDate";
            String batchNo = "batchNo";
			String quantityInVarTemp2 = "quantityInVarTemp";
			String lotNo2 = "lotNo";
			String batchNoTemp2 = "batchNoTemp";
			String taxVarTemp2 = "taxVarTemp";
			String amountVarTemp2 = "amountVarTemp";
			String unitRateVarTemp2 = "unitRateVarTemp";
			String discountVarTemp2 = "discountVarTemp";
			String incVar2 = "incVar2";
			String brandId2 = "brandId";
			String quanRec2="quanRec"; 
			String dispenseType2 = "dispenseType";
			String mdq2 = "mdq";
			String ratePerMdq2 = "ratePerMdq";
			String batchNo2 = "batchNo"; 
			String convertedStock2 = "convertedStock";
			String convertedStock = "convertedStock";
			String discountAmount2 = "discountAmount";
			String amtVar2="amtVar";
			if (previousPage.equals("no")) {
				int inc = ((pageNo - 1) * 10) + 1;
				System.out.println("--------------inc -----------   " + inc);
				int incTemp2 = inc + 25;

				for (StoreLoaninT storeGrnT : storeLoanInTList) {

					if (inc < incTemp2) {
		%>
		
		<%
			idItem = idItem2 + ("" + inc);
						codeItem = codeItem2 + ("" + inc);
						nameItem = nameItem2 + ("" + inc);
						idAu = idAu2 + ("" + inc);
						idBrand = idBrand2 + ("" + inc);
						quantityInVar = quantityInVar2 + ("" + inc);
						lotNoVar = lotNoVar2 + ("" + inc);
						taxVar = taxVar2 + ("" + inc);
						amountVar = amountVar2 + ("" + inc);
						unitRateVar = unitRateVar2 + ("" + inc);
						discountVar = discountVar2 + ("" + inc);
						brandId = brandId2 + ("" + inc);
						quanRec = quanRec2 +("" +inc);
						freeQty = freeQty2 + ("" + inc);
						freeItem = freeItem2 + ("" + inc);
						manufacturerId = manufacturerId2 + ("" + inc);
						manufacturingDate = manufacturingDate2 + ("" + inc);
						expiryDate = expiryDate2 + ("" + inc);
						batchNo = batchNo2 +("" + inc);
						convertedStock = convertedStock2 + ("" +inc);
						quantityInVarTemp = quantityInVarTemp2 + ("" + inc);
						lotNo = lotNo + ("" + inc);
						taxVarTemp = taxVarTemp2 + ("" + inc);
						unitRateVarTemp = unitRateVarTemp2 + ("" + inc);
						discountVarTemp = discountVarTemp2 + ("" + inc);
						incVar = incVar2 + ("" + inc);
						discountAmount = discountAmount2 +("" + inc); 
						dispenseType = dispenseType2 + ("" + inc);
						mdq = mdq2 + ("" + inc);
						ratePerMdq = ratePerMdq2 + ("" + inc);
						costPrice =  costPrice2 +("" + inc);
						amtVar = amtVar2 + ("" + inc );
						expiry = expiry2 + ("" +inc );
						formula = formula2 + ("" + inc);
						conversionFactor = conversionFactor2 + ("" + inc);
						System.out.println("== storeGrnT.getId(======="
								+ storeGrnT.getId());
		%>
		
		<tr>

			<td width="5%">
			<input type="text" size="2"	value="<%=storeGrnT.getSerialNo()%>"  	name="<%=SR_NO%>" readonly="readonly" />
			</td>
			<td width="10%">
			<%
				if (storeGrnT.getItem() != null) {
			%> <input type="text" value="<%=storeGrnT.getItem().getPvmsNo() %>" tabindex="1" size="8" name="<%=ITEM_CODE %>"  id="<%=codeItem%>" onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');"/>
			<%} else { %>
			<input type="text" value=" " tabindex="1" size="12"	name="<%=ITEM_CODE %>"  id="<%=codeItem%>" onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');"/> 
			<%} %>
			<input type="hidden" name="<%=DETAIL_ID %>"	value="<%=storeGrnT.getId() %>" id="hdb" />
			<input type="hidden" name="flag" value="LoanIn" />
			<input type="hidden" size="2" value="<%=storeGrnT.getItem().getId() %>" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem%>" /> 
			<input type="hidden" value="<%=storeGrnT.getItem().getExpiry() %>" class="smcaption" name="" id="<%=expiry%>" /> 
			<input type="hidden" value="<%=storeGrnT.getItem().getItemConversion().getFormula() %>" class="smcaption" name="" id="<%=formula%>" /> 
			<input type="hidden" value="<%=storeGrnT.getItem().getItemConversion().getConversionFactor1() %>" class="smcaption" name="" id="<%=conversionFactor%>" />
			</td>
			<td width="10%">
			<input type="text"	value="<%=storeGrnT.getItem().getNomenclature()%>" id="<%=nameItem%>" size="40" tabindex="1" onblur="if(fillSrNo('<%=inc %>')){removePreviousData(<%=inc %>);checkForLoanIn1(this.value, '<%=nameItem%>','<%=inc %>');}" />
			<div id="ac2update" style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=<%=nameItem%>&poId='+document.getElementById('poId').value });
			</script>
			</td>
			<td width="10%">
			<select name="<%=BRAND_ID%>" id="<%=brandId%>" tabindex="1">
			    <option value="">select</option>
				<option value="<%=storeGrnT.getBrand().getId()%>" selected="selected"><%=storeGrnT.getBrand().getBrandName()%></option>
			</select>
			</td>
			<td width="10%">
			<select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId%> tabindex="1">
			    <option value="">--select manuf--</option>
				<option value="<%=storeGrnT.getManufacturer().getId()%>" selected="selected"><%=storeGrnT.getManufacturer()
										.getManufacturerName()%></option>
			</select>
			<td width="10%">
			<input type="text" tabindex="1"	value="<%=storeGrnT.getItem().getItemConversion().getItemUnitName() %>"	size="8"  name="<%=AV%>" id="<%=idAu%>" />
			</td>

			<td width="10%">
			<input type="text"	size="10" value="<%=storeGrnT.getReceivedQty() %>"  name="<%=QUANTITY_RECEIVED %>"	id="<%=quanRec %>" tabindex="1" onblur="calculationinLoanIn();"  /> 
			</td>

			<td width="10%">
			<%if(storeGrnT.getFreeQty()!=null){ %>
			<input type="text"  tabindex="1"  value="<%=storeGrnT.getFreeQty()%>" name="<%=FREE_QTY %>" size="5"	id="<%= freeQty %>" onblur="calculationinLoanIn()" />
			<%}else{ %>
			<input type="text"  tabindex="1"  value="" name="<%=FREE_QTY %>" size="5"	id="<%= freeQty %>" onblur="calculationinLoanIn()" />
			<%} %>
			</td>

			<td width="10%">
			<select name="dispenseType" id=<%=dispenseType%>	tabindex="1" >
				<option value="">Select Type</option>
				<option value="Bottle of gm" <%= HMSUtil.isSelected(storeGrnT.getDispType(),"Bottle of gm")%> >
				Bottle	of (gm)</option>
				<option value="Bottle of ml" <%=HMSUtil.isSelected(storeGrnT.getDispType(),"Bottle of ml")%>>Bottle
				of (ml)</option>
				<option value="Each" <%=HMSUtil.isSelected(storeGrnT.getDispType(),"Each")%>>Each</option>
				<option value="Jar of gm"	<%=HMSUtil.isSelected(storeGrnT.getDispType(),"Jar of gm")%>>Jar
				of (gm)</option>
				<option value="Kit of Tests"	<%=HMSUtil.isSelected(storeGrnT.getDispType(),"Kit of Tests")%>>Kit
				of (Tests)</option>
				<option value="No"
					<%=HMSUtil.isSelected(storeGrnT.getDispType(),"No")%>>No</option>
				<option value="Pack of No" <%=HMSUtil.isSelected(storeGrnT.getDispType(),"Pack of No")%>>Pack
				of (No)</option>
				<option value="Reel of Mtr" <%=HMSUtil.isSelected(storeGrnT.getDispType(),"Reel of Mtr")%>>Reel
				of (Mtr)</option>
				<option value="Strip of No" <%=HMSUtil.isSelected(storeGrnT.getDispType(),"Strip of No")%>>Strip
				of (No)</option>
				<option value="Tests" <%=HMSUtil.isSelected(storeGrnT.getDispType(),"Tests")%>>Tests</option>
				<option value="Tube of gm" <%=HMSUtil.isSelected(storeGrnT.getDispType(),"Tube of gm")%>>Tube
				of (gm)</option>
				<option value="BOTTLE" <%=HMSUtil.isSelected(storeGrnT.getDispType(),"BOTTLE")%>>BOTTLE</option>
			</select>
			</td>
			<td width="10%">
			<input type="text" size="8" name="mdq" id="<%=mdq%>" value=<%=storeGrnT.getMdqValue()%> tabindex="1" />
			</td>

			<td width="10%">
			<input type="text" size="10"  name="ratePerMdq" value="<%=storeGrnT.getRatePerMdq()%>" id="<%=ratePerMdq%>"  tabindex="1" onblur="calculationinLoanIn()" />
			</td>

			<td width="10%">
			<input type="text" size="12"	value="<%=storeGrnT.getBatchNo() %>"  name="<%=BATCH_NO %>"	id="<%=batchNo%>" tabindex="1"  /> 
			<input type="hidden" value="<%=storeGrnT.getLotNo() %>" name="<%=LOT_NO %>" id="<%=lotNo %>" tabindex="1"  />
			</td>
            <td width="3%">
			<input type="text"  value="<%=storeGrnT.getUnitRate() %>" name="<%=UNIT_RATE%>" tabindex="1" id="<%=unitRateVarTemp%>" size="12" /> 
			</td>
			
			<td width="3%">
			<input type="text" size="10" value="" name="convertedStock" id="<%=convertedStock%>" readonly="readonly" size="12"/>
			</td>

			<td width="3%">
			<% if(storeGrnT.getDiscount().floatValue() !=0.00){
				double disV = storeGrnT.getDiscount().floatValue();
			   double amtV = storeGrnT.getAmountValue().floatValue();
			   double taxP=0.00;
			   if(storeGrnT.getTax()!=null){
				   taxP = storeGrnT.getTax().floatValue();
			   }
			   double amtWT = (amtV*100.00)/(100.00+taxP);
			   double amtWTD = amtWT + disV;
			   double disP = (disV*100.00)/amtWTD ;
			      
			     
			      //System.out.println("disP::"+(new BigDecimal(disP)).setScale(2 , BigDecimal.ROUND_HALF_UP)+"::disV::"+disV+"::amtV::"+amtV+"::taxP::"+taxP);
			%>
			<input type="text" size="10" value="<%=(new BigDecimal(disP)).setScale(4, BigDecimal.ROUND_HALF_UP) %>" name="<%=DISCOUNT_PERCENTAGE%>" tabindex="1" id="<%=discountVar%>" onblur="calculationinLoanIn();" validate="Discount,float,no"  /> 
			<input type="hidden"  value="<%=storeGrnT.getDiscount() %>" name="discountAmount" id="<%=discountAmount%>" />
			<%}else{ %>
			<input type="text" size="10" value="" name="<%=DISCOUNT_PERCENTAGE%>" tabindex="1" id="<%=discountVar%>" onblur="calculationinLoanIn();" validate="Discount,float,no"  /> 
			<input type="hidden"  value="" name="discountAmount" id="<%=discountAmount%>" />
			
			<%} %>
			</td>

			<td width="10%">
			<%if(storeGrnT.getTax()!=null){ %>
			<input type="text" value="<%=storeGrnT.getTax() %>" size="10"  name="<%=TAX_PERCENT %>" tabindex="1" id="<%=taxVar%>" onblur="calculationinLoanIn();" validate="Tax,float,no"  /> 
			<%}else{ %>
			<input type="text" value="" size="10"  name="<%=TAX_PERCENT %>" tabindex="1" id="<%=taxVar%>" onblur="calculationinLoanIn();" validate="Tax,float,no"  />
			<%} %>
			</td>

			<td width="10%">
			<input type="text" value="<%=storeGrnT.getAmountValue() %>" size="10" name="<%=AMOUNT %>" tabindex="1" id="<%=amtVar%>" /> 
			<input type="hidden" value="<%=storeGrnT.getAmountValue() %>"  name="<%= COST_PRICE %>" id="<%=costPrice%>" />
			
			</td>

			<td width="10%">
			<select class="small" value="<%=storeGrnT.getFreeItem() %>" name="<%=FREE_ITEM %>" id="<%=freeItem %>" tabindex="1">
				<option value="n">No</option>
				<option value="y">Yes</option>
			</select>
			</td>

			<td width="40%">
			<% 
			if(storeGrnT.getManufacturerDate()!=null){
			String[] arr = 	storeGrnT.getManufacturerDate().split("-");
			String ManufacturerDate = arr[2]+"/"+arr[1]+"/"+arr[0];
			%>
			<input type="text" value="<%=ManufacturerDate%>" name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate%>"  MAXLENGTH="30" tabindex="1" readonly="readonly" size="10"/>
			<%}else{ %>
			<input type="text" value="" name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate%>"  MAXLENGTH="30" tabindex="1" readonly="readonly" size="10"/>
			<%} %>
			</td>
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate%>'),event)" />
			
			</td>

			<td width="40%">
			<input type="text" value="<%=HMSUtil.changeDateToddMMyyyy(storeGrnT.getExpiryDate())%>" name="<%=EXPIRY_DATE%>" id="<%=expiryDate %>"  MAXLENGTH="30" tabindex="1" readonly="readonly" size="10"/>
			</td>
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate%>'),event)" />
			
			</td>
		</tr>

		<%
			inc++;
					}
				}
		%>
		<script>
	    	   
	    	 document.indentGrid.noOfRows.value=<%=inc-((pageNo-1)*10)-1%>
	    	 </script>
		<%
			detailCounter = 25;
				temp = 0;
				idItem = "idItem";
				codeItem = "codeItem";
				nameItem = "nameItem";
				idAu = "idAu";
				idBrand = "idBrand";
				quantityInVar = "quantityInVar";
				lotNoVar = "lotNoVar";
				batchNoVar = "batchNoVar";
				taxVar = "taxVar";
				amountVar = "amountVar";
				unitRateVar = "unitRateVar";
				discountVar = "discountVar";

				quantityInVarTemp = "quantityInVarTemp";
				lotNo = "lotNo";
				batchNoTemp = "batchNoTemp";
				taxVarTemp = "taxVarTemp";
				amountVarTemp = "amountVarTemp";
				unitRateVarTemp = "unitRateVarTemp";
				discountVarTemp = "discountVarTemp";
				incVar = "incVar";

				freeQty = "freeQty";
				manufacturerId = "manufacturerId";
				freeItem = "freeItem";
				manufacturingDate = "manufacturingDate";
				expiryDate = "expiryDate";

				dispenseType = "dispenseType";
				mdq = "mdq";
				ratePerMdq = "ratePerMdq";
				
				idItem2 = "idItem";
				codeItem2 = "codeItem";
				nameItem2 = "nameItem";
				idAu2 = "idAu";
				idBrand2 = "idBrand";
				quantityInVar2 = "quantityInVar";
				lotNoVar2 = "lotNoVar";
				batchNoVar2 = "batchNoVar";
				taxVar2 = "taxVar";
				amountVar2 = "amountVar";
				unitRateVar2 = "unitRateVar";
				discountVar2 = "discountVar";

				freeQty2 = "freeQty";
				manufacturerId2 = "manufacturerId";
				freeItem2 = "freeItem";
				manufacturingDate2 = "manufacturingDate";
				expiryDate2 = "expiryDate";

				quantityInVarTemp2 = "quantityInVarTemp";
				lotNo = "lotNo";
				batchNoTemp2 = "batchNoTemp";
				taxVarTemp2 = "taxVarTemp";
				amountVarTemp2 = "amountVarTemp";
				unitRateVarTemp2 = "unitRateVarTemp";
				discountVarTemp2 = "discountVarTemp";
				incVar2 = "incVar2";
                
				dispenseType2 = "dispenseType";
				mdq2 = "mdq";
				ratePerMdq2 = "ratePerMdq";

				if (inc < incTemp2) {
					for (; inc < incTemp2; inc++) {
						idItem = idItem2 + ("" + inc);
						codeItem = codeItem2 + ("" + inc);
						nameItem = nameItem2 + ("" + inc);
						idAu = idAu2 + ("" + inc);
						idBrand = idBrand2 + ("" + inc);
						quantityInVar = quantityInVar2 + ("" + inc);
						lotNoVar = lotNoVar2 + ("" + inc);
						taxVar = taxVar2 + ("" + inc);
						amountVar = amountVar2 + ("" + inc);
						unitRateVar = unitRateVar2 + ("" + inc);
						discountVar = discountVar2 + ("" + inc);
						costPrice =  costPrice2 +("" + inc);
						freeQty = freeQty2 + ("" + inc);
						freeItem = freeItem2 + ("" + inc);
						brandId = brandId2 + ("" + inc);
						manufacturerId = manufacturerId2 + ("" + inc);
						manufacturingDate = manufacturingDate2 + ("" + inc);
						expiryDate = expiryDate2 + ("" + inc);
						batchNo = batchNo2 + ("" + inc);
						convertedStock = convertedStock2 + ("" + inc);
						quantityInVarTemp = quantityInVarTemp2 + ("" + inc);
						lotNo = lotNo + ("" + inc);
						taxVarTemp = taxVarTemp2 + ("" + inc);
						unitRateVarTemp = unitRateVarTemp2 + ("" + inc);
						discountVarTemp = discountVarTemp2 + ("" + inc);
						incVar = incVar2 + ("" + inc);
						batchNo = batchNo2 +(""+inc);
						discountAmount = discountAmount2 +("" + inc);
						dispenseType = dispenseType2 + ("" + inc);
						mdq = mdq2 + ("" + inc);
						ratePerMdq = ratePerMdq2 + ("" + inc);
						amtVar = amtVar2 + ("" + inc );
						expiry = expiry2 + ("" +inc );
						formula = formula2 + ("" + inc);
						quanRec = quanRec2 +("" +inc);
						conversionFactor = conversionFactor2 + ("" + inc);
		%>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"  name="<%=SR_NO%>" readonly="readonly" />
			</td>
			<td width="10%">
			<input type="text" size="8" name="<%=ITEM_CODE %>"  id="<%=codeItem%>" value="" onblur="ajaxFunctionForAutoCompleteForLoanIn('indentGrid','stores?method=fillItemsCommon&pvmsNo=' +  this.value , '<%=inc %>');" tabindex="1" />
			<input type="hidden" size="2" value="0" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem%>" />
			<input type="hidden" value="" class="smcaption" name="" id="<%=expiry%>" /> 
			<input type="hidden" value="" class="smcaption" name="" id="<%=formula%>" /> 
			<input type="hidden" value="" class="smcaption" name="" id="<%=conversionFactor%>" />
			</td>
			
			<td width="10%">
			<input type="text" value="" tabindex="1"  id="<%=nameItem%>" size="40" name="<%=nameItem%>"  onblur="if(fillSrNo('<%=inc %>')){removePreviousData(<%=inc %>);checkForLoanIn1(this.value, '<%=nameItem%>','<%=inc %>');}"/>
			<div id="ac2update" style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=<%=nameItem%>&poId='+document.getElementById('poId').value });
			</script>
			</td>
			<td width="10%">
			<select name="<%=BRAND_ID%>" id="<%=brandId%>" tabindex="1">
				<option value="0">Select</option>
			</select>
			</td>

			<td width="10%">
			<select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId%> tabindex="1">
				<option value="">--select manuf--</option>
			</select>
			<td width="10%">
			<input type="text" value="" size="8" name="<%=AV%>" id="<%=idAu%>" tabindex="1" />
			</td>

			<td width="10%">
			<input type="text" value="0" size="10"  name="<%=QUANTITY_RECEIVED %>" tabindex="1" id="<%=quanRec%>"
				onblur="calculationinLoanIn();" /></td>

			<td width="10%">
			<input type="text" value=""	name="<%=FREE_QTY %>" id="<%=freeQty%>" size="5"
				tabindex="1" onblur="calculationinLoanIn()" />
			</td>

			<td width="10%">
			<select name="dispenseType" id=<%=dispenseType%>	tabindex="1" >
				<option value="">Select Type</option>
				<option value="Bottle of gm">Bottle of gm</option>
				<option value="Bottle of ml">Bottle of ml</option>
				<option value="Each">Each</option>
				<option value="Jar of gm">Jar of gm</option>
				<option value="Kit of Tests">Kit of Tests</option>
				<option value="No">No</option>
				<option value="Pack of No">Pack of No</option>
				<option value="Reel of Mtr">Reel of Mtr</option>
				<option value="Strip of No">Strip of No</option>
				<option value="Tests">Tests</option>
				<option value="Tube of gm">Tube of gm</option>
				<option value="BOTTLE" >BOTTLE</option>
			</select>
			</td>
			<td width="10%">
			<input type="text" size="8" value=""  name="mdq" id="<%=mdq%>" tabindex="1" />
			</td>

			<td width="10%">
			<input type="text" value="" size="8"  name="ratePerMdq" id="<%=ratePerMdq%>" tabindex="1"
				onblur="calculationinLoanIn()" />
			</td>

			<td width="10%">
			<input type="text" value="" size="12" name="<%=BATCH_NO %>" tabindex="1" id="<%=batchNo%>" maxlength="10" />
			<input type="hidden" value=""  name="<%=LOT_NO %>" tabindex="1" id="<%=lotNo%>" maxlength="50" />
			</td>
			<td width="3%">
			<input type="text" size="12" value="" name="<%=UNIT_RATE%>" tabindex="1" id="<%=unitRateVarTemp%>"  />
			
			</td>
           
            <td width="3%">
          
			<input type="text"  value="" name="convertedStock" id="<%=convertedStock%>" size="10" readonly="readonly" />
			</td>
			
			<td width="3%">
			<input type="text"  value="" size="10"	name="<%=DISCOUNT_PERCENTAGE%>" tabindex="1"
				id="<%=discountVar%>" onblur="calculationinLoanIn();" validate="Discount,float,no" /> 
			<input type="hidden"  value="" name="discountAmount" id="<%=discountAmount%>" />
			</td>

			<td width="10%">
			<input type="text" size="10" name="<%=TAX_PERCENT %>" tabindex="1" id="<%=taxVar%>"
				onblur="calculationinLoanIn();" validate="Tax,float,no" /> 
			</td>
			<td width="10%">
			<input type="hidden" value="0"  name="<%= COST_PRICE %>" id="<%=costPrice%>" />
			<input type="text" value="0"  size="10" name="<%=AMOUNT%>" id="<%=amtVar%>" readonly="readonly" />
			</td>

			<td width="10%">
			<select name="<%=FREE_ITEM %>"
				id="<%=freeItem%>" class="small" onChange="">
				<option value="n">No</option>
				<option value="y">Yes</option>
			</select>
			</td>

			<td width="40%">
			<input type="text" name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate%>" tabindex="1" size="10"	readonly="readonly" /> 
			</td>
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate%>'),event)" />
			
			</td>

			<td width="40%">
			<input type="text" name="<%=EXPIRY_DATE%>" id="<%=expiryDate %>" tabindex="1" size="10" readonly="readonly" /> 
			</td>
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate%>'),event)" />
			</td>
		</tr>

		<%
			}
				}
		%>
		<%
			}//this is if(previousPage.equals("no")) end
			else {
			}
		%>

	</tbody>

</table>
</div>

</div>
<%
	if (map.get("storeLoanInMList") != null) {
		storeLoanInMList = (List<StoreLoaninM>) map
				.get("storeLoanInMList");
	}
	StoreLoaninM grnMObj = null;

	if (storeLoanInMList.size() > 0) {
		System.out.println("if(storeLoanInMList.size() >>>>>> 0)");
		grnMObj = (StoreLoaninM) storeLoanInMList.get(0);
		loanInId = grnMObj.getId();
		System.out.println("Getting the grnMObj---"
				+ grnMObj.getLoaninNo());
	}
%>
<div class="Clear"></div>
<label class="bodytextB_blue">CRV Value</label>

<input type="text"	name="loanInValue" id="loanInValue" value="<%=grnMObj.getLoaninValue() %>"	class="textbox_size20" MAXLENGTH="20" readonly="readonly" />
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label >Changed Date:</label>
<label class="value"><%=date%></label>

<label>Changed Time:</label>
<label class="value"><%=time%></label>
</div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" />
	</div>


<%@page import="java.util.*"%>
<%@page
	import="static jkt.hms.util.RequestConstants.*,java.math.BigDecimal"%>


<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalReturnM"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreGrnReturnM"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />
<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
</script>
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
<script type="text/javascript">
 var nameArray=new Array();
 var codeArray=new Array();

</script>
<%
	 int pageNo=1;
	int storeFyDocumentNoId = 0;
	Map map = new HashMap();
	String buttonFlag="";
	String max="";
    
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("stores.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	int departmentIdForReturnFromDispensary = Integer.parseInt(properties.getProperty("departmentIdForReturnFromDispensary"));
	
	int deptId = 0 ;
	int vendorReturnId = 0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String timeInHHmm="";
	String [] tempArr = null;
	tempArr = time.split(":");
	for (int i = 0 ; i < tempArr.length-1 ; i++) {
		
		timeInHHmm=timeInHHmm+(String)tempArr[i];
    	 if(i==0)
    	 {
    		 timeInHHmm=timeInHHmm+":";
    	 }
	}
	
	if(map.get("buttonFlag") != null)
	{
		buttonFlag=(String)map.get("buttonFlag");
	}
	if(map.get("pageNo") != null)
	{
		pageNo=(Integer)map.get("pageNo");
	}
	
	if(map.get("deptId") != null)
	{
		deptId=(Integer)map.get("deptId");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	String fromDateToDate=(String)map.get("fromDateToDate");
	
	List listOfItemsInStock=new ArrayList();
	List brandList= new ArrayList();
	List returnNoList= new ArrayList();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<StoreGrnReturnM> searchList = new ArrayList<StoreGrnReturnM>();
	try {
		if(map.get("listOfItemsInStock") != null){
			listOfItemsInStock=(List)map.get("listOfItemsInStock");
		}
		if(map.get("supplierList") != null){
			supplierList=(List)map.get("supplierList");
		}
		if (map.get("deptList") != null) {
			deptList = (List)map.get("deptList");
		}
		if (map.get("brandList") != null) {
			brandList = (List)map.get("brandList");
		}
		if (map.get("returnNoList") != null) {
			returnNoList = (List)map.get("returnNoList");
		}
		if (map.get("employeeList") != null) {
			employeeList = (List<MasEmployee>)map.get("employeeList");
		}
		if (map.get("searchList") != null) {
			searchList = (List<StoreGrnReturnM>)map.get("searchList");
		}
		if(map.get("storeFyDocumentNoId") != null){
			storeFyDocumentNoId = (Integer)map.get("storeFyDocumentNoId");
		}
		if(map.get("max") != null){
			max = ""+map.get("max");
		}
		System.out.println("max   "+max);
	} catch (Exception exp) {
		exp.printStackTrace();
	}
	Box box = HMSUtil.getBox(request);
  %>
<script language="javascript">
	function checkForVendorReturn(val,a,inc){
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
	    for(i=1;i<=8;i++){
	    if(val !="")
	    if(document.getElementById('brandName'+i).value==val){
	    if(document.getElementById('brandName'+inc).value!=val){
	    	alert("Item already selected...!")
	    	document.getElementById('brandName'+inc).value=""
	    	
	    	return false;
	    	}
	    }}
		ajaxFunctionForVendorReturn('vendorReturnForm','stores?method=fillItemsForIndentToVendorReturn&brandName=' +  val , inc);
}


function fillSrNo(rowVal){

	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		if(rowVal==0){
   			rowVal=8
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	var errorMessage="";
	if(document.getElementById('referenceNo').value == "")
		errorMessage=errorMessage+"Please fill referenceNo  \n"; 
	
	if(document.getElementById('vendorId').value == 0)
		errorMessage=errorMessage+"Please Select Vendor name \n";
	if(document.getElementById('SONo').value == "")
		errorMessage=errorMessage+"Please fill Supply Order No \n";
	if(document.getElementById('returnBy').value == 0)
		errorMessage=errorMessage+"Please select return By \n";
		if(document.getElementById('approvedBy').value == 0)
		errorMessage=errorMessage+"Please selct Approved By \n";
		
		
		
		
	
	if((document.getElementById('referenceNo').value != "")  &&(document.getElementById('vendorId').value != "") &&(document.getElementById('SONo').value != "")&&(document.getElementById('returnBy').value != 0)&&(document.getElementById('approvedBy').value != 0)){
		return true;
	}else{
		alert(errorMessage)
		return false
	}
}

</script>

<div id="contentspace"><br />
<h2 align="left" class="style1">Vendor Return</h2>
<!-- <jsp:include page="searchResultPO.jsp" />--> <!-- </form> -->

<form name="search" method="post">
<div id="testDiv"><input type="hidden" name="pageNo"
	value="<%=pageNo%>" /> <!--  code to make the search panel -->

<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
		</td>
	</tr>
</table>
</div>
<div align="center"><%--------------- Start of Search Panel ---------------------------%>
<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">
<form name="searchPanel" method="post">
<table width="330" border="0" cellpadding="2" cellspacing="1"
	style="border: 1px solid #245E83;">
	<tr>
		<td width="324" class="thead">Search Panel<a
			name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB">Vendor No:</label> <select
			name="<%= RequestConstants.VENDOR_RETURN_ID%>"
			validate="MMF Year,num,Yes" id="mmfYear">
			<option value="0">Select</option>
			<%
				try{
					for(StoreGrnReturnM storeGrnReturnM :searchList){ %>
			}
			<option value="<%=storeGrnReturnM.getId() %>"><%=storeGrnReturnM.getReturnNo() %></option>
			<%} }catch(Exception e){
					e.printStackTrace();
				}%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('search','stores?method=searchVendorReturn&pageNo=<%=pageNo-1%>&deptId=<%=deptId%>&buttonFlag=<%=buttonFlag%>');" />
		</td>
	</tr>
</table>
</form>
</div>
</div>
</div>
<%-------------------- End of Search Panel ---------------------------%>
</form>

<form name="vendorReturnForm" method="post"><!--  code to make the search panel -->
<%
	String returnNo = "";
	
	if(map.get("finalReturnNo") != null){
		System.out.println("(((((((((((((( IN IF  ))))))))))))))))");
		returnNo = (String)map.get("finalReturnNo");
	}else if(map.get("returnNo") != null){
		System.out.println("(((((((((((((( IN ELSE  ))))))))))))))))");
		returnNo = (String)map.get("returnNo");
	}
	%>

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Vendor return details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 130px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">

<input type="hidden" class="textbox_size20" name="storeGrnReturnMId"
	id="storeGrnReturnMId" value="0" tabindex=1 /> <label
	class="bodytextB"><font id="error"></font>Return No:</label> <input
	type="hidden" class="textbox_size20" name="<%=RETURN_NO %>"
	id="vendorReturnId" value="<%= vendorReturnId%>" readonly="readonly"
	validate="Return No ,String,yes" tabindex=1 /> <input type="text"
	class="textbox_date" id="returnNo" value="<%= max%>"
	readonly="readonly" /> <input type="hidden" id="storeFyDocumentNoId"
	value="<%=storeFyDocumentNoId %>" /> <label class="bodytextB"><font
	id="error"></font>Return Date : </label> <input type="text"
	name="<%=RETURN_DATE%>" id="returnDate" value="<%=date %>"
	class="textbox_date" validate="Return Date,dateOfAdmission,yes"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	tabindex="1"
	onClick="setdate('<%=date%>',document.return.<%=RETURN_DATE%>,event)" />


<label class="bodytextB"><font id="error"></font>Reference No: </label>
<input type="text" class="textbox_size20" id="referenceNo"
	name="<%=REFERENCE_NO %>" value="<%=box.get("referenceNo") %>"
	validate="Reference No ,String,yes" tabindex=1 /> <br />

<label class="bodytextB"><font id="error"></font>Vendor Name: </label> <select
	name="<%=VENDOR_NAME %>" id="vendorId" validate="Return By,String,yes">
	<option value="0">Select</option>
	<%
	for (MasStoreSupplier  storeSupplier : supplierList) {
	%>
	<option value="<%=storeSupplier.getId() %>"
		<%=HMSUtil.isSelected(storeSupplier.getId().toString(),box.get("vendorName")) %>><%=storeSupplier.getSupplierName()%></option>
	<%
	}
	%>
</select> <label class="bodytextB"><font id="error"></font>SO No:</label> <input
	type="text" class="textbox_size20" id="SONo" name="<%=SUPPLIER3 %>"
	value="<%=box.get("supplier3") %>" validate="Reference No ,String,yes"
	tabindex=1 /> <br />


<label class="bodytextB"><font id="error"></font>Return By:</label> <select
	name="<%=RETURN_BY_ID %>" id="returnBy" validate="Return By,String,yes">
	<option value="0">Select</option>
	<%
	for (MasEmployee masEmployee : employeeList) {
	%>
	<option value="<%=masEmployee.getId() %>"
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("returnBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%
	}
	%>
</select> <label class="bodytextB"><font id="error"></font>Approved By:</label> <select
	name="<%=APPROVED_BY %>" id="approvedBy"
	validate="Received By ,String,yes">
	<option value="0">Select</option>
	<%
	for (MasEmployee masEmployee : employeeList) {
	%>
	<option value="<%=masEmployee.getId() %>"
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("approvedBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%
	}
	%>
</select> <br />
<label class="bodytextB"><font id="error"></font>Reason:</label> <textarea
	class="txtarea" name="<%=REASON %>" id="reason"
	validate="Reason ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /><%=box.get("reason").trim()%></textarea> <label
	class="bodytextB"><font id="error"></font>Remarks:</label> <textarea
	name="<%=REMARKS %>" id="remarks" class="txtarea"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /><%=box.get("remarks")%></textarea></div>

<br />
<!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->
<div style="float: left; padding-left: 15px;"><input type="hidden"
	id="storeFyDocumentNoId" value="<%=storeFyDocumentNoId %>" /> <input
	type="button" class="button" value="Next"
	onclick="if(checkForNext()){submitForm('vendorReturnForm','stores?method=showVendorReturnJsp&buttonFlag=next&pageNo=<%=pageNo%>&returnNo=<%=max%>&deptId=<%=deptId%>&storeFyDocumentNoId=<%=storeFyDocumentNoId %>');}"
	align="right" /> <input type="button" class="button" value="Delete"
	onclick="openPopupForDelete(1,'<%=max%>');" align="right" /></div>
<div style="float: left; padding-left: 15px; padding-bottom: 10px;">
<label class="bodytextB">Page No:</label>
<div class="changebydt" style="width: 65px;"><%=pageNo%></div>
</div>
<input type="hidden" size="2" value="0"
	name="<%=RequestConstants.NO_OF_ROWS%>"
	id="<%=RequestConstants.NO_OF_ROWS%>" /> <input type="hidden"
	name="pageNo" value="<%=pageNo%>" id="pageNo" /> <input type="hidden"
	size="2" value="9" name="noOfRecords" id="noOfRecords" /> <!-- <input type="hidden" name="<%=STORE_ITEM_BATCH_STOCK_ID %>" value="" id="hdb" /> -->
<input type="hidden" value="<%= deptId%>" name="deptId" id="deptId" />
<br />

<table width="200px" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0"
	style="border: 1px solid #7E7E7E;">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Brand
			Name</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="16%"><label valign="left" class="smalllabel">Total
			Quantity Returned</label></td>

		</tr>
	</thead>
	<tbody>
		<%
    	int detailCounter=8; 
    	int temp=0;
    	    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=8;inc++){
     		
     %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="13%"><input type="text" class="medcaption"
				name="pvmsNo<%=inc%>" readonly="readonly" id="pvmsNo<%=inc%>" /></td>
			<input type="hidden" name="itemId<%=inc%>" id="itemId<%=inc %>"
				value="" />
			<input type="hidden" name="date" id="date" value="<%=date %>" />
			<input type="hidden" name="time" id="time" value="<%=time %>" />

			<td width="10%"><input type="text" value="" tabindex="1"
				id="brandName<%=inc%>" class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForVendorReturn(this.value, 'brandName<%=inc%>','<%=inc %>');}"
				name="brandName<%=inc%>" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('brandName<%=inc%>','ac2update','stores?method=getItemListForVendorReturn',{parameters:'requiredField=brandName<%=inc%>&indentId='+document.getElementById('vendorReturnId').value });
			</script></td>
			<td width="10%"><input type="text" value=""
				id="nomenclature<%=inc%>" class="bigcaption"
				name="<%=NOMENCLATURE%>" readonly /></td>

			<td width="16%"><input type="text" value="" class="medcaption"
				name="<%=QTY_ISSUED%>" id="qtyIssued<%=inc%>" value="" readonly /></td>
		</tr>
		<%
     	}
     %>
	</tbody>
</table>
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


	
	/*	function validatePage(formName) {
			
			var counter=document.getElementById('counter').value;
			//alert(counter)
			formname=formName.name
			//alert(formname)
			 for(var i = 0; i < counter; i++)
			 {
			   amountVal = eval('document.'+formname+'.amount' + i + '.value')
			   issQtyVal=eval('document.'+formname+'.issueQty' + i + '.value')
			  // alert("amount value=="+amountVal+"  issued quantity value=="+issQtyVal)
				if(amountVal =="" && issQtyVal != "")
				{
					alert("Please Enter the correct value in Issued Quantity")
					return false
				}
				if(amountVal !="" && issQtyVal == "")
				{
					alert("Please Enter the Issued Quantity")
					return false
				}
		    }
		return true
		}
	*/	
		
	function fillItemsInGrid(brandId,rowVal,deptId){
	var err = "";
	var referenceNo = document.getElementById('referenceNo').value
	var toWard = document.getElementById('toWard').value
	var returnBy = document.getElementById('returnBy').value
	var receiveBy = document.getElementById('receiveBy').value
	
		for(var i=0;i<nameArray.length;i++){
		if(nameArray[i][5]==brandId){
			document.getElementById('pvmsNo'+rowVal).value=nameArray[i][1]
			document.getElementById('itemId'+rowVal).value=nameArray[i][2]
			document.getElementById('nomenclature'+rowVal).value=nameArray[i][6]
			document.getElementById('noOfRecords').value=rowVal+1;
			
			}
		}
		if(referenceNo == ""){
			err += "Please Enter Reference Number. \n";
		}
		if(toWard == 0){
			err += "Please Enter To Department. \n";
		}
		if(returnBy == 0){
			err += "Please select Return By. \n";
		}
		if(receiveBy == 0){
			err += "Please select Received By.";
		}
		
		if(referenceNo != "" && toWard != 0 && returnBy != 0 && receiveBy != 0){
			if(err == ""){
				openPopup(brandId,deptId,rowVal);
			}
		}else{
			alert(err);
		}
}	
	
	
	function openPopup(brandId,deptId,rowVal){
		var url="/hms/hms/stores?method=showStockDetailsForReturnDispensary&brandId="+brandId+"&deptId="+deptId+"&rowVal="+rowVal;
        popwindow(url);
     }
	function popwindow(url)
	{
		 newwindow=window.open(url,'name',"height=470,width=700,status=1");
    }
	function checkForNext(){
	  if(document.getElementById('noOfRecords').value<=8)
	  {
	  	alert("All rows are not filled.Please Select the Brand Names to Enter ")
	  	return false;
	  }else{
	  return true;
	  }
  }
  
	function openPopupForDelete(brandId,max){
		var url="/hms/hms/stores?method=showDeleteVendorReturn&brandId="+brandId+"&returnNo="+max;
        popwindowForDelete(url);
     }
	function popwindowForDelete(url)
	{
		// newwindow=window.open(url,'name',"height=500,width=700,status=1, scrollbars=yes ");
		 newwindow=window.open(url,'name','status=yes,resizable,scrollbars=1,height=400,width=1000,');
    }	
</script> <script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script></div>










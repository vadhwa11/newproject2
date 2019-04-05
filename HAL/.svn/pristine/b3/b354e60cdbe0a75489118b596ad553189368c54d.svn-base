<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hms.masters.business.MasStorePoDeliveryTerms"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/stores.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js?n=1" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
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
  var numLinesAdded = 1;
  var tt;
  function fillItems(idVal,rowVal){
  
  		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	
    	idItem=idItem+rowVal;
    	
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal;
    	
    	document.getElementById('noOfRows').value=rowVal
		
		for(i=0;i<itemsArray1.length;i++){
		if(itemsArray1[i][0]==idVal){
		document.getElementById(idItem).value=itemsArray1[i][0]
		document.getElementById(nameItem).value=itemsArray1[i][2]
		document.getElementById(idAu).value=itemsArray1[i][3]
		
		}
		}
	
  }
    
  
  function checkForNext10(){
  
  if(document.getElementById('noOfRows').value<200)
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
	  return true;
  }
  
  function checkQtyforGrid(){
	  var noOfRows=document.getElementById('noOfRows').value;

		for(i=1;i<noOfRows;i++)
		{
		if(document.getElementById('quantityInVarTemp'+i).value==0)
			{
			  alert("Qty should be greater than zero.Plese check row no."+i);
			  return false;
			}	
		}	
	  return true;
	  }

  function checkForImport(){
	  if(document.getElementById('VendorId').value==0)
	   {
	   alert("There must be select Vendor");
		  return false;
		}
	  if(document.getElementById('delDate').value=='')
	  {
	  alert("There must be select Delivery Date");
	  return false;
	  }
	  
	 	  return true;
	  }
	
	
function get_value_for_purchase(rowNo)
{
 var url="/hms/hms/purchaseOrder?method=showMoreInfoPurchaseJsp&rowNo="+rowNo;
   popwindow(url);
 }  

var newwindow;
function popwindow(url)
{
 newwindow=window.open(url,'name',"height=500,width=1010,status=1, left=5, top=0");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();

}

// For new AutoComplete

function checkForPurchase(val,a,inc)
{
		/*var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*10)+1;
    	var end=((pageNo-1)*10)+10;*/
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    //for(i=1+inc-1;i<=10+inc-1;i++){
	    //if(pvms !="")
	    //if(document.getElementById('codeItem'+i).value==pvms){
	    //if(document.getElementById('codeItem'+inc).value!=pvms){
	    	//alert("Item already selected...!")
	    	//document.getElementById('nameItem'+inc).value=""
	    	//return false;
	    	//}
	    //}}
	  if(pvms !=""){
		  if(validatePvms(pvms)){
			  ajaxFunctionForAutoCompleteInLPOGeneral('purchaseGrid','stores?method=fillItemsForLpo&pvmsNo=' +  pvms , inc);
				//ajaxFunctionForAutoCompleteForPurchase('purchaseGrid','stores?method=fillItemsCommon&pvmsNo=' +  pvms , inc)
			   	
			}else{
			    return false;
			}
		  
	  }
}

function ajaxFunctionForAutoCompleteInLPOGeneral(formName,action,rowVal) {

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
      	 var brandId="brandId"+rowVal;
		 obj =document.getElementById(brandId); 
		 obj.length = 1;
		
		var manufacturerId="manufacturerId"+rowVal;
		//obj1 =document.getElementById(manufacturerId); 
		//obj1.length = 1;
      	for (loop = 0; loop < items.childNodes.length; loop++) 
      	{
      
	   	    var item = items.childNodes[loop];
	   	    
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var bgId=item.getElementsByTagName("bgId")[0];
	        var formula = item.getElementsByTagName("formula")[0];
	        var conversionFactor = item.getElementsByTagName("conversionFactor")[0];
	       // var name  = item.getElementsByTagName("name")[0];
	       var dispType = item.getElementsByTagName("dispType")[0];
	        var brandLength  = item.getElementsByTagName("brands")[0];
        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
		
				
        	
        	document.getElementById('formula'+rowVal).value = formula.childNodes[0].nodeValue
        	document.getElementById('conversionFactor'+rowVal).value = conversionFactor.childNodes[0].nodeValue
        	//document.getElementById('dispenseType'+rowVal).value = dispType.childNodes[0].nodeValue 
           var dispenseType ="dispenseType"+rowVal;
            obj2 = document.getElementById(dispenseType);
         	obj2.length=1;
			obj2.options[obj2.length-1].value = dispType.childNodes[0].nodeValue;
			obj2.options[obj2.length-1].text  = dispType.childNodes[0].nodeValue;
        	for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++)
        	{
        		var brand = brandLength.childNodes[innerLoop];
	        	var brandId  = brand.getElementsByTagName("brandId")[0];
	        	var brandName  = brand.getElementsByTagName("brandName")[0];
	 
	        	//var manufacturerId = brand.getElementsByTagName("manufacturerId")[0];
	        	//var manufacturerName = brand.getElementsByTagName("manufacturerName")[0];
	        	
	        	obj.length++;
				obj.options[obj.length-1].value=brandId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=brandName.childNodes[0].nodeValue;
				
				//obj1.length++;
				//obj1.options[obj1.length-1].value=manufacturerId.childNodes[0].nodeValue;
				//obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;
        	}
      }
    }
  }
}

function autocompleteBasedOnPvms(val,inc)
{

	if(validatePvms(val)){
		ajaxFunctionForAutoCompleteForLP('purchaseGrid','stores?method=fillItemsCommon&pvmsNo=' +  val , inc);
		   	
		}else{
		    return false;
		}
		
	
}

function ajaxFunctionForAutoCompleteForLP(formName,action,rowVal) 
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
	       	document.getElementById('nameItem'+rowVal).value = name.childNodes[0].nodeValue + "[" + pvms.childNodes[0].nodeValue + "]"
      }
    }
  }
}
 
function fillSrNo(rowVal){
	var pageNo=parseInt(document.getElementById('noOfRows').value);
	
	
   		rowVal=rowVal%200
   		if(rowVal==0){
   			rowVal=200
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
 		  	
 		  	
			}
   		
	return true;
}



function fillSrNoForRowSize(rowVal){
	if(document.getElementById('nameItem'+rowVal).value=='')
		{
		document.getElementById('noOfRows').value=(parseInt(rowVal));
	}else{
	var pageNo=parseInt(document.getElementById('noOfRows').value);
	var rowSize=document.getElementById('rowSize').value;
   		rowVal=rowVal%200
   		if(rowVal==0){
   			rowVal=200
   	 		}
   		if(!(parseInt(document.getElementById('rowSize').value)>=parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=(parseInt(rowVal)+1);
 		  	document.getElementById('rowSize').value=(parseInt(rowSize)+1);
			}
	}
	return true;
	}


function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/purchaseOrder?method=printLocalPoFormatJsp";
  obj.submit();
}

function openItemPopup()
{
 var url="/hms/hms/pharmacy?method=showItemJsp";
 popwindow1(url);
}


function openManufacturerPopup()
{
 var url="/hms/hms/pharmacy?method=showManufacturerJsp";
 popwindow1(url);
}

function popwindow1(url)
{
newwindow=window.open(url,'name',"top=100,height=600,width=1000,status=1");
if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();
}

function openPopupWindowForSupplier()
	{
	 var url="/hms/hms/stores?method=showVendorJsp";
	 newwindow=window.open(url,'name',"left=5,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	}
	        
function jsSetSupplierData(supplierId)
{
 for(var i=0;i<document.getElementById("VendorId").length;i++)
 {
	 if (document.getElementById("VendorId").options[i].value==supplierId)
	 {
	 	document.getElementById("VendorId").selectedIndex = i;
	 	document.getElementById("VendorId").focus();
	 }
 }
}
function getCurSOAmount(){
var vend = document.getElementById('VendorId').value;
var soDate = document.getElementById('soDate').value; 
if(vend != "" && soDate != ""){
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
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
    
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	   var existingtot =0;
	if(document.getElementById('total_amount'))
		existingtot = parseFloat(document.getElementById('total_amount').value);
	  	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var remain = items.childNodes[loop];
	   	    
	       var rem  = remain.getElementsByTagName("rem")[0];
       if(document.getElementById('remain'))
	      document.getElementById('remain').value = roundVal(existingtot + parseFloat(rem.childNodes[0].nodeValue),2);
	if( document.getElementById('totremain'))
		      document.getElementById('totremain').value = roundVal(rem.childNodes[0].nodeValue,2);
	   } 
      }
    }
   
   var url="/hms/hms/purchaseOrder?method=getCurVendorSoAmount&vendorId="+vend+"&soDate="+soDate
     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
}

}        
function checkSaveRem()
{
//var remain = parseFloat(document.getElementById('remain').value);
var msg = ""
 //  if(remain > 100000){
  //   msg = "Total 'SO' amount for the day has exceeded Rs.1 Lakh do you want to continue";
  // }else{
     msg = "Do you want to save ?";
  // }
		if(confirm(msg))
			return true;
		else
			return false;
}
function getlpitemsValidate(){
	
	 // var so = document.getElementById('indentCombo').value;
	 // var loanIn = document.getElementById('loanInStatus').value;
	 var soNo=document.getElementById('soNo').value;
	 var noOfRows=document.getElementById('noOfRows').value;
	
	 var requestType="importLp";
	 currPage=1;
		/*
		* Code for remove metachar Code By Anamika
		*/
	  	if(soNo!= ""){
			if(! validateMetaCharacters(soNo)){
			   	var url="/hms/hms/stores?method=getLPItemDetailsValidate&currPage="+currPage+"&soNo="+soNo+"&requestType="+requestType+"&pageType=add";
				newwindow=window.open(url,'name','top=0, left=5, height=600,width=1010,status=1');
			}else{
			    return false;
			}
		 }
}















function getlpitems(){
	
	 // var so = document.getElementById('indentCombo').value;
	 // var loanIn = document.getElementById('loanInStatus').value;
	 var soNo=document.getElementById('soNo').value;
	 var noOfRows=document.getElementById('noOfRows').value;
	
	 var requestType="importLp";
	 currPage=1;
      numOfRows=10;
      /*
		* Code for remove metachar Code By Anamika
		*/
	  	if(soNo!= ""){
			if(! validateMetaCharacters(soNo)){
				var url="/hms/hms/stores?method=getLPItemDetails&currPage="+currPage+"&soNo="+soNo+"&requestType="+requestType+"&noOfRows="+noOfRows+"&pageType=add";
				newwindow=window.open(url,'name','top=0, left=5, height=600,width=1010,status=1');
			}else{
			    return false;
			}
		 }

		  	   
	  }




	function getMMF(){
	 // var so = document.getElementById('indentCombo').value;
	 // var loanIn = document.getElementById('loanInStatus').value;
	 var soNo=document.getElementById('soNo').value;
	 var noOfRows=document.getElementById('noOfRows').value;
	
	 var requestType="importLp";
	 currPage=1;
     numOfRows=10;
	/*
	* Code for remove metachar Code By Anamika
	*/
  	if(soNo!= ""){
		    if(! validateMetaCharacters(soNo)){
		    	var url="/hms/hms/stores?method=getMMFItem&currPage="+currPage+"&soNo="+soNo+"&noOfRows="+noOfRows+"&requestType="+requestType+"&pageType=add";
				newwindow=window.open(url,'name','top=0, left=5, height=600,width=1010,status=1');
		    }else{
		     return false;
		    }

		   }
		  	   
	  }

function getManufacturerNameByAjax(brandId,rowVal){
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

	 	 var manufacturerId="manufacturerId"+rowVal;
		obj1 =document.getElementById(manufacturerId); 
		obj1.length = 1;
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var manufacturerName  = item.getElementsByTagName("manufacturerName")[0];
		        var mId  = item.getElementsByTagName("mId")[0];

		        
		       // obj1.length++;
	        	obj1.options[obj1.length-1].value=mId.childNodes[0].nodeValue;
				obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;
					        	
	        	
	        	
	      	} 
	      }
	    }
	     url="stores?method=getManufacturerNameInAjax&brandId="+brandId;
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	 }
	 




function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}

function closeSearchBlock()
{

document.getElementById('searchBlock').style.display = 'none';
}

</script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	int poId = 0;

	List<StorePoHeader> poNumberList = new ArrayList<StorePoHeader>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
	if (map.get("poNumberList") != null) {
		poNumberList = (List<StorePoHeader>)map.get("poNumberList");
	}
	
%>
<%if(session.getAttribute("deptId").toString().equals("24")){ %>

 <div class="titleBg">
<h2>Supply Order Approval</h2>
</div>
<form name="purchaseGrid" method="post">
<div id="testDiv">
<div class="Block">
<label>SO No.</label>
<select name="<%=PO_ID%>" onchange="selectPOID(this.value);">
<option value="0">Select</option>
<%	for(StorePoHeader obj: poNumberList){%>
	<option value="<%=obj.getId() %>"><%=obj.getPoNumber() %></option>
<%} %>
</select>
<label> SO Date <span>*</span></label>
<input type="text" name="<%=PO_DATE%>" class="date" id="soDate" onblur="getCurSOAmount();" value="<%=currentDate %>" class="" readonly="readonly" style="border: 1px solid #7f9db7;" validate="S.O. Date,dateOfAdmission,yes"  MAXLENGTH="30"  />
<img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"  validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.purchaseGrid.<%=PO_DATE%>,event)" />
<label class="auto"> Vendor  <span>*</span></label>
<label class="value"></label>
<input class="transparent" size="1" />
<div class="clear"></div>
<label> Delivery Date <span>*</span></label>
<label class="value"></label>
	<label>Reference</label>
<label class="value"></label>
	<label>Category <span>*</span></label>
	<label class="value"></label>
	
	<div class="clear"></div>
	 
	
	<label>Contact No.</label>
	<label class="value"></label>
	<label>Code Head</label>
		<label class="value"></label>
	<input	type="hidden"  name="codehead" value="LCH-749/01"  validate="codehead ,String,no" tabindex=1 />
	<input	type="hidden"  name="requestType"  id="reqType" value="" />
	
	<label>Remarks</label>
	<label class="value"></label>
</div>  

	<div class="clear paddingTop15"></div>
		
<div class="cmntable">
	  	<table align="center" width="100%" id="localSupply" colspan="7"  class="grid_header" border="0" cellpadding="0" cellspacing="0">
		<thead>
		<tr>
		<!-- -
          <th width="5%"></th> -->
             <th>Delete</br>Row</th>
	      <th width="5%">Sl</br>No.</th>
	      <th width="13%">PVMS</br>/NIV No.</th>
	      <th width="13%">Nomenclature</th>
	      <th width="13%">A/U</th>
	      <th width="13%">B/G</th>
	       <th width="13%">Brand</br>Name</th>
	      <th width="13%">Manufacturer</th>
	      <th width="13%">Qty</br>Req.</th>

	 		<th width="9%">Dispense</br>Type</th>
		  <th width="6%">Packaging</th>
		   <th width="10%">Ordered</br>quantity(OQ)</th>
		 
	 
	
	      <th width="10%">MRP per</br>Packaging</th>
	      <th width="13%">Disc(%)</th>
	      <th width="6%">Tax(%)</th>
	      	<th width="9%">Actual</br>Cost</th>
	      <th width="13%">Amount</th>
	      <th>Add Row</th> 	
	   
	  
    	</tr>
    
  </thead>
  <tbody>
  
   	<%
  		int detailCounter=200; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	String idBg="idBg";
    	String quantityInVar="quantityInVar";
    	String taxVar="taxVar";
    	String unitRateVar="unitRateVar";
    	String amountVar = "amountVar";
    	String discountVar="discountVar";
    	
    	String quantityInVarTemp="quantityInVarTemp";
    	String taxVarTemp="taxVarTemp";
    	String unitRateVarTemp="unitRateVarTemp";
    	String amountVarTemp = "amountVarTemp";
    	String costPrice="costPrice";
    	String discountVarTemp="discountVarTemp";
    	String incVar="incVar";
    	
    	String freeQty="freeQty";
    	String amount="amount";
    	String manufacturerId="manufacturerId";
    	String brandId="brandId";
    	String freeItem="freeItem";
    	
    	String dispenseType = "dispenseType";
    	String mdq = "mdq";
    	String ratePerMdq = "ratePerMdq";
    	String mrp = "mrp";
    	String otherTaxes = "otherTaxes";
    	String discountAmount = "discountAmount";
    	String taxAmount = "taxAmount";
    	String actualqty = "actualqty";
    	String actualqtyin = "actualqtyin";
    	String formula = "formula";
    	String conversionFactor = "conversionFactor";
    	String deleteRow="deleteRow";
    	
    	String totRateOq = "totRateOq";
    	String exciseDuty = "exciseDuty";
    	String taxOq = "taxOq"; 
    	String prescription_id="prescription_id";
        	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";
    	String idBg2="idBg";
	   	String quantityInVar2="quantityInVar";
    	String taxVar2="taxVar";
    	String unitRateVar2="unitRateVar";
    	String amountVar2 = "amountVar";
    	String discountVar2="discountVar";
    	
    	String freeQty2="freeQty";
    	String amount2="amount";
    	String manufacturerId2="manufacturerId";
    	String brandId2="brandId";
    	String freeItem2="freeItem";
    	
    	
    	String quantityInVarTemp2="quantityInVarTemp";
    	String taxVarTemp2="taxVarTemp";
    	String unitRateVarTemp2="unitRateVarTemp";
    	String amountVarTemp2 = "amountVarTemp";
    	String costPrice2="costPrice";
    	String discountVarTemp2="discountVarTemp";
    	String incVar2="incVar2";
    	
    	String dispenseType2 = "dispenseType";
    	String mdq2 = "mdq";
    	String ratePerMdq2 = "ratePerMdq";
    	String mrp2 = "mrp";
    	String otherTaxes2 = "otherTaxes";
    	String discountAmount2 = "discountAmount";
    	String taxAmount2 = "taxAmount";
    	String actualqty2 = "actualqty";
    	String actualqtyin2 = "actualqtyin";
    	String formula2 = "formula";
    	String conversionFactor2 = "conversionFactor";
    	
    	String totRateOq2 = "totRateOq";
    	String exciseDuty2 = "exciseDuty";
    	String taxOq2 = "taxOq";
    	String prescription_id2="prescription_id";
    	String deleteRow2="deleteRow";
    	int inc=0;
	
    	
    	 for(inc=1+temp;inc<=10+temp;inc++){
     		
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idAu=idAu2+(""+inc);
     		idBg=idBg2+(""+inc);
     		
     		quantityInVar=quantityInVar2+(""+inc);
     		taxVar=taxVar2+(""+inc);
     		unitRateVar=unitRateVar2+(""+inc);
     		amountVar = amountVar2+(""+inc);
     		discountVar=discountVar2+(""+inc);
     		
     		freeQty=freeQty2+(""+inc);     		
     		freeItem=freeItem2+(""+inc);
     		amount=amount2+(""+inc);
     		manufacturerId=manufacturerId2+(""+inc);
     		brandId=brandId2+(""+inc);
     		
     		quantityInVarTemp=quantityInVarTemp2+(""+inc);
     		taxVarTemp=taxVarTemp2+(""+inc);
     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
     		amountVarTemp = amountVarTemp2+(""+inc);
     		costPrice=costPrice2+(""+inc);
     		discountVarTemp=discountVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
     		
    		dispenseType = dispenseType2 +(""+inc);
        	mdq = mdq2 +(""+inc);
        	ratePerMdq = ratePerMdq2 +(""+inc);
        	mrp = mrp2 +(""+inc);
        	otherTaxes = otherTaxes2 +(""+inc); 
        	discountAmount = discountAmount2+(""+inc);
        	taxAmount=taxAmount2+(""+inc);
        	actualqty = actualqty2+(""+inc);
        	actualqtyin =actualqtyin2+(""+inc); 
        	formula = formula2+(""+inc);
        	conversionFactor = conversionFactor2+(""+inc);
        	totRateOq = totRateOq2+(""+inc);
        	exciseDuty = exciseDuty2+(""+inc);
        	taxOq = taxOq2+(""+inc);
        	prescription_id=prescription_id2+(""+inc);
        	deleteRow=deleteRow2+(""+inc);
    %>
   <tr>
       <td>
				<input type="checkbox" name="delete" vlaue="0"   id="<%=deleteRow%>" tabindex="1" />
	  </td>
      <td width="3%">
      <input type="text" size="3" value="<%=temp+inc%>"  name="<%=SR_NO%>" readonly="readonly" />
	  <input type="hidden" size="2" value="0" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem%>" />
      <input type="hidden" value="" class="smcaption" name="" id="<%=formula%>" />
	  <input type="hidden" value="" class="smcaption" name="" id="<%=conversionFactor%>" />
	  </td>
      <td width="10%">
	     <input type="text" name="<%=ITEM_CODE %>" tabindex="1" id="<%=codeItem%>" onblur="autocompleteBasedOnPvms(this.value,'<%=inc %>');" validate="PVMS No,String,no" size="8"/>
      </td>
      
		<td width="17%">
      	<input type="text" value=""	id="<%=nameItem%>"  onblur="if(fillSrNo('<%=inc %>') && fillSrNoForRowSize('<%=inc %>')){checkForPurchase(this.value, '<%=nameItem%>','<%=inc %>');}"  name="<%=nameItem%>" tabindex="1" size="30" />
		<div id="ac2update" style="display:none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		
		var PId= document.getElementById('poId').value;
	    new Ajax.Autocompleter('<%=nameItem%>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=<%=nameItem%>&poId='+PId });
		</script>
		</td> 
      <td width="10%">
      <input type="text" value="" class="smcaption" readonly="readonly" name="<%=AV%>" id="<%=idAu%>" tabindex="1" validate="A/U ,String,no" size="5"/>
      </td>
       <td width="10%">
       <select name="<%=BG%>" id="<%=idBg%>" tabindex="1" validate="BG ,String,no" class="auto">
             <option value="B">B</option>
             <option value="G">G</option>
             <option value="O">O</option>
             <option value="S">S</option>
             <option value="L">L</option>
             <option value="X">X</option>
             <option value="T">T</option>
             <option value="R">R</option>
             <option value="M">M</option>
             
      </select>
      </td>
      <td width="10%">
      <select name="<%=BRAND_ID%>" class="small3" id=<%=brandId%> tabindex="1" validate="Brand,int,no" onchange="getManufacturerNameByAjax(this.value,<%=inc%>);">
      <option value="">select brand</option>
      </select>
      </td>
      
      <td width="10%">
      <select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId%> tabindex="1" validate="Manufacturer,int,no" class="small3">
      <option value="">select manuf</option>
      </select>
      </td>

      <td width="10%">
       <input type="text" value="0" class="medcaption" name="" id="<%=actualqtyin %>"  size="5" validate="ActualQuantity,float,no" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" tabindex="1" maxlength="9"/>
      <input type="hidden" value="0" class="medcaption" name="<%=ACTUAL_QTY %>" id="<%=actualqty%>"/>
      <input type="hidden" name="prescription_id" value="0" id="<%=prescription_id%>"/> 
      </td>
	  <td width="10%">
      <select name="dipenseType" id=<%=dispenseType%> tabindex="1" validate="Dispense Type,String,no" class="small3">
             <option value="">select Dispen.</option>
      </select>
      </td>
      <td width="10%">
      <input type="text" class="medcaption" name="mdq" id="<%=mdq%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" size="7" validate="Minimum Dispensable Qty (MDQ),num,no" value="1" tabindex="1" maxlength="9"/>
      </td>
      <td width="10%">
      <input type="text" value="0" class="medcaption" name="" id="<%=quantityInVarTemp %>"  size="5" readonly validate="Quantity,float,no" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" tabindex="1" maxlength="9" />	
	 <input type="hidden" value="0" class="medcaption" name="<%=QUANTITY %>" id="<%=quantityInVar%>" />
      </td>
    
      
      <td width="10%">
      <input type="text" class="medcaption" value="0" name="mrp"  id="<%=mrp%>"  size="5" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" validate="Tax,float,no" maxlength="15" tabindex="1" size="5"/>
      </td>
      <td width="3%">
      <input type="text" class="medcaption" value="0" name="<%=DISCOUNT_PERCENTAGE%>" size="4" id="<%=discountVarTemp%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);"  validate="Discount,float,no" maxlength="6" tabindex="1" size="5"/>
      <input type="hidden" class="medcaption" value="0" name="<%=DISCOUNT_AMOUNT%>" id="<%=discountAmount%>"/>
      </td>
 
      <td width="10%">
      <input type="text" class="medcaption" value="0" name="<%=TAX_PERCENT %>" size="4" id="<%=taxVarTemp%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" validate="Tax,float,no" maxlength="15" tabindex="1"/>
                 <input type="hidden" class="medcaption" value="0" name="<%=TAX_AMOUNT%>" id="<%=taxAmount%>"/>
        
      </td>
     
       <td width="10%">
			<input type="text" value="0"	 name="<%= COST_PRICE %>" id="<%=costPrice%>" size="5" tabindex="1"/></td>
		
      <td width="3%">
      <input type="text" class="medcaption" value="0" name="" id="<%=amountVarTemp%>" readonly="readonly" validate="Amount,float,no"  tabindex="1" size="8"/>
      <input type="hidden" class="medcaption" value="0" name="<%=AMOUNT%>"  id="<%=amountVar%>"/>
      </td>
      	<td>
			    <input name="Button" type="button" class="buttonAdd" value="" onclick="addRow('localSupply');" tabindex="1" />
		   </td>
		  
  
       </tr>
   <%
     	 }   %>
	</tbody>
</table>
</div>
     	 <input type="hidden" id="gridSize" name="gridSize" value="<%=inc-1%>">

<input type="hidden" size="2"	value="0"  name="noOfRows" id="noOfRows" />
	
	<br />
</div>	
</form>
<%}else{ %>
<h4>Access Denied! </h4>
<%}%>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	
	<input type="hidden" name="rowSize" id="rowSize" value="0"/>
	<input type="hidden" name="rows" id="rr" value="1"/>
	<input type="hidden" name="rows" id="rr" value="1"/>
	<input type="button" name="sss" class="button" value="DELETE" onclick="removeRow('localSupply');" />
	<input type="button" name="sss"  class="button" value="Submit" onclick="if(checkForSubmit() && checkSaveRem() ){submitForm('purchaseGrid','purchaseOrder?method=approvePurchaseOrder');}"/>
    
    
    <input type="hidden" class="button" value="Delete"/>
    
    <input type="hidden" class="buttonBig" value="Export To CRV"/>
	<div class="clear"></div>
	<div class="division"></div>
		<script type="text/javascript">



		
		 function addRow(idName) 
		 {
	

			 
				  var tbl =  document.getElementById(idName);
				  var lastRow = tbl.rows.length;
				 /* var iteration = lastRow;
				  var row = tbl.insertRow(lastRow);
				  var hdb = document.getElementById('gridSize');
				  hdb.value=iteration
				  */
				  var iteration = lastRow;
				  var row = tbl.insertRow(lastRow);
				  var hdb = document.getElementById('gridSize');
				  var iteration = parseInt(hdb.value)+1;
				  hdb.value = iteration;
				  var el=0;


				  var cellRight0 = row.insertCell(el);
				  var e0 = document.createElement('input');
				  e0.type = 'checkbox';
				  e0.name='delete';
				  e0.id='deleteRow'+iteration;
				  e0.value='0';
				  e0.setAttribute('tabindex', 1);
				  cellRight0.appendChild(e0);
				  cellRight0.appendChild(e0);			



				  
					
				
				  var cellRight22 = row.insertCell(++el);
				  var e22 = document.createElement('input');
				  e22.type = 'text';
				  e22.size = '3';
				  e22.name='<%=SR_NO%>';
				  e22.setAttribute('tabindex', 1);
				  e22.readOnly=true;
				  e22.value=iteration;
				  cellRight22.appendChild(e22);

				  var ee5 = document.createElement('input');
				  ee5.type = 'hidden';
				  ee5.name='<%=ITEM_ID%>';
				  ee5.id = 'idItem'+iteration;

				 

				  var ee3 = document.createElement('input');
				  ee3.type = 'hidden';
				  ee3.name='';
				  ee3.id = 'formula'+iteration;


				  var ee4 = document.createElement('input');
				  ee4.type = 'hidden';
				  ee4.name='';
				  ee4.id = 'conversionFactor'+iteration;


				  var ee45 = document.createElement('input');
				  ee45.type = 'hidden';
				  ee45.name='poDetailId';
				  ee45.id = 'poDetailId'+iteration;
				  ee45.value = '0';

				  var cellRight1 = row.insertCell(++el);
				  var e1 = document.createElement('input');
				  e1.type = 'text';
				  e1.name='<%=ITEM_CODE%>';
				  e1.id = 'codeItem'+iteration;
				  e1.size='8';
				  e1.onblur =function(){autocompleteBasedOnPvms(this.value,iteration)}; 
				  e1.setAttribute('tabindex', 1);
				  
				
				  cellRight1.appendChild(ee3);
				  cellRight1.appendChild(ee4);
				  cellRight1.appendChild(ee5); 
				  cellRight1.appendChild(e1);
				  cellRight1.appendChild(ee45);




				  var cellRight2 = row.insertCell(++el);
				  var e2 = document.createElement('input');
				  e2.type = 'text';
				  e2.name = 'nameItem'+iteration;
				  e2.id = 'nameItem' + iteration;
				  e2.size = '30';
				  e2.onblur = function(){if(fillSrNo(iteration) && fillSrNoForRowSize(iteration)){checkForPurchase(this.value, 'nameItem',iteration)}};
				  e2.setAttribute('tabindex', 1);

				 var newdiv = document.createElement('div');
			 	  newdiv.setAttribute('id', 'ac2update');
			 	 newdiv.style.display = 'none';
			 	  newdiv.className = "autocomplete";
				  cellRight2.appendChild(e2);
				  cellRight2.appendChild(newdiv);
				  new Ajax.Autocompleter('nameItem'+iteration,'ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=nameItem'+iteration});
					
				  
				  var cellRight3 = row.insertCell(++el);
				  var e3 = document.createElement('input');
				  e3.type = 'text';
				  e3.name='<%=AV%>';
				  e3.id = 'idAu'+iteration;
				  e3.setAttribute('tabindex', 1);
				  e3.size='5';
				   cellRight3.appendChild(e3);


				 


				   var cellRight4 = row.insertCell(++el);
				   var e4 = document.createElement('Select');
					e4.name='<%=BG%>';
					e4.id = 'idBg'+iteration;
					e4.className = 'auto';
					e4.setAttribute('tabindex', 1);
					e4.options[0] = new Option('B', 'B');
					e4.options[1] = new Option('G', 'G');
					e4.options[2] = new Option('O', 'O');
					e4.options[3] = new Option('S', 'S');
					e4.options[4] = new Option('L', 'L');
					e4.options[5] = new Option('X', 'X');
					e4.options[6] = new Option('T', 'T');
					e4.options[7] = new Option('R', 'R');
					e4.options[8] = new Option('M', 'M');
					
					cellRight4.appendChild(e4);



					var cellRight5 = row.insertCell(++el);
					  var e5 = document.createElement('Select');
					  e5.name = '<%=BRAND_ID%>';
					  e5.id = 'brandId' + iteration;
					  e5.className = 'small3';
					  e5.setAttribute('tabindex', 1);
					  e5.onchange= function(){getManufacturerNameByAjax(this.value,iteration)};
					  e5.options[0] = new Option('select brand', '');
					  cellRight5.appendChild(e5);


						var cellRight6 = row.insertCell(++el);
						  var e6 = document.createElement('Select');
						  e6.name = '<%=MANUFACTURER_ID%>';
						  e6.id = 'manufacturerId' + iteration;
						  e6.className = 'small3';
						  e6.setAttribute('tabindex', 1);
						  e6.options[0] = new Option('select manuf', '');
						  cellRight6.appendChild(e6);

						  var cellRight7 = row.insertCell(++el);
						  var e7 = document.createElement('input');
						  e7.type = 'text';
					      e7.name='';
					      e7.value='0';
						  e7.id = 'actualqtyin'+iteration;
						  e7.setAttribute('tabindex', 1);
						  e7.setAttribute('maxlength', 9);
						  e7.onblur=function(){gridCalculationLocalSupplyOrderAdd(iteration)}; 
						  e7.size='5';
						  cellRight7.appendChild(e7);

						  
						  var e8 = document.createElement('input');
						  e8.type = 'hidden';
					      e8.name='<%=ACTUAL_QTY %>';
						  e8.id = 'actualqty'+iteration;
						  e8.setAttribute('tabindex', 1);
						  e8.setAttribute('maxlength', 9);
						  e8.size='5';
						 
						  var ee20 = document.createElement('input');
							ee20.type = 'hidden';
							ee20.name='prescription_id';
							ee20.id = 'prescription_id'+iteration;
							ee20.value='0';


				var cellRight12 = row.insertCell(++el);
				var e12 = document.createElement('Select');
				e12.name = 'dipenseType';
				e12.id = 'dispenseType' + iteration;
				e12.className = 'small3';
				e12.setAttribute('tabindex', 1);
				e12.options[0] = new Option('select Dispen.', '0');
				cellRight12.appendChild(e12);

				

				var cellRight13 = row.insertCell(++el);
				var e13 = document.createElement('input');
				e13.type = 'text';
				e13.name='mdq';
				e13.id = 'mdq'+iteration;
				e13.size='7';
				e13.value='1';
				e13.onblur = function(){gridCalculationLocalSupplyOrderAdd(iteration)};
				cellRight13.appendChild(e8);
				cellRight13.appendChild(ee20);
				e13.setAttribute('tabindex', 2);
				cellRight13.appendChild(e13);
				

				  var cellRight9 = row.insertCell(++el);
				  var e9 = document.createElement('input');
				  e9.type = 'text';
			      e9.name='';
			      e9.value='0';
				  e9.id = 'quantityInVarTemp'+iteration;
				  e9.setAttribute('tabindex', 1);
				  e9.setAttribute('maxlength', 9);
				  e9.onblur=function(){gridCalculationLocalSupplyOrderAdd(iteration)}; 
				  e9.size='5';
				  cellRight9.appendChild(e9);

				  var e10 = document.createElement('input');
				  e10.type = 'hidden';
			      e10.name='<%=QUANTITY %>';
				  e10.id = 'quantityInVar'+iteration;
				  e10.setAttribute('tabindex', 1);
				  e10.setAttribute('maxlength', 9);
				  e10.onblur=function(){gridCalculationLocalSupplyOrderAdd(iteration)}; 
				  e10.size='5';
				  cellRight9.appendChild(e10);


				  

				var cellRight14 = row.insertCell(++el);
				var e14 = document.createElement('input');
				e14.type = 'text';
				e14.name='<%=MRP %>';
				e14.id = 'mrp'+iteration;
				e14.size='5';
				e14.value='0';
				e14.onblur = function(){gridCalculationLocalSupplyOrderAdd(iteration)};
				e14.setAttribute('tabindex', 1);
				cellRight14.appendChild(e14);

				var ee16 = document.createElement('input');
				ee16.type = 'hidden';
				ee16.name='<%=DISCOUNT_AMOUNT%>';
				ee16.id = 'discountAmount'+iteration;
				ee16.value='0';



				
				var cellRight16 = row.insertCell(++el);
				var e16 = document.createElement('input');
				e16.type = 'text';
				e16.name='<%=DISCOUNT_PERCENTAGE%>';
				e16.id = 'discountVarTemp'+iteration;
				e16.size='4';
				e16.value='0';
				e16.setAttribute('tabindex', 1);
				e16.onblur = function(){gridCalculationLocalSupplyOrderAdd(iteration)};
				cellRight16.appendChild(ee16);
				cellRight16.appendChild(e16);


				

				var ee17 = document.createElement('input');
				ee17.type = 'hidden';
				ee17.name='<%=TAX_AMOUNT%>';
				ee17.id = 'taxAmount'+iteration;
				ee17.value='0';

				var cellRight17 = row.insertCell(++el);
				var e17 = document.createElement('input');
				e17.type = 'text';
				e17.name='<%=TAX_PERCENT%>';
				e17.id = 'taxVarTemp'+iteration;
				e17.size='4';
				e17.value='0';
				e17.setAttribute('tabindex', 1);
				e17.onblur=function(){gridCalculationLocalSupplyOrderAdd(iteration)};
				cellRight17.appendChild(ee17);
				cellRight17.appendChild(e17);
				

				var cellRight18 = row.insertCell(++el);
				var e18 = document.createElement('input');
				e18.type = 'text';
				e18.name='<%=COST_PRICE%>';
				e18.id = 'costPrice'+iteration;
				e18.size='5';
				e18.value='0'
				e18.setAttribute('tabindex', 1);
				cellRight18.appendChild(e18);

				
				var e23 = document.createElement('input');
				e23.type = 'hidden';
				e23.name='<%=AMOUNT%>';
				e23.id = 'amountVar'+iteration;
				e23.size='8'
				e23.value='0'
				e23.setAttribute('tabindex', 1);
				


				var cellRight19 = row.insertCell(++el);
				var e19 = document.createElement('input');
				e19.type = 'text';
				e19.name='';
				e19.id = 'amountVarTemp'+iteration;
				e19.size='8'
				e19.value='0'
				e19.setAttribute('tabindex', 1);
				cellRight19.appendChild(e23);
				cellRight19.appendChild(e19);


				  var cellRight21 = row.insertCell(++el);
				  var e21 = document.createElement('input');
				  e21.type = 'button';
				  e21.name='remarks'+iteration;
				  e21.className = 'buttonAdd';
				  e21.setAttribute('tabindex', 1);
				  e21.onclick= function(){addRow('localSupply')};
				  cellRight21.appendChild(e21);

			

			}

		 function removeRow(idName)
		 {
			 var deletedIds = '';	
		     try {
		         var table = document.getElementById(idName);
		         var rowCount = table.rows.length;
		         var gridSize=document.getElementById('gridSize').value;
		         var rowSize=document.getElementById('noOfRows').value;
				
		     	for(var i=1; i<rowCount; i++) {
					var row = table.rows[i];
					var chkbox;
					var nameBox;
			     
			         
					if(row.cells[0].childNodes[1]==undefined){
						chkbox = row.cells[0].childNodes[0];
					    nameBox=row.cells[3].childNodes[0];
					}
				else{
							chkbox = row.cells[0].childNodes[1];
				    		nameBox=row.cells[3].childNodes[1];
					}
					if(chkbox.checked==undefined){
						chkbox = row.cells[0].childNodes[0];
					    nameBox=row.cells[3].childNodes[0];
						
						}

					if(null != chkbox && true == chkbox.checked) {
		            	 if(nameBox.value=='')
	                       {
	                    		document.getElementById('noOfRows').value=(parseInt(rowSize));
	                       }
		                   else
	                       {
			               	document.getElementById('noOfRows').value=(parseInt(rowSize))-1;
			               	rowSize=document.getElementById('noOfRows').value;
			               	if(deletedIds!=''){
			               		deletedIds += ",";
			               	}
			               	if( chkbox.value!=0)
			            	 	deletedIds += chkbox.value;
	                       }
						table.deleteRow(i);
					//	document.getElementById('gridSize').value=(parseInt(gridSize))-1; 
						rowCount--;
						i--;
						/**
						* Delete from DB
						*/
						deletePoDetails(deletedIds);
						
					}
					}
		     	  return true;
		        }catch(e)
		        {
		            alert(e);
		        }

		 }

		 function deletePoDetails(ids){
			  if(ids!=''){
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

					  xmlHttp.onreadystatechange=function()
					  {
						  if(xmlHttp.readyState==4){

							  var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
							  for (loop = 0; loop < items.childNodes.length; loop++) {
								  var item = items.childNodes[loop];
								  var message =  item.getElementsByTagName("message")[0];
								  if(message.childNodes[0]!=undefined){
									  alert(message.childNodes[0].nodeValue);
									
								  } 
							  }
						  }
					  }
					  xmlHttp.open("GET",'/hms/hms/purchaseOrder?method=deletePoDetails&deletedIds='+ids,true);
					  xmlHttp.setRequestHeader("Content-Type", "text/xml");
					  xmlHttp.send(null);
				  }
		  
		 }
		 
		 function selectPOID(val)
		 {
		// alert(val);
			 if(val != 0)
			 {
				submitProtoAjax1('purchaseGrid','/hms/hms/purchaseOrder?method=getSoDetailsForApproval&poId='+val);
			 }
		 }
		   
</script>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StoreSupplyOrderEntry"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreLoaninM"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
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
<script type="text/javascript">
function loanAdjustment(soId){
	 if(soId != 0){
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
		   	 //  var sli  = item.getElementsByTagName("SLIStatus")[0];
		       //   document.getElementById('adjust').style.display = 'none';
		              document.getElementById('soItem').style.display = 'inline';
		         // document.getElementById('loanInStatus').value = "No";
		   }
	      }
	    }

	   var url="/hms/hms/stores?method=findloanInItems&soId="+soId

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	   }

	  }
</script>

<script>
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
	</script>
<script language="javascript">





function calculationinLoanIn()
{
   	
   	for(rowVal=1;rowVal<=25;rowVal++)
		{
			if(document.getElementById('idItem'+rowVal).value.trim()!=0)
			{
   			var discount = parseFloat(0);
				var tax = parseFloat(0);
			
				//Calculation of Amount for the Current Row (rowVal)
				
				var quantity = isNaN(parseFloat(document.getElementById('quanRec'+rowVal).value))==true?"0":parseFloat(document.getElementById('quanRec'+rowVal).value);
				var freeQty = isNaN(parseFloat(document.getElementById('freeQty'+rowVal).value))==true?"0":parseFloat(document.getElementById('freeQty'+rowVal).value);
				var ratePerMdq = isNaN(parseFloat(document.getElementById('ratePerMdq'+rowVal).value))==true?"0":parseFloat(document.getElementById('ratePerMdq'+rowVal).value);
				var discount = isNaN(parseFloat(document.getElementById('discountVar'+rowVal).value))==true?"0":parseFloat(document.getElementById('discountVar'+rowVal).value);
				var tax = isNaN(parseFloat(document.getElementById('taxVar'+rowVal).value))==true?"0":parseFloat(document.getElementById('taxVar'+rowVal).value);

				var total = parseFloat(0);
				var disc= parseFloat(0);
				var amountAfterdiscount= parseFloat(0);
				var taxAmount = parseFloat(0);
				var netAmount= parseFloat(0);
	
				total = parseFloat(quantity)* (parseFloat(ratePerMdq) + parseFloat(tax));
				disc = total*(discount/100);
				amountAfterdiscount = total-disc;
				taxAmount = (amountAfterdiscount)*(tax/100)
				netAmount = amountAfterdiscount;
				 
				document.getElementById('amtVar'+rowVal).value=roundVal(netAmount,2);
				//document.getElementById('taxAmount'+rowVal).value=roundVal(taxAmount,2);
				document.getElementById('discountAmount'+rowVal).value=roundVal(disc,2);

				// Calculating converted Stock as Per Formula  & Conversion Login
				var formula = isNaN(parseFloat(document.getElementById('formula'+rowVal).value))==true?"0":parseFloat(document.getElementById('formula'+rowVal).value);
				var conversionFactor = isNaN(parseFloat(document.getElementById('conversionFactor'+rowVal).value))==true?"0":parseFloat(document.getElementById('conversionFactor'+rowVal).value);
				var mdq = isNaN(parseFloat(document.getElementById('mdq'+rowVal).value))==true?"0":parseFloat(document.getElementById('mdq'+rowVal).value);
				var convertedStock = parseFloat(0);
				quantity = parseFloat(quantity) + parseFloat(freeQty); 
				if (formula !=0 && conversionFactor != 0 && mdq != 0)
				{
					if (formula==1)
					{
						convertedStock = (parseFloat(quantity) * parseFloat(mdq)) / parseFloat(conversionFactor);
					}
					else if (formula==2)
					{
						convertedStock = parseFloat(quantity); 
					}
					document.getElementById('convertedStock'+rowVal).value = parseFloat(convertedStock);
				}

			}
		}
		
		
		var rowAmt = parseFloat(0);
		var convertedStock = parseFloat(0);
		var costPrice = parseFloat(0);
	

		//Calculate cost price for all items in the Grid
		for(i=1;i<=25;i++)
		{
		if(document.getElementById('idItem'+i).value.trim()!=0)
		{
		    rowAmt = isNaN(parseFloat(document.getElementById('amtVar'+i).value))==true?0:parseFloat(document.getElementById('amtVar'+i).value);
		 	document.getElementById('amtVar'+i).value = roundVal(rowAmt,2);
		 	convertedStock = isNaN(parseFloat(document.getElementById('convertedStock'+i).value))==true?"0":parseFloat(document.getElementById('convertedStock'+i).value);
		 	if (convertedStock > 0) 
		 		costPrice = parseFloat(rowAmt) / parseFloat(convertedStock);
		 	else
		 		costPrice = parseFloat(0);
		 	document.getElementById('costPrice'+i).value = roundVal(costPrice,3);
		}
		}


	//Calculate Total Loan In Amount 
	var tempNetValue = parseFloat(0);
	for(i=1;i<=25;i++)
	{
		if(document.getElementById('idItem'+i).value.trim()!=0)
		{
		 	var freeItem = document.getElementById('freeItem'+i).value;
			if (freeItem=='n') 
				tempNetValue=parseFloat(tempNetValue)+parseFloat(document.getElementById('amtVar'+i).value);
		}
	}
	document.getElementById('loanInValue').value=roundVal(tempNetValue,2);
}











function checkForLoanIn(val,a,inc)
{
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    
	    for(i=1;i<=25;i++)
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
	    
	    var poId = document.getElementById('poId').value;
		ajaxFunctionForAutoCompleteInLoanIn1('loanGrid','stores?method=fillItemsForLoanIn&requiredField=' + pvms + "&poId=" + poId , inc);
		
}

//---- For Loan In---------------------
function ajaxFunctionForAutoCompleteInLoanIn1(formName,action,rowVal) {
var po_id = document.getElementById('poId').value
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
    	
    	var brandId="brandId"+rowVal;
		obj =document.getElementById(brandId); 
		obj.length = 1;
		
		var manufacturerId ="manufacturerId"+rowVal;
		obj1 =document.getElementById(manufacturerId); 
		obj1.length = 1;
		
		var dispenseType ="dispenseType"+rowVal;
		
		obj2 = document.getElementById(dispenseType); 
	
			
    	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var name  = item.getElementsByTagName("name")[0];
	        var expiry  = item.getElementsByTagName("expiry")[0];
	        var brandLength  = item.getElementsByTagName("brands")[0];
	        var BrandGen  = item.getElementsByTagName("bg")[0];
	        var DispType = item.getElementsByTagName("dispType")[0];
	        if(po_id != ""){
	        var poRate  = item.getElementsByTagName("poRate")[0];
	        var poTax = item.getElementsByTagName("poTax")[0];
	        var poDiscount = item.getElementsByTagName("poDiscount")[0];
	        var poDispType = item.getElementsByTagName("poDispType")[0];
	        var poMdqValue = item.getElementsByTagName("poMdqValue")[0];
	        var poRatePerMdq = item.getElementsByTagName("poRatePerMdq")[0];
	        var poBrandId = item.getElementsByTagName("poBrandId")[0];
	       // alert("poBrandId1111111111111----"+poBrandId.childNodes[0].nodeValue);
	        var poManufacturerId = item.getElementsByTagName("poManufacturerId")[0];
	        var poFreeQty = item.getElementsByTagName("poFreeQty")[0];
	        var poFreeItem = item.getElementsByTagName("poFreeItem")[0];
	        }
	        var formula  = item.getElementsByTagName("formula")[0];
   		var conversionFactor  = item.getElementsByTagName("conversionFactor")[0];
	        
   		
	        
      	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
      	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
      	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
      	document.getElementById('BrandGen'+rowVal).value = BrandGen.childNodes[0].nodeValue
      	
      	document.getElementById('expiry'+rowVal).value = expiry.childNodes[0].nodeValue
      	document.getElementById('formula'+rowVal).value = formula.childNodes[0].nodeValue
			document.getElementById('conversionFactor'+rowVal).value = conversionFactor.childNodes[0].nodeValue
			
      	obj2.length=1;
      	obj2.options[obj2.length-1].value = DispType.childNodes[0].nodeValue;
      	obj2.options[obj2.length-1].text = DispType.childNodes[0].nodeValue;
      	
      	for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++)
      	{
      		var brand = brandLength.childNodes[innerLoop];
	        	var brandId  = brand.getElementsByTagName("brandId")[0];
	        	var brandName  = brand.getElementsByTagName("brandName")[0];
	        	var manufacturerId  = brand.getElementsByTagName("manufacturerId")[0];
	        	var manufacturerName = brand.getElementsByTagName("manufacturerName")[0];
	        	
	        	obj.length++;
				obj.options[obj.length-1].value=brandId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=brandName.childNodes[0].nodeValue;
				
				obj1.length++;
				obj1.options[obj1.length-1].value=manufacturerId.childNodes[0].nodeValue;
				obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;
      	}
      	
      	if(po_id != ""){
      	//document.getElementById('freeQty'+rowVal).value = poFreeQty.childNodes[0].nodeValue
      	document.getElementById('discountVar'+rowVal).value =poDiscount.childNodes[0].nodeValue
      	if(poTax.childNodes[0].nodeValue!="null")
      	{
      	document.getElementById('taxVar'+rowVal).value =poTax.childNodes[0].nodeValue
      	}
      	else
      	{
      		document.getElementById('taxVar'+rowVal).value=0;
         }
      	document.getElementById('mdq'+rowVal).value =poMdqValue.childNodes[0].nodeValue
      	if(poRatePerMdq.childNodes[0].nodeValue!="null")
      	{
      	document.getElementById('ratePerMdq'+rowVal).value =poRatePerMdq.childNodes[0].nodeValue
      	}
      	else
      	{
      		document.getElementById('ratePerMdq'+rowVal).value =0;
         }
      	}
      	
      	
      	var brandCombo = document.getElementById('brandId'+rowVal);
      	
      	//for(var i=0;i<brandCombo.length;i++)
      	//{
      		//if (brandCombo[i].value == poBrandId.childNodes[0].nodeValue)
      		//	brandCombo.selectedIndex = i;
      //}
      	
      	
      	var manufacturerCombo = document.getElementById('manufacturerId'+rowVal);
      	
      //	for(var i=0;i<manufacturerCombo.length;i++)
      //	{
      //		if (manufacturerCombo[i].value == poManufacturerId.childNodes[0].nodeValue)
      //			manufacturerCombo.selectedIndex = i;
      //	}
      	
      //	var freeItemCombo = document.getElementById('freeItem'+rowVal);
      	
      //	for(var i=0;i<freeItemCombo.length;i++)
      	//{
      	//	if (freeItemCombo[i].value == poFreeItem.childNodes[0].nodeValue)
      			//freeItemCombo.selectedIndex = i;
      	//}
      	
      	
    	} 
    }
  }
 	 var url=action
   
  xmlHttp.open("GET",url,true);
  xmlHttp.setRequestHeader("Content-Type", "text/xml");
  xmlHttp.send(null);
}

function autocompleteBasedOnPvms(val,inc)
{
		ajaxFunctionForAutoCompleteForLoanIn('loanGrid','stores?method=fillItemsCommon&pvmsNo=' +  val , inc);
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
        	document.getElementById('nameItem'+rowVal).value = name.childNodes[0].nodeValue + "[" + pvms.childNodes[0].nodeValue + "]"
      }
    }
  }
}
  
 </script>
<script type="text/javascript" language="javascript">
var itemsArray1=new Array();
 var numLinesAdded = 1;
  var brandArray = new Array();
  var tt;
   function fillValuesInGrn(inc)
  {
  		
  	 	var quanRec = "quanRec";
    	var taxVar = "taxVar";
    	var amtVar = "amtVar";
    	var unitRateVar = "unitRateVar";
    	var discountVar = "discountVar";
    	
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
  
    function checkForNext(){
  if(document.getElementById('noOfRows').value<10)
  {
  	alert("All rows are not filled.To continue press Submit ")
  	return false;
  }else{
  return true;
  }
  }
  
 
  function checkForSubmit(){
  var poId = document.getElementById('poId').value;
  var chal = document.getElementById('challanNo').value;
	  if(document.getElementById('noOfRows').value==0)
	  {
	    alert("There must be one detail row");
	     return false;
	  }else{
	    if(poId == "" && chal == ""){
	      alert("Please Enter the Value for etheir the challanNo. or So Number ");
	      return false;
	      }else{
	      return true;
	      }
	    }
	    return true;
	  }
  
   
function get_value(rowNo)
{
 var url="/hms/hms/stores?method=showMoreInfoLoanIn&rowNo="+rowNo + "&detailId=" + document.getElementById('poId').value;
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


//===for  new brand addition on screen

function get_valueForBrand()
{
 var url="/hms/hms/personnel?method=showBrandJsp";
   popwindow(url);
 }  

var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name',"height=700,width=1010,status=1");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();

}

function submitFormToDisableSubmitForLoanIn(formName,action,extraFunction,extraFunction2,extraFunction3){
	
	errorMsgDisableSubmit="";
	
			ob1 = true;
			ob2 = true;
			ob3 = true;
			obj = eval('document.'+formName);

			if(eval("window."+extraFunction))
		    	ob1 =  eval(extraFunction+"()")

				if(eval("window."+extraFunction2))
		        	ob2 = eval(extraFunction2+"()")

				if(eval("window."+extraFunction3))
		        	ob3 = eval(extraFunction3+"()")

				if(validateFieldsForDisableSubmit(formName)== true & ob1 & ob2 &ob3){
					
					if(document.getElementById('submitForDisable') != null){
						document.getElementById('submitForDisable').disabled=true
					}
		        	obj.action = action;
					obj.submit();
				 	return true;
				}else{
					
					if(errorMsgDisableSubmit != ""){
						alert("return false");
						alert(errorMsgDisableSubmit);
			       		return false;
			       	}
					obj.action = action;
					obj.submit();
			       	return true;
		    	}
		}



function getSupplierAndGrid(val){


	var supplierId = document.getElementById('supplier_id').value
    var url='/hms/hms/stores?method=getPoList&supplerId='+supplierId;
	submitProtoAjaxforIndent1('loanGrid','/hms/hms/stores?method=responseGridForChallnEntry&poId='+val);
		//ajaxFunctionForgetSupplierAndGrid('loanGrid','stores?method=getPoList&supplerId=' +  supplierId);
}


 function populateLoanInGrid() {
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
      var formName = "loanGrid";
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	    obj = eval('document.'+formName+'.poId');
	        obj.length = 1;
	        obj.options[obj.length-1].value="";
	        obj.options[obj.length-1].text="Select So No.";
	        
	        
        	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];

	   	 	
		   	 var proPending=item.getElementsByTagName("amtForProB")[0];
			   

				var po=item.getElementsByTagName("po")[0] ;
				document.getElementById('amt_For_ProB').value=proPending.childNodes[0].nodeValue;
				
				for(loop2 = 0 ; loop2<po.childNodes.length ; loop2++)
				{
				var po1= po.childNodes[loop2] ;
		     	var poId  = po1.getElementsByTagName("poId")[0];
	         	var poNumber = po1.getElementsByTagName("poNumber")[0];
	    	  	obj.length++;
		      	obj.options[obj.length-1].value=poId.childNodes[0].nodeValue
			  	obj.options[obj.length-1].text=poNumber.childNodes[0].nodeValue		
				}
				}

			
			  
      }
    }
     var supplierId = document.getElementById('supplier_id').value
    var url='/hms/hms/stores?method=getPoList&supplerId='+supplierId;
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }
 function submitProtoAjaxforIndent1(formName,action){
		errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
 	   	 var url=action+"&"+getNameAndData(formName)
     	
     	new Ajax.Updater('gridDiv',url,
			   {asynchronous:true, evalScripts:true }); 
	       	return true;
}

 
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
function getsoitems(){
	  var so = document.getElementById('poId').value;
	  var proAmount=parseFloat(document.getElementById('amt_For_ProB').value);
	  if(proAmount>45000){
		  alert("You are reaching the maximum limit amount Please make proforma")
		  }
	 // var loanIn = document.getElementById('loanInStatus').value;
	   	currPage=1;
		numOfRows=10;
		   if(so != 0 && so != ""){
		  	   var url="/hms/hms/stores?method=getSoItemDetails&currPage="+currPage+"&numOfRows=8&sos="+document.getElementById('sourceCombo').value+"&po_id="+so+"&pageType=add";
				newwindow=window.open(url,'name','top=0, left=5, height=675,width=1010,status=1');
			} else {
		 	 	alert("Please select SO No ..!!!");
		 	}
	  }
</script>
<script type="text/javascript">
function jsGetGrid(){
	 // alert("i am in so grid");

 if((document.getElementById('item_id').value).length > 0){
     var loanStatus = document.getElementById('adloanIn').value;
    document.getElementById('temp').value = document.getElementById('item_id').value
    document.getElementById('item_id').value = "";
    var po_id = document.getElementById('poId').value;
    var sos = document.getElementById('sourceCombo').value;
   submitProtoAjaxforGrid('loanGrid','/hms/hms/stores?method=responseSOGridList&sos='+sos+'&po_id='+po_id+'&items='+document.getElementById('temp').value+'&loanInStatus='+loanStatus);
  }
 }
</script>

<script language="javascript">
		function calculateTotalCrvAmount(inc)
			{

			// var discount = parseFloat(0);
			// var tax = parseFloat(0);
			// var totalCarryForward = 0;
			 var grandTotal = 0;

			 var hdb = document.getElementById('hdb').value;
			 //alert("hdb :"+hdb);
			// if (!isNaN(document.getElementById('totalCarryForward').value))
			//	totalCarryForward = parseFloat(document.getElementById('totalCarryForward').value);

			//	for(var i=1 ;i<= inc;i++){
			// var quantity = isNaN(parseFloat(document.getElementById('quantity'+i).value))==true?"0":parseFloat(document.getElementById('quantity'+i).value);
			// var price = isNaN(parseFloat(document.getElementById('price'+i).value))==true?"0":parseFloat(document.getElementById('price'+i).value);
//			 var discount = isNaN(parseFloat(document.getElementById('discount'+i).value))==true?"0":parseFloat(document.getElementById('discount'+i).value);
//			 var tax = isNaN(parseFloat(document.getElementById('tax'+i).value))==true?"0":parseFloat(document.getElementById('tax'+i).value);

			// var total = parseFloat(0);
			 //var disc= parseFloat(0);
			// var amountAfterdiscount= parseFloat(0);
			//// var taxAmount = parseFloat(0);
			 var netAmount= parseFloat(0);
			 // total = parseFloat(quantity)*parseFloat(price);
			// disc = total*(discount/100);
			// amountAfterdiscount = total-disc;
			// taxAmount = (amountAfterdiscount)*(tax/100)
			// netAmount = amountAfterdiscount + taxAmount;

			// document.getElementById('amount'+i).value=roundVal(netAmount,2);

			//}
			 for(var r =1;r<=inc;r++){
				// var totalAmt =document.getElementById('amtVar'+r).value;
				 var totalAmt= isNaN(parseFloat(document.getElementById('amtVar'+r).value))==true?"0":parseFloat(document.getElementById('amtVar'+r).value);
				// alert("r value >+"+r);
				// alert("totalAmt >"+totalAmt);
			 grandTotal = grandTotal +totalAmt;
			// alert("grandTotal >"+grandTotal);
			 document.getElementById('total_amount').value = roundVal(grandTotal,2);
				}
}
</script>



<script type="text/javascript">
function addRow(idName,rowLen) {
	
	

	  var tbl =  document.getElementById(idName);
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('gridSize');
	  hdb.value=iteration
	  var el=0;

	  var cellRight0 = row.insertCell(el);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '2';
	  e0.name='<%=SR_NO%>';
	  e0.setAttribute('tabindex', 1);
	  e0.readOnly=true;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var ee5 = document.createElement('input');
	  ee5.type = 'hidden';
	  ee5.name='<%=ITEM_ID%>';
	  ee5.id = 'idItem'+iteration;
	  ee5.value=document.getElementById('idItem'+rowLen).value;
	  
	  var ee1 = document.createElement('input');
	  ee1.type = 'hidden';
	  ee1.name='<%=DETAIL_ID%>';
	  ee1.id = 'hdb'+iteration;
	  ee1.value=iteration;

	  var ee2 = document.createElement('input');
	  ee2.type = 'hidden';
	  ee2.name='';
	  ee2.id = 'expiry'+iteration;

	  var ee3 = document.createElement('input');
	  ee3.type = 'hidden';
	  ee3.name='';
	  ee3.id = 'formula'+iteration;


	  var ee4 = document.createElement('input');
	  ee4.type = 'hidden';
	  ee4.name='';
	  ee4.id = 'conversionFactor'+iteration;


	  var ee6 = document.createElement('input');
	  ee6.type = 'hidden';
	  ee6.name='loanInItem';
	  ee6.id = 'loanInItem'+iteration;
	  ee6.value='No'

	  var cellRight1 = row.insertCell(++el);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	 
	  
	  e1.name='<%=ITEM_CODE%>';
	  e1.id = 'codeItem'+iteration;
	  e1.size='8';
	  e1.setAttribute('tabindex', 1);
	  e1.value=document.getElementById('codeItem'+rowLen).value;
	 
	  cellRight1.appendChild(ee1);
	  cellRight1.appendChild(ee2);
	  cellRight1.appendChild(ee3);
	  cellRight1.appendChild(ee4);
	  cellRight1.appendChild(ee5);
	  cellRight1.appendChild(ee6);
	  cellRight1.appendChild(e1);



	 

	  var cellRight2 = row.insertCell(++el);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'nameItem';
	  e2.id = 'nameItem' + iteration;
	  e2.size = '50';
	  e2.value=document.getElementById('nameItem'+rowLen).value;
	  e2.setAttribute('tabindex', 1);
	  //e2.onblur=function(){if(fillSrNo(iteration)){checkForGrn(document.getElementById('codeItem'+iteration).value,'nameItem',iteration)}};

	  
	



	 var newdiv = document.createElement('div');
 	  newdiv.setAttribute('id', 'ac2update'+iteration);
 	 newdiv.style.display = 'none';
 	  newdiv.className = "autocomplete";
	  cellRight2.appendChild(e2);
	  cellRight2.appendChild(newdiv);
	  new Ajax.Autocompleter('nameItem'+iteration,'ac2update','stores?method=getItemListForGrnByAutocomplete&sourceOfSupply=a',{parameters:'requiredField=nameItem'});


	  var cellRight3 = row.insertCell(++el);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='<%=AV%>';
	  e3.id = 'idAu'+iteration;
	  e3.value=document.getElementById('idAu'+rowLen).value;
	  e3.setAttribute('tabindex', 1);

	 // e3.size='8';
	   cellRight3.appendChild(e3);


	   var cellRight4 = row.insertCell(++el);
	   var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name='barCodeNo';
		  e4.id = 'barCodeId'+iteration;
		  e4.setAttribute('tabindex', 1);
		
		 // e3.size='8';
		   cellRight4.appendChild(e4);


	   var cellRight5 = row.insertCell(++el);
	   var e5 = document.createElement('input');
		e5.type = 'text';
		e5.name='BRAND_GEN';
		e5.id = 'BrandGen'+iteration;
		
		e5.setAttribute('tabindex', 1);

		// e3.size='8';
		 cellRight5.appendChild(e5);


		var cellRight6 = row.insertCell(++el);
		  var e6 = document.createElement('Select');
		  e6.name = '<%=BRAND_ID%>';
		  e6.id = 'brandId' + iteration;
		  e6.setAttribute('tabindex', 1);
		  var brandVale =document.getElementById("brandId"+rowLen);
          var optionText = brandVale.options[0].text;
		  var optionValue=brandVale.options[0].value;
		  e6.options[0] = new Option(optionText,optionValue);
		  cellRight6.appendChild(e6);


			var cellRight7 = row.insertCell(++el);
			  var e7 = document.createElement('Select');
			  e7.name = '<%=MANUFACTURER_ID%>';
			  e7.id = 'manufacturerId' + iteration;
			  e7.setAttribute('tabindex', 1);
			  
			  var manuFacture =document.getElementById("manufacturerId"+rowLen);
	          var optionText = manuFacture.options[0].text;
			  var optionValue=manuFacture.options[0].value;
			  e7.options[0] = new Option(optionText,optionValue);

			  cellRight7.appendChild(e7);

			  
			  var cellRight8 = row.insertCell(++el);
			   var e8 = document.createElement('input');
				e8.type = 'text';
				e8.name='<%=BATCH_NO %>';
				e8.id = 'batchNo'+iteration;
				e8.setAttribute('tabindex', 1);
				e8.setAttribute('maxlength', 25);
				// e3.size='8';
				 cellRight8.appendChild(e8);



	  var cellRight9 = row.insertCell(++el);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.name='<%=MANUFACTURING_DATE%>';
	  e9.id = 'manufacturingDate'+iteration;
	  e9.size='8';
	  cellRight9.appendChild(e9);


     var cellRight99 = row.insertCell(++el);
     var eImg = document.createElement('img');
   	eImg.src = '/hms/jsp/images/cal.gif';
   eImg.name = '' ;
   eImg.id = '';
   eImg.WIDTH = '16';
   eImg.HEIGHT = '16';
   //eImg.id = 'billDateId'+iteration;
   eImg.onclick = function(event){
		  setdate('',document.getElementById('<%="manufacturingDate"%>'+iteration),event) };
   cellRight99.appendChild(eImg);

	var cellRight110 = row.insertCell(++el);
	var e110 = document.createElement('input');
	e110.type = 'text';
	e110.name='<%=EXPIRY_DATE%>';
	e110.id = 'expiryDate'+iteration;
	e110.size='8';
	cellRight110.appendChild(e110);



	 var cellRight999 = row.insertCell(++el);
     var eImg1 = document.createElement('img');
   	eImg1.src = '/hms/jsp/images/cal.gif';
   eImg1.name = '' ;
   eImg1.id = '';
   eImg1.WIDTH = '16';
   eImg1.HEIGHT = '16';
   //eImg.id = 'billDateId'+iteration;
   eImg1.onclick = function(event){
		  setdate('',document.getElementById('<%="expiryDate"%>'+iteration),event) };
   cellRight999.appendChild(eImg1);

	var cellRight11 = row.insertCell(++el);
	var e11 = document.createElement('input');
	e11.type = 'text';
	e11.name='<%=QUANTITY_RECEIVED%>';
	e11.id = 'quanRec'+iteration;
	e11.size='8';
	e11.value='0'
	e11.setAttribute('tabindex', 1);
	cellRight11.appendChild(e11);


	var cellRight12 = row.insertCell(++el);
	var e12 = document.createElement('Select');
	e12.name = 'dispenseType';
	e12.id = 'dispenseType' + iteration;
	e12.setAttribute('tabindex', 1);
	var dispensValue =document.getElementById("dispenseType"+rowLen);
    var optionText = dispensValue.options[0].text;
	var optionValue=dispensValue.options[0].value;
	e12.options[0] = new Option(optionText,optionValue);
	cellRight12.appendChild(e12);

	var cellRight13 = row.insertCell(++el);
	var e13 = document.createElement('input');
	e13.type = 'text';
	e13.name='mdq';
	e13.id = 'mdq'+iteration;
	e13.size='20';
	e13.value='1'
	e13.onblur = function(){calculationInCRV()};
	e13.onfocus=function(){calculateTotalCrvAmount(iteration)};

	e13.setAttribute('tabindex', 2);
	cellRight13.appendChild(e13);



	var cellRight15 = row.insertCell(++el);
	var e15 = document.createElement('input');
	e15.type = 'text';
	e15.name='ratePerMdq';
	e15.id = 'ratePerMdq'+iteration;
	e15.size='8';
	e15.value=document.getElementById('ratePerMdq'+rowLen).value;
	e15.setAttribute('tabindex', 1);

	e15.onblur = function(){calculationInCRV()};
	e15.onfocus=function(){calculateTotalCrvAmount(iteration)};
	cellRight15.appendChild(e15);


	var cellRight14 = row.insertCell(++el);
	var e14 = document.createElement('input');
	e14.type = 'text';
	e14.name='<%=MRP %>';
	e14.id = 'mrp'+iteration;
	e14.size='8';
	e14.value='';
	e14.onblur = function(){calculationInCRV()};
	e14.onfocus=function(){calculateTotalCrvAmount(iteration)};
	e14.setAttribute('tabindex', 1);
	cellRight14.appendChild(e14);

	var ee16 = document.createElement('input');
	ee16.type = 'hidden';
	ee16.name='discountAmount';
	ee16.id = 'discountAmount'+iteration;
	ee16.value='';


	var cellRight16 = row.insertCell(++el);
	var e16 = document.createElement('input');
	e16.type = 'text';
	e16.name='<%=DISCOUNT_PERCENTAGE%>';
	e16.id = 'discountVar'+iteration;
	e16.size='5';
	e16.value=document.getElementById('discountVar'+rowLen).value;
	e16.setAttribute('tabindex', 1);
	e16.onblur = function(){calculationInCRV()};
	e16.onfocus=function(){calculateTotalCrvAmount(iteration)};
	cellRight16.appendChild(ee16);
	cellRight16.appendChild(e16);

	var ee17 = document.createElement('input');
	ee17.type = 'hidden';
	ee17.name='taxAmount';
	ee17.id = 'taxAmount'+iteration;
	ee17.value='';

	var cellRight17 = row.insertCell(++el);
	var e17 = document.createElement('input');
	e17.type = 'text';
	e17.name='<%=TAX_PERCENT%>';
	e17.id = 'taxVar'+iteration;
	e17.value=document.getElementById('taxVar'+rowLen).value;
	e17.setAttribute('tabindex', 1);
	e17.onblur = function(){calculationInCRV()};
	e17.onfocus=function(){calculateTotalCrvAmount(iteration)};
	cellRight17.appendChild(ee17);
	cellRight17.appendChild(e17);

	var cellRight18 = row.insertCell(++el);
	var e18 = document.createElement('input');
	e18.type = 'text';
	e18.name='<%=COST_PRICE%>';
	e18.id = 'costPrice'+iteration;
	e18.value='0'
	e18.onblur = function(){calculationInCRV()};
	e18.onfocus=function(){calculateTotalCrvAmount(iteration)};
	e18.setAttribute('tabindex', 1);
	cellRight18.appendChild(e18);

	var cellRight19 = row.insertCell(++el);
	var e19 = document.createElement('input');
	e19.type = 'text';
	e19.name='<%=AMOUNT%>';
	e19.id = 'amtVar'+iteration;
	e19.size='8'
	e19.value='0'
	e19.onblur = function(){calculationInCRV()};
	e19.onfocus=function(){calculateTotalCrvAmount(iteration)};
	e19.setAttribute('tabindex', 1);
	cellRight19.appendChild(e19);

	var ee20 = document.createElement('input');
	ee20.type = 'hidden';
	ee20.name='PreId';
	ee20.id = 'PreId'+iteration;
	ee20.value=document.getElementById("PreId"+rowLen).value;

	var cellRight20 = row.insertCell(++el);
	var e20 = document.createElement('input');
	e20.type = 'text';
	e20.name='reasonForDemand';
	e20.value=''
	e20.setAttribute('tabindex', 1);
	e20.onblur = function(){calculationInCRV()};
	cellRight20.appendChild(ee20);
	cellRight20.appendChild(e20);


	  var cellRight21 = row.insertCell(++el);
	  var e21 = document.createElement('input');
	  e21.type = 'button';
	  e21.name='remarks'+iteration;
	  e21.className = 'buttonAdd';
	  e21.setAttribute('tabindex', 1);
	  e21.onclick= function(){addRow('grnDetails',rowLen)};
	  cellRight21.appendChild(e21);

	  var cellRight22 = row.insertCell(++el);
	  var e22 = document.createElement('input');
	  e22.type = 'button';
	  e22.name='remarks'+iteration;
	  e22.setAttribute('tabindex', 1);
	  e22.className = 'buttonDel';
	  e22.onclick= function(){removeRow('grnDetails',iteration)};
	  cellRight22.appendChild(e22);

	

}
function removeRow(idName,rowLen)
{

    try {
        var table = document.getElementById(idName);
        var rowCount = table.rows.length;
        var gridSize=document.getElementById('gridSize').value;
  
    	//for(var i=rowCount-1; i>0; i++)
        //{
        	//var row = table.rows[i];
            if(gridSize>1)
            {
            	table.deleteRow(rowLen);
              	document.getElementById('gridSize').value=(parseInt(gridSize))-1;
                return true;
             }
            else
            {
            	alert("At Least One Row  Should Be There");
                return false;
             }
              // rowCount--;
                //i--;


      // }
       }catch(e)
       	{
           alert(e);
       }

}

</script>



<%
		Map map = new HashMap();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		int loanInId = 0;
		if (map.get("loanInId") != null) {
			loanInId = Integer.parseInt("" + map.get("loanInId"));
		}
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		if (map.get("supplierList") != null) {
			supplierList = (ArrayList) map.get("supplierList");
			session.setAttribute("supplierList", supplierList);
		} else if (session.getAttribute("supplierList") != null) {
			supplierList = (ArrayList) session.getAttribute("supplierList");

		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		if (map.get("itemList") != null) {
			itemList = (ArrayList) map.get("itemList");
			session.setAttribute("itemList", itemList);
		} else if (session.getAttribute("itemList") != null) {
			itemList = (ArrayList) session.getAttribute("itemList");

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
		StoreLoaninM storeloanObj = null;
		List<StoreIndentM> indentList = new ArrayList<StoreIndentM>();
		if (map.get("indentList") != null) {
			indentList = (ArrayList) map.get("indentList");
			session.setAttribute("indentList", indentList);
		} else if (session.getAttribute("indentList") != null) {
			indentList = (ArrayList) session.getAttribute("indentList");

		}
		
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		if (map.get("manufacturerList") != null) {
			manufacturerList = (ArrayList) map.get("manufacturerList");
			session.setAttribute("manufacturerList", manufacturerList);
		} else if (session.getAttribute("manufacturerList") != null) {
			manufacturerList = (ArrayList) session.getAttribute("manufacturerList");

		}
	
		List<StoreSupplyOrderEntry> supplyOrderList = new ArrayList<StoreSupplyOrderEntry>();
		if (map.get("supplyOrderList") != null) {
			supplyOrderList = (ArrayList) map.get("supplyOrderList");
			session.setAttribute("supplyOrderList", supplyOrderList);
		} else if (session.getAttribute("supplyOrderList") != null) {
			supplyOrderList = (ArrayList) session.getAttribute("supplyOrderList");

		}
		List<StoreLoaninM> searchLoanInList = new ArrayList<StoreLoaninM>();
		if (map.get("searchLoanInList") != null)
			searchLoanInList = (List) map.get("searchLoanInList");
		String message = "";
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		if(map.get("brandList") != null){
			brandList = (ArrayList) map.get("brandList");
			session.setAttribute("brandList",brandList);
		}else if(session.getAttribute("brandList") != null){
			brandList = (ArrayList)session.getAttribute("brandList");
			
		}
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		List<StoreLoaninM> loaninList= new ArrayList<StoreLoaninM>();
		if (map.get("loaninList") != null)
			loaninList = (List) map.get("loaninList");
		
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		int pageNo = 1;
		if (map.get("pageNo") != null) {
			pageNo = Integer.parseInt("" + map.get("pageNo"));
			
		}
		String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");

		}
		Box box=HMSUtil.getBox(request);
		if(map.get("box")!=null){
			box=(Box)map.get("box");
		}
		String date="";
		String time="";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 date = (String)utilMap.get("currentDate");	 
		 time = (String)utilMap.get("currentTime");
		String max="";
		if(map.get("max") != null){
			max = (String) map.get("max");
		}
		includedJsp = (String) map.get("includedJsp");
	%>

<script>
var nameArray=new Array();
var codeArray=new Array();
</script>


<div id="searchBlock" style="display:none;">
<form name="departmentIndent" method="post">

<div class="clear"></div>
<h6>SEARCH</h6>
<div class="Block">
<form name="" method="">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> 
<input type="hidden" name="do" value="process" /> 
<input type="hidden" name="searchthread" value="1" /> 
<input type="hidden" name="showposts" value="1" /> 
<input type="hidden" name="searchthreadid" value="85875" />  
<label >From Date</label>
<input type="text"	name="<%= FROM_DATE %>" MAXLENGTH="30" class="date"	tabindex=1 />
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	 onClick="setdate('<%=currentDate%>',document.departmentIndent.<%= FROM_DATE%>,event)" />
<label >To Date</label>
<input type="text" name="<%= TO_DATE %>" class="date" MAXLENGTH="30"  tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"  onClick="setdate('<%=currentDate%>',document.departmentIndent.<%= TO_DATE%>,event)" />
<label >Loan In No.</label>
<select name="<%=LOANIN_NO%>">
			 <%
			 	for (StoreLoaninM storeLoaninM : searchLoanInList) {
			 %>
				<option value=<%=storeLoaninM.getLoaninNo()%>><%=storeLoaninM.getLoaninNo()%></option>
	  		 <%
				}
			 %>
	   </select>
	   
	  <div class="Clear"></div>
<input type="button" class="button" value="SEARCH"	onClick="submitForm('departmentIndent','stores?method=searchLoanin');" />	
<input type="button" name="sss" class="button" value="CLOSE" onClick="closeSearchBlock();" />
			
</form>
</div>
</form>
</div>





<form name="loanGrid" method="post">
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" />
<input type="hidden" name="deptId" value="<%=deptId%>" />
<div class="titleBg"><h2>CHALLAN ENTRY</h2></div>
<div class="Block">
<label >Source of Supply <span>*</span> </label>
<label class="value">Local Purchase</label>
<input type="hidden"  name="<%= SOURCE_OF_SUPPLY %>"  id="sourceCombo" value="l" readonly="readonly" tabindex=1 />

<%-- <label >Entry No.</label> --%>

<% if(storeloanObj != null){%>
<input type="hidden"	 name="<%= LOANIN_NO %>"	value="<%=storeloanObj.getLoaninNo()%>" readonly="readonly"	validate="LoanIn Number ,String,yes" tabindex=1 maxlength="12" />
<%}else{ %>
<input type="hidden"  name="<%= LOANIN_NO %>"		value="<%=max %>" readonly="readonly"	validate="LoanIn Number ,String,yes" tabindex=1 maxlength="12" />
<%} %>

<label >Vendor</label> <select name="<%= SUPPLIER_ID%>" id="supplier_id"
			validate="Supplier,string,yes" tabindex=1
			onchange="populateLoanInGrid();">
			<option value="">Select</option>
			<%
			for (MasStoreSupplier masStoreSupplier : supplierList) {
				if (storeloanObj != null) {
					if (storeloanObj.getSupplier().getId().equals(
							masStoreSupplier.getId())) {
		%>

			<option value=<%=masStoreSupplier.getId()%> selected="selected"
				readonly><%=masStoreSupplier.getSupplierName()%></option>
			<%
	}
		} else {
%>


			<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%></option>
			<%
	}
	}
%>
		</select>

		
		<label >So No. </label> 
		<select name="<%=INDENT_ID%>" id="poId"  onchange="loanAdjustment(this.value);"  validate="Po,string,No" >
		<option>-Select So No.-</option>
		</select>
	
	<input type="hidden" name="item_id" id="item_id" value="" />
	<input type="hidden" name="temp" id="temp" value="" /> <input type="hidden"
	name="adloanIn" id="adloanIn" value="No" />
	<input type="hidden" name="loanInStatus" id="loanInStatus" value="" />
	<div class="clear"></div>
	<label >Amount Pending For Proforma B Entry</label>
		<input  type="text" name="amtForProB" id="amt_For_ProB"/> 
		
		
<!--<div id="adjust" style="display: none;">

<input type="button"
	name="loanInAd" id="loanInAd" align="right" class="button"
	onblur="jsGetGrid();" value="Adjust LoanIn.." onclick="adjustment();" />
</div>
--><div id="soItem" style="display: none;">
<input type="button" name="details" id="details" align="right" class="buttonBig2" onblur="" value="Import Supplier Order" onclick="getsoitems();" />
<input type="hidden" name="details" id="details" align="right" class="button" onblur="" value="Import Medcine" onclick="submitForm('grnGrid','stores?method=showLPImportGrnJsp');" />
</div>
		
		
		
		
		
<div class="Clear"></div>

	<label >So Date</label>
 	<input type="text" name="<%=LOANIN_DATE%>"	value="<%=currentDate %>"  class="date" readonly="readonly" MAXLENGTH="30" />

	 <a href="javascript:setdate('<%=currentDate%>',document.loanGrid.<%=LOANIN_DATE%>,true)">
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" /> 
		</a>	
		
		
		<label >Date Received</label>
 	<input type="text" name="receivedDate"	value="<%=currentDate %>"  class="date" readonly="readonly" MAXLENGTH="30" />

	 <a href="javascript:setdate('<%=currentDate%>',document.loanGrid.'receivedDate',true)">
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" /> 
		</a>	
		
		

		<label > Challan No.<span>*</span></label> 
		<%if(storeloanObj != null){ %> 
		<input type="text" 	name="<%=CHALLAN_NO %>" id="challanNo" class="date"	value="<%=storeloanObj.getChallanNo() %>" validate="Challan No, String ,No" MAXLENGTH="20"/  > 
		<%}else{ %> 
		<input type="text"  name="<%= CHALLAN_NO %>" value="" class="date" id="challanNo" validate="Challan No, String ,No" tabindex=1 	MAXLENGTH="20" /> 
		<%} %>
			

		<div class="Clear"></div>	
		
<label >Challan Date</label>
<input	type="text" class="date" name="<%=CHALLAN_DATE%>" value="<%=currentDate %>"	 MAXLENGTH="30" />

<img  src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"  validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.loanGrid.<%=CHALLAN_DATE%>,event)" />
<label> <span>*</span> Unpacked-Checked	By</label>
<select name="<%=EMPLOYEE_ID %>" validate="Employee,string,yes"	tabindex=1>
			<option value="">Select</option>
			<%
			for (MasEmployee masEmployee : employeeList) {
		%>

<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()+"("+masEmployee.getRank().getRankName()+")" %></option>			<%
		  	}
		  %>
		</select>
<%--<label>Remarks </label> <%if(storeloanObj != null){ %>
<textarea value="<%=storeloanObj.getRemarks()%>" name="<%=REMARKS %>"	validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	 maxlength="45" />
</textarea>
<%}else{ %>
<textarea value="" name="<%=REMARKS %>"	validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)"	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	 maxlength="45" />
</textarea>
<%} %>
 --%>
</div>

<div class="Clear"></div>

<div id="gridDiv"></div>
<!-- <input	type="button" id="addbutton" name="Add" type="submit" value="Add"	class="button" onClick="submitForm('createGrn','stores?method=showLoanInJsp');">
<input type="button" name="Modify"  value="Modify" class="button" onclick="submitForm('createGrn','stores?method=ShowListOFLoanInForUpdate');">
<input	type="button" name="Reset" type="submit" value="Reset"	class="button">
<input	type="button" name="Delete" type="submit" value="Delete" class="button">
<input	type="button" name="print" type="submit" class="button"	value="Print" onClick=""> -->
<div class="Clear"></div>
<!--<label > Total Amount </label>
<input type="text" name="loanInValue" id="loanInValue" value=""	 MAXLENGTH="15" tabindex="2" />
--><div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<input type="button" name="sss" align="right" id="submitForDisable" class="button" value="Submit"	onclick="submitForm('loanGrid','stores?method=submitLoanIn');" />
<%--<input type="button" name="sss" align="right" class="button"	value="Brand" onclick="get_valueForBrand();" /> --%>
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
<input type="hidden" size="2" value="0" name="noOfRows" id="noOfRows" />
<input type="hidden" name="<%=LOANIN_ID %>" value="<%=loanInId%>"	id="hdb" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label>Changed Date:</label>
<label class="value"><%=date%></label>

<label>Changed Time:</label>
<label class="value"><%=time%></label>
</div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input	type="hidden" name="totalAmount" id="totalAmount" value="">
<input	type="hidden" value="" id="totalAmountTemp">

<script	type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	
	
function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}

function closeSearchBlock()
{

document.getElementById('searchBlock').style.display = 'none';
}
	
	
	</script>
	<input type="hidden" name="rows" id="rr" value="1" /> <br />

</form>


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
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*10)+1;
    	var end=((pageNo-1)*10)+10;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    for(i=1+inc;i<=10+inc;i++){
	    if(pvms !="")
	    if(document.getElementById('codeItem'+i).value==pvms){
	    if(document.getElementById('codeItem'+inc).value!=pvms){
	    	alert("Item already selected...!")
	    	document.getElementById('nameItem'+inc).value=""
	    	return false;
	    	}
	    }}
	    ajaxFunctionForAutoCompleteInLPOGeneral('purchaseGrid','stores?method=fillItemsForLpo&pvmsNo=' +  pvms , inc);
		//ajaxFunctionForAutoCompleteForPurchase('purchaseGrid','stores?method=fillItemsCommon&pvmsNo=' +  pvms , inc);
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
		obj1 =document.getElementById(manufacturerId); 
		obj1.length = 1;
      	for (loop = 0; loop < items.childNodes.length; loop++) 
      	{
      
	   	    var item = items.childNodes[loop];
	   	    
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var formula = item.getElementsByTagName("formula")[0];
	        var conversionFactor = item.getElementsByTagName("conversionFactor")[0];
	       // var name  = item.getElementsByTagName("name")[0];
	     //   var dispType = item.getElementsByTagName("dispType")[0];
	        var brandLength  = item.getElementsByTagName("brands")[0];
	        
        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
        	document.getElementById('formula'+rowVal).value = formula.childNodes[0].nodeValue
        	document.getElementById('conversionFactor'+rowVal).value = conversionFactor.childNodes[0].nodeValue
        	//document.getElementById('dispenseType'+rowVal).value = dispType.childNodes[0].nodeValue 
         //   var dispenseType ="dispenseType"+rowVal;
         //   obj2 = document.getElementById(dispenseType);
            
         //  	obj2.length=1;
			//obj2.options[obj2.length-1].value = dispType.childNodes[0].nodeValue;
			//obj2.options[obj2.length-1].text  = dispType.childNodes[0].nodeValue;
        	
        	for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++)
        	{
        		var brand = brandLength.childNodes[innerLoop];
	        	var brandId  = brand.getElementsByTagName("brandId")[0];
	        	var brandName  = brand.getElementsByTagName("brandName")[0];
	        	var manufacturerId = brand.getElementsByTagName("manufacturerId")[0];
	        	var manufacturerName = brand.getElementsByTagName("manufacturerName")[0];
	        	
	        	obj.length++;
				obj.options[obj.length-1].value=brandId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=brandName.childNodes[0].nodeValue;
				
				obj1.length++;
				obj1.options[obj1.length-1].value=manufacturerId.childNodes[0].nodeValue;
				obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;
        	}
      }
    }
  }
}

function autocompleteBasedOnPvms(val,inc)
{
 		ajaxFunctionForAutoCompleteForLP('purchaseGrid','stores?method=fillItemsCommon&pvmsNo=' +  val , inc);
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
   		rowVal=rowVal%10
   		if(rowVal==0){
   			rowVal=10
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
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

function removeRow(argIndex,idName){
	         var table=document.getElementById(idName);
	         var tblRows  = table.getElementsByTagName("tr");
	         var check=0;
	         var grandTot=0;
	         
	         var temp1 = false;
	         
	    var net_amount = parseFloat(0);     
  if (purchaseGrid.<%="deleteItem"%>)
	{
			if (purchaseGrid.<%="deleteItem"%>.length)
			{
			var check = true;
				 for(var i = 0; i < purchaseGrid.<%="deleteItem"%>.length; i++)
			 	 {
				 	 if (purchaseGrid.<%="deleteItem"%>[i].checked == true){
				 	  	 var amount = parseFloat(0);
					  	 var cal = purchaseGrid.<%=AMOUNT%>[i].value 
					  	 net_amount = net_amount + parseFloat(cal)
					        check = false;
	        		 }
	        	 }
			 	  if(check){
        		 	   net_amount = parseFloat(0);
				  }
			}
			else
			{ 
				if (purchaseGrid.<%="deleteItem"%>.checked == true){
				 var amount = parseFloat(0);
				 var cal = purchaseGrid.<%=AMOUNT%>.value 
				 net_amount = net_amount + parseFloat(cal)
				}else{
		          net_amount = parseFloat(0);
				}
			}
   } 
	         
	         for(i=tblRows.length-1;i>0;i--)
	        {         
	         var tblCtrl =  tblRows[i].getElementsByTagName("input"); 
	               for(j=0;j<tblCtrl.length;j++)
	               {
	                  if(tblCtrl[j].type == 'checkbox')
	                   {    
	                    if(tblCtrl [j].checked){
	                              check=check+1;
	                       temp1 = true;       
	                     }         
	                   }
	               }
	        }
	        
	         if(tblRows.length-1==check){
	         	alert("Can not delete all rows")
	         	return false;
	         }
	         
	          if(temp1){
	         if(confirm("Are You Sure,You want Delete ? ")){
			 }else{
				return false;
			 } 
	         }
			var temp =true;
	        for(i=tblRows.length-1;i>0;i--)
	        {         
	         var tblCtrl =  tblRows[i].getElementsByTagName("input"); 
	               for(j=0;j<tblCtrl.length;j++)
	               {
	                  if(tblCtrl[j].type == 'checkbox')
	                   {    
	                    if(tblCtrl [j].checked){
	                        document.getElementById(idName).deleteRow(i);
	                         temp = false;     
	                    }         
	                   }
	               }
	        }
	        if(temp){
	        alert("Atleast should select one row");
	        }

   grandTot = parseFloat(document.getElementById('total_amount').value)
   grandTot = grandTot - net_amount ; 
   document.getElementById('total_amount').value = grandTot;
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
	   var existingtot = parseFloat(document.getElementById('total_amount').value);
	  	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var remain = items.childNodes[loop];
	   	    
	       var rem  = remain.getElementsByTagName("rem")[0];
	      document.getElementById('remain').value = roundVal(existingtot + parseFloat(rem.childNodes[0].nodeValue),2);
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
     msg = "Are You sure, You want to Save ?";
  // }
		if(confirm(msg))
			return true;
		else
			return false;
}




function getlpitems(){
	 // var so = document.getElementById('indentCombo').value;
	 // var loanIn = document.getElementById('loanInStatus').value;
	 var soNo=document.getElementById('soNo').value;
	 var requestType="importLp";
	 currPage=1;
	numOfRows=10;
	/*
	* Code for remove metachar Code By Anamika
	*/
  	if(soNo!= ""){
		if(! validateMetaCharacters(soNo)){
			 var url="/hms/hms/stores?method=getLPItemDetails&currPage="+currPage+"&soNo="+soNo+"&requestType="+requestType+"&pageType=add";
				newwindow=window.open(url,'name','top=0, left=5, height=600,width=1010,status=1');
		}else{
		    return false;
		}
	 }
 }

</script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	String previousPage = "no";
	int pageNo = 1;
	int poId = 0;
	String max = "";
	BigDecimal netAmount = null;
	Box box = null;
	String DeliveryDate = null;
	String QuotationDate = null;
	
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<StorePoHeader> poNumberList = new ArrayList<StorePoHeader>();
	List<MasStorePoDeliveryTerms> poDeliveryDescList = new ArrayList<MasStorePoDeliveryTerms>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	String FileNo = ""; 
	String msg = "";
	BigDecimal remain = new BigDecimal("0");
	String totr = "";
	String requestType="";

	if (map.get("box") != null) {
		box = (Box) map.get("box");
	
		DeliveryDate = box.get(DELIVERY_DATE);
		QuotationDate = box.get(QUOTATION_DATE);
		FileNo = box.get(FILE_NO);
		
	}
	
	
	if(map.get("poId")!=null){
		poId = Integer.parseInt(""+map.get("poId"));
	}
	
	if(map.get("previousPage")!=null){
		previousPage=(""+map.get("previousPage"));
	}
	
	if(map.get("msg")!=null){
		msg=(""+map.get("msg"));
	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	if (map.get("poNumberList") != null) {
		poNumberList = (List<StorePoHeader>)map.get("poNumberList");
	}
	if(map.get("supplierList")!=null)
		supplierList = (List<MasStoreSupplier>) map.get("supplierList");
	
	if(map.get("remain") != null){
		remain = (BigDecimal)map.get("remain");	
	}
	if(map.get("requestType")!=null){
		requestType=(String)map.get("requestType");
	}
	if(map.get("itemList")!=null){
		itemList = (List<MasStoreItem>) map.get("itemList");
	}
	System.out.println("this is lp jsp"+itemList.size());
	totr = new  DecimalFormat("0.##").format(Double.valueOf(remain.toString()));
	
	if(map.get("max") != null){
		max = (String) map.get("max");
	}
%>
<html>
<script type="text/javascript">
function load()
{
alert("Page is loaded");
}
</script>
<body onload="load();">
<div class="titleBg">
<h2>Supply Order Entry</h2>
</div>
<form name="poMain" method="post">
<div class="clear"></div>
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<div class="searchBlock" id="threadsearch_menu" style="display: none">
<form name="searchPanel" method="post" >
<div class="clear"></div>
	
	<label>From Date</label>

<input	type="text" name="<%= FROM_DATE %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date"  tabindex="1"	onClick="setdate('<%=currentDate%>',document.searchPanel.<%=FROM_DATE%>,event)" />

<label>To	Date</label>
<input	type="text" name="<%= TO_DATE %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" tabindex="1"	onClick="setdate('<%=currentDate%>',document.searchPanel.<%=TO_DATE%>,event)" />
<input	type="hidden" name="<%=GRN_NO%>" value="" tabindex=1 MAXLENGTH="100" id="<%=GRN_NO%>" />
<div id="ac3update"	style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=GRN_NO%>','ac3update','stores?method=getGrnNoListForAutoComplete',{parameters:'requiredField=<%=GRN_NO%>'});
			</script>
		<div class="clear"></div>
		 <label>SO.No.</span></label>
		 <select name="<%=PO_ID%>">
			<option value="0">Select</option>
			<%	for(StorePoHeader obj: poNumberList){%>
				<option value="<%=obj.getId() %>"><%=obj.getPoNumber() %></option>
			<%} %>
		</select>
	
		 <label>Supplier Name</label>	
		<select	name="<%= SUPPLIER_ID %>" id="supplierId" validate="Vendor Name,String,no">
			<option value="0">--Select--</option>
<%
			for (MasStoreSupplier masStoreSupplier :supplierList ) {
%>
			<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%></option>
<%
			}
%>
	</select>
<input type="image" class="button" value="" onClick="submitForm('poMain','purchaseOrder?method=searchPO');" />			 
</form>
</div>
<form name="purchaseGrid" method="post" O>
<div id="testDiv" size="height:500px;">
	<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo"/>
	<%
	List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();
	StorePoHeader poHeaderObj = null;
	
	if(map.get("poHeaderList") != null){
		poHeaderList = (List)map.get("poHeaderList");
	}
	if(poHeaderList.size() > 0){
		poHeaderObj = (StorePoHeader)poHeaderList.get(0);
		netAmount = poHeaderObj.getNetAmount();
	}
		
	%>
	<!-- -
 <div id="contentHolder">
 
	<input type="button" class="button" value="Budget Status" onclick="window.open('/hms/hms/purchaseOrder?method=showBudgetStatus','new','left=200,top=100,width=425,height=400')" />
	
	<input type="button" class="button" value="Approval Authority" onclick="window.open('/hms/hms/purchaseOrder?method=showApprovalAuthority&poId='+purchaseGrid.<%=PO_ID %>.value,'new','left=200,top=100,width=525,height=450')" />
 </div>	
	 -->
<br /><br />

<div class="Block">
<label><span>*</span>SO No.</label>
	<% if(poHeaderObj != null){%>
<input	type="text" name="<%= PO_NO %>" value="<%=poHeaderObj.getPoNumber()%>" readonly="readonly" validate="S.O. Number ,String,yes" tabindex=1  id="so_id"/>
<%	}else{%>
<input	type="text"  name="<%= PO_NO %>" value="<%=max %>" readonly="readonly" validate="S.O. Number ,String,yes" tabindex=1  id="soNo"/> 
<%}%>
<label><span>*</span> SO Date </label>
<input type="text" name="<%=PO_DATE%>" id="soDate" onblur="getCurSOAmount();" value="<%=currentDate %>" class="" readonly="readonly" style="border: 1px solid #7f9db7;" validate="S.O. Date,dateOfAdmission,yes"  MAXLENGTH="30"  />
<img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"  validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.purchaseGrid.<%=PO_DATE%>,event)" />
<label class="auto"><span>*</span> Vendor Name</label>
<select	name="<%= SUPPLIER_ID %>" id="VendorId" validate="Vendor Name,String,yes" onblur="getCurSOAmount();" tabindex=1>
		<option value="">Select</option>
<%
	for (MasStoreSupplier masStoreSupplier :supplierList ) {
		if(poHeaderObj != null){
		 	if(poHeaderObj.getSupplier().getId().equals(masStoreSupplier.getId())){	
%>		
<option value=<%=masStoreSupplier.getId()%> selected="selected" readonly><%=masStoreSupplier.getSupplierName()%></option>
<%      	}
		 	}else{ %>

%>	
	<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%></option>
<%
	}}
%>
	</select> 
<IMG SRC="/hms/jsp/images/search.gif" WIDTH="16" HEIGHT="16" onClick="javascript:openPopupWindowForSupplier();"
	title="Click here to Search Vendor Name">
<div class="clear"></div>
<label><span>*</span> Delivery Date </label>
<%if(poHeaderObj != null)
{%>
<input type="text" name="<%=DELIVERY_DATE%>" value="<%=poHeaderObj.getDeliveryDate()==null?"":HMSUtil.convertDateToStringWithoutTime(poHeaderObj.getDeliveryDate())%>" readonly="readonly" validate="Delivery Date,deliveryDate,yes"  MAXLENGTH="30" class="date"  id="delDate"/>
<%}else{%>
<input type="text" name="<%=DELIVERY_DATE%>" value="" readonly="readonly" style="border: 1px solid #7f9db7;" validate="Delivery Date,deliveryDate,yes"  MAXLENGTH="30" class="date" id="delDate"/>
<%}%>
 <img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.purchaseGrid.<%=DELIVERY_DATE%>,event)" />
      <label>Remarks</label>
	<%if(poHeaderObj != null){ %>
	<textarea value="<%=poHeaderObj.getRemarks()%>" readOnly name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200"/>
	<%=poHeaderObj.getRemarks()%></textarea> 
	<%}else{ %>
	<textarea value="" name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200"/></textarea> 

	<%} %>
	<label>Reference</label>
	<input	type="text"  name="references"  validate="references,String,yes" tabindex=1 /> 
	<!--<label>Signing Authority</label>
	<%if(poHeaderObj != null){ %>
	<textarea value="<%=poHeaderObj.getSigningAuthority()%>" readOnly name="<%=LPO_SIGNING_AUTHORITY %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" maxlength="200"/><%=poHeaderObj.getSigningAuthority()%></textarea> 
	<%}else{ %>
	<textarea value="" name="<%=LPO_SIGNING_AUTHORITY %>" validate="Signing Authority ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200"/></textarea> 
	<%} %>
	
	-->
	<div class="clear"></div>
	<label>Category</label>
	<input	type="text"  name="category"   validate="category ,String,yes" tabindex=1 />
	<label>Contact/Tell No.</label>
	<input	type="text"  name="telephoneNo"   validate="telephoneNo ,String,yes" tabindex=1 />
	<label>Code Head</label>
	<input	type="text"  name="codehead"   validate="codehead ,String,yes" tabindex=1 />
	
	
	 <!--<label>Approval of CFA/IFA vide</label>
	<textarea value="" name="<%="approval" %>" validate="approval of CFA/IFA vide ,String,no" tabindex=1 cols="71" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="198" class="auto" /></textarea>
	
	-->
</div>  
	<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	
		<input type="hidden" name="rows" id="rr" value="1"/>
	<input type="hidden" name="rows" id="rr" value="1"/>
	<input type="button" class="button" value="Save & Next"  onclick="if(checkForNext10() && checkForLocalPurchaseGrid() && checkSaveRem()){submitForm('purchaseGrid','purchaseOrder?method=submitPurchaseOrder&buttonFlag=next');}" align="right" />
    <input type="button" name="sss" align="right" class="button" value="Submit" onclick="if(checkForSubmit() && checkSaveRem()){submitForm('purchaseGrid','purchaseOrder?method=submitPurchaseOrder');}"/>
    <input type="button" class="buttonBig" value="IMPORT PENDING MEDCINE"  onclick="getlpitems();"/>
    <input type="hidden" class="button" value="Add"/>
    <input type="hidden" class="button" value="Delete"/>
    <input type="hidden" class="button" value="Print"/>
    <input type="hidden" class="buttonBig" value="Export To CRV"/>
	<div class="clear"></div>
	<div class="division"></div>
<!-- -
<div id=biglabel>Payment Terms</div> 

<%if(poHeaderObj != null){ %>

	<textarea  value="<%=poHeaderObj.getPayTerms()%>" name="<%=PAY_TERMS %>" readOnly id="<%=PAY_TERMS %>" validate="Payment Terms ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" style="width: 500px;" maxlength="80"/><%=poHeaderObj.getPayTerms()%></textarea>
	<%}else{ %>
	<textarea value="" name="<%=PAY_TERMS %>" id="<%=PAY_TERMS %>" validate="Payment Terms ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" style="width: 500px;" maxlength="80"/></textarea>
	<%} %>
	<a href="#" onclick="window.open('/hms/hms/purchaseOrder?method=showPaymentTerms','new','left=200,top=100,width=625,height=550')">Select</a>
    <br/>
	<div id=biglabel>Delivery Terms</div>

	<%if(poHeaderObj != null){ %>
	<textarea value="<%= poHeaderObj.getDeliveryTerms()%>" id="<%=DELIVERY_TERMS %>" readOnly name="<%=DELIVERY_TERMS %>" validate="Delivery Terms ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" style="width: 500px;" maxlength="80"/><%= poHeaderObj.getDeliveryTerms()%></textarea> 
	<%}else{ %>
	<textarea value="" name="<%=DELIVERY_TERMS %>" id="<%=DELIVERY_TERMS %>" validate="Delivery Terms ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" style="width: 500px;" maxlength="80"/></textarea>
	<%} %>

<a href="#" onclick="window.open('/hms/hms/purchaseOrder?method=showDeliveryTerms','new','left=200,top=100,width=625,height=550')">Select</a>
<br />
<div id=biglabel>Remarks</div>
	<%if(poHeaderObj != null){ %>
	<textarea value="<%=poHeaderObj.getRemarks()%>" readOnly name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" style="width: 500px;" maxlength="200"/><%=poHeaderObj.getRemarks()%></textarea> 
	<%}else{ %>
	<textarea value="" name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" style="width: 500px;" maxlength="200"/></textarea> 

	<%} %>
 <br />
 <div id=biglabel>Signing Authority</div>
	<%if(poHeaderObj != null){ %>
	<textarea value="<%=poHeaderObj.getSigningAuthority()%>" readOnly name="<%=LPO_SIGNING_AUTHORITY %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" style="width: 500px;" maxlength="200"/><%=poHeaderObj.getSigningAuthority()%></textarea> 
	<%}else{ %>
	<textarea value="" name="<%=LPO_SIGNING_AUTHORITY %>" validate="Signing Authority ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" style="width: 500px;" maxlength="200"/></textarea> 
	<%} %>
 <br/>
 <div id=biglabel>approval of CFA/IFA vide</div>
	<textarea value="" name="<%="approval" %>" validate="approval of CFA/IFA vide ,String,no" tabindex=1 style="width: 500px;" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="198"/></textarea> 
 <br/>	
-->


 

	
	<!-- -
    <input type="button" name="sss1" align="right" class="button" value="PVMS/NIV" onclick="openItemPopup();"/> -->


  
	</div>
	<div class="clear paddingTop15"></div>
		<input type="hidden" size="2"	value="0"  name="noOfRows" id="noOfRows" />
		<input type="hidden" name="<%=PO_ID %>" value="<%=poId %>" id="poId" />
 
	
  
	  
	  
	  
	  <div class="cmntable">
	  	<table align="center" width="100%" id="localSupply" colspan="7"  class="grid_header" border="0" cellpadding="0" cellspacing="0">
		<thead>
		<tr>
		<!-- -
          <th width="5%"></th> -->
	      <th width="5%">SR No</th>
	      <th width="13%">PVMS No</th>
	      <th width="10%">Nomenclature</th>
	      <th width="13%">A/U</th>
	       <th width="13%">Brand</th>
	      <th width="13%">Manufacturer</th>
	       <!-- -  <th width="13%"><label valign="left" class="smalllabel">Actual quantity</label></th>
	      <th width="13%"><label valign="left" class="smalllabel">Free Qty</label></th>-->
	     <!-- -  <th width="9%"><label valign="left" class="smalllabel">Dispen.Type</label></th>
		  <th width="9%"><label valign="left" class="smalllabel">MDQ</label></th>-->
		  <th width="13%">Quantity Demanded</th>
		<!-- -  <th width="9%"><label valign="left" class="smalllabel">Rate Per MDQ</label></th> 
		  <th width="9%"><label valign="left" class="smalllabel">Total Rate for OQ</label></th>
		  <th width="9%"><label valign="left" class="smalllabel">ExciseDuty for OQ</label></th>
		  <th width="13%"><label valign="left" class="smalllabel">Unit Rate</label></th>-->
	      <th width="6%">MRP</th>
	      <th width="13%">Discount(%)</th>
	        <!--<th width="6%"><label valign="left" class="smalllabel">Tax for OQ</label></th>
	    <th width="6%"><label valign="left" class="smalllabel">Other Taxes(in Rs.)</label></th> -->
	      <th width="13%">Total Amount</th>
	      <!-- -<th width="13%"><label valign="left" class="smalllabel">Free Item</label></th> -->
      
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
    	String quantityInVar="quantityInVar";
    	String taxVar="taxVar";
    	String unitRateVar="unitRateVar";
    	String amountVar = "amountVar";
    	String discountVar="discountVar";
    	
    	String quantityInVarTemp="quantityInVarTemp";
    	String taxVarTemp="taxVarTemp";
    	String unitRateVarTemp="unitRateVarTemp";
    	String amountVarTemp = "amountVarTemp";
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
    	
    	String totRateOq = "totRateOq";
    	String exciseDuty = "exciseDuty";
    	String taxOq = "taxOq"; 
        	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";
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
    	
	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
    	
    	if(!requestType.equals("forLPItem")){ 
    		for(int inc=1+temp;inc<=10+temp;inc++){
  
     		
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idAu=idAu2+(""+inc);
     		
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
    %>
   <tr>
     <!-- - 
      <td width="5%">
    
      <input type="checkbox" id="deleteItem<%=inc%>" class="checkbox" name="deleteItem" value="" />
       
      </td> -->
      <td width="3%"><input type="text" size="2" value="<%=temp+inc%>"  name="<%=SR_NO%>"
			readonly="readonly" />
			<input type="hidden" size="2" value="0" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem%>" />
       <input type="hidden" value="" class="smcaption" name="" id="<%=formula%>" />
	   <input type="hidden" value="" class="smcaption" name="" id="<%=conversionFactor%>" />
			</td>
      <td width="10%">
	     <input type="text" class="medcaption" name="<%=ITEM_CODE %>" tabindex="1" id="<%=codeItem%>" onblur="autocompleteBasedOnPvms(this.value,'<%=inc %>');" validate="PVMS No,String,no" size="5"/>
      </td>
      
		<td width="17%">
      	<input type="text" value=""	id="<%=nameItem%>"  onblur="if(fillSrNo('<%=inc %>')){checkForPurchase(this.value, '<%=nameItem%>','<%=inc %>');}"  name="<%=nameItem%>" tabindex="1" size="30" />
			<div id="ac2update" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=<%=nameItem%>&poId='+document.getElementById('poId').value });
			</script>
		</td> 
     
      <td width="10%">
      <input type="text" value="" class="smcaption" readonly="readonly" name="<%=AV%>" id="<%=idAu%>" tabindex="1" validate="A/U ,String,no" size="5"/>
      </td>
      
      
      <td width="10%">
      <select name="<%=BRAND_ID%>" id=<%=brandId%> tabindex="1" validate="Brand,int,no">
      <option value="">select brand</option>
      </select>
      </td>
      
      <td width="10%">
      <select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId%> tabindex="1" validate="Manufacturer,int,no">
      <option value="">select manuf</option>
      </select></td>

      <td width="10%">
      <input type="text" value="0" class="medcaption" name="" id="<%=quantityInVarTemp %>" validate="Quantity,float,no" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" tabindex="1" maxlength="9" size="12"/>
      <input type="hidden" value="0" class="medcaption" name="<%=QUANTITY %>" id="<%=quantityInVar%>"/>
      </td>
      <!-- -
      <td width="10%">
      <input type="text"  class="medcaption" name="ratePerMdq" value="0" id="<%=ratePerMdq%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" validate="Rate per MDQ,float,no" onblur="calculateUnitRateinLocalSupplyOrder(<%=inc%>);" tabindex="1" maxlength="16"/>
      </td> 
      
      <td width="10%">
      <input type="text"  class="medcaption" name="totRateOq"  value="0" id="<%=totRateOq%>"  validate="totRateOq,float,no"  tabindex="1" maxlength="15"/>
      </td>

       <td width="10%">
      <input type="text"  class="medcaption" name="exciseDuty" value="0" id="<%=exciseDuty%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" validate="exciseDuty,float,no"  tabindex="1" maxlength="15"/>
      </td>-->
      
      
      <td width="10%">
      <input type="text" class="medcaption" value="0" name="mrp"  id="<%=mrp%>"  onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" validate="Tax,float,no" maxlength="15" tabindex="1" size="5"/>
      </td>
       <td width="3%">
      <input type="text" class="medcaption" value="0" name="<%=DISCOUNT_PERCENTAGE%>"  id="<%=discountVarTemp%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);"  validate="Discount,float,no" maxlength="6" tabindex="1" size="5"/>
      <input type="hidden" class="medcaption" value="0" name="<%=DISCOUNT_AMOUNT%>" id="<%=discountAmount%>"/>
      </td>
      <!--
      <td width="10%">
      <input type="text" class="medcaption" value="0" name="<%=TAX_PERCENT %>"  id="<%=taxVarTemp%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" validate="Tax,float,no" maxlength="15" tabindex="1"/>
      <input type="hidden" class="medcaption" value="0" name="taxOq"  id="<%=taxOq%>"  validate="taxOq,float,no" maxlength="15" tabindex="1"/>
      <input type="hidden" class="medcaption" value="0" name="<%=SALES_TAX_AMOUNT%>" id="<%=taxAmount%>"/>
      --></td>
      <!--
      <td width="10%">
      <input type="text" class="medcaption" value="0" name="otherTaxes"  id="<%=otherTaxes%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" validate="Tax,float,no" maxlength="25" tabindex="1"/>
      </td> -->
       
      <td width="3%">
      <input type="text" class="medcaption" value="0" name="" id="<%=amountVarTemp%>" readonly="readonly" validate="Amount,float,no"  tabindex="1" size="12"/>
      <input type="hidden" class="medcaption" value="0" name="<%=AMOUNT%>"  id="<%=amountVar%>"/>
      </td>
      <!-- -
      <td width="10%">
      <select name="<%=FREE_ITEM %>" id="<%=freeItem %>"  tabindex="1" onChange="gridCalculationLocalSupplyOrderAdd(<%=inc%>);">
	  <option value="n">No</option>
	  <option value="y">Yes</option>
      </select>
      </td>
       -->
       </tr>
   <%
     	 }   
    		}else{
    			System.out.println("this is req"+requestType);
    			for(int inc=1+temp;inc<=10+temp;inc++){
    			  
         		
         		idItem=idItem2+(""+inc);
         		codeItem=codeItem2+(""+inc);
         		nameItem=nameItem2+(""+inc);
         		idAu=idAu2+(""+inc);
         		
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
        %>
       <tr>
         <!-- - 
          <td width="5%">
        
          <input type="checkbox" id="deleteItem<%=inc%>" class="checkbox" name="deleteItem" value="" />
           
          </td> -->
          <td width="3%"><input type="text" size="2" value="<%=temp+inc%>"  name="<%=SR_NO%>"
    			readonly="readonly" />
    			<input type="hidden" size="2" value="0" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem%>" />
           <input type="hidden" value="" class="smcaption" name="" id="<%=formula%>" />
    	   <input type="hidden" value="" class="smcaption" name="" id="<%=conversionFactor%>" />
    			</td>
          <td width="10%">
    	     <input type="text" class="medcaption" name="<%=ITEM_CODE %>" tabindex="1" id="<%=codeItem%>" onblur="autocompleteBasedOnPvms(this.value,'<%=inc %>');" validate="PVMS No,String,no" size="5"/>
          </td>
          
    		<td width="17%">
          	<input type="text" value=""	id="<%=nameItem%>"  onblur="if(fillSrNo('<%=inc %>')){checkForPurchase(this.value, '<%=nameItem%>','<%=inc %>');}"  name="<%=nameItem%>" tabindex="1" size="30" />
    			<div id="ac2update" style="display:none;" class="autocomplete"></div>
    			<script type="text/javascript" language="javascript" charset="utf-8">
    			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=<%=nameItem%>&poId='+document.getElementById('poId').value });
    			</script>
    		</td> 
         
          <td width="10%">
          <input type="text" value="" class="smcaption" readonly="readonly" name="<%=AV%>" id="<%=idAu%>" tabindex="1" validate="A/U ,String,no" size="5"/>
          </td>
          
          
          <td width="10%">
          <select name="<%=BRAND_ID%>" id=<%=brandId%> tabindex="1" validate="Brand,int,no">
          <option value="">select brand</option>
          </select>
          </td>
          
          <td width="10%">
          <select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId%> tabindex="1" validate="Manufacturer,int,no">
          <option value="">select manuf</option>
          </select>
          </td>

          <td width="10%">
          <input type="text" value="0" class="medcaption" name="" id="<%=quantityInVarTemp %>" validate="Quantity,float,no" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" tabindex="1" maxlength="9" size="12"/>
          <input type="hidden" value="0" class="medcaption" name="<%=QUANTITY %>" id="<%=quantityInVar%>"/>
          </td>
          <!-- -
          <td width="10%">
          <input type="text"  class="medcaption" name="ratePerMdq" value="0" id="<%=ratePerMdq%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" validate="Rate per MDQ,float,no" onblur="calculateUnitRateinLocalSupplyOrder(<%=inc%>);" tabindex="1" maxlength="16"/>
          </td> 
          
          <td width="10%">
          <input type="text"  class="medcaption" name="totRateOq"  value="0" id="<%=totRateOq%>"  validate="totRateOq,float,no"  tabindex="1" maxlength="15"/>
          </td>

           <td width="10%">
          <input type="text"  class="medcaption" name="exciseDuty" value="0" id="<%=exciseDuty%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" validate="exciseDuty,float,no"  tabindex="1" maxlength="15"/>
          </td>-->
          
          
          <td width="10%">
          <input type="text" class="medcaption" value="100" name="mrp"  id="<%=mrp%>"  onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" validate="Tax,float,no" maxlength="15" tabindex="1" size="5"/>
          </td>
           <td width="3%">
          <input type="text" class="medcaption" value="0" name="<%=DISCOUNT_PERCENTAGE%>"  id="<%=discountVarTemp%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);"  validate="Discount,float,no" maxlength="6" tabindex="1" size="5"/>
          <input type="hidden" class="medcaption" value="0" name="<%=DISCOUNT_AMOUNT%>" id="<%=discountAmount%>"/>
          </td>
          <!--
          <td width="10%">
          <input type="text" class="medcaption" value="0" name="<%=TAX_PERCENT %>"  id="<%=taxVarTemp%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" validate="Tax,float,no" maxlength="15" tabindex="1"/>
          <input type="hidden" class="medcaption" value="0" name="taxOq"  id="<%=taxOq%>"  validate="taxOq,float,no" maxlength="15" tabindex="1"/>
          <input type="hidden" class="medcaption" value="0" name="<%=SALES_TAX_AMOUNT%>" id="<%=taxAmount%>"/>
          --></td>
          <!--
          <td width="10%">
          <input type="text" class="medcaption" value="0" name="otherTaxes"  id="<%=otherTaxes%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" validate="Tax,float,no" maxlength="25" tabindex="1"/>
          </td> -->
           
          <td width="3%">
          <input type="text" class="medcaption" value="0" name="" id="<%=amountVarTemp%>" readonly="readonly" validate="Amount,float,no"  tabindex="1" size="12"/>
          <input type="hidden" class="medcaption" value="0" name="<%=AMOUNT%>"  id="<%=amountVar%>"/>
          </td>
          <!-- -
          <td width="10%">
          <select name="<%=FREE_ITEM %>" id="<%=freeItem %>"  tabindex="1" onChange="gridCalculationLocalSupplyOrderAdd(<%=inc%>);">
    	  <option value="n">No</option>
    	  <option value="y">Yes</option>
          </select>
          </td>
           -->
           </tr>
       <%
         	 } 
    			
    		}%>
	</tbody>
</table>
</div>
	<!-- -
	<label>Total Amount:</label>
	
	<%if(netAmount != null){ %>
	<input type="text" name="<%=TOTAL_AMOUNT %>" value="<%=netAmount %>" id="total_amount" validate="Total Amount,float,yes" readonly="readonly">
	<input type="hidden" value="<%=netAmount %>" id="totalCarryForward" >
	<%}else{ %>
	<input type="text" name="<%=TOTAL_AMOUNT %>" value="0" id="total_amount"  validate="Total Amount,float,yes" readonly="readonly">
	<input type="hidden" value="0" id="totalCarryForward" >
	<%} %>
 -->

	
	</div>
	<br />
	
	</form>
	<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>

</form>
</body>
</html>
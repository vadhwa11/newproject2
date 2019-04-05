<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * update_Local_Purchase.jsp  
 * Purpose of the JSP -  This is for Update Local Purchase.
 * @author  Dipali
 * Create Date: 
 * Revision Date:      
 * Revision By:  
 * @version 1.7
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="org.apache.poi.util.SystemOutLogger"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
   	
   	var pageNo=parseInt(document.getElementById('noOfRows').value);
   	rowVal=rowVal%10
   	if(rowVal==0){
   		rowVal=10
   	 	}
   	if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
   	
   	document.getElementById('noOfRows').value=rowVal
	}
	for(i=0;i<itemsArray1.length;i++){
		if(itemsArray1[i][0]==idVal){
			document.getElementById(idItem).value=itemsArray1[i][0]
			document.getElementById(nameItem).value=itemsArray1[i][2]
			document.getElementById(idAu).value=itemsArray1[i][3]
		
		}
	}
	
  }

function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/purchaseOrder?method=printLocalSupplyOrder";
  obj.submit();
}
  function checkForNext(){
  if(document.getElementById('noOfRows').value < 10)
  {
  	alert("All rows are not filled.To continue press Submit ")
  	return false;
  }else{
  return true;
  }
  }
  
  function checkForSubmit(){
  if(document.getElementById('noOfRows').value==0)
  {alert("There must be one detail row");
  return false;
  }else{
  return true;
  }
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
		    document.getElementById('idBg'+rowVal).value=bgId.childNodes[0].nodeValue

        	
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
				
				obj1.length++;
				//obj1.options[obj1.length-1].value=manufacturerId.childNodes[0].nodeValue;
				//obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;
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
function get_value_for_purchase(rowNo,detailId)
{
 var url="/hms/hms/purchaseOrder?method=showMoreInfoPurchaseJsp&detailId="+detailId+"&rowNo="+rowNo;
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

function deleteItemcheck(inc){
var check = false;
			 for(var i = 0; i <inc; i++)
			 {
				
			  if (document.getElementById('deleteItem'+i).checked==true ){
            		if(document.getElementById('deleteItem'+i).value!=""){
            		check = true;
            		}
			  	}
			 }
	if(!check){
	alert("Please select the item !!")
	return false;
	}else{
	 if(document.getElementById('received').value == "0"){
	  if(confirm("Are You Sure,You want Delete ? ")){
	   // document.getElementById('received').value = ""
	      return true;
			 }else{
			// document.getElementById('received').value = ""
				return false;
			 }
			  
	  }
	  else{
	     //document.getElementById('received').value = ""
	     alert("Items are received in CRV '"+document.getElementById('crvNo').value+"'\n you can not delete !!");
	 } 		 
	//return true;
	}
return false;	
}


function confirmCancel(){
  if(confirm("Are You Sure,You want cancel LSO ? ")){
	      return true;
   }else{
	      return false;
  }
}



function fillSrNoForRowSize(rowVal){
	var pageNo=parseInt(document.getElementById('noOfRows').value);
	var rowSize=document.getElementById('rowSize').value;
	
   		rowVal=rowVal%10
   		if(rowVal==0){
   			rowVal=10
   	 		}
   		if(!(parseInt(document.getElementById('rowSize').value)>=parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
 		  	document.getElementById('rowSize').value=(parseInt(rowSize)+1);
 		  	
			}
   		
   		return true;
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

		        
		        obj1.length++;
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
	Map<String, Object> purchaseMap = new HashMap<String, Object>();
	String noDetailRecords="no";
	String previousPage = "no";
	String validationMessage ="CRV already generated against this supply order";
	String validationMessage1 ="This supply order is cancelled";
	
	int pageNo = 1;
	int poId = 0;
	int grn = 0;
	String crvNo = "";
	BigDecimal netAmount = null;
	
	//List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<StorePoHeader> poNumberList = new ArrayList<StorePoHeader>();
	List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();
	List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
	List<MasItemCategory>masItemCategory =new ArrayList<MasItemCategory>();
	
	Box box=HMSUtil.getBox(request);
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");

	 if(map.get("box")!=null)
		 box =(Box) map.get("box") ;
	
	if(map.get("poId")!=null){
		poId = Integer.parseInt(""+map.get("poId"));
	}
	//if(map.get("previousPage")!=null){
		//previousPage=(""+map.get("previousPage"));
	//}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	if (map.get("poNumberList") != null) {
		poNumberList = (List<StorePoHeader>)map.get("poNumberList");
	}
	
	if (map.get("poHeaderList") != null) {
		poHeaderList = (List<StorePoHeader>)map.get("poHeaderList");
	}
	
	if (map.get("poDetailList") != null) {
		poDetailList = (List<StorePoDetail>)map.get("poDetailList");
	}
	
	if(map.get("grnHeaderList") != null){
		grn = (Integer)map.get("grnHeaderList");
	}
	
	if(map.get("crvNo") != null){
		crvNo = (String)map.get("crvNo");
	}
	//if (map.get("poHeaderList") != null) {
		//poHeaderList = (List<StorePoHeader>)map.get("poHeaderList");
	//}
	if (map.get("purchaseMap") != null) {
		purchaseMap = (Map<String, Object>)map.get("purchaseMap");
	}
	if(purchaseMap.get("supplierList")!=null){
		supplierList = (List<MasStoreSupplier>) purchaseMap.get("supplierList");
	}
	//if(purchaseMap.get("itemList")!=null){
	//	itemList = (List<MasStoreItem>) purchaseMap.get("itemList");
	//}
	if(map.get("noDetailRecords")!=null){
		noDetailRecords=(""+map.get("noDetailRecords"));
	}
	 int totalPages=0;
	 if(map.get("totalPages")!=null){
		 totalPages=(Integer)map.get("totalPages");
		}
	 
	 BigDecimal currAmount= new BigDecimal("0");
	 if(map.get("currAmount")!=null){
		 currAmount=(BigDecimal)map.get("currAmount");
		}
	 if(map.get("masItemCategory")!=null){
			masItemCategory=(List<MasItemCategory>)map.get("masItemCategory");
		}
	 %>

<div id="contentspace">
<div class="titleBg">
<h2 >Supply Order Entry</h2>
</div>

<div class="clear"></div>
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
<label>From Date :</label> 
<input type="text" name="<%= FROM_DATE %>"	 MAXLENGTH="30" tabindex=1 />
<img id="calendar"  src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
				          onClick="setdate('<%=currentDate%>',document.departmentIndent.<%= FROM_DATE%>,event)" />

<label >To Date :</label> 
<input type="text" name="<%= TO_DATE %>" MAXLENGTH="30"  tabindex=1 />
 <img id="calendar"  src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
				 onClick="setdate('<%=currentDate%>',document.departmentIndent.<%= TO_DATE%>,event)" />
<div class="clear"></div>				 
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
<input type="button" name="sss" class="button" value="SEARCH" onClick="submitForm('departmentIndent','neStores?method=searchPO');" />	
<input type="button" name="close" class="button" value="CLOSE" onClick="closeSearchBlock();" />		
</form>
</div>
</form>
</div>

<form name="purchaseGrid" method="post">
<div id="testDiv" size="height:500px;"><input type="hidden"
	name="pageNo" value="<%=pageNo%>" id="pageNo" /> <%
	poHeaderList = new ArrayList<StorePoHeader>();
	StorePoHeader poHeaderObj = null;
	String status = "";
	if(map.get("poHeaderList") != null)
	{
		poHeaderList = (List<StorePoHeader>)map.get("poHeaderList");
		
	if(poHeaderList.size() > 0)
	{
		poHeaderObj = (StorePoHeader)poHeaderList.get(0);
		poId = poHeaderObj.getId();
		netAmount = poHeaderObj.getNetAmount();
		status = poHeaderObj.getStatus();
	}
	}
		
	%> <input type="hidden" name="totalRecords"
	value="<%=poDetailList.size() %>" />
<!--<input type="button" class="buttonBig" value="Budget Status" onclick="window.open('/hms/hms/purchaseOrder?method=showBudgetStatus','new','left=200,top=100,width=425,height=350')" />
	
	--><!-- -
<input type="button" class="button" value="Approval Authority"
	onclick="window.open('/hms/hms/purchaseOrder?method=showApprovalAuthority&poId='+purchaseGrid.<%=PO_ID %>.value,'new','left=200,top=100,width=525,height=350')" />
	 -->

<% if (poHeaderObj!=null)
{
	int tender_id = 0;
	int group_id = 0;

	try
	{
		tender_id = poHeaderObj.getTenderM().getId();
	}
	catch(Exception e)
	{
		tender_id = 0;
	}
	
	try
	{
		group_id = poHeaderObj.getGroup().getId();
	}
	catch(Exception e)
	{
		group_id = 0;
	}
	
%> <input type="hidden" name="tender_id" value="<%=tender_id%>" /> <input
	type="hidden" name="group_id" value="<%=group_id%>" /> <% } %> <%
String dt = "";
String poDate = "";
String deliveryDate = "";
String quotationDate = "";
String converted_date = "";
if (poHeaderObj!=null)
{
	
dt =  poHeaderObj.getPoDate().toString();
converted_date = dt.substring(8) + "/" +dt.substring(5, 7) + "/" + dt.substring(0, 4);
poDate = converted_date;

dt =  poHeaderObj.getDeliveryDate().toString();
converted_date = dt.substring(8) + "/" +dt.substring(5, 7) + "/" + dt.substring(0, 4);
deliveryDate = converted_date;

//dt =  poHeaderObj.getQuotationDate().toString();
converted_date = dt.substring(8) + "/" +dt.substring(5, 7) + "/" + dt.substring(0, 4);
quotationDate = converted_date;

}

%>

<div style="padding-left: 15px;">

	<%
  if(crvNo.equals("") && !status.equals("c")){ 
 %>
	
		
		
<!--<input type="button" class="button" value="Cancel LSO" onclick="if(confirmCancel()){submitForm('purchaseGrid','purchaseOrder?method=cancelLSO');}" />
	--><%} %>
<div class="clear"></div>
<div class="Block">
		<label> SO No.<span>*</span></label>
		<% if(poHeaderObj != null){ %>
<input type="text" name="<%= PO_NO %>" value="<%=poHeaderObj.getPoNumber()%>" readonly="readonly" validate="P.O. Number ,String,yes" tabindex=1 /> 
<input type="hidden" name="parent" id="headerId" value="<%=poHeaderObj.getId()%>" />		
		<label> SO Date<span>*</span></label>
		</td>
		<input type="text" class="textbox_size20"name="<%= PO_DATE %>" value="<%=poDate%>" readonly="readonly"
			tabindex=1 />
		
		<%}else{ %>
		<input type="text" class="textbox_size20" name="<%= PO_NO %>" value="" validate="P.O. Number ,String,yes" tabindex=1 />
		<label><span>*</span> SO Date</label>
	<input type="text" class="textbox_size20" name="<%= PO_DATE %>" value="<%=currentDate %>" readonly="readonly" tabindex=1 validate="P.O. Date ,dateOfAdmission,no" />
	<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.purchaseGrid.<%=PO_DATE%>,event)" />
		<%} %>
<label> Vendor <span>*</span></label>
<select name="<%= SUPPLIER_ID %>" validate="Vendor Name,string,yes" tabindex=1>
		<option value="">Select</option>
			<%
	for (MasStoreSupplier masStoreSupplier :supplierList ) {
		if(poHeaderObj != null){
			if(poHeaderObj.getSupplier().getId().equals(masStoreSupplier.getId())){
%>

			<option value=<%=masStoreSupplier.getId()%> selected="selected"><%=masStoreSupplier.getSupplierName()%></option>
			<%      	}else{ 
%>
			<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%></option>
			<%
}}}
%>
		</select>
		
		<div class="clear"></div>
<label> Delivery Date <span>*</span></label>
<%if(poHeaderObj != null)
{%>
<input type="text" name="<%=DELIVERY_DATE%>" value="<%=poHeaderObj.getDeliveryDate()==null?"":HMSUtil.convertDateToStringWithoutTime(poHeaderObj.getDeliveryDate())%>" readonly="readonly" validate="Delivery Date,deliveryDate,yes"  MAXLENGTH="30" class="date"  id="soDate"/>
<%}else{%>
<input type="text" name="<%=DELIVERY_DATE%>" value="" readonly="readonly" style="border: 1px solid #7f9db7;" validate="Delivery Date,deliveryDate,yes"  MAXLENGTH="30" class="date" id="soDate"/>
<%}%>
 <img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.purchaseGrid.<%=DELIVERY_DATE%>,event)" />
     
	<label>Reference</label>
	<%if(poHeaderObj.getReferences()!=null){ %>
	<input	type="text"  name="references" value="<%=poHeaderObj.getReferences()%>" validate="references,String,no" tabindex=1 />
	<%}else{%>
	<input	type="text"  name="references" value="TENDER INQUIRY NO. 01/2011-12/12/MS/PRICE AGREEMENT DATED 03 MARCH 11."  validate="references,String,no" tabindex=1 />
	<%}%> 
	<!--<label>Signing Authority</label>
	<%if(poHeaderObj != null){ %>
	<textarea value="<%=poHeaderObj.getSigningAuthority()%>" readOnly name="<%=LPO_SIGNING_AUTHORITY %>" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" maxlength="200"/><%=poHeaderObj.getSigningAuthority()%></textarea> 
	<%}else{ %>
	<textarea value="" name="<%=LPO_SIGNING_AUTHORITY %>" validate="Signing Authority ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200"/></textarea> 
	<%} %>
	-->
	<label>Category <span>*</span></label>
	<select	name="category" id="categoryId" validate="category ,String,yes">
<%
			for (MasItemCategory masItemCategoryL :masItemCategory ) {
				try{
				if(poHeaderObj.getCategory().toString().equals(masItemCategoryL.getId().toString())){
%>
			<option value=<%=masItemCategoryL.getId()%> selected="selected"><%=masItemCategoryL.getItemCategoryName()%></option>
<%}else{%>
			<option value=<%=masItemCategoryL.getId()%>><%=masItemCategoryL.getItemCategoryName()%></option>
<% }				
				}catch(Exception e){
					%>
				<option value=<%=masItemCategoryL.getId()%>><%=masItemCategoryL.getItemCategoryName()%></option>
					<% 
				}
				}
%>
	</select>
	<div class="clear"></div>
	 
	
	<label>Contact No.</label>
	<%if(poHeaderObj.getTelephoneNo()!=null){%>
	<input	type="text"  name="telephoneNo"  value="<%=poHeaderObj.getTelephoneNo()%>"  validate="Contact No ,phone,no" tabindex=1 maxlength="12"/>
	<%}else{%>
		<input	type="text"  name="telephoneNo"  value=""  validate="Contact No ,phone,no" tabindex=1 maxlength="12"/>
	<%}%>
	<label>Code Head</label>
	<%if(poHeaderObj.getCodehead()!=null){%>
	<input	type="text"  name="codehead" value="<%=poHeaderObj.getCodehead()%>"  validate="codehead ,String,no" tabindex=1 />
	<%}else{%>
		<input	type="text"  name="codehead" value="LCH-749/01"  validate="codehead ,String,no" tabindex=1 />
	<%}%>
	<input	type="hidden"  name="requestType"  id="reqType" value="" />
	 <!--<label>Approval of CFA/IFA vide</label>
	<textarea value="" name="<%="approval" %>" validate="approval of CFA/IFA vide ,String,no" tabindex=1 cols="71" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="198" class="auto" /></textarea>
	
	-->
	<label>Remarks</label>
	<%if(poHeaderObj.getRemarks() != null){%>
	<textarea name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onKeyUp="chkLength(this,200);"/>
	<%=poHeaderObj.getRemarks().trim()%>
	</textarea> 
	<%}else{%>
	<textarea value="" name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)"  onKeyUp="chkLength(this,200);"/></textarea> 
	<%} %>
</div>  	
		<!--<%if(poHeaderObj != null){ %>
		<div class="clear"></div>
		<label ><span>*</span> Delivery Date </label>
		
	<input type="text" class="textbox_size20" name="<%= DELIVERY_DATE %>" value="<%=deliveryDate %>" readonly="readonly" tabindex=1 />
	<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" class="calender"	tabindex="1"onClick="setdate('<%=currentDate%>',document.purchaseGrid.<%=DELIVERY_DATE%>,event)" />
		
		<% } else { %>
	
		<label > Delivery Date<span>*</span> </label>
		
		<input type="text" class="textbox_size20" name="<%= DELIVERY_DATE %>" value="<%=currentDate %>"	readonly="readonly" tabindex=1 validate="Delivery Date ,deliveryDate,no" />
	<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" class="calender"	tabindex="1"	onClick="setdate('<%=currentDate%>',document.purchaseGrid.<%=DELIVERY_DATE%>,event)" />
	
		<% } %>


<div class="clear"></div>
	<label >Remarks</label>
<%if(poHeaderObj != null && poHeaderObj.getRemarks() != null){ %> 
<textarea	value="<%=poHeaderObj.getRemarks()%>" name="<%=REMARKS %>"	validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="250" /></textarea> 
<script>document.purchaseGrid.<%=REMARKS%>.innerHTML = "<%=poHeaderObj.getRemarks() %>"</script>
<%}else{ %> 
<textarea value="" name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"  maxlength="250" /></textarea> 
<%} %> 
	 
<label >Signing Authority</label>
<%if(poHeaderObj != null && poHeaderObj.getSigningAuthority() != null){ %>
<textarea name="<%=LPO_SIGNING_AUTHORITY %>" validate="Signing Authority ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"  maxlength="250" />
<%=poHeaderObj.getSigningAuthority()%></textarea>
<%}else{ %> <textarea value="" name="<%=LPO_SIGNING_AUTHORITY %>"
	validate="Signing Authority ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	 maxlength="250" /></textarea> <%} %> 
	 

<label >Approval of CFA/IFA vide</label>

<%if(poHeaderObj != null && poHeaderObj.getAppVide() != null){ %> 
<textarea name="<%="approval" %>" validate="approval of CFA/IFA vide ,String,no" tabindex=1  maxlength="150" /><%=poHeaderObj.getAppVide()%></textarea>
<%}else{ %> 
<textarea value="" name="<%="approval" %>" validate="approval of CFA/IFA vide,String,no" tabindex=1 maxlength="150" /></textarea> <%} %> 
<% if (poHeaderObj != null && poHeaderObj.getStatus().equalsIgnoreCase("o")) { %>
<div class="clear"></div>
</div>
<input type="button" class="button" value="Update & Next"  onclick="if(checkForNext() && checkForLocalPurchaseGrid()){submitForm('purchaseGrid','purchaseOrder?method=updatePurchaseOrder&buttonFlag=next');}" align="right" />
   onClick="{submitForm('purchaseGrid','purchaseOrder?method=poModifyJsp&buttonFlag=goToPage');}"
   <input type="button" class="button" value="Update"
	onClick="{submitForm('purchaseGrid','purchaseOrder?method=poModifyJsp&buttonFlag=goToPage');}"
	align="right" />  --> 


<!--<label >Page No:</label>
<div ><%=pageNo%></div>
--><!--<td width="9%"><input type="text" class="smcaption"
	name="ValueOfPage" <%if(box.getString("pvmsNo1").equals("")){ %>
	value="<%=pageNo+1%>" <%}else{%> value="" <%}%> id="page"
	style="width: 50px;" MAXLENGTH="3" /></td>
<td width="21%"><input type="button" name="goToPage" value="Go"
	onClick="{submitForm('purchaseGrid','purchaseOrder?method=poModifyJsp&buttonFlag=goToPage');}"
	class="button" /></td>

--><!--<label >Total Pages:</label>
<div ><%=totalPages%></div>
-->

<% }else if(poHeaderObj != null && poHeaderObj.getStatus().equalsIgnoreCase("c")){%>

<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; font-weight: bold; height: 23px;">
<%=validationMessage1 %></div>
</div>
<div id="contentHolder"><input type="button" class="button"
	value="Next"
	onClick="{submitForm('purchaseGrid','purchaseOrder?method=poModifyJsp&buttonFlag=goToPage');}"
	align="right" />
<div style="float: left; padding-left: 15px; padding-bottom: 10px;">
<label >Page No:</label>
<div ><%=pageNo%></div>
<td width="9%"><input type="text" class="smcaption"
	name="ValueOfPage" <%if(box.getString("pvmsNo1").equals("")){ %>
	value="<%=pageNo+1%>" <%}else{%> value="" <%}%> id="page"
	style="width: 50px;" MAXLENGTH="3" /></td>
<td width="21%"><input type="button" name="goToPage" value="Go"
	onClick="{submitForm('purchaseGrid','purchaseOrder?method=poModifyJsp&buttonFlag=goToPage');}"
	class="button" /></td>
</div>
<label >Total Pages:</label>
<div ><%=totalPages%></div>
</br>
</br>
</div>
<%} else{%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; font-weight: bold; height: 23px;">
<%=validationMessage %></div>
</div>
<div id="contentHolder"><input type="button" class="button"
	value="Next"
	onClick="{submitForm('purchaseGrid','neStores?method=poModifyJsp&buttonFlag=goToPage');}"
	align="right" />
<div style="float: left; padding-left: 15px; padding-bottom: 10px;">
<label >Page No:</label>
<div ><%=pageNo%></div>
<td width="9%"><input type="text" class="smcaption"
	name="ValueOfPage" <%if(box.getString("pvmsNo1").equals("")){ %>
	value="<%=pageNo+1%>" <%}else{%> value="" <%}%> id="page"
	style="width: 50px;" MAXLENGTH="3" /></td>
<td width="21%"><input type="button" name="goToPage" value="Go"
	onClick="submitForm('purchaseGrid','neStores?method=poModifyJsp&buttonFlag=goToPage');"
	class="button" /></td>
</div>
<label >Total Pages:</label>
<div ><%=totalPages%></div>
</br>
</br>
</div>

<%} %>
</div>

<input type="hidden" name="<%=NO_DETAIL_RECORDS%>"
	value="<%=noDetailRecords%>" /> <input type="hidden" size="2"
	value="0" name="<%=NO_OF_ROWS %>" id="noOfRows" /> <input
	type="hidden" name="<%=PO_ID %>" value="<%=poId %>" id="poId" /> <input
	type="hidden" name="currAmount" value="<%= currAmount%>"
	id="currAmount" />

<div style="padding-left: 15px;">
<div class="Clear"></div>
<h4>Supply Order details</h4>
<div class="Clear"></div>
 <div class="cmntable">
<table align="center" width="100%" colspan="7" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
		
	      <th width="5%">Sl</br>No.</th>
	      <th width="7%">PVMS<br>/NIV  No.</th>
	      <th width="7%">Nomenclature</th>
	      <th width="5%">A/U</th>
	      <%--
	      <th width="5%">B/G</th>
	       <th width="7%">Brand</br>Name</th> --%>
	      <th width="7%">Manufacturer</th>
	      <%---
	      <th width="7%">Qty</br>Req.</th>
	       <th width="13%"><label valign="left" class="smalllabel">Actual quantity</label></th>
	      <th width="13%"><label valign="left" class="smalllabel">Free Qty</label></th> 
	 		<th width="7%">Dispense</br>Type</th>
		  <th width="6%">Packaging</th>--%>
		   <th width="7%">Quantity</th>
	 
		<!-- -  
		  <th width="9%"><label valign="left" class="smalllabel">Rate Per MDQ</label></th> 
		  <th width="9%"><label valign="left" class="smalllabel">Total Rate for OQ</label></th>
		  <th width="9%"><label valign="left" class="smalllabel">ExciseDuty for OQ</label></th>
		  <th width="13%"><label valign="left" class="smalllabel">Unit Rate</label></th>-->
	      <th width="5%">MRP</th>
	      <th width="5%">Disc(%)</th>
	      <th width="5%">Tax(%)</th>
	      <!--<th width="6%"><label valign="left" class="smalllabel">Other Taxes(in Rs.)</label></th> -->
	      	<th width="5%">Actual</br>Cost</th>
	      <th width="5%">Amount</th>
		  <th width="5%">Delete</th>
	      <!-- -<th width="13%"><label valign="left" class="smalllabel">Free Item</label></th> -->
    	</tr>
	</thead>
	<tbody>
		
		<%
   		BigDecimal pageTotal = new BigDecimal(0);
  		int detailCounter=200; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	String idBg="idBg";
    	String idBg2="idBg";
    	String quantityInVar="quantityInVar";
    	String taxVar="taxVar";
    	String unitRateVar="unitRateVar";
    	String amountVar = "amountVar";
    	String discountVar="discountVar";
    	String costPrice="costPrice";
    	String quantityInVarTemp="quantityInVarTemp";
    	String taxVarTemp="taxVarTemp";
    	String unitRateVarTemp="unitRateVarTemp";
    	String amountVarTemp = "amountVarTemp";
    	String discountVarTemp="discountVarTemp";
    	String incVar="incVar";
    	String prescription_id="prescription_id";
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
    	String totalCarryForward = "totalCarryForward";
    	String discountAmount = "discountAmount";
    	String taxAmount = "taxAmount";
    	String detailId = "detailId";
    	String actualqty = "actualqty";
    	String actualqtyin = "actualqtyin";
    	String formula = "formula";
    	String conversionFactor = "conversionFactor";
    	String totRateOq = "totRateOq";
    	String exciseDuty = "exciseDuty";
    	String taxOq = "taxOq"; 
    	String deleteItem="deleteItem";
   
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";
	   	String quantityInVar2="quantityInVar";
    	String taxVar2="taxVar";
    	String unitRateVar2="unitRateVar";
    	String amountVar2 = "amountVar";
    	String discountVar2="discountVar";
    	String costPrice2="costPrice";
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
    	String totalCarryForward2 = "totalCarryForward";
    	String discountAmount2 = "discountAmount";
    	String taxAmount2 = "taxAmount";
    	String detailId2 = "detailId";
    	String actualqty2 = "actualqty";
    	String actualqtyin2 = "actualqtyin";
    	String formula2 = "formula";
    	String conversionFactor2 = "conversionFactor";
    	String totRateOq2 = "totRateOq";
    	String exciseDuty2 = "exciseDuty";
    	String taxOq2 = "taxOq";
    	String prescription_id2="prescription_id";
    	String deleteItem2="deleteItem";
			int inc=0;
	    	   int incTemp2=poDetailList.size();
	    	   
	    	   int intDel=0;
	    	   if(poDetailList!=null){
	    	   intDel=poDetailList.size();
	    	   }
	    	   for(StorePoDetail storePoDetail : poDetailList){
	    		   pageTotal = pageTotal.add(storePoDetail.getAmount());
	    		  //if(inc<incTemp2){
   %>
		
		<%
    	
    	
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idAu=idAu2+(""+inc);
     		idBg=idBg2+(""+inc);
     		quantityInVar=quantityInVar2+(""+inc);
     		taxVar=taxVar2+(""+inc);
     		unitRateVar=unitRateVar2+(""+inc);
     		amountVar=amountVar2+(""+inc);
     		discountVar=discountVar2+(""+inc);
     		costPrice=costPrice2+(""+inc);
     		freeQty=freeQty2+(""+inc);     		
     		freeItem=freeItem2+(""+inc);
     		amount=amount2+(""+inc);
     		manufacturerId=manufacturerId2+(""+inc);
     		brandId=brandId2+(""+inc);
     		
     		quantityInVarTemp=quantityInVarTemp2+(""+inc);
     		taxVarTemp=taxVarTemp2+(""+inc);
     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
     		amountVarTemp=amountVarTemp2+(""+inc);
     		discountVarTemp=discountVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
     		
     		dispenseType = dispenseType2 +(""+inc);
        	mdq = mdq2 +(""+inc);
        	ratePerMdq = ratePerMdq2 +(""+inc);
        	mrp = mrp2 +(""+inc);
        	otherTaxes = otherTaxes2 +(""+inc);
        	totalCarryForward = totalCarryForward2 +(""+inc); 
        	discountAmount = discountAmount2+(""+inc);
        	taxAmount=taxAmount2+(""+inc);
        	detailId=detailId2+(""+inc);
        	actualqty = actualqty2+(""+inc);
        	actualqtyin =actualqtyin2+(""+inc); 
        	formula = formula2+(""+inc);
        	conversionFactor = conversionFactor2+(""+inc);
        	totRateOq = totRateOq2+(""+inc);
        	exciseDuty = exciseDuty2+(""+inc);
        	taxOq = taxOq2+(""+inc);
        	prescription_id=prescription_id2+(""+inc);
        	deleteItem=deleteItem2+(""+inc);
        	
    %>
		
     <%-- 
      <td width="5%">
    
      <input type="checkbox" id="deleteItem<%=inc%>" class="checkbox" name="deleteItem" value="" />
       
      </td>  --%>
      
    
      
       <tr>
      
      	<td width="5%"><input type="text" size="3"
				value="<%=storePoDetail.getSerialNo()%>" 
				name="<%=SR_NO%>" readonly="readonly" />
				 <input type="hidden" name="<%=DETAIL_ID%>" id="<%=detailId%>"
				value="<%=storePoDetail.getId()%>" /> <input type="hidden"
				value="<%=storePoDetail.getItem().getItemConversion().getFormula() %>"
				class="smcaption" name="" id="<%=formula%>" /> <input type="hidden"
				value="<%=storePoDetail.getItem().getItemConversion().getConversionFactor1() %>"
				class="smcaption" name="" id="<%=conversionFactor%>" /></td>

			<td width="10%"><input type="text"  class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>"
				value="<%=storePoDetail.getItem().getPvmsNo() %>"  tabindex="1" size="8"/></td>

			<input type="hidden" size="2"
				value="<%=storePoDetail.getItem().getId() %>" class="smcaption"
				name="<%=ITEM_ID%>" id="<%=idItem%>" />

			<td width="10%">
			<input type="text" value="<%=storePoDetail.getItem().getNomenclature() %>"
				id="<%=nameItem%>" size="30" name="<%=nameItem%>"
				tabindex="1" readonly="readonly"  size="25"/>
				 <!-- 
		 	<div id="ac2update" style="display:none; border:1px solid black; padding-right: 450px; background-color:white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=<%=nameItem%>&poId='+document.getElementById('poId').value });
			</script>
		--></td>

     
     	<%
	  String unitname = "";
     	String bg="";
	  try
	  {
	  	  unitname = storePoDetail.getItem().getItemConversion().getItemUnitName();
	  }
	  catch(Exception e)
	  {
		  unitname = "-";
	  }
	  
	  
	  try
	  {
	  	  bg = storePoDetail.getItem().getBrandedGeneric();
	  }
	  catch(Exception e)
	  {
		  bg = "";
	  }
	  
	  
	  
	  %>

			<td width="10%"><input type="text" value="<%=unitname%>" size="5"
				class="smcaption" readonly="readonly" name="<%=AV%>" id="<%=idAu%>"
				tabindex="1" /></td>
				<%--- 
       <td width="10%">
      <input type="text" value="<%=bg%>" class="smcaption" readonly="readonly" name="<%=BG%>" id="<%=idBg%>" tabindex="1" validate="A/U ,String,no" size="1"/>
      </td>
      <td width="10%"><select name="<%=BRAND_ID%>" id=<%=brandId%> class="small3"
				tabindex="1">
				<option value="">Select Brand</option>
				<%
      
      	int bId = 0;
        int mId = 0;
      
      	try
        {
      		bId = storePoDetail.getBrand().getId();
      	}
      	catch(Exception e)
      	{
      		bId = 0;
      	}
      	
      	try
        {
      		mId = storePoDetail.getManufacturer().getId();
      	}
      	catch(Exception e)
      	{
      		mId = 0;
      	}

      	
      	List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
      	if(storePoDetail.getBrand()!=null)
      	{
      		try{
      	brandList = (List) map.get(storePoDetail.getBrand());
      	for (MasStoreBrand masStoreBrand : brandList)
      	{
      		if(storePoDetail.getBrand().getId()==masStoreBrand.getId())
      		{
      		%>
				<option value=<%=masStoreBrand.getId()%>
					<%=HMSUtil.isSelected(bId,masStoreBrand.getId())%> selected="selected"><%=masStoreBrand.getBrandName() %>
				</option>
				<% }
      	else{

      %>  
      <option value=<%=masStoreBrand.getId()%>
					<%=HMSUtil.isSelected(bId,masStoreBrand.getId())%> ><%=masStoreBrand.getBrandName() %>
				</option>
      <%}}}catch(Exception e){
    	  
      } }%>
	</select></td> --%>
	
				<td width="10%"><select name="<%=MANUFACTURER_ID %>" class="small3"
				id=<%=manufacturerId%> tabindex="1">
				<option value="">Select Manufacturer</option>
				
		  
		  <%if(storePoDetail.getManufacturer()!=null) {%>
     
      <option value="<%=storePoDetail.getManufacturer().getId() %>" selected="selected"><%=storePoDetail.getManufacturer().getManufacturerName()%></option>
      <%} %>
	</select></td><%----
			<td width="10%">
			<input type="text" class="medcaption" value="<%=storePoDetail.getLsoQty()==null?"0":storePoDetail.getLsoQty() %>"  size="5" name="" id="<%=actualqtyin %>" validate="ActualQuantity,float,no" onblur="gridCalculationNonLSOAdd(<%=inc%>);" tabindex="1" maxlength="9" /> 
				<input type="hidden" value="<%=storePoDetail.getLsoQty()==null?"0":storePoDetail.getLsoQty()%>" name="<%=ACTUAL_QTY %>" id="<%=actualqty%>" />
			 </td>
			<td width="10%">
			<select name="dipenseType" id=<%=dispenseType%> class="small3"
				tabindex="1">
				<option value="<%=storePoDetail.getDispType()%>" selected="selected"><%=storePoDetail.getDispType() %></option>
			</select>
			</td>
			
			
			<td width="10%"><input type="text"  
				value="<%=storePoDetail.getMdqValue() %>" name="mdq" id="<%=mdq%>"
				onblur="gridCalculationNonLSOAdd(<%=inc%>);" tabindex="1"
				validate="Minimum Dispensable Qty (MDQ),num,no" maxlength="9" size="8"/></td>
				
      --%>
      <td width="10%"><input type="text"  value="<%=storePoDetail.getQuantityOrdered() %>" 
				name="" id="<%=quantityInVarTemp %>" tabindex="1"
				onBlur="gridCalculationNonLSOAdd(<%=inc%>);"
				validate="Quantity,float,no" maxlength="9" size="5"/> 
			<input type="hidden" value="<%=storePoDetail.getQuantityOrdered() %>" 
				name="<%=QUANTITY %>" id="<%=quantityInVar%>" size="8"/></td>
      
      <%-- -<td width="10%">
      <input type="text"  class="medcaption" name="ratePerMdq" value="0" id="<%=ratePerMdq%>" onblur="gridCalculationNonLSOAdd(<%=inc%>);" validate="Rate per MDQ,float,no" onblur="calculateUnitRateinLocalSupplyOrder(<%=inc%>);" tabindex="1" maxlength="16"/>
      </td> 
      
      <td width="10%">
      <input type="text"  class="medcaption" name="totRateOq"  value="0" id="<%=totRateOq%>"  validate="totRateOq,float,no"  tabindex="1" maxlength="15"/>
      </td>

       <td width="10%">
      <input type="text"  class="medcaption" name="exciseDuty" value="0" id="<%=exciseDuty%>" onblur="gridCalculationNonLSOAdd(<%=inc%>);" validate="exciseDuty,float,no"  tabindex="1" maxlength="15"/>
      </td>
      --%>
      
      
      
		<td width="10%"><input type="text" 
				value="<%=storePoDetail.getMrp()==null?"0":storePoDetail.getMrp() %>" class="medcaption" value="0" name="mrp"
				id="<%=mrp%>"
				onblur="gridCalculationNonLSOAdd(<%=inc%>);" tabindex="1"
				validate="Rate per MDQ,float,no" maxlength="16" size="5"/></td>

<td width="10%">
    <input type="text" 
				name="<%=DISCOUNT_PERCENTAGE%>" class="medcaption"
				value="<%=storePoDetail.getDiscountPercent()==null?"0":storePoDetail.getDiscountPercent()%>"
				name="" id="<%=discountVarTemp%>"
				onblur="gridCalculationNonLSOAdd(<%=inc%>);" tabindex="1"
				validate="Discount,float,no" maxlength="6"  size="5"/>
				 <input type="hidden"
				 name="<%=DISCOUNT_AMOUNT%>"
				id="<%=discountAmount%>"
				value="<%=storePoDetail.getDiscountAmount()==null?"0":storePoDetail.getDiscountAmount()%>"
				tabindex="2" size="8"/></td>
 
			     <td width="10%"><input type="text" name="<%=TAX_PERCENT %>" class="medcaption"
				value="<%=storePoDetail.getTaxPercent()==null?"0":storePoDetail.getTaxPercent()%>"
				class="medcaption"  id="<%=taxVarTemp%>"
				onblur="gridCalculationNonLSOAdd(<%=inc%>);"
				validate="Tax,float,no" tabindex="1" maxlength="15" size="5"/> 
				
				
				<input
				type="hidden" class="medcaption"
				value="<%=storePoDetail.getTaxAmtPerMdq()==null?"0":storePoDetail.getTaxAmtPerMdq()%>"
				name="<%=TAX_AMOUNT%>"  id="<%=taxAmount%>" validate="taxOq,float,no"
				maxlength="15" tabindex="1" /> <%--<input type="hidden"	name="<%=SALES_TAX_AMOUNT%>" id="<%=taxAmount%>" value="<%=storePoDetail.getTaxAmount()==null?"0":storePoDetail.getTaxAmount()%>" class="smcaption"  tabindex="2" />--%>
			</td>
      
       <td width="10%">
			<input type="text" value="<%=storePoDetail.getUnitRate()==null?"0":storePoDetail.getUnitRate()%>" 	 name="<%= COST_PRICE %>" id="<%=costPrice%>" tabindex="1" size="5"/>
			</td>
      <td width="3%">
      <input type="text" class="medcaption"  name="" id="<%=amountVarTemp%>" value="<%=storePoDetail.getAmount()%>" readonly="readonly" validate="Amount,float,no"  tabindex="1"  size="6"/>
      <input type="hidden" class="medcaption" value="<%=storePoDetail.getAmount()%>" name="<%=AMOUNT%>"  id="<%=amountVar%>"/>
      </td>
       <td width="5%"><input type="checkbox" id="<%=deleteItem%>"
				class="checkbox" name="deleteItem"
				value="<%=storePoDetail.getId() %>"  /></td>
      <!-- -
      <td width="10%">
      <select name="<%=FREE_ITEM %>" id="<%=freeItem %>"  tabindex="1" onChange="gridCalculationNonLSOAdd(<%=inc%>);">
	  <option value="n">No</option>
	  <option value="y">Yes</option>
      </select>
      </td>
       -->
       </tr>
		<% inc++;
     	// }
     	 }
	    	   %> 
	    	   <script>
	    	 document.purchaseGrid.noOfRows.value=<%=inc-((pageNo-1)*10)-1%>
	    	 </script> <%
	    	
	       	temp=0;
	    	idItem="idItem";
	    	codeItem="codeItem";
	    	nameItem="nameItem";
	    	idAu="idAu";
	    	idBg="idBg";
	    	 idBg2="idBg";
	    	quantityInVar="quantityInVar";
	    	taxVar="taxVar";
	    	unitRateVar="unitRateVar";
	    	amountVar="amountVar";
	    	discountVar="discountVar";
	    	
	    	quantityInVarTemp="quantityInVarTemp";
	    	taxVarTemp="taxVarTemp";
	    	unitRateVarTemp="unitRateVarTemp";
	    	amountVarTemp = "amountVarTemp";
	    	discountVarTemp="discountVarTemp";
	    	incVar="incVar";
	    	
	    	freeQty="freeQty";
	    	amount="amount";
	    	manufacturerId="manufacturerId";
	    	brandId="brandId";
	    	freeItem="freeItem";
	    	
	    	dispenseType = "dispenseType";
	    	mdq = "mdq";
	    	ratePerMdq = "ratePerMdq";
			mrp = "mrp";
	    	otherTaxes = "otherTaxes";
	    	totalCarryForward = "totalCarryForward";
	    	detailId = "detailId";
	    	actualqty = "actualqty";
	    	actualqtyin = "actualqtyin";
	    	costPrice="costPrice";
	    
	    	idItem2="idItem";
	    	codeItem2="codeItem";
	    	nameItem2="nameItem";
	    	idAu2="idAu";
		   	quantityInVar2="quantityInVar";
	    	taxVar2="taxVar";
	    	unitRateVar2="unitRateVar";
	    	amountVar2 = "amountVar";
	    	discountVar2="discountVar";
	    	
	    	freeQty2="freeQty";
	    	amount2="amount";
	    	manufacturerId2="manufacturerId";
	    	brandId2="brandId";
	    	freeItem2="freeItem";
	    	
	    	
	    	quantityInVarTemp2="quantityInVarTemp";
	    	taxVarTemp2="taxVarTemp";
	    	unitRateVarTemp2="unitRateVarTemp";
	    	amountVarTemp2 = "amountVarTemp";
	    	discountVarTemp2="discountVarTemp";
	    	incVar2="incVar2";
	    	costPrice2="costPrice";
	    	
	    	dispenseType2 = "dispenseType";
	    	mdq2 = "mdq";
	    	ratePerMdq2 = "ratePerMdq";
			mrp2 = "mrp";
	    	otherTaxes2 = "otherTaxes";
	    	totalCarryForward2 = "totalCarryForward";
	    	detailId2 = "detailId";
	    	actualqty2 = "actualqty";
	    	actualqtyin2 = "actualqtyin";
	    	formula = "formula";
	    	conversionFactor = "conversionFactor";
	    	totRateOq = "totRateOq";
	    	exciseDuty = "exciseDuty";
	    	taxOq = "taxOq"; 
	    	
	    		  if(inc<incTemp2){
	    			  inc=inc+1;
	    			  for(;inc<incTemp2;inc++)
	    			  {
	    				    idItem=idItem2+(""+inc);
	    		     		codeItem=codeItem2+(""+inc);
	    		     		nameItem=nameItem2+(""+inc);
	    		     		idAu=idAu2+(""+inc);
	    		     		idBg=idBg2+(""+inc);
	    		     		quantityInVar=quantityInVar2+(""+inc);
	    		     		taxVar=taxVar2+(""+inc);
	    		     		unitRateVar=unitRateVar2+(""+inc);
	    		     		amountVar=amountVar2+(""+inc);
	    		     		discountVar=discountVar2+(""+inc);

	    		     		freeQty=freeQty2+(""+inc);     		
	    		     		freeItem=freeItem2+(""+inc);
	    		     		amount=amount2+(""+inc);
	    		     		manufacturerId=manufacturerId2+(""+inc);
	    		     		brandId=brandId2+(""+inc);
	    		     		
	    		     		quantityInVarTemp=quantityInVarTemp2+(""+inc);
	    		     		taxVarTemp=taxVarTemp2+(""+inc);
	    		     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
	    		     		amountVarTemp=amountVarTemp2+(""+inc);
	    		     		discountVarTemp=discountVarTemp2+(""+inc);
	    		     		incVar=incVar2+(""+inc);
	    		     		costPrice=costPrice2+(""+inc);	     		
	    		     		dispenseType = dispenseType2 +(""+inc);
	    		        	mdq = mdq2 +(""+inc);
	    		        	ratePerMdq = ratePerMdq2 +(""+inc);
	    					mrp = mrp2 +(""+inc);
	    			    	otherTaxes = otherTaxes2 +(""+inc);
	    		        	totalCarryForward = totalCarryForward2 +(""+inc); 
	    		        	discountAmount = discountAmount2+(""+inc);
	    		        	taxAmount=taxAmount2+(""+inc);
	    		        	detailId = detailId2+(""+inc);
	    		        	actualqty = actualqty2+(""+inc);
	    		        	actualqtyin =actualqtyin2+(""+inc); 
	    		        	formula = formula2+(""+inc);
	    		        	conversionFactor = conversionFactor2+(""+inc);
	    		        	totRateOq = totRateOq2+(""+inc);
	    		        	exciseDuty = exciseDuty2+(""+inc);
	    		        	taxOq = taxOq2+(""+inc);
	    		          %>
		 <tr>
     <%-- 
      <td width="5%">
    
      <input type="checkbox" id="deleteItem<%=inc%>" class="checkbox" name="deleteItem" value="" />
       
      </td>  --%>
      <td width="5%"><input type="checkbox" id="<%=deleteItem%>"
				class="checkbox" name="deleteItem" value=""  /></td>
      
       <td width="3%">
      <input type="text" size="3" value="<%=temp+inc%>"  name="<%=SR_NO%>" readonly="readonly" />
	  <input type="hidden" size="2" value="0" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem%>" />
      <input type="hidden" value="" class="smcaption" name="" id="<%=formula%>" />
	  <input type="hidden" value="" class="smcaption" name="" id="<%=conversionFactor%>" />
	  </td>
      <td width="10%">
	     <input type="text"  name="<%=ITEM_CODE %>" tabindex="1" id="<%=codeItem%>" onblur="autocompleteBasedOnPvms(this.value,'<%=inc %>');" validate="PVMS No,String,no" size="8"/>
      </td>
      
		<td width="17%">
      	<input type="text" value=""	id="<%=nameItem%>"  onblur="if(fillSrNo('<%=inc %>') && fillSrNoForRowSize('<%=inc %>')){checkForPurchase(this.value, '<%=nameItem%>','<%=inc %>');}"  name="<%=nameItem%>" tabindex="1" size="30" />
		<div id="ac2update" style="display:none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
	    new Ajax.Autocompleter('<%=nameItem%>','ac2update','neStores?method=getItemListNonSupplyOrder',{parameters:'requiredField=<%=nameItem%>&poId='+document.getElementById('poId').value });
		</script>
		</td> 
     
      <td width="10%">
      <input type="text" value="" readonly="readonly" name="<%=AV%>" id="<%=idAu%>" tabindex="1" validate="A/U ,String,no" size="5" />
      </td>
      
      
       <td width="10%">
      <input type="text" value="" class="smcaption" readonly="readonly" name="<%=BG%>" id="<%=idBg%>" tabindex="1" validate="A/U ,String,no" size="1"/>
      </td>
      
      
      <td width="10%">
      <select name="<%=BRAND_ID%>" id=<%=brandId%> tabindex="1" validate="Brand,int,no" onchange="getManufacturerNameByAjax(this.value,<%=inc%>);" class="small3">
      <option value="">select brand</option>
      </select>
      </td>
      
      <td width="10%">
      <select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId%> tabindex="1" validate="Manufacturer,int,no" class="small3">
      <option value="">select manuf</option>
      </select>
      </td>

      <td width="10%">
       <input type="text" value="0" class="medcaption" name="" id="<%=actualqtyin %>"  validate="ActualQuantity,float,no" onblur="gridCalculationNonLSOAdd(<%=inc%>);" tabindex="1" maxlength="9" size="5"/>
      <input type="hidden" value="0" class="medcaption" name="<%=ACTUAL_QTY %>" id="<%=actualqty%>"/>
      <input type="hidden" name="prescription_id" value="0" id="<%=prescription_id%>"/> 
      </td>

       
	  <td width="10%">
      <select name="dipenseType" id=<%=dispenseType%> tabindex="1" validate="Dispense Type,String,no" class="small3">
             <option value="">select Dispen.</option>
      </select>
      </td>
      <td width="10%">
      <input type="text"  name="mdq" id="<%=mdq%>" onblur="gridCalculationNonLSOAdd(<%=inc%>);" validate="Minimum Dispensable Qty (MDQ),num,no" value="1" tabindex="1" maxlength="9" size="8"/>
      </td>
      <td width="10%">
      <input type="text" value="0"  name="" id="<%=quantityInVarTemp %>" readonly validate="Quantity,float,no" onblur="gridCalculationNonLSOAdd(<%=inc%>);" tabindex="1" maxlength="9" size="5"/>	
	 <input type="hidden" value="0"  name="<%=QUANTITY %>" id="<%=quantityInVar%>" />
      </td>
       
      <!-- -<td width="10%">
      <td width="10%">
      <input type="text"  class="medcaption" name="ratePerMdq" value="0" id="<%=ratePerMdq%>" onblur="gridCalculationNonLSOAdd(<%=inc%>);" validate="Rate per MDQ,float,no" onblur="calculateUnitRateinLocalSupplyOrder(<%=inc%>);" tabindex="1" maxlength="16"/>
      </td>
       

      <td width="10%">
      <input type="text"  class="medcaption" name="totRateOq"  value="0" id="<%=totRateOq%>"  validate="totRateOq,float,no"  tabindex="1" maxlength="15"/>
      </td>

       <td width="10%">
      <input type="text"  class="medcaption" name="exciseDuty" value="0" id="<%=exciseDuty%>" onblur="gridCalculationNonLSOAdd(<%=inc%>);" validate="exciseDuty,float,no"  tabindex="1" maxlength="15"/>
      </td>
      -->
      <td width="10%">
      <input type="text"  value="0" name="mrp"  id="<%=mrp%>"  onblur="gridCalculationNonLSOAdd(<%=inc%>);" validate="Tax,float,no" maxlength="15" tabindex="1" size="5"/>
      </td>
      <td width="3%">
      <input type="text"  value="0" name="<%=DISCOUNT_PERCENTAGE%>"  id="<%=discountVarTemp%>" onblur="gridCalculationNonLSOAdd(<%=inc%>);"  validate="Discount,float,no" maxlength="6" tabindex="1" size="4"/>
      <input type="hidden" class="medcaption" value="0" name="<%=DISCOUNT_AMOUNT%>" id="<%=discountAmount%>"/>
      </td>
 
      <td width="10%">
      <input type="text" class="medcaption" value="0" name="<%=TAX_PERCENT %>"  id="<%=taxVarTemp%>" onblur="gridCalculationNonLSOAdd(<%=inc%>);" validate="Tax,float,no" maxlength="15" tabindex="1" size="4"/>
      <input type="hidden" class="medcaption" value="0" name="<%=TAX_AMOUNT%>" id="<%=taxAmount%>"/>
           
           <%--<input type="hidden" class="medcaption" value="0" name="taxOq"  id="<%=taxOq%>"  validate="taxOq,float,no" maxlength="15" tabindex="1"/>
      <input type="hidden" class="medcaption" value="0" name="<%=SALES_TAX_AMOUNT%>" id="<%=taxAmount%>"/>
      -->
      </td>
      <!--
      <td width="10%">
      <input type="text" class="medcaption" value="0" name="otherTaxes"  id="<%=otherTaxes%>" onblur="gridCalculationNonLSOAdd(<%=inc%>);" validate="Tax,float,no" maxlength="25" tabindex="1"/>
      </td> --%>
           <td width="10%">
			<input type="text" value="0" name="<%=COST_PRICE %>" id="<%=costPrice%>" tabindex="1" size="5"/>
			</td>
        <td width="3%">
      <input type="text" class="medcaption" value="0" name="" id="<%=amountVarTemp%>" readonly="readonly" validate="Amount,float,no"  tabindex="1" size="6"/>
      <input type="hidden" class="medcaption" value="0" name="<%=AMOUNT%>"  id="<%=amountVar%>"/>
      </td>
      
      <%-- 
      <td width="10%">
      <select name="<%=FREE_ITEM %>" id="<%=freeItem %>"  tabindex="1" onChange="gridCalculationNonLSOAdd(<%=inc%>);">
	  <option value="n">No</option>
	  <option value="y">Yes</option>
      </select>
      </td>
       --%>
       
       
       </tr>
		<% }
	    		  }
     	    %>
		
	</tbody>
</table>
</div>
<%--
<label >Total Amount:</label> <input type="text"
	name="<%=TOTAL_AMOUNT %>" value="<%=netAmount==null?"0":netAmount%>"
	id="total_amount" readonly="readonly"> <input type="hidden"
	value="<%=netAmount==null?"0":netAmount%>" id="totalCarryForward">
<input type="hidden" value="<%=grn%>"
	name="received" id="received" /> <input type="hidden"
	value="<%=crvNo%>" name="crvNo" id="crvNo" />
	
	 --%>
	<input type="hidden" value="<%=pageTotal==null?"0":pageTotal%>"
	id="pageTotal"> 
	</div>
</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="rowSize" id="rowSize" value="0"/>
 <input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
<input type="button" name="update" align="right" class="button" value="Update" onclick="submitForm('purchaseGrid','neStores?method=updatePurchaseOrder');" />
<input type="button" name="delete" align="right" class="button"
	value="Delete"
	onclick="submitForm('purchaseGrid','neStores?method=deletePurchaseOrderItem');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" /></form>
</div>
<script>
function chkLength(field,maxLimit)
{
if(field.value.length > maxLimit)
{
 alert('Maximum Limit is '+maxLimit+' characters.');
 var val=field.value.substring(0,maxLimit);
 field.value=val;
}
}

</script>
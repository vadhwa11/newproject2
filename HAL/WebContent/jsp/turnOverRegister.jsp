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
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugM"%>
<%@page import="jkt.hms.masters.business.StoreCopyAddressList"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>

<%@page import="jkt.hms.util.RequestConstants"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

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

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
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
<style type="text/css" media="screen">
.selected {
	background-color: #888;
}
</style>

<% 
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	int entryId=0;	
	if(map.get("entryId")!=null){
		entryId=Integer.parseInt(""+map.get("entryId"));
	}	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<MasEmployee> enterdByList = new ArrayList<MasEmployee>();
	List<MasEmployee> authorisedList = new ArrayList<MasEmployee>();
	
			if(map.get("itemList") != null){
				itemList = (ArrayList) map.get("itemList");
				session.setAttribute("itemList",itemList);
			}else if(session.getAttribute("itemList") != null){
				itemList = (ArrayList)session.getAttribute("itemList");
				
			}
			if (map.get("authorisedList") != null) {
				authorisedList = (List<MasEmployee>)map.get("authorisedList");
			}
			if (map.get("enterdByList") != null) {
				enterdByList = (List<MasEmployee>)map.get("enterdByList");
			}
			if(map.get("itemList") != null){
				itemList = (ArrayList) map.get("itemList");
				session.setAttribute("itemList",itemList);
			}else if(session.getAttribute("itemList") != null){
				itemList = (ArrayList)session.getAttribute("itemList");
				
			}
			StoreDefectiveDrugM storeDefectiveObj = null;
			List<StoreIndentM> drugList = new ArrayList<StoreIndentM>();
			if(map.get("drugList") != null){
				drugList = (ArrayList) map.get("drugList");
				session.setAttribute("drugList",drugList);
			}else if(session.getAttribute("drugList") != null){
				drugList = (ArrayList)session.getAttribute("drugList");
				
			}
			
			List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
			if(map.get("brandList") != null){
				brandList = (ArrayList) map.get("brandList");
				session.setAttribute("brandList",brandList);
			}else if(session.getAttribute("brandList") != null){
				brandList = (ArrayList)session.getAttribute("brandList");
			}
			
			List<StoreDefectiveDrugM> searchDrugList= new ArrayList<StoreDefectiveDrugM>();
			if(map.get("searchDrugList")!=null)
				searchDrugList = (List) map.get("searchDrugList");
			
			List<StoreCopyAddressList> copyList = new ArrayList<StoreCopyAddressList>();
			if(map.get("copyList")!=null)
				copyList = (List) map.get("copyList");
			
			List<StoreGrnT> grnList = new ArrayList<StoreGrnT>();
			if(map.get("grnList")!=null)
				grnList = (List) map.get("grnList");
			
			String message="";
			if(map.get("message") != null){
				message = (String)map.get("message"); 
			}
		
			String userName = "";
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			
			List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
			if(map.get("manufacturerList")!=null)
				manufacturerList = (List) map.get("manufacturerList");
			
			
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
			
			String max="";
			if(map.get("max") != null){
				max = (String) map.get("max");
			}
			
			Set<StoreItemBatchStock> set1 = new HashSet<StoreItemBatchStock>();
			if (request.getAttribute("set1") != null) {
				set1 = (Set) request.getAttribute("set1");
				

			}
			String  batchId="batchId";
			%>
<script>
 var nameArray=new Array();
 var itemsArray1=new Array();
 var itemsArray2 = new Array();
 var manufacturerArray = new Array();
  var brandArray = new Array();
  
 function fillValuesInDefectiveDrug(inc)
  {

  	 	var quanRec = "quanRec";
  	 	authyDec = "authyDec";
  	 	var disposal ="disposal";
  	 	var remarks = "remarks";
    
    	var quanRecTemp = "quanRecTemp";
    	var authyDecTemp = "authyDecTemp";
  	 	var disposalTemp ="disposalTemp";
  	 	remarksTemp = "remarksTemp";
    	
    	
    	
    	document.getElementById(quanRec+inc).value=document.getElementById(quanRecTemp+inc).value
    	document.getElementById(authyDec+inc).value=document.getElementById(authyDecTemp+inc).value
    	if(document.getElementById(disposal+inc).value  != "" ){
    	document.getElementById(disposal+inc).value=document.getElementById(disposalTemp+inc).value
    	}else{
    	document.getElementById(disposal+inc).value=0;
    	}
    	if(document.getElementById(remarks+inc).value  != "" ){
    	document.getElementById(remarks+inc).value=document.getElementById(remarksTemp+inc).value
    	}else{
    	document.getElementById(remarks+inc).value=0;
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
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var manufacturerName  = item.getElementsByTagName("manufacturerName")[0];
	        var mId  = item.getElementsByTagName("mId")[0];
        	document.getElementById('manufacturerId'+rowVal).value = manufacturerName.childNodes[0].nodeValue
        	document.getElementById('manufacturerIdTemp'+rowVal).value = mId.childNodes[0].nodeValue
        	
      	} 
      }
    }
     url="stores?method=getManufacturerNameInAjax&brandId="+brandId;
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    
 }
 
 
  function getExpiryDateByAjax(batchId){
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
	        var expiryDate  = item.getElementsByTagName("expiryDate")[0];
	        var manufacturingDate=item.getElementsByTagName("manufacturingDate")[0];
	        var manufacturer=item.getElementsByTagName("manufacturer")[0];
	        var mId  = item.getElementsByTagName("mId")[0];
        	document.getElementById('expiryDate').value = expiryDate.childNodes[0].nodeValue
        	//document.getElementById('expiryDateTemp').value = expiryDate.childNodes[0].nodeValue
        	document.getElementById('manufactureDate').value = manufacturingDate.childNodes[0].nodeValue 
        	document.getElementById('manuf').value = manufacturer.childNodes[0].nodeValue  
        	  var itemLength = item.getElementsByTagName("values")[0];
        	for(innerLoop = 0;innerLoop < itemLength .childNodes.length;innerLoop++)
        	{
        		var item = itemLength .childNodes[innerLoop];
	        	var date  = item.getElementsByTagName("dt")[0];
	        	var docNo  = item.getElementsByTagName("docNo")[0];
	        	var recQty  = item.getElementsByTagName("recQty")[0];
	        	var IssuedQty  = item.getElementsByTagName("IssuedQty")[0];
	        	var closQty = item.getElementsByTagName("closQty")[0];
	        	document.getElementById('dt').value = date.childNodes[0].nodeValue 
	        	
	        	obj.length++;
				//obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
				//obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;
	        	
        	}  	
          	} 
      }
    }
    
     url="stores?method=getTurnOverData&batchId="+batchId;
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    
 }


  


  
 
  function checkForSubmit(){
  if(document.getElementById('noOfRows').value==0)
  {alert("There must be one detail row");
  return false;
  }else{
  return true;
  }
 
  }
</script>

<script language="javascript">

function checkForDefectiveDrugs(val,a)
{
	
		//var pageNo =parseInt(document.getElementById('pageNo').value) 
		//var start=((pageNo-1)*8)+1;
    	//var end=((pageNo-1)*8)+8;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    var inc =1
	   // alert("checkForDefectiveDrugs"+pvms);
	    ajaxFunctionForAutoCompleteInTurnOver('grnGrid','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);
		
}


function checkForDefectiveDrugsPvsm(val)
{
		
	    var inc =1
	   // alert("checkForDefectiveDrugs"+pvms);
	    ajaxFunctionForAutoCompleteInTurnOverPvsm('grnGrid','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + val , inc);
		
}


// javed  for Turn over Register 
function ajaxFunctionForAutoCompleteInTurnOverPvsm(formName,action) {
 var xmlHttp;
   var f=formName;
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
     
     	//var brandId="brandId";
     	var batchId="batchId";
		//obj1 =document.getElementById(brandId); 
     	if(f=="grnGrid"){
		obj = document.getElementById(batchId);
		obj.length = 1;
     	}
		//obj1.length =1;
		
     	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	   	 var nomen  = item.getElementsByTagName("nomen")[0];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var name  = item.getElementsByTagName("name")[0];
	        var brandLength  = item.getElementsByTagName("brands")[0];
	         var batchLength  = item.getElementsByTagName("batchsForTurn")[0];
       	document.getElementById('codeItem1').value = pvms.childNodes[0].nodeValue
       	document.getElementById('idItem1').value = id.childNodes[0].nodeValue
       	document.getElementById('idAu1').value = au.childNodes[0].nodeValue
       	document.getElementById('nameItem1').value = nomen.childNodes[0].nodeValue+" ["+pvms.childNodes[0].nodeValue +"]"
       	
       	
       	
       	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
       	{
       		var batch = batchLength.childNodes[innerLoop];
	        	var batchId  = batch.getElementsByTagName("batchIdForTurn")[0];
	        	var batchName  = batch.getElementsByTagName("batchNameForTurn")[0];
	        	obj.length++;
				obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;
	        	
       	}
      
       	/* for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++){
       		var brand = brandLength.childNodes[innerLoop];
	        	var brandId  = brand.getElementsByTagName("brandId")[0];
	        	var brandName  = brand.getElementsByTagName("brandName")[0];
	        	
	        	obj1.length++;
				obj1.options[obj1.length-1].value=brandId.childNodes[0].nodeValue;
				obj1.options[obj1.length-1].text=brandName.childNodes[0].nodeValue;
	        	
       	}*/
       		
     	} 
     }
   }
   var url=action+"&"+getNameAndData(formName)
    
   xmlHttp.open("GET",url,true);
   xmlHttp.setRequestHeader("Content-Type", "text/xml");
   xmlHttp.send(null);
   
   
 }
  
 </script>

<div class="titleBg">
<h2>Turn over register</h2>
</div>


<form name="grnGrid" method="post">
<div class="clear"></div>

<div class="clear"></div>
<div class="Block">
<%String nameItem1="nameItem1" ;
String codeItem1="codeItem1";
String idItem1="idItem1";
String idAu1="idAu1";
//String  batchId="batchId";
String  brandId="brandId";
%>


		<label >PVMS/ NIV No.</label>
			<input type="text" size="5" name="<%=ITEM_CODE %>" validate="PVMS/NIV NO.,alphanumeric1,no"  id="<%=codeItem1%>"  onblur="checkForDefectiveDrugsPvsm(this.value);"/> 
				<input type="hidden" size="2" value="0" name="<%=ITEM_ID%>" id="<%=idItem1%>" />
				
	
		<label >Nomenclature</label>
			<input type="text" value="" name="<%=nameItem1%>" id="<%=nameItem1%>" onblur="checkForDefectiveDrugs(this.value, '<%=nameItem1%>');"
			 />
			<div id="ac2update"	style="display: none;" class="autocomplete">
			</div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  		new Ajax.Autocompleter('<%=nameItem1%>','ac2update','stores?method=getItemListForTurnOverByAutocomplete',{parameters:'requiredField=<%=nameItem1%>'});
			</script>
			<label>A/ U</label>
			<input type="text" size="5" value="" readonly="readonly" name="<%=AV%>" id="<%=idAu1%>" tabindex="1" />
			
				<label>Batch No.</label>
			<!-- <select name="<%=BATCH_ID%>" id="<%=batchId%>"	onchange="getExpiryDateByAjax(this.value);" tabindex="1">-->
			<select name="<%=BATCH_ID%>" id="<%=batchId%>"	onChange="submitProtoAjax('grnGrid','stores?method=getTurnOverData&batchId='+document.getElementById('<%=batchId%>').value);" tabindex="1">
				<option value="0">Select</option>
			</select>
		
			<div id="testDiv">
			</div>


</form>

<div class="clear"></div>


<!--</fieldset>-->
<div class="clear"></div>
<!--  <input type="button"
	name="sss" align="right" class="button" value="Submit"
	onclick="if(checkSave()&& checkForSubmit()){submitForm('grnGrid','stores?method=submitDefectiveDrug');}" />-->
<!--	<input-->
<!--					type="hidden" name="Add" type="submit" value="Add"-->
<!--					class="button" onClick="submitForm('createGrn','stores?method=showDefectiveDrugJsp');">-->
<!--  <input type="hidden" id="addbutton" name="Add" value="Add"	class="button"
					onClick="submitForm('createGrn','stores?method=showDefectiveDrugJsp');">-->
<!--  <input type="button" name="Reset" type="submit" value="Reset"	class="button">-->
<!--				<input-->
<!--					type="hidden" name="Delete" value="Delete"-->
<!--					class="button">-->
<!--				<input-->
<!--					type="button" name="print" type="submit" class="button"-->
<!--					value="Print"-->
<!--					onClick="submitForm('createGrn','stores?method=showDefectiveDrugReportJsp');">-->


<!-- 
<div class="bottom">
 
<label>Changed By:</label>   
			<label class="value"><%=userName%></label>
        
			<label>Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label>Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
 </div>  -->
 <script
	type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" /> 




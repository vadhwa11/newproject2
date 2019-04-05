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
<script type="text/javascript">
function selectAll()
{
	var len=document.getElementById('val').value;
	for(int i=0;i<len;i++)
	{
	 var inc=all+i;
	 alert(inc);
	 document.getElementById(inc).checked = true;
	}
}
</script>
<!--

//-->
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
				System.out.println("max  "+max);
			}
			
			Set<StoreItemBatchStock> set1 = new HashSet<StoreItemBatchStock>();
			if (request.getAttribute("set1") != null) {
				set1 = (Set) request.getAttribute("set1");
				

			}
			int cinc=0;
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
 
 
  function getExpiryDateByAjax(batchId,rowVal){
 

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
	        var mId  = item.getElementsByTagName("mId")[0];
        	document.getElementById('expiryDate'+rowVal).value = expiryDate.childNodes[0].nodeValue
        	document.getElementById('expiryDateTemp'+rowVal).value = expiryDate.childNodes[0].nodeValue
        	
      	} 
      }
    }
     url="stores?method=getExpiryDateInAjax&batchId="+batchId;
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

function checkForDefectiveDrugs(val,a,inc)
{
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    
	   
		ajaxFunctionForAutoCompleteInDefectiveDrugs('grnGrid','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);
		
}
  
 </script>

<div class="titleBg">
<h2>PROFORMA LP Details</h2>
</div>

<form name="createGrn" method="post" action="">
<!--<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">-->
<div class="clear"></div>
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<!--<form name="searchPanel" method="post">
--><div class="searchBlock" id="threadsearch_menu" style="display: none">

<label>From Date  </label> 
<input type="text" name="<%= FROM_DATE %>" MAXLENGTH="30" class="date" tabindex=1 /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.createGrn.<%= FROM_DATE%>,event)" />
<label>To Date  </label> 
<input type="text" name="<%= TO_DATE %>" MAXLENGTH="30" class="date" tabindex=1 /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
			onClick="setdate('<%=currentDate%>',document.createGrn.<%= TO_DATE%>,event)" />

<div class="clear"></div>
<label >Defective Drug No </label> 
<select
			name="<%=ENTRY_NO%>">
			<%
					for (StoreDefectiveDrugM storeDefectiveDrugM :searchDrugList ) {
				%>

			<option value=<%=storeDefectiveDrugM.getEntryNo()%>><%=storeDefectiveDrugM.getEntryNo()%></option>

			<%
					}
				%>

</select> 
<input type="image" class="button" value="" onClick="submitForm('createGrn','stores?method=searchDefectiveDrug');" />

</div>
</form>

<jsp:include page="searchResultBlock.jsp" />

<form name="grnGrid" method="post">
<div class="clear"></div>
<h4>PROFORMA B(SO DETAILS)</h4>
<div class="clear">
</div>
<div class="Block">
	<label>SO NO<span>*</span></label>
	<input type="text" name="soNo" id="so_no"  />
	<input type="button" name="sss" align="right" class="button" value="IMPORT LP" onclick="getsoexcelitems();"/>
</div>

<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> 

<input type="hidden" name="deptId" value="<%=deptId%>" /> 

<input type="hidden" value="toplace" name="<%=TO_PLACE %>" validate="to Place  ,String,yes" tabindex=1/> 
			
<input type="hidden" class="button" name="<%=CREATE_ADJUSTMENT %>" value="Adjust"
	onclick="submitFormForButton('grnGrid','stores?method=createAdjustment');" />
<input type="hidden" Page No: <%=pageNo%> /> <input type="hidden"
	size="2" value="0" name="<%=NO_OF_ROWS %>" id="<%=NO_OF_ROWS %>" /> <input
	type="hidden" name="<%=ENTRY_ID %>" value="<%=entryId%>" id="hdb" /> 
	<div class="clear"></div>
<div class="clear"></div>
<input type="button" name="sss" align="right" class="button" value="ADD" onclick="if(checkSave()&& checkForSubmit()){submitForm('grnGrid','stores?method=submitDefectiveDrug');}" />
<input type="button" name="sss" align="right" class="button" value="CLOSE" onclick="if(checkSave()&& checkForSubmit()){submitForm('grnGrid','stores?method=submitDefectiveDrug');}" />
<input type="button" name="sss" align="right" class="button" value="SELECT ALL" onclick="selectAll();" />

<div class="clear"></div>
<h4>SO ITEM DETAILS</h4>
<div class="clear"></div>
<div class="clear"></div>
<!--<div style="width: 15px; float: left;"><img-->
<!--	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>-->



<div class="cmntable">
<table width="200px" colspan="7" id="grnDetails" 
	border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="5%">SR No</th>
			<th width="8%">PVMS No</th>
			<th width="9%">Nomenclature</th>
			<th width="9%">A/U</th>
			<th width="9%">Batch</th>
			<th width="9%">Brand Name</th>
			<th width="9%">Manufacturer</th>
			<th width="9%">Expiry Date</th>
			
			<th width="9%">Quantity</th>
			<th width="9%">Add</th>
			<!-- -For Smc
			<td width="15%"><label>Authy</label></td>
			<td width="15%"><label>Disposal</label></td>
			<td width="9%"><label>Remarks</label></td> -->
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
    	String idManufacturer="idManufacturer";
    	String idAu="idAu";
    	String batchNo="batchNo";
    	String batchNoTemp="batchNoTemp";
    	String quanRec="quanRec";
    	String quanRecTemp="quanRecTemp";
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
    	String manufacturingDate="manufacturingDate";
    	String expiryDate="expiryDate";
    	String manufacturerId="manufacturerId";
    	String lotNo="lotNo";
    	String shelfLife="shelfLife";
    	String expiry ="expiry";
    	String nameManufacturer="nameManufacturer";
    	String remarks ="remarks";
    	String disposal ="disposal";
    	String remarksTemp="remarksTemp";
    	String authyDecTemp="authyDecTemp";
    	String authyDec="authyDec";
    	String disposalTemp ="disposalTemp";
    	String expiryDateTemp="expiryDateTemp";
    	String brandId="brandId";
    	String batchId="batchId";
    	String manufacturerIdTemp="manufacturerIdTemp";
    	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idSection2="idSection";
    	String nameBrand2="nameBrand";
    	String idBrand2="idBrand";
    	String idAu2="idAu";
    	String freeItem2="freeItem";
    	String manufacturingDate2="manufacturingDate";
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
    	String shelfLife2 ="shelfLife";
    	String expiry2="expiry";
    	String remarks2 ="remarks";
    	String disposal2="disposal";
    	String remarksTemp2="remarksTemp";
    	String authyDecTemp2="authyDecTemp";
    	String authyDec2="authyDec";
    	String disposalTemp2="disposalTemp";
    	String idManufacturer2="idManufacturer";
    	String expiryDateTemp2="expiryDateTemp";
    	String brandId2="brandId";
    	String batchId2="batchId";
    	String manufacturerIdTemp2="manufacturerIdTemp";
    	
    	String nameManufacturer2="nameManufacturer";
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
     		unitRateVar=unitRateVar2+(""+inc);
     		discountVar=discountVar2+(""+inc);
     		amtVar=amtVar2+(""+inc);
     		batchNo=batchNo2+(""+inc);
     		batchNoTemp=batchNoTemp2+(""+inc);
     		lotNo=lotNo2+(""+inc);
     		quanRec=quanRec2+(""+inc);
     		quanRecTemp=quanRecTemp2+(""+inc);
     		authyDecTemp=authyDecTemp2+(""+inc);
     		taxVarTemp=taxVarTemp2+(""+inc);
     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
     		discountVarTemp=discountVarTemp2+(""+inc);
     		amtVarTemp=amtVarTemp2+(""+inc);
     		stockInVarTemp=stockInVarTemp2+(""+inc);
     		mmfVarTemp=mmfVarTemp2+(""+inc);
     		demandVarTemp=demandVarTemp2+(""+inc);
     		idManufacturer=idManufacturer2+(""+inc);
     		batchId = batchId2+(""+inc);
     		
     		incVar=incVar2+(""+inc);
     		freeQty=freeQty2+(""+inc);     		
     		freeItem=freeItem2+(""+inc);
     		manufacturingDate=manufacturingDate2+(""+inc);
     		expiryDate=expiryDate2+(""+inc);
     		manufacturerId=manufacturerId2+(""+inc);
     		shelfLife = shelfLife2+(""+inc);
     		expiry = expiry2+(""+inc);
     		remarks = remarks2+(""+inc);
     		remarksTemp =remarksTemp2+(""+inc);
     		nameManufacturer=nameManufacturer2+(""+inc);
     		disposal = disposal2+(""+inc);
     		disposalTemp = disposalTemp2+(""+inc);
     		authyDec = authyDec2+(""+inc);
     		expiryDateTemp =expiryDateTemp2+(""+inc);
     		brandId = brandId2+(""+inc);
     		batchId=batchId2+(""+inc);
     		manufacturerIdTemp = manufacturerIdTemp2+(""+inc);
			cinc++;
     		
    	  %>
		<tr>
			
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" size="5" name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> 
				<input type="hidden" size="2" value="0" name="<%=ITEM_ID%>" id="<%=idItem%>" />
			</td>
			<td width="10%">
			<input type="text" value="" id="<%=nameItem%>" 
			onblur="if(fillSrNo('<%=inc %>')){checkForDefectiveDrugs(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update"	style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});
		</script></td>
			<td width="10%">
			<input type="text" size="5" value="" readonly="readonly" name="<%=AV%>" id="<%=idAu%>" tabindex="1" />
			<input type="hidden" value="0"  name="<%=EXPIRY%>" id="<%=expiry%>" /></td>
				
			<td width="10%">
			    <select name="<%=BATCH_ID%>" id="<%=batchId%>"	onchange="getExpiryDateByAjax(this.value,<%=inc%>);" tabindex="1">
				<option value="0">Select</option>
			</select></td>

			<td width="10%">
			<select name="<%=BRAND_ID%>" id="<%=brandId%>" onchange="getManufacturerNameByAjax(this.value,<%=inc%>);"
				tabindex="1"><option value="0">Select</option>
						</select></td>

			<td width="10%"><input id="<%=manufacturerId %>" value="" tabindex="1" name="<%=MANUFACTURER_NAME %>"/>
			 <input	type="hidden" name="<%=MANUFACTURER_ID %>" value="0" id="<%=manufacturerIdTemp %>" tabindex="1" />
			</td>

			<td width="10%"><input id="<%=expiryDate %>" value="" size="16"
				onblur="fillExpForDefectiveDrug(<%=inc%>)" /> <input type="hidden"
				value="abc" id="<%=expiryDateTemp %>" name="<%=EXPIRY_DATE%>"
				tabindex="1" /></td>

			<td width="10%"><input type="text" value="" 
				name="" id="<%=quanRecTemp%>"
				onblur="fillQuanForDefectiveDrug(<%=inc%>)" tabindex="1" /> 
				<input type="hidden" value="0" name="<%=QUANTITY_RECEIVED%>" id="<%=quanRec%>" tabindex="1" /></td>
		
<!--
			<td width="10%"><input type="text" value="" 
				name="" id="<%=authyDecTemp%>" tabindex="1" maxlength="15"
				onblur="fillAuthyForDefectiveDrug(<%=inc%>)" /> <input type="hidden"
				value="0"  name="<%=AUTHY_UNDER_DECLARED %>"
				tabindex="1" id="<%=authyDec%>" /></td>


			<td width="10%"><input type="text" value="" 
				name="" id="<%=disposalTemp%>" tabindex="1" maxlength="15"
				onblur="fillDisposalForDefectiveDrug(<%=inc%>)" /> <input
				type="hidden" value="emptyString1" 
				name="<%=DISPOSAL %>" tabindex="1" id="<%=disposal%>" /></td>
			<td width="10%"><input type="text" value="" 
				name="" id="<%=remarksTemp%>" tabindex="1" maxlength="15"
				onblur="fillValuesInDefectiveDrug(<%=inc%>);" /> <input
				type="hidden" value="emptyString2" 
				name="<%=REMARKS %>" tabindex="1" id="<%=remarks%>" /></td> -->
				
				
		 	<td>
			<input type="checkbox" id="all<%=inc%>" />
				
			</td>
		</tr>
		<%
     	 }  
     	 %>
     	
	</tbody>
</table>
</div>
</form>

<!--</fieldset>-->
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<!--	<input-->
<!--					type="hidden" name="Add" type="submit" value="Add"-->
<!--					class="button" onClick="submitForm('createGrn','stores?method=showDefectiveDrugJsp');">-->


<!--				<input-->
<!--					type="hidden" name="Delete" value="Delete"-->
<!--					class="button">-->
<!--				<input-->
<!--					type="button" name="print" type="submit" class="button"-->
<!--					value="Print"-->
<!--					onClick="submitForm('createGrn','stores?method=showDefectiveDrugReportJsp');">-->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label>   
			<label class="value"><%=userName%></label>
        
			<label>Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label>Changed Time:</label>   
			<label class="value"><%=time%></label>
			 <input type="hidden" id="val" value="<%=cinc%>"/>
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
			
 </div>  
 <script
	type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" /> 


</form>

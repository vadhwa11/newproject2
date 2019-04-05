
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>


<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.util.HMSUtil"%>
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
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

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
    	}  }
  

    function checkForNext(){
  if(document.getElementById('noOfRows').value<10)
  {
  	alert("All rows are not filled.To continue press Submit ")
  	return false;
  }else{
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
function get_value(rowNo)
{
 var url="/hms/hms/stores?method=showInfoOfGrnJsp&rowNo="+rowNo;
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
</script>

<form name="grnGrid" method="post">


<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">GRN</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div id="gridDiv">


<div
	style="overflow: auto; width: 100%; height: 325px; padding-left: 9px; BORDER: #9A9A9A 1px solid;"">
<table width="98%" colspan="7" id="grnDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="8%"><label valign="left" class="smalllabel">PVMS/NIV
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="9%"><label valign="left" class="smalllabel">Brand
			Name</label></td>
			<td width="9%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="9%"><label valign="left" class="smalllabel">Batch
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Lot
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Quan
			Rec</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Unit
			Rate</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Disc(%)</label>
			</td>
			<td width="9%"><label valign="left" class="smalllabel">Tax(%)</label>
			</td>
			<td width="9%"><label valign="left" class="smalllabel">Amt
			Value</label></td>
			<td width="9%"><label valign="left" class="smalllabel"></label>
			</td>
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
    	String manufacturingDate="manufacturingDate";
    	String expiryDate="expiryDate";
    	String manufacturerId="manufacturerId";
    	String lotNo="lotNo";
    	String shelfLife="shelfLife";
    	String expiry ="expiry";
    	String brandId ="brandId";
    	
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
    	String brandId2="brandId";
    	// if(pageNo!=1)
    	//{
    	//	temp=detailCounter*(pageNo-1);
    	//} 
    	//
     	 for(int inc=1;inc<=10;inc++)
     	 {
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
     		manufacturingDate=manufacturingDate2+(""+inc);
     		expiryDate=expiryDate2+(""+inc);
     		manufacturerId=manufacturerId2+(""+inc);
     		shelfLife = shelfLife2+(""+inc);
     		expiry = expiry2+(""+inc);
     		brandId =brandId2+(""+inc);
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
				onblur="if(fillSrNo('<%=inc %>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
		</script></td>
			<td width="10%"><select name="<%=BRAND_ID%>" id="<%=brandId%>">
				<option value="">Select</option>
			</select></td>

			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=AV%>" id="<%=idAu%>" tabindex="1" /> <input
				type="hidden" value="0" class="smcaption" name="<%=EXPIRY%>"
				id="<%=expiry%>" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=BATCH_NO_TEMP %>" id="<%=batchNoTemp%>" tabindex="2"
				maxlength="10" onblur="fillBatchForGrn(<%=inc%>)" /> <input
				type="hidden" value="emptyString" class="medcaption"
				name="<%=BATCH_NO %>" tabindex="2" id="<%=batchNo%>" /></td>


			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=LOT_NO_TEMP %>" id="<%=lotNoTemp%>" tabindex="2"
				maxlength="10" onblur="fillLotForGrn(<%=inc%>)" /> <input
				type="hidden" value="emptyString1" class="medcaption"
				name="<%=LOT_NO %>" tabindex="2" id="<%=lotNo%>" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				name="" id="<%=quanRecTemp%>" tabindex="2" maxlength="15"
				validate="Quantity,float,no" /> <input type="hidden" value="0"
				class="medcaption" name="<%=QUANTITY_RECEIVED %>" tabindex="2"
				id="<%=quanRec%>" /></td>
			<td width="3%"><input type="text" class="medcaption" value=""
				name="" tabindex="2" id="<%=unitRateVarTemp%>" maxlength="15"
				onblur="calculateAmountInGrn(<%=inc%>);"
				validate="Unit Rate,float,no" /> <input type="hidden"
				class="medcaption" value="0" name="<%=UNIT_RATE%>" tabindex="2"
				id="<%=unitRateVar%>" /></td>

			<td width="3%"><input type="text" class="medcaption" value=""
				name="" tabindex="2" id="<%=discountVarTemp%>" maxlength="15"
				onblur="calculateAmountInGrn(<%=inc%>);"
				validate="Discount,float,no" /> <input type="hidden"
				class="medcaption" value="0" name="<%=DISCOUNT_PERCENTAGE%>"
				tabindex="2" id="<%=discountVar%>" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="" tabindex="2" id="<%=taxVarTemp%>" maxlength="15"
				onblur="calculateAmountInGrn(<%=inc%>);" validate="Tax,float,no" />
			<input type="hidden" value="0" class="medcaption"
				name="<%=TAX_PERCENT %>" tabindex="2" id="<%=taxVar%>" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="" tabindex="2" id="<%=amtVarTemp%>" readonly="readonly"
				onblur="fillValuesInGrn(<%=inc%>);" /> <input type="hidden"
				value="0" class="medcaption" name="<%=AMOUNT%>" tabindex="2"
				id="<%=amtVar%>" /> <input type="hidden" value="0"
				name="<%=FREE_QTY %>" id="<%= freeQty %>" /> <input type="hidden"
				value="0" name="<%=MANUFACTURING_DATE %>"
				id="<%=manufacturingDate %>" /> <input type="hidden" value="0"
				name="<%=EXPIRY_DATE %>" id="<%=expiryDate %>" /> <input
				type="hidden" value="0" name="<%=MANUFACTURER_ID %>"
				id="<%=manufacturerId %>" /> <input type="hidden" value="0"
				name="<%=FREE_ITEM %>" id="<%=freeItem %>" /></td>

			<td width="3%"><input type="button"
				onclick="get_value(<%=temp+inc%>);" name="Submit2" value=""
				class="morebutton" /></td>
		</tr>
		<% } %>
	</tbody>
</table>
<br />
</div>
</div>

<div style="padding-left: 730px;"><label class="bodytextB"></font>CRV
Value</label> <input type="text" name="<%=GRN_VALUE %>" id="<%=GRN_VALUE %>"
	value="" class="textbox_size20" style="width: 85px;" MAXLENGTH="15" />
</div>
</div>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreLoaninM"%>
<%@page import="jkt.hms.masters.business.StoreLoaninT"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.math.MathContext"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
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
<script>
function checkDate(inc){
var date=document.getElementById("currdate").value;
alert("date>>>>>>>>>>>>>>>>>>"+date);
var manuDate=document.getElementById("manufacturingDate"+inc).value;
alert("manuDate>>>>>>>>>>>>>>>>>>"+manuDate);
	if(manuDate >date )
	{
		alert ("Manufacture Date is Invalid .")
		return false;
	}
}
</script>
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

function fillSrNo(rowVal){
	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%30
   		if(rowVal==0){
   			rowVal=30
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}

</script>
<%
Map map = new HashMap();
String choice = "";
Map<String, Object> utilMap = new HashMap<String, Object>();
List<StoreIndentT> indentTList = new ArrayList<StoreIndentT>();
List<MasManufacturer> manufactureList = new ArrayList<MasManufacturer>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
if(map.get("choice") != null){
	choice = (String)map.get("choice");
	System.out.println("choice::::::"+choice);
}

if(map.get("indentTList") != null){
	indentTList = (List<StoreIndentT>)map.get("indentTList");
	System.out.println("indentTList::::::"+indentTList.size());
}

if(map.get("manufactureList") != null){
	manufactureList = (List<MasManufacturer>)map.get("manufactureList");
	System.out.println("v::::::"+manufactureList.size());
}

int numberOfRecordsInLoanIn = 0;
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String currentTime = (String)utilMap.get("currentTime");


String idItem="idItem";
String codeItem="codeItem";
String nameItem="nameItem";
String idAu="idAu";
String idBrand="idBrand";
String dispenseType = "dispenseType";
String mdq = "mdq";
String ratePerMdq = "ratePerMdq";
String quantityInVar="quantityInVar";
String taxVar="taxVar";
String amountVar="amountVar";
String unitRateVar="unitRateVar";
String discountVar="discountVar";
String idSection="idSection";
String costPrice ="costPrice";
String freeQty="freeQty";
String manufacturerId="manufacturerId";
String manufacturerId1="manufacturerId1";
String freeItem="freeItem";
String manufacturingDate="manufacturingDate";
String expiryDate="expiryDate";
String brandId="brandId";
String nameBrand="nameBrand";
String batchNo="batchNo";
String quanRec="quanRec";
String amtVar="amtVar";
String stockInVarTemp="stockInVarTemp";
String lotNo="lotNo";
String shelfLife="shelfLife";
String expiry ="expiry";
String amcStartDate="amcStartDate";
String warrantyDate="warrantyDate";
String installationDate="installationDate";
String vatTax="vatTax";
String convertedStock = "convertedStock";
String formula = "formula";
String conversionFactor = "conversionFactor";
String discountAmount = "discountAmount";
String taxAmount = "taxAmount";
String ed = "ed";
String WarrantyEndDate ="WarrantyEndDate";
%>



<div id="gridDiv">
<div class="clear paddingTop15">
<div class="Block">
<!--  
<label > Total VAT Amt </label>
<input type="text"	name="vatTax" id="vatTax" value=""	MAXLENGTH="15" validate="Total VAT,float,no"	onblur="calculationInCRV()" tabindex="2" />
<label>Total Discount </label>
<input type="text" name="totDiscount" id="totDiscount"	value="" MAXLENGTH="15"	validate="Total Discount,float,no" onblur="calculationInCRV()"	tabindex="2" />
<label> CRV Value </label>
<input	type="text" name="grnValue" id="grnValue" value=""	MAXLENGTH="15" tabindex="2" />
<label> Round Off Value </label>
<input type="text"	name="roundOfValue" id="roundOfValue" value=""	MAXLENGTH="15" tabindex="2" />
<input	type="hidden" name="actualGrnValue" id="actualGrnValue" value="" />
<label>VAT Added</label>
<input type="checkbox"	name="vatApplicable" id="vatApplicable" value="1"	onClick="calculationInCRV();" />
-->
</div>
</div>
<input type="hidden" name="currDate" id="currdate" value="<%=currentDate %>"  />
<h4>CRV</h4>
<div class="Clear"></div>


<div STYLE=" height:400px; width: 1000px; font-size: 12px; overflow: auto;">
<table width="98%" colspan="7" id="grnDetails" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>PVMS/NIV No.</th>
			<th>Nomenclature</th>
			<th>A/U</th>
			<th>Serial No.</th>
			<th>Company Name</th>
			 <th>Qty Received</th>
			 <th>MRP</th>
			<th>Cost</th>
			<th>Disc(%)</th>
			<th>Total</th>
			<th>Reason for Demand</th>
			<th width="5%" colspan="2" >DOM</th>
			<th width="5%" colspan="2" >Warranty Start Date</th>
			<th width="5%" colspan="2" >Warranty End Date</th>
			<th width="5%" colspan="2" >AMC Start Date</th>
			<!--  
			<th width="16%">Add</th>
			<th width="16%">Delete</th>
			-->
		</tr>
	</thead>
	
	<tbody>

	

		<% // Code for Adding Empty Rows
		int inc=0;
	for(int t=inc+1;t<20; t++)
	{
    %>
		<tr>
		<input type="hidden" 	value="" name="convertedStock"	id="<%=convertedStock+""+t%>" readonly="readonly" />
			<td width="5%"><input type="text" size="2" value="<%=t%>"	name="<%=SR_NO%>" readonly="readonly" tabindex="1"/></td>
			<td ><!--<input type="text"  name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem+""+t%>" />	-->
			<input type="text"  size="10" name="<%=ITEM_CODE %>"	id="<%=codeItem+""+t%>"	onblur="autocompleteBasedOnPvms(this.value,'<%=t%>');"	validate="PVMS No,String,no" tabindex="1" tabindex="1"/>
			<input type="hidden" name="flag" value="Grn" /> <input type="hidden" size="2" 	name="<%=ITEM_ID%>" id="<%=idItem+""+t%>" />
			<input	type="hidden" name="<%=DETAIL_ID %>" value="0" id="hdb" />
			<input type="hidden" value="" name="" id="<%=expiry+""+t%>" />
			<input type="hidden" value=""	name="" id="<%=formula+""+t%>" />
			<input	type="hidden" value="" name=""	id="<%=conversionFactor+""+t%>" />
			<input type="hidden" name="loanInItem" value="No" id="loanInItem" />
			</td>

			<td width="10%">
			
			
			<input type="text" value="" id="<%=nameItem+""+t%>" size="30"
				onblur="if(fillSrNo('<%=t%>')){checkForGrn(this.value, '<%=nameItem%>','<%=t%>');}"
				
				name="<%=nameItem%>" tabindex="1" />
				
			<div id="ac2update"	style="display: none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem+""+t%>','ac2update','neStores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&sourceOfSupply= '+document.getElementById('sourceCombo').value});
		
		</script> 
		</td>


			<td width="10%">
			<input type="text" size="6" value="" readonly="readonly" tabindex="1" name="<%=AV%>" id="<%=idAu+""+t%>" />
			</td>
			
			<td width="10%">
			<input type="text" size="7" value="" name="<%=BATCH_NO %>" tabindex="1" id="<%=batchNo+""+t%>"	maxlength="25" />
			</td>
			
			<%--
			<td width="10%">
				<input type="text" value=""  name="<%=LOT_NO %>"	tabindex="1" id="<%=lotNo+""+t%>" maxlength="50" />
			</td>
			 --%>
			 
			 <td width="10%">
			<select name="manufacturer" id=<%=manufacturerId+""+t%> tabindex="1" onchange="getManufId(this.value,<%=t%>);">
				<option value="">Select</option>
				<% for(MasManufacturer mm : manufactureList){ %>
				<option value="<%=mm.getId() %>"><%=mm.getManufacturerName() %></option>
				<%} %>
			</select>
				<input type="hidden" size="10" name="<%=MANUFACTURER_ID%>"  id=<%=manufacturerId1+""+t%> value="0"/> 
			</td>
			
			 
			<td width="10%">
			<input type="text"  size="9" value="" name="<%=QUANTITY_RECEIVED %>" tabindex="1" id="<%=quanRec+""+t%>"	onblur="calculationInCRV();" />
			</td>
			
			<td width="10%">
			<input type="text" size="4"  value="" name="mrp" id="mrp<%=inc%>" tabindex="1"	onblur="calculationInCRV()" onkeypress="return isNumberKey(event)"/>
			</td>
			
			<td width="10%">
			<input type="text"  size="4" value="" name="<%=UNIT_RATE %>" id="<%=ratePerMdq+""+t%>" tabindex="1"	onblur="calculationInCRV()" onkeypress="return isNumberKey(event)">
			</td>
			
			
			<td>
			<input size="5" type="text"  value="0" name="<%=DISCOUNT_PERCENTAGE%>" tabindex="1"	id="<%=discountVar+""+t%>" onblur="calculationInCRV(); calculateTotalCrvAmount(<%=t %>)"		validate="Discount,float,no" />
			<input type="hidden" value="" name="discountAmount"	id="<%=discountAmount+""+t%>" />
			</td>
			
			
			<%--
			<td width="10%">
			<input type="text" name="<%=TAX_PERCENT %>" value="0" tabindex="1" id="<%=taxVar+""+t%>"	onblur="calculationInCRV();" validate="Tax,float,no" />
			<input	type="hidden"  value="" name="taxAmount"	id="<%=taxAmount+""+t%>" />
			</td>
			 --%>
			
			<td width="10%">
			<input type="hidden"   value="0"	 name="<%= COST_PRICE %>" id="<%=costPrice+""+t%>" />
			<input type="text" size="7" value="0"  name="<%=AMOUNT%>"	id="<%=amtVar+""+t%>" readonly="readonly" onblur="calculateTotalCrvAmount(<%=t %>)"
			/>
			</td>
			
			<td width="10%">
			<input type="text" size="18" 	name="reasonForDemand" id="reasonForDemand<%=inc %>"  value=""tabindex="1" onblur="calculateTotalCrvAmount(<%=t %>)" />
			</td>
			
			
			<%--
			<td width="10%">
			<input type="text" value="0"	name="<%=FREE_QTY %>" id="<%=freeQty+""+t %>" tabindex="1" onblur="calculationInCRV()" />
			</td>
			 --%>
			
			<td>
			<input type="text"	size="9" name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate+""+t%>"	tabindex="1" readonly="readonly" onblur="checkDate(<%=t%>)"/>
			
			</td>
			
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+t%>'),event);" />
			</td>

<%--
			<td>
			<input type="text" size="10" name="<%=EXPIRY_DATE%>" id="<%=expiryDate+""+t %>" tabindex="1" readonly="readonly" />
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+t %>'),event);" />
			</td>
	
	 --%>		
			 <td>
			<input type="text" size="9" name="WarrantyDate" id="<%=warrantyDate+""+t %>" tabindex="1" readonly="readonly" />
			
			</td>
			
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=warrantyDate+""+t %>'),event);" />
			
			</td>
	
	 		<td>
			<input type="text" size="9" name="WarrantyEndDate" id="<%=WarrantyEndDate+""+t %>" tabindex="1" readonly="readonly" onblur="checkWarantyDate(<%=t%>)"/>
			
			</td>
			
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=WarrantyEndDate+""+t %>'),event);" />
			
			</td>
			
			
			 
			<td>
			<input type="text" size="9" name="AmcStartDate" id="<%=amcStartDate+""+t %>" tabindex="1" readonly="readonly"  onblur="checkAmc(<%=t%>)" />
			
			</td>
			
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=amcStartDate+""+t %>'),event);" />
			
			</td>
	<!-- 		
<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grnDetails','hdb',this);" tabindex="1" />
			</td>
			

			-->
			
<%--
			<td>
			<select name="<%=FREE_ITEM %>"	id="<%=freeItem+""+t%>" class="small" onChange="">
				<option value="n">No</option>
				<option value="y">Yes</option>
			</select>
			</td>
 --%>
			
		</tr>
		<% } // Code for Adding Empty Rows Ends Here 
		%>
		
	


	</tbody>
</table>
</div>
</div>





<SCRIPT language=Javascript>

function isNumberKey(evt)
{
var charCode = (evt.which) ? evt.which : event.keyCode
if (charCode > 31  && (charCode < 46 || charCode > 57))
return false;

return true;
}

</SCRIPT>
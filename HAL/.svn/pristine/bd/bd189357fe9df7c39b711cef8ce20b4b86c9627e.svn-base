<%@ page errorPage="error.jsp"%> 
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreLoaninM"%>
<%@page import="jkt.hms.masters.business.StoreLoaninT"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.math.MathContext"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>

<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%><script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript">
//<!--
//var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
//var IMGDIR_MISC = "images/misc";
//var vb_disable_ajax = parseInt("0", 10);
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
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
if(map.get("choice") != null){
	choice = (String)map.get("choice");
}
List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
if(map.get("manufacturerList") != null){
	manufacturerList  = (List<MasManufacturer>)map.get("manufacturerList");
}
List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
if(map.get("brandList") != null){
	brandList  = (List<MasStoreBrand>)map.get("brandList");
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
String idBranGen1="idBranGen1";
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
String vatTax="vatTax";
String convertedStock = "convertedStock";
String formula = "formula";
String conversionFactor = "conversionFactor";
String discountAmount = "discountAmount";
String taxAmount = "taxAmount";
String ed = "ed";
String barCodeId="barCodeId";
String mrp="mrp";
String reasonForDemand="reasonForDemand";

%>


<div id="gridDiv">
<!-- -
<label > Total VAT Amt </label> <input type="text"
	name="vatTax" id="vatTax" value="" class="textbox_small_size"
	MAXLENGTH="15" validate="Total VAT,float,no"
	onblur="calculationInCRV()" tabindex="2" />
	 <label >
Total Discount </label> <input type="text" name="totDiscount" id="totDiscount"
	value="" class="textbox_small_size" MAXLENGTH="15"
	validate="Total Discount,float,no" onblur="calculationInCRV()"
	tabindex="2" />
	 <label
	> Round Off Value </label> <input type="text"
	name="roundOfValue" id="roundOfValue" value=""
	class="textbox_small_size" MAXLENGTH="15" tabindex="2" /> <input
	type="hidden" name="actualGrnValue" id="actualGrnValue" value="" /> <label
	>VAT Added</label> <input type="checkbox"
	name="vatApplicable" id="vatApplicable" value="1"
	onClick="calculationInCRV();" /></div>

 <label > CRV Value </label>
 <input	type="text" name="grnValue" id="grnValue" value=""	 MAXLENGTH="15" tabindex="2" />-->
<div class="Clear"></div>
<h4>CRV</h4>
<div class="Clear"></div>
<div class="cmntableWithHeight">
<table width="98%" colspan="7" id="grnDetails" 	border="0" cellpadding="0" cellspacing="0">
		<tr>
			<th>Sl No.</th>
			<th width="8%">PVMS/NIV	No.</th>
			<th width="9%">Nomenclature</th>
			<th width="9%">A/U</th>
			<th width="9%">Barcode</th>
			<th width="4%">B/G</th>
			<th width="9%">Brand Name</th>
			<th width="9%">Manufacturer Name</th>
			<th width="9%">Batch No.</th>
			<th width="9%" colspan="2">DOM</th>
			<th width="9%" colspan="2">DOE</th>
			<th width="9%">Qty Received</th>
			<th width="9%">Dispense Type</th>
			<th width="9%">Packaging</th>
			<th width="9%">MRP per Pack</th>
			<th>MRP Per A/U</th>
			<th width="3%">Disc(%)</th>
			<th width="3%">Tax(%)</th>
			<th width="9%">Cost</th>
			<th width="9%">Amount</th>
			<th width="9%">Reason for Demand</th>
		</tr>


		<% // Code for Adding Empty Rows
		int inc=0;
	for(int t=inc+1;t<20; t++)
	{
    %>
		<tr>
			<td width="5%">
			<input type="text" size="1" value="<%=t%>"	 name="<%=SR_NO%>" readonly="readonly" />
			</td>
			<td width="10%">
			<!--<input type="text"  name="<%=ITEM_CODE %>" size="8" readonly="readonly" id="<%=codeItem+""+t%>" />	-->
			<input type="text"  name="<%=ITEM_CODE %>" size="8"	id="<%=codeItem+""+t%>"	onblur="autocompleteBasedOnPvms(this.value,'<%=t%>');"	validate="PVMS No,String,no" tabindex="1" />
			<input type="hidden" name="flag" value="Grn" />

				<input type="hidden" size="2" value="0"	 name="<%=ITEM_ID%>" id="<%=idItem+""+t%>" />
				 <input	type="hidden" name="<%=DETAIL_ID %>" value="<%=t %>" id="hdb" />
				<input	type="hidden" value=""  name=""	id="<%=expiry+""+t%>" />
				<input type="hidden" value="" name="" id="<%=formula+""+t%>" />
				 <input	type="hidden" value=""  name=""	id="<%=conversionFactor+""+t%>" />
				<input type="hidden" name="loanInItem" value="No" id="loanInItem" />
				</td>

			<td width="10%">
			<input type="text" value=""	id="<%=nameItem+""+t%>" size="50" onblur="if(fillSrNo('<%=t%>')){checkForGrn(this.value, '<%=nameItem%>','<%=t%>');}"
				name="<%=nameItem%>" tabindex="1"  />
			<div id="ac2update"	 style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%=nameItem+""+t%>','ac2update','stores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&sourceOfSupply= '+document.getElementById('sourceCombo').value});
				
			</script>
			</td>
			<td width="10%"><input type="text" value=""
				readonly="readonly" tabindex="1" name="<%=AV%>" id="<%=idAu+""+t%>"  size="7"/>
			</td>
			<td><input type="text" name="barCodeNo" id="<%=barCodeId+""+t%>" value="" tabindex="" size="8" /></td>
			<%--<td width="4%"><input type="text" name="BranGen" id="<%=idBranGen1+""+t%>" value="" size="1"  /></td>--%>
			<td width="4%">
			<select name="BranGen" id="<%=idBranGen1+""+t%>" tabindex="1" validate="BG ,String,no" class="auto">
             <option value="B">B</option>
             <option value="G">G</option>
             
             
      </select>
      </td>
			
			
			<td width="10%">
			
			
			<select name="<%=BRAND_ID%>" id="<%=brandId+""+t%>" tabindex="1" class="small3" onchange="getManufacturerNameByAjax(this.value,<%=t%>);">
			<option value="">Select Brand</option>
			</select>
			</td>

			<td width="10%">
			<select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId+""+t%> tabindex="1" >
				<option value="0">--Select Manuf--</option>
			</select></td>




			<td width="10%"><input type="text" value=""
				name="<%=BATCH_NO %>" tabindex="1" id="<%=batchNo+""+t%>"
				maxlength="25" size="8" />
			</td>
<!-- -
			<input type="hidden" value=""  name="<%=LOT_NO %>"
				tabindex="1" id="<%=lotNo+""+t%>" maxlength="50" />
 -->
<!-- -
			<td width="10%"><input type="text" value=""
				name="<%=FREE_QTY %>" id="<%=freeQty+""+t %>"
				tabindex="1" onblur="calculationInCRV()" /></td>



			<td width="10%"><input type="text" value=""
				name="mdq" id="<%=mdq+""+t%>" tabindex="1" /></td>

 -->
				<!-- -
			<%if(choice.equals("l")){ %>
			<td width="10%"><input type="text" value=""
				name="ed" onblur="calculationInCRV();" id="<%=ed+""+t%>"
				tabindex="1" /></td>
			<%} %>
			<td width="3%"><input type="text"  value=""
				name="convertedStock" id="<%=convertedStock+""+t%>"
				readonly="readonly" /></td>
 -->

<!-- -
			<%if(choice.equals("l")){
		%>
			<td width="10%"><input type="text" value=""
				name="<%=TAX_AMT_MDQ %>" tabindex="2" onblur="calculationInCRV();"
				id="<%=TAX_AMT_MDQ +""+t%>" /> <!--<input type="text"  name="<%=TAX_PERCENT %>" tabindex="1" id="<%=taxVar+""+t%>" onblur="calculationInCRV();"  validate="Tax,float,no"/>
			<input type="hidden"  value="" name="taxAmount" id="<%=taxAmount+""+t%>" />
			</td>
			<%} else { %>
			<td width="10%"><input type="text"
				name="<%=TAX_PERCENT %>" tabindex="1" id="<%=taxVar+""+t%>"
				onblur="calculationInCRV();" validate="Tax,float,no" /> <input
				type="hidden"  value="" name="taxAmount"
				id="<%=taxAmount+""+t%>" /></td>
			<%}%>
 -->

<!-- -
			<td width="10%"><select name="<%=FREE_ITEM %>"
				id="<%=freeItem+""+t%>"  onChange="">
				<option value="n">No</option>
				<option value="y">Yes</option>
			</select></td>
 -->
			<td width="50%">
			<input type="text"	name="<%=MANUFACTURING_DATE%>" size="10" id="<%=manufacturingDate+""+t%>"	tabindex="1" readonly="readonly" />
			</td><td><img src="/hms/jsp/images/cal.gif" width="16"		height="16" border="0" validate="Pick a date"	onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+t%>'),event);" />
			</td>

			<td width="40%">
			<input type="text" name="<%=EXPIRY_DATE%>" size="10"	id="<%=expiryDate+""+t %>" tabindex="1" readonly="readonly" />
			</td><td><img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+t %>'),event);" />
			</td>
			<td width="10%">
			<input type="text" value="0" name="<%=QUANTITY_RECEIVED %>" size="8" tabindex="1" id="<%=quanRec+""+t%>"	onblur="calculationInCRV();" tabindex="1"/>
			</td>

			<td width="10%">
			<select name="dispenseType"
				id=<%=dispenseType+""+t%>>
				   <option value="0">select Dispen.</option>
			</select>
			</td>

			<td width="10%"><input type="text" value="1" name="mdq" id="<%=mdq+""+t%>" tabindex="1" onblur="calculationInCRV();" size="6"/></td>




				<td width="10%">
				<input type="text" value="" name="ratePerMdq" size="8" id="<%=ratePerMdq+""+t%>" tabindex="1"  tabindex="1" onblur="calculationInCRV();"/>
				</td>
				<td >
				<input type="text" value="" name="<%=MRP %>" size="8" id="<%=mrp+""+t%>" tabindex="1" onblur="calculationInCRV();"/>
				</td>
				<td width="3%">
				<input type="text"  value="" name="<%=DISCOUNT_PERCENTAGE%>" size="5" tabindex="1"	id="<%=discountVar+""+t%>" onblur="calculationInCRV();"	validate="Discount,float,no" tabindex="1" size="8"/>
				<input type="hidden" value="" name="discountAmount"	id="<%=discountAmount+""+t%>" tabindex="1"/>
				</td>
				<td width="3%"><input type="text"
				name="<%=TAX_PERCENT %>" tabindex="1" id="<%=taxVar+""+t%>"
				onblur="calculationInCRV();" validate="Tax,float,no" size="6"/> <input
				type="hidden"  value="" name="taxAmount"
				id="<%=taxAmount+""+t%>"  size="8"/></td>

			<td width="10%">
			<input type="text" value="0"	 name="<%= COST_PRICE %>" id="<%=costPrice+""+t%>" tabindex="1" size="8"/></td>
			<td width="10%">
				<input type="text" value="0"  name="<%=AMOUNT%>" size="8"	id="<%=amtVar+""+t%>" readonly="readonly" tabindex="1" />
				 <input type="hidden" name="PreId" id="<%="PreId"+""+inc%>" value="0"/>
			</td>
			<td><input type="text" name="<%=reasonForDemand%>" value="" tabindex="1"/></td>
		</tr>

		<% } // Code for Adding Empty Rows Ends Here %>

</table>
</div>
<div class="clear"></div>
<div class="Block">
<!-- -
<label>Total Cost</label>
<input type="text" id="total_cost" name="totalCost" value="" readonly="readonly" tabindex="1"/> -->
<label>Total Amount</label>
<input type="text" id="total_amount" name="actualGrnValue" value="" readonly="readonly" tabindex="1"/>
</div>



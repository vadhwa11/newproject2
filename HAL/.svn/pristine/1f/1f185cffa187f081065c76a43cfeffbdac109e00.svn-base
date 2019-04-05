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

%>



<div id="gridDiv">
<div class="clear paddingTop15">
<div class="Block">

<label > Total VAT Amt </label>
<input type="hidden"	name="vatTax" id="vatTax" value=""	MAXLENGTH="15" validate="Total VAT,float,no"	onblur="calculationInCRV()" tabindex="2" />
<label>Total Discount </label>
<input type="hidden" name="totDiscount" id="totDiscount"	value="" MAXLENGTH="15"	validate="Total Discount,float,no" onblur="calculationInCRV()"	tabindex="2" />
<label> CRV Value </label>
<input	type="hidden" name="grnValue" id="grnValue" value=""	MAXLENGTH="15" tabindex="2" />
<label> Round Off Value </label>
<input type="hidden"	name="roundOfValue" id="roundOfValue" value=""	MAXLENGTH="15" tabindex="2" />
<input	type="hidden" name="actualGrnValue" id="actualGrnValue" value="" />
<label>VAT Added</label>
<input type="checkbox"	name="vatApplicable" id="vatApplicable" value="1"	onClick="calculationInCRV();" />
</div>
</div>
<input type="hidden" name="currDate" id="currdate" value="<%=currentDate %>"  />
<h4>CRV</h4>
<div class="Clear"></div>

<div class="cmntable">
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
			
		</tr>
	</thead>
	
	<tbody>

		<%
		List<StoreLoaninT> gridLoanInTList= new ArrayList<StoreLoaninT>();
 		int noOfRows = 0;
	    if (map.get("gridLoanInTList")!=null)
	    {
	    	gridLoanInTList = (List) map.get("gridLoanInTList");
	    	noOfRows = gridLoanInTList.size();
	    }
	    int inc = 0;
	   	if (gridLoanInTList != null && gridLoanInTList.size()>0)
	    {
    		 for(StoreLoaninT storeLoaninT : gridLoanInTList)
	    	 {
    			 inc = inc + 1;
	    	 %>
		<tr>
			<td width="5%">
			<input type="text" size="1" value="<%=inc%>" name="<%=SR_NO%>" readonly="readonly" tabindex="1"/>
			</td>

			<input type="hidden" name="flag" value="LoanIn" />

			<td >
			<%if(storeLoaninT.getItem().getPvmsNo()!=null){ %>
			<input type="text" size="8" value="<%=storeLoaninT.getItem().getPvmsNo() %>" name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem+""+inc%>" tabindex="1"/>
			<%}else{ %>
			<input type="text" size="8" value=" " name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem+""+inc%>" tabindex="1"/>
			<%} %>
			</td>

			<input type="hidden" name="<%=DETAIL_ID %>"		value="<%=storeLoaninT.getId() %>" id="hdb" />
			<input type="hidden" value="<%=storeLoaninT.getItem().getId()%>"	name="<%=ITEM_ID%>" id="<%=idItem+""+inc%>" />
			<input type="hidden" value="" name="" id="<%=expiry+""+inc%>" />
			<input type="hidden" value="<%=storeLoaninT.getItem().getItemConversion().getFormula()%>"	name="" id="<%=formula+""+inc%>" />
			<input type="hidden" value="<%=storeLoaninT.getItem().getItemConversion().getConversionFactor1()%>"	name="" id="<%=conversionFactor+""+inc%>" />
			<input type="hidden" name="loanInItem" value="Yes" id="loanInItem" />
			<td width="10%">
			<input type="text" value="<%=storeLoaninT.getItem().getNomenclature() %>"	size="30" readonly="readonly" tabindex="1" id="<%=nameItem+""+inc%>"	name="<%=nameItem%>" />
			</td>
			
			<%--<td width="10%">
			<select name="<%=BRAND_ID%>" id="<%=brandId+""+inc%>" tabindex="1">
			<option value="<%=storeLoaninT.getBrand().getId()%>"><%=storeLoaninT.getBrand().getBrandName()%></option>
			</select>
			</td> --%>

			<td width="10%">
			<select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId+""+inc%> tabindex="1">
				<option value="<%=storeLoaninT.getManufacturer().getId()%>"><%=storeLoaninT.getManufacturer().getManufacturerName()%></option>
			</select>

			<td width="10%">
			<input type="text"	size="6" value="<%=storeLoaninT.getItem().getItemConversion().getItemUnitName() %>"	readonly="readonly" name="<%=AV%>"	id="<%=idAu+""+inc%>" />
			</td>

			<td width="10%">
			<input type="text"	size="7"  value="<%=storeLoaninT.getBatchNo() %>" name="<%=BATCH_NO %>" readonly="readonly" tabindex="3"	id="<%=batchNo+""+inc%>" />
			</td>
			<!--
	       <td width="10%">
		       <input type="hidden" value="<%=storeLoaninT.getLotNo() %>"  name="<%=LOT_NO %>" readonly="readonly" tabindex="2" id="<%=lotNo+""+inc%>"/>
	       </td>
 	       -->

			<td width="10%">
			<input type="text" size="7" 	value="<%=storeLoaninT.getReceivedQty() %>" name="<%=QUANTITY_RECEIVED %>" readonly="readonly" tabindex="2"	id="<%=quanRec+""+inc%>" />
			</td>

			<td width="10%">
			<input type="text"	size="7"  value="<%=storeLoaninT.getFreeQty() %>" name="<%=FREE_QTY %>"	id="<%=freeQty+""+inc%>" readonly="readonly" />
			</td>

			<td width="10%">
			<select size="7"  name="dispenseType"	id=<%=dispenseType+""+inc%> tabindex="1">
				<option value="<%=storeLoaninT.getDispType()%>"><%=storeLoaninT.getDispType()%></option>
			</select>

			<td width="10%">
			<input type="text"	size="7"  value="<%=storeLoaninT.getMdqValue()%>" name="mdq" readonly="readonly" id="<%=mdq+""+inc%>" tabindex="2" />
			</td>

			<td width="10%">
			<input type="text"	size="7"  value="<%=storeLoaninT.getRatePerMdq()%>" name="ratePerMdq" readonly="readonly" id="<%=ratePerMdq+""+inc%>"	tabindex="2" />
			</td>

			<td width="10%">
			<input type="text" value="0" name="ed" readonly="readonly" id="<%=ed+""+inc%>" tabindex="2" />
			</td>

			<%
			BigDecimal tax = new BigDecimal(0);
	       	BigDecimal discount = new BigDecimal(0);
	       	BigDecimal qty = new BigDecimal(0);
	       	BigDecimal rate = new BigDecimal(0);
	       	BigDecimal amount  = new BigDecimal(0);
	       	BigDecimal amountAfterTax = new BigDecimal(0);
	      	BigDecimal amountAfterdis = new BigDecimal(0);
	       	BigDecimal mdqValue = new BigDecimal(0);
	       	String formulaValue = "";
	       	int conversionFactorValue = 0;

	        BigDecimal taxPercent = new BigDecimal(0);
		    BigDecimal discountPercent = new BigDecimal(0);


		    try
			{
				qty = storeLoaninT.getReceivedQty();
			}
			catch(Exception e)
			{
				qty = new BigDecimal(0);
			}

		    try
			{
				rate = storeLoaninT.getRatePerMdq();
			}
			catch(Exception e)
			{
				rate = new BigDecimal(0);
			}

		    try
			{
				tax = storeLoaninT.getTax();
			}
			catch(Exception e)
			{
				tax = new BigDecimal(0);
			}

			try
			{
				discount = storeLoaninT.getDiscount();
			}
			catch(Exception e)
			{
				discount = new BigDecimal(0);
			}

			try
			{
				formulaValue = storeLoaninT.getItem().getItemConversion().getFormula();
			}
			catch(Exception e)
			{
				formulaValue = "";
			}


			try
			{
				conversionFactorValue = storeLoaninT.getItem().getItemConversion().getConversionFactor1();
			}
			catch(Exception e)
			{
				conversionFactorValue = 0;
			}

			try
			{
				mdqValue = storeLoaninT.getMdqValue();
			}
			catch(Exception e)
			{
				mdqValue = new BigDecimal(0);
			}

			amount = qty.multiply(rate);
			//amountAfterTax = amount.add(tax);
			amountAfterdis = amount.subtract(discount);


			if(!tax.toString().equals("0.0000")){
			taxPercent =  (tax.multiply(new BigDecimal(100))).divide(amount,new MathContext(4));
			}
			if(!discount.toString().equals("0.0000")){
			discountPercent = (discount.multiply(new BigDecimal(100))).divide(amount,new MathContext(4));
			}
			BigDecimal convertedStockValue = new BigDecimal(0);

			if (formulaValue.equals("1"))
			{
				convertedStockValue = qty.multiply(mdqValue).divide(new BigDecimal(conversionFactorValue));
			}
			else if (formulaValue.equals("2"))
			{
				convertedStockValue = qty;
			}

			%>

			<td width="3%">
			<input type="text" size="7"  	value="<%=convertedStockValue%>" name="convertedStock"	id="<%=convertedStock+""+inc%>" readonly="readonly" />
			</td>
			<input type="hidden" size="5"  value="<%=storeLoaninT.getUnitRate() %>" name="<%=UNIT_RATE%>"	readonly="readonly" tabindex="2" id="<%=unitRateVar+""+inc%>" />
			<td >
			<input type="text" size="5" value="<%=discountPercent%>" name="<%=DISCOUNT_PERCENTAGE%>"	readonly="readonly" tabindex="2" id="<%=discountVar+""+inc%>" />
			<input	type="hidden" value="<%=storeLoaninT.getDiscount()%>" name="discountAmount"	id="<%=discountAmount+""+inc%>" />
			</td>

			<td width="10%">
			<input type="text" size="5"   value="<%=tax%>"	 name="<%=TAX_AMT_MDQ %>" tabindex="2"	onblur="calculationInCRV();" id="<%=TAX_AMT_MDQ+""+inc%>" />
			</td>

			<td width="10%">
			<input type="text"	size="5"  value="<%=storeLoaninT.getAmountValue() %>" name="<%=AMOUNT %>" tabindex="2" readonly="readonly"	id="<%=amtVar+""+inc%>" />
			<input type="hidden" value="<%=storeLoaninT.getFinalCostPrice()%>" name="<%= COST_PRICE %>" id="<%=costPrice+""+inc%>" />
			</td>

			<td >
			<select name="<%=FREE_ITEM %>"	class="small" id="<%=freeItem+""+inc%>" tabindex="2" >
				<option value="n"
					<%=HMSUtil.isSelected(storeLoaninT.getFreeItem(),"n")%>>No</option>
				<option value="y"
					<%=HMSUtil.isSelected(storeLoaninT.getFreeItem(),"y")%>>Yes</option>
			</select>
			</td>

			<td >
			<input type="text"	size="10" value="<%=storeLoaninT.getManufacturerDate()==null?"":storeLoaninT.getManufacturerDate()%>"		name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate+""+inc%>"	 MAXLENGTH="30" tabindex="2" readonly="readonly" />
			</td>
	
			<td >
			<input type="text"	size="10" value="<%=storeLoaninT.getExpiryDate()==null?"":HMSUtil.convertDateToStringWithoutTime(storeLoaninT.getExpiryDate())%>" name="<%=EXPIRY_DATE%>" id="<%=expiryDate+""+inc %>" MAXLENGTH="30" tabindex="2" readonly="readonly" />
			</td>
		</tr>		
		<% }
	} //for loop ends here %>


		<%
		List<StorePoDetail> storePoDetailList= new ArrayList<StorePoDetail>();
        List<StorePoHeader> storePoHeaderList= new ArrayList<StorePoHeader>();
        List<MasStoreBrand> brandList= new ArrayList<MasStoreBrand>();
 		if (map.get("poList")!=null)
	    {
 			storePoDetailList = (List) map.get("poList");
	    	noOfRows = storePoDetailList.size();
	    }
 		if (map.get("poHeadList")!=null)
	    {
 			storePoHeaderList = (List) map.get("poHeadList");
	    }
 		
 		
 		if (map.get("poDetailsList")!=null)
	    {
 			storePoDetailList = (List) map.get("poDetailsList");
	    }
 		
 		
 		int tenderId = 0;
 		for(StorePoHeader sPH :storePoHeaderList){
 			if(sPH.getTenderM() != null){
 			tenderId = sPH.getTenderM().getId();
 			}else{
 			tenderId = 0;
 			}
 		}


 		if (map.get("brandList")!=null)
	    {
 			brandList = (List) map.get("brandList");
	    }
 		
 		
 		
 		
 		
 		
	   	if (indentTList != null && indentTList.size()>0)
	    {
    		 for(StoreIndentT storeIndentT : indentTList)
	    	 {
    			 inc = inc + 1;
	    	 %>
		<tr>
		<input type="hidden" 	value="" name="convertedStock"	id="<%=convertedStock+""+inc%>" readonly="readonly" />
			<td width="5%"><input type="text" size="1" value="<%=inc%>"	name="<%=SR_NO%>" readonly="readonly" tabindex="1"/></td>
			<td ><!--<input type="text"  name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem+""+inc%>" />	-->
			<input type="text"  size="8" name="<%=ITEM_CODE %>" value="<%=storeIndentT.getItem().getPvmsNo()%>"	id="<%=codeItem+""+inc%>"	onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');"	validate="PVMS No,String,no" tabindex="1" tabindex="1"/>
			<input type="hidden" name="flag" value="Grn" /> <input type="hidden" size="2" value="<%=storeIndentT.getItem().getId()%>"	name="<%=ITEM_ID%>" id="<%=idItem+""+inc%>" />
			<input	type="hidden" name="<%=DETAIL_ID %>" value="0" id="hdb" />
			<input type="hidden" value="" name="" id="<%=expiry+""+inc%>" />
			<input type="hidden" value=""	name="" id="<%=formula+""+inc%>" />
			<input	type="hidden" value="" name=""	id="<%=conversionFactor+""+inc%>" />
			<input type="hidden" name="loanInItem" value="Yes" id="loanInItem" />
			</td>

			<td width="10%"><input type="text" size="30" value="<%=storeIndentT.getItem().getNomenclature()%>" id="<%=nameItem+""+inc%>"
				
				onblur="if(fillSrNo('<%=inc%>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc%>');}"
				name="<%=nameItem%>" tabindex="1" />
			<div id="ac2update"	style="display: none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem+""+inc%>','ac2update','neStores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
		</script></td>


			<td width="10%">
			<input type="text" size="6" value="<%=storeIndentT.getItem().getItemConversion().getItemUnitName() %>" readonly="readonly" tabindex="1" name="<%=AV%>" id="<%=idAu+""+inc%>" />
			</td>
			
			<td width="10%">
			<input type="text" size="7" value="" name="<%=BATCH_NO %>" tabindex="1" id="<%=batchNo+""+inc%>"	maxlength="25" />
			</td>
			<%--<td width="10%">
				<input type="text" value=""  name="<%=LOT_NO %>"tabindex="1" id="<%=lotNo+""+inc%>" maxlength="50" onblur="getManufacturer(<%=inc %>);" />
			</td>--%>
		
			<td width="10%">
			
			
			<select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId+""+inc%> tabindex="1" onchange="getManufId(this.value,<%=inc%>);">
			<option value="">Select </option>
			<% for(MasManufacturer manufacturer : manufactureList){ %>
				<option value=<%=manufacturer.getId() %>><%=manufacturer.getManufacturerName() %></option>
					<% }%>
			</select>
			
			<input type="hidden" size="10" name="<%=MANUFACTURER_ID%>" id=<%=manufacturerId1+""+inc%> value="0"/> 
			</td>
	
			
					
			
			<td width="10%">
			<%if(storeIndentT.getQtyInDemand()!=null){ %>
			<input type="text"  size="9" value="<%=storeIndentT.getQtyInDemand()%>"  name="<%=QUANTITY_RECEIVED %>" tabindex="1" id="<%=quanRec+""+inc%>"	onblur="calculationInCRV();" />
			<%}else{ %>
			<input type="text" size="9" value=""  name="<%=QUANTITY_RECEIVED %>" tabindex="1" id="<%=quanRec+""+inc%>"	onblur="calculationInCRV();" />
			<%} %>
			</td>
			
			<td width="10%">
			<input type="text" size="4"  value="" name="mrp" id="mrp<%=inc%>" tabindex="1"	onblur="calculationInCRV()" onkeypress="return isNumberKey(event)"/>
			</td>
			
			<td width="10%">
			<input type="text" size="4"  value="" name="<%=UNIT_RATE %>" id="<%=ratePerMdq+""+inc%>" tabindex="1"	onblur="calculationInCRV()" onkeypress="return isNumberKey(event)"/>
			</td>
			
			
			<td>
			<input size="5" type="text"   name="<%=DISCOUNT_PERCENTAGE%>" tabindex="1" value="0"	id="<%=discountVar+""+inc%>" onblur="calculationInCRV(); calculateTotalCrvAmount(<%=inc %>) "		validate="Discount,float,no" />
			<input type="hidden" value="" name="discountAmount"	id="<%=discountAmount+""+inc%>" />
			</td>
			
			<%--
			<td width="10%">
			<input type="text" name="<%=TAX_PERCENT %>" tabindex="1" id="<%=taxVar+""+inc%>" value="0"	onblur="calculationInCRV();" validate="Tax,float,no" />
			<input	type="hidden"  value="" name="taxAmount"	id="<%=taxAmount+""+inc%>" />
			</td>
			 --%>
			
			<td width="10%">
			<input type="hidden" value="0"	 name="<%= COST_PRICE %>" id="<%=costPrice+""+inc%>" />
			<input type="text" size="7" value="0"  name="<%=AMOUNT%>"	id="<%=amtVar+""+inc%>" readonly="readonly"  onblur="calculateTotalCrvAmount(<%=inc %>)"/>
			</td>
			
			<%--
			
			<td width="10%">
			<input type="text" 	name="<%=FREE_QTY %>" id="<%=freeQty+""+inc %>"  value="0"tabindex="1" onblur="calculationInCRV()" />
			</td>
			 --%>
			
			<td width="10%">
			<input type="text" 	size="18" name="reasonForDemand" id="reasonForDemand<%=inc %>"  value=""tabindex="1" onblur="calculateTotalCrvAmount(<%=inc %>)" />
			</td>
			
			<td>
			<input type="text"	size="8" name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate+""+inc%>"	tabindex="1" readonly="readonly" onblur="checkDate(<%=inc%>)"/>
			
			</td>
			
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+inc%>'),event);" />
			</td>
			
			<%--
			<td>
			<input type="text" size="10" name="<%=EXPIRY_DATE%>" id="<%=expiryDate+""+inc %>" tabindex="1" readonly="readonly" />
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+inc %>'),event);" />
			</td>
			
			 --%>
			 
			 <td>
			<input type="text" size="8" name="WarrantyDate" id="<%=warrantyDate+""+inc %>" tabindex="1" readonly="readonly" />
			
			</td>
			
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=warrantyDate+""+inc %>'),event);" />
			</td>
			
			 <td>
			<input type="text" size="8" name="WarrantyEndDate" id="WarrantyEndDate<%=inc %>" tabindex="1" readonly="readonly" onblur="checkWarantyDate(<%=inc%>)"/>
			
			</td>
			
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('WarrantyEndDate<%=inc %>'),event);" />
			</td>
			
			<td>
			<input type="text" size="8" name="AmcStartDate" id="<%=amcStartDate+""+inc %>" tabindex="1" readonly="readonly" onblur="checkAmc(<%=inc%>)"/>
			</td>
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=amcStartDate+""+inc %>'),event);" />
			</td>
			
			<%--
			
			<td>
			<input type="text" size="10" name="InstallationDate" id="<%=installationDate+""+inc %>" tabindex="1" readonly="readonly" />
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=installationDate+""+inc %>'),event);" />
			</td>

			

			
			

			<td>
			<select name="<%=FREE_ITEM %>"	id="<%=freeItem+""+inc%>" class="small" onChange="">
				<option value="n">No</option>
				<option value="y">Yes</option>
			</select>
			</td>
 --%>
			
		</tr>
		<% }
	} //for loop ends here %>

		<%


			if (storePoDetailList != null && storePoDetailList.size()>0)
	  		  {
				int rowLenSize=storePoDetailList.size();
    		 for(StorePoDetail storePoDetail : storePoDetailList)
	    	 {
    			 inc = inc + 1;
	    	 %>
		<tr>
		<input type="hidden" 	value="" name="convertedStock"	id="<%=convertedStock+""+inc%>" readonly="readonly" />
			<td width="5%"><input type="text" size="1" value="<%=inc%>"	name="<%=SR_NO%>" readonly="readonly" tabindex="1"/></td>
			<td ><!--<input type="text"  name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem+""+inc%>" />	-->
			<input type="text"  size="8" name="<%=ITEM_CODE %>" value="<%=storePoDetail.getItem().getPvmsNo()%>"	id="<%=codeItem+""+inc%>"	onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');"	validate="PVMS No,String,no" tabindex="1" tabindex="1"/>
			<input type="hidden" name="flag" value="Grn" /> 
			<input type="hidden" size="2" value="<%=storePoDetail.getItem().getId()%>"	name="<%=ITEM_ID%>" id="<%=idItem+""+inc%>" />
			<input	type="hidden" name="<%=DETAIL_ID %>" value="0" id="hdb" />
			<input type="hidden" value="" name="" id="<%=expiry+""+inc%>" />
			<input type="hidden" value=""	name="" id="<%=formula+""+inc%>" />
			<input	type="hidden" value="" name=""	id="<%=conversionFactor+""+inc%>" />
			<input type="hidden" name="loanInItem" value="Yes" id="loanInItem" />
			</td>

			<td width="10%"><input type="text" size="30" value="<%=storePoDetail.getItem().getNomenclature()%>" id="<%=nameItem+""+inc%>"
				
				onblur="if(fillSrNo('<%=inc%>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc%>');}"
				name="<%=nameItem%>" tabindex="1" />
			<div id="ac2update"	style="display: none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem+""+inc%>','ac2update','neStores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
		</script></td>


			<td width="10%">
			<input type="text" size="6" value="<%=storePoDetail.getItem().getItemConversion().getItemUnitName() %>" readonly="readonly" tabindex="1" name="<%=AV%>" id="<%=idAu+""+inc%>" />
			</td>
			
			<td width="10%">
			<input type="text" size="7" value="" name="<%=BATCH_NO %>" tabindex="1" id="<%=batchNo+""+inc%>"	maxlength="25" />
			</td>
			
			<%--
			<td width="10%">
				<input type="text" value=""  name="<%=LOT_NO %>"tabindex="1" id="<%=lotNo+""+inc%>" maxlength="50" onblur="getManufacturer(<%=inc %>);" />
			</td>
			 --%>
			 
			 <%--
			 <td width="10%">
			<select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId+""+inc%> tabindex="1" onchange="getManufId(this.value,<%=inc%>);">
				<option value="">Select Manuf</option>
			</select>
			<input type="hidden" size="10" name="<%=MANUFACTURER_ID%>" id=<%=manufacturerId1+""+inc%> value="0"/> 
			</td>
			--%>
			
			<td width="10%">
			<select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId+""+inc%> tabindex="1" onchange="getManufId(this.value,<%=inc%>);">
			<option value="">Select Manuf</option>
			<% for(MasManufacturer manufacturer : manufactureList){ %>
				<option value=<%=manufacturer.getId() %>><%=manufacturer.getManufacturerName() %></option>
					<% }%>
			</select>
			<input type="hidden" size="10" name="<%=MANUFACTURER_ID%>" id=<%=manufacturerId1+""+inc%> value="0"/> 
			</td>
			
			 
			<td width="10%">
			<%if(storePoDetail.getQuantityOrdered()!=null){ %>
			<input type="text" size="9" value="<%=storePoDetail.getQuantityOrdered()%>"  name="<%=QUANTITY_RECEIVED %>" tabindex="1" id="<%=quanRec+""+inc%>"	onblur="calculationInCRV();" />
			<%}else{ %>
			<input type="text" size="9" value=""  name="<%=QUANTITY_RECEIVED %>" tabindex="1" id="<%=quanRec+""+inc%>"	onblur="calculationInCRV();" />
			<%} %>
			</td>
			
			<!-- 
			<td width="10%">
			<input type="text" value="" name="mrp" id="mrp<%=inc%>" tabindex="1"	onblur="calculationInCRV()"  onfocus="calculateTotalCrvAmount(<%=rowLenSize%>);"/>
			</td>
			 -->
			<%if(storePoDetail.getMrp() != null){%>
			<td width="10%"><input type="text" size="4"	value="<%=storePoDetail.getMrp()%>" name="mrp" size="8" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=rowLenSize%>);"	 tabindex="1" /></TD>
			<%}else{ %>
			<td><input	type="text"  size="4" value=""	 name="mrp" size="8" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=rowLenSize%>);"  tabindex="1" /></td>
			 <%}%>
			
			
			<td width="10%">
			<input type="text" size="9" value="" name="<%=UNIT_RATE %>" id="<%=ratePerMdq+""+inc%>" tabindex="1"	onblur="calculationInCRV() ; calculateTotalCrvAmount(<%=rowLenSize%>);"  onfocus="calculateTotalCrvAmount(<%=rowLenSize%>);"/>
			</td>
			
			
			<td>
			<input siz="5" type="text"   name="<%=DISCOUNT_PERCENTAGE%>" tabindex="1" value="0"	id="<%=discountVar+""+inc%>" onblur="calculationInCRV(); calculateTotalCrvAmount(<%=inc %>)"	onfocus="calculateTotalCrvAmount(<%=rowLenSize%>);" 	validate="Discount,float,no" />
			<input type="hidden" value="" name="discountAmount"	id="<%=discountAmount+""+inc%>" />
			</td>
			
			<%--
			<td width="10%">
			<input type="text" name="<%=TAX_PERCENT %>" tabindex="1" id="<%=taxVar+""+inc%>" value="0"	onblur="calculationInCRV();" validate="Tax,float,no" />
			<input	type="hidden"  value="" name="taxAmount"	id="<%=taxAmount+""+inc%>" />
			</td>
			 --%>
			
			<td width="10%">
			<input type="hidden" value="0"	 name="<%= COST_PRICE %>" id="<%=costPrice+""+inc%>" />
			<input type="text" size="7" value="0"  name="<%=AMOUNT%>"	id="<%=amtVar+""+inc%>" readonly="readonly" />
			</td>
			
			<td width="10%">
			<input type="text" size="18"	name="reasonForDemand" id="reasonForDemand<%=inc %>"  value=""tabindex="1" onblur="calculationInCRV()"  onfocus="calculateTotalCrvAmount(<%=inc%>);"/>
			</td>
			
			<%--
			
			<td width="10%">
			<input type="text" 	name="<%=FREE_QTY %>" id="<%=freeQty+""+inc %>"  value="0"tabindex="1" onblur="calculationInCRV()" />
			</td>
			 --%>
			
			<td>
			<input type="text"	size="9" name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate+""+inc%>"	tabindex="1" readonly="readonly" onblur="checkDate(<%=inc%>)"/>
			
			</td>
			
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+inc%>'),event);" />
			</td>
			

			<%--
			<td>
			<input type="text" size="10" name="<%=EXPIRY_DATE%>" id="<%=expiryDate+""+inc %>" tabindex="1" readonly="readonly" />
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+inc %>'),event);" />
			</td>
			 --%>
			 <td>
			<input type="text" size="9" name="WarrantyDate" id="<%=warrantyDate+""+inc %>" tabindex="1" readonly="readonly" />
			
			</td>
			
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=warrantyDate+""+inc %>'),event);" />
			
			</td>
	
	 		<td>
			<input type="text" size="9" name="WarrantyEndDate" id="WarrantyEndDate<%=inc %>" tabindex="1" readonly="readonly" onblur="checkWarantyDate(<%=inc%>)"/>
			
			</td>
			
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('WarrantyEndDate<%=inc %>'),event);" />
			
			</td>
			
			
			 
			<td>
			<input type="text" size="9" name="AmcStartDate" id="<%=amcStartDate+""+inc %>" tabindex="1" readonly="readonly" onblur="checkAmc(<%=inc%>)"/>
			
			</td>
			
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=amcStartDate+""+inc %>'),event);" />
			
			</td>
			
			<%--

			

			
			

			<td>
			<select name="<%=FREE_ITEM %>"	id="<%=freeItem+""+inc%>" class="small" onChange="">
				<option value="n">No</option>
				<option value="y">Yes</option>
			</select>
			</td>
 --%>
			
		</tr>
		<% }
	} //for loop ends here %>
	
	


	</tbody>
</table>
</div>
</div>

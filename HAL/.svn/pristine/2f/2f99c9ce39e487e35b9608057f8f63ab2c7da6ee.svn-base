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
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
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
float Tot=0.0f;
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
<h4>Challan Items Detail
</h4>
<div class="Clear"></div>
<div class="cmntableWithHeight">
<table width="98%" colspan="7" id="grnDetails" 	border="0" cellpadding="0" cellspacing="0">
		<tr>
			<th>Sl No.</th>
			<th width="8%">PVMS/ NIV No.</td>
			<th width="9%">Nomenclature</th>
			<th width="9%">A/U</th>
			<th width="9%">Barcode</th>
			<th width="9%">B/G</th>
			<th width="9%">Brand </th>
			<th width="9%">Manufacturer</th>
			<th width="9%">Batch No.</th>
			<th width="9%" colspan="2">DOM</th>
			<th width="9%" colspan="2">DOE</th>

			<th width="9%">Qty Received</label></th>
			<th width="9%">Dispense Type</th>
		    <th width="9%">Packaging</th>
			<th>MRP</BR>Per Pack </th>
			<th width="9%">MRP</BR>Per A/U</th>
			<th width="9%">Disc(%)</th>
			<th width="9%">Tax(%)</th>
			<th width="9%">Cost</th>
			<th width="9%">Amount</th>
			<th width="9%">Reason</BR>for Demand</th>
			<th scope="col">Add</th>
			<th scope="col">Delete</th>
		</tr>
		<%
		List<StoreIndentT> gridLoanInTList= new ArrayList<StoreIndentT>();
 		int noOfRows = 0;
	    if (map.get("gridLoanInTList")!=null)
	    {
	    	gridLoanInTList = (List) map.get("gridLoanInTList");
	    	noOfRows = gridLoanInTList.size();
	    }
	    int inc = 0;
	   	if (gridLoanInTList != null && gridLoanInTList.size()>0)
	    {
    		 for(StoreIndentT storeLoaninT : gridLoanInTList)
	    	 {
    			 System.out.println("this is indent list");
    			 inc = inc + 1;
	    	 %>
		<tr>
		<td width="5%">
		<input type="text"  value="<%=inc%>" name="<%=SR_NO%>" readonly="readonly" size="1" />
		</td>
		<td width="10%">
		<input type="hidden" name="flag" value="LoanIn" />
			<%if(storeLoaninT.getItem().getPvmsNo()!=null){ %>
		<input type="text"	value="<%=storeLoaninT.getItem().getPvmsNo() %>" name="<%=ITEM_CODE %>" size="6" readonly="readonly" id="<%=codeItem+""+inc%>" />
		<%}else{ %>
		<input type="text" value=" " name="<%=ITEM_CODE %>" size="6" readonly="readonly" id="<%=codeItem+""+inc%>" />
		<%} %>
		<input type="hidden" name="<%=DETAIL_ID %>"	value="<%=storeLoaninT.getId() %>" id="hdb" />
		<input type="hidden" value="<%=storeLoaninT.getItem().getId()%>" name="<%=ITEM_ID%>" id="<%=idItem+""+inc%>" />
		<input type="hidden" value=""  name=""	id="<%=expiry+""+inc%>" />
		<input type="hidden" value="<%=storeLoaninT.getItem().getItemConversion().getFormula()%>" name="" id="<%=formula+""+inc%>" />
		<input type="hidden" value="<%=storeLoaninT.getItem().getItemConversion().getConversionFactor1()%>"	 name="" id="<%=conversionFactor+""+inc%>" />
		<input type="hidden" name="loanInItem" value="Yes" id="loanInItem" />
		</td>

		<td width="10%">
		<input type="text"	value="<%=storeLoaninT.getItem().getNomenclature() %>"	readonly="readonly" tabindex="1" id="<%=nameItem+""+inc%>" name="<%=nameItem%>" size="50" />
		</td>
		<td width="10%">
		<input type="text"	value="<%=storeLoaninT.getItem().getItemConversion().getIssueUnit().getUnitName() %>"	 readonly="readonly" name="<%=AV%>"	id="<%=idAu+""+inc%>" size="7"/>
		</td>
		<td>
		<input type="text" name="barCodeNo" id=""<%=barCodeId+""+inc%>" value="" size="6" tabindex=""/>
		</td>

		<td>
		<input type="text" name="BRAND_GEN" id=""<%="BrandGen"+""+inc%>" value="<%=storeLoaninT.getItem().getBrandedGeneric()%>" tabindex="" size="1"/>
		</td>

		<td width="10%">
		<select name="<%=BRAND_ID%>" id="<%=brandId+""+inc%>" tabindex="1" >
		<%if(storeLoaninT.getBrand() !=null){%>
				<option value="<%=storeLoaninT.getBrand().getId()%>"><%=storeLoaninT.getBrand().getBrandName()%></option>
				<%}else{ 
				for(MasStoreBrand storeBrand:brandList){%>
					<option value="<%=storeBrand.getId()%>"><%=storeBrand.getBrandName()%></option>
				
				<%
				}}%>
			</select>
		</td>

		<td width="10%">
		<select name="<%=MANUFACTURER_ID %>"	id=<%=manufacturerId+""+inc%> tabindex="1">
		<%if(storeLoaninT.getManufacture() !=null){ %>
				<option value="<%=storeLoaninT.getManufacture().getId()%>"><%=storeLoaninT.getManufacture().getManufacturerName()%></option>
				<%}else{ 
				for(MasManufacturer masManufacturer:manufacturerList){%>
					<option value="<%=masManufacturer.getId()%>"><%=masManufacturer.getManufacturerName()%></option>
				<%} 
				}%>
			</select>
</td>
		

		<td width="10%">
		<input type="text"	value=""	name="<%=BATCH_NO %>"  tabindex="3"	id="<%=batchNo+""+inc%>" size="8" tabindex="1"/>
		</td>
<td width="40%">
			<input type="text" value=""	name="<%=MANUFACTURING_DATE%>" size="8" id="<%=manufacturingDate+""+inc%>" MAXLENGTH="30" tabindex="1" readonly="readonly" tabindex="1"/>
			</td><td><img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" OnClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+inc%>'),event);" />
			</td>
<td width="40%">
			<input type="text" value=""	name="<%=EXPIRY_DATE%>" size="8" id="<%=expiryDate+""+inc %>" MAXLENGTH="30" tabindex="1" readonly="readonly" tabindex="1"/>
			</td><td><img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+inc%>'),event);" />
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
			    	if(storeLoaninT.getQtyReceived() !=null){
					qty = storeLoaninT.getQtyReceived();
				}
			    }catch(Exception e)
				{
					qty = new BigDecimal(0);
				}
			    try
				{
			    	if(storeLoaninT.getUnitRate() !=null){
					rate = storeLoaninT.getUnitRate();
				}
			    }catch(Exception e)
				{
					rate = new BigDecimal(0);
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

			amount = qty.multiply(rate);
			//amountAfterTax = amount.add(tax);
			amountAfterdis = amount.subtract(discount);

			if(!discount.toString().equals("0.0000") && !amount.toString().equals("0")){
			discountPercent = (discount.multiply(new BigDecimal(100))).divide(amount,new MathContext(4));
			}
			BigDecimal convertedStockValue = new BigDecimal(0);

			if (formulaValue.equals("1"))
			{
			//	convertedStockValue = qty.multiply(mdqValue).divide(new BigDecimal(conversionFactorValue));
			}
			else if (formulaValue.equals("2"))
			{
				convertedStockValue = qty;
			}

			%>
			<td width="10%">
			<%if(storeLoaninT.getQtyReceived() !=null){ %>
			<input type="text" value="<%=storeLoaninT.getQtyReceived() %>" name="<%=QUANTITY_RECEIVED %>" size="8" tabindex="1" id="<%=quanRec+""+inc %>"	onblur="calculationInCRV();" tabindex="1"/>
			<%}else{ %>
			<input type="text" value="" name="quantityReceived" size="8" tabindex="1" id="<%=quanRec+""+inc %>"	onblur="calculationInCRV();" tabindex="1"/>
			<%} %>
			</td>
			</td>
				<td width="10%"><select name="dispenseType"
				id=<%=dispenseType+""+inc%>  tabindex="1" class="small">
				<option value="<%=storeLoaninT.getItem().getItemConversion().getIntermediateUnit().getUnitName()%>"><%=storeLoaninT.getItem().getItemConversion().getIntermediateUnit().getUnitName()%></option>
			</select></td>
					<td width="10%"><input type="text"
				value="" class="medcaption"
				name="mdq"  id="<%=mdq+""+inc%>" size="5" tabindex="2" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);"/>
			</td>
			
					<td width="10%">
				<%if(storeLoaninT.getUnitRate() !=null){%>
				<input type="text" value="<%=storeLoaninT.getUnitRate()%>" name="ratePerMdq" size="8" id="<%=ratePerMdq+""+inc %>" tabindex="1" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);" tabindex="1"/>
				<%}else{ %>
				<input type="text" value="" name="ratePerMdq" size="8" id="<%=ratePerMdq+""+inc %>" tabindex="1" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);" tabindex="1"/>
				<%} %>
				</td>
				
				
				<td >
				<input type="text" value="" name="<%=MRP %>" size="8" id="<%=mrp+""+inc %>" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);" tabindex="1"/>
				</td>
				
			
				
				<td width="3%">
				<input type="text"  value="" name="<%=DISCOUNT_PERCENTAGE%>" size="5" tabindex="1"	id="<%=discountVar+""+inc %>" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);"	validate="Discount,float,no" tabindex="1"/>
				<input type="hidden" value="" name="discountAmount"	id="<%=discountAmount+""+inc %>" tabindex="1"/>
				</td>
					<%if(choice.equals("l")){
		%>
			<!--<td width="10%"><input type="text" value="" 
				name="<%=TAX_AMT_MDQ %>" tabindex="2" onblur="calculationInCRV();"
				id="<%=TAX_AMT_MDQ +""+inc%>" />------>
			<td width="10%">
			<input type="text"  name="<%=TAX_PERCENT %>" value="" tabindex="1" id="<%=taxVar+""+inc %>" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);" size="5"  validate="Tax,float,no"/>
			<input type="hidden"  value="" name="taxAmount" id="<%=taxAmount+""+inc%>" />
			</td>
			<%} else { %>
			<td width="10%"><input type="text" name="<%=TAX_PERCENT %>" tabindex="1" id="<%=taxVar+""+inc%>" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);" validate="Tax,float,no" size="5" />
				 <input
				type="hidden"  value="" name="taxAmount"
				id="<%=taxAmount+""+inc%>" /></td>
			<%}%>
			<td width="10%">
			<input type="text" value="" name="<%= COST_PRICE %>"	id="<%=costPrice+""+inc%>" onblur="calculationInCRV();" size="8"  onfocus="calculateTotalCrvAmount(<%=inc%>);"/>
			</td>
			<td width="10%">
			<%if(storeLoaninT.getTotalCost() !=null){ %>
			<input type="hidden" value=""	 name="<%= COST_PRICE %>" id="<%=costPrice+""+inc %>" tabindex="1"/>
			<input type="text" value=""  name="<%=AMOUNT%>" size="8"	id="<%=amtVar+""+inc %>" readonly="readonly" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);" tabindex="1" />
			<%}else{ %>
			<input type="hidden" value=""	 name="<%= COST_PRICE %>" id="<%=costPrice+""+inc %>" tabindex="1"/>
			<input type="text" value=""  name="<%=AMOUNT%>" size="8"	id="<%=amtVar+""+inc %>" readonly="readonly" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);" tabindex="1" />
			<%} %>
			</td>
			<td><input type="text" name="<%=reasonForDemand%>" value="" tabindex="1"/></td>
<!-- -
			<td width="10%"><input type="text" value="0" 
				name="ed" readonly="readonly" id="<%=ed+""+inc%>" tabindex="2" /></td>

			

			<td width="3%"><input type="text" 
				value="<%=convertedStockValue%>" name="convertedStock"
				id="<%=convertedStock+""+inc%>" readonly="readonly" /></td>
 -->
		</tr>
		<% }
	} //for loop ends here %>


		<%
		List<StorePoDetail> storePoDetailList= new ArrayList<StorePoDetail>();
        List<StorePoHeader> storePoHeaderList= new ArrayList<StorePoHeader>();
 		if (map.get("poList")!=null)
	    {
 			storePoDetailList = (List) map.get("poList");
	    	noOfRows = storePoDetailList.size();
	    }
 		if (map.get("poHeadList")!=null)
	    {
 			storePoHeaderList = (List) map.get("poHeadList");
	    }
 		int tenderId = 0;
 		/* for(StorePoHeader sPH :storePoHeaderList){
 			if(sPH.getTenderM() != null){
 			tenderId = sPH.getTenderM().getId();
 			}else{
 			tenderId = 0;
 			}
 		} */

	   	if (storePoDetailList != null && storePoDetailList.size()>0)
	    {
	   		int rowLenSize=storePoDetailList.size();
    		 for(StorePoDetail storePoDetail : storePoDetailList)
	    	 {
    			 inc = inc + 1;
	    	 %>
		<tr>
			<td width="5%">
			<input type="text" size="1" value="<%=inc%>" name="<%=SR_NO%>" readonly="readonly" />
			</td>

			<input type="hidden" name="flag" value="LoanIn" />
			<td width="10%">
			<%if(storePoDetail.getItem().getPvmsNo()!=null){ %>
			<input type="text"	value="<%=storePoDetail.getItem().getPvmsNo() %>" tabindex="1"	onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');" name="<%=ITEM_CODE %>" size="6" id="<%=codeItem+""+inc%>" />
			<%}else{ %>
			<input	type="text" value=" "  name="<%=ITEM_CODE %>" size="6"	tabindex="1" id="<%=codeItem+""+inc%>" />
			<%} %>
			<input type="hidden" name="<%=DETAIL_ID %>"	value="<%=storePoDetail.getId() %>" id="hdb" />
			<input type="hidden" value="<%=storePoDetail.getItem().getId()%>" name="<%=ITEM_ID%>" id="<%=idItem+""+inc%>" />
					<%
					String expiryVal ="";
					if(storePoDetail.getItem().getExpiry() != null)
						expiryVal = storePoDetail.getItem().getExpiry();
				%>
			<input type="hidden" value="<%=expiryVal%>"  name="" id="<%=expiry+""+inc%>" />
			<input type="hidden" value="<%=storePoDetail.getItem().getItemConversion().getFormula()%>" name="" id="<%=formula+""+inc%>" />
			<input type="hidden" value="<%=storePoDetail.getItem().getItemConversion().getConversionFactor1()%>" name="" id="<%=conversionFactor+""+inc%>" />
			<input type="hidden" name="loanInItem" value="N0" id="loanInItem" />
			</td>

			<!--
		   <td width="10%">
	      	   <input type="text" value="<%=storePoDetail.getItem().getNomenclature() %>" id="<%=nameItem+""+inc%>" tabindex="1" class="bigcaption" name="<%=nameItem%>" />
		   </td>
		   -->

			<td width="10%">
			<input type="text"	value="<%=storePoDetail.getItem().getNomenclature()%>" id="<%=nameItem+""+inc%>" size="50"	onblur="if(fillSrNo('<%=inc%>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc%>');}"	name="<%=nameItem%>" tabindex="1" size="50" />
			<div id="ac2update"	style="display: none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%=nameItem+""+inc%>','ac2update','stores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
			</script>
			</td>
			<td width="10%">
			<input type="text"	value="<%=storePoDetail.getItem().getItemConversion().getIssueUnit().getUnitName() %>"	tabindex="1"  readonly="readonly" name="<%=AV%>" id="<%=idAu+""+inc%>" tabindex="1" size="7"/>
			</td>
			<td>
			<input type="text" name="barCodeNo" id=""<%=barCodeId+""+inc%>" value="" size="6" tabindex="1"/>
</td>
			<%

			int bId = 0;
			int mId = 0;
			String brandName = "";
			String manufacturer = "";
		   	if (brandList != null && brandList.size()>0)
		    {
	    		 for(MasStoreBrand masStoreBrand : brandList){
	    			 if(masStoreBrand.getItem().getId() == storePoDetail.getItem().getId()){
	    				 brandName = masStoreBrand.getBrandName();
	    				 bId = masStoreBrand.getId();
	    				 manufacturer = masStoreBrand.getManufacturer().getManufacturerName();
	    				 mId = masStoreBrand.getManufacturer().getId();
	    			 }
	    		 }
	    	}

			%>
			
		<td>
		<input type="text" name="BRAND_GEN" id=""<%="BrandGen"+""+inc%>" value="<%=storePoDetail.getItem().getBrandedGeneric() != null?storePoDetail.getItem().getBrandedGeneric():"B"%>" tabindex="" size="1"/>
		</td>
			
			<td width="10%">
			<select name="<%=BRAND_ID%>" tabindex="1" id="<%=brandId+""+inc%>" tabindex="1" >
				<option value="<%=bId%>"><%=brandName%></option>
			</select>
			</td>

			<td width="10%">
			<select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId+""+inc%> tabindex="1">
				<option value="<%=mId%>"><%=manufacturer%></option>
			</select>
			</td>

			

			<td width="10%">
			<input type="text" value="" name="<%=BATCH_NO %>"	onblur="fillSrNo('<%=inc%>');calculationInCRV();" tabindex="1"	id="<%=batchNo+""+inc%>" size="8" tabindex="1"/>
			</td>
			<!--
	       <td width="10%">
		       <input type="hidden" value=""  name="<%=LOT_NO %>" readonly="readonly" tabindex="2" id="<%=lotNo+""+inc%>"/>
	       </td>
 	       -->
			<td width="40%">
			<input type="text" value=""	name="<%=MANUFACTURING_DATE%>" size="9" id="<%=manufacturingDate+""+inc%>" MAXLENGTH="10" size tabindex="1" readonly="readonly" />
			</td><td><img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" OnClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+inc%>'),event);" />
			</td>
			<td width="40%">
			<input type="text" value=""	name="<%=EXPIRY_DATE%>" size="9" id="<%=expiryDate+""+inc %>" MAXLENGTH="10" tabindex="1" readonly="readonly" />
			</td><td><img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+inc%>'),event);" />
			</td>
			<td width="10%">
			<input type="text"	value="<%=storePoDetail.getQuantityOrdered() %>" name="<%=QUANTITY_RECEIVED %>" size="8" onblur="calculationInCRV();" tabindex="1" id="<%=quanRec+""+inc%>" />
			</td>
				<td width="10%"><select name="dispenseType"
				id=<%=dispenseType+""+inc%> tabindex="1">
				<option value="<%=storePoDetail.getDispType()%>"><%=storePoDetail.getDispType()%></option>
			</select></td>
					
					<td width="10%">
					<input type="text"
				value="<%=storePoDetail.getMdqValue()%>" class="medcaption"
				name="mdq" readonly="readonly" id="<%=mdq+""+inc%>" tabindex="2" size="5"/>
			</td>
			<!--
			<td width="10%">
			<input type="text"	value="<%=storePoDetail.getMrp()%>" name="<%=MRP %>" size="8" onblur="calculationInCRV();" tabindex="1" id="<%=mrp+""+inc %>" />
			</td>
			-->
			<%if(storePoDetail.getMrp() != null){%>
			<td width="10%"><input type="text"	value="<%=storePoDetail.getMrp()%>" name="ratePerMdq" size="8" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=rowLenSize%>);"	id="<%=ratePerMdq+""+inc%>" tabindex="1" /></TD>
			<%}else{ %>
			<TD><input	type="text" value=""	 name="ratePerMdq" size="8" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=rowLenSize%>);" id="<%=ratePerMdq+""+inc%>" tabindex="1" /></td>
			 <%}%>

			<td width="10%"><%try{%>
			<%if(storePoDetail.getMdqValue() != null && storePoDetail.getMdqValue()!=new BigDecimal(0.0))
			{
			float mrpPerAu=storePoDetail.getMrp().floatValue()/storePoDetail.getMdqValue().floatValue();%>
			<input type="text"	value="<%=mrpPerAu%>" name="mrp" size="8" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=rowLenSize%>);"	id="<%=mrp+""+inc %>" tabindex="1" />
			<%}else{ %>
			<input	type="text" value=""	 name="mrp" size="8" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=rowLenSize%>);"	id="<%=mrp+""+inc %>" tabindex="1" />
			 <%}%>
			 <%}catch(Exception e){%>
			 <input	type="text" value="0"	 name="mrp" size="8" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=rowLenSize%>);"	id="<%=mrp+""+inc %>" tabindex="1" />
			 <%}%>
			</td>


			<%
			BigDecimal tax = new BigDecimal(0);
	       	BigDecimal discount = new BigDecimal(0);
	       	BigDecimal qty = new BigDecimal(0);
	       	BigDecimal rate = new BigDecimal(0);
	       	BigDecimal amount  = new BigDecimal(0);
	       	BigDecimal amountAfterTax = new BigDecimal(0);
	       	BigDecimal aftersubdisAmount = new BigDecimal(0);
	       	BigDecimal amountAfterdis = new BigDecimal(0);


	       	BigDecimal mdqValue = new BigDecimal(0);
	       	String formulaValue = "";
	       	int conversionFactorValue = 0;

		    float taxPercent = 0f;
		    float discountPercent = 0f;


		    try
			{
				qty = storePoDetail.getQuantityOrdered();
			}
			catch(Exception e)
			{
				qty = new BigDecimal(0);
			}

		    try
			{
				rate = storePoDetail.getRatePerMdq();
			}
			catch(Exception e)
			{
				rate = new BigDecimal(0);
			}

		    try
			{
				//tax = storePoDetail.getTaxAmtPerMdq();
			}
			catch(Exception e)
			{
				tax = new BigDecimal(0);
			}

			try
			{
				discount = storePoDetail.getDiscountAmount();
			}
			catch(Exception e)
			{
				discount = new BigDecimal(0);
			}

			try
			{
				formulaValue = storePoDetail.getItem().getItemConversion().getFormula();
			}
			catch(Exception e)
			{
				formulaValue = "";
			}


			try
			{
				conversionFactorValue = storePoDetail.getItem().getItemConversion().getConversionFactor1();
			}
			catch(Exception e)
			{
				conversionFactorValue = 0;
			}

			try
			{
				mdqValue = storePoDetail.getMdqValue();
			}
			catch(Exception e)
			{
				mdqValue = new BigDecimal(0);
			}

		//	amount = qty.multiply(rate);
			//aftersubdisAmount = amount.subtract(discount);
			//amountAfterdis  = amount.add(discount);
			//amountAfterTax = aftersubdisAmount.add(tax);


			//taxPercent = tax.divide(amountAfterTax).multiply(new BigDecimal(100)).floatValue();
			//discountPercent = discount.divide(amountAfterdis).multiply(new BigDecimal(100)).floatValue();


			%>
-->
			<td width="3%">
			<input type="text" value="<%=storePoDetail.getDiscountPercent()%>" name="<%=DISCOUNT_PERCENTAGE%>" size="5"	onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=rowLenSize%>);" tabindex="1" id="<%=discountVar+""+inc%>" />
			<input type="hidden" value="<%=storePoDetail.getDiscountPercent()%>" name="discountAmount" id="<%=discountAmount+""+inc%>" />
			</td>
			<td width="10%">
			<input type="text"  name="<%=TAX_PERCENT %>" value="<%=storePoDetail.getTaxPercent()%>" tabindex="1" id="<%=taxVar+""+inc%>" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=rowLenSize%>);" validate="Tax,float,no" size="5"/>
			<input type="hidden"  value="<%=storePoDetail.getTaxAmount()%>" name="taxAmount" id="<%=taxAmount+""+inc%>" />
			</td>
			<td width="10%">
			<% 
			Tot=Tot+storePoDetail.getAmount().floatValue();
			%>
			<input type="text" value="<%=storePoDetail.getUnitRate()%>" name="<%= COST_PRICE %>"	id="<%=costPrice+""+inc%>"  onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=rowLenSize%>);" size="8"/>
			</td>
			<td width="10%">
			<input type="text" value="<%=storePoDetail.getAmount()%>" 	name="<%=AMOUNT %>" tabindex="1" readonly="readonly"	id="<%=amtVar+""+inc%>"    onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=rowLenSize%>);" size="8"/>
			<td><input type="text" name="<%=reasonForDemand%>" value="" tabindex="1"/></td>
			<%-- <%if(storePoDetail.getPreId()!=null){%>
			<input type="hidden" name="PreId" id="<%="PreId"+""+inc%>" value="<%=storePoDetail.getPreId()%>"/>
			<%}else{%>
		   <input type="hidden" name="PreId" id="<%="PreId"+""+inc%>" value="0"/>
			<%}%> --%>
			</td>
			
				<td>
			    <input name="Button" type="button" class="buttonAdd" value="" onclick="addRow('grnDetails',<%=inc%>);" tabindex="1" />
		   </td>
		   <td>
				<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grnDetails',<%=inc%>,this);" tabindex="1" />

		   </td>		
	
			
		</tr>
		<% }
	} //for loop ends here %>
	
	

	
	
        <input type="hidden" name="gridSize" id="gridSize" value="<%=inc%>"/>
</table>
</div>
<div class="clear"></div>
<div class="Block">
<!-- -
<label>Total Cost</label>
<input type="text" id="total_cost" name="totalCost" value="" readonly="readonly" tabindex="1"/> -->
<label>Total Amount</label>
<input type="text" id="total_amount" name="actualGrnValue" value="<%=Tot%>" readonly="readonly"    tabindex="1"/>
</div>
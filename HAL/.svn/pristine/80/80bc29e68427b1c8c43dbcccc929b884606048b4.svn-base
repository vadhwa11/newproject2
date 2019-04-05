<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> utilMap = new HashMap<String, Object>();

int poId = 0;

List<StorePoHeader> poNumberList = new ArrayList<StorePoHeader>();

if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}

utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");  
String currentTime = (String)utilMap.get("currentTime");

if (map.get("poNumberList") != null) {
	poNumberList = (List<StorePoHeader>)map.get("poNumberList");
}
List<StorePoHeader> poDetailsList = new ArrayList<StorePoHeader>();
if (map.get("poDetailsList") != null) {
	poDetailsList = (List<StorePoHeader>)map.get("poDetailsList");
}
StorePoHeader poHeader = new StorePoHeader();
if(poDetailsList.size() > 0){
	poHeader = poDetailsList.get(0);
}

%>



<%@page import="jkt.hms.masters.business.StorePoHeader"%>


<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="java.util.HashSet"%><div class="Block">

<input type="hidden" value="<%out.print(poHeader.getPoNumber() !=null?poHeader.getPoNumber():"NA"); %>" name="poNo" id="poNumber"/>
<label>SO No.</label>
<select name="<%=PO_ID%>" id="poId" onchange="selectPOID(this.value);" >
<option value="0">Select</option>
<%	for(StorePoHeader obj: poNumberList){%>
				<option value="<%=obj.getId() %>"><%=obj.getPoNumber() %></option>
			<%} %>
 
</select>
<script>
document.getElementById('poId').value = '<%=poHeader.getId()%>';
</script>
<label> SO Date <span>*</span></label>
<input type="text" name="<%=PO_DATE%>" class="date" id="soDate" onblur="getCurSOAmount();" value="<%=poHeader.getPoDate()!=null?HMSUtil.convertDateToStringWithoutTime(poHeader.getPoDate()):"" %>" class="" readonly="readonly" style="border: 1px solid #7f9db7;" validate="S.O. Date,dateOfAdmission,yes"  MAXLENGTH="30"  />

<label class="auto"> Vendor  <span>*</span></label>
<label class="value"><%=poHeader.getSupplier().getSupplierName() %></label>
<input class="transparent" size="1" />
<div class="clear"></div>
<label> Delivery Date <span>*</span></label>
<label class="value"><%=poHeader.getDeliveryDate()!=null?HMSUtil.convertDateToStringWithoutTime(poHeader.getDeliveryDate()):"" %></label>
	<label>Reference</label>
	<input	type="text"  name="references" value="<%=poHeader.getReferences()!=null?poHeader.getReferences():"" %>" readonly="readonly" validate="references,String,no" tabindex=1 />
	<label>Category <span>*</span></label>
	<label class="value"><%=poHeader.getCategory()!=null? poHeader.getCategory():""%></label>
	
	<div class="clear"></div>
	 
	
	<label>Contact No.</label>
	<label class="value"><%=poHeader.getTelephoneNo()!=null?poHeader.getTelephoneNo():"" %></label>
	<label>Code Head</label>
	<label class="value"><%=poHeader.getCodehead()!=null?poHeader.getCodehead():"" %></label>
	<input	type="hidden"  name="codehead" value="LCH-749/01"  validate="codehead ,String,no" tabindex=1 />
	<input	type="hidden"  name="requestType"  id="reqType" value="" />
	
	
	<label>Remarks</label>
	<label class="value"></label>
</div>  

	<div class="clear paddingTop15"></div>
		
<div class="cmntable">
	  	<table align="center" width="100%" id="localSupply" colspan="7"  class="grid_header" border="0" cellpadding="0" cellspacing="0">
		<thead>
		<tr>
		<!-- -
          <th width="5%"></th> -->
             <th>Delete</br>Row</th>
	      <th width="5%">Sl</br>No.</th>
	      <th width="13%">PVMS</br>/NIV No.</th>
	      <th width="13%">Nomenclature</th>
	      <th width="13%">A/U</th>
	      <th width="13%">B/G</th>
	       <th width="13%">Brand</br>Name</th>
	      <th width="13%">Manufacturer</th>
	      <th width="13%">Qty</br>Req.</th>

	 		<th width="9%">Dispense</br>Type</th>
		  <th width="6%">Packaging</th>
		   <th width="10%">Ordered</br>quantity(OQ)</th>
		 
	 
	
	      <th width="10%">MRP per</br>Packaging</th>
	      <th width="13%">Disc(%)</th>
	      <th width="6%">Tax(%)</th>
	      	<th width="9%">Actual</br>Cost</th>
	      <th width="13%">Amount</th>
	      <th>Add Row</th> 	
	   
	  
    	</tr>
    
  </thead>
  <tbody>
  
   	<%
  		int detailCounter=200; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	String idBg="idBg";
    	String quantityInVar="quantityInVar";
    	String taxVar="taxVar";
    	String unitRateVar="unitRateVar";
    	String amountVar = "amountVar";
    	String discountVar="discountVar";
    	
    	String quantityInVarTemp="quantityInVarTemp";
    	String taxVarTemp="taxVarTemp";
    	String unitRateVarTemp="unitRateVarTemp";
    	String amountVarTemp = "amountVarTemp";
    	String costPrice="costPrice";
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
    	String deleteRow="deleteRow";
    	
    	String totRateOq = "totRateOq";
    	String exciseDuty = "exciseDuty";
    	String taxOq = "taxOq"; 
    	String prescription_id="prescription_id";
        	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";
    	String idBg2="idBg";
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
    	String costPrice2="costPrice";
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
    	String prescription_id2="prescription_id";
    	String deleteRow2="deleteRow";
    	int inc=1;
	
    	Set<StorePoDetail> storePoDetails = new HashSet<StorePoDetail>();
    	storePoDetails = poHeader.getStorePoDetails();
    	 for(StorePoDetail poDetail : storePoDetails){
     		
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idAu=idAu2+(""+inc);
     		idBg=idBg2+(""+inc);
     		
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
     		costPrice=costPrice2+(""+inc);
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
        	prescription_id=prescription_id2+(""+inc);
        	deleteRow=deleteRow2+(""+inc);
    %>
   <tr>
       <td>
				<input type="checkbox" name="delete" value="<%=poDetail.getId() %>"   id="<%=deleteRow%>" tabindex="1" />
	  </td>
      <td width="3%">
      <input type="hidden" name="poDetailId" value="<%=poDetail.getId() %>">
      <input type="text" size="3" value="<%=temp+inc%>"  name="<%=SR_NO%>" readonly="readonly" />
	  <input type="hidden" size="2" value="<%=poDetail.getItem().getId() %>" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem%>" />
      <input type="hidden" value="" class="smcaption" name="" id="<%=formula%>" />
	  <input type="hidden" value="" class="smcaption" name="" id="<%=conversionFactor%>" />
	  </td>
      <td width="10%">
	     <input type="text" name="<%=ITEM_CODE %>" value="<%=poDetail.getItem().getPvmsNo() %>" tabindex="1" id="<%=codeItem%>" onblur="autocompleteBasedOnPvms(this.value,'<%=inc %>');" validate="PVMS No,String,no" size="8"/>
      </td>
      
		<td width="17%">
      	<input type="text" value="<%=poDetail.getItem().getNomenclature() %>"	id="<%=nameItem%>"  onblur="if(fillSrNo('<%=inc %>') && fillSrNoForRowSize('<%=inc %>')){checkForPurchase(this.value, '<%=nameItem%>','<%=inc %>');}"  name="<%=nameItem%>" tabindex="1" size="30" />
		<div id="ac2update" style="display:none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
	    new Ajax.Autocompleter('<%=nameItem%>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=<%=nameItem%>&poId='+document.getElementById('poId').value });
		</script>
		</td> 
      <td width="10%">
      <input type="text" value="<%=poDetail.getItem().getItemConversion().getItemUnitName() %>" class="smcaption" readonly="readonly" name="<%=AV%>" id="<%=idAu%>" tabindex="1" validate="A/U ,String,no" size="5"/>
      </td>
       <td width="10%">
       <select name="<%=BG%>" id="<%=idBg%>" tabindex="1" validate="BG ,String,no" class="auto">
             <option value="B">B</option>
             <option value="G">G</option>
             <option value="O">O</option>
             <option value="S">S</option>
             <option value="L">L</option>
             <option value="X">X</option>
             <option value="T">T</option>
             <option value="R">R</option>
             <option value="M">M</option>
             
      </select>
      <script>
      document.getElementById('<%=idBg%>').value = '<%=poDetail.getBrandedGeneric()!=null?poDetail.getBrandedGeneric():""%>';
      </script>
      
      </td>
      <td width="10%">
       <input type="text" value="<%=poDetail.getBrand()!=null?poDetail.getBrand().getBrandName():"" %>" size="12" readonly="readonly" name="brand" id="<%=idAu%>" tabindex="1" validate="A/U ,String,no" size="5"/>
         <input type="hidden" value="<%=poDetail.getBrand()!=null?poDetail.getBrand().getId():"0" %>" size="12" readonly="readonly" name="MANUFACTURER_ID" id="<%=manufacturerId%>" tabindex="1" validate="A/U ,String,no" size="5"/>
    
     
      </td>
      
      <td width="10%">
       <input type="text" value="<%=poDetail.getManufacturer()!=null?poDetail.getManufacturer().getManufacturerName():"" %>" size="12" readonly="readonly" name="<%=BRAND_ID%>" id="<%=brandId%>" tabindex="1" validate="A/U ,String,no" size="5"/>
         <input type="hidden" value="<%=poDetail.getManufacturer()!=null?poDetail.getManufacturer().getId():"0" %>" size="12" readonly="readonly" name="<%=MANUFACTURER_ID %>" id="<%=manufacturerId%>" tabindex="1" validate="A/U ,String,no" size="5"/>
      </td>

      <td width="10%">
       <input type="text" value="<%=poDetail.getLsoQty() %>" class="medcaption" name="" id="<%=actualqtyin %>"  size="5" validate="ActualQuantity,float,no" readonly="readonly" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" tabindex="1" maxlength="9"/>
      <input type="hidden" value="<%=poDetail.getLsoQty() %>" class="medcaption" name="<%=ACTUAL_QTY %>" id="<%=actualqty%>"/>
      <input type="hidden" name="prescription_id" value="0" id="<%=prescription_id%>"/> 
      </td>
	  <td width="10%">
      <input type="text" value="<%=poDetail.getDispType()!=null?poDetail.getDispType():"" %>" size="8" readonly="readonly" name="dipenseType" id="<%=dispenseType%>" tabindex="1" validate="A/U ,String,no" size="5"/>
      </td>
      <td width="10%">
      <input type="text" class="medcaption" name="mdq"  id="<%=mdq%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" size="7" validate="Minimum Dispensable Qty (MDQ),num,no" readonly="readonly" value="<%=poDetail.getMdqValue()!=null?poDetail.getMdqValue():"" %>" tabindex="1" maxlength="9"/>
      </td>
      <td width="10%">
      <input type="text" value="<%=poDetail.getQuantityOrdered()!=null?poDetail.getQuantityOrdered():"" %>" readonly="readonly" class="medcaption" name="" id="<%=quantityInVarTemp %>"  size="5" readonly validate="Quantity,float,no" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" tabindex="1" maxlength="9" />	
	 <input type="hidden" value="<%=poDetail.getQuantityOrdered()!=null?poDetail.getQuantityOrdered():"" %>" class="medcaption" name="<%=QUANTITY %>" id="<%=quantityInVar%>" />
      </td>
    
      
      <td width="10%">
      <input type="text" class="medcaption" value="<%=poDetail.getMrp()!=null?poDetail.getMrp():"" %>" name="mrp"  id="<%=mrp%>"  size="5" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" validate="Tax,float,no" readonly="readonly" maxlength="15" tabindex="1" size="5"/>
      </td>
      <td width="3%">
      <input type="text" class="medcaption" value="<%=poDetail.getDiscountPercent()!=null?poDetail.getDiscountPercent():"" %>" name="<%=DISCOUNT_PERCENTAGE%>" size="4" id="<%=discountVarTemp%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);"  readonly="readonly" validate="Discount,float,no" maxlength="6" tabindex="1" size="5"/>
      <input type="hidden" class="medcaption" value="<%=poDetail.getDiscountAmount()!=null?poDetail.getDiscountAmount():"" %>" name="<%=DISCOUNT_AMOUNT%>" id="<%=discountAmount%>"/>
      </td>
 
      <td width="10%">
      <input type="text" class="medcaption" value="<%=poDetail.getTaxPercent()!=null?poDetail.getTaxPercent():"" %>" name="<%=TAX_PERCENT %>" size="4" id="<%=taxVarTemp%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" readonly="readonly" validate="Tax,float,no" maxlength="15" tabindex="1"/>
                 <input type="hidden" class="medcaption" value="<%=poDetail.getTaxAmount()!=null?poDetail.getTaxAmount():"" %>" name="<%=TAX_AMOUNT%>" id="<%=taxAmount%>"/>
        
      </td>
     
       <td width="10%">
			<input type="text" value="<%=poDetail.getUnitRate()!=null? poDetail.getUnitRate():""%>"	 name="<%= COST_PRICE %>" id="<%=costPrice%>" size="5" readonly="readonly" tabindex="1"/></td>
		
      <td width="3%">
      <input type="text" class="medcaption" value="<%=poDetail.getAmount()!=null?poDetail.getAmount():"" %>" name="" id="<%=amountVarTemp%>" readonly="readonly" validate="Amount,float,no"  tabindex="1" size="8"/>
      <input type="hidden" class="medcaption" value="<%=poDetail.getAmount()!=null?poDetail.getAmount():"" %> " name="<%=AMOUNT%>"  id="<%=amountVar%>"/>
      </td>
      	<td>
			    <input name="Button" type="button" class="buttonAdd" value="" onclick="addRow('localSupply');" tabindex="1" />
		   </td>
		  
  
       </tr>
   <%
     	inc++; }   %>
	</tbody>
</table>
</div>
     	 <input type="hidden" id="gridSize" name="gridSize" value="<%=inc-1%>">
<input type="hidden" size="2"	value="<%=inc-1%>"  name="noOfRows" id="noOfRows" />

	
	<br />
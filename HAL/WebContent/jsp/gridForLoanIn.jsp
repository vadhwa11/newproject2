<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreLoaninM"%>
<%@page import="jkt.hms.masters.business.StoreLoaninT"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
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
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

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
   		rowVal=rowVal%25
   		if(rowVal==0){
   			rowVal=25
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}

</script>
<%
Map map = new HashMap();
Map<String, Object> utilMap = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}


List<StorePoHeader> poList= new ArrayList<StorePoHeader>();

if(request.getAttribute("map") != null)
{
	map = (Map)request.getAttribute("map");
poList=(List)map.get("second_combo");
	
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
String lotNoVar="lotNoVar";
String batchNoVar="batchNoVar";
String taxVar="taxVar";
String amountVar="amountVar";
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
String barCodeId="barCodeId";
String reasonForDemand="reasonForDemand";
%>

<div id="gridDiv">
<div class="cmntableWithHeight">
<table width="98%" colspan="7" id="grnDetails"   cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>Sl. No.</th>
			<th width="8%">PVMS/NIV	No.</td>
			<th width="9%">Nomenclature</th>
				<th width="9%">A/U</th>
			<th width="9%">BarCode No.</th>
			<th width="9%">B/G</th>
			<th width="9%">Brand Name</th>
			<th width="9%">Manufacturer Name</th>
		
			<th width="9%">Batch No</th>
						<th width="9%" colspan="2">DOM</th>
			<th width="9%" colspan="2">DOE</th>	 

			<th width="9%">Qty Received</label></th>
			<th width="9%">Dispense Type</th>
		    <th width="9%">Packaging</th>
			<th>MRP Per Pack </th>
			<th width="9%">MRP Per A/U</th>
			<th width="9%">Disc(%)</th>
			<th width="9%">Tax(%)</th>
			<th width="9%">Cost</th>
			<th width="9%">Amount</th>
			<th width="9%">Reason For Demand</th>
		</tr>
	</thead>
	<tbody>

		<%
	for(int t=1;t<26;t++)
	{
    %>
		<tr>
			<td width="5%">
			<input type="text" size="2" value="<%=t%>" name="<%=SR_NO%>" readonly="readonly" />
			</td>
			<td width="10%"><!--<input type="text" class="medcaption" name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem+""+t%>" />	-->
			<input type="text" size="12" name="<%=ITEM_CODE %>" id="<%=codeItem+""+t%>" onblur="autocompleteBasedOnPvms(this.value,'<%=t%>');"
				validate="PVMS No,String,no" tabindex="1" /> 
			<input type="hidden" name="flag" value="LoanIn" />
			<input type="hidden" size="2" value="0" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem+""+t%>" /> 
			<input type="hidden" value="" class="smcaption" name="" id="<%=expiry+""+t%>" /> 
			<input type="hidden" value="" class="smcaption" name="" id="<%=formula+""+t%>" /> 
			<input type="hidden" value="" class="smcaption" name="" id="<%=conversionFactor+""+t%>" />
			</td>

			<td width="10%">
			<input type="text" value=""	id="<%=nameItem+""+t%>" size="40" onblur="if(fillSrNo('<%=t %>')){checkForLoanIn(this.value, '<%=nameItem%>','<%=t %>');}"
				name="<%=nameItem%>" tabindex="1" />
			<div id="ac2update"	style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">

			function eventCallback(element, entry){
				return entry + "&poId=" + document.getElementById('poId').value; 
			}
			   new Ajax.Autocompleter('<%=nameItem+""+t%>','ac2update','stores?method=getItemListForLoanInByAutocomplete',{parameters:'requiredField=<%=nameItem%>', callback: eventCallback});
				   
		   </script></td>
		   
		   <td width="10%">
			<input type="text" value="" size="5" readonly="readonly" tabindex="1" name="<%=AV%>" id="<%=idAu+""+t%>" />
			</td>
		   
		   <td>
			<input type="text" name="barCodeNo" id=""<%=barCodeId+""+t%>" value="" tabindex=""/></td>
			
			<td>
			<input type="text" name="BRAND_GEN" id="<%="BrandGen"+""+t%>" value="" tabindex=""/>
			</td>
			
			<td width="10%">
			<select name="<%=BRAND_ID%>" id="<%=brandId+""+t%>" tabindex="1">
				<option value="">Select Brand</option>
			</select></td>

			<td width="10%">
			<select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId+""+t%> tabindex="1">
				<option value="">--Select Manuf--</option>
			</select>


			
			<td width="10%">
			<input type="text" value="" size="12" name="<%=BATCH_NO %>" tabindex="1" id="<%=batchNo+""+t%>" maxlength="10" />
			</td>

			<input type="hidden" value="" size="12" name="<%=LOT_NO %>"
				tabindex="1" id="<%=lotNo+""+t%>" maxlength="50" />

			<td width="50%">
			<input type="text" size="10" name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate+""+t%>" tabindex="1"  
				readonly="readonly" /> 
			</td>
			
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+t%>'),event)" />
			</td>

			<td width="40%">
			<input type="text" size="10" name="<%=EXPIRY_DATE%>" id="<%=expiryDate+""+t %>" tabindex="1"  readonly="readonly" /> 
			</td>
			
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+t %>'),event)" />
			</td>


			<td width="10%">
			<input type="text" value="0" size="12" name="<%=QUANTITY_RECEIVED %>" tabindex="1" id="<%=quanRec+""+t%>"
				onblur="calculationinLoanIn();" />
			<input type="hidden" value="0"	name="<%=FREE_QTY %>" id="<%=freeQty+""+t %>" size="5"/>
			
				</td>


			<%-- <td width="10%">
			<input type="text" value=""	name="<%=FREE_QTY %>" id="<%=freeQty+""+t %>" size="5"
				tabindex="1" onblur="calculationinLoanIn()" />
				</td>
--%>
			<td width="10%">
			
			<select name="dispenseType"
				id=<%=dispenseType+""+t%>>
			</select>

			<td width="10%">
			<input type="text" value="" size="12" name="mdq" id="<%=mdq+""+t%>" tabindex="1" />
			</td>

			<td width="10%">
			<input type="text" value="" size="12" name="ratePerMdq" id="<%=ratePerMdq+""+t%>" tabindex="1"
				onblur="calculationinLoanIn()" />
				<input type="hidden" size="12" value="" name="convertedStock" id="<%=convertedStock+""+t%>"/>
				</td>
				
				<td >
				<input type="text" value="0" name="<%=MRP %>" size="8" id="mrp" tabindex="1"/>
				</td>

			<%--<td width="3%">
			<input type="text" size="12" value="" name="convertedStock" id="<%=convertedStock+""+t%>"
				readonly="readonly" />
			</td>
 --%>
			<td width="3%">
			<input type="text" size="12" value="" 	name="<%=DISCOUNT_PERCENTAGE%>" tabindex="1"
				id="<%=discountVar+""+t%>" onblur="calculationinLoanIn();" validate="Discount,float,no" /> 
			<input type="hidden" size="12" value="" name="discountAmount" id="<%=discountAmount+""+t%>" />
			</td>

			<td width="10%">
			<input type="text" size="12" name="<%=TAX_PERCENT %>" tabindex="1" id="<%=taxVar+""+t%>"
				onblur="calculationinLoanIn();" validate="Tax,float,no" /> <!--<input type="hidden" class="medcaption" value="" name="taxAmount" id="<%=taxAmount+""+t%>" />-->
			</td>
			
			<td width="10%">
			<input type="text" value="0"	 name="<%= COST_PRICE %>" id="<%=costPrice+""+t%>" tabindex="1"/>
				</td>

			<td width="10%">
			<input type="hidden" value="n" size="12" name="<%=FREE_ITEM%>" id="<%=freeItem+""+t%>" readonly="readonly" />
			<input type="text" value="0" size="12" name="<%=AMOUNT%>" id="<%=amtVar+""+t%>" readonly="readonly" />
			</td>

			<%--<td width="10%">
			<select name="<%=FREE_ITEM %>"
				id="<%=freeItem+""+t%>" class="small" onChange="">
				<option value="n">No</option>
				<option value="y">Yes</option>
			</select>
			</td>
			
			 --%> 
			 <td>
			 <input type="text" name="<%=reasonForDemand%>" value="" tabindex="1"/>
			 </td>
		</tr>
		<% } // Code for Adding Empty Rows Ends Here %>
	</tbody>
</table>
</div>
</div>


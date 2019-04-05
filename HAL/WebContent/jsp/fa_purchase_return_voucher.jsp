<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>

<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasCostCenter"%>
<%@page import="jkt.hms.masters.business.FaMasNarration"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%><script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>


<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<script type="text/javascript">

	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
	<%--serverdate = '<%=curDate+"/"+month+"/"+year%>'  --%>
</script>
<form name="purchaseReturnVoucher" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
	List<FaMasNarration> narrationList = new ArrayList<FaMasNarration>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	if(map.get("costCenterList") != null){
		costCenterList = (List<MasCostCenter>)map.get("costCenterList");
	}
	if(map.get("supplierList") != null){
		supplierList = (List<MasStoreSupplier>)map.get("supplierList");
	}
	if(map.get("narrationList") != null){
		narrationList = (List<FaMasNarration>)map.get("narrationList");
	}
	int voucherNo = 0;
	if(map.get("voucherNo") != null){
		voucherNo = (Integer)map.get("voucherNo");
	}
String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}
%>
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="titleBg">
<h4>Purchase Return Voucher</h4>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<%--<label>Voucher No<span>*</span></label> --%>
 <input id="voucherNoId" type="hidden" readonly="readonly" size="5" name="<%=VOUCHER_NO%>" value="<%= voucherNo %>"  validate="Voucher No,string,no" MAXLENGTH="8"  tabindex=1 />

<label>Voucher Date<span>*</span></label>
<input type="text" name="<%=VOUCHER_DATE %>" id="voucherDate" value="<%=date %>" class="calDate" readonly="readonly" validate="Voucher Date ,date,no" MAXLENGTH="30" />

<div class="clear"></div>
</div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0"	id="voucherDetails" class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col" width="4"></th>
		<th scope="col">Account</th>
		<th scope="col">S L</th>
<%--		<th scope="col">CostCenter</th> --%>
		<th scope="col">Narration</th>
		<th scope="col">Dr</th>
		<th scope="col">Cr</th>
		<th scope="col"></th>
	</tr>

	<%int i = 1;%>
	<tr>
	<td><input type="radio" value="" name="selectedChrage" class="radioAuto" style="margin-right:5px;" /></td>
	<td width="4"><select id="drcr<%=i %>" name="drCr<%=i  %>" class="smallest" onchange="changeField(this.value,<%=i %>);">
		<option value="cr">Cr</option>
		<option value="dr">Dr</option>
		</select></td>
	<td> <input id="accountNameId<%=i%>" type="text" size="30"  name="accountName<%=i%>" value="" validate="Account,string,yes" tabindex=1 onblur="validateAccountName(this.value,<%=i %>,'slId')" />

				<div id="ac2update<%=i%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  function eventCallback(element, entry){
					return entry + "&amtType=" + document.getElementById('drcr<%=i%>').value+"&salesVoucherType=salesReturn";
				}
			  	new Ajax.Autocompleter('accountNameId<%=i%>','ac2update<%=i%>','account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName<%=i%>', callback: eventCallback});
			</script></td>
	<td id="slId<%=i %>"> <input  type="text"  readonly="readonly" name="<%=SUB_LEDGER_CODE%><%=i%>" value="" size="12"  /></td>
	<td> 
	 <div style="width:180px; float:left;">
	 <input id="accountNarrationId<%=i %>" type="text" size="18" class="large"  name="<%=ACCOUNT_NARRATION%><%=i%>" value=""  MAXLENGTH="100" tabindex=1 />
	<div id="ac2update<%=i%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  	new Ajax.Autocompleter('accountNarrationId<%=i%>','ac2update<%=i%>','account?method=getAccountNarrationForAutoComplete',{parameters:'requiredField=<%=ACCOUNT_NARRATION%><%=i%>'});
			</script>
	<input type="button" name="add"  value="" class="buttonAdd" onClick="addAccountsNarrationInAjax('cashVoucher',<%=i %>);" tabindex=1 />
	</div>
	</td>

	<td> <input id="drAmountId<%=i %>" type="text"  size="10" name="<%=DR_AMOUNT%><%=i%>" value="" disabled="disabled" onblur="totalDrCrAmount('dr');" validate="DrAmount,float,no"   MAXLENGTH="12" tabindex=1 /></td>
	<td> <input id="crAmountId<%=i %>" type="text"  size="10" name="<%=CR_AMOUNT%><%=i%>" value=""  onblur="totalDrCrAmount('cr');" validate="CrAmount,float,no"   MAXLENGTH="12" tabindex=1 /></td>
	<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
	</tr>
	
	<tr class="background">
		<td colspan=6 class="right">Total</td>
		<td><input id="totalDrAmountId" type="text" class="readOnlySmall" readonly="readonly" name="<%=TOTAL_DR_AMOUNT %>" validate="Total DrAmount,float,yes" value=""   MAXLENGTH="15" tabindex=1 /></td>
		<td colspan=2><input id="totalCrAmountId" type="text" class="readOnly" readonly="readonly" name="<%=TOTAL_CR_AMOUNT %>" value="" validate="Total CrAmount,float,yes" MAXLENGTH="15" tabindex=1 /></td>
	</tr>
	</table>
	</div>
	<div class="clear"></div>
<input type="button" name="delete" class="buttonDel" onClick="removeRow();" />
<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
<input type="hidden" value="flagOP" name="flagValueOP" id="flagValueOP" />
<div class="clear"></div>
<div class="clear"></div>
<div class="Block"><%-- 
<div class="floatRight">
	<label>Total </label>
	<label class="auto">Dr</label>
	<input id="totalDrAmountId" type="text" class="readOnlySmall" readonly="readonly" name="<%=TOTAL_DR_AMOUNT %>" value=""   MAXLENGTH="15" tabindex=1 />

	<label class="auto">Cr</label>
	<input id="totalCrAmountId" type="text" class="readOnly" readonly="readonly" name="<%=TOTAL_CR_AMOUNT %>" value=""  MAXLENGTH="15" tabindex=1 />
	</div>--%>
<div class="paddingTop40"></div>
<div class="clear"></div>
<label>Narration<span>*</span></label>
<input id="voucherNarrationId" type="text" name="<%=NARRATION %>" value="" class="extraLarge" MAXLENGTH="30" tabindex=1 />

<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  	new Ajax.Autocompleter('voucherNarrationId','ac2update','account?method=getNarrationForAutoComplete',{parameters:'requiredField=<%=NARRATION %>'});
			</script>

<input type="button" name="add" id="addbutton" value="Add TO Template" class="buttonBig" onClick="addNarrationInAjax('purchaseReturnVoucher');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="clear"></div>
<label>Supplier</label>
<select id="supplierId" name="supplierId">
<option value="0">Select</option>
<%if(supplierList.size()>0){
	for(MasStoreSupplier masStoreSupplier : supplierList){
	%>
	<option value="<%=masStoreSupplier.getId() %>"><%=masStoreSupplier.getSupplierName() %></option>
<%}} %>
</select>
<label>PO No.</label>
<input id="poNoId" type="text" name="poNo" value="" validate="PO No.,string,no" MAXLENGTH="30" tabindex=1 />
<label>PO Date:</label>
<input type="text" name="poDate" id="poDate" value="<%=date %>" class="calDate"  MAXLENGTH="8" />
<div class="clear" ></div>
<label>PO Amount</label>
<input id="poAmountId" type="text" name="poAmount" value="" validate="PO Amount,float,no" MAXLENGTH="15" tabindex=1 />
<label>Invoice No</label>
<input id="invoiceNoId" type="text" name="invoiceNo" value="" 	validate="Invoice No,string,no" MAXLENGTH="30" tabindex=1 />
<label>Invoice Date:</label>
<input type="text" name="invoiceDate" id="invoiceDate" value="<%=date %>" class="calDate"  MAXLENGTH="8" />
<div class="clear"></div>
<label>Invoice Amount</label>
<input id="invoiceAmountId" type="text" name="invoiceAmount" value="" 	validate="Invoice Amount,float,no" MAXLENGTH="15" tabindex=1 />

</div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('purchaseReturnVoucher','account?method=submitPurchaseReturnVoucher','validateNarration','validateTotalDrCr');" accesskey="a" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

  <div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %> </label>

<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
 <label class="value"><%=time%></label>
  <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName %>" />
   <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
    <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>



<div class="clear"></div>
<div class="clear"></div>
<script type="text/javascript">
var costCenterArray =new Array();
</script>
<%  int j=0;

for(MasCostCenter masCostCenter:costCenterList){
%>
<script>
			costCenterArray[<%=j%>]= new Array();
			costCenterArray[<%=j%>][0] = "<%=masCostCenter.getId()%>";
			costCenterArray[<%=j%>][1] = "<%=masCostCenter.getCostCenterName()%>";

		</script>
<%j++;} %>
<script type="text/javascript">
function addRow(){
	var tbl = document.getElementById('voucherDetails');
	var lastRow = tbl.rows.length-1;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;



	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'radio';
	e0.name='selectedChrage';
	e0.className='radioAuto';
	e0.style.marginRight = "5px";
	
	e0.value=(iteration);
	cell0.appendChild(e0);

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('select');
	e1.options[1] = new Option('Cr', 'cr','selected');
	e1.options[2] = new Option('Dr', 'dr');
	e1.name="drCr"+iteration;
	e1.id ="drCr"+iteration;
	e1.setAttribute('validate','DrCr,string,yes');
	e1.className="smallest";
	e1.onchange=function(){changeField(this.value,iteration);};
	cell1.appendChild(e1);

	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.onblur=function(){
						validateAccountName(this.value,(iteration),'slId')
			  };
	e2.name = 'accountName'+ (iteration);
	e2.id = 'accountNameId' + (iteration);
	e2.setAttribute('validate','Account,string,yes');
	e2.tabIndex="1";
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
   	cell2.appendChild(e2);
	e2.focus();
    cell2.appendChild(newdiv);
	e2.size = '30';
  	new Ajax.Autocompleter('accountNameId'+ (iteration),'ac2update'+iteration,'account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName'+ (iteration)});


	var cell3 = row.insertCell(3);
	cell3.id='slId'+(iteration);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=SUB_LEDGER_CODE%>'+ (iteration);
	e3.id = 'subLedgerId'+(iteration)
	e3.size='12';
	e3.maxLength ='3';
	e3.readOnly = true;
	cell3.appendChild(e3);


	<%-- var cell4 = row.insertCell(4);
	var e4 = document.createElement('select');
	
	e4.name='<%=COST_CENTER_ID%>'+ (iteration);
	e4.id='costCenterId'+(iteration);
	e4.options[0] = new Option('Select', '0');
	for(var k = 0;k<costCenterArray.length;k++){
		e4.options[k+1] = new Option(costCenterArray[k][1],costCenterArray[k][0]);
	}
	e4.tabIndex='1';
	e4.className="small";
	cell4.appendChild(e4); --%>

	var cell5 = row.insertCell(4);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='<%=ACCOUNT_NARRATION%>'+ (iteration);
	e5.id='accountNarrationId'+(iteration);
	e5.size='18';
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
  	cell5.appendChild(e5);
	e5.focus();
    cell5.appendChild(newdiv);
  	new Ajax.Autocompleter('accountNarrationId'+ (iteration),'ac2update'+iteration,'account?method=getAccountNarrationForAutoComplete',{parameters:'requiredField=<%=ACCOUNT_NARRATION%>'+ (iteration)});

	var e51 = document.createElement('input');
	e51.type = 'button';
	e51.name='add';
	e51.className = 'buttonAdd';
	e51.tabIndex="1";
	e51.onclick = function(){
					addAccountsNarrationInAjax('cashVoucher', (iteration));

	}
	cell5.appendChild(e51);

	var cell6 = row.insertCell(5);
	var e6 = document.createElement('input');
	e6.type = 'text';
	e6.name='<%=DR_AMOUNT%>'+ (iteration);
	e6.id='drAmountId'+(iteration);
	e6.setAttribute('validate','Dr Amount,float,no');
	e6.disabled=true;
	e6.onblur = function(){
				totalDrCrAmount('dr');
	}
	e6.size="10";
	e6.tabIndex="1";
	cell6.appendChild(e6);

	var cell7 = row.insertCell(6);
	var e7 = document.createElement('input');
	e7.type = 'text';
	e7.name='<%=CR_AMOUNT%>'+ (iteration);
	e7.id='crAmountId'+(iteration);
	e7.setAttribute('validate','Cr Amount,float,no');
	e7.disabled=true;
	e7.onblur = function(){
				totalDrCrAmount('cr');
	}
	e7.size="10";
	e7.tabIndex="1";
	cell7.appendChild(e7);

	var cell8 = row.insertCell(7);
	var e8 = document.createElement('input');
	e8.type = 'button';
	e8.name='add';
	e8.className = 'buttonAdd';
	e8.tabIndex="1";
	e8.onclick = function(){
					addRow();
	}

	cell8.appendChild(e8);
}
function removeRow(){
	var tbl = document.getElementById('voucherDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");

 	if(tblRows.length-3==0){
        	alert("Can not delete all rows")
        	return false;
    }
 	var count = 0;
	count = document.getElementById('hiddenValueCharge').value;
	var totalCrAmt =0;
	var totalDrAmt =0;
	var amttype = "";
	for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
	{
		if (document.getElementsByName('selectedChrage')[counter].checked == true)
		{
		  	tbl.deleteRow(counter+1);

		}
	}
	for(i=1; i<=count; i++){
		var cramount = 0;
		var dramount = 0;
			if(document.getElementById('crAmountId'+i) && document.getElementById('crAmountId'+i).value != "" ){
				cramount = document.getElementById('crAmountId'+i).value;
				totalCrAmt = parseFloat(totalCrAmt)+parseFloat(cramount);
			}
		
			if(document.getElementById('drAmountId'+i) && document.getElementById('drAmountId'+i).value != "" ){
				dramount = document.getElementById('drAmountId'+i).value;
				totalDrAmt = parseFloat(totalDrAmt)+parseFloat(dramount);
			}
		
	}
	document.getElementById('totalCrAmountId').value = totalCrAmt;
	document.getElementById('totalDrAmountId').value = totalDrAmt;
}
function validateAccountName( strValue,inc,tdid ) {

 	if(strValue != "")
	{
 			var idx1 = strValue.lastIndexOf("[");
			var idx2 = strValue.lastIndexOf("]");
		   	var accountName = strValue.substring(0,idx1);

			idx1++;
			var id = strValue.substring(idx1,idx2);
		    if(id!="")
		    {
		    	submitProtoAjaxWithDivNameWithoutFormData('purchaseReturnVoucher','account?method=getSubLedgerForAccount&accName='+encodeURIComponent(strValue)+'&rowVal='+inc,tdid+inc);
		    }
	}
}


function validateNarration(){
var errMsg = "";
	var vNarrationId = document.getElementById('voucherNarrationId').value;
	var voucherNoId = document.getElementById('voucherNoId').value;
	var voucherDate = document.getElementById('voucherDate').value;

/* 	if(voucherNoId == 0){
		errMsg += "Voucher No can not be blank.\n";
	} */
	if(voucherDate == ""){
		errMsg += "Voucher Date can not be blank.\n";
	}
	if(vNarrationId == ""){
		errMsg += "Voucher Narration can not be blank.\n";
	}
	if(errMsg != ""){
		alert(errMsg);
		return false;
	}

	return true;
}

	function totalDrCrAmount(amttype)
	{
		var count = 0;
		count = document.getElementById('hiddenValueCharge').value;
		var totalCrAmt =0;
		var totalDrAmt =0;
		for(i=1; i<=count; i++){
			var cramount = 0;
			var dramount = 0;
			if(amttype == "cr"){
				if(document.getElementById('crAmountId'+i) && document.getElementById('crAmountId'+i).value != ""){
					cramount = document.getElementById('crAmountId'+i).value;
					totalCrAmt = parseFloat(totalCrAmt)+parseFloat(cramount);
				}
			}else if(amttype == "dr"){
				if(document.getElementById('drAmountId'+i) && document.getElementById('drAmountId'+i).value != ""){
					dramount = document.getElementById('drAmountId'+i).value;
					totalDrAmt = parseFloat(totalDrAmt)+parseFloat(dramount);
				}
			}
		}
		if(totalCrAmt != "0")
			document.getElementById('totalCrAmountId').value = totalCrAmt;
		if(totalDrAmt != "0")
			document.getElementById('totalDrAmountId').value = totalDrAmt;
	}

	function changeField(val,inc){
        var crChangeAmt = 0;
        var drChangeAmt = 0;
        if(val == 'dr'){
            if(document.getElementById('crAmountId'+inc).value != "" ){
                crChangeAmt = document.getElementById('crAmountId'+inc).value;
            }
            
            document.getElementById('drAmountId'+inc).disabled = false;
            document.getElementById('crAmountId'+inc).disabled = true;
            document.getElementById('crAmountId'+inc).value = "";
        }else if(val == 'cr'){
            if(document.getElementById('drAmountId'+inc).value != "" ){
                drChangeAmt = document.getElementById('drAmountId'+inc).value;
            }
            
            document.getElementById('crAmountId'+inc).disabled = false;
            document.getElementById('drAmountId'+inc).disabled = true;
            document.getElementById('drAmountId'+inc).value = "";
        }
        var totalCrAmt = 0;
        var totalDrAmt = 0;
        if(document.getElementById('totalCrAmountId').value!='')
            totalCrAmt = document.getElementById('totalCrAmountId').value;
        if(document.getElementById('totalDrAmountId').value!='')
            totalDrAmt = document.getElementById('totalDrAmountId').value;
        
        if(totalCrAmt != "0")
            document.getElementById('totalCrAmountId').value = parseFloat(totalCrAmt)-parseFloat(crChangeAmt);
        if(totalDrAmt != "0")
            document.getElementById('totalDrAmountId').value = parseFloat(totalDrAmt)-parseFloat(drChangeAmt);

    }

	function validateTotalDrCr(){
		var drTotal = document.getElementById('totalDrAmountId').value;
		var crTotal = document.getElementById('totalCrAmountId').value;
		if(parseFloat(drTotal) != parseFloat(crTotal)){
			alert("Total of Dr and Cr amount should be Equal.");
			return false;
		}
		return true;
	}


</script>


</form>
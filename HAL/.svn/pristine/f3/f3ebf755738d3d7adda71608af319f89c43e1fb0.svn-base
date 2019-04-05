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
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<form name="paymentVoucher" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
	List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
	List<FaMasNarration> narrationList = new ArrayList<FaMasNarration>();
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

	if(map.get("accList") != null){
		accList = (List<FaMasAccount>)map.get("accList");
	}

	if(map.get("costCenterList") != null){
		costCenterList = (List<MasCostCenter>)map.get("costCenterList");
	}
	if(map.get("narrationList") != null){
		narrationList = (List<FaMasNarration>)map.get("narrationList");
	}
	int mainAccountId = 0;
	if(map.get("mainAccountId") != null){
		mainAccountId = (Integer)map.get("mainAccountId");
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

<div class="clear"></div>
<div class="titleBg">
<h4>Receipt Voucher</h4>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Cash/Bank Account<span>*</span></label>
<select id="mainAccountId"  name="<%=ACCOUNT_ID %>" onchange="showBalanceInAjax('paymentVoucher');showBankDetails(this.value);" onblur="submitProtoAjaxWithDivName('paymentVoucher','account?method=checkForAccountType','checkNoDiv');">
<option value="0">Select</option>
	<%if(accList.size()>0){
		for(FaMasAccount faMasAccount :accList){
			if(faMasAccount.getId().equals(mainAccountId)){
		%>
		<option value="<%=faMasAccount.getId() %>" selected="selected"><%=faMasAccount.getAccDesc() %></option>
		<%}else{%>
				<option value="<%=faMasAccount.getId() %>"><%=faMasAccount.getAccDesc() %></option>

	<%	}
	}
		}%>
</select>

<script type="text/javascript">
showBalanceInAjax('paymentVoucher');
</script>
 <input id="groupId" type="hidden"  name="groupId" value=""   />
 <input id="subGroupId"  type="hidden"   name="subGroupId" value=""  />
<input type="hidden" value="flagOP" name="flagValueOP" id="flagValueOP" />
<div id="checkNoDiv"></div>
<div class="clear"></div>
<label>Balance:</label>
 <input id="balanceId" type="text"  size="5" name="<%=BALANCE_AMOUNT%>" value="" readonly="readonly" MAXLENGTH="8"  tabindex=1 />

<div class="clear"></div>
<%--<label>Voucher No<span>*</span></label>--%>
 <input id="voucherNoId" type="hidden"  size="5" name="<%=VOUCHER_NO%>" readonly="readonly" value="<%= voucherNo %>"  MAXLENGTH="8"  tabindex=1/ >

<label>Voucher Date<span>*</span></label> 
<input type="text" name="<%=VOUCHER_DATE %>" id="voucherDate" value="<%=date %>" class="calDate" readonly="readonly" MAXLENGTH="8" />

<div class="clear"></div>
<div id="bankDetails" style="display: none;">
<label>Bank Name<span>*</span></label>
 <input id="bankNameId" type="text"  size="5" name="<%=BANK_NAME %>"  value=""  MAXLENGTH="40"  tabindex=1 />

<label>Cheque No.<span>*</span></label>
<input id="chequeNoId" type="text"  size="5" name="<%=CHEQUE_NO%>"  value=""  MAXLENGTH="20"  tabindex=1 />

<label>Cheque Date<span>*</span></label>
<input type="text" name="<%=CHEQUE_DATE%>" id="chequeDate" value="<%=date %>" class="calDate"  MAXLENGTH="8" />
</div>

<div class="clear"></div>
</div>
<div class="paddingTop15"></div>
<!--  ======================================Table for cash voucher============================================================-->
<script type="text/javascript">
	function showBankDetails(accountId){
		
		var accSubGrpId= 0;
		<%for(FaMasAccount masAccount :accList){ %>
			if(<%=masAccount.getId()%> == accountId){
				accSubGrpId = '<%=masAccount.getAccountSubGroup().getId()%>';
			}
		<%}%>
		if(accSubGrpId == 2){
			
			document.getElementById('bankDetails').style.display = "none"	;

		}else if(accSubGrpId == 1){
			
			document.getElementById('bankDetails').style.display = "inline"
		}
	}

	function showGridForBank(accounId){
		var accSubGrpId= 0;
		<%for(FaMasAccount masAccount :accList){ %>
			if(<%=masAccount.getId()%> == accountId){
				accSubGrpId = '<%=masAccount.getAccountSubGroup().getId()%>';
			}
		<%}%>
		if(accSubGrpId == 2){
			document.getElementById('gridId').style.display = "inline"
			document.getElementById('gridBankId').style.display = "none"	;
			document.getElementById('flagForSL').value = 'cash';

		}else if(accSubGrpId == 1){

			document.getElementById('gridId').style.display = "none";
			document.getElementById('gridBankId').style.display = "inline"
			document.getElementById('flagForSL').value = 'bank';
		}

	}


</script>
<%-- <input type="hidden" id="flagForSL" name="flagForSL" value="bank"/>--%>
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="voucherDetails" class="cmntable">
	<tr>
		<th ></th>
		<th scope="col">Account</th>
		<th scope="col">S L</th>
		<%--<th scope="col">CostCenter</th> --%>
		<th scope="col">Narration</th>
		<th scope="col">Amount</th>
		<th scope="col">&nbsp;</th>
	</tr>

	<%int i = 1;%>
	<tr>
	<td><input type="radio" value="" name="selectedChrage" class="radioAuto" /></td>
	<td> <input id="accountNameId<%=i%>" type="text" size="42"  name="accountName<%=i%>" value=""    tabindex=1 onblur="validateAccountName(this.value,<%=i %>,'slId')" />
	<script type="text/javascript">
	document.getElementById('accountNameId<%=i%>').focus();
	</script>
				<div id="ac2update<%=i%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  	new Ajax.Autocompleter('accountNameId<%=i%>','ac2update<%=i%>','account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName<%=i%>'});
			</script></td>
	<td id="slId<%=i %>"> <input  type="text"   name="<%=SUB_LEDGER_CODE%><%=i%>" value=""    readonly="readonly" /></td>
	
	<td> <input id="accountNarrationId<%=i %>" type="text" size="20" class="large"  name="<%=ACCOUNT_NARRATION%><%=i%>" value=""   MAXLENGTH="100" tabindex=1 />
	<div id="ac2update<%=i%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  	new Ajax.Autocompleter('accountNarrationId<%=i%>','ac2update<%=i%>','account?method=getAccountNarrationForAutoComplete',{parameters:'requiredField=<%=ACCOUNT_NARRATION%><%=i%>'});
			</script>
	<input type="button" name="add"  value="" class="buttonAdd" onClick="addAccountsNarrationInAjax('paymentVoucher',<%=i %>);" />
	</td>

	<td> <input id="amountId<%=i %>" type="text"  name="<%=AMOUNT%><%=i%>" value="" onblur="totalCrAmount('cash');"   MAXLENGTH="8" tabindex=1 />
	<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
	</tr>
	<tr class="background">
	<td colspan=5 class="right">Total</td>
	<td><input id="totalAmountId" type="text"   name="<%=TOTAL_AMOUNT %>" value="" MAXLENGTH="100" tabindex=1 /></td>
	</tr>
	</table>
	</div>
		<input type="button" name="delete" class="buttonDel" onClick="removeRow();" />

<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
<div class="clear"></div>
<div class="Block">
<label><span>*</span>Narration</label>

<input id="voucherNarrationId" type="text" name="<%=NARRATION %>" value="" class="extraLarge"	 MAXLENGTH="190" tabindex=1 />


<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  	new Ajax.Autocompleter('voucherNarrationId','ac2update','account?method=getNarrationForAutoComplete',{parameters:'requiredField=<%=NARRATION %>'});
			</script>

<input type="button" name="add" id="addbutton" value="Add TO Template" class="buttonBig" onClick="addNarrationInAjax('paymentVoucher');" accesskey="a" tabindex=1 />
<div class="clear"></div></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('paymentVoucher','account?method=submitReceiptVoucher','validateNarration','validateFieldsFrCashVoucher');" accesskey="a" tabindex=1 />
  <input type="reset" name="Reset" id="reset"  value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

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
	e0.value=(iteration);
	cell0.appendChild(e0);

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.onblur=function(){
						validateAccountName(this.value,(iteration),'slId')
			  };
	e1.name = 'accountName'+ (iteration);
	e1.id = 'accountNameId' + (iteration);
	e1.tabIndex="1";
	e1.size = '42';
   	cell1.appendChild(e1);
	e1.focus();
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
    cell1.appendChild(newdiv);
  	new Ajax.Autocompleter('accountNameId'+ (iteration),'ac2update'+iteration,'account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName'+ (iteration)});


	var cell2 = row.insertCell(2);
	cell2.id='slId'+(iteration);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=SUB_LEDGER_CODE%>'+ (iteration);
	e2.id = 'subLedgerId'+(iteration)
	//e2.tabIndex="1";
	e2.maxLength ='3';
	e2.readOnly = true;
	cell2.appendChild(e2);


	var cell4 = row.insertCell(3);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='<%=ACCOUNT_NARRATION%>'+ (iteration);
	e4.id='accountNarrationId'+(iteration);
	e4.size='20';
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
  	 cell4.appendChild(e4);
    cell4.appendChild(newdiv);
  	new Ajax.Autocompleter('accountNarrationId'+ (iteration),'ac2update'+iteration,'account?method=getAccountNarrationForAutoComplete',{parameters:'requiredField=<%=ACCOUNT_NARRATION%>'+ (iteration)});

	var e41 = document.createElement('input');
	e41.type = 'button';
	e41.name='add';
	e41.className = 'buttonAdd';
	e41.tabIndex="1";
	e41.onclick = function(){
					addAccountsNarrationInAjax('paymentVoucher', (iteration));

	}
	cell4.appendChild(e41);

	var cell5 = row.insertCell(4);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='<%=AMOUNT%>'+ (iteration);
	e5.id='amountId'+(iteration);
	e5.onblur = function(){
					totalCrAmount('cash');
	}
	e5.maxLength='8';
	cell5.appendChild(e5);

	var cell6 = row.insertCell(5);
	var e6 = document.createElement('input');
	e6.type = 'button';
	e6.name='add';
	e6.className = 'buttonAdd';
	e6.tabIndex="1";
	e6.onclick = function(){
					addRow();
	}
	cell6.appendChild(e6);
}


function removeRow()
{
	var tbl = document.getElementById('voucherDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");

  	if(tblRows.length-3==0){
         	alert("Can not delete all rows")
         	return false;
     }

	for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
	{
		if (document.getElementsByName('selectedChrage')[counter].checked == true)
		{
		  	tbl.deleteRow(counter+1);

		}
	}
}

function removeBankRow()
{
	var tbl = document.getElementById('bankDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");

  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }

	for(counter=0;counter<document.getElementsByName('selectedBankChrage').length;counter++)
	{
		if (document.getElementsByName('selectedBankChrage')[counter].checked == true)
		{
		  	tbl.deleteRow(counter+1);

		}
	}
}
</script>


<script type="text/javascript">
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
		    	submitProtoAjaxWithDivNameWithoutFormData('paymentVoucher','account?method=getSubLedgerForAccount&accName='+encodeURIComponent(strValue)+'&rowVal='+inc,tdid+inc);
		    }
	}
}


function validateNarration(){
var errMsg = "";
	var vNarrationId = document.getElementById('voucherNarrationId').value;
	var cashAccountId = document.getElementById('mainAccountId').value;
	var voucherNoId = document.getElementById('voucherNoId').value;
	var voucherDate = document.getElementById('voucherDate').value;
	var totalAmountId = document.getElementById('totalAmountId').value;

	if(cashAccountId == 0){
		errMsg += "Cash Account can not be blank.\n";
	}
/* 	if(voucherNoId == 0){
		errMsg += "Voucher No can not be blank.\n";
	} */
	if(voucherDate == ""){
		errMsg += "Voucher Date can not be blank.\n";
	}
	if(vNarrationId == ""){
		errMsg += "Voucher Narration can not be blank.\n";
	}
	if(totalAmountId == ""){
		errMsg += "Total Amount can not be blank.\n";
	}

	if(errMsg != ""){
		alert(errMsg);
		return false;
	}

	return true;
}

	function totalCrAmount(flag)
	{
		var count = 0;
		var accountCrAmt = 0;var accountDrAmt = 0;
			if(flag == 'cash'){
				 count = document.getElementById('hiddenValueCharge').value;
			}else{
				 count = document.getElementById('hiddenValueChargeForBank').value;
			}
			var balance = document.getElementById('balanceId').value
			var balanceAmt = balance.substring(0,balance.indexOf(" "));
			var str = balance.substring(balance.indexOf(" "));
			if(trimAll(str) == "Dr"){
				accountDrAmt = parseFloat(balanceAmt);
			}else if(trimAll(str) == "Cr"){
				accountCrAmt = parseFloat(balanceAmt);
			}
			var drAmt = 0;
			var totalAmount = 0;
			var balanceAmt = 0;
			for(i=1; i<=count; i++){
			var amount = 0;
			if(flag == 'cash'){
				 drAmt = document.getElementById('amountId'+i).value;
				}else {
				 drAmt = document.getElementById('amountBankId'+i).value;
				}
				totalAmount = parseFloat(totalAmount)+parseFloat(drAmt);

			}
			document.getElementById('totalAmountId').value = totalAmount;
			if(parseFloat(drAmt) !=0){
				 if(parseFloat(accountCrAmt)!=0){
				 	 if(parseFloat(accountCrAmt) > parseFloat(drAmt) ){
				 		accountCrAmt = parseFloat(accountCrAmt)- parseFloat(drAmt);
				 	 }else if(parseFloat(drAmt) > parseFloat(accountCrAmt)){
				 		accountDrAmt =parseFloat(drAmt) - parseFloat(accountCrAmt);
				 	 }else if(parseFloat(drAmt) == parseFloat(accountCrAmt)){
				 		accountCrAmt =parseFloat(accountCrAmt)-parseFloat(drAmt) ;
			 		 }
					 }else {
			 		  accountDrAmt = parseFloat(accountDrAmt)+parseFloat(drAmt);
				  }
				}
		}

		function validateFieldsFrCashVoucher(){
		var msg ="";
		var count = document.getElementById('hiddenValueCharge').value;

			for(i=1; i<= count; i++){
		  			if(document.getElementById('accountNameId'+i).value == ""){
  					msg += "Account can not be blank.\n";
  				  	}
		  			if(document.getElementById('amountId'+i).value == ""){
	 					msg += "Amount can not be blank.\n";
  				  }
			}
			if(msg != ""){
				alert(msg);
				return false;
			}
			return true;
		}

	function validateAmount(amt,inc){
		if(!validateFloat(amt)){
			alert("Please enter valid amount.");
			document.getElementById('amountBankId'+inc).value = ""
			document.getElementById('amountBankId'+inc).focus();
			return false;
	}else{

		return true;

		}
	}





</script>


</form>
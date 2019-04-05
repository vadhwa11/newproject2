<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.MasApprovalStatus"%>
<%@page import="jkt.hms.masters.business.FaVoucherDetails"%>
<%@page import="jkt.hms.masters.business.FaVoucherHeader"%>
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

<form name="paymentVoucherApproval" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
	List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
	List<FaMasNarration> narrationList = new ArrayList<FaMasNarration>();
	List<MasApprovalStatus> approvalStatusList = new ArrayList<MasApprovalStatus>();
	List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
	List<FaVoucherHeader> voucherHeader = new ArrayList<FaVoucherHeader>();
	
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
	
	 if(map.get("voucherDetailList") != null){
		 voucherDetailList = (List<FaVoucherDetails>)map.get("voucherDetailList");
		}
	 
	 if(map.get("voucherHeader") != null){
		 voucherHeader = (List<FaVoucherHeader>)map.get("voucherHeader");
		}
	
	
	if(map.get("approvalStatusList") != null){
		approvalStatusList = (List<MasApprovalStatus>)map.get("approvalStatusList");
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
<h4>Receipt Voucher Approval</h4>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>

	<%  if(voucherDetailList.size()>0){
		 for(FaVoucherDetails list : voucherDetailList){
		 if(list.getDrAmount()==null){%>
<label>Voucher Date<span>*</span></label>
<input type="text" name="<%=VOUCHER_DATE %>" id="voucherDate" value="<%=HMSUtil.convertDateToStringTypeDateOnly(list.getVoucherHeader().getVoucherDate())%>" class="calDate" tabindex=1  readonly="readonly" validate="Voucher Date ,date,no" MAXLENGTH="30" />			 
<label>Cash/Bank Account<span>*</span></label>
	<input readonly type="text" name="mainAccount" id="mainAccount" value="<%=list.getAccount().getAccDesc()%>" />
	<input type="hidden" name="accountId" id="mainAccountId" value="<%=list.getAccount().getId()%>" />
	
<label>Subledger Account </label>
<input readonly type="text" name="subLedId" id="subLedId" value="<%=list.getSubLed()!=null?list.getSubLed().getSubLedDesc():""%>" />
<input  type="hidden" name="subLedId" id="subLedId" value="<%=list.getSubLed()!=null?list.getSubLed().getId():0%>" />	
<div class="clear"></div>	
<label>Cheque No/D.D No/Pay-in Slip/Challan</label>
<input readonly type="text" name="checkNo" validate="Check No.,string,no" id="checkNoId" value="<%=list.getVoucherHeader().getChequeNo()!=null?list.getVoucherHeader().getChequeNo():""%>" />
<% }}}%> 
<script type="text/javascript">
showBalanceInAjax('paymentVoucherApproval');
</script>
<input id="groupId" type="hidden"  name="groupId" value=""   />
<div id="checkNoDiv"></div>
 <input id="subGroupId"  type="hidden"   name="subGroupId" value=""  />
 <div class="clear"></div>
<label>Balance:</label>
<input id="balanceId" type="text"   name="<%=BALANCE_AMOUNT%>" readonly="readonly" value=""   tabindex=1 />
<div class="clear"></div>


<input id="voucherNoId" type="hidden"  size="5" name="<%=VOUCHER_NO%>" readonly="readonly" value="<%= voucherNo %>"  MAXLENGTH="8"  tabindex=1/ >


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

<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="voucherDetails" class="cmntable">
	<tr id=th>
		<th scope="col"></th>
		<th scope="col">Account</th>
		<th scope="col">S L</th>
		<th scope="col">Narration</th>
		<th scope="col">Amount</th>
	</tr>

		<%int i=1;%>
	<%if(voucherDetailList.size()>0){
		 for(FaVoucherDetails list : voucherDetailList){
		 if(list.getCrAmount()==null){%>
	<tr id="<%=list.getId()%>">
	<td><input type="radio" value="" name="selectedChrage"  class="radiobutMargin" /></td>
	<td><input id="accountNameId<%=list.getId()%>" readonly  type="text" size="30"  name="accountName<%=list.getId()%>" value="<%=list.getAccount().getAccDesc() + "[" + list.getAccount().getAccCode() +"]" %>"  tabindex=1  />
		
	<td id="slId<%=i %>"> 
	 <input  type="text"   name="<%=SUB_LEDGER_CODE%><%=list.getId()%>" value="<%=list.getSubLed()!=null?list.getSubLed().getSubLedDesc():"" %>"  readonly="readonly"  size="40"/>
	</td>
	<td><input id="accountNarrationId<%=list.getId()%>" type="text" size="18" class="large"  name="accountNarrationId<%=list.getId()%>" value="<%=list.getNarration()!=null?list.getNarration():"" %>"  MAXLENGTH="100" tabindex=1 /></td>
	<td> <input id="amountId<%=list.getId() %>" type="text"  name="<%=AMOUNT%><%=list.getId()%>" value="<%=list.getDrAmount() %>" onblur="totalCrAmount('cash','voucherDetails'); checkTotalAmountValueWithCashACC(<%=list.getId()%>)"   validate="Amount,float,yes"  tabindex=1 />
	</tr>
	<%}}}%>
	</table>
	<table>
	<tr class="background">
	<td colspan=5 class="right">Total</td>
	<%if(voucherHeader.size()>0){
		for(FaVoucherHeader header: voucherHeader){%>
	<td><input id="totalAmountId" type="text"   name="<%=TOTAL_AMOUNT %>" value="<%=header.getCrAmount()%>"  validate="Total Amount ,string,no" MAXLENGTH="100" tabindex=1 readonly /></td>
	<%}}%>
	</tr>
	</table>
	</div>

<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
<input type="hidden" id="tableRowId" name="tableRowId" value="1"/>
<div class="clear"></div>
<div class="Block">
<label>Narration<span>*</span></label>
<%if(voucherHeader.size()>0){
		for(FaVoucherHeader header: voucherHeader){%>
<input id="voucherNarrationId" type="text" name="<%=NARRATION %>" value="<%=(header.getNarration()!=null)?header.getNarration():"" %>" class="extraLarge" MAXLENGTH="190" tabindex=1 />
<input type="hidden" value="<%=header.getId()%>" name="voucherHeaderId" id="voucherHeaderId" />
<%}}%>
<div class="clear"></div>
<label>Approval Status<span>*</span></label> 
		<select name="ApprovalStatusId" validate="Approval Status,int,yes" id="ApprovalStatusId" tabindex="1" >
			<option value="0">Select</option>
			
			<% for (MasApprovalStatus masApprovalStatus : approvalStatusList) {
			if(masApprovalStatus.getStatusCode().equalsIgnoreCase("AP") || masApprovalStatus.getStatusCode().equalsIgnoreCase("RJ")){%>
			<option value="<%=masApprovalStatus.getId()%>"><%=masApprovalStatus.getStatusName()%></option>
			<%}}%>
		</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('paymentVoucherApproval','account?method=submitReceiptVoucherApproval','validateNarration','validateFieldsFrCashVoucher');" accesskey="a" tabindex=1 />
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
		    	submitProtoAjaxWithDivName('paymentVoucher','account?method=getSubLedgerForAccount&accName='+encodeURIComponent(strValue)+'&rowVal='+inc,tdid+inc);
		    }
	}
}


function validateNarration(){
var errMsg = "";
	var vNarrationId = document.getElementById('voucherNarrationId').value;
	var cashAccountId = document.getElementById('mainAccountId').value;
	var voucherDate = document.getElementById('voucherDate').value;
	var totalAmountId = document.getElementById('totalAmountId').value;

	if(cashAccountId == 0){
		errMsg += "Cash Account can not be blank.\n";
	}
	
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


function totalCrAmount(flag,tableId){
	var j= $j("#"+tableId+" tr:last").attr("id");	
	if(j == "th")
	{
		
	}
else
	{
		j=j*1;
		
	}
	  var valRowId = new Array();
		$j("#"+tableId+" tr[id!='th']").each(function(j)
				{				
					valRowId[j] =$j(this).attr("id");
				});
		$j("#tableRowId").val(valRowId);
	
			var count = 0;
			var accountCrAmt = 0;
			var accountDrAmt = 0;
			
			var balance = document.getElementById('balanceId').value;
				var balanceAmt = balance.substring(0,balance.indexOf(" "));
				var str = balance.substring(balance.indexOf(" "));
				if(trimAll(str) == "Dr"){
					accountDrAmt = parseFloat(balanceAmt);
				}else if(trimAll(str) == "Cr"){
					accountCrAmt = parseFloat(balanceAmt);
				}
			var crAmt = 0;
			var totalAmt =0;
				for(i=0; i<=valRowId.length-1; i++){
				if(flag == 'cash'){
					 crAmt = document.getElementById('amountId'+valRowId[i]).value;
					}
					totalAmt = parseFloat(totalAmt)+parseFloat(crAmt);
				}
				document.getElementById('totalAmountId').value = totalAmt;
				if(parseFloat(crAmt)!= 0){
				if(parseFloat(accountDrAmt)!= 0){
				  if(parseFloat(accountDrAmt) > parseFloat(crAmt) ){
					    accountDrAmt =parseFloat(accountDrAmt) - parseFloat(crAmt);
				  }else if(parseFloat(crAmt) > parseFloat(accountDrAmt) ){
					    accountCrAmt = parseFloat(crAmt)- parseFloat(accountDrAmt);
				 	 }else if(parseFloat(crAmt) == parseFloat(accountDrAmt)){
				 		accountDrAmt =parseFloat(accountDrAmt)-parseFloat(crAmt) ;
				 	 }
				}else{
					 accountCrAmt = parseFloat(accountCrAmt) + parseFloat(crAmt);
				  }
					}
				}


		function validateFieldsFrCashVoucher(){
		var msg ="";
		var tableId='voucherDetails';
		var j= $j("#"+tableId+" tr:last").attr("id");	
		if(j == "th")
		{
			
		}
	else
		{
			j=j*1;
			
		}
		  var valRowId = new Array();
			$j("#"+tableId+" tr[id!='th']").each(function(j)
					{				
						valRowId[j] =$j(this).attr("id");
					});
			$j("#tableRowId").val(valRowId);
		
  					for(i=0; i<= valRowId.length-1; i++){
  						if(document.getElementById('accountNameId'+valRowId[i])){
		  			if(document.getElementById('accountNameId'+valRowId[i]).value == ""){
  					msg += "Account can not be blank.\n";
		  			}
  						}
  						if(document.getElementById('amountId'+valRowId[i])){
		  			if(document.getElementById('amountId'+valRowId[i]).value == ""){
	 					msg += "Amount can not be blank.\n";
		  			}
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

	function checkTotalAmountValueWithCashACC(inc)
	{
		var CashAccountValue = document.getElementById('balanceId').value; 
		var totalAmountId = document.getElementById("totalAmountId").value;
		
		if(CashAccountValue.indexOf("Cr") != -1)
			{
				alert("You are not able to generate the Payment Voucher as Sufficient Balance is not avilable. ");
				document.getElementById("amountId"+inc).value = "";
				document.getElementById("totalAmountId").value = "";				
				
			}
		
		if(CashAccountValue.indexOf("Dr") != -1)
		{				
			
			CashAccountValue = CashAccountValue.replace("Dr","");
			CashAccountValue=CashAccountValue.trim();
			CashAccountValue = CashAccountValue *1;
			totalAmountId = totalAmountId *1;
			
			if(CashAccountValue<totalAmountId)
				{
					alert("You are not able to generate the Payment Voucher as Sufficient Balance is not avilable. ");
					document.getElementById("amountId"+inc).value = "";
					document.getElementById("totalAmountId").value = "";		
				};
		};
	}
	window.addEventListener('load', function() {
	
		showCrBalanceInAjax('paymentVoucherApproval');
		
	})


</script>


</form>
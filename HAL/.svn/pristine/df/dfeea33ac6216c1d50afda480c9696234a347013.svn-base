<%@page import="jkt.hms.masters.business.FaVoucherDetails"%>
<%@page import="jkt.hms.masters.business.FaVoucherHeader"%>
<%@page import="jkt.hms.masters.business.MasApprovalStatus"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="java.math.BigDecimal"%>
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
	serverdate = '<%=curDate+"/"+month+"/"+year%>';
</script>
<form name="paymentVoucherApproval" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
	List<FaVoucherHeader> voucherHeader = new ArrayList<FaVoucherHeader>();
	List<MasApprovalStatus> approvalStatusList = new ArrayList<MasApprovalStatus>();
	
	List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>)request.getAttribute("map");
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
	 
	if(map.get("approvalStatusList") != null){
		approvalStatusList = (List<MasApprovalStatus>)map.get("approvalStatusList");
		}
	
	 if(map.get("voucherDetailList") != null){
		 voucherDetailList = (List<FaVoucherDetails>)map.get("voucherDetailList");
		}
	 
	 if(map.get("voucherHeader") != null){
		 voucherHeader = (List<FaVoucherHeader>)map.get("voucherHeader");
		}
	 
	 int locationId=0;
	 if(map.get("locationId") != null)
	 {
		 locationId =  (Integer)map.get("locationId");	  
		  
	  }
	 

%>
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<div class="titleBg">
<h4>Payment/Contra Voucher Approval</h4>
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
<input type="text" name="<%=VOUCHER_DATE %>" id="voucherDate" value="<%=HMSUtil.convertDateToStringTypeDateOnly(list.getVoucherHeader().getVoucherDate()).trim()%>" class="calDate" tabindex=1  readonly="readonly" validate="Voucher Date ,date,no" MAXLENGTH="30" />			 
<label>Cash/Bank Account<span>*</span></label>
<select readOnly="true" id="mainAccountId"  name="<%=ACCOUNT_ID %>"   onchange="showCrBalanceInAjax('paymentVoucherApproval');" onblur="submitProtoAjaxWithDivNameWithoutFormData('paymentVoucherApproval','account?method=checkForAccountType&accountId='+this.value,'checkNoDiv');" tabindex=1 >
	<!-- <option value="0">Select</option> -->
	<%
	if(accList.size()>0){
		for(FaMasAccount faMasAccount :accList){
		if(faMasAccount.getId() == list.getAccount().getId())
		{
		%>
		<option value="<%=faMasAccount.getId() %>"<%=(list.getAccount().getId()).equals(faMasAccount.getId())?"Selected":"" %>><%=faMasAccount.getAccDesc()%></option>
	<%}
	}}%>
</select>	
	<input type="hidden" name="mainAccount" id="mainAccount" value="<%=list.getAccount().getId()%>" />
	
<label>Subledger Account <span>*</span></label>
<input readonly type="text" name="subLedIddesc" id="subLedIddesc" value="<%=list.getSubLed()!=null?list.getSubLed().getSubLedDesc():""%>" />
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



</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<table id="voucherDetails" width="100%" border="0" cellspacing="0" cellpadding="5"   class="cmntable">
	<tr id="th">
		<th scope="col"></th>
		<th scope="col">Account</th>
		<th scope="col">Sub Ledger</th>
		<th scope="col">Amount</th>
		<!-- <th scope="col">Remarks</th> -->
	</tr>

	<%int i=1;%>
	<%if(voucherHeader.size()>0){
		 for(FaVoucherHeader list : voucherHeader){%>
	<tr id="<%=i%>">
	<td><input type="radio" value="" name="selectedChrage"  class="radiobutMargin" /></td>
	<td><input id="accountNamedesc" readonly  type="text" size="30"  name="accountNamedesc" value="<%=list.getTransferedAccount().getAccDesc() + "[" + list.getTransferedAccount().getAccCode() +"]" %>"  tabindex=1  />
		<input id="accountNameId<%=i%>"   type="hidden" size="30"  name="accountName<%=i%>" value="<%=list.getTransferedAccount().getId() %>"  tabindex=1  />
	</td>	
	<td id="slId<%=i %>"> 
	 <input  type="text"   name="subLeddesc" value="<%=list.getTransferedAccountSubled()!=null?list.getTransferedAccountSubled().getSubLedDesc():"" %>"  readonly="readonly"  size="40"/>
	 <input  type="hidden"   name="<%=SUB_LEDGER_CODE%><%=i%>" value="<%=list.getTransferedAccountSubled()!=null?list.getTransferedAccountSubled().getId():"" %>"    size="40"/>
	</td>
	<td> <input id="amountId<%=i %>" type="text"  name="<%=AMOUNT%><%=i%>" value="<%=list.getDrAmount() %>" onblur="totalCrAmount('cash','voucherDetails'); checkTotalAmountValueWithCashACC(<%=i%>)"   validate="Amount,float,yes"  tabindex=1 />
	<%-- <td> <input readonly id="remarks<%=i %>" type="text"  name="remarks<%=i%>" value=""   validate="Remarks,String,no"  tabindex=1 /> --%>
	
	</tr>
	<%}}%>
	</table>
	<table>
	<tr class="background">
	<td colspan=3 class="right">Total</td>
	<%if(voucherHeader.size()>0){
		for(FaVoucherHeader header: voucherHeader){%>
	<td><input id="totalAmountId" type="text"   name="<%=TOTAL_AMOUNT %>" value="<%=header.getCrAmount()%>"  validate="Total Amount ,string,no" MAXLENGTH="100" tabindex=1 readonly /></td>
	<%}}%>
	</tr>
	</table>
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
  <input type="button" name="add" id="addbutton" value="Submit" class="button" onclick="if(checkTotalAmount()){submitForm('paymentVoucherApproval','account?method=submitPaymentVoucherApproval','validateNarration','validateFieldsFrCashVoucher')};" accesskey="a" tabindex=1 />

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
		    	submitProtoAjaxWithDivName('paymentVoucherApproval','account?method=getSubLedgerForAccount&accName='+encodeURIComponent(strValue)+'&rowVal='+inc,tdid+inc);
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



function checkSubLed(val, inc){
		for(i=1;i<inc;i++){
			if(inc != 1){
				if(document.getElementById('resrate'+i)!=null){
					var subled =document.getElementById('resrate'+i).value;
					

					
					if(subled == val)
					{
						alert("SL already selected...!")
						document.getElementById('resrate'+inc).value="0"
						var e=eval(document.getElementById('resrate'+inc));
						e.focus();
						return false;
					}
				}
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

function checkvalue(inc){
		showAllBalanceInAjaxSub('paymentVoucher',inc);
		}
		
function checkPaymentType(){
			alert(document.getElementById("subGroupId").value);
			if(document.getElementById("subGroupId").value=='31378' ||document.getElementById("subGroupId").value=='31383'){
				document.getElementById("checkNoId22").style.display="inline";
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

function checkTotalAmount(){
			
			var tAmount = document.getElementById("totalAmountId").value;
			var balanceId = document.getElementById("balanceId").value;
			if(isNaN(tAmount)){
				alert("Total Amount should be Number");
				return false;
			}else if(balanceId==0 || balanceId<0){
				alert("Can not submit Due to Insufficient Balance");
				return false;
			}
			else{
				return true;
			}
		};
		 window.addEventListener('load', function() {
			document.getElementById("mainAccountId").onchange();
		}) 
		
	
</script>
</form> 








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
<%-- <%@page import="jkt.hms.masters.business.MasBranch"%> --%>
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
<form name="paymentVoucher" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
	List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
	List<Object[]> centreList = new ArrayList<Object[]>();
	List<FaMasNarration> narrationList = new ArrayList<FaMasNarration>();
	/* List<MasBranch> branchList = new ArrayList(); */
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
	 if(map.get("centreList") != null)
	 {
		 centreList =  (List<Object[]>)map.get("centreList");	  
		   
	  }
	 
	 int locationId=0;
	 if(map.get("locationId") != null)
	 {
		 locationId =  (Integer)map.get("locationId");	  
		  
	  }
	 
	if(map.get("narrationList") != null){
		narrationList = (List<FaMasNarration>)map.get("narrationList");
	}
/* 	if(map.get("branchList") != null){
		branchList = (List<MasBranch>)map.get("branchList");
	} */
	int voucherNo = 0;
	if(map.get("voucherNo") != null){
		voucherNo = (Integer)map.get("voucherNo");
	}
	 int mainAccountId = 0;
	 if(map.get("mainAccountId") != null){
		 mainAccountId = (Integer)map.get("mainAccountId");
		}
%>
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<div class="titleBg">
<h4>Payment/Contra Voucher</h4>
</div>


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="Block">
<div class="clear"></div>
<label>Voucher Date<span>*</span></label>
<input type="text" name="<%=VOUCHER_DATE %>" id="voucherDate" value="<%=date %>" class="calDate" tabindex=1  readonly="readonly" validate="Voucher Date ,date,no" MAXLENGTH="30" />

<label>Cash/Bank Account<span>*</span></label>
<select id="mainAccountId"  name="<%=ACCOUNT_ID %>"  onchange="showCrBalanceInAjax('paymentVoucher');" onblur="submitProtoAjaxWithDivName('paymentVoucher','account?method=checkForAccountType','checkNoDiv');" tabindex=1 >
	<option value="0">Select</option>
	<%
	if(accList.size()>0){
		for(FaMasAccount faMasAccount :accList){%>
			
		<option value="<%=faMasAccount.getId() %>" ><%=faMasAccount.getAccDesc() %></option>
		
	<%}
		}%>
</select>
<script type="text/javascript">
showBalanceInAjax('paymentVoucher');
</script>
<input id="groupId" type="hidden"  name="groupId" value=""   />
<div id="checkNoDiv"></div>
 <input id="subGroupId"  type="hidden"   name="subGroupId" value=""  />
 <div class="clear"></div>
<label>Balance:</label>
<input id="balanceId" type="text"   name="<%=BALANCE_AMOUNT%>" readonly="readonly" value=""   tabindex=1 />
 <%if(locationId==1){%>

		<%-- <label>Select Centre</label>
		<select name ="ddlLocation" id="ddlLocation" validate="Centre,string,no" >
		<option value="0">Select</option>
			<%
				if(centreList.size()>0)
				{
					for(Object[] list : centreList)
					{
						%>
							<option value="<%=list[0]%>"><%=list[1]%></option>
						<%
					}
				}
			%> 
		</select> --%>
<% }else{%>
<!-- <label>Amount Transfer TO HO</label>
<input id="transferHo" type="checkbox" name="transferHo" value="" validate="Amount Transfer TO HO,string,no" tabindex=1 class="radioCheck" onclick="validateCheck()" /> -->
<input type="hidden" value="" name="flagValueOP" id="flagValueOP" />
<%} %>

 <input id="voucherNoId" type="hidden"   name="<%=VOUCHER_NO%>" value="<%= voucherNo %>" readonly="readonly"  validate="Voucher No,string,no"  tabindex=1/>

</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<table width="100%" border="0" cellspacing="0" cellpadding="5"
	id="voucherDetails" class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Account</th>
		<th scope="col">Sub Ledger</th>
		<th scope="col">Amount</th>
		<!-- <th scope="col">&nbsp;</th> -->
	</tr>

	<%int i = 1;%>
	<tr>
	<td><input type="radio" value="" name="selectedChrage"  class="radiobutMargin" /></td>
	
	<td> <input id="accountNameId<%=i%>" type="text" size="30"  name="accountName<%=i%>" value=""  tabindex=1 onblur="validateAccountName(this.value,<%=i %>,'slId')"  />

				<div id="ac2update<%=i%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  	new Ajax.Autocompleter('accountNameId<%=i%>','ac2update<%=i%>','account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName<%=i%>'});
			</script></td>
	<td id="slId<%=i %>"> 
	<input  type="text"  id="resrate<%=i%>" name="<%=SUB_LEDGER_CODE%><%=i%>" value=""  readonly="readonly"  size="40"/></td>
	<td> <input id="amountId<%=i %>" type="text"  name="<%=AMOUNT%><%=i%>" value="" onblur="totalCrAmount('cash'); checkTotalAmountValueWithCashACC(<%=i%>)"   validate="Amount,float,yes" MAXLENGTH="8" tabindex=1 />
	<!-- <td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex=1 /></td> -->
	</tr>
	<tr class="background">
	<td colspan=3 class="right">Total</td>
	<td><input id="totalAmountId" type="text"   name="<%=TOTAL_AMOUNT %>" value=""  validate="Total Amount ,string,no" MAXLENGTH="100" tabindex=1 readonly /></td>
	</tr>
	</table>
	<!-- <input type="button" name="delete" class="buttonDel" onClick="removeRow();totalCrAmount('cash');" /> -->
	<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />

	
<div class="clear"></div>
<div class="Block">
<label>Narration<span>*</span></label>

<input id="voucherNarrationId" type="text" name="<%=NARRATION %>" value="" class="extraLarge" MAXLENGTH="190" tabindex=1 />
<div class="clear"></div></div>
<div class="clear"></div>
  <input type="button" name="add" id="addbutton" value="Submit" class="button" onclick="if(checkTotalAmount()){submitForm('paymentVoucher','account?method=submitPaymentVoucher','validateNarration','validateFieldsFrCashVoucher')};" accesskey="a" tabindex=1 />
  <input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="" accesskey="u" tabindex=1 />
  <input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="" accesskey="d" tabindex=1 />
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
var branchArray = new Array();
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
<%-- <%  int h=0;

for(MasBranch masBranch:branchList){
%>
<script>
	branchArray[<%=h%>]= new Array();
	branchArray[<%=h%>][0] = "<%=masBranch.getId()%>";
	branchArray[<%=h%>][1] = "<%=masBranch.getBranchDesc()%>";

		</script>
<%h++;} %> --%>
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
	//e0.id = 'radioId' + (iteration);
	e0.value=(iteration);
	cell0.appendChild(e0);

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.onblur=function(){
						validateAccountName(this.value,(iteration),'slId')
			  };
	//e1.onchange=function(){
		//showAllBalanceInAjax('paymentVoucher',iteration)
	//}; 
	e1.name = 'accountName'+ (iteration);
	e1.id = 'accountNameId' + (iteration);
	e1.tabIndex='1';
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
   	cell1.appendChild(e1);
	e1.focus();
    cell1.appendChild(newdiv);
	e1.size = '42';
  	new Ajax.Autocompleter('accountNameId'+ (iteration),'ac2update'+iteration,'account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName'+ (iteration)});


	var cell2 = row.insertCell(2);
	cell2.id='slId'+(iteration);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=SUB_LEDGER_CODE%>'+ (iteration);
	e2.id = 'subLedgerId'+(iteration)
	e2.readOnly = true;
	e2.size='12';
	cell2.appendChild(e2);

	var cell3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=AMOUNT%>'+ (iteration);
	e3.id='amountId'+(iteration);
	e3.onblur = function(){
					totalCrAmount('cash'),checkTotalAmountValueWithCashACC(iteration);
	}
	e3.tabIndex='1';
	cell3.appendChild(e3);

	var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'button';
	e4.name='add';
	e4.className = 'buttonAdd';
	e4.tabIndex="1";
	e4.onclick = function(){
					addRow();
	}
	cell4.appendChild(e4);
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


function removeRow()
{
	var tbl = document.getElementById('voucherDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");

  	if(tblRows.length-3==0){
         	alert("Can not delete all rows")
         	return false;
     }
	/*var count = 0;
	count = document.getElementById('hiddenValueCharge').value;
	var totalDrAmt =0;
	var k = 1;
	var accountCrAmt = 0;var accountDrAmt = 0;
	var balance = document.getElementById('balanceId').value;
		var balanceAmt = balance.substring(0,balance.indexOf(" "));
		var str = balance.substring(balance.indexOf(" "));
		if(trimAll(str) == "Dr"){
			accountDrAmt = parseFloat(balanceAmt);
		}else if(trimAll(str) == "Cr"){
			accountCrAmt = parseFloat(balanceAmt);
		}
		var drAmt = 0;
		var totalAmt =0;*/
		for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
		{
			if (document.getElementsByName('selectedChrage')[counter].checked == true)
			{
			  	tbl.deleteRow(counter+1);

			}
		}
			
			//totalAmt = parseFloat(totalAmt)+parseFloat(drAmt);
			//document.getElementById('totalAmountId').value = totalAmt;
		/*if(parseFloat(drAmt)!= 0){
		if(parseFloat(accountCrAmt)!= 0){
		  if(parseFloat(accountCrAmt) > parseFloat(drAmt) ){
			  accountCrAmt =parseFloat(accountCrAmt) - parseFloat(drAmt);
			  alert("accountDrAmt111==="+accountCrAmt);
				document.getElementById('balanceId').value = accountCrAmt+" Cr"; 
		  }else if(parseFloat(drAmt) > parseFloat(accountCrAmt) ){
			    accountCrAmt = parseFloat(drAmt)- parseFloat(accountCrAmt);
			    alert("accountCrAmt222==="+accountCrAmt);
			    document.getElementById('balanceId').value = accountCrAmt+" Dr"; 
		 	 }else if(parseFloat(crAmt) == parseFloat(accountDrAmt)){
		 		accountCrAmt =parseFloat(accountCrAmt)- parseFloat(drAmt) ;
		 		  alert("accountDrAmt333==="+accountDrAmt);
		 		document.getElementById('balanceId').value = accountCrAmt+" Cr"; 
		 	 }
		}else{
			 accountDrAmt = parseFloat(accountCrAmt)+parseFloat(drAmt);
			 alert("accountCrAmt333==="+accountCrAmt);
			 document.getElementById('balanceId').value = accountDrAmt+" Dr"; 
		  }
			}
		
		k++;*/
	
	/*for(i=1; i<=count; i++){
		var dramount = 0;
				if(document.getElementById('amountId'+i) && document.getElementById('amountId'+i).value != "" ){
					dramount = document.getElementById('amountId'+i).value;
					totalDrAmt = parseFloat(totalDrAmt)+parseFloat(dramount);
					
				}
		}
		
		document.getElementById('totalAmountId').value = totalDrAmt;*/
	
}


		function totalCrAmount(flag)
		{
			
			var count = 0;
			var accountCrAmt = 0;
			var accountDrAmt = 0;
			if(flag == 'cash'){
				 count = document.getElementById('hiddenValueCharge').value;
			}else{
				 count = document.getElementById('hiddenValueChargeForBank').value;
			}
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
				for(i=1; i<=count; i++){
				if(flag == 'cash'){
					 crAmt = document.getElementById('amountId'+i).value;
					}else {
					 crAmt = document.getElementById('amountBankId'+i).value;
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
		//var count = document.getElementById('hiddenValueChargeForBank').value;
		var cnt = document.getElementById('hiddenValueCharge').value;
		//var flagForGrid = document.getElementById('flagForSL').value;
		/*	if(flagForGrid == 'bank'){
			for(i=1; i<= count; i++){
				if(document.getElementById('accountNameBankId'+i)){
				if(document.getElementById('accountNameBankId'+i).value == ""){
  					msg += "Account can not be blank.\n";
  				  	}
				  }
				if(document.getElementById('bankNameId'+i)){
  				  if(document.getElementById('bankNameId'+i).value == ""){
  					msg += "Bank can not be blank.\n";
  				  }
				}
				if(document.getElementById('checkNoId'+i)){
  				 if(document.getElementById('checkNoId'+i).value == ""){
   					msg += "Check No can not be blank.\n";
   				  }
				}
				if(document.getElementById('checkDateId'+i)){
  				if(document.getElementById('checkDateId'+i).value == ""){
   					msg += "Check D can not be blank.\n";
   				  }
				}
				if(document.getElementById('amountBankId'+i)){
		  			if(document.getElementById('amountBankId'+i).value == ""){
	 					msg += "Amount can not be blank.\n";
		  			}
  				  }
			}

  				  }else{*/
  					for(i=1; i<= cnt; i++){
  						if(document.getElementById('accountNameId'+i)){
		  			if(document.getElementById('accountNameId'+i).value == ""){
  					msg += "Account can not be blank.\n";
		  			}
  						}
  						if(document.getElementById('amountId'+i)){
		  			if(document.getElementById('amountId'+i).value == ""){
	 					msg += "Amount can not be blank.\n";
		  			}
  				  }
		  			

				}
			//}
			if(msg != ""){
				alert(msg);
				return false;
			}
			return true;
		}

	function checkvalue(inc){
			//submitForm('paymentVoucher','account?method=showAccountBal&accountNameId'+accountNameId);
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
			if(isNaN(tAmount)){
				alert("Total Amount should be Number");
				return false;
			}
			else{
				return true;
			}
		};
		
		
		function validateCheck(){
			var chkHO = document.getElementById("transferHo");
			if(chkHO.checked){
				document.getElementById("flagValueOP").value='flagOP';
				document.getElementById("transferHo").value='y';
				alert("All  Payment will Transfer to HO Account");
				
				document.getElementById("accountNameId1").value="";
				document.getElementById("resrate1").value="";
				document.getElementById("amountId1").value="";
			}
			
		};
</script>
</form>
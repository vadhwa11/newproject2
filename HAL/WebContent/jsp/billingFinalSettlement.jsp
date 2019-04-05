<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.BlPatientLedger"%>
<%@page import="java.math.BigDecimal"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<div id="contentHolder"><script>
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
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
	</script>

<form name="patientFinalSettlement" method="post" action="">
<h6>Patient Final Settlement</h6>
<%

Map<String,Object> map = new HashMap<String,Object>();
Map<String,Object> patientMap = new HashMap<String,Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
List<Patient> patientDetailsList = new ArrayList<Patient>();

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
String date=(String)utilMap.get("currentDate");
String time=(String)utilMap.get("currentTime");

if(map.get("patientMap") != null){
	patientMap= (Map<String, Object>)map.get("patientMap");
}
if(patientMap.get("patientDetailsList") != null){
	patientDetailsList = (List<Patient>)patientMap.get("patientDetailsList");
}

%>

<div class="Clear"></div>

<!--Block One Starts-->
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<%
   String patientName = "";
   String hin = "";
   	if(patientDetailsList.size() > 0){
   		for(Patient patient : patientDetailsList){
   			patientName = patient.getPFirstName()+" "+patient.getPLastName();
   			hin = patient.getHinNo();
   %>
<div class="blockFrame"><label>Admission No:</label> <%
String adNo = "";
int inpatientId = 0;
if(patient.getInpatients() != null)
{
Set<Inpatient> inpatientSet = patient.getInpatients();	    
for(Inpatient inpatient :inpatientSet){
if(!inpatient.getAdStatus().equals("D")){
inpatientId = inpatient.getId();
adNo = inpatient.getAdNo();
}
}
}
%> <label class="value"> <%=adNo%></label> <label>Patient Name:</label>
<%
if(patient.getPFirstName() != null)
{
%> <label class="value"> <%= patientName%></label> <%
}%> <label>Age:</label> <label class="value"> <%=patient.getAge() %></label>

<div class="Clear"></div>

<label>Sex:</label> <label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>

<label>Service Person Name:</label> <%
			if(patient.getSFirstName() != null)
			{
		%> <label class="value"> <%= patient.getSFirstName() %> <%= patient.getSLastName()%></label>
<%
		}else{
		%> <label class="value"> -</label> <%} %> <label>Service Type:</label> <%
	    if(patient.getServiceType()!= null){
	    %> <label class="value"> <%=patient.getServiceType().getServiceTypeName() %></label>
<%
		   }else{
		%> <label class="value"> -</label> <%} %>
<div class="Clear"></div>
<label>Service Status:</label> <%if(patient.getServiceStatus() != null){%>
<label class="value"> <%=patient.getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="value"> -</label> <%} %> <label>Relation:</label>
<%if(patient.getNextOfKinRelation() != null){%> <label class="value">
<%=patient.getNextOfKinRelation().getRelationName() %></label> <%}else{ %> <label
	class="value"> -</label> <%} %> <input type="hidden" name="<%=HIN_ID %>"
	value="<%=patient.getId() %>"> <input type="hidden"
	name="<%=HIN_NO %>" value="<%=patient.getHinNo() %>"> <input
	type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>">
<input type="hidden" name="<%=AD_NO %>" value="<%=adNo%>"> <%} 
   		
		}%>
</div>
<input type=hidden value=0 name=pagecounter2> <%
			BigDecimal totalChargeSlipAmt = new BigDecimal(0);
			BigDecimal totalAdvAmt = new BigDecimal(0);
			BigDecimal diffAmt = new BigDecimal(0);
			
		 	List<BlPatientLedger> patientLedgerList = new ArrayList<BlPatientLedger>();
			if(map.get("patientLedgerList") != null){
				patientLedgerList = (List<BlPatientLedger>)map.get("patientLedgerList");
			}
			
			if(patientLedgerList.size() > 0){
				for(BlPatientLedger patientLedger : patientLedgerList){
					System.out.println("patientLedger.getTotalChargeSlipAmt()--- "+patientLedger.getTotalChargeSlipAmt());
					if(patientLedger.getTotalChargeSlipAmt() != null){
						totalChargeSlipAmt = patientLedger.getTotalChargeSlipAmt();
					}
					if(patientLedger.getTotalAdvAmt() != null){
						totalAdvAmt = patientLedger.getTotalAdvAmt();
					}
					try{
						diffAmt = totalChargeSlipAmt.subtract(totalAdvAmt);
					}catch(Exception e){
						diffAmt = totalChargeSlipAmt;
					}
					
				}
			}
			
			String displayStringBal = "";
			String displayString = "";
			String diffAmtString =  "";
			String seqNo = "";
			
			if(diffAmt != null){
				if(diffAmt.intValue() < 0){
					if(map.get("refundNo") != null){
						seqNo = (String)map.get("refundNo");
					}
					diffAmtString = diffAmt.toString().substring(1);
					displayStringBal = "Bl. Amt. Refundable";
					displayString = "Refund";
				}else if(diffAmt.intValue() >= 0){
					if(map.get("receiptNo") != null){
						seqNo = (String)map.get("receiptNo");
					}
					diffAmtString = diffAmt.toString();
					displayStringBal = "Bl. Amt. Payable";
					displayString = "Receipt";
				}
			}
		%> <input type="hidden" name="transType" value="<%=displayString %>">
<input type="hidden" name="diffAmt" value="<%=diffAmt %>"> <label
	class="common"><%=displayString %> No.:</label> <input type="text"
	name="<%=SETTLEMENT_NO %>" value="<%=seqNo %>" class="filled"
	readonly="readonly" /> <label class="common"><%=displayString %>
Date:</label> <input type="text" name="<%=SETTLEMENT_DATE%>" value="<%=date %>"
	class="filled" readonly="readonly" /> <label class="common"><%=displayString %>
Time:</label> <input type="text" name="<%=SETTLEMENT_TIME %>" value="<%=time %>"
	class="filled" readonly="readonly" />

<div class="Clear"></div>

<label class="common">Total Charge Slip Amt.</label> <input type="text"
	name="<%=CHARGE_SLIP_AMOUNT %>" value="<%=totalChargeSlipAmt %>"
	class="filled" readonly="readonly" /> <label class="common">Total
Advance:</label> <input type="text" name="<%=ADVANCE_AMOUNT %>"
	value="<%=totalAdvAmt %>" class="filled" readonly="readonly" /> <label
	class="common"><%=displayStringBal %>:</label> <input type="text"
	id="balanceAmt" name="<%=BALANCE_AMOUNT %>" value="<%=diffAmtString %>"
	class="filled" readonly="readonly" />
<div class="division"></div>
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" />
<div class="tableHholderCmnLarge">
<%
	String displayStrForChq = "";
	String displayStrForChqDate = "";
	if(displayString.equals("Receipt")){
		displayStrForChq = "Cheque/Credit Card No";
		displayStrForChqDate = "Cheque/Credit Card Date";
	}else{
		displayStrForChq = "Cheque No";
		displayStrForChqDate = "Cheque Date";
	}

%>
<table width="100%" colspan="7" id="chargeDetails" border="0"
	cellpadding="0" cellspacing="0">
	<tr>
		<th>SR No</th>
		<th>Payment Mode</th>
		<th>Amount</th>
		<th><%=displayStrForChq %></th>
		<th><%=displayStrForChqDate %></th>
		<th>Bank</th>
		<th>Received From</th>

	</tr>

	<%
    
     	int inc = 0;    	
    	for(inc=1;inc<=10;inc++){
    	%>

	<tr>

		<td><input type="text" size="2" value="<%=inc%>"
			name="<%=SR_NO%>" readonly="readonly" /></td>

		<td><select name="<%=PAYMENT_MODE %>" id="paymentModeId<%=inc %>"
			onchange="fillSrNo('<%=inc %>');checkPaymentMode(this.value,<%=inc %>);"
			tabindex="1">
			<option value="">Select</option>
			<option value="C">Cash</option>
			<option value="Q">Cheque</option>
		</select> <script type="text/javascript">

<!------------------- Script for adding option in payment mode for transaction type Receipt ------------->

	var payMode = '<%=displayString%>'
	if(payMode == "Receipt"){
		obj = document.getElementById('paymentModeId<%=inc %>');
		var length = obj.length;
		obj.length++;
		obj.options[obj.length-1].value = "R";
		obj.options[obj.length-1].text = "Credit Card";		
	}
	
<!--------------- End Of script   ---------------------->

</script></td>
		<td><input type="text" name="<%=AMOUNT %>" id="advAmt<%=inc %>"
			class="filled" value="" validate="Advance Amount,string,no"
			onblur="totalAdvAmt(this.value);" tabindex="1" maxlength="10"
			readonly="readonly" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_NO%>"
			class="filled" id="cqeId<%=inc %>" tabindex="1" maxlength="16"
			onblur="validateCheque(this.value,<%=inc %>);" readonly="readonly" />
		</td>
		<td><input type="text" value="" name="<%=CHEQUE_DATE %>"
			id="chqDate<%=inc %>" tabindex="1" class="filled" readonly="readonly" />
		<a
			href="javascript:setdate('',document.getElementById('chqDate<%=inc %>'))">
		<img style="display: none;" id="calId<%=inc %>"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" tabindex="1" /> </a></td>

		<td><input type="text" value="" name="<%=BANK_NAME %>"
			id="bank<%=inc %>" tabindex="1" class="filled" maxlength="50"
			readonly="readonly" /></td>
		<td><input type="text" value="" name="<%=RECEIVED_FROM %>"
			id="received<%=inc %>" tabindex="1" class="filled" maxlength="50"
			readonly="readonly" /></td>
	</tr>

	<%} %>

</table>
</div>
<div class="Clear"></div>
<div class="floatRight"><label>Total Amount</label> <input
	type="text" id="totalAmt" name="<%=TOTAL_AMOUNT %>" class="filled"
	readonly="readonly" /></div>

<div class="division"></div>

<label>Remarks:</label> <textarea name="<%=REMARKS %>" cols="70"
	rows="1" validate="Remarks,string,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	tabindex="1" maxlength="250">
</textarea>

<div class="division"></div>

<div class="bottom"><input type="button" class="button"
	value="Submit"
	onclick="if(checkBalanceAmt()){if(validateFieldsOnSubmit()){submitForm('patientFinalSettlement','billing?method=submitBillingFinalSettlementDetails')}};"
	align="right" /> <input type="button" class="button" value="Back"
	align="left"
	onClick="submitForm('patientFinalSettlement','billing?method=showSearchJspForDepositAndSettlement&flag=searchFinalSettlement');" />
<input type="reset" class="button" value="Reset"> <input
	type="hidden" name="rows" id="rr" value="1" /></div>

<script type="text/javascript">


function checkPaymentMode(val, count){
	if(val == "C"){
		document.getElementById("cqeId"+count).value = "";
		document.getElementById("chqDate"+count).value = "";
		document.getElementById("bank"+count).value = "";
		document.getElementById("advAmt"+count).readOnly = false;
		document.getElementById("cqeId"+count).readOnly = true;
		document.getElementById("bank"+count).readOnly = true;
		document.getElementById("received"+count).readOnly = false;
		document.getElementById("calId"+count).style.display = 'none';
		document.getElementById("cqeId"+count).className = "filled";
		document.getElementById("bank"+count).className = "filled";
		document.getElementById("advAmt"+count).className = "";
		document.getElementById("received"+count).className = "";
	}else if(val == "Q" || val == "R"){
		document.getElementById("advAmt"+count).readOnly = false;
		document.getElementById("cqeId"+count).readOnly = false;
		document.getElementById("bank"+count).readOnly = false;
		document.getElementById("received"+count).readOnly = false;
		document.getElementById("calId"+count).style.display = 'inline';
		document.getElementById("cqeId"+count).className = "";
		document.getElementById("bank"+count).className = "";
		document.getElementById("advAmt"+count).className = "";
		document.getElementById("received"+count).className = "";
	}else{
		document.getElementById("advAmt"+count).value = "";
		document.getElementById("cqeId"+count).value = "";
		document.getElementById("chqDate"+count).value = "";
		document.getElementById("bank"+count).value = "";
		document.getElementById("received"+count).value = "";
		document.getElementById("advAmt"+count).readOnly = true;
		document.getElementById("cqeId"+count).readOnly = true;
		document.getElementById("bank"+count).readOnly = true;
		document.getElementById("received"+count).readOnly = true;
		document.getElementById("calId"+count).style.display = 'none';
		document.getElementById("cqeId"+count).className = "filled";
		document.getElementById("bank"+count).className = "filled";
		document.getElementById("advAmt"+count).className = "filled";
		document.getElementById("received"+count).className = "filled";
	}
}

function totalAdvAmt(val){
	var amt = 0;
	for(var i=1; i<=10; i++){
		var advAmt = eval(document.getElementById("advAmt"+i));
		if(validateFloat(advAmt.value)){
			if(amt != 0 && advAmt.value != ""){
				amt = parseInt(amt)+parseInt(advAmt.value);
			}else if(amt == 0 && advAmt.value != ""){
				amt = parseInt(advAmt.value);
			}
		}else{
			alert("Please enter valid Amount value.\n");
			document.getElementById("advAmt"+i).value = "";
			document.getElementById("advAmt"+i).focus();
			return false;
		}
	}
	document.getElementById('totalAmt').value = amt;
}

function checkBalanceAmt(){
	if(checkForFilledRow()){
		var balanceAmt = document.getElementById('balanceAmt').value;
		var totalAmt = document.getElementById('totalAmt').value;
		if(parseInt(balanceAmt) == parseInt(totalAmt)){
			return true;
		}else{
			if(totalAmt != ""){
				alert("Balance Amt and total Amt are not equal.");
				}
			return false;
		}
	}
	
}

function fillSrNo(rowVal){
	if(document.getElementById('paymentModeId'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
		}
	}else if(document.getElementById('paymentModeId'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}	
	return true;
}

function validateFieldsOnSubmit(){
	var count = document.getElementById('noOfRecords').value;
	var msg = "";
	var prevCNo = "";
	var prevPayMode = "";
	for(var i=1;i<=count;i++){
		var cNo = document.getElementById('cqeId'+i).value;
		var payMode = document.getElementById('paymentModeId'+i).value;
		var amt = document.getElementById("advAmt"+i).value;
		
		if(parseInt(amt) <= 0){
				msg += "Please enter valid Amount value.\n";
				document.getElementById('advAmt'+i).value = "";
		}
		
		if(prevCNo !="" && cNo != ""){
			if(prevCNo == cNo){
				msg += "Cheque/Credit Card No can not be duplicate.\n";
				document.getElementById('cqeId'+i).value = "";
			}
		}
		if(prevPayMode != "" && payMode != ""){
			if(prevPayMode == payMode){
				msg += "Payment Mode Cash can not be repeated.\n";
				document.getElementById('paymentModeId'+i).value = "";
			}
		}
		
		if(msg != ""){
			break;
		}
		prevCNo = document.getElementById('cqeId'+i).value;
		
		if(document.getElementById('paymentModeId'+i).value == "C")
			prevPayMode = document.getElementById('paymentModeId'+i).value;
	}
	if(msg != ""){
		alert(msg)
	  	return false;
	}else{
		return true;
	}
}

</script></form>
</div>

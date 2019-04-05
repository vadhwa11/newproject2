<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.BlDepositHeader"%>
<%@page import="jkt.hms.masters.business.BlPatientLedger"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<div id="contentspace"><script>
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

<form name="deposit" method="post" action=""><br />
<h2 align="left" class="style1">Patient Advance</h2>
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

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
	<TBODY>
		<TR>
			<TD height="6" bgColor=#ffffff></TD>
		</TR>
		<TR>
			<TD align=right>
			<TABLE width=* border=0 align="left" cellPadding=0 cellSpacing=0>
				<TBODY>
					<TR>
						<TD rowSpan=2><IMG height=8 src="images/spacer.gif" width=8></TD>
						<TD bgColor=#95bfea rowSpan=2><IMG height=1
							src="images/spacer.gif" width=1></TD>
						<TD bgColor=#95bfea><IMG height=1 src="images/spacer.gif"
							width=1></TD>
						<TD rowSpan=2><IMG height=21
							src="/hms/jsp/images/tab_edge_ltbl.gif" width=25></TD>
					</TR>
					<TR>
						<TD
							style="PADDING-RIGHT: 4px; PADDING-LEFT: 8px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px color :   #1D0E63;"
							vAlign=center noWrap align=middle bgColor=#D3E8FD><strong>Patient
						Details</strong> <%
   String patientName = "";
   String hin = "";
   	if(patientDetailsList.size() > 0){
   		for(Patient patient : patientDetailsList){
   			patientName = patient.getPFirstName()+" "+patient.getPLastName();
   			hin = patient.getHinNo();
   %>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
		<TR>
			<TD>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" bgColor=#d3e8fd
				border=0>
				<TBODY>
					<TR>
						<TD rowSpan=2><IMG height=7 src="/hms/jsp/images/pt_001.gif"
							width=7></TD>
						<TD width="100%" bgColor=#3c8ad7><IMG height=1
							src="/hms/jsp/images/spacer.gif" width="100%"></TD>
						<TD align=right rowSpan=2><IMG height=7
							src="/hms/jsp/images/pt_007.gif" width=7></TD>
					</TR>
					<TR>
						<TD><IMG height=6 src="/hms/jsp/images/grad_blue_opp.gif"
							width="100%"></TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>

<table cellspacing=0 cellpadding=0 width="100%" bgcolor=#d3e8fd border=0>
	<tbody>
		<tr>
			<td width=7 background="/hms/jsp/images/pt_002.gif"><img
				height=1 src="/hms/jsp/images/spacer.gif" width=1></td>
			<td>
			<table cellspacing=0 cellpadding=2 width="100%" border=0>
				<tbody>
					<tr>
						<td
							style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px"
							bgcolor=#ffffff height=1><img height=1
							src="Images/spacer.gif" width=1></td>
					</tr>
					<tr bgcolor=#d3e8fd>
						<td height="10" align=left valign=center
							style="BORDER-LEFT: #ffffff 1px solid"></td>
					</tr>
					<tr>
						<td
							style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px"
							bgcolor=#3c8ad7 height=1><img height=1
							src="/hms/jsp/images/spacer.gif" width=1></td>
					</tr>
					<tr valign=top bgcolor=#ffffff>
						<td valign=center align=middle colspan=2 bgcolor="#f4f9fe">

						<div><label class="bodytextB">Admission No:</label> <%
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
	    %> <span class="wardspan"> <%=adNo%></span> <label
							class="bodytextB">Patient Name:</label> <%
			if(patient.getPFirstName() != null)
			{
		%> <span class="wardspan"> <%= patient.getPFirstName() %> <%= patient.getPLastName()%></span>
						<%
		}%> <label class="bodytextB">Age:</label> <span class="wardspan">
						<%=patient.getAge() %></span> <label class="bodytextB">Sex:</label> <span
							class="wardspan"> <%=patient.getSex().getAdministrativeSexName() %></span>

						<br />
						<label class="bodytextB">Service Person Name:</label> <%
			if(patient.getSFirstName() != null)
			{
		%> <span class="wardspan"> <%= patient.getSFirstName() %> <%= patient.getSLastName()%></span>
						<%
		}else{
		%> <span class="wardspan"> -</span> <%} %> <label class="bodytextB">Service
						Type:</label> <%
	    if(patient.getServiceType()!= null){
	    %> <span class="wardspan"> <%=patient.getServiceType().getServiceTypeName() %></span>
						<%
		   }else{
		%> <span class="wardspan"> -</span> <%} %> <label class="bodytextB">Service
						Status:</label> <%if(patient.getServiceStatus() != null){%> <span
							class="wardspan"> <%=patient.getServiceStatus().getServiceStatusName() %></span>
						<%}else{ %> <span class="wardspan"> -</span> <%} %> <label
							class="bodytextB">Relation:</label> <%if(patient.getNextOfKinRelation() != null){%>
						<span class="wardspan"> <%=patient.getNextOfKinRelation().getRelationName() %></span>
						<%}else{ %> <span class="wardspan"> -</span> <%} %> <br />
						<input type="hidden" name="<%=HIN_ID %>"
							value="<%=patient.getId() %>"> <input type="hidden"
							name="<%=HIN_NO %>" value="<%=patient.getHinNo() %>"> <input
							type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>">
						<input type="hidden" name="<%=AD_NO %>" value="<%=adNo%>">
						<%} 
   		
		}%>
						</div>
						</td>
					</tr>
					<input type=hidden value=0 name=pagecounter2>
			</table>
			</td>

			<td width=7 background="/hms/jsp/images/pt_005.gif"><img
				height=1 src="/hms/jsp/images/spacer.gif" width=1></td>
		</tr>
		<tr>
			<td rowspan=2><img height=7 src="/hms/jsp/images/pt_003.gif"
				width=7></td>
			<td
				style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px"
				bgcolor=#ffffff><img height=6 src="/hms/jsp/images/pt_006.gif"
				width="100%"></td>
			<td rowspan=2><img height=7 src="/hms/jsp/images/pt_004.gif"
				width=7></td>
		</tr>
		<tr>
			<td
				style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px"
				bgcolor=#3c8ad7><img height=1 src="/hms/jsp/images/spacer.gif"
				width="100%"></td>
		</tr>
	</TBODY>
</table>
<br />
<%
			String receiptNo = "";
			if(map.get("receiptNo") != null){
				receiptNo = (String)map.get("receiptNo");
			}
			
		%> <label class="bodytextB">Receipt No.:</label> <input type="text"
	name="<%=RECEIPT_NO %>" value="<%=receiptNo %>"
	style="border: 1px solid #7f9db7;" class="textbox_size20"
	readonly="readonly" /> <label class="bodytextB">Receipt Date:</label> <input
	type="text" name="<%=RECEIPT_DATE %>" value="<%=date %>"
	style="border: 1px solid #7f9db7;" class="textbox_size20"
	readonly="readonly" /> <label class="bodytextB">Receipt Time:</label> <input
	type="text" name="<%=RECEIPT_TIME %>" value="<%=time %>"
	style="border: 1px solid #7f9db7;" class="textbox_size20"
	readonly="readonly" /> <br />
<br />


<div style="overflow: auto; height: 320px; padding-left: 9px;">

<table width="100%" colspan="7" id="chargeDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="3%">
			<div align="left"><font valign="left" class="gridsmlabel">SR
			No</font></div>
			</td>
			<td width="10%">
			<div align="left"><font valign="left" class="smalllabel">Payment
			Mode</font></div>
			</td>
			<td width="7%">
			<div align="left"><font valign="left" class="smalllabel">Advance
			Amt</font></div>
			</td>
			<td width="7%">
			<div align="left"><font valign="left" class="smalllabel">Cheque/Credit
			Card No</font></div>
			</td>
			<td width="7%">
			<div align="left"><font valign="left" class="smalllabel">Cheque/Credit
			Date</font></div>
			</td>
			<td width="7%">
			<div align="left"><font valign="left" class="smalllabel">Bank</font>
			</div>
			</td>
			<td width="7%">
			<div align="left"><font valign="left" class="smalllabel">Received
			From</font></div>
			</td>

		</tr>
	</thead>
	<tbody>
		<%
    
     	int inc = 0;    	
    	for(inc=1;inc<=10;inc++){
    	%>

		<tr>

			<td width="5%"><input type="text" size="2" value="<%=inc%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><select name="<%=PAYMENT_MODE %>"
				id="paymentModeId<%=inc %>" class="NewSelectBox"
				onchange="checkPaymentMode(this.value,<%=inc %>);" tabindex="1">
				<option value="">Select</option>
				<option value="C">Cash</option>
				<option value="Q">Cheque</option>
				<option value="R">Credit Card</option>
			</select></td>
			<td><input type="text" name="<%=ADVANCE_AMOUNT %>"
				id="advAmt<%=inc %>" value="" class="medcaption"
				validate="Advance Amount,string,no"
				onblur="totalAdvAmt(this.value);" tabindex="1" /></td>
			<td><input type="text" value="" class="medcaption"
				name="<%=CHEQUE_NO%>" id="cqeId<%=inc %>" tabindex="1" /></td>
			<td><input type="text" value="" class="medcaption"
				name="<%=CHEQUE_DATE %>" id="chqDate<%=inc %>" tabindex="1" /> <a
				href="javascript:setdate('',document.deposit.<%=CHEQUE_DATE%>)">
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender" style="padding-top: 5px;"
				tabindex="1" /> </a></td>
			<td><input type="text" value="" class="medcaption"
				name="<%=BANK_NAME %>" id="bank<%=inc %>" tabindex="1" /></td>
			<td><input type="text" value="" class="medcaption"
				name="<%=RECEIVED_FROM %>" id="received<%=inc %>" tabindex="1" /></td>
		</tr>

		<%} %>
		<tr>
			<td width="5%"></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
			<div align="left"><font valign="left" class="smalllabel">Total
			Amount</font></div>
			</td>
			<td><input type="text" id="totalAmt" class="medcaption"
				name="<%=TOTAL_AMOUNT %>" readonly="readonly" /></td>
		</tr>
	</tbody>
</table>
</div>

<br />
<%
	List<BlPatientLedger> previousDepositList = new ArrayList<BlPatientLedger>();
	String totalAdvCollected = "";
	if(map.get("previousDepositList") != null){
		previousDepositList = (List<BlPatientLedger>)map.get("previousDepositList");
		for(BlPatientLedger blPatientLedger : previousDepositList){
			totalAdvCollected = String.valueOf(blPatientLedger.getTotalAdvAmt());
		}
	}
%> <label class="bodytextB">Total Adv. Collect:</label> <input
	type="text" name="<%=TOTAL_COLLECTED_ADVANCE %>"
	value="<%=totalAdvCollected %>" style="border: 1px solid #7f9db7;"
	class="textbox_size20" readonly="readonly" /> <label
	class="bodytextReg">Remarks:</label> <textarea name="<%=REMARKS %>"
	cols="70" rows="1" validate="Remarks,string,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	tabindex="1" maxlength="250">Advance received from <%= patientName%>, Hin No. <%=hin %>
        </textarea> <br />
<br />

<div style="padding-left: 80px; float: left;"><input type="button"
	class="button" value="Submit"
	onclick="submitForm('deposit','billing?method=submitDepositDetails')"
	align="right" /> <input type="button" class="button" value="Back"
	align="left"
	onClick="submitForm('deposit','billing?method=showSearchPatientForDeposits');" />
<input type="reset" class="button" value="Reset"> <input
	type="hidden" name="rows" id="rr" value="1" /></div>

<script type="text/javascript">

function checkPaymentMode(val, count){
	if(val == "C"){
		document.getElementById("cqeId"+count).value = "";
		document.getElementById("chqDate"+count).value = "";
		document.getElementById("bank"+count).value = "";
		document.getElementById("cqeId"+count).readOnly = true;
		document.getElementById("chqDate"+count).readOnly = true;
		document.getElementById("bank"+count).readOnly = true;
	}else{
		document.getElementById("cqeId"+count).readOnly = false;
		document.getElementById("chqDate"+count).readOnly = false;
		document.getElementById("bank"+count).readOnly = false;
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

</script></form>
</div>

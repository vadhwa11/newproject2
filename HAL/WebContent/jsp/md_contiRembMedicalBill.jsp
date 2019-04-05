<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MdSpecialInvestigationHd"%>
<%@page import="jkt.hms.masters.business.MdMasAuthority"%>
<%@page import="jkt.hms.masters.business.MdSpecialInvestigationDt"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%><script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>


<form name="contingentBill" method="post" action="">
<script	type="text/javascript">
		history.forward();
</script> <script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
	var selectedTestType="MEDCLAIMS";
                 function checkedfunctions(){
                           if(document.getElementById('testType1').checked){
                            selectedTestType = document.getElementById('testType1').value;
                           }else{
                             selectedTestType = document.getElementById('testType2').value;
                           }
                              alert("selectedTestType::"+selectedTestType);
                             
                          }
</script> <%
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MdSpecialInvestigationHd> specialInvHdList = new ArrayList<MdSpecialInvestigationHd>();
	MdSpecialInvestigationHd specialInvestigationHd= new MdSpecialInvestigationHd();
//	List <MdMasAuthority> authorityList=new ArrayList<MdMasAuthority>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTimeWithoutSc");
	String userName="";
	int hospitalId=0;
	int specialhdId=0;
	int hinId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
			}
		if(map.get("specialInvHdList") != null){
			specialInvHdList=(List)map.get("specialInvHdList");
		}
	/*	if(map.get("authorityList") != null){
			authorityList=(List)map.get("authorityList");
		}*/
 	    List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
 	    if(map.get("employeeList") != null){
 	    	employeeList=(List)map.get("employeeList");
		}
 	   
		if(specialInvHdList != null && specialInvHdList.size()>0){
			specialInvestigationHd = (MdSpecialInvestigationHd) specialInvHdList.get(0);
				hinId =specialInvestigationHd.getHin().getId();
		}
		 List<MdSpecialInvestigationDt> masInvestigationDtList = new ArrayList<MdSpecialInvestigationDt>();
		 if(map.get("masInvestigationDtList") != null){
			 masInvestigationDtList= (List)map.get("masInvestigationDtList");
			}
		
		if(map.get("pageNo") != null){
			pageNo=(Integer)map.get("pageNo");
		}
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		if(map.get("hospitalList") != null){
			hospitalList= (List)map.get("hospitalList");
		}
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
		if(map.get("chargeList") != null){
			chargeList=(List)map.get("chargeList");
		}
		if(map.get("specialhdId") != null){
			specialhdId=(Integer)map.get("specialhdId");
		}
%>

<div class="titleBg">
<h2>Contingent Bill for Reimbursement of Medical Bill Entry</h2>
</div>

<div class="Clear"></div>
<div class="Block">


<input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <%
 	String entrySeqNo = "";
 	if (map.get("entrySeqNo") != null) {
 		entrySeqNo = (String) map.get("entrySeqNo");
 	}
 %> 
 
 
 
 <label>Entry No.</label> <input id="orderNoId" type=hidden
	name="<%=ENTRY_NO %>" value="<%=entrySeqNo %>" title="Entry No" /> <label
	class="value"><%=entrySeqNo%></label> <input type="hidden"
	id="specialhdId" name="specialhdId"
	value="<%= specialInvestigationHd.getId()%>" />
	
 <label>Entry Date<span>*</span></label> <input type="text" class="calDate" id="fromDateId"
	name="<%=ENTRY_DATE %>" value="<%=currentDate %>" readonly="readonly"
	MAXLENGTH="30" validate="Entry Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.contingentBill.<%=ENTRY_DATE%>,event)" />
<input type="hidden" name="diagnosis" id="diagnosis"
	value="<%=specialInvestigationHd.getWorkingDiagnosis() %>" />
<div class="Clear"></div>
<%

String name="";
name=specialInvestigationHd.getHin().getPFirstName();
if(specialInvestigationHd.getHin().getPMiddleName() !=null){
	name=name+" "+specialInvestigationHd.getHin().getPMiddleName();}
	if(specialInvestigationHd.getHin().getPLastName() !=null){
	name=name+" "+specialInvestigationHd.getHin().getPLastName();}%>

<label>Patient Name</label> <label class="value"><%=name%></label> <label>Service
No.</label> <label class="value"><%=specialInvestigationHd.getHin().getServiceNo()%></label>
<input type="hidden" name="<%=HIN_NO %>"
	value="<%=specialInvestigationHd.getHin().getHinNo() %>" /> <label>Rank
</label> <%
 	if (specialInvestigationHd.getHin().getRank() != null) {
 %> <label class="value"><%=specialInvestigationHd.getHin().getRank()
								.getRankName()%></label> <%
	} else {
%> <label class="value"> - </label> <%
 	}
 %>

<div class="Clear"></div>

<label>Branch/Trade </label> <%
 	if (specialInvestigationHd.getHin().getTrade() != null) {
 %> <label class="value"><%=specialInvestigationHd.getHin().getTrade()
								.getTradeName()%></label> <%
	} else {
%> <label class="value"> - </label> <%
 	}
 %> <label>Unit </label> <%
 	if (specialInvestigationHd.getHin().getUnit() != null) {
 %> <label class="value"><%=specialInvestigationHd.getHin().getUnit()
								.getUnitName()%></label> <%
	} else {
%> <label class="value"> - </label> <%
 	}
 %> <%
 	int inpatientId = 0;
 	String flag = "";
 	Set<Inpatient> set = new HashSet<Inpatient>();
 	set = specialInvestigationHd.getHin().getInpatients();
 	for (Inpatient inpatient : set) {
 		if (inpatient.getAdStatus().equals("A")) {
 			inpatientId = inpatient.getId();
 		}
 %> <input type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=inpatient.getId()%>" /> <input type="hidden"
	name="<%=DEPARTMENT_ID %>"
	value="<%=inpatient.getDepartment().getId() %>" /> <%} %> <input
	type="hidden" name="<%=HIN_ID %>"
	value="<%=specialInvestigationHd.getHin().getId() %>" /> <input
	type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />

<label>Claim Type</label> <select name="<%=CLAIM_TYPE%>">
	<option value="general">General Claim</option>
	<option value="emergency">Emergency Claim</option>
	<option value="hearingAid">Hearing aid claim</option>
</select></div>



<div class="Clear paddingTop15"></div>


<h4>Investigation Required</h4> 

<%---
	
<label>Select Test Type </label>
<label class="auto">ALL Test</label> 
<input	type="radio" name="testType" id="testType1" value="ALL" onclick="checkedfunctions();" class="radioAuto" />
	
<label class="auto">GeneralClaims Specific Test </label>
<input type="radio" name="testType" id="testType2"	value="MEDCLAIMS" checked="checked" class="radioAuto" onclick="checkedfunctions();" />
	 --%>

<div class="clear"></div>

<div class="cmntable">

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails">
	<thead>
		<tr>
			<th scope="col"></th>
			<th scope="col">Test Name</th>
			<th>Add</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>

		<%
			int inc = 0;
			List<MdSpecialInvestigationDt> specialInvestigationDtList = new ArrayList<MdSpecialInvestigationDt>();
			if (detailsMap.get("masInvestigationDtList") != null) {
				specialInvestigationDtList = (List<MdSpecialInvestigationDt>) detailsMap.get("masInvestigationDtList");
			}
			if (specialInvestigationDtList != null
					&& specialInvestigationDtList.size() > 0) {
				for (MdSpecialInvestigationDt specialInvestigationDt : specialInvestigationDtList) {
					inc++;
		%>

		<tr>
			<td><input type="checkbox" value="<%=inc%>"
				name="selectedChrage" class="radioCheck" /></td>
			<td>
			<%
				if (specialInvestigationDt.getCharge() != null) {
			%> <input type="text" tabindex="1" align="right"
				name="<%=CHARGE_NAME%>" size="80" id="chargeName<%=inc%>"
				onblur="if(fillSrNo){fillChargeId(this.value,<%=inc %>);}"
				value="<%=specialInvestigationDt.getCharge().getChargeCodeName()+"["+specialInvestigationDt.getCharge().getId()+"]" %>" />
			<input type="hidden"
				value="<%=specialInvestigationDt.getCharge().getId()%>"
				name="chargeCodeId<%=inc %>" id="chargeCodeId<%=inc %>" />

			<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				//function eventCallback(element, entry){
					//return entry + "&testType="+selectedTestType; 
				//}
			    new Ajax.Autocompleter('chargeName<%=inc%>','ac2update','mediClaim?method=getChargeName',{parameters:'requiredField=chargeName<%=inc%>'});
			 
    </script> <%
 	} else {
 %> <input type="text" tabindex="1" name="<%=CHARGE_NAME%><%=inc %>" size="80"
				id="chargeName<%=inc%>"
				onblur="if(fillSrNo){fillChargeId(this.value,<%=inc %>);}" />
			<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				//function eventCallback(element, entry){
					//return entry + "&testType="+selectedTestType; 
			//	}
			    new Ajax.Autocompleter('chargeName<%=inc%>','ac2update','mediClaim?method=getChargeName',{parameters:'requiredField=chargeName<%=inc%>'});
			 
    </script> <input type="hidden" value="" name="chargeCodeId<%=inc %>"
				id="chargeCodeId<%=inc %>" /> <%
 	}
 %>
			</td>
			
			<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
			<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" /> </td>
			
		</tr>
		<%
			}
			}
		%>
	</tbody>

</table>
<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"	id="hiddenValueCharge" />
	</div>

<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label> Bill No.<span>*</span></label> <input
	id="billNo" type="text" name="<%= BILL_NO%>" value=""
	validate="Bill No,string,yes" MAXLENGTH="15" tabindex=1 /> <label>
Bill Date <span>*</span></label> <input type="text" class="calDate" id="fromDateId"
	name="<%=BILL_DATE %>" value="<%=currentDate %>" readonly="readonly"
	MAXLENGTH="30" validate="Bill Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.contingentBill.<%=BILL_DATE%>,event)" />

<label>Amount(Rs.)<span>*</span></label> <input id="amount" type="text"
	name="<%= AMOUNT%>" value="" validate="Amount,float,yes" MAXLENGTH="8"
	tabindex=1 onblur="fillAmount();" /> <script type="text/javascript">
function fillAmount(){
var amount=document.getElementById('amount').value;
document.getElementById('receivedRs').value=amount;
document.getElementById('qualifyingAmt').value=amount;

}

</script>
<div class="Clear"></div>
<label>CGHS Code</label>
<input type="text" name="cghsCode" value="" maxlength="12" />
<label>CGHS Rate</label>
<input type="text" name="cghsRate" value="" maxlength="10" />
<div class="Clear"></div>

<label class="auto"> Amt. Qualifying of reimbursement of (Rs.)<span>*</span> </label> 
<input id="qualifyingAmt" type="text" class="auto"
	name="<%= QUALIFYING_RS%>" value=""
	validate="Amount Qualifying of reimbursement of Rs.,float,yes"
	MAXLENGTH="8" tabindex=1
	onblur="checkQualifyingAmt();AmountToReceived();" /> 
	
	
<label class="auto"> Amount Payable to<span>*</span></label> <%
	String fullName="";
	fullName= specialInvestigationHd.getHin().getServiceNo()+" ";
	if (specialInvestigationHd.getHin().getRank() != null) {
		fullName +=specialInvestigationHd.getHin().getRank().getRankName()+"  ";
		}
	fullName =fullName+" "+specialInvestigationHd.getHin().getSFirstName();
	if(specialInvestigationHd.getHin().getSMiddleName() !=null){
	fullName=fullName+" "+specialInvestigationHd.getHin().getSMiddleName();
	}
	if(specialInvestigationHd.getHin().getSLastName() !=null){
		fullName=fullName+" "+specialInvestigationHd.getHin().getSLastName();
		}
	
	if(specialInvestigationHd.getHin().getTrade()!=null){
		fullName +=" "+specialInvestigationHd.getHin().getTrade().getTradeName()+" ";
	}
	if(specialInvestigationHd.getHin().getUnit()!=null){
		fullName +=specialInvestigationHd.getHin().getUnit().getUnitName();
	}
	
	%> <input id="payAmount" type="text" class="large"
	name="<%= PAYABLE_TO%>" value="<%=fullName.substring(0,5)%>"
	validate="Amount Payable,string,yes" MAXLENGTH="10" tabindex=1 />
 

</div>
<div class="Clear"></div>
<div class="Block">
<label class="auto"> Name of pay account office in which individual IRLAs are maintained <span>*</span></label> <input id="payName" type="text"
	class="large" name="<%= NAME_PAY_OFFICER%>" value=""
	validate="Name of pay account office,string,yes" MAXLENGTH="50"
	tabindex=1 />

<div class="Clear"></div>
<label> Date of Submission <span>*</span></label> <input type="text"
	class="date" id="fromDateId" name="<%=SUB_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30"
	validate="Date Of Submission,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" 
	onClick="setdate('<%=currentDate %>',document.contingentBill.<%=SUB_DATE%>,event)" />

<label>Received (Rs.)</label> <input id="receivedRs" type="text"
	name="<%= RECEIVED_RS%>" value="" validate="Received Rs,float,no"
	MAXLENGTH="8" tabindex=1 />



<label> Forward to<span>*</span></label> <select name="<%= AUTHORITY_ID %>"
	validate="FWT to,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
		if (employeeList != null) {
			for (MasEmployee masEmployee : employeeList) {
	%>
	<option value="<%=masEmployee.getId ()%>"><%=masEmployee.getRank().getRankName()+" "+ masEmployee.getFirstName()+" "+(masEmployee.getLastName()!=null?masEmployee.getLastName():"")%></option>

	<%
		}
		}
	%>
<%--	<%
		if (authorityList != null) {
			for (MdMasAuthority masAuthority : authorityList) {
	%>
	<option value="<%=masAuthority.getId ()%>"><%=masAuthority.getAuthorityName()%></option>

	<%
		}
		}
	%> --%>
</select>

 <div class="Clear"></div>
 
 
<label> FWT Date<span>*</span></label> <input type="text"
	class="calDate" id="fromDateId" name="<%=FWT_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30"
	validate="FWT Date:,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.contingentBill.<%=FWT_DATE%>,event)" />

 <div class="Clear"></div>
</div>

<!--Bottom labels starts-->

<div class="Clear"></div>

<div class="division"></div>

<div class="Clear"></div>

<input type="button" class="button" value="Submit"
	onclick="if(checkFilledRow())submitForm('contingentBill','mediClaim?method=submitContingentBill');"
	align="right" /> 
	
<input type="reset" class="button" name="Reset"
	id="reset" value="Reset"
	onclick="resetClicked('contingentBill',<%=inc %>);" accesskey="r" />


<div class="Clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>
<input type="hidden" name="counter" value=<%=inc %>></div>

</form>

<script type="text/javascript">
function AmountToReceived(){
var var1= document.getElementById('receivedRs');
var1.value=document.getElementById('qualifyingAmt').value ;

}
	function addRow(){
	var tbl = document.getElementById('chargeDetails');
	var lastRow = tbl.rows.length;
	
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;
	
	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name='selectedChrage';
	e0.value=(iteration);
	cell0.appendChild(e0);
	
	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.size = '80';
	e1.onblur=function(){
				if(fillSrNo){fillChargeId(this.value,iteration);}
			  };
	e1.name = 'chargeName'+ (iteration);
	e1.id = 'chargeName' + (iteration);
	e1.tabIndex="1";
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update');
   	newdiv.style.display = 'none';
   	newdiv.style.background = '#FFF';
   	newdiv.style.border = '1px solid #000';
   	cell1.appendChild(e1);
    cell1.appendChild(newdiv);

	new Ajax.Autocompleter('chargeName'+ (iteration),'ac2update','mediClaim?method=getChargeName',{parameters:'requiredField=chargeName'+ (iteration),callback:eventCallback});
	
	cell1.id='itm'+iteration;
	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='chargeCodeId'+iteration;
	  e2.id='chargeCodeId'+iteration
	  e2.size = '10'
	  e2.maxlength="5"
	  cell1.appendChild(e2);
}
function removeRow()
{
	var tbl = document.getElementById('chargeDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");
	
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
	for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
	{
     var err = "";
		if (document.getElementsByName('selectedChrage')[counter].checked == true) 
		{
		  	tbl.deleteRow(counter+1);
		  	totalCost();
		}else{
			err += "Please select atleast one row for delete";
		
		}
	}
	
	if(err != ""){
		alert(err);
		return false;
	}
}

function fillChargeId(val,inc){
		if(val != "")
		{
			var index1 = val.lastIndexOf("[");
			var indexForInvestigationName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var chargeId = val.substring(index1,index2);
			if(chargeId=='')
			{
			alert("Test Name is Incorrect");
			document.getElementById('chargeName'+inc).value=""
			var e=eval(document.getElementById('chargeName'+inc)); 
			e.focus();
			return false;
			}
			var indexForChargeName = indexForChargeName--;
			var ChargeName = val.substring(0,indexForChargeName);
		document.getElementById('chargeCodeId'+inc).value = chargeId;
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('chargeName'+i).value==val)
		{
			alert("Charge Name already selected...!")
			document.getElementById('chargeName'+inc).value=""
			var e=eval(document.getElementById('chargeName'+inc)); 
			e.focus();
			return false;
		} }  }
			
}
}


function fillSrNo(rowVal){

	if(document.getElementById('chargeName'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('chargeName'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}
function checkFilledRow(){
	var msg ="";
	  	var count = document.getElementById('hiddenValueCharge').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('chargeName'+i) != null){
	  	 		if(document.getElementById('chargeName'+i).value == ""){
	  				alert("Please fill atleast one Investigation to submit.");
	  				return false;
	  		}
	  		}
	  	if(msg != ""){
	  		alert(msg)
	  		return false;
	  	}else{
	  		return true;
	  	}
	}
	}
	
	
	function checkQualifyingAmt(){
	var quaAmt = document.getElementById('qualifyingAmt').value;
	var amt = document.getElementById('amount').value;
	if(parseFloat(quaAmt) > parseFloat(amt)){
	alert("Amount Qualifying of reimbursement should be less than Amount");
	document.getElementById('qualifyingAmt').value= "";
	return false;
	}else{
	  		return true;
	  	}
	}
</script>


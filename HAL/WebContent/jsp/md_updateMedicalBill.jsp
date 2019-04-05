<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MdMasAuthority"%>
<%@page import="jkt.hms.masters.business.MdContigentMedicalBillHd"%>
<%@page import="jkt.hms.masters.business.MdContigentMedicalBillDt"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<form name="contingentBill" method="post" action=""><script
	type="text/javascript">
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
	List<MdContigentMedicalBillHd> medicalBillList = new ArrayList<MdContigentMedicalBillHd>();
	MdContigentMedicalBillHd contigentMedicalBillHd= new MdContigentMedicalBillHd();
	List <MdMasAuthority> authorityList=new ArrayList<MdMasAuthority>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
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
		if(map.get("medicalBillList") != null){
			medicalBillList=(List)map.get("medicalBillList");
		}
		if(map.get("authorityList") != null){
			authorityList=(List)map.get("authorityList");
		}
		if(medicalBillList != null) {
			contigentMedicalBillHd = (MdContigentMedicalBillHd) medicalBillList.get(0);
				hinId =contigentMedicalBillHd.getHin().getId();
		}
		if(map.get("pageNo") != null){
			pageNo=(Integer)map.get("pageNo");
		}
		
		if(map.get("specialhdId") != null){
			specialhdId=(Integer)map.get("specialhdId");
		}
%>
<div id="contentHolder">
<h6>Update Contingent Bill for Reimbursement of Medical Bill Entry</h6>
<div class="Clear"></div>
<div class="blockFrame" id="testDiv"><input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <%
		String entrySeqNo="";
		if(map.get("entrySeqNo") != null){
			entrySeqNo = (String)map.get("entrySeqNo");
		}
%> <label>Entry No</label> <input id="orderNoId" type=hidden
	name="<%=ENTRY_NO %>" value="<%=contigentMedicalBillHd.getEntryNo() %>"
	title="Entry No" /> <label class="value"><%=contigentMedicalBillHd.getEntryNo() %></label>
<input type="hidden" id="specialhdId" name="specialhdId"
	value="<%= specialhdId%>" /> <label> Entry Date</label> <%if(contigentMedicalBillHd.getEntryDate() != null){ %>
<input type="text" class="calDate" id="fromDateId"
	name="<%=ENTRY_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(contigentMedicalBillHd.getEntryDate() ) %>"
	readonly="readonly" MAXLENGTH="30" validate="Entry Date,date,yes" /> <%}else{ %>
<input type="text" class="calDate" id="fromDateId"
	name="<%=ENTRY_DATE %>" value="<%=currentDate %>" readonly="readonly"
	MAXLENGTH="30" validate="Entry Date,date,yes" /> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.contingentBill.<%=ENTRY_DATE%>,event)" />

<div class="Clear"></div>

<label>Patient Name</label> <label class="value"><%=contigentMedicalBillHd.getHin().getPFirstName()+" "+contigentMedicalBillHd.getHin().getPMiddleName()+" "+contigentMedicalBillHd.getHin().getPLastName() %></label>

<label>Service No.</label> <label class="value"><%=contigentMedicalBillHd.getHin().getServiceNo()%></label>

<label>Rank </label> <%if(contigentMedicalBillHd.getHin().getRank() !=null){ %>
<label class="value"><%=contigentMedicalBillHd.getHin().getRank().getRankName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %>

<div class="Clear"></div>

<label>Branch/Trade </label> <%if(contigentMedicalBillHd.getHin().getTrade() !=null){ %>
<label class="value"><%=contigentMedicalBillHd.getHin().getTrade().getTradeName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> <label>Unit </label> <%if(contigentMedicalBillHd.getHin().getUnit() !=null){ %>
<label class="value">&nbsp;<%=contigentMedicalBillHd.getHin().getUnit().getUnitName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> <%
			int inpatientId =0;
			String flag = "";
			Set<Inpatient> set = new HashSet<Inpatient>();
			set = contigentMedicalBillHd.getHin().getInpatients();
			for(Inpatient inpatient : set){
				if(inpatient.getAdStatus().equals("A")){
					inpatientId = inpatient.getId();
				
%> <%if(contigentMedicalBillHd.getInpatient()!=null){ %> <input
	type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=contigentMedicalBillHd.getInpatient().getId()%>" /> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=contigentMedicalBillHd.getInpatient().getDepartment().getId() %>" />
<%}}} %> <input type="hidden" name="contigentMedicalBillHdId"
	value="<%=contigentMedicalBillHd.getId()%>" /> <input type="hidden"
	name="<%=HIN_ID %>"
	value="<%=contigentMedicalBillHd.getHin().getId() %>" /> <input
	type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />

<label>Claim Type</label> <select name="<%=CLAIM_TYPE%>">
	<option value="general">General Claim</option>
	<option value="emergency">Emergency Claim</option>
	<option value="hearingAid">Hearing aid claim</option>
</select></div>
<div class="Clear"></div>
<div class="division"></div>
<label class="large">Investigation Required</label> <input type="button"
	name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" />
<input type="button" name="delete" value="" class="buttonDel"
	onclick="removeRow();" /> <label
	style="padding-left: 30px; width: 140px;">Select Test Type :-</label>
<label style="padding-left: 20; width: 70px;">ALL Test</label> <input
	type="radio" name="testType" id="testType1" value="ALL"
	onclick="checkedfunctions();" style="width: 5px;" /> <label
	style="padding-left: 20; width: 180px;">GeneralClaims Specific
Test </label> <input type="radio" name="testType" id="testType2"
	value="MEDCLAIMS" checked="checked" style="width: 5px;"
	onclick="checkedfunctions();" />

<div class="tableHolderAuto">

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails">
	<thead>
		<tr>
			<th scope="col">&nbsp;</th>
			<th scope="col">Test Name</th>
		</tr>
	</thead>
	<tbody>

		<%
		int inc = 0;
	List<MdContigentMedicalBillDt>medicalBillDtList=new ArrayList<MdContigentMedicalBillDt>();
	if(map.get("medicalBillDtList")!=null){
		medicalBillDtList=(List<MdContigentMedicalBillDt>)	map.get("medicalBillDtList");
	}
     if(medicalBillDtList!= null && medicalBillDtList.size()>0){
    	 for(MdContigentMedicalBillDt contigentMedicalBillDt:medicalBillDtList){
		 inc++; 
	%>

		<tr>
			<td><input type="checkbox" value="<%=inc%>"
				name="selectedChrage" class="radioCheck" /></td>
			<td>
			<%if(contigentMedicalBillDt.getCharge()!= null){ %> 
			<input type="text" tabindex="1" align="right" name="<%=CHARGE_NAME%>" size="80" id="chargeName<%=inc%>" onblur="if(fillSrNo){fillChargeId(this.value,<%=inc %>);}"
				value="<%=contigentMedicalBillDt.getCharge().getChargeCodeName()+"["+contigentMedicalBillDt.getCharge().getId()+"]" %>" />
			<div id="ac2update" style="display: none; border: 1px solid #000"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				function eventCallback(element, entry){
					return entry + "&testType="+selectedTestType; 
				}
				
			    new Ajax.Autocompleter(document.getElementById('chargeName<%=inc%>'),'ac2update','mediClaim?method=getChargeName',{parameters:'requiredField=chargeName',callback:eventCallback});
			    alert(inc);
    </script> <input type="hidden"
				value="<%=contigentMedicalBillDt.getCharge().getId()%>"
				name="chargeId" id="chargeId" /> 
				<%}else{ %> 
				<input type="text"
				name="<%=CHARGE_NAME%>" id="chargeName<%=inc%>"
				onblur="if(fillSrNo){fillChargeId(this.value,<%=inc %>);}"
				tabindex="1" align="right" size="80" />

			<div id="ac2update" style="display: none; border: 1px solid #000"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				function eventCallback(element, entry){
					return entry + "&testType="+selectedTestType; 
				}
				
			    new Ajax.Autocompleter(document.getElementById('chargeName<%=inc%>'),'ac2update','mediClaim?method=getChargeName',{parameters:'requiredField=chargeName',callback:eventCallback});
			    
    </script> <input type="hidden" value="" name="chargeId"
				id="chargeCodeId<%=inc %>" /> <%} %>
			</td>
		</tr>
		<%}} %>
	</tbody>
</table>
<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"
	id="hiddenValueCharge" /></div>

<div class="division"></div>
<div class="blockFrame">
<label><span>*</span> Bill No.</label> 
<%if(contigentMedicalBillHd.getBillNo()!=null){ %> 
<input id="billNo" type="text" name="<%= BILL_NO%>" value="<%=contigentMedicalBillHd.getBillNo() %>" validate="Bill No,string,yes" MAXLENGTH="15" tabindex=1 /> 
<%}else{ %> 
<input id="billNo" type="text" name="<%= BILL_NO%>" value="" validate="Bill No,string,yes" MAXLENGTH="15" tabindex=1 /> 
<%} %> 
<label><span>*</span>Bill Date</label> 
<%if(contigentMedicalBillHd.getBillDate()!=null){ %> 
<input type="text" class="calDate" id="fromDateId" name="<%=BILL_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(contigentMedicalBillHd.getBillDate()) %>"
	readonly="readonly" MAXLENGTH="30" /> 
	<%}else{ %> 
	<input type="text" class="calDate" id="fromDateId" name="<%=BILL_DATE %>" value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> 
	<%} %> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.contingentBill.<%=BILL_DATE%>,event)" />

<label><span>*</span> Amount(Rs.)</label> 
<%if(contigentMedicalBillHd.getAmount()!=null){ %>
<input id="amount" type="text" name="<%= AMOUNT%>" value="<%=contigentMedicalBillHd.getAmount() %>"
	validate="Amount,float,yes" MAXLENGTH="8" tabindex=1 /> 
<%}else{ %> 
<input id="amount" type="text" name="<%= AMOUNT%>" value=""
	validate="Amount,float,yes" MAXLENGTH="8" tabindex=1 /> 
<%} %>
<div class="Clear"></div>

<label style="width:230px;padding-left:10px;"><span>*</span>Amt. Qualifying of reimbursement of Rs.</label> 
<%if(contigentMedicalBillHd.getQualifyingAmount()!=null){ %>
<input id="qualifyingAmt" type="text" name="<%= QUALIFYING_RS%>" value="<%=contigentMedicalBillHd.getQualifyingAmount() %>"
	validate="Amount Qualifying of reimbursement of Rs.,float,yes"
	maxlength="8" onblur="checkQualifyingAmt();" tabindex=1 style="width:80px;" /> 
	<%}else{ %> 
	<input id="qualifyingAmt" type="text" name="<%= QUALIFYING_RS%>" value=""
	validate="Amount Qualifying of reimbursement of Rs.,float,yes"
	maxlength="8" onblur="checkQualifyingAmt();" tabindex=1  style="width:80px;"/> 
	<%} %> 
<label style="padding-left: 10px;"><span>*</span> Amount Payable to</label> <%if(contigentMedicalBillHd.getPayableTo()!=null){ %>
<input id="payAmount" type="text" class="large2" name="<%= PAYABLE_TO%>"
	value="<%= contigentMedicalBillHd.getPayableTo()%>"
	validate="Amount Payable,string,yes" MAXLENGTH=50 " tabindex=1 /> <%}else{ %>
<input id="payAmount" type="text" class="large2" name="<%= PAYABLE_TO%>"
	value="" validate="Amount Payable,string,yes" MAXLENGTH=50 " tabindex=1 />
<%} %>
<div class="Clear"></div>

<label class="noWidth"><span>*</span> Name of pay account office
in which individual IRLAs are maintained</label> <%if(contigentMedicalBillHd.getAccountOfficer()!=null){ %>
<input id="payName" type="text" class="large2"
	name="<%= NAME_PAY_OFFICER%>"
	value="<%=contigentMedicalBillHd.getAccountOfficer() %>"
	validate="Name of pay account office,string,yes" MAXLENGTH="50"
	tabindex=1 /> <%}else{ %> <input id="payName" type="text" class="large2"
	name="<%= NAME_PAY_OFFICER%>" value=""
	validate="Name of pay account office,string,yes" MAXLENGTH="50"
	tabindex=1 /> <%} %>

<div class="Clear"></div>

<label><span>*</span> Date of Submission</label> <%if(contigentMedicalBillHd.getSubmissionDate()!=null){ %>
<input type="text" class="calDate" id="fromDateId" name="<%=SUB_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(contigentMedicalBillHd.getSubmissionDate()) %>"
	readonly="readonly" MAXLENGTH="30"
	validate="Date Of Submission,date,yes" /> <%}else{ %> <input type="text"
	class="calDate" id="fromDateId" name="<%=SUB_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30"
	validate="Date Of Submission,date,yes" /> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.contingentBill.<%=SUB_DATE%>,event)" />


<label>Received (Rs.)</label> <%if(contigentMedicalBillHd.getReceivedRs()!=null){ %>
<input id="receivedRs" type="text" name="<%= RECEIVED_RS%>"
	value="<%=contigentMedicalBillHd.getReceivedRs() %>"
	validate="Received Rs,float,no" maxlength="8" tabindex=1 /> <%}else{ %>
<input id="receivedRs" type="text" name="<%= RECEIVED_RS%>" value=""
	validate="Received Rs,float,no" maxlength="8" tabindex=1 /> <%} %>

<div class="Clear"></div>
<label><span>*</span> FWT to</label> <select name="<%= AUTHORITY_ID %>"
	validate="FWT to,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%
				         		if(authorityList != null){ 	
				         			for (Iterator iter = authorityList.iterator(); iter.hasNext();) {
				         				MdMasAuthority mdMasAuthority = (MdMasAuthority) iter.next();
				         %>
	<%if(contigentMedicalBillHd.getFwtTo().getId() .equals(mdMasAuthority.getId())){ %>
	<option value="<%=contigentMedicalBillHd.getFwtTo().getId()%>"
		selected="selected"><%=contigentMedicalBillHd.getFwtTo().getAuthorityName()%></option>
	<%}else{ %>
	<option value="<%=mdMasAuthority.getId() %>"><%=mdMasAuthority.getAuthorityName()%></option>
	<%		}} } %>
</select> <label><span>*</span> FWT Date</label> <%if(contigentMedicalBillHd.getFwtDate()!=null){ %>
<input type="text" class="calDate" id="fromDateId" name="<%=FWT_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(contigentMedicalBillHd.getFwtDate())%>"
	readonly="readonly" MAXLENGTH="30" validate="FWT Date:,date,yes" /> <%}else{ %>
<input type="text" class="calDate" id="fromDateId" name="<%=FWT_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30"
	validate="FWT Date:,date,yes" /> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.contingentBill.<%=FWT_DATE%>,event)" />
<div class="Clear"></div>
</div>
<div class="Height10"></div>
<div class="Clear"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Update"
	onclick="if(checkFilledRow())submitForm('contingentBill','mediClaim?method=updateMedicalBill');"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset"
	onclick="resetClicked('contingentBill',<%=inc %>);" accesskey="r" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <input
	type="hidden" name="changed_by" value="<%=userName%>"> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <input type="hidden"
	name="changed_date" value="<%=currentDate%>"> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="changed_time" value="<%=time%>">

<div class="Clear"></div>
<input type="hidden" name="counter" value=<%=inc %>></div>
</div>
</form>

<script type="text/javascript">
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
	  e2.name='chargeId';
	  e2.id='chargeCodeId'+iteration
	  e2.size = '10'
	  e2.maxLength="5"
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
	  				alert("Please fill atleast one Test to submit.");
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

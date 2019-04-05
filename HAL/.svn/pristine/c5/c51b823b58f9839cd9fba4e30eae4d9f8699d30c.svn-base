
<html>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.*"%>

<head>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<br />
</head>
<body>
<script type="text/javascript" language="javascript">
	 var masRelationArray=new Array();
	<%
	Date d=new Date();
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}
	
	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>
<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
	hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	
	List<MasRelation> masRelationList=new ArrayList<MasRelation>();
	if(map.get("masRelationList")!= null){
		masRelationList=(List<MasRelation>)map.get("masRelationList");
	}
	
	List<PensionDataSheet> pensionDataSheetList=new ArrayList<PensionDataSheet>();
	if(map.get("pensionDataSheetList")!= null){
		pensionDataSheetList=(List<PensionDataSheet>)map.get("pensionDataSheetList");
	}
	PensionDataSheet pensionDataSheet=(PensionDataSheet)pensionDataSheetList.get(0);
	
	
	
	
	
	%>
<div id="contentHolder">
<form name="updateDataSheet" method="post">
<h6>Update Data Sheet</h6>
<div class="floatRight">
<h5>Total Service</h5>
<h5>years</h5>
<label class="noWidth"><%=pensionDataSheet.getPersonnel().getTotalServiceWithoutEolYears() %></label>
<h5>months</h5>
<label class="noWidth"><%=pensionDataSheet.getPersonnel().getTotalServiceWithoutEolMonths() %></label>
<h5>days</h5>
<label class="noWidth"><%=pensionDataSheet.getPersonnel().getTotalServiceWithoutEolDays() %></label>
</div>
<div class="Clear"></div>

<div class="blockFrame"><label>1. Organisation Code </label> <%if(pensionDataSheet.getOrganisationCode()!= null){ %>
<input name="orgCode" class="small"
	value="<%=pensionDataSheet.getOrganisationCode() %>" type="text"
	maxlength="5" /> <%}else{ %> <input name="orgCode" class="small"
	type="text" maxlength="5" /> <%} %> <label>2. ORG-Group For
GPF-No</label> <%if(pensionDataSheet.getOrgGroup()!= null){ %> <input
	name="orgGroup" type="text"
	value="<%=pensionDataSheet.getOrgGroup() %>" maxlength="5" /> <%}else{ %>
<input name="orgGroup" type="text" maxlength="5" /> <%} %> <label>3.
GPF No </label> <%if(pensionDataSheet.getGpfNo()!= null){ %> <input name="gpfNo"
	type="text" value="<%=pensionDataSheet.getGpfNo() %>" maxlength="9" />
<%}else{ %> <input name="gpfNo" type="text" maxlength="9" /> <%} %>
<div class="Clear"></div>

<label>4. Office Unit Formation</label> <label class="value"><%=pensionDataSheet.getPersonnel().getUnit().getUnitName() %></label>

<label>5. Head Office Address</label> <%if(pensionDataSheet.getHeadOfficeAddress() !=null){ %>
<textarea name="headOfficeAddress" maxlength="100"
	onkeyup="return ismaxlength(this)"><%=pensionDataSheet.getHeadOfficeAddress() %></textarea>
<%}else{ %> <textarea name="headOfficeAddress" maxlength="100"
	onkeyup="return ismaxlength(this)"></textarea> <%} %>
</div>


<h5>Part-A Service Purticulars</h5>

<div class="blockFrame"><label>Pass No. </label> <label
	class="value"><%=pensionDataSheet.getPersonnel().getPassNo() %></label>

<label>Name.</label> <label class="value"><%=pensionDataSheet.getPersonnel().getPersonnelName() %></label>

<label>Nationality Code.</label> <%if(pensionDataSheet.getNationalityCode()!= null){ %>
<input name="natinalityCode" type="text"
	value="<%=pensionDataSheet.getNationalityCode()%>" maxlength="2" /> <%}else{ %>
<input name="natinalityCode" type="text" maxlength="2" /> <%} %> <label>Sex</label>
<label class="value"><%=pensionDataSheet.getPersonnel().getAdministrativeSex().getAdministrativeSexName() %></label>



<label>Post Last Held</label> <label class="value"><%=pensionDataSheet.getPersonnel().getDesignation().getDesignationName() %></label>

<label>Date Of Birth</label> <label class="value"><%=HMSUtil.changeDateToddMMyyyy(pensionDataSheet.getPersonnel().getDateOfBirth())%></label>

<div class="Clear"></div>

<label>Date Of Joining</label> <label class="value"><%=HMSUtil.changeDateToddMMyyyy(pensionDataSheet.getPersonnel().getPostingIn()) %></label>
<div class="Clear"></div>

<label>Industrial/Non-Industrial</label> <label class="value"><%=pensionDataSheet.getPersonnel().getDesignation().getType() %></label>

<label>Date Of Retirement</label> <label class="value"><%=HMSUtil.changeDateToddMMyyyy(pensionDataSheet.getPersonnel().getRetirementDate())%></label>
<div class="Clear"></div>
<label>Retirement</label> <select name="retirementType" />
	<option value="0">Select</option>
	<%if(pensionDataSheet.getRetirement()!= null){
			if(pensionDataSheet.getRetirement().equals("AN")){ %>
	<option value="AN" selected>AN</option>
	<%}else{ %>
	<option value="AN">AN</option>
	<%}if(pensionDataSheet.getRetirement().equals("FN")){ %>
	<option value="FN" selected>FN</option>
	<%}else{ %>
	<option value="FN">FN</option>
	<%} }%>
</select> <label>Nature Of Pension</label> <%if(pensionDataSheet.getNatureOfPension()!= null){ %>
<input name="natureOfPension"
	value="<%=pensionDataSheet.getNatureOfPension() %>" type="text"
	maxlength="6" /> <%}else{ %> <input name="natureOfPension" type="text"
	maxlength="6" /> <%} %> <label>Former Service Counted
Towards(current spell)</label> <%if(pensionDataSheet.getFormerServiceCounted()!= null){ %>
<input name="formerService" type="text"
	value="<%=pensionDataSheet.getFormerServiceCounted() %>" maxlength="6" />
<%}else{ %> <input name="formerService" type="text" maxlength="6" /> <%} %>

<div class="Clear"></div>

<label>Weightage allowed in qualifying service</label> <%if(pensionDataSheet.getWeightageAllowed()!= null){ %>
<input name="weightage" type="text"
	value="<%=pensionDataSheet.getWeightageAllowed() %>" maxlength="5" /> <%}else{ %>
<input name="weightage" type="text" maxlength="5" /> <%} %> <label>Medical
Allowannce</label> <%if(pensionDataSheet.getMedicalAllowance()!= null){ %> <input
	name="medicalAllowance" type="text" class="small"
	value="<%=pensionDataSheet.getMedicalAllowance() %>" maxlength="1" /> <%}else{ %>
<input name="medicalAllowance" type="text" class="small" maxlength="1" />
<%} %> <label>Group</label> <%if(pensionDataSheet.getPayGroup()!= null){ %>
<input name="payGroup" type="text" class="small"
	value="<%=pensionDataSheet.getPayGroup() %>" maxlength="1" /> <%}else{ %>
<input name="payGroup" type="text" class="small" maxlength="1" /> <%} %>
<div class="Clear"></div>
</div>
<h5>Part-B Last Pay Details</h5>

<div class="blockFrame"><label>Pay Code </label> <%if(pensionDataSheet.getPayCode()!= null){ %>
<input type="text" id="payCode"
	value="<%=pensionDataSheet.getPayCode() %>" name="payCode"
	maxlength="2" /> <%}else{ %> <input type="text" id="payCode"
	name="payCode" maxlength="2" /> <%} %> <label>Pay Band Code </label> <%if(pensionDataSheet.getPayBandCode()!= null){ %>
<input type="text" id="payBandCode" name="payBandCode"
	value="<%=pensionDataSheet.getPayBandCode() %>" maxlength="2" /> <%}else{ %>
<input type="text" id="payBandCode" name="payBandCode" maxlength="2" />
<%} %> <label>Pay in Pay Band Scale(Excluding Grade Pay) </label> <%if(pensionDataSheet.getPayInPayBandScale()!= null){ %>
<input type="text" id="payInPayBandScale"
	value="<%=pensionDataSheet.getPayInPayBandScale() %>"
	name="payInPayBandScale" maxlength="5" /> <%}else{ %> <input type="text"
	id="payInPayBandScale" name="payInPayBandScale" maxlength="5" /> <%} %>
<div class="Clear"></div>

<label>Grade Pay </label> <%if(pensionDataSheet.getGradePay()!= null){ %>
<input type="text" id="gradePay" name="gradePay"
	value="<%=pensionDataSheet.getGradePay() %>" maxlength="5" /> <%}else{ %>
<input type="text" id="gradePay" name="gradePay" maxlength="5" /> <%} %> <label>NPA/MS
pay </label> <%if(pensionDataSheet.getNpMsPay()!= null){ %> <input type="text"
	id="npa" name="npa" value="<%=pensionDataSheet.getNpMsPay() %>"
	maxlength="5" /> <%}else{ %> <input type="text" id="npa" name="npa"
	maxlength="5" /> <%} %> <label class="noWidth">Date Of Last Pay
Drawn</label> <%if(pensionDataSheet.getLastPayDrawn()!= null){ %> <input
	name="lastPayDate" type="text" maxlength="2"
	value="<%=HMSUtil.changeDateToddMMyyyy(pensionDataSheet.getLastPayDrawn()) %>"
	readonly /> <%}else{ %> <input name="lastPayDate" type="text"
	maxlength="2" readonly /> <%} %> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('',document.updateDataSheet.lastPayDate,event)" />

<div class="Clear"></div>

<label>10 month average </label> <%if(pensionDataSheet.getMonAve()!= null){ %>
<input type="text" id="monthsAverage" name="monthsAverage"
	value="<%=pensionDataSheet.getMonAve() %>" maxlength="5"
	validate="10 Months Average,num,no" /> <%}else{ %> <input type="text"
	id="monthsAverage" name="monthsAverage" maxlength="5"
	validate="10 Months Average,num,no" /> <%} %> <label>GAL Award </label> <%if(pensionDataSheet.getGalAward()!= null){ %>
<input type="text" id="galAward" class="small" name="galAward"
	value="<%=pensionDataSheet.getGalAward() %>" maxlength="2" /> <%}else{ %>
<input type="text" id="galAward" class="small" name="galAward"
	maxlength="2" /> <%} %> <label>Last Pay Reduced</label> <select
	name="lastPayReduced">
	<option value="0">Select</option>
	<%if(pensionDataSheet.getLastPayReduced()!= null){
		if(pensionDataSheet.getLastPayReduced().equals("y")){ %>
	<option value="y" selected>Yes</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<%}if(pensionDataSheet.getLastPayReduced().equals("n")){ %>
	<option value="n" selected>No</option>
	<%}else{ %>
	<option value="n">No</option>
	<%}} %>
</select>
<div class="Clear"></div>

<h5>Amount Of Demand</h5>
<div class="Clear"></div>
<label>On A/C of RDR Head </label> <%if(pensionDataSheet.getAcOfRdrHead()!= null){ %>
<input type="text" id="rdrHead" name="rdrHead"
	value="<%=pensionDataSheet.getAcOfRdrHead() %>" maxlength="7" /> <%}else{ %>
<input type="text" id="rdrHead" name="rdrHead" maxlength="7" /> <%} %> <label>On
A/C of Other than RDR Head </label> <%if(pensionDataSheet.getAcOtherThenRdrHead()!= null){ %>
<input type="text" id="otherThenRdrHead" name="otherThenRdrHead"
	value="<%=pensionDataSheet.getAcOtherThenRdrHead() %>" maxlength="7" />
<%}else{ %> <input type="text" id="otherThenRdrHead"
	name="otherThenRdrHead" maxlength="7" /> <%} %> <label>Interest
On RDR Demand </label> <%if(pensionDataSheet.getInterestOnRdrDemand()!= null){ %>
<input type="text" id="rdrDemand" name="rdrDemand"
	value="<%=pensionDataSheet.getInterestOnRdrDemand() %>" maxlength="7" />
<%}else{ %> <input type="text" id="rdrDemand" name="rdrDemand"
	maxlength="7" /> <%} %>

<div class="Clear"></div>

<label>Interest Payable </label> <%if(pensionDataSheet.getInterestPayable()!= null){ %>
<input type="text" id="interestPayable" name="interestPayable"
	value="<%=pensionDataSheet.getInterestPayable() %>" maxlength="7" /> <%}else{ %>
<input type="text" id="interestPayable" name="interestPayable"
	maxlength="7" /> <%} %>
</div>


<h5>Part-C Commutation Purticulars</h5>
<div class="blockFrame"><label>Date Of Receipt</label> <%if(pensionDataSheet.getDateOfReceipt()!= null){ %>
<input name="dateOfReceipt" type="text" maxlength="10"
	value="<%=HMSUtil.changeDateToddMMyyyy(pensionDataSheet.getDateOfReceipt()) %>"
	readonly /> <%}else{ %> <input name="dateOfReceipt" type="text"
	maxlength="10" readonly /> <%} %> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('',document.updateDataSheet.dateOfReceipt,event)" /> <label>Fraction
Commuted</label> <%if(pensionDataSheet.getFractionComm()!= null){ %> <input
	name="fractionComm" type="text" maxlength="2"
	value="<%=pensionDataSheet.getFractionComm() %>"
	validate="Fraction Commuted,num,no" /> <%}else{%> <input
	name="fractionComm" type="text" maxlength="2"
	validate="Fraction Commuted,num,no" /> <%} %> <label>Amount Comm.</label>
<%if(pensionDataSheet.getAmountComm()!= null){ %> <input name="amountComm"
	type="text" maxlength="5"
	value="<%=pensionDataSheet.getAmountComm() %>" validate="Amount,num,no" />
<%}else{ %> <input name="amountComm" type="text" maxlength="5"
	validate="Amount,num,no" /> <%} %> <label>Age Load</label> <%if(pensionDataSheet.getAgeLoad()!= null){ %>
<input name="ageLoad" type="text" maxlength="2"
	value="<%=pensionDataSheet.getAgeLoad() %>" validate="Age Load,num,no" />
<%}else{ %> <input name="ageLoad" type="text" maxlength="2"
	validate="Age Load,num,no" /> <%} %>
</div>

<h5>Part-D Family Purticulars</h5>
<div class="blockFrame"><label>Married Before Retirement.</label>
<select name="marriedBeforeRetirement" />
	<option value="0" selected>Select</option>
	<% if(pensionDataSheet.getMarriedBeforeRetirement()!= null){
		if(pensionDataSheet.getMarriedBeforeRetirement().equals("Yes")){ %>
	<option value="Yes">Yes</option>
	<%}else{ %>
	<option value="Yes">Yes</option>
	<%}if(pensionDataSheet.getMarriedBeforeRetirement().equals("No")){ %>
	<option value="No" selected>No</option>
	<%}else{ %>
	<option value="No">No</option>
	<%}} %>
</select> <label>Spouse Alive</label> <select name="spouseAlive">
	<option value="0">Select</option>
	<% if(pensionDataSheet.getSpouseAlive()!= null){
		if(pensionDataSheet.getSpouseAlive().equals("y")){ %>
	<option value="y">Yes</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<%}if(pensionDataSheet.getSpouseAlive().equals("n")){ %>
	<option value="n">No</option>
	<%}else{ %>
	<option value="n">No</option>
	<%}} %>
</select> <label>Name Of Spouse</label> <%if(pensionDataSheet.getNameOfSpouse()!= null){ %>
<input name="spouseName" type="text"
	value="<%=pensionDataSheet.getNameOfSpouse() %>" maxlength="30" /> <%}else{ %>
<input name="spouseName" type="text" maxlength="30" /> <%} %>



<div class="Clear"></div>

<label>Natinality Code Spouse</label> <%if(pensionDataSheet.getNationalityCodeSpouse()!= null){ %>
<input name="natinalityCodeSpouse"
	value="<%=pensionDataSheet.getNationalityCodeSpouse() %>" type="text"
	maxlength="2" /> <%}else{ %> <input name="natinalityCodeSpouse"
	type="text" maxlength="2" /> <%} %> <label class="noWidth">Age
Spouse</label> <%if(pensionDataSheet.getAgeSpouse()!= null){ %> <input
	name="ageSpouse" type="text" maxlength="2"
	value="<%=HMSUtil.changeDateToddMMyyyy(pensionDataSheet.getAgeSpouse()) %>" />
<%}else{ %> <input name="ageSpouse" type="text" maxlength="2" /> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.updateDataSheet.ageSpouse,event)" />

<div class="Clear"></div>

</div>



<h5>Part-E PDA Details</h5>
<div class="blockFrame"><label>PDA Code </label> <%if(pensionDataSheet.getPdaCode()!= null){ %>
<input type="text" id="pdaCode" name="pdaCode"
	value="<%=pensionDataSheet.getPdaCode() %>" maxlength="1" /> <%}else{ %>
<input type="text" id="pdaCode" name="pdaCode" maxlength="1" /> <%} %> <label>DPDO
Code </label> <%if(pensionDataSheet.getDpdoCode()!= null){ %> <input type="text"
	id="dpdoCode" name="dpdoCode"
	value="<%=pensionDataSheet.getDpdoCode() %>" maxlength="20" /> <%}else{ %>
<input type="text" id="dpdoCode" name="dpdoCode" maxlength="20" /> <%} %>

<label>PDA Station</label> <%if(pensionDataSheet.getPdaStation()!= null){ %>
<input type="text" id="bankSubTreeStation" name="bankSubTreeStation"
	value="<%=pensionDataSheet.getPdaStation() %>" maxlength="24" /> <%}else{ %>
<input type="text" id="bankSubTreeStation" name="bankSubTreeStation"
	maxlength="24" /> <%} %> <label>PDA State Code</label> <%if(pensionDataSheet.getPdaStateCode()!= null){ %>
<input type="text" id="pdaStateCode" name="pdaStateCode"
	value="<%=pensionDataSheet.getPdaStateCode() %>" maxlength="2" /> <%}else{ %>
<input type="text" id="pdaStateCode" name="pdaStateCode" maxlength="2" />
<%} %> <label>Bank Sub Try Code</label> <%if(pensionDataSheet.getBankSubTryCode()!= null){ %>
<input type="text" id="bankSubTryCode" name="bankSubTryCode"
	value="<%=pensionDataSheet.getBankSubTryCode() %>" maxlength="3" /> <%}else{ %>
<input type="text" id="bankSubTryCode" name="bankSubTryCode"
	maxlength="3" /> <%} %> <label>Link Bank</label> <%if(pensionDataSheet.getLinkBank()!= null){ %>
<input type="text" id="linkBank" name="linkBank"
	value="<%=pensionDataSheet.getLinkBank() %>" maxlength="40" /> <%}else{ %>
<input type="text" id="linkBank" name="linkBank" maxlength="40" /> <%} %>
<div class="Clear"></div>

<label>Bank Branch</label> <%if(pensionDataSheet.getBankBranch()!= null){ %>
<input type="text" id="bankBranch" name="bankBranch"
	value="<%=pensionDataSheet.getBankBranch() %>" maxlength="40" /> <%}else{ %>
<input type="text" id="bankBranch" name="bankBranch" maxlength="40" />
<%} %> <label>BSR Code of Bank Branch </label> <%if(pensionDataSheet.getBsrCodeOfBankBranch()!= null){ %>
<input type="text" id="bsrCodeOfBankBranch"
	value="<%=pensionDataSheet.getBsrCodeOfBankBranch() %>"
	name="bsrCodeOfBankBranch" maxlength="7" /> <%}else{ %> <input
	type="text" id="bsrCodeOfBankBranch" name="bsrCodeOfBankBranch"
	maxlength="7" /> <%} %> <label>BSR Code of Link Bank </label> <%if(pensionDataSheet.getBsrCodeOfLinkBank()!= null){ %>
<input type="text" id="bsrCodeOfLinkBank" name="bsrCodeOfLinkBank"
	value="<%=pensionDataSheet.getBsrCodeOfLinkBank() %>" maxlength="7" />
<%}else{ %> <input type="text" id="bsrCodeOfLinkBank"
	name="bsrCodeOfLinkBank" maxlength="7" /> <%} %>

<div class="Clear"></div>
<label>Bank A/C No </label> <input type="text" id="acNo" name="acNo"
	maxlength="20" /> <label>Pensioners Address </label> <%if(pensionDataSheet.getPersonnel().getPermanentAddress()!= null){ %>
<input type="text" id="pensionersAddress" name="pensionersAddress"
	value="<%=pensionDataSheet.getPersonnel().getPermanentAddress()%>"
	maxlength="20" /> <%}else{ %> <input type="text" id="pensionersAddress"
	name="pensionersAddress" maxlength="20" /> <%} %> <label>Pensioners
State Code </label> <%if(pensionDataSheet.getPensionersStateCode()!= null){ %> <input
	type="text" id="pensionersStateCode" name="pensionersStateCode"
	value="<%=pensionDataSheet.getPensionersStateCode() %>" maxlength="20" />
<%}else{ %> <input type="text" id="pensionersStateCode"
	name="pensionersStateCode" maxlength="20" /> <%} %>

<div class="Clear"></div>
<label>Ind Pin Code </label> <%if(pensionDataSheet.getPersonnel().getPermanentPin()!= null){ %>
<input type="text" id="indPinCode" name="indPinCode"
	value="<%=pensionDataSheet.getPersonnel().getPermanentPin() %>"
	maxlength="20" /> <%}else{ %> <input type="text" id="indPinCode"
	name="indPinCode" maxlength="20" /> <%} %> <label>Having
Handicapped Child </label> <select name="handicappedChild">
	<option value="0">Select</option>
	<%if(pensionDataSheet.getHavingHandicappedChild()!= null){
		if(pensionDataSheet.getHavingHandicappedChild().equals("y")){ %>
	<option value="y" selected>Yes</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<%}if(pensionDataSheet.getHavingHandicappedChild().equals("n")){ %>
	<option value="n" selected>No</option>
	<%}else{ %>
	<option value="n">No</option>
	<%}} %>
</select> <label>Name Of Handicapped Child </label> <%if(pensionDataSheet.getNameOfHandicappedChild()!= null){ %>
<input type="text" id="nameOfHandicappedChild"
	value="<%=pensionDataSheet.getNameOfHandicappedChild() %>"
	name="nameOfHandicappedChild" maxlength="20" /> <%}else{ %> <input
	type="text" id="nameOfHandicappedChild" name="nameOfHandicappedChild"
	maxlength="20" /> <%} %>

<div class="Clear"></div>
<label>Relationship </label> <select name="relationId">
	<option value="0">Select</option>
	<%
        
             for(MasRelation masRelation:masRelationList){
            	 int id=masRelation.getId();
            	 String relationName=masRelation.getRelationName();
            		if(pensionDataSheet.getRelation().getId()==id){
         %>
	<option value="<%=id %>" selected><%=relationName %></option>
	<%}else{ %>
	<option value="<%=id %>"><%=relationName %></option>
	<%}} %>
</select> <label>CDR No </label> <%if(pensionDataSheet.getCdrNo()!= null){ %> <input
	type="text" id="cdrNo" name="cdrNo"
	value="<%=pensionDataSheet.getCdrNo() %>" maxlength="9" /> <%}else{ %> <input
	type="text" id="cdrNo" name="cdrNo" maxlength="9" /> <%} %>
</div>
<div class="bottom"><input type="hidden" name="personnelId"
	value="<%=pensionDataSheet.getPersonnel().getId()%>" /> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	name="Submit" type="button" class="button" value="Update"
	onclick="submitForm('updateDataSheet','pension?method=updateDataSheet')" />
<input name="Button" type="button" class="button" value="Reset" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName %></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="Clear"></div>


</div>
<br>
<br>
<br>
</form>
</div>
</body>
</html>


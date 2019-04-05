
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.*"%>

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
		List<MasPersonnelDetails> masPersonnelDetailsList=new ArrayList<MasPersonnelDetails>();
		if(map.get("masPersonnelDetailsList")!= null){
			masPersonnelDetailsList=(List<MasPersonnelDetails>)map.get("masPersonnelDetailsList");
		}
		MasPersonnelDetails masPersonnelDetails=masPersonnelDetailsList.get(0);
		
		List<MasRelation> masRelationList=new ArrayList<MasRelation>();
		if(map.get("masRelationList")!= null){
			masRelationList=(List<MasRelation>)map.get("masRelationList");
		}
		
		
		
		if(map.get("message") != null){
				   String message = (String)map.get("message");
				   out.println(message);
				  }
		%>
<div id="contentHolder">
<form name="dataSheet" method="post">
<h6>Data Sheet</h6>
<div class="floatRight">
<h5>Total Service:</h5>
<h5>Years</h5>
<label class="noWidth"><%=masPersonnelDetails.getTotalServiceWithoutEolYears() %></label>
<h5>Months</h5>
<label class="noWidth"><%=masPersonnelDetails.getTotalServiceWithoutEolMonths() %></label>
<h5>Days</h5>
<label class="noWidth"><%=masPersonnelDetails.getTotalServiceWithoutEolDays() %></label>
</div>
<div class="Clear"></div>

<div class="blockFrame"><label class="large">1.
Organisation Code </label> <input name="orgCode" type="text" maxlength="2" /> <label
	class="large">2. ORG-Group For GPF-No</label> <input name="orgGroup"
	type="text" maxlength="5" />

<div class="Clear"></div>

<label class="large">3. GPF No </label> <input name="gpfNo" type="text"
	maxlength="9" /> <label class="large">4. Office Unit Formation</label>
<label class="value"><%=masPersonnelDetails.getUnit().getUnitName() %></label>

<div class="Clear"></div>

<label class="large">5. Head Office Address</label> <textarea
	name="headOfficeAddress" maxlength="100"
	onkeyup="return ismaxlength(this)"></textarea></div>

<h5>Part-A Service Purticulars</h5>
<div class="blockFrame"><label>Pass No. </label> <label
	class="value"><%=masPersonnelDetails.getPassNo() %></label> <label>Name.</label>
<label class="value"><%=masPersonnelDetails.getPersonnelName() %></label>

<label>Nationality Code.</label> <input name="natinalityCode"
	type="text" maxlength="10" /> <label>Sex</label> <label class="value"><%=masPersonnelDetails.getAdministrativeSex().getAdministrativeSexName() %></label>



<label>Post Last Held</label> <label class="value"><%=masPersonnelDetails.getDesignation().getDesignationName() %></label>

<label>Date Of Birth</label> <label class="value"><%=HMSUtil.changeDateToddMMyyyy(masPersonnelDetails.getDateOfBirth())%></label>
<div class="Clear"></div>

<label>Date Of Joining</label> <label class="value"><%=HMSUtil.changeDateToddMMyyyy(masPersonnelDetails.getPostingIn()) %></label>


<label class="large">Industrial/Non-Industrial</label> <label
	class="value"><%=masPersonnelDetails.getDesignation().getType() %></label>

<label>Date Of Retirement</label> <label class="value"><%=HMSUtil.changeDateToddMMyyyy(masPersonnelDetails.getRetirementDate())%></label>

<div class="Clear"></div>
<div class="Height10"></div>

<label>Retirement</label> <select name="retirementType" />
	<option value="0">Select</option>
	<option value="AN">AN</option>
	<option value="FN">FN</option>
</select> <label>Nature Of Pension</label> <input name="natureOfPension"
	type="text" class="small" maxlength="1" /> <label>Former
Service Counted Towards(current spell)</label> <input name="formerService"
	type="text" maxlength="6" />

<div class="Clear"></div>

<label>Weightage allowed in qualifying service</label> <input
	name="weightage" type="text" maxlength="5" /> <label>Medical
Allowannce</label> <input name="medicalAllowance" class="small" type="text"
	maxlength="1" /> <label>Group</label> <input name="payGroup"
	type="text" class="small" maxlength="1" /></div>
<div class="Clear"></div>

<h5>Part-B Last Pay Details</h5>
<div class="blockFrame"><label>Pay Code </label> <input
	type="text" id="payCode" class="small" name="payCode" maxlength="2" />

<label>Pay Band Code </label> <input type="text" id="payBandCode"
	class="small" name="payBandCode" maxlength="2" /> <label>Pay in
Pay Band Scale(Excluding Grade Pay) </label> <input type="text"
	id="payInPayBandScale" name="payInPayBandScale" maxlength="5" />

<div class="Clear"></div>

<label>Grade Pay </label> <input type="text" id="gradePay"
	name="gradePay" maxlength="5" /> <label>NPA/MS pay </label> <input
	type="text" id="npa" name="npa" maxlength="5" /> <label class="noWidth">Date
Of Last Pay Drawn</label> <input name="lastPayDate" type="text" readonly /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.dataSheet.lastPayDate,event)" />

<div class="Clear"></div>

<label>10 month average </label> <input type="text" id="monthsAverage"
	name="monthsAverage" maxlength="5" validate="10 Months Average,num,no" />

<label>GAL Award </label> <input type="text" id="galAward" class="small"
	name="galAward" maxlength="2" /> <label>Last Pay Reduced</label> <select
	name="lastPayReduced">
	<option value="0">Select one</option>
	<option value="Yes">Yes</option>
	<option value="No">No</option>
</select>
<div class="Clear"></div>

<h5>Amount Of Demand</h5>
<div class="Clear"></div>
<label>On A/C of RDR Head </label> <input type="text" id="rdrHead"
	name="rdrHead" maxlength="7" /> <label>On A/C of Other than RDR
Head </label> <input type="text" id="otherThenRdrHead" name="otherThenRdrHead"
	maxlength="7" /> <label>Interest On RDR Demand </label> <input
	type="text" id="rdrDemand" name="rdrDemand" maxlength="7" />

<div class="Clear"></div>

<label>Interest Payable </label> <input type="text" id="interestPayable"
	name="interestPayable" maxlength="7" /></div>


<h5>Part-C Commutation Purticulars</h5>
<div class="blockFrame"><label>Date Of Receipt</label> <input
	name="dateOfReceipt" type="text" maxlength="10" readonly /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.dataSheet.dateOfReceipt,event)" /> <label>Fraction
Commuted</label> <input name="fractionComm" type="text" maxlength="6"
	validate="Fraction Commuted,num,no" /> <label>Amount Comm.</label> <input
	name="amountComm" type="text" maxlength="6" validate="Amount,num,no" />

<label>Age Load</label> <input name="ageLoad" type="text" maxlength="2"
	validate="Age Load,num,no" /></div>

<h5>Part-D Family Purticulars</h5>
<div class="blockFrame"><label>Married Before Retirement.</label>
<select name="marriedBeforeRetirement" />
	<option value="0">Select</option>
	<option value="Yes">Yes</option>
	<option value="No">No</option>
</select> <label>Spouse Alive</label> <select name="spouseAlive">
	<option value="0">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select> <label>Name Of Spouse</label> <input name="spouseName" type="text"
	maxlength="30" />



<div class="Clear"></div>

<label>Nationality Code Spouse</label> <input
	name="natinalityCodeSpouse" class="small" type="text" maxlength="15" />


<label class="noWidth">Age Spouse</label> <input name="ageSpouse"
	type="text" maxlength="2" readonly /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.dataSheet.ageSpouse,event)" />

<div class="Clear"></div>

</div>



<h5>Part-E PDA Details</h5>
<div class="blockFrame"><label>PDA Code </label> <input
	type="text" class="small" id="pdaCode" name="pdaCode" maxlength="1" />

<label>DPDO Code </label> <input type="text" class="small" id="dpdoCode"
	name="dpdoCode" maxlength="2" /> <label>PDA Station</label> <input
	type="text" id="pdaStation" name="pdaStation" maxlength="24" /> <label>PDA
State Code</label> <input type="text" id="pdaStateCode" name="pdaStateCode"
	maxlength="2" /> <label>Bank Sub Try Code</label> <input type="text"
	id="bankSubTryCode" name="bankSubTryCode" maxlength="3" /> <label>Link
Bank</label> <input type="text" id="linkBank" name="linkBank" maxlength="40" />
<div class="Clear"></div>

<label>Bank Branch</label> <input type="text" id="bankBranch"
	name="bankBranch" maxlength="40" /> <label>BSR Code of Bank
Branch </label> <input type="text" id="bsrCodeOfBankBranch"
	name="bsrCodeOfBankBranch" maxlength="7" /> <label>BSR Code of
Link Bank </label> <input type="text" id="bsrCodeOfLinkBank"
	name="bsrCodeOfLinkBank" maxlength="7" />

<div class="Clear"></div>
<label>Bank A/C No </label> <input type="text" id="acNo" name="acNo"
	maxlength="20" /> <label>Pensioners Address </label> <input
	type="text" id="pensionersAddress" name="pensionersAddress"
	maxlength="20" /> <label>Pensioners State Code </label> <input
	type="text" id="pensionersStateCode" name="pensionersStateCode"
	maxlength="2" />

<div class="Clear"></div>
<label>Ind Pin Code </label> <input type="text" id="indPinCode"
	name="indPinCode" maxlength="20" /> <label>Having Handicapped
Child </label> <select name="handicappedChild">
	<option value="0">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select> <label>Name Of Handicapped Child </label> <input type="text"
	id="nameOfHandicappedChild" name="nameOfHandicappedChild"
	maxlength="20" />

<div class="Clear"></div>
<label>Relationship </label> <select name="relationId">
	<option value="0">Select</option>
	<%if(masRelationList!= null){
			for(MasRelation masRelation:masRelationList){
				String relationName=masRelation.getRelationName();
				int id=masRelation.getId();
		%>
	<option value="<%=id%>"><%=relationName%></option>
	<%		
			}
		}
        %>
</select> <label>CDR No </label> <input type="text" id="cdrNo" name="cdrNo"
	maxlength="9" /></div>

<div class="bottom"><input type="hidden" name="personnelId"
	value="<%=masPersonnelDetails.getId()%>" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input name="Submit"
	type="button" class="button" value="Submit"
	onclick="submitForm('dataSheet','pension?method=submitDataSheetJsp')" />
<input name="Button" type="button" class="button" value="Reset" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName %></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="Clear"></div>


</div>
</form>
</div>

<script type="text/javascript">
				function ismaxlength(obj){
				var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
				if (obj.getAttribute && obj.value.length>mlength)
				obj.value=obj.value.substring(0,mlength)
				}
		</script>
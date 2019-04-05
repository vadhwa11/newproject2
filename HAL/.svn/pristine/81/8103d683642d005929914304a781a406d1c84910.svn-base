
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>
 
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calendar.js" type="text/javascript"></script>
<SCRIPT>
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
		Map<String, Object> utilMap = new HashMap<String, Object>();
		String userName="";
		if(session.getAttribute("userName")!=null)
		 userName=(String)session.getAttribute("userName");
		
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		//String Session=(String) utilMap.get("session");
		String time = (String) utilMap.get("currentTime");		
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	
	</script>
<script type="text/javascript">
var bankArray=new Array();
</script>

<script type="text/javascript">

animatedcollapse.addDiv('jason', 'fade=1,height=80px')
animatedcollapse.addDiv('kelly', 'fade=1,height=100px')
animatedcollapse.addDiv('michael', 'fade=1,height=120px')

animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide4', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide5', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide6', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide7', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide8', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide9', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide10', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide11', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide12', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide13', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

function checkForInvestReferToMH()
 {
 	var inc=document.getElementById('hiddenValue').value;
 	var i;
 	for(i=1;i<=inc;i++)
 	{
 		if(document.getElementById('investigationReferToMH'+i).checked==true)
 		{
 			document.getElementById('uploadReport'+i).style.display='inline';
 		}		
 	}
 }
function checkForDentalMH()
{
   if(document.getElementById('dentalReferToMH').checked==true)
   {
   	document.getElementById('dentalReferToMH').value='yes';
   } else
   {
   	document.getElementById('dentalReferToMH').value='no';
   }              
}
</script>

<script type="text/javascript">
<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<MbTypeOfEntryMaster> typeOfEntryMasterList = new ArrayList<MbTypeOfEntryMaster>();
List<MasUnit> masUnitList = new ArrayList<MasUnit>();
List<MasMaritalStatus> masMaritalStatusList = new ArrayList<MasMaritalStatus>();
List<MasRank> masRankList1 = new ArrayList<MasRank>();
String entryno="";
String entryno1="";
if(map.get("medicalEntryNo")!=null)
{
	entryno = (String) map.get("medicalEntryNo");

}
if(map.get("medicalEntryNo1")!=null)
{
	entryno1 = (String) map.get("medicalEntryNo1");

}

if(map.get("mbTypeOfEntryMaster")!=null)
{
	typeOfEntryMasterList = (List) map.get("mbTypeOfEntryMaster");

}
if(map.get("masUnitList")!=null)
{
	masUnitList = (List) map.get("masUnitList");

}
if(map.get("masMaritalStatusList")!=null)
{
	masMaritalStatusList = (List) map.get("masMaritalStatusList");

}

List templateList= new ArrayList();
if(map.get("templateList") != null){
templateList=(List)map.get("templateList");
}
if(map.get("masRankList")!=null)
{
	masRankList1 = (List) map.get("masRankList");

}
List visitlist = new ArrayList();

if(map.get("visit") != null){
	visitlist=(List)map.get("visit");
	}
Visit visit=null;
if(visitlist!=null &&visitlist.size()>0)
{
 visit=(Visit)visitlist.get(0);
}

String url="";
if(map.get("url") != null){
	url = (String)map.get("url");
}

List<MasServiceType> serviceTypeList =null;
List<MasState> stateList = null;
List<MasMaritalStatus> maritalStatusList = null;
	if(map.get("serviceTypeList") != null){
		serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
	}
if(map.get("stateList") != null)	{
	stateList = (List<MasState>)map.get("stateList");
	}
if(map.get("maritalStatusList") != null){
		maritalStatusList = (List<MasMaritalStatus>)map.get("maritalStatusList");
}
List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
if(map.get("medExamList") != null){
	medExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("medExamList");
}
MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();

if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
}
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();	
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
}
Set<PatientInvestigationDetails> patientInvestigationdetails=null;
PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
if(map.get("patientInvestigationHeader")!=null){
	patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
	patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
}

Properties properties = new Properties();
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
DgOrderhd dgOrderhd=null;
Set<DgOrderdt> getDgOrderdts=null;
if(map.get("dgOrderhd")!=null){
	
	dgOrderhd=(DgOrderhd)map.get("dgOrderhd");
	getDgOrderdts=dgOrderhd.getDgOrderdts();
}
List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
if(map.get("resultList") != null){
	resultList=(List)map.get("resultList");
	}
%>
function checkTemplateId(templateId){
	
    if(templateId=="0"){
      return true;
    }else{
      return true;
    }
  }
</script>
<% 
String message="";
if (map.get("message") != null) {
       message = (String) map.get("message");
   }
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>

<!--main content placeholder starts here-->
<div class="clear"></div>
<body onLoad="coolDental()">
<form name="medBoardDetail" action="" method="post">



<h2>Chronological List of the Disabilities <a href="javascript:animatedcollapse.toggle('slide14')"></a></h2>
<div class="clear"></div>
<div id="slide14">

	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<th>Disability</TH>
		<TH>Date Of origin</TH>
		<TH>Rank of Indl</TH>
		<TH>Place</TH>
		<TH>Unit(Where serving at the time)</TH>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<% int inc14=0;

			inc14=inc14+1;
	%>

	<tr>
		<td>
			<input type="text"  name="<%=DISABILITY_ONE+inc14 %>" maxlength="10" tabindex="1" />
		</td>
		<td>
			<input tabindex="1"  type="text"	name="<%=DATE_OF_ORIGIN+inc14 %>" maxlength="10" />
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',medicalBoardForm16.<%=DATE_OF_ORIGIN+inc14%>,event);" />
		</td>
		<td>
			<input tabindex="1" readonly="readonly" type="text"	name="<%=RANK_OF_INDL+inc14 %>" maxlength="10" />
		</td>
		<td>
			<input tabindex="1" readonly="readonly" type="text"	name="<%=PLACE+inc14 %>" maxlength="10" />
		</td>
		<td>
			<input tabindex="1" readonly="readonly" type="text"	name="<%=UNIT+inc14 %>" maxlength="10" />
		</td>
		<td> 
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRowChronological();" tabindex="1" />
		</td>
		<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowChronological();" tabindex="1" />
		</td>
		<input type="hidden" name="hdb" value="<%=inc14%>" id="hdb" />
	</tr>
</table>
</div>
<div class="clear paddingTop15"></div>
<h4>Clinical detail <a href="javascript:animatedcollapse.toggle('slide15')"></a></h4>
<div class="clear"></div>
<div id="slide15">
	<div class="Block">

<label class="large">Personal and relevent family history</label>
<input type="text" name="<%=PERSONAL_AND_RELEVENT_FAMILY_HISTORY %>" tabindex="1" class="auto" size="100" maxlength="100"/>

<div class="clear"></div>

<label class="large">Specialist Report</label>
<input type="text" name="<%=SPECIALIST_REPORT %>" tabindex="1" class="auto" size="100" maxlength="100"/>

<div class="clear"></div>

<label class="large">Treatment</label>
<input type="text" name="<%=TREATMENT %>" tabindex="1" class="auto" size="100" maxlength="100"/>

<div class="clear"></div>

<label class="large">Present condition in details</label>
<input type="text" name="<%=PRESENT_CONDITION %>" tabindex="1" class="auto" size="100" maxlength="100" />
</div>
</div>
<div class="clear paddingTop15"></div>
<h4>Casual Relationship of the Disability with Service condition or otherwise <a href="javascript:animatedcollapse.toggle('slide16')"></a></h4>
<div class="clear"></div>
<div id="slide16">

<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<th>Disability</TH>
		<TH>Attributeable to Service(Y/N)</TH>
		<TH>Aggravated by Service (Y/N)</TH>
		<TH>Not connected with Service(Y/N)</TH>
		<TH>Reason/Cause/Specific Condition</TH>
		<TH>Period in service</TH>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<% int inc15=0;
			inc15=inc15+1;
	%>
	<tr>
		<td>
			<input type="text"  name="<%=DISABILITY_TWO+inc15 %>" maxlength="10" tabindex="1" />
		</td>

		<td>
			<input tabindex="1"  type="text"	name="<%=ATTRIBUTE_TO_SERVICE+inc15 %>" maxlength="10" />
		</td>
		<td>
			<input tabindex="1" readonly="readonly" type="text"	name="<%=AGGRAVATED_BY_SERVICE+inc15 %>" maxlength="10" />
		</td>
		<td>
			<input tabindex="1" readonly="readonly" type="text"	name="<%=NOT_CONNECTED_WITH_SERVICE+inc15 %>" maxlength="10" />
		</td>
		<td>
			<input tabindex="1" readonly="readonly" type="text"	name="<%=REASON_CAUSE_SPECIFIC_CONDITION+inc15 %>" maxlength="10" />
		</td>
		<td>
			<input tabindex="1" readonly="readonly" type="text"	name="<%=PERIOD_IN_SERVICE+inc15 %>" maxlength="10" />
		</td>
		<td>
			 <input name="Button" type="button" class="buttonAdd" value="" onclick="addRowCasualRelationship();" tabindex="1" />
		</td>
		<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowCasualRelationship();" tabindex="1" />
		</td>
		<input type="hidden" name="hdb" value="<%=inc15%>" id="hdb" />
	</tr>
</table>

<div class="clear paddingTop15"></div>

<div class="Block">
<label class="large">Disability existed before service</label>
<select class="smaller" name="<%=DIABEILITY_EXISTED_BEFORE_SERVICE %>" id="<%=DIABEILITY_EXISTED_BEFORE_SERVICE %>" onchange="showHideDisabilityExistedBeforeService();">
<option value="">select</option>
<option  value="y">Yes</option>
<option  value="n">No</option>
<option  value="CouldBe">Could Be</option>
</select>
<div id="disabilityExistedBeforeServiceDiv" style="display: none" >
<div class="clear"></div>
<label class="auto">Is it possible that it could not be detected during the routine medical examination carried out at the time of the entry?</label>
<input type="text" name="" tabindex="1"  size="128"  class="auto" maxlength="100"/>
</div>
<div class="clear"></div>
<label class="large">Effects of aggravation Persists</label>
<select name="<%=EFFECTS_OF_AGGRAVATION_PERSISTS %>"  id="<%=EFFECTS_OF_AGGRAVATION_PERSISTS %>" onchange="showHideEffectsOfAggravationPersists()"; class="smaller" >
<option value="">select</option>
<option  value="y">Yes</option>
<option  value="n">No</option>
</select> 
<div id="effectsOfAggravationPersistsDiv" style="display: none" >
<div class="clear"></div>
<label class="large">Will effect persist for a matcrial period </label>
<select name="<%=WILL_EFFECT_PERSIST_FOR_MATCRIAL_PERIOD %>" class="smaller" id="<%=WILL_EFFECT_PERSIST_FOR_MATCRIAL_PERIOD %>" onchange="showHideWillEffectPersistForMatcrialPeriod();">
<option value="">select</option>
<option  value="y">Yes</option>
<option  value="n">No</option>
</select>
</div>
<div id="willEffectPersistForMatcrialPeriodDiv" style="display: none" >
<div class="clear"></div>
<label class="large">Remarks</label>
<textarea rows="" cols="58"  class="auto" name="<%=REMARKS %>" id="<%=REMARKS %>"> </textarea>
</div>
<div class="clear"></div>
<label class="large">Disability attribute due to individuals own negligence </label>
<select name="<%=DISABILITY_ATTRIBUTE_DUE_TO_INDIVIDUALS_OWN_NEGLIGENCE %>" id="<%=DISABILITY_ATTRIBUTE_DUE_TO_INDIVIDUALS_OWN_NEGLIGENCE %>" onchange="showHideDisabilityAttributeDueToIndividualsOwnNegligence();"; class="smaller">
<option value="">select</option>
<option  value="y">Yes</option>
<option  value="n">No</option>
</select>
<div id="disabilityAttributeDueToIndividualsOwnNegligenceDiv" style="display: none" >
<div class="clear"></div>
<label class="large">How</label>
<textarea rows="" cols="58"  class="auto" name="<%=HOW %>"> </textarea>
</div>
<div class="clear"></div>
<label class="large">Aggarvated by negligence</label>
<select name="<%=AGGARAVATED_BY_NEGLIGENCE %>" id="<%=AGGARAVATED_BY_NEGLIGENCE %>"  class="smaller" onchange="showHideAggarvatedByNegligence();">
<option value="">select</option>
<option  value="y">Yes</option>
<option  value="n">No</option>
</select>
<div id="aggarvatedByNegligenceDiv" style="display: none" >
<div class="clear"></div>
<label class="large">How</label>
<textarea rows="" cols="58"  class="auto" name="<%=HOW_AGGARAVATED_BY_NEGLIGENCE %>"> </textarea>
<div class="clear"></div>
 <label class="large">Percentage of the total disablement</label>
<textarea rows="" cols="58"  class="auto" name="<%=PERCENTAGE_OF_TOTAL_DISABLEMENT %>"> </textarea>
</div>
<div class="clear"></div>

<label class="large">Individual Refused for operation/treatment</label>
<select name="<%=INDIVIDUAL_REFUSED_OF_OPERATION_TREATMENT %>"  id="<%=INDIVIDUAL_REFUSED_OF_OPERATION_TREATMENT %>" onchange="showHideIndividualRefusedForOperationTreatment();" class="smaller">
<option value="">select</option>
<option  value="y">Yes</option>
<option  value="n">No</option>
</select>
<div id="individualRefusedForOperationTreatmentDiv" style="display: none" >
<div class="clear"></div>
<label class="large">Reason</label>
<textarea rows="" cols="58"  class="auto" name="<%=REASON %>"> </textarea>
</div>

<div class="clear"></div>

<label class="auto">Has the effect of refusal been explained to and fully understood by him/her.Viz, a reduction in or ther entire withholding of any disability pension to which he/she might otherwise might be entitled?</label>
<input type="text" name="" tabindex="1" class="auto" size="128" maxlength="100"/>

<div class="clear"></div>
<label class="auto">Does the Medical Board consider it proable that the operation/Treatment would have cured the disability or reduced by operation/Treatment</label>
<input type="text" name="" tabindex="1" class="auto" size="128" maxlength="100"/>

<div class="clear"></div>
<label class="auto">The Probable percentage to which the disabment could be reduced by operation/treatment?</label>
<input type="text" name="" tabindex="1" class="auto" size="128" maxlength="100"/>

<div class="clear"></div>
<label class="auto">Does the Medical Board consider individual's refused to submit to operation/treatment reasonable?Give reason in support of the opinion specifying the operation/treatment recommented</label>
<input type="text" name="" tabindex="1" class="auto" size="128" maxlength="100"/>
</div>
</div>
<div class="clear paddingTop15"></div>

<h4>Present degree of disablement as compared with healty person of the same age and sex <a href="javascript:animatedcollapse.toggle('slide17')"></a></h4>
<div class="clear"></div>
<div id="slide17">

	
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid" class="cmnTable">
	<tr>
		<th>Disability</TH>
		<TH>Percentage of disablement</TH>
		<TH>Duration</TH>
		<TH>Composite assessment for all disability</TH>
		<TH>Duration</TH>
		<TH>Disability qualifying for disability pension</TH>
		<th>Duration</th>
		<th>Net Assessement qualifying for Disability Pension</th>
		<th>Duration</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
<% int inc16=0;
			inc16=inc16+1;
%>
	<tr>
		<td>
			<input type="text"  name="<%=DISABILITY_THREE+inc16 %>" size="10" maxlength="10" tabindex="1" />
		</td>
		<td>
			<input tabindex="1"  type="text" name="<%=PERCENTAGE_OF_DISABLEMENT+inc16 %>" 	size="10" name="" maxlength="10" />
		</td>
		<td>
			<input tabindex="1" readonly="readonly" size="4" type="text"	name="<%=DURATION_ONE+inc16 %>"  maxlength="10" />
		</td>
		<td>
			<input tabindex="1" readonly="readonly"  type="text" name="<%=COMPOSITE_ASSESSMENT_FOR_ALL_DISABILITY+inc16 %>" maxlength="10" />
		</td>
		<td>
			<input tabindex="1" readonly="readonly" name="<%=DURATION_TWO+inc16 %>" size="4" type="text" maxlength="10" />
		</td>
		<td>
			<input tabindex="1" readonly="readonly" type="text" name="<%=DISABILITY_QUALIFYING_FOR_DISABILITY_PENSION+inc16 %>" maxlength="10" />
		</td>
		<td>
			<input tabindex="1" readonly="readonly" size="4" type="text" name="<%=DURATION_THREE+inc16 %>" maxlength="10" />
		</td>
		<td>
			<input tabindex="1" readonly="readonly" type="text"  name="<%=NET_ASSESSEMENT_QUALIFYING_FOR_DISABILITY_PENSION+inc16 %>" maxlength="10" />
		</td>
		<td>
			<input tabindex="1" readonly="readonly" size="4" type="text" name="<%=DURATION_FOUR+inc16 %>" maxlength="10" />
		</td>
		<td> 
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRowCasualRelationship();" tabindex="1" />
		</td>
		<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowCasualRelationship();" tabindex="1" />
		</td>
		<input type="hidden" name="hdb" value="<%=inc16%>" id="hdb" />
	</tr>
</table>

<div class="clear paddingTop15"></div>

<div class="Block">
<label class="large">Further Treatment Required</label>
<select name="<%=FURTHER_TREATMENT_REQUIRE %>" id="<%=FURTHER_TREATMENT_REQUIRE %>" onchange="showHideFurtherTreatmentRequire();">
<option value="">select</option>
<option  value="y">Yes</option>
<option  value="n">No</option>
</select>
<div id="furtherTreatmentRequireDiv" style="display: none" >
<label >NATURE</label>
<input type="text"  name="<%=NATURE%>" class="auto" maxlength="10" tabindex="1" />
<div class="clear"></div>
<input class="transparent" size="96">
<label >DURATION</label>
<input type="text"  name="<%=YEAR_ONE%>" size="2" class="auto" maxlength="10" tabindex="1" /><label class="unit">yrs</label>
<input type="text"  name="<%=MONTH_ONE %>"  size="4" class="auto" maxlength="10" tabindex="1" /><label class="unit">month</label>
<input type="text"  name="<%=DAY_ONE %>" size="2" class="auto" maxlength="10" tabindex="1" /><label class="unit">Days</label>
</div>
<div class="clear"></div>
<div class="clear"></div>

<label class="large">Attendant Required</label>
<select name="<%=ATTENDANT_REQUIRED %>"  id="<%=ATTENDANT_REQUIRED %>" onchange="showHideAttendantRequired();">
<option value="">select</option>
<option  value="y">Yes</option>
<option  value="n">No</option>
</select>
<div id="attendantRequiredDiv" style="display: none" >
<label >DURATION</label>
<input type="text"  name="<%=YEAR_TWO%>" size="2" class="auto" maxlength="10" tabindex="1" /><label class="unit">yrs</label>
<input type="text" name="<%=MONTH_TWO %>"  size="4" class="auto" maxlength="10" tabindex="1" /><label class="unit">month</label>
<input type="text" name="<%=DAY_TWO %>" size="2" class="auto" maxlength="10" tabindex="1" /><label class="unit">Days</label>
</div>
<div class="clear"></div>

<label class="large">Invalidment/Release in Medical Category</label>
<input type="text"  name="<%=INVALIDMENT_RELEASE_IN_MEDICAL_CATEGORY %>" maxlength="10" size="80" tabindex="1" />

<div class="clear"></div>

<label class="large">Opinion of Medical Board</label>
<textarea rows="" cols="" name="<%=OPINION_OF_MEDICAL_BOARD %>"></textarea>

<div class="clear"></div>

<label>Member</label>
<input type="text"  name="<%=MEMBER_ONE%>" maxlength="10" tabindex="1" />

<label>Member</label>
<input type="text"  name="<%=MEMBER_TWO%>" maxlength="10" tabindex="1" />

<label>President</label>
<input type="text"  name="<%=PRESIDENT %>" maxlength="10" tabindex="1" />

<div class="clear"></div>
<div class="clear"></div>

</div>
</div>
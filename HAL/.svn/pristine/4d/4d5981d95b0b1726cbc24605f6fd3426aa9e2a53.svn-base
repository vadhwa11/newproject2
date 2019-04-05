<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.Disability"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.Disabilitygroup"%>
<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>


<%@page import="jkt.hms.masters.business.MasTrade"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
var disabilityListArray=new Array();
var masIcdListArray=new Array();
var disabilitygroupListArray=new Array();
</script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>

<!-- -<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
 -->
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
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
		//String time = (String) utilMap.get("currentTime");
		String time = (String) utilMap.get("currentTimeWithoutSc");

	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';

	</script>
<script type="text/javascript">

<%
String Labresult="NotPresent";
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
//List<MbTypeOfEntryMaster> typeOfEntryMasterList = new ArrayList<MbTypeOfEntryMaster>();
//List<MasUnit> masUnitList = new ArrayList<MasUnit>();
//List<MasMaritalStatus> masMaritalStatusList = new ArrayList<MasMaritalStatus>();
//List<MasRank> masRankList1 = new ArrayList<MasRank>();
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
/*
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
if(map.get("masRankList")!=null)
{
	masRankList1 = (List) map.get("masRankList");

}
*/
List templateList= new ArrayList();
if(map.get("templateList") != null){
templateList=(List)map.get("templateList");
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
String jspheading=null;
if(map.get("jspheading") != null){
	jspheading = (String)map.get("jspheading");
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
Properties properties = new Properties();
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
Set<PatientInvestigationDetails> patientInvestigationdetails=null;
PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
if(map.get("patientInvestigationHeader")!=null){

	patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
	patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
}

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
List<MasIcd> masIcdList = new ArrayList<MasIcd>();
if(map.get("masIcdList") != null){
	masIcdList=(List)map.get("masIcdList");

	}
List<Disabilitygroup> disabilitygroupList = new ArrayList<Disabilitygroup>();
if(map.get("disabilitygroupList") != null){
	disabilitygroupList=(List)map.get("disabilitygroupList");

	}


List<OpdPatientDetails> opdDentalDetailsList = new ArrayList<OpdPatientDetails>();
if(map.get("opdDentalDetailsList") != null){
	opdDentalDetailsList=(List<OpdPatientDetails>)map.get("opdDentalDetailsList");
}
OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
if(opdDentalDetailsList.size() > 0){
	opdPatientDetails = opdDentalDetailsList.get(0);
}
List<MasTrade> tradeList = null;
if(map.get("tradeList") != null){
	tradeList = (List<MasTrade>)map.get("tradeList");
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
int token=0;
if(visit.getTokenNo()!=null){
	token=visit.getTokenNo();
}
if(!message.equalsIgnoreCase("")){
	
%>
<h4><%=message %></h4>
<%} %>

<div class="clear"></div>
<!--main content placeholder starts here-->
<div class="titleBg">
<h2>AFMSF-10</h2>
</div>
<div class="clear"></div>
<form name="MedicalBoardForm10" action="" method="post">
<!--Block One Starts-->
<%
int medExamId = 0;
if(medExamObj.getId()!= null){
	medExamId = medExamObj.getId();
}
%>


<div class="clear paddingTop15"></div>

<div class="Block">
<label>Name  </label>

  <input type="text" value="<%= visit.getHin().getSFirstName()+" "+(visit.getHin().getSMiddleName()!=null?visit.getHin().getSMiddleName():"")+" "+(visit.getHin().getSLastName()!=null?visit.getHin().getSLastName():"") %>" readonly="readonly" name="<%=FULL_NAME%>"	tabindex="2" maxlength="20"/>
<input type="hidden" name="medExamId" value="<%=medExamId %>"/>
<label>Service No. </label>
<% if(visit.getMedExamType()!=null){%>
 <input type="hidden"	value="<%= visit.getMedExamType() %>" name="medicalExamType" tabindex="2" />

<% }else{%>

 <input type="hidden"	value="Initial Medical Board AFMSF 10" name="medicalExamType" tabindex="2" />
<% }%>
 <input type="text"	 name="<%=SERVICE_NO %>" readonly="readonly" tabindex="2" value="<%=visit.getHin().getServiceNo()%>"/>
 <label>Rank  </label>
   <input type="text" value="<%= visit.getHin().getRank().getRankName() %>" readonly="readonly" name="<%=RANK%>"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="2" maxlength="20" />


 <div class="clear"></div>
  <label>Unit </label>
 <% if(visit.getHin().getUnit()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>" tabindex="2" value="<%=visit.getHin().getUnit().getUnitName() %>"/>
 <input type="hidden" value="<%=visit.getHin().getUnit().getId() %>" name="<%=UNIT_ID%>"	tabindex="2" />
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>" tabindex="2" />
 <% }%>
 <label>Service</label>
 <input	type="text" value="<%=  visit.getHin().getServiceType().getServiceTypeName() %>" readonly="readonly" name="serviceiaf"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID%>"	tabindex="2" maxlength="20" />
 <label>Branch/Trade  </label>
<% if(visit.getHin().getTrade()!=null){%>
 <input	type="text"  name="<%=TRADE%>"	readonly="readonly" tabindex="2" value="<%= visit.getHin().getTrade().getTradeName() %>" maxlength="20" />
  <input	type="hidden"  name="<%=TRADE_ID%>"	tabindex="2" value="<%= visit.getHin().getTrade().getId() %>" maxlength="20" />

<% }else{%>
 <input	type="text"  name="<%=TRADE%>"	tabindex="2" />

 <% }%>
 <div class="clear"></div>

 <%
 if(visit.getHin().getDateOfBirth()!=null && !(visit.getHin().getDateOfBirth().equals(""))){%>
  <input type="hidden"	tabindex="1" name="<%=DATE_OF_BIRTH %>"  class="date" value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>" />

<%}%>


  <%if(visit.getHin().getCommissionDate()!=null)
 { %>
 <input type="hidden"	tabindex="1" name="<%=DATE_COMMENCEMENT %>" class="date"  value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getCommissionDate()) %>"	 />
 <% }%>

 <label>Age  </label>
  <% if(visit.getHin().getAge()!=null){%>
<input	type="text" readonly="readonly" maxlength="20"  value="<%=visit.getHin().getAge() %>" name="apparentAge"	tabindex="2" />

 <% }else{%>
<input	type="text" readonly="readonly" maxlength="20"  value="" name="typeOfCommunication"	tabindex="2" />

 <% }%>
  <%if(visit.getAge()!= null){ %>
<input type="hidden" name="ageId" id="ageId" value="<%=visit.getAge() %>">
<%} %>



<label>Total Service  </label>
  <%if(visit.getHin().getServiceYears()!=null)
 { %>
 <input	type="text" readonly="readonly" value="<%= visit.getHin().getServiceYears() %>" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" />
 <% }else{%>
 <input	type="text" value="" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" readonly="readonly"/>
 <% }%>
 

<label>Field  </label>
<select	name="<%=FIELDS %>"	validate="Field,string,no" tabindex=1>
	<option value="">Select</option>
	<option value="Field">Field</option>
	<option value="High Altitude">High Altitude</option>
 <option value="Sea">Sea</option>
 </select>
 
 <div class="clear"></div>
<label>Disciplinary Record/Entries</label>
  <textarea tabindex="1" name="<%=DISCIPLINE_REMARKS %>" onkeyup="chkLength(this,100);"></textarea>

<label>Administrative Profile</label>
 
<select	name="administrative_profile_a"	validate="Administrative Profile,string,no" tabindex=1>
	<option value="">Select</option>
	<option value="Punctual">Punctual</option>
	<option value="Unpunctual">Unpunctual</option>
 </select>
 
 <select	name="administrative_profile_b"	validate="Administrative Profile,string,no" tabindex=1 class="smaller">
	<option value="">Select</option>
	<option value="Disciplined">Disciplined</option>
	<option value="Indisciplined">Indisciplined</option>
</select>
 
 <select	name="administrative_profile_c"	validate="Administrative Profile,string,no" tabindex=1 class="smaller">
	<option value="">Select</option>
	<option value="Dedicated">Dedicated</option>
	<option value="Casual">Casual</option>
 </select>
 
 <div class="clear"></div>
<label>Alcohol /Drug Profile</label>
 <select name="<%=COVER_TEST %>" id="<%=COVER_TEST %>" tabindex="1" onclick="displayDrinker(this.value);">
	<option value="">Select</option>
<%
String alcohal="";
	if(visit.getHin()!=null){
		if(visit.getHin().getAlcohol()!=null){
			alcohal=visit.getHin().getAlcohol();
		}
	}else if(medExamObj.getHin()!=null){
		if(medExamObj.getHin()!=null){
			alcohal=medExamObj.getHin().getAlcohol();
		}
}
if(alcohal.equalsIgnoreCase("Non-drinker")){ %>
	<option value="Non-drinker" selected="selected">Non-drinker</option>
	<option value="Drinker">Drinker</option>
	<%}else if(alcohal.equalsIgnoreCase("Drinker")){ %>
	<option value="Non-drinker">Non-drinker</option>
		<option value="Drinker" selected="selected">Drinker</option>
<%} else{ %>
<option value="Drinker">Drinker</option>
<option value="Non-drinker">Non-drinker</option>
	<%} %>
</select> <script>
<%
if(medExamObj.getCoverTest()!= null){
%>
document.getElementById("<%=COVER_TEST %>").value='<%=medExamObj.getCoverTest()%>';

<%}%>
</script>
<div id="followUpDiv" style="display: none;">
<label>Drinker </label> 
<select name="drinker" id="drinker" tabindex="1" >
<option value="">Select</option>
<option value="Social">Social</option>
<option value="Frequent">Frequent</option>
<option value="Regular">Regular</option>
<option value="Heavy">Heavy</option>
<option value="Uncontroller">Uncontroller</option>
</select>
</div>


 <label>Alcohol/Drug Related</label>
 <select	name="alcohol_drug_related"	validate="Alcohol/Drug Related,string,no" tabindex=1>
	<option value="">Select</option>
	<option value="Misbehaviour">Misbehaviour</option>
	<option value="Absenteeism">Absenteeism</option>
	<option value="Sick Report">Sick Report</option>
	
 </select>
</div>


<div class="clear paddingp15"></div>
<h4>Nature Of duties <a href="javascript:animatedcollapse.toggle('slide1')"></a></h4>
<div class="clear"></div>
<div id="slide1">
<div class="Block">

<label > Trade/Branch</label>
<% 
if(visit.getHin().getTrade()!=null){
%>
<select id="tradeNature" name="tradeNature"  validate="Trade,string,no" tabindex="1"  >

			<option value="0">Select</option>
			<%
			
			if(tradeList.size()>0){
				
				for (MasTrade trade : tradeList) {
			
				 if(visit.getHin().getTrade().getId()==trade.getId()){
				%>
		<option value=<%=trade.getId()%> selected="selected"><%=trade.getTradeName() %></option>
		
	<%}else{ %>
			<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%}}}%>
</select>
<%}else{ %>
<select id="tradeNature" name="tradeNature"  validate="Trade,string,no" tabindex="1"  >
		<option value="0">Select</option>
			<%
			
			if(tradeList.size()>0){
				
				for (MasTrade trade : tradeList) {
			
				%>
	
			<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%}}%>
</select>
<%} %>
 <label>Regimental  </label>
  <input	type="text"  name="regimental"	tabindex="2" maxlength="50"/>
 
 <label>Others  </label>
<textarea tabindex="1" name="others" onkeyup="chkLength(this,100);"></textarea>

<div class="clear"></div>

<label>Total Flying Hours</label> 
 <!-- Code By Mukesh 16 March 2012 -->
 <%if(medExamObj.getHoursOfFlown()!=null)
 { %>
 <input	type="text" readonly="readonly" value="<%=medExamObj.getHoursOfFlown() %>" name="<%=HOURS_OF_FLOWN%>"	maxlength="100" tabindex="1" onKeyUp="mask(this.value,this,'2',':');" onBlur="checkTime('medicalBoardMOForm16','<%=HOURS_OF_FLOWN%>');"/>
 <% }else{%>
 <input	type="text" value="" name="<%=HOURS_OF_FLOWN%>"	maxlength="5" tabindex="1" onKeyUp="mask(this.value,this,'2',':');" onBlur="checkTime('MedicalBoardForm10','<%=HOURS_OF_FLOWN%>');"/>
 <% }%>
 
 <label>Operational  </label>
<textarea tabindex="1" name="operational" onkeyup="chkLength(this,100);"></textarea>




</div>
</div>


<div class="clear paddingp15"></div>
<h4>Competence and response to training <a href="javascript:animatedcollapse.toggle('slide2')"></a></h4>
<div class="clear"></div>
<div id="slide2">
<div class="Block">

 <label>Professional</label>
 <select	name="professional"	validate="Professional,string,no" tabindex=1>
	<option value="">Select</option>
	<option value="Above Average">Above Average</option>
	<option value="Average">Average</option>
	<option value="Below Average">Below Average </option>
	
 </select>
 
 <label>Regimental/ Others</label>
 <select	name="regimentalOthers"	validate="Regimental/ Others,string,no" tabindex=1>
	<option value="">Select</option>
	<option value="Good">Good</option>
	<option value="Satifactory">Satifactory</option>
	<option value="Unsatifactory">Unsatifactory</option>
	
 </select>
<div class="clear"></div>
 <label>Motivation</label>
 <select	name="motivation"	validate="Motivation,string,no" tabindex=1>
	<option value="">Select</option>
	<option value="Above Average">Above Average</option>
	<option value="Average">Average</option>
	<option value="Below Average">Below Average </option>
	
 </select>


 <label>Performation Under Stress</label>
 <select	name="performationUnderStress"	validate="Performation Under Stress,string,no" tabindex=1>
		<option value="">Select</option>
	<option value="Good">Good</option>
	<option value="Satifactory">Satifactory</option>
	<option value="Unsatifactory">Unsatifactory</option>
	
 </select>


</div>
</div>

<div class="clear paddingp15"></div>
<h4>Psychoscial Profile <a href="javascript:animatedcollapse.toggle('slide3')"></a></h4>
<div class="clear"></div>
<div id="slide3">
<div class="Block">

 <label>General Outlook</label>
 <select	name="generalOutlook"	validate="General Outlook,string,no" tabindex=1>
		<option value="">Select</option>
	<option value="Cheerful">Cheerful</option>
	<option value="Average">Average</option>
	<option value="Gloomy">Gloomy</option>
	
 </select>
 
  <label>Soical Interaction</label>
 <select	name="soicalInteraction"	validate="Soical Interaction,string,no" tabindex=1>
		<option value="">Select</option>
	<option value="Active and Outgoing">Active & Outgoing</option>
	<option value="Average">Average</option>
	<option value="Reclusive">Reclusive</option>
	
	
 </select>
 
  <label>Abnormal Trails</label>
 <select	name="abnormalTrails"	validate="Abnormal Trails,string,no"  tabindex="1" multiple="multiple" class="list" >
 <option value="">Select</option>
 <option value="Impulsive">Impulsive</option>
  <option value="Excitable tends to overreact">Excitable tends to overreact</option>
   <option value="Suspicious">Suspicious</option>
   <option value="Accusative">Accusative</option>
    <option value="Hostile towards authority">Hostile towards authority</option>
</select>


</div>
</div>
<div class="clear paddingp15"></div>
<h4>Behaviour <a href="javascript:animatedcollapse.toggle('slide4')"></a></h4>
<div class="clear"></div>
<div id="slide4">
<div class="Block">
  <label>Prior to the onset of present Illness/problem</label>
 <select	name="prior"	validate="Prior to ther onset of present Illness/problem,string,no"  tabindex="1"  onclick="displayPrior(this.value);">
 <option value="">Select</option>
 <option value="Normal">Normal</option>
  <option value="Abnormal">Abnormal</option>
</select>
<div id="priorAbnormalDiv" style="display: none;">
<label class="auto">Specify</label>
<textarea tabindex="1" name="priorAbnormalSpecify" onkeyup="chkLength(this,100);"></textarea>
</div>
<div class="clear"></div>

  <label>Since the onset of Present Illness/problem</label>
 <select	name="since"	validate="Since the onset of Present Illness/problem,string,no"  tabindex="1"  onclick="displaySince(this.value);">
 <option value="">Select</option>
 <option value="Normal">Normal</option>
  <option value="Abnormal">Abnormal</option>
</select>
<div id="sinceAbnormalDiv" style="display: none;">
<label class="auto">Specify</label>
<textarea tabindex="1" name="sinceAbnormalSpecify" onkeyup="chkLength(this,100);"></textarea>
</div>
<div class="clear"></div>
 <label>Since last psychiatric Hospitalisation/treatment</label>
 <select	name="sinceLastPsychiatric"	validate="Since last psychiatric Hospitalisation/treatment(where applicable),string,no"  tabindex="1" onclick="displaySinceLastPsychiatric(this.value);">
 <option value="">Select</option>
 <option value="Improved to pre illness level">Improved to pre-illness level</option>
  <option value="Partially improved">Partially improved</option>
  <option value="Not Improved Worse">Not improved worse</option>
</select>
<div id="sinceLastPsychiatricAbnormalDiv" style="display: none;">
<label class="auto">Specify</label>
<textarea tabindex="1" name="sinceLastPsychiatricAbnormalSpecify" onkeyup="chkLength(this,100);"></textarea>
</div>

</div>
</div>


<div class="clear paddingp15"></div>
<h4>Follow-up data in respect of treated / low medical category cases<a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div class="clear"></div>
<div id="slide5">
<div class="Block">

 <label>Compliance with treatment</label>
 <select	name="complianceWithTreatment"	validate="Compliance with treatment,string,no" tabindex=1>
		<option value="">Select</option>
	
	<option value="Satifactory">Satifactory</option>
	<option value="Unsatifactory">Unsatifactory</option>
	
 </select>


 <label>Alocohol Status</label>
 <select	name="alocoholStatus"	validate="Alocohol Status,string,no" tabindex=1>
		<option value="">Select</option>
	
	<option value="Absitnent">Absitnent</option>
	<option value="Partly Absitnent">Partly Absitnent</option>
	<option value="Not Abstinent or Worse">Not Abstinent or Worse</option>
	
 </select>
 
  <label>Vocational performance</label>
 <select	name="vocationalPerformance"	validate="Vocational performance,string,no" tabindex=1>
		<option value="">Select</option>
	
	<option value="Satifactory">Satifactory</option>
	<option value="Equivocal">Equivocal</option>
	<option value="Unsatifactory">Unsatifactory</option>
	
 </select>

</div>
</div>

<div class="clear paddingp15"></div>
<h4>Personal administartive data <a href="javascript:animatedcollapse.toggle('slide6')"></a></h4>
<div class="clear"></div>
<div id="slide6">
<div class="Block">

<label>Date of Posting In</label>
<input type="radio"  name="dateOfPosting"  id="dateOfPostIn" value="i" class="radioAuto" tabindex="1" onclick="displayDateOfPost();"/>

<div id="dateOfPostingInDiv" style="display: none;">
<input type="text"	id="dateOfPostingIn" name="dateOfPostingIn" tabindex="1" value=""	validate="Date of Posting In,date,no" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');"	class="calDate"  readonly="readonly"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.MedicalBoardForm10.dateOfPostingIn,event)" /> 

</div>

<div class="clear"></div>

<label>Date of Posting Out</label>
<input type="radio" id="dateOfPostOut" name="dateOfPosting" tabindex="1" value="o" class="radioAuto" onclick="displayDateOfPost();"/>


<div id="dateOfPostingOutDiv" style="display: none;">
<input type="text"	id="dateOfPostingOut" name="dateOfPostingOut" tabindex="1" value=""	validate="Date of Posting Out,date,no" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');"	class="calDate"  readonly="readonly"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.MedicalBoardForm10.dateOfPostingOut,event)" /> 

<label class="auto">Specify</label>
<textarea tabindex="1" name="dateOfPostingOutSpecify" id="dateOfPostingOutSpecify" onkeyup="chkLength(this,50);"></textarea>
</div>

<div class="clear"></div>

<label>Date of leave</label>
<input type="text" class="transparent" size="1">
<input type="text"	id="dateOfLeave" name="dateOfLeave" tabindex="1" value=""	validate="Date of leave,date,no" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');"	class="calDate" readonly="readonly"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.MedicalBoardForm10.dateOfLeave,event)" /> 

<div class="clear"></div>
<label class="large">Pending Disciplinary cases(if any)</label>
<textarea tabindex="1" name="pendingDisciplinaryCases" onkeyup="chkLength(this,100);"></textarea>

<div class="clear"></div>
<label class="large">Details of Previous Medical History  </label>
<%if(medExamObj.getPastmedicalhistory()!=null)
 { %>
 <textarea tabindex="1" name="<%=PAST_MEDICAL_HISTORY %>" onkeyup="chkLength(this,100);"><%=medExamObj.getPastmedicalhistory() %></textarea>
 <% }else{%>
   <textarea tabindex="1" name="<%=PAST_MEDICAL_HISTORY %>" onkeyup="chkLength(this,100);"></textarea>
 <% }%>


</div>
</div>

<div class="clear paddingTop15"></div>
<a href="javascript:animatedcollapse.toggle('slide7')"></a>
<div class="clear"></div>
<div id="slide7">
<div class="Block">
<label class="large">Any other relevant information (including unusual physical or mental stressors, domestic problems etc.)</label>
<textarea tabindex="1" name="anyOtherRelevantInformation" onkeyup="chkLength(this,200);"></textarea>

</div>
</div>
<div class="clear paddingTop15"></div>
<div class="division"></div>

<input type="button" onclick="submitdata()" value="Submit" class="buttonBig" name="Button" tabindex="1">
<input tabindex="1" class="buttonBig" id=reset accessKey=r	onclick="resetCheck();" type=reset value=Reset name=Reset>
<input name="visitNumberForReport" type="hidden" value="<%=visit.getVisitNo()%>" />

<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="clear"></div>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<INPUT	type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>">
<INPUT type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>">
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>">
<input type="hidden" value="MedicalBoard" name="medicalType" id="hiddenValue" />
</div>
<%if(visit.getDoctor() != null){ %>
<input name="empId" type="hidden" value="<%=visit.getDoctor().getId()%>" />
<%}%>
<%if(visit.getDepartment() != null){
%>
<input name="deptId" type="hidden" value="<%=visit.getDepartment().getId()%>" />
<%}%>
<%if(visit.getHin() != null){
	%>
<input name="hinId" type="hidden" value="<%=visit.getHin().getId()%>" />
<%}%>
<%if(visit.getHin() != null){
	%>
<input name="visitId" type="hidden" value="<%=visit.getId()%>" />
<%}%>


<!--Bottom labels starts--> <!--main content placeholder ends here--> 
<script	type="text/javascript">


function displayDrinker(obj){
	if(obj=='Drinker'){
		document.getElementById('followUpDiv').style.display='inline';
	}else if(!obj.checked){
		document.getElementById('followUpDiv').style.display='none';
	}
	
}

function displayDateOfPost(){
   	var dateOfPIn=document.getElementById('dateOfPostIn');
   	var dateOfPOut=document.getElementById('dateOfPostOut');
	
	if(document.getElementById('dateOfPostIn').checked==true){
		document.getElementById('dateOfPostingInDiv').style.display='inline';
		document.getElementById('dateOfPostingOut').value="";
		document.getElementById('dateOfPostingOutSpecify').value="";
	}else if(document.getElementById('dateOfPostIn').checked==false){
	document.getElementById('dateOfPostingInDiv').style.display='none';
	document.getElementById('dateOfPostingOut').value="";
	document.getElementById('dateOfPostingOutSpecify').value="";
	}

	if(document.getElementById('dateOfPostOut').checked==true){
		document.getElementById('dateOfPostingOutDiv').style.display='inline';
		document.getElementById('dateOfPostingIn').value="";
	}
	else if(document.getElementById('dateOfPostOut').checked==false){
	document.getElementById('dateOfPostingOutDiv').style.display='none';
	document.getElementById('dateOfPostingIn').value="";
	
	}
	
}


function displayPrior(obj){
	if(obj=='Abnormal'){
		document.getElementById('priorAbnormalDiv').style.display='inline';
	}else if(!obj.checked){
		document.getElementById('priorAbnormalDiv').style.display='none';
	}
	
}

function displaySince(obj){
	if(obj=='Abnormal'){
		document.getElementById('sinceAbnormalDiv').style.display='inline';
		
	}else if(!obj.checked){
		document.getElementById('sinceAbnormalDiv').style.display='none';
	}
	
}

function displaySinceLastPsychiatric(obj){
	if(obj=='Not Improved Worse'){
		document.getElementById('sinceLastPsychiatricAbnormalDiv').style.display='inline';
	}else if(!obj.checked){
		document.getElementById('sinceLastPsychiatricAbnormalDiv').style.display='none';
	}
	
}

function submitdata()
{
	
    	submitForm('MedicalBoardForm10','medicalBoard?method=addMedicalBoardForm10');
   
}


</script>
</form>


<script type="text/javascript">
checkForInvestReferToMH();
</script>

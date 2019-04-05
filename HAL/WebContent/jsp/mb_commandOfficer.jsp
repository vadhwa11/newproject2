<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.Category"%><link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calendar.js" type="text/javascript"></script>
<script type="text/javascript">

animatedcollapse.addDiv('jason', 'fade=1,height=80px')
animatedcollapse.addDiv('kelly', 'fade=1,height=100px')
animatedcollapse.addDiv('michael', 'fade=1,height=120px')

animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')


animatedcollapse.init()
</script>
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
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		List<MasMedicalExaminationDetail> masMedicalExamDetailList=new ArrayList<MasMedicalExaminationDetail>();
		MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();
		if(map.get("masMedicalExaminationReportOnEntry")!=null)
		{
			medExamObj = (MasMedicalExaminationReportOnEntry) map.get("masMedicalExaminationReportOnEntry");
		}
		if(map.get("masMedicalExamDetailList")!=null)
		{
			masMedicalExamDetailList = (List<MasMedicalExaminationDetail>) map.get("masMedicalExamDetailList");

		}
		List<Category> categoryList = new ArrayList<Category>();
		if(map.get("categoryList")!=null)
		{
			categoryList = (List<Category>) map.get("categoryList");

		}
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';

	</script>
<div class="titleBg"><h2>COMMAND OFFICER</h2></div>

<div class="clear"></div>

<body onLoad="coolDental()">

<form name="commandOfficer" method="post">

<div class="clear paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<%
String  individualDate="";
String lowMedCate="";
if(medExamObj.getDatetheIndividual() !=null ){
	individualDate=HMSUtil.changeDateToddMMyyyy(medExamObj.getDatetheIndividual());
}if(medExamObj.getLowMedCat() !=null && !medExamObj.getLowMedCat().equals("")){
	lowMedCate=medExamObj.getLowMedCat();
}

%>
<label class="large">Date the individual joined your Unit/Ship</label>
<input type="text" name="<%=UNIT_DATE%>" tabindex="2" class="auto" size="21"value="<%=individualDate %>" readonly="readonly"/>

<label>Was he in Low Med Cat</label>
<select name="<%=LOW_MED_CAT %>" disabled="disabled" tabindex="1" id="lowMedCat" onchange="showHideLowMedCat();">
	<option value="">Select</option>
	<%if(lowMedCate.equalsIgnoreCase("y")){ %>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%}else if(lowMedCate.equalsIgnoreCase("n")){ %>
	<option value="y">Yes</option>
	<option value="n" selected="selected">No</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<option value="n">No</option>
	<%} %>
</select>

<div class="clear"></div>
<%if(lowMedCate.equalsIgnoreCase("y")){ %>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid4">
	<tr>
		<th scope="col">Disability Details</th>
		<th scope="col">Med Cat (Last Cat Med Board)</th>
		<th scope="col">Since</th>
		<th scope="col" colspan="2">How Long (in LMC)</th>
	</tr>
	<tr>
	<% int inc112=0;
/*
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	*/
	if(masMedicalExamDetailList!=null && masMedicalExamDetailList.size()>0)
	{
	for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExamDetailList){
	
	if(masMedicalExamDetails.getParticular()!=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("DisabilityDetails")){
		++inc112;
	%>

<TR>
<td>
<%if(masMedicalExamDetails.getIllness() !=null && masMedicalExamDetails.getMasIcd() !=null){ %>
<input 	name="disabilityCommand<%=inc112 %>" value="<%=masMedicalExamDetails.getIllness()+"["+masMedicalExamDetails.getMasIcd().getIcdCode()+"]" %>"	id="disabilityCommand<%=inc112 %>" tabindex="1" class="auto" size="50"readonly="readonly" />
<%}else{ %>
<input 	name="disabilityCommand<%=inc112 %>" value=""	id="disabilityCommand<%=inc112 %>" tabindex="1" class="auto" size="50"readonly="readonly" />
<%} %>

		<%-- 	<input name="disabilityCommand" id="disabilityCommand" type="text"  value="" tabindex="1" class="auto" size="40"/>
		--%>
		</td>
		<td>
			<select tabindex="1"  name="<%=LOW_MED_CAT %><%=inc112 %>" tabindex="1" id="lowMedCat<%=inc112 %>" disabled="disabled">

			<% for(Category category:categoryList)
			   {
			%>
				<option value="<%=category.getCategoryid() %>"><%=category.getCategories() %></option>

			<%} %>
			<%-- value will come from database --%>

</select>
<%
int ii=0;
for (Category category : categoryList) {
     			 %> <script>

     			categoryMedArray[<%=ii%>]= new Array();
     			categoryMedArray[<%=ii%>][0] = "<%=category.getCategoryid()%>";
     			categoryMedArray[<%=ii%>][1] = "<%=category.getCategories()%>";
            </script> <%
++ii;
}%>
</td>

<td>
<input type="text" name="<%=SINCE_DATE%><%=inc112 %>" value="<%=HMSUtil.changeDateToddMMyyyy(masMedicalExamDetails.getDisabilitydate()) %>" tabindex="2" maxlength="20" class="auto" size="21" readonly="readonly"/>
<%String sinceDate="sinceDate"+inc112;
%>
</td>
<td>
<input type="text"  name="<%=SINCE_YEAR %><%=inc112 %>" value="<%=masMedicalExamDetails.getLMCYears() %>" tabindex="1" class="auto" size="5"  readonly="readonly"/> year(s)
</td>
<td>
<input type="text" name="<%=SINCE_MONTH %><%=inc112 %>" value="<%=masMedicalExamDetails.getLMCMonth() %>" tabindex="1" class="auto" size="5"  readonly="readonly"/>month(s)
<input type="hidden" name="disabilityStatus" value="y" id="disabilityStatus" />
</td>
	</TR>
	
	<% }}}if(inc112<=0){
	++inc112;%>
	
	<tr>
		<td>
		<input 	name="disabilityCommand<%=inc112 %>" value=""	id="disabilityCommand<%=inc112 %>" tabindex="1" class="auto" size="50" onblur="" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('disabilityCommand<%=inc112 %>','ac2update','medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=disabilityCommand<%=inc112 %>'});
		</script>

		<%-- 	<input name="disabilityCommand" id="disabilityCommand" type="text"  value="" tabindex="1" class="auto" size="40"/>
		--%>
		</td>
		<td>
			<select tabindex="1"  name="<%=LOW_MED_CAT %><%=inc112 %>" tabindex="1" id="lowMedCat<%=inc112 %>">

			<% for(Category category:categoryList)
			   {
			%>
				<option value="<%=category.getCategoryid() %>"><%=category.getCategories() %></option>

			<%} %>
			<%-- value will come from database --%>


</select>
<%
int ii=0;
for (Category category : categoryList) {
     			 %> <script>

     			categoryMedArray[<%=ii%>]= new Array();
     			categoryMedArray[<%=ii%>][0] = "<%=category.getCategoryid()%>";
     			categoryMedArray[<%=ii%>][1] = "<%=category.getCategories()%>";
            </script> <%
++ii;
}%>
</td>

<td>
			<input type="text" name="<%=SINCE_DATE%><%=inc112 %>" tabindex="2" maxlength="20" class="auto" size="21" onKeyUp="mask(this.value,this,'2,5','/');"/>
			<%String sinceDate="sinceDate"+inc112;
			%>
</td>
<td>
<input type="text"  name="<%=SINCE_YEAR %><%=inc112 %>" value="" tabindex="1" class="auto" size="5"  /> year(s)
</td>
<td>
<input type="text" name="<%=SINCE_MONTH %><%=inc112 %>" value="" tabindex="1" class="auto" size="5"  />month(s)
<input type="hidden" name="disabilityStatus" value="y" id="disabilityStatus" />
</td>
</tr>
<%} %>
 <input type="hidden" name="hdb3" value="<%=inc112 %>" id="hdb3" />
</table>
<%} %>
<div class="clear"></div>


<div class="clear"></div>
<%
String dutyExcused="";
if(medExamObj.getDutyExcused() !=null && !medExamObj.getDutyExcused().equals("")){
	dutyExcused=medExamObj.getDutyExcused();
}
%>
<label class="large">Any Duty Excused</label>
<select disabled="disabled" name="<%=DUTY_EXCUSED %>" id="dutyExcused" >
	<option value="">Select</option>
	<%if(dutyExcused.equalsIgnoreCase("y")){ %>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%}else if(dutyExcused.equalsIgnoreCase("n")){ %>
	<option value="y">Yes</option>
	<option value="n" selected="selected">No</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<option value="n">No</option>
	<%} %>
</select>

<div class="clear"></div>
<label class="large">Nature of Duties in the Unit</label>
<%
String natureDuties="";
if(medExamObj.getNatureDuties() !=null && !medExamObj.getNatureDuties().equals("")){
	natureDuties=medExamObj.getNatureDuties();
}%>
<input type="text" readonly="readonly" name="<%=NATURE_DUTIES %>" id="natureDuties" value="<%=natureDuties %>" tabindex="1"  readonly="readonly"/>

<div class="clear"></div>
<%
String severeExcepStress="";
if(medExamObj.getSevereExcepStress() !=null && !medExamObj.getSevereExcepStress().equals("")){
	severeExcepStress=medExamObj.getSevereExcepStress();}
%>
<label class="large">Did the duties involve severe/exceptional stress &amp; strain</label>
<select name="<%=SEVERE_EXCEPTIONAL %>" disabled="disabled" id="severeExceptional" onchange="showHideSevereExceptional();" tabindex="1">
	<option value="">Select</option>
	<%if(severeExcepStress.equalsIgnoreCase("y")){ %>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%}else if(severeExcepStress.equalsIgnoreCase("n")){ %>
	<option value="y">Yes</option>
	<option value="n" selected="selected">No</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<option value="n">No</option>
	<%} %>
</select>

<%---
<div id="severeExceptionalDiv"  style="display: none"> --%>
<%
String sinceWhen="";
String sinceOn="";
String sinceFamily="";
String sinceIn="";
if(severeExcepStress.equalsIgnoreCase("y")){
if(medExamObj.getSinceWhen() !=null ){
	sinceWhen=HMSUtil.changeDateToddMMyyyy(medExamObj.getSinceWhen()); 
}
if(medExamObj.getSinceOn() !=null ){
	sinceOn=medExamObj.getSinceOn(); 
}
if(medExamObj.getSinceWhen1() !=null ){
	sinceFamily=HMSUtil.changeDateToddMMyyyy(medExamObj.getSinceWhen1()); 
}
if(medExamObj.getSinceIn() !=null ){
	sinceIn=medExamObj.getSinceIn(); 
}
	
	%>
<label class="">Since When</label>
<input type="text" name="<%=SINCE_WHEN%>" readonly="readonly" tabindex="2" class="auto" size="11" value="<%=sinceWhen %>" readonly="readonly"/>

<label class="auto">On </label>
<select name="" id="" onchange="" tabindex="1" disabled="disabled" >
	<option value="">Select</option>
	<%if(sinceOn.equalsIgnoreCase("Special Days")){ %>
<option value="Special Days" selected="selected">Special Days</option>
	<option value="Occasions">Occasions</option><%}else if(sinceOn.equalsIgnoreCase("Occasions")){ %>
	<option value="Special Days">Special Days</option>
	<option value="Occasions" selected="selected">Occasions</option>
	<%}else{ %>
	<option value="Special Days">Special Days</option>
	<option value="Occasions">Occasions</option>
	<%} %>
</select>
<%} %>
<%---</div> --%>

<div class="clear"></div>
<%
String familyLiving="";
if(medExamObj.getFamilyLiving() !=null && !medExamObj.getFamilyLiving().equals("")){
	familyLiving=medExamObj.getFamilyLiving();
}%>
<label class="large">Was he living with his family </label>
<select name="<%=WITH_FAMILY %>"  tabindex="1"id="withFamily" onchange="showHideWithFamily();" disabled="disabled">
<option value="">Select</option>
	<%if(familyLiving.equalsIgnoreCase("y")){ %>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%}else if(familyLiving.equalsIgnoreCase("n")){ %>
	<option value="y">Yes</option>
	<option value="n" selected="selected">No</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<option value="n">No</option>
	<%} %>
</select>
<%if(familyLiving.equalsIgnoreCase("y")){ %>
<%---
<div id="withFamilyDiv"  style="display: none"> --%>

<label class=""> Since When</label>
<input type="text" readonly="readonly" name="<%=SINCE_FAMILY%>" tabindex="2" class="auto" size="11" value="<%=sinceFamily %>" readonly="readonly"/>

<label class="auto"> In</label>
<select name="<%=GOV_ACCOMODATE %>" disabled="disabled" tabindex="1" id="govAccomodate" >
	<option value="">Select</option>
	<%if(sinceIn.equalsIgnoreCase("govt")){ %>
	<option value="govt" selected="selected">Govt. Accomodation</option>
	<option value="nonGovt">Own Arrangement</option>
	<%}else if(sinceIn.equalsIgnoreCase("nonGovt")){ %>
	<option value="govt">Govt. Accomodation</option>
	<option value="nonGovt" selected="selected">Own Arrangement</option>
	<%}else{ %>
	<option value="govt">Govt. Accomodation</option>
	<option value="nonGovt">Own Arrangement</option>
	<%} %>
</select><%} %>
<%--
</div> --%>

<div class="clear"></div>
<%
String livingUnitLines="";
if(medExamObj.getLivingUnitLines() !=null && !medExamObj.getLivingUnitLines().equals("")){
	livingUnitLines=medExamObj.getLivingUnitLines();
}%>
<label class="large" >Living in Unit lines</label>
<select name="<%=UNIT_LINES %>" disabled="disabled" id="unitLines">
<option value="">Select</option>
	<%if(livingUnitLines.equalsIgnoreCase("y")){ %>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%}else if(livingUnitLines.equalsIgnoreCase("n")){ %>
	<option value="y">Yes</option>
	<option value="n" selected="selected">No</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<option value="n">No</option>
	<%} %>
</select>

<div class="clear"></div>
<%
String lastLeaveOn="";
String spent="";
if(medExamObj.getDatesoflastleave() !=null ){
	lastLeaveOn=HMSUtil.changeDateToddMMyyyy(medExamObj.getDatesoflastleave()); 
} 
if(medExamObj.getSpent() !=null ){
	spent=medExamObj.getSpent(); 
}%>
<label class="large">Last Leave on</label>
<input type="text" readonly="readonly" name="<%=LEAVE_DATE%>" tabindex="2" class="auto" size="21" value="<%=lastLeaveOn %>" readonly="readonly"/>


<label class="">Spent</label>
<%--
<input type="text" name="<%=SPENT%>" id="spent" value=""   /> --%>
<select name="<%=SPENT %>" disabled="disabled" id="spent"  tabindex="1">
	<option value="">Select</option>
	<%if(spent.equalsIgnoreCase("village")){ %>
	<option value="village" selected="selected">Village</option>
	<option value="town">Town</option>
	<option value="state">State</option><%}else if(spent.equalsIgnoreCase("town")){ %>
	<option value="village">Village</option>
	<option value="town" selected="selected">Town</option>
	<option value="state">State</option>
	<%}else if(spent.equalsIgnoreCase("state")){ %>
	<option value="village">Village</option>
	<option value="town">Town</option>
	<option value="state" selected="selected">State</option>
	<%}else{ %>
	<option value="village">Village</option>
	<option value="town">Town</option>
	<option value="state">State</option><%} %>
</select>
<div class="clear"></div>
<%
String infectionDisability="";
if(medExamObj.getInfectionDisability() !=null && !medExamObj.getInfectionDisability().equals("")){
	infectionDisability=medExamObj.getInfectionDisability();
}%>
<label class="large">If disablity is due to infection</label>
<select name="<%=DISABILTY_INFECTION %>" disabled="disabled" id="disabiltyInfection" onchange="showHideDisabiltyInfection();"	 tabindex="1">
	<option value="">Select</option>
	<%if(infectionDisability.equalsIgnoreCase("y")){ %>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%}else if(infectionDisability.equalsIgnoreCase("n")){ %>
	<option value="y">Yes</option>
	<option value="n" selected="selected">No</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<option value="n">No</option>
	<%} %>
</select>

<div class="clear"></div>

<%---
<div id="disabiltyInfectionDiv"  style="display: none"> --%>
<%if(infectionDisability.equalsIgnoreCase("y")){ %>
<%
String disabilityOtherCase="";
if(medExamObj.getDisabilityOtherCase() !=null && !medExamObj.getDisabilityOtherCase().equals("")){
	disabilityOtherCase=medExamObj.getDisabilityOtherCase();
}%>
<label class="large">Any other case in the unit</label>
<select name="<%=OTHER_CASE_UNIT %>" disabled="disabled" tabindex="1">
	<option value="">Select</option>
	<%if(disabilityOtherCase.equalsIgnoreCase("y")){ %>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%}else if(disabilityOtherCase.equalsIgnoreCase("n")){ %>
	<option value="y">Yes</option>
	<option value="n" selected="selected">No</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<option value="n">No</option>
	<%} %>
</select>

<div class="clear"></div>
<%if(infectionDisability.equalsIgnoreCase("y")){ %>
<label class="large">Is the disease endemic in the town in surrounding areas</label>
<%if(medExamObj.getDiseaseSurroundingAreas()  !=null){ %>
<input type="text" readonly="readonly" name="<%=SURROUNDING_AREAS%>" tabindex="2" maxlength="50" 
value="<%=medExamObj.getDiseaseSurroundingAreas() %>"   />
<%}else{ %>
<input type="text" readonly="readonly" name="<%=SURROUNDING_AREAS%>" tabindex="2" maxlength="50"   />
<%} %>
<%} %>
<div class="clear"></div>
<%String  preventiveMeasures="";
if(medExamObj.getPreventMeasure() !=null){
preventiveMeasures=medExamObj.getPreventMeasure();}%>
<label class="large">Preventive measures taken</label>
<select name="<%=PREVENT_MEASURES %>" disabled="disabled"  tabindex="1">
<option value="">Select</option>
	<%if(preventiveMeasures.equalsIgnoreCase("y")){ %>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%}else if(preventiveMeasures.equalsIgnoreCase("n")){ %>
	<option value="y">Yes</option>
	<option value="n" selected="selected">No</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<option value="n">No</option>
	<%} %>
</select>
<%} %>
<div class="clear"></div>
<%String transmittedDiseases=""; 
if(medExamObj.getTranmittedDisease() !=null){
transmittedDiseases=medExamObj.getTranmittedDisease();}%>
<label class="large">Is this a case of sexually transmitted diseases</label>
<select name="<%=TRANMITTED_DISEASE %>" disabled="disabled" id="diseasesId"  tabindex="1" onchange="showHideTransmittedDiseases();">
	<option value="">Select</option>
	<%if(transmittedDiseases.equalsIgnoreCase("y")){ %>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%}else if(transmittedDiseases.equalsIgnoreCase("n")){ %>
	<option value="y">Yes</option>
	<option value="n" selected="selected">No</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<option value="n">No</option>
	<%} %>
</select>
<div class="clear"></div>
<%----
<div id="transmittedDiv"  style="display: none"> --%>
<%if(transmittedDiseases.equalsIgnoreCase("y")){
	String contactedDate="";
	String contactedPlace="";
	String hospitalStd="";
	if(medExamObj.getTranmittedDate() !=null ){
		contactedDate=HMSUtil.changeDateToddMMyyyy(medExamObj.getTranmittedDate()); 
}
if(medExamObj.getPlace() !=null ){
		contactedDate=medExamObj.getPlace(); 
}
if(medExamObj.getHospitalStdCenter() !=null){
	hospitalStd=medExamObj.getHospitalStdCenter();
}
%>
<label class="large">When was it contacted</label>
<input type="text" readonly="readonly" name="<%=CONTACTED_DATE%>" tabindex="2" class="date" value="<%=contactedDate %>" readonly="readonly"/>

<label>Where was it contacted</label>
<input type="text" readonly="readonly" name="<%=CONTACTED_PLACE%>" tabindex="2" value="<%=contactedDate %>" readonly="readonly"/>

<div class="clear"></div>

<label class="large">Name of Hospital/STD Centre where treated</label>
<input type="text" readonly="readonly" name="<%=HOSPITAL_STD%>" tabindex="2" readonly="readonly"  value="<%=hospitalStd %>"/>

<div class="clear"></div>
<% String Followup_treatment="";
if(medExamObj.getFollowup_treatment() !=null){
Followup_treatment=medExamObj.getFollowup_treatment();}%>
<label class="large">Was surveillance and follow up treatment completed</label>
<select name="<%=TREATMENT_COMPLETED %>" disabled="disabled" id="treatmentCompleted" tabindex="1">
	<%if(Followup_treatment.equalsIgnoreCase("y")){ %>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%}else if(Followup_treatment.equalsIgnoreCase("n")){ %>
	<option value="y">Yes</option>
	<option value="n" selected="selected">No</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<option value="n">No</option>
	<%} %>
</select>
<%--- <div id="ftcDateDiv"  style="display: inline;"> --%>
 <%String flcDate="";
 if(medExamObj.getFlcDate() !=null && !medExamObj.getFlcDate().equals("")){
	 flcDate=HMSUtil.changeDateToddMMyyyy(medExamObj.getFlcDate());
}%>
<label>Date of FTC</label>
<input type="text" readonly="readonly" name="<%=FTC_DATE%>" tabindex="2" class="auto" size="20" id="ftcDate" 
value="<%=flcDate %>"readonly="readonly"/>
 <%---</div> --%>
<div class="clear"></div>
<div id="treatmentCompletedDiv"  style="display: none">

<label class="large">State responsible service factors</label>
<input type="text" name="<%=RESPONSIBLE_FACTORS%>" readonly="readonly" tabindex="2"   />

</div><%} %><%---</div> --%>
<div class="clear"></div>

<label class="auto">Injury Report/ IHD Case /any other / 14 days charter of duties any other document.</label>

<input class="transparent" size="2">
<input name="Send" type="button"  class="button" value="View"
				onClick="javascript:fileUploadViewWindow('IHD');" />

</div>

<div class="clear paddingTop15"></div>

<h4> Command Officer Details<a href="javascript:animatedcollapse.toggle('slide2')"></a></h4>
<div class="clear"></div>
<div id="slide2">
<div class="Block">

<label >Rank</label>
<% if(medExamObj!=null && medExamObj.getComdOfficerRamk()!=null){%>

<input tabindex="1" type="text" readonly="readonly" name="<%=COMMAND_RANK%>" value="<%=medExamObj.getComdOfficerRamk() %>" id="commandRank"/>
<%}else{ %>
<input tabindex="1" type="text" readonly="readonly" name="<%=COMMAND_RANK%>" id="commandRank"/>

 <%}%>
<label >Name</label>
<% if(medExamObj!=null && medExamObj.getCommandingOfficer()!=null){%>

<input tabindex="1" type="text" readonly="readonly" value="<%=medExamObj.getCommandingOfficer() %>" name="<%=COMMAND_NAME%>" id="commandRank"/>
<%}else{ %>
<input tabindex="1" type="text" readonly="readonly" name="<%=COMMAND_RANK%>" id="commandRank"/>

 <%}%>

<label >Unit</label>
<% if(medExamObj!=null && medExamObj.getComdOfficerUnit()!=null){%>

<input tabindex="1" type="text" readonly="readonly" name="<%=COMMAND_UNIT%>" value="<%=medExamObj.getComdOfficerUnit() %>" id="commandRank"/>
<%}else{ %>
<input tabindex="1" type="text" readonly="readonly" name="<%=COMMAND_UNIT%>" id="commandRank"/>

 <%}%>
<div class="clear"></div>
<label >Date</label>
<%String commandDate="";
if(medExamObj.getCommanddate() !=null){
	commandDate=HMSUtil.changeDateToddMMyyyy(medExamObj.getCommanddate());
}
%>
<input tabindex="1" type="text" name="<%=COMMAND_DATE%>" readonly="readonly" id="commandRank" value="<%=commandDate%>"/>

<div class="clear"></div>
</div>
</div>
<%--
<input name="Button" type="button" class="button" value="Submit" onClick="" tabindex="1"/>
--%>
<input type="button" name="Close" value="Close" class="button" onclick="window.close()" tabindex="1" />

<div class="clear"></div>
<script language="JavaScript" type="text/javascript">

 function showHideLowMedCat(){
		if(document.getElementById('lowMedCat').value == 'y'){
		  	document.getElementById("lowMedCatDiv").style.display='inline';
		}else{
			document.getElementById("lowMedCatDiv").style.display='none';
		}
	}
	function showHideWithFamily(){
		if(document.getElementById('withFamily').value == 'y'){
		  	document.getElementById("withFamilyDiv").style.display='inline';
		}else{
			document.getElementById("withFamilyDiv").style.display='none';
		}
	}
	function showHideSevereExceptional(){
		if(document.getElementById('severeExceptional').value == 'y'){
		  	document.getElementById("severeExceptionalDiv").style.display='inline';
		}else{
			document.getElementById("severeExceptionalDiv").style.display='none';
		}
	}
	function showHideDisabiltyInfection(){
		if(document.getElementById('disabiltyInfection').value == 'y'){
		  	document.getElementById("disabiltyInfectionDiv").style.display='inline';
		}else{
			document.getElementById("disabiltyInfectionDiv").style.display='none';
		}
	}
	function showHideTreatmentCompleted(){
		if(document.getElementById('treatmentCompleted').value == 'n'){
		  	document.getElementById("treatmentCompletedDiv").style.display='inline';
		}else{
			document.getElementById("treatmentCompletedDiv").style.display='none';
		}
	}
	function fileUploadViewWindow(flag)
	{
			var url="/hms/hms/medicalBoard?method=viewUploadDocuments&visitId=<%=medExamObj.getVisit().getId()%>&medExamId=<%=medExamObj.getId()%>&flag="+flag;
			newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

	}
</script></form>
</body>
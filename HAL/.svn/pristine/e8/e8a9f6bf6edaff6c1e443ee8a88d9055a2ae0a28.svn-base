
<%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<%@page import="jkt.hms.masters.business.MasChildMilestone"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.FwcGrowthChart"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript" language="javascript">
<%
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


var icdArray=new Array();
var unitArray = new Array();

</script>

<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	List<Visit>wellBabyDataList = new ArrayList<Visit>();
	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
	List<PatientFamilyHistory> patientFamilyHistoryList=new ArrayList<PatientFamilyHistory>(); 
	if(map.get("wellBabyDataList") != null){
		wellBabyDataList=(List)map.get("wellBabyDataList");
	}
	List<MasMedicalExaminationReportOnEntry> medicalList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	if(map.get("medicalList") != null){
		medicalList=(List)map.get("medicalList");
	}
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null){
		frequencyList=(List)map.get("frequencyList");
	}
	if(map.get("disposalList") != null){
		disposalList=(List)map.get("disposalList");
	}
	if(map.get("patientFamilyHistoryList") != null){
		patientFamilyHistoryList=(List)map.get("patientFamilyHistoryList");
	}
	List<MasChildMilestone> masChildMilestoneList = new ArrayList<MasChildMilestone>();
	if(map.get("masChildMilestoneList") != null){
		masChildMilestoneList=(List)map.get("masChildMilestoneList");
	}
	List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
	if(map.get("templateList") != null){
		templateList=(List)map.get("templateList");
	}
	List<FwcGrowthChart> growthChartList = new ArrayList<FwcGrowthChart>();
	if(map.get("growthChartList") != null){
	   growthChartList=(List)map.get("growthChartList");
	}
	
	MasMedicalExaminationReportOnEntry meddata=new MasMedicalExaminationReportOnEntry();
	if(medicalList.size()>0)
	{
		meddata=(MasMedicalExaminationReportOnEntry)medicalList.get(0);
	}
	String patientName="";
	Patient patient = new Patient();
	String servicePersionName="";
	Visit visit = new Visit();
	if(wellBabyDataList.size()>0){
	 visit=(Visit)wellBabyDataList.get(0);
	 patient = (Patient)visit.getHin();
	if(patient.getPFirstName()!= null){
	patientName=patient.getPFirstName();
	}
	if(patient.getPMiddleName()!= null){
	patientName=patientName+" "+patient.getPMiddleName();
	}
	if(patient.getPLastName()!= null){
	patientName=patientName+" "+patient.getPLastName();
	}
	if(patient.getSFirstName()!= null){
	 servicePersionName=patient.getSFirstName();
	}
	if(patient.getSMiddleName()!= null){
	servicePersionName=servicePersionName+" "+patient.getSMiddleName();
	}
	if(patient.getSLastName()!= null){
	servicePersionName=servicePersionName+" "+patient.getSLastName();
	}
}
	
	//Set<MasMedicalExamFamilyHis> familyHisSet = new HashSet<MasMedicalExamFamilyHis>();
	//if(visit.getHin().getMasMedicalExamFamilyHis() !=null){
		//familyHisSet  = visit.getHin().getMasMedicalExamFamilyHis() ;
	//}

%>

<!--main content placeholder starts here-->
<form name="wellBaby" action="" method="post">
<div>

<input	name="" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&reportingFor=FamilyWC&backFlag=fp')" />
<input	name="" type="button"	value="Previous Prescriptions" tabindex="1" class="buttonBig2" onclick="javascript:openPopupPrescriptions(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getDepartment().getId()%>,<%=visit.getHin().getId()%>,'FamilyWC')" />
<input	name="" type="button"	value="Previous Investigations" tabindex="1" class="buttonBig2" onclick="javascript:openPopupInvestigation(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getDepartment().getId()%>,<%=visit.getHin().getId()%>,'FamilyWC')"/>
<input	name="" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&backFlag=fp')" />
<input	name="" type="button"	value="MLC Details" tabindex="1" class="buttonBig2" onclick="openWindow('/hms/hms/adt?method=showMlcJsp&hinId=<%=visit.getHin().getId() %>&reportingFor=FamilyWC&backFlag=fp')"/>
<input	name="" type="button"	value="Upload Documents" tabindex="1" class="buttonBig2" onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&visitId=<%=visit.getId() %>&reportingFor=FamilyWC&backFlag=fp')"/>
</div>
<div class="clear"></div>
<div class="titleBg">
<h2>Well Baby</h2>
</div>



<script type="text/javascript">
var milestoneArr=new Array();
</script>
<div class="clear"></div>


<h4>Service Personal Details</h4>
<div class="clear"></div>
<div class="Block">
<label>Service No.</label>
 
<label class="value"><%=patient.getServiceNo()!=null ?patient.getServiceNo(): ""  %></label>
 

<label>Rank</label>

<label class="value"><%=patient.getRank() != null ? patient.getRank().getRankName():"" %></label>


<label>Name</label> 
 <label class="value"><%=servicePersionName %></label>

<div class="clear"></div>
<label>Trade/Branch</label>
 
<label class="value"><%=patient.getTrade()!= null?patient.getTrade().getTradeName():"" %></label>

<label>Unit</label>
 
<label class="value"><%=patient.getUnit()!= null?patient.getUnit().getUnitName():"" %></label>


<label>Age</label> 

<label class="value"><%=patient.getSrAge()!= null?patient.getSrAge():"" %></label> 


<input type="hidden" value="37 Years" id="ageId" name="ageId">
<div class="clear"></div>

 
<label>Blood Group</label>

<label class="value"><%=patient.getSrBloodGroup()!= null?patient.getSrBloodGroup().getBloodGroupName():"" %></label>

<input type="hidden" name="visitId" value="<%=visit.getId()%>">
<input type="hidden" name="hinId" value="<%=patient.getId()%>">
 <input name="departmentId"	type="hidden" value="<%=visit.getDepartment().getId()%>" />
<input	name="<%=VISIT_NUMBER%>" type="hidden" value="<%=visit.getVisitNo()%>" />
<input	name="<%=SERVICE_NO%>" type="hidden" value="<%=visit.getHin().getServiceNo()%>" />
<%-- <input name="deptId" type="hidden" value="<%=visit.getDepartment().getId()%>" />--%>
<input name="<%=HIN_NO%>" type="hidden"	value="<%=visit.getHin().getHinNo()%>" />
<input name="<%=SERVICE_TYPE_NAME%>" type="hidden"	value="<%=visit.getHin().getServiceType().getServiceTypeName()%>" />

</div>

<div class="clear"></div>
<h4>Child's Details</h4>
<div class="clear"></div>
<div class="Block">
<label>Name of Child</label>
<input type="text" name="nameOfChild" value="<%=patientName %>" />
<label>Relation</label>
<input type="text" name="relation" value="<%=patient.getRelation()!= null?patient.getRelation().getRelationName():"" %>" />
<label>DOB</label>
<%if(patient.getDateOfBirth() != null && !patient.getDateOfBirth().equals("")){ %>
<input type="text" id="srdobId" name="dateOfBirth"	tabindex="1" value="<%=HMSUtil.convertDateToStringWithoutTime(patient.getDateOfBirth()) %>" validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"	/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.wellBaby.dateOfBirth,event)" />
<%}else{ %>
<input type="text" id="srdobId" name="dateOfBirth"	tabindex="1" value="" validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"	 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.wellBaby.dateOfBirth,event)" />
<%} %>
<div class="clear"></div>

<label>Age <span>*</span></label>
<input type="text" name="relation" value="<%=patient.getAge()!= null?patient.getAge():"" %>" />

<label>Gender</label>
<input type="text" name="gender"  value="<%=patient.getSex()!= null?patient.getSex().getAdministrativeSexName():"" %>" />
<input type="hidden" name="gender" id="genderId" value="<%=patient.getSex()!= null?patient.getSex().getId():"" %>" />
<label>Allergies</label>
<input type="text" name="allergies" value="<%=patient.getAllergyDetails() != null?patient.getAllergyDetails():"" %>" />
<label>Blood Group</label>
<input type="text" name="bloodGroup" value="<%=patient.getBloodGroup()!= null?patient.getBloodGroup().getBloodGroupName():"" %>" />

<div class="clear"></div>
<%-- <label>Chest</label>
<input type="text" name="childchest" class="small"/>
<label class="unit">cm</label>


<label>Respiratory Rate</label>
<input type="text" name="chilRespiratoryRate" class="auto" size="17"/>
<label class="unit">/min</label>
--%>
</div>
<div class="clear"></div>





<h4>Birth Record</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Hospital Name</label>
<input type="text" name="hospitalName" value="" maxlength="50"/>
<label>DOB</label>
<%if(patient.getDateOfBirth() != null && !patient.getDateOfBirth().equals("")){ %>
<input type="text" id="srdobId" name="<%=DOB %>"	tabindex="1" value="<%=HMSUtil.convertDateToStringWithoutTime(patient.getDateOfBirth()) %>" validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"		onblur="validateExpDate(this,'srdobId');calculateSRAgeInAjax();fillPatientName(this);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"  border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.wellBaby.<%=DOB%>,event)" />
<%}else{ %>
<input type="text" id="srdobId" name="<%=DOB %>"	tabindex="1" value="" validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"		onblur="validateExpDate(this,'srdobId');calculateSRAgeInAjax();fillPatientName(this);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"  border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.wellBaby.<%=DOB%>,event)" />

<%} %>
<label>Time of Birth</label>
<input type="text" name="timeOfBirth" value="" onkeyup="mask(this.value,this,'2',':');" maxlength="5" />
<div class="clear"></div>
<label>Type of Delivery</label>
<select name="typeOfDelivery" >
<option value="Normal">Normal</option>
<option value="Cesarean">Cesarean</option>
</select>
<label>Gestational Age</label>
<input type="text" name="gestationalAge" value="" />
<div class="clear"></div>
<label >Weight</label>
<input type="text" name="childWeight" class="auto" value="" size="7" maxlength="2"/>
<label class="unit">kg</label>
<input type="text" name="weightGm" class="auto" size="7"/>
<label class="unit">gm</label>

<label >Height</label>
<input type="text" name="childHeight" value="" class="small" maxlength="2"/>
<label class="unit">cm</label>
<label>Head Circumference</label>
<input type="text" name="childHeadCircumference" value=""  class="auto" size="7"  maxlength="2"/>
<label class="unit">cm</label>
<label class="unit">gm</label>
<div class="clear"></div>
<label>Perinatal History/Neonatal Illness<span>*</span></label> <!--  <input type="text" id="presentComplain"  name="presentComplain" maxlength="100"/>-->
<textarea name="perinatalHistory" cols="0" rows="0"  maxlength="950" validate="Perinatal History,metachar,yes" value=""  tabindex="1" onkeyup="return ismaxlength(this)"></textarea>

<div class="clear"></div>
</div>


<div class="clear"></div>
<h4>Immunization</h4>
<div class="clear"></div>

<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="immunizationgrid" >

<tr>
<th>Age</th>
<th>Vaccine</th>
<th>Given On</th>
<th>Due On</th>
<th>Dose</th>
<th>Route</th>
<th>Add</th>
<th>Delete</th>
</tr>
<%
int i =1;

%>
<tr>
<td><select name="vaccineAge<%=i%>" id="vaccineAge<%=i%>" tabindex="1" onchange="displayVaccine(this.value,<%=i %>);"  >
			<option value="0">Select</option>
			<option value="Birth">Birth</option>
			<option value="6 Weeks">6 Weeks</option>
			<option value="10 Weeks">10 Weeks</option>
			<option value="14 Weeks">14 Weeks</option>
			<option value="9 Months">9 Months</option>
			<option value="16-24 Months">16-24 Months</option>
			<option value="2 Years">2 Years</option>
			<option value="4-6 Years">4-6 Years</option>
			<option value="10 Years">10 Years</option>
			<option value="16 Years">16 Years</option>
			
		</select></td>
		<td>
			<select name="immunizationId<%=i%>" id="immunizationId<%=i%>" tabindex="1"   >
			<option value="0">Select</option>
		</select>
		</td>
		
		<td>	
			<input	type="text" name="immuDate<%=i %>" value="" id="immuDate<%=i %>" size="10" readonly="readonly">
			<img id="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"
			onClick="setdate('',document.wellBaby.immuDate<%=i %>,event)" /> 
			
			</td>
			
		<td>	
			<input	type="text" name="dueDate<%=i %>" value="" id="dueDate<%=i %>" size="10" readonly="readonly"/>
			<img id="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" class="calender"
			onClick="setdate('',document.wellBaby.dueDate<%=i %>,event)" /> 
			</td>
			
			<td><input	type="text" name="dose<%=i %>" value="" id="dose<%=i %>" size="5" maxlength="5"/></td>
			
			<td><input	type="text" name="route<%=i %>" value="" id="route<%=i %>" size="10" maxlength="20"/></td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForImmunisation();" tabindex="1" /></td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('immunizationgrid','hdb',this);" tabindex="1" />
			</td>
	</tr>

</table>
</div>
<div class="clear"></div>
<input type="hidden" name="count" value="<%=i %>" id="count" />
<div class="division"></div>
<div class="clear"></div>
<h4>Development Milestone</h4>
<div class="clear"></div>

<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="milstoneGrid">

<tr>
<th>Milestone</th>
<th colspan="2">Result</th>
<th colspan="2">Normal Age Range</th>
<th>Remarks</th>
<th>Add</th>
<th>Delete</th>
</tr>
<%
int inc = 1;

%>
<tr>
<td><select name="childMilestone<%=inc%>" id="childMilestone<%=inc%>" tabindex="1" onchange="displayMilestoneNormalRange(this.value,<%=inc %>);" >
			<option value="0">Select</option>
			<%
				for (MasChildMilestone masChildMilestone: masChildMilestoneList) {
									
			%>

			<option value="<%=masChildMilestone.getId()%>" ><%=masChildMilestone.getMilestoneName()%></option>
			<%
				}
			%>
		</select> <%

 					for (int j = 0; j < masChildMilestoneList.size(); j++) {
 	MasChildMilestone masChildMilestone = masChildMilestoneList.get(j);
 						
 %> <script>

 milestoneArr[<%=j%>]= new Array();
 milestoneArr[<%=j%>][0] = '<%=masChildMilestone.getId()%>';
 milestoneArr[<%=j%>][1] = '<%=masChildMilestone.getMilestoneName()%>';
            </script> <%
 	}
 %>
		</td>
		
<td><input type="text" name="result<%=inc%>" id="result<%=inc%>" class="auto" /></td>
<td>Months</td>
<td><input type="text" name="normalAgeRange<%=inc%>" value="" id="normalAgeRange<%=inc%>" /></td>
<td>Months</td>
<td><input type="text" name="remarks<%=inc%>" id="remarks<%=inc%>" /></td>
<td><input name="button" type="button" class="buttonAdd" value="" onclick="addRowMilestone();" tabindex="1" /></td>
<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('milstoneGrid','hdb',this);" tabindex="1" /></td>
</tr>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />

</table>
</div>
<div class="clear"></div>
<h4>Medical Examination</h4>
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="ancGrid">
	<tr>
		<th scope="col">Age</th>
		<th scope="col">Clinical Examination</th>
		<th scope="col">BP</th>
		<th scope="col">Hb</th>
		<th scope="col">Urine</th>
		<th scope="col">Eye</th>
		<th scope="col">ENT</th>
		<th scope="col">Dental</th>
			
	</tr>

	<tr>
	<td><input type="text"	 name="ageGrid" value=""/></td>
	<td><input type="text"	 name="clinicalExamination" value=""/></td>
	<td><input type="text"	 name="bp" value=""/></td>
	<td><input type="checkbox"	 name="hb" value="" onclick="displayInv(this);" /></td>
	<td><input type="checkbox"	 name="urine" value="" onclick="displayInv(this);" /></td>
	<td><input type="text"	 name="eye" value=""  /></td>
	<td><input type="text"	 name="ent" value=""/></td>
	<td><input type="text"	 name="dental" value=""/></td>
	</tr>
</table>
</div>

<div class="clear"></div>
<div id="followUpDiv" style="display: none;">
<h4>INVESTIGATION</h4>
<div class="Block">
<label >Template</label>
<div id="investigationDiv">
<select name="investigationTemplateId" id="investigationTemplateId" tabindex="1" multiple="multiple" class="list" onblur="showHideInvestigationTemplateCombo();">
<%-- <select name="investigationTemplateId"	tabindex="1" onchange="showHideInvestigationTemplateCombo(this.value);">--%>
	<option value="0">Select</option>
	<%
			   Iterator itr1=templateList.iterator();
			   while(itr1.hasNext())
			   {
				   OpdTemplate opdTemplate=(OpdTemplate)itr1.next();
				   String templateType=opdTemplate.getTemplateType();
				   if(templateType.equalsIgnoreCase("I"))
				   {
			%>
	<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getId()+" "+opdTemplate.getTemplateName()%></option>
	<%
		   }
	      }

		%>

</select>
</div>
<%-- <input	name="Prevoius" type="button" value="Previous" tabindex="1"	class="button"	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />--%>
<div id="createInvestigationDivToShowHide">
<input	name="investigationTemplate" type="button"	value="Create Template" tabindex="1" class="buttonBig" onclick="showCreateInvestigationTemplate();" />
</div>
<div id="copyPrevInvestigationTemplateDiv" style="display: none">
<input name="copyPrevInvestigationTemplate" tabindex="1" type="button"	value="Copy Previous" class="buttonBig" onclick="copyPrevInvestigationTempate('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>');" />
</div>
<div id="investigationImportButton1" >
<input	name="investigationImportButton1" tabindex="1" type="button"	value="Import New" class="button"	onclick="getListForTreatment('investigationDiv');" />
</div>
</div>
<div class="clear"></div>
<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid">
	<tr>
		<th scope="col">Investigation Name</th>
		<th scope="col">Refer to MH</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>
		<%int j=1;
%>
		<tr>
		<td>
		<input type="text" value="" tabindex="1" id="chargeCodeName1" size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=j %>')){checkForChargeCode(this.value,'<%=j %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty<%=j %>" tabindex="1" name="qty1"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
	
		<td><input type="checkbox" name="referToMh1" tabindex="1" id="referToMhId<%=j%>" value="y" class="radio"  validate="Refer to MH,metachar,no" /></td>
	
		<td><input name="Button" type="button" class="buttonAdd" value="" tabindex="1"
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" tabindex="1"
			onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


	</tr>
	
	

	
</table>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<div class="clear paddingTop15"></div>
<div class="clear"></div></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" >

<tr>
<TH scope="col" class="large">Clinical Notes</TH>
</tr>

<tr>
<td><input type="text" name="clinicalNotes1" class="auto" size="100" maxlength="98"></input></td>
</tr>

</table>
<div class="clear"></div>

</div>
<div class="clear"></div>



<div class="Clear"></div>
<h4>Treatment</h4>
<div class="Clear"></div>
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

	<tr>
		 <th>PVMS/NIV Nomenclature</th>
	    <th colspan="1">Other Drug</th>
	<!--      <th colspan="1">Injection</th>-->
		<!-- <th scope="col">PVMS No.</th> -->
		<th scope="col">AU</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">Days</th>
		<!--  <th scope="col">Total</th>
		<th scope="col">Intake</th> -->
		<th scope="col">Route</th>
		<!--<th scope="col">Type</th>-->
		<th scope="col">Remarks</th>
		<th scope="col">CT</th>
		<th scope="col">Stock</th>
		<th>Add</th>
		<th>Delete</th>
		
	</tr>
	<tr>
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature1" size="30"  name="nomenclature1" onblur="populatePVMS(this.value,'1');checkItem(1);disableOtherMedicine(this.value,'1');displayAu(this.value,'1');"  />
	    <!-- <IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();" title="Click here to Search for Nomenclature"> -->
	     <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>
		<td><input type="text" name="otherMedicine1" tabindex="1" id="otherMedicine1"  size="20" onblur="readOnlyNomenclature(this.value,'1');" validate="other Medicine,metachar,no" /></td>
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,metachar,no" />
		<input type="hidden" name="actualDispensingQty1" tabindex="1" id="actualDispensingQty1" value=""  size="6"  validate="AU,metachar,no" /></td>
		
	<%-- <td><input type="checkbox" name="injCategory1" class="radio" id="injCategory1" value="y" />
		</td>--%>
		<td><input type="hidden" name="pvmsNo1" tabindex="1" id="pvmsNo1"	size="10" readonly="readonly" />
	<input type="text" name="dosage1" tabindex="1" value="" id="dosage1"	size="5" maxlength="5" onblur="checkDosageValidation(this.value,'1')" /></td>
		<td><select name="frequency1" id="frequency1" tabindex="1" class="medium" onchange="fillValueFromFrequency(this.value,'1');getFrequencyValue(this.value,'1')" >
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
		</select> <%
	    		MasFrequency  masFrequency = new MasFrequency();

			     for (int l = 0; l < frequencyList.size(); l++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(l);
     			 %> <script>

	          icdArray[<%=l%>]= new Array();
	          icdArray[<%=l%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=l%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%>
            <input type="hidden" name="frequencyValue1" id="frequencyValue1" value="">
            <input type="text" name="sosQty1" tabindex="1" id="sosQty1" style="display: none;"   size="3" onblur="fillValue(this.value,'1')"	maxlength="3" validate="Sos Qty,num,no" />
		</td>

		<td><input type="text" name="noOfDays1" tabindex="1" id="noOfDays1" onblur="fillValue(this.value,'1')"  size="3"	maxlength="3" validate="No Of Days,num,no" />
			
		</td>
		<td><input type="text" name="route1" tabindex="1" id="route1" value="PO"  size="5" maxlength="20"	 validate="Route,metachar,no" />
			<input type="hidden" name="total1" tabindex="1" id="total1" />
		</td>
		
		<td><input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>
			</td>
			<td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td>
		<td><input type="text" name="closingStock1" tabindex="1" value="" id="closingStock1"  size="6"  validate="closingStock,metachar,no" /></td>
		
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid','hdb',this);" tabindex="1" />
			</td>
		
	</tr>

	<input type="hidden" name="hdb" value="1" id="hdb" />
</table>
</div>

<div class="Clear"></div>



<div class="Block">
<label>Referred to MH</label>
<input type="checkbox" name="referedToMH" class="radio" id="referedToMH" value="y" onclick="checkReferToMh();"/>


<div id="mhDiv" style="display: none">
<label>MH Name</label>
<input name="mh" type="text" tabindex="1" maxlength="32" id="mh" size="20"  />

<label>Department</label>
<input name="mhDepartment" type="text" tabindex="1" maxlength="32" id="mhDepartment" size="20"  />
<div class="clear"></div>
<label>Referred For</label>
<input name="mhReferredFor" type="text" tabindex="1" maxlength="50" id="mhReferredFor" size="20"  />
</div>
<%-- <label >Additional Advice</label>
<textarea name="presentAdvice" cols="50" rows="0" maxlength="300" 	tabindex="1" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"class="auto"></textarea>--%>
	<div id="disposalDiv" style="display: inline">
<label >Additional Advice</label>
<textarea name="presentAdvice" cols="50" rows="0" maxlength="300" 	tabindex="1" onkeyup="return ismaxlength(this)" class="auto">Review SOS</textarea>
<div class="clear"></div>

<label class="auto">Disposal</label>
<select name="disposal" id="disposalId">
<option value="0">select</option>
	<%
	if(disposalList.size() > 0){
		for(MasDisposal masDisposal: disposalList){
		%>
		<option value="<%=masDisposal.getDisposalName() %>"><%=masDisposal.getDisposalName() %></option>
	<%}
	}
%>
</select>


<div id="daysDiv">
<label>Days</label>
<input name="diposalDays" type="text" tabindex="1" maxlength="2" id="days" size="20"  />
</div>
</div>
	
<div class="Clear"></div>
 <label>Next Visit Date  </label> 
 <input type="text" name="nextVisiDate" id="nextVisiDate" value="" maxlength="10"  class="calDate" onkeyup="mask(this.value,this,'2,5','/');" onblur="if(this.value!=''){validateExpDate(this,'medCatDate');checkDateGreaterEqualToCurrent(this.value,this);}"/>
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.wellBaby.nextVisiDate,event)" /> 
	<div class="Clear"></div>
	</div>


<div class="division"></div>
<div class="clear"></div>
<h4>WHO Growth Chart</h4>
<div class="clear"></div>

<div class="cmntable">
<table>

<tr>
<th>Age</th>
<th>Weight(Kg)</th>
<th>Expected Weight For Age</th>
<th>Height(cm)</th>
<th>Expected Height For Age</th>
<th>BMI(kg/m2)</th>
<th>Expected BMI For Age</th>
</tr>
<td><select name="growthAge" id="growthId" tabindex="1" onchange="displayGrowthChartValues(this.value);" >
			<option value="0">Select</option>
			<%for(int m =5; m<=18; m++){ %>
		<option value="<%=m %>"><%=m %></option>
		<%} %>
		</select></td>
<td><input type="text" name="growthWeight" id="growthWeight" value="" /></td>
<td><input type="text" name="expectedWeight" id="expectedWeight" value="" /></td>
<td><input type="text" name="growthHeight" id="growthHeight" value="" /></td>
<td><input type="text" name="expectedHeight" id="expectedHeight" value="" /></td>
<td><input type="text" name="growthBmi" id="growthBmi" value="" /></td>
<td><input type="text" name="expectedBmi" id="expectedBmi" value="" /></td>
</tr>

</table>
</div>
<div class="clear"></div>

<input name="Submit" type="button"	tabindex="1" align="right" class="button" value="Submit" onclick="submitForm('wellBaby','fwc?method=submitPediatricsDetail&flag=WELL BABY');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<script type="text/javascript">
function checkReferToMh (){
	 if(document.getElementById('referedToMH').checked == true){
		 document.getElementById('mhDiv').style.display = 'block'
			 document.getElementById('disposalDiv').style.display = 'none'
	 }else{
		 document.getElementById('mhDiv').style.display = 'none'
		  document.getElementById('disposalDiv').style.display = 'inline'	
	 }
}

function openPopupPrescriptions(visitId,visitNo,deptId,hinId,reportingFor)
{
	
 var url="/hms/hms/opd?method=showPatientPreviousVisitForPrescriptionReport&visitId="+visitId+"&visitNo="+visitNo+"&deptId="+deptId+"&hinId="+hinId+"&reportingFor="+reportingFor;
 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
	 //alert("Detention Advice ....");
}

function openPopupInvestigation(visitId,visitNo,deptId,hinId,reportingFor)
{
 var url="/hms/hms/opd?method=showPatientPreviousVisitForInvestigationReport&visitId="+visitId+"&visitNo="+visitNo+"&deptId="+deptId+"&hinId="+hinId+"&reportingFor="+reportingFor;
//opd?method=showPatientPreviousVisitForInvestigationReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>"
 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
	 //alert("Detention Advice ....");
}

function  fillValueFromFrequency(value,inc){
  var dosage = document.getElementById('dosage'+inc).value
 var noOfDays=document.getElementById('noOfDays'+inc).value
 var freq=document.getElementById('frequencyValue'+inc).value
 document.getElementById('total'+inc).value=noOfDays*freq*dosage
 var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
 var total = freq*noOfDays*dosage;
 var finalQty;
 if(document.getElementById('actualDispensingQty'+inc).value != 0){
	  var totalQty = (total/parseFloat(dispenseQty)).toFixed(2)
	  if(totalQty != 0){
		  finalQty = Math.ceil(totalQty);
	  }
	 /*var arr = new Array();
	  arr = totalQty.split(".");
	  var qtyA;var qtyB;var finalQty;
	  if(arr[0] != "" && arr[0] != null){
		  qtyA = parseFloat(arr[0]);
	  }else{
		  qtyA = 0;
	  }
	  if(arr[1] != "" && arr[1] != null){
		  qtyB = parseFloat(arr[1]);
	  }else{
		  qtyB = 0;
	  }
	  if(qtyA == 0){
		  finalQty = 1;
	  }else if(qtyB ==0){
		 finalQty = qtyA;
		  
	  }else if(qtyB >0){
		  finalQty = qtyA+1;
	  }*/
	  document.getElementById('total'+inc).value=finalQty;

}else{
	  document.getElementById('total'+inc).value=noOfDays*freq*dosage
 }
}
function displayInv(inc){
	if(inc.checked){
		document.getElementById('followUpDiv').style.display='inline';
	}else if(!inc.checked){
		document.getElementById('followUpDiv').style.display='none';
	}
}
function displayGrowthChartValues(val){
	 	genderId = document.getElementById('genderId').value;
	  //obj.length = 1;
		if(val != "")
		{
		var xmlHttp;
		  try {
		    // Firefox, Opera 8.0+, Safari
		    xmlHttp=new XMLHttpRequest();
		  }catch (e){
		    // Internet Explorer
		    try{
		      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		    }catch (e){
		    	alert(e)
		      try{
		        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }catch (e){
		        alert("Your browser does not support AJAX!");
		        return false;
		      }
		     }
		   }
		
		    xmlHttp.onreadystatechange=function()
		    {
		      if(xmlHttp.readyState==4){
		      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		      	for (loop = 0; loop < items.childNodes.length; loop++) {
			   	    var item = items.childNodes[loop];
			   	  var expectedWeight  = item.getElementsByTagName("expectedWeight")[0];
			   	var expectedHeight  = item.getElementsByTagName("expectedHeight")[0];
			   	var expectedBmi  = item.getElementsByTagName("expectedBmi")[0];
			      		   		   	  
			   	if(document.getElementById('expectedWeight') && expectedWeight.childNodes[0] != undefined ){
		        	document.getElementById('expectedWeight').value = expectedWeight.childNodes[0].nodeValue;
		        }else{
		        	document.getElementById('expectedWeight').value = "";
		        }
			   	if(document.getElementById('expectedHeight') && expectedHeight.childNodes[0] != undefined ){
		        	document.getElementById('expectedHeight').value = expectedHeight.childNodes[0].nodeValue;
		        }else{
		        	document.getElementById('expectedHeight').value = "";
		        }
			   	if(document.getElementById('expectedBmi') && expectedBmi.childNodes[0] != undefined ){
		        	document.getElementById('expectedBmi').value = expectedBmi.childNodes[0].nodeValue;
		        }else{
		        	document.getElementById('expectedBmi').value = "";
		        }
			       
		      	} 
		      }
		      }
		    var url="/hms/hms/fwc?method=displayGrowthChartValue&growthChartAge="+val+"&genderId="+genderId;
		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);
		}
    }

function displayMilestoneNormalRange(val,inc){
	 if(val == '1'){
		document.getElementById('normalAgeRange'+inc).value ='2-3' 
	 }else if(val == '2'){
		 document.getElementById('normalAgeRange'+inc).value ='3' 
	 }else if(val == '3'){
		 document.getElementById('normalAgeRange'+inc).value ='4-5' 
	 }else if(val == '4'){
		 document.getElementById('normalAgeRange'+inc).value ='6-7' 
	 }else if(val == '5'){
		 document.getElementById('normalAgeRange'+inc).value ='9' 
	 }else if(val == '6'){
		 document.getElementById('normalAgeRange'+inc).value ='9-10' 
	 }else if(val == '7'){
		 document.getElementById('normalAgeRange'+inc).value ='10-12' 
	 }else if(val == '8'){
		 document.getElementById('normalAgeRange'+inc).value ='12' 
	 }else if(val == '9'){
		 document.getElementById('normalAgeRange'+inc).value ='12' 
	 }else if(val == '10'){
		 document.getElementById('normalAgeRange'+inc).value ='15-18' 
	 }else if(val == '11'){
		 document.getElementById('normalAgeRange'+inc).value ='24' 
	 }
}
function getImmunizationId(immu,rowval){
	 var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	 
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		       
		        var immunizationId  = item.getElementsByTagName("immunizationId")[0];
		        document.getElementById('immunizationId'+rowval).value = immunizationId.childNodes[0].nodeValue;
		               
	      	} 
	      }
	    }

	    var index1 = immu.lastIndexOf("[");
	    var index2 = immu.lastIndexOf("]");
	    index1++;
	    var immunization = immu.substring(index1,index2);
	  if(immunization!=''){
	  	 var url="/hms/hms/fwc?method=getImmunizationId&immunizationCode="+immunization+"&rowval="+rowval;
	  
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	  }
}


function addRowMilestone(){
    
	  var tbl = document.getElementById('milstoneGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	  // alert("iteration row--"+iteration)

	  var cellRight0 = row.insertCell(0);
	  var e1 = document.createElement('Select');
	  e1.name='childMilestone'+iteration;
	  e1.id='childMilestone'+iteration;
	 // e1.className='medium';
	  //e2.class = 'medium';
	   e1.tabindex = '1';
	  e1.options[0] = new Option('Select', '0');
	  e1.onchange=function(){displayMilestoneNormalRange(this.value,iteration);}; 
	   for(var k = 0;k<milestoneArr.length;k++ ){
	      e1.options[k+1] = new Option(milestoneArr[k][1],milestoneArr[k][0]);
	      }
	  cellRight0.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(1);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='result'+iteration;
	  e2.id='result'+iteration
	  e2.size='20';
	  e2.tabindex = '1';
	  cellRight1.appendChild(e2);

	  var cell2 = row.insertCell(2);
	  cell2.innerHTML='Months'

	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='normalAgeRange'+iteration;
	  e3.id='normalAgeRange'+iteration
	  e3.size='20';
	  e3.tabindex = '1';
	  cellRight3.appendChild(e3);

	  var cellRight4 = row.insertCell(4);
	  cellRight4.innerHTML='Months'

	  var cellRight5 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='remarks'+iteration;
	  e4.id='remarks'+iteration
	  e4.size='20';
	  e4.tabindex = '1';
	  cellRight5.appendChild(e4);
	  

	 var cellRight6 = row.insertCell(6);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonAdd';
	  e5.name='Button';
	  e5.tabindex = '1';
	  e5.onclick = function(){addRowMilestone();};
	  cellRight6.appendChild(e5);

	  var cellRight7 = row.insertCell(7);
	  var e6 = document.createElement('input');
	  e6.type = 'button';
	  e6.className = 'buttonDel';
	  e6.name='delete';
	  e6.tabindex = '1';
	  //e6.setAttribute('onClick','removeRow();');
	  e6.onclick = function(){removeRow("milstoneGrid","hdb",this);}; 
	  cellRight7.appendChild(e6);
	  

	}
function removeRow(idName,countId,obj)
{
  var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
  }
}
function addRowForImmunisation(){
	
	  var tbl = document.getElementById('immunizationgrid');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('count');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight11 = row.insertCell(0);
      var e0 = document.createElement('Select');
	  e0.name = 'vaccineAge' + iteration;
	  e0.id = 'vaccineAge' + iteration;
	 // e0.className='medium';
	  e0.setAttribute('tabindex','1');
	  e0.options[0] = new Option('Select', 'Select');
	  e0.options[1] = new Option('Birth', 'Birth');
	  e0.options[2] = new Option('6 Weeks', '6 Weeks');
	  e0.options[3] = new Option('14 Weeks', '14 Weeks');
	  e0.options[4] = new Option('9 Months', '9 Months');
	  e0.options[5] = new Option('16-24 Months', '16-24 Months');
	  e0.options[6] = new Option('2 Years', '2 Years');
	  e0.options[7] = new Option('4-6 Years', '4-6 Years');
	  e0.options[8] = new Option('10 Years', '10 Years');
	  e0.options[9] = new Option('16 Years', '16 Years');
	  e0.onchange = function(){displayVaccine(this.value,iteration);}; 
      cellRight11.appendChild(e0);
     
	  var cell1 = row.insertCell(1);
	  var e1 = document.createElement('Select');
	  e1.name='immunizationId'+iteration;
	  e1.id='immunizationId'+iteration
	  e1.setAttribute('tabindex','1');
	  e1.options[0] = new Option('Select', 'Select');
	  cell1.appendChild(e1);
	  
	 /* var e11 = document.createElement('input');
 	  e11.type = 'hidden';
	  e11.name='immunizationId'+iteration;
	  e11.id='immunizationId'+iteration
	  cell1.appendChild(e11);

	  var e12 = document.createElement('input');
	  e12.type = 'hidden';
	  e12.name='immunId'+(iteration);
	  e12.id='immunId'+(iteration);
	  e12.value='0';
	  cell1.appendChild(e12);*/
	  
	  var cell2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='immuDate'+iteration;
	  e2.id='immuDate'+iteration
	  e2.size = '10';
	  e2.tabindex='1';
	  var e2Img = document.createElement('img');
	  e2Img.src = '/hms/jsp/images/cal.gif';
	  e2Img.className = 'calender';
	  e2Img.id = 'calender'+iteration;
	  e2Img.onclick = function(event){
					setdate('',document.getElementById('immuDate'+iteration),event) };
	  cell2.appendChild(e2);
	  cell2.appendChild(e2Img);
	  
	  

	  var cell3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='dueDate'+iteration;
	  e3.id='dueDate'+iteration
	  e3.size = '10';
	  e3.setAttribute('tabindex','1');
	  var e3Img = document.createElement('img');
	  e3Img.src = '/hms/jsp/images/cal.gif';
	  e3Img.className = 'calender';
	  e3Img.id = 'calender'+iteration;
	  e3Img.onclick = function(event){
					setdate('',document.getElementById('dueDate'+iteration),event) };
	  cell3.appendChild(e3);
	  cell3.appendChild(e3Img);

	  
	  var cell4 = row.insertCell(4);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name='dose'+iteration;
	  e5.id='dose'+iteration
	  e5.size = '5';
	  e5.maxLength = '5';
	  e5.tabindex='1';
	  cell4.appendChild(e5);


	  var cell5 = row.insertCell(5);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name='route'+iteration;
	  e6.id='route'+iteration
	  e6.maxLength = '5';
	  e6.size = '10';
	  e6.tabindex='1';
	  cell5.appendChild(e6);
	  
	  var cell6 = row.insertCell(6);
	  var e7 = document.createElement('input');
	  e7.type = 'button';
	  e7.className = 'buttonAdd';
	  e7.name='Button'+iteration;
	  e7.onclick = function(){addRowForImmunisation();}; 
	  e7.tabindex='1';
	  cell6.appendChild(e7);

	  var cell7 = row.insertCell(7);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonDel';
	  e8.name='delete'+iteration;
	  e8.onclick = function(){removeRow("immunizationgrid","hdb",this);}; 
	  e8.tabindex='1';
	  cell7.appendChild(e8);
}

function displayVaccine(val,inc){
	  obj = document.getElementById('immunizationId'+inc);
	  obj.length = 1;
		if(val != "")
		{
		var xmlHttp;
		  try {
		    // Firefox, Opera 8.0+, Safari
		    xmlHttp=new XMLHttpRequest();
		  }catch (e){
		    // Internet Explorer
		    try{
		      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		    }catch (e){
		    	alert(e)
		      try{
		        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }catch (e){
		        alert("Your browser does not support AJAX!");
		        return false;
		      }
		     }
		   }
		
		    xmlHttp.onreadystatechange=function()
		    {
		      if(xmlHttp.readyState==4){
		      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		      	for (loop = 0; loop < items.childNodes.length; loop++) {
			   	    var item = items.childNodes[loop];
			       var vacLength = item.getElementsByTagName("vacs")[0];
			      
			   	for(innerLoop = 0;innerLoop < vacLength.childNodes.length;innerLoop++)
	        	{
	        		var immunization = vacLength.childNodes[innerLoop];
		        	var immu  = immunization.getElementsByTagName("vaccine")[0];
		        	var immuId  = immunization.getElementsByTagName("vaccineId")[0];
		        	obj.length++;
		        	
					obj.options[obj.length-1].value=immuId.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=immu.childNodes[0].nodeValue;
		        	
	        	}
			   	  
			        /*if(vaccine.childNodes[0] != undefined ){
			        	document.getElementById('immunizationName'+inc).value = vaccine.childNodes[0].nodeValue;
			        }*/
			        
			       
		      	} 
		      }
		      }
		    var url="/hms/hms/fwc?method=displayVaccine&vaccineAge="+val;
		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);
		}
	}	

function showHideInvestigationTemplateCombo(){
	var invId="";
	var sel = document.getElementById("investigationTemplateId");
	var listLength = sel.options.length;
	//alert("listLength--->"+listLength);
	
	for(var i=0;i<listLength;i++){
	   if(sel.options[i].selected){
			if(invId!=""){
				invId=invId+","+sel.options[i].value;
				}else{
					invId=sel.options[i].value;
			}
			
	   }
	}
		//alert("invId==="+invId);
	//if(checkTemplateId(valueOfTemplate)){
	  	document.getElementById("copyPrevInvestigationTemplateDiv").style.display='none';//'+invId
submitProtoAjaxWithDivName('wellBaby','/hms/hms/opd?method=showGridForInvestigation&investigationTemplateId='+invId,'gridview');
			
			}

function checkTemplateId(templateId){

  if(templateId=="0"){
    return true;
  }else{
    return true;
  }
}

function addRow(){
	  
	  var tbl = document.getElementById('grid');
	 
	  var lastRow = tbl.rows.length;
	//alert("tbl length---"+lastRow);
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration
	//  alert("1---");
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 
	 // e0.innerHTML = iteration+':'
	//  alert("2---");
	e0.name = 'nomenclature' + iteration;
	  e0.id = 'nomenclature' + iteration;
	  e0.onblur=function(){
	                       var val=e0.value
	                       if(val != "")
							{
						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);

						   	if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclature'+iteration).value="";
	   								document.getElementById('pvmsNo'+iteration).value="";
						     return;
						    }
						    else
	      						document.getElementById('pvmsNo'+iteration).value=pvmsNo
	      						checkItem(iteration);disableOtherMedicine(this.value,iteration);displayAu(this.value,iteration);
						   }
	  					  };
	  
	var newdiv = document.createElement('div');
  	newdiv.setAttribute('id', 'ac2update'+iteration);
  	newdiv.setAttribute('class', 'autocomplete');
   	newdiv.style.display = 'none';
e0.size = '30';
	//  alert("3-1--");
	  e0.setAttribute('tabindex','1');
	//  alert("3-2--");
	  cellRight0.appendChild(newdiv);
	  cellRight0.appendChild(e0);
	  e0.focus();
	
	//  alert("3--3-"+iteration);
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});
	   //alert("name--"+e0.name)
//alert("4---");
	   <%--  var cellRight1 = row.insertCell(1);
	    var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/search.gif';
	  eImg.name = 'search' + iteration;
	  eImg.id = 'search' + iteration;
	  eImg.WIDTH = '26';
	  eImg.HEIGHT = '26';
	  //eImg.id = 'billDateId'+iteration;
	  eImg.onclick = function(){
	   var url="/hms/hms/opd?method=showItemSearchJsp&count="+iteration;
	    newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0"); };
	  cellRight1.appendChild(eImg);--%>
	//  alert("5---");
	
	 var cellRight1 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='otherMedicine'+iteration;
	  e11.id='otherMedicine'+iteration
	  e11.size='20';
	  e11.setAttribute('tabindex','1');
	  e11.onblur=function(){readOnlyNomenclature(this.value,iteration)};
	  cellRight1.appendChild(e11);

	  var cellRight2 = row.insertCell(2);
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='actualDispensingQty'+iteration;
	  e1.id='actualDispensingQty'+iteration
	  e1.size='6';
	  e1.setAttribute('tabindex','1');
	  var e12 = document.createElement('input');
	  e12.type = 'text';
	  e12.name='au'+iteration;
	  e12.id='au'+iteration
	  e12.size='6';
	  e12.setAttribute('tabindex','1');
	  //e12.onblur=function(){displayAU(this.value,iteration)};
	  cellRight2.appendChild(e12);

	 
	  cellRight2.appendChild(e1);
	  

	 /* var cellRight3 = row.insertCell(3);
	  var e31 = document.createElement('input');
	  e31.type = 'checkbox';
	  e31.name='injCategory'+iteration;
	  e31.id='injCategory'+iteration
	  e31.size='10';
	  e31.className='radio';
	  e31.value='y';
	  e31.setAttribute('tabindex','1');
	  cellRight3.appendChild(e31);*/

	  var cellRight3 = row.insertCell(3);
	  var e13 = document.createElement('input');
	  e13.type = 'text';
	  e13.name='dosage'+iteration;
	  e13.id='dosage'+iteration
	  e13.size='5';
	  e13.setAttribute('maxlength', 5); 
	  e13.setAttribute('tabindex','1');
	  e13.onblur = function(){checkDosageValidation(this.value,iteration)};
	  cellRight3.appendChild(e13);
	  
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight3.appendChild(sel);
	
	 
	//  var cellRightSel = row.insertCell(2);
	 
	  var cellRight4 = row.insertCell(4);
	  var e2 = document.createElement('Select');
	  e2.name='frequency'+iteration;
	  e2.id='frequency'+iteration;
	  e2.className='medium';
	  //e2.class = 'medium';
	  e2.setAttribute('tabindex','1');
	  e2.options[0] = new Option('Select', '0');
	  e2.onblur=function(){fillValueFromFrequency(this.value,iteration);getFrequencyValue(this.value,iteration)};
	   for(var i = 0;i<icdArray.length;i++ ){
	      e2.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	  cellRight4.appendChild(e2);

	  	var e52 = document.createElement('input');
		e52.type = 'text';
		e52.name='sosQty'+iteration;
		e52.id='sosQty'+iteration;
		e52.tabIndex='1';
		e52.size='3';
		e52.style.display='none';
		e52.setAttribute('maxlength', 3); 
	    e52.onblur=function(){fillValue(this.value,iteration)};
		cellRight4.appendChild(e52);

	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='frequencyValue'+iteration;
	  e21.id='frequencyValue'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight4.appendChild(e21);
	  	  
	  var cellRight5 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='3';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','noOfDays,int,yes');
	  e4.onblur=function(){fillValue(this.value,iteration)};
	  cellRight5.appendChild(e4);

	  var e5 = document.createElement('input');
	  e5.type = 'hidden';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	  cellRight5.appendChild(e5);

		var cellRight6 = row.insertCell(6);
		var e6 = document.createElement('input');
		e6.type = 'text';
		e6.name='route'+iteration;
		e6.id='route'+iteration
		e6.size='5';
		e6.value='PO'
		e6.setAttribute('maxlength', 20); 
		e6.setAttribute('tabindex','1');
		cellRight6.appendChild(e6);

	  var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='remarks'+iteration;
	  e7.id='remarks'+iteration
	  e7.size='10';
	  e7.setAttribute('maxlength', 40); 
	  e7.setAttribute('tabindex','1');
	  cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(8);
	  var e71 = document.createElement('input');
	  e71.type = 'checkbox';
	  e71.name='ct'+iteration;
	  e71.id='ct'+iteration
	  e71.size='10';
	  e71.className='radio';
	  e71.value='y';
	  e71.setAttribute('tabindex','1');
	  cellRight8.appendChild(e71);

	  var cellRight9 = row.insertCell(9);
	  var e72 = document.createElement('input');
	  e72.type = 'text';
	  e72.name='closingStock'+iteration;
	  e72.id='closingStock'+iteration
	  e72.size='6';
	  e72.setAttribute('tabindex','1');
	  cellRight9.appendChild(e72);

	  var cellRight10 = row.insertCell(10);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='remarks'+iteration;
	 // e8.setAttribute('onClick', 'addRow();');
	  e8.onclick = function(){addRow();}; 
	  e8.setAttribute('tabindex','1');
	  cellRight10.appendChild(e8);

	  var cellRight11 = row.insertCell(11);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='remarks'+iteration;
	  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
	  e9.onclick = function(){removeRow("grid","hdb",this);}; 
	  e9.setAttribute('tabindex','1');
	  cellRight11.appendChild(e9);

	}

function getFrequencyValue(feqValue,inc){
	var feqQty;
<%
if(frequencyList.size()>0){	
	for(MasFrequency freq :frequencyList){
%>
 if(feqValue == '<%=freq.getId()%>'){
	 feqQty = '<%=freq.getFeq()%>'
  }
<%}
}%>
 document.getElementById('frequencyValue'+inc).value = feqQty;
}

function  fillValue(value,inc){
	  var dosage = document.getElementById('dosage'+inc).value
	  var freq=document.getElementById('frequencyValue'+inc).value
	  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
	  var sosQty = document.getElementById('sosQty'+inc).value;
	  var total = freq*value*dosage;
	  var finalQty;
	  if(document.getElementById('frequency'+inc).value != 13 ){
	  if(document.getElementById('actualDispensingQty'+inc).value != 0){
		  var totalQty = (total/parseFloat(dispenseQty)).toFixed(2)
		  if(totalQty != 0){
			  finalQty = Math.ceil(totalQty);
		  }
		  document.getElementById('total'+inc).value=finalQty;
		 }else{
			// alert("==in else==");
			  document.getElementById('total'+inc).value=freq*value*dosage
		  }
	  }else{
		  if(document.getElementById('actualDispensingQty'+inc).value != 0){
			  var totalQty = ((freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
			  if(totalQty != 0){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('total'+inc).value=finalQty;
			 }else{
				// alert("==in else==");
				  document.getElementById('total'+inc).value=freq*value*dosage
			  }

	  }
	  
	 }

function readOnlyNomenclature(val,inc){
	if(val != ""){
		//alert("Please confirm PVMS/NIV is not available");
		 document.getElementById('nomenclature'+inc).readOnly = true;
		 document.getElementById('au'+inc).readOnly = true;				
	     document.getElementById('nomenclature'+inc).value ="";
	     if(document.getElementById('itemId'+inc)){
	    	 document.getElementById('pvmsNo'+inc).value = "";
	     }
	  }else{
		document.getElementById('nomenclature'+inc).readOnly = false;
		 document.getElementById('au'+inc).readOnly = false;			

	  }
   }

function populatePVMS(val,inc){
	//alert("in method--")
	if(val != "")
	{
	    var index1 = val.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvmsNo = val.substring(index1,index2);
	    var indexForBrandName=indexForBrandName--;
	    var brandName=val.substring(0,indexForBrandName);
	   //  alert("pvms no--"+pvmsNo)

  if(pvmsNo == "")
  {
   // alert("pvms no1111--"+pvmsNo)
   	document.getElementById('nomenclature'+inc).value="";
    document.getElementById('pvmsNo'+inc).value="";
   return;
   }
   else
      document.getElementById('pvmsNo'+inc).value=pvmsNo


 }
}
function disableOtherMedicine(val,inc){
	//alert("sdfsdfsd"+val+"inc==="+inc);
  if(val != "")
	{
   document.getElementById('otherMedicine'+inc).readOnly = true;		
   document.getElementById('otherMedicine'+inc).value ="";
  // document.getElementById('itemConversionId'+inc).disabled = true;
  // document.getElementById('itemConversionId'+inc).value = "";
   //document.getElementById('injCategory'+inc).disabled = true;	
   
	}else{
		document.getElementById('otherMedicine'+inc).readOnly = false;
		//document.getElementById('itemConversionId'+inc).disabled = false;
		//document.getElementById('injCategory'+inc).disabled = false;	

	}
}


</script>
<script type="text/javascript">
function addRowForInvestigation(){
    
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	  // alert("iteration row--"+iteration)
 
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){

	  						if(validateInvestigationAutoComplete(this.value,iteration)){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration);}

	  					  };
	   var newdiv1 = document.createElement('div');
	  newdiv1.setAttribute('id', 'ac2update'+iteration);
	  newdiv1.setAttribute('class', 'autocomplete');
	  newdiv1.style.display = 'none';
	  					
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.setAttribute('tabindex','1');
	  //alert("name--"+e0.name)
	  e0.size = '100'
	  cellRight0.appendChild(newdiv1);
	  
	  cellRight0.appendChild(e0);
	  e0.focus();
	
	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='chargeCode'+iteration;
	  sel.id='chargeCode'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight0.appendChild(sel);

	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='qty'+iteration;
	  e2.id='qty'+iteration
	  e2.size='10';
	  e2.setAttribute('tabindex','1');
	  cellRight0.appendChild(e2);
	  
	  var cellRight1 = row.insertCell(1);
	  var e3 = document.createElement('input');
	  e3.type = 'checkbox';
	  e3.name='referToMh'+iteration;
	  e3.id='referToMhId'+iteration
	  e3.size='10';
	  e3.className='radio';
	  e3.value='y';
	  e3.setAttribute('tabindex','1');
	  cellRight1.appendChild(e3);

	 var cellRight2 = row.insertCell(2);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonAdd';
	  e4.name='Button';
	  e4.setAttribute('tabindex','1');
	  //e4.setAttribute('onClick','addRowForInvestigation();');
	  e4.onclick = function(){addRowForInvestigation("grid","hdb",this);}; 
	  cellRight2.appendChild(e4);

	  var cellRight3 = row.insertCell(3);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.name='delete';
	  e5.setAttribute('tabindex','1');
	  //e5.setAttribute('onClick','removeRow("investigationGrid","hdb",this);');
	  e5.onclick = function(){removeRow("investigationGrid","hdb",this);}; 
	  cellRight3.appendChild(e5);
	  

	}

function removeRow(idName,countId,obj)
{
var tbl = document.getElementById(idName);
var lastRow = tbl.rows.length;
if (lastRow > 2){
//	tbl.deleteRow(lastRow - 1);
  var i=obj.parentNode.parentNode.rowIndex;
  tbl.deleteRow(i);
}
}


function openWindow(url){

	 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
    
	
}
</script>
</form>
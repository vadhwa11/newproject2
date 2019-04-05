
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.DIAGNOSIS_ID"%>
<%@page import="jkt.hms.masters.business.AllergyDetail"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%@page import="jkt.hms.masters.business.PhysioRequisitionDetail"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>

<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.ProcedureHeader"%>
<%@page import="jkt.hms.masters.business.PhysioRequisitionHeader"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>


<%@page import="jkt.hms.masters.business.IpdPatientDiet"%>

<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<form name="ipdCaseSheet" method="post">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String) utilMap.get("currentTime");
	 
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	if(map.get("inpatientList") != null)
	{
		inpatientList=(List<Inpatient>)map.get("inpatientList");
	}
	List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
	if(map.get("opdDetailsList") != null)
	{
		opdDetailsList=(List<OpdPatientDetails>)map.get("opdDetailsList");
	}
	
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null){
	frequencyList=(List)map.get("frequencyList");
	}
	List<MasIcd> masIcdList = new ArrayList<MasIcd>();
	if(map.get("masIcdList") != null){
		masIcdList=(List<MasIcd>)map.get("masIcdList");
	}
	List<MasDiet> dietTypeList = new ArrayList<MasDiet>();
	if(map.get("dietTypeList") != null){
		dietTypeList =(List<MasDiet>)map.get("dietTypeList");
	}
	List templateList= new ArrayList();
	if(map.get("templateList") != null){
	templateList=(List)map.get("templateList");
	}
	List<PatientPrescriptionHeader> opdPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
	List<PatientInvestigationHeader> opdInvestigationList = new ArrayList<PatientInvestigationHeader>();
	List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
	List<ProcedureHeader> opdProcedureList = new ArrayList<ProcedureHeader>();
	List<PhysioRequisitionHeader> opdPhysiotherapyList = new ArrayList<PhysioRequisitionHeader>();
	List<OpdPatientHistory> opdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
	List<IpdPatientDiet> ipdPatientDietList= new ArrayList<IpdPatientDiet>();

	if(map.get("opdPrescriptionList") != null){
		opdPrescriptionList=(List<PatientPrescriptionHeader>)map.get("opdPrescriptionList");
	}
	if(map.get("opdInvestigationList") != null){
		opdInvestigationList=(List<PatientInvestigationHeader>)map.get("opdInvestigationList");
	}
	if(map.get("icdList") != null){
		icdList=(List<DischargeIcdCode>)map.get("icdList");
	}
	if(map.get("opdProcedureList") != null){
		opdProcedureList=(List<ProcedureHeader>)map.get("opdProcedureList");
	}
	if(map.get("opdPhysiotherapyList") != null){
		opdPhysiotherapyList=(List<PhysioRequisitionHeader>)map.get("opdPhysiotherapyList");
	}
	List<PatientFamilyHistory> familyHistoryList = new ArrayList<PatientFamilyHistory>();
	if(map.get("familyHistoryList") != null){
		familyHistoryList=(List<PatientFamilyHistory>)map.get("familyHistoryList");
	}
	if(map.get("opdHistoryDetailsListForFollowUp") != null){
		opdHistoryDetailsListForFollowUp=(List)map.get("opdHistoryDetailsListForFollowUp");
	}
	if(map.get("ipdPatientDietList") != null){
		ipdPatientDietList=(List)map.get("ipdPatientDietList");
	}
	List<OpdPatientDetails> caseSheetList = new ArrayList<OpdPatientDetails>();
	if(map.get("caseSheetList") != null)
	{
		caseSheetList=(List<OpdPatientDetails>)map.get("caseSheetList");
	}
	
	OpdPatientHistory opdPatientHistory = null;
	
	if(opdHistoryDetailsListForFollowUp.size()>0){
		opdPatientHistory = opdHistoryDetailsListForFollowUp.get(0);
	}
	
	Patient patient = new Patient();
	Inpatient inpatient = new Inpatient();
	String patientName ="";
	String consultantName = "";
	String currentAge = "";
	if(inpatientList.size() >0){
		patient = inpatientList.get(0).getHin();
		inpatient = inpatientList.get(0);
		patientName=patient.getPFirstName()+" "+(patient.getPMiddleName() != null?patient.getPMiddleName():"")+" "+(patient.getPLastName() != null?patient.getPLastName():"");
	
		if(inpatient.getDoctor() !=null)
			consultantName=inpatient.getDoctor().getRank().getRankName();
		if(inpatient.getDoctor().getFirstName() != null)
		{
			consultantName+=" "+inpatient.getDoctor().getFirstName();	
		}
		if(inpatient.getDoctor() !=null)
		if(inpatient.getDoctor().getMiddleName() != null)
		{
			consultantName+= " "+inpatient.getDoctor().getMiddleName();
		}
		if(inpatient.getDoctor() !=null)
		if(inpatient.getDoctor().getLastName() != null)
		{
			consultantName+=" "+inpatient.getDoctor().getLastName();
		}
		String age = "";

	    if(patient.getAge()!=null)
			age = patient.getAge();
		try{
			if(!age.equals(""))
			currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
%>


<div class="titleBg"><h2>Case Sheet</h2></div>

<h4>Patient Details</h4>
<div class="Clear"></div>
<div class="Block">

<label>A&D No.</label> <%if(inpatient.getAdNo() != null){ %>
<label class="value"><%=inpatient.getAdNo() %></label> <%}else{ %>
<label class="value">-</label>
<%} %>
<label>Service No.</label> 
<label class="value"> <%=patient.getServiceNo()!=null?patient.getServiceNo():"" %></label>

<label>Ward </label> <%if(inpatient.getDepartment() != null){ %>
<label class="value"> <%=inpatient.getDepartment().getDepartmentName() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<div class="Clear"></div>
<label>Patient Name</label>
<label	class="value"> <%= patientName %></label>

<label>Relation</label> <%
	if(patient.getRelation() != null){
	%> 
<label class="value"><%= patient.getRelation().getRelationName()%></label>
<%} else{ %> <label
	class="value">-</label> 
	<% }%> 

<label>Rank</label>
<label class="value"><%=patient.getRank().getRankName() %></label>
<div class="Clear"></div>
<label>Name</label> <%
		String sMiddleName = "";
		String sLastName = "";
		if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
		
			if(patient.getSMiddleName() != null){
				sMiddleName = patient.getSMiddleName();
			}
			if(patient.getSLastName() != null){
				sLastName = patient.getSLastName();
			}
	 %> 
<label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> 
<label class="value">-</label> 
<% }%>

<label>Branch/Trade</label>
<%
if(patient.getTrade() != null){
%> 
<label class="value"><%=  patient.getTrade().getTradeName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%>


<label>Unit</label> <%
if(patient.getUnit() != null){
%> <label class="value"><%= patient.getUnit().getUnitName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%>
<div class="Clear"></div>
<label>Age</label> <%if(!currentAge.equals("")){ %>
<label class="value"> <%=currentAge %></label> <%}else{ %>
<label	class="value">-</label> <%} %>
<label>Gender</label> <%if(patient.getSex() != null){ %>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<label>Med Cat</label>
<label class="value"><%=patient.getCategory()!=null? patient.getCategory().getCategories():""%></label>

<div class="Clear"></div>

<label>Admitting MO</label>
<label class="value"><%=consultantName %></label>

<label>Allergies</label>
<%
String allergies = "";
	if(patient.getDrugAllergies()!=null){
/*	for(AllergyDetail allergyDetail : patient.getAllergyDetails()){
		if(!allergies.equals("")){
			allergies += ",";
		}
		allergies += allergyDetail.getDescription();
	}*/
		allergies = patient.getDrugAllergies();
}%>
<%
	if(!allergies.equals("")){
%>
<label class="valueAuto"><%=allergies %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<div class="Clear"></div>

<label> Diagnosis</label> 
<%	List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
if(map.get("diagnosisList")!=null){
	diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
	
}
if(diagnosisList != null && diagnosisList.size() > 0 && diagnosisList.get(0).getIcd()!=null)
{
%> <label class="valueFixedWidth"><%=diagnosisList.get(0).getIcd().getIcdName() %></label>
<%
		}else{
		%> <label class="value"></label> <%	
		}
		%> 
<label>Disability</label>
<%
	List<MasMedicalExaminationDetail> disabilityList = new ArrayList<MasMedicalExaminationDetail>();
	if(map.get("disabilityList")!=null){
		disabilityList = (List<MasMedicalExaminationDetail>)map.get("disabilityList");
	}
	
	if(disabilityList != null && disabilityList.size() > 0)
	{
	%> <label class="valueFixedWidth"><%=disabilityList.get(0).getMasIcd()!=null?disabilityList.get(0).getMasIcd().getIcdName():"" %></label>
<%
	}else{
	%> <label class="value"></label> <%	
	}
%> 

<%-- 
<label>Date</label>
<label class="value"><%=currentDate%></label>
<div class="Clear"></div>
<label>Time</label>
<input type="text"	id="timeId" name="timeForAll" value="<%=time%>" class="calDate"	tabindex=1 onblur="fillTime(this.value)"
	onchange="IsValidTime(this.value,this.id);" /> <!--  <input type="button" class="button" value="Go" onClick="" />-->
 --%>
 <input type="hidden"	id="timeId" name="timeForAll" value="<%=time%>" class="calDate"	tabindex=1 onblur="fillTime(this.value)"
	onchange="IsValidTime(this.value,this.id);" /> <!--  <input type="button" class="button" value="Go" onClick="" />-->
 
<div class="Clear"></div>
</div>
<input name="hinId" type="hidden"	value="<%=patient.getId()%>" />
<input name="inpatientId" type="hidden"	value="<%=inpatient.getId()%>" />
<input name="adNo" type="hidden"	value="<%=inpatient.getAdNo()%>" />
<input name="hinNo" type="hidden"	value="<%=patient.getHinNo()%>" />
<input name="serviceNo" type="hidden"	value="<%=patient.getServiceNo()!=null?patient.getServiceNo():""%>" />

<div class="clear"></div>

<div class="clear"></div>
<%OpdPatientDetails opdPatientDetails =new OpdPatientDetails();
int m = 1;	
System.out.println("caseSheetList.size()-- "+caseSheetList.size());
if(caseSheetList.size() > 0){
		for(OpdPatientDetails patientDetails : caseSheetList){
			if(patientDetails.getVisit()!=null){
%>
<h5 id="prevData<%=m %>" class="plus" onclick="changeClass('prevData<%=m %>');submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ipd?method=getLastOpdDetails&opdPatientDetailsId=<%=patientDetails.getId() %>&hinId=<%=patientDetails.getVisit().getHin().getId() %>','opdDetails');return false;"><a href="" onclick="">
OPD <%=HMSUtil.convertDateToStringWithoutTime(patientDetails.getOpdDate()) %> <%=patientDetails.getOpdTime() %></a></h5>
<%}else if(patientDetails.getInpatient()!=null){ %>
<div class="clear"></div>
<h5 id="prevData<%=m %>" class="plus" onclick="changeClass('prevData<%=m %>');submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ipd?method=getLastOpdDetails&opdPatientDetailsId=<%=patientDetails.getId() %>&hinId=<%=patientDetails.getInpatient().getHin().getId() %>','opdDetails');return false;"><a href="" onclick="">
IPD <%=HMSUtil.convertDateToStringWithoutTime(patientDetails.getOpdDate()) %> <%=patientDetails.getOpdTime() %></a></h5>

<%}
			opdPatientDetails = patientDetails;
		m++;}
}%>

<div class="division"></div>	
<%

	if(opdDetailsList.size() == 0){
%>		
<div class="Block">
<label >Complaints</label>
<textarea name="presentComplain" cols="0" rows="0"  maxlength="300" validate="Complaints,string,no" value="" validate tabindex="1" onkeyup="return ismaxlength(this)"></textarea>

<label >Past Medical History</label> 
<textarea name="pastMedicalHistory" cols="0" rows="0"  maxlength="300"	value=""  tabindex="1" onkeyup="return ismaxlength(this)"></textarea>
<div class="clear"></div>
<label>Family History</label> 
<select name="familyHistory" id="familyHistory"  class="list" multiple="multiple" >
	<option value="0">Select</option>
		<%
		Set<MasMedicalExamFamilyHis> familyHisSet = new HashSet<MasMedicalExamFamilyHis>();
		if(patient.getMasMedicalExamFamilyHis() !=null){
			familyHisSet  = patient.getMasMedicalExamFamilyHis() ;
		}
			if(familyHistoryList.size() > 0){
				for(PatientFamilyHistory familyHistory : familyHistoryList){
		%>
		<option value="<%=familyHistory.getId() %>"><%=familyHistory.getPatientHistoryName() %></option>
		
		<%}
				}%>
</select>
<script type="text/javascript">

<%--for display patient history --%>
<%
	if(familyHisSet.size() > 0){
%>		
	var obj = document.getElementById('familyHistory');
	if(obj.length > 0){
		for(var i=0;i<obj.length;i++){
			bar = new Array();
			
<%			int i=0;
			for(MasMedicalExamFamilyHis meExamFamilyHis : familyHisSet){
%>
			bar[<%=i%>] = <%=meExamFamilyHis.getPatientFamilyHistory().getId()%>;
<%i++;}%>
			for(var m=0; m<bar.length;m++)
			{
				if (obj[i].value == bar[m])
				{ 
					obj[i].selected = true;
					break;
				}
			}


		}

	}
<%	}
%>
<%--end for display patient history --%>
</script>
<label >Risk Factors</label>
<textarea name="riskFactor" cols="0" rows="0"  maxlength="300"	value=""  tabindex="1" onkeyup="return ismaxlength(this)"></textarea>


<div class="clear"></div>
</div>

<div class="clear"></div>
<h4>Vitals</h4>
<div class="Block">
<label class="">Weight</label>
<input name="weight" tabindex="1" type="text" id="weight" value=""  onblur="calculateBMI()" class="auto" size="5" validate="weight,int,no" maxlength="3" />
<label class="unit">kg</label> 

<label  class="">Height</label> 
<input name="height" tabindex="1" type="text" id="height" value="" class="auto" onblur="calculateIdealWeight();calculateBMI();" size="5" validate="height,int,no"  maxlength="3" />
<label class="unit">cm</label>

 <label	class="">BMI</label> 
<input tabindex="1" type="text" id="bmi" name="bmi" readonly="readonly" maxlength="6" value="" onKeyUp="limitText(this,6);" class="auto" size="5" />
<label class="unit">kg/m<sup>2</sup></label> 
  <div class="clear"></div>
<label	class="">Ideal Weight</label>
 <input name="idealWeight" type="text" id="idealWeightId" tabindex="1" class="auto" size="5" value="" tabindex="1" validate="Ideal Weight,string,no" maxlength="3" />
 <label class="unit">kg</label> 
 <label class="">Temperature</label>
 <input name="temperature" id="tempId" type="text" tabindex="1" value="" class="auto" size="5" maxlength="5" />
 <label class="unit">&deg;F</label>
 <label	class="">Pulse</label>
 <input name="pulse" type="text" tabindex="1" value="" class="auto" size="5" tabindex="1" validate="pulse,int,no" maxlength="3" />
 <label class="unit">/min</label> 
   
   <div class="clear"></div>
   
 <label class="">BP</label>
 <input	name="bp" id="bp" type="text" tabindex="1" value="" class="auto" size="5" onblur="validateBpValue(this.value);" maxlength="7" />
 <label class="unit">mm/Hg</label>
 <label class="">RR</label>
 <input	name="rr" id="rr" type="text" tabindex="1" value="" class="auto" size="5" maxlength="3" />
 <label class="unit">/min</label>

<div class="clear"></div>
 
 <label>On Examination</label>	
<textarea name="onExamination" cols="120" rows="0" value="" maxlength="300" class="auto" tabindex="1"  onkeyup="return ismaxlength(this)"></textarea>
  <div class="clear"></div>

<div class="clear"></div>
</div>
	<%}
%>

<div class="clear"></div>
<div id="opdDetails"></div>
<div class="clear"></div>
<input type="button" class="buttonBig" value="View Clinical Chart" onClick="submitForm('ipdCaseSheet','discharge?method=showClinicalSheetReport&admissionNumber=<%=inpatient.getAdNo() %>&serviceNo=<%=inpatient.getHin().getServiceNo()!=null?inpatient.getHin().getServiceNo():"" %>','validatePatient');"	/>  
<input type="button" class="buttonBig" value="View Intake/Output" onClick="submitForm('ipdCaseSheet','ipd?method=showIntakeOutputChartReport&adNo=<%=inpatient.getAdNo() %>&reportType=summary','validatePatient');"	/>  

<!--

<input type="button" class="buttonBig" value="Clinical Chart" onClick="submitForm('ipdCaseSheet','ipd?method=showNewNursingClinicalChartJsp&parent=<%=inpatient.getId() %>','validatePatient');"	/>  
<input type="button" class="buttonBig" value="Nursing Entry" onClick="submitForm('ipdCaseSheet','ipd?method=showNewNursingCareEntryDetailsJsp&parent=<%=inpatient.getId() %>','validatePatient');"	/>  
<input type="button" class="buttonBig" value="Intake Output" onClick="submitForm('ipdCaseSheet','ipd?method=showIntakeOutputJsp&parent=<%=inpatient.getId() %>','validatePatient');"	/>
<input type="button" class="buttonBig" value="SIL/DIL" onClick="submitForm('ipdCaseSheet','ipd?method=showSilDilJsp&parent=<%=inpatient.getId() %>','validatePatient');" />
<input type="button" class="buttonBig" value="Discharge Slip" onClick="submitForm('ipdCaseSheet','discharge?method=showDischargeInputJsp&parent=<%=inpatient.getId() %>','validatePatient');"	/>  
<input type="button" class="buttonBig" value="MLC" onClick="submitForm('ipdCaseSheet','/hms/hms/adt?method=showMlcJsp&flag=ip&adNo=<%=inpatient.getAdNo() %>&parent=<%=inpatient.getId() %>','validatePatient');"	/>  
 
--><div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid1">
	<tr>
		<th scope="col">Today's Case Notes</th>

	</tr>
	<tr>
	<td><input type="text" id="caseNotes" name="clinicalNotes" tabindex="1" value="<%=opdPatientHistory!=null && opdPatientHistory.getPresentComplain()!=null?opdPatientHistory.getPresentComplain():"" %>" size="190" maxlength="200" validate="Today's Case Notes,string,no"/></td>
	</tr>
</table>
<div class="clear paddingTop15"></div>
<h4>Diagnosis</h4>
<div class="Block">


<!-- 	<label >On Examination</label>  -->
<input	type="hidden" id="systamicExam" class="large" name="systamicExam"	maxlength="200" />
<label>Working Diagnosis</label>
<input type="text" class="auto"  size="119" id="initialDiagnosis" tabindex="1" value="<%=opdPatientDetails.getInitialDiagnosis()!=null?opdPatientDetails.getInitialDiagnosis():"" %>"	name="initialDiagnosis" maxlength="100" />

<div class="clear"></div>

<label>System Diagnosis</label>

<input 	name="systemDiagnosis" value="<%=opdPatientDetails.getSystemDiagnosis()!=null?opdPatientDetails.getSystemDiagnosis().getSystemDiagnosisName()+"["+opdPatientDetails.getSystemDiagnosis().getId()+"]":"" %>"	id="systemDiagnosis" tabindex="1" class="auto"  size="119" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('systemDiagnosis','ac2update','opd?method=autoCompleteForSystemDiagnosis',{parameters:'requiredField=systemDiagnosis'});
</script>
		
<div class="clear"></div>

<label>ICD Diagnosis</label>
<input type="text" tabindex="1"	value="" id="icd"  name="icd"	class="auto"  size="55" onblur="fillDiagnosisCombo(this.value);" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
</script>
<select name="<%=DIAGNOSIS_ID%>" multiple="4" size="5" tabindex="1"  id="diagnosisId" class="listBig">
	<option value="0">Select</option>
	<%
		if(icdList.size()>0){
			for(DischargeIcdCode icdCode : icdList){
	%>
	<option value="<%=icdCode.getIcd().getIcdCode() %>" selected="selected"><%=icdCode.getIcd().getIcdName()+"["+icdCode.getIcd().getIcdCode()+"]" %></option>
	<%}
			}%>
</select>

<input type="button" class="buttonDel" value="" 	onclick="deleteDgItems(this,'diagnosisId');" align="right" />
</div>
<script type="text/javascript">	var	frequencyArray= new Array();</script>
<%
	    		MasFrequency  frequency = new MasFrequency();

			     for (int k = 0; k < frequencyList.size(); k++) {
			    	 frequency = (MasFrequency) frequencyList.get(k);
     			 %> <script>

     			frequencyArray[<%=k%>]= new Array();
     			frequencyArray[<%=k%>][0] = "<%=frequency.getId()%>";
     			frequencyArray[<%=k%>][1] = "<%=frequency.getFrequencyName()%>";
            </script> <% }%>
<div class="clear"></div>
<div class="clear paddingTop15"></div>

<h4>Treatment</h4>

<div id="templateDivToShowHide" class="floatLeft">

<div id="testDiv">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		 <th scope="col">Nomenclature</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">Route</th>
		<th scope="col">Remarks</th>
		<th>Add</th>
		<th>Delete</th>
		
	</tr>
	<%
	int l =0;
		if(opdPrescriptionList.size() > 0){
			PatientPrescriptionHeader prescriptionHeader = opdPrescriptionList.get(0);
			for(PatientPrescriptionDetails prescriptionDetails : prescriptionHeader.getPatientPrescriptionDetails()){
				l++;
	%>
	<tr>
		<td>
	    <input type="text" value="<%=prescriptionDetails.getItem().getNomenclature()+"["+prescriptionDetails.getItem().getPvmsNo()+"]"%>" tabindex="1" id="nomenclature<%=l %>" size="80"  name="nomenclature<%=l %>" onblur="populatePVMS(this.value,'<%=l %>'),checkItem('<%=l %>');"  />
	   	<div id="ac2update1<%=l %>" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature<%=l %>','ac2update1<%=l %>','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature<%=l %>'});
			</script>
	    </td>
		<td><input type="hidden" name="pvmsNo<%=l %>" tabindex="1" id="pvmsNo<%=l %>" value="<%=prescriptionDetails.getItem().getPvmsNo() %>"	size="10" readonly="readonly" />
		<input type="text" name="dosage<%=l %>" tabindex="1" value="<%=prescriptionDetails.getDosage() %>" id="dosage<%=l %>"	size="10" maxlength="5" /></td>
		<td><select name="frequency<%=l %>" id="frequency<%=l %>" tabindex="1" onclick="fillValueFromFrequency(this.value,'<%=l %>');" >
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
		</select> 
		<script>
		document.getElementById('frequency<%=l %>').value = '<%=prescriptionDetails.getFrequency().getId()%>'
		</script>
		</td>

		<td><input type="text" name="noOfDays<%=l %>" tabindex="1" id="noOfDays<%=l %>" value="<%=prescriptionDetails.getNoOfDays()!=null?prescriptionDetails.getNoOfDays():"" %>" onblur="fillValue(this.value,'<%=l %>')"  size="10"	maxlength="3" validate="No Of Days,num,no" />
			
		</td>
		<td><input type="text" name="route<%=l %>" tabindex="1" id="route<%=l %>"  size="10" maxlength="20" value="<%=prescriptionDetails.getRoute()!=null?prescriptionDetails.getRoute():"" %>"	 validate="Route,string,no" />
			<input type="hidden" name="total<%=l %>" tabindex="1" id="total<%=l %>" value="<%=prescriptionDetails.getTotal()!=null?prescriptionDetails.getTotal():"" %>"/>
		</td>
		<td><input type="text" name="treatRemarks<%=l %>" tabindex="1" id="treatRemarks<%=l %>" size="10" maxlength="40" value="<%=prescriptionDetails.getRemarks()!=null?prescriptionDetails.getRemarks():"" %>"/>
			</td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid',this);" tabindex="1" />
			</td>
		
	</tr>
	
	<%
			}}else{ l++;%>
	<tr>
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature<%=l %>" size="80"  name="nomenclature<%=l %>" onblur="populatePVMS(this.value,'<%=l %>'),checkItem('<%=l %>');"  />
	    <div id="ac2update1<%=l %>" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature<%=l %>','ac2update1<%=l %>','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature<%=l %>'});
			</script>
	    </td>
		<td><input type="hidden" name="pvmsNo<%=l %>" tabindex="1" id="pvmsNo<%=l %>"	size="10" readonly="readonly" />
		<input type="text" name="dosage<%=l %>" tabindex="1" id="dosage<%=l %>"	size="10" maxlength="5" /></td>
		<td><select name="frequency<%=l %>" id="frequency<%=l %>" tabindex="1" onclick="fillValueFromFrequency(this.value,'<%=l %>');" >
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
		</select> 
		</td>

		<td><input type="text" name="noOfDays<%=l %>" tabindex="1" id="noOfDays<%=l %>" onblur="fillValue(this.value,'1')"  size="10"	maxlength="3" validate="No Of Days,num,no" />
			
		</td>
		<td><input type="text" name="route<%=l %>" tabindex="1" id="route<%=l %>"  size="10" maxlength="20"	value="PO" validate="Route,string,no" />
			<input type="hidden" name="total<%=l %>" tabindex="1" id="total<%=l %>" />
		</td>
		<td><input type="text" name="treatRemarks<%=l %>" tabindex="1" id="treatRemarks<%=l %>" size="10" maxlength="40"/>
			</td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid',this);" tabindex="1" />
			</td>
		
	</tr>
<%} %>
</table>
	<input type="hidden" name="hdb" value="<%=l %>" id="hdb" />
<div class="clear"></div>
</div>
</div>
	<div class="clear paddingTop15"></div>
<h4>Investigation</h4>

<div class="Block">
<label >Template</label>
<div id="investigationDiv">
<select name="investigationTemplateId"	tabindex="1" onchange="showHideInvestigationTemplateCombo(this.value);">
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
<div id="createInvestigationDivToShowHide">
<input	name="investigationTemplate" type="button"	value="Create Template" tabindex="1" class="buttonBig" onclick="showCreateInvestigationTemplate();" />
</div>
<div id="investigationImportButton1" >
<input	name="investigationImportButton1" tabindex="1" type="button"	value="Import New" class="button"	onclick="getListForTreatment('investigationDiv');" />
</div>
</div>

<%
int inc = 0;
%>
<div class="clear"></div>
<div class="Block">
<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Investigation </th>
		<th scope="col">Refer to MH</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>
<%--	<%
	
		if(opdInvestigationList.size() > 0){
			PatientInvestigationHeader investigationHeader  = opdInvestigationList.get(0);
			for(PatientInvestigationDetails investigationDetails : investigationHeader.getPatientInvestigationDetails()){
				inc++;
	%>
	<tr>
		<td>
		<input type="text" value="<%=investigationDetails.getChargeCode().getChargeCodeName() %>[<%=investigationDetails.getChargeCode().getId() %>]" tabindex="1"  id="chargeCodeName<%=inc %>" size="100" name="chargeCodeName<%=inc %>"
		 	onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty<%=inc %>"	value="<%=investigationDetails.getQuantity() %>"	size="10" maxlength="6" validate="Qty,num,no" /> 
		<input	type="hidden" tabindex="1" id="chargeCode<%=inc %>" value="<%=investigationDetails.getChargeCode().getChargeCodeCode() %>" name="chargeCode<%=inc %>"	size="10" readonly /> 
		</td>
	
		<td>
		<%
			if(investigationDetails.getReferToMh()!=null && (investigationDetails.getReferToMh().equalsIgnoreCase("y"))){
		%>
		<input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio" checked="checked"  validate="Refer to MH,string,no" />
		<%}else{ %>
		
		<input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" />
		
		<%} %>
		</td>
		
	
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('investigationGrid',this);" /></td>


	</tr>
<%}
		}else{ --%><%inc++; %>
<tr>
		<td>
		<input type="text" value="" tabindex="1" 
			id="chargeCodeName<%=inc %>" size="120" name="chargeCodeName<%=inc %>"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName<%=inc %>','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty<%=inc %>"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode<%=inc %>" name="chargeCode<%=inc %>"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
	
		<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td>
	
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('investigationGrid',this);" /></td>


	</tr>

<%//} %>
</table>
	<input type="hidden" value="<%=inc %>" name="hiddenValue" id="hiddenValue" />
	</div>
	</div>
	<div class="Clear"></div>
	<div class="clear paddingTop15"></div>
	<%--
<h4>Procedure </h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="proceduregrid">
	<tr>
		<th scope="col">Procedure Name</th>
		<th scope="col">Remarks</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<%
	int i=0;
	if(opdProcedureList.size() > 0){
		ProcedureHeader procedureHeader = opdProcedureList.get(0);
		for(ProcedureDetails procedureDetails : procedureHeader.getProcedureDetails()){
			i++;
	%>
	<tr>
		<td>
		<input type="hidden" name="visitProcedureId" id="visitProcedureId" value="" />
		<input type="hidden" name="proDtId<%=i %>" id="proDtId<%=i %>" value="<%=procedureDetails.getId() %>" />
		<input type="text" name="procedure<%=i %>" id="procedure<%=i %>" value="<%=procedureDetails.getNursingCare().getNursingName() %>" size="80" onblur="getProcedureId(this.value,<%=i %>);"/>
		 <div id="ac2update3<%=i %>" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('procedure<%=i %>','ac2update3<%=i %>','registration?method=getProcedureForAutoComplete',{parameters:'requiredField=procedure<%=i %>'});
			</script>	
		<input type="hidden" name="procedureId<%=i %>" id="procedureId<%=i %>"	value="<%=procedureDetails.getNursingCare().getId() %>" /> 
		</td>
		<td>	
			<input	type="text" name="procRemarks<%=i %>" value="<%=procedureDetails.getRemarks()!=null?procedureDetails.getRemarks():"" %>" id="procRemarks<%=i %>" size="80" />
			</td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addProcedureRow();" tabindex="1" /></td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('proceduregrid',this);" tabindex="1" />
			</td>
	</tr>
	<%}
	}else{i++; %>
	<tr>
		<td>
		<input type="hidden" name="visitProcedureId" id="visitProcedureId" value="" />
		<input type="hidden" name="proDtId<%=i %>" id="proDtId<%=i %>" value="" />
		<input type="text" name="procedure<%=i %>" id="procedure<%=i %>" value="" size="80" onblur="getProcedureId(this.value,<%=i %>);"/>
		   <div id="ac2update3<%=i %>" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('procedure<%=i %>','ac2update3<%=i %>','registration?method=getProcedureForAutoComplete',{parameters:'requiredField=procedure<%=i %>'});
			</script>
		<input type="hidden" name="procedureId<%=i %>" id="procedureId<%=i %>"	value="" /> 
		</td>
		<td>	
			<input	type="text" name="procRemarks<%=i %>" value="" id="procRemarks<%=i %>" size="80" />
			</td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addProcedureRow();" tabindex="1" /></td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('proceduregrid',this);" tabindex="1" />
			</td>
	</tr>
	<%} %>
	</table>
		<input type="hidden" value="<%=i %>" name="procCount" id="procCount" />
	<div class="clear paddingTop15"></div>
<h4>Physiotherapy </h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="therapygrid">
<tr>
		<th scope="col">Therapy Name</th>
		<th scope="col">Duration</th>
		<th scope="col">Frequency</th>
		<th scope="col">No of Days</th>
		<th scope="col">Remarks</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<%
	int j = 0;
	if(opdPhysiotherapyList.size() > 0){
		PhysioRequisitionHeader physioRequisitionHeader = opdPhysiotherapyList.get(0);
		for(PhysioRequisitionDetail physioRequisitionDetail : physioRequisitionHeader.getPhysioRequisitionDetails()){
			j++;
	%>
<tr>
	<td>
	    <input type="text" value="<%=physioRequisitionDetail.getTharaphy().getTherapyTypeName() %>" tabindex="1" id="therapyTypeId<%=j %>" size="55"  name="therapyType<%=j %>" onblur="getTheraphyId(this.value,<%=j %>);"  />
	    
	   
	     <div id="ac2update4<%=j %>" style="display:none;"  class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('therapyTypeId<%=j %>','ac2update4<%=j %>','opd?method=getTherapyTypeListForAutoComplete',{parameters:'requiredField=therapyType<%=j %>'});
			</script>
			<div id="therapyDiv<%=j %>">
			<input type="hidden" name="therapyId<%=j %>" id="therapyId<%=j %>"	value="<%=physioRequisitionDetail.getTharaphy().getId() %>" /> </div>
		</td>
		
	<td><input type="text" name="duration<%=j %>" tabindex="1" id="durationId<%=j %>" value="<%=physioRequisitionDetail.getDuration()!=null?physioRequisitionDetail.getDuration():"" %>"	size="15" maxlength="5" /></td>
	
	<td><select name="frequencyId<%=j %>" id="frequencyId<%=j %>" tabindex="1"  >
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFreq : frequencyList){
		       
          %>
			<option value="<%=masFreq.getId() %>"><%=masFreq.getFrequencyName()%></option>
			<%} %>
		</select> 
		<script>
		
		document.getElementById('frequencyId<%=j %>').value='<%=physioRequisitionDetail.getFrequency().getId()%>'
		</script>
		</td>
	<td><input type="text" name="phyNoOfDays<%=j %>" tabindex="1" id="phyNoOfDays<%=j %>"  size="10" value="<%=physioRequisitionDetail.getNoOfDays()!=null?physioRequisitionDetail.getNoOfDays():"" %>"	maxlength="3" validate="No Of Days,num,no" /></td>
	<td><input type="text" name="remarks<%=j %>" tabindex="1" id="remarks<%=j %>" value="<%=physioRequisitionDetail.getRemark()!=null?physioRequisitionDetail.getRemark():"" %>" size="45" maxlength="40"/>
			</td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addPhysiotherapyRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('therapygrid',this);" tabindex="1" />
			</td>
		
	</tr>

<%}
	}else{j++; %>
<tr>
	<td>
	    <input type="text" value="" tabindex="1" id="therapyTypeId<%=j %>" size="55"  name="therapyType<%=j %>" onblur="getTheraphyId(this.value,<%=j %>);"  />
	    
	   
	     <div id="ac2update4<%=j %>" style="display:none;"  class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('therapyTypeId<%=j %>','ac2update4<%=j %>','opd?method=getTherapyTypeListForAutoComplete',{parameters:'requiredField=therapyType<%=j %>'});
			</script>
			<div id="therapyDiv<%=j %>">
			<input type="hidden" name="therapyId<%=j %>" id="therapyId<%=j %>"	value="" /> </div>
		</td>
		
	<td><input type="text" name="duration<%=j %>" tabindex="1" id="durationId<%=j %>"	size="15" maxlength="5" /></td>
	
	<td><select name="frequencyId<%=j %>" id="frequencyId<%=j %>" tabindex="1"  >
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFreq : frequencyList){
		       
          %>
			<option value="<%=masFreq.getId() %>"><%=masFreq.getFrequencyName()%></option>
			<%} %>
		</select> 
		</td>
	<td><input type="text" name="phyNoOfDays<%=j %>" tabindex="1" id="phyNoOfDays<%=j %>"  size="10"	maxlength="3" validate="No Of Days,num,no" /></td>
	<td><input type="text" name="remarks<%=j %>" tabindex="1" id="remarks<%=j %>" size="45" maxlength="40"/>
			</td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addPhysiotherapyRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('therapygrid',this);" tabindex="1" />
			</td>
		
	</tr>
<%} %>	
</table>
	<input type="hidden" name="therapyCount" value="<%=j %>" id="therapyCount" />
	--%>
<div class="Block">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

	<tr>
		 <td><a href="javascript:openPopupProcedureAdviceWindow(<%=inpatient.getId() %>,<%=inpatient.getHin().getId() %>,<%=inpatient.getDoctor().getId() %>)"> Procedure Advice</a></td>
		<td><a href="javascript:openPopupPhysiotheraphyAdviceWindow(<%=inpatient.getId() %>,<%=inpatient.getHin().getId() %>,<%=inpatient.getDoctor().getId() %>)">  Physiotherapy Advice</a></td>
</tr>
</table>
</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>Diet Setup</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="dietgrid">
<tr>
		<th scope="col">Type of Diet</th>
		<th scope="col">Spl. Instructions</th>
	
	</tr>
	<%
		if(ipdPatientDietList.size() >0){
			for(IpdPatientDiet ipdPatientDiet : ipdPatientDietList){
	%>
	<tr>
	<td>
	<select id="dietTypeId" name="dietType">
	<option value="0">Select</option>
	<%
		if(dietTypeList.size() > 0){
			for(MasDiet diet:dietTypeList){
	%>
	<option value="<%=diet.getId() %>"><%=diet.getDietName() %></option>
	
	<%}
			}%>
	</select>
	<script type="text/javascript">
	document.getElementById('dietTypeId').value='<%=ipdPatientDiet.getDiet().getId()%>'
	
	</script>
	</td>
	<td><input type="text" name="splInstructions" maxlength="50" value="" size="160"/></td>
	</tr>
	<%}
			}else{ %>
	<tr>
	<td>
	<select name="dietType">
	<option value="0">Select</option>
	<%
		if(dietTypeList.size() > 0){
			for(MasDiet diet:dietTypeList){
	%>
	<option value="<%=diet.getId() %>"><%=diet.getDietName() %></option>
	
	<%}
			}%>
	</select>
	</td>
	<td><input type="text" name="splInstructions" maxlength="50" value="" size="160"/></td>
	</tr>
	
	<%} %>
</table>
<input name="physioRequisitionHeaderId" id="physioRequisitionHeaderId" type="hidden" value="0" />
<input name="procedureHeaderId" id="procedureHeaderId" type="hidden" value="0" />
<div class="Clear"></div>
<div class="Block">
<label>Ready to Discharge</label>
<%
	if(opdPatientDetails.getInpatient()!=null && opdPatientDetails.getInpatient().getAdStatus().equals("R")){
%>
<input type="checkbox" value="y" name="readyToDischarge" id="readyToDischarge" class="radio" checked="checked">

<%}else{ %>
<input type="checkbox" value="y" name="readyToDischarge" id="readyToDischarge" class="radio">
<%} %>
<div class="Clear"></div>
</div>

<div class="Clear"></div>
<input type="hidden" name="ageName" value="<%=inpatient.getAge() %>" id="ageId" /> 
<input type="hidden" name="genderId" id="genderId" value="<%=patient.getSex().getId() %>">
<div class="division"></div>	
<input type="button"	name="sss" class="button" value="Submit"	onclick="submitForm('ipdCaseSheet','ipd?method=submitIpdCaseSheetDetails','validateRows');" />
<input type="button" class="button" value="Back" onClick="submitForm('ipdCaseSheet','ipd?method=showPatientListJsp');" />
<input type="reset" name="reset" value="Reset"/>	
<div class="Clear"></div>
<div class="division"></div>

</form>

<script>

function validateRows(){
	if(document.getElementById('caseNotes').value==''){
		alert("Please enter Case Notes.");
		return false;
	}

	
	var treatCount = document.getElementById('hdb').value;
//	var therapyCount = document.getElementById('therapyCount').value;
	if(treatCount>0){
		for(var i =1;i<=treatCount;i++){
			if(document.getElementById('nomenclature'+i) && document.getElementById('nomenclature'+i).value!=''){
				if(document.getElementById('frequency'+i)){
					if(document.getElementById('frequency'+i).value == '0'){
						alert('Please select frequency for treatment in row '+i);
						return false;
					  }
					 }
					
					if(document.getElementById('dosage'+i)){
					if(document.getElementById('dosage'+i).value == ''){
						alert('Please enter dosage for treatment in row '+i);
						return false;
					 }
					}
					
					if(document.getElementById('noOfDays'+i)){
					if(document.getElementById('noOfDays'+i).value == ''){
						alert('Please enter noOfDays for treatment in row '+i);
						return false;
					 }
					}
					if(document.getElementById('noOfDays'+i).value!="")
					{
					if( isNaN(document.getElementById('noOfDays'+i).value))
			    	{
			        	alert("No. of Days should be number");
			        	return false;
			    	 }
					 }
				   }
			}
		
	}

/*	if(therapyCount>0){
		for(var j =1;j<=therapyCount;j++){
			if(document.getElementById('therapyTypeId'+j) && document.getElementById('therapyTypeId'+j).value!=''){
				if(document.getElementById('frequencyId'+j)){
					if(document.getElementById('frequencyId'+j).value == '0'){
						alert('Please select frequency for therapy in row '+j);
						return false;
					  }
					 }
					
					if(document.getElementById('durationId'+j)){
					if(document.getElementById('durationId'+j).value == ''){
						alert('Please enter therapy duration in row '+j);
						return false;
					 }
					}
					
					if(document.getElementById('phyNoOfDays'+j)){
					if(document.getElementById('phyNoOfDays'+j).value == ''){
						alert('Please enter noOfDays for therapy in row '+j);
						return false;
					 }
					}
					if(document.getElementById('phyNoOfDays'+j).value!="")
					{
					if( isNaN(document.getElementById('phyNoOfDays'+j).value))
			    	{
			        	alert("No. of Days should be number");
			        	return false;
			    	 }
					 }
				   }
			}

		
	}*/
	return true;
}

function removeRow(idName,obj)
{
  var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  if (lastRow > 1){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
  }
}


function fillDiagnosisCombo(val) {

         
	  	  var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var id = val.substring(index1,index2);
		   
		    if(id ==""){
			  return;
			}else{
			   		obj =document.getElementById('diagnosisId');
					obj.length = document.getElementById('diagnosisId').length;
                   var valu=obj.options[obj.length-1].value;
					var b="false";
					for(var i=1;i<obj.length;i++){
							    
		                    	var val1=obj.options[i].value;
		                    	var length=obj.length-1;
                               	
		                    	if(id==val1)
		                    	{
		                        	alert("ICD  Already taken");
		                        	document.getElementById('icd').value =""
		                        	b=true;
		                       	}
		                              	
		                    }
                   
		                    if(b=="false")
		                    {
		                    	obj.length++;
		    					obj.options[obj.length-1].value=id
		    					obj.options[obj.length-1].text=val
		    					obj.options[obj.length-1].selected=true
		    					document.getElementById('icd').value =""
		    			                    
		                    }
				}
			
	  }

function populatePVMS(val,inc){
	if(val != "")
	{
	    var index1 = val.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvmsNo = val.substring(index1,index2);
	    var indexForBrandName=indexForBrandName--;
	    var brandName=val.substring(0,indexForBrandName);

	  if(pvmsNo == "")
	  {
	   	document.getElementById('nomenclature'+inc).value="";
	    document.getElementById('pvmsNo'+inc).value="";
	   return;
	   }
	   else
	      document.getElementById('pvmsNo'+inc).value=pvmsNo
	
	
	 }
}
function getProcedureId(val,inc){
	if(val!=''){
		var index1 = val.lastIndexOf("[");
		var index2 = val.lastIndexOf("]");
		index1++;
		var procId = val.substring(index1,index2);
		document.getElementById('procedureId'+inc).value = procId;
	}else{
		if(document.getElementById('procedure'+inc)){
	      	document.getElementById('procedure'+inc).value="";
	      	document.getElementById('procedureId'+inc).value="";
	    	document.getElementById('proDtId'+inc).value="";
	      	document.getElementById('procRemarks'+inc).value="";
			}
	}
	
}

function getTheraphyId(val,inc){
	if(val != ""){
			
			var index1 = val.lastIndexOf("[");
			var indexForTheraphyCode = index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var therapyId = val.substring(index1,index2);
			var indexForTheraphyCode = indexForTheraphyCode--;
			var theraphyCode = val.substring(0,indexForTheraphyCode);

			 
			if(therapyId == "" ) {
		      	document.getElementById('therapyTypeId'+inc).value="";
		      	return;
			}
		if(therapyId!=""){
			submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/opd?method=getTheraphyId&counter='+inc+'&therapyId='+therapyId,'therapyDiv'+inc);
		}
	}else{
	
		if(document.getElementById('therapyTypeId'+inc)){
			document.getElementById('therapyTypeId'+inc).value="";
	      	document.getElementById('therapyId'+inc).value="";
	      	document.getElementById('durationId'+inc).value="";
	    	document.getElementById('frequencyId'+inc).value="0";
	      	document.getElementById('phyNoOfDays'+inc).value="";
	      	document.getElementById('remarks'+inc).value="";
			}

	}
		
	}

function addRow(){
	  
	  var tbl = document.getElementById('grid');
	 
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;
	  
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	
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
	      						checkItem(iteration);
						   }
	  					  };
	  
	    var newdiv = document.createElement('div');
      	newdiv.setAttribute('id', 'ac2update1'+iteration);
      	newdiv.setAttribute('class', 'autocomplete');
       	newdiv.style.display = 'none';
        e0.size = '80';
 
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);
	  cellRight0.appendChild(newdiv);
	
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update1'+iteration,'opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});
	  var cellRight1 = row.insertCell(1);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='dosage'+iteration;
	  e3.id='dosage'+iteration
	  e3.size='10';
	  e3.setAttribute('maxlength', 5); 
	  e3.setAttribute('tabindex','1');
	  cellRight1.appendChild(e3);

	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('Select');

	  e2.name='frequency'+iteration;
	  e2.id='frequency'+iteration;
	  e2.classname='smalllabel';
	  e2.setAttribute('tabindex','1');
	  e2.options[0] = new Option('Select', '0');
	  e2.onclick=function(){fillValueFromFrequency(this.value,iteration);}

	   for(var i = 0;i<frequencyArray.length;i++ ){
	      e2.options[i+1] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
	      }
	  cellRight2.appendChild(e2);
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight2.appendChild(sel);
	
	 

	  
	  var cellRight3 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='10';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','noOfDays,int,no');

	  e4.onblur=function(){fillValue(this.value,iteration);	}
	  cellRight3.appendChild(e4);

	  var e5 = document.createElement('input');
	  e5.type = 'hidden';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	  cellRight3.appendChild(e5);



		var cellRight4 = row.insertCell(4);
		var e6 = document.createElement('input');
		e6.type = 'text';
		e6.name='route'+iteration;
		e6.id='route'+iteration
		e6.value='PO';
		e6.size='10';
		e6.setAttribute('maxlength', 20); 
		e6.setAttribute('tabindex','1');
		cellRight4.appendChild(e6);

	  var cellRight5 = row.insertCell(5);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='treatRemarks'+iteration;
	  e7.id='treatRemarks'+iteration
	  e7.size='10';
	  e7.setAttribute('maxlength', 40); 
	  e7.setAttribute('tabindex','1');
	  cellRight5.appendChild(e7);

	  var cellRight6 = row.insertCell(6);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='add'+iteration;
	  e8.setAttribute('onClick', 'addRow();'); 
	  e8.setAttribute('tabindex','1');
	  cellRight6.appendChild(e8);

	  var cellRight7 = row.insertCell(7);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='del'+iteration;
	  e9.onclick = function(){removeRow('grid',this);};
	  e9.setAttribute('tabindex','1');
	  cellRight7.appendChild(e9);


	}


function addRowForInvestigation(){
    
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;
   
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.onblur=function(){

	  						if(validateInvestigationAutoComplete(this.value,iteration)){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration);}

	  					  };
	   var newdiv1 = document.createElement('div');
	  newdiv1.setAttribute('id', 'ac2update2');
	  newdiv1.setAttribute('class', 'autocomplete');
	  newdiv1.style.display = 'none';
	  					
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.setAttribute('tabindex','1');
	  e0.size = '120'
	  cellRight0.appendChild(newdiv1);
	  
	  cellRight0.appendChild(e0);
	
	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});	 

	  var sel = document.createElement('input');
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
	  e4.setAttribute('onClick','addRowForInvestigation();');
	  cellRight2.appendChild(e4);

	  var cellRight3 = row.insertCell(3);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.name='delete';
	  e5.onclick = function(){removeRow('investigationGrid',this);};
	  cellRight3.appendChild(e5);
	
	}


function addProcedureRow(){
		
		  var tbl = document.getElementById('proceduregrid');
		  var lastRow = tbl.rows.length;

		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('procCount');
		  var iteration = parseInt(hdb.value)+1;
		  hdb.value = iteration;

		  
		  var cell1 = row.insertCell(0);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.size = '80';
		  e1.name='procedure'+iteration;
		  e1.id='procedure'+iteration
		  e1.onblur=function() {getProcedureId(this.value,iteration);}

		  var newdiv = document.createElement('div');
	      newdiv.setAttribute('id', 'ac2update3'+iteration);
	      newdiv.setAttribute('class', 'autocomplete');
	      newdiv.style.display = 'none';
	      cell1.appendChild(newdiv);
		  cell1.appendChild(e1);
		  new Ajax.Autocompleter('procedure'+iteration,'ac2update3'+iteration,'registration?method=getProcedureForAutoComplete',{parameters:'requiredField=procedure'+iteration});
	       	
		  var e11 = document.createElement('input');
		  e11.type = 'hidden';
		  e11.name='procedureId'+iteration;
		  e11.id='procedureId'+iteration
		  cell1.appendChild(e11);
		  
		  var e12 = document.createElement('input');
		  e12.type = 'hidden';
		  e12.name='proDtId'+iteration;
		  e12.id='proDtId'+iteration
		  cell1.appendChild(e12);
		  
		  var cell11 = row.insertCell(1);
		  var e21 = document.createElement('input');
		  e21.type = 'text';
		  e21.name='procRemarks'+iteration;
		  e21.id='procRemarks'+iteration
		  e21.size = '80';
		  e21.setAttribute('tabindex','1');
		  cell11.appendChild(e21);
		  
		  var cell12 = row.insertCell(2);
		  var e31 = document.createElement('input');
		  e31.type = 'button';
		  e31.className = 'buttonAdd';
		  e31.name='Button'+iteration;
		  e31.setAttribute('onClick', 'addProcedureRow();'); 
		  e31.setAttribute('tabindex','1');
		  cell12.appendChild(e31);

		  var cell13 = row.insertCell(3);
		  var e41 = document.createElement('input');
		  e41.type = 'button';
		  e41.className = 'buttonDel';
		  e41.name='delete'+iteration;
		  e41.onclick = function(){removeRow('proceduregrid',this);};
		  e41.setAttribute('tabindex','1');
		  cell13.appendChild(e41);
}


function addPhysiotherapyRow(){
		
		  var tbl = document.getElementById('therapygrid');
		  var lastRow = tbl.rows.length;

		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('therapyCount');
		  var iteration = parseInt(hdb.value)+1;
		  hdb.value = iteration;
		  
		  var cell1 = row.insertCell(0);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.size = '55';
		  e1.name='therapyType'+iteration;
		  e1.id='therapyTypeId'+iteration
		  e1.onblur=function() {getTheraphyId(this.value,iteration);}

		  var newdiv = document.createElement('div');
	      newdiv.setAttribute('id', 'ac2update4'+iteration);
	      newdiv.setAttribute('class', 'autocomplete');
	      newdiv.style.display = 'none';
	      cell1.appendChild(newdiv);
		  cell1.appendChild(e1);
		  new Ajax.Autocompleter('therapyTypeId'+iteration,'ac2update4'+iteration,'opd?method=getTherapyTypeListForAutoComplete',{parameters:'requiredField=therapyType'});
		  
		  var e11 = document.createElement('input');
		  var ediv = document.createElement('div');
		  ediv.id='therapyDiv'+(iteration);
		  e11.type = 'hidden';
		  e11.name='therapyId'+iteration;
		  e11.id='therapyId'+iteration
		  cell1.appendChild(ediv);
		  cell1.appendChild(e11);
		  
		  var cell2 = row.insertCell(1);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name='duration'+iteration;
		  e2.id='durationId'+iteration
		  e2.size = '15'
		  cell2.appendChild(e2);

		  var cell13 = row.insertCell(2);
		  var e3 = document.createElement('Select');

		  e3.name='frequencyId'+iteration;
		  e3.id='frequencyId'+iteration;
		  e3.classname='smalllabel';
		  e3.setAttribute('tabindex','1');
		  e3.options[0] = new Option('Select', '0');
		   for(var i = 0;i<frequencyArray.length;i++ ){
		      e3.options[i+1] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
		      }
		   cell13.appendChild(e3);

		  var cell14 = row.insertCell(3);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name='phyNoOfDays'+iteration;
		  e4.id='phyNoOfDays'+iteration;
		  e4.size='10';
		  e4.setAttribute('maxlength', 3); 
		  e4.setAttribute('tabindex','1');
		  e4.setAttribute('validate','noOfDays,int,yes');
		  cell14.appendChild(e4);
		  
		  var cell5 = row.insertCell(4);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.name='remarks'+iteration;
		  e5.id='remarks'+iteration
		  e5.size = '45';
		  e5.setAttribute('tabindex','1');
		  cell5.appendChild(e5);
		  
		  var cell6 = row.insertCell(5);
		  var e6 = document.createElement('input');
		  e6.type = 'button';
		  e6.className = 'buttonAdd';
		  e6.name='Button'+iteration;
		  e6.setAttribute('onClick', 'addPhysiotherapyRow();'); 
		  e6.setAttribute('tabindex','1');
		  cell6.appendChild(e6);

		  var cell7 = row.insertCell(6);
		  var e7 = document.createElement('input');
		  e7.type = 'button';
		  e7.className = 'buttonDel';
		  e7.name='delete'+iteration;
		  e7.onclick = function(){removeRow('therapygrid',this);};
		  e7.setAttribute('tabindex','1');
		  cell7.appendChild(e7);
}
function changeClass(divid){
	var inc = '<%=m%>'
	for(var i=1;i<inc;i++){

	}
	if(document.getElementById(divid).getAttribute('class') == 'plus'){
		document.getElementById(divid).setAttribute('class','minus');
		document.getElementById('opdDetails').style.display='block';
	}else if(document.getElementById(divid).getAttribute('class') == 'minus'){
		document.getElementById(divid).setAttribute('class','plus');
		document.getElementById('opdDetails').style.display='none';
	}
	
}

function clearTestDivDown(flag,id,resultType,resultStatus,confidential){
//	document.getElementById('testDivDown').innerHTML = "";
	if(flag == 'rhLab'){
		window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');
	}
	if(flag == 'rdRadio'){
		//window.showModalDialog('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','dialogHeight=120,dialogWidth=120','dialogLeft=100,dialogTop=160,dialogHeight=120,dialogWidth=120,,status=2,scrollbars=1,resizable=0,center=1');
		window.open('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');
	}
	if(flag == 'rhSenLab'){
		window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=25,top=160,height=400,width=970,status=1,scrollbars=1,resizable=1');			
		//submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'','testDivDown');
	}
	if(flag == 'rEntryDetailLab'){
		if(resultType == 's'){
			window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');				
		}else{
			window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');				
		}
	}
}
function deleteDgItems(value){
    if(document.getElementById('diagnosisId').selectedIndex!=0){
	 if(confirm("are you sure want to delete ?")){

	 		document.getElementById('diagnosisId').remove(document.getElementById('diagnosisId').selectedIndex)

	    }
	   }
    }
function  fillValue(value,inc){

	  var freq=document.getElementById('frequency'+inc).value;
	  var dosage=document.getElementById('dosage'+inc).value;
	  document.getElementById('total'+inc).value=freq*value*dosage;
	 }
function  fillValueFromFrequency(value,inc){

  var noOfDays=document.getElementById('noOfDays'+inc).value;
  var dosage=document.getElementById('dosage'+inc).value;
  document.getElementById('total'+inc).value=noOfDays*value*dosage;
 }

function openPopupProcedureAdviceWindow(inpatientId,hinId,doctorId)
{
 var url="/hms/hms/ipd?method=showIPProcedureListJsp&inpatientId="+inpatientId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=ipd";
 newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
}

function openPopupPhysiotheraphyAdviceWindow(inpatientId,hinId,doctorId)
{
 var url="/hms/hms/opd?method=showPhysiotherapyListJsp&inpatientId="+inpatientId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=ipd";
 newwindow=window.open(url,'name',"left=1,top=100,height=300,width=900,status=1,scrollbars=1,resizable=0");
	 //alert("Physiotheraphy Advice ....");
}
function showHideInvestigationTemplateCombo(valueOfTemplate){
	
	if(checkTemplateId(valueOfTemplate)){
		
			submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/opd?method=showGridForInvestigation','gridview');
			
			}

}

function checkTemplateId(templateId){
	
  if(templateId=="0"){
    return true;
  }else{
    return true;
  }
}

function getListForTreatment(val){
	if(val=='investigationDiv'){
		submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
	}else if(val=='treatmentDiv'){
		submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
	}
}

function showCreateInvestigationTemplate(){
    
    document.getElementById("investigationImportButton1").style.display='inline'
  	var url="/hms/hms/opd?method=showCreateInvestigationTemplate";
   newwindow=window.open(url,'investigation',"height=500,width=1010,status=1,top=0,left=2");
  

}
</script>

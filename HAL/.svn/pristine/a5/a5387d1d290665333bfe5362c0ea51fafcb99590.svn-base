
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.DIAGNOSIS_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.FREQUENCY"%>
<%@page import="jkt.hms.masters.business.AllergyDetail"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%@page import="jkt.hms.masters.business.PhysioRequisitionDetail"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>

<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%>
<%@page import="jkt.hms.masters.business.ProcedureHeader"%>
<%@page import="jkt.hms.masters.business.PhysioRequisitionHeader"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>
<%@page import="jkt.hms.masters.business.MasImpanneledHospital"%>


<%@page import="jkt.hms.masters.business.IpdPatientDiet"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/tabcontentIn.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
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



function popwindowresult(url)
{
		   	
		   newwindow=window.open(url,'Diagnosis',"left=0,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=1");
		  
}

var icdArray=new Array();
var unitArray = new Array(); 
var itemClassArray = new Array();
var itemClassCodeLiquidArray = new Array();
</script>

	<%
	String []ItemClassCodeForLiquid1 = HMSUtil.getProperties("adt.properties", "ItemClassCodeForLiquidForm").trim().split(",");
	for(int i=0;i<ItemClassCodeForLiquid1.length;i++)
	{
	%>
	<script>

	itemClassCodeLiquidArray[<%=i%>]= new Array();
	itemClassCodeLiquidArray[<%=i%>][0] = "<%=ItemClassCodeForLiquid1[i]%>";

     			
            </script>
<%	}%>

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
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
	hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	List<MasDepartment> deptList= new ArrayList<MasDepartment>();
	if(map.get("deptList") != null){
	deptList=(List)map.get("deptList");
	}
	List<MasImpanneledHospital> masImpanneledHospitalList = new ArrayList<MasImpanneledHospital>();
  	if(map.get("masImpanneledHospitalList") != null)
	{
  		masImpanneledHospitalList=(List<MasImpanneledHospital>)map.get("masImpanneledHospitalList");
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
	List<PatientPrescriptionHeader> ipdPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
	List<PatientInvestigationHeader> ipdInvestigationList = new ArrayList<PatientInvestigationHeader>();
	List<DischargeIcdCode> ipIcdList = new ArrayList<DischargeIcdCode>();
	List<MasEmployee>employeeList=new ArrayList<MasEmployee>();	
//	List<ProcedureHeader> ipdProcedureList = new ArrayList<ProcedureHeader>();
//	List<PhysioRequisitionHeader> ipdPhysiotherapyList = new ArrayList<PhysioRequisitionHeader>();
	List<OpdPatientHistory> ipdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
	List<IpdPatientDiet> ipdPatientDietList= new ArrayList<IpdPatientDiet>();
	if(map.get("employeeList")!=null){
		employeeList=(List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("ipdPrescriptionList") != null){
		ipdPrescriptionList=(List<PatientPrescriptionHeader>)map.get("ipdPrescriptionList");
	}
	if(map.get("ipdInvestigationList") != null){
		ipdInvestigationList=(List<PatientInvestigationHeader>)map.get("ipdInvestigationList");
	}
	if(map.get("ipIcdList") != null){
		ipIcdList=(List<DischargeIcdCode>)map.get("ipIcdList");
	}
/*	if(map.get("ipdProcedureList") != null){
		ipdProcedureList=(List<ProcedureHeader>)map.get("ipdProcedureList");
	}
	if(map.get("ipdPhysiotherapyList") != null){
		ipdPhysiotherapyList=(List<PhysioRequisitionHeader>)map.get("ipdPhysiotherapyList");
	}*/
	List<PatientFamilyHistory> familyHistoryList = new ArrayList<PatientFamilyHistory>();
	if(map.get("familyHistoryList") != null){
		familyHistoryList=(List<PatientFamilyHistory>)map.get("familyHistoryList");
	}
	List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
	if(map.get("itemConversionList") != null){
		itemConversionList=(List)map.get("itemConversionList");
		}
	List <MasItemClass> masItemClassList =new ArrayList<MasItemClass>();
    if(map.get("masItemClassList") != null){
    	masItemClassList = (List<MasItemClass>) map.get("masItemClassList");
    			}
	
	if(map.get("ipdHistoryDetailsListForFollowUp") != null){
		ipdHistoryDetailsListForFollowUp=(List)map.get("ipdHistoryDetailsListForFollowUp");
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
	
	if(ipdHistoryDetailsListForFollowUp.size()>0){
		opdPatientHistory = ipdHistoryDetailsListForFollowUp.get(0);
	}
	
	Patient patient = new Patient();
	Inpatient inpatient = new Inpatient();
	String patientName ="";
	String consultantName = "";
	String currentAge = "";
	String admDate="";
	if(inpatientList.size() >0){
		patient = inpatientList.get(0).getHin();
		inpatient = inpatientList.get(0);
		patientName=patient.getPFirstName()+" "+(patient.getPMiddleName() != null?patient.getPMiddleName():"")+" "+(patient.getPLastName() != null?patient.getPLastName():"");
		admDate = HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission());
		if(inpatient.getDoctor() !=null)
			/* consultantName=inpatient.getDoctor().getRank().getRankName(); */
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
	
	Calendar now = Calendar.getInstance();
 	Calendar cal = Calendar.getInstance();
	cal.setTime(inpatient.getDateOfAddmission());

	
	int currentDays = now.get(Calendar.DATE);
	int regDays = cal.get(Calendar.DATE);
	
	int currentMonth = now.get(Calendar.MONTH) + 1;
	int regMonth = cal.get(Calendar.MONTH) + 1;
	
	int currentYear = now.get(Calendar.YEAR);
	int regYear = cal.get(Calendar.YEAR);
	
	int calculatedDays=0;
	int calculatedMonth=0;
	int calculatedYear=0;
	
	if (currentDays < regDays) {
		currentDays = currentDays + 30;
		calculatedDays = currentDays - regDays;
		currentMonth = currentMonth - 1;
	} else {
		calculatedDays = (currentDays - regDays);
	}
	
	if (currentMonth < regMonth) {
		currentMonth = currentMonth + 12;
		calculatedMonth = currentMonth - regMonth;
		currentYear = currentYear - 1;
	} else {
		calculatedMonth = currentMonth - regMonth;
	}

	calculatedYear = currentYear - regYear;
	
	
	Date d1= inpatient.getDateOfAddmission();
	Date d2= new Date();
	long t1 = d1.getTime();
	long  t2 = d2.getTime();
	long day = 1000 * 60 * 60 * 24; // milliseconds in a day
	long totalOfDays =  (t2 - t1) / day;
	
%>


<div class="titleBg"><h2>Case Sheet</h2></div>

<h4>Patient Details</h4>
<div class="Clear"></div>
<div class="Block">

<label>A&D No.</label> <%if(inpatient.getAdNo() != null){ %>
<label class="value"><%=inpatient.getAdNo() %></label> <%}else{ %>
<label class="value">-</label>
<%} %>
<label>Employee No.</label> 
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

<label>Designation</label>
<%if(patient.getRank()!=null)
	{
	%>
<label class="value"><%=patient.getRank().getRankName() %></label>
<%}
else
{
%>
<label class="value"></label>
<%}%>

<div class="Clear"></div>
<label>Employee Name</label> <%
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

<%-- <label>Branch/Trade</label>
<%
if(patient.getTrade() != null){
%> 
<label class="value"><%=  patient.getTrade().getTradeName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%> --%>


<%-- <label>Unit</label> <%
if(patient.getUnit() != null){
%> <label class="value"><%= patient.getUnit().getUnitName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%> --%>
<!-- <div class="Clear"></div> -->
<label>Age</label> <%if(!currentAge.equals("")){ %>
<label class="value"> <%=currentAge %></label> <%}else{ %>
<label	class="value">-</label> <%} %>
<label>Gender</label> <%if(patient.getSex() != null){ %>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<%-- <label>Med Cat</label>
<label class="value"><%=patient.getCategory()!=null? patient.getCategory().getCategories():""%></label>
 --%>
<div class="Clear"></div>

<label>Admitting Doctor</label>
<label class="value"><%=consultantName %></label>

<%-- <label>Allergies</label>
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
<%} %> --%>
<%
String admissionNotes = "";
if(caseSheetList.size()!=0)
{
	admissionNotes = (caseSheetList.get(0).getAdmissionNotes()!=null?caseSheetList.get(0).getAdmissionNotes():" ");
}
%>
<label>Total Admission Days</label>
 <label class="value"><%=totalOfDays%> </label>
 <div class="Clear"></div>
 <label>Admission Notes</label>
 <textarea onkeyup="auto_grow(this)" validate="Admission Notes,string,no" maxlength="500" name ="admission_notes" id ="admission_notes" class="large" disabled="disabled" />
<%=admissionNotes%>
</textarea>
  
 <%-- 
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
		%>  --%>
<%-- <label>Disability</label>
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
%>  --%>


 <%-- <input type="hidden"	id="timeId" name="timeForAll" value="<%=time%>" class="calDate"	tabindex=1 onblur="fillTime(this.value)"
	onchange="IsValidTime(this.value,this.id);" /> --%>
 
 
 

<div class="Clear"></div>
</div>

<%-- 
<%

	if(opdDetailsList.size() == 0){
%>		
<div class="Block">
<label >Complaints</label>
<textarea name="presentComplain" cols="0" rows="0"  maxlength="300" validate="Complaints,string,no" value="" validate tabindex="1" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

<label >Past Medical History</label> 
<textarea name="pastMedicalHistory" cols="0" rows="0"  maxlength="300"	value=""  tabindex="1" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
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

for display patient history
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
end for display patient history
</script>

<label >Risk Factors</label>
<textarea name="riskFactor" cols="0" rows="0"  maxlength="300"	value=""  tabindex="1" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>


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
<textarea name="onExamination" cols="120" rows="0" value="" maxlength="300" class="auto" tabindex="1"  onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
  <div class="clear"></div>

<div class="clear"></div>
</div>
	<%}
%> --%>

<div class="clear"></div>

<div class="division"></div>
<input type="button" class="buttonBig" value="View Clinical Chart" onClick="submitForm('ipdCaseSheet','discharge?method=showClinicalSheetReport&adNo=<%=inpatient.getAdNo() %>&serviceNo=<%=inpatient.getHin().getServiceNo()!=null?inpatient.getHin().getServiceNo():"" %>','validatePatient');"	/>  
<input type="button" class="buttonBig" value="View Intake/Output" onClick="submitForm('ipdCaseSheet','ipd?method=showIntakeOutputChartReport&adNo=<%=inpatient.getAdNo() %>&reportType=summary','validatePatient');"	/>
<%-- <input type="button" class="buttonBig" value="View Specialist Opinion" onClick="openWindow('ipd?method=viewSpecialistOpinion&inpatientId=<%=inpatient.getId() %>');"	/> --%>
<input	name="investigationTemplate" type="button" value="Clinical Assist"	onclick="showDiagnosis()" tabindex="1" class="buttonBig" />  
<input	name="treatmentTemplate" type="button" value="Treatment Assist"	tabindex="1" onclick="showTreatment()" class="buttonBig" />
<div class="clear"></div>
<div class="division"></div>
<input name="hinId" id="hinId" type="hidden"	value="<%=patient.getId()%>" />
<input name="inpatientId" type="hidden"	value="<%=inpatient.getId()%>" />
<input name="adNo" type="hidden"	value="<%=inpatient.getId()%>" />
<input name="hinNo" type="hidden"	value="<%=patient.getHinNo()%>" />
<input name="serviceNo" type="hidden"	value="<%=patient.getServiceNo()!=null?patient.getServiceNo():"" %>" />
<%
String serviceNo = patient.getServiceNo()!=null?patient.getServiceNo():"";
int hinId= patient.getId();
String hinNo= patient.getHinNo();
%>
<div class="arrowlistmenu">

<ul class="categoryitems">

	<li><a href="#" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&hinId=<%=hinId %>&backFlag=ipd')">
	Previous Visits </a></li>
    <li>
	<a href="#" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForHospitality&hinNo=<%=hinNo%>&backFlag=ipd')">
    Previous Hospitalizations</a>
	</li>
	<%-- <li>
	<a href="#" onclick="openWindow('/hms/hms/medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=serviceNo %>&hinId=<%=hinId %>&backFlag=ipd')">
	Previous Medical Exams </a>
	
	</li>
	
	<li>
	<a href="#" onclick="openWindow('/hms/hms/medicalExam?method=getPrevMedBoardFromHIC&hinId=<%=hinId %>&serviceNo=<%=serviceNo %>&backFlag=ipd')">
	Previous Medical Boards</a>
	</li> --%>
	<%-- <li>
	<a href="#" onclick="javascript:openPopupPrescriptions(0,<%=patient.getCurrentVisitNo()%>,0,<%=patient.getId()%>)">
	Previous Prescriptions</a>
	</li>
	<li>
	<a
		href="#" onclick="javascript:openPopupInvestigation(0,<%=patient.getCurrentVisitNo()%>,0,<%=patient.getId()%>)">
		Previous Investigations</a>
		</li> --%>
		<li>
		 <a href="#"
				onclick="javascript:openPopupInvestigation(<%=hinId %>)">
					Previous Lab Investigations</a></li>
					<%String hinNo1 =patient.getHinNo();
					   if(hinNo1!=null && !hinNo1.isEmpty() && hinNo1.charAt(0)=='0')
						   hinNo1 =hinNo1.substring(1, hinNo.length());
					%>
			<li><a href="#"
				onclick="javascript:openPopupRadioInvestigation('<%=hinNo1%>')">
					Previous Radiology Investigations</a></li>
		
	<li>
	<a href="#" onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&hinId=<%=patient.getId()%>&backFlag=ipd&inpatientId=<%=inpatient.getId()%>')">Upload Documents </a>
	</li>
	
	<li><a href="#" onclick="openWindow('/hms/hms/opd?method=viewAllPrevoiusSurgery&hinId=<%=patient.getId()%>')">Previous Minor Surgery</a></li>
	<!--

	<li>
	 <a href="#" onclick="javascript:openPopupPrescriptions(,,,)">
	Previous Prescriptions</a>
	</li>
	<li>
	<a
		href="#" onclick="javascript:openPopupInvestigation(,,,)">
		Previous Investigations</a></li> 
		
--></ul>
<script type="text/javascript">
function openWindow(url){

    newwindow=window.open(url,'name',"left=2,top=100,height=500,width=900,status=1,scrollbars=1,resizable=0");
	
}
</script>
</div>
<div class="opdArea">
<div class="clear"></div>
       <ul id="countrytabs" class="shadetabs">
           <li onclick="submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ipd?method=getPrevCaseNoteDiagnosis&parent=<%=inpatient.getId() %>&hinId=<%=inpatient.getHin().getId() %>','prevDiagCaseNoteDiv');"><a href="#" rel="country1" >Case Notes</a></li>
           <li onclick="submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ipd?method=getPrevTreatmentDetails&parent=<%=inpatient.getId() %>&hinId=<%=inpatient.getHin().getId() %>','prevTreatmentDiv');"><a href="#" rel="country2" >Treatments</a></li>
           <li onclick="submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ipd?method=getPrevInvestigationDetails&parent=<%=inpatient.getId() %>&hinId=<%=inpatient.getHin().getId() %>','prevInvestigationDiv');"><a href="#" rel="country3">Investigations</a></li>
           <li onclick="submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ipd?method=getPrevProcedureDetails&parent=<%=inpatient.getId() %>&hinId=<%=inpatient.getHin().getId() %>','prevProcedureDiv');"><a href="#" rel="country4">Procedures</a></li>
           <%-- <li onclick="submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ipd?method=getPrevPhysiotherapyDetails&parent=<%=inpatient.getId() %>&hinId=<%=inpatient.getHin().getId() %>','prevTherapyDiv');"><a href="#" rel="country5">Physiotherapy</a></li> --%>
           <li onclick="submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ipd?method=getPrevDietDetails&parent=<%=inpatient.getId() %>&hinId=<%=inpatient.getHin().getId() %>','prevDietDiv');"><a href="#" rel="country6">Diet Details</a></li>
           <li ><a href="#" rel="country7">Referral</a></li>
           <li onclick="submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ipd?method=getPrevConsultationDetails&parent=<%=inpatient.getId() %>&hinId=<%=inpatient.getHin().getId() %>','prevConsultaionDiv');"><a href="#" rel="country8">Consultation</a></li>
           <li onclick="submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ipd?method=getTransferHistory&parent=<%=inpatient.getId() %>&hinId=<%=inpatient.getHin().getId() %>','prevTransferDiv');"><a href="#" rel="country9">Transfer History</a></li>
	</ul>
<div class="clear"></div>
<div class="paddingTop5"></div>
<!-- First Tab End -->
<div id="country1" class="tabcontentIn">
<%
OpdPatientDetails prevPatientDetails =new OpdPatientDetails();
if(caseSheetList.size() > 0){
	prevPatientDetails = caseSheetList.get(0); // For getting latest case notes
}
%>
<div class="clear"></div>
<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid1">
	<tr>
		<th scope="col">Today's Case Notes</th>

	</tr>
	<tr>
	<td>
	<%-- <input type="text" id="caseNotes" name="clinicalNotes" tabindex="1" value="<%=(prevPatientDetails!=null && prevPatientDetails.getCaseNotes()!=null)?prevPatientDetails.getCaseNotes():"" %>" size="147" maxlength="200" validate="Today's Case Notes,string,no"/> --%>
	<!-- <!-- <input type="text" id="caseNotes" name="clinicalNotes" tabindex="1" value="" size="147" maxlength="5000" validate="Today's Case Notes,string,no" class="large"/> --> 
	<textarea maxlength="5000" id="caseNotes" name="clinicalNotes" class="large"></textarea>
	</td>
	</tr>
</table>
</div>
<div class="clear"></div>
<h4>Diagnosis</h4>
<div class="Block">
<input	type="hidden" id="systamicExam" class="large" name="systamicExam"	maxlength="200" />
<label>Working Diagnosis</label>
<%-- <input type="text" class="large"  size="119" id="initialDiagnosis" tabindex="1" value="<%=prevPatientDetails.getInitialDiagnosis()!=null?prevPatientDetails.getInitialDiagnosis():"" %>"	name="initialDiagnosis" maxlength="100" /> --%>
<input type="text" class="large"  size="119" id="initialDiagnosis" tabindex="1" value=""	name="initialDiagnosis" maxlength="500" />
<div class="clear"></div>

<%-- <label>System Diagnosis</label>

<input 	name="systemDiagnosis" value="<%=prevPatientDetails.getSystemDiagnosis()!=null?prevPatientDetails.getSystemDiagnosis().getSystemDiagnosisName()+"["+prevPatientDetails.getSystemDiagnosis().getId()+"]":"" %>"	id="systemDiagnosis" tabindex="1" class="large"  size="119" />
<input 	name="systemDiagnosis" value=""	id="systemDiagnosis" tabindex="1" class="large"  size="119" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('systemDiagnosis','ac2update','opd?method=autoCompleteForSystemDiagnosis',{parameters:'requiredField=systemDiagnosis'});
</script> --%>
		
<div class="clear"></div>

<label>ICD Diagnosis<span></span></label>
<input type="text" tabindex="1"	value="" id="icd"  name="icd" 	class="auto"  size="55" onblur="fillDiagnosisCombo(this.value);" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
</script>
<select name="<%=DIAGNOSIS_ID%>" multiple="4" size="5" tabindex="1" validate="ICD Diagnosis,string,no" id="diagnosisId" class="listBig">
	<option value="0">Select</option>
	<%
		/* if(ipIcdList.size()>0){ */
			if(false){
			for(DischargeIcdCode icdCode : ipIcdList){
				if(prevPatientDetails.getId()==icdCode.getOpdPatientDetails().getId())
				{
					
				
	%>
	<option value="<%=icdCode.getIcd().getIcdCode() %>" selected="selected"><%=icdCode.getIcd().getIcdName()+"["+icdCode.getIcd().getIcdCode()+"]" %></option>
	<%
	}
				}
			}%>
</select>

<input type="button" class="buttonDel" value="" onclick="deleteDgItems(this,'diagnosisId');" align="right" />
<div class="clear"></div>
</div>

<div class="Clear paddingTop15" ></div>
<div id="prevDiagCaseNoteDiv">
<%
int m = 1;	
if(caseSheetList.size() > 0){
		for(OpdPatientDetails patientDetails : caseSheetList){
			if(patientDetails.getVisit()!=null){
%>
             
<h6>
<%if(patientDetails.getOpdDate() != null){%>
<%=HMSUtil.convertDateToStringWithoutTime(patientDetails.getOpdDate()) %> <%=patientDetails.getOpdTime() %> <%=patientDetails.getDepartment()!=null?patientDetails.getDepartment().getDepartmentName():""%> <%} %> </h6>
<div class="clear"></div>

<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid1">
	<tr>
		<th scope="col">Case Notes</th>

	</tr>
	<tr>
	<%-- <td ><input type="text" class="large"  size="147" tabindex="1" value='<%=patientDetails.getCaseNotes()!=null?patientDetails.getCaseNotes():"" %>' maxlength="100" readOnly="true"/></td> --%>
<td><textarea  class="large"  readOnly="readonly"><%=patientDetails.getCaseNotes()!=null?patientDetails.getCaseNotes():""%></textarea></td>	
	</tr>
</table>
</div>
<div class="clear"></div>
<h4>Diagnosis</h4>
<div class="clear"></div>

<div class="Block">
<label>Working Diagnosis</label>
<%-- <label class="value"><%=patientDetails.getInitialDiagnosis()!=null?patientDetails.getInitialDiagnosis():""%></label> --%>
<input type="text" value="<%=patientDetails.getInitialDiagnosis()!=null?patientDetails.getInitialDiagnosis():""%>" class="large"  />
<div class="clear"></div>
<%-- 
<label>System Diagnosis</label>
<label class="value"><%=patientDetails.getSystemDiagnosis()!=null?patientDetails.getSystemDiagnosis().getSystemDiagnosisName():"" %></label> --%>

<label>ICD Diagnosis</label>
<%-- <%String diagnosis = "";
if(ipIcdList.size() > 0){
	boolean flag = false;
	for(DischargeIcdCode dischargeIcdCode : ipIcdList){
		flag = false;
		if((patientDetails.getInpatient()!=null && dischargeIcdCode.getOpdPatientDetails().getInpatient()!=null) && (patientDetails.getInpatient().getId()==dischargeIcdCode.getOpdPatientDetails().getInpatient().getId()))
		{
			flag =true;
		}
		else if((patientDetails.getVisit()!=null && dischargeIcdCode.getOpdPatientDetails().getVisit()!=null) && (patientDetails.getVisit().getId()==dischargeIcdCode.getOpdPatientDetails().getVisit().getId()))
		{
			flag =true;
		}
		if(flag)
		{
			if(!diagnosis.equals("")){
				diagnosis += ",";
			}
			diagnosis += dischargeIcdCode.getIcd().getIcdName();	
		}
		
	}
}
%>  --%>
<%String diagnosis = "";
if(ipIcdList.size() > 0){
	//System.out.println("ipIcdList"+ipIcdList.size());
	for(DischargeIcdCode dischargeIcdCode : ipIcdList){
		//System.out.println("ipIcdList1"+ipIcdList.size());
		if(patientDetails.getId() == dischargeIcdCode.getOpdPatientDetails().getId())
		{
			//System.out.println("ipIcdList2"+ipIcdList.size());
			if(!diagnosis.equals("")){
				diagnosis += ",";
			}
			diagnosis += dischargeIcdCode.getIcd().getIcdName();
		}
	
	}
}
%> 
<%
	if(!diagnosis.equals("")){
%>
<label class="valueFixedWidth"><%=diagnosis %></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>
<div class="clear"></div>
</div>

<div class="Clear paddingTop15" ></div>
<%}else if(patientDetails.getInpatient()!=null && ((patientDetails.getInitialDiagnosis()!=null && !patientDetails.getInitialDiagnosis().trim().equals(""))  || (patientDetails.getCaseNotes()!=null && !patientDetails.getCaseNotes().trim().equals("")) || patientDetails.getDischargeIcdCodes().size()>0)){ %>
<div class="clear"></div>
<h6><%=HMSUtil.convertDateToStringWithoutTime(patientDetails.getOpdDate()) %> <%=patientDetails.getOpdTime() %> <%=patientDetails.getDepartment()!=null?patientDetails.getDepartment().getDepartmentName():""%>  </h6>
<div class="clear"></div>
<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid1">
	<tr>
		<th scope="col">Case Notes</th>

	</tr>
	<tr>
	<%-- <td ><input type="text" class="large"  size="147" tabindex="1" value='<%=patientDetails.getCaseNotes()!=null?patientDetails.getCaseNotes():"" %>' maxlength="100" readOnly="true" /></td> --%>
	<td><textarea  class="large"  readOnly="readonly"><%=patientDetails.getCaseNotes()!=null?patientDetails.getCaseNotes():"" %></textarea></td>

	</tr>
</table>
</div>
<div class="clear"></div>
<h4>Diagnosis</h4>
<div class="clear"></div>
<div class="Block">

<label>Working Diagnosis</label>
<%-- <label class="value"><%=patientDetails.getInitialDiagnosis()!=null?patientDetails.getInitialDiagnosis():"" %></label> --%>
<input type="text" value="<%=patientDetails.getInitialDiagnosis()!=null?patientDetails.getInitialDiagnosis():""%>" class="large"  />
<div class="clear"></div>

<%-- <label>System Diagnosis</label>
<label class="value"><%=patientDetails.getSystemDiagnosis()!=null?patientDetails.getSystemDiagnosis().getSystemDiagnosisName():"" %></label>
 --%>
<label>ICD Diagnosis</label>
<%String diagnosis = "";

if(ipIcdList.size() > 0){
	for(DischargeIcdCode dischargeIcdCode : ipIcdList){
		if(patientDetails.getId() == dischargeIcdCode.getOpdPatientDetails().getId())
		{
			if(!diagnosis.equals("")){
				diagnosis += ",";
			}
			diagnosis += dischargeIcdCode.getIcd().getIcdName();
		}
		
	}
}
%> 
<%
	if(!diagnosis.equals("")){
%>
<label class="value"><%=diagnosis %></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>
<div class="clear"></div>
</div>

<div class="Clear paddingTop15" ></div>
<%}
		m++;}
}%>

<div class="Clear"></div>



</div>
</div>
<div class="clear"></div>
<!-- First Tab End -->
<div id="country2" class="tabcontentIn">

<!-- <div id="templateDivToShowHide" class="floatLeft"> -->

<div class="Block">

<label>Template</label>
<div id="treatmentDiv">
<select name="templateId" id="templateId" tabindex="1">
	<option value="0">Select</option>
	<%
	   Iterator itr=templateList.iterator();
	   while(itr.hasNext())
	   {
		   OpdTemplate opdTemplate=(OpdTemplate)itr.next();
		   String templateType=opdTemplate.getTemplateType();
		   if(templateType.equalsIgnoreCase("p"))
		   {
	%>
	<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getTemplateName()%></option>
	<%
		   }}%>
</select>
</div>

<%-- <div id="prevButtonDivToShowHide">
<input name="Prevoius2"	tabindex="1" type="button" value="Previous" class="button"	onclick="openPopupForPatientPrescription('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>','<%=visit.getDepartment().getId()%>','<%=visit.getId()%>')" />
</div> --%>
<div id="createPresDivToShowHide">
<input 	name="createPrescriptionTemplate" tabindex="1" type="button" value="Create Template"    class="buttonBig" onclick="showCreatePrescriptionTempate();" />
</div>
<%-- <div id="copyPrevPrescriptionTemplateDiv" style="display: none;">
<input name="copyPrevPrescriptionTemplate" tabindex="1" type="button" value="Copy Previous" class="buttonBig"	onclick="copyPrevPrescriptionTempate('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>');" />
</div> --%>

<div>
				<input name="createPrescriptionTemplate" tabindex="1" type="button"
					value="Update Template" class="buttonBig"
					onclick="showUpdateOpdTempate('P');" />
			</div>
<div id="prescriptionImportButton" class="floatLeft" >
<input	name="prescriptionImportButton1" tabindex="1" type="button"	value="Import New" class="button"	onclick="getListForTreatment('treatmentDiv');" /> 
	  
</div>
           <%--   <div class="floatRight">
				<a href="#" onclick="getTodayAllPrescriptionPopup('<%=visit.getId()%>','<%=hinId%>');">Today's Other Prescription</a>
		    </div> --%>
		    
		  <%--    <div class="floatRight">
				<a href="#" onclick="getTodayAllPrescriptionPopupForIPD('<%=hinId%>','y');">Current Medication</a>
		    </div> --%>
		     <div class="floatRight">
				<a href="#"
					onclick="getTodayAllPrescriptionPopup('<%=hinId%>','y','OPD');">Current Medication</a>
			</div>
		    
		    <div class="clear"></div>
</div>


<div id="testDiv">
<!--<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid1">
	<tr>
	<th scope="col">Remarks</th>

	<td><input type="text" name="remaks" tabindex="1"
			size="120" maxlength="45" /></td></tr>
	</table>
	-->
	
	    <script type="text/javascript">
      
       var itemClassCodeArray = new Array();
       var ItemClassIdUOMNotRequired = new Array();
    </script>
<%
	String []ItemClassIdUOMNotRequired = HMSUtil.getProperties("adt.properties", "ItemClassIdUOMNotRequired").trim().split(",");
	for(int i=0;i<ItemClassIdUOMNotRequired.length;i++)
	{
	%>
	<script>
	ItemClassIdUOMNotRequired[<%=i%>]= new Array();
	ItemClassIdUOMNotRequired[<%=i%>]= "<%=ItemClassIdUOMNotRequired[i]%>";
            </script>
<%}%>

    <%
        String []ItemClassCodeForLiquid = HMSUtil.getProperties("adt.properties", "ItemClassCodeForDrop").trim().split(",");
    for(int i=0;i<ItemClassCodeForLiquid.length;i++)
    {
    %>
    <script>

    itemClassCodeArray[<%=i%>]= new Array();
    itemClassCodeArray[<%=i%>][0] = "<%=ItemClassCodeForLiquid[i]%>";

                 
            </script>
<%    }%>
	<div class="cmntable" style="width:775px; margin-left:4px;">
			<table border="0" align="center" cellpadding="0" cellspacing="0"
					id="nomenclatureGrid">

					<tr>
						<th>Nomenclature/Material Code</th>
	<!-- 					<th colspan="1">New NIP</th> -->
						<!--      <th colspan="1">Injection</th>-->
						<!-- <th scope="col">PVMS No.</th> -->
						<!-- 		<th scope="col">Unit</th> -->
					<!-- 	<th scope="col">Class</th>
						<th scope="col">AU</th> -->
						<th scope="col">Dispensing Unit</th>
						<th scope="col">Dosage<span>*</span></th>
						<th scope="col">Frequency<span>*</span></th>
						<th scope="col">Days<span>*</span></th>
						<th scope="col">Total<span>*</span></th>
						<!--
		<th id="sosQtyLbl">Qty</th>
		-->
						<!--  <th scope="col">Total</th>
		<th scope="col">Intake</th> -->
			<!-- 			<th scope="col">Route</th> -->
						<!--<th scope="col">Type</th>-->
						<th scope="col">Instruction</th>
						<!-- <th scope="col">CT</th> -->
						<th scope="col">Stock</th>
						<th>Add</th>
						<th>Delete</th>

					</tr>
					<tr>
						<td><input type="text" value="" tabindex="1"
							id="nomenclature1" size="77" name="nomenclature1"
							onblur="checkForAlreadyIssuedPrescription(this.value,'1',document.getElementById('hinId').value);populatePVMS(this.value,'1');checkItem(1);displayAu(this.value,'1','<%=hinId%>');checkForPurchase(this.value,'1');" />
							<input type="hidden" name="itemId1" id="itemId1" value="" />
							<input type="hidden" name="itemIdClassificationId1" id="itemIdClassificationId1" value="" />
							<div id="ac2update1" style="display: none;" class="autocomplete"></div>
							<script type="text/javascript" language="javascript"
								charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem&screen=ward',{parameters:'requiredField=nomenclature1'});
			</script></td>
				<!-- 		<td><input type="text" name="otherMedicine1" tabindex="1"
							id="otherMedicine1" size="20"
							onblur="checkDuplicateOtherMedicine(this.value,'1');readOnlyNomenclature(this.value,'1');showSimilarMedicineNames(this.value);"
							validate="other Medicine,string,no" /></td> -->
	<%-- 					<td><select name="itemClass1" id="itemClass1">
								<option value="0">Select</option>
								<%for(MasItemClass mc : masItemClassList) {%>
								<option value="<%=mc.getId()%>"><%=mc.getItemClassName()%></option>
								<%} %>
						</select> <%
				MasItemClass  Mic = null;

			     for (int i = 0; i < masItemClassList.size(); i++) {
			    	 Mic = (MasItemClass) masItemClassList.get(i);
     			 %> <script>

     			itemClassArray[<%=i%>]= new Array();
     			itemClassArray[<%=i%>][0] = "<%=Mic.getId()%>";
     			itemClassArray[<%=i%>][1] = "<%=Mic.getItemClassName()%>";
            </script> <% }%></td> --%>
					<%-- 	<td><select name="itemConversionId1" id="itemConversionId1"
							tabindex="1" class="medium">
								<option value="0">Select</option>
								<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
								<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
								<%} %>
						</select> <%
	    		MasStoreItemConversion  masStoreItemConversion1 = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion1 = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion1.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion1.getItemUnitName()%>";
            </script> <% }%> <!-- </td> 
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" /> -->
							<input type="hidden" name="au1" tabindex="1" value="" id="au1"
							size="6" validate="AU,string,no" /> </td> --%>
						<td>
							<input type="text" name="dispensingUnit1" tabindex="1" id="dispensingUnit1"  size="6"  validate="Dispensing Unit,string,no"  readonly="readonly"/>
						<%-- <select name="dispensingUnit1" id="dispensingUnit1"
							tabindex="1" class="medium">
								<option value="0">Select</option>
								<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
								<option><%=masStoreItemConversion.getItemUnitName()%></option>
								<%} %>
						</select> --%>
						
						<input type="hidden"
							name="actualDispensingQty1" tabindex="1"
							id="actualDispensingQty1" value="" size="6"
							validate="AU,string,no" /> 
							<input type="hidden" tabindex="1"
							id="itemClassCode1" name="itemClassCode1"
							validate="itemClassCode,string,no" value="" />
							<input type="hidden" tabindex="1"
							id="highValueMedicine1" name="highValueMedicine1"
							validate="highValue,string,no" value="" />
						</td>
						<%-- <td><input type="checkbox" name="injCategory1" class="radio" id="injCategory1" value="y" />
		</td>--%>
						<td><input type="hidden" name="pvmsNo1" tabindex="1"
							id="pvmsNo1" size="10" readonly="readonly" /> <input type="text"
							name="dosage1" tabindex="1" value="" id="dosage1" size="5"
							maxlength="5"
							onblur="checkDosageValidation(this.value,'1');fillValue('1')" /></td>
						<td><select name="frequency1" id="frequency1" tabindex="1"
							class="medium"
							onchange="getFrequencyValue(this.value,'1');fillValueFromFrequency(this.value,'1');displaySOSQty(this.value,'1');fillValue('1')">
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

			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
     			 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%> <input type="hidden" name="frequencyValue1"
							id="frequencyValue1" value=""> <input type="text"
							name="sosQty1" tabindex="1" id="sosQty1" style="display: none;"
							size="3" onblur="fillValue('1')" maxlength="3"
							validate="Sos Qty,num,no" /></td>
						<td><input type="text" name="noOfDays1" tabindex="1"
							id="noOfDays1" onblur="fillValue('1')" size="5" maxlength="3"
							validate="No of Days,num,no" /></td>
						<td><input type="text" name="total1" tabindex="1" id="total1"
							size="5" validate="total,num,no" onblur="treatmentTotalAlert(this.value,1)" /></td>
						<!-- <td><input type="text" name="route1" tabindex="1" id="route1"
							value="" size="5" maxlength="20" validate="Route,string,no" /></td> -->
						<!--<td><select name="instructionACPC1" id="instructionACPC1" tabindex="1">
			<option value="">Select</option>
			<option value="AC">AC</option>
			<option value="PC" selected="selected">PC</option>
		</select>	</td>

		<td><select name="typeLeftRight1" id="typeLeftRight1"
			tabindex="1">
			<option value="">Select</option>
			<option value="left">Left</option>
			<option value="right">Right</option>
		</select></td>-->

						<td><input type="text" name="remarks1" tabindex="1"
							id="remarks1" size="10" maxlength="15" placeholder="1-1-1"/></td>
						<!-- <td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td> -->
						<td><input type="text" name="closingStock1" tabindex="1"
							value="" id="closingStock1" size="3"
							validate="closingStock,string,no" /></td>

						<td><input name="Button" type="button" class="buttonAdd"
							value="" onclick="addNomenclatureRow();" tabindex="1" /></td>
						<td><input type="button" name="delete" value=""
							class="buttonDel" onclick="removeRow('nomenclatureGrid','nomenclaturehdb',this);"
							tabindex="1" /></td>
					</tr>
					
				</table>
				<input type="hidden" name="nomenclaturehdb" value="1" id="nomenclaturehdb" />
<div class="clear"></div>



</div>
<%int nipInc=500; %>
	<%-- <h4>NIP</h4>
		
			<div class="cmntable" style="width:775px; margin-left:4px;">
				<table border="0" align="center" cellpadding="0" cellspacing="0"
					id="grid">

					<tr>
						<th>NIP</th>
						<th colspan="1">New NIP</th>
						<!--      <th colspan="1">Injection</th>-->
						<!-- <th scope="col">PVMS No.</th> -->
						<!-- 		<th scope="col">Unit</th> -->
						<th scope="col">Class</th>
						<th scope="col">AU</th>
						<th scope="col">Dispensing Unit</th>
						<th scope="col">UOM Qty</th>
						<th scope="col">Dosage<span>*</span></th>
						<th scope="col">Frequency<span>*</span></th>
						<th scope="col">Days<span>*</span></th>
						<th scope="col">Total<span>*</span></th>
						<!--
		<th id="sosQtyLbl">Qty</th>
		-->
						<!--  <th scope="col">Total</th>
		<th scope="col">Intake</th> -->
						<!-- <th scope="col">Route</th> -->
						<!--<th scope="col">Type</th>-->
						<th scope="col">Instruction</th>
						<!-- <th scope="col">CT</th> -->
						<th scope="col">Stock</th>
						<th>Add</th>
						<th>Delete</th>

					</tr>
					<tr>
						<td><input type="text" value="" tabindex="1"
							id="nomenclature<%=nipInc%>" size="30" name="nomenclature<%=nipInc%>"
							onblur="checkForAlreadyIssuedPrescription(this.value,'<%=nipInc%>',document.getElementById('hinId').value);populatePVMS(this.value,'<%=nipInc%>');checkItem(<%=nipInc%>);disableOtherMedicine(this.value,'<%=nipInc%>');displayAu(this.value,'<%=nipInc%>','<%=hinId%>');checkForPurchase(this.value,'<%=nipInc%>');" />
							<input type="hidden" name="itemId<%=nipInc%>" id="itemId<%=nipInc%>" value="" />
							<input type="hidden" name="itemIdClassificationId<%=nipInc%>" id="itemIdClassificationId<%=nipInc%>" value="" />
							<div id="ac2update2" style="display: none;" class="autocomplete"></div>
							<script type="text/javascript" language="javascript"
								charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature<%=nipInc%>','ac2update2','opd?method=getNipItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature<%=nipInc%>'});
			</script></td>
						<td><input type="text" name="otherMedicine<%=nipInc%>" tabindex="1"
							id="otherMedicine<%=nipInc%>" size="20"
							onblur="checkDuplicateOtherMedicine(this.value,'<%=nipInc%>');readOnlyNomenclature(this.value,'<%=nipInc%>');showSimilarMedicineNames(this.value);"
							validate="other Medicine,string,no" /></td>
						<td><select name="itemClass<%=nipInc%>" id="itemClass<%=nipInc%>">
								<option value="0">Select</option>
								<%for(MasItemClass mc : masItemClassList) {%>
								<option value="<%=mc.getId()%>"><%=mc.getItemClassName()%></option>
								<%} %>
						</select> <%
				MasItemClass  Mic = null;

			     for (int i = 0; i < masItemClassList.size(); i++) {
			    	 Mic = (MasItemClass) masItemClassList.get(i);
     			 %> <script>

     			itemClassArray[<%=i%>]= new Array();
     			itemClassArray[<%=i%>][0] = "<%=Mic.getId()%>";
     			itemClassArray[<%=i%>][1] = "<%=Mic.getItemClassName()%>";
            </script> <% }%></td>
						<td><select name="itemConversionId<%=nipInc%>" id="itemConversionId<%=nipInc%>"
							tabindex="1" class="medium">
								<option value="0">Select</option>
								<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
								<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
								<%} %>
						</select> <%
						MasStoreItemConversion masStoreItemConversion1 = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion1 = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion1.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion1.getItemUnitName()%>";
            </script> <% }%> <!-- </td> 
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" /> -->
							<input type="hidden" name="au<%=nipInc%>" tabindex="1" value="" id="au<%=nipInc%>"
							size="6" validate="AU,string,no" /> <input type="hidden"
							name="actualDispensingQty<%=nipInc%>" tabindex="1"
							id="actualDispensingQty<%=nipInc%>" value="" size="6"
							validate="AU,string,no" /> 
							<input type="hidden" tabindex="1"
							id="itemClassCode<%=nipInc%>" name="itemClassCode<%=nipInc%>"
							validate="itemClassCode,string,no" value="" />
							<input type="hidden" tabindex="1"
							id="highValueMedicine<%=nipInc%>" name="highValueMedicine<%=nipInc%>"
							validate="highValue,string,no" value="" /></td>
						<td><select name="dispensingUnit<%=nipInc%>" id="dispensingUnit<%=nipInc%>"
							tabindex="1" class="medium">
								<option value="0">Select</option>
								<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
								<option><%=masStoreItemConversion.getItemUnitName()%></option>
								<%} %>
						</select></td>
						<td><input type="checkbox" name="injCategory<%=nipInc%>" class="radio" id="injCategory<%=nipInc%>" value="y" />
		</td>
		<td><input type="text" name="uomQty<%=nipInc%>" tabindex="1" id="uomQty<%=nipInc%>" maxlength="5" size="5" validate="UOM Qty,float,no"/></td>
							 
						<td><input type="hidden" name="pvmsNo<%=nipInc%>" tabindex="1"
							id="pvmsNo<%=nipInc%>" size="10" readonly="readonly" /> <input type="text"
							name="dosage<%=nipInc%>" tabindex="1" value="" id="dosage<%=nipInc%>" size="5"
							maxlength="5"
							onblur="checkDosageValidation(this.value,'<%=nipInc%>');fillValue('<%=nipInc%>')" /></td>
						<td><select name="frequency<%=nipInc%>" id="frequency<%=nipInc%>" tabindex="1"
							class="medium"
							onchange="getFrequencyValue(this.value,'<%=nipInc%>');fillValueFromFrequency(this.value,'<%=nipInc%>');displaySOSQty(this.value,'<%=nipInc%>');fillValue('<%=nipInc%>')">
								<option value="0">Select</option>
								<%

		      for(MasFrequency masFrequency1 : frequencyList){
		       int id = masFrequency1.getId();
		       String name = masFrequency1.getFrequencyName();
          %>
								<option value="<%=id %>"><%=name%></option>
								<%} %>
						</select> <%
	    		  masFrequency = new MasFrequency();

			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
     			 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%> <input type="hidden" name="frequencyValue<%=nipInc%>"
							id="frequencyValue<%=nipInc%>" value=""> <input type="text"
							name="sosQty<%=nipInc%>" tabindex="1" id="sosQty<%=nipInc%>" style="display: none;"
							size="3" onblur="fillValue('<%=nipInc%>')" maxlength="3"
							validate="Sos Qty,num,no" /></td>
						<td><input type="text" name="noOfDays<%=nipInc%>" tabindex="1"
							id="noOfDays<%=nipInc%>" onblur="fillValue('<%=nipInc%>')" size="5" maxlength="3"
							validate="No of Days,num,no" /></td>
						<td><input type="text" name="total<%=nipInc%>" tabindex="1" id="total<%=nipInc%>"
							size="5" validate="total,num,no" onblur="treatmentTotalAlert(this.value,<%=nipInc%>)" /></td>
						<td>
						<input type="text" name="route<%=nipInc%>" tabindex="1" id="route<%=nipInc%>"
							value="" size="5" maxlength="20" validate="Route,string,no" />
							</td>
						<!--<td><select name="instructionACPC1" id="instructionACPC1" tabindex="1">
			<option value="">Select</option>
			<option value="AC">AC</option>
			<option value="PC" selected="selected">PC</option>
		</select>	</td>

		<td><select name="typeLeftRight1" id="typeLeftRight1"
			tabindex="1">
			<option value="">Select</option>
			<option value="left">Left</option>
			<option value="right">Right</option>
		</select></td>-->

						<td><input type="text" name="remarks<%=nipInc%>" tabindex="1"
							id="remarks<%=nipInc%>" size="10" maxlength="15" placeholder="1-1-1"/></td>
						<!-- <td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td> -->
						<td><input type="text" name="closingStock<%=nipInc%>" tabindex="1"
							value="" id="closingStock<%=nipInc%>" size="3"
							validate="closingStock,string,no" /></td>

						<td><input name="Button" type="button" class="buttonAdd"
							value="" onclick="addRowForNIP();" tabindex="1" /></td>
						<td><input type="button" name="delete" value=""
							class="buttonDel" onclick="removeRow('grid','hdb',this);"
							tabindex="1" /></td>
					</tr>
					
				</table>
				
				<div class="clear"></div>
			</div> --%>
			
			<input type="hidden" name="hdb" value="<%=nipInc%>" id="hdb" />
</div>


<%-- <div id="testDiv">
<h6>Today's</h6>
<div class="small">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		 <th scope="col">Nomenclature</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">Days</th>
		<th scope="col">Route</th>
		<th scope="col">Remarks</th>
		<th>Add</th>
		<th>Delete</th>
		
	</tr>
	<%
	int l =0;
		/* if(ipdPrescriptionList.size() > 0){ */
			if(false){
			PatientPrescriptionHeader prescriptionHeader = ipdPrescriptionList.get(0);
			for(PatientPrescriptionDetails prescriptionDetails : prescriptionHeader.getPatientPrescriptionDetails()){
				l++;
	%>
	<tr>
		<td>
	    <input type="text" size="50" value="<%=prescriptionDetails.getItem().getNomenclature()+"("+prescriptionDetails.getItem().getId()+")"+"["+prescriptionDetails.getItem().getPvmsNo()+"]"%>" tabindex="1" id="nomenclature<%=l %>" size="70"  name="nomenclature<%=l %>" onblur="populatePVMS(this.value,'<%=l %>'),checkItem('<%=l %>');checkForPurchase(this.value,'atul','<%=l %>');"  />
	    <input type="hidden" name="itemId<%=l%>" id="itemId<%=l%>"	value="<%=prescriptionDetails.getItem().getId() %>" />
	   	<div id="ac2update1<%=l %>" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature<%=l %>','ac2update1<%=l %>','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature<%=l %>'});
			</script>
	    </td>
		<td><input type="hidden" name="pvmsNo<%=l %>" tabindex="1" id="pvmsNo<%=l %>" value="<%=prescriptionDetails.getItem().getPvmsNo() %>"	size="10" readonly="readonly" />
		<input type="text" name="dosage<%=l %>" tabindex="1" value="<%=prescriptionDetails.getDosage() %>" id="dosage<%=l %>"	size="2" maxlength="5" /></td>
		<td><select name="treatmentFrequency<%=l %>" id="frequency<%=l %>" class="small" tabindex="1" onclick="fillValueFromFrequency(this.value,'<%=l %>');" >
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

		<td><input type="text" name="noOfDays<%=l %>" tabindex="1" id="noOfDays<%=l %>" value="<%=prescriptionDetails.getNoOfDays()!=null?prescriptionDetails.getNoOfDays():"" %>" onblur="fillValue(this.value,'<%=l %>')"  size="2"	maxlength="3" validate="No. of Days,num,no" />
			
		</td>
		<td><input type="text" name="route<%=l %>" tabindex="1" id="route<%=l %>"  size="5" maxlength="20" value="<%=prescriptionDetails.getRoute()!=null?prescriptionDetails.getRoute():"" %>"	 validate="Route,string,no" />
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
	    <input type="text" value="" tabindex="1" id="nomenclature<%=l %>" size="50"  name="nomenclature<%=l %>" onblur="populatePVMS(this.value,'<%=l %>'),checkItem('<%=l %>');checkForPurchase(this.value,'atul','<%=l %>');"  />
	    <input type="hidden" name="itemId<%=l%>" id="itemId<%=l%>"/>
	    <div id="ac2update1<%=l %>" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature<%=l %>','ac2update1<%=l %>','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature<%=l %>'});
			</script>
	    </td>
		<td><input type="hidden" name="pvmsNo<%=l %>" tabindex="1" id="pvmsNo<%=l %>"	size="10" readonly="readonly" />
		<input type="text" name="dosage<%=l %>" tabindex="1" id="dosage<%=l %>"	size="2" maxlength="5" /></td>
		<td><select name="treatmentFrequency<%=l %>" id="frequency<%=l %>" class="small" tabindex="1" onclick="fillValueFromFrequency(this.value,'<%=l %>');" >
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

		<td><input type="text" name="noOfDays<%=l %>" tabindex="1" id="noOfDays<%=l %>" onblur="fillValue(this.value,'1')"  size="2"	maxlength="3" validate="No. of Days,num,no" />
			
		</td>
		<td><input type="text" name="route<%=l %>" tabindex="1" id="route<%=l %>"  size="5" maxlength="20"	value="" validate="Route,string,no" />
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
</div>
	<input type="hidden" name="hdb" value="<%=l %>" id="hdb" />
</div> --%>
<!-- </div> -->
<div id="prevTreatmentDiv"></div>
</div>

<div id="country3" class="tabcontentIn">
	<div class="Block">
		<label>Template</label>
		<div id="investigationDiv">
			<select name="investigationTemplateId" id="investigationTemplateId"
				tabindex="1" 
				>
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
				<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getTemplateName()%></option>
				<%
		   }
	      }

		%>

			</select>
		</div>
		<%-- <input	name="Prevoius" type="button" value="Previous" tabindex="1"	class="button"	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" /> --%>
		<div id="createInvestigationDivToShowHide">
			<input name="investigationTemplate" type="button"
				value="Create Template" tabindex="1" class="buttonBig"
				onclick="showCreateInvestigationTemplate();" />
		</div>
		<div >
				<input name="createupdateTemplate" tabindex="1" type="button"
					value="Update Template" class="buttonBig"
					onclick="showUpdateOpdTempate('I');" />
			</div>
		<div id="copyPrevInvestigationTemplateDiv" style="display: none">
			<input name="copyPrevInvestigationTemplate" tabindex="1"
				type="button" value="Copy Previous" class="buttonBig"
				onclick="showCreateInvestigationTemplate();" />
			
		</div>
		<div id="investigationImportButton1">
			<input name="investigationImportButton1" tabindex="1" type="button"
				value="Import New" class="button"
				onclick="getListForTreatment('investigationDiv');" />
		</div>
		
	</div>


<%
int inc = 0;
%>
<div class="clear"></div>
<div id="gridview">
<h6>Today's</h6>
<div class="small">
	<table border="0" align="center" cellpadding="0" cellspacing="0"
				id="investigationGrid">
				<tr>
				  <td colspan="4" >
			      	<div class="floatleft">				
							
							<div class="labRadiologyDivfixed"><input type="radio" value="Lab" class="radioCheckCol2" style="margin-right:5px;"
							name="labradiologyCheck" checked="checked" onchange="" /> LAB</div>		
						
							
							<div class="labRadiologyDivfixed" style="width:90px;"><input type="radio" value="Radio" class="radioCheckCol2" style="margin-right:5px;"
							name="labradiologyCheck" onchange="" /> Radiology</div>
							 <input
							type="hidden" name="investigationCategory"
							id="investigationCategory" />
						<div class="clear"></div>
					</div>
			 </td>
					
					
				</tr>
				<tr>
					<th scope="col">Investigation</th>
					<!-- <th scope="col">Refer to MH</th> -->
					<th>Date</th>
					<th scope="col">Add</th>
					<th scope="col">Delete</th>
				</tr>
				<tr>
					<td><input type="text" value=""
						tabindex="1" id="chargeCodeName1" size="100"
						name="chargeCodeName1"
						onblur="checkForAlreadyPrescribedInvestigation(this.value,'1',document.getElementById('hinId').value);if(validateInvestigationAutoComplete(this.value,'1')){checkForChargeCode(this.value,'1','chargeCodeVal');}" />
						<div id="ac2updateInv1" style="display: none;" class="autocomplete"></div>
						 <script type="text/javascript" language="javascript"
							charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName1','ac2updateInv1','opd?method=getInvestigationListForAutoComplete',{
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty1" tabindex="1" name="qty1"
						size="10" maxlength="6" validate="Qty,num,no" /> <input
						type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
						size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

					</td>
					<td><input  type="text" class="calDate" onchange="checkForAlreadyPrescribedInvestigation(document.getElementById('chargeCodeName1').value,'1',document.getElementById('hinId').value);"  id="investigationDate1" name="investigationDate1" placeholder="DD/MM/YYYY" validate="LMP Date,string,no" value="<%=currentDate%>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'investigationDate1');" maxlength="10" style="width: 120px"/></td>
					<td><input name="Button" type="button" class="buttonAdd"
						value="" tabindex="1" onclick="addRowForInvestigation();" /></td>
					<td><input type="button" name="delete" value=""
						class="buttonDel" tabindex="1"
						onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


				</tr>
			</table>
		
</div>
		<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
	</div>
	
	<div class="Clear"></div>
	<div id="prevInvestigationDiv"></div>
</div>

<div id="country4" class="tabcontentIn">
<div class="Clear"></div>
<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="proceduregrid">
	<tr>
		<th scope="col">Procedure Name</th>
		<th colspan="2">Duration</th>
		<th>Frequency</th>
		<th>No. of Days</th>
		<th>Remarks</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<%
	int i=1;
	 %>
	<tr>
		<td>
		<input type="hidden" name="visitProcedureId" id="visitProcedureId" value="" />
		<input type="hidden" name="proDtId<%=i %>" id="proDtId<%=i %>" value="" />
		<input type="text" name="procedure<%=i %>" id="procedure<%=i %>" value="" size="30" onblur="getProcedureId(this.value,<%=i %>);" tabindex="1"/>
		   <div id="ac2update3<%=i %>" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('procedure<%=i %>','ac2update3<%=i %>','registration?method=getProcedureForAutoComplete',{parameters:'requiredField=procedure<%=i %>'});
			</script>
		<input type="hidden" name="procedureId<%=i %>" id="procedureId<%=i %>"	value="" /> 
		</td>
		<td>
		<input type="text" name="procDuration<%=i %>" tabindex="1" id="procDurationId<%=i %>" value=""	size="2" maxlength="3" /></td>
		<td width="8%">min</td>
	
	<td width="27%" class="rowcolor">
	
<select name="procfrequency<%=i %>" id="procfrequency<%=i %>"	tabindex="1"	validate="Frequency,string,no">
			<option value="0">Select</option>
			<%
			 			for(MasFrequency masFreq : frequencyList){
			 				
			 		%>
			<option value="<%=masFreq.getId() %>"><%=masFreq.getFrequencyName() %></option>
			<%} %>
		</select>

		</td>
		<td>
		
		<input type="text" name="procNoOfDays<%=i %>" tabindex="1" id="procNoOfDays<%=i%>"  size="3" value="<%//=nursingcareSetup.getNoOfDays()!=null?nursingcareSetup.getNoOfDays():"" %>"	maxlength="3" validate="No. of Days,num,no" /></td>
		
		<td>	
			<input	type="text" name="procRemarks<%=i %>" value="" id="procRemarks<%=i %>" size="30"  tabindex="1" maxlength="50"/>
			</td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addProcedureRow();" tabindex="1" /></td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('proceduregrid',this);" tabindex="1" />
			</td>
	</tr>

	</table>
	</div>
		<input type="hidden" value="<%=i %>" name="procCount" id="procCount" />
		<div class="Clear"></div>
	<div id="prevProcedureDiv"></div>
</div>

<div id="country5" class="tabcontentIn">
<div class="Clear"></div>
<div class="Clear"></div>
<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="therapygrid">
<tr>
		<th scope="col">Therapy Name</th>
		<th colspan="2">Duration</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">Remarks</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<%
	int j = 1;
	%>
<tr>
	<td>
	    <input type="text" value="" tabindex="1" id="therapyTypeId<%=j %>" size="30"  name="therapyType<%=j %>" onblur="getTheraphyId(this.value,<%=j %>);"  />
	    
	   
	     <div id="ac2update4<%=j %>" style="display:none;"  class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('therapyTypeId<%=j %>','ac2update4<%=j %>','opd?method=getTherapyTypeListForAutoComplete',{parameters:'requiredField=therapyType<%=j %>'});
			</script>
			<div id="therapyDiv<%=j %>">
			<input type="hidden" name="therapyId<%=j %>" id="therapyId<%=j %>"	value="" /> </div>
		</td>
		
	<td><input type="text" name="duration<%=j %>" tabindex="1" id="durationId<%=j %>"	size="2" maxlength="5" /></td>
	<td width="8%">min</td>
	<td><select name="frequencyId<%=j %>" id="frequencyId<%=j %>" tabindex="1"  >
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFreq : frequencyList){
		       
          %>
			<option value="<%=masFreq.getId() %>"><%=masFreq.getFrequencyName()%></option>
			<%} %>
		</select> 
		</td>
	<td><input type="text" name="phyNoOfDays<%=j %>" tabindex="1" id="phyNoOfDays<%=j %>"  size="3"	maxlength="3" validate="No. of Days,num,no" /></td>
	<td><input type="text" name="remarks<%=j %>" tabindex="1" id="remarks<%=j %>" size="30" maxlength="40"/>
			</td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addPhysiotherapyRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('therapygrid',this);" tabindex="1" />
			</td>
		
	</tr>

</table>
</div>
	<input type="hidden" name="therapyCount" value="<%=j %>" id="therapyCount" />
	<div class="Clear"></div>
	<div id="prevTherapyDiv"></div>
</div>
<div id="country6" class="tabcontentIn">
<div class="Clear"></div>
<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="dietgrid">
<tr>
		<th scope="col">Type of Diet</th>
		<th scope="col">Spl. Instructions</th>
	
	</tr>
	<%
		/* if(ipdPatientDietList.size() >0){ */
			if(false){
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
	<td><input type="text" name="splInstructions" maxlength="50" value="" size="50"/></td>
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
	<td><input type="text" name="splInstructions" maxlength="50" value="" size="50"/></td>
	</tr>
	
	<%} %>
</table>
</div>
	<div class="Clear"></div>
<div id="prevDietDiv"></div>

</div>
<div id="country7" class="tabcontentIn">
<div class="Clear"></div>

<div class="small">
<div id="referalDiv" >
		
									<label>Referral </label> <select id="referral" name="referral"
										class="midium">
										<option value="0" selected="selected">No</option>
										<option value="1">Yes</option>
									</select>
		
								<div id="referDiv" class="col collaps">
								<div style="display:none">
									<label>Refer To</label>
									<!-- <label><input type="checkbox"  name="referBack" id="referBack"  onclick="selectDept('referInternal');"/>ReferBack</label> -->
						<%-- 			<%
									if(opdpatientDetailId !=0)
									{%>
										<label class="autoSpace"><input type="checkbox"
											class="radioCheckCol2" name="referBack" id="referBack"
											value="Internal"
											onclick="selectReferBack('<%out.print(referralDistrict);%>@@@<%out.print(referralHospital);%>@@@<%out.print(referralDept);%>@@@<%out.print(referralType);%>@@@<%out.print(deptNameforExternal);%>');" />ReferBack</label>
										<%
									}
									%> --%>
		
									<label class="autoSpace"><input type="radio"
										class="radioCheckCol2" name="referTo" id="referInternal"
										value="Internal" onclick="checkReferTOIPD('referInternal');" style="margin:1px 5px 0px 0px;" />Internal</label>
									<label class="autoSpace"><input type="radio"
										class="radioCheckCol2" name="referTo" id="referExternal"
										value="Empanel" onclick="checkReferTOIPD('referExternal');" style="margin:1px 5px 0px 0px;" />Empanel</label>
		                           </div>
									<div class="clear"></div>
									<label>Refer Date:</label> <input type="text"
										id="referVisitDate" name="referVisitDate" class="date"
										value="<%=currentDate%>"
										readonly="readonly"
										 />
										 <!-- onblur="checkAdmte()" -->
									
									<img  src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.ipdCaseSheet.referVisitDate,event);" /> 
									<!--  <label id="priorityLabelId">Current Proirity No.</label> <select
										id="priorityId" name="priorityName" tabindex="1">
										<option value="3">3</option>
										<option value="2">2</option>
										<option value="1">1</option>
									</select> -->
									<div class="clear"></div>
									<%-- <label id="referdistrictLabel">District</label> <select
										id="referdistrict" name="referdistrict"
										onchange="fnGetDistrictHospital();">
										<option value="0">Select</option>
										<%for(MasDistrict district:masDistrictList){%>
										<%if(districtId==district.getId()){ %>
										<option value="<%=district.getId()%>" selected="selected"><%=district.getDistrictName()%></option>
										<%}else{ %>
										<option value="<%=district.getId()%>"><%=district.getDistrictName()%></option>
										<%} %>
										<%}%> 
									
									</select> --%><%--<label id="referHospitalTypeLabel">Hospital Type</label>  <select
										id="referHospitalType" name="referHospitalType"
										onchange="fnGetDistrictHospital();">
										<option value="0">Select</option>
										<%if(hospitalTypeList.size()>0){
										for(MasHospitalType masHospitalType:hospitalTypeList){%>
										<%if(hospitalTypeId==masHospitalType.getId()){ %>
										<option value="<%=masHospitalType.getId()%>" selected="selected"><%=masHospitalType.getHospitalTypeName()%></option>
										<%}else{ %>
										<option value="<%=masHospitalType.getId()%>"><%=masHospitalType.getHospitalTypeName()%></option>
										<%} %>
										<%}}%>
									</select> --%>
									<div class="clear"></div>
		<!-- Babita -->
									<label id="referhospitalLabel" style="display: none;" >Hospital <span>*</span></label> <select
										id="referhospital" name="referhospital"
										onchange="fnGetHospitalDepartment(this.value);" style="display: none;" >
										<option value="0">Select</option>
										<%for(MasImpanneledHospital msih:masImpanneledHospitalList){%>
										<option value="<%=msih.getId()%>"><%=msih.getImpanneledHospitalName()%></option>
										<%}%>
									</select>
									
								  <label id= referdayslLabel style="display: none;">No. of Days</label> <input id="referdays" name="referdays" type="text"
									maxlength="2" style="display: none;" />
									
									<div class="clear"></div>
		
									<label id="referdepartmentLabel" >Department <span>*</span></label> <select
										id="referdepartment" name="referdepartment"
										onchange="fnGetDoctorDepartment(this.value);">
										<option value="0">Select</option>
										<%for(MasDepartment dep:deptList){
										%>
										<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
								<%-- 		<%if(deptId==dep.getId()) {%>
										<option value="<%=dep.getId()%>" selected="selected"><%=dep.getDepartmentName()%></option>
										<%}else{ %>
										<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
										<%} %> --%>
										<%}%>
									</select> <label id ="refereddoctorlabel">Doctor  <span>*</span></label> <select id="refereddoctor"
										name="refereddoctor">
										<option value="0">Select</option>
									</select>
		
		
									<div class="clear"></div>
									<label>Referral Note</label>
									<textarea name="remarksBYDoc" validate="remarksBYDoc,string,no"
										id="patientAdvise" cols="0" rows="0" maxlength="500"
										tabindex="5" onkeyup="return checkLength(this)"></textarea>
									<!-- <input type="button" class="buttonAuto-buttn" value="+"
										onclick="" /> -->
										<!--  <label>Referral Notes</label>
									<textarea name="referralNote" validate="referralNote,string,no"
										id="referralNote" cols="0" rows="0" maxlength="500" tabindex="5"
										onkeyup="return checkLength(this)"></textarea> -->
									<!-- <input type="button" class="buttonAuto-buttn" value="+"
										onclick="" /> -->
								</div>
								<%-- <input type="hidden" name="userName" value="<%=userName %>" /> --%>
						<%-- 		<%
									if(visit.getHin().getRelation() != null){
							    	 relationName=visit.getHin().getRelation().getRelationName();
								if(visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self")){
								%>
								<label>No. of Days</label> <input name="days" type="text"
									maxlength="1" />
								<%}} %> --%>
							</div>
</div>
</div>

<div id="country8" class="tabcontentIn">
<div class="Clear"></div>



<div class="small">
<div id="prevConsultaionDiv" >
</div>


</div>
</div>

<div id="country9" class="tabcontentIn">
<div class="Clear"></div>
<div class="small">
<div id="prevTransferDiv" >
</div>
</div>
</div>


<script type="text/javascript">	var	frequencyArray= new Array();
<%
	    		MasFrequency  frequency = new MasFrequency();

			     for (int k = 0; k < frequencyList.size(); k++) {
			    	 frequency = (MasFrequency) frequencyList.get(k);
     			 %> 

     			frequencyArray[<%=k%>]= new Array();
     			frequencyArray[<%=k%>][0] = "<%=frequency.getId()%>";
     			frequencyArray[<%=k%>][1] = "<%=frequency.getFrequencyName()%>";
     			 <% }%>    </script>
<div class="Clear paddingTop15"></div>
</div>
<div class="Block">
<label>Ready to Discharge</label>
<%
	if(prevPatientDetails.getInpatient()!=null && prevPatientDetails.getInpatient().getAdStatus().equals("R")){
%>
<input type="checkbox" value="y" name="readyToDischarge" id="readyToDischarge" class="radio" onchange="javascript:validationToggle()" checked="checked">
<%-- <label>Refer</label>
<input type="checkbox" value="" name="referToName" id="referToId" onclick="getReferDoctors();" class="checkboxMargin"/>
<input type="hidden" value="" name="referToName1" id="referToId1" />
<div id="referDivId" style="display: none;">
<label>Doctor</label>
<select name="docName" id="docNameId">
<option value="0">Select</option>
<%for(MasEmployee me:employeeList){ %>
<option value="<%=me.getId() %>"><%=me.getFirstName() %></option>
<%} %>
</select>
<div class="clear"></div>
<label>Remarks By Doctor</label>
<textarea name="remarksBYDoc" id="remarksBYDocId"></textarea>

</div> --%>
<%}else{ %>
<input type="checkbox" value="y"  onchange="javascript:validationToggle()" name="readyToDischarge" id="readyToDischarge" class="radio">
<%-- <label>Refer</label>
<input type="checkbox" value="" name="referToName" id="referToId" onclick="getReferDoctors();" class="checkboxMargin"/>
<input type="hidden" value="" name="referToName1" id="referToId1" />
<div id="referDivId" style="display: none;">
<label>Doctor</label>
<select name="docName" id="docNameId">
<option value="0">Select</option>
<%for(MasEmployee me:employeeList){ %>
<option value="<%=me.getId() %>"><%=me.getFirstName() %></option>
<%} %>
</select>
<div class="clear"></div>
<label>Remarks By Doctor</label>
<textarea name="remarksBYDoc" id="remarksBYDocId"></textarea>

</div> --%>
<%} %>
<div class="Clear"></div>
</div>
<%  if(caseSheetList.size() > 0)
 {
	
 String gender = "";
	if(caseSheetList.get(0).getInpatient()==null)
 
 {
	gender = caseSheetList.get(0).getVisit().getHin().getSex().getAdministrativeSexCode();
 }
	else
		
			 
		 {
			gender = caseSheetList.get(0).getInpatient().getHin().getSex().getAdministrativeSexCode();
		 }
	if(gender.equalsIgnoreCase("F"))
	{
 %>

<h4>Pregnancy</h4>
 <div class="Block">
 <%	 
 if(caseSheetList.get(0).getPregnancy()!=null && caseSheetList.get(0).getPregnancy().equalsIgnoreCase("y"))
 {
%>
   <label class="">Pregnant</label> <input type="checkbox" name="pregnancy" id="pregnancy"  class="radioAuto" value="y" onclick="fillPregnancylValue(this.id);putLMPEDD(this.id,'<%=caseSheetList.get(0).getLmpDate()!=null?HMSUtil.convertDateToStringWithoutTime(caseSheetList.get(0).getLmpDate()):false%>','<%=caseSheetList.get(0).getEddDate()!=null?HMSUtil.convertDateToStringWithoutTime(caseSheetList.get(0).getEddDate()):false%>')" checked="checked"/>
   <label class="">LMP Date</label>
<input type="text" name="lmp_date" id="lmp_date" readonly="readonly" id="lmp_date"  value='<%=caseSheetList.get(0).getLmpDate()!=null?HMSUtil.convertDateToStringWithoutTime(caseSheetList.get(0).getLmpDate()):""%>'/>  
 
 <label class="">EDD</label><input type="text" name="edd" id="edd" readonly="readonly" value='<%=caseSheetList.get(0).getEddDate()!=null?HMSUtil.convertDateToStringWithoutTime(caseSheetList.get(0).getEddDate()):""%>'/>

 <%}
 
 else
 {%>
<label class="">Pregnant</label> <input type="checkbox" name="pregnancy" id="pregnancy"  class="radioAuto" value="n" onclick="fillPregnancylValue(this.id);"/>
	<label class="">LMP Date</label>
<input type="text" name="lmp_date" id="lmp_date" readonly="readonly" id="lmp_date"  value="" onblur="generateEDD(this.id, pregnancy);"/>  
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.getElementById('lmp_date'),event);" onchange="onSlelctSurgeryDate();" /></td>
 <label class="">EDD</label><input type="text" name="edd" id="edd"readonly="readonly"/>
 <%}%>
  </div>
 <%} }
 %>
 
  
<div class="Clear"></div>
<input type="hidden" name="ageName" value="<%=inpatient.getAge() %>" id="ageId" /> 
<input	name="hospitalId" type="hidden" id="hospitalId" value="<%=hospitalId%>"  />
<input type="hidden" name="genderId" id="genderId" value="<%=patient.getSex().getId() %>">
<input type="hidden" name="consultationDate" id="consultationDate" value="<%=currentDate%>">

<div class="division"></div>	
<input type="button"	name="sss" class="button" value="Submit"	onclick="if(validateNip()){submitForm('ipdCaseSheet','ipd?method=submitIpdCaseSheetDetails','validateRows');}" />
<input type="button" class="button" value="Back" onClick="submitForm('ipdCaseSheet','ipd?method=showPatientListJsp');" />
<input type="reset" name="reset" value="Reset"/>	
<div class="Clear"></div>
<div class="division"></div>

</form>

<script>
//validations added by Atul 	
function validateReferal()
{
	var returnValue = true;
  
	var referral = document.getElementById('referral').value;
	if(referral =='1')
       {		
		 if(document.getElementById('referInternal').checked)
			 {  
			  var refDoc = document.getElementById('refereddoctor').value;
			    if(refDoc==0 )
			    	{
			    	 alert("Please select Doctor");
			    	 returnValue = false;
			    	} 
			    	 
			 }
		 else if(document.getElementById('referExternal').checked)	 
			 {
			    var refHosp = document.getElementById('referhospital').value;
			    if(refHosp==0 )
			    	{
			    	 alert("Please select hospital");
			    	 returnValue = false;
			    	} 
			 }
       }
	
	return returnValue;
}

function validationToggle()
{
	
    
	 if(document.getElementById('readyToDischarge').checked)
	 { 
		 document.getElementById('diagnosisId').setAttribute("validate","ICD Diagnosis,string,no");
	 }
	 else
		 {
		 document.getElementById('diagnosisId').setAttribute("validate","ICD Diagnosis,string,no");
		 }
}

function validateRows(){
	if(!validateReferal())
		{
		   return false;
		}
/* 	if(document.getElementById('caseNotes').value==''){
		alert("Please enter Case Notes.");
		return false;
	} */

	
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

	var procCount = document.getElementById('procCount').value;
//	var therapyCount = document.getElementById('therapyCount').value;
	if(treatCount>0){
		for(var i =1;i<=procCount;i++){
			if(document.getElementById('procedure'+i) && document.getElementById('procedure'+i).value!=''){
				if(document.getElementById('procfrequency'+i)){
					if(document.getElementById('procfrequency'+i).value == '0'){
						alert('Please select frequency for procedure in row '+i);
						return false;
					  }
					 }
					
					if(document.getElementById('procDurationId'+i)){
					if(document.getElementById('procDurationId'+i).value == ''){
						alert('Please enter duration for procedure in row '+i);
						return false;
					 }
					}
					
					if(document.getElementById('procNoOfDays'+i)){
					if(document.getElementById('procNoOfDays'+i).value == ''){
						alert('Please enter no of days for procedure in row '+i);
						return false;
					 }
					}
					if(document.getElementById('procNoOfDays'+i).value!="")
					{
					if( isNaN(document.getElementById('procNoOfDays'+i).value))
			    	{
			        	alert("No. of Days should be number procedure in row "+i);
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

function removeRow(idName,obj, obj1)
{
  var tbl = document.getElementById(idName);
  var lastRow = parseInt(tbl.rows.length);  
  if(idName == "investigationGrid" && lastRow > 3)
	  {
	  if (lastRow > 2){
		    var i=obj1.parentNode.parentNode.rowIndex;
		    tbl.deleteRow(i);
		  }
	  }
  else if((idName == "nomenclatureGrid" || idName == "grid")&& lastRow > 2)
	  {
	   //var tbl = document.getElementById(idName);
	   var lastRow = tbl.rows.length;
		  if (lastRow > 2){
		    var i=obj1.parentNode.parentNode.rowIndex;
		    tbl.deleteRow(i);
		  }
	  }
  
  else if (idName != "investigationGrid" && lastRow > 2){
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

/* function populatePVMS(val,inc){
	

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
} */
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

function repeatTreatment(tCount, tRow)
{
	 var tbl = document.getElementById('grid');	 
	  var lastRow = tbl.rows.length;
	  lastRow = parseInt(lastRow)-1;
	  /* var iteration = lastRow; 
	  var row = tbl.insertRow(lastRow);*/
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value); 
	  var flag = true;
	  if(document.getElementById("repeat"+tCount+tRow).checked)
		  {
		 
			  
			
			  
			  for(var i=1; i<=iteration; i++)
			  {
				  
			   flag = true;
			   if(document.getElementById('nomenclature'+i) != null && document.getElementById('nomenclature'+i).value.trim()=="")
				   {
				  
				   fillRow(i, tCount, tRow);
				   if(!checkItem((iteration)))
					  {
						  document.getElementById("repeat"+tCount+tRow).checked = false; 
					  } 
				   flag=false;
				   fillValueFromFrequency(document.getElementById("frequency"+iteration).value, iteration);
				   fillValue(iteration);
				    break;
				   }
			  
			  }
			  
			  if(flag)
			  {
			  addRow();		  
			  fillRow((iteration+1), tCount, tRow);
			  /* alert(checkItem((iteration+1))); */
			   if(!checkItem((iteration+1)))
			  {
				  document.getElementById("repeat"+tCount+tRow).checked = false; 
			  } 
			   fillValueFromFrequency(document.getElementById("frequency"+(iteration+1)).value, (iteration+1));
			   fillValue(iteration+1);
			 
			  }
			  
		  
		  
		  
	
		  
		  }else
			  {
			  
			 
			  
				  for(var i=1; i<=iteration; i++)
				  {
				   if(document.getElementById('nomenclature'+i) != null && document.getElementById('prevnomenclature'+tCount+tRow).value.trim() == document.getElementById('nomenclature'+i).value.trim())
					   {
					  
					   /*  var j=document.getElementById('nomenclature'+i).parentNode.parentNode.rowIndex;
					    tbl.deleteRow(j); */
					    if(lastRow==1)
						  {
						   document.getElementById('nomenclature'+i).value  = "";
							document.getElementById('pvmsNo'+i).value  = "";
							document.getElementById('dosage'+i).value  = "";
							document.getElementById('frequency'+i).value  = "";
							document.getElementById('noOfDays'+i).value  = "";
							document.getElementById('route'+i).value  = "";
							document.getElementById('remarks'+i).value  = "";
						  }
					    else
					    	{
					    	removeRow('grid',document.getElementById('nomenclature'+i));
					    	}
					    
					   }
				  }
				  
				  
				  
			
			  }
		  
	 
	  
	
}

function fillRow(iteration,tCount,tRow)
{
	document.getElementById('nomenclature'+iteration).value  = document.getElementById('prevnomenclature'+tCount+tRow).value;
	document.getElementById('pvmsNo'+iteration).value  = document.getElementById('pvmsNo'+tCount+tRow).value;
	document.getElementById('dosage'+iteration).value  = document.getElementById('prevdosage'+tCount+tRow).value;
	document.getElementById('frequency'+iteration).value  = document.getElementById('prevfrequency'+tCount+tRow).value;
	document.getElementById('noOfDays'+iteration).value  = document.getElementById('prevnoOfDays'+tCount+tRow).value;
	document.getElementById('route'+iteration).value  = document.getElementById('prevroute'+tCount+tRow).value;
	document.getElementById('remarks'+iteration).value  = document.getElementById('prevtreatRemarks'+tCount+tRow).value;
}
	

	
function addRow(){
	   
	  var tbl = document.getElementById('grid');
	 
	  var lastRow = tbl.rows.length;
	
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 

	e0.name = 'nomenclature' + iteration;
	  e0.id = 'nomenclature' + iteration;
	  e0.onblur=function(){
	                     <%--   var val=e0.value
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
	   								disableOtherMedicine(this.value,iteration);
						     return;
						    }
						    else
	      						document.getElementById('pvmsNo'+iteration).value=pvmsNo
	      						checkItem(iteration);disableOtherMedicine(this.value,iteration);displayAu(this.value,iteration,'<%= hinId%>');checkForPurchase(this.value,iteration);
						   }
	                       else
							    {
							    		document.getElementById('nomenclature'+iteration).value="";
		   								document.getElementById('pvmsNo'+iteration).value="";
		   								document.getElementById('itemId'+iteration).value="";
		   								disableOtherMedicine(this.value,iteration);
							     return;
							    } --%>
							    if(populatePVMS(this.value,iteration))
							    	{
							    	checkItem(iteration);disableOtherMedicine(this.value,iteration);displayAu(this.value,iteration,'<%=hinId%>'); 
							    	checkForPurchase(this.value,iteration);
							    	}
							  
	                       
	  					  };
	  
	var newdiv = document.createElement('div');
  	    newdiv.id='ac2update'+iteration;
  	    newdiv.className='autocomplete';
    	newdiv.style.display = 'none';
       e0.size = '30';
	        e0.setAttribute('tabindex','1');

		var e01 = document.createElement('input');
	  e01.type = 'hidden';
	  e01.name = 'itemId' + iteration;
	  e01.id = 'itemId' + iteration;
	  e0.focus();
	  cellRight0.appendChild(e0);
	  cellRight0.appendChild(e01);
	  cellRight0.appendChild(newdiv);

	  
	  
	
	//  alert("3--3-"+iteration);
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});
	 
	
	 var cellRight1 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='otherMedicine'+iteration;
	  e11.id='otherMedicine'+iteration
	  e11.size='20';
	  e11.setAttribute('tabindex','1');
	  e11.onblur=function(){if(this.value!=''){checkDuplicateOtherMedicine(this.value,iteration);readOnlyNomenclature(this.value,iteration);showSimilarMedicineNames(this.value)}
	  else{readOnlyNomenclature(this.value,iteration);} };
	  cellRight1.appendChild(e11);

	   var cellRight2 = row.insertCell(2);
	  var e12 = document.createElement('Select');
	  e12.name='itemClass'+iteration;
	  e12.id='itemClass'+iteration;
	  /* e12.className='medium'; */
	  //e2.class = 'medium';
	  e12.setAttribute('tabindex','1');
	  e12.options[0] = new Option('Select', '0');
	   for(var i = 0;i<itemClassArray.length;i++ ){
	      e12.options[i+1] = new Option(itemClassArray[i][1],itemClassArray[i][0]);
	      }
	   
	   var e121 = document.createElement('input');
		  e121.type = 'hidden';
		  e121.name='itemClassCode'+iteration;
		  e121.id='itemClassCode'+iteration
		  
		  
		  cellRight2.appendChild(e121); 
		  
	  cellRight2.appendChild(e12); 

	  //itemClassArray
	  
	   var cellRight14 = row.insertCell(3);
	  var e12 = document.createElement('Select');
	  e12.name='itemConversionId'+iteration;
	  e12.id='itemConversionId'+iteration;
	  e12.className='medium';
	  //e2.class = 'medium';
	  e12.setAttribute('tabindex','1');
	  e12.options[0] = new Option('Select', '0');
	   for(var i = 0;i<unitArray.length;i++ ){
	      e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][0]);
	      }
	  cellRight14.appendChild(e12); 
	  
	   var cellRight15 = row.insertCell(4);
		  var e12 = document.createElement('Select');
		  e12.name='dispensingUnit'+iteration;
		  e12.id='dispensingUnit'+iteration;
		  e12.className='medium';
		  //e2.class = 'medium';
		  e12.setAttribute('tabindex','1');
		  e12.options[0] = new Option('Select', '0');
		   for(var i = 0;i<unitArray.length;i++ ){
		      e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][0]);
		      }
		  cellRight15.appendChild(e12); 
	  

	  
	 // var cellRight3 = row.insertCell(4);
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='actualDispensingQty'+iteration;
	  e1.id='actualDispensingQty'+iteration
	  e1.size='6';
	  e1.setAttribute('tabindex','1');
	 
	  
	  var e15 = document.createElement('input');
	  e15.type = 'hidden';
	  e15.name='highValueMedicine'+iteration;
	  e15.id='highValueMedicine'+iteration
	  e15.size='1';
	  e15.setAttribute('tabindex','1');
	  cellRight15.appendChild(e15);
	  //end
	  var e13 = document.createElement('input');
	  e13.type = 'hidden';
	  e13.name='au'+iteration;
	  e13.id='au'+iteration
	  e13.size='6';
	  e13.setAttribute('tabindex','1');
	  //e12.onblur=function(){displayAU(this.value,iteration)};
	  cellRight15.appendChild(e13);

	 
	  cellRight15.appendChild(e1);
	  
	  
	

	  var cellRight4 = row.insertCell(5);
	  var e14 = document.createElement('input');
	  e14.type = 'text';
	  e14.name='dosage'+iteration;
	  e14.id='dosage'+iteration
	  e14.size='5';
	  e14.setAttribute('maxlength', 5); 
	  e14.setAttribute('tabindex','1');
	  e14.onblur = function(){checkDosageValidation(this.value,iteration);fillValue(iteration)};
	  cellRight4.appendChild(e14);
	  
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight4.appendChild(sel);
	
	 
	
	 
	  var cellRight5 = row.insertCell(6);
	  var e2 = document.createElement('Select');
	  e2.name='frequency'+iteration;
	  e2.id='frequency'+iteration;
	  e2.className='medium';
	  //e2.class = 'medium';
	  e2.setAttribute('tabindex','1');
	  e2.options[0] = new Option('Select', '0');
	  e2.onblur=function(){getFrequencyValue(this.value,iteration);fillValueFromFrequency(this.value,iteration);displaySOSQty(this.value,iteration);fillValue(iteration)};
	   for(var i = 0;i<icdArray.length;i++ ){
	      e2.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	  cellRight5.appendChild(e2);
	  var e52 = document.createElement('input');
		e52.type = 'text';
		e52.name='sosQty'+iteration;
		e52.id='sosQty'+iteration;
		e52.tabIndex='1';
		e52.size='3';
		e52.style.display='none';
		e52.setAttribute('maxlength', 3); 
	    e52.onblur=function(){fillValue(iteration)};
		cellRight5.appendChild(e52);

	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='frequencyValue'+iteration;
	  e21.id='frequencyValue'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight5.appendChild(e21);
	  	  
	  var cellRight6 = row.insertCell(7);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='3';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','No. of Days,int,no');
	  e4.onblur=function(){fillValue(iteration)};
	  cellRight6.appendChild(e4);

	  
		var cellRight16 = row.insertCell(8);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	  cellRight16.appendChild(e5);

	 	

		var cellRight8 = row.insertCell(9);
		var e6 = document.createElement('input');
		e6.type = 'text';
		e6.name='route'+iteration;
		e6.id='route'+iteration
		e6.size='5';
		e6.value=''
		e6.setAttribute('maxlength', 20); 
		e6.setAttribute('tabindex','1');
		cellRight8.appendChild(e6); 

	  var cellRight9 = row.insertCell(10);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='remarks'+iteration;
	  e7.id='remarks'+iteration
	  e7.size='10';
	  e7.setAttribute('maxlength', 40); 
	  e7.setAttribute('tabindex','1');
	  cellRight9.appendChild(e7);



	  /* var cellRight11 = row.insertCell(11);
	  var e72 = document.createElement('input');
	  e72.type = 'text';
	  e72.name='closingStock'+iteration;
	  e72.id='closingStock'+iteration
	  e72.size='3';
	  e72.setAttribute('tabindex','1');
	  cellRight11.appendChild(e72); */

	  var cellRight12 = row.insertCell(11);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'button';
	  e8.value = "Add";
	  e8.name='remarks'+iteration;
	 // e8.setAttribute('onClick', 'addRow();'); 
	  e8.onclick = function(){addRow();}; 
	  e8.setAttribute('tabindex','1');
	  cellRight12.appendChild(e8);

	  var cellRight13 = row.insertCell(12);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'button';
	  e9.value = "Delete";
	  e9.name='remarks'+iteration;
	  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
	  e9.onclick = function(){removeRow("grid","hdb",this);};  
	  e9.setAttribute('tabindex','1');
	  cellRight13.appendChild(e9);

	 
	  

	}



/*function addRowForInvestigation(){
    
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
	  newdiv1.id='ac2update2'+iteration;
	  newdiv1.className = 'autocomplete';
	  newdiv1.style.display = 'none';
	  					
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.setAttribute('tabindex','1');
	  e0.size = '40'
	  
	  cellRight0.appendChild(e0);
	  cellRight0.appendChild(newdiv1);
	
	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update2'+iteration,'opd?method=getInvestigationListForAutoComplete',{minChars:1,
		  callback: function(element, entry) {
	            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
	        },parameters:'requiredField=chargeCodeName'+iteration});	 

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
	  
	 //  var cellRight1 = row.insertCell(1);  // by atul for removing refer to mh 
	  var e3 = document.createElement('input');
	  e3.type = 'checkbox';
	  e3.name='referToMh'+iteration;
	  e3.id='referToMhId'+iteration
	//  e3.size='10';
	  e3.className='radio';
	  e3.value='y';
	  e3.setAttribute('tabindex','1');
	  // cellRight1.appendChild(e3);  // by atul for removing refer to mh 

	 var cellRight2 = row.insertCell(1);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonAdd';
	  e4.name='Button';
	  e4.setAttribute('onClick','addRowForInvestigation();');
	  cellRight2.appendChild(e4);

	  var cellRight3 = row.insertCell(2);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.name='delete';
	  e5.onclick = function(){removeRow('investigationGrid',this);};
	  cellRight3.appendChild(e5);
	
	}*/


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
		  e1.size = '30';
		  e1.tabindex='1';
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

		  var cell2 = row.insertCell(1);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name='procDuration'+iteration;
		  e2.id='procDurationId'+iteration
		  e2.size = '2'
		  e2.tabindex='1';
		  e2.maxlength='3';
		  cell2.appendChild(e2);

		  var cell3 = row.insertCell(2);
		  cell3.innerHTML='min'
			  
		  var cell4 = row.insertCell(3);
	 	  var e3 = document.createElement('select');
		  
		  e3.name='frequency'+iteration;
		  e3.id='frequency'+iteration
		  e3.tabindex='1';
		  e3.options[0] = new Option('Select','0');
		  for(var i = 0;i<frequencyArray.length;i++ ){
		      e3.options[i+1] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
		   }
		  e3.tabindex='1';
		  cell4.appendChild(e3);

		  var cell5 = row.insertCell(4);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name='procNoOfDays'+iteration;
		  e4.id='procNoOfDays'+iteration;
		  e4.size='3';
		  e4.maxlength='3'; 
		  e4.tabindex='1';
		  e4.setAttribute('validate','No. of days,int,no');
		  cell5.appendChild(e4);
		  
		  var cell6 = row.insertCell(5);
		  var e21 = document.createElement('input');
		  e21.type = 'text';
		  e21.name='procRemarks'+iteration;
		  e21.id='procRemarks'+iteration
		  e21.maxlegth="50"
		  e21.size = '30';
		  e21.setAttribute('tabindex','1');
		  cell6.appendChild(e21);
		  
		  var cell7 = row.insertCell(6);
		  var e31 = document.createElement('input');
		  e31.type = 'button';
		  e31.className = 'buttonAdd';
		  e31.name='Button'+iteration;
		  e31.setAttribute('onClick', 'addProcedureRow();'); 
		  e31.setAttribute('tabindex','1');
		  cell7.appendChild(e31);

		  var cell8 = row.insertCell(7);
		  var e41 = document.createElement('input');
		  e41.type = 'button';
		  e41.className = 'buttonDel';
		  e41.name='delete'+iteration;
		  e41.onclick = function(){removeRow('proceduregrid',this);};
		  e41.setAttribute('tabindex','1');
		  cell8.appendChild(e41);
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
		  e1.size = '30';
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
		  e2.size = '2'
		  cell2.appendChild(e2);

		  var cell3 = row.insertCell(2);
		  cell3.innerHTML='min'
			  
		  var cell14 = row.insertCell(3);
		  var e3 = document.createElement('Select');

		  e3.name='frequencyId'+iteration;
		  e3.id='frequencyId'+iteration;
		  e3.classname='smalllabel';
		  e3.setAttribute('tabindex','1');
		  e3.options[0] = new Option('Select', '0');
		   for(var i = 0;i<frequencyArray.length;i++ ){
		      e3.options[i+1] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
		      }
		   cell14.appendChild(e3);

		  var cell15 = row.insertCell(4);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name='phyNoOfDays'+iteration;
		  e4.id='phyNoOfDays'+iteration;
		  e4.size='3';
		  e4.setAttribute('maxlength', 3); 
		  e4.setAttribute('tabindex','1');
		  e4.setAttribute('validate','No. of days,int,no');
		  cell15.appendChild(e4);
		  
		  var cell6 = row.insertCell(5);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.name='remarks'+iteration;
		  e5.id='remarks'+iteration
		  e5.size = '30';
		  e5.setAttribute('tabindex','1');
		  cell6.appendChild(e5);
		  
		  var cell7 = row.insertCell(6);
		  var e6 = document.createElement('input');
		  e6.type = 'button';
		  e6.className = 'buttonAdd';
		  e6.name='Button'+iteration;
		  e6.setAttribute('onClick', 'addPhysiotherapyRow();'); 
		  e6.setAttribute('tabindex','1');
		  cell7.appendChild(e6);

		  var cell8 = row.insertCell(7);
		  var e7 = document.createElement('input');
		  e7.type = 'button';
		  e7.className = 'buttonDel';
		  e7.name='delete'+iteration;
		  e7.onclick = function(){removeRow('therapygrid',this);};
		  e7.setAttribute('tabindex','1');
		  cell8.appendChild(e7);
}

/* function removeRow(idName,countId,obj)
{
	
  alert("hiy");
  var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
  }
} */


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
/* function  fillValue(value,inc){

	  var freq=document.getElementById('frequency'+inc).value;
	  var dosage=document.getElementById('dosage'+inc).value;
	  document.getElementById('total'+inc).value=freq*value*dosage;
	 } */
/* function fillValue(inc){
	  
	  
    var noOfDays = document.getElementById('noOfDays'+inc).value 
	  var dosage = document.getElementById('dosage'+inc).value
	  var freq=document.getElementById('frequencyValue'+inc).value
	  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
	  var sosQty = document.getElementById('sosQty'+inc).value;
	  var total = freq*noOfDays*dosage;
	  
	  var finalQty;
	  
	  if(document.getElementById('frequency'+inc).value != 13 ){
	  if(document.getElementById('actualDispensingQty'+inc).value != 0){
		  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
		//  alert(totalQty);
		  if(totalQty != '0.00'){
			  finalQty = Math.ceil(totalQty);
		  }
		  else
			  {
			 	 finalQty = 1;
			  }
		  
		  document.getElementById('total'+inc).value=finalQty;
		 }else{
			  document.getElementById('total'+inc).value=freq*noOfDays*dosage
		  }
	 //	document.getElementById('noOfDays'+inc).disabled = false;
	// 	document.getElementById('sosQty'+inc).disabled = true;
	  }else{
		  if(document.getElementById('actualDispensingQty'+inc).value != 0){
			  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
			  if(totalQty != '0.00'){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('total'+inc).value=finalQty;
			 }else{
				  document.getElementById('total'+inc).value=freq*sosQty*dosage
			  }
	//	   document.getElementById('noOfDays'+inc).disabled = true;
	//	   document.getElementById('sosQty'+inc).disabled = false;

	  }
	  if(document.getElementById('otherMedicine'+inc).value=="")
		  {
		  document.getElementById('nomenclature'+inc).onblur();
		  }
	  
	  
	 } */
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
		
			submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/opd?method=showGridForInvestigationIPD','gridview');
			
			}

}
function showHideDrugTemplateCombo(valueOfTemplate){
	if(checkTemplateId(valueOfTemplate)){
	  	/* document.getElementById("copyPrevPrescriptionTemplateDiv").style.display='none'; */

		submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/opd?method=showGridInMainJspForIPD','testDiv');
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

function showCreatePrescriptionTempate(){
    
		document.getElementById('prescriptionImportButton').style.display = 'inline';
   	var url="/hms/hms/opd?method=showCreatePrescriptionTempate";
    newwindow=window.open(url,'presciption',"height=500,width=1010,status=1,top=0,left=2");
   
     }

function showCreateInvestigationTemplate(){
    
    document.getElementById("investigationImportButton1").style.display='inline'
  	var url="/hms/hms/opd?method=showCreateInvestigationTemplate";
   newwindow=window.open(url,'investigation',"height=500,width=1010,status=1,top=0,left=2");
  

}



var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()


function showDiagnosis()
    {
    		   	var url="/hms/hms/opd?method=showDiagnosisPopUp";
    		   newwindow=window.open(url,'Diagnosis',"left=0,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=1");
    		  
    }
function showTreatment()
{
	
		   	var url="/hms/hms/opd?method=showTreatmentPopUp&flag=opd";
		    newwindow=window.open(url,'treatment',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
		  
}
function openPopupPrescriptions(visitId,visitNo,deptId,hinId)
{
 var url="/hms/hms/opd?method=showPatientPreviousVisitForPrescriptionReport&visitId="+visitId+"&visitNo="+visitNo+"&deptId="+deptId+"&hinId="+hinId;
 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
	 //alert("Detention Advice ....");
}

<%-- function openPopupInvestigation(visitId,visitNo,deptId,hinId)
{
 var url="/hms/hms/opd?method=showPatientPreviousVisitForInvestigationReport&visitId="+visitId+"&visitNo="+visitNo+"&deptId="+deptId+"&hinId="+hinId;
opd?method=showPatientPreviousVisitForInvestigationReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>"
 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
	 //alert("Detention Advice ....");
}
 --%>

/* function checkForPurchase(val,a,inc)
{
		    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    console.log(pvms);
	  
	  if(pvms !="")
	  {
		
		  ajaxFunctionForAutoCompleteInLPOGeneral('ipdCaseSheet','opd?method=fillItemsInGrid&pvmsNo=' +  pvms , inc);
				//ajaxFunctionForAutoCompleteForPurchase('purchaseGrid','stores?method=fillItemsCommon&pvmsNo=' +  pvms , inc);
			   	
			}
	  else{
			    return false;
			}
	 
			  	  
	    
} */

function ajaxFunctionForAutoCompleteInLPOGeneral(formName,action,rowVal) {
	
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
    var url=action
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
    	  

  	     var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	 
		
		
      	for (loop = 0; loop < items.childNodes.length; loop++) 
      	{
      
	   	    var item = items.childNodes[loop];
	   	    
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        
        	/* document.getElementById('itemCode'+rowVal).value = pvms.childNodes[0].nodeValue */
        	
        	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue
        	/* document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue	 */		
        	
      }
    }
  }
}



<%--
function displayAu(val,inc){
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
                               
                           var au  = item.getElementsByTagName("au")[0];
                           var actualDispensingQty = item.getElementsByTagName("actualDispensingQty")[0];
                           var stock = item.getElementsByTagName("stock")[0];
                           
                           if(document.getElementById('au'+inc) && au.childNodes[0] != undefined ){
                                   document.getElementById('au'+inc).value = au.childNodes[0].nodeValue;
                           }
                        /*    if(document.getElementById('closingStock'+inc) && stock.childNodes[0] != undefined){
                                   document.getElementById('closingStock'+inc).value = stock.childNodes[0].nodeValue;
                                   if(stock.childNodes[0].nodeValue == 0){
                                      alert("Stock is not available...");
                                   }
                           }else{
                           } */
                           if(document.getElementById('actualDispensingQty'+inc)){
                           if(actualDispensingQty.childNodes[0]!=undefined){
                                   document.getElementById('actualDispensingQty'+inc).value = actualDispensingQty.childNodes[0].nodeValue;
                           }else{
                                   document.getElementById('actualDispensingQty'+inc).value = 0;

                           }
                           }
                           var dangerousDrug = item.getElementsByTagName("dangerousDrug")[0];
                           if(dangerousDrug.childNodes[0]!=undefined && dangerousDrug.childNodes[0].nodeValue == 'y'){
                                   alert("This drug is dangerous.");
                           }
                         }
                 }
                }
               var url="/hms/hms/opd?method=displayAU&pvmsNo="+pvmsNo;
               xmlHttp.open("GET",url,true);
               xmlHttp.setRequestHeader("Content-Type", "text/xml");
               xmlHttp.send(null);
           }
   else
	   {
	   document.getElementById('itemId'+inc).value = "";
	   }
} --%>

<%-- function displayAu(val, inc, hinId) {
	
	if (val != "") {
		
		var index1 = val.lastIndexOf("[");
		var indexForBrandName = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var pvmsNo = val.substring(index1, index2);
		var indexForBrandName = indexForBrandName--;
		var brandName = val.substring(0, indexForBrandName);
		if (pvmsNo == "") {
			
		
			document.getElementById('nomenclature' + inc).value = "";
			document.getElementById('pvmsNo' + inc).value = "";
			return;
		} else
			var xmlHttp;
		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				alert(e)
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("Your browser does not support AJAX!");
					return false;
				}
			}
		}

		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
				for (loop = 0; loop < items.childNodes.length; loop++) {
					var item = items.childNodes[loop];

					var au = item.getElementsByTagName("au")[0];
					var actualDispensingQty = item
							.getElementsByTagName("actualDispensingQty")[0];
					var stock = item.getElementsByTagName("stock")[0];
					var itemClassCode = item.getElementsByTagName("itemClassCode")[0];

					if (document.getElementById('dispensingUnit' + inc)
							&& au.childNodes[0] != undefined) {
						document.getElementById('dispensingUnit' + inc).value = au.childNodes[0].nodeValue;
					}
					
					if (document.getElementById('itemClassCode' + inc)
							&& au.childNodes[0] != undefined) {
						document.getElementById('itemClassCode' + inc).value = itemClassCode.childNodes[0].nodeValue;
					}
					if (document.getElementById('closingStock' + inc)
							&& stock.childNodes[0] != undefined) {
						document.getElementById('closingStock' + inc).value = stock.childNodes[0].nodeValue;
						if (stock.childNodes[0].nodeValue == 0) {
							alert("Stock is not available...");
						}
					} else {
					}
					if (document.getElementById('actualDispensingQty' + inc)) {
						if (actualDispensingQty.childNodes[0] != undefined) {
							document
									.getElementById('actualDispensingQty' + inc).value = actualDispensingQty.childNodes[0].nodeValue;
						} else {
							document
									.getElementById('actualDispensingQty' + inc).value = 0;

						}
					}
					
					   var dispQty = item.getElementsByTagName("dispQty")[0];
                       if(dispQty.childNodes[0]!=undefined && dispQty.childNodes[0].nodeValue == 'true'){
                               alert("No configuration of dispensary quantity for this medicine" +inc);
                    		   document.getElementById('nomenclature'+inc).value="";
                    		   document.getElementById('itemId'+inc).value="";
    						   if(document.getElementById('closingStock'+inc))
                    		   document.getElementById('closingStock'+inc).value="";
    						   document.getElementById('pvmsNo' + inc).value = "";
                       }
					
					var dangerousDrug = item
							.getElementsByTagName("dangerousDrug")[0];
					if (dangerousDrug.childNodes[0] != undefined
							&& dangerousDrug.childNodes[0].nodeValue == 'y') {
						alert("This drug is dangerous.");
					}

					var highValueMedicine = item
							.getElementsByTagName("highValueMedicine")[0];
					if (highValueMedicine.childNodes[0] != undefined
							&& highValueMedicine.childNodes[0].nodeValue == 'y') {
						document.getElementById('highValueMedicine' + inc).value = 'y';
						checkHighValueMedicine(pvmsNo, inc, hinId);
					} else {
						document.getElementById('highValueMedicine' + inc).value = 'n';
					}

				}
			}
		}
		var url = "/hms/hms/opd?method=displayAU&pvmsNo=" + pvmsNo;
		 var url="/hms/hms/opd?method=displayAU&pvmsNo="+pvmsNo+"&"+&hinId=<%=visit.getHin().getId()%>";
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
	else
		{
		document.getElementById('itemId' + inc).value = '';
		}
} --%>

function getFrequencyValue(feqValue,inc){
	var feqQty;
<%
if(frequencyList.size()>0){	
	for(MasFrequency masFrequency1 :frequencyList){
%>
 if(feqValue == '<%=masFrequency1.getId()%>'){
	 feqQty = '<%=masFrequency1.getFeq()%>'
	
  }

<%}
}%>
 document.getElementById('frequencyValue'+inc).value = feqQty;
}

/* function displaySOSQty(val,inc){
	
	if(val == '13'){
		document.getElementById('sosQty'+inc).style.display = 'block';
		document.getElementById('noOfDays'+inc).disabled = true;
	 }else{
	
	 document.getElementById('sosQty'+inc).style.display  = 'none';
	  document.getElementById('noOfDays'+inc).disabled = false;
	 }
	} */
	

 function fnGetDoctorDepartment(departmentId){
	// new Ajax.Request('opd?method=getDoctorDepartment&departmentId='+departmentId+'&'+csrfTokenName+'='+csrfTokenValue, {
	 new Ajax.Request('opd?method=getDoctorDetailsIPD&departmentId='+departmentId,{
    	  onSuccess: function(response) {
    	      if(response.responseText.trim()!='')
    	    	  {
    	    	  document.getElementById('refereddoctor').innerHTML=response.responseText.trim();
    	    	  }
    	  }
    	});
}
  
</script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript">

var $j = jQuery.noConflict();
</script>

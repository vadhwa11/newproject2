
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showPatientList.jsp  
 * Purpose of the JSP -  This is Show Patient List.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.15
--%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
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
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/tabcontentIn.js" type="text/javascript"></script>

<%@page import="jkt.hms.masters.business.DgOrderhd"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>


<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
 <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> 
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> -->
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
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
	List<PatientPrescriptionHeader> ipdPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
	List<PatientInvestigationHeader> ipdInvestigationList = new ArrayList<PatientInvestigationHeader>();
	List<DischargeIcdCode> ipIcdList = new ArrayList<DischargeIcdCode>();
//	List<ProcedureHeader> ipdProcedureList = new ArrayList<ProcedureHeader>();
//	List<PhysioRequisitionHeader> ipdPhysiotherapyList = new ArrayList<PhysioRequisitionHeader>();
	List<OpdPatientHistory> ipdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
	List<IpdPatientDiet> ipdPatientDietList= new ArrayList<IpdPatientDiet>();

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
	
	
	int opdSurgeryId =0;
	
	if(map.get("opdSurgeryId") != null)
	{
		opdSurgeryId=(Integer)map.get("opdSurgeryId");
	}
	
	OpdPatientHistory opdPatientHistory = null;
	if(ipdHistoryDetailsListForFollowUp.size()>0){
		opdPatientHistory = ipdHistoryDetailsListForFollowUp.get(0);
	}
	Visit visit =null;
	Patient patient = null;
	Inpatient inpatient =null;
	String patientName ="";
	String consultantName = "";
	String currentAge = "";
	String admDate="";
	
	if(map.get("patient") != null)
	{
		patient=(Patient)map.get("patient");
	}
	
	if(inpatientList.size() >0){
		patient = inpatientList.get(0).getHin();
		inpatient = inpatientList.get(0);
		patientName=patient.getPFirstName()+" "+(patient.getPMiddleName() != null?patient.getPMiddleName():"")+" "+(patient.getPLastName() != null?patient.getPLastName():"");
		admDate = HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission());
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
	
	Calendar now = Calendar.getInstance();
 	Calendar cal = Calendar.getInstance();
 	System.out.println("ff"+inpatient);
 	if(inpatient!=null && inpatient.getDateOfAddmission()!=null)
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
	
	if(inpatient!=null)
	{
	Date d1= inpatient.getDateOfAddmission();
	Date d2= new Date();
	long t1 = d1.getTime();
	long  t2 = d2.getTime();
	long day = 1000 * 60 * 60 * 24; // milliseconds in a day
	long totalOfDays =  (t2 - t1) / day;
	}
%>

<div class="clear"></div>
<input name="hinId" type="hidden"	value="<%=patient.getId()%>" />
<input name="inpatientId" type="hidden"	value="<%=inpatient!=null?inpatient.getId():"0"%>" />
<input name="adNo" type="hidden"	value="<%=inpatient!=null?inpatient.getAdNo():"0"%>" />
<input name="hinNo" type="hidden"	value="<%=patient.getHinNo()%>" />
<input name="serviceNo" type="hidden"	value="<%=patient!=null?patient.getServiceNo():"" %>" />
<%
String serviceNo = patient!=null?patient.getServiceNo():"";
System.out.println(patient.getId());
int hinId= patient.getId();
%>

<div class="opdArea">
<div class="clear"></div>
       <ul id="countrytabs" class="shadetabs">
           <li onclick="submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ot?method=getPrevCaseNoteDiagnosis&parent=<%=inpatient!=null?inpatient.getId():"0"%>&hinId=<%=patient.getId() %>','prevDiagCaseNoteDiv');"><a href="#" rel="country1" >Case Notes/Diagnosis</a></li>
           <li onclick="submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ot?method=getPrevTreatmentDetails&parent=<%=inpatient!=null?inpatient.getId():"0"%>&hinId=<%=patient.getId()%>&opdSurgeryId=<%=opdSurgeryId%>','prevTreatmentDiv');"><a href="#" rel="country2" >Treatments</a></li>
           <li onclick="submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ot?method=getPrevInvestigationDetails&parent=<%=inpatient!=null?inpatient.getId():"0" %>&hinId=<%=patient.getId() %>&opdSurgeryId=<%=opdSurgeryId%>','prevInvestigationDiv');"><a href="#" rel="country3">Investigations</a></li>
           <li onclick="submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ot?method=getPrevProcedureDetails&parent=<%=inpatient!=null?inpatient.getId():"0" %>&hinId=<%=patient.getId() %>','prevProcedureDiv');"><a href="#" rel="country4">Procedures</a></li>
           <%-- <li onclick="submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ipd?method=getPrevPhysiotherapyDetails&parent=<%=inpatient.getId() %>&hinId=<%=inpatient.getHin().getId() %>','prevTherapyDiv');"><a href="#" rel="country5">Physiotherapy</a></li> --%>
           <%-- <li onclick="submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ipd?method=getPrevDietDetails&parent=<%=inpatient.getId() %>&hinId=<%=inpatient.getHin().getId() %>','prevDietDiv');"><a href="#" rel="country6">Diet Details</a></li> --%>
	</ul>
<!-- First Tab End -->
<div id="country1" class="tabcontentIn">
<%
OpdPatientDetails prevPatientDetails =new OpdPatientDetails();
if(caseSheetList.size() > 0){
	prevPatientDetails = caseSheetList.get(0); // For getting latest case notes
}
%>
<div class="clear"></div>
<%-- <div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid1">
	<tr>
		<th scope="col">Today's Case Notes</th>

	</tr>
	<tr>
	<td><input type="text" id="caseNotes" name="clinicalNotes" tabindex="1" value="<%=(prevPatientDetails!=null && prevPatientDetails.getCaseNotes()!=null)?prevPatientDetails.getCaseNotes():"" %>" size="147" maxlength="200" validate="Today's Case Notes,string,no"/></td>
	</tr>
</table>
</div> --%>
<div class="clear"></div>
<%--<h4>Diagnosis</h4>
 <div class="Block">
<input	type="hidden" id="systamicExam" class="large" name="systamicExam"	maxlength="200" />
<label>Working Diagnosis</label>
<input type="text" class="large"  size="119" id="initialDiagnosis" tabindex="1" value="<%=prevPatientDetails.getInitialDiagnosis()!=null?prevPatientDetails.getInitialDiagnosis():"" %>"	name="initialDiagnosis" maxlength="100" />

<div class="clear"></div>

<label>System Diagnosis</label>

<input 	name="systemDiagnosis" value="<%=prevPatientDetails.getSystemDiagnosis()!=null?prevPatientDetails.getSystemDiagnosis().getSystemDiagnosisName()+"["+prevPatientDetails.getSystemDiagnosis().getId()+"]":"" %>"	id="systemDiagnosis" tabindex="1" class="large"  size="119" />
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
		if(ipIcdList.size()>0){
			for(DischargeIcdCode icdCode : ipIcdList){
	%>
	<option value="<%=icdCode.getIcd().getIcdCode() %>" selected="selected"><%=icdCode.getIcd().getIcdName()+"["+icdCode.getIcd().getIcdCode()+"]" %></option>
	<%}
			}%>
</select>

<input type="button" class="buttonDel" value="" 	onclick="deleteDgItems(this,'diagnosisId');" align="right" />
<div class="clear"></div>
</div> --%>

<div class="Clear paddingTop15" ></div>
<div id="prevDiagCaseNoteDiv">
<%
int m = 1;	

if(caseSheetList.size() > 0){
		for(OpdPatientDetails patientDetails : caseSheetList){
			if(patientDetails.getVisit()!=null){
				visit = patientDetails.getVisit();
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
	<td ><input type="text" class="large"  size="147" tabindex="1" value='<%=patientDetails.getCaseNotes()!=null?patientDetails.getCaseNotes():"" %>' maxlength="100" readOnly="true"/></td>
	</tr>
</table>
</div>
<div class="clear"></div>
<h4>Diagnosis</h4>
<div class="clear"></div>

<div class="Block">
<label>Working Diagnosis</label>
<label class="value"><%=patientDetails.getInitialDiagnosis()!=null?patientDetails.getInitialDiagnosis():""%></label>

<label>System Diagnosis</label>
<label class="value"><%=patientDetails.getSystemDiagnosis()!=null?patientDetails.getSystemDiagnosis().getSystemDiagnosisName():"" %></label>

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
	System.out.println("ipIcdList"+ipIcdList.size());
	for(DischargeIcdCode dischargeIcdCode : ipIcdList){
		System.out.println("ipIcdList1"+ipIcdList.size());
		if(patientDetails.getId() == dischargeIcdCode.getOpdPatientDetails().getId())
		{
			System.out.println("ipIcdList2"+ipIcdList.size());
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
<%}else if(patientDetails.getInpatient()!=null){ %>
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
	<td ><input type="text" class="large"  size="147" tabindex="1" value='<%=patientDetails.getCaseNotes()!=null?patientDetails.getCaseNotes():"" %>' maxlength="100" readOnly="true" /></td>

	</tr>
</table>
</div>
<div class="clear"></div>
<h4>Diagnosis</h4>
<div class="clear"></div>
<div class="Block">

<label>Working Diagnosis</label>
<label class="value"><%=patientDetails.getInitialDiagnosis()!=null?patientDetails.getInitialDiagnosis():"" %></label>

<label>System Diagnosis</label>
<label class="value"><%=patientDetails.getSystemDiagnosis()!=null?patientDetails.getSystemDiagnosis().getSystemDiagnosisName():"" %></label>

<label>ICD Diagnosis</label>
<%String diagnosis = "";
System.out.println("ipIcdList.size()"+ipIcdList.size());
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

<div id="templateDivToShowHide" class="floatLeft">

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
	<!-- 	<th>Add</th>
		<th>Delete</th> -->
		
	</tr>
	<%
	int l =0;
		if(ipdPrescriptionList.size() > 0){
			PatientPrescriptionHeader prescriptionHeader = ipdPrescriptionList.get(0);
			for(PatientPrescriptionDetails prescriptionDetails : prescriptionHeader.getPatientPrescriptionDetails()){
				l++;
	%>
	<tr>
		<td>
	    <%=prescriptionDetails.getItem().getNomenclature()%>
	    </td>
		<td>
		<%=prescriptionDetails.getDosage()!=null?prescriptionDetails.getDosage():"" %></td>
		
		<td><%=prescriptionDetails.getFrequency()!=null?prescriptionDetails.getFrequency().getFrequencyName():""%>
		</td>

	<td><%=prescriptionDetails.getNoOfDays()!=null?prescriptionDetails.getNoOfDays():"" %>
		</td>
		<td><%=prescriptionDetails.getRoute()!=null?prescriptionDetails.getRoute():"" %></td>
		<td><%=prescriptionDetails.getRemarks()!=null?prescriptionDetails.getRemarks():"" %></td>
			<!-- <td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid',this);" tabindex="1" />
			</td> -->
		
	</tr>
	
	<%
			}}else{ l++;%>
	<tr>
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature<%=l %>" size="40"  name="nomenclature<%=l %>" onblur="populatePVMS(this.value,'<%=l %>'),checkItem('<%=l %>');displayAu(this.value,'<%=l %>')"  />
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
		<td><input type="text" name="route<%=l %>" tabindex="1" id="route<%=l %>"  size="5" maxlength="20"	value="PO" validate="Route,string,no" />
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
</div>
<div id="prevTreatmentDiv"></div>
</div>

<div id="country3" class="tabcontentIn">


<%
int inc = 0;
%>
<div class="clear"></div>
<%-- <div id="gridview">
<h6>Today's</h6>
<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Investigations </th>
		<!-- <th scope="col">Refer to MH</th> -->
	<!-- 	<th scope="col">Add</th>
		<th scope="col">Delete</th> -->
	</tr>
<%inc++; %>
<tr>
		<td>
		<input type="text" value="" tabindex="1" 
			id="chargeCodeName<%=inc %>" size="40" name="chargeCodeName<%=inc %>"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2<%=inc %>" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName<%=inc %>','ac2update2<%=inc%>','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>'});
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

</table>
</div>
	<input type="hidden" value="<%=inc %>" name="hiddenValue" id="hiddenValue" />
	</div> --%>
	
	<div class="Clear"></div>
	<div id="prevInvestigationDiv"></div>
</div>

<div id="country4" class="tabcontentIn">
<div class="Clear"></div>
<%-- <div class="small">
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
	
<select name="<%=FREQUENCY%><%=i %>" id="procfrequency<%=i %>"	tabindex="1"	validate="Frequency,string,no">
			<option value="0">Select</option>
			<%
			 			for(MasFrequency masFrequency : frequencyList){
			 				
			 		%>
			<option value="<%=masFrequency.getId() %>"><%=masFrequency.getFrequencyName() %></option>
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
	</div> --%>
		<%-- <input type="hidden" value="<%=i %>" name="procCount" id="procCount" /> --%>
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
<div class="Clear paddingTop10"></div>
</div>

<div class="Clear"></div>
<input type="hidden" name="ageName" value="<%=patient.getAge() %>" id="ageId" /> 
<input type="hidden" name="genderId" id="genderId" value="<%=patient.getSex().getId() %>">
<div class="Clear"></div>	
<input type="button" name="close" value="Close" onclick="window.close();" style="float:right;"/>	
<div class="Clear"></div>

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
	      						checkItem(iteration);displayAu(this.value,iteration)
						   }
	  					  };
	  
	    var newdiv = document.createElement('div');
      	newdiv.setAttribute('id', 'ac2update1'+iteration);
      	newdiv.setAttribute('class', 'autocomplete');
       	newdiv.style.display = 'none';
        e0.size = '40';
 
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);
	  cellRight0.appendChild(newdiv);
	
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update1'+iteration,'opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});
	  var cellRight1 = row.insertCell(1);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='dosage'+iteration;
	  e3.id='dosage'+iteration
	  e3.size='2';
	  e3.setAttribute('maxlength', 5); 
	  e3.setAttribute('tabindex','1');
	  cellRight1.appendChild(e3);

	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('Select');

	  e2.name='treatmentFrequency'+iteration;
	  e2.id='frequency'+iteration;
	  e2.className="small";
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
	  e4.size='2';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','No. of days,int,no');

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
		e6.size='5';
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
	  newdiv1.id='ac2update2'+iteration;
	  newdiv1.className = 'autocomplete';
	  newdiv1.style.display = 'none';
	  					
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.setAttribute('tabindex','1');
	  e0.size = '40'
	  
	  cellRight0.appendChild(e0);
	  cellRight0.appendChild(newdiv1);
	
	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update2'+iteration,'opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});	 

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
	//  e3.size='10';
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
var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()


function showDiagnosis()
    {
    		   	var url="/hms/hms/opd?method=showDiagnosisPopUp";
    		   newwindow=window.open(url,'Diagnosis',"left=0,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=1");
    		  
    }
  
  
function popwindowresult(url)
	    {
	    		   	
	    		   newwindow=window.open(url,'Diagnosis',"left=0,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=1");
	    		  
	    }
</script>
	
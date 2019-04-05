<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name: dischargeDetailsInput.jsp 
	 * Tables Used: discharge_items, discharge_items_category, discharge_summary 
	 * Entry Screen to feed Discharge Summary Details
	 * @author  Create Date: 11.02.2008    Name: Othivadivel K R   
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 * @see DischargeController.java, DischargeHandlerService.java, DischargeHandlerServiceImpl.java, 
	 *      DischargeDataService.java, DischargeDataServiceImpl.java, dischargeFieldDisplay.jsp
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>

<%@page import="jkt.hms.masters.business.AllergyDetail"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasImpanneledHospital"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>

<%@page import="jkt.hms.masters.business.MasDisposedTo"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.MasDischargeStatus"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>

<%
    String externalReferralType ="";
    externalReferralType = HMSUtil.getProperties("adt.properties", "externalReferralType");
	Map map = new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List inPatientDetailList = new ArrayList();
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	/*List<PatientPrescriptionHeader> ipdPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
	List<PatientInvestigationHeader> ipdInvestigationList = new ArrayList<PatientInvestigationHeader>();*/
	List<PatientPrescriptionDetails> ipdPrescriptionList = new ArrayList<PatientPrescriptionDetails>();
	List<PatientInvestigationDetails> ipdInvestigationList = new ArrayList<PatientInvestigationDetails>();
	
	List<DischargeIcdCode> ipIcdList = new ArrayList<DischargeIcdCode>();
	List<ProcedureDetails> ipdProcedureList = new ArrayList<ProcedureDetails>();
	List<MasDisposedTo> disposedToList = new ArrayList<MasDisposedTo>();
	
	String currentDate = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int inpatientId = 0;
	String admissionNumber = "";
	String patientName = "";
	String serviceno = "";
	String rank = "";
	String unit = "";
	String doa = "";
	String dod = "";
	String relation = "";
	String age = "";
	String sex = "";
	int departmentId =0;
	int hinId = 0;
	Inpatient inpatient = null;
	Patient patient = null;
	MasRank masRank = null;
	MasRelation masRelation = null;
	String category_name = "";
	String servicetype = "";
	String hinNo ="";
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	currentDate = (String) utilMap.get("currentDate");
	time = (String) utilMap.get("currentTime");
	
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
		
	List<MasImpanneledHospital> masImpanneledHospitalList = new ArrayList<MasImpanneledHospital>();
  	if(map.get("masImpanneledHospitalList") != null)
	{
  		masImpanneledHospitalList=(List<MasImpanneledHospital>)map.get("masImpanneledHospitalList");
	}
  	
	if (map.get("inPatientDetailList") != null){
	inPatientDetailList = (List) map.get("inPatientDetailList");
	
	}
	if (map.get("ipdInvestigationList") != null){
		ipdInvestigationList = (List) map.get("ipdInvestigationList");
		
	}
	if (map.get("ipdPrescriptionList") != null){
		ipdPrescriptionList = (List) map.get("ipdPrescriptionList");
		
	}
	if (map.get("ipIcdList") != null){
		ipIcdList = (List) map.get("ipIcdList");
		
	}
	if (map.get("ipdProcedureList") != null){
		ipdProcedureList = (List) map.get("ipdProcedureList");
		
	}
	if (map.get("category_name")!=null)
	{
		category_name = map.get("category_name").toString();
	}
	List<Integer> dischargeNoList = new ArrayList<Integer>();
	if(map.get("dischargeNoList") != null){
		dischargeNoList = (List<Integer>)map.get("dischargeNoList");
	}
	if(map.get("disposedToList") != null){
		disposedToList = (List<MasDisposedTo>)map.get("disposedToList");
	}
	List<Category> categoryList= new ArrayList<Category>();
	if(map.get("categoryList") != null){
		categoryList=(List)map.get("categoryList");
	}
	List<Object[]> caseNotesList = new ArrayList<Object[]>();
	if(map.get("caseNotesList") != null){
		caseNotesList=(List)map.get("caseNotesList");
	}
	List<MasDischargeStatus> dischargeStatusList= new ArrayList<MasDischargeStatus>();
	if(map.get("dischargeStatusList") != null){
		dischargeStatusList=(List)map.get("dischargeStatusList");
	}
	int dischargeNo = 0;
	if(dischargeNoList.size() > 0){
		dischargeNo = dischargeNoList.get(0)+1;
	}else{
		dischargeNo = 1;	
	}		

	if(map.get("doctorList") != null){
		doctorList = (List<MasEmployee>)map.get("doctorList");
	}
	
	String initDiagnosis ="";
	 String currentAge = "";
	 String consultantName = "";
	 int consultantId = 0;
	try
	{
		inpatient = (Inpatient) inPatientDetailList.get(0);
		patient = (Patient) inpatient.getHin();
		masRank = (patient.getEmployee()!=null?patient.getEmployee().getRank():null);
		masRelation = (MasRelation) patient.getRelation();
		
				
				try
				{
					servicetype = patient.getServiceType().getServiceTypeName();
				}
				catch(Exception e)
				{
					servicetype="";
				}
				if(inpatient.getInitDiagnosis()!= null)
				{
					initDiagnosis = inpatient.getInitDiagnosis();
				}
				
				try 
				{
					patientName = inpatient.getHin().getPFirstName() ;
					  
					   if(inpatient.getHin().getPMiddleName()!= null){
						   patientName=patientName+" "+inpatient.getHin().getPMiddleName();
					   }
					   if(inpatient.getHin().getPLastName()!= null){
						   patientName=patientName+" "+inpatient.getHin().getPLastName();
					   }
				} 
				catch (Exception e) 
				{
					patientName = "";
				}
				
				try{
					if(!age.equals(""))
					currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
				}catch(Exception ex){
					ex.printStackTrace();
				}
				
				try 
				{
					consultantName=inpatient.getDoctor().getRank().getRankName();
					consultantName +=" "+ inpatient.getDoctor().getFirstName();
					if(inpatient.getDoctor().getMiddleName() != null){
						consultantName += " "+inpatient.getDoctor().getMiddleName();
					}
					if(inpatient.getDoctor().getLastName() != null){
						consultantName += " "+inpatient.getDoctor().getLastName();
					}
					consultantId = inpatient.getDoctor().getId();
				} 
				catch (Exception e){ 

					consultantName = "";
				}
				
				try 
				{
					admissionNumber = inpatient.getAdNo();
				} 
				catch (Exception e) 
				{
					admissionNumber = "";
				}

				try 
				{
					serviceno = inpatient.getHin().getServiceNo();
				} 
				catch (Exception e) 
				{
					serviceno = "";
				}
				
				try 
				{
					rank = masRank.getRankName();
				} 
				catch (Exception e) 
				{
					rank = "";
				}
				
				try 
				{
					unit = patient.getUnit().getUnitName();
				} 
				catch (Exception e) 
				{
					unit = "";
				}
				
				try 
				{
					age = inpatient.getAge();
				} 
				catch (Exception e) 
				{
					age = "";
				}

				try 
				{
					sex = inpatient.getHin().getSex().getAdministrativeSexName();
				} 
				catch (Exception e) 
				{
					sex = "";
				}

				if(inpatient.getDateOfAddmission() != null) 
				{
					doa = HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission());
				} 
				
				if(inpatient.getDischargeDate() != null) 
				{
					dod = HMSUtil.convertDateToStringWithoutTime(inpatient.getDischargeDate());
				} 
				
				try 
				{
					hinId = inpatient.getHin().getId().intValue();
				} 
				catch (Exception e) 
				{
					hinId = 0;
				}
				try 
				{
					hinNo = inpatient.getHin().getHinNo();
				} 
				catch (Exception e) 
				{
					hinNo = "";
				}
				try 
				{
					departmentId = inpatient.getDepartment().getId().intValue();
				} 
				catch (Exception e) 
				{
					departmentId = 0;
				}
				try 
				{
					inpatientId = inpatient.getId().intValue();
				} 
				catch (Exception e) 
				{
					inpatientId = 0;
				}
				
				try 
				{
					relation = masRelation.getRelationName();
				} 
				catch (Exception e) 
				{
					relation = "";
				}
				
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

%>
<script>
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<script language="Javascript">
function jsOnLoad()
{
if (document.dischargePatient.casetypecombo.value=="") return;
document.dischargePatient.casetype.value=document.dischargePatient.casetypecombo.value;
document.dischargePatient.casetypecombo.disabled=true;
submitProtoAjax('dischargePatient','discharge?method=displayDischargeFields&admissionNumber=<%=admissionNumber%>');
}


function jsOnChange()
{
document.dischargePatient.casetype.value=document.dischargePatient.casetypecombo.value;
submitProtoAjax('dischargePatient','discharge?method=displayDischargeFields&admissionNumber=<%=admissionNumber%>');
}

function checkpoint(){
var case_type = '<%=category_name%>';
if(case_type == ""){
alert("Discharge summary information not submitted!!!");
return false;
}
return true;
}
</script>
<form name="dischargePatient" method="post">
<div class="titleBg"><h2>Discharge Summary</h2></div>
<div class="Block">
<label>Discharge Date <span>*</span></label>
<input	type="text" name="dischargeDate" id="dischargeDate" validate="Discharge Date,string,yes" value="<%=currentDate %>" MAXLENGTH="8" class="date" readonly="readonly"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender" onClick="setdate('<%=currentDate %>',document.dischargePatient.dischargeDate,event)" />
<label>Discharge Time <span>*</span></label> 
 <input	type="text" name="dischargeTime" id="dischargeTime" validate="Discharge Time,string,yes" value="<%=time.substring(0,5) %>" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	 MAXLENGTH="5"  />
<input	type="hidden" name="dischargeNo" id="dischargeNo" validate="Discharge No,integer,yes" value="<%=dischargeNo %>"  MAXLENGTH="5"  />
 <div class="Clear"></div>
 </div>
<div class="Clear"></div>
<h4>Patient Details</h4>
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
<label class="value"><%=(patient.getEmployee()!=null?patient.getEmployee().getRank().getRankName():"")%></label>
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

<%-- <label>Branch/Trade</label>
<%
if(patient.getTrade() != null){
%> 
<label class="value"><%=  patient.getTrade().getTradeName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%> --%>

<%-- 
<label>Unit</label> <%
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
<label class="valueFixedWidth"><%=allergies %></label>
<%}else{ %>
<label class="value"></label>
<%} %> --%>
<!-- <div class="Clear"></div> -->

<label> Diagnosis</label> 
<%
List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
if(map.get("diagnosisList")!=null){
	diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
	
}
if(diagnosisList != null && diagnosisList.size() > 0 && diagnosisList.get(0).getIcd()!=null)
{
%> <label class="valueFixedWidth"><%=diagnosisList.get(0).getIcd().getIcdName() %></label>
<%
		}else{
		%> <label class="value">-</label> <%	
		}
		%> 
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

<div class="Clear"></div>

</div>
<div class="Clear paddingTop15"></div>

<input type="hidden" name="<%=ADMISSION_NUMBER%>"	value="<%=admissionNumber%>">
<input type="hidden" name="<%=HIN_ID%>" value="<%=hinId%>">
<input type="hidden" name="<%=HIN_NO%>" value="<%=hinNo%>">
<input type="hidden" name=<%=HOSPITAL_ID%> value="<%=hospitalId%>">
<input type="hidden" name=<%=DEPARTMENT_ID%> value="<%=departmentId%>">
<input type="hidden" name=<%=INPATIENT_ID%> value="<%=inpatientId%>">
<input type="hidden" name=<%=SERVICE_NO %> value="<%= serviceno%>">
<input type="hidden" name="casetype" value="">
<%-- 
<div class="Block">
<label>Select Department</label>
<select	name="casetypecombo" onChange="jsOnChange();">
	<option value="">--Select Department--</option>
	<option value="O" <%=HMSUtil.isSelected("O",category_name)%>>Obe & Gynecology</option>
	<option value="G" <%=HMSUtil.isSelected("G",category_name)%>>General</option>
	<option value="P" <%=HMSUtil.isSelected("P",category_name)%>>Paediatrics</option>
	<option value="N" <%=HMSUtil.isSelected("N",category_name)%>>NABH</option>
</select>
<div class="Clear"></div>
</div>

<div class="Clear paddingTop15"></div>
<div id="testDiv"></div>
--%>
<div class="Clear"></div>
<h4>Discharge Details</h4>
<div class="Block">
<label>History & Examination</label>
<%
	String caseNotes = "";

if(caseNotesList.size()>0){
		for(Object[] obj :caseNotesList){
			caseNotes = (String)obj[0];
		}
	%>
<textarea name="historyExamination" cols="0" rows="0"  maxlength="300"	tabindex="1"onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)" ><%=caseNotes %></textarea>
<%}else{
%>
	<textarea name="historyExamination" cols="0" rows="0"  maxlength="300"	value=""  tabindex="1" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>

<%} %>
<label onclick=""><a href="javascript:openPopupForInvestigation();">Investigation</a></label>

<%--
<%
String chargeCode = "";
if(ipdInvestigationList.size()>0){
	for(PatientInvestigationDetails investigationDetails : ipdInvestigationList){
		if(!chargeCode.equals("")){
			chargeCode += ",\n";
		}
		chargeCode += investigationDetails.getChargeCode().getChargeCodeName();
	}}
	%>
<%if(!chargeCode.equals("")){ %>
<textarea name="investigation" cols="0" rows="0" id="investigation" maxlength="300" tabindex="1" onkeyup="return ismaxlength(this)"></textarea>
<%}else{ %>
<textarea name="investigation" cols="0" rows="0" id="investigation"  maxlength="300"	value=""  tabindex="1" onkeyup="return ismaxlength(this)"></textarea>
<%} %>
 --%>
 <textarea name="investigation" cols="0" rows="0" id="investigation"  maxlength="300"	value=""  tabindex="1" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<label>Diagnosis</label>
<%
	String diagnosis = "";
	if(ipIcdList.size() > 0){
		for(DischargeIcdCode dischargeIcdCode : ipIcdList){
			if(!diagnosis.equals("")){
				diagnosis += ",\n";
			}
			diagnosis += dischargeIcdCode.getIcd()!=null?dischargeIcdCode.getIcd().getIcdName():"";
		}
	}
%>
<textarea name="diagnosis" cols="0" rows="0"  maxlength="300" tabindex="1" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=diagnosis %></textarea>
<div class="Clear"></div>
<label onclick=""><a href="javascript:openPopupForProcedure();">Procedure Details</a></label>
<%
/*String procedure = "";
if(ipdProcedureList.size() > 0){
	for(ProcedureDetails procedureDetails : ipdProcedureList){
		if(!procedure.equals("")){
			procedure += ",\n";
		}
		procedure += procedureDetails.getNursingCare().getNursingName();
	}
	
}
*/
%>
<textarea name="procedureDetails" id="procedure" cols="0" rows="0"  maxlength="300" tabindex="1"onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<label onclick=""><a href="javascript:openPopupForTreatment();">Treatment</a></label>
<%
/*Set<PatientPrescriptionDetails> presDt = new HashSet<PatientPrescriptionDetails>();
String treatment = "";
if(ipdPrescriptionList.size()>0){
	for(PatientPrescriptionDetails presDetails : ipdPrescriptionList){
		if(!treatment.equals("")){
			treatment +=",\n";
		}
		treatment += presDetails.getItem().getNomenclature()+" "+presDetails.getFrequency().getFrequencyName();
		
	}
}
*/
%>
<textarea name="treatment" cols="0" rows="0" id="treatment" maxlength="500"	tabindex="1" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<label>Instructions to Patient</label>
<!--<textarea name="followUp" cols="0" rows="0"  maxlength="500"	tabindex="1" onkeyup="return ismaxlength(this)"></textarea>-->
<textarea name="instructionToPatient" cols="0" rows="0"  maxlength="300"	tabindex="1" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<div class="Clear"></div>
</div>

<div class="Clear"></div>
<div class="Block">

<div class="Clear"></div>
 <label>Doctor <span>*</span></label> 
<select id="medicalOfficerId" name="<%=MEDICAL_OFFICER_ID %>"  tabindex="1" validate="MO,String,yes" >
	<option value="0">Select</option>
<%
	if(doctorList.size()>0){
		for(MasEmployee employee : doctorList){
%>
<option value="<%=employee.getId() %>"><%=employee.getRank().getRankName()+" "+employee.getFirstName()+" "+(employee.getMiddleName()!=null?employee.getMiddleName():"")+" "+(employee.getLastName()!=null?employee.getLastName():"") %></option>

<%}
}%>
	</select>
	<script>
	document.getElementById('medicalOfficerId').value = '<%=consultantId%>';
	</script>
	<label>Review On </label>
<input	type="text" name="reviewDate" id="reviewDate" validate="Review Date,string,no" value="" MAXLENGTH="10" class="date" onkeyup="mask(this.value,this,'2,5','/');"		onblur="validateExpDate(this,'reviewDate'); "/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender" onClick="setdate('<%=currentDate %>',document.dischargePatient.reviewDate,event)" />

<label>Discharge Status</label>
<select name="dischargeStatus" onchange="displayMhFields(this.value)">
<option value="0">Select</option>
<%
if(dischargeStatusList.size() > 0){
	for(MasDischargeStatus dischargeStatus : dischargeStatusList){

%>
	<option value="<%=dischargeStatus.getId() %>"><%= dischargeStatus.getDischargeStatusName()%></option>
<%}
}
%>

</select>
<div class="Clear"></div>

<label>Patient Condition</label> 
<select id="patientCondition" name="patientCondition" class="year" tabindex="1" validate="Condition,String,no">
	<option value="0">Select</option>
	<option value="Normal">Normal</option>
	<option value="Critical">Critical</option>
	<option value="Dead">Dead</option>
</select>
<%-- <label>Med Cat(On Discharge)</label> 
 <select 	name="medicalCategory" id="medicalCategory" validate="Med Cat(On Discharge),string,no" tabindex=1>
 <option value="0">Select</option>
 <%
 for (Category category : categoryList) {
		%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%	}
				
 %>
 </select> --%>
 <label>Discharge To<span>*</span></label> 
<select id="dischargeTo" name="dischargeTo"  tabindex="1" validate="Discharge To,String,yes"  onchange="showDiv();">
	<option value="0">Select</option>
	<%
		for(MasDisposedTo masDisposedTo : disposedToList){
	%>
	<option value="<%=masDisposedTo.getId() %>"><%=masDisposedTo.getDisposedToName() %></option>
	<%} %>
</select>


<div id="referalDiv" style = "display:none">
		
									
		
								<div id="referDiv" class="col collaps">
								
									<div class="clear"></div>
									<label>Refer Date:</label> <input type="text"
										id="referVisitDate" name="referVisitDate" class="date"
										value="<%=currentDate%>"
										readonly="readonly"
										 />
										 <!-- onblur="checkAdmte()" -->
									
									<img  src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.ipdCaseSheet.referVisitDate,event);" /> 
									
									
	                                   
									<label id="referhospitalLabel" >Hospital <span>*</span></label> <select
										id="referhospital" name="referhospital"
										  >
										<option value="0">Select</option>
										<%for(MasImpanneledHospital msih:masImpanneledHospitalList){%>
										<option value="<%=msih.getId()%>"><%=msih.getImpanneledHospitalName()%></option>
										<%}%>
									</select>
									
								  <label id= referdayslLabel >No. of Days</label> <input id="referdays" name="referdays" type="text"
									maxlength="2"  />
									
									<div class="clear"></div>
		
									<div class="clear"></div>
									<label id="referral_treatment_type_label" >Treatment Type <span>*</span></label> 
									<select	id="referral_treatment_type" name="referral_treatment_type">										
										<option value="1" selected="true">OPD</option>
										<option value="2">Admission</option>
									</select>
									<label>Referred For<span>*</span></label>
									 <input id="referredFor" name="referredFor" type="text"
									maxlength="300" validate="Referred For,string,yes" />
									<label>Referral Note</label>
									<textarea name="remarksBYDoc" validate="remarksBYDoc,string,no"
										id="patientAdvise" cols="0" rows="0" maxlength="500"
										tabindex="5" onkeyup="return checkLength(this)"></textarea>
								
								</div>
								
							</div>

<div id="mhDiv" style="display: none">
<label>MH Name</label>
<input name="mh" type="text" tabindex="1" maxlength="32" id="mh" size="20"  />

<label>Department</label>
<input name="mhDepartment" type="text" tabindex="1" maxlength="32" id="mhDepartment" size="20"  />
<label>Referred For</label>
<input name="referredFor" type="text" tabindex="1" maxlength="50" id="mhReferredFor" size="20"  />
</div>

<div id="DischargeTransferDiv" style="display: none">
<label>Hospital Name</label>
<input name="DischargeTransferToWhere" type="text" tabindex="1" maxlength="200" id="DischargeTransferToWhere" size="20"  />


</div>
<div class="Clear"></div>
</div>
<div class="division"></div>
<div class="Clear"></div>
<!--  <input type="button" name="PatientDiagnosis" id="addbutton"
	value="Patient Diagnosis" class="buttonBig"
	onClick="submitForm('dischargePatient','discharge?method=addDischargeSummary&flag=PatientDiagnosis');"
	accesskey="a" />-->
	 <input type="button" name="Add" id="addbutton"
	value="Submit" class="button"
	onClick="submitForm('dischargePatient','discharge?method=addDischargeSummary');"
	accesskey="a" /> <!--<input type="button" name="Print" value="Print"
	class="button"
	onClick="if(checkpoint()){submitForm('dischargePatient','/hms/hms/discharge?method=showDischargeSummaryReport');}"
	accesskey="p" /> <input type="button" name="DischargeSlip"
	value="Discharge Slip" class="buttonbig"
	onClick="submitForm('dischargePatient','/hms/hms/ipd?method=showDischargeSlipReport');"
	accesskey="d" />--> <input type="reset" name="Back" value="Back"
	class="button" onclick="history.back()" accesskey="r" /> <input
	type="hidden" name="isRecordAlreadyExists"
	value="" />

<div class="Clear"></div>
	
</form>
<div class="Clear"></div>

<script>
function openPopupForInvestigation(){
	window.open('lab?method=getInvestigationDetailsForDischargeSummary&parent=<%=inpatientId%>&flag=dischargeSummary','inv','left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');
}
function openPopupForProcedure(){
	window.open('ipd?method=getProcedureForDischargeSummary&parent=<%=inpatientId%>&flag=dischargeSummary','procedure','left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');
}
function openPopupForTreatment(){
	window.open('ipd?method=getTreatmentDetailsForDischargeSummary&parent=<%=inpatientId%>&flag=dischargeSummary','procedure','left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');
}

function displayMhFields(disStatus){
	if(disStatus=='9'){
		document.getElementById('mhDiv').style.display='block';
	}else{
		document.getElementById('mhDiv').style.display='none';
	}
	
}

/* function showDiv()
{
	dischargeTo = document.getElementById('dischargeTo').value;
	alert(dischargeTo);
	
	if(dischargeTo == 12)
		{
			document.getElementById('DischargeTransferDiv').style.display='block';
		}
	else
		{
		document.getElementById('DischargeTransferDiv').style.display='none';
		}
	
	
} */
 function showDiv()
{
	/* var dischargeTo = document.getElementById('dischargeTo').innerHtml; */
	var dischargeTo = document.getElementById('dischargeTo').options[document.getElementById('dischargeTo').selectedIndex].text;	
	var externalReferralType = '<%=externalReferralType%>';	
	if(dischargeTo == externalReferralType)
		{
			document.getElementById('referalDiv').style.display='block';
			document.getElementById('referhospital').setAttribute("validate", "Hospital,String,yes");
			document.getElementById('referral_treatment_type').setAttribute("validate", "Treatment Type,String,yes");
			document.getElementById('referredFor').setAttribute("validate", "Referred For,string,yes");
			
			
		}
	else
		{
		document.getElementById('referalDiv').style.display='none';
		document.getElementById('referhospital').setAttribute("validate", " ");
		document.getElementById('referral_treatment_type').setAttribute("validate", " ");
		document.getElementById('referredFor').setAttribute("validate", " ");
		
		}
	
	
} 

</script>
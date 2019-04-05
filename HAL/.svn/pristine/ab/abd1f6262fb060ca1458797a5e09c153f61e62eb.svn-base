<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/opd.js"></script>
	

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>


<!--<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
-->
<!--</script>
-->
<!--<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
-->
<!--  By Vishnu -->
<%



Map map = new HashMap();
//String includedJsp = null;
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

}

String userName = "";
if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
}
int hospitalId=0;
if (session.getAttribute("hospitalId") != null) {
	hospitalId = (Integer) session.getAttribute("hospitalId");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");	 
String currentTime = (String)utilMap.get("currentTime");

 List <OtPreAnesthesiaHd>otPreAnesthesiaDetailsList = new ArrayList<OtPreAnesthesiaHd>();
  List 	opdPatientHistoryList= new ArrayList();	
 List otPreOPDrugsList= new ArrayList();
if(map.get("otPreAnesthesiaDetailsList") != null){
	otPreAnesthesiaDetailsList=(List<OtPreAnesthesiaHd>)map.get("otPreAnesthesiaDetailsList");
}
if(map.get("opdPatientHistoryList") != null){
	opdPatientHistoryList=(List)map.get("opdPatientHistoryList");
}
if(map.get("otPreOPDrugsList") != null){
	otPreOPDrugsList=(List)map.get("otPreOPDrugsList");
}
List<OtPreAnesthesiaDetail> otPreAnesthesiaSurgeryList = new ArrayList<OtPreAnesthesiaDetail>();
if(map.get("otPreAnesthesiaSurgeryList") != null){
	otPreAnesthesiaSurgeryList=(List)map.get("otPreAnesthesiaSurgeryList");
}
List<OtPreAnesthesiaDetail> pacDt = new ArrayList<OtPreAnesthesiaDetail>();
if(map.get("pacDt") != null){
	pacDt = (List<OtPreAnesthesiaDetail>) map.get("pacDt");
}

List<PreAnesthesiaConsultDoctorDt> ConsultDoctorDtList = new ArrayList<PreAnesthesiaConsultDoctorDt>();
if(map.get("requestList") != null){
	ConsultDoctorDtList = (List<PreAnesthesiaConsultDoctorDt>) map.get("requestList");
}

OtPreAnesthesiaHd otPreAnesthesiaDetails =null;
if(otPreAnesthesiaDetailsList.size()>0){
 otPreAnesthesiaDetails=(OtPreAnesthesiaHd)otPreAnesthesiaDetailsList.get(0);



String patientName="";
if(otPreAnesthesiaDetails.getHin().getPFirstName()!= null){
	patientName=otPreAnesthesiaDetails.getHin().getPFirstName();
}
if(otPreAnesthesiaDetails.getHin().getPMiddleName()!= null){
	patientName=patientName+" "+otPreAnesthesiaDetails.getHin().getPMiddleName();
}
if(otPreAnesthesiaDetails.getHin().getPLastName()!= null){
	patientName=patientName+" "+otPreAnesthesiaDetails.getHin().getPLastName();
}
String servicePersonName="";
if(otPreAnesthesiaDetails.getHin().getSFirstName()!= null){
	servicePersonName=otPreAnesthesiaDetails.getHin().getSFirstName();
}
if(otPreAnesthesiaDetails.getHin().getSMiddleName()!= null){
	servicePersonName=servicePersonName+" "+otPreAnesthesiaDetails.getHin().getSMiddleName();
}
if(otPreAnesthesiaDetails.getHin().getSLastName()!= null){
	servicePersonName=servicePersonName+" "+otPreAnesthesiaDetails.getHin().getSLastName();
}


//if(pacDt.size() >0 && otPreAnesthesiaDetails.getPacDate()!=null){
	if(pacDt.size() >0 && otPreAnesthesiaDetails.getPacDate()!=null){
	//if(pacDt.size() >0){
	

 //String pacDateInString =HMSUtil.changeDateToddMMyyyy(otPreAnesthesiaDetails.getPacDate());

  OpdSurgeryHeader opdSurgeryHeader =pacDt.get(0).getOpdSurgeryDetail().getOpdSurgery();
	
/* 	if(otPreAnesthesiaDetails!=null && otPreAnesthesiaDetails.getOpdSurgeryHeader() !=null)
		opdSurgeryHeader = otPreAnesthesiaDetails.getOpdSurgeryHeader();
	System.out.println("adafsa" +opdSurgeryHeader.getId()); */

	String icd = "";
	
	if(map.get("icd")!=null){
		icd=(String)map.get("icd");
	}
	
	String anesthesia="";
	if(map.get("anesthesia") != null){
		anesthesia=(String)map.get("anesthesia");
	}
/* 	List<PatientFamilyHistory> medicalHistoryTemplate = new ArrayList<PatientFamilyHistory>();
	if(map.get("medicalHistoryTemplate")!=null){
		medicalHistoryTemplate=(List<PatientFamilyHistory>)map.get("medicalHistoryTemplate");
	}	 */
	List<PatientMedicalHistory>  patientMedicalHistory = new ArrayList<PatientMedicalHistory>();
	if(map.get("PatientMedicalHistory") != null){
		patientMedicalHistory=(List)map.get("PatientMedicalHistory");
	}	
	
	boolean opdView=false;
	if(map.get("opdView") != null){
		opdView = (Boolean)map.get("opdView");
	}	 
	
	 String working_diagnosis=null;
	 if(opdSurgeryHeader.getVisit()!=null)
	 working_diagnosis = ((OpdPatientDetails)(opdSurgeryHeader.getVisit().getOpdPatientDetails().toArray()[0])).getInitialDiagnosis();
			 
			
%>

<title>Pre-Anesthesia Assessment Form Entry</title>

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}">
	<div class="titleBg">
		<h2>Pre-Anesthesia Assessment Form Entry</h2>
	</div>
	<div class="clear"></div>
	<div class="Block">
		<div class="paddingTop15"></div>
		<div class="clear"></div>
		<label>Surgery Requisition No.</label> <input type="text"
			readonly="readonly" value="<%=opdSurgeryHeader.getOrderNo() %>" />
		<label>Surgery Requisition Date</label> <input type="text"
			readonly="readonly"
			value="<%=HMSUtil.convertDateToStringWithoutTime(opdSurgeryHeader.getRequisitionDate()) %>" />
		<%-- <input type="text" readonly="readonly" value="<%=currentDate %>"  /> --%>
	</div>
	<!--Block One Starts-->
	<div class="Block">
		<h4>Patient Details</h4>
		<div class="clear"></div>

<%-- 		<label>HIN</label>
		<%if(opdSurgeryHeader.getHin().getHinNo()!= null){ %>
		<input type="text" readonly="readonly" id="hinNoUHID"
			value="<%=opdSurgeryHeader.getHin().getHinNo() %>" />
		<%}else{ %>
		<input type="text" readonly="readonly" value="-" />
		<%} %> --%>

		<label>Employee No.</label>
		<%if(opdSurgeryHeader.getHin()!= null && opdSurgeryHeader.getHin().getEmployee()!= null){ %>
		<input type="text" readonly="readonly"
			value="<%=opdSurgeryHeader.getHin().getServiceNo()%>" /> <input
			name="inPatientId" id="inPatientId" type="hidden"
			value="<%=opdSurgeryHeader.getInpatient()!=null ? opdSurgeryHeader.getInpatient().getId():""%>" />
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label>Patient Name </label>
		<%if(patientName!= null){ %>
		<input type="text" readonly="readonly" value="<%=patientName %>" />
		<%}else{ %>
		<input type="text" readonly="readonly" value="-" />
		<%} %>

		<label>Gender</label>
		<%if(opdSurgeryHeader.getHin().getSex().getAdministrativeSexName()!= null){ %>
		<input type="text" readonly="readonly"
			value="<%=opdSurgeryHeader.getHin().getSex().getAdministrativeSexName() %>" />
		<%}else{ %>
		<input type="text" readonly="readonly" value="-" />
		<%} %>


		<div class="clear"></div>
		<label>IP No. </label>
		<%if(opdSurgeryHeader.getInpatient()!= null){ %>
		<input type="text" readonly="readonly"
			value="<%=opdSurgeryHeader.getInpatient().getAdNo() %>" /> <input
			name="inPatientId" id="inPatientId" type="hidden"
			value="<%=opdSurgeryHeader.getInpatient().getId() %>" />
		<%}else{ %>
		<label class="value">-</label>
		<%} %>


		<label>Age</label>
		<%if(opdSurgeryHeader.getHin().getAge()!= null){ %>

		<input type="text" readonly="readonly"
			value="<%=opdSurgeryHeader.getHin().getAge() %>" />
		<%}else{ %>
		<input type="text" readonly="readonly" value="-" />
		<%} %>

		
		<label>Referring Doctor </label>
		<%
		   if(opdSurgeryHeader.getInpatient()!= null){ 
    %>
    
		<%if(opdSurgeryHeader.getInpatient().getDoctor()!= null){ 
	String DoctorName="";
	if(opdSurgeryHeader.getInpatient().getDoctor().getFirstName()!= null){
		DoctorName=opdSurgeryHeader.getInpatient().getDoctor().getFirstName();
	}
	if(opdSurgeryHeader.getInpatient().getDoctor().getMiddleName()!= null){
		DoctorName=DoctorName+" "+opdSurgeryHeader.getInpatient().getDoctor().getMiddleName();
	}
	if(opdSurgeryHeader.getInpatient().getDoctor().getLastName()!= null){
		DoctorName=DoctorName+" "+opdSurgeryHeader.getInpatient().getDoctor().getLastName();
	}

%>
		<input type="text" readonly="readonly" value="<%=DoctorName %>" />
		<%}else{ %>
		<input type="text" readonly="readonly" value="-" />
		<%}} %>
	<div class="clear"></div>
		<label>Admitted By </label>
		<%
		   if(opdSurgeryHeader.getVisit()!= null){ 
    %>
		<%if(opdSurgeryHeader.getVisit().getDoctor()!= null){ 
	String DoctorName="";
	if(opdSurgeryHeader.getVisit().getDoctor().getFirstName()!= null){
		DoctorName=opdSurgeryHeader.getVisit().getDoctor().getFirstName();
	}
	if(opdSurgeryHeader.getVisit().getDoctor().getMiddleName()!= null){
		DoctorName=DoctorName+" "+opdSurgeryHeader.getVisit().getDoctor().getMiddleName();
	}
	if(opdSurgeryHeader.getVisit().getDoctor().getLastName()!= null){
		DoctorName=DoctorName+" "+opdSurgeryHeader.getVisit().getDoctor().getLastName();
	}

	
%>
		<input type="text" readonly="readonly" value="<%=DoctorName %>" />
		<%}else{ %>
		<input type="text" readonly="readonly" value="-" />
		<%}} %>

		<label>Provisional Diagnosis </label>
		<%if(icd!= null){ %>
		<textarea class="large" readonly="readonly"><%=icd%></textarea>

		<%}else{ %>
		<textarea class="large" readonly="readonly">-</textarea>
		<%} %>
			<div class="clear"></div>
			<label>Working Diagnosis</label><textarea class="large" readonly="readonly"><%=working_diagnosis!=null?working_diagnosis:"" %></textarea>
			
	<%	if(opdSurgeryHeader.getHin()!=null && opdSurgeryHeader.getHin().getSex().getAdministrativeSexCode()!=null )
	{
		
		if(opdSurgeryHeader.getHin().getSex().getAdministrativeSexCode().equalsIgnoreCase("f"))
		{
			Date lmpDate =null;
			if(opdSurgeryHeader.getVisit()!=null)
				lmpDate = ((OpdPatientDetails)(opdSurgeryHeader.getVisit().getOpdPatientDetails().toArray()[0])).getLmpDate();
			
	
		%>
	  
		<label>LMP Date</label> <input type="text" readonly value="<%=lmpDate!=null?HMSUtil.convertDateToStringWithoutTime(lmpDate):""%>">
		<%} }%>
		<%-- <div class="Block">
<label>Height</label>
<%if(height!=null){ %>
<input type="text" name="height" id="heightId" value="<%=height %>" />
<%}else{ %>
<input type="text" name="height" id="heightId" value="" />
<%} %>
<label>Weight</label>
<%if(weight!=null){ %>
<input type="text" name="weight" id="weightId" value="<%=weight %>" onblur="calculateBMI();"/>
<%}else{ %>
<input type="text" name="weight" id="weightId" value="" onblur="calculateBMI();" />
<%} %>
<label>BMI</label>
<%if(bmi!=null && !bmi.equals("")){ %>
<input type="text" name="bmi" id="bmiId" value="<%=bmi %>" />
<%}else{ %>
<input type="text" name="bmi" id="bmiId" />
<%} %>
<label>BMI Status</label>
<input type="text" name="bmiStatus" id="bmiStatusId" readonly="readonly"  />
</div> --%>

		<div class="clear"></div>
		<%-- <h4>Prescription Details</h4>
<div class="clear"></div>
<table>
<tr>
<th>Item Name</th>
<th>Frequency</th>
<th>No of Days</th>
<th>Dosage</th>
<th>Total</th>
</tr>
<%for(PatientPrescriptionDetails PatientPrescriptionDetails:patientPrescriptionDetailList){ %>
<tr>
<td><%=PatientPrescriptionDetails.getItem().getNomenclature() %></td>
<%if(PatientPrescriptionDetails.getFrequency()!=null){ %>
<td><%=PatientPrescriptionDetails.getFrequency().getFrequencyName() %></td>
<%}else{ %>
<td>-</td>
<%} %>
<td><%=PatientPrescriptionDetails.getNoOfDays() %></td>
<td><%=PatientPrescriptionDetails.getDosage() %></td>
<td><%=PatientPrescriptionDetails.getTotal() %></td>
</tr>

<%} %>
</table> --%>



		<div class="clear"></div>
		<%if(!opdView) {%>
		<input type="button" class="button" tabindex="3" name=""
						value="+" onclick="OPDHistoryPopup('<%=opdSurgeryHeader.getHin().getId()%>', '<%=opdSurgeryHeader.getInpatient()!=null?opdSurgeryHeader.getInpatient().getId():"0"%>');" /> Current OPD/IPD History
				
				<%} %>		
						
						<div class="clear"></div>

		<div class="paddingTop15"></div>
		<h4>Previous Anesthetics Details</h4>
		<textarea name="anestheticName" cols="0" readonly="readonly" rows="0"
			class="large" style="margin-left: 7px;"><%=otPreAnesthesiaDetails!=null?otPreAnesthesiaDetails.getPreviousAnesthetics()!=null?otPreAnesthesiaDetails.getPreviousAnesthetics():"":""%>
	</textarea>


		<input type="button" name="Submit" class="button" value="Allergy"
			onclick="javascript:openPopupWindow();" />


		<div class="clear"></div>	
		<%
		
if(patientMedicalHistory!=null && patientMedicalHistory.size()!=0)
{
%>
		<h4>Medical History</h4>
		<div class="clear"></div>
		<label>Disease </label> <label style="width:149px;">Status</label>
		<label style="width:149px; margin-left:10px;">Duration</label>
		<div class="clear"></div>
		<%
	 int mhcount = 0;
	/* for(PatientFamilyHistory fh :medicalHistoryTemplate) 
	{ */  
    %> 
	
	<%-- <label><%=fh.getPatientPresentComplaintName()%></label> --%>
	<%for(PatientMedicalHistory mh: patientMedicalHistory)
	{  /* if(mh.getPatientFamilyHistory().getId() == fh.getId())
			{ */
		%>  
		<label><%=mh.getPatientFamilyHistory().getPatientPresentComplaintName()%></label><label class="value"><%=mh.getDiseaseStatus()%></label><label class="value"><%=mh.getDuration()%></label><div class="clear"></div>
	<%}//}
	
	
	
	/* }//fh loop */
	 %>
	 <input type="hidden" name="mhcount" value="<%=mhcount%>">
	
	<%} %>

		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>


<%-- 		<%

if(patientMedicalHistory!=null && patientMedicalHistory.size()!=0)
{
%>


		<h4>Medical History</h4>

		<div class="clear"></div>
		<label>Disease </label> <label>Status</label> <label>Duration</label>
		<div class="clear"></div>
		<%
	 int mhcount = 0;
	for(PatientMedicalHistory mh :patientMedicalHistory) 
	{
		mhcount++;
		
	 %>
		<label><%=mh.getPatientFamilyHistory()%></label> <select
			name="mhStatus<%=mhcount%>"><option>No</option>
			<option>Yes</option></select> <input type="text" name="mhDuration<%=mhcount%>">
		<%
	}
	 %>
		<div class="Block"></div>

		<%} %> --%>

		<div class="paddingTop15"></div>

		<%-- <label>Surgery Name </label> <textarea name="surgeryName" cols="0"
	rows="0" class="large" readonly="readonly" >
		<%
		String message1="No records.";
		if(opdSurgeryHeader.getOpdSurgeryDetails()!=null){
			 
		%>
		<%=((OpdSurgeryDetail)(opdSurgeryHeader.getOpdSurgeryDetails().toArray()[0])).getChargeCode().getChargeCodeName() %>
		<% }else{%>
		<%=message1%>
<%} %>
</textarea>
 
<div class="division"></div>
<!--Block one Ends--> <label>Patient Past History</label> <% 
		String presentHistory="";
		String pastHistory="";
		String presentMedication="";
		int opdPatientHistoryId=0;
		if(opdPatientHistoryList!= null && opdPatientHistoryList.size()>0){
		 OpdPatientHistory opdPatientHistory= (OpdPatientHistory)opdPatientHistoryList.get(0);
			 presentHistory=opdPatientHistory.getPersonalPresentHistory();
			 pastHistory=opdPatientHistory.getPersonalPastHistory();
			 opdPatientHistoryId=opdPatientHistory.getId();
			 presentMedication=opdPatientHistory.getPersonalPresentMedication();
		}
		if(pastHistory !=null){
		%> <textarea name="pastHistory" cols="0" rows="0" class="large"
	maxlength="500" onkeyup="return ismaxlength(this)"><%=pastHistory %></textarea>
<%}else { %> <textarea name="pastHistory" cols="0" rows="0" class="large"
	maxlength="500" onkeyup="return ismaxlength(this)">No Records.</textarea>
<%} %> <!-- <h5>Past History</h5>
	<textarea name="pastHistory" cols="0" rows="0" class="large" maxlength="500" onkeyup="return ismaxlength(this)"></textarea>
	 -->
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label>Drug Therapy </label> <textarea name="drugTreatment" cols="0"
	rows="0" class="large" >
		<%
		String message="No records.";
		if(presentMedication!=null){
			if(!presentMedication.equals("")){
		%>
		<%=presentMedication %>
		<% }}else{%>
		<%=message%>
<%} %>
</textarea>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label>Patient Personal History</label> <%if (presentHistory!=null){ %> <textarea
	name="presentHistory" cols="0" rows="0" class="large" maxlength="500"
	onkeyup="return ismaxlength(this)"><%=presentHistory %></textarea> <%}else{ %>
<textarea name="presentHistory" cols="0" rows="0" class="large"
	maxlength="500" onkeyup="return ismaxlength(this)">No Records</textarea>
<%} %>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label>Smoking/ Alcohol</label>

<select name="smoking" class="midium" >
	<option value="">Select</option>
	<option value="Smoking">Smoking</option>
	<option value="Alcohol">Alcohol</option>
	<option value="Both">Both</option>
</select>

<label>Prev Treatment/Surgery</label> <input name="Previous treatment"
	type="text" class="large" maxlength="100" />
<div class="clear"></div>
<label>Diet Category</label>
<select name="smoking" class="midium">
	<option value="">Select</option>
	<option value="veg">VEG</option>
	<option value="nonVeg">NON-Veg</option>
</select>
<div><label>Drug Therapy </label></div>
<input name="drugTherapy" type="text" class="large" maxlength="45" />
</div>
 --%>
		<%-- <div class="clear"></div>
<h4>Bed Arrangements</h4>
<div class="clear"></div>
<div class="Block">
<label>Arrange Bed</label>
<input type="checkbox" name="arrangeBed" id="arrangeBedId" value="" onclick="setBedStatus()" />
<input type="hidden" name="arrangeBed1" id="arrangeBedId1" value="n" />
<div id="ventilatorId" style="display: none;">
<label>Ward</label>
<select name="wardName" id="wardId">
<option value="0">Select</option>
<%for(MasDepartment dept:wardDepartmentList){ %>
<option value="<%=dept.getId()%>"><%=dept.getDepartmentName() %></option>
<%} %>
</select>
<select name="vent" >
<option value="withVen">With Ventilator</option>
<option value="withoutVen">Without Ventilator</option>
</select>
<div class="clear"></div>
<label>Remarks</label>
<textarea class="large" name="remarksForBedArrangement" maxlength="250">

</textarea>
</div>

</div> --%>


		<div class="Block">
		
		<label>Procedure</label> 
<%

	String procedureName = "";
	 int count =0;
	for(OtPreAnesthesiaDetail pacd:otPreAnesthesiaSurgeryList){
		if(count++>=1)
			procedureName = procedureName.concat(" | ");
		    procedureName =procedureName+ pacd.getOpdSurgeryDetail().getChargeCode().getChargeCodeName(); 
	}
 %>
  <label class="value"><b><%=procedureName %></b></label>  
<%
%>

<div class="clear"></div>
		    <h4>Vitals</h4>
			<label class="auto">Weight</label> <input type="text" class="auto" size="8" value="<%=otPreAnesthesiaDetails.getWeight()!=null?otPreAnesthesiaDetails.getWeight():""%>" readonly="readonly"><label class="unit" style="margin-right: 25px;">kg</label>
			<label class="auto">BP</label><input type="text" class="auto" size="8" value="<%=otPreAnesthesiaDetails.getBp()!=null?otPreAnesthesiaDetails.getBp():""%>" readonly="readonly"><label class="unit" style="margin-right: 25px;">mmHg</label>
			<label class="auto">Pulse</label><input type="text" class="auto" size="8" value="<%=otPreAnesthesiaDetails.getPulse()!=null?otPreAnesthesiaDetails.getPulse():""%>" readonly="readonly"><label class="unit" style="margin-right: 25px;">min</label>
			<label class="auto">RR</label><input type="text" class="auto" size="8" value="<%=otPreAnesthesiaDetails.getPr()!=null?otPreAnesthesiaDetails.getPr():""%>" readonly="readonly"><label class="unit">min</label>
	<div class="clear"></div>
		
			<h4>General Examination</h4>
			<div class="paddingTop15"></div>
			<div class="clear"></div>
			<%-- <label >Pulse</label> <input name="pulse" type="text" maxlength="15"  />
<label>Icetrus</label> <input name="icetrus" type="text" maxlength="15"  />
<label >Nourishment</label><input name="nourishment" type="text" maxlength="15"  />
<label>Pallor</label> <input name="pallor" type="text"	maxlength="15"  />

<label >Oedema</label> <input name="oedema" type="text" maxlength="15"  />
<label >BP</label> 
<%if(bp!=null && !bp.equals("")){ %>
<input name="bp" type="text" onblur="validateBpValue(this.value);" id="bp" value="<%=bp %>" maxlength="10" />
<%}else{ %>
<input name="bp" type="text" onblur="validateBpValue(this.value);" id="bp" maxlength="10" />
<%} %>
<div class="clear"></div> 
<label>Cyanosis</label> <input name="cyanosis" type="text" maxlength="15"  /> 
<label >Spine</label> <input name="spine" type="text" maxlength="15"  />

<label >Airway</label>
<input name="airway" type="text" maxlength="15"  /><div class="clear"></div> 
<label >Clubbing</label>
<input name="clubbing" type="text" maxlength="15"  />
<label>Thyroid</label> <input name="thyroid" type="text" maxlength="15"  />
<label >Venous Access </label> <input name="venous" type="text" maxlength="15"  />

<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Respiratory System</h4>
<div class="clear"></div>
<div class="paddingTop15"></div>

<label >Breath Sound </label> <input name="breath"
	type="text" maxlength="25"  /> <label >Adv.
Sound </label> <input name="advance" type="text" maxlength="25"  />

<div class="clear"></div>

<div class="clear"></div>

<h4>Cardio Vascular System</h4>

<div class="clear"></div>

<label class="auto">S1 </label> 
<input id="s1" name="s1" type="checkbox" value="s1" class="radioCheck css-checkbox" />
 
<label class="auto">S2 </label> 
<input id="s2" name="s2" type="checkbox" value="s2" class="radioCheck css-checkbox" />
 
<label class="auto">S3 </label> 
<input id="s3" name="s3" type="checkbox" value="s3"	class="radioCheck css-checkbox" />
 
<label class="auto">S4 </label> 
<input id="s4" name="s4" type="checkbox" value="s4" class="radioCheck css-checkbox" /> --%>

			<label>Pallor</label> <input type="text" value="<%=otPreAnesthesiaDetails.getPallor()%>" readonly="readonly">
				<label>Icterus</label><input type="text" value="<%=otPreAnesthesiaDetails.getIcetrus()%>" readonly="readonly">
				 <label>Cyanosis</label><input type="text" value="<%=otPreAnesthesiaDetails.getCyanosis()%>" readonly="readonly">	<div class="clear"></div>
				  <label>Koilonychia</label><input type="text" value="<%=otPreAnesthesiaDetails.getKoilonychia()%>" readonly="readonly">
				  <label>Oedema</label><input type="text" value="<%=otPreAnesthesiaDetails.getOedema()%>" readonly="readonly">
				   <label>Lymphadenopathy</label><input type="text" value="<%=otPreAnesthesiaDetails.getLymphadenopathy()%>" readonly="readonly">
			<div class="clear"></div>
			<div class="clear"></div>
			<div class="clear"></div>
		</div>

		<div class="Block">
			<h4>Airway</h4>
			<label>MPC</label><input type="text" value="<%=otPreAnesthesiaDetails.getMpc()%>" readonly="readonly">
			<label>TMD</label><input type="text" value="<%=otPreAnesthesiaDetails.getTmd()%>" readonly="readonly">
			<label>TMJ</label><input type="text" value="<%=otPreAnesthesiaDetails.getTmj()%>" readonly="readonly">
			<div class="clear"></div>
			<label>MO</label><input type="text" value="<%=otPreAnesthesiaDetails.getMo()%>" readonly="readonly">
			<label>Teeth</label><input type="text" value="<%=otPreAnesthesiaDetails.getTeeth()%>" readonly="readonly">
			<div class="clear"></div>
			<label>I.V. Access </label>
			<textarea maxlength="15" readonly="readonly"><%=otPreAnesthesiaDetails.getVenousAccess()%></textarea>
			<label>Spine</label>
			<textarea  maxlength="15" readonly="readonly"><%=otPreAnesthesiaDetails.getSpine()%></textarea>
			<label>Echo</label>
			<textarea  maxlength="15" readonly="readonly"><%=otPreAnesthesiaDetails.getEco()%></textarea>
			<label>ECG</label>
			<textarea  maxlength="15" readonly="readonly"><%=otPreAnesthesiaDetails.getEcg()%></textarea>
			<label>Chest X-Ray</label>
			<textarea  maxlength="15" readonly="readonly"><%=otPreAnesthesiaDetails.getChestXray()%></textarea>
		</div>

		<div class="clear"></div>
		<div class="Block">
			<div class="clear"></div>

			<label>CVS</label><input type="text" value="<%=otPreAnesthesiaDetails.getCvs()%>" readonly="readonly">
			<label>RS</label><input type="text" value="<%=otPreAnesthesiaDetails.getRs()%>" readonly="readonly">
			<label>Abdomen</label><input type="text" value="<%=otPreAnesthesiaDetails.getAbdomen()%>" readonly="readonly">	<div class="clear"></div>
			<label>CNS</label><input type="text" value="<%=otPreAnesthesiaDetails.getCns()%>" readonly="readonly">

		</div>

		<div class="clear"></div>
	

	
			<div class="Block">
				<h4>Others</h4>
				<label class="auto" style="padding: 0px 12px 0px 5px;"><span>*</span>
					Anesthetic Technique Planed</label> <input type="text" value="<%=otPreAnesthesiaDetails.getAnashteicDetails()%>" readonly="readonly">
					 <label>Additional Remarks</label>
				<textarea  maxlength="15" readonly="readonly"><%=otPreAnesthesiaDetails.getAddtionalRemarks()%></textarea>
				<div class="clear"></div>
				<div class="clear"></div>
				<div class="clear"></div>
				
				<%if(opdView) {
				  if(ConsultDoctorDtList.size() >0)
				  {
				%>
				   <div class="cmntable">
		  <h4>Doctor Advice</h4>
		 <!--  <label>Referral Notes</label><textarea type="text" name="doctorAdvice"  maxlength="200"class="large"></textarea>
		  	<label>Advice</label><textarea type="text" name="doctorAdvice"  maxlength="200"class="large"></textarea>
		  	 -->
		  	<table>
		  	
		  	<tr>
		  	<th>Referred Date</th>
		  	<th>Referred Department</th>
		  	<th>Referred Doctor</th>
		  	<th>Referral Notes</th>
		  	<th>Doctor Advice</th></tr>
		  	
		  	<%
		  	int hbt=0;
		  	for(PreAnesthesiaConsultDoctorDt doctdt:ConsultDoctorDtList){ 
		  		hbt ++;
		  	
		  	%>
		  	<tr>
			<td><%=HMSUtil.convertDateToStringWithoutTime(doctdt.getConsultDate())%></td>
				<td><textarea readonly="readonly" class="medium" ><%=doctdt.getConsultedDepartment().getDepartmentName()%></textarea></td>
					<td><textarea readonly="readonly" class="medium" ><%=doctdt.getConsultedDoctor()!=null?doctdt.getConsultedDoctor().getFirstName():"-"%></textarea></td>
		  	<td><textarea readonly="readonly" class="medium" ><%=doctdt.getReferralNotes()%></textarea></td>
		  	<td><textarea readonly="readonly" class="medium"><%=doctdt.getDoctorAdvice()!=null?doctdt.getDoctorAdvice():""%></textarea></td>
		  	</tr>
		  	<%} %>
		  	
		  	</table>
		  	<input type="hidden" name="hbt" value="<%=hbt%>"/>
		</div>
				
				<%}} else { %>
				
<form name="preAnesthesia" method="post" action="">
	<div class="Block">
		  <h4>Doctor Advice</h4>
		 <!--  <label>Referral Notes</label><textarea type="text" name="doctorAdvice"  maxlength="200"class="large"></textarea>
		  	<label>Advice</label><textarea type="text" name="doctorAdvice"  maxlength="200"class="large"></textarea>
		  	 -->
		 <div class="cmntable">
		  	<table>
		  	<tr>
			<th>Referred Date</th>
		  	<th>Referral Notes</th>
		  	<th>Please Enter Your Advice</th></tr>
		  	
		  	<%
		  	int hbt=0;
		  	for(PreAnesthesiaConsultDoctorDt doctdt:ConsultDoctorDtList){ 
		  		hbt ++;
		  	
		  	%>
		  	<tr>
			<td><%=HMSUtil.convertDateToStringWithoutTime(doctdt.getConsultDate())%></td>
		  	<td><input type="hidden" name="question<%=hbt%>" value="<%=doctdt.getId()%>"/><textarea readonly="readonly" class="large" ><%=doctdt.getReferralNotes()%></textarea></td>
		  	<td><textarea name="answer<%=hbt%>"  maxlength="500"class="large"></textarea></td>
		  	</tr>
		  	<%} %>
		  	
		  	</table>
		  	</div>
		  	<input type="hidden" name="hbt" value="<%=hbt%>"/>
		</div>
					<input type="hidden" name="surgeryId" value="<%=otPreAnesthesiaDetails.getId()%>"/>
			<input name="patientStatus" type="hidden"
				value="<%=opdSurgeryHeader.getPatientStatus() %>" /> <input
				type="hidden" id="requestId"
				value="<%=opdSurgeryHeader.getHin().getId() %>" /> <input
				name="hinId" id="hinId" type="hidden"
				value="<%=opdSurgeryHeader.getHin().getId() %>" /> <input
				name="hospitalId" type="hidden" value="<%=hospitalId %>" />  <input
				name="orderNo" type="hidden"
				value="<%=opdSurgeryHeader.getOrderNo() %>" />
						<input name="surgeryDoctor" type="hidden"
						value="<%=opdSurgeryHeader.getEmployee().getId()%>" />
				 <input
				name="changedBy" type="hidden" value="<%=userName %>" /> <input
				name="changedDate" type="hidden" value="<%=currentDate %>" /> <input
				name="changedTime" type="hidden" value="<%=currentTime %>" /> <input
				type="button" name="Submit" class="button" value="Submit"
				<%-- onclick="if(checkGrade()){submitForm('preAnesthesia','ot?method=submitPreAnesthesiaDetails&pastHistory=<%=pastHistory%>&presentHistory=<%=presentHistory%>');}" /> --%>
		onclick="submitForm('preAnesthesia','ot?method=submitDoctorAdviceForPACClearance');" />

		<!-- 	<input name="back" type="button" class="button" value="Back"
				onclick="submitForm ('preAnesthesia','ot?method=showPACClearanceList')" /> -->
			<div class="clear"></div>
		</div>
		<div class="division"></div>
		<div class="clear"></div>
		<div class="bottom">
			<label>Changed By</label> <label class="value"><%=userName %></label>

			<label>Changed Date</label> <label class="value"><%=currentDate %></label>

			<label>Changed Time</label> <label class="value"><%=currentTime %></label>
			<div class="clear"></div>
			<div class="paddingTop40"></div>
		</div>
</form>
<%}
	}			
				
}
	  else
	  {
%>
		<h2>No record</h2>  
<%} %>
<%-- <div class="Block">
<h4>Others</h4>
<div class="clear"></div>

<label>Abdomen</label> <textarea name="abdomen" class="textareaMediua"
	cols="" rows="" maxlength="100" onkeyup="return ismaxlength(this)"></textarea>

<label>Liver</label> <textarea name="liver" cols="" rows="" class="textareaMediua"
	maxlength="100" onkeyup="return ismaxlength(this)"></textarea> <label>Spleen</label>
<textarea name="spleen" cols="" rows="" maxlength="100" class="textareaMediua"
	onkeyup="return ismaxlength(this)"></textarea>

<div class="clear"></div>

<input type="text" value="" id="anaesthicPlanned" name="anaesthicPlanned" style="width:160px;" />
<div class="clear"></div>
 <label>Blood Component </label> 
<!--  <input name="blood" type="text" maxlength="25" /> -->
 <select name="blood" multiple="multiple" class="list" size="25" >
 <option value="">Select</option>
 <%for(BloodMasComponent BloodMasComponent:BloodMasComponentList){ %>
 <option value="<%=BloodMasComponent.getComponentName().concat("[").concat(""+BloodMasComponent.getQtyUnit()+" "+"ml").concat("]")%>"><%=BloodMasComponent.getComponentName().concat("[").concat(""+BloodMasComponent.getQtyUnit()+" "+"ml").concat("]") %></option>
 <%} %>
 </select>
 <label>Unit</label>
 <input type="text" name="unitForBloodComponent" id="unitForBloodComponentId" value=""  maxlength="4" />
 
	<div class="clear"></div>
	<label>In</label> <select name="">
	<option>select</option>
	<option>OT</option>
</select>
<div class="clear"></div>
<label>Any Special Instruction</label> <textarea name="instructions" class="textareaMediua"
	cols="" rows="" maxlength="100" onkeyup="return ismaxlength(this)"></textarea>
<label>ASA Grade</label> <select name="asa" id="asa">
	<option value="">Select</option>
	<option value="I">I</option>
	<option value="II">II</option>
	<option value="III">III</option>
	<option value="IV">IV</option>
	<option value="V">V</option>
</select> <label>Patient Type</label> 
<select name="patientType" id="patientType">
	<option value="">Select</option>
	<option value="new">New</option>
	<option value="Review">Review</option>

</select>
<div class="clear"></div>
<label>Fit for surgery</label>
<select name="fitForSurgery" id="fitForSurgery1" onchange="getFitForSurgery(this.value);">
<option value="">-Select-</option>
<option value="y">Yes</option>
<option value="n">Pending</option>
</select>
<div id="fitForSurgery" style="display: none;"><label>Doctor</label>
<select name="doctorName" id="doctorId">
<option value="0">Select</option>
<%for(MasEmployee emp:doctorList){ %>
<option value="<%=emp.getId()%>"><%=emp.getFirstName()%></option>
<%} %>
</select>
<label>Remarks</label>
<textarea name="remarks" ></textarea>

</div>
<div class="clear"></div>
<label>Summary</label>
<textarea name="summary" id="summaryId" class="textareaMediua">

</textarea>
<div class="clear"></div>
<input name="investigation"
	type="button" value="View Patient History" class="inputButtonAutu"
	onclick="showPatientHistory();" />
	
	<input name="investigation"
	type="button" value="Blood request" class="inputButtonAutu"
	onclick="getBloodRequest('<%=opdSurgeryHeader.getHin().getHinNo() %>')" />

<input name="patientStatus" type="hidden"
	value="<%=opdSurgeryHeader.getPatientStatus() %>" />
	<input type="hidden" id="requestId" value="<%=opdSurgeryHeader.getHin().getId() %>"/>
	
	
	
	 <input	name="hinId" id="hinId" type="hidden"	value="<%=opdSurgeryHeader.getHin().getId() %>" /> 
	 <input	name="hospitalId" type="hidden" value="<%=hospitalId %>" /> 
	 <input	name="deptId" type="hidden" value="<%=deptId %>" /> 
	 <input	name="orderNo" type="hidden" value="<%=opdSurgeryHeader.getOrderNo() %>" /> 
	 <input name="changedBy"
	type="hidden" value="<%=userName %>" /> <input name="changedDate"
	type="hidden" value="<%=currentDate %>" /> <input name="changedTime"
	type="hidden" value="<%=currentTime %>" /> <input type="button"
	name="Submit" class="button" value="Submit"
	onclick="if(checkGrade()){submitForm('preAnesthesia','ot?method=submitPreAnesthesiaDetails&pastHistory=<%=pastHistory%>&presentHistory=<%=presentHistory%>');}" />

<input name="back" type="button" class="button" value="Back"
	onclick="submitForm ('preAnesthesia','ot?method=showPACClearanceList')" />
<div class="clear"></div>
</div> 
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=currentDate %></label>

<label>Changed Time</label> <label class="value"><%=currentTime %></label>
<div class="clear"></div>
<div class="paddingTop40"></div>
</div>
</form>
--%>
<!--main content placeholder ends here-->


<script type="text/javascript">
	
	
		function ismaxlength(obj){
		var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
		if (obj.getAttribute && obj.value.length>mlength)
		obj.value=obj.value.substring(0,mlength)
		}
		
		function checkGrade(){
		var grade=document.getElementById('grade').value;
		if (grade== ""){
		
			if(!displayAlert("Please Enter the Anesthtic Technique Planned."))
				alert("Please Enter the Anesthtic Technique Planned.");
			getShadow('grade');
		    return false;
		}
		  return true;
		}
		
		
		function openPopupForInvestigation(patientStatus){
			
			var hinId=document.getElementById('hinId').value;
			if(patientStatus=="OutPatient"){
			var visitId=document.getElementById('visitId').value
			   var url="/hms/hms/ot?method=openPopUPWindowForInvestigationJsp&patientStatus="+patientStatus+"&visitId="+visitId+"&hinId="+hinId;
			}else{
			 var inpatientId=document.getElementById('inPatientId').value
			   var url="/hms/hms/ot?method=openPopUPWindowForInvestigationJsp&patientStatus="+patientStatus+"&hinId="+hinId+"&inpatientId="+inpatientId;
			}
		   popwindow(url);
		}
		var newwindow;
		function popwindow(url)
		{
		 newwindow=window.open(url,'name',"height=300,width=700,status=1");
		
		}

		function validateBpValue(obj){
			var bpObj = document.getElementById('bp');
			 var bool =validateBpWithSlash(obj)
			if(bool)
			{

			if(obj != ""){
			var index=obj.indexOf('/');
			if(index != 3){
				if(!displayAlert("BP should be in max/min Format."))
					alert("BP should be in max/min Format.");
				showShadow(bpObj);
				 bpObj.value="";
				 //bpObj.focus();
				 return false;
				 }


				 var pairs2 = obj.substring(0,obj.length).split('/');
				 if (pairs2.length!=2) {
					 if(!displayAlert("Invalid  Format."))
						 alert("Invalid  Format.");
					 showShadow(bpObj);
					return false;
					}

				val3=eval(pairs2[0]);
				if (val3>240) {
					if(!displayAlert("Maximum BP should be less than 240."))
						alert("Maximum BP should be less than 240.");
					showShadow(bpObj);
				 return false;}

				val2=eval(pairs2[1]);
				if (val2<60 ) {
					if(!displayAlert("Maximum BP should be less than 240."))
						alert("Minimum BP should be greater than 60");
					showShadow(bpObj);
				  return false;}


			}
			return true;
			}
			showShadow(bpObj);
			bpObj.value="";
			return false;
			}
		function stValueToAnaesthicPlanned(val){
				val=val+" ";
				var valForAna=document.getElementById('anaesthicPlanned').value;
				val=valForAna+val+",";
				document.getElementById('anaesthicPlanned').value=val;
			     
				}
	</script>
<script>
function getBloodRequest(hinNo){
	submitForm('preAnesthesia','bloodBank?method=searchPatientForBloodRequest&<%=HIN_NO%>='+ hinNo);

	}
</script>

<script type="text/javascript">
	function openPopupWindow() {
		var requestId = document.getElementById("requestId").value.trim();

		//window.open("/hms/hms/ot?method=showAllergy&requestId="+requestId+"&"+csrfTokenName+"="+csrfTokenValue,"_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=850, height=400");
		window
				.open(
						"/hms/hms/ot?method=showAllergy&requestId=" + requestId,
						"_blank",
						"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=850, height=400");
	}
</script>
<script>
	function getFitForSurgery(val) {
		//alert(""+val)
		if (val == 'n') {
			document.getElementById('fitForSurgery').style.display = "inline";
		} else if (val == 'y') {
			document.getElementById('fitForSurgery').style.display = "none";
		} else //if(val=='')
		{
			document.getElementById('fitForSurgery').style.display = "none";
		}
	}
</script>
<script>
	function calculateBMI() {
		document.getElementById('bmiId').value = '';
		if (document.getElementById('heightId').value != ""
				&& document.getElementById('weightId').value != "") {
			var height = parseFloat(document.getElementById('heightId').value) / 100;
			var weight = document.getElementById('weightId').value;
			document.getElementById('bmiId').value = (weight / (height * height))
					.toFixed(2);
		}
		bmiCat();
	}

	function bmiCat() {
		var bmicat;
		document.getElementById('bmiId').value = '';
		if (document.getElementById('heightId').value != ""
				&& document.getElementById('weightId').value != "") {
			var height = parseFloat(document.getElementById('heightId').value) / 100;
			var weight = document.getElementById('weightId').value;
			document.getElementById('bmiId').value = (weight / (height * height))
					.toFixed(2);
			bmicat = (weight / (height * height)).toFixed(2);
		}
		document.getElementById('bmiStatusId').value = ' ';
		if (bmicat < 18.5) {
			document.getElementById('bmiStatusId').value = 'Underweight';
		} else if (bmicat >= 18.5 && bmicat < 25) {
			document.getElementById('bmiStatusId').value = 'Healthy Range';
		} else if (bmicat >= 25 && bmicat <= 30) {
			document.getElementById('bmiStatusId').value = 'Overweight';
		} else if (bmicat >= 30 && bmicat <= 35) {
			document.getElementById('bmiStatusId').value = 'Obese';
		} else if (bmicat > 35) {

			document.getElementById('bmiStatusId').value = 'Severely obese';
		} else {
			document.getElementById('bmiStatusId').value = '';
		}
	}
	function setBedStatus() {
		if (document.getElementById('arrangeBedId').checked == true) {
			document.getElementById('ventilatorId').style.display = "inline";
			document.getElementById('arrangeBedId1').value = 'y';
		} else if (document.getElementById('arrangeBedId').checked == false) {
			document.getElementById('ventilatorId').style.display = "none";
			document.getElementById('arrangeBedId1').value = 'n';
		}

	}
	function showPatientHistory() {
		//document.opdMain.action="/hms/hms/enquiry?method=showPatientDetails&hinNo="+hinNo;
		//document.opdMain.submit();
		// var visitId = document.getElementById("visitId").value;
		var hinNo = document.getElementById('hinNoUHID').value;
		var url = '/hms/hms/enquiry?method=showPatientDetails&hinNo=' + hinNo
				+ '&' + csrfTokenName + '=' + csrfTokenValue;
		newwindow = window
				.open(url, 'opd_window',
						"left=100,top=100,height=700,width=1024,status=1,scrollbars=yes,resizable=0");
	}

	function addRowForInvestigation() {

		var tbl = document.getElementById('investigationGrid');
		var lastRow = tbl.rows.length;

		// if there's no header row in the table, then iteration = lastRow + 1
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('hiddenValue');
		var iteration = parseInt(hdb.value) + 1;
		hdb.value = iteration
		// alert("iteration row--"+iteration)

		var cellRight0 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'text';
		// e0.innerHTML = iteration+':'
		e0.onblur = function() {

			if (validateInvestigationAutoComplete(this.value, iteration)) {
				checkForChargeCode(this.value, iteration, 'chargeCodeVal'
						+ iteration);
			}

		};
		var newdiv1 = document.createElement('div');
		newdiv1.id = 'ac2update' + iteration;
		newdiv1.className = 'autocomplete';
		newdiv1.style.display = 'none';

		e0.name = 'chargeCodeName' + iteration;
		e0.id = 'chargeCodeName' + iteration;
		e0.setAttribute('tabindex', '1');
		//alert("name--"+e0.name)
		e0.size = '100'
		cellRight0.appendChild(newdiv1);

		cellRight0.appendChild(e0);
		e0.focus();

		new Ajax.Autocompleter(
				'chargeCodeName' + iteration,
				'ac2update' + iteration,
				'opd?method=getInvestigationListForAutoComplete',
				{
					callback : function(element, entry) {
						return entry
								+ '&labradiologyCheck='
								+ document
										.getElementById('investigationCategory').value;
					},
					parameters : 'requiredField=chargeCodeName' + iteration
				});
		var sel = document.createElement('input');

		sel.type = 'hidden';
		sel.name = 'chargeCode' + iteration;
		sel.id = 'chargeCode' + iteration
		sel.size = '10';
		sel.setAttribute('tabindex', '1');
		cellRight0.appendChild(sel);

		var e2 = document.createElement('input');
		e2.type = 'hidden';
		e2.name = 'qty' + iteration;
		e2.id = 'qty' + iteration
		e2.size = '10';
		e2.setAttribute('tabindex', '1');
		cellRight0.appendChild(e2);

		/* 	  var cellRight1 = row.insertCell(1);
		 var e3 = document.createElement('input');
		 e3.type = 'checkbox';
		 e3.name='referToMh'+iteration;
		 e3.id='referToMhId'+iteration
		 e3.size='10';
		 e3.className='radio';
		 e3.value='y';
		 e3.setAttribute('tabindex','1');
		 cellRight1.appendChild(e3); */

		var cellRight2 = row.insertCell(1);
		var e4 = document.createElement('input');
		e4.type = 'button';
		e4.className = 'buttonAdd';
		e4.name = 'Button';
		e4.setAttribute('tabindex', '1');
		//e4.setAttribute('onClick','addRowForInvestigation();');
		e4.onclick = function() {
			addRowForInvestigation();
		};
		cellRight2.appendChild(e4);

		var cellRight3 = row.insertCell(2);
		var e5 = document.createElement('input');
		e5.type = 'button';
		e5.className = 'buttonDel';
		e5.name = 'deldddete';
		e5.setAttribute('tabindex', '1');
		e5.onclick = function() {
			removeRow("investigationGrid", "hdb", this);
		};
		//e5.setAttribute('onClick','removeRow("investigationGrid","hdb",this);');
		cellRight3.appendChild(e5);

		//fayaz removed
		//var cellRight3 = row.insertCell(1);
		// var e3 = document.createElement('input');
		// e3.type = 'text';
		// e3.name='clinicalNotes'+iteration;
		// e3.id='clinicalNotes'+iteration;
		// e3.setAttribute('tabindex','1');
		// e3.size='60'
		// cellRight3.appendChild(e3);

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

	function fnGetDoctorDepartment(departmentId, divName) {
		// new Ajax.Request('opd?method=getDoctorDepartment&departmentId='+departmentId+'&'+csrfTokenName+'='+csrfTokenValue, {
		new Ajax.Request(
				'opd?method=getDoctorDetails&departmentId=' + departmentId,
				{
					onSuccess : function(response) {
						if (response.responseText.trim() != '') {
							document.getElementById(divName).innerHTML = response.responseText
									.trim();
						}
					}
				});
	}

	 function OPDHistoryPopup(hinId,inpatientId)
		{
		//var url='/hms/hms/opd?method=showPopUpPresentComplaint&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
			 var url='/hms/hms/ot?method=openPopupWindowForOPDHistory&hinId='+hinId+"&inpatientId="+inpatientId;
		 //popwindow(url);
		 window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
		} 
	 
	 function IPDHistoryPopup(tempCode)
		{
		//var url='/hms/hms/opd?method=showPopUpPresentComplaint&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
			 var url='/hms/hms/ot?method=showPopUpHistoryTemplate&tempCode='+tempCode;
		// popwindow(url);
		 window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
		} 
		
	jQuery(function($) {

		$("#referDiv").hide();

		$("#refer_consult").change(function() {
			if ($("#refer_consult").val() == 'y') {
				$("#referDiv").show();
			} else {
				$("#referDiv").hide();

			}
		});

	});
	
	
	
	
</script>


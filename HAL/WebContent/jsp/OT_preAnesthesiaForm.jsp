<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%> 
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/opd.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

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
	String icd="";
	 List opdSurgeryList = new ArrayList();
	 List opdPatientHistoryList= new ArrayList();	
	 List<PatientPrescriptionDetails> patientPrescriptionDetailList= new ArrayList<PatientPrescriptionDetails>();
	 List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	 Set<PatientInvestigationDetails> patientInvestigationdetails = null;
	 List<PatientInvestigationHeader>patientInvestigationHeaderListForFollowUp = new ArrayList<PatientInvestigationHeader>();
	if(map.get("opdSurgeryList") != null){
		opdSurgeryList=(List)map.get("opdSurgeryList");
	}
	if(map.get("icd")!=null){
		icd=(String)map.get("icd");
	}
	if (map.get("deptList") != null) {
		departmentList = (List<MasDepartment>) map.get("deptList");
 		
 	}
	if(map.get("opdPatientHistoryList") != null){
		opdPatientHistoryList=(List)map.get("opdPatientHistoryList");
	}
	if(map.get("patientPrescriptionDetailList") != null){
		patientPrescriptionDetailList=(List)map.get("patientPrescriptionDetailList");
	}
	
	List<OtPreAnesthesiaDetails> otPreADList = new ArrayList<OtPreAnesthesiaDetails>();
	
	if(map.get("OtPreAnesthesiaDetails") != null){
		otPreADList=(List)map.get("OtPreAnesthesiaDetails");
	}
	
	
	List<OtPreAnesthesiaDetail> procedureListForConsultation = new ArrayList<OtPreAnesthesiaDetail>();
	if(map.get("procedureListForConsultation") != null){
		procedureListForConsultation=(List<OtPreAnesthesiaDetail>)map.get("procedureListForConsultation");
	}
	
	PatientInvestigationHeader patientInvestigationHeader = null;
	if(patientInvestigationHeaderListForFollowUp.size()>0){
		patientInvestigationHeader = patientInvestigationHeaderListForFollowUp.get(0);
		patientInvestigationdetails = patientInvestigationHeader.getPatientInvestigationDetails();
	}
	
	OpdSurgeryHeader opdSurgeryHeader=(OpdSurgeryHeader)opdSurgeryList.get(0);
	
	String patientName="";
	if(opdSurgeryHeader.getHin().getPFirstName()!= null){
		patientName=opdSurgeryHeader.getHin().getPFirstName();
	}
	if(opdSurgeryHeader.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+opdSurgeryHeader.getHin().getPMiddleName();
	}
	if(opdSurgeryHeader.getHin().getPLastName()!= null){
		patientName=patientName+" "+opdSurgeryHeader.getHin().getPLastName();
	}
	String servicePersonName="";
	if(opdSurgeryHeader.getHin().getSFirstName()!= null){
		servicePersonName=opdSurgeryHeader.getHin().getSFirstName();
	}
	if(opdSurgeryHeader.getHin().getSMiddleName()!= null){
		servicePersonName=servicePersonName+" "+opdSurgeryHeader.getHin().getSMiddleName();
	}
	if(opdSurgeryHeader.getHin().getSLastName()!= null){
		servicePersonName=servicePersonName+" "+opdSurgeryHeader.getHin().getSLastName();
	}
	 String requisitionDateInString =HMSUtil.changeDateToddMMyyyy(opdSurgeryHeader.getRequisitionDate());
	int deptId=opdSurgeryHeader.getPrescribedDepartment().getId();
	String departmentName=opdSurgeryHeader.getPrescribedDepartment().getDepartmentName();
	List<MasAnesthesia> anesthesiaList= new ArrayList<MasAnesthesia>();
	if(map.get("anesthesiaList") != null){
		anesthesiaList=(List)map.get("anesthesiaList");
	}
/* 	List<BloodMasComponent>BloodMasComponentList=new ArrayList<BloodMasComponent>();
	if(map.get("BloodMasComponentList") != null){
		BloodMasComponentList=(List)map.get("BloodMasComponentList");
	} */
	List<MasEmployee>doctorList=new ArrayList<MasEmployee>();
	if(map.get("doctorList") != null){
		doctorList=(List)map.get("doctorList");
	}
	List<OpdPatientDetails>patientDetailsList=new ArrayList<OpdPatientDetails>();
	if(map.get("patientDetailsList") != null){
		patientDetailsList=(List)map.get("patientDetailsList");
	}
	String anesthesia="";
	if(map.get("anesthesia") != null){
		anesthesia=(String)map.get("anesthesia");
	}
	List<MasDepartment>wardDepartmentList=new ArrayList<MasDepartment>();
	if(map.get("wardDepartmentList")!=null){
		wardDepartmentList=(List<MasDepartment>)map.get("wardDepartmentList");
	}
	
	
	List<OtPreAnesthesiaHd>OtPreAnesthesiaDetailsList=new ArrayList<OtPreAnesthesiaHd>();
	if(map.get("OtPreAnesthesiaDetailsList")!=null){
		OtPreAnesthesiaDetailsList=(List<OtPreAnesthesiaHd>)map.get("OtPreAnesthesiaDetailsList");
	}
	
	
	List<DgOrderdt > orderDtList = new ArrayList<DgOrderdt>(); 
	if(map.get("orderDtList")!=null){
		orderDtList=(List<DgOrderdt>)map.get("orderDtList");
	}
	
	List<PreAnesthesiaConsultDoctorDt> consultList = new ArrayList<PreAnesthesiaConsultDoctorDt>();
	if(map.get("consultList")!=null){
		consultList=(List<PreAnesthesiaConsultDoctorDt>)map.get("consultList");
	}
	
	int otPreAnesthesiaDetailsId =0;
	if(map.get("otPreAnesthesiaDetailsId")!=null){
		otPreAnesthesiaDetailsId=(Integer)map.get("otPreAnesthesiaDetailsId");
	}
	
	List<PatientFamilyHistory> medicalHistoryTemplate = new ArrayList<PatientFamilyHistory>();
	if(map.get("medicalHistoryTemplate")!=null){
		medicalHistoryTemplate=(List<PatientFamilyHistory>)map.get("medicalHistoryTemplate");
	}	
	List<PatientMedicalHistory>  patientMedicalHistory = new ArrayList<PatientMedicalHistory>();
	if(map.get("PatientMedicalHistory") != null){
		patientMedicalHistory=(List)map.get("PatientMedicalHistory");
	}	
	List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
	if(map.get("dgSampleCollectionDetailsList") != null)
	{
		dgSampleCollectionDetailsList=(List<DgSampleCollectionDetails>)map.get("dgSampleCollectionDetailsList");
	}
	String height="";
	String weight="";
	String bmi="";
	String bmiStatus="";
	String bp="";
	String working_diagnosis =null;
		
	for(OpdPatientDetails OpdPatientDetails:patientDetailsList){
		if(OpdPatientDetails.getHeight()!=null)
		{
		height=OpdPatientDetails.getHeight();
		}
		if(OpdPatientDetails.getVweight()!=null)
		{
		weight=OpdPatientDetails.getVweight();
		}
		if(OpdPatientDetails.getBmi()!=null){
		bmi=""+OpdPatientDetails.getBmi();
		}
		if(OpdPatientDetails.getBp()!=null){
		bp=OpdPatientDetails.getBp();
		}
		if(OpdPatientDetails.getInitialDiagnosis()!=null){
			working_diagnosis=OpdPatientDetails.getInitialDiagnosis();
			}
		
		//bmiStatus=OpdPatientDetails.getBmiStatus();
	}
	List templateList= new ArrayList();
	if(map.get("templateList") != null){
	templateList=(List)map.get("templateList");
	}
	int hinId =0;
	String hinNo =null;
	if(opdSurgeryHeader!=null){
		hinId= opdSurgeryHeader.getHin().getId();
		hinNo =opdSurgeryHeader.getHin().getHinNo();
	}
	%>
	
	<script>
	var departmentArray = new Array();
	</script>
	<%
	int j=0;
	for (MasDepartment masDepartment : departmentList) {
    %>
    <script>
    departmentArray[<%=j%>]= new Array();
    departmentArray[<%=j%>][0] = "<%=masDepartment.getId()%>";
    departmentArray[<%=j%>][1]= "<%=masDepartment.getDepartmentName()%>";

                 
            </script>
<%    j++;}%>

 
	
<title>Pre-Anesthesia Assessment Form Entry</title>
<form name="preAnesthesia" method="post" action="">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}">
	<div class="titleBg">
		<h2>Pre-Anesthesia Assessment Form Entry</h2>
	</div>
		<div class="Block">
		<div class="paddingTop5"></div>
		<div class="clear"></div>
		<label>Surgery Requisition No.</label> <input type="text"
			readonly="readonly" value="<%=opdSurgeryHeader.getOrderNo() %>" />
		<label>Surgery Requisition Date</label> <input type="text"
			readonly="readonly"  value="<%=opdSurgeryHeader.getRequisitionDate()!=null?HMSUtil.convertDateToStringWithoutTime(opdSurgeryHeader.getRequisitionDate()):"" %>"/>
		<div class="clear"></div>
		<div class="paddingTop5"></div>
	</div>
	<!--Block One Starts-->
	<div class="Block">
		<h4>Patient Details</h4>
		<div class="clear"></div>
	<%-- 	<label>HIN</label>
		<%if(opdSurgeryHeader.getHin().getHinNo()!= null){ %>
		<input type="text" readonly="readonly" id="hinNoUHID"
			value="<%=opdSurgeryHeader.getHin().getHinNo() %>" />
		<%}else{ %>
		<input type="text" readonly="readonly" value="-" />
		<%} %> --%>
		<label>Employee No</label>
		<input type="hidden" name="surgerId" value="<%=opdSurgeryHeader.getId()%>"/>
		<%if(opdSurgeryHeader.getHin()!= null && opdSurgeryHeader.getHin().getEmployee()!= null){ %>
		<input type="text" readonly="readonly"
			value="<%=opdSurgeryHeader.getHin().getEmployee().getServiceNo()%>" /> <input
			name="inPatientId" id="inPatientId" type="hidden"
			value="<%=opdSurgeryHeader.getInpatient()!=null ?opdSurgeryHeader.getInpatient().getId() :"0"%>" />
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

		<%--  
<label >Req. Date </label> 
<%if(requisitionDateInString != null){ %> 
<input type="text" readonly="readonly" value="<%=requisitionDateInString %>"  />
<%}else{ %> 
<input type="text" readonly="readonly" value="-"  />
<%} %> 

 <label >Patient Type </label> 
<%if(opdSurgeryHeader.getPatientStatus()!= null){ %>
<input type="text" readonly="readonly" value="<%=opdSurgeryHeader.getPatientStatus() %>"  />
<%}else{ %>
<input type="text" readonly="readonly" value="-"  />
<%}
	  if(opdSurgeryHeader.getPatientStatus().equalsIgnoreCase("OutPatient")){
	%> <label >Visit No. </label> <%if(opdSurgeryHeader.getVisit()!= null){ %>
<label class="valueMedium"><%=opdSurgeryHeader.getVisit().getVisitNo() %></label>
 <%}else{ %> <label
	class="valueMedium">-</label> <%}
	  }else{	
	%>  --%>		<input name="visitId" id="visitId" type="hidden"
	value="<%=opdSurgeryHeader.getVisit().getId() %>" />
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
		<%if(opdSurgeryHeader.getHin().getAge()!= null){
			int patientAge =0;
			String sPatientAge="-";
			String age =null;
			    if(opdSurgeryHeader.getHin().getDateOfBirth() != null)
			    {
			        Date date_of_birth= opdSurgeryHeader.getHin().getDateOfBirth();        
			        patientAge = HMSUtil.calculateAgeInYears(date_of_birth);
			        if(patientAge == 1 )
			            sPatientAge = patientAge +" Year";
			        else if(patientAge == 0 )
			        {
			        	sPatientAge= HMSUtil.getAgeFromDOB(opdSurgeryHeader.getHin().getDateOfBirth());
			        }
			        else
			            sPatientAge = patientAge +" Years";
			    }	
			%>
		<input type="text" readonly="readonly" value="<%=sPatientAge%>" />
		<%} %>
		
		
		
		

		<label>Referring Doctor </label>
		<%String DoctorName="";
		   if(opdSurgeryHeader.getInpatient()!= null){ 
    %>
		<%if(opdSurgeryHeader.getInpatient().getDoctor()!= null){ 
	
	if(opdSurgeryHeader.getInpatient().getDoctor().getFirstName()!= null){
		DoctorName=opdSurgeryHeader.getInpatient().getDoctor().getFirstName();
	}
	if(opdSurgeryHeader.getInpatient().getDoctor().getMiddleName()!= null){
		DoctorName=DoctorName+" "+opdSurgeryHeader.getInpatient().getDoctor().getMiddleName();
	}
	if(opdSurgeryHeader.getInpatient().getDoctor().getLastName()!= null){
		DoctorName=DoctorName+" "+opdSurgeryHeader.getInpatient().getDoctor().getLastName();
	}
		}
%>
		<input type="text" readonly="readonly" value="<%=DoctorName%>" />
		<%}else{ %>
		<input type="text" readonly="readonly" value="-" />
		<%} %>
<div class="clear"></div>
		<label>Admitted By </label>
		<%
		   if(opdSurgeryHeader.getVisit()!= null){ 
    %>
		<%if(opdSurgeryHeader.getVisit().getDoctor()!= null){ 

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
		<%} %><div class="clear"></div>
		
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
<div class="paddingTop5"></div>
<div class="clear"></div>

  <div class="floatRight">
				<a href="#" onclick="getTodayAllPrescriptionPopup('<%=hinId%>','y','OT');">Current Medication</a>
				<a href="#" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&<%=HIN_ID%>=<%=hinId%>&backFlag=OPD')">Previous Visits </a>
				<a href="#" onclick="javascript:openPopupInvestigation(<%=hinId%>)">Previous Lab Investigations</a>
				<%
				 if(hinNo!=null && !hinNo.isEmpty() && hinNo.charAt(0)=='0')
					hinNo = hinNo.substring(1, hinNo.length()); %>
				<a href="#" onclick="javascript:openPopupRadioInvestigation('<%=hinNo%>')">Previous Radiology Investigations</a>	
			</div>

<%-- <input type="button" class="button" tabindex="3" name=""
 value="+" onclick="OPDHistoryPopup('<%=opdSurgeryHeader.getHin().getId()%>', '<%=opdSurgeryHeader.getInpatient()!=null?opdSurgeryHeader.getInpatient().getId():"0"%>', '<%=opdSurgeryHeader.getId()%>');" />
 <div class="popupTextDiv">Current OPD/IPD History</div> --%>
<div class="clear"></div>
<div class="paddingTop5"></div>
		<h4>Previous Anesthetics Details</h4>
		<textarea name="anestheticDetails" cols="0" rows="0"
			class="large" style="margin-left: 7px;" maxlength="150"><%=OtPreAnesthesiaDetailsList.size()>0?OtPreAnesthesiaDetailsList.get(0).getPreviousAnesthetics()!=null?OtPreAnesthesiaDetailsList.get(0).getPreviousAnesthetics():"":""%>
	</textarea>

		<input type="button" name="Submit" class="button" value="Allergy"
			onclick="javascript:openPopupWindow();" />
		<div class="clear"></div>	
		<%
		
if(medicalHistoryTemplate!=null && medicalHistoryTemplate.size()!=0)
{
%>
		<h4>Medical History</h4>
		<div class="clear"></div>
		<label>Disease </label> <label style="width:149px;">Status</label>
		<label style="width:149px; margin-left:10px;">Duration</label>
		<div class="clear"></div>
		<%
	 int mhcount = 0;
		boolean match = false;
	for(PatientFamilyHistory fh :medicalHistoryTemplate) 
	{
		mhcount++;
		match = false;
		
	%>
	<label><%=fh.getPatientPresentComplaintName()%></label> <input type="hidden" name="fhId<%=mhcount%>" value=<%=fh.getId() %>>
	<%	
	 // if(patientMedicalHistory.size()>0)
	 // {
		for(PatientMedicalHistory mh: patientMedicalHistory)
		{
		
			if(mh.getPatientFamilyHistory().getId() == fh.getId())
			{
				
			match = true;
				String selected ="";
			  
%>              
              <select name="mhStatus<%=mhcount%>">
<% 				
			  if(mh.getDiseaseStatus().equalsIgnoreCase("Yes"))	
			  {
				  selected ="selected";	  
	 %>        
		     <%} %><option>No</option>
		       <option <%=selected %>>Yes</option></select>
		   <input type="text" name="mhDuration<%=mhcount%>" style="width: 650px;" maxlength="100" value="<%=mh.getDuration()%>"><div class="clear"></div>
	<%		}
			else
			{
	 %>
		   <input type="hidden" name="fhId<%=mhcount%>" value=<%=fh.getId() %>>
		<%
			}
		}//mh loop
		
		if(!match)
		{
	%>
			

<select name="mhStatus<%=mhcount%>"><option>No</option><option>Yes</option></select>
		   <input type="text" name="mhDuration<%=mhcount%>" style="width: 478px;" maxlength="100"><div class="clear"></div>
	<%	}
		
	//}//
	//else
	//{
	%>
	  <%--  <select name="mhStatus<%=mhcount%>"><option>No</option><option>Yes</option></select>
		   <input type="text" name="mhDuration<%=mhcount%>" maxlength="25"><div class="clear"></div> --%>
	<%	
	//}
		
	}//fh loop
	 %>
	 <input type="hidden" name="mhcount" value="<%=mhcount%>">
	
	<%} %>
<div class="paddingTop15"></div>
</div>

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
		
			<%-- <label >Pulse</label> <input name="pulse" type="text" maxlength="25"  />
<label>Icetrus</label> <input name="icetrus" type="text" maxlength="25"  />
<label >Nourishment</label><input name="nourishment" type="text" maxlength="25"  />
<label>Pallor</label> <input name="pallor" type="text"	maxlength="25"  />

<label >Oedema</label> <input name="oedema" type="text" maxlength="25"  />
<label >BP</label> 
<%if(bp!=null && !bp.equals("")){ %>
<input name="bp" type="text" onblur="validateBpValue(this.value);" id="bp" value="<%=bp %>" maxlength="10" />
<%}else{ %>
<input name="bp" type="text" onblur="validateBpValue(this.value);" id="bp" maxlength="10" />
<%} %>
<div class="clear"></div> 
<label>Cyanosis</label> <input name="cyanosis" type="text" maxlength="25"  /> 
<label >Spine</label> <input name="spine" type="text" maxlength="25"  />

<label >Airway</label>
<input name="airway" type="text" maxlength="25"  /><div class="clear"></div> 
<label >Clubbing</label>
<input name="clubbing" type="text" maxlength="25"  />
<label>Thyroid</label> <input name="thyroid" type="text" maxlength="25"  />
<label >Venous Access </label> <input name="venous" type="text" maxlength="25"  />

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
<%if(OtPreAnesthesiaDetailsList.size() >0) 
{ 
	String selected ="";
	OtPreAnesthesiaHd otPA = OtPreAnesthesiaDetailsList.get(0);
%> <!-- if part to update --> 
	  			<%if(otPA.getPallor().equalsIgnoreCase("yes"))
				  {
					  selected ="selected";
				  }
				  else
					  selected="";
				  %>
				  
				  <h4>PAC Clearance</h4>
<label>Select Procedure</label> 
<%
if(otPA!=null){
	Set<OtPreAnesthesiaDetail> OtPreAnesthesiaDetailSet = new HashSet<OtPreAnesthesiaDetail>();
	//OtPreAnesthesiaDetailSet = ;
	//System.out.println("ger "+OtPreAnesthesiaDetailSet.size());
	String procedureName = "";
	 int count =0;
	for(OtPreAnesthesiaDetail pacd:procedureListForConsultation){
		
%>
<input checked="checked" onclick="return false;" type="checkbox" name="surgerydt" style="margin-right: 5px;" value="<%=pacd.getOpdSurgeryDetail().getId() %>"><div class="labRadiologyDivAuto" ><%=pacd.getOpdSurgeryDetail().getChargeCode().getChargeCodeName()%></div>
<%		
	
		if(count++>=1)
			procedureName = procedureName.concat(" | ");
		    procedureName =procedureName+ pacd.getOpdSurgeryDetail().getChargeCode().getChargeCodeName(); 
	}
 %>
<%-- <%=procedureName %> --%>
<%}
%>
<div class="clear"></div>
				  
		<div class="clear"></div>
		    <h4>Vitals</h4>
			<label class="auto">Weight</label> <input name="weight" tabindex="1" type="text" id="weight"  class="auto" class="auto" size="8" validate="weight,float,no" maxlength="6" value="<%=otPA.getWeight()!=null?otPA.getWeight():""%>"/><label class="unit" style="margin-right: 25px;">kg</label>
			<label class="auto">BP</label><input name="bp" id="bp" type="text" tabindex="1"	class="auto" class="auto" size="8" maxlength="10" value="<%=otPA.getBp()!=null?otPA.getBp():""%>"/><label class="unit" style="margin-right: 25px;">mmHg</label>
			<label class="auto">Pulse</label> <input name="pulse" tabindex="1" type="text" maxlength="5" class="auto" size="8"id="hr" value="<%=otPA.getPulse()!=null?otPA.getPulse():""%>"/><label class="unit" style="margin-right: 25px;">min</label>
			<label class="auto">RR</label> <input name="pr" tabindex="1" type="text" maxlength="5" id="pr" class="auto" size="8" value="<%=otPA.getPr()!=null?otPA.getPr():""%>" /><label class="unit">min</label>
	<div class="clear"></div>		  
				  
				  	<h4>General Examination</h4>
			<div class="clear"></div>
	            <label>Pallor</label><select name="pallor">
				  <option>No</option><option <%=selected %>>Yes</option></select> 
				  
				    <%if(otPA.getIcetrus().equalsIgnoreCase("yes"))
				  {
					  selected ="selected";
				  }
				  else
					  selected="";
				  %>
				<label>Icterus</label><select name="icterus"><option>No</option><option <%=selected %>>Yes</option></select>
				  <%if(otPA.getPallor().equalsIgnoreCase("yes"))
				  {
					  selected ="selected";
				  }
				  else
					  selected="";
				  %>
				<label>Cyanosis</label><select name="cyanosis"><option>No</option><option <%=selected %>>Yes</option></select>
				  <%if(otPA.getKoilonychia().equalsIgnoreCase("yes"))
				  {
					  selected ="selected";
				  }
				  else
					  selected="";
				  %>
				<label>Koilonychia</label><select name="koilonychia"><option>No</option><option <%=selected %>>Yes</option></select>
			
			  <%if(otPA.getOedema().equalsIgnoreCase("yes"))
				  {
					  selected ="selected";
				  }
				  else
					  selected="";
				  %>
				 <label>Oedema</label><select name="oedema"><option>No</option><option <%=selected %>>Yes</option></select>
				   <%if(otPA.getLymphadenopathy().equalsIgnoreCase("yes"))
				  {
					  selected ="selected";
				  }
				  else
					  selected="";
				  %>
			     <label>Lymphadenopathy</label><select name="lymphadenopathy"><option>No</option><option <%=selected %>>Yes</option></select>
		
<div class="clear"></div>
</div>

		<div class="Block">
			<h4>Airway</h4>
			<label>MPC</label><input type="text" name="mpc" value="<%=otPA.getMpc()%>" maxlength="500">
			<label>TMD</label><input type="text" name="tmd" value="<%=otPA.getTmd()%>" maxlength="500">
			<label>TMJ</label><input type="text" name="tmj" value="<%=otPA.getTmj()%>" maxlength="500">
			<div class="clear"></div>
			<label>MO</label><input type="text" name="mo" value="<%=otPA.getMo()%>" maxlength="500">
			<label>Teeth</label><input type="text" name="teeth" value="<%=otPA.getTeeth()%>" maxlength="500">
			<div class="clear"></div>
			<label>I.V. Access </label>
			<textarea name="venous" maxlength="500"><%=otPA.getVenousAccess()%></textarea>
			<label>Spine</label>
			<textarea name="spine" maxlength="500" ><%=otPA.getSpine()%></textarea>
			<label>Echo</label>
			<textarea name="eco" maxlength="100"><%=otPA.getEco()%></textarea>
			<label>ECG</label>
			<textarea name="ecg" maxlength="100"><%=otPA.getEcg()%></textarea>
			<label>Chest X-Ray</label>
			<textarea name="chestxray" maxlength="100"><%=otPA.getChestXray()%></textarea>   
		</div>
		<div class="Block">
			<div class="clear"></div>

			<label>CVS</label><input type="text" name="cvs" value="<%=otPA.getCvs()%>" maxlength="500">
			<label>RS</label><input type="text" name="rs" value="<%=otPA.getRs()%>" maxlength="500">
			<label>Abdomen</label><input type="text" name="abdomen" value="<%=otPA.getAbdomen()%>"
				maxlength="500">  <label>CNS</label><input type="text"
				name="cns" maxlength="500" value="<%=otPA.getCns()%>">

</div>
<div class="Block">
<h4>Investigation</h4>
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
				onclick="copyPrevInvestigationTempate('0','<%=opdSurgeryHeader.getHin().getId()%>');" />
		</div>
		<div id="investigationImportButton1">
			<input name="investigationImportButton1" tabindex="1" type="button"
				value="Import New" class="button"
				onclick="getListForTreatment('investigationDiv');" />
		</div>
		<label>Urgent</label> <input type="checkbox" name="urgent"
			tabindex="1" class="radioAuto" value="1" />
	</div>


<div class="cmntable">


		
		<%int inc=1;
		int dgOrderHdId=0;
			String investigationName = "";
			if(orderDtList != null && orderDtList.size() >0){
				dgOrderHdId = orderDtList.get(0).getOrderhd().getId();
			
			%>
		
				<input name="dgOrderHdId"
			type="hidden" value="<%=dgOrderHdId%>" />
			<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
	  	  <td colspan="6" >
	      	<div class="floatleft">
				<input type="radio" value="Lab" class="radioCheckCol2" style="margin-right:5px;"
					name="labradiologyCheck" checked="checked" onchange="" /><div class="labRadiologyDivfixed">LAB</div>			
				<input type="radio" value="Radio" class="radioCheckCol2" style="margin-right:5px;"
					name="labradiologyCheck" onchange="" /><div class="labRadiologyDivfixed">Radiology</div>
					 <input
					type="hidden" name="investigationCategory"
					id="investigationCategory" />
				<div class="clear"></div>
			</div>
			 </td>
	</tr>
			<tr>
		<th scope="col">Investigation </th>
		<!-- <th scope="col">Refer to MH</th> -->
		<th>Date</th>
		<th>Result</th>
		<th>Remarks</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>
			<%	
				String orderNo=orderDtList.get(0).getOrderhd().getOrderNo();
				for (DgOrderdt patientInvestigation : orderDtList) {
					
					String url="/hms/hms/lab?method=investigationResult&orderNo="+orderNo+"&chargeCodeId="+patientInvestigation.getChargeCode().getId();
					investigationName = patientInvestigation
							.getChargeCode().getChargeCodeName()
							+ "["
							+ patientInvestigation.getChargeCode().getId()
							+ "]";
					boolean sampleCollected = false;
					 
					if(!patientInvestigation.getOrderStatus().equalsIgnoreCase("p"))
					{
						sampleCollected = true;
					}
				
				%> 
		
				<tr>
				<td>	
				
				<input type="hidden" tabindex="1" id="dgOrderDtId<%=inc %>" name="dgOrderDtId<%=inc %>" value="<%=patientInvestigation.getId()%>"
					size="10" readonly /> 
				<input type="text" value="<%=investigationName %>" tabindex="1" 
					id="chargeCodeName<%=inc %>" size="100" name="chargeCodeName<%=inc %>"
					 readonly="readonly"/>
				<div id="ac2update2" style="display: none;" class="autocomplete">
				</div>
<%-- 				<script type="text/javascript" language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{minChars:2,
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName<%=inc %>'});
						  
						</script>  --%> <input
					type="hidden" tabindex="1" id="chargeCode<%=inc %>" name="chargeCode<%=inc %>"
					size="10" readonly /> 
					
					<!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

				</td>
				<td><input  type="text"  id="investigationDate<%=inc%>" name="investigationDate<%=inc%>" placeholder="DD/MM/YYYY" validate="LMP Date,string,no" value="<%=HMSUtil.convertDateToStringTypeDateOnly(patientInvestigation.getCreatedon())%>" maxlength="10" style="width: 120px" readonly="readonly"/></td>
				<td>  
				<%if(sampleCollected) {%>
				 <input type="button" accesskey="a" class="button" value="Result" onclick="javascript:popwindowresult('<%=url%>');" id="print" name="print">
				 <%} %>
				</td>
				<td><textarea
					 tabindex="1" id="investigationRemarks<%=inc %>" name="investigationRemarks<%=inc %>"
					maxlength="100"> <%=patientInvestigation.getOtRemarks()!=null?patientInvestigation.getOtRemarks():""%></textarea> </td>
				
		<%-- 		<%if(patientInvestigation.getReferToMh().equals("") && patientInvestigation.getReferToMh().equals("y") ){ %>
				<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio" checked="checked" validate="Refer to MH,string,no" /></td>
				<%}else{ %>
				<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td>
				<%} %> --%>
					<td><input name="Button" type="button" class="buttonAdd" value=""
					onclick="addRowForInvestigation('y');" /></td>
				<td>
				<%if(!sampleCollected) {%>
				  <input type="button" name="delete" value="" class="buttonDel" tabindex="1" onclick="removeRow('investigationGrid','hiddenValue',this);" />
					<%}
				else{%>
									
				
				 		
			<%
			boolean flag = false;
				for(DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsList){
				if(dgSampleCollectionDetails.getOrderdt().getId()==patientInvestigation.getId())
				{
					flag = false;
			if( dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("P")){
				if(dgSampleCollectionDetails.getRejected() != null &&
						dgSampleCollectionDetails.getRejected().equalsIgnoreCase("y") ){	 %>
				Sample is Rejected <span
					style="color: highlightred; font-weight: bold; font-style: i">(Reason
				: <% if(dgSampleCollectionDetails.getReason() != null){ %> <%=dgSampleCollectionDetails.getReason() %>
				<% } %> ) </span>
				<% }else{ %>
				Pending For Sample Validation
				<% } %>

				<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("E")){%>
				Result Entered
				<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("A")){%>
			Sample Pending For Result Entry
				<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("X")){%>
				Test Cancelled
				<%}}} %>
				</td>
				<%}%>
			  


			</tr>
			<%inc++;}
				%>
					<input type="hidden" value="<%=inc-1 %>" name="hiddenValue" id="hiddenValue" />
				<%}else{ %>
	<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
	  	  <td colspan="4" >
	      	<div class="floatleft">
				<input type="radio" value="Lab" class="radioCheckCol2" style="margin-right:5px;"
					name="labradiologyCheck" checked="checked" onchange="" /><div class="labRadiologyDivfixed">LAB</div>			
				<input type="radio" value="Radio" class="radioCheckCol2" style="margin-right:5px;"
					name="labradiologyCheck" onchange="" /><div class="labRadiologyDivfixed">Radiology</div>
					 <input
					type="hidden" name="investigationCategory"
					id="investigationCategory" />
				<div class="clear"></div>
			</div>
			 </td>
	</tr>
			<tr>
		<th scope="col">Investigation </th>
		<!-- <th scope="col">Refer to MH</th> -->
		<th>Date</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>
		<tr>
		<td>
		<input type="text" value="<%=investigationName %>" tabindex="1" 
			id="chargeCodeName<%=inc %>" size="100" name="chargeCodeName<%=inc %>"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete"></div>
		<%-- <script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>&labradiologyCheck='+ document.getElementById('investigationCategory').value});
				</script>  --%>
				
			   <script type="text/javascript"	language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName<%=inc %>'});
				</script> 
				
				
				<input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
		<%-- <td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td> --%>
		<td><input  type="text" class="calDate" onchange="checkForAlreadyPrescribedInvestigation(document.getElementById('chargeCodeName<%=inc %>').value,'<%=inc%>',document.getElementById('hinId').value);"  id="investigationDate<%=inc%>" name="investigationDate<%=inc%>" placeholder="DD/MM/YYYY" validate="LMP Date,string,no" value="<%=currentDate%>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'investigationDate<%=inc%>');" maxlength="10" style="width: 120px"/></td>
		<td><input name="Button" type="button" class="buttonAdd" value="" tabindex="1"
			onclick="addRowForInvestigation('n');" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" tabindex="1"
			onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>
	  </tr>
	
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
	
	<%} %>


</table>
</div>
</div>

<div class="Block">
				<h4>Others</h4>
				<label class="auto" style="padding: 0px 12px 0px 5px;">
					Anesthetic Technique Planed <span>*</span></label> <select style="width: 160px;"
					name="grade1" id="grade"
					onblur="stValueToAnaesthicPlanned(this.value);"
					validate=" Anesthetic Technique,string,yes">
					<option value="0">Select</option>
					<%for(MasAnesthesia masAnesthesia:anesthesiaList) {
					
					   if(masAnesthesia.getAnesthesiaName().equalsIgnoreCase(otPA.getAnashteicDetails()))	
					   {
					  %>
					<option value="<%=masAnesthesia.getAnesthesiaName()%>" selected><%=masAnesthesia.getAnesthesiaName()%></option>
					<%}
					   else
					   {
				   %>
				      <option value="<%=masAnesthesia.getAnesthesiaName()%>" ><%=masAnesthesia.getAnesthesiaName()%></option>
				   <%		   
					   }
					} 
					%>
				</select> <label>Additional Remarks</label>
				<textarea name="additional_remarks" maxlength="500"><%=otPA.getAddtionalRemarks()%></textarea>
				<div class="clear"></div>
				<div id="Block">
				    <h4>Refer</h4>
				    <div class="cmntable">
				     <table>
				      <tr><td colspan="6"><b>Previous Consultations</b></td></tr>
				      <%
				      if(consultList.size() >0)
				      {
				    	  %>
				      <tr><th>Department</th><th>Requested Doctor</th><th>Consultation Received By</th><th>Requested Date for consultation</th><th>Referral Notes</th><th>Advice</th></tr>
				        <%for(PreAnesthesiaConsultDoctorDt consultDt:consultList)
				        {
				        	String doctorName=null;
				        	String conReceivedBy=null;
				        	if(consultDt.getConsultedDoctor()!=null){
				        	if(consultDt.getConsultedDoctor().getFirstName() !=null)
				        		doctorName = consultDt.getConsultedDoctor().getFirstName();
				        	if(consultDt.getConsultedDoctor().getMiddleName() !=null)
				        		doctorName +=" "+ consultDt.getConsultedDoctor().getMiddleName();
				        	if(consultDt.getConsultedDoctor().getLastName() !=null)
				        		doctorName += " "+consultDt.getConsultedDoctor().getLastName();
				        	}
				        	
				        	if(consultDt.getConsultationRecBy()!=null){
					        	if(consultDt.getConsultationRecBy().getFirstName() !=null)
					        		conReceivedBy = consultDt.getConsultationRecBy().getFirstName();
					        	if(consultDt.getConsultationRecBy().getMiddleName() !=null)
					        		conReceivedBy += " "+consultDt.getConsultationRecBy().getMiddleName();
					        	if(consultDt.getConsultationRecBy().getLastName() !=null)
					        		conReceivedBy += " "+consultDt.getConsultationRecBy().getLastName();
					        	}
					        	
				        %>
				            <tr><td><%=consultDt.getConsultedDepartment()!=null?consultDt.getConsultedDepartment().getDepartmentName():"-"%></td><td><%=doctorName!=null?doctorName:"-"%></td><td><%=conReceivedBy!=null?conReceivedBy:""%></td><td><%= consultDt.getConsultDate()!=null? HMSUtil.convertDateToStringWithoutTime(consultDt.getConsultDate()):""%></td><td><%=consultDt.getReferralNotes()%></td><td><%= consultDt.getDoctorAdvice()!=null?consultDt.getDoctorAdvice():"Pending"%></td></tr>	
				        <%	
				        }
				      }
				      else
				      {
				      %>
				      <tr><td colspan="4"><b>No Consulation records found.</b></td></tr>
				      <%} %>
				     </table>
				     </div>
				    <div class="clear"></div>
				    <label>Refer for consultation</label><select id="refer_consult" onchange="onChangeRefer(this.value);"
					name="refer_consult"><option value='n'>No</option>
					<option value="y">Yes</option></select>


				<div id="referDiv">
				<div class="clear"></div>
				<table  id="referGrid">
				<tr><th>Referral Notes</th><th>Department</th><th>Doctor</th>	<th scope="col">Add</th>
		<th scope="col">Delete</th>
				<tr>
				 <td>
            <textarea maxlength="300" name="referral_notes1" id="referral_notes1" ></textarea>
				</td>
				<td>
					<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" validate="Department,number,no"> --%>
					<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" onchange="getDetails(this.value);" validate="Department,number,no" > --%>
					<select id="deptId1" name="refereddept1"
						onchange="fnGetDoctorDepartment(this.value,'refereddoctor1');">
						<option value="0">Select</option>
						<%
				deptId=(Integer)session.getAttribute("deptId");
				if(departmentList!= null){
				for (MasDepartment masDepartment : departmentList) {
			%>

						<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>

						<%}
				}
			%>
					</select> 
					</td>
					<td>
				<select id="refereddoctor1"
						name="refereddoctor1">
						<option value="0">Select</option>
					</select>
					</td>
					<td><input name="Button" type="button" class="buttonAdd" value="" tabindex="1"
			onclick="addRowForRefer();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" tabindex="1"
			onclick="removeRow('referGrid','hiddenValue',this);" /></td>
					</tr>
				  </table>
				  	<input type="hidden" value="1" name="hiddenValueRefer" id="hiddenValueRefer" />
				</div>
				</div>	
				<div class="clear"></div>
				<div class="clear"></div>
</div>
<%if(opdSurgeryHeader.getInpatient()!=null) {%>

<div class="Block" id="reviewPAE">
				<h4>Review PAE</h4>
				<label>Fresh Complaint</label><textarea name="review_complaints" maxlength="100"></textarea>
			<label>RR</label><input type="text" name="reviewqp"  maxlength="25"/>
			<label>BP</label><input type="text" name="reviewbp"  maxlength="25"/>
			<label>CVS</label><input type="text" name="reviewcvs"  maxlength="25"/>
			<label>RS</label><input type="text" name="reviewrs"  maxlength="25"/>
			
				<label>Fit for surgery <span>*</span></label> <select name="fitForSurgery"
					id="fitForSurgery1" >
					<option value="">-Select-</option>
					<option value="y">Yes</option>
					<option value="n">No</option>
				</select>
				<div id="fitForSurgery" style="display: none;">
					<label>Department <span>*</span></label> <select id="pendingDeptId"
						name="pendingDeptName"
						onchange="fnGetDoctorDepartment(this.value,'pendingDoctId');">
						<option value="0">Select</option>
						<%
				deptId=(Integer)session.getAttribute("deptId");
				if(departmentList!= null){
				for (MasDepartment masDepartment : departmentList) {
			%>

						<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>

						<%}
				}
			%>
					</select> <label>Doctor </label> <select id="pendingDoctId"
						name="pendingDocName">
						<option value="0">Select</option>
					</select>
					<div id="clear"></div>
					<div id="clear"></div>
				</div>
				<label>Others</label>
				<textarea name="summary" id="summaryId" class="textareaMediua" maxlength="50"></textarea>
				<label>ASA Risk</label>
				<textarea name="asaRisk" id="asaRisk" class="textareaMediua" maxlength="50"></textarea> 
					<label>Remarks</label>
					<textarea name="remarks" id="remarkspae" class="textareaMediua" maxlength="50"></textarea>
			</div>
			
			<%} %>
<div class="Block">
<%}  else {%>
<h4>Requested Procedure </h4>
<label>Select Procedure</label> 

<% 

if(opdSurgeryHeader.getOpdSurgeryDetails() != null )
{
	Set<OpdSurgeryDetail> opdSuregryDetailsSet = new HashSet<OpdSurgeryDetail>();
	opdSuregryDetailsSet = opdSurgeryHeader.getOpdSurgeryDetails();
	String procedureName = "";
	 int count =0;
	for(OpdSurgeryDetail osd:opdSuregryDetailsSet){
		if(osd.getAnestheisaPacStatus()!=null && !osd.getAnestheisaPacStatus().equalsIgnoreCase("y") && !osd.getAnestheisaPacStatus().equalsIgnoreCase("nc") )
		{
%>
<input type="checkbox" name="surgerydt" style="margin-right: 5px;" value="<%=osd.getId()%>"><div class="labRadiologyDivAuto" ><b><%=osd.getChargeCode().getChargeCodeName()%></b></div>
<%
		}
	}
		
	}		%>


<div class="clear"></div>
		    <h4>Vitals</h4>
			<label class="auto">Weight</label> <input name="weight" tabindex="1" type="text" id="weight"  class="auto" size="8" validate="weight,float,no" maxlength="6" /> <label class="unit" style="margin-right: 25px;">kg</label>
			<label class="auto">BP</label><input name="bp" id="bp" type="text" tabindex="1"	class="auto" class="auto" size="8" maxlength="10" /><label class="unit" style="margin-right: 25px;">mmHg</label>
			<label class="auto">Pulse</label> <input name="pulse" tabindex="1" type="text" maxlength="8"  class="auto" size="8" id="hr"/><label class="unit" style="margin-right: 25px;">min</label>
			<label class="auto">RR</label> <input name="pr" tabindex="1"   type="text" maxlength="8" class="auto" size="8" id="pr"/><label class="unit">min</label>
	<div class="clear"></div>
		
				  
				  	<h4>General Examination</h4>
			<div class="clear"></div>

			<label>Pallor</label> <select name="pallor"><option>No</option>
				<option>Yes</option></select> <label>Icterus</label><select name="icterus"><option>No</option>
				<option>Yes</option></select> <label>Cyanosis</label><select name="cyanosis"><option>No</option>
				<option>Yes</option></select> <label>Koilonychia</label><select
				name="koilonychia"><option>No</option>
				<option>Yes</option></select> <label>Oedema</label><select name="oedema"><option>No</option>
				<option>Yes</option></select> <label>Lymphadenopathy</label><select
				name="lymphadenopathy"><option>No</option>
				<option>Yes</option></select>
			<div class="clear"></div>
			<div class="clear"></div>
			
			<div class="clear"></div>
		</div>

		<div class="Block">
			<h4>Airway</h4>
			<label>MPC</label><input type="text" name="mpc" maxlength="500">
			<label>TMD</label><input type="text" name="tmd" maxlength="500">
			<label>TMJ</label><input type="text" name="tmj" maxlength="500">
			<div class="clear"></div>
			<label>MO</label><input type="text" name="mo" maxlength="500">
			<label>Teeth</label><input type="text" name="teeth" maxlength="500">
			<label>I.V. Access </label>
			<textarea name="venous" maxlength="500"></textarea>
			<div class="clear"></div>
			<label>Spine</label>
			<textarea name="spine" maxlength="500"></textarea>  
			<label>Echo</label>
			<textarea name="" maxlength="100"></textarea>
			<label>ECG</label>
			<textarea name="" maxlength="100"></textarea>
			<label>Chest X-Ray</label>
			<textarea name="" maxlength="100"></textarea>          
			<label>CVS</label><input type="text" name="cvs" maxlength="500">
			<label>RS</label><input type="text" name="rs" maxlength="500">
			<div class="clear"></div>
			<label>Abdomen</label><input type="text" name="abdomen"
				maxlength="500"> <label>CNS</label><input type="text"
				name="cns" maxlength="500">
		</div>
<h4>Investigation</h4>

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
				onclick="copyPrevInvestigationTempate('0','<%=opdSurgeryHeader.getHin().getId()%>');" />
		</div>
		<div id="investigationImportButton1">
			<input name="investigationImportButton1" tabindex="1" type="button"
				value="Import New" class="button"
				onclick="getListForTreatment('investigationDiv');" />
		</div>
		<label>Urgent</label> <input type="checkbox" name="urgent"
			tabindex="1" class="radioAuto" value="1" />
	</div>
<div class="Block">
<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
	  	  <td colspan="4" >
	      	<div class="floatleft">
				<input type="radio" value="Lab" class="radioCheckCol2" style="margin-right:5px;"
					name="labradiologyCheck" checked="checked" onchange="" /><div class="labRadiologyDivfixed">LAB</div>			
				<input type="radio" value="Radio" class="radioCheckCol2" style="margin-right:5px;"
					name="labradiologyCheck" onchange="" /><div class="labRadiologyDivfixed">Radiology</div>
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

		
		<%int inc=1;
			String investigationName = "";
		if(patientInvestigationdetails != null){
		for (PatientInvestigationDetails patientInvestigation : patientInvestigationdetails) {
			investigationName = patientInvestigation
					.getChargeCode().getChargeCodeName()
					+ "["
					+ patientInvestigation.getChargeCode().getId()
					+ "]";
		
		
		%> 
		<tr>
		<td>
		<input type="text" value="<%=investigationName %>" tabindex="1" 
			id="chargeCodeName<%=inc %>" size="100" name="chargeCodeName<%=inc %>"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{minChars:2,
					  callback: function(element, entry) {
				            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
				        },
					  parameters:'requiredField=chargeCodeName<%=inc %>'});
				  
				</script>  <input
			type="hidden" tabindex="1" id="chargeCode<%=inc %>" name="chargeCode<%=inc %>"
			size="10" readonly /> 
			 <input
			
			size="10" readonly />
			<!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
<%-- 		<%if(patientInvestigation.getReferToMh().equals("") && patientInvestigation.getReferToMh().equals("y") ){ %>
		<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio" checked="checked" validate="Refer to MH,string,no" /></td>
		<%}else{ %>
		<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td>
		<%} %> --%>
		<td><input  type="text" class="calDate" onchange="checkForAlreadyPrescribedInvestigation(document.getElementById('chargeCodeName<%=inc %>').value,'<%=inc%>',document.getElementById('hinId').value);"  id="investigationDate<%=inc%>" name="investigationDate<%=inc%>" placeholder="DD/MM/YYYY" validate="LMP Date,string,no" value="<%=currentDate%>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'investigationDate<%=inc%>');" maxlength="10" style="width: 120px"/></td>
		<td><input name="Button" type="button" class="button" value="Add"
			onclick="addRowForInvestigation('n');" /></td>
		<td><input type="button" name="delete" value="Delete" class="button" tabindex="1"
			onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


	</tr>
	<%inc++;}
		%>
			<input type="hidden" value="<%=inc-1 %>" name="hiddenValue" id="hiddenValue" />
		<%}else{ %>
	
		<tr>
		<td>
		<input type="text" value="<%=investigationName %>" tabindex="1" 
			id="chargeCodeName<%=inc %>" size="100" name="chargeCodeName<%=inc %>"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete"></div>
		<%-- <script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>&labradiologyCheck='+ document.getElementById('investigationCategory').value});
				</script>  --%>
				
			   <script type="text/javascript"	language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName<%=inc %>'});
				</script> 
				
				
				<input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
	
		<%-- <td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td> --%>
	<td><input  type="text" class="calDate" onchange="checkForAlreadyPrescribedInvestigation(document.getElementById('chargeCodeName<%=inc %>').value,'<%=inc%>',document.getElementById('hinId').value);"  id="investigationDate<%=inc%>" name="investigationDate<%=inc%>" placeholder="DD/MM/YYYY" validate="LMP Date,string,no" value="<%=currentDate%>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'investigationDate<%=inc%>');" maxlength="10" style="width: 120px"/></td>
		<td><input name="Button" type="button" class="buttonAdd" value="" tabindex="1"
			onclick="addRowForInvestigation('n');" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" tabindex="1"
			onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


	</tr>
	
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
	
	<%} %>
</table>
</div>
</div>

<div class="Block">
<h4>Others</h4>
<label class="auto">
					Anesthetic Technique Planed <span>*</span></label> <select style="width: 160px;"
					name="grade1" id="grade"
					onblur="stValueToAnaesthicPlanned(this.value);"
					validate=" Anesthetic Technique,string,yes">
					<option value="0">Select</option>
					<%for(MasAnesthesia masAnesthesia:anesthesiaList) {%>
					<option value="<%=masAnesthesia.getAnesthesiaName()%>"><%=masAnesthesia.getAnesthesiaName()%></option>
					<%} %>
				</select> <label class="auto">Additional Remarks</label>
				<textarea name="additional_remarks" maxlength="500"></textarea>
				   <div class="clear"></div>
				<label>Refer for consultation</label><select id="refer_consult" onchange="onChangeRefer(this.value);"
					name="refer_consult"><option value='n'>No</option>
					<option value="y">Yes</option></select>


				<div id="referDiv">
				<table  id="referGrid">
				<tr><th>Referral Notes<span>*</span></th><th>Department<span>*</span></th><th>Doctor</th>	<th scope="col">Add</th>	<th scope="col">Delete</th></tr>
						<tr><td>				
                 <textarea maxlength="300" name="referral_notes1" id="referral_notes1" ></textarea>
					</td>

					<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" validate="Department,number,no"> --%>
					<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" onchange="getDetails(this.value);" validate="Department,number,no" > --%>
					<td>
					<select id="deptId1" name="refereddept1"
						onchange="fnGetDoctorDepartment(this.value,'refereddoctor1');">
						<option value="0">Select</option>
						<%
				deptId=(Integer)session.getAttribute("deptId");
				if(departmentList!= null){
				for (MasDepartment masDepartment : departmentList) {
			%>

						<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>

						<%}
				}
			%>
					</select> </td><td> <select id="refereddoctor1"
						name="refereddoctor1">
						<option value="0">Select</option>
					</select></td>
					<td><input name="Button" type="button" class="buttonAdd" value="" tabindex="1"
			onclick="addRowForRefer();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" tabindex="1"
			onclick="removeRow('referGrid','hiddenValue',this);" /></td>
					</tr>
				  </table>
				  	<input type="hidden" value="1" name="hiddenValueRefer" id="hiddenValueRefer" />
				</div>
				<div class="clear"></div>
			</div>
			
			<%if(opdSurgeryHeader.getInpatient()!=null) {%>
              <div class="Block" id="reviewPAE">
				<h4>Review PAE</h4>
				<label>Fresh Complaint</label><textarea name="review_complaints" maxlength="100"></textarea>
			<label>QP</label><input type="text" name="reviewqp" maxlength="25"/>
			<label>BP</label><input type="text" name="reviewbp" maxlength="25"/>
			<div class="clear"></div>
			<label>CVS</label><input type="text" name="reviewcvs" maxlength="25"/>
			<label>RS</label><input type="text" name="reviewrs" maxlength="25"/>
			<label>Fit for surgery <span>*</span></label> <select name="fitForSurgery"
					id="fitForSurgery1">
					<option value="">-Select-</option>
					<option value="y">Yes</option>
					<option value="n">No</option>
				</select>
		<div class="clear"></div>
				<div id="fitForSurgery" style="display: none;">
					<label>Department <span>*</span></label> <select id="pendingDeptId"
						name="pendingDeptName"
						onchange="fnGetDoctorDepartment(this.value,'pendingDoctId');">
						<option value="0">Select</option>
						<%
				deptId=(Integer)session.getAttribute("deptId");
				if(departmentList!= null){
				for (MasDepartment masDepartment : departmentList) {
			%>

						<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>

						<%}
				}
			%>
					</select> <label>Doctor </label> <select id="pendingDoctId"
						name="pendingDocName">
						<option value="0">Select</option>
					</select>
					<div id="clear"></div>
					<div id="clear"></div>
				</div>
		<label>Others</label>
				<textarea name="summary"  class="textareaMediua" maxlength="50"></textarea>
				<label>ASA Risk</label>
				<textarea name="asaRisk" id="asaRisk" class="textareaMediua" maxlength="50"></textarea> 
					<label>Remarks</label>
					<textarea name="remarks" id="remarkspae" class="textareaMediua" maxlength="50"></textarea>
			</div>
<%} %>
<div class="Block">			
<div id="clear"></div>	
	<%} %>	<!-- end else part for new anesthesia-->	
			<input name="patientStatus" type="hidden"
				value="<%=opdSurgeryHeader.getPatientStatus() %>" /> 
					<input name="otPreAnesthesiaDetailsId" type="hidden"
				value="<%=otPreAnesthesiaDetailsId %>" /> 
				
				
				<input
				type="hidden" id="requestId"
				value="<%=opdSurgeryHeader.getHin().getId() %>" /> <input
				name="hinId" id="hinId" type="hidden"
				value="<%=hinId%>" /> <input
				name="hospitalId" type="hidden" value="<%=hospitalId %>" /> <input
				name="deptId" type="hidden" value="<%=deptId %>" /> <input
				name="orderNo" type="hidden"
				value="<%=opdSurgeryHeader.getOrderNo() %>" />
						<input name="surgeryDoctor" type="hidden"
						value="<%=opdSurgeryHeader.getEmployee().getId()%>" />
				 <input
				name="changedBy" type="hidden" value="<%=userName %>" /> <input
				name="changedDate" type="hidden" id="currentDate" value="<%=currentDate%>" /> <input
				name="changedTime" type="hidden" value="<%=currentTime %>" /> 
				<%   if(consultList.size() >0){ %>
				<input name="previousRefer" type="hidden" value="y" />
				<%} %> 
				
			  
				<div class="clear"></div>
				
		<%if(OtPreAnesthesiaDetailsList.size() >0) 
        { %>
				<input
				type="button" name="Submit" class="button" value="Update"
				<%-- onclick="if(checkGrade()){submitForm('preAnesthesia','ot?method=submitPreAnesthesiaDetails&pastHistory=<%=pastHistory%>&presentHistory=<%=presentHistory%>');}" /> --%>
		onclick="if(checkGrade()){submitForm('preAnesthesia','ot?method=updatePreAnesthesiaDetails');}" />
	     <%}
		else  {
		%>	
				<input
				type="button" name="Submit" class="button" value="Submit"
				<%-- onclick="if(checkGrade()){submitForm('preAnesthesia','ot?method=submitPreAnesthesiaDetails&pastHistory=<%=pastHistory%>&presentHistory=<%=presentHistory%>');}" /> --%>
		onclick="if(checkGrade()){submitForm('preAnesthesia','ot?method=submitPreAnesthesiaDetails');}" />
       <%} %>
			<input name="back" type="button" class="button" value="Back"
				onclick="submitForm ('preAnesthesia','ot?method=showPACClearanceList')" />
			
</div>
<div class="clear"></div>
	<div class="division"></div>
		<div class="clear"></div>
		<div class="bottom">
			<label>Changed By</label> <label class="value"><%=userName %></label>

			<label>Changed Date</label> <label class="value"><%=currentDate %></label>

			<label>Changed Time</label> <label class="value"><%=currentTime %></label>
			<div class="clear"></div>
		
		</div>

</table>
</div>
</div>
</form>
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
			
			var checkboxs=document.getElementsByName("surgerydt");
		    var okay=false;
		    for(var i=0,l=checkboxs.length;i<l;i++)
		    {
		        if(checkboxs[i].checked)
		        {
		            okay=true;
		            break;
		        }
		    }
		    if(!okay)
		    	{
		    	 alert("Please select atleast one surgery");
		    	 return false;
		    	}	
		
		var grade=document.getElementById('grade').value;
		var fit=null;
		if(document.getElementById('fitForSurgery1'))
			fit = document.getElementById('fitForSurgery1').value;
		var consult=document.getElementById('refer_consult').value;
		
		if (grade== ""){
		
			if(!displayAlert("Please Enter the Anesthtic Technique Planned."))
				alert("Please Enter the Anesthtic Technique Planned.");
			getShadow('grade');
		    return false;
		}
		
		if (consult=='n' && fit!=null && fit== ""){
			alert("Please select Fit for surgery");
	    return false;
	}
		
		if (consult=='n' && fit== "n" && document.getElementById('remarkspae').value ==""){
				alert("Please enter remarks");
		    return false;
		}
		
		if (consult=='y'){
		//	alert($('#refereddoctor').val());
		var totalRefer = document.getElementById('hiddenValueRefer').value;
		
		 for(var i=1; i<=totalRefer;i++)
			 {
			if(document.getElementById('referral_notes'+i)!=null && document.getElementById('referral_notes'+i).value=="")
				{
			       alert("Enter Referral Notes");
			       return false;
				}
			else if(document.getElementById('deptId'+i)!=null &&document.getElementById('deptId'+i).value==0)
				{
			       alert("Select referral department");
			       return false;
				}
			 }
			
		/* 	else if(document.getElementById('refereddoctor').value==0)
				{
			       alert("Select Doctor");
			       return false;
				} */
	   
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
/* 		function stValueToAnaesthicPlanned(val){
				val=val+" ";
				var valForAna=document.getElementById('anaesthicPlanned').value;
				val=valForAna+val+",";
				document.getElementById('anaesthicPlanned').value=val;
			     
				} */
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
<!-- <script>
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
</script> -->

<script type="text/javascript">
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

	function addRowForInvestigation(prevInvestigation) {
       
		var tbl = document.getElementById('investigationGrid');
		var lastRow = tbl.rows.length;

		// if there's no header row in the table, then iteration = lastRow + 1
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('hiddenValue');
		var iteration = parseInt(hdb.value) + 1;
		hdb.value = iteration
		// alert("iteration row--"+iteration)
        var colPosition = 0;
	
		var cellRight0 = row.insertCell(colPosition);
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

		  colPosition = colPosition+1;
		 var cellRight2 = row.insertCell(colPosition);
		  var e3 = document.createElement('input');
		  e3.type = "text";
		  e3.name='investigationDate'+iteration;
		  e3.placeholder="DD/MM/YYYY";
		  e3.value=document.getElementById("currentDate").value;;
		  e3.className='calDate';
		  e3.id='investigationDate'+iteration;
			 e3.setAttribute("onblur", "validateExpDate(this,'investigationDate"+iteration+"')");
			 e3.setAttribute("onkeyup", "mask(this.value,this,'2,5','/')");
			  e3.onchange=function(){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration);
					checkForAlreadyPrescribedInvestigation(this.value,iteration,visitId);
				  };
			 
			 cellRight2.appendChild(e3);

		  if(prevInvestigation=='y')
			{
			  
			  colPosition = colPosition+1;
				var cellRight4 = row.insertCell(colPosition);
				var e0 = document.createElement('input');
				e0.type = 'hidden';
				// e0.innerHTML = iteration+':'
				e0.name = 'investigationRemarks' + iteration;
				e0.id = 'investigationRemarks' + iteration;
				e0.setAttribute('tabindex', '1');
				//alert("name--"+e0.name)
				e0.size = '50'
				cellRight4.appendChild(e0);
			
			colPosition = colPosition+1;
			var cellRight5 = row.insertCell(colPosition);
			e0 = document.createElement('input');
			e0.type = 'hidden';
			// e0.innerHTML = iteration+':'
			e0.name = 'investigationRemarks' + iteration;
			e0.id = 'investigationRemarks' + iteration;
			e0.setAttribute('tabindex', '1');
			//alert("name--"+e0.name)
			e0.size = '50'
			cellRight5.appendChild(e0);
		
			} 
		 
		 colPosition = colPosition+1;
		var cellRight2 = row.insertCell(colPosition);
		var e4 = document.createElement('input');
		e4.type = 'button';
		e4.className = 'buttonAdd';
		e4.name = 'Button';
		
		e4.setAttribute('tabindex', '1');
		//e4.setAttribute('onClick','addRowForInvestigation();');
		e4.onclick = function() {
			addRowForInvestigation(prevInvestigation);
		};
		cellRight2.appendChild(e4);

		colPosition = colPosition+1;
		var cellRight3 = row.insertCell(colPosition);
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

	function OPDHistoryPopup(hinId,inpatientId,opdsurgeryid)
	{
	//var url='/hms/hms/opd?method=showPopUpPresentComplaint&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
		 var url='/hms/hms/ot?method=openPopupWindowForOPDHistory&hinId='+hinId+"&inpatientId="+inpatientId+"&opdSurgeryId="+opdsurgeryid;;
	 //popwindow(url);
	 window.open(url,'name',"left=170,top=50,height=600,width=850,status=1,scrollbars=1,resizable=0");
	} 
	 
	 function IPDHistoryPopup(tempCode)
		{
		//var url='/hms/hms/opd?method=showPopUpPresentComplaint&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
			 var url='/hms/hms/ot?method=showPopUpHistoryTemplate&tempCode='+tempCode;
		// popwindow(url);
		window.open(url,'name',"left=170,top=50,height=600,width=850,status=1,scrollbars=1,resizable=0");
		} 
	 
	 function onChangeRefer(val)
	 {
	 // alert(val+"dd");	 
	  if(val=='y')
		  {
			document.getElementById('referDiv').style.display = 'block';
			document.getElementById('reviewPAE').style.display = 'none';
			//alert("yes "+val);
		  }
	  else
		  {
			document.getElementById('referDiv').style.display = 'none';
			document.getElementById('reviewPAE').style.display = 'block';
			//alert("no "+val);
		  }
	 }
	 
	 
		function addRowForRefer() {
			
		
			var tbl = document.getElementById('referGrid');
			var lastRow = tbl.rows.length;
			var iteration = lastRow;
			var row = tbl.insertRow(lastRow);
			var hdb = document.getElementById('hiddenValueRefer');
			var iteration = parseInt(hdb.value) + 1;
			hdb.value = iteration;
	        var colPosition = 0;
		
		
			var cellRight0 = row.insertCell(colPosition);
			var e0 = document.createElement('textarea');
			  e0.setAttribute('maxlength', 300);
			  e0.name='referral_notes'+iteration;
			  e0.id='referral_notes'+iteration;
			cellRight0.appendChild(e0);
		
			 
			
			   colPosition = colPosition+1;
			  var cellRight1 = row.insertCell(colPosition);
			  var e2 = document.createElement('Select');
			  e2.name='refereddept'+iteration;
			  e2.id='deptId'+iteration;
			  //e2.class = 'medium';
			 // e2.setAttribute('tabindex','1');
			  e2.options[0] = new Option('Select', '0');
			 e2.onblur=function(){fnGetDoctorDepartment(this.value,'refereddoctor'+iteration);};
			   for(var i = 0;i<departmentArray.length;i++ ){
			      e2.options[i+1] = new Option(departmentArray[i][1],departmentArray[i][0]);
			      }
			  cellRight1.appendChild(e2);

			   colPosition = colPosition+1;
				  var cellRight2 = row.insertCell(colPosition);
				  var e3 = document.createElement('Select');
				  e3.name='refereddoctor'+iteration;
				  e3.id='refereddoctor'+iteration;
				  e3.setAttribute('tabindex','1');
				  e3.options[0] = new Option('Select', '0');
				
				  cellRight2.appendChild(e3);
			 
			 colPosition = colPosition+1;
			var cellRight3 = row.insertCell(colPosition);
			var e4 = document.createElement('input');
			e4.type = 'button';
			e4.className = 'buttonAdd';
			e4.name = 'Button';
			e4.value = '';
			
			e4.setAttribute('tabindex', '1');
			e4.onclick = function() {
				addRowForRefer();
			};
			cellRight3.appendChild(e4);

			colPosition = colPosition+1;
			var cellRight4 = row.insertCell(colPosition);
			var e5 = document.createElement('input');
			e5.type = 'button';
			e5.className = 'buttonDel';
			e5.value = '';
			e5.setAttribute('tabindex', '1');
			e5.onclick = function() {
				removeRow("referGrid", "hdb", this);
			};
			cellRight4.appendChild(e5);

		}
		  function showCreateInvestigationTemplate(){
			     document.getElementById("investigationImportButton1").style.display='inline'
			   	var url="/hms/hms/opd?method=showCreateInvestigationTemplate";
			    newwindow=window.open(url,'investigation',"height=500,width=1010,status=1,top=0,left=2");
		  }

		  function getListForTreatment(val){
			 	if(val=='investigationDiv'){
					submitProtoAjaxWithDivName('preAnesthesia','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
				}else if(val=='treatmentDiv'){
					submitProtoAjaxWithDivName('preAnesthesia','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
				}
//				document.getElementById('prescriptionImportButton').style.display = 'none';
//				document.getElementById("investigationImportButton").style.display='none'
			 }
/*jQuery(function($) {

		$("#referDiv").hide();

		$("#refer_consult").change(function() {
			if ($("#refer_consult").val() == 'y') {
				$("#referDiv").show();
				$("#reviewPAE").hide();
			} else {
				$("#referDiv").hide();
				$("#reviewPAE").show();

			}
		});

	});*/
	
	
</script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript">

var $j = jQuery.noConflict();
</script>


<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * nursingCareEntryDetail.jsp  
 * Purpose of the JSP -  This is for Nursing Care Entry Setup.
 * @author  Vikas
 * @author  Deepali
 * Create Date: 20th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.ReferralPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.ReferralPatientBilling"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.PatientDietIndoorDetail"%>
<%@page import="jkt.hms.masters.business.Ipdcaredetail"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>

<%@page import="jkt.hms.masters.business.AllergyDetail"%>

<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%><script
	type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<script type="text/javascript">
	vBulletin_init();
</script>

<%	List<PatientDietIndoorDetail> patientDietIndoorDetailList = new ArrayList<PatientDietIndoorDetail>();
List<ReferralPatientBilling> referralPatientBillingList = new ArrayList<ReferralPatientBilling>();
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	String deptName="";
	if(map.get("referralPatientBillingList")!=null){
		referralPatientBillingList = (List<ReferralPatientBilling>)map.get("referralPatientBillingList");
	}
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	String caretime=(String)map.get("caretime");
	
	OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
	if (map.get("opdPatientDetails") != null) {
		opdPatientDetails = (OpdPatientDetails) map.get("opdPatientDetails");
	}
	
	List<ReferralPatientDetails> referralPatientDetailsList = new ArrayList<ReferralPatientDetails>();
	
	if(map.get("referralPatientDetailsList")!=null){
		referralPatientDetailsList = (List<ReferralPatientDetails>)map.get("referralPatientDetailsList");
	}
	
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	 
	Patient patient = new Patient();	
	String patientName ="";
	String consultantName = "";
	String age = "";
	String currentAge = "";
	String referredFrom = "";
	int hinId = 0;
	int visitId = 0;
	int opdPatientDetailsId = 0;
	int adNo=0;
	String hinNo="";
	String serviceNo = "";
	int inpatientId = 0;

	if(opdPatientDetails.getVisit()!= null)
	{
		patient = opdPatientDetails.getVisit().getHin();
		referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
		visitId = opdPatientDetails.getVisit().getId();
		
	}
	else
	{
		patient = opdPatientDetails.getInpatient().getHin();
		referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
		adNo = opdPatientDetails.getInpatient().getId();
		visitId = opdPatientDetails.getInpatient().getVisit().getId();
		inpatientId = opdPatientDetails.getInpatient().getId();
	}
		
	hinId = patient.getId();
	hinNo = patient.getHinNo();
	serviceNo = patient.getServiceNo();
	opdPatientDetailsId= opdPatientDetails.getId();
		if(patient.getPFirstName() != null)
		   {
	       patientName=patient.getPFirstName()+" ";
		   }
		if(patient.getPMiddleName() != null)
			   {
			   patientName +=patient.getPMiddleName()+" " ;
			   }
		if(patient.getPLastName() != null)
			   {
			   patientName +=patient.getPLastName();
			   }
		if(opdPatientDetails.getEmployee() !=null){
			/* consultantName=inpatient.getDoctor().getRank().getRankName(); */
			if(opdPatientDetails.getEmployee().getFirstName() != null)
			{
				consultantName+=" "+opdPatientDetails.getEmployee().getFirstName();	
			}
			if(opdPatientDetails.getEmployee().getMiddleName() != null)
			{
				consultantName+= " "+opdPatientDetails.getEmployee().getMiddleName();
			}
			if(opdPatientDetails.getEmployee().getLastName() != null)
			{
				consultantName+=" "+opdPatientDetails.getEmployee().getLastName();
			}
		}
		
	    if(patient.getAge()!=null)
			age = patient.getAge();
		try{
			if(!age.equals(""))
			currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	
	
	
%>
<h4>Patient Details</h4>
<div class="Clear"></div>
<form name="generateReferralLetterPage" method="post">
	<div class="Block">

		<label>Employee No.</label> <label class="value"> <%=patient.getServiceNo()!=null?patient.getServiceNo():"" %></label>





		<label>Patient Name</label> <label class="value"> <%= patientName %></label>
		<input type="hidden" name="opdPatientDetailsId"
			id="opdPatientDetailsId" value="<%=opdPatientDetailsId%>" /> <input
			type="hidden" name="hinId" id="hinId" value="<%=hinId%>" /> <label>Relation</label>
		<%
	if(patient.getRelation() != null){
	%>
		<label class="value"><%= patient.getRelation().getRelationName()%></label>
		<%} else{ %>
		<label class="value">-</label>
		<% }%>
		<div class="Clear"></div>
		<label>Designation</label> <label class="value"><%=(patient.getEmployee().getRank()!=null?patient.getEmployee().getRank().getRankName():"")%></label>

		<label>Name</label>
		<%
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

		<label>Age</label>
		<%if(!currentAge.equals("")){ %>
		<label class="value"> <%=currentAge %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<div class="Clear"></div>
		<label>Gender</label>
		<%if(patient.getSex() != null){ %>
		<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<div class="Clear"></div>
	</div>

	<%-- <h4>Referral Details</h4>
<div class="Clear"></div>
<div class="Block">


<label>Doctor Name</label>
<label class="value"><%=consultantName %></label>

<label>Referred From </label> <%if(referredFrom != null){ %>
<label class="value"> <%=referredFrom %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<label>Empanelled Hospital </label> <%if(referredFrom != null){ %>
<label class="value"> <%=opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<label>Treatment Type </label> <%if(opdPatientDetails.getReferralTreatmentType().equals("1")){ %>
<label class="value"> OPD</label>
<%}else{ %>
<label class="value"> Admission</label>
<%} %>



<label> Diagnosis</label> 
	<%
	List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
	List<ReferralPatientDetails> referralPatientDetailsList = new ArrayList<ReferralPatientDetails>();
	String subject = "";
	String note = "";
	int validity_period = 0;
	int referralPatientDetailsId = 0;
	int referralPatientHeaderId = 0;
	int total_bill = 0;
	int approved_bill = 0;
	String admin_remarks= "";
	String hr_remarks= "";
	String flag= "";
	String referralTreatmentType = "";
	if(map.get("diagnosisList")!=null){
		diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
		
	}
	if(map.get("referralPatientDetailsList")!=null){
		referralPatientDetailsList = (List<ReferralPatientDetails>)map.get("referralPatientDetailsList");
		subject = referralPatientDetailsList.get(0).getSubject();
		note = referralPatientDetailsList.get(0).getReferralNote();
		validity_period = referralPatientDetailsList.get(0).getLetterValidityPeriod();
		referralPatientDetailsId = referralPatientDetailsList.get(0).getId();
		referralPatientHeaderId = referralPatientDetailsList.get(0).getReferralPatientHeader().getId();
		
		if(referralPatientDetailsList.get(0).getReferralPatientHeader().getEmployeeDependent()!=null)
		{
			flag="dependent";
		}
		else
		{
			flag="employee";
		}
		
		referralTreatmentType = referralPatientDetailsList.get(0).getReferralPatientHeader().getOpdPatientDetails().getReferralTreatmentType();
	}
	if(diagnosisList != null && diagnosisList.size() > 0 && diagnosisList.get(0).getIcd()!=null)
	{
	%> <label class="valueFixedWidth"><%=diagnosisList.get(0).getIcd().getIcdName()%></label>
	<%
		}else{
		%> <label class="value"></label> <%	
		}
		%> 
		
<div class="Clear"></div>

<label > Note:<span>*</span></label><input type="text" class = "large"  validate="Note,String,no" maxlength="500" value="<%=note %>" name ="referral_note" id ="referral_note" readOnly = "true"/>

<div class="Clear"></div>
<label> This letter is valid for <span>*</span></label><input type="text" value="<%=validity_period %>" class = "small" name ="validity_period" id="validity_period" validate="Validity Period,int,no" maxlength="5" readOnly = "true"/>Days
<div class="Clear"></div>
<label> Subject:<span>*</span></label><input type="text"  class="large" value="<%=subject %>" name ="subject" id ="subject" validate="Subject,String,no" maxlength="250" readOnly = "true"/>
<input type = "hidden" value = "<%=referralPatientDetailsId %>" name = "referralPatientDetailsId" id="referralPatientDetailsId"/>
<input type = "text" value = "<%=referralPatientHeaderId%>" name = "referralPatientHeaderId" id="referralPatientHeaderId"/>
</div> --%>


	<h4>Referral Details</h4>
	<div class="Clear"></div>
	<div class="Block">


		

		
		<%
	
	
	String subject = "";
	String note = "";
	int validity_period = 0;
	int referralPatientDetailsId = 0;
	int referralPatientHeaderId = 0;
	int total_bill = 0;
	int approved_bill = 0;
	int extentionCnt = 0;
	String admin_remarks= "";
	String hr_remarks= "";
	String finance_remarks= "";
	String flag= "";
	String referralTreatmentType = "";

	
	


	List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
	
	if(map.get("diagnosisList")!=null){
		diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
		
	}%>

<label>Working Diagnosis</label> 

	<label class="value"><%=diagnosisList.get(0)!=null?diagnosisList.get(0).getOpdPatientDetails().getInitialDiagnosis():""%></label>	
	
<label>ICD Diagnosis</label> 
	<%
	String icdDiagnosis = "";
	for(DischargeIcdCode dic :diagnosisList)
	{
		icdDiagnosis =  icdDiagnosis + dic.getIcd().getIcdName()+",<br>";
	}
	
	%>
	<label class="value"><%=icdDiagnosis.substring(0, (icdDiagnosis.length()-5))%></label>
	
	
	

		<label>Referred From </label>
		<%if(referredFrom != null){ %>
		<label class="value"> <%=referredFrom %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label>Empanelled Hospital </label>
		<%if(referredFrom != null){ %>
		<label class="value"> <%=opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} 





	
	
	for(ReferralPatientDetails referralPatientDetails: referralPatientDetailsList)
	{
		
		subject = (referralPatientDetails.getSubject()!=null?referralPatientDetails.getSubject():"");
		note = (referralPatientDetails.getReferralNote()!=null?referralPatientDetails.getReferralNote():"");
		validity_period =(referralPatientDetails.getLetterValidityPeriod()!=null?referralPatientDetails.getLetterValidityPeriod():0);
		referralPatientDetailsId = referralPatientDetails.getId();
		referralPatientHeaderId = referralPatientDetails.getReferralPatientHeader().getId();
		System.out.println("referralPatientDetailsList"+referralPatientDetailsList.size());
		
		if(referralPatientDetails.getReferralPatientHeader().getEmployeeDependent()!=null)
		{
			flag="dependent";
		}
		else
		{
			flag="employee";
		}
		
		 referralTreatmentType = referralPatientDetails.getTreatmentType();
		 if(extentionCnt!=0)
		 {
			 %>
		<h4>
			Extension - :
			<%=extentionCnt%></h4>
		<div class="Clear"></div>
		<h4>
			Extension No :
			<%=referralPatientDetails.getReferralNo()!=null?referralPatientDetails.getReferralNo():""%></h4>
		<label>Extension Date</label>
		<%
			 
		 }
		 else
		 {
			 %>

		<div class="Clear"></div>
		<h4>
			Referral No :
			<%=referralPatientDetails.getReferralNo()%></h4>
		<label>Referral Date</label>
		<%
			 
		 }
		 %>

		<label class="value"><%=referralPatientDetails.getReferralExtensionDate()!=null?HMSUtil.convertDateToStringTypeDateOnly(referralPatientDetails.getReferralExtensionDate()):""%></label>
		<label>Referred For</label> <label class="value"><%=referralPatientDetails.getReferredFor()!=null?referralPatientDetails.getReferredFor():""%></label>
		<label>Treatment Type </label>
		<%
		 if(referralPatientDetails.getTreatmentType()==null)
		 {
			 %>
		<label class="value"> </label>
		<%
		 }
		 else if(referralPatientDetails.getTreatmentType().equals("1")){ %>
		<label class="value"> OPD</label>
		<%}else{ %>
		<label class="value"> Admission</label>
		 
		<%}if(false){ %>
	
		<label> Note:<span>*</span></label><input type="text" class="large"
			validate="Note,String,yes" maxlength="500"
			value="OPD/CONSULTATION(INCLUDING PHARMACECUTICALS FOR <%=referralPatientDetails.getNoOfDays()!=null?referralPatientDetails.getNoOfDays():""%> DAYS)"
			name="referral_note" id="referral_note" />
		<%if(referralPatientDetails.getTreatmentType().equals("2")){%>
		<label style="margin-left: 42px;"> Ward:</label> <label class="value">
			<%=referralPatientDetails.getWard()!=null?referralPatientDetails.getWard().getWardName():""%></label>

		<%}%>
		<div class="Clear"></div>
		   <% consultantName ="";	
		 if(referralPatientDetails.getDoctor() !=null){
			/* consultantName=inpatient.getDoctor().getRank().getRankName(); */
			if(referralPatientDetails.getDoctor().getFirstName() != null)
			{
				consultantName+=" "+referralPatientDetails.getDoctor().getFirstName();	
			}
			if(referralPatientDetails.getDoctor().getMiddleName() != null)
			{
				consultantName+= " "+referralPatientDetails.getDoctor().getMiddleName();
			}
			if(referralPatientDetails.getDoctor().getLastName() != null)
			{
				consultantName+=" "+referralPatientDetails.getDoctor().getLastName();
			}
		}
		 %>
		 
		 <label>Doctor Name</label>
         <label class="value"><%=consultantName %></label>
         
		<label> This letter is valid for <span>*</span></label><input
			type="text" value="" class="small" name="validity_period"
			id="validity_period" validate="Validity Period,int,yes" maxlength="5" />Days
		<div class="Clear"></div>
		<label> Subject:<span>*</span></label><input type="text" class="large"
			value="" name="subject" id="subject" validate="Subject,String,yes"
			maxlength="250" />
		<%}else{ %>
           <div class="Clear"></div>
        <label>Doctor Note</label>
         <textarea class = "large" readonly="readonly"><%=(referralPatientDetails.getDoctorRemarks()!=null?referralPatientDetails.getDoctorRemarks():" ")%></textarea>
         
		 <div class="Clear"></div>
		<label> Note:</label><input type="text" class="large"
			validate="Note,String,no" maxlength="500" value="<%=note %>"
			readOnly="true" />
		<%if(referralPatientDetails.getTreatmentType().equals("2")){%>
		<label style="margin-left: 42px;"> Ward:</label> <label class="value">
			<%=referralPatientDetails.getWard()!=null?referralPatientDetails.getWard().getWardName():""%></label>

		<%}%>
		<div class="Clear"></div>
		   <% consultantName ="";	
		 if(referralPatientDetails.getDoctor() !=null){
			/* consultantName=inpatient.getDoctor().getRank().getRankName(); */
			if(referralPatientDetails.getDoctor().getFirstName() != null)
			{
				consultantName+=" "+referralPatientDetails.getDoctor().getFirstName();	
			}
			if(referralPatientDetails.getDoctor().getMiddleName() != null)
			{
				consultantName+= " "+referralPatientDetails.getDoctor().getMiddleName();
			}
			if(referralPatientDetails.getDoctor().getLastName() != null)
			{
				consultantName+=" "+referralPatientDetails.getDoctor().getLastName();
			}
		}
		 %>
		 
		 <label>Doctor Name</label>
         <label class="value"><%=consultantName %></label>
         
		<label> This letter is valid for </label><input type="text"
			value="<%=validity_period %>" class="small"
			validate="Validity Period,int,no" maxlength="5" readOnly="true" />Days
		<div class="Clear"></div>
		<label> Subject:</label><input type="text" class="large"
			value="<%=subject %>" validate="Subject,String,no" maxlength="250"
			readOnly="true" /> <input type="button" class="button"
			value="Referral Note "
			onClick="submitFormForButton('generateReferralLetterPage','referral?method=showInvoiceReport&referralPatientDetailsId=<%=referralPatientDetailsId%>&flag=<%=flag%>&referralTreatmentType=<%=referralTreatmentType%>');"
			align="left" onClick="" />

		<%}
		 ++extentionCnt;
	}
	%>







		<input type="hidden" value="<%=referralPatientDetailsId %>"
			name="referralPatientDetailsId" id="referralPatientDetailsId" /> <input
			type="hidden" value="<%=referralPatientHeaderId %>"
			name="referralPatientHeaderId" id="referralPatientHeaderId" />
	</div>

	<%-- <h4>Treatment Details</h4>
<div class="Clear"></div>
<div class="Block">




<label>Total Bill Amount<span>*</span></label><input type="text" validate="Empanelled Bill,int,no" maxlength="15" name ="impanelled_bill" id ="impanelled_bill" value="<%=total_bill%>" readOnly="true"/>


<label>Approved Bill Amount<span>*</span></label><input type="text" validate="HAL Bill,int,yes" maxlength="15" name ="hal_bill" id ="hal_bill" value="<%=approved_bill%>" readOnly="true"/>
<div class="Clear"></div>
<label>Admin Remarks</label><textarea validate="Remarks,string,no" maxlength="500" name ="admin_remarks" id ="admin_remarks" readOnly="true"/><%=admin_remarks%></textarea>
<label>HR Remarks</label><textarea validate="Remarks,string,no" maxlength="500" name ="admin_remarks" id ="admin_remarks" readOnly="true"/><%=hr_remarks%></textarea>
<div class="Clear"></div>
<label>Remarks</label><textarea validate="Remarks,string,no" maxlength="500" name ="finance_remarks" id ="finance_remarks" /></textarea>
<div class="Clear"></div>

<input type="button" class="button" value="Referral Note " onClick="submitFormForButton('generateReferralLetterPage','referral?method=showInvoiceReport&referralPatientDetailsId=<%=referralPatientDetailsId%>&flag=<%=flag%>&referralTreatmentType=<%=referralTreatmentType%>');" align="left"
	onClick="" />

    <%if(opdPatientDetails.getInpatient()!=null)
    	{
    	%>
	<input type="button" class="button" value="OPD Case Sheet " align="left"
    			onclick = "submitFormForButton('generateReferralLetterPage','opd?method=showOpdCaseSheetReport&hinNo=<%=hinNo%>&visitId=<%=visitId%>&flagPrint=opd');" />
	
	
	<input type="button" class="button" value="IPD Case Sheet " align="left"
	onClick="submitFormForButton('generateReferralLetterPage','discharge?method=showDischargeSummaryReport&flag=c&adNo=<%=adNo%>&hinNo=<%=hinNo%>&serviceNo=<%=serviceNo%>');" />
	<%}
    else
    {	%>
    	<input type="button" class="button" value="OPD Case Sheet " align="left"
    			onclick = "submitFormForButton('generateReferralLetterPage','opd?method=showOpdCaseSheetReport&hinNo=<%=hinNo%>&visitId=<%=visitId%>&flagPrint=opd');" />
    
    <%}
   	%>
	
	<input type="button" class="button" value="Upload/Download Documents" align="left"
	onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&hinId=<%=hinId%>&backFlag=ipd&inpatientId=<%=inpatientId%>&visitId=<%=visitId%>')" />
	
	
	
	<a href="#" onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&hinId=<%=hinId%>&backFlag=ipd&inpatientId=<%=inpatientId%>')">Upload Documents </a>
	
	
	

</div> --%>


	<h4>Billing Details</h4>
	<div class="Clear"></div>
	<div class="Block" id="billingList">
		<% 
int divCountBilling= 1;
boolean billflag = true;
for(ReferralPatientDetails referralPatientDetails : referralPatientDetailsList)
{ 
	%>
		<h4>
			Referral No:
			<%=referralPatientDetails.getReferralNo()%></h4>
		<%
for(ReferralPatientBilling referralPatientBilling : referralPatientBillingList)
	{ 
	if(referralPatientDetails.getId() == referralPatientBilling.getReferralDetails().getId())
	{
		billflag = false;
%>
		<div id="divBilling<%=divCountBilling%>">
			<input type="hidden" name="referralBillingId<%=divCountBilling%>"
				id="referralBillingId<%=divCountBilling%>"
				value="<%=referralPatientBilling.getId()%>" /> <label>Bill
				No</label><input type="text" maxlength="15"
				value='<%=referralPatientBilling.getBillNo()!=null?referralPatientBilling.getBillNo():""%>'
				readOnly="readOnly" /> <label>Bill Date</label><input type="text"
				maxlength="15"
				value='<%=referralPatientBilling.getBillDate()!=null?HMSUtil.convertDateToStringTypeDateOnly(referralPatientBilling.getBillDate()):""%>'
				readOnly="readOnly" />
			<div class="Clear"></div>
			<label>Bill Amount</label><input type="text"
				validate="Bill Amount,float,no" maxlength="15"
				name="impanelled_bill<%=divCountBilling%>"
				id="impanelled_bill<%=divCountBilling%>"
				value='<%=referralPatientBilling.getTotalBillAmt()!=null?referralPatientBilling.getTotalBillAmt():""%>'
				readOnly="readOnly" /> <label>Approved Bill Amount</label><input
				type="text" validate="Approved Bill Amount,float,no" maxlength="15"
				name="hal_bill<%=divCountBilling%>"
				id="hal_bill<%=divCountBilling%>"
				value='<%=referralPatientBilling.getAdminBillAmt()!=null?referralPatientBilling.getAdminBillAmt():""%>'
				readOnly="readOnly" />
			<!-- <input name="Button" type="button" class="buttonAdd" value="" onclick="addDivBilling();" tabindex="1" /> 			
	<input type="button" name="delete" value="" class="buttonDel" onclick="removeDivBilling();" tabindex="1" /> -->
			<div class="Clear"></div>
			<input type="hidden" id="referralNoId<%=divCountBilling%>"
				name="referralNoId<%=divCountBilling%>"
				value="<%=referralPatientBilling.getReferralDetails().getId()%>"
				readOnly="readOnly">
			<%-- <label>Referral Number <span>*</span></label>	
<select id="referralNoId<%=divCountBilling%>" name="referralNoId<%=divCountBilling%>"  validate="Referral Number,string,yes"  readOnly="readOnly">
			<option value="0">Select</option>
			<%
				
				if(referralPatientDetailsList!= null){
				for (ReferralPatientDetails details : referralPatientDetailsList) {
					if(details.getId() == referralPatientBilling.getReferralDetails().getId())
					{
			
			%>
							<option value="<%=details.getId()%>" selected="selected"><%=details.getReferralNo()%></option>
			<%	
				}
					else
					{
						
						%>
										<option value="<%=details.getId()%>" ><%=details.getReferralNo()%></option>
						<%	
							}
				}
			}
			%>
		</select> --%>
			<label>Admin Remarks</label>
			<textarea class="large" onkeyup="auto_grow(this)"
				validate="Remarks,string,no" maxlength="500"
				name="admin_remarks<%=divCountBilling%>"
				id="admin_remarks<%=divCountBilling%>" readOnly="readOnly" /><%=referralPatientBilling.getAdminRemarks()!=null?referralPatientBilling.getAdminRemarks():""%></textarea>

			<div class="clear"></div>
		</div>
		<% ++divCountBilling;
  } }
	if(billflag)
	{
		%>
		<h4>No Bill Available</h4>
		<%
	}
	}%>

		<%
	if(referralPatientBillingList.size()>0)
	{
		 %>
		<label>Admin Approval Date</label><label class="value"><%=referralPatientBillingList.get(0).getReferralDetails().getReferralPatientHeader().getAdminApprovalDate()!=null?HMSUtil.convertDateToStringWithoutTime(referralPatientBillingList.get(0).getReferralDetails().getReferralPatientHeader().getAdminApprovalDate()):""%></label>
		</textarea>
		<label>Hr Approval Date</label><label class="value"><%=referralPatientBillingList.get(0).getReferralDetails().getReferralPatientHeader().getHrApprovalDate()!=null?HMSUtil.convertDateToStringWithoutTime(referralPatientBillingList.get(0).getReferralDetails().getReferralPatientHeader().getHrApprovalDate()):""%></label>
		</textarea>
		<div class="Clear"></div>
		<label>Hr Remarks</label>
		<textarea class="large" onkeyup="auto_grow(this)"
			validate="Remarks,string,no" maxlength="500" readOnly="readOnly" /><%=referralPatientBillingList.get(0).getReferralDetails().getReferralPatientHeader().getHrRemarks()!=null?referralPatientBillingList.get(0).getReferralDetails().getReferralPatientHeader().getHrRemarks():""%></textarea>
		<div class="Clear"></div>
		<label>Remarks</label>
		<textarea class="large" onkeyup="auto_grow(this)"
			validate="Remarks,string,no" maxlength="500" name="finance_remarks"
			id="finance_remarks" /></textarea>
		<%}
	%>


		<script type="text/javascript">	var	referralNoArray= new Array();
	<%
	ReferralPatientDetails  referralPatientDetails = new ReferralPatientDetails();

				     for (int d = 0; d < referralPatientDetailsList.size(); d++) {
				    	 referralPatientDetails = (ReferralPatientDetails) referralPatientDetailsList.get(d);
	     			 %> 

	     			referralNoArray[<%=d%>]= new Array();
	     			referralNoArray[<%=d%>][0] = "<%=referralPatientDetails.getId()%>";
	     			referralNoArray[<%=d%>][1] = "<%=referralPatientDetails.getReferralNo()%>
			";
		<% }%>
			
		</script>
	</div>

	<input type="hidden" name="divCountBilling" id="divCountBilling"
		value="<%=(divCountBilling-1)%>" /> <input type="hidden"
		name="divCountExtension" id="divCountExtension" value="1" />

	<h4>Download Documents</h4>
	<div class="Clear"></div>
	<div class="Block">







		<%-- <input type="button" class="button" value="Referral Note " onClick="submitFormForButton('generateReferralLetterPage','referral?method=showInvoiceReport&referralPatientDetailsId=<%=referralPatientDetailsId%>&flag=<%=flag%>&referralTreatmentType=<%=referralTreatmentType%>');" align="left"
	onClick="" /> --%>
		<input type="button" name="yes" value="Print Covering Letter"
			class="button"
			onclick="submitForm('generateReferralLetterPage','/hms/hms/referral?method=showReferralReport&flag=covering_letter&referral_patient_header_id=<%=referralPatientHeaderId%>');" />

		<%if(opdPatientDetails.getInpatient()!=null)
    	{
    	%>
		<input type="button" class="button" value="OPD Case Sheet "
			align="left"
			onclick="submitFormForButton('generateReferralLetterPage','opd?method=showOpdCaseSheetReport&hinNo=<%=hinNo%>&visitId=<%=visitId%>&flagPrint=opd');" />


		<input type="button" class="button" value="IPD Case Sheet "
			align="left"
			onClick="submitFormForButton('generateReferralLetterPage','discharge?method=showDischargeSummaryReport&flag=c&adNo=<%=adNo%>&hinNo=<%=hinNo%>&serviceNo=<%=serviceNo%>');" />
		<%}
    else
    {	%>
		<input type="button" class="button" value="OPD Case Sheet "
			align="left"
			onclick="submitFormForButton('generateReferralLetterPage','opd?method=showOpdCaseSheetReport&hinNo=<%=hinNo%>&visitId=<%=visitId%>&flagPrint=opd');" />

		<%}
   	%>

		<input type="button" class="button" value="Upload/Download Documents"
			align="left"
			onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&hinId=<%=hinId%>&backFlag=Referral&referralHeaderId=<%=referralPatientHeaderId%>')" />
		<%-- <a href="#" onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&hinId=<%=hinId%>&backFlag=ipd&inpatientId=<%=inpatientId%>')">Upload Documents </a> --%>




	</div>


	<input type="hidden" name="careDate" value="<%=currentDate %>"
		readonly="readonly" /> <input type="hidden" name="time"
		value="<%=time.substring(0,time.lastIndexOf(":")) %>"
		readonly="readonly" />


	<div class="Clear"></div>



	<input type="hidden" name="careTime1"
		value="<%=time.substring(0,time.lastIndexOf(":"))  %>"
		readonly="readonly" /> <input type="hidden" name="careTime"
		value="<%=time%>" readonly="readonly" />
	<%-- <input type="hidden" id="inpatientId" name="inpatientId" value="<%=inpatient.getId()%>"/> --%>


	<div id="edited"></div>
	<div id="statusMessage" class="messagelabel">
		<br />
	</div>


	<input type="button" class="button" value="Approve " align="left"
		onClick="submitForm('generateReferralLetterPage','referral?method=submitInvoicePageForFinanceDivision');" />
	<input type="button" class="button" value="Reject " align="left"
		onClick="submitForm('generateReferralLetterPage','referral?method=submitInvoicePageForFinanceDivision&flag=rejected');" />
	<input type="button" class="button" value="Back" align="left"
		onClick="submitFormForButton('generateReferralLetterPage','referral?method=invoiceWaitingList');" />
	<input type="reset" name="reset" value="Reset" class="button"
		onclick="location.reload();" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="paddingTop15"></div>
	<div class="bottom">
		<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
			Date</label> <label class="value"><%=currentDate%></label> <label>Changed
			Time</label> <label class="value"><%=time%></label> <input type="hidden"
			name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
			name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
			type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	</div>
</form>

<script>
	function checkTimeFormat() {

		var chtime = document.getElementById("caretime").value
		if (chtime == "") {
			alert('Changed Time  can not be blank')
			return false
		}
		if (chtime != "") {
			var index = chtime.indexOf(':');
			//alert(index)
			if (!validateInteger(trimAll(chtime))) {
				alert(" Time should be a number(without spaces) without special Characters in HH:MM Format.");
				return false
			}
			if (index == -1)
				alert("Please Enter The Time in Correct Format.")

				//var indx = chtime.indexOf(':');

			if (index != -1) {
				var pairs2 = chtime.substring(0, chtime.length).split(':');
			}

			if (pairs2.length != 2) {
				alert("Invalid Time Format.It should be HH:MM")
				return false;
			}

			if (pairs2[0].length != 2 || pairs2[1].length != 2) {
				alert("Invalid Time Format.It should be HH:MM")
				return false;
			}

			val2 = eval(pairs2[0]);

			if (val2<0 || val2>23) {
				alert("Hours should 00-23")
				return false;
			}

			val3 = eval(pairs2[1]);

			if (val3<0 || val3>59) {
				alert("Min should 00-59")
				return false;
			}

			return true;
		}
	}

	function openWindow(url) {

		newwindow = window
				.open(url, 'name',
						"left=2,top=100,height=500,width=900,status=1,scrollbars=1,resizable=0");

	}
</script>






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

<%@page import="jkt.hms.masters.business.ReferralPatientBilling"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasWardImpanneledHospital"%>
<%@page import="jkt.hms.masters.business.ReferralPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.ReferralClarrificationHeader"%>
<%@page import="jkt.hms.masters.business.MasImpanneledHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.PatientDietIndoorDetail"%>
<%@page import="jkt.hms.masters.business.Ipdcaredetail"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>

<%@page import="jkt.hms.masters.business.AllergyDetail"%>

<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%-- <%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script> --%>
<!-- <script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script> -->
<!-- <script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script> -->
<!-- <script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script> -->
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
	
	




<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>

<script type="text/javascript">


var $j = jQuery.noConflict();
</script>


<%	
String rankCategoryCodeForWorkmen = HMSUtil.getProperties("adt.properties", "rankCategoryCodeForWorkmen");
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	String deptName="";
	
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	String caretime=(String)map.get("caretime");
	
	OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
	if (map.get("opdPatientDetails") != null) {
		opdPatientDetails = (OpdPatientDetails) map.get("opdPatientDetails");
	}
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	List<ReferralPatientDetails> referralPatientDetailsList = new ArrayList<ReferralPatientDetails>();
	List<ReferralPatientBilling> referralPatientBillingList = new ArrayList<ReferralPatientBilling>();
	List<ReferralClarrificationHeader> referralClarrificationHeaderList = new ArrayList<ReferralClarrificationHeader>();
	List<MasImpanneledHospital> impanelHospitalList = new ArrayList<MasImpanneledHospital>();
	
	if(map.get("referralPatientBillingList")!=null){
		referralPatientBillingList = (List<ReferralPatientBilling>)map.get("referralPatientBillingList");
	}
	if(map.get("referralPatientDetailsList")!=null){
		referralPatientDetailsList = (List<ReferralPatientDetails>)map.get("referralPatientDetailsList");
	}
	if(map.get("impanelHospitalList")!=null){
		impanelHospitalList = (List<MasImpanneledHospital>)map.get("impanelHospitalList");
	}
	
	if(map.get("referralClarrificationHeaderList")!=null){
		referralClarrificationHeaderList = (List<ReferralClarrificationHeader>)map.get("referralClarrificationHeaderList");
	}
	List<MasWardImpanneledHospital> imWardList = new ArrayList<MasWardImpanneledHospital>();
	if (map.get("imWardList") != null) {
		imWardList = (List<MasWardImpanneledHospital>) map.get("imWardList");
	}
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();	
	
	
	if (map.get("departmentList") != null) {
		departmentList = (List<MasDepartment>) map.get("departmentList");
 		
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
				currentAge = HMSUtil.calculateAge(patient.getDateOfBirth());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	
	
	
%>
<script type="text/javascript">
serverdate = '<%=currentDate%>'
</script>
<h4>Patient Details</h4>
<div class="Clear"></div>
<form name="generateReferralLetterPage" method="post">
<div class="Block">

<label>Employee No.</label> 
<label class="value"> <%=patient.getServiceNo()!=null?patient.getServiceNo():"" %></label>





<label>Patient Name</label>
<label	class="value"> <%= patientName %></label>
<input type="hidden" name="opdPatientDetailsId" id="opdPatientDetailsId" value="<%=opdPatientDetailsId%>"/>
<input type="hidden" name="hinId" id="hinId" value="<%=hinId%>"/>
<input	type="hidden" id="subTestIdArray" name="subTestIdArray"	value="">  

<label>Relation</label> <%
	if(patient.getRelation() != null){
	%> 
<label class="value"><%= patient.getRelation().getRelationName()%></label>
<%} else{ %> <label
	class="value">-</label> 
	<% }%> 
<div class="Clear"></div>
<label>Designation</label>
<label class="value"><%=(patient.getEmployee().getRank()!=null?patient.getEmployee().getRank().getRankName():"")%></label>

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

<label>Age</label> <%if(!currentAge.equals("")){ %>
<label class="value"> <%=currentAge %></label> <%}else{ %>
<label	class="value">-</label> <%} %>
<div class="Clear"></div>
<label>Gender</label> <%if(patient.getSex() != null){ %>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>		
<div class="Clear"></div>
</div>

<%-- 
<h4>Referral Details</h4>
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
	List<ReferralPatientBilling> referralPatientBillingList = new ArrayList<ReferralPatientBilling>();
	String subject = "";
	String note = "";
	int validity_period = 0;
	int referralPatientDetailsId = 0;
	String flag= "";
	String referralTreatmentType = "";
	if(map.get("diagnosisList")!=null){
		diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
		
	}
	if(map.get("referralPatientBillingList")!=null){
		referralPatientBillingList = (List<ReferralPatientBilling>)map.get("referralPatientBillingList");
	}
	if(map.get("referralPatientDetailsList")!=null){
		referralPatientDetailsList = (List<ReferralPatientDetails>)map.get("referralPatientDetailsList");
		subject = referralPatientDetailsList.get(0).getSubject();
		note = referralPatientDetailsList.get(0).getReferralNote();
		validity_period = referralPatientDetailsList.get(0).getLetterValidityPeriod();
		referralPatientDetailsId = referralPatientDetailsList.get(0).getId();
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
</div> --%>



<h4>Referral Details</h4>
<div class="Clear"></div>
<div class="Block">




	<%
	
	
	String subject = "";
	String note = "";
	int validity_period = 0;
	int referralPatientDetailsId = 0;
	BigDecimal deductionFS = new BigDecimal(0.0);
	int referralPatientHeaderId = 0;
	int total_bill = 0;
	int approved_bill = 0;
	int extentionCnt = 0;
	String admin_remarks= "";
	String hr_remarks= "";
	String finance_remarks= "";
	String flag= "";
	String referralTreatmentType = "";
	
	
	
	
%>
<%
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
	
	
		

<label>Referred From </label> <%if(referredFrom != null){ %>
<label class="value"> <%=referredFrom %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<label>Empanelled Hospital </label> 

<input type = "hidden" id="toHospital" name="toHospital" value="<%=opdPatientDetails.getImpanneledHospital().getId()%>"/>
<select id="empanelledHospitalId" name="empanelledHospitalId" class="large" validate="Empanelled Hospital,string,yes">
<option value="0">Select</option>
<%	for(MasImpanneledHospital ehospital :impanelHospitalList)
	{
	%>
	
	<%
	if(opdPatientDetails.getImpanneledHospital().getId()==ehospital.getId())
	{	
	
	%>
	<option value="<%=ehospital.getId()%>" selected="selected"><%=ehospital.getImpanneledHospitalName()%></option>
	<%
	}
	else
		{%>
	
			<option value="<%=ehospital.getId()%>"><%=ehospital.getImpanneledHospitalName()%></option>
	
		<%	}
	}
 %>

</select>


<%

	
	int refcount=0;
	for(ReferralPatientDetails referralPatientDetails: referralPatientDetailsList)
	{
		refcount++;
		subject = (referralPatientDetails.getSubject()!=null?referralPatientDetails.getSubject():"");
		note = (referralPatientDetails.getReferralNote()!=null?referralPatientDetails.getReferralNote():"");
		validity_period =(referralPatientDetails.getLetterValidityPeriod()!=null?referralPatientDetails.getLetterValidityPeriod():0);
		referralPatientDetailsId = referralPatientDetails.getId();
		referralPatientHeaderId = referralPatientDetails.getReferralPatientHeader().getId();
		deductionFS = referralPatientDetails.getReferralPatientHeader().getDeductionFromSalary();
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
			 <h4>Extension - : <%=extentionCnt%></h4>
			 <div class="Clear"></div>
			 <h4>Extension No : <%=referralPatientDetails.getReferralNo()!=null?referralPatientDetails.getReferralNo():""%></h4>
		     <label>Extension Date</label> 
			 <%
			 
		 }
		 else
		 {
			 %>
			 
			 <div class="Clear"></div>
			 <h4>Referral No : <%=referralPatientDetails.getReferralNo()%></h4>
		     <label>Referral Date</label> 
			 <%
			 
		 }
		 %>  
		  
		  <input type="text" id="referralDate<%=refcount%>" name="referralDate<%=refcount%>" value="<%=referralPatientDetails.getReferralExtensionDate()!=null?HMSUtil.convertDateToStringTypeDateOnly(referralPatientDetails.getReferralExtensionDate()):""%>"/>
		  <label>Referred For</label> 
		  <input type="text" id="referredFor<%=refcount%>" name="referredFor<%=refcount%>" value="<%=referralPatientDetails.getReferredFor()!=null?referralPatientDetails.getReferredFor():""%>"/>
		  
		 <label>Treatment Type </label>
		<%--  <input type="hidden" id="treatmentType<%=refcount%>" name="treatmentType<%=refcount%>" value="<%=referralPatientDetails.getTreatmentType()!=null?referralPatientDetails.getTreatmentType():""%>"/> --%>
		<select id="treatmentType<%=refcount%>" name="treatmentType<%=refcount%>" validate="Treatment Type,string,yes" onchange="wardDiv(this.value, <%=refcount%>)">
     
	
	<%
	if(referralPatientDetails.getTreatmentType().trim().equals("1")){
	
	%>
	<option value="1" selected="selected">OPD</option>
	<%
	}
	else
		{%>	
		<option value="1">OPD</option>	
		<%}	
 %>
 	<%
	if(referralPatientDetails.getTreatmentType().trim().equals("2")){
	
	%>
	<option value="2" selected="selected">Admission</option>
	<%
	}
	else
		{%>	
		<option value="2">Admission</option>	
		<%}	
 %>
   </select>
		
	
	         <%
		 if(false){ %>
		 <div class="Clear"></div>
		 <label > Note:<span>*</span></label><input type="text" class = "large"  validate="Note,String,yes" maxlength="500" value="OPD/CONSULTATION(INCLUDING PHARMACECUTICALS FOR <%=referralPatientDetails.getNoOfDays()!=null?referralPatientDetails.getNoOfDays():""%> DAYS)" name ="referral_note" id ="referral_note"/>
          <%if(referralPatientDetails.getTreatmentType().equals("2")){%>
<label  style="margin-left: 42px;">
 Ward:</label> 
<label class="value"> <%=referralPatientDetails.getWard().getWardName()%></label>


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
         <label> This letter is valid for <span>*</span></label><input type="text" value="" class = "small" name ="validity_period" id="validity_period" validate="Validity Period,int,yes" maxlength="5"/>Days
         <div class="Clear"></div>
         <label> Subject:<span>*</span></label><input type="text"  class="large" value="" name ="subject" id ="subject" validate="Subject,String,yes" maxlength="250"/>
        <%}else{ %>
        <div class="Clear"></div>
        <label>Doctor Note</label>
         <textarea class = "large" name ="doctorNote<%=refcount%>" id ="doctorNote<%=refcount%>" ><%=(referralPatientDetails.getDoctorRemarks()!=null?referralPatientDetails.getDoctorRemarks():" ")%></textarea>
         <div class="Clear"></div>
		 <label > Note:</label><input type="text" class = "large" name ="note<%=refcount%>" id ="note<%=refcount%>" validate="Note,String,no" maxlength="500" value="<%=note %>"  />
		 <div id ="wardDiv<%=refcount%>" style="display:none">
		 <label  style="margin-left: 42px;"> Ward:<span>*</span></label> 
<select name="wardId<%=refcount%>" id="wardId<%=refcount%>" validate="Ward ,String,no">
<option value="0">Select</option>
	<%
	System.out.println("imWardList"+imWardList.size());
	for(MasWardImpanneledHospital mweh: imWardList)
	{
	
			
			if(mweh.getWardName().equalsIgnoreCase(referralPatientDetails.getWard()!=null?referralPatientDetails.getWard().getWardName():""))
			{
			%>
	<option value="<%=mweh.getId()%>" selected="selected"><%=referralPatientDetails.getWard().getWardName()%></option>
	<%
			}
			else
			{
			%>
	<option value="<%=mweh.getId()%>"><%=mweh.getWardName()%></option>
	<%
			}
			
		
		}
		%>
</select> 
		 </div>
		  <%if(referralPatientDetails.getTreatmentType().equals("2")){%>
	<script type="text/javascript">	
	
	document.getElementById("wardDiv<%=refcount%>").show();
	</script>


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
		 <label> This letter is valid for </label><input type="text" name ="validityPeriod<%=refcount%>" id ="validityPeriod<%=refcount%>"  value="<%=validity_period %>" class = "small"  validate="Validity Period,int,no" maxlength="5" />Days
		 <div class="Clear"></div>
		 <label> Subject:</label><input type="text" name ="subject<%=refcount%>" id ="subject<%=refcount%>" class="large" value="<%=subject %>"  validate="Subject,String,no" maxlength="250" />
		 
	     <input type="button" class="button" value="update " onClick="updateReferralDetails(<%=refcount%>, <%=referralPatientDetailsId%>)" align="left"	 />
	     <input type="button" class="button" value="Referral Note " onClick="submitFormForButton('generateReferralLetterPage','referral?method=showInvoiceReport&referralPatientDetailsId=<%=referralPatientDetailsId%>&flag=<%=flag%>&referralTreatmentType=<%=referralTreatmentType%>');" align="left"	 />
	
	
		 <%}
		 ++extentionCnt;
	}
	%>
			



	
		

<input type = "hidden" value = "<%=referralPatientDetailsId %>" name = "referralPatientDetailsId" id="referralPatientDetailsId"/>
<%-- <input type = "hidden" value = "<%=referralPatientHeaderId %>" name = "referralPatientHeaderId" id="referralPatientHeaderId"/> --%>
</div>



<h4>Billing Details</h4>
<div class="Clear"></div>
<div class="Block" id="billingList">
  <label><font color="red">Deduction From Salary</font></label><input type="text" style="margin-right: 0px;" validate="Deduction From Salary,string,nos" maxlength="19" name ="deductionFS" id ="deductionFS" value=<%=deductionFS!=null?deductionFS:0%> />
  <div class="Clear"></div>
<% int divCountBilling= 1;
if(referralPatientBillingList.size()>0)
{
for(ReferralPatientBilling referralPatientBilling : referralPatientBillingList)
	{ 
%>
<div id="divBilling<%=divCountBilling%>">
<input type="hidden" name="referralBillingId<%=divCountBilling%>" id="referralBillingId<%=divCountBilling%>" value="<%=referralPatientBilling.getId()%>"/>
<label>Bill No<span>*</span></label><input type="text" validate="Bill No,string,yes" maxlength="100" name ="bill_no<%=divCountBilling%>" id ="bill_no<%=divCountBilling%>" value='<%=referralPatientBilling.getBillNo()!=null?referralPatientBilling.getBillNo():""%>' onblur="checkBillNo(<%=divCountBilling%>)"/>
<label>Bill Date<span>*</span></label>
<input id="bill_date<%=divCountBilling%>" class="calDate" validate="Bill Date,string,yes" placeholder="DD/MM/YYYY" name="bill_date<%=divCountBilling%>" onkeyup="mask(this.value,this,'2,5','/');"   maxlength="30" type="text" value='<%=referralPatientBilling.getBillDate()!=null?HMSUtil.convertDateToStringTypeDateOnly(referralPatientBilling.getBillDate()):""%>'>
<!-- <input  type="text" class="calDate"  id="ProposalApprovalDate" name="ProposalApprovalDate" placeholder="DD/MM/YYYY" validate="Proposal Approval Date,string,yes"  onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10"/> -->
<%-- <img id="calendar" class="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" onclick="setdate('',document.generateReferralLetterPage.bill_date<%=divCountBilling%>, event)" width="16" border="0" height="16"> --%>
<%if(!referralPatientBilling.getReferralDetails().getReferralPatientHeader().getApprovalStatus().equals("RHD(there is no need of this condition now)"))
		{
		%>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addDivBilling();" tabindex="1" /> 			
<input type="button" name="delete" value="" class="buttonDel" onclick="removeDivBillingDB(<%=referralPatientBilling.getId() %>, <%=divCountBilling%>);" tabindex="1" />
<%}%>
<div class="Clear"></div>
    <label>Bill Amount<span>*</span></label><input type="text" validate="Bill Amount,float,yes" maxlength="15" name ="impanelled_bill<%=divCountBilling%>" id ="impanelled_bill<%=divCountBilling%>" value='<%=referralPatientBilling.getTotalBillAmt()!=null?referralPatientBilling.getTotalBillAmt():""%>' />

<label>Approved Bill Amount<span>*</span></label><input type="text" validate="Approved Bill Amount,float,yes" maxlength="15" name ="hal_bill<%=divCountBilling%>" onchange="validateBill(<%=divCountBilling%>)" id ="hal_bill<%=divCountBilling%>" value='<%=referralPatientBilling.getAdminBillAmt()!=null?referralPatientBilling.getAdminBillAmt():""%>' />
<input type="checkbox" style="margin-right: 0px;" validate="Include in clarification Amount,string,nos" maxlength="15" name ="clarri_bill<%=divCountBilling%>" id ="clarri_bill<%=divCountBilling%>" value='y' /><label>Include In Clarification</label>
	<div class="Clear"></div>
	<%if(referralPatientBilling.getReferralDetails().getReferralPatientHeader().getApprovalStatus().equals("RHD(there is no need of this condition now)"))
		{
		%>
	<%-- 	<label>Remarks</label><textarea readonly="readonly" validate="Remarks,string,no" maxlength="500" name ="admin_remarks<%=divCountBilling%>" id ="admin_remarks<%=divCountBilling%>" /><%=referralPatientBilling.getAdminRemarks()!=null?referralPatientBilling.getAdminRemarks():""%></textarea>

 <label>Referral Number </label>	
<select id="referralNoId<%=divCountBilling%>" disabled ="true" name="referralNoId<%=divCountBilling%>"  validate="Referral Number,string,no">
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
			} --%>
			
<label>Remarks</label><textarea validate="Remarks,string,no" class="large" onkeyup="auto_grow(this)" maxlength="500" name ="admin_remarks<%=divCountBilling%>" id ="admin_remarks<%=divCountBilling%>" /><%=referralPatientBilling.getAdminRemarks()!=null?referralPatientBilling.getAdminRemarks():""%></textarea>

 <label>Referral Number <span>*</span></label>	
<select id="referralNoId<%=divCountBilling%>" name="referralNoId<%=divCountBilling%>"  validate="Referral Number,string,yes">
			<option value="0">Select</option>
			<%
				
				if(referralPatientDetailsList!= null){
				for (ReferralPatientDetails details : referralPatientDetailsList) {
					if(details.getId() == referralPatientBilling.getReferralDetails().getId())
					{
			
			%>
							<option value="<%=details.getId()%>" selected="selected"><%=details.getReferralNo()!=null?details.getReferralNo():""%></option>
			<%	
				}
					else
					{
						
						%>
										<option value="<%=details.getId()%>" ><%=details.getReferralNo()!=null?details.getReferralNo():""%></option>
						<%	
							}
				}
			}
		
		}
		else
		{%>
			

<label>Remarks</label><textarea validate="Remarks,string,no" class="large" onkeyup="auto_grow(this)" maxlength="500" name ="admin_remarks<%=divCountBilling%>" id ="admin_remarks<%=divCountBilling%>" /><%=referralPatientBilling.getAdminRemarks()!=null?referralPatientBilling.getAdminRemarks():""%></textarea>
 
 <label>Referral Number <span>*</span></label>	
<select id="referralNoId<%=divCountBilling%>" name="referralNoId<%=divCountBilling%>"  validate="Referral Number,string,yes">
			<option value="0">Select</option>
			<%
				
				if(referralPatientDetailsList!= null){
				for (ReferralPatientDetails details : referralPatientDetailsList) {
					if(details.getId() == referralPatientBilling.getReferralDetails().getId())
					{
			
			%>
							<option value="<%=details.getId()%>" selected="selected"><%=details.getReferralNo()!=null?details.getReferralNo():""%></option>
			<%	
				}
					else
					{
						
						%>
										<option value="<%=details.getId()%>" ><%=details.getReferralNo()!=null?details.getReferralNo():""%></option>
						<%	
							}
				}
			}}
			%>
		</select>		
	
  <div class="clear"></div> 
 
  </div>
  <% ++divCountBilling;
  }
if(referralPatientBillingList.get(0).getReferralDetails().getReferralPatientHeader().getHrRemarks() != null)	
{%>
 
	<label>Hr Remarks</label><textarea validate="Remarks,string,no" class="large" onkeyup="auto_grow(this)" maxlength="500"  readOnly="readOnly"/><%=referralPatientBillingList.get(0).getReferralDetails().getReferralPatientHeader().getHrRemarks()!=null?referralPatientBillingList.get(0).getReferralDetails().getReferralPatientHeader().getHrRemarks():""%></textarea>
	 <div class="clear"></div> 
	<% 
}

}
  else
  {
	  %>
	  <div id="divBilling<%=divCountBilling%>">
<input type="hidden" name="referralBillingId<%=divCountBilling%>" id="referralBillingId<%=divCountBilling%>" />
<label>Bill No<span>*</span></label>
<input type="text" validate="Bill No,string,yes" maxlength="100" name ="bill_no<%=divCountBilling%>" id ="bill_no<%=divCountBilling%>" onblur="checkBillNo(<%=divCountBilling%>)" />

<label>Bill Date<span>*</span></label>
<input id="bill_date<%=divCountBilling%>" class="calDate" validate="Bill Date,date,yes" placeholder="DD/MM/YYYY" onkeyup="mask(this.value,this,'2,5','/');" name="bill_date<%=divCountBilling%>"  value="" tabindex="1" maxlength="30" type="text">


<%-- <img id="calendar<%=divCountBilling%>" class="calender" src="/hms/jsp/images/cal.gif" validate="Pick a date" onclick="setdate('',document.generateReferralLetterPage.bill_date<%=divCountBilling%>, event)" width="16" border="0" height="16"> --%>

<input name="Button" type="button" class="buttonAdd" value="" onclick="addDivBilling();" tabindex="1" /> 			
	<input type="button" name="delete" value="" class="buttonDel" onclick="removeDivBilling(<%=divCountBilling%>);" tabindex="1" />
<div class="Clear"></div>
    <label>Bill Amount<span>*</span></label><input type="text" validate="Bill Amount,float,yes" maxlength="15" name ="impanelled_bill<%=divCountBilling%>" id ="impanelled_bill<%=divCountBilling%>"  />

<label>Approved Bill Amount<span>*</span></label><input type="text" validate="Approved Bill Amount,float,yes" maxlength="15" name ="hal_bill<%=divCountBilling%>" id ="hal_bill<%=divCountBilling%>" onchange="validateBill(<%=divCountBilling%>)" />
<input type="checkbox" style="margin-right: 0px;" validate="Include in clarification Amount,string,nos" maxlength="15" name ="clarri_bill<%=divCountBilling%>" id ="clarri_bill<%=divCountBilling%>" value='y' /><label>Include In Clarification</label>	
<div class="Clear"></div>
<label>Remarks</label><textarea validate="Remarks,string,no" class="large" onkeyup="auto_grow(this)" maxlength="500" name ="admin_remarks<%=divCountBilling%>" id ="admin_remarks<%=divCountBilling%>" /></textarea>

 <label>Referral Number <span>*</span></label>	
<select id="referralNoId<%=divCountBilling%>" name="referralNoId<%=divCountBilling%>"  validate="Referral Number,string,yes">
			<option value="0">Select</option>
			<%
				
				if(referralPatientDetailsList!= null){
				for (ReferralPatientDetails details : referralPatientDetailsList) {
				
			
			%>
							<option value="<%=details.getId()%>" selected="selected"><%=details.getReferralNo()!=null?details.getReferralNo():""%></option>
			<%	
				
				
				}
			}
			%>
		</select>		
	
  <div class="clear"></div> 
  </div>
	  <%
	  ++divCountBilling;
	  }%>
  
  	<script type="text/javascript">	var	referralNoArray= new Array();
	<%
	ReferralPatientDetails  referralPatientDetails = new ReferralPatientDetails();

				     for (int d = 0; d < referralPatientDetailsList.size(); d++) {
				    	 referralPatientDetails = (ReferralPatientDetails) referralPatientDetailsList.get(d);
	     			 %> 

	     			referralNoArray[<%=d%>]= new Array();
	     			referralNoArray[<%=d%>][0] = "<%=referralPatientDetails.getId()%>";
	     			referralNoArray[<%=d%>][1] = "<%=referralPatientDetails.getReferralNo()%>";
	     			 <% }%>    </script>
	     			
</div>

<input type="hidden" name ="divCountBilling" id="divCountBilling" value="<%=(divCountBilling-1)%>"/>
<input type="hidden" name ="divCountExtension" id="divCountExtension" value="1"/>


<h4>Clarification Details</h4>
<div class="Clear"></div>
<div class="Block">



	<label>Clarification Remarks</label><textarea onkeyup="auto_grow(this)" validate="Clarification Remarks,string,no" maxlength="2000" name ="clarri_remarks" id ="clarri_remarks" class="large" /></textarea>
<div class="Clear"></div>
<% int clarriCount = 0;
if(referralClarrificationHeaderList.size()>0)
	{%>
	<h4>Clarification History</h4>
	<table>
	<tr><th>Request Date</th><th>Requested By</th><th>HAL Remarks</th><th>Impanel Remarks</th> <th>Report</th></tr>
    <%for(ReferralClarrificationHeader rch : referralClarrificationHeaderList)
    	{
    	++clarriCount; 
    	%>
    	<tr>
    	<input type="hidden" name="clarriHeaderId<%=clarriCount%>" id="clarriHeaderId<%=clarriCount%>" value="<%=rch.getId()%>"/>
    	<td><%=HMSUtil.convertDateToStringTypeDateOnly(rch.getGenerationDate())%></td>
    	<td><%=rch.getGeneratedBy().getEmployee().getFirstName()+" "+(rch.getGeneratedBy().getEmployee().getMiddleName()!=null?rch.getGeneratedBy().getEmployee().getMiddleName()+" ":"")+(rch.getGeneratedBy().getEmployee().getLastName()!=null?rch.getGeneratedBy().getEmployee().getLastName()+" ":"")%></td>
    	<td><%=rch.getClarificationRemarks()!=null?rch.getClarificationRemarks():""%></td>
    	<td><%if(rch.getImpaneledRemarks()!=null && rch.getImpaneledRemarks().trim()!="") {%>
    	<%=rch.getImpaneledRemarks()%>
    	<%}else{ %>
    	<textarea name='impanel_remarks<%=clarriCount%>' id='impanel_remarks<%=clarriCount%>' maxlength="2000" onkeyup="auto_grow(this)"></textarea>
    	<%}%>
    	</td>
    	<td><input type="button" class="button" value="Report" onclick = "submitFormForButton('generateReferralLetterPage','referral?method=generateClarrificationReport&clarrificationHeaderId=<%=rch.getId()%>');" /></td>
	
	</tr>
	<%}%>
	</table>
	<%}%>
	
	<input type="hidden" name="clarriCount" id="clarriCount" value="<%=clarriCount%>"/>

</div>


<h4>Generate Extension</h4>
<div class="Clear"></div>
<div class="Block">
<div class="Block">
			<label>Department <span>*</span></label> <select id="deptId" name="departmentId"
				onchange="submitProtoAjaxWithDivName('generateReferralLetterPage','/hms/hms/appointment?method=getDoctorDetailsForReferral','doctorNSessionList');">
				<option value="0">Select</option>
				<%
				
				if(departmentList!= null){
				for (MasDepartment masDepartment : departmentList) {
					
			
			%>
				<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
				<%	
					
				}
			}
			%>
			</select>


			<div id="doctorNSessionList">
				<label>Doctor List<span>*</span>
				</label> <select id="doctorId" name="consultingDoctor">
					<option value="0"></option>
				</select> <label>Session<span>*</span>
				</label> <select id="sesId" name="sessionList">
					<option value="0"></option>
				</select>

			</div>


			<!-- <input name="Print" type="button" value="Generate Report" target="_blank" class="cmnButton" onClick="showReport('appSetup');"> -->
			<input name="Print" type="button" value="Show Availability" target="_blank"
				style="width: 147px;" class="button" onClick="validateTokenDiv()">
			<!-- <input name="Print" type="button" value="Show Setup" target="_blank" class="cmnButton"   onclick="if(validateDatefield()){ getDetails();}" /> -->

			<div id="displayToken"></div>		


		</div>
		
	<input type="button" class="button" value="Generate Extension" align="left"
	onClick="validateExtension();" />

</div>

<h4>Download Documents</h4>
<div class="Clear"></div>
<div class="Block">







	<%-- <input type="button" class="button" value="Referral Note " onClick="submitFormForButton('generateReferralLetterPage','referral?method=showInvoiceReport&referralPatientDetailsId=<%=referralPatientDetailsId%>&flag=<%=flag%>&referralTreatmentType=<%=referralTreatmentType%>');" align="left"
	onClick="" /> --%>

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
	onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&hinId=<%=hinId%>&backFlag=Referral&referralHeaderId=<%=referralPatientHeaderId%>')" />
	
	<%-- <a href="#" onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&hinId=<%=hinId%>&backFlag=ipd&inpatientId=<%=inpatientId%>')">Upload Documents </a> --%>
	
	
	

</div>


<input type="hidden" name="careDate" value="<%=currentDate %>" readonly="readonly" />
<input type="hidden" name="time" value="<%=time.substring(0,time.lastIndexOf(":")) %>" readonly="readonly" /> 


<div class="Clear"></div>



<input type="hidden" name="careTime1" value="<%=time.substring(0,time.lastIndexOf(":"))  %>" readonly="readonly" />
<input type="hidden" name="careTime" value="<%=time%>" readonly="readonly" />
<%-- <input type="hidden" id="inpatientId" name="inpatientId" value="<%=inpatient.getId()%>"/> --%>


<div id="edited"></div>
<div id="statusMessage" class="messagelabel"><br />
</div>

<%-- <%
if(referralPatientBillingList.size()>0)
{
if(!referralPatientBillingList.get(0).getReferralDetails().getReferralPatientHeader().getApprovalStatus().equals("RHD"))
		{
		%>
<input type="button" class="button" value="Save As Draft " align="left"
	onClick="submitForm('generateReferralLetterPage','referral?method=submitInvoicePage&saveAs=draft');" />
<input type="button" class="button" value="Approve " align="left"
	onClick="submitForm('generateReferralLetterPage','referral?method=submitInvoicePage');" />
	<%}}
else
{
	%>
	<input type="button" class="button" value="Save As Draft " align="left"
	onClick="submitForm('generateReferralLetterPage','referral?method=submitInvoicePage&saveAs=draft');" />
<input type="button" class="button" value="Approve " align="left"
	onClick="submitForm('generateReferralLetterPage','referral?method=submitInvoicePage');" />
	<%
}
		%> --%>
		
<!-- <input type="button" class="button" value="Reject " align="left"  /> -->



<input type="button" class="button" value="Save As Draft" align="left"
	onClick="submitForm('generateReferralLetterPage','referral?method=submitInvoicePage&saveAs=draft', 'clarrificationValidation');" />
<input type="button" class="button" value="Approve " align="left"
	onClick="submitForm('generateReferralLetterPage','referral?method=submitInvoicePage', 'billNoValidation');" />
<input type="button" class="button" value="Back" align="left"
	onClick="submitFormForButton('generateReferralLetterPage','referral?method=invoiceWaitingList');" />
<input type="reset" name="reset" value="Reset" class="button" onclick="location.reload();"/>
	<div class="clear"></div>
<div class="division"></div>	
<div class="paddingTop15"></div>
	<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>

<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>

<script>


function checkTimeFormat(){
	
	var chtime=document.getElementById("caretime").value
 	if(chtime==""){
		alert('Changed Time  can not be blank')
		return false
	}
	 if(chtime!= ""){
	 			var index=chtime.indexOf(':');
	 			//alert(index)
				if(!validateInteger(trimAll(chtime)))
				{
					alert(" Time should be a number(without spaces) without special Characters in HH:MM Format.");
					return false						
				}
				if(index == -1)
				  alert("Please Enter The Time in Correct Format.")
					
	
		 //var indx = chtime.indexOf(':');
		 
		 if (index != -1) {
		 var pairs2 = chtime.substring(0,chtime.length).split(':');
		 }
				 
		 if (pairs2.length!=2) { 
			 alert("Invalid Time Format.It should be HH:MM")
			return false;
			}
		 
		 if (pairs2[0].length != 2 || pairs2[1].length != 2 ) {
				  alert("Invalid Time Format.It should be HH:MM")
				  return false;
				}
		 
		 		 val2=eval(pairs2[0]);
		 			
						  if (val2<0 || val2>23) {
							  alert("Hours should 00-23")
					 		 return false;}
					 		 
					 		 val3=eval(pairs2[1]);
		 		
							  if (val3<0 || val3>59) {
							  alert("Min should 00-59")
					 		 return false;}
			 			
		return true;	  
	}
	}
	
function openWindow(url){

    newwindow=window.open(url,'name',"left=2,top=100,height=500,width=900,status=1,scrollbars=1,resizable=0");
	
}

function addDivBilling(){
	  
	  var divList = document.getElementById('billingList');		 
	  var divCount = parseInt(document.getElementById("divCountBilling").value);
	  var iteration = divCount+1;
	  var newdiv = document.createElement('divBilling');
newdiv.setAttribute('id', 'divBilling'+iteration);
divList.appendChild(newdiv);
	 
    var e11 = document.createElement('label');
    e11.innerHTML = "Bill No<span>*<span>";
    newdiv.appendChild(e11);

    var e12 = document.createElement('input');
    e12.name='bill_no'+iteration;		  
    e12.id='bill_no'+iteration;
    e12.type = 'text';	  
    e12.setAttribute('validate','Bill no,string,yes');	
    e12.onblur=function(){checkBillNo(iteration);}
    newdiv.appendChild(e12);
    
    var e13 = document.createElement('label');
    e13.innerHTML = "Bill Date<span>*<span>";
    newdiv.appendChild(e13);

    var e14 = document.createElement('input');
    e14.name='bill_date'+iteration;		  
    e14.id='bill_date'+iteration;
    e14.type = 'text';	  
    e14.setAttribute('validate','Bill Date,date,yes');	
    e14.setAttribute('class','calDate');    
    e14.placeholder='DD/MM/YYYY';
    e14.setAttribute("onkeyup","mask(this.value,this,'2,5','/')");
    newdiv.appendChild(e14);
    
    
    /* var e15 = document.createElement('IMG');     
    e15.id='calendar'+iteration;  
    e15.setAttribute('class','calender');
    e15.setAttribute('src','/hms/jsp/images/cal.gif');
    e15.setAttribute('validate','Pick a date');
    e15.onclick=function(){setdate('',document.getElementById("bill_date"+iteration), 'event');}
    e15.setAttribute('width','16');
    e15.setAttribute('height','16');
    e15.setAttribute('border','0');
    newdiv.appendChild(e15); */
    
    var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.name='Button';
	  e5.onclick=function(){addDivBilling();}
	  e5.setAttribute("class", "buttonAdd");			 
	  newdiv.appendChild(e5);
	  
	  var e6 = document.createElement('input');
	  e6.type = 'button';
	  e6.name='delete';
	  e6.onclick=function(){removeDivBilling(iteration);}
	  e6.setAttribute("class", "buttonDel");
	  
	  newdiv.appendChild(e6);
	  
	  var newline1 = document.createElement('div');
	  newline1.setAttribute("class", "clear");		
	  newdiv.appendChild(newline1);
	  
	  
	  var e1 = document.createElement('label');
	  e1.innerHTML = "Bill Amount<span>*<span>";
	  newdiv.appendChild(e1);
	  
	  var e2 = document.createElement('input');
	  e2.name='impanelled_bill'+iteration;		  
	  e2.id='impanelled_bill'+iteration;
	  e2.type = 'text';	  
	  e2.setAttribute('validate','Bill Amount,float,yes');	
	  newdiv.appendChild(e2);
	  
	  var e3 = document.createElement('label');
	  e3.innerHTML = "Approved Bill Amount<span>*<span>";
	  newdiv.appendChild(e3);
	  
	  
	
	
	  
	  
	  var e4 = document.createElement('input');
	  e4.name='hal_bill'+iteration;		  
	  e4.id='hal_bill'+iteration;
	  e4.type = 'text';	  
	  e4.setAttribute('validate','Approved Bill Amount,float,yes');	
	  e4.onclick=function(){validateBill(iteration);}
	  newdiv.appendChild(e4);
		  
	  var e50 = document.createElement('input');
	  e50.name='clarri_bill'+iteration;		  
	  e50.id='clarri_bill'+iteration;
	  e50.type = 'checkbox';	  
	  e50.style = 'margin-right: 0px;';	
	  e50.setAttribute('validate','Include in clarrification Amount,string,no');	
	  newdiv.appendChild(e50);
	  
	  var e51 = document.createElement('label');
	  e51.innerHTML = "Include In Clarrification";
	  newdiv.appendChild(e51);
		 
		  
		  var newline2 = document.createElement('div');
		  newline2.setAttribute("class", "clear");		
		  newdiv.appendChild(newline2);
		  
		  var e7 = document.createElement('label');
		  e7.innerHTML = "Remarks";
		  newdiv.appendChild(e7);
		  
		  var e8 = document.createElement('textarea');
		  e8.name='admin_remarks'+iteration;		  
		  e8.id='admin_remarks'+iteration;	
		  e8.setAttribute('class','large');
		  e8.onkeyup="auto_grow(this)";
		  e8.setAttribute('validate','Remarks,string,no');	
		  newdiv.appendChild(e8);
		  
		  var e9 = document.createElement('label');
		  e9.innerHTML = "Referral Number<span>*<span>";
		  newdiv.appendChild(e9);
		  
		  var e10 = document.createElement('Select');
		  e10.name='referralNoId'+iteration;		  
		  e10.id='referralNoId'+iteration;	 
		  e10.setAttribute('validate','Referral Number,string,yes');	
		  
		  e10.options[0] = new Option('Select', '0');
		
		   for(var i = 0;i<referralNoArray.length;i++ ){
		      e10.options[i+1] = new Option(referralNoArray[i][1],referralNoArray[i][0]);
		      }
		   newdiv.appendChild(e10);
		  
		  var newline3 = document.createElement('div');
		  newline3.setAttribute("class", "clear");		
		  newdiv.appendChild(newline3);
		  document.getElementById("divCountBilling").value = iteration;


	}
function removeDivBilling(divNum)
{
/* var divCount = parseInt(document.getElementById("divCountBilling").value); */
if(divNum>1)
	{
	
	document.getElementById("divBilling"+divNum).remove();
	/* document.getElementById("divCountBilling").value = (divCount-1); */
	}
	

}

function removeDivBillingDB(Id, divNumber)
{
var divCount = parseInt(document.getElementById("divCountBilling").value);



if(confirm("Are you sure you want to delete the details?"))
{		
	DeleteFromDatabase_AddRemoveGrid(Id,divCount, divNumber);	   
	
}
else
	{				
		return;
	}
	
	
}
	
function DeleteFromDatabase_AddRemoveGrid(tableId,divCount, divNumber)
{	
	var data = "Id="+tableId;
	
	//alert(data+tableId+headerId);
	
		
	
	
	
	$j.ajax({
		type:"GET",
		data: data,
		url:'referral?method=DeleteFromDatabase_AddRemoveGrid',		
		cache: false,
		success: function(msg)
		{			
			if(msg.indexOf("success~~") != -1)
				{					
					
					
					if(divNumber>1)
					{
					
						document.getElementById("divBilling"+divNumber).remove();
						/* document.getElementById("divCountBilling").value = (divCount-1); */
					}
				}
			else
				{
					alert("Not Delete");
				}
			
					
		},
		error: function(msg)
		{		
			alert("Some error Occured. Please try again.")
			
		}
			
		
	});
}
	



function validateBill(rowNum)
{
var approvedBill = parseFloat(document.getElementById("hal_bill"+rowNum).value);
var billAmount = parseFloat(document.getElementById("impanelled_bill"+rowNum).value);
if(approvedBill > billAmount)
	{
	document.getElementById("hal_bill"+rowNum).value="";
	alert("Approved Bill Amount can't be greater than Bill Amount");
	
	}
	

}

function clarrificationValidation()
{
	var returnflag = true;
	returnflag = billNoValidation();
	if(returnflag)
		{
	var divCount = parseInt(document.getElementById("divCountBilling").value);
	var flag = false;

	

	
	for(var i = 1; i<=divCount; i++)
		{
		
		 if(document.getElementById("clarri_bill"+i)!=null && document.getElementById("clarri_bill"+i).checked)
			 {
			 flag = true;
			 }
		}
	if(flag)
		{
		if(document.getElementById("clarri_remarks").value.trim() == "")
			{
			 alert("Please Enter Clarification Remarks");
			 returnflag = false;
			}
		}
}
	return returnflag;
	
}

function billNoValidation()
{
	var divCount = parseInt(document.getElementById("divCountBilling").value);
	var flag = true;
	for(var i = 1; i<=divCount; i++)
		{
		
		for(var j = 1; j<=divCount; j++)
		{
		
			if(i!=j && document.getElementById("bill_no"+i)!=null && document.getElementById("bill_no"+j)!=null)
				{
				 if(document.getElementById("bill_no"+i).value.trim() == document.getElementById("bill_no"+j).value.trim())
				 {
				 flag = false;
				 }
				}
		
		}
		
		
		}
	if(!flag)
		{
		alert("Dublicate Bill No");
		}
	
	return flag;
}

function validateTokenDiv()
{
	var deptId = document.getElementById("deptId").value;
	var doctorId = document.getElementById("doctorId").value;
	var sesId = document.getElementById("sesId").value;
	if(deptId!=0 && doctorId!=0 && sesId!=0)
		{
		submitProtoAjaxWithDivName('generateReferralLetterPage','/hms/hms/registration?method=getTokenNoForDepartmentReferral','displayToken');
		}
	else
	{
		alert("Please Select Department, Doctor And Session");
	}
		
}

function validateExtension(){
	
	
	if(document.getElementById("tokenNoId") !=null)
		{
		if(document.getElementById("tokenNoId").value != "Doctor is available")
			{
			 alert(document.getElementById("tokenNoId").value);
			}
		else
			{
			submitFormForButton('generateReferralLetterPage','referral?method=generateExtension&employeeId='+document.getElementById("doctorId").value+'&referralPatientHeaderId=<%=referralPatientHeaderId%>');
			}
		
		}
	else{
		alert("Please check availability first");
	}
	
	
	
		
}
function updateReferralDetails(rowNum, referralPatientDetailsId){
	var empanelledHospitalId = document.getElementById("empanelledHospitalId").value
	var referralDate = document.getElementById("referralDate"+rowNum).value
	var referredFor = document.getElementById("referredFor"+rowNum).value
	var treatmentType = document.getElementById("treatmentType"+rowNum).value
	var doctorNote = document.getElementById("doctorNote"+rowNum).value
	var note = document.getElementById("note"+rowNum).value
	var validityPeriod = document.getElementById("validityPeriod"+rowNum).value
	var subject = document.getElementById("subject"+rowNum).value
	var wardId = document.getElementById("wardId"+rowNum).value
	
	submitFormForButton('generateReferralLetterPage','referral?method=updateReferralDetails&referralPatientDetailsId='+<%=referralPatientDetailsId%>+'&empanelledHospitalId='+empanelledHospitalId+'&referralDate='+referralDate+'&referredFor='+referredFor+'&treatmentType='+treatmentType+'&doctorNote='+doctorNote+'&note='+note+'&validityPeriod='+validityPeriod+'&subject='+subject+'&wardId='+wardId);
			
	
}



function wardDiv(val,refcount)
{
	if(val==2)
		{
		document.getElementById("wardDiv<%=refcount%>").show();
		}
	else
		{
		document.getElementById("wardDiv<%=refcount%>").hide();
		}
	
	}
	

function checkBillNo(rowNum) {
	
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
  var bill_no = document.getElementById("bill_no"+rowNum).value;
  var toHospital = document.getElementById("toHospital").value;
  
	
    var url='referral?method=checkBillNo&bill_no='+bill_no+'&toHospital='+toHospital
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
    	  

  	     var items =xmlHttp.responseXML.getElementsByTagName('dublicateBill')[0];      	
		if(items.innerHTML==="true")
			{
			alert("Bill No "+document.getElementById('bill_no'+rowNum).value+" already received for this hospital")
			document.getElementById('bill_no'+rowNum).value="";
			}
		
    }
  }
}

</script>





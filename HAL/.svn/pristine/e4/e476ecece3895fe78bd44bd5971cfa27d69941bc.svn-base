<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<%@page import="jkt.hms.masters.business.MasTherapyType"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>

<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%>

<%@page import="jkt.hms.masters.business.MasAnesthesia"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
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
</script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<%
Map map = new HashMap();
//String includedJsp = null;
if (request.getAttribute("map") != null) {
map = (Map) request.getAttribute("map");

}
List<Visit>dentalPatientDataList = new ArrayList<Visit>();
List<MasDisposal> disposalTypeList = new ArrayList<MasDisposal>();
if(map.get("dentalPatientDataList") != null){
	dentalPatientDataList=(List)map.get("dentalPatientDataList");
}
	List<MasFrequency>frequencyList = new ArrayList<MasFrequency>();
	List<MasAnesthesia> anesthesiaList = new ArrayList<MasAnesthesia>();
	if(map.get("frequencyList") != null){
		frequencyList=(List)map.get("frequencyList");
	}
	if(map.get("anesthesiaList") != null){
		anesthesiaList=(List)map.get("anesthesiaList");
	}
	if(map.get("disposalTypeList") != null){
		disposalTypeList=(List)map.get("disposalTypeList");
	}
	String patientName="";
	String reportingFor = "Dental";
	Patient patient = new Patient();
	String servicePersionName="";
	Visit visit = new Visit();
	if(dentalPatientDataList.size()>0){
	 visit=(Visit)dentalPatientDataList.get(0);
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

%>
 <script type="text/javascript">
	   var icdArray=new Array();

	</script>

<form name="dentalTreatment" action="" method="post">
<div class="titleBg">
<h2>Dental Treatment</h2>
</div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label>Service No.</label>

<label class="value"><%=patient.getServiceNo()!=null ?patient.getServiceNo(): ""  %></label>

<label>Patient Name</label>
 <label class="value"><%=patientName %></label>

<label>Relation</label>
 <label class="value"><%=patient.getRelation()!=null ?patient.getRelation().getRelationName(): ""  %></label>

 <label>Rank</label>
 <label class="value"><%=patient.getRank() != null ? patient.getRank().getRankName():"" %></label>

<label>Name</label>
 <label class="value"><%=servicePersionName %></label>

<label>Gender</label>
 <label class="value"><%=patient.getSex() != null ?patient.getSex().getAdministrativeSexName():"" %></label>
 <label>Age</label>
 <label class="value"><%=patient.getAge()!= null?patient.getAge():"" %></label>

<label>Trade/Branch</label>
 <label class="value"><%=patient.getTrade()!= null?patient.getTrade().getTradeName():"" %></label>

<label>Unit</label>
 <label class="value"><%=patient.getUnit()!= null?patient.getUnit().getUnitName():"" %></label>
</div>

<input type="hidden" name="visitId" value="<%=visit.getId()%>">
<input type="hidden" name="hinId" value="<%=patient.getId()%>">
<input name="departmentId"	type="hidden" value="<%=visit.getDepartment()!=null?visit.getDepartment().getId():0%>" />
<input	name="<%=VISIT_NUMBER%>" type="hidden" value="<%=visit.getVisitNo()%>" />
<input	name="<%=SERVICE_NO%>" type="hidden" value="<%=visit.getHin().getServiceNo()%>" />
<input name="deptId" type="hidden" value="<%=visit.getDepartment()!=null?visit.getDepartment().getId():0%>" />
<input name="<%=HIN_NO%>" type="hidden"	value="<%=visit.getHin().getHinNo()%>" />
<input name="hospitalIdForReport" id="hospitalIdForReport" type="hidden"	value="<%=visit.getHospital().getId()%>" />
<div class="clear"></div>
<div class="arrowlistmenu">

<ul class="categoryitems">

	<%-- <li><a href="appointment?method=showAppointmentPatientJsp">Appointments</a></li>
	<li><a href="appointment?method=showAppointmentInvestigationJsp">Investigation
	Appt.</a></li>
	<li><a href="opd?method=showPatientHistoryJsp&visitId=<%=visit.getId() %>">Patient History</a></li> --%>
	<li>
	<a href="#" onclick="openWindow('/hms/hms/dental?method=showPatientPreviousVisitForDental&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment()!=null?visit.getDepartment().getId():0%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&backFlag=dental')">
	Previous Visits </a>
	<!--<a href="#" onclick="submitFormForButton('dentalTreatment','opd?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment()!=null?visit.getDepartment().getId():0%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>')">
	Previous Visits </a>--></li>
	
	<%--<li><a href="opd?method=showPatientPreviousVisitForMedicalExamp&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo() %>">
	Previous Medical Exam </a></li>
	--%>
	<li>
	<a href="#" onclick="openWindow('/hms/hms/medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>&visitId=<%=visit.getId()%>&token=<%=visit.getTokenNo()%>&backFlag=dental')">
	Previous Medical Exams </a>
	<!--<a href="#" onclick="submitFormForButton('dentalTreatment','medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>&visitId=<%=visit.getId()%>&token=<%=visit.getTokenNo()%>')">
	Previous Medical Exams </a>--></li>
	<li>
	<a href="#" onclick="openWindow('/hms/hms/medicalExam?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment()!=null?visit.getDepartment().getId():0%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo()%>&token=<%=visit.getTokenNo()%>&backFlag=dental')">
	Previous Medical Boards</a>
	<!--<a href="#" onclick="submitFormForButton('dentalTreatment','medicalExam?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment()!=null?visit.getDepartment().getId():0%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo()%>&token=<%=visit.getTokenNo()%>')">
	Previous Medical Boards</a>--></li>
	<li><a href="#" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment()!=null?visit.getDepartment().getId():0%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&backFlag=dental')">
    Previous Hospitalizations</a></li>
	
<%-- 	<li><a
		href="opd?method=showPatientAllergicDrugsJsp&visitId=<%=visit.getId() %>">Patient
	Allergic Drugs</a></li>
	<li><a
		href="opd?method=showUploadingDocumentsJsp&visitId=<%=visit.getId() %>">Uploading
	documents </a></li>
	<li><a
		href="opd?method=getPatientDetailsForOPDOrderBooking&visitId=<%=visit.getId() %>">Order
	Booking </a></li>
	<li><a
		href="opd?method=showOpdTemplateDepartmentWiseJsp&visitId=<%=visit.getId() %>">Opd
	Template Department Wise</a></li>
	<li><a
		href="opd?method=showSurgeryRequisitionJsp&visitId=<%=visit.getId() %>">Surgery
	Requisition Form</a></li>
	 <li><a href="adt?method=showAdmissionJsp">Admitted Patient</a></li> --%>
	<li>
	<%-- Code for Open In popup mode
	Code By Mukesh 04 Oct 2011
	 --%>
	 <%--
	<a href="opd?method=showPatientPreviousVisitForPrescriptionReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>">
	Previous Prescriptions</a>
	 //opd?method=showPatientPreviousVisitForPrescriptionReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>
	 <li><a
		href="opd?method=showPatientPreviousVisitForInvestigationReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>">Previous
	Investigations</a></li>
	 --%>
	 <a href="#" onclick="javascript:openPopupPrescriptions(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getDepartment()!=null?visit.getDepartment().getId():0%>,<%=visit.getHin().getId()%>)">
	Previous Prescriptions</a>
	</li>
	<li>
	<a
		href="#" onclick="javascript:openPopupInvestigation(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getDepartment()!=null?visit.getDepartment().getId():0%>,<%=visit.getHin().getId()%>)">
		Previous Investigations</a></li>
		<%-- <li><a href="opd?method=showAllergyDetailsJsp&visitId=<%=visit.getId() %>&hinId=<%=visit.getHin().getId() %>">Allergies</a></li>--%>
		<%-- <li><a href="#" onclick="submitFormForButton('opdMain','adt?method=showMlcJsp&hinId=<%=visit.getHin().getId() %>')">MLC Details</a></li>--%>
	<li><a href="#" onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&visitId=<%=visit.getId() %>&token=<%=visit.getTokenNo()%>&backFlag=dental')">Upload Documents </a></li>
<%-- <li><a href="#">Drug Allergies</a></li> --%>
	<%--<li>Print AFMSF- 7A</li>
--%>
</ul>



<script type="text/javascript">


</script>
</div>
<div class="opdArea">

<h4>Patient Complaints</h4>
<div class="clear"></div>
<div class="Block">
<label>Main Complaint</label>
<select id="mainCompId" name="mainCompId" validate="Main Complaint,string,no" tabindex="1">
	<option value="">Select</option>
	<option value="Pain">Pain</option>
	<option value="Swelling">Swelling</option>
	<option value="Pain And Swelling">Pain And Swelling</option>

</select>

<label >Since</label>
<input tabindex="1"	type="text"  name="since" class="small" value=""
	onKeyUp="isNumber(this)" maxlength="2" />
<select id="sinceUnit" name="sinceUnit" class="small"	validate="Since,string,no" tabindex="1">
	<option value="0">Select</option>
    <option value="Days">Days</option>
    <option value="Weeks">Weeks</option>
    <option value="Months">Months</option>
    <option value="Year">Year</option>
</select>
<div class="clear"></div>
<label>Remarks</label>
<input type="text" name="sinceRemarks" tabindex="1" id="sinceRemarks" validate="Remarks,string,no" class="large" maxlength="40"/>
<div class="clear"></div>
<label>Associated Complaint</label>
<select id="associatedComplaint" name="associatedComplaint" validate="Associated Complaint,string,no" tabindex="1">
	<option value="">Select</option>
	<option value="Pain">Pain</option>
	<option value="Swelling">Swelling</option>
	<option value="Pain And Swelling">Pain And Swelling</option>

</select>
<label >Since</label>
<input tabindex="1"	type="text"   name="associatedSince" class="small" value=""	onKeyUp="isNumber(this)" maxlength="2" />
	<select id="associatedSinceUnit" name="associatedSinceUnit"	validate="Since,string,no" tabindex="1" class="small">
	<option value="0">Select</option>
    <option value="Days">Days</option>
    <option value="Weeks">Weeks</option>
    <option value="Months">Months</option>
    <option value="Year">Year</option>
</select>
<div class="clear"></div>
<label>Remarks</label>
<input type="text" name="associatedRemarks" tabindex="1" id="associatedRemarks" validate="Remarks,string,no" class="large" maxlength="40"/>
<div class="clear"></div>
<label>Complaint Description</label>
<textarea name="complaintDescriptions"
	id="complaintDescriptions" cols="20" rows="2" tabindex="1" maxlength="999"
	validate="Complaint Descriptions,string,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
<div class="clear"></div>
</div>

<div class="clear"></div>

<div class="clear"></div>

<h4>Oral Health Condition And Findings</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label >Total No. of Teeth</label>
 <input tabindex="1"	type="text"   name="<%=TOTAL_NO_OF_TEETH %>" class="small" value=""
	onKeyUp="isNumber(this)" maxlength="2" />
<label class="medium3">Total No. of Defective Teeth</label>
<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" value=""
	onKeyUp="isNumber(this)" maxlength="2" />
	<label class="medium3">Total no. of Dental Points</label>
<input tabindex="1"	type="text"   name="dentalPoints" class="small" value=""
	onKeyUp="isNumber(this)" maxlength="2" />
<div class="clear"></div>
<label >Missing </label>
<input tabindex="1"	type="text"   name="missingTeeth" class="small" value=""
	onKeyUp="isNumber(this)" maxlength="2" />
<label class="medium3">Unsaveable</label>
<input tabindex="1"	type="text"   name="unsaveableTeeth" class="small" value=""
	onKeyUp="isNumber(this)" maxlength="2" />
 <label class="medium3">Condition of Gums</label>
<input tabindex="1"	type="text"   name="conditionOfGums" id="txtAlpha" class="small" value=""
	validate="Condition of Gums,alphaspace,no" maxlength="100" />
	<div class="clear"></div>
</div>
<div class="clear"></div>
</div>
<input	type="hidden" name="dentalValue" id="dentalValueId" value="" />
<input type="hidden"  name="MissTeeth" id="MissTeeth123" value=""/>
<input type="hidden"  name="UnserTeeth" id="UnserTeeth123" value=""/>
<h4>Missing Teeth</h4>
<div class="Block">
<div class="clear"></div>
<label class="smallAuto" >UR</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_8%>" value="" class="radioAuto" id="d1" onclick="chkValueMissing(this);chkDentalValue(this);"  />
	<label class="smallAuto">18</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_7%>" value="" class="radioAuto" id="d2" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">17</label>
<input tabindex="1" type="checkbox"
	name="<%=MUR_6%>" value="" class="radioAuto" id="d3" onclick="chkValueMissing(this);chkDentalValue(this);" />
<label class="smallAuto">16</label>
<input tabindex="1" type="checkbox"
	name="<%=MUR_5%>" value="" class="radioAuto" id="d4" onclick="chkValueMissing(this);chkDentalValue(this);" />
<label class="smallAuto">15</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_4%>" value="" class="radioAuto" id="d5"  onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">14</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_3%>" value="" class="radioAuto" id="d6"  onclick="chkValueMissing(this);chkDentalValue(this);" />
<label class="smallAuto">13</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_2%>" value="" class="radioAuto" id="d7" onclick="chkValueMissing(this);chkDentalValue(this);" />
<label class="smallAuto">12</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_1%>" value="" class="radioAuto" id="d8"  onclick="chkValueMissing(this);chkDentalValue(this);" />
<label class="smallAuto">11</label>

<input tabindex="1" type="checkbox"
	name="<%=MUL_1%>" value="" class="radioAuto" id="d16" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">21</label>
	
<input tabindex="1" type="checkbox"
name="<%=MUL_2%>" value="" class="radioAuto" id="d15" onclick="chkValueMissing(this);chkDentalValue(this);" />
<label class="smallAuto">22</label>

<input tabindex="1" type="checkbox"
	name="<%=MUL_3%>" value="" class="radioAuto" id="d14" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">23</label>
	
<input tabindex="1" type="checkbox"
name="<%=MUL_4%>" value="" class="radioAuto" id="d13" onclick="chkValueMissing(this);chkDentalValue(this);" />
<label class="smallAuto">24</label>

<input tabindex="1" type="checkbox"
	name="<%=MUL_5%>" value="" class="radioAuto" id="d12" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">25</label>
	
<input tabindex="1" type="checkbox"
name="<%=MUL_6%>" value="" class="radioAuto" id="d11" onclick="chkValueMissing(this);chkDentalValue(this);" />
<label class="smallAuto">26</label>

<input tabindex="1" type="checkbox"
	name="<%=MUL_7%>" value="" class="radioAuto" id="d10" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">27</label>


<input tabindex="1" type="checkbox"
	name="<%=MUL_8%>" value="" class="radioAuto" id="d9" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">28</label>
	<label class="smallAuto">UL</label>
<div class="clear"></div>
<label class="smallAuto" >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_8%>" value="" class="radioAuto" id="d17"  onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">48</label>

<input tabindex="1" type="checkbox"
	name="<%=MLR_7%>" value="" class="radioAuto" id="d18"  onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">47</label>

<input tabindex="1" type="checkbox"
	name="<%=MLR_6%>" value="" class="radioAuto" id="d19" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">46</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_5%>" value="" class="radioAuto" id="d20" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">45</label>

<input tabindex="1" type="checkbox"
	name="<%=MLR_4%>" value="" class="radioAuto" id="d21" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">44</label>

<input tabindex="1" type="checkbox"
	name="<%=MLR_3%>" value="" class="radioAuto" id="d22" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">43</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_2%>" value="" class="radioAuto" id="d23" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">42</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_1%>" value="" class="radioAuto" id="d24" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">41</label>
	
<input tabindex="1" type="checkbox"
	name="<%=MLL_1%>" value="" class="radioAuto" id="d32" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">31</label> 
	
	<input tabindex="1" type="checkbox"
	name="<%=MLL_2%>" value="" class="radioAuto" id="d31" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">32</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=MLL_3%>" value="" class="radioAuto" id="d30" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">33</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=MLL_4%>" value="" class="radioAuto" id="d29" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">34</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=MLL_5%>" value="" class="radioAuto" id="d28" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">35</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=MLL_6%>" value="" class="radioAuto" id="d27" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">36</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=MLL_7%>" value="" class="radioAuto" id="d26" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">37</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=MLL_8%>" value="" class="radioAuto" id="d25" onclick="chkValueMissing(this);chkDentalValue(this);" />
	<label class="smallAuto">38</label>
	
	
	<label class="smallAuto">LL</label>
	<div class="clear"></div>

<h4>Unsaveable Teeth</h4>
<div class="clear"></div>
<label class="smallAuto">UR</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_8%>" value="" class="radioAuto" id="d33" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">18</label>

<input tabindex="1" type="checkbox"
	name="<%=UUR_7%>" value="" class="radioAuto" id="d34" onclick="chkValue(this);chkDentalValue(this);chkDentalValue(this);" />
	<label class="smallAuto">17</label>

<input tabindex="1" type="checkbox"
	name="<%=UUR_6%>" value="" class="radioAuto" id="d35" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">16</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_5%>" value="" class="radioAuto" id="d36" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">15</label>

<input tabindex="1" type="checkbox"
	name="<%=UUR_4%>" value="" class="radioAuto" id="d37" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">14</label>

<input tabindex="1" type="checkbox"
	name="<%=UUR_3%>" value="" class="radioAuto" id="d38" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">13</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_2%>" value="" class="radioAuto" id="d39" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">12</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_1%>" value="" class="radioAuto" id="d40" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">11</label>
	
<input tabindex="1" type="checkbox"
	name="<%=UUL_1%>" value="" class="radioAuto" id="d48" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">21</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=UUL_2%>" value="" class="radioAuto" id="d47" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">22</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=UUL_3%>" value="" class="radioAuto" id="d46" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">23</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=UUL_4%>" value="" class="radioAuto" id="d45" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">24</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=UUL_5%>" value="" class="radioAuto" id="d44" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">25</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=UUL_6%>" value="" class="radioAuto" id="d43" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">26</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=UUL_7%>" value="" class="radioAuto" id="d42" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">27</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=UUL_8%>" value="" class="radioAuto" id="d41" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">28</label>
<label  class="smallAuto">UL</label>

<div class="clear"></div>
<label  class="smallAuto">LR</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_8%>" value="" class="radioAuto" id="d49" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">48</label>

<input tabindex="1" type="checkbox"
	name="<%=ULR_7%>" value="" class="radioAuto" id="d50" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">47</label>

<input tabindex="1" type="checkbox"
	name="<%=ULR_6%>" value="" class="radioAuto" id="d51" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">46</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_5%>" value="" class="radioAuto" id="d52" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">45</label>

<input tabindex="1" type="checkbox"
	name="<%=ULR_4%>" value="" class="radioAuto" id="d53" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">44</label>

<input tabindex="1" type="checkbox"
	name="<%=ULR_3%>" value="" class="radioAuto" id="d54" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">43</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_2%>" value="" class="radioAuto" id="d55" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">42</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_1%>" value="" class="radioAuto" id="d56" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">41</label>
	
<input tabindex="1" type="checkbox"
	name="<%=ULL_1%>" value="" class="radioAuto" id="d64" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">31</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=ULL_2%>" value="" class="radioAuto" id="d63" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">32</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=ULL_3%>" value="" class="radioAuto" id="d62" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">33</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=ULL_4%>" value="" class="radioAuto" id="d61" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">34</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=ULL_5%>" value="" class="radioAuto" id="d60" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">35</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=ULL_6%>" value="" class="radioAuto" id="d59" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">36</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=ULL_7%>" value="" class="radioAuto" id="d58" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">37</label>
	
	<input tabindex="1" type="checkbox"
	name="<%=ULL_8%>" value="" class="radioAuto" id="d57" onclick="chkValue(this);chkDentalValue(this);" />
	<label class="smallAuto">38</label>
	
	<label class="smallAuto" >LL</label>
	
	
	
	
<div class="clear"></div>
<label>Treatable Tooth</label>

<input name="treatableTooth" value=""	id="treatableTooth" tabindex="1" maxlength="40" class="auto" size="50" />
<div class="clear"></div>
<label>Treatment Required</label>
<textarea name="teethRemarks" class="auto"  cols="60" rows="0" maxlength="400" 	tabindex="1" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"class="auto"></textarea>

</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>Diagnosis</h4>
<div class="clear"></div>
<div class="Block">


<div class="floatLeft">
<!-- 	<label >On Examination</label>  -->
<input	type="hidden" id="systamicExam" class="large" name="systamicExam"	maxlength="200" />
<label>Working Diagnosis</label>

<input name="workingDiagnosis" value=""	id="workingDiagnosis" tabindex="1" maxlength="100" class="auto" size="117" />

<div class="clear"></div>

<label>System Diagnosis</label>
<input 	name="systemDiagnosis" value=""	id="systemDiagnosis" tabindex="1" class="auto" onblur="" size="117" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('systemDiagnosis','ac2update','opd?method=autoCompleteForSystemDiagnosis',{parameters:'requiredField=systemDiagnosis'});
		</script>

<div class="clear"></div>
<%--
<label>ICD Code</label>
<input name="" value=""	id="icdCode" tabindex="1" class="auto" size="117" onblur="getIcd();" />
<input name="" value=""	id="temp" type="hidden" /> 
<IMG SRC="/hms/jsp/images/search.gif"	WIDTH="24" HEIGHT="20" style="cursor: pointer; margin:0px;" class="floatLeft"	onClick="javascript:openPopupWindow();"	title="Click here to Search ICD Codes" />
 --%>
<input type="hidden" name="ageName" value="<%=visit.getHin().getAge()%> " id="ageId" /> 

<div class="clear"></div>
<label>ICD Diagnosis</label>
<input type="text" tabindex="1"	value="" id="icd"  name="icd"	class="auto"  size="55" onblur="fillDiagnosisCombo(this.value);" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
		   //document.getElementById('slide0').style.display="hide"
</script>
<select name="<%=DIAGNOSIS_ID%>" multiple="4" size="5" tabindex="1"  id="diagnosisId" class="listBig">
	<option value="0">Select</option>
</select>

<input type="button" class="buttonDel" value="" 	onclick="deleteDgItems(this,'diagnosisId');" align="right" />
</div><!-- floatLeft ends -->
<div class="floatRight">

</div><!-- floatRight ends -->

</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<h4>Dental Procedure</h4>
<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="dentalGrid">
	<tr>
		<th scope="col">Teeth</th>
		<th scope="col">Treatment</th>
		<th scope="col">DTC</th>
		<th scope="col">Remarks</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<%int k=1;%>
	<tr>
	<td><select id="teethId<%=k %>" name="teeth<%=k %>" validate="Teeth,string,no" tabindex="1"  >
	<option value="0">Select</option>
	<%  for (int i=11; i < 49; i++) { %>
    <option value="<%=i %>"><%=i %></option>
    <%} %>
    
</select></td>
	<td><select id="dentalTreatment<%=k %>" name="dentalTreatment<%=k %>"	validate="Treatment,string,no" tabindex="1"  >
	<option value="0">Select</option>
    <option value="PI">PI</option>
    <option value="PII">PII</option>
    <option value="PIII">PIII</option>
</select></td>
	<td><select id="dtc<%=k %>" name="dtc<%=k %>"	validate="Since,string,no" tabindex="1" >
	<option value="0">Select</option>
    <option value="PI">PI</option>
    <option value="PII">PII</option>
    <option value="PIII">PIII</option>
    
</select></td>
	<td><input type="text" name="treatmentRemarks<%=k %>" tabindex="1" id="treatmentRemarks<%=k %>" validate="Treatment Remarks,string,no" size="70" maxlength="100"/>
</td>
	<td><input name="Button" type="button" class="buttonAdd" value="" tabindex="1" onclick="addDentalProcedureRow();" tabindex="1" /></td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('proceduregrid','hiddenValue',this);" tabindex="1" tabindex="1" />
			</td>
	
	</tr>
	</table>
	<input type="hidden" name="dentalCount" value="<%=k %>" id="dentalCount" />

<%-- 
<label>Treatment</label>
<select id="dentalTreatment" name="dentalTreatment"	validate="Treatment,string,no" tabindex="1"  >
	<option value="0">Select</option>
    <option value="1">PI</option>
    <option value="2">PII</option>
    <option value="3">PIII</option>
    
</select>
<label>DTC</label>
<select id="dtc" name="dtc"	validate="Since,string,no" tabindex="1" >
	<option value="0">Select</option>
    <option value="1">PI</option>
    <option value="2">PII</option>
    <option value="3">PIII</option>
    
</select>

<label>Remarks</label>
<input type="text" name="treatmentRemarks" tabindex="1" id="treatmentRemarks" validate="Treatment Remarks,string,no" size="10" maxlength="100"/>

--%>
<label>Anesthesia</label>
<select id="anesthesiaId" name="anesthesiaId"	validate="Since,string,no" tabindex="1"  >
	<option value="0">Select</option>
	<%for(MasAnesthesia masAnesthesia :anesthesiaList){ %>
	<option value="<%=masAnesthesia.getId() %>"><%=masAnesthesia.getAnesthesiaName() %></option>
	<%} %>
</select>

<label>Remarks</label>
<input type="text" name="anesthesiaRemark" tabindex="1" validate="Remarks,string,no" id="anesthesiaRemark" class="large" maxlength="100"/>


<label>Teeth Extracted</label>
<input type="text" name="teethExtracted" tabindex="1" id="remarks1" size="10" validate="Teeth Extract,int,no" maxlength="2"/>


<label>Teeth Conserved(With RT)</label>
<input type="text" name="teethConservesWithRt" tabindex="1" id="teethConservesWithRt" validate="Teeth Conserved(RT),int,no" size="10" maxlength="2"/>
<label>Without RT</label>
<input type="text" name="teethConservesWithOutRt" tabindex="1" id="teethConservesWithOutRt" size="10" validate="Teeth Conserved(withoutRT),int,no" maxlength="2"/>

<div class="clear"></div>
<h4>Dentures Fitted</h4>
<div class="clear"></div>


<label>New</label>
<input type="text" name="denturesFittedNew" tabindex="1" id="denturesFittedNew" size="10" validate="New,int,no"  maxlength="2"/>

<label>Remodels</label>
<input type="text" name="denturesFittedRemodels" tabindex="1" id="denturesFittedRemodels" size="10" validate="Remodels,int,no" maxlength="2"/>


<label>Repairs</label>
<input type="text" name="denturesFittedRepairs" tabindex="1" id="denturesFittedRepairs" validate="Remodels,int,no" size="10" maxlength="2"/>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="Block">
<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="proceduregrid">
	<tr>
		<th scope="col">Procedure Name</th>
		<th scope="col">Remarks</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<%int j=1;%>
	<tr>
		<td>
		<input type="hidden" name="visitProcedureId" id="visitProcedureId" value="" />
		<input type="hidden" name="proDtId<%=j %>" id="proDtId<%=j %>" value="" />
		<input type="text" name="procedure<%=j %>" id="procedure<%=j %>" value="" tabindex="1" size="70" onblur="if(this.value!=''){getProcedureId(this.value,1);}"/>
		   <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('procedure1','ac2update1','dental?method=getDentalProcedureForAutoComplete',{parameters:'requiredField=procedure1'});
			</script>
		<input type="hidden" name="procedureId<%=j %>" id="procedureId<%=j %>" 	value="" /> 
		</td>
		<td>	
			<input	type="text" name="remarks<%=j %>" value="" tabindex="1" id="remarks<%=j %>" size="70" />
			</td>
		<td><input name="Button" type="button" class="buttonAdd" value="" tabindex="1"
			onclick="addProcedureRow();" tabindex="1" /></td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('proceduregrid','hiddenValue',this);" tabindex="1" tabindex="1" />
			</td>
	</tr>
	
</table>
	<input type="hidden" name="procCount" value="<%=j %>" id="procCount" />

<label >Specialised Treatment</label>
<textarea name="specialisedTreatment" cols="50" rows="0" maxlength="900" 	tabindex="1" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"class="auto"></textarea>

</div>
</div>
<div class="clear"></div>
<h4>Investigation</h4>
<div class="clear"></div>
<div class="Block">
<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid">
	<tr>
		<th scope="col">Investigation Name</th>
		<th scope="col">Refer to MH/SMC</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>
		<%int inc=1;
%>
		<tr>
		<td>
		<input type="text" value="" tabindex="1" id="chargeCodeName1" size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
	
		<td><input type="checkbox" name="referToMh1" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td>
	
		<td><input name="Button" type="button" class="buttonAdd" value="" tabindex="1"
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" tabindex="1"
			onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


	</tr>
	
	

	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
</table>

<div class="clear paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid1">
	<tr>
		<th scope="col">Clinical Notes</th>
	</tr>
	<tr>
<td><input type="text" name="clinicalNotes1" id="clinicalNotes" tabindex="1" value="" size="100" maxlength="80" /></td>
	</tr>
</table>
</div>
</div>
<div class="clear paddingTop15"></div>
<h4>Treatment</h4>
<div class="Clear"></div>
<div class="cmntable">
<div id="testDiv">

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
		<td><input type="text" name="otherMedicine1" tabindex="1" id="otherMedicine1"  size="20" onblur="readOnlyNomenclature(this.value,'1');" validate="other Medicine,string,no" /></td>
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty1" tabindex="1" id="actualDispensingQty1" value=""  size="6"  validate="AU,string,no" /></td>
		
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

			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
     			 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%>
            <input type="hidden" name="frequencyValue1" id="frequencyValue1" value="">
		</td>

		<td><input type="text" name="noOfDays1" tabindex="1" id="noOfDays1" onblur="fillValue(this.value,'1')"  size="3"	maxlength="3" validate="No Of Days,num,no" />
			
		</td>
		<td><input type="text" name="route1" tabindex="1" id="route1" value="PO"  size="5" maxlength="20"	 validate="Route,string,no" />
			<input type="hidden" name="total1" tabindex="1" id="total1" />
		</td>
		
		<td><input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>
			</td>
			<td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td>
		<td><input type="text" name="closingStock1" tabindex="1" value="" id="closingStock1"  size="6"  validate="closingStock,string,no" /></td>
		
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
<label>Disposal</label>
<select name="disposal" size="0" tabindex="1" id="disposal" >
	<option value="">select</option>
	<% 
			for(MasDisposal masDisposalType : disposalTypeList){	
		%>
	<option value="<%=masDisposalType.getDisposalName() %>" ><%=masDisposalType.getDisposalName() %></option>
	<%}%>
	<!--<option value="ED">ED</option>
	<option value="MD">MD</option>
	<option value="LD">LD</option>
--></select>

<div id="daysDiv">
<label>Days</label>
<input name="days" type="text" tabindex="1" maxlength="2" id="days" size="20"  />
</div>
</div>
	
<div class="Clear"></div>
 <label>Next Visit Date  </label> 
 <input type="text" name="nextVisiDate" id="nextVisiDate" value="" maxlength="10"  class="calDate" onkeyup="mask(this.value,this,'2,5','/');" onblur="if(this.value!=''){validateExpDate(this,'medCatDate');checkDateGreaterEqualToCurrent(this.value,this);}"/>
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.dentalTreatment.nextVisiDate,event)" /> 
	<div class="Clear"></div>
	</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<div class="clear"></div>

<div class="division"></div>
<input name="Submit" type="button"	tabindex="1" align="right" class="button" value="Submit" onclick="submitForm('dentalTreatment','dental?method=submitDentalTreatmentDetails&flag=dental');" />
<input tabindex="1" class=button id="reset" accessKey="r"	onclick="resetCheck();" type="reset" value="Reset" name="Reset" />
<div class="clear"></div>
<div class="division"></div>
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

function submitOPDMainForm(){
	//	if(validateFieldValuesForMainSubmit()){
	var referedToMH =document.getElementById('referedToMH').value;
	 if(document.getElementById('referedToMH').checked == true){
			if(validateFrequency() && validateDays()){
				//submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=responseForDoctarsList&referredDepartmentId='+indexes+'','referredDoctarsIdDiv');
				
				submitForm('opdMain','opd?method=submitOPDPatientDetails&referedToMH=y&flag=opd');
		}
	 }else{
		 if(validateFrequency() && validateDays()){
				//submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=responseForDoctarsList&referredDepartmentId='+indexes+'','referredDoctarsIdDiv');
				
				submitForm('opdMain','opd?method=submitOPDPatientDetails&referedToMH=n&flag=opd');
		}
	 }
	}
function getProcedureId(val,inc){
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var procId = val.substring(index1,index2);
	document.getElementById('procedureId'+inc).value = procId;
	
}
function addDentalProcedureRow(){
	
	  var tbl = document.getElementById('dentalGrid');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('dentalCount');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  
	  var cell1 = row.insertCell(0);
	  var e1 = document.createElement('Select');
	  //e1.size = '70';
	  e1.name='teeth'+iteration;
	  e1.id='teethId'+iteration
	  e1.setAttribute('tabindex','1');
	  e1.options[0] = new Option('Select', '0');
	  <%  for (int i=11; i <49; i++) { %>
	  e1.options[<%=i%>] = new Option('<%=i%>', '<%=i%>');
	 <%}%>
	  cell1.appendChild(e1);
	  e1.focus();
	  
	  var cell11 = row.insertCell(1);
	  var e21 = document.createElement('Select');
	  e21.name='dentalTreatment'+iteration;
	  e21.id='dentalTreatment'+iteration
	  e21.setAttribute('tabindex','1');
	  e21.options[0] = new Option('Select', '0');
	  e21.options[1] = new Option('PI', '1');
	  e21.options[2] = new Option('PII', '2');
	  e21.options[3] = new Option('PIII', '3');
	  cell11.appendChild(e21);

	  
	  var cell12 = row.insertCell(2);
	  var e22 = document.createElement('Select');
	  e22.name='dtc'+iteration;
	  e22.id='dtc'+iteration
	  e22.setAttribute('tabindex','1');
	  e22.options[0] = new Option('Select', '0');
	  e22.options[1] = new Option('PI', '1');
	  e22.options[2] = new Option('PII', '2');
	  e22.options[3] = new Option('PIII', '3');
	  cell12.appendChild(e22);

	  var cell14 = row.insertCell(3);
	  var e23 = document.createElement('input');
	  e23.type = 'text';
	  e23.name='remarks'+iteration;
	  e23.id='remarks'+iteration
	  e23.size = '70';
	  e23.setAttribute('tabindex','1');
	  cell14.appendChild(e23);
	  
	  
	  var cell15 = row.insertCell(4);
	  var e31 = document.createElement('input');
	  e31.type = 'button';
	  e31.className = 'buttonAdd';
	  e31.name='Button'+iteration;
	  e31.onclick = function(){addDentalProcedureRow();}; 
	  e31.setAttribute('tabindex','1');
	  cell15.appendChild(e31);

	  var cell16 = row.insertCell(5);
	  var e41 = document.createElement('input');
	  e41.type = 'button';
	  e41.className = 'buttonDel';
	  e41.name='delete'+iteration;
	  //e41.setAttribute('onClick', 'removeRow();');
	  e41.onclick = function(){removeRow('dentalGrid','hiddenValue',this);};  
	  e41.setAttribute('tabindex','1');
	  cell16.appendChild(e41);
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
	  e1.size = '70';
	  e1.name='procedure'+iteration;
	  e1.id='procedure'+iteration
	  e1.setAttribute('tabindex','1');
	  e1.onblur=function() {getProcedureId(this.value,iteration);}
	  cell1.appendChild(e1);
	  e1.focus();
	  new Ajax.Autocompleter('procedure'+iteration,'ac2update1','dental?method=getDentalProcedureForAutoComplete',{parameters:'requiredField=procedure'+iteration});

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
	  e21.name='remarks'+iteration;
	  e21.id='remarks'+iteration
	  e21.size = '70';
	  e21.setAttribute('tabindex','1');
	  cell11.appendChild(e21);
	  
	  var cell12 = row.insertCell(2);
	  var e31 = document.createElement('input');
	  e31.type = 'button';
	  e31.className = 'buttonAdd';
	  e31.name='Button'+iteration;
	  e31.onclick = function(){addProcedureRow();}; 
	  e31.setAttribute('tabindex','1');
	  cell12.appendChild(e31);

	  var cell13 = row.insertCell(3);
	  var e41 = document.createElement('input');
	  e41.type = 'button';
	  e41.className = 'buttonDel';
	  e41.name='delete'+iteration;
	  //e41.setAttribute('onClick', 'removeRow();');
	  e41.onclick = function(){removeRow('proceduregrid','hiddenValue',this);};  
	  e41.setAttribute('tabindex','1');
	  cell13.appendChild(e41);
}

function removeRow()
{
  var tbl = document.getElementById('proceduregrid');
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  	tbl.deleteRow(lastRow - 1);
  	var tbl = document.getElementById('proceduregrid');
  	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
 	var iteration = lastRow - 1;
  	var hdb = document.getElementById('hdb');
  	hdb.value=iteration
  }
}

//=========To get Icd String with icd code==========================
function getIcd(){
var icdCode =document.getElementById("icdCode").value

 if(icdCode !="")
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
         icdString  = item.getElementsByTagName('icdString')[0];
         document.getElementById('icd').value =icdString.childNodes[0].nodeValue
         document.getElementById('icdCode').value="";
         fillDiagnosisCombo(document.getElementById('icd').value);
  }
  }
  }
var url="/hms/hms/adt?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)
xmlHttp.open("GET",url,true);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);

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
	  e4.onclick = function(){addRowForInvestigation();};
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

	  /*
	  var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('Select');

	  e6.name='instructionACPC'+iteration;
	  e6.id='instructionACPC'+iteration;
	  e6.classname='smalllabel';
	  e6.setAttribute('tabindex','1');
	  e6.options[0] = new Option('Select', '');
	  e6.options[1] = new Option('AC', 'AC');
	  e6.options[2] = new Option('PC', 'PC',true);
	  cellRight6.appendChild(e6);


	  var cellRight7 = row.insertCell(7);
	   var e7 = document.createElement('Select');

	  e7.name='typeLeftRight'+iteration;
	  e7.id='typeLeftRight'+iteration;
	  e7.classname='smalllabel';
	  e7.setAttribute('tabindex','1');
	   e7.options[0] = new Option('Select', '');
	   e7.options[1] = new Option('Left', 'left');
	   e7.options[2] = new Option('Right', 'right');
	   cellRight7.appendChild(e7);
*/


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
	  e8.onclick = function(){addRow();};
	  e8.setAttribute('tabindex','1');
	  cellRight10.appendChild(e8);

	  var cellRight11 = row.insertCell(11);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='remarks'+iteration;
	 // e9.setAttribute('onClick', 'removeRow("grid","hdb",this);'); 
	  e9.onclick = function(){removeRow("grid","hdb",this);};
	  e9.setAttribute('tabindex','1');
	  cellRight11.appendChild(e9);

	 
	  
	   //added - fayaz
	//  var cellRight9 = row.insertCell(9);
 //   var e9 = document.createElement('input');
//     e9.id = 'a'
//     e9.type = 'checkbox';
//    cellRight9.appendChild(e9);

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
function chkDentalValue(Obj)
{
	var newdentalValue="";
	var duplicate = new Boolean(false)
	var dstr=document.getElementById('dentalValueId').value;
	 var mySplitResult = dstr.split(",");
	 for(i=1;i<mySplitResult.length;i++)
	 {
		 if(mySplitResult[i]==Obj.id)
		 {
			 duplicate=true;
		 }else{
			 newdentalValue=newdentalValue+","+mySplitResult[i];

		 }
	 }
	 if(duplicate==false)
	 {
	dstr=dstr+","+Obj.id;
	document.getElementById('dentalValueId').value = dstr;
	 }else{
			document.getElementById('dentalValueId').value = newdentalValue;
		 }
}

function chkValueMissing(Obj)
{
	var newdentalValue="";
	var duplicate = new Boolean(false)
	var dstr=document.getElementById('MissTeeth123').value;
	 var mySplitResult = dstr.split(",");
	 for(i=1;i<mySplitResult.length;i++)
	 {
		 if(mySplitResult[i]==Obj.id)
		 {
			 duplicate=true;
		 }else{
			 newdentalValue=newdentalValue+","+mySplitResult[i];
		 }
	 }
	 if(duplicate==false)
	 {
		 if(dstr!=''){
			 dstr=dstr+",";
		 }
	dstr=dstr+Obj.id;
	document.getElementById('MissTeeth123').value = dstr;
	 }else{
			document.getElementById('MissTeeth123').value = newdentalValue;
	 }

}
function chkValue(Obj)
{
	var newdentalValue="";
	var duplicate = new Boolean(false)
	var dstr=document.getElementById('UnserTeeth123').value;
	 var mySplitResult = dstr.split(",");
	 for(i=1;i<mySplitResult.length;i++)
	 {
		 if(mySplitResult[i]==Obj.id)
		 {
			 duplicate=true;
		 }else{
			 newdentalValue=newdentalValue+","+mySplitResult[i];
		 }
	 }
	 if(duplicate==false)
	 {
		 if(dstr!=''){
			 dstr=dstr+",";
		 }
	dstr=dstr+Obj.id;
	document.getElementById('UnserTeeth123').value = dstr;
	 }else{
			document.getElementById('UnserTeeth123').value = newdentalValue;
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
   //document.getElementById('injCategory'+inc).disabled = true;	
   
	}else{
		document.getElementById('otherMedicine'+inc).readOnly = false;
		//document.getElementById('injCategory'+inc).disabled = false;	

	}
}
function readOnlyNomenclature(val,inc){
if(val != ""){
	alert("Please confirm PVMS/NIV is not available");
	 document.getElementById('nomenclature'+inc).readOnly = true;		
     document.getElementById('nomenclature'+inc).value ="";
     if(document.getElementById('itemId'+inc)){
    	 document.getElementById('pvmsNo'+inc).value = "";
     }
  }else{
	document.getElementById('nomenclature'+inc).readOnly = false;

  }
}
function getFrequencyValue(feqValue,inc){
	var feqQty;
<%
if(frequencyList.size()>0){	
	for(MasFrequency frequency :frequencyList){
%>
 if(feqValue == '<%=frequency.getId()%>'){
	 feqQty = '<%=frequency.getFeq()%>'
  }
<%}
}%>
 document.getElementById('frequencyValue'+inc).value = feqQty;
}

function  fillValue(value,inc){
	  var dosage = document.getElementById('dosage'+inc).value
	  var freq=document.getElementById('frequencyValue'+inc).value
	  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
	  var total = freq*value*dosage;
	  var finalQty;
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
	 }

	 function  fillValueFromFrequency(value,inc){
 	  var dosage = document.getElementById('dosage'+inc).value
	  var noOfDays=document.getElementById('noOfDays'+inc).value
	  var freq=document.getElementById('frequencyValue'+inc).value
	  document.getElementById('total'+inc).value=noOfDays*value*dosage
	  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
	  var total = freq*value*dosage;
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

function openPopupPrescriptions(visitId,visitNo,deptId,hinId)
{
 var url="/hms/hms/opd?method=showPatientPreviousVisitForPrescriptionReport&visitId="+visitId+"&visitNo="+visitNo+"&deptId="+deptId+"&hinId="+hinId;
 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
	 //alert("Detention Advice ....");
}

function openPopupInvestigation(visitId,visitNo,deptId,hinId)
{
 var url="/hms/hms/opd?method=showPatientPreviousVisitForInvestigationReport&visitId="+visitId+"&visitNo="+visitNo+"&deptId="+deptId+"&hinId="+hinId;
//opd?method=showPatientPreviousVisitForInvestigationReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment()!=null?visit.getDepartment().getId():0%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>"
 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
	 //alert("Detention Advice ....");
}
function isNumber(field) {
    var re = /^[0-9-'.'-',']*$/;
    if (!re.test(field.value)) {
        alert('please enter only numeric data');
        field.value = field.value.replace(/[^0-9-'.'-',']/g,"");
    }
}


function deleteDgItems(value){
    if(document.getElementById('diagnosisId').selectedIndex!=0){
	 if(confirm("Are you sure want to delete ?")){

	 		document.getElementById('diagnosisId').remove(document.getElementById('diagnosisId').selectedIndex)

	    }
	   }
    }
function openWindow(url){

    newwindow=window.open(url,'name',"left=2,top=100,height=500,width=900,status=1,scrollbars=1,resizable=0");
	
}

</script> 


</form>


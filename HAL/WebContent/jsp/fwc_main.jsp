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
<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>

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
	List patientDataList = new ArrayList();

	if(map.get("patientDataList") != null){
	patientDataList=(List)map.get("patientDataList");

	}
	int visitCount=0;
	if(map.get("visitCount") != null){
		visitCount=(Integer)map.get("visitCount");

		}	
	List<MasDisposal> disposalTypeList =null;

	if(map.get("disposalTypeList") != null){
				disposalTypeList= (List<MasDisposal>)map.get("disposalTypeList");
			}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> mapForDS= new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String consultationDate = (String)utilMap.get("currentDate");
	String consultationTime = (String)utilMap.get("currentTime");

	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
	hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	List templateList= new ArrayList();
	if(map.get("templateList") != null){
	templateList=(List)map.get("templateList");
	}
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null){
	frequencyList=(List)map.get("frequencyList");
	}
	List<PatientFamilyHistory> patientFamilyHistoryList=new ArrayList<PatientFamilyHistory>();
	if(map.get("patientFamilyHistoryList") != null){
		patientFamilyHistoryList=(List)map.get("patientFamilyHistoryList");
		}
	List<MasDepartment> deptList= new ArrayList<MasDepartment>();
	if(map.get("deptList") != null){
	deptList=(List)map.get("deptList");
	}
	List<MasTherapyType> therapyTypeList = new ArrayList<MasTherapyType>();
	if(map.get("therapyTypeList") != null){
		therapyTypeList=(List)map.get("therapyTypeList");
		}
	List<MasMedicalExaminationReportOnEntry> medicalList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	MasMedicalExaminationReportOnEntry meddata=new MasMedicalExaminationReportOnEntry();
	if(map.get("medicalList") != null){
		medicalList=(List)map.get("medicalList");
		}
	
	if(medicalList.size()>0)
	{
		meddata=(MasMedicalExaminationReportOnEntry)medicalList.get(0);
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	Visit visit=(Visit)patientDataList.get(0);

	String patientName="";
	String servicePersionName="";
	if(visit.getHin().getPFirstName()!= null){
	patientName=visit.getHin().getPFirstName();
	}
	if(visit.getHin().getPMiddleName()!= null){
	patientName=patientName+" "+visit.getHin().getPMiddleName();
	}
	if(visit.getHin().getPLastName()!= null){
	patientName=patientName+" "+visit.getHin().getPLastName();
	}
	String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	int deptId=0;
	String departmentName="";
	String departmentCode="";
	if(visit.getDepartment() !=null){
	deptId=visit.getDepartment().getId();
	departmentName=visit.getDepartment().getDepartmentName();
	 departmentCode=visit.getDepartment().getDepartmentCode();
	}
	%>
<!--main content placeholder starts here-->
<form name="fwcMain" action="" method="post">
<input type="hidden" name="userName" value="<%=userName %>" /> <%if(visit.getDepartment()!= null){ %>
<div class="titleBg"><h2>OPD- Main</h2></div>
<div class="clear"></div>
<%} %>
 <script type="text/javascript">
	   var icdArray=new Array();

	</script> <%
			if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
			  }
	    %> <!--Block One Starts-->
<h4>Patient Details</h4>

<div class="clear"></div>
<div class="Block">
<% 

if(visit.getHin().getRelation()!=null&&visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self"))
{ 
%>
<label>Service No.</label>
 <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label>Patient Name</label> 
<%if(visit.getHin() != null){
		Patient patient =visit.getHin();
	if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){

					String sMiddleName = "";
					String sLastName = "";
					if(patient.getSMiddleName() != null){
						sMiddleName = patient.getSMiddleName();
					}
					if(patient.getSLastName() != null){
						sLastName = patient.getSLastName();
					}%> <label
	class="value"><%=patient.getSFirstName()+" "+sMiddleName+" "+sLastName %></label> <%}}else{ %> <label class="value"></label>
<%} %>
<label>Relation</label>
 <%if(visit.getHin().getRelation()!= null){ %>
<label class="value"><%=visit.getHin().getRelation().getRelationName() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>

<div class="clear"></div>
<label>Rank</label>
<%if(visit.getHin().getRank()!= null){ %>
<label class="value"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>

<label>Name</label> 
<%if(visit.getHin() != null){
		Patient patient =visit.getHin();
		
		
	if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){

					String sMiddleName = "";
					String sLastName = "";
					if(patient.getSMiddleName() != null){
						sMiddleName = patient.getSMiddleName();
					}
					if(patient.getSLastName() != null){
						sLastName = patient.getSLastName();
					}
					servicePersionName=patient.getSFirstName()+" "+sMiddleName+" "+sLastName;
					}%> <label
	class="value"><%=patientName %></label> 
<%} %>

<label>Trade/Branch</label>
 <%if(visit.getHin().getTrade() != null){ %>
<label class="value"><%=visit.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
<div class="clear"></div>
 <label>Unit</label>
 <%if(visit.getHin().getUnit() != null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>

<label >Age</label> 
<%if(visit.getAge()!= null){ %>
<label class="value"><%=visit.getAge() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
 <label>Gender</label>
 <%if(visit.getHin().getSex() != null){ %>
<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
<div class="clear"></div>
<label >Occupation</label> 
<%if(visit.getHin().getOccupation()!= null){ %>
<label class="value"><%=visit.getHin().getOccupation().getOccupationName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label >Marital Status</label> 
<%if(visit.getHin().getSrMaritalStatus()!= null){ %>
<label class="value"><%=visit.getHin().getSrMaritalStatus().getMaritalStatusName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %> 

<label >Blood Group</label>
<%-- 
<%
if(visit.getHin() != null){
if(visit.getHin().getBloodGroup() != null){ %>
<label class="value"><%=visit.getHin().getSrBloodGroup().getBloodGroupName() %></label>
<%}}else{ %>
<label class="value">&nbsp;</label> 
<%} %>--%>
<div class="clear"></div>
<label >Medical Category</label>
<%if(meddata.getPresentMedicalCategory() != null){ %>
<label class="value"><%=meddata.getPresentMedicalCategory().getCategories() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label>Date</label>
<%if(meddata.getDateOfReporting() != null){ %>
<label class="value"><%=meddata.getDateOfReporting() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
 
<label >Medical Disability</label>
<%if(meddata.getPresentDisability()!= null){ %>
<label class="value"><%=meddata.getPresentDisability().getDisability() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
<div class="clear"></div>
<!-- <label >Medication</label> -->
<%--if(meddata.getInstructionByPresident() != null){ --%>
<!-- <label class="value">meddata.getInstructionByPresident()</label> -->
<%--}else{ --%>
<!-- <label class="value">&nbsp;</label> }-->
<div class="clear"></div>
<!-- <label >Allergies</label> -->
<%--if(visit.getHin() != null){ --%>
<!-- <label class="value">&nbsp;</label> -->
<%--}else{ --%>
 <!--  <label class="value">&nbsp;</label>  -->

 <%--} --%>
<div class="floatRight paddRight47">
<label>Current Year's Visit</label> 
<label class="value"><%=visitCount%></label> 
</div>
<%--
<%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visitCount%></label> 
<%}else{ %> 
<label class="value">&nbsp;</label><%} %>
 --%>
 <% }else{%>
 
<label>Service No.</label>
 <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label	>Patient Name</label> 
<%if(visit.getHin() != null){
		Patient patient =visit.getHin();
				
	if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){

		String sMiddleName = "";
		String sLastName = "";
		if(patient.getSMiddleName() != null){
			sMiddleName = patient.getSMiddleName();
		}
		if(patient.getSLastName() != null){
			sLastName = patient.getSLastName();
		}
		servicePersionName=patient.getSFirstName()+" "+sMiddleName+" "+sLastName;
		}%> <label
	class="value"><%=patientName %></label> 
<%} %>
<label>Relation</label>
 <%if(visit.getHin().getRelation()!= null){ %>
<label class="value"><%=visit.getHin().getRelation().getRelationName() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>

<div class="clear"></div>
<label >Rank</label>
<%if(visit.getHin().getRank()!= null){ %>
<label class="value"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="value"></label> <%} %>

<label>Name</label>
<label class="value"><%=servicePersionName %></label>

<label>Trade/Branch</label>
 <%if(visit.getHin().getTrade() != null){ %>
<label class="value"><%=visit.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
 
<div class="clear"></div>

 <label>Unit</label>
 <%if(visit.getHin().getUnit() != null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
<label >Age</label> 
<%if(visit.getAge()!= null){ %>
<label class="value"><%=visit.getAge() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>


 <label>Sex</label>
 <%if(visit.getHin().getSex() != null){ %>
<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
 
 <div class="clear"></div>
 
<label >Occupation</label> 
<%if(visit.getHin().getOccupation()!= null){ %>
<label class="value"><%=visit.getHin().getOccupation().getOccupationName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label >Marital Status</label> 
<%if(visit.getHin().getMaritalStatus() != null){ %>
<label class="value"><%=visit.getHin().getMaritalStatus().getMaritalStatusName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label> 
<%} %> 

<label >Blood Group</label>
<%if(visit.getHin().getBloodGroup() != null){ %>
<label class="value"><%=visit.getHin().getBloodGroup().getBloodGroupName() %></label>
<%}else{ %>
<label class="value">&nbsp;</label> <%} %>
 <div class="clear"></div>
<!-- <label >Allergies</label> -->
<%--if(visit.getHin() != null){ --%>
<!-- <label class="value">&nbsp;</label> -->
<%--}else{ --%>
 <!--<label class="value">&nbsp;</label> -->
 <%--} --%>

<label >Current Year's Visit</label> 
<label class="value"><%=visitCount%></label> 
<%-- 
<%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label> 
<%}else{ %> 
<label class="value">&nbsp;</label><%} %>
 --%>
<% }%>
<div class="clear"></div>
</div>
<div class="arrowlistmenu">

<ul class="categoryitems">

	<!-- <li><a href="appointment?method=showAppointmentPatientJsp">Appointments</a></li>
	<li><a href="appointment?method=showAppointmentInvestigationJsp">Investigation
	Appt.</a></li>
	<li><a href="fwc?method=showPatientHistoryJsp&visitId=<%=visit.getId() %>">Patient History</a></li> -->
	<li><a href="fwc?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>">
	Previous Visit </a></li>
	
	<!--<li><a href="fwc?method=showPatientPreviousVisitForMedicalExamp&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo() %>">
	Previous Medical Exam </a></li>
	-->
	<li><a href="medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>">
	Previous Medical Exam </a></li>
	<li><a href="medicalExam?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo() %>">
	Previous Medical Board</a></li>
	<li><a href="fwc?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>">
    Previous Hospitalization</a></li>
		
<!-- 	<li><a
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
	 <li><a href="adt?method=showAdmissionJsp">Admitted Patient</a></li> -->
	<li>
	<!-- Code for Open In popup mode
	Code By Mukesh 04 Oct 2011
	 -->
	 <%--
	<a href="opd?method=showPatientPreviousVisitForPrescriptionReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>">
	Previous Prescriptions</a>
	 //opd?method=showPatientPreviousVisitForPrescriptionReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>
	 <li><a
		href="opd?method=showPatientPreviousVisitForInvestigationReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>">Previous
	Investigations</a></li>
	 --%>
	 <a href="javascript:openPopupPrescriptions(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getDepartment().getId()%>,<%=visit.getHin().getId()%>)">
		Previous Prescriptions</a>
	</li>
	<li>
	<a
		href="javascript:openPopupInvestigation(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getDepartment().getId()%>,<%=visit.getHin().getId()%>)">
		Previous Investigations</a></li>
		<li><a
		href="fwc?method=showPatientAllergicDrugsJsp&visitId=<%=visit.getId() %>">Patient
	Allergic Drugs</a></li>
	<li><a
		href="fwc?method=showUploadingDocumentsJsp&visitId=<%=visit.getId() %>">Uploading
	documents </a></li>
<!-- <li><a href="#">Drug Allergies</a></li> -->
	<!--<li>Print AFMSF- 7A</li>
-->

<!-- 	<li><a
		href="fwc?method=showPatientAllergicDrugsJsp&visitId=<%=visit.getId() %>">Patient
	Allergic Drugs</a></li>
	<li><a
		href="fwc?method=showUploadingDocumentsJsp&visitId=<%=visit.getId() %>">Uploading
	documents </a></li>
	<li><a
		href="fwc?method=getPatientDetailsForFWCOrderBooking&visitId=<%=visit.getId() %>">Order
	Booking </a></li>
	<li><a
		href="fwc?method=showOpdTemplateDepartmentWiseJsp&visitId=<%=visit.getId() %>">Opd
	Template Department Wise</a></li>
	<li><a
		href="fwc?method=showSurgeryRequisitionJsp&visitId=<%=visit.getId() %>">Surgery
	Requisition Form</a></li>
	 <li><a href="adt?method=showAdmissionJsp">Admitted Patient</a></li> -->
	<li>
	<!-- Code for Open In popup mode
	Code By Mukesh 04 Oct 2011
	 -->
	 <%--
	<a href="fwc?method=showPatientPreviousVisitForPrescriptionReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>">
	Previous Prescriptions</a>
	 //fwc?method=showPatientPreviousVisitForPrescriptionReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>
	 <li><a
		href="fwc?method=showPatientPreviousVisitForInvestigationReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>">Previous
	Investigations</a></li>
	 --%>
	 <a href="javascript:openPopupPrescriptions(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getDepartment().getId()%>,<%=visit.getHin().getId()%>)">
	Previous Prescriptions</a>
	</li>
	<li>
	<a
		href="javascript:openPopupInvestigation(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getDepartment().getId()%>,<%=visit.getHin().getId()%>)">
		Previous Investigations</a></li>

	<li><a
		href="javascript:submitForm('fwcMain','fwc?method=showAntenatalCardJsp&flag=antenatal');">Antenatal
	Card</a></li>
	<li><a
		href="javascript:submitForm('fwcMain','fwc?method=submitFWCPatientDetails&flag=obg');">OBG
		</a></li>
	<li>
	
	<input type="button" class="button" value="Pediatrics" onclick="validateFieldValuesPediatricsOpd();" align="right" />	
	</li>
</ul>

<script type="text/javascript">

function validateFieldValuesPediatricsOpd(){

	var ageId=document.getElementById("ageId").value
	var age = ageId.substring(0,2);
	var ageIntoInt=parseInt(age);
	if(ageIntoInt<=15)
	{
		submitForm('fwcMain','fwc?method=submitFWCPatientDetails&flag=pediatric');  
		//submitForm('fwcMain','fwc?method=showPediatricCaseSheetJsp&visitId=<%=visit.getId()%>');  
		return true;
		   		
	}
	else
	{
		alert("Age cannot be more than 15 years");
		return false;
	}
	return true;
}
function validateFieldValuesForMainSubmit(){

	//var dateSelected=document.getElementById("nextVisitDate").value
	//if(document.getElementById('diagnosisId').length == 1) {
	//	alert("Please Enter the diagnosis of the Patient.");
	//    return false;
	//}
	if(dateSelected != "")
	{
			var visitDate = new Date(dateSelected.substring(6),(dateSelected.substring(3,5) - 1) ,dateSelected.substring(0,2))
			var currentDate = new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2))
				if(visitDate<currentDate)
			    {
					document.getElementById("nextVisitDate").value="";
					alert("Visit Date can not be less than current date.")
					return false;
			    }
    }
    return true;
}

function validateFieldValues(){

	var dateSelected=document.getElementById("nextVisitDate").value
	//if(document.getElementById('diagnosisId').length == 1) {
	//	alert("Please Enter the diagnosis of the Patient.");
	//   return false;
	//}
	if(dateSelected != "")
	{
			var visitDate = new Date(dateSelected.substring(6),(dateSelected.substring(3,5) - 1) ,dateSelected.substring(0,2))
			var currentDate = new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2))
				if(visitDate<currentDate)
			    {
					document.getElementById("nextVisitDate").value="";
					alert("Visit Date can not be less than current date.")
					return false;
			    }
    }
    return true;
}
function validateFieldValuesPediatricsFwc(){

	var ageId=document.getElementById("ageId").value
	var age = ageId.substring(0,2);
	var ageIntoInt=parseInt(age);
	if(ageIntoInt<=15)
	{
		var dateSelected=document.getElementById("nextVisitDate").value
		//if(document.getElementById('diagnosisId').length == 1)
	    //  {
	    //    alert("Please Enter the diagnosis of the Patient.");
	    //    return false;
	    //  }
		if(dateSelected != "")
		{
			var visitDate = new Date(dateSelected.substring(6),(dateSelected.substring(3,5) - 1) ,dateSelected.substring(0,2))
			var currentDate = new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2))
				if(visitDate<currentDate)
			    {
				document.getElementById("nextVisitDate").value="";
				alert("Please enter the correct Visit date.")
				return false;
			    }
  	  }
    return true;
   }
   	else
   	{
    	alert("Not more 15 years.");
    	return false;
	}
  return true;
}

function openpopforItemSearch(){
	    var url="/hms/hms/fwc?method=showItemSearchJsp&count="+1;
	    newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	}

	function jsSetUnitData(id,pvms,nomenclature,count)
	{
	document.getElementById('nomenclature'+count).value = nomenclature+'['+pvms+']'
	document.getElementById('nomenclature'+count).focus();
	}


</script>
</div>


<div class="opdArea">

<label>Return from Hospital</label>
<input type="checkbox" name="returnfromHospital" class="radio" id="returnValue" value="false"  onchange="valueChange()"/>
<div class="clear"></div>
<div id=hospidataId style="display: none">
<label>Hospital Name</label>
<input type="text" name="hospName" tabindex="1" size="100" maxlength="150" />
<label class="medium">DOA</label> <input	type="text" name="doa"  class="date" id="doa"	MAXLENGTH="30" validate="Pick a from date,date,no" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="javascript:setdate('doa',document.fwcMain.doa, event)"	validate="Pick a date"  />
<label class="medium">DOD</label> <input	type="text" name="dod" value="" class="date" id="dod"	MAXLENGTH="30" validate="Pick a from date,date,no" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="javascript:setdate('dod',document.fwcMain.dod, event)" validate="Pick a date"  /> 
<label >Advise on Discharge</label>
<textarea name="adviceOnDischarge" cols="0" rows="0"  maxlength="300"	value=""  tabindex="1" onkeyup="return ismaxlength(this)"></textarea>
<div class="clear"></div>

<label >Diagnosis</label>
<input type="text"  class="auto" size="48" 	id="pastDiagnosis" tabindex="1" value="" name="pastDiagnosis" maxlength="100" />
<label class="medium">Disposal</label>
<select name="pastdisposal" size="0" tabindex="1" class="med">
	<option value="0">select</option>
	<% 
			for(MasDisposal masDisposalType : disposalTypeList){	
		%>
	<option value="<%=masDisposalType.getDisposalName() %>" selected="selected"><%=masDisposalType.getDisposalName() %></option>
	<%}%>
	</select>
<!-- 	
<select name="pastdisposal" size="0" tabindex="1" class="med">
	<option value="0">select</option>
	<option value="ED">ED</option>
	<option value="MD">MD</option>
	<option value="LD">LD</option>
</select>
 -->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</div>
<div class="clear"></div>
<div class="floatLeft">
<label >Complaints</label> <!--  <input type="text" id="presentComplain"  name="presentComplain" maxlength="100"/>-->
<textarea name="presentComplain" cols="0" rows="0"  maxlength="300"	value=""  tabindex="1" onkeyup="return ismaxlength(this)"></textarea>
<div class="clear"></div>
<label >Past Medical History</label> <!--  <input type="text" id="presentComplain"  name="presentComplain" maxlength="100"/>-->
<textarea name="pastMedicalHistory" cols="0" rows="0"  maxlength="300"	value=""  tabindex="1" onkeyup="return ismaxlength(this)"></textarea>
<div class="clear"></div>
<label>Family History</label> <!--  <input type="text" id="presentComplain"  name="presentComplain" maxlength="100"/>-->
<select name="familyHistory" id="familyHistory" class="med">
	<option value="0">select</option>
		<%
	if(patientFamilyHistoryList.size()>0){
		for(PatientFamilyHistory patientFamilyHistory:patientFamilyHistoryList){
	%>
	<option value="<%=patientFamilyHistory.getPatientHistoryName() %>"><%=patientFamilyHistory.getPatientHistoryName() %></option>
	<%		
		}
	}
	%>
</select>
<!-- <textarea name="familyHistory" cols="0" rows="0"  maxlength="300"	value=""  tabindex="1" onkeyup="return ismaxlength(this)"></textarea> -->
<div class="clear"></div>
<label >Risk Factor</label> <!--  <input type="text" id="presentComplain"  name="presentComplain" maxlength="100"/>-->
<textarea name="riskFactor" cols="0" rows="0"  maxlength="300"	value=""  tabindex="1" onkeyup="return ismaxlength(this)"></textarea>
</div><!-- floatLeft ends-->
<div class="floatRight"><input	name="investigationTemplate" type="button" onclick="showSymptom()" class="btn_Symptomp_Assist"	tabindex="1"  /></div><!-- float Right ends -->
<div class="clear"></div>
</div><!-- opdarea ends -->
<div class="clear"></div>
<!--  Commented On Date 20 Sep 2011 By Mukesh as per New SRS -->
<!-- 
<h4>Examination</h4>
<div class="Block">
<label>General Phys Exam</label>

<input type="text" name="gpe_examination" tabindex="1" size="123" maxlength="150" class="auto" />
<div class="clear"></div>
</div>
 -->
<div class="clear paddingTop15"></div>

<h4>Vitals</h4>
<div class="Block">
<label class="medium">Weight</label>
<input name="weight" tabindex="1" type="text"	 id="weight" value=""  onblur="calculateBMI()" class="auto" size="5" validate="weight,int,no" maxlength="3" />
<label class="small">kg</label> 

<label  class="medium">Height</label> 
<input name="height" tabindex="1" type="text" id="height" class="auto" onblur="calculateBMI()" size="5" validate="height,int,no"  maxlength="3" />
<label	class="small">cm</label>

 <label	class="medium">BMI</label> 
<input tabindex="1" type="text" id="bmi" name="bmi"  maxlength="6" onKeyUp="limitText(this,6);" class="auto" size="5" />
<label class="small">kg/m</label> 
<label	class="medium">WHR</label>
 <input name="whr" type="text" tabindex="1" class="auto" size="5" tabindex="1" validate="whr,metachar,no" maxlength="3" />

  <div class="clear"></div>
 <label class="medium">Temperature</label>
 <input name="temperature" type="text" tabindex="1" class="auto" size="5" maxlength="5" />
 <label	class="small">&deg;F</label>
 <label	class="medium">Pulse</label>
 <input name="pulse" type="text" tabindex="1" class="auto" size="5" tabindex="1" validate="pulse,int,no" maxlength="3" />
 <label class="small">/min</label> 
 <label class="medium">BP</label>
 <input	name="bp" id="bp" type="text" tabindex="1" class="auto" size="5" onblur="validateBpValue(this.value);" maxlength="7" />
 <label	class="small">mm/Hg</label>
 <label class="medium">RR</label>
 <input	name="rr" id="rr" type="text" tabindex="1" class="auto" size="5" maxlength="3" />
 <label	class="small">/min</label>


<div class="clear"></div>
 
 <label>On Examination</label>	
<textarea name="onExamination" cols="120" rows="0" maxlength="300" class="auto" tabindex="1" onkeyup="return ismaxlength(this)"></textarea>
  <div class="clear"></div>

<input type="hidden" name="userName" value="<%=userName %>" />
<div class="clear"></div>
</div>
<div class="clear paddingTop15"></div>
<h4>Diagnosis</h4>
<div class="Block">

<div class="floatLeft">
<!-- 	<label >On Examination</label>  -->
<input	type="hidden" id="onExamination" class="large" name="onExamination"	maxlength="200" />
<label>Working Diagnosis</label>
<% if(visit.getDiagnosisString()!=null)
{%>
<input type="text" class="auto"  size="123" 	id="initialDiagnosis" tabindex="1" value="<%=visit.getDiagnosisString() %>"	name="initialDiagnosis" maxlength="100" />
<% }else{%>
<input type="text" class="auto"  size="123" 	id="initialDiagnosis" tabindex="1" value=""	name="initialDiagnosis" maxlength="100" />

<% }%>
<div class="clear"></div>

<label>System Diagnosis</label>
<input name="" value=""	id="systemDiagnosis" tabindex="1" class="auto" size="117" />

<div class="clear"></div>
<%--
<label>ICD Code</label>
<input name="" value=""	id="icdCode" tabindex="1" class="auto" size="117" onblur="getIcd();" />
<input name="" value=""	id="temp" type="hidden" /> 
<IMG SRC="/hms/jsp/images/search.gif"	WIDTH="24" HEIGHT="20" style="cursor: pointer; margin:0px;" class="floatLeft"	onClick="javascript:openPopupWindow();"	title="Click here to Search ICD Codes" />
 --%>

<input type="hidden"	name="ageName" value="<%=visit.getHin().getAge() %>" id="ageId" /> 

<div class="clear"></div>
<label>ICD Diagnosis</label>
<input type="text" tabindex="1"	value="" id="icd"  name="icd"	class="auto"  size="55" onblur="fillDiagnosisCombo(this.value);" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','fwc?method=getICDList',{parameters:'requiredField=icd'});
		   //document.getElementById('slide0').style.display="hide"
</script>
<select name="<%=DIAGNOSIS_ID%>" multiple="4" size="5" tabindex="1"  id="diagnosisId" class="listBig">
	<option value="0">Select</option>
</select>

<input type="button" class="buttonDel" value="" 	onclick="deleteDgItems(this,'diagnosisId');" align="right" />
</div><!-- floatLeft ends -->
<div class="floatRight">
<input	name="investigationTemplate" type="button"	onclick="showDiagnosis()" tabindex="1" class="btn_Diagnosis_Assist" />
</div><!-- floatRight ends -->


</div>
<div class="clear"></div>
<!-- fayaz added -->
<h4>Investigation</h4>
<%--
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
<input	name="Prevoius" type="button" value="Previous" tabindex="1"	class="btn_template "	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />
<div id="createInvestigationDivToShowHide">
<input	name="investigationTemplate" type="button"	value="Create Template" tabindex="1" class="btn_template " onclick="showCreateInvestigationTemplate();" />
</div>
<div id="copyPrevInvestigationTemplateDiv" style="display: none">
<input name="copyPrevInvestigationTemplate" tabindex="1" type="button"	value="Copy Previous" class="btn_template " onclick="copyPrevInvestigationTempate('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>');" />
</div>
<div id="investigationImportButton1" >
<input	name="investigationImportButton1" tabindex="1" type="button"	value="Import New" class="btn_template "	onclick="getListForTreatment('investigationDiv');" />
</div>
</div>
--%>
<div class="clear"></div>
<div class="Block">
<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Test Name</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>

	<tr>
		<td>
		<%int inc=1; %> <input type="text" value="" tabindex="1"
			id="chargeCodeName1" size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','fwc?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRowForInvestigation();" /></td>


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
		<td><input type="text" name="clinicalNotes1" tabindex="1"
			size="100" maxlength="45" /></td>

	</tr>
</table>
</div>
</div>


<div class="clear paddingTop15"></div>
<h4>Treatment</h4>
<div class="floatRight"><input	name="treatmentTemplate" type="button"	tabindex="1" onclick="showTreatment()" class="btn_Treatment_Assist" />
</div>
<div id="templateDivToShowHide" class="floatLeft">
<!-- 
<div class="Block">

<label>Template</label>
<div id="treatmentDiv">
<select name="templateId" id="templateId" tabindex="1" onchange="showHideDrugTemplateCombo(this.value);">
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

<div id="prevButtonDivToShowHide">
<input name="Prevoius2"	tabindex="1" type="button" value="Previous" class="button"	onclick="openPopupForPatientPrescription('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>','<%=visit.getDepartment().getId()%>','<%=visit.getId()%>')" />
</div>
<div id="createPresDivToShowHide">
<input 	name="createPrescriptionTemplate" tabindex="1" type="button" value="Create Template"    class="buttonBig" onclick="showCreatePrescriptionTempate();" />
</div>
<div id="copyPrevPrescriptionTemplateDiv" style="display: none;">
<input name="copyPrevPrescriptionTemplate" tabindex="1" type="button" value="Copy Previous" class="buttonBig"	onclick="copyPrevPrescriptionTempate('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>');" />
</div>

<div id="prescriptionImportButton" >
<input	name="prescriptionImportButton1" tabindex="1" type="button"	value="Import New" class="button"	onclick="getListForTreatment('treatmentDiv');" />
</div>
</div>
 -->
<div id="testDiv">
<!--<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid1">
	<tr>
	<th scope="col">Remarks</th>

	<td><input type="text" name="remaks" tabindex="1"
			size="120" maxlength="45" /></td></tr>
	</table>
	-->
	<div class="medTable">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

	<tr>
		 <th colspan="2">Nomenclature</th>
	<!-- <th scope="col">PVMS No.</th> -->
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<!--  <th scope="col">Total</th>
		<th scope="col">Intake</th> -->
		<th scope="col">Route</th>
		<!--<th scope="col">Type</th>-->
		<th scope="col">Remarks</th>
		<th>Add</th>
		<th>Delete</th>
		
	</tr>
	<tr>
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature1" size="30"  name="nomenclature1" onblur="populatePVMS(this.value,'1'),checkItem();"  />
	    </td>
	    <td>
	    <IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();" title="Click here to Search for Nomenclature">
	     <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2update1','fwc?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>
		<td><input type="hidden" name="pvmsNo1" tabindex="1" id="pvmsNo1"	size="10" readonly="readonly" />
		<input type="text" name="dosage1" tabindex="1" id="dosage1"	size="5" maxlength="5" /></td>
		<td><select name="frequency1" id="frequency1" tabindex="1"onclick="fillValueFromFrequency(this.value,'1');">
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
		</td>

		<td><input type="text" name="noOfDays1" tabindex="1" id="noOfDays1" onblur="fillValue(this.value,'1')" size="3"	maxlength="3" validate="No Of Days,num,no" />
			
		</td>
		<td><input type="text" name="route1" tabindex="1" id="route1"  size="10" maxlength="20"	 validate="Route,metachar,no" />
			
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
		<td><input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>
			</td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
			</td>
		
	</tr>
	<%--<tr>
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature2" size="30"  name="nomenclature2" onblur="populatePVMS(this.value,'1'),checkItem();"  />
	    </td>
	    <td>
	    <IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();" title="Click here to Search for Nomenclature">
	     <div id="ac2update2" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature2','ac2update2','fwc?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>
		<td><input type="hidden" name="pvmsNo2" tabindex="1" id="pvmsNo2"	size="10" readonly="readonly" /><input type="text" name="dosage2" tabindex="1" id="dosage2"	size="5" maxlength="5" /></td>
		<td><select name="frequency2" id="frequency2" tabindex="1"onclick="fillValueFromFrequency(this.value,'1');">
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFrequency2 : frequencyList){
		       int id = masFrequency2.getId();
		       String name = masFrequency2.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
		</select> <%
	    		MasFrequency  masFrequency3 = new MasFrequency();

			     for (int i = 0; i < frequencyList.size(); i++) {
			    	 masFrequency3 = (MasFrequency) frequencyList.get(i);
     			 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
            </script> <% }%>
		</td>

		<td><input type="text" name="noOfDays2" tabindex="1" id="noOfDays2" onblur="fillValue(this.value,'1')" size="3"	maxlength="3" validate="No Of Days,num,no" />
			
		</td>
		<td><input type="text" name="route2" tabindex="1" id="route2"  size="10" maxlength="20"	 validate="Route,string,no" />
			
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
		<td><input type="text" name="remarks2" tabindex="1" id="remarks2" size="10" maxlength="40"/>
			</td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
			</td>
		
	</tr>
	<tr>
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature3" size="30"  name="nomenclature3" onblur="populatePVMS(this.value,'1'),checkItem();"  />
	    </td>
	    <td>
	    <IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();" title="Click here to Search for Nomenclature">
	     <div id="ac2update3" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature3','ac2update3','fwc?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>
		<td><input type="hidden" name="pvmsNo3" tabindex="1" id="pvmsNo3"	size="10" readonly="readonly" /><input type="text" name="dosage3" tabindex="1" id="dosage3"	size="5" maxlength="5" /></td>
		<td><select name="frequency3" id="frequency3" tabindex="1"onclick="fillValueFromFrequency(this.value,'1');">
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFrequency4 : frequencyList){
		       int id = masFrequency4.getId();
		       String name = masFrequency4.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
		</select> <%

			     for (int i = 0; i < frequencyList.size(); i++) {
	    					MasFrequency  masFrequency5 = new MasFrequency();
			        	 masFrequency5 = (MasFrequency) frequencyList.get(i);
     			 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency5.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency5.getFrequencyName()%>";
            </script> <% }%>
		</td>

		<td><input type="text" name="noOfDays3" tabindex="1" id="noOfDays3" onblur="fillValue(this.value,'1')" size="3"	maxlength="3" validate="No Of Days,num,no" />
			
		</td>
		<td><input type="text" name="route3" tabindex="1" id="route3"  size="10" maxlength="20"	 validate="Route,string,no" />
			
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
		<td><input type="text" name="remarks3" tabindex="1" id="remarks3" size="10" maxlength="40"/>
			</td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
			</td>
		
	</tr>
		<tr>
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature4" size="30"  name="nomenclature4" onblur="populatePVMS(this.value,'1'),checkItem();"  />
	    </td>
	    <td>
	    <IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();" title="Click here to Search for Nomenclature">
	     <div id="ac2update4" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature4','ac2update4','fwc?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>
		<td><input type="hidden" name="pvmsNo4" tabindex="1" id="pvmsNo4"	size="10" readonly="readonly" /><input type="text" name="dosage3" tabindex="1" id="dosage3"	size="5" maxlength="5" /></td>
		<td><select name="frequency4" id="frequency4" tabindex="1"onclick="fillValueFromFrequency(this.value,'1');">
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFrequency4 : frequencyList){
		       int id = masFrequency4.getId();
		       String name = masFrequency4.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
		</select> <%

			     for (int i = 0; i < frequencyList.size(); i++) {
	    					MasFrequency  masFrequency7 = new MasFrequency();
			        	 masFrequency7 = (MasFrequency) frequencyList.get(i);
     			 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency7.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency7.getFrequencyName()%>";
            </script> <% }%>
		</td>

		<td><input type="text" name="noOfDays4" tabindex="1" id="noOfDays4" onblur="fillValue(this.value,'1')" size="3"	maxlength="3" validate="No Of Days,num,no" />
			
		</td>
		<td><input type="text" name="route4" tabindex="1" id="route4"  size="10" maxlength="20"	 validate="Route,string,no" />
			
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
		<td><input type="text" name="remarks4" tabindex="1" id="remarks4" size="10" maxlength="40"/>
			</td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
			</td>
		
	</tr>
	
	 --%>
	<input type="hidden" name="hdb" value="1" id="hdb" />
</table>
<div class="clear"></div>
</div>
</div>
</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<h4>Advice</h4>
<div class="clear"></div>

<label >Additional Advice</label>
<textarea name="presentAdvice" cols="50" rows="0" maxlength="300" 	tabindex="1" onkeyup="return ismaxlength(this)" class="auto"></textarea>

<label >Referred To </label>
<select	name="referredDepartmentId" tabindex="1" multiple="4" size="3"	id="referredDepartmentId"  class="listBig" onchange="referedchange(this)">
	<option value="0">Select</option>
	<%
					  Iterator itr2= deptList.iterator();
					  while(itr2.hasNext())
					  {
						MasDepartment masDepartment=(MasDepartment)itr2.next();
						int departmentId=masDepartment.getId();
						String deptName=masDepartment.getDepartmentName();
						
					%>
	<option value="<%=departmentId %>"><%=deptName %></option>
	<%
	 			 }
				%>
</select>
<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

	<tr>
		 <td><a href="javascript:openPopupProcedureAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)"> Procedure Advice</a></td>
		<td><a href="javascript:openPopupDetentionAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)"> Detention Advice</a></td>
		<td><a href="javascript:openPopupPhysiotheraphyAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)">  Physiotherapy Advice</a></td>
</tr>
</table>
<div class="clear"></div>
<%--
<div id=threpyId style="display: none">  
<div class="clear"></div>
<label>Therapy type</label>

<select	name="threpytypeId" tabindex="1" 	id="threpytypeId"   >
	<option value="0">Select</option>
	<%
					  Iterator therapyTypeListitr= therapyTypeList.iterator();
					  while(therapyTypeListitr.hasNext())
					  {
						MasTherapyType masthrepy=(MasTherapyType)therapyTypeListitr.next();
						int threpyId=masthrepy.getId();
						String threpyName=masthrepy.getTherapyTypeName();;
						
					%>
	<option value="<%=threpyId %>"><%=threpyName %></option>
	<%
	 			 }
				%>
</select>
 
<label class="medium">Days</label>
<input type="text" name="DaysPhy" tabindex="1" class="auto" size="12" maxlength="3" />
<label>Duration</label>
<input type="text" name="DurationPhy" tabindex="1" class="auto" size="48" maxlength="3" />
</div>
--%>
<div class="clear"></div>
<label>Referred To MH</label>
<input type="checkbox" name="referedToMH" class="radio" id="referedToMH" value="y"/>
<% if(visit.getHin().getRelation()!=null&&visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self")){%>
<label>Disposal</label>
<select name="disposal" size="0" tabindex="1">
	<option value="0">select</option>
	<% 
			for(MasDisposal masDisposalType : disposalTypeList){	
		%>
	<option value="<%=masDisposalType.getDisposalName() %>" selected="selected"><%=masDisposalType.getDisposalName() %></option>
	<%}%>
	<!--<option value="ED">ED</option>
	<option value="MD">MD</option>
	<option value="LD">LD</option>
--></select>
<label>Days</label>
<input name="days" type="text" tabindex="1" maxlength="2"  size="48"  />

<% }%>
</div>
<div class="clear"></div>


<!-- <input type="text" name="nextVisitDate"  class="calDate"/>
		<a href="#"><img src="images/cal.gif" alt="Calender" border="0" /></a>
		 -->
<div class="clear"></div>

<input id="visitId" name="visitId" type="hidden"	value="<%=visit.getId()%>" />
<input id="visitId1" name="<%=VISIT_ID %>" type="hidden"	value="<%=visit.getId()%>" />
<input name="hinId" type="hidden"	value="<%=visit.getHin().getId()%>" />
<input name="departmentId"	type="hidden" value="<%=visit.getDepartment().getId()%>" />
<input	name="hospitalId" type="hidden" value="<%=hospitalId%>" />
<%if(visit.getDoctor() != null){ %>
<input name="empId" type="hidden" value="<%=visit.getDoctor().getId()%>" />
<%}%>
<input name="deptId" type="hidden" value="<%=deptId%>" />
<input	name="<%=SERVICE_NO%>" type="hidden"	value="<%=visit.getHin().getServiceNo()%>" />
<input	name="<%=VISIT_NUMBER%>" type="hidden" value="<%=visit.getVisitNo()%>" />
<input name="<%=HIN_NO%>" type="hidden"	value="<%=visit.getHin().getHinNo()%>" />
<input	name="consultationDate" type="hidden" value="<%=consultationDate%>" />
<input name="consultationTime" type="hidden"	value="<%=consultationTime%>" />
<input name="relation" type="hidden" value="<%=visit.getHin().getRelation().getRelationName()%>" />
<%
	String orderSeqNo="";
	if(mapForDS.get("orderSeqNo") != null){
		orderSeqNo = (String)mapForDS.get("orderSeqNo");
	}
%>
<input name="<%=ORDER_NO %>" type="hidden" value="<%=orderSeqNo %>" />
<div class="clear"></div>
<div class="division"></div>
<input name="Submit" type="button"	tabindex="1" align="right" class="button" value="Submit" onclick="submitFWCMainForm();" />
<input name="Reset" type="reset" tabindex="1" align="right"	class="button" value="Reset" onclick="resetdata()" />
<div class="clear"></div>
<div class="division"></div>
<div class="paddingTop40"></div>
<!--main content placeholder ends here--> <script type="text/javascript">





 /*
 // Both the methods merged in validate fiels
 // method for validating nxt visit date
	function validateDate() {
			//alert("---date--"+serverdate)
			var dateSelected=document.getElementById("nextVisitDate").value
			if(dateSelected != ""){

			var visitDate = new Date(dateSelected.substring(6),(dateSelected.substring(3,5) - 1) ,dateSelected.substring(0,2))
			var currentDate = new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2))

				if(visitDate<currentDate)
			    {
				document.getElementById("nextVisitDate").value="";
				alert("Please enter the correct Visit date.")
				return false;
			    }
		    }
		    return true;
		  }
	//method for checking diagnosis field
	var errorMsg="";
	function checkDiagnosis(){
	 //var validateDate=validateDate();

	 alert("----diagnosis length---")
	      if(document.getElementById('diagnosisId').length == 1)
	      {
	       alert("Please Enter the diagnosis of the Patient.\n");
	        return false;
	      }else{
	         return true;
	       }


    }
	*/
	function jsSetIcdData(icd_no)
	{
	document.getElementById("icdCode").value=icd_no;
	document.getElementById("icdCode").focus();
	}

	function openPopupWindow()
	{
	 var url="/hms/hms/adt?method=showICDSearchJsp";
	 newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	}
	function openPopupTreatmentWindow()
	{
		var url="/hms/hms/fwc?method=showtreatmentSearchJsp";
		newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	    		
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

	function checkTemplateId(templateId){
		
      if(templateId=="0"){
        return true;
      }else{
        return true;
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
 

  function validateBpValue(obj){
	var bpObj = document.getElementById('bp');
	 var bool =validateBpWithSlash(obj)
	if(bool)
	{

	if(obj != ""){
	var index=obj.indexOf('/');
	//if(index != 2){
	//	 alert("BP should be in min/max Format.")
	//	 bpObj.value="";
	//	 bpObj.focus();
	//	 return false;
	//	 }
		 var pairs2 = obj.substring(0,obj.length).split('/');
		 if (pairs2.length!=2) {
			 alert("Invalid  Format.BP should be in min/max Format.")
			return false;
			}
		val2=eval(pairs2[0]);
		 if (val2<60 ) {
		  alert("Minimum BP should be greater than 60.")
		  return false;}

		 val3=eval(pairs2[1]);
         if (val3>240) {
		  alert("Maximum BP should be less than 240.")
		 return false;}

	}
	return true;
	}
	bpObj.value="";
	bpObj.focus();
	return false;
	}
	function validateBpWithSlash(strValue){
		if(strValue != ""){
		var objRegExp = /^(\d{1,}[\/]\d*)$/
		obj =  objRegExp.test(strValue);
		if(!obj){
			alert("BP should be in min/max Format.");
			return false;
		}
		return true;
	  }
	}

	function validateTemp( strValue ) {
 			 var objRegExp  =/^((\+|-)\d)?\d*(\.\d{2})?$/;
 			return objRegExp.test(strValue);
		}

	function validateInvestigationAutoComplete( strValue,inc ) {

 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    //alert("id----"+id)

		    if(id =="")
		    {
		    		document.getElementById('chargeCodeName'+inc).value="";
	   				document.getElementById('chargeCode'+inc).value="";
 					return ;
 			}
 			document.getElementById('qty'+inc).value="1";
 			return true;
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
		      						checkItem();
							   }
		  					  };
		  e0.name = 'nomenclature' + iteration;
		  e0.id = 'nomenclature' + iteration;
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
		
		//  alert("3--3-"+iteration);
		 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'fwc?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});
		   //alert("name--"+e0.name)
	 //alert("4---");
		    var cellRight1 = row.insertCell(1);
		    var eImg = document.createElement('img');
		  eImg.src = '/hms/jsp/images/search.gif';
		  eImg.name = 'search' + iteration;
		  eImg.id = 'search' + iteration;
		  eImg.WIDTH = '26';
		  eImg.HEIGHT = '26';
		  //eImg.id = 'billDateId'+iteration;
		  eImg.onclick = function(){
		   var url="/hms/hms/fwc?method=showItemSearchJsp&count="+iteration;
		    newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0"); };
		  cellRight1.appendChild(eImg);
		//  alert("5---");
		


		  var cellRight2 = row.insertCell(2);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name='dosage'+iteration;
		  e2.id='dosage'+iteration
		  e2.size='5';
		  e2.setAttribute('maxlength', 5); 
		  e2.setAttribute('tabindex','1');
		  cellRight2.appendChild(e2);

		//  var cellRightSel = row.insertCell(2);
		  var sel = document.createElement('input');
		  sel.type = 'hidden';
		  sel.name='pvmsNo'+iteration;
		  sel.id='pvmsNo'+iteration
		  sel.size = '10';
		  sel.setAttribute('tabindex','1');
		  cellRight2.appendChild(sel);
		  

		  var cellRight3 = row.insertCell(3);
		  var e3 = document.createElement('Select');

		  e3.name='frequency'+iteration;
		  e3.id='frequency'+iteration;
		  e3.classname='smalllabel';
		  e3.setAttribute('tabindex','1');
		  e3.options[0] = new Option('Select', '0');
		  e3.onclick=function(){
		  					var val=e4.value
		  					var freq=e3.value
		  						//alert("frequency-----"+freq)
		  					document.getElementById('total'+iteration).value=val*freq
		  		}

		   for(var i = 0;i<icdArray.length;i++ ){
		      e3.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
		      }
		  cellRight3.appendChild(e3);


		  var cellRight4 = row.insertCell(4);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name='noOfDays'+iteration;
		  e4.id='noOfDays'+iteration;
		  e4.size='3';
		  e4.setAttribute('maxlength', 3); 
		  e4.setAttribute('tabindex','1');
		  e4.setAttribute('validate','noOfDays,int,yes');

		  e4.onblur=function(){
		  							var val=e4.value
		  							var freq=e3.value
		  							//alert("frequency-----"+freq)
		  							document.getElementById('total'+iteration).value=val*freq
		  						}
		  cellRight4.appendChild(e4);

		  var e5 = document.createElement('input');
		  e5.type = 'hidden';
		  e5.name='total'+iteration;
		  e5.id='total'+iteration;
		  e5.size='5';
		  e5.setAttribute('tabindex','1');
		  cellRight4.appendChild(e5);

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


			var cellRight6 = row.insertCell(5);
			var e6 = document.createElement('input');
			e6.type = 'text';
			e6.name='route'+iteration;
			e6.id='route'+iteration
			e6.size='10';
			e6.setAttribute('maxlength', 20); 
			e6.setAttribute('tabindex','1');
			cellRight6.appendChild(e6);

		  var cellRight7 = row.insertCell(6);
		  var e7 = document.createElement('input');
		  e7.type = 'text';
		  e7.name='remarks'+iteration;
		  e7.id='remarks'+iteration
		  e7.size='10';
		  e7.setAttribute('maxlength', 40); 
		  e7.setAttribute('tabindex','1');
		  cellRight7.appendChild(e7);

		  var cellRight8 = row.insertCell(7);
		  var e8 = document.createElement('input');
		  e8.type = 'button';
		  e8.className = 'buttonAdd';
		  e8.name='remarks'+iteration;
		  e8.setAttribute('onClick', 'addRow();'); 
		  e8.setAttribute('tabindex','1');
		  cellRight8.appendChild(e8);

		  var cellRight9 = row.insertCell(8);
		  var e9 = document.createElement('input');
		  e9.type = 'button';
		  e9.className = 'buttonDel';
		  e9.name='remarks'+iteration;
		  e9.setAttribute('onClick', 'removeRow();'); 
		  e9.setAttribute('tabindex','1');
		  cellRight9.appendChild(e9);

		  
		   //added - fayaz
		//  var cellRight9 = row.insertCell(9);
	   //   var e9 = document.createElement('input');
	 //     e9.id = 'a'
	 //     e9.type = 'checkbox';
	  //    cellRight9.appendChild(e9);

		}

		
	function removeRow()
	{
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('grid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hdb');
	  	hdb.value=iteration
	  }
	}
	function removeRowForInvestigation()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('investigationGrid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hiddenValue');
	  	hdb.value=iteration

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
function checkItem(){


var tbl = document.getElementById('grid');
var lastRow = tbl.rows.length;
var iteration = lastRow-1;

var pvmsNo=document.getElementById("pvmsNo"+iteration).value
var nomenclature = document.getElementById("nomenclature"+iteration).value

var visitId=document.getElementById("visitId").value
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
	        var bedStatus  = item.getElementsByTagName("bedStatus")[0];
	       if(bedStatus.childNodes[0].nodeValue=='yes'){
	           	alert("This Drug is Alergic for this patient..!")

	       	document.getElementById("nomenclature"+iteration).value = ""
	       	document.getElementById("pvmsNo"+iteration).value= ""
	       	pvmsNo=pvmsNo.childNodes[0].nodeValue
	       return true
	       }else{
	       	document.getElementById("visitId").selectedIndex=0
	        pvmsNo=0
	       	return false;
	       }

      	}
      	
      }
      
      }
    if(nomenclature!="")
    {
        
  	  checkForNomenclature(nomenclature,iteration)
    }
    var url="/hms/hms/fwc?method=checkItem&pvmsNo="+pvmsNo+"&visitId="+visitId

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

}

	 function  fillValue(value,inc){

	  //alert(value)
	  var freq=document.getElementById('frequency'+inc).value
	  document.getElementById('total'+inc).value=freq*value
	 }

	 function  fillValueFromFrequency(value,inc){

	  //alert(value)
	  var noOfDays=document.getElementById('noOfDays'+inc).value
	  document.getElementById('total'+inc).value=noOfDays*value
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
	
	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'fwc?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});	  var sel = document.createElement('input');
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
	  e3.type = 'button';
	  e3.className = 'buttonAdd';
	  e3.name='Button';
	  e3.setAttribute('onClick','addRowForInvestigation();');
	  cellRight1.appendChild(e3);

	  var cellRight2 = row.insertCell(2);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonDel';
	  e4.name='delete';
	  e4.setAttribute('onClick','removeRowForInvestigation();');
	  cellRight2.appendChild(e4);
	  
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
</script> 
<script type="text/javascript">
	function openPopupForPatientPrescription(visitNo,hinId,deptId,visitId){
		  //alert("in pop up window visit No---"+visitNo+"---- hin id ---"+hinId)


		if(visitNo >1){
		var url="/hms/hms/fwc?method=showPatientPreviousPrescription&visitNo="+visitNo+"&hinId="+hinId+"&deptId="+deptId+"&visitId="+visitId;
        newwindow=window.open(url,'name',"height=300,top=0,width=1010,status=1");
        }else{
          alert("This Is Patient's first Visit.")
        }
     }

     function submitDetails(){

		
        document.fwcMain.action="hms/hms/fwc?method=submitFWCPatientDetails";
        document.fwcMain.submit();
        document.fwcMain.action="fwc?method=showEntJsp&visitId=<%=visit.getId() %>"
        document.fwcMain.submit();
		

     }

     

     function openPopupForPatientInvestigation(visitNo,hinId){
		  //alert("in pop up window visit No---"+visitNo+"---- hin id ---"+hinId)


		if(visitNo >1){
		var url="/hms/hms/fwc?method=showPatientPreviousInvestigation&visitNo="+visitNo+"&hinId="+hinId;
        newwindow=window.open(url,'name','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
        }else{
          alert("This is Patient's First Visit. ")
        }
     }
	function getDoctorList(){
		document.getElementById("referredDoctarsId").options.length=0;
		var combo=document.getElementById("referredDepartmentId");
		var x=0;
		var a="";
		var indexes = new Array();
		for(x=0;x<combo.options.length;x++) {
			if (combo.options[x].selected) {
				a=combo.options[x].value;
				indexes.push(a);
			}
		}
		submitProtoAjaxWithDivName('fwcMain','/hms/hms/fwc?method=responseForDoctarsList&referredDepartmentId='+indexes+'','referredDoctarsIdDiv');
		//submitProtoAjaxforOpdMain('fwcMain','/hms/hms/fwc?method=responseForDoctarsList&referredDepartmentId='+indexes+'');
	}


  function showCreatePrescriptionTempate(){
        
  		document.getElementById('prescriptionImportButton').style.display = 'inline';
	   	var url="/hms/hms/fwc?method=showCreatePrescriptionTempate";
	    newwindow=window.open(url,'presciption',"height=500,width=1010,status=1,top=0,left=2");
	   
	     }

  function copyPrevPrescriptionTempate(visitNo,hinId){
   		document.getElementById('templateDivToShowHide').style.display = 'none';
   		document.getElementById('prevButtonDivToShowHide').style.display = 'none';
   		document.getElementById('createPresDivToShowHide').style.display = 'none';

		var hdb = document.getElementById('hdb').value;
	    submitProtoAjaxWithDivName('fwcMain','/hms/hms/fwc?method=getPatientPreviousPrescriptionForCopy&&visitNo='+visitNo+'&hinId='+hinId,'testDiv');
  }

  function copyPrevInvestigationTempate(visitNo,hinId){
   		document.getElementById('templateDivInvestigationToShowHide').style.display = 'none';
   		document.getElementById('prevButtonDivInvestigationToShowHide').style.display = 'none';
   		document.getElementById('createInvestigationDivToShowHide').style.display = 'none';

		var hdb = document.getElementById('hdb').value;
	    submitProtoAjaxWithDivName('fwcMain','/hms/hms/fwc?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
  }

  function showCreateInvestigationTemplate(){
     
	     document.getElementById("investigationImportButton1").style.display='inline'
	   	var url="/hms/hms/fwc?method=showCreateInvestigationTemplate";
	    newwindow=window.open(url,'investigation',"height=500,width=1010,status=1,top=0,left=2");
	   

  }


 function getListForTreatment(val){
 	if(val=='investigationDiv'){
		submitProtoAjaxWithDivName('fwcMain','/hms/hms/fwc?method=getListForTreatment&flag=investigation',val);
	}else if(val=='treatmentDiv'){
		submitProtoAjaxWithDivName('fwcMain','/hms/hms/fwc?method=getListForTreatment&flag=treatment',val);
	}
//	document.getElementById('prescriptionImportButton').style.display = 'none';
//	document.getElementById("investigationImportButton").style.display='none'
 }

 function checkForChargeCode(val,inc,chargeCodeTdDiv){
   
	if(val != ""){
       
		var index1 = val.lastIndexOf("[");
		var indexForChargeCode = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var chargeId = val.substring(index1,index2);
		var indexForChargeCode = indexForChargeCode--;
		var chargeCode = val.substring(0,indexForChargeCode);


		if(chargeId == "" ) {
	      	document.getElementById('chargeCodeName'+inc).value="";
	      	document.getElementById('chargeCode'+inc).value="";
	      	document.getElementById('clinicalNotes'+inc).value="";
	 	  	document.getElementById('qty'+inc).value="";
	      	return;
		}

		for(i=1;i<inc;i++){

			if(inc != 1){
				if(document.getElementById('chargeCodeName'+i).value==val) {
					alert("Test name already selected...!")
					document.getElementById('chargeCodeName'+inc).value=""
					var e=eval(document.getElementById('chargeCodeName'+inc));
					e.focus();
					return false;
				}
			}
		}

		var nameOfChargeCodeArray = chargeCode.split('&');
		var tempChargeCodeString = "";
		for(var m=0; m<nameOfChargeCodeArray.length;m++) {
			tempChargeCodeString = tempChargeCodeString + nameOfChargeCodeArray[m]+"0";
		}

		//ajaxFunctionForAutoCompleteChargeCodeName('orderBooking','lab?method=fillItemsForChargeCode&chargeCode=' +  tempChargeCodeString , inc);
		//submitProtoAjaxWithDivName('fwcMain','/hms/hms/fwc?method=fillChargeCodeForInvestigation&chargeCodeNAmeForAjax='+ tempChargeCodeString+'&rowVal=1',chargeCodeTdDiv);

		}else{
			document.getElementById('chargeCodeName'+inc).value = "";
			document.getElementById('qty'+inc).value = "";
			document.getElementById('chargeCode'+inc).value = "";
			//document.getElementById('qty'+inc).value = "";
			//document.getElementById('qty'+inc).value = "";
		}
	}

	function fillChargeCodeId(val){
		//alert("in method--")

		if(val != "") {
		    var index1 = val.lastIndexOf("[");
		    var indexForChargeCode=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var chargeCodeId = val.substring(index1,index2);
		    var indexForChargeCode=indexForChargeCode--;
		    var chargeCodeName=val.substring(0,indexForChargeCode);
			if(chargeCodeId == "") {
		   		document.getElementById('chargeCodeName1').value="";
		    	document.getElementById('chargeCodeId').value="";
		   		return;
		   	} else {
	   		      document.getElementById('chargeCodeId').value=chargeCodeId;
	      	}
	 	}
	}
	function showHideDrugTemplateCombo(valueOfTemplate){
		if(checkTemplateId(valueOfTemplate)){
		  	document.getElementById("copyPrevPrescriptionTemplateDiv").style.display='none';

			submitProtoAjax('fwcMain','/hms/hms/fwc?method=showGridInMainJsp','testDiv');
		}
	}
	function showHideInvestigationTemplateCombo(valueOfTemplate){
		
		if(checkTemplateId(valueOfTemplate)){
			
		  	document.getElementById("copyPrevInvestigationTemplateDiv").style.display='none';
		  	
				submitProtoAjaxWithDivName('fwcMain','/hms/hms/fwc?method=showGridForInvestigation','gridview');
				
				}
	
	}
	function validateFrequency(){
		
		var count = document.getElementById('hdb').value;
		for(var i = 1; i <= count;i++){
			var nomenclature = document.getElementById('nomenclature'+i).value;
			if(nomenclature != ''){
				var frequency = document.getElementById('frequency'+i).value;
				if(frequency == '0'){
					alert('Please select frequency.');
					return false;
				}
				var dosage = document.getElementById('dosage'+i).value;
				if(dosage == ''){
					alert('Please Enter dosage.');
					return false;
				}
				var noOfDays = document.getElementById('noOfDays'+i).value;
				if(noOfDays == ''){
					alert('Please Enter noOfDays.');
					return false;
				}
				if(noOfDays!="")
				{
				if( isNaN(noOfDays))
		    	{
		        	alert("No. of Days Should be number");
		        	return false;
		    	}
				}
				
				/*var instructionACPC = document.getElementById('instructionACPC'+i).value;
				if(instructionACPC == ''){
					alert('Please select Intake.');
					return false;
				}
				var typeLeftRight = document.getElementById('typeLeftRight'+i).value;
				if(typeLeftRight == ''){
					alert('Please select Type.');
					return false;
				}
				var remarks = document.getElementById('remarks'+i).value;
				if(remarks == ''){
					alert('Please Enter remarks.');
					return false;
				}*/
			}else
			{
				alert("Please Enter Nomenclature");
				return false;
			}
		}
		return true;
	}

	function submitFWCMainForm(){
	//	if(validateFieldValuesForMainSubmit()){
			if(validateFrequency()){
				submitForm('fwcMain','fwc?method=submitFWCPatientDetails&flag=fwc');
	//		}
		}
	}
	function deleteDgItems(value){
     if(document.getElementById('diagnosisId').selectedIndex!=0){
	 if(confirm("are you sure want to delete ?")){

 	 		document.getElementById('diagnosisId').remove(document.getElementById('diagnosisId').selectedIndex)

	    }
	   }
     }
    function showTreatment()
    {
    	
    		   	var url="/hms/hms/fwc?method=showTreatmentPopUp";
    		    newwindow=window.open(url,'treatment',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
    		  
    }
    function obg()
    {
    	
    	submitForm('fwcMain','fwc?method=showOBGONEJsp&visitId=<%=visit.getId()%>');  
    }
    function pediatrics()
    {


    	var ageId=document.getElementById("ageId").value
    	var age = ageId.substring(0,2);
    	var ageIntoInt=parseInt(age);
    	if(ageIntoInt<=15)
    	{
    		submitForm('fwcMain','fwc?method=showPediatricCaseSheetJsp&visitId=<%=visit.getId()%>');  
			return true;
    		   		
    	}
    	else
    	{
    		alert("Age cannot be more than 15 years");
    		return false;
    	}
    	return true;
   	
    }
    function showSymptom()
    {
    	
    		   	var url="/hms/hms/fwc?method=showSymptomPopUp";
    		    newwindow=window.open(url,'Symptom',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
    		  
    }
    function showDiagnosis()
    {
    	
    		   	var url="/hms/hms/fwc?method=showDiagnosisPopUp";
    		    newwindow=window.open(url,'Diagnosis',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
    		  
    }
    function checkForNomenclature(val,inc)
    {
        
    	if(val != ""){
    		
    		var index1 = val.lastIndexOf("[");
    		var indexForChargeCode = index1;
    		var index2 = val.lastIndexOf("]");
    		index1++;
    		var chargeId = val.substring(index1,index2);
    		var indexForChargeCode = indexForChargeCode--;
    		var chargeCode = val.substring(0,indexForChargeCode);

    		 
    		if(chargeId == "" ) {
    	      	document.getElementById('nomenclature'+inc).value="";
    	      	document.getElementById('pvmsNo'+inc).value="";
    	     // 	document.getElementById('clinicalNotes'+inc).value="";
    	 	 // 	document.getElementById('qty'+inc).value="";
    	      	return;
    		}

    		for(i=1;i<inc;i++){
                
    			if(inc != 1){
    				 
     				if(document.getElementById('nomenclature'+i).value==val) {
    					alert("Nomenclature already selected...!")
    					document.getElementById('nomenclature'+inc).value=""
    					document.getElementById('pvmsNo'+inc).value="";
    					var e=eval(document.getElementById('nomenclature'+inc));
    					e.focus();
    					return false;
    				}
    			}
    		}

    		
    }
    }
    function resetdata()
    {
       
        document.fwcMain.action="/hms/hms/fwc?method=showFWCMainJsp&visitId=<%=visit.getId() %>&token=<%=visit.getTokenNo()%>";
        document.fwcMain.submit();
       
    }
    function valueChange()
    {
    	var ret_value=document.getElementById("returnValue").value;
    	var v=document.getElementById("hospidataId").style.display;
    	
    	if(ret_value=="false")
    	{
       
        document.getElementById("hospidataId").style.display= 'inline'
          
        var v1=document.getElementById("hospidataId").style.display;
        
        document.getElementById("returnValue").value="true";
      	
    	}
    	if(ret_value=="true")
    	{
    		document.getElementById("hospidataId").style.display='none'
    	    document.getElementById("returnValue").value="false";
    	}
    	
    }
    function checkDate1(val,Id)
    {

    if(Id=="doa" || Id=="dod" )
    {
           curr = new Date(serverdate);
           dob = new Date(val);
          
                if(dob>curr)
                 {
                  alert("Date should be less or Equal Current Date "+serverdate);
                  document.getElementById(Id).value="";
                  
                 }
    }
    
    if(Id=="dod")
    {  
      var passportIssueDate=document.getElementById('doa').value;
      curr1 = new Date(passportIssueDate);
       dob1 = new Date(val);
      if(curr1>dob1)
      {
                 alert("doa  Date can not be gretter than dod Date");
                 document.getElementById(Id).value="";
      }
      
    }
     if(Id=="doa")
     {
                
          var passportExpiryDate=document.getElementById('dod').value;
          curr1 = new Date(passportExpiryDate);
       dob1 = new Date(val); 
      if(dob1 > curr1 && curr1 !="")
      {
                 alert("doa  Date can not be gretter than dod Date");
                 document.getElementById(Id).value="";
      }
     } 
        
   }
        function referedchange(obj)
        {
        	
        	 var referredDepartmentId=document.getElementById('referredDepartmentId').value;
        	
        	 if(referredDepartmentId==87)
        	 {
        		
        		 document.getElementById("threpyId").style.display= 'inline';
        		
        	 }else{
        		 document.getElementById("threpyId").style.display='none'
        	 }
        }
        function openPopupProcedureAdviceWindow(visitId,hinId,doctorId)
    	{
    	 var url="/hms/hms/fwc?method=showProcedureListJsp&visitId="+visitId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=fwc";
    	 newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
    	}
        function openPopupDetentionAdviceWindow(visitId,hinId,doctorId)
    	{
    	 var url="/hms/hms/fwc?method=showDetentionListJsp&visitId="+visitId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=fwc";
    	 newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
       	 //alert("Detention Advice ....");
    	}
        function openPopupPhysiotheraphyAdviceWindow()
    	{
    	 //var url="/hms/hms/fwc?method=showProcedureListJsp&visitId="+visitId;
    	 //newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
       	 alert("Physiotheraphy Advice ....");
    	}
        function openPopupPrescriptions(visitId,visitNo,deptId,hinId)
    	{
    	 var url="/hms/hms/fwc?method=showPatientPreviousVisitForPrescriptionReport&visitId="+visitId+"&visitNo="+visitNo+"&deptId="+deptId+"&hinId="+hinId;
    	 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
       	 //alert("Detention Advice ....");
    	}
        
        function openPopupInvestigation(visitId,visitNo,deptId,hinId)
    	{
    	 var url="/hms/hms/fwc?method=showPatientPreviousVisitForInvestigationReport&visitId="+visitId+"&visitNo="+visitNo+"&deptId="+deptId+"&hinId="+hinId;
    	//fwc?method=showPatientPreviousVisitForInvestigationReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>"
    	 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
       	 //alert("Detention Advice ....");
    	}
</script>
</form>



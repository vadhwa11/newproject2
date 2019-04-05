<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<!-- <script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>-->
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<form name="opdMain" action="" method="post">
<style type="text/css">
#contentHolder {
	padding: 0px 0px 0px 10px;
	margin: 0px;
	width: 935px;
	height: auto;
}

#contentHolder select.listBig {
	font: normal 11px Tahoma, Verdana, Arial, Helvetica, sans-serif;
	color: #000000;
	width: 320px;
	border: 1px solid #7F9DB7;
	height: 50px;
	float: left;
	margin: 4px 10px 10px 0px;
	padding-left: 5px;
}

#contentHolder select.listSm {
	font: normal 11px Tahoma, Verdana, Arial, Helvetica, sans-serif;
	color: #000000;
	width: 120px;
	border: 1px solid #7F9DB7;
	height: 50px;
	float: left;
	margin: 4px 10px 10px 0px;
	padding-left: 5px;
}
</style>
<script type="text/javascript">
animatedcollapse.addDiv('slide0', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

</script> <script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script> <script
	type="text/javascript">


ddaccordion.init({
	headerclass: "expandable", //Shared CSS class name of headers group that are expandable
	contentclass: "categoryitems", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false
	defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "normal", //speed of animation: "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
})



</script> <script type="text/javascript">

function openpopforItemSearch(){

    var url="/hms/hms/opd?method=showItemSearchJsp&count="+1;

    newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");

}
function jsSetUnitData(id,pvms,nomenclature,count)
{
document.getElementById('nomenclature'+count).value = nomenclature+'['+pvms+']'
document.getElementById('nomenclature'+count).focus();
}
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}
</script> <script type="text/javascript" language="javascript">
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
</script> <%--For AutoComplete Through Ajax--%> <script src="/hms/jsp/js/ajax.js"
	type="text/javascript"></script> <script src="/hms/jsp/js/prototype.js"
	type="text/javascript"></script>
	<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
	
	 <script
	src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script> <script
	src="/hms/jsp/js/unittest.js" type="text/javascript"></script> <%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}

	List<DischargeIcdCode>dischargeIcdCodeList=new ArrayList<DischargeIcdCode>();
	List<OpdPatientDetails> opdPatientDetailsList = new ArrayList<OpdPatientDetails>();
	PatientPrescriptionHeader patientPrescriptionHeader =null;
	PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
	List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
	List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
	List<MasEmployee> doctarsList = new ArrayList<MasEmployee>();

	OpdPatientHistory opdPatientHistory=new OpdPatientHistory();
	OpdPatientDetails opdPatientDetails=new OpdPatientDetails();
	String complaints="";
	String advice="";
	String presentIllness="";
	String pastHistory="";
	String personalHistory="";
	String familyHistory="";


	DgOrderhd dgOrderhd=new DgOrderhd();
	List patientDataList = new ArrayList();
	if(map.get("opdPatientDetailsList")!=null){
		System.out.println(" opdPatientDetailsList is not null");
		opdPatientDetailsList=(List<OpdPatientDetails>)map.get("opdPatientDetailsList");
		opdPatientDetails=opdPatientDetailsList.get(0);
	}
	if(map.get("opdPatientHistoryList")!=null){
		System.out.println(" opdPatientHistoryList is not null");
		opdPatientHistoryList=(List<OpdPatientHistory>)map.get("opdPatientHistoryList");
		opdPatientHistory=opdPatientHistoryList.get(0);
	}

	if(map.get("doctarsList")!=null){
		doctarsList=(List<MasEmployee>)map.get("doctarsList");
	}

	if(map.get("dischargeIcdCodeList")!=null){
		System.out.println(" dischargeIcdCodeList is not null");
		dischargeIcdCodeList=(List<DischargeIcdCode>)map.get("dischargeIcdCodeList");
	}
	if(map.get("patientPrescriptionHeader")!=null){
		System.out.println(" patientPrescriptionHeader is not null");
		patientPrescriptionHeader=(PatientPrescriptionHeader)map.get("patientPrescriptionHeader");
	}
	if(map.get("patientInvestigationHeader")!=null){
		System.out.println(" patientInvestigationHeader is not null");
		patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
	}
	if(map.get("dgSampleCollectionDetailsList")!=null){
		dgSampleCollectionDetailsList=(List)map.get("dgSampleCollectionDetailsList");
	}

	if(map.get("patientDataList") != null){
		System.out.println(" patientDataList is not null");
	patientDataList=(List)map.get("patientDataList");

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
	List<MasDepartment> deptList= new ArrayList<MasDepartment>();
	if(map.get("deptList") != null){
	deptList=(List)map.get("deptList");
	}


	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	System.out.println("Size of patientDataList list in jsp--"+patientDataList.size()+" Size of templateList list in jsp--"+templateList.size()+"-----and userName========="+userName);
	Visit visit=(Visit)map.get("visit");

	String patientName="";
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
	int deptId=visit.getDepartment().getId();
	String departmentName=visit.getDepartment().getDepartmentName();
	String departmentCode=visit.getDepartment().getDepartmentCode();
	%> <!--main content placeholder starts here-->



<div class="blockFrame" id="testDiv"><input type="hidden"
	name="userName" value="<%=userName %>" /> <%if(visit.getDepartment()!= null){ %>
<h4><%=visit.getDepartment().getDepartmentName() %></h4>
<h6>OPD- Main (AFMSF- 7A 2002)</h6>
<div class="clear"></div>
<%} %> <script type="text/javascript">
	   var icdArray=new Array();
	</script> <%
			if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
			  }
	    %> <!--Block One Starts-->
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="clear"></div>

<div class="Block">
<label >Rank</label>
<%if(visit.getHin().getRank()!= null){ %>
<label class="value"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>

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
					}%> <label
	class="value"><%=patient.getSFirstName()+" "+sMiddleName+" "+sLastName %></label> <%}}else{ %> <label class="value">-</label>
<%} %>
<label>Branch</label>
 <%if(visit.getHin().getTradeName() != null){ %>
<label class="value"><%=visit.getHin().getTradeName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>

 <div class="clear"></div>

 <label>Sex</label>
 <%if(visit.getHin().getSex() != null){ %>
<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
 
<label >Age</label> 
<%if(visit.getAge()!= null){ %>
<label class="value"><%=visit.getAge() %></label> 
<%}else{ %>
<label class="value">-</label> 
<%} %> 
<label >Occupation</label> 
<%if(visit.getHin().getOccupation()!= null){ %>
<label class="value"><%=visit.getHin().getOccupation().getOccupationName() %></label> 
<%}else{ %>
<label class="value">-</label> 
<%} %> 
 <div class="clear"></div>
<label >Marital Status</label> 
<%if(visit.getHin().getMaritalStatus() != null){ %>
<label class="value"><%=visit.getHin().getMaritalStatus().getMaritalStatusName() %></label> 
<%}else{ %>
<label class="value">-</label> 
<%} %> 

<label >Relation</label>
<%if(visit.getHin().getRelation() != null){ %>
<label class="value"><%=visit.getHin().getRelation().getRelationName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>

<label >Blood Group</label>
<%if(visit.getHin().getBloodGroup() != null){ %>
<label class="value"><%=visit.getHin().getBloodGroup().getBloodGroupName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
 <div class="clear"></div>
<label >Medical Category</label>
<%if(visit.getHin() != null){ %>
<label class="value"><%="-" %></label>
<%}else{ %>
<label class="value">-</label> <%} %>

<label>Medical Exam Date</label>
<%if(visit.getHin() != null){ %>
<label class="value"><%="-" %></label>
<%}else{ %>
<label class="value">-</label> <%} %>

<label >Medical Disability</label>
<%if(visit.getHin() != null){ %>
<label class="value"><%="-" %></label>
<%}else{ %>
<label class="value">-</label> <%} %>

 <div class="clear"></div>

<label >Medication</label>
<%if(visit.getHin() != null){ %>
<label class="value"><%="-" %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<label >Disability</label>
<%if(visit.getHin() != null){ %>
<label class="value"><%="-" %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<label >Date</label>
<%if(visit.getHin() != null){ %>
<label class="value"><%="-" %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
 
 <div class="clear"></div>
 
<label >Allergies</label>
<%if(visit.getHin() != null){ %>
<label class="value"><%="-" %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<label >No Of Dependent</label>
<%if(visit.getHin() != null){ %>
<label class="value"><%="-" %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<label >Wife</label>
<%if(visit.getHin() != null){ %>
<label class="value"><%="-" %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
 <div class="clear"></div>
<label >Children</label>

<%if(visit.getHin() != null){ %>
<label class="value"><%="-" %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<label >Visit No. </label> 

<%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label> 
<%}else{ %> 
<label	class="value">-</label> <%} %> 

 <label >Service </label>
 <%if(visit.getHin().getServiceType()!= null){ %>
<label class="value"><%=visit.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> 
<label class="value">-</label> <%} %>

<label	>Service No.</label>
 <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %></label>
 <%}else{ %>
<label class="value">-</label> <%} %>
 

<label >Visit Date </label> 
<%if(visitDateInString != null){ %> <label class="value"><%=visitDateInString %></label>
<%}else{ %> 
<label class="value">-</label> 
<%} %>
<label >Token No.</label> 
<%if(visit.getTokenNo()!= null){ %> 
<label class="value"><%=visit.getTokenNo() %></label>
<%}else{ %> <label class="value">-</label> <%} %> 
<label > Prev. Diag </label> 
<%if(visit.getDiagnosis()!= null){ %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %> 


<label >Mobile No.</label> 
<% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
<label class="value"><%=visit.getHin().getMobileNumber() %></label>
<%}else{ %> <label class="value">---</label> <%} %> 


<label>Cons.Doc.</label> 
<%
		String fullDoctorName = "";
	if(visit.getDoctor() != null){
	   if(visit.getDoctor().getFirstName() != null){
	     fullDoctorName = visit.getDoctor().getFirstName();
	   }
		if(visit.getDoctor().getMiddleName() != null){
			fullDoctorName = fullDoctorName + " " + visit.getDoctor().getMiddleName();
		}
		if(visit.getDoctor().getLastName() != null ){
			fullDoctorName = fullDoctorName + " " + visit.getDoctor().getLastName();
		}
	}
	%> <label class="valueAuto"><%=fullDoctorName%></label>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="arrowlistmenu">
<h3 class="menuheader expandable openheader">OPD ManAgement</h3>
<ul class="categoryitems">

	<!-- <li><a href="appointment?method=showAppointmentPatientJsp">Appointments</a></li>
	<li><a href="appointment?method=showAppointmentInvestigationJsp">Investigation
	Appt.</a></li>
	<li><a href="opd?method=showPatientHistoryJsp&visitId=<%=visit.getId() %>">Patient History</a></li> -->
	<li><a href=javascript:showPreviousVisit(<%=visit.getVisitNo() %>)>
	Previous Visit Detail</a></li>
	<li><a href="">
	Previous Medical Examp Detail</a></li>
	<li><a href="">
	Previous Medical Board</a></li>
	<li><a href="">
	Previous Hospitality</a></li>
	
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
	<li><a
		href="opd?method=showPatientPreviousVisitForPrescriptionReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>">Previous
	Prescription</a></li>
	<li><a
		href="opd?method=showPatientPreviousVisitForInvestigationReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>">Previous
	Investigation</a></li>


	<!--<li>Print AFMSF- 7A</li>
-->
</ul>

<h3 class="menuheader expandable">Opd Specification</h3>
<ul class="categoryitems">
	<%if(departmentCode.equalsIgnoreCase("Oph1")){ %>
	<li><a
		href="javascript:if(validateFieldValues()){submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=opth');}">Ophthalmology</a></li>
	<%} %>
	<%if(departmentCode.equalsIgnoreCase("ENT1")){ %>
	<li><a
		href="javascript:if(validateFieldValues()){submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=ent');}">ENT</a></li>
	<%} %>
	<%if(departmentCode.equalsIgnoreCase("Gynae1")){ %>
	<li><a
		href="javascript:if(validateFieldValues()){submitForm('opdMain','opd?method=showAntenatalCardJsp&flag=antenatal');}">Antenatal
	Card</a></li>
	<li><a
		href="javascript:if(validateFieldValues()){submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=obg');}">OBG</a></li>
	<%} %>
	<%if(departmentCode.equalsIgnoreCase("Paed1")){ %>
	<li><a
		href="javascript:if(validateFieldValuesPediatricsOpd()){submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=pediatric');}">Pediatrics</a></li>
	<%} %>

	<%if(departmentCode.equalsIgnoreCase("Cardio")){ %>
	<li><a
		href="javascript:if(validateFieldValues()){submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=cardiology');}">Cardiology</a></li>
	<%} %>

	<%//if(departmentCode.equalsIgnoreCase("Antenata")){ %>
	<!-- <li><a href="javascript:if(validateFieldValues()){submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=antenatal');}">Antenatal Card</a></li> -->
	<%//} %>

	<%if(departmentCode.equalsIgnoreCase("Gastro")){ %>
	<li><a
		href="javascript:if(validateFieldValues()){submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=gastroEndoscopy');}">Gastro
	Enterology Endoscopy</a></li>
	<%} %>
	<%if(departmentCode.equalsIgnoreCase("GastroCo")){ %>
	<li><a
		href="javascript:if(validateFieldValues()){submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=gastroColonoscopy');}">Gastro
	Enterology Colonoscopy</a></li>
	<%} %>
	<%if(departmentCode.equalsIgnoreCase("Oncolo")){
 %>
	<li><a
		href="javascript:if(validateFieldValues()){submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=oncosurgeryCaseSheet');}">Onco
	Surgery Case Sheet</a></li>
	<%} %>

	<%if(departmentCode.equalsIgnoreCase("Uro1")){ %>
	<li><a
		href="javascript:if(validateFieldValues()){submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=urologyCaseSheet');}">Urology
	Case Sheet</a></li>
	<%} %>

	<%if(departmentCode.equalsIgnoreCase("Onco1")){ %>
	<li><a
		href="javascript:if(validateFieldValues()){submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=oncosurgery');}">Onco
	Surgery</a></li>
	<%} %>
</ul>

<script type="text/javascript">

function validateFieldValues(){

	var dateSelected=document.getElementById("nextVisitDate").value
	if(document.getElementById('diagnosisId').length == 1)
	      {
	       //alert("Please Enter the diagnosis of the Patient.");
	       // return false;
	      }
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
function validateFieldValuesPediatricsOpd(){

	var ageId=document.getElementById("ageId").value
	var age = ageId.substring(0,2);
	var ageIntoInt=parseInt(age);
	if(ageIntoInt<=15)
	{
		var dateSelected=document.getElementById("nextVisitDate").value
		//if(document.getElementById('diagnosisId').length == 1)
	   //   {
	    //   alert("Please Enter the diagnosis of the Patient.");
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
</script>
</div>


<div class="opdArea">

<div class="clear"></div>

<label >Complaints</label> <% if(opdPatientHistory.getPresentComplain()!=null){%>
<textarea name="presentComplain" cols="0" rows="0" maxlength="300"><%=opdPatientHistory.getPresentComplain()%></textarea>
<%}else{ %> <textarea name="presentComplain" cols="0" rows="0"
	maxlength="300"></textarea> <% }%>
<div class="clear"></div>
<label>Examination</label>
<%if(opdPatientDetails.getAfmsDesc()!=null){ %> <textarea
	name="afmsDescription" cols="0" rows="0" maxlength="50"
	onkeyup="return ismaxlength(this)"><%=opdPatientDetails.getAfmsDesc() %></textarea>
<%}else{%> <textarea name="afmsDescription" cols="0" rows="0"
	maxlength="50" onkeyup="return ismaxlength(this)"></textarea> <% }%>
<div class="clear"></div>

<input type="hidden" name="userName" value="<%=userName %>" />

<h4>Diagnosis</h4>
<input	type="hidden" id="onExamination" class="large" name="onExamination"
	maxlength="200" />
<div class="clear"></div>
<label >Icd Code</label>
<input name="" value=""	id="icdCode" tabindex="1" onblur="getIcd();" />
<input name="" value=""	id="temp" type="hidden" /> 
<IMG SRC="/hms/jsp/images/search.gif"	WIDTH="24" HEIGHT="20" style="cursor: pointer;" class="floatLeft"	onClick="javascript:openPopupWindow();"	title="Click here to Search ICD Codes" />

<input type="hidden"	name="ageName" value="<%=visit.getHin().getAge() %>" id="ageId" />
 <label	>Initial Diagnosys</label> <%if(opdPatientDetails.getInitialDiagnosis()!=null){ %>
<input type="text" id="initialDiagnosis" class="large"
	value="<%=opdPatientDetails.getInitialDiagnosis() %>"
	name="initialDiagnosis" maxlength="100" /> <%}else{ %> <input type="text"
	id="initialDiagnosis" class="large" name="initialDiagnosis"
	maxlength="100" /> <%} %>
<div class="clear"></div>
<label>Diagnosis </label>
 <input type="text" value=""	id="icd" class="large" name="icd"	onblur="fillDiagnosisCombo(this.value);" />
 <div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
		</script> <select name="<%=DIAGNOSIS_ID%>" multiple="4" size="5"	id="diagnosisId"  class="listBig">
	<option value="0">Select</option>
	<%for(DischargeIcdCode dischargeIcdCode:dischargeIcdCodeList){ %>
	<option value="<%=dischargeIcdCode.getIcd().getIcdCode()%>"><%=dischargeIcdCode.getIcd().getIcdName()%>[<%=dischargeIcdCode.getIcd().getIcdCode()%>]</option>
	<%} %>
</select>

<input type="button" class="buttonDel" value="" onclick="deleteDgItems(this,'diagnosisId');" align="right" />

<label>Referred To </label>
 <select
	name="referredDepartmentId" multiple="4" size="3"
	id="referredDepartmentId" onclick="getDoctorList();" class="listSm">
	<option value="0">Select</option>
	<%
					  System.out.println("dept List Size :"+deptList.size());
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
<%String reffredArray1[];int len=0;int y=0;

	if(opdPatientDetails.getReferredDept() !=null && opdPatientDetails.getReferredDept().contains(",")){
		reffredArray1=opdPatientDetails.getReferredDept().split(",");
	 	len=reffredArray1.length;
	} else {
		reffredArray1=new String[1];
		len=1;
		reffredArray1[0]=opdPatientDetails.getReferredDept();
	}

	int refferedCounter = 0;
	for(String reffredDept : reffredArray1){ %> <input type="hidden"
	name="selectedReferredDepartmentId" multiple="4" size="3"
	value="<%=reffredDept%>"
	id="selectedReferredDepartmentId<%=refferedCounter%>" /> <%refferedCounter++;
	} %> <script type="text/javascript">
	var x=0;
	var y1 = 0;
	var reffredArray= new Array(<%=reffredArray1.length%>);
	if(document.getElementById('selectedReferredDepartmentId'+y1) != null){
		while(x<<%=len%>){
			reffredArray[x]=document.getElementById('selectedReferredDepartmentId'+y1).value;
			x++;y1++;
		}
	}
	obj = document.getElementById("referredDepartmentId");
	var m=0;
	for ( m=0; m <(obj.options.length); m++ )
	{
		for(x=0;x<<%=len%>;x++)
		{
			if(reffredArray[x]==obj.options[m].value)
			{
				obj.options[m].selected=true
			}
		}

	}


</script>

<div id="referredDoctarsIdDiv"><label class="small">Referred
Doctor </label> <select name="referredDoctarsId" tabindex="1" multiple="4"
	size="3" id="referredDoctarsId" class="listSm">
	<%for(MasEmployee employee : doctarsList){
			String fullDoctorName1 = employee.getFirstName();
			if(employee.getMiddleName() != null){
				fullDoctorName1 = fullDoctorName1 + " "+ employee.getMiddleName();
			}
			if(employee.getLastName() != null){
				fullDoctorName1 = fullDoctorName1 + " " +employee.getLastName();
			}
		%>
	<option value="<%=employee.getId()%>"><%=fullDoctorName1%></option>
	<% } %>
</select></div>
<%String reffredDoctorArray1[];int len1=0;;

	if(opdPatientDetails.getReferedDoctars()!= null
			&& opdPatientDetails.getReferedDoctars().contains(",")){
		reffredDoctorArray1=opdPatientDetails.getReferedDoctars().split(",");
	 	len1=reffredDoctorArray1.length;
	} else {
		reffredDoctorArray1=new String[1];
		len1=1;
		reffredDoctorArray1[0]=opdPatientDetails.getReferedDoctars();
	}
	int refferedDoctorCounter = 0;
	for(String reffredDoctor : reffredDoctorArray1){ %> <input
	type="hidden" name="selectedReferredDoctorId" multiple="4" size="3"
	value="<%=reffredDoctor%>"
	id="selectedReferredDoctorId<%=refferedDoctorCounter%>" /> <%refferedDoctorCounter++;
	} 
%> 
	<script type="text/javascript">
	var x2=0;

	var y2 = 0;
	var reffredDoctorArray= new Array(<%=reffredDoctorArray1.length%>);
	if(document.getElementById('selectedReferredDoctorId'+y2) != null){
		while(x2<<%=len1%>){
			reffredDoctorArray[x2]=document.getElementById('selectedReferredDoctorId'+y2).value;
			x2++;y2++;
		}
	}
	obj = document.getElementById("referredDoctarsId");
	var m=0;
	for ( m=0; m <(obj.options.length); m++ )
	{
		for(x=0;x<<%=len1%>;x++)
		{
			if(reffredDoctorArray[x]==obj.options[m].value)
			{
				obj.options[m].selected=true
			}
		}

	}




</script>
</div>
<%
int inc=1;
if(dgSampleCollectionDetailsList!=null && dgSampleCollectionDetailsList.size()>0){ %>
<%
	for(DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsList){
		String investigationName="";
		investigationName=dgSampleCollectionDetails.getChargeCode().getChargeCodeName()+"["+dgSampleCollectionDetails.getChargeCode().getId()+"]";
	    %> <input type="hidden"
	value="<%=dgSampleCollectionDetails.getId()%>"
	name="dgSampleCollectionDetailsId" id="dgSampleCollectionDetailsId" />
<input type="hidden"
	value="<%=dgSampleCollectionDetails.getSampleCollectionHeader().getId()%>"
	name="dgSampleCollectionHeaderId" id="dgSampleCollectionHeaderId" />

<%} %>
<div class="Block">
<div class="title">Investigation:</div>
<div class="clear"></div>
<label class="small">Template</label> <select
	name="investigationTemplateId"
	onchange="if(checkTemplateId(this.value)){submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=showGridForInvestigation','gridview');}">
	<option value="0">Select</option>
	<%         if(templateList!=null && templateList.size()>0)
	{
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
	}

		%>

</select> <input name="Prevoius" type="button" value="Prev Investigation"
	class="cmnButton"
	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />
<input type="button" class="ButtonDel" alt="Delete" value="&nbsp;"
	onclick="removeRowForInvestigation();" align="right" /> <input
	type="button" class="ButtonAdd" alt="Add" value="&nbsp;"
	onclick="addRowForInvestigation();" align="right" />

<div class="clear"></div>
<div id="gridview">

<div class="floatLeft">
<div class="tableHholder">
<table id="clinicalNoteTable" border="0" cellspacing="0" cellpadding="0">
<%
	     if(dgSampleCollectionDetailsList!=null && dgSampleCollectionDetailsList.size()>0)
	      {
	    	 DgSampleCollectionDetails dgSampleCollectionDetails1 =(DgSampleCollectionDetails)dgSampleCollectionDetailsList.get(0);%>

		<tr>



		<th scope="col">Clinical Notes</th>
<td><input type="text" name="clinicalNotes1"
			value="<%=dgSampleCollectionDetails1.getSampleCollectionHeader().getOrder().getClinicalNote()%>" tabindex="1"
			size="120" /></td>
	</tr>   <%} %>
</table>
<br>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Test Name</th>

	</tr>
	<%inc=1;

		    for(DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsList){
				String investigationName="";
		    	investigationName=dgSampleCollectionDetails.getChargeCode().getChargeCodeName()+"["+dgSampleCollectionDetails.getChargeCode().getId()+"]";
			    %>
	<tr>
		<td><input type="text" value="<%=investigationName%>"
			tabindex="2" id="chargeCodeName<%=inc %>" size="137"
			name="chargeCodeName<%=inc %>"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />

		<div id="ac2update2"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('chargeCodeName<%=inc%>','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc%>'});
			</script></td>


	</tr>
	<%inc++;
		    }
		     %>

</table>

<div class="clear"></div>
</div>
</div>
</div>
<% }else{%>
<div class="colA">
<div class="title">Investigation</div>
<div class="clear"></div>
<label class="small">Template</label> <select
	name="investigationTemplateId"
	onchange="if(checkTemplateId(this.value)){submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=showGridForInvestigation','gridview');}">
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

</select> <input name="Prevoius" type="button" value="Prev Investigation"
	class="cmnButton"
	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />
<input type="button" class="ButtonDel" alt="Delete" value="&nbsp;"
	onclick="removeRowForInvestigation();" align="right" /> <input
	type="button" class="ButtonAdd" alt="Add" value="&nbsp;"
	onclick="addRowForInvestigation();" align="right" />

<div class="clear"></div>
<div id="gridview">

<div class="floatLeft">
<div class="tableHholder">
	<table>
	<tr>
	<th scope="col">Clinical Notes</th>

	<td><input type="text" name="clinicalNotes1" tabindex="1"
			size="120" maxlength="45" /></td></tr>
	</table>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Test Name</th>

	</tr>



	<tr>
		<td><input type="text" value="" tabindex="2" id="chargeCodeName1"
			size="137" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter(document.getElementById('chargeCodeName<%=inc%>'),'ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
			</script></td>

	</tr>
</table>
<div class="clear"></div>
</div>
</div>
</div>
<% }%> <input type="hidden" value="<%=inc%>" name="hiddenValue"
	id="hiddenValue" /></div>

 <% if(patientPrescriptionHeader!=null){%>

<div class="title">Drugs</div>
<div class="clear"></div>
<label class="small">Template</label> <select name="templateId"
	id="templateId"
	onchange="if(checkTemplateId(this.value)){submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=showGridInMainJsp','testDivDrug');}">
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
		   }
	   }

	%>
</select> <input name="Prevoius2" type="button" value="Prev Prescription"
	class="cmnButton"
	onclick="openPopupForPatientPrescription('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />
<input type="button" class="ButtonDel" alt="Delete" value=" "
	onclick="removeRow(this,'grid');" align="right" /> <input type="button"
	class="ButtonAdd" alt="Add" onclick="addRow();" value=" " align="right" />


<div class="clear"></div>
<div id="testDivDrug">
<div class="floatLeft">
<div class="tableHholder">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid">
	<tr>
      	<th colspan="2">Nomenclature</th>
		<th scope="col">PVMS No.</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">Total</th>
		<th scope="col">Type</th>
		<th scope="col"> </th>

	</tr>


	<%

	  int inc1 =1;
	  if(patientPrescriptionHeader.getPatientPrescriptionDetails()!=null){
	  for(PatientPrescriptionDetails patientPrescriptionDetails:patientPrescriptionHeader.getPatientPrescriptionDetails()){ %>
	<tr>
		<td>
		<%MasStoreItem item=patientPrescriptionDetails.getItem();
	    String itemName1=item.getNomenclature()+"["+item.getPvmsNo()+"]";
	   String pvmsNo="";
	   pvmsNo=item.getPvmsNo();

	   String dosage=patientPrescriptionDetails.getDosage();
	   int noOfDays=patientPrescriptionDetails.getNoOfDays();
	   int total=patientPrescriptionDetails.getTotal();
	   String type=patientPrescriptionDetails.getType();
	   int frequencyId=patientPrescriptionDetails.getFrequency().getId();


	    %>

	      <!-- main for loop <input type="text" tabindex="1"
			id="nomenclature1" value="<%=itemName1%>" size="43"
			name="nomenclature<%=inc %>" onblur="populatePVMS(this.value)" />
		<div id="ac2update1"
			style="font-weight: normal; display: none; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter(document.getElementById('nomenclature<%=inc%>'),'ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'});
			</script> -->
		<!-- added by fayaz -->
		<input type="text"  tabindex="1" id="nomenclature1" value="<%=itemName1%>"  size="43"  name="nomenclature<%=inc %>" onblur="populatePVMS(this.value,'value');"  />
	    </td><td>
	    <IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();" title="Click here to Search for Nomenclature">
	     <div id="ac2update1" style=" font-weight:normal;display:none; border:1px solid black; padding-right: 10px; background-color:white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>

		<td><input type="text" name="pvmsNo<%=inc %>"
			id="pvmsNo<%=inc %>" value="<%=pvmsNo %>" size="10"
			readonly="readonly" /></td>
		<td><input type="text" name="dosage<%=inc %>"
			id="dosage<%=inc %>" value="<%=dosage %>" size="10" tabindex="1"
			maxlength="45" /></td>
		<td><select name="frequency<%=inc %>" id="frequency<%=inc %>"
			tabindex="1">
			<option value="0">Select</option>
			<%

		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();

          %>

			<option value="<%=id %>" <%=HMSUtil.isSelected(id,frequencyId) %>><%=name%></option>
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

		<td><input type="text" name="noOfDays<%=inc %>" tabindex="1"
			id="noOfDays<%=inc %>" value="<%=noOfDays %>"
			onblur="fillValue(this.value)" size="3" maxlength="3"
			validate="No Of Days,num,no" /></td>
		<td><input type="text" name="total<%=inc %>" id="total<%=inc %>"
			value="<%=total %>" readonly="readonly" size="5"
			validate="Total,num,no" /></td>
		<td><select name="typeLeftRight<%=inc %>"
			id="typeLeftRight<%=inc %>" tabindex="1">
			<option value="">Select</option>
			<option value="left">Left</option>
			<option value="right">Right</option>
		</select></td>
		<td>
		<input type="checkbox" id="deleteDrugItem" name="deleteDrugItem" >
        </td>
	</tr>
	<%inc++; }}%>
	<input type="hidden" name="hdb" value="<%=inc-1 %>" id="hdb" />


</table>
<div class="clear"></div>

</div>
</div>
</div>
</div>
<% }else{%>
<div class="colA">
<div class="title">Drugs:</div>
<div class="clear"></div>
<label class="small">Template</label> <select name="templateId"
	id="templateId"
	onchange="if(checkTemplateId(this.value)){submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=showGridInMainJsp','testDivDrug');}">
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
		   }
	   }

	%>
</select> <input name="Prevoius2" type="button" value="Prev Prescription"
	class="cmnButton"
	onclick="openPopupForPatientPrescription('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />
<input type="button" class="ButtonDel" alt="Delete" value=" "
	onclick="removeRow(this,'grid');" align="right" /> <input type="button"
	class="ButtonAdd" alt="Add" onclick="addRow();" value=" " align="right" />


<div class="clear"></div>
<div id="testDivDrug">
<div class="floatLeft">
<div class="tableHholder">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid">
	<tr>
		<th colspan="2">Nomenclature</th>
		<th scope="col">PVMS No.</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">Total</th>
		<th scope="col">Type</th>
		<th scope="col"> </th>
	</tr>
	<tr>
		<!-- <td><input type="text" value="" tabindex="1" id="nomenclature1"
			size="43" name="nomenclature1"
			onblur="populatePVMS(this.value),checkItem();" />
		<div id="ac2update1"
			style="font-weight: normal; display: none; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script></td> -->
		<!-- added by fayaz -->
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature1" size="43"  name="nomenclature1" onblur="populatePVMS(this.value,'value');"  />
	    </td><td>
	    <IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();" title="Click here to Search for Nomenclature">
	     <div id="ac2update1" style=" font-weight:normal;display:none; border:1px solid black; padding-right: 10px; background-color:white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>
		<td><input type="text" name="pvmsNo1" id="pvmsNo1" size="10"
			readonly="readonly" /></td>
		<td><input type="text" name="dosage1" id="dosage1" size="10"
			tabindex="1" maxlength="45" /></td>
		<td><select name="frequency1" id="frequency1" tabindex="1">
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

		<td><input type="text" name="noOfDays1" tabindex="1"
			id="noOfDays1" onblur="fillValue(this.value)" size="3" maxlength="3"
			validate="No Of Days,num,no" /></td>
		<td><input type="text" name="total1" id="total1"
			readonly="readonly" size="5" validate="Total,num,no" /></td>
		<td><select name="typeLeftRight1" id="typeLeftRight1"
			tabindex="1">
			<option value="">Select</option>
			<option value="left">Left</option>
			<option value="right">Right</option>
		</select></td>
		<td>
		<input type="checkbox" id="deleteDrugItem" name="deleteDrugItem" >
        </td>
		<input type="hidden" name="hdb" value="1" id="hdb" />
	</tr>

</table>
<div class="clear"></div>

</div>
</div>
</div>
</div>
<% }%> 
<!--Bottom labels starts-->
<div class="clear"></div>
<div class="paddLeft25">
<div class="bottom"><label>Plan</label> <%if(opdPatientDetails.getPlan()!=null && !opdPatientDetails.getPlan().equals("")){ %>
<textarea rows="" cols="" maxlength="1000"
	onkeyup="return ismaxlength(this)" name="plan"><%=opdPatientDetails.getPlan() %></textarea>
<%}else{ %> <textarea rows="" cols="" maxlength="1000"
	onkeyup="return ismaxlength(this)" name="plan"></textarea> <% }%> <label>Next
Visit Date</label> <%if(opdPatientDetails.getNextVisitDate()!=null){String visitDate="";
				visitDate=HMSUtil.convertDateToStringWithoutTime(opdPatientDetails.getNextVisitDate());%>


<input type="text" class="calDate" id="nextVisitDate"
	value="<%=visitDate %>" name="nextVisitDate" readonly="readonly"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=consultationDate %>',document.opdMain.nextVisitDate,event)" />
<%}else{ %> <input type="text" class="calDate" id="nextVisitDate"
	name="nextVisitDate" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=consultationDate %>',document.opdMain.nextVisitDate,event)" />
<% }%>
<div class="clear"></div>
<div class="Height10"></div>
<input id="visitId" name="visitId" type="hidden"
	value="<%=visit.getId()%>" /> <input name="hinId" type="hidden"
	value="<%=visit.getHin().getId()%>" /> <input name="departmentId"
	type="hidden" value="<%=visit.getDepartment().getId()%>" /> <input
	name="hospitalId" type="hidden" value="<%=hospitalId%>" /> <% if(visit.getDoctor()!=null){%>
<input name="empId" type="hidden" value="<%=visit.getDoctor().getId()%>" />
<%}else{ %> <input name="empId" type="hidden" value="" /> <%} %> <input
	name="deptId" type="hidden" value="<%=deptId%>" /> <input
	name="consultationDate" type="hidden" value="<%=consultationDate%>" />
<input name="consultationTime" type="hidden"
	value="<%=consultationTime%>" /> <input name="relation" type="hidden"
	value="<%=visit.getHin().getRelation().getRelationName()%>" /> <input
	type="hidden" name="opdPatientDetailsId"
	value="<%=opdPatientDetails.getId() %>"> <input type="hidden"
	name="opdPatientHistoryId" value="<%=opdPatientHistory.getId() %>">
<%if(patientPrescriptionHeader!=null){ %> <input type="hidden"
	name="patientPrescriptionHeaderId"
	value="<%=patientPrescriptionHeader.getId() %>"> <% }%> <%if(patientInvestigationHeader!=null){ %>
<input type="hidden" name="patientInvestigationHeaderId"
	value="<%=patientInvestigationHeader.getId() %>"> <% }%> <%
	String orderSeqNo="";
	if(mapForDS.get("orderSeqNo") != null){
		orderSeqNo = (String)mapForDS.get("orderSeqNo");
	}
%> <input name="<%=ORDER_NO %>" type="hidden" value="<%=orderSeqNo %>" />

<div class="paddLeft300">
<input name="Submit" type="button"
	align="right" class="button" value="Update"
	onclick="if(validateFieldValues()&& setSelectionForCombo()){submitForm('opdMain','opd?method=finalUpdateOpdPatientDetails&flag=opd');}" /></div>
<input name="Reset" type="reset" align="right" class="button"
	value="Reset" /></div>
	<br>
<br>
<br>
</div>


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
	 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
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
      }
      }
      }
    var url="/hms/hms/adt?method=getIcdWithIcdCodeForOpd&icdCode="+encodeURIComponent(icdCode)
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  	}
  }

	function checkTemplateId(templateId){
      //alert(templateId)
      if(templateId=="0"){
        return false;
        }else
           return true;
    }


 function fillDiagnosisCombo(val) {

	  	  var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var id = val.substring(index1,index2);
		    //alert("function called---"+id)
		    if(id ==""){
			  return;
			}else{
			  obj =document.getElementById('diagnosisId');
			obj.length = document.getElementById('diagnosisId').length;

		        	obj.length++;
					obj.options[obj.length-1].value=id
					obj.options[obj.length-1].text=val
					obj.options[obj.length-1].selected=true
					document.getElementById('icd').value =""

			}

	  }



  function validateBpValue(obj){
	var bpObj = document.getElementById('bp');
	 var bool =validateBpWithSlash(obj)
	if(bool)
	{

	if(obj != ""){
	var index=obj.indexOf('/');
	if(index != 2){
		 alert("BP should be in min/max Format.")
		 bpObj.value="";
		 bpObj.focus();
		 return false;
		 }


		 var pairs2 = obj.substring(0,obj.length).split('/');

		 if (pairs2.length!=2) {
			 alert("Invalid  Format.")
			return false;
			}
		val2=eval(pairs2[0]);
		 if (val2<60 ) {
		  alert("Minimum BP should be greater than 60")
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
			alert("BP is not having Valid Value.");
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
	   				//document.getElementById('chargeCode'+inc).value="";
 					return ;
 			}
 			//document.getElementById('qty'+inc).value="1";
 			return true;
		}


	function addRow(){

	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;


	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){

	                      // alert('event added--'+e0.value+"iteration--"+iteration);
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
						    	//alert("nomenclature---"+nomenclature)
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

	  e0.size = '43';
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('nomenclature'+iteration,'ac2update1','opd?method=getItemList',{parameters:'requiredField=nomenclature'+iteration});
	   //alert("name--"+e0.name)

	  var cellRight1 = row.insertCell(1);
	    var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/s_search.gif';
	  eImg.name = 'search' + iteration;
	  eImg.id = 'search' + iteration;
	  eImg.WIDTH = '26';
	  eImg.HEIGHT = '26';
	  //eImg.id = 'billDateId'+iteration;
	  eImg.onclick = function(){
	   var url="/hms/hms/opd?method=showItemSearchJsp&count="+iteration;
	    newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0"); };
	  cellRight1.appendChild(eImg);

	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10'
	  cellRightSel.appendChild(sel);



	  var cellRight2 = row.insertCell(3);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='dosage'+iteration;
	  e2.id='dosage'+iteration
	  e2.size='10'
	  cellRight2.appendChild(e2);

	  var cellRight3 = row.insertCell(4);
	  var e3 = document.createElement('Select');

	  e3.name='frequency'+iteration;
	  e3.id='frequency'+iteration;
	  e3.classname='smalllabel'
	   e3.options[0] = new Option('Select', 'value0');
	   for(var i = 0;i<icdArray.length;i++ ){
	      e3.options[icdArray[i][0]] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	  cellRight3.appendChild(e3);


	  var cellRight4 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='3'
	  e4.onblur=function(){
	  							var val=e4.value
	  							var freq=e3.value
	  							//alert("frequency-----"+freq)
	  							document.getElementById('total'+iteration).value=val*freq
	  						}
	  cellRight4.appendChild(e4);

	  var cellRight5 = row.insertCell(6);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5'
	  cellRight5.appendChild(e5);


	  var cellRight6 = row.insertCell(7);
	  var e6 = document.createElement('Select');

	  e6.name='typeLeftRight'+iteration;
	  e6.id='typeLeftRight'+iteration;
	  e6.classname='smalllabel'
	   e6.options[0] = new Option('Select', '');
	   e6.options[1] = new Option('Left', 'left');
	   e6.options[2] = new Option('Right', 'right');
	   cellRight6.appendChild(e6);

	     //added - fayaz
	  var cellRight8 = row.insertCell(8);
      var e8 = document.createElement('input');
      e8.id = 'a'
      e8.type = 'checkbox';
      cellRight8.appendChild(e8);


	}


	function removeRow(argIndex,idName)
	{
	  var status = removeRowDelete(argIndex,idName);

	  //alert(status)
		if(!status)
		{
		//alert("INSIEDE IF");
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
	}

	function removeRowForInvestigation()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	}
	function populatePVMS(val){
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
	   	document.getElementById('nomenclature1').value="";
	    document.getElementById('pvmsNo1').value="";
	   return;
	   }
	   else
	      document.getElementById('pvmsNo1').value=pvmsNo


	 }
	}
function checkItem(){


var tbl = document.getElementById('grid');
var lastRow = tbl.rows.length;



var iteration = lastRow-1;

var pvmsNo=document.getElementById("pvmsNo"+iteration).value
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
	           	alert("This is Alergic for this patient..!")
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
    var url="/hms/hms/opd?method=checkItem&pvmsNo="+pvmsNo+"&visitId="+visitId

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

}

	 function  fillValue(value){

	  //alert(value)
	  var freq=document.getElementById('frequency1').value
	  document.getElementById('total1').value=freq*value
	 }

	 function addRowForInvestigation(){

	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;

	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  if(hdb==null){
	  	document.getElementById('hiddenValue').value
	   	iteration=1;
	  }
	  hdb.value=iteration
	  // alert("iteration row--"+iteration)

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){

	  						if(validateInvestigationAutoComplete(this.value,iteration)){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration);}

	  					  };
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  //alert("name--"+e0.name)
	  e0.size = '137'
	  cellRight0.appendChild(e0);
		new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});

	  //faayz removed
	  //var cellRight3 = row.insertCell(1);
	  //var e3 = document.createElement('input');
	  //e3.type = 'text';
	  //e3.name='clinicalNotes'+iteration;
	  //e3.id='clinicalNotes'+iteration;
	  //e3.size='60'
	  //cellRight3.appendChild(e3);

	}
  </script> <script type="text/javascript">
		function openPopupForPatientPrescription(visitNo,hinId){
		 // alert("in pop up window visit No---"+visitNo+"---- hin id ---"+hinId)


		if(visitNo >1){
		var url="/hms/hms/opd?method=showPatientPreviousPrescription&visitNo="+visitNo+"&hinId="+hinId;
        newwindow=window.open(url,'name',"height=300,width=950,status=1");
        }else{
          alert("This Is Patient's first Visit.")
        }
     }

     function submitDetails(){

		 // alert("in showPreviousVisit")
        document.opdMain.action="hms/hms/opd?method=submitOPDPatientDetails";
        document.opdMain.submit();
        document.opdMain.action="opd?method=showEntJsp&visitId=<%=visit.getId() %>"
        document.opdMain.submit();


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
		submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=responseForDoctarsList&referredDepartmentId='+indexes+'','referredDoctarsIdDiv');
	}

     function showPreviousVisit(visitNo){
		  //alert("in showPreviousVisit")
		if(visitNo >1){

        document.opdMain.action="/hms/hms/opd?method=showPatientPreviousVisit&hinId=<%=visit.getHin().getId()%>&deptId=<%=visit.getDepartment().getId()%>&visitNo=<%=visit.getVisitNo() %>";
        document.opdMain.submit();
        }else{
          alert("This Is Patient's first Visit.")
        }
     }

     function openPopupForPatientInvestigation(visitNo,hinId){
		  //alert("in pop up window visit No---"+visitNo+"---- hin id ---"+hinId)


		if(visitNo >1){
		var url="/hms/hms/opd?method=showPatientPreviousInvestigation&visitNo="+visitNo+"&hinId="+hinId;
        newwindow=window.open(url,'name',"height=300,width=600,status=1");
        }else{
          alert("This is Patient's First Visit. ")
        }
     }

 function deleteItems(value){
 if(document.getElementById('diagnosisId').selectedIndex!=0){
	 if(confirm("are you sure want to delete ?")){


		    //alert("function called---"+id)ListDates.remove(ListDates.selectedIndex)
		    document.getElementById('diagnosisId').remove(document.getElementById('diagnosisId').selectedIndex)

	  }
	  }

 }
 function setSelectionForCombo(){

 var obj=document.getElementById('diagnosisId');
var m=0;

for ( m=0; m <(obj.options.length); m++ )
{
if(obj.options[m].value!=0){
obj.options[m].selected=true;

}
}
if(document.getElementById("hdb").value==""){

var tbl = document.getElementById('grid');
var lastRow = tbl.rows.length;
document.getElementById("hdb").value=lastRow;
alert(document.getElementById("hdb").value);

}
//storing nomenclature in combobox


return true;

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
	      	document.getElementById('clinicalNotes'+inc).value="";
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
		//submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=fillChargeCodeForInvestigation&chargeCodeNAmeForAjax='+ tempChargeCodeString+'&rowVal=1',chargeCodeTdDiv);

		}else{
			document.getElementById('chargeCodeName'+inc).value = "";
			document.getElementById('qty'+inc).value = "";
			//document.getElementById('chargeCode'+inc).value = "";
			//document.getElementById('qty'+inc).value = "";
			//document.getElementById('qty'+inc).value = "";
		}
	}
  function deleteDgItems(value){
     if(document.getElementById('diagnosisId').selectedIndex!=0){
	 if(confirm("are you sure want to delete ?")){

 	 		document.getElementById('diagnosisId').remove(document.getElementById('diagnosisId').selectedIndex)

	    }
	   }
     }

     //added-- fayaz

	function removeRowDelete(argIndex,idName){



	         var table=document.getElementById(idName);

	         var tblRows  = table.getElementsByTagName("tr");

	         var check=0;



	         for(i=tblRows.length-1;i>0;i--)

	        {

	         var tblCtrl =  tblRows[i].getElementsByTagName("input");





	               for(j=0;j<tblCtrl.length;j++)

	               {

	                  if(tblCtrl[j].type == 'checkbox')

	                   {

	                    if(tblCtrl [j].checked)

	                              check=check+1;

	                   }

	               }

	        }

			var counter = false;

	        for(i=tblRows.length-1;i>0;i--)

	        {

	         var tblCtrl =  tblRows[i].getElementsByTagName("input");



	               for(j=0;j<tblCtrl.length;j++)

	               {

	                  if(tblCtrl[j].type == 'checkbox')

	                   {

	                    if(tblCtrl [j].checked)

	                    	{

	                              document.getElementById(idName).deleteRow(i);

	                              counter=true;

	                        }

	                   }

	               }

	        }

	        return counter;

     }



		</script></div>
</div>
</div>
</form>




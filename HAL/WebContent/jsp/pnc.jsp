<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<%@page import="jkt.hms.masters.business.MasTherapyType"%>

<%@page
	import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>

<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%><script
	type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

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
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}
	List<OpdPatientDetails> opdDetailListForFollowUp = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> opdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
	List<PatientInvestigationHeader>patientInvestigationHeaderListForFollowUp = new ArrayList<PatientInvestigationHeader>();
	Set<PatientInvestigationDetails> patientInvestigationdetails = null;
	List<PatientPrescriptionHeader> patientPrescriptionHeaderList = new ArrayList<PatientPrescriptionHeader>();
	List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
	List<Visit>pncDataList = new ArrayList<Visit>();
	if(map.get("opdDetailListForFollowUp") != null){
		opdDetailListForFollowUp=(List)map.get("opdDetailListForFollowUp");
	}
	if(map.get("dischargeIcdCodeList") != null){
		dischargeIcdCodeList=(List)map.get("dischargeIcdCodeList");
	}
	if(map.get("opdHistoryDetailsListForFollowUp") != null){
		opdHistoryDetailsListForFollowUp=(List)map.get("opdHistoryDetailsListForFollowUp");
	}
	if(map.get("pncDataList") != null){
		pncDataList= (List<Visit>)map.get("pncDataList");
	}
	if(map.get("patientInvestigationHeaderListForFollowUp") != null){
		patientInvestigationHeaderListForFollowUp=(List)map.get("patientInvestigationHeaderListForFollowUp");
	}
	if(map.get("patientPrescriptionHeaderList") != null){
		patientPrescriptionHeaderList=(List)map.get("patientPrescriptionHeaderList");
	}
	OpdPatientDetails opdDetailsForFollowup = null;
	if(opdDetailListForFollowUp.size()>0){
		opdDetailsForFollowup = opdDetailListForFollowUp.get(0);
	}
	List<OpdPatientDetails> opdDentalDetailsList = new ArrayList<OpdPatientDetails>();
	if(map.get("opdDentalDetailsList") != null){
		opdDentalDetailsList=(List<OpdPatientDetails>)map.get("opdDentalDetailsList");
	}
	OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
	if(opdDentalDetailsList.size() > 0){
		opdPatientDetails = opdDentalDetailsList.get(0);
	}
	OpdPatientHistory opdPatientHistory = null;
	if(opdHistoryDetailsListForFollowUp.size()>0){
		opdPatientHistory = opdHistoryDetailsListForFollowUp.get(0);
	}
	
	PatientInvestigationHeader patientInvestigationHeader = null;
	if(patientInvestigationHeaderListForFollowUp.size()>0){
		patientInvestigationHeader = patientInvestigationHeaderListForFollowUp.get(0);
		patientInvestigationdetails = patientInvestigationHeader.getPatientInvestigationDetails();
	}
	PatientPrescriptionHeader patientPrescriptionHeader = null;
	if(patientPrescriptionHeaderList.size()>0){
		patientPrescriptionHeader = patientPrescriptionHeaderList.get(0);
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
	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
	if(map.get("disposalList") != null){
		disposalList=(List)map.get("disposalList");
		}
	List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
	if(map.get("itemConversionList") != null){
		itemConversionList=(List)map.get("itemConversionList");
		}
	List<MasMedicalExaminationReportOnEntry> medicalList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	MasMedicalExaminationReportOnEntry meddata=new MasMedicalExaminationReportOnEntry();
	if(map.get("medicalList") != null){
		medicalList=(List)map.get("medicalList");
		}
	
	if(medicalList.size()>0)
	{
	//	meddata=(MasMedicalExaminationReportOnEntry)medicalList.get(0);
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	Visit visit=null;
	String visitDateInString="";
	String departmentName="";
	String departmentCode="";
	String patientName="";
	String servicePersionName="";
	int deptId=0;
	Set<MasMedicalExamFamilyHis> familyHisSet = new HashSet<MasMedicalExamFamilyHis>();
	if(pncDataList.size()>0)
	{
	 visit=(Visit)pncDataList.get(0);

	
	if(visit.getHin().getPFirstName()!= null){
	patientName=visit.getHin().getPFirstName();
	}
	if(visit.getHin().getPMiddleName()!= null){
	patientName=patientName+" "+visit.getHin().getPMiddleName();
	}
	if(visit.getHin().getPLastName()!= null){
	patientName=patientName+" "+visit.getHin().getPLastName();
	}
	 visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	 deptId=visit.getDepartment().getId();
	 departmentName=visit.getDepartment().getDepartmentName();
	 departmentCode=visit.getDepartment().getDepartmentCode();
	
	
	
	if(visit.getHin().getMasMedicalExamFamilyHis() !=null){
		familyHisSet  = visit.getHin().getMasMedicalExamFamilyHis() ;
	}
	}
	%>
<!--main content placeholder starts here-->
<body onLoad="coolDental()">
<form name="pnc" action="" method="post">
<input type="hidden"	name="userName" value="<%=userName %>" />

<div class="titleBg">
<h2>PNC</h2>
</div>




<div class="clear"></div>

<script type="text/javascript">
	   var icdArray=new Array();
	   var iArray=new Array();

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

if(visit.getHin()!= null && visit.getHin().getRelation()!=null&&visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self"))
{ 
%> <label>Service No.</label> <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %></label> <%}else{ %>
<label class="value">&nbsp;</label>
<%} %> <label>Patient Name</label> <%if(visit.getHin() != null){
		Patient patient =visit.getHin();
	if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){

					String sMiddleName = "";
					String sLastName = "";
					if(patient.getSMiddleName() != null){
						sMiddleName = patient.getSMiddleName();
					}
					if(patient.getSLastName() != null){
						sLastName = patient.getSLastName();
					}%> <label class="value"><%=patient.getSFirstName()+" "+sMiddleName+" "+sLastName %></label>
<%}}else{ %> <label class="value"></label> <%} %> <label>Relation</label> <%if(visit.getHin().getRelation()!= null){ %>
<label class="value"><%=visit.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="value">&nbsp;</label>
<%} %>

<div class="clear"></div>
<label>Rank</label> <%if(visit.getHin().getRank()!= null){ %> <label
	class="value"><%=visit.getHin().getRank().getRankName() %></label> <%}else{ %>
<label class="value">&nbsp;</label>
<%} %> <label>Name</label> <%if(visit.getHin() != null){
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
					}%> <label class="value"><%=patientName %></label> <%} %> <label>Trade/Branch</label>
<%if(visit.getHin().getTrade() != null){ %> <label class="value"><%=visit.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="value">&nbsp;</label>
<%} %>
<div class="clear"></div>
<label>Unit</label> <%if(visit.getHin().getUnit() != null){ %> <label
	class="value"><%=visit.getHin().getUnit().getUnitName() %></label> <%}else{ %>
<label class="value">&nbsp;</label>
<%} %> <label>Age</label> <%if(visit.getAge()!= null){ %> <label
	class="value"><%=visit.getAge() %></label> <%}else{ %> <label
	class="value">&nbsp;</label>
<%} %> <%if(visit.getAge()!= null){ %> <input type="hidden" name="ageId"
	id="ageId" value="<%=visit.getAge() %>"> <%} %> <label>Gender</label>
<%if(visit.getHin().getSex() != null){ %> <label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
<input type="hidden" name="genderId" id="genderId"
	value="<%=visit.getHin().getSex().getId() %>"> <%}else{ %> <label
	class="value">&nbsp;</label>
<%} %>

<div class="clear"></div>
<label>Occupation</label> <%if(visit.getHin().getOccupation()!= null){ %>
<label class="value"><%=visit.getHin().getOccupation().getOccupationName() %></label>
<%}else{ %> <label class="value">&nbsp;</label>
<%} %> <label>Marital Status</label> <%if(visit.getHin().getSrMaritalStatus()!= null){ %>
<label class="value"><%=visit.getHin().getSrMaritalStatus().getMaritalStatusName() %></label>
<%}else{ %> <label class="value">&nbsp;</label> <%} %> <label>Blood
Group</label> <%
if(visit.getHin().getBloodGroup() != null ){ %> <label class="value"><%=visit.getHin().getBloodGroup().getBloodGroupName() %></label>
<%}else{ %> <label class="value">&nbsp;</label> <%} %>
<div class="clear"></div>
<%-- <label >Medical Category</label>
<%if(visit.getHin().getCategory() != null){ %>
<label class="value"><%=visit.getHin().getCategory().getCategories() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label>Date</label>
<%if(meddata.getDateOfReporting() != null){ %>
<label class="value"><%=meddata.getDateOfReporting() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>--%> 
<label>Medical Disability</label> <%if(meddata.getPresentDisability()!= null){ %> <label
	class="value"><%=meddata.getPresentDisability().getDisability() %></label>
<%}else{ %> <label class="value">&nbsp;</label>
<%} %> <!-- <label >Medication</label> --> <%--if(meddata.getInstructionByPresident() != null){ --%>
<!-- <label class="value">meddata.getInstructionByPresident()</label> -->
<%--}else{ --%> <!-- <label class="value">&nbsp;</label> }--> <!-- <label >Allergies</label> -->
<%--if(visit.getHin() != null){ --%> <!-- <label class="value">&nbsp;</label> -->
<%--}else{ --%> <!--  <label class="value">&nbsp;</label>  --> <%--} --%>

<label>Current Year's Visit</label> <label class="value"><%=visitCount%></label>

<label >Date of Marriage</label> 
<input	tabindex="1" name="dateofMarriage" class="date" maxlength="10" readonly="readonly" value="<%=visit.getHin().getSrMarriageDate()!= null?visit.getHin().getSrMarriageDate():"" %>" />



<div class="clear"></div>
<label>No. of Children</label>
<input type="text" name="noOfChildren"	 maxlength="1" />
 
<label>Gender</label>
<select name="gender">
	<option>Male</option>
	<option>Female</option>
</select>

<label>Delivery</label> 
<select name="delivery">
	<option value="Normal">Normal</option>
	<option value="Abnormal">Abnormal</option>
</select>


<% }else{%> <label>Service No.</label> <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %></label> <%}else{ %>
<label class="value">&nbsp;</label>
<%} %> <label>Patient Name</label> <%if(visit.getHin() != null){
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
					}%> <label class="value"><%=patientName %></label> <%} %> <label>Relation</label>
<%if(visit.getHin().getRelation()!= null){ %> <label class="value"><%=visit.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="value">&nbsp;</label>
<%} %>

<div class="clear"></div>
<label>Rank</label> <%if(visit.getHin().getRank()!= null){ %> <label
	class="value"><%=visit.getHin().getRank().getRankName() %></label> <%}else{ %>
<label class="value"></label> <%} %> <label>Name</label> <label
	class="value"><%=servicePersionName %></label> <label>Trade/Branch</label>
<%if(visit.getHin().getTrade() != null){ %> <label class="value"><%=visit.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="value">&nbsp;</label>
<%} %>

<div class="clear"></div>

<label>Unit</label> <%if(visit.getHin().getUnit() != null){ %> <label
	class="value"><%=visit.getHin().getUnit().getUnitName() %></label> <%}else{ %>
<label class="value">&nbsp;</label>
<%} %> <label>Age</label> <%if(visit.getAge()!= null){ %> <label
	class="value"><%=visit.getAge() %></label> <%}else{ %> <label
	class="value">&nbsp;</label>
<%} %> <label>Gender</label> <%if(visit.getHin().getSex() != null){ %> <label
	class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
<input type="hidden" name="genderId" id="genderId"
	value="<%=visit.getHin().getSex().getId() %>"> <%}else{ %> <label
	class="value">&nbsp;</label>
<%} %>

<div class="clear"></div>

<label>Occupation</label> <%if(visit.getHin().getOccupation()!= null){ %>
<label class="value"><%=visit.getHin().getOccupation().getOccupationName() %></label>
<%}else{ %> <label class="value">&nbsp;</label>
<%} %> <label>Marital Status</label> <%if(visit.getHin().getMaritalStatus() != null){ %>
<label class="value"><%=visit.getHin().getMaritalStatus().getMaritalStatusName() %></label>
<%}else{ %> <label class="value">&nbsp;</label> <%} %> <label>Blood
Group</label> <%if(visit.getHin().getBloodGroup() != null){ %> <label
	class="value"><%=visit.getHin().getBloodGroup().getBloodGroupName() %></label>
<%}else{ %> <label class="value">&nbsp;</label> <%} %>
<div class="clear"></div>
<!-- <label >Allergies</label> --> <%--if(visit.getHin() != null){ --%>
<!-- <label class="value">&nbsp;</label> --> <%--}else{ --%> <!--<label class="value">&nbsp;</label> -->
<%--} --%> <label>Current Year's Visit</label> <label class="value"><%=visitCount%></label>
<%-- 
<%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label> 
<%}else{ %> 
<label class="value">&nbsp;</label><%} %>
 --%> <% }%>
<div class="clear"></div>
</div>


<script type="text/javascript">
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
function validateFieldValuesPediatricsOpd(){

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
	    var url="/hms/hms/opd?method=showItemSearchJsp&count="+1;
	    newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	}

	function jsSetUnitData(id,pvms,nomenclature,count)
	{
	document.getElementById('nomenclature'+count).value = nomenclature+'['+pvms+']'
	document.getElementById('nomenclature'+count).focus();
	}
	function openPopupANCINITIALVisit()
	{
		var url="/hms/hms/fwc?method=showAntentatalCardFollowUpJsp&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>";
	   	newwindow=window.open(url,'pnc','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
	}

	function openPopupDeliveryDeatils()
	{
		var url="/hms/hms/fwc?method=showDeliveryDetails&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>";
	   	newwindow=window.open(url,'pnc','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
	}

</script>


<div>

<input	name="investigationTemplate" type="button"	value="Antentatal Details" tabindex="1" class="buttonBig" 
onclick="openPopupANCINITIALVisit();" />
<input	name="" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&reportingFor=FamilyWC&backFlag=fp')"/>
<input	name="" type="button"	value="Previous Prescriptions" tabindex="1" class="buttonBig2" onclick="javascript:openPopupPrescriptions(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getDepartment().getId()%>,<%=visit.getHin().getId()%>,'FamilyWC&backFlag=fp')"/>
<input	name="" type="button"	value="Previous Investigations" tabindex="1" class="buttonBig2" onclick="javascript:openPopupInvestigation(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getDepartment().getId()%>,<%=visit.getHin().getId()%>,'FamilyWC&backFlag=fp')"/>
<input	name="" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>')" />
<input	name="" type="button"	value="MLC Details" tabindex="1" class="buttonBig2" onclick="openWindow('/hms/hms/adt?method=showMlcJsp&hinId=<%=visit.getHin().getId() %>&reportingFor=FamilyWC&backFlag=fp')"/>
<input	name="" type="button"	value="Upload Documents" tabindex="1" class="buttonBig2" onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&visitId=<%=visit.getId() %>&reportingFor=FamilyWC&backFlag=fp')"/>

<input	name="investigationTemplate" type="button"	value="Delivery Details" tabindex="1" class="buttonBig" 
onclick="openPopupDeliveryDeatils();" />

</div>
<div class="clear"></div>



<div class="clear"></div>
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="ancGrid">
	<tr>
		<TH scope="col" rowspan="">Date</th>
		<TH scope="col" rowspan="">Weight</th>
		<TH scope="col" rowspan="">BP mm Hg</th>
		<TH scope="col" rowspan="">Breast</th>
		<TH scope="col" rowspan="">Compliants</th>
		<TH scope="col" rowspan="">PAP Smear</th>
		<TH scope="col" rowspan="">Other Findings</th>
		<TH scope="col" rowspan="">Distant Vision</th>
		<TH scope="col" rowspan="">Near Vision</th>
		
		
	</tr>
	<tr>
		<td>
		

		<input type="text"	id="dateAnc" name="dateAnc" readonly="readonly" validate="Date,date,no"	/>
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',pnc.dateAnc,event);" />

		</td>
		<td>
		<input name="weight" tabindex="1" type="text" id="weight" value="<%=opdDetailsForFollowup !=null && opdDetailsForFollowup.getVweight()!=null?opdDetailsForFollowup.getVweight():"" %>" 
		onblur="calculateBMI()" class="auto" size="5" validate="weight,int,no"
		maxlength="3" />
		</td>
		<td> <input name="bp" id="bp" type="text" tabindex="1" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getBp()!= null?opdDetailsForFollowup.getBp():"" %>"  class="auto" size="5"	onblur="validateBpValue(this.value);" maxlength="7" />
		</td>
		<td><input type="text" name="breastExam" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getBreastExam() != null ? opdDetailsForFollowup.getBreastExam():"" %>" id="breastExam" maxlength="45" />
		</td>
		<td>
		<textarea name="presentComplain" cols="0" rows="0" maxlength="950" 	validate="Complaints,metachar,yes" value=""  tabindex="1"	onkeyup="return ismaxlength(this)">	<%=opdPatientHistory != null && opdPatientHistory.getPresentComplain()!=null ?opdPatientHistory.getPresentComplain():"" %>	</textarea>
		</td>
		<td>
		<input type="text" name="papSmear" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getPapSmear() != null ? opdDetailsForFollowup.getPapSmear():"" %>" id="papSmear" maxlength="45" />
		</td>
		<td><input type="text" name="otherObservation" id="otherObservation" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getOtherFinding() != null ? opdDetailsForFollowup.getOtherFinding():"" %>" maxlength="45" />
		</td>
		<td>
		<input	type="text" name="distantVision" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getDistantVision()!=null ?opdDetailsForFollowup.getDistantVision():"" %>" id="distantVision" maxlength="5" validate='DistantVision,int,no' /> 
		</td>
		<td> <input type="text" name="nearVision" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getNearVision()!=null ?opdDetailsForFollowup.getNearVision():"" %>"  id="nearVision"  maxlength="5" validate='NearVision,int,no'/>
		</td>
	</tr>



</table>
</div>
<div class="clear paddingTop15"></div>
<div class="Block">

<label>Past Medical History</label> <!--  <input type="text" id="presentComplain"  name="presentComplain" maxlength="100"/>-->
<textarea name="pastMedicalHistory" cols="0" rows="0" maxlength="300"
	value="" tabindex="1" onkeyup="return ismaxlength(this)">
	<%=opdPatientHistory != null && opdPatientHistory.getPastMedicalHistory()!= null?opdPatientHistory.getPastMedicalHistory():"" %>
	</textarea>

<label>Family History</label> <!--  <input type="text" id="presentComplain"  name="presentComplain" maxlength="100"/>-->
<select name="familyHistory" id="familyHistory" tabindex="1"
	multiple="multiple" class="list" onclick="openOtherField(this.value);">
	<option value="0">select</option>
	<%
	if(patientFamilyHistoryList.size() > 0){
		System.out.println("patientFamilyHistoryList==="+patientFamilyHistoryList.size());
		for(PatientFamilyHistory familyHistory : patientFamilyHistoryList){
		%>
	<option value="<%=familyHistory.getId() %>"><%=familyHistory.getPatientHistoryName() %></option>
	<%}
	}
%>
</select>
<div id="otherFamilyHistoryDiv" style="display: none;"><label>Other</label>
<input type="text" name="otherFamilyHistory" id="otherFamilyHistory"
	value=""></div>
<script>
<%
if(visit.getHin().getOtherFamilyHistory()!=null){
%>
document.getElementById('otherFamilyHistoryDiv').style.display = 'block';
document.getElementById('otherFamilyHistory').value='<%=visit.getHin().getOtherFamilyHistory()%>'
<%}%>
<%--for display patient history --%>
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

</script>
<label>Risk Factors</label> 
<textarea name="riskFactor" cols="0" rows="0" maxlength="300" value=""	tabindex="1" onkeyup="return ismaxlength(this)">
	<%=opdPatientHistory != null && opdPatientHistory.getRiskFactor()!= null?opdPatientHistory.getRiskFactor():"" %>
	</textarea>
	
	</div>
<div class="clear"></div>


<div class="clear paddingTop15"></div>
<h4>Diagnosis</h4>
<div class="Block">

<div class="floatLeft"><!-- 	<label >On Examination</label>  --> <input
	type="hidden" id="systamicExam" class="large" name="systamicExam"
	maxlength="200" /> <label>Working Diagnosis</label> 
	
	<% 

if( opdDetailsForFollowup != null && opdDetailsForFollowup.getInitialDiagnosis()!=null)
{%>
<input type="text" class="auto"   id="initialDiagnosis" tabindex="1" size="117" value="<%=opdDetailsForFollowup.getInitialDiagnosis() %>"	name="initialDiagnosis" maxlength="100" onblur="populateClinicalNotes(this);" />
<% }else{%>
	<input type="text"
	class="auto" id="initialDiagnosis" tabindex="1" value="" size="117"
	name="initialDiagnosis" maxlength="100"
	onblur="populateClinicalNotes(this);" />
<% }%>
	


<div class="clear"></div>

<label>System Diagnosis</label> <input name="systemDiagnosis" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getSystemDiagnosis()!= null?opdDetailsForFollowup.getSystemDiagnosis().getSystemDiagnosisName()+"["+opdDetailsForFollowup.getSystemDiagnosis().getId()+"]":"" %>"
	id="systemDiagnosis" tabindex="1" class="auto" onblur="" size="117" />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('systemDiagnosis','ac2update','opd?method=autoCompleteForSystemDiagnosis',{parameters:'requiredField=systemDiagnosis'});
		</script>

<div class="clear"></div>
<%--
<label>ICD Code</label>
<input name="" value=""	id="icdCode" tabindex="1" class="auto" size="117" onblur="getIcd();" />
<input name="" value=""	id="temp" type="hidden" /> 
<IMG SRC="/hms/jsp/images/search.gif"	WIDTH="24" HEIGHT="20" style="cursor: pointer; margin:0px;" class="floatLeft"	onClick="javascript:openPopupWindow();"	title="Click here to Search ICD Codes" />
 --%> <input type="hidden" name="ageName"
	value="<%=visit.getHin().getAge() %>" id="ageId" />

<div class="clear"></div>
<label>ICD Diagnosis</label> <input type="text" tabindex="1" value=""
	id="icd" name="icd" class="auto" size="55"
	onblur="fillDiagnosisCombo(this.value);" />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
		   //document.getElementById('slide0').style.display="hide"
</script> 
<select name="<%=DIAGNOSIS_ID%>" multiple="4" size="5" tabindex="1"  id="diagnosisId" class="listBig">
	<option value="0">Select</option>
	<%
		if(dischargeIcdCodeList.size()>0){
			for(DischargeIcdCode icdCode : dischargeIcdCodeList){
	%>
	<option value="<%=icdCode.getIcd().getIcdCode() %>" selected="selected"><%=icdCode.getIcd().getIcdName()+"["+icdCode.getIcd().getIcdCode()+"]" %></option>
	<%}
			}%>
</select>


<input type="button" class="buttonDel" value=""
	onclick="deleteDgItems(this,'diagnosisId');" align="right" /></div>
<!-- floatLeft ends -->
<div class="floatRight"><input name="investigationTemplate"
	type="button" onclick="showDiagnosis()" tabindex="1"
	class="btn_Diagnosis_Assist" /></div>
<!-- floatRight ends --></div>
<div class="clear"></div>
<!-- fayaz added -->
<h4>INVESTIGATION</h4>
<div class="Block">
<label >Template</label>
<div id="investigationDiv">
<select name="investigationTemplateId" id="investigationTemplateId" tabindex="1" multiple="multiple" class="list" onblur="showHideInvestigationTemplateCombo();">
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
	<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getId()+" "+opdTemplate.getTemplateName()%></option>
	<%
		   }
	      }

		%>

</select>
</div>
<%-- <input	name="Prevoius" type="button" value="Previous" tabindex="1"	class="button"	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />--%>
<div id="createInvestigationDivToShowHide">
<input	name="investigationTemplate" type="button"	value="Create Template" tabindex="1" class="buttonBig" onclick="showCreateInvestigationTemplate();" />
</div>
<div id="copyPrevInvestigationTemplateDiv" style="display: none">
<input name="copyPrevInvestigationTemplate" tabindex="1" type="button"	value="Copy Previous" class="buttonBig" onclick="copyPrevInvestigationTempate('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>');" />
</div>
<div id="investigationImportButton1" >
<input	name="investigationImportButton1" tabindex="1" type="button"	value="Import New" class="button"	onclick="getListForTreatment('investigationDiv');" />
</div>
</div>
<div class="clear"></div>
<div class="Block">
<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Investigation</th>
		<th scope="col">Refer to MH</th>
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
		<td><input type="text"  value="<%=investigationName %>" tabindex="1" id="chargeCodeName1"
			size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc%>'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
<%if(patientInvestigation.getReferToMh().equals("") && patientInvestigation.getReferToMh().equals("y") ){ %>
		<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio" checked="checked" validate="Refer to MH,metachar,no" /></td>
		<%}else{ %>
		<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,metachar,no" /></td>
		<%} %>
		
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
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
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
	
		<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,metachar,no" /></td>
	
		<td><input name="Button" type="button" class="buttonAdd" value="" tabindex="1"
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" tabindex="1"
			onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


	</tr>
	
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
	
	<%} %>



</table>
</div>
<div class="clear paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid1">
	<tr>
		<th scope="col">Clinical Notes</th>

	</tr>
	<tr>
		<%
	if(patientInvestigationHeader != null){
	if(patientInvestigationHeader.getClinicalNotes()!= null){ %>
		<td><input type="text" name="clinicalNotes1" id="clinicalNotes" tabindex="1" value="<%=patientInvestigationHeader.getClinicalNotes() %>"
			size="100" maxlength="98" /></td>
			<%}}else{ %>
			<td><input type="text" name="clinicalNotes1" id="clinicalNotes" tabindex="1" value="" size="98" maxlength="42" /></td>
			<%} %>
	</tr>
</table>
</div>

<%
	if (patientPrescriptionHeader != null) {
			//System.out.println("this is if");
%>
<div class="clear paddingTop15"></div>
<h4>Treatment</h4>
<div class="cmntable">
<div class="Clear"></div>
<div id="testDivDrug">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid">
	<tr>
		<th colspan="col">PVMS/NIV Nomenclature</th>
		
		 <th colspan="1">Other Drug</th>
		<!-- <th scope="col">Injection</th> -->
		<!--  <th scope="col">Unit</th>-->
		<th scope="col">Unit</th>
		<th scope="col">AU</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
			<th scope="col">Route</th>
		<!--<th scope="col">Intake</th>-->
		<!-- <th scope="col">Type</th> -->
		<th scope="col">Remarks</th>
		<th scope="col">CT</th>
		<th scope="col">Stock</th>

 <th scope="col">Add</th>
<th scope="col">Delete</th>
	</tr>


	<%
		int inc1 = 1;
				if (patientPrescriptionHeader.getPatientPrescriptionDetails() != null) {
					for (PatientPrescriptionDetails patientPrescriptionDetails : patientPrescriptionHeader
							.getPatientPrescriptionDetails()) {
	%>
	<tr>
		<td>
		<%
			MasStoreItem
			item = patientPrescriptionDetails
									.getItem();
							String itemName1 = item.getNomenclature() + "("+ item.getId() + ")" + "["+ item.getPvmsNo() + "]";
							String pvmsNo = "";
							pvmsNo = item.getPvmsNo();

							String dosage = patientPrescriptionDetails
									.getDosage();
							int noOfDays = patientPrescriptionDetails
									.getNoOfDays();
							int total = patientPrescriptionDetails.getTotal();
							String type = patientPrescriptionDetails.getType();
							int frequencyId = patientPrescriptionDetails
									.getFrequency().getId();
							String instruction = patientPrescriptionDetails
									.getInstruction();
							String remark = patientPrescriptionDetails
									.getRemarks();
							String au = patientPrescriptionDetails.getItem().getItemConversion().getItemUnitName();
							String route = patientPrescriptionDetails.getRoute();
		%> 
	    
			<input type="text" tabindex="1"	id="nomenclature<%=inc1 %>" size = "30" readonly="readonly" value="<%=itemName1%> "
			size="50" name="nomenclature<%=inc1%>"  onblur="disableOtherMedicine();"/>
			<div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature<%=inc1%>','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature<%=inc1%>'});
			</script>
			</td>
	
		<td><input type="text" name="otherMedicine<%=inc1%>" tabindex="1" id="otherMedicine<%=inc1%>"   size="20"	 validate="Other Medicine,metachar,no" onblur="showSimilarMedicineNames(this.value);"/></td>
<%-- <td><input type="checkbox" name="injCategory" class="radio" id="injCategory" value="false"   /></td>--%>
<td><select name="itemConversionId1" id="itemConversionId1" tabindex="1" class="medium" disabled="disabled"  >
			<option value="0">Select</option>
			<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
			<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
			<%} %>
		</select>
		<%
	    		MasStoreItemConversion  masStoreItemConversion = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion.getItemUnitName()%>";
            </script> <% }%>
		</td>
<%if(au != null){ %>
		<td>
		<input type="text" name="au<%=inc1%>" tabindex="1" value="<%=au %>" id="au<%=inc1%>"  size="6"  validate="AU,metachar,no" />
		<input type="hidden" name="actualDispensingQty<%=inc1%>" tabindex="1" id="actualDispensingQty<%=inc1%>" value=""  size="6"  validate="AU,metachar,no" />
			</td>
			<%}else{ %>
			<td>
		<input type="text" name="au<%=inc1%>" tabindex="1" value="" id="au<%=inc1%>"  size="6"  validate="AU,metachar,no" />
		<input type="hidden" name="actualDispensingQty<%=inc1%>" tabindex="1" id="actualDispensingQty<%=inc1%>" value=""  size="6"  validate="AU,metachar,no" />
			</td>
			<%} %>
			<td>
			<input type="hidden" name="pvmsNo<%=inc%>" id="pvmsNo<%=inc%>" value="<%=pvmsNo%>" size="10" readonly="readonly" /><input type="text" name="dosage<%=inc%>" readonly="readonly"
			id="dosage<%=inc%>" value="<%=dosage%>" size="5" tabindex="1" /></td>
			
			<td><select name="frequency<%=inc1%>" id="frequency<%=inc1%>" class="medium"  
			tabindex="1">
			<option value="0">Select</option>
			<%
				for (MasFrequency masFrequency : frequencyList) {
									int id = masFrequency.getId();
									String name = masFrequency.getFrequencyName();
			%>

			<option value="<%=id%>" <%=HMSUtil.isSelected(id, frequencyId)%>><%=name%></option>
			<%
				}
			%>
		</select> <%
 	MasFrequency masFrequency = new MasFrequency();

 					for (int i = 0; i < frequencyList.size(); i++) {
 						masFrequency = (MasFrequency) frequencyList
 								.get(i);
 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <%
 	}
 %>
		</td>
		
		
		
        <%
        	if (patientPrescriptionDetails.getNoOfDays() != null) {
        %>
		<td><input type="text" name="noOfDays<%=inc1%>" size="3"
			tabindex="1" id="noOfDays<%=inc1%>" value="<%=noOfDays%>"
			readonly="readonly" /></td>
		<%
			} else {
		%>
		<td><input type="text" name="noOfDays<%=inc1%>" size="3"
			tabindex="1" id="noOfDays<%=inc1%>" value=""
			readonly="readonly" /></td>
		<%
			}
		%>
		<%if(route != null && !route.equals("")){ %>
		<td><input type="text" name="route<%=inc1%>" tabindex="1" id="route<%=inc1%>" value="<%=route %>"  size="5" maxlength="20"	 validate="Route,metachar,no" />
			<input type="hidden" name="total<%=inc1%>" tabindex="1" id="total<%=inc1%>" /></td>
			<%}else{ %>
			<td><input type="text" name="route<%=inc1%>" tabindex="1" id="route<%=inc1%>" value="PO"  size="5" maxlength="20"	 validate="Route,metachar,no" />
			<input type="hidden" name="total<%=inc1%>" tabindex="1" id="total<%=inc1%>" /></td>
			<%} %>
		<%-- <%
		 	if (patientPrescriptionDetails.getInstruction() != null) {
		 %>
		<td><select name="instructionACPC1" id="instructionACPC1" disabled="disabled"
			tabindex="1">
			<option value="<%=instruction%>"><%=instruction%></option>
		</select></td>
		<%
			} else {
		%>
		
		<td><select name="instructionACPC1" id="instructionACPC1" disabled="disabled"
			tabindex="1">
			<option value=""></option>
		</select></td>
		<%
			}
		%> --%>
		 		 <%
		 		 	if (patientPrescriptionDetails.getRemarks() != null) {
		 		 %>
		<td><input type="text" name="remarks<%=inc1%>" tabindex="1" id="remarks<%=inc1%>" size = "10"
			value=<%=remark%> class="small" readonly="readonly" /></td>
			<%
				} else {
			%>
			<td><input type="text" name="remarks<%=inc1%>" tabindex="1" id="remarks<%=inc1%>"  size = "10"
			value="" class="small" readonly="readonly" /></td>
			<%
				}
			%>
			<td><input type="checkbox" name="ct<%=inc1%>" class="radio" id="ct<%=inc1%>" value="y" />
		</td>
		<td><input type="text" name="closingStock<%=inc1%>" disabled="disabled" tabindex="1" value="" id="closingStock<%=inc1%>"  size="3"  validate="closingStock,metachar,no" /></td>
		
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid','hdb',this);" tabindex="1" />
			</td>
			
	</tr>
	<%
		inc1++;
					}
				}
	%>



</table>
	<input type="hidden" name="hdb" value="<%=inc1 - 1%>" id="hdb" />
<div class="Clear"></div>

</div>
</div>
<%
	} else {
			//System.out.println("this is else");
%>
<div class="clear paddingTop15"></div>

<h4><div class="floatRight">
<input	name="treatmentTemplate" type="button" value="Treatment Assist"	tabindex="1" onclick="showTreatment()" class="buttonBig" />
</div>Treatment</h4>

<div id="templateDivToShowHide" class="floatLeft">

<div id="testDiv">

	<div class="cmntable">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

	<tr>
		 <th>PVMS/NIV Nomenclature</th>
	    <th colspan="1">Other Drug</th>
	
			<th scope="col">Unit</th>
		<th scope="col">AU</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">Days</th>
		<th scope="col">Route</th>
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
		<td><input type="text" name="otherMedicine1" tabindex="1" id="otherMedicine1"  size="20" onblur="checkDuplicateOtherMedicine(this.value,'1');readOnlyNomenclature(this.value,'1');showSimilarMedicineNames(this.value);" validate="other Medicine,metachar,no" /></td>
		<td><select name="itemConversionId1" id="itemConversionId1" tabindex="1" class="medium"  >
			<option value="0">Select</option>
			<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
			<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
			<%} %>
		</select>
		<%
	    		MasStoreItemConversion  masStoreItemConversion = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion.getItemUnitName()%>";
            </script> <% }%>
		</td>
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,metachar,no" />
		<input type="hidden" name="actualDispensingQty1" tabindex="1" id="actualDispensingQty1" value=""  size="6"  validate="AU,metachar,no" /></td>
		

		<td><input type="hidden" name="pvmsNo1" tabindex="1" id="pvmsNo1"	size="10" readonly="readonly" />
	<input type="text" name="dosage1" tabindex="1" value="" id="dosage1"	size="5" maxlength="5" onblur="checkDosageValidation(this.value,'1')" /></td>
		<td><select name="frequency1" id="frequency1" tabindex="1" class="medium" onchange="getFrequencyValue(this.value,'1');fillValueFromFrequency(this.value,'1');displaySOSQty(this.value,'1')" >
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
            <input type="text" name="sosQty1" tabindex="1" id="sosQty1" style="display: none;"   size="3" onblur="fillValue(this.value,'1')"	maxlength="3" validate="Sos Qty,num,no" />
		</td>
		<td><input type="text" name="noOfDays1" tabindex="1" id="noOfDays1" onblur="fillValue(this.value,'1')"  size="3"	maxlength="3" validate="No of Days,num,no" />
		
			
		</td>
		<td><input type="text" name="route1" tabindex="1" id="route1" value="PO"  size="5" maxlength="20"	 validate="Route,metachar,no" />
			<input type="hidden" name="total1" tabindex="1" id="total1" />
		</td>
		
		
		<td><input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>
			</td>
			<td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td>
		<td><input type="text" name="closingStock1" tabindex="1" value="" id="closingStock1"  size="3"  validate="closingStock,metachar,no" /></td>
		
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid','hdb',this);" tabindex="1" />
			</td>
		
	</tr>
	

</table>
	<input type="hidden" name="hdb" value="1" id="hdb" />
<div class="clear"></div>
</div>
</div>
</div>
<%} %>

<div class="clear paddingTop15"></div>

<h4>Dental <a href="javascript:animatedcollapse.toggle('slide10')"></a></h4>
<div class="clear"></div>
<div id="slide10">

<div class="Block">
<div class="clear"></div>

<% if(opdDetailsForFollowup!=null){%> <input type="hidden"
	name="dentalValue" id="dentalValueId"
	value="<%=opdDetailsForFollowup.getDentalValue()%>" /> 
<% }else if(opdDetailsForFollowup!=null && opdDetailsForFollowup.getDentalValue()!=null){%>
 <input type="hidden"
	name="dentalValue" id="dentalValueId"
		value="<%=opdDetailsForFollowup.getDentalValue()%>" /> <% }else{%> <input
	type="hidden" name="dentalValue" id="dentalValueId" value="" /> <%} %> 
	


<input type="hidden"  name="MissTeeth" id="MissTeeth123" value=""/>
<input type="hidden"  name="UnserTeeth" id="UnserTeeth123" value=""/>
<label>Total No. of Teeth</label> 
<input tabindex="1" type="text" name="<%=TOTAL_NO_OF_TEETH %>" class="small" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getNoOfTeeth() != null ? opdDetailsForFollowup.getNoOfTeeth():"" %>"  onKeyUp="isNumber(this)" maxlength="2" /> 

<label class="medium3">Total No. of Defective Teeth</label> 
<input tabindex="1" type="text" name="<%=DEFECTIVE_TEETH %>" class="small" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getNoOfDefectiveTeeth() != null ? opdDetailsForFollowup.getNoOfDefectiveTeeth():"" %>"  onKeyUp="isNumber(this)" maxlength="2" /> 

<label class="medium3">Total No. of Dental Points</label> 
<input tabindex="1" type="text" name="<%=DENTSL_POINT %>" onKeyUp="isNumber(this);" maxlength="2"  value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getNoOfDentalPoints() != null ? opdDetailsForFollowup.getNoOfDentalPoints():"" %>" />

<div class="clear"></div>

<label>Missing </label>
 <input tabindex="1" type="text" name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);" maxlength="2" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getMissingTeeth() != null ? opdDetailsForFollowup.getMissingTeeth():"" %>" /> 

<label class="medium3">Unsaveable</label> 
 <input tabindex="1" type="text" name="<%=MISSING_UNSERVICABLE_TEETH %>" class="small" onKeyUp="isNumber(this);" maxlength="2" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getUnSaveableTeeth() != null ? opdDetailsForFollowup.getUnSaveableTeeth():"" %>" />
 
 
 <label class="medium3">Condition of Gums</label> 
<input	tabindex="1" type="text" name="<%=CONDITION_OF_GUMS %>" onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="100"  validate="Condition Of Gums,Alphabetic,Yes" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getConditionOfGums() != null ? opdDetailsForFollowup.getConditionOfGums():"Healthy" %>"  /> 

<div class="clear"></div>
<h4>Missing Teeth</h4>
<div class="clear"></div>
<label>UR</label>
 <input tabindex="1" type="checkbox" name="<%=MUR_8%>"
	value="" class="radioAuto" id="d1" onclick="chkValue(this);" /> <label
	class="smallAuto">8</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_7%>" value="" class="radioAuto" id="d2"
	onclick="chkValue(this);" /> <label class="smallAuto">7</label> <input
	tabindex="1" type="checkbox" name="<%=MUR_6%>" value=""
	class="radioAuto" id="d3" onclick="chkValue(this);" /> <label
	class="smallAuto">6</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_5%>" value="" class="radioAuto" id="d4"
	onclick="chkValue(this);" /> <label class="smallAuto">5</label> <input
	tabindex="1" type="checkbox" name="<%=MUR_4%>" value=""
	class="radioAuto" id="d5" onclick="chkValue(this);" /> <label
	class="smallAuto">4</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_3%>" value="" class="radioAuto" id="d6"
	onclick="chkValue(this);" /> <label class="smallAuto">3</label> <input
	tabindex="1" type="checkbox" name="<%=MUR_2%>" value=""
	class="radioAuto" id="d7" onclick="chkValue(this);" /> <label
	class="smallAuto">2</label> <input tabindex="1" type="checkbox"
	name="<%=MUR_1%>" value="" class="radioAuto" id="d8"
	onclick="chkValue(this);" /> <label class="smallAuto">1</label>

<div class="clear"></div>
<label>UL</label> <input tabindex="1" type="checkbox" name="<%=MUL_8%>"
	value="" class="radioAuto" id="d9" onclick="chkValue(this);" /> <label
	class="smallAuto">8</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_7%>" value="" class="radioAuto" id="d10"
	onclick="chkValue(this);" /> <label class="smallAuto">7</label> <input
	tabindex="1" type="checkbox" name="<%=MUL_6%>" value=""
	class="radioAuto" id="d11" onclick="chkValue(this);" /> <label
	class="smallAuto">6</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_5%>" value="" class="radioAuto" id="d12"
	onclick="chkValue(this);" /> <label class="smallAuto">5</label> <input
	tabindex="1" type="checkbox" name="<%=MUL_4%>" value=""
	class="radioAuto" id="d13" onclick="chkValue(this);" /> <label
	class="smallAuto">4</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_3%>" value="" class="radioAuto" id="d14"
	onclick="chkValue(this);" /> <label class="smallAuto">3</label> <input
	tabindex="1" type="checkbox" name="<%=MUL_2%>" value=""
	class="radioAuto" id="d15" onclick="chkValue(this);" /> <label
	class="smallAuto">2</label> <input tabindex="1" type="checkbox"
	name="<%=MUL_1%>" value="" class="radioAuto" id="d16"
	onclick="chkValue(this);" /> <label class="smallAuto">1</label>

<div class="clear"></div>
<label>LR</label> <input tabindex="1" type="checkbox" name="<%=MLR_8%>"
	value="" class="radioAuto" id="d17" onclick="chkValue(this);" /> <label
	class="smallAuto">8</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_7%>" value="" class="radioAuto" id="d18"
	onclick="chkValue(this);" /> <label class="smallAuto">7</label> <input
	tabindex="1" type="checkbox" name="<%=MLR_6%>" value=""
	class="radioAuto" id="d19" onclick="chkValue(this);" /> <label
	class="smallAuto">6</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_5%>" value="" class="radioAuto" id="d20"
	onclick="chkValue(this);" /> <label class="smallAuto">5</label> <input
	tabindex="1" type="checkbox" name="<%=MLR_4%>" value=""
	class="radioAuto" id="d21" onclick="chkValue(this);" /> <label
	class="smallAuto">4</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_3%>" value="" class="radioAuto" id="d22"
	onclick="chkValue(this);" /> <label class="smallAuto">3</label> <input
	tabindex="1" type="checkbox" name="<%=MLR_2%>" value=""
	class="radioAuto" id="d23" onclick="chkValue(this);" /> <label
	class="smallAuto">2</label> <input tabindex="1" type="checkbox"
	name="<%=MLR_1%>" value="" class="radioAuto" id="d24"
	onclick="chkValue(this);" /> <label class="smallAuto">1</label>

<div class="clear"></div>
<label class=>LL</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_8%>" value="" class="radioAuto" id="d25"
	onclick="chkValue(this);" /> <label class="smallAuto">8</label> <input
	tabindex="1" type="checkbox" name="<%=MLL_7%>" value=""
	class="radioAuto" id="d26" onclick="chkValue(this);" /> <label
	class="smallAuto">7</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_6%>" value="" class="radioAuto" id="d27"
	onclick="chkValue(this);" /> <label class="smallAuto">6</label> <input
	tabindex="1" type="checkbox" name="<%=MLL_5%>" value=""
	class="radioAuto" id="d28" onclick="chkValue(this);" /> <label
	class="smallAuto">5</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_4%>" value="" class="radioAuto" id="d29"
	onclick="chkValue(this);" /> <label class="smallAuto">4</label> <input
	tabindex="1" type="checkbox" name="<%=MLL_3%>" value=""
	class="radioAuto" id="d30" onclick="chkValue(this);" /> <label
	class="smallAuto">3</label> <input tabindex="1" type="checkbox"
	name="<%=MLL_2%>" value="" class="radioAuto" id="d31"
	onclick="chkValue(this);" /> <label class="smallAuto">2</label> <input
	tabindex="1" type="checkbox" name="<%=MLL_1%>" value=""
	class="radioAuto" id="d32" onclick="chkValue(this);" /> <label
	class="smallAuto">1</label>
<div class="clear"></div>

<h4>Unsaveable Teeth</h4>
<div class="clear"></div>
<label>UR</label> <input tabindex="1" type="checkbox" name="<%=UUR_8%>"
	value="" class="radioAuto" id="d33" onclick="chkValue(this);" /> <label
	class="smallAuto">8</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_7%>" value="" class="radioAuto" id="d34"
	onclick="chkValue(this);" /> <label class="smallAuto">7</label> <input
	tabindex="1" type="checkbox" name="<%=UUR_6%>" value=""
	class="radioAuto" id="d35" onclick="chkValue(this);" /> <label
	class="smallAuto">6</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_5%>" value="" class="radioAuto" id="d36"
	onclick="chkValue(this);" /> <label class="smallAuto">5</label> <input
	tabindex="1" type="checkbox" name="<%=UUR_4%>" value=""
	class="radioAuto" id="d37" onclick="chkValue(this);" /> <label
	class="smallAuto">4</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_3%>" value="" class="radioAuto" id="d38"
	onclick="chkValue(this);" /> <label class="smallAuto">3</label> <input
	tabindex="1" type="checkbox" name="<%=UUR_2%>" value=""
	class="radioAuto" id="d39" onclick="chkValue(this);" /> <label
	class="smallAuto">2</label> <input tabindex="1" type="checkbox"
	name="<%=UUR_1%>" value="" class="radioAuto" id="d40"
	onclick="chkValue(this);" /> <label class="smallAuto">1</label>
<div class="clear"></div>

<div class="clear"></div>
<label>UL</label> <input tabindex="1" type="checkbox" name="<%=UUL_8%>"
	value="" class="radioAuto" id="d41" onclick="chkValue(this);" /> <label
	class="smallAuto">8</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_7%>" value="" class="radioAuto" id="d42"
	onclick="chkValue(this);" /> <label class="smallAuto">7</label> <input
	tabindex="1" type="checkbox" name="<%=UUL_6%>" value=""
	class="radioAuto" id="d43" onclick="chkValue(this);" /> <label
	class="smallAuto">6</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_5%>" value="" class="radioAuto" id="d44"
	onclick="chkValue(this);" /> <label class="smallAuto">5</label> <input
	tabindex="1" type="checkbox" name="<%=UUL_4%>" value=""
	class="radioAuto" id="d45" onclick="chkValue(this);" /> <label
	class="smallAuto">4</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_3%>" value="" class="radioAuto" id="d46"
	onclick="chkValue(this);" /> <label class="smallAuto">3</label> <input
	tabindex="1" type="checkbox" name="<%=UUL_2%>" value=""
	class="radioAuto" id="d47" onclick="chkValue(this);" /> <label
	class="smallAuto">2</label> <input tabindex="1" type="checkbox"
	name="<%=UUL_1%>" value="" class="radioAuto" id="d48"
	onclick="chkValue(this);" /> <label class="smallAuto">1</label>

<div class="clear"></div>
<label>LR</label> <input tabindex="1" type="checkbox" name="<%=ULR_8%>"
	value="" class="radioAuto" id="d49" onclick="chkValue(this);" /> <label
	class="smallAuto">8</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_7%>" value="" class="radioAuto" id="d50"
	onclick="chkValue(this);" /> <label class="smallAuto">7</label> <input
	tabindex="1" type="checkbox" name="<%=ULR_6%>" value=""
	class="radioAuto" id="d51" onclick="chkValue(this);" /> <label
	class="smallAuto">6</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_5%>" value="" class="radioAuto" id="d52"
	onclick="chkValue(this);" /> <label class="smallAuto">5</label> <input
	tabindex="1" type="checkbox" name="<%=ULR_4%>" value=""
	class="radioAuto" id="d53" onclick="chkValue(this);" /> <label
	class="smallAuto">4</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_3%>" value="" class="radioAuto" id="d54"
	onclick="chkValue(this);" /> <label class="smallAuto">3</label> <input
	tabindex="1" type="checkbox" name="<%=ULR_2%>" value=""
	class="radioAuto" id="d55" onclick="chkValue(this);" /> <label
	class="smallAuto">2</label> <input tabindex="1" type="checkbox"
	name="<%=ULR_1%>" value="" class="radioAuto" id="d56"
	onclick="chkValue(this);" /> <label class="smallAuto">1</label>

<div class="clear"></div>
<label>LL</label> <input tabindex="1" type="checkbox" name="<%=ULL_8%>"
	value="" class="radioAuto" id="d57" onclick="chkValue(this);" /> <label
	class="smallAuto">8</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_7%>" value="" class="radioAuto" id="d58"
	onclick="chkValue(this);" /> <label class="smallAuto">7</label> <input
	tabindex="1" type="checkbox" name="<%=ULL_6%>" value=""
	class="radioAuto" id="d59" onclick="chkValue(this);" /> <label
	class="smallAuto">6</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_5%>" value="" class="radioAuto" id="d60"
	onclick="chkValue(this);" /> <label class="smallAuto">5</label> <input
	tabindex="1" type="checkbox" name="<%=ULL_4%>" value=""
	class="radioAuto" id="d61" onclick="chkValue(this);" /> <label
	class="smallAuto">4</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_3%>" value="" class="radioAuto" id="d62"
	onclick="chkValue(this);" /> <label class="smallAuto">3</label> <input
	tabindex="1" type="checkbox" name="<%=ULL_2%>" value=""
	class="radioAuto" id="d63" onclick="chkValue(this);" /> <label
	class="smallAuto">2</label> <input tabindex="1" type="checkbox"
	name="<%=ULL_1%>" value="" class="radioAuto" id="d64"
	onclick="chkValue(this);" /> <label class="smallAuto">1</label>
<div class="clear"></div>
<label> Remarks</label>
<%
if(opdDetailsForFollowup!=null && opdDetailsForFollowup.getMissingTeethRemark()!=null){%>
 <textarea rows="" cols="62" name="<%=DENTAL_REMARKS %>" class="auto" onkeyup="chkLength(this,250);" value="<%=opdDetailsForFollowup.getMissingTeethRemark() %>"><%=opdDetailsForFollowup.getMissingTeethRemark() %></textarea>
 <% }else{%>
 <textarea rows="" cols="60" name="<%=DENTAL_REMARKS %>" class="auto" onkeyup="chkLength(this,299);"
 onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" ></textarea>
 <% }%>
  <label class="auto"> Refer to MH</label>
<%	if(opdDetailsForFollowup!=null && opdDetailsForFollowup.getDentalReferToMH()!=null && opdDetailsForFollowup.getDentalReferToMH().equalsIgnoreCase("yes")){%>

	<input tabindex="1" type="checkbox" disabled="disabled"
	name="dentalReferToMH" value="no" checked="checked" class="radioAuto"   onclick="checkForDentalMH();"/>
	<input tabindex="1" type="hidden" name="dentalReferToMH" value="yes"  id="dentalReferToMH" />
	<%}else	{ %>
		<input tabindex="1" type="checkbox"
	name="dentalReferToMH" value="no" class="radioAuto"  id="dentalReferToMH"  onclick="checkForDentalMH();"/>
	<%} %>
	
	<div class="clear"></div>
	</div>
</div>


<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>

<div class="Block">

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid">

	<tr>
		<td><a
			href="javascript:openPopupProcedureAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)">
		Procedure Advice</a></td>
	<%--	<td><a
			href="javascript:openPopupDetentionAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)">
		Detention Advice</a></td> --%>
		<td><a
			href="javascript:openPopupPhysiotheraphyAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)">
		Physiotherapy Advice</a></td>
	</tr>
</table>
<div class="clear"></div>
<label>Any Systemic Disorder</label>
 <textarea rows="" cols="" name="systemicDisorder" maxlength="95" validate="Systemic Disorder,metachar,no" value=""  tabindex="1" onkeyup="return ismaxlength(this)" >
 <%=opdDetailsForFollowup != null && opdDetailsForFollowup.getSystemicDisorder() != null ? opdDetailsForFollowup.getSystemicDisorder():"" %>
 </textarea>

<label>Additional Advice</label> <textarea name="presentAdvice"
	cols="50" rows="0" maxlength="300" tabindex="1"
	onkeyup="return ismaxlength(this)" class="auto">
		<%=opdPatientHistory != null && opdPatientHistory.getPresentAdvice() != null ? opdPatientHistory.getPresentAdvice():"Review SOS" %>
	</textarea> 
	<div class="clear"></div>
	<label>Referred to MH</label>
<%	if(opdDetailsForFollowup!=null  && opdDetailsForFollowup.getMhRun()!=null && opdDetailsForFollowup.getMhRun().equalsIgnoreCase("y")){%>
	<input type="checkbox" name="referedToMH" checked="checked" class="radio" id="referedToMH" value="y" onclick="checkReferToMh();"/>
	<%}else{ %>
<input type="checkbox" name="referedToMH" class="radio" id="referedToMH" value="n" onclick="checkReferToMh();"/>
<%} %>
	


<div id="mhDiv" style="display: none">
<label>MH Name</label>

<input name="mh" type="text" tabindex="1" maxlength="32" id="mh" size="20" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getMh() != null ? opdDetailsForFollowup.getMh():"" %>" />

<label>Department</label>
<input name="mhDepartment" type="text" tabindex="1" maxlength="32" id="mhDepartment" size="20" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getMhDepartment() != null ? opdDetailsForFollowup.getMhDepartment():"" %>"  />

<label>Referred For</label>
<input name="mhReferredFor" type="text" tabindex="1" maxlength="50" id="mhReferredFor" size="20" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getMhReferredFor() != null ? opdDetailsForFollowup.getMhReferredFor():"" %>"  />
</div>
<div class="clear"></div>
<label>Disposal</label>
 <select name="disposal" size="0" tabindex="1" id="disposal">
	
	<option value="">Select</option>
			<%
			for(MasDisposal masDisposalType : disposalTypeList){
									int id = masDisposalType.getId();
									String name = masDisposalType.getDisposalName();
									if(opdDetailsForFollowup!=null){
			%>

			<option value="<%=name%>" <%=HMSUtil.isSelected(name, opdDetailsForFollowup.getDisposal())%>><%=name%></option>
			<%
									}else{
										%>
										
										<option value="<%=masDisposalType.getDisposalName() %>" ><%=masDisposalType.getDisposalName() %></option>
										<%}
									}
			%>
		</select> <%
		MasDisposal masDisposalType = new MasDisposal();

 					for (int i = 0; i < disposalTypeList.size(); i++) {
 						masDisposalType = (MasDisposal) disposalTypeList
 								.get(i);
 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masDisposalType.getDisposalName()%>";
	          icdArray[<%=i%>][1] = "<%=masDisposalType.getDisposalName()%>";
            </script> <%
 	}
 %>
		






<div id="daysDiv"><label>Days</label>


 <input name="days"	type="text" tabindex="1" maxlength="2" id="days" size="20" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getDays() != null ? opdDetailsForFollowup.getDays():"" %>" />
 
 </div>

</div>
<div class="clear paddingTop15"></div>





<div class="clear"></div>

<script>

function checkReferToMh (){
	 if(document.getElementById('referedToMH').checked == true){
		 document.getElementById('mhDiv').style.display = 'block'
			 document.getElementById('referedToMH').value='y';
	 }else{
		 document.getElementById('mhDiv').style.display = 'none'
			 document.getElementById('referedToMH').value='n';

	 }
 }
function validateDays(){
	//alert(document.getElementById('disposal').value);
 var msg = "";
 if(document.getElementById('disposal')){
 var disposal = document.getElementById('disposal').value;
 if(document.getElementById('disposal')){
	// alert(disposal)
 if(disposal == 'Light duties' || disposal =='Sick in Quarters' || disposal =='Sick Leave' || disposal =='Excused Duty'  )
 {
	 document.getElementById('daysDiv').style.display = 'block';
	 if(document.getElementById('days').value == "")
		msg += "Please select the days.\n";
		
	 }else{
	 document.getElementById('daysDiv').style.display = 'none';
 }
 }
}
 if(msg!=''){
		alert(msg);
		return false;
	}
return true;	
	
}



</script> <!-- <input type="text" name="nextVisitDate"  class="calDate"/>
		<a href="#"><img src="images/cal.gif" alt="Calender" border="0" /></a>
		 -->
<div class="clear"></div>

<input id="visitId" name="visitId" type="hidden"
	value="<%=visit.getId()%>" /> <input id="visitId1"
	name="<%=VISIT_ID %>" type="hidden" value="<%=visit.getId()%>" /> <input
	name="hinId" type="hidden" value="<%=visit.getHin().getId()%>" /> <input
	name="departmentId" type="hidden"
	value="<%=visit.getDepartment().getId()%>" /> <input name="hospitalId"
	type="hidden" value="<%=hospitalId%>" /> <%if(visit.getDoctor() != null){ %>
<input name="empId" type="hidden" value="<%=visit.getDoctor().getId()%>" />
<%}%> <input name="deptId" type="hidden" value="<%=deptId%>" /> <input
	name="<%=SERVICE_NO%>" type="hidden"
	value="<%=visit.getHin().getServiceNo()%>" /> <input
	name="<%=VISIT_NUMBER%>" type="hidden" value="<%=visit.getVisitNo()%>" />
<input name="<%=HIN_NO%>" type="hidden"
	value="<%=visit.getHin().getHinNo()%>" /> <input
	name="consultationDate" type="hidden" value="<%=consultationDate%>" />
<input name="consultationTime" type="hidden"
	value="<%=consultationTime%>" /> <input name="relation" type="hidden"
	value="<%=visit.getHin().getRelation().getRelationName()%>" /> <%
	String orderSeqNo="";
	if(mapForDS.get("orderSeqNo") != null){
		orderSeqNo = (String)mapForDS.get("orderSeqNo");
	}
%> <input name="<%=ORDER_NO %>" type="hidden" value="<%=orderSeqNo %>" />
<input name="physioRequisitionHeaderId" id="physioRequisitionHeaderId"
	type="hidden" value="0" /> <input name="procedureHeaderId"
	id="procedureHeaderId" type="hidden" value="0" />
<div class="clear"></div>
<div class="division"></div>
<input name="Submit" type="button" tabindex="1" align="right"
	class="button" value="Submit" onclick="submitOPDMainForm();" /> <input
	name="Reset" type="reset" tabindex="1" align="right" class="button"
	value="Reset" onclick="resetdata()" />
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
	function convertFarenhiteToCelcius(){
	   var strIn = document.getElementById('tempId').value;
		  if(isNaN(strIn) || strIn == '')
		  {
		    //alert("Not a Number");
		  }
		  else
		  {
		    var f = parseFloat(strIn);
		    var c = (f - 32) * 5/9;

		    var r = Math.round(c * 100)/100;
		    document.getElementById('tempInCelciusId').value = r.toString();   
		  }
		}
	function convertCelciusToFarenhite()
	{
        var strIn = document.getElementById('tempInCelciusId').value;
		  if(isNaN(strIn) || strIn == '')
		  {
		   // alert("Not a Number");
		  }
		  else
		  {
		    var c = parseFloat(strIn);
		    var f = (c * 9/5) + 32;
		
		    var r = Math.round(f * 100)/100;
		    document.getElementById('tempId').value = r.toString();   
		  }
		}


	
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
		var url="/hms/hms/opd?method=showtreatmentSearchJsp";
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
	
	 var cellRight2 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='otherMedicine'+iteration;
	  e11.id='otherMedicine'+iteration
	  e11.size='20';
	  e11.setAttribute('tabindex','1');
	  e11.onblur=function(){readOnlyNomenclature(this.value,iteration)};
	  cellRight2.appendChild(e11);

	  var cellRight3 = row.insertCell(2);
	  var e12 = document.createElement('input');
	  e12.type = 'text';
	  e12.name='au'+iteration;
	  e12.id='au'+iteration
	  e12.size='6';
	  e12.setAttribute('tabindex','1');
	  e12.onblur=function(){displayAU(this.value,iteration)};
	  cellRight3.appendChild(e12);

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

	  var cellRight4 = row.insertCell(3);
	  var e13 = document.createElement('input');
	  e13.type = 'text';
	  e13.name='dosage'+iteration;
	  e13.id='dosage'+iteration
	  e13.size='5';
	  e13.setAttribute('maxlength', 5); 
	  e13.setAttribute('tabindex','1');
	  cellRight4.appendChild(e13);
	  
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight4.appendChild(sel);
	
	 
	//  var cellRightSel = row.insertCell(2);
	 
	  var cellRight5 = row.insertCell(4);
	  var e2 = document.createElement('Select');

	  e2.name='frequency'+iteration;
	  e2.id='frequency'+iteration;
	  e2.classname='smalllabel';
	  e2.setAttribute('tabindex','1');
	  e2.options[0] = new Option('Select', '0');
	  e2.onclick=function(){
	  					var val=e4.value
	  					var freq=e2.value
	  						//alert("frequency-----"+freq)
	  					document.getElementById('total'+iteration).value=val*freq
	  		}

	   for(var i = 0;i<icdArray.length;i++ ){
	      e2.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	  cellRight5.appendChild(e2);
	  
	 
	  
	  var cellRight6 = row.insertCell(5);
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
	  							var freq=e2.value
	  							//alert("frequency-----"+freq)
	  							document.getElementById('total'+iteration).value=val*freq
	  						}
	  cellRight6.appendChild(e4);

	  var e5 = document.createElement('input');
	  e5.type = 'hidden';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	  cellRight6.appendChild(e5);

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


		var cellRight7 = row.insertCell(6);
		var e6 = document.createElement('input');
		e6.type = 'text';
		e6.name='route'+iteration;
		e6.id='route'+iteration
		e6.size='10';
		e6.value='PO'
		e6.setAttribute('maxlength', 20); 
		e6.setAttribute('tabindex','1');
		cellRight7.appendChild(e6);

	  var cellRight8 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='remarks'+iteration;
	  e7.id='remarks'+iteration
	  e7.size='10';
	  e7.setAttribute('maxlength', 40); 
	  e7.setAttribute('tabindex','1');
	  cellRight8.appendChild(e7);

	  var cellRight9 = row.insertCell(8);
	  var e71 = document.createElement('input');
	  e71.type = 'checkbox';
	  e71.name='ct'+iteration;
	  e71.id='ct'+iteration
	  e71.size='10';
	  e71.className='radio';
	  e71.value='y';
	  e71.setAttribute('tabindex','1');
	  cellRight9.appendChild(e71);

	  var cellRight10 = row.insertCell(9);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='remarks'+iteration;
	  e8.setAttribute('onClick', 'addRow();'); 
	  e8.setAttribute('tabindex','1');
	  cellRight10.appendChild(e8);

	  var cellRight11 = row.insertCell(10);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='remarks'+iteration;
	  e9.setAttribute('onClick', 'removeRow("grid","hdb",this);'); 
	  e9.setAttribute('tabindex','1');
	  cellRight11.appendChild(e9);

	 
	  
	   //added - fayaz
	//  var cellRight9 = row.insertCell(9);
   //   var e9 = document.createElement('input');
 //     e9.id = 'a'
 //     e9.type = 'checkbox';
  //    cellRight9.appendChild(e9);

	}

	<%-- function removeRow()
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
	} --%>

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

	function populateClinicalNotes(obj){
		var objValue = obj.value;
		if(obj.id == 'initialDiagnosis'){
			document.getElementById('clinicalNotes').value = objValue;
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
		   //  alert("pvms no--"+pvmsNo)
	  if(pvmsNo == "")
	  {
	   // alert("pvms no1111--"+pvmsNo)
	   	document.getElementById('nomenclature'+inc).value="";
	    document.getElementById('pvmsNo'+inc).value="";
	   return;
	   }
	   else
	      //document.getElementById('pvmsNo'+inc).value=pvmsNo
	      //alert(pvmsNo);
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
			       document.getElementById('au'+inc).value = au.childNodes[0].nodeValue;
		      	} 
		      }
		      }
		    var url="/hms/hms/opd?method=displayAU&pvmsNo="+pvmsNo;
		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);
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


	 function  fillValue(value,inc){

	// alert("noof days=="+value)
	  var freq=document.getElementById('frequency'+inc).value
	 // alert(freq)
	  document.getElementById('total'+inc).value=freq*value
	 }

	 function  fillValueFromFrequency(value,inc){

	 	//alert("frquency=="+value)
	  var noOfDays=document.getElementById('noOfDays'+inc).value
	 // alert(noOfDays)
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
	  e4.setAttribute('onClick','addRowForInvestigation();');
	  cellRight2.appendChild(e4);

	  var cellRight3 = row.insertCell(3);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.name='delete';
	  e5.setAttribute('onClick','removeRow("investigationGrid","hdb",this);');
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
</script> <script type="text/javascript">
		function openPopupForPatientPrescription(visitNo,hinId,deptId,visitId){
		  //alert("in pop up window visit No---"+visitNo+"---- hin id ---"+hinId)


		if(visitNo >1){
		var url="/hms/hms/opd?method=showPatientPreviousPrescription&visitNo="+visitNo+"&hinId="+hinId+"&deptId="+deptId+"&visitId="+visitId;
        newwindow=window.open(url,'name',"height=300,top=0,width=1010,status=1");
        }else{
          alert("This Is Patient's first Visit.")
        }
     }

     function submitDetails(){

		
        document.opdMain.action="hms/hms/opd?method=submitOPDPatientDetails";
        document.opdMain.submit();
        document.opdMain.action="opd?method=showEntJsp&visitId=<%=visit.getId() %>"
        document.opdMain.submit();
		

     }

     function showHideInvestigationTemplateCombo(){
    		var invId="";
    		var sel = document.getElementById("investigationTemplateId");
    		var listLength = sel.options.length;
    		//alert("listLength--->"+listLength);
    		
    		for(var i=0;i<listLength;i++){
    		   if(sel.options[i].selected){
    				if(invId!=""){
    					invId=invId+","+sel.options[i].value;
    					}else{
    						invId=sel.options[i].value;
    				}
    				
    		   }
    		}
    			//alert("invId==="+invId);
    		//if(checkTemplateId(valueOfTemplate)){
    		  	document.getElementById("copyPrevInvestigationTemplateDiv").style.display='none';//'+invId
    	submitProtoAjaxWithDivName('pnc','/hms/hms/opd?method=showGridForInvestigation&investigationTemplateId='+invId,'gridview');
    				
    				}
    	     

     function openPopupForPatientInvestigation(visitNo,hinId){
		  //alert("in pop up window visit No---"+visitNo+"---- hin id ---"+hinId)


		if(visitNo >1){
		var url="/hms/hms/opd?method=showPatientPreviousInvestigation&visitNo="+visitNo+"&hinId="+hinId;
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
		submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=responseForDoctarsList&referredDepartmentId='+indexes+'','referredDoctarsIdDiv');
		//submitProtoAjaxforOpdMain('opdMain','/hms/hms/opd?method=responseForDoctarsList&referredDepartmentId='+indexes+'');
	}


  function showCreatePrescriptionTempate(){
        
  		document.getElementById('prescriptionImportButton').style.display = 'inline';
	   	var url="/hms/hms/opd?method=showCreatePrescriptionTempate";
	    newwindow=window.open(url,'presciption',"height=500,width=1010,status=1,top=0,left=2");
	   
	     }

  function copyPrevPrescriptionTempate(visitNo,hinId){
   		document.getElementById('templateDivToShowHide').style.display = 'none';
   		document.getElementById('prevButtonDivToShowHide').style.display = 'none';
   		document.getElementById('createPresDivToShowHide').style.display = 'none';

		var hdb = document.getElementById('hdb').value;
	    submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getPatientPreviousPrescriptionForCopy&&visitNo='+visitNo+'&hinId='+hinId,'testDiv');
  }

  function copyPrevInvestigationTempate(visitNo,hinId){
   		document.getElementById('templateDivInvestigationToShowHide').style.display = 'none';
   		document.getElementById('prevButtonDivInvestigationToShowHide').style.display = 'none';
   		document.getElementById('createInvestigationDivToShowHide').style.display = 'none';

		var hdb = document.getElementById('hdb').value;
	    submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
  }

  function showCreateInvestigationTemplate(){
     
	     document.getElementById("investigationImportButton1").style.display='inline'
	   	var url="/hms/hms/opd?method=showCreateInvestigationTemplate";
	    newwindow=window.open(url,'investigation',"height=500,width=1010,status=1,top=0,left=2");
	   

  }


 function getListForTreatment(val){
 	if(val=='investigationDiv'){
		submitProtoAjaxWithDivName('pnc','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
	}else if(val=='treatmentDiv'){
		submitProtoAjaxWithDivName('pnc','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
	}
//	document.getElementById('prescriptionImportButton').style.display = 'none';
//	document.getElementById("investigationImportButton").style.display='none'
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

			submitProtoAjax('pnc','/hms/hms/opd?method=showGridInMainJsp','testDiv');
		}
	}
	
	function validateFrequency(){
		
		var count = document.getElementById('hdb').value;
		for(var i = 1; i <= count;i++){
			//var nomenclature = document.getElementById('nomenclature'+i).value;
			if(document.getElementById('nomenclature'+i)){
			if(document.getElementById('nomenclature'+i).value != ''){
				if(document.getElementById('frequency'+i)){
				if(document.getElementById('frequency'+i).value == '0'){
					alert('Please select frequency.');
					return false;
				  }
				 }
				
				//var dosage = document.getElementById('dosage'+i).value;
				if(document.getElementById('dosage'+i)){
				if(document.getElementById('dosage'+i).value == ''){
					alert('Please Enter dosage.');
					return false;
				 }
				}
				
				//var noOfDays = document.getElementById('noOfDays'+i).value;
				if(document.getElementById('noOfDays'+i)){
				if(document.getElementById('noOfDays'+i).value == ''){
					alert('Please Enter noOfDays.');
					return false;
				 }
				}
				if(document.getElementById('noOfDays'+i)){
				if(document.getElementById('noOfDays'+i).value!="")
				{
				if( isNaN(document.getElementById('noOfDays'+i).value))
		    	{
		        	alert("No. of Days Should be number");
		        	return false;
		    	 }
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
			}
			/*else
			{
				alert("Please Enter Nomenclature");
				return false;
			}*/
			
		 }
		}
		return true;
	}

	function submitOPDMainForm(){
	//	if(validateFieldValuesForMainSubmit()){
			if(validateFrequency() && validateDays()){
				submitForm('pnc','fwc?method=submitPncDetails&flag=pnc');
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
    	
    		   	var url="/hms/hms/opd?method=showTreatmentPopUp";
    		    newwindow=window.open(url,'treatment',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
    		  
    }
   
    function showSymptom()
    {
    		 	var url="/hms/hms/opd?method=showSymptomPopUp";
    		    newwindow=window.open(url,'Symptom',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
    		  
    }
    function showDiagnosis()
    {
    		   	var url="/hms/hms/opd?method=showDiagnosisPopUp";
    		   newwindow=window.open(url,'Diagnosis',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
    		  
    }
  
    function resetdata()
    {
       
        document.opdMain.action="/hms/hms/opd?method=showOPDMainJsp&visitId=<%=visit.getId() %>&token=<%=visit.getTokenNo()%>";
        document.opdMain.submit();
       
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
    	 var url="/hms/hms/opd?method=showProcedureListJsp&visitId="+visitId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=opd";
    	 newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
    	}
        function openPopupDetentionAdviceWindow(visitId,hinId,doctorId)
    	{
    	 var url="/hms/hms/opd?method=showDetentionListJsp&visitId="+visitId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=opd";
    	 newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
       	 //alert("Detention Advice ....");
    	}
        function openPopupPhysiotheraphyAdviceWindow(visitId,hinId,doctorId)
    	{
    	 var url="/hms/hms/opd?method=showPhysiotherapyListJsp&visitId="+visitId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=opd";
    	 newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
       	 //alert("Physiotheraphy Advice ....");
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
    	//opd?method=showPatientPreviousVisitForInvestigationReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>"
    	 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
       	 //alert("Detention Advice ....");
    	}
        function openOtherField(familyHistoryId){
        	if(familyHistoryId == '8'){
        		document.getElementById('otherFamilyHistoryDiv').style.display = 'block';
        	}else{
        	//	document.getElementById('familyHistoryId').style.display = 'none';
        	}
        	
        }

        function chkValue(field)
        {
        	if(!field.checked)
        	{

        	field.value="N";
        	}
        	else{

        	field.value="Y";

        	}

        }
        function chkValue(Obj)
    	{
    		var newdentalValue="";
    		var duplicate = new Boolean(false)
    		var dstr=document.getElementById('dentalValueId').value;
    	<%
    	if(opdDentalDetailsList.size() == 0){
    	%>
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
    	<%}else{%>
    		alert("You are trying to change the value.");
    		if(Obj.checked){
    			document.getElementById(Obj.id).checked = false;
    		}else{
    			document.getElementById(Obj.id).checked = true;
    		}
    	<%}%>
    	}
     function coolDental()
    	{
    	 var dentalValue=document.getElementById('dentalValueId').value;
    	 var mySplitResult = dentalValue.split(",");
    	 for(i=1;i<mySplitResult.length;i++)
    	 {
    		 document.getElementById(mySplitResult[i]).checked="checked";
    		 messingTeeth(mySplitResult[i]);
    	 }
    	}

       

        function messingTeeth(mm)
        {

        	var name=document.getElementById(mm).name;

        	var mval=document.getElementById('MissTeeth123').value;
        	var uval=document.getElementById('UnserTeeth123').value;
        	if(name[0]=='m')
        	{
        		mval=mval+" "+name.substring(1,name.length).toUpperCase();
        		document.getElementById('MissTeeth123').value=mval;
        	}
        	if(name[0]=='u')
        	{
        		uval=uval+" "+name.substring(1,name.length).toUpperCase();
        		document.getElementById('UnserTeeth123').value=uval;
        	}
        }
        function checkForDentalMH()
        {
           if(document.getElementById('dentalReferToMH').checked==true)
           {
           	document.getElementById('dentalReferToMH').value='yes';
           } else
           {
           	document.getElementById('dentalReferToMH').value='no';
           }              
        }

function openWindow(url){

	 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
    
	
}
</script>
</form>
</body>



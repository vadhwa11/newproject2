<%@page import="jkt.hms.masters.business.ObgDetails"%>
<%@page import="jkt.hms.masters.business.TherapyDetails"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryDetail"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.masters.business.OtBooking"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.MasImpanneledHospital"%>
<%@page import="jkt.hms.masters.business.InjAppointmentDetails"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<!--<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

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
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%><script type="text/javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<!-- <script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script> -->

<script>jQuery.noConflict();</script>

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
	List patientDataList = new ArrayList();
	List<OpdPatientDetails> opdDetailListForFollowUp = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> opdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
	List<DgOrderhd>patientInvestigationHeaderListForFollowUp = new ArrayList<DgOrderhd>();
	Set<DgOrderdt> patientInvestigationdetails = null;
	List<PatientPrescriptionHeader> patientPrescriptionHeaderList = new ArrayList<PatientPrescriptionHeader>();
	List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
	List<InjAppointmentDetails>injAppDetails= new ArrayList<InjAppointmentDetails>();
	List<OpdSurgeryDetail>OpdSurgeryDetailList= new ArrayList<OpdSurgeryDetail>();
	List<OtBooking> otbooking = null;
	
 	List<MasImpanneledHospital> masImpanneledHospitalList = new ArrayList<MasImpanneledHospital>();
	  	if(map.get("masImpanneledHospitalList") != null)
		{
	  		masImpanneledHospitalList=(List<MasImpanneledHospital>)map.get("masImpanneledHospitalList");
		}
	  	
	  	
	List<MasDepartment> wardDepartmentList = new   ArrayList<MasDepartment>();
	if(map.get("wardDepartment") != null)
	{
		wardDepartmentList=(List<MasDepartment>)map.get("wardDepartment");
	}
	
	//ended
  	OpdPatientDetails opdPatientDetails = null;
  	OpdPatientDetails opdReferralPatientDetails = null;
	
  	
		String lastEncounterDetail = "";
		
		Integer opdpatientDetailId=0;
		int pHeaderId=0;
		int dgOrderHdId=0;
		int referralDept=0;
		int referralHospital=0;
		int referralDistrict=0;
		String referralType="NA";
		String deptNameforExternal="NA";
	 	if(map.get("opdPatientDetails") != null)
		{
			
			opdPatientDetails=(OpdPatientDetails)map.get("opdPatientDetails");
			opdpatientDetailId=opdPatientDetails.getId();
		//	referralDept = opdPatientDetails.getReferredDept()!=null?opdPatientDetails.getReferredDept().getId():0;
			//referralHospital = opdPatientDetails.getHospital().getId();
			//referralDistrict = opdPatientDetails.getReferedDistrict() != null? opdPatientDetails.getReferedDistrict().getId():0;
			//referralType = opdPatientDetails.getReferredType() != null?opdPatientDetails.getReferredType():"NA";
			//deptNameforExternal = opdPatientDetails.getReferredDept() !=null?opdPatientDetails.getReferredDept().getDepartmentName():"NA";
		} 
		
		if(map.get("opdReferralPatientDetails") != null)
		{
			
			opdReferralPatientDetails=(OpdPatientDetails)map.get("opdReferralPatientDetails");
			//opdpatientDetailId=opdReferralPatientDetails.getId();
		//	referralDept = opdPatientDetails.getReferredDept()!=null?opdPatientDetails.getReferredDept().getId():0;
			referralHospital = opdReferralPatientDetails.getHospital().getId();
			//referralDistrict = opdPatientDetails.getReferedDistrict() != null? opdPatientDetails.getReferedDistrict().getId():0;
			//referralType = opdPatientDetails.getReferredType() != null?opdPatientDetails.getReferredType():"NA";
			//deptNameforExternal = opdPatientDetails.getReferredDept() !=null?opdPatientDetails.getReferredDept().getDepartmentName():"NA";
		}
	
  List<ProcedureDetails>procedureDetails= new ArrayList<ProcedureDetails>();
	if(map.get("procedureDetails") != null)
		{
			procedureDetails=(List<ProcedureDetails>)map.get("procedureDetails");
		}	
	
	if(map.get("opdDetailListForFollowUp") != null){
		opdDetailListForFollowUp=(List)map.get("opdDetailListForFollowUp");
	}
	if(map.get("dischargeIcdCodeList") != null){
		dischargeIcdCodeList=(List)map.get("dischargeIcdCodeList");
	}
	String presentComplaintHistory="";
	String familyPresentHistory="";
	String additionalAdvice="";
	String otherInvestigation ="";
	if(map.get("opdHistoryDetailsListForFollowUp") != null){
		opdHistoryDetailsListForFollowUp=(List<OpdPatientHistory>)map.get("opdHistoryDetailsListForFollowUp");
		
		if(opdHistoryDetailsListForFollowUp.size()>0){
  		presentComplaintHistory = opdHistoryDetailsListForFollowUp.get(0).getPresentComplain()!=null?opdHistoryDetailsListForFollowUp.get(0).getPresentComplain().replace(",", "\n"):"";
  		familyPresentHistory = opdHistoryDetailsListForFollowUp.get(0).getFamilyPresentHistory()!=null?opdHistoryDetailsListForFollowUp.get(0).getFamilyPresentHistory().replace(",", "\n"):"";
  		additionalAdvice = opdHistoryDetailsListForFollowUp.get(0).getPresentAdvice()!=null?opdHistoryDetailsListForFollowUp.get(0).getPresentAdvice().replace(",", "\n"):"";
  		/* personalPresentHistory=preOpdPatientHistory.getPersonalPresentHistory()!=null?preOpdPatientHistory.getPersonalPresentHistory().replace(",", "\n"):"";
  		familyPastHistory=preOpdPatientHistory.getFamilyPastHistory()!=null?preOpdPatientHistory.getFamilyPastHistory().replace(",", "\n"):"";
  		madicationHistory=preOpdPatientHistory.getMadicationHistory()!=null?preOpdPatientHistory.getMadicationHistory().replace(",", "\n"):"";
  		opdPatientHistoriesStr=preOpdPatientHistory.getPastIllnessHistory()!=null?preOpdPatientHistory.getPastIllnessHistory().replace(",", "\n"):""; */
		}
	}
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
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
	
	OpdPatientHistory opdPatientHistory = null;
	if(opdHistoryDetailsListForFollowUp.size()>0){
		opdPatientHistory = opdHistoryDetailsListForFollowUp.get(0);
	}
	
	DgOrderhd patientInvestigationHeader = null;
	if(patientInvestigationHeaderListForFollowUp.size()>0){
		patientInvestigationHeader = patientInvestigationHeaderListForFollowUp.get(0);
		otherInvestigation = patientInvestigationHeader.getOtherInvestigation()!=null?patientInvestigationHeader.getOtherInvestigation() :"";
		dgOrderHdId = patientInvestigationHeader.getId();
		patientInvestigationdetails = patientInvestigationHeader.getDgOrderdts();
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
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
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
	int deptId=visit.getDepartment().getId();
	String departmentName=visit.getDepartment().getDepartmentName();
	String departmentCode=visit.getDepartment().getDepartmentCode();
	

	List<Patient> patientList = new ArrayList<Patient>();   
	String patientTypeNameForHAL = null;
	String patientTypeNameForOther = null;

	
    String referral_other_patient ="y";
	
	Set<MasMedicalExamFamilyHis> familyHisSet = new HashSet<MasMedicalExamFamilyHis>();
	if(visit.getHin().getMasMedicalExamFamilyHis() !=null){
		familyHisSet  = visit.getHin().getMasMedicalExamFamilyHis() ;
		
	
	}
	
	int hinId = visit.getHin().getId();
	
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	
	InputStream in = resourcePath.openStream();
	Properties prop = new Properties();
	prop.load(in);
	String familyHistoryCode = null;
	String complaintHistoryCode = null;
    String empTypeCodeForContract = null;

    try
    {
 	   prop.load(resourcePath.openStream());
 	  familyHistoryCode = prop.getProperty("templateCodeForFamilyHistory");
 	  complaintHistoryCode = prop.getProperty("templateCodeForComplaintHistory");
 	 patientTypeNameForHAL = prop.getProperty("patientTypeNameForHAL");
	 patientTypeNameForOther = prop.getProperty("patientTypeNameForOther");
	 empTypeCodeForContract = prop.getProperty("empTypeCodeForContract");
 	     
    }
    catch (Exception e)
    {
            e.printStackTrace();
    }
    
    		if(visit.getHin().getPatientType().getId()!=null)
    		{
    			if(visit.getHin().getPatientType().getId()==2)
    			{
    				
    			}
    		}
    		
    		
    		if(visit.getHin().getPatientType().getPatientTypeName()!=null)
			{
			
				 if(visit.getHin().getPatientType().getPatientTypeName().equals(patientTypeNameForOther))
				{
					if(visit.getHin().getBillable().equals("y"))
						referral_other_patient ="n";
					else if(visit.getHin().getBillable().equals("n"))
						referral_other_patient ="y";
				}
			}
    		
    		List<OpdPatientDetails> admittedVisit = new ArrayList<OpdPatientDetails>();
    		
    if(map.get("admittedVisit") != null){
    	admittedVisit = (List<OpdPatientDetails>) map.get("admittedVisit");
    	
    			}
    
	List <OpdPatientDetails> opdPatientDetailsList =new ArrayList<OpdPatientDetails>();
    if(map.get("opdPatientDetailsList") != null){
    	opdPatientDetailsList = (List<OpdPatientDetails>) map.get("opdPatientDetailsList");
    			}
    
    if(map.get("injAppDetails") != null){
    	injAppDetails = (List<InjAppointmentDetails>) map.get("injAppDetails");
    			}
    
    if(map.get("OpdSurgeryDetailList") != null){
    	OpdSurgeryDetailList = (List<OpdSurgeryDetail>) map.get("OpdSurgeryDetailList");
    			}
    
    if(map.get("otbooking") != null){
    	otbooking = (List<OtBooking>) map.get("otbooking");
    			}
	List <MasItemClass> masItemClassList =new ArrayList<MasItemClass>();
    if(map.get("masItemClassList") != null){
    	masItemClassList = (List<MasItemClass>) map.get("masItemClassList");
    			}
  
	List<MasEmployeeDependent> med = null;
	if(map.get("med") != null){
		med = (List<MasEmployeeDependent>) map.get("med");
    			}
	List<OpdPatientDetails> eyeDetails = null;
	if (map.get("opdPDetailsListForEyeDeptFollowUp") != null) {
		eyeDetails = (List<OpdPatientDetails>) map.get("opdPDetailsListForEyeDeptFollowUp");
	}
	List<TherapyDetails> therapyList = null;
	if(map.get("therapyList") != null){
		therapyList = (List<TherapyDetails>) map.get("therapyList");
    			}
	
	ObgDetails obgDetails = null;
	List<ObgDetails> obgDetailsList = null;
	if(map.get("obgDetailsList") != null){
		obgDetailsList = (List<ObgDetails>) map.get("obgDetailsList");
    			}

	
	
	%>
<!--main content placeholder starts here-->
<form name="opdMain" action="" method="post">
<%-- <input type="hidden" id="referralotherpatient" value="<%=referral_other_patient %>" /> --%>
<input type="hidden" name="userName" value="<%=userName %>" /> <%if(visit.getDepartment()!= null){ %>
<div class="titleBg"><h2>OPD- Main</h2></div>
<div class="clear"></div>
<%} %>
 <script type="text/javascript">
	   var icdArray=new Array();
	   var unitArray = new Array();
	   var itemClassArray = new Array();
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
if(visit.getHin().getRelation()!=null&&visit.getHin().getRelation().getNewRelationName().equalsIgnoreCase("Self"))
{ 
%><div class="photoDivLeft">
<label>Employee No.</label>
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
	class="value" style="min-width:147px; width:auto;"><%=patient.getSFirstName()+" "+sMiddleName+" "+sLastName %></label> <%}}else{ %> <label class="value"></label>
<%} %>
<label>Relation</label>
 <%if(visit.getHin().getRelation()!= null){ %>
<label class="value"><%=visit.getHin().getRelation().getNewRelationName() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>

<div class="clear"></div>
<label>Designation</label>
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

<%-- <label>Trade/Branch</label>
 <%if(visit.getHin().getTrade() != null){ %>
<label class="value"><%=visit.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %> --%>
<%--  <label>Unit</label>
 <%if(visit.getHin().getUnit() != null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
<input type="hidden" name="unitId" value="<%=visit.getHin().getUnit().getId() %>"/>
<%}else{ %> <label class="value">&nbsp;</label><%} %> --%>

<label >Age</label> 
<%if(visit.getHin().getAge()!= null){ %>
<label class="value"><%=visit.getHin().getAge() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
<%if(visit.getHin().getAge()!= null){ %>
<input type="hidden" name="ageId" id="ageId" value="<%=visit.getHin().getAge() %>">
<%} %>
 <label>Gender</label>
 <%if(visit.getHin().getSex() != null){ %>
<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
<input type="hidden" name="genderId" id="genderId" value="<%=visit.getHin().getSex().getId() %>">
<%}else{ %> <label class="value">&nbsp;</label><%} %>


<%-- <%if(visit.getHin().getRelation().getId() != 8){ %>
<label >Occupation</label> 
<%if(visit.getHin().getOccupation()!= null){ %>
<label class="value"><%=visit.getHin().getOccupation().getOccupationName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%}} %> --%>
<label >Marital Status</label> 
<%if(visit.getHin().getSrMaritalStatus()!= null){ %>
<label class="value"><%=visit.getHin().getSrMaritalStatus().getMaritalStatusName() %></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %> 

<label >Blood Group</label>
<%
if(visit.getHin().getBloodGroup() != null ){ %>
<label class="value"><%=visit.getHin().getBloodGroup().getBloodGroupName() %></label>
<%}else{ %>
<label class="value">&nbsp;</label> <%} %>
<div class="clear"></div>
<%-- <label >Medical Category</label>
<%if(visit.getHin().getCategory() != null){ %>
<label class="value"><%=visit.getHin().getCategory().getCategories() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %> --%>
<%-- <label>Date</label>
<%if(meddata.getDateOfReporting() != null){ %>
<label class="value"><%=meddata.getDateOfReporting() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %> --%>
<%--  
<label >Disability</label>
<%if(meddata.getPresentDisability()!= null){ %>
<label class="value"><%=meddata.getPresentDisability().getDisability() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %> --%>

<!-- <label >Medication</label> -->
<%--if(meddata.getInstructionByPresident() != null){ --%>
<!-- <label class="value">meddata.getInstructionByPresident()</label> -->
<%--}else{ --%>
<%-- <label class="value">&nbsp;</label> }--%>

<%-- <label >Allergies</label> --%>
<%--if(visit.getHin() != null){ --%>
<%-- <label class="value">&nbsp;</label> --%>
<%--}else{ --%>
 <%--  <label class="value">&nbsp;</label>  --%>

 <%--} --%>
 <label>Allergy</label>
<%if(visit.getHin().getDrugAllergies() != null){ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="<%=visit.getHin().getDrugAllergies() %>" maxlength="77" id="allergies" size="77"  />
<%}else{ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="" maxlength="100" id="allergies" size="77"  />
<%} %>
	
 <label>Current Year's Visit</label> 
<label class="value"><%=visitCount%></label> 
</div>
	<div class="photoImageDiv">
		
		<% 
		System.out.println(visit.getHin().getPatientType().getPatientTypeCode() +" xf");
		  if(visit.getHin().getPatientType()!=null && visit.getHin().getPatientType().getPatientTypeName().equalsIgnoreCase(patientTypeNameForHAL))
		  {
		%>	
		  <img
				src="/hms/hms/personnel?method=displayImage&amp;employeeId=<%=visit.getHin().getEmployee().getId()%>"
				width="105" height="112">  
		 <% }
		  else
		  {
	%>		   
	 <img
				src="/hms/jsp/images/photo_icon.png"
				width="105" height="112">  
	<%	  }
		%>
			
		</div>
<%--  <input class="transparent" size="125" >--%>

<%--
<%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visitCount%></label> 
<%}else{ %> 
<label class="value">&nbsp;</label><%} %>
 --%>
 <% }else{ %>
 <div class="photoDivLeft">
<label>Employee No.</label>
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
	style="min-width:147px; width:auto;"class="value"><%=patientName %></label> 
<%} %>
<label>Relation</label>
 <%if(visit.getHin().getRelation()!= null){ %>
<label class="value"><%=visit.getHin().getRelation().getNewRelationName() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>

<div class="clear"></div>
<label >Designation</label>
<%if(visit.getHin().getRank()!= null){ %>
<label class="value"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="value"></label> <%} %>

<label>Name</label>
<label class="value"><%=servicePersionName %></label>

<%-- <label>Trade/Branch</label>
 <%if(visit.getHin().getTrade() != null){ %>
<label class="value"><%=visit.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %> --%>
 


<%--  <label>Unit</label>
 <%if(visit.getHin().getUnit() != null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
 --%>
<label >Age</label> 
<%if(visit.getHin().getAge()!= null){ %>
<label class="value"><%=visit.getHin().getAge()%></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>


 <label>Gender</label>
 <%if(visit.getHin().getSex() != null){ %>
<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
<input type="hidden" name="genderId" id="genderId" value="<%=visit.getHin().getSex().getId() %>">
<%}else{ %> <label class="value">&nbsp;</label><%} %>
 
<%-- <label >Occupation</label> 
<%if(visit.getHin().getOccupation()!= null){ %>
<label class="value"><%=visit.getHin().getOccupation().getOccupationName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %> --%>
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
<%-- <label >Allergies</label> --%>
<%--if(visit.getHin() != null){ --%>
<%-- <label class="value">&nbsp;</label> --%>
<%--}else{ --%>
 <%--<label class="value">&nbsp;</label> --%>
 <%--} --%>
<label>Allergy</label>
<%if(visit.getHin().getDrugAllergies() != null){ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="<%=visit.getHin().getDrugAllergies() %>" maxlength="91" id="allergies" size="77"  />
<%}else{ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="" maxlength="100" id="allergies" size="77"  />
<%} %>
<label >Current Year's Visit</label> 
<label class="value"><%=visitCount%></label> 

</div>
	<%if(med!=null){
for(MasEmployeeDependent dependent :med)
{
	  if(dependent.getRelation().getId() == visit.getHin().getRelation().getId())
	  {
	%>	
	<div class="photoImageDiv"><img src="/hms/hms/personnel?method=displayImageEmployeeDependent&amp;employeeDependentId=<%=dependent.getId()%>" width="105" height="112"></div>  
	  <%break; }
}
	}
%>  

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

	<%-- <li><a href="appointment?method=showAppointmentPatientJsp">Appointments</a></li>
	<li><a href="appointment?method=showAppointmentJsp">Investigation
	Appt.</a></li>
	<li><a href="opd?method=showPatientHistoryJsp&visitId=<%=visit.getId() %>">Patient History</a></li> --%>
	<li><a href="#" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&hinNo=<%=visit.getHin().getHinNo()%>&backFlag=OPD')">
	Previous Visits </a>
	<!--<a href="#" onclick="submitFormForButton('opdMain','opd?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&backFlag=OPD')">
	Previous Visits </a>-->
	</li>
	
	<%--<li><a href="opd?method=showPatientPreviousVisitForMedicalExamp&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo() %>">
	Previous Medical Exam </a></li>
	--%>
<%-- 	<li>
	<a href="#" onclick="openWindow('/hms/hms/medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>&visitId=<%=visit.getId()%>&token=<%=visit.getTokenNo()%>&hinNo=<%=visit.getHin().getHinNo()%>&hinId=<%= visit.getHin().getId()%>&backFlag=OPD')">
	Previous Medical Exams </a>
	<!--<a href="#" onclick="submitFormForButton('opdMain','medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>&visitId=<%=visit.getId()%>&token=<%=visit.getTokenNo()%>&backFlag=OPD')">
	Previous Medical Exams </a>-->
	</li> --%>
	
	<%-- <li>
	<a href="#" onclick="openWindow('/hms/hms/medicalExam?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo()%>&token=<%=visit.getTokenNo()%>&backFlag=OPD')">
	Previous Medical Boards</a>
	<!--<a href="#" onclick="submitFormForButton('opdMain','medicalExam?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo()%>&token=<%=visit.getTokenNo()%>&backFlag=OPD')">
	Previous Medical Boards</a>-->
	</li> --%>
	<li>
	<a href="#" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&hinNo=<%=visit.getHin().getHinNo()%>&backFlag=OPD')">
    Previous Hospitalizations</a>
	<!--<a href="#" onclick="submitFormForButton('opdMain','opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&backFlag=OPD')">
    Previous Hospitalizations</a>--></li>
	
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
<%-- 	<li>
	Code for Open In popup mode
	Code By Mukesh 04 Oct 2011
	
	 
	<a href="opd?method=showPatientPreviousVisitForPrescriptionReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>">
	Previous Prescriptions</a>
	 //opd?method=showPatientPreviousVisitForPrescriptionReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>
	 <li><a
		href="opd?method=showPatientPreviousVisitForInvestigationReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>">Previous
	Investigations</a></li>
	
	 <a href="#" onclick="javascript:openPopupPrescriptions(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getDepartment().getId()%>,<%=visit.getHin().getId()%>)">
	Previous Prescriptions</a>
	</li> --%>
<%-- 	<li>
	 <a href="#"
				onclick="javascript:openPopupInvestigation(<%=visit.getHin().getId()%>)">
					Previous Investigations</a></li> --%>
								<li>
			
			<%-- <a href="#"
				onclick="javascript:openPopupInvestigation(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getDepartment().getId()%>,<%=visit.getHin().getId()%>)">
					Previous Investigations</a></li>
			 --%>
			 <a href="#"
				onclick="javascript:openPopupInvestigation(<%=visit.getHin().getId()%>)">
					Previous Lab Investigations</a></li>
			<%String hinNo =visit.getHin().getHinNo();
					   if(hinNo!=null && !hinNo.isEmpty() && hinNo.charAt(0)=='0')
						   hinNo =hinNo.substring(1, hinNo.length());
					%>
			<li><a href="#"
				onclick="javascript:openPopupRadioInvestigation('<%=hinNo%>')">
					Previous Radiology Investigations</a></li>
		<%-- <li><a href="opd?method=showAllergyDetailsJsp&visitId=<%=visit.getId() %>&hinId=<%=visit.getHin().getId() %>">Allergies</a></li>--%>
	<%-- 	<li>
		<a href="#" onclick="openWindow('/hms/hms/adt?method=showMlcJsp&hinId=<%=visit.getHin().getId() %>&backFlag=OPD')">MLC Details</a>
		<!--<a href="#" onclick="submitFormForButton('opdMain','adt?method=showMlcJsp&hinId=<%=visit.getHin().getId() %>')">MLC Details</a>
		--></li> --%>
	<li>
	<a href="#" onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId() %>&token=<%=visit.getTokenNo()%>&backFlag=OPD')">Upload Documents </a>
	
	<!--<a href="#" onclick="submitFormForButton('opdMain','opd?method=showUploadingDocumentsJsp&visitId=<%=visit.getId() %>&token=<%=visit.getTokenNo()%>&backFlag=OPD')">Upload Documents </a>--></li>
	<%
	String departmentCodeForPhychiatrist = HMSUtil.getProperties("adt.properties", "departmentCodeForPhychiatrist");
	String departmentCodeForPediatric = HMSUtil.getProperties("adt.properties", "departmentCodeForPediatric");
	String departmentCodeForEye = HMSUtil.getProperties("adt.properties", "departmentCodeForEye");
	String departmentCodeForOBG = HMSUtil.getProperties("adt.properties", "departmentCodeForOBG");
	if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForOBG)) {
		obgDetails =new ObgDetails();
	  	if(obgDetailsList!=null && obgDetailsList.size()>0)
		{
				obgDetails = obgDetailsList.get(0);	
		}  
	}
	if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForPhychiatrist)) {%>
	
		<li><a href="#" onclick="openWindow('/hms/hms/opd?method=showPsychiatristQuestionnaireJsp&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId() %>&token=<%=visit.getTokenNo()%>&backFlag=OPD')">Phychiatrist Questionnaire </a></li>
			<li><a href="#"
				      onclick="openWindow('/hms/hms/opd?method=viewAllPrevoiusSession&hinId=<%=visit.getHin().getId()%>')">Previous Therapy
					 </a></li> 
	<%} %>
<%-- <li><a href="#">Drug Allergies</a></li> --%>
	<%--<li>Print AFMSF- 7A</li>
--%>

<%if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForPediatric)) {
	int patientAge =0;
	String age =null;
	if(visit.getHin().getAge()!= null){
		age=!visit.getHin().getAge().equals("")?visit.getHin().getAge():"";
		if(age.length()>0){
		patientAge=Integer.parseInt(age.split(" ")[0]);
		}
		}
 	if(patientAge<=7){ %>
				<li><a
					href="javascript:popwindowImmunization('opd?method=showVaccineDetailJsp&visitId=<%=visit.getId()%>');">Immunization</a></li>
				 <%}else{%>
				<!-- <li><a href="">Immunization</a></li> -->
				<%}}%> 
</ul>



<script type="text/javascript">
function openWindow(url){

    newwindow=window.open(url,'name',"left=2,top=100,height=750,width=1000,status=1,scrollbars=1,resizable=0");
	
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


</script>
</div>


<div class="opdArea">
<%-- <label>Return from Hospital</label>
<%

	if (opdDetailsForFollowup != null && opdDetailsForFollowup.getReturnfromHospital() != null  && opdDetailsForFollowup.getReturnfromHospital().equals("")
				&& opdDetailsForFollowup.getReturnfromHospital()
						.equalsIgnoreCase("true")) {
%> 
<input type="checkbox" name="returnfromHospital" class="radio" id="returnValue" value="false" checked="checked"  onclick="valueChange()"/>
<%}else{ %>
<input type="checkbox" name="returnfromHospital" class="radio" id="returnValue" value="false"  onclick="valueChange()"/>
<%} %> --%>
<%-- 
<label>Follow Up</label>
<%if(opdDetailsForFollowup != null){ %>
<input type="checkbox" name="followUp" class="radio" id="returnValue" checked="checked" value="false"  />
<%}else{ %>
<input type="checkbox" name="followUp" class="radio" id="returnValue"  value="false"  />
<%} %>--%>
<div class="clear"></div>


<div id=hospidataId style="display: none">
<label>Hospital Name</label>
<%
if(opdDetailsForFollowup!=null){
%>
<input type="text" name="hospName" tabindex="1" size="100" value="<%=(opdDetailsForFollowup.getHospName()!=null?opdDetailsForFollowup.getHospName():"") %>" maxlength="150" />
<%}else{ %>
<input type="text" name="hospName" tabindex="1" size="100" value="" maxlength="150" />
<%} %>
<label class="auto">DOA</label>
<%if(opdDetailsForFollowup != null){ %>
 <input	type="text" name="doa"  class="date" id="doa"	MAXLENGTH="30" validate="Pick a from date,date,no" value="<%=opdDetailsForFollowup.getDoa()!=null?opdDetailsForFollowup.getDoa():"" %>" readonly="readonly" onblur="checkDate1(this.value,this.id)"/>
 <%}else{ %>
  <input	type="text" name="doa"  class="date" id="doa"	MAXLENGTH="30" validate="Pick a from date,date,no" value="" readonly="readonly" onblur="checkDate1(this.value,this.id)"/>
 
 <%} %>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="javascript:setdate('doa',document.opdMain.doa, event)"	validate="Pick a date"  />
<label class="auto">DOD</label>
<%if(opdDetailsForFollowup != null){ %>
 <input	type="text" name="dod" value="<%=opdDetailsForFollowup.getDod()!=null?opdDetailsForFollowup.getDod():"" %>" class="date" id="dod"	MAXLENGTH="30" validate="Pick a from date,date,no" readonly="readonly" />
 <%}else{ %>
 <input	type="text" name="dod" value="" class="date" id="dod"	MAXLENGTH="30" validate="Pick a from date,date,no" readonly="readonly" onblur="checkDate1(this.value,this.id)"/>
 <%} %>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="javascript:setdate('dod',document.opdMain.dod, event)" validate="Pick a date"  onblur="checkDate1(this.value,this.id)"/>
<div class="clear"></div>
<label >Diagnosis</label>
<input type="text"  class="auto" size="48" 	id="pastDiagnosis" tabindex="1" value="" name="pastDiagnosis" maxlength="100" />
<div class="clear"></div> 
<label >Advise on Discharge</label>
<%if(opdDetailsForFollowup != null){ %>
<textarea name="adviceOnDischarge" cols="0" rows="0"  maxlength="300"	value="<%=opdDetailsForFollowup.getAdviceOnDischarge() !=null?opdDetailsForFollowup.getAdviceOnDischarge():"" %>"  tabindex="1" onkeyup="return ismaxlength(this)"></textarea>
<%}else{ %>
<textarea name="adviceOnDischarge" cols="0" rows="0"  maxlength="300"	value=""  tabindex="1" onkeyup="return ismaxlength(this)"></textarea>
<%} %>
<div class="clear"></div>

<%-- <label class="">Disposal</label>
<select name="pastdisposal" size="0" tabindex="1" class="med">
	<option value="">select</option>
	<% 
			
		for(MasDisposal masDisposalType : disposalTypeList){
			if(opdDetailsForFollowup != null){
			if(opdDetailsForFollowup.getDisposal() != null){
			if(opdDetailsForFollowup.getDisposal().equals(masDisposalType.getDisposalName())){
		%>
	<option value="<%=masDisposalType.getDisposalName() %>" selected="selected"><%=masDisposalType.getDisposalName() %></option>
	<%}}}else{%>
	<option value="<%=masDisposalType.getDisposalName() %>" ><%=masDisposalType.getDisposalName() %></option>
	<%}} %>
	</select>
 --%>
<!-- <label>Days</label>
<input name="disposalDays" type="text" tabindex="1" maxlength="2" id="disposalDays" size="20" validate='Days,int,no'  />

 -->
<%-- 	
<select name="pastdisposal" size="0" tabindex="1" class="med">
	<option value="0">select</option>
	<option value="ED">ED</option>
	<option value="MD">MD</option>
	<option value="LD">LD</option>
</select>
 --%>
<div class="clear"></div>

</div>

<div class="floatLeft">
<%-- <label >History of Present Illness<span>*</span></label> <!--  <input type="text" id="presentComplain"  name="presentComplain" maxlength="100"/>-->
<textarea name="presentComplain" cols="0" rows="0"  maxlength="950" validate="History of Present Illness,string,yes" value=""  tabindex="1" onkeyup="return ismaxlength(this)"><%=opdPatientHistory != null && opdPatientHistory.getPresentComplain()!=null ?opdPatientHistory.getPresentComplain():"" %></textarea>
 --%><div class="clear"></div>
<label >Past Medical History</label> <!--  <input type="text" id="presentComplain"  name="presentComplain" maxlength="100"/>-->
<textarea name="pastMedicalHistory" cols="0" rows="0"  maxlength="300"	value=""  tabindex="1" ><%=opdPatientHistory != null && opdPatientHistory.getPastMedicalHistory()!= null?opdPatientHistory.getPastMedicalHistory():"" %></textarea>
<div class="clear"></div>
<%-- <label>Family History</label> <!--  <input type="text" id="presentComplain"  name="presentComplain" maxlength="100"/>-->
<select name="familyHistory" id="familyHistory" tabindex="1" multiple="multiple" class="list" onclick="openOtherField(this.value);">
	<option value="0">select</option>
	<%
	if(patientFamilyHistoryList.size() > 0){
		for(PatientFamilyHistory familyHistory : patientFamilyHistoryList){
		%>
		<option value="<%=familyHistory.getId() %>"><%=familyHistory.getPatientHistoryName() %></option>
	<%}
	}
%>
</select> --%>

	<label>Present Complaint <span>*</span></label>
					<textarea class="opdMainTextArea yellowBackground"
						name="presentComplain" id="presentComplain" tabindex="2"
						validate="Present Complaint,string,yes" cols="0" rows="0"
						maxlength="300"><%=presentComplaintHistory %></textarea>
					<input type="button" class="button" tabindex="3" name=""
						value="+" onclick="getPresentTemplate('<%=complaintHistoryCode%>');" />

	<label>Family Present History</label>
					<textarea class="opdMainTextArea yellowBackground"
						name="familyHistory" validate="Family History,string,no"
						id="familyHistory" cols="0" rows="0" maxlength="500" tabindex="8"><%=familyPresentHistory %></textarea>
					<input type="button" class="buttonAuto-buttn" id="" name=""
						value="+" onclick="getFamilyHistoryTemplate('<%=familyHistoryCode%>');" tabindex="9" />
	<%if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForOBG)) {%>
				<label>HOPI</label><textarea name="hopi" cols="0" rows="0" maxlength="300"><%=obgDetails.getHopi()!=null?obgDetails.getHopi():""%></textarea>
	            <label>Other Complaints</label><textarea name="other_complaint" cols="0" rows="0" maxlength="300"><%=obgDetails.getOtherComplaints()!=null?obgDetails.getOtherComplaints():""%></textarea>
	             <label>Personal History</label><textarea name="personal_history" cols="0" rows="0" maxlength="200"><%=obgDetails.getPersonalHistory()!=null?obgDetails.getPersonalHistory():""%></textarea>
	          <label>Clinical History</label><textarea name="clinical_history" cols="0" rows="0" maxlength="200"><%=obgDetails.getClinicalHsirory()!=null?obgDetails.getClinicalHsirory():""%></textarea>
	          <label>Surgery History</label><textarea name="surgery_history" cols="0" rows="0" maxlength="200"><%=obgDetails.getSurgicalHistory()!=null?obgDetails.getSurgicalHistory():""%></textarea>
		<%} %>
<!-- <div id="otherFamilyHistoryDiv" style="display: none;">
<label>Other</label>
<input type="text" name="otherFamilyHistory" id="otherFamilyHistory" value="" maxlength="50">
</div> -->
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
<%--end for display patient history --%>
</script>
<%-- <textarea name="familyHistory" cols="0" rows="0"  maxlength="300"	value=""  tabindex="1" onkeyup="return ismaxlength(this)"></textarea> --%>
<%-- <div class="clear"></div>
<label >Risk Factors</label>  <input type="text" id="presentComplain"  name="presentComplain" maxlength="100"/>
<textarea name="riskFactor" cols="0" rows="0"  maxlength="300"	value=""  tabindex="1" onkeyup="return ismaxlength(this)"><%=opdPatientHistory != null && opdPatientHistory.getRiskFactor()!= null?opdPatientHistory.getRiskFactor():"" %></textarea> --%>
</div><!-- floatLeft ends-->



 <%--  
 ---------commented by anamika------------------------
  <div class="floatRight"><input	name="investigationTemplate" type="button" onclick="showSymptom()" class="btn_Symptomp_Assist"	tabindex="1"  /></div>--%><!-- float Right ends -->
<div class="clear"></div>
</div><!-- opdarea ends -->

<div class="clear"></div>
<%--  Commented On Date 20 Sep 2011 By Mukesh as per New SRS --%>
<%--
<h4>Examination</h4>
<div class="Block">
<label>General Phys Exam</label>

<input type="text" name="gpe_examination" tabindex="1" size="123" maxlength="150" class="auto" />
<div class="clear"></div>
</div>
 --%>
 <%if(opdReferralPatientDetails!=null  && opdReferralPatientDetails.getReferralVisit()!=null && opdReferralPatientDetails.getReferralVisit().getId().equals(visit.getId()) &&  opdReferralPatientDetails.getReferredDeptInt()!=null && opdReferralPatientDetails.getReferredDeptInt().getId().equals(deptId) )
	{
	
	 String name=opdReferralPatientDetails.getEmployee().getFirstName();
		if(opdReferralPatientDetails.getEmployee().getMiddleName()!=null && !opdReferralPatientDetails.getEmployee().getMiddleName().equals(""))
			name=name+" "+opdReferralPatientDetails.getEmployee().getMiddleName();
		if(opdReferralPatientDetails.getEmployee().getLastName()!=null && !opdReferralPatientDetails.getEmployee().equals(""))
			name=name+" "+opdReferralPatientDetails.getEmployee().getLastName();	
 %>  
 <div class="clear paddingTop5"></div>
 <h4>Referral</h4>
 <div class="Block">
 					<label>Referred by Doctor</label> <input type="text" id="" name=""
						readonly="readonly"
						value="<%=name%>" />
						
						
					<input type="hidden" id="" name="" readonly="readonly" /> 
						<label>Departement From</label> <input type="text" id=""
						name="" readonly="readonly"
						value="<%=opdReferralPatientDetails.getReferredDeptInt()!=null?opdReferralPatientDetails.getReferredDeptInt().getDepartmentName():"" %>" />
				<%-- 	<label>Hospital From</label> <input type="text" id="" name=""
						readonly="readonly"
						value="<%=opdPatientDetails.getHospital()!=null?opdPatientDetails.getHospital().getHospitalName():"" %>" /> --%>

					<label>Date</label> <input type="text" class="date"
						readonly="readonly"
						value="<%=opdReferralPatientDetails.getOpdDate()!=null?HMSUtil.convertDateToStringTypeDateOnly(opdReferralPatientDetails.getOpdDate()):"" %>" />

					<div class="clear"></div>
					<label>Doctor Note</label>
					<textarea cols="0" rows="0" maxlength="300"  readonly="readonly"><%=opdReferralPatientDetails.getReferralNotes()!=null?opdReferralPatientDetails.getReferralNotes():"" %>
					</textarea>
				<%-- 	<label>Patient Advice</label>
		<textarea class="auto" cols="82" rows="0" maxlength="300"
			readonly="readonly"><%=opdPatientDetails.getPatientAdvise()!=null?opdPatientDetails.getPatientAdvise():"" %>
					</textarea> --%>
					<%
					String referralSysDia = null;
					int count=0;
					Set<DischargeIcdCode> referralSysDiaSet = opdReferralPatientDetails.getDischargeIcdCodes();
					for(DischargeIcdCode dIC:referralSysDiaSet)
					{
						if(count==0)
							referralSysDia=dIC.getIcd().getIcdName();
						else
						referralSysDia +=" | "+dIC.getIcd().getIcdName();
						
						count++;
					
					}
					
					Set<DgOrderhd> referralDgOrderHd = opdReferralPatientDetails.getVisit().getDgOrderhds();
					count =0;
					String referralInvestigation = null;
						
					for(DgOrderhd dgHd:referralDgOrderHd)
					{
						
							for(DgOrderdt dgDt:dgHd.getDgOrderdts())
							{
						if(count==0)
							referralInvestigation=dgDt.getChargeCode().getChargeCodeName();
						else
							referralInvestigation +=" | "+dgDt.getChargeCode().getChargeCodeName();
						
						count++;
							}
					
					}
					%>
	   <label>System Diagnosis</label>
	   <textarea class="auto" cols="69" rows="0" maxlength="300"
		readonly="readonly"><%=referralSysDia !=null?referralSysDia:"" %></textarea>
		
		<label>Investigation</label>
	   <textarea class="auto" cols="69" rows="0" maxlength="300"
		readonly="readonly"><%=referralInvestigation !=null?referralInvestigation:"" %></textarea>	
 
 </div>
 
 <%} %>
 <div class="clear paddingTop5"></div>

 
 <%
 if(visit.getHin().getSex().getAdministrativeSexCode().equalsIgnoreCase("F"))
 {
	 
%>
 <h4>Pregnancy</h4>
 <div class="Block">
 <%	 
 if(opdDetailListForFollowUp.size() >0&& opdDetailListForFollowUp.get(0).getPregnancy()!=null && opdDetailListForFollowUp.get(0).getPregnancy().equalsIgnoreCase("y"))
 {
%>
   <label class="">Pregnant</label> <input type="checkbox" name="pregnancy" id="pregnancy"  class="radioAuto" value="y" onclick="fillPregnancylValue(this.id);putLMPEDD(this.id,'<%=HMSUtil.convertDateToStringWithoutTime(opdDetailListForFollowUp.get(0).getLmpDate())%>','<%=HMSUtil.convertDateToStringWithoutTime(opdDetailListForFollowUp.get(0).getEddDate())%>')" checked="checked"/>
   <label class="">LMP Date</label>
   <input type="text" name="lmp_date" id="lmp_date" readonly="readonly" id="lmp_date"  value="<%=HMSUtil.convertDateToStringWithoutTime(opdDetailListForFollowUp.get(0).getLmpDate())%>" onblur="generateEDD(this.id, pregnancy);"/>
   <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.getElementById('lmp_date'),event);" onchange="onSlelctSurgeryDate();" /></td>  
 
 <label class="">EDD</label><input type="text" name="edd" id="edd" readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(opdDetailListForFollowUp.get(0).getEddDate())%>"/>

 <%}
 
 else
 {%>
<label class="">Pregnant</label> <input type="checkbox" name="pregnancy" id="pregnancy"  class="radioAuto" value="n" onclick="fillPregnancylValue(this.id);"/>
	<label class="">LMP Date</label>
<input type="text" name="lmp_date" id="lmp_date" readonly="readonly" id="lmp_date"  value="" onblur="generateEDD(this.id, pregnancy);"/>  
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.getElementById('lmp_date'),event);" onchange="onSlelctSurgeryDate();" /></td>
 <label class="">EDD</label><input type="text" name="edd" id="edd"readonly="readonly"/>
 <%} 
 %>
  </div>
 <%}%>

<div class="clear paddingTop5"></div>
<h4>Vitals</h4>
<div class="Block">
<label class="">Weight</label>
<input name="weight" tabindex="1" type="text" id="weight" value="<%=opdDetailsForFollowup !=null && opdDetailsForFollowup.getVweight()!=null?opdDetailsForFollowup.getVweight():"" %>"  onblur="calculateBMI()" class="auto" size="5" validate="weight,int,no" maxlength="3" />
<label class="unit">kg</label> 

<label  class="">Height</label> 
<input name="height" tabindex="1" type="text" id="height" value="<%=opdDetailsForFollowup !=null && opdDetailsForFollowup.getHeight() != null ?opdDetailsForFollowup.getHeight():"" %>" class="auto" onblur="calculateIdealWeight();calculateBMI();" size="5" validate="height,int,no"  maxlength="3" />
<label class="unit">cm</label>

 <label	class="">BMI</label> 
<input tabindex="1" type="text" id="bmi" name="bmi" readonly="readonly" maxlength="6" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getBmi() != null ? opdDetailsForFollowup.getBmi():"" %>" onKeyUp="limitText(this,6);" class="auto" size="5" />
<label class="unit">kg/m<sup>2</sup></label> 
  <div class="clear"></div>
<label	class="">Ideal Weight</label>
 <input name="idealWeight" type="text" id="idealWeightId" tabindex="1" class="auto" size="5" value="<%=opdDetailsForFollowup!= null && opdDetailsForFollowup.getIdealWeight()!= null ?opdDetailsForFollowup.getIdealWeight():"" %>" tabindex="1" validate="Ideal Weight,string,no" maxlength="3" />
 <label class="unit">kg</label> 
 <label class="">Temperature</label>
 <input name="temperature" id="tempId" type="text" validate="Temperature,float,no" tabindex="1" value="<%=opdDetailsForFollowup!= null && opdDetailsForFollowup.getTemperature()!= null?opdDetailsForFollowup.getTemperature():"" %>" class="auto" size="5" onblur="convertFarenhiteToCelcius();" maxlength="5" />
 <label class="unit">&deg;F</label>
 <label class="">Temperature</label>
 <input name="temperature" id="tempInCelciusId"  type="text" tabindex="1" value="" class="auto" size="5" maxlength="5" onblur="convertCelciusToFarenhite();" />
  <label class="unit">&deg;C</label>
   <div class="clear"></div>
 <label	class="">Pulse</label>
 <input name="pulse" type="text" tabindex="1" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getPulse() != null?opdDetailsForFollowup.getPulse():"" %>" class="auto" size="5" tabindex="1" validate="pulse,int,no" maxlength="3" />
 <label class="unit">/min</label> 
   
   
 <label class="">BP</label>
 <input	name="bp" id="bp" type="text" tabindex="1" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getBp()!= null?opdDetailsForFollowup.getBp():"" %>" class="auto" size="5" onblur="if(this.value!=''){validateBpValue(this.value)};" maxlength="7" />
 <label class="unit">mm/Hg</label>
 <label class="">RR</label>
 <input	name="rr" id="rr" type="text" tabindex="1" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getRr()!= null?opdDetailsForFollowup.getRr():"" %>" class="auto" size="5" maxlength="3" validate="RR,int,no"/>
 <label class="unit">/min</label>
<div class="clear"></div>
 	<%if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForOBG)) {%>
			<label class="">PR</label>
			<input name="pr" id="pr" type="text" value="<%=opdDetailListForFollowUp.get(0).getPr()!=null?opdDetailListForFollowUp.get(0).getPr():""%>" tabindex="1" class="auto" size="5" maxlength="3" validate="PR,int,no" /><div style="float: left; width: 48px;">&nbsp; </div>
			<label class="">SP</label>
			<input name="sp" id="sp" type="text" value="<%=opdDetailListForFollowUp.get(0).getSp()!=null?opdDetailListForFollowUp.get(0).getSp():""%>" tabindex="1" class="auto" size="5" maxlength="3" validate="SP,int,no" /><div style="float: left; width: 48px;">&nbsp; </div>
			<label class="">BST</label>
			<input name="bst" id="bst" type="text" value="<%=opdDetailListForFollowUp.get(0).getBst()!=null?opdDetailListForFollowUp.get(0).getBst():""%>" tabindex="1" class="auto" size="5" maxlength="3" validate="bst,int,no" /><div style="float: left; width: 48px;">&nbsp; </div><div class="clear"></div>
			<label class="">Breast</label>
			<select name="breast"><option value="">Select</option>
			
			<%
	if(opdDetailListForFollowUp.size()>0 && opdDetailListForFollowUp.get(0).getBreast()!=null && opdDetailListForFollowUp.get(0).getBreast().equalsIgnoreCase("N")){%>
	    <option selected="selected">N</option>
	<%}else{%> 
	 <option>N</option>
				<%}
	if(opdDetailListForFollowUp.size()>0 && opdDetailListForFollowUp.get(0).getBreast()!=null && opdDetailListForFollowUp.get(0).getBreast().equalsIgnoreCase("AD")){%>
	    <option selected="selected">AD</option>
	<%}else{%> 
	 <option>AD</option>
			<%} %>
			
			</select>	
				<label class="">Spine</label>
			<select name="spine"><option value="">Select</option>
					<%
	if(opdDetailListForFollowUp.size()>0 && opdDetailListForFollowUp.get(0).getSpine()!=null && opdDetailListForFollowUp.get(0).getSpine().equalsIgnoreCase("A1")){%>
	    <option selected="selected">A1</option>
	<%}else{%> 
	 <option>A1</option>
				<%}if(opdDetailListForFollowUp.size()>0 && opdDetailListForFollowUp.get(0).getSpine()!=null && opdDetailListForFollowUp.get(0).getSpine().equalsIgnoreCase("Ab")){%>
	    <option selected="selected">Ab</option>
	<%}else{%>
			<option>Ab</option>
			<%} %>	
			</select>
	<%} %>
 <div class="clear"></div><label>On Examination</label>	

<textarea name="onExamination" cols="118" rows="0" value="" maxlength="300" class="auto" tabindex="1"  onkeyup="return ismaxlength(this)"><%=opdDetailsForFollowup != null && opdDetailsForFollowup.getOnExamination()!= null?opdDetailsForFollowup.getOnExamination():"" %></textarea>
<div class="clear"></div>

<input type="hidden" name="userName" value="<%=userName %>" />
<div class="clear"></div>
</div>
<!-- OBG details -->
	 <%if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForOBG)) {%>
<h4> OBG Details</h4>	       
<div class="Block"> 
	     
	     <label> Obestrtic History</label> 	<select name="obg_history"><option value="">Select</option>
	     <%
	if(obgDetails.getObstreticHistory()!=null && obgDetails.getObstreticHistory().equalsIgnoreCase("Primigravida")){%>
	    <option selected="selected">Primigravida</option>
	<%}else{%> 
	 <option>Primigravida</option>
				<%}if(obgDetails.getObstreticHistory()!=null && obgDetails.getObstreticHistory().equalsIgnoreCase("Multigravida")){%>
	    <option selected="selected">Multigravida</option>
	<%}else{%>
			<option>Multigravida</option>
			<%} %>	
			</select>
	     <label>Obstetric Score G</label><select name="obstetric_score_g"><option value="">Select</option>
	        <%for(int i=0;i<=9;i++){
	        	if(obgDetails.getObstreticScoreG()!=null && obgDetails.getObstreticScoreG()==i){
	        	%>	
	        	  <option selected="selected"><%=i%></option>
	        	<%} else{
	        	%>
	       <option><%=i%></option>
	             <%} %>
	       <%} %>
	     </select>
	       <label>Obstetric Score P</label><select name="obstetric_score_p"><option value="">Select</option>
	        <%for(int i=0;i<=9;i++){ 
	        	   if(obgDetails.getObstreticScoreP()!=null && obgDetails.getObstreticScoreP()==i){
	   	        	%>	
	   	        	  <option selected="selected"><%=i%></option>
	   	        	<%} else{
	   	        	%>
	       <option><%=i%></option>
	       <%} }%>
	     </select>
	       <label>Obstetric Score A</label><select name="obstetric_score_a"><option value="">Select</option>
	        <%for(int i=0;i<=9;i++){ 
	       if(obgDetails.getObstreticScoreA()!=null &&obgDetails.getObstreticScoreA()==i){
	        	%>	
	        	  <option selected="selected"><%=i%></option>
	        	<%} else{
	        	%>
	       <option><%=i%></option>
	              <%} %>
	       <%} %>
	     </select>
	       <label>Obstetric Score L</label><select name="obstetric_score_l"><option value="">Select</option>
	        <%for(int i=0;i<=9;i++){ if(obgDetails.getObstreticScoreL()!=null &&obgDetails.getObstreticScoreL()==i){
	        	%>	
	        	  <option selected="selected"><%=i%></option>
	        	<%} else{
	        	%>
	       <option><%=i%></option>
	       <%} }%>
	     </select>
	     <label>Conception</label><select name="conception"><option value="">Select</option>
	      <%
	if(obgDetails.getConception()!=null && obgDetails.getConception().equalsIgnoreCase("Sponta-Neous")){%>
	    <option selected="selected">Sponta-Neous</option>
	<%}else{%> 
	 <option>Sponta-Neous</option>
				<%}if(obgDetails.getConception()!=null && obgDetails.getConception().equalsIgnoreCase("Assisted-OI/IU")){%>
	    <option selected="selected">Assisted-OI/IU</option>
	<%}else{%>
			<option>Assisted-OI/IU</option>
			<%} %>	
	   </select><div class="Clear"></div>
	     <label>Married Life</label><input type="text" name="total_marriage_year" value="<%=obgDetails.getMarriedLife()!=null?obgDetails.getMarriedLife():""%>">
	     <label>Consan Guinity</label><select name="consan"><option value="">Select</option>
	     	      
			<%if(obgDetails.getConsanGuinity()!=null && obgDetails.getConsanGuinity().equalsIgnoreCase("I")){%>
			    <option selected="selected">I</option><%}else{%> 
			 <option>I</option><%}if(obgDetails.getConsanGuinity()!=null && obgDetails.getConsanGuinity().equalsIgnoreCase("II")){%>
			    <option selected="selected">II</option>
			<%}else{%><option>II</option><%}if(obgDetails.getConsanGuinity()!=null && obgDetails.getConsanGuinity().equalsIgnoreCase("III")){%>
		    <option selected="selected">III</option>
		<%}else{%><option>III</option><%} %>	
	   </select>
	     <label>Booked</label><select name="booked"><option value="">Select</option>
	     	<%if(obgDetails.getBooked()!=null && obgDetails.getBooked().equalsIgnoreCase("Yes")){%>
			    <option selected="selected">Yes</option><%}else{%> 
			 <option>Yes</option><%}if(obgDetails.getBooked()!=null && obgDetails.getBooked().equalsIgnoreCase("No")){%>
			    <option selected="selected">No</option>
			<%}else{%><option>No</option><%} %>	
	       </select><div class="Clear"></div>
	 	 <label>Immunised</label><select name="immunised"><option value="">Select</option>
	 	 	<%if(obgDetails.getImmunised()!=null && obgDetails.getImmunised().equalsIgnoreCase("Yes")){%>
			    <option selected="selected">Yes</option><%}else{%> 
			 <option>Yes</option><%}if(obgDetails.getImmunised()!=null && obgDetails.getImmunised().equalsIgnoreCase("No")){%>
			    <option selected="selected">No</option>
			<%}else{%><option>No</option><%} %>	
	 	    </select>
	 	 <label>I,II,III Trimisters</label><select name="trimisters"><option value="">Select</option>
	 	 	<%if(obgDetails.getTrimisters()!=null && obgDetails.getTrimisters ().equalsIgnoreCase("EventFul")){%>
			    <option selected="selected">EventFul</option><%}else{%> 
			 <option>EventFul</option><%}if(obgDetails.getTrimisters ()!=null && obgDetails.getTrimisters ().equalsIgnoreCase("UneventFul")){%>
			    <option selected="selected">UneventFul</option>
			<%}else{%><option>UneventFul</option><%} %>	
	 	
	 	 </select>
	      <label>Specify</label> <textarea rows="" cols="" name="specify" maxlength="200"><%=obgDetails.getSpecify()!=null?obgDetails.getSpecify():""%></textarea><div class="Clear"></div>
	      
	      <h4>Menstrual History</h4>
	      <label>Age of Menarche</label><select name="menarche_age"><option value="menarche_age">Select</option>
	       <%for(int i=9;i<=70;i++){
	    	   if(obgDetails.getAgeOfMenarche() !=null && obgDetails.getAgeOfMenarche()==i){
		        	%>	
		        	  <option selected="selected"><%=i%></option>
		        	<%} else{
		        	%>
	       <option><%=i%></option>
	       <%}} %>
	       </select>
	      <label>Cycles</label><select name="cycles"><option value="cycles">Select</option>
	      
	<%if(obgDetails.getCycles()!=null && obgDetails.getCycles().equalsIgnoreCase("Regular")){%>
			    <option selected="selected">Regular</option><%}else{%> 
			 <option>Regular</option><%}if(obgDetails.getCycles()!=null && obgDetails.getCycles().equalsIgnoreCase("Irregular")){%>
			    <option selected="selected">Irregular</option>
			<%}else{%><option>Irregular</option><%} %>	
	     </select>
	      <label>Range</label><select name="range"><option value="range">Select</option>  <%for(int i=9;i<=70;i++){ 
	    	  if(obgDetails.getRangeValue()!=null && obgDetails.getRangeValue()==i){
		        	%>	
		        	  <option selected="selected"><%=i%></option>
		        	<%} else{
		        	%>
	       <option><%=i%></option>
	       <%} }%></select>
	      <label>Flow</label><select name="flow"><option value="">Select</option>  <%for(int i=1;i<=30;i++){ 
	    	  if(obgDetails.getFlow()!=null && obgDetails.getFlow()==i){
		        	%>	
		        	  <option selected="selected"><%=i%></option>
		        	<%} else{
		        	%>
	       <option><%=i%></option>
	       <%} }%></select>
	    <div class="Clear"></div><div class="Clear"></div>
	       <h4>Systemie Examination</h4>
	         <label>Respiratory System</label><select name="respiratory_system"><option value="">Select</option>
			<%if(obgDetails.getRespiratorySystem()!=null && obgDetails.getRespiratorySystem().equalsIgnoreCase("Velicular")){%>
			    <option selected="selected">Velicular</option><%}else{%> 
			 <option>Velicular</option><%}if(obgDetails.getRespiratorySystem()!=null && obgDetails.getRespiratorySystem().equalsIgnoreCase("Bronchial")){%>
			    <option selected="selected">Bronchial</option>
			<%}else{%><option>Bronchial</option><%} %>	
	         </select>
	         <label>Breath sounds</label><select name="breath_sound"><option value="">Select</option>
	         <%if(obgDetails.getBreadthAddedSounds()!=null && obgDetails.getBreadthAddedSounds().equalsIgnoreCase("Crept")){%>
			    <option selected="selected">Crept</option><%}else{%> 
			 <option>Crept</option><%}if(obgDetails.getBreadthAddedSounds()!=null && obgDetails.getBreadthAddedSounds().equalsIgnoreCase("Rhonchi")){%>
			    <option selected="selected">Rhonchi</option>
			<%}else{%><option>Rhonchi</option><%} %>	
      	      </select>
	       
	          <h4>Cardiovascular System </h4>
	           <label>S1</label><select name="s1"><option value="">Select</option>
	           <%if(obgDetails.getS1()!=null && obgDetails.getS1().equalsIgnoreCase("Normal")){%>
			    <option selected="selected">Normal</option><%}else{%> 
			 <option>Normal</option><%}if(obgDetails.getS1()!=null && obgDetails.getS1().equalsIgnoreCase("Ab(n)")){%>
			    <option selected="selected">Ab(n)</option>
			<%}else{%><option>Ab(n)</option><%} %>	
	 	
	          </select>
	           <label>S2</label><select name="s2"><option value="">Select</option>
	               <%if(obgDetails.getS2()!=null && obgDetails.getS2().equalsIgnoreCase("Normal")){%>
			    <option selected="selected">Normal</option><%}else{%> 
			 <option>Normal</option><%}if(obgDetails.getS2()!=null && obgDetails.getS2().equalsIgnoreCase("Ab(n)")){%>
			    <option selected="selected">Ab(n)</option>
			<%}else{%><option>Ab(n)</option><%} %>	
	         </select>
	           <label>Murmurs</label><input type="text" name="murmurs" maxlength="30" value="<%=obgDetails.getMurmurs()!=null?obgDetails.getMurmurs():""%>">
	           
	           	     <div class="Clear"></div><div class="Clear"></div> <div class="Clear"></div><div class="Clear"></div>
	         <h4>Per Abdomen Examination</h4>	   
	           <div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div>
	           <label>Inspection-Height of Uterus</label><select name="uterus_height"><option value="">Select</option><%for(int i=12;i<=40;i++){
	        	   if(obgDetails.getHeightOfUterus()!=null  && obgDetails.getHeightOfUterus()==i){
	   	        	%>	
	   	        	  <option selected="selected"><%=i%></option>
	   	        	<%} else{
	   	        	%>
	       <option><%=i%></option>
	       <%}} %></select>
	    
	           <label>Palpation-Lower Pole</label><select name="lower_pole"><option value="">Select</option>
	           <%if(obgDetails.getLowerPole()!=null && obgDetails.getLowerPole().equalsIgnoreCase("Head")){%>
			    <option selected="selected">Head</option><%}else{%> 
			 <option>Head</option><%}if(obgDetails.getLowerPole()!=null && obgDetails.getLowerPole().equalsIgnoreCase("breech")){%>
			    <option selected="selected">breech</option>
			<%}else{%><option>breech</option><%} %>	
	 	
	           </select>
	           <label>Lateral grip:Back</label><select name="lateral_grip"><option value="">Select</option>
	           <%if(obgDetails.getLowerGrip()!=null && obgDetails.getLowerGrip().equalsIgnoreCase("Left")){%>
			    <option selected="selected">Left</option><%}else{%> 
			 <option>Left</option><%}if(obgDetails.getLowerGrip()!=null && obgDetails.getLowerGrip().equalsIgnoreCase("Right")){%>
			    <option selected="selected">Right</option>
			<%}else{%><option>Others</option><%} if(obgDetails.getLowerGrip()!=null && obgDetails.getLowerGrip().equalsIgnoreCase("Others")){%>
		    <option selected="selected">Others</option>
		<%}else{%><option>Others</option><%} %>	
	 	
	         </select><div class="Clear"></div>
	           <label>Auscultation : Fatal Heart Rate - Regular</label><select name="heart_rate_regular"><option value="">Select</option><%for(int i=90;i<=100;i++){ 
	        	   if(obgDetails.getHeartRateRegular()!=null &&obgDetails.getHeartRateRegular()==i){
	   	        	%>	
	   	        	  <option selected="selected"><%=i%></option>
	   	        	<%} else{
	   	        	%>
	       <option><%=i%></option>
	       <%} }%></select>
	           <label>Fatal Heart Rate Absent</label><input type="text" name="heart_rate_absent" maxlength="15" value="<%=obgDetails.getHeartRateAbsent()!=null?obgDetails.getHeartRateAbsent():""%>">
	           
	          <h4>Per Vaginal Examination</h4>
	          <label>OS Dilatation of cervix</label><select name="cervix_dilatation"><option value="">Select</option><%for(int i=0;i<=10;i++){ 
	        	  if(obgDetails.getDilatationOfCervix()!=null && obgDetails.getDilatationOfCervix()==i){
	  	        	%>	
	  	        	  <option selected="selected"><%=i%></option>
	  	        	<%} else{
	  	        	%>
	       <option><%=i%></option>
	       <%}} %></select> (CM)
	          <%-- <label>Effacement of cervix</label><select name="cervix_effacement"><option value="">Select</option>
	             <%for(int i=0;i<100;){
	            	 if(obgDetails.getEffacementOfCervix()==i){
	     	        	%>	
	     	        	  <option selected="selected"><%=i%></option>
	     	        	<%} else{
	     	        	%>
	       <option><%=i%><%i+=10;%>-<%=i%></option>
	       <%}}%>	          
	          </select> --%>
	          <label>Membrane</label><select name="membrane"><option value="">Select</option>
	                       <%if(obgDetails.getMembrane()!=null && obgDetails.getMembrane().equalsIgnoreCase("Intact")){%>			    <option selected="selected">Intact</option><%}else{%> 
			 <option>Intact</option><%}if(obgDetails.getMembrane()!=null && obgDetails.getMembrane().equalsIgnoreCase("Ruptured")){%>
			    <option selected="selected">Ruptured</option>
			<%}else{%><option>Melonium</option><%} %>	
	         </select>
	          <label>Liquor</label><select name="liquor"><option value="">Select</option>
	          
	                  <%if(obgDetails.getLiquor()!=null && obgDetails.getLiquor().equalsIgnoreCase("clear")){%>
			    <option selected="selected">clear</option><%}else{%> 
			 <option>clear</option><%}if(obgDetails.getLiquor()!=null && obgDetails.getLiquor().equalsIgnoreCase("Blood Tinged")){%>
			    <option selected="selected">Blood Tinged</option>
			<%}else{%><option>Melonium</option><%} if(obgDetails.getLiquor()!=null && obgDetails.getLiquor().equalsIgnoreCase("Melonium")){%>
		    <option selected="selected">Melonium</option>
		<%}else{%><option>Melonium</option><%} %>	
	          
	       </select>
	          <label>Consistency of cervix</label><select name="cervix_consistency"><option value="">Select</option>
	             <%if(obgDetails.getConsistencyOfCervix()!=null && obgDetails.getConsistencyOfCervix().equalsIgnoreCase("Soft")){%>
			    <option selected="selected">Soft</option><%}else{%> 
			 <option>Soft</option><%}if(obgDetails.getConsistencyOfCervix()!=null && obgDetails.getConsistencyOfCervix().equalsIgnoreCase("Medium")){%>
			    <option selected="selected">Medium</option>
			<%}else{%><option>Hard</option><%} if(obgDetails.getConsistencyOfCervix()!=null && obgDetails.getConsistencyOfCervix().equalsIgnoreCase("Hard")){%>
		    <option selected="selected">Hard</option>
		<%}else{%><option>Hard</option><%} %>	
	          </select>
	          <label>Position of cervix</label><select name="cervix_position"><option value="">Select</option>
	           <%if(obgDetails.getPositionOfCervix()!=null && obgDetails.getPositionOfCervix().equalsIgnoreCase("anterior")){%>
			    <option selected="selected">anterior</option><%}else{%> 
			 <option>anterior</option><%}if(obgDetails.getPositionOfCervix()!=null && obgDetails.getPositionOfCervix().equalsIgnoreCase("MIO")){%>
			    <option selected="selected">MIO</option>
			<%}else{%><option>posterior</option><%} if(obgDetails.getPositionOfCervix()!=null && obgDetails.getPositionOfCervix().equalsIgnoreCase("posterior")){%>
		    <option selected="selected">posterior</option>
		<%}else{%><option>posterior</option><%} %>	
	          </select>
	          <label>Length of cervix</label><select name="cervix_length"><option value="">Select</option>
	          	          <%for(int i=0;i<=4;i++){ 
	          	        	if(obgDetails.getLengthOfCervix()!=null && obgDetails.getLengthOfCervix()==i){
	          		        	%>	
	          		        	  <option selected="selected"><%=i%></option>
	          		        	<%} else{
	          		        	%>
	       <option><%=i%></option>
	       <%}} %></select>
	          <label>Station of Presenting Part</label><select name="station"><option value="">Select</option>
	          <%for(int i=-3;i<=3;i++){ 
	        	  if(obgDetails.getStationOfPresentingPart()!=null && obgDetails.getStationOfPresentingPart()==i){
	  	        	%>	
	  	        	  <option selected="selected"><%=i%></option>
	  	        	<%} else{
	  	        	%>
	       <option><%=i%></option>
	       <%} }%></select>
	          <label>Head</label><select name="head"><option value="">Select</option>
	          <%if(obgDetails.getHead()!=null && obgDetails.getHead().equalsIgnoreCase("Mobile")){%>
			    <option selected="selected">Mobile</option><%}else{%> 
			 <option>Mobile</option><%}if(obgDetails.getHead()!=null && obgDetails.getHead().equalsIgnoreCase("Fixed")){%>
			    <option selected="selected">Fixed</option>
			<%}else{%><option>Fixed</option><%} %>	
	 	
	          </select><div class="Clear"></div>
	          <label>Pelvis</label><select name="pelvis"><option value="">Select</option>
	                <%if(obgDetails.getPelvis()!=null && obgDetails.getPelvis().equalsIgnoreCase("Mobile")){%>
			    <option selected="selected">Adevate</option><%}else{%> 
			 <option>Adevate</option><%}if(obgDetails.getPelvis()!=null && obgDetails.getPelvis().equalsIgnoreCase("contracted")){%>
			    <option selected="selected">contracted</option>
			<%}else{%><option>contracted</option><%} %>	
	          </select>
</div>	
	 <%}%>
	<!-- OBG details end -->
<div class="clear paddingTop5"></div>
<div class="floatRight"><input	name="investigationTemplate" type="button" value="Clinical Assist"	onclick="showDiagnosis()" tabindex="1" class="buttonBig" /></div>
<div class="clear paddingTop5"></div>
<!-- floatRight ends -->
<h4>Diagnosis</h4>
<div class="Block">

<div class="floatLeft">
<%-- 	<label >On Examination</label>  --%>
<input	type="hidden" id="systamicExam" class="large" name="systamicExam"	maxlength="200" />
<label>Working Diagnosis</label>
<% 

if( opdDetailsForFollowup != null && opdDetailsForFollowup.getInitialDiagnosis()!=null)
{%>
<input type="text" class="auto"   id="initialDiagnosis" tabindex="1" size="117" value="<%=opdDetailsForFollowup.getInitialDiagnosis() %>"	name="initialDiagnosis" maxlength="100"  />
<% }else{%>
<input type="text" class="auto"  id="initialDiagnosis" tabindex="1" value="" size="117"	name="initialDiagnosis" maxlength="100" />

<% }%>

<div class="clear"></div>

<%-- <label>System Diagnosis</label>

<input 	name="systemDiagnosis" value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getSystemDiagnosis()!= null?opdDetailsForFollowup.getSystemDiagnosis().getSystemDiagnosisName()+"["+opdDetailsForFollowup.getSystemDiagnosis().getId()+"]":"" %>"	id="systemDiagnosis" tabindex="1" class="auto" onblur="checkForSystemDiagnosis(this.value);" size="117"/>
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('systemDiagnosis','ac2update','opd?method=autoCompleteForSystemDiagnosis',{parameters:'requiredField=systemDiagnosis'});
		</script> --%>


<div class="clear"></div>
<%--
<label>ICD Code</label>
<input name="" value=""	id="icdCode" tabindex="1" class="auto" size="117" onblur="getIcd();" />
<input name="" value=""	id="temp" type="hidden" /> 
<IMG SRC="/hms/jsp/images/search.gif"	WIDTH="24" HEIGHT="20" style="cursor: pointer; margin:0px;" class="floatLeft"	onClick="javascript:openPopupWindow();"	title="Click here to Search ICD Codes" />
 --%>
<input type="hidden" name="ageName" value="<%=visit.getHin().getAge() %>" id="ageId" /> 

<div class="clear"></div>
<label>ICD Diagnosis<span>*</span></label>

<input type="text" tabindex="1"	value="" id="icd"  name="icd"	class="auto"  size="53" onblur="fillDiagnosisCombo(this.value);"/>
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
		   //document.getElementById('slide0').style.display="hide"
</script>
<select name="<%=DIAGNOSIS_ID%>" multiple="4" size="5" tabindex="1"  id="diagnosisId" class="listBig"  validate="ICD Daignosis,string,yes">
	<option value="0">Select</option>
	<%
		if(dischargeIcdCodeList.size()>0){
			int i=0;
			for(DischargeIcdCode icdCode : dischargeIcdCodeList){
	%>
	<%--  <input type="hidden" value="<%=icdCode.getId()%>" name="dischargeIcdCode"<%=i%>/>  --%>
	<option value="<%=icdCode.getId()%>@@<%=icdCode.getIcd().getIcdCode() %>" selected="selected"><%=icdCode.getIcd().getIcdName()+"["+icdCode.getIcd().getIcdCode()+"]" %></option>
	
	<%i++;}
			}%>
</select>

<input type="button" class="buttonDel" value="" 	onclick="deleteDgItems(this,'diagnosisId');" align="right" />
<!-- <input type="button" class="button" value="Delete" 	id="removeOPDisgnosis" align="right" /> -->
</div><!-- floatLeft ends -->

<%-- <%if(visit.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("male")) {%>
<div id="pregnancy">
	<label >
	<input type="checkbox" name="preganancy" id="preganancy" class="radioCheckCol2"/>
	Patient is Pregnant
	</label>
</div>

<%} %> --%>
</div>
<div class="clear"></div>
<!-- fayaz added -->
<h4>Investigation</h4>

<%-- <div class="Block">
<label >Template</label>
<div id="investigationDiv">
<select name="investigationTemplateId" id="investigationTemplateId" tabindex="1" multiple="multiple" class="list" onblur="showHideInvestigationTemplateCombo();">
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
	<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getTemplateName()%></option>
	<%
		   }
	      }

		%>

</select>
</div>
<input	name="Prevoius" type="button" value="Previous" tabindex="1"	class="button"	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />
<div id="createInvestigationDivToShowHide">
<input	name="investigationTemplate" type="button"	value="Create Template" tabindex="1" class="buttonBig" onclick="showCreateInvestigationTemplate();" />
</div>
<div id="copyPrevInvestigationTemplateDiv" style="display: none">
<input name="copyPrevInvestigationTemplate" tabindex="1" type="button"	value="Copy Previous" class="buttonBig" onclick="copyPrevInvestigationTempate('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>');" />
</div>
<div id="investigationImportButton1" >
<input	name="investigationImportButton1" tabindex="1" type="button"	value="Import New" class="button"	onclick="getListForTreatment('investigationDiv');" />
</div>
<!-- <label>Urgent</label>
<input type="checkbox" name="urgent" tabindex="1" class="radioAuto" value="1" /> -->
</div> --%>

<div class="clear"></div>
<div class="Block">
<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
	  	  <td colspan="3" >
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
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>

		
	<%int inc=1;
			String investigationName = "";
		if(patientInvestigationdetails != null){
		for (DgOrderdt patientInvestigation : patientInvestigationdetails) {
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
		<td>	<input type="hidden" tabindex="1" id="dgOrderDtId<%=inc %>" name="dgOrderDtId<%=inc %>" value="<%=patientInvestigation.getId()%>"
			size="10" readonly /> 
		<input type="text" value="<%=investigationName %>" tabindex="1" 
			id="chargeCodeName<%=inc %>" size="100" name="chargeCodeName<%=inc %>"
			onblur="checkForAlreadyPrescribedInvestigation(this.value,'1',document.getElementById('visitId').value);if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{minChars:2,
					  callback: function(element, entry) {
				            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
				        },
					  parameters:'requiredField=chargeCodeName<%=inc %>'});
				  
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
						size="10" maxlength="6" validate="Qty,num,no" />  <input
			type="hidden" tabindex="1" id="chargeCode<%=inc %>" name="chargeCode<%=inc %>"
			size="10" readonly /> 
			
			<!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
<%-- 		<%if(patientInvestigation.getReferToMh().equals("") && patientInvestigation.getReferToMh().equals("y") ){ %>
		<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio" checked="checked" validate="Refer to MH,string,no" /></td>
		<%}else{ %>
		<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td>
		<%} %> --%>
			<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td>
		<%if(!sampleCollected) {%>
		  <input type="button" name="delete" value="" class="buttonDel" tabindex="1" onclick="removeRow('investigationGrid','hiddenValue',this);" />
			<%}
		else{%>
			Sample Collected
		<%}%>
	    </td>


	</tr>
	<%inc++;}
		%>
			<input type="hidden" value="<%=inc-1 %>" name="hiddenValue" id="hiddenValue" />
		<%}else{ %>
	
		<tr>
		<td>
		<input type="text" value="<%=investigationName %>" tabindex="1" 
			id="chargeCodeName<%=inc %>" size="100" name="chargeCodeName<%=inc %>"
			onblur="checkForAlreadyPrescribedInvestigation(this.value,'1',document.getElementById('visitId').value);if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
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
	
		<td><input name="Button" type="button" class="buttonAdd" value="" tabindex="1"
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" tabindex="1"
			onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


	</tr>
	
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
	
	<%} %>


</table>
</div>
<label>Other Investigation</label>
<textarea name="otherInvestigation" cols="50" rows="0" maxlength="500" 	tabindex="1" onkeyup="return ismaxlength(this)" class="auto"><%=otherInvestigation%></textarea>
<div class="clear paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid1">
	<tr>
		<th scope="col">Clinical Notes</th>

	</tr>
	<tr>
	<%
	if(opdDetailsForFollowup != null){
	if(opdDetailsForFollowup.getCaseNotes()!= null){ %>
		<td><input type="text" name="clinicalNotes1" id="clinicalNotes" tabindex="1" value="<%=opdDetailsForFollowup.getCaseNotes()%>"
			size="100" maxlength="98" /></td>
			<%}}else{ %>
			<td><input type="text" name="clinicalNotes1" id="clinicalNotes" tabindex="1" value="" size="98" maxlength="42" /></td>
			<%} %>

	</tr>
</table>
</div>

<%
	//if (patientPrescriptionHeaderList.size()>0 && patientPrescriptionHeaderList.get(0).getPatientPrescriptionDetails().size()!=0) {
		if (patientPrescriptionHeaderList.size()>0) {
		
%>
<div class="clear paddingTop5"></div>
<h4>Treatment</h4>
<div id="templateDivToShowHide" class="floatLeft">
<%-- <div class="Block">

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

<div id="prescriptionImportButton" class="floatLeft" >
<input	name="prescriptionImportButton1" tabindex="1" type="button"	value="Import New" class="button"	onclick="getListForTreatment('treatmentDiv');" /> 
	  
</div>
             	<div class="floatRight">
				<a href="#"
					onclick="getTodayAllPrescriptionPopup('<%=hinId%>');">Current Medication</a>
			</div>
</div> --%>

<div id="testDiv">
<div class="cmntable">
<div class="Clear"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid">
	<tr>
		 <th>Nomenclature/Material Code</th>
	    <th colspan="1">Other Drug</th>
	<!--      <th colspan="1">Injection</th>-->
		<!-- <th scope="col">PVMS No.</th> -->
	<!-- 		<th scope="col">Unit</th> -->
		<th scope="col">Class</th>
		<th scope="col">AU</th>
		<th scope="col">Dispensing Unit</th>
		<th scope="col">Dosage<span>*</span></th>
		<th scope="col">Frequency<span>*</span></th>
		<th scope="col">Days<span>*</span></th>
		<th scope="col">Total<span>*</span></th>
		<!--
		<th id="sosQtyLbl">Qty</th>
		--><!--  <th scope="col">Total</th>
		<th scope="col">Intake</th> -->
		<th scope="col">Route</th>
		<!--<th scope="col">Type</th>-->
		<th scope="col">Remarks</th>
		<!-- <th scope="col">CT</th> -->
		<th scope="col">Stock</th>
		<th>Add</th>
		<th>Delete</th>
		
	</tr>


	<%
		int inc1 = 1;
				if (patientPrescriptionHeader.getPatientPrescriptionDetails() != null) {
					
					for (PatientPrescriptionDetails patientPrescriptionDetails : patientPrescriptionHeader
							.getPatientPrescriptionDetails()) {
						System.out.println(patientPrescriptionHeader.getStatus() +" 1");
					
					}
					
					pHeaderId = patientPrescriptionHeader.getId();
					boolean prescriptionIssued = false;
					boolean injectionIssued = false;
					System.out.println("");
					if(patientPrescriptionHeader.getStatus().equalsIgnoreCase("I"))
					prescriptionIssued = true;
					String readonly ="";
					if(prescriptionIssued)
						readonly ="readonly='readonly'";
					for (PatientPrescriptionDetails patientPrescriptionDetails : patientPrescriptionHeader
							.getPatientPrescriptionDetails()) {
						
					if(!prescriptionIssued){
							readonly = "";
							injectionIssued = false;
						for(InjAppointmentDetails injDt: injAppDetails){
							if(patientPrescriptionDetails.getId() == injDt.getPatientPrescriptionDetails().getId() && injDt.getStatus()!=null && injDt.getStatus().equalsIgnoreCase("y") )
							{
								injectionIssued = true;
								readonly ="readonly='readonly'";
								break;
							}
						  }
						
						if(!injectionIssued  && patientPrescriptionDetails.getInjectionStatus()!=null && !patientPrescriptionDetails.getInjectionStatus().equalsIgnoreCase("n"))
						{
							readonly ="readonly='readonly'";
							injectionIssued = true;
						}
						
						}
						
						else if(!patientPrescriptionDetails.getInjectionStatus().equalsIgnoreCase("n"))
						{
							readonly ="readonly='readonly'";
							injectionIssued = true;
						} 
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
							System.out.println("au "+au);
		%> 
	        <input type="hidden" tabindex="1"	id="prescriptionId<%=inc1%>" name="prescriptionId<%=inc1%>" size = "30" readonly="readonly" value="<%=patientPrescriptionDetails.getId()%>"/>
	        <input type="hidden" tabindex="1"	id="injFlag<%=inc1%>" name="injFlag<%=inc1%>" size = "30" readonly="readonly" value="<%=patientPrescriptionDetails.getInjectionStatus()%>"/>
			<input type="text" tabindex="1"	id="nomenclature<%=inc1 %>" size = "30"  <%=readonly %> value="<%=itemName1%> "
			size="50" name="nomenclature<%=inc1%>"  onblur="checkForAlreadyIssuedPrescription(this.value,'<%=inc1%>');populatePVMS(this.value,'<%=inc1%>');checkItem(<%=inc1%>);disableOtherMedicine(this.value,'<%=inc1%>');displayAu(this.value,<%=inc1%>,'<%=hinId%>');checkForPurchase(this.value,'<%=inc1%>');"/>
			 <input type="hidden" name="itemId<%=inc1%>" id="itemId<%=inc1%>"	value="<%=patientPrescriptionDetails.getItem().getId()%>" />
			 <input type="hidden" name="itemIdClassificationId<%=inc1%>" id="itemIdClassificationId<%=inc1%>"/>
			<div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature<%=inc1%>','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature<%=inc1%>'});
			</script>
			</td>
	<td><input type="text" name="otherMedicine<%=inc1%>" tabindex="1" id="otherMedicine<%=inc1%>"  size="20" onblur="checkDuplicateOtherMedicine(this.value,'<%=inc1%>');readOnlyNomenclature(this.value,'<%=inc1%>');showSimilarMedicineNames(this.value);" validate="other Medicine,string,no" /></td>
		<%-- <td><input type="text" name="otherMedicine<%=inc1%>" tabindex="1" id="otherMedicine<%=inc1%>"   size="20"	 validate="Other Medicine,string,no" onblur="showSimilarMedicineNames(this.value);"/></td> --%>
<%-- <td><input type="checkbox" name="injCategory" class="radio" id="injCategory" value="false"   /></td>--%>
	<td><select name="itemClass<%=inc1%>" id="itemClass<%=inc1%>" disabled="disabled">
		<option value="0">Select</option>
		<%for(MasItemClass mc : masItemClassList) {
		  if(mc.getId() == patientPrescriptionDetails.getItem().getItemClass().getId())
		       {		 	
		    %>	   <option value="<%=mc.getId()%>" selected="selected"><%=mc.getItemClassName()%></option>
		      <% }else{
          %>
			<option value="<%=mc.getId()%>"><%=mc.getItemClassName()%></option>
			<%} }%> 
			
		</select>
		
				<%
				MasItemClass  Mic = null;

			     for (int i = 0; i < masItemClassList.size(); i++) {
			    	 Mic = (MasItemClass) masItemClassList.get(i);
     			 %> <script>

     			itemClassArray[<%=i%>]= new Array();
     			itemClassArray[<%=i%>][0] = "<%=Mic.getId()%>";
     			itemClassArray[<%=i%>][1] = "<%=Mic.getItemClassName()%>";
            </script> <% }%>
		
		</td>
		 		<td><select name="itemConversionId<%=inc1%>" id="itemConversionId<%=inc1%>" tabindex="1" class="medium"  disabled="disabled">
			<option value="0">Select</option>
		 	<%

		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       if(masStoreItemConversion.getId() == patientPrescriptionDetails.getItem().getItemConversion().getId())
		       {		 	
		    %>	   <option value="<%=masStoreItemConversion.getId() %>" selected="selected"><%=masStoreItemConversion.getItemUnitName()%></option>
		      <% }else{
          %>
			<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
			<%} }%> 
		</select>
 		<%
	    		MasStoreItemConversion  masStoreItemConversion1 = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion1 = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion1.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion1.getItemUnitName()%>";
            </script> <% }%> 
		<!-- </td> 
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" /> -->
		<input type="hidden" name="au<%=inc1%>" tabindex="1" value="" id="au<%=inc1%>"  size="6"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty<%=inc1%>" tabindex="1" id="actualDispensingQty<%=inc1%>" value=""  size="6"  validate="AU,string,no" />
		<input type="hidden" tabindex="1" id="highValueMedicine<%=inc1%>" name="highValueMedicine<%=inc1%>" validate="AU,string,no" value=""/>  
		</td>
<%-- <%if(au != null){ %>
		<td>
		<input type="text" name="au<%=inc1%>" tabindex="1" value="<%=au %>" id="au<%=inc1%>" readonly="readonly" size="6"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty<%=inc1%>" tabindex="1" id="actualDispensingQty<%=inc1%>" value=""  size="6"  validate="AU,string,no" />
		<input type="hidden" name="highValueMedicine<%=inc1%>" tabindex="1" id="highValueMedicine<%=inc1%>" value=""  size="1"  validate="AU,string,no" />
			</td>
			<%}else{ %>
			<td>
		<input type="text" name="au<%=inc1%>" tabindex="1" value="" id="au<%=inc1%>"  size="6"  readonly="readonly"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty<%=inc1%>" tabindex="1" id="actualDispensingQty<%=inc1%>" value=""  size="6"  validate="AU,string,no" />
		<input type="hidden" name="highValueMedicine<%=inc1%>" tabindex="1" id="highValueMedicine<%=inc1%>" value=""  size="1"  validate="AU,string,no" />
			</td>
			<%} %> --%>
			
					<td>
		<select name="dispensingUnit<%=inc1%>" id="dispensingUnit<%=inc1%>" tabindex="1" class="medium"  disabled="disabled">
			<option value="0">Select</option>
			<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
		    	     if(patientPrescriptionDetails.getItem().getDispUnit()!=null&& masStoreItemConversion.getItemUnitName()!=null && masStoreItemConversion.getItemUnitName().equalsIgnoreCase(patientPrescriptionDetails.getItem().getDispUnit()))
				       {		 	
				    %>	   <option value="<%=masStoreItemConversion.getItemUnitName() %>" selected="selected"><%=masStoreItemConversion.getItemUnitName()%></option>
				      <% }else{
		          %>
					<option value="<%=masStoreItemConversion.getItemUnitName() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
					<%} }%> 
		</select>
		</td>
			
			<td>
			<input type="hidden" name="pvmsNo<%=inc1%>" id="pvmsNo<%=inc1%>" value="<%=pvmsNo%>" size="10" readonly="readonly" /><input type="text" name="dosage<%=inc1%>" <%=readonly%>
			id="dosage<%=inc1%>" value="<%=dosage%>" size="5" tabindex="1" onblur="checkDosageValidation(this.value,'<%=inc1%>');fillValue('<%=inc1%>')"/></td>
			
			<td><select name="frequency<%=inc1%>" id="frequency<%=inc1%>"  class="medium"  
			tabindex="1" onchange="getFrequencyValue(this.value,'<%=inc1%>');fillValueFromFrequency(this.value,'<%=inc1%>');displaySOSQty(this.value,'<%=inc1%>');fillValue('<%=inc1%>')">
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
		 <input type="hidden" name="frequencyValue<%=inc1%>" id="frequencyValue<%=inc1%>" value="3"></td>
		  <input type="text" name="sosQty<%=inc1%>" tabindex="1" id="sosQty<%=inc1%>" style="display: none;"   size="3" onblur="fillValue('<%=inc1%>')"	maxlength="3" validate="Sos Qty,num,no" />
		
		
        <%
        	if (patientPrescriptionDetails.getNoOfDays() != null) {
        %>
		<td><input type="text" name="noOfDays<%=inc1%>" size="3"
			tabindex="1" id="noOfDays<%=inc1%>"  value="<%=noOfDays%>"
			 <%=readonly%>  onblur="fillValue('<%=inc1%>')" validate="days,num,no"/></td>
		<%
			} else {
		%>
		<td><input type="text" name="noOfDays<%=inc1%>" size="3"
			tabindex="1" id="noOfDays<%=inc1%>"  onblur="fillValue('<%=inc1%>')"
			 <%=readonly%>/></td>
		<%
			}
		%>
				<%
				
				if(patientPrescriptionDetails.getItem().getItemClassification()!=null && patientPrescriptionDetails.getItem().getItemClassification().getId() ==2)
				{
					readonly ="";
				}
				else
				{
					readonly ="readonly='readonly'";
				}
				
				if(total != 0){ %>
		<td>
			<input type="text" name="total<%=inc1%>"  value="<%=total %>" tabindex="1" id="total<%=inc1%>" <%=readonly%>/></td>
			<%}else{ %>
			<td>	<input type="text" name="total<%=inc1%>" tabindex="1" id="total<%=inc1%>" <%=readonly%> /></td>
			
			<%} %>
		
		<%if(route != null && !route.equals("")){ %>
		<td><input type="text" name="route<%=inc1%>" tabindex="1" id="route<%=inc1%>" value="<%=route %>"  size="5" maxlength="20"	<%=readonly%>  validate="Route,string,no" />
			<%}else{ %>
			<td><input type="text" name="route<%=inc1%>" tabindex="1" id="route<%=inc1%>" value=""  size="5" maxlength="20"	 validate="Route,string,no" />
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
			value="<%=remark%>iuoio" class="small" <%=readonly%> maxlength="10" /></td>
			<%
				} else {
			%>
			<td><input type="text" name="remarks<%=inc1%>" tabindex="1" id="remarks<%=inc1%>"  size = "10"
			value="" class="small"  <%=readonly%> maxlength="10"/></td>
			<%
				}
			%>
		<%-- 	<td><input type="checkbox" name="ct<%=inc1%>" class="radio" id="ct<%=inc1%>" value="y" />
		</td> --%>
		<td><input type="text" name="closingStock<%=inc1%>" disabled="disabled" tabindex="1" value="" id="closingStock<%=inc1%>"  size="3"  validate="closingStock,string,no" /></td>
		
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<%	if(!prescriptionIssued && !injectionIssued){ %>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid','hdb',this);" tabindex="1" />
			<%} else if(injectionIssued){%>
			Injection cannot be modified
			<%} else{%>
			Issued
			<%} %>
			</td>
			
	</tr>
	<%
		inc1++;
					}
				}
	%>
	<input type="hidden" name="hdb" value="<%=inc1 - 1%>" id="hdb" />


</table>
<div class="Clear"></div>

</div>
</div>
</div>
<%
	} else {
	
%>
<div class="clear paddingTop5"></div>
<h4><div class="floatRight"><input	name="treatmentTemplate" type="button" value="Treatment Assist"	tabindex="1" onclick="showTreatment()" class="buttonBig" />
</div>
<div class="clear paddingTop5"></div>
Treatment</h4>

<div id="templateDivToShowHide" class="floatLeft">

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

<%-- <div id="prevButtonDivToShowHide">
<input name="Prevoius2"	tabindex="1" type="button" value="Previous" class="button"	onclick="openPopupForPatientPrescription('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>','<%=visit.getDepartment().getId()%>','<%=visit.getId()%>')" />
</div> --%>
<div id="createPresDivToShowHide">
<input 	name="createPrescriptionTemplate" tabindex="1" type="button" value="Create Template"    class="buttonBig" onclick="showCreatePrescriptionTempate();" />
</div>
<div id="copyPrevPrescriptionTemplateDiv" style="display: none;">
<input name="copyPrevPrescriptionTemplate" tabindex="1" type="button" value="Copy Previous" class="buttonBig"	onclick="copyPrevPrescriptionTempate('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>');" />
</div>

<div id="prescriptionImportButton" class="floatLeft" >
<input	name="prescriptionImportButton1" tabindex="1" type="button"	value="Import New" class="button"	onclick="getListForTreatment('treatmentDiv');" /> 
	  
</div>
             	<div class="floatRight">
				<a href="#"
					onclick="getTodayAllPrescriptionPopup('<%=hinId%>');">Current Medication</a>
			</div>
</div>

<div id="testDiv">
<!--<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid1">
	<tr>
	<th scope="col">Remarks</th>

	<td><input type="text" name="remaks" tabindex="1"
			size="120" maxlength="45" /></td></tr>
	</table>
	-->
	<div class="cmntable">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

	<tr>
		 <th>Nomenclature/Material Code</th>
	    <th colspan="1">Other Drug</th>
	<!--      <th colspan="1">Injection</th>-->
		<!-- <th scope="col">PVMS No.</th> -->
	<!-- 		<th scope="col">Unit</th> -->
		<th scope="col">Class</th>
		<th scope="col">AU</th>
		<th scope="col">Dispensing Unit</th>
		<th scope="col">Dosage<span>*</span></th>
		<th scope="col">Frequency<span>*</span></th>
		<th scope="col">Days<span>*</span></th>
		<th scope="col">Total<span>*</span></th>
		<!--
		<th id="sosQtyLbl">Qty</th>
		--><!--  <th scope="col">Total</th>
		<th scope="col">Intake</th> -->
		<th scope="col">Route</th>
		<!--<th scope="col">Type</th>-->
		<th scope="col">Remarks</th>
		<!-- <th scope="col">CT</th> -->
		<th scope="col">Stock</th>
		<th>Add</th>
		<th>Delete</th>
		
	</tr>
	<tr>
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature1" size="30"  name="nomenclature1" onblur="checkForAlreadyIssuedPrescription(this.value,'1');populatePVMS(this.value,'1');checkItem(1);disableOtherMedicine(this.value,'1');displayAu(this.value,'1','<%=hinId%>');checkForPurchase(this.value,'1');"  />
	    <!-- <IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();" title="Click here to Search for Nomenclature"> -->
	      <input type="hidden" name="itemId1" id="itemId1"	value="" />
	        <input type="hidden" name="itemIdClassificationId" id="itemIdClassificationId"	value="" />
	      
	     <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>
		<td><input type="text" name="otherMedicine1" tabindex="1" id="otherMedicine1"  size="20" onblur="checkDuplicateOtherMedicine(this.value,'1');readOnlyNomenclature(this.value,'1');showSimilarMedicineNames(this.value);" validate="other Medicine,string,no" /></td>
		<td><select name="itemClass1" id="itemClass1">
		<option value="0">Select</option>
		<%for(MasItemClass mc : masItemClassList) {%>
		<option value="<%=mc.getId()%>"><%=mc.getItemClassName()%></option>
		<%} %>
		</select>
		
				<%
				MasItemClass  Mic = null;

			     for (int i = 0; i < masItemClassList.size(); i++) {
			    	 Mic = (MasItemClass) masItemClassList.get(i);
     			 %> <script>

     			itemClassArray[<%=i%>]= new Array();
     			itemClassArray[<%=i%>][0] = "<%=Mic.getId()%>";
     			itemClassArray[<%=i%>][1] = "<%=Mic.getItemClassName()%>";
            </script> <% }%>
		
		</td>
 		<td><select name="itemConversionId1" id="itemConversionId1" tabindex="1" class="medium"  >
			<option value="0">Select</option>
			<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
			<option value="<%=masStoreItemConversion.getItemUnitName() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
			<%} %>
		</select>
 		<%
	    		MasStoreItemConversion  masStoreItemConversion1 = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion1 = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion1.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion1.getItemUnitName()%>";
            </script> <% }%> 
		<!-- </td> 
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" /> -->
		<input type="hidden" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty1" tabindex="1" id="actualDispensingQty1" value=""  size="6"  validate="AU,string,no" />
		<input type="hidden" tabindex="1" id="highValueMedicine1" name="highValueMedicine1" validate="AU,string,no" value=""/>  
		</td>
		<td>
		<select name="dispensingUnit1" id="dispensingUnit1" tabindex="1" class="medium"  >
			<option value="0">Select</option>
			<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
			<option><%=masStoreItemConversion.getItemUnitName()%></option>
			<%} %>
		</select>
		</td>
	<%-- <td><input type="checkbox" name="injCategory1" class="radio" id="injCategory1" value="y" />
		</td>--%>
		<td><input type="hidden" name="pvmsNo1" tabindex="1" id="pvmsNo1"	size="10" readonly="readonly" />
	<input type="text" name="dosage1" tabindex="1" value="" id="dosage1"	size="5" maxlength="5" onblur="checkDosageValidation(this.value,'1');fillValue('1')" /></td>
		<td><select name="frequency1" id="frequency1" tabindex="1" class="medium" onchange="getFrequencyValue(this.value,'1');fillValueFromFrequency(this.value,'1');displaySOSQty(this.value,'1');fillValue('1')" >
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
            <input type="text" name="sosQty1" tabindex="1" id="sosQty1" style="display: none;"   size="3" onblur="fillValue('1')"	maxlength="3" validate="Sos Qty,num,no" />
		</td>
		<td><input type="text" name="noOfDays1" tabindex="1" id="noOfDays1" onblur="fillValue('1')"  size="3"	maxlength="3" validate="No of Days,num,no" />
		
			
		</td>
		<td><input type="text" name="total1" tabindex="1" id="total1" size="3"/></td>
		<td><input type="text" name="route1" tabindex="1" id="route1" value=""  size="5" maxlength="20"	 validate="Route,string,no" />
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
			<!-- <td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td> -->
		<td><input type="text" name="closingStock1" tabindex="1" value="" id="closingStock1"  size="3"  validate="closingStock,string,no" /></td>
		
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid','hdb',this);" tabindex="1" />
			</td>
	</tr>
	<input type="hidden" name="hdb" value="1" id="hdb" />
</table>
<div class="clear"></div>
</div>
</div>
</div>
<div class="clear"></div>
<div class="Block">
<label>Other Treatment</label>
<textarea name="otherTreatment" cols="50" rows="0" maxlength="500" 	tabindex="1" onkeyup="return ismaxlength(this)" class="auto"></textarea>
</div>

<%} %>

<div class="clear"></div>
<div class="paddingTop40"></div>
			<div class="Block">

					<label>Procedure Advice</label>
					<div class="clear"></div><div class="clear"></div><div class="clear"></div>
					<div class="floatRight" style="margin-right: 173px">
					<input type="button" class="buttonAdd"
							alt="Add" tabindex="4" value=""
							onclick="addRowTreatmentNursingCare();" align="left" />
						<input type="button" class="buttonDel" tabindex="3" alt="Delete"
							value="" onclick="removeRowTreatmentNursingCare();"
							align="right" /> 
					</div>
					<div class="clear"></div>
					<div id="divTemplet" style="width: 700px;">
						<table border="0" align="center" cellpadding="0" cellspacing="0"
							id="gridNursing">

							<tr>
								<th>&nbsp;</th>
								<th>Procedure Name</th>
								<th>Frequency<span>*</span></th>
								<th>No.Of Days<span>*</span></th>
								<th>Remarks</th>
								<!-- <th>Alert Me</th> -->
							</tr>
							<%
	int incr=0 ;
	int len=1;
	if(procedureDetails.size()>0){
		len=procedureDetails.size();
	}
	Integer procedureId=0;
	Integer procedureHeaderId=0;
	String nursingCare="";
	String nursingRemark="";
	String procedureStatus="";
	int noOfDays=0;
	int frequencyId_1=0;
	System.out.println("procedureDetails "+procedureDetails.size());
	for(;incr<len;incr++){
	
		ProcedureDetails procedureDetails1=null;
		if(procedureDetails.size()>0 ){
			procedureDetails1=procedureDetails.get(incr);
		}
		if(procedureDetails1!=null){
			procedureId=procedureDetails1.getId();
			procedureHeaderId=procedureDetails1.getProcedureHeader().getId();
			nursingCare=procedureDetails1.getNursingCare().getNursingName()+"["+procedureDetails1.getNursingCare().getId()+"]";
			if(procedureDetails1.getRemarks()!=null)
			nursingRemark=procedureDetails1.getRemarks();
			procedureStatus=procedureDetails1.getStatus();
			noOfDays = procedureDetails1.getNoOfDays();
			frequencyId_1 = procedureDetails1.getFrequency().getId();
		}
	%>
							<tr>
								<td>
									<%if(procedureStatus.equalsIgnoreCase("y")) {%> <input
									type="checkbox" disabled="disabled" class="radioCheck"
									id="nursingRadio<%=incr%>" name="nursingRadio<%=incr%>" />
								</td>
								<%}else{ %>
								<input type="checkbox" class="radioCheck"
									id="nursingRadio<%=incr%>" name="nursingRadio<%=incr%>">
								</td>
								<%} %>
								<input type="hidden"
									value="<%=procedureId!=null && !procedureId.equals(0)?procedureId:0 %>"
									name="procedureDetailId<%=incr%>"
									id="procedureDetailId<%=incr%>" />
								<td>
									<%if(procedureStatus.equalsIgnoreCase("y")) {%>
										<input	readonly="readonly" type="text"	class="opdTextBoxSmall textYellow"
										value="<%=nursingCare %>" id="procedureName_nursing<%=incr%>" size="35"	name="procedureName_nursing<%=incr%>"
										<%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 	
										 />
									<%}else{%>
										<input	type="text" class="opdTextBoxSmall textYellow"	value="<%=nursingCare %>" id="procedureName_nursing<%=incr%>" 
										size="35" name="procedureName_nursing<%=incr%>"
										<%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 
										  /> 
										<%}%>
									<div id="ac2updates_nursing<%=incr%>" style="display: none;" class="autocomplete"></div>
									<script type="text/javascript"	language="javascript" charset="utf-8">
											  new Ajax.Autocompleter('procedureName_nursing<%=incr%>','ac2updates_nursing<%=incr%>','registration?method=getProcedureForAutoComplete',{
											  callback: function(element, entry) {
								              return entry + '&minor_major=1';
								        }, parameters:'requiredField=procedureName_nursing<%=incr%>'});
									</script> 
								</td>
								<td>
								<%-- onchange="populateNoOfDaysForNursingProcedure(this.value,'<%=incr%>')" --%>
								<select name="frequency_nursing<%=incr%>"
									id="frequency_nursing<%=incr%>" tabindex="36"> 
										<option value="0">Select</option>
										<%
						  MasFrequency masFrequency = new MasFrequency();
					      for(MasFrequency masFrequency2 : frequencyList){
					       int id = masFrequency2.getId();
					       String name = masFrequency2.getFrequencyName();
			          %>
										<option value="<%=id %>" <% if(frequencyId_1 == id){%>
											selected <%}%>><%=name%></option>
										<%} %>
								</select> <%
		    		MasFrequency masFrequency3 = new MasFrequency();
				         for (int i = 0; i < frequencyList.size(); i++) {
				        	 masFrequency3 = (MasFrequency) frequencyList.get(i);
	     			 %> <script>
		          icdArray[<%=i%>]= new Array();
		          icdArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
		          icdArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
	            </script> <% }%></td>
								<td id="nf<%=incr%>"><input type="text"
									name="noOfDays_nursing<%=incr%>" id="noOfDays_nursing<%=incr%>" 
									value="<%=noOfDays!=0?noOfDays:""%>" class="opdTextBoxTSmall textYellow" size="5" validate='Days,int,no'/>
								</td>
								<td>
									<%if(procedureStatus.equalsIgnoreCase("y")) {%> <input
									readonly="readonly" value="<%=nursingRemark %>" type="text"
									name="remark_nursing<%=incr%>" id="remark_nursing<%=incr%>"
									class="largTextBoxOpd textYellow" /> <%}else{ %> <input
									type="text" value="<%=nursingRemark %>"
									name="remark_nursing<%=incr%>" id="remark_nursing<%=incr%>"
									class="largTextBoxOpd textYellow" /> <%} %>
								</td>
						<%-- 		<td><input class="radioCheck" type="checkbox"
									name="alert_nursing<%=incr %>" name="alert_nursing<%=incr %>" /></td>
							</tr> --%>
							<%} %>
						</table>
						<input type="hidden" id="procedureHeaderId"
							name="procedureHeaderId" value="<%=procedureHeaderId%>" />
						</td> <input type="hidden" name="nursinghdb" value="<%=incr-1%>"
							id="nursinghdb" />
					</div>
				</div>
				
					<%if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForPhychiatrist)) {%>
		<div class="Block">
 <%
 int therapyHeaderId = 0;
 Date appointDate =null;
 String appointTime =null;
 if(therapyList.size()>0) {
	 therapyHeaderId = therapyList.get(0).getProcedureHeader().getId();
	 appointDate = therapyList.get(0).getProcedureHeader().getProcedureDate();
			 appointTime=therapyList.get(0).getProcedureHeader().getProcedureTime();
 }%>
		<label>Therapy Advice</label> <input name="investigationTemplate" value="Appointment Calendar"onclick="openWindow('/hms/hms/opd?method=showProcedureCalenderDoctorWise&opdFlag=y&psyFlag=y')" tabindex="1" class="buttonBig" type="button">
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="floatRight" style="margin-right: 173px">
			<input type="button" class="buttonAdd" alt="Add" tabindex="4"
				value="" onclick="addRowTherapy('t');" align="left" />
			<input type="button" class="buttonDel" tabindex="3" alt="Delete"
				value="" onclick="removeRowTherapy();"
				align="right" /><label>Appointment Date<span>*</span></label><input type="text" name="procedureDate" id="procedureDate"
			readonly="readonly" value="<%=appointDate!=null?HMSUtil.convertDateToStringWithoutTime(appointDate):""%>"
			 /> <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.getElementById('procedureDate'),event);"/>
			<label>Appointment Time<span>*</span></label><input type="text" id="procedureTime" name="procedureTime" onblur="IsValidTime(this.value,this.id)" onkeyup="mask(this.value,this,'2',':');" maxlength="5" value="<%=appointTime!=null?appointTime:""%>"/>
				
		</div>
		<div class="clear"></div>
		<div id="divTemplet" style="width: 700px;">
			<table border="0" align="center" cellpadding="0" cellspacing="0"
				id="gridTherapy">

				<tr>
					<th>&nbsp;</th>
					<th>Therapy Name</th>
					<!-- <th>Frequency<span>*</span></th>
					<th>No.Of Days<span>*</span></th> -->
					<th>Remarks</th>
					<!-- <th>Alert Me</th> -->
				</tr>
				<%
	 incr=0 ;
for(TherapyDetails td: therapyList){
%>
<tr><td></td><td><%=td.getProcedure().getNursingName()%></td><td><%=td.getOpdRemarks()%></td>
</tr>
<%}


	%>
				<tr>
					<td>
						<%if(procedureStatus.equalsIgnoreCase("y")) {%> <input
						type="checkbox" disabled="disabled" class="radioCheck"
						id="therapyRadio<%=incr%>" name="therapyRadio<%=incr%>" />
					</td>
					<%}else{ %>
					<input type="checkbox" class="radioCheck"
						id="therapyRadio<%=incr%>" name="therapyRadio<%=incr%>">
					</td>
					<%} %>
					<input type="hidden"
						value="<%=procedureId!=null && !procedureId.equals(0)?procedureId:0 %>"
						name="therapyDetailId<%=incr%>" id="therapyDetailId<%=incr%>" />
					<td>
						<%if(procedureStatus.equalsIgnoreCase("y")) {%> <input
						readonly="readonly" type="text" class="opdTextBoxSmall textYellow"
						value="<%=nursingCare %>" id="therapy_nursing<%=incr%>"
						size="35" name="therapy_nursing<%=incr%>" <%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 	
										 />
						<%}else{%> <input type="text" class="opdTextBoxSmall textYellow"
						value="<%=nursingCare %>" id="therapy_nursing<%=incr%>"
						size="35" name="therapy_nursing<%=incr%>" <%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 
										  />
						<%}%>
						<div id="ac2updates_therapy<%=incr%>" style="display: none;"
							class="autocomplete"></div> <script type="text/javascript"
							language="javascript" charset="utf-8">
											  new Ajax.Autocompleter('therapy_nursing<%=incr%>','ac2updates_therapy<%=incr%>','registration?method=getProcedureForAutoComplete&procedureType=t',{
											  callback: function(element, entry) {
								              return entry + '&minor_major=1';
								        }, parameters:'requiredField=therapy_nursing<%=incr%>'});
									</script>
					</td>
			<%-- 		<td>
						onchange="populateNoOfDaysForNursingProcedure(this.value,'<%=incr%>')"
						<select name="frequency_nursing<%=incr%>"
						id="frequency_nursing<%=incr%>" tabindex="36">
							<option value="0">Select</option>
							<%
						  MasFrequency masFrequency = new MasFrequency();
					      for(MasFrequency masFrequency2 : frequencyList){
					       int id = masFrequency2.getId();
					       String name = masFrequency2.getFrequencyName();
			          %>
							<option value="<%=id %>" <% if(frequencyId_1 == id){%> selected
								<%}%>><%=name%></option>
							<%} %>
					</select> <%
		    		MasFrequency masFrequency3 = new MasFrequency();
				         for (int i = 0; i < frequencyList.size(); i++) {
				        	 masFrequency3 = (MasFrequency) frequencyList.get(i);
	     			 %> <script>
		          icdArray[<%=i%>]= new Array();
		          icdArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
		          icdArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
	            </script> <% }%>
					</td>
					<td id="nf<%=incr%>"><input type="text"
						name="noOfDays_nursing<%=incr%>" id="noOfDays_nursing<%=incr%>"
						value="<%=noOfDays!=0?noOfDays:""%>"
						class="opdTextBoxTSmall textYellow" size="5" /></td>
					<td>
						<%if(procedureStatus.equalsIgnoreCase("y")) {%> <input
						readonly="readonly" value="<%=nursingRemark %>" type="text"
						name="remark_nursing<%=incr%>" id="remark_nursing<%=incr%>"
						class="largTextBoxOpd textYellow" /> <%}else{ %> <input type="text"
						value="<%=nursingRemark %>" name="remark_nursing<%=incr%>"
						id="remark_nursing<%=incr%>" class="largTextBoxOpd textYellow" />
						<%} %>
					</td> --%>
					<td><%-- input type="text"
						value="<%=nursingRemark%>" name="remark_therapy<%=incr%>"
						id="remark_therapy<%=incr%>" class="largTextBoxOpd textYellow" /> --%>
						<textarea size="20" class="large" id="remark_therapy<%=incr%>" name="remark_therapy<%=incr%>" validate="Remarks,string,no" value="" tabindex="1" style="width: 250px; height: 50px;" maxlength="1000"></textarea>
						</td>
					<%-- 		<td><input class="radioCheck" type="checkbox"
									name="alert_nursing<%=incr %>" name="alert_nursing<%=incr %>" /></td>
							</tr> --%>
			
				
			</table>
			<input type="hidden" id="therapyHeaderId" name="therapyHeaderId"
				value="<%=therapyHeaderId%>" />
			 <input type="hidden" name="therapyhdb" value="<%=incr-1%>"
				id="therapyhdb" />
		</div>
	</div>
	
	<%} %>
	
<div class="clear paddingTop15"></div>
	<%
	
	if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForEye)) {
	System.out.println("sfdfsd"+eyeDetails);
	%>
	<div class="Block">
	<h4>Ophthalmology Details</h4>
	<table border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr><th></th><th colspan="3" style="text-align: center;">R.E.</th><th colspan="3"style="text-align: center;">L.E.</th></tr>
	  <tr><th></th><th>SPH</th><th>CYL</th><th>Axis</th><th>SPH</th><th>CYL</th><th>Axis</th></tr>
	  <tr><th>Dist</th><td><input type="text" name="dist_r_sph" value="<%=eyeDetails!=null?eyeDetails.get(0).getDistRSph()!=null?eyeDetails.get(0).getDistRSph():"": ""%>" validate="R.E Dist SPH,num,no" maxlength="3"/></td><td><input type="text" name="dist_r_cyl" value="<%=eyeDetails!=null?eyeDetails.get(0).getDistRCyl()!=null?eyeDetails.get(0).getDistRCyl():"": ""%>" validate="R.E Dist CYL,num,no" maxlength="3"/></td><td><input type="text" name="dist_r_axix" value="<%=eyeDetails!=null?eyeDetails.get(0).getDistRAxis()!=null?eyeDetails.get(0).getDistRAxis():"": ""%>"validate="R.E Dist Axix,num,no" maxlength="3"/></td><td><input type="text" name="dist_l_sph" value="<%=eyeDetails!=null?eyeDetails.get(0).getDistLSph()!=null?eyeDetails.get(0).getDistLSph():"": ""%>" validate="L.E Dist SPH,num,no" maxlength="3"/></td><td><input type="text" name="dist_l_cyl" value="<%=eyeDetails!=null?eyeDetails.get(0).getDistLCyl()!=null?eyeDetails.get(0).getDistLCyl():"": ""%>" validate="L.E DistCYL,num,no" maxlength="3"/></td><td><input type="text" name="dist_l_axix" value="<%=eyeDetails!=null?eyeDetails.get(0).getDistLAxis()!=null?eyeDetails.get(0).getDistLAxis():"": ""%>" validate="L.E Dist Axix,num,no" maxlength="3"/></td></tr>
	  <tr><th>Near</th><td><input type="text" name="near_r_sph" value="<%=eyeDetails!=null?eyeDetails.get(0).getNearRSph()!=null?eyeDetails.get(0).getNearRSph():"": ""%>" validate="R.E Near SPH,num,no" maxlength="3"/></td><td><input type="text" name="near_r_cyl"value="<%=eyeDetails!=null?eyeDetails.get(0).getNearRCyl()!=null?eyeDetails.get(0).getNearRCyl():"": ""%>" validate="R.E Near CYL,num,no" maxlength="3"/></td><td><input type="text" name="near_r_axix" value="<%=eyeDetails!=null?eyeDetails.get(0).getNearRAxis()!=null?eyeDetails.get(0).getNearRAxis():"": ""%>" validate="R.ENear Axix ,num,no" maxlength="3"/></td><td><input type="text" name="near_l_sph" value="<%=eyeDetails!=null?eyeDetails.get(0).getNearLSph()!=null?eyeDetails.get(0).getNearLSph():"": ""%>" validate="L.E Near SPH,num,no" maxlength="3"/></td><td><input type="text" name="near_l_cyl" value="<%=eyeDetails!=null?eyeDetails.get(0).getNearLCyl()!=null?eyeDetails.get(0).getNearLCyl():"": ""%>" validate="L.E Near CYL,num,no" maxlength="3"/></td><td><input type="text" name="near_l_axix" value="<%=eyeDetails!=null?eyeDetails.get(0).getNearLAxis()!=null?eyeDetails.get(0).getNearLAxis():"": ""%>" validate="L.E Near Axix,num,no" maxlength="3"/></td></tr>
	 
	</table>
	<label>IPD(50-70)</label> <input type="text" name="eye_ipd" maxlength="2" value="<%=eyeDetails!=null?eyeDetails.get(0).getEyeIpd()!=null?eyeDetails.get(0).getEyeIpd():"": ""%>" validate="Eye IPD ,num,no">
	
	<label>Use</label><select name="eye_use"><option value="">Select</option>
	<%
	if(eyeDetails!=null && eyeDetails.get(0).getEyeUse()!=null && eyeDetails.get(0).getEyeUse().equalsIgnoreCase("Constant")){%>
	    <option selected="selected">Constant</option>
	<%}else{%> 
	 <option>Constant</option>
	
	<%}if(eyeDetails!=null &&  eyeDetails.get(0).getEyeUse()!=null && eyeDetails.get(0).getEyeUse().equalsIgnoreCase("Near")){%>
	<option selected="selected">Near</option>
	<%}else{%>
		<option>Near</option>
	<%}if(eyeDetails!=null && eyeDetails.get(0).getEyeUse()!=null &&  eyeDetails.get(0).getEyeUse().equalsIgnoreCase("Distance")){%>
	<option selected="selected" >Distance</option>
	<%}else{%>
	<option >Distance</option>
	<%} %>
	</select>
	<label>Type of Lens</label><select name="lensType"><option value="">Select</option>
	<%
	if(eyeDetails!=null && eyeDetails.get(0).getLensType()!=null && eyeDetails.get(0).getLensType().equalsIgnoreCase("Keyptok")){%>
	    <option selected="selected">Keyptok</option>
	<%}else{%> 
	 <option>Keyptok</option>
	
	<%}if(eyeDetails!=null && eyeDetails.get(0).getLensType()!=null && eyeDetails.get(0).getLensType().equalsIgnoreCase("Executive/Bifocal")){%>
	<option selected="selected">Executive/Bifocal</option>
	<%}else{%>
		<option>Executive/Bifocal</option>
	<%}if(eyeDetails!=null && eyeDetails.get(0).getLensType()!=null && eyeDetails.get(0).getLensType().equalsIgnoreCase("Progressive")){%>
	<option selected="selected" >Progressive</option>
	<%}else{%>
	<option >Progressive</option>
	<%} %>
	</select>
	</div>
	<%} %>
	<div class="clear paddingTop15"></div>
<div class="clear"></div>

<!-- Minor OT -->
<%if(OpdSurgeryDetailList.size()>0) {%>

<h4>Surgery advice</h4>

<!-- <div class="floatLeft" style="width: 300px;">
				<input type="button" class="button" value="Delete"
					onclick="removeSurgicalRow('surgicalGrid');" /> <input type="button"
					class="button" onclick="addSurgicalRequRow();" value="" />
					
					<input type="radio" value="SurgProc" class="radioCheckCol2" id="majorSurgery" style="margin-right:5px;" name="surgeryCheck" checked="checked" onchange=""><div class="labRadiologyDivfixed">Major</div>			
				<input type="radio" value="MinorSur" class="radioCheckCol2" id="minorSurgery" style="margin-right:5px;" name="surgeryCheck" onchange=""><div class="labRadiologyDivfixed">Minor</div>
					 <input type="hidden" name="surgeryCategory" id="surgeryCategory">
					
			</div> -->
			<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="surgicalGrid">
	<tr>
		<th scope="col" style="width: 20px;">S.No</th>
<!-- 		<th scope="col">Admission Date</th>
		<th scope="col">HIN No</th>
		<th scope="col">Patient Name</th>
		<th scope="col">A&D No.</th>
		<th scope="col">Department</th> -->
<!-- 		<th scope="col">Unit</th> -->
		<th scope="col">Procedure</th>
		<!-- <th scope="col">Tentative Date</th> -->
<!-- 		<th scope="col">PAC Status</th> -->
		<th scope="col">Surgery Type</th>
	     <th scope="col">Pacs</th>

	</tr>
	<%int i=0;
	String pName="";
	
	%>
	
	<%
	
	String admisDate="",UHID="",patName="",adNo="",deptName="",inpatientId="";

		i++;
String majSur ="";
String minSur ="";
try
{
	majSur = HMSUtil.getProperties("adt.properties", "subChargeCodeForMajorSurgery");
	minSur = HMSUtil.getProperties("adt.properties", "subChargeCodeForMinorSurgery");
}
catch(Exception e)
{
	e.printStackTrace();
}
for(OpdSurgeryDetail psd:OpdSurgeryDetailList){
	%>
	<tr>
		<td><%=i%></td>
		  		<td><input type="hidden" name="proscedureName<%=i%>" value="<%=psd.getChargeCode().getId()%>"/><input type="text" class="opdTextBoxSmall textYellow"  
		  		 value="<%=psd.getChargeCode().getChargeCodeName()%>" readonly="readonly" 
		 />
<%-- <input type="hidden" name="surgeryType<%=i %>" id="surgeryType<%=i %>"	value="major" /> --%>		 
		 
		<%--  <input type="text" value="" tabindex="1" size="40"
			id="chargeCodeName<%=inc %>" name="chargeCodeName<%=inc %>"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
			 --%>
		
		</div>
		
	<%--	 <div id="ac2update3<%=i %>" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('proscedureName<%=i %>','ac2update3<%=i %>','ot?method=getInvestigationListForRequestionForIP',{parameters:'requiredField=proscedureName<%=i %>'});
			</script>--%> 
			<!-- changed by govind 14-10-2016 end -->
		<input type="hidden" name="procedureId<%=i %>" id="procedureId<%=i %>"	value="" />
		 
		
		</td>
		<%-- <td><input type="text" size="8" value="<%=date+"/"+month+"/"+year%>" name="tentativeDate<%=i%>" id="tentativeDate<%=i%>"
							validate="Date,date,no" />
							<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.inpatientSurgeryRequisition.tentativeDate1,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
							</td> --%>
	<%-- 	<td><select name="pacstatus<%=i%>" id="pacstatus<%=i%>">
		<!-- <option value="0">select</option> -->
	
		<option value="Pending">Pending</option>
		<option value="Cleared">Cleared</option>
		</select>
		</td> --%>
		<td>
		<%if(majSur.equalsIgnoreCase(psd.getChargeCode().getSubChargecode().getSubChargecodeCode())) {%>
		Major
		<%}
		else if(minSur.equalsIgnoreCase(psd.getChargeCode().getSubChargecode().getSubChargecodeCode())) {%>
		Minor
		<%}
		%>
		</td>
		<td>
		<%if(majSur.equalsIgnoreCase(psd.getChargeCode().getSubChargecode().getSubChargecodeCode())){ %>
		 <input class="button" alt="PAC" tabindex="4" value="PAC" onclick="openWindow('/hms/hms/opd?method=viewPreAnesthesiaOPD&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId() %>&chargeCode=<%=psd.getChargeCode()!=null?psd.getChargeCode().getId():"0"%>&token=<%=visit.getTokenNo()%>&backFlag=OPD')" type="button" align="left">
		 <%} %>
		 <%-- <a href="#" onclick="openWindow('/hms/hms/opd?method=viewPreAnesthesiaOPD&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId() %>&token=<%=visit.getTokenNo()%>&backFlag=OPD')">PAC</a></li> --%>
		</td>
	</tr>
<%	i++;  }
	%>
	
</table>
<input type="hidden" name="procCount" value="<%=i %>" id="procCount" />
<%} %>
<!-- added by govind 14-10-2016 end -->
<div class="clear"></div>
<div class="paddingTop40"></div>
<!-- <input name="Submit" type="button" align="right" class="button" value="Save"
	onclick="submitSurgryRequisition();" />
	<input type="reset" class="button" name="reset" value="reset" onclick="submitForm('inpatientSurgeryRequisition','ipd?method=showSurgeryRequisitionJspFromPatientList');"/>

<input type="button" class="button" name="reset" value="Back" onclick="submitForm('inpatientSurgeryRequisition','ipd?method=showPatientListJsp');"/>
 -->
		<div class="clear"></div>

<div class="block">
<%if(otbooking!=null && otbooking.size()>0) {%>
<label>Surgery Date <span>*</span></label>
<label class="value"><%=otbooking.get(0).getSurgeryDate()%></label>
 
 
 <label>Start Time <span>*</span></label>
<label class="value"><%=otbooking.get(0).getSurgeryStartTime() %></label>


<label>End Time <span>*</span></label>
<label class="value"><%=otbooking.get(0).getSurgeryEndTime() %></label>


<div class="clear"></div>
		
	<label>Department<span>*</span></label>
 <label class="value"><%=otbooking.get(0).getDepartment().getDepartmentName() %></label>
<label>OT<span>*</span></label>
<label class="value"><%=otbooking.get(0).getOt().getOtName() %></label>

	
	<label>Table<span>*</span></label>
<label class="value"><%=otbooking.get(0).getBed().getBedNo()%></label>


<%} %>
 </div>
<!-- End Minor OT -->

<div class="Block">




<%-- <table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		 <td><a href="#" onclick="javascript:openPopupProcedureAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)"> Procedure Advice</a></td>
		 <td><a href="javascript:openPopupDetentionAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)"> Detention Advice</a></td>
		 <td><a href="#" onclick="javascript:openPopupPhysiotheraphyAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)">  Physiotherapy Advice</a></td>
</tr>
</table> --%>
<div class="clear"></div>



<%--
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
</select> --%>

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

<!-- <label>Referred to MH</label>
<input type="checkbox" name="referedToMH" class="radio" id="referedToMH" value="" onclick="checkReferToMh();"/>


<div id="mhDiv" style="display: none">
<label>MH Name</label>
<input name="mh" type="text" tabindex="1" maxlength="32" id="mh" size="20"  />

<label>Department</label>
<input name="mhDepartment" type="text" tabindex="1" maxlength="32" id="mhDepartment" size="20"  />
<div class="clear"></div>
<label>Referred For</label>
<input name="mhReferredFor" type="text" tabindex="1" maxlength="50" id="mhReferredFor" size="20"  />
</div> -->
<%-- 
<% //if(visit.getHin().getRelation()!=null && visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self")){%> --%>
<!--  <input class="transparent" size="23">-->


<%

if(admittedVisit!=null && admittedVisit.size() >0) 
{
	String doctorName="";
	if(admittedVisit.get(0).getEmployee().getFirstName()!= null){
		doctorName=admittedVisit.get(0).getEmployee().getFirstName();
	}
	if(admittedVisit.get(0).getEmployee().getMiddleName()!= null){
	patientName=patientName+" "+admittedVisit.get(0).getEmployee().getMiddleName();
	}
	if(admittedVisit.get(0).getEmployee().getLastName()!= null){
		doctorName=patientName+" "+admittedVisit.get(0).getEmployee().getLastName();
	}

%>	
	<span style="color:red; padding-left: 10px;">Patient is already adviced for admission from <%=doctorName%> (<%=admittedVisit.get(0).getDepartment().getDepartmentName() %>)</span>
<%}

else
{
%>

<div id="disposalDiv" style="display: inline">
<label >Additional Advice</label>
<textarea name="presentAdvice" cols="50" rows="0" maxlength="300" 	tabindex="1" onkeyup="return ismaxlength(this)" class="auto"><%=additionalAdvice%></textarea>
<div class="clear"></div>

		<div id="admissionDiv">
						<div class="clear"></div>
				<%-- 		<label class="autoSpace">Transfer to observation ward <%if(opdPatientDetails!=null && opdPatientDetails.getObservationStatus()!=null && opdPatientDetails.getObservationStatus().equalsIgnoreCase("y")) {%>
							<input type="checkbox" checked="checked" class="radioCheckCol2"
							id="observationStatus" name="observationStatus" /> <%}else{ %> <input
							type="checkbox" class="radioCheckCol2" id="observationStatus"
							name="observationStatus" /> <%} %>
						</label> --%>
						 <label>Admission Advised
						<%--   <%if(opdPatientDetails!=null && opdPatientDetails.getAdmissionAdvised()!=null && opdPatientDetails.getAdmissionAdvised().equalsIgnoreCase("y")) {%>
							<input type="checkbox" checked="checked" class="radioCheckCol2"	id="admissionAdvised" name="admissionAdvised" />
							<%}else{ %>
							<input	type="checkbox" class="radioCheckCol2" id="admissionAdvised"	name="admissionAdvised" />
							<%} %> --%>
							
							<input	type="checkbox" class="radioCheckCol2" id="admissionAdvised" name="admissionAdvised" style="margin:1px 5px 0px 0px;" />
						</label>
				
							<div id="admDiv" class="collaps">
							<label>Admission Date</label>
							 <input type="text"	name="admissionDate" id="admissionDate"	style="text-align: left;" class="dateTextSmall"	value="<%=currentDate%>" readonly="readonly" onblur="checkAdmte()" />
							  <img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.opdMain.admissionDate,event);" />
						<!-- 	<label class="autoSpace">Payward

							<input type="checkbox"
								name="payward" id="payward" class="radioCheckCol2" value="Y"
							 />	
							</label> --> <label >Ward</label>
							<select name="admissionWard" id="admissionWard"
								onclick="getBedStatus(this.value);">
								<option value="0">Select</option>
								<%for(MasDepartment ward:wardDepartmentList){ %>
								<option value="<%=ward.getId()%>"><%=ward.getDepartmentName() %></option>
								<%} %>
							</select>
							<div id="bedDiv"></div>
						</div>
			

					</div>
</div>
<%} %>
<div class="clear"></div>
<div id="detentionDiv" style="display: none">
<label> Review at</label> 
<input	type="text" name="reviewAt" size="92" class="auto" id="reviewAtId" validate="Review at,string,no" value="" MAXLENGTH="200"   />
</div>
<div class="clear"></div>
</div>

		<div class="clear"></div>
		<% if(admittedVisit.size() ==0) 
		{ %>
<h4>Referral</h4>

<div class="Block">
      				
					<%  String relationName=""; %>
				
								<div id="referalDiv" >
		
									<label>Referral </label> <select id="referral" name="referral"
										class="midium">
										<option value="0" selected="selected">No</option>
										<option value="1">Yes</option>
									</select>
		
								<div id="referDiv" class="col collaps">
									<label>Refer To</label>
									<!-- <label><input type="checkbox"  name="referBack" id="referBack"  onclick="selectDept('referInternal');"/>ReferBack</label> -->
						<%-- 			<%
									if(opdpatientDetailId !=0)
									{%>
										<label class="autoSpace"><input type="checkbox"
											class="radioCheckCol2" name="referBack" id="referBack"
											value="Internal"
											onclick="selectReferBack('<%out.print(referralDistrict);%>@@@<%out.print(referralHospital);%>@@@<%out.print(referralDept);%>@@@<%out.print(referralType);%>@@@<%out.print(deptNameforExternal);%>');" />ReferBack</label>
										<%
									}
									%> --%>
		
									<label class="autoSpace"><input type="radio"
										class="radioCheckCol2" name="referTo" id="referInternal"
										value="Internal" onclick="checkReferTO('referInternal');" style="margin:1px 5px 0px 0px;" />Internal</label>
									
<% if(visit.getHin().getPatientType()!=null && visit.getHin().getPatientType().getPatientTypeName().equalsIgnoreCase(patientTypeNameForHAL) && visit.getHin().getEmployee()!=null && !visit.getHin().getEmployee().getEmployeeType().getEmployeeTypeCode().equalsIgnoreCase(empTypeCodeForContract))		
{ %>

				<label	class="autoSpace"><input type="radio"
					class="radioCheckCol2" name="referTo" id="referExternal"
					value="Empanel" onclick="checkReferTO('referExternal');"
					style="margin: 1px 5px 0px 0px;" />Empanel</label>
<%} %>
									<div class="clear"></div>
									<label>Refer Date:</label> <input type="text"
										id="referVisitDate" name="referVisitDate" class="date"
										value="<%=currentDate%>"
										readonly="readonly"
										 />
										 <!-- onblur="checkAdmte()" -->
									
									<img  src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.opdMain.referVisitDate,event);" /> 
									 <label id="priorityLabelId">Current Proirity No.</label> <select
										id="priorityId" name="priorityName" tabindex="1">
										<option value="3">3</option>
										<option value="2">2</option>
										<option value="1">1</option>
									</select>
									<div class="clear"></div>
									<%-- <label id="referdistrictLabel">District</label> <select
										id="referdistrict" name="referdistrict"
										onchange="fnGetDistrictHospital();">
										<option value="0">Select</option>
										<%for(MasDistrict district:masDistrictList){%>
										<%if(districtId==district.getId()){ %>
										<option value="<%=district.getId()%>" selected="selected"><%=district.getDistrictName()%></option>
										<%}else{ %>
										<option value="<%=district.getId()%>"><%=district.getDistrictName()%></option>
										<%} %>
										<%}%> 
									
									</select> --%><%--<label id="referHospitalTypeLabel">Hospital Type</label>  <select
										id="referHospitalType" name="referHospitalType"
										onchange="fnGetDistrictHospital();">
										<option value="0">Select</option>
										<%if(hospitalTypeList.size()>0){
										for(MasHospitalType masHospitalType:hospitalTypeList){%>
										<%if(hospitalTypeId==masHospitalType.getId()){ %>
										<option value="<%=masHospitalType.getId()%>" selected="selected"><%=masHospitalType.getHospitalTypeName()%></option>
										<%}else{ %>
										<option value="<%=masHospitalType.getId()%>"><%=masHospitalType.getHospitalTypeName()%></option>
										<%} %>
										<%}}%>
									</select> --%>
									<div class="clear"></div>
		<!-- Babita -->
									<label id="referhospitalLabel" style="display: none;" >Hospital <span>*</span></label> <select
										id="referhospital" name="referhospital"
										onchange="fnGetHospitalDepartment(this.value);" style="display: none;" >
										<option value="0">Select</option>
										<%for(MasImpanneledHospital msih:masImpanneledHospitalList){%>
										<option value="<%=msih.getId()%>"><%=msih.getImpanneledHospitalName()%></option>
										<%}%>
									</select>
									
								  <label id= referdayslLabel style="display: none;">No. of Days</label> <input id="referdays" name="referdays" type="text"
									maxlength="2" style="display: none;" />
									
									<div class="clear"></div>
		
									<label id="referdepartmentLabel" >Department <span>*</span></label> <select
										id="referdepartment" name="referdepartment"
										onchange="fnGetDoctorDepartment(this.value,'refereddoctor');">
										<option value="0">Select</option>
										<%for(MasDepartment dep:deptList){
										%>
										<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
								<%-- 		<%if(deptId==dep.getId()) {%>
										<option value="<%=dep.getId()%>" selected="selected"><%=dep.getDepartmentName()%></option>
										<%}else{ %>
										<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
										<%} %> --%>
										<%}%>
									</select> <label id ="refereddoctorlabel">Doctor  <span>*</span></label> <select id="refereddoctor"
										name="refereddoctor">
										<option value="0">Select</option>
									</select>
		
		
									<div class="clear"></div>
									<label style="display:none">Patient Advise</label>
									<textarea name="patientAdvise" validate="patientAdvise,string,no"
										id="patientAdvise" cols="0" rows="0" maxlength="500"
										tabindex="5" onkeyup="return checkLength(this)" style="display:none"></textarea>
									<!-- <input type="button" class="buttonAuto-buttn" value="+"
										onclick="" /> --> 
										<label id="referral_treatment_type_label" >Treatment Type <span>*</span></label> 
									<select	id="referral_treatment_type" name="referral_treatment_type">										
										<option value="1" selected="true">Review</option>
										<option value="2">Admission</option>
									</select>
									<label>Referral Notes</label>
									<textarea name="referralNote" validate="referralNote,string,no"
										id="referralNote" cols="0" rows="0" maxlength="500" tabindex="5"
										onkeyup="return checkLength(this)"></textarea>
									<!-- <input type="button" class="buttonAuto-buttn" value="+"
										onclick="" /> -->
								</div>
								<input type="hidden" name="userName" value="<%=userName %>" />
						<%-- 		<%
									if(visit.getHin().getRelation() != null){
							    	 relationName=visit.getHin().getRelation().getRelationName();
								if(visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self")){
								%>
								<label>No. of Days</label> <input name="days" type="text"
									maxlength="1" />
								<%}} %> --%>
							</div>
				
					<div class="clear"></div>
</div>
<%} %>
<script>
	function checkReferToMh (){
	 if(document.getElementById('referedToMH').checked == true){
		 document.getElementById('mhDiv').style.display = 'block'
			 document.getElementById('disposalDiv').style.display = 'none'
	 }else{
		 document.getElementById('mhDiv').style.display = 'none'
		  document.getElementById('disposalDiv').style.display = 'inline'	
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

function validateNip(){
	var count = document.getElementById('hdb').value;
	for(var i = 1; i <= count;i++){
		//var nomenclature = document.getElementById('nomenclature'+i).value;
		if(document.getElementById('otherMedicine'+i)){
		if(document.getElementById('otherMedicine'+i).value != ''){
			if(document.getElementById('itemClass'+i)){
			if(document.getElementById('itemClass'+i).value == '0'){
				alert('Please select class for Medicine '+i);
				return false;
			  }
			 }
			

             if(document.getElementById('itemConversionId'+i)){
			if(document.getElementById('itemConversionId'+i).value == '0'){
				alert('Please select Au for Medicine '+i);
				return false;
			 }
			}
		
			//var noOfDays = document.getElementById('noOfDays'+i).value;
	
			if(document.getElementById('dispensingUnit'+i)){
			if(document.getElementById('dispensingUnit'+i).value == '0'){
				alert('Please select Dispensing Unit for Medicine '+i);
				return false;
			 }
			 }
		}
	 }
	}
	return true;
	
}
function displayDetained(){
	if(document.getElementById('disposal')){
		 var disposal = document.getElementById('disposal').value;
		 if(disposal == 'Detained'){
			 document.getElementById('detentionDiv').style.display = 'block';
		 }else{
			 document.getElementById('detentionDiv').style.display = 'none';
		 }

	}
}


</script>
<!-- <input type="text" name="nextVisitDate"  class="calDate"/>
		<a href="#"><img src="images/cal.gif" alt="Calender" border="0" /></a>
		 -->
<div class="clear"></div>

<input id="visitId" name="visitId" type="hidden"	value="<%=visit.getId()%>" />
<input id="visitId1" name="<%=VISIT_ID %>" type="hidden"	value="<%=visit.getId()%>" />
<input name="hinId" type="hidden"	value="<%=visit.getHin().getId()%>" />
<input name="departmentId"	type="hidden" value="<%=visit.getDepartment().getId()%>" />
<input	name="hospitalId" type="hidden" id="hospitalId" value="<%=hospitalId%>"  />
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
<input
			name="opdpatientDetailId" type="hidden"
			value="<%=opdpatientDetailId%>" />
			<input name="pHeaderId"
			type="hidden" value="<%=pHeaderId%>" />
			<input name="dgOrderHdId"
			type="hidden" value="<%=dgOrderHdId%>" />
			
			
<%
	String orderSeqNo="";
	if(mapForDS.get("orderSeqNo") != null){
		orderSeqNo = (String)mapForDS.get("orderSeqNo");
	}
%>
<input name="<%=ORDER_NO %>" type="hidden" value="<%=orderSeqNo %>" />
<input name="physioRequisitionHeaderId" id="physioRequisitionHeaderId" type="hidden" value="0" />
<input name="procedureHeaderId" id="procedureHeaderId" type="hidden" value="0" />
<div class="clear"></div>
<div class="division"></div>
<input name="Submit11" type="button"	tabindex="1" align="right" class="button" value="Submit" onclick="submitOPDMainForm();" />
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
		newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=1");
	    		
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

<%-- 	function addRow(){
		  var tbl = document.getElementById('grid');
		 
		  var lastRow = tbl.rows.length;
		
		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('hdb');
		  var iteration = parseInt(hdb.value)+1;
		  hdb.value=iteration
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
		   								disableOtherMedicine(this.value,iteration);
							     return;
							    }
							    else
		      						document.getElementById('pvmsNo'+iteration).value=pvmsNo
		      						checkItem(iteration);disableOtherMedicine(this.value,iteration);checkForAlreadyIssuedPrescription(this.value,iteration);displayAu(this.value,iteration,'<%= hinId%>');
							   }
		                       else
								    {
								    		document.getElementById('nomenclature'+iteration).value="";
			   								document.getElementById('pvmsNo'+iteration).value="";
			   								disableOtherMedicine(this.value,iteration);
								     return;
								    }
		                       
		  					  };
		  
		var newdiv = document.createElement('div');
	        	//newdiv.setAttribute('id', 'ac2update'+iteration);
	        	//newdiv.setAttribute('class', 'autocomplete');
	       	    newdiv.id='ac2update'+iteration;
	       	    newdiv.className='autocomplete';
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
		    var cellRight1 = row.insertCell(1);
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
		  cellRight1.appendChild(eImg);
		//  alert("5---");
		
		 var cellRight1 = row.insertCell(1);
		  var e11 = document.createElement('input');
		  e11.type = 'text';
		  e11.name='otherMedicine'+iteration;
		  e11.id='otherMedicine'+iteration
		  e11.size='20';
		  e11.setAttribute('tabindex','1');
		  e11.onblur=function(){if(this.value!=''){checkDuplicateOtherMedicine(this.value,iteration);readOnlyNomenclature(this.value,iteration);showSimilarMedicineNames(this.value)}
		  else{readOnlyNomenclature(this.value,iteration);} };
		  cellRight1.appendChild(e11);

		   var cellRight2 = row.insertCell(2);
		  var e12 = document.createElement('Select');
		  e12.name='itemClass'+iteration;
		  e12.id='itemClass'+iteration;
		  e12.className='medium';
		  //e2.class = 'medium';
		  e12.setAttribute('tabindex','1');
		  e12.options[0] = new Option('Select', '0');
		   for(var i = 0;i<itemClassArray.length;i++ ){
		      e12.options[i+1] = new Option(itemClassArray[i][1],itemClassArray[i][0]);
		      }
		  cellRight2.appendChild(e12); 

		  //itemClassArray
		  
		   var cellRight14 = row.insertCell(3);
		  var e12 = document.createElement('Select');
		  e12.name='itemConversionId'+iteration;
		  e12.id='itemConversionId'+iteration;
		  e12.className='medium';
		  //e2.class = 'medium';
		  e12.setAttribute('tabindex','1');
		  e12.options[0] = new Option('Select', '0');
		   for(var i = 0;i<unitArray.length;i++ ){
		      e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][0]);
		      }
		  cellRight14.appendChild(e12); 
		  
		   var cellRight15 = row.insertCell(4);
			  var e12 = document.createElement('Select');
			  e12.name='dispensingUnit'+iteration;
			  e12.id='dispensingUnit'+iteration;
			  e12.className='medium';
			  //e2.class = 'medium';
			  e12.setAttribute('tabindex','1');
			  e12.options[0] = new Option('Select', '0');
			   for(var i = 0;i<unitArray.length;i++ ){
			      e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][1]);
			      }
			  cellRight15.appendChild(e12); 
		  

		  
		 // var cellRight3 = row.insertCell(4);
		  var e1 = document.createElement('input');
		  e1.type = 'hidden';
		  e1.name='actualDispensingQty'+iteration;
		  e1.id='actualDispensingQty'+iteration
		  e1.size='6';
		  e1.setAttribute('tabindex','1');
		 
		  
		  var e15 = document.createElement('input');
		  e15.type = 'hidden';
		  e15.name='highValueMedicine'+iteration;
		  e15.id='highValueMedicine'+iteration
		  e15.size='1';
		  e15.setAttribute('tabindex','1');
		  cellRight15.appendChild(e15);
		  //end
		  var e13 = document.createElement('input');
		  e13.type = 'hidden';
		  e13.name='au'+iteration;
		  e13.id='au'+iteration
		  e13.size='6';
		  e13.setAttribute('tabindex','1');
		  //e12.onblur=function(){displayAU(this.value,iteration)};
		  cellRight15.appendChild(e13);

		 
		  cellRight15.appendChild(e1);
		  
		  
		 /* var cellRight3 = row.insertCell(4);
		  var e31 = document.createElement('input');
		  e31.type = 'checkbox';
		  e31.name='injCategory'+iteration;
		  e31.id='injCategory'+iteration
		  e31.size='10';
		  e31.className='radio';
		  e31.value='y';
		  e31.setAttribute('tabindex','1');
		  cellRight3.appendChild(e31);*/

		  var cellRight4 = row.insertCell(5);
		  var e14 = document.createElement('input');
		  e14.type = 'text';
		  e14.name='dosage'+iteration;
		  e14.id='dosage'+iteration
		  e14.size='5';
		  e14.setAttribute('maxlength', 5); 
		  e14.setAttribute('tabindex','1');
		  e14.onblur = function(){checkDosageValidation(this.value,iteration);fillValue(iteration)};
		  cellRight4.appendChild(e14);
		  
		  

		  var sel = document.createElement('input');
		  sel.type = 'hidden';
		  sel.name='pvmsNo'+iteration;
		  sel.id='pvmsNo'+iteration
		  sel.size = '10';
		  sel.setAttribute('tabindex','1');
		  cellRight4.appendChild(sel);
		
		 
		//  var cellRightSel = row.insertCell(2);
		 
		  var cellRight5 = row.insertCell(6);
		  var e2 = document.createElement('Select');
		  e2.name='frequency'+iteration;
		  e2.id='frequency'+iteration;
		  e2.className='medium';
		  //e2.class = 'medium';
		  e2.setAttribute('tabindex','1');
		  e2.options[0] = new Option('Select', '0');
		  e2.onblur=function(){getFrequencyValue(this.value,iteration);fillValueFromFrequency(this.value,iteration);displaySOSQty(this.value,iteration);fillValue(iteration)};
		   for(var i = 0;i<icdArray.length;i++ ){
		      e2.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
		      }
		  cellRight5.appendChild(e2);
		  var e52 = document.createElement('input');
			e52.type = 'text';
			e52.name='sosQty'+iteration;
			e52.id='sosQty'+iteration;
			e52.tabIndex='1';
			e52.size='3';
			e52.style.display='none';
			e52.setAttribute('maxlength', 3); 
		    e52.onblur=function(){fillValue(iteration)};
			cellRight5.appendChild(e52);

		  var e21 = document.createElement('input');
		  e21.type = 'hidden';
		  e21.name='frequencyValue'+iteration;
		  e21.id='frequencyValue'+iteration;
		  e21.size='5';
		  e21.setAttribute('tabindex','1');
		  cellRight5.appendChild(e21);
		  	  
		  var cellRight6 = row.insertCell(7);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name='noOfDays'+iteration;
		  e4.id='noOfDays'+iteration;
		  e4.size='3';
		  e4.setAttribute('maxlength', 3); 
		  e4.setAttribute('tabindex','1');
		  e4.setAttribute('validate','No. of Days,int,no');
		  e4.onblur=function(){fillValue(iteration)};
		  cellRight6.appendChild(e4);

		  
			var cellRight16 = row.insertCell(8);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.name='total'+iteration;
		  e5.id='total'+iteration;
		  e5.size='5';
		  e5.setAttribute('tabindex','1');
		  cellRight16.appendChild(e5);

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

		//	var cellRight7 = row.insertCell(7);
			
			

			var cellRight8 = row.insertCell(9);
			var e6 = document.createElement('input');
			e6.type = 'text';
			e6.name='route'+iteration;
			e6.id='route'+iteration
			e6.size='5';
			e6.value=''
			e6.setAttribute('maxlength', 20); 
			e6.setAttribute('tabindex','1');
			cellRight8.appendChild(e6);

		  var cellRight9 = row.insertCell(10);
		  var e7 = document.createElement('input');
		  e7.type = 'text';
		  e7.name='remarks'+iteration;
		  e7.id='remarks'+iteration
		  e7.size='10';
		  e7.setAttribute('maxlength', 40); 
		  e7.setAttribute('tabindex','1');
		  cellRight9.appendChild(e7);

	/* 	  var cellRight10 = row.insertCell(9);
		  var e71 = document.createElement('input');
		  e71.type = 'checkbox';
		  e71.name='ct'+iteration;
		  e71.id='ct'+iteration
		  e71.size='10';
		  e71.className='radio';
		  e71.value='y';
		  e71.setAttribute('tabindex','1');
		  cellRight10.appendChild(e71); */

		  var cellRight11 = row.insertCell(11);
		  var e72 = document.createElement('input');
		  e72.type = 'text';
		  e72.name='closingStock'+iteration;
		  e72.id='closingStock'+iteration
		  e72.size='3';
		  e72.setAttribute('tabindex','1');
		  cellRight11.appendChild(e72);

		  var cellRight12 = row.insertCell(12);
		  var e8 = document.createElement('input');
		  e8.type = 'button';
		  e8.className = 'button';
		  e8.value = "Add";
		  e8.name='remarks'+iteration;
		 // e8.setAttribute('onClick', 'addRow();'); 
		  e8.onclick = function(){addRow();}; 
		  e8.setAttribute('tabindex','1');
		  cellRight12.appendChild(e8);

		  var cellRight13 = row.insertCell(13);
		  var e9 = document.createElement('input');
		  e9.type = 'button';
		  e9.className = 'button';
		  e9.value = "Delete";
		  e9.name='remarks'+iteration;
		  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
		  e9.onclick = function(){removeRow("grid","hdb",this);};  
		  e9.setAttribute('tabindex','1');
		  cellRight13.appendChild(e9);

		 
		  
		   //added - fayaz
		//  var cellRight9 = row.insertCell(9);
	   //   var e9 = document.createElement('input');
	 //     e9.id = 'a'
	 //     e9.type = 'checkbox';
	  //    cellRight9.appendChild(e9);

		} --%>

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
	//  alert(lastRow + " "+obj.parentNode.parentNode.rowIndex);
	  if (lastRow > 0){
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
	

	function disableOtherMedicine(val,inc){
		  if(val != "")
			{
		   document.getElementById('otherMedicine'+inc).disabled = true;
		   document.getElementById('otherMedicine'+inc).value ="";
		   document.getElementById('total'+inc).readOnly  = true;
		   document.getElementById('itemConversionId'+inc).disabled = true;
		   document.getElementById('itemConversionId'+inc).value = "0";
		   document.getElementById('itemClass'+inc).disabled = true;
		   document.getElementById('itemClass'+inc).value = "0";
		   document.getElementById('dispensingUnit'+inc).disabled = true;
		   document.getElementById('dispensingUnit'+inc).value = "0";
		   //document.getElementById('injCategory'+inc).disabled = true;	
		   
			}else{
				document.getElementById('otherMedicine'+inc).disabled = false;
				document.getElementById('itemConversionId'+inc).disabled = false;
				document.getElementById('itemClass'+inc).disabled = false;
				document.getElementById('dispensingUnit'+inc).disabled = false;
				document.getElementById('total'+inc).readOnly  = false;
				//document.getElementById('injCategory'+inc).disabled = false;	

			}
		}
	function readOnlyNomenclature(val,inc){
	if(val != ""){
		//alert("Please confirm PVMS/NIV is not available");
		 document.getElementById('nomenclature'+inc).readOnly = true;
		 document.getElementById('au'+inc).readOnly = true;				
	     document.getElementById('nomenclature'+inc).value ="";
	     if(document.getElementById('itemId'+inc)){
	    	 document.getElementById('pvmsNo'+inc).value = "";
	     }
	  }else{
		document.getElementById('nomenclature'+inc).readOnly = false;
		 document.getElementById('au'+inc).readOnly = false;			

	  }
   }

	function displaySOSQty(val,inc){
		
	if(val == '13'){
		document.getElementById('sosQty'+inc).style.display = 'block';
		document.getElementById('noOfDays'+inc).disabled = true;
	 }else{
	
	 document.getElementById('sosQty'+inc).style.display  = 'none';
	  document.getElementById('noOfDays'+inc).disabled = false;
	 }
	}
	
	function getFrequencyValue(feqValue,inc){
		var feqQty;
	<%
	if(frequencyList.size()>0){	
		for(MasFrequency masFrequency :frequencyList){
	%>
	 if(feqValue == '<%=masFrequency.getId()%>'){
		 feqQty = '<%=masFrequency.getFeq()%>'
		
	  }

	<%}
	}%>
	 document.getElementById('frequencyValue'+inc).value = feqQty;
	}
	
	 function fillValue(inc){
	  
	  
      var noOfDays = document.getElementById('noOfDays'+inc).value 
	  var dosage = document.getElementById('dosage'+inc).value
	  var freq=document.getElementById('frequencyValue'+inc).value
	  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
	  var sosQty = document.getElementById('sosQty'+inc).value;
	  var total = freq*noOfDays*dosage;
	  
	  var finalQty;
	  
	  if(document.getElementById('frequency'+inc).value != 13 ){
	  if(document.getElementById('actualDispensingQty'+inc).value != 0){
		  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
		//  alert(totalQty);
		  if(totalQty != '0.00'){
			  finalQty = Math.ceil(totalQty);
		  }
		  else
			  {
			 	 finalQty = 1;
			  }
		  
		  document.getElementById('total'+inc).value=finalQty;
		 }else{
			  document.getElementById('total'+inc).value=freq*noOfDays*dosage
		  }
	 //	document.getElementById('noOfDays'+inc).disabled = false;
	// 	document.getElementById('sosQty'+inc).disabled = true;
	  }else{
		  if(document.getElementById('actualDispensingQty'+inc).value != 0){
			  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
			  if(totalQty != '0.00'){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('total'+inc).value=finalQty;
			 }else{
				  document.getElementById('total'+inc).value=freq*sosQty*dosage
			  }
	//	   document.getElementById('noOfDays'+inc).disabled = true;
	//	   document.getElementById('sosQty'+inc).disabled = false;

	  }
	  
	 }

	 function  fillValueFromFrequency(value,inc){
   	  var dosage = document.getElementById('dosage'+inc).value
	  var noOfDays=document.getElementById('noOfDays'+inc).value
	  var freq=document.getElementById('frequencyValue'+inc).value
	  document.getElementById('total'+inc).value=noOfDays*freq*dosage
	  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
   	  var sosQty = document.getElementById('sosQty'+inc).value;
	  var total = freq*noOfDays*dosage;
	  var finalQty;
	  if(document.getElementById('frequency'+inc).value != 13 ){
	  if(document.getElementById('actualDispensingQty'+inc).value != 0){
		  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
		  if(totalQty != '0.00'){
			  finalQty = Math.ceil(totalQty);
		  }
		  document.getElementById('total'+inc).value=finalQty;
	
		 }else{
			 
			  document.getElementById('total'+inc).value=noOfDays*freq*dosage
		  }
	 // document.getElementById('noOfDays'+inc).readOnly = false;
	 // document.getElementById('sosQty'+inc).readOnly = true;
	  }else{
		  if(document.getElementById('actualDispensingQty'+inc).value != 0){
			  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
			  if(totalQty != '0.00'){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('total'+inc).value=finalQty;
		
			 }else{
				  document.getElementById('total'+inc).value=sosQty*freq*dosage
			  }
		//  alert(document.getElementById('noOfDays'+inc).readOnly);
		 // document.getElementById('noOfDays'+inc).readOnly = true;
		 // document.getElementById('sosQty'+inc).readOnly = false;
	  }
	 }

	
</script> 
<script type="text/javascript">
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

		
        document.opdMain.action="hms/hms/opd?method=submitRecallOpdPatientDetails";
        document.opdMain.submit();
        document.opdMain.action="opd?method=showEntJsp&visitId=<%=visit.getId() %>"
        document.opdMain.submit();
		

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
		submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
	}else if(val=='treatmentDiv'){
		submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
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

			submitProtoAjax('opdMain','/hms/hms/opd?method=showGridInMainJsp','testDiv');
		}
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
submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=showGridForInvestigation&investigationTemplateId='+invId,'gridview');
				
				}
	//}
	
	
	function validatePregnancy(){
		if(document.getElementById("pregnancy")!=null && document.getElementById("pregnancy").checked && document.getElementById('lmp_date').value=="" && document.getElementById('edd').value=="")
		{
		  alert("LMP and EDD cannot be blank if patient is pregnant")	
		  return false;
		}
		return true;
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
				
	
	             if(document.getElementById('dosage'+i)){
				if(document.getElementById('dosage'+i).value == ''){
					alert('Please Enter dosage.');
					return false;
				 }
				}
			
				//var noOfDays = document.getElementById('noOfDays'+i).value;
				if(document.getElementById('frequency'+i).value != '13'){
				if(document.getElementById('noOfDays'+i)){
				if(document.getElementById('noOfDays'+i).value == ''){
					alert('Please Enter No. of Days.');
					return false;
				 }
				 }
				}else{
					if(document.getElementById('sosQty'+i)){
						if(document.getElementById('sosQty'+i).value == ''){
							alert('Please Enter SOS Qty.');
							return false;
						 }
						 }
				}
				if(document.getElementById('noOfDays'+i)){
				if(document.getElementById('noOfDays'+i).value!="")
				{
				if( isNaN(document.getElementById('noOfDays'+i).value))
		    	{
					document.getElementById('noOfDays'+i).value =""; //Babita
		        	alert("No. of Days should be a number");
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

	function validateReferal()
	{
		var returnValue = true;
	  
		if(document.getElementById('referral')==null)
			return returnValue;
		
		var referral = document.getElementById('referral').value;
		if(referral =='1')
	       {		
			 if(document.getElementById('referInternal').checked)
				 {  
				  var refDoc = document.getElementById('refereddoctor').value;
				    if(refDoc==0 )
				    	{
				    	 alert("Please select Doctor");
				    	 returnValue = false;
				    	} 
				    	 
				 }
			 else if(document.getElementById('referExternal').checked)	 
				 {
				    var refHosp = document.getElementById('referhospital').value;
				    if(refHosp==0 )
				    	{
				    	 alert("Please select hospital");
				    	 returnValue = false;
				    	} 
				 }
	       }
		
		return returnValue;
	}

	
	
	function validateAdmission()
	{
		if(document.getElementById('admissionAdvised') &&  document.getElementById('admissionAdvised').checked)
			{
			
			  var admissionWard = document.getElementById('admissionWard').value;
			  if(admissionWard==0)
			   {alert("Select admission ward.");
			   return false;
			   }
			}
		return true;
	}

//end	

	function submitOPDMainForm(){
	//	if(validateFieldValuesForMainSubmit()){
	
	//var referedToMH =document.getElementById('referedToMH').value;
	if(confirm("Do You want to submit the Record!?")){
/* 	 if(document.getElementById('referedToMH').checked == true){
			if(validateFrequency() && validateDays()){
				//submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=responseForDoctarsList&referredDepartmentId='+indexes+'','referredDoctarsIdDiv');
				
				submitForm('opdMain','opd?method=submitRecallOpdPatientDetails&referedToMH=y&flag=opd');
		}
	 } */
	 
		 if( validatePregnancy()&& validateFrequency() && validateDays()  &&  validateNip() && validateProcedure() && validateReferal() && validateAdmission()  ){
				//submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=responseForDoctarsList&referredDepartmentId='+indexes+'','referredDoctarsIdDiv');
				var str=document.getElementById("presentComplain").value.replace(/(\n)/g, ',');
		        document.getElementById("presentComplain").value=str.substring(0, str.length - 1);
				str=document.getElementById("familyHistory").value.replace(/(\n)/g, ',');
		        document.getElementById("familyHistory").value=str.substring(0, str.length - 1);
				submitForm('opdMain','opd?method=submitRecallOpdPatientDetails&referedToMH=n&flag=opd');
		}
	
		return true;
	}else{
		return false;
	}
	 
	}
	function deleteDgItems(value){
     if(document.getElementById('diagnosisId').selectedIndex!=0){
	 if(confirm("are you sure want to delete ?")){

 	 		document.getElementById('diagnosisId').remove(document.getElementById('diagnosisId').selectedIndex);

	    }
	   }
     }
    function showTreatment()
    {
    	
    		   	var url="/hms/hms/opd?method=showTreatmentPopUp&flag=opd";
    		    newwindow=window.open(url,'treatment',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
    		  
    }
   
    function showSymptom()
    {
    		 	var url="/hms/hms/opd?method=showSymptomPopUp";
    		    newwindow=window.open(url,'Symptom',"left=2,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=1");
    		  
    }
    function showDiagnosis()
    {
    		   	var url="/hms/hms/opd?method=showDiagnosisPopUp";
    		   newwindow=window.open(url,'Diagnosis',"left=0,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=1");
    		  
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
          /* curr = new Date(serverdate);
           dob = new Date(val);
           */
           curr = new Date()
         	dob = new Date(val.substring(6),(val.substring(3,5) - 1) ,val.substring(0,2));
           
                if(dob>curr)
                 {
                  alert("Date should be less or Equal Current Date "+serverdate+".");
                  document.getElementById(Id).value="";
                  return false;
                 }
    }
    
    if(Id=="dod")
    {  
      var doa=document.getElementById('doa').value;
    /*  curr1 = new Date(doa);
       dob1 = new Date(val);*/
       if(doa!=''){
	       curr1 = new Date(doa.substring(6),(doa.substring(3,5) - 1) ,doa.substring(0,2))
	       dob1 = new Date(val.substring(6),(val.substring(3,5) - 1) ,val.substring(0,2));
	       if(curr1>dob1)
	       {
	                // alert("DOA can not be gretter than DOD.");
	                 document.getElementById(Id).value="";
	                 return false;
	       }
       }
      
    }
     if(Id=="doa")
     {
                
          var dod=document.getElementById('dod').value;
      /*    curr1 = new Date(passportExpiryDate);
       dob1 = new Date(val); */
		if(dod!=''){
	       curr1 = new Date(dod.substring(6),(dod.substring(3,5) - 1) ,dod.substring(0,2))
	   	   dob1 = new Date(val.substring(6),(val.substring(3,5) - 1) ,val.substring(0,2));
	       if(dob1 > curr1 && curr1 !="")
	       {
	                 alert("DOA can not be gretter than DOD.");
	                 document.getElementById(Id).value="";
	                 return false;
	       }
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
        
   
        function openOtherField(familyHistoryId){
        /*	if(familyHistoryId == '8'){
        		document.getElementById('otherFamilyHistoryDiv').style.display = 'block';
        	}else{
        	//	document.getElementById('familyHistoryId').style.display = 'none';
        	}*/
        	sel = document.getElementById('familyHistory');
        	
        	var listLength = sel.options.length;
        	var fhId="";
        	
        	for(var i=0;i<listLength;i++){
        	   if(sel.options[i].selected){
        		   fhId=sel.options[i].value;
        			if(fhId=='8'){
       					document.getElementById('otherFamilyHistoryDiv').style.display = 'block';
        			
        			}
        			
        	   }
        	}
        	
        }

        function showSimilarMedicineNames(otherDrug){
        	newwindow=window.open('/hms/hms/opd?method=showRelatedMedicineNames&otherDrug='+otherDrug,'name',"left=2,top=100,height=300,width=800,status=1,scrollbars=1,resizable=0");
        }
        
        function addSurgicalRequRow() {

        	var tbl = document.getElementById('surgicalGrid');
        	//var hdbTabIndex = parseInt(document.getElementById('usghdbTabIndex').value) + 1;
        	//document.getElementById('usghdbTabIndex').value = hdbTabIndex;

        	var lastRow = tbl.rows.length;

        	// if there's no header row in the table, then iteration = lastRow + 1
        	var iteration = lastRow;
        	var row = tbl.insertRow(lastRow);
        	var hdb = document.getElementById('procCount');
        	iteration = parseInt(hdb.value) + 1;
        	hdb.value = iteration;
        	// document.getElementById('pulse').value=hdb.value;

        	var cellRight1 = row.insertCell(0);
        	cellRight1.innerHTML=iteration;

/*         	var cellRight1 = row.insertCell(1);
        	cellRight1.innerHTML=document.getElementById('admisDate').value;
        	
        	var cellRight1 = row.insertCell(2);
        	cellRight1.innerHTML=document.getElementById('UHID').value;
        	
        	var cellRight1 = row.insertCell(3);
        	cellRight1.innerHTML=document.getElementById('patName').value;
        	
        	var cellRight1 = row.insertCell(4);
        	cellRight1.innerHTML=document.getElementById('IPNo').value;	
        	
        	var cellRight1 = row.insertCell(5);
        	cellRight1.innerHTML=document.getElementById('deptName').value;	 */
        	
        	/* var cellRight1 = row.insertCell(6);
        	cellRight1.innerHTML=""; */
        	
        	var cellRight1 = row.insertCell(1);
        	var e1 = document.createElement('input');
        	var e2 = document.createElement('input');
        	e1.type = 'text';
        	e2.type = 'hidden';
        	e1.name = 'proscedureName' + iteration;
        	e1.id = 'proscedureName' + iteration;
        	e1.className = "opdTextBoxSmall textYellow";
        	
        	/* e1.onkeypress = function(event) {
        		selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'proscedureName'+iteration);
        	}; */
        	
        	e1.onblur = function(event) {
        		checkMappedChargeIP(this.value,iteration);getProcedureId(this.value,iteration);getSurgeryDiv(iteration);
        	};
        	 var newdiv1 = document.createElement('div');
        	  newdiv1.id='ac2update2'+iteration;
        	  newdiv1.className = 'autocomplete';
        	  newdiv1.style.display = 'none';
        	  
        	  cellRight1.appendChild(e1);
        		cellRight1.appendChild(newdiv1);
        	  
        	  new Ajax.Autocompleter('proscedureName'+iteration,'ac2update2'+iteration,'ipd?method=checkMappedCharge',{minChars:1,
        		  callback: function(element, entry) {
        	            return entry + '&chargeName=' + document.getElementById('proscedureName'+iteration).value
        	            +'&surgeryCheck=' + document.getElementById('surgeryCategory').value ;
        	        },parameters:'requiredField=proscedureName'+iteration});	 

        	
        	e2.name = 'procedureId' + iteration;
        	e2.id = 'procedureId' + iteration;
        	cellRight1.appendChild(e2);

        	var e3 = document.createElement('input');
        	e3.type = 'hidden';
        	e3.name = 'surgeryType' + iteration;
        	e3.id = 'surgeryType' + iteration;
        	e3.value='';
          	cellRight1.appendChild(e3);
        	
        	var cellRight1 = row.insertCell(2);
        	var e1 = document.createElement('select');
        	/* e1.options[0] = new Option('Select', '0'); */
        	e1.options[0] = new Option('Pending', 'Pending');
        	/* e1.options[2] = new Option('Clear', 'Cleared');
        	e1.options[3] = new Option('Not Fit', 'Not Fit'); */
        	e1.name = 'pacstatus' + iteration;
        	e1.id = 'pacstatus' + iteration;
        	cellRight1.appendChild(e1);

        	var cellRight1 = row.insertCell(3);
        	var e1 = document.createElement('input');
        	e1.type = 'checkbox';
        	e1.name = 'surgeryradio' + iteration;
        	e1.id = 'surgeryradio' + iteration;
        	e1.className = 'smalll';
        	
        
        	
       /*  	var e3 = document.createElement('input');
        	e3.type = 'hidden';
        	e3.name = 'hinId' + iteration;
        	e3.id = 'hinId' + iteration;
        	e3.value=document.getElementById('hinId').value; */
        	cellRight1.appendChild(e1);
        	cellRight1.appendChild(e2);
     /*    	cellRight1.appendChild(e3);	 */
        	
        }


        function removeSurgicalRow(form) {
        	var tbl = document.getElementById(form);
        	var lastRow = tbl.rows.length;
        	var hdb;
        	var radio = "";
        	if (form == 'surgicalGrid') {
        		hdb = document.getElementById('procCount');
        		radio = "surgeryradio";
        	}
        	

        	var iteration = parseInt(hdb.value);
        	var totalSelected = 0;
        	if (confirm("Do you want to delete !")) {
        		for (var i = 0; i <= iteration; i++) {
        			if (document.getElementById(radio + i) != null
        					&& (typeof document.getElementById(radio + i).checked) != 'undefined'
        					&& document.getElementById(radio + i).checked) {
        				totalSelected = totalSelected + 1;
        			}
        		}

        		if (totalSelected == 0) {
        			alert('Please select atleast 1 row to delete');
        		}
        		/*
        		 * else if(lastRow==2 || lastRow==(totalSelected+1)) { alert('You can
        		 * not delete all Row.'); } else if (lastRow > 2){
        		 */
        		for (var i = 0; i <= iteration; i++) {
        			if (document.getElementById(radio + i) != null
        					&& (typeof document.getElementById(radio + i).checked) != 'undefined'
        					&& document.getElementById(radio + i).checked) {
        				var deleteRow = document.getElementById(radio + i).parentNode.parentNode;
        				document.getElementById(radio + i).parentNode.parentNode.parentNode
        						.removeChild(deleteRow);
        			}
        		}

        	}
        }
        
        	
    function checkMappedChargeIP(val, count) {
        	
        	var index1 = val.lastIndexOf("[");
        	var index2 = val.lastIndexOf("]");
        	index1++;
        	
        	var id = val.substring(index1, index2);
        	if (id == "") {
        		
        			document.getElementById('proscedureName' + count).value = "";
        			
        		
        	}
        	
        		if (val != "") {				
        					
        					document.getElementById("procedureId" + count).value = id;
        								for (var xx = 1; xx <count; xx++) {
        								 if(document.getElementById("pacstatus" + xx)!=null && document.getElementById("pacstatus" + xx).value =='Pending')
        									 {
        									if (document.getElementById("procedureId" + count)!=null && document.getElementById("procedureId" + count).value == document.getElementById("procedureId" + xx).value)
        									{
        										document.getElementById("procedureId" + count).value = "";
        										document.getElementById("proscedureName" + count).value = "";
        										alert("charge already taken");
        										break;
        									}
        								}
        								}
        							
        } 
        		
        }
    
    
    function getProcedureId(val,inc){
    	if(val!=''){
    		var index1 = val.indexOf("[");
    		var index2 = val.indexOf("]");
    		index1++;
    		var procName = val.substring(0,index1-1);
    		var procId = val.substring(index1,index2);
    		
    		var index1 = val.lastIndexOf("[");
    		var index2 = val.lastIndexOf("]");
    		index1++;
    		var procCode = val.substring(index1,index2);
    		document.getElementById('proscedureName'+inc).value=procName;
    		document.getElementById('procedureId'+inc).value = procId;
    		//document.getElementById('procedurecode'+inc).value = procCode;
    		
    		
    	}else{
    		if(document.getElementById('proscedureName'+inc)){
    	      	document.getElementById('proscedureName'+inc).value="";
    	      	document.getElementById('procedureId'+inc).value="";
    	    	//document.getElementById('proDtId'+inc).value="";
    	      //	document.getElementById('procRemarks'+inc).value="";
    	      	//document.getElementById('procedurecode'+inc).value="";
    			}
    	}
    	
    }
        
  	
    function getSurgeryDiv(count) {
        
     	//console.log(count);
     	 	var select = document.getElementById("pacstatus"+count);
         	var option = document.createElement('option');
        if(document.getElementById('minorSurgery').checked)
        	{
        	 document.getElementById('pacstatus'+count).innerHTML = "";
         	 option.text = option.value = "completed";
         	 select.add(option, 0);
         	document.getElementById('surgeryType'+count).value = "minor";
        	}
        else
    	{
       	 document.getElementById('pacstatus'+count).innerHTML = "";
        	 option.text = option.value = "pending";
        	 select.add(option, 0);
          	document.getElementById('surgeryType'+count).value = "major";
       	}
        	
        schedulingDiv(count);
        
        }
    
    
    function schedulingDiv(count){
    	
    	for (var xx = 1; xx <count; xx++) {
			 if(document.getElementById("surgeryType" + xx)!=null && document.getElementById("surgeryType" + xx).value =='minor')
				 {
				  document.getElementById("procedureId" + count) = "";
					document.getElementById("minorOTSchedulingDiv").style.display='block';
				    return true;
			     }
			}
    	
    	document.getElementById("minorOTSchedulingDiv").style.display='none';
	    return false;
    }
</script>
</form>



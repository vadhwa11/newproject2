<%@page import="jkt.hms.masters.business.OpdOphthalmologyDetails"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.MasImpanneledHospital"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.masters.business.ObgDetails"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
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
<%-- <%@page import="jkt.hms.masters.business.MasDisposal"%> --%>
<!--<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
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
<%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%><script
	type="text/javascript" src="/hms/jsp/js/gridForPatient.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js?n=1"></script>
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
<%System.out.println("opdmain");
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}
	List patientDataList = new ArrayList();
	List<OpdPatientDetails> opdDetailListForFollowUp = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> opdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
	List<PatientInvestigationHeader>patientInvestigationHeaderListForFollowUp = new ArrayList<PatientInvestigationHeader>();
	Set<PatientInvestigationDetails> patientInvestigationdetails = null;
	List<PatientPrescriptionHeader> patientPrescriptionHeaderList = new ArrayList<PatientPrescriptionHeader>();
	List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
	
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
		String lastEncounterDetail = "";
		
		Integer opdpatientDetailId=0;
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
			referralHospital = opdPatientDetails.getHospital().getId();
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
	if(map.get("opdHistoryDetailsListForFollowUp") != null){
		opdHistoryDetailsListForFollowUp=(List)map.get("opdHistoryDetailsListForFollowUp");
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
/* 	List<MasDisposal> disposalTypeList =null;

	if(map.get("disposalTypeList") != null){
				disposalTypeList= (List<MasDisposal>)map.get("disposalTypeList");
			} */ //commented unused code by Babita Dangwal on 21-09-2017
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
	String presentComplaintHistory=""; 
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
    String empTypeCodeForContract = null;
	
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
    String treatmentAdviceCode = null;
	
    try
    {
 	   prop.load(resourcePath.openStream());
 	  familyHistoryCode = prop.getProperty("templateCodeForFamilyHistory");
 	  complaintHistoryCode = prop.getProperty("templateCodeForComplaintHistory");
 	 patientTypeNameForHAL = prop.getProperty("patientTypeNameForHAL");
	 patientTypeNameForOther = prop.getProperty("patientTypeNameForOther");
	 empTypeCodeForContract = prop.getProperty("empTypeCodeForContract");
	 treatmentAdviceCode = prop.getProperty("templateCodeForTreatmentAdvice");
 	     
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
    
/* 	List <OpdPatientDetails> opdPatientDetailsList =new ArrayList<OpdPatientDetails>();
    if(map.get("opdPatientDetailsList") != null){
    	opdPatientDetailsList = (List<OpdPatientDetails>) map.get("opdPatientDetailsList");
    			} */ //commented unused code by Babita Dangwal on 21-09-2017

	List <MasItemClass> masItemClassList =new ArrayList<MasItemClass>();
    if(map.get("masItemClassList") != null){
    	masItemClassList = (List<MasItemClass>) map.get("masItemClassList");
    			}
  
	List<MasEmployeeDependent> med = null;
	if(map.get("med") != null){
		med = (List<MasEmployeeDependent>) map.get("med");
    			}
	List<OpdOphthalmologyDetails> opdOphthalmologyDetails = null;
	if (map.get("opdPDetailsListForEyeDeptFollowUp") != null) {
		opdOphthalmologyDetails = (List<OpdOphthalmologyDetails>) map.get("opdPDetailsListForEyeDeptFollowUp");
	}
	String departmentCodeForEye = HMSUtil.getProperties("adt.properties", "departmentCodeForEye");
	
	ObgDetails obgDetails = null;
	List<ObgDetails> obgDetailsList = null;
	if(map.get("obgDetailsList") != null){
		obgDetailsList = (List<ObgDetails>) map.get("obgDetailsList");
    			}
	List<MasBloodGroup> bloodGroupList = null;
	if(map.get("bloodGroupList") != null){
		bloodGroupList = (List<MasBloodGroup>) map.get("bloodGroupList");
    			}
	List<OpdPatientDetails> LastVisitPatientDetails = null;
	if(map.get("LastVisitPatientDetails") != null){
		LastVisitPatientDetails = (List<OpdPatientDetails>) map.get("LastVisitPatientDetails");//no restriction of departmetn
    			}
	%>
<!--main content placeholder starts here-->
<body onload="setPregencyValues()"></body>
<form name="opdMain" action="" method="post">
	<%-- <input type="hidden" id="referralotherpatient" value="<%=referral_other_patient %>" /> --%>
	<input type="hidden" name="userName" value="<%=userName %>" />
	<%if(visit.getDepartment()!= null){ %>
	<div class="titleBg">
		<h2>OPD- Main</h2>
	</div>
	<div class="clear"></div>
	<%} %>
	<script type="text/javascript">
	   var icdArray=new Array();
	   var unitArray = new Array();
	   var itemClassArray = new Array();
	   var itemClassCodeArray = new Array();
	   var departmentArray = new Array();
	   var ItemClassIdUOMNotRequired = new Array();
	</script>
	<%
			if(map.get("message") != null){
			   String message = (String)map.get("message");
			   //out.println(message);
			  }
	    %>
	<!--Block One Starts-->
	<h4>Patient Details</h4>
	<div class="clear"></div>
	<div class="Block">
		<% 
		int patientAge =0;
		String sPatientAge="-";
		String age =null;
		/* if(visit.getHin().getAge()!= null){
			age=!visit.getHin().getAge().equals("")?visit.getHin().getAge():"";
			if(age.length()>0){
			patientAge=Integer.parseInt(age.split(" ")[0]);
			}
			} */
			 
            if(visit.getHin().getDateOfBirth() != null)
            {
                Date date_of_birth= visit.getHin().getDateOfBirth();        
                patientAge = HMSUtil.calculateAgeInYears(date_of_birth);
                if(patientAge == 1 )
                    sPatientAge = patientAge +" Year";
                else if(patientAge == 0 )
                {
                	sPatientAge= HMSUtil.getAgeFromDOB( visit.getHin().getDateOfBirth());
                }
                else
                    sPatientAge = patientAge +" Years";

            }
		String []ItemClassCodeForLiquid = HMSUtil.getProperties("adt.properties", "ItemClassCodeForDrop").trim().split(",");
		
		
	for(int i=0;i<ItemClassCodeForLiquid.length;i++)
	{
	%>
	<script>

	itemClassCodeArray[<%=i%>]= new Array();
	itemClassCodeArray[<%=i%>][0] = "<%=ItemClassCodeForLiquid[i]%>";

     			
            </script>
<%	}%>

	<%
	String []ItemClassIdUOMNotRequired = HMSUtil.getProperties("adt.properties", "ItemClassIdUOMNotRequired").trim().split(",");
%>
	<%for(int i=0;i<ItemClassIdUOMNotRequired.length;i++)
	{
	%>
	<script>

	ItemClassIdUOMNotRequired[<%=i%>]= new Array();
	ItemClassIdUOMNotRequired[<%=i%>][0] = "<%=ItemClassIdUOMNotRequired[i]%>";

     			
            </script>
<%	}%>

<%-- <%=ItemClassIdUOMNotRequired.toString()%> --%>
<%if(visit.getHin().getRelation()!=null&&visit.getHin().getRelation().getNewRelationName().equalsIgnoreCase("Self"))
{ 
%>

		<div class="photoDivLeft">
			<label>Employee No.</label>
			<%if(visit.getHin().getServiceNo()!= null){ %>
			<label class="value"><%=visit.getHin().getServiceNo() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
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
					}%>
			<label class="value" style="min-width: 147px; width: auto;"><%=patient.getSFirstName()+" "+sMiddleName+" "+sLastName %></label>
			<%}}else{ %>
			<label class="value"></label>
			<%} %>
			<div class="clear"></div>
			<label>Relation</label>
			<%if(visit.getHin().getRelation()!= null){ %>
			<label class="value"><%=visit.getHin().getRelation().getNewRelationName() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<label>Designation</label>
			<%if(visit.getHin().getRank()!= null){ %>
			<label class="value"><%=visit.getHin().getRank().getRankName() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<div class="clear"></div>
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
					}%>
			<label class="value"><%=patientName %></label>
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
			<label>Age</label>
			<label class="value"><%=sPatientAge%></label>
			
		<%-- 	<%if(visit.getHin().getAge()!= null){ %>
			<label class="value"><%=visit.getHin().getAge() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %> --%>
				<%if(visit.getHin().getDateOfBirth()!= null){ %>
			<input type="hidden" name="ageId" id="ageId"
				value="<%=HMSUtil.calculateAgeInYears(visit.getHin().getDateOfBirth())%>">
			<%} %>
			<div class="clear"></div>
			<label>Gender</label>
			<%if(visit.getHin().getSex() != null){ %>
			<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
			<input type="hidden" name="genderId" id="genderId"
				value="<%=visit.getHin().getSex().getId() %>">
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>

			<%-- <%if(visit.getHin().getRelation().getId() != 8){ %>
<label >Occupation</label> 
<%if(visit.getHin().getOccupation()!= null){ %>
<label class="value"><%=visit.getHin().getOccupation().getOccupationName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%}} %> --%>
			<label>Marital Status</label>
			<%if(visit.getHin().getSrMaritalStatus()!= null){ %>
			<label class="value"><%=visit.getHin().getSrMaritalStatus().getMaritalStatusName() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<div class="clear"></div>
			<label>Blood Group</label>
	<%
	if(visit.getHin().getPatientType().getPatientTypeName().equalsIgnoreCase(patientTypeNameForHAL)){
	
	if(visit.getHin().getEmployee().getBloodGroup() != null){ %>
		<input name="patientEmpId" type="hidden" value="<%=visit.getHin().getEmployee().getId()%>" />
			    <% if(visit.getHin().getEmployee().getBloodGroup().getBloodGroupName().equalsIgnoreCase("NA")){%>
			<select name="bloodGroupId"><option value="">Select</option> 
			<%for(MasBloodGroup mbg: bloodGroupList){ %>
			<option value="<%=mbg.getId()%>" <%=visit.getHin().getEmployee().getBloodGroup().getId()==mbg.getId()?"selected":"" %>><%=mbg.getBloodGroupName()%></option>
			<%} %>
			</select>
			<%}else{
				%>
				<label class="value"><%=visit.getHin().getEmployee().getBloodGroup().getBloodGroupName() %></label>
				<%
			}}else{ %>
		<select name="bloodGroupId"><option value="">Select</option> 
			<%for(MasBloodGroup mbg: bloodGroupList){ %>
			<option value="<%=mbg.getId()%>"><%=mbg.getBloodGroupName()%></option>
			<%} %>
			</select><%}} else{%>
			<label class="value"><%=visit.getHin().getBloodGroup()!=null?visit.getHin().getBloodGroup().getBloodGroupName():""%></label>
			<%}%>
			<label>Current Year's Visit</label> <label class="value"><%=visitCount%></label>
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

			<div class="clear"></div>
			<label><span>Allergy</span></label>
			<%if(visit.getHin().getDrugAllergies() != null){ %>
			<input name="allergies" type="text" tabindex="1" class="auto"
				value="<%=visit.getHin().getDrugAllergies() %>" maxlength="500"
				id="allergies" size="77" />
			<%}else{ %>
			<input name="allergies" type="text" tabindex="1" class="auto"
				value="" maxlength="500" id="allergies" size="77" />
			<%} %>
			<div class="clear"></div>
			<%-- <%if(opdPDetailsListForEyeDeptFollowUp.size()>0){
			    OpdPatientDetails eyeDetails = opdPDetailsListForEyeDeptFollowUp.get(0);
			}%> --%>
			
		
		</div>
		<div class="photoImageDiv">
		
		<% 
		System.out.println(visit.getHin().getPatientType().getPatientTypeCode() +" xf");
		  if(visit.getHin().getPatientType()!=null && visit.getHin().getPatientType().getPatientTypeName().equalsIgnoreCase(patientTypeNameForHAL))
		  {
		%>	
		  <img value="sfsf"
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
		<%-- <input class="transparent" size="125" >--%>
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
			<label class="value">&nbsp;</label>
			<%} %>
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
					}
					servicePersionName=patient.getSFirstName()+" "+sMiddleName+" "+sLastName;
					}%>
			<label class="value" style="min-width: 147px; width: auto;"><%=patientName %></label>
			<%} %>
			<div class="clear"></div>
			<label>Relation</label>
			<%if(visit.getHin().getRelation()!= null){ %>
			<label class="value"><%=visit.getHin().getRelation().getNewRelationName() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<label>Designation</label>
			<%if(visit.getHin().getRank()!= null){ %>
			<label class="value"><%=visit.getHin().getRank().getRankName() %></label>
			<%}else{ %>
			<label class="value"></label>
			<%} %>
			<div class="clear"></div>
			<label>Name</label> <label class="value"><%=servicePersionName %></label>

			<%-- <label>Trade/Branch</label>
 <%if(visit.getHin().getTrade() != null){ %>
<label class="value"><%=visit.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %> --%>

			<%--  <label>Unit</label>
 <%if(visit.getHin().getUnit() != null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
 --%>
			<label>Age</label>
			<label class="value"><%=sPatientAge%></label>
		<%-- 	<%if(visit.getHin().getAge()!= null){ %>
			<label class="value"><%=visit.getHin().getAge()%></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %> --%>
			<div class="clear"></div>
			<label>Gender</label>
			<%if(visit.getHin().getSex() != null){ %>
			<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
			<input type="hidden" name="genderId" id="genderId"
				value="<%=visit.getHin().getSex().getId() %>">
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>

			<%-- <label >Occupation</label> 
<%if(visit.getHin().getOccupation()!= null){ %>
<label class="value"><%=visit.getHin().getOccupation().getOccupationName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %> --%>
			<label>Marital Status</label>
			<%if(visit.getHin().getMaritalStatus() != null){ %>
			<label class="value"><%=visit.getHin().getMaritalStatus().getMaritalStatusName() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
			<div class="clear"></div>
		<% int dependentId=0;
	MasEmployeeDependent employeeDependent =null;
	if(med!=null){
for(MasEmployeeDependent dependent :med)
{
	  if(dependent.getRelation().getId() == visit.getHin().getRelation().getId())
	  {
		  dependentId=dependent.getId();
		  employeeDependent = dependent;
	 break; }
}
	}%>

<label >Blood Group</label>
<input name="dependentId" type="hidden" value="<%=dependentId%>" />
		<%if(employeeDependent.getBloodGroup() != null){ 
			     if(employeeDependent.getBloodGroup().getBloodGroupName().equalsIgnoreCase("NA")){%>
			<select name="bloodGroupId"><option value="">Select</option> 
			<%for(MasBloodGroup mbg: bloodGroupList){ %>
			<option value="<%=mbg.getId()%>" <%=employeeDependent.getBloodGroup().getId()==mbg.getId()?"selected":"" %>><%=mbg.getBloodGroupName()%></option>
			<%} %>
			</select>
			<%}else{
				%>
				<label class="value"><%=employeeDependent.getBloodGroup().getBloodGroupName() %></label>
				<%
			}}else{ %>
		<select name="bloodGroupId"><option value="">Select</option> 
			<%for(MasBloodGroup mbg: bloodGroupList){ %>
			<option value="<%=mbg.getId()%>"><%=mbg.getBloodGroupName()%></option>
			<%} %>
			</select><%} %>
			<label>Current Year's Visit</label> <label class="value"><%=visitCount%></label>
			<div class="clear"></div>
			<%-- <label >Allergies</label> --%>
			<%--if(visit.getHin() != null){ --%>
			<%-- <label class="value">&nbsp;</label> --%>
			<%--}else{ --%>
			<%--<label class="value">&nbsp;</label> --%>
			<%--} --%>
			<div class="clear"></div>
			<label><span>Allergy</span></label>
			<%if(visit.getHin().getDrugAllergies() != null){ %>
			<input name="allergies" type="text" tabindex="1" class="auto"
				value="<%=visit.getHin().getDrugAllergies() %>" maxlength="500"
				id="allergies" size="77" />
			<%}else{ %>
			<input name="allergies" type="text" tabindex="1" class="auto"
				value="" maxlength="500" id="allergies" size="77" />
			<%} %>
			
	
		</div>

<div class="photoImageDiv"><img src="/hms/hms/personnel?method=displayImageEmployeeDependent&amp;employeeDependentId=<%=dependentId%>" width="105" height="112"></div>
<%-- <div>		<%
			
			if(opdPDetailsListForEyeDeptFollowUp.size()>0 && departmentCodeForEye.equalsIgnoreCase(visit.getDepartment().getDepartmentCode())){ %>
				<h4>Previous Ophthalmology details </h4>
				<table border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr><th></th><th colspan="3" style="text-align: center;">R.E.</th><th colspan="3"style="text-align: center;">L.E.</th></tr>
	  <tr><th></th><th>SPH</th><th>CYL</th><th>Axis</th><th>SPH</th><th>CYL</th><th>Axis</th></tr>
	  <tr><th>Dist</th><td><%=opdPDetailsListForEyeDeptFollowUp.get(0).getDistRSph()!=null?opdPDetailsListForEyeDeptFollowUp.get(0).getDistRSph():""%></td><td><%=opdPDetailsListForEyeDeptFollowUp.get(0).getDistRCyl()!=null?opdPDetailsListForEyeDeptFollowUp.get(0).getDistRCyl():""%></td><td><%=opdPDetailsListForEyeDeptFollowUp.get(0).getDistRAxis()!=null?opdPDetailsListForEyeDeptFollowUp.get(0).getDistRAxis():""%></td><td><%=opdPDetailsListForEyeDeptFollowUp.get(0).getDistLSph()!=null?opdPDetailsListForEyeDeptFollowUp.get(0).getDistLSph():""%></td><td><%=opdPDetailsListForEyeDeptFollowUp.get(0).getDistLCyl()!=null?opdPDetailsListForEyeDeptFollowUp.get(0).getDistLCyl():""%></td><td><%=opdPDetailsListForEyeDeptFollowUp.get(0).getDistLAxis()!=null?opdPDetailsListForEyeDeptFollowUp.get(0).getDistLAxis():""%></td></tr>
	  <tr><th>Near</th><td><%=opdPDetailsListForEyeDeptFollowUp.get(0).getNearRSph()!=null?opdPDetailsListForEyeDeptFollowUp.get(0).getNearRSph():""%><td><%=opdPDetailsListForEyeDeptFollowUp.get(0).getNearRCyl()!=null?opdPDetailsListForEyeDeptFollowUp.get(0).getNearRCyl():""%></td><td><%=opdPDetailsListForEyeDeptFollowUp.get(0).getNearRAxis()!=null?opdPDetailsListForEyeDeptFollowUp.get(0).getNearRAxis():""%></td><td><%=opdPDetailsListForEyeDeptFollowUp.get(0).getNearLSph()!=null?opdPDetailsListForEyeDeptFollowUp.get(0).getNearLSph():""%></td><td><%=opdPDetailsListForEyeDeptFollowUp.get(0).getNearLCyl()!=null?opdPDetailsListForEyeDeptFollowUp.get(0).getNearLCyl():""%></td><td><%=opdPDetailsListForEyeDeptFollowUp.get(0).getNearLAxis()!=null?opdPDetailsListForEyeDeptFollowUp.get(0).getNearLAxis():""%></td></tr>
	</table>
	<label>IPD(50-70)</label><label class="value"><%=opdPDetailsListForEyeDeptFollowUp.get(0).getEyeIpd()!=null?opdPDetailsListForEyeDeptFollowUp.get(0).getEyeIpd():""%></label>
	<label>Use</label><label class="value"><%=opdPDetailsListForEyeDeptFollowUp.get(0).getEyeUse()!=null?opdPDetailsListForEyeDeptFollowUp.get(0).getEyeUse():""%></label>
	<label>Type of Lens</label><label class="value"><%=opdPDetailsListForEyeDeptFollowUp.get(0).getLensType()!=null?opdPDetailsListForEyeDeptFollowUp.get(0).getLensType():""%></label>
	
<%} %></div> --%>

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
			<li><a href="#"
				onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&hinNo=<%=visit.getHin().getHinNo()%>&backFlag=OPD')">
					Previous Visits </a> <!--<a href="#" onclick="submitFormForButton('opdMain','opd?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&backFlag=OPD')">
	Previous Visits </a>--></li>

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
			<li><a href="#"
				onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&hinNo=<%=visit.getHin().getHinNo()%>&backFlag=OPD')">
					Previous Hospitalizations</a> <!--<a href="#" onclick="submitFormForButton('opdMain','opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&backFlag=OPD')">
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
	<%-- 		<li>
				Code for Open In popup mode
	Code By Mukesh 04 Oct 2011
	 
	<a href="opd?method=showPatientPreviousVisitForPrescriptionReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>">
	Previous Prescriptions</a>
	 //opd?method=showPatientPreviousVisitForPrescriptionReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>
	 <li><a
		href="opd?method=showPatientPreviousVisitForInvestigationReport&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment().getId()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>">Previous
	Investigations</a></li>
	 <a href="#"
				onclick="javascript:openPopupPrescriptions(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getDepartment().getId()%>,<%=visit.getHin().getId()%>)">
					Previous Prescriptions</a>
			</li> --%>
			
	<%-- 		<li>
	 <a href="#"
				onclick="javascript:openPopupPrescriptions(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getDepartment().getId()%>,<%=visit.getHin().getId()%>)">
					Previous Prescriptions</a>
			</li>  --%>
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
			<li><a href="#"
				onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId() %>&token=<%=visit.getTokenNo()%>&backFlag=OPD')">Upload
					Documents </a> <!--<a href="#" onclick="submitFormForButton('opdMain','opd?method=showUploadingDocumentsJsp&visitId=<%=visit.getId() %>&token=<%=visit.getTokenNo()%>&backFlag=OPD')">Upload Documents </a>--></li>
					
					<li><a href="#"
				      onclick="openWindow('/hms/hms/opd?method=viewAllPrevoiusSurgery&hinId=<%=visit.getHin().getId()%>')">Previous Minor Surgery
					 </a></li> 

		 	<%
	String departmentCodeForPhychiatrist = HMSUtil.getProperties("adt.properties", "departmentCodeForPhychiatrist");
		 	String departmentCodeForPediatric = HMSUtil.getProperties("adt.properties", "departmentCodeForPediatric");
		 	String departmentCodeForOBG = HMSUtil.getProperties("adt.properties", "departmentCodeForOBG");
		 	String departmentCodeForSurgery = HMSUtil.getProperties("adt.properties", "departmentCodeForSurgery");
		 	String departmentCodeForGM = HMSUtil.getProperties("adt.properties", "departmentCodeForGM");
			String departmentCodeForDermo = HMSUtil.getProperties("adt.properties", "departmentCodeForDermo");
	if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForOBG)) {
				obgDetails =new ObgDetails();
				//System.out.println("opdDetailListForFollowUp.get(0) "+opdDetailListForFollowUp.get(0).getId());
			  	if(opdDetailListForFollowUp.size()>0 && opdDetailListForFollowUp.get(0).getObgDetails().size()>0)
				{
						obgDetails =((ObgDetails)(opdDetailListForFollowUp.get(0).getObgDetails().toArray()[0]));		
				}  
	}
	if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForPhychiatrist)) {%>
		 	<li><a href="#"
				onclick="openWindow('/hms/hms/opd?method=showPsychiatristQuestionnaireJsp&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId() %>')">Phychiatrist
					Questionnaire </a></li>
					
					<li><a href="#"
				      onclick="openWindow('/hms/hms/opd?method=viewAllPrevoiusSession&hinId=<%=visit.getHin().getId()%>')">Previous Therapy
					 </a></li> 
					 
					 
			<%} %> 
			
			
		<%if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForOBG)) {%>
	
		<li><a href="#" onclick="openDynamicWindow('/hms/hms/opd?method=showPatientPreviousOBGVisit&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId() %>',1250)">Ante Natal Care(ANC)</a></li>
	<%} %>
			<%-- <li><a href="#">Drug Allergies</a></li> --%>
			<%--<li>Print AFMSF- 7A</li>
--%>
	<%if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForPediatric)) {
 	if(patientAge<=7){ %>
				<li><a
					href="javascript:popwindowImmunization('opd?method=showVaccineDetailJsp&visitId=<%=visit.getId()%>&hinId=<%=hinId%>');">Immunization</a></li>
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
			<input type="text" name="hospName" tabindex="1" size="100"
				value="<%=(opdDetailsForFollowup.getHospName()!=null?opdDetailsForFollowup.getHospName():"") %>"
				maxlength="150" />
			<%}else{ %>
			<input type="text" name="hospName" tabindex="1" size="100" value=""
				maxlength="150" />
			<%} %>
			<label class="auto">DOA</label>
			<%if(opdDetailsForFollowup != null){ %>
			<input type="text" name="doa" class="date" id="doa" MAXLENGTH="30"
				validate="Pick a from date,date,no"
				value="<%=opdDetailsForFollowup.getDoa()!=null?opdDetailsForFollowup.getDoa():"" %>"
				readonly="readonly" onblur="checkDate1(this.value,this.id)" />
			<%}else{ %>
			<input type="text" name="doa" class="date" id="doa" MAXLENGTH="30"
				validate="Pick a from date,date,no" value="" readonly="readonly"
				onblur="checkDate1(this.value,this.id)" />

			<%} %>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				onclick="javascript:setdate('doa',document.opdMain.doa, event)"
				validate="Pick a date" /> <label class="auto">DOD</label>
			<%if(opdDetailsForFollowup != null){ %>
			<input type="text" name="dod"
				value="<%=opdDetailsForFollowup.getDod()!=null?opdDetailsForFollowup.getDod():"" %>"
				class="date" id="dod" MAXLENGTH="30"
				validate="Pick a from date,date,no" readonly="readonly" />
			<%}else{ %>
			<input type="text" name="dod" value="" class="date" id="dod"
				MAXLENGTH="30" validate="Pick a from date,date,no"
				readonly="readonly" onblur="checkDate1(this.value,this.id)" />
			<%} %>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				onclick="javascript:setdate('dod',document.opdMain.dod, event)"
				validate="Pick a date" onblur="checkDate1(this.value,this.id)" />
			<div class="clear"></div>
			<label>Diagnosis</label> <input type="text" class="auto" size="48"
				id="pastDiagnosis" tabindex="1" value="" name="pastDiagnosis"
				maxlength="100" />
			<div class="clear"></div>
			<label>Advise on Discharge</label>
			<%if(opdDetailsForFollowup != null){ %>
			<textarea name="adviceOnDischarge" cols="0" rows="0" maxlength="300"
				value="<%=opdDetailsForFollowup.getAdviceOnDischarge() !=null?opdDetailsForFollowup.getAdviceOnDischarge():"" %>"
				tabindex="1" onkeyup="return ismaxlength(this)"></textarea>
			<%}else{ %>
			<textarea name="adviceOnDischarge" cols="0" rows="0" maxlength="300"
				value="" tabindex="1" onkeyup="return ismaxlength(this)"></textarea>
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
 --%>
			<div class="clear"></div>
			<label>Past Medical History</label>
			<!--  <input type="text" id="presentComplain"  name="presentComplain" maxlength="100"/>-->
			<textarea name="pastMedicalHistory" id="pastMedicalHistory" cols="0" rows="0" maxlength="5000"
				value="" tabindex="1" onkeyup="return ismaxlength(this)"><%=opdPatientHistory != null && opdPatientHistory.getPastMedicalHistory()!= null?opdPatientHistory.getPastMedicalHistory():"" %></textarea>
			<input type="button" class="button" tabindex="3" name=""
						value="+" onclick="getPresentTemplate('<%=complaintHistoryCode%>','pastMedicalHistory');" />
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
			
			<%if(visit.getDepartment()!=null && (visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForPhychiatrist) || visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForSurgery) || visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForGM)) || visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForDermo)) {%>
			<textarea class="opdMainTextArea yellowBackground"
				name="presentComplain" id="presentComplain" tabindex="2"
				validate="Present Complaint,string,yes" maxlength="5000" cols="0" rows="0"><%=opdPatientHistory != null && opdPatientHistory.getPresentComplain()!= null?opdPatientHistory.getPresentComplain().replace(",", "\n"):"" %></textarea>
			<%}else{ %>
			<textarea class="opdMainTextArea yellowBackground"
				name="presentComplain" id="presentComplain" maxlength="5000" tabindex="2"
				validate="Present Complaint,string,yes" cols="0" rows="0"></textarea>
			<%} %>
			
				
			<input type="button" class="button" tabindex="3" name="" value="+"
				onclick="getPresentTemplate('<%=complaintHistoryCode%>');" /> <label>Family
				Present History</label>
			<textarea class="opdMainTextArea yellowBackground"
				name="familyHistory" validate="Family History,string,no"
				id="familyHistory" cols="0" rows="0" maxlength="500" tabindex="8"><%=opdPatientHistory != null && opdPatientHistory.getFamilyPresentHistory()!= null?opdPatientHistory.getFamilyPresentHistory().replace(",", "\n"):"" %></textarea>
			<input type="button" class="buttonAuto-buttn" id="" name="" value="+"
				onclick="getFamilyHistoryTemplate('<%=familyHistoryCode%>');"
				tabindex="9" />
				
				<%if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForOBG)) {%>
				<label>HOPI</label><textarea name="hopi" cols="0" rows="0" maxlength="300"><%=obgDetails.getHopi()!=null?obgDetails.getHopi():""%></textarea>
	            <label>Other Complaints</label><textarea name="other_complaint" cols="0" rows="0" maxlength="300"><%=obgDetails.getOtherComplaints()!=null?obgDetails.getOtherComplaints():""%></textarea>
	             <label>Personal History</label><textarea name="personal_history" cols="0" rows="0" maxlength="200"><%=obgDetails.getPersonalHistory()!=null?obgDetails.getPersonalHistory():""%></textarea>
	            <label>Clinical History</label><textarea name="clinical_history" cols="0" rows="0" maxlength="200"><%=obgDetails.getClinicalHsirory()!=null?obgDetails.getClinicalHsirory():""%></textarea>
	            <label>Surgery History</label><textarea name="surgery_history" cols="0" rows="0" maxlength="200"><%=obgDetails.getSurgicalHistory()!=null?obgDetails.getSurgicalHistory():""%></textarea>
		<%} %>
				
			<%-- 	<%if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForOBG)) {%>
				<label>HOPI</label><textarea name="hopi" cols="0" rows="0" maxlength="300"></textarea>
	        <label>Other Complaints</label><textarea name="other_complaint" cols="0" rows="0" maxlength="300"></textarea>
	         <label>Personal History</label><textarea name="personal_history" cols="0" rows="0" maxlength="200"></textarea>
	          <label>Clinical History</label><textarea name="clinical_history" cols="0" rows="0" maxlength="200"></textarea>
		<%} %> --%>
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
		</div>
		<!-- floatLeft ends-->



		<%--  
 ---------commented by anamika------------------------
  <div class="floatRight"><input	name="investigationTemplate" type="button" onclick="showSymptom()" class="btn_Symptomp_Assist"	tabindex="1"  /></div>--%>
		<!-- float Right ends -->
		<div class="clear"></div>
	</div>
	<!-- opdarea ends -->

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
	<%
	
	
	
/* 	if(opdPatientDetails!=null  && opdPatientDetails.getReferralVisit()!=null && opdPatientDetails.getReferralVisit().getId().equals(visit.getId()) &&  opdPatientDetails.getReferredDeptInt()!=null && opdPatientDetails.getReferredDeptInt().getId().equals(deptId) )
	{ */
	if(visit.getRefereeOpdPatientdetailsId()!=null){
	
	 String name=visit.getRefereeOpdPatientdetailsId().getEmployee().getFirstName();
		/* if(visit.getRefereeOpdPatientdetailsId().getEmployee().getMiddleName()!=null && !visit.getRefereeOpdPatientdetailsId().getEmployee().getMiddleName().equals(""))
			name=name+" "+opdPatientDetails.getEmployee().getMiddleName();
		if(visit.getRefereeOpdPatientdetailsId().getEmployee().getLastName()!=null && !visit.getRefereeOpdPatientdetailsId().getEmployee().equals(""))
			name=name+" "+opdPatientDetails.getEmployee().getLastName(); */	
 %>
	<div class="clear paddingTop5"></div>
	<h4>Referral</h4>
	<div class="Block">
		<label>Referred by Doctor</label> <input type="text" id="" name=""
			readonly="readonly" value="<%=name%>" /> <input type="hidden" id=""
			name="" readonly="readonly" /> <label>Department From</label> <input
			type="text" id="" name="" readonly="readonly"
			value="<%=visit.getRefereeOpdPatientdetailsId().getDepartment().getDepartmentName()%>" />
		<%-- 	<label>Hospital From</label> <input type="text" id="" name=""
						readonly="readonly"
						value="<%=opdPatientDetails.getHospital()!=null?opdPatientDetails.getHospital().getHospitalName():"" %>" /> --%>

		<label>Date</label> <input type="text" class="date"
			readonly="readonly"
			value="<%=HMSUtil.convertDateToStringTypeDateOnly(visit.getRefereeOpdPatientdetailsId().getOpdDate()) %>" />

		
	<%-- 	<label>Patient Advice</label>
		<textarea class="auto" cols="82" rows="0" maxlength="300"
			readonly="readonly"><%=opdPatientDetails.getPatientAdvise()!=null?opdPatientDetails.getPatientAdvise():"" %>
					</textarea> --%>
					<%
					String referralSysDia = null;
					int count=0;
					Set<DischargeIcdCode> referralSysDiaSet = visit.getRefereeOpdPatientdetailsId().getDischargeIcdCodes();
					for(DischargeIcdCode dIC:referralSysDiaSet)
					{
						if(count==0)
							referralSysDia=dIC.getIcd().getIcdName();
						else
						referralSysDia +=" | "+dIC.getIcd().getIcdName();
						
						count++;
					
					}
					
					Set<DgOrderhd> referralDgOrderHd = visit.getRefereeOpdPatientdetailsId().getVisit().getDgOrderhds();
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
	   <textarea  style="width: 477px;" cols="0" rows="0" maxlength="300"
		readonly="readonly"><%=referralSysDia !=null?referralSysDia:"" %></textarea>
	
	
	   <div class="clear"></div>
		<label>Doctor Note</label>
		<textarea cols="0" rows="0" maxlength="500" readonly="readonly" style="width: 477px;"><%=visit.getRefereeOpdPatientdetailsId().getReferralNotes()!=null?visit.getRefereeOpdPatientdetailsId().getReferralNotes():"" %>
					</textarea>
		<div class="clear"></div>
		<label>Investigation</label>
	   <textarea style="width: 477px;" cols="0" rows="0" maxlength="300"
		readonly="readonly"><%=referralInvestigation !=null?referralInvestigation:"" %></textarea>		

					
		

	</div>

	<%}%>
	<div class="clear paddingTop5"></div>


	<%
 if(patientAge>=18 && visit.getHin().getSex().getAdministrativeSexCode().equalsIgnoreCase("F"))
 {
	 // remove this code after some time  
	 if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForOBG))
		 LastVisitPatientDetails = opdDetailListForFollowUp;
	 //end
%>
	<h4>Pregnancy</h4>
	<div class="Block">
		<%	 
 if(LastVisitPatientDetails!=null && LastVisitPatientDetails.size()>0 && LastVisitPatientDetails.get(0).getPregnancy()!=null && LastVisitPatientDetails.get(0).getPregnancy().equalsIgnoreCase("y"))
 {
%>
		<label class="">Pregnant</label> <input type="checkbox"
			name="pregnancy" id="pregnancy" class="radioAuto" value="y" 
			onclick="fillPregnancylValue(this.id);putLMPEDD(this.id,'<%=HMSUtil.convertDateToStringWithoutTime(LastVisitPatientDetails.get(0).getLmpDate())%>','<%=LastVisitPatientDetails.get(0).getEddDate() !=null?HMSUtil.convertDateToStringWithoutTime(LastVisitPatientDetails.get(0).getEddDate()):""%>')"
			checked="checked" />
			 <label class="auto">LMP Date</label> 
			 <input type="text" name="lmp_date" id="lmp_date" class="calDate"  placeholder="DD/MM/YYYY" onkeyup="mask(this.value,this,'2,5','/');" onchange="generateEDD(this.id, pregnancy);"
			id="lmp_date" value="<%=HMSUtil.convertDateToStringWithoutTime(LastVisitPatientDetails.get(0).getLmpDate())%>" />
			

		<label class="auto">EDD</label><input type="text" name="edd" id="edd" class="calDate"  placeholder="DD/MM/YYYY" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'edd');" value="<%=LastVisitPatientDetails.get(0).getEddDate() !=null?HMSUtil.convertDateToStringWithoutTime(LastVisitPatientDetails.get(0).getEddDate()):""%>" />
		<label class="auto">Current EDD</label><input type="text"  class="calDate"  placeholder="DD/MM/YYYY" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'current edd');" name="currentEdd" id="currentEdd" readonly="readonly" value="<%=LastVisitPatientDetails.get(0).getCurrentEdd() !=null?HMSUtil.convertDateToStringWithoutTime(LastVisitPatientDetails.get(0).getCurrentEdd()):consultationDate%>" />
 <div class="clear"></div>
  <label class="auto">Period of Gestation for today</label><input  type="text" name="operation_period_today" value="<%=LastVisitPatientDetails.get(0).getOperationPeriodToday()!=null?LastVisitPatientDetails.get(0).getOperationPeriodToday():""%>" id="operation_period_today"/> 
		<%}
 
 else
 {%>
		<label class="">Pregnant</label> <input type="checkbox"
			name="pregnancy" id="pregnancy" class="radioAuto" value="n"
			onclick="fillPregnancylValue(this.id);" /> <label class="auto">LMP
			Date</label> <%-- <input type="text" name="lmp_date" id="lmp_date"
			readonly="readonly" id="lmp_date" value=""
			onblur="generateEDD(this.id, pregnancy);" /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.getElementById('lmp_date'),event);"
			onchange="onSlelctSurgeryDate();" /> --%>
			<input  type="text" class="calDate"  id="lmp_date" name="lmp_date" placeholder="DD/MM/YYYY" validate="LMP Date,string,no" value="" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'lmp_date');" onchange="generateEDD(this.id, pregnancy);" maxlength="10" style="width: 120px"/>
	<label class="auto">EDD</label><%-- <input type="text" name="edd" id="edd"
			readonly="readonly" />
			<img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.getElementById('edd'),event);"
			 /> --%>
			 <input  type="text" class="calDate"  id="edd" name="edd" placeholder="DD/MM/YYYY" validate="EDD Date,string,no" value="" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'edd');" maxlength="10" style="width: 120px"/>
			 <label class="auto">Current EDD</label><input  type="text" class="calDate"  id="currentEdd" name="currentEdd" placeholder="DD/MM/YYYY" validate="Current EDD Date,string,no" value="" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'currentEdd');" maxlength="10" style="width: 120px"/>
			  <div class="clear"></div>
			 <label class="auto">Period of Gestation for today</label><input  type="text" name="operation_period_today" id="operation_period_today"/>
		<%} 
 %>
	</div>
	<%}%>

	<div class="clear paddingTop5"></div>
		<div class="clear paddingTop15"></div>
	
	<%
	
	if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForEye)) {%>
	<%if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getVisit().getId() == visit.getId()) {%>
	<input type="hidden" name="opdOphthalId" value="<%=opdOphthalmologyDetails.get(0).getId()%>">
	<%}%>
	
	
	<div class="Block">
	<div class="clear"></div>
	 <label>Employee No.</label>
			<%if(visit.getHin().getServiceNo()!= null){ %>
			<label class="value"><%=visit.getHin().getServiceNo() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
	<label>Patient Name</label>
	<label class="value"><%=visit.getHin().getPFirstName() %></label>
	<label>Relation</label>
			<%if(visit.getHin().getRelation()!= null){ %>
			<label class="value"><%=visit.getHin().getRelation().getNewRelationName() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %> 
	<h4>Vision</h4>
	<table border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr><th></th><th colspan="3" style="text-align: center;">R.E.</th><th colspan="3"style="text-align: center;">L.E.</th></tr>
	  <tr><th></th><th>Uncorrected</th><th>Pinhole</th><th>Best Corrected</th><th>Uncorrected</th><th>Pinhole</th><th>Best Corrected</th></tr>
	  <tr><th>Distance</th>
	  <td><select name="dist_r_uncorrected"><option value="">Select</option>
	    <option value="6/6-20/25" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/6-20/25")?"selected":"": ""%>>6/6-20/25</option>
	    <option value="6/6p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/6p")?"selected":"": ""%>>6/6p </option>
	    <option value="6/9-20/30" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/9-20/30")?"selected":"": ""%>>6/9-20/30 </option>
	    <option value="6/9p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/9p")?"selected":"": ""%>>6/9p </option>
	    <option value="6/12-20/40" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/12-20/40")?"selected":"": ""%>>6/12-20/40 </option>
	    <option value="6/12p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/12p")?"selected":"": ""%>>6/12p </option>
	    <option value="6/18-20/50" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/18-20/50")?"selected":"": ""%>>6/18-20/50 </option>
	    <option value="6/18p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/18p")?"selected":"": ""%>>6/18p</option>
	    <option value="6/24-20/70" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/24-20/70")?"selected":"": ""%>>6/24-20/70</option>
	    <option value="6/24p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/24p")?"selected":"": ""%>>6/24p </option>
	    <option value="6/36-20/100" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/36-20/100")?"selected":"": ""%>>6/36-20/100 </option>
	    <option value="6/36p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/36p")?"selected":"": ""%>>6/36p </option>
	    
	    <option value="6/60-20/200" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/60-20/200")?"selected":"": ""%>>6/60-20/200</option>
	    <option value="6/60p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/60p")?"selected":"": ""%>>6/60p </option>
	    <option value="3/60" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("3/60")?"selected":"": ""%>>3/60 </option>
	    <option value="CF 5 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("CF 5 mt")?"selected":"": ""%>>CF 5 mt </option>
	    <option value="CF 4 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("CF 4 mt")?"selected":"": ""%>>CF 4 mt </option>
	    <option value="CF 3 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("CF 3 mt")?"selected":"": ""%>>CF 3 mt </option>
	    <option value="CF 2 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("CF 2 mt")?"selected":"": ""%>>CF 2 mt </option>
	    <option value="CF 1 mts" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("CF 1 mts")?"selected":"": ""%>>CF 1 mts </option>
	    <option value="CFCF" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("CFCF")?"selected":"": ""%>>CFCF </option>
	    <option value="PL +ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("PL +ve")?"selected":"": ""%>>PL +ve </option>
	    <option value="PL -ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("PL -ve")?"selected":"": ""%>>PL -ve </option>
	    <option value="NIG" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("NIG")?"selected":"": ""%>>NIG </option>
	   <option value="HM+" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("HM+")?"selected":"": ""%>>HM+ </option>
	  </select></td>
	  
	  <td><select name="dist_r_pinhole"><option value="">Select</option>
	  <option value="6/6-20/25" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/6-20/25")?"selected":"": ""%>>6/6-20/25</option>
	    <option value="6/6p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/6p")?"selected":"": ""%>>6/6p </option>
	    <option value="6/9-20/30" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/9-20/30")?"selected":"": ""%>>6/9-20/30 </option>
	    <option value="6/9p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/9p")?"selected":"": ""%>>6/9p </option>
	    <option value="6/12-20/40" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/12-20/40")?"selected":"": ""%>>6/12-20/40 </option>
	    <option value="6/12p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/12p")?"selected":"": ""%>>6/12p </option>
	    <option value="6/18-20/50" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/18-20/50")?"selected":"": ""%>>6/18-20/50 </option>
	    <option value="6/18p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/18p")?"selected":"": ""%>>6/18p </option>
	    <option value="6/24-20/70" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/24-20/70")?"selected":"": ""%>>6/24-20/70</option>
	    <option value="6/24p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/24p")?"selected":"": ""%>>6/24p </option>
	    <option value="6/36-20/100" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/36-20/100")?"selected":"": ""%>>6/36-20/100 </option>
	    <option value="6/36p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/36p")?"selected":"": ""%>>6/36p </option>
	    
	    <option value="6/60-20/200" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/60-20/200")?"selected":"": ""%>>6/60-20/200 </option>
	    <option value="6/60p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/60p")?"selected":"": ""%>>6/60p </option>
	    <option value="3/60" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("3/60")?"selected":"": ""%>>3/60 </option>
	    <option value="CF 5 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("CF 5 mt")?"selected":"": ""%>>CF 5 mt </option>
	    <option value="CF 4 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("CF 4 mt")?"selected":"": ""%>>CF 4 mt </option>
	    <option value="CF 3 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("CF 3 mt")?"selected":"": ""%>>CF 3 mt </option>
	    <option value="CF 2 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("CF 2 mt")?"selected":"": ""%>>CF 2 mt </option>
	    <option value="CF 1 mts" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("CF 1 mts")?"selected":"": ""%>>CF 1 mts </option>
	    <option value="CFCF" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("CFCF")?"selected":"": ""%>>CFCF </option>
	    <option value="PL +ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("PL +ve")?"selected":"": ""%>>PL +ve </option>
	    <option value="PL -ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("PL -ve")?"selected":"": ""%>>PL -ve </option>
	   <option value="NIG" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("NIG")?"selected":"": ""%>>NIG </option>
	   <option value="HM+" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("HM+")?"selected":"": ""%>>HM+ </option>
	  
	  </select></td>
	  <td><select name="dist_r_best_corrected"><option value="">Select</option>
	  <option value="6/6-20/25" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/6-20/25")?"selected":"": ""%>>6/6-20/25</option>
	    <option value="6/6p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/6p")?"selected":"": ""%>>6/6p </option>
	    <option value="6/9-20/30" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/9-20/30")?"selected":"": ""%>>6/9-20/30 </option>
	    <option value="6/9p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/9p")?"selected":"": ""%>>6/9p </option>
	    <option value="6/12-20/40" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/12-20/40")?"selected":"": ""%>>6/12-20/40 </option>
	    <option value="6/12p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/12p")?"selected":"": ""%>>6/12p </option>
	    <option value="6/18-20/50" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/18-20/50")?"selected":"": ""%>>6/18-20/50 </option>
	    <option value="6/18p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/18p")?"selected":"": ""%>>6/18p </option>
	    <option value="6/24-20/70" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/24-20/70")?"selected":"": ""%>>6/24-20/70</option>
	    <option value="6/24p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/24p")?"selected":"": ""%>>6/24p </option>
	    <option value="6/36-20/100" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/36-20/100")?"selected":"": ""%>>6/36-20/100 </option>
	    <option value="6/36p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/36p")?"selected":"": ""%>>6/36p </option>
	    <option value="6/60-20/200" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/60-20/200")?"selected":"": ""%>>6/60-20/200 </option>
	    <option value="6/60" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/60")?"selected":"": ""%>>6/60 </option>
	    <option value="6/60p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/60p")?"selected":"": ""%>>6/60p </option>
	    
	    <option value="3/60" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("3/60")?"selected":"": ""%>>3/60 </option>
	    <option value="CF 5 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("CF 5 mt")?"selected":"": ""%>>CF 5 mt </option>
	    <option value="CF 4 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("CF 4 mt")?"selected":"": ""%>>CF 4 mt </option>
	    <option value="CF 3 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("CF 3 mt")?"selected":"": ""%>>CF 3 mt </option>
	    <option value="CF 2 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("CF 2 mt")?"selected":"": ""%>>CF 2 mt </option>
	    <option value="CF 1 mts" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("CF 1 mts")?"selected":"": ""%>>CF 1 mts </option>
	    <option value="CFCF" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("CFCF")?"selected":"": ""%>>CFCF </option>
	    <option value="PL +ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("PL +ve")?"selected":"": ""%>>PL +ve </option>
	    <option value="PL -ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("PL -ve")?"selected":"": ""%>>PL -ve </option>
	   <option value="NIG" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("NIG")?"selected":"": ""%>>NIG </option>
	   <option value="HM+" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("HM+")?"selected":"": ""%>>HM+ </option>
	  </select></td>
	  <td><select name="dist_l_uncorrected"><option value="">Select</option>
	  <option value="6/6-20/25" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/6-20/25")?"selected":"": ""%>>6/6-20/25</option>
	    <option value="6/6p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/6p")?"selected":"": ""%>>6/6p </option>
	    <option value="6/9-20/30" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/9-20/30")?"selected":"": ""%>>6/9-20/30 </option>
	    <option value="6/9p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/9p")?"selected":"": ""%>>6/9p </option>
	    <option value="6/12-20/40" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/12-20/40")?"selected":"": ""%>>6/12-20/40 </option>
	    <option value="6/12p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/12p")?"selected":"": ""%>>6/12p </option>
	    <option value="6/18-20/50" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/18-20/50")?"selected":"": ""%>>6/18-20/50 </option>
	    <option value="6/18p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/18p")?"selected":"": ""%>>6/18p</option>
	    <option value="6/24-20/70" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/24-20/70")?"selected":"": ""%>>6/24-20/70</option>
	    <option value="6/24p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/24p")?"selected":"": ""%>>6/24p </option>
	    <option value="6/36-20/100" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/36-20/100")?"selected":"": ""%>>6/36-20/100 </option>
	    <option value="6/36p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/36p")?"selected":"": ""%>>6/36p </option>
	    
	    <option value="6/60-20/200" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/60-20/200")?"selected":"": ""%>>6/60-20/200</option>
	    <option value="6/60p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/60p")?"selected":"": ""%>>6/60p </option>
	    <option value="3/60" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("3/60")?"selected":"": ""%>>3/60 </option>
	    <option value="CF 5 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("CF 5 mt")?"selected":"": ""%>>CF 5 mt </option>
	    <option value="CF 4 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("CF 4 mt")?"selected":"": ""%>>CF 4 mt </option>
	    <option value="CF 3 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("CF 3 mt")?"selected":"": ""%>>CF 3 mt </option>
	    <option value="CF 2 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("CF 2 mt")?"selected":"": ""%>>CF 2 mt </option>
	    <option value="CF 1 mts" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("CF 1 mts")?"selected":"": ""%>>CF 1 mts </option>
	    <option value="CFCF" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("CFCF")?"selected":"": ""%>>CFCF </option>
	    <option value="PL +ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("PL +ve")?"selected":"": ""%>>PL +ve </option>
	    <option value="PL -ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("PL -ve")?"selected":"": ""%>>PL -ve </option>
	    <option value="NIG" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("NIG")?"selected":"": ""%>>NIG </option>
	   <option value="HM+" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("HM+")?"selected":"": ""%>>HM+ </option>
</select></td>
	  <td><select name="dist_l_pinhole"><option value="">Select</option>
	  <option value="6/6-20/25" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/6-20/25")?"selected":"": ""%>>6/6-20/25</option>
	    <option value="6/6p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/6p")?"selected":"": ""%>>6/6p </option>
	    <option value="6/9-20/30" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/9-20/30")?"selected":"": ""%>>6/9-20/30 </option>
	    <option value="6/9p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/9p")?"selected":"": ""%>>6/9p </option>
	    <option value="6/12-20/40" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/12-20/40")?"selected":"": ""%>>6/12-20/40 </option>
	    <option value="6/12p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/12p")?"selected":"": ""%>>6/12p </option>
	    <option value="6/18-20/50" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/18-20/50")?"selected":"": ""%>>6/18-20/50 </option>
	    <option value="6/18p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/18p")?"selected":"": ""%>>6/18p </option>
	    <option value="6/24-20/70" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/24-20/70")?"selected":"": ""%>>6/24-20/70</option>
	    <option value="6/24p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/24p")?"selected":"": ""%>>6/24p </option>
	    <option value="6/36-20/100" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/36-20/100")?"selected":"": ""%>>6/36-20/100 </option>
	    <option value="6/36p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/36p")?"selected":"": ""%>>6/36p </option>
	    
	    <option value="6/60-20/200" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/60-20/200")?"selected":"": ""%>>6/60-20/200 </option>
	    <option value="6/60p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/60p")?"selected":"": ""%>>6/60p </option>
	    <option value="3/60" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("3/60")?"selected":"": ""%>>3/60 </option>
	    <option value="CF 5 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("CF 5 mt")?"selected":"": ""%>>CF 5 mt </option>
	    <option value="CF 4 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("CF 4 mt")?"selected":"": ""%>>CF 4 mt </option>
	    <option value="CF 3 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("CF 3 mt")?"selected":"": ""%>>CF 3 mt </option>
	    <option value="CF 2 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("CF 2 mt")?"selected":"": ""%>>CF 2 mt </option>
	    <option value="CF 1 mts" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("CF 1 mts")?"selected":"": ""%>>CF 1 mts </option>
	    <option value="CFCF" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("CFCF")?"selected":"": ""%>>CFCF </option>
	    <option value="PL +ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("PL +ve")?"selected":"": ""%>>PL +ve </option>
	    <option value="PL -ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("PL -ve")?"selected":"": ""%>>PL -ve </option>
	  <option value="NIG" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("NIG")?"selected":"": ""%>>NIG </option>
	   <option value="HM+" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("HM+")?"selected":"": ""%>>HM+ </option>
	  </select></td>
	  <td><select name="dist_l_best_corrected"><option value="">Select</option>
	  <option value="6/6-20/25" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/6-20/25")?"selected":"": ""%>>6/6-20/25</option>
	    <option value="6/6p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/6p")?"selected":"": ""%>>6/6p </option>
	    <option value="6/9-20/30" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/9-20/30")?"selected":"": ""%>>6/9-20/30 </option>
	    <option value="6/9p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/9p")?"selected":"": ""%>>6/9p </option>
	    <option value="6/12-20/40" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/12-20/40")?"selected":"": ""%>>6/12-20/40 </option>
	    <option value="6/12p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/12p")?"selected":"": ""%>>6/12p </option>
	    <option value="6/18-20/50" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/18-20/50")?"selected":"": ""%>>6/18-20/50 </option>
	    <option value="6/18p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/18p")?"selected":"": ""%>>6/18p </option>
	    <option value="6/24-20/70" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/24-20/70")?"selected":"": ""%>>6/24-20/70</option>
	    <option value="6/24p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/24p")?"selected":"": ""%>>6/24p </option>
	    <option value="6/36-20/100" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/36-20/100")?"selected":"": ""%>>6/36-20/100 </option>
	    <option value="6/36p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/36p")?"selected":"": ""%>>6/36p </option>
	    
	    <option value="6/60-20/200" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/60-20/200")?"selected":"": ""%>>6/60-20/200 </option>
	    <option value="6/60p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/60p")?"selected":"": ""%>>6/60p </option>
	    <option value="3/60" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("3/60")?"selected":"": ""%>>3/60 </option>
	    <option value="CF 5 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("CF 5 mt")?"selected":"": ""%>>CF 5 mt </option>
	    <option value="CF 4 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("CF 4 mt")?"selected":"": ""%>>CF 4 mt </option>
	    <option value="CF 3 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("CF 3 mt")?"selected":"": ""%>>CF 3 mt </option>
	    <option value="CF 2 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("CF 2 mt")?"selected":"": ""%>>CF 2 mt </option>
	    <option value="CF 1 mts" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("CF 1 mts")?"selected":"": ""%>>CF 1 mts </option>
	    <option value="CFCF" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("CFCF")?"selected":"": ""%>>CFCF </option>
	    <option value="PL +ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("PL +ve")?"selected":"": ""%>>PL +ve </option>
	    <option value="PL -ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("PL -ve")?"selected":"": ""%>>PL -ve </option>
	   <option value="NIG" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("NIG")?"selected":"": ""%>>NIG </option>
	   <option value="HM+" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("HM+")?"selected":"": ""%>>HM+ </option>
	  </select></td>
	  </tr>
	    <tr><th>Near</th>
	  <td><select name="near_r_uncorrected"><option value="">Select</option>
	  <option value="N4-J1" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N4-J1")?"selected":"": ""%>>N4-J1</option>
	   <option value="N5-J2" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N5-J2")?"selected":"": ""%>>N5-J2</option>
	   <option value="N6-J3" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N6-J3")?"selected":"": ""%>>N6-J3</option>
	   <option value="N7-J4" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N7-J4")?"selected":"": ""%>>N7-J4</option>
	    <option value="N8-J5" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N8-J5")?"selected":"": ""%>>N8-J5</option>
	    <option value="N9-J6" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N9-J6")?"selected":"": ""%>>N9-J6</option>
	   <option value="N10-J7" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N10-J7")?"selected":"": ""%>>N10-J7</option>
	   <option value="N11-J8" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N11-J8")?"selected":"": ""%>>N11-J8</option>
	   <option value="N12" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N12")?"selected":"": ""%>>N12</option>
	   <option value="N14" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N14")?"selected":"": ""%>>N14</option>
	   <option value="N18" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N18")?"selected":"": ""%>>N18</option>
	   <option value="N24" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N24")?"selected":"": ""%>>N24</option>
	   <option value="N36" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N36")?"selected":"": ""%>>N36</option>
	   <option value="NOT Possible" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("NOT Possible")?"selected":"": ""%>>NOT Possible</option>
	  </select>
	  </td>
	  <td><select name="near_r_pinhole"><option value="">Select</option>
	   <option value="N4-J1" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N4-J1")?"selected":"": ""%>>N4-J1</option>
	     <option value="N5-J2" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N5-J2")?"selected":"": ""%>>N5-J2</option>
	   <option value="N6-J3" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N6-J3")?"selected":"": ""%>>N6-J3</option>
	 <option value="N7-J4" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N7-J4")?"selected":"": ""%>>N7-J4</option>
	   <option value="N8-J5" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N8-J5")?"selected":"": ""%>>N8-J5</option>
	  <option value="N9-J6" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N9-J6")?"selected":"": ""%>>N9-J6</option>
	   <option value="N10-J7" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N10-J7")?"selected":"": ""%>>N10-J7</option>
	    <option value="N11-J8" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N11-J8")?"selected":"": ""%>>N11-J8</option>
	   <option value="N12" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N12")?"selected":"": ""%>>N12</option>
	   <option value="N14" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N14")?"selected":"": ""%>>N14</option>
	   <option value="N18" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N18")?"selected":"": ""%>>N18</option>
	   <option value="N24" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N24")?"selected":"": ""%>>N24</option>
	   <option value="N36" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N36")?"selected":"": ""%>>N36</option>
	   <option value="NOT Possible" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("NOT Possible")?"selected":"": ""%>>NOT Possible</option>
	  </select>
	  </td>
	  <td><select name="near_r_best_corrected"><option value="">Select</option>
	   <option value="N4-J1" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N4-J1")?"selected":"": ""%>>N4-J1</option>
	     <option value="N5-J2" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N5-J2")?"selected":"": ""%>>N5-J2</option>
	   <option value="N6-J3" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N6-J3")?"selected":"": ""%>>N6-J3</option>
	 <option value="N7-J4" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N7-J4")?"selected":"": ""%>>N7-J4</option>
	   <option value="N8-J5" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N8-J5")?"selected":"": ""%>>N8-J5</option>
	  <option value="N9-J6" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N9-J6")?"selected":"": ""%>>N9-J6</option>
	   <option value="N10-J7" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N10-J7")?"selected":"": ""%>>N10-J7</option>
	   <option value="N11-J8" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N11-J8")?"selected":"": ""%>>N11-J8</option>
	   <option value="N12" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N12")?"selected":"": ""%>>N12</option>
	   <option value="N14" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N14")?"selected":"": ""%>>N14</option>
	   <option value="N18" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N18")?"selected":"": ""%>>N18</option>
	   <option value="N24" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N24")?"selected":"": ""%>>N24</option>
	   <option value="N36" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N36")?"selected":"": ""%>>N36</option>
	   <option value="NOT Possible" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("NOT Possible")?"selected":"": ""%>>NOT Possible</option>
	  </select>
	  </td>
	  <td><select name="near_l_uncorrected"><option value="">Select</option>
	   <option value="N4-J1" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N4-J1")?"selected":"": ""%>>N4-J1</option>
	    <option value="N5-J2" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N5-J2")?"selected":"": ""%>>N5-J2</option>
	   <option value="N6-J3" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N6-J3")?"selected":"": ""%>>N6-J3</option>
	  <option value="N7-J4" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N7-J4")?"selected":"": ""%>>N7-J4</option>
	   <option value="N8-J5" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N8-J5")?"selected":"": ""%>>N8-J5</option>
	  <option value="N9-J6" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N9-J6")?"selected":"": ""%>>N9-J6</option>
	   <option value="N10-J7" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N10-J7")?"selected":"": ""%>>N10-J7</option>
	   <option value="N11-J8" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N11-J8")?"selected":"": ""%>>N11-J8</option>
	   <option value="N12" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N12")?"selected":"": ""%>>N12</option>
	   <option value="N14" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N14")?"selected":"": ""%>>N14</option>
	   <option value="N18" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N18")?"selected":"": ""%>>N18</option>
	   <option value="N24" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N24")?"selected":"": ""%>>N24</option>
	   <option value="N36" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N36")?"selected":"": ""%>>N36</option>
	   <option value="NOT Possible" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("NOT Possible")?"selected":"": ""%>>NOT Possible</option>
	  </select>
	  </td>
	  <td><select name="near_l_pinhole"><option value="">Select</option>
	   <option value="N4-J1" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N4-J1")?"selected":"": ""%>>N4-J1</option>
	     <option value="N5-J2" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N5-J2")?"selected":"": ""%>>N5-J2</option>
	   <option value="N6-J3" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N6-J3")?"selected":"": ""%>>N6-J3</option>
	   <option value="N7-J4" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N7-J4")?"selected":"": ""%>>N7-J4</option>
	   <option value="N8-J5" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N8-J5")?"selected":"": ""%>>N8-J5</option>
	  <option value="N9-J6" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N9-J6")?"selected":"": ""%>>N9-J6</option>
	   <option value="N10-J7" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N10-J7")?"selected":"": ""%>>N10-J7</option>
	    <option value="N11-J8" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N11-J8")?"selected":"": ""%>>N11-J8</option>
	   <option value="N12" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N12")?"selected":"": ""%>>N12</option>
	   <option value="N14" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N14")?"selected":"": ""%>>N14</option>
	   <option value="N18" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N18")?"selected":"": ""%>>N18</option>
	   <option value="N24" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N24")?"selected":"": ""%>>N24</option>
	   <option value="N36" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N36")?"selected":"": ""%>>N36</option>
	   <option value="NOT Possible" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("NOT Possible")?"selected":"": ""%>>NOT Possible</option>
	  </select>
	  </td>
	  <td><select name="near_l_best_corrected"><option value="">Select</option>
	   <option value="N4-J1" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N4-J1")?"selected":"": ""%>>N4-J1</option>
	     <option value="N5-J2" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N5-J2")?"selected":"": ""%>>N5-J2</option>
	   <option value="N6-J3" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N6-J3")?"selected":"": ""%>>N6-J3</option>
	  <option value="N7-J4" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N7-J4")?"selected":"": ""%>>N7-J4</option>
	   <option value="N8-J5" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N8-J5")?"selected":"": ""%>>N8-J5</option>
	   <option value="N9-J6" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N9-J6")?"selected":"": ""%>>N9-J6</option>
	   <option value="N10-J7" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N10-J7")?"selected":"": ""%>>N10-J7</option>
	    <option value="N11-J8" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N11-J8")?"selected":"": ""%>>N11-J8</option>
	   <option value="N12" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N12")?"selected":"": ""%>>N12</option>
	   <option value="N14" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N14")?"selected":"": ""%>>N14</option>
	   <option value="N18" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N18")?"selected":"": ""%>>N18</option>
	   <option value="N24" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N24")?"selected":"": ""%>>N24</option>
	   <option value="N36" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N36")?"selected":"": ""%>>N36</option>
	   <option value="NOT Possible" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("NOT Possible")?"selected":"": ""%>>NOT Possible</option>
	  </select>
	  </td>
     </tr>	  
<!-- 	  <tr><th>Near</th>
	  <td><select name="near_r_uncorrected"><option value="">Select</option><option>N5</option><option>N6</option><option>N8</option><option>N10</option><option>N12</option><option>N14</option><option>N18</option><option>N14</option><option>N18</option><option>N24</option><option>N36</option></select></td>
	  <td><select name="near_r_pinhole"><option value="">Select</option><option>N5</option><option>N6</option><option>N8</option><option>N10</option><option>N12</option><option>N14</option><option>N18</option><option>N14</option><option>N18</option><option>N24</option><option>N36</option></select></td>
	  <td><select name="near_r_best_corrected"><option value="">Select</option><option>N5</option><option>N6</option><option>N8</option><option>N10</option><option>N12</option><option>N14</option><option>N18</option><option>N14</option><option>N18</option><option>N24</option><option>N36</option></select></td>
	  <td><select name="near_l_uncorrected"><option value="">Select</option><option>N5</option><option>N6</option><option>N8</option><option>N10</option><option>N12</option><option>N14</option><option>N18</option><option>N14</option><option>N18</option><option>N24</option><option>N36</option></select></td>
	  <td><select name="near_l_pinhole"><option value="">Select</option><option>N5</option><option>N6</option><option>N8</option><option>N10</option><option>N12</option><option>N14</option><option>N18</option><option>N14</option><option>N18</option><option>N24</option><option>N36</option></select></td>
	  <td><select name="near_l_best_corrected"><option value="">Select</option><option>N5</option><option>N6</option><option>N8</option><option>N10</option><option>N12</option><option>N14</option><option>N18</option><option>N14</option><option>N18</option><option>N24</option><option>N36</option></select></td>
</tr>	  --> 
	</table>
	<div class="clear"></div>
	<%-- <label>IPD</label><input type="text" name="vision_ipd" maxlength="50" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getVisionIpd()!=null?opdOphthalmologyDetails.get(0).getVisionIpd():"": ""%>"/><label class="unit">mm</label> --%>
	<label>Fundus Glow</label><input type="text" class="large" name="vision_fundus" maxlength="50" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getVisionFundus()!=null?opdOphthalmologyDetails.get(0).getVisionFundus():"": ""%>"/>
	<div class="clear"></div><div class="clear"></div>
	
	
	<h4>Retinoscopy</h4>
	<table border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr><th></th><th colspan="2" style="text-align: center;">R.E.</th><th colspan="2"style="text-align: center;">L.E.</th></tr>
	  <tr><th></th><th></th><th>Axis</th><th></th><th>Axis</th></tr>
	  <tr><th>V</th><td><input type="text" name="retinoscopy_re_v"  maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinoscopyReV()!=null?opdOphthalmologyDetails.get(0).getRetinoscopyReV():"": ""%>" /></td><td><input value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinoscopyReAxis()!=null?opdOphthalmologyDetails.get(0).getRetinoscopyReAxis():"": ""%>" name="retinoscopy_re_axis" maxlength="5"/></td><td><input type="text" name="retinoscopy_le_v"  maxlength="20"  value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinoscopyLeV()!=null?opdOphthalmologyDetails.get(0).getRetinoscopyLeV():"": ""%>" /></td><td><input value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinoscopyLeAxis()!=null?opdOphthalmologyDetails.get(0).getRetinoscopyLeAxis():"": ""%>" name="retinoscopy_le_axis" maxlength="5"/></td></tr>
	  <tr><th>H</th><td><input type="text" name="retinoscopy_re_h"  maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinoscopyReH()!=null?opdOphthalmologyDetails.get(0).getRetinoscopyReH():"": ""%>" /></td><td></td><td><input type="text" name="retinoscopy_le_h"  maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinoscopyLeH()!=null?opdOphthalmologyDetails.get(0).getRetinoscopyLeH():"": ""%>" /></td><td></td></tr>
	   
	</table>
	<div class="cmntable">
	<table border="0" align="center" cellpadding="0" cellspacing="0">
	
	  <tr><th colspan="5" style="text-align: center;">R.E.</th><th colspan="5"style="text-align: center;">L.E.</th></tr>
	  <tr><th>Keratometry</th><th>Pachymetry</th><th>Non-contact Tonometry</th><th>Field of VN</th><th>IOL</th><th>Keratometry</th><th>Pachymetry</th><th>Non-contact Tonometry</th><th>Field of VN</th><th>IOL</th></tr>
	  <tr><td><input type="text"  size="30" name="re_keratometry" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReKeratometry()!=null?opdOphthalmologyDetails.get(0).getReKeratometry():"": ""%>" maxlength="40" size="6"/><label class="auto">D</label></td><td><input type="text" name="re_pachymetry" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRePachymetry()!=null?opdOphthalmologyDetails.get(0).getRePachymetry():"": ""%>" maxlength="20" size="6"/><label class="auto">UM</label></td><td><input type="text" name="re_Non_contact_tonometry" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReNonContactTonometry()!=null?opdOphthalmologyDetails.get(0).getReNonContactTonometry():"": ""%>" maxlength="20"size="10"/><label class="auto">mm of Hg</label></td><td><input type="text" name="re_field_vn" maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReFieldVn()!=null?opdOphthalmologyDetails.get(0).getReFieldVn():"": ""%>"/></td><td><input type="text" name="iol_re" maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getIolRe()!=null?opdOphthalmologyDetails.get(0).getIolRe():"": ""%>"/></td><td><input type="text" size="30" name="le_keratometry" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeKeratometry()!=null?opdOphthalmologyDetails.get(0).getLeKeratometry():"": ""%>"  maxlength="40"size="6"/><label class="auto">D</label></td><td><input type="text" name="le_pachymetry" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLePachymetry()!=null?opdOphthalmologyDetails.get(0).getLePachymetry():"": ""%>"  maxlength="20"size="6"/><label class="auto">UM</label></td><td><input type="text" name="le_Non_contact_tonometry" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeNonContactTonometry()!=null?opdOphthalmologyDetails.get(0).getLeNonContactTonometry():"": ""%>"  maxlength="20"size="10"/><label class="auto">mm of Hg</label></td><td><input type="text" name="le_field_vn"  maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeFieldVn()!=null?opdOphthalmologyDetails.get(0).getLeFieldVn():"": ""%>"/></td><td><input type="text" name="iol_le" maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getIolLe()!=null?opdOphthalmologyDetails.get(0).getIolLe():"": ""%>"/></td></tr>
	</table>
	</div>
	<h4>Spectacle Correction</h4>
	<table border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr><th></th><th colspan="3" style="text-align: center;">R.E.</th><th colspan="3"style="text-align: center;">L.E.</th></tr>
	  <tr><th></th><th>SPH</th><th>CYL</th><th>Axis</th><th>SPH</th><th>CYL</th><th>Axis</th></tr>
	  <tr><th>Dist</th><td><input type="text" name="dist_r_sph" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRSph()!=null?opdOphthalmologyDetails.get(0).getDistRSph():0: 0%>" validate="R.E Dist SPH,string,no" maxlength="20"/></td><td><input type="text" onblur="copyValues();" id="dist_r_cyl" name="dist_r_cyl" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRCyl()!=null?opdOphthalmologyDetails.get(0).getDistRCyl():0: 0%>" validate="R.E Dist CYL,string,no" maxlength="20"/></td><td><input type="text" onblur="copyValues();" id="dist_r_axix" name="dist_r_axix" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRAxis()!=null?opdOphthalmologyDetails.get(0).getDistRAxis():0: 0%>"validate="R.E Dist Axix,string,no" maxlength="20"/></td><td><input type="text" name="dist_l_sph" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLSph()!=null?opdOphthalmologyDetails.get(0).getDistLSph():0: 0%>" validate="L.E Dist SPH,string,no" maxlength="20"/></td><td><input type="text" onblur="copyValues();" id="dist_l_cyl" name="dist_l_cyl" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLCyl()!=null?opdOphthalmologyDetails.get(0).getDistLCyl():0: 0%>" validate="L.E DistCYL,string,no" maxlength="20"/></td><td><input type="text" onblur="copyValues();" id="dist_l_axix" name="dist_l_axix" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLAxis()!=null?opdOphthalmologyDetails.get(0).getDistLAxis():0: 0%>" validate="L.E Dist Axix,string,no" maxlength="20"/></td></tr>
	  <tr><th>Near</th><td><input type="text" name="near_r_sph" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRSph()!=null?opdOphthalmologyDetails.get(0).getNearRSph():0: 0%>" validate="R.E Near SPH,string,no" maxlength="20"/></td><td><input type="text" id="near_r_cyl"  name="near_r_cyl"value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRCyl()!=null?opdOphthalmologyDetails.get(0).getNearRCyl():0: 0%>" validate="R.E Near CYL,string,no" maxlength="20"/></td><td><input type="text"  id="near_r_axix" name="near_r_axix" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRAxis()!=null?opdOphthalmologyDetails.get(0).getNearRAxis():0: 0%>" validate="R.ENear Axix ,string,no" maxlength="20"/></td><td><input type="text" name="near_l_sph" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLSph()!=null?opdOphthalmologyDetails.get(0).getNearLSph():0: 0%>" validate="L.E Near SPH,string,no" maxlength="20"/></td><td><input type="text" id="near_l_cyl" name="near_l_cyl" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLCyl()!=null?opdOphthalmologyDetails.get(0).getNearLCyl():0: 0%>" validate="L.E Near CYL,string,no" maxlength="20"/></td><td><input type="text" id="near_l_axix" name="near_l_axix" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLAxis()!=null?opdOphthalmologyDetails.get(0).getNearLAxis():0: 0%>" validate="L.E Near Axix,string,no" maxlength="20"/></td></tr>
	</table>
	<label>IPD(50-70)</label> <input type="text" name="eye_ipd" maxlength="2" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getEyeIpd()!=null?opdOphthalmologyDetails.get(0).getEyeIpd():"": ""%>" validate="Eye IPD ,string,no">
	
	<label>Use</label><select name="eye_use"><option value="">Select</option>
	<%
	if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getEyeUse()!=null && opdOphthalmologyDetails.get(0).getEyeUse().equalsIgnoreCase("Constant")){%>
	    <option selected="selected">Constant</option>
	<%}else{%> 
	 <option>Constant</option>
	
	<%}if(opdOphthalmologyDetails.size()>0 &&  opdOphthalmologyDetails.get(0).getEyeUse()!=null && opdOphthalmologyDetails.get(0).getEyeUse().equalsIgnoreCase("Near")){%>
	<option selected="selected">Near</option>
	<%}else{%>
		<option>Near</option>
	<%}if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getEyeUse()!=null &&  opdOphthalmologyDetails.get(0).getEyeUse().equalsIgnoreCase("Distance")){%>
	<option selected="selected" >Distance</option>
	<%}else{%>
	<option >Distance</option>
	<%} %>
	</select>
	<label>Type of Lens</label><select name="lensType"><option value="">Select</option>
	<%
	if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getLensType()!=null && opdOphthalmologyDetails.get(0).getLensType().equalsIgnoreCase("Kryptok")){%>
	    <option selected="selected">Kryptok</option>
	<%}else{%> 
	 <option>Kryptok</option>
	
	<%}if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getLensType()!=null && opdOphthalmologyDetails.get(0).getLensType().equalsIgnoreCase("Executive/Bifocal")){%>
	<option selected="selected">Executive/Bifocal</option>
	<%}else{%>
		<option>Executive/Bifocal</option>
	<%}if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getLensType()!=null && opdOphthalmologyDetails.get(0).getLensType().equalsIgnoreCase("Progressive")){%>
	<option selected="selected" >Progressive</option>
	<%}else{%>
	<option >Progressive</option>
	<%} %>
	</select>

	<h4>On Examination:</h4>
	<h4>Anterior Segment</h4>
	<div class="cmntable">
		<table border="0" align="center" cellpadding="0" cellspacing="0">
		<!--   <tr><th colspan="13" style="text-align: center;">R.E.</th><th colspan="13"style="text-align: center;">L.E.</th></tr> -->
		  <tr><th></th><th>Eyebrow</th><th>Eyelid</th><th>Cornea</th><th>Conjunctiva</th><th>Fornix</th><th>Limbus</th><th>Sclera</th><th>Anterior Chamber</th><th>Iris</th><th>Pupils</th><th>Lens</th><th>Anterior</th><th>Vitreous</th><!-- <th>Eyebrow</th><th>Eyelid</th><th>Cornea</th><th>Conjunctiva</th><th>Fornix</th><th>Limbus</th><th>Sclera</th><th>Anterior Chamber</th><th>Iris</th><th>Pupils</th><th>Lens</th><th>Anterior</th><th>Vitreous</th> --></tr>
		  <tr><th>R.E</th><td><input type="text" name="re_eyebrow"  maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReEyebrow()!=null?opdOphthalmologyDetails.get(0).getReEyebrow():"N": "N"%>"/></td><td><input type="text" name="re_eyelid" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReEyelid()!=null?opdOphthalmologyDetails.get(0).getReEyelid():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_cornea" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReCornea()!=null?opdOphthalmologyDetails.get(0).getReCornea():"N": "N"%>" maxlength="20" /></td><td><input type="text" name="re_conjunction" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReConjunction()!=null?opdOphthalmologyDetails.get(0).getReConjunction():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_fornix" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReFornix()!=null?opdOphthalmologyDetails.get(0).getReFornix():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_limbus" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReLimbus()!=null?opdOphthalmologyDetails.get(0).getReLimbus():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_sclera" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReSclera()!=null?opdOphthalmologyDetails.get(0).getReSclera():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_anterior_chamber" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReAnteriorChamber()!=null?opdOphthalmologyDetails.get(0).getReAnteriorChamber():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_iris" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReIris()!=null?opdOphthalmologyDetails.get(0).getReIris():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_pupils" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRePupils()!=null?opdOphthalmologyDetails.get(0).getRePupils():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_Lens" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReLens()!=null?opdOphthalmologyDetails.get(0).getReLens():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_anterior" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReAnterior()!=null?opdOphthalmologyDetails.get(0).getReAnterior():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_vitreous" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReVitreousAnterior()!=null?opdOphthalmologyDetails.get(0).getReVitreousAnterior():"N": "N"%>" maxlength="20"/></td></tr>
		  	       <tr><th>L.E.</th><td><input type="text" name="le_eyebrow" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeEyebrow()!=null?opdOphthalmologyDetails.get(0).getLeEyebrow():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_eyelid" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeEyelid()!=null?opdOphthalmologyDetails.get(0).getLeEyelid():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_cornea" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeCornea()!=null?opdOphthalmologyDetails.get(0).getLeCornea():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_conjunction" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeConjunction()!=null?opdOphthalmologyDetails.get(0).getLeConjunction():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_fornix" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeFornix()!=null?opdOphthalmologyDetails.get(0).getLeFornix():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_limbus" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeLimbus()!=null?opdOphthalmologyDetails.get(0).getLeLimbus():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_sclera" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeSclera()!=null?opdOphthalmologyDetails.get(0).getLeSclera():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_anterior_chamber" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeAnteriorChamber()!=null?opdOphthalmologyDetails.get(0).getLeAnteriorChamber():"N": "N"%>"maxlength="20"/></td><td><input type="text" name="le_iris"value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeIris()!=null?opdOphthalmologyDetails.get(0).getLeIris():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_pupils" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLePupils()!=null?opdOphthalmologyDetails.get(0).getLePupils():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_Lens" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeLens()!=null?opdOphthalmologyDetails.get(0).getLeLens():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_anterior" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeAnterior()!=null?opdOphthalmologyDetails.get(0).getLeAnterior():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_vitreous" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeVitreousAnterior()!=null?opdOphthalmologyDetails.get(0).getLeVitreousAnterior():"N": "N"%>" maxlength="20"/></td></tr>
	 
		</table>
	 </div>

	<h4>Posterior Segment</h4>
	<div class="cmntable">
	<table border="0" align="center" cellpadding="0" cellspacing="0">
	<!--   <tr><th colspan="4" style="text-align: center;">R.E.</th><th colspan="4"style="text-align: center;">L.E.</th></tr> -->
	  <tr><th></th><th>Optic Disc</th><th>Fovea and Macula</th><th>Vitreous</th><th>Blood Vessels</th><th>Retina</th></tr>
	  <tr><th>R.E.</th><td><input type="text" name="re_optic_disc" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReOpticDisc()!=null?opdOphthalmologyDetails.get(0).getReOpticDisc():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_fovea" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReFovea()!=null?opdOphthalmologyDetails.get(0).getReFovea():"N": "N"%>" maxlength="20"/><td><input type="text" name="re_vitreous_posterior" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReVitreousPosterior()!=null?opdOphthalmologyDetails.get(0).getReVitreousPosterior():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_blood_vessels" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReBloodVessels()!=null?opdOphthalmologyDetails.get(0).getReBloodVessels():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="retina_re" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinaRe()!=null?opdOphthalmologyDetails.get(0).getRetinaRe():"N": "N"%>" maxlength="20"/></td></tr>
	  <tr><th>L.E.</th><td><input type="text" name="le_optic_disc" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeOpticDisc()!=null?opdOphthalmologyDetails.get(0).getLeOpticDisc():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_fovea" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeFovea()!=null?opdOphthalmologyDetails.get(0).getLeFovea():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_vitreous_posterior" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeVitreousPosterior()!=null?opdOphthalmologyDetails.get(0).getLeVitreousPosterior():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_blood_vessels" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeBloodVessels()!=null?opdOphthalmologyDetails.get(0).getLeBloodVessels():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="retina_le" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinaLe()!=null?opdOphthalmologyDetails.get(0).getRetinaLe():"N": "N"%>" maxlength="20"/></td></tr>
	</table>
	</div>
	<h4>Colour Vision</h4>
	<table border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr><th colspan="1" style="text-align: center;">R.E.</th><th colspan="1"style="text-align: center;">L.E.</th></tr>
	  <tr><td>
	  
	  	  <select name="re_colour_vision"><option value="">Select</option>
	<%
	if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getReColourVision()!=null && opdOphthalmologyDetails.get(0).getReColourVision().equalsIgnoreCase("Normal")){%>
	    <option selected="selected">Normal</option>
	<%}else{%> 
	 <option>Normal</option>
	
	<%}if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getReColourVision()!=null && opdOphthalmologyDetails.get(0).getReColourVision().equalsIgnoreCase("Defective")){%>
	<option selected="selected">Defective</option>
	<%}else{%>
		<option>Defective</option>
	<%}%>
	</select>
	  
	  </td>
	  <td>
	  	  <select name="le_colour_vision"><option value="">Select</option>
	<%
	if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getLeColourVision()!=null && opdOphthalmologyDetails.get(0).getLeColourVision().equalsIgnoreCase("Normal")){%>
	    <option selected="selected">Normal</option>
	<%}else{%> 
	 <option>Normal</option>
	
	<%}if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getLeColourVision()!=null && opdOphthalmologyDetails.get(0).getLeColourVision().equalsIgnoreCase("Defective")){%>
	<option selected="selected">Defective</option>
	<%}else{%>
		<option>Defective</option>
	<%}%>
	</select>
	  
	  </td></tr>
	  

	  
	  
	  </table>
	  
	
	</div>
	
	
	
	<%} %>
	
	
	<div class="clear paddingTop15"></div>
	
	<h4>Vitals</h4>
	<div class="Block">
		<label class="">Weight</label> <input name="weight" tabindex="1"
			type="text" id="weight"
			value="<%=opdDetailsForFollowup !=null && opdDetailsForFollowup.getVweight()!=null?opdDetailsForFollowup.getVweight():"" %>"
			onblur="calculateBMI()" class="auto" size="5"
			validate="weight,float,no" maxlength="6" /> <label class="unit">kg</label>

		<label class="">Height</label> <input name="height" tabindex="1"
			type="text" id="height"
			value="<%=opdDetailsForFollowup !=null && opdDetailsForFollowup.getHeight() != null ?opdDetailsForFollowup.getHeight():"" %>"
			class="auto" onblur="calculateIdealWeight();calculateBMI();" size="5"
			validate="height,float,no" maxlength="6" /> <label class="unit">cm</label>

		<label class="">BMI</label> <input tabindex="1" type="text" id="bmi"
			name="bmi" readonly="readonly" maxlength="6"
			value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getBmi() != null ? opdDetailsForFollowup.getBmi():"" %>"
			onKeyUp="limitText(this,6);" class="auto" size="5" /> <label
			class="unit">kg/m<sup>2</sup></label>
		<div class="clear"></div>
		<label class="">Ideal Weight</label> <input name="idealWeight"
			type="text" id="idealWeightId" tabindex="1" class="auto" size="5"
			value="<%=opdDetailsForFollowup!= null && opdDetailsForFollowup.getIdealWeight()!= null ?opdDetailsForFollowup.getIdealWeight():"" %>"
			tabindex="1" validate="Ideal Weight,float,no" maxlength="3" /> <label
			class="unit">kg</label> <label class="">Temperature</label> <input
			name="temperature" id="tempId" type="text"
			validate="Temperature,float,no" tabindex="1"
			value="<%=opdDetailsForFollowup!= null && opdDetailsForFollowup.getTemperature()!= null?opdDetailsForFollowup.getTemperature():"" %>"
			class="auto" size="5" onblur="convertFarenhiteToCelcius();"
			maxlength="5" /> <label class="unit">&deg;F</label> <label class="">Temperature</label>
		<input name="temperature" id="tempInCelciusId" type="text"
			tabindex="1" value="" class="auto" size="5" maxlength="5"
			onblur="convertCelciusToFarenhite();" /> <label class="unit">&deg;C</label>
		<div class="clear"></div>
		<label class="">Pulse</label> <input name="pulse" type="text"
			tabindex="1"
			value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getPulse() != null?opdDetailsForFollowup.getPulse():"" %>"
			class="auto" size="5" tabindex="1" validate="pulse,int,no"
			maxlength="3" /> <label class="unit">/min</label> <label class="">BP</label>
		<input name="bp" id="bp" type="text" tabindex="1"
			value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getBp()!= null?opdDetailsForFollowup.getBp():"" %>"
			class="auto" size="5"
			onblur="if(this.value!=''){validateBpValue(this.value)};"
			maxlength="7" /> <label class="unit">mm/Hg</label> <label class="">RR</label>
		<input name="rr" id="rr" type="text" tabindex="1"
			value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getRr()!= null?opdDetailsForFollowup.getRr():"" %>"
			class="auto" size="5" maxlength="3" validate="RR,int,no" /> <label
			class="unit">/min</label><div class="clear"></div>
	<%if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForOBG)) {%>
			<label class="">PR</label>
			<select name="pr" class="small"><option value="">Select</option>	      
				 <%for(int i=80;i<=130;i++) {%>
				 <option <%= opdDetailsForFollowup!=null?opdDetailsForFollowup.getPr()!=null?opdDetailsForFollowup.getPr()==i?"selected":"":"":""%>><%=i%></option>
				 <%} %>
				 </select>
			<!-- <input name="pr" id="pr" type="text" tabindex="1" class="auto" size="5" maxlength="3" validate="PR,int,no" /><div style="float: left; width: 48px;">&nbsp; </div> -->
			<!-- <label class="">SP</label>
			<input name="sp" id="sp" type="text" tabindex="1" class="auto" size="5" maxlength="3" validate="SP,int,no" /><div style="float: left; width: 48px;">&nbsp; </div>
			<label class="">BST</label>
			<input name="bst" id="bst" type="text" tabindex="1" class="auto" size="5" maxlength="3" validate="bst,int,no" /><div style="float: left; width: 48px;">&nbsp; </div><div class="clear"></div> -->
			<label class="">Breast</label>
			<select name="breast"><option value="">Select</option><option>Normal</option><option>Inverted/Flat Nipple</option></select>	
			<!-- 	<label class="">Spine</label>
			<select name="spine"><option value="">Select</option><option>A1</option><option>Ab</option></select> -->
			     <label class="auto">Auscultation : Fetal  Heart Rate - Regular</label>
	           <select name="heart_rate_regular" class="smaller"><option value="">Select</option>
	            <option>0</option>
	             <%for(int i=90;i<=180;){ 
	        	   if(obgDetails.getHeartRateRegular()!=null &&obgDetails.getHeartRateRegular()==i){
	   	        	%>	
	   	        	  <option selected="selected"><%=i%></option>
	   	        	<%} else{
	   	        	%>
	       <option><%=i%></option>
	       <%}i+=10; }%></select>	
	<%} %>
		<div class="clear"></div>

		<label>On Examination</label>

		<textarea name="onExamination" cols="118" rows="0" value=""
			maxlength="500" class="auto" tabindex="1"
			onkeyup="return ismaxlength(this)"><%=opdDetailsForFollowup != null && opdDetailsForFollowup.getOnExamination()!= null?opdDetailsForFollowup.getOnExamination():"" %></textarea>
		<div class="clear"></div>

		<input type="hidden" name="userName" value="<%=userName %>" />
		<div class="clear"></div>
	</div>
	
<!-- OBG details -->
	 <%if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForOBG)) {%>
<h4>OBG Details</h4><input class="button" tabindex="3" name="obgBtn" id="obgBtn"value="+" onclick="toggleDiv('obg','obgBtn')" type="button" style="padding: 1px;width: 20px;height: 18px;">	       
<div class="Block" id="obg"> 
	     
	     <label class="auto">Obstetric History</label> 	<select name="obg_history" class="small"><option value="">Select</option>
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
	     <label class="auto">Obstetric Score</label>
	     <label class="auto">G</label>
	     <select name="obstetric_score_g" class="smaller">
	     <option value="">Select</option>
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
	       <!-- <label class="auto">Obstetric Score</label> -->
	       <label class="auto">P</label>
	       <select name="obstetric_score_p" class="smaller">
	       <option value="">Select</option>
	        <%for(int i=0;i<=9;i++){ 
	        	   if(obgDetails.getObstreticScoreP()!=null && obgDetails.getObstreticScoreP()==i){
	   	        	%>	
	   	        	  <option selected="selected"><%=i%></option>
	   	        	<%} else{
	   	        	%>
	       <option><%=i%></option>
	       <%} }%>
	     </select>
	     
	       <!-- <label class="auto">Obstetric Score</label> -->
	        <label class="auto">A</label>
	       
	       <select name="obstetric_score_a" class="smaller">
	       <option value="">Select</option>
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
	        
	      <!--  <label>Obstetric Score</label> -->
	        <label class="auto">L</label>
	       <select name="obstetric_score_l" class="smaller"><option value="">Select</option>
	        <%for(int i=0;i<=9;i++){ if(obgDetails.getObstreticScoreL()!=null &&obgDetails.getObstreticScoreL()==i){
	        	%>	
	        	  <option selected="selected"><%=i%></option>
	        	<%} else{
	        	%>
	       <option><%=i%></option>
	       <%} }%>
	     </select>
	      
	     
	     <label class="auto">Conception</label><select name="conception" class="small"><option value="">Select</option>
	      <%
	if(obgDetails.getConception()!=null && obgDetails.getConception().equalsIgnoreCase("Spontaneous")){%>
	    <option selected="selected">Spontaneous</option>
	<%}else{%> 
	 <option>Spontaneous</option>
				<%}if(obgDetails.getConception()!=null && obgDetails.getConception().equalsIgnoreCase("Assisted-OI/IUI/IVF")){%>
	    <option selected="selected">Assisted-OI/IUI/IVF</option>
	<%}else{%>
			<option>Assisted-OI/IUI/IVF</option>
			<%} %>	
	   </select>
	   <div class="clear"></div>
	   
	     <label class="auto">Married Life</label><input type="text" name="total_marriage_year" maxlength="10" value="<%=obgDetails.getMarriedLife()!=null?obgDetails.getMarriedLife():""%>">
	    
	     
	     <label class"auto">Consan Guinity</label>
	     <select name="consan" class="smaller">
	     <option value="">Select</option>
	     	      
			<%if(obgDetails.getConsanGuinity()!=null && obgDetails.getConsanGuinity().equalsIgnoreCase("I")){%>
			    <option selected="selected">I</option><%}else{%> 
			 <option>I</option><%}if(obgDetails.getConsanGuinity()!=null && obgDetails.getConsanGuinity().equalsIgnoreCase("II")){%>
			    <option selected="selected">II</option>
			<%}else{%><option>II</option><%}if(obgDetails.getConsanGuinity()!=null && obgDetails.getConsanGuinity().equalsIgnoreCase("III")){%>
		    <option selected="selected">III</option>
		<%}else{%><option>III</option><%} if(obgDetails.getConsanGuinity()!=null && obgDetails.getConsanGuinity().equalsIgnoreCase("NCM")){%>
		    <option selected="selected">NCM</option>
		<%}else{%><option>NCM</option><%} %>	
	   </select>
	        
	     <label class="auto">Booked</label><select name="booked" class="smaller"><option value="">Select</option>
	     	<%if(obgDetails.getBooked()!=null && obgDetails.getBooked().equalsIgnoreCase("Yes")){%>
			    <option selected="selected">Yes</option><%}else{%> 
			 <option>Yes</option><%}if(obgDetails.getBooked()!=null && obgDetails.getBooked().equalsIgnoreCase("No")){%>
			    <option selected="selected">No</option>
			<%}else{%><option>No</option><%} %>	
	       </select>

	 	 <label class="auto">Immunised</label><select name="immunised" class="smaller"><option value="">Select</option>
	 	 	<%if(obgDetails.getImmunised()!=null && obgDetails.getImmunised().equalsIgnoreCase("Yes")){%>
			    <option selected="selected">Yes</option><%}else{%> 
			 <option>Yes</option><%}if(obgDetails.getImmunised()!=null && obgDetails.getImmunised().equalsIgnoreCase("No")){%>
			    <option selected="selected">No</option>
			<%}else{%><option>No</option><%} %>	
	 	    </select>	 	
	 	    	 	    
	 	 <label class="auto">I,II,III Trimisters</label><select name="trimisters" class="small"><option value="">Select</option>
	 	 	<%if(obgDetails.getTrimisters()!=null && obgDetails.getTrimisters ().equalsIgnoreCase("EventFul")){%>
			    <option selected="selected">EventFul</option><%}else{%> 
			 <option>EventFul</option><%}if(obgDetails.getTrimisters ()!=null && obgDetails.getTrimisters ().equalsIgnoreCase("UneventFul")){%>
			    <option selected="selected">UneventFul</option>
			<%}else{%><option>UneventFul</option><%} %>	
	 	
	 	 </select>
	 	     <div class="Clear"></div>
	 	       <label class="auto">GC</label><input type="text" name="gyngc" maxlength="40" value="<%=obgDetails.getGc() !=null?obgDetails.getGc():""%>">
	 	    	 <label class="auto">Pa^</label><select name="gynPa" class="small"><option value="">Select</option>	      
				 <option <%=obgDetails.getPa()!=null?obgDetails.getPa().equalsIgnoreCase("+")?"selected":"":""%>>+</option>
				 <option <%=obgDetails.getPa()!=null?obgDetails.getPa().equalsIgnoreCase("-")?"selected":"":""%>>-</option>
	     		</select>
	 	      <label class="auto">Pe^</label><select name="gynPe" class="small"><option value="">Select</option>	      
				 <option <%=obgDetails.getPe()!=null?obgDetails.getPe().equalsIgnoreCase("+")?"selected":"":""%>>+</option>
				 <option <%=obgDetails.getPe()!=null?obgDetails.getPe().equalsIgnoreCase("-")?"selected":"":""%>>-</option>
	     		</select>
	     		<label class="auto">TT</label><select name="tt" class="small"><option value="">Select</option>	      
				 <option <%=obgDetails.getTt()!=null?obgDetails.getTt()==1?"selected":"":""%>>1</option>
				 <option <%=obgDetails.getTt()!=null?obgDetails.getTt()==2?"selected":"":""%>>2</option>
	     		</select>
	     	<label class="auto">FHR</label>
	     		<select name="gynFhr" class="small"><option value="">Select</option>	      
				 <%for(int i=90,j=100;i<180;){%>
				 <option <%=obgDetails.getFhr()!=null?obgDetails.getFhr().equalsIgnoreCase(i+"-"+j)?"selected":"":""%>><%=i%>-<%=j%></option>
				 <%i+=10;j+=10;} %>
	     	</select>
	     	<label class="auto">Presentation</label><select name="gynPresentation" class="small"><option value="">Select</option>	      
				 <option <%=obgDetails.getPresentation()!=null?obgDetails.getPresentation().equalsIgnoreCase("EB")?"selected":"":""%>>EB</option>
				 <option <%=obgDetails.getPresentation()!=null?obgDetails.getPresentation().equalsIgnoreCase("Cephalic")?"selected":"":""%>>Cephalic</option>
				 <option <%=obgDetails.getPresentation()!=null?obgDetails.getPresentation().equalsIgnoreCase("Breech")?"selected":"":""%>>Breech </option>
				 <option <%=obgDetails.getPresentation()!=null?obgDetails.getPresentation().equalsIgnoreCase("Transverse")?"selected":" ":""%>>Transverse</option>
				 <option <%=obgDetails.getPresentation()!=null?obgDetails.getPresentation().equalsIgnoreCase("Oblique")?"selected":"":""%>>Oblique</option>
	     		</select>
	     	   <div class="Clear"></div>
	     	   <label class="auto">Palpation</label><input type="text" name="obg_palpation" maxlength="30" value="<%=obgDetails.getPalpation() !=null?obgDetails.getPalpation():""%>">
	     	<label class="auto">PV</label><input type="text" name="gynPv" maxlength="40" value="<%=obgDetails.getPv() !=null?obgDetails.getPv():""%>">
	 	
	 	        <label class="auto">Inspection-Height of Uterus</label>
	           <select name="uterus_height" class="smaller"><option value="">Select</option>
	               <%for(int i=12,j=14;i<36;){
	            	 String a= ""+i+"-"+j;
	              if(obgDetails.getHeightOfUterus()!=null &&  obgDetails.getHeightOfUterus().equals(a)){
	     	        	%>	
	     	      <option selected="selected"><%=a%></option>
	     	        	<%} else{
	     	        	%>
	        	  <option><%=a%></option>
	       			<%}i+=2;j+=2;}%>
	       			<option <%=obgDetails.getHeightOfUterus()!=null?obgDetails.getHeightOfUterus().equals("Term-size")?"selected":"":""%>>Term-size</option>	
	       			<option <%=obgDetails.getHeightOfUterus()!=null?obgDetails.getHeightOfUterus().equals("Palpable")?"selected":"":""%>>Palpable</option>
	       			<option <%=obgDetails.getHeightOfUterus()!=null?obgDetails.getHeightOfUterus().equals("Non-palpable")?"selected":"":""%>>Non-palpable</option>
	       			
	       			
	           </select>
	      <label class="auto">Specify</label> <textarea name="specify" maxlength="200"><%=obgDetails.getSpecify()!=null?obgDetails.getSpecify():""%></textarea>
	      <div class="Clear"></div>
	      <label class="auto">Remarks</label> <textarea name="obg_remarks" maxlength="200"><%=obgDetails.getObgRemarks()!=null?obgDetails.getObgRemarks():""%></textarea><div class="Clear"></div>
	      
	      <h4>Menstrual History</h4>
	      <label class="auto">Age of Menarche</label>
	      <select name="menarche_age" class="smaller"><option value="menarche_age">Select</option>
	       <%for(int i=8;i<=70;i++){
	    	   if(obgDetails.getAgeOfMenarche() !=null && obgDetails.getAgeOfMenarche()==i){
		        	%>	
		        	  <option selected="selected"><%=i%></option>
		        	<%} else{
		        	%>
	       <option><%=i%></option>
	       <%}} %>
	       </select>
	      <label class="auto">Cycles</label>
	      <select name="cycles" id="cycles" class="small"><option value="cycles">Select</option>	      
	<%if(obgDetails.getCycles()!=null && obgDetails.getCycles().equalsIgnoreCase("Regular")){%>
			    <option selected="selected">Regular</option><%}else{%> 
			 <option>Regular</option><%}if(obgDetails.getCycles()!=null && obgDetails.getCycles().equalsIgnoreCase("Irregular")){%>
			    <option selected="selected">Irregular</option>
			<%}else{%><option>Irregular</option><%} %>	
	     </select>
	     
	       <%if(obgDetails.getCycleText()!=null && !obgDetails.getCycleText().isEmpty()) {%>
	     <input type="text" maxlength="30" name="cycle_text" id="cycle_text" style="width:65px;" value="<%=obgDetails.getCycleText()%>" />
	     <input type="hidden" maxlength="30" name="cycle_text_hidden" id="cycle_text_hidden" value="<%=obgDetails.getCycleText()%>"/>
	     <%} else{%>
	     <input type="text" maxlength="30" name="cycle_text" id="cycle_text" style="display:none; width:65px;" value=""/>
	     <%} %>
	    
	      <label class="auto">Range: No. of Days</label>
	       <select name="range" class="smaller"><option value="">Select</option>
	               <%for(int i=0,j=1;i<30;){
	            	 String a= ""+i+"-"+j;
	              if(obgDetails.getRangeValue()!=null &&  obgDetails.getRangeValue().equals(a)){
	     	        	%>	
	     	      <option selected="selected"><%=a%></option>
	     	        	<%} else{
	     	        	%>
	        	  <option><%=a%></option>
	       			<%}i+=1;j+=1;}%>	 
	          </select> 
	       <label class="auto">Interval</label> <input type="text" name="range_interval" maxlength="30" value="<%=obgDetails.getRangeInterval()!=null?obgDetails.getRangeInterval():""%>">
	       <label class="auto">Flow</label><select name="flow" class="smaller"><option value="">Select</option>  
	       <%if(obgDetails.getFlow()!=null && obgDetails.getFlow().equalsIgnoreCase("Normal")){%>
			    <option selected="selected">Normal</option><%}else{%> 
			 <option>Normal</option><%}if(obgDetails.getFlow()!=null && obgDetails.getFlow().equalsIgnoreCase("Moderate")){%>
			    <option selected="selected">Moderate</option>
			<%}else{%><option>Moderate</option><%}if(obgDetails.getFlow()!=null && obgDetails.getFlow().equalsIgnoreCase("Heavy")){%>
		    <option selected="selected">Heavy</option>
		<%}else{%><option>Heavy</option><%}%>	
	      </select>
	     <div class="Clear"></div> 
	    <label class="auto">Menstrual Pause</label><input type="text" name="mestrual_pause" maxlength="30" value="<%=obgDetails.getMenstrualPause()!=null?obgDetails.getMenstrualPause():""%>">
	   
	    <div class="Clear"></div><div class="Clear"></div>
	    
	       <h4>Systemic Examination</h4>
	         <label class="auto">Respiratory System</label>
	         <select name="respiratory_system" class="small"><option value="">Select</option>
			<%if(obgDetails.getRespiratorySystem()!=null && obgDetails.getRespiratorySystem().equalsIgnoreCase("NVBS")){%>
			    <option selected="selected">NVBS</option><%}else{%> 
			 <option>NVBS</option><%}if(obgDetails.getRespiratorySystem()!=null && obgDetails.getRespiratorySystem().equalsIgnoreCase("Bronchial")){%>
			    <option selected="selected">Bronchial</option>
			<%}else{%><option>Bronchial</option><%} %>	
	         </select>
	         <label class="auto">Breath sounds</label>
	         <select name="breath_sound" class="small"><option value="">Select</option>
	          <%if(obgDetails.getBreadthAddedSounds()!=null && obgDetails.getBreadthAddedSounds().equalsIgnoreCase("Normal")){%>
			    <option selected="selected">Normal</option><%}else{%> 
			 <option>Normal</option>
	         <%}if(obgDetails.getBreadthAddedSounds()!=null && obgDetails.getBreadthAddedSounds().equalsIgnoreCase("Crept")){%>
			    <option selected="selected">Crept</option><%}else{%> 
			 <option>Crept</option><%}if(obgDetails.getBreadthAddedSounds()!=null && obgDetails.getBreadthAddedSounds().equalsIgnoreCase("Rhonchi")){%>
			    <option selected="selected">Rhonchi</option>
			<%}else{%><option>Rhonchi</option><%} %>	
      	      </select>
	       <div class="Clear"></div>
	       
	          <h4>Cardiovascular System </h4>
	           <label class="auto">S1</label>
	           <select name="s1" class="small"><option value="">Select</option>
	           <%if(obgDetails.getS1()!=null && obgDetails.getS1().equalsIgnoreCase("Normal")){%>
			    <option selected="selected">Normal</option><%}else{%> 
			 <option>Normal</option><%}if(obgDetails.getS1()!=null && obgDetails.getS1().equalsIgnoreCase("Ab(n)")){%>
			    <option selected="selected">Ab(n)</option>
			<%}else{%><option>Ab(n)</option><%} %>	
	 	
	          </select>
	           <label class="auto">S2</label>
	           <select name="s2" class="small"><option value="">Select</option>
	               <%if(obgDetails.getS2()!=null && obgDetails.getS2().equalsIgnoreCase("Normal")){%>
			    <option selected="selected">Normal</option><%}else{%> 
			 <option>Normal</option><%}if(obgDetails.getS2()!=null && obgDetails.getS2().equalsIgnoreCase("Ab(n)")){%>
			    <option selected="selected">Ab(n)</option>
			<%}else{%><option>Ab(n)</option><%} %>	
	         </select>
	           <label class="auto">Murmurs</label>
	           <input type="text" name="murmurs" maxlength="50"value="<%=obgDetails.getMurmurs()!=null?obgDetails.getMurmurs():""%>">
	           
	          <div class="Clear"></div><div class="Clear"></div> <div class="Clear"></div><div class="Clear"></div>
<%-- 	         <h4>Per Abdomen Examination</h4>	   
	           <div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div>
	           
	           <label class="auto">Inspection-Height of Uterus</label>
	           <select name="uterus_height" class="smaller"><option value="">Select</option>
	               <%for(int i=12,j=14;i<36;){
	            	 String a= ""+i+"-"+j;
	              if(obgDetails.getHeightOfUterus()!=null &&  obgDetails.getHeightOfUterus().equals(a)){
	     	        	%>	
	     	      <option selected="selected"><%=a%></option>
	     	        	<%} else{
	     	        	%>
	        	  <option><%=a%></option>
	       			<%}i+=2;j+=2;}%>
	       			<%if(obgDetails.getHeightOfUterus()!=null &&  obgDetails.getHeightOfUterus().equals("Term-size")){ %>
	       			<option selected>Term-size</option>	
	       			<%}else{ %>
	       			<option>Term-size</option>	
	       			<%} %>
	           </select>
	    
	           <label class="auto">Palpation-Lower Pole</label>
	           <select name="lower_pole" class="smaller"><option value="">Select</option>
	           <%if(obgDetails.getLowerPole()!=null && obgDetails.getLowerPole().equalsIgnoreCase("Head")){%>
			    <option selected="selected">Head</option><%}else{%> 
			 <option>Head</option><%}if(obgDetails.getLowerPole()!=null && obgDetails.getLowerPole().equalsIgnoreCase("breech")){%>
			    <option selected="selected">breech</option>
			<%}else{%><option>breech</option><%} %>	
	 	<%if(obgDetails.getLowerPole()!=null && obgDetails.getLowerPole().equalsIgnoreCase("Oblique")){%>
			    <option selected="selected">Oblique</option>
			<%}else{%><option>Oblique</option><%} %>	
			<%if(obgDetails.getLowerPole()!=null && obgDetails.getLowerPole().equalsIgnoreCase("Empty-transverse lie")){%>
			    <option selected="selected">Empty-transverse lie</option>
			<%}else{%><option>Empty-transverse lie</option><%} %>	
	           </select>
	           <label class="auto">Lateral grip:Back</label>
	           <select name="lateral_grip" class="smaller"><option value="">Select</option>
	           <%if(obgDetails.getLowerGrip()!=null && obgDetails.getLowerGrip().equalsIgnoreCase("Left")){%>
			    <option selected="selected">Left</option><%}else{%> 
			 <option>Left</option><%}if(obgDetails.getLowerGrip()!=null && obgDetails.getLowerGrip().equalsIgnoreCase("Right")){%>
			    <option selected="selected">Right</option>
			<%}else{%><option>Right</option><%} if(obgDetails.getLowerGrip()!=null && obgDetails.getLowerGrip().equalsIgnoreCase("Others")){%>
		    <option selected="selected">Others</option>
		<%}else{%><option>Others</option><%} %>	
	 	
	         </select>
	         
	           <label class="auto">Auscultation : Fetal  Heart Rate - Regular</label>
	           <select name="heart_rate_regular" class="smaller"><option value="">Select</option>
	            <option>0</option>
	             <%for(int i=90;i<=180;){ 
	        	   if(obgDetails.getHeartRateRegular()!=null &&obgDetails.getHeartRateRegular()==i){
	   	        	%>	
	   	        	  <option selected="selected"><%=i%></option>
	   	        	<%} else{
	   	        	%>
	       <option><%=i%></option>
	       <%}i+=10; }%></select> --%>
	       <div class="clear"></div>
	       
	         <%--   <label>Fetal Heart Rate Absent</label>
	           <input type="text" name="heart_rate_absent" maxlength="15" value="<%=obgDetails.getHeartRateAbsent()!=null?obgDetails.getHeartRateAbsent():""%>">
	           --%> 
	          <h4>Per Vaginal Examination</h4>
	          <label class="auto">OS Dilatation of cervix</label>
	          <select name="cervix_dilatation" class="smaller"><option value="">Select</option><%for(int i=0;i<=10;i++){ 
	        	  if(obgDetails.getDilatationOfCervix()!=null && obgDetails.getDilatationOfCervix()==i){
	  	        	%>	
	  	        	  <option selected="selected"><%=i%></option>
	  	        	<%} else{
	  	        	%>
	       <option><%=i%></option>
	       <%}} %></select> (CM)
	       
	          <label class="auto">Effacement of cervix</label>
	          <select name="cervix_effacement" class="smaller"><option value="">Select</option>
	             <%for(int i=0,j=10;i<100;){
	            	 String a= ""+i+"-"+j;
	              if(obgDetails.getEffacementOfCervix()!=null && obgDetails.getEffacementOfCervix().equals(a)){
	     	        	%>	
	     	      <option selected="selected"><%=a%>%</option>
	     	        	<%} else{
	     	        	%>
	         <option><%=a%>%</option>
	       <%}i+=10;j+=10;}%>	          
	          </select>
	           
	          <label class="auto">Membrane</label><select name="membrane" class="smaller"><option value="">Select</option>
	                       <%if(obgDetails.getMembrane()!=null && obgDetails.getMembrane().equalsIgnoreCase("Intact")){%>			    <option selected="selected">Intact</option><%}else{%> 
			 <option>Intact</option><%}if(obgDetails.getMembrane()!=null && obgDetails.getMembrane().equalsIgnoreCase("Absent")){%>
			    <option selected="selected">Absent</option>
			<%}else{%><option>Absent</option><%} %>	
	         </select>
	         
	          <label class="auto">Liquor</label>
	          <select name="liquor" class="small"><option value="">Select</option>	          
	                  <%if(obgDetails.getLiquor()!=null && obgDetails.getLiquor().equalsIgnoreCase("clear")){%>
			    <option selected="selected">clear</option><%}else{%> 
			 <option>clear</option><%}if(obgDetails.getLiquor()!=null && obgDetails.getLiquor().equalsIgnoreCase("Blood Tinged")){%>
			    <option selected="selected">Blood Tinged</option>
			<%}else{%><option>Blood Tinged</option><%} if(obgDetails.getLiquor()!=null && obgDetails.getLiquor().equalsIgnoreCase("Meconium")){%>
		    <option selected="selected">Meconium</option>
		<%}else{%><option>Meconium</option><%} %>	
	          
	       </select>
	       
	          <label class="auto">Consistency of cervix</label>
	          <select name="cervix_consistency" class="smaller"><option value="">Select</option>
	             <%if(obgDetails.getConsistencyOfCervix()!=null && obgDetails.getConsistencyOfCervix().equalsIgnoreCase("Soft")){%>
			    <option selected="selected">Soft</option><%}else{%> 
			 <option>Soft</option><%}if(obgDetails.getConsistencyOfCervix()!=null && obgDetails.getConsistencyOfCervix().equalsIgnoreCase("Normal")){%>
			    <option selected="selected">Normal</option>
			<%}else{%><option>Normal</option><%} if(obgDetails.getConsistencyOfCervix()!=null && obgDetails.getConsistencyOfCervix().equalsIgnoreCase("Hard")){%>
		    <option selected="selected">Hard</option>
		<%}else{%><option>Hard</option><%} %>	
	          </select>
	          <div class="clear"></div>
	          
	          <label class="auto">Position of cervix</label>
	          <select name="cervix_position" class="small"><option value="">Select</option>
	           <%if(obgDetails.getPositionOfCervix()!=null && obgDetails.getPositionOfCervix().equalsIgnoreCase("anterior")){%>
			    <option selected="selected">anterior</option><%}else{%> 
			 <option>anterior</option><%}if(obgDetails.getPositionOfCervix()!=null && obgDetails.getPositionOfCervix().equalsIgnoreCase("Mid Position")){%>
			    <option selected="selected">Mid Position</option>
			<%}else{%><option>Mid Position</option><%} if(obgDetails.getPositionOfCervix()!=null && obgDetails.getPositionOfCervix().equalsIgnoreCase("posterior")){%>
		    <option selected="selected">posterior</option>
		<%}else{%><option>posterior</option><%} %>	
	          </select>
	          
	          <label class="auto">Length of cervix</label>
	          <select name="cervix_length" class="smaller"><option value="">Select</option>
	          	          <%for(int i=0;i<=4;i++){ 
	          	        	if(obgDetails.getLengthOfCervix()!=null && obgDetails.getLengthOfCervix()==i){
	          		        	%>	
	          		        	  <option selected="selected"><%=i%></option>
	          		        	<%} else{
	          		        	%>
	       <option><%=i%></option>
	       <%}} %></select>
	       
	          <label class="auto">Station of Presenting Part</label>
	          <select name="station" class="smaller"><option value="">Select</option>
	          <%for(int i=-3;i<=3;i++){ 
	        	  if(obgDetails.getStationOfPresentingPart()!=null && obgDetails.getStationOfPresentingPart()==i){
	  	        	%>	
	  	        	  <option selected="selected"><%=i%></option>
	  	        	<%} else{
	  	        	%>
	       <option><%=i%></option>
	       <%} }%></select>
	          
	          <label class="auto">Head</label>
	          <select name="head" class="smaller"><option value="">Select</option>
	          <%if(obgDetails.getHead()!=null && obgDetails.getHead().equalsIgnoreCase("Mobile")){%>
			    <option selected="selected">Mobile</option><%}else{%> 
			 <option>Mobile</option><%}if(obgDetails.getHead()!=null && obgDetails.getHead().equalsIgnoreCase("Fixed")){%>
			    <option selected="selected">Fixed</option>
			<%}else{%><option>Fixed</option><%} %>	
	 	
	          </select>
	                   
	          <label class="auto">Pelvis</label>
	          <select name="pelvis" class="small"><option value="">Select</option>
	                <%if(obgDetails.getPelvis()!=null && obgDetails.getPelvis().equalsIgnoreCase("Adequate")){%>
			    <option selected="selected">Adequate</option><%}else{%> 
			 <option>Adequate</option><%}if(obgDetails.getPelvis()!=null && obgDetails.getPelvis().equalsIgnoreCase("contracted")){%>
			    <option selected="selected">contracted</option>
			<%}else{%><option>contracted</option><%} %>	
	          </select>
</div>	

 <h4>Gynaecology</h4><input class="button" tabindex="3" name="gynBtn" id="gynBtn"value="+" onclick="toggleDiv('gyna','gynBtn')" type="button" style="padding: 1px;width: 20px;height: 18px;"> 
 <div class="Block" id="gyna">
<h4>Menstrual History</h4>
<%-- <label>Age of Menarche</label><select name="menarche_age"><option value="menarche_age">Select</option>
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
	 
	    --%>
	          <label>Flow</label><select name="gyn_flow"><option value="">Select</option> 
	          <%if(obgDetails.getGynFlow()!=null && obgDetails.getGynFlow().equalsIgnoreCase("Normal")){%>
			    <option selected="selected">Normal</option><%}else{%> 
			 <option>Normal</option><%}if(obgDetails.getGynFlow()!=null && obgDetails.getGynFlow().equalsIgnoreCase("Moderate")){%>
			    <option selected="selected">Moderate</option>
			<%}else{%><option>Moderate</option><%}if(obgDetails.getGynFlow()!=null && obgDetails.getGynFlow().equalsIgnoreCase("Heavy")){%>
		    <option selected="selected">Heavy</option>
		<%}else{%><option>Heavy</option><%}%>	 
	         </select>
	       	 <label class="auto">Age of menarche</label>
	           <select name="gyn_menarche_age" class="smaller"><option value="">Select</option>
	          <%for(int i=8;i<=20;i++){ 
	        	  if(obgDetails.getGynAgeOfMenarche()!=null && obgDetails.getGynAgeOfMenarche()==i){
	  	        	%>	
	  	        	  <option selected="selected"><%=i%></option>
	  	        	<%} else{
	  	        	%>
	       <option><%=i%></option>
	       <%} }%></select> 
	 	 
	 	  <label class="auto">Last Menstrual period</label>
		<%-- 	<input type="text" name="last_menstrual" maxlength="50" value="<%=obgDetails.getLastMenstrual()!=null?obgDetails.getLastMenstrual():""%>"> --%>
			<input type="text" name="last_menstrual" id="last_menstrual" readonly="readonly"  value="<%=obgDetails.getLastMenstrual()!=null?HMSUtil.convertDateToStringTypeDateOnly(obgDetails.getLastMenstrual()):""%>"/>
			 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.getElementById('last_menstrual'),event);" />
			   <div class="clear"></div>
			 <label class="auto">Menstrual pattern</label>
			      <select name="menstrual_pattern1" class="smaller"><option value="">Select</option>
	               <%
	               String a="";
	               for(int i=0,j=1;i<6;){
	            	   if(i==5)
	            		  a=">5";
	            	else
	            	  a= ""+i+"-"+j;
	              if(obgDetails.getMenstrualPattern1()!=null &&  obgDetails.getMenstrualPattern1().equals(a)){
	     	        	%>	
	     	      <option selected="selected"><%=a%></option>
	     	        	<%} else{
	     	        	%>
	         <option><%=a%></option>
	               
	       <%}i+=1;j+=1;}%>	 
	              
	          </select> 
	          
	           <select name="menstrual_pattern2" class="smaller"><option value="">Select</option>
	               <%
	                a="";
	               for(int i=10,j=15;i<=30;){
	            	   if(i==10)
	            	   {
	            		  a="<15";
	            		  
	            	   }
	            	   else if(i==30)
		            		  a=">30";
	            	else
	            	  a= ""+i+"-"+j;
	              if(obgDetails.getMenstrualPattern2()!=null &&  obgDetails.getMenstrualPattern2().equals(a)){
	     	        	%>	
	     	      <option selected="selected"><%=a%></option>
	     	        	<%} else{
	     	        	%>
	         <option><%=a%></option>
	               
	       <%}i+=5;j+=5;}%>	 
	              
	          </select> 
			<%-- <label class="auto">flow</label>
			<select name="flow" class="smaller"><option value="">Select</option>
	 	 	<%if(obgDetails.getImmunised()!=null && obgDetails.getImmunised().equalsIgnoreCase("Normal")){%>
			    <option selected="selected">Normal</option><%}else{%> 
			 <option>Normal</option><%}if(obgDetails.getImmunised()!=null && obgDetails.getImmunised().equalsIgnoreCase("Moderate")){%>
			    <option selected="selected">Moderate</option>
			<%}else{%><option>Moderate</option><%}%>
			<%if(obgDetails.getImmunised()!=null && obgDetails.getImmunised().equalsIgnoreCase("Heavy")){%>
			    <option selected="selected">heavy</option>
			<%}else{%><option>heavy</option><%}%>		
	 	    </select> --%>

<h4>Obstetric H/o</h4>
<textarea rows="" name="gyn_obstetric_history" maxlength="2000"class="medium"><%=obgDetails.getGynObstetricHistory()!=null?obgDetails.getGynObstetricHistory():""%></textarea>
<label>Sterilisation</label><select name="gyn_sterilisation"><option value="">Select</option>
<option <%=obgDetails.getSterilisation()!=null?obgDetails.getSterilisation().equalsIgnoreCase("Yes")?"selected":"":""%>>Yes</option>
<option <%=obgDetails.getSterilisation()!=null?obgDetails.getSterilisation().equalsIgnoreCase("No")?"selected":"":""%>>No</option>
</select> 


 <%-- <label>Married Life</label><input type="text" name="total_marriage_year" value="<%=obgDetails.getMarriedLife()!=null?obgDetails.getMarriedLife():""%>">
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
	  
	       <label>Obstetric Score L</label><select name="obstetric_score_l"><option value="">Select</option>
	        <%for(int i=0;i<=9;i++){ if(obgDetails.getObstreticScoreL()!=null &&obgDetails.getObstreticScoreL()==i){
	        	%>	
	        	  <option selected="selected"><%=i%></option>
	        	<%} else{
	        	%>
	       <option><%=i%></option>
	       <%} }%>
	     </select> --%>

	       <%--  <label>Missing label 2</label><select name="consan"><option value="">Select</option>
			<%if(obgDetails.getConsanGuinity()!=null && obgDetails.getConsanGuinity().equalsIgnoreCase("Normal Vaginal Delivery")){%>
			    <option selected="selected">Normal Vaginal Delivery</option><%}else{%> 
			 <option>Normal Vaginal Delivery</option><%}if(obgDetails.getConsanGuinity()!=null && obgDetails.getConsanGuinity().equalsIgnoreCase("Ceas")){%>
			    <option selected="selected">Ceas</option>
			<%}else{%><option>Ceas</option><%}if(obgDetails.getConsanGuinity()!=null && obgDetails.getConsanGuinity().equalsIgnoreCase("Sterilised")){%>
		    <option selected="selected">Sterilised</option>
		<%}else{%><option>Sterilised</option><%} %>
		<%if(obgDetails.getConsanGuinity()!=null && obgDetails.getConsanGuinity().equalsIgnoreCase("Non Sterilised")){%>
		    <option selected="selected">Non Sterilised</option>
		<%}else{%><option>Non Sterilised</option><%} %>
		<%if(obgDetails.getConsanGuinity()!=null && obgDetails.getConsanGuinity().equalsIgnoreCase("Other Contraception")){%>
		    <option selected="selected">Other Contraception</option>
		<%}else{%><option>Other Contraception</option><%} %>
		
	   </select> --%>
	   
<h4>Per Abdomen</h4>
 <label>Inspection</label><textarea rows="" name="gyn_abdomen_inspection" class="large" maxlength="2000"><%=obgDetails.getGynAbdomenInspection()!=null?obgDetails.getGynAbdomenInspection():""%></textarea> 
    <%--  <label>Inspection: Abdomen</label>
     <select name="inspection_abdomen"><option value="">Select</option>
           <%if(obgDetails.getInspectionAbdomen()!=null && obgDetails.getInspectionAbdomen().equalsIgnoreCase("Scaphoid")){%>
	       <option selected="selected">Scaphoid</option><%}else{%> 
	       <option>Scaphoid</option><%}if(obgDetails.getInspectionAbdomen()!=null && obgDetails.getInspectionAbdomen().equalsIgnoreCase("Distended")){%>
	       <option selected="selected">Distended</option>
	       <%}else{%><option>Distended</option><%} %>	
	 </select>
	 
	 <label>Inspection: Umbilicus </label>
     <select name="inspection_umbilicus"><option value="">Select</option>
           <%if(obgDetails.getInspectionUmbilicus()!=null && obgDetails.getInspectionUmbilicus().equalsIgnoreCase("Normal")){%>
	       <option selected="selected">Normal</option><%}else{%> 
	       <option>Normal</option><%}if(obgDetails.getInspectionUmbilicus()!=null && obgDetails.getInspectionUmbilicus().equalsIgnoreCase("Everted")){%>
	       <option selected="selected">Everted</option>
	       <%}else{%><option>Everted</option><%} %>	
	 </select>

     <label>Inspection: Hernia</label>
     <select name="inspection_hernia"><option value="">Select</option>
           <%if(obgDetails.getInspectionHernia()!=null && obgDetails.getInspectionHernia().equalsIgnoreCase("Yes")){%>
	       <option selected="selected">Yes</option><%}else{%> 
	       <option>Yes</option><%}if(obgDetails.getInspectionHernia()!=null && obgDetails.getInspectionHernia().equalsIgnoreCase("No")){%>
	       <option selected="selected">No</option>
	       <%}else{%><option>No</option><%} %>	
	 </select>
	 
     <label>Inspection: Scars</label>
     <select name="inspection_scar"><option value="">Select</option>
			<%if(obgDetails.getInspectionScar()!=null && obgDetails.getInspectionScar().equalsIgnoreCase("---")){%>
			<option selected="selected">---</option><%}else{%> 
			<option>---</option><%}if(obgDetails.getInspectionScar()!=null && obgDetails.getInspectionScar().equalsIgnoreCase("Tubectomy")){%>
			<option selected="selected">Tubectomy</option>
			<%}else{%><option>Tubectomy</option><%}if(obgDetails.getInspectionScar()!=null && obgDetails.getInspectionScar().equalsIgnoreCase("Appendicectomy")){%>
		    <option selected="selected">Appendicectomy</option>
		    <%}else{%><option>Appendicectomy</option><%} %>	
	   </select>  --%>
	   
 <h4>Palpation</h4>
 <textarea rows="" name="gyn_palpation" class="large" maxlength="2000"><%=obgDetails.getGynPalpation()!=null?obgDetails.getGynPalpation():""%></textarea>
 
  <label>Pap-smear</label><select name="Pap_smear"><option value="">Select</option>
<option <%=obgDetails.getPapSmear()!=null?obgDetails.getPapSmear().equalsIgnoreCase("Yes")?"selected":"":""%>>Yes</option>
<option <%=obgDetails.getPapSmear()!=null?obgDetails.getPapSmear().equalsIgnoreCase("No")?"selected":"":""%>>No</option>
</select>
  <%-- 	 <label>Mass:Palpable</label>
     <select name="mass_palpable"><option value="">Select</option>
           <%if(obgDetails.getMassPalpable()!=null && obgDetails.getMassPalpable().equalsIgnoreCase("Yes")){%>
	       <option selected="selected">Yes</option><%}else{%> 
	       <option>Yes</option><%}if(obgDetails.getMassPalpable()!=null && obgDetails.getMassPalpable().equalsIgnoreCase("No")){%>
	       <option selected="selected">No</option>
	       <%}else{%><option>No</option><%} %>	
	 </select>
 <label>Mass:Size</label>
  <input type="text" name="mass_size" value="<%=obgDetails.getMassSize()!=null?obgDetails.getMassSize():""%>" maxlength="50"/>
  <label>Mass:Shape</label>
  <input type="text" name="mass_shape" value="<%=obgDetails.getMassShape()!=null?obgDetails.getMassShape():""%>" maxlength="50"/><div class="clear"></div>
  <label>Mass:Position</label>
  <input type="text" name="mass_position" value="<%=obgDetails.getMassPosition()!=null?obgDetails.getMassPosition():""%>" maxlength="50"/>
  <label>Mass:Consistency</label>
  <input type="text" name="mass_consistency" value="<%=obgDetails.getMassConsistency()!=null?obgDetails.getMassConsistency():""%>" maxlength="50"/>
  <label>Mass:Temp</label>
  <input type="text" name="mass_temp" value="<%=obgDetails.getMassTemp()!=null?obgDetails.getMassTemp():""%>" maxlength="50"/>
    <label>ASCITIS</label>
  <input type="text" name="asicitis" value="<%=obgDetails.getAsicitis()!=null?obgDetails.getAsicitis():""%>" maxlength="50"/> --%>
 <h4>Local Examination</h4>
 <textarea rows="" name="gyn_local_examination" class="large" maxlength="2000"><%=obgDetails.getGynLocalExamination()!=null?obgDetails.getGynLocalExamination():""%></textarea> 
    <%-- <label>External Genitalia</label>
    <select name="external_genitalia" id="external_genitalia"><option value="">Select</option>
			<%if(obgDetails.getExternalGenitalia()!=null && obgDetails.getExternalGenitalia().equalsIgnoreCase("Normal")){%>
			<option selected="selected">Normal</option><%}else{%> 
			<option>Normal</option><%}if(obgDetails.getExternalGenitalia()!=null && obgDetails.getExternalGenitalia().equalsIgnoreCase("Abnormal")){%>
			<option selected="selected">Abnormal</option>
			<%}else{%><option>Abnormal</option><%}if(obgDetails.getExternalGenitalia()!=null && obgDetails.getExternalGenitalia().equalsIgnoreCase("Other")){%>
		    <option selected="selected">Other</option>
		    <%}else{%><option>Other</option><%} %>	
	  </select> 
	 <input type="text" id="external_genitalia_other" name="external_genitalia_other" maxlength="50" value="<%=obgDetails.getExternalGenitaliaOther()!=null?obgDetails.getExternalGenitaliaOther():""%>" style="display: none;">
	   --%>
 <h4>Internal Examination</h4>
 <label>Per Speculum</label> <textarea rows="" name="gyn_per_speculum" class="large" maxlength="2000"><%=obgDetails.getGynPerSpeculum()!=null?obgDetails.getGynPerSpeculum():""%></textarea> 
  <%--  	 <label>Per Speculum: Vagina</label>
     <select name="speculum_vagina"><option value="">Select</option>
           <%if(obgDetails.getSpeculumVagina()!=null && obgDetails.getSpeculumVagina().equalsIgnoreCase("Normal")){%>
	       <option selected="selected">Normal</option><%}else{%> 
	       <option>Normal</option><%}if(obgDetails.getSpeculumVagina()!=null && obgDetails.getSpeculumVagina().equalsIgnoreCase("Atrophy")){%>
	       <option selected="selected">Atrophy</option>
	       <%}else{%><option>Atrophy</option><%} %>	
	 </select>
	 
	 	 <label>Per Speculum: Discharge</label>
     <select name="speculum_discharge"><option value="">Select</option>
           <%if(obgDetails.getSpeculumDischarge()!=null && obgDetails.getSpeculumDischarge().equalsIgnoreCase("Absent")){%>
	       <option selected="selected">Absent</option><%}else{%> 
	       <option>Absent</option><%}if(obgDetails.getSpeculumDischarge()!=null && obgDetails.getSpeculumDischarge().equalsIgnoreCase("--")){%>
	       <option selected="selected">Atrophy</option>
	       <%}else{%><option>---</option><%} %>	
	 </select>
	 
	 	 <label>Per Speculum: cervix</label>
     <select name="speculum_cervix"><option value="">Select</option>
           <%if(obgDetails.getSpeculumCervix()!=null && obgDetails.getSpeculumCervix().equalsIgnoreCase("Healthy")){%>
	       <option selected="selected">Healthy</option><%}else{%> 
	       <option>Healthy</option><%}if(obgDetails.getSpeculumCervix()!=null && obgDetails.getSpeculumCervix().equalsIgnoreCase("Unhealthy")){%>
	       <option selected="selected">Unhealthy</option>
	       <%}else{%><option>Unhealthy</option><%} %>	
	 </select>
	 
	 	 <label>Per Speculum: Descent</label>
   <input type="text" name="speculum_decent" value="<%=obgDetails.getSpeculumDecent()!=null?obgDetails.getSpeculumDecent():""%>" maxlength="50"/>
	    --%>
	   <h4>Bimanual Examination</h4>
	    <textarea rows="" name="gyn_bimanual_examination" class="large" maxlength="2000"><%=obgDetails.getGynBimanualExamination()!=null?obgDetails.getGynBimanualExamination():""%></textarea> 
	 <%-- 	 <label>Uterus:Size</label>
   <input type="text" name="uterus_size" value="<%=obgDetails.getUterusSize()!=null?obgDetails.getUterusSize():""%>" maxlength="50" />
    <label>Uterus:-----</label>
   <input type="text" name="uterus_size" value="" maxlength="50" />
    <label>Uterus:Forness</label>
   <input type="text" name="uterus_forness" value="<%=obgDetails.getUterusForness()!=null?obgDetails.getUterusForness():""%>" maxlength="50"/>
    <label>Uterus:Cervical Movement</label>
    <select name="uterus_cervical_movement"><option value="">Select</option>
           <%if(obgDetails.getUterusCervicalMovement()!=null && obgDetails.getUterusCervicalMovement().equalsIgnoreCase("Yes")){%>
	       <option selected="selected">Yes</option><%}else{%> 
	       <option>Yes</option><%}if(obgDetails.getUterusCervicalMovement()!=null && obgDetails.getUterusCervicalMovement().equalsIgnoreCase("No")){%>
	       <option selected="selected">No</option>
	       <%}else{%><option>No</option><%} %>	
	 </select> --%>
</div>

	 <%}%>
	<!-- OBG details end -->
	
	
	<div class="clear paddingTop5"></div>
	<div class="floatRight">
		<input name="investigationTemplate" type="button"
			value="Clinical Assist" onclick="showDiagnosis()" tabindex="1"
			class="buttonBig" />
	</div>
	<div class="clear paddingTop5"></div>
	<!-- floatRight ends -->
	<h4>Diagnosis</h4>
	<div class="Block">

		<div class="floatLeft">
			<%-- 	<label >On Examination</label>  --%>
			<input type="hidden" id="systamicExam" class="large"
				name="systamicExam" maxlength="200" /> <label>Working Diagnosis</label>
					<%if(visit.getDepartment()!=null && (visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForPhychiatrist) || visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForSurgery) || visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForGM)) || visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForDermo)) {%>
			<input type="text" class="auto" id="initialDiagnosis" tabindex="1"
				 value="<%=opdDetailListForFollowUp.size()>0?opdDetailListForFollowUp.get(0).getInitialDiagnosis()!=null?opdDetailListForFollowUp.get(0).getInitialDiagnosis():"":""%>" size="117" name="initialDiagnosis" maxlength="500"/>
			<%}else{ %>
			<input type="text" class="auto" id="initialDiagnosis" tabindex="1"
				 value="" size="117" name="initialDiagnosis" maxlength="500"/>
			<%} %>
				
				
<%-- 			<% 

if( opdDetailsForFollowup != null && opdDetailsForFollowup.getInitialDiagnosis()!=null)
{%>
			<input type="text" class="auto" id="initialDiagnosis" tabindex="1"
				size="117" value="<%=opdDetailsForFollowup.getInitialDiagnosis() %>"
				name="initialDiagnosis" maxlength="100" />
			<% }else{%>
			<input type="text" class="auto" id="initialDiagnosis" tabindex="1"
				value="" size="117" name="initialDiagnosis" maxlength="100" />

			<% }%> --%>

			<div class="clear"></div>

			<%-- <label>System Diagnosis</label> <input name="systemDiagnosis"
				value="<%=opdDetailsForFollowup != null && opdDetailsForFollowup.getSystemDiagnosis()!= null?opdDetailsForFollowup.getSystemDiagnosis().getSystemDiagnosisName()+"["+opdDetailsForFollowup.getSystemDiagnosis().getId()+"]":"" %>"
				id="systemDiagnosis" tabindex="1" class="auto"
				onblur="checkForSystemDiagnosis(this.value);" size="117" />
			<div id="ac2update" style="display: none;" class="autocomplete"></div>
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
			<input type="hidden" name="ageName"
				value="<%=visit.getHin().getAge() %>" id="ageId" />

			<div class="clear"></div>
			<label>ICD Diagnosis<span>*</span></label> <input type="text"
				tabindex="1" value="" id="icd" name="icd" class="auto" size="53"
				onblur="fillDiagnosisCombo(this.value);" /> 
				
			<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
		   //document.getElementById('slide0').style.display="hide"
</script>
			<select name="<%=DIAGNOSIS_ID%>" multiple="4" size="5" tabindex="1"
				id="diagnosisId" class="listBig" validate="ICD Daignosis,string,yes">
				<option value="0">Select</option>
				<%
		if(dischargeIcdCodeList.size()>0){
			for(DischargeIcdCode icdCode : dischargeIcdCodeList){
	%>
				<option value="<%=icdCode.getIcd().getIcdCode() %>"
					selected="selected"><%=icdCode.getIcd().getIcdName()+"["+icdCode.getIcd().getIcdCode()+"]" %></option>
				<%}
			}%>
			</select> <input type="button" class="buttonDel" value=""
				onclick="deleteDgItems(this,'diagnosisId');" align="right" />
				<input type="checkbox" onclick="addNAIcd('<%=HMSUtil.getProperties("adt.properties", "ICDCodeForNotAvailble")%>',this)" name="NAIcd" id="NAIcd" value="<%=HMSUtil.getProperties("adt.properties", "ICDCodeForNotAvailble")%>" style="margin-top: 0px; margin-right: 5px;"> Not available
		</div>
		<!-- floatLeft ends -->

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
				onclick="copyPrevInvestigationTempate('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>');" />
		</div>
		<div id="investigationImportButton1">
			<input name="investigationImportButton1" tabindex="1" type="button"
				value="Import New" class="button"
				onclick="getListForTreatment('investigationDiv','opdMain');" />
		</div>
		<label>Urgent</label> <input type="checkbox" name="urgent"
			tabindex="1" class="radioAuto" value="1" />
	</div>

	<div class="clear"></div>
	<div class="Block">
		<div id="gridview">
			<table border="0" align="center" cellpadding="0" cellspacing="0"
				id="investigationGrid">
				<tr>
					<td colspan="4">
						<div class="floatleft">
							<input type="radio" value="Lab" class="radioCheckCol2"
								style="margin-right: 5px;" name="labradiologyCheck"
								checked="checked" onchange="" />
							<div class="labRadiologyDivfixed">LAB</div>
							<input type="radio" value="Radio" class="radioCheckCol2"
								style="margin-right: 5px;" name="labradiologyCheck" onchange="" />
							<div class="labRadiologyDivfixed">Radiology</div>
							<input type="hidden" name="investigationCategory"
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
					<td><input type="text" value="<%=investigationName %>"
						tabindex="1" id="chargeCodeName<%=inc %>" size="100"
						name="chargeCodeName<%=inc %>"
						onblur="checkForAlreadyPrescribedInvestigation(this.value,'1',document.getElementById('hinId').value);if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
						<div id="ac2update2" style="display: none;" class="autocomplete">
						</div> <script type="text/javascript" language="javascript"
							charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{minChars:2,
					  callback: function(element, entry) {
				            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
				        },
					  parameters:'requiredField=chargeCodeName<%=inc %>'});
				  
				</script> <input type="hidden" tabindex="1" id="chargeCode<%=inc %>"
						name="chargeCode<%=inc %>" size="10" readonly /> <input size="10"
						readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

					</td>
					<%-- 		<%if(patientInvestigation.getReferToMh().equals("") && patientInvestigation.getReferToMh().equals("y") ){ %>
		<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio" checked="checked" validate="Refer to MH,string,no" /></td>
		<%}else{ %>
		<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td>
		<%} %> --%>
					<td><input name="Button" type="button" class="buttonAdd"
						value="" onclick="addRowForInvestigation();" /></td>
					<td><input type="button" name="delete" value=""
						class="buttonDel" tabindex="1"
						onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


				</tr>
				<%inc++;}
		%>
				<input type="hidden" value="<%=inc-1 %>" name="hiddenValue"
					id="hiddenValue" />
				<%}else{ %>

				<tr>
					<td><input type="text" value="<%=investigationName %>"
						tabindex="1" id="chargeCodeName<%=inc %>" size="100"
						name="chargeCodeName<%=inc %>"
						onblur="checkForAlreadyPrescribedInvestigation(this.value,'1',document.getElementById('visitId').value);if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
						<div id="ac2update1" style="display: none;" class="autocomplete"></div>
						<%-- <script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>&labradiologyCheck='+ document.getElementById('investigationCategory').value});
				</script>  --%> <script type="text/javascript" language="javascript"
							charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName1','ac2update1','opd?method=getInvestigationListForAutoComplete',{
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName<%=inc %>'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
						size="10" maxlength="6" validate="Qty,num,no" /> <input
						type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
						size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

					</td>

					<%-- <td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td> --%>
<td><input  type="text" class="calDate" onchange="checkForAlreadyPrescribedInvestigation(document.getElementById('chargeCodeName<%=inc %>').value,'<%=inc%>',document.getElementById('hinId').value);"  id="investigationDate<%=inc%>" name="investigationDate<%=inc%>" placeholder="DD/MM/YYYY" validate="LMP Date,string,no" value="<%=consultationDate%>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'investigationDate<%=inc%>');" maxlength="10" style="width: 120px"/></td>
					<td><input name="Button" type="button" class="buttonAdd"
						value="" tabindex="1" onclick="addRowForInvestigation();" /></td>
					<td><input type="button" name="delete" value=""
						class="buttonDel" tabindex="1"
						onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>


				</tr>

				<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />

				<%} %>


			</table>
		</div>
		<label>Other Investigation</label>
		<textarea name="otherInvestigation" cols="50" rows="0" maxlength="500"
			tabindex="1" onkeyup="return ismaxlength(this)" class="auto"></textarea>
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
				<td><input type="text" name="clinicalNotes1" id="clinicalNotes"
					tabindex="1"
					value="<%=patientInvestigationHeader.getClinicalNotes() %>"
					size="100" maxlength="5000" /></td>
				<%}}else{ %>
				<td><input type="text" name="clinicalNotes1" id="clinicalNotes"
					tabindex="1" value="" size="98" maxlength="5000" /></td>
				<%} %>

			</tr>
		</table>
	</div>

<%-- 	<%
	if (patientPrescriptionHeader != null) {
			
%>
	<div class="clear paddingTop5"></div>
	<h4>Treatment</h4>
	<div class="cmntable">
		<div class="Clear"></div>
		<div id="testDivDrug">
			<table border="0" align="center" cellpadding="0" cellspacing="0"
				id="grid">
				<tr>
					<th colspan="col">Nomenclature2/Material Code</th>

					<th colspan="1">New NIP</th>
					<!-- <th scope="col">Injection</th> -->
					<!--  <th scope="col">Unit</th>-->
					<!-- <th scope="col">Unit</th> -->
					<th scope="col">AU</th>
					<th scope="col">Dosage<span>*</span></th>
					<th scope="col">Frequency<span>*</span></th>
					<th scope="col">No. of Days<span>*</span></th>
					<th scope="col">Route</th>
					<!--<th scope="col">Intake</th>-->
					<!-- <th scope="col">Type</th> -->
					<th scope="col">Remarks</th>
					<!-- <th scope="col">CT</th> -->
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
		%> <input type="text" tabindex="1" id="nomenclature<%=inc1 %>"
						size="30" readonly="readonly" value="<%=itemName1%> " size="50"
						name="nomenclature<%=inc1%>" onblur="disableOtherMedicine();" />
						<div id="ac2update1" style="display: none;" class="autocomplete"></div>
						<script type="text/javascript" language="javascript"
							charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature<%=inc1%>','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature<%=inc1%>'});
			</script>
					</td>

					<td><input type="text" name="otherMedicine<%=inc1%>"
						tabindex="1" id="otherMedicine<%=inc1%>" size="20"
						validate="Other Medicine,string,no"
						onblur="showSimilarMedicineNames(this.value);" /></td>
					<td><input type="checkbox" name="injCategory" class="radio" id="injCategory" value="false"   /></td>
					<td><select name="itemConversionId1" id="itemConversionId1"
						tabindex="1" class="medium" disabled="disabled">
							<option value="0">Select</option>
							<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
							<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
							<%} %>
					</select> <%
	    		MasStoreItemConversion  masStoreItemConversion = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion.getItemUnitName()%>";
            </script> <% }%></td>
					<%if(au != null){ %>
					<td><input type="text" name="au<%=inc1%>" tabindex="1"
						value="<%=au %>" id="au<%=inc1%>" size="6" validate="AU,string,no" />
						<input type="hidden" name="actualDispensingQty<%=inc1%>"
						tabindex="1" id="actualDispensingQty<%=inc1%>" value="" size="6"
						validate="AU,string,no" /> <input type="hidden"
						name="highValueMedicine<%=inc1%>" tabindex="1"
						id="highValueMedicine<%=inc1%>" value="" size="1"
						validate="AU,string,no" /></td>
					<%}else{ %>
					<td><input type="text" name="au<%=inc1%>" tabindex="1"
						value="" id="au<%=inc1%>" size="6" validate="AU,string,no" /> <input
						type="hidden" name="actualDispensingQty<%=inc1%>" tabindex="1"
						id="actualDispensingQty<%=inc1%>" value="" size="6"
						validate="AU,string,no" /> <input type="hidden"
						name="highValueMedicine<%=inc1%>" tabindex="1"
						id="highValueMedicine<%=inc1%>" value="" size="1"
						validate="AU,string,no" /></td>
					<%} %>
					<td><input type="hidden" name="pvmsNo<%=inc%>"
						id="pvmsNo<%=inc%>" value="<%=pvmsNo%>" size="10"
						readonly="readonly" /><input type="text" name="dosage<%=inc%>"
						readonly="readonly" id="dosage<%=inc%>" value="<%=dosage%>"
						size="5" tabindex="1" /></td>

					<td><select name="frequency<%=inc1%>" id="frequency<%=inc1%>"
						class="medium" tabindex="1">
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
 %></td>



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
						tabindex="1" id="noOfDays<%=inc1%>" value="" readonly="readonly" /></td>
					<%
			}
		%>
					<%if(route != null && !route.equals("")){ %>
					<td><input type="text" name="route<%=inc1%>" tabindex="1"
						id="route<%=inc1%>" value="<%=route %>" size="5" maxlength="20"
						validate="Route,string,no" /> <input type="hidden"
						name="total<%=inc1%>" tabindex="1" id="total<%=inc1%>" /></td>
					<%}else{ %>
					<td><input type="text" name="route<%=inc1%>" tabindex="1"
						id="route<%=inc1%>" value="" size="5" maxlength="20"
						validate="Route,string,no" /> <input type="hidden"
						name="total<%=inc1%>" tabindex="1" id="total<%=inc1%>" /></td>
					<%} %>
					<%
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
		%>
					<%
		 		 	if (patientPrescriptionDetails.getRemarks() != null) {
		 		 %>
					<td><input type="text" name="remarks<%=inc1%>" tabindex="1"
						id="remarks<%=inc1%>" size="10" value=<%=remark%> class="small"
						readonly="readonly" /></td>
					<%
				} else {
			%>
					<td><input type="text" name="remarks<%=inc1%>" tabindex="1"
						id="remarks<%=inc1%>" size="10" value="" class="small"
						readonly="readonly" /></td>
					<%
				}
			%>
						<td><input type="checkbox" name="ct<%=inc1%>" class="radio" id="ct<%=inc1%>" value="y" />
		</td>
					<td><input type="text" name="closingStock<%=inc1%>"
						disabled="disabled" tabindex="1" value=""
						id="closingStock<%=inc1%>" size="3"
						validate="closingStock,string,no" /></td>

					<td><input name="Button" type="button" class="buttonAdd"
						value="" onclick="addRow();" tabindex="1" /></td>
					<td><input type="button" name="delete" value="Delete"
						class="button" onclick="removeRow('grid','hdb',this);"
						tabindex="1" /></td>

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
	<%
	} else {
	
%> --%>
	<div class="clear paddingTop5"></div>
	
		<div class="floatRight">
			<input name="treatmentTemplate" type="button"
				value="Treatment Assist" tabindex="1" onclick="showTreatment()"
				class="buttonBig" />
				<input name="CimsTemplate" type="button"
				value="CIMS " tabindex="1" onclick="showCIMS()"
				class="buttonBig" />
		</div>
		<div class="clear paddingTop5"></div>
	<h4>	Treatment
	</h4>

	<div id="templateDivToShowHide" class="floatLeft">

		<div class="Block">

			<label>Template</label>
			<div id="treatmentDiv">
				<select name="templateId" id="templateId" tabindex="1">
				
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
				<input name="createPrescriptionTemplate" tabindex="1" type="button"
					value="Create Template" class="buttonBig"
					onclick="showCreatePrescriptionTempate();" />
			</div>
			
			<div>
				<input name="createPrescriptionTemplate" tabindex="1" type="button"
					value="Update Template" class="buttonBig"
					onclick="showUpdateOpdTempate('P');" />
			</div>
			<div id="copyPrevPrescriptionTemplateDiv" style="display: none;">
				<input name="copyPrevPrescriptionTemplate" tabindex="1"
					type="button" value="Copy Previous" class="buttonBig"
					onclick="copyPrevPrescriptionTempate('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>');" />
			</div>

			<div id="prescriptionImportButton" class="floatLeft">
				<input name="prescriptionImportButton1" tabindex="1" type="button"
					value="Import New" class="button"
					onclick="getListForTreatment('treatmentDiv','opdMain');" />

			</div>
	   <div class="floatRight">
				<a href="#"
					onclick="getTodayAllPrescriptionPopup('<%=hinId%>','y','OPD');">Current Medication</a>
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
				<table border="0" align="center" cellpadding="0" cellspacing="0"
					id="nomenclatureGrid">

					<tr>
						<th>Nomenclature/Material Code</th>
	<!-- 					<th colspan="1">New NIP</th> -->
						<!--      <th colspan="1">Injection</th>-->
						<!-- <th scope="col">PVMS No.</th> -->
						<!-- 		<th scope="col">Unit</th> -->
					<!-- 	<th scope="col">Class</th>
						<th scope="col">AU</th> -->
						<th scope="col">Disp. Unit</th>
						<th scope="col">Dosage<span>*</span></th>
						<th scope="col">Frequency<span>*</span></th>
						<th scope="col">Days<span>*</span></th>
						<th scope="col">Total<span>*</span></th>
						<!--
		<th id="sosQtyLbl">Qty</th>
		-->
						<!--  <th scope="col">Total</th>
		<th scope="col">Intake</th> -->
			<!-- 			<th scope="col">Route</th> -->
						<!--<th scope="col">Type</th>-->
						<th scope="col">Instruction</th>
						<!-- <th scope="col">CT</th> -->
						<th scope="col">Stock</th>
						<th>Add</th>
						<th>Delete</th>

					</tr>
					<tr>
						<td><input type="text" value="" tabindex="1"
							id="nomenclature1" size="77" name="nomenclature1"
							onblur="checkForAlreadyIssuedPrescription(this.value,'1',document.getElementById('hinId').value);populatePVMS(this.value,'1');checkItem(1);displayAu(this.value,'1','<%=hinId%>');checkForPurchase(this.value,'1');" />
							<input type="hidden" name="itemId1" id="itemId1" value="" />
							<input type="hidden" name="itemIdClassificationId1" id="itemIdClassificationId1" value="" />
							<div id="ac2updateTreatment1" style="display: none;" class="autocomplete"></div>
							<script type="text/javascript" language="javascript"
								charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2updateTreatment1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script></td>
				<!-- 		<td><input type="text" name="otherMedicine1" tabindex="1"
							id="otherMedicine1" size="20"
							onblur="checkDuplicateOtherMedicine(this.value,'1');readOnlyNomenclature(this.value,'1');showSimilarMedicineNames(this.value);"
							validate="other Medicine,string,no" /></td> -->
	<%-- 					<td><select name="itemClass1" id="itemClass1">
								<option value="0">Select</option>
								<%for(MasItemClass mc : masItemClassList) {%>
								<option value="<%=mc.getId()%>"><%=mc.getItemClassName()%></option>
								<%} %>
						</select> <%
				MasItemClass  Mic = null;

			     for (int i = 0; i < masItemClassList.size(); i++) {
			    	 Mic = (MasItemClass) masItemClassList.get(i);
     			 %> <script>

     			itemClassArray[<%=i%>]= new Array();
     			itemClassArray[<%=i%>][0] = "<%=Mic.getId()%>";
     			itemClassArray[<%=i%>][1] = "<%=Mic.getItemClassName()%>";
            </script> <% }%></td> --%>
					<%-- 	<td><select name="itemConversionId1" id="itemConversionId1"
							tabindex="1" class="medium">
								<option value="0">Select</option>
								<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
								<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
								<%} %>
						</select> <%
	    		MasStoreItemConversion  masStoreItemConversion1 = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion1 = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion1.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion1.getItemUnitName()%>";
            </script> <% }%> <!-- </td> 
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" /> -->
							<input type="hidden" name="au1" tabindex="1" value="" id="au1"
							size="6" validate="AU,string,no" /> </td> --%>
						<td>
						<input type="text" name="dispensingUnit1" tabindex="1" id="dispensingUnit1"  size="6"  validate="AU,string,no"  readonly="readonly"/>
						<%-- <select name="dispensingUnit1" id="dispensingUnit1"
							tabindex="1" class="medium">
								<option value="0">Select</option>
								<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
								<option><%=masStoreItemConversion.getItemUnitName()%></option>
								<%} %>
						</select> --%>
						
						<input type="hidden"
							name="actualDispensingQty1" tabindex="1"
							id="actualDispensingQty1" value="" size="6"
							validate="AU,string,no" /> 
							<input type="hidden" tabindex="1"
							id="itemClassCode1" name="itemClassCode1"
							validate="itemClassCode,string,no" value="" />
							<input type="hidden" tabindex="1"
							id="highValueMedicine1" name="highValueMedicine1"
							validate="highValue,string,no" value="" />
						</td>
						<%-- <td><input type="checkbox" name="injCategory1" class="radio" id="injCategory1" value="y" />
		</td>--%>
						<td><input type="hidden" name="pvmsNo1" tabindex="1"
							id="pvmsNo1" size="10" readonly="readonly" /> <input type="text"
							name="dosage1" tabindex="1" value="" id="dosage1" size="5"
							maxlength="5"
							onblur="checkDosageValidation(this.value,'1');fillValue('1')" /></td>
						<td><select name="frequency1" id="frequency1" tabindex="1"
							class="medium"
							onchange="getFrequencyValue(this.value,'1');fillValueFromFrequency(this.value,'1');displaySOSQty(this.value,'1');fillValue('1')">
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
            </script> <% }%> <input type="hidden" name="frequencyValue1"
							id="frequencyValue1" value=""> <input type="text"
							name="sosQty1" tabindex="1" id="sosQty1" style="display: none;"
							size="3" onblur="fillValue('1')" maxlength="3"
							validate="Sos Qty,num,no" /></td>
						<td><input type="text" name="noOfDays1" tabindex="1"
							id="noOfDays1" onblur="fillValue('1')" size="5" maxlength="3"
							validate="No of Days,num,no" /></td>
						<td><input type="text" name="total1" tabindex="1" id="total1"
							size="5" validate="total,num,no" onblur="treatmentTotalAlert(this.value,1)" /></td>
						<!-- <td><input type="text" name="route1" tabindex="1" id="route1"
							value="" size="5" maxlength="20" validate="Route,string,no" /></td> -->
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

						<td><input type="text" name="remarks1" tabindex="1"
							id="remarks1" size="10" maxlength="15" placeholder="1-1-1"/></td>
						<!-- <td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td> -->
						<td><input type="text" name="closingStock1" tabindex="1"
							value="" id="closingStock1" size="3"
							validate="closingStock,string,no" /></td>

						<td><input name="Button" type="button" class="buttonAdd"
							value="" onclick="addNomenclatureRow();" tabindex="1" /></td>
						<td><input type="button" name="delete" value=""
							class="buttonDel" onclick="removeRow('nomenclatureGrid','nomenclaturehdb',this);"
							tabindex="1" /></td>
					</tr>
					
				</table>
				<input type="hidden" name="nomenclaturehdb" value="1" id="nomenclaturehdb" />
				<div class="clear"></div>
			</div>
		</div>
		<h4>NIP</h4>
		<%int nipInc=500; %>
			<div class="cmntable">
				<table border="0" align="center" cellpadding="0" cellspacing="0"
					id="grid">

					<tr>
						<th>NIP</th>
						<th colspan="1">New NIP</th>
						<!--      <th colspan="1">Injection</th>-->
						<!-- <th scope="col">PVMS No.</th> -->
						<!-- 		<th scope="col">Unit</th> -->
						<th scope="col">Class</th>
						<th scope="col">AU</th>
						<th scope="col">Disp. Unit</th>
						<th scope="col">UOM Qty</th>
						<th scope="col">Dosage<span>*</span></th>
						<th scope="col">Frequency<span>*</span></th>
						<th scope="col">Days<span>*</span></th>
						<th scope="col">Total<span>*</span></th>
						<!--
		<th id="sosQtyLbl">Qty</th>
		-->
						<!--  <th scope="col">Total</th>
		<th scope="col">Intake</th> -->
						<!-- <th scope="col">Route</th> -->
						<!--<th scope="col">Type</th>-->
						<th scope="col">Instruction</th>
						<!-- <th scope="col">CT</th> -->
						<th scope="col">Stock</th>
						<th>Add</th>
						<th>Delete</th>

					</tr>
					<tr>
						<td><input type="text" value="" tabindex="1"
							id="nomenclature<%=nipInc%>" size="30" name="nomenclature<%=nipInc%>"
							onblur="checkForAlreadyIssuedPrescription(this.value,'<%=nipInc%>',document.getElementById('hinId').value);populatePVMS(this.value,'<%=nipInc%>');checkItem(<%=nipInc%>);disableOtherMedicine(this.value,'<%=nipInc%>');displayAu(this.value,'<%=nipInc%>','<%=hinId%>');checkForPurchase(this.value,'<%=nipInc%>');" />
							<input type="hidden" name="itemId<%=nipInc%>" id="itemId<%=nipInc%>" value="" />
							<input type="hidden" name="itemIdClassificationId<%=nipInc%>" id="itemIdClassificationId<%=nipInc%>" value="" />
							<div id="ac2update2" style="display: none;" class="autocomplete"></div>
							<script type="text/javascript" language="javascript"
								charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature<%=nipInc%>','ac2update2','opd?method=getNipItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature<%=nipInc%>'});
			</script></td>
						<td><input type="text" name="otherMedicine<%=nipInc%>" tabindex="1"
							id="otherMedicine<%=nipInc%>" size="20"
							onblur="checkDuplicateOtherMedicine(this.value,'<%=nipInc%>');readOnlyNomenclature(this.value,'<%=nipInc%>');showSimilarMedicineNames(this.value);"
							validate="other Medicine,string,no" /></td>
						<td><select name="itemClass<%=nipInc%>" id="itemClass<%=nipInc%>">
								<option value="0">Select</option>
								<%for(MasItemClass mc : masItemClassList) {%>
								<option value="<%=mc.getId()%>"><%=mc.getItemClassName()%></option>
								<%} %>
						</select> <%
				MasItemClass  Mic = null;

			     for (int i = 0; i < masItemClassList.size(); i++) {
			    	 Mic = (MasItemClass) masItemClassList.get(i);
     			 %> <script>

     			itemClassArray[<%=i%>]= new Array();
     			itemClassArray[<%=i%>][0] = "<%=Mic.getId()%>";
     			itemClassArray[<%=i%>][1] = "<%=Mic.getItemClassName()%>";
            </script> <% }%></td>
						<td><select name="itemConversionId<%=nipInc%>" id="itemConversionId<%=nipInc%>"
							tabindex="1" class="medium">
								<option value="0">Select</option>
								<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
								<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
								<%} %>
						</select> <%
						MasStoreItemConversion masStoreItemConversion1 = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion1 = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion1.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion1.getItemUnitName()%>";
            </script> <% }%> <!-- </td> 
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" /> -->
							<input type="hidden" name="au<%=nipInc%>" tabindex="1" value="" id="au<%=nipInc%>"
							size="6" validate="AU,string,no" /> <input type="hidden"
							name="actualDispensingQty<%=nipInc%>" tabindex="1"
							id="actualDispensingQty<%=nipInc%>" value="" size="6"
							validate="AU,string,no" /> 
							<input type="hidden" tabindex="1"
							id="itemClassCode<%=nipInc%>" name="itemClassCode<%=nipInc%>"
							validate="itemClassCode,string,no" value="" />
							<input type="hidden" tabindex="1"
							id="highValueMedicine<%=nipInc%>" name="highValueMedicine<%=nipInc%>"
							validate="highValue,string,no" value="" /></td>
						<td><select name="dispensingUnit<%=nipInc%>" id="dispensingUnit<%=nipInc%>"
							tabindex="1" class="medium">
								<option value="0">Select</option>
								<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
								<option><%=masStoreItemConversion.getItemUnitName()%></option>
								<%} %>
						</select></td>
			<%-- 			<td><input type="checkbox" name="injCategory<%=nipInc%>" class="radio" id="injCategory<%=nipInc%>" value="y" />
		</td> --%>
		<td><input type="text" name="uomQty<%=nipInc%>" tabindex="1" id="uomQty<%=nipInc%>" maxlength="5" size="5" validate="UOM Qty,float,no"/></td>
							 
						<td><input type="hidden" name="pvmsNo<%=nipInc%>" tabindex="1"
							id="pvmsNo<%=nipInc%>" size="10" readonly="readonly" /> <input type="text"
							name="dosage<%=nipInc%>" tabindex="1" value="" id="dosage<%=nipInc%>" size="5"
							maxlength="5"
							onblur="checkDosageValidation(this.value,'<%=nipInc%>');fillValue('<%=nipInc%>')" /></td>
						<td><select name="frequency<%=nipInc%>" id="frequency<%=nipInc%>" tabindex="1"
							class="medium"
							onchange="getFrequencyValue(this.value,'<%=nipInc%>');fillValueFromFrequency(this.value,'<%=nipInc%>');displaySOSQty(this.value,'<%=nipInc%>');fillValue('<%=nipInc%>')">
								<option value="0">Select</option>
								<%

		      for(MasFrequency masFrequency1 : frequencyList){
		       int id = masFrequency1.getId();
		       String name = masFrequency1.getFrequencyName();
          %>
								<option value="<%=id %>"><%=name%></option>
								<%} %>
						</select> <%
	    		  masFrequency = new MasFrequency();

			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
     			 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%> <input type="hidden" name="frequencyValue<%=nipInc%>"
							id="frequencyValue<%=nipInc%>" value=""> <input type="text"
							name="sosQty<%=nipInc%>" tabindex="1" id="sosQty<%=nipInc%>" style="display: none;"
							size="3" onblur="fillValue('<%=nipInc%>')" maxlength="3"
							validate="Sos Qty,num,no" /></td>
						<td><input type="text" name="noOfDays<%=nipInc%>" tabindex="1"
							id="noOfDays<%=nipInc%>" onblur="fillValue('<%=nipInc%>')" size="3" maxlength="5"
							validate="No of Days,num,no" /></td>
						<td><input type="text" name="total<%=nipInc%>" tabindex="1" id="total<%=nipInc%>"
							size="5" validate="total,num,no" onblur="treatmentTotalAlert(this.value,<%=nipInc%>)" /></td>
					<%-- 	<td>
						<input type="text" name="route<%=nipInc%>" tabindex="1" id="route<%=nipInc%>"
							value="" size="5" maxlength="20" validate="Route,string,no" />
							</td> --%>
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

						<td><input type="text" name="remarks<%=nipInc%>" tabindex="1"
							id="remarks<%=nipInc%>" size="10" maxlength="15" placeholder="1-1-1"/></td>
						<!-- <td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td> -->
						<td><input type="text" name="closingStock<%=nipInc%>" tabindex="1"
							value="" id="closingStock<%=nipInc%>" size="3"
							validate="closingStock,string,no" /></td>

						<td><input name="Button" type="button" class="buttonAdd"
							value="" onclick="addRowForNIP();" tabindex="1" /></td>
						<td><input type="button" name="delete" value=""
							class="buttonDel" onclick="removeRow('grid','hdb',this);"
							tabindex="1" /></td>
					</tr>
					
				</table>
				<input type="hidden" name="hdb" value="<%=nipInc%>" id="hdb" />
				<div class="clear"></div>
			</div>
		 
		
	</div>
	<div class="clear"></div>
   <div class="Block">
		<label>Treatment Advice</label>
		<textarea name="otherTreatment" id="otherTreatment" cols="50" rows="0" maxlength="500"
			tabindex="1" onkeyup="return ismaxlength(this)" class="auto"></textarea>
			<input type="button" class="button" tabindex="3" name="" value="+" onclick="getPresentTemplate('<%=treatmentAdviceCode%>','otherTreatment');" />
	</div> 

	<%-- <%} %> --%>

	<div class="clear"></div>
	<div class="paddingTop40"></div>
	<div class="clear"></div>
	<div class="paddingTop40"></div>
	<div class="clear"></div>
	<div class="Block">
 
		<label>Procedure Care</label> 
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
<!-- 		<div class="floatRight" style="margin-right: 173px">
			<input type="button" class="buttonAdd" alt="Add" tabindex="4"
				value="" onclick="addRowTreatmentNursingCare();" align="left" />
			<input type="button" class="buttonDel" tabindex="3" alt="Delete"
				value="" onclick="removeRowTreatmentNursingCare();"
				align="right" />
				
		</div> -->
		
				<div class="floatLeft" style="width: 350px;">
					<input type="button" class="buttonAdd" alt="Add" tabindex="4"
				value="" onclick="addRowTreatmentNursingCare();" align="left" />
			<input type="button" class="buttonDel" tabindex="3" alt="Delete"
				value="" onclick="removeRowTreatmentNursingCare();"
				align="right" /> 
				<input type="radio" value="<%=HMSUtil.getProperties("adt.properties", "NursingTypeCodeForProcedure")%>" class="radioCheckCol2" id="procedureCheck" style="margin-right: 5px;"
				name="procedureCheck" checked="checked" onchange="">
			<div class="labRadiologyDivfixed">Procedure</div>
			<input type="hidden" id="nurCodePhy" value="<%=HMSUtil.getProperties("adt.properties", "NursingTypeCodeForPhysiotherapy")%>">
			<input type="radio" value="<%=HMSUtil.getProperties("adt.properties", "NursingTypeCodeForPhysiotherapy")%>"  class="radioCheckCol2"
				id="procedureCheck" style="margin-right: 5px;" name="procedureCheck" 
				onchange="">
			<div class="labRadiologyDivfixed">Physiotherapy</div>
			<input type="hidden" name="nursingCategory" id="nursingCategory">

		</div>
		<div class="clear"></div>
		<div id="divTemplet" style="width: 700px;">
			<table border="0" align="center" cellpadding="0" cellspacing="0"
				id="gridNursing">

				<tr>
					<th>&nbsp;</th>
					<th>Nursing Care Name</th>
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
						name="procedureDetailId<%=incr%>" id="procedureDetailId<%=incr%>" />
					<td>
						<%if(procedureStatus.equalsIgnoreCase("y")) {%> <input
						readonly="readonly" type="text" class="opdTextBoxSmall textYellow"
						value="<%=nursingCare %>" id="procedureName_nursing<%=incr%>"
						size="35" name="procedureName_nursing<%=incr%>" <%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 	
										 />
						<%}else{%> <input type="text" class="opdTextBoxSmall textYellow"
						value="<%=nursingCare %>" id="procedureName_nursing<%=incr%>"
						size="35" name="procedureName_nursing<%=incr%>" onblur="validateNursingCare(this.value, <%=incr%>)" <%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 
										  />
						<%}%>
						<input type="hidden" name="procedureType<%=incr%>"
					id="procedureType<%=incr%>" value="" />
						<div id="ac2updates_nursing<%=incr%>" style="display: none;"
							class="autocomplete"></div> <script type="text/javascript"
							language="javascript" charset="utf-8">
											  new Ajax.Autocompleter('procedureName_nursing<%=incr%>','ac2updates_nursing<%=incr%>','registration?method=getProcedureForAutoComplete',{
											  callback: function(element, entry) {
								              return entry + '&minor_major=1'+'&procedureType=' + document.getElementById('nursingCategory').value;
								        }, parameters:'requiredField=procedureName_nursing<%=incr%>'});
									</script>
					</td>
					<td>
						<%-- onchange="populateNoOfDaysForNursingProcedure(this.value,'<%=incr%>')" --%>
						<select name="frequency_nursing<%=incr%>"
						id="frequency_nursing<%=incr%>" tabindex="36"> 
							<option value="">Select</option>
							<%
						   masFrequency = new MasFrequency();
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
						class="opdTextBoxTSmall textYellow" size="5"  validate="No. of days,num,no" /></td>
					<td>
						<%if(procedureStatus.equalsIgnoreCase("y")) {%> <input
						readonly="readonly" value="<%=nursingRemark %>" type="text"
						name="remark_nursing<%=incr%>" id="remark_nursing<%=incr%>"
						class="largTextBoxOpd textYellow" maxlength="100"/> <%}else{ %> <input type="text"
						value="<%=nursingRemark %>" name="remark_nursing<%=incr%>"
						id="remark_nursing<%=incr%>" class="largTextBoxOpd textYellow" maxlength="100"/>
						<%} %>
					</td>
					<%-- 		<td><input class="radioCheck" type="checkbox"
									name="alert_nursing<%=incr %>" name="alert_nursing<%=incr %>" /></td>
							</tr> --%>
					<%} %>
				
			</table>
			<input type="hidden" id="procedureHeaderId" name="procedureHeaderId"
				value="<%=procedureHeaderId%>" />
			</td> <input type="hidden" name="nursinghdb" value="<%=incr-1%>"
				id="nursinghdb" />
		</div>
	</div>
	<%if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCodeForPhychiatrist)) {%>
		<div class="Block">
 
		<label>Therapy Advice</label> <input name="investigationTemplate" value="Appointment Calendar"onclick="openWindow('/hms/hms/opd?method=showProcedureCalenderDoctorWise&opdFlag=y&psyFlag=y')" tabindex="1" class="buttonBig" type="button">
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="floatRight" style="margin-right: 173px">
			<input type="button" class="buttonAdd" alt="Add" tabindex="4"
				value="" onclick="addRowTherapy('t');" align="left" />
			<input type="button" class="buttonDel" tabindex="3" alt="Delete"
				value="" onclick="removeRowTherapy();"
				align="right" /><%-- <label>Appointment Date<span>*</span></label><input type="text" name="procedureDate" id="procedureDate"
			readonly="readonly" value="" onblur="validateDate(this.value ,this.id);"
			 /> <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.getElementById('procedureDate'),event);"/>
			<label>Appointment Time<span>*</span></label><input type="text" id="procedureTime" name="procedureTime" onblur="IsValidTime(this.value,this.id)" onkeyup="mask(this.value,this,'2',':');" maxlength="5"/> --%>
				
		</div>
		<div class="clear"></div>
		<div id="divTemplet" style="width: 700px;">
			<table border="0" align="center" cellpadding="0" cellspacing="0"
				id="gridTherapy">

				<tr>
					<th>&nbsp;</th>
					<th>Therapy Name</th>
					 	<th>Next Appointment/Close</th>
					<!-- <th>Frequency<span>*</span></th>
					<th>No.Of Days<span>*</span></th> -->
					<th>Remarks</th>
					<!-- <th>Alert Me</th> -->
				</tr>
				<%
	 incr=0 ;
	 len=1;
	if(procedureDetails.size()>0){
		len=procedureDetails.size();
	}
	 procedureId=0;
	 procedureHeaderId=0;
	 nursingCare="";
	 nursingRemark="";
	 procedureStatus="";
	 noOfDays=0;
	 frequencyId_1=0;
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
						size="35" onblur="validateTherapy(<%=incr%>);" name="therapy_nursing<%=incr%>" <%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 	
										 />
						<%}else{%> <input type="text" class="opdTextBoxSmall textYellow"
						value="<%=nursingCare %>" id="therapy_nursing<%=incr%>"
						size="35" onblur="validateTherapy(<%=incr%>);" name="therapy_nursing<%=incr%>" onblur="validateTherapy(<%=incr%>)"<%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 
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
						<td>
					<div style="width:370px;">
					<div style="width:110px; float:left;"><input type="radio" name="appointStatus<%=incr%>" id="close<%=incr%>"value="c" style="margin:-3px 5px 0px 0px;" onclick="clearAppointment('appointmentDate<%=incr%>','appointmentTime<%=incr%>','<%=incr%>');" checked="checked">Close</div>
					<div style="width:130px; float:left;"><input type="radio" name="appointStatus<%=incr%>" id="nextAppoint<%=incr%>" value="na" style="margin:-3px 5px 0px 0px;" onclick="markAppointMandatory('<%=incr%>')">Next Appointment</div>
					<div style="width:130px; float:left;"><input type="radio" name="appointStatus<%=incr%>" id="appoint<%=incr%>" value="a" style="margin:-3px 5px 0px 0px;"  onclick="markAppointMandatory('<%=incr%>')">Appointment</div>
					
					<div class="Clear"></div>
					<div class="paddingTop5"></div>			
					<div style="width:110px; padding-top: 6px; float:left;">Appointment Date <span id="appointDateSpan<%=incr%>" style="display: none">*</span></div>
				<%-- 	<input type="text" name="appointmentDate<%=incr%>"
					readonly="readonly" id="appointmentDate<%=incr%>" value="" />
					<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
					validate="Pick a date" class="calender" tabindex="1"
					onClick="setdate('<%=currentDate%>',document.getElementById('appointmentDate<%=incr%>'),event);" /> --%>
							<input  type="text" class="calDate"  id="appointmentDate<%=incr%>" name="appointmentDate<%=incr%>" placeholder="DD/MM/YYYY" validate="LMP Date,string,no" value="" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'appointmentDate<%=incr%>');" maxlength="10" style="width: 120px"/>	
					<div class="Clear"></div>
					<div class="paddingTop5"></div>
					<div style="width:110px; padding-top: 6px; float:left;">Appointment Time <span id="appointTimeSpan<%=incr%>" style="display: none">*</span></div>
					<input type="text" name="appointmentTime<%=incr%>" id="appointmentTime<%=incr%>" onblur="IsValidTime(this.value,this.id)" onkeyup="mask(this.value,this,'2',':');" maxlength="5"/>
					 </div>
			   </td>
					
					<td><%-- input type="text"
						value="<%=nursingRemark%>" name="remark_therapy<%=incr%>"
						id="remark_therapy<%=incr%>" class="largTextBoxOpd textYellow" /> --%>
						<textarea size="20" class="large" id="remark_therapy<%=incr%>" name="remark_therapy<%=incr%>" validate="Remarks,string,no" value="" tabindex="1" style="width: 250px; height: 50px;" maxlength="1000"></textarea>
						</td>
					<%-- 		<td><input class="radioCheck" type="checkbox"
									name="alert_nursing<%=incr %>" name="alert_nursing<%=incr %>" /></td>
							</tr> --%>
					<%} %>
				
			</table>
			<input type="hidden" id="therapyHeaderId" name="therapyHeaderId"
				value="<%=procedureHeaderId%>" />
			</td> <input type="hidden" name="therapyhdb" value="<%=incr-1%>"
				id="therapyhdb" />
		</div>
	</div>
	
	<%} %>
	
	

	<div class="Block">

		<%-- <table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		 <td><a href="#" onclick="javascript:openPopupProcedureAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)"> Procedure Advice</a></td>
		 <td><a href="javascript:openPopupDetentionAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)"> Detention Advice</a></td>
		 <td><a href="#" onclick="javascript:openPopupPhysiotheraphyAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)">  Physiotherapy Advice</a></td>
</tr>
</table> --%>
		<div class="clear"></div>

		<!-- Minor OT -->

		<h4>Surgery advice</h4>

		<div class="floatLeft" style="width: 350px;">
			<input type="button" class="buttonDel" value=""
				onclick="removeSurgicalRow('surgicalGrid');" /> <input
				type="button" class="buttonAdd" onclick="addSurgicalRequRow();"
				value="" /> <input type="radio" value="SurgProc"
				class="radioCheckCol2" id="majorSurgery" style="margin-right: 5px;"
				name="surgeryCheck" checked="checked" onchange="">
			<div class="labRadiologyDivfixed">Major</div>
			<input type="radio" value="MinorSur" class="radioCheckCol2"
				id="minorSurgery" style="margin-right: 5px;" name="surgeryCheck"
				onchange="">
			<div class="labRadiologyDivfixed">Minor</div>
			<input type="hidden" name="surgeryCategory" id="surgeryCategory">

		</div>
		<input name="investigationTemplate" value="OT Calendar"onclick="openWindow('/hms/hms/ot?method=showOtDashboard&opdFlag=y')" tabindex="1" class="buttonBig" type="button">
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
				<th scope="col">Surgery</th>
				<!-- <th scope="col">Tentative Date</th> -->
				<!-- 	<th scope="col">PAC Status</th> -->
				<th scope="col">Select</th>

			</tr>
			<%int i=0;
	String pName="";
	
	%>

			<%
	
	String admisDate="",UHID="",patName="",adNo="",deptName="",inpatientId="";

		i++;


	%>

			<tr>
				<td><%=i%></td>
				<!-- 	<td>1</td>
		<td>2</td>
		<td>3</td>
		<td>4</td>
		<td>5</td> -->
				<!-- <td></td> -->
				<!-- changed by govind 14-10-2016 -->
				<%--<td><input type="text"  name="proscedureName<%=i%>" id="proscedureName<%=i%>" onblur="getProcedureId(this.value,<%=i %>)" />  --%>
				<%-- 		<td><input type="text" class="opdTextBoxSmall textYellow" name="proscedureName<%=i%>" id="proscedureName<%=i%>" 
		
										onblur="checkMappedChargeIP(this.value,'<%=i%>');"										
		 />
		  --%>

				<td><input type="text" class="opdTextBoxSmall textYellow"
					name="proscedureName<%=i%>" id="proscedureName<%=i%>"
					onblur="checkMappedChargeIP(this.value,'<%=i%>');getProcedureId(this.value,<%=i %>);getSurgeryDiv(<%=i %>);" />
					<input type="hidden" name="surgeryType<%=i %>"
					id="surgeryType<%=i %>" value="" /> <%--  <input type="text" value="" tabindex="1" size="40"
			id="chargeCodeName<%=inc %>" name="chargeCodeName<%=inc %>"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
			 --%>
					<div id="ac2update2<%=i%>" style="display: none;"
						class="autocomplete"></div> <script type="text/javascript"
						language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('proscedureName<%=i%>','ac2update2<%=i%>','ipd?method=checkMappedCharge',{minChars:1,
					  callback: function(element, entry) {
				            return entry + '&chargeName=' + document.getElementById('proscedureName<%=i%>').value+'&surgeryCheck=' + document.getElementById('surgeryCategory').value;
				           // return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
				        },parameters:'requiredField=proscedureName<%=i %>'});
				</script> <%--	 <div id="ac2update3<%=i %>" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('proscedureName<%=i %>','ac2update3<%=i %>','ot?method=getInvestigationListForRequestionForIP',{parameters:'requiredField=proscedureName<%=i %>'});
			</script>--%> <!-- changed by govind 14-10-2016 end --> <input
					type="hidden" name="procedureId<%=i %>" id="procedureId<%=i %>"
					value="" /></td>
				<%-- <td><input type="text" size="8" value="<%=date+"/"+month+"/"+year%>" name="tentativeDate<%=i%>" id="tentativeDate<%=i%>"
							validate="Date,date,no" />
							<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.inpatientSurgeryRequisition.tentativeDate1,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
							</td> --%>
				<%-- 	<td><select name="pacstatus<%=i%>" id="pacstatus<%=i%>">
		<!-- <option value="0">select</option> -->
		<option value="Pending">Pending</option>
		<!-- <option value="Cleared">Clear</option>
		<option value="Not Fit">Not Fit</option> -->
		</select>
		</td> --%>

				<td><input type="checkbox" class="smalll" value="1"
					name="surgeryradio<%=i%>" id="surgeryradio<%=i%>" /> <input
					type="hidden" name="<%=INPATIENT_ID %><%=i %>" value="1"
					validate="inpatientId,int,no" /> <%-- <input type="hidden"
					name="<%=HIN_ID%><%=i %>" value="1" validate="hinId,int,no" /> --%></td>
			</tr>


		</table>
		<input type="hidden" name="procCount" value="<%=i %>" id="procCount" />
		<%-- <!-- added by govind 14-10-2016 -->
<input type="hidden" id="admisDate" value="<%=admisDate%>"/>
<input type="hidden"  id="UHID" value="<%=UHID%>"/>
<input type="hidden"  id="patName" value="<%=patName%>"/>
<input type="hidden"  id="IPNo" value="<%=adNo%>"/>
<input type="hidden"  id="deptName" value="<%=deptName%>"/>
<input type="hidden"  id="<%=INPATIENT_ID %>" value="<%=inpatientId%>" validate="inpatientId,int,no" />
<input type="hidden"  id="<%=HIN_ID %>" value="<%=hinId%>" validate="hinId,int,no"/> --%>
		<!-- added by govind 14-10-2016 end -->
		<div class="clear"></div>
		<div class="paddingTop40"></div>
		<!-- <input name="Submit" type="button" align="right" class="button" value="Save"
	onclick="submitSurgryRequisition();" />
	<input type="reset" class="button" name="reset" value="reset" onclick="submitForm('inpatientSurgeryRequisition','ipd?method=showSurgeryRequisitionJspFromPatientList');"/>

<input type="button" class="button" name="reset" value="Back" onclick="submitForm('inpatientSurgeryRequisition','ipd?method=showPatientListJsp');"/>
 -->
		<div class="clear"></div>

		<div id="minorOTSchedulingDiv" style="display: block">
			<label>Surgery Date <span>*</span></label> 
			<input  type="text" class="calDate"  id="tentativeDateId" name="tentativeDate" placeholder="DD/MM/YYYY" validate="Surgery Date,string,no" value="" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'tentativeDate');onSelectSurgeryDate(this.value);" maxlength="10" style="width: 120px"/>
			<%-- <input type="text"
				name="tentativeDate" readonly="readonly" id="tentativeDateId"
				value="" onblur="onSelectSurgeryDate(this.value);" /> 
				
				<img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" class="calender" tabindex="1"
				onClick="setdate('<%=currentDate%>',document.getElementById('tentativeDateId'),event);"
				onchange="onSlelctSurgeryDate();" /> --%> <label>Start Time <span>*</span></label>
			<input id="startTime" type="text" autocomplete="off" maxlength="5"
				onblur="IsValidTime(this.value,this.id)"
				onkeyup="mask(this.value,this,'2',':');" name="startTime"> <label>End
				Time <span>*</span>
			</label> <input id="endTime" type="text" autocomplete="off" maxlength="5"
				onblur="IsValidTime(this.value,this.id);;checkAvailbilityForSurgeryTime(this.value, startTime);""
				onkeyup="mask(this.value,this,'2',':');" name="endTime">

			<div class="clear"></div>

			<label>Department<span>*</span></label> <select id="deptId"
				name="otDepartment" onchange="displayOT(this.value)">
				<option value="0">Select</option>
				<%if(deptList.size()>0){
			for(MasDepartment deptList1 :deptList){
		%>
				<option value="<%=deptList1.getId()%>"><%=deptList1.getDepartmentName()%></option>
				<%}}%>
			</select> <label>OT<span>*</span></label> <select name="otId" id="otId"
				onchange="displayTable(this.value,startTime, endTime,'opdMain','y')">
				<option value="0">Select</option>

			</select> <label>Table<span>*</span></label> <select name="tableId"
				id="tableId">
				<option value="0">Select</option>

			</select>

		</div>
		<!-- End Minor OT -->
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
	
System.out.println(admittedVisit.get(0).getEmployee().getId());
	String doctorName="";
	if(admittedVisit.get(0).getEmployee().getFirstName()!= null){
		doctorName=admittedVisit.get(0).getEmployee().getFirstName();
	}
	if(admittedVisit.get(0).getEmployee().getMiddleName()!= null){
		doctorName+=" "+admittedVisit.get(0).getEmployee().getMiddleName();
	}
	if(admittedVisit.get(0).getEmployee().getLastName()!= null){
		doctorName+=" "+admittedVisit.get(0).getEmployee().getLastName();
	}

%>
		<span style="color: red; padding-left: 10px;">Patient is
			already adviced for admission from <%=doctorName%> (<%=admittedVisit.get(0).getDepartment().getDepartmentName() %>)
		</span>
		<%}

else
{
%>

		<div id="disposalDiv" style="display: inline">
			<label>Additional Advice</label>
			<textarea name="presentAdvice" cols="50" rows="0" maxlength="5000"
				tabindex="1" onkeyup="return ismaxlength(this)" class="auto"></textarea>
			<div class="clear"></div>

			<div id="admissionDiv">
				<div class="clear"></div>
				<%-- 		<label class="autoSpace">Transfer to observation ward <%if(opdPatientDetails!=null && opdPatientDetails.getObservationStatus()!=null && opdPatientDetails.getObservationStatus().equalsIgnoreCase("y")) {%>
							<input type="checkbox" checked="checked" class="radioCheckCol2"
							id="observationStatus" name="observationStatus" /> <%}else{ %> <input
							type="checkbox" class="radioCheckCol2" id="observationStatus"
							name="observationStatus" /> <%} %>
						</label> --%>
				<label>Admission Advised <%--   <%if(opdPatientDetails!=null && opdPatientDetails.getAdmissionAdvised()!=null && opdPatientDetails.getAdmissionAdvised().equalsIgnoreCase("y")) {%>
							<input type="checkbox" checked="checked" class="radioCheckCol2"	id="admissionAdvised" name="admissionAdvised" />
							<%}else{ %>
							<input	type="checkbox" class="radioCheckCol2" id="admissionAdvised"	name="admissionAdvised" />
							<%} %> --%> <input type="checkbox" class="radioCheckCol2"
					id="admissionAdvised" name="admissionAdvised"
					style="margin: 1px 5px 0px 0px;" />
				</label>

				<div id="admDiv" class="collaps">
					<label>Admission Date</label> <input type="text"
						name="admissionDate" id="admissionDate" style="text-align: left;"
						class="dateTextSmall" value="<%=currentDate%>" readonly="readonly"
						onblur="checkAdmte()" /> <img src="/hms/jsp/images/cal.gif"
						width="16" height="16" border="0" validate="Pick a date"
						onclick="setdate('<%=currentDate%>',document.opdMain.admissionDate,event);" />
					<!-- 	<label class="autoSpace">Payward

							<input type="checkbox"
								name="payward" id="payward" class="radioCheckCol2" value="Y"
							 />	
							</label> -->
					<label>Ward</label> <select name="admissionWard"
						id="admissionWard" onclick="getBedStatus(this.value);">
						<option value="0">Select</option>
						<%for(MasDepartment ward:wardDepartmentList){ %>
						<option value="<%=ward.getId()%>"><%=ward.getDepartmentName() %></option>
						<%} %>
					</select>
					<div class="clear"></div>
					<label>Admission  Notes</label>
				<textarea name="admissionNote" validate="referralNote,string,no"
					id="referralNote" cols="0" rows="0" maxlength="500" tabindex="5"
					 style="width: 477px;"></textarea>
					<div id="bedDiv"></div>
				</div>


			</div>
		</div>
		<%} %>
		<div class="clear"></div>
		<div id="detentionDiv" style="display: none">
			<label> Review at</label> <input type="text" name="reviewAt"
				size="92" class="auto" id="reviewAtId"
				validate="Review at,string,no" value="" MAXLENGTH="200" />
		</div>
		<div class="clear"></div>
	</div>

	<div class="clear"></div>
	<% if(admittedVisit.size() ==0) 
		{ %>
	<h4>Referral</h4>

	<div class="Block">

		<%  String relationName=""; %>

		<div id="referalDiv">

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
					value="Internal" onclick="checkReferTO('referInternal');"
					style="margin: 1px 5px 0px 0px;" />Internal</label>
					   
<% if(visit.getHin().getPatientType()!=null && visit.getHin().getPatientType().getPatientTypeName().equalsIgnoreCase(patientTypeNameForHAL) && visit.getHin().getEmployee()!=null && !visit.getHin().getEmployee().getEmployeeType().getEmployeeTypeCode().equalsIgnoreCase(empTypeCodeForContract))
{ %>

				<label	class="autoSpace"><input type="radio"
					class="radioCheckCol2" name="referTo" id="referExternal"
					value="Empanel" onclick="checkReferTO('referExternal');"
					style="margin: 1px 5px 0px 0px;" />Empanel</label>
					
					<label class="autoSpace"><input type="radio" class="radioCheckCol2" name="referTo" id="referBoth" 
				value="Both" onclick="checkReferTO('Both');" style="margin:1px 5px 0px 0px;" />Both</label>
<%} %>
				<div class="clear"></div>
				<label>Refer Date:</label> 
				 <input type="text" name="referVisitDate" id="referVisitDate" class="calDate"  placeholder="DD/MM/YYYY" onkeyup="mask(this.value,this,'2,5','/');"  value="<%=currentDate%>" />
			
			
				<!-- onblur="checkAdmte()" -->
				<label id="priorityLabelId">Current Proirity No.</label> <select
					id="priorityId" name="priorityName" tabindex="1">
					<option value="3">3</option>
					<option value="2">2</option>
					<option value="1">1</option>
				</select>
				<!-- <div class="clear"></div> -->
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
									
									</select> --%>
				<%--<label id="referHospitalTypeLabel">Hospital Type</label>  <select
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
				<!-- <div class="clear"></div> -->
			<div id="referDepartmentDiv">
				<div class="clear"></div>
				<table  id="referGrid">
				<tr><th>Department</th><th>Doctor</th>	<th scope="col">Add</th>
		<th scope="col">Delete</th>
				<tr>
				
				<td>
					<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" validate="Department,number,no"> --%>
					<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" onchange="getDetails(this.value);" validate="Department,number,no" > --%>
					<select id="deptId1" name="refereddept1"
						onchange="fnGetAvailableDoctor(this.value,'refereddoctor1');">
						<option value="0">Select</option>
						<%
				deptId=(Integer)session.getAttribute("deptId");
				if(deptList!= null){i=0;
				for (MasDepartment masDepartment : deptList) {
			%>

						<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
  <script>
    departmentArray[<%=i%>]= new Array();
    departmentArray[<%=i%>][0] = "<%=masDepartment.getId()%>";
    departmentArray[<%=i%>][1]= "<%=masDepartment.getDepartmentName()%>";

                 
            </script>
						<%i++;}
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
				<label id="referhospitalLabel" style="display: none;">Hospital
					<span>*</span>
				</label> <select id="referhospital" name="referhospital"
					onchange="fnGetHospitalDepartment(this.value);"
					style="display: none;">
					<option value="0">Select</option>
					<%for(MasImpanneledHospital msih:masImpanneledHospitalList){%>
					<option value="<%=msih.getId()%>"><%=msih.getImpanneledHospitalName()%></option>
					<%}%>
				</select> <label id=referdayslLabel style="display: none;">No. of
					Days</label> <input id="referdays" name="referdays" type="text"
					maxlength="2" style="display: none;" />

				<div class="clear"></div>

			<%-- 	<label id="referdepartmentLabel">Department <span>*</span></label>
				<select id="referdepartment" name="referdepartment"
					onchange="fnGetAvailableDoctor(this.value,'refereddoctor');">
					<option value="0">Select</option>
					<%for(MasDepartment dep:deptList){
										%>
					<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
							<%if(deptId==dep.getId()) {%>
										<option value="<%=dep.getId()%>" selected="selected"><%=dep.getDepartmentName()%></option>
										<%}else{ %>
										<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
										<%} %>
					<%}%>
				</select> <label id="refereddoctorlabel">Doctor <span>*</span></label> <select
					id="refereddoctor" name="refereddoctor">
					<option value="0">Select</option>
				</select> --%>


				<div class="clear"></div>
				<label style="display: none">Patient Advise</label>
				<textarea name="patientAdvise" validate="patientAdvise,string,no"
					id="patientAdvise" cols="0" rows="0" maxlength="500" tabindex="5"
					onkeyup="return checkLength(this)" style="display: none"></textarea>
				<!-- <input type="button" class="buttonAuto-buttn" value="+"
										onclick="" /> -->
				<label id="referral_treatment_type_label" style="display: none">Treatment Type <span>*</span></label>
				<select id="referral_treatment_type" name="referral_treatment_type" style="display: none">
					<option value="1" selected="true">OPD</option>
					<option value="2">Admission</option>
				</select> <label id="referredForLabel"  style="display: none">Referred For<span>*</span></label> <input
					id="referredFor" name="referredFor" type="text" maxlength="300"
					validate="" style="display: none" /> 
					<div class="clear"></div><label>Referral Notes</label>
				<textarea name="referralNote" validate="referralNote,string,no"
					id="referralNote" cols="0" rows="0" maxlength="500" tabindex="5"
					onkeyup="return checkLength(this)" style="width: 477px;"></textarea>
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

	<input id="visitId" name="visitId" type="hidden"
		value="<%=visit.getId()%>" /> <input id="visitId1"
		name="<%=VISIT_ID %>" type="hidden" value="<%=visit.getId()%>" /> <input
		name="hinId" id="hinId" type="hidden" value="<%=visit.getHin().getId()%>" /> <input
		name="departmentId" type="hidden"
		value="<%=visit.getDepartment().getId()%>" /> <input
		name="hospitalId" type="hidden" id="hospitalId"
		value="<%=hospitalId%>" />
		<input
		name="ItemClassCodeForLiquid" type="hidden" id="ItemClassCodeForLiquid"
		value="<%=ItemClassCodeForLiquid%>" />
		
	<%if(visit.getDoctor() != null){ %>
	<input name="empId" type="hidden"
		value="<%=visit.getDoctor().getId()%>" />
	<%}%>
	
	
		
	<input name="deptId" type="hidden" value="<%=deptId%>" /> <input
		name="<%=SERVICE_NO%>" type="hidden"
		value="<%=visit.getHin().getServiceNo()%>" /> <input
		name="<%=VISIT_NUMBER%>" type="hidden" value="<%=visit.getVisitNo()%>" />
	<input name="<%=HIN_NO%>" type="hidden"
		value="<%=visit.getHin().getHinNo()%>" /> <input
		name="consultationDate" id="consultationDate" type="hidden" value="<%=consultationDate%>" />
	<input name="consultationTime" type="hidden"
		value="<%=consultationTime%>" /> <input name="relation" type="hidden"
		value="<%=visit.getHin().getRelation().getRelationName()%>" />
	<%
	String orderSeqNo="";
	if(mapForDS.get("orderSeqNo") != null){
		orderSeqNo = (String)mapForDS.get("orderSeqNo");
	}
%>
	<input name="<%=ORDER_NO %>" type="hidden" value="<%=orderSeqNo %>" />
	<input name="physioRequisitionHeaderId" id="physioRequisitionHeaderId"
		type="hidden" value="0" /> <input name="procedureHeaderId"
		id="procedureHeaderId" type="hidden" value="0" />
	<div class="clear"></div>
	<div class="division"></div>
	<input name="Submit11" type="button" tabindex="1" align="right"
		class="button" value="Submit" onclick="submitOPDMainForm();" /> <input
		name="Reset" type="reset" tabindex="1" align="right" class="button"
		value="Reset" onclick="resetdata()" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="paddingTop40"></div>
	<!--main content placeholder ends here-->
	<script type="text/javascript">
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
		                    	
		                    	 if(document.getElementById('diagnosisId').options[1]!=null && document.getElementById('diagnosisId').options[1].value ==document.getElementById('NAIcd').value){
		         			    	document.getElementById('NAIcd').checked=false;obj.remove(1);}
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



	
	
	function displaySOSQty(val,inc){
		
/* 	if(val == '13'){
		document.getElementById('sosQty'+inc).style.display = 'block';
		document.getElementById('noOfDays'+inc).disabled = true;
	 }else{
	
	 document.getElementById('sosQty'+inc).style.display  = 'none';
	  document.getElementById('noOfDays'+inc).disabled = false;
	 } */
	}
	
	function getFrequencyValue(feqValue,inc){
		feqValue =  document.getElementById('frequency'+inc).value;
		var feqQty;
	<%
	if(frequencyList.size()>0){	
		for(MasFrequency masFrequency1 :frequencyList){
	%>
	 if(feqValue == '<%=masFrequency1.getId()%>'){
		 feqQty = '<%=masFrequency1.getFeq()%>'
		
	  }

	<%}
	}%>
	 document.getElementById('frequencyValue'+inc).value = feqQty;
	}
	


	/*  function  fillValueFromFrequency(value,inc){
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
	 } */


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

		
        document.opdMain.action="hms/hms/opd?method=submitOPDPatientDetails";
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


/*   function showCreatePrescriptionTempate(){
        
  		document.getElementById('prescriptionImportButton').style.display = 'inline';
	   	var url="/hms/hms/opd?method=showCreatePrescriptionTempate";
	    newwindow=window.open(url,'presciption',"height=500,width=1010,status=1,top=0,left=2");
	   
	     } */

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



/*  function getListForTreatment(val){
 	if(val=='investigationDiv'){
		submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
	}else if(val=='treatmentDiv'){
		submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
	}
//	document.getElementById('prescriptionImportButton').style.display = 'none';
//	document.getElementById("investigationImportButton").style.display='none'
 } */


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
/* 	function showHideDrugTemplateCombo(valueOfTemplate){
		 if(checkTemplateId(valueOfTemplate)){
		  	document.getElementById("copyPrevPrescriptionTemplateDiv").style.display='none';

			submitProtoAjax('opdMain','/hms/hms/opd?method=showGridInMainJsp','testDiv');
		} 
	} */
	function showHideInvestigationTemplateCombo(){
/* 		var invId="";
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
submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=showGridForInvestigation&investigationTemplateId='+invId,'gridview'); */
				
				}
	//}
	
	

	

	
	
//end	

	function submitOPDMainForm(){
	//	if(validateFieldValuesForMainSubmit()){
	
	//var referedToMH =document.getElementById('referedToMH').value;
	if(confirm("Do You want to submit the Record!?")){
/* 	 if(document.getElementById('referedToMH').checked == true){
			if(validateFrequency() && validateDays()){
				//submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=responseForDoctarsList&referredDepartmentId='+indexes+'','referredDoctarsIdDiv');
				
				submitForm('opdMain','opd?method=submitOPDPatientDetails&referedToMH=y&flag=opd');
		}
	 } */
	 
		 if( validateICD()&& validatePregnancy()  &&  validateNip() &&  validateFrequency() && validateDays()  && validateProcedure()&& validateTherapy() &&  validateReferal() &&  validateAdmission() && validateSurgery()  ){
				//submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=responseForDoctarsList&referredDepartmentId='+indexes+'','referredDoctarsIdDiv');
				enablePhysioProcedure();
				var str=document.getElementById("presentComplain").value.replace(/(\n)/g, ',');
		        //document.getElementById("presentComplain").value=str.substring(0, str.length - 1);
		           document.getElementById("presentComplain").value=str.substring(0, str.length);
				str=document.getElementById("familyHistory").value.replace(/(\n)/g, ',');
		        document.getElementById("familyHistory").value=str.substring(0, str.length - 1);
		        
		            document.getElementById("familyHistory").value=str.substring(0, str.length);
				submitForm('opdMain','opd?method=submitOPDPatientDetails&referedToMH=n&flag=opd');
		}
	
		return true;
	}else{
		return false;
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

    


</script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript">

var $j = jQuery.noConflict();


</script>

</form>




<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<SCRIPT>
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		String userName="";
		if(session.getAttribute("userName")!=null)
		 userName=(String)session.getAttribute("userName");
		
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		//String Session=(String) utilMap.get("session");
		String time = (String) utilMap.get("currentTime");		
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	
	</script>
<script type="text/javascript">
var bankArray=new Array();
</script>

<script type="text/javascript">

animatedcollapse.addDiv('jason', 'fade=1,height=80px')
animatedcollapse.addDiv('kelly', 'fade=1,height=100px')
animatedcollapse.addDiv('michael', 'fade=1,height=120px')

animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide4', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide5', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide6', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide7', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide8', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide9', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide10', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide11', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide12', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide13', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

function checkForInvestReferToMH()
 {
 	var inc=document.getElementById('hiddenValue').value;
 	var i;
 	for(i=1;i<=inc;i++)
 	{
 		if(document.getElementById('investigationReferToMH'+i).checked==true)
 		{
 			document.getElementById('uploadReport'+i).style.display='inline';
 		}		
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
</script>

<script type="text/javascript">
<%String Labresult="NotPresent";
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
//List<MbTypeOfEntryMaster> typeOfEntryMasterList = new ArrayList<MbTypeOfEntryMaster>();
//List<MasUnit> masUnitList = new ArrayList<MasUnit>();
//List<MasMaritalStatus> masMaritalStatusList = new ArrayList<MasMaritalStatus>();
//List<MasRank> masRankList1 = new ArrayList<MasRank>();
String entryno="";
String entryno1="";
if(map.get("medicalEntryNo")!=null)
{
	entryno = (String) map.get("medicalEntryNo");

}
if(map.get("medicalEntryNo1")!=null)
{
	entryno1 = (String) map.get("medicalEntryNo1");

}
/*
if(map.get("mbTypeOfEntryMaster")!=null)
{
	typeOfEntryMasterList = (List) map.get("mbTypeOfEntryMaster");
}
if(map.get("masUnitList")!=null)
{
	masUnitList = (List) map.get("masUnitList");
}
if(map.get("masMaritalStatusList")!=null)
{
	masMaritalStatusList = (List) map.get("masMaritalStatusList");
}
if(map.get("masRankList")!=null)
{
	masRankList1 = (List) map.get("masRankList");
}
*/
List templateList= new ArrayList();
if(map.get("templateList") != null){
templateList=(List)map.get("templateList");
}

List visitlist = new ArrayList();

if(map.get("visit") != null){
	visitlist=(List)map.get("visit");
	}
Visit visit=null;
if(visitlist!=null &&visitlist.size()>0)
{
 visit=(Visit)visitlist.get(0);
}
String service_no="";
if(visit.getHin()!=null){
	service_no=visit.getHin().getServiceNo();
}
String rank="";
if(visit.getHin().getRank()!=null){
	rank=visit.getHin().getRank().getRankName();
}

String url="";
if(map.get("url") != null){
	url = (String)map.get("url");
}
/*
List<MasServiceType> serviceTypeList =null;
List<MasState> stateList = null;
List<MasMaritalStatus> maritalStatusList = null;
	if(map.get("serviceTypeList") != null){
		serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
	}
if(map.get("stateList") != null)	{
	stateList = (List<MasState>)map.get("stateList");
	}
if(map.get("maritalStatusList") != null){
		maritalStatusList = (List<MasMaritalStatus>)map.get("maritalStatusList");
}
*/
List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
if(map.get("medExamList") != null){
	medExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("medExamList");
}
MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();

if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
}
List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
if(map.get("masMedicalExaminationDetailList") != null){
	masMedicalExaminationDetailList = (List<MasMedicalExaminationDetail>)map.get("masMedicalExaminationDetailList");
}
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();	
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
}
Set<PatientInvestigationDetails> patientInvestigationdetails=null;
PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
if(map.get("patientInvestigationHeader")!=null){
	patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
	patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
}

Properties properties = new Properties();
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
DgOrderhd dgOrderhd=null;
Set<DgOrderdt> getDgOrderdts=null;
if(map.get("dgOrderhd")!=null){
	
	dgOrderhd=(DgOrderhd)map.get("dgOrderhd");
	getDgOrderdts=dgOrderhd.getDgOrderdts();
}
List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
if(map.get("resultList") != null){
	resultList=(List)map.get("resultList");
	}
List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
if(map.get("masHospitalList") != null){
	masHospitalList=(List)map.get("masHospitalList");
}
if(map.get("masDepartmentList") != null){
	masDepartmentList=(List)map.get("masDepartmentList");
}
List<MasEmployee> loginEmployeeList = new ArrayList<MasEmployee>();
if(map.get("loginEmployeeList") != null){
	loginEmployeeList=(List)map.get("loginEmployeeList");
}
String signedBy="";
//if(session.getAttribute("users")!=null){
//Users user = (Users) session.getAttribute("users");
//if(loginEmployeeList.size()>0){
	//for(MasEmployee masEmployee:loginEmployeeList){
	//	signedBy=masEmployee.getFirstName();
	//	if(masEmployee.getMiddleName()!=null){
	//		signedBy=signedBy+" "+masEmployee.getMiddleName();
	//	}
	//	if(masEmployee.getLastName()!=null){
	//		signedBy=signedBy+" "+masEmployee.getLastName();
	//	}			}}
List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
if(map.get("employeeMoList")!=null)
{
	employeeMoList = (List<MasEmployee>) map.get("employeeMoList");
}
if(employeeMoList.size()>0){
	for(MasEmployee masEmployee:employeeMoList){
		//loginEmpId=masEmployee.getId();
		signedBy=masEmployee.getFirstName();
		if(masEmployee.getMiddleName()!=null){
			signedBy=signedBy+" "+masEmployee.getMiddleName();
		}
		if(masEmployee.getLastName()!=null){
			signedBy=signedBy+" "+masEmployee.getLastName();
		}
	}
}
List<MasMedicalExaminationDetail> masMedicalExaminationIllList = new ArrayList<MasMedicalExaminationDetail>();
if(map.get("masMedicalExaminationIllList") != null){
	masMedicalExaminationIllList = (List<MasMedicalExaminationDetail>)map.get("masMedicalExaminationIllList");
}

//}
%>
function checkTemplateId(templateId){
	
    if(templateId=="0"){
      return true;
    }else{
      return true;
    }
  }

</script>
<% 
String message="";
if (map.get("message") != null) {
       message = (String) map.get("message");
   }
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>

<div><%-- 
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" onClick="submitForm('medicalBoardMOForm16','opd?method=showPatientPreviousVisitForViewScreen&link=medicalExam&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>');" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" class="buttonBig2" onClick="submitForm('medicalBoardMOForm16','medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>');" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" class="buttonBig2" onClick="submitForm('medicalBoardMOForm16','medicalExam?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo() %>');" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onClick="submitForm('medicalBoardMOForm16','opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>');" />
</div>--%>
<div>
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" 
	onclick="openPopupPatientPreviousVisit();" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" 
	class="buttonBig2" onClick="getPrevMedExamFromHIC();" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" 
	class="buttonBig2" onClick="getPrevMedBoardFromHIC();" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" 
	class="buttonBig2" onClick="showPatientPreVisitHospitality();" />
</div>
<!--main content placeholder starts here-->
<div class="titleBg">
<h2>AFMSF-16</h2>
</div>
<div class="clear"></div>
<body onLoad="coolDental()">
<form name="medicalBoardMOForm16" action="" method="post">
<%
int medExamId = 0;
int visitId=0;
if(medExamObj.getId()!= null){
	medExamId = medExamObj.getId();
	
}
int hinId=0;
if(medExamObj.getVisit()!=null){
	visitId=medExamObj.getVisit().getId();
	hinId=medExamObj.getHin().getId();
}
%>
<input type="hidden" name="medExamId" value="<%=medExamId %>"/>
<input type="hidden" name="visitId" value="<%=visitId %>"/>
<input type="hidden" name="<%=HIN_ID%>" value="<%=hinId %>" id="hinId"/>
<!--Block One Starts-->
<div class="clear"></div>
<div class="Block">
<label>Authority for Board</label>
 <% 
 String authority="";
 if(medExamObj.getAuthority()!=null){ 
 authority=medExamObj.getAuthority();
 }%>
<input tabindex="1" type="text"  name="<%=AUTHORITY_OF_BOARD %>" maxlength="100" value="<%=authority %>"
	onKeyUp="limitText(this,100);"  />
	
 <%if(session.getAttribute("hospitalName")!=null){ %>
<label>Place </label> 
<input tabindex="1" type="text" maxlength="20"  id="" name="<%=PLACE %>"  value="<%=((String)session.getAttribute("hospitalName")) %>"
	onKeyUp="limitText(this,20);" readonly="readonly" class="auto" size="50" />
<%}%>

<div class="clear"></div>
<div class="clear"></div>
<label>Date Of Discharge</label>
<%if(medExamObj.getDateOfDischarge() !=null){ %>
<input tabindex="1" type="text"	name="dateOfDischarge" class="calDate" maxlength="10"  class="auto"
onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfDischarge()) %>" validate="Discharge Date,date,no" />
<%}else{ %>
 <input tabindex="1" type="text"	name="dateOfDischarge" class="calDate" maxlength="10"  class="auto"
onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>" validate="Discharge Date,date,no" />
<%} %>
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
		class="calender" onclick="setdate('',medicalBoardMAForm16.dateOfDischarge,event);" />
	<label>Date</label>
<%if(medExamObj.getId()==null)
{%>	
	 <input tabindex="1" type="text"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10"  class="auto"
		onkeyup="mask(this.value,this,'2,5','/');" value="<%=date %>"
		validate="Reported Date,date,no" /> 
<% }else if(medExamObj.getDateOfReporting() !=null){%>
	 <input tabindex="1" type="text"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10" disabled="disabled"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfReporting()) %>"
		validate="Reported Date,date,no" /> 

<% }else{%>
 <input tabindex="1" type="text"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10"  class="auto"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
		validate="Reported Date,date,no" /> 
<%} %>

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
		class="calender" onclick="setdate('',medicalBoardMOForm16.<%=REPORTED_DATE%>,event);" />
		</div>
<div class="clear paddingTop15"></div>
<div class="Block">
  <label> Date of Release  </label>
  <input tabindex="1" name="<%=DATE_OF_RELEASE %>" class="date" value="<%=date %>"
	validate="Date of Release,date,no" maxlength="10"  onKeyUp="mask(this.value,this,'2,5','/');" /> 
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
 class="calender" onclick="setdate('',medicalBoardMOForm16.<%=DATE_OF_RELEASE%>,event);" />
<label>Name  </label> 
<%String sPersonName="";
sPersonName=visit.getHin().getSFirstName();
if(visit.getHin().getSMiddleName() !=null){
	sPersonName=sPersonName+" "+visit.getHin().getSMiddleName();
}
if(visit.getHin().getSLastName() !=null){
	sPersonName=sPersonName+" "+visit.getHin().getSLastName();
}
%>
 <input type="text" value="<%=sPersonName %>" readonly="readonly" name="<%=FULL_NAME%>"	tabindex="2"/>
 
<label>Service No. </label>
<% if(visit.getMedExamType()!=null){%>
 <input type="hidden"	value="<%= visit.getMedExamType() %>" name="medicalExamType" tabindex="2" />
 
<% }else{%>

 <input type="hidden" value="Medical Board AFMSF 16" name="medicalExamType" tabindex="2" />
<% }%>
 <input type="text"	 name="<%=SERVICE_NO %>" readonly="readonly" tabindex="2" value="<%=visit.getHin().getServiceNo()%>"/>
 <label>Rank  </label> 
   <input type="text" value="<%= visit.getHin().getRank().getRankName() %>" readonly="readonly" name="<%=RANK%>"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="2" maxlength="20" />
 
  <label>Unit </label> 
 <% if(visit.getHin().getUnit()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>" tabindex="2" value="<%=visit.getHin().getUnit().getUnitName() %>"/>
 <input type="hidden" value="<%=visit.getHin().getUnit().getId() %>" name="<%=UNIT_ID%>"	tabindex="2" />
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>" tabindex="2" />
 <% }%>
 <label>Service</label> 
 <input	type="text" value="<%=  visit.getHin().getServiceType().getServiceTypeName() %>" readonly="readonly" name="serviceiaf"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID%>"	tabindex="2" maxlength="20" />
 <div class="clear"></div>
 <label>Branch/Trade  </label> 
<% if(visit.getHin().getTrade()!=null){%>
 <input	type="text"  name="<%=TRADE%>"	readonly="readonly" tabindex="2" value="<%= visit.getHin().getTrade().getTradeName() %>" maxlength="20" />
  <input	type="hidden"  name="<%=TRADE_ID%>"	tabindex="2" value="<%= visit.getHin().getTrade().getId() %>" maxlength="20" />

<% }else{%>
 <input	type="text"  name="<%=TRADE%>"	tabindex="2" readonly="readonly"/>
 
 <% }%>
 <%if(visit.getAge()!= null){ %>
<input type="hidden" name="ageId" id="ageId" value="<%=visit.getAge() %>">
<%} %>
<%if(visit.getHin().getSex() != null){  %>
<input type="hidden" name="genderId" id="genderId" value="<%=visit.getHin().getSex().getId() %>">
<%} %>
 
 <label>Total Service  </label> 
  <%if(visit.getHin().getServiceYears()!=null)
 { %>
 <input	type="text" readonly="readonly" value="<%= visit.getHin().getServiceYears() %>" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" />
 <% }else{%>
 <input	type="text" value="" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" />
 <% }%>
 
 <label>DOB </label>
 <%
 if(visit.getHin().getDateOfBirth()!=null){%>
  <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly" class="" value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>"
	validate="DOB,date,yes" maxlength="12"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
<%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_OF_BIRTH %>,event);"/>--%>

	<% }else{%>
<input	tabindex="1" name="<%=DATE_OF_BIRTH %>" class="" value="30/09/1982"
	validate="DOB,date,yes" maxlength="12"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
<%--<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_OF_BIRTH %>,event);" />--%>
	
	<% }%> 
 

 <div class="clear"></div> 
<label>Total Flying Hours</label> 
 <!-- Code By Mukesh 16 March 2012 -->
 <%if(medExamObj.getHoursOfFlown()!=null)
 { %>
 <input	type="text" readonly="readonly" value="<%=medExamObj.getHoursOfFlown() %>" name="<%=HOURS_OF_FLOWN%>"	maxlength="100" tabindex="1" onKeyUp="mask(this.value,this,'2',':');" onBlur="checkTime('medicalBoardMOForm16','<%=HOURS_OF_FLOWN%>');"/>
 <% }else{%>
 <input	type="text" value="" name="<%=HOURS_OF_FLOWN%>"	maxlength="100" tabindex="1" onKeyUp="mask(this.value,this,'2',':');" onBlur="checkTime('medicalBoardMOForm16','<%=HOURS_OF_FLOWN%>');"/>
 <% }%>
 <%--
<input	type="text" maxlength="5" value="" name="totalFlyingHrs" 	tabindex="2" />
 --%>
 <label >DOE/DOC</label> 
  <%if(visit.getHin().getCommissionDate()!=null)
 { %>
 <input	tabindex="2" readonly="readonly" name="<%=DATE_COMMENCEMENT %>"   value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getCommissionDate()) %>"	 validate="Date of Commission,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }else{%>
 <input	tabindex="2" name="<%=DATE_COMMENCEMENT %>"  value="<%=date %>"	validate="Date of Commission,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
 
 <% }%>
 
 <label >Permanent Address</label>
 <!-- Code By Mukesh 16 March 2012 -->
  <%
String addressOnLeave="";

if(medExamObj.getPermanentAddress()!=null)
 {
	addressOnLeave=medExamObj.getPermanentAddress();
 }
%>
 <textarea cols="20" rows="2" tabindex="1" id="<%=PERMANENT_ADDRESS%>" name="<%=PERMANENT_ADDRESS%>" tabindex="1" onkeyup="chkLength(this,99);" readonly="readonly"><%=addressOnLeave %></textarea>
<%--  
<textarea rows="" cols=""  class="medium" name="<%=PERMANENT_ADDRESS %>" class="large" onkeyup="chkLength(this,50);" ></textarea>
  --%>
 <div class="clear"></div>
 <div class="floatLeft">
 <label >Identification Marks</label> 
 <%
 String identification1="";
 String identification2="";
 if(medExamObj.getIdentificationMarks1()!=null){
	 identification1=medExamObj.getIdentificationMarks1();
 }
 if(medExamObj.getIdentificationMarks2()!=null){
	 identification2=medExamObj.getIdentificationMarks2();
 } 
 %>
<label class="valueAuto">1</label><input tabindex="1" type="text" validate="Identification Marks1,string,no" maxlength="50"  id="<%=IDENTIFICATION_MARKS1 %>" name="<%=IDENTIFICATION_MARKS1 %>" maxlength="6" 
	 value="<%=identification1%>"	onKeyUp="limitText(this,50);" class="auto" size="50"  />
<div class="clear"></div>
<input class="transparent" size="28">
<label class="valueAuto">2</label><input tabindex="1" type="text" validate="Identification Marks2,string,no" maxlength="50"  id="<%=IDENTIFICATION_MARKS2 %>" name="<%=IDENTIFICATION_MARKS2 %>"  
 value="<%=identification2%>"	onKeyUp="limitText(this,50);" class="auto" size="50"  />
</div>

<div class="smallest floatRight">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridDisability">
	<tr>
<th scope="col">Disability</th>
<th>Add</th>
<th>Delete</th>
</tr>

<% int incDisability=0;
/*
if(medExamObj.getMasmedicaldetail()!=null)
{
	for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
*/
if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
{
for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationDetailList){
		if(masMedicalExamDetails.getParticular()!=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("detail"))
	{
			++incDisability;
			int icdId=0;
			String icdCd="";
			if(masMedicalExamDetails.getMasIcd()!=null){
				icdId=masMedicalExamDetails.getMasIcd().getId();
				icdCd=masMedicalExamDetails.getMasIcd().getIcdCode();
			}
			String disabilityStr="";
			disabilityStr=masMedicalExamDetails.getPrincipal()+"["+icdCd+"]"+"["+icdId+"]";
	%>
	<tr>
<td>

<!-- <input name="disability" id="Disability" type="text"  value="" tabindex="1" class="auto" size="50"/> -->

<input 	name="systemDiagnosis<%=incDisability %>" value="<%=disabilityStr%>"	id="systemDiagnosis1" tabindex="1" class="auto" size="50" onblur="" readonly="readonly"/>
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		<%-- new Ajax.Autocompleter('systemDiagnosis<%=incDisability %>','ac2update','medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=systemDiagnosis<%=incDisability %>'}); --%>
		  new Ajax.Autocompleter('systemDiagnosis<%=incDisability %>','ac2update','opd?method=getICDForIdList',{parameters:'requiredField=systemDiagnosis<%=incDisability %>'});
		</script>
</td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForDisability();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('gridDisability','hdbDisability',this);" tabindex="1" />
</td>
</tr>
	<%
	}
}
%>
<input type="hidden" name="hdbDisability" value="<%=incDisability%>" id="hdbDisability" />
<% }
  if(incDisability <=0){
  incDisability=1; %>
<tr>
<td>
<!-- <input name="disability" id="Disability" type="text"  value="" tabindex="1" class="auto" size="50"/> -->
<input 	name="systemDiagnosis<%=incDisability %>" value=""	id="systemDiagnosis1" tabindex="1" class="auto" size="50" onblur="" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
  <%--new Ajax.Autocompleter('systemDiagnosis<%=incDisability%>','ac2update','medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=systemDiagnosis1'});
--%>
new Ajax.Autocompleter('systemDiagnosis<%=incDisability%>','ac2update','opd?method=getICDForIdList',{parameters:'requiredField=systemDiagnosis1'});
</script>
</td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForDisability();" tabindex="1" />
</td>
<td>
&nbsp;
<%--
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowDisability();" tabindex="1" />
 --%>
</td>
<input type="hidden" name="hdbDisability" value="<%=incDisability %>" id="hdbDisability" />
</tr>
<%} %>
</table>
</div>
</div>
<div class="clear paddingTop15"></div>
<h4>SERVICE DETAILS <a href="javascript:animatedcollapse.toggle('slide1')"></a></h4>
<div class="clear"></div>
<div id="slide2">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
<tr>
<TH scope="col">Sl No.</TH>
<TH scope="col" colspan="2">From</TH>
<TH scope="col" colspan="2">To</TH>
<TH scope="col">Place</TH>
<TH>P/F</TH>
<th>Add</th>
<th>Delete</th>
</tr>
<% int inc12=0;
/*
if(medExamObj.getMasmedicaldetail()!=null)
{
	for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
*/
if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
{
for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationDetailList){
		if(masMedicalExamDetails.getParticular()!=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("detail1"))
	{	inc12=inc12+1;	%>

<tr>
<% if(masMedicalExamDetails.getSerialno()!=null){%>
<td><input type="text" name="<%=SIRIAL_NO+inc12 %>" value="<%=masMedicalExamDetails.getSerialno() %>" tabindex="1" size="1" class="auto" readonly="readonly"/></td>
<% }else{%>
<td><input type="text" name="<%=SIRIAL_NO+inc12 %>" tabindex="1" size="1" class="auto" readonly="readonly"/></td>

<% }%>
<% if(masMedicalExamDetails.getAddressfrom()!=null){ %>
<td width="10%"><input tabindex="1" class="autoArial" size="11" type="text" id="from<%=inc12 %>"	name="<%=FROM+inc12 %>" maxlength="10" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getAddressfrom()) %>"/></td>
<% }else{ %>
<td width="10%"><input tabindex="1" type="text"	class="autoArial" size="11" name="<%=FROM+inc12 %>" id="from<%=inc12 %>" maxlength="10" />
<% }%>
</td>
<td>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMOForm16.<%=FROM+inc12%>,event);" />
</td>
<% if(masMedicalExamDetails.getAddressto()!=null ){%>
<td width="10%">
<input tabindex="1" type="text" class="autoArial" size="11"	name="<%=TO+inc12 %>" id="to<%=inc12 %>" maxlength="10" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getAddressto()) %>"/></td>
<% }else{%>
<td width="10%">
<input tabindex="1" type="text"	class="autoArial" size="11" name="<%=TO+inc12 %>" id="to<%=inc12 %>" maxlength="10" />
</td>
<% }%>
<td>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMOForm16.<%=TO+inc12%>,event);" />
</td>
<% if(masMedicalExamDetails.getPlace()!=null && ! masMedicalExamDetails.getPlace().equalsIgnoreCase("null")){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc12 %>" maxlength="99" value="<%=masMedicalExamDetails.getPlace() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc12 %>" maxlength="99" /></td>
<% }%>
<%
String pf_no="";
if(masMedicalExamDetails.getPno()!=null && ! masMedicalExamDetails.getPno().equalsIgnoreCase("null")){
	pf_no=masMedicalExamDetails.getPno();
}
%>
<%--
<%if(masMedicalExamDetails.getPno()!=null && ! masMedicalExamDetails.getPno().equalsIgnoreCase("null")){ %>
<td width="10%"><input tabindex="1" type="text"	name="<%=P_NO+inc12 %>" maxlength="10" value="<%=masMedicalExamDetails.getPno() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=P_NO+inc12 %>" maxlength="10" /></td>
<% }%> --%>
<td width="10%">
<select name="<%=P_NO+inc12 %>" id="<%=P_NO+inc12 %>" validate="P/F,string,no">
<option value="">select</option>
<option value="Peace">Peace</option>
<option value="Field">Field</option>
<option value="MFA">MFA</option>
</select>
<script type="text/javascript">
	document.getElementById('<%=P_NO+inc12 %>').value ='<%=pf_no%>';
</script>
</td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid','hdb',this);" tabindex="1" />
</td>

</tr>
<input type=hidden name="<%=SERVICEID+inc12 %>" value="<%=masMedicalExamDetails.getServiceid()%>" id="serviceId" />
<%
	}
}}
if(inc12<=0){
inc12=1;%>
<tr>
<td width="10%"><input tabindex="1"  type="text" readonly="readonly" name="<%=SIRIAL_NO+inc12 %>" value=<%=inc12%> size="1" maxlength="10" /></td>
<td width="10%">
<input tabindex="1" type="text" size="11" readonly="readonly"	id="from<%=inc12 %>" name="<%=FROM+inc12 %>" maxlength="10" />
</td>
<td>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMOForm16.<%=FROM+inc12%>,event);" />
</td>
<td width="10%"><input tabindex="1" size="11" type="text" id="to<%=inc12 %>" readonly="readonly"	name="<%=TO+inc12 %>" maxlength="10" />
</td>
<td>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMOForm16.<%=TO+inc12 %>,event);" />
</td>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc12 %>" maxlength="99" /></td>
<td width="10%">
<%--<input tabindex="1" type="text"	name="<%=P_NO+inc12 %>" maxlength="10" /> --%>
<select name="<%=P_NO+inc12 %>" id="<%=P_NO+inc12 %>" validate="P/F,string,no">
<option value="">select</option>
<option value="Peace">Peace</option>
<option value="Field">Field</option>
<option value="MFA">MFA</option>
</select>
</td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow(),displayNextDate(<%=inc12%>);" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid','hdb',this);" tabindex="1" />
</td>
</tr>
<% }%>
<input type="hidden" name="hdb" value="<%=inc12%>" id="hdb" />
</table>
</div>

<div class="clear"></div>

	
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>Disease,Wound or Injuries Details<a href="javascript:animatedcollapse.toggle('slide3')"></a></h4>
<div class="clear"></div>
<div id="slide3">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid1">
<tr>
<th scope="col" rowspan="2">Sl No.</th>
<th rowspan="2" scope="col">Illness/Wound/Injury</th>
<th colspan="2" rowspan="2" scope="col">First Started on</th>
<th rowspan="2" scope="col">First Started at</th>
<th rowspan="2">Where Treated</th>
<th colspan="4">Approximate Dates and Periods Treated</th>
<th rowspan="2">Add</th>
<th rowspan="2">Delete</th>
</tr>
<tr>
	<TH colspan="2">From</TH>
	<th colspan="2">To</th>
</tr>
<% int inc11=0;
/*
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
*/
//if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
if(masMedicalExaminationIllList!=null && masMedicalExaminationIllList.size()>0)
{
for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationIllList){
	if(masMedicalExamDetails.getParticular()!=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("particular") && masMedicalExamDetails.getBeforeDisability().equalsIgnoreCase("n")){
		inc11=inc11+1; %>
<TR>
 <% if(masMedicalExamDetails.getSerialNo1()!=null){%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly" name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" value="<%=masMedicalExamDetails.getSerialNo1() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly" name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" /></td>
 <% }%>
 <%--
 <% if(masMedicalExamDetails.getIllness()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11 %>" maxlength="10" value="<%=masMedicalExamDetails.getIllness() %>"/></td>
  <% }else{%>

<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11 %>" maxlength="10" /></td>
 <% }%>
  --%>
  <%
  String illness="";
  if(masMedicalExamDetails.getIllness()!=null){
	  illness=masMedicalExamDetails.getIllness();
  }
  int icdId=0;
  String icdCod="";
/*	if(masMedicalExamDetails.getSystemDiagnosis()!=null){
		icdId=masMedicalExamDetails.getSystemDiagnosis().getId();
	}*/
  if(masMedicalExamDetails.getMasIcd()!=null){
		icdId=masMedicalExamDetails.getMasIcd().getId();
		icdCod=masMedicalExamDetails.getMasIcd().getIcdCode();
	}
	if(illness!=""){
		illness=illness+"["+icdCod+"]"+"["+icdId+"]";
	}
  %>
<td width="10%"> 
<input type="text" tabindex="1" value="<%=illness%>" id="<%=ILLNESS+inc11 %>"  name="<%=ILLNESS+inc11 %>"	class="auto"  size="22" 
 	readonly="readonly"/></td>
 
<td width="10%">
 <% if(masMedicalExamDetails.getParticulardate()!=null){%>
<input type="text"	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>"  size="11" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getParticulardate())%>"
validate="First Started on,date,no" maxlength="10" id="particulardate" onKeyUp="mask(this.value,this,'2,5','/');" />
<% }else{%>
<input	type="text" tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" size="11" 	validate="First Started on,date,no" maxlength="10" id="particulardate" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }%>
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMOForm16.<%=PARTICULAR_DATE+inc11%>,event);" />
</td>

<%if(masMedicalExamDetails.getPlace1()!=null){ %>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="99" 
		value="<%=masMedicalExamDetails.getPlace1()%>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="99" /></td>
 <% }%>

 <% if(masMedicalExamDetails.getTreated()!=null){%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" maxlength="99" value="<%=masMedicalExamDetails.getTreated() %>"/></td>
  <% }else{%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" maxlength="99" /></td>
 <% }%>

<td width="20%">
 <% if(masMedicalExamDetails.getApproximatedate1()!=null){  %>
<input type="text"	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" size="11" value="<%=HMSUtil.convertDateToStringTypeDateOnly(masMedicalExamDetails.getApproximatedate1())%>"	validate="Approximate Dates and Periods Treated To,String,no" maxlength="30"
	 />
  <% }else{%>
<input  type="text"	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" size="11"	validate="Approximate Dates and Periods Treated To,String,no" maxlength="30" />
 <% }%>
  </td>
  <td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMOForm16.<%=APPROXIMATE_DATE+inc11%>,event);" />

</td>
<td width="20%">
 <%if(masMedicalExamDetails.getApproximatedate2()!=null){  %>
<input type="text"	tabindex="1" name="<%=APPROXIMATE_DATE2+inc11 %>" id="approximatedate2" size="11"
value="<%=HMSUtil.convertDateToStringTypeDateOnly(masMedicalExamDetails.getApproximatedate2())%>"	validate="Approximate Dates and Periods Treated From,String,no" maxlength="30"/>
  <% }else{%>
<input  type="text"	tabindex="1" name="<%=APPROXIMATE_DATE2+inc11 %>" id="approximatedate2" size="11"	validate="Approximate Dates and Periods Treated To,String,no" maxlength="30" />
 <% }%>
  </td>
  <td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMOForm16.<%=APPROXIMATE_DATE2+inc11%>,event);" />
</td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow1();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid1','hdb1',this);" tabindex="1" />
<%
		String beforeDisability="";
		if(masMedicalExamDetails.getBeforeDisability()!=null){
			beforeDisability=masMedicalExamDetails.getBeforeDisability();
		}else{
			beforeDisability="n";
		}
%>
<input type=hidden name="beforeDisability<%=inc11 %>" id="beforeDisability<%=inc11 %>" value="<%=beforeDisability%>"  />
</td>
</TR>
<input type=hidden name="<%=SERVICEID+inc11 %>" value="<%=masMedicalExamDetails.getServiceid()%>"  />
<% }}}
	if(inc11<=0){
	inc11=1;
%>
<TR>
<td width="10%"><input name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" value="<%=inc11 %>" tabindex="1" size="2" type="text" readonly="readonly"/></td>
<td width="10%">
<%--
<input tabindex="1" type="text"	name="<%=ILLNESS+inc11 %>" maxlength="10" />
  --%>
 <input type="text" tabindex="1"	value="" id="<%=ILLNESS+inc11 %>"  name="<%=ILLNESS+inc11 %>"	class="auto"  size="22" />
<div id="ac2updatex2"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  <%--new Ajax.Autocompleter('<%=ILLNESS+inc11 %>','ac2updatex2','medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=<%=ILLNESS+inc11 %>'});
		--%>
		new Ajax.Autocompleter('<%=ILLNESS+inc11 %>','ac2updatex2','opd?method=getICDForIdList',{parameters:'requiredField=<%=ILLNESS+inc11 %>'});
		</script>
</td>
<td width="10%">
<input	type="text" tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" size="11" 	validate="First Started on,date,no" maxlength="10" id="particulardate" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />

</td>
<td>
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMOForm16.<%=PARTICULAR_DATE+inc11%>,event);" />

</td>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="99" size="15"/></td>

<td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" maxlength="99" /></td>

<td width="20%">
<input  type="text"	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" size="11"	validate="Approximate Dates and Periods Treated To,String,no" maxlength="30" />
  </td>
  <td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	 class="calender"	onclick="setdate('',medicalBoardMOForm16.<%=APPROXIMATE_DATE+inc11%>,event);" />
</td>
<td width="20%">
<input  type="text"	tabindex="1" name="<%=APPROXIMATE_DATE2+inc11 %>" id="approximatedate2" size="11"	validate="Approximate Dates and Periods Treated From,String,no" maxlength="30" />
  </td>
  <td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
	class="calender" onclick="setdate('',medicalBoardMOForm16.<%=APPROXIMATE_DATE2+inc11%>,event);" />
</td>
 <td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow1();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid1','hdb1',this);" tabindex="1" />

<input type=hidden name="beforeDisability<%=inc11%>" id="beforeDisability<%=inc11%>" value="n"  />

</td>
</TR>

<% } %>
<input type="hidden" name="hdb1" value="<%=inc11%>" id="hdb1" />
</table>
</div>
	</div>
	
<!--Disease,Wound or Injuries Details  Ends-->
<div class="clear paddingTop15"></div>
<!-- Code By Mukesh 16 March 2012 -->
<%
String displayStyle="";
String displayValue="";
if(medExamObj.getDisabilitybefore()!=null){
	
	displayValue=medExamObj.getDisabilitybefore();
	if(displayValue.equalsIgnoreCase("y")){
		displayStyle="inline";
	}else{
		displayStyle="none";
	}
}else{
	displayStyle="inline";
}
%>
<div class="Block">
<label class="large2">Did you suffer from any disability before joining the Armed Forces </label>
<select name="<%=DISABILITY_BEFORE%>" tabindex="1" id="<%=DISABILITY_BEFORE%>" onchange="showHideDisabilityBefore();" class="small">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>
<script type="text/javascript">
document.getElementById('disabilitybefore').value ='<%=displayValue%>';
</script>

</div>
<div class="clear"></div>

<!--If yes then below details and dates option will appear (By Anshu)-->


<div class="cmntable" id="beforeDisabilityDiv" style="display: <%=displayStyle%>;">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridIllness">
	<tr>
<th scope="col" rowspan="">Sl No.</th>
<th rowspan="" scope="col">Illness/Wound/Injury Details</th>
<th colspan="" rowspan="" scope="col">First Started on</th>
<th colspan="2" scope="col">First Started at</th>
<th rowspan="">Where Treated</th>

<th >Add</th>
<th >Delete</th>
</tr>



<% int incBefore=0;
/*
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
*/
if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
{
for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationDetailList){
	if(masMedicalExamDetails.getBeforeDisability()!=null && masMedicalExamDetails.getBeforeDisability().equalsIgnoreCase("y")){
		incBefore=incBefore+1;
	%>

<TR>

 <% if(masMedicalExamDetails.getSerialno()!=null){%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly"	name="<%=SIRIAL_NO1%>1<%=incBefore %>" maxlength="3" value="<%=masMedicalExamDetails.getSerialno() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly" name="<%=SIRIAL_NO1%>1<%=incBefore %>" maxlength="3" /></td>
 <% }%>
 <%--
 <% if(masMedicalExamDetails.getIllness()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS%>1<%=incBefore %>" maxlength="10" value="<%=masMedicalExamDetails.getIllness() %>"/></td>
  <% }else{%>

<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS%>1<%=incBefore %>" maxlength="10" /></td>
 <% }%>
  --%>
 <td width="10%">
   <%
  String illness="";
  if(masMedicalExamDetails.getIllness()!=null){
	  illness=masMedicalExamDetails.getIllness();
  }
  int icdId=0;
  String icdCe="";
	/*if(masMedicalExamDetails.getSystemDiagnosis()!=null){
		icdId=masMedicalExamDetails.getSystemDiagnosis().getId();
	}*/
  if(masMedicalExamDetails.getMasIcd()!=null){
		icdId=masMedicalExamDetails.getMasIcd().getId();
		icdCe=masMedicalExamDetails.getMasIcd().getIcdCode();
	}
	if(illness!=""){
		illness=illness+"["+icdCe+"]"+"["+icdId+"]";
	}
  %>
 <input type="text" tabindex="1" value="<%=illness%>" id="<%=ILLNESS%>1<%=incBefore %>"  name="<%=ILLNESS%>1<%=incBefore %>"	class="auto"  size="35" />
<div id="ac2updatex3"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  <%--new Ajax.Autocompleter('<%=ILLNESS%>1<%=incBefore %>','ac2updatex3','medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=<%=ILLNESS%>1<%=incBefore %>'});
		   //document.getElementById('slide0').style.display="hide"
--%>
new Ajax.Autocompleter('<%=ILLNESS%>1<%=incBefore %>','ac2updatex3','opd?method=getICDForIdList',{parameters:'requiredField=<%=ILLNESS%>1<%=incBefore %>'});
</script>
</td>
<td width="10%">
 <% if(masMedicalExamDetails.getParticulardate()!=null){%>
<input	tabindex="1" name="<%=PARTICULAR_DATE%>1<%=incBefore %>" size="11" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getParticulardate())%>"
	validate="First Started on,date,no" maxlength="10" id="particulardate1<%=incBefore %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
  <% }else{%>
<input	tabindex="1" name="<%=PARTICULAR_DATE%>1<%=incBefore %>" size="11" 	validate="First Started on,date,no" maxlength="10" id="particulardate1<%=incBefore %>" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }%>
 </td>
 <td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMOForm16.<%=PARTICULAR_DATE%>1<%=incBefore%>,event);" />

</td>

 <% if(masMedicalExamDetails.getPlace()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1%>1<%=incBefore %>" maxlength="99" value="<%=masMedicalExamDetails.getPlace()%>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1%>1<%=incBefore %>" maxlength="99" /></td>
 <% }%>

 <% if(masMedicalExamDetails.getTreated()!=null){%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED%>1<%=incBefore %>" maxlength="99" value="<%=masMedicalExamDetails.getTreated() %>"/></td>
  <% }else{%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED%>1<%=incBefore %>" maxlength="99" /></td>
 <% }%>

<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRowBefore();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('gridIllness','hdbBefore',this);" tabindex="1" />
</td>

</TR>
<input type=hidden name="<%=SERVICEID%>1<%=incBefore %>" value="<%=masMedicalExamDetails.getServiceid()%>"  />
<%
String beforeDisability="";
if(masMedicalExamDetails.getBeforeDisability()!=null){
	beforeDisability=masMedicalExamDetails.getBeforeDisability();
}else{
	beforeDisability="y";
}
%>
<input type=hidden name="beforeDisability<%=incBefore %>" id="beforeDisability<%=incBefore %>" value="<%=beforeDisability%>"  />

<%
}}}

if(incBefore<=0){
	incBefore=1;%>
	<TR>
<td width="10%"><input tabindex="1" size="2" type="text"	readonly="readonly" name="<%=SIRIAL_NO1%>1<%=incBefore %>" maxlength="3" value="<%=incBefore %>"/></td>
<%--
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS%>1<%=incBefore %>" maxlength="10" /></td>
 --%>
  <td width="10%">
 <input type="text" tabindex="1"	value="" id="<%=ILLNESS%>1<%=incBefore %>"  name="<%=ILLNESS%>1<%=incBefore %>"	class="auto"  size="35" />
<div id="ac2updatex3"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  <%--new Ajax.Autocompleter('<%=ILLNESS%>1<%=incBefore %>','ac2updatex3','medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=<%=ILLNESS%>1<%=incBefore %>'});
		   //document.getElementById('slide0').style.display="hide"
--%>
new Ajax.Autocompleter('<%=ILLNESS%>1<%=incBefore %>','ac2updatex3','opd?method=getICDForIdList',{parameters:'requiredField=<%=ILLNESS%>1<%=incBefore %>'});
</script>
</td>
<td width="10%">
<input	tabindex="1" name="<%=PARTICULAR_DATE%>1<%=incBefore %>" size="11" 	validate="First Started on,date,no" maxlength="10" id="particulardate1<%=incBefore %>" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />

</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMOForm16.<%=PARTICULAR_DATE%>1<%=incBefore%>,event);" />

</td>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1%>1<%=incBefore %>" maxlength="99" /></td>

<td width="10%"><input tabindex="1" type="text"	name="<%=TREATED%>1<%=incBefore%>" maxlength="99" /></td>
 <td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRowBefore();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('gridIllness','hdbBefore',this);" tabindex="1" />
</td>
<input type=hidden name="beforeDisability1<%=incBefore %>" id="beforeDisability1<%=incBefore %>" value="y"/>
</TR>

<% }%>
<input type="hidden" name="hdbBefore" value="<%=incBefore%>" id="hdbBefore" />
</table>
</div>
<script type="text/javascript">
function showHideDisabilityBefore(){
	if(document.getElementById('disabilitybefore').value == 'y'){
	  	document.getElementById("beforeDisabilityDiv").style.display='inline';
	}else{
		document.getElementById("beforeDisabilityDiv").style.display='none';
	}
}

</script>


<div class="Block">

<script>
<%
	String incidentsDuringYourService="";
	if(medExamObj.getIncidentsDuringYourService()!= null){
		incidentsDuringYourService=medExamObj.getIncidentsDuringYourService();
	}
	String reasonWoundInjury="";
	if(medExamObj.getReasonWoundInjury()!= null){
		reasonWoundInjury=medExamObj.getReasonWoundInjury();
	}
	
	// Code By Mukesh Date 16 March 2012
	String medBoardHeld="";
	String displayInjuryStyle="";
	if(medExamObj.getMedBoardHeld()!= null){
		medBoardHeld=medExamObj.getMedBoardHeld();
		if(medBoardHeld.equalsIgnoreCase("y")){
			displayInjuryStyle="inline";
		}else{
			displayInjuryStyle="none";
		}
	}else{
		displayInjuryStyle="inline";
	}
	String injuryReport="";
	if(medExamObj.getInjuryReport()!= null){
		injuryReport=medExamObj.getInjuryReport();
	}
	
%>


</script>
<label class="large2">Details of any incidents during your service which you think caused/made your disability worse</label> 
<textarea name="incidents_during_your_service" id="incidents_during_your_service" rows="" cols="" class="large"><%=incidentsDuringYourService%></textarea>

<div class="clear"></div>
<label class="large2">In case of wound/injury, state how they happened</label>
<textarea rows="" cols="" name="<%=REASON_WOUND_INJURY%>" id="<%=REASON_WOUND_INJURY%>"   class="large"><%=reasonWoundInjury%></textarea>
<div class="clear"></div>
<label class="large2">Med Board/ Court of inquiry was held</label>
<select name="MED_BOARD_HELD" id="MED_BOARD_HELD" class="small"  onchange="showHideCourtOfInquiry();">
<option value="">Select</option>
<option value="y">Yes</option>
<option value="n">No</option>
</select>
<script type="text/javascript">
document.medicalBoardMOForm16.MED_BOARD_HELD.value='<%=medBoardHeld%>';
</script>
<input class="transparent" size="1" />
<div id="injuryReportDiv" style="display: <%=displayInjuryStyle%>;">
<label>Injury Report</label>
<select name="INJURY_REPORT" id="INJURY_REPORT">
<option value="Submitted">Submitted</option>
<option value="Not Submitted">Not Submitted</option>
</select>
<script type="text/javascript">
document.medicalBoardMOForm16.INJURY_REPORT.value='<%=injuryReport%>';
</script>
</div>
<script type="text/javascript">
function showHideCourtOfInquiry(){
	if(document.getElementById('MED_BOARD_HELD').value == 'y'){
	  	document.getElementById("injuryReportDiv").style.display='inline';
	}else{
		document.getElementById("injuryReportDiv").style.display='none';
	}
}

</script>

<div class="clear"></div>
<label class="large2">Any other health information</label> 

<% if(medExamObj.getAnyOtherInformationAboutYourHealth()!=null){%>
<textarea rows="" cols="71" class="large"   	name="<%=OTHER_INFORMATION %>" class="large" onkeyup="chkLength(this,100);" ><%=medExamObj.getAnyOtherInformationAboutYourHealth() %></textarea>
 <% }else{%>
<textarea rows="" cols="71" class="large"  	name="<%=OTHER_INFORMATION %>" class="large" onkeyup="chkLength(this,100);" ></textarea>
 <% }%>
 
 <div class="clear"></div>
 
</div>

<div class="clear paddingTop15"></div> 
<div class="Block">
<%
String individualSign="";
if(medExamObj.getIndividualDigitalSign() !=null){
individualSign=medExamObj.getIndividualDigitalSign();}%>
<label>Signature of Individual</label>
 <input type="text" value="" name="<%=SIGN%>" id="<%=SIGN%>" maxlength="30" value="<%=individualSign %>" disabled="disabled"/>
 
 <label>Service No.</label>
 <input type="text" value="<%=service_no%>" name="<%=SIGN%>" id="<%=SIGN%>"/>
 
  <label>Rank</label>
 <input type="text" value="<%=rank %>" name="<%=SIGN%>" id="<%=SIGN%>"/>
 
 <label>Date</label>
 <input type="text" name="<%=SIGN_DATE%>" value="<%=date%>" tabindex="2" maxlength="20" size="11" readonly="readonly" />  
 
</div>

 <!-- End Of COde for New MA Form 16 -->
<div class="clear paddingTop15"></div>
<h4>Dental <a href="javascript:animatedcollapse.toggle('slide1')"></a></h4>
<div class="clear"></div>
<div id="slide1">
<div class="Block">
<div class="clear"></div>
<% if(medExamObj.getDentalValue()!=null){%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value="<%=medExamObj.getDentalValue()%>"/>
<% }else{%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value=""/>
<%} %>
<label >Total No. of Teeth</label>
  <% if(medExamObj.getTotalTeeth()!=null){%>
 
 <input tabindex="1"	type="text"   name="<%=TOTAL_NO_OF_TEETH %>" class="small" value="<%=medExamObj.getTotalTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }else{%>
<input tabindex="1"	type="text"  name="<%=TOTAL_NO_OF_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }%>
 
	
<label class="medium3">Total No. of Defective Teeth</label>
 <% if(medExamObj.getTotalDefectiveTeeth()!=null){%>
<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" value="<%=medExamObj.getTotalDefectiveTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }else{%>
<input tabindex="1"	type="text"  name="<%=DEFECTIVE_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }%>
	<label class="medium3">Total No. of Dental Points</label> 
	<% if(medExamObj.getDenstlPoint()!=null){%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>" value="<%=medExamObj.getDenstlPoint() %>"
	onKeyUp="isNumber(this);" maxlength="2" /> 


 <% }else{%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }%>

	<div class="clear"></div>
	
<label >Missing </label> 
	<% if(medExamObj.getMissingTeeth()!=null){%>
<input tabindex="1" type="text" 
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);" value="<%=medExamObj.getMissingTeeth() %>"
	maxlength="2" />
 <% }else{%>
<input tabindex="1" type="text"
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);"	maxlength="2" />
 <% }%>
<label class="medium3">Unsaveable</label>

<% if(medExamObj.getUnservisableTeeth()!=null){%>
<input	tabindex="1" type="text"   name="<%=MISSING_UNSERVICABLE_TEETH %>" value="<%=medExamObj.getUnservisableTeeth() %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }else{%>
<input	tabindex="1" type="text"  name="<%=MISSING_UNSERVICABLE_TEETH %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }%> 
 <label class="medium3">Condition of Gums</label>

<% if(medExamObj.getConditionOfGums()!=null){%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" value="<%=medExamObj.getConditionOfGums() %>"
	 onchange="return CheckAlpha(event);"  id="txtAlpha" maxlength="100" validate="Condition Of Gums,Alphabetic,Yes" />
	

 <% }else{%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>"
 onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="100" value="Healthy" validate="Condition Of Gums,Alphabetic,Yes"/>

 <% }%> 
<div class="clear"></div>


<h4>Missing Teeth</h4>
<div class="clear"></div>
<label >UR</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_8%>" value="" class="radioAuto" id="d1" onclick="chkValue(this);"  />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_7%>" value="" class="radioAuto" id="d2" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUR_6%>" value="" class="radioAuto" id="d3" onclick="chkValue(this);" />
<label class="smallAuto">6</label> 	
<input tabindex="1" type="checkbox"
	name="<%=MUR_5%>" value="" class="radioAuto" id="d4" onclick="chkValue(this);" />
<label class="smallAuto">5</label> 	

<input tabindex="1" type="checkbox"
	name="<%=MUR_4%>" value="" class="radioAuto" id="d5"  onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 	
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_3%>" value="" class="radioAuto" id="d6"  onclick="chkValue(this);" />
<label class="smallAuto">3</label> 	
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_2%>" value="" class="radioAuto" id="d7" onclick="chkValue(this);" />
<label class="smallAuto">2</label> 	

<input tabindex="1" type="checkbox"
	name="<%=MUR_1%>" value="" class="radioAuto" id="d8"  onclick="chkValue(this);" />
<label class="smallAuto">1</label> 

<div class="clear"></div>
<label>UL</label>
<input tabindex="1" type="checkbox"
	name="<%=MUL_8%>" value="" class="radioAuto" id="d9" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MUL_7%>" value="" class="radioAuto" id="d10" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_6%>" value="" class="radioAuto" id="d11" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_5%>" value="" class="radioAuto" id="d12" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_4%>" value="" class="radioAuto" id="d13" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_3%>" value="" class="radioAuto" id="d14" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_2%>" value="" class="radioAuto" id="d15" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_1%>" value="" class="radioAuto" id="d16" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_8%>" value="" class="radioAuto" id="d17"  onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MLR_7%>" value="" class="radioAuto" id="d18"  onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLR_6%>" value="" class="radioAuto" id="d19" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLR_5%>" value="" class="radioAuto" id="d20" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLR_4%>" value="" class="radioAuto" id="d21" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLR_3%>" value="" class="radioAuto" id="d22" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLR_2%>" value="" class="radioAuto" id="d23" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLR_1%>" value="" class="radioAuto" id="d24" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 

<div class="clear"></div>
<label class=>LL</label>
<input tabindex="1" type="checkbox"
	name="<%=MLL_8%>" value="" class="radioAuto" id="d25" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MLL_7%>" value="" class="radioAuto" id="d26" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLL_6%>" value="" class="radioAuto" id="d27" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_5%>" value="" class="radioAuto" id="d28" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLL_4%>" value="" class="radioAuto" id="d29" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLL_3%>" value="" class="radioAuto" id="d30" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_2%>" value="" class="radioAuto" id="d31" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_1%>" value="" class="radioAuto" id="d32" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> <div class="clear"></div>


<h4>Unsaveable Teeth</h4>
<div class="clear"></div>
<label >UR</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_8%>" value="" class="radioAuto" id="d33" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=UUR_7%>" value="" class="radioAuto" id="d34" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUR_6%>" value="" class="radioAuto" id="d35" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUR_5%>" value="" class="radioAuto" id="d36" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUR_4%>" value="" class="radioAuto" id="d37" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUR_3%>" value="" class="radioAuto" id="d38" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUR_2%>" value="" class="radioAuto" id="d39" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUR_1%>" value="" class="radioAuto" id="d40" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>
	<div class="clear"></div>


<div class="clear"></div>
<label >UL</label>
<input tabindex="1" type="checkbox"
	name="<%=UUL_8%>" value="" class="radioAuto" id="d41" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=UUL_7%>" value="" class="radioAuto" id="d42" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUL_6%>" value="" class="radioAuto" id="d43" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUL_5%>" value="" class="radioAuto" id="d44" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUL_4%>" value="" class="radioAuto" id="d45" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUL_3%>" value="" class="radioAuto" id="d46" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUL_2%>" value="" class="radioAuto" id="d47" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUL_1%>" value="" class="radioAuto" id="d48" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_8%>" value="" class="radioAuto" id="d49" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=ULR_7%>" value="" class="radioAuto" id="d50" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_6%>" value="" class="radioAuto" id="d51" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_5%>" value="" class="radioAuto" id="d52" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_4%>" value="" class="radioAuto" id="d53" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_3%>" value="" class="radioAuto" id="d54" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_2%>" value="" class="radioAuto" id="d55" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_1%>" value="" class="radioAuto" id="d56" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 

<div class="clear"></div>
<label >LL</label>
<input tabindex="1" type="checkbox"
	name="<%=ULL_8%>" value="" class="radioAuto" id="d57" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=ULL_7%>" value="" class="radioAuto" id="d58" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULL_6%>" value="" class="radioAuto" id="d59" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULL_5%>" value="" class="radioAuto" id="d60" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULL_4%>" value="" class="radioAuto" id="d61" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULL_3%>" value="" class="radioAuto" id="d62" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULL_2%>" value="" class="radioAuto" id="d63" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULL_1%>" value="" class="radioAuto" id="d64" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 
<div class="clear"></div>
<label> Remarks</label>
 <%
if(medExamObj.getRemarksTeath()!=null){%>
 <textarea rows="" cols="60" name="<%=DENTAL_REMARKS %>" class="auto" onkeyup="chkLength(this,299);" value="<%=medExamObj.getRemarksTeath() %>" ><%=medExamObj.getRemarksTeath() %></textarea>
 <% }else{%>
 <textarea rows="" cols="60" name="<%=DENTAL_REMARKS %>" class="auto" onkeyup="chkLength(this,299);"></textarea>
 <% }%>
<label class="auto"> Refer to MH</label>
<%
System.out.println("medExamObj.getReferToMH()------------------------->"+medExamObj.getReferToMH());

if(medExamObj.getReferToMH()!=null && medExamObj.getReferToMH().equalsIgnoreCase("yes")){ %>

	<input tabindex="1" type="checkbox" disabled="disabled"
	name="dentalReferToMH2" value="no" checked="checked" class="radioAuto"   onclick="checkForDentalMH();checkDentalReferToMH();"/>
	<input tabindex="1" type="hidden" name="dentalReferToMH" value="yes"  id="dentalReferToMH" />
	<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:fileUploadViewWindow('DEN');" 
style="display: block;" id="dentalDivId"/><%}else	{ %>
		<input tabindex="1" type="checkbox"
	name="dentalReferToMH" value="no" class="radioAuto"  id="dentalReferToMH"  onclick="checkForDentalMH();checkDentalReferToMH();"/>
	<%} %>
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:fileUploadViewWindow('DEN');" 
style="display: none" id="dentalDivId"/>
	<div class="clear"></div>
	</div>
</div>
<div class="clear paddingTop15"></div>


<h4> PHYSICAL CAPACITY <a href="javascript:animatedcollapse.toggle('slide2')"></a></h4>
<div class="clear"></div>
<div id="slide2">
<div class="Block">
<label >Height</label> 
  <% if(medExamObj.getHeight()!=null){%>
<input tabindex="1" type="text" id="height" class="auto" size="10"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)" value="<%=medExamObj.getHeight() %>"
	maxlength="5" onblur="calculateIdealWeight();checkForWiegth(this.value,id);;calculateBMI();" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="height"	class="auto" size="10"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)"
	maxlength="5" onblur="calculateIdealWeight();checkForWiegth(this.value,id);calculateBMI();" /><label class="unit">cm</label>

 <% }%>


<label	>Weight</label> 
  <% if(medExamObj.getActualweight()!=null){%>
<input tabindex="1" type="text"   id="weight" class="auto" size="10"	name="<%=ACTUAL_WEIGHT %>" maxlength="5" value="<%=medExamObj.getActualweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();calculateOverWeight();" /><label class="unit">kg</label>

 <% }else{%>
<input tabindex="1" type="text"  id="weight" class="auto" size="10"	name="<%=ACTUAL_WEIGHT %>" maxlength="5" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();calculateOverWeight();" /><label class="unit">kg</label>

 <% }%>

<label>SD</label>
	<%
	if(medExamObj.getSD()!=null){
	%>
<input type="text" value="<%=medExamObj.getSD() %>" tabindex="1" name="sd" id="sd" readonly="readonly" class="auto" size="10"/>
<%}else{ %>
<input type="text" value="" tabindex="1" name="sd" id="sd" readonly="readonly" class="auto" size="10"/>

<%} %>
<input type="hidden" value="" name="sdVal" id="sdVal"/>
<div class="clear"></div>

<label	>Ideal Weight</label> 
  <% if(medExamObj.getIdealweight()!=null){%>
<input tabindex="1" type="text"   id="idealWeightId" name="<%=IDEAL_WEIGHT %>" class="auto" size="10"	maxlength="5" value="<%=medExamObj.getIdealweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateOverWeight();" /><label class="unit">kg</label>

 <% }else{%>
<input tabindex="1" type="text"   id="idealWeightId" name="<%=IDEAL_WEIGHT %>" class="auto" size="10"	maxlength="5" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateOverWeight();" /><label class="unit">kg</label>

 <% }%>

<label	>Over Weight</label> 
  <% if(medExamObj.getOverweight()!=null){%>
<input tabindex="1" type="text"   id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>" class="auto" size="10"	maxlength="5" value="<%=medExamObj.getOverweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">%</label>

 <% }else{%>
<input tabindex="1" type="text"   id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>"  class="auto" size="10"	maxlength="5" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">%</label>

 <% }%>


<label	>BMI</label> 
  <% if(medExamObj.getBhi()!=null){%>
<input tabindex="1" type="text"  id="bmi" name="<%=BHI %>" maxlength="5" value="<%=medExamObj.getBhi() %>"
	onKeyUp="limitText(this,6);" class="auto" size="10"  /><label class="unit">Kg/m<sup>2</sup></label>

 <% }else{%>
<input tabindex="1" type="text"  id="bmi" name="<%=BHI %>" maxlength="5" 
	onKeyUp="limitText(this,6);"  class="auto" size="10" /><label class="unit">Kg/m<sup>2</sup></label>

 <% }%>

<div class="clear"></div>

<label	>Body Fat</label> 
  <% if(medExamObj.getBodyfat()!=null){%>
<input tabindex="1" type="text"  id="<%=BODY_FAT %>" name="<%=BODY_FAT %>"maxlength="5" value="<%=medExamObj.getBodyfat() %>"
	onKeyUp="limitText(this,6);" class="auto" size="10" />

 <% }else{%>
<input tabindex="1" type="text"  id="<%=BODY_FAT %>" name="<%=BODY_FAT %>" maxlength="5" 
	onKeyUp="limitText(this,6);" class="auto" size="10" />

 <% }%>
  <input type="text" class="transparent" size="6">
<label	>Waist</label> 
  <% if(medExamObj.getWaist()!=null){%>
<input tabindex="1" type="text"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="5" value="<%=medExamObj.getWaist() %>"
	onKeyUp="limitText(this,6);" onblur="calculateWHR();" class="auto" size="10" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="5" 
	onKeyUp="limitText(this,6);" onblur="calculateWHR();" class="auto" size="10" /><label class="unit">cm</label>

 <% }%>
<label	>Hip</label> 
  <% if(medExamObj.getHips()!=null){%>
<input tabindex="1" type="text" maxlength="99"  id="hips" name="Hips"  value="<%=medExamObj.getHips() %>"
	onKeyUp="limitText(this,100);" onblur="calculateWHR();" class="auto" size="10" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="99"  id="hips" name="Hips"
	onKeyUp="limitText(this,100);" onblur="calculateWHR();" class="auto" size="10"  /><label class="unit">cm</label>

 <% }%>
 <div class="clear"></div>
<label	>WHR</label> 
  <% if(medExamObj.getWhr()!=null){%>
<input tabindex="1" type="text" maxlength="99"  id="WHR" name="WHR" maxlength="6" value="<%=medExamObj.getWhr() %>"
	onKeyUp="limitText(this,100);" class="auto" size="10" />

 <% }else{%>
<input tabindex="1" type="text" maxlength="99"  id="WHR" name="WHR" maxlength="6" 
	onKeyUp="limitText(this,100);" class="auto" size="10"  />

 <% }%>
  <input type="text" class="transparent" size="6">
<label	>Skin Fold Thickness</label> 
  <% if(medExamObj.getSignfoldthickness()!=null){%>
<input tabindex="1" type="text"  id="<%=THICKNESS %>" name="<%=THICKNESS %>" maxlength="99" value="<%=medExamObj.getSignfoldthickness() %>"
	onKeyUp="limitText(this,100);" class="auto" size="10"  /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"   id="<%=THICKNESS %>" name="<%=THICKNESS %>" maxlength="99" 
	onKeyUp="limitText(this,6);" class="auto" size="10" /><label class="unit">cm</label>

 <% }%>
<label	>Chest Full Expansion</label> 
  <% if(medExamObj.getChestfullexpansion()!=null){%>
<input tabindex="1" type="text"   id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>"  maxlength="99" value="<%=medExamObj.getChestfullexpansion() %>"
	onKeyUp="limitText(this,100);" class="auto" size="10" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" maxlength="99" 
	onKeyUp="limitText(this,100);" class="auto" size="10"  /><label class="unit">cm</label>

 <% }%>

<div class="clear"></div>
<label>Range of Expansion</label> 
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="99" value="<%=medExamObj.getRangeofexpansion() %>"
	onKeyUp="limitText(this,100);" class="auto" size="10" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="99" 
	onKeyUp="limitText(this,100);" class="auto" size="10"  /><label class="unit">cm</label>

 <% }%>


<label>Sportsman</label>

<!-- Commented By Ritu as per testing at 412 AFS  Date: 22 June 2011-->


 <%-- <% if(medExamObj.getSportman()!=null){%>
<input tabindex="1" type="text"   id="<%=SPORTS %>" name="<%=SPORTS %>" maxlength="5" value="<%=medExamObj.getSportman() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />
 <% }else{%>
<input tabindex="1" type="text"  id="<%=SPORTS %>" name="<%=SPORTS %>"  maxlength="5"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>  --%> 
 
 <select name="<%=SPORTS %>"  id="<%=SPORTS %>" class="smaller" validate="Sports Man,stirng,no">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script type="text/javascript">
<% if(medExamObj.getSportman()!=null){%>
document.getElementById('sport').value = '<%=medExamObj.getSportman()%>'
<%}%>
</script>
 

</div>
</div>

<div class="clear paddingTop15"></div>


<h4>Vision  <a href="javascript:animatedcollapse.toggle('slide3')"></a></h4>
<div class="clear"></div>
<div id="slide3">
<table width="50%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Distant Vision</th>
		<th scope="col">R</th>
		<th scope="col">L</th>
		<th scope="col">Near Vision</th>
		<th scope="col">R</th>
		<th scope="col">L</th>
		<th scope="col">CP</th>
		
	</tr>
	<tr>
		<td>Without Glasses</td>
		<td width="10%">
	
  <% if(medExamObj.getWthoutGlassesRDistant()!=null){%>
 <input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="29" value="<%=medExamObj.getWthoutGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="29" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text"  	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="29" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text"   	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="29" />
 <% }%>
 </td>
		
		<td>Without Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="29" value="<%=medExamObj.getWithoutGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="29" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="29" value="<%=medExamObj.getWithoutGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="29" />
 <% }%>
 </td>
 	<td width="10%" rowspan="2">
	
  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="1" type="text"  name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="29" value="<%=medExamObj.getNearVisionWithoutGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="29" />
 <% }%>
 </td>
		
	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%">
	
  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="1" type="text" name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="29" value="<%=medExamObj.getWithGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text"	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="29" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="29" value="<%=medExamObj.getWithGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="29" />
 <% }%>
 </td>	
		
		<td>With Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" name="<%=WITH_GLASSES_NEAR_R %>" maxlength="29" value="<%=medExamObj.getWithGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="29" />
 <% }%>
 </td>	
 
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text"	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="29" value="<%=medExamObj.getWithGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITH_GLASSES_NEAR_L %>" maxlength="29" />
 <% }%>
 </td>	
 	<%-- <td width="10%">
	
  <% if(medExamObj.getNearVisionWithGlassCp()!=null){%>
 <input tabindex="1" type="text"  	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="29" value="<%=medExamObj.getNearVisionWithGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="29" />
 <% }%>
 </td>	--%>
		
	</tr>

</table>

	</div>

<div class="clear paddingTop15"></div>

<h4> Hearing <a	href="javascript:animatedcollapse.toggle('slide2')"></a></h4>
<div class="clear"></div>
<div id="slide2">

<table width="50%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col"></th>
		<th scope="col">R</th>
		<th scope="col">L</th>
		<th scope="col">Both</th>
		</tr>
	<tr>
		<th>FW</th>
		<td>
			<% if(medExamObj.getEarHearingRfw() != null){ %>
			<input tabindex="1" class="auto" size="10"  type="text" maxlength="5"  id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()   %>" onkeyup="isNumber1(this)"  onblur="checkForWiegth(this.value,id);" />
			<%}else{ %>
			<input tabindex="1" class="auto" size="10" value="600" type="text" maxlength="5"  id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"	onblur="checkForWiegth(this.value,id);" />
			cm
			<%} %>
		</td>

		<td>
			<% if(medExamObj.getEarHearingLfw() != null){ %>
			<input tabindex="1" class="auto"  size="10" type="text" maxlength="5"  id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" onblur="checkForWiegth(this.value,id);" /> <label class="unit">cm</label>
			<%}else{ %>
			<input tabindex="1" class="auto" value="600" size="10" type="text" maxlength="5"  id="hlfw" name="<%=HEARING_L_F_W %>" onkeyup="isNumber1(this)" onblur="checkForWiegth(this.value,id);" /> <label class="unit">cm</label>
			<%} %>
		</td>

		<td>
			<% if(medExamObj.getEarHearingBothFw() != null){ %>
			<input tabindex="1" class="auto"  size="10" type="text" maxlength="5"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)"  onblur="checkForWiegth(this.value,id);" />
			<%}else{ %>
			<input tabindex="1" class="auto" value="600" size="10" type="text" maxlength="5"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)"  onblur="checkForWiegth(this.value,id);" />
			cm
			<%} %>
		</td>

	</tr>


	<tr>
		<th>CV</th>
		<td>
			<% if(medExamObj.getHearingRcv() != null){ %>
 			<input tabindex="1" type="text"  class="auto" size="10" maxlength="5"  id="hrcv" name="<%=HEARING_R_C_V %>" value="<%= medExamObj.getHearingRcv() %>" onkeyup="isNumber1(this)" onblur="checkForWiegth(this.value,id);" />
			<%}else{ %>
			<input tabindex="1" type="text" value="600" class="auto" size="10" maxlength="5"  id="hrcv" name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)" onblur="checkForWiegth(this.value,id);" />
			cm
			<%} %>
		</td>

		<td>
			 <% if(medExamObj.getHearingLcv() != null){ %>
	 		 <input tabindex="1" type="text"  class="auto" size="10" maxlength="5"  id="hlcv" name="<%=HEARING_L_C_V %>" value="<%= medExamObj.getHearingLcv() %>" onkeyup="isNumber1(this)" maxlength="5" onblur="checkForWiegth(this.value,id);" />
	  		 <%}else{ %>
	   		 <input tabindex="1" type="text" value="600" class="auto" size="10" maxlength="5"  id="hlcv" name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)" maxlength="5" onblur="checkForWiegth(this.value,id);" />
	   		 cm
	  		 <%} %>
		</td>

		<td>
		  	<% if(medExamObj.getHearingBothCv() != null){ %>
	  		<input tabindex="1" type="text"  class="auto" size="10" maxlength="5"  id="bothcv" name="<%=HEARING_BOTH_CV %>" value="<%= medExamObj.getHearingBothCv()  %>" onkeyup="isNumber1(this)" maxlength="5" onblur="checkForWiegth(this.value,id);" />
			<%}else{ %>
 			<input tabindex="1" type="text" value="600" class="auto" size="10" maxlength="5"  id="bothcv" name="<%=HEARING_BOTH_CV %>" onkeyup="isNumber1(this)" maxlength="5" onblur="checkForWiegth(this.value,id);" />
 			cm
			<%} %>
		</td>
	</tr>

	<tr>
		<th>TM</th>
		<td>
			<select name="<%=TYMPANIC_L %>" class="small2" size="0" tabindex="1" id="tympanic_l">
				<option value="Intact">Intact</option>
				<option value="No">Not Intact</option>
			</select>
			<script>
				<%if(medExamObj.getTympanicL()!= null){%>
				document.getElementById("tympanic_l").value='<%=medExamObj.getTympanicL()%>';
				<%}%>
			</script>
		</td>

		<td>
			<select name="<%=TYMPANIC_R %>" class="small2" size="0" tabindex="1" id="tympanic_r">
				<option value="Intact">Intact</option>
				<option value="No">Not Intact</option>
			</select>
			<script>
				<%
				if(medExamObj.getTympanicR()!= null){
				%>
				document.getElementById("tympanic_r").value='<%=medExamObj.getTympanicR()%>';

				<%}%>
			</script>
		</td>

		<td></td>
	</tr>

	<tr>
		<th>Mobility</th>

		<td>
			 <% if(medExamObj.getMobilityL() != null){ %>
	 		<input tabindex="1" type="text"  class="auto" size="10" name="<%=MOBILITYL %>" maxlength="99"  value="<%= medExamObj.getMobilityL()  %>"  />
			<%}else{ %>
 			<input tabindex="1" type="text" value="Normal" class="auto" size="10" name="<%=MOBILITYL %>"  maxlength="99"  />
			<%} %>
		</td>

		<td>
		  	<% if(medExamObj.getMobilityR() != null){ %>
	 		<input tabindex="1" type="text"  class="auto" size="10" name="<%=MOBILITYR %>" maxlength="99"  value="<%= medExamObj.getMobilityR()  %>"  />
			<%}else{ %>
 			<input tabindex="1" type="text" value="Normal" class="auto" size="10" name="<%=MOBILITYR %>"  maxlength="99"  />
			<%} %>
		</td>

		<td></td>
	</tr>
</table>

<div class="Block">

<label>Nose, Throat &amp; Sinuses</label>
	  	 <% if(medExamObj.getNosethroat() != null){ %>
	  <input tabindex="1" type="text" class="auto" size="21" maxlength="99"  id="bothcv" name="<%=NOSE_THROAT %>" value="<%= medExamObj.getNosethroat()  %>"  />

<%}else{ %>
 <input tabindex="1" type="text" class="auto" size="21"  id="bothcv" name="<%=NOSE_THROAT %>"  maxlength="99" value="NAD" />

<%} %>


<label>Audiometry Record </label>
	  	 <% if(medExamObj.getAudiometryRecord() != null){ %>
	  <input tabindex="1" type="text" class="auto" size="19" maxlength="9"  id="bothcv" name="<%=AUDIOMETRY_RECORD %>" value="<%= medExamObj.getAudiometryRecord()  %>"  />
<%}else{ %>
 <input tabindex="1" type="text" class="auto" size="19"  id="bothcv" name="<%=AUDIOMETRY_RECORD %>"  maxlength="9" value="Not Done" />
<%} %>
<!--<input tabindex="1" name="Button"	type="button" class="button" value="UPLOAD"	onClick="submitForm('medicalBoardMOForm16','medicalBoard?method=displayFileUpload');" />
-->
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:fileUploadViewWindow('HEA');" />


</div>
</div>


<%	int count=1;
    if(getDgOrderdts!=null)
    {
	for(DgOrderdt dgOrderdt : getDgOrderdts){%>
	<input type="hidden" value="<%=dgOrderdt.getId()%>" name="dgOrderdtId<%=count%>" id="dgOrderdtId<%=count%>" />
<%count++;}
    }
%>

<% if(visit.getHin() !=null){%>
<INPUT type=hidden value="<%=visit.getHin().getHinNo()%>" name="hinNoForreport" id="hinNoForreport"/>
<% }%>
<input type="hidden" value="" name="deleatedValue" id="deleatedValue" />
<input type="hidden" value="" name="deleatedorderid" id="deleatedorderid" />
<div class="clear paddingTop15"></div>
<h4>Investigations <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div id="slide5">
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
<div id="createInvestigationDivToShowHide">
<input	name="investigationTemplate" type="button"	value="Create Template" tabindex="1" class="buttonBig" onclick="showCreateInvestigationTemplate();" />
</div>
<div id="copyPrevInvestigationTemplateDiv" style="display: none">
<input name="copyPrevInvestigationTemplate" tabindex="1" type="button"	value="Copy Previous" class="buttonBig"  />
</div>

<div id="investigationImportButton1" >
<input	name="investigationImportButton1" tabindex="1" type="button"	value="IMPORT" class="buttonBig"	onclick="getListForTreatment('investigationDiv');" />
</div>

<input name="Prevoius" type="button" tabindex="1" value="Prev Investigations"	class="buttonBig"	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />

</div>
<div class="clear"></div>
<div id="gridview">
<div id="ac2update"	style="display: none;" class="autocomplete"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid1">
	<tr>
	<th scope="col">Clinical Notes</th>

</tr>
<tr>
<%if(dgOrderhd !=null && dgOrderhd.getClinicalNote() !=null){
%>
<td><input type="text" name="clinicalNotes1" tabindex="1" value="<%=dgOrderhd.getClinicalNote() %>" size="100" maxlength="45"  validate="Clinical Notes,metachar,no"/></td>
<%}else{ %>
<td><input type="text" name="clinicalNotes1" tabindex="1" value="For Medical Board" size="100" maxlength="45"  validate="Clinical Notes,metachar,no"/></td>
<%} %>
</tr>
	</table>
	<div class="clear paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Investigation</th>
		<th scope="col">Refer to MH</th>
		<th scope="col">Result</th>
		<th scope="col">File Upload</th>
		<th scope="col">Add</th>
        <th scope="col">Delete</th>
		</tr>

<%int inc=1;
if(resultList!=null && resultList.size()>0)
{%>
	 <input	type="hidden"  name="Investigated"	tabindex="2" value="yes"/>
<% }else{%>
	 <input	type="hidden"  name="Investigated"	tabindex="2" value="No"/>
<%  }


if(patientInvestigationHeader.getId()!=null)
{
%>
<input type="hidden" value="<%=patientInvestigationHeader.getId() %>" name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" />
<%
}else{%>
<input type="hidden"  name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" />
<% }
if(dgOrderhd!=null)
{
%>
<input type="hidden" value="<%=dgOrderhd.getId() %>" name="dgOrderhdId" id="dgOrderhdId" />
<input type="hidden" value="<%=dgOrderhd.getOrderNo() %>" name="dgOrderhdOrderNo" id="dgOrderhdOrderNo" />
<%
}else{ %>
<input type="hidden"  name="dgOrderhdId" id="dgOrderhdId" />
<input type="hidden" value="" name="dgOrderhdOrderNo" id="dgOrderhdOrderNo" />
<% }
String template="";
int resultid=0;

if(patientInvestigationdetails!=null && patientInvestigationdetails.size()>0){
	   HashMap first = new HashMap();
	   HashMap second = new HashMap();
	   HashMap third = new HashMap();
	   int inc1=1;
	   
		    for(PatientInvestigationDetails patientInvestigation : patientInvestigationdetails)
		    {
		    	int cnt=0;
		    	String investigationName="";
		    	investigationName=patientInvestigation.getChargeCode().getChargeCodeName()+"["+patientInvestigation.getChargeCode().getId()+"]";
		    	first.put(investigationName,patientInvestigation.getChargeCode().getId());
		    	third.put(investigationName,patientInvestigation.getId());

		    	String val="";
		    	String val1="";
		    	String val2="";
		    	int investigationId=0;
		      	if(resultList.size()>0 && inc1<=resultList.size())
		    	{
		    	DgResultEntryHeader dgEH=(DgResultEntryHeader)resultList.get(inc1-1);
		    	/**
		    	* For getting ordered sub investigations
		    	* Added by Ritu 
		    	*/
		    	Set<DgResultEntryDetail> linkedHashSet = DgResultEntryComparatorByOrderNo.getApplicationTreeSet(); 
		    	Set<DgResultEntryDetail> subSet1 = new LinkedHashSet<DgResultEntryDetail>();
				for(DgResultEntryDetail dgResultEntryDetail : dgEH.getDgResultEntryDetails()){
					linkedHashSet.add(dgResultEntryDetail);
				}
				subSet1.addAll(linkedHashSet);
		    	
		    //	for(DgResultEntryDetail dgre:dgEH.getDgResultEntryDetails())
		    	for(DgResultEntryDetail dgre:subSet1)
		    	{  
		    		if(dgre.getSubInvestigation()!=null)
			    		val1=dgre.getSubInvestigation().getSubInvestigationName();
			    	if(!dgre.getResultType().equalsIgnoreCase("t"))
		    		{
			      	    ++cnt;
			    		if(dgre.getResult()!=null)
			    			val2=dgre.getResult();
			    
			    		if(cnt==1){
			    	    	val=" "+val1+":"+val2;
			    	    }else{
			    	    	val=" "+val+","+val1+":"+val2;
			    	    }
			    		 

		    		}
		    	investigationId=dgre.getInvestigation().getId();
		    		if(dgre.getResultType().equalsIgnoreCase("s"))
		    		{
		    		    	val=val.substring(2);
		    				resultid=0;
			
		    		}
		    		if(dgre.getResultType().equalsIgnoreCase("m"))
		    		{
		    			val=val.substring(1);
		    			resultid=0;
	    	
		    		}
		    		if(dgre.getResultType().equalsIgnoreCase("t"))
		    		{

		    			resultid=dgre.getResultEntry().getId();
		    			template="template"+"/"+resultid;
		    			val=template;
	    	
		    		} 
		    	
		    	
		    	}

		    	}
		    	if(investigationId!=0&&!second.containsKey(investigationId))
		    	second.put(investigationId,val);
		    	++inc1;
		    	//
		    }

			    for (Iterator i = new InvestigationDetailByInvestigationId().sortByValue(first).iterator(); i.hasNext(); ) {
            String key = (String) i.next();



		    %>
	<tr>

	<input type="hidden" value="<%=third.get(key) %>" name="patientInvestigationdetailsId<%=inc %>" id="patientInvestigationdetailsId<%=inc %>" />
		<td><input type="text" value="<%=key%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="chargeCodeName<%=inc %>"
			 name="chargeCodeName<%=inc %>" size="45" />
</td>
<%

if(second.get(first.get(key))!=null)
	{
	Labresult="present";
	String st=(String)second.get(first.get(key));
	String[] mySplitResult = st.split("/");
	if(!mySplitResult[0].equalsIgnoreCase("template"))
	{if(resultList!=null && resultList.size()>0){
		%>
		
		<td> <input tabindex="1" type="checkbox"
		name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"  
		onclick="checkForInvestigationMH(<%=inc %>);" disabled="disabled"/>
	 </td><%}else{ %>
	 <td> <input tabindex="1" type="checkbox"
		name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"  
		onclick="checkForInvestigationMH(<%=inc %>);" />
	 <%} %>
		<td><input type="text" value="<%=second.get(first.get(key))%>" readonly="readonly"
				readonly="readonly" tabindex="2" id="Result<%=inc %>"
				 name="Result<%=inc %>" size="65" />
	</td>

<% }else{

%>
<td>&nbsp;</td>
	<td>
	<input name="resultIdTemplate<%=inc %>"	id="resultIdTemplate<%=inc %>" type="hidden"	value="<%=mySplitResult[1]%>"/>
	<input	type="Button" class="Button" value="Result"	onclick="openTemplateScreen(<%=inc %>);"  />
	</td>

<%}}else{

	String investigationVal=key;
	StringTokenizer st = new StringTokenizer(investigationVal, "[");
	st.nextToken();
	String val = st.nextToken();
	StringTokenizer st1 = new StringTokenizer(val, "]");
	String finalInvestVal=st1.nextToken();
	%>

	<%
	if(getDgOrderdts!=null)
    {
	for(DgOrderdt dgOrderdt : getDgOrderdts)
	{
	    int finalVal=Integer.parseInt(finalInvestVal);
	    if(dgOrderdt.getInvestigation().getId()==finalVal)
	    {
	    	if(dgOrderdt.getInvestigationToMH()!=null)
	    	{
	    	if(dgOrderdt.getInvestigationToMH().equalsIgnoreCase("y"))
	    	{

	    		%>
<td><input tabindex="1" type="checkbox" disabled="disabled" name="investigationReferToMH<%=inc %>"
			 value="y" checked="checked" id="investigationReferToMH<%=inc %>"  />
	    			<%--onclick="checkForInvestigationMH(<%=inc %>);" --%>
</td>
<td><input type="text" value=""  tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<% 	    	}else
            { %>
             <td>
            <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"  />
	<%--onclick="checkForInvestigationMH(<%=inc %>);" --%>
   </td>
    <td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
            <%

             }
	    	}else
	    	{%>
	    	 <td>
  		<input tabindex="1" type="checkbox" name="investigationReferToMH<%=inc %>" value="y" 
  			 id="investigationReferToMH<%=inc %>" onclick="checkForInvestigationMH(<%=inc %>);" />
   </td>
    <td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
        </td>
	    <%	}
	    }
	%>
	<!--
	/*
	* Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
	<%--<input type="text" value="<%=dgOrderdt.getId()%>" name="dgOrderdtId<%=inc%>" id="dgOrderdtId<%=inc%>" />
	 --%>
	<input type="hidden" value="<%=third.get(key) %>" name="patientInvestigationdetailsId<%=inc %>" id="patientInvestigationdetailsId<%=inc %>" />
	<!--
	/*
	* End of Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
	<%
	}
	}else{
	%>
	<!--
	/*
	* Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
<%--
<input type="hidden" value="0" name="dgOrderdtId<%=inc%>" id="dgOrderdtId<%=inc%>" />
 --%>
<input type="hidden" value="0" name="patientInvestigationdetailsId<%=inc %>" id="patientInvestigationdetailsId<%=inc %>" />
<!--
	/*
	* End of Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
	  <td>
<input tabindex="1" type="checkbox" 	name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"
onclick="checkForInvestigationMH(<%=inc %>);"   />

</td>
<td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<% }%>



<% }%>
<!-- style="display: none;" -->
<td><input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>

<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>
	</tr>

	<% inc++;
		    }

%>
<input type="hidden" value="<%=inc-1 %>" name="hiddenValue" id="hiddenValue" />

<%
}else{ %>
	<tr>
		<td>
		 <input type="text" value="" tabindex="1"
			id="chargeCodeName1" size="45" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal','parent')}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="5" validate="Qty,num,no" /> <input type="hidden"
			tabindex="1" id="chargeCode1" name="chargeCode1" size="10" readonly />
<!--	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->
<%--<input type="hidden" value="0" name="dgOrderdtId1" id="dgOrderdtId1" /> --%>
		</td>
	<td>
<input tabindex="1" type="checkbox"	name="investigationReferToMH1" value="y" id="investigationReferToMH1"  
	onclick="checkForInvestigationMH(1);" />
</td>
<td>
<input type="text" value="" readonly="readonly" name="Result1" id="Result1" size="65" />
</td>
<!-- style="display: none;"  -->
<td><input name="uploadReport1" id="uploadReport1" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(1);" /></td>

<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>
</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<% }%>
</table>
</div>
</div>
<script>
checkForInvestReferToMH();

</script>
<input type="hidden" id="investigationDataStatus" name="investigationDataStatus" value="no"/>

<div class="Clear paddingTop15"></div>

<h4> CARDIO VASCULAR SYSTEM <a	href="javascript:animatedcollapse.toggle('slide6')"></a></h4>
<div class="clear"></div>
<div id="slide6">
<div class="Block">
<div class="clear"></div>
<label>Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input type="text" name="<%=PULSE_RATES%>" class="autoArial" size="17" value="<%=medExamObj.getPulseRates() %>"
  id="pulseRate" tabindex="1"  maxlength="19" onblur="putPulseRateValue();"/>
  <label class="unit2">/min</label>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="19"  name="<%=PULSE_RATES%>" onblur="putPulseRateValue();" value="Normal"
 id="pulseRate" class="autoArial" size="17" /><label class="unit2">/min</label>
 <% }%>
 <label class="medium">BP</label> 
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" maxlength="19"  name="<%=BP1%>" class="autoArial" size="17" value="<%=medExamObj.getBp() %>"
  id="bloodpressure" onblur="putBpRateValue();"/>
 <label class="unit2">mm Hg</label>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="19"  name="<%=BP1%>" value="Normal" class="autoArial" size="17" id="bloodpressure" onblur="putBpRateValue();" />
 <label class="unit2">mm Hg</label>
 <% }%>
<label>Peripheral Pulsations</label>
<% if(medExamObj.getArterialWalls()!=null){%>
<input tabindex="1" type="text" maxlength="19" 	name="<%= ARTERIAL_WALLS%>" class="autoArial" size="20" value="<%=medExamObj.getArterialWalls() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="19"  value="Normal"	name="<%= ARTERIAL_WALLS%>" class="autoArial" size="20" validate="Peripheral Pulsations,metachar,no"/>
 <% }%>


<div class="clear"></div>
<label>Heart Size</label>
<% if(medExamObj.getHeartSize()!=null){%>
<input tabindex="1" type="text" maxlength="19" 	name="<%= HEART_SIZE%>" class="autoArial" size="27" value="<%=medExamObj.getHeartSize() %>" />

 <% }else{%>
<input tabindex="1" type="text" maxlength="19" 	name="<%= HEART_SIZE%>" class="autoArial" size="27" value="Normal"  validate="Heart Size,metachar,no"/>
 <% }%>


 <label class="medium">Sounds</label>
 <% if(medExamObj.getSounds()!=null){%>
 <input tabindex="1" type="text" maxlength="19"  name="<%= SOUND%>" class="autoArial"	size="27" value="<%=medExamObj.getSounds() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="19"  name="<%= SOUND%>" class="autoArial"	value="Normal"  size="27"  validate="Sounds,metachar,no"/>
 <% }%>
<label>Rhythm</label>
<% if(medExamObj.getRhythm()!=null){%>
 <input tabindex="1" type="text" maxlength="19"  name="<%= RHYTHM%>" class="autoArial"	size="20" value="<%=medExamObj.getRhythm() %>"/>

 <% }else{%>
 <input tabindex="1" type="text" maxlength="19"  name="<%= RHYTHM%>" class="autoArial"	size="20"   value="Regular" validate="Rhythm,metachar,no" />
 <% }%>


<div class="clear"></div>

</div>
</div>

<div class="clear paddingTop15"></div>

<h4>RESPIRATORY SYSTEM <a href="javascript:animatedcollapse.toggle('slide7')"></a></h4>
<div class="clear"></div>
<div id="slide7">
<div class="Block">
<div class="clear"></div>
<label> Respiratory System</label>
<% if(medExamObj.getRespiratorySystem()!=null){%>
  <input tabindex="1" type="text" maxlength="99" 	name="<%=RESPIRATORY_SYSTEM %>" class="auto" size="120" maxlength="100" value="<%=medExamObj.getRespiratorySystem() %>" validate="Respiratory System,metachar,no"/>
   <% }else{%>
  <input tabindex="1" type="text" maxlength="99" value="NAD"	name="<%=RESPIRATORY_SYSTEM %>" class="auto" size="120" maxlength="100" validate="Respiratory System,metachar,no"/>
 <% }%>


<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>


<h4>GASTRO INTESTINAL SYSTEM <a	href="javascript:animatedcollapse.toggle('slide8')"></a></h4>
<div class="clear"></div>
<div id="slide8">
<div class="Block">
<div class="clear"></div>
<label > Liver</label>
<% if(medExamObj.getLiver()!=null){%>
  <input tabindex="1" type="text"  	name="liver" class="auto" size="120" maxlength="99" value="<%=medExamObj.getLiver() %>" validate="Liver,metachar,no"/>
   <% }else{%>
  <input tabindex="1" type="text" 	name="liver" class="auto" size="120" maxlength="99" value="Not Palpable"validate="Liver,metachar,no"/>
 <% }%>
<div class="clear"></div>
<label> Spleen</label> 
<% if(medExamObj.getSpleen()!=null){%>
  <input tabindex="1" type="text"  	name="spleen" class="auto" size="120" maxlength="99" value="<%=medExamObj.getSpleen() %>"validate="Spleen,metachar,no"/>
   <% }else{%>
  <input tabindex="1" type="text" 	name="spleen" class="auto" size="120" maxlength="99" value="Not Palpable"validate="Spleen,metachar,no"/>
 <% }%>

<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>

<h4>CENTRAL NERVOUS SYSTEM <a href="javascript:animatedcollapse.toggle('slide9')"></a></h4>
<div class="clear"></div>
<div id="slide9">
<div class="Block">
<div class="clear"></div>
<label > Higher Mental Func</label> 
<% if(medExamObj.getHigherMentalFunction()!=null){%>
<input tabindex="1" type="text" maxlength="100" name="<%=HIGHER_MENTAL_FUNCTION %>"  maxlength="10" value="<%=medExamObj.getHigherMentalFunction() %>"validate="Higher Mental Func,metachar,no"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="100" name="<%=HIGHER_MENTAL_FUNCTION %>"  maxlength="10" value="Normal" validate="Higher Mental Func,metachar,no"/>
 <% }%>

<label > Speech</label> 
<% if(medExamObj.getSpeech()!=null){%>
<input tabindex="1" type="text" name="<%=SPEECH %>"  maxlength="99" value="<%=medExamObj.getSpeech() %>" validate="Speech,metachar,no"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=SPEECH %>"  maxlength="99" value="Normal"validate="Higher Mental Func,metachar,no"/>
 <% }%>


<label > Reflexes</label> 
<% if(medExamObj.getReflexes()!=null){%>
<input tabindex="1" type="text" name="<%=REFLEXES %>"  maxlength="99" value="<%=medExamObj.getReflexes() %>"validate="Reflexes,metachar,no"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=REFLEXES %>"  maxlength="99" value="Normal"validate="Higher Mental Func,metachar,no"/>
 <% }%>


<div class="clear"></div>
<label > Tremors</label> 
<select name="<%=TREMORS %>" size="0" tabindex="1" id="tremors" validate="Tremors,metachar,no">
	<option value="Nil">Nil</option>
	<option value="Fine">Fine</option>
	<option value="Coarse">Coarse</option>
</select>
<script>
<%
if(medExamObj.getTremors()!= null){
%>
document.getElementById("tremors").value='<%=medExamObj.getTremors()%>';

<%}%>
</script>

<label > Self Balancing Test</label> 

<select name="<%=SELF_BALANCING_TEST %>" size="0" tabindex="1" id="selfbalancingtest" validate="Self Balancing Test,metachar,no">
	<option value="Fairly">Steady</option>
	<option value="Fairly">Fairly Steady</option>
	<option value="Unsteady">Unsteady</option>
	
</select>
<script>
<%
if(medExamObj.getSelfBalancingTest()!= null){
%>
document.getElementById("selfbalancingtest").value='<%=medExamObj.getSelfBalancingTest()%>';

<%}%>
</script>
<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>
<label >Locomotor System</label>
<% if(medExamObj.getLocomoterSystem()!=null){%>
<input tabindex="1" type="text" name="locomoterSystem"  size="20" maxlength="9" value="<%=medExamObj.getLocomoterSystem() %>" validate="Locomotor System,metachar,no"/>
   <% }else{%>
<input tabindex="1" type="text" name="locomoterSystem"  size="20" maxlength="9" value="NAD" validate="Locomotor System,metachar,no"/>
 <% }%>
<label>Spine</label> 
<% if(medExamObj.getSpine()!=null){%>
<input tabindex="1" type="text" name="spine"  size="20" maxlength="9" value="<%=medExamObj.getSpine() %>" validate="Spine,metachar,no"/>
   <% }else{%>

<input tabindex="1" type="text" name="spine"  size="20" maxlength="9" value="NAD" validate="Spine,metachar,no"/>
 <% }%>


<label>Hernia</label> 
<% if(medExamObj.getHerniaMusic()!=null){%>
<input tabindex="1" type="text"  name="<%=HERNIA_MUSCLE %>" size="20" maxlength="9" value="<%=medExamObj.getHerniaMusic() %>" validate="Hernia,metachar,no"/>
   <% }else{%>

<input tabindex="1" type="text" name="<%=HERNIA_MUSCLE %>"  size="20" maxlength="9" value="Nil" validate="Hernia,metachar,no"/>
 <% }%>


<div class="clear"></div>
<label>Hydrocele</label>
<% if(medExamObj.getHydrocele()!=null){%>
<input tabindex="1" type="text" name="<%=HYDROCELE %>" size="20" maxlength="9" value="<%=medExamObj.getHydrocele() %>"validate="Hydrocele,metachar,no"/>
   <% }else{%>

<input tabindex="1" type="text" name="<%=HYDROCELE %>" size="20" maxlength="9" value="Nil"validate="Hydrocele,metachar,no"/>
 <% }%>


<label>Haemorrhoids</label>
<% if(medExamObj.getHemorrhoids()!=null){%>
<input tabindex="1" type="text" name="<%=HEMONHOIDS %>"  size="20" maxlength="10" value="<%=medExamObj.getHemorrhoids() %>"validate="Haemorrhoids,metachar,no"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=HEMONHOIDS %>"  size="20" maxlength="10" value="Nil"validate="Haemorrhoids,metachar,no"/>
 <% }%>


<label>Breast</label>
<% if(medExamObj.getBreasts()!=null){%>
<input tabindex="1" type="text" name="<%=BREASTS %>"  size="20" maxlength="10" value="<%=medExamObj.getBreasts() %>"validate="Breast,metachar,no"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=BREASTS %>"  size="20" maxlength="10" value="NAD"validate="Breast,metachar,no"/>
 <% }%>


<div class="clear"></div>

</div>
</div>
<div class="clear paddingTop15"></div>
<% if(visit.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("Female"))
{

%>


<h4>GYNAECOLOGY EXAM <a href="javascript:animatedcollapse.toggle('slide10')"></a></h4>
<div class="clear"></div>
<div id="slide10">
<div class="Block">
<label >Menstrual History</label>
<% if(medExamObj.getMenstrualHistory()!=null){%>
<input tabindex="1" type="text" maxlength="10" 	name="<%=MENSTRUAL_HISTORY %>"  size="20" maxlength="30" value="<%=medExamObj.getMenstrualHistory() %>" validate="Menstrual History,metachar,no"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="10" 	name="<%=MENSTRUAL_HISTORY %>"  size="20" maxlength="30" validate="Menstrual History,metachar,no"/>
 <% }%>

<label>LMP</label>
<% if(medExamObj.getLmp()!=null){%>
<input tabindex="1" type="text"  class="calDate" readonly="readonly "	name="<%=LMP %>"  size="20" maxlength="3" onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLmp()) %>"/>
   <% }else{%>
<input tabindex="1" type="text" class="calDate" readonly="readonly "	name="<%=LMP %>" onKeyUp="mask(this.value,this,'2,5','/');"  size="20" maxlength="3" />
 <% }%>
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medicalBoardMOForm16.<%=LMP%>,event);" />
<label >No. of pregnancies</label>
<% if(medExamObj.getNoOfPregnancies()!=null){%>
<input tabindex="1" type="text" 	name="<%=NO_OF_PREGNANCY %>"  size="20" maxlength="3" value="<%=medExamObj.getNoOfPregnancies() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=NO_OF_PREGNANCY %>"  size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>

<div class="clear"></div>
<label >No of Abortions</label>
<% if(medExamObj.getNoOfAbortions()!=null){%>
<input tabindex="1" type="text" id="noofabo"	name="<%=NO_OF_ABORTION %>"  size="20" maxlength="3" value="<%=medExamObj.getNoOfAbortions() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text" id="noofabo"	name="<%=NO_OF_ABORTION %>"  size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>
<label >No. of Children</label>
<% if(medExamObj.getNoOfChildren()!=null){%>
<input tabindex="1" type="text" 	name="<%=NO_OF_CHILDREN %>"  size="20" maxlength="3" value="<%=medExamObj.getNoOfChildren() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text"  	name="<%=NO_OF_CHILDREN %>" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>


<label >Last Confinement on</label>
<% if(medExamObj.getLastConfinementDate()!=null){%>
<input tabindex="1" type="text"  class="calDate" readonly="readonly " value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLastConfinementDate()) %>"	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" />
   <% }else{%>
<input tabindex="1" type="text"  class="calDate" readonly="readonly "	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" />
 <% }%>


<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medicalBoardMOForm16.<%=DATE_OF_LASTCONFINEMENT%>,event);" />
<div class="clear"></div>
<label >Vaginal Discharge</label>
<% if(medExamObj.getVaginalDischarge()!=null){%>
<input tabindex="1" type="text" 	name="<%=VAGINAL_DISCHARGE %>"  size="20" maxlength="10" value="<%=medExamObj.getVaginalDischarge() %>" validate="Vaginal Discharge,metachar,no"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=VAGINAL_DISCHARGE %>"  size="20" maxlength="10" validate="Vaginal Discharge,metachar,no"/>
 <% }%>

<label	>Prolapse</label> 
<% if(medExamObj.getProlapse()!=null){%>
<input tabindex="1" type="text" 	name="<%=PROLAPSE %>"  size="20" maxlength="10" value="<%=medExamObj.getProlapse() %>" validate="Prolapse,metachar,no"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=PROLAPSE %>"  size="20" maxlength="10" validate="Prolapse,metachar,no"/>
 <% }%>


<label >USG Abdomen</label> 
<% if(medExamObj.getUsgAbdomen()!=null){%>
<input tabindex="1" type="text" name="<%=USG_ABORTION %>"  size="20" maxlength="10" value="<%=medExamObj.getUsgAbdomen() %>" validate="USG Abdomen,metachar,no"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=USG_ABORTION %>"  size="20" maxlength="10" value="Not Done" validate="USG Abdomen,metachar,no"/>
 <% }%>
 <input size="157" class="transparent" />
 <input name="Send" type="button"  class="button" value="Upload" onClick="javascript:fileUploadViewWindow('GYN');" />
 <%--
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:FileUploadWindowGynaecology();" />
 --%>

</div>
</div>
<%} %>


<div class="clear"></div>
<div class="Clear paddingTop15"></div>
<h4>CLINICAL SUMMARY</h4>
<div class="clear"></div>
<div class="Block">

<%
String presentConditions="";
String medication="";
BigDecimal temperature=new BigDecimal(0);
String pulseRates="";
String bp1="";
String rr="";
String generalPhysicalExam="";
String cardiovascularSystem="";
if(medExamObj.getPresentCondition()!=null){
	presentConditions=medExamObj.getPresentCondition();
}

if(medExamObj.getMedication()!=null){
	medication=medExamObj.getMedication();
}
if(medExamObj.getGeneralPhysicalExam()!=null){
	generalPhysicalExam=medExamObj.getGeneralPhysicalExam();
}

if(medExamObj.getGastroIntestinalSystem()!=null){
}
if(medExamObj.getCardiovascularSystem()!=null){
	cardiovascularSystem=medExamObj.getCardiovascularSystem();
	
}
%>
  <%String diagnosis1="";String diagnosis2="";String onsetDiag1="";String onsetDiag2="";
 if(medExamObj.getDiagnosis1Clini() !=null){
	 diagnosis1=medExamObj.getDiagnosis1Clini();
 }
 if(medExamObj.getDiagnosis2Clini() !=null){
	 diagnosis2=medExamObj.getDiagnosis2Clini();
 }
 if(medExamObj.getOnsetDiag1() !=null){
	 onsetDiag1=medExamObj.getOnsetDiag1();
 }
 if(medExamObj.getOnsetDiag2() !=null){
	 onsetDiag2=medExamObj.getOnsetDiag2();
 }
 %>
 <%-- 
<label>Diagnosis</label>
 <input size="1" class="transparent">
 <label class="unit">1.</label>
<input type="text" name="diagnosis1" id="diagnosis1" value="<%=diagnosis1 %>" class="auto" size="45" tabindex="1"/>
 <label class="unit">Onset</label>
 <input type="text" name="onsetDiag1" id="onsetDiag1" value="<%=onsetDiag1 %>" class="auto" size="50" tabindex="1" />
<div class="clear"></div>
<input size="33" class="transparent">
 <label class="unit">2.</label>
<input type="text" name="diagnosis2" id="diagnosis2" value="<%=diagnosis2 %>" class="auto" size="45" tabindex="1"/>
 <label class="unit">Onset</label>
 <input type="text" name="onsetDiag2" id="onsetDiag2" value="<%=onsetDiag2 %>" class="auto" size="50" tabindex="1"/>
<div class="clear"></div>
<label>Last Medical Board</label>
 <input size="1" class="transparent">
 <label class="unit">Place</label>
 <%String placeLastBoard="";
 if(medExamObj.getPlaceLastCatBoard() !=null){
 placeLastBoard=medExamObj.getPlaceLastCatBoard();
 }
 %>
<input type="text" name="lastMedBoardPlace" id="lastMedBoardPlace" value="<%=placeLastBoard %>" 
		class="auto" size="45" maxlength="49" tabindex="1"/>
<label class="unit">Date</label>
 <%String dateLastBoard="";
 if(medExamObj.getLastBoardDate() !=null){
	 dateLastBoard=HMSUtil.changeDateToddMMyyyy(medExamObj.getLastBoardDate());
 }
 %>
<input type="text" name="dateLastBoard" id="dateLastBoard" value="<%=dateLastBoard %>" class="auto" size="45" 
	onkeyup="mask(this.value,this,'2,5','/');" tabindex="1" readonly="readonly"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMOForm16.dateLastBoard,event);" />
	<div class="clear"></div>
	--%>
<label>Present Conditions</label>
<textarea rows="" cols="125" class="auto"name="presentConditions" id="presentConditions" 
validate="Present Conditions,metachar,no" onkeyup="chkLength(this,2000);"><%=presentConditions%></textarea>
	
<div class="clear"></div>
<label>Medication</label>
<input type="text" name="medication" id="medication" value="<%=medication%>" size="100" class="auto" maxlength="999" 
validate="Medication,metachar,no" tabindex="1"/>
<div class="clear"></div>
<h4>Examination</h4>
<div class="clear"></div>
<label>Temperature</label>
 <% if(medExamObj.getTemprature()!=null){%>
  <input tabindex="1" type="text" maxlength="10"  name="<%=TEMPERATURE%>" class="auto" size="3" maxlength="10"  value="<%=medExamObj.getTemprature() %>" validate="num,string,no"/>
  <label class="auto">F</label>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="10"  name="<%=TEMPERATURE%>" class="auto" size="3" maxlength="10" validate="Temp,num,no" /><label class="unit">F</label>
 <% }%>
<input size="2" class="transparent">
<label class="auto">Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input tabindex="1" type="text" maxlength="19"  name="<%=PULSE_RATES%>" class="auto" size="3" value="<%=medExamObj.getPulseRates() %>" 
  id="pulseRate1" readonly="readonly"/>
  <label class="auto">/min</label>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="19"  name="<%=PULSE_RATES%>" class="auto" size="3"  id="pulseRate1" readonly="readonly"/><label class="unit">/min</label>
 <% }%>
 <input size="2" class="transparent">
 <label class="auto">BP</label>
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" maxlength="19"  name="<%=BP1%>" class="auto" size="5"  value="<%=medExamObj.getBp() %>" id="bloodpressure1" readonly="readonly"/>
 <label class="auto">mm Hg</label>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="19"  name="<%=BP1%>" class="auto" size="5" id="bloodpressure1" readonly="readonly"/>
 <label class="auto">mm Hg</label>
 <% }%>
 <input size="2" class="transparent">
<label class="auto">RR</label>
<% if(medExamObj.getRrClinical()!=null){%>
  <input tabindex="1" type="text" maxlength="19"  name="<%=RR%>" class="auto" size="3"  value="<%=medExamObj.getRrClinical() %>" validate="RR,string,no"/>
 <label class="auto">/min</label>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="19"  name="<%=RR%>" class="auto" size="3"  validate="RR,string,no"/>
 <label class="auto">/min</label>
 <% }%>
 <div class="clear"></div>
<label>General Physical Exam</label>
<input type="text" name="generalPhysicalExam" id="generalPhysicalExam" value="<%=generalPhysicalExam%>" size="100" class="auto"
   maxlength="999" validate="General Physical Exam,metachar,no"tabindex="1"/>
<div class="clear"></div>
<label>Cardiovascular System</label>
<input type="text" name="cardiovascularSystem" id="cardiovascularSystem" value="<%=cardiovascularSystem%>" size="100" class="auto"
	maxlength="999" validate="Cardiovascular System,metachar,no" tabindex="1"/>
<div class="clear"></div>
<%---
<label>Respiratory System</label>
<% if(medExamObj.getRespiratorySystem()!=null){%>
  <input tabindex="1" type="text" name="<%=RESPIRATORY_SYSTEM%>" class="auto" size="100" maxlength="100"  value="<%=medExamObj.getRespiratorySystem() %>" validate="Respiratory System,string,no"/>

 <% }else{%>
 <input tabindex="1" type="text" name="<%=RESPIRATORY_SYSTEM%>" class="auto" size="100" maxlength="100" validate="Respiratory System,string,no"/>

 <% }%>  --%>
<div class="clear"></div>

	<%
			String gastroIntestinalSystem="";
			String breakDown="";
			String centralNervousSystem="";

			String localExamination="";
			String remarksClinical="";
			int opdDeptClinical=0;
			if(medExamObj.getGastroIntestinalSystem()!=null){
				gastroIntestinalSystem=medExamObj.getGastroIntestinalSystem();
			}
			if(medExamObj.getCentralNervousSystem()!=null){
				centralNervousSystem=medExamObj.getCentralNervousSystem();
			}
			if(medExamObj.getLocalExamination()!=null){
				localExamination=medExamObj.getLocalExamination();
			}
			if(medExamObj.getRemarksClinical()!=null){
				remarksClinical=medExamObj.getRemarksClinical();
			}
			if(medExamObj.getClinicalOpdDept()!=null){
				opdDeptClinical=medExamObj.getClinicalOpdDept().getId();
			}
			%>

<label>Gastro Intestinal System</label>

<input type="text" name="gastroIntestinalSystem" id="gastroIntestinalSystem" value="<%=gastroIntestinalSystem%>" size="100" class="auto"
 maxlength="999" validate="Gastro Intestinal System,metachar,no" tabindex="1"/>
<div class="clear"></div>
<label>Central Nervous System </label>
<% if(medExamObj.getCentralNervousSystemMMHG()!=null){%>
  <input tabindex="1" type="text" maxlength="999"  name="<%=NERVOUS_BRAKDOWN%>" class="auto" size="100"  value="<%=medExamObj.getCentralNervousSystemMMHG()%>" validate="Central Nervous System unit,metachar,no"/>

 <% }else{%>
 <input tabindex="1" type="text" maxlength="999"  name="<%=NERVOUS_BRAKDOWN%>" class="auto" size="100" validate="Central Nervous System,metachar,no"/>

 <% }%>
<%--  <input type="text" name="centralNervousSystem" id="centralNervousSystem" value="<%=centralNervousSystem%>" size="100" class="auto"
 maxlength="50" validate="Central Nervous System,string,no"/>--%>
<div class="clear"></div>
<label>Local Examination</label>
<input type="text" name="localExamination" id="localExamination" value="<%=localExamination%>" size="100" class="auto"
 maxlength="999" validate="Local Examination,metachar,no" tabindex="1"/>
<div class="clear"></div>

<label>Remarks</label>
<input type="text" name="remarksClinical" id="remarksClinical" value="<%=remarksClinical%>" size="100" class="auto" maxlength="999"
tabindex="1" validate="Clinical Remarks,metachar,no"/>
<div class="clear"></div>
<%String referredToMhClinical="";
if(medExamObj.getClinicalReferMh() !=null){
	referredToMhClinical=medExamObj.getClinicalReferMh();
}
%>
<label>Referred to MH</label>
<input name="referredToMhClinical" id="referredToMhClinical" value="<%=referredToMhClinical%>" maxlength="99"/>
<%--
//int referredToMhClinical=0;

if(masHospitalList.size()>0){
		for(MasHospital masHospital:masHospitalList){

		}
	}
if(masDepartmentList.size()>0){
	for(MasDepartment masDepartment:masDepartmentList){

	}
}
--%>
<%---
<select id="referredToMhClinical" name="referredToMhClinical" validate="Referred to MH,string,no" tabindex="1">
<option value="">Select</option>
<%if(masHospitalList.size()>0){
	for(MasHospital masHospital:masHospitalList){
		String selected="";
		if(referredToMhClinical==masHospital.getId()){
			selected="selected";
		}
 %>
<option value="<%=masHospital.getId()%>" <%=selected%>><%=masHospital.getHospitalName()%></option>
<%}
	}%>
</select> --%>

<label>Referred to OPD/Dept</label>
<select id="opdDeptClinical" name="opdDeptClinical" validate="OPD/Dept,string,no" tabindex="1">
<%if(masDepartmentList.size()>0){
	for(MasDepartment masDepartment:masDepartmentList){
		String selected="";
		if(opdDeptClinical==masDepartment.getId()){
			selected="selected";
		}
 %>
<option value="<%=masDepartment.getId()%>" <%=selected%>><%=masDepartment.getDepartmentName()%></option>
<%}
	}%>
</select>


<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<%
String medicalBoardStatus="";
boolean medicalBoardFlag=false;
if(medExamObj.getStatus()!=null){
	medicalBoardStatus=medExamObj.getStatus();
}
if(!medicalBoardStatus.equalsIgnoreCase("f")){
	medicalBoardFlag=true;
}
if(medicalBoardFlag){
%>
<div class="Clear paddingTop15"></div>
<%//if(!medExamObj.getStatus().equalsIgnoreCase("s")){ %>
<div id="specialistOpinionForward" style="display: inline;"> 
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Print Medical Case Sheet"	onclick="submitFormForButton('medicalBoardMOForm16','/hms/hms/medicalBoard?method=printMedicalCaseSheet')" />
<%if(dgOrderhd.getOrderStatus().equals("A")){ %>
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Print Investigations"	onclick="submitForInvestigationPrintOut();" />
<%} %>
<%if(medExamObj.getSpecialistRefer() !=null && medExamObj.getSpecialistRefer().equalsIgnoreCase("y")){ %>
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Forward to Specialist"	onclick="openPopupForSpecialistOpinionForward('<%=visitId%>','<%=medExamId %>');" id="forwardSpecial" disabled="disabled"/>
<%}else{ %>
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Forward to Specialist"	onclick="openPopupForSpecialistOpinionForward('<%=visitId%>','<%=medExamId %>');" id="forwardSpecial"/>
<%} %>
<%---
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Enter Specialist Opinion"	onclick="openPopupForSpecialistOpinion('<%=visitId%>','<%=medExamId %>');" /> --%>
<label>Refer Specialist</label>
<%if(medExamObj.getSpecialistRefer() !=null && medExamObj.getSpecialistRefer().equalsIgnoreCase("y")){ %>
<input type="checkBox" name="referSpecial" id="referSpecial" onclick="onclickSpecial();" checked="checked"/>
<%}else{ %>
<input type="checkBox" name="referSpecial" id="referSpecial" onclick="onclickSpecial();"/>
<%} %>
<input type="hidden" value="" name="specialValue" id="specialValue"/>
<div class="clear"></div>
<input type="button" value="Upload Specialist Report" class="buttonBig2" onClick="javascript:fileUploadViewWindow('SPE');" id="buttonSpecial"/></div>
</div>
<%}else if(medExamObj.getSpecialistRefer() !=null && medExamObj.getSpecialistRefer().equalsIgnoreCase("y")){  %>
<div class="Clear paddingTop15"></div>
<div id="specialistOpinionForward" style="display: inline;"> 
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Print Medical Case Sheet"	onclick="submitFormForButton('MedicalBoardInitialMedExamJsp','/hms/hms/medicalBoard?method=printMedicalCaseSheet')" />
<%if(dgOrderhd.getOrderStatus().equalsIgnoreCase("A")){ %>
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Print Investigations"	onclick="submitForInvestigationPrintOut();" />
<%} %>
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Forward to Specialist"
	onclick="openPopupForSpecialistOpinionForward('<%=visitId%>','<%=medExamId %>');" id="forwardSpecial"
	disabled="disabled"/>
<%---
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Enter Specialist Opinion"	onclick="openPopupForSpecialistOpinion('<%=visitId%>','<%=medExamId %>');" /> --%>
<label>Refer Specialist</label>
<input type="checkBox" name="referSpecial" id="referSpecial" onclick="onclickSpecial();" checked="checked"/>
<input type="hidden" value="y" name="specialValue" id="specialValue" /><div class="clear"></div>
<input type="button" value="Upload Specialist Report" class="buttonBig2" onClick="javascript:fileUploadViewWindow('SPE');" id="buttonSpecial"/></div>
<%} %>
<%// if(!medicalBoardFlag){ 
	if(!medicalBoardFlag || (medExamObj.getSpecialistRefer()!=null && medExamObj.getSpecialistRefer().equals("") && medExamObj.getSpecialistRefer().equals("n"))){ %>
<input type="button" value="Print Specialist Opinion" class="buttonBig2"
	onclick="submitForm('medicalBoardMOForm16','/hms/hms/medicalBoard?method=printSpecialistOpinionReport&medExamId=<%=medExamId %>&visitId=<%=visitId %>')">
	<%} %>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>Remarks by MO</h4>
<div class="clear"></div>
<div class="Block">

<label>Remarks</label>
<%String moRemarks="";
if(medExamObj.getRemarks() !=null){
moRemarks=medExamObj.getRemarks();}%>
<textarea rows="" cols="" name="moRemarks" id="moRemarks" validate="Remarks,metachar,no" value="<%=moRemarks%>" tabindex="1" onkeyup="chkLength(this,49);">
<%=moRemarks %></textarea>

<label>Signed By</label>
<input type="text" name="signedBy" id="signedBy" value="<%=signedBy %>" validate="Signed By,metachar,no"
	readonly="readonly"	tabindex="1"/>
</div>
<div class="clear PaddingTop15"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%if(medExamObj.getId()!=null)
{%>
<input tabindex="1" name="Button" type="button" class="button" value="Update"	onClick="submitForm('medicalBoardMOForm16','medicalBoard?method=updateMedicalBoardMO16&Labresult=<%=Labresult.trim() %>');" />
<% }else{%>
<%--<input type="button" onclick="submitdata()" value="Submit" class="button" name="Button" tabindex="1" /> --%>
<% }%>
<%
if(!medicalBoardFlag){
%>
<input tabindex="1" name="Button" type="button" class="button" value="Validate" onClick="submitForm('medicalBoardMOForm16','medicalBoard?method=updateMedicalBoardMO16&data=validate&Labresult=<%=Labresult.trim() %>');"/>
<%} %>
<input tabindex="1" name="Button" type="button" class="button" value="REJECT"	onClick="checkReject();" />
<input tabindex="1" class=button id=reset onclick="resetCheck();" type=reset value=Reset name=Reset  accessKey=r/>
<input type="button" name="viewCaseSheet" value="Medical Case Sheet" class="buttonBig2" onclick="submitForm('medicalBoardMOForm16','/hms/hms/medicalBoard?method=printMedicalCaseSheet')" />
<%

if(dgOrderhd.getOrderStatus().equals("A")){ %>
<input tabindex="1" name="Button" type="button" class="buttonBig" 
	value="Print Investigations" onclick="submitForInvestigationPrintOut();" />
<%} %>
<input name="Send" type="hidden"  class="button" value="Upload" onClick="javascript:FileUploadViewWindow('ALL');" />
<input name="Send" type="hidden"  class="buttonBig" value="Specialist Opinion" onClick="openPopupForSpecialistOpinion()" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="clear"></div>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<INPUT	type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>">
<INPUT type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>">
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>">

</div>
<%----
<%if(visit.getDoctor() != null){ %>
<input name="empId" type="hidden" value="" />
<%}%>
<%if(visit.getDepartment() != null){
	%>
<input name="deptId" type="hidden" value="<%=visit.getDepartment().getId()%>" />
<%}%>
<%if(visit.getHin() != null){
%>
<input name="hinId" type="hidden" value="<%=visit.getHin().getId()%>" />
<%}%>

<%if(visit.getHin() != null){%>
<input name="visitId" type="hidden" value="<%=visit.getId()%>" />
<input name="visitNumberForReport" type="hidden" value="<%=visit.getVisitNo()%>" />
<%}%> --%>
<input type="hidden"  name="medicalType" id="medicalType" value="<%=medExamObj.getMedicalType() %>"/>
<input type="hidden"  name="MissTeeth" id="MissTeeth" value=""/>
<input type="hidden"  name="UnserTeeth" id="UnserTeeth" value=""/>

<!--Bottom labels starts--> <!--main content placeholder ends here--> <script
	type="text/javascript">
	function generateRowMdicalBoard1(idName) {
		 var d=document.getElementById(idName).getElementsByTagName("tr");

		lastTr = d[d.length-1]
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input");
		tblCtrl[0].value=d.length-2;
		document.getElementById('hiddenValue').value =d.length-2
		for(var i=4;i<tblCtrl.length;i++)
			tblCtrl[i].value="";


		}
    function removeRowMedicalBoard1()
	{
	  var tbl = document.getElementById('amcDetailId');
	 if(document.getElementById('hiddenValue').value >1){

	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	  }
	}
	</script> <script type="text/javascript">
function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {

        limitField.value = limitField.value.substring(0, limitNum);

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
function isAlpha(argvalue) {
argvalue = argvalue.toString();
var validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

for (var n = 0; n < argvalue.length; n++) {
if (validChars.indexOf(argvalue.substring(n, n+1)) == -1)
return false;
}
return true;
}

function CheckAlpha()
{

    var txt=document.getElementById('txtAlpha');
    var filter=/^[a-zA-Z]+$/;
    var test_bool = filter.test(txt.value);
    if (test_bool==false)
    {
        alert('Please Enter Only Alphabets');
        txt.focus();
        return false;
    }
}


</script> <script language="JavaScript" type="text/JavaScript">
function isNumber(field) {
        var re = /^[0-9-'.'-',']*$/;
        if (!re.test(field.value)) {
            alert('please enter only numeric data');
            field.value = field.value.replace(/[^0-9-'.'-',']/g,"");
        }

    }


</script> <script language="JavaScript" type="text/javascript">

  function isNumber1(field) {
       var i=3;
        var re = /^[0-9-'.'-',']*$/;
        if (!re.test(field.value)) {
            alert('please enter only numeric data');
            field.value = field.value.replace(/[^0-9-'.'-',']/g,"");

        }
     var aa=field.value[1];
    if(field.value.indexOf(".")<4)
    {
 return true;
 }
 else
 {
     alert('please enter less than three digit before decimal point'+aa);
		 field.value='';

	}
}

  function checkForWiegth(val,id){
	  var index=val.indexOf(".");
	  if(index!=-1){
	  	var arr= val.split(".");
	  	if(arr[1].length>3){
	  	alert("pls check the decimal fractions");
	  	document.getElementById(id).value="";
	  	document.getElementById(id).focus();
	  	return false;
	  	}

	  	}
	  	else{

	  	if(val.length>3){
	  	alert("pls give the decimal point after three digit");
	  	document.getElementById(id).value="";
	  	document.getElementById(id).focus();
	  	return false;
	  	}

	   }
  }
  function chkLength(field,maxLimit)
   {
   if(field.value.length > maxLimit)
   {
    alert('Maximum Limit is '+maxLimit+' characters.');
    var val=field.value.substring(0,maxLimit);
    field.value=val;
   }
}
  function showHideInvestigationTemplateCombo(valueOfTemplate){

		if(checkTemplateId(valueOfTemplate)){

		  	document.getElementById("copyPrevInvestigationTemplateDiv").style.display='none';

				submitProtoAjaxWithDivName('medicalBoardMOForm16','/hms/hms/opd?method=showGridForInvestigation&flag=Board','gridview');

				}

	}
  function addRowForInvestigation(){

	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  document.getElementById('investigationDataStatus').value="yes";
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){
		if(validateInvestigationAutoComplete(this.value,iteration)){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration,'parent');}
	  };
	   var newdiv1 = document.createElement('div');
	  newdiv1.setAttribute('id', 'ac2update'+iteration);
	  newdiv1.setAttribute('class', 'autocomplete');
	  newdiv1.style.display = 'none';

	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.setAttribute('tabindex','1');
	
	  e0.size = '45'
	  cellRight0.appendChild(newdiv1);
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});

	  
	  var cellRight11 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'checkbox';
	  e11.name = 'investigationReferToMH' + iteration;
	  e11.id = 'investigationReferToMH' + iteration;
	  e11.value='n';
	  e11.className = 'radioAuto';
	  e11.setAttribute('tabindex','1');
	  e11.onclick = function(){checkForInvestigationMH(iteration)};
	  cellRight11.appendChild(e11);

	  var cellRight1 = row.insertCell(2);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '65';
	  e1.name = 'Result' + iteration;
	  e1.id = 'Result' + iteration;
	  e1.setAttribute('readonly','readonly');
	  e1.setAttribute('maxlength', 20);
	  e1.setAttribute('tabindex','1');
      cellRight1.appendChild(e1);

      var sel = document.createElement('input');
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
	  var cellRight30 = row.insertCell(3);
	  var e30 = document.createElement('input');
	  e30.type = 'button';
	  e30.className = 'button';
	  e30.name='uploadReport'+iteration;;
	  e30.id='uploadReport'+iteration;
	  e30.value='UPLOAD REPORT';
	  e30.style.display='none';
	 // e30.style.display='inline';
	  e30.onclick = function(){fileUploadWindowInvestigation(iteration);};
	  cellRight30.appendChild(e30);

	  var cellRight1 = row.insertCell(4);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonAdd';
	  e3.name='Button';
	  e3.onclick = function(){addRowForInvestigation();};
	  cellRight1.appendChild(e3);

	  var cellRight2 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonDel';
	  e4.name='delete';
	  e4.onclick = function(){removeRowForInvestigation(this);};
	  cellRight2.appendChild(e4);


	}
function submitFormForPrescriptionReport(){
	  var hinNoForreport=document.getElementById('hinNoForreport').value;
      <%if(medExamObj.getVisit()!=null){%>
	  var url='/hms/hms/opd?method=showPatientInvestigationReport&visitNumberForReport='+<%=medExamObj.getVisit().getVisitNo()%>+'&hinNoForReport='+hinNoForreport+'&serviceNoForReport='+<%=medExamObj.getVisit().getHin().getServiceNo()%>;
      newwindow=window.open(url,'ar',"left=2,top=100,height=500,width=500,status=1,scrollbars=1,resizable=0");
	<%}%>
	}
 function removeRowForInvestigation()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  document.getElementById('investigationDataStatus').value="yes";
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
 function checkForInvestigationMH(inc)
 {
    if(document.getElementById('investigationReferToMH'+inc).checked==true)
    {
        document.getElementById('investigationReferToMH'+inc).value='y';
        document.getElementById('Result'+inc).readOnly=false;
        document.getElementById("uploadReport"+inc).style.display='inline';

    } else
    {
    	document.getElementById('investigationReferToMH'+inc).value='n';
    	 document.getElementById('Result'+inc).readOnly=true;
         document.getElementById("uploadReport"+inc).style.display='none';
    }
 }
 function openPopupForPatientInvestigation(visitNo,hinId){

	if(visitNo >1){
	var url="/hms/hms/opd?method=showPatientPreviousInvestigation&visitNo="+visitNo+"&hinId="+hinId;
   newwindow=window.open(url,'name','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
   }else{
     alert("This is Patient's First Visit. ")
   }
}
 function showCreateInvestigationTemplate(){

     document.getElementById("investigationImportButton1").style.display='inline'
   	var url="/hms/hms/opd?method=showCreateInvestigationTemplate";
    newwindow=window.open(url,'investigation',"height=500,width=1010,status=1,top=0,left=2");


}
 function copyPrevInvestigationTempate(visitNo,hinId){
		document.getElementById('templateDivInvestigationToShowHide').style.display = 'none';
		document.getElementById('prevButtonDivInvestigationToShowHide').style.display = 'none';
		document.getElementById('createInvestigationDivToShowHide').style.display = 'none';

		var hdb = document.getElementById('hdb').value;
	    submitProtoAjaxWithDivName('medicalBoardMOForm16','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}
 function getListForTreatment(val){
	 	if(val=='investigationDiv'){
			submitProtoAjaxWithDivName('medicalBoardMOForm16','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
		}else if(val=='treatmentDiv'){
			submitProtoAjaxWithDivName('medicalBoardMOForm16','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
		}
//		document.getElementById('prescriptionImportButton').style.display = 'none';
//		document.getElementById("investigationImportButton").style.display='none'
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
			//submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=fillChargeCodeForInvestigation&chargeCodeNAmeForAjax='+ tempChargeCodeString+'&rowVal=1',chargeCodeTdDiv);

			}else{
				document.getElementById('chargeCodeName'+inc).value = "";
				document.getElementById('qty'+inc).value = "";
				document.getElementById('chargeCode'+inc).value = "";
				//document.getElementById('qty'+inc).value = "";
				//document.getElementById('qty'+inc).value = "";
			}
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
	  e0.name = 'serialNo' + iteration;
	  e0.id = 'serialNo' + iteration;
	  e0.setAttribute('maxlength', 20);
	  e0.setAttribute('readonly','readonly');
     e0.size = '1';
     e0.value=hdb.value;
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '11';
	  e1.setAttribute('readonly','readonly');
	  e1.name = 'from' + iteration;
	  e1.id = 'from' + iteration;
	  e1.setAttribute('tabindex','1');
     cellRight1.appendChild(e1);

     var cellRight11 = row.insertCell(2);
     var e11 = document.createElement('img');
     e11.src = '/hms/jsp/images/cal.gif';
    //e3.style.display ='none';
     e11.id = 'calId'+iteration;
     e11.onclick = function(event){
     setdate('',document.getElementById('from'+iteration),event) };
     cellRight11.appendChild(e11);

     var cellRight2 = row.insertCell(3);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.size = '11';
	  e2.name = 'to' + iteration;
	  e2.id = 'to' + iteration;
     e2.setAttribute('tabindex','1');
     e2.setAttribute('readonly','readonly');
     cellRight2.appendChild(e2);
     var cellRight21 = row.insertCell(4);
     var e21 = document.createElement('img');
     e21.src = '/hms/jsp/images/cal.gif';
    // e3.style.display ='none';
     e21.id = 'calId'+iteration;
     e21.onclick = function(event){
     setdate('',document.getElementById('to'+iteration),event) };
     cellRight21.appendChild(e21);

     var cellRight3 = row.insertCell(5);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'place' + iteration;
	  e3.id = 'place' + iteration;
     e3.size = '20';
     e3.setAttribute('maxlength', 99);
	  e3.setAttribute('tabindex','1');
     cellRight3.appendChild(e3);

     var cellRight4 = row.insertCell(6);
     var e4 = document.createElement('select');
   //e4.type = 'select';
	  e4.name = 'pNo' + iteration;
	  e4.id = 'pNo' + iteration;
     e4.options[0] = new Option('select', '');
     e4.options[1] = new Option('Peace', 'Peace');
     e4.options[2] = new Option('Field', 'Field');
     e4.options[3] = new Option('MFA', 'MFA');
   //e4.size = '20';
	  e4.setAttribute('tabindex','1');
     cellRight4.appendChild(e4);
     
     var cellRight5 = row.insertCell(7);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonAdd';
	  e5.name='remarks'+iteration;
	  e5.setAttribute('onClick', 'addRow();');
	  e5.setAttribute('tabindex','1');
	  cellRight5.appendChild(e5);

	  var cellRight6 = row.insertCell(8);
	  var e6 = document.createElement('input');
	  e6.type = 'button';
	  e6.className = 'buttonDel';
	  e6.name='remarks'+iteration;
	//  e6.setAttribute('onClick', 'removeRow('grid','hdb',this);');
	  e6.onclick =function(){removeRow('grid','hdb',this);};
	  e6.setAttribute('tabindex','1');
	  cellRight6.appendChild(e6);

	  displayNextDate(iteration-1);

	}

 function displayNextDate(i){
		if(document.getElementById('to'+i) && document.getElementById('to'+i).value!=''){
		var tDate = document.getElementById('to'+i).value;
	    var NextDate=new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		   
		   var d = NextDate.getDate();
		   var m = NextDate.getMonth();
		   var y = NextDate.getFullYear();
		   var date1= new Date(y, m+1, d+1);
		   //var date11=date1.getMonth()+1+"/"+date1.getDate()+"/"+date1.getFullYear();
		   var date11=date1.getDate()+"/"+date1.getMonth() +"/"+ date1.getFullYear();
		   document.getElementById('from'+(i+1)).value = date11;

		}
	}


	function removeRow2()
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
	function addRow1(){

		  var tbl = document.getElementById('grid1');
		  var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
		  var iteration = lastRow-1;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('hdb1');
		  hdb.value=iteration;
		  
		  var cellRight0 = row.insertCell(0);
		  var e0 = document.createElement('input');
		  e0.type = 'text';
		  e0.name = 'serialNo1' + iteration;
		  e0.id = 'serialNo1' + iteration;
		  e0.value=iteration;
		  e0.setAttribute('maxlength', 20);
		  e0.setAttribute('readonly','readonly');
	      e0.size = '2';
		  e0.setAttribute('tabindex','1');
		  cellRight0.appendChild(e0);

		  var cellRight1 = row.insertCell(1);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.name = 'illness' + iteration;
		  e1.id = 'illness' + iteration;
		  e1.setAttribute('maxlength', 22);
	      e1.size = '22';
		  e1.setAttribute('tabindex','1');
	      cellRight1.appendChild(e1);

		  var newdiv1 = document.createElement('div');
		  newdiv1.setAttribute('id', 'ac2updatex2'+iteration);
		  newdiv1.setAttribute('class', 'autocomplete');
		  newdiv1.style.display = 'none';
		  cellRight1.appendChild(newdiv1);
		  cellRight1.appendChild(e1);
		//new Ajax.Autocompleter('illness'+iteration,'ac2updatex2'+iteration,'medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=illness'+iteration});
		new Ajax.Autocompleter('illness'+iteration,'ac2updatex2'+iteration,'opd?method=getICDForIdList',{parameters:'requiredField=illness'+iteration});
		
    var cellRight2 = row.insertCell(2);
    var e2 = document.createElement('input');
    e2.type = 'text';
    e2.className = 'date';
   // e2.readOnly = true;
    e2.setAttribute('readonly','readonly');
    e2.name='particulardate'+ iteration;
    e2.size = '11';
    e2.id='particulardate'+iteration;
    cellRight2.appendChild(e2);

    var cellRight3 = row.insertCell(3);
    var e3 = document.createElement('img');
    e3.src = '/hms/jsp/images/cal.gif';
   // e3.style.display ='none';
    e3.id = 'calId'+iteration;
    e3.onclick = function(event){
    setdate('',document.getElementById('particulardate'+iteration),event) };
    cellRight3.appendChild(e3);

    var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name = 'place1' + iteration;
	  e4.id = 'place1' + iteration;
	  e4.size = '20';
	  e4.setAttribute('maxlength', 99);
	  e4.setAttribute('tabindex','1');
    cellRight4.appendChild(e4);

	    /*  var cellRight5 = row.insertCell(5);
	      var e5 = document.createElement('select');
	      e5.options[0] = new Option('Select', '');
	      e5.name = 'rankindividualid'+ iteration;
	      e5.id = 'rankindividualid' + iteration;
	      e5.tabIndex="1";
	      for(var i = 0;i<bankArray.length;i++ ){
	    	  e5.options[bankArray[i][0]] = new Option(bankArray[i][1],bankArray[i][0]);
	    	  }
	    	cellRight5.appendChild(e5);
		*/
	      var cellRight6 = row.insertCell(5);
		  var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.name = 'treated' + iteration;
		  e6.id = 'treated' + iteration;
		  e6.size = '20';
		  e6.setAttribute('maxlength', 99);
		  e6.setAttribute('tabindex','1');
	      cellRight6.appendChild(e6);


    var cellRight7 = row.insertCell(6);
    var e7 = document.createElement('input');
    e7.type = 'text';
    e7.name='approximatedate'+ iteration;
    e7.id='approximatedate'+iteration;
    e7.size='40';
    e7.setAttribute('maxlength', 30);
		e7.setAttribute('tabindex','1');
	    cellRight7.appendChild(e7);

	    var cellRight8 = row.insertCell(7);
	      var e8 = document.createElement('img');
	      e8.src = '/hms/jsp/images/cal.gif';
	     // e8.style.display ='none';
	      e8.id = 'calId1'+iteration;
	      e7.size='11';
	      e8.onclick = function(event){
	      setdate('',document.getElementById('approximatedate'+iteration),event) };
	      cellRight8.appendChild(e8);

	    	var cellRight9 = row.insertCell(8);
	      var e9 = document.createElement('input');
	      e9.type = 'text';
	      e9.className = 'date';
	      e9.size='11';
	     // e9.readOnly = true;
	      e9.setAttribute('readonly','readonly');
	      e9.name='approximatedate2'+ iteration;
	      e9.id='approximatedate2'+iteration;
	      cellRight9.appendChild(e9);

	      var cellRight10 = row.insertCell(9);
	      var e10 = document.createElement('img');
	      e10.src = '/hms/jsp/images/cal.gif';
	     // e10.style.display ='none';
	      e10.id = 'calId2'+iteration;
	      e10.onclick = function(event){
	      setdate('',document.getElementById('approximatedate2'+iteration),event) };
	      cellRight10.appendChild(e10);


	      var cellRight11 = row.insertCell(10);
		  var e11 = document.createElement('input');
		  e11.type = 'button';
		  e11.className = 'buttonAdd';
		  e11.setAttribute('onClick', 'addRow1();');
		  e11.setAttribute('tabindex','1');

		  var exx2 = document.createElement('input');
		  exx2.type = 'hidden';
		  exx2.name='beforeDisability'+iteration;
		  exx2.id='beforeDisability'+iteration
		  exx2.value='n';
		  
		  cellRight11.appendChild(exx2);
		  cellRight11.appendChild(e11);

		  var cellRight12 = row.insertCell(11);
		  var e12 = document.createElement('input');
		  e12.type = 'button';
		  e12.className = 'buttonDel';
		  e12.name='remarks'+iteration;
		//  e12.setAttribute('onClick', 'removeRow("grid1","hdb1",this);');
		  e12.onclick =function(){removeRow('grid1','hdb1',this);};
		  e12.setAttribute('tabindex','1');
		  cellRight12.appendChild(e12);

		}
	function removeRow1()
	{
	  var tbl = document.getElementById('grid1');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('grid1');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hdb1');
	  	hdb.value=iteration
	  }
	}
	function FileUploadWindow()
	{
		   var folderName='hearing';
			var url="/hms/hms/medicalExam?method=displayFileUpload&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId()%>&hinNo=<%=visit.getHin().getHinNo()%>&folder="+folderName;

			newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

	}
	function fileUploadWindowInvestigation(rowVal)
	{
		var hinNo='<%=visit.getHin().getHinNo()%>'
		var medicalExamId='<%=medExamId%>';
	 	//if(medicalExamId=='0')
	 //	{
	 	// 	alert("file can not be uploaded; refferred to MH");
	 	 //	return false;
	 //	}else{
	 		var val=document.getElementById('chargeCodeName'+rowVal).value;
	 	 	var index1 = val.lastIndexOf("[");
	 	 	var index2 = val.lastIndexOf("]");
	 	 	index1++;

	 	var invest_id = val.substring(index1,index2);
	 	if(validateMetaCharacters(hinNo)){
	 		var url="/hms/hms/medicalExam?method=displayFileUploadInvestigation&hinId=<%=visit.getHin().getId()%>&hinNo="+hinNo+"&invest_id="+invest_id+"&masExamId=<%=medExamId%>";
		}
	 		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	 //	}

	}
	function FileUploadWindowGynaecology()
	{
		var folderName='gynaecology';
			var url="/hms/hms/medicalBoard?method=displayFileUpload";

			newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	}


	function submitdata()
	{
		var charge=document.getElementById("chargeCodeName1").value;
        if(charge=="")
        {
         alert("Please Select Test Name");
         return false;
        }else{
        	submitForm('medicalBoardMOForm16','medicalBoard?method=addMedicalBoardMO16');
        }


	}
	function chkValue(Obj)
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
 	var mval=document.getElementById('MissTeeth').value;
 	var uval=document.getElementById('UnserTeeth').value;
 	if(name[0]=='m')
 	{
 		mval=mval+" "+name.substring(1,name.length).toUpperCase();
 		document.getElementById('MissTeeth').value=mval;
 	}
 	if(name[0]=='u')
 	{
 		//alert("val u--"+uval);
 		//alert("val-length u-"+name.length);
 		//alert("val-sub111 u-"+name.substring(1,name.length));
 		uval=uval+" "+name.substring(1,name.length).toUpperCase();
 		//alert("val u--"+uval);
 		document.getElementById('UnserTeeth').value=uval;
 	}
 }
 //function FileUploadViewWindow()
 //{
 		//var url="/hms/hms/medicalBoard?method=showUploadViewDocumentJsp";

 		//newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

 //}
 function fileUploadViewWindow(flag)
{
	//flag=HEA Means-->Hearing
	//flag=GYN Means-->GYNAECOLOGY EXAM
	//flag=ALL Means-->ALL Type
//	<li><a href="opd?method=showUploadingDocumentsJsp&visitId=<%=visit.getId() %>">Upload Documents </a></li>
		var url="/hms/hms/medicalBoard?method=showUploadViewDocumentJsp&visitId=<%=visit.getId()%>&medExamId=<%=medExamId%>&flag="+flag;

		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

}


 //function openPopupForSpecialistOpinion()
 //{
 //	var url="/hms/hms/medicalBoard?method=showSpecialistOpinionJsp";
 //	newwindow=window.open(url,'mbSpecialistOpinion','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
 //}
 function addRowForDisability(){
	  var tbl = document.getElementById('gridDisability');
	  var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);

	  var hdb = document.getElementById('hdbDisability');
	  hdb.value=iteration
	  
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  var newdiv1 = document.createElement('div');
	  newdiv1.setAttribute('id', 'ac2updatex1'+iteration);
	  newdiv1.setAttribute('class', 'autocomplete');
	  newdiv1.style.display = 'none';
	
	  e0.name = 'systemDiagnosis' + iteration;
	  e0.id = 'systemDiagnosis' + iteration;
	  e0.setAttribute('tabindex','1');
	  e0.size = '50'
	  cellRight0.appendChild(newdiv1);
	  cellRight0.appendChild(e0);
	  //new Ajax.Autocompleter('systemDiagnosis'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});	  var sel = document.createElement('input');
	  //new Ajax.Autocompleter('systemDiagnosis'+iteration,'ac2updatex1'+iteration,'medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=systemDiagnosis'+iteration});
	   new Ajax.Autocompleter('systemDiagnosis'+iteration,'ac2updatex1'+iteration,'opd?method=getICDForIdList',{parameters:'requiredField=systemDiagnosis'+iteration});
	    
/* 		e0.name = 'icdDisability' + iteration;
		e0.id = 'icdDisability' + iteration;
		e0.setAttribute('tabindex','1');
		//alert("name--"+e0.name)
		e0.size = '50'
		cellRight0.appendChild(newdiv1);			
		cellRight0.appendChild(e0);			
		new Ajax.Autocompleter('icdDisability'+iteration,'ac2updatex1'+iteration,'opd?method=getICDForIdList',{parameters:'requiredField=icdDisability'+iteration});
*/
	  var cellRight1 = row.insertCell(1);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonAdd';
	  e3.name='Button';
	  //e3.setAttribute('onClick','addRowForDisability();');
	  e3.onclick =function(){addRowForDisability();};
	  cellRight1.appendChild(e3);

	  var cellRight2 = row.insertCell(2);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonDel';
	  e4.name='delete';
	//e4.setAttribute('onClick','removeRow("gridDisability","hdbDisability",this);');
	  e4.onclick =function(){removeRow('gridDisability','hdbDisability',this);};
	  cellRight2.appendChild(e4);
	}
function removeRowDisability()
{
 var tbl = document.getElementById('gridDisability');
 var lastRow = tbl.rows.length;
 if (lastRow > 2){
 	tbl.deleteRow(lastRow - 1);
 	var tbl = document.getElementById('gridDisability');
 	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow - 1;
 	var hdb = document.getElementById('hdbDisability');
 	hdb.value=iteration
 }
}
function addRowBefore(){
	  var tbl = document.getElementById('gridIllness');
	  var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdbBefore');
	  hdb.value=iteration;
	  var cellRight0 = row.insertCell(0);

	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'serialNo11' + iteration;
	  e0.id = 'serialNo11' + iteration;
	  e0.value=iteration;
	  e0.setAttribute('maxlength', 20);
	  e0.setAttribute('readonly','readonly');
    e0.size = '2';
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);
	/*
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = 'illness1' + iteration;
	  e1.id = 'illness1' + iteration;
	  e1.setAttribute('maxlength', 20);
    e1.size = '20';
	  e1.setAttribute('tabindex','1');
    cellRight1.appendChild(e1);
	*/
	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	
	e1.name = 'illness1' + iteration;
	e1.id = 'illness1' + iteration;
	e1.setAttribute('maxlength', 22);
	e1.size = '35';
	e1.setAttribute('tabindex','1');
	cellRight1.appendChild(e1);
	
	var newdiv1 = document.createElement('div');
	newdiv1.setAttribute('id', 'ac2updatex3'+iteration);
	newdiv1.setAttribute('class', 'autocomplete');
	newdiv1.style.display = 'none';
	cellRight1.appendChild(newdiv1);
	cellRight1.appendChild(e1);
	//new Ajax.Autocompleter('illness1'+iteration,'ac2updatex3'+iteration,'medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=illness1'+iteration});
	new Ajax.Autocompleter('illness1'+iteration,'ac2updatex3'+iteration,'opd?method=getICDForIdList',{parameters:'requiredField=illness1'+iteration});

  var cellRight2 = row.insertCell(2);
  var e2 = document.createElement('input');
  e2.type = 'text';
  e2.className = 'date';
  e2.size = '11';
 // e2.readOnly = true;
  e2.setAttribute('readonly','readonly');
  e2.name='particulardate1'+ iteration;
  e2.id='particulardate1'+iteration;
  cellRight2.appendChild(e2);

  var cellRight3 = row.insertCell(3);
  var e3 = document.createElement('img');
  e3.src = '/hms/jsp/images/cal.gif';
 // e3.style.display ='none';
  e3.id = 'calId'+iteration;
  e3.onclick = function(event){
  setdate('',document.getElementById('particulardate1'+iteration),event) };
  cellRight3.appendChild(e3);

    var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name = 'place11' + iteration;
	  e4.id = 'place11' + iteration;
	  e4.size = '20';
	  e4.setAttribute('maxlength', 99);
	  e4.setAttribute('tabindex','1');
    cellRight4.appendChild(e4);

  /*  var cellRight5 = row.insertCell(5);
    var e5 = document.createElement('select');
    e5.options[0] = new Option('Select', '');
    e5.name = 'rankindividualid'+ iteration;
    e5.id = 'rankindividualid' + iteration;
    e5.tabIndex="1";
    for(var i = 0;i<bankArray.length;i++ ){
  	  e5.options[bankArray[i][0]] = new Option(bankArray[i][1],bankArray[i][0]);
  	  }
  	cellRight5.appendChild(e5);
	*/
    var cellRight6 = row.insertCell(5);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name = 'treated1' + iteration;
	  e6.id = 'treated1' + iteration;
	  e6.size = '20';
	  e6.setAttribute('maxlength', 99);
	  e6.setAttribute('tabindex','1');
    cellRight6.appendChild(e6);

    var cellRight11 = row.insertCell(6);
	  var e11 = document.createElement('input');
	  e11.type = 'button';
	  e11.className = 'buttonAdd';
	  e11.name='remarks1'+iteration;
	  e11.setAttribute('onClick', 'addRowBefore();');
	  e11.setAttribute('tabindex','1');
	  cellRight11.appendChild(e11);

	  var cellRight12 = row.insertCell(7);
	  var e12 = document.createElement('input');
	  e12.type = 'button';
	  e12.className = 'buttonDel';
	  e12.name='remarks1'+iteration;
	 // e12.setAttribute('onClick', 'removeRow('gridIllness','hdbBefore',this);');
	  e12.onclick =function(){removeRow('gridIllness','hdbBefore',this);};
	  e12.setAttribute('tabindex','1');

	  var exx2 = document.createElement('input');
	  exx2.type = 'hidden';
	  exx2.name='beforeDisability1'+iteration;
	  exx2.id='beforeDisability1'+iteration
	  exx2.value='y';
	  cellRight12.appendChild(exx2);
	  
	  cellRight12.appendChild(e12);

	}
function removeRowBefore()
{
var tbl = document.getElementById('gridIllness');
var lastRow = tbl.rows.length;
if (lastRow > 2){
	tbl.deleteRow(lastRow - 1);
	var tbl = document.getElementById('gridIllness');
	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow - 1;
	var hdb = document.getElementById('hdbBefore');
	hdb.value=iteration
}
}
function checkReject()
{
	var medRemarks=document.getElementById("moRemarks").value;
	if(medRemarks!=""){
		//alert("Please Enter Medical Board Details Remark. true");
		submitForm('medicalBoardMOForm16','medicalBoard?method=rejectMBForm16Entry&rejectStatus=fr');
	}else{
		alert("Please Enter Medical Board Details Remark.");
		return false;
		}
}
function putPulseRateValue()
{
	var pulseRate=document.getElementById("pulseRate").value;
	if(pulseRate != "" ){
		document.getElementById("pulseRate1").value=pulseRate;
	}
}
function putBpRateValue()
{
	var bloodpressure=document.getElementById("bloodpressure").value;
	if(bloodpressure != "" ){
		document.getElementById("bloodpressure1").value=bloodpressure;
	}
}
function submitForInvestigationPrintOut()
{
	var orderNo=document.getElementById('dgOrderhdId').value;
	var flag="MO";
	var hinId= document.getElementById('hinId').value;
	if(orderNo!=null && orderNo!="" && hinId!=null && hinId!=""){
		submitFormForButton('medicalBoardMOForm16','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo+'&hinId='+hinId+'&flag='+flag);
		}
}

function openPopupForSpecialistOpinionForward(visitId,medExamId){
	document.getElementById('specialistOpinionForward').style.display='none';
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
	        var msg  = item.getElementsByTagName("msg")[0];
			//if(msg.childNodes[0]!='undefined'){
				alert(msg.childNodes[0].nodeValue);
		//	}

      	}
      }
    }
    var url="/hms/hms/medicalBoard?method=forwardMedExamSpecialOpinion&visitId="+visitId+"&flagForward=s&medExamId="+medExamId;   
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
//   newwindow=window.open(url,'mbSpecialistOpinion','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function openPopupForSpecialistOpinion(visitId,medExamId){
	var url="/hms/hms/medicalBoard?method=showSpecialistOpinionJsp&visitId="+visitId+"&SecialFlag=y&medExamId="+medExamId;
   newwindow=window.open(url,'mbSpecialistOpinion','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
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
function openPopupPatientPreviousVisit()
{
	var url="/hms/hms/medicalBoard?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>";
   	newwindow=window.open(url,'opdPatientPrevVisitForViewScreen','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function getPrevMedBoardFromHIC()
{
	var url="/hms/hms/medicalBoard?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>&serviceNo=<%=visit.getHin().getServiceNo() %>";
   	newwindow=window.open(url,'opd_previousVisitForMedicalBoard','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function getPrevMedExamFromHIC()
{
	//var url="/hms/hms/medicalBoard?method=getPrevMedExamFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";
	var url="/hms/hms/medicalBoard?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>";
   	newwindow=window.open(url,'opd_previousVisitForMedicalExampVal','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function showPatientPreVisitHospitality()
{
	var url="/hms/hms/medicalBoard?method=showPatientPreVisitHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";
   	newwindow=window.open(url,'opd_previousVisitForHospitality','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function openTemplateScreen(index){
	var resultId = document.getElementById('resultIdTemplate'+index).value;
    //submitForm('medicalBoardMAForm16','investigation?method=searchPatientForResultValidation&resultId='+resultId+'&flagForLab=fromLab');
     var url="/hms/hms/investigation?method=searchPatientForResultValidation&resultId="+resultId+"&flagForLab=fromExam";
    newwindow=window.open(url,'ar',"left=2,top=100,height=500,width=500,status=1,scrollbars=1,resizable=0");
 }

function onclickSpecial(){
	 if(document.getElementById('referSpecial').checked==true){
		 document.getElementById('forwardSpecial').disabled = true;
		 document.getElementById('specialValue').value='y';
		 
	 }else{
		 document.getElementById('forwardSpecial').disabled = false;
		 document.getElementById('specialValue').value='n';
	 }
}
function checkDentalReferToMH()
{
		if(document.getElementById("dentalReferToMH").checked==true)
		{
			document.getElementById('dentalDivId').style.display='inline';
		}else{
			document.getElementById('dentalDivId').style.display='none';
		}
}
</script></form>
</body>

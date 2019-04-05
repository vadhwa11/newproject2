
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

<%@page import="jkt.hms.masters.business.Category"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
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
var rankArray=new Array();
var unitArray=new Array();
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasUnit> masUnitList = new ArrayList<MasUnit>();
	//List<MbTypeOfEntryMaster> typeOfEntryMasterList = new ArrayList<MbTypeOfEntryMaster>();
	//List<MasMaritalStatus> masMaritalStatusList = new ArrayList<MasMaritalStatus>();
	List<MasRank> masRankList = new ArrayList<MasRank>();
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
	
	if(map.get("masUnitList")!=null)
	{
		masUnitList = (List) map.get("masUnitList");
	}
	/*
	if(map.get("mbTypeOfEntryMaster")!=null)
	{
		typeOfEntryMasterList = (List) map.get("mbTypeOfEntryMaster");
	}
	if(map.get("masMaritalStatusList")!=null)
	{
		masMaritalStatusList = (List) map.get("masMaritalStatusList");
	}
	*/
	List templateList= new ArrayList();
	if(map.get("templateList") != null){
	templateList=(List)map.get("templateList");
	}
	if(map.get("masRankList")!=null)
	{
		masRankList = (List) map.get("masRankList");
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
	List<Category> categoryList= new ArrayList<Category>();
	if(map.get("categoryList") != null){
		categoryList=(List)map.get("categoryList");
	}
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
	String service_no="";
	if(visit.getHin()!=null){
		service_no=visit.getHin().getServiceNo();
	}
	String rank="";
	if(visit.getHin().getRank()!=null){
		rank=visit.getHin().getRank().getRankName();
	}
	String signedBy="";
	int loginEmpId=0;
	/*
	if(session.getAttribute("users")!=null){
	Users user = (Users) session.getAttribute("users");
	if(user.getEmployee()!=null){
		signedBy=user.getEmployee().getFirstName();
		if(user.getEmployee().getMiddleName()!=null){
			signedBy=signedBy+" "+user.getEmployee().getMiddleName();
		}
		if(user.getEmployee().getLastName()!=null){
			signedBy=signedBy+" "+user.getEmployee().getLastName();
		}
	}
		if(user.getEmployee()!=null){
			loginEmpId=user.getEmployee().getId();
		}
	}*/
	List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
	if(map.get("employeeMoList")!=null)
	{
		employeeMoList = (List<MasEmployee>) map.get("employeeMoList");

	}
	if(employeeMoList.size()>0){
		for(MasEmployee masEmployee:employeeMoList){
			loginEmpId=masEmployee.getId();
			signedBy=masEmployee.getFirstName();
			if(masEmployee.getMiddleName()!=null){
				signedBy=signedBy+" "+masEmployee.getMiddleName();
			}
			if(masEmployee.getLastName()!=null){
				signedBy=signedBy+" "+masEmployee.getLastName();
			}
		}
	}
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
<%---
<div>
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" onClick="submitForm('mbOpinionForm16','opd?method=showPatientPreviousVisitForViewScreen&link=medicalExam&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>');" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" class="buttonBig2" onClick="submitForm('mbOpinionForm16','medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>');" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" class="buttonBig2" onClick="submitForm('mbOpinionForm16','medicalExam?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo() %>');" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onClick="submitForm('mbOpinionForm16','opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>');" />
</div>
--%>
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
<h2>AFMSF 16 </h2>
</div>
<div class="clear"></div>
<form name="mbOpinionForm16" action="" method="post">
<!--Block One Starts-->
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
<input type="hidden" name="medExamId" value="<%=medExamId %>" id="medExamId"/>
<input type="hidden" name="visitId" value="<%=visitId %>" id="visitId"/>
<input type="hidden" name="<%=HIN_ID%>" value="<%=hinId %>" id="hinId"/>

<div class="clear"></div>
<div class="Block">
<label>Authority for Board</label>
 <%
 String authority="";
 if(medExamObj.getAuthority()!=null){
 authority=medExamObj.getAuthority();
 }%>
<input tabindex="1" type="text"  name="<%=AUTHORITY_OF_BOARD %>" maxlength="100" value="<%=authority %>"
	onKeyUp="limitText(this,100);" readonly="readonly" />

 <%if(session.getAttribute("hospitalName")!=null){ %>
<label>Place </label>
<input tabindex="1" type="text" maxlength="20"  id="" name="<%=PLACE %>" class="auto" size="50" value="<%=((String)session.getAttribute("hospitalName")) %>"
	onKeyUp="limitText(this,20);" readonly="readonly" />
<%}%>
<div class="clear"></div>
<label>Date Of Discharge</label>
<%if(medExamObj.getDateOfDischarge() !=null){ %>
<input tabindex="1" type="text"	name="dateOfDischarge" class="" maxlength="10"  size="27" 
 value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfDischarge()) %>" readonly="readonly" />
<%}else{ %>
 <input tabindex="1" type="text"	name="dateOfDischarge"  maxlength="10"  class="auto"
 value="<%=date %>" validate="Discharge Date,date,no" readonly="readonly"/>
<%} %>
	<label>Date</label>
<%if(medExamObj.getId()==null)
{ %>
	 <input tabindex="1" type="text"	readonly="readonly"  name="<%=REPORTED_DATE %>"  maxlength="10"  
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
		validate="Reported Date,date,no" />
<% }else if(medExamObj.getDateOfReporting() !=null){%>
	 <input tabindex="1" type="text"	readonly="readonly"  name="<%=REPORTED_DATE %>" maxlength="10" disabled="disabled"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfReporting()) %>"
		validate="Reported Date,date,no" />

<% }else{%>
 <input tabindex="1" type="text"  readonly="readonly"	name="<%=REPORTED_DATE %>"  maxlength="10"  class="auto"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
		validate="Reported Date,date,no" />
<%} %>

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
		class="calender" onclick="setdate('',mbOpinionForm16.<%=REPORTED_DATE%>,event);" />
<div class="clear"></div>
  <label> Date of Release  </label>
  <input tabindex="1" name="<%=DATE_OF_RELEASE %>" class="date" value="<%=date %>"
	validate="Date of Release,date,no" maxlength="10"  onKeyUp="mask(this.value,this,'2,5','/');" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
 class="calender" onclick="setdate('',mbOpinionForm16.<%=DATE_OF_RELEASE%>,event);" />
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
<% 
if(dgOrderhd!=null)
{
%>
<input type="hidden" value="<%=dgOrderhd.getId() %>" name="dgOrderhdId" id="dgOrderhdId" />
<input type="hidden" value="<%=dgOrderhd.getOrderNo() %>" name="dgOrderhdOrderNo" id="dgOrderhdOrderNo" />
<%
}else{ %>
<input type="hidden"  name="dgOrderhdId" id="dgOrderhdId" />
<input type="hidden" value="" name="dgOrderhdOrderNo" id="dgOrderhdOrderNo" />
<% }%>
 <input type="text" value="<%=sPersonName %>" readonly="readonly" name="<%=FULL_NAME%>"	tabindex="2" readonly="readonly"  />

<label>Service No. </label>
<input type="hidden"  name="medicalType" id="medicalType" value="<%=medExamObj.getMedicalType() %>"/>
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
 <input	type="text"  name="<%=TRADE%>"	readonly="readonly" tabindex="2" value="<%= visit.getHin().getTrade().getTradeName() %>" maxlength= />
  <input	type="hidden"  name="<%=TRADE_ID%>"	tabindex="2" value="<%= visit.getHin().getTrade().getId() %>" maxlength="20" />

<% }else{%>
 <input	type="text"  name="<%=TRADE%>"	tabindex="2" readonly="readonly"/>

 <% }%>
 <label>Total Service  </label>
  <%if(visit.getHin().getServiceYears()!=null)
 { %>
 <input	type="text" readonly="readonly" value="<%= visit.getHin().getServiceYears() %>" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" />
 <% }else{%>
 <input	type="text" value="" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" readonly="readonly"/>
 <% }%>

 <label> DOB </label>
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
 <!-- Code By Dipali -->
 <%if(medExamObj.getHoursOfFlown()!=null)
 { %>
 <input	type="text" readonly="readonly" value="<%=medExamObj.getHoursOfFlown() %>" name="<%=HOURS_OF_FLOWN%>"	maxlength="100" tabindex="1" onKeyUp="mask(this.value,this,'2',':');" onBlur="checkTime('medicalBoardMOForm16','<%=HOURS_OF_FLOWN%>');"/>
 <% }else{%>
 <input	type="text" value="" name="<%=HOURS_OF_FLOWN%>"	maxlength="100" tabindex="1" onKeyUp="mask(this.value,this,'2',':');" onBlur="checkTime('medicalBoardMOForm16','<%=HOURS_OF_FLOWN%>');"/>
 <% }%>

 <label >DOC/DOE</label>
  <%if(visit.getHin().getCommissionDate()!=null)
 { %>
 <input	tabindex="2" readonly="readonly" name="<%=DATE_COMMENCEMENT %>"   value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getCommissionDate()) %>"	readonly="readonly"/>
 <% }else{%>
 <input	tabindex="2" name="<%=DATE_COMMENCEMENT %>"  value="<%=date %>"	readonly="readonly"/>

 <% }%>
  <label >Permanent Address</label>
 <%String permaAddress="";
if(medExamObj.getParmanentAddress() !=null){
	permaAddress=medExamObj.getParmanentAddress();}%>
<textarea rows="" cols=""  class="medium" name="<%=PERMANENT_ADDRESS %>" class="large" readonly="readonly" >
<%=permaAddress %></textarea>

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
<label class="valueAuto">1</label>
<input tabindex="1" type="text" readonly="readonly" id="<%=IDENTIFICATION_MARKS1 %>" name="<%=IDENTIFICATION_MARKS1 %>" maxlength="6"
	 value="<%=identification1%>"	class="auto" size="50"  />
<div class="clear"></div>
<input class="transparent" size="28">
<label class="valueAuto">2</label>
<input tabindex="1" type="text" id="<%=IDENTIFICATION_MARKS2 %>" name="<%=IDENTIFICATION_MARKS2 %>"
 value="<%=identification2%>"	readonly="readonly" class="auto" size="50"  />
</div>

<div class="smallest floatRight">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridDisability">
	<tr>
<th scope="col">Disability</th>
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
		incDisability=incDisability+1;
		int icdId=0;
		String icdCd="";
		if(masMedicalExamDetails.getMasIcd()!=null){
			icdId=masMedicalExamDetails.getMasIcd().getId();
			icdCd=masMedicalExamDetails.getMasIcd().getIcdCode();
		}
		String disabilityStr="";
		disabilityStr=masMedicalExamDetails.getPrincipal()+"["+icdCd+"]";
	%>
	<tr>
<td>
<!-- <input name="disability" id="Disability" type="text"  value="" tabindex="1" class="auto" size="50"/> -->

<input 	name="systemDiagnosis<%=incDisability %>" value="<%=disabilityStr %>"	id="systemDiagnosis1" tabindex="1" class="auto" size="50" onblur="" readonly="readonly"/>
</td>
<input type="hidden" name="hdbDisability" value="<%=incDisability%>" id="hdbDisability" />
</tr>
	<%
	}
}
%>
<%
}
if(incDisability <=0){
incDisability=1;%>
<tr>
<td>
<!-- <input name="disability" id="Disability" type="text"  value="" tabindex="1" class="auto" size="50"/> -->

<input 	name="systemDiagnosis<%=incDisability %>" value=""	id="systemDiagnosis1" tabindex="1" class="auto" size="50" onblur="" readonly="readonly" readonly="readonly"/>
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
<TH scope="col">Sl. No.</TH>
<TH scope="col">From</TH>
<TH scope="col">To</TH>
<TH scope="col">Place</TH>
<TH>P/F</TH>
</tr>
<% int inc1=0;
/*
if(medExamObj.getMasmedicaldetail()!=null)
{
	for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
*/
if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
{
for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationDetailList){

		if(masMedicalExamDetails.getParticular()!=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("detail1"))
	{

		inc1=inc1+1;
	%>

<tr>
<% if(masMedicalExamDetails.getSerialno()!=null){%>
<td><input type="text" readonly="readonly" name="<%=SIRIAL_NO+inc1 %>" maxlength="10" value="<%=masMedicalExamDetails.getSerialno() %>" tabindex="1" size="2"/></td>
<% }else{%>
<td><input type="text" readonly="readonly" name="<%=SIRIAL_NO+inc1 %>" maxlength="10" tabindex="1" size="2"/></td>

<% }%>
<% if(masMedicalExamDetails.getAddressfrom()!=null)
{
%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=FROM+inc1 %>" maxlength="10" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getAddressfrom()) %>"/></td>
<% }else{
%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=FROM+inc1 %>" maxlength="10" />
<% }%>
</td>
<% if(masMedicalExamDetails.getAddressto()!=null ){%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=TO+inc1 %>" maxlength="10" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getAddressto()) %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=TO+inc1 %>" maxlength="10" />
</td>
<% }%>
<% if(masMedicalExamDetails.getPlace()!=null && ! masMedicalExamDetails.getPlace().equalsIgnoreCase("null")){%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PLACE+inc1 %>" maxlength="10" value="<%=masMedicalExamDetails.getPlace() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1 %>" maxlength="10" readonly="readonly" /></td>
<% }%>
<% 
String pf_no="";
if(masMedicalExamDetails.getPno()!=null && ! masMedicalExamDetails.getPno().equalsIgnoreCase("null")){
	pf_no=masMedicalExamDetails.getPno();
}
%>
<td width="10%">
<select name="<%=P_NO+inc1 %>" id="<%=P_NO+inc1 %>" validate="P/F,string,no" disabled="disabled">
<option value="">select</option>
<option value="Peace">Peace</option>
<option value="Field">Field</option>
<option value="MFA">MFA</option>
</select>

<script type="text/javascript">
document.getElementById('<%=P_NO+inc1 %>').value ='<%=pf_no%>';
</script>
</td>
</tr>
<input type=hidden name="<%=SERVICEID+inc1 %>" value="<%=masMedicalExamDetails.getServiceid()%>" id="serviceId" />
<%
	}
}}if(inc1<=0){
	//mbOpinionForm16.out.println("this is else jsp");
inc1=1;%>
<tr>


<td width="10%"><input tabindex="1"  type="text" readonly="readonly" name="<%=SIRIAL_NO+inc1 %>" value=<%=inc1%> maxlength="10" /></td>
<td width="10%">
<input tabindex="1" type="text" readonly="readonly"	name="<%=FROM+inc1 %>" maxlength="10" />
</td>
<td width="10%"><input tabindex="1" type="text" readonly="readonly"	name="<%=TO+inc1 %>" maxlength="10" />
</td>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1 %>" maxlength="10" readonly="readonly"/></td>
<td width="10%">
<select name="<%=P_NO+inc1 %>" id="<%=P_NO+inc1 %>" validate="P/F,string,no" disabled="disabled">
<option value="">select</option>
<option value="Peace">Peace</option>
<option value="Field">Field</option>
<option value="MFA">MFA</option>
</select>
</td>

</tr>

<% }%>
<input type="hidden" name="hdb" value="<%=inc1%>" id="hdb" />

</table>

</div>
<div class="clear"></div>


<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>Disease,Wound or Injures Details<a href="javascript:animatedcollapse.toggle('slide3')"></a></h4>
<div class="clear"></div>
<div id="slide3">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid1">
	<tr>
<th scope="col" rowspan="2">Sl No.</th>
<th rowspan="2" scope="col">Illness/Wound/Injury</th>
<th colspan="1" rowspan="2" scope="col">First Started on</th>
<th rowspan="2" scope="col">First Started at</th>
<th rowspan="2">Where Treated</th>
<th colspan="2" >Approximate Dates and Periods Treated</th>
</tr>
	<tr>
<TH>From</TH>
<th>To</th>
</tr>
<% int inc11=0;
/*
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	*/
	if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
	{
	for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationDetailList){
	
	//if(masMedicalExamDetails.getParticular()!=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("particular")){
		if(masMedicalExamDetails.getParticular()!=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("particular") && masMedicalExamDetails.getBeforeDisability().equalsIgnoreCase("n")){
		inc11=inc11+1;
	%>

<TR>

 <% if(masMedicalExamDetails.getSerialNo1()!=null){%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly"	name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" value="<%=masMedicalExamDetails.getSerialNo1() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly" name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" /></td>
 <% }%>
 <% if(masMedicalExamDetails.getIllness()!=null){
	 int icdId=0;
		String icdCd="";
		if(masMedicalExamDetails.getMasIcd()!=null){
			icdId=masMedicalExamDetails.getMasIcd().getId();
			icdCd=masMedicalExamDetails.getMasIcd().getIcdCode();
		}
		String disabilityStr="";
		disabilityStr=masMedicalExamDetails.getIllness()+"["+icdCd+"]";
 %>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly"  name="<%=ILLNESS+inc11 %>" maxlength="10" size="35" value="<%=disabilityStr%>"/></td>
  <% }else{%>

<td width="10%"><input tabindex="1" type="text"	readonly="readonly"  name="<%=ILLNESS+inc11 %>" maxlength="10" size="35"/></td>
 <% }%>
<td width="10%">
 <% if(masMedicalExamDetails.getParticulardate()!=null){%>
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" class="date" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getParticulardate())%>"
	validate="DOB,date,no" maxlength="10" id="particulardate"
	onKeyUp="mask(this.value,this,'2,5','/');" />
  <% }else{%>
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" class="date" 	validate="DOB,date,no" maxlength="10" id="particulardate" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }%>
 </td>

 <% if(masMedicalExamDetails.getPlace1()!=null){%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=PLACE1+inc11 %>" maxlength="10" value="<%=masMedicalExamDetails.getPlace1()%>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="10" readonly="readonly"  /></td>
 <% }%>

 <% if(masMedicalExamDetails.getTreated()!=null){%>
    <td width="10%"><input tabindex="1" type="text"	readonly="readonly"  name="<%=TREATED+inc11 %>" maxlength="10" value="<%=masMedicalExamDetails.getTreated() %>"/></td>
  <% }else{%>
    <td width="10%"><input tabindex="1" type="text"	readonly="readonly"  name="<%=TREATED+inc11 %>" maxlength="10" /></td>
 <% }%>

<td width="20%">
 <% if(masMedicalExamDetails.getApproximatedate1()!=null){  %>
<input type="text"	readonly="readonly" tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" size="11" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getApproximatedate1())%>"	validate="DOB,String,no" maxlength="30"
	 />
  <% }else{%>
<input  type="text"	readonly="readonly"  tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" size="11"	validate="Approximate Dates From,String,no" maxlength="30" />
 <% }%>
  </td>
<td width="20%">
 <% if(masMedicalExamDetails.getApproximatedate2()!=null){  %>
<input type="text"	readonly="readonly" tabindex="1" name="<%=APPROXIMATE_DATE2+inc11 %>" id="approximatedate2" size="11" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getApproximatedate2())%>"	validate="DOB,String,no" maxlength="30"
	 />
  <% }else{%>
<input  type="text"	readonly="readonly"  tabindex="1" name="<%=APPROXIMATE_DATE2+inc11 %>" id="approximatedate2" size="11"	validate="Approximate Dates To,String,no" maxlength="30" />
 <% }%>
  </td>
</TR>
<input type=hidden name="<%=SERVICEID+inc11 %>" value="<%=masMedicalExamDetails.getServiceid()%>"  />

<%
}}}if(inc11<=0){
inc11=1;%>
<td width="10%"><input tabindex="1" size="2" type="text"	readonly="readonly" name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" value="<%=inc11 %>"/></td>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11 %>" maxlength="10" readonly="readonly"  size="35"/></td>
<td width="10%">
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" class="date" 	validate="Particular Date,date,no" maxlength="10" id="particulardate" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />

</td>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="10" readonly="readonly" /></td>

<td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" maxlength="10" readonly="readonly"  /></td>
<td width="20%">
<input	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" size="11"	validate="Approximate Dates From,String,no" maxlength="30" value=""/>

</td>
<td width="20%">
<input	tabindex="1" name="<%=APPROXIMATE_DATE2+inc11 %>" id="approximatedate2" size="11"	validate="Approximate Dates To,String,no" maxlength="30" value=""/>

</td>
</TR>

<% }%>
<input type="hidden" name="hdb1" value="<%=inc11%>" id="hdb1" />
</table>
</div>
	</div>
<!--Block Four Ends-->
<div class="clear paddingTop15"></div>
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
	displayStyle="none";
}
%>
<div class="Block">
<label class="large2">Did you suffer from any disability before joining the Armed Forces </label>
<select name="<%=DISABILITY_BEFORE%>" tabindex="1" id="<%=DISABILITY_BEFORE%>" class="small" disabled="disabled">
	<option value="">Select</option>
	<%if(displayValue.equalsIgnoreCase("y")){ %>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%}else if(displayValue.equalsIgnoreCase("n")){ %>
	<option value="y">Yes</option>
	<option value="n" selected="selected">No</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<option value="n">No</option>
	<%} %>
</select>
<%-- 
<script type="text/javascript">
document.getElementById('disabilitybefore').value ='<%=displayValue%>';
</script>
--%>
</div>
<div class="clear"></div>

<!--If yes then below details and dates option will appear (By Anshu)-->

<div class="cmntable" id="beforeDisabilityDiv" style="display: <%=displayStyle%>;" >
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridIllness">
	<tr>
<th scope="col" rowspan="">S.No.</th>
<th scope="col">Illness/Wound/Injury Details</th>
<th scope="col">First Started on</th>
<th scope="col">First Started at</th>
<th scope="col">Where Treated</th>
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
 <% if(masMedicalExamDetails.getIllness()!=null){
 int icdId=0;
		String icdCd="";
		if(masMedicalExamDetails.getMasIcd()!=null){
			icdId=masMedicalExamDetails.getMasIcd().getId();
			icdCd=masMedicalExamDetails.getMasIcd().getIcdCode();
		}
		String disabilityStr2="";
		disabilityStr2=masMedicalExamDetails.getIllness()+"["+icdCd+"]";%>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS%>1<%=incBefore %>" maxlength="10" size="35" value="<%=disabilityStr2%>" readonly="readonly"/></td>
  <% }else{%>
  
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS%>1<%=incBefore %>" maxlength="10" size="35" readonly="readonly"/></td>
 <% }%>

 <% if(masMedicalExamDetails.getParticulardate()!=null){%>
 <td width="10%">
<input	tabindex="1" name="<%=PARTICULAR_DATE%>1<%=incBefore %>" size="11" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getParticulardate())%>"
	validate="First Started on,date,no" maxlength="10" id="particulardate1<%=incBefore %>"
	onKeyUp="mask(this.value,this,'2,5','/');"  readonly="readonly"/></td>
  <% }else{%><td>
<input	tabindex="1" name="<%=PARTICULAR_DATE%>1<%=incBefore %>" size="11" 	validate="First Started on,date,no" maxlength="10" id="particulardate1<%=incBefore %>" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" readonly="readonly"/>  </td>
 <% }%>

 
 
 <% if(masMedicalExamDetails.getPlace()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1%>1<%=incBefore %>" maxlength="10" value="<%=masMedicalExamDetails.getPlace()%>" readonly="readonly"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1%>1<%=incBefore %>" maxlength="10"  readonly="readonly"/></td>
 <% }%>

 <% if(masMedicalExamDetails.getTreated()!=null){%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED%>1<%=incBefore %>" maxlength="10" value="<%=masMedicalExamDetails.getTreated() %>" readonly="readonly"/></td>
  <% }else{%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED%>1<%=incBefore %>" maxlength="10"  readonly="readonly"/></td>
 <% }%>
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
<td width="10%"><input tabindex="1" size="2" type="text"	readonly="readonly" name="<%=SIRIAL_NO1%>1<%=incBefore %>" maxlength="3" value="<%=incBefore %>"/></td>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS%>1<%=incBefore %>" maxlength="10" /></td>
<td width="10%">
<input	tabindex="1" name="<%=PARTICULAR_DATE%>1<%=incBefore %>" size="11" 	validate="First Started on,date,no" maxlength="10" id="particulardate1<%=incBefore %>" value="<%=date %>"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 

</td>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1%>1<%=incBefore %>" maxlength="10" /></td>

<td width="10%"><input tabindex="1" type="text"	name="<%=TREATED%>1<%=incBefore%>" maxlength="10" /></td>
<input type=hidden name="beforeDisability1<%=incBefore %>" id="beforeDisability1<%=incBefore %>" value="y"/>
</TR>

<% }%>
<input type="hidden" name="hdbBefore" value="<%=incBefore%>" id="hdbBefore" />
</table>
</div>


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
	String medBoardHeld="";
	if(medExamObj.getMedBoardHeld()!= null){
		medBoardHeld=medExamObj.getMedBoardHeld();
	}
	String injuryReport="";
	if(medExamObj.getInjuryReport()!= null){
		injuryReport=medExamObj.getInjuryReport();
	}
%>


</script>
<label class="large2">Details of any incidents during your service which you think caused/made your disability worse</label>
<textarea readonly="readonly" name="incidents_during_your_service" id="incidents_during_your_service" rows="" cols="" class="large"><%=incidentsDuringYourService%></textarea>

<div class="clear"></div>
<label class="large2">In case of wound/injury, state how they happened</label>
<textarea rows="" cols="" name="<%=REASON_WOUND_INJURY%>" id="<%=REASON_WOUND_INJURY%>" readonly="readonly"   class="large"><%=reasonWoundInjury%></textarea>
<div class="clear"></div>
<label class="large2">Med Board/ Court of inquiry was held</label>
<select name="MED_BOARD_HELD" id="MED_BOARD_HELD" class="small" disabled="disabled">
<option value="y">Yes</option>
<option value="n">No</option>
</select>
<script type="text/javascript">
document.mbOpinionForm16.MED_BOARD_HELD.value='<%=medBoardHeld%>';
</script>
<input class="transparent" size="1" />
<label>Injury Report</label>
<select name="INJURY_REPORT" id="INJURY_REPORT" disabled="disabled">
<option value="Submitted">Submitted</option>
<option value="Not Submitted">Not Submitted</option>
</select>
<script type="text/javascript">
document.mbOpinionForm16.INJURY_REPORT.value='<%=injuryReport%>';
</script>
<div class="clear"></div>
<label class="large2">Any other health information</label>

<% if(medExamObj.getAnyOtherInformationAboutYourHealth()!=null){%>
<textarea rows="" cols="71" class="large"  readonly="readonly" 	name="<%=OTHER_INFORMATION %>" class="large" onkeyup="chkLength(this,100);" ><%=medExamObj.getAnyOtherInformationAboutYourHealth() %></textarea>
 <% }else{%>
<textarea rows="" cols="71" class="large" readonly="readonly" 	name="<%=OTHER_INFORMATION %>" class="large" onkeyup="chkLength(this,100);" ></textarea>
 <% }%>

 <div class="clear"></div>

</div>

<div class="clear paddingTop15"></div>
<h4>Individual Details</h4>
<div class="Block">
<%
String individualSign="";
if(medExamObj.getIndividualDigitalSign() !=null){
individualSign=medExamObj.getIndividualDigitalSign();}%>
<label>Signature of Individual</label>
 <input type="text" disabled="disabled"  value="" name="<%=SIGN%>" id="<%=SIGN%>" maxlength="30" value="<%=individualSign %>"/>

 <label>Service No.</label>
 <input type="text" value="<%=service_no%>" name="<%=SIGN%>" id="<%=SIGN%>" readonly="readonly" />

  <label>Rank</label>
 <input type="text" value="<%=rank %>" name="<%=SIGN%>" id="<%=SIGN%>"  readonly="readonly"  />

 <label>Date</label>
 <input type="text" readonly="readonly" name="<%=SIGN_DATE%>" value="<%=date%>" tabindex="2" maxlength="20" size="11" readonly="readonly" />

</div>
<div class="clear paddingTop15"></div>

<input type="hidden" name="viewMedExamDetails" value="View Med Exam Details" class="buttonBig2" onClick="openPopupForMedExamDetail(<%=medExamId %>,<%=visitId %>);"/>
<input name="Button" type="hidden" class="buttonBig" value="Clinical Summary"	onClick="openPopupForClinicalSummary(<%=medExamId %>,<%=visitId %>);" tabindex="1" />
<input name="Button" type="button" class="buttonBig" value="Commanding Officer" onClick="openPopupForCommandingOfficer();" tabindex="1" />
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="View Specialist Opinion"	onClick="openPopupForSpecialistOpinion();" />
<div class="clear paddingTop15"></div>
<h4>Chronological List of the Disabilities <a href="javascript:animatedcollapse.toggle('slide14')"></a></h4>
<div class="clear"></div>
<div id="slide14">

	<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridIcdDisability">
	<tr>
		<th rowspan="2">Disability</TH>
		<TH rowspan="2">Date of Origin</TH>
		<TH rowspan="2">Rank of Indl</TH>
		<TH>Place</TH>
		<TH>Unit</TH>
		<th rowspan="2">Add</th>
		<th rowspan="2">Delete</th>
	</tr>

	<tr>
		<th colspan="2">Where Serving at the Time</th>
	</tr>
	<% int inc=0;
	if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
	{
	for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationDetailList){
	if(masMedicalExamDetails.getPrincipal()!=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("Cronical")){
		
			inc=inc+1;
		//	int icdDisability=0;
		int icdId=0;
			String icdDisCode="";
			String dateOfOrigin="";
			int rankDisablilty=0;
			String placeServing="";
			int unitDisablilty=0;
		//	icdDisability=masMedicalExamDetails.getPrincipal();
		//	if(masMedicalExamDetails.getSystemDiagnosis()!=null){
				icdId=masMedicalExamDetails.getMasIcd().getId();
				//icdDisability=masMedicalExamDetails.getSystemDiagnosis().getId();
				icdDisCode=masMedicalExamDetails.getMasIcd().getIcdCode();
			String disabilityStr="";
			disabilityStr=masMedicalExamDetails.getPrincipal()+"["+icdDisCode+"]"+"["+icdId+"]";
			if(masMedicalExamDetails.getOrigindate()!=null){
				dateOfOrigin=HMSUtil.convertDateToStringTypeDateOnly(masMedicalExamDetails.getOrigindate());
			}
			if(masMedicalExamDetails.getRankDisability()!=null){
				rankDisablilty=masMedicalExamDetails.getRankDisability().getId();
			}
			if(masMedicalExamDetails.getUnitDisability()!=null){
				unitDisablilty=masMedicalExamDetails.getUnitDisability().getId();
			}
			if(masMedicalExamDetails.getPlaceDisability()!=null){
				placeServing=masMedicalExamDetails.getPlaceDisability();
			}
	%>
<tr>
<td>
<input type="text" tabindex="1"	value="<%=disabilityStr%>" id="icdDisability<%=inc %>"   name="icdDisability<%=inc %>"	class="auto"  size="50" />
<input type="hidden" name="disablementServiceIdCronical<%=inc%>" value="<%=masMedicalExamDetails.getServiceid() %>" tabindex="1" readonly="readonly" />
<%--<div id="ac2update1"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icdDisability<%=inc%>','ac2update1','opd?method=getICDForIdList',{parameters:'requiredField=icdDisability'});
</script> --%>
	</td>
		<td>
			<input tabindex="1"  type="text" value="<%=dateOfOrigin%>" name="<%=DATE_OF_ORIGIN+inc %>" maxlength="10" class="auto" size="11" id="dateOfOrigin<%=inc %>"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',mbOpinionForm16.<%=DATE_OF_ORIGIN+inc%>,event);" />
		</td>
		<td><select name="rankDisablilty<%=inc%>" id="rankDisablilty<%=inc%>" tabindex="1">
			<option value="0">Select</option>
		<% 	for (MasRank masRank : masRankList) { %>
				<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
		<%	}%>
			</select>
<script type="text/javascript">
document.mbOpinionForm16.rankDisablilty<%=inc%>.value='<%=rankDisablilty%>';
</script>
		</td>
		<td>
		<input tabindex="1"  type="text" value="<%=placeServing%>" name="placeServing<%=inc%>" id="placeServing<%=inc%>" maxlength="10" />
		</td>
		<td><select name="unitDisablilty<%=inc%>" id="unitDisablilty<%=inc%>" tabindex="1">
			<option value="0">Select</option>
		<% 	for (MasUnit masUnit : masUnitList) {%>
					<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
		<%}%>
			</select>
				<script type="text/javascript">
document.mbOpinionForm16.unitDisablilty<%=inc%>.value='<%=unitDisablilty%>';
</script>
		</td>
		<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRowIcdDisability();" tabindex="1" />
		</td>
		<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('gridIcdDisability','hdbIcdCronicalDisability',this);" tabindex="1" />
		</td>
	</tr>
	<%
	}
	}
	}
	if(inc<=0){
	++inc;
	
	%>
<tr>
<td>
<input type="text" tabindex="1"	value="" id="icdDisability<%=inc %>"  name="icdDisability<%=inc %>"	class="auto"  size="50" />
<input type="hidden" name="disablementServiceIdCronical<%=inc%>" value="0" tabindex="1" readonly="readonly" />
<%--<div id="ac2update1"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icdDisability<%=inc%>','ac2update1','opd?method=getICDForIdList',{parameters:'requiredField=icdDisability'});
</script> --%>
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icdDisability<%=inc%>','ac2update','medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=icdDisability<%=inc%>'});
		</script>
	</td>
		<td>
			<input tabindex="1"  type="text"	name="<%=DATE_OF_ORIGIN+inc %>" maxlength="10" class="auto" size="11" id="dateOfOrigin<%=inc %>"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',mbOpinionForm16.<%=DATE_OF_ORIGIN+inc%>,event);" />
		</td>
		<td><select name="rankDisablilty<%=inc%>" id="rankDisablilty<%=inc%>" tabindex="1">
			<option value="0">Select</option>
		<% 	for (MasRank masRank : masRankList) { %>
				<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
		<%	}%>
			</select>
		</td>
		<td>
		<input tabindex="1"  type="text" name="placeServing<%=inc%>" id="placeServing<%=inc%>" maxlength="10" />
		</td>
		<td><select name="unitDisablilty<%=inc%>" id="unitDisablilty<%=inc%>" tabindex="1">
			<option value="0">Select</option>
		<% 	for (MasUnit masUnit : masUnitList) {%>
					<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
		<%}%>
			</select>
		</td>
		<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRowIcdDisability();" tabindex="1" />
		</td>
		<td>
			
		</td>
	</tr>
	<%
	}
%>
		<input type="hidden" name="hdbIcdCronicalDisability" value="<%=inc%>" id="hdbIcdCronicalDisability" />
</table>
</div>

<script type="text/javascript">
var unitDisablilty=new Array();
var rankDisablilty=new Array();
</script>
<%
int unitCnt=0;
for (MasUnit masUnit : masUnitList) {
     			 %> <script>

     			unitDisablilty[<%=unitCnt%>]= new Array();
     			unitDisablilty[<%=unitCnt%>][0] = "<%=masUnit.getId()%>";
     			unitDisablilty[<%=unitCnt%>][1] = "<%=masUnit.getUnitName()%>";
            </script> <%
++unitCnt;
}
            int rankCnt=0;
            for (MasRank masRank : masRankList) {
                 			 %> <script>

                 			rankDisablilty[<%=rankCnt%>]= new Array();
                 			rankDisablilty[<%=rankCnt%>][0] = "<%=masRank.getId()%>";
                 			rankDisablilty[<%=rankCnt%>][1] = "<%=masRank.getRankName()%>";
                        </script> <%
            ++rankCnt;
}%>

<div class="clear paddingTop15"></div>
<h4>Clinical Details</h4>
<div class="clear paddingTop15"></div>

<div class="Block">

<label>Relevant Family History</label>
<%
	String releventFamHis="";
	String specialistReport="";
	String treatment="";
	if(medExamObj.getRelevantFamilyHistory() !=null){
		releventFamHis=medExamObj.getRelevantFamilyHistory();
	}
	if(medExamObj.getSpecialistReport() !=null){
		specialistReport=medExamObj.getSpecialistReport();
	}
	if(medExamObj.getTreatment() !=null){
		treatment=medExamObj.getTreatment();
	}
%>
<input type="text" name="<%=RELEVENT_FAMILY_HISTORY %>" VALUE="<%=releventFamHis %>" maxlength="100"/>

<label>Specialist Report</label>
<input type="text" name="<%=SPECIALIST_REPORT %>" VALUE="<%=specialistReport %>" maxlength="50"/>

<div class="clear"></div>

<label>Treatment</label>
<input type="text" name="<%=TREATMENT%>" VALUE="<%=treatment %>" maxlength="50"/>

<label>Present Condition</label>
<%String presentConds="";
if(medExamObj.getPresentCondition() !=null){
	presentConds=medExamObj.getPresentCondition();}%>
<input type="text" name="presentCondition" value="<%=presentConds%>"/>

</div>

<div class="clear paddingTop15"></div>
<h4>Casual Relationship of the Disability with Service Conditions or Otherwise</h4>
<div class="clear paddingTop15"></div>

<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

<tr>
<th rowspan="2">Disability</th>
<th rowspan="2">Attributable to Service</th>
<th rowspan="2">Aggravated by Service</th>
<th rowspan="2">Not Connected with Service</th>
<th rowspan="2">Reason/Cause/Specific Condition</th>
<th colspan="2">Period in Service</th>
</tr>

<tr>
<th>From</th>
<th>To</th>
</tr>

<% 
int incDisability2=0;
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
			incDisability2=incDisability2+1;
			String reasonCause="";
			//	Date
			String fromServicePeriod="";
			String toServicePeriod="";
			if(masMedicalExamDetails.getReasonVariation()!=null){
				reasonCause=masMedicalExamDetails.getReasonVariation();
			}
			if(masMedicalExamDetails.getFromServicePeriod()!=null){
				fromServicePeriod=masMedicalExamDetails.getFromServicePeriod();
			}
			if(masMedicalExamDetails.getToServicePeriod()!=null){
				toServicePeriod=masMedicalExamDetails.getToServicePeriod();
			}
	%>
<tr>
<td>
<input type="text" name="disabilityService<%=incDisability2%>" value="<%=masMedicalExamDetails.getPrincipal() %>"	id="disabilityService"<%=incDisability2%> tabindex="1" class="auto" size="35" readonly="readonly"/>
<input type="hidden" name="disabilityServiceId<%=incDisability2%>" value="<%=masMedicalExamDetails.getServiceid() %>"	id="disabilityServiceId<%=incDisability2%>" tabindex="1" /></td>

<td><select name="attributService<%=incDisability2%>" id="attributService<%=incDisability2%>">
<option value="n">No</option><option value="y">Yes</option>
</select></td>
<script type="text/javascript">
document.mbOpinionForm16.attributService<%=incDisability2%>.value='<%=masMedicalExamDetails.getAttributeService()%>';
</script>
<td><select name="aggravateService<%=incDisability2%>" id="aggravateService<%=incDisability2%>">
<option value="n">No</option><option value="y">Yes</option></select></td>
<script type="text/javascript">
document.mbOpinionForm16.aggravateService<%=incDisability2%>.value='<%=masMedicalExamDetails.getAggravarteService()%>';
</script>
<td><select name="notConnectedService<%=incDisability2%>" id="notConnectedService<%=incDisability2%>">
<option value="n">No</option><option value="y">Yes</option></select></td>

<script type="text/javascript">
document.mbOpinionForm16.notConnectedService<%=incDisability2%>.value='<%=masMedicalExamDetails.getNotConnectService()%>';
</script>
<td><input type="text" name="reasonCause<%=incDisability2%>" maxlength="49" value="<%=reasonCause%>"/></td>
<td><input type="text" name="fromServicePeriod<%=incDisability2%>" value="<%=fromServicePeriod%>" maxlength="12" class="date" class="auto" size="11" tabindex="1"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',mbOpinionForm16.fromServicePeriod<%=incDisability2 %>,event);" /></td>
<td><input type="text" name="toServicePeriod<%=incDisability2%>" value="<%=toServicePeriod%>" maxlength="12" class="date" class="auto" size="11" tabindex="1"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',mbOpinionForm16.toServicePeriod<%=incDisability2%>,event);" /></td>
</tr>
<%}}}if(incDisability2<=0){
	++incDisability2;%>
	<tr>
<td>
<input type="text" name="disabilityService<%=incDisability2%>" value=""	id="disabilityService"<%=incDisability2%> tabindex="1" class="auto" size="35" readonly="readonly"/>
<input type="hidden" name="disabilityServiceId<%=incDisability2%>" value="" id="disabilityServiceId<%=incDisability2%>" tabindex="1" /></td>

<td><select name="attributService<%=incDisability2%>" id="attributService<%=incDisability2%>">
<option value="n">No</option><option value="y">Yes</option>
</select></td>
<td><select name="aggravateService<%=incDisability2%>" id="aggravateService<%=incDisability2%>">
<option value="n">No</option><option value="y">Yes</option></select></td>
<td><select name="notConnectedService<%=incDisability2%>" id="notConnectedService<%=incDisability2%>">
<option value="n">No</option><option value="y">Yes</option></select></td>
<td><input type="text" name="reasonCause<%=incDisability2%>" maxlength="49" value=""/></td>
<td><input type="text" name="fromServicePeriod<%=incDisability2%>" value="" maxlength="12" class="date" class="auto" size="11" tabindex="1"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',mbOpinionForm16.fromServicePeriod<%=incDisability2 %>,event);" /></td>
<td><input type="text" name="toServicePeriod<%=incDisability2%>" value="" maxlength="12" class="date" class="auto" size="11" tabindex="1"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',mbOpinionForm16.toServicePeriod<%=incDisability2%>,event);" /></td>
</tr>

<%} %>
<input type="hidden" name="hdbDisabilityService" value="<%=incDisability2%>" id="hdbDisabilityService" />
</table>
</div>
<div class="clear paddingTop15"></div>
<div class="clear paddingTop15"></div>

<div class="Block">
<%
String	existDisability="";
String	routineMedExam="";
String	persistMaterialPeriod="";
String	aggravMaterialPeriod="";
String	individualMisconduct="";
String	inWay="";
if(medExamObj.getDisabilitybefore()!=null){
	existDisability=medExamObj.getDisabilitybefore();
}
if(medExamObj.getMedExamCarryTime()!=null){
	routineMedExam=medExamObj.getMedExamCarryTime();
}
if(medExamObj.getDisableAggravPersist()!=null){
	persistMaterialPeriod=medExamObj.getDisableAggravPersist();
}
if(medExamObj.getAggravMaterialPeriod()!=null){
	aggravMaterialPeriod=medExamObj.getAggravMaterialPeriod();
}
if(medExamObj.getIndividualMisconduct()!=null){
	individualMisconduct=medExamObj.getIndividualMisconduct();
}
if(medExamObj.getInWay()!=null){
	inWay=medExamObj.getInWay();
}
String	aggravatedMisconduct="";
String	inWay2="";
String	totalDisablement="";
String	refuseOperationTreat="";
String	individualReason="";
String	reducDisablePension="";

if(medExamObj.getAggravatedMisconduct()!=null){
	aggravatedMisconduct=medExamObj.getAggravatedMisconduct();
}
if(medExamObj.getInWay2()!=null){
	inWay2=medExamObj.getInWay2();
}
if(medExamObj.getPercentageDisable()!=null){
	totalDisablement=medExamObj.getPercentageDisable();
}
if(medExamObj.getRefuseOperationTreat()!=null){
	refuseOperationTreat=medExamObj.getRefuseOperationTreat();
}
if(medExamObj.getIndividualReason()!=null){
	individualReason=medExamObj.getIndividualReason();
}
if(medExamObj.getReductionDisablePension()!=null){
	reducDisablePension=medExamObj.getReductionDisablePension();
}

String	reducDisablePensionEntry="";
String	operationTreatCured="";
String	operationTreatCuredEntry="";
String	percentageDisableTreatment="";
String	individualRefusalTratment="";
String	operaTreatmentRecommend="";

if(medExamObj.getReducDisablePensionEntry()!=null){
	reducDisablePensionEntry=medExamObj.getReducDisablePensionEntry();
}
if(medExamObj.getOperationTreatCured()!=null){
	operationTreatCured=medExamObj.getOperationTreatCured();
}
if(medExamObj.getOpernTreatCuredEntry()!=null){
	operationTreatCuredEntry=medExamObj.getOpernTreatCuredEntry();
}
if(medExamObj.getPercentageDisableTreatment()!=null){
	percentageDisableTreatment=medExamObj.getPercentageDisableTreatment();
}
if(medExamObj.getIndividualRefusalTratment()!=null){
	individualRefusalTratment=medExamObj.getIndividualRefusalTratment();
}
if(medExamObj.getOperaTreatmentRecommend()!=null){
	operaTreatmentRecommend=medExamObj.getOperaTreatmentRecommend();
}
%>
<label class="large3">Did the Disability exist before service</label>
<select id="existDisability" onchange="showHideExistDisability();" name="<%=EXIST_DISABILITY %>">
<option value="">Select</option>
<option value="n">No</option>
<option value="y">Yes</option>
</select>
<script type="text/javascript">
document.mbOpinionForm16.existDisability.value='<%=existDisability%>';
</script>
<%
if(existDisability.equalsIgnoreCase("y"))
{
	%>
	<div id="existDisabilityDiv" style="display: inline;">
  	<%
}else{
	%>
	<div id="existDisabilityDiv" style="display: none;">
  	<%
}
%>
<div class="clear"></div>

<label class="large3">Is it possible that it could not be detected during the routine medical examination carried out at the time of the entry</label>
<select name="<%=ROUTINE_MED_EXAM %>" id="routineMedExam">
<option value="y">Yes</option>
<option value="n">No</option></select>
</div>
<script type="text/javascript">
document.mbOpinionForm16.routineMedExam.value='<%=routineMedExam%>';
</script>
<label class="large3">In case of disability awarded Aggravation, whether the effects of such aggravation will persist</label>
<select name="<%=PERSIST_MATERIAL_PERIOD %>" id="persistMaterialPeriod">
<option value="">Select</option>
<option value="n">No</option>
<option value="y">Yes</option>
</select>
<script type="text/javascript">
document.mbOpinionForm16.persistMaterialPeriod.value='<%=persistMaterialPeriod%>';
</script>
<div class="clear"></div>

<label class="large3">Whether the effects of aggravation will persist for a material period</label>
<select name="<%=AGGRA_MATERIAL_PERIOD %>" id="aggravMaterialPeriod">
<option value="">Select</option>
<option value="y">Yes</option>
<option value="n">No</option>
</select>
<script type="text/javascript">
document.mbOpinionForm16.aggravMaterialPeriod.value='<%=aggravMaterialPeriod%>';
</script>
<div class="clear"></div>

<label class="large3">Was the Disability attributable to the Individual's own negligence or misconduct</label>
<select id="individualMisconduct" onchange="showHideDisabilityAttribute();" name="<%=INDIVIDUAL_MISCONDUCT %>">
<option value="">Select</option>
<option value="n">No</option>
<option value="y">Yes</option>
</select>
<script type="text/javascript">
document.mbOpinionForm16.individualMisconduct.value='<%=individualMisconduct%>';
</script>
<%
if(individualMisconduct.equalsIgnoreCase("y"))
{
	%>
	<div id="disabilityAttributeDiv" style="display: inline;">
  	<%
}else{
	%>
	<div id="disabilityAttributeDiv" style="display: none;">
  	<%
}
%>
<div class="clear"></div>

<label class="large3">In What Way</label>
<input type="text" name="<%=IN_WAY %>" maxlength="50" value="<%=inWay%>" />
</div>

<label class="large3">Was it Aggravated by Negligence of Misconduct</label>
<select id="aggravatedMisconduct" onchange="showHideAggravated();" name="<%=AGGRAVATED_MISCONDUCT %>">
<option value="">Select</option>
<option value="n">No</option>
<option value="y">Yes</option>
</select>
<script type="text/javascript">
document.mbOpinionForm16.aggravatedMisconduct.value='<%=aggravatedMisconduct%>';
</script>
<%
if(aggravatedMisconduct.equalsIgnoreCase("y"))
{
	%>
	<div id="aggravatedMisconductDiv" style="display: inline;">
  	<%
}else{
	%>
	<div id="aggravatedMisconductDiv" style="display: none;">
  	<%
}
%>
<div class="clear"></div>
<label>In What Way</label>
<input type="text" name="<%=IN_WAY2 %>" maxlength="50"  value="<%=inWay2%>" class="autoArial" size="79" />

<label class="auto">Percentage of the Total Disablement</label>
<input type="text" name="<%=TOTAL_DISABLEMENT %>" id="totalDisablement" value="<%=totalDisablement %>" maxlength="9"/>
</div>
<div class="clear"></div>
<label class="large3">Has the Individual refused to undergo Operation/ Treatment</label>
<select id="refuseOperationTreat" onchange="showHideUndergoOperation();" name="<%=REFUSE_OPER_TREATMENT %>">
<option value="">Select</option>
<option value="y">Yes</option>
<option value="n">No</option>
</select>
<script type="text/javascript">
document.mbOpinionForm16.refuseOperationTreat.value='<%=refuseOperationTreat%>';
</script>
<%
if(refuseOperationTreat.equalsIgnoreCase("y"))
{
	%>
	<div id="refuseOperationTreatDiv" style="display: inline;">
  	<%
}else{
	%>
	<div id="refuseOperationTreatDiv" style="display: none;">
  	<%
}
%>
<div class="clear"></div>

<label>Individual's Reason</label>
<input type="text" name="individualReason" value="<%=individualReason%>" class="autoArial" size="123" maxlength="99" />
<input type="button" name="upload" class="buttonBig" value="Upload Certificate" onClick="javascript:fileUploadViewWindow('CER');" />

</div>
<label class="large3">Has the effect of refusal been explained to and fully understood by him/her. Viz, a reduction in, or the entire withholding of any  disability pension to which he/she might otherwise might be entitled</label>
<select id="reducDisablePension" onchange="showHideRefusal();" name="<%=REDUCTION_DISABLE_PENSION %>">
<option value="">Select</option>
<option value="y">Yes</option>
<option value="n">No</option>
</select>

<script type="text/javascript">
document.mbOpinionForm16.reducDisablePension.value='<%=reducDisablePension%>';
</script>
<%
if(reducDisablePension.equalsIgnoreCase("y"))
{
	%>
	<div id="reducDisablePensionDiv" style="display: inline;">
  	<%
}else{
	%>
	<div id="reducDisablePensionDiv" style="display: none;">
  	<%
}
%>
<input type="text" name="<%=REDUC_DISABLE_PENSION_ENTRY %>" value="<%=reducDisablePensionEntry%>" maxlength="50"/>
</div>
<div class="clear"></div>
<label class="large3">Does the Medical Board consider it probable that the Operation/ Treatment would have cured the disability or reduced it's percentage</label>
<select name="<%=OPERATION_TREAT_CURED %>" id="operationTreatCured">
<option value="">Select</option>
<option value="a">Affirmative</option>
<option value="n">Negative</option>
</select>
<script type="text/javascript">
document.mbOpinionForm16.operationTreatCured.value='<%=operationTreatCured%>';
</script>
<input type="text" name="<%=OPERATION_TREAT_CURED_ENTRY %>" maxlength="50" value="<%=operationTreatCuredEntry%>"/>

<label class="large3">What is the probable percentage to which the disablement could be reduced by Operation/ Treatement</label>
<input type="text" name="<%=PERCENTAGE_DISABLE_TREAT %>" value="<%=percentageDisableTreatment %>" maxlength="50"/>

<label class="large3">Does the Medical Board consider individual's refusal to submit to operation/ Treatment reasonable</label>
<select id="individualRefusalTratment" onchange="showHideOperationTreatment();" name="<%=PERCENTAGE_REFUSAL_TREAT %>">
<option value="">Select</option>
<option value="y">Yes</option>
<option value="n">No</option>
</select>
<script type="text/javascript">
document.mbOpinionForm16.individualRefusalTratment.value='<%=individualRefusalTratment%>';
</script>
<%
if(individualRefusalTratment.equalsIgnoreCase("y"))
{
	%>
	<div id="individualRefusalTratmentDiv" style="display: inline;">
  	<%
}else{
	%>
	<div id="individualRefusalTratmentDiv" style="display: none;">
  	<%
}
%>

<div class="clear"></div>
<label class="large3">Give reason in support of the opinion specifing the Operation/ Treatment recommended</label>
<textarea rows="" cols="" name="<%=OPERA_TREAT_RECOMMEND %>"  onkeyup="chkLength(this,50);"><%=operaTreatmentRecommend%></textarea>
</div>

</div>
<div class="clear paddingTop15"></div>
<h4>What is present degree of disablement as compared with a healthy person of the same age and gender</h4>
<div class="clear paddingTop15"></div>

<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

<tr>
<th >Disability</th>
<th>Percentage of <br> Disablement</th>
<th colspan="2">Duration</th>
<th >Composite Assessment for <br /> all Disability (Max 100%)</th>
<th colspan="">Disability qualifying for <br />disability pension</th>
<th colspan="2">Duration</th>
<th colspan="">Net Assessement qualifying for <br> Disability Pension (Max 100%)</th>
<th colspan="2">Duration</th> 
</tr>

<% 
int incDisability3=0;
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
			incDisability3=incDisability3+1;
			
			String percenDisablement="";
			String disablementYear="";
			String disablementMonth="";
			String compositeAssessment="";
			String disablityPension="";
			String disablityPensionYear="";
			String disablityPensionMonth="";
			String netAssessment="";
			String netAssessmentYear="";
			String netAssessmentMonth="";
			if(masMedicalExamDetails.getDisablementPercentage()!=null){
				percenDisablement=masMedicalExamDetails.getDisablementPercentage();
			}
			if(masMedicalExamDetails.getDisablementYear()!=null){
				disablementYear=masMedicalExamDetails.getDisablementYear();
			}
			if(masMedicalExamDetails.getDisablementMonth()!=null){
				disablementMonth=masMedicalExamDetails.getDisablementMonth();
			}
			if(masMedicalExamDetails.getDisablityCompositeAssessment()!=null){
				compositeAssessment=masMedicalExamDetails.getDisablityCompositeAssessment();
			}
			if(masMedicalExamDetails.getDisablityPension()!=null){		
				disablityPension=masMedicalExamDetails.getDisablityPension();
			}
			if(masMedicalExamDetails.getDisablityPensionYear()!=null){		
				disablityPensionYear=masMedicalExamDetails.getDisablityPensionYear();
			}
			if(masMedicalExamDetails.getDisablityPensionMonth()!=null){
				disablityPensionMonth=masMedicalExamDetails.getDisablityPensionMonth();
			}
			if(masMedicalExamDetails.getDisablityNetAssessment()!=null){
				netAssessment=masMedicalExamDetails.getDisablityNetAssessment();
			}
			if(masMedicalExamDetails.getDisablityAssessmentYear()!=null){
				netAssessmentYear=masMedicalExamDetails.getDisablityAssessmentYear();
			}
			if(masMedicalExamDetails.getDisablityAssessmentMonth()!=null){
				netAssessmentMonth=masMedicalExamDetails.getDisablityAssessmentMonth();
			}
	%>
	<tr>
<td><input type="text"	name="disablementService<%=incDisability3%>" value="<%=masMedicalExamDetails.getPrincipal() %>" tabindex="1" class="auto" size="50" readonly="readonly" />
<input type="hidden" name="disablementServiceId<%=incDisability3%>" value="<%=masMedicalExamDetails.getServiceid() %>" tabindex="1" readonly="readonly" /></td>
<td><input type="text" value="<%=percenDisablement%>" name="percenDisablement<%=incDisability3%>" id="percenDisablement<%=incDisability3%>" maxlength="50" tabindex="1" size="5"/></td>
<td><input type="text" value="<%=disablementYear%>" name="disablementYear<%=incDisability3%>" id="disablementYear<%=incDisability3%>" class="auto" size="3" maxlength="5" tabindex="1"/>Years</td>
<td><input type="text" value="<%=disablementMonth%>"  name="disablementMonth<%=incDisability3%>" id="disablementMonth<%=incDisability3%>" class="auto" size="3" maxlength="5" tabindex="1"/>Months</td>

<td><input type="text" value="<%=compositeAssessment%>"  name="compositeAssessment<%=incDisability3%>" id="compositeAssessment<%=incDisability3%>" maxlength="50" size="5" tabindex="1"/> </td>
<td><input maxlength="50" type="text" value="<%=disablityPension%>"  tabindex="1" maxlength="5" name="disablityPension<%=incDisability3%>" id="disablityPension<%=incDisability3%>"></td>
<td><input type="text" value="<%=disablityPensionYear%>"  name="disablityPensionYear<%=incDisability3%>" id="disablityPensionYear<%=incDisability3%>" class="auto" size="3" maxlength="5" tabindex="1"/>Years</td>
<td><input type="text" value="<%=disablityPensionMonth%>"  name="disablityPensionMonth<%=incDisability3%>" name="disablityPensionMonth<%=incDisability3%>" class="auto" size="3" maxlength="5" tabindex="1"/>Months</td>

<td><input type="text" value="<%=netAssessment%>"  name="netAssessment<%=incDisability3%>" id="netAssessment<%=incDisability3%>" maxlength="50" tabindex="1"/></td>

<td><input type="text" value="<%=netAssessmentYear%>"  name="netAssessmentYear<%=incDisability3%>" id="netAssessmentYear<%=incDisability3%>" class="auto" size="3" maxlength="5" tabindex="1" />Years</td>
<td><input type="text" value="<%=netAssessmentMonth%>"  name="netAssessmentMonth<%=incDisability3%>" id="netAssessmentMonth<%=incDisability3%>" class="auto" size="3" maxlength="5" tabindex="1" />Months</td>
</tr>
<%} } }if(incDisability3 <=0){
	++incDisability3;%>

	<tr>
<td><input type="text"	name="disablementService<%=incDisability3%>" value="" tabindex="1" class="auto" size="50" readonly="readonly" />
<input type="hidden" name="disablementServiceId<%=incDisability3%>" value="" tabindex="1" readonly="readonly" /></td>
<td><input type="text" value="" name="percenDisablement<%=incDisability3%>" id="percenDisablement<%=incDisability3%>" maxlength="50" tabindex="1" size="5"/></td>
<td><input type="text" value="" name="disablementYear<%=incDisability3%>" id="disablementYear<%=incDisability3%>" class="auto" size="3" maxlength="5" tabindex="1"/>Years</td>
<td><input type="text" value=""  name="disablementMonth<%=incDisability3%>" id="disablementMonth<%=incDisability3%>" class="auto" size="3" maxlength="5" tabindex="1"/>Months</td>

<td><input type="text" value=""  name="compositeAssessment<%=incDisability3%>" id="compositeAssessment<%=incDisability3%>" maxlength="50" size="5" tabindex="1"/> </td>
<td><input maxlength="50" type="text" value=""  tabindex="1" maxlength="5" name="disablityPension<%=incDisability3%>" id="disablityPension<%=incDisability3%>"></td>
<td><input type="text" value=""  name="disablityPensionYear<%=incDisability3%>" id="disablityPensionYear<%=incDisability3%>" class="auto" size="3" maxlength="5" tabindex="1"/>Years</td>
<td><input type="text" value=""  name="disablityPensionMonth<%=incDisability3%>" name="disablityPensionMonth<%=incDisability3%>" class="auto" size="3" maxlength="5" tabindex="1"/>Months</td>

<td><input type="text" value=""  name="netAssessment<%=incDisability3%>" id="netAssessment<%=incDisability3%>" maxlength="50" tabindex="1"/></td>

<td><input type="text" value=""  name="netAssessmentYear<%=incDisability3%>" id="netAssessmentYear<%=incDisability3%>" class="auto" size="3" maxlength="5" tabindex="1" />Years</td>
<td><input type="text" value=""  name="netAssessmentMonth<%=incDisability3%>" id="netAssessmentMonth<%=incDisability3%>" class="auto" size="3" maxlength="5" tabindex="1" />Months</td>
</tr>
<%} %>
<input type="hidden" name="hdbDisabilityPresent" value="<%=incDisability3 %>" id="hdbDisabilityPresent" />
</table>
</div>

<div class="clear paddingTop15"></div>
<div class="clear paddingTop15"></div>
<%
String individualTreatment="y";
String individualNature="";
String treatmentYear="";
String treatmentMonth="";
String individualAttendent="";
String attendentYear="";
String attendentMonth="";
String flcDate="";
String medBoardOpinion="";


if(medExamObj.getIndividual_further_tratment()!=null){
	individualTreatment=medExamObj.getIndividual_further_tratment();
}
if(medExamObj.getIndividualNature()!=null){
	individualNature=medExamObj.getIndividualNature();
}
if(medExamObj.getTreatmentYear()!=null){
	treatmentYear=medExamObj.getTreatmentYear();
}
if(medExamObj.getTreatmentMonth()!=null){
	treatmentMonth=medExamObj.getTreatmentMonth();
}
if(medExamObj.getIndividualAttendent()!=null){
	individualAttendent=medExamObj.getIndividualAttendent();
}
if(medExamObj.getAttendentYear()!=null){
	attendentYear=medExamObj.getAttendentYear();
}
if(medExamObj.getAttendentMonth()!=null){
	attendentMonth=medExamObj.getAttendentMonth();
}

if(medExamObj.getFlcDate()!=null){
	flcDate=HMSUtil.convertDateToStringTypeDateOnly(medExamObj.getFlcDate());
}
if(medExamObj.getOpinion()!=null){
	medBoardOpinion=medExamObj.getOpinion();
}

%>

<div class="Block">
<label class="large3">Is the Individual in need of further treatment</label>
<select id="individualTreatment" name="<%=INDIVIDUAL_FURTHER_TREAT %>" onchange="showHideIndividualTreatment();">
<option value="y">Yes</option>
<option value="n">No</option></select>
<script type="text/javascript">
document.mbOpinionForm16.individual_further_tratment.value='<%=individualTreatment%>';
</script>
<div class="clear"></div>
<div id="individualTreatmentDiv" style="display: inline;">
<label>What Nature</label>
<input type="text" name="<%=INDIVIDUAL_NATURE%>" maxlength="50" value="<%=individualNature%>"/>
<label>How long Required</label>
<input type="text" class="auto" size="16" name="<%=TREATMET_YEAR %>" value="<%=treatmentYear %>" maxlength="4"/><label class="unit">Year(s)</label>
<input type="text" class="auto" size="16" name="<%=TREATMET_MONTH %>" value="<%=treatmentMonth%>" maxlength="2" /><label class="auto">Month(s)</label>
</div>
<label class="large3">Does the individual require an attendent</label>
<select name="<%=INDIVIDUAL_ATTENDENT %>" id="individualAttendent" onchange="showHideIndividualAttendent();">
<option value="">Select</option>
<option value="y">Yes</option>
<option value="n">No</option></select>

<script type="text/javascript">
document.mbOpinionForm16.individualAttendent.value='<%=individualAttendent%>';
</script>
<div class="clear"></div>
<%
if(individualAttendent.equalsIgnoreCase("y"))
{
	%>
	<div id="individualAttendentDiv" style="display: inline;">
  	<%
}else{
	%>
	<div id="individualAttendentDiv" style="display: none;">
  	<%
}
%>

<label>How long Required</label>
<input type="text" class="auto" name="<%=ATTENDENT_YEAR %>" value="<%=attendentYear%>"/><label class="unit">Year(s)</label>
<input type="text" class="auto" name="<%=ATTENDENT_MONTH %>" value="<%=attendentMonth%>"/><label class="auto">Month(s)</label>
</div>
</div>

<div class="clear paddingTop15"></div>
<div class="clear paddingTop15"></div>

<div class="Block">

<label class="large">Invalidment/ Realease in Medical Category</label>
<%--<%if(medExamObj.getReleaseMedCatValue() !=null){ %>
<input type="text" class="large" name="<%=INVALID_RELEASE_MED_CAT %>" value="<%=medExamObj.getReleaseMedCatValue() %>"/><%}else{ %>
<input type="text" class="large" name="<%=INVALID_RELEASE_MED_CAT %>" />
<%} %>
--%>


<select name="<%=INVALIDMENT_RELEASE_MED_CAT %>" id="medCatNowRecommend" onclick="setMedCatRec()" validate="Invalidment/ Realease in Medical Category,string,no" tabindex=1>
	<option value="0">Select</option>
	<%
	if(categoryList.size()>0){		
		for (Category category : categoryList) {
			if(medExamObj.getMedCatRelease() !=null){
			if(medExamObj.getMedCatRelease().getCategoryid()==category.getCategoryid())
				{
					%>
		<option value="<%=category.getCategoryid()%>" selected="selected" ><%=category.getCategories()%> </option>
		<%}else{ %>
		<option value="<%=category.getCategoryid()%>"><%=category.getCategories()%> </option>
		<%}}else{
			%>
		<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
		<%	}

					}	}%>
</select>
<%
String medcatrec="";
if(medExamObj.getMedCatRec() !=null){ 
medcatrec= medExamObj.getMedCatRec();
}%>
<input type="hidden" name="medcatrec" id="medcatrec" value="<%=medcatrec %>"/>
<div class="clear"></div>
<label>Period  </label>
<% if(medExamObj.getReleaseMedPeriod() !=null && medExamObj.getReleaseMedPeriod()!=""){
 String medCatPeriod=medExamObj.getReleaseMedPeriod().substring(0,medExamObj.getReleaseMedPeriod().indexOf(" "));
 String medCatDuration = medExamObj.getReleaseMedPeriod().substring(medExamObj.getReleaseMedPeriod().indexOf(" ")+1);%>
 <input type="text" name="releaseCatPeriod" id="releaseCatPeriod" value="<%=medCatPeriod %>" maxlength="5" class="small"/>
 <select name="releaseCatDuration" id="releaseCatDuration" class="small">
<%if(medCatDuration.equalsIgnoreCase("Months")){ %>
 <option value="Months" selected="selected">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option>
 <%}else if(medCatDuration.equalsIgnoreCase("Weeks")){ %>
 <option value="Months">Months</option>
 <option value="Weeks" selected="selected">Weeks</option>
 <option value="Days">Days</option>
 <%}else if(medCatDuration.equalsIgnoreCase("Days")){ %>
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days" selected="selected">Days</option>
 <%}else{ %>
  <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option>
 <%} %></select>
 <%}else{%><input type="text" name="releaseCatPeriod" id="releaseCatPeriod" value="" maxlength="5" class="small"/>
 <select name="releaseCatDuration" id="releaseCatDuration" class="small">
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option></select><%} %>
 <label>Shape Factor</label>
 <%if(medExamObj.getShapFactor() !=null){ %>
 <input type="text" name="releaseShapeFactor" id="releaseShapeFactor" value="<%=medExamObj.getReleaseShapeFactor() %>" maxlength="19" tabindex="1"/>
 <%}else{ %>
  <input type="text" name="releaseShapeFactor" id="releaseShapeFactor" value="" maxlength="19" tabindex="1"/>
 <%} %> 
<div class="clear"></div>

<label class="large">Medical Board Opinion</label>
<input type="text" class="large" name="<%=MED_BOARD_OPINION %>" value="<%=medBoardOpinion %>"/>

<div class="clear"></div>

<label>Member 1</label>
<select name="member1" id="member1"	tabindex="1">
	<option value="0">Select</option>
	<%
	int medMember1=0;
	if(medExamObj.getMedDetailMember1()!=null){
		medMember1=medExamObj.getMedDetailMember1().getId();
	}
			   if(employeeList.size()>0){
				   for(MasEmployee masEmployee:employeeList){
					String employeeName="";
					if(masEmployee.getFirstName()!=null){
						employeeName=masEmployee.getFirstName();
					}
					if(masEmployee.getMiddleName()!=null){
						employeeName=employeeName+" "+masEmployee.getMiddleName();
					}
					if(masEmployee.getLastName()!=null){
						employeeName=employeeName+" "+masEmployee.getLastName();
					}
			String medMemberStr1="";
					if(medMember1==masEmployee.getId()){
						medMemberStr1="selected";
					}
			%>
	<option value="<%=masEmployee.getId()%>" <%=medMemberStr1 %>><%=masEmployee.getRank().getRankName()+" "+employeeName%></option>
	<%
		   }
	      }

		%>

</select>


<label>Member2</label>
<select name="member2" id="member2"	tabindex="1">
	<option value="0">Select</option>
	<%
	int medMember2=0;
	if(medExamObj.getMedDetailMember2()!=null){
		medMember2=medExamObj.getMedDetailMember2().getId();
	}
			   if(employeeList.size()>0){
				   for(MasEmployee masEmployee:employeeList){
					String employeeName="";
					if(masEmployee.getFirstName()!=null){
						employeeName=masEmployee.getFirstName();
					}
					if(masEmployee.getMiddleName()!=null){
						employeeName=employeeName+" "+masEmployee.getMiddleName();
					}
					if(masEmployee.getLastName()!=null){
						employeeName=employeeName+" "+masEmployee.getLastName();
					}
					String medMemberStr2="";
					if(medMember2==masEmployee.getId()){
						medMemberStr2="selected";
					}
			%>
	<option value="<%=masEmployee.getId()%>" <%=medMemberStr2 %>><%=masEmployee.getRank().getRankName()+" "+employeeName%></option>
	<%
		   }
	      }

		%>

</select>

<label class="auto">Signature of President</label>
<select name="president" id="president"	tabindex="1">
	<option value="0">Select</option>
	<%
	int medPresedent=0;
	if(medExamObj.getMedDetailPresident()!=null){
		medPresedent=medExamObj.getMedDetailPresident().getId();
	}

			   if(employeeList.size()>0){
				   for(MasEmployee masEmployee:employeeList){
					String employeeName="";
					if(masEmployee.getFirstName()!=null){
						employeeName=masEmployee.getFirstName();
					}
					if(masEmployee.getMiddleName()!=null){
						employeeName=employeeName+" "+masEmployee.getMiddleName();
					}
					if(masEmployee.getLastName()!=null){
						employeeName=employeeName+" "+masEmployee.getLastName();
					}
					if(masEmployee.getRank() !=null){
						employeeName=masEmployee.getRank().getRankName()+" "+employeeName;
					}
					String selectedPres="";
					if(medPresedent==masEmployee.getId()){
						selectedPres="selected";
					}
			%>
	<option value="<%=masEmployee.getId()%>" <%=selectedPres%> ><%=employeeName%></option>
	<%
		   }
	      }	%>

</select>

</div>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<div class="division"></div>
<div class="clear paddingTop15"></div>


<input tabindex="1" name="Button" type="button" class="button" value="Update"	onClick="submitForm('mbOpinionForm16','medicalBoard?method=validateMBOpinion');" />
<input tabindex="1" name="Button"	type="button" class="button" value="Validate" onClick="checkPresidentValidate();"/>
<input tabindex="1" name="Button" type="button" class="button" value="REJECT"	onClick="checkReject();" />
<input tabindex="1" class="button" onclick="resetCheck()" type="reset" value="Reset" name="Reset"  accessKey="r"/>

<input tabindex="1" name="Button"	type="button" class="buttonBig" value="Medical Case Sheet" onClick="submitForm('mbOpinionForm16','/hms/hms/medicalBoard?method=printMedicalCaseSheet')" />
<%if(dgOrderhd.getOrderStatus().equals("A")){ %>
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Print Investigations"	onclick="submitForInvestigationPrintOut();" />
<%} %>
<input name="Send" type="hidden"  class="button" value="Upload" onClick="javascript:fileUploadViewWindow('ALL');" />
<div class="clear"></div>
<div class="division"></div>
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
<input name="visitId" type="hidden" value="<%=visit.getId()%>" validate="visitId,int,no" />
<input type="hidden"  name="MissTeeth" id="MissTeeth" value=""/>
<input type="hidden"  name="UnserTeeth" id="UnserTeeth" value=""/>

<!--Bottom labels starts--> <!--main content placeholder ends here--> <script
	type="text/javascript">
	</script> <script type="text/javascript">
function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {

        limitField.value = limitField.value.substring(0, limitNum);

    }
}

/*
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
*/
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

				submitProtoAjaxWithDivName('mbOpinionForm16','/hms/hms/opd?method=showGridForInvestigation','gridview');

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
 
 function copyPrevInvestigationTempate(visitNo,hinId){
		document.getElementById('templateDivInvestigationToShowHide').style.display = 'none';
		document.getElementById('prevButtonDivInvestigationToShowHide').style.display = 'none';
		document.getElementById('createInvestigationDivToShowHide').style.display = 'none';

		var hdb = document.getElementById('hdb').value;
	    submitProtoAjaxWithDivName('mbOpinionForm16','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}
 function getListForTreatment(val){
	 	if(val=='investigationDiv'){
			submitProtoAjaxWithDivName('mbOpinionForm16','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
		}else if(val=='treatmentDiv'){
			submitProtoAjaxWithDivName('mbOpinionForm16','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
		}
//		document.getElementById('prescriptionImportButton').style.display = 'none';
//		document.getElementById("investigationImportButton").style.display='none'
	 }
	function FileUploadWindow()
	{
		   var folderName='hearing';
			var url="/hms/hms/medicalExam?method=displayFileUpload";

			newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

	}
	function fileUploadWindowInvestigation(rowVal)
	{
		var medicalExamId='';
	 	if(medicalExamId=='0')
	 	{
	 	 	alert("file can not be uploaded; refferred to MH");
	 	 	return false;
	 	}else{
	 		var val=document.getElementById('chargeCodeName'+rowVal).value;
			var index1 = val.lastIndexOf("[");
			var index2 = val.lastIndexOf("]");
			index1++;
			var invest_id = val.substring(index1,index2);
			var url="/hms/hms/medicalExam?method=displayFileUploadInvestigation";
			newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	 	}

	}
	function FileUploadWindowGynaecology()
	{
		var folderName='gynaecology';
			var url="/hms/hms/medicalExam?method=displayFileUpload";

			newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

	}
	//function fileUploadViewWindow(flag)
	//{
		//flag=HEA Means-->Hearing
		//flag=GYN Means-->GYNAECOLOGY EXAM
		//flag=ALL Means-->ALL Type
//		<li><a href="opd?method=showUploadingDocumentsJsp&visitId=<%=visit.getId() %>">Upload Documents </a></li>
		//	var url="/hms/hms/medicalBoard?method=showUploadViewDocumentJsp&visitId=<%=visit.getId()%>&medExamId=<%=medExamId%>&flag="+flag;

		//	newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

	//}
	/*
 function FileUploadViewWindow()
 {
 		var url="/hms/hms/medicalBoard?method=showUploadViewDocumentJsp";

 		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

 }

function openPopupForClinicalSummary(){
		var url="/hms/hms/medicalBoard?method=showClinicalSummaryJsp";
	   newwindow=window.open(url,'clinicalSummary','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
	}*/

function showHideDisabilityExistedBeforeService(){
	if(document.getElementById('disabilityExistedBeforeService').value == 'y'){
	  	document.getElementById("disabilityExistedBeforeServiceDiv").style.display='inline';
	}else{
		document.getElementById("disabilityExistedBeforeServiceDiv").style.display='none';
	}
}

function showHideEffectsOfAggravationPersists(){
	if(document.getElementById('effectsOfAggravationPersists').value == 'y'){
	  	document.getElementById("effectsOfAggravationPersistsDiv").style.display='inline';
	}else{
		document.getElementById("effectsOfAggravationPersistsDiv").style.display='none';
	}
}
function showHideWillEffectPersistForMatcrialPeriod(){
	if(document.getElementById('willEffectPersistForMatcrialPeriod').value == 'y'){
	  	document.getElementById("willEffectPersistForMatcrialPeriodDiv").style.display='inline';
	}else{
		document.getElementById("willEffectPersistForMatcrialPeriodDiv").style.display='none';
	}
}
function showHideDisabilityAttributeDueToIndividualsOwnNegligence(){
	if(document.getElementById('disabilityAttributeDueToIndividualsOwnNegligence').value == 'y'){
	  	document.getElementById("disabilityAttributeDueToIndividualsOwnNegligenceDiv").style.display='inline';
	}else{
		document.getElementById("disabilityAttributeDueToIndividualsOwnNegligenceDiv").style.display='none';
	}
}
function showHideAggarvatedByNegligence(){
	if(document.getElementById('aggarvatedByNegligence').value == 'y'){
	  	document.getElementById("aggarvatedByNegligenceDiv").style.display='inline';
	}else{
		document.getElementById("aggarvatedByNegligenceDiv").style.display='none';
	}
}
function showHideIndividualRefusedForOperationTreatment(){
	if(document.getElementById('individualRefusedForOperationTreatment').value == 'y'){
	  	document.getElementById("individualRefusedForOperationTreatmentDiv").style.display='inline';
	}else{
		document.getElementById("individualRefusedForOperationTreatmentDiv").style.display='none';
	}
}
function showHideFurtherTreatmentRequire(){
	if(document.getElementById('furtherTreatmentRequire').value == 'y'){
	  	document.getElementById("furtherTreatmentRequireDiv").style.display='inline';
	}else{
		document.getElementById("furtherTreatmentRequireDiv").style.display='none';
	}
}
function showHideAttendantRequired(){
	if(document.getElementById('attendantRequired').value == 'y'){
	  	document.getElementById("attendantRequiredDiv").style.display='inline';
	}else{
		document.getElementById("attendantRequiredDiv").style.display='none';
	}
}

//---Methods Written By Kiran

function showHideDisabilityAttribute()
{

	if(document.getElementById('individualMisconduct').value == 'y')
		{
		  	document.getElementById("disabilityAttributeDiv").style.display='inline';
		}
	else
		{
			document.getElementById("disabilityAttributeDiv").style.display='none';
		}
}


function showHideExistDisability()
{

	if(document.getElementById('existDisability').value == 'y')
		{
		  	document.getElementById("existDisabilityDiv").style.display='inline';
		}
	else
		{
			document.getElementById("existDisabilityDiv").style.display='none';
		}
}

function showHideAggravated()
{

	if(document.getElementById('aggravatedMisconduct').value == 'y')
		{
		  	document.getElementById("aggravatedMisconductDiv").style.display='inline';
		}
	else
		{
			document.getElementById("aggravatedMisconductDiv").style.display='none';
		}
}

function showHideUndergoOperation()
{

	if(document.getElementById('refuseOperationTreat').value == 'y')
		{
		  	document.getElementById("refuseOperationTreatDiv").style.display='inline';
		}
	else
		{
			document.getElementById("refuseOperationTreatDiv").style.display='none';
		}
}

function showHideOperationTreatment()
{

	if(document.getElementById('individualRefusalTratment').value == 'y')
		{
		  	document.getElementById("individualRefusalTratmentDiv").style.display='inline';
		}
	else
		{
			document.getElementById("individualRefusalTratmentDiv").style.display='none';
		}
}

function showHideRefusal()
{

	if(document.getElementById('reducDisablePension').value == 'y')
		{
		  	document.getElementById("reducDisablePensionDiv").style.display='inline';
		}
	else
		{
			document.getElementById("reducDisablePensionDiv").style.display='none';
		}
}
function showHideIndividualTreatment()
{

	if(document.getElementById('individualTreatment').value == 'y')
		{
		  	document.getElementById("individualTreatmentDiv").style.display='inline';
		}
	else
		{
			document.getElementById("individualTreatmentDiv").style.display='none';
		}
}
function showHideIndividualAttendent()
{

	if(document.getElementById('individualAttendent').value == 'y')
		{
		  	document.getElementById("individualAttendentDiv").style.display='inline';
		}
	else
		{
			document.getElementById("individualAttendentDiv").style.display='none';
		}
}
//---End of Methods by Kiran

</script></form>
<script>

function openPopupForMedExamDetail(medExamId,visitId)
{
	var url='/hms/hms/medicalBoard?method=showPopUpViewMedExamDetail&medExamId='+medExamId+'&visitId='+visitId ;
   	newwindow=window.open(url,'medExamDetail','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
}

function openPopupForClinicalSummary(medExamId,visitId)
{
	var url='/hms/hms/medicalBoard?method=showViewClinicalSummary16Jsp&medExamId='+medExamId+'&visitId='+visitId ;
   	newwindow=window.open(url,'clinicalSummary','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
}
/*function openPopupForMedicalBoard(medExamId){
	var url="/hms/hms/medicalBoard?method=showMedicalBoardJsp";
   newwindow=window.open(url,'medicalBoardOpinion','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
}*/
function openPopupForCommandingOfficer(){
	var url='/hms/hms/medicalBoard?method=showCommandOfficerJsp&visitId=<%=visit.getId()%>&medExamId=<%=medExamId%>';
   newwindow=window.open(url,'commandOfficer','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function checkReject()
{
		submitForm('mbOpinionForm16','medicalBoard?method=rejectMBForm16Entry&rejectStatus=nr');
}
function checkPresidentValidate()
{
	var president=document.getElementById("president").value;
	if(president==<%=loginEmpId%>){
		submitForm('mbOpinionForm16','medicalBoard?method=validateMBOpinion&data=validate');
	}else{
	alert("President can login and validate only.");
	return false;
	}
}
function showHideDisabilityBefore(){
	if(document.getElementById('disabilitybefore').value == 'y'){
	  	document.getElementById("beforeDisabilityDiv").style.display='inline';
	}else{
		document.getElementById("beforeDisabilityDiv").style.display='none';
	}
}
function addRowIcdDisability(){
	  var tbl = document.getElementById('gridIcdDisability');
	  var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow-1;
	  var row = tbl.insertRow(lastRow);

	  var hdb = document.getElementById('hdbIcdCronicalDisability');
	  hdb.value=iteration

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	
		e0.name = 'icdDisability' + iteration;
		e0.id = 'icdDisability' + iteration;
		e0.setAttribute('tabindex','1');
		e0.size = '50'
	//	cellRight0.appendChild(newdiv1);
		cellRight0.appendChild(e0);

		 var e01 = document.createElement('input');
		 e01.type = 'hidden';
		 e01.className = 'date';
		 e01.name='disablementServiceIdCronical'+ iteration;
		 e01.id='disablementServiceIdCronical'+iteration;
		 e01.value='0';
		 cellRight0.appendChild(e01); 
		
		
		  var newdiv1 = document.createElement('div');
		  newdiv1.setAttribute('id', 'ac2update1'+iteration);
		  newdiv1.setAttribute('class', 'autocomplete');
		  newdiv1.style.display = 'none';
		  cellRight0.appendChild(newdiv1);
		  cellRight0.appendChild(e0);
		new Ajax.Autocompleter('icdDisability'+iteration,'ac2update1'+iteration,'medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=icdDisability'+iteration});

		var cellRight1 = row.insertCell(1);
	    var e1 = document.createElement('input');
	    e1.type = 'text';
	    e1.className = 'date';
	    e1.name='dateOfOrigin'+ iteration;
	    e1.id='dateOfOrigin'+iteration;
	    e1.size='11';
	    e1.setAttribute('tabindex','1');
	    cellRight1.appendChild(e1);

	    
	    var e11 = document.createElement('img');
	    e11.src = '/hms/jsp/images/cal.gif';
	   // e3.style.display ='none';
	    e11.id = 'calId'+iteration;
	    e11.onclick = function(event){
	    setdate('',document.getElementById('dateOfOrigin'+iteration),event) };
	    cellRight1.appendChild(e11);

	    var cellRight2 = row.insertCell(2);
		  var e2 = document.createElement('Select');
		  e2.name = 'rankDisablilty'+ iteration;
		  e2.id = 'rankDisablilty' + iteration;
		  e2.setAttribute('tabindex', 1); 
		  e2.options[0] = new Option('Select', '0');
		   for(var i = 0;i<rankDisablilty.length;i++ ){
		      e2.options[i+1] = new Option(rankDisablilty[i][1],rankDisablilty[i][0]);
		      }
		  cellRight2.appendChild(e2);

		  var cellRight3 = row.insertCell(3);
		    var e3 = document.createElement('input');
		    e3.type = 'text';
		    e3.name='placeServing'+ iteration;
		    e3.id='placeServing'+iteration;
		    e3.setAttribute('tabindex','1');
			cellRight3.appendChild(e3);

		    var cellRight4 = row.insertCell(4);
			  var e4 = document.createElement('Select');
			  e4.name = 'unitDisablilty'+ iteration;
			  e4.id = 'unitDisablilty' + iteration;
			  e4.setAttribute('tabindex', 1); 
			  e4.options[0] = new Option('Select', '0');
			   for(var i = 0;i<unitDisablilty.length;i++ ){
			     e4.options[i+1] = new Option(unitDisablilty[i][1],unitDisablilty[i][0]);
			      }
			  cellRight4.appendChild(e4);
		    
		  
	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonAdd';
	  e5.name='Button';
	  e5.setAttribute('onClick','addRowIcdDisability();');
	  cellRight5.appendChild(e5);

	  var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.type = 'button';
	  e6.className = 'buttonDel';
	  e6.name='delete';
	  //e6.setAttribute('onClick','removeRow('gridIcdDisability','hdbIcdCronicalDisability',this);');
	  e6.onclick =function(){removeRow('gridIcdDisability','hdbIcdCronicalDisability',this);};
	  cellRight6.appendChild(e6);
}

function removeRowDisability()
{
var tbl = document.getElementById('gridIcdDisability');
var lastRow = tbl.rows.length;
if (lastRow > 2){
	tbl.deleteRow(lastRow - 1);
	var tbl = document.getElementById('gridIcdDisability');
	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow - 1;
	var hdb = document.getElementById('hdbDisability');
	hdb.value=iteration
}
}
function openPopupForSpecialistOpinion()
{
	var url="/hms/hms/medicalBoard?method=showViewSpecialistOpinionJsp&visitId=<%=visit.getId()%>&medExamId=<%=medExamId%>";
	newwindow=window.open(url,'mbSpecialistOpinion','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function submitForInvestigationPrintOut()
{
	var orderNo=document.getElementById('dgOrderhdId').value;
	var flag="MO";
	var hinId= document.getElementById('hinId').value;
	if(orderNo!=null && orderNo!="" && hinId!=null && hinId!=""){
		submitFormForButton('mbOpinionForm16','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo+'&hinId='+hinId+'&flag='+flag);
		}
}
function fileUploadViewWindow(flag)
{
	//flag=HEA Means-->Hearing
	//flag=GYN Means-->GYNAECOLOGY EXAM
	//flag=ALL Means-->ALL Type
//	<li><a href="opd?method=showUploadingDocumentsJsp&visitId=<%=visit.getId() %>">Upload Documents </a></li>
	var url="/hms/hms/medicalBoard?method=showUploadViewDocumentJsp&visitId=<%=visit.getId()%>&medExamId=<%=medExamId%>&flag="+flag;
	newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

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
function setMedCatRec()
{
	 var obj=document.getElementById('medCatNowRecommend');
	if(obj !=null && obj !=""){
		var title=obj.options[obj.selectedIndex].text;
		document.getElementById('medcatrec').value=title;
	}
}
</script>

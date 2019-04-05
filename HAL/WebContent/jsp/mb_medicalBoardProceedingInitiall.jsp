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
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.Disability"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.Disabilitygroup"%>

<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">
var disabilityListArray=new Array();
var masIcdListArray=new Array();
var disabilitygroupListArray=new Array();
</script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>

<!-- -<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
 -->
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
		//String time = (String) utilMap.get("currentTime");
		String time = (String) utilMap.get("currentTimeWithoutSc");

	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';

	</script>
<script type="text/javascript">
var categoryMedArray=new Array();
<%
String Labresult="NotPresent";
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
/*List<Disability> disabilityList= new ArrayList<Disability>();
if(map.get("disabilityList") != null){
	disabilityList=(List)map.get("disabilityList");
}*/
List<Category> categoryList= new ArrayList<Category>();
if(map.get("categoryList") != null){
	categoryList=(List)map.get("categoryList");
}
String url="";
if(map.get("url") != null){
	url = (String)map.get("url");
}
String jspheading=null;
if(map.get("jspheading") != null){
	jspheading = (String)map.get("jspheading");
}
List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
if(map.get("medExamList") != null){
	medExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("medExamList");
}
List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
if(map.get("masMedicalExaminationDetailList") != null){
	masMedicalExaminationDetailList = (List<MasMedicalExaminationDetail>)map.get("masMedicalExaminationDetailList");
}
MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();

if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
}
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
}
Properties properties = new Properties();
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
Set<PatientInvestigationDetails> patientInvestigationdetails=null;
PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
if(map.get("patientInvestigationHeader")!=null){

	patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
	patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
}

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
List<MasIcd> masIcdList = new ArrayList<MasIcd>();
if(map.get("masIcdList") != null){
	masIcdList=(List)map.get("masIcdList");

	}
List<Disabilitygroup> disabilitygroupList = new ArrayList<Disabilitygroup>();
if(map.get("disabilitygroupList") != null){
	disabilitygroupList=(List)map.get("disabilitygroupList");

	}


List<OpdPatientDetails> opdDentalDetailsList = new ArrayList<OpdPatientDetails>();
if(map.get("opdDentalDetailsList") != null){
	opdDentalDetailsList=(List<OpdPatientDetails>)map.get("opdDentalDetailsList");
}
OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
if(opdDentalDetailsList.size() > 0){
	opdPatientDetails = opdDentalDetailsList.get(0);
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
int token=0;
if(visit.getTokenNo()!=null){
	token=visit.getTokenNo();
}
if(!message.equalsIgnoreCase("")){
	
%>
<h4><%=message %></h4>
<%} %>
<%---
<div>
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" onClick="submitForm('MedicalBoardInitialMedExamJsp','opd?method=showPatientPreviousVisitForViewScreen&link=medicalExam&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>');"" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" class="buttonBig2" onClick="submitForm('MedicalBoardInitialMedExamJsp','medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>');"" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" class="buttonBig2" onClick="submitForm('MedicalBoardInitialMedExamJsp','medicalExam?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&serviceNo=<%=visit.getHin().getServiceNo() %>');"" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onClick="submitForm('MedicalBoardInitialMedExamJsp','opd?method=showPatientPreviousVisitForHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>');"" />
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
<div class="clear"></div>
<!--main content placeholder starts here-->
<div class="titleBg">
<h2>AFMSF-15</h2>
<div class="floatRight"><h2>Initial</h2> </div>
</div>
<div class="clear"></div>
<body onLoad="coolDental()">
<form name="MedicalBoardInitialMedExamJsp" action="" method="post">
<!--Block One Starts-->
<%
int medExamId = 0;
if(medExamObj.getId()!= null){
	medExamId = medExamObj.getId();
}
%>

<div class="Block">
<label>Authority for Board</label>
<%
String authority="IAP4303(4TH Ed)";
if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
	if(medExamObj.getAuthority()!=null){
		authority=medExamObj.getAuthority();
	}

} %>
<input type="text" name="authorityforBoard" id="AuthorityforBoard" value="<%=authority %>" tabindex="1"  validate="Authority of board,metacharSpacBrac,no" />
<%
 
	 String place="";
if(medExamObj.getPlace()!=null){
		 place= medExamObj.getPlace();
	 }else{
	 if(session.getAttribute("hospitalName")!=null){
		 place=((String)session.getAttribute("hospitalName"));
	 }
	 }
	 %>
<label>Place </label>
<input tabindex="1" type="text" maxlength="99" class="autoArial" size="50" id="<%=PLACE %>" name="<%=PLACE %>"  value="<%=place%>"
	onKeyUp="limitText(this,99);" validate="Place,metacharSpacBrac,no" />
</div>
<div class="clear paddingTop15"></div>

<div class="Block">
<label>Name  </label>

  <input type="text" value="<%= visit.getHin().getSFirstName()+" "+(visit.getHin().getSMiddleName()!=null?visit.getHin().getSMiddleName():"")+" "+(visit.getHin().getSLastName()!=null?visit.getHin().getSLastName():"") %>" readonly="readonly" name="<%=FULL_NAME%>"	tabindex="1" maxlength="20" validate="Name,metacharSpac,no" />
<input type="hidden" name="medExamId" id="medExamId" value="<%=medExamId %>" validate="med Exam Id,metachar,no"/>
<label>Service No. </label>
<% if(visit.getMedExamType()!=null){%>
 <input type="hidden"	value="<%= visit.getMedExamType() %>" name="medicalExamType" tabindex="1" />

<% }else{%>

 <input type="hidden"	value="Initial Medical Board AFMSF 15" name="medicalExamType" tabindex="1" />
<% }%>
 <input type="text"	 name="<%=SERVICE_NO %>" id="serviceNo" readonly="readonly" tabindex="1" value="<%=visit.getHin().getServiceNo()%>" validate="serviceNo,metachar,no" />
 <label>Rank  </label>
   <input type="text" value="<%= visit.getHin().getRank().getRankName() %>" readonly="readonly" name="<%=RANK%>"	tabindex="1" maxlength="20"  validate="Rank,metacharSpacBrac,no" />
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="1" maxlength="20"  validate="Rank_id ,metachar,no" />


 <div class="clear"></div>
  <label>Unit </label>
 <% if(visit.getHin().getUnit()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>" tabindex="1" value="<%=visit.getHin().getUnit().getUnitName() %>"/>
 <input type="hidden" value="<%=visit.getHin().getUnit().getId() %>" name="<%=UNIT_ID%>"	tabindex="1" validate="Unit_Id,metachar,no" />
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>" tabindex="1" />
 <% }%>
 <label>Service</label>
 <input	type="text" value="<%=  visit.getHin().getServiceType().getServiceTypeName() %>" readonly="readonly" name="serviceiaf"	tabindex="1" maxlength="20" validate="service,metacharSpacBrac,no" />
  <input type="hidden" value="<%= visit.getHin().getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID%>"	tabindex="1" maxlength="20" validate="service_type_id ,metachar,no" />
 <label>Branch/Trade  </label>
<% if(visit.getHin().getTrade()!=null){%>
 <input	type="text"  name="<%=TRADE%>"	readonly="readonly" tabindex="1" value="<%= visit.getHin().getTrade().getTradeName() %>" maxlength="20" />
  <input	type="hidden"  name="<%=TRADE_ID%>"	tabindex="1" value="<%= visit.getHin().getTrade().getId() %>" maxlength="20" />

<% }else{%>
 <input	type="text"  name="<%=TRADE%>"	tabindex="1" />

 <% }%>
 <div class="clear"></div>
 <label> DOB </label>
 <%
 if(visit.getHin().getDateOfBirth()!=null && !(visit.getHin().getDateOfBirth().equals(""))){%>
  <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly" class="date" value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>"
	validate="DOB,date,yes" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_OF_BIRTH %>,event);"/>

	<% }else if(medExamObj.getDateOfBirth()!=null && !(medExamObj.getDateOfBirth().equals(""))){%>
	  <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly" class="date" value="<%= HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfBirth()) %>"
			validate="DOB,date,yes" maxlength="10"
			onKeyUp="mask(this.value,this,'2,5','/');" />
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" class="calender" onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_OF_BIRTH %>,event);"/>

			<% }else{%>
<input	tabindex="1" name="<%=DATE_OF_BIRTH %>" class="date" value=""
	validate="DOB,date,yes" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_OF_BIRTH %>,event);" />

	<% }%>
 <label>Age  </label>
  <% if(visit.getHin().getAge()!=null){%>
<input	type="text" readonly="readonly" maxlength="20"  value="<%=visit.getHin().getAge() %>" name="apparentAge"	tabindex="1" />

 <% }else{%>
<input	type="text" readonly="readonly" maxlength="20"  value="" name="typeOfCommunication"	tabindex="1" />

 <% }%>
 <label>Gender</label>
  <input type="text" readonly="readonly" value="<%= visit.getHin().getSex().getAdministrativeSexName() %>" name="sex"	tabindex="1" maxlength="20" validate="sex,metachar,no"/>
  <%if(visit.getAge()!= null){ %>
<input type="hidden" name="ageId" id="ageId" value="<%=visit.getAge() %>">
<%} %>
<%if(visit.getHin().getSex() != null){  %>
<input type="hidden" name="genderId" id="genderId" value="<%=visit.getHin().getSex().getId() %>" validate="genderId,metachar,no" >
<%} %>
  <div class="clear"></div>
  <%--
  <label>Weight  </label>
 <%if(medExamObj.getPatientweight()!=null)
 { %>
  <input	class="autoArial" tabindex="1" type="text" value="<%=medExamObj.getPatientweight()%>" name="patientweight"	tabindex="3" maxlength="20" size="15"/>
 <% }else{%>
   <input	class="autoArial" tabindex="1" type="text"  name="patientweight"	tabindex="3" maxlength="20" size="15"/>
 <% }%>
 <label class="unit2">Kg</label>
<label>Height</label>
<%if(medExamObj.getPatientheight()!=null)
 { %>
  <input	class="auto" tabindex="1" type="text" value="<%=medExamObj.getPatientheight()%>" name="patientheight"	tabindex="3" maxlength="20" size="17"/>
 <% }else{%>
   <input	class="auto" tabindex="1" type="text"  name="patientheight"	tabindex="2" maxlength="20" size="17"/>
 <% }%>
 <label class="unit2">cm</label>
--%>
 <label>Address on Leave</label>
<%
String addressOnLeave="";

if(medExamObj.getParmanentAddress()!=null)
 {
	addressOnLeave=medExamObj.getParmanentAddress();
 }
%>
  <input	type="text" value="<%=addressOnLeave%>"  name="<%=PERMANENT_ADDRESS%>"	tabindex="1" maxlength="99"  validate="Address on Leave,metachar,no"/>
 

 
 <label>DOE/DOC</label>
  <%if(visit.getHin().getCommissionDate()!=null)
 { %>
 <input	tabindex="1" name="<%=DATE_COMMENCEMENT %>" readonly="readonly" class="date"  value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getCommissionDate()) %>"	validate="Entry Date,date,no" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" />
 <img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_COMMENCEMENT%>,event);" />
 <% }else{%>
 <input	tabindex="1" name="<%=DATE_COMMENCEMENT %>" class="date"   value="<%=date %>"	validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" 	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_COMMENCEMENT%>,event);" />
 <% }%>
<%
String recordOffice="";
if(medExamObj.getRecordoffice()!=null){
	recordOffice=medExamObj.getRecordoffice();
}
if(recordOffice.equalsIgnoreCase("")){
	if(visit.getHin()!=null){
		if(visit.getHin().getRecordOfficeAddress()!=null){
			recordOffice=visit.getHin().getRecordOfficeAddress().getAddress();
		}
	}	
}
%>
 <label>Record Office</label>
  <input	type="text" value="<%=recordOffice%>" name="<%=RECORDOFFICE%>"	maxlength="20" tabindex="1" readonly="readonly" validate="Record Office,metacharSpacBrac,no"/>
<div class="clear"></div>
 <label>Ceased Duty on</label>
<%if(medExamObj.getCeaseduty()!=null)
 { %>
  <input class="date" type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getCeaseduty())%>" name="<%=CEASEDDUTY%>"	tabindex="1" maxlength="20" validate="Ceased Duty on,date,no"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=CEASEDDUTY %>,event);" />

 <% }else{%>
   <input	type="text" id="ceasedDuty"  name="<%=CEASEDDUTY%>"	tabindex="1" maxlength="20" class="date" onKeyUp="mask(this.value,this,'2,5','/');" validate="Ceased Duty on,date,no" onblur="validateExpDate(this,'ceasedDuty');" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=CEASEDDUTY %>,event);" />
 <% }%>
 <label>Past Medical History  </label>
<%if(medExamObj.getPastmedicalhistory()!=null)
 { %>
 <textarea tabindex="1" name="<%=PAST_MEDICAL_HISTORY %>" onkeyup="chkLength(this,500);" validate="Past Medical History,metachar,no"><%=medExamObj.getPastmedicalhistory() %></textarea>
 <% }else{%>
   <textarea tabindex="1" name="<%=PAST_MEDICAL_HISTORY %>" onkeyup="chkLength(this,500);" validate="Past Medical History,metachar,no"></textarea>
 <% }%>
 <div class="clear"></div>
<label>Present Med Cat </label>
<select 	name="<%=PRESENT_MEDICAL_CATEGORY %>"	validate="Med Category,metachar,no" tabindex=1>
	<option value="0">Select</option>
	<%
	int presentMedicalCategory=0;
	
		if(medExamObj.getPresentMedicalCategory()!=null)
		{
			presentMedicalCategory=medExamObj.getPresentMedicalCategory().getCategoryid();
		}	
	if(presentMedicalCategory==0){
		if(visit.getHin().getCategory()!=null){
			presentMedicalCategory=visit.getHin().getCategory().getCategoryid();
		}
	}
	if(categoryList.size()>0){		
		for (Category category : categoryList) {
					if(presentMedicalCategory==category.getCategoryid())
						{
					%>
		<option value="<%=category.getCategoryid()%>" selected="selected" ><%=category.getCategories()%> </option>
		<%}else{
			%>
		<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
		<%	}

					}}	%>
</select>

<%
int ii=0;
for (Category category : categoryList) {
     			 %>
<script>
				categoryMedArray[<%=ii%>]= new Array();
				categoryMedArray[<%=ii%>][0] = "<%=category.getCategoryid()%>";
     			categoryMedArray[<%=ii%>][1] = "<%=category.getCategories()%>";
</script>
<%
++ii;
}%>

 <label>Period  </label>
<% if(medExamObj.getPresentMedPeriod() !=null && !medExamObj.getPresentMedPeriod().equals("")){
 String medCatPeriod=medExamObj.getPresentMedPeriod().substring(0,medExamObj.getPresentMedPeriod().indexOf(" "));
 String medCatDuration = medExamObj.getPresentMedPeriod().substring(medExamObj.getPresentMedPeriod().indexOf(" ")+1);%>
 <input type="text" name="medCatPeriod" id="medCatPeriod" tabindex="1" value="<%=medCatPeriod %>" maxlength="5" class="small" onblur="validateDuration(this.value,'medCatPeriod');"/>
 <select name="medCatDuration" id="medCatDuration" class="small">
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
 <%} %></select>
 <%}else
 if(visit.getHin().getMedCatPeriod() !=null && !visit.getHin().getMedCatPeriod().equals("")){
 String medCatPeriod=visit.getHin().getMedCatPeriod().substring(0,visit.getHin().getMedCatPeriod().indexOf(" "));
 String medCatDuration = visit.getHin().getMedCatPeriod().substring(visit.getHin().getMedCatPeriod().indexOf(" ")+1);%>
 <input type="text" name="medCatPeriod" id="medCatPeriod" value="<%=medCatPeriod %>" maxlength="5" class="small" onblur="validateDuration(this.value,'medCatPeriod');"/>
 <select name="medCatDuration" id="medCatDuration" class="small">
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
 <%} %>
 </select>
 <%}else{%><input type="text" name="medCatPeriod" id="medCatPeriod" value="" maxlength="5" class="small" onblur="validateDuration(this.value,'medCatPeriod');"/>
 <select name="medCatDuration" id="medCatDuration" class="small">
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option></select><%} %>
 <label>Shape Factor</label>
 <%if(medExamObj.getShapFactor() !=null){ %>
 <input type="text" name="shapeFactor" id="shapeFactor" value="<%=medExamObj.getShapFactor() %>" maxlength="19" tabindex="1" validate="Shape Factor,metacharSpacBrac,no" />
 <%}else{ %>
  <input type="text" name="shapeFactor" id="shapeFactor" value="" maxlength="19" tabindex="1" validate="Shape Factor,metacharSpacBrac,no"/>
 <%} %> 
<div class="clear"></div>
<div>
<label>Signature of Individual</label>
<input type="text" disabled="disabled" tabindex="1" />

<label >Date</label>
<% if(medExamObj.getOpiniondate()!=null){%>
<input	tabindex="1" name="<%=OPINION_DATE %>" id="uploadeddate" class="date" 	validate="Date,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getOpiniondate())%>" />

<% }else{%>
<input	tabindex="1" name="<%=OPINION_DATE %>" id="uploadeddate" class="date" 	validate="Date,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date%>" />
<% }%>
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=OPINION_DATE%>,event);" />
</div>

</div>

<div class="clear paddingTop15"></div>
<h4> DETAILS OF PRESENT AND PREVIOUS DISABILITIES <a href="javascript:animatedcollapse.toggle('slide5')"></a>
<div class="floatRight"><input type="button" value="Upload Injury Report" class="buttonBig" onClick="javascript:fileUploadViewWindow('INJ');" /></div>
</h4>

<div class="clear"></div>
<div id="slide5">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
<TH scope="col">Sl No.</TH>
<TH scope="col">Disabilities</TH>
<TH scope="col" colspan="2">Date of Origin</TH>
<TH scope="col" >Place of Origin</TH>
<TH scope="col">Prev Med Cat</TH>
<TH scope="col">Period</TH>
<TH scope="col">Shape Factor</TH>
<TH scope="col" colspan="2">Prev Med Cat Date</TH>
<TH scope="col" colspan="2">Next Med Cat due on</TH>
<%---
<TH scope="col" >Attributability/ Aggravation </TH>
<TH scope="col"> Remarks</TH> --%>
<th></th>
<th></th>
<!--<th>Add</th>
<th>Delete</th>
-->
</tr>
<% int inc1123=0;
if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
{
for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationDetailList){
	if(masMedicalExamDetails.getParticular() !=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("detail")){
	++inc1123;

	%>

<TR>
<td width="10%"><input tabindex="1" size="1" type="text"	name="<%=SIRIAL_NO+inc1123 %>" maxlength="3" value="<%=masMedicalExamDetails.getSerialno() %>"/></td>
<%--
<% if(masMedicalExamDetails.getPrincipal()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PRINCIPAL+inc1123 %>" maxlength="10" value="<%=masMedicalExamDetails.getPrincipal() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PRINCIPAL+inc1123 %>" maxlength="10" /></td>
<% }%>
 --%>
<%
  String principal="";
  if(masMedicalExamDetails.getPrincipal()!=null){
	  principal=masMedicalExamDetails.getPrincipal();
  }
  int icdId=0;
  String icdCode="";
	if(masMedicalExamDetails.getMasIcd()!=null){
		icdId=masMedicalExamDetails.getMasIcd().getId();
		icdCode=masMedicalExamDetails.getMasIcd().getIcdCode();
	}
	/*if(masMedicalExamDetails.getSystemDiagnosis()!=null){
		icdId=masMedicalExamDetails.getSystemDiagnosis().getId();
}*/
	if(principal!=""){
		principal=principal+"["+icdCode+"]"+"["+icdId+"]";
	}
  %>
<td width="10%"> 
 <input type="text" tabindex="1"	value="<%=principal%>" id="<%=PRINCIPAL+inc1123%>"  name="<%=PRINCIPAL+inc1123%>"	class="auto"  size="22" onblur="checkDisability(this.value,<%= inc1123%>);"/>
<div id="ac2updatex2"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
<%--
new Ajax.Autocompleter('<%=PRINCIPAL+inc1123%>','ac2updatex2','medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=<%=PRINCIPAL+inc1123%>'}); --%>
		  new Ajax.Autocompleter('<%=PRINCIPAL+inc1123%>','ac2updatex2','opd?method=getICDForIdList',{parameters:'requiredField=<%=PRINCIPAL+inc1123%>'});
		   //document.getElementById('slide0').style.display="hide"
		   
</script>
</td>


<td width="10%">
<% if(masMedicalExamDetails.getOrigindate()!=null){%>
<input	type="text" tabindex="1" name="<%=ORIGIN_DATE+inc1123 %>" size="11" validate="DOB,date,no" maxlength="11" id="<%=ORIGIN_DATE+inc1123 %>"
value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getOrigindate())%>"	onKeyUp="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'<%=ORIGIN_DATE+inc1123 %>');" />
<% }else{%>
<input	tabindex="1" type="text" name="<%=ORIGIN_DATE+inc1123 %>" size="11" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=ORIGIN_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'<%=ORIGIN_DATE+inc1123 %>');"  />

<% }%>
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=ORIGIN_DATE+inc1123%>,event);" />
</td>
<% if(masMedicalExamDetails.getPlace()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1123 %>" id="place<%=inc1123 %>" maxlength="100" value="<%=masMedicalExamDetails.getPlace() %>" validate="Place1 of Origin,metachar,no"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1123 %>" id="place<%=inc1123 %>" maxlength="100" validate="Place1 of Origin,metachar,no"/></td>
<% }%>

<td>
<select class="medium"	name="<%=PRESENT_MEDICAL_CATEGORY+inc1123%>" id="presentMedCategory<%=inc1123 %>"	validate="Medical Category,string,no" tabindex=1>
	<option value="0">Select</option>
	<%
	int categoryId=0;
	if(masMedicalExamDetails.getCategory()!=null)
	{
		categoryId=masMedicalExamDetails.getCategory().getCategoryid();
	}
	if(categoryId==0){
		if(visit.getHin().getCategory()!=null){
			categoryId=visit.getHin().getCategory().getCategoryid();
		}
	}
			for (Category category : categoryList) {
		/*		String selected="";
				if(masMedicalExamDetails.getCategory()!=null){


				if(masMedicalExamDetails.getCategory().getCategoryid().equals(categoryId))
					{
					selected="selected";
					}
				}*/
				%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%}%>
</select>
<script>

document.getElementById('presentMedCategory<%=inc1123 %>').value='<%=categoryId%>'
</script>
</td>
<td width="10%">
<%if(masMedicalExamDetails.getDisMedCat() !=null){
String medCatPeriod=masMedicalExamDetails.getDisMedCat().substring(0,masMedicalExamDetails.getDisMedCat().indexOf(" "));
String medCatDuration =masMedicalExamDetails.getDisMedCat().substring(masMedicalExamDetails.getDisMedCat().indexOf(" ")+1);%>

<input type="text" name="medCatPeriodDis<%=inc1123 %>" id="medCatPeriodDis<%=inc1123 %>" value="<%=medCatPeriod %>" maxlength="5" class="auto" size="5" tabindex="1" />
 <select name="medCatDurationDis<%=inc1123 %>" id="medCatDurationDis<%=inc1123 %>" class="small">
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
 <%}else{ %> <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option>
 <%} %></select>
 <%}else{ %>
 <input type="text" name="medCatPeriodDis<%=inc1123 %>" id="medCatPeriodDis<%=inc1123 %>" value="" maxlength="5" class="small" tabindex="1" />
 <select name="medCatDurationDis<%=inc1123 %>" id="medCatDurationDis<%=inc1123 %>" class="small">
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option></select>
 <%} %></td>
<td>
<%String shapeFactorDetail="";
if(masMedicalExamDetails.getDisShapeFactor() !=null){
	shapeFactorDetail=masMedicalExamDetails.getDisShapeFactor();
}%>
<input type="text" name="shapeFactorDetail<%=inc1123 %>" id="shapeFactorDetail<%=inc1123 %>"
value="<%=shapeFactorDetail %>"/></td>
<td width="10%">
<% if(masMedicalExamDetails.getMedicalcatdate()!=null){%>
<input	tabindex="1" name="<%=MEDICAL_CAT_DATE+inc1123 %>"  type="text" size="11" value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getMedicalcatdate()) %>" 	validate="DOB,date,no" maxlength="10" id="<%=MEDICAL_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'<%=MEDICAL_CAT_DATE+inc1123 %>');" />
<% }else{%>
<input	tabindex="1" name="<%=MEDICAL_CAT_DATE+inc1123 %>" type="text" size="11" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=MEDICAL_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'<%=MEDICAL_CAT_DATE+inc1123 %>');" />
<% }%>
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" k="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=MEDICAL_CAT_DATE+inc1123%>,event);" />
</td>
<td width="10%">
<% if(masMedicalExamDetails.getNextcatdate()!=null){%>
<input	tabindex="1" name="<%=NEXT_CAT_DATE+inc1123 %>" size="11"  type="text"  value="<%=HMSUtil.convertDateToStringWithoutTime(masMedicalExamDetails.getNextcatdate()) %>" 	validate="DOB,date,no" maxlength="10" id="<%=NEXT_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'<%=NEXT_CAT_DATE+inc1123 %>');" />
<% }else{%>
<input	tabindex="1" name="<%=NEXT_CAT_DATE+inc1123 %>" size="11" type="text" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=NEXT_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'<%=NEXT_CAT_DATE+inc1123 %>');" />
<% }%>
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=NEXT_CAT_DATE+inc1123%>,event);" />
</td>
<%---
<td>
<%
String aggravation="";
if(masMedicalExamDetails.getDisabilityAggravation()!=null){
	aggravation=masMedicalExamDetails.getDisabilityAggravation();
}
%>
<select tabindex="1" name="aggravation<%=inc1123%>" id="aggravation<%=inc1123%>" validate="Attributability/Aggravation,string,no">
<option value="">select</option>
<option value="Attributability">Attributability</option>
<option value="Aggravation">Aggravation</option>
<option value="Nil">Nil</option>
</select>
<script type="text/javascript">
document.MedicalBoardInitialMedExamJsp.aggravation<%=inc1123%>.value='<%=aggravation%>'
</script>
</td>
<td>
<%
String remarks="";
if(masMedicalExamDetails.getDisabilityRemarks()!=null){
	remarks=masMedicalExamDetails.getDisabilityRemarks();
}
%>
<input tabindex="1" type="text" value="<%=remarks%>" maxlength="50" name="remarks<%=inc1123%>" id="remarks<%=inc1123%>" validate="remarks,string,no"/>
</td> as discussed with anshu change by Dipali--%>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowIndividual('grid','hdb',this);" tabindex="1" />
</td>

</TR>
<input type=hidden name="<%=SERVICEID+inc1123 %>" value="<%=masMedicalExamDetails.getServiceid()%>"  />

<%
}}}else{
	++inc1123;
%>
<tr>
<td width="10%"><input tabindex="1" size="2" type="text"	name="<%=SIRIAL_NO+inc1123 %>" value="<%=inc1123 %>" maxlength="3" /></td>
<%--
<td width="10%"><input tabindex="1" type="text"	name="<%=PRINCIPAL+inc1123 %>" maxlength="10" /></td>
 --%>
 <%
 String principal="";
 %>
<td width="10%"> 
 <input type="text" tabindex="1"	value="<%=principal%>" id="<%=PRINCIPAL+inc1123%>"  name="<%=PRINCIPAL+inc1123%>"	class="auto"  size="22" onblur="checkDisability(this.value,<%= inc1123%>);"/>
<div id="ac2updatex2"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
<%-- new Ajax.Autocompleter('<%=PRINCIPAL+inc1123%>','ac2updatex2','medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=<%=PRINCIPAL+inc1123%>'}); --%>

		  new Ajax.Autocompleter('<%=PRINCIPAL+inc1123%>','ac2updatex2','opd?method=getICDForIdList',{parameters:'requiredField=<%=PRINCIPAL+inc1123%>'});
		   //document.getElementById('slide0').style.display="hide"
</script>
</td>
<td width="10%">
<input	tabindex="1" name="<%=ORIGIN_DATE+inc1123 %>" size="11" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=ORIGIN_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=ORIGIN_DATE+inc1123%>,event);" />
</td>

<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE+inc1123 %>" maxlength="100" id="place<%=inc1123 %>" Place of Origin/></td>
<%-- <td width="10%"><input tabindex="1" type="text"	name="<%=FROM+inc1123 %>" maxlength="10" /></td>--%>
<td>
<select 	name="<%=PRESENT_MEDICAL_CATEGORY+inc1123%>" id="presentMedicalCategory<%=inc1123 %>" class="medium"	validate="Medical Category,string,no" tabindex=1>
	<option value="0">Select</option>
	<%
			for (Category category : categoryList) {
				String selected="";
				if(presentMedicalCategory==category.getCategoryid())
				{
			%>
<option value="<%=category.getCategoryid()%>" selected="selected" ><%=category.getCategories()%> </option>
<%}else{
	%>
<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
<%	}
			}
	%>			
</select>
</td>
<td width="10%">
<input type="text" name="medCatPeriodDis<%=inc1123 %>" id="medCatPeriodDis<%=inc1123 %>" value="" maxlength="5" class="auto" size="5" tabindex="1" />
 <select name="medCatDurationDis<%=inc1123 %>" id="medCatDurationDis<%=inc1123 %>" class="small">
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option></select></td>
<td><input type="text" name="shapeFactorDetail<%=inc1123 %>" id="shapeFactorDetail<%=inc1123 %>"/></td>
<td width="10%">
<input	tabindex="1" name="<%=MEDICAL_CAT_DATE+inc1123 %>" size="11" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=MEDICAL_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />

</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=MEDICAL_CAT_DATE+inc1123%>,event);" />
</td>

<td width="10%">
<input	tabindex="1" name="<%=NEXT_CAT_DATE+inc1123 %>" size="11" value="<%=date %>" 	validate="DOB,date,no" maxlength="10" id="<%=NEXT_CAT_DATE+inc1123 %>"
	onKeyUp="mask(this.value,this,'2,5','/');" />
</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=NEXT_CAT_DATE+inc1123%>,event);" />
</td>
<%---
<td>
<select tabindex="1" name="aggravation<%=inc1123%>" id="aggravation<%=inc1123%>" validate="Attributability/Aggravation,string,no">
<option value="">select</option>
<option value="Attributability">Attributability</option>
<option value="Aggravation">Aggravation</option>
<option value="Nil">Nil</option>
</select>
</td>
<td>
<input tabindex="1" type="text" name="remarks<%=inc1123%>" id="remarks<%=inc1123%>" validate="remarks,string,no"/>

</td>as discussed with anshu change by Dipali--%>
<td>

<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowIndividual('grid','hdb',this);" tabindex="1" />
</td>

</TR>

<% }%>
<input type=hidden name="hdb" value="<%=inc1123%>" id="hdb" />
</table>
</div>
</div>
<div class="clear paddingp15"></div>
<%--<div class="Block">

<h4>Specialist Opinion<a href="javascript:animatedcollapse.toggle('slide4')"></a></h4>
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:FileUploadWindow();" />
<input type="hidden" name="flag1" value="" id="flag1" />
<input name="view" type="button" class ="button" value="ViewDocuments" onClick="javascript:ViewDocumentWindow();"/>
</div>
<div class="clear paddingTop15"></div>
<% if(visit.getMedExamType().equalsIgnoreCase("Initial Medical Board AFMSF 15")){%>
<div class="clear paddingTop15"></div>
<h4>Case Summary <a href="javascript:animatedcollapse.toggle('slide4')"></a></h4>
<div class="clear"></div>
<div id="slide4">
<div class="Block">

<label > Disability Attributable <br /><span class="sublabel">(to service)</span></label>
<select name=<%=DISABILITY%> size="0" tabindex="1" id="disability" class="small" onchange="changeRemark()">
	<option value="0">select</option>
	<option value="Yes">Yes</option>
	<option value="No">No</option>
</select>
<script>
<%
if(medExamObj.getDisability()!= null){
%>
document.getElementById('disability').value='<%=medExamObj.getDisability()%>';

<%}%>
</script>


<% if(medExamObj.getDisabilityAttribute() != null && medExamObj.getDisability().equalsIgnoreCase("Yes")){ %>
<label> Remarks</label>
<input  type="text" id="disabilityAttributableDesc" name=<%=DISABILITY_ATTRIBUTABLE_DESC%>  value="<%=medExamObj.getDisabilityAttribute()%>"  class="Auto" size="25" maxlength="100" />
<%}%>
<div id="disattribute" style="display: none">
<label>Remarks</label>
<input  type="text" id="disabilityAttributableDesc" name=<%=DISABILITY_ATTRIBUTABLE_DESC%> class="Auto"  size="25" maxlength="100" />
</div>
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:FileUploadWindow();" />
<label>Case Summary</label>

	<% if(medExamObj.getCaseSheet() != null){ %>
 <textarea tabindex="1" name="<%=CASE_SHEET %>" onkeyup="chkLength(this,100);"><%=medExamObj.getCaseSheet()%></textarea>
<%}else{ %>
 <textarea tabindex="1" name="<%=CASE_SHEET %>" onkeyup="chkLength(this,100);"></textarea>

	<%} %>



<div class="clear"></div>
<label > Aggravated <br /><span class="sublabel">by Service)</label>
<select name=<%=AGGRAVATED_SERVICE_LABEL%> size="0" tabindex="1" id="aggravated" class="small" onchange="changeRemark1()">
	<option value="0">select</option>
	<option value="Yes">Yes</option>
	<option value="No">No</option>
</select>
<script>
<%
if(medExamObj.getAggravatedService()!= null){
%>
document.getElementById('aggravated').value='<%=medExamObj.getAggravatedService()%>';

<%}%>
</script>
<% if(medExamObj.getAggravatedServiceDesc() != null && medExamObj.getAggravatedService().equalsIgnoreCase("Yes")){ %>
<label>Remarks</label>
<input  type="text" name=<%=AGGRAVATED_SERVICE_DESC%> id="<%=AGGRAVATED_SERVICE_DESC%>" value="<%=medExamObj.getAggravatedServiceDesc()%>" class="Auto" size="25" maxlength="100" />
<%}%>
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:FileUploadWindow();" />
<input type="hidden" name="flag"
	value="Upload" id="flag">
<div id="aggravatedid" style="display: none">
<label >Remark</label>
<input tabindex="1" type="text" name=<%=AGGRAVATED_SERVICE_DESC%> id="<%=AGGRAVATED_SERVICE_DESC%>" class="Auto" size="100" maxlength="100" />
</div>

</div>
<% }%>
--%>

<div class="clear paddingTop15"></div>
<h4>Dental <a href="javascript:animatedcollapse.toggle('slide3')"></a></h4>
<div class="clear"></div>
<div id="slide3">
<div class="Block">
<div class="clear"></div>
<% if(medExamObj.getDentalValue()!=null){%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value="<%=medExamObj.getDentalValue()%>"/>
<% }else if(opdPatientDetails!=null && opdPatientDetails.getDentalValue()!=null){%>
<input type="hidden" name="dentalValue" id="dentalValueId" value="<%=opdPatientDetails.getDentalValue()%>" /> 
<% }else{%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value=""/>
<%} %>
<label >Total No. of Teeth</label>
  <% if(medExamObj.getTotalTeeth()!=null){%>
 <input tabindex="1"	type="text"   name="<%=TOTAL_NO_OF_TEETH %>" class="small" value="<%=medExamObj.getTotalTeeth() %>"	onKeyUp="isNumber(this)" maxlength="2" />
 <% }else if(opdPatientDetails!=null && opdPatientDetails.getNoOfTeeth()!=null){
	 %>
<input 	tabindex="1" type="text" name="<%=TOTAL_NO_OF_TEETH %>" class="small" value="<%=opdPatientDetails.getNoOfTeeth() %>" onKeyUp="isNumber(this)" readonly="readonly"	maxlength="2" /> 
 <%}else{%>
<input tabindex="1"	type="text"  name="<%=TOTAL_NO_OF_TEETH %>" class="small"	onKeyUp="isNumber(this)" maxlength="2" />

 <% }%>


<label >Total Defective Teeth</label>
 <% if(medExamObj.getTotalDefectiveTeeth()!=null){%>
<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" value="<%=medExamObj.getTotalDefectiveTeeth() %>"	onKeyUp="isNumber(this)" maxlength="2" />
 <% }else if(opdPatientDetails!=null && opdPatientDetails.getNoOfDefectiveTeeth()!=null){%> 
 <input	tabindex="1" type="text" name="<%=DEFECTIVE_TEETH %>" class="small" readonly="readonly"	value="<%=opdPatientDetails.getNoOfDefectiveTeeth()%>"	onKeyUp="isNumber(this)" maxlength="2" /> 
	<% }else{%>
<input tabindex="1"	type="text"  name="<%=DEFECTIVE_TEETH %>" class="small"	onKeyUp="isNumber(this)" maxlength="2" />
 <% }%>
 
<label class="">Total No. of Dental Points</label>
<% if(medExamObj.getDenstlPoint()!=null){%>
<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>" class=""  value="<%=medExamObj.getDenstlPoint() %>"
onKeyUp="isNumber(this);" maxlength="2" />

 <% }else if(opdPatientDetails!=null && opdPatientDetails.getNoOfDentalPoints()!=null){%> 
 <input	tabindex="1" type="text" name="<%=DENTSL_POINT %>"
		value="<%=opdPatientDetails.getNoOfDentalPoints() %>" onKeyUp="isNumber(this);" readonly="readonly"
		maxlength="2" /> 
	<% }else{%>
<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>" class=""	onKeyUp="isNumber(this);" maxlength="2" />
 <% }%>

	<div class="clear"></div>

<label >Missing </label>
	<% if(medExamObj.getMissingTeeth()!=null){%>
<input tabindex="1" type="text" name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);"
	 value="<%=medExamObj.getMissingTeeth() %>"	maxlength="2" />
 <% }else if(opdPatientDetails!=null && opdPatientDetails.getMissingTeeth()!=null){%> 
 <input	tabindex="1" type="text" name="<%=MISSING_TEETH %>" class="small"
		onKeyUp="isNumber(this);" value="<%=opdPatientDetails.getMissingTeeth() %>" readonly="readonly"		maxlength="2" />
<% }else{%>
<input tabindex="1" type="text" name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);"	maxlength="2" />
 <% }%>

<label >Unsaveable</label>

<% if(medExamObj.getUnservisableTeeth()!=null){%>
<input	tabindex="1" type="text"   name="<%=MISSING_UNSERVICABLE_TEETH %>" value="<%=medExamObj.getUnservisableTeeth() %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }else  if(opdPatientDetails!=null && opdPatientDetails.getUnSaveableTeeth()!=null){%>
 <input tabindex="1" type="text" name="<%=MISSING_UNSERVICABLE_TEETH %>"
		value="<%=opdPatientDetails.getUnSaveableTeeth() %>" class="small" readonly="readonly"
		onKeyUp="isNumber(this);" maxlength="2" /> 
<% }else{%>
<input	tabindex="1" type="text"  name="<%=MISSING_UNSERVICABLE_TEETH %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }%>
 <label>Condition of Gums</label>
<% if(medExamObj.getConditionOfGums()!=null){%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" value="<%=medExamObj.getConditionOfGums() %>"	 onchange="return CheckAlpha(event);"  id="txtAlpha" maxlength="30"  size="6" validate="Condition Of Gums,Alphabetic,Yes" />
 <% }else if(opdPatientDetails!=null && opdPatientDetails.getConditionOfGums()!=null){%>
 <input tabindex="1" type="text" name="<%=CONDITION_OF_GUMS %>"	value="<%=opdPatientDetails.getConditionOfGums() %>" onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="100" readonly="readonly"	validate="Condition Of Gums,Alphabetic,Yes" /> 
<% }else{%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" value="Healthy" onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="30" validate="Condition Of Gums,Alphabetic,Yes"  size="6" />

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
	<label>Dental Officer </label> 

 <input type="text" 	value="<% if(medExamObj.getDentalOfficer()!=null) {out.print(medExamObj.getDentalOfficer());} %>"	name="DentalOfficer" maxlength="200" tabindex="2"  validate="DentalOfficer,string,yes" />
 
	<label>Dental Checkup Date</label> <%if(medExamObj.getDentalCheckupDate()==null)
{%> <input tabindex="1" type="text" name="<%=DENTAL_CHECKUP_DATE %>"
	class="calDate" maxlength="10" class="auto"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
	validate="Dental Checkup Date,date,no" /> <% }else{%> <input tabindex="1"
	type="text" name="<%=DENTAL_CHECKUP_DATE %>" class="calDate" maxlength="10"
	disabled="disabled" onKeyUp="mask(this.value,this,'2,5','/');"
	value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDentalCheckupDate()) %>"
	validate="Dental Checkup Date,date,no" /> <% }%> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DENTAL_CHECKUP_DATE%>,event);" />
<div class="clear"></div>
<label> Remarks</label>
 <%
if(medExamObj.getRemarksTeath()!=null){%>
 <textarea rows="" cols="62" name="<%=DENTAL_REMARKS %>" class="auto" onkeyup="chkLength(this,250);" value="<%=medExamObj.getRemarksTeath() %>" validate="Place of Origin,metachar,no"><%=medExamObj.getRemarksTeath() %></textarea>
<% }else if(opdPatientDetails!=null && opdPatientDetails.getMissingTeethRemark()!=null){%> 
<textarea rows="" cols="60" maxlength="299"	name="<%=DENTAL_REMARKS %>" class="auto"  readonly="readonly"		onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" onKeyDown="return checkMaxLength(this)" validate="Place of Origin,metachar,no"	onkeyup="chkLength(this,299);" 	value="<%=medExamObj.getRemarksTeath() %>"><%=opdPatientDetails.getMissingTeethRemark()  %></textarea>
<% }else{%>
 <textarea rows="" cols="62"	name="<%=DENTAL_REMARKS %>" class="auto" onkeyup="chkLength(this,250);"></textarea>
 <% }%>
<%
if(medExamObj.getReferToMH()!=null && medExamObj.getReferToMH().equalsIgnoreCase("yes")){
%>
<input tabindex="1" type="checkbox"	name="refferToMh" value="" class="radioAuto" id="dentalReferId" checked="checked" 
onclick="checkDentalReferToMH();" />
<%}else{ %>
<input tabindex="1" type="checkbox"	name="refferToMh" value="" class="radioAuto" id="dentalReferId" 
onclick="checkDentalReferToMH();" />
<%} %>
	<label class="medium">Refer to MH</label>
	<%
if(medExamObj.getReferToMH()!=null && medExamObj.getReferToMH().equalsIgnoreCase("yes")){
%>
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:fileUploadViewWindow('DEN');" 
style="display: inline;" id="dentalDivId"/>
<%} else{%>
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:fileUploadViewWindow('DEN');" 
style="display: none" id="dentalDivId"/><%} %>
	<div class="clear"></div>
	<div class="clear"></div>
	</div>
</div>

<div class="clear paddingTop15"></div>


<h4> PHYSICAL CAPACITY <a href="javascript:animatedcollapse.toggle('slide1')"></a></h4>
<div class="clear"></div>
<div id="slide1">
<div class="Block">
<label>Height</label>
  <% if(medExamObj.getHeight()!=null){%>
<input tabindex="1" type="text"   id="height" class="auto" size="10"	name="<%=HEIGHT_WITHOUT_SHOOSE %>"  value="<%=medExamObj.getHeight() %>"
	maxlength="6" onblur="calculateIdealWeight();checkForWiegth(this.value,id);;calculateBMI();" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"   id="height"	class="auto" size="10"	name="<%=HEIGHT_WITHOUT_SHOOSE %>"
	maxlength="6" onblur="calculateIdealWeight();checkForWiegth(this.value,id);;calculateBMI();" /><label class="unit">cm</label>

 <% }%>

<label>Weight</label>
  <% if(medExamObj.getActualweight()!=null){%>
<input tabindex="1" type="text"  id="weight" class="auto"	name="<%=ACTUAL_WEIGHT %>" maxlength="6" value="<%=medExamObj.getActualweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();calculateOverWeight();" size="10"/><label class="unit">kg</label>

 <% }else{%>
<input tabindex="1" type="text"   id="weight" class="auto"	name="<%=ACTUAL_WEIGHT %>" maxlength="6"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();calculateOverWeight();" size="10" /><label class="unit">kg</label>

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

<label>Ideal Weight</label>
  <% if(medExamObj.getIdealweight()!=null){
	  System.out.println(medExamObj.getIdealweight()+"---medExamObj.getIdealweight()");
  %>
<input tabindex="1" type="text"   id="idealWeightId" name="<%=IDEAL_WEIGHT %>" class="auto" size="10"	maxlength="6" value="<%=medExamObj.getIdealweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateOverWeight();" /><label class="unit">kg</label>

 <% }else{ System.out.println(medExamObj.getIdealweight()+"-ELSE--medExamObj.getIdealweight()");%>
<input tabindex="1" type="text" maxlength="20"  id="idealWeightId" name="<%=IDEAL_WEIGHT %>" class="auto" size="10"	maxlength="6"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateOverWeight();" /><label class="unit">kg</label>

 <% }%>


<label>Over Weight</label>
  <% if(medExamObj.getOverweight()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>" class="auto" size="10"	maxlength="6" value="<%=medExamObj.getOverweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">%</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>"  class="auto" size="10"	maxlength="6"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">%</label>

 <% }%>
<label>BMI</label>
  <% if(medExamObj.getBhi()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="bmi" name="<%=BHI %>" maxlength="6" value="<%=medExamObj.getBhi() %>"
	onKeyUp="limitText(this,6);" class="auto" size="10"  />
	<label class="unit">kg/m<sup>2</sup></label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="bmi" name="<%=BHI %>" maxlength="6"
	onKeyUp="limitText(this,6);" class="auto" size="10"  />
	<label class="unit">kg/m<sup>2</sup></label>

 <% }%>
 <div class="clear"></div>
 <label>Body Fat</label>
  <% if(medExamObj.getBodyfat()!=null){%>
<input tabindex="1" type="text" class="auto" size="10" maxlength="20"  id="" name="<%=BODY_FAT %>"maxlength="6" value="<%=medExamObj.getBodyfat() %>"
	onKeyUp="limitText(this,6);"  />

 <% }else{%>
<input tabindex="1" type="text" class="auto" size="10" maxlength="20"  id="" name="<%=BODY_FAT %>" maxlength="6"
	onKeyUp="limitText(this,6);"  />

 <% }%>
<input type="text" class="transparent" size="6">
<label>Waist</label>
  <% if(medExamObj.getWaist()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6" value="<%=medExamObj.getWaist() %>"
	onKeyUp="limitText(this,6);" onblur="calculateWHR();" class="auto" size="10" />
	<label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6"
	onKeyUp="limitText(this,6);"  onblur="calculateWHR();" class="auto"  size="10" />
  <label class="unit">cm</label>
 <% }%>
 <label>Hip</label>
  <% if(medExamObj.getHips()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="hips" name="Hips" maxlength="6" value="<%=medExamObj.getHips() %>"
	onKeyUp="limitText(this,6);"  onblur="calculateWHR();" class="auto" size="10" />
	<label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="hips" name="Hips" maxlength="6"
	onKeyUp="limitText(this,6);"  onblur="calculateWHR();" class="auto" size="10"  />
	<label class="unit">cm</label>

 <% }%>
  <div class="clear"></div>
<label>WHR</label>
  <% if(medExamObj.getWhr()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="WHR" name="WHR" maxlength="6" value="<%=medExamObj.getWhr() %>"
	onKeyUp="limitText(this,6);" class="auto" size="10" />

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="WHR" name="WHR" maxlength="6"
	onKeyUp="limitText(this,6);" class="auto" size="10"  />

 <% }%>
<input type="text" class="transparent" size="6">
<label>Skin Fold Thickness</label>
  <% if(medExamObj.getSignfoldthickness()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="" name="<%=THICKNESS %>" maxlength="6" value="<%=medExamObj.getSignfoldthickness() %>"
	onKeyUp="chkLength(this,6);" class="auto" size="10" />
<label class="unit">cm</label>
 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="" name="<%=THICKNESS %>" maxlength="6"
	onKeyUp="chkLength(this,6);" class="auto" size="10"  />
<label class="unit">cm</label>
 <% }%>
<label>Chest Full Expansion</label>
  <% if(medExamObj.getChestfullexpansion()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" 	 maxlength="6" value="<%=medExamObj.getChestfullexpansion() %>"
	onKeyUp="chkLength(this,6);" class="auto" size="10" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" 	 maxlength="6"
	onKeyUp="chkLength(this,6);" class="auto" size="10" /><label class="unit">cm</label>

 <% }%>
 <div class="clear"></div>
<label>Range of Expansion</label>
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6" value="<%=medExamObj.getRangeofexpansion() %>"
	onKeyUp="chkLength(this,6);" class="auto" size="10" />
<label class="unit">cm</label>
 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6"
	onKeyUp="chkLength(this,6);" class="auto" size="10" />
   <label class="unit">cm</label>
 <% }%>

<label>Sportsman</label>
<select name="<%=SPORTS %>"  id="<%=SPORTS %>" validate="Sports Man,stirng,no" class="smaller"  >
<option value="No">No</option>
<option value="Yes">Yes</option>

</select>
<script type="text/javascript">
<% if(medExamObj.getSportman()!=null){%>
document.getElementById('sport').value = '<%=medExamObj.getSportman()%>'
<%}%>
</script>

 <div class="clear"></div>

</div>
</div>

<div class="clear paddingTop15"></div>


<h4> Vision <a href="javascript:animatedcollapse.toggle('slide6')"></a></h4>
<div class="clear"></div>
<div id="slide6">
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

  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="9" value="<%=medExamObj.getWthoutGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="9" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="9" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="9" />
 <% }%>
 </td>

		<td>Without Glasses</td>
			<td width="10%">

  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="9" value="<%=medExamObj.getWithoutGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="9" value="<%=medExamObj.getWithoutGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="9" />
 <% }%>
 </td>
 	<td width="10%" rowspan="2">

  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithoutGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>

	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%">

  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="1" type="text"  	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="1" type="text"  name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>

		<td>With Glasses</td>
			<td width="10%">

  <% if(medExamObj.getWithGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text"  	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>
 	<%-- <td width="10%">

  <% if(medExamObj.getNearVisionWithGlassCp()!=null){%>

 <input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithGlassCp()%>"/>
 <% }else{%>

<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>--%>

	</tr>

</table>

	</div>

<div class="clear paddingTop15"></div>

<h4> Hearing <a	href="javascript:animatedcollapse.toggle('slide7')"></a></h4>
<div class="clear"></div>
<div id="slide7">
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
			<input tabindex="1" size="10" type="text"   id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
			<%}else{ %>
			<input tabindex="1" size="10" type="text"  id="hrfw" name="<%=HEARING_R_F_W %>" value="600" onkeyup="isNumber1(this)"	maxlength="6"  onblur="checkForWiegth(this.value,id);" />
			<%} %>
			cm
		</td>

		<td>
			<% if(medExamObj.getEarHearingLfw() != null){ %>
			<input tabindex="1" size="10" type="text"  id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
			<%}else{ %>
			<input tabindex="1" size="10" type="text"  id="hrfw" name="<%=HEARING_L_F_W %>" value="600" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />
			<%} %>
			cm
		</td>

		<td>
			<% if(medExamObj.getEarHearingBothFw() != null){ %>
			<input tabindex="1"  size="10" type="text" size="" maxlength="10" id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
			<%}else{ %>
			<input tabindex="1"  size="10" type="text"  id="bothfw" size="" maxlength="10"	value="600" name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);"/>
			<%} %>
			cm

		</td>
		</tr>


	<tr>
		<th>CV</th>
		<td>

<% if(medExamObj.getHearingRcv() != null){ %>
 <input tabindex="1" size="10" type="text"  id="hrcv" name="<%=HEARING_R_C_V %>" value="<%= medExamObj.getHearingRcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />

<%}else{ %>
	 <input tabindex="1" size="10" type="text" value="600"  id="hrcv" name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);"  />

	<%} %>
	cm
</td>

		<td>
			<% if(medExamObj.getHearingLcv() != null){ %>
	  <input tabindex="1" size="10" type="text" maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" value="<%= medExamObj.getHearingLcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />

	  <%}else{ %>
	    <input tabindex="1" size="10" type="text" maxlength="20" value="600"  id="hlcv" name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />

	  <%} %>
	  cm


		</td>

		<td>

	  	 <% if(medExamObj.getHearingBothCv() != null){ %>
	  <input tabindex="1" size="10" type="text"  maxlength="10"  id="bothcv" name="<%=HEARING_BOTH_CV %>" value="<%= medExamObj.getHearingBothCv()  %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />

<%}else{ %>
 <input tabindex="1" size="10" type="text" value="600" maxlength="10"  id="bothcv" name="<%=HEARING_BOTH_CV %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />

<%} %>
cm
		</td>
		</tr>

	<tr>
	<th>TM</th>
<%
String tmr="";
String tml="";
String mobility_r="Normal";
String mobility_l="Normal";
String noseThroatSinuses="NAD";
String audiometryRecord="Not Done";
if(medExamObj.getTympanicR() != null){
	tmr=medExamObj.getTympanicR();
}
if(medExamObj.getTympanicL() != null){
	tml=medExamObj.getTympanicL();
}
if(medExamObj.getMobilityR()!=null){
	mobility_r=medExamObj.getMobilityR();
}
if(medExamObj.getMobilityL()!=null){
	mobility_l=medExamObj.getMobilityL();
}
if(medExamObj.getNoseThroatSinuses() !=null){
	noseThroatSinuses=medExamObj.getNoseThroatSinuses();
}
if(medExamObj.getAudiometryRecord()!=null){
	audiometryRecord=medExamObj.getAudiometryRecord();
}
%>
<td>
<select name="<%=TYMPANIC_R %>" id="<%=TYMPANIC_R%>" tabindex="1" class="small2"  size="0" validate="TYMPANIC_R , metachar,no" >
<option value="Intact">Intact</option>
	<option value="Not Intact">Not Intact</option>
	</select>
<script type="text/javascript">
<%
if(!tmr.equals("")){
%>
document.getElementById('<%=TYMPANIC_R%>').value = '<%=tmr%>'
<%}%>
</script>
</td>
<td>
<select name="<%=TYMPANIC_L %>" id="<%=TYMPANIC_L %>" class="small2" size="0" tabindex="1"  validate="TYMPANIC_L , metachar,no">
<option value="Intact">Intact</option>
	<option value="Not Intact">Not Intact</option>
	</select>
<script type="text/javascript">
<%
if(!tml.equals("")){
%>
document.getElementById('<%=TYMPANIC_L%>').value = '<%=tml%>'
<%}%>
</script>
	</td>
	<td></td>
</tr>

<tr>
<th>Mobility</th>
<td>
<input tabindex="1" type="text" size="10" name="<%=MOBILITYR %>" id="<%=MOBILITYR %>" maxlength="99" value="<%=mobility_r%>" validate="Mobility R , Alphabetic,no" />
</td>
<td >
<input tabindex="1" type="text" size="10"  name="<%=MOBILITYL %>" id="<%=MOBILITYL %>" maxlength="99"  value="<%=mobility_l%>" validate="Mobility L , Alphabetic,no" />
</td>
<td></td>
</tr>

	</table>





<div class="Block">
<div class="clear"></div>
<%--
<label>FWR</label>
<% if(medExamObj.getEarHearingRfw() != null){ %>
<input tabindex="1" class="small" type="text"  class="auto" id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()   %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<label class="unit">cm</label>
	<%}else{ %>
	<input tabindex="1" class="small" type="text"  id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"	maxlength="6"  onblur="checkForWiegth(this.value,id);" />
	<label class="unit">cm</label>

	<%} %>
	--%>
	<%--<label>FWL</label>
<% if(medExamObj.getEarHearingLfw() != null){ %>
<input tabindex="1" class="small" type="text"  id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<label class="unit">cm</label>
	<%}else{ %>
	<input tabindex="1" class="small" type="text"  id="hrfw" name="<%=HEARING_L_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />
	<label class="unit">cm</label>
	<%} %>--%>
<%--
	<label>FW BOTH</label>
	<% if(medExamObj.getEarHearingBothFw() != null){ %>
	<input tabindex="1"  class="small" type="text" size="10" maxlength="10" id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	<label class="unit">cm</label>
<%}else{ %>
		<input tabindex="1"  class="small" type="text"  id="bothfw" size="10" maxlength="10"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);"/>
	<label class="unit">cm</label>
	<%} %>--%>

<div class="clear"></div>
<%--
<label>CVR</label>
<% if(medExamObj.getHearingRcv() != null){ %>
 <input tabindex="1" class="small" type="text"  id="hrcv" name="<%=HEARING_R_C_V %>" value="<%= medExamObj.getHearingRcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
 <label class="unit">cm</label>
<%}else{ %>
	 <input tabindex="1" class="small" type="text"   id="hrcv" name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);"  />
	 <label class="unit">cm</label>
	<%} %>
	 <label >CVL</label>

	 <% if(medExamObj.getHearingLcv() != null){ %>
	  <input tabindex="1" class="small" type="text" maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" value="<%= medExamObj.getHearingLcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	  <label class="unit">cm</label>
	  <%}else{ %>
	    <input tabindex="1" class="small" type="text" maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	    <label class="unit">cm</label>
	  <%} %>
	  <label>CV BOTH </label>
	  	 <% if(medExamObj.getHearingBothCv() != null){ %>
	  <input tabindex="1" class="small" type="text" size="10" maxlength="10"  id="bothcv" name="<%=HEARING_BOTH_CV %>" value="<%= medExamObj.getHearingBothCv()  %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	  <label class="unit">cm</label>
<%}else{ %>
 <input tabindex="1" class="small" type="text" size="10" maxlength="10"  id="bothcv" name="<%=HEARING_BOTH_CV %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
 <label class="unit">cm</label>
<%} %>

--%>
<div class="clear"></div>
<%--
<label >TMR</label>
<%
String tmr="";
String tml="";
String mobility_r="";
String mobility_l="";
String noseThroatSinuses="";
String audiometryRecord="";
if(medExamObj.getTympanicR() != null){
	tmr=medExamObj.getTympanicR();
}
if(medExamObj.getTympanicL() != null){
	tml=medExamObj.getTympanicL();
}
if(medExamObj.getMobilityR()!=null){
	mobility_r=medExamObj.getMobilityR();
}
if(medExamObj.getMobilityL()!=null){
	mobility_l=medExamObj.getMobilityL();
}
if(medExamObj.getNoseThroatSinuses()!=null){
	noseThroatSinuses=medExamObj.getNoseThroatSinuses();
}
if(medExamObj.getAudiometryRecord()!=null){
	audiometryRecord=medExamObj.getAudiometryRecord();
}
%>

<select name="<%=TYMPANIC_R %>" id="<%=TYMPANIC_R%>" tabindex="1" class="small2"  size="0" maxlength="20">
<option value="0">Intact</option>
	<option value="Y">Y</option>
	<option value="N">N</option>
	</select>
<script type="text/javascript">
document.getElementById('<%=TYMPANIC_R%>').value = '<%=tmr%>'
</script>

<label >TML</label>
<select name="<%=TYMPANIC_L %>" id="<%=TYMPANIC_L %>" class="small2" size="0" maxlength="20" tabindex="1" >
<option value="0">Intact</option>
	<option value="Y">Y</option>
	<option value="N">N</option>
	</select>
<script type="text/javascript">
document.getElementById('<%=TYMPANIC_L%>').value = '<%=tml%>'
</script>
--%>

<div class="clear"></div>
<label >Nose,Throat &amp; Sinuses</label>
<input tabindex="1" type="text" name="<%=NOSE_THROAT_SINUSES%>" id="<%=NOSE_THROAT_SINUSES%>" size="15" class="" 
value="<%=noseThroatSinuses%>" maxlength="49" validate="NOSE_THROAT_SINUSES,metacharSpac,no" />

<label >Audiometry Record</label>
<input tabindex="1" type="text" name="<%=AUDIOMETRY_RECORD%>" id="<%=AUDIOMETRY_RECORD%>" class="" value="<%=audiometryRecord%>" size="16" maxlength="49"
validate="AUDIOMETRY_RECORD,metacharSpac,no" />
<%--
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:FileUploadWindow();" />
 --%>
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:fileUploadViewWindow('HEA');" />
</div>
</div>

<%	int count=1;
    if(getDgOrderdts!=null)
    {

	for(DgOrderdt dgOrderdt : getDgOrderdts){
	%>
	 <input type="hidden" value="<%=dgOrderdt.getId()%>" name="dgOrderdtId<%=count%>" id="dgOrderdtId<%=count%>" validate="dgOrderdtId,metachar,no"/>

<%count++;}
    }
%>

<!-- fayaz added -->
<% if(visit.getHin() !=null){%>
<INPUT type=hidden value="<%=visit.getHin().getHinNo()%>" name="hinNoForreport" id="hinNoForreport" validate="hinNoForreport,metachar,no"/>
<% }%>
<input type="hidden" value="" name="deleatedValue" id="deleatedValue" />
<input type="hidden" value="" name="deleatedorderid" id="deleatedorderid" />
<div class="clear paddingTop15"></div>
<h4>Investigation <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div id="slide5">
<div class="Block">
<label >Template</label>
<div id="investigationDiv">
<select name="investigationTemplateId"	tabindex="1" onchange="showHideInvestigationTemplateCombo(this.value);" validate="Template,metachar,no" >
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
<div id="createInvestigationDivToShowHide">
<input	name="investigationTemplate" type="button"	value="Create Template" tabindex="1" class="buttonBig" onclick="showCreateInvestigationTemplate();" />
</div>
<div id="copyPrevInvestigationTemplateDiv" style="display: none">
<input name="copyPrevInvestigationTemplate" tabindex="1" type="button"	value="Copy Previous" class="buttonBig"  />
</div>

<div id="investigationImportButton1" >
<input	name="investigationImportButton1" tabindex="1" type="button"	value="IMPORT" class="buttonBig"	onclick="getListForTreatment('investigationDiv');" />
</div>


<input name="Prevoius" type="button" tabindex="2" value="Prev Investigations"	class="buttonBig"	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />

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
<td><input type="text" name="clinicalNotes1" tabindex="1" value="<%=dgOrderhd.getClinicalNote() %>" size="100" maxlength="45" /></td>
<%}else{ %>
<td><input type="text" name="clinicalNotes1" tabindex="1" value="For Medical Board" size="100" maxlength="45" /></td>
<%} %>
</tr>
</table>
<div class="clear paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid">
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
{ %>
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
<%
}else{%>
<input type="hidden"  name="dgOrderhdId" id="dgOrderhdId" />
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

<%}%>
	
	<td>
	<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD/ View" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
	</td>
	<%}else{

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
	    	 <td>
 <input tabindex="1" type="checkbox" name="investigationReferToMH<%=inc %>" value="y" checked="checked"
	id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);" disabled="disabled"/></td>
<td><input type="text" value=""  tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD/ View" style="display: inline"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
<% 	    	}else
            { %>
             <td>
            <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc%>" value="n"  id="investigationReferToMH<%=inc %>"
	onclick="checkForInvestigationMH(<%=inc %>);"/>
   </td>
    <td><input type="text" value="" readonly="readonly"	 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD/ View" style="display: none"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
            <%
             }
	    	}else
	    	{ %>
 <td>
	<input tabindex="1" type="checkbox"	name="investigationReferToMH<%=inc %>" value="y"  
	id="investigationReferToMH<%=inc %>" onclick="checkForInvestigationMH(<%=inc %>);" />
   </td>
    <td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
        </td>
        <td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD/ View" style="display: none"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
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
 <input tabindex="1" type="checkbox" name="investigationReferToMH<%=inc %>" value="n"
	id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/></td>
<td><input type="text" value="" readonly="readonly"	 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD/ View" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
<% }%><% }%>
<!-- style="display: none;" -->

<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation(this);" /></td>
	</tr>
	<% inc++;
		    }%>

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
		<!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->
<%--<input type="hidden" value="0" name="dgOrderdtId1" id="dgOrderdtId1" /> --%>
		</td>
	<td>
<input tabindex="1" type="checkbox"
	name="investigationReferToMH1" value="n" id="investigationReferToMH1" onclick="checkForInvestigationMH(1);" />
</td>
<td>
<input type="text" value="" readonly="readonly" name="Result1" id="Result1" size="65" />
</td>
<!-- style="display: none;"  -->
<td><input name="uploadReport1" id="uploadReport1" type="button"  class="button" value="UPLOAD/ View" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(1);" /></td>

<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation(this);" /></td>
	</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<% }%>
</table>
</div>
</div>

<input type="hidden" id="investigationDataStatus" name="investigationDataStatus" value="no"/>
<div class="Clear paddingTop15"></div><%--

<h4> CARDIO VASCULAR SYSTEM <a	href="javascript:animatedcollapse.toggle('slide6')"></a></h4>
<div class="clear"></div>
<div id="slide6">
<div class="Block">
<div class="clear"></div>

<label>Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input tabindex="1" type="text" maxlength="10"  name="<%=PULSE_RATES%>" class="auto" size="17" maxlength="10"  value="<%=medExamObj.getPulseRates() %>"/>
  <label class="small">/min</label>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="10"  name="<%=PULSE_RATES%>" class="auto" size="17" maxlength="10" value="Normal" /><label class="small">/min</label>
 <% }%>

 <label class="medium">BP</label>
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" maxlength="10"  name="<%=BP1%>" class="auto" size="17" maxlength="10"  value="<%=medExamObj.getBp() %>"/>

 <label class="small">mm Hg</label>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="10"  name="<%=BP1%>" class="auto" size="17" maxlength="10" value="Normal"/>

 <label class="small">mm Hg</label>
 <% }%>

<label>Peripheral Pulsations</label>
<% if(medExamObj.getArterialWalls()!=null){%>
<input tabindex="1" type="text" maxlength="10" 	name="<%= ARTERIAL_WALLS%>" class="auto" size="20" maxlength="10"  value="<%=medExamObj.getArterialWalls() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="10" 	name="<%= ARTERIAL_WALLS%>" class="auto" size="20" maxlength="10" value="Normal" />
 <% }%>


<div class="clear"></div>


<label>Heart Size</label>
<% if(medExamObj.getHeartSize()!=null){%>
<input tabindex="1" type="text" maxlength="17" 	name="<%= HEART_SIZE%>" class="auto" size="17" maxlength="10" value="<%=medExamObj.getHeartSize() %>"/>
 <label class="small">&nbsp;</label>
 <% }else{%>
<input tabindex="1" type="text" maxlength="17" 	name="<%= HEART_SIZE%>" class="auto" size="17" maxlength="10" value="Normal" />
  <label class="small">&nbsp;</label>
 <% }%>


 <label class="medium">Sounds</label>
 <% if(medExamObj.getSounds()!=null){%>
 <input tabindex="1" type="text" maxlength="10"  name="<%= SOUND%>" class="auto"	size="17" maxlength="10" value="<%=medExamObj.getSounds() %>"/>
 <label class="small">&nbsp;</label>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="10"  name="<%= SOUND%>" class="auto"	size="17" maxlength="10" value="Normal" />
  <label class="small">&nbsp;</label>
 <% }%>


<label>Rhythm</label>
<% if(medExamObj.getRhythm()!=null){%>
 <input tabindex="1" type="text" maxlength="10"  name="<%= RHYTHM%>" class="auto"	size="20" maxlength="10" value="<%=medExamObj.getRhythm() %>"/>

 <% }else{%>
 <input tabindex="1" type="text" maxlength="10"  name="<%= RHYTHM%>" class="auto"	size="20" maxlength="10" value="Regular" />
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
  <input tabindex="1" type="text" maxlength="10" 	name="<%=RESPIRATORY_SYSTEM %>" class="auto" size="120" maxlength="100" value="<%=medExamObj.getRespiratorySystem() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" maxlength="10" 	name="<%=RESPIRATORY_SYSTEM %>" class="auto" size="120" maxlength="100" value="Normal"/>
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

<label > Liver Palpalable</label>
<% if(medExamObj.getLiver()!=null){%>
  <input tabindex="1" type="text" maxlength="10" 	name="liver" class="auto" size="120" maxlength="100" value="<%=medExamObj.getLiver() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" maxlength="10" 	name="liver" class="auto" size="120" maxlength="100" value="Not Palpable"/>
 <% }%>
<div class="clear"></div>


<label> Spleen Palpalable</label>
<% if(medExamObj.getSpleen()!=null){%>
  <input tabindex="1" type="text" maxlength="10" 	name="spleen" class="auto" size="120" maxlength="100" value="<%=medExamObj.getSpleen() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" maxlength="10" 	name="spleen" class="auto" size="120" maxlength="100" value="Not Palpable"/>
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
<input tabindex="1" type="text" maxlength="10" 	name="<%=HIGHER_MENTAL_FUNCTION %>"  maxlength="10" value="<%=medExamObj.getHigherMentalFunction() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="10" 	name="<%=HIGHER_MENTAL_FUNCTION %>"  maxlength="10" value="Normal" />
 <% }%>

<label > Speech</label>
<% if(medExamObj.getSpeech()!=null){%>
<input tabindex="1" type="text" maxlength="10" 	name="<%=SPEECH %>"  maxlength="10" value="<%=medExamObj.getSpeech() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="10" 	name="<%=SPEECH %>"  maxlength="10" value="Normal"/>
 <% }%>
<label > Reflexes</label>
<% if(medExamObj.getReflexes()!=null){%>
<input tabindex="1" type="text" maxlength="10" 	name="<%=REFLEXES %>"  maxlength="10" value="<%=medExamObj.getReflexes() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="10" 	name="<%=REFLEXES %>"  maxlength="10" value="Normal" />
 <% }%>
<div class="clear"></div>
<label > Tremors</label>
<select name="<%=TREMORS %>" size="0" tabindex="1" id="tremors">
<option value="0">select</option>
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
<select name="<%=SELF_BALANCING_TEST %>" size="0" tabindex="1" id="selfbalancingtest">
<option value="0">select</option>
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


<label >Locomoter System</label>
<% if(medExamObj.getLocomoterSystem()!=null){%>
<input tabindex="1" type="text" name="locomoterSystem" class="auto" size="20" maxlength="10" value="<%=medExamObj.getLocomoterSystem() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="locomoterSystem" class="auto" size="20" maxlength="10" value="NAD" />
 <% }%>


<label>Spine</label>
<% if(medExamObj.getSpine()!=null){%>
<input tabindex="1" type="text" name="spine" class="auto" size="20" maxlength="10" value="<%=medExamObj.getSpine() %>"/>
   <% }else{%>

<input tabindex="1" type="text" name="spine" class="auto" size="20" maxlength="10" value="NAD" />
 <% }%>


<label>Hernia</label>
<% if(medExamObj.getHerniaMusic()!=null){%>
<input tabindex="1" type="text"  name="<%=HERNIA_MUSCLE %>" class="auto" size="20" maxlength="10" value="<%=medExamObj.getHerniaMusic() %>"/>
   <% }else{%>

<input tabindex="1" type="text" name="<%=HERNIA_MUSCLE %>" class="auto" size="20" maxlength="10" value="Nil"/>
 <% }%>


<div class="clear"></div>
<label>Hydrocele</label>
<% if(medExamObj.getHydrocele()!=null){%>
<input tabindex="1" type="text" name="<%=HYDROCELE %>" class="auto" size="20" maxlength="10" value="<%=medExamObj.getHydrocele() %>"/>
   <% }else{%>

<input tabindex="1" type="text" name="<%=HYDROCELE %>" class="auto" size="20" maxlength="10" value="Nil"/>
 <% }%>


<label>Haemorrhoids</label>
<% if(medExamObj.getHemorrhoids()!=null){%>
<input tabindex="1" type="text" name="<%=HEMONHOIDS %>" class="auto" size="20" maxlength="10" value="<%=medExamObj.getHemorrhoids() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=HEMONHOIDS %>" class="auto" size="20" maxlength="10" value="Nil"/>
 <% }%>


<label>Breast</label>
<% if(medExamObj.getBreasts()!=null){%>
<input tabindex="1" type="text" name="<%=BREASTS %>" class="auto" size="20" maxlength="10" value="<%=medExamObj.getBreasts() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=BREASTS %>" class="auto" size="20" maxlength="10" value="NAD"/>
 <% }%>


<div class="clear"></div>

</div>
</div>--%>
<%
	if(!visit.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){
%>
<h4>GYNAECOLOGY EXAM <a href="javascript:animatedcollapse.toggle('slide10')"></a></h4>
<div class="clear"></div>
<div id="slide10">
<div class="Block">
<label >Menstrual History</label>
<% if(medExamObj.getMenstrualHistory()!=null){%>
<input tabindex="1" type="text"	name="<%=MENSTRUAL_HISTORY %>" class="auto" size="20" maxlength="29" value="<%=medExamObj.getMenstrualHistory() %>"/>
   <% }else{%>
<input tabindex="1" type="text"	name="<%=MENSTRUAL_HISTORY %>" class="auto" size="20" maxlength="29" />
 <% }%>


<label>LMP</label>
<% if(medExamObj.getLmp()!=null){%>
<input tabindex="1" type="text"  name="<%=LMP%>" class="date" size="20" maxlength="10" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLmp())%>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=LMP%>" class="date" size="20" maxlength="10" />
 <% }%>
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=LMP%>,event);" />
<label >No. of Pregnancies</label>
<% if(medExamObj.getNoOfPregnancies()!=null){%>
<input tabindex="1" type="text" name="<%=NO_OF_PREGNANCY %>" class="" size="20" maxlength="3" value="<%=medExamObj.getNoOfPregnancies() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=NO_OF_PREGNANCY %>" class="" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>

<div class="clear"></div>
<label >No. of Abortions</label>
<% if(medExamObj.getNoOfAbortions()!=null){%>
<input tabindex="1" type="text" id="noofabo"	name="<%=NO_OF_ABORTION %>" class="auto" size="20" maxlength="3" value="<%=medExamObj.getNoOfAbortions() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text" id="noofabo"	name="<%=NO_OF_ABORTION %>" class="auto" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>
<label >No. of Children</label>
<% if(medExamObj.getNoOfChildren()!=null){%>
<input tabindex="1" type="text" 	name="<%=NO_OF_CHILDREN %>" class="" size="20" maxlength="3" value="<%=medExamObj.getNoOfChildren() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text"  	name="<%=NO_OF_CHILDREN %>" class="" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>

<label >Last Confinement on</label>
<% if(medExamObj.getLastConfinementDate()!=null){%>
<input tabindex="1" type="text"  class="calDate" readonly="readonly " value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLastConfinementDate()) %>"	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" />
   <% }else{%>
<input tabindex="1" type="text"  class="calDate" readonly="readonly "	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" />
 <% }%>
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DATE_OF_LASTCONFINEMENT%>,event);" />
<div class="clear"></div>
<label >Vaginal Discharge</label>
<% if(medExamObj.getVaginalDischarge()!=null){%>
<input tabindex="1" type="text" 	name="<%=VAGINAL_DISCHARGE %>" class="auto" size="20" maxlength="49" value="<%=medExamObj.getVaginalDischarge() %>"/>
   <% }else{%>
<input tabindex="1" type="text" value="Nil"	name="<%=VAGINAL_DISCHARGE %>" class="auto" size="20" maxlength="49" />
 <% }%>


<label	>Prolapse</label>
<% if(medExamObj.getProlapse()!=null){%>
<input tabindex="1" type="text" 	name="<%=PROLAPSE %>" class="" size="20" maxlength="9" value="<%=medExamObj.getProlapse() %>"/>
   <% }else{%>
<input tabindex="1" type="text" value="Nil"	name="<%=PROLAPSE %>" class="" size="20" maxlength="9" />
 <% }%>

<label >USG Abdomen</label>
<% if(medExamObj.getUsgAbdomen()!=null){%>
<input tabindex="1" type="text" name="<%=USG_ABORTION %>" class="" size="20" maxlength="9" value="<%=medExamObj.getUsgAbdomen() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=USG_ABORTION %>" value="Not Done" class="" size="30" maxlength="9" />
 <% }%>
 <div class="clear"></div>
 <input class="transparent" size="150"/>
 <input name="Send" type="button"  class="button" value="Upload/ View" onClick="javascript:fileUploadViewWindow('GYN');" />
<%--
<input name="Send" type="button"  class="button" value="Upload" onClick="javascript:FileUploadWindowGynaecology();" />
--%>
</div>
</div>

<%
	}
int inc11234=0;
 %>
<div class="clear"></div>
<%--
<div class="clear paddingTop15"></div>
<div class="Block">
<label >Medical Categ. Now</label>
 <select 	name="<%= PRESENT_MEDICAL_CATEGORY %>"	validate="Signed By,string,no" tabindex=1>
<option value="0">Select</option>
<%
if( medExamObj.getPresentMedicalCategory()!=null)
{
		for (Category category : categoryList) {
			if( medExamObj.getPresentMedicalCategory().getCategoryid().equals(category.getCategoryid()))
				{
			%>
<option value="<%=category.getCategoryid()%>"  selected="selected"><%=category.getCategories()%> </option>
<%}}}else{
	for (Category category : categoryList) {
%>
<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
<%	}}
		%>
</select>

<label >Duration</label>
<% if(medExamObj.getMonthlySerialNo() != null){ %>
<input tabindex="1" type="text" name="MonthlySerialNo"  class="Auto" size="20" maxlength="20" value="<%=medExamObj.getMonthlySerialNo() %>"/>
	  <%}else{ %>
<input tabindex="1" type="text" name="MonthlySerialNo"  class="Auto" size="20" maxlength="20" />
	  <%} %>

<label >Place Of <br /> <span class="sublabel">(Next Categorization Board)</span></label>
<% if(medExamObj.getCategoryplace() != null){ %>
<input tabindex="1" type="text" name=<%=CATEGORIZATION_PLACE%>  class="Auto" size="20" maxlength="20" value="<%=medExamObj.getCategoryplace() %>"/>
	  <%}else{ %>
<input tabindex="1" type="text" name=<%=CATEGORIZATION_PLACE%>  class="Auto" size="20" maxlength="20" />
	  <%} %>

<div class="clear"></div>
<label >Date Of <br /> <span class="sublabel">(Next Categorization Board)</span></label>
<% if(medExamObj.getCategorydate() != null){ %>
<input	tabindex="1" name="<%=CATEGORIZATION_DATE %>" 	validate="Entry Date,date,no" value="<%=date %>" maxlength="10" class="date"	onKeyUp="mask(this.value,this,'2,5','/');" value=<%=medExamObj.getCategorydate() %>/>
	  <%}else{ %>
<input	tabindex="1" name="<%=CATEGORIZATION_DATE %>" 	validate="Entry Date,date,no" value="<%=date %>" maxlength="10" class="date"	onKeyUp="mask(this.value,this,'2,5','/');" />
	  <%} %>
  <img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" onclick="setdate('',MedicalBoardInitialMedExamJsp.<%=DOB%>,event);" />

<label >Opinion Of Medical Board</label>
<% if(medExamObj.getDocumentForwardTo() != null){ %>
<input tabindex="1" type="text" name="<%=DOCUMENT_FORWARD_TO %>"  class="Auto" size="20" maxlength="20" value="<%=medExamObj.getDocumentForwardTo() %>"/>
	  <%}else{ %>
<input tabindex="1" type="text" name="<%=DOCUMENT_FORWARD_TO %>" class="Auto" size="20" maxlength="20" />
	  <%} %>

<label >Disssent Notes</label>
<% if(medExamObj.getArmsCorps() != null){ %>
<input tabindex="1" type="text" name=<%=ARMS_CROPS%>  class="Auto" size="20" maxlength="20" value="<%=medExamObj.getArmsCorps() %>"/>
	  <%}else{ %>
<input tabindex="1" type="text" name=<%=ARMS_CROPS%>  class="Auto" size="20" maxlength="20" />
	  <%} %>
</div>
<div class="clear paddingTop15"></div>
<h4>PERCENTAGE OF DISABILITY(ONLY FOR PERMANENT LMC) <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div class="clear"></div>
<div id="slide5">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="disabilitygrid">
	<tr>

<TH scope="col">Disability%</TH>
<TH scope="col">ICD Code</TH>
<TH scope="col">Disability Group</TH>
<TH scope="col">Previous Disability%</TH>
<TH scope="col" >Present Disability%</TH>
<TH scope="col">Reason</TH>
<th>Add</th>
<th>Delete</th>
</tr>
<% int inc11234=0;
String valuefound="false";
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	if(setMedicalExam.getParticular() !=null && setMedicalExam.getParticular().equalsIgnoreCase("particular")){
		inc11234=inc11234+1;
		valuefound="true";
	%>

<TR>
<td width="10%">
<select name="<%=DISABILITYID+inc11234 %>" id="<%=DISABILITYID+inc11234 %>" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j=0;

	 for(Disability masrank : disabilityList){
		 	if ((setMedicalExam.getDisability()!=null)&&(masrank.getDisabilityid()==(setMedicalExam.getDisability().getDisabilityid()))) {
		 	%>
		 <option value="<%=masrank.getDisabilityid ()%>" selected="selected"><%=masrank.getDisability()%>
		 </option>
		 <%}else{

		 %><option value="<%=masrank.getDisabilityid()%>"><%=masrank.getDisability()%>
		 	</option>
		 	<script>
		 	disabilityListArray[<%=j%>]= new Array();
		 	disabilityListArray[<%=j%>][0] = "<%=masrank.getDisabilityid()%>";
		 	disabilityListArray[<%=j%>][1] = "<%=masrank.getDisability()%>";
            </script>
		 	<%	}
		 	j=j+1;
		 	}%>
    </select>
    </td>
<td width="10%">
<select name="<%=ICDID+inc11234 %>" id="<%=ICDID+inc11234 %>" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j1=0;

	 for(MasIcd masrank : masIcdList){
		 	if ((setMedicalExam.getMasIcd()!=null)&&(masrank.getId()==(setMedicalExam.getMasIcd().getId()))) {%>
		 <option value="<%=masrank.getId()%>" selected="selected"><%=masrank.getIcdName()%>
		 </option>
		 <%}else{%><option value="<%=masrank.getId()%>"><%=masrank.getIcdName()%>
		 	</option>
		 	<script>
		 	masIcdListArray[<%=j1%>]= new Array();
		 	masIcdListArray[<%=j1%>][0] = "<%=masrank.getId()%>";
		 	masIcdListArray[<%=j1%>][1] = "<%=masrank.getIcdName()%>";
            </script>
		 	<%	}
		 	j1=j1+1;
		 	}%>
    </select>
    </td>
    <td width="10%">
<select name="<%=DISABILITYGROUPID+inc11234 %>" id="<%=DISABILITYGROUPID+inc11234 %>" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j3=0;

	 for(Disabilitygroup masrank : disabilitygroupList){
		 	if ((setMedicalExam.getDisabilitygroup()!=null)&&(masrank.getGroupid()==(setMedicalExam.getDisabilitygroup().getGroupid()))) {%>
		 <option value="<%=masrank.getGroupid()%>" selected="selected"><%=masrank.getDiseaseGroups()%>
		 </option>
		 <%}else{%><option value="<%=masrank.getGroupid()%>"><%=masrank.getDiseaseGroups()%>
		 	</option>
		 	<script>
		 	disabilitygroupListArray[<%=j3%>]= new Array();
		 	disabilitygroupListArray[<%=j3%>][0] = "<%=masrank.getGroupid()%>";
		 	disabilitygroupListArray[<%=j3%>][1] = "<%=masrank.getDiseaseGroups()%>";
            </script>
		 	<%	}
		 	j3=j3+1;
		 	}%>
    </select>
    </td>


<% if(setMedicalExam.getIllness()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11234 %>" id="<%=ILLNESS+inc11234 %>" maxlength="10" value="<%=setMedicalExam.getIllness() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11234 %>"  id="<%=ILLNESS+inc11234 %>" maxlength="10" /></td>
<% }%>
<td width="10%">
<% if(setMedicalExam.getPlace1()!=null){%>
<input	tabindex="1" name="<%=PLACE1+inc11234 %>" type="text" value="<%=setMedicalExam.getPlace1()%>" 	 maxlength="10" id="<%=PLACE1+inc11234 %>" />
<% }else{%>
<input	tabindex="1" name="<%=PLACE1+inc11234 %>" type="text"  	 maxlength="10" id="<%=PLACE1+inc11234 %>" />
<% }%>
</td>

<td width="10%">
<% if(setMedicalExam.getTreated()!=null){%>
<input	tabindex="1" name="<%=TREATED+inc11234 %>" type="text" value="<%=setMedicalExam.getTreated()%>" 	 maxlength="10" id="<%=TREATED+inc11234 %>"/>
<% }else{%>
<input	tabindex="1" name="<%=TREATED+inc11234 %>" type="text"  	 maxlength="10" id="<%=NEXT_CAT_DATE+inc11234 %>" />
<% }%>
</td>



<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addDisability();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeDisability();" tabindex="1" />
</td>

</TR>
<input type=hidden name="<%=SERVICEID+inc11234 %>" value="<%=setMedicalExam.getServiceid()%>"  />

<%
	}}}
if(valuefound.equalsIgnoreCase("false")){
	inc11234=inc11234+1;
	%>
<tr>
<td width="10%">
<select name="<%=DISABILITYID+inc11234 %>" id="<%=DISABILITYID+inc11234 %>"  validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j=0;
	 for(Disability masrank : disabilityList){
		 %><option value="<%=masrank.getDisabilityid()%>"><%=masrank.getDisability()%>
		 	</option>
		 	<script>
		 	disabilityListArray[<%=j%>]= new Array();
		 	disabilityListArray[<%=j%>][0] = "<%=masrank.getDisabilityid()%>";
		 	disabilityListArray[<%=j%>][1] = "<%=masrank.getDisability()%>";
            </script>
		 	<%
		 	j=j+1;
		 	}%>
    </select>

</td>
<td width="10%">
<select name="<%=ICDID+inc11234 %>" id="<%=ICDID+inc11234 %>" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j1=0;

	 for(MasIcd masrank : masIcdList){
	%><option value="<masrank.getId()%>"><%=masrank.getIcdName()%>
		 	</option>
		 	<script>
		 	masIcdListArray[<%=j1%>]= new Array();
		 	masIcdListArray[<%=j1%>][0] = "<%=masrank.getId()%>";
		 	masIcdListArray[<%=j1%>][1] = "<%=masrank.getIcdName()%>";
            </script>
		 	<%
		 	j1=j1+1;
		 	}%>
    </select>

    </td>
    <td width="10%">
<select name="<%=DISABILITYGROUPID+inc11234 %>" id="<%=DISABILITYGROUPID+inc11234 %>" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j3=0;

	 for(Disabilitygroup masrank : disabilitygroupList){
	%><option value="<%=masrank.getGroupid()%>"><%=masrank.getDiseaseGroups()%>
		 	</option>
		 	<script>
		 	disabilitygroupListArray[<%=j3%>]= new Array();
		 	disabilitygroupListArray[<%=j3%>][0] = "<%=masrank.getGroupid()%>";
		 	disabilitygroupListArray[<%=j3%>][1] = "<%=masrank.getDiseaseGroups()%>";
            </script>
		 	<%
		 	j3=j3+1;
		 	}%>
    </select>
    </td>


<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11234 %>" id="<%=ILLNESS+inc11234 %>"  maxlength="10" /></td>
<td width="10%">
<input	tabindex="1" name="<%=PLACE1+inc11234 %>" type="text"  	 maxlength="10" id="<%=PLACE1+inc11234 %>" />
</td>

<td width="10%">
<input	tabindex="1" name="<%=TREATED+inc11234 %>" type="text"  	 maxlength="10" id="<%=TREATED+inc11234 %>" />
</td>


<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addDisability();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeDisability();" tabindex="1" />
</td>

</TR>

<% }%>
<input type="hidden" name="hdb1" value="<%=inc11234%>" id="hdb1" />
</table>
</div>
</div>
<div class="clear paddingTop15"></div>

<div class="Block">

<label >Any Restriction <br /> <span class="sublabel">(Regarding Employment)</span></label>
<% if(medExamObj.getRestrictionemployment() != null){ %>
<input tabindex="1" type="text" name=<%=RESTRICTION_EMPLOYMENT%>  class="Auto" size="20" maxlength="20" value="<%=medExamObj.getRestrictionemployment() %>"/>
	  <%}else{ %>
<input tabindex="1" type="text" name=<%=RESTRICTION_EMPLOYMENT%>  class="Auto" size="20" maxlength="20" />
	  <%} %>
<label >Instruction Given to <br /> <span class="sublabel">(Indvidual By the President of the Board)</span></label>
<% if(medExamObj.getInstructionByPresident() != null){ %>
<input tabindex="1" type="text" name=<%=INSTRUCTION_BY_PRESIDENT%>  class="Auto" size="20" maxlength="20" value="<%=medExamObj.getInstructionByPresident() %>"/>
	  <%}else{ %>
<input tabindex="1" type="text" name=<%=INSTRUCTION_BY_PRESIDENT%>  class="Auto" size="20" maxlength="20" />
	  <%} %>
	 <input tabindex="1" type="hidden"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10"  class="Auto"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
		validate="Reported Date,date,no" />


<div class="clear"></div>
</div>
	 <input tabindex="1" type="hidden"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10"  class="Auto"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
		validate="Reported Date,date,no" />
--%>
<input type="hidden" name="hdb1" value="<%=inc11234%>" id="hdb1" />
<div class="clear"></div>
<div class="Block">
<label> Medical Officer</label> 
<%
if(Labresult.equalsIgnoreCase("present")){ %>
<select	name="medicalOfficer" id="moId" validate="Medical Officer,String,no" tabindex="1" >
	<option value="0">Select</option>
	<% 
		for (MasEmployee  obj : employeeList){
				String doctorMiddleName = "";
				String doctorLastName = "";
				String rankName ="";
				if(obj.getMiddleName()!= null){
					doctorMiddleName = obj.getMiddleName();
				}
				if(obj.getLastName() != null){
					doctorLastName = obj.getLastName();
				}
				if(obj.getRank() != null){
					rankName = obj.getRank().getRankName();
				}
	%>
	<option value="<%=obj.getId ()%>"><%=rankName+" "+obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<%  
	} %>
</select><%}else{ %>
<select	name="medicalOfficer" id="moId" validate="Medical Officer,String,no" tabindex="1" disabled="disabled">
	<option value="0">Select</option>
	<% 
		for (MasEmployee  obj : employeeList){
				String doctorMiddleName = "";
				String doctorLastName = "";
				String rankName ="";
				if(obj.getMiddleName()!= null){
					doctorMiddleName = obj.getMiddleName();
				}
				if(obj.getLastName() != null){
					doctorLastName = obj.getLastName();
				}
				if(obj.getRank() != null){
					rankName = obj.getRank().getRankName();
				}
	%>
	<option value="<%=obj.getId ()%>"><%=rankName+" "+obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<%  
	} %>
</select>
<%} %>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>

<%if(medExamObj.getId()!=null)
{%>
<input tabindex="1" name="Button"	type="button" class="buttonBig" value="SUBMIT"	onClick="submitForm('MedicalBoardInitialMedExamJsp','medicalBoard?method=updateMedicalExamEntry&Labresult=<%=Labresult.trim() %>&SecialFlag=&directFlag=');" />
<% }else{%>
<input type="button" onclick="submitdata()" value="Submit" class="buttonBig" name="Button" tabindex="1">
<% }%>
<input tabindex="1" class="buttonBig" id=reset accessKey=r	onclick="resetCheck();" type=reset value=Reset name=Reset>
<input tabindex="1" name="Button"	type="button" class="buttonBig" value="Forward To Mo"	
onClick="submitForm('MedicalBoardInitialMedExamJsp','medicalBoard?method=updateMedicalExamEntry&data=farwarded&Labresult=<%=Labresult.trim() %>&SecialFlag=&directFlag=','validateMO');" />
<!-- <input tabindex="1" class=button id=reset accessKey=r	onclick=resetCheck(); type=reset value=Appointment name=Reset> -->
<input name="visitNumberForReport" type="hidden" id="visitNumberForReport" value="<%=visit.getVisitNo()%>" validate="visitNumberForReport,metachar,no" />
<input name="token" type="hidden" id="token" value="<%=visit.getTokenNo()%>" validate="token,metachar,no" /> <%-- add by javed khan --%>

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
<input type="hidden" value="MedicalBoard" name="medicalType" id="hiddenValue" />
</div>
<%if(visit.getDoctor() != null){ %>
<input name="empId" type="hidden" value="<%=visit.getDoctor().getId()%>" />
<%}%>
<%if(visit.getDepartment() != null){
%>
<input name="deptId" type="hidden" value="<%=visit.getDepartment().getId()%>" />
<%}%>
<%if(visit.getHin() != null){
	%>
<input name="hinId" type="hidden" id="hinId" value="<%=visit.getHin().getId()%>"  validate="hinId,metachar,no" />
<%}%>
<%if(visit.getHin() != null){
	%>
<input name="visitId" type="hidden" id="visitId" value="<%=visit.getId()%>" validate="visitId,metachar,no" />
<%}%>
<input type="hidden"  name="MissTeeth" id="MissTeeth" value=""/>
<input type="hidden"  name="UnserTeeth" id="UnserTeeth" value=""/>


<!--Bottom labels starts--> <!--main content placeholder ends here--> <script
	type="text/javascript">
  function validateMO(){
	if(document.getElementById('moId').value=='0'){
		alert("Please select Medical Officer.");
		return false;
	}else{
	return true;
	}
  }
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
	function FileUploadWindowGynaecology()
	{
		var folderName='gynaecology';
			var url="/hms/hms/medicalBoard?method=showUploadingDocumentsJsp&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId()%>&hinNo=<%=visit.getHin().getHinNo()%>&folder="+folderName;
			newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

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
	  var medBoardFlag='Board';
		if(checkTemplateId(valueOfTemplate)){
	  	document.getElementById("copyPrevInvestigationTemplateDiv").style.display='none';
		//submitProtoAjaxWithDivName('MedicalBoardInitialMedExamJsp','/hms/hms/opd?method=showGridForInvestigation','gridview');
		if(validateMetaCharacters(medBoardFlag)){
		submitProtoAjaxWithDivName('MedicalBoardInitialMedExamJsp','/hms/hms/opd?method=showGridForInvestigationMedicalExam&flag='+medBoardFlag,'gridview');
		  }
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
	  newdiv1.id='ac2update'+iteration;
	  newdiv1.className='autocomplete';
	  newdiv1.style.display = 'none';

	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.tabindex='1';
	  //alert("name--"+e0.name)
	  e0.size = '45'
	  cellRight0.appendChild(newdiv1);

	  cellRight0.appendChild(e0);

	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});
	  var sel = document.createElement('input');
	  
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'checkbox';
	  e1.name = 'investigationReferToMH' + iteration;
	  e1.id = 'investigationReferToMH' + iteration;
	  e1.value='n';
	  e1.className = 'radioAuto';
	  e1.tabindex='1';
	  e1.onclick = function(){checkForInvestigationMH(iteration)};
	  cellRight1.appendChild(e1);

	  var cellRight1 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'Result' + iteration;
	  e2.id = 'Result' + iteration;
	  e2.size = '65';
	  e2.readOnly='readonly';
	  e2.maxLength= 20;
	  e2.tabindex='1';
      cellRight1.appendChild(e2);

	  sel.type = 'hidden';
	  sel.name='chargeCode'+iteration;
	  sel.id='chargeCode'+iteration
	  sel.size = '10';
	  sel.tabindex='1';
	  cellRight0.appendChild(sel);
	/*
	* Code by Mukesh
	* Date 01 Feb 2012
	*/
	  var dgOrderDt = document.createElement('input');
	  dgOrderDt.type = 'hidden';
	  dgOrderDt.name='dgOrderdtId'+iteration;
	  dgOrderDt.id='dgOrderdtId'+iteration
	  dgOrderDt.size = '10';
	  dgOrderDt.value = '0';
	  dgOrderDt.tabindex='1';
	  cellRight0.appendChild(dgOrderDt);


	  var patientInvDt = document.createElement('input');
	  patientInvDt.type = 'hidden';
	  patientInvDt.name='patientInvestigationdetailsId'+iteration;
	  patientInvDt.id='patientInvestigationdetailsId'+iteration
	  patientInvDt.size = '10';
	  patientInvDt.value = '0';
	  patientInvDt.tabindex='1';
	  cellRight0.appendChild(patientInvDt);
	  /*
		* End Code by Mukesh
		* Date 01 Feb 2012
		*/
	  var e3 = document.createElement('input');
	  e3.type = 'hidden';
	  e3.name='qty'+iteration;
	  e3.id='qty'+iteration
	  e3.size='10';
	  e3.tabindex='1';
	  cellRight0.appendChild(e3);

	  var cellRight1 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'button';
	  e4.name='uploadReport'+iteration;;
	  e4.id='uploadReport'+iteration;
	  e4.value='UPLOAD/ View';
	  e4.style.display='none';
	  //---Commented by dipali bcz not working for add row
	  //e4.setAttribute('onClick','fileUploadWindowInvestigation(iteration);');
	  //----Added by dipali---
	  e4.onclick = function(){fileUploadWindowInvestigation(iteration)};
	  cellRight1.appendChild(e4);

	 var cellRight1 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonAdd';
	  e4.name='Button';
	  e4.onclick=function(){addRowForInvestigation();};
	  cellRight1.appendChild(e4);

	  var cellRight2 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.name='delete';
	  e5.onclick =function(){removeRowForInvestigation(this);};
	  cellRight2.appendChild(e5);

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
 function removeRowForInvestigation(obj)

	{
	  var tbl = document.getElementById('investigationGrid');
	  document.getElementById('investigationDataStatus').value="yes";
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
		  /*
			* Code By Mukesh
			* Date 31 Jan 2012
			*/
		  var i=obj.parentNode.parentNode.rowIndex;
		  tbl.deleteRow(i);
		  	//tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('investigationGrid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hiddenValue');
	  	hdb.value=iteration

	  }

	  var pid = 0;
	  if(document.getElementById('patientInvestigationdetailsId'+lastRow ))
		  pid =document.getElementById('patientInvestigationdetailsId'+lastRow ).value;

      var dv=document.getElementById('deleatedValue').value;
      var val;

      if(dv=="")
      {
    	  val=pid+",";
	  document.getElementById('deleatedValue').value = val;
      }else{
    	  val=dv+pid+","
    	  document.getElementById('deleatedValue').value = val;
      }

	  var pid1 = 0;
	  if( document.getElementById('dgOrderdtId'+lastRow ))
	  	pid1= document.getElementById('dgOrderdtId'+lastRow ).value;

      var dv1=document.getElementById('deleatedorderid').value;
      var val1;

      if(dv1=="")
      {

    	  val1=pid1+",";
	  document.getElementById('deleatedorderid').value = val1;
      }else{
    	  val1=dv1+pid1+","
    	  document.getElementById('deleatedorderid').value = val1;
      }
	  }
function submitFormForPrescriptionReport(){
	  var hinNoForreport=document.getElementById('hinNoForreport').value;
      <%if(medExamObj.getVisit()!=null){%>
	  var url='/hms/hms/opd?method=showPatientInvestigationReport&visitNumberForReport='+<%=medExamObj.getVisit().getVisitNo()%>+'&hinNoForReport='+hinNoForreport+'&serviceNoForReport='+<%=medExamObj.getVisit().getHin().getServiceNo()%>;
      newwindow=window.open(url,'ar',"left=2,top=100,height=500,width=500,status=1,scrollbars=1,resizable=0");
	<%}%>
	}


 function openPopupForPatientInvestigation(visitNo,hinId){
	  //alert("in pop up window visit No---"+visitNo+"---- hin id ---"+hinId)
	  if(validateMetaCharacters(visitNo) && validateMetaCharacters(hinId)){
	if(visitNo >1){
	var url="/hms/hms/opd?method=showPatientPreviousInvestigation&visitNo="+visitNo+"&hinId="+hinId;
   newwindow=window.open(url,'name','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
   }else{
     alert("This is Patient's First Visit. ")
   }
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
	    submitProtoAjaxWithDivName('MedicalBoardInitialMedExamJsp','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}
 function getListForTreatment(val){
	 var treatFlag='treatment';
	 var investFlag='investigation';
	 	if(val=='investigationDiv'){
		 	if(validateMetaCharacters(investFlag)){
			submitProtoAjaxWithDivName('MedicalBoardInitialMedExamJsp','/hms/hms/opd?method=getListForTreatment&flag='+investFlag,val);
		 	}
		}else if(val=='treatmentDiv'){
			if(validateMetaCharacters(treatFlag)){
			submitProtoAjaxWithDivName('MedicalBoardInitialMedExamJsp','/hms/hms/opd?method=getListForTreatment&flag='+treatFlag,val);
		}
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
	  e0.setAttribute('maxlength', 3);
	  e0.value=hdb.value;
      e0.size = '2';
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);

	  /*
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = 'principal' + iteration;
	  e1.id = 'principal' + iteration;
	  e1.setAttribute('maxlength', 10);
     e1.size = '20';
	  e1.setAttribute('tabindex','1');
     cellRight1.appendChild(e1);
*/
 var cellRight1 = row.insertCell(1);
var e1 = document.createElement('input');
e1.type = 'text';

e1.name = 'principal' + iteration;
e1.id = 'principal' + iteration;
e1.setAttribute('maxlength', 22);
e1.size = '22';
e1.setAttribute('tabindex','1');
e1.onblur=function(){checkDisability(this.value,iteration)};
cellRight1.appendChild(e1);

var newdiv1 = document.createElement('div');
newdiv1.setAttribute('id', 'ac2updatex2'+iteration);
newdiv1.className = 'autocomplete';
newdiv1.style.display = 'none';
cellRight1.appendChild(newdiv1);
cellRight1.appendChild(e1);
//new Ajax.Autocompleter('principal'+iteration,'ac2updatex2'+iteration,'medicalBoard?method=autoCompleteForIcdDiagnosis',{parameters:'requiredField=principal'+iteration});
new Ajax.Autocompleter('principal'+iteration,'ac2updatex2'+iteration,'opd?method=getICDForIdList',{parameters:'requiredField=principal'+iteration});

     var cellRight2 = row.insertCell(2);
	 var e2 = document.createElement('input');
	 e2.type = 'text';
	 e2.name = 'origindate' + iteration;
	 e2.id = 'origindate' + iteration;
     e2.size = '11';
     e2.value= '<%=date%>';
     e2.onkeyup=function(){mask(this.value,this,'2,5','/');} ;
     e2.onblur= function(){validateExpDate(this,'origindate'+iteration);};
     e2.setAttribute('maxlength', 10);
	 e2.setAttribute('tabindex','1');
     cellRight2.appendChild(e2);

     var cellRight3 = row.insertCell(3);
	 var e3 = document.createElement('img');
     e3.src = '/hms/jsp/images/cal.gif';
    // e3.style.display ='none';
     e3.id = 'calId'+iteration;
     e3.onclick = function(event){
     setdate('',document.getElementById('origindate'+iteration),event) };
     cellRight3.appendChild(e3);

     var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name = 'place' + iteration;
	  e4.id = 'place' + iteration;
     e4.size = '20';
     e4.setAttribute('validate','Place of Origin,metachar,no');
     e4.setAttribute('maxlength', 10);
	  e4.setAttribute('tabindex','1');
     cellRight4.appendChild(e4);
     /*
     var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name = 'presentMedicalCategory' + iteration;
	  e5.id = 'presentMedicalCategory' + iteration;
	  e5.setAttribute('maxlength', 10);
      e5.size = '20';
	  e5.setAttribute('tabindex','1');
     cellRight5.appendChild(e5);
*/

     var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('Select');

	  e5.name='presentMedicalCategory'+iteration;
	  e5.id='presentMedicalCategory'+iteration;
	  e5.setAttribute('tabindex','1');
	  e5.className='medium';
	  e5.options[0] = new Option('Select', '0');
  		 for(var i = 0;i<categoryMedArray.length;i++ ){
      e5.options[i+1] = new Option(categoryMedArray[i][1],categoryMedArray[i][0]);
      }
      e5.value='<%=presentMedicalCategory%>'
	  cellRight5.appendChild(e5);

      var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name = 'medCatPeriodDis' + iteration;
	  e6.id = 'medCatPeriodDis' + iteration;
	  e6.size = '5';
	  e6.setAttribute('maxlength', 5);
	  e6.setAttribute('tabindex','1');
	  var e66 = document.createElement('Select');
	  e66.name = 'medCatDurationDis' + iteration;
	  e66.id = 'medCatDurationDis' + iteration;
	  e66.className='small';
	  e66.setAttribute('tabindex','1');
	  e66.options[0] = new Option('Months', 'Months');
	  e66.options[1] = new Option('Weeks', 'Weeks');
	  e66.options[2] = new Option('Days', 'Days');
	  cellRight6.appendChild(e6);
	  cellRight6.appendChild(e66);

     var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name = 'shapeFactorDetail' + iteration;
	  e7.id = 'shapeFactorDetail' + iteration;
	  e7.size = '20';
	  e7.setAttribute('maxlength', 20);
	  e7.setAttribute('tabindex','1');
	  cellRight7.appendChild(e7);


      
     var cellRight8 = row.insertCell(8);
	 var e8 = document.createElement('input');
	 e8.type = 'text';
	 e8.name = 'medicalcatdate' + iteration;
	 e8.id = 'medicalcatdate' + iteration;
	 e8.size = '11';
	 e8.value= '<%=date%>';
	 e8.onkeyup=function(){mask(this.value,this,'2,5','/');} ;
	 e8.onblur= function(){validateExpDate(this,'medicalcatdate'+iteration);};
	 e8.setAttribute('maxlength', 10);
	 e8.setAttribute('tabindex','1');
	 cellRight8.appendChild(e8);

     var cellRight9 = row.insertCell(9);
     var e9 = document.createElement('img');
     e9.src = '/hms/jsp/images/cal.gif';
    // eImg.style.display ='none';
     e9.id = 'calId'+iteration;
     e9.onclick = function(event){
     setdate('',document.getElementById('medicalcatdate'+iteration),event) };
     cellRight9.appendChild(e9);

     var cellRight10 = row.insertCell(10);
	 var e10 = document.createElement('input');
	 e10.type = 'text';
	 e10.name = 'nextcatdate' + iteration;
	 e10.id = 'nextcatdate' + iteration;
	 e10.size = '11';
	 e10.value= '<%=date%>';
	 e10.onkeyup=function(){mask(this.value,this,'2,5','/');} ;
	 e10.onblur= function(){validateExpDate(this,'nextcatdate'+iteration);};
	 e10.setAttribute('maxlength', 10);
	 e10.setAttribute('tabindex','1');
	 cellRight10.appendChild(e10);

     var cellRight11 = row.insertCell(11);
	 var e11 = document.createElement('img');
	 e11.src = '/hms/jsp/images/cal.gif';
	 e11.className = 'calender';
    // eImg.style.display ='none';
     e11.id = 'calId'+iteration;
     e11.onclick = function(event){
     setdate('',document.getElementById('nextcatdate'+iteration),event) };
     cellRight11.appendChild(e11);
/*
     var cellRight10 = row.insertCell(10);
     var e10 = document.createElement('select');
     e10.setAttribute('tabindex','1');
     e10.name='aggravation'+iteration;
     e10.id='aggravation'+iteration;
     e10.options[0] = new Option('select', '');
     e10.options[1] = new Option('Attributability', 'Attributability');
     e10.options[2] = new Option('Aggravation', 'Aggravation');
     e10.options[3] = new Option('Nil', 'Nil');
     cellRight10.appendChild(e10);

        var cellRight11 = row.insertCell(11);
        var e11 = document.createElement('input');
        e11.type = 'text';
        e11.name = 'remarks'+iteration;
        e11.setAttribute('maxlength','50');
        e11.setAttribute('tabindex','1');
        cellRight11.appendChild(e11);
*/
      var cellRight12 = row.insertCell(12);
	  var e12 = document.createElement('input');
	  e12.type = 'button';
	  e12.className = 'buttonAdd';
	  e12.name='remarks'+iteration;
	  e12.onclick=function(){addRow();};
	  e12.setAttribute('tabindex','1');
	  cellRight12.appendChild(e12);

	  var cellRight13 = row.insertCell(13);
	  var e13 = document.createElement('input');
	  e13.type = 'button';
	  e13.className = 'buttonDel';
	  e13.name='remarks'+iteration;
	  e13.onclick = function(){removeRowIndividual("grid","hdb",this);};
	  e13.setAttribute('tabindex','1');
	  cellRight13.appendChild(e13);

	}
 function fileUploadWindowInvestigation(rowVal)
 {
	 var hinNo='<%=visit.getHin().getHinNo()%>';
 	var medicalExamId='<%=medExamId%>';
 	var hinId= document.getElementById('hinId');
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
  	if(validateMetaCharacters(hinNo) && validateMetaCharacters(medicalExamId) && validateMetaCharacters(hinId)  && validateMetaCharacters(invest_id)){
  		<%-- var url="/hms/hms/medicalBoard?method=displayFileUploadInvestigation&hinId=<%=visit.getHin().getId()%>&hinNo="+hinNo+"&invest_id="+invest_id+"&masExamId=<%=medExamId%>"; --%>
  		var url="/hms/hms/medicalBoard?method=displayFileUploadInvestigation&hinId="+hinId+"&hinNo="+hinNo+"&invest_id="+invest_id+"&masExamId="+medicalExamId;
  	}	
  		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
  	}
 }

 function removeRowIndividual(idName,countId,obj)
 {
   var tbl = document.getElementById(idName);
   var lastRow = tbl.rows.length;
   if (lastRow > 2){
   //	tbl.deleteRow(lastRow - 1);
     var i=obj.parentNode.parentNode.rowIndex;
     tbl.deleteRow(i);
   }
 }

	function removeRowForInvestigation(obj)
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
			/*
			* Code By Mukesh
			* Date 31 Jan 2012
			*/
		  var i=obj.parentNode.parentNode.rowIndex;
		  tbl.deleteRow(i);
		  	//tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('investigationGrid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hiddenValue');
	  	hdb.value=iteration

	  }

	  var pid = 0;
	  if(document.getElementById('patientInvestigationdetailsId'+lastRow ))
		  pid = document.getElementById('patientInvestigationdetailsId'+lastRow ).value;

      var dv=document.getElementById('deleatedValue').value;
      var val;

      if(dv=="")
      {
    	  val=pid+",";
	  document.getElementById('deleatedValue').value = val;
      }else{
    	  val=dv+pid+","
    	  document.getElementById('deleatedValue').value = val;
      }

	  var pid1 = 0;
if( document.getElementById('dgOrderdtId'+lastRow ))
	  pid1 = document.getElementById('dgOrderdtId'+lastRow ).value;

      var dv1=document.getElementById('deleatedorderid').value;
      var val1;

      if(dv1=="")
      {
    	  val1=pid1+",";
	  document.getElementById('deleatedorderid').value = val1;
      }else{
    	  val1=dv1+pid1+","
    	  document.getElementById('deleatedorderid').value = val1;
      }
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

	function submitdata()
	{
		var charge=document.getElementById("chargeCodeName1").value;
        if(charge=="")
        {
         alert("Please Select Test Name");
        }else{
        	submitForm('MedicalBoardInitialMedExamJsp','medicalBoard?method=addMedicalBoardInit');
        }
		//{submitForm('MedicalBoardInitialMedExamJsp','medicalBoard?method=addMedicalBoardInit')}
	}
	function changeRemark()
	{
		var disval=document.getElementById("disability").value;
		  if(disval=="Yes")
        {
	    	 document.getElementById("disattribute").style.display= 'inline'
        	        }else{
        	document.getElementById("disattribute").style.display='none'
                }

	}
	function changeRemark1()
	{
		var disval=document.getElementById("aggravated").value;
		  if(disval=="Yes")
        {
	    	 document.getElementById("aggravatedid").style.display= 'inline'
        	        }else{
        	document.getElementById("aggravatedid").style.display='none'
                }

	}
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
	function coolDental()
	{
	 var dentalValue=document.getElementById('dentalValueId').value;
	 //alert(dentalValue);

	 var mySplitResult = dentalValue.split(",");
	 for(i=1;i<mySplitResult.length;i++)
	 {
		 document.getElementById(mySplitResult[i]).checked="checked";
		 messingTeeth(mySplitResult[i]);

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
			uval=uval+" "+name.substring(1,name.length).toUpperCase();
			document.getElementById('UnserTeeth').value=uval;
		}
	}
	<%--
	function FileUploadWindow()
		{  
			var folderName='hearing';

			var url="/hms/hms/medicalBoard?method=showUploadingDocumentsJsp&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId()%>&hinNo=<%=visit.getHin().getHinNo()%>&folder="+folderName;
			newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

			}

	function ViewDocumentWindow()
	  {
		document.getElementById('flag1').value="viewDocuments";
		 <% if(medExamObj.getVisit() != null){%>
		 var url="/hms/hms/medicalBoard?method=displayDocumentView&flag1=viewDocuments&visitId=<%=medExamObj.getVisit().getId()%>&hinNo=<%=medExamObj.getVisit().getHin().getHinNo()%>&hinId=<%=medExamObj.getVisit().getHin().getId()%>";
		 newwindow=window.open(url,'name', "left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");


		 <%}%>
		 }
		 --%>
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

	function addDisability(){
		 var tbl = document.getElementById('disabilitygrid');

		  var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('hdb1');
		  hdb.value=iteration
		  var cellRight1 = row.insertCell(0);
		  var e1 = document.createElement('select');
	      e1.options[0] = new Option('Select', '');
		  e1.name = '<%=DISABILITYID%>'+iteration;
		  e1.id = '<%=DISABILITYID%>' + iteration;
		  var j=1;
		  for(var i = 0;i<disabilityListArray.length;i++ ){
			  e1.options[j] = new Option(disabilityListArray[i][1],disabilityListArray[i][0]);
             j++;
	    	  }

	      cellRight1.appendChild(e1);
	      var cellRight2 = row.insertCell(1);
		  var e2 = document.createElement('select');
	      e2.options[0] = new Option('Select', '');
		  e2.name = 'icdId' + iteration;
		  e2.id = 'icdId' + iteration;
		  var k=1;
		  for(var i = 0;i<masIcdListArray.length;i++ ){
	    	  e2.options[k] = new Option(masIcdListArray[i][1],masIcdListArray[i][0]);
             k++;
	    	  }
	      cellRight2.appendChild(e2);

	      var cellRight3 = row.insertCell(2);
		  var e3 = document.createElement('select');
	      e3.options[0] = new Option('Select', '');
		  e3.name = 'disabilitygroupId' + iteration;
		  e3.id = 'disabilitygroupId' + iteration;
		  var m=1;
		  for(var i = 0;i<disabilitygroupListArray.length;i++ ){
	    	  e3.options[m] = new Option(disabilitygroupListArray[i][1],disabilitygroupListArray[i][0]);
             m++;
	    	  }
	      cellRight3.appendChild(e3);

	      var cellRight4 = row.insertCell(3);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name = 'illness' + iteration;
		  e4.id = 'illness' + iteration;
		  e4.setAttribute('maxlength', 10);
	      e4.size = '20';

		  e4.setAttribute('tabindex','1');
	      cellRight4.appendChild(e4);

	      var cellRight5 = row.insertCell(4);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.name = 'place1' + iteration;
		  e5.id = 'place1' + iteration;
	      e5.size = '20';

	      e5.setAttribute('maxlength', 100);
		  e5.setAttribute('tabindex','1');
	      cellRight5.appendChild(e5);

	      var cellRight6 = row.insertCell(5);
		  var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.name = 'treated' + iteration;
		  e6.id = 'treated' + iteration;
	      e6.size = '20';

	      e6.setAttribute('maxlength', 10);
		  e6.setAttribute('tabindex','1');
	      cellRight6.appendChild(e6);

	      var cellRight7 = row.insertCell(6);
		  var e7 = document.createElement('input');
		  e7.type = 'button';
		  e7.className = 'buttonAdd';
		  e7.name='remarks'+iteration;
		  e7.onClick= function(){addDisability()};
		  e7.setAttribute('tabindex','1');
		  cellRight7.appendChild(e7);

		  var cellRight8 = row.insertCell(7);
		  var e8 = document.createElement('input');
		  e8.type = 'button';
		  e8.className = 'buttonDel';
		  e8.name='remarks'+iteration;
		  e8.onClick = function(){removeDisability();};
		  e8.setAttribute('tabindex','1');
		  cellRight8.appendChild(e8);

		}
		function removeDisability()
		{
		  var tbl = document.getElementById('disabilitygrid');
		  var lastRow = tbl.rows.length;
		  if (lastRow > 2){
		  	tbl.deleteRow(lastRow - 1);
		  	var tbl = document.getElementById('disabilitygrid');
		  	var lastRow = tbl.rows.length;
			  // if there's no header row in the table, then iteration = lastRow + 1
		 	var iteration = lastRow - 1;
		  	var hdb = document.getElementById('hdb1');
		  	hdb.value=iteration
		  }
		}
		function fileUploadViewWindow(flag)
		{
			var medicalExamId='<%=medExamId%>';
		 	if(medicalExamId=='0')
		 	{
		 	 	alert("Please click on Submit to raise requisition for Board");
		 	 	return false;
		 	}else
		 	{
			//flag=HEA Means-->Hearing
			//flag=GYN Means-->GYNAECOLOGY EXAM
			//flag=ALL Means-->ALL Type
<%--		<li><a href="opd?method=showUploadingDocumentsJsp&visitId=<%=visit.getId() %>">Upload Documents </a></li>  --%>
			var visId = document.getElementById('visitId').value;
			if( validateMetaCharacters(visId) && validateMetaCharacters(medicalExamId) && validateMetaCharacters(flag)){
				<%--var url="/hms/hms/medicalBoard?method=showUploadViewDocumentJsp&visitId=<%=visit.getId()%>&medExamId=<%=medExamId%>&flag="+flag; --%>
				var url="/hms/hms/medicalBoard?method=showUploadViewDocumentJsp&visitId="+visId+"&medExamId="+medicalExamId+"&flag="+flag;
				newwindow=window.open(url,'name',"left=0,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
			}
		 	}

		}
		 function openTemplateScreen(index){
		 		var resultId = document.getElementById('resultIdTemplate'+index).value;
		 	//	submitForm('medicalBoardMAForm16','investigation?method=searchPatientForResultValidation&resultId='+resultId+'&flagForLab=fromLab');
		 		if( validateMetaCharacters(resultId)){
		       	var url="/hms/hms/investigation?method=searchPatientForResultValidation&resultId="+resultId+"&flagForLab=fromExam";
			    newwindow=window.open(url,'ar',"left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1");
		 		}
		 }		

function checkDisability(val,inc){
if(val != ""){
		
		var index1 = val.lastIndexOf("[");
		var index = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var id = val.substring(index1,index2);
		var index = index--;
		var disability = val.substring(0,index);		
		if(id == "" ) {
			if(document.getElementById('principal'+inc)){
		      	document.getElementById('principal'+inc).value="";
		      	document.getElementById('origindate'+inc).value="";
		    	document.getElementById('place'+inc).value="";
		   //  document.getElementById('presentMedicalCategory'+inc).value="0";
		    	document.getElementById('medicalcatdate'+inc).value="";
		      	document.getElementById('nextcatdate'+inc).value="";
		    //	document.getElementById('aggravation'+inc).value="";
		    	if(document.getElementById('remarks'+inc))
		    		document.getElementById('remarks'+inc).value="";
			}
	     return false;
		}		
}
}
function openPopupPatientPreviousVisit()
{

	var visId = document.getElementById('visitId').value;
	var visNo= document.getElementById('visitNumberForReport').value;
	var hinId1 = document.getElementById('hinId').value;
		if( validateMetaCharacters(visId) && validateMetaCharacters(visNo) && validateMetaCharacters(hinId1)){
		<%-- var url="/hms/hms/medicalBoard?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>";--%>
	   		var url="/hms/hms/medicalBoard?method=showPatientPreviousVisitForViewScreen&visitId="+visId+"&visitNo="+visNo+"&hinId="+hinId1;
	   	newwindow=window.open(url,'opdPatientPrevVisitForViewScreen','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
	   	
		}
	
	
}
function getPrevMedBoardFromHIC()
{
	var visId = document.getElementById('visitId').value;
	var visNo= document.getElementById('visitNumberForReport').value;
	var hinId1 = document.getElementById('hinId').value;
	var tokenNo =  document.getElementById('token').value;
	if( validateMetaCharacters(visId) && validateMetaCharacters(visNo) && validateMetaCharacters(hinId1) && validateMetaCharacters(tokenNo)){
		<%-- var url="/hms/hms/medicalBoard?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";--%>
		var url="/hms/hms/medicalBoard?method=getPrevMedBoardFromHIC&visitId"+visId+"&visitNo="+visNo+"&hinId="+hinId1+"&token="+tokenNo;
   		newwindow=window.open(url,'opd_previousVisitForMedicalBoard','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
	}
}
function getPrevMedExamFromHIC()
{
	<%--var url="/hms/hms/medicalBoard?method=getPrevMedExamFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";--%>
	
	var serviceNo = document.getElementById('serviceNo').value; // add and comment by javed khan
	<%--var url="/hms/hms/medicalBoard?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>";--%>
	if( validateMetaCharacters(serviceNo)){
	var url="/hms/hms/medicalBoard?method=getPrevMedExamFromHIC&serviceNo="+serviceNo;  // add by javed khan
   	newwindow=window.open(url,'opd_previousVisitForMedicalExampVal','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
	}
}
function showPatientPreVisitHospitality()
{
//  added by javed khan 

	var visId = document.getElementById('visitId').value;
	var visNo= document.getElementById('visitNumberForReport').value;
	var hinId1 = document.getElementById('hinId').value;
	var tokenNo =  document.getElementById('token').value;

	if( validateMetaCharacters(visId) && validateMetaCharacters(visNo) && validateMetaCharacters(hinId1) && validateMetaCharacters(tokenNo)){
	<%-- var url="/hms/hms/medicalBoard?method=showPatientPreVisitHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>"; --%>
	var url="/hms/hms/medicalBoard?method=showPatientPreVisitHospitality&visitId="+visId+"&visitNo="+visNo+"&hinId="+hinId1+"&token="+tokenNo;
   	newwindow=window.open(url,'opd_previousVisitForHospitality','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
	}
}
function validateDuration(val, fieldId){
	if(val != "" || val == '0'){
		if(!validateInteger(val)){
			alert("Period should be an integer value.");
			document.getElementById(fieldId).value = "";
			document.getElementById(fieldId).focus();
			return false;
		}
	}else if(val == "" ){
		alert("Period  should be geater than 0.");
		document.getElementById(fieldId).value = "";
		document.getElementById(fieldId).focus();
		return false;
	}
	return true;
}
function checkDentalReferToMH()
{
		if(document.getElementById("dentalReferId").checked==true)
		{
			document.getElementById('dentalDivId').style.display='inline';
		}else{
			document.getElementById('dentalDivId').style.display='none';
		}
}
</script></form>

</body>
<script type="text/javascript">
checkForInvestReferToMH();
coolDental();
</script>

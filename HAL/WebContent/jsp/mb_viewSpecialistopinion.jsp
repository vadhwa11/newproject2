<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Disabilitygroup"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="java.util.Properties"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.Disability"%>
<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%>
<%@page import="java.util.LinkedHashSet"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>

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
	<%

String Labresult="NotPresent";
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<MbTypeOfEntryMaster> typeOfEntryMasterList = new ArrayList<MbTypeOfEntryMaster>();
List<MasUnit> masUnitList = new ArrayList<MasUnit>();
List<MasMaritalStatus> masMaritalStatusList = new ArrayList<MasMaritalStatus>();
List<MasRank> masRankList1 = new ArrayList<MasRank>();
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

List templateList= new ArrayList();
if(map.get("templateList") != null){
templateList=(List)map.get("templateList");
}
if(map.get("masRankList")!=null)
{
	masRankList1 = (List) map.get("masRankList");

}
List visitlist = new ArrayList();

if(map.get("visit") != null){
	visitlist=(List)map.get("visit");

	}
List<Disability> disabilityList= new ArrayList<Disability>();
if(map.get("disabilityList") != null){
	disabilityList=(List)map.get("disabilityList");
}
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
MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();
	Visit visit=null;
if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
	 visit=(Visit)medExamObj.getVisit();

}
List<MasMedicalExaminationDetail> medicalExamDetailsList = new ArrayList<MasMedicalExaminationDetail>();
if(map.get("medicalExamDetailsList") != null){
	medicalExamDetailsList = (List<MasMedicalExaminationDetail>)map.get("medicalExamDetailsList");
}


List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
}
Properties properties = new Properties();
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
Set<PatientInvestigationDetails> patientInvestigationdetails=null;
PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
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
List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
if(map.get("masHospitalList") != null){
	masHospitalList=(List)map.get("masHospitalList");
}
if(map.get("masDepartmentList") != null){
	masDepartmentList=(List)map.get("masDepartmentList");
}
String directFlag="";
if(map.get("directFlag") != null){
	directFlag=(String)map.get("directFlag");
}
String SecialFlag="";
if(map.get("SecialFlag") != null){
	SecialFlag=(String)map.get("SecialFlag");
}
%>
<div class="titleBg">
<h2>Specialist Opinion</h2>
</div>
<div class="clear"></div>
<body>

<form name="MedicalBoardInitialMedExamJsp" action="" method="post">
<div class="clear"></div>
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

String presentConditions="";
String medication="";
if(medExamObj.getPresentCondition()!=null){
	presentConditions=medExamObj.getPresentCondition();
}

if(medExamObj.getMedication()!=null){
	medication=medExamObj.getMedication();
}
%>
<input type="hidden" name="medExamId" value="<%=medExamId %>"/>
<input type="hidden" name="visitId" value="<%=visitId %>"/>
<input type="hidden" name="<%=HIN_ID%>" value="<%=hinId %>"/>

<div class="Block">

<label>Service No. </label>
<% if(visit.getMedExamType()!=null){%>
 <input type="hidden"	value="<%= visit.getMedExamType() %>" name="medicalExamType" tabindex="2" />

<% }else{%>

 <input type="hidden"	value="Initial Medical Board AFMSF 15" name="medicalExamType" tabindex="2" />
<% }%>
 <input type="text"	 name="<%=SERVICE_NO %>" readonly="readonly" tabindex="2" value="<%=visit.getHin().getServiceNo()%>"/>
 <label>Rank  </label>
   <input type="text" value="<%= visit.getHin().getRank().getRankName() %>" readonly="readonly" name="<%=RANK%>"	tabindex="2" maxlength="20" />
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="2" maxlength="20" />

<label>Name  </label>

  <input	type="text" value="<%= visit.getHin().getSFirstName()+" "+(visit.getHin().getSMiddleName()!=null?visit.getHin().getSMiddleName():"")+" "+(visit.getHin().getSLastName()!=null?visit.getHin().getSLastName():"") %>" readonly="readonly" name="<%=FULL_NAME%>"	tabindex="2" maxlength="20"/>

  <%if(visit.getAge()!= null){ %>
<input type="hidden" name="ageId" id="ageId" value="<%=visit.getAge() %>">
<%} %>
<%if(visit.getHin().getSex() != null){  %>
<input type="hidden" name="genderId" id="genderId" value="<%=visit.getHin().getSex().getId() %>">
<%} %>
 <div class="clear"></div>
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
 <label>Branch/Trade  </label>
<% if(visit.getHin().getTrade()!=null){%>
 <input	type="text"  name="<%=TRADE%>"	readonly="readonly" tabindex="2" value="<%= visit.getHin().getTrade().getTradeName() %>" maxlength="20" />
  <input	type="hidden"  name="<%=TRADE_ID%>"	tabindex="2" value="<%= visit.getHin().getTrade().getId() %>" maxlength="20" />

<% }else{%>
 <input	type="text"  name="<%=TRADE%>"	tabindex="2" readonly="readonly"/>

 <% }%>
 <div class="clear"></div>
  <label>Present Med Cat </label>
<select name="<%= PRESENT_MEDICAL_CATEGORY %>" disabled="disabled"	validate="Previous Med Category,string,no" tabindex=1 readonly="readonly">
	<option value="0">Select</option>
	<%
	int presentMedicalCategory=0;
	if(medExamObj.getPresentMedicalCategory()!=null)
	{
		presentMedicalCategory=medExamObj.getPresentMedicalCategory().getCategoryid();
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
 </div>
  <div class="clear paddingTop15"></div>
 <div class="clear"></div>
 <div id="slide2">
<div class="Block">
<%
String disability = "";
if(medicalExamDetailsList.size() > 0){
	for(MasMedicalExaminationDetail medicalExaminationDetail : medicalExamDetailsList){
		if(medicalExaminationDetail.getPrincipal()!=null){
		if(!disability.equals("")){
			disability += ",";
		}
			disability +=medicalExaminationDetail.getPrincipal();
		}
	}
}

String diagnosis1="";
String diagnosis2="";
String onsetDiag1="";
String onsetDiag2="";
String placeLastBoard="";
String dateLastBoard="";
if(medExamObj.getDiagnosis1Clini()!=null){
	diagnosis1=medExamObj.getDiagnosis1Clini();
}
if(medExamObj.getDiagnosis2Clini()!=null){
	diagnosis2=medExamObj.getDiagnosis2Clini();
}
if(medExamObj.getOnsetDiag1()!=null){
	onsetDiag1=medExamObj.getOnsetDiag1();
}
if(medExamObj.getOnsetDiag2()!=null){
	onsetDiag2=medExamObj.getOnsetDiag2();
}
if(medExamObj.getPlaceLastCatBoard()!=null){
	placeLastBoard=medExamObj.getPlaceLastCatBoard();
}
if(medExamObj.getLastBoardDate()!=null){
	dateLastBoard=HMSUtil.convertDateToStringTypeDateOnly(medExamObj.getLastBoardDate());
}

%>
<%----
<label>Disability</label>
<%
	if(medExamObj.getSplDisability()!=null){
%>
 <textarea rows="" readonly="readonly" cols="" class="large" name="splDisability" readonly="readonly"><%=medExamObj.getSplDisability()!=null?medExamObj.getSplDisability():"" %></textarea>
 <%}else if(!disability.equals("")){ %>
  <textarea rows="" cols="" readonly="readonly" class="large" name="splDisability" readonly="readonly"><%=disability %></textarea>
 <%} %>
<div class="clear"></div>
<label>Last Review</label>
 <textarea rows="" cols="" class="large" name="lastReview" readonly="readonly"><%= medExamObj.getLastReview()!=null?medExamObj.getLastReview():""%></textarea>

 <div class="clear"></div>

<label>Course of Illness</label>
 <textarea rows="" cols="" class="large" name="courseOfIllness" readonly="readonly"><%=medExamObj.getCourseOfIllness()!=null?medExamObj.getCourseOfIllness():"" %></textarea>
<div class="clear"></div>
<label>General Exam</label>
 <textarea rows="" cols="" class="large" name="generalExam" readonly="readonly"><%=medExamObj.getGeneralExam()!=null?medExamObj.getGeneralExam():"" %></textarea>

</div>
</div>
 <div class="clear paddingTop15"></div>
<div class="clear"></div>--%>
<label>Diagnosis</label>
<input size="1" class="transparent" disabled="disabled" />
 <label class="unit">1.</label>
<input type="text" name="diagnosis1" id="diagnosis1" value="<%=diagnosis1%>" class="auto" size="45" readonly="readonly"/>
 <label class="unit">Onset</label>
 <input type="text" name="onsetDiag1" id="onsetDiag1" value="<%=onsetDiag1%>" class="auto" size="50" readonly="readonly"/>
<div class="clear"></div>
<label class="transparent">&nbsp;</label>
<input size="1" class="transparent" disabled="disabled" />
 <label class="unit">2.</label>
<input type="text" name="diagnosis2" id="diagnosis2" value="<%=diagnosis2%>" class="auto" size="45" readonly="readonly"/>
 <label class="unit">Onset</label>
 <input type="text" name="onsetDiag2" id="onsetDiag2" value="<%=onsetDiag2%>" class="auto" size="50" readonly="readonly" />
<div class="clear"></div>
<label>Last Medical Board</label>
 <input size="1" class="transparent" />
 <label class="unit">Place</label>
<input type="text" name="lastMedBoardPlace" id="lastMedBoardPlace" value="<%=placeLastBoard%>" class="auto" size="45" readonly="readonly"/>
<label class="unit">Date</label>
<input type="text" name="dateLastBoard" id="dateLastBoard" value="<%=dateLastBoard%>" class="auto" size="45" readonly="readonly" readonly="readonly"/>
 <div class="clear"></div>
<label>Present Condition</label>
<input type="text" name="presentConditions" id="presentConditions" value="<%=presentConditions%>" size="125" class="auto"
	 readonly="readonly"/>
<div class="clear"></div>
<label>Medication</label>
<input type="text" name="medication" id="medication" value="<%=medication%>" size="125" class="auto"  readonly="readonly" validate="Medication,string,no"/>
<div class="clear"></div>
<label>Temperature</label>
 <% if(medExamObj.getTemprature()!=null){%>
  <input tabindex="1" type="text" name="<%=TEMPERATURE%>" class="auto" size="3"  readonly="readonly"  value="<%=medExamObj.getTemprature() %>" validate="num,float,no"/>
  <label class="auto"><sup>o</sup>F</label>
 <% }else{%>
 <input tabindex="1" type="text" name="<%=TEMPERATURE%>" class="auto" size="3"  readonly="readonly" validate="Temp,num,no"/><label class="unit">/min</label>
 <% }%>
<input size="2" class="transparent" />
<label class="auto">Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input tabindex="1" type="text"name="<%=PULSE_RATES%>" class="auto" size="3"  readonly="readonly"  value="<%=medExamObj.getPulseRates() %>" validate="Pulse,string,no"/>
  <label class="auto">/min</label>
 <% }else{%>
 <input tabindex="1" type="text"name="<%=PULSE_RATES%>" class="auto" size="3"  readonly="readonly" validate="Pulse,string,no"/><label class="unit">/min</label>
 <% }%>
 <input size="2" class="transparent" />
 <label class="auto">BP</label>
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" name="<%=BP1%>" class="auto" size="5"  readonly="readonly"  value="<%=medExamObj.getBp() %>" validate="BP,string,no"/>
 <label class="auto">mm Hg</label>
 <% }else{%>
 <input tabindex="1" type="text" name="<%=BP1%>" class="auto" size="5"  readonly="readonly" validate="BP,string,no"/>
 <label class="auto">mm Hg</label>
 <% }%>
 <input size="2" class="transparent" />
<label class="auto">RR</label>
<% if(medExamObj.getRrClinical()!=null){%>
  <input tabindex="1" type="text"name="<%=RR%>" class="auto" size="3"  readonly="readonly"  value="<%=medExamObj.getRrClinical() %>" validate="RR,string,no"/>
 <label class="auto">/min</label>
 <% }else{%>
 <input tabindex="1" type="text"name="<%=RR%>" class="auto" size="3"  readonly="readonly" validate="RR,string,no"/>
 <label class="auto">/min</label>
 <% }%></div></div>
  <div class="clear paddingTop15"></div>
<div class="clear"></div>
<!--  Start Of PHYSICAL CAPACITY -->

<h4> On Examination<a href="javascript:animatedcollapse.toggle('slide1')"></a></h4>
<div class="clear"></div>
<div id="slide1">
<div class="Block">
<label>Height</label>
  <% if(medExamObj.getHeight()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  id="height" class="auto" size="10"	name="<%=HEIGHT_WITHOUT_SHOOSE %>"  value="<%=medExamObj.getHeight() %>"
	 readonly="readonly" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  id="height"	class="auto" size="10"	name="<%=HEIGHT_WITHOUT_SHOOSE %>"
	 /><label class="unit">cm</label>

 <% }%>

<label>Weight</label>
  <% if(medExamObj.getActualweight()!=null){%>
<input tabindex="1" type="text" readonly="readonly" id="weight" class="auto"	name="<%=ACTUAL_WEIGHT %>"  value="<%=medExamObj.getActualweight() %>"
	readonly="readonly" size="10"/><label class="unit">kg</label>

 <% }else{%>
<input tabindex="1" type="text"   id="weight" class="auto"	name="<%=ACTUAL_WEIGHT %>" 
	readonly="readonly" size="10" /><label class="unit">kg</label>

 <% }%>
<label>SD</label>
	<%
	if(medExamObj.getSD()!=null){
	%>
<input type="text" value="<%=medExamObj.getSD() %>" tabindex="1" name="sd" id="sd" readonly="readonly" class="auto" size="10"/>
<%}else{ %>
<input type="text" value="" tabindex="1" name="sd" id="sd" readonly="readonly" class="auto" size="10"/>

<%} %>
<div class="clear"></div>
<label>Ideal Weight</label>
  <% if(medExamObj.getIdealweight()!=null){%>
<input tabindex="1" type="text"   id="idealWeightId" name="<%=IDEAL_WEIGHT %>" class="auto" size="10"	 value="<%=medExamObj.getIdealweight() %>"
readonly="readonly" /><label class="unit">kg</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="idealWeightId" name="<%=IDEAL_WEIGHT %>" class="auto" size="10"	
readonly="readonly" /><label class="unit">kg</label>

 <% }%>


<label>Over Weight</label>
  <% if(medExamObj.getOverweight()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>" class="auto" size="10"	 value="<%=medExamObj.getOverweight() %>"
readonly="readonly" /><label class="unit">%</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>"  class="auto" size="10"	
readonly="readonly" /><label class="unit">%</label>

 <% }%>
<label>BMI</label>
  <% if(medExamObj.getBhi()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="bmi" name="<%=BHI %>"  value="<%=medExamObj.getBhi() %>"
	readonly="readonly" class="auto" size="10"  />
	<label class="unit">kg/m<sup>2</sup></label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="bmi" name="<%=BHI %>" 
	readonly="readonly" class="auto" size="10"  />
	<label class="unit">kg/m<sup>2</sup></label>

 <% }%>
 <div class="clear"></div>
 <label>Body Fat</label>
  <% if(medExamObj.getBodyfat()!=null){%>
<input tabindex="1" type="text" class="auto" size="10" maxlength="20"  id="" name="<%=BODY_FAT %>" value="<%=medExamObj.getBodyfat() %>"
	readonly="readonly" />

 <% }else{%>
<input tabindex="1" type="text" class="auto" size="10" maxlength="20"  id="" name="<%=BODY_FAT %>" 
	 readonly="readonly"  />

 <% }%>
 <input type="text" class="transparent" size="6" />
<label>Waist</label>
  <% if(medExamObj.getWaist()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="<%=WAIST %>" name="<%=WAIST %>"  value="<%=medExamObj.getWaist() %>"
 readonly="readonly" onblur="calculateWHR();" class="auto" size="10" />
	<label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="<%=WAIST %>" name="<%=WAIST %>" 
 readonly="readonly"  onblur="calculateWHR();" class="auto"  size="10" />
  <label class="unit">cm</label>
 <% }%>
 <label>Hip</label>
  <% if(medExamObj.getHips()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="hips" name="Hips"  value="<%=medExamObj.getHips() %>"
	 readonly="readonly"  onblur="calculateWHR();" class="auto" size="10" />
	<label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="hips" name="Hips" 
 readonly="readonly"  onblur="calculateWHR();" class="auto" size="10"  />
	<label class="unit">cm</label>

 <% }%>
 
  <div class="clear"></div>
<label>WHR</label>
  <% if(medExamObj.getWhr()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="WHR" name="WHR"  value="<%=medExamObj.getWhr() %>"
 readonly="readonly" class="auto" size="10" />

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="WHR" name="WHR" 
 readonly="readonly" class="auto" size="10"  />

 <% }%>
  <input type="text" class="transparent" size="6" />
<label>Skin Fold Thickness</label>
  <% if(medExamObj.getSignfoldthickness()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="" name="<%=THICKNESS %>"  value="<%=medExamObj.getSignfoldthickness() %>"
 readonly="readonly" class="auto" size="10" />
<label class="unit">cm</label>
 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="" name="<%=THICKNESS %>" 
 readonly="readonly" class="auto" size="10"  />
<label class="unit">cm</label>
 <% }%>
<label>Chest Full Expansion</label>
  <% if(medExamObj.getChestfullexpansion()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" 	  value="<%=medExamObj.getChestfullexpansion() %>"
	 readonly="readonly" class="auto" size="10" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" 	 
	 readonly="readonly" class="auto" size="10" /><label class="unit">cm</label>

 <% }%>
 <div class="clear"></div>
<label>Range of Expansion</label>
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text" maxlength="20"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>"  value="<%=medExamObj.getRangeofexpansion() %>"
	 readonly="readonly" class="auto" size="10" />
<label class="unit">cm</label>
 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" 
	 readonly="readonly" class="auto" size="10" />
   <label class="unit">cm</label>
 <% }%>
<label>Sportsman</label>
<select name="<%=SPORTS %>" class="small" id="<%=SPORTS %>" validate="Sports Man,stirng,no" disabled="disabled" >
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
<!--  End Of PHYSICAL CAPACITY -->

 <div class="clear paddingTop15"></div>
 <div class="clear"></div>
<div id="slide4">
<div class="Block">
 <!-- Code for Exaimination -->
 <%

BigDecimal temperature=new BigDecimal(0);
String pulseRates="";
String bp1="";
String rr="";
String generalPhysicalExam="NAD";
String cardiovascularSystem="NAD";

if(medExamObj.getGeneralPhysicalExam()!=null){
	generalPhysicalExam=medExamObj.getGeneralPhysicalExam();
}

if(medExamObj.getGastroIntestinalSystem()!=null){
}
if(medExamObj.getCardiovascularSystem()!=null){
	cardiovascularSystem=medExamObj.getCardiovascularSystem();

}
%>
 
 <label>General Physical Exam</label>
<input type="text" name="generalPhysicalExam" id="generalPhysicalExam" value="<%=generalPhysicalExam%>" size="100" class="auto"
   readonly="readonly"/>
<div class="clear"></div>
<label>Cardiovascular System</label>
<input type="text" name="cardiovascularSystem" id="cardiovascularSystem" value="<%=cardiovascularSystem%>" size="100" class="auto"
	 readonly="readonly"/>
<div class="clear"></div>

<label>Respiratory System</label>
<% if(medExamObj.getRespiratorySystem()!=null){%>
<input tabindex="1" type="text" maxlength="10"  name="<%=RESPIRATORY_SYSTEM%>" class="auto" size="100" maxlength="100"  value="<%=medExamObj.getRespiratorySystem() %>"
   readonly="readonly"/>

 <% }else{%>
<input tabindex="1" type="text" maxlength="10" value="NAD" name="<%=RESPIRATORY_SYSTEM%>" class="auto" size="100" 
  readonly="readonly"/>

 <% }%>
<div class="clear"></div>

			<%

			String gastroIntestinalSystem="NAD";
			String breakDown="";
			String centralNervousSystem="NAD";

			String localExamination="";
			String remarksClinical="";
			int opdDeptClinical=0;
			if(medExamObj.getGastroIntestinalSystem()!=null){
				gastroIntestinalSystem=medExamObj.getGastroIntestinalSystem();
			}
			if(medExamObj.getCentralNervousSystemMMHG()!=null){
				centralNervousSystem=medExamObj.getCentralNervousSystemMMHG();
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
 readonly="readonly"/>
<div class="clear"></div>


<label>Central Nervous System </label><%-- 
<% if(medExamObj.getCentralNervousSystemMMHG()!=null){%>
  <input tabindex="1" type="text" maxlength="1"  name="<%=NERVOUS_BRAKDOWN%>" class="auto" size="100"  value="<%=medExamObj.getCentralNervousSystemMMHG()%>" validate="Central Nervous System unit,string,no"/>

 <% }else{%>
 <input tabindex="1" type="text" maxlength="1" value="Normal" name="<%=NERVOUS_BRAKDOWN%>" class="auto" size="100" validate="Central Nervous System,string,no"/>

 <% }%>--%>
 <input type="text" name="centralNervousSystem" id="centralNervousSystem" value="<%=centralNervousSystem%>" size="100" class="auto"
  readonly="readonly"/>
<div class="clear"></div>

<%-- 
<label>Local Examination</label>
<input type="text" name="localExamination" id="localExamination" value="<%=localExamination%>" size="100" class="auto"
 maxlength="50" validate="Local Examination,string,no"/>
<div class="clear"></div>

<label>Remarks</label>
<input type="text" name="remarksClinical" id="remarksClinical" value="<%=remarksClinical%>" size="100" class="auto" maxlength="100" validate="Clinical Remarks,string,no"/>
 --%>
 
 </div>
<div class="clear paddingTop15"></div>
<h4>Investigation <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div id="slide5">
<div class="Block">
<label >Template</label>
<div id="investigationDiv">
<select name="investigationTemplateId" disabled="disabled"	tabindex="1" onchange="showHideInvestigationTemplateCombo(this.value);">
	<option value="0">Select</option>
	
	<option value=""></option>


</select>
</div>
<div id="createInvestigationDivToShowHide">
<input	name="investigationTemplate" type="hidden"	value="Create Template" tabindex="1" class="buttonBig" onclick="showCreateInvestigationTemplate();" />
</div>
<div id="copyPrevInvestigationTemplateDiv" style="display: none">
<input name="copyPrevInvestigationTemplate" tabindex="1" type="hidden"	value="Copy Previous" class="buttonBig"  />
</div>

<!--<div id="investigationImportButton1" >
<input	name="investigationImportButton1" tabindex="1" type="button"	value="IMPORT" class="buttonBig"	onclick="getListForTreatment('investigationDiv');" />
</div>

-->
<input name="Prevoius" type="hidden" tabindex="2" value="Prev Investigations"	class="buttonBig"	 />

</div><div class="clear"></div>
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
	<%	int count=1;
    if(getDgOrderdts!=null)
    {

	for(DgOrderdt dgOrderdt : getDgOrderdts){
	%>
	 <input type="hidden" value="<%=dgOrderdt.getId()%>" name="dgOrderdtId<%=count%>" id="dgOrderdtId<%=count%>"  readonly="readonly"/>

<%count++;}
    }
%>
	<div class="clear paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid">
<tr>
	<th scope="col">Investigation</th>
	<th scope="col">Refer to MH</th>
	<th scope="col">Result</th>
	<th scope="col">View File</th>
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
		
		<td> <%---<input tabindex="1" type="checkbox"
		name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"  
		onclick="checkForInvestigationMH(<%=inc %>);" disabled="disabled"/>
	 </td> --%><%}else{ %>
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
	<input	type="button" class="Button" value="Result"	onclick="openTemplateScreen(<%=inc %>);"  />
	</td>

<%}%>
	
	<td>
	<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
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
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: inline"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
<% 	    	}else
            { %>
             <td>
            <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" value="n"  id="investigationReferToMH<%=inc %>"
	onclick="checkForInvestigationMH(<%=inc %>);"/>
   </td>
    <td><input type="text" value="" readonly="readonly"	 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
            <%
             }
	    	}else
	    	{%>
 <td>
	<input tabindex="1" type="checkbox"	name="investigationReferToMH<%=inc %>" value="y"  
	id="investigationReferToMH<%=inc %>" onclick="checkForInvestigationMH(<%=inc %>);" />
   </td>
    <td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
        </td>
        <td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
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
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
<% }%>



<% }%>
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
		<input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
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
<td><input name="uploadReport1" id="uploadReport1" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(1);" /></td>


	</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<% }%>
</table>
</div>
</div>

<input type="hidden" id="investigationDataStatus" name="investigationDataStatus" value="no"/>
<div class="Clear paddingTop15"></div>
<!--  End Of Investigations -->
<div class="clear"></div>
<div class="Block">
<%
String specilaistOpinionRemark="";
String specilaistTreatmentAdvice="";
String specilaistOpinionDate="";
int specilaistMedCatRec=0;
if(medExamObj.getSpecilaistOpinionDate()!=null){
	specilaistOpinionDate=HMSUtil.convertDateToStringTypeDateOnly(medExamObj.getSpecilaistOpinionDate());
}else{
	specilaistOpinionDate=date;
}
if(medExamObj.getSpecilaistTreatmentAdvice()!=null){
	specilaistTreatmentAdvice=medExamObj.getSpecilaistTreatmentAdvice();
}
if(medExamObj.getSpecilaistOpinionRemark()!=null){
	specilaistOpinionRemark=medExamObj.getSpecilaistOpinionRemark();
}
BigDecimal medboardDuration=new BigDecimal(0);
if(medExamObj.getMedboardDuration()!=null){
	medboardDuration=medExamObj.getMedboardDuration();
}
%>
<label>Specilaist Opinion</label>
<textarea rows="" cols="" name="SpecilaistOpinionRemark" id="SpecilaistOpinionRemark" readonly="readonly" >
<%=specilaistOpinionRemark %></textarea>

<label>Med Cat Rec</label>
<%if(medExamObj.getMedicalCategoryRecomended() !=null){ %>
<input type="text" value="<%=medExamObj.getMedicalCategoryRecomended().getCategories() %>" name="medCatNowRecommend" readonly="readonly"/>
<%}else{ %>
<input type="text" value="" name="medCatNowRecommend" readonly="readonly"/>
<%} %>	<%--
<select id="medCatNowRecommend"	name="medCatNowRecommend"	readonly="readonly" tabindex=1>
	<option value="0">Select</option>

<select name="SpecilaistMedCatRec" id="SpecilaistMedCatRec"	validate="Med Cat Rec,string,no" tabindex=1>
	<%
	if(medExamObj.getSpecilaistMedCatRec()!=null)
	{
		specilaistMedCatRec=medExamObj.getSpecilaistMedCatRec().getCategoryid();
	}
	if(categoryList.size()>0){		
	for (Category category : categoryList) {
				if(specilaistMedCatRec==category.getCategoryid())
					{
				%>
	<option value="<%=category.getCategoryid()%>" selected="selected" ><%=category.getCategories()%> </option>
	<%}else{
		%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%	}

				}}	%>
			
				<%
	int medicalCategoryRecomendedId=0;
	if(medExamObj.getMedicalCategoryRecomended()!=null)
	{
		medicalCategoryRecomendedId=medExamObj.getMedicalCategoryRecomended().getCategoryid();
	}
			for (Category category : categoryList) {
				/*	String selected="";
				if(category.getCategoryid().equals(medicalCategoryRecomendedId))
					{
					selected="selected";
					}else{
						selected="";
					}*/
				%>
	<option value="<%=category.getCategoryid()%>"><%=category.getCategories()%> </option>
	<%}%>
</select> 
<script type="text/javascript">
document.getElementById('medCatNowRecommend').value = '<%=medicalCategoryRecomendedId%>';
</script>--%>
<label>Duration</label>
<input tabindex="1" type="text" id="medboardDuration" name="medboardDuration"  class="autoArial" size="1" value="<%=medboardDuration%>" readonly="readonly" maxlength="1"/>
<label class="unit">Weeks</label>	
<label>Date</label>
<input type="text" name="SpecilaistOpinionDate" id="SpecilaistOpinionDate" value="<%=specilaistOpinionDate%>" class="auto" size="10" readonly="readonly"/>

<div class="clear"></div>
<label>Treatment Advice</label>
<textarea rows="" cols="" name="SpecilaistTreatmentAdvice"  id="SpecilaistTreatmentAdvice" readonly="readonly" >
<%=specilaistTreatmentAdvice %></textarea>
</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="reset" name ="Close" id="close" value ="Close" class="button" onclick="window.close();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
</form>
</body>
<script>
function openTemplateScreen(index){
		var resultId = document.getElementById('resultIdTemplate'+index).value;
	//	submitForm('MedicalBoardInitialMedExamJsp','investigation?method=searchPatientForResultValidation&resultId='+resultId+'&flagForLab=fromLab');
   	var url="/hms/hms/investigation?method=searchPatientForResultValidation&resultId="+resultId+"&flagForLab=fromExam";
    newwindow=window.open(url,'ar',"left=2,top=100,height=500,width=500,status=1,scrollbars=1,resizable=0");

}
function fileUploadWindowInvestigation(rowVal)
{
	var hinNo='<%=visit.getHin().getHinNo()%>';
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
 		var url="/hms/hms/medicalExam?method=viewUploadDocumentsInvestigationDetails&hinId=<%=visit.getHin().getId()%>&hinNo="+hinNo+"&invest_id="+invest_id+"&masExam_Id=<%=medExamId%>&visitId=<%=visit.getId()%>";
 	}
 		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
 //	}


}
</script>
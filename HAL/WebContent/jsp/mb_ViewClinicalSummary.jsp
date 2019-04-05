<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script>
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
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasMedicalExaminationReportOnEntry> medicalExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	if(map.get("medExamList") !=null){
		medicalExamList=(List)map.get("medExamList");
	}
	MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();
	Visit visit=null;
	if(medicalExamList.size() > 0){
		medExamObj = medicalExamList.get(0);
		 visit=(Visit)medExamObj.getVisit();
	}

%>
<div class="titleBg">
<h2>CLINICAL SUMMARY</h2>
</div>
<div class="clear"></div>
<div class="Block">
<% String presentCondition="";
	String medication="";
	if(medExamObj.getPresentCondition() !=null){
		presentCondition=medExamObj.getPresentCondition();
	}
	if(medExamObj.getMedication() !=null){
	medication=medExamObj.getMedication();
	}%>
<label>Present Conditions</label>

<input type="text" name="presentConditions" id="presentConditions" value="<%=presentCondition %>" readonly="readonly" 
 	size="100" class="auto" tabindex="1"/>
<div class="clear"></div>
<label>Medication</label>
<input type="text" name="medication" id="medication" value="<%=medication %>" size="100" class="auto" readonly="readonly" tabindex="1"/>
<div class="clear"></div>
<h4>Examination</h4>
<div class="clear"></div>
<label >Temp</label>
 <% if(medExamObj.getTemprature()!=null){%>
  <input type="text" class="auto" size="21" name="<%=TEMPERATURE%>" value="<%=medExamObj.getTemprature()%>"  tabindex="1" readonly="readonly"/>
  <label class="unit">F</label>
 <% }else{%>
 <input type="text" name="<%=TEMPERATURE%>"  tabindex="1" readonly="readonly" class="auto" size="21"/>
 <label class="unit" >F</label>
 <% }%>

<label>Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input type="text" class="auto" size="21" name="<%=PULSE_RATES%>"  value="<%=medExamObj.getPulseRates() %>"  tabindex="1" readonly="readonly"/>
  <label class="unit">/min</label>
 <% }else{%>
 <input type="text"  name="<%=PULSE_RATES%>"  tabindex="1" readonly="readonly" class="auto" size="21"/>
 <label class="unit">/min</label>
 <% }%>
 
 <div class="clear"></div>
 
 <label >BP</label> 
<% if(medExamObj.getBp()!=null){%>
  <input type="text"name="<%=BP1%>"  value="<%=medExamObj.getBp() %>"  tabindex="1" readonly="readonly" class="auto" size="21"/>
 <label class="unit">mm/Hg</label>
 <% }else{%>
 <input type="text"name="<%=BP1%>"  tabindex="1" readonly="readonly" class="auto" size="21"/>
 <label class="unit">mm/Hg</label>
 <% }%>

<label>RR</label> 
<% if(medExamObj.getRrClinical()!=null){%>
  <input type="text"  class="auto" size="21" name="<%=RR%>"  value="<%=medExamObj.getRrClinical() %>"  tabindex="1" readonly="readonly"/>
 <label class="unit">/min</label>
 <% }else{%>
 <input type="text" name="<%=RR%>" class="auto" size="21" tabindex="1" readonly="readonly"/>
 <label class="unit">/min</label>
 <% }%>
 
 <div class="clear"></div>
 
<label>General Physical Exam</label>
<%
String generalPhysicalExam="";
String cardiovascularSys="";
String gastroIntestinalSystem="";
String centralNervousMM="";
String centralNervousSystem="";
String localExam="";
String referredToMh="";
String clinicalRemarks="";
String opdDept="";
if(medExamObj.getGeneralPhysicalExam()!=null){
	generalPhysicalExam=medExamObj.getGeneralPhysicalExam();
}
if(medExamObj.getCardiovascularSystem()!=null){
	cardiovascularSys=medExamObj.getCardiovascularSystem();
}
if(medExamObj.getCentralNervousSystemMMHG() !=null){
	centralNervousMM=medExamObj.getCentralNervousSystemMMHG();
}
if(medExamObj.getCentralNervousSystem() !=null){
	centralNervousSystem=medExamObj.getCentralNervousSystem();
}
if(medExamObj.getLocalExamination() !=null){
	localExam=medExamObj.getLocalExamination() ;
}
if(medExamObj.getRemarksClinical() !=null){
	clinicalRemarks=medExamObj.getRemarksClinical() ;
}
if(medExamObj.getClinicalReferMh() !=null){
	referredToMh=medExamObj.getClinicalReferMh();
}
if(medExamObj.getClinicalOpdDept() !=null){
	opdDept=medExamObj.getClinicalOpdDept().getDepartmentName();
}
if(medExamObj.getGastroIntestinalSystem()!=null){
	gastroIntestinalSystem=medExamObj.getGastroIntestinalSystem();
}
%>
<input type="text" name="generalPhysicalExam" id="generalPhysicalExam" value="<%=generalPhysicalExam %>" size="100" class="auto" readonly="readonly" tabindex="1"/>
<div class="clear"></div>
<label>Cardiovascular System</label>
<input type="text" name="cardiovascularSystem" id="cardiovascularSystem" value="<%=cardiovascularSys %>" size="100" class="auto" readonly="readonly" tabindex="1"/>
<div class="clear"></div>
<label>Respiratory System</label> 
<% if(medExamObj.getRespiratorySystem()!=null){%>
  <input type="text"name="<%=RESPIRATORY_SYSTEM%>" class="auto" size="100" value="<%=medExamObj.getRespiratorySystem() %>" tabindex="1" readonly="readonly" />

 <% }else{%>
 <input type="text" name="<%=RESPIRATORY_SYSTEM%>" class="auto" size="100" tabindex="1" readonly="readonly"/>

 <% }%>
<div class="clear"></div>

<label>Gastro Intestinal System</label>
<input type="text" name="gastroIntestinalSystem" id="gastroIntestinalSystem" value="<%=gastroIntestinalSystem %>" 
	size="100" class="auto" readonly="readonly" tabindex="1"/>
<div class="clear"></div>
<label>Central Nervous System </label>
  <input type="text"name="<%=NERVOUS_BRAKDOWN%>" class="auto" size="100" value="<%=centralNervousSystem%>" readonly="readonly" tabindex="1"/>

<div class="clear"></div>
<label>Local Examination</label>
<input type="text" name="localExamination" id="localExamination" value="<%=localExam %>" size="100" class="auto" readonly="readonly" tabindex="1"/>
<div class="clear"></div>

<label>Remarks</label>
<input type="text" name="remarks" id="remarks" value="<%=clinicalRemarks %>" size="100" class="auto" readonly="readonly" tabindex="1"/>
<div class="clear"></div>
<label>Referred to MH</label>
<input name="referredToMh" id="referredToMh" value="<%=referredToMh %>" readonly="readonly" tabindex="1" />
<%-- 
<select name="referredToMh">
<option value="">SMC</option></select>--%>
<div class="clear"></div>
<label>Referred to OPD</label>
<input name="opdDept" id="opdDept" value="<%=opdDept %>" readonly="readonly" tabindex="1">
<%-- 
<select name="opdDept">
<option value="">Select</option></select>--%>
<div class="clear"></div>
<div class="Clear paddingTop15"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="Close" value="Close" class="button" onclick="window.close()" tabindex="1" />

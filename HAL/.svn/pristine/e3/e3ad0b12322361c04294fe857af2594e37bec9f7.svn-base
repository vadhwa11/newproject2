<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.Visit"%>

<%@page import="java.math.BigDecimal"%><link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
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
	//List<MasMedicalExaminationReportOnEntry> medicalExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	//if(map.get("medicalExamList") !=null){
	//	medicalExamList=(List)map.get("medicalExamList");
	//}
	//MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();
	//Visit visit=null;
	//if(medicalExamList.size() > 0){
	//	medExamObj = medicalExamList.get(0);
	//	 visit=(Visit)medExamObj.getVisit();
	//}
	MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();
	if(map.get("masMedicalExaminationReportOnEntry")!=null)
	{
		medExamObj = (MasMedicalExaminationReportOnEntry) map.get("masMedicalExaminationReportOnEntry");
	}
%>
<div class="titleBg">
<h2>CLINICAL SUMMARY</h2>
</div>
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
<label>Diagnosis</label>
 <input size="1" class="transparent">
 <label class="unit">1.</label>
<input type="text" name="diagnosis1" readonly="readonly"  id="diagnosis1" value="<%=diagnosis1 %>" class="auto" size="45" tabindex="1"/>
 <label class="unit">Onset</label>
 <input type="text" name="onsetDiag1" readonly="readonly" id="onsetDiag1" value="<%=onsetDiag1 %>" class="auto" size="50" tabindex="1" />
<div class="clear"></div>
<input size="33" class="transparent">
 <label class="unit">2.</label>
<input type="text" name="diagnosis2" readonly="readonly" id="diagnosis2" value="<%=diagnosis2 %>" class="auto" size="45" tabindex="1"/>
 <label class="unit">Onset</label>
 <input type="text" readonly="readonly"  name="onsetDiag2" id="onsetDiag2" value="<%=onsetDiag2 %>" class="auto" size="50" tabindex="1"/>
<div class="clear"></div>
<label>Last Medical Board</label>
 <input size="1" class="transparent">
 <label class="unit">Place</label>
 <%String placeLastBoard="";
 if(medExamObj.getPlaceLastCatBoard() !=null){
 placeLastBoard=medExamObj.getPlaceLastCatBoard();
 }
 %>
<input type="text" readonly="readonly"  name="lastMedBoardPlace" id="lastMedBoardPlace" value="<%=placeLastBoard %>"
		class="auto" size="45" maxlength="49" tabindex="1"/>
<label class="unit">Date</label>
 <%String dateLastBoard="";
 if(medExamObj.getLastBoardDate() !=null){
	 dateLastBoard=HMSUtil.changeDateToddMMyyyy(medExamObj.getLastBoardDate());
 }
 %>
<input type="text" readonly="readonly" name="dateLastBoard" id="" value="<%=dateLastBoard %>" class="auto" size="45"
	onkeyup="mask(this.value,this,'2,5','/');" tabindex="1"/>
<!--<img src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardMOForm16.medBoarddate,event);" />
	--><div class="clear"></div>
<label>Present Conditions</label>
<input type="text" readonly="readonly"  name="presentConditions" id="presentConditions" value="<%=presentConditions%>" size="125" class="auto"
	maxlength="99" validate="Present Conditions,string,no" tabindex="1"/>
<div class="clear"></div>
<label>Medication</label>
<input type="text" readonly="readonly"  name="medication" id="medication" value="<%=medication%>" size="125" class="auto" maxlength="99"
validate="Medication,string,no" tabindex="1"/>
<div class="clear"></div>
<h4>Examination</h4>
<div class="clear"></div>
<label>Temperature</label>
 <% if(medExamObj.getTemprature()!=null){%>
  <input tabindex="1" type="text" readonly="readonly"  maxlength="10"  name="<%=TEMPERATURE%>" class="auto" size="3" maxlength="10"  value="<%=medExamObj.getTemprature() %>" validate="num,string,no"/>
  <label class="auto">F</label>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly"  maxlength="10"  name="<%=TEMPERATURE%>" class="auto" size="3" maxlength="10" validate="Temp,num,no" /><label class="unit">F</label>
 <% }%>
<input size="7" class="transparent">
<label class="auto">Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" maxlength="19"  name="<%=PULSE_RATES%>" class="auto" size="3" value="<%=medExamObj.getPulseRates() %>"
  id="pulseRate1" readonly="readonly"/>
  <label class="auto">/min</label>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="19"  name="<%=PULSE_RATES%>" class="auto" size="3"  id="pulseRate1" readonly="readonly"/><label class="unit">/min</label>
 <% }%>
 <input size="8" class="transparent">
 <label class="auto">BP</label>
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" maxlength="19"  name="<%=BP1%>" class="auto" size="5"  value="<%=medExamObj.getBp() %>" id="bloodpressure1" readonly="readonly"/>
 <label class="auto">mm Hg</label>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="19"  name="<%=BP1%>" class="auto" size="5" id="bloodpressure1" readonly="readonly"/>
 <label class="auto">mm Hg</label>
 <% }%>
 <input size="8" class="transparent">
<label class="auto">RR</label>
<% if(medExamObj.getRrClinical()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" maxlength="19"  name="<%=RR%>" class="auto" size="3"  value="<%=medExamObj.getRrClinical() %>" validate="RR,string,no"/>
 <label class="auto">/min</label>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly"  maxlength="19"  name="<%=RR%>" class="auto" size="3"  validate="RR,string,no"/>
 <label class="auto">/min</label>
 <% }%>
 <div class="clear"></div>
<label>General Physical Exam</label>
<input type="text" readonly="readonly"  name="generalPhysicalExam" id="generalPhysicalExam" value="<%=generalPhysicalExam%>" size="125" class="auto"
   maxlength="50" validate="General Physical Exam,string,no"tabindex="1"/>
<div class="clear"></div>
<label>Cardiovascular System</label>
<input type="text" readonly="readonly"  name="cardiovascularSystem" id="cardiovascularSystem" value="<%=cardiovascularSystem%>" size="125" class="auto"
	maxlength="50" validate="Cardiovascular System,string,no" tabindex="1"/>
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
			int referredToMhClinical=0;
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

			if(medExamObj.getClinicalReferMh()!=null){
				referredToMhClinical=medExamObj.getClinicalReferMh().getId();
			}
			if(medExamObj.getClinicalOpdDept()!=null){
				opdDeptClinical=medExamObj.getClinicalOpdDept().getId();
			}
			%>

<label>Gastro Intestinal System</label>

<input type="text" readonly="readonly"  name="gastroIntestinalSystem" id="gastroIntestinalSystem" value="<%=gastroIntestinalSystem%>" size="125" class="auto"
 maxlength="50" validate="Gastro Intestinal System,string,no" tabindex="1"/>
<div class="clear"></div>
<label>Central Nervous System </label>
<% if(medExamObj.getCentralNervousSystemMMHG()!=null){%>
  <input tabindex="1" type="text" readonly="readonly"  maxlength="99"  name="<%=NERVOUS_BRAKDOWN%>" class="auto" size="125"  value="<%=medExamObj.getCentralNervousSystemMMHG()%>" validate="Central Nervous System unit,string,no"/>

 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly"  maxlength="99"  name="<%=NERVOUS_BRAKDOWN%>" class="auto" size="125" validate="Central Nervous System,string,no"/>

 <% }%>
<%--  <input type="text" name="centralNervousSystem" id="centralNervousSystem" value="<%=centralNervousSystem%>" size="100" class="auto"
 maxlength="50" validate="Central Nervous System,string,no"/>--%>
<div class="clear"></div>
<label>Local Examination</label>
<input type="text" readonly="readonly"  name="localExamination" id="localExamination" value="<%=localExamination%>" size="125" class="auto"
 maxlength="50" validate="Local Examination,string,no" tabindex="1"/>
<div class="clear"></div>

<label>Remarks</label>
<input type="text" readonly="readonly"  name="remarksClinical" id="remarksClinical" value="<%=remarksClinical%>" size="125" class="auto" maxlength="99"
tabindex="1" validate="Clinical Remarks,string,no"/>
<div class="clear"></div>
<input type="button" name="Close" value="Close" class="button" onclick="window.close()" tabindex="1" />
<div class="clear"></div>
</div>
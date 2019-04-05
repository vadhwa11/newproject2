<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* nursingClinicalChart.jsp  
* Purpose of the JSP -  This is for Nursing Clinical Chart Details.
* @author  Dipali
* Create Date: 08th Feb,2008 
* Revision Date:      
* Revision By: Purpose
* @version 1.8  
--%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>

<%@page import="jkt.hms.masters.business.IpdClinicalChart"%>
<%@page import="jkt.hms.masters.business.IpdTemperature"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.AllergyDetail"%>
<%@page import="jkt.hms.masters.business.IpdIntakeOutputChart"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script>
<script language="JavaScript">

function fillHin(val1,val2){
document.getElementById("adminNo").value=val1
document.getElementById("srNo").value=val2
}
function checkRadio(){
  
  if(document.getElementsByName('radio').checked == true){ 
  return true;
  }else{
  	alert("Please Select radio")
  	return false
  }
  }
function fillTime(time)
{
var len = document.getElementById("indentDetails").rows.length;
for(var i=1;i<len;i++)
{
document.getElementById(i).value=time;
}
}
</script>
<script type='text/javascript'>
function isEmpty(elem, errorMsg){
var len
if(elem.value.length == 0){
alert(errorMsg);
elem.focus();
return true;
}
return false;
}
</script>
<script type="text/javascript">
<!--
// Main vBulletin Javascript Initialization
vBulletin_init();
//-->
</script>
<script type="text/javascript">


<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->

</script>

<%
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");  
String time = (String) utilMap.get("currentTimeWithoutSc");
Map map = new HashMap();
int pageNo=1;
String max="";
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String clinicalDate = (String)utilMap.get("currentDate");	 
List<Inpatient> inpatientList = new ArrayList<Inpatient>();
if (request.getAttribute("map") != null) {
map = (Map) request.getAttribute("map");
}
Set inPatientSet = new HashSet();
try {
if(map.get("takeSetFromSessionInJsp")!=null)
{
String takeSetFromSessionInJsp=(String)map.get("takeSetFromSessionInJsp");
if(takeSetFromSessionInJsp.equals("false"))
{
inPatientSet=(Set)map.get("inPatientSet");
session.setAttribute("inPatientSet",inPatientSet);
}else{
inPatientSet=(Set) session.getAttribute("inPatientSet");
}
}


} catch (Exception exp) {
exp.printStackTrace();
}
List inPatientDetailList = new ArrayList();
try{
inPatientDetailList=(List)map.get("inPatientDetailList");

}catch(Exception e){
e.printStackTrace();
}
List<IpdTemperature> patientClinicalChartList = new ArrayList<IpdTemperature>();
if(map.get("patientClinicalChartList") != null)
{
	patientClinicalChartList=(List<IpdTemperature>)map.get("patientClinicalChartList");
}
if(map.get("inpatientList") != null)
{
	inpatientList=(List<Inpatient>)map.get("inpatientList");
}
int deptId=0;

if (map.get("deptId") != null) {
deptId = (Integer) map.get("deptId");
}
String deptName="";
if (map.get("deptName") != null) {
deptName = (String) map.get("deptName");
}

if(map.get("message") != null){
String message = (String)map.get("message");
out.println(message);
}
if(map.get("max")!=null)
max = (String) map.get("max");

List<IpdTemperature> ipdTempList = new ArrayList<IpdTemperature>();
if(map.get("ipdTempList")!=null){
	ipdTempList = (List) map.get("ipdTempList");
	}
Patient patient = new Patient();
Inpatient inpatient = new Inpatient();
String patientName ="";
String consultantName = "";
String currentAge = "";
if(inpatientList.size() >0){
	patient = inpatientList.get(0).getHin();
	inpatient = inpatientList.get(0);
	if(patient.getPFirstName() != null)
	   {
       patientName=patient.getPFirstName();
	   }
	if(patient.getPMiddleName() != null)
		   {
		   patientName +=patient.getPMiddleName();
		   }
	if(patient.getPLastName() != null)
		   {
		   patientName +=patient.getPLastName();
		   }
	if(inpatient.getDoctor() !=null){
		/* consultantName=inpatient.getDoctor().getRank().getRankName(); */
		if(inpatient.getDoctor().getFirstName() != null)
		{
			consultantName+=" "+inpatient.getDoctor().getFirstName();	
		}
		if(inpatient.getDoctor().getMiddleName() != null)
		{
			consultantName+= " "+inpatient.getDoctor().getMiddleName();
		}
		if(inpatient.getDoctor().getLastName() != null)
		{
			consultantName+=" "+inpatient.getDoctor().getLastName();
		}
	}
	String age = "";

    if(patient.getAge()!=null)
		age = patient.getAge();
	try{
		if(!age.equals(""))
		currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
	}catch(Exception ex){
		ex.printStackTrace();
	}
}
%>
<form name="nursingClinicalChart" method="post">
<div class="titleBg"><h2>Clinical Entry</h2></div>

<h4>Patient Details</h4>
<div class="Clear"></div>
<div class="Block">

<label>A&D No.</label> <%if(inpatient.getAdNo() != null){ %>
<label class="value"><%=inpatient.getAdNo() %></label> <%}else{ %>
<label class="value">-</label>
<%} %>
<label>Employee No.</label> 
<label class="value"> <%=patient.getServiceNo()!=null?patient.getServiceNo():"" %></label>

<label>Ward </label> <%if(inpatient.getDepartment() != null){ %>
<label class="value"> <%=inpatient.getDepartment().getDepartmentName() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<div class="Clear"></div>
<label>Patient Name</label>
<label	class="value"> <%= patientName %></label>

<label>Relation</label> <%
	if(patient.getRelation() != null){
	%> 
<label class="value"><%= patient.getRelation().getRelationName()%></label>
<%} else{ %> <label
	class="value">-</label> 
	<% }%> 

<label>Designation</label>
<label class="value"><%=patient.getRank()!=null?patient.getRank().getRankName():"" %></label>
<div class="Clear"></div>
<label>Employee Name</label> <%
		String sMiddleName = "";
		String sLastName = "";
		if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
		
			if(patient.getSMiddleName() != null){
				sMiddleName = patient.getSMiddleName();
			}
			if(patient.getSLastName() != null){
				sLastName = patient.getSLastName();
			}
	 %> 
<label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> 
<label class="value">-</label> 
<% }%>
<%-- 
<label>Branch/Trade</label>
<%
if(patient.getTrade() != null){
%> 
<label class="value"><%=  patient.getTrade().getTradeName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%> --%>

<%-- 
<label>Unit</label> <%
if(patient.getUnit() != null){
%> <label class="value"><%= patient.getUnit().getUnitName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%> --%>
<!-- <div class="Clear"></div> -->
<label>Age</label> <%if(!currentAge.equals("")){ %>
<label class="value"> <%=currentAge %></label> <%}else{ %>
<label	class="value">-</label> <%} %>
<label>Gender</label> <%if(patient.getSex() != null){ %>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<%-- 
<label>Med Cat</label>
<label class="value"><%=patient.getCategory()!=null?patient.getCategory().getCategories():"-" %></label>
 --%>

<div class="Clear"></div>

<label>Admitting Doctor</label>
<label class="value"><%=consultantName %></label>
<%-- 
<label>Allergies</label>
<%
String allergies = "";
	if(patient.getDrugAllergies()!=null){
/*	for(AllergyDetail allergyDetail : patient.getAllergyDetails()){
		if(!allergies.equals("")){
			allergies += ",";
		}
		allergies += allergyDetail.getDescription();
	}*/
		allergies = patient.getDrugAllergies();
}%>
<%
	if(!allergies.equals("")){
%>
<label class="valueAuto"><%=allergies %></label>
<%}else{ %>
<label class="value"></label>
<%} %> --%>
<!-- <div class="Clear"></div> -->

<label> Diagnosis</label> 
	<%
	List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
	if(map.get("diagnosisList")!=null){
		diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
		
	}
	if(diagnosisList != null && diagnosisList.size() > 0 && diagnosisList.get(0).getIcd()!=null)
	{
	%> <label class="valueFixedWidth"><%=diagnosisList.get(0).getIcd().getIcdName() %></label>
	<%
		}else{
		%> <label class="value"></label> <%	
		}
		%> 
		<%-- 
<label>Disability</label>
<%
	List<MasMedicalExaminationDetail> disabilityList = new ArrayList<MasMedicalExaminationDetail>();
	if(map.get("disabilityList")!=null){
		disabilityList = (List<MasMedicalExaminationDetail>)map.get("disabilityList");
	}
	
	if(disabilityList != null && disabilityList.size() > 0)
	{
	%> <label class="valueFixedWidth"><%=disabilityList.get(0).getMasIcd()!=null?disabilityList.get(0).getMasIcd().getIcdName():"" %></label>
<%
	}else{
	%> <label class="value"></label> <%	
	}
%>  --%>
<!--<label>Date</label>
<label class="value"><%=currentDate%></label>-->
<div class="Clear"></div>
<!--<label>Time</label>
-->
<input type="hidden"	id="timeId" name="timeForAll" value="<%=time%>" class="calDate"	tabindex=1 onblur="fillTime(this.value)"
	onchange="IsValidTime(this.value,this.id);" /> <!--  <input type="button" class="button" value="Go" onClick="" />-->




<div class="Clear"></div>
</div>

<div class="cmntable">
<table width="100%" border="0" cellpadding="0" cellspacing="0"	id="indentDetails" colspan="7">
	<thead>
		<tr>
			<!--<th width="3%">&nbsp;</th>
			--><th width="13%">Date</th>
			<th width="3%">Time</th>
			<th colspan="2">Temperature</th>
			<th colspan="2">Pulse</th>
			<th colspan="2">Respiration</th>
			<th colspan="2">BP</th>
			<th width="6%">O<sub>2</sub> Saturation</th>
			<th width="6%">Bowel</th>
			<th width="6%">Pain</th>
			<!--<th width="9%">&nbsp;</th>
			<th width="9%">FHR</th>
			<th width="9%">Remarks</th>-->
		</tr>
	</thead>
	<tbody>
		
			<%
String status="status";
String incTime="time";
String incPulse="incPulse";
String incResp="incResp";
String incBp="incBp";
String incFhr="incFhr";
String incRemarks="incRemarks";
String incPulseTemp="incPulseTemp";
String incRespTemp="incRespTemp";
String incBpTemp="incBpTemp";
String incFhrTemp="incFhrTemp";
String incRemarksTemp="incRemarksTemp";
String incTimeTemp="incTimeTemp";
String incPulse2="incPulse";
String incResp2="incResp";
String incBp2="incBp";
String incFhr2="incFhr";
String incRemarks2="incRemarks";
String incPulseTemp2="incPulseTemp";
String incRespTemp2="incRespTemp";
String incTimeTemp2="incTimeTemp";
String incBpTemp2="incBpTemp";
String incFhrTemp2="incFhrTemp";
String incRemarksTemp2="incRemarksTemp";
String status2="status";
//int inc=((pageNo-1)*10)+1;
int inc=1;
int incTemp2=inc+10;
int cnt = 1;
status=status2+(""+inc);
incPulse=incPulse2+(""+inc);
incResp=incResp2+(""+inc);
incBp=incBp2+(""+inc);
incFhr=incFhr2+(""+inc);
incRemarks=incRemarks2+(""+inc);
incPulseTemp=incPulseTemp2+(""+inc);
incRespTemp=incRespTemp2+(""+inc);
incBpTemp=incBpTemp2+(""+inc);
incFhrTemp=incFhrTemp2+(""+inc);
incRemarksTemp=incRemarksTemp2+(""+inc);
incTimeTemp=incTimeTemp2+(""+inc);

if(patientClinicalChartList.size() > 0){

for(IpdTemperature ipdTemperature : patientClinicalChartList){
%>

		<tr>
			<!--<td width="3%">
				</td>-->
			<td width="11%">
			<input type="hidden"	tabindex=3 class="CheckBox" name="parent"		value="<%= ipdTemperature.getId()%>" id="radio" />
			<input type="hidden" name="ipdTemperatureId<%=inc %>" id="ipdTemperatureId<%=inc %>" value="<%= ipdTemperature.getId()%>"/>
				
			<input type="text"
				value="<%=HMSUtil.convertDateToStringWithoutTime(ipdTemperature.getIpdDate()) %>" size="15" name="ipdDate<%=inc %>"
				readonly="readonly" tabindex=3 /></td>
				
			<td width="3%">
			
			<input type="text" id="<%=cnt++%>" value="<%=ipdTemperature.getTime()%>" name="<%=CHANGED_TIME%><%=inc %>" tabindex="1" onKeyUp="mask(this.value,this,'2',':');" value="" validate=" Time,String,no" onblur="IsValidTimeWithBlankCheck(this.value,this.id);" maxlength="5"/>
					
			</td>
			<td width="8%"><input name="<%=TEMPERATURE %><%=inc %>" id="temperature<%=inc %>" size="8" type="text" readonly="readonly" tabindex=1 value="<%=(ipdTemperature.getTemperature()!=null && ipdTemperature.getTemperature()!=0)?ipdTemperature.getTemperature():""%>"/>
				</td>
			<td width="8%"><label><sup>&deg;</sup>F</label></td>
			<script>
				//document.getElementById('temperature<%=inc%>').value = '<%=(ipdTemperature.getTemperature()!=null && ipdTemperature.getTemperature()!=0)?ipdTemperature.getTemperature():""%>';
			</script>
			
			<td width="8%"><input type="hidden" size="2" value="<%=(ipdTemperature.getPulse()!=null && ipdTemperature.getPulse()!=0)?ipdTemperature.getPulse():"" %>"
				class="medcaption" name="<%=PULSE%><%=inc %>" id="incPulse<%=inc %>"
				validate="Pulse,int,no" onchange="checkPulseValidation(this.value);"
				maxlength="4" tabindex=1 /> <input type="text" value="<%=(ipdTemperature.getPulse()!=null && ipdTemperature.getPulse()!=0)?ipdTemperature.getPulse():"" %>" size="5"
				name="<%=PULSE_TEMP%><%=inc %>" id="incPulseTemp<%=inc%>" readonly="readonly"
				onblur="fillClinical(<%=inc %>);" validate="Pulse,int,no"
				onchange="checkPulseValidation(this.value,'<%=inc %>');"
				maxlength="4" tabindex=1 /></td>
			<td width="8%"><label> /min</label></td>
			
			<td width="5%"><input type="text" size="5" value="<%=ipdTemperature.getRespiration()!=null?ipdTemperature.getRespiration():"" %>"
				name="<%=RESPIRATION_TEMP%><%=inc %>" id="incRespTemp<%=inc%>" readonly="readonly"
				onblur="fillClinical(<%=inc %>);" validate="Respiration,int,no"
				onchange="checkRespirationValidation(this.value,'<%=inc %>');"
				maxlength="4" tabindex=1 /> <input type="hidden" size="2" value="<%=ipdTemperature.getRespiration()!=null?ipdTemperature.getRespiration():"0" %>"
				class="medcaption" name="<%=RESPIRATION%><%=inc %>" id="incResp<%=inc%>"
				validate="Respiration,int,no"
				onchange="checkRespirationValidation(this.value);" maxlength="4"
				tabindex=1 /></td>
			<td width="5%"><label> /min</label></td>
			
			<td width="5%"><input type="text" size="5" value="<%=ipdTemperature.getBp()!=null?ipdTemperature.getBp():"" %>"
				name="<%=BP_TEMP%><%=inc %>" id="incBpTemp<%=inc%>" readonly="readonly"
				onblur="validateBpWithSlash(this.value);fillClinical(<%=inc %>);"
				onchange="checkBpValidation(this.value,'<%=inc %>');" maxlength="7"
				tabindex=1 /> <input type="hidden" size="2" value="<%=ipdTemperature.getBp()!=null?ipdTemperature.getBp():"0" %>"
				class="medcaption" name="<%=BP%><%=inc %>" id="incBp<%=inc%>"
				onchange="validateBpWithSlash(this.value);" maxlength="7" tabindex=1 />
			</td>
			<td width="5%"><label> mm/Hg</label></td>
			<td>
			<input type="text" name="o2Saturation<%=inc %>" readonly="readonly" id="o2Saturation<%=inc %>" maxlength="6" size="10" tabindex="1" value="<%=ipdTemperature.getO2Saturation()!=null?ipdTemperature.getO2Saturation():"" %>"/>
			
			</td>
			<td width="6%"><input type="text" name="<%= BOWEL%><%=inc %>" readonly="readonly"
				value="<%=ipdTemperature.getBowel()!=null?ipdTemperature.getBowel():"" %>" size="8" maxlength="10"
				tabindex=1> </td>
			<td width="6%"><input type="text" name="<%= PAIN%><%=inc %>" size="9" id="pain<%=inc %>"tabindex=1 value="<%=(ipdTemperature.getPain()!=null && !ipdTemperature.getPain().equals("0"))?ipdTemperature.getPain():""%>" readonly="readonly"/>
				</td>
			<script>
			//	document.getElementById('pain<%=inc%>').value = '<%=(ipdTemperature.getPain()!=null && !ipdTemperature.getPain().equals("0"))?ipdTemperature.getPain():""%>';
			</script>
			<!--<td width="9%"><label>/min</label></td>
			<td width="9%"><input type="text" value="<%=ipdTemperature.getFhr()!=null?ipdTemperature.getFhr():""%>" size="5"
				name="<%=FHR_TEMP%>" id="incFhrTemp<%=inc%>"
				onblur="fillClinical(<%=inc %>);" validate="Fhr,int,no"
				onchange="checkFhrValidation(this.value,'<%=inc %>');" tabindex=1
				maxlength="3" /> <input type="hidden" size="2" value="<%=ipdTemperature.getFhr()!=null?ipdTemperature.getFhr():"0"%>"
				class="medcaption" name="<%=FHR%>" id="incFhr<%=inc%>"
				validate="Fhr,string,no" onchange="checkFhrValidation(this.value);"
				tabindex=1 /></td>
			<td width="9%"><input type="text" value="<%=ipdTemperature.getRemarks()!=null?ipdTemperature.getRemarks():""%>" size="30"
				name="<%=REMARKS_TEMP%>" id="incRemarksTemp<%=inc%>"
				onblur="fillClinical(<%=inc %>);" validate="Remarks,string,no"
				tabindex=1 maxlength="30" /> <input type="hidden" size="2"
				value="emptyString" class="medcaptionsize15" name="<%=REMARKS%>"
				id="incRemarks<%=inc%>" validate="Remarks,string,no" tabindex=1 /></td>-->
	<input type="hidden" class="medcaption" name="" 		value="<%=patient.getId()%>" />
		<input type="hidden" class="medcaption" name=""		value="<%=inpatient.getId()%>" />
	<input type="hidden" class="medcaption" name="" value="n" 		id="status<%=inc%>" />
	<input type="hidden" class="medcaption" name=""	value="<%=inpatient.getAdNo()%>" />
		</tr>
	<%inc++;
	}} %>
	<tr>
			<!--<td width="3%">
			
				</td>
			--><td width="11%">
			<input type="hidden"
				tabindex=3 class="CheckBox" name="parent"
				value="" id="radio" />
			<input type="hidden" name="ipdTemperatureId<%=inc %>" id="ipdTemperatureId<%=inc %>" value="0"/>
			<input type="text"
				value="<%=currentDate%>" size="15" name="ipdDate<%=inc %>"
				readonly="readonly" tabindex=3 /></td>
				
			<td width="3%">
			<input type="text" id="<%=cnt++%>" value="<%=time%>" name="<%=CHANGED_TIME%><%=inc %>"  tabindex="3" onKeyUp="mask(this.value,this,'2',':');" value="" validate="Time,String,no" onblur="IsValidTimeWithBlankCheck(this.value,this.id);" maxlength="5"/>
			</td>
			<td width="8%"><select name="<%=TEMPERATURE %><%=inc %>" id="temperature<%=inc %>"
				onchange="changeStatus(<%=inc %>);" tabindex=1 class="auto">
				<option value="0">Select</option>
				<option value="97.0">97</option>
				<option value="97.2">97.2</option>
				<option value="97.4">97.4</option>
				<option value="97.6">97.6</option>
				<option value="97.8">97.8</option>
				<option value="98.0">98</option>
				<option value="98.2">98.2</option>
				<option value="98.4">98.4</option>
				<option value="98.6">98.6</option>
				<option value="98.8">98.8</option>
				<option value="99.0">99</option>
				<option value="99.2">99.2</option>
				<option value="99.4">99.4</option>
				<option value="99.6">99.6</option>
				<option value="99.8">99.8</option>
				<option value="100.0">100</option>
				<option value="100.2">100.2</option>
				<option value="100.4">100.4</option>
				<option value="100.6">100.6</option>
				<option value="100.8">100.8</option>
				<option value="101.0">101</option>
				<option value="101.2">101.2</option>
				<option value="101.4">101.4</option>
				<option value="101.6">101.6</option>
				<option value="101.8">101.8</option>
				<option value="102.0">102</option>
				<option value="102.2">102.2</option>
				<option value="102.4">102.4</option>
				<option value="102.6">102.6</option>
				<option value="102.8">102.8</option>
				<option value="103.0">103</option>
				<option value="103.2">103.2</option>
				<option value="103.4">103.4</option>
				<option value="103.6">103.6</option>
				<option value="103.8">103.8</option>
				<option value="104.0">104</option>
				<option value="104.2">104.2</option>
				<option value="104.4">104.4</option>
				<option value="104.6">104.6</option>
				<option value="104.8">104.8</option>
				<option value="105.0">105</option>
				<option value="105.2">105.2</option>
				<option value="105.2">105.4</option>
				<option value="105.6">105.6</option>
				<option value="105.8">105.8</option>
				<option value="106.0">106</option>
			</select></td>
			<td width="8%"><label><sup>&deg;</sup>F</label></td>
			<td width="8%"><input type="hidden" size="2" value="0"
				class="medcaption" name="<%=PULSE%><%=inc %>" id="incPulse<%=inc%>"
				validate="Pulse,int,no" onchange="checkPulseValidation(this.value);"
				maxlength="4" tabindex=1 /> <input type="text" value="" size="5"
				name="<%=PULSE_TEMP%><%=inc %>" id="incPulseTemp<%=inc%>"
				onblur="fillClinical(<%=inc %>);" validate="Pulse,int,no"
				onchange="checkPulseValidation(this.value,'<%=inc %>');"
				maxlength="4" tabindex=1 /></td>
			<td width="8%"><label> /min</label></td>
			<td width="5%"><input type="text" size="5" value=""
				name="<%=RESPIRATION_TEMP%><%=inc %>" id="incRespTemp<%=inc%>"
				onblur="fillClinical(<%=inc %>);" validate="Respiration,int,no"
				onchange="checkRespirationValidation(this.value,'<%=inc %>');"
				maxlength="4" tabindex=1 /> <input type="hidden" size="2" value="0"
				class="medcaption" name="<%=RESPIRATION%><%=inc %>" id="incResp<%=inc%>"
				validate="Respiration,int,no"
				onchange="checkRespirationValidation(this.value);" maxlength="4"
				tabindex=1 /></td>
			<td width="5%"><label> /min</label></td>
			
			<td width="5%"><input type="text" size="5" value=""
				name="<%=BP_TEMP%><%=inc %>" id="incBpTemp<%=inc%>"
				onblur="validateBpWithSlash(this.value);fillClinical(<%=inc %>);"
				onchange="checkBpValidation(this.value,'<%=inc %>');" maxlength="7"
				tabindex=1 /> <input type="hidden" size="2" value="0"
				class="medcaption" name="<%=BP%><%=inc %>" id="incBp<%=inc%>"
				onchange="validateBpWithSlash(this.value);" maxlength="7" tabindex=1 />
			</td>
			<td width="5%"><label> mm/Hg</label></td>
			<td>
			<input type="text" name="o2Saturation<%=inc %>" id="o2Saturation<%=inc %>" maxlength="6" tabindex="1" size="10"/>
			
			</td>
			<td width="6%"><input type="text" name="<%= BOWEL%><%=inc %>" id="bowel<%=inc %>"
				onchange="changeStatus(<%=inc %>);" value="" size="8" maxlength="10"
				tabindex=1> </td>
			<td width="6%"><select name="<%= PAIN%><%=inc %>" id="pain<%=inc %>"
				onchange="changeStatus(<%=inc %>);" tabindex=1 class="auto">
				<option value="0">Select</option>
				<option value="P1">P1</option>
				<option value="P2">P2</option>
				<option value="P3">P3</option>
				<option value="P4">P4</option>
				<option value="P5">P5</option>
				<option value="P6">P6</option>
				<option value="P7">P7</option>
				<option value="P8">P8</option>
				<option value="P9">P9</option>
				<option value="P10">P10</option>
			</select></td>
		<!--	<td width="9%"><label>/min</label></td>
			<td width="9%"><input type="text" value="" size="5"
				name="<%=FHR_TEMP%>" id="incFhrTemp<%=inc%>"
				onblur="fillClinical(<%=inc %>);" validate="Fhr,int,no"
				onchange="checkFhrValidation(this.value,'<%=inc %>');" tabindex=1
				maxlength="3" /> <input type="hidden" size="2" value="0"
				class="medcaption" name="<%=FHR%>" id="incFhr<%=inc%>"
				validate="Fhr,string,no" onchange="checkFhrValidation(this.value);"
				tabindex=1 /></td>
			<td width="9%"><input type="text" value="" size="30"
				name="<%=REMARKS_TEMP%>" id="incRemarksTemp<%=inc%>"
				onblur="fillClinical(<%=inc %>);" validate="Remarks,string,no"
				tabindex=1 maxlength="30" /> <input type="hidden" size="2"
				value="emptyString" class="medcaptionsize15" name="<%=REMARKS%>"
				id="incRemarks<%=inc%>" validate="Remarks,string,no" tabindex=1 /></td>-->
	
	<input type="hidden" class="medcaption" name=<%=HIN_ID %>
		value="<%=patient.getId()%>" />
	<input type="hidden" class="medcaption" name=<%=INPATIENT_ID %>
		value="<%=inpatient.getId()%>" />
	<input type="hidden" class="medcaption" name=<%=STATUS%> value="n"
		id="status<%=inc%>" />
	<input type="hidden" class="medcaption" name=<%=AD_NO%>
		value="<%=inpatient.getAdNo()%>" />
	
		</tr>
	

	</tbody>
</table>
</div>
<input type="hidden" name="counter" id="counter" value="<%= inc %>"/>
<div class="Clear"></div>
<div class="division"></div>
<input type="hidden" value="" name="adminNo" id="adminNo" />
<input	type="hidden" value="" name="srNo" id="srNo" />
<input type="hidden"	name="pageNo" value="<%=pageNo%>" />
<input type="hidden"	name="<%=NO_OF_ROWS%>" id="rr" value="22" />
<input type="button"	name="sss" class="button" value="Submit"	onclick="submitForm('nursingClinicalChart','ipd?method=submitNursingClinicalChart','validateClinicalFields');" />
<!--<input type="button" class="button" value="Print" align="left"
	onClick="{submitForm('nursingClinicalChart','/hms/hms/discharge?method=showClinicalSheetReport&admissionNumber='+document.getElementById('adminNo').value+'&serviceNo='+document.getElementById('srNo').value,'validateRadio');}" />
-->

<input type="button" class="button" value="Back" align="left"	onClick="submitForm('nursingClinicalChart','ipd?method=showPatientListJsp');" />
<input type="reset" name="reset" value="Reset"/>
<!--<input type="button" class="button" value="View" align="left"
	onClick="submitForm('nursingClinicalChart','ipd?method=showViewClinicalChartJsp','validateRadio');" />
--></form>
<div class="Clear"></div>
<div class="division"></div>
<script>
function validateClinicalFields(){
	var inc = document.getElementById('counter').value;
	var flag = '';
	if(document.getElementById('temperature'+inc).value != '0'){
		flag = 'filled';
	}
	if(document.getElementById('incPulseTemp'+inc).value != ''){
		flag = 'filled';
	}
	if(document.getElementById('incRespTemp'+inc).value != ''){
		flag = 'filled';
	}
	if(document.getElementById('incBpTemp'+inc).value != ''){
		flag = 'filled';
	}
	if(document.getElementById('o2Saturation'+inc).value != ''){
		flag = 'filled';
	}
	if(document.getElementById('bowel'+inc).value != ''){
		flag = 'filled';
	}
	if(document.getElementById('pain'+inc).value != '0'){
		flag = 'filled';
	}
	if(flag==''){
		alert("Please enter value.");
		return false;
	}
	return true;
}

function validateRow(){
	var count = document.getElementById('counter').value;
	var flag = false;
	for(var i=1;i<count;i++){
		if(document.getElementById('status'+i).value == 'y'){
			flag=true;
			break;
		}

	}
	if(flag==false){
		alert("Please enter value in atleast one row.");
		return false;
		
	}
	return true;
}

</script>

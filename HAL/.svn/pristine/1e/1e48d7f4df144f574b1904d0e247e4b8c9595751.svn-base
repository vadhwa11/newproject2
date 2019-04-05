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
<%@page import="jkt.hms.masters.business.IpdTemperature"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
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
String time = (String) utilMap.get("currentTime");
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
int deptId=0;

if (map.get("deptId") != null) {
deptId = (Integer) map.get("deptId");
}
String deptName="";
if (map.get("deptName") != null) {
deptName = (String) map.get("deptName");
}
if(map.get("inpatientList")!=null){
inpatientList = (List) map.get("inpatientList");
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

int k=0;
if(inpatientList.size()>0)
for (Inpatient inpatient : inpatientList){
%>
<script>

indentArray[<%=k%>]= new Array();
indentArray[<%=k%>][0] = "<%=inpatient.getId()%>";
indentArray[<%=k%>][1] = "<%=inpatient.getAdNo()%>";
indentArray[<%=k%>][2] = "<%=inpatient.getHin().getPFirstName()+" "+inpatient.getHin().getPMiddleName()+" "+inpatient.getHin().getPLastName()%>";
indentArray[<%=k%>][3] = "" ;
indentArray[<%=k%>][4] = "";
indentArray[<%=k%>][5] = "";
indentArray[<%=k%>][6] = "";
indentArray[<%=k%>][7] = "" ;
indentArray[<%=k%>][8] = "";
indentArray[<%=k%>][9] = "";
indentArray[<%=k%>][10] = "";
indentArray[<%=k%>][11] = "";
</script>
<%
k++;
} %>

<form name="nursingClinicalChart" method="post">
<div class="titleBg"><h2>Clinical Chart</h2></div>
<div class="Clear"></div>
<!--<h4><%=deptName%></h4>
--><div class="Clear"></div>
<div class="Block">
<label>Date</label>
<label class="value" id="time"><%=clinicalDate%></label>
<div id="testDiv">
<label>Time</label>
<input type="text"	id="timeId" name="timeForAll" value="<%=time%>" class="calDate"	tabindex=1 onblur="fillTime(this.value)"
	onchange="IsValidTime(this.value,this.id);" /> <!--  <input type="button" class="button" value="Go" onClick="" />-->
</div>
<div class="Clear"></div>
</div>
<div class="Clear paddingTop15"></div>

<div class="cmntable">
<table width="100%" border="0" cellpadding="0" cellspacing="0"	id="indentDetails" colspan="7">
	<thead>
		<tr>
			<th width="3%">&nbsp;</th>
			<th width="11%">Ad No</th>
			<th width="13%">Patient Name</th>
			<th width="3%">Time</th>
			<th colspan="2">Temperature</th>
			<th colspan="2">Pulse</th>
			<th colspan="2">Respiration</th>
			<th colspan="2">BP</th>
			<th width="6%">Bowel</th>
			<th width="6%">Pain</th>
			<th width="9%">&nbsp;</th>
			<th width="9%">FHR</th>
			<th width="9%">Remarks</th>
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
int inc=((pageNo-1)*10)+1;
int incTemp2=inc+10;
int cnt = 1;
for(Inpatient inpatientObj : inpatientList){
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
%>
<%--
<%
int pulse = 0;
int resp =0;
String bp = "";
String bowel = "";
String pain = "";
String fhr = "";
String remarks ="";
String temp = "";

float temperature = 0.0f;
	if(ipdTempList.size() > 0){
		for(IpdTemperature ipdTemperature : ipdTempList){
			if(ipdTemperature.getIntakeoutput().getAdNo().equals(inpatientObj.getAdNo())){
				System.out.println("111 if");
				
				if(ipdTemperature.getTime() != null)
					time = ipdTemperature.getTime();
				if(ipdTemperature.getTemperature() != null)
					temperature = ipdTemperature.getTemperature();
				
				if(ipdTemperature.getPulse()!= null)
				 	pulse = ipdTemperature.getPulse();
				
				if(ipdTemperature.getRespiration()!= null)
					resp = ipdTemperature.getRespiration();
				
				if(ipdTemperature.getBp()!= null)
					 bp = ipdTemperature.getBp();
					
				if(ipdTemperature.getBowel()!= null)
					bowel = ipdTemperature.getBowel();
				
				if(ipdTemperature.getPain()!= null)
					pain = ipdTemperature.getPain();
				
				if(ipdTemperature.getFhr()!= null)
					 fhr = ipdTemperature.getFhr();
					
				if(ipdTemperature.getRemarks()!= null)
					remarks = ipdTemperature.getRemarks();
				break;
			}
		}
%>

<tr>
<td width="3%"><input type="radio"
				onchange="fillHin('<%=inpatientObj.getAdNo()%>','<%=inpatientObj.getHin().getServiceNo()%>');"
				tabindex=3 class="CheckBox" name="parent"
				value="<%= inpatientObj.getAdNo()%>" id="radio" /></td>
			<td width="11%"><input type="text"
				value="<%=inpatientObj.getAdNo() %>" size="15" name="<%=AD_NO%>"
				readonly="readonly" tabindex=3 /></td>
				<%
				  String patientName=inpatientObj.getHin().getPFirstName();
	        	  if( inpatientObj.getHin().getPMiddleName() != null)
	        		  patientName += " "+inpatientObj.getHin().getPMiddleName();
	        	  if(inpatientObj.getHin().getPLastName()!= null)
	        	  	  patientName += " "+inpatientObj.getHin().getPLastName();
				%>
			<td width="13%"><input type="text" size="20"
				value="<%=patientName %>"
				name="<%=PATIENT_NAME%>" readonly="readonly" tabindex=3 /></td>
			<td width="3%"><input type="text" size="8" value="<%=time%>" maxlength="8"
				name="<%=CHANGED_TIME%>" id="<%=cnt++%>" tabindex=3 onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);"
				/></td>
			<td width="8%"><label><sup>&deg;</sup>F</label></td>
			<td width="8%"><select name="<%=TEMPERATURE %>" id="temperature<%= inc %>"
				onchange="changeStatus(<%=inc %>);" tabindex=1 class="auto">
				<option value="0">Select</option>
				<option value="97">97</option>
				<option value="97.2">97.2</option>
				<option value="97.4">97.4</option>
				<option value="97.6">97.6</option>
				<option value="97.8">97.8</option>
				<option value="98">98</option>
				<option value="98.2">98.2</option>
				<option value="98.4">98.4</option>
				<option value="98.6">98.6</option>
				<option value="98.8">98.8</option>
				<option value="99">99</option>
				<option value="99.2">99.2</option>
				<option value="99.4">99.4</option>
				<option value="99.6">99.6</option>
				<option value="99.8">99.8</option>
				<option value="100">100</option>
				<option value="100.2">100.2</option>
				<option value="100.4">100.4</option>
				<option value="100.6">100.6</option>
				<option value="100.8">100.8</option>
				<option value="101">101</option>
				<option value="101.2">101.2</option>
				<option value="101.4">101.4</option>
				<option value="101.6">101.6</option>
				<option value="101.8">101.8</option>
				<option value="102">102</option>
				<option value="102.2">102.2</option>
				<option value="102.4">102.4</option>
				<option value="102.6">102.6</option>
				<option value="102.8">102.8</option>
				<option value="103">103</option>
				<option value="103.2">103.2</option>
				<option value="103.4">103.4</option>
				<option value="103.6">103.6</option>
				<option value="103.8">103.8</option>
				<option value="104">104</option>
				<option value="104.2">104.2</option>
				<option value="104.4">104.4</option>
				<option value="104.6">104.6</option>
				<option value="104.8">104.8</option>
				<option value="105">105</option>
				<option value="105.2">105.2</option>
				<option value="105.2">105.4</option>
				<option value="105.6">105.6</option>
				<option value="105.8">105.8</option>
				<option value="106">106</option>
			</select>
			<script type="text/javascript">
			<%
				if(temperature != 0.0f){
			%>
				document.getElementById('temperature<%= inc %>').value='<%=temperature%>'
			<%}%>
			</script>
			</td>
			<td width="8%"><label> /min</label></td>
			<td width="8%">
		
			<input type="hidden" size="2" value="0"
				class="medcaption" name="<%=PULSE%>" id="<%=incPulse%>"
				validate="Pulse,int,no" onchange="checkPulseValidation(this.value);"
				maxlength="4" tabindex=1 /> <input type="text" value="<%= pulse %>" size="5"
				name="<%=PULSE_TEMP%>" id="<%=incPulseTemp%>"
				onblur="fillClinical(<%=inc %>);" validate="Pulse,int,no"
				onchange="checkPulseValidation(this.value,'<%=inc %>');"
				maxlength="4" tabindex=1 /></td>
			<td width="5%"><label> /min</label></td>
			<td width="5%"><input type="text" size="5" value="<%= resp %>"
				name="<%=RESPIRATION_TEMP%>" id="<%=incRespTemp%>"
				onblur="fillClinical(<%=inc %>);" validate="Respiration,int,no"
				onchange="checkRespirationValidation(this.value,'<%=inc %>');"
				maxlength="4" tabindex=1 /> <input type="hidden" size="2" value="0"
				class="medcaption" name="<%=RESPIRATION%>" id="<%=incResp%>"
				validate="Respiration,int,no"
				onchange="checkRespirationValidation(this.value);" maxlength="4"
				tabindex=1 /></td>
			<td width="5%"><label> mm/hg</label></td>
			<td width="5%"><input type="text" size="5" value="<%= bp %>"
				name="<%=BP_TEMP%>" id="<%=incBpTemp%>"
				onblur="validateBpWithSlash(this.value);fillClinical(<%=inc %>);"
				onchange="checkBpValidation(this.value,'<%=inc %>');" maxlength="7"
				tabindex=1 /> <input type="hidden" size="2" value="0"
				class="medcaption" name="<%=BP%>" id="<%=incBp%>"
				onchange="validateBpWithSlash(this.value);" maxlength="7" tabindex=1 />
			</td>
			<td width="6%"><input name="<%= BOWEL%>"
				onchange="changeStatus(<%=inc %>);" value="<%= bowel %>" size="8" maxlength="3"
				tabindex=1> </td>
			<td width="6%"><select name="<%= PAIN%>" id="pain<%=inc  %>"
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
			<script type="text/javascript">
			<%
				if(!pain.equals("")){
			%>
				document.getElementById('pain<%= inc %>').value='<%=pain%>';
			<%}%>
			</script>
			<td width="9%"><label>/min</label></td>
			<td width="9%"><input type="text" value="<%= fhr %>" size="5"
				name="<%=FHR_TEMP%>" id="<%=incFhrTemp%>"
				onblur="fillClinical(<%=inc %>);" validate="Fhr,int,no"
				onchange="checkFhrValidation(this.value,'<%=inc %>');" tabindex=1
				maxlength="3" /> <input type="hidden" size="2" value="0"
				class="medcaption" name="<%=FHR%>" id="<%=incFhr%>"
				validate="Fhr,string,no" onchange="checkFhrValidation(this.value);"
				tabindex=1 /></td>
			<td width="9%"><input type="text" value="<%= remarks %>" size="30"
				name="<%=REMARKS_TEMP%>" id="<%=incRemarksTemp%>"
				onblur="fillClinical(<%=inc %>);" validate="Remarks,string,no"
				tabindex=1 maxlength="30" /> <input type="hidden" size="2"
				value="emptyString" class="medcaptionsize15" name="<%=REMARKS%>"
				id="<%=incRemarks%>" validate="Remarks,string,no" tabindex=1 /></td>
		</tr>



<%	
		}else{
			System.out.println("3333 if");
		%> --%>
		<tr>
			<td width="3%"><input type="radio"
				onchange="fillHin('<%=inpatientObj.getAdNo()%>','<%=inpatientObj.getHin().getServiceNo()%>');"
				tabindex=3 class="CheckBox" name="parent"
				value="<%= inpatientObj.getAdNo()%>" id="radio" /></td>
			<td width="11%"><input type="text"
				value="<%=inpatientObj.getAdNo() %>" size="15" name="<%=AD_NO%>"
				readonly="readonly" tabindex=3 /></td>
				<%
				  String patientName=inpatientObj.getHin().getPFirstName();
	        	  if( inpatientObj.getHin().getPMiddleName() != null)
	        		  patientName += " "+inpatientObj.getHin().getPMiddleName();
	        	  if(inpatientObj.getHin().getPLastName()!= null)
	        	  	  patientName += " "+inpatientObj.getHin().getPLastName();
				%>
			<td width="13%"><input type="text" size="20"
				value="<%=patientName %>"
				name="<%=PATIENT_NAME%>" readonly="readonly" tabindex=3 /></td>
			<td width="3%"><input type="text" size="8" value="<%=time%>" maxlength="8"
				name="<%=CHANGED_TIME%>" id="<%=cnt++%>" tabindex=3 onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);"
				/></td>
			<td width="8%"><label><sup>&deg;</sup>F</label></td>
			<td width="8%"><select name="<%=TEMPERATURE %>"
				onchange="changeStatus(<%=inc %>);" tabindex=1 class="auto">
				<option value="0">Select</option>
				<option value="97">97</option>
				<option value="97.2">97.2</option>
				<option value="97.4">97.4</option>
				<option value="97.6">97.6</option>
				<option value="97.8">97.8</option>
				<option value="98">98</option>
				<option value="98.2">98.2</option>
				<option value="98.4">98.4</option>
				<option value="98.6">98.6</option>
				<option value="98.8">98.8</option>
				<option value="99">99</option>
				<option value="99.2">99.2</option>
				<option value="99.4">99.4</option>
				<option value="99.6">99.6</option>
				<option value="99.8">99.8</option>
				<option value="100">100</option>
				<option value="100.2">100.2</option>
				<option value="100.4">100.4</option>
				<option value="100.6">100.6</option>
				<option value="100.8">100.8</option>
				<option value="101">101</option>
				<option value="101.2">101.2</option>
				<option value="101.4">101.4</option>
				<option value="101.6">101.6</option>
				<option value="101.8">101.8</option>
				<option value="102">102</option>
				<option value="102.2">102.2</option>
				<option value="102.4">102.4</option>
				<option value="102.6">102.6</option>
				<option value="102.8">102.8</option>
				<option value="103">103</option>
				<option value="103.2">103.2</option>
				<option value="103.4">103.4</option>
				<option value="103.6">103.6</option>
				<option value="103.8">103.8</option>
				<option value="104">104</option>
				<option value="104.2">104.2</option>
				<option value="104.4">104.4</option>
				<option value="104.6">104.6</option>
				<option value="104.8">104.8</option>
				<option value="105">105</option>
				<option value="105.2">105.2</option>
				<option value="105.2">105.4</option>
				<option value="105.6">105.6</option>
				<option value="105.8">105.8</option>
				<option value="106">106</option>
			</select></td>
			<td width="8%"><label> /min</label></td>
			<td width="8%"><input type="hidden" size="2" value="0"
				class="medcaption" name="<%=PULSE%>" id="<%=incPulse%>"
				validate="Pulse,int,no" onchange="checkPulseValidation(this.value);"
				maxlength="4" tabindex=1 /> <input type="text" value="" size="5"
				name="<%=PULSE_TEMP%>" id="<%=incPulseTemp%>"
				onblur="fillClinical(<%=inc %>);" validate="Pulse,int,no"
				onchange="checkPulseValidation(this.value,'<%=inc %>');"
				maxlength="4" tabindex=1 /></td>
			<td width="5%"><label> /min</label></td>
			<td width="5%"><input type="text" size="5" value=""
				name="<%=RESPIRATION_TEMP%>" id="<%=incRespTemp%>"
				onblur="fillClinical(<%=inc %>);" validate="Respiration,int,no"
				onchange="checkRespirationValidation(this.value,'<%=inc %>');"
				maxlength="4" tabindex=1 /> <input type="hidden" size="2" value="0"
				class="medcaption" name="<%=RESPIRATION%>" id="<%=incResp%>"
				validate="Respiration,int,no"
				onchange="checkRespirationValidation(this.value);" maxlength="4"
				tabindex=1 /></td>
			<td width="5%"><label> mm/hg</label></td>
			<td width="5%"><input type="text" size="5" value=""
				name="<%=BP_TEMP%>" id="<%=incBpTemp%>"
				onblur="validateBpWithSlash(this.value);fillClinical(<%=inc %>);"
				onchange="checkBpValidation(this.value,'<%=inc %>');" maxlength="7"
				tabindex=1 /> <input type="hidden" size="2" value="0"
				class="medcaption" name="<%=BP%>" id="<%=incBp%>"
				onchange="validateBpWithSlash(this.value);" maxlength="7" tabindex=1 />
			</td>
			<td width="6%"><input name="<%= BOWEL%>"
				onchange="changeStatus(<%=inc %>);" value="" size="8" maxlength="3"
				tabindex=1> </select></td>
			<td width="6%"><select name="<%= PAIN%>"
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
			<td width="9%"><label>/min</label></td>
			<td width="9%"><input type="text" value="" size="5"
				name="<%=FHR_TEMP%>" id="<%=incFhrTemp%>"
				onblur="fillClinical(<%=inc %>);" validate="Fhr,int,no"
				onchange="checkFhrValidation(this.value,'<%=inc %>');" tabindex=1
				maxlength="3" /> <input type="hidden" size="2" value="0"
				class="medcaption" name="<%=FHR%>" id="<%=incFhr%>"
				validate="Fhr,string,no" onchange="checkFhrValidation(this.value);"
				tabindex=1 /></td>
			<td width="9%"><input type="text" value="" size="30"
				name="<%=REMARKS_TEMP%>" id="<%=incRemarksTemp%>"
				onblur="fillClinical(<%=inc %>);" validate="Remarks,string,no"
				tabindex=1 maxlength="30" /> <input type="hidden" size="2"
				value="emptyString" class="medcaptionsize15" name="<%=REMARKS%>"
				id="<%=incRemarks%>" validate="Remarks,string,no" tabindex=1 /></td>
		</tr>
		<%//} %>
	</tbody>
	<input type="hidden" class="medcaption" name=<%=HIN_ID %>
		value="<%=inpatientObj.getHin().getId()%>" />
	<input type="hidden" class="medcaption" name=<%=STATUS%> value="n"
		id="<%=status%>" />
	<%inc++;
	} %>
</table>
</div>
<input type="hidden" name="counter" id="counter" value="<%= inc %>"/>
<div class="Clear"></div>
<div class="division"></div>
<input type="hidden" value="" name="adminNo" id="adminNo" />
<input	type="hidden" value="" name="srNo" id="srNo" />
<input type="hidden"	name="pageNo" value="<%=pageNo%>" />
<input type="hidden"	name="<%=NO_OF_ROWS%>" id="rr" value="22" />
<input type="button"	name="sss" class="button" value="Submit"	onclick="submitForm('nursingClinicalChart','ipd?method=submitNursingClinicalChart','validateRow');" />
<!--<input type="button" class="button" value="Print" align="left"
	onClick="{submitForm('nursingClinicalChart','/hms/hms/discharge?method=showClinicalSheetReport&admissionNumber='+document.getElementById('adminNo').value+'&serviceNo='+document.getElementById('srNo').value,'validateRadio');}" />
-->
<input type="button" class="button" value="Back" align="left"	onClick="submitForm('nursingClinicalChart','ipd?method=showPatientListJsp');" />
<input type="button" class="button" value="View" align="left"
	onClick="submitForm('nursingClinicalChart','ipd?method=showViewClinicalChartJsp','validateRadio');" />
</form>
<div class="Clear"></div>
<div class="division"></div>
<script>
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

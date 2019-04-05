<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showPatientList.jsp  
 * Purpose of the JSP -  This is Show Patient List.
 * @author  Dipali
 * Revision Date:      
 * Revision By:  
 * @version 1.15
--%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.SilDilStatus"%>
<%@page import="jkt.hms.masters.business.Visit"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<!--[if lt IE 9]>
        <link href="/hms/jsp/css/ie.css" rel="stylesheet" type="text/css" />
<![endif]-->
<!-- script for fixed header table starts -->

<!--[if IE 9]>
<link href="/hms/jsp/css/ie.css" rel="stylesheet" type="text/css" />
<![endif]-->
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<%
		Map map = new HashMap();
        String url = "";
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		Map<String, Object> mapSmc = new HashMap<String, Object>();
		if(map.get("mapSmc") != null){
			mapSmc = (Map<String, Object>)map.get("mapSmc");
		 }
		 if(map.get("url") != null)
		  {
			url = ""+map.get("url");
		  }
		
		int visitIdForOpd = 0;
		int token = 0;
		String backFlag = "";
		if(map.get("token") != null){
			token = (Integer)map.get("token");
		}
		if(map.get("backFlag") != null){
			backFlag = (String)map.get("backFlag");
		}
		if(map.get("visitId") != null){
			visitIdForOpd = (Integer)map.get("visitId");
		}
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		if(mapSmc.get("medExamList") != null){
			medExamList = (List<MasMedicalExaminationReportOnEntry>)mapSmc.get("medExamList");
		 }
		if(medExamList.size()>0)
		 {
			int visitId=medExamList.get(0).getVisit().getId();
			String  medExamType = medExamList.get(0).getMedicalExamType();
			url=url+"&visitId="+visitId+"&medExamType="+medExamType;
		 }
		if(medExamList!=null && medExamList.size()>0){	
%>
<div class="titleBg"><h2>Details Of Annual Medical Examination</h2></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<form name="opd_previousVisitForMedicalExampVal" method="post" action="">
<!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script type="text/javascript" language="javascript">
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"], [1,"<%= RequestConstants.DATE %>"],[2,"<%=RequestConstants.UNIT%>"],[3,"<%= RequestConstants.WEIGHT %>"],[4,"<%=RequestConstants.BP%>"],[5,"ecg"],[6,"xray"],[7,"abnormality"],[8,"medCat"],[9,"datasource"] ];
	 statusTd =13;
</script></div>
<div id="edited"></div>
<div id="statusMessage" ></div>
<input type="hidden" name="serviceNoForReport" id="serviceNoForReport"	value="" />
<input type="hidden" name="visitNumberForReport"	id="visitNumberForReport" value="" />
<input type="hidden" name="hinNoForReport" id="hinNoForReport" value="" />
<script	type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = ""
		data_header[0][1] = "radio";
		data_header[0][2] = "10%";
		data_header[0][3] = "<%=RequestConstants.RADIO_FOR_TABLE %>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Date"
		data_header[1][1] = "data";
		data_header[1][2] = "10%";
		data_header[1][3] = "<%= RequestConstants.DATE%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Unit"
		data_header[2][1] = "data";
		data_header[2][2] = "10%";
		data_header[2][3] = "<%=RequestConstants.UNIT %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Wt"
		data_header[3][1] = "data";
		data_header[3][2] = "10%";
		data_header[3][3] = "<%= RequestConstants.WEIGHT %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "BP"
		data_header[4][1] = "data";
		data_header[4][2] = "10%";
		data_header[4][3] = "<%=RequestConstants.BP%>";
		
		data_header[5] = new Array;
		data_header[5][0] = "ECG"
		data_header[5][1] = "data";
		data_header[5][2] = "10%";
		data_header[5][3] = "ecg";
		
		data_header[6] = new Array;
		data_header[6][0] = "X Ray"
		data_header[6][1] = "data";
		data_header[6][2] = "10%";
		data_header[6][3] = "xray";
		
		data_header[7] = new Array;
		data_header[7][0] = "Final Observation"
		data_header[7][1] = "data";
		data_header[7][2] = "20%";
		data_header[7][3] = "finalObservation";
		
		data_header[8] = new Array;
		data_header[8][0] = "Med Cat"
		data_header[8][1] = "data";
		data_header[8][2] = "10%";
		data_header[8][3] = "medCat";
				
		data_arr = new Array();
<%
int  i=0;
try{
String st="";
 for(MasMedicalExaminationReportOnEntry medExam : medExamList)
  {   
      if(medExam.getDateOfReporting()!= null && medExam.getMedicalExamType() !=null){
%>
data_arr[<%= i%>] = new Array();
data_arr[<%= i%>][0] ="<%=medExam.getId()%>"
data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=medExam.getId()%>" id="parent" onclick="fillMedExamId(this)"/>'
					
<%
if(medExam.getMedicalExamType().equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)")&&(medExam.getDateOfReporting()!=null))
   {%>
data_arr[<%=i%>][2] = "<%=HMSUtil.changeDateToddMMyyyy(medExam.getDateOfReporting())%>"
<%}else if(medExam.getMedicalExamType().equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)")&&(medExam.getDateDischarge()!=null))
{%>
data_arr[<%= i%>][2] = "<%=HMSUtil.changeDateToddMMyyyy(medExam.getDateDischarge())%>"
<%}else{%>
data_arr[<%= i%>][2] = ""   
<%}%>
			
<%
if(medExam.getUnit()!=null){
%>
data_arr[<%= i%>][3] = "<%=medExam.getUnit().getUnitName()%>"

<%}else{
%>
data_arr[<%= i%>][3] = "";
<%}%>
<%
if(medExam.getWeight()!=null){
%>
data_arr[<%= i%>][4]="<%=medExam.getWeight()%>"
<%}else{
%>
data_arr[<%= i%>][4] = "";
<%}%>
<%
if(medExam.getBp()!=null){
%>
data_arr[<%= i%>][5] = "<%=medExam.getBp()%>"
<%}else{
%>
data_arr[<%= i%>][5] = "";
<%}%>
<%
if(medExam.getEcg()!=null){
%>
data_arr[<%= i%>][6] = "<%=medExam.getEcg()%>"
<%}else{
%>
data_arr[<%= i%>][6] = "";
<%}%>
<%
if(medExam.getXray()!=null){
%>
data_arr[<%= i%>][7] = "<%=medExam.getXray()%>"
<%}else{
%>
data_arr[<%= i%>][7] = "";
<%}%>
<%if(medExam.getMedicalExamType().equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)") && (medExam.getPerFinalObservation()!=null))
{%>
data_arr[<%=i%>][8] = "<%=medExam.getPerFinalObservation()%>"
<%}else if(medExam.getMedicalExamType().equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)") && (medExam.getPaAFROFinalObservation()!=null))
{%>
data_arr[<%= i%>][8] = "<%=medExam.getPaAFROFinalObservation()%>"
<%}else{%>
data_arr[<%= i%>][8] = ""   
<%}%>
<%
if(medExam.getPresentMedicalCategory()!= null ){
%>
data_arr[<%= i%>][9] = "<%=medExam.getPresentMedicalCategory().getCategories() %>";
<%}else{%>
data_arr[<%= i%>][9] = "";
<%
}%>
<%
if(medExam.getMedicalExamType()!= null){
%>
data_arr[<%= i%>][10] = "<%=medExam.getMedicalExamType()%>";


<%}else{%>
data_arr[<%= i%>][10] = "";
<%
}%>
<%
if(medExam.getId()!= null){
%>
data_arr[<%= i%>][11] = "<%=medExam.getId()%>";
<%}else{%>
data_arr[<%= i%>][11] = "";
<%
}%>
<%i++;
   }
 }
  
}catch(Exception e){
e.printStackTrace();	

}
%>
 
//formName = "opd_previousVisitForMedicalExamp"
formName="opd_previousVisitForMedicalExampVal"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<div class="Clear"></div>
<div class="floatRight">
<label class="auto"><span>Total Patient Visit </span></label>
<label class="valueAuto"><%= i%></label>
<input type="hidden"	name="counter" id="counter" value="<%=i %>" />
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="medExamId" id="medExamId" value="" />
<%if(backFlag.equals("OPD")){ %>
<input name="Back" type="hidden" alt="Back" value="Back" class="button"	onclick="submitForm('opd_previousVisitForMedicalExampVal','opd?method=showOPDMainJsp&visitId=<%=visitIdForOpd%>&token=<%=token%>');"/>
<%} %>
<input name="Close" type="button" value="Close" class="button"	onclick="window.close();"/>
<%-- <input name="Back" type="button" value="Back" class="button"	onclick="history.go(-1);return false;"/>--%>
<input type="button" name="printReport" id="print"	onclick="submitFormForMedicalExamReport();" value="print Report"	class="buttonBig" accesskey="a" />

<div class="clear"></div>
<div class="division"></div>
</form>
<% }else{ %>

<form name="opd_previousVisitForMedicalExampVal" method="post" action="">

<h4>Records not available!</h4>
<div class="Clear"></div>
<%if(backFlag.equals("OPD")){ %>
<input name="Back" type="hidden" alt="Back" value="Back" class="button"	onclick="submitForm('opd_previousVisitForMedicalExampVal','opd?method=showOPDMainJsp&visitId=<%=visitIdForOpd%>&token=<%=token%>');"/>

<% }%>
<input name="Close" type="button" value="Close" class="button"	onclick="window.close();"/>
<%} %>

<script type="text/javascript">	
function submitFormForMedicalExamReport()
{
	var flag = validateRadioForVisitNo();
	if(flag == false){
		return false;
	}else{
		submitForm('opd_previousVisitForMedicalExampVal','medicalExam?method=printAnnualMedicalExamReport');
	}
}
function fillMedExamId(printValueObj){
	var allValues = printValueObj.value;
	document.getElementById('medExamId').value = allValues;
}
function fillVisitNo(printValueObj){
	var allValues = printValueObj.value;
	
	var allValuesArray = allValues.split("@");
		
		document.getElementById('serviceNoForReport').value = allValuesArray[0];
		document.getElementById('visitNumberForReport').value = allValuesArray[1]; 
		document.getElementById('hinNoForReport').value = allValuesArray[2];  
	}
	
	function validateRadioForVisitNo(){
		for(var i = 0; i < document.getElementsByName('parent').length; i++){
			if(document.getElementsByName('parent')[i].checked == true){
				return true;
			}		
  		}
  		alert("Please select one row");
		return false;
	}
	function showPreviousVisit(hinId,deptId,visitNo){
		if(visitNo >1){
       document.opd_previousVisitForMedicalExamp.action="/hms/hms/opd?method=getPatientOpdDetails&flag=current&hinId="+hinId+"&deptId="+deptId+"&visitNumber="+visitNo;
       document.opd_previousVisitForMedicalExamp.submit();
        }else{
         alert("This Is Patient's first Visit.")
       }
    }
</script>
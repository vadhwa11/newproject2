<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showPatientList.jsp  
 * Purpose of the JSP -  This is Show Patient List.
 * @author  Ritu
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
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
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
        //String medExamType= "";
        //String jspheading = "";
        int visitId=0;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		Map<String, Object> mapSmc = new HashMap<String, Object>();
		if(map.get("mapSmc") != null){
			mapSmc = (Map<String, Object>)map.get("mapSmc");
		 }
		if(map.get("visitId") != null){
			visitId = (Integer)map.get("visitId");
		}
		/*
		String FlagFOrMedExamMa = "";
		if(map.get("FlagFOrMedExamMa")!= null)
		{
			FlagFOrMedExamMa = (String)map.get("FlagFOrMedExamMa");
		}
		String medExamType="";
		if(map.get("medExamType")!= null)
        {
      	medExamType = (String)map.get("medExamType");
        }*/
		if(map.get("url") != null)
		  {
			url = ""+map.get("url");
		  }
		//url=url+"&visitId="+visitId+"&medExamType="+medExamType;
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
		if(medExamList!=null && medExamList.size()>0){	
%>
<div class="titleBg"><h2>Details Of Annual Medical Examination</h2></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock1.jsp" />
<form name="opd_previousVisitForMedicalExampVal" method="post" action="">
<!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->
<div id="searchresults" tabindex=2>
<div id="searchtable1" tabindex=2></div>
<script type="text/javascript" language="javascript">
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"], [1,"<%= RequestConstants.DATE %>"],[2,"<%=RequestConstants.UNIT%>"],[3,"<%= RequestConstants.WEIGHT %>"],[4,"<%=RequestConstants.BP%>"],[5,"ecg"],[6,"xray"],[7,"abnormality"],[8,"medCat"],[9,"datasource"] ];
	 statusTd =13;
</script></div>
<div id="edited"></div>
<div id="statusMessage" ></div>
<input type="hidden" name="medExamId" id="medExamId"	value="" />

<script	type="text/javascript" language="javascript">
		
		data_header1 = new Array();
		
		data_header1[0] = new Array;
		data_header1[0][0] = ""
		data_header1[0][1] = "radio";
		data_header1[0][2] = "10%";
		data_header1[0][3] = "<%=RequestConstants.RADIO_FOR_TABLE %>"
		
		data_header1[1] = new Array;
		data_header1[1][0] = "Date"
		data_header1[1][1] = "data";
		data_header1[1][2] = "10%";
		data_header1[1][3] = "<%= RequestConstants.DATE%>"
		
		data_header1[2] = new Array;
		data_header1[2][0] = "Unit"
		data_header1[2][1] = "data";
		data_header1[2][2] = "10%";
		data_header1[2][3] = "<%=RequestConstants.UNIT %>";
		
		data_header1[3] = new Array;
		data_header1[3][0] = "Wt"
		data_header1[3][1] = "data";
		data_header1[3][2] = "10%";
		data_header1[3][3] = "<%= RequestConstants.WEIGHT %>";
		
		data_header1[4] = new Array;
		data_header1[4][0] = "BP"
		data_header1[4][1] = "data";
		data_header1[4][2] = "10%";
		data_header1[4][3] = "<%=RequestConstants.BP%>";
		
		data_header1[5] = new Array;
		data_header1[5][0] = "ECG"
		data_header1[5][1] = "data";
		data_header1[5][2] = "10%";
		data_header1[5][3] = "ecg";
		
		data_header1[6] = new Array;
		data_header1[6][0] = "X Ray"
		data_header1[6][1] = "data";
		data_header1[6][2] = "10%";
		data_header1[6][3] = "xray";
		
		data_header1[7] = new Array;
		data_header1[7][0] = "Final Observation"
		data_header1[7][1] = "data";
		data_header1[7][2] = "20%";
		data_header1[7][3] = "finalObservation";
		
		data_header1[8] = new Array;
		data_header1[8][0] = "Med Cat"
		data_header1[8][1] = "data";
		data_header1[8][2] = "10%";
		data_header1[8][3] = "medCat";
				
		data_arr1 = new Array();
<%
int  i=0;
try{
String st="";
 for(MasMedicalExaminationReportOnEntry medExam : medExamList)
  {   
      if(medExam.getDateOfReporting()!= null && medExam.getMedicalExamType() !=null){
%>
data_arr1[<%= i%>] = new Array();
data_arr1[<%= i%>][0] ="<%=medExam.getId()%>"
data_arr1[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=medExam.getId()%>" id="parent" onclick="fillMedExamId(this)"/>'
					
<%
if(medExam.getMedicalExamType().equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)")&&(medExam.getDateOfReporting()!=null))
   {%>
data_arr1[<%=i%>][2] = "<%=HMSUtil.changeDateToddMMyyyy(medExam.getDateOfReporting())%>"
<%}else if(medExam.getMedicalExamType().equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)")&&(medExam.getDateDischarge()!=null))
{%>
data_arr1[<%= i%>][2] = "<%=HMSUtil.changeDateToddMMyyyy(medExam.getDateDischarge())%>"
<%}else{%>
data_arr1[<%= i%>][2] = ""   
<%}%>
			
<%
if(medExam.getUnit()!=null){
%>
data_arr1[<%= i%>][3] = "<%=medExam.getUnit().getUnitName()%>"

<%}else{
%>
data_arr1[<%= i%>][3] = "";
<%}%>
<%
if(medExam.getWeight()!=null){
%>
data_arr1[<%= i%>][4]="<%=medExam.getWeight()%>"
<%}else{
%>
data_arr1[<%= i%>][4] = "";
<%}%>
<%
if(medExam.getBp()!=null){
%>
data_arr1[<%= i%>][5] = "<%=medExam.getBp()%>"
<%}else{
%>
data_arr1[<%= i%>][5] = "";
<%}%>
<%
if(medExam.getEcg()!=null){
%>
data_arr1[<%= i%>][6] = "<%=medExam.getEcg()%>"
<%}else{
%>
data_arr1[<%= i%>][6] = "";
<%}%>
<%
if(medExam.getXray()!=null){
%>
data_arr1[<%= i%>][7] = "<%=medExam.getXray()%>"
<%}else{
%>
data_arr1[<%= i%>][7] = "";
<%}%>
<%if(medExam.getMedicalExamType().equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)") && (medExam.getPerFinalObservation()!=null))
{%>
data_arr1[<%=i%>][8] = "<%=medExam.getPerFinalObservation()%>"
<%}else if(medExam.getMedicalExamType().equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)") && (medExam.getPaAFROFinalObservation()!=null))
{%>
data_arr1[<%= i%>][8] = "<%=medExam.getPaAFROFinalObservation()%>"
<%}else{%>
data_arr1[<%= i%>][8] = ""   
<%}%>
<%
if(medExam.getPresentMedicalCategory()!= null ){
%>
data_arr1[<%= i%>][9] = "<%=medExam.getPresentMedicalCategory().getCategories() %>";
<%}else{%>
data_arr1[<%= i%>][9] = "";
<%
}%>
<%
if(medExam.getMedicalExamType()!= null){
%>
data_arr1[<%= i%>][10] = "<%=medExam.getMedicalExamType()%>";


<%}else{%>
data_arr1[<%= i%>][10] = "";
<%
}%>
<%
if(medExam.getId()!= null){
%>
data_arr1[<%= i%>][11] = "<%=medExam.getId()%>";
<%}else{%>
data_arr1[<%= i%>][11] = "";
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
formName="opd_previousVisitForMedicalExampVal1"

	start1 = 0
	if(data_arr1.length < rowsPerPage)
		end1 = data_arr1.length;
	else
		end1 = rowsPerPage;
	makeTable1(start1,end1);

intializeHover('searchresulttable1', 'TR', ' tableover');	

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
<%if(backFlag.equals("OPD") || backFlag.equals("dental")){ %>
<!--<input name="Back" type="button" value="Back" class="button"	onclick="submitForm('opd_previousVisitForMedicalExampVal','opd?method=showOPDMainJsp&visitId=<%=visitIdForOpd%>&token=<%=token%>');"/>-->
<input name="close" type="button" value="close" class="button" onclick="window.close();"/>
<%} %>


<input type="button" name="printReport" id="print"	onclick="submitFormForMedicalExamReport();" value="print Report"	class="buttonBig" accesskey="a" />

<div class="clear"></div>
<div class="division"></div>
</form>
<% }else{ %>

<form name="opd_previousVisitForMedicalExampVal1" method="post" action="">
<h4>No Previous Medical Exams Found </h4>
<div class="Clear"></div>
<%if(backFlag.equals("OPD") || backFlag.equals("dental")){ %>
<!--<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opd_previousVisitForMedicalExampVal','opd?method=showOPDMainJsp&visitId=<%=visitIdForOpd%>&token=<%=token%>');"/>-->
<input name="close" type="button" value="close" class="button" onclick="window.close();"/>
<% } %>

</form>

<% } %>

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


 <%@ include file="opd_previousVisitForMedicalExamHIS.jsp" %> 
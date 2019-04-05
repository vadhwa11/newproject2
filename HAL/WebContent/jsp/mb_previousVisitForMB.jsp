<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showPatientList.jsp  
 * Purpose of the JSP -  This is Show Patient List.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 21st Feb,2008 
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
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

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

<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> -->
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<%
		Map map = new HashMap();
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		int visitNoForJsp=0;
		int visitIdForOpd=0;
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
		 List<MasMedicalExaminationReportOnEntry> medExamList = null;
		 if(map.get("medExamList") != null){
			 medExamList = (List)map.get("medExamList");
		 }
/*	List patientPreviousVisitList = new ArrayList();
	List<Integer> maxVisitIdList = new ArrayList<Integer>();
	List<Integer> minVisitIdList = new ArrayList<Integer>();
	
	if(map.get("patientPreviousVisitList") != null){
		patientPreviousVisitList=(List)map.get("patientPreviousVisitList");
	}	
	if(map.get("maxVisitIdList") != null){
		maxVisitIdList=(List)map.get("maxVisitIdList");
	}	
	if(map.get("minVisitIdList") != null){
		minVisitIdList=(List)map.get("minVisitIdList");
	}	*/

//	if(patientPreviousVisitList.size() > 0){
	if(medExamList!=null && medExamList.size()>0){
		System.out.println("in if condition previousVisitForMedicalBoardJsp");	
	
%>

<div class="titleBg"><h2>Details Of Medical Board</h2></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />

<form name="opd_previousVisitForMedicalBoard" method="post" action="">
<!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script type="text/javascript" language="javascript">

formFields = [
		[0, "<%= RequestConstants.HIN_ID%>", "id"], [1,"<%= RequestConstants.DATE %>"],[2,"<%=RequestConstants.UNIT%>"],[3,"<%= RequestConstants.WEIGHT %>"],[4,"<%=RequestConstants.BP%>"],[5,"medCat"],[6,"Disability"],[7,"Disability"],[8,"Attributability/Aggravation"],[9,"Injury Report/Charter Of Duties"],[10,"charterDuties"],[11,"Empl Restrictions"],[12,"Medication"] ];
 statusTd =14;
</script></div>
<div id="edited"></div>
<div id="statusMessage" ></div>
<input type="hidden" name="serviceNoForReport" id="serviceNoForReport"	value="" />
<input type="hidden" name="visitNumberForReport"	id="visitNumberForReport" value="" />
<input type="hidden"	name="hinNoForReport" id="hinNoForReport" value="" />
<script	type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Date"
		data_header[0][1] = "data";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.DATE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Unit"
		data_header[1][1] = "data";
		data_header[1][2] = "8%";
		data_header[1][3] = "<%= RequestConstants.UNIT%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Wt"
		data_header[2][1] = "data";
		data_header[2][2] = "10%";
		data_header[2][3] = "<%= RequestConstants.WEIGHT %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "BP"
		data_header[3][1] = "data";
		data_header[3][2] = "5%";
		data_header[3][3] = "<%=RequestConstants.BP %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Med Cat"
		data_header[4][1] = "data";
		data_header[4][2] = "6%";
		data_header[4][3] = "medCat";
		
		data_header[5] = new Array;
		data_header[5][0] = "Disability"
		data_header[5][1] = "data";
		data_header[5][2] = "5%";
		data_header[5][3] = "Disability";		
		
		data_header[6] = new Array;
		data_header[6][0] = "Disability"
		data_header[6][1] = "data";
		data_header[6][2] = "5%";
		data_header[6][3] = "Disability";
		
		data_header[7] = new Array;
		data_header[7][0] = "Attributability"
		data_header[7][1] = "data";
		data_header[7][2] = "10%";
		data_header[7][3] = "Attributability/Aggravation";		
		
		data_header[8] = new Array;
		data_header[8][0] = "Injury Report"
		data_header[8][1] = "data";
		data_header[8][2] = "5%";
		data_header[8][3] = "Injury Report/Charter Of Duties";

		data_header[9] = new Array;
		data_header[9][0] = "Charter of Duties"
		data_header[9][1] = "data";
		data_header[9][2] = "10%";
		data_header[9][3] = "charterDuties";
		
		data_header[10] = new Array;
		data_header[10][0] = "Empl Restrictions"
		data_header[10][1] = "data";
		data_header[10][2] = "10%";
		data_header[10][3] = "Empl Restrictions";

		data_header[11] = new Array;
		data_header[11][0] = "Medication"
		data_header[11][1] = "data";
		data_header[11][2] = "10%";
		data_header[11][3] = "Medication";

		data_header[12] = new Array;
		data_header[12][0] = "Data Source"
		data_header[12][1] = "hide";
		data_header[12][2] = "10%";
		data_header[12][3] = "datasource";

		data_header[13] = new Array;
		data_header[13][0] = "VisitId"
		data_header[13][1] = "hide";
		data_header[13][2] = "10%";
		data_header[13][3] = "datasource";

		data_header[14] = new Array;
		data_header[14][0] = "Med Type"
		data_header[14][1] = "hide";
		data_header[14][2] = "10%";
		data_header[14][3] = "datasource";

		data_header[15] = new Array;
		data_header[15][0] = "MedId"
		data_header[15][1] = "hide";
		data_header[15][2] = "10%";
		data_header[15][3] = "datasource";
		
		data_arr = new Array();
		
		<%
		int  i=0;
		try{
			String st="";
			  for(MasMedicalExaminationReportOnEntry medExam : medExamList)
			   {         	
		%>
					data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] =""
			<%
			if(medExam.getDateValidated()!=null){
			%>
			data_arr[<%= i%>][1] = '<%=HMSUtil.convertDateToStringWithoutTime(medExam.getDateValidated())%>'
		<%}else{
			%>
			data_arr[<%= i%>][1] = "";
		<%}%>
		<%
		if(medExam.getVisit()!=null){
		%>
			data_arr[<%= i%>][2] = "<%=medExam.getVisit().getHin().getUnit().getUnitName()%>"
		
			<%}else{
				%>
				data_arr[<%= i%>][2] = "";
			<%}%>
		<%
		if(medExam.getWeight()!=null){
		%>
			data_arr[<%= i%>][3]="<%=medExam.getWeight()%>"
				<%}else{
					%>
					data_arr[<%= i%>][3] = "";
				<%}%>
				
					
				
				<%
				if(medExam.getBp()!=null){
				%>
			data_arr[<%= i%>][4] = "<%=medExam.getBp()%>"
				<%}else{
					%>
					data_arr[<%= i%>][4] = "";
				<%}%>
				<%
				if(medExam.getPresentMedicalCategory()!=null){
				%>
			data_arr[<%= i%>][5] = "<%=medExam.getPresentMedicalCategory().getCategories()%>"
				<%}else{
					%>
					data_arr[<%= i%>][5] = "";
				<%}%>
				<%
				if(medExam.getMasmedicaldetail()!=null){
			String disability="";
					for(MasMedicalExaminationDetail setMedicalExam:medExam.getMasmedicaldetail()){
						if(setMedicalExam.getPrincipal()!=null)
						disability=disability+","+setMedicalExam.getPrincipal();
						
					}
					if(disability!="")
					disability=disability.substring(1);
				%>
			data_arr[<%= i%>][6] = "<%=disability%>"
				<%}else{
					%>
					data_arr[<%= i%>][6] = "";
				<%}%>
				<%
				if(medExam.getPastDisability()!=null){
				%>
			data_arr[<%= i%>][7] = "<%=medExam.getPastDisability().getDisability()%>"
				<%}else{
					%>
					data_arr[<%= i%>][7] = "";
				<%}%>
				<%String value="";
				if(medExam.getDisabilityAttribute()!=null ){
					
					
						value=medExam.getDisabilityAttribute();
					
				
				%>
			data_arr[<%= i%>][8] = "<%=value%>"
				<%}else{%>
				data_arr[<%= i%>][8] = "";
				<%}%>
				data_arr[<%= i%>][9] = ""
				<%String value1="";
				if(medExam.getAggravatedServiceDesc()!=null){
					
					
						value1=medExam.getAggravatedServiceDesc();
					
				
				%>
				
			data_arr[<%= i%>][10] = "<%=value1%>"
				<%}else{%>
				data_arr[<%= i%>][10] = "";
				<%}%>
				<%
				if(medExam.getRestrictionemployment()!=null ){
				%>
			data_arr[<%= i%>][11] = "<%=medExam.getRestrictionemployment()%>"
				<%}else{
					%>
					data_arr[<%= i%>][11] = "";
				<%}%>
				<%
				if(medExam.getInstructionByPresident()!=null){
				%>
			data_arr[<%= i%>][12] = "<%=medExam.getInstructionByPresident()%>"
				<%}else{
					%>
					data_arr[<%= i%>][12] = "";
				<%}%>
                 <%if(medExam.getSourceOfData()!= null){
				%>
					data_arr[<%= i%>][13] = "<%=medExam.getSourceOfData()%>";

					
				<%}else{%>
				data_arr[<%= i%>][13] = "";
                 <%}%>
                 <%
 				
 				if(medExam.getVisit()!= null){
 				%>
 					data_arr[<%= i%>][14] = "<%=medExam.getVisit().getId()%>";

 					
 				<%}else{%>
 				data_arr[<%= i%>][14] = "";
 			<%
 				}%>
 <%
 				
 				if(medExam.getMedicalExamType()!= null){
 				%>
 					data_arr[<%= i%>][15] = "<%=medExam.getMedicalExamType()%>";

 					
 				<%}else{%>
 				data_arr[<%= i%>][15] = "";
 			<%
 				}%>
 <%
 				if(medExam.getId()!= null){
 				%>
 					data_arr[<%= i%>][16] = "<%=medExam.getId()%>";
 				<%}else{%>
 				data_arr[<%= i%>][16] = "";
 			<%
 				}%>
			<%
			i++;
		           }
		  
		          
		}catch(Exception e){
		e.printStackTrace();	
	
		}
		%>
		 
		formName = "opd_previousVisitForMedicalBoard"
		
		
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
<%//if(backFlag.equals("OPD")){ %>
<%--
<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opd_previousVisitForMedicalBoard','opd?method=showOPDMainJsp&visitId=<%=visitIdForOpd%>&token=<%=token%>');"/>
 --%>
 <input name="Close" type="button" value="Close" class="button"	onclick="window.close();"/>
<%//} %>
<div class="clear"></div>
<div class="division"></div>
</form>
<% }else{ %>

<form name="opd_previousVisitForMedicalBoard" method="post" action="">
<h4>Records not available!</h4>
<div class="Clear"></div>
<%//if(backFlag.equals("OPD")){ %><%--
<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opd_previousVisitForMedicalBoard','opd?method=showOPDMainJsp&visitId=<%=visitIdForOpd%>&token=<%=token%>');"/></form>
 --%>
  <input name="Close" type="button" value="Close" class="button"	onclick="window.close();"/>
<%} %>

<%// } %>

<script type="text/javascript">	
	function submitFormForPrescriptionReport(){
		var flag = validateRadioForVisitNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
			var printId = document.getElementById('print');
			checkTargetForYes();
			//printId.setAttribute("type","submit");
			submitForm('opdPatientPrevVisitForReport','/hms/hms/opd?method=showPatientPrescriptionReport');
			checkTargetForNo();
		}
		
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

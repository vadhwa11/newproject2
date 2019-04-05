
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


<%@page import="oracle.jdbc.OracleResultSet"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
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
		String url = "";
		if(map.get("url") != null)
		  {
			url = ""+map.get("url");
		  }
		 
		int visitNoForJsp=0;
		int visitId=0;
        //String url = "";
		int visitIdForOpd=0;
		int token = 0;
		String backFlag = "";
		if(map.get("token") != null){
			token = (Integer)map.get("token");
		}
		if(map.get("backFlag") != null){
			backFlag = (String)map.get("backFlag");
		}
		Map<String, Object> mapSmc = new HashMap<String, Object>();
		if(map.get("mapSmc") != null){
			mapSmc = (Map<String, Object>)map.get("mapSmc");
		 }
		
		if(map.get("visitId") != null){
			visitIdForOpd = (Integer)map.get("visitId");
		}
		if(map.get("visitId") != null){
			visitId = (Integer)map.get("visitId");
		}

		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		if(mapSmc.get("medExamList") != null){
			medExamList = (List<MasMedicalExaminationReportOnEntry>)mapSmc.get("medExamList");
		 }
		 String FlagFOrMedExamMa = "";
			System.out.println("FlagFOrMedExamMaPrevious Visit For MedicalBoard---->>>************ "+map.get("FlagFOrMedExamMa"));
			if(map.get("FlagFOrMedExamMa")!= null)
			{
				FlagFOrMedExamMa = (String)map.get("FlagFOrMedExamMa");
				
			}
			String medExamType="";
			System.out.println("medExamType Previous Visit For MedicalBoard==>>>***********"+map.get("medExamType"));
			if(map.get("medExamType")!= null)
	        {
	      	medExamType = (String)map.get("medExamType");
	        }
			if(map.get("url") != null)
			  {
				url = ""+map.get("url");
			  }
			url=url+"&visitId="+visitId+"&medExamType="+medExamType;
		 
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
	if(medExamList!=null && medExamList.size()>0){System.out.println("in if condition previousVisitForMedicalBoardJsp");	
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
		[0, "<%= RequestConstants.HIN_ID%>", "id"], [1,"<%= RequestConstants.DATE %>"],[2,"<%=RequestConstants.UNIT%>"],[3,"<%= RequestConstants.WEIGHT %>"],[4,"<%=RequestConstants.BP%>"],[5,"medCat"],[6,"Disability"],[7,"Disability"],[8,"Attributability/Aggravation"],[9,"Injury Report/Charter Of Duties"],[10,"charterDuties"],[11,"Empl Restrictions"],[12,"Medication"],[13,"Medication1"] ];
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
		data_header[5][0] = "Med Cat"
		data_header[5][1] = "data";
		data_header[5][2] = "6%";
		data_header[5][3] = "medCat";
		
		data_header[6] = new Array;
		data_header[6][0] = "Disability"
		data_header[6][1] = "data";
		data_header[6][2] = "5%";
		data_header[6][3] = "Disability";		
		
		data_header[7] = new Array;
		data_header[7][0] = "Disability"
		data_header[7][1] = "data";
		data_header[7][2] = "5%";
		data_header[7][3] = "Disability";
		
		data_header[8] = new Array;
		data_header[8][0] = "Attributability"
		data_header[8][1] = "data";
		data_header[8][2] = "10%";
		data_header[8][3] = "Attributability/Aggravation";		
		
		data_header[9] = new Array;
		data_header[9][0] = "Injury Report"
		data_header[9][1] = "data";
		data_header[9][2] = "5%";
		data_header[8][3] = "Injury Report/Charter Of Duties";

		data_header[10] = new Array;
		data_header[10][0] = "Charter of Duties"
		data_header[10][1] = "data";
		data_header[10][2] = "10%";
		data_header[10][3] = "charterDuties";
		
		data_header[11] = new Array;
		data_header[11][0] = "Empl Restrictions"
		data_header[11][1] = "data";
		data_header[11][2] = "10%";
		data_header[11][3] = "Empl Restrictions";

		data_header[12] = new Array;
		data_header[12][0] = "Medication"
		data_header[12][1] = "data";
		data_header[12][2] = "10%";
		data_header[12][3] = "Medication";

		data_header[13] = new Array;
		data_header[13][0] = "Data Source"
		data_header[13][1] = "hide";
		data_header[13][2] = "10%";
		data_header[13][3] = "datasource";

		data_header[14] = new Array;
		data_header[14][0] = "VisitId"
		data_header[14][1] = "hide";
		data_header[14][2] = "10%";
		data_header[14][3] = "datasource";

		data_header[15] = new Array;
		data_header[15][0] = "Med Type"
		data_header[15][1] = "hide";
		data_header[15][2] = "10%";
		data_header[15][3] = "datasource";

		data_header[16] = new Array;
		data_header[16][0] = "MedId"
		data_header[16][1] = "hide";
		data_header[16][2] = "10%";
		data_header[16][3] = "datasource";
	
		data_arr = new Array();
		
		<%
		int  i=0;
		try{
			String st="";
			  for(MasMedicalExaminationReportOnEntry medExam : medExamList)
			   {         	
		%>
					data_arr[<%= i%>] = new Array();
			
					data_arr[<%= i%>][0] ="<%=medExam.getId()%>"
						data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=medExam.getId()%>" id="parent" onclick="fillMedBoardId(this)"/>'
			<%
			if(medExam.getDateValidated()!=null){
			%>
			data_arr[<%= i%>][2] = '<%=HMSUtil.convertDateToStringWithoutTime(medExam.getDateValidated())%>'
		<%}else{
			%>
			data_arr[<%= i%>][2] = "";
		<%}%>
		<%
		if(medExam.getVisit()!=null){
		%>
			data_arr[<%= i%>][3] = "<%=medExam.getVisit().getHin().getUnit().getUnitName()%>"
		
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
				if(medExam.getPresentMedicalCategory()!=null){
				%>
			data_arr[<%= i%>][6] = "<%=medExam.getPresentMedicalCategory().getCategories()%>"
				<%}else{
					%>
					data_arr[<%= i%>][6] = "";
				<%}%>
				<%
				if(medExam.getMasmedicaldetail()!=null){
			String disability="";
			System.out.println("medExam.getMasmedicaldetail()-- "+medExam.getMasmedicaldetail());
					for(MasMedicalExaminationDetail setMedicalExam:medExam.getMasmedicaldetail()){
						if(setMedicalExam.getPrincipal()!=null)
						disability=disability+","+setMedicalExam.getPrincipal();
						
					}
					if(disability!="")
					disability=disability.substring(1);
				%>
			data_arr[<%= i%>][7] = "<%=disability%>"
				<%}else{
					%>
					data_arr[<%= i%>][7] = "";
				<%}%>
				<%
				if(medExam.getPastDisability()!=null){
				%>
			data_arr[<%= i%>][8] = "<%=medExam.getPastDisability().getDisability()%>"
				<%}else{
					%>
					data_arr[<%= i%>][8] = "";
				<%}%>
				<%String value="";
				if(medExam.getDisabilityAttribute()!=null ){
					
					
						value=medExam.getDisabilityAttribute();
					
				
				%>
			data_arr[<%= i%>][9] = "<%=value%>"
				<%}else{%>
				data_arr[<%= i%>][9] = "";
				<%}%>
				data_arr[<%= i%>][10] = ""
				<%String value1="";
				if(medExam.getAggravatedServiceDesc()!=null){
					
					
						value1=medExam.getAggravatedServiceDesc();
					
				
				%>
				
			data_arr[<%= i%>][11] = "<%=value1%>"
				<%}else{%>
				data_arr[<%= i%>][11] = "";
				<%}%>
				<%
				if(medExam.getRestrictionemployment()!=null ){
				%>
			data_arr[<%= i%>][12] = "<%=medExam.getRestrictionemployment()%>"
				<%}else{
					%>
					data_arr[<%= i%>][12] = "";
				<%}%>
				<%
				if(medExam.getInstructionByPresident()!=null){
				%>
			data_arr[<%= i%>][13] = "<%=medExam.getInstructionByPresident()%>"
				<%}else{
					%>
					data_arr[<%= i%>][13] = "";
				<%}%>
                 <%if(medExam.getSourceOfData()!= null){
				%>
					data_arr[<%= i%>][14] = "<%=medExam.getSourceOfData()%>";

					
				<%}else{%>
				data_arr[<%= i%>][14] = "";
                 <%}%>
                 <%
 				
 				if(medExam.getVisit()!= null){
 				%>
 					data_arr[<%= i%>][15] = "<%=medExam.getVisit().getId()%>";

 					
 				<%}else{%>
 				data_arr[<%= i%>][15] = "";
 			<%
 				}%>
 <%
 				
 				if(medExam.getMedicalExamType()!= null){
 				%>
 					data_arr[<%= i%>][16] = "<%=medExam.getMedicalExamType()%>";

 					
 				<%}else{%>
 				data_arr[<%= i%>][16] = "";
 			<%
 				}%>
 <%
 				if(medExam.getId()!= null){
 				%>
 					data_arr[<%= i%>][17] = "<%=medExam.getId()%>";
 				<%}else{%>
 				data_arr[<%= i%>][17] = "";
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

<%-- <%if(backFlag.equals("OPD") || backFlag.equals("dental")){ %>
<!--<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opd_previousVisitForMedicalBoard','opd?method=showOPDMainJsp&visitId=<%=visitIdForOpd%>&token=<%=token%>');"/>-->
<input name="close" type="button" value="close" class="button" onclick="window.close();"/>
<%} %>
<%if(FlagFOrMedExamMa.equals("medExamMA")){  System.out.println("FlagFOrMedExamMa in jsp check"); %>
<input name="Back" type="button" alt="Back" value="Back" class="button"	onClick="submitForm('opd_previousVisitForMedicalBoard','<%=url%>');"/>
<%}%>
<div class="clear"></div>
<div class="division"></div>
</form>
<% }else{ %>

<form name="opd_previousVisitForMedicalBoard" method="post" action="">
<h4>No Medical Board Records Found </h4>
<div class="Clear"></div>
</form>
<%if(backFlag.equals("OPD") || backFlag.equals("dental")){ %>
<!--<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opd_previousVisitForMedicalBoard','opd?method=showOPDMainJsp&visitId=<%=visitIdForOpd%>&token=<%=token%>');"/>--></form>
<input name="close" type="button" value="close" class="button" onclick="window.close();"/>
<%} %>
<%if(FlagFOrMedExamMa.equals("medExamMA")){ %>
<input name="Back" type="button" alt="Back" value="Back" class="button"	onClick="submitForm('opd_previousVisitForMedicalBoard','<%=url%>');"/>
<%}%>

<% } %> --%>
<input type="hidden" name="medExamId" id="medExamId" value="" />

<%if(backFlag.equals("OPD") || backFlag.equals("dental")){ %>
<!--<input name="Back" type="button" value="Back" class="button"	onclick="submitForm('opd_previousVisitForMedicalExampVal','opd?method=showOPDMainJsp&visitId=<%=visitIdForOpd%>&token=<%=token%>');"/>-->
<input name="close" type="button" value="close" class="button" onclick="window.close();"/>
<%} %>


<input type="button" name="printReport" id="print"	onclick="submitFormForMedicalBoardReport();" value="print Report"	class="buttonBig" accesskey="a" />

<div class="clear"></div>
<div class="division"></div>
</form>
<% }else{ %>

<form name="opd_previousVisitForMedicalExampVal" method="post" action="">
<h4>No Previous Medical Exams Found </h4>
<div class="Clear"></div>
<%if(backFlag.equals("OPD") || backFlag.equals("dental")){ %>
<!--<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opd_previousVisitForMedicalExampVal','opd?method=showOPDMainJsp&visitId=<%=visitIdForOpd%>&token=<%=token%>');"/>-->
<input name="close" type="button" value="close" class="button" onclick="window.close();"/>
<% } %>

</form>

<% } %>

<script type="text/javascript">	
function submitFormForMedicalBoardReport()
{
	var flag = validateRadioForVisitNo();
	if(flag == false){
		return false;
	}else{
		submitForm('opd_previousVisitForMedicalBoard','medicalExam?method=printAnnualMedicalExamReport');
	}
}
function fillMedBoardId(printValueObj){
	var allValues = printValueObj.value;
	document.getElementById('medExamId').value = allValues;
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
	
</script>

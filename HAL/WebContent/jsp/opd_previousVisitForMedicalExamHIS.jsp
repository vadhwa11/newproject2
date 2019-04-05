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
		
		

		Date toDate  = null;
		Date fromDate=null;
		
		List<Object[]> mdExamAssistantList = new ArrayList<Object[]>();

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
		if(mapSmc.get("medExamListHIS") != null){
			mdExamAssistantList= (List<Object[]>)mapSmc.get("medExamListHIS");
		}
		//out.print("ss="+mdExamAssistantList.size());
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		
		int hinId=0;
		if(request.getParameter("hinId") != null)
		{
			hinId = Integer.parseInt(request.getParameter("hinId"));
		}
	%>
<div id="contentHolder">
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <label class="noWidth"><span><%=message %></span></label>
	   <div class="Clear"></div>
	   <% 
	  }

%>
<h6>Detail Of Annual Medical Examination (HIS)</h6>

	<jsp:include page="searchResultBlock.jsp" />
	<div class="Clear"></div>
	<form name="mdExamPreviousPatientMedicalAssistant" method="post" action="">
	<input type="hidden" name="ctoken" value="<%=session.getAttribute("csrfToken")%>">
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	
	<script type="text/javascript">
	formFields = [
			[0, "<%= hinId%>", "id"], [1,"servNo"], [2,"hin"], [3,"serviceType"], [4,"sPersonName"], [5,"rank"], [6,"unit"], [7,"medTypeId"]];
	 statusTd = 7;
</script>
		
		<div class="Clear"></div>
		</div>
		<div class="Clear"></div>
		
	<!-- <input type="button" name="yes" value="Print"
	class="button" id="dsPrint" 
	onclick="if(validateRadioMdExam()){showAddInfoPopUp();}" /> -->
	
	
	<!-- <input type="button" name="close" value="Close"
	class="button" 
	onclick="window.close()" /> -->
		<div class="Height10"></div>
		</form>
	</div>

	<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "data";
	data_header[0][2] = "5%";
	data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Md_Exam_Date"
	data_header[1][1] = "data";
	data_header[1][2] = "7%";
	data_header[1][3] = "md_exam_date"

	data_header[2] = new Array;
	data_header[2][0] = "Unit"
	data_header[2][1] = "data";
	data_header[2][2] = "7%";
	data_header[2][3] = "unit";

	data_header[3] = new Array;
	data_header[3][0] = "Wt"
	data_header[3][1] = "data";
	data_header[3][2] = "7%";
	data_header[3][3] = "wt";

	data_header[4] = new Array;
	data_header[4][0] = "BP"
	data_header[4][1] = "data";
	data_header[4][2] = "7%";
	data_header[4][3] = "bp";

	data_header[5] = new Array;
	data_header[5][0] = "ECG"
	data_header[5][1] = "hide";
	data_header[5][2] = "7%";
	data_header[5][3] = "ecg"

	data_header[6] = new Array;
	data_header[6][0] = "X-ray"
	data_header[6][1] = "hide";
	data_header[6][2] = "7%";
	data_header[6][3] = "xRay";

	data_header[7] = new Array;
	data_header[7][0] = "Final Observation"
	data_header[7][1] = "hide";
	data_header[7][2] = "7%";
	data_header[7][3] = "finalObservation";

	data_header[8] = new Array;
	data_header[8][0] = "Med. Cat"
	data_header[8][1] = "data";
	data_header[8][2] = "7%";
	data_header[8][3] = "medCat";
	
	data_header[9] = new Array;
	data_header[9][0] = "Rank"
	data_header[9][1] = "data";
	data_header[9][2] = "7%";
	data_header[9][3] = "rank";



	data_header[10] = new Array;
	data_header[10][0] = "Medical Type"
	data_header[10][1] = "data";
	data_header[10][2] = "7%";
	data_header[10][3] = "medType";

	data_header[11] = new Array;
	data_header[11][0] = "Medical Type Id"
	data_header[11][1] = "hide";
	data_header[11][2] = "7%";
	data_header[11][3] = "medTypeId";
	
	data_header[12] = new Array;
	data_header[12][0] = "DB Falg"
	data_header[12][1] = "hide";
	data_header[12][2] = "7%";
	data_header[12][3] = "db_flag";
	
	data_header[13] = new Array;
	data_header[13][0] = "Hospital/SMC Name"
	data_header[13][1] = "data";
	data_header[13][2] = "7%";
	data_header[13][3] = "hospital_name";

	data_arr = new Array();
	<%
		List<String> mdExamStatus =new ArrayList<String>();
		mdExamStatus.add(0, "c");
		mdExamStatus.add(1, "IP");
		mdExamStatus.add(2, "RV");
		mdExamStatus.add(3, "MOP");
		mdExamStatus.add(4, "MOR");
		mdExamStatus.add(5, "AAP");
		mdExamStatus.add(6, "OCP");
		mdExamStatus.add(7, "AAR");
		mdExamStatus.add(8, "OCR");
		mdExamStatus.add(9, "PAP");
		mdExamStatus.add(10, "PAR");
		mdExamStatus.add(11, "PAV");
		mdExamStatus.add(12, "AHP");
		mdExamStatus.add(13, "AHR");
		mdExamStatus.add(14, "AHV");
	    int  counter=0;
		if (mdExamAssistantList != null && mdExamAssistantList.size() > 0) { %>

	<% 	Iterator ite = mdExamAssistantList.iterator();
	while ( ite.hasNext() ) {
        Object[] pair = (Object[]) ite.next();
        String dateExam = null;
        if(pair[2]!=null){
        //Date dates= (Date)pair[2];
       // dateExam =HMSUtil.convertDateTypeToStringWithoutTime(dates);
        	//dateExam= pair[2];
        	//System.out.print("date="+pair[2]);
        }
        
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%=pair[1] %>
			data_arr[<%= counter%>][1] = "<input style='width:15px;border:none;' type='radio' class='radiogrid' name='parent' value='<%=pair[1]%>' id='parent' onclick='fillHISMedExamId(this)' />"
				<%if(pair[2] != null){%>
				data_arr[<%= counter%>][2] = "<%=pair[2]%>"
				<%}else{%>
				data_arr[<%= counter%>][2] = ""
				<%}%>
			<%if(pair[3] != null){%>
			data_arr[<%= counter%>][3] = "<%=pair[3]%>"
			<%}else{%>
			data_arr[<%= counter%>][3] = ""
			<%}%>
			<%if(pair[4] != null){%>
			data_arr[<%= counter%>][4] = "<%=pair[4]%>"
			<%}else{%>
			data_arr[<%= counter%>][4] = ""
			<%}%>
			<%if(pair[5] != null){%>
			data_arr[<%= counter%>][5] = "<%=pair[5]%>"
			<%}else{%>
			data_arr[<%= counter%>][5] = ""
			<%}%>
			
			data_arr[<%= counter%>][6] = ""
			
			data_arr[<%= counter%>][7] = ""
			
			<%if(pair[5] != null){%>
			data_arr[<%= counter%>][8] = "<%=pair[5]%>"
			<%}else{%>
			data_arr[<%= counter%>][8] = ""
			<%}%>
			

			<%if(pair[6] != null){%>
			data_arr[<%= counter%>][9] = "<%=pair[6]%>"
			<%}else{%>
			data_arr[<%= counter%>][9] = ""
			<%}%>
			
			<%if(pair[7] != null){%>
			data_arr[<%= counter%>][10] = "<%=pair[7]%>"
			<%}else{%>
			data_arr[<%= counter%>][10] = ""
			<%}%>
			
			<%if(pair[8] != null){%>
			data_arr[<%= counter%>][11] = "<%=pair[8]%>"
			<%}else{%>
			data_arr[<%= counter%>][11] = ""
			<%}
			
			if(pair[10] != null){%>
			data_arr[<%= counter%>][12] = "<%=pair[10]%>"
			<%}else{%>
			data_arr[<%= counter%>][12] = ""
			<%}
			if(pair[11] != null){%>
			data_arr[<%= counter%>][13] = "<%=pair[11]%>"
			<%}else{%>
			data_arr[<%= counter%>][13] = ""
			<%}
			if(pair[9] != null){%>
			data_arr[<%= counter%>][14] = "<%=pair[9]%>"
			<%}else{%>
			data_arr[<%= counter%>][14] = ""
			<%}
				
				
				    counter++;
		    	}
			}
		%>

    formName = "mdExamPreviousPatientMedicalAssistant"

	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;

	}

	makeTable(start,end);


	</script>
<div class="Clear"></div>
<div class="floatRight">
<label class="auto"><span>Total Patient Visit </span></label>

</div>
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="medExamId" id="medExamId" value="" />


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
function fillHISMedExamId(printValueObj){
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
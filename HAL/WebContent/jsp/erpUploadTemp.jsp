

<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.UPLOAD_FILENAME"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/controls.js?n=1"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<%
	String pageTitle = "";
    String message = "";
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<Object[]> seedCategoryList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();
	
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	

	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName"); 
	 
	}
	
	String currentDate = (String)utilMap.get("currentDate");  
	
	
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId =  (Integer)session.getAttribute("hospitalId");
	}
	int empId = 0;
	if(session.getAttribute("empId") != null){
		empId = (Integer)session.getAttribute("empId");
	}
	
	//out.print("hospitalId="+hospitalId);
	
	
	
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId =  (Integer)session.getAttribute("deptId");
	}
%>

<form name="getReferralWaitingList" method="post" action="">
    <h4><%=message %></h4>
	<h2>ERP Upload </h2>
 
	<div class="Block" style="padding-top: 20px;">
		<div id="divSearchResult">

			
			<div class="clear"></div>
			<div class="clear"></div>
             <div class="Block">

<label>Select File</label> <input
	type="file" name="uploadFilename" id="uploadFilename" value="" />
	
	  <input type="button" name="impbutton" id="submitForDisable" value="Read Excel" class="buttonBig" onClick="fileValidation()">
	  
	 <!--  <input type="button" name="billable" id="billable" value="Generate Excel"
				class="button"
				onClick="if(confirm('Are you sure you want to generate Excel!')){submitForm('getReferralWaitingList','/hms/hms/referral?method=generateExcelForPortal')};"
				accesskey="r" tabindex=1 />  -->
</div>
			 
		
          <input type="hidden" value="<%=empId%>" name="approvedBy" /> 
		</div>
		<div id="pageNavPosition"></div>

	</div>
	<div class="clear"></div>
<div class="division"></div>	
<div class="paddingTop15"></div>
	<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>

<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js?n=1"></script>

<script language="javascript">
	var nPageNo = 1;

	var $j = jQuery.noConflict();

	$j(document).ready(function() {
		/* GetPatientList('ALL'); */

	});

	function GetPatientList(MODE) {

		var hospitalId =
<%out.print(hospitalId);%>
	;

		if (MODE == 'ALL') {
			var data = "PN=" + nPageNo + "&hospitalId=" + hospitalId;
		} else {
			var data = "PN=" + nPageNo + "&hospitalId=" + hospitalId;
		}
		var url = "referral?method=getExcelWaitingList";
		var bClickable = true;
		GetJsonData('tblListOfPatient', data, url, bClickable);
	}

	function makeTable(jsonData) {
		var htmlTable = "";
		for (i = 0; i < jsonData.length; i++) {

			htmlTable = htmlTable + "<tr id="+jsonData[i].opdId+">";
			
			htmlTable = htmlTable + "<td >" + jsonData[i].employeeNo
					+ "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].name + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].relation + "</td>";
			/* htmlTable = htmlTable + "<td >" + jsonData[i].age + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].gender + "</td>"; */
			htmlTable = htmlTable + "<td >" + jsonData[i].division + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].treatmentType + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].referralNo + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].referredDate + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].referredBy + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].referredFrom + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].excelStatus + "</td>";

			htmlTable = htmlTable + "</tr>";
		}
		if (jsonData.length == 0) {
			htmlTable = htmlTable
					+ "<tr><td colspan='11'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}

		$j("#tblListOfPatient").html(htmlTable);

	}

 	function executeClickEvent(Id)
	 {
	   
	 window.location="referral?method=generateExcelWaitingPage&opdId="+Id;
	 } 
			 
/*
	 function showMedicalExamDetails(tempId)
	 {
	 //alert(tempId);
	 var array = new Array();
	 array = tempId.split("~~~");
	 var visitId = array[0];
	 var medExamType = array[1];
	
	
	 //window.location = "medicalExam?method=showAnnualMedExamJsp&visitId="+visitId+"&medExamType="+ExamType;
	
	 if(medExamType=='Primary/Extension Med. Exam(AFMSF-2A)'){
	 window.location = "medicalExam?method=showPrimaryExtMedExamJsp&visitId="+visitId+"&medExamType="+medExamType;
	 }else if((medExamType=='Annual Medical Exam(AFMSF-3B)')||(medExamType=='Prior To Proceedings Abroad Med. Exam(AFMSF-3B)')||(medExamType=='High Altitude Med. Exam(AFMSF-3B)'))
	 {   
	 if(validateMetaCharactersExam(medExamType)){
	 window.location = "medicalExam?method=showAnnualMedExamJsp&visitId="+visitId+"&medExamType="+medExamType;
	 }
	 }else if(medExamType=='Med. Exam On Release/Discharge(AFMSF-18)')
	 {
	 if(validateMetaCharactersExam(medExamType)){
	 window.location = "medicalExam?method=showReleaseDischargeJsp&visitId="+visitId+"&medExamType="+medExamType;
	 }
	 }else if(medExamType == 'Medical Case Sheet(AFMSF-7A)'){
	 window.location = "opd?method=showOPDMainJsp&visitId="+visitId;
	
	 }else if(medExamType == 'Form-44(AFMSF-44)'){
	 window.location = "opd?method=showOPDMainJsp&visitId="+visitId;
	 }	    
	 else if(medExamType=='AFMSF-7A')
	 { 
	 window.location = "medicalExam?method=showAFMSF7AJsp&visitId="+visitId+"&medExamType="+medExamType;
	 }
	 //-by kiran
	 else if(medExamType == 'Form-44')
	 {
	 window.location = "medicalExam?method=showMeForm44JSP&visitId="+visitId;
	 }
	
	
	 } */

	function showResultPage(pageNo) {

		nPageNo = pageNo;
		GetPatientList('FILTER');

	}

	function ShowAllList(pageNo) {

		$j("#pageno").val("");
		nPageNo = pageNo;
		GetPatientList('ALL');

	}

	function goToPageForPatient(pageNo) {
		if (pageNo != "") {
			if (parseInt(TotalNumberOfPages) < parseInt(pageNo)) {

				alert("Please enter correct page No.");
				return;

			}
		} else {
			alert("Please enter correct page No.");
			return;
		}

		nPageNo = pageNo;
		GetPatientList('FILTER');
	}

	function validateRadio() {

		var flag = false;

		for (var i = 0; i < document.getElementsByName("patientId").length; i++) {
			if (document.getElementsByName("patientId")[i].checked == true) {
				flag = true;
			} 
		}
		if (!flag) {
			alert("Please select at least one radio button");
		}
		return flag;

	}
	

		function fileValidation()
		{
			var fname =document.getElementById('uploadFilename').value;
			if (document.getReferralWaitingList.uploadFilename.value=="")
			{
			alert('Pl. Select the Excel file to Import!.....');
			return;
			}
			var fname = document.getReferralWaitingList.uploadFilename.value;
			var st = fname.length;
			st = st-3;
			if (fname.substring(st)!="xls")
			{
			alert('Only Excel files are Allowed.');
			return;
			}
			
			document.getReferralWaitingList.encoding="multipart/form-data";
				
			var ind = fname.lastIndexOf("\\");
			var filename = fname.substring(ind+1);
			
			
			submitForm('getReferralWaitingList','/hms/hms/referral?method=submitERPUploadTemp')
			/* submitForm('departmentInd','stores?method=importPVMSOpeningBalanceForDisplay&filename='+filename,'checkDepartment'); */
		} 	
</script>


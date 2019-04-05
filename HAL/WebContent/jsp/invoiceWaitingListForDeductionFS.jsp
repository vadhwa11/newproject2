
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasImpanneledHospital"%>

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
	
	//out.print("hospitalId="+hospitalId);.
	
	List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
	
	if(map.get("rankCategoryList") != null){
		rankCategoryList = (List<MasRankCategory>)map.get("rankCategoryList");
	}
	
    List<MasImpanneledHospital> impHospitalList = new ArrayList<MasImpanneledHospital>();
	
	if(map.get("impHospitalList") != null){
		impHospitalList = (List<MasImpanneledHospital>)map.get("impHospitalList");
	}
List<Object[]> noteSheetNoList = new ArrayList<Object[]>();
	
	if(map.get("noteSheetNoList") != null){
		noteSheetNoList = (List<Object[]>)map.get("noteSheetNoList");
	}
	
	
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId =  (Integer)session.getAttribute("deptId");
	}
%>

<form name="getReferralWaitingList" method="post" action="">
    <h4><%=message %></h4>
	<h2>Deduction From Salary</h2>

	<div class="Block" style="padding-top: 20px;">
	
	<label>Emp No</label>

<input type="text" name ="empNo" id="empNo" value="" onchange="GetPatientList('FILTER');">
	
	
	<label>Rank Category</label>
<select name ="rankCategoryId" id="rankCategoryId"  onchange ="GetPatientList('FILTER');">
<option value="0">Select</option>
	<%
		if(rankCategoryList.size()>0)
		{
			for(MasRankCategory rc : rankCategoryList)
			{
				%>
					<option value="<%=rc.getId()%>"><%=rc.getRankCategoryName()%></option>
				<%
			}
		}
	%>
</select>
	
	

<%-- 
<label>NoteSheet No</label>
<select name ="noteSheetNo" id="noteSheetNoId"   onchange ="GetPatientList('FILTER');">
<option value="0">Select</option>
	<%
	
		if(noteSheetNoList.size()>0)
		{
			for(Object ns : noteSheetNoList)
			{
				%>
					<option value="<%=ns%>"><%=ns%></option>
				<%
			}
		}
	%>
</select> --%>

	<label>Hospital</label>

<select name ="impHospitalId" id="impHospitalId" validate="Hospital,string,no" onchange="GetPatientList('FILTER');">
<option value="0">Select</option>
	<%
		if(impHospitalList.size()>0)
		{
			for(MasImpanneledHospital meh: impHospitalList)
			{
				%>
					<option value="<%=meh.getId()%>"><%=meh.getImpanneledHospitalName()%></option>
				<%
			}
		}
	%>
</select>

<div class="clear"></div>
<input type="button" name="reset" id="resetbutton" value="Show all" class="button" onClick="ShowAllList('1');" accesskey="r" tabindex=1 />

<div class="clear" style="padding-top: 10px;"></div>

<div class="clear" style="padding-top: 10px;"></div>





		<div id="divSearchResult">

			<table class="tblSearchActions" cellspacing="0" cellpadding="0"
				border="0">
				<tr>
					<td class="SearchStatus" style="font-size: 13px;" align="left">Search
						Results</td>
					<td>
						<div id=resultnavigation></div>


					</td>
					<td style="width: 80px;"><input id="pageno" type="text"
						maxlength="4" name="pageno" style="width: 25px;"> <input
						class="button" type="button"
						onclick="goToPageForPatient(pageno.value)" value="Go" name="ok"
						style="width: 35px;"></td>
				</tr>
			</table>

			<table id="tblSearchResultsHeader" class="tblSearchResultsHeader"
				cellspacing="0" cellpadding="0" border="0">
				<tr>
                     <!-- <th id="th1" style='width: 10px;'>Select</th> -->
					<th id="th1" style='width: 10px;'>Emp. No</th>
					<th id="th1" style='width: 100px;'>Patient Name</th>
					<th id="th1" style='width: 100px;'>Relation</th>
					<!-- <th id="th2" style='width: 100px;'>Age</th>
					<th id="th3" style='width: 120px;'>Gender</th> -->
					<!-- <th id="th4" style='width: 120px;'>Division</th> -->
					<th id="th4" style='width: 120px;'>Treatment<br>Type</th>
					<th id="th5" style='width: 150px;'>Dispatch<br>No</th>
					<th id="th5" style='width: 150px;'>Dispatch<br>Date</th>
					<th id="th5" style='width: 150px;'>NoteSheet<br>No</th>
					<!-- <th id="th5" style='width: 150px;'>NoteSheet<br>Date</th> -->
					<th id="th5" style='width: 150px;'>Cover Note No</th>
					<!-- <th id="th5" style='width: 150px;'>Cover Note<br>Date</th> -->
					<th id="th5" style='width: 150px;'>Referral No</th>
					<!-- <th id="th5" style='width: 150px;'>Referral Date</th> -->
					<th id="th5" style='width: 150px;'>Approved<br>Bill Amt</th>
					<!-- <th id="th6" style='width: 100px;'>Referred By</th>
					<th id="th6" style='width: 100px;'>Referred From</th> -->
					<th id="th6" style='width: 100px;'>Empanelled Hospital</th>
					<th id="th6" style='width: 100px;'>Deduction<br>From<br>Salary</th>


				</tr>
				<tbody id="tblListOfPatient">

				</tbody>
			</table>
			<div class="clear"></div>
			<div class="clear"></div>
			
		</div>
		<div class="block">
            
                   
		
				<!-- <label>Total Bill Amt</label><input type="text" value="0" id="totalAmt" name="totalAmt" readonly="readonly"/> --> 
				<!-- <input type="button" name="yes" value="Deducted"	class="button"	onclick="if(confirm('Are you sure want to mark as deducted!')){validateCheckboxForDeduction()}" /> -->
          <input type="hidden" value="<%=empId%>" name="approvedBy" /> 
          <input type="hidden" id="flag" name="flag" value="Divisional_approval_letter"/>
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
		GetPatientList('ALL');

	});

	function GetPatientList(MODE) {

		var hospitalId =<%out.print(hospitalId);%>;
		var impHospitalId = $j("#impHospitalId").val();
		var empNo = $j("#empNo").val();
		var rankCategoryId = $j("#rankCategoryId").val();
		var noteSheetNo = $j("#noteSheetNoId").val();

		if (MODE == 'ALL') {
			var data = "PN=" + nPageNo + "&hospitalId=" + hospitalId;
		} else {
			var data = "PN=" + nPageNo + "&impHospitalId=" + impHospitalId+"&empNo="+empNo+"&rankCategoryId="+rankCategoryId+"&noteSheetNo="+noteSheetNo;;
		}
		var url = "referral?method=getInvoiceWaitingListForGM&deducted=n";
		var bClickable = true;
		GetJsonData('tblListOfPatient', data, url, bClickable);
		$j("#totalAmt").val(0);
	}

	function makeTable(jsonData) {
		var htmlTable = "";
		for (i = 0; i < jsonData.length; i++) {

			htmlTable = htmlTable + "<tr id="+jsonData[i].headerId+">";
			/* htmlTable = htmlTable + "<td ><input type='checkbox' name='headerId"+i+"' id='headerId"+i+"' value='"+jsonData[i].headerId+"' style='margin-right: 0px; margin-left: 15px;'/></td>"; */
			htmlTable = htmlTable + "<td >" + jsonData[i].employeeNo
					+ "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].name + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].relation + "</td>";
			/* htmlTable = htmlTable + "<td >" + jsonData[i].age + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].gender + "</td>"; */
			/* htmlTable = htmlTable + "<td >" + jsonData[i].division + "</td>"; */
			htmlTable = htmlTable + "<td >" + jsonData[i].treatmentType + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].dispatchNo + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].dispatchDate + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].noteSheetNo + "</td>";
			/* htmlTable = htmlTable + "<td >" + jsonData[i].noteSheetDate + "</td>"; */
			htmlTable = htmlTable + "<td >" + jsonData[i].coverNoteNo + "</td>";
			/* htmlTable = htmlTable + "<td >" + jsonData[i].coverNoteDate + "</td>"; */
			htmlTable = htmlTable + "<td >" + jsonData[i].referralNo + "</td>";
			/* htmlTable = htmlTable + "<td >" + jsonData[i].referredDate + "</td>"; */
			htmlTable = htmlTable + "<td ><input type='hidden' name='amt"+i+"' id='amt"+i+"' value='"+jsonData[i].adminBillAmt+"'/>" + jsonData[i].adminBillAmt + "</td>";
			/* htmlTable = htmlTable + "<td >" + jsonData[i].referredBy + "</td>";*/
			htmlTable = htmlTable + "<td >" + jsonData[i].referredFrom + "</td>"; 
			htmlTable = htmlTable + "<td >" + jsonData[i].deduction + "</td>";
			

			htmlTable = htmlTable + "</tr>";
		}
		if (jsonData.length == 0) {
			htmlTable = htmlTable
					+ "<tr><td colspan='13'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr><input type = 'hidden' name='checkboxCount' id='checkboxCount' value='"+jsonData.length+"'/>";
		}
		else
			{
			htmlTable = htmlTable +"<input type = 'hidden' name='checkboxCount' id='checkboxCount' value='"+jsonData.length+"'/>";
			
			}
		

		$j("#tblListOfPatient").html(htmlTable);

	}

	 function executeClickEvent(Id)
	 {
	   
	 window.location="referral?method=generateInvoicePageForAll&deducted=n&opdId="+Id;
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
		$j("#impHospitalId option[value='0']").prop("selected","selected");
		$j("#rankCategoryId option[value='0']").prop("selected","selected");
		$j("#empNo").val("");

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

	function validateCheckbox() {

		var flag = false;

		for (var i = 0; i < document.getElementById("checkboxCount").value; i++) {
			if (document.getElementById("headerId"+i).checked == true) {
				flag = true;
			} 
		}
		if (!flag) {
			alert("Please select at least one checkbox");
		}
		else
		{
			/* if(parseInt(document.getElementById("totalAmt").value)>1000000)
				{
				alert("Total amount can't be greater than 1000000");
				}
			else
				{
				submitForm('getReferralWaitingList','/hms/hms/referral?method=generateDivisionalApprovalLetter&flag=Divisional_approval_letter');
				} */
			submitForm('getReferralWaitingList','/hms/hms/referral?method=generateDivisionalApprovalLetter&flag=Divisional_approval_letter');
			
		}
		

	}
	
	function calculateTotal(cnt)
	{
		if (document.getElementById("headerId"+cnt).checked == true) {
			document.getElementById("totalAmt").value=parseInt(document.getElementById("totalAmt").value)+parseInt(document.getElementById("amt"+cnt).value);
		} 
		else
			{
			document.getElementById("totalAmt").value=parseInt(document.getElementById("totalAmt").value)-parseInt(document.getElementById("amt"+cnt).value);
			}
	}
	
	function validateCheckboxForDeduction() {

		var flag = false;

		for (var i = 0; i < document.getElementById("checkboxCount").value; i++) {
			if (document.getElementById("headerId"+i).checked == true) {
				flag = true;
			} 
		}
		if (!flag) {
			alert("Please select at least one checkbox");
		}
		else
		{
			
			submitForm('getReferralWaitingList','/hms/hms/referral?method=revertToHRDivision');
			
		}
		
	}
</script>


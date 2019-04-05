

<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasImpanneledHospital"%>
<%@page import="jkt.hms.masters.business.MasDivision"%>
<%@page import="static jkt.hms.util.RequestConstants.FROM_DATE"%>

<%@page import="jkt.hms.util.HMSUtil"%>






<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>

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
	
	List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
	
	if(map.get("rankCategoryList") != null){
		rankCategoryList = (List<MasRankCategory>)map.get("rankCategoryList");
	}
	
    List<MasImpanneledHospital> impHospitalList = new ArrayList<MasImpanneledHospital>();
	
	if(map.get("impHospitalList") != null){
		impHospitalList = (List<MasImpanneledHospital>)map.get("impHospitalList");
	}
	
	 List<MasDivision> divisionList = new ArrayList<MasDivision>();
		
		if(map.get("divisionList") != null){
			divisionList = (List<MasDivision>)map.get("divisionList");
		}
	
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId =  (Integer)session.getAttribute("deptId");
	}
%>

<form name="getReferralWaitingList" method="post" action="">
    <h4><%=message %></h4>
	<h2>Referral Waiting List </h2>

	<div class="Block" style="padding-top: 20px;">
	<label>Emp No</label>

<input type="text" name ="empNo" id="empNo" value="" onchange="GetPatientList('FILTER');">
	
	
	
	
	<label>Division</label>

<select name ="divisionId" id="divisionId"  onchange="GetPatientList('FILTER');">
<option value="0">Select</option>
	<%
		if(divisionList.size()>0)
		{
			for(MasDivision md: divisionList)
			{
				%>
					<option value="<%=md.getId()%>"><%=md.getDivisionName()%></option>
				<%
			}
		}
	%>
	</select>
	
	<label>Hospital</label>

<select name ="impHospitalId" id="impHospitalId"  onchange="GetPatientList('FILTER');">
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
<label class="medium">Date<span></span></label> 
<input type="text" name="<%=FROM_DATE%>" id="<%=FROM_DATE%>" class="calDate"  value="" MAXLENGTH="10"  placeholder="DD/MM/YYYY" validate="Date,date,no" onkeyup="mask(this.value,this,'2,5','/');" onchange="GetPatientList('FILTER');" />


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

					<th id="th1" style='width: 10px;'>Emp. No</th>
					<th id="th1" style='width: 100px;'>Patient Name</th>
					<th id="th1" style='width: 100px;'>Relation</th>
					<th id="th2" style='width: 100px;'>Age</th>
					<th id="th3" style='width: 120px;'>Gender</th>
					<th id="th4" style='width: 120px;'>Division</th>
					<th id="th6" style='width: 100px;'>Treatment Type</th>
					<th id="th5" style='width: 150px;'>Referral Date</th>
					<th id="th6" style='width: 100px;'>Referred By</th>
					<th id="th6" style='width: 100px;'>Referred From</th>
					


				</tr>
				<tbody id="tblListOfPatient">

				</tbody>
			</table>
			<div class="clear"></div>
			<div class="clear"></div>

			<!-- <input type="button" name="billable" id="billable" value="Billable"
				class="button"
				onClick="if(validateRadio()){submitForm('getReferralWaitingList','/hms/hms/registration?method=submitPendingForApproval&flag=y')};"
				accesskey="r" tabindex=1 /> 
				<input type="button" name="nonBillable"
				id="nonBillable" value="Non Billable" class="button"
				onClick="if(validateRadio()){submitForm('getReferralWaitingList','/hms/hms/registration?method=submitPendingForApproval&flag=n')};"
				accesskey="r" tabindex=1 /> -->
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


<script language="javascript">
	var nPageNo = 1;

	//var $j = jQuery.noConflict();

	$j(document).ready(function() {
		GetPatientList('ALL');

	});

	function GetPatientList(MODE) {

		var hospitalId =<%out.print(hospitalId);%>;
		var impHospitalId = $j("#impHospitalId").val();
		var empNo = $j("#empNo").val();
		var rankCategoryId = $j("#rankCategoryId").val();
		var fromDate = $j("#fromDate").val();
		var divisionId = $j("#divisionId").val();

		if (MODE == 'ALL') {
			var data = "PN=" + nPageNo + "&hospitalId=" + hospitalId;
		} else {
			var data = "PN=" + nPageNo + "&impHospitalId=" + impHospitalId+"&empNo="+empNo+"&rankCategoryId="+rankCategoryId+"&divisionId="+divisionId+"&date="+fromDate;
		}
		var url = "referral?method=getReferralWaitingListForDoctor";
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
			htmlTable = htmlTable + "<td >" + jsonData[i].age + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].gender + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].division + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].treatmentType + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].referredDate + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].referredBy + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].referredFrom + "</td>";

			htmlTable = htmlTable + "</tr>";
		}
		if (jsonData.length == 0) {
			htmlTable = htmlTable
					+ "<tr><td colspan='10'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}

		$j("#tblListOfPatient").html(htmlTable);

	}

	 function executeClickEvent(Id)
	 {
	   
	 window.location="referral?method=viewReferralLetterPage&opdId="+Id;
	 } 
			 

	function showResultPage(pageNo) {

		nPageNo = pageNo;
		GetPatientList('FILTER');

	}

	function ShowAllList(pageNo) {

		$j("#pageno").val("");
		nPageNo = pageNo;
		GetPatientList('ALL');
		$j("#divisionId option[value='0']").prop("selected","selected");
		$j("#impHospitalId option[value='0']").prop("selected","selected");
		$j("#empNo").val("");
		$j("#fromDate").val("");

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

	
</script>


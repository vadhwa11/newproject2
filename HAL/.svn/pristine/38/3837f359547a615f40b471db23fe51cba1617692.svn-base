

<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.masters.business.MasSession"%>
<%@ page import="static jkt.hms.util.RequestConstants.DEPARTMENT_ID"%>
<%@ page import = "static jkt.hms.util.RequestConstants.SESSION_ID" %>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>

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
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTimeWithoutSc");

	

	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName"); 
	 
	}
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasSession> sessionList = new ArrayList<MasSession>();
	
 	
	 if(map.get("sessionList") != null){
		 sessionList=(List)map.get("sessionList");
		
	 }
	
	if (map.get("departmentList") != null) {
		departmentList = (List<MasDepartment>) map.get("departmentList");
 		
 	}
	
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

<form name="searchPendingForApproval" method="post" action="">
    <h4><%=message %></h4>
	<h2>Patient Visit - Referral</h2>
	<!-- <div class="page_title">Medical Exam waiting List</div> -->

	<!-- <div class="Block">

		<label>HIN.</label> <input name="ServiceNo" id="ServiceNo" type="text">
		<input type="button" name="reset" id="resetbutton" value="Search"
			class="button" onClick="GetPatientList('FILTER');" accesskey="r"
			tabindex=1 /> <input type="button" name="reset" id="resetbutton"
			value="Show all" class="button" onClick="ShowAllList('1');"
			accesskey="r" tabindex=1 />
	</div> -->
	<div class="Block" style="padding-top: 20px;">
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

					<th id="th1" style='width: 10px;'>Select</th>
					<th id="th1" style='width: 100px;'>Referral Date</th>
					<th id="th2" style='width: 100px;'>HIN No</th>
					<th id="th3" style='width: 120px;'>Name</th>
					<th id="th4" style='width: 120px;'>Age</th>
					<th id="th5" style='width: 150px;'>Gender</th>
					<!-- <th id="th6" style='width: 100px;'>Contact No</th> -->
					<th id="th6" style='width: 100px;'>Referred By Doctor</th>
					<th id="th6" style='width: 100px;'>Referred By<br> Department</th>
					<th id="th6" style='width: 100px;'>Referred To Doctor</th>
					<th id="th6" style='width: 100px;'>Referred To<br> Department</th>
					<th id="th6" style='width: 100px;'>Priority</th>


				</tr>
				<tbody id="tblListOfPatient">

				</tbody>
			</table>
			<div class="clear"></div>
			<div class="clear"></div>

			
          <input type="hidden" value="<%=empId%>" name="approvedBy" /> 
		</div>
		<div id="pageNavPosition"></div>

	</div>
	
<!--Block One Starts-->


<div class="Block" style="padding-top: 20px;">
  <label>Department <span>*</span></label>


<input type="hidden" id="deptId" name="<%=DEPARTMENT_ID%>" value=""/>
<!-- <label id="deptIdLabel">&nbsp</label> -->
<input type="text" id="deptIdLabel" value="" readOnly="true"/>
		
		
		
		<div id="doctorNSessionList" >
		<label>Doctor <span>*</span> </label>
		<input type="hidden" id="doctorId" name="employeeId" value=""/>
		<!-- <label id="doctorIdLabel">&nbsp</label> -->
		<input type="text" id="doctorIdLabel" readOnly="true" value=""/>
		
		
		
		<label>Session<span>*</span> </label>
<select  id="sesId" name="<%=SESSION_ID%>"  validate="" tabindex="1">
<option value="0">Select</option>
	<%
		if(sessionList.size() > 0){
			for(MasSession employee : sessionList){
	%>
	<option value="<%=employee.getId() %>"> <%= employee.getSessionName() %> </option>
	<%}
			}%>
</select>
		
		</div>
		<div class="clear"></div>
		
		<!-- <input name="Print" type="button" value="Generate Report" target="_blank" class="cmnButton" onClick="showReport('appSetup');"> -->
       <input name="Print" type="button" value="Show Token" target="_blank" style="width:147px;" class="button" onClick="validateTokenDiv()"> 
  <!-- <input name="Print" type="button" value="Show Setup" target="_blank" class="cmnButton"   onclick="if(validateDatefield()){ getDetails();}" /> -->
  	
		<div id="displayToken" >
		</div>
		<input type="button" name="refer" id="refer" value="Refer"
				class="button" 
				onClick="if(validateRadio()){submitReferral()};"
				accesskey="r" tabindex=1 />
				
  
  
</div>
<!--Block one Ends-->
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

		var hospitalId =
<%out.print(hospitalId);%>
	;

		if (MODE == 'ALL') {
			var data = "PN=" + nPageNo + "&hospitalId=" + hospitalId;
		} else {
			var data = "PN=" + nPageNo + "&hospitalId=" + hospitalId;
		}
		var url = "registration?method=getListOfPatientVisitReferral";
		var bClickable = false;
		GetJsonData('tblListOfPatient', data, url, bClickable);
	}

	function makeTable(jsonData) {
		var htmlTable = "";
		for (i = 0; i < jsonData.length; i++) {

			htmlTable = htmlTable + "<tr id='"+jsonData[i].Id+"'>";
			htmlTable = htmlTable
					+ "<td ><input type='radio' name='opdPDetailsId' id='opdPDetailsId' onchange='putRefferalDetails("+jsonData[i].referredToDeptId+","+jsonData[i].referredToId+",\""+jsonData[i].referredToName+"\",\""+jsonData[i].refferedToDept+"\")' style='margin-right:0px;' value='"
					+ jsonData[i].Id + "'" 
					+ "</td>";
			/* htmlTable = htmlTable + "<td >" + jsonData[i].registrationDate
					+ "</td>"; */
					htmlTable = htmlTable + "<td >" + jsonData[i].referredDate
					+ "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].HIN + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].name + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].age + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].gender + "</td>";
			/* htmlTable = htmlTable + "<td >" + jsonData[i].contactNo + "</td>"; */
			htmlTable = htmlTable + "<td >" + jsonData[i].referredByName + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].refferedFromDept + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].referredToName + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].refferedToDept + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].referralPriority + "</td>";

			htmlTable = htmlTable + "</tr>";
		}
		if (jsonData.length == 0) {
			htmlTable = htmlTable
					+ "<tr><td colspan='11'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}

		$j("#tblListOfPatient").html(htmlTable);

	}

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

		for (var i = 0; i < document.getElementsByName("opdPDetailsId").length; i++) {
			if (document.getElementsByName("opdPDetailsId")[i].checked == true) {
				flag = true;
			} 
		}
		if (!flag) {
			alert("Please select at least one radio button");
		}
		return flag;

	}
	
    function validateTokenDiv()
    {
    	var deptId = document.getElementById("deptId").value;
    	var doctorId = document.getElementById("doctorId").value;
    	var sesId = document.getElementById("sesId").value;
    	if(deptId!=0 && doctorId!=0 && sesId!=0)
    		{
    		/* submitProtoAjaxNew('visitEmployee','/hms/hms/registration?method=getTokenNoForDepartmentMultiVisit&row='+i+'&consultingDoctor'+i+'='+doctorId+'&sessionId'+i+'='+sesId+'&departmentId'+i+'='+deptId,'displayToken'+i); */
    		submitProtoAjaxNew('searchPendingForApproval','/hms/hms/registration?method=getTokenNoForDepartment&employeeId='+doctorId+'&sessionId='+sesId+'&departmentId='+deptId,'displayToken');
    		}
    	else
    	{
    		alert("Please Select Department, Doctor And Session");
    	}
    		
    }
    function putRefferalDetails(referredToDeptId, referredToId, referredToName, refferedToDept)
    {
    	
    	document.getElementById("deptId").value=referredToDeptId;   	
       	document.getElementById("doctorId").value=referredToId; 
       	document.getElementById("deptIdLabel").value=refferedToDept;   	
       	document.getElementById("doctorIdLabel").value=referredToName; 
    	
    		
    }
    
    function submitReferral(){
    	var flag ='registration';
    	if(validateMetaCharacters(flag))
    		{
    		
    		if(document.getElementById("tokenNoId") !=null)
    			{
    			if(isNaN(document.getElementById("tokenNoId").value))
    				{
    				 alert(document.getElementById("tokenNoId").value);
    				}
    			else
    				{
    				submitForm('searchPendingForApproval','/hms/hms/registration?method=submitReferral&flag=y');
    				}
    			
    			}
    		else{
    			alert("Please generate token no first");
    		}
    		
    		}
    		
    }
</script>


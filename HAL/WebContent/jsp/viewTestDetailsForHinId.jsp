

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
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<%@page import="jkt.hms.masters.business.Patient"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-color.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/wysiwyg-settings.js"></script>


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
	
 	

	
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId =  (Integer)session.getAttribute("hospitalId");
	}

	
	int hinId = 0;
	if (map.get("hinId") != null) {
		hinId = (Integer) map.get("hinId");
 	}

%>

<form name="previousInvestigation" method="post" action="">
    <h4><%=message %></h4>
	<h2>PREVIOUS INVESTIGATIONS</h2>
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

			<!-- 		<th id="" style='width: 10px;'>Select</th> -->
						<th>Investigation Name</th>
			  			<th width="10%" >Modality</th> 
			  			<th>Order No</th>
			  			<th>Order Date</th>
			  			<th>Prescribed by</th>
						<th>Result</th>
						<th>UOM</th>
						<th>Normal Range</th>
						<th>Investigation Status</th>
						<th>Report</th>
				<!-- 	<th id="th2" style='width: 100px;'>HIN No</th>
					<th id="th3" style='width: 120px;'>Name</th>
					<th id="th4" style='width: 120px;'>Age</th>
					<th id="th5" style='width: 150px;'>Gender</th>
					<th id="th6" style='width: 100px;'>Contact No</th>
					<th id="th6" style='width: 100px;'>Referred By Doctor</th>
					<th id="th6" style='width: 100px;'>Referred By<br> Department</th>
					<th id="th6" style='width: 100px;'>Referred To Doctor</th>
					<th id="th6" style='width: 100px;'>Referred To<br> Department</th>
					<th id="th6" style='width: 100px;'>Priority</th> -->


				</tr>
				<tbody id="tblListOfPatient">

				</tbody>
			</table>
			<div class="clear"></div>
			<div class="clear"></div>


		</div>
		<div id="pageNavPosition"></div>

	</div>
	
	<div id="testDivDown"></div>
	
<!--Block One Starts-->


<%-- <div class="Block" style="padding-top: 20px;">
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
				
  
  
</div> --%>
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
			var data = "PN=" + nPageNo + "&hospitalId=" + hospitalId +"&hinId="+<%=hinId%>;
		} else {
			var data = "PN=" + nPageNo + "&hospitalId=" + hospitalId+"&hinId="+<%=hinId%>;
		}
		//var url = "registration?method=getListOfPatientVisitReferral";
		var url = "lab?method=viewAllTestForOrderNo1";
		var bClickable = false;
		GetJsonData('tblListOfPatient', data, url, bClickable);
	}

	function makeTable(jsonData) {
		try{
		var htmlTable = "";
		for (i = 0; i < jsonData.length; i++) {

			htmlTable = htmlTable + "<tr>";
		/* 	htmlTable = htmlTable
					+ "<td ><input type='radio' name='opdPDetailsId' id='opdPDetailsId' onchange='putRefferalDetails("+jsonData[i].referredToDeptId+","+jsonData[i].referredToId+",\""+jsonData[i].referredToName+"\",\""+jsonData[i].refferedToDept+"\")' style='margin-right:0px;' value='"
					+ jsonData[i].Id + "'" 
					+ "</td>"; */
			/* htmlTable = htmlTable + "<td >" + jsonData[i].registrationDate
					+ "</td>"; */
			/* 		htmlTable = htmlTable + "<td >" + jsonData[i].referredDate
					+ "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].HIN + "</td>"; */
			htmlTable = htmlTable + "<td >" + jsonData[i].name + "</td>";
 			htmlTable = htmlTable + "<td >" + jsonData[i].modality + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].orderno + "</td>"; 
			/* htmlTable = htmlTable + "<td >" + jsonData[i].contactNo + "</td>"; */
		
 			htmlTable = htmlTable + "<td >" + jsonData[i].orderDate + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].prescribedBy + "</td>";
			
		
			if(jsonData[i].resultType=="m"){
				htmlTable = htmlTable
				+ "<td ><input type='button' name='Result' id='Result' onclick='clearTestDivDown("+"\"rhLab"+"\","+jsonData[i].resultHeaderId+",\""+jsonData[i].resultType+"\",\""+jsonData[i].orderStatus+"\",\""+jsonData[i].confidential+"\")' style='margin-right:0px;' value='Result' class='button'>"
				+ "</td>";
			}
			else if(jsonData[i].resultType=="t"){
				htmlTable = htmlTable
				+ "<td ><input type='button' name='Result' id='Result' onclick='clearTestDivDown("+"\"rEntryDetailLab"+"\","+jsonData[i].resultHeaderId+",\""+jsonData[i].resultType+"\",\""+jsonData[i].orderStatus+"\",\""+jsonData[i].confidential+"\")' style='margin-right:0px;' value='Result' class='button'>"
				+ "</td>";
			}
			else{
				
			htmlTable = htmlTable + "<td >" +jsonData[i].result.replace("#", "'").replace("$", "\"") + "</td>";
			}
			htmlTable = htmlTable + "<td >" + jsonData[i].UOM + "</td>";
			htmlTable = htmlTable + "<td >" + jsonData[i].normalRange + "</td>";
			if(jsonData[i].rejectedReason!="")
			htmlTable = htmlTable + "<td >" + jsonData[i].investigationStatus +" <span> (Reason: "+jsonData[i].rejectedReason+ ")</span></td>";
			else
			htmlTable = htmlTable + "<td >" + jsonData[i].investigationStatus +"</td>";
			
			if(jsonData[i].orderNo!="0"){
			htmlTable = htmlTable
			+ "<td ><input type='button' name='HTML' id='html' onclick='submitResultPrintAfterValidationForReport("+jsonData[i].orderNo+")' style='margin-right:0px;' value='HTML' class='button'>"+"</td>";
			}
			else
				htmlTable = htmlTable+"<td></td>";
			
			htmlTable = htmlTable + "</tr>";
		}
		if (jsonData.length == 0) {
			htmlTable = htmlTable
					+ "<tr><td colspan='11'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}

		$j("#tblListOfPatient").html(htmlTable);
		}
		catch(err) {
		   alert(err.message);
		}

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



    
	function clearTestDivDown(flag,id,resultType,resultStatus,confidential){
		document.getElementById('testDivDown').innerHTML = "";
		if(flag == 'rhLab'){
			window.close();
			window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');
		}
		if(flag == 'rdRadio'){
			window.close();
			//window.showModalDialog('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','dialogHeight=120,dialogWidth=120','dialogLeft=100,dialogTop=160,dialogHeight=120,dialogWidth=120,,status=2,scrollbars=1,resizable=0,center=1');
			window.open('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');
		}
		if(flag == 'rhSenLab'){
			window.close();
			window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=25,top=160,height=400,width=970,status=1,scrollbars=1,resizable=1');			
			//submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'','testDivDown');
		}
		if(flag == 'rEntryDetailLab'){
			window.close();
			if(resultType == 's'){
				window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');				
			}else{
				window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');				
			}
		}
	}

	function submitResultPrintAfterValidationForReport(orderNo){
					window.close();
					 window.open('/hms/hms/investigation?method=printResultValidationLab&orderNo='+orderNo);
				
			}
	</script>


<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : pendingResultValidationLab.jsp 
	 * Tables Used         : DgSampleCollectionHeader,DgSampleCollectionDetails,MasSample,Patient,MasSubChargecode
	 * Description         : 
	 * @author  Create Date: 21.07.2008    Name: Abha
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@page import="jkt.hms.masters.business.MasSample"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<form name="patientSearch" action="" method="post">
<script	type="text/javascript" language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <%
		Box box = HMSUtil.getBox(request);
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<DgOrderhd>orderList = new ArrayList<DgOrderhd>();
		List<MasSample>sampleList = new ArrayList<MasSample>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();
		List<String> stringOfIdsList = new ArrayList<String>();
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
		 date = (String) utilMap.get("currentDate");
	 	Date toDate  = null;
		Date fromDate=null;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("patientList") != null){
			patientList= (List<DgResultEntryHeader>)patientMap.get("patientList");
			
		}
		if(patientMap.get("stringOfIdsList") != null){
			stringOfIdsList = (List<String>)patientMap.get("stringOfIdsList");
			
		}
		if(patientMap.get("stringOfSubDeptIdsList") != null){
			stringOfSubDeptIdsList = (List<String>)patientMap.get("stringOfSubDeptIdsList");
			
		}

		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		String userName = "";
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}
		if(detailsMap.get("subChargeCodeList") != null){
			subChargeCodeList = (List<MasSubChargecode>)detailsMap.get("subChargeCodeList");
			}
		if(detailsMap.get("orderList") != null){
			orderList = (List<DgOrderhd>)detailsMap.get("orderList");
			}
		if(detailsMap.get("sampleList") != null){
			sampleList = (List<MasSample>)detailsMap.get("sampleList");
			}
		if(detailsMap.get("chargeCodeList") != null){
			chargeCodeList = (List<MasChargeCode>)detailsMap.get("chargeCodeList");
			}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
			}
		
		List<DgResultEntryHeader> ResultValidationList = new ArrayList<DgResultEntryHeader>();
		if(detailsMap.get("ResultValidationList") != null){
			ResultValidationList = (List<DgResultEntryHeader>)detailsMap.get("ResultValidationList");
			}
		int deptId=0;
		
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		String deptName="";
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		String deptType="";
		if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
		}
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);
			
		<%}
	%>
	</script> <%if(deptId == 49){ %>
<div class="titleBg"><h2>Pending For Report Validation</h2></div>
<%}else{ %>
<div class="titleBg"><h2>Pending For Result Validation</h2></div>
<%} %>
<div class="Clear"></div>
<h4>Patient Search</h4>
<div class="Block">
<label>Bar Code Search</label>
<input type="text" name="barCodeOrderNo"	id="barCodeOrderNo" value="" MAXLENGTH="20" onkeypress="return searchKeyPress(event);" /> 



<%-- <label> From Date</label> 
<input  type="text" class="calDate"  id="fromDateId" name="fromDate" placeholder="DD/MM/YYYY" validate="From Date,string,no" value="" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10" style="width: 120px"/>

<label>To Date</label> 
<input type="text" id="ToDateId"	name="<%=TO_DATE %>" value="" class="calDate"	placeholder="DD/MM/YYYY" validate="To Date,string,no" value="" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10" style="width: 120px" /> 



<label>Modality</label> 
<select	id="subChargeCodeId" name="<%=SUB_CHARGECODE_ID %>">
<option value="0">Select</option>
<%
	for(MasSubChargecode subChargecode : subChargeCodeList){
	%>
<option value="<%=subChargecode.getId() %>"
	<%=HMSUtil.isSelected(subChargecode.getId(),Integer.valueOf(box.getInt(SUB_CHARGECODE_ID)))%>><%=subChargecode.getSubChargecodeName() %></option>
<%}%>
</select>
 --%>




<label> Employee No.</label> 
<input type="text" name="<%=SERVICE_NO %>"	value="" MAXLENGTH="20" />
 





<%-- <label>Patient Name</label>
<input type="text" name="<%=P_FIRST_NAME %>" value=""MAXLENGTH="30" />
<label>Department Name</label>
<select id="departmentId" name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<% for(MasDepartment masDepartment : departmentList){%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%}%>
</select> --%>

<div class="Clear"></div>
</div>

</form>
<div class="Clear"></div>

<input type="button" name="submit" id="addbutton"
	onclick="check();"		
	value="Search" class="button" accesskey="a" />
	
	<!-- <input type="button" name="submit" id="addbutton"
	onclick="submitForm('patientSearch','/hms/hms/investigation?method=showPendingForResultValidationLabJsp&selectedAppId=A478');"		
	value="Show All" class="button" accesskey="a" /> -->
	


<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="pendingResultValidationLab" method="post" action="">
<script type="text/javascript">
	formFields = [
	[0, "<%=RESULT_ID%>", "id"],[1,"<%=SAMPLE_NO%>"],[2,"smpcDate"],[3,"time"], [4,"serNo"],[5,"dept"], [6,"hin"], [7,"patName"], [8,"age"], [9,"sex"],[10,"pType"],[11,"orderBy"],[12,"doct"],[13,"<%=RESULT_ID%>"],[14,"<%=DIAGNOSIS_NO%>"],[15,"<%=SUB_CHARGE%>"],[16,"priority"]];
	 statusTd = 15;
	</script></form>
</div>
<div class="Clear"></div>

<script type="text/javascript" language="javascript">
	
	data_header = new Array();

		
	data_header[0] = new Array;
	data_header[0][0] = "Sample No"
	data_header[0][1] = "hide";
	data_header[0][2] = "7%";
	data_header[0][3] = "<%=SAMPLE_NO%>";

	data_header[1] = new Array;
	data_header[1][0] = "Diag No."
	data_header[1][1] = "data";
	data_header[1][2] = "7%";
	data_header[1][3] = "smpcDate";
	
	data_header[2] = new Array;
	data_header[2][0] = "Result Date"
	data_header[2][1] = "data";
	data_header[2][2] = "7%";
	data_header[2][3] = "smpcDate";
	
    data_header[3] = new Array;
	data_header[3][0] = "Result Time"
	data_header[3][1] = "data";
	data_header[3][2] = "15%";
	data_header[3][3] = "time";

	data_header[4] = new Array;
	data_header[4][0] = "Patient Name"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "patName";

	data_header[5] = new Array;
	data_header[5][0] = "Hin No."
	data_header[5][1] = "hide";
	data_header[5][2] = "20%";
	data_header[5][3] = "hin";

	data_header[6] = new Array;
	data_header[6][0] = "Relation"
	data_header[6][1] = "data";
	data_header[6][2] = "20%";
	data_header[6][3] = "hin";
	
	data_header[7] = new Array;
	data_header[7][0] = "Employee No."
	data_header[7][1] = "data";
	data_header[7][2] = "15%";
	data_header[7][3] = "serNo";

	data_header[8] = new Array;
	data_header[8][0] = "Designation"
	data_header[8][1] = "hide";
	data_header[8][2] = "20%";
	data_header[8][3] = "hin";
	
	data_header[9] = new Array;
	data_header[9][0] = "Department Name"
	data_header[9][1] = "data";
	data_header[9][2] = "10%";
	data_header[9][3] = "dept";

	
	
	
	data_header[10] = new Array;
	data_header[10][0] = "Age"
	data_header[10][1] = "hide";
	data_header[10][2] = "10%";
	data_header[10][3] = "age";
		
	data_header[11] = new Array;
	data_header[11][0] = "Gender"
	data_header[11][1] = "hide";
	data_header[11][2] = "10%";
	data_header[11][3] = "sex";
	
	data_header[12] = new Array;
	data_header[12][0] = "P Type"
	data_header[12][1] = "hide";
	data_header[12][2] = "10%";
	data_header[12][3] = "pType";
	
	data_header[13] = new Array;
	data_header[13][0] = "Doctor Name"
	data_header[13][1] = "data";
	data_header[13][2] = "10%";
	data_header[13][3] = "orderBy";
	
	

	data_header[14] = new Array;
	data_header[14][0] = "Id"
	data_header[14][1] = "hide";
	data_header[14][2] = "10%";
	data_header[14][3] = "<%=RESULT_ID%>";

		
	data_header[15] = new Array;
	data_header[15][0] = "Modality"
	data_header[15][1] = "data";
	data_header[15][2] = "10%";
	data_header[15][3] = "<%=SUB_CHARGE%>";

	data_header[16] = new Array;
	data_header[16][0] = "priority"
	data_header[16][1] = "hide";
	data_header[16][2] = "10%";
	data_header[16][3] = "priority"
	
	data_arr = new Array();
	</script> <% // int  counter=0;%> <%
		int  counter=0;
		List<String> pendingValidationListLabAll = new ArrayList<String>();

		String stringOfSubDeptIds = "";
		String stringOfIds = "";

			if (patientList.size() > 0){ 
			  for(int i = 0; i<patientList.size(); i++){ 
					stringOfIds = stringOfIdsList.get(i);
					stringOfSubDeptIds = stringOfSubDeptIdsList.get(i);
					pendingValidationListLabAll.add(stringOfIds+"@"+stringOfSubDeptIds);
			  %> <jsp:include page="pendingResultValidationLabGrid.jsp"
	flush="true">
	<jsp:param name="counter" value="<%=counter%>" />
	<jsp:param name="resultEntryIndex" value="<%=(counter)%>" />
</jsp:include> <%	counter++;	}
			}
				%> <%

	if(session.getAttribute("pendingValidationListLabAll") != null){
		session.removeAttribute("pendingValidationListLabAll");
		session.setAttribute("pendingValidationListLabAll",pendingValidationListLabAll);
	}else{
		session.setAttribute("pendingValidationListLabAll",pendingValidationListLabAll);
	}
	%> <script type="text/javascript" language="javascript">
	
	formName = "pendingResultValidationLab";
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
	function searchKeyPress(e) {
		// look for window.event in case event isn't passed in
		e = e || window.event;
		 if (e.keyCode == 13) { 
			 
			 submitForm('patientSearch','/hms/hms/investigation?method=searchPatientForResultValidationLab');
			
			return false;
		 } 
		return true;
	}

	document.getElementById("barCodeOrderNo").focus();
	</script>
	
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript">

var $j = jQuery.noConflict();
</script>

<script type="text/javascript">
function check(){
		
		if(document.patientSearch.serviceNo.value =="" && document.patientSearch.barCodeOrderNo.value=="" )
		{
			alert("Please enter Employee No or Barcode No");
			return false;
		}
	else
		{
			submitForm('patientSearch','/hms/hms/investigation?method=searchPatientForResultValidationLab');	
		}
	}
</script>
	<div class="Clear"></div>
<input type="text" class="signPriority1" readonly="readonly">
<label class="valueAutoPriority">Priority-1</label>
<input type="text" class="signPriority2" readonly="readonly">
<label class="valueAutoPriority">Priority-2</label>
<input type="text" class="signPriority3" readonly="readonly">
<label class="valueAutoPriority">Priority-3</label>
<input type="text" class="signMorethen6HRS" readonly="readonly">
<label class="valueAutoPriority">More than 6 hrs</label>
<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : pendingResultValidation.jsp 
	 * Tables Used         : DgSampleCollectionHeader,DgSampleCollectionDetails,MasSample,Patient,MasSubChargecode
	 * Description         : 
	 * @author  Create Date: 21.07.2008    Name: Abha
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasSample"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder"><script type="text/javascript">
	function displayUnitDetails(id){
		
		submitProtoAjax('pendingResultValidationForFilmUpdate','/hms/hms/investigation?method=searchPatientForFilmValidation&resultId='+id)
	}
</script>


<form name="patientSearchForFilmSizeUpdate" action="" method="post">

<script type="text/javascript" language="javascript">
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
		int resultId = 0;
		if(map.get("resultId") != null)
		{
			resultId = (Integer)map.get("resultId");
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
		
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();
		
		if(map.get("resultList") != null)
		{
			resultList = (List<DgResultEntryHeader>)map.get("resultList");
		}

		if(resultList.size()>0){
			
			for(DgResultEntryHeader dgHeader:resultList ){
				dgDetailSet =dgHeader.getDgResultEntryDetails();
				
			}
			if(dgDetailSet.size()>0){

				Iterator  iterator = dgDetailSet.iterator();
				DgResultEntryDetail dgResultEntryDetail = (DgResultEntryDetail)iterator.next();

			}
		}

	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);
			
		<%}
	%>
	
	function submitPopUpForm(){

		//var filmSizeUsedInPopUp = document.getElementById("filmSizeUsedPopUp").value;
		//var filmUsedPopUp = document.getElementById("filmUsedPopUp").value;
		var result = checkFilmSize();
		if(result == false){
			return false;
		}else{
			var resultId = document.getElementById("resultIdPopUp").value;
			submitProtoAjax('pendingResultValidationForFilmUpdate','/hms/hms/investigation?method=updatePatientFilmSize&resultId='+resultId);
		}
	}
	function removeSingleRow()
	{
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  	if (lastRow > 2){ 
	  		tbl.deleteRow(lastRow - 1);
	  		var hdb = document.getElementById('hdb');
	  		hdb.value=lastRow - 2;
 
	  	}
	}
	function addRow(){
	
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow; 
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration
 	  
 	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('label');
	 
	   
	  cellRight0.appendChild(e0); 
 	
 	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('Select');
	 
	  e1.name='filmSizeUsed'+iteration;
	  e1.id='filmSizeUsedPopUp'+iteration;
	  //e0.classname='smalllabel'
	   e1.options[0] = new Option('Select', '');
	   e1.options[1] = new Option('17"*14"', '17X14');
	   e1.options[2] = new Option('15"*12"', '15X12');
	   e1.options[3] = new Option('12"*10"', '12X10');
	   e1.options[4] = new Option('10"*8"', '10X8');
	   e1.options[5] = new Option('USG', 'USG');
	   
	  cellRight1.appendChild(e1); 
 
 	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('Select');
	 
	  e2.name='filmUsed'+iteration;
	  e2.id='filmUsedPopUp'+iteration;
	  //e0.classname='smalllabel'
	   e2.options[0] = new Option('Select', '');
	   e2.options[1] = new Option('1', '1');
	   e2.options[2] = new Option('2', '2');
	   e2.options[3] = new Option('3', '3');
	   e2.options[4] = new Option('4', '4');
	   e2.options[5] = new Option('5', '5');
	   e2.options[6] = new Option('6', '6');
	   e2.options[7] = new Option('7', '7');
	   e2.options[8] = new Option('8', '8');
	   e2.options[9] = new Option('9', '9');
	   
	  cellRight2.appendChild(e2); 
	  	  
	}
	function checkFilmSize(){
		
		var noOfRows = document.getElementById('hdb').value;
		var i=1;
		for(;i<=noOfRows;i++){
			var filmSizeUsed = document.getElementById('filmSizeUsedPopUp'+i).value
			var filmUsed = document.getElementById('filmUsedPopUp'+i).value
			if(filmSizeUsed==''){
				alert('Film Size Used can not be blank');
				document.getElementById('filmSizeUsedPopUp'+i).focus();
				return false;
			}
			if(filmUsed==''){
				alert('Film Used can not be blank');
				document.getElementById('filmUsedPopUp'+i).focus();
				return false;
			}
		}
		return true;
		
	}
	
	</script>
<h6>Patient Film Entry</h6>

<div class="Clear"></div>
<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>


<label><span>*</span>From Date</label> <input type="text"
	class="calDate" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearchForFilmSizeUpdate.<%=FROM_DATE%>,event)" />

<label><span>*</span>To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"
	readonly="readonly" validate="To Date,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearchForFilmSizeUpdate.<%=TO_DATE%>,event)" />



<label>P Type</label> <select name="<%=PATIENT_TYPE%>"
	validate="P Type,string,no">
	<option value="">Select One</option>
	<option value="IP">IP</option>
	<option value="OP">OP</option>
</select> <label> Service No.</label> <input type="text" name="<%=SERVICE_NO %>"
	value="" MAXLENGTH="20" /> <label>Sub Department</label> <select
	id="subChargeCodeId" name="<%=SUB_CHARGECODE_ID %>">
	<option value="0">Select</option>
	<%
		for(MasSubChargecode subChargecode : subChargeCodeList){
		%>
	<option value="<%=subChargecode.getId() %>"
		<%=HMSUtil.isSelected(subChargecode.getId(),Integer.valueOf(box.getInt(SUB_CHARGECODE_ID)))%>><%=subChargecode.getSubChargecodeName() %></option>
	<%}%>
</select> <label>Order By</label> <select id="departmentId"
	name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
		for(MasDepartment masDepartment : departmentList){
		%>
	<option value="<%=masDepartment.getId() %>"
		<%=HMSUtil.isSelected(masDepartment.getId(),Integer.valueOf(box.getInt(DEPARTMENT_ID)))%>><%=masDepartment.getDepartmentName() %></option>
	<%}%>
</select>
<div class="Clear"></div>
<label>Ser. Per. Name</label> <input type="text"
	name="<%=S_FIRST_NAME %>" value="" MAXLENGTH="30" /> <label>Hin</label>
<input type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50" /> <label>Patient
Name</label> <input type="text" name="<%=P_FIRST_NAME %>" value=""
	MAXLENGTH="30" />
<div class="Clear"></div>
<label>A&D No.</label> <input type="text" name="<%=AD_NO %>" value=""
	MAXLENGTH="30" /></div>

</form>
<div class="Clear"></div>

<input type="button" name="submit" id="addbutton"
	onclick="submitForm('patientSearchForFilmSizeUpdate','/hms/hms/investigation?method=searchPatientForUpdateFilmSize','checkFromNTodata');"
	value="Search" class="cmnButton" accesskey="a" />


<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="pendingResultValidationForFilmUpdate" method="post"
	action=""><script type="text/javascript">
	formFields = [
	[0, "<%=RESULT_ID%>", "id"],[1,"<%=SAMPLE_NO%>"],[2,"smpcDate"],[3,"time"], [4,"serNo"],[5,"sPerName"], [6,"hin"], [7,"patName"], [8,"age"], [9,"sex"],[10,"pType"],[11,"orderBy"],[12,"doct"],[13,"<%=RESULT_ID%>"],[14,"<%=DIAGNOSIS_NO%>"],[15,"<%= RADIO_FOR_TABLE%>"],[16,"filmSizeUsed"],[17,"filmUsed"]];
	 statusTd = 17;
	</script>

<div id="testDiv"></div>

</form>
</div>

<div class="Clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Sample No"
	data_header[0][1] = "hide";
	data_header[0][2] = "7%";
	data_header[0][3] = "<%=SAMPLE_NO%>";
	
	data_header[1] = new Array;
	data_header[1][0] = "Result Date"
	data_header[1][1] = "data";
	data_header[1][2] = "7%";
	data_header[1][3] = "smpcDate";
	
    data_header[2] = new Array;
	data_header[2][0] = "Result Time"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "time";
	
	data_header[3] = new Array;
	data_header[3][0] = "Service no"
	data_header[3][1] = "data";
	data_header[3][2] = "15%";
	data_header[3][3] = "serNo";
	
	data_header[4] = new Array;
	data_header[4][0] = "S Person Name"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "sPerName";
	
	data_header[5] = new Array;
	data_header[5][0] = "Hin No"
	data_header[5][1] = "data";
	data_header[5][2] = "20%";
	data_header[5][3] = "hin";
	
	data_header[6] = new Array;
	data_header[6][0] = "Patient Name"
	data_header[6][1] = "data";
	data_header[6][2] = "10%";
	data_header[6][3] = "patName";
	
	data_header[7] = new Array;
	data_header[7][0] = "Age"
	data_header[7][1] = "data";
	data_header[7][2] = "10%";
	data_header[7][3] = "age";
		
	data_header[8] = new Array;
	data_header[8][0] = "Sex"
	data_header[8][1] = "data";
	data_header[8][2] = "10%";
	data_header[8][3] = "sex";
	
	data_header[9] = new Array;
	data_header[9][0] = "P Type"
	data_header[9][1] = "hide";
	data_header[9][2] = "10%";
	data_header[9][3] = "pType";
	
	data_header[10] = new Array;
	data_header[10][0] = "Order By"
	data_header[10][1] = "hide";
	data_header[10][2] = "10%";
	data_header[10][3] = "orderBy";
	
	data_header[11] = new Array;
	data_header[11][0] = "Doctor"
	data_header[11][1] = "data";
	data_header[11][2] = "14%";
	data_header[11][3] = "doct";
	
	data_header[12] = new Array;
	data_header[12][0] = "Id"
	data_header[12][1] = "hide";
	data_header[12][2] = "10%";
	data_header[12][3] = "<%=RESULT_ID%>";
	
	data_header[13] = new Array;
	<%if(deptType.equalsIgnoreCase("RADIO")){%>
	data_header[13][0] = "Radio Id."
	<%}else{%>
	data_header[13][0] = "Diag/No."
	<%}%>
	data_header[13][1] = "data";
	data_header[13][2] = "10%";
	data_header[13][3] = "<%=DIAGNOSIS_NO%>";
	
	data_header[14] = new Array;
	data_header[14][0] = "Se"
	data_header[14][1] = "hide";
	data_header[14][2] = "4%";
	data_header[14][3] = "<%= RADIO_FOR_TABLE%>"

	data_header[15] = new Array;
	data_header[15][0] = "Film Size Used"
	data_header[15][1] = "hide";
	data_header[15][2] = "4%";
	data_header[15][3] = "filmSizeUsed"

	data_header[16] = new Array;
	data_header[16][0] = "Film Used"
	data_header[16][1] = "hide";
	data_header[16][2] = "4%";
	data_header[16][3] = "filmUsed"

	
	data_arr = new Array();
	<%

	    int  counter=0; %>
	   
	   <%
	   
		if (patientList != null && patientList.size() > 0) { %>
	
	<% 	String DiagNo="";
	for(DgResultEntryHeader dgResultDetail : patientList){
		Patient patient = dgResultDetail.getPatient();
		Set<DgResultEntryDetail> sampleDet = new HashSet<DgResultEntryDetail>();
		sampleDet=	dgResultDetail.getDgResultEntryDetails();
		for(DgResultEntryDetail resultDetail :sampleDet){
			DiagNo = resultDetail.getSampleCollectionDetails().getDiagNo();
		}
		
		
	%>
		  		data_arr[<%= counter%>] = new Array();
		  		data_arr[<%= counter%>][0] = "<%=dgResultDetail.getId()%>"
				data_arr[<%= counter%>][1] = "<%=dgResultDetail.getResultNo()%>"
				data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(dgResultDetail.getResultDate())%>"
				data_arr[<%= counter%>][3] = "<%=dgResultDetail.getResultTime()%>"
				
				data_arr[<%= counter%>][4] = "<%=patient.getServiceNo()%>"
				<%try{
				if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
				
				String sMiddleName = "";
				String sLastName = "";
				if(patient.getSMiddleName() != null){
					sMiddleName = patient.getSMiddleName();
				}
				if(patient.getSLastName() != null){
					sLastName = patient.getSLastName();
				}
				String sName = patient.getSFirstName()+" "+sMiddleName+" "+sLastName;
				
				%>
				data_arr[<%= counter%>][5] = "<%=sName%>"
				<%}else{%>
				data_arr[<%= counter%>][5] = ""
				<%}%>
				data_arr[<%= counter%>][6] = "<%=patient.getHinNo()%> "
				<%
				if(patient.getPFirstName() != null  && !(patient.getPFirstName().equals(""))){
				
				String pMiddleName = "";
				String pLastName = "";
				if(patient.getPFirstName() != null){
					pMiddleName = patient.getPMiddleName();
				}
				if(patient.getPFirstName() != null){
					pLastName = patient.getPLastName();
				}
				String pName = patient.getPFirstName()+" "+pMiddleName+" "+pLastName;
				
				%>
				data_arr[<%= counter%>][7] = "<%=pName%>"
				<%}else{%>
				data_arr[<%= counter%>][7] = ""
				<%}%>
				<%if(dgResultDetail.getPatient() != null){%>
				data_arr[<%= counter%>][8] = "<%=dgResultDetail.getPatient().getAge()%> "
				<%}else{%>
				data_arr[<%= counter%>][8] = "-"
				<%}%>
				
				data_arr[<%= counter%>][9] = "<%=dgResultDetail.getPatient().getSex().getAdministrativeSexName()%> "
				
				<%if(dgResultDetail.getSampleCollectionHeader().getOrder()!= null){%>
				data_arr[<%= counter%>][10] = "<%=dgResultDetail.getSampleCollectionHeader().getOrder().getPatientType()%> "
				<%}else{%>
				data_arr[<%= counter%>][10] = "-"
				<%}%>
				<%if(dgResultDetail.getSampleCollectionHeader().getOrder()!= null){%>
				data_arr[<%= counter%>][11] = "<%=dgResultDetail.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%> "
				<%}else{%>
				data_arr[<%= counter%>][11] = "-"
				<%}%>
				<%if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy()!= null){
					String FirName="";String midName=""; String lastName="";
						if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName()!=null){
						FirName=dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName();
						}
						if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName()!=null){
							midName=dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName();
						}
						if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName()!=null){
							lastName=dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName();
						}
						String name =FirName+" "+midName+" "+lastName;
					
				%>
				data_arr[<%= counter%>][12] = "<%=name%>"
				<%}else{%>
				data_arr[<%= counter%>][12] = "-"
				<%}%>
				data_arr[<%= counter%>][13] = "<%=dgResultDetail.getId()%>"
				
				<%
				if(DiagNo != null){%>
				data_arr[<%= counter%>][14] = "<%=DiagNo%>"
				<%}else{%>
				data_arr[<%= counter%>][14] ="-"
				<%}%>
				data_arr[<%= counter%>][15] ='<input type="radio" id="unit" name="unit" value="<%= dgResultDetail.getId()%>"  onclick="displayUnitDetails(<%= dgResultDetail.getId()%>)" />'
				
				<% 
				     Set<DgResultEntryDetail> dgResultEntryDetailSet =dgResultDetail.getDgResultEntryDetails();
				String filmSizeUsed = "";	
				Integer filmUsed = 0;
				String filmSizeUsedToShow ="";
				if(dgResultEntryDetailSet.size()>0){
							DgResultEntryDetail dgResultEntryDetail = dgResultEntryDetailSet.iterator().next();
							if(dgResultEntryDetail.getFilmSize()!=null){
								filmSizeUsed = dgResultEntryDetail.getFilmSize();	
							}
							if(dgResultEntryDetail.getFilmUsed()!=null){
								filmUsed = dgResultEntryDetail.getFilmUsed();	
							}
						}
				
						
				%>
				<% if((!filmSizeUsed.equals(""))){ %>
						<%if(filmSizeUsed.equals("17X14")){%>
							data_arr[<%= counter%>][16] ="17\"*14\"";
						<%}else if(filmSizeUsed.equals("15X12")){%>
							data_arr[<%= counter%>][16] ="15\"*12\"";
						<%}else if(filmSizeUsed.equals("12X10")){%>
							data_arr[<%= counter%>][16] ="12\"*10\"";						
						<%}else if(filmSizeUsed.equals("10X8")){%>
							data_arr[<%= counter%>][16] ="10\"*8\"";						
						<%}else if(filmSizeUsed.equals("None")){%>
							data_arr[<%= counter%>][16] ="None";
						<%}else if(filmSizeUsed.equals("USG")){%>
							data_arr[<%= counter%>][16] ="USG";						
						<% }%>
				<%	}else{ %>	
					data_arr[<%= counter%>][16] ="----"
				<% }%>
				
				<% if(!filmSizeUsed.equals("")){ %>
				 
					data_arr[<%= counter%>][17] ="<%=filmUsed%>"
				
				<%	}else{ %>	
					data_arr[<%= counter%>][17] ="----"
				<% }%>
				
			<%	
				}catch(Exception e){
					e.printStackTrace();
				}
					     counter++;
		}
	}
	
		%>	
	
	<%
	session.setAttribute("patientList",patientList);
	%>
	formName = "pendingResultValidationForFilmUpdate"
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	</script></div>



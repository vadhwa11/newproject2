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
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder">
<style>
#contentHolder .divisionR {
	height: 8px;
	clear: both;
	border-top: 1px solid #000;
	margin-top: 8px;
}
</style>
<form name="patientSearch" action="" method="post"><script
	type="text/javascript" language="javascript">
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
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);
			
		<%}
	%>
	</script> <%if(deptId == 49){ %>
<h6>Pending For Report Validation</h6>
<%}else{ %>
<h6>Pending For Result Validation</h6>
<%} %>

<div class="Clear"></div>
<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<div class="blockTitle" style="font-size: 11px;">Test Conducted
During Period</div>
<div class="blockTitleCurve"></div>

<div class="Clear"></div>
<label>&nbsp;</label> <label><span>*</span>From Date</label> <input
	type="text" class="calDate" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

<label><span>*</span>To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"
	readonly="readonly" validate="To Date,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />

<div class="divisionR"></div>

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
</select>

<div class="Clear"></div>


<label>Order By</label> <select id="departmentId"
	name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
		for(MasDepartment masDepartment : departmentList){
		%>
	<option value="<%=masDepartment.getId() %>"
		<%=HMSUtil.isSelected(masDepartment.getId(),Integer.valueOf(box.getInt(DEPARTMENT_ID)))%>><%=masDepartment.getDepartmentName() %></option>
	<%}%>
</select> <label>Ser. Per. Name</label> <input type="text"
	name="<%=S_FIRST_NAME %>" value="" MAXLENGTH="30" /> <label>Hin</label>
<input type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50" />
<div class="Clear"></div>
<label>Patient Name</label> <input type="text" name="<%=P_FIRST_NAME %>"
	value="" MAXLENGTH="30" /> <label>A&D No.</label> <input type="text"
	name="<%=AD_NO %>" value="" MAXLENGTH="30" />
<div class="Clear"></div>
</div>

</form>
<div class="Clear"></div>

<input type="button" name="submit" id="addbutton"
	onclick="submitForm('patientSearch','/hms/hms/investigation?method=searchPatientForResultValidation','checkFromNTodata');"
	value="Search" class="cmnButton" accesskey="a" />

<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="pendingResultValidation" method="post" action=""><script
	type="text/javascript">
	formFields = [
	[0, "<%=RESULT_ID%>", "id"],[1,"<%=SAMPLE_NO%>"],[2,"smpcDate"],[3,"time"], [4,"serNo"],[5,"sPerName"], [6,"hin"], [7,"patName"], [8,"age"], [9,"sex"],[10,"pType"],[11,"orderBy"],[12,"doct"],[13,"<%=RESULT_ID%>"],[14,"<%=DIAGNOSIS_NO%>"]];
	 statusTd = 14;
	</script></form>
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
	data_header[5][1] = "hide";
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
	data_header[9][1] = "data";
	data_header[9][2] = "10%";
	data_header[9][3] = "pType";
	
	data_header[10] = new Array;
	data_header[10][0] = "Order By"
	data_header[10][1] = "data";
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
	
	data_arr = new Array();
	<%

	    int  counter=0;%>
	   
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
	formName = "pendingResultValidation";
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	</script></div>

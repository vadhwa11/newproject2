<%-- 
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* File Name           : pendingResultEntry.jsp 
* Tables Used         : DgOrderhd,DgSampleCollectionHeader,DgSampleCollectionDetails,MasSample,Patient,MasSubChargecode
* Description         : 
* @author  Create Date: 21.07.2008    Name: Abha
* Revision Date:      Revision By: 
* @version 1.0  

--%>

<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
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
</script> <%Box box = HMSUtil.getBox(request);
Map<String, Object> patientMap = new HashMap<String, Object>();
Map<String, Object> map = new HashMap<String, Object>();
List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
List<DgOrderhd>orderList = new ArrayList<DgOrderhd>();
List<MasSample>sampleList = new ArrayList<MasSample>();
List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
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
patientList= (List<DgSampleCollectionDetails>)patientMap.get("patientList");
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
List<DgSampleCollectionDetails> sampleDetailList = new ArrayList<DgSampleCollectionDetails>();
if(detailsMap.get("sampleDetailList") != null){
sampleDetailList = (List<DgSampleCollectionDetails>)detailsMap.get("sampleDetailList");
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
<h6>Pending For Report Entry</h6>
<%}else{ %>
<h6>Pending For Result Entry</h6>
<%} %>
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
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

<label><span>*</span>To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"
	readonly="readonly" validate="To Date,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />

<%if(deptType.equalsIgnoreCase("RADIO")){%> <label>Radio Id.</label> <%}else{ %>
<label>Diag. No.</label> <%} %> <input type="text"
	name="<%=DIAGNOSIS_NO %>" value="" MAXLENGTH="30" />
<div class="Clear"></div>

<label>P Type</label> <select name="<%=PATIENT_TYPE%>"
	validate="P Type,string,no">
	<option value="">Select One</option>
	<option value="IP">IP</option>
	<option value="OP">OP</option>
</select> <label> Service No.</label> <input type="text" name="<%=SERVICE_NO %>"
	value="" MAXLENGTH="20" /> <label>Patient Name</label> <input
	type="text" name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="30" />

<div class="Clear"></div>

<label>A&D No</label> <input type="text" name="<%=AD_NO %>" value=""
	MAXLENGTH="30" /> <label>Order By</label> <select id="departmentId"
	name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
for(MasDepartment masDepartment : departmentList){
%>
	<option value="<%=masDepartment.getId() %>"
		<%=HMSUtil.isSelected(masDepartment.getId(),Integer.valueOf(box.getInt(DEPARTMENT_ID)))%>><%=masDepartment.getDepartmentName() %></option>
	<%}%>
</select> <label>Sub Department</label> <select id="subChargeCodeId"
	name="<%=SUB_CHARGECODE_ID %>">
	<option value="0">Select</option>
	<%
for(MasSubChargecode subChargecode : subChargeCodeList){
%>
	<option value="<%=subChargecode.getId() %>"
		<%=HMSUtil.isSelected(subChargecode.getId(),Integer.valueOf(box.getInt(SUB_CHARGECODE_ID)))%>><%=subChargecode.getSubChargecodeName() %></option>
	<%}%>
</select>

<div class="Clear"></div>

<label>Ser. Per. Name</label> <input type="text"
	name="<%=S_FIRST_NAME %>" value="" MAXLENGTH="30" /> <label>Hin
No.</label> <input type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50" /></div>
</form>

<div class="Clear"></div>

<input type="button" name="submit" id="addbutton"
	onclick="submitForm('patientSearch','/hms/hms/investigation?method=searchPatient','checkFromNTodata');"
	value="Search" class="cmnButton" accesskey="a" />

<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="pendingResult" method="post" action=""><script
	type="text/javascript">
	formFields = [
		[0, "<%= SAMPLE_COLLECTION_DETAIL_ID%>", "id"],[1,"<%=SAMPLE_NO%>"],[2,"smpcDate"],[3,"time"], [4,"serNo"],[5,"sPerName"], [6,"hin"], [7,"patName"], [8,"age"], [9,"sex"],[10,"pType"],[11,"orderBy"],[12,"doct"],[13,"investigationId"],[14,"hinId"],[15,"sampleHeaderId"],[16,"<%=DIAGNOSIS_NO%>"]];
		statusTd = 16;
	</script></form>
</div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript" language="javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Sample No"
data_header[0][1] = "hide";
data_header[0][2] = "7%";
data_header[0][3] = "<%=SAMPLE_NO%>";

data_header[1] = new Array;
data_header[1][0] = "Order Date"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "smpcDate";

data_header[2] = new Array;
data_header[2][0] = "Order Time"
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
data_header[12][0] = "Investigation Name"
data_header[12][1] = "data";
data_header[12][2] = "10%";
data_header[12][3] = "investigationId";

data_header[13] = new Array;
data_header[13][0] = "hinId"
data_header[13][1] = "hide";
data_header[13][2] = "10%";
data_header[13][3] = "hinId";

data_header[14] = new Array;
data_header[14][0] = "SampleHeaderId"
data_header[14][1] = "hide";
data_header[14][2] = "10%";
data_header[14][3] = "sampleHeaderId";

data_header[15] = new Array;
<%if(deptType.equalsIgnoreCase("RADIO")){%>
data_header[15][0] = "Radio Id."
<%}else{%>
data_header[15][0] = "Diag/No."
<%}%>
data_header[15][1] = "data";
data_header[15][2] = "10%";
data_header[15][3] = "<%=DIAGNOSIS_NO%>";
data_arr = new Array();


<%
int  counter=0;%>

<% if (patientList != null && patientList.size() > 0) { 
%>
<% 	for(DgSampleCollectionDetails dgsampleDetails : patientList){

Patient patient =dgsampleDetails.getSampleCollectionHeader().getHin();
DgSampleCollectionHeader sampleHeader = dgsampleDetails.getSampleCollectionHeader();


%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=dgsampleDetails.getId()%>"
data_arr[<%= counter%>][1] = "<%=dgsampleDetails.getSampleNo()%>"
data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(dgsampleDetails.getSampleCollectionHeader().getOrder().getOrderDate())%>"
data_arr[<%= counter%>][3] = "<%=dgsampleDetails.getSampleCollectionHeader().getOrder().getOrderTime()%>"

data_arr[<%= counter%>][4] = "<%=patient.getServiceNo()%>"
<%
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
data_arr[<%= counter%>][5] = "-"
<%}%>
data_arr[<%= counter%>][6] = "<%=patient.getHinNo()%> "
<%
if(patient.getPFirstName() != null  && !(patient.getPFirstName().equals(""))){
	String pMiddleName = "";
	String pLastName = "";
	if(patient.getPMiddleName() != null){
		pMiddleName = patient.getPMiddleName();
	}
	if(patient.getPLastName() != null){
		pLastName = patient.getPLastName();
	}
	String pName = patient.getPFirstName()+" "+pMiddleName+" "+pLastName;
%>
data_arr[<%= counter%>][7] = "<%=pName%>"
<%}else{%>
data_arr[<%= counter%>][7] = "-"
<%}%>

<%if(dgsampleDetails.getSampleCollectionHeader().getHin() != null){%>
data_arr[<%= counter%>][8] = "<%=dgsampleDetails.getSampleCollectionHeader().getHin().getAge()%> "
<%}else{%>
data_arr[<%= counter%>][8] ="-"
<%}%>

<%if(dgsampleDetails.getSampleCollectionHeader().getHin() != null){%>
data_arr[<%= counter%>][9] = "<%=dgsampleDetails.getSampleCollectionHeader().getHin().getSex().getAdministrativeSexName()%> "
<%}else{%>
data_arr[<%= counter%>][9] = "-"
<%}%>

<%if(dgsampleDetails.getSampleCollectionHeader().getOrder() != null){%>
data_arr[<%= counter%>][10] = "<%=dgsampleDetails.getSampleCollectionHeader().getOrder().getPatientType()%> "
<%}else{%>
data_arr[<%= counter%>][10] ="-"
<%}%>

<%if(dgsampleDetails.getSampleCollectionHeader().getOrder().getDepartment() != null){%>
data_arr[<%= counter%>][11] = "<%=dgsampleDetails.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%> "
<%}else{%>
data_arr[<%= counter%>][11] = "-"
<%}%>

	<%if(dgsampleDetails.getSampleCollectionHeader().getOrder().getPrescribedBy()!= null){
					String FirName="";String midName=""; String lastName="";
						if(dgsampleDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName()!=null){
						FirName=dgsampleDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName();
						}
						if(dgsampleDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName()!=null){
							midName=dgsampleDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName();
						}
						if(dgsampleDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName()!=null){
							lastName=dgsampleDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName();
						}
						String name =FirName+" "+midName+" "+lastName;
					
				%>

			data_arr[<%= counter%>][12] = "<%=name%>"
				<%}else{%>
				data_arr[<%= counter%>][12] = "-"
				<%}%>

<%if (dgsampleDetails.getInvestigation() != null){%>
data_arr[<%= counter%>][13] = "<%=dgsampleDetails.getInvestigation().getInvestigationName()%> "
<%}else{%>
data_arr[<%= counter%>][13] = "-"
<%}%>


data_arr[<%= counter%>][14] = "<%=patient.getId()%> "


<%if (dgsampleDetails.getSampleCollectionHeader() != null){%>
data_arr[<%= counter%>][15] = "<%=dgsampleDetails.getSampleCollectionHeader().getId()%> "
<%}else{%>
data_arr[<%= counter%>][15] = "-"
<%}%>

<%if (dgsampleDetails.getDiagNo() != null){%>
data_arr[<%= counter%>][16] = "<%=dgsampleDetails.getDiagNo()%> "
<%}else{%>
data_arr[<%= counter%>][16] = "-"
<%}%>
<%	

counter++;
}
}

%>
<%
	session.setAttribute("patientList",patientList);
	%>
formName = "pendingResult"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}

makeTable(start,end);
</script></div>

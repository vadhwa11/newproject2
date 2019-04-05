<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Hospital Management System</title>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/report.css" />


</head>

<body>
<%Date d=new Date();
String hinNo="&nbsp;";
String serviceNo="&nbsp;";
String deptName="&nbsp;";
String patientName="&nbsp;";
String orderNo="&nbsp;";
String orderDate="&nbsp;";
String relationName="&nbsp;";
String patientAge="&nbsp;";
String sex="&nbsp;";
String resultDate="&nbsp;";
String rankName="&nbsp;";
String subChargeCodeName="&nbsp;";
String mainChargeCodeName="&nbsp;";
String charge="&nbsp;";
String doctorName="&nbsp;";
String entryPersonName="&nbsp;";
String verifiedPersonName="&nbsp;";
String servicePersonName="&nbsp;";
String orderByDepartment = "&nbsp;";
Date toDate = new Date();
Date fromDate = new Date();
String toDatePrint = "&nbsp;";
String fromDatePrint = "&nbsp;";
String patientType = "&nbsp;";
String remarks ="&nbsp;";

	List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap1 = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();

	List<String> subChargeList = new ArrayList<String>();
	List<String> testNameList = new ArrayList<String>();
	List<String> remarksList = new ArrayList<String>();
	List<String> confidentialList = new ArrayList<String>();
	List<String> subChargeCodeGroup = new ArrayList<String>();

	String message = "";
	String url = "";
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	
	}
	if (map.get("detailsMap1") != null) {
		detailsMap1 = (Map<String, Object>)map.get("detailsMap1");
		// System.out.println("in not null");
	}
	if(session.getAttribute("deptName")!=null){
		deptName=(String)session.getAttribute("deptName");
	}
	if (detailsMap1.get("subChargeList") != null) {
		subChargeList = (List)detailsMap1.get("subChargeList");
	}
	if (detailsMap1.get("testNameList") != null) {
		testNameList = (List)detailsMap1.get("testNameList");
	}
	if (detailsMap1.get("remarksList") != null) {
		remarksList = (List)detailsMap1.get("remarksList");
	}
	if (detailsMap1.get("confidentialList") != null) {
		confidentialList = (List)detailsMap1.get("confidentialList");
	}
	if (detailsMap1.get("subChargeCodeGroup") != null){
		subChargeCodeGroup = (List)detailsMap1.get("subChargeCodeGroup");
	}

	if (detailsMap1.get("hinNo") != null) {
		hinNo = (String)detailsMap1.get("hinNo");

	}
	if (detailsMap1.get("serviceNo") != null) {
		serviceNo = (String)detailsMap1.get("serviceNo");

	}
	if (detailsMap1.get("verifiedPersonName") != null) {
		verifiedPersonName = (String)detailsMap1.get("verifiedPersonName");

	}
	if (detailsMap1.get("orderByDepartment") != null) {
		orderByDepartment = (String)detailsMap1.get("orderByDepartment");

	}
	
	if (detailsMap1.get("entryPersonName") != null) {
		entryPersonName = (String)detailsMap1.get("entryPersonName");

	}
	
	if (detailsMap1.get("patientName") != null) {
		patientName = (String)detailsMap1.get("patientName");

	}
	if (detailsMap1.get("orderNo") != null) {
		orderNo = (String)detailsMap1.get("orderNo");

	}
	if (detailsMap1.get("orderDate") != null) {
		orderDate = HMSUtil.convertDateToStringWithoutTime((Date)detailsMap1.get("orderDate"));

	}
	if (detailsMap1.get("relationName") != null) {
		relationName = (String)detailsMap1.get("relationName");

	}
	if (detailsMap1.get("patientAge") != null) {
		patientAge = (String)detailsMap1.get("patientAge");

	}
	if (detailsMap1.get("sex") != null) {
		sex = (String)detailsMap1.get("sex");

	}
	if (detailsMap1.get("resultDate") != null) {
		resultDate = HMSUtil.convertDateToStringWithoutTime((Date)detailsMap1.get("resultDate"));

	}
	if (detailsMap1.get("rankName") != null) {
		rankName = (String)detailsMap1.get("rankName");

	}
	if (detailsMap1.get("subChargeCodeName") != null) {
		subChargeCodeName = (String)detailsMap1.get("subChargeCodeName");

	}
	if (detailsMap1.get("mainChargeCodeName") != null) {
		mainChargeCodeName = (String)detailsMap1.get("mainChargeCodeName");

	}
	if (detailsMap1.get("charge") != null) {
		charge = (String)detailsMap1.get("charge");

	}
	if (detailsMap1.get("doctorName") != null) {
		doctorName = (String)detailsMap1.get("doctorName");

	}
	if (detailsMap1.get("servicePersonName") != null) {
		servicePersonName = (String)detailsMap1.get("servicePersonName");

	}
	
	if (detailsMap1.get("patientType") != null) {
		patientType = (String)detailsMap1.get("patientType");
	}
	if (detailsMap1.get("remarks") != null) {
		remarks = (String)detailsMap1.get("remarks");
	}

	
	if (map.get("parameters") != null) {
		parameters = (Map<String, Object>) map.get("parameters");
	}
	if (parameters.get("fromDate") != null) {
		fromDate = (Date) parameters.get("fromDate");
		fromDatePrint = HMSUtil.convertDateToStringWithoutTime(fromDate);		
	}
	if (parameters.get("toDate") != null) {
		toDate = (Date) parameters.get("toDate");
		toDatePrint =  HMSUtil.convertDateToStringWithoutTime(toDate);
	}
	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	
	if (map.get("messageTOBeVisibleToTheUser") != null) {
		message = "" + map.get("messageTOBeVisibleToTheUser");
	}

	if (map.get("url") != null) {
		url = "" + map.get("url");
	}
	if (detailsMap1.get("dgResultdetailList") != null) {
		dgResultdetailList = (List<DgResultEntryDetail>) detailsMap1
				.get("dgResultdetailList");

	}

	String resultType = "";
	if (map.get("resultType") != null) {
		resultType = (String) map.get("resultType");
	}

	String hospitalName = "";
	if (detailsMap1.get("hospitalName") != null) {
		hospitalName = (String) detailsMap1.get("hospitalName");
	}

	String hospitalAddress = "";
	if (detailsMap1.get("hospitalAddress") != null) {
		hospitalAddress = (String) detailsMap1.get("hospitalAddress");
	}
	Box  box = HMSUtil.getBox(request);
%>
<h1><%=hospitalName %></h1>

<div class="Clear"></div>
<h3>
	Diagnostic Register  for the period ( <%=fromDatePrint%> - <%=toDatePrint%> )
</h3>
<div class="Clear"></div>
<%
	if(box.getString("resultType").equals("s")){
%>
<div class="grid">
<table width="100%" border="1" cellspacing="1" cellpadding="1">
	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">Diag.No.</th>
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Unit</th>
		<th scope="col">Age</th>
		<th scope="col">Gender</th>
		<th scope="col">Investigations</th>
		<th scope="col">Result</th>
		<th scope="col">UOM</th>
		<th scope="col">Normal Range</th>
		
	</tr>
<%
int index = 0; 
for(String subChargeName : subChargeCodeGroup){
	%>

<%

for(DgResultEntryDetail dgResultEntryDetail : dgResultdetailList){ 
	
	if(dgResultEntryDetail.getInvestigation().getSubChargecode().getSubChargecodeName()
			.equalsIgnoreCase(subChargeName)){


%>
<%
index++;
%>
<tr>
<td><%=index %></td>

<td><%=dgResultEntryDetail.getSampleCollectionDetails().getDiagNo()!=null?dgResultEntryDetail.getSampleCollectionDetails().getDiagNo():"" %></td>
<td><%=dgResultEntryDetail.getResultEntry().getPatient().getServiceNo()!=null?dgResultEntryDetail.getResultEntry().getPatient().getServiceNo():"" %></td>
<td><%=dgResultEntryDetail.getResultEntry().getPatient().getPFirstName()+" "+(dgResultEntryDetail.getResultEntry().getPatient().getPMiddleName()!=null?dgResultEntryDetail.getResultEntry().getPatient().getPMiddleName():"")+" "+(dgResultEntryDetail.getResultEntry().getPatient().getPLastName()!=null?dgResultEntryDetail.getResultEntry().getPatient().getPLastName():"") %></td>
<td><%=dgResultEntryDetail.getResultEntry().getPatient().getRelation().getRelationName() %></td>
<td><%=dgResultEntryDetail.getResultEntry().getPatient().getRank().getRankName() %></td>
<td><%=dgResultEntryDetail.getResultEntry().getPatient().getSFirstName() %></td>
<td><%=dgResultEntryDetail.getResultEntry().getPatient().getUnit().getUnitName() %></td>
<td><%=dgResultEntryDetail.getResultEntry().getPatient().getAge() %></td>
<td><%=dgResultEntryDetail.getResultEntry().getPatient().getSex().getAdministrativeSexName() %></td>
<td><%=dgResultEntryDetail.getInvestigation().getInvestigationName() %></td>
<% 
   	String confidential = "";
		if(dgResultEntryDetail.getInvestigation().getConfidential() != null 
				&& !dgResultEntryDetail.getInvestigation().getConfidential().equals("")
				&& !dgResultEntryDetail.getInvestigation().getConfidential().equalsIgnoreCase("n")){
			confidential = "y";
		}else{
			confidential = "n";
		}

%>

<td><% if(confidential.equalsIgnoreCase("n")){ %> <%=dgResultEntryDetail.getResult()%>
<% }else{ %>
This test's result is confidential<% } %></td>
<%if(dgResultEntryDetail.getInvestigation().getUom()!=null){ %>
<td><%=dgResultEntryDetail.getInvestigation().getUom().getUomName()%></td>
<%}else{ %>
<td>&nbsp;</td>
<%} %>
<%if(deptType.equalsIgnoreCase("DIAG")){
	DgSampleCollectionDetails dgCollection = dgResultEntryDetail.getSampleCollectionDetails();
	%>
		<td>
		<%if(dgCollection.getInvestigation().getNormalValue() != null || dgCollection.getInvestigation().getMinNormalValue() != null || dgCollection.getInvestigation().getMaxNormalValue() != null){ %>
		<%if(dgCollection.getInvestigation().getNormalValue() != null ){ 
				if(!dgCollection.getInvestigation().getNormalValue().equals("")){
					%> 
					<%=dgCollection.getInvestigation().getNormalValue()%>
			<%}else if (dgCollection.getInvestigation().getMinNormalValue()!= null && dgCollection.getInvestigation().getMaxNormalValue() != null){ %>
				<%=dgCollection.getInvestigation().getMinNormalValue()+" - "+dgCollection.getInvestigation().getMaxNormalValue()%>
			<%}
		} 
		else if(dgCollection.getInvestigation().getMinNormalValue()!= null && dgCollection.getInvestigation().getMaxNormalValue() != null){ %>
		<%=dgCollection.getInvestigation().getMinNormalValue()+" - "+dgCollection.getInvestigation().getMaxNormalValue()%>
		<%}}else{ %> 
		&nbsp;
		<%} %>
		</td>
		<%} %>

</tr>


<%		} 

	}
}
%>
</table>
</div>
<%}else if(box.getString("resultType").equals("t")){ %>
<%
int index = 1; 
for(String subChargeName : subChargeCodeGroup){
	
for(DgResultEntryDetail dgResultEntryDetail : dgResultdetailList){ 
	if(dgResultEntryDetail.getInvestigation().getSubChargecode().getSubChargecodeName()
			.equalsIgnoreCase(subChargeName)){


%>
<div class="Clear"></div>
<div class="grid">
<table width="100%" border="1" cellspacing="1" cellpadding="1">
	<tr>
		<th scope="col">Sl.No.</th>
		
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Unit</th>
		<th scope="col">Age</th>
		<th scope="col">Gender</th>
		<th scope="col">Test Name</th>
		
	</tr>
<tr>
<td><%=index %></td>
<td><%=dgResultEntryDetail.getSampleCollectionDetails().getDiagNo()!=null?dgResultEntryDetail.getSampleCollectionDetails().getDiagNo():"" %></td>

<td><%=dgResultEntryDetail.getResultEntry().getPatient().getPFirstName()+" "+(dgResultEntryDetail.getResultEntry().getPatient().getPMiddleName()!=null?dgResultEntryDetail.getResultEntry().getPatient().getPMiddleName():"")+" "+(dgResultEntryDetail.getResultEntry().getPatient().getPLastName()!=null?dgResultEntryDetail.getResultEntry().getPatient().getPLastName():"") %></td>
<td><%=dgResultEntryDetail.getResultEntry().getPatient().getRelation().getRelationName() %></td>
<td><%=dgResultEntryDetail.getResultEntry().getPatient().getRank().getRankName() %></td>
<td><%=dgResultEntryDetail.getResultEntry().getPatient().getSFirstName() %></td>
<td><%=dgResultEntryDetail.getResultEntry().getPatient().getUnit().getUnitName() %></td>
<td><%=dgResultEntryDetail.getResultEntry().getPatient().getAge() %></td>
<td><%=dgResultEntryDetail.getResultEntry().getPatient().getSex().getAdministrativeSexName() %></td>

<td><%=dgResultEntryDetail.getInvestigation().getInvestigationName() %></td>

</table>
</div>
<div class="Clear"></div>
<label>Result</label>
<label class="value"><%=dgResultEntryDetail.getResult()%></label>
<div class="Clear"></div>
<%index++;}
	}
	} %>
<%} %>
<div class="Clear"></div>
<div style='page-break-after: always;'></div>
<div class="Clear"></div>
<%if( dgResultdetailList.size() == 0){ %>
<label class="value">No Record Found</label>
<% }
%>

</body>
</html>
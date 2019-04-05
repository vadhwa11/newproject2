<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Hospital Management System</title>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/report.css" />
</head>


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

	
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap1 = new HashMap<String, Object>();
	List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();

	String message = "";
	String clinicalNotes = "";
	String url = "";
	String verifiedPersonNameDesignation = "&nbsp;";
	String entryPersonNameDesignation = "&nbsp;";
	String entryPersonNameRank = "&nbsp;";
	String verifiedPersonNameRank = "&nbsp;";
	String flagForConfidential = "";
	String empRank = "";

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	
	}
	if (map.get("detailsMap1") != null) {
		
		detailsMap1 = (Map<String, Object>)map.get("detailsMap1");
		System.out.println("in not null");
		
	}
	if(session.getAttribute("deptName")!=null){
		deptName=(String)session.getAttribute("deptName");
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
	if (detailsMap1.get("clinicalNote") != null) {
		clinicalNotes = (String)detailsMap1.get("clinicalNote");

	}
	if (detailsMap1.get("entryPersonNameDesignation") != null && !detailsMap1.get("entryPersonNameDesignation").equals("")) {
		entryPersonNameDesignation = (String)detailsMap1.get("entryPersonNameDesignation");
		
	}
	if (detailsMap1.get("entryPersonNameRank") != null && !detailsMap1.get("entryPersonNameRank").equals("")) {
		entryPersonNameRank = (String)detailsMap1.get("entryPersonNameRank");

	}

	if (detailsMap1.get("verifiedPersonNameDesignation") != null && !detailsMap1.get("verifiedPersonNameDesignation").equals("")) {
		verifiedPersonNameDesignation = (String)detailsMap1.get("verifiedPersonNameDesignation");

	}
	if (detailsMap1.get("verifiedPersonNameRank") != null && !detailsMap1.get("verifiedPersonNameRank").equals("")) {
		verifiedPersonNameRank = (String)detailsMap1.get("verifiedPersonNameRank");

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
	if (detailsMap1.get("empRank") != null) {
		empRank = (String)detailsMap1.get("empRank");

	}
	if (detailsMap1.get("doctorName") != null) {
		doctorName = (String)detailsMap1.get("doctorName");

	}
	if (detailsMap1.get("servicePersonName") != null) {
		servicePersonName = (String)detailsMap1.get("servicePersonName");

	}
	if (detailsMap1.get("dgResultEntryHeaderByOrderNo") != null) {
		dgResultEntryHeaderByOrderNo = (List)detailsMap1.get("dgResultEntryHeaderByOrderNo");

	}
	if (detailsMap1.get("flagForConfidential") != null) {
		flagForConfidential = (String)detailsMap1.get("flagForConfidential");

	}
	
	if (map.get("messageTOBeVisibleToTheUser") != null) {
		message = "" + map.get("messageTOBeVisibleToTheUser");
	}
	if (map.get("url") != null) {
		url = "" + map.get("url");
	}
	String hospitalName = "";
	if (detailsMap1.get("hospitalName") != null) {
		hospitalName = (String) detailsMap1.get("hospitalName");
	}
	String hospitalAddress = "";
	if (detailsMap1.get("hospitalAddress") != null) {
		hospitalAddress = (String) detailsMap1.get("hospitalAddress");
	}
%>
<body>
<%int testCounter = 1; %>
<%int subTestCounter = 0; %>


<!-- line should  behere -->
<h1><%=hospitalName %> </h1>
<div class="Clear"></div>
<h2><%=hospitalAddress %></h2>
<div class="Clear"></div>
<h3>Final Result </h3>
<div class="Clear"></div>
<fieldset id="dataDiv">
<label>Dept/Ward</label>
<label class="value"> <%=orderByDepartment%></label>
<label>Date</label>
<label class="value"> <%=orderDate %></label>
<label>Employee No.</label>
<label class="value"> <%=serviceNo %></label>

<div class="Clear"></div>
<label>Patient Name</label>
<label class="value"> <%=patientName %></label>
<label>Relation</label>
<label class="value"> <%=relationName %></label>
<label>Designation</label>
<label class="value"> <%=rankName %></label>
<div class="Clear"></div>
<label>Name</label>
<label class="value"> <%=servicePersonName %></label>

<label>Age/Gender</label>
<label class="value"> <%=patientAge%>/<%=sex %></label>

<label>Prescribed By</label>
<label class="value"> <%=doctorName %></label>
<div class="Clear"></div>

<label>Clinical Notes </label>
<label class="value"><%=clinicalNotes%></label>
</fieldset>
<div class="Clear"></div>
<h4>Sub Department : <%=subChargeCodeName%></h4> 
<div class="Clear"></div>
<%int resultEntryIndex = 0; %> <% 
 	for(DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderByOrderNo){
 		if(dgResultEntryHeader.getResultType() != null 
 				&& dgResultEntryHeader.getResultType().equalsIgnoreCase("S")){ 
 			DgResultEntryDetailSen dgDetail = dgResultEntryHeader.getDgResultEntryDetailSen().iterator().next();
 			if(flagForConfidential.equals("") 
 					&& dgDetail.getInvestigation().getConfidential() != null
 					&& dgDetail.getInvestigation().getConfidential().equals("y")){ %>
<div class="Clear"></div>
<span>This
Investigation Result is confidential </span>
<div class="Clear"></div>
<%}else{ %>
<ul><li><%=testCounter%>)</li>
<!--<li>Investigation: <%= dgDetail.getInvestigation().getInvestigationName()%></li>-->
<li> <%= dgDetail.getInvestigation().getInvestigationName()%></li>

</ul>

<jsp:include page="viewReportForSensitiveTestTypeOrderNoWise.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include> <%} %>
<div class="Clear"></div>

<%}else{ 
 		  DgResultEntryDetail dgDetail = dgResultEntryHeader.getDgResultEntryDetails().iterator().next();
 	   %>
<ul><li><%=testCounter%>)</li>
<!--<li>Investigation: <%= dgDetail.getInvestigation().getInvestigationName()%></li>-->
<li><%= dgDetail.getInvestigation().getInvestigationName()%></li>
</ul>
<%
 	       if(flagForConfidential.equals("") 
				   && dgDetail.getInvestigation().getConfidential() != null
 	    		   && dgDetail.getInvestigation().getConfidential().equals("y") ){ %>
<div class="Clear"></div>
<span>
This Investigation Result is confidential </span>
<div class="Clear"></div>
<%}else{ %> <%if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("s")){ %>
<jsp:include page="viewSingleResultReportLabOrderNoWise.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include> <%}else if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("m")){%>

<jsp:include page="viewMultipleTestReportOrderNoWise.jsp" flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include> <%}else if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("t")){%>
<label class="value" style="width: 820px;"><%=dgDetail.getResult()%></label>
<div class="Clear"></div>
<label>Remarks:</label> <% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<label class="value" ><%=dgDetail.getRemarks()%></label>
<% } else { %>
<label class="value">-</label> <% } %> <%} 
	 	   	  } %>
<div class="Clear"></div>
<%}
 		resultEntryIndex++;
 		testCounter++;
 	}
 	
 	%>

<div class="Clear"></div>
<div class="footer">
<label>Entered By:</label>
<label class="value"><%=entryPersonName%></label>
<label></label>
<label></label>
<label></label>
<label></label>
<label>Validated By:</label>

 <div class="Clear"></div>
<%-- <label class="value"><%=entryPersonNameRank%></label>
<label class="value"><%=verifiedPersonNameRank%></label> --%>
<div class="Clear"></div>
<%-- <label class="value"><%=entryPersonNameDesignation%></label>
<label class="value"><%=verifiedPersonNameDesignation%></label> --%>
<div class="Clear"></div>
<label>Date: </label>
<label class="value"><%=resultDate%> </label>
<label></label>
<label></label>
<label></label>
<label></label>
<label>Date: </label>
<label class="value"><%=resultDate%> </label>



 <!--  <label style="font-size:11px; color:#000;font-family:arial;	padding-left:350px;width:auto;padding-right:0px;margin-right: 0px;">Signature:</label> -->
<!--  <label class="value" style="width:120px;margin-left: 0px;padding-left: 0px;"> </label> -->
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<h6>----------End of the Report ----------</h6>

<div style='page-break-after: always;'></div>


</body>
</html>
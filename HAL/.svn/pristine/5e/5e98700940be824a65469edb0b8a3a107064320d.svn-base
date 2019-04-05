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
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />

<style>
#contentHolder1 {
	width: 100%;
	margin: 0px auto;
}

#contentHolder1 .blockFrame1 {
	width: 100%;
	margin: 0px auto;
}

#contentHolder1 .blockFrame1 label {
	width: 170px;
	float: left;
	text-align: left;
	height: auto;
	line-height: normal;
	padding-right: 5px;
	padding-left: 50px;
	font-weight: bold;
}

#contentHolder1 .blockFrame1 label.value {
	color: #000000;
	width: 180px;
	float: left;
	font-size: 11px;
	text-align: left;
	height: auto;
	font-weight: normal;
}

#contentHolder1 .divisionR1 {
	height: 8px;
	clear: both;
	border-top: 1px solid #000;
}

#contentHolder1 .Clear {
	clear: both;
	height: 1px;
	overflow: hidden;
}

#html,body {
	overflow: visible;
	text-align: left;
}
</style>

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


	List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();
	
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap1 = new HashMap<String, Object>();

	String message = "";
	String clinicalNotes = "";
	String url = "";
	String verifiedPersonNameDesignation = "&nbsp;";
	String entryPersonNameDesignation = "&nbsp;";
	String entryPersonNameRank = "&nbsp;";
	String verifiedPersonNameRank = "&nbsp;";
	String flagForConfidential = "";
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
	if (detailsMap1.get("entryPersonNameDesignation") != null) {
		entryPersonNameDesignation = (String)detailsMap1.get("entryPersonNameDesignation");

	}
	if (detailsMap1.get("entryPersonNameRank") != null) {
		entryPersonNameRank = (String)detailsMap1.get("entryPersonNameRank");

	}

	if (detailsMap1.get("verifiedPersonNameDesignation") != null) {
		verifiedPersonNameDesignation = (String)detailsMap1.get("verifiedPersonNameDesignation");

	}
	if (detailsMap1.get("verifiedPersonNameRank") != null) {
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
	if (detailsMap1.get("doctorName") != null) {
		doctorName = (String)detailsMap1.get("doctorName");

	}
	if (detailsMap1.get("dgResultEntryHeaderByOrderNo") != null) {
		dgResultEntryHeaderByOrderNo = (List)detailsMap1.get("dgResultEntryHeaderByOrderNo");

	}
	
	if (detailsMap1.get("servicePersonName") != null) {
		servicePersonName = (String)detailsMap1.get("servicePersonName");

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

	String resultType = "";
	if (map.get("resultType") != null) {
		resultType = (String) map.get("resultType");
	}

	System.out.println("resultType is------" + resultType);
%>
<body>
<%int testCounter = 1; %>

<%int subTestCounter = 0; %>

<%
	
	%>
<h1 align="center" class="style1"><!-- charge Code here --></h1>
<!-- line should  behere -->
<div id="contentHolder1"><label
	style="font: bold 13px arial color : #000; font-weight: bold; text-decoration: underline; float: right; text-align: center; font-size: 12px; width: 100%; margin-top: 0px;">COMMAND
HOSPITAL AIR FORCE</label>
<div class="Clear"></div>
<label
	style="font: bold 13px arial color : #000; font-weight: bold; text-decoration: underline; float: right; text-align: center; font-size: 12px; width: 100%; margin-top: 0px;">BANGALORE-560007</label>

<div class="Clear"></div>
<label
	style="font: bold 13px arial color : #000; width: 100%; font-weight: bold; text-align: center; font-size: 12px; float: right; margin-top: 1px">Provisional
Pathology Result </label> <br>
<div style="padding-top: 10px; margin-top: 0px;"></div>
<div id="dataDiv" class="blockFrame1"
	style="border: none; background: #FFF; height: auto;"><label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 159px; padding-right: 0px; margin-right: 0px;">Dept/Ward</label>
<label class="value"
	style="width: 249px; margin-left: 0px; padding-left: 0px;">: <%=orderByDepartment%>
</label> <label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 91px; padding-right: 0px; margin-right: 0px;">Test
Date</label> <label class="value"
	style="width: 120px; margin-left: 0px; padding-left: 0px;">: <%=orderDate %>
</label>
<div class="divisionR"></div>

<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 159px; padding-right: 0px; margin-right: 0px;">Service
No.</label> <label class="value"
	style="width: 180px; margin-left: 0px; padding-left: 0px;">: <%=serviceNo %>
</label> <label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 91px; width: 90px; padding-right: 0px; margin-right: 0px;">Rank</label>
<label class="value"
	style="width: auto; margin-left: 0px; padding-left: 0px;">: <%=rankName %>
</label>

<div class="Clear"></div>
<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 159px; padding-right: 0px; margin-right: 0px;">Service
Person Name</label> <label class="value"
	style="width: auto; margin-left: 0px; padding-left: 0px;">: <%=servicePersonName %>
</label>
<div class="Clear"></div>

<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 159px; padding-right: 0px; margin-right: 0px;">Patient
Name</label> <label class="value"
	style="width: 261px; margin-left: 0px; padding-left: 0px;">: <%=patientName %>
</label> <label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 10px; width: 90px; padding-right: 0px; margin-right: 0px;">Relation</label>
<label class="value"
	style="width: 120px; margin-left: 0px; padding-left: 0px;">: <%=relationName %>
</label>

<div class="Clear"></div>



<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 159px; padding-right: 0px; margin-right: 0px;">Age/Sex</label>
<label class="value"
	style="width: 120px; margin-left: 0px; padding-left: 0px;">: <%=patientAge%>/<%=sex %></label>
<div class="divisionR"></div>

<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 159px; padding-right: 0px; margin-right: 0px;">Prescribed
By</label> <label class="value"
	style="width: auto; margin-left: 0px; padding-left: 0px;">: <%=doctorName %></label>
<div class="Clear"></div>

<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 159px; padding-right: 0px;">
Clinical Notes </label> <label class="value"
	style="padding-right: 0px; margin-right: 0px; width: auto; padding-left: 0px;">:
<%=clinicalNotes%></label>

<div class="divisionR1"></div>
<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 220px; width: auto;">Sub
Department :</label> <label class="value"
	style="padding-right: 0px; margin-right: 0px; width: auto; padding-left: 0px;"><%=subChargeCodeName%></label>


<div class="divisionR1"></div>
<%int resultEntryIndex = 0; %> <% 
 	System.out.println("Size ----------"+dgResultEntryHeaderByOrderNo.size());
 	for(DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderByOrderNo){
 		if(dgResultEntryHeader.getResultType() != null 
 				&& dgResultEntryHeader.getResultType().equalsIgnoreCase("S")){ 
 			DgResultEntryDetailSen dgDetail = dgResultEntryHeader.getDgResultEntryDetailSen().iterator().next();
 			if(flagForConfidential.equals("") && dgDetail.getInvestigation().getConfidential() != null
 					&& dgDetail.getInvestigation().getConfidential().equals("y")){ %>
<div class="Clear"></div>
<label class="value" style="padding-left: 40px; margin-left: 0px;">This
Test Result is confidential </label>
<div class="Clear"></div>
<%}else{ %> <label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; padding-right: 0px; margin-right: 0px; width: 16px;"><%=testCounter%>)</label>
<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 0px; width: auto;">Test
: </label> <label class="value" style="padding-left: 0px; margin-left: 0px;"><%= dgDetail.getInvestigation().getInvestigationName()%></label>

<jsp:include page="viewReportForSensitiveTestTypeOrderNoWise.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include> <%} %>
<div class="Clear"></div>

<%}else{ 
 		  DgResultEntryDetail dgDetail = dgResultEntryHeader.getDgResultEntryDetails().iterator().next();
 	   %> <label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; padding-right: 0px; margin-right: 0px; width: 16px;"><%=testCounter%>)</label>
<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 0px; width: auto;">Test
: </label> <label class="value" style="padding-left: 0px; margin-left: 0px;"><%= dgDetail.getInvestigation().getInvestigationName()%></label>
<%
 	       if(flagForConfidential.equals("") && dgDetail.getInvestigation().getConfidential() != null
 	    		   && dgDetail.getInvestigation().getConfidential().equals("y") ){ %>
<div class="Clear"></div>
<label class="value" style="padding-left: 40px; margin-left: 0px;">
This Test Result is confidential </label>
<div class="Clear"></div>
<%}else{ %> <%if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("s")){ %>
<jsp:include page="viewSingleResultReportLabOrderNoWise.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include> <%}else if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("m")){%>

<jsp:include page="viewMultipleTestReportOrderNoWise.jsp" flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include> <%}else if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("t")){%>
<label class="value"><%=dgDetail.getResult()%></label> <%} 
	 	   	  } %>
<div class="Clear"></div>
<%}
 		resultEntryIndex++;
 		testCounter++;
 	}
 	
 	%> <label class="value"
	style="width: 220px; margin-left: 0px; padding-left: 20px; padding-top: 30px;">(<%=entryPersonName%>)
</label>

<div class="Clear"></div>
<label class="value"
	style="width: 220px; margin-left: 0px; padding-left: 20px; padding-top: 0px;"><%=entryPersonNameRank%>
</label>

<div class="Clear"></div>
<label class="value"
	style="width: 220px; margin-left: 0px; padding-left: 20px; padding-top: 0px;"><%=entryPersonNameDesignation%>
</label>

<div class="Clear"></div>

<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 103px; padding-right: 0px; margin-right: 0px; padding-top: 0px;">Date</label>
<label class="value"
	style="width: 120px; margin-left: 0px; padding-left: 0px; padding-top: 0px;">:
<%=resultDate%> </label> <!--  <label style="font-size:11px; color:#000;font-family:arial;	padding-left:350px;width:auto;padding-right:0px;margin-right: 0px;">Signature:</label> -->
<!--  <label class="value" style="width:120px;margin-left: 0px;padding-left: 0px;"> </label> -->
<div class="Clear"></div>


</div>

</div>
<label
	style="font: bold 13px arial color : #000; font-weight: bold; float: right; text-align: center; font-size: 11px; width: 100%; height: 0px; margin-top: 0px;">----------
End Of The Report ----------</label>

<div style='page-break-after: always;'></div>


</body>
</html>
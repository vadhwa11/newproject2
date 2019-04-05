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

<%
// Set File type
response.setContentType("application/msword");
//set header name
response.setHeader("Content-Disposition","attachment; filename=DocumentName" + ".doc");
%>


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
	List<String> subChargeCodeGroup = new ArrayList<String>();

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
	if (detailsMap1.get("subChargeCodeGroup") != null){
		subChargeCodeGroup = (List)detailsMap1.get("subChargeCodeGroup");
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
	if (detailsMap1.get("entryPersonNameDesignation") != null 
			&& !detailsMap1.get("entryPersonNameDesignation").equals("")) {
		entryPersonNameDesignation = (String)detailsMap1.get("entryPersonNameDesignation");

	}
	if (detailsMap1.get("entryPersonNameRank") != null
			&& !detailsMap1.get("entryPersonNameRank").equals("")) {
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
%>


<body>
<%if(dgResultEntryHeaderByOrderNo!=null && dgResultEntryHeaderByOrderNo.size()>0 &&
		subChargeCodeGroup!=null && subChargeCodeGroup.size()>0){
%>
<h1 style="
font-family:arial;
font-size:17pt;
font-weight:bold;
line-height:none;
color : #000;
text-decoration: underline;
float: right;
text-align: center;
width: 100%;
margin: 0px;
padding: 0px;">

<%=hospitalName %>
    
    </h1>
    
<h2 style="
font-family:arial;
font-size:13pt;
font-weight:bold;
line-height:none;
color : #000;
text-decoration: underline;
float: right;
text-align: center;
width: 100%;
margin: 0px;
padding: 0px;">
    
    <%=hospitalAddress %>
    
    </h2>
    
 <hr />
 <h4 style="
font-family:arial;
font-size:13pt;
font-weight:bold;
line-height:none;
color : #000;
text-decoration: underline;
float: right;
text-align: center;
width: 100%;
margin: 0px;
padding: 0px;">
    
    Final Laboratory Result
    
    </h4>
    
 <hr />
<%int testCounter = 1; %>
<%int noOfSubTest = subChargeCodeGroup.size(); %>
<%int subTestCounter = 0; %>

<table cellpadding="0" cellspacing="0" width="100%" >
<tr>
<td width="16%" align="left" style="font-family:arial;
font-size:11pt;
font-weight:bold;
line-height:none;
color: #000000;"> Dept/Ward       : </td>

<td width="16%" align="left"
style="font-family:arial;
font-size:11pt;
font-weight:normal;
line-height:none;
color: #000000;"><%=orderByDepartment %></td>

<td width="16%" align="left" style="font-family:arial;
font-size:11pt;
font-weight:bold;
line-height:none;
color: #000000;"> Result Date      : </td>

<td width="16%" align="left"
style="font-family:arial;
font-size:11pt;
font-weight:normal;
line-height:none;
color: #000000;"><%=orderDate %></td>

<td width="16%" align="left" style="font-family:arial;
font-size:11pt;
font-weight:bold;
line-height:none;
color: #000000;">Employee No.       : </td>

<td width="16%" align="left"
style="font-family:arial;
font-size:11pt;
font-weight:normal;
line-height:none;
color: #000000;"> <%=serviceNo %></td>

</tr>
<tr>
<td width="16%" align="left" style="font-family:arial;
font-size:11pt;
font-weight:bold;
line-height:none;
color: #000000;"> Patient Name     :</td>

<td width="20%" align="left"
style="font-family:arial;
font-size:11pt;
font-weight:normal;
line-height:none;
color: #000000;"> <%=patientName %></td>

<td width="16%" align="left" style="font-family:arial;
font-size:11pt;
font-weight:bold;
line-height:none;
color: #000000;"> Relation         : </td>

<td width="16%" align="left"
style="font-family:arial;
font-size:11pt;
font-weight:normal;
line-height:none;
color: #000000;"><%=relationName %></td>

<td width="16%" align="left" style="font-family:arial;
font-size:11pt;
font-weight:bold;
line-height:none;
color: #000000;">Designation              :</td>

<td width="20%" align="left"
style="font-family:arial;
font-size:11pt;
font-weight:normal;
line-height:none;
color: #000000;"><%=rankName %> </td>
</tr>

<tr>
<td width="16%" align="left" style="font-family:arial;
font-size:11pt;
font-weight:bold;
line-height:none;
color: #000000;">Name:</td>

<td width="20%" align="left"
style="font-family:arial;
font-size:11pt;
font-weight:normal;
line-height:none;
color: #000000;"><%=servicePersonName %> </td>

<td width="16%" align="left" style="font-family:arial;
font-size:11pt;
font-weight:bold;
line-height:none;
color: #000000;">Age/Gender       :</td>

<td width="16%" align="left"
style="font-family:arial;
font-size:11pt;
font-weight:normal;
line-height:none;
color: #000000;"><%=patientAge%>/<%=sex %></td>

<td width="16%" align="left" style="font-family:arial;
font-size:11pt;
font-weight:bold;
line-height:none;
color: #000000;">Prescribed By      :</td>

<td width="20%" align="left"
style="font-family:arial;
font-size:11pt;
font-weight:normal;
line-height:none;
color: #000000;"><%=doctorName %></td>

</tr>
<tr>

<td width="16%" align="left" style="font-family:arial;
font-size:11pt;
font-weight:bold;
line-height:none;
color: #000000;">Clinical Notes      :</td>

<td width="25%" align="left"
style="font-family:arial;
font-size:11pt;
font-weight:normal;
line-height:none;
color: #000000;"><%=clinicalNotes%></td>
</tr>
</table>
 <%for(String subChargeName : subChargeCodeGroup){ 

	%>
 </br>
 <hr />
 <h4 style="
font-family:arial;
font-size:11pt;
font-weight:bold;
line-height:none;
color : #000;
text-decoration: underline;
float: right;
text-align: center;
width: 100%;
margin: 0px;
padding: 0px;">
    
   <%=subChargeName %> 
    
    </h4>
<hr/>


<!-- Loop for Printing DgResultEntryHeader For Lab  Only For Multiple-->
<%int resultEntryIndex = 0; %> <% 
 	for(DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderByOrderNo){
 		if(dgResultEntryHeader.getResultType() != null 	&& dgResultEntryHeader.getResultType().equalsIgnoreCase("S")){
 			if(dgResultEntryHeader.getSubChargecode().getSubChargecodeName().equalsIgnoreCase(subChargeName)){ 
 			
 			DgResultEntryDetailSen dgDetail = dgResultEntryHeader.getDgResultEntryDetailSen().iterator().next();
 			if(flagForConfidential.equals("") && dgDetail.getInvestigation().getConfidential() != null
  	    		   && dgDetail.getInvestigation().getConfidential().equals("y") ){ %>
<div class="Clear"></div>
<span >
This Test Result is confidential </span>
<div class="Clear"></div>

<%}else{ %>
<ul><li><%=testCounter%>)</li>
<li>Test: <%= dgDetail.getInvestigation().getInvestigationName()%></li>
</ul>
<div class="Clear"></div>
<jsp:include page="viewReportForSensitiveTestTypeOrderNoWise.jsp"	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include>
<div class="Clear"></div>
<%}
 			 testCounter++;
 			
 			}
 		%> <%}else{ 
 		  DgResultEntryDetail dgDetail = dgResultEntryHeader.getDgResultEntryDetails().iterator().next();
 		   if(dgResultEntryHeader.getSubChargecode().getSubChargecodeName().equalsIgnoreCase(subChargeName)){
 	   %>
<div class="Clear"></div>
<ul><li><%=testCounter%>)</li>
<li>Test:  <%= dgDetail.getInvestigation().getInvestigationName()%></li>
</ul>
<%
	       if(flagForConfidential.equals("") && dgDetail.getInvestigation().getConfidential() != null
	    		   && dgDetail.getInvestigation().getConfidential().equals("y") ){ %>
<div class="Clear"></div>
<span>
This Test Result is confidential </span>
<div class="Clear"></div>
<%}else{ %> <%if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("s")){ %>
<div class="Clear"></div>
<jsp:include page="viewSingleResultReportLabOrderNoWise.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include>
<div class="Clear"></div>

<%}else if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("m")){%>

<jsp:include page="viewMultipleTestReportOrderNoWise.jsp" flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include>
<div class="Clear"></div>

<%}else if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("t")){%>
<!--  <label> Result</label>
<div class="Clear"></div>
<label>&nbsp;</label>-->
<label class="value"><%=dgDetail.getResult()%></label>
<div class="Clear"></div>
<label>Remarks:</label> <% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<label class="value" ><%=dgDetail.getRemarks()%></label><div class="Clear"></div>
<% } else { %> <label class="value">-</label> <% } %>
<div class="Clear"></div>
<%}
	       }
 	  		testCounter++;
 		  }
 		}
 		resultEntryIndex++;
 		
 	}
 	
 	%>

<!--  <label style="font-size:11px; color:#000;font-family:arial;	padding-left:350px;width:auto;padding-right:0px;margin-right: 0px;">Signature:</label> -->
<!--  <label class="value" style="width:120px;margin-left: 0px;padding-left: 0px;"> </label> -->
<div class="Clear"></div>


<% subTestCounter++; %>
<% if(subTestCounter == noOfSubTest){ %>
<h6>----------End Of The Report ----------</h6>
<% } %>
<% 
 testCounter = 1;
}
%>
<div class="Clear"></div>
<table cellpadding="0" cellspacing="0" width="70%" style="position:absolute: bottom:0;" >
<tr>
<td width="25%" style="font-family:arial;
font-size:10pt;
font-weight:bold;
line-height:none;
color: #000000;" >Report Prepared By :</td>

<td width="25%" style="font-family:arial;
font-size:10pt;
font-weight:bold;
line-height:none;
color: #000000;" ><%=entryPersonName%></td>

<td width="25%" style="font-family:arial;
font-size:10pt;
font-weight:bold;
line-height:none;
color: #000000;" ><%=entryPersonNameRank%></td>
</tr>
<tr>
<td width="25%" style="font-family:arial;
font-size:10pt;
font-weight:bold;
line-height:none;
color: #000000;" >Report Verified By :</td>
<td width="25%" style="font-family:arial;
font-size:10pt;
font-weight:bold;
line-height:none;
color: #000000;" ><%=verifiedPersonName%> </td>

<td width="25%" style="font-family:arial;
font-size:10pt;
font-weight:bold;
line-height:none;
color: #000000;" ><%=verifiedPersonNameRank%></td>

</tr>
</table>
<hr/><!--

 <div class="footer">	


 	<label class="value"><%=entryPersonName%>
</label> <label class="value"><%=verifiedPersonName%>
</label>

<div class="Clear"></div>
<label class="value"><%=entryPersonNameRank%>
</label> <label class="value"><%=verifiedPersonNameRank%>
</label>

<div class="Clear"></div>
<label class="value"><%=entryPersonNameDesignation%>
</label> <label class="value"><%=verifiedPersonNameDesignation%></label>
<div class="Clear"></div>
<label>Date: </label>
<label class="value"><%=resultDate%> </label>

<div class="Clear"></div>


</div>
-->
<%}else{ %>
<h1 style="
font-family:arial;
font-size:17pt;
font-weight:bold;
line-height:none;
color : #000;
text-decoration: underline;
float: right;
text-align: center;
width: 100%;
margin: 0px;
padding: 0px;">

----No Report Data Found----
    
    </h1>
<%} %></body>
</html>
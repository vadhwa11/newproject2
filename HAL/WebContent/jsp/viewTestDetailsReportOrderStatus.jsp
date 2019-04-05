<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : orderStatusForWardManagment.jsp 
	 * Tables Used         : 
	 * Description         : For Viewing All Order No For IPD .
	 * @author Name        : Naresh Kumar
	 * Revision Date	   : Revision By: 
	 * @version 1.0  
--%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="java.util.HashMap"%>

<html xmlns="http://www.w3.org/1999/xhtml">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Hospital Management System</title>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/phaseII.css" />
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

#contentHolder1 .divisionR {
	height: 1px;
	clear: both;
	border-top: 1px solid #000;
	margin-top: 2px;
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
	</script>
<script type="text/javascript">
	
	
	</script>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> orderDetailMap = new HashMap<String,Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();

		List<DgOrderdt> orderdtList = new ArrayList<DgOrderdt>();
		List<DgMasInvestigation> dgMasInvestigationList = new ArrayList<DgMasInvestigation>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsLabList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailLabList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryHeader> dgResultEntryHeaderLabList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> dgResultEntryHeaderSensitiveLabList = new ArrayList<DgResultEntryHeader>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String,Object>>();
		
		List<String> scdRadioInvestigationList = new ArrayList<String>();
		List<String> subChargeCodeGroup = new ArrayList<String>();
		
		DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
		DgOrderdt dgOrderdt = new DgOrderdt();
		
		String userName = "";
		String hinNo="&nbsp;";
		String serviceNo="&nbsp;";
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
		String unitNameAndAddress = "&nbsp;";
		String recordOfficeAddress = "&nbsp;";
		String clinicalNotes= "&nbsp;";
		Boolean doPageBreak = false;
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		}

		int deptId=0;
		if(session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		String deptName="";
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		if(session.getAttribute("userName") != null){
			 userName = (String)session.getAttribute("userName");
		}
		
		if (map.get("orderDetailMap") != null){
			orderDetailMap =(Map)map.get("orderDetailMap");
		}
		if (map.get("resultDetailsMapList") != null){
			resultDetailsMapList =(List)map.get("resultDetailsMapList");
		}
		if (orderDetailMap.get("dgOrderdtList") != null){
			orderdtList =(List)orderDetailMap.get("dgOrderdtList");
		}
		if (orderDetailMap.get("dgMasInvestigationList") != null){
			dgMasInvestigationList = (List)orderDetailMap.get("dgMasInvestigationList");
		}
		if (orderDetailMap.get("dgSampleCollectionDetailsList") != null){
			dgSampleCollectionDetailsList = (List)orderDetailMap.get("dgSampleCollectionDetailsList");
		}
		if (orderDetailMap.get("scdRadioInvestigationList") != null){
			scdRadioInvestigationList = (List)orderDetailMap.get("scdRadioInvestigationList");
		}
		
		if (orderDetailMap.get("dgResultEntryDetailList") != null){
			dgResultEntryDetailList = (List)orderDetailMap.get("dgResultEntryDetailList");
		}
		if (orderDetailMap.get("dgSampleCollectionDetailsLabList") != null){
			dgSampleCollectionDetailsLabList = (List)orderDetailMap.get("dgSampleCollectionDetailsLabList");
		}
		if (orderDetailMap.get("dgResultEntryDetailLabList") != null){
			dgResultEntryDetailLabList = (List)orderDetailMap.get("dgResultEntryDetailLabList");
		}
		if (orderDetailMap.get("dgResultEntryHeaderLabList") != null){
			dgResultEntryHeaderLabList = (List)orderDetailMap.get("dgResultEntryHeaderLabList");
		}
		if (orderDetailMap.get("dgResultEntryHeaderSensitiveLabList") != null){
			dgResultEntryHeaderSensitiveLabList = (List)orderDetailMap.get("dgResultEntryHeaderSensitiveLabList");
		}
		if (orderDetailMap.get("subChargeCodeGroup") != null){
			subChargeCodeGroup = (List)orderDetailMap.get("subChargeCodeGroup");
		}
/////////////////////////////////////////////////
	if (orderDetailMap.get("hinNo") != null) {
		hinNo = (String)orderDetailMap.get("hinNo");
	}
	if (orderDetailMap.get("serviceNo") != null) {
		serviceNo = (String)orderDetailMap.get("serviceNo");
	}
	if (orderDetailMap.get("orderByDepartment") != null) {
		orderByDepartment = (String)orderDetailMap.get("orderByDepartment");
	}
	if (orderDetailMap.get("patientName") != null) {
		patientName = (String)orderDetailMap.get("patientName");
	}
	if (orderDetailMap.get("orderNo") != null) {
		orderNo = (String)orderDetailMap.get("orderNo");
	}
	if (orderDetailMap.get("orderDate") != null) {
		orderDate = HMSUtil.convertDateToStringWithoutTime((Date)orderDetailMap.get("orderDate"));
	}
	if (orderDetailMap.get("relationName") != null) {
		relationName = (String)orderDetailMap.get("relationName");
	}
	if (orderDetailMap.get("patientAge") != null) {
		patientAge = (String)orderDetailMap.get("patientAge");
	}
	if (orderDetailMap.get("sex") != null) {
		sex = (String)orderDetailMap.get("sex");
	}
	if (orderDetailMap.get("rankName") != null) {
		rankName = (String)orderDetailMap.get("rankName");
	}
	if (orderDetailMap.get("subChargeCodeName") != null) {
		subChargeCodeName = (String)orderDetailMap.get("subChargeCodeName");
	}
	if (orderDetailMap.get("mainChargeCodeName") != null) {
		mainChargeCodeName = (String)orderDetailMap.get("mainChargeCodeName");
	}
	if (orderDetailMap.get("charge") != null) {
		charge = (String)orderDetailMap.get("charge");
	}
	if (orderDetailMap.get("servicePersonName") != null) {
		servicePersonName = (String)orderDetailMap.get("servicePersonName");
	}
	if (orderDetailMap.get("unitNameAndAddress") != null) {
		unitNameAndAddress = (String)orderDetailMap.get("unitNameAndAddress");
	}
	if (orderDetailMap.get("recordOfficeAddress") != null) {
		recordOfficeAddress = (String)orderDetailMap.get("recordOfficeAddress");
	}
	if (orderDetailMap.get("clinicalNotes") != null) {
		clinicalNotes = (String)orderDetailMap.get("clinicalNotes");
	}

/////////////////////////////////////////////////
		
		String deptType ="";
		Integer totalSize = 0;
		Integer initHieght = 60;
		
		if(session.getAttribute("deptType") != null){
			deptType = (String)session.getAttribute("deptType");
		}
		if(orderdtList!=null ){
			totalSize = totalSize + orderdtList.size();
		}
		if(dgSampleCollectionDetailsList != null ){
			totalSize = totalSize + dgSampleCollectionDetailsList.size();
		}
		if(dgResultEntryDetailList != null){
			totalSize = totalSize + dgResultEntryDetailList.size();
		}
		if(dgSampleCollectionDetailsLabList.size()>0){
			totalSize = totalSize + dgSampleCollectionDetailsLabList.size();
		}
		if(dgResultEntryDetailLabList != null){
			totalSize = totalSize + dgResultEntryDetailLabList.size();
		}
		if(dgResultEntryHeaderLabList != null){
			totalSize = totalSize + dgResultEntryHeaderLabList.size();
		}
		if(dgResultEntryHeaderSensitiveLabList != null){
			totalSize = totalSize + dgResultEntryHeaderSensitiveLabList.size();
		}
		
		for(int i=1 ;i<=totalSize-1 ;i++){
			initHieght = initHieght + 20;
		}
		
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");

	%>
<body>
<%int testCounter = 1; %>
<%int divCounter = 1; %>
<%int noOfSubTest = subChargeCodeGroup.size(); %>
<%for(String subChargeName : subChargeCodeGroup){
	System.out.println("sub Depart hghgh fghj:"+subChargeName);
	%>
<div id="contentHolder1"><label
	style="font: bold 13px arial color : #000; font-weight: bold; text-decoration: underline; float: right; text-align: center; font-size: 12px; width: 100%; margin-top: 10px;">COMMAND
HOSPITAL AIR FORCE</label>
<div class="Clear"></div>
<label
	style="font: bold 13px arial color : #000; font-weight: bold; text-decoration: underline; float: right; text-align: center; font-size: 12px; width: 100%; margin-top: 0px;">BANGALORE-560007</label>

<div class="Clear"></div>
<label
	style="font: bold 13px arial color : #000; width: 100%; font-weight: bold; text-align: center; font-size: 12px; float: right; margin-top: 1px">Order
Status Report</label>

<div class="Clear"></div>

<div id="dataDiv<%=divCounter%>" class="blockFrame1"
	style="border: none; background: #FFF; height: auto;"><label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 159px; padding-right: 0px;">
Hin No </label> <label class="value" style="padding-left: 0px;">: <%=hinNo%></label>
<div class="divisionR"></div>


<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 159px; padding-right: 0px; margin-right: 0px;">
Dept/Ward </label> <label class="value"
	style="width: 263px; margin-left: 0px; padding-left: 0px;">: <%=orderByDepartment%></label>

<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 0px; width: 91px; padding-right: 0px;">
Order Date </label> <label class="value"
	style="margin-right: 0px; width: 120px; padding-left: 0px;">: <%=orderDate%></label>
<div class="divisionR"></div>

<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 159px; padding-right: 0px;">
Service No. </label> <label class="value"
	style="margin-right: 0px; width: 122px; padding-left: 0px;">: <%=serviceNo%></label>

<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 142px; margin-right: 0px; width: 88px; padding-right: 0px;">
Rank </label> <label class="value"
	style="margin-right: 0px; width: 120px; padding-left: 0px;">: <%=rankName%></label>
<div class="Clear"></div>

<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 159px; padding-right: 0px;">
Service Person Name </label> <label class="value"
	style="padding-right: 0px; margin-right: 0px; width: auto; padding-left: 0px;">:
<%=servicePersonName%></label>

<div class="Clear"></div>
<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 159px; padding-right: 0px;">
Unit </label> <label class="value"
	style="padding-right: 0px; margin-right: 0px; width: 264px; padding-left: 0px;">:
<%=unitNameAndAddress%></label> <label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 5px; width: 88px; padding-right: 0px;">
R/O </label> <label class="value"
	style="padding-right: 0px; margin-right: 0px; width: auto; padding-left: 0px;">:
<%=recordOfficeAddress%></label>

<div class="Clear"></div>



<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 159px; padding-right: 0px;">
Patient Name </label> <label class="value"
	style="padding-right: 0px; margin-right: 0px; width: 250px; padding-left: 0px;">:
<%=patientName%></label> <label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 88px; padding-right: 0px;">
Relation </label> <label class="value"
	style="width: 120px; margin-left: 0px; padding-left: 0px;">: <%=relationName%></label>
<div class="Clear"></div>

<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 159px; padding-right: 0px;">
Age/Sex </label> <label class="value"
	style="padding-right: 0px; margin-right: 0px; width: auto; padding-left: 0px;">:
<%=patientAge+"/"+sex%></label>


<div class="Clear"></div>
<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; width: 159px; padding-right: 0px;">
Clinical Notes </label> <label class="value"
	style="padding-right: 0px; margin-right: 0px; width: auto; padding-left: 0px;">:
<%=clinicalNotes%></label>
<div class="divisionR"></div>
<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 220px; width: auto;">Sub
Department :</label> <label class="value"
	style="padding-right: 0px; margin-right: 0px; width: auto; padding-left: 0px;">
<%=subChargeName%></label>
<div class="divisionR"></div>
<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px;">Test
Name </label> <label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 255px;">Test
Status </label>
<div class="Clear"></div>

<%
			boolean orderDtEmpty = true;
 			boolean dgSampleCollectionDtEmpty = true;
 			boolean dgResultDtEmpty = true;
 			boolean dgResultDtEmptyLab = true;
 			boolean dgSampleCollectionDtLabEmpty = true;
		if (orderdtList != null && orderdtList.size() > 0 
				&& dgMasInvestigationList!=null && dgMasInvestigationList.size()>0)
		{ %> <%
  			orderDtEmpty = false;
		Iterator<DgOrderdt> dgOrderdtIt = orderdtList.iterator();
		Iterator<DgMasInvestigation> dgMasInvestigationIt = dgMasInvestigationList.iterator();
		while(dgMasInvestigationIt.hasNext() && dgOrderdtIt.hasNext()){
			dgMasInvestigation = dgMasInvestigationIt.next();
			dgOrderdt = dgOrderdtIt.next();
		    if(dgOrderdt.getSubChargeid().getSubChargecodeName().equalsIgnoreCase(subChargeName)){	
			%> <label class="value"
	style="padding-left: 20px; padding-right: 0px; margin-right: 0px; width: 16px;"><%=testCounter%>)</label>
<label class="value"
	style="padding-left: 2px; margin-left: 0px; width: 300px;"><%=dgMasInvestigation.getInvestigationName()%></label>
<% if(dgOrderdt.getOrderStatus().equalsIgnoreCase("P")){ %> <label
	class="value"
	style="padding-left: 110px; width: auto; text-align: center;">Pending
For Sample Collection</label> <%}else if(dgOrderdt.getOrderStatus().equalsIgnoreCase("C")){%>
<label class="value" style="padding-left: 110px; width: auto;">Sample
Collected</label> <%}else if(dgOrderdt.getOrderStatus().equalsIgnoreCase("A")){%>
<label class="value" style="padding-left: 110px; width: auto;">Sample
Accepted</label> <%}else if(dgOrderdt.getOrderStatus().equalsIgnoreCase("X")){%> <label
	class="value" style="padding-left: 110px; width: auto;">Test
Cancelled</label> <%} %> <%testCounter ++; } 
	 	 
	 	 %>
<div class="Clear"></div>
<%} %> <%} %> <!-- Loop for Printing DgSampleCollectionDetails For Lab --> <%for(DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsLabList){
			dgSampleCollectionDtLabEmpty = false;
			if(dgSampleCollectionDetails.getSubcharge().getSubChargecodeName().equalsIgnoreCase(subChargeName)){
			%> <label class="value"
	style="padding-left: 20px; padding-right: 0px; margin-right: 0px; width: 16px;"><%=testCounter%>)</label>
<label class="value"
	style="padding-left: 2px; margin-left: 0px; width: 300px;"><%= dgSampleCollectionDetails.getInvestigation().getInvestigationName()%></label>

<% if( dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("P")){ 
			        if(dgSampleCollectionDetails.getRejected() != null &&
							dgSampleCollectionDetails.getRejected().equalsIgnoreCase("y") ){ %>
<label class="value" style="padding-left: 110px; width: auto;">Rejected</label>
<% }else{ %> <label class="value"
	style="padding-left: 110px; width: auto;">Pending For Sample
Validation</label> <% } %> <%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("E")){%>
<label class="value"
	style="padding-left: 110px; width: auto; text-align: center;">Result
Entered</label> <%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("A")){%>
<label class="value" style="padding-left: 110px; width: auto;">Sample
Pending For Result Entry</label> <%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("X")){%>
<label class="value" style="padding-left: 110px; width: auto;">Test
Cancelled</label> <%} %> <%testCounter++; 
	 	} %>
<div class="Clear"></div>
<%} %> <% int resultEntryIndex = 0; %> <!-- Loop for Printing DgResultEntryDetail For Lab -->
<%for(DgResultEntryDetail dgResultEntryDetail : dgResultEntryDetailLabList){
			dgResultDtEmptyLab = false;
			if(dgResultEntryDetail.getSampleCollectionDetails().getSubcharge().getSubChargecodeName()
					.equalsIgnoreCase(subChargeName)){
			String confidential = "";
			if(dgResultEntryDetail.getInvestigation().getConfidential() != null 
					&& !dgResultEntryDetail.getInvestigation().getConfidential().equals("")
					&& !dgResultEntryDetail.getInvestigation().getConfidential().equalsIgnoreCase("n")){
				confidential = "y";
			}else{
				confidential = "n";
			}
			String investigationType = dgResultEntryDetail.getInvestigation().getInvestigationType();
			%> <label class="value"
	style="padding-left: 20px; padding-right: 0px; margin-right: 0px; width: 16px;"><%=testCounter%>)</label>
<label class="value"
	style="padding-left: 2px; margin-left: 0px; width: 300px;"><%= dgResultEntryDetail.getInvestigation().getInvestigationName()%></label>

<% if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %>
<label class="value" style="padding-left: 110px; width: auto;">Pending
For Result Validation</label> <%}else if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("A")){%>
<label class="value" style="padding-left: 110px; width: auto;">Result
Validated</label> <%}%>
<div class="Clear"></div>
<% if(dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("A") || dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %>
<label
	style="font-size: 11px; padding-left: 20px; padding-right: 0px; margin-right: 0px; width: auto; margin-top: 0px;">Result</label>
<% if(dgResultEntryDetail.getResultType() != null 
						&& dgResultEntryDetail.getResultType().equalsIgnoreCase("t")){ %>
<div class="Clear"></div>
<% } %> <%if(confidential.equalsIgnoreCase("n")){ %> <% if(investigationType.equalsIgnoreCase("s")){ %>
<jsp:include page="viewSingleResultReport.jsp" flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="requestFlag" value="fromOrderStatusReport" />
</jsp:include> <% }else{ %> <label class="value"
	style="padding-left: 30px; margin-left: 0px; margin-top: 0px;">
: <%=dgResultEntryDetail.getResult()%> </label> <% } %> <%}else{ %> <label
	class="value"
	style="padding-left: 30px; margin-left: 0px; margin-top: 0px;">:
Result is Confidential</label> <%} %> <% } %> <%testCounter++; 
	 	} %>
<div class="Clear"></div>
<% resultEntryIndex++; 
	 	} %> <!-- Loop for Printing DgResultEntryHeader For Lab  Only For Multiple-->
<%int mapIndex = 0; %> <%for(DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderLabList){
			dgResultDtEmptyLab = false;
			 DgResultEntryDetail dgResultEntryDetail = dgResultEntryHeader.getDgResultEntryDetails().iterator().next(); 
			if(dgResultEntryDetail.getSampleCollectionDetails().getSubcharge().getSubChargecodeName()
					.equalsIgnoreCase(subChargeName)){	
			 String confidential = "";
				if(dgResultEntryDetail.getInvestigation().getConfidential() != null 
						&& !dgResultEntryDetail.getInvestigation().getConfidential().equals("")
						&& !dgResultEntryDetail.getInvestigation().getConfidential().equalsIgnoreCase("n")){
					confidential = "y";
					System.out.println("Confiden :");
				}else{
					confidential = "n";
				}
			%> <label class="value"
	style="padding-left: 20px; padding-right: 0px; margin-right: 0px; width: 16px;"><%=testCounter%>)</label>
<label class="value"
	style="padding-left: 2px; margin-left: 0px; width: 300px;"><%= dgResultEntryDetail.getInvestigation().getInvestigationName()%></label>

<% if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("P")){ %> <label
	class="value" style="padding-left: 110px; width: auto;">Pending
For Result Validation</label> <%}else if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("A")){%>
<label class="value" style="padding-left: 110px; width: auto;">Result
Validated</label> <%}%>
<div class="Clear"></div>
<% if(dgResultEntryHeader.getResultStatus().equalsIgnoreCase("A") || dgResultEntryHeader.getResultStatus().equalsIgnoreCase("P")){ %>
<label
	style="font-size: 11px; padding-left: 20px; padding-right: 0px; margin-right: 0px; width: auto; margin-top: 0px;">Result</label>
<label
	style="padding-left: 30px; padding-right: 0px; margin-right: 0px; width: auto; margin-top: 0px;">:</label>

<%if(confidential.equalsIgnoreCase("n")){ %> <jsp:include
	page="viewMultipleTestReportForOrderStatus.jsp" flush="true">
	<jsp:param name="mapIndex" value="<%=mapIndex%>" />
</jsp:include> <% }else{ %> <label class="value"
	style="padding-left: 0px; margin-left: 0px; margin-top: 0px;">This
test's result is confidential</label> <% } %> <% } %> <% testCounter++;
	 	} %>
<div class="Clear"></div>
<% mapIndex++;
	 	} %> <!-- Loop for Printing DgResultEntryHeader For Lab Only For Sensitive -->
<% resultEntryIndex = 0;
		for(DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderSensitiveLabList){
			dgResultDtEmptyLab = false;
			 DgResultEntryDetailSen dgResultEntryDetailSen = dgResultEntryHeader.getDgResultEntryDetailSen().iterator().next(); 
			if(dgResultEntryDetailSen.getSampleCollection().getSubcharge().getSubChargecodeName()
					.equalsIgnoreCase(subChargeName)){	
			 String confidential = "";
				System.out.println("Confi :"+dgResultEntryDetailSen.getInvestigation().getConfidential());
				if(dgResultEntryDetailSen.getInvestigation().getConfidential() != null 
						&& !dgResultEntryDetailSen.getInvestigation().getConfidential().equals("")
						&& !dgResultEntryDetailSen.getInvestigation().getConfidential().equalsIgnoreCase("n")){
					confidential = "y";
				}else{
					confidential = "n";
				}
			%> <label class="value"
	style="padding-left: 20px; padding-right: 0px; margin-right: 0px; width: 16px;"><%=testCounter%>)</label>
<label class="value"
	style="padding-left: 2px; margin-left: 0px; width: 300px;"><%= dgResultEntryDetailSen.getInvestigation().getInvestigationName()%></label>

<% if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("P")){ %> <label
	class="value" style="padding-left: 110px; width: auto;">Pending
For Result Validation</label> <%}else if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("A")){%>
<label class="value" style="padding-left: 110px; width: auto;">Result
Validated</label> <%}%>
<div class="Clear"></div>
<% if(dgResultEntryHeader.getResultStatus().equalsIgnoreCase("A") || dgResultEntryHeader.getResultStatus().equalsIgnoreCase("P")){ %>
<label
	style="font-size: 11px; padding-left: 20px; padding-right: 0px; margin-right: 0px; width: auto; margin-top: 0px;">Result</label>

<%if(confidential.equalsIgnoreCase("n")){ %> <jsp:include
	page="viewReportForSensitiveTestType.jsp" flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include> <%}else{ %> <label class="value"
	style="padding-left: 30px; margin-left: 0px; margin-top: 0px;">:
Result is confidential</label> <% } %> <% } %> <% testCounter++; 
	 	} %>
<div class="Clear"></div>
<%resultEntryIndex++;
	 	} %> <!-- Loop for Printing DgSampleCollectionDetails For Radiology -->
<%int index = 0; %> <%for(DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsList){
			dgSampleCollectionDtEmpty = false;
			if(dgSampleCollectionDetails.getInvestigation().getSubChargecode().getSubChargecodeName()
					.equalsIgnoreCase(subChargeName)){
			//String investigationName = scdRadioInvestigationList.get(index);
			%> <label class="value"
	style="padding-left: 20px; padding-right: 0px; margin-right: 0px; width: 16px;"><%=testCounter%>)</label>
<label class="value"
	style="padding-left: 2px; margin-left: 0px; width: 300px;"><%= dgSampleCollectionDetails.getInvestigation().getInvestigationName()%></label>
<% if( dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("P")){ 
			    if(dgSampleCollectionDetails.getRejected() != null 
			    		&& dgSampleCollectionDetails.getRejected().equalsIgnoreCase("y")){ %>
<label class="value" style="padding-left: 110px; width: auto;">Rejected</label>
<%  }else{
			   %> <label class="value" style="padding-left: 110px; width: auto;">Pending
For Acceptance</label> <% } %> <%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("E")){%>
<label class="value" style="padding-left: 110px; width: auto;">Report
Entered</label> <%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("A")){%>
<label class="value" style="padding-left: 110px; width: auto;">Accepted
For Radiological Investigation</label> <%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("X")){%>
<label class="value" style="padding-left: 110px; width: auto;">Test
Cancelled</label> <%} %> <%testCounter++;
	 	}	 %>
<div class="Clear"></div>
<%} %> <!-- Loop for Printing DgResultDetails For Radiology--> <%index = 0; %>
<%for(DgResultEntryDetail dgResultEntryDetail : dgResultEntryDetailList){
			dgResultDtEmpty = false;
			String confidential = "";
			if(dgResultEntryDetail.getInvestigation().getSubChargecode().getSubChargecodeName()
					.equalsIgnoreCase(subChargeName)){
			if(dgResultEntryDetail.getInvestigation().getConfidential() != null 
					&& !dgResultEntryDetail.getInvestigation().getConfidential().equals("")
					&& !dgResultEntryDetail.getInvestigation().getConfidential().equalsIgnoreCase("n")){
				confidential = "y";
			}else{
				confidential = "n";
			}
			%> <label class="value"
	style="padding-left: 20px; padding-right: 0px; margin-right: 0px; width: 16px;"><%=testCounter%>)</label>
<label class="value"
	style="padding-left: 2px; margin-left: 0px; width: 300px;"><%= dgResultEntryDetail.getInvestigation().getInvestigationName()%></label>
<% if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %>
<label class="value" style="padding-left: 110px; width: auto;">Pending
For Report Validation</label> <%}else if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("A")){%>
<label class="value"
	style="padding-left: 110px; width: auto; text-align: center;">Report
Validated</label> <%}%>
<div class="Clear"></div>
<% if(dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
<label
	style="font-size: 11px; padding-left: 20px; padding-right: 0px; margin-right: 0px; width: auto; margin-top: 0px;">Result</label>
<label class="value"
	style="padding-left: 30px; padding-right: 0px; margin-right: 0px; width: auto; margin-top: 0px;">:</label>

<%if(confidential.equalsIgnoreCase("n")){ %>
<div class="Clear"></div>
<label class="value"><%=dgResultEntryDetail.getResult()%></label> <%}else{ %>
<label class="value"
	style="padding-left: 0px; margin-left: 0px; margin-top: 0px;">Result
is Confidential</label> <%} %> <% } %> <%testCounter++; 
	 	} %>
<div class="Clear"></div>
<%} %> <%if(orderDtEmpty && dgSampleCollectionDtEmpty && dgResultDtEmpty && dgSampleCollectionDtLabEmpty 
				&& dgResultDtEmptyLab){ %> <label class="value"> No Data
Exist </label> <%} %>
</div>

<div class="Clear"></div>
<% divCounter++;%>
</div>
<% if(noOfSubTest == (divCounter - 1) ){ %>
<label
	style="font: bold 13px arial color : #000; font-weight: bold; float: right; text-align: center; font-size: 11px; width: 100%; height: 35px; margin-top: 13px;">----------
End Of The Report ----------</label>
<% } %>
<div style='page-break-after: always;'></div>
<%testCounter = 1; %>
<%} %>

</body>
</html>
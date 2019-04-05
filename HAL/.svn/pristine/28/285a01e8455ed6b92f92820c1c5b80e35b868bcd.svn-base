<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Hospital Management System</title>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<style>
#html,body {
	overflow: visible;
	text-align: left;
}
</style>

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
		System.out.println("in not null");
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

	System.out.println("resultType is------" + dgResultdetailList.size());
%>
<%for(String subChargeName : subChargeCodeGroup){
	System.out.println("Sub Charge Name :"+subChargeName);
	%>


<%int index = 0; %>
<%for(DgResultEntryDetail dgResultEntryDetail : dgResultdetailList){ 
	if(dgResultEntryDetail.getInvestigation().getSubChargecode().getSubChargecodeName()
			.equalsIgnoreCase(subChargeName)){


%>
<div id="contentHolder1">
<h1
	style="font: bold 16px arial color : #000; text-align: center; font-size: 22px;">Command
Hospital Bangalore</h1>
<h3
	style="font: bold 13px arial color : #000; text-decoration: underline; text-align: center; font-size: 16px;">Diagnostic
Register Report for the period ( <%=fromDatePrint%> - <%=toDatePrint%> )
</h3>
<div style="padding-top: 20px;"></div>
<div class="blockFrame1" style="border: none; background: #FFF;">
<div class="divisionR"></div>
<label
	style="font-size: 14px; color: #000; font-family: arial; padding-left: 20px; width: auto; padding-right: 0px; margin-right: 0px;">OrderBy
: </label> <label class="value"
	style="width: 120px; margin-left: 0px; padding-left: 0px;"> <%=orderByDepartment%>
</label> <label
	style="font-size: 14px; color: #000; font-family: arial; padding-left: 20px; width: auto; padding-right: 0px; margin-right: 0px;">Main
Group : </label> <label class="value"
	style="width: 120px; margin-left: 0px; padding-left: 0px;"> <%=mainChargeCodeName%>
</label> <label
	style="font-size: 14px; color: #000; font-family: arial; padding-left: 20px; width: auto; padding-right: 0px; margin-right: 0px;">Sub
Group : </label> <label class="value"
	style="width: 120px; margin-left: 0px; padding-left: 0px;"> <%=subChargeName%>
</label>

<div class="Clear"></div>
<label
	style="font-size: 14px; color: #000; font-family: arial; padding-left: 20px; width: auto; padding-right: 0px; margin-right: 0px;">Patient
Type : </label> <label class="value"
	style="width: 120px; margin-left: 0px; padding-left: 0px;"> <%=patientType%>
</label>

<div class="divisionR"></div>
<label
	style="font-size: 14px; color: #000; font-family: arial; padding-left: 20px; width: auto; padding-right: 0px; margin-right: 0px;">Result
Date :</label> <label class="value"
	style="width: 60px; margin-left: 0px; padding-left: 0px;"><%=dgResultEntryDetail.getResultEntry().getResultDate()%>
</label> <label
	style="font-size: 14px; color: #000; font-family: arial; padding-left: 54px; width: auto; padding-right: 0px; margin-right: 0px;">Patient
Name : </label> <label class="value"
	style="width: 120px; margin-left: 0px; padding-left: 0px;"><%=patientName %>
</label> <label
	style="font-size: 14px; color: #000; font-family: arial; padding-left: 10px; width: auto; padding-right: 0px; margin-right: 0px;">Hin
No : </label> <label class="value"
	style="width: 120px; margin-left: 0px; padding-left: 0px;"><%=hinNo%>
</label>

<div class="Clear"></div>
<label
	style="font-size: 14px; color: #000; font-family: arial; padding-left: 20px; width: auto; padding-right: 0px; margin-right: 0px;">Service
No. :</label> <label class="value"
	style="width: 104px; margin-left: 0px; padding-left: 0px;"> <%=serviceNo %>
</label> <label
	style="font-size: 14px; color: #000; font-family: arial; padding-left: 10px; width: auto; padding-right: 0px; margin-right: 0px;">Test
Name : </label> <label class="value"
	style="width: 140px; margin-left: 0px; padding-left: 0px;"> <%=dgResultEntryDetail.getInvestigation().getInvestigationName() %>
</label> <label
	style="font-size: 14px; color: #000; font-family: arial; padding-left: 10px; width: auto; padding-right: 0px; margin-right: 0px;">Remarks
: </label> <label class="value"
	style="width: 120px; margin-left: 0px; padding-left: 0px;"> <%=dgResultEntryDetail.getRemarks()%>
</label>

<div class="Clear"></div>

<!-- line should  be here -->
<h1 align="center" class="style1"><!-- charge Code here --></h1>
<!-- line should  behere -->


<div class="divisionR"></div>
<!-- line should  behere -->
<div class="Clear"></div>
<% 
   	String confidential = "";
		if(dgResultEntryDetail.getInvestigation().getConfidential() != null 
				&& !dgResultEntryDetail.getInvestigation().getConfidential().equals("")
				&& !dgResultEntryDetail.getInvestigation().getConfidential().equalsIgnoreCase("n")){
			confidential = "y";
		}else{
			confidential = "n";
		}

%> <label
	style="font-size: 15px; color: #000; font-family: arial; width: auto; padding-left: 10px;">Result
:</label> <%if(confidential.equalsIgnoreCase("n")){ %> <label class="value"><%=dgResultEntryDetail.getResult()%></label>
<%}else{ %> <label class="value">This test's result is
confidential</label> <%} %>

<div class="Clear"></div>
</div>
<div class="Clear"></div>
</div>
<div style='page-break-after: always;'></div>
<%		} 

	}
}
if( subChargeCodeGroup.size() == 0){ %>
<label class="value">No Record Found</label>
<% }
%>

</body>
</html>
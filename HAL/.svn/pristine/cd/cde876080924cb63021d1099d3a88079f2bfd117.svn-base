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


<script type="text/javascript">
        function PrintPage() {
            document.getElementById('print').style.display = 'none';
            window.resizeTo(960, 600);
            document.URL = "";
            window.location.href = "";
            window.print();
        }

    </script>
    <style type="text/css" media="print">
        @page
        {
            size: auto; /* auto is the initial value */
            /* margin: 2mm 4mm 0mm 0mm; */ /* this affects the margin in the printer settings */
        }
        thead
        {
            display: table-header-group;
        }
        tfoot
        {
            display: table-footer-group;
        }
        table{border:0; font-size:12px;}        
        table td {border:0; font-size:12px;}
        
    </style>
    <style type="text/css" media="screen">
        thead
        {
            display: block;
        }
        tfoot
        {
            display: block;
        }
        
        table{border:0; font-size:12px;}        
        table td {border:0; font-size:12px;}
    </style>
    
<body>


<form id="form1" runat="server">
    <div>
<div>
<h1><%=hospitalName %></h1>
<div class="Clear"></div>
<h2><%=hospitalAddress %></h2>
<div class="Clear"></div>
<h3>Final Laboratory Result</h3>

<div class="Clear"></div>
<%int testCounter = 1; %>
<%int noOfSubTest = subChargeCodeGroup.size(); %>
<%int subTestCounter = 0; %>

<%//for(String subChargeName : subChargeCodeGroup){
	%>
</div>
	
<table style="width:1024px; margin: 0 auto;">
	<thead>
     <tr>
     <td>
   <div class="Clear"></div>
<!-- line should  behere -->
<div class="Clear"></div>
<fieldset id="dataDiv">
<div class="Clear"></div>
<label>Dept/Ward      :</label>
<label class="value"> <%=orderByDepartment%></label>
<label>Order Date    :</label>
<label class="value"> <%=orderDate %>
</label>


<label>Employee No.    :</label> <label class="value"> <%=serviceNo %> 
</label>
<div class="clear"></div>
<label>Patient Name   :</label> <label class="value"> <%=patientName %>
</label>
<label>Relation       :</label>
<label class="value"><%=relationName %></label>
<label>Designation           :</label>
<label class="value"> <%=rankName %>
</label>
<div class="Clear"></div>

<label>Name           :</label> <label class="value"> <%=servicePersonName %>
</label>
	<%
		int PatientAge=0;
		String sPatientAge="-";
		if(dgResultEntryHeaderByOrderNo.size() > 0 ){
			
			if(dgResultEntryHeaderByOrderNo.get(0).getPatient().getDateOfBirth() != null)
			{
				Date date_of_birth= dgResultEntryHeaderByOrderNo.get(0).getPatient().getDateOfBirth();
				
			//	Date d1= new Date();
				
				
				PatientAge = HMSUtil.calculateAgeInYears(date_of_birth);
				
				if(PatientAge == 1 )
				{
					sPatientAge = PatientAge +" Year";
				}
				else if(PatientAge == 0 )
				{
					
				}
				else
				{
					sPatientAge = PatientAge +" Years";
				}
			}
		}
	%>
<label>Age/Gender     :</label>
<label class="value"> <%=sPatientAge%>/<%=sex %></label>
<label>Prescribed By  :</label> <label class="value"> <%=doctorName %></label>
<div class="Clear"></div>

<label>
Order No       : </label> <label class="value">
<%=orderNo%></label>
<%for(String subChargeName : subChargeCodeGroup){
	%>

<label>Modality       :</label> <label class="value">
<%=subChargeName%></label>
<div class="clear"></div>
</fieldset>

<div class="Clear"></div>
       </td>
       </tr>
       </thead>
       
    <tbody>
  

<div class="printWrapper--">

<!-- Loop for Printing DgResultEntryHeader For Lab  Only For Multiple-->
<%int resultEntryIndex = 0; %> <% 
 	for(DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderByOrderNo){
 		%>
 		 <tr>
 		 <td>
 		 	<%
 	
 		if(dgResultEntryHeader.getResultType() != null 	&& dgResultEntryHeader.getResultType().equalsIgnoreCase("S")){
 			if(dgResultEntryHeader.getSubChargecode().getSubChargecodeName().equalsIgnoreCase(subChargeName)){ 
 			
 			DgResultEntryDetailSen dgDetail = dgResultEntryHeader.getDgResultEntryDetailSen().iterator().next();
 			if(flagForConfidential.equals("") && dgDetail.getInvestigation().getConfidential() != null
  	    		   && dgDetail.getInvestigation().getConfidential().equals("y") ){ %>
<div class="Clear"></div>
<span >
This Investigation Result is confidential </span>
<div class="Clear"></div>

<%}else{ %>
<ul><li><%=testCounter%>)</li>
<li>Investigation: <%= dgDetail.getInvestigation().getInvestigationName()%></li>
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
<li>Investigations:  <%= dgDetail.getInvestigation().getInvestigationName()%></li>
</ul>
<%
	       if(flagForConfidential.equals("") && dgDetail.getInvestigation().getConfidential() != null
	    		   && dgDetail.getInvestigation().getConfidential().equals("y") ){ %>
<div class="Clear"></div>
<span>
This Investigation Result is confidential </span>
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
<label class="value" style="width:780px;"><%=dgDetail.getResult()%></label>
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
 		
 %>
 </tr>
 </td>
 	<%}
 	
 	%>

<!--  <label style="font-size:11px; color:#000;font-family:arial;	padding-left:350px;width:auto;padding-right:0px;margin-right: 0px;">Signature:</label> -->
<!--  <label class="value" style="width:120px;margin-left: 0px;padding-left: 0px;"> </label> -->
<!-- <div class="Clear"></div> -->

<tr>
 <td>
<% subTestCounter++; %>
<% if(subTestCounter == noOfSubTest){ %>
<h6>----------End Of The Report ----------</h6>
<% } %>
<% 
 testCounter = 1;
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
 <label class="value"><%=verifiedPersonName%></label>
 <div class="Clear"></div>



<div class="Clear"></div>
<label class="value"><%=entryPersonNameDesignation%></label>
<label class="value"><%=verifiedPersonNameDesignation%></label>
<div class="Clear"></div>
<label>Date: </label>
<label class="value"><%=resultDate%> </label>
<label></label>
<label></label>
<label></label>
<label></label>
<label>Date: </label>
<label class="value"><%=resultDate%> </label>

<div class="Clear"></div>
</div> 

<!-- <div style='page-break-after: always;'></div> -->
<div class="Clear"></div>
</div>

</td>
</tr>
</tbody>

<!-- <tfoot>
                <tr>
                    <td>
                        footer comes here for each page
                    </td>
                </tr>
            </tfoot> -->
        </table>
    </div>
    <br clear="all" />
    <div class="print_wp">
    <input type="button" id="print" name="print" value="Print" class="printButton" onclick="javascript:PrintPage();" />
    </div>
    </form>




</body>
</html>
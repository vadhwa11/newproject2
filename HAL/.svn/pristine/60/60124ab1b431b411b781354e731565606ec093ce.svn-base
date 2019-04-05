<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="java.text.DecimalFormat"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Hospital Management System</title>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />


<%
	Date d=new Date();
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
	String servicePersonName="&nbsp;";
	String radioId = "&nbsp;";
	String entryPersonNameRank = "&nbsp;";
	String prefix = "";
	String suffix = "";
	Integer investigationId = 0;
	
	List<DgResultEntryDetail> dgResultEntryDtList = new ArrayList<DgResultEntryDetail>();
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	String message = "";
	String url = "";
	String clinicalNotes = "";
	int deptId = 0;
	String verifiedPersonNameDesignation = "&nbsp;";
	String entryPersonNameDesignation = "&nbsp;";
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	
	}
	if (map.get("detailsMap") != null) {
		detailsMap = (Map<String, Object>)map.get("detailsMap");
	}
	if (map.get("investigationId") != null) {
		investigationId = (Integer)map.get("investigationId");
	}
	
	if(session.getAttribute("deptName")!=null){
		deptName=(String)session.getAttribute("deptName");
	}
	if(session.getAttribute("deptId")!=null){
		deptId =(Integer)session.getAttribute("deptId");
	}

	if (detailsMap.get("hinNo") != null) {
		hinNo = (String)detailsMap.get("hinNo");

	}if (detailsMap.get("servicePersonName") != null) {
		servicePersonName = (String)detailsMap.get("servicePersonName");

	}
	
	if (detailsMap.get("serviceNo") != null) {
		serviceNo = (String)detailsMap.get("serviceNo");

	}
	if (detailsMap.get("prefix") != null) {
		prefix = (String)detailsMap.get("prefix");

	}
	if (detailsMap.get("suffix") != null) {
		suffix = (String)detailsMap.get("suffix");

	}

	if (detailsMap.get("entryPersonName") != null) {
		entryPersonName = (String)detailsMap.get("entryPersonName");

	}
	if (detailsMap.get("entryPersonNameDesignation") != null) {
		entryPersonNameDesignation = (String)detailsMap.get("entryPersonNameDesignation");

	}
	if (detailsMap.get("entryPersonNameRank") != null) {
		entryPersonNameRank = (String)detailsMap.get("entryPersonNameRank");

	}
	if (detailsMap.get("verifiedPersonNameDesignation") != null) {
		verifiedPersonNameDesignation = (String)detailsMap.get("verifiedPersonNameDesignation");

	}

	if (detailsMap.get("patientName") != null) {
		patientName = (String)detailsMap.get("patientName");

	}
	if (detailsMap.get("orderNo") != null) {
		orderNo = (String)detailsMap.get("orderNo");

	}
	if (detailsMap.get("radioId") != null) {
		radioId = (String)detailsMap.get("radioId");

	}
	if (detailsMap.get("orderDate") != null) {
		orderDate = HMSUtil.convertDateToStringWithoutTime((Date)detailsMap.get("orderDate"));

	}
	if (detailsMap.get("relationName") != null) {
		relationName = (String)detailsMap.get("relationName");

	}
	if (detailsMap.get("patientAge") != null) {
		patientAge = (String)detailsMap.get("patientAge");

	}
	if (detailsMap.get("sex") != null) {
		sex = (String)detailsMap.get("sex");

	}
	if (detailsMap.get("resultDate") != null) {
		resultDate = HMSUtil.convertDateToStringWithoutTime((Date)detailsMap.get("resultDate"));

	}
	if (detailsMap.get("rankName") != null) {
		rankName = (String)detailsMap.get("rankName");

	}
	if (detailsMap.get("subChargeCodeName") != null) {
		subChargeCodeName = (String)detailsMap.get("subChargeCodeName");

	}
	if (detailsMap.get("mainChargeCodeName") != null) {
		mainChargeCodeName = (String)detailsMap.get("mainChargeCodeName");

	}
	if (detailsMap.get("charge") != null) {
		charge = (String)detailsMap.get("charge");

	}
	if (detailsMap.get("doctorName") != null) {
		doctorName = (String)detailsMap.get("doctorName");

	}
	if (detailsMap.get("clinicalNotes") != null) {
		clinicalNotes = (String)detailsMap.get("clinicalNotes");
	}
	if (map.get("messageTOBeVisibleToTheUser") != null) {
		message = "" + map.get("messageTOBeVisibleToTheUser");
	}
	if (map.get("url") != null) {
		url = "" + map.get("url");
	}
	if (detailsMap.get("dgResultEntryDtList") != null) {
		dgResultEntryDtList = (List<DgResultEntryDetail>) detailsMap
				.get("dgResultEntryDtList");
	}

	String resultType = "";
	if (map.get("resultType") != null) {
		resultType = (String) map.get("resultType");
	}
	Integer initHieght = 65;
	int totalSize = dgResultEntryDtList.size();
	String sampleCollDateString = "";
	System.out.println("resultType is------" + resultType);
	for(int i=1 ;i<=totalSize-1 ;i++){
		initHieght = initHieght + 20;
	}


%>
<form action="">
<div id="contentHolder">
<div class="Clear"></div>
<h6>Patient Test History</h6>

<% if(dgResultEntryDtList.size() > 0){ %>
<div
	style="overflow: scroll; overflow-x: scroll; height:<%=initHieght%>px; width: 99%; BORDER: #202020 1px solid;margin-left:20px;">

<table width="100%" border="0" cellpadding="2" cellspacing="2"
	class="grid_header">


	<thead>
		<tr>

			<td width="70%" class="gridheaderlabel">Test Name</td>
			<td width="10%" class="gridheaderlabel">Result Date</td>
			<td width="10%" class="gridheaderlabel">Result</td>
			<td width="10%" class="gridheaderlabel">Normal Range</td>
		</tr>
	</thead>
	<%for(DgResultEntryDetail dgResultEntryDetail : dgResultEntryDtList){ 
       		%>
	<tbody>
		<tr onclick="">
			<td><%= dgResultEntryDetail.getInvestigation().getInvestigationName()%></td>
			<% 
					
			%>

			<td><%=HMSUtil.changeDateToddMMyyyy(dgResultEntryDetail.getResultEntry().getVerifiedOn()) %></td>
			<% if(dgResultEntryDetail.getInvestigation().getMinNormalValue() != null
	    		&& dgResultEntryDetail.getInvestigation().getMaxNormalValue() != null){ 
				
				new DecimalFormat();
	    		Float minValue = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMinNormalValue());
	    		Float maxValue = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMaxNormalValue());
	    		Float result1   = Float.parseFloat(dgResultEntryDetail.getResult());
	       		
	    		String result = new DecimalFormat("0.##").format((double)result1);

	    		if(result1 <= maxValue && result1 >= minValue ){ %>
			<td><%=result%></td>
			<% }else{ %>
			<td><span style="font-weight: bold; color: red;"><%=result %></span></td>
			<% }
	    		%>
			<% }else{ %>
			<td><%=dgResultEntryDetail.getResult()%></td>
			<% } %>

			<% if(dgResultEntryDetail.getInvestigation().getMinNormalValue() != null
    		&& dgResultEntryDetail.getInvestigation().getMaxNormalValue() != null){ 
    		Integer minValue = Integer.parseInt(dgResultEntryDetail.getInvestigation().getMinNormalValue());
    		Integer maxValue = Integer.parseInt(dgResultEntryDetail.getInvestigation().getMaxNormalValue());
     		
    		%>
			<td><%=minValue%> - <%=maxValue %></td>


			<% }else{ %>
			<td>-</td>
			<% } %>


		</tr>

		<% } %>


	</tbody>
</table>
</div>
<% }else{ %> <label
	style="font: bold 13px arial color : #000; font-weight: bold; float: right; text-align: center; font-size: 11px; width: 100%; height: 35px; margin-top: 13px;">----------
No Data Found ----------</label> <% } %> <br>

<input type="button" name="yes" value="Back" class="button"
	onclick="history.back()" /></div>
</form>
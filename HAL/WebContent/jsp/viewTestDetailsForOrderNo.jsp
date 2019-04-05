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
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<%@page import="jkt.hms.masters.business.Patient"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-color.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/wysiwyg-settings.js"></script>


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
		
			function clearTestDivDown(flag,id,resultType,resultStatus,confidential){
			document.getElementById('testDivDown').innerHTML = "";
			if(flag == 'rhLab'){
				window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');
			}
			if(flag == 'rdRadio'){
				//window.showModalDialog('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','dialogHeight=120,dialogWidth=120','dialogLeft=100,dialogTop=160,dialogHeight=120,dialogWidth=120,,status=2,scrollbars=1,resizable=0,center=1');
				window.open('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');
			}
			if(flag == 'rhSenLab'){
				window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=25,top=160,height=400,width=970,status=1,scrollbars=1,resizable=1');			
				//submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'','testDivDown');
			}
			if(flag == 'rEntryDetailLab'){
				if(resultType == 's'){
					window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');				
				}else{
					window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');				
				}
			}
		}

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
		List<Patient> patientList = new ArrayList<Patient>();
		List<String> scdRadioInvestigationList = new ArrayList<String>();
		
		DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
		DgOrderdt dgOrderdt = new DgOrderdt();
		
		String userName = "";
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
		if (orderDetailMap.get("patientList") != null){
			patientList =(List)orderDetailMap.get("patientList");
		}
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
	 	Patient patient = new Patient();
	 	System.out.println("orderdtList==="+orderdtList.size());
	 	if(patientList.size()>0){
	 		patient = patientList.get(0);
		 	
	 	}	 	

	%>

<div class="popupbg">
<div class="clear"></div>
<div class="titleBg"><h2>Previous Investigations</h2></div>
<%-- 	<h4>Patient Details</h4>
	<div class="clear"></div>
<div class="Block">
<label>Employee No.</label>
 <%
 	if (patient.getServiceNo() != null) {
 %>
<label class="value"><%=patient.getServiceNo()%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>
<label>Patient Name</label>
 <%
 	if (patient.getPFirstName() != null) {
 			String mname = "";
 			String lname = "";
 			String fname = patient.getPFirstName();
 			if (patient.getPMiddleName() != null)
 				mname = patient.getPMiddleName();
 			if (patient.getPLastName() != null)
 				lname = patient.getPLastName();
 %>
<label class="value"><%=fname + mname + lname%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>
<label>Relation</label>
 <%
 	if (patient.getRelation() != null) {
 %>
<label class="value"><%=patient.getRelation().getRelationName()%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>


<div class="clear"></div>
<label >Designation</label>
<%
	if (patient.getRank() != null) {
%>
<label class="value"><%=patient.getRank().getRankName()%></label>
<%
	} else {
%> <label class="value">&nbsp;</label><%
 	}
 %>
<label>Name</label> 
<%
 	if (patient != null) {
 			
 			if (patient.getSFirstName() != null
 					&& !(patient.getSFirstName().equals(""))) {

 				String sMiddleName = "";
 				String sLastName = "";
 				if (patient.getSMiddleName() != null) {
 					sMiddleName = patient.getSMiddleName();
 				}
 				if (patient.getSLastName() != null) {
 					sLastName = patient.getSLastName();
 				}
 %> <label
	class="value"><%=patient.getSFirstName() + " " + sMiddleName
								+ " " + sLastName%></label> <%
 	}
 		} else {
 %> <label class="value"></label>
<%
	}
%>
<label>Unit</label>
 <%
 	if (patient.getUnit() != null) {
 %>
<label class="value"><%=patient.getUnit().getUnitName()%></label>
<%
	} else {
%> <label class="value">&nbsp;</label><%
 	}
 %>
<label >Age</label> 
<%
 	if (patient.getAge() != null) {
 %>
<label class="value"><%=patient.getAge()%></label> 
<%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>


 <label>Gender</label>
 <%
 	if (patient.getSex() != null) {
 %>
<label class="value"><%=patient.getSex()
							.getAdministrativeSexName()%></label>
<%
	} else {
%> <label class="value">&nbsp;</label><%
 	}
 %>
 
<label>Medical Officer</label>
 <%
 	if (patient.getServiceNo() != null) {
 %>
<label class="value"><%=patient.getServiceNo()%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>
<div class="clear"></div>
 <label>Visit Date</label>
 <%
 	if (visit.getVisitDate() != null) {
 %>
<label class="value"><%=visit.getVisitDate()%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>
<label>Visit No.</label>
 <%
 	if (visit.getVisitNo() != null) {
 %>
<label class="value"><%=visit.getVisitNo()%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>

<%
	String diagNo = "";
		Set<PatientInvestigationHeader> patientInvestigationHeaderSet = new HashSet<PatientInvestigationHeader>();
		if (visit.getPatientInvestigationHeaders() != null) {
			patientInvestigationHeaderSet = visit
					.getPatientInvestigationHeaders();
		}
		if (patientInvestigationHeaderSet.size() > 0) {
			for (PatientInvestigationHeader patientInvestigationHeader : patientInvestigationHeaderSet) {
				Set<PatientInvestigationDetails> patientInvestigationDetailsSet = new HashSet<PatientInvestigationDetails>();
				if (patientInvestigationHeader
						.getPatientInvestigationDetails() != null) {
					patientInvestigationDetailsSet = patientInvestigationHeader
							.getPatientInvestigationDetails();
					diagNo = "" + patientInvestigationDetailsSet.size();
				}
			}
		}
%>
<label>Diag. No.</label>
<label class="value"><%=diagNo%></label>

</div> --%>
<!-- <div class="division"></div> -->

<%-- <h3 style="margin-top: 0px;">Test Details For Selected Order</h3>
<div
	style="overflow: scroll; overflow-x: scroll;  height:<%=initHieght%>px; width: 99%; BORDER: #202020 1px solid;margin-left:20px;">
 --%>
 
 <div id="searchresults" tabindex=2>
<div id="searchtable1" tabindex=2></div>


<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.TOKEN_NO%>"], [3,"<%= RequestConstants.VISIT_ID %>","visitId"], [4,"<%= RequestConstants.SERVICE_NO %>"],[5,"<%= RequestConstants.VISIT_TIME %>"],[6,"<%= RequestConstants.SERVICE_NO %>"],[7,"<%=RequestConstants.HIN_NO%>"],[8,"<%= RequestConstants.PATIENT_NAME %>"],[9,"<%=RequestConstants.AGE%>"],[10,"<%=RequestConstants.SEX%>"],[11,"<%=RequestConstants.DIAGNOSIS_ID%>"],[12,"visitNoForJsp"],[13,"disposal"],[14,"days"]  ];
	 //statusTd =13;

</script></div>
<div id="edited"></div>
<div id="statusMessage" ></div>
<table width="100%" border="0" cellpadding="2" cellspacing="2" class="grid_header">
	<thead>
		<tr>
			<!--   			<td width="5%" class="gridheaderlabel">Test Code</td> -->
			<th>Investigation Name</th>
			<!--   			<td width="10%" class="gridheaderlabel">Main Test Name</td> -->
			  			<th width="10%" >Modality</th> 
			  			<th>Order No</th>
			  			<th>Order Date</th>
			  			<th>Prescribed by</th>
			<th>Result</th>
			<th>UOM</th>
			<th>Normal Range</th>
			<th>Investigation Status</th>
			<!-- <th>DICOM View</th> -->
		</tr>
	</thead>
	<tbody>
		<%
			boolean orderDtEmpty = true;
 			boolean dgSampleCollectionDtEmpty = true;
 			boolean dgResultDtEmpty = true;
 			boolean dgResultDtEmptyLab = true;
 			boolean dgSampleCollectionDtLabEmpty = true;
		if (orderdtList != null && orderdtList.size() > 0 
				&& dgMasInvestigationList!=null && dgMasInvestigationList.size()>0)
		{ %>

		<%
  			orderDtEmpty = false;
		Iterator<DgOrderdt> dgOrderdtIt = orderdtList.iterator();
		Iterator<DgMasInvestigation> dgMasInvestigationIt = dgMasInvestigationList.iterator();
		while(dgMasInvestigationIt.hasNext() && dgOrderdtIt.hasNext()){
			dgMasInvestigation = dgMasInvestigationIt.next();
			dgOrderdt = dgOrderdtIt.next();
		
		

			%>
		<!--<tr
			onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgMasInvestigationId=<%=dgMasInvestigation.getId()%>&resultType=<%=dgMasInvestigation.getInvestigationType()%>&dgOrderdtId=<%=dgOrderdt.getId()%>&orderStatus=<%=dgOrderdt.getOrderStatus()%>','testDivDown');">


			-->
			<tr>
			<td>a<%= dgMasInvestigation.getInvestigationName()%></td>
			 <td><%=dgOrderdt.getChargeCode().getSubChargecode().getSubChargecodeName()%></td>
			     <td><%=dgOrderdt.getOrderhd().getOrderNo()%></td>
<td><%=HMSUtil.convertDateToStringWithoutTime(dgOrderdt.getOrderhd().getOrderDate())%></td>
<td><%=dgOrderdt.getOrderhd().getDepartment()!=null?dgOrderdt.getOrderhd().getDepartment().getDepartmentName():"-"%></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<% if(dgOrderdt.getOrderStatus().equalsIgnoreCase("P")){ %>
			<td>Pending</td>
			<%}else if(dgOrderdt.getOrderStatus().equalsIgnoreCase("C")){%>
			<td>Sample Collected</td>
			<%}else if(dgOrderdt.getOrderStatus().equalsIgnoreCase("A")){%>
			<td>Sample Accepted</td>
			<%}else if(dgOrderdt.getOrderStatus().equalsIgnoreCase("X")){%>
			<td>Test Cancelled</td>
			<%} %>
		
		<%-- 	<td>
			<%if(dgOrderdt.getMainChargecode().getMainChargecodeCode().equalsIgnoreCase("Radio"))
			{
				out.write(HMSUtil.getDICOM(dgOrderdt.getOrderhd().getHin().getId().toString()));
			}
				
				%>
			</td> --%>
			
		</tr>

		<%} %>

		<%} %>
		<!-- Loop for Printing DgSampleCollectionDetails For Lab -->
		<%for(DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsLabList){
			dgSampleCollectionDtLabEmpty = false;
			%>
	<%--<% if(dgSampleCollectionDetails.getRejected() != null){ %>
		<tr
			onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgSampleCollectionDetailLabId=<%=dgSampleCollectionDetails.getId()%>&resultType=<%=dgSampleCollectionDetails.getInvestigation().getInvestigationType()%>&orderStatus=<%=dgSampleCollectionDetails.getOrderStatus()%>&rejectedStatus=<%=dgSampleCollectionDetails.getRejected()%>&rejReason=<%=dgSampleCollectionDetails.getReason()%>','testDivDown');">
			<% }else{ %>
			<tr
				onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgSampleCollectionDetailLabId=<%=dgSampleCollectionDetails.getId()%>&resultType=<%=dgSampleCollectionDetails.getInvestigation().getInvestigationType()%>&orderStatus=<%=dgSampleCollectionDetails.getOrderStatus()%>','testDivDown');">
				<% } %> --%>	

<tr>
				<td>b<%= dgSampleCollectionDetails.getInvestigation().getInvestigationName()%></td>
				<td><%=dgSampleCollectionDetails.getChargeCode().getSubChargecode().getSubChargecodeName()%></td>
				<td><%=dgSampleCollectionDetails.getOrderdt().getOrderhd().getOrderNo()%></td>
				<td><%=HMSUtil.convertDateToStringWithoutTime(dgSampleCollectionDetails.getOrderdt().getOrderhd().getOrderDate())%></td>
				<td><%=dgSampleCollectionDetails.getOrderdt().getOrderhd().getDepartment()!=null?dgSampleCollectionDetails.getOrderdt().getOrderhd().getDepartment().getDepartmentName():"-"%></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<% if( dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("P")){
				if(dgSampleCollectionDetails.getRejected() != null &&
						dgSampleCollectionDetails.getRejected().equalsIgnoreCase("y") ){	 %>
				<td>Sample is Rejected <span
					style="color: highlightred; font-weight: bold; font-style: i">(Reason
				: <% if(dgSampleCollectionDetails.getReason() != null){ %> <%=dgSampleCollectionDetails.getReason() %>
				<% } %> ) </span></td>
				<% }else{ %>
				<td>Pending For Sample Validation</td>
				<% } %>

				<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("E")){%>
				<td>Result Entered</td>
				<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("A")){%>
				<td>Sample Pending For Result Entry</td>
				<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("X")){%>
				<td>Investigation Cancelled</td>
				<%} %>
			</tr>

			<%} %>
			<!-- Loop for Printing DgResultEntryDetail For Lab -->
			<%for(DgResultEntryDetail dgResultEntryDetail : dgResultEntryDetailLabList){
			dgResultDtEmptyLab = false;
			String confidential = "";
			if(dgResultEntryDetail.getInvestigation().getConfidential() != null 
					&& !dgResultEntryDetail.getInvestigation().getConfidential().equals("")
					&& !dgResultEntryDetail.getInvestigation().getConfidential().equalsIgnoreCase("n")){
				confidential = "y";
			}else{
				confidential = "n";
			}
			%>
		<%--	<% if(dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %>
			<tr
				onclick="clearTestDivDown('rEntryDetailLab','<%=dgResultEntryDetail.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryDetail.getResultDetailStatus()%>','<%=confidential%>');">
				<!-- <tr onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId=<%=dgResultEntryDetail.getId()%>&resultType=<%=dgResultEntryDetail.getResultType()%>&orderStatus=<%=dgResultEntryDetail.getResultDetailStatus()%>&confidential=<%=confidential%>','testDivDown');"> -->
				<% }else { %>
				<tr
					onclick="clearTestDivDown('rEntryDetailLab','<%=dgResultEntryDetail.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryDetail.getResultDetailStatus()%>','<%=confidential%>');">
					<% } %> --%>
<tr>
					<td>c<%= dgResultEntryDetail.getInvestigation().getInvestigationName()%></td>
                    <td><%=dgResultEntryDetail.getChargeCode().getSubChargecode().getSubChargecodeName()%></td>
                    <td><%=dgResultEntryDetail.getSampleCollectionDetails().getOrderdt().getOrderhd().getOrderNo()%></td>
                    <td><%=HMSUtil.convertDateToStringWithoutTime(dgResultEntryDetail.getSampleCollectionDetails().getOrderdt().getOrderhd().getOrderDate())%></td>
                    	<td><%=dgResultEntryDetail.getSampleCollectionDetails().getOrderdt().getOrderhd().getDepartment()!=null?dgResultEntryDetail.getSampleCollectionDetails().getOrderdt().getOrderhd().getDepartment().getDepartmentName():"-"%></td>
					<% try{
    	if(dgResultEntryDetail.getInvestigation().getMinNormalValue() != null
    		&& dgResultEntryDetail.getInvestigation().getMaxNormalValue() != null && !dgResultEntryDetail.getInvestigation().getMinNormalValue().isEmpty() && !dgResultEntryDetail.getInvestigation().getMaxNormalValue().isEmpty()){
    		Float minValue =0.0f;
    		Float maxValue =0.0f;
    		System.out.println("1"+dgResultEntryDetail.getInvestigation().getMinNormalValue() +dgResultEntryDetail.getInvestigation().getMinNormalValue().isEmpty());
    		
    		 minValue = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMinNormalValue());
    		 maxValue = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMaxNormalValue());
    		

    		if(dgResultEntryDetail.getResult() != null 
    				&& !dgResultEntryDetail.getResult().equals("")){

    			Float result1   = Float.parseFloat(dgResultEntryDetail.getResult());
	    		String result = new DecimalFormat("0.##").format((double)result1);
	    		if(result1 <= maxValue && result1 >= minValue ){ %>
					<td><%=result%></td>
					<% }else{ %>
					<td style="color: red; font-weight: bold;"><%=result %></td>
					<% }
    		}else{%>
					<td>No Result Entered</td>
					<%}
	       }else{ %>
					<td><%-- <%=dgResultEntryDetail.getResult()%> --%><input  id="Result" type="button" tabindex="1" name="Result"  value="Result" class="button" onclick="clearTestDivDown('rEntryDetailLab','<%=dgResultEntryDetail.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryDetail.getResultEntry().getResultStatus()%>','<%=confidential%>');" /> </td>
					<% } 
    }catch(Exception exception){ %>
					<td><%=dgResultEntryDetail.getResult()%></td>
					<% } %>

					<% if(dgResultEntryDetail.getInvestigation().getUom() != null){ %>
					<td><%=dgResultEntryDetail.getInvestigation().getUom().getUomName()%></td>
					<% }else{ %>
					<td>-</td>
					<% } %>
					<% if(dgResultEntryDetail.getInvestigation().getMinNormalValue() != null &&!dgResultEntryDetail.getInvestigation().getMinNormalValue().isEmpty() 
    		&& dgResultEntryDetail.getInvestigation().getMaxNormalValue() != null &&!dgResultEntryDetail.getInvestigation().getMaxNormalValue().isEmpty() ){ 
     		Float minValue1 = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMinNormalValue());
    		Float maxValue1 = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMaxNormalValue());
    		String minValue = new DecimalFormat("0.##").format((double)minValue1);
    		String maxValue = new DecimalFormat("0.##").format((double)maxValue1);
    		%>
					<td><%=minValue%> - <%=maxValue %></td>
					<% }else{ %>
					<td>-</td>
					<% } %>

					<% if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %>
					<td>Provisional Result/Report</td>
					<%}else if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("A")){%>
					<td>Result Status Validated</td>
					<%}%>
				</tr>

				<%} %>

				<!-- Loop for Printing DgResultEntryHeader For Lab  Only For Multiple-->
				<%for(DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderLabList){
			dgResultDtEmptyLab = false;
			 DgResultEntryDetail dgResultEntryDetail = dgResultEntryHeader.getDgResultEntryDetails().iterator().next(); 
				String confidential = "";
				if(dgResultEntryDetail.getInvestigation().getConfidential() != null 
						&& !dgResultEntryDetail.getInvestigation().getConfidential().equals("")
						&& !dgResultEntryDetail.getInvestigation().getConfidential().equalsIgnoreCase("n")){
					confidential = "y";
					System.out.println("Confiden :");
				}else{
					confidential = "n";
				}
			%>
				<% if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("P")){ %>
				<tr>
				<!--<tr				
					onclick="clearTestDivDown('rhLab','<%=dgResultEntryHeader.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryHeader.getResultStatus()%>','<%=confidential%>');">
					--><!-- 	 <tr onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryHeaderLabId=<%=dgResultEntryHeader.getId()%>&resultType=<%=dgResultEntryDetail.getResultType()%>&orderStatus=<%=dgResultEntryHeader.getResultStatus()%>&confidential=<%=confidential%>','testDivDown');"> -->
					<% }else { %>
					<tr>
					<!--<tr
						onclick="clearTestDivDown('rhLab','<%=dgResultEntryHeader.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryHeader.getResultStatus()%>','<%=confidential%>');">-->
						<% } %>

						<td>d<%= dgResultEntryDetail.getInvestigation().getInvestigationName()%></td>
						  <td><%=dgResultEntryDetail.getChargeCode().getSubChargecode().getSubChargecodeName()%></td>
						      <td><%=dgResultEntryDetail.getSampleCollectionDetails().getOrderdt().getOrderhd().getOrderNo()%></td>
						<td><%=HMSUtil.convertDateToStringWithoutTime(dgResultEntryDetail.getSampleCollectionDetails().getOrderdt().getOrderhd().getOrderDate())%></td>
						<td><%=dgResultEntryDetail.getSampleCollectionDetails().getOrderdt().getOrderhd().getDepartment()!=null?dgResultEntryDetail.getSampleCollectionDetails().getOrderdt().getOrderhd().getDepartment().getDepartmentName():"-"%></td>
						<td>
						<!--  <span style="color: highlightred;">Click here toget Result/Report-->
						<input  id="Result" type="button" tabindex="1" name="Result"  value="Result" class="button" onclick="clearTestDivDown('rhLab','<%=dgResultEntryHeader.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryHeader.getResultStatus()%>','<%=confidential%>');" />
	
						</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<% if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("P")){ %>
						<td>Provisional Result/Report</td>
						<%}else if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("A")){%>
						<td>Result Status Validated</td>
						<%}%>
					</tr>

					<%} %>

					<!-- Loop for Printing DgResultEntryHeader For Lab Only For Sensitive -->
					<%
		for(DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderSensitiveLabList){
			dgResultDtEmptyLab = false;
			 DgResultEntryDetailSen dgResultEntryDetailSen = dgResultEntryHeader.getDgResultEntryDetailSen().iterator().next(); 
				String confidential = "";
				System.out.println("Confi :"+dgResultEntryDetailSen.getInvestigation().getConfidential());
				if(dgResultEntryDetailSen.getInvestigation().getConfidential() != null 
						&& !dgResultEntryDetailSen.getInvestigation().getConfidential().equals("")
						&& !dgResultEntryDetailSen.getInvestigation().getConfidential().equalsIgnoreCase("n")){
					confidential = "y";
				}else{
					confidential = "n";
				}
			%>
					<tr
						onclick="clearTestDivDown('rhSenLab','<%=dgResultEntryHeader.getId()%>','v','<%=dgResultEntryHeader.getResultStatus()%>','<%=confidential%>');">
						<td>e<%= dgResultEntryDetailSen.getInvestigation().getInvestigationName()%></td>
						  <td><%=dgResultEntryDetailSen.getInvestigation().getSubChargecode().getSubChargecodeName()%></td>
						     <td><%=dgResultEntryDetailSen.getSampleCollection().getOrderdt().getOrderhd().getOrderNo()%></td>
                           <td><%=HMSUtil.convertDateToStringWithoutTime(dgResultEntryDetailSen.getSampleCollection().getOrderdt().getOrderhd().getOrderDate())%></td>
                           <td><%=dgResultEntryDetailSen.getSampleCollection().getOrderdt().getOrderhd().getDepartment()!=null?dgResultEntryDetailSen.getSampleCollection().getOrderdt().getOrderhd().getDepartment().getDepartmentName():"-"%></td>
						<td>
						<!--  <span style="color: highlightred;">Click here to get Result/Report</span>-->
						</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<% if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("P")){ %>
						<td>Provisional Result/Report</td>
						<%}else if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("A")){%>
						<td>Result Status Validated</td>
						<%}%>
					</tr>

					<%} %>

					<!-- Loop for Printing DgSampleCollectionDetails For Radiology -->
					<%int index = 0; %>
					<%for(DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsList){
			dgSampleCollectionDtEmpty = false;
			String investigationName = scdRadioInvestigationList.get(index);
			%>
					<% if(dgSampleCollectionDetails.getRejected() != null){ %>
					<tr
						onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=printResultForRadiology&dgSampleCollectionDetailId=<%=dgSampleCollectionDetails.getId()%>&resultType=<%=dgSampleCollectionDetails.getInvestigation().getInvestigationType()%>&orderStatus=<%=dgSampleCollectionDetails.getOrderStatus()%>&rejectedStatus=<%=dgSampleCollectionDetails.getRejected()%>&rejReason=<%=dgSampleCollectionDetails.getReason()%>','testDivDown');">
						<% }else{ %>
						<tr
							onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=printResultForRadiology&dgSampleCollectionDetailId=<%=dgSampleCollectionDetails.getId()%>&resultType=<%=dgSampleCollectionDetails.getInvestigation().getInvestigationType()%>&orderStatus=<%=dgSampleCollectionDetails.getOrderStatus()%>','testDivDown');">
							<% } %>

							<td><%=investigationName%></td>
							<td>d1</td>
           <td><%=dgSampleCollectionDetails.getChargeCode().getSubChargecode().getSubChargecodeName()%></td>
						     <td><%=dgSampleCollectionDetails.getOrderdt().getOrderhd().getOrderNo()%></td>
<td><%=HMSUtil.convertDateToStringWithoutTime(dgSampleCollectionDetails.getOrderdt().getOrderhd().getOrderDate())%></td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<% if( dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("P")){ %>
							<%	if(dgSampleCollectionDetails.getRejected() != null &&
						dgSampleCollectionDetails.getRejected().equalsIgnoreCase("y") ){	 %>
							<td>Test is Rejected <span
								style="color: highlightred; font-weight: bold;">(Reason :
							<% if(dgSampleCollectionDetails.getReason() != null){ %> <%=dgSampleCollectionDetails.getReason() %>
							<% } %> )</span></td>
							<% }else{ %>
							<td>Pending For Radiological Investigation</td>
							<% } %>

							<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("E")){%>
							<td>Report Entered</td>
							<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("A")){%>
							<td>Accepted For Radiological Investigation</td>
							<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("X")){%>
							<td>Investigation Cancelled</td>
							<%} %>
						</tr>
						<%index++; %>
						<%} %>
						<!-- Loop for Printing DgResultDetails For Radiology-->
						<%index = 0; %>
						<%for(DgResultEntryDetail dgResultEntryDetail : dgResultEntryDetailList){
			dgResultDtEmpty = false;
			String confidential = "";
			if(dgResultEntryDetail.getInvestigation().getConfidential() != null 
					&& !dgResultEntryDetail.getInvestigation().getConfidential().equals("")
					&& !dgResultEntryDetail.getInvestigation().getConfidential().equalsIgnoreCase("n")){
				confidential = "y";
			}else{
				confidential = "n";
			}
			%>
						<% if(dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %>
						<!--<tr onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=printResultForRadiology&dgResultEntryDetailId=<%=dgResultEntryDetail.getId()%>&resultType=<%=dgResultEntryDetail.getResultType()%>&orderStatus=<%=dgResultEntryDetail.getResultDetailStatus()%>&confidential=<%=confidential%>','testDivDown');">
				-->
						<tr
							onclick="clearTestDivDown('rdRadio','<%=dgResultEntryDetail.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryDetail.getResultDetailStatus()%>','<%=confidential%>');">
							<% }else{ %>
							<tr
								onclick="clearTestDivDown('rdRadio','<%=dgResultEntryDetail.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryDetail.getResultDetailStatus()%>','<%=confidential%>');">
								<% } %>
								<td><%= dgResultEntryDetail.getInvestigation().getInvestigationName()%></td>
                                <td><%=dgResultEntryDetail.getChargeCode().getSubChargecode().getSubChargecodeName()%></td>
    <td><%=dgResultEntryDetail.getSampleCollectionDetails().getOrderdt().getOrderhd().getOrderNo()%></td>
<td><%=HMSUtil.convertDateToStringWithoutTime(dgResultEntryDetail.getSampleCollectionDetails().getOrderdt().getOrderhd().getOrderDate())%></td>
<td><%=dgResultEntryDetail.getSampleCollectionDetails().getOrderdt().getOrderhd().getDepartment()!=null?dgResultEntryDetail.getSampleCollectionDetails().getOrderdt().getOrderhd().getDepartment().getDepartmentName():"-"%></td>

								<td>
								<input  id="Result" type="button" tabindex="1" name="Result"  value="Result" class="button" onclick="clearTestDivDown('rdRadio','<%=dgResultEntryDetail.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryDetail.getResultDetailStatus()%>','<%=confidential%>');"" />
	
								</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<% if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %>
								<td>Provisional Result/Report</td>
								<%}else if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("A")){%>
								<td>Result Status Validated</td>
								<%}%>
							</tr>

							<%} %>
							<%if(orderDtEmpty && dgSampleCollectionDtEmpty && dgResultDtEmpty && dgSampleCollectionDtLabEmpty 
				&& dgResultDtEmptyLab){ %>
							<tr>
								<td>No Data Exist</td>
							</tr>
							<%} %>
						
	</tbody>
</table>




<div id="testDivDown"></div>

<div class="clear"></div>
</div>


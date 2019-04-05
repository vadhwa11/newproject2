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
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
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
	</script>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> testDetailMap = new HashMap<String,Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();

		List<DgOrderdt> orderdtList = new ArrayList<DgOrderdt>();
		List<DgMasInvestigation> dgMasInvestigationList = new ArrayList<DgMasInvestigation>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsLabList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailLabList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryHeader> dgResultEntryHeaderLabList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> dgResultEntryHeaderSensitiveLabList = new ArrayList<DgResultEntryHeader>();
		
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
		
		if (map.get("testDetailMap") != null){
			testDetailMap =(Map)map.get("testDetailMap");
		}
		if (testDetailMap.get("dgOrderdtList") != null){
			orderdtList =(List)testDetailMap.get("dgOrderdtList");
		}
		if (testDetailMap.get("dgMasInvestigationList") != null){
			dgMasInvestigationList = (List)testDetailMap.get("dgMasInvestigationList");
		}
		if (testDetailMap.get("dgSampleCollectionDetailsList") != null){
			dgSampleCollectionDetailsList = (List)testDetailMap.get("dgSampleCollectionDetailsList");
		}
		if (testDetailMap.get("dgResultEntryDetailList") != null){
			dgResultEntryDetailList = (List)testDetailMap.get("dgResultEntryDetailList");
		}
		if (testDetailMap.get("dgSampleCollectionDetailsLabList") != null){
			dgSampleCollectionDetailsLabList = (List)testDetailMap.get("dgSampleCollectionDetailsLabList");
		}
		if (testDetailMap.get("dgResultEntryDetailLabList") != null){
			dgResultEntryDetailLabList = (List)testDetailMap.get("dgResultEntryDetailLabList");
		}
		if (testDetailMap.get("dgResultEntryHeaderLabList") != null){
			dgResultEntryHeaderLabList = (List)testDetailMap.get("dgResultEntryHeaderLabList");
		}
		if (testDetailMap.get("dgResultEntryHeaderSensitiveLabList") != null){
			dgResultEntryHeaderSensitiveLabList = (List)testDetailMap.get("dgResultEntryHeaderSensitiveLabList");
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

	%>

<div class="division"></div>
<div id="contentHolder">
<h3 style="margin-top: 0px; margin-bottom: 0px;">Test Details For
Selected Order</h3>
<label
	style="width: 100%; text-align: left; color: red; padding-left: 20px;">(Note
:Confidential Test are shown in red color)</label>
<div
	style="overflow: scroll; overflow-x: scroll;  height:<%=initHieght%>px; width: 99%; BORDER: #202020 1px solid;margin-left:20px;">

<table width="100%" cellpadding="3" cellspacing="0" class="grid_header">


	<thead>
		<tr>
			<!--   			<td width="5%" class="gridheaderlabel">Test Code</td> -->
			<td width="70%" class="gridheaderlabel">Test Name</td>
			<!--   			<td width="10%" class="gridheaderlabel">Main Test Name</td> -->
			<!--   			<td width="10%" class="gridheaderlabel">Sub Test Name</td> -->
			<td width="10%" class="gridheaderlabel">Test Status</td>
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
			String confidential = "";
			if(dgMasInvestigation.getConfidential() != null 
					&& !dgMasInvestigation.getConfidential().equals("")
					&& !dgMasInvestigation.getConfidential().equalsIgnoreCase("n")){
				confidential = "y";
			}else{
				confidential = "n";
			}
 			%>
		<%if(confidential.equalsIgnoreCase("y")){ %>
		<tr style="color: red;"
			onclick="clearTestDivDown('orderdtForLab','<%=dgMasInvestigation.getId()%>','<%=dgMasInvestigation.getInvestigationType()%>','<%=dgOrderdt.getOrderStatus()%>','<%=confidential%>');"
			<%}else{ %><tr onclick="clearTestDivDown('orderdtForLab','<%=dgMasInvestigation.getId()%>','<%=dgMasInvestigation.getInvestigationType()%>','<%=dgOrderdt.getOrderStatus()%>','<%=confidential%>');"> 		
 		<%} %>

<!--  			<td><%= dgMasInvestigation.getChargeCode().getChargeCodeCode()%></td> -->
			<td><%= dgMasInvestigation.getInvestigationName()%></td>
			<!-- 			<td><%= dgMasInvestigation.getMainChargecode().getMainChargecodeName()%></td> -->
			<!-- 			<td><%= dgMasInvestigation.getSubChargecode().getSubChargecodeName()%></td> -->

			<% if(dgOrderdt.getOrderStatus().equalsIgnoreCase("P")){ %>
			<td>Pending</td>
			<%}else if(dgOrderdt.getOrderStatus().equalsIgnoreCase("C")){%>
			<td>Sample Collected</td>
			<%}else if(dgOrderdt.getOrderStatus().equalsIgnoreCase("A")){%>
			<td>Sample Accepted</td>
			<%}else if(dgOrderdt.getOrderStatus().equalsIgnoreCase("X")){%>
			<td>Test Cancelled</td>
			<%} %>
		</tr>

		<%} %>

		<%} %>
		<!-- Loop for Printing DgSampleCollectionDetails For Lab -->
		<%for(DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsLabList){
			dgSampleCollectionDtLabEmpty = false;
			String confidential = "";
			if(dgSampleCollectionDetails.getInvestigation().getConfidential() != null 
					&& !dgSampleCollectionDetails.getInvestigation().getConfidential().equals("")
					&& !dgSampleCollectionDetails.getInvestigation().getConfidential().equalsIgnoreCase("n")){
				confidential = "y";
			}else{
				confidential = "n";
			}
			%>
		<%if(confidential.equalsIgnoreCase("y")){ %>
		<tr
			onclick="clearTestDivDown('sampleDtForLab','<%=dgSampleCollectionDetails.getId()%>','<%=dgSampleCollectionDetails.getInvestigation().getInvestigationType()%>','<%=dgSampleCollectionDetails.getOrderStatus()%>','<%=confidential%>');">
			<%}else{ %>
			<tr
				onclick="clearTestDivDown('sampleDtForLab','<%=dgSampleCollectionDetails.getId()%>','<%=dgSampleCollectionDetails.getInvestigation().getInvestigationType()%>','<%=dgSampleCollectionDetails.getOrderStatus()%>','<%=confidential%>');">
				<%} %>
				<!--  			<td><%= dgSampleCollectionDetails.getChargeCode().getChargeCodeCode()%></td> -->
				<td><%= dgSampleCollectionDetails.getInvestigation().getInvestigationName()%></td>
				<!-- 			<td><%= dgSampleCollectionDetails.getMaincharge().getMainChargecodeName()%></td> -->
				<!-- 			<td><%= dgSampleCollectionDetails.getSubcharge().getSubChargecodeName()%></td> -->

				<% if( dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("P")){ %>
				<td>Pending For Sample Validation</td>
				<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("E")){%>
				<td>Result Entered</td>
				<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("A")){%>
				<td>Sample Pending For Result Entry</td>
				<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("X")){%>
				<td>Test Cancelled</td>
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
			<%if(confidential.equalsIgnoreCase("y")){ %>
			<tr style="color: red;"
				onclick="clearTestDivDown('rEntryDetailLab','<%=dgResultEntryDetail.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryDetail.getResultDetailStatus()%>','<%=confidential%>');">
				<%}else{ %>
				<tr
					onclick="clearTestDivDown('rEntryDetailLab','<%=dgResultEntryDetail.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryDetail.getResultDetailStatus()%>','<%=confidential%>');">
					<%} %>

					<!--   		<tr onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId=<%=dgResultEntryDetail.getId()%>&resultType=<%=dgResultEntryDetail.getResultType()%>&orderStatus=<%=dgResultEntryDetail.getResultDetailStatus()%>','testDivDown');"> -->
					<!-- 			<td><%= dgResultEntryDetail.getChargeCode().getChargeCodeCode()%></td> -->
					<td><%= dgResultEntryDetail.getInvestigation().getInvestigationName()%></td>
					<!-- 			<td><%= dgResultEntryDetail.getChargeCode().getMainChargecode().getMainChargecodeName()%></td> -->
					<!-- 			<td><%= dgResultEntryDetail.getChargeCode().getSubChargecode().getSubChargecodeName()%></td> -->

					<% if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %>
					<td>Pending For Result Validation</td>
					<%}else if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("A")){%>
					<td>Result Validated</td>
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
				<%if(confidential.equalsIgnoreCase("y")){ %>
				<tr style="color: red;"
					onclick="clearTestDivDown('rhLab','<%=dgResultEntryHeader.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryHeader.getResultStatus()%>','<%=confidential%>');">
					<%}else{ %>
					<tr
						onclick="clearTestDivDown('rhLab','<%=dgResultEntryHeader.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryHeader.getResultStatus()%>','<%=confidential%>');">
						<%} %>

						<!--	 <tr onclick="window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderLabId=<%=dgResultEntryHeader.getId()%>&resultType=<%=dgResultEntryDetail.getResultType()%>&orderStatus=<%=dgResultEntryHeader.getResultStatus()%>','name','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');"> -->

						<!-- 	 <tr onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryHeaderLabId=<%=dgResultEntryHeader.getId()%>&resultType=<%=dgResultEntryDetail.getResultType()%>&orderStatus=<%=dgResultEntryHeader.getResultStatus()%>','testDivDown');"> -->
						<!--  			<td><%= dgResultEntryDetail.getChargeCode().getChargeCodeCode()%></td> -->
						<td><%= dgResultEntryDetail.getInvestigation().getInvestigationName()%></td>
						<!-- 			<td><%= dgResultEntryHeader.getMainChargecode().getMainChargecodeName()%></td> -->
						<!-- 			<td><%= dgResultEntryHeader.getSubChargecode().getSubChargecodeName()%></td> -->

						<% if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("P")){ %>
						<td>Pending For Result Validation</td>
						<%}else if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("A")){%>
						<td>Result Validated</td>
						<%}%>
					</tr>

					<%} %>

					<!-- Loop for Printing DgResultEntryHeader For Lab Only For Sensitive -->
					<%for(DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderSensitiveLabList){
			dgResultDtEmptyLab = false;
			 DgResultEntryDetailSen dgResultEntryDetailSen = dgResultEntryHeader.getDgResultEntryDetailSen().iterator().next(); 
				String confidential = "";
				if(dgResultEntryDetailSen.getInvestigation().getConfidential() != null 
						&& !dgResultEntryDetailSen.getInvestigation().getConfidential().equals("")
						&& !dgResultEntryDetailSen.getInvestigation().getConfidential().equalsIgnoreCase("n")){
					confidential = "y";
				}else{
					confidential = "n";
				}
			%>
					<%if(confidential.equalsIgnoreCase("y")){ %>
					<tr style="color: red;"
						onclick="clearTestDivDown('rhSenLab','<%=dgResultEntryHeader.getId()%>','v','<%=dgResultEntryHeader.getResultStatus()%>','<%=confidential%>');">
						<%}else{ %>
						<tr
							onclick="clearTestDivDown('rhSenLab','<%=dgResultEntryHeader.getId()%>','v','<%=dgResultEntryHeader.getResultStatus()%>','<%=confidential%>');">
							<%} %>

							<!--  			<td><%= dgResultEntryDetailSen.getInvestigation().getChargeCode().getChargeCodeCode()%></td> -->
							<td><%= dgResultEntryDetailSen.getInvestigation().getInvestigationName()%></td>
							<!-- 			<td><%= dgResultEntryHeader.getMainChargecode().getMainChargecodeName()%></td> -->
							<!-- 			<td><%= dgResultEntryHeader.getSubChargecode().getSubChargecodeName()%></td> -->

							<% if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("P")){ %>
							<td>Pending For Result Validation</td>
							<%}else if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("A")){%>
							<td>Result Validated</td>
							<%}%>
						</tr>

						<%} %>

						<!-- Loop for Printing DgSampleCollectionDetails For Radiology -->
						<%for(DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsList){
			dgSampleCollectionDtEmpty = false;
			String confidential = "";
			if(dgSampleCollectionDetails.getInvestigation().getConfidential() != null 
					&& !dgSampleCollectionDetails.getInvestigation().getConfidential().equals("")
					&& !dgSampleCollectionDetails.getInvestigation().getConfidential().equalsIgnoreCase("n")){
				confidential = "y";
			}else{
				confidential = "n";
			}
			%>
						<%if(confidential.equalsIgnoreCase("y")){ %>
						<tr style="color: red;"
							onclick="clearTestDivDown('sampleCollectionDtRadio','<%=dgSampleCollectionDetails.getId()%>','<%=dgSampleCollectionDetails.getInvestigation().getInvestigationType()%>','<%=dgSampleCollectionDetails.getOrderStatus()%>','<%=confidential%>');">
							<%}else{ %>
							<tr
								onclick="clearTestDivDown('sampleCollectionDtRadio','<%=dgSampleCollectionDetails.getId()%>','<%=dgSampleCollectionDetails.getInvestigation().getInvestigationType()%>','<%=dgSampleCollectionDetails.getOrderStatus()%>','<%=confidential%>');">
								<%} %>

								<!-- 			<td><%= dgSampleCollectionDetails.getChargeCode().getChargeCodeCode()%></td> -->
								<td><%= dgSampleCollectionDetails.getInvestigation().getInvestigationName()%></td>
								<!-- 			<td><%= dgSampleCollectionDetails.getMaincharge().getMainChargecodeName()%></td> -->
								<!-- 			<td><%= dgSampleCollectionDetails.getSubcharge().getSubChargecodeName()%></td> -->

								<% if( dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("P")){ %>
								<td>Pending For Acceptance</td>
								<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("E")){%>
								<td>Report Entered</td>
								<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("A")){%>
								<td>Accepted For Radiological Investigation</td>
								<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("X")){%>
								<td>Test Cancelled</td>
								<%} %>
							</tr>

							<%} %>
							<!-- Loop for Printing DgResultDetails For Radiology-->
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
							<%if(confidential.equalsIgnoreCase("y")){ %>
							<tr style="color: red;"
								onclick="clearTestDivDown('rdRadio','<%=dgResultEntryDetail.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryDetail.getResultDetailStatus()%>','<%=confidential%>');">
								<%}else{ %>
								<tr
									onclick="clearTestDivDown('rdRadio','<%=dgResultEntryDetail.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryDetail.getResultDetailStatus()%>','<%=confidential%>');">
									<%} %>

									<!-- 		<tr onclick="window.open('lab?method=printResultForRadiology&dgResultEntryDetailId=<%=dgResultEntryDetail.getId()%>&resultType=<%=dgResultEntryDetail.getResultType()%>&orderStatus=<%=dgResultEntryDetail.getResultDetailStatus()%>','name','left=100,top=80,height=420,width=820,status=1,scrollbars=1,resizable=1');" -->
									<!--   		<tr onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=printResultForRadiology&dgResultEntryDetailId=<%=dgResultEntryDetail.getId()%>&resultType=<%=dgResultEntryDetail.getResultType()%>&orderStatus=<%=dgResultEntryDetail.getResultDetailStatus()%>','testDivDown');"> -->
									<!--  			<td><%= dgResultEntryDetail.getChargeCode().getChargeCodeCode()%></td> -->
									<td><%= dgResultEntryDetail.getInvestigation().getInvestigationName()%></td>
									<!-- 			<td><%= dgResultEntryDetail.getChargeCode().getMainChargecode().getMainChargecodeName()%></td> -->
									<!-- 			<td><%= dgResultEntryDetail.getChargeCode().getSubChargecode().getSubChargecodeName()%></td> -->

									<% if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %>
									<td>Pending For Report Validation</td>
									<%}else if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("A")){%>
									<td>Report Validated</td>
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


</div>

<div id="testDivDown"></div>


</div>

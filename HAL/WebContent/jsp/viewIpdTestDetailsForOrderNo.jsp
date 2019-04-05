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
<%@page import="java.text.DecimalFormat"%>
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

<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>

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
<h4>Investigation Details For Selected Requisition</h4>

<table width="100%" border="0" cellpadding="2" cellspacing="2"
	class="grid_header">


	<thead>
		<tr>
			<!--   			<td width="5%" class="gridheaderlabel">Test Code</td> -->
			<th>Investigation</th>
			<!--   			<td width="10%" class="gridheaderlabel">Main Test Name</td> -->
			<!--   			<td width="10%" class="gridheaderlabel">Sub Test Name</td> -->
			<th>Result</th>
			<th>UOM</th>
			<th>Normal Range</th>
			<th>Investigation Status</th>
			
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
		<tr
			onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgMasInvestigationId=<%=dgMasInvestigation.getId()%>&resultType=<%=dgMasInvestigation.getInvestigationType()%>&dgOrderdtId=<%=dgOrderdt.getId()%>&orderStatus=<%=dgOrderdt.getOrderStatus()%>','testDivDown');">


			<td><%= dgMasInvestigation.getInvestigationName()%></td>
			<td></td>
			<td></td>
			<td></td>
			<% if(dgOrderdt.getOrderStatus().equalsIgnoreCase("P")){ %>
			<td>Pending For Sample Collection</td>
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
			%>
		<% if(dgSampleCollectionDetails.getRejected() != null){ %>
		<tr
			onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgSampleCollectionDetailLabId=<%=dgSampleCollectionDetails.getId()%>&resultType=<%=dgSampleCollectionDetails.getInvestigation().getInvestigationType()%>&orderStatus=<%=dgSampleCollectionDetails.getOrderStatus()%>&rejectedStatus=<%=dgSampleCollectionDetails.getRejected()%>&rejReason=<%=dgSampleCollectionDetails.getReason()%>','testDivDown');">
			<% }else{ %>
			<tr
				onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgSampleCollectionDetailLabId=<%=dgSampleCollectionDetails.getId()%>&resultType=<%=dgSampleCollectionDetails.getInvestigation().getInvestigationType()%>&orderStatus=<%=dgSampleCollectionDetails.getOrderStatus()%>','testDivDown');">
				<% } %>


				<td><%= dgSampleCollectionDetails.getInvestigation().getInvestigationName()%></td>
				<td></td>
				<td></td>
				<td></td>
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
			<% if(dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %>
			<tr
				onclick="clearTestDivDown('rEntryDetailLab','<%=dgResultEntryDetail.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryDetail.getResultDetailStatus()%>','<%=confidential%>');">
				<!-- <tr onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId=<%=dgResultEntryDetail.getId()%>&resultType=<%=dgResultEntryDetail.getResultType()%>&orderStatus=<%=dgResultEntryDetail.getResultDetailStatus()%>&confidential=<%=confidential%>','testDivDown');"> -->
				<% }else { %>
				<tr
					onclick="clearTestDivDown('rEntryDetailLab','<%=dgResultEntryDetail.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryDetail.getResultDetailStatus()%>','<%=confidential%>');">
					<% } %>

					<td><%= dgResultEntryDetail.getInvestigation().getInvestigationName()%></td>

					<% try{
    	if(dgResultEntryDetail.getInvestigation().getMinNormalValue() != null
    		&& dgResultEntryDetail.getInvestigation().getMaxNormalValue() != null){ 
    		Float minValue = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMinNormalValue());
    		Float maxValue = Float.parseFloat(dgResultEntryDetail.getInvestigation().getMaxNormalValue());
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
					<td><%=dgResultEntryDetail.getResult()%></td>
					<% } 
    }catch(Exception exception){ %>
					<td><%=dgResultEntryDetail.getResult()%></td>
					<% } %>

					<% if(dgResultEntryDetail.getInvestigation().getUom() != null){ %>
					<td><%=dgResultEntryDetail.getInvestigation().getUom().getUomName()%></td>
					<% }else{ %>
					<td>-</td>
					<% } %>
					<% if(dgResultEntryDetail.getInvestigation().getMinNormalValue() != null
    		&& dgResultEntryDetail.getInvestigation().getMaxNormalValue() != null){ 
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
					<td>Result/Report Validated</td>
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
					// System.out.println("Confiden :");
				}else{
					confidential = "n";
				}
			%>
				<% if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("P")){ %>
				<tr
					onclick="clearTestDivDown('rhLab','<%=dgResultEntryHeader.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryHeader.getResultStatus()%>','<%=confidential%>');">
					<!-- 	 <tr onclick="submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryHeaderLabId=<%=dgResultEntryHeader.getId()%>&resultType=<%=dgResultEntryDetail.getResultType()%>&orderStatus=<%=dgResultEntryHeader.getResultStatus()%>&confidential=<%=confidential%>','testDivDown');"> -->
					<% }else { %>
					<tr
						onclick="clearTestDivDown('rhLab','<%=dgResultEntryHeader.getId()%>','<%=dgResultEntryDetail.getResultType()%>','<%=dgResultEntryHeader.getResultStatus()%>','<%=confidential%>');">
						<% } %>

						<td><%= dgResultEntryDetail.getInvestigation().getInvestigationName()%></td>
						<td><span style="color: highlightred;">Click here to
						get Result/Report</span></td>
						<td></td>
						<td></td>
						<% if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("P")){ %>
						<td>Provisional Result/Report</td>
						<%}else if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("A")){%>
						<td>Result/Result Validated</td>
						<%}%>
					
					</tr>

					<%} %>

					<!-- Loop for Printing DgResultEntryHeader For Lab Only For Sensitive -->
					<%
		for(DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderSensitiveLabList){
			dgResultDtEmptyLab = false;
			 DgResultEntryDetailSen dgResultEntryDetailSen = dgResultEntryHeader.getDgResultEntryDetailSen().iterator().next(); 
				String confidential = "";
				// System.out.println("Confi :"+dgResultEntryDetailSen.getInvestigation().getConfidential());
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
						<td><%= dgResultEntryDetailSen.getInvestigation().getInvestigationName()%></td>
						<td><span style="color: highlightred;">Click here to
						get Result/Report</span></td>
						<td></td>
						<td></td>
						<% if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("P")){ %>
						<td>Provisional Result/Report</td>
						<%}else if( dgResultEntryHeader.getResultStatus().equalsIgnoreCase("A")){%>
						<td>Result/Report Validated</td>
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

							<td><%= investigationName%></td>
							<td></td>
							<td></td>
							<td></td>
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
							<td>Test Cancelled</td>
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
								<td><span style="color: highlightred;">Click here to
								get Result/Report</span></td>
								<td></td>
								<td></td>
								<% if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %>
								<td>Provisional Result/Report</td>
								<%}else if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("A")){%>
								<td>Result/Report Validated</td>
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


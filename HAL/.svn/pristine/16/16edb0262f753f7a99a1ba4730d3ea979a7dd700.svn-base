<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : viewOrderNoForUpdateOPD.jsp 
	 * Tables Used         : 
	 * Description         : For OrderBooking For OP .
	 * @author Name        : Dipali
	 * Revision Date:      Revision By: 
	 * @version 1.0  
--%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%@page import="java.net.URL"%>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<script type="text/javascript">
	function checkAll(checkall)
	{
		var c = document.getElementById('counter').value;
		if(checkall.checked ){
			for (var i=1;i <= c;i++)
		 	{
	  			document.getElementById("cancelCheck"+i).checked =true;
	 	  	}	
	 	 }else{
			checkall.checked == false ;
		 	for (var i=1;i <= c;i++)
			{
		  		document.getElementById("cancelCheck"+i).checked =false;
	 		}
	 	}
	}
	function unCheckCheckAll(cancelCheck){
		if(!cancelCheck.checked){
			document.getElementById('checkAllBox').checked = false;
		}
	}
	function selectAtleastOne(){
		if(document.getElementById('checkAllBox').checked){
			return true;
		}
		flag = true;
		counter = document.getElementById('counter').value;
		for(var i = 1; i < counter; i++){
			if(document.getElementById('cancelCheck'+i).checked) 
            { 
            	flag = false;
            	break;
     		}		
  		}
  		if(flag == false)
  		{	
			return true;
		}
		else{
			alert("Check atleat one Test For Cancel !!!!");
			return false;
		}
	}
	
</script>
<%
		Map<String, Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
		List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsLabList = new ArrayList<DgSampleCollectionDetails>();
		List<String> dgMasInvestigationList = new ArrayList<String>();
		Integer inc = 1;
		Integer dgOrderhdId = 0;
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if(detailsMap.get("dgOrderhdId")!=null){
			dgOrderhdId = (Integer)detailsMap.get("dgOrderhdId");
		}
		if(detailsMap.get("dgSampleCollectionDetailsList")!=null){
			dgSampleCollectionDetailsList = (List)detailsMap.get("dgSampleCollectionDetailsList");
		}
		if(detailsMap.get("dgOrderdtList")!=null){
			dgOrderdtList = (List)detailsMap.get("dgOrderdtList");
		}
		if(detailsMap.get("dgSampleCollectionDetailsLabList")!=null){
			dgSampleCollectionDetailsLabList = (List)detailsMap.get("dgSampleCollectionDetailsLabList");
		}
		if(detailsMap.get("dgMasInvestigationList")!=null){
			dgMasInvestigationList = (List)detailsMap.get("dgMasInvestigationList");
		}
		
		Integer initHieght = 97;
		Integer totalSize = 0;
		if(dgOrderdtList!=null ){
			totalSize = totalSize + dgOrderdtList.size();
		}
		if(dgSampleCollectionDetailsList != null ){
			totalSize = totalSize + dgSampleCollectionDetailsList.size();
		}
		if(dgSampleCollectionDetailsLabList.size()>0){
			totalSize = totalSize + dgSampleCollectionDetailsLabList.size();
		}

		for(int i=1 ;i<=totalSize-1 ;i++){
			initHieght = initHieght + 20;
		}

%>
<form name="viewTestDetailsForCancel" method="post" action="">
<div id="contentHolder">
<%if(dgOrderdtList.size() == 0 && dgSampleCollectionDetailsLabList.size() == 0
    		&& dgSampleCollectionDetailsList.size() == 0){ %> <br>
<h3>No Test To Cancel In This Order</h3>
<%}else{ %>
<h6>Test Details For Selected Order</h6>
<br>
<div
	style="overflow: scroll; overflow-x: scroll;  height:<%=initHieght%>px; width: 105%; BORDER: #202020 1px solid;  margin-left: 5px">

<table width="100%" border="0" cellpadding="2" cellspacing="2"
	class="grid_header">


	<thead>
		<tr>
			<td width="2%" class="gridheaderlabel">Test Code</td>
			<td width="70%" class="gridheaderlabel">Test Name</td>
			<td width="10%" class="gridheaderlabel">Main Test Name</td>
			<td width="10%" class="gridheaderlabel">Sub Test Name</td>
			<td width="10%" class="gridheaderlabel">Test Status</td>
			<td width="8%"><label valign="center" class="smalllabel"><input
				type="checkbox" id="checkAllBox" class="checkbox"
				onclick="checkAll(this);" /> Cancel </td>
		</tr>
	</thead>
	<tbody>
		<%
 			
		if (dgOrderdtList != null && dgOrderdtList.size() > 0 
				&& dgMasInvestigationList!=null && dgMasInvestigationList.size()>0)
		{ %>

		<%
 		Iterator<DgOrderdt> dgOrderdtIt = dgOrderdtList.iterator();
		Iterator<String> dgMasInvestigationIt = dgMasInvestigationList.iterator();
		while(dgMasInvestigationIt.hasNext() && dgOrderdtIt.hasNext()){
			String dgMasInvestigationName = dgMasInvestigationIt.next();
			DgOrderdt dgOrderdt = dgOrderdtIt.next();

			%>
		<tr>
			<td><%= dgOrderdt.getChargeCode().getChargeCodeCode()%></td>
			<td><%= dgMasInvestigationName%></td>
			<td><%= dgOrderdt.getMainChargecode().getMainChargecodeName()%></td>
			<td><%= dgOrderdt.getSubChargeid().getSubChargecodeName()%></td>

			<% if(dgOrderdt.getOrderStatus().equalsIgnoreCase("P")){ %>
			<td>Pending For Collection</td>
			<%}else if(dgOrderdt.getOrderStatus().equalsIgnoreCase("C")){%>
			<td>Sample Collected</td>
			<%}else if(dgOrderdt.getOrderStatus().equalsIgnoreCase("A")){%>
			<td>Sample Accepted</td>
			<%}%>
			<td><input type="checkbox" class="check"
				style="margin: 0px 0px 0px 0px; width: 5px; margin-left: 23px;"
				id="cancelCheck<%=inc %>" name="cancelCheckSelected<%=inc%>"
				value="y" onclick="unCheckCheckAll(this)" /></td>

			<input type="hidden" name="idetifierOfId" value="dgOrderdtId"
				MAXLENGTH="50" tabindex=1 size="40" />
			<input type="hidden" name="<%=ALL_TEST_IDS%>"
				value="<%=dgOrderdt.getId()%>" MAXLENGTH="50" tabindex=1 size="40" />
			<input type="hidden" name="<%=ORDER_BOOKING_ID%>"
				value="<%=dgOrderdt.getOrderhd().getId()%>" MAXLENGTH="50"
				tabindex=1 size="40" />
			<input type="hidden" name="<%=CHARGE_CODE_ID%>"
				value="<%=dgOrderdt.getChargeCode().getId()%>" MAXLENGTH="50"
				tabindex=1 size="40" />
		</tr>
		<%inc++; %>
		<%} %>

		<%} %>
		<!-- Loop for Printing DgSampleCollectionDetails For Lab -->
		<%for(DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsLabList){
			%>

		<tr>
			<td><%= dgSampleCollectionDetails.getChargeCode().getChargeCodeCode()%></td>
			<td><%= dgSampleCollectionDetails.getInvestigation().getInvestigationName()%></td>
			<td><%= dgSampleCollectionDetails.getMaincharge().getMainChargecodeName()%></td>
			<td><%= dgSampleCollectionDetails.getSubcharge().getSubChargecodeName()%></td>

			<% if( dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("P")){ %>
			<td>Pending For Sample Validation</td>
			<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("E")){%>
			<td>Result Entered</td>
			<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("A")){%>
			<td>Sample Validated</td>
			<%}%>
			<td><input type="checkbox" class="check"
				style="margin: 0px 0px 0px 0px; width: 5px; margin-left: 23px;"
				id="cancelCheck<%=inc%>" name="cancelCheckSelected<%=inc%>"
				value="y" onclick="unCheckCheckAll(this)" /></td>

			<input type="hidden" name="idetifierOfId"
				value="dgSampleCollectionDetailLabId" MAXLENGTH="50" tabindex=1
				size="40" />
			<input type="hidden" name="<%=ALL_TEST_IDS%>"
				value="<%=dgSampleCollectionDetails.getId()%>" MAXLENGTH="50"
				tabindex=1 size="40" />
			<input type="hidden" name="<%=ORDER_BOOKING_ID%>"
				value="<%=dgSampleCollectionDetails.getSampleCollectionHeader().getId()%>"
				MAXLENGTH="50" tabindex=1 size="40" />
			<input type="hidden" name="<%=CHARGE_CODE_ID%>"
				value="<%=dgSampleCollectionDetails.getChargeCode().getId()%>"
				MAXLENGTH="50" tabindex=1 size="40" />
		</tr>
		<%inc++; %>
		<%} %>

		<!-- Loop for Printing DgSampleCollectionDetails For Radiology -->
		<%for(DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsList){
			%>

		<tr>
			<td><%= dgSampleCollectionDetails.getChargeCode().getChargeCodeCode()%></td>
			<td><%= dgSampleCollectionDetails.getInvestigation().getInvestigationName()%></td>
			<td><%= dgSampleCollectionDetails.getMaincharge().getMainChargecodeName()%></td>
			<td><%= dgSampleCollectionDetails.getSubcharge().getSubChargecodeName()%></td>

			<% if( dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("P")){ %>
			<td>Pending For Acceptance</td>
			<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("E")){%>
			<td>Report Entered</td>
			<%}else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("A")){%>
			<td>Accepted For Radiological Investigation</td>
			<%}%>
			<td><input type="checkbox" class="check"
				style="margin: 0px 0px 0px 0px; width: 5px; margin-left: 23px;"
				id="cancelCheck<%=inc %>" name="cancelCheckSelected<%=inc%>"
				value="y" onclick="unCheckCheckAll(this)" /></td>

			<input type="hidden" name="idetifierOfId"
				value="dgSampleCollectionDetailId" MAXLENGTH="50" tabindex=1
				size="40" />
			<input type="hidden" name="<%=ALL_TEST_IDS%>"
				value="<%=dgSampleCollectionDetails.getId()%>" MAXLENGTH="50"
				tabindex=1 size="40" />
			<input type="hidden" name="<%=ORDER_BOOKING_ID%>"
				value="<%=dgSampleCollectionDetails.getSampleCollectionHeader().getId()%>"
				MAXLENGTH="50" tabindex=1 size="40" />
			<input type="hidden" name="<%=CHARGE_CODE_ID%>"
				value="<%=dgSampleCollectionDetails.getChargeCode().getId()%>"
				MAXLENGTH="50" tabindex=1 size="40" />
		</tr>
		<%inc++; %>
		<%} %>
		<input type="hidden" name="orderHeaderId" value="<%=dgOrderhdId%>"
			MAXLENGTH="50" tabindex=1 size="40" />
		<input type="hidden" name="counter" id="counter" value="<%=inc-1 %>" />
	</tbody>
</table>


</div>
<div class="Clear"></div>
<br>

<input type="button" class="cmnButton" value="Submit"
	onclick="submitForm('viewTestDetailsForCancel','lab?method=submitCancelSelectedTests','selectAtleastOne');"
	align="right" /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="cmnButton" onclick="resetCheck();" accesskey="r" />
<input type="button" class="cmnButton" value="Back"
	onclick="submitForm('viewTestDetailsForCancel','lab?method=cancelOrderBooking');"
	align="right" /> <%} %>
</div>
</form>
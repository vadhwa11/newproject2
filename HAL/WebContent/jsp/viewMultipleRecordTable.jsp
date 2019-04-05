
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%
		int pageNo=1;
		Map<String,Object> map = new HashMap<String,Object>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		List<DgSubMasInvestigation> subList = new ArrayList<DgSubMasInvestigation>();
	    String age = "";
		DgSampleCollectionDetails dgDetails = new DgSampleCollectionDetails();
		List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
		Patient patient = new Patient();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("sampleCollectionList") != null){
			sampleCollectionList=(List)map.get("sampleCollectionList");
		}
		if(map.get("fixedValList") != null){
			fixedValList=(List)map.get("fixedValList");
		}

		if(map.get("subList") != null){
				subList=(List)map.get("subList");
		}

	    if(sampleCollectionList != null && sampleCollectionList.size()>0)
		{
			dgDetails=(DgSampleCollectionDetails) sampleCollectionList.get(0);
			patient = (Patient) dgDetails.getSampleCollectionHeader().getHin();
		}
	%>
<!-- Table Starts -->
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<div class="tableHholderCmnLarge">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Investigation</th>
		<th scope="col">Sample</th>
		<th scope="col">Result</th>
		<th scope="col">UOM</th>
		<th scope="col">Normal Range</th>
		<th scope="col">Additional Remarks</th>
	</tr>
	<tbody>
		<!--  for increment of rows  -->
		<%
	int detailCounter=8; 
	int temp=0;
	int inc =0;   
	if(pageNo!=1)
	{
	temp=detailCounter*(pageNo-1);
	} 
	%>
		<!--  end of increment code  -->
		<!-- for getting sets  -->
		<%
	System.out.println("==========================================================================");	
	Set<DgSubMasInvestigation> subSet = new  HashSet<DgSubMasInvestigation>();
	Set<DgNormalValue>normalSet = new HashSet<DgNormalValue>();
	for(DgSampleCollectionDetails dgDet :sampleCollectionList)
	{
		for(DgSubMasInvestigation dgCollection : subList){
	normalSet = dgCollection.getDgNormalValues();
	System.out.println("normalSet 11              "+normalSet.size());
	%>
		<!--  if condition when result type is heading and comaprison type is none -->
		<%if(dgCollection.getResultType().equalsIgnoreCase("h")&& dgCollection.getComparisonType().equalsIgnoreCase("n")) { %>
		<tr>
			<td>
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				type="hidden" value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<label name="<%=SUBTEST_NAME %>" class="heading"><%=dgCollection.getSubInvestigationName()%></label>
			<input name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <% if(dgCollection.getInvestigation().getSample() != null){ %>
			<input name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <% } %> <%}else{%> <label class="heading"
				name="<%=SUBTEST_NAME %>">-</label> <%} %>
			</td>
			<td><input name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %>" value=""
				type="hidden" /> <label>-</label></td>
			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m"> <input
				type="hidden" name="<%=RESULT%>" id="<%=RESULT %><%=inc %>" value="">
			<input type="hidden" name="<%=FIXED_ID %>"
				id="<%=FIXED_ID %><%=inc %>" value="" /> <label>-</label></td>
			<td><input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" value="" type="hidden" /> <label>-</label></td>
			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden"> <label>-</label></td>
			<td><input type="hidden" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<label>-</label></td>
		</tr>
		<%} %><!-- end of if condition when result type is heading and comaprison type is none -->

		<!-- if condition when result type is single parameter and comparison type is none -->
		<%if(dgCollection.getResultType().equalsIgnoreCase("s") && dgCollection.getComparisonType().equalsIgnoreCase("n")){ %>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 
%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{ %> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>
			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>
			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m">
			</option>
			<input type="text" name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
				maxlength="50">
			</option>
			<input type="hidden" name="<%=FIXED_ID %>"
				id="<%=FIXED_ID %><%=inc %>" value="" /></td>
			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>
			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden"> <label>-</label></td>
			<td>
			<%if(dgDet.getRemarks() != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks() %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %><!--end of if condition when result type is single parameter and comparison type is none -->

		<!-- if condition when result type is   text and comparison type is none -->
		<%if (dgCollection.getResultType().equalsIgnoreCase("t") && dgCollection.getComparisonType().equalsIgnoreCase("n")){ %>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>
			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>
			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m">
			</option>
			<input type="text" name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
				maxlength="50">
			</option>
			<input type="hidden" name="<%=FIXED_ID %>"
				id="<%=FIXED_ID %><%=inc %>" value="" /></td>
			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>
			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden"> <label>-</label></td>
			<td>
			<%if(dgDet.getRemarks() != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks() %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %><!--end of if condition when result type is text and comparison type is none -->

		<!-- if condition when result type is   text Area and comparison type is none -->
		<%if (dgCollection.getResultType().equalsIgnoreCase("m") && dgCollection.getComparisonType().equalsIgnoreCase("n")){ %>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>
			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>
			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m">
			</option>
			<textarea value="" name="<%=RESULT %>" id="<%=RESULT %>"
				maxlength="100" onkeyup="return ismaxlength(this)"></textarea> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>
			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>
			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden"> <label>-</label></td>
			<td>
			<%if(dgDet.getRemarks() != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks() %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %>
		<!--end of if condition when result type is text Area and comparison type is none -->

		<!-- if condition when result type is Range and comparison type is none -->
		<%if (dgCollection.getResultType().equalsIgnoreCase("r") && dgCollection.getComparisonType().equalsIgnoreCase("n")){ %>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>
			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>
			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m"> <input
				type="text" name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
				maxlength="50"> <input type="hidden" name="<%=FIXED_ID %>"
				id="<%=FIXED_ID %><%=inc %>" value="" /></td>
			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>
			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden"> <label>-</label></td>
			<td>
			<%if(dgDet.getRemarks() != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks() %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %>
		<!--end of if condition when result type is Range and comparison type is none -->

		<!-- if condition when result type is single parameter and comparison type is fixed values -->
		<%if(dgCollection.getResultType().equalsIgnoreCase("s") && dgCollection.getComparisonType().equalsIgnoreCase("f")) { %>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>
			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>
			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m">
			</option>
			<input type="hidden" name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" />
				<select id="fixedId<%=inc %>" name="<%= FIXED_ID %>" class="large" tabindex="1" >
					<option value="">Select</option>
					  <% 
					   if(fixedValList != null){ 	
						for (DgFixedValue  dgFixedValue : fixedValList){
					  if(dgCollection.getId().equals(dgFixedValue.getSubInvestigation().getId())){ %>
					  <option value="<%=dgFixedValue.getId ()%>"><%=dgFixedValue.getFixedValue()%></option>
					  <%  }
					  }
					  } %>
		     </select></td>
			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>
			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden"> <label>-</label></td>

			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %><!--end of if condition when result type is single parameter and comparison type is fixed values -->

		<!-- if result type is text area and comparison type is fixed values  -->
		<%if(dgCollection.getResultType().equalsIgnoreCase("m")&& dgCollection.getComparisonType().equalsIgnoreCase("f") ){ %>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m">
			</option>
			<input type="hidden" value="" name="<%=RESULT %>" id="<%=RESULT %>" />
			<select id="fixedId<%=inc %>" name="<%= FIXED_ID %>" class="large"
				tabindex="1">
				<option value="">Select</option>
				<% 
				   if(fixedValList != null){ 	
					for (DgFixedValue  dgFixedValue : fixedValList){
					 if(dgCollection.getId() == dgFixedValue.getSubInvestigation().getId()) %>
				<option value="<%=dgFixedValue.getId ()%>"><%=dgFixedValue.getFixedValue()%></option>
				<%}
				  } %>
			</select></td>
			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden"></td>


			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %><!--end of if condition when result type is text area and comparison type is fixed values-->

		<!-- if result type is text  and comparison type is fixed values -->
		<%if(dgCollection.getResultType().equalsIgnoreCase("t") && dgCollection.getComparisonType().equalsIgnoreCase("f")){ %>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value="<%= dgCollection.getId()%>" type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m"> <input
				type="hidden" value="" name="<%=RESULT %>" id="<%=RESULT %>" /> <select
				id="fixedId<%=inc %>" name="<%= FIXED_ID %>" class="large"
				tabindex="1">
				<option value="">Select</option>
				<% 
				   if(fixedValList != null){ 	
					for (DgFixedValue  dgFixedValue : fixedValList){
					if(dgCollection.getId()== dgFixedValue.getSubInvestigation().getId()){%>
				<option value="<%=dgFixedValue.getId ()%>"><%=dgFixedValue.getFixedValue()%></option>
				<%} 
					}
				  } %>
			</select></td>
			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden"></td>

			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>

		<%} %>
		<!--  end of if result type is text  and comparison type is fixed values -->

		<!-- if result type is range  and comparison type is fixed values -->
		<%if(dgCollection.getResultType().equalsIgnoreCase("r") && dgCollection.getComparisonType().equalsIgnoreCase("f")){ %>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m"> <input
				type="hidden" name="<%=RESULT %>" id="<%=RESULT %><%=inc %>">
			<select id="fixedId<%=inc %>" name="<%= FIXED_ID %>" class="large"
				tabindex="1">
				<option value="">Select</option>
				<% 
				   if(fixedValList != null){ 	
					for (DgFixedValue  dgFixedValue : fixedValList){
						if(dgCollection.getId()== dgFixedValue.getSubInvestigation().getId()){%>
				<option value="<%=dgFixedValue.getId ()%>"><%=dgFixedValue.getFixedValue()%></option>
				<%} 
						}
				  } %>
			</select></td>
			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden"></td>


			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>

		<%} %>
		<!--  end of if result type is range  and comparison type is fixed values -->

		<!--  if result type is single parameter and comaprison type is normal value  and condition MALE -->
		<%if(patient.getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("s") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>
		<%
	String age1 ="";
	age = patient.getAge();
	int index =  age.indexOf(" ");    
	age1 = age.substring(0,index);
	if(normalSet.size()>0) {
	for(DgNormalValue nv :normalSet){
		if(nv.getFromAge() != null && nv.getToAge() != null && !nv.getToAge().equals("") && !nv.getFromAge().equals("")){
			if(nv != null && nv.getSex().equalsIgnoreCase("m")&& Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)< nv.getToAge()){
	 
	
	%>
		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">


			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10" value="" readonly /> <%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>
			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>

		<% }%>
		<%}else if(nv.getSex().equalsIgnoreCase("m")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("m")&& nv.getSex().equalsIgnoreCase("")){ %>){
		%>
		<!--  if patient age is not available  -->
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">


			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10" value="" readonly /> <%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>
			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>
			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<!-- end of code if patient age is not available  -->
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} 
	   %>
		<!--  end of  if result type is single parameter and comaprison type is normal value and condition MALE -->
		<!--  if result type is single parameter and comparison type is normal value  and condition FEMALE -->
		<%if(patient.getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("s") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ 

	String age1 ="";
	age = patient.getAge();
	int index =  age.indexOf(" ");    
	age1 = age.substring(0,index);
	if(normalSet.size()>0) {
	for(DgNormalValue nv :normalSet){
		if(nv.getFromAge() != null && nv.getToAge() != null && !nv.getToAge().equals("") && !nv.getFromAge().equals("")){
			if(nv != null && nv.getSex().equalsIgnoreCase("f")&& Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)< nv.getToAge()){
	%>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>
			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<% }%>
		<%}else if(nv.getSex().equalsIgnoreCase("f")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("f")&& nv.getSex().equalsIgnoreCase("")){ %>){
		%>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>
			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} 
	  
 	%>
		<!--  end of  if result type is single parameter and comaprison type is normal value and condition FEMALE -->

		<!--  if result type is single parameter and comaprison type is normal value  and condition NONE -->
		<%if(patient.getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("s") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%
	String age1 ="";
	age = patient.getAge();
	int index =  age.indexOf(" ");    
	age1 = age.substring(0,index);
	if(normalSet.size()>0) {
	for(DgNormalValue nv :normalSet){
		if(nv.getFromAge() != null && nv.getToAge() != null && !nv.getToAge().equals("") && !nv.getFromAge().equals("")){
			if(nv != null && nv.getSex().equalsIgnoreCase("n")&& Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)< nv.getToAge()){
	%>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">

			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50">
			<input type="hidden" name="<%=FIXED_ID %>"
				id="<%=FIXED_ID %><%=inc %>" value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>

			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<% }%>
		<%}else if(nv.getSex().equalsIgnoreCase("n")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("n")&& nv.getSex().equalsIgnoreCase("")){ %>){
		%>
		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">

			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50">
			<input type="hidden" name="<%=FIXED_ID %>"
				id="<%=FIXED_ID %><%=inc %>" value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>
			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} 
	        
	%>
		<!--  end of  if result type is single parameter and comaprison type is normal value and condition NONE -->

		<!--  if result type is Text Area and comaprison type is normal value  and condition MALE -->
		<%if(patient.getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("m") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%
	String age1 ="";
	age = patient.getAge();
	int index =  age.indexOf(" ");    
	age1 = age.substring(0,index);
	if(normalSet.size()>0) {
	for(DgNormalValue nv :normalSet){
		if(nv.getFromAge() != null && nv.getToAge() != null && !nv.getToAge().equals("") && !nv.getFromAge().equals("")){
			if(nv != null && nv.getSex().equalsIgnoreCase("m")&& Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)< nv.getToAge()){
	 
	
	%>
		<tr>

			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>


			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<% }%>
		<%}else if(nv.getSex().equalsIgnoreCase("m")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("m")&& nv.getSex().equalsIgnoreCase("")){ %>){
		%>
		<tr>

			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>

			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is text area and comaprison type is normal value and condition MALE -->

		<!--  if result type is Text Area and comaprison type is normal value  and condition FEMALE -->
		<%if(patient.getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("m") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%
	String age1 ="";
	age = patient.getAge();
	int index =  age.indexOf(" ");    
	age1 = age.substring(0,index);
	if(normalSet.size()>0) {
	for(DgNormalValue nv :normalSet){
		if(nv.getFromAge() != null && nv.getToAge() != null && !nv.getToAge().equals("") && !nv.getFromAge().equals("")){
			if(nv != null && nv.getSex().equalsIgnoreCase("f")&& Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)< nv.getToAge()){
	%>

		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>
			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<% }%>
		<%}else if(nv.getSex().equalsIgnoreCase("f")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("f")&& nv.getSex().equalsIgnoreCase("")){ %>){
		%>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>



			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is text area and comaprison type is normal value and condition FEMALE-->

		<!--  if result type is Text Area and comaprison type is normal value  and condition NONE -->
		<%if(patient.getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("m") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%
	String age1 ="";
	age = patient.getAge();
	int index =  age.indexOf(" ");    
	age1 = age.substring(0,index);
	if(normalSet.size()>0) {
	for(DgNormalValue nv :normalSet){
		if(nv.getFromAge() != null && nv.getToAge() != null && !nv.getToAge().equals("") && !nv.getFromAge().equals("")){
			if(nv != null && nv.getSex().equalsIgnoreCase("n")&& Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)< nv.getToAge()){
	 
	
	%>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50">
			<input type="hidden" name="<%=FIXED_ID %>"
				id="<%=FIXED_ID %><%=inc %>" value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>
			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<% }%>
		<%}else if(nv.getSex().equalsIgnoreCase("n")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("n")&& nv.getSex().equalsIgnoreCase("")){ %>){
		%>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50">
			<input type="hidden" name="<%=FIXED_ID %>"
				id="<%=FIXED_ID %><%=inc %>" value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>
			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is text area and comaprison type is normal value and condition NONE -->
		<!--  if result type is Text and comaprison type is normal value  and condition MALE  -->
		<%if(patient.getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("t") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ 
	%>
		<%
	String age1 ="";
	age = patient.getAge();
	int index =  age.indexOf(" ");    
	age1 = age.substring(0,index);
	if(normalSet.size()>0) {
	for(DgNormalValue nv :normalSet){
		if(nv.getFromAge() != null && nv.getToAge() != null && !nv.getToAge().equals("") && !nv.getFromAge().equals("")){
			if(nv != null && nv.getSex().equalsIgnoreCase("m")&& Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)< nv.getToAge()){%>

		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>
			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<% }%>
		<%}else if(nv.getSex().equalsIgnoreCase("m")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("m")&& nv.getSex().equalsIgnoreCase("")){ %>){
		%>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>



			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>

		<!--  end of  if result type is text t and comaprison type is normal value and condition MALE -->

		<!--  if result type is Text t and comaprison type is normal value  and condition FEMALE -->
		<%if(patient.getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("t") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%
	String age1 ="";
	age = patient.getAge();
	int index =  age.indexOf(" ");    
	age1 = age.substring(0,index);
	if(normalSet.size()>0) {
	for(DgNormalValue nv :normalSet){
		if(nv.getFromAge() != null && nv.getToAge() != null && !nv.getToAge().equals("") && !nv.getFromAge().equals("")){
			if(nv != null && nv.getSex().equalsIgnoreCase("f")&& Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)< nv.getToAge()){
			%>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50">
			<input type="hidden" name="<%=FIXED_ID %>"
				id="<%=FIXED_ID %><%=inc %>" value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>

			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<% }%>
		<%}else if(nv.getSex().equalsIgnoreCase("f")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("f")&& nv.getSex().equalsIgnoreCase("")){ %>){
		%>

		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50">
			<input type="hidden" name="<%=FIXED_ID %>"
				id="<%=FIXED_ID %><%=inc %>" value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>

			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is text t and comaprison type is normal value and condition FEMALE-->

		<!--  if result type is Text and comaprison type is normal value  and condition NONE -->
		<%if(patient.getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("t") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%
	String age1 ="";
	age = patient.getAge();
	int index =  age.indexOf(" ");    
	age1 = age.substring(0,index);
	if(normalSet.size()>0) {
	for(DgNormalValue nv :normalSet){
		if(nv.getFromAge() != null && nv.getToAge() != null && !nv.getToAge().equals("") && !nv.getFromAge().equals("")){
			if(nv != null && nv.getSex().equalsIgnoreCase("n")&& Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)< nv.getToAge()){
	%>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50">
			<input type="hidden" name="<%=FIXED_ID %>"
				id="<%=FIXED_ID %><%=inc %>" value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>

			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<% }%>
		<%}else if(nv.getSex().equalsIgnoreCase("n")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("n")&& nv.getSex().equalsIgnoreCase("")){ %>){
		%>
		<tr>

			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50">
			<input type="hidden" name="<%=FIXED_ID %>"
				id="<%=FIXED_ID %><%=inc %>" value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>

			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is text and comaprison type is normal value and condition NONE -->

		<!--  if result type is Range and comaprison type is normal value  and condition MALE -->
		<%if(patient.getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("r") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%
	String age1 ="";
	age = patient.getAge();
	int index =  age.indexOf(" ");    
	age1 = age.substring(0,index);
	if(normalSet.size()>0) {
	for(DgNormalValue nv :normalSet){
		if(nv.getFromAge() != null && nv.getToAge() != null && !nv.getToAge().equals("") && !nv.getFromAge().equals("")){
			if(nv != null && nv.getSex().equalsIgnoreCase("m")&& Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)< nv.getToAge()){
	%>
		<tr>

			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>

			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<% }%>
		<%}else if(nv.getSex().equalsIgnoreCase("m")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("m")&& nv.getSex().equalsIgnoreCase("")){ %>){
		%>
		<tr>

			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>

			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is range and comaprison type is normal value and condition MALE -->

		<!--  if result type is Range and comaprison type is normal value  and condition FEMALE -->
		<%if(patient.getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("r") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%
	String age1 ="";
	age = patient.getAge();
	int index =  age.indexOf(" ");    
	age1 = age.substring(0,index);
	if(normalSet.size()>0) {
	for(DgNormalValue nv :normalSet){
		if(nv.getFromAge() != null && nv.getToAge() != null && !nv.getToAge().equals("") && !nv.getFromAge().equals("")){
			if(nv != null && nv.getSex().equalsIgnoreCase("f")&& Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)< nv.getToAge()){
	%>
		<tr>

			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>

			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<% }%>
		<%}else if(nv.getSex().equalsIgnoreCase("f")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("f")&& nv.getSex().equalsIgnoreCase("")){ %>){
		%>
		<tr>

			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>

			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is range and comaprison type is normal value and condition FEMALE-->

		<!--  if result type is range and comaprison type is normal value  and condition NONE -->
		<%if(patient.getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("r") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%
	String age1 ="";
	age = patient.getAge();
	int index =  age.indexOf(" ");    
	age1 = age.substring(0,index);
	if(normalSet.size()>0) {
	for(DgNormalValue nv :normalSet){
		if(nv.getFromAge() != null && nv.getToAge() != null && !nv.getToAge().equals("") && !nv.getFromAge().equals("")){
			if(nv != null && nv.getSex().equalsIgnoreCase("n")&& Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)< nv.getToAge()){
	 
	
	%>
		<tr>

			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>

			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<% }%>
		<%}else if(nv.getSex().equalsIgnoreCase("n")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("n")&& nv.getSex().equalsIgnoreCase("")){ %>){
		%>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID 

%><%=inc %>">
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
					if(!nv.getNormalValue().equals("")){
				%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
					} 
				else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="" readonly /><label>-</label> <%} %>
			</td>
			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200"> <%}else{ %>
			<input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
			<%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is range and comaprison type is normal value and condition NONE -->
		<!-- end for sets -->
		<%	}
	} %>
	</tbody>
</table>
</div>
<!-- Table Ends -->

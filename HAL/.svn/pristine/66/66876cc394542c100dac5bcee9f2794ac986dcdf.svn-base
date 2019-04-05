
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%
		int pageNo=1;
		Map<String,Object> map = new HashMap<String,Object>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		List<List<DgFixedValue>> allFixedValueList = new ArrayList<List<DgFixedValue>>();

		List<String> resultSeqNoList = new ArrayList<String>();
	    String age = "";

	    int resultEntryIndex = 0;
	    int resultEntryIndexTemp= 0; 
	    int srNoCounter = 0;
	    char subCounter = 97;
	    Integer resultEntryIndexForMultiple = 0;
	    
		DgSampleCollectionDetails dgDetails = new DgSampleCollectionDetails();
		DgSampleCollectionDetails dgDet = new DgSampleCollectionDetails();
		List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
		Patient patient = new Patient();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("sampleCollectionList") != null){
			sampleCollectionList=(List)map.get("sampleCollectionList");
		}
		if(request.getParameter("resultEntryIndex") != null){
			resultEntryIndex = Integer.parseInt(request.getParameter("resultEntryIndex"));
			resultEntryIndexTemp =  resultEntryIndex;
		}
		if(request.getParameter("srNoCounter") != null){
			srNoCounter = Integer.parseInt(request.getParameter("srNoCounter"));
			
		}

		if(map.get("allFixedValueList") != null){
			allFixedValueList=(List)map.get("allFixedValueList");
		}
		if(map.get("resultSeqNoList") != null){
			resultSeqNoList = (List<String>)map.get("resultSeqNoList");
		}
		if(allFixedValueList.size() > 0 ){
			fixedValList = allFixedValueList.get(resultEntryIndex);
		}
		if(request.getParameter("resultEntryIndexForMultiple") != null){
			resultEntryIndexForMultiple = Integer.parseInt(request.getParameter("resultEntryIndexForMultiple"));
		}

	    if(sampleCollectionList != null && sampleCollectionList.size()>0)
		{
			dgDetails=(DgSampleCollectionDetails) sampleCollectionList.get(0);
			dgDet =(DgSampleCollectionDetails) sampleCollectionList.get(resultEntryIndex);
			patient = (Patient) dgDetails.getSampleCollectionHeader().getHin();
		}
	%>
<!-- Table Starts -->
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="jkt.hms.masters.business.Patient"%>



<!--  for increment of rows  -->
<%
	int detailCounter=8; 
	int temp=0;
	int inc = resultEntryIndexForMultiple;
	
	if(pageNo!=1)
	{
	temp=detailCounter*(pageNo-1);
	} 
	%>
<!--  end of increment code  -->
<!-- for getting sets  -->
<%
	Set<DgSubMasInvestigation> subSet = new  HashSet<DgSubMasInvestigation>();
	Set<DgNormalValue>normalSet = new HashSet<DgNormalValue>();
	//while(sampleCollectionList.get(resultEntryIndexTemp).getInvestigation().getInvestigationType()
	//		.equalsIgnoreCase("m")){ 
	//}
	//for(DgSampleCollectionDetails dgDet :sampleCollectionList)
	//{ 
		dgDet = sampleCollectionList.get(resultEntryIndexTemp);
		subCounter = 97;

		Set<DgSubMasInvestigation> subSet1 = new LinkedHashSet<DgSubMasInvestigation>();
		Set<DgSubMasInvestigation> subSet2  = dgDet.getInvestigation().getDgSubMasInvestigations();
		Set<DgSubMasInvestigation> linkedHashSet = DgSubMasInvestigationComparatorByOrderNo.getApplicationTreeSet(); 
		
		for(DgSubMasInvestigation dgSubMasInvestigation : subSet2){
			linkedHashSet.add(dgSubMasInvestigation);
		}
		subSet1.addAll(linkedHashSet);
		map.put("subSet1",subSet1);
		%>
<%@page import="jkt.hms.util.DgSubMasInvestigationComparatorByOrderNo"%>
<input type="hidden" name="srNo1" value="<%=srNoCounter-1%>">
<tr>
	<td><label name="<%=SR_NO%>"><%=srNoCounter%></label>
	
	
	</td>
	<td>
	<%if(dgDet.getDiagNo() != null){ %> <label name=<%=DIAGNOSIS_NO %>
		id=<%=DIAGNOSIS_NO %>><%=dgDet.getDiagNo() %></label> <%}else{ %> <label
		name=<%=DIAGNOSIS_NO %> id=<%=DIAGNOSIS_NO %>>-</label> <%} %>
	</td>
	<td><label name="<%=INVESTIGATION_NAME%>"style="font-weight: bold;"><%=dgDet.getInvestigation().getInvestigationName() %></label> 
	<input type="hidden" name="<%=TEST_ORDER_NO_MULTIPLE_VALUE%>"	value="<%=(dgDet.getInvestigation().getTestOrderNo()!=null?dgDet.getInvestigation().getTestOrderNo():"")%>"></input>
	</td>
	<td><input type="hidden" name="HeaderCountFlag"	id="HeaderCountFlag" value="HeaderCountFlag" /></td>
	<td><input type="hidden" name="<%=RESULT_NO_FOR_MULTIPLE_VALUE%>"	value="<%=resultSeqNoList.get(resultEntryIndexTemp) %>"	title="Result No." /></td>
	
	<td><input type="hidden" name="<%=SUB_TEST_SIZE%>"	id="<%=SUB_TEST_SIZE %>" value="<%=subSet1.size()%>" /> 
	<input	type="hidden" name="<%=ADDITIONAL_REMARKS%>"id="<%=ADDITIONAL_REMARKS %>" value="" /> 
	<input type="hidden"name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID %>" value="" /> 
	<input	type="hidden" name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID %>" value="" />
	<input type="hidden" name="<%=NORMAL_ID%>" id="<%=NORMAL_ID %>"	value="" /> 
	<input type="hidden" name="<%=FIXED_ID%>"id="<%=FIXED_ID %>" value="" /> 
	<input type="hidden"name="<%=UNIT_OF_MEASUREMENT_ID%>" id="<%=UNIT_OF_MEASUREMENT_ID %>"	value="" /> 
	<input type="hidden" name="<%=RESULT_TYPE%>"	id="<%=RESULT_TYPE %>" value="" /> 
	<input type="hidden"name="<%=INVESTIGATION_ID%>" id="<%=INVESTIGATION_ID %>" value="" />
	<input type="hidden" name="<%=DG_SAMPLE_DETAIL_ID%>"id="<%=DG_SAMPLE_DETAIL_ID %>" value="" />
	</td>
	<td><input type="hidden" name="<%=RESULT%>"	id="<%=RESULT%><%=inc%>" value="TestRowFlag" /></td>
	<td>&nbsp;</td>
	<td><input type="checkbox" name="sampleRejected<%=inc %>" value="y" /></td>
	<% inc++; %>

</tr>

<%
int i=0;
		for(DgSubMasInvestigation dgCollection : subSet1){
			System.out.println("dgCollectionsize="+subSet1.size());
			i++;
	normalSet = dgCollection.getDgNormalValues();
	System.out.println("normalSetFirst="+normalSet.size());
	
	%>
<!--  if condition when result type is heading and comaprison type is none -->
<!-- end of if condition when result type is heading and comaprison type is none -->

<!-- if condition when result type is single parameter and comparison type is none -->
<input name="chargeCodeCodeForPerticularTestForMultiple" id="chargeCodeCodeForPerticularTestForMultiple<%=srNoCounter %><%=subCounter %>"value="<%= dgCollection.getInvestigation().getChargeCode().getChargeCodeCode()%>"	type="hidden">
<input name="resultNumericOrStringForMultiple"	id="resultNumericOrStringForMultiple<%=srNoCounter %><%=subCounter %>"	value="<%= dgCollection.getInvestigation().getNumericOrString()%>"	type="hidden">
<jsp:include page="sResulType.jsp" flush="true">
<jsp:param name="countLoop" value="<%=i%>" />
<jsp:param name="srNoCounter" value="<%=srNoCounter%>" />
<jsp:param name="subCounter" value="<%=subCounter%>" />
<jsp:param name="inc" value="<%=inc%>" /> 
<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />

</jsp:include> 

<!--  if result type is Text Area and comparison type is normal value  and condition MALE -->
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
	<!--<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
	<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>
	<td><input type="hidden" value="<%=dgCollection.getInvestigation().getId() %>"	name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
	<input type="hidden" value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"	name="<%=CHARGE_CODE_ID %>" id="<%=CHARGE_CODE_ID%><%=inc %>">
	<%
	if(dgCollection.getSubInvestigationName() != null){ %> 
	<input	name="<%=SUBTEST_NAME %>" type="text" value="<%=dgCollection.getSubInvestigationName()%>" readonly /> 
	<input	name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"	value=<%= dgCollection.getId()%> type="hidden"> 
	<input	name="<%=DG_SAMPLE_DETAIL_ID %>" id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>	type="hidden"> 
	<%}else{%> 
	<input name="<%=SUBTEST_ID %>"	id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> 
	<input	name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> 
	<%} %>
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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>

	<td>
	<%if(dgCollection.getUom()!= null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
		value="<%=dgCollection.getUom().getId()%>" type="hidden"> <input
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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<% }%>
<%}else if(nv.getSex().equalsIgnoreCase("m")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("m")&& nv.getSex().equalsIgnoreCase("")){ %>
<tr>
	<!--<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
	<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>


	<td><input type="hidden"
		value="<%=dgCollection.getInvestigation().getId() %>"
		name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
	<input type="hidden"
		value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
		name="<%=CHARGE_CODE_ID %>" id="<%=CHARGE_CODE_ID%><%=inc %>">
	<%if(dgCollection.getSubInvestigationName() != null){ %> <input
		name="<%=SUBTEST_NAME %>" type="text"
		value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
		name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
		value="<%=dgCollection.getId()%>" type="hidden"> <input
		name="<%=DG_SAMPLE_DETAIL_ID %>"
		id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
		type="hidden"> <%}else{%> <input name="<%=SUBTEST_ID %>"
		id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
		name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
	</td>

	<td>
	<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
		name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
		value="<%= dgCollection.getInvestigation().getSample().getId()%>"
		type="hidden"> <input name="<%=SAMPLE_NAME %>" type="text"
		size="10"
		value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
		readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
		id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>
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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
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

<tr><!--
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
	<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>

	<td><input type="hidden"
		value="<%=dgCollection.getInvestigation().getId() %>"
		name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
	<input type="hidden"
		value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
		name="<%=CHARGE_CODE_ID %>" id="<%=CHARGE_CODE_ID%><%=inc %>">
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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>
	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>
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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<% }%>
<%}else if(nv.getSex().equalsIgnoreCase("f")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("f")&& nv.getSex().equalsIgnoreCase("")){ %>
<tr>
	<!--<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
	<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>

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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>

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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
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
	<!--<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
	<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>

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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>

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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<% }%>
<%}else if(nv.getSex().equalsIgnoreCase("n")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("n")&& nv.getSex().equalsIgnoreCase("")){ %>
<tr>
	<!--<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
	<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>

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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>

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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
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
	<!--<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
		<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>


	<td><input type="hidden"
		value="<%=dgCollection.getInvestigation().getId() %>"
		name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
	<input type="hidden"
		value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
		name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID%><%=inc %>"> <%if(dgCollection.getSubInvestigationName() != null){ %>
	<input name="<%=SUBTEST_NAME %>oioio" type="text"
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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>

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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<% }%>
<%}else if(nv.getSex().equalsIgnoreCase("m")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("m")&& nv.getSex().equalsIgnoreCase("")){ %>
<tr><!--
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
		<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>


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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>

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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
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
<tr><!--
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
		<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>

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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>

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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<% }%>
<%}else if(nv.getSex().equalsIgnoreCase("f")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("f")&& nv.getSex().equalsIgnoreCase("")){ %>
<tr>
	<!--<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
		<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>

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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>

	<td>
	<%if(dgCollection.getUom()!= null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
		value="<%=dgCollection.getUom().getId()%>" type="hidden"> <input
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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
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
	<!--<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
		<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>

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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>

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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<% }%>
<%}else if(nv.getSex().equalsIgnoreCase("n")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("n")&& nv.getSex().equalsIgnoreCase("")){ %>
<tr>
	<!--<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
		<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>


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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>

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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<%} %>
<%} %>
<%} %>
<%} %>
<%} %>
<!--  end of  if result type is text and comaprison type is normal value and condition NONE -->

<!--  if result type is Range and comaprison type is normal value  and condition MALE -->
<%if(patient.getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
<%if(dgCollection.getResultType().equalsIgnoreCase("r") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ 
	System.out.println("in if  r and v");
%>

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
	<!--<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
		<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>


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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>

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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<% }%>
<%}else if(nv.getSex().equalsIgnoreCase("m")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("m")&& nv.getSex().equalsIgnoreCase("")){ %>
<tr>
	<!--<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
	<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>


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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>

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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<%} %>
<%} %>
<%} %>
<%} %>
<%} %>
<!--  end of  if result type is range and comaprison type is normal value and condition MALE -->

<!--  if result type is Range and comaprison type is normal value  and condition FEMALE -->

<!--  end of  if result type is range and comaprison type is normal value and condition FEMALE-->

<!--  if result type is range and comaprison type is normal value  and condition NONE -->
<%if(patient.getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
<%if(dgCollection.getResultType().equalsIgnoreCase("r") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ 

%>

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
	<!--<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
	<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>


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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>

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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<% }%>
<%}else if(nv.getSex().equalsIgnoreCase("n")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("n")&& nv.getSex().equalsIgnoreCase("")){ %>
<tr>
	<!--<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	-->
	<td><label>(<%=subCounter %>)</label></td>
	<td><label>---</label></td>

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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>

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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<%} %>
<%} %>
<%} %>
<%} %>
<%} %>
<!--  end of  if result type is range and comaprison type is normal value and condition NONE -->
<!-- end for sets -->
<% 	inc++;subCounter++;
		}
	//inc++;srNoCounter++;
	srNoCounter++;
	//resultEntryIndexTemp++;
	//if(resultEntryIndexTemp > sizeOfList-1 ){
		//break;
	//}
	//} 
	%>

<!-- Table Ends -->

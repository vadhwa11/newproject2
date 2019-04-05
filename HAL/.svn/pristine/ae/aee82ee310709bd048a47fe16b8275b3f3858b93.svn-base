
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.DgSubMasInvestigationComparatorByOrderNo"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%

Map<String,Object> map = new HashMap<String,Object>();
List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
List<List<DgFixedValue>> allFixedValueList = new ArrayList<List<DgFixedValue>>();
Set<DgNormalValue>normalSet = new HashSet<DgNormalValue>();
DgSubMasInvestigation dgCollection=new DgSubMasInvestigation();
String age = "";
int srNoCounter =0;
char subCounter =97;
int inc=0;
int resultEntryIndex = 0;
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

DgSampleCollectionDetails dgDetails = new DgSampleCollectionDetails();
DgSampleCollectionDetails dgDet = new DgSampleCollectionDetails();
List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
Patient patient = new Patient();


Set<DgSubMasInvestigation> subSet1 = new LinkedHashSet<DgSubMasInvestigation>();
if(map.get("subSet1")!=null)
{
	subSet1=(Set<DgSubMasInvestigation>)map.get("subSet1");
	}

if(request.getParameter("subCounter") != null){
	Object obj=new Object();
	obj=(Object)request.getParameter("subCounter");
	String str = obj.toString();
	subCounter = str.charAt(0);
	}
if(request.getParameter("srNoCounter") != null){
	srNoCounter = Integer.parseInt(request.getParameter("srNoCounter"));
	
}
if(request.getParameter("inc") != null){
	inc = Integer.parseInt(request.getParameter("inc"));
	
}
if(map.get("sampleCollectionList") != null){
	sampleCollectionList=(List)map.get("sampleCollectionList");
}
if(map.get("allFixedValueList") != null){
	allFixedValueList=(List)map.get("allFixedValueList");
}
if(request.getParameter("resultEntryIndex") != null){
	resultEntryIndex = Integer.parseInt(request.getParameter("resultEntryIndex"));
	
}

if(sampleCollectionList != null && sampleCollectionList.size()>0)
{
	dgDetails=(DgSampleCollectionDetails) sampleCollectionList.get(0);
	dgDet =(DgSampleCollectionDetails) sampleCollectionList.get(resultEntryIndex);
	patient = (Patient) dgDetails.getSampleCollectionHeader().getHin();
}

int PaientAge=0;
	
	if(patient.getDateOfBirth() != null)
	{
		Date date_of_birth= patient.getDateOfBirth();
		PaientAge = HMSUtil.calculateAgeInYears(date_of_birth);
	}
if(allFixedValueList.size() > 0 ){
	fixedValList = allFixedValueList.get(resultEntryIndex);
}
if(subSet1 != null){
	int j=0;
	int countLoop=0;
	Iterator itr= subSet1.iterator();
	
	if(request.getParameter("countLoop")!=null)
	{
		countLoop=Integer.parseInt(request.getParameter("countLoop"));
	}
	while(itr.hasNext())
	{
		j++;
		if(countLoop==j)
		{
		 dgCollection =(DgSubMasInvestigation)itr.next();
		 break;
		}
		itr.next();
		
	}
	
	
	}
%>




<%
if(dgCollection!=null)
{
	normalSet = dgCollection.getDgNormalValues();
if(dgCollection.getResultType().equalsIgnoreCase("s") && dgCollection.getComparisonType().equalsIgnoreCase("n")){ %>
<tr>
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
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
		type="hidden"> <%}else{ %> <input name="<%=SUBTEST_ID %>"
		id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> <input
		name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
	</td>
	<td>
	<%
	
	if(dgCollection.getInvestigation()!=null && dgCollection.getInvestigation().getSample() != null){ %> <input
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
		id="<%=RESULT_TYPE %><%=inc %>" value="m">
	</option>
	<input type="text" name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
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
	<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
		value="" type="hidden"> <label>-</label></td>
	<td>
	<%if(dgDet.getRemarks() != null){ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks() %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<%} %><!--end of if condition when result type is single parameter and comparison type is none -->

<!-- if condition when result type is   text and comparison type is none -->
<%if (dgCollection.getResultType().equalsIgnoreCase("t") && dgCollection.getComparisonType().equalsIgnoreCase("n")){ %>
<tr>
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	<td><label>---</label></td>
	<td><input type="hidden"
		value="<%=dgCollection.getInvestigation().getId() %>"
		name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
	<input type="hidden"
		value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
		name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID%><%=inc %>"> <%if(dgCollection.getSubInvestigationName() != null){ %>
	<input name="<%=SUBTEST_NAME %>" type="text"
		value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
		name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
		value=<%= dgCollection.getId()%> type="hidden"> <input
		name="<%=DG_SAMPLE_DETAIL_ID %>"
		id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value="<%=dgDet.getId()%>"
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
		id="<%=RESULT_TYPE %><%=inc %>" value="m"> <input type="text"
		name="<%=RESULT %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		id="<%=RESULT %><%=inc %>" tabindex="1" maxlength="50" /> <input
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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks() %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<%} %><!--end of if condition when result type is text and comparison type is none -->

<!-- if condition when result type is   text Area and comparison type is none -->
<%if (dgCollection.getResultType().equalsIgnoreCase("m") && dgCollection.getComparisonType().equalsIgnoreCase("n")){ %>
<tr>
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	<td><label>---</label></td>
	<td><input type="hidden"
		value="<%=dgCollection.getInvestigation().getId() %>"
		name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
	<input type="hidden"
		value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
		name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID%><%=inc %>"> <%if(dgCollection.getSubInvestigationName() != null){ %>
	<input name="<%=SUBTEST_NAME %>" type="text"
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
		id="<%=RESULT_TYPE %><%=inc %>" value="m">
	</option>
	<input type="text" name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
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
	<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
		value="" type="hidden"> <label>-</label></td>
	<td>
	<%if(dgDet.getRemarks() != null){ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks() %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<%} %>
<!--end of if condition when result type is text Area and comparison type is none -->

<!-- if condition when result type is Range and comparison type is none -->
<%if (dgCollection.getResultType().equalsIgnoreCase("r") && dgCollection.getComparisonType().equalsIgnoreCase("n")){ %>
<tr>
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	<td><label>---</label></td>
	<td><input type="hidden"
		value="<%=dgCollection.getInvestigation().getId() %>"
		name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
	<input type="hidden"
		value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
		name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID%><%=inc %>"> <%if(dgCollection.getSubInvestigationName() != null){ %>
	<input name="<%=SUBTEST_NAME %>" type="text"
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
		id="<%=RESULT_TYPE %><%=inc %>" value="m"> <input type="text"
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
	<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
		value="" type="hidden"> <label>-</label></td>
	<td>
	<%if(dgDet.getRemarks() != null){ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks() %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<%} %>
<!--end of if condition when result type is Range and comparison type is none -->

<!-- if condition when result type is single parameter and comparison type is fixed values -->
<%if(dgCollection.getResultType().equalsIgnoreCase("s") && dgCollection.getComparisonType().equalsIgnoreCase("f")) {

System.out.println("in if    s and f");
%>
<tr>
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	<td><label>---</label></td>
	<td><input type="hidden" value="<%=dgCollection.getInvestigation().getId() %>"	name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
	<input type="hidden" value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"	name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID%><%=inc %>"> 
	<%if(dgCollection.getSubInvestigationName() != null){ %>
	<input name="<%=SUBTEST_NAME %>" type="text" value="<%=dgCollection.getSubInvestigationName()%>" readonly /> 
	<input	name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"	value=<%= dgCollection.getId()%> type="hidden"> 
	<input	name="<%=DG_SAMPLE_DETAIL_ID %>" id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%> type="hidden"> 
	<%}else{%> 
	<input name="<%=SUBTEST_ID %>"	id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden"> 
	<input	name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> 
	<%} %>
	</td>
	<td>
	<%if(dgCollection.getInvestigation().getSample() != null){ %> 
	<input	name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"	value=<%= dgCollection.getInvestigation().getSample().getId()%>	type="hidden"> 
	<input name="<%=SAMPLE_NAME %>" type="text"	size="10"	value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"	readonly /> 
	<%}else{ %> 
	<input name="<%=SAMPLE_ID %>"	id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> 
	<input	name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> 
	<%} %>
	</td>
	<td><input type="hidden" name="<%=RESULT_TYPE%>"id="<%=RESULT_TYPE %><%=inc %>" value="m">

	<input type="hidden" name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"	onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"	tabindex="1" maxlength="50" /> 
	<select id="fixedId<%=inc %>"	name="<%= FIXED_ID %>" tabindex="1">
		<option value="">Select</option>
		<% 
					   if(fixedValList != null){ 	
						for (DgFixedValue  dgFixedValue : fixedValList){
					  if(dgCollection.getId().equals(dgFixedValue.getSubInvestigation().getId())){ %>
		<option value="<%=dgFixedValue.getId ()%>"><%=dgFixedValue.getFixedValue()%></option>
		<%  }
					  }
					  } %>
	</select>
	</td>
	<td>
	<%if(dgCollection.getUom()!= null){ %> 
	<input	name="<%=UNIT_OF_MEASUREMENT_ID %>"	id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"	value=<%=dgCollection.getUom().getId()%> type="hidden"> 
	<input	name="unitName" type="text" size="8" value="<%=dgCollection.getUom().getUomName()%>" readonly /> 
	<%}else{ %>
	<input name="<%=UNIT_OF_MEASUREMENT_ID %>"	id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden">
	<input name="unitName" type="text" size="8" value="" readonly /> 
	<%} %>
	</td>
	<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"	value="" type="hidden">-</td>

	<td>
	<%if(dgDet.getRemarks()  != null){ %> 
	<input type="text"	name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"	id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"	maxlength="200"> 
	<%}else{ %> 
	<input type="text"	name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"	id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m">
	</option>
	<input type="hidden" name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <select id="fixedId<%=inc %>"
		name="<%= FIXED_ID %>" tabindex="1">
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
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()  %>"
		maxlength="200"> <%}else{ %> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
	<%} %>
	</td>
	<td>&nbsp;</td>
</tr>
<%} %><!--end of if condition when result type is text area and comparison type is fixed values-->

<!-- if result type is text  and comparison type is fixed values -->
<%if(dgCollection.getResultType().equalsIgnoreCase("t") && dgCollection.getComparisonType().equalsIgnoreCase("f")){ %>
<tr>
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	<td><label>---</label></td>

	<td><input type="hidden"
		value="<%=dgCollection.getInvestigation().getId() %>"
		name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
	<input type="hidden"
		value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
		name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID%><%=inc %>"> <%if(dgCollection.getSubInvestigationName() != null){ %>
	<input name="<%=SUBTEST_NAME %>" type="text"
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
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>
	<td><input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE %><%=inc %>" value="m"> <input
		type="hidden" name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <select id="fixedId<%=inc %>"
		name="<%= FIXED_ID %>" tabindex="1">
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
<!--  end of if result type is text  and comparison type is fixed values -->

<!-- if result type is range  and comparison type is fixed values -->
<%if(dgCollection.getResultType().equalsIgnoreCase("r") && dgCollection.getComparisonType().equalsIgnoreCase("f")){ %>
<tr>
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	<td><label>---</label></td>

	<td><input type="hidden"
		value="<%=dgCollection.getInvestigation().getId() %>"
		name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
	<input type="hidden"
		value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
		name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID%><%=inc %>"> <%if(dgCollection.getSubInvestigationName() != null){ %>
	<input name="<%=SUBTEST_NAME %>" type="text"
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
		id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="hidden"
		name="<%=RESULT %>" id="<%=RESULT %><%=inc %>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
		tabindex="1" maxlength="50" /> <select id="fixedId<%=inc %>"
		name="<%= FIXED_ID %>" tabindex="1">
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
<!--  end of if result type is range  and comparison type is fixed values -->


<!-- if result type is heading  and comparison type is none -->
<%if(dgCollection.getResultType().equalsIgnoreCase("h") && dgCollection.getComparisonType().equalsIgnoreCase("n")){ %>
<tr>
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	<td> <label>-</label></td>
	<td>
			<%
				if (dgCollection.getSubInvestigationName() != null) {
			%> <input type="hidden"
			value="<%=dgCollection.getInvestigation().getId()%>"
			name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>">
				<label name="<%=SUBTEST_NAME%>" class="heading"><%=dgCollection.getSubInvestigationName()%></label>
				<input name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID%><%=inc%>"
				value=<%=dgCollection.getId()%> type="hidden"> <input
					name="<%=DG_SAMPLE_DETAIL_ID%>"
					id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
					type="hidden"> <%
 	} else {
 %> <label class="heading" name="<%=SUBTEST_NAME%>">-</label> <%
 	}
 %>
		</td>

	<td>
	<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
		name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
		value=<%= dgCollection.getInvestigation().getSample().getId()%>
		type="hidden"> <input name="<%=SAMPLE_NAME %>" type="hidden"
		size="10"
		value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
		readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
		id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"> <input
		name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly /> <%} %>
	</td>

	
	<td><input type="hidden" name="<%=RESULT_TYPE%>"
			id="<%=RESULT_TYPE%><%=inc%>" value="m"> <input type="hidden"
				name="<%=RESULT%>" id="<%=RESULT%><%=inc%>" value="0"> <input
					type="hidden" name="<%=FIXED_ID%>" id="<%=FIXED_ID%><%=inc%>"
					value="" /> <label>-</label></td>
	<td>
				<label>-</label></td>

<td>
				<label>-</label></td>
	<td><input type="hidden" name="<%=ADDITIONAL_REMARKS%>"
			id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
				<label>-</label></td>
	
	<td></td>
	
</tr>

<%} %>



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
			if(nv != null && nv.getSex().equalsIgnoreCase("m")&& PaientAge> nv.getFromAge() && PaientAge<= nv.getToAge()){
	%>
<tr>
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	<td><label>---</label></td>
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
	System.out.print("femaile if");

	String age1 ="";
	age = patient.getAge();
	int index =  age.indexOf(" ");    
	age1 = age.substring(0,index);
	System.out.println("age1="+age1);
	
	System.out.println("normalSet="+normalSet.size());
	if(normalSet.size()>0) {
	for(DgNormalValue nv :normalSet){
		if(nv.getFromAge() != null && nv.getToAge() != null && !nv.getToAge().equals("") && !nv.getFromAge().equals("")){
			if(nv != null && nv.getSex().equalsIgnoreCase("f")&& PaientAge> nv.getFromAge() && PaientAge<= nv.getToAge()){
				
				System.out.println("2nd if");
				
				
	%>
<tr>
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
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
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
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
			if(nv != null && nv.getSex().equalsIgnoreCase("n")&& PaientAge> nv.getFromAge() && PaientAge<= nv.getToAge()){
	%>
<tr>
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
	<td><label>---</label></td>
	<td><input type="hidden"
		value="<%=dgCollection.getInvestigation().getId() %>"
		name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>">
	<input type="hidden"
		value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
		name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID%><%=inc %>"> <%if(dgCollection.getSubInvestigationName() != null){ %>
	<input name="<%=SUBTEST_NAME %>" type="text"
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
<% }%>
<%}else if(nv.getSex().equalsIgnoreCase("n")&& nv.getFromAge()== null || nv.getSex().equalsIgnoreCase("n")&& nv.getSex().equalsIgnoreCase("")){ %>
<tr>
	<td><label><%=srNoCounter %>.<%=subCounter %>)</label></td>
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


<%} 
	        
	}%>
<!--  end of  if result type is single parameter and comaprison type is normal value and condition NONE -->


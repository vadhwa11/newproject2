<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>

<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
Map<String,Object> map = new HashMap<String,Object>();
Set<DgResultEntryDetail> subSet1 = new HashSet<DgResultEntryDetail>();
Integer resultEntryIndex = 0;
char subCounter = 97;
Integer resultEntryIndexForMultiple = 0;
DgResultEntryHeader dgResultEntryHeader= new DgResultEntryHeader();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

try{
	if(map.get("resultList") != null){
		resultList=(List)map.get("resultList");
	}
}catch(Exception e){
	e.printStackTrace();
}
if(request.getParameter("resultEntryIndex") != null){
	resultEntryIndex = Integer.parseInt(request.getParameter("resultEntryIndex"));
}
if(request.getParameter("resultEntryIndexForMultiple") != null){
	resultEntryIndexForMultiple = Integer.parseInt(request.getParameter("resultEntryIndexForMultiple"));
}

Patient patient = new Patient(); 
if(resultList != null && resultList.size()>0){
	   dgResultEntryHeader = (DgResultEntryHeader) resultList.get(resultEntryIndex);
	   subSet1 = dgResultEntryHeader.getDgResultEntryDetails();
	   patient = (Patient) dgResultEntryHeader.getPatient();
}

String age1 ="";
String age = patient.getAge();
int index =  age.indexOf(" ");    
age1 = age.substring(0,index);	


Set<DgResultEntryDetail> dgResultEntryDtSet = new LinkedHashSet<DgResultEntryDetail>();
Set<DgResultEntryDetail> linkedHashSet = DgResultEntryComparatorByOrderNo.getApplicationTreeSet(); 
for(DgResultEntryDetail dgResultEntryDetail : subSet1){
	linkedHashSet.add(dgResultEntryDetail);
}
//dgResultEntryDtSet.addAll(linkedHashSet);
//dgResultEntryDtSet=subSet1;
dgResultEntryDtSet.addAll(linkedHashSet);
map.put("subSet1",dgResultEntryDtSet);

%>
<div class="Clear"></div>
<!-- Table Starts -->
<% int i =0; 
	    Set<DgNormalValue> normalSet = new HashSet<DgNormalValue>(); 
	    Set<DgFixedValue> dgFixedValueSet = new HashSet<DgFixedValue>();
	    %>
<tr>
	<td><%=resultEntryIndex+1%></td>
	<td><label name="<%=INVESTIGATION_NAME %>"
		style="font-weight: bold;"><%=dgResultEntryHeader.getDgResultEntryDetails().iterator().next().getInvestigation().getInvestigationName() %>
	</label></td>
	<td><input type="hidden" name="HeaderCountFlag" id="HeaderCountFlag" value="HeaderCountFlag" /></td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td><input type="hidden" name="<%=SUB_TEST_SIZE%>"	id="<%=SUB_TEST_SIZE %>" value="<%=dgResultEntryDtSet.size()%>" /> 
	<input type="hidden" name="<%=RESULT_ID %>" id="<%= RESULT_ID%>" value="<%=dgResultEntryHeader.getId() %>" /> 
	<input name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5" value="" readonly /> 
	<input type="hidden" name="<%=RESULT%>" id="<%=RESULT%><%=resultEntryIndexForMultiple%>" value="TestRowFlag" /> 
	<input type="hidden" name="<%=FIXED_ID %>"	id="<%=FIXED_ID %>" value=""  tabindex="1" /> 
	<input	name="<%=ADDITIONAL_REMARKS %>" type="hidden" value="" />
	</td>
	<td><input id="checkId<%=resultEntryIndexForMultiple%>"	name="checkId<%=resultEntryIndexForMultiple%>" value="testValidate"	type="hidden" class="check" />&nbsp;</td>
<td>&nbsp;</td>
</tr>
<%
	    
	    for(DgResultEntryDetail dgDetail :dgResultEntryDtSet){
	    	System.out.println("dgResultEntryDtSet="+dgResultEntryDtSet.size());
	    	i++;
	    	resultEntryIndexForMultiple++;
	    %>

<input name="chargeCodeCodeForPerticularTestForMultiple" id="chargeCodeCodeForPerticularTestForMultiple<%=resultEntryIndexForMultiple%>" value="<%= dgDetail.getInvestigation().getChargeCode().getChargeCodeCode()%>"	type="hidden">

<input name="resultNumericOrStringForMultiple"	id="resultNumericOrStringForMultiple<%=resultEntryIndexForMultiple%>"	value="<%= dgDetail.getInvestigation().getNumericOrString()%>"	type="hidden">

<input name="resultType" type="hidden" size="10" value="<%=dgDetail.getResultType() %>" />
<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition male  -->
<%
	normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	dgFixedValueSet=dgDetail.getSubInvestigation().getDgFixedValues();
   	 %>
<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition male -->
<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition Female  -->
<%
	normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
   	%>
   	
   	<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition male -->
   	
   	<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m") && Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)<= nv.getToAge()){
							%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %>
	<input	name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"	size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
	
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label> <%}else { %> 
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>">-</label> 
	<%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> 
	<input name="<%=SAMPLE_ID %>"	id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"	value="<%=dgDetail.getSample().getId() %>" readonly />
	<label	name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %></label>
	<%}else { %> <label name="sample" id="sample<%=i%>">-</label> 
	<%} %>
	</td>
	<td>
<% 
	    try{
	    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
	    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
	    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
	    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
	    		if(dgDetail.getResult() != null 
	    				&& !dgDetail.getResult().equals("")){
	    			Float result1   = Float.parseFloat(dgDetail.getResult());
		    		String result = new DecimalFormat("0.##").format((double)result1);
		    		if(result1 <= maxValue && result1 >= minValue ){ %> 
	<input	name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"	onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');" value="<%=result1 %>" /> 
	<input type="hidden" name="<%=FIXED_ID %>"	id="<%=FIXED_ID %>" value="" tabindex="1" /> 
	<% }else{ %>
	<input name="<%=RESULT %>"	id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"	onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');" class="highlight" value="<%=result1 %>" /> 
	<input type="hidden"	name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value=""	tabindex="1" /> 
	<% }
	}else{%> 
	<input name="<%=RESULT %>"	id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"	onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"	value="" /> 
	<input type="hidden" name="<%=FIXED_ID %>"	id="<%=FIXED_ID %>" value=""  tabindex="1" /> 
	<%}					       
	    }else{ %> 
	 <input name="<%=RESULT %>"	id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"	onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"	value="<%=dgDetail.getResult()%>" /> 
	 <input type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" tabindex="1" /> 
	 <% } 
		    }catch(Exception exception){ %> 
	<input name="<%=RESULT %>"	id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"	onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"	value="<%=dgDetail.getResult()%>" /> 
	<input type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" tabindex="1" /> 
	<% } %>
	</td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getUom().getId()%>" readonly /> <label
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %></label>
	<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%></label>
	<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></label>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<%}}else{ %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue">-</label> <%}} %>
	</td>

	
	<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		 style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		 style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>
</tr>

<%}}
					}
					}
				} %>
				
				
				
		<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition female -->		
				
				
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f")  && Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)<= nv.getToAge()){
							%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %>
	<input	name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"	size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
	
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label> <%}else { %> 
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>">-</label> 
	<%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> 
	<input name="<%=SAMPLE_ID %>"	id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"	value="<%=dgDetail.getSample().getId() %>" readonly />
	<label	name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %></label>
	<%}else { %> <label name="sample" id="sample<%=i%>">-</label> 
	<%} %>
	</td>
	<td>
<% 
	    try{
	    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
	    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
	    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
	    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
	    		if(dgDetail.getResult() != null 
	    				&& !dgDetail.getResult().equals("")){
	    			Float result1   = Float.parseFloat(dgDetail.getResult());
		    		String result = new DecimalFormat("0.##").format((double)result1);
		    		if(result1 <= maxValue && result1 >= minValue ){ %> 
	<input	name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"	onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');" value="<%=result1 %>" /> 
	<input type="hidden" name="<%=FIXED_ID %>"	id="<%=FIXED_ID %>" value="" tabindex="1" /> 
	<% }else{ %>
	<input name="<%=RESULT %>"	id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"	onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');" class="highlight" value="<%=result1 %>" /> 
	<input type="hidden"	name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value=""	tabindex="1" /> 
	<% }
	}else{%> 
	<input name="<%=RESULT %>"	id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"	onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"	value="" /> 
	<input type="hidden" name="<%=FIXED_ID %>"	id="<%=FIXED_ID %>" value=""  tabindex="1" /> 
	<%}					       
	    }else{ %> 
	 <input name="<%=RESULT %>"	id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"	onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"	value="<%=dgDetail.getResult()%>" /> 
	 <input type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" tabindex="1" /> 
	 <% } 
		    }catch(Exception exception){ %> 
	<input name="<%=RESULT %>"	id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"	onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"	value="<%=dgDetail.getResult()%>" /> 
	<input type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" tabindex="1" /> 
	<% } %>
	</td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getUom().getId()%>" readonly /> <label
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %></label>
	<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%></label>
	<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></label>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<%}}else{ %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue">-</label> <%}} %>
	</td>

	
	<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		 style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		 style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>
</tr>

<%}}
					}
					}
				} %>
<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition female -->

<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition None  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
		size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <label
		name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
	<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
	</td>
	<td>
	<% 
				    try{
				    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
		name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>"
		tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=result1 %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result1 %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } %>
	</td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getUom().getId()%>" readonly /> <label
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
	<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
	<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<%}}else{ %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue">-</label> <%}} %>
	</td>
	<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>
	
</tr>
<%}}
					}
					}
				} %>
<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition NoNe -->

<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition male  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	 %>
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m") && Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)<= nv.getToAge()){
						%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
		size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <label
		name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
	<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
	</td>
	<td>
	<% 
				    try{
				    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
		name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>"
		tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=result1 %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result1 %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } %>
	</td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getUom().getId()%>" readonly /> <label
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
	<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
	<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<%}}else{ %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue">-</label> <%}} %>
	</td>
	<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		 style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		 style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>
	
</tr>

<%
				}
					}
						}
				}
				} %>
<!--  when result type is MULTIPLE PARAMETER and comaprison type NORMAL VALUE and condition male -->
<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition Female  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();

	    	 %>
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
	
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						
						if(nv != null && nv.getSex().equalsIgnoreCase("f") && Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)<= nv.getToAge()){
						%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
		size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
	</td>
	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <label
		name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
	<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
	</td>
	<td>
	<% 
				    try{
				    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
		name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>"
		tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=result1 %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result1 %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } %>
	</td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getUom().getId()%>" readonly /> <label
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
	<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
	</td>
	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
	<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<%}}else{ %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue">-</label> <%}} %>
	</td>
<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		 style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		 style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>
	
</tr>
<%
				}
					}
						}
				}
				} %>
<!--  when result type MULTIPLE PARAMETER and comaprison type NORMAL VALUE and condition fEmale -->
<!--  when result type is multiple PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition none  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>

<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
		size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <label
		name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
	<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
	</td>
	<td>
	<% 
				    try{
				    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
		name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>"
		tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=result1 %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result1 %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } %>
	</td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getUom().getId()%>" readonly /> <label
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
	<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
	<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<%}}else{ %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue">-</label> <%}} %>
	</td>
<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>
	
</tr>

<%
				}
					}
						}
				}
				} %>
<!--  when result type is Multiple PARAMETER and comaprison type NORMAL VALUE and condition none -->

<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition male  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	 %>
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m") && Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)<= nv.getToAge()){
							%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
		size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <label
		name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
	<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
	</td>
	<td>
	<% 
				    try{
				    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
		name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>"
		tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=result1 %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result1 %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } %>
	</td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getUom().getId()%>" readonly /> <label
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
	<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
	<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<%}}else{ %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue">-</label> <%}} %>
	</td>
<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>
	
</tr>

<%
				}
					}
						}
				}
				} %>
<!--  when result type is TEXT AREA  and comaprison type NORMAL VALUE and condition male -->

<!--  when result type is TEXT AREA and comparison type is NORMAL VALUE  -->
<!--  condition Female  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f") && Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)<= nv.getToAge()){
						%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
		size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <label
		name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
	<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
	</td>
	<td>
	<% 
				    try{
				    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
		name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>"
		tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=result1 %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result1 %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } %>
	</td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getUom().getId()%>" readonly /> <label
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
	<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
	<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<%}}else{ %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue">-</label> <%}} %>
	</td>
	<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>

</tr>

<%
				}
					}
						}
				}
				} %>
<!--  when result type TEXT AREA and comaprison type NORMAL VALUE and condition fEmale -->

<!--  when result type is TEXT AREA and comparison type is NORMAL VALUE  -->
<!--  condition none  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>

<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
		size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <label
		name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
	<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
	</td>
	<td>
	<% 
				    try{
				    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
		name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>"
		tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=result1 %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result1 %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } %>
	</td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getUom().getId()%>" readonly /> <label
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
	<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
	<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<%}}else{ %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue">-</label> <%}} %>
	</td>
	<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>

</tr>

<%
				}
					}
						}
				}
				} %>
<!--  when result type is TEXT AREA and comaprison type NORMAL VALUE and condition none -->

<!--  when result type is Range and comparison type is NORMAL VALUE  -->
<!--  condition male  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m") && Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)<= nv.getToAge()){
						%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
		size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <label
		name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
	<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
	</td>
	<td>
	<% 
				    try{
				    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
		name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>"
		tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=result1 %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result1 %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } %>
	</td>
	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
	<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<%}}else{ %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue">-</label> <%}} %>
	</td>
<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>
	
</tr>

<%
				}
					}
						}
				}
				} %>
<!--  when result type is Range and comaprison type NORMAL VALUE and condition male -->

<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
<!--  condition Female  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f") && Integer.parseInt(age1)> nv.getFromAge() && Integer.parseInt(age1)<= nv.getToAge()){
							%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
		size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <label
		name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
	<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
	</td>
	<td>
	<% 
				    try{
				    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
		name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>"
		tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=result1 %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result1 %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } %>
	</td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getUom().getId()%>" readonly /> <label
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
	<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
	<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<%}}else{ %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue">-</label> <%}} %>
	</td>
	<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>

</tr>

<%
				}
					}
						}
				}
				} %>
<!--  when result type RANGE and comaprison type NORMAL VALUE and condition fEmale -->

<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
<!--  condition none  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>

<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
		size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <label
		name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
	<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
	</td>
	<td>
	<% 
				    try{
				    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
		name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>"
		tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=result1 %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result1 %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <%} %>
	</td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
		value="<%=dgDetail.getUom().getId()%>" readonly /> <label
		name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
	<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
		id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
	</td>

	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
	<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
	<%}}else{ %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
		name="normalValue" id="normalValue">-</label> <%}} %>
	</td>
<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>
	
</tr>

<%
				}
					}
						}
				}
				} %>
<!--  when result type is RANGE and comaprison type NORMAL VALUE and condition none -->

<!--  when result type is HEADING and comparison type is NONE -->
<!--  end when result type is HEADING and comparison type is NONE  -->
<!--  when result type is HEADING and comparison type is FIXED VALUE -->

<!--  end when result type is HEADING and comparison type is FIXED VALUE -->
<!--  when result type is HEADING and comparison type is NORMAL VALUE  -->
<!--  end of when result type is HEADING and comparison type is NORMAL VALUE  -->
<!--  when result type is SINGLE PARAMETER and COMPARISON TYPE is NONE  -->

<!--  end when result type is SINGLE PARAMETER and COMAPRISON TYPE is NONE -->

<!--  when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE  -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f") ){ %>


<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> 
		<label><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label> 
		<%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
		size="2" value="" readonly /> <%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id=<%=SAMPLE_ID %> type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <input
		name="sample" type="text"
		value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
	<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
	</td>

	<td>
	<% if(dgDetail.getFixed() != null){	%> <select name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" tabindex="1">
		<option value="">Select</option>
		<%for(DgFixedValue dgFixedValue : dgFixedValueSet){
						if(dgFixedValue.getFixedValue() != null){ 
							if(dgFixedValue.getId() == dgDetail.getFixed().getId()){ %>
		<option selected="selected" value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
		<%}else{ %>
		<option value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
		<%} %>
		<%}
					 }%>
	</select> <input type="hidden" name="<%=RESULT %>" tabindex="1"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" value="" /> <%}%>
	</td>

	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>" id="<%=UNIT_OF_MEASUREMENT_ID %>"
		type="hidden" size="5" value="<%=dgDetail.getUom().getId()%>" readonly />
	<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
		value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2" value=""
		readonly /> <%} %>
	</td>
	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <input name="normalId" type="hidden" id="normalId"
		size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <%}}else{ %> <input name="normalId" type="hidden"
		id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
		readonly /> <input name="normalValue" type="text" size="8" value=""
		readonly /><label>-</label> <%}} %>
	</td>
<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>
	
</tr>
<%} %>
<!-- end of when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE -->
<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE  -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> 
		<label><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
		 <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
		size="2" value="" readonly /> <%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id=<%=SAMPLE_ID %> type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <input
		name="sample" type="text"
		value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
	<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
	</td>
	<td>
	<% 
				    try{
				    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
		name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>"
		tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=result1 %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result1 %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } %>
	</td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>" id="<%=UNIT_OF_MEASUREMENT_ID %>"
		type="hidden" size="5" value="<%=dgDetail.getUom().getId()%>" readonly />
	<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
		value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2" value=""
		readonly /> <%} %>
	</td>
	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <input name="normalId" type="hidden" id="normalId"
		size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <%}}else{ %> <input name="normalId" type="hidden"
		id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
		readonly /> <input name="normalValue" type="text" size="8" value=""
		readonly /><label>-</label> <%}} %>
	</td>
<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>
	
</tr>
<%} %>
<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE   -->
<!--  when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f") ){ %>


<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> 
		<label><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label> 
		<%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
		size="2" value="" readonly /> <%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id=<%=SAMPLE_ID %> type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <input
		name="sample" type="text"
		value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
	<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
	</td>

	<td>
	<% if(dgDetail.getFixed() != null){	%> <select name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" tabindex="1">
		<option value="">Select</option>
		<%for(DgFixedValue dgFixedValue : dgFixedValueSet){
						if(dgFixedValue.getFixedValue() != null){ 
							if(dgFixedValue.getId() == dgDetail.getFixed().getId()){ %>
		<option selected="selected" value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
		<%}else{ %>
		<option value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
		<%} %>
		<%}
					 }%>
	</select> <input type="hidden" name="<%=RESULT %>" tabindex="1"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" value="" /> <%}%>
	</td>

	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>" id="<%=UNIT_OF_MEASUREMENT_ID %>"
		type="hidden" size="5" value="<%=dgDetail.getUom().getId()%>" readonly />
	<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
		value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2" value=""
		readonly /> <%} %>
	</td>
	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <input name="normalId" type="hidden" id="normalId"
		size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <%}}else{ %> <input name="normalId" type="hidden"
		id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
		readonly /> <input name="normalValue" type="text" size="8" value=""
		readonly /><label>-</label> <%}} %>
	</td>
<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>
	
</tr>
<%} %>
<!-- end when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->

<!--  when result type is TEXT AREA and comparison type is NONE -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter %>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
<label><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
 <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
		size="2" value="" readonly /> <%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id=<%=SAMPLE_ID %> type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <input
		name="sample" type="text"
		value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
	<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
	</td>
	<td>
	<% 
				    try{
				    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
		name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>"
		tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=result1 %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result1 %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <%}
					       }else{ 
					        if(dgDetail.getResult() != null){ %> <input
		name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>"
		tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <% }else{ %> <input
		name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>"
		tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <% } %> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } %>
	</td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>" id="<%=UNIT_OF_MEASUREMENT_ID %>"
		type="hidden" size="5" value="<%=dgDetail.getUom().getId()%>" readonly />
	<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
		value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2" value=""
		readonly /> <%} %>
	</td>
	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <input name="normalId" type="hidden" id="normalId"
		size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <%}}else{ %> <input name="normalId" type="hidden"
		id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
		readonly /> <input name="normalValue" type="text" size="8" value=""
		readonly /><label>-</label> <%}} %>
	</td>

	<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>

</tr>
<%} %>

<!-- end when result type is TEXT AREA and comparison type is NONE -->
<!--  when result type is TEXT AREA and comparison type is FIXED VALUE -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> 
		<label><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
		 <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
		size="2" value="" readonly /> <%} %>
	</td>

	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id=<%=SAMPLE_ID %> type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <input
		name="sample" type="text"
		value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
	<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
	</td>
	<td>
	<%if(dgDetail.getFixed() != null){ %> <select name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>"  tabindex="1">
		<option value="">Select</option>
		<%for(DgFixedValue dgFixedValue : dgFixedValueSet){
						if(dgFixedValue.getFixedValue() != null){ 
							if(dgFixedValue.getId() == dgDetail.getFixed().getId()){ %>
		<option selected="selected" value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
		<%}else{ %>
		<option value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
		<%} %>
		<%}
					 }%>
	</select> <%}else{ %> <select name="<%=FIXED_ID %>" id="<%=FIXED_ID %>"
		 tabindex="1">
		<option value="">Select</option>
		<%for(DgFixedValue dgFixedValue : dgFixedValueSet){
							if(dgFixedValue.getFixedValue() != null){ %>
		<option value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
		<%} %>
		<%} %>
	</select> <%} %> <input type="hidden" name="<%=RESULT %>" tabindex="1"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" value="" /></td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>" id="<%=UNIT_OF_MEASUREMENT_ID %>"
		type="hidden" size="5" value="<%=dgDetail.getUom().getId()%>" readonly />
	<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
		value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2" value=""
		readonly /> <%} %>
	</td>

	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <input name="normalId" type="hidden" id="normalId"
		size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <%}}else{ %> <input name="normalId" type="hidden"
		id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
		readonly /> <input name="normalValue" type="text" size="8" value=""
		readonly /><label>-</label> <%}} %>
	</td>
<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>
	
</tr>
<%} %>
<!-- end  when result type is TEXT AREA and comparison type is FIXED VALUE -->
<!--  when result type is Range and comparison type is NONE -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> 
<label><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
 <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
		size="2" value="" readonly /> <%} %>
	</td>
	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id=<%=SAMPLE_ID %> type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <input
		name="sample" type="text"
		value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
	<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
	</td>
	<td>
	<% 
				    try{
				    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
		name="<%=RESULT %>" id="<%=RESULT %><%=resultEntryIndexForMultiple%>"
		tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=result1 %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result1 %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value=""  tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" 
		tabindex="1" /> <% } %>
	</td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>" id="<%=UNIT_OF_MEASUREMENT_ID %>"
		type="hidden" size="5" value="<%=dgDetail.getUom().getId()%>" readonly />
	<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
		value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2" value=""
		readonly /> <%} %>
	</td>
	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <input name="normalId" type="hidden" id="normalId"
		size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <%}}else{ %> <input name="normalId" type="hidden"
		id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
		readonly /> <input name="normalValue" type="text" size="8" value=""
		readonly /><label>-</label> <%}} %>
	</td>
		<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>

</tr>
<%} %>
<!-- when result type is RANGE and comparison type is FIXED VALUE  -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> 
<label><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
 <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
		size="2" value="" readonly /> <%} %>
	</td>
	<td>
	<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
		id=<%=SAMPLE_ID %> type="hidden" size="5"
		value="<%=dgDetail.getSample().getId() %>" readonly /> <input
		name="sample" type="text"
		value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
	<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
	</td>
	<td>
	<%if(dgDetail.getFixed() != null){ %> <select name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>"  tabindex="1">
		<option value="">Select</option>
		<%for(DgFixedValue dgFixedValue : dgFixedValueSet){
						if(dgFixedValue.getFixedValue() != null){ 
							if(dgFixedValue.getId() == dgDetail.getFixed().getId()){ %>
		<option selected="selected" value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
		<%}else{ %>
		<option value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
		<%} %>
		<%}
					 }%>
	</select> <%}else{ %> <select name="<%=FIXED_ID %>" id="<%=FIXED_ID %>"
		 tabindex="1">
		<option value="">Select</option>
		<%for(DgFixedValue dgFixedValue : dgFixedValueSet){
							if(dgFixedValue.getFixedValue() != null){ %>
		<option value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
		<%} %>
		<%} %>
	</select> <%} %> <input type="hidden" name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		value="" /></td>
	<td>
	<%if(dgDetail.getUom() !=null){ %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>" id="<%=UNIT_OF_MEASUREMENT_ID %>"
		type="hidden" size="5" value="<%=dgDetail.getUom().getId()%>" readonly />
	<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
		value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %> <input
		name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2" value=""
		readonly /> <%} %>
	</td>
	<td>
	<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <input name="normalId" type="hidden" id="normalId"
		size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
	<input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <%}}else{ %> <input name="normalId" type="hidden"
		id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
		readonly /> <input name="normalValue" type="text" size="8" value=""
		readonly /><label>-</label> <%}} %>
	</td>
	<td>
	<%if(dgDetail.getRemarks() !=null){ %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
		name="<%=ADDITIONAL_REMARKS %>" onkeyup="chkLength(this,100);"
		type="text" value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
		id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getId()%>" readonly /></td>
	<td>
	<% if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %> <label
		name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;">Validated</label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% }else{ %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>
	<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" type="checkbox"
		class="check" /> <% } %>
	</td>
	
</tr>
<%}
    	%>
<%
    	subCounter++;
	    } %>
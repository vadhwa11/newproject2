<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
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

if(resultList != null && resultList.size()>0){
	   dgResultEntryHeader = (DgResultEntryHeader) resultList.get(resultEntryIndex);
	   subSet1 = dgResultEntryHeader.getDgResultEntryDetails();
}
System.out.println("subSet1::"+subSet1.size());
Set<DgResultEntryDetail> dgResultEntryDtSet = new LinkedHashSet<DgResultEntryDetail>();
Set<DgResultEntryDetail> linkedHashSet = DgResultEntryComparatorByOrderNo.getApplicationTreeSet(); 
for(DgResultEntryDetail dgResultEntryDetail : subSet1){
	linkedHashSet.add(dgResultEntryDetail);
}
//dgResultEntryDtSet.addAll(linkedHashSet);
dgResultEntryDtSet=subSet1;


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

</tr>
<%
	    
	    for(DgResultEntryDetail dgDetail :dgResultEntryDtSet){
	    	i++;
	    	resultEntryIndexForMultiple++;
	    %>



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
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
							%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> 
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
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
		value="<%=result %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } %>
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
	<%if(dgDetail.getSubInvestigation() !=null){ %>
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
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
		value="<%=result %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } %>
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
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
						%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %>
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
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
		value="<%=result %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } %>
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
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
						%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %>
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
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
		value="<%=result %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } %>
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
	<%if(dgDetail.getSubInvestigation() !=null){ %> 
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
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
		value="<%=result %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } %>
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
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
							%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> 
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
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
		value="<%=result %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } %>
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
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
						%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> 
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
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
		value="<%=result %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } %>
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
	<%if(dgDetail.getSubInvestigation() !=null){ %> 
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
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
		value="<%=result %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } %>
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
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
						%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> 
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
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
		value="<%=result %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } %>
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
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
							%>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
		size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
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
		value="<%=result %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } %>
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
	<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
	<%}else { %> <label name="<%=SUBTEST_NAME %>"
		id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
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
		value="<%=result %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <%} %>
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
<!-- end of when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE -->
<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE  -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
<tr>
	<td><%=resultEntryIndex+1%>.<%=subCounter%>)</td>
	<td>
	<%if(dgDetail.getSubInvestigation() !=null){ %> <input
		name="<%=SUBTEST_ID %>" type="hidden" size="5"
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
		name="<%=SUBTEST_NAME %>" type="text" size="5"
		value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
		readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
		size="2" value="" readonly /> <%} %>
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
		value="<%=result %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } %>
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
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
		name="<%=SUBTEST_NAME %>" type="text" size="5"
		value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
		readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
		size="2" value="" readonly /> <%} %>
	</td>

	

	<td>
	<% if(dgDetail.getFixed() != null){	%> <select name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" class="large" tabindex="1">
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
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
		name="<%=SUBTEST_NAME %>" type="text" size="5"
		value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
		readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
		size="2" value="" readonly /> <%} %>
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
		value="<%=result %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <%}
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
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } %>
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
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
		name="<%=SUBTEST_NAME %>" type="text" size="5"
		value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
		readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
		size="2" value="" readonly /> <%} %>
	</td>

	
	<td>
	<%if(dgDetail.getFixed() != null){ %> <select name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" class="large" tabindex="1">
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
		class="large" tabindex="1">
		<option value="">Select</option>
		<%for(DgFixedValue dgFixedValue : dgFixedValueSet){
							if(dgFixedValue.getFixedValue() != null){ %>
		<option value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
		<%} %>
		<%} %>
	</select> <%} %> <input type="hidden" name="<%=RESULT %>" tabindex="1"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" value="" /></td>
	
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
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
		name="<%=SUBTEST_NAME %>" type="text" size="5"
		value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
		readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
		size="2" value="" readonly /> <%} %>
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
		value="<%=result %>" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <% }else{ %>
	<input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		class="highlight" value="<%=result %>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% }
					    	}else{%> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="" /> <input type="hidden" name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" value="" class="large" tabindex="1" /> <%}
					       }else{ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex+1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <input type="hidden"
		name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" class="large"
		tabindex="1" /> <% } %>
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
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
		name="<%=SUBTEST_NAME %>" type="text" size="5"
		value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
		readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
		size="2" value="" readonly /> <%} %>
	</td>
	
	<td>
	<%if(dgDetail.getFixed() != null){ %> <select name="<%=FIXED_ID %>"
		id="<%=FIXED_ID %>" class="large" tabindex="1">
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
		class="large" tabindex="1">
		<option value="">Select</option>
		<%for(DgFixedValue dgFixedValue : dgFixedValueSet){
							if(dgFixedValue.getFixedValue() != null){ %>
		<option value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
		<%} %>
		<%} %>
	</select> <%} %> <input type="hidden" name="<%=RESULT %>"
		id="<%=RESULT %><%=resultEntryIndexForMultiple%>" tabindex="1"
		value="" /></td>
	
</tr>
<%}
    	%>
<%
    	subCounter++;
	    } %>
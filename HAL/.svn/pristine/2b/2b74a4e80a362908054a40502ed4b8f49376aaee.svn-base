<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="java.net.URL"%>
<%@page import="java.text.DecimalFormat"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%

	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	String[] orderStatusMsg = null;
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	int initialHieght = 22;
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("orderStatusMsg") != null){
		orderStatusMsg = (String[])map.get("orderStatusMsg");
	}

	List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
	if(map.get("dgResultdetailList") != null){
		dgResultdetailList = (List<DgResultEntryDetail>)map.get("dgResultdetailList");
	}
	if(dgResultdetailList.size()>0){
		initialHieght = initialHieght + dgResultdetailList.size()*27;
	}
	List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
	try{
		if(map.get("fixedValList") != null){
			fixedValList=(List)map.get("fixedValList");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	try{
		if(map.get("resultList") != null){
			resultList=(List)map.get("resultList");
		}
	}catch(Exception e){
		e.printStackTrace();
	}

	DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
		if(resultList != null && resultList.size()>0)	   {
		   dgResultEntryHeader = (DgResultEntryHeader) resultList.get(0);
		}

%>
<div class="Clear"></div>
<%if(orderStatusMsg != null){ 
	for(String msg : orderStatusMsg){%>
<h4><%=msg%> </h4>
<%	}
} %>


<div class="Clear"></div>
<!-- Table Starts -->


<table border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">Investigation</th>
		<th scope="col">Sample</th>
		<th scope="col">Result</th>
		<th scope="col">UOM</th>
		<th scope="col">Normal Range</th>
		<th scope="col">Validation Status</th>
		<th scope="col">Additional Remarks</th>
	</tr>
	<% int i =0;
	    Set<DgNormalValue>normalSet = new HashSet<DgNormalValue>();
	    for(DgResultEntryDetail dgDetail :dgResultdetailList){
	    	i++;
	    %>
	<input name="resultType" type="hidden" size="10"
		value="<%=dgDetail.getResultType() %>" />
	<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
	<!--  condition male  -->
	<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

	<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
	<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
							System.out.println("inside male condition normal value  ");%>
	<tr>
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%> <!--   <input id="checkId<%=i %>" name="<%=VALIDATED %>" type="checkbox" class="check"/> -->
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" onkeyup="chkLength(this,100);" />
		<%}else { %> <input name="<%=ADDITIONAL_REMARKS %>" type="text"
			readonly="readonly" value="" onkeyup="chkLength(this,100);" /> <%} %>
		<input name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
			type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
	</tr>

	<%
				}
					}
						}
				}
				} %>
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
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
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
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%> <!-- <input id="checkId<%=i %>" name="<%=VALIDATED %>" type="checkbox" class="check"/> -->
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
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
					//for(DgNormalValue nv :normalSet){
						//if(nv != null && nv.getSex().equalsIgnoreCase("m")){
						%>
	<tr>
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
	</tr>

	<%
				}
				//	}
				//		}
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
					//for(DgNormalValue nv :normalSet){
					//	if(nv != null && nv.getSex().equalsIgnoreCase("f")){
						%>
	<tr>
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
	</tr>

	<%
				}
				//	}
				//		}
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
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
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
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
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
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
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
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
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
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
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
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
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
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
	</tr>

	<%
				}
					}
						}
				}
				} %>
	<!--  when result type is RANGE and comaprison type NORMAL VALUE and condition none -->

	<!--  when result type is HEADING and comparison type is NONE -->
	<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
	<tr>
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" class="heading"
			id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
		<%}else { %> <label name="<%=SUBTEST_NAME %>" class="heading"
			id="<%=SUBTEST_NAME %><%=i %>" /> <%} %>
		</td>
		<td><input name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=i %>"
			type="hidden" size="5" value="" readonly /> <label>-</label></td>
		<td><input name="result" id="result<%=i %>" type="hidden"
			value="" /><label>-</label></td>
		<td><input name="<%=UNIT_OF_MEASUREMENT_ID %>"
			id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
			value="" readonly /> <label>-</label></td>
		<td><input name="normalId" type="hidden" id="normalId<%=i %>"
			size="5" value="" readonly /> <input name="fixedId" type="hidden"
			id="fixedId<%=i %>" size="5" value="" readonly /><label>-</label></td>
		<td>
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td><input name="<%=ADDITIONAL_REMARKS %>"
			id="<%=ADDITIONAL_REMARKS %><%=i %>" type="hidden" value="" /> <label>-</label>
		<input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %><%=i %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
	</tr>
	<%} %>
	<!--  end when result type is HEADING and comparison type is NONE  -->
	<!--  when result type is HEADING and comparison type is FIXED VALUE -->
	<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>
	<tr>
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" class="heading"
			id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
		<%}else { %>
		 <label name="<%=SUBTEST_NAME %>" class="heading" id="<%=SUBTEST_NAME %><%=i %>" /> 
			<%} %>
		</td>
		<td><input name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=i %>"
			type="hidden" size="5" value="" readonly /> <label>-</label></td>
		<td><input name="result" id="result<%=i %>" type="hidden"
			value="" /><label>-</label></td>
		<td><input name="<%=UNIT_OF_MEASUREMENT_ID %>"
			id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
			value="" readonly /> <label>-</label></td>
		<td><input name="normalId" type="hidden" id="normalId<%=i %>"
			size="5" value="" readonly /> <input name="fixedId" type="hidden"
			id="fixedId<%=i %>" size="5" value="" readonly /><label>-</label></td>
		<td>
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td><input name="<%=ADDITIONAL_REMARKS %>"
			id="<%=ADDITIONAL_REMARKS %><%=i %>" type="hidden" value="" /> <label>-</label>
		<input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %><%=i %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
	</tr>
	<%} %>
	<!--  end when result type is HEADING and comparison type is FIXED VALUE -->
	<!--  when result type is HEADING and comparison type is NORMAL VALUE  -->
	<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){ %>
	<tr>
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" class="heading"
			id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
		<%}else { %> <label name="<%=SUBTEST_NAME %>" class="heading"
			id="<%=SUBTEST_NAME %><%=i %>" /> <%} %>
		</td>
		<td><input name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=i %>"
			type="hidden" size="5" value="" readonly /> <label>-</label></td>
		<td><input name="result" id="result<%=i %>" type="hidden"
			value="" /><label>-</label></td>
		<td><input name="<%=UNIT_OF_MEASUREMENT_ID %>"
			id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
			value="" readonly /> <label>-</label></td>
		<td><input name="normalId" type="hidden" id="normalId<%=i %>"
			size="5" value="" readonly /> <input name="fixedId" type="hidden"
			id="fixedId<%=i %>" size="5" value="" readonly /><label>-</label></td>
		<td>
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td><input name="<%=ADDITIONAL_REMARKS %>"
			id="<%=ADDITIONAL_REMARKS %><%=i %>" type="hidden" value="" /> <label>-</label>
		<input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %><%=i %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
	</tr>
	<%} %>
	<!--  end of when result type is HEADING and comparison type is NORMAL VALUE  -->
	<!--  when result type is SINGLE PARAMETER and COMPARISON TYPE is NONE  -->
	<%if((dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n"))){ %>
	<tr>
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
	</tr>
	<%} %>
	<!--  end when result type is SINGLE PARAMETER and COMAPRISON TYPE is NONE -->

	<!--  when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE  -->
	<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>

	<tr>
		<td><%=i %></td>
		<td>
		<%if(dgDetail.getSubInvestigation() !=null){ %> <input
			name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
			size="5" value="<%=dgDetail.getSubInvestigation().getId()%>" readonly />
		<label name="<%=SUBTEST_NAME %>" id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
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
		<%System.out.println("<<< gDetail.getFixed().getFixedValue() >>>> "+dgDetail.getFixed().getFixedValue()); %>
		<!-- frst if --> <%if(dgDetail.getFixed() != null){%> <input
			name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" readonly="readonly"
			value="<%=dgDetail.getFixed().getFixedValue() %>" /> <input
			type="hidden" name="<%=RESULT %>" id="" <%=RESULT %>
			readonly="readonly" value="" /> <%}else{
			%> <input name="<%=FIXED_ID %>" id="<%=FIXED_ID %>"
			readonly="readonly" value="" /> <input type="hidden"
			name="<%=RESULT %>" id="" <%=RESULT %> readonly="readonly" value="" />
		<%} %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
	</tr>
	<%} %>
	<!-- end of when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE -->
	<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE  -->
	<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
	<tr>
		<td><%=i %></td>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
		</td>
		<td>
		<%if(dgDetail.getUom() !=null){ %> <input
			name="<%=UNIT_OF_MEASUREMENT_ID %>" id="<%=UNIT_OF_MEASUREMENT_ID %>"
			type="hidden" size="5" value="<%=dgDetail.getUom().getId()%>"
			readonly /> <input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text"
			size="5" value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
		<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
			value="" readonly /> <%} %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
	</tr>
	<%} %>
	<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE   -->
	<!--  when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->
	<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f") ){ %>


	<tr>
		<td><%=i %></td>
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
		<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
			id=<%=SAMPLE_ID %> type="hidden" size="5"
			value="<%=dgDetail.getSample().getId() %>" readonly /> <input
			name="sample" type="text"
			value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
		<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
		</td>

		<td>
		<% if(dgDetail.getFixed() != null){	%> <input name="<%=FIXED_ID %>"
			id="<%=FIXED_ID %>" readonly="readonly"
			value="<%=dgDetail.getFixed().getFixedValue() %>" /> <input
			type="hidden" name="<%=RESULT %>" id="<%=RESULT %>"
			readonly="readonly" value="" /> <%}%>
		</td>

		<td>
		<%if(dgDetail.getUom() !=null){ %> <input
			name="<%=UNIT_OF_MEASUREMENT_ID %>" id="<%=UNIT_OF_MEASUREMENT_ID %>"
			type="hidden" size="5" value="<%=dgDetail.getUom().getId()%>"
			readonly /> <input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text"
			size="5" value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
		<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
			value="" readonly /> <%} %>
		</td>
		<td>
		<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
			readonly="readonly" value="<%=dgDetail.getNormal().getId() %>"
			readonly /> <input name="normalValue" type="text" size="8"
			readonly="readonly"
			value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<input name="normalValue" type="text" size="8" v readonly="readonly"
			alue="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
			readonly /> <input name="normalId" type="hidden" id="normalId"
			size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<input name="normalId" type="hidden" id="normalId" size="5"
			readonly="readonly" value="<%=dgDetail.getNormal().getId() %>"
			readonly /> <input name="normalValue" type="text" size="8"
			readonly="readonly"
			value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
			readonly /> <%}}else{ %> <input name="normalId" type="hidden"
			id="normalId" size="5" readonly="readonly"
			value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
			name="normalValue" type="text" size="8" readonly="readonly" value=""
			readonly /><label>-</label> <%}} %>
		</td>

		<td>
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>
		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
	</tr>
	<%} %>
	<!-- end when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->

	<!--  when result type is TEXT AREA and comparison type is NONE -->
	<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
	<tr>
		<td><%=i %></td>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
		</td>
		<td>
		<%if(dgDetail.getUom() !=null){ %> <input
			name="<%=UNIT_OF_MEASUREMENT_ID %>" id="<%=UNIT_OF_MEASUREMENT_ID %>"
			type="hidden" size="5" value="<%=dgDetail.getUom().getId()%>"
			readonly /> <input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text"
			size="5" value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
		<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
			value="" readonly /> <%} %>
		</td>

		<td>
		<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
			readonly="readonly" value="<%=dgDetail.getNormal().getId() %>"
			readonly /> <input name="normalValue" type="text" size="8"
			readonly="readonly"
			value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<input name="normalValue" type="text" size="8" readonly="readonly"
			value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
			readonly /> <input name="normalId" type="hidden" id="normalId"
			size="5" readonly="readonly"
			value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<input name="normalId" type="hidden" id="normalId" size="5"
			readonly="readonly" value="<%=dgDetail.getNormal().getId() %>"
			readonly /> <input name="normalValue" type="text" size="8"
			readonly="readonly"
			value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
			readonly /> <%}}else{ %> <input name="normalId" type="hidden"
			id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
			readonly /> <input name="normalValue" type="text" size="8"
			readonly="readonly" value="" readonly /><label>-</label> <%}} %>
		</td>

		<td>
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>

		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
	</tr>
	<%} %>

	<!-- end when result type is TEXT AREA and comparison type is NONE -->
	<!--  when result type is TEXT AREA and comparison type is FIXED VALUE -->
	<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>
	<tr>
		<td><%=i %></td>
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
		<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
			id=<%=SAMPLE_ID %> type="hidden" size="5"
			value="<%=dgDetail.getSample().getId() %>" readonly /> <input
			name="sample" type="text"
			value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
		<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
		</td>
		<td>
		<%if(dgDetail.getFixed() != null){ %> <input name="<%=FIXED_ID %>"
			id="<%=FIXED_ID %>" readonly="readonly"
			value="<%=dgDetail.getFixed().getFixedValue() %>" /> <input
			type="hidden" name="<%=RESULT %>" id="<%=RESULT %>"
			readonly="readonly" value="" /> <%}%>
		</td>
		<td>
		<%if(dgDetail.getUom() !=null){ %> <input
			name="<%=UNIT_OF_MEASUREMENT_ID %>" id="<%=UNIT_OF_MEASUREMENT_ID %>"
			type="hidden" size="5" value="<%=dgDetail.getUom().getId()%>"
			readonly /> <input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text"
			size="5" value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
		<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
			value="" readonly /> <%} %>
		</td>

		<td>
		<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
			readonly="readonly" value="<%=dgDetail.getNormal().getId() %>"
			readonly /> <input name="normalValue" type="text" size="8"
			readonly="readonly"
			value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<input name="normalValue" type="text" size="8" readonly="readonly"
			value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
			readonly /> <input name="normalId" type="hidden" id="normalId"
			size="5" readonly="readonly"
			value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<input name="normalId" type="hidden" id="normalId" size="5"
			readonly="readonly" value="<%=dgDetail.getNormal().getId() %>"
			readonly /> <input name="normalValue" type="text" size="8"
			readonly="readonly"
			value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
			readonly /> <%}}else{ %> <input name="normalId" type="hidden"
			id="normalId" size="5" readonly="readonly"
			value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
			name="normalValue" type="text" size="8" readonly="readonly" value=""
			readonly /><label>-</label> <%}} %>
		</td>

		<td>
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>

		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <%} %> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /></td>
	</tr>
	<%} %>
	<!-- end  when result type is TEXT AREA and comparison type is FIXED VALUE -->
	<!--  when result type is Range and comparison type is NONE -->
	<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>

	<tr>
		<td><%=i %></td>
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
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" value="<%=result %>" /> <% }else{ %> <input
			name="<%=RESULT %>" id="<%=RESULT %>" tabindex="1"
			readonly="readonly" class="highlight" value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="" /> <%}
					       }else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
			tabindex="1" readonly="readonly" value="<%=dgDetail.getResult()%>" />
		<% } 
				    }catch(Exception exception){ %> <input name="<%=RESULT %>"
			id="<%=RESULT %>" tabindex="1" readonly="readonly"
			value="<%=dgDetail.getResult()%>" /> <% } %>
		</td>
		<td>
		<%if(dgDetail.getUom() !=null){ %> <input
			name="<%=UNIT_OF_MEASUREMENT_ID %>" id="<%=UNIT_OF_MEASUREMENT_ID %>"
			type="hidden" size="5" value="<%=dgDetail.getUom().getId()%>"
			readonly /> <input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text"
			size="5" value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
		<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
			value="" readonly /> <%} %>
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
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>

		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /> <%} %>
		</td>
	</tr>
	<%} %>

	<!-- when result type is RANGE and comparison type is FIXED VALUE  -->
	<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>

	<tr>
		<td><%=i %></td>
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
		<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
			id=<%=SAMPLE_ID %> type="hidden" size="5"
			value="<%=dgDetail.getSample().getId() %>" readonly /> <input
			name="sample" type="text"
			value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
		<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
		</td>


		<td>
		<%if(dgDetail.getFixed() != null){ %> <input name="<%=FIXED_ID %>"
			id="<%=FIXED_ID %>" readonly="readonly"
			value="<%=dgDetail.getFixed().getFixedValue() %>" /> <input
			type="hidden" name="<%=RESULT %>" id="<%=RESULT %>"
			readonly="readonly" value="" /> <%}%>
		</td>

		<td>
		<%if(dgDetail.getUom() !=null){ %> <input
			name="<%=UNIT_OF_MEASUREMENT_ID %>" id="<%=UNIT_OF_MEASUREMENT_ID %>"
			type="hidden" size="5" value="<%=dgDetail.getUom().getId()%>"
			readonly /> <input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text"
			size="5" value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
		<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
			value="" readonly /> <%} %>
		</td>

		<td>
		<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
			readonly="readonly" value="<%=dgDetail.getNormal().getId() %>"
			readonly /> <input name="normalValue" type="text" size="8"
			readonly="readonly"
			value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<input name="normalValue" type="text" size="8" readonly="readonly"
			value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
			readonly /> <input name="normalId" type="hidden" id="normalId"
			size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
		<input name="normalId" type="hidden" id="normalId" size="5"
			readonly="readonly" value="<%=dgDetail.getNormal().getId() %>"
			readonly /> <input name="normalValue" type="text" size="8"
			readonly="readonly"
			value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
			readonly /> <%}}else{ %> <input name="normalId" type="hidden"
			id="normalId" size="5" readonly="readonly"
			value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
			name="normalValue" type="text" size="8" readonly="readonly" value=""
			readonly /><label>-</label> <%}} %>
		</td>

		<td>
		<%if(dgDetail.getResultDetailStatus().equalsIgnoreCase("P")){ %> <label
			class="value">Pending For Result Validation</label> <%}else if(dgDetail.getResultDetailStatus().equalsIgnoreCase("A")){ %>
		<label class="value">Result is Validated</label> <%}%>
		</td>

		<td>
		<%if(dgDetail.getRemarks() !=null){ %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
			name="<%=ADDITIONAL_REMARKS %>" type="text" readonly="readonly"
			value="" /> <input name="<%=RESULT_DETAIL_ID %>"
			id="<%=RESULT_DETAIL_ID %>" type="hidden" size="5"
			value="<%=dgDetail.getId()%>" readonly /> <%} %>
		</td>
	</tr>


	<%}
    	%>
	<%} %>


	</tbody>
</table>


<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

<%Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List<PatientInvestigationDetails> patientInvestigationList= new ArrayList<PatientInvestigationDetails>();	
	if(map.get("patientInvestigationList")!=null){
		patientInvestigationList = (List)map.get("patientInvestigationList");
	
	}
	
	
	%>

<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdTemplateInvestigation"%>

<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<% 	if(patientInvestigationList.size() == 0){  %>
<h4>No Previous
Investigation</h4>
<% }%>



<table id="investigationGrid" border="0" cellspacing="0" cellpadding="0">
	<tr>


		<th scope="col">Test Name</th>
		<!--  <th scope="col">Test Code</th>
	    <th scope="col">Quantity</th>  -->
		<th scope="col">Clinical Notes</th>

	</tr>
	<%
	    int i=1;
	      for(PatientInvestigationDetails patientInvestigationDetails : patientInvestigationList)
	      {	    	  
	      
	    %>
	<tr>
		<td><input type="text" name="chargeCodeName<%=i%>" tabindex="1"	id="chargeCodeName<%=i%>"	value="<%=patientInvestigationDetails.getChargeCode().getChargeCodeName()%>[<%=patientInvestigationDetails.getChargeCode().getId()%>]"	size="172" />
		<div id="ac2update2" style="display:" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName<%=i%>','ac2update2','fwc?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=i%>'});
				</script>
				<input type="hidden" name="chargeCode<%=i%>" tabindex="1"	id="chargeCode<%=i%>"	value="<%=patientInvestigationDetails.getChargeCode().getChargeCodeCode()%>" size="10" />
				<input type="hidden" name="qty<%=i%>" id="qty<%=i%>" tabindex="1" value="<%=patientInvestigationDetails.getQuantity() %>" />
				</td>
		<td><input type="text" name="clinicalNotes<%=i%>" tabindex="1"	id="clinicalNotes<%=i%>" value="<%=patientInvestigationDetails.getClinicalNotes() %>"	size="172" /></td>
		
	</tr>
	<%i++;} 
	 	if(patientInvestigationList.size() == 0){ %>
	<tr>
		<td><input type="text" name="chargeCodeName<%=i%>" tabindex="1"
			id="chargeCodeName<%=i%>" value="" size="172" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		<script type="text/javascript" language="javascript" charset="utf-8">
					  new Ajax.Autocompleter('chargeCodeName<%=i%>','ac2update2','fwc?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=i%>'});
					</script></div>
		<input type="hidden" name="chargeCode<%=i%>" tabindex="1"	id="chargeCode<%=i%>" value="" size="10" />
		<input type="hidden"	name="qty<%=i%>" tabindex="1" id="qty<%=i%>" value="" size="10" /></td>
		<td><input type="text" name="clinicalNotes<%=i%>" tabindex="1"	id="clinicalNotes<%=i%>" value="" size="172" /></td>

	</tr>

	<% i++; } %>

	<input type="hidden" name="hiddenValue" value="<%=i-1 %>"	id="hiddenValue" />
</table>
<div class="Clear"></div>






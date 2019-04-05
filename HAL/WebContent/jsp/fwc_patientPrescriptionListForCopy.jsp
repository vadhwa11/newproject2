<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>


<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List<PatientPrescriptionDetails> patientPrescriptionList= new ArrayList<PatientPrescriptionDetails>();
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("patientPrescriptionList")!=null){
		patientPrescriptionList = (List)map.get("patientPrescriptionList");
	
	}
	if(map.get("frequencyList") != null){
		frequencyList = (List)map.get("frequencyList");
	}
	
	%>

<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<% 	if(patientPrescriptionList.size() == 0){  %>
<label style="text-align: center; color: red;">No Previous
Prescription</label>
<% }%>

<div class="floatLeft">
<div class="tableHholder">

<table id="grid" border="0" cellspacing="0" cellpadding="0">
	<tr>

		<th scope="col">Nomenclature</th>
		<th scope="col">PVMS No.</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<!--  <th scope="col">Total</th> -->
		<th scope="col">Intake</th>
		<th scope="col">Remarks</th>
	</tr>
	<%
	    int i=1;

	      for(PatientPrescriptionDetails patientPrescriptionDetails : patientPrescriptionList)
	      {
	    	 String frequencyNameFromDB = patientPrescriptionDetails.getFrequency().getFrequencyName();
	    %>
	<tr>
		<td><input type="text" id="nomenclature<%=i%>"
			onblur="populatePVMS(this.value,'<%=i %>'),checkItem();" tabindex="1"
			name="nomenclature<%=i%>"
			value="<%=patientPrescriptionDetails.getItem().getNomenclature()%>[<%=patientPrescriptionDetails.getItem().getPvmsNo()%>]"
			size="50" />
		<div id="ac2update1"
			style="font-weight: normal; display: none; border: 1px solid black; padding-right: 10px; background-color: white;">
		<script type="text/javascript" language="javascript" charset="utf-8">
				  			new Ajax.Autocompleter('nomenclature<%=i%>','ac2update1','fwc?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature<%=i%>'});
				</script></div>
		</td>

		<td><input type="text" name="pvmsNo<%=i%>" id="pvmsNo<%=i%>"
			tabindex="1"
			value="<%=patientPrescriptionDetails.getItem().getPvmsNo()%>"
			size="10" /></td>
		<td><input type="text" name="dosage<%=i%>" id="dosage<%=i%>"
			tabindex="1" value="<%=patientPrescriptionDetails.getDosage() %>"
			size="5" /></td>
		<td><select name="frequency<%=i%>" id="frequency<%=i%>"
			tabindex="1" onclick="fillValueFromFrequency(this.value,'<%=i%>');">
			<option value="0">Select</option>
			<%
	         for(MasFrequency masFrequency : frequencyList){
	        	 String frequencyName=masFrequency.getFrequencyName();
	        	 if(frequencyName.equals(frequencyNameFromDB)){ 
	       %>
			<option value="<%=masFrequency.getId() %>" selected="selected"><%=frequencyNameFromDB %></option>
			<%}else{ %>
			<option value="<%=masFrequency.getId() %>"><%=masFrequency.getFrequencyName() %></option>
			<%}} %>
		</select></td>
		<td><input type="text" name="noOfDays<%=i%>" tabindex="1"
			id="noOfDays<%=i%>" onblur="fillValue(this.value,'<%=i%>');"
			value="<%=patientPrescriptionDetails.getNoOfDays() %>" size="3" />
		<input type="hidden" name="total<%=i%>" id="total<%=i%>" tabindex="1"
			value="<%=patientPrescriptionDetails.getTotal() %>" size="5" /></td>
		<td><select name="instructionACPC<%=i %>"
			id="instructionACPC<%=i %>" tabindex="1">
			<option value="">Select</option>
			<option value="AC">AC</option>
			<option value="PC">PC</option>
		</select></td>

		<td><input type="text" name="typeLeftRight<%=i %>" tabindex="1"
			size="50" id="typeLeftRight<%=i %>" maxlength="195" /> <!--<select name="typeLeftRight<%=i %>"  id="typeLeftRight<%=i %>" tabindex="1">
			    <option value="">Select</option>
			    <option value="left">Left</option>
			    <option value="right">Right</option>
		    </select>--></td>

	</tr>

	<%i++;}
	      if(patientPrescriptionList.size() == 0){ 

	      %>

	<tr>
		<td><input type="text" id="nomenclature<%=i%>" tabindex="1"
			name="nomenclature<%=i%>" value=""
			onblur="populatePVMS(this.value,'<%=i %>'),checkItem();" size="50" />

		<div id="ac2update1"
			style="font-weight: normal; display: none; border: 1px solid black; padding-right: 10px; background-color: white;">
		<script type="text/javascript" language="javascript" charset="utf-8">
				  			new Ajax.Autocompleter('nomenclature1','ac2update1','fwc?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
						</script></div>
		</td>
		<td><input type="text" name="pvmsNo<%=i%>" tabindex="1"
			id="pvmsNo<%=i%>" value="" size="10" /></td>
		<td><input type="text" name="dosage<%=i%>" tabindex="1"
			id="dosage<%=i%>" value="" size="5" /></td>
		<td><select name="frequency<%=i%>" id="frequency<%=i%>"
			tabindex="1" onclick="fillValueFromFrequency(this.value,'<%=i%>');">
			<option value="0">Select</option>
			<%
	         for(MasFrequency masFrequency : frequencyList){
	        	 String frequencyName=masFrequency.getFrequencyName();
	       %>

			<option value="<%=masFrequency.getId() %>"><%=masFrequency.getFrequencyName() %></option>
			<%} %>
		</select></td>
		<td><input type="text" name="noOfDays<%=i%>" tabindex="1"
			id="noOfDays<%=i%>" onblur="fillValue(this.value,'<%=i%>');" value=""
			size="3" /> <input type="hidden" name="total<%=i%>" tabindex="1"
			id="total<%=i%>" value="" size="5" /></td>
		<td><select name="instructionACPC<%=i %>"
			id="instructionACPC<%=i %>" tabindex="1">
			<option value="">Select</option>
			<option value="AC">AC</option>
			<option value="PC">PC</option>
		</select></td>

		<td><input type="text" name="typeLeftRight<%=i %>" tabindex="1"
			size="50" id="typeLeftRight<%=i %>" maxlength="195" /> <!--<select name="typeLeftRight<%=i %>" id="typeLeftRight<%=i %>"  tabindex="1">
			    <option value="">Select</option>
			    <option value="left">Left</option>
			    <option value="right">Right</option>
		    </select>--></td>

	</tr>
	<% i++; } %>
	<input type="hidden" name="hdb" value="<%=i-1 %>" id="hdb" />
</table>
<div class="Clear"></div>
<br />
</div>
</div>



</script>

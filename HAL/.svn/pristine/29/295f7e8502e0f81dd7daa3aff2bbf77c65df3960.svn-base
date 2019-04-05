<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>


<%Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List treatmentTemplateList= new ArrayList();
	List frequencyList= new ArrayList();
	if(map.get("treatmentTemplateList") != null){
		treatmentTemplateList = (List)map.get("treatmentTemplateList");
	}
	if(map.get("frequencyList") != null){
		frequencyList = (List)map.get("frequencyList");
	}
	
	%>

<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
	<div class="cmntable">
<table id="grid" border="0" cellspacing="0" cellpadding="0">

	<tr>


		<th scope="col">Nomenclature</th>
		<th scope="col"></th>
		<th scope="col">PVMS No.</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<!--  <th scope="col">Total</th> -->
		<th scope="col">Intake</th>
		<!--<th scope="col">Type</th> -->
		<th scope="col">Remarks</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<%
	    int i=1;
	       Iterator itr=treatmentTemplateList.iterator();
	       if(treatmentTemplateList!=null&&treatmentTemplateList.size()>0)
	       {
	      while(itr.hasNext())
	      {
	    	  OpdTemplateTreatment opdTemplateTreatment=(OpdTemplateTreatment)itr.next();
	    	  String frequencyNameFromDB=opdTemplateTreatment.getFrequency().getFrequencyName();
	    	  int frquencyId=opdTemplateTreatment.getFrequency().getId();
	      
	    %>
	<tr>
	     <td><input type="text" id="nomenclature<%=i%>"	name="nomenclature<%=i%>" tabindex="1"	value="<%=opdTemplateTreatment.getItem().getNomenclature()%>[<%=opdTemplateTreatment.getItem().getPvmsNo()%>]"	readonly size="50" />
		<div id="ac2update1"	style="display: none;" class="autocomplete">
		</div>
		</td>
 <td><IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();"></td> 
		
		<td><input type="text" name="pvms<%=i%>" tabindex="1"	value="<%=opdTemplateTreatment.getItem().getPvmsNo()%>" readonly	size="10" /></td>
		<td><input type="text" name="dosage<%=i%>" id="dosage<%=i%>" tabindex="1"		value="<%=opdTemplateTreatment.getDosage() %>" size="5" maxlength="5"/></td>
		<td><select name="frequency<%=i%>" tabindex="1"	id="frequency<%=i%>">
			<option value="0">Select</option>
			<%
	         for(Iterator itr1=frequencyList.iterator();itr1.hasNext();){
	        	 MasFrequency frequency=(MasFrequency)itr1.next();
	        	 String frequencyName=frequency.getFrequencyName();
	        	 if(frequencyName.equals(frequencyNameFromDB)){ 
	       %>
			<option value="<%=frquencyId %>" selected><%=frequencyNameFromDB %></option>
			<%}else{ %>
			<option value="<%=frequency.getId() %>"><%=frequency.getFrequencyName() %></option>
			<%}} %>
		</select>
		</td>
		<td>
		<input type="text" name="noOfDays<%=i%>" id="noOfDays<%=i%>" tabindex="1"	value="" size="3" maxlength="3"/>
		</td>
		<td>
		<select name="instructionACPC<%=i %>" tabindex="1"	id="instructionACPC<%=i %>" tabindex="1">
			<option value="">Select</option>
			<option value="AC">AC</option>
			<option value="PC">PC</option>
		</select>
		</td>

	<!--	<td><select name="typeLeftRight<%=i %>" id="typeLeftRight<%=i %>" tabindex="1">
			<option value="">Select</option>
			<option value="left">Left</option>
			<option value="right">Right</option>
		</select></td> -->
		
		
			<td><input type="text" name="remarks<%=i%>" tabindex="1" id="remarks<%=i%>"  size="10" maxlength="40" validate="Remarks,string,no" />
			</td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
			</td>
			</tr>

	<%i++;} %>
	<input type="hidden" name="hdb" value="<%=i-1 %>" id="hdb" />
	<% }else{%>
	<tr>
	
		<td>
	    <input type="text" value="" tabindex="1" id="nomenclature<%=i%>" size="50"  name="nomenclature<%=i%>" onblur="populatePVMS(this.value,'1'),checkItem();"  />
	    </td>
	    <td>
	    <IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();" title="Click here to Search for Nomenclature">
	     <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature1','ac2update1','fwc?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td> 
		<td><input type="text" name="pvms<%=i%>" tabindex="1"	value="" readonly	size="10" /></td>
		<td><input type="text" name="dosage<%=i%>" id="dosage<%=i%>" tabindex="1"		value="" size="5" maxlength="5"/></td>
		<td><select name="frequency<%=i%>" tabindex="1"	id="frequency<%=i%>">
			<option value="0">Select</option>
			<%
	         for(Iterator itr1=frequencyList.iterator();itr1.hasNext();){
	        	 MasFrequency frequency1=(MasFrequency)itr1.next();
	        	 String frequencyName1=frequency1.getFrequencyName();
	        	 
	       %>
			<option value="<%=frequency1.getId() %>" ><%=frequencyName1 %></option>
			<%}%>
		</select>
		</td>
		<td>
		<input type="text" name="noOfDays<%=i%>" id="noOfDays<%=i%>" tabindex="1"	value="" size="3"	maxlength="3"  />
		</td>
		<td>
		<select name="instructionACPC<%=i %>" tabindex="1"	id="instructionACPC<%=i %>" tabindex="1">
			<option value="">Select</option>
			<option value="AC">AC</option>
			<option value="PC">PC</option>
		</select>
		</td>

	<!--	<td><select name="typeLeftRight<%=i %>" id="typeLeftRight<%=i %>" tabindex="1">
			<option value="">Select</option>
			<option value="left">Left</option>
			<option value="right">Right</option>
		</select></td> --->
		
		
			<td><input type="text" name="remarks<%=i%>" tabindex="1" id="remarks<%=i%>"  size="10" maxlength="40"  validate="Remarks,string,no" />
			</td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
			</td>
			</tr>
	
	<input type="hidden" name="hdb" value="<%=i %>" id="hdb" />
	<% }%>
</table>
<div class="Clear"></div>
</div>




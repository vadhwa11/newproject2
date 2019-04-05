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
	List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
	if(map.get("itemConversionList") != null){
		itemConversionList=(List)map.get("itemConversionList");
		}
	List<Object[]> stockList = new ArrayList<Object[]>();
	if(map.get("stockList") != null){
		stockList=(List<Object[]>)map.get("stockList");
		}
	%>

<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>

<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%>
<%@page import="java.math.BigDecimal"%><script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
	<div class="small">
<table id="grid" border="0" cellspacing="0" cellpadding="0">

	<tr>


		 <th>Nomenclature</th>
	   <!--  <th colspan="1">Other Drug</th> -->
			<!-- <th scope="col">Unit</th> -->
		<!-- <th scope="col">AU</th> -->
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">Days</th>
		<th scope="col">Route</th>
		<th scope="col">Remarks</th>
	<!-- 	<th scope="col">CT</th> -->
		<!-- <th scope="col">Stock</th> -->
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
	    	  BigDecimal stock = new BigDecimal(0);
	    	  if(stockList.size() > 0){
	    		  for(Object[] obj : stockList){
	    			  if(opdTemplateTreatment.getItem().getId() == Integer.parseInt(obj[1].toString())){
	    				  stock = new BigDecimal(obj[0].toString());
	    				  break;
	    			  }
	    			  
	    		  }
	    	  }
	      
	    %>
	<tr>
	     <td><input type="text" id="nomenclature<%=i%>"	name="nomenclature<%=i%>" tabindex="1"	value="<%=opdTemplateTreatment.getItem().getNomenclature()%>(<%=opdTemplateTreatment.getItem().getId() %>)[<%=opdTemplateTreatment.getItem().getPvmsNo()%>]"	readonly="readonly" size="30" />
		<div id="ac2update1"	style="display: none;" class="autocomplete">
		</div>
		</td>
		<%-- <td><input type="text" name="otherMedicine<%=i %>" tabindex="1" id="otherMedicine<%=i %>"  size="20" onblur="checkDuplicateOtherMedicine(this.value,'1');readOnlyNomenclature(this.value,'1');showSimilarMedicineNames(this.value);" validate="other Medicine,string,no" /></td> --%>
	<%-- 	<td><select name="itemConversionId<%=i %>" id="itemConversionId<%=i %>" tabindex="1" class="medium" disabled="disabled" >
			<option value="0">Select</option>
		</select>
		
		</td> --%>
		<%-- <td>
		<input type="text" name="au<%=i%>" tabindex="1" value="<%=(opdTemplateTreatment.getItem().getItemConversion()!=null?opdTemplateTreatment.getItem().getItemConversion().getItemUnitName():"") %>" id="au<%=i%>"  size="6"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty<%=i%>" tabindex="1" id="actualDispensingQty<%=i%>" value="<%=(opdTemplateTreatment.getItem().getADispQty()!=null?opdTemplateTreatment.getItem().getADispQty():"") %>"  size="6"  validate="AU,string,no" />
			</td> --%>
		<td>
		<input type="hidden" name="pvmsNo<%=i%>" id="pvmsNo<%=i%>" value="<%=opdTemplateTreatment.getItem().getPvmsNo()%>" size="10" readonly="readonly" />
		<input type="text" name="dosage<%=i%>" id="dosage<%=i%>" tabindex="1"		value="<%=(opdTemplateTreatment.getDosage()!=null?opdTemplateTreatment.getDosage():"") %>" size="5" maxlength="5"/></td>
		<td><select name="treatmentFrequency<%=i%>" tabindex="1"	id="frequency<%=i%>" class="small"  >
			<option value="0">Select</option>
			<%
			BigDecimal freqVal = new BigDecimal(0);
			BigDecimal total = new BigDecimal(0);
	         for(Iterator itr1=frequencyList.iterator();itr1.hasNext();){
	        	 MasFrequency frequency=(MasFrequency)itr1.next();
	        	 String frequencyName=frequency.getFrequencyName();
	        	 if(frequencyName.equals(frequencyNameFromDB)){ 
	        		 freqVal = frequency.getFeq();
	       %>
			<option value="<%=frquencyId %>" selected><%=frequencyNameFromDB %></option>
			<%}else{ %>
			<option value="<%=frequency.getId() %>"><%=frequency.getFrequencyName() %></option>
			<%}}
	         total = (freqVal.multiply(new BigDecimal(opdTemplateTreatment.getDosage()!=null?opdTemplateTreatment.getDosage():"0"))).multiply(new BigDecimal(opdTemplateTreatment.getNoofdays()!=null?opdTemplateTreatment.getNoofdays():0));
	         %>
		</select>
		<input type="hidden" name="frequencyValue1" id="frequencyValue1" value="<%=freqVal %>">
		</td>
		<td>
		<input type="text" name="noOfDays<%=i%>" id="noOfDays<%=i%>" tabindex="1"	value="<%=(opdTemplateTreatment.getNoofdays()!=null?opdTemplateTreatment.getNoofdays():"" )%>" size="3" maxlength="3"/>
		</td>
		<td>
		<input type="text" name="route<%=i%>" tabindex="1" id="route<%=i%>" value=""  size="5" maxlength="20"	 validate="Route,string,no" />
			<input type="hidden" name="total<%=i%>" tabindex="1" id="total<%=i%>"  value="<%=total %>"/></td>



	<!--	<td><select name="typeLeftRight<%=i %>" id="typeLeftRight<%=i %>" tabindex="1">
			<option value="">Select</option>
			<option value="left">Left</option>
			<option value="right">Right</option>
		</select></td> -->
			<td><input type="text" name="treatRemarks<%=i%>" tabindex="1" id="treatRemarks<%=i%>"  size="10" maxlength="40" validate="Remarks,string,no" />
			</td>
	<%-- 	<td><input type="checkbox" name="ct<%=i%>" class="radio" id="ct<%=i%>" value="y" />
		</td> --%>
		<%-- <td><input type="text" name="closingStock<%=i%>" disabled="disabled" tabindex="1" value="<%=stock %>" id="closingStock<%=i%>"  size="3"  validate="closingStock,string,no" /></td> --%>
		
		
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
	    <input type="text" value="" tabindex="1" id="nomenclature<%=i%>" size="30"  name="nomenclature<%=i%>" onblur="populatePVMS(this.value,'1'),checkItem();"  />
	    </td>
	   <!--  <td>
	    <IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch();" title="Click here to Search for Nomenclature">
	     <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>  -->
		<%-- <td><input type="text" name="pvms<%=i%>" tabindex="1"	value="" readonly	size="10" /></td> --%>
		<td><input type="text" name="dosage<%=i%>" id="dosage<%=i%>" tabindex="1"		value="" size="5" maxlength="5"/></td>
		<td><select name="treatmentFrequency<%=i%>" tabindex="1" class="small" id="frequency<%=i%>">
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
	<%-- 	<td>
		<select name="instructionACPC<%=i %>" tabindex="1"	id="instructionACPC<%=i %>" tabindex="1">
			<option value="">Select</option>
			<option value="AC">AC</option>
			<option value="PC">PC</option>
		</select>
		</td> --%>
		<td>
		<input type="text" name="route<%=i%>" tabindex="1" id="route<%=i%>" value=""  size="5" maxlength="20" value="PO" 	 validate="Route,string,no" />
			<input type="hidden" name="total<%=i%>" tabindex="1" id="total<%=i%>"  /></td>

	<!--	<td><select name="typeLeftRight<%=i %>" id="typeLeftRight<%=i %>" tabindex="1">
			<option value="">Select</option>
			<option value="left">Left</option>
			<option value="right">Right</option>
		</select></td> --->
		
		
			<td><input type="text" name="treatRemarks<%=i%>" tabindex="1" id="treatRemarks<%=i%>"  size="10" maxlength="40"  validate="Remarks,string,no" />
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




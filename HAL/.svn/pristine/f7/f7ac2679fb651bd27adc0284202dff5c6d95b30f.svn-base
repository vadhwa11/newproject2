<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>


<%Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List treatmentTemplateList= new ArrayList();
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
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
	
	List <MasItemClass> masItemClassList =new ArrayList<MasItemClass>();
    if(map.get("masItemClassList") != null){
    	masItemClassList = (List<MasItemClass>) map.get("masItemClassList");
    			}
    
    int hinId = 0;
    if(map.get("hinId") != null){
    	hinId = (Integer) map.get("hinId");
    }

        int totalRow = 0;
        if(map.get("totalRow") != null){
        	totalRow = (Integer) map.get("totalRow");
    			}
        String itemIdArray[] = {};
        if(map.get("itemIdArray") != null){
        	itemIdArray = (String[]) map.get("itemIdArray");
    			}
        List<Integer> itemIdList= new ArrayList<Integer>();
        for(int i=0; i<itemIdArray.length;i++){
        	if(!itemIdArray[i].isEmpty())
        	itemIdList.add(Integer.parseInt(itemIdArray[i]));}
        
		List<Integer> currentPrescriptionIdList = new ArrayList<Integer>();
        if(map.get("currentPrescriptionIdList") != null){
        	currentPrescriptionIdList = (List<Integer>) map.get("currentPrescriptionIdList");
        			}
	%>

<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>

<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%>
<%@page import="java.math.BigDecimal"%>

	<%
	    int inc1=totalRow;
	       Iterator itr=treatmentTemplateList.iterator();
	       if(treatmentTemplateList!=null&&treatmentTemplateList.size()>0)
	       {
	      while(itr.hasNext())
	      {
	    	  OpdTemplateTreatment opdTemplateTreatment=(OpdTemplateTreatment)itr.next();
	    	  if(itemIdList.contains(opdTemplateTreatment.getItem().getId()) || currentPrescriptionIdList.contains(opdTemplateTreatment.getItem().getId()))
	    			  continue;
	    	  
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
	<%
	  if(stock.doubleValue()> 0)
	  {
		 %><tr><%		 
		  
	  }
	  else
	  {
		  %><tr bgcolor= "#FA8072"><%	
	  }
	%>
	     <%-- <td><input type="text" id="nomenclature<%=inc1%>"	name="nomenclature<%=inc1%>" tabindex="1"	value="<%=opdTemplateTreatment.getItem().getNomenclature()%>(<%=opdTemplateTreatment.getItem().getId() %>)[<%=opdTemplateTreatment.getItem().getPvmsNo()%>]"	readonly="readonly" size="77" /> --%>
	     <td><input type="text" id="nomenclature<%=inc1%>"	name="nomenclature<%=inc1%>" tabindex="1" value="<%=opdTemplateTreatment.getItem().getNomenclature()%>[<%=opdTemplateTreatment.getItem().getPvmsNo()%>]"	readonly="readonly" size="77" />
		 <input type="hidden" name="itemId<%=inc1%>" id="itemId<%=inc1%>"	value="<%=opdTemplateTreatment.getItem().getId()%>" />
		<div id="ac2update1"	style="display: none;" class="autocomplete">
		</div>
		</td>
		<%-- <td><input type="text" name="otherMedicine<%=inc1 %>" tabindex="1" id="otherMedicine<%=inc1 %>"  size="20" disabled="disabled"/></td> --%>
	<%-- 	<td><select name="itemConversionId<%=i %>" id="itemConversionId<%=i %>" tabindex="1" class="medium" disabled="disabled" >
			<option value="0">Select</option>
		</select>
		
		</td> --%>
<%-- 		<td>
		<input type="text" name="au<%=inc1%>" tabindex="1" value="<%=(opdTemplateTreatment.getItem().getItemConversion()!=null?opdTemplateTreatment.getItem().getItemConversion().getItemUnitName():"") %>" id="au<%=inc1%>"  size="6"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty<%=inc1%>" tabindex="1" id="actualDispensingQty<%=inc1%>" value="<%=(opdTemplateTreatment.getItem().getADispQty()!=null?opdTemplateTreatment.getItem().getADispQty():"") %>"  size="6"  validate="AU,string,no" />
			</td> --%>
<%-- 			
			<td><select name="itemClass<%=inc1%>" id="itemClass<%=inc1%>" disabled="disabled">
		<option value="0">Select</option>
		<%for(MasItemClass mc : masItemClassList) {
		  if(mc.getId() == opdTemplateTreatment.getItem().getItemClass().getId())
		       {		 	
		    %>	   <option value="<%=mc.getId()%>" selected="selected"><%=mc.getItemClassName()%></option>
		      <% }else{
          %>
			<option value="<%=mc.getId()%>"><%=mc.getItemClassName()%></option>
			<%} }%> 
			
		</select>
		
				<%
				MasItemClass  Mic = null;

			     for (int i = 0; i < masItemClassList.size(); i++) {
			    	 Mic = (MasItemClass) masItemClassList.get(i);
     			 %> <script>

     			itemClassArray[<%=inc1%>]= new Array();
     			itemClassArray[<%=inc1%>][0] = "<%=Mic.getId()%>";
     			itemClassArray[<%=inc1%>][1] = "<%=Mic.getItemClassName()%>";
            </script> <% }%>
		
		</td> --%>
		 <%-- 		<td><select name="itemConversionId<%=inc1%>" id="itemConversionId<%=inc1%>" tabindex="1" class="medium"  disabled="disabled">
			<option value="0">Select</option>
		 	<%

		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       if(masStoreItemConversion.getId() == opdTemplateTreatment.getItem().getItemConversion().getId())
		       {		 	
		    %>	   <option value="<%=masStoreItemConversion.getId() %>" selected="selected"><%=masStoreItemConversion.getItemUnitName()%></option>
		      <% }else{
          %>
			<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
			<%} }%> 
		</select>
 		<%
	    		MasStoreItemConversion  masStoreItemConversion1 = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion1 = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=inc1%>]= new Array();
     			unitArray[<%=inc1%>][0] = "<%=masStoreItemConversion1.getId()%>";
     			unitArray[<%=inc1%>][1] = "<%=masStoreItemConversion1.getItemUnitName()%>";
            </script> <% }%> 
		<!-- </td> 
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" /> -->
		<input type="hidden" name="au<%=inc1%>" tabindex="1" value="" id="au<%=inc1%>"  size="6"  validate="AU,string,no" />
		</td> --%>
<%-- <%if(au != null){ %>
		<td>
		<input type="text" name="au<%=inc1%>" tabindex="1" value="<%=au %>" id="au<%=inc1%>" readonly="readonly" size="6"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty<%=inc1%>" tabindex="1" id="actualDispensingQty<%=inc1%>" value=""  size="6"  validate="AU,string,no" />
		<input type="hidden" name="highValueMedicine<%=inc1%>" tabindex="1" id="highValueMedicine<%=inc1%>" value=""  size="1"  validate="AU,string,no" />
			</td>
			<%}else{ %>
			<td>
		<input type="text" name="au<%=inc1%>" tabindex="1" value="" id="au<%=inc1%>"  size="6"  readonly="readonly"  validate="AU,string,no" />
		<input type="hidden" name="actualDispensingQty<%=inc1%>" tabindex="1" id="actualDispensingQty<%=inc1%>" value=""  size="6"  validate="AU,string,no" />
		<input type="hidden" name="highValueMedicine<%=inc1%>" tabindex="1" id="highValueMedicine<%=inc1%>" value=""  size="1"  validate="AU,string,no" />
			</td>
			<%} %> --%>
			
					<td>
					<input type="text" name="dispensingUnit<%=inc1%>" tabindex="1" id="dispensingUnit<%=inc1%>"  size="6"  validate="AU,string,no" value="<%=opdTemplateTreatment.getItem().getDispUnit() %>" readonly="readonly"/>
<%-- 		<select name="dispensingUnit<%=inc1%>" id="dispensingUnit<%=inc1%>" tabindex="1" class="medium"  disabled="disabled">
			<option value="0">Select</option>
			<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
		    	     if(opdTemplateTreatment.getItem().getDispUnit()!=null&& masStoreItemConversion.getItemUnitName()!=null && masStoreItemConversion.getItemUnitName().equalsIgnoreCase(opdTemplateTreatment.getItem().getDispUnit()))
				       {		 	
				    %>	   <option value="<%=masStoreItemConversion.getItemUnitName() %>" selected="selected"><%=masStoreItemConversion.getItemUnitName()%></option>
				      <% }else{
		          %>
					<option value="<%=masStoreItemConversion.getItemUnitName() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
					<%} }%> 
		</select> --%>
		<input type="hidden" name="actualDispensingQty<%=inc1%>" tabindex="1" id="actualDispensingQty<%=inc1%>" value="<%=opdTemplateTreatment.getItem().getADispQty() %>"  size="6"  validate="AU,string,no" />
		<input type="hidden" tabindex="1" id="itemClassCode<%=inc1%>" name="itemClassCode<%=inc1%>" validate="itemClassCode,string,no" value="<%=opdTemplateTreatment.getItem().getItemClass().getItemClassCode()%>" />
							
						
		<input type="hidden" tabindex="1" id="highValueMedicine<%=inc1%>" name="highValueMedicine<%=inc1%>" validate="AU,string,no" value=""/>  
		
		</td>
		<td>
		<input type="hidden" name="pvmsNo<%=inc1%>" id="pvmsNo<%=inc1%>" value="<%=opdTemplateTreatment.getItem().getPvmsNo()%>" size="10" readonly="readonly" />
		<input type="text" name="dosage<%=inc1%>" id="dosage<%=inc1%>" tabindex="1"		value="<%=(opdTemplateTreatment.getDosage()!=null?opdTemplateTreatment.getDosage():"") %>" size="5" maxlength="5" onblur="fillValue('<%=inc1%>')"/></td>
		<td><select name="frequency<%=inc1%>" tabindex="1"	id="frequency<%=inc1%>" class="medium" onchange="getFrequencyValue(this.value,'<%=inc1%>');fillValueFromFrequency(this.value,'<%=inc1%>');displaySOSQty(this.value,'<%=inc1%>');fillValue('<%=inc1%>')">
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
	        // total = (freqVal.multiply(new BigDecimal(opdTemplateTreatment.getDosage()!=null?opdTemplateTreatment.getDosage():"0"))).multiply(new BigDecimal(opdTemplateTreatment.getNoofdays()!=null?opdTemplateTreatment.getNoofdays():0));
	        total =     BigDecimal.valueOf(opdTemplateTreatment.getTotal());
	         %>
		</select>
		<input type="hidden" name="frequencyValue<%=inc1%>" id="frequencyValue<%=inc1%>" value="<%=freqVal %>">
		<input type="text" name="sosQty<%=inc1%>" tabindex="1" id="sosQty<%=inc1%>" style="display: none;"   size="3" onblur="fillValue('<%=inc1%>')"	maxlength="3" validate="Sos Qty,num,no" />
		</td>
		<td>
		<input type="text" name="noOfDays<%=inc1%>" id="noOfDays<%=inc1%>" tabindex="1"	value="<%=(opdTemplateTreatment.getNoofdays()!=null?opdTemplateTreatment.getNoofdays():"" )%>" size="5" maxlength="3"  onblur="fillValue('<%=inc1%>')"/>
		</td>
		<td>
		<input type="hidden" name="route<%=inc1%>" tabindex="1" id="route<%=inc1%>" value=""  size="5" maxlength="20"	 validate="Route,string,no" />
			<input type="text" name="total<%=inc1%>" tabindex="1" id="total<%=inc1%>"  value="<%=total %>" validate="total,num,no" size="5"/></td>

<%-- <td><input type="text" name="route<%=inc1%>" tabindex="1" id="route<%=inc1%>"  size="5" maxlength="20" validate="Route,string,no" /></td> --%>

	<!--	<td><select name="typeLeftRight<%=inc1 %>" id="typeLeftRight<%=inc1 %>" tabindex="1">
			<option value="">Select</option>
			<option value="left">Left</option>
			<option value="right">Right</option>
		</select></td> -->
			<td><input type="text" name="remarks<%=inc1%>" tabindex="1" id="remarks<%=inc1%>"  size="10" maxlength="40" validate="Remarks,string,no" placeholder="1-1-1" value="<%=opdTemplateTreatment.getInstruction()!=null?opdTemplateTreatment.getInstruction():"" %>"/>
			</td>
	<%-- 	<td><input type="checkbox" name="ct<%=inc1%>" class="radio" id="ct<%=inc1%>" value="y" />
		</td> --%>
		<td><input type="text" name="closingStock<%=inc1%>" disabled="disabled" tabindex="1" value="<%=stock%>" id="closingStock<%=inc1%>"  size="3"  validate="closingStock,string,no" /></td>
		
		
		<td><input name="Button" type="button" class="buttonAdd"
							value="" onclick="addNomenclatureRow();" tabindex="1" /></td>
						<td><input type="button" name="delete" value=""
							class="buttonDel" onclick="removeRow('nomenclatureGrid','nomenclaturehdb',this);"
							tabindex="1" /></td>
			</tr>

	<%inc1++;} %>
	<input type="hidden" name="nomenclaturehdb" value="<%=inc1-1 %>" id="nomenclaturehdb" />
	<% }else{%>
	
	
	<tr>
						<td><input type="text" value="" tabindex="1"
							id="nomenclature1" size="77" name="nomenclature1"
							onblur="checkForAlreadyIssuedPrescription(this.value,'1');populatePVMS(this.value,'1');checkItem(1);displayAu(this.value,'1','<%=hinId%>');checkForPurchase(this.value,'1');" />
							<input type="hidden" name="itemId1" id="itemId1" value="" />
							<input type="hidden" name="itemIdClassificationId1" id="itemIdClassificationId1" value="" />
							<div id="ac2update1" style="display: none;" class="autocomplete"></div>
							<script type="text/javascript" language="javascript"
								charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			</script></td>
					<!-- 	<td><input type="text" name="otherMedicine1" tabindex="1"
							id="otherMedicine1" size="20"
							onblur="checkDuplicateOtherMedicine(this.value,'1');readOnlyNomenclature(this.value,'1');showSimilarMedicineNames(this.value);"
							validate="other Medicine,string,no" /></td> -->
				<%-- 		<td><select name="itemClass1" id="itemClass1">
								<option value="0">Select</option>
								<%for(MasItemClass mc : masItemClassList) {%>
								<option value="<%=mc.getId()%>"><%=mc.getItemClassName()%></option>
								<%} %>
						</select> <%
				MasItemClass  Mic = null;

			     for (int i = 0; i < masItemClassList.size(); i++) {
			    	 Mic = (MasItemClass) masItemClassList.get(i);
     			 %> <script>

     			itemClassArray[<%=i%>]= new Array();
     			itemClassArray[<%=i%>][0] = "<%=Mic.getId()%>";
     			itemClassArray[<%=i%>][1] = "<%=Mic.getItemClassName()%>";
            </script> <% }%></td> --%>
					<%-- 	<td><select name="itemConversionId1" id="itemConversionId1"
							tabindex="1" class="medium">
								<option value="0">Select</option>
								<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
								<option value="<%=masStoreItemConversion.getId() %>"><%=masStoreItemConversion.getItemUnitName()%></option>
								<%} %>
						</select> <%
	    		MasStoreItemConversion  masStoreItemConversion1 = new MasStoreItemConversion();

			     for (int i = 0; i < itemConversionList.size(); i++) {
			    	 masStoreItemConversion1 = (MasStoreItemConversion) itemConversionList.get(i);
     			 %> <script>

     			unitArray[<%=i%>]= new Array();
     			unitArray[<%=i%>][0] = "<%=masStoreItemConversion1.getId()%>";
     			unitArray[<%=i%>][1] = "<%=masStoreItemConversion1.getItemUnitName()%>";
            </script> <% }%> <!-- </td> 
		<td><input type="text" name="au1" tabindex="1" value="" id="au1"  size="6"  validate="AU,string,no" /> -->
							<input type="hidden" name="au1" tabindex="1" value="" id="au1"
							size="6" validate="AU,string,no" /></td> --%>
						<td>
						<input type="text" name="dispensingUnit1" tabindex="1" id="dispensingUnit1"  size="6"  validate="AU,string,no"  readonly="readonly"/>
						<%-- <select name="dispensingUnit1" id="dispensingUnit1"
							tabindex="1" class="medium">
								<option value="0">Select</option>
								<%
		      for(MasStoreItemConversion masStoreItemConversion: itemConversionList){
		       
          %>
								<option><%=masStoreItemConversion.getItemUnitName()%></option>
								<%} %>
						</select> --%>
						
						 <input type="hidden"
							name="actualDispensingQty1" tabindex="1"
							id="actualDispensingQty1" value="" size="6"
							validate="AU,string,no" /> 
							<input type="hidden" tabindex="1"
							id="itemClassCode1" name="itemClassCode1"
							validate="itemClassCode,string,no" value="" />
							<input type="hidden" tabindex="1"
							id="highValueMedicine1" name="highValueMedicine1"
							validate="highValue,string,no" value="" />
						</td>
						<%-- <td><input type="checkbox" name="injCategory1" class="radio" id="injCategory1" value="y" />
		</td>--%>
						<td><input type="hidden" name="pvmsNo1" tabindex="1"
							id="pvmsNo1" size="10" readonly="readonly" /> <input type="text"
							name="dosage1" tabindex="1" value="" id="dosage1" size="5"
							maxlength="5"
							onblur="checkDosageValidation(this.value,'1');fillValue('1')" /></td>
						<td><select name="frequency1" id="frequency1" tabindex="1"
							class="medium"
							onchange="getFrequencyValue(this.value,'1');fillValueFromFrequency(this.value,'1');displaySOSQty(this.value,'1');fillValue('1')">
								<option value="0">Select</option>
								<%

		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
          %>
								<option value="<%=id %>"><%=name%></option>
								<%} %>
						</select> <%
	    		MasFrequency  masFrequency = new MasFrequency();

			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
     			 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%> <input type="hidden" name="frequencyValue1"
							id="frequencyValue1" value=""> <input type="text"
							name="sosQty1" tabindex="1" id="sosQty1" style="display: none;"
							size="3" onblur="fillValue('1')" maxlength="3"
							validate="Sos Qty,num,no" /></td>
						<td><input type="text" name="noOfDays1" tabindex="1"
							id="noOfDays1" onblur="fillValue('1')" size="5" maxlength="3"
							validate="No of Days,num,no" /></td>
						<td><input type="text" name="total1" tabindex="1" id="total1"
							size="5" validate="total,num,no"/></td>
					<!-- 	<td><input type="text" name="route1" tabindex="1" id="route1"
							value="" size="5" maxlength="20" validate="Route,string,no" /></td> -->
						<!--<td><select name="instructionACPC1" id="instructionACPC1" tabindex="1">
			<option value="">Select</option>
			<option value="AC">AC</option>
			<option value="PC" selected="selected">PC</option>
		</select>	</td>

		<td><select name="typeLeftRight1" id="typeLeftRight1"
			tabindex="1">
			<option value="">Select</option>
			<option value="left">Left</option>
			<option value="right">Right</option>
		</select></td>-->

						<td><input type="text" name="remarks1" tabindex="1"
							id="remarks1" size="10" maxlength="40" placeholder="1-1-1"/></td>
						<!-- <td><input type="checkbox" name="ct1" class="radio" id="ct1" value="y" />
		</td> -->
						<td><input type="text" name="closingStock1" tabindex="1"
							value="" id="closingStock1" size="3"
							validate="closingStock,string,no" /></td>

						<td><input name="Button" type="button" class="buttonAdd"
							value="" onclick="addNomenclatureRow();" tabindex="1" /></td>
						<td><input type="button" name="delete" value=""
							class="buttonDel" onclick="removeRow('nomenclatureGrid','nomenclaturehdb',this);"
							tabindex="1" /></td>
		</tr>
	
	<input type="hidden" name="nomenclaturehdb " value="<%=inc1 %>" id="nomenclaturehdb" />
	<% }%>






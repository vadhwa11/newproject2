<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.CODE"%>
<%@ page import="static jkt.hms.util.RequestConstants.SEARCH_NAME"%>


<%Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List<OpdTemplateTreatment> treatmentTemplateList= new ArrayList<OpdTemplateTreatment>();
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("treatmentTemplateList") != null){
		treatmentTemplateList = (List<OpdTemplateTreatment>)map.get("treatmentTemplateList");
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
	    int inc1=1;
	       Iterator itr=treatmentTemplateList.iterator();
	       if(treatmentTemplateList!=null&&treatmentTemplateList.size()>0)
	       {
	   %>	 
	   <div class="Block">
<label> Template Code </label>
 <input type="text"	name="<%= CODE%>" id="code" value="<%=treatmentTemplateList.get(0).getTemplate()!=null?treatmentTemplateList.get(0).getTemplate().getTemplateCode():""%>" disabled="true"	readonly="readonly" validate="Template Code,string,yes" MAXLENGTH="8"	tabindex=1 />
 <label><span>*</span> Template Name</label>
 <input type="text" name="<%= SEARCH_NAME %>" id="<%= SEARCH_NAME%>" onblur="createTemplateCode();"  validate="Template Name,string,yes" MAXLENGTH="30" tabindex=1 value="<%=treatmentTemplateList.get(0).getTemplate()!=null?treatmentTemplateList.get(0).getTemplate().getTemplateName():""%>" />
   <script>
	document.prescriptionTemplate.<%=CODE%>.focus();
</script>
</div>
	   
	   <table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
		<tr>
		<th scope="col">Nomenclature</th>
		<th scope="col">Material Code</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
			<th scope="col">Total</th>
			<th scope="col">Instruction</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>  
	     <% while(itr.hasNext())
	      {
	    	  OpdTemplateTreatment opdTemplateTreatment=(OpdTemplateTreatment)itr.next();
	   %>

	<tr>
	<td>
	 <input type="text"  tabindex="1" id="nomenclature<%=inc1%>"size="43" validate="Nomenclature,string,yes" 
			name="nomenclature<%=inc1%>" onblur="populatePVMS(this.value,'1');displayAu(this.value,'1','0');checkForPurchase(this.value,'1');" tabindex="1"
			value="<%=opdTemplateTreatment.getItem().getNomenclature()%>"
			/>
			<input type="hidden" name="itemId<%=inc1%>" id="itemId<%=inc1%>" value="<%=opdTemplateTreatment.getItem().getId()%>" />
			<input type="hidden" tabindex="1"	id="templateTreatmentId<%=inc1%>" name="templateTreatmentId<%=inc1%>" size = "30" readonly="readonly" value="<%=opdTemplateTreatment.getId()%>"/>
		<div id="ac2update1"	style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature<%=inc1%>','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature<%=inc1%>'});
			</script></td>
			
		<td><input type="text" name="pvmsNo1" tabindex="1" id="pvmsNo<%=inc1%>"	validate="MET No.,string,yes" size="10" readonly="readonly" value="<%=opdTemplateTreatment.getItem().getPvmsNo()%>" />
		<input type="hidden"
						name="highValueMedicine<%=inc1%>" tabindex="1"
						id="highValueMedicine<%=inc1%>" value="" size="1"
						validate="High value Medicine,string,no" />
						
	<input type="hidden" tabindex="1" id="itemClassCode<%=inc1%>" name="itemClassCode<%=inc1%>" validate="itemClassCode,string,no" value="<%=opdTemplateTreatment.getItem().getItemClass().getItemClassCode()%>"/>
							
							
		</td>
		<td><input type="text" name="dosage<%=inc1%>" tabindex="1" id="dosage<%=inc1%>"	validate="Dosage,string,yes" size="5" onblur="fillValue('<%=inc1%>')" maxlength="5" value="<%=opdTemplateTreatment.getDosage()%>"/></td>
		<td>
		<select name="frequency<%=inc1%>" id="frequency<%=inc1%>"  class="medium"  
			tabindex="1" onchange="getFrequencyValue(this.value,'<%=inc1%>');fillValueFromFrequency(this.value,'<%=inc1%>');displaySOSQty(this.value,'<%=inc1%>');fillValue('<%=inc1%>')">
			<option value="0">Select</option>
			<%
				for (MasFrequency masFrequency : frequencyList) {
									if(masFrequency.getId()==opdTemplateTreatment.getFrequency().getId()){
			%>

			<option value="<%=masFrequency.getId()%>" selected="selected"><%=masFrequency.getFrequencyName()%></option>
			<%
				}else{
					%>
					<option value="<%=masFrequency.getId()%>"><%=masFrequency.getFrequencyName()%></option>
				<%}
				}
			%>
		</select>
		 <% 
	    		MasFrequency  masFrequency = new MasFrequency();
	    		  
			         for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
    			 %> <script>
	    	  
	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%>
            <input type="hidden" name="frequencyValue<%=inc1%>"
							id="frequencyValue<%=inc1%>" value="<%=opdTemplateTreatment.getFrequency().getFeq()%>"> <input type="text"
							name="sosQty<%=inc1%>" tabindex="1" id="sosQty<%=inc1%>" style="display: none;"
							size="3" onblur="fillValue('<%=inc1%>')" maxlength="3"
							validate="Sos Qty,num,no" />
<input type="hidden"
							name="actualDispensingQty<%=inc1%>" tabindex="1"
							id="actualDispensingQty<%=inc1%>" value="<%=opdTemplateTreatment.getItem().getADispQty()%>" size="6"
							validate="AU,string,no" />							
		</td>
		<td><input type="text" name="noOfDays<%=inc1%>" tabindex="1" id="noOfDays<%=inc1%>" onblur="fillValue(<%=inc1%>)" size="7" maxlength="3" validate="No Of Days,int,yes" value="<%=opdTemplateTreatment.getNoofdays()%>"/></td>
		<td><input type="text" name="total<%=inc1%>" tabindex="1" id="total<%=inc1%>" size="3" validate="total,num,no" value="<%=opdTemplateTreatment.getTotal()%>"/>
		<td>
			<input type="text" name="instruction<%=inc1%>" tabindex="1" id="instruction<%=inc1%>" size="10" maxlength="15" placeholder="1-1-1" value="<%=opdTemplateTreatment.getInstruction()!=null?opdTemplateTreatment.getInstruction():""%>"/>
		</td>
		
		<!-- <td><input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/>
		</td> -->
			<td><input type="button" tabindex="1" class="buttonAdd" alt="Add" onclick="addRow();" value="" align="right" /></td>
			<td><input type="button" tabindex="1"	class="buttonDel" alt="Delete" value="" onclick="removeRow('grid','hdb',this);" /></td>
	</tr>

	<%inc1++;} %>
	<input type="hidden" name="hdb" value="<%=inc1%>" id="hdb" /></td>
	</table>
	
	<input type="button" name="add" id="addbutton" value="Save"	class="button" onClick="submitWindow();" accesskey="a" tabindex=1 />
	<input type="button" name="add" id="addbutton" value="Delete Template"	class="button" onClick="deleteTemplate();" accesskey="a" tabindex=1 />
<input	type="reset" name="Reset" id="reset" value="Close" class="button"	onclick="closeWindow();" accesskey="r" />
	<% }%>



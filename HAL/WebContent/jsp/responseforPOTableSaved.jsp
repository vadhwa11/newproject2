<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="jkt.hms.masters.business.StoreQuotationRequestT"%>
    <%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@ page import="java.util.*"%>
<%@ page import="java.math.BigDecimal"%>
<%

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<StoreQuotationRequestT> quotationList = new ArrayList<StoreQuotationRequestT>();
	List<StorePoDetail> poDetails = new ArrayList<StorePoDetail>();
	
	List<Object[]> poListforGRN = new ArrayList<Object[]>();

	
 if(map.get("quotationList") != null){
	 
	 quotationList=(List<StoreQuotationRequestT>)map.get("quotationList");
 }
 
	
 if(map.get("poDetails") != null)
 {
	 poDetails =  (List<StorePoDetail>)map.get("poDetails");	  
	   
  }	
 
//out.print("quotationList="+quotationList.size());

 
%>
<div class="cmntable">
<table id="MPRGrid">
		
		<tr id="th">
		
         
          <th width="5%">Select Item <input type="checkbox" onclick='checkAll(); getQuotationId();' id="chkAll"/></th>	      
	      <th width="5%">Mat Code</th>
	      <th width="20%">Nomenclature</th>
	      <th width="5%">A/U</th>
	      <th width="5%">Manufacturer</th>
	      <th width="5%">Brand</th>
	      <th width="10%">Qty Req.</th>
	      <th width="15%">Unit Rate</th>	      
		   <th width="13%">Item Value</th>
		   <th width="13%">Chemical Composition</th>
		 	
	   
	      
    	</tr>
    	<%
    	int manufacturerId = 0;
		String manufacturerName = ""; 
		int brandId = 0;
		String brandName = ""; 
		BigDecimal txtUnitRate = new BigDecimal(0.0);
		BigDecimal txtItemValue =  new BigDecimal(0.0);
		String chemicalComposition = "";
		String checked = "false";
		
    	for(StoreQuotationRequestT list : quotationList)
    	{
    		
    	 	int counter =1;
    	 	
    	 	 manufacturerId = 0;
			 manufacturerName = ""; 
			 brandId = 0;
			 brandName = ""; 			
			 chemicalComposition = "";
			 txtUnitRate = new BigDecimal(0.0);
			 txtItemValue =  new BigDecimal(0.0);
			 checked="false";
			
    			for(StorePoDetail detailsList :poDetails)
    			{
    				
    				if(detailsList.getQuotationDetails().getId()==list.getId())
    				{
    					manufacturerId = (detailsList.getManufacturer()!=null?detailsList.getManufacturer().getId():0);
    					manufacturerName = (detailsList.getManufacturer()!=null?detailsList.getManufacturer().getManufacturerName():"");
    					
    					brandId = (detailsList.getBrand()!=null?detailsList.getBrand().getId():0);
    					brandName = (detailsList.getBrand()!=null?detailsList.getBrand().getBrandName():"");
    					txtUnitRate = (detailsList.getUnitRate()!=null?detailsList.getUnitRate():txtUnitRate);
    					txtItemValue = (detailsList.getAmount()!=null?detailsList.getAmount():txtItemValue);
    					chemicalComposition= (detailsList.getChemicalComposition()!=null?detailsList.getChemicalComposition():"");
    					checked="true";
    				}
    			}
    		%>
			    		<tr id="<%out.print(list.getId()); %>">
			    		<td><input type='checkbox' name='chk"+i+"' id='chk'  checked ="<%=checked%>" onclick='getQuotationId();' style='margin-right:0px;' value='<%out.print(list.getId()); %>'/></td>
			      
							
				  
			     
			      <td> <input  type="text"  size="15" class='medium3' id='txtMatCode<%out.print(list.getId()); %>' nme='txtMatCode<%out.print(list.getId()); %>'   readonly value='<%out.print(list.getMprDetails().getItem().getPvmsNo()); %>' />
			      
			      </td>
			      <td> <input  type="text"  size="60" class='medium3' id='txtItem<%out.print(list.getId()); %>' name='txtItem<%out.print(list.getId()); %>'   readonly value='<%out.print(list.getMprDetails().getItem().getNomenclature()); %>' />
			      <input  type="hidden"   id='txtItemId<%out.print(list.getId()); %>' name='txtItemId<%out.print(list.getId()); %>'   readonly value='<%out.print(list.getMprDetails().getItem().getId()); %>' /></td>
					 
			      <td>
			      <input type="text" value="<%out.print(list.getMprDetails().getItem().getItemConversion().getItemUnitName()); %>" class="smcaption" readonly="readonly" name="AV<%out.print(list.getId()); %>" id="idAu<%out.print(list.getId()); %>" tabindex="1" validate="A/U ,String,no" size="8"/>
			      </td>
			      <td> <input  type="text"  size="30" class='MasterData' value="<%=manufacturerName%>" validate="Manufacturer Value,string,yes"  id='Manufacturer_<%out.print(list.getId()); %>'  name='ManufacturerName' size='30' autocomplete='off'  />
			      <p id='Manufacturer_addNew<%out.print(list.getId()); %>' class='addNew' onclick="addNew(<%out.print(list.getId()); %>,'Manufacturer', 'masManufacturer');" style="display:none">Add New?</p>
			      <input id='ManufacturerId<%out.print(list.getId()); %>' value="<%=manufacturerId%>" type='hidden' name='manufacturerId<%out.print(list.getId()); %>' value='0'>
			      <div id='ac6update<%out.print(list.getId()); %>' class='autocomplete' style='display: none;'></div>
			      
			      <script type="text/javascript" language="javascript" charset="utf-8">
					new Ajax.Autocompleter('Manufacturer_<%out.print(list.getId()); %>','ac6update<%out.print(list.getId()); %>','stores?method=getMasterByAutocomplete',{parameters:'masterName=masManufacturer'});	
				</script>
			      </td>
			      <td> <input  type="text"  size="30" class='MasterData' value="<%=brandName%>" validate="Brand,string,yes" id='Brand_<%out.print(list.getId()); %>' name='BrandName' size='30' autocomplete='off'  />
			      <p id='Brand_addNew<%out.print(list.getId()); %>' class='addNew' onclick="addNew(<%out.print(list.getId()); %>,'Brand', 'masStoreBrand');" style="display:none">Add New?</p>
			      <input id='BrandId<%out.print(list.getId()); %>' value="<%=brandId%>" type='hidden' name='brandId<%out.print(list.getId()); %>' value='0'>
			      <div id='ac7update<%out.print(list.getId()); %>' class='autocomplete' style='display: none;'></div>
			      
			      <script type="text/javascript" language="javascript" charset="utf-8">
					new Ajax.Autocompleter('Brand_<%out.print(list.getId()); %>','ac7update<%out.print(list.getId()); %>','stores?method=getMasterByAutocomplete',{parameters:'masterName=masStoreBrand'});	
				</script>
			      </td>
			      <td> <input  size="20" type="text"  onkeypress ="return isNumber(event);"   id="txtQtyReq<%out.print(list.getId()); %>" name="txtQtyReq<%out.print(list.getId()); %>"  value="<%out.print(list.getMprDetails().getQtyRequired());%>" validate="Required Qty,string,yes" readonly/>
			      
			     <td> <input  type="text"  size="20" class='medium3' value = "<%=txtUnitRate%>" id='txtUnitRate<%out.print(list.getId()); %>' name='txtUnitRate<%out.print(list.getId()); %>'   onblur ='calculateAmount(<%out.print(list.getId()); %>)' onkeypress ="return isNumber(event);" validate="Unit Rate Value,string,yes"  /></td>
			      <td> <input  type="text"  size="20" class='medium3' value = "<%=txtItemValue%>" id='txtItemValue<%out.print(list.getId()); %>' name='txtItemValue<%out.print(list.getId()); %>'   readonly validate="Item Value,string,yes" /></td>
			        <td> <textarea size ="20" class="large"  id="chemicalComposition<%out.print(list.getId()); %>" class="medium3"  name="chemicalComposition<%out.print(list.getId()); %>"  validate="chemical Composition,string,no" value=""   tabindex=1 style="width: 250px; height: 50px;" ><%=chemicalComposition%></textarea></td>
			          
			       
					  
			   
			       </tr>
    		<%
    	}
    		
    		
    	%>
    	
    	
    
   </table>
</div>

 <script type="text/javascript" language="javascript" charset="utf-8">
 
 jQuery(document).ready(function(){
		jQuery(".MasterData").blur(function(){
			var val = this.value;
			var thisId= this.id;
		if(val!=''){
			var index1 = val.lastIndexOf("[");
			var index2 = val.lastIndexOf("]");
			var masId = val.substring(index1+1,index2);
			var countStr = thisId.substring(thisId.lastIndexOf("_")+1);
			var id1 = thisId.substring(0, thisId.lastIndexOf("_"));
			 if(index1==-1 || index2==-1){
				 jQuery('#'+id1+'_addNew'+countStr).css('display', 'Block');
				 }else{
					 jQuery('#'+id1+'Id'+countStr).val(masId);
				 }
	    }});
	});
		 
 </script>
     	 
	

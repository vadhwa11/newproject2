<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) 
	{	map = (Map<String,Object>) request.getAttribute("map");
	}
	List investigationTemplateList= new ArrayList();
	if(map.get("investigationTemplateList") != null)
	{	investigationTemplateList = (List)map.get("investigationTemplateList");
	}	
	%>
<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdTemplateInvestigation"%>

<table border="0" align="center" cellpadding="0" cellspacing="0"	id="investigationGrid1">
	 <tr>
	    <th scope="col">Clinical Notes</th>
     </tr>
     <tr>
	     <td><input type="text" name="clinicalNotes1" tabindex="1"	size="100" maxlength="45" /></td>
	  </tr>	
</table>
	<div class="clear paddingTop15"></div>
<table id="investigationGrid" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Test Name</th>
		<th scope="col">Refer to MH</th>
		<th scope="col">Test Result</th>
		<th scope="col">File Upload</th>
		<th scope="col">Add</th>
        <th scope="col">Delete</th>
		<!--<th scope="col">Test Code</th>
	    <th scope="col">Quantity</th> 
	    -->
    </tr>
	<%
	    //System.out.println("investigationTemplateListres size-->>>"+investigationTemplateList.size());
	  int i=1; 
	  int inc=1;
	if(investigationTemplateList!= null && investigationTemplateList.size()>0)
	    {	 // System.out.println("in If Condition=================>");  
	       Iterator itr=investigationTemplateList.iterator();
	      while(itr.hasNext())
	      { 	 OpdTemplateInvestigation opdInvestigation=(OpdTemplateInvestigation)itr.next();
	      	    	      
	      %>
	<tr>
		<td><input type="text" name="chargeCodeName<%=inc%>"
			id="chargeCodeName<%=inc%>" tabindex="1" 
			value="<%=opdInvestigation.getChargeCode().getChargeCodeName()%>[<%=opdInvestigation.getChargeCode().getId()%>]"
			readonly size="45" />
			<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName<%=inc%>','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc%>'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="5" validate="Qty,num,no" /> 
			<input	type="hidden" tabindex="1" id="chargeCodeName1" name="chargeCodeName1"	size="10" readonly /> 
		<div id="ac2update2"
			style="display: none; " class="autocomplete"></div>
		    <input type="hidden" name="chargeCodeName1<%=inc%>" tabindex="1"
			value="<%=opdInvestigation.getChargeCode().getChargeCodeCode()%>"
			readonly size="10" /> 
			<input type="hidden" name="qty<%=i%>"
			value="<%=opdInvestigation.getTemplateInvestigationQty() %>"
			tabindex="1" size="10" /></td>
			
		<td>
		   <input type="checkbox" name="referToMh<%=i %>" tabindex="1" id="investigationReferToMH<%=inc %>" value="y" class="radio"  validate="Refer to MH,string,no" onclick="checkForInvestigationMH(<%=inc %>)"; />
		</td>
		<!--          
	  
	  <td>
	     <input type="text" value="" readonly="readonly" readonly="readonly" tabindex="2" id="Result<%=i %>" name="Result<%=i %>" />
	  </td>	
	  -->
	  <td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
      </td>	
	   <!--<td>
			 <input type="hidden" value="" tabindex="2" />
			 <td><input name="uploadReport" id="uploadReport" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation();" />
    </td>
   	 </td>-->	
	<td>
	    <input type="button" name="uploadReport<%=inc %>" class="button" value="UPLOAD REPORT" id="uploadReport<%=inc %>" style="display: none;" onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);"/>
    </td>
	<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>
     
	</tr>
	<%i++;
	inc++;
	      } %>
	<input type="hidden" name="hiddenValue" value="<%=i-1 %>" id="hiddenValue" />
	<% }else{ %>
	<tr>
		<td> <input type="text" value="" tabindex="1"
			id="chargeCodeName1" size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=i %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script></td>
	<td>
	    <input type="checkbox" name="referToMh<%=i %>" tabindex="1" id="referToMhId<%=i%>" value="y" class="radio"  validate="Refer to MH,string,no;" onclick="checkForInvestigationMH(<%=inc %>);" />
	</td>
	<td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
   </td>
	<td>
	    <input  type="button" name="uploadReport<%=inc %>"  class="buttonAdd" value="UPLOAD REPORT" id="uploadReport<%=inc %>" style="display: none;" onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);"/>
    </td>
    <td>
        <input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation(<%=inc %>);" /></td>
	<td>
	     <input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('investigationGrid','hiddenValue',this);" />
	</td>
	
	<input type="hidden" name="hiddenValue" value="<%=inc %>" id="hiddenValue" />
	</tr>
	<% }%>
</table>

<div class="Clear"></div>





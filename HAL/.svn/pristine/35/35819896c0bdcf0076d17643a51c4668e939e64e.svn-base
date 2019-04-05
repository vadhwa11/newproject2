<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

<%Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List investigationTemplateList= new ArrayList();
	
	if(map.get("investigationTemplateList") != null){
		investigationTemplateList = (List)map.get("investigationTemplateList");
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
	<td>	<input type="text" name="clinicalNotes1" tabindex="1"	size="100" maxlength="45" /></td>
	
	
	</tr>
	</table>
	<div class="clear paddingTop15"></div>
<table id="investigationGrid" border="0" cellspacing="0" cellpadding="0">
	<tr>


		<th scope="col">Test Name</th>
		<th scope="col">Test Result</th>
		<th scope="col">Add</th>
<th scope="col">Delete</th>
		<!--  <th scope="col">Test Code</th>
	    <th scope="col">Quantity</th>  -->
		

	</tr>
	<%
	System.out.println("investigationTemplateListres size-->>>"+investigationTemplateList.size());
	  int i=1;   
	if(investigationTemplateList!= null && investigationTemplateList.size()>0)
	    {
	  
	       Iterator itr=investigationTemplateList.iterator();
	      while(itr.hasNext())
	      {
	    	  OpdTemplateInvestigation opdInvestigation=(OpdTemplateInvestigation)itr.next();
	    	  
	      
	    %>
	<tr>
		<td><input type="text" name="chargeCodeName<%=i%>"
			id="chargeCodeName<%=i%>" tabindex="1"
			value="<%=opdInvestigation.getChargeCode().getChargeCodeName()%>[<%=opdInvestigation.getChargeCode().getId()%>]"
			readonly size="100" />
		<div id="ac2update2"
			style="display: none; " class="autocomplete"></div>
		<input type="hidden" name="chargeCode<%=i%>" tabindex="1"
			value="<%=opdInvestigation.getChargeCode().getChargeCodeCode()%>"
			readonly size="10" /> <input type="hidden" name="qty<%=i%>"
			value="<%=opdInvestigation.getTemplateInvestigationQty() %>"
			tabindex="1" size="10" /></td>
	<td><input type="text" value="" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=i %>"
			 name="Result<%=i %>" />
</td>
			
	<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation();" /></td>

	</tr>
	<%i++;} %>
	<input type="hidden" name="hiddenValue" value="<%=i-1 %>" id="hiddenValue" />
	<% }else{%>
	<tr>
		<td> <input type="text" value="" tabindex="1"
			id="chargeCodeName1" size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=i %>')){checkForChargeCode(this.value,'<%=i %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','fwc?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script></td>
	
<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation();" /></td>
	</tr>
	<input type="hidden" name="hiddenValue" value="<%=i %>" id="hiddenValue" />
	<% }%>
</table>
<div class="Clear"></div>





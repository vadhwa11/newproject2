<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

<%Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	//Set<OpdTemplateInvestigation>investigationTemplateSet = new HashSet<OpdTemplateInvestigation>();
	Set<MasChargeCode> masChargeCodeSet = new HashSet<MasChargeCode>();
	if(map.get("masChargeCodeSet") != null){
		masChargeCodeSet = (Set)map.get("masChargeCodeSet");
	}
	System.out.println("masChargeCodeSet==="+masChargeCodeSet.size());
	
	%>

<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdTemplateInvestigation"%>


<%@page import="jkt.hms.masters.business.MasChargeCode"%><table border="0" align="center" cellpadding="0" cellspacing="0"	id="investigationGrid1">
<%--	<tr>
	<th scope="col">Clinical Notes</th>
</tr>
<tr>
	<td>	<input type="text" name="clinicalNotes1" tabindex="1"	size="100" maxlength="45" /></td>
	
	
	</tr>
	 --%>
	</table>
	<div class="clear paddingTop15"></div>
<table id="investigationGrid" border="0" cellspacing="0" cellpadding="0">
	<tr>
	  	  <td colspan="3">
	      <div class="floatleft">
				<input type="radio" value="Lab" class="radioCheckCol2" style="margin:7px 5px 0px 0px; float: left;"
					name="labradiologyCheck" checked="checked" onchange="" /><div class="labRadiologyDivfixed">LAB</div>			
				<input type="radio" value="Radio" class="radioCheckCol2" style="margin:7px 5px 0px 0px; float: left;"
					name="labradiologyCheck" onchange="" /><div class="labRadiologyDivfixed">Radiology</div>
					 <input
					type="hidden" name="investigationCategory"
					id="investigationCategory" />
				<div class="clear"></div>
			</div>
		
			
	  </td>
	</tr>

	<tr>


		<th scope="col" style="width:50%;">Investigation</th>
		<!-- <th scope="col">Refer to MH</th> -->
		<th scope="col" style="width:25%;">Add</th>
<th scope="col" style="width:25%;">Delete</th>
		<!--  <th scope="col">Test Code</th>
	    <th scope="col">Quantity</th>  -->
		

	</tr>
	<%
	  int i=1;   
	if(masChargeCodeSet!= null && masChargeCodeSet.size()>0)
	    {
	  
	       /*Iterator itr=masChargeCodeSet.iterator();
	      while(itr.hasNext())
	      {
	    	  OpdTemplateInvestigation opdInvestigation=(OpdTemplateInvestigation)itr.next();
	    	 */ 
	      for(MasChargeCode masChargeCode:masChargeCodeSet){
	    	  System.out.println("chargecode id ="+masChargeCode.getId());
	   
	    %>
	<tr>
		<td><input type="text" name="chargeCodeName<%=i%>"
			id="chargeCodeName<%=i%>" tabindex="1"
			value="<%=masChargeCode.getChargeCodeName()%>[<%=masChargeCode.getId()%>]"
			readonly size="40" />
		<div id="ac2update2"
			style="display: none; " class="autocomplete"></div>
		<input type="hidden" name="chargeCode<%=i%>" tabindex="1"
			value="<%=masChargeCode.getChargeCodeCode()%>"
			readonly size="10" /> <input type="hidden" name="qty<%=i%>"
			value=""
			tabindex="1" size="10" /></td>
	<%-- <td><input type="text" value="" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=i %>"
			 name="Result<%=i %>" /></td>--%>
		<%-- 	 <td><input type="checkbox" name="referToMh<%=i %>" tabindex="1" id="referToMhId<%=i%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td> --%>

			
	<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>

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
		<!-- <script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> -->
						<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{minChars:3,
					  callback: function(element, entry) {
				            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
				        },
					  parameters:'requiredField=chargeCodeName1'});
				  
				</script>
				</td>
	<%-- <td><input type="checkbox" name="referToMh<%=i %>" tabindex="1" id="referToMhId<%=i%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td> --%>
<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>
	</tr>
	<input type="hidden" name="hiddenValue" value="<%=i %>" id="hiddenValue" />
	<% }%>
</table>
<div class="Clear"></div>





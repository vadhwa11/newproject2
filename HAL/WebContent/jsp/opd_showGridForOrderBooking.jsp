<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%Map<String,Object> map = new HashMap<String,Object>();
	int pageNo=1;
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

<div class="halfWidthtable">
<table id="investigationGrid" width="100%" colspan="7"
	id="chargeDetails" cellpadding="0" cellspacing="0">
	<tr>
		<th width="5%">SR No</th>
		<th width="5%">Test Name</th>

	</tr>
	<%
	    int i=1;
	    int inc = 1;
	       Iterator itr=investigationTemplateList.iterator();
	      while(itr.hasNext())
	      {
	    	  OpdTemplateInvestigation opdInvestigation=(OpdTemplateInvestigation)itr.next();
	    	  
	      
	    %>
	<tr>
		<td width="5%" align="center"><input type="text" size="2"
			value="<%=inc%>" name="<%=SR_NO%>" readonly="readonly" /></td>
		<td width="95%"><input type="text" align="right" size="80"
			name="<%=CHARGE_CODE%>" tabindex="1" id="chargeCode<%=inc%>"
			value="<%=opdInvestigation.getChargeCode().getChargeCodeName()%>[<%=opdInvestigation.getChargeCode().getId()%>]"
			onblur="if(fillSrNo('<%=inc %>')){checkForChargeCode(this.value, '<%=inc %>');}" />
		<div id="ac2update"		style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				function eventCallback(element, entry){
					return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value; 
				}
			    new Ajax.Autocompleter(document.getElementById('chargeCode<%=inc%>'),'ac2update','lab?method=getChargeCode',{parameters:'requiredField=chargeCode', callback: eventCallback});
			  
    </script></td>
		<input type="hidden" name="<%=CHARGE_CODE_ID%>"
			id="chargeCodeId<%=inc %>"
			value=<%=opdInvestigation.getChargeCode().getId()%> />
		<input type="hidden" id="chargeName<%=inc%>" style="width: 80%"
			name="<%=CHARGE_NAME%>" value="" readonly="readonly" />
		</td>
		<input type="hidden" id="qty<%=inc%>" name="<%=QUANTITY %>" value="1"
			validate="Qty,int,no" MAXLENGTH="3" />
		<input type="hidden" name="hiddenValue" value="<%=i %>"
			id="hiddenValue" />
		<input type="hidden"
			value="<%=opdInvestigation.getChargeCode().getMainChargecode().getId() %>"
			name="mainCharge" id="mainChargeId<%=inc %>" />
		<input type="hidden"
			value="<%=opdInvestigation.getChargeCode().getSubChargecode().getId() %>"
			name="subCharge" id="subChargeId<%=inc %>" />
	</tr>
	<%i++;
	       inc++; 
	      } %>
	<%
    	int detailCounter=10; 
    	
    	for(;inc<=10;inc++){
    	%>

	<tr>

		<td width="5%"><input type="text" size="2" value="<%=inc%>"
			name="<%=SR_NO%>" readonly="readonly" /></td>
		<td width="95%"><input type="text" align="right"
			name="<%=CHARGE_CODE%>" tabindex="1" id="chargeCode<%=inc%>" size="80"	onblur="if(fillSrNo('<%=inc %>')){checkForChargeCode(this.value, '<%=inc %>');}" />
		<div id="ac2update"	style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				function eventCallback(element, entry){
					return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value; 
				}
			    new Ajax.Autocompleter(document.getElementById('chargeCode<%=inc%>'),'ac2update','lab?method=getChargeCode',{parameters:'requiredField=chargeCode', callback: eventCallback});
			  
    </script></td>
		<input type="hidden" value="" name="<%=CHARGE_CODE_ID%>"
			id="chargeCodeId<%=inc %>" />
		<input type="hidden" id="chargeName<%=inc%>" style="width: 80%"
			name="<%=CHARGE_NAME%>" value="" readonly="readonly" />
		</td>
		<input type="hidden" id="qty<%=inc%>" name="<%=QUANTITY %>" value=""
			validate="Qty,int,no" MAXLENGTH="3" />

	</tr>
	<input type="hidden" value="" name="mainCharge"
		id="mainChargeId<%=inc %>" />
	<input type="hidden" value="" name="subCharge"
		id="subChargeId<%=inc %>" />
	<script type="text/javascript">
		document.getElementById('chargeCodeId'+<%=inc%>).value='';
		document.getElementById('chargeName'+<%=inc%>).value='';
		document.getElementById('qty'+<%=inc%>).value='';
		document.getElementById('mainChargeId'+<%=inc%>).value='';
		document.getElementById('subChargeId'+<%=inc%>).value='';		
	</script>

	<%}     	
    int lastIndex = inc;
%>
	<input type="hidden" value="<%=lastIndex%>" name="lastIndex"
		id="lastIndex" />
	<% 
    
    for(;inc<=50;inc++){
    	%>

	<tr id="extraRows<%=inc %>" style="display: none;">

		<td width="5%"><input type="text" size="2" value="<%=inc%>"
			name="<%=SR_NO%>" readonly="readonly" /></td>
		<td width="95%"><input type="text" align="right"
			name="<%=CHARGE_CODE%>" tabindex="1" id="chargeCode<%=inc%>" size="80"	onblur="if(fillSrNo('<%=inc %>')){checkForChargeCode(this.value, '<%=inc %>');}" />
			<div id="ac2update"	style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
						function eventCallback(element, entry){
							return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value; 
						}
					    new Ajax.Autocompleter(document.getElementById('chargeCode<%=inc%>'),'ac2update','lab?method=getChargeCode',{parameters:'requiredField=chargeCode', callback: eventCallback});
					  
		    </script></td>
		<input type="hidden" value="" name="<%=CHARGE_CODE_ID%>"
			id="chargeCodeId<%=inc %>" />
		<input type="hidden" id="chargeName<%=inc%>" style="width: 80%"
			name="<%=CHARGE_NAME%>" value="" readonly="readonly" />
		</td>
		<input type="hidden" id="qty<%=inc%>" name="<%=QUANTITY %>" value=""
			validate="Qty,int,no" MAXLENGTH="3" />

	</tr>

	<input type="hidden" value="" name="mainCharge"
		id="mainChargeId<%=inc %>" />
	<input type="hidden" value="" name="subCharge"
		id="subChargeId<%=inc %>" />
	<script type="text/javascript">
				document.getElementById('chargeCodeId'+<%=inc%>).value='';
				document.getElementById('chargeName'+<%=inc%>).value='';
				document.getElementById('qty'+<%=inc%>).value='';
				document.getElementById('mainChargeId'+<%=inc%>).value='';
				document.getElementById('subChargeId'+<%=inc%>).value='';		
			</script>

	<%} %>
</table>
<!-- Add row button removed from here as exists in parent jsp -->
</div>








<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>

<%@page import="jkt.hms.masters.business.KitIssueMasterTemplateT"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.KitIssueMasterTemplateM"%>
<div class="Clear"></div>
<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
List<KitIssueMasterTemplateT> kitIssueDetailsList = new ArrayList<KitIssueMasterTemplateT>();
if(map.get("kitIssueDetailsList")!=null){
	kitIssueDetailsList = (List<KitIssueMasterTemplateT>)map.get("kitIssueDetailsList");
}
KitIssueMasterTemplateM kitIssueMasterTemplateM = new KitIssueMasterTemplateM();
if(kitIssueDetailsList.size() > 0){
	kitIssueMasterTemplateM =  kitIssueDetailsList.get(0).getTemplate();
}
%>



<input type="hidden" name="kitIssueMasterId" value="<%= kitIssueMasterTemplateM.getId()%>"/>
<div id="pageNavPosition"></div>
<div class="Clear"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  class="center">
	<tr>
		<th width="15%">Nomenclature</th>
		<th width="3%">Qty Issued</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<% int j=1;
		for(KitIssueMasterTemplateT kitIssueMasterTemplateT :kitIssueDetailsList ){
			if(kitIssueMasterTemplateT.getStatus().equalsIgnoreCase("y")){
	%>
	<tr>
		
		<td><input type="text" value="<%=kitIssueMasterTemplateT.getItemName() %>" tabindex="1" id="itemName<%=j %>"
			size="35" name="itemName<%=j %>"
			onblur="if(this.value!=''){checkForNomenclature(this.value,<%=j %>);}" />
	    <input type="hidden" name="kitIssueDetailsId<%=j %>"  value="0"/>

		<div id="ac2update1" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			
		//	  new Ajax.Autocompleter('nomenclature1','ac2update1','inPatientMaster?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature1'});
			</script>
			
			</td>
			<td id="batchDiv1" style="display: none;">
		<input type="hidden" id="itemId<%=j %>" name="itemId<%=j %>" value="">
		</td>	
		<td>
		  <input type="text" value="<%=kitIssueMasterTemplateT.getAuthQuantity() %>" tabindex="1" id="issueQuantity<%=j %>" size="25"
			name="issueQuantity<%=j %>"></td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRow();" tabindex="1" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('grid','hdb',this);setIdForDelete('<%=kitIssueMasterTemplateT.getId() %>','');" tabindex="1" />
			</td>
	</tr>
	<%j++;}
			}%>
</table>
		<input type="hidden" id="deleteKitId" name="deleteKitId" value="">
<input type="hidden" name="hdb" value="<%=j-1 %>" id="hdb" />

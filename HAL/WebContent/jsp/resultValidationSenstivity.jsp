<%@page import="java.util.*"%>
<!--main content placeholder starts here-->
<%@page import="jkt.hms.masters.business.DgOrgDtl"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<%
Map map = new HashMap();
List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
if(map.get("dgResultEntryDetailSenList") != null){
	dgResultEntryDetailSenList = (List<DgResultEntryDetailSen>)map.get("dgResultEntryDetailSenList");
}
System.out.println("========  "+dgResultEntryDetailSenList.size());
%>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th width="8%" scope="col">&nbsp;</th>
		<th colspan="2" scope="col">Sensitivity</th>
		<th width="12%" scope="col">Result</th>
	</tr>


	<%
    int srNo =1;
    for(DgResultEntryDetailSen dgResultEntryDetailSen: dgResultEntryDetailSenList){
    	System.out.println("srNo   "+srNo);
    	%>
	<tr>
		<td><%=srNo%></td>
		<td width="9%"><input type="checkbox" name="chkBox<%=srNo%>"
			id="chkBox<%=srNo%>"
			value="<%=dgResultEntryDetailSen.getSensitivity().getId() %>"
			class="radio" checked="checked" /> <%System.out.println("checkbox"+srNo); %>
		</td>
		<td width="71%"><%=dgResultEntryDetailSen.getSensitivity().getAntibioticLabName()%></td>
		<td><select name="res<%=srNo%>" id="res<%=srNo%>"
			validate="Result Entered By,string,no" tabindex=1>
			<%if(dgResultEntryDetailSen.getResult().equalsIgnoreCase("Sensitive")){ %>
			<option value="SENSITIVE" selected="selected">SENSITIVE</option>
			<option value="NON-SENSITIVE">RESISTANT</option>
			<option value="MS">MS</option>
			<option value="NOT APPLICABLE">NO RESULT</option>
			<%} %>
			<%if(dgResultEntryDetailSen.getResult().equalsIgnoreCase("Non-Sensitive")){ %>
			<option value="SENSITIVE">SENSITIVE</option>
			<option value="NON-SENSITIVE" selected="selected">RESISTANT</option>
			<option value="MS">MS</option>
			<option value="NOT APPLICABLE">NO RESULT</option>
			<%} %>
			<%if(dgResultEntryDetailSen.getResult().equalsIgnoreCase("MS")){ %>
			<option value="SENSITIVE">SENSITIVE</option>
			<option value="NON-SENSITIVE">RESISTANT</option>
			<option value="MS" selected="selected">MS</option>
			<option value="NOT APPLICABLE">NO RESULT</option>
			<%} %>
			<%if(dgResultEntryDetailSen.getResult().equalsIgnoreCase("NOT APPLICABLE")){ %>
			<option value="SENSITIVE">SENSITIVE</option>
			<option value="NON-SENSITIVE">RESISTANT</option>
			<option value="MS">MS</option>
			<option value="NOT APPLICABLE" selected="selected">NO RESULT</option>
			<%} %>
		</select></td>
	</tr>
	<%
    srNo++;
    } %>

</table>
<input id="noOfOrg" name="noOfOrg" type="hidden" value="<%=srNo-1%>" />
<%@page import="java.util.*"%>
<!--main content placeholder starts here-->
<%@page import="jkt.hms.masters.business.DgOrgDtl"%>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<%
Map map = new HashMap();
List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
if(map.get("dgOrgDtlList") != null){
	dgOrgDtlList = (List<DgOrgDtl>)map.get("dgOrgDtlList");
}
System.out.println("========  "+dgOrgDtlList.size());
%>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th width="8%" scope="col">&nbsp;</th>
		<th colspan="2" scope="col">Sensitivity</th>
		<th width="12%" scope="col">Result</th>
	</tr>


	<%
    int srNo =1;
    for(DgOrgDtl orgDtl: dgOrgDtlList){
    	System.out.println("srNo   "+srNo);
    	%>
	<tr>
		<td><%=srNo%></td>
		<td width="9%"><input type="checkbox"
			name="chkBoxSensitive<%=srNo%>" id="chkBoxSensitive<%=srNo%>"
			value="<%=orgDtl.getAntibioticLab().getId()%>@<%=orgDtl.getOrganism().getId()%>@<%=orgDtl.getOrganismGroup().getId()%>"
			class="radio" /> <%System.out.println("checkbox"+srNo); %>
		</td>
		<td width="71%"><%=orgDtl.getAntibioticLab().getAntibioticLabName()%></td>
		<td><select name="res<%=srNo%>" id="res<%=srNo%>"
			validate="Result Entered By,string,no" tabindex=1>
			<option value="SENSITIVE">SENSITIVE</option>
			<option value="NON-SENSITIVE">RESISTANT</option>
			<option value="MS">MS</option>
			<option value="NOT APPLICABLE">NO RESULT</option>
		</select></td>
	</tr>
	<%
    srNo++;
    } %>

</table>


<input id="noOfSensitivity" name="noOfSensitivity" type="hidden"
	value="<%=srNo-1%>" />
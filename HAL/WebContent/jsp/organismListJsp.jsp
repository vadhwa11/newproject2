%@page import="jkt.hms.masters.business.DgOrgGrpDtl"%>
<%@page import="java.util.*"%>
<!--main content placeholder starts here-->
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<%
Map map = new HashMap();
List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
if(map.get("dgOrgGrpDtlList") != null){
	dgOrgGrpDtlList = (List<DgOrgGrpDtl>)map.get("dgOrgGrpDtlList");
}
System.out.println("========  "+dgOrgGrpDtlList.size());
%>
<div
	style="width: 585px; border: 1px solid #3C8AD7; height: 150px; float: left; margin-left: 20px; display: inline; overflow: auto;">
<div class="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th width="8%" scope="col">&nbsp;</th>
		<th colspan="2" scope="col">Organism</th>
	</tr>


	<%
    int srNo =1;
    for(DgOrgGrpDtl dgOrgGrpDtl: dgOrgGrpDtlList){
    	System.out.println("srNo   "+srNo);
    	%>
	<tr>
		<td><%=srNo%></td>
		<td width="9%"><input type="checkbox" name="checkbox"
			id="chkBox<%=srNo%>" value="<%=dgOrgGrpDtl.getOrganism().getId() %>"
			class="radio" onchange="fillSensitivity(this.value);" /></td>
		<td width="71%"><%=dgOrgGrpDtl.getOrganism().getOrganismName()%></td>
	</tr>
	<%
    srNo++;
    } %>

</table>
</div>
</div>

<input id="noOfOrg" type="hidden" value="<%=srNo-1%>" />
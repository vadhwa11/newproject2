<%@page import="jkt.hms.masters.business.DgOrgGrpDtl"%>
<%@page import="java.util.*"%>
<!--main content placeholder starts here-->
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="jkt.hms.masters.business.DgMasOrganism"%>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<%
Map map = new HashMap();
List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
if(map.get("dgMasOrganismList") != null){
	
	dgMasOrganismList = (List<DgMasOrganism>)map.get("dgMasOrganismList");
}

if(map.get("dgResultEntryDetailSenList") != null){
	dgResultEntryDetailSenList = (List<DgResultEntryDetailSen>)map.get("dgResultEntryDetailSenList");
}
System.out.println("========  "+dgResultEntryDetailSenList.size());
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
    boolean isAdded=false;
    Set  ids = new HashSet();
    for(DgResultEntryDetailSen dgResultEntryDetailSen: dgResultEntryDetailSenList){
    	System.out.println("srNo   "+srNo);
    	isAdded=ids.add(dgResultEntryDetailSen.getOrganism().getId());
    	if(isAdded){
    	%>
	<tr>
		<td><%=srNo%></td>
		<td width="9%"><input type="checkbox" name="checkbox"
			id="chkBox<%=srNo%>" checked="checked"
			value="<%=dgResultEntryDetailSen.getOrganism().getId() %>"
			class="radio" onchange="fillSensitivity(this.value);" /></td>
		<td width="71%"><%=dgResultEntryDetailSen.getOrganism().getOrganismName()%></td>
	</tr>
	<%
    srNo++;
    	}
    } %>

</table>
</div>
</div>

<input id="noOfOrg" type="hidden" value="<%=srNo-1%>" />
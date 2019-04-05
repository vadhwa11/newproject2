<%@page import="jkt.hms.masters.business.DgOrgGrpDtl"%>
<%@page import="java.util.*"%>
<!--main content placeholder starts here-->
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="jkt.hms.masters.business.DgMasOrganism"%>
<%@page import="jkt.hms.masters.business.MasAntibioticLab"%>
<%@page import="jkt.hms.masters.business.DgMasOrganismGroup"%>
<%@page import="jkt.hms.masters.business.DgOrgDtl"%>

<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.util.OrganismComparator"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<%@page import="java.net.URL"%>

<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-color.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/wysiwyg-settings.js"></script>
<%
Map<String,Object> map = new HashMap<String,Object>();
String[] orderStatusMsg = null;
DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();	
Set<DgResultEntryDetailSen> dgResultDtSenSet = new HashSet<DgResultEntryDetailSen>();
List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
Map<String,Object> orderDetailMap = new HashMap<String,Object>();
Integer resultEntryIndex = 0;

if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
if (map.get("resultList") != null){
	resultList = (List)map.get("resultList");
}
if(map.get("orderStatusMsg") != null){
	orderStatusMsg = (String[])map.get("orderStatusMsg");
}

if(resultList.size() > 0 ){
	dgResultEntryHeader = resultList.get(0);
}
Set<DgResultEntryDetailSen> organismSet = new HashSet<DgResultEntryDetailSen>();
List<DgResultEntryDetailSen> dgResSenList = new ArrayList<DgResultEntryDetailSen>();

dgResultDtSenSet = dgResultEntryHeader.getDgResultEntryDetailSen();
organismSet.addAll(dgResultDtSenSet);

for(DgResultEntryDetailSen detailSen : dgResultDtSenSet){
	dgResSenList.add(detailSen);
}

OrganismComparator organismComparator = new OrganismComparator();
Collections.sort(dgResSenList,organismComparator);
DgResultEntryDetailSen dgResultEntryDetailSenToCheck = dgResultDtSenSet.iterator().next(); 
int srNo = 1;
%>
<br />
<%if(orderStatusMsg != null){ 
	for(String msg : orderStatusMsg){%>
<font id="error" style=""><%=msg%> </font>
<br />
<%	}
} %>

<div id="contentHolder">
<div class="blockFrame">
<div id="sensitive" style="display: block;">
<div class="Clear"></div>
<div class="tableHolderAuto">
<div class="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sr No.</th>
		<th scope="col">Organism Group</th>
		<th scope="col">Organism</th>
		<th scope="col">Antibiotic</th>
		<th scope="col">Result</th>

	</tr>
	<%if(dgResultEntryDetailSenToCheck.getGrowthOption().equalsIgnoreCase("o")){ %>
	<tr>
		<td><%=srNo%>)</td>
		<td>-</td>
		<td>-</td>
		<td>-</td>
		<td>
		<%
			String resultAll = "";
			if(dgResultEntryDetailSenToCheck.getResult() != null 
					&& !dgResultEntryDetailSenToCheck.getResult().equals("")){
				resultAll = resultAll + dgResultEntryDetailSenToCheck.getResult();
			} 
			if(dgResultEntryDetailSenToCheck.getResultOther() != null 
					&& !dgResultEntryDetailSenToCheck.getResultOther().equals("")){
				resultAll = resultAll + dgResultEntryDetailSenToCheck.getResultOther();
			}
			%> <%=resultAll%></td>
	</tr>
	<%} else{
      if(dgResSenList.size() > 0){ %>
	<tr>
		<td><%=srNo%>)</td>
		<td><%= dgResSenList.get(0).getOrganismGroup().getOrganismGroupName()%></td>
		<td><%= dgResSenList.get(0).getOrganism().getOrganismName()%></td>
		<td><%=dgResSenList.get(0).getSensitivity().getAntibioticLabName()%></td>
		<td>
		<%if( dgResSenList.get(0).getResult().equalsIgnoreCase("NON-SENSITIVE")){ %>
		RESISTANT <% }else if( dgResSenList.get(0).getResult().equalsIgnoreCase("NOT APPLICABLE")){ %>
		- <%}  else {%> <%=dgResSenList.get(0).getResult()%> <% } %>
		</td>
	</tr>
	<%srNo++;  
 } 
for(int ilop=0;ilop<dgResSenList.size()-1;ilop++){
		if(!dgResSenList.get(ilop).getOrganismGroup().getId()
				.equals(dgResSenList.get(ilop+1).getOrganismGroup().getId())){ %>
	<tr>
		<td><%=srNo%>)</td>

		<td><%= dgResSenList.get(ilop+1).getOrganismGroup().getOrganismGroupName()%></td>
		<td><%= dgResSenList.get(ilop+1).getOrganism().getOrganismName()%></td>
		<td><%=dgResSenList.get(ilop+1).getSensitivity().getAntibioticLabName()%></td>

		<td>
		<%if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NON-SENSITIVE")){ %>
		RESISTANT <% }else if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NOT APPLICABLE")){ %>
		- <%}  else {%> <%=dgResSenList.get(ilop+1).getResult()%> <% } %>
		</td>
	</tr>
	<% srNo++;
		}else {
			if(!dgResSenList.get(ilop).getOrganism().getId()
					.equals(dgResSenList.get(ilop+1).getOrganism().getId())){ %>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td><%= dgResSenList.get(ilop+1).getOrganism().getOrganismName()%></td>
		<td><%=dgResSenList.get(ilop+1).getSensitivity().getAntibioticLabName()%></td>
		<td>
		<%if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NON-SENSITIVE")){ %>
		RESISTANT <% }else if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NOT APPLICABLE")){ %>
		- <%}  else {%> <%=dgResSenList.get(ilop+1).getResult()%> <% } %>
		</td>
	</tr>
	<%}else{ %>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td><%=dgResSenList.get(ilop+1).getSensitivity().getAntibioticLabName()%></td>
		<td>
		<%if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NON-SENSITIVE")){ %>
		RESISTANT <% }else if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NOT APPLICABLE")){ %>
		- <%}  else {%> <%=dgResSenList.get(ilop+1).getResult()%> <% } %>
		</td>
	</tr>
	<%}
		}

	}

} %>
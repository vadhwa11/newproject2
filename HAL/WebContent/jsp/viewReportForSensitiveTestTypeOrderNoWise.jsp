
<%@page import="java.util.*"%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();

		DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();	
		Set<DgResultEntryDetailSen> dgResultDtSenSet = new HashSet<DgResultEntryDetailSen>();
		
		Integer resultEntryIndex = 0;
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(request.getParameter("resultEntryIndex") != null){
			resultEntryIndex = Integer.parseInt(request.getParameter("resultEntryIndex"));
		}
		if (map.get("detailsMap1") != null) {
			detailsMap1 = (Map<String, Object>)map.get("detailsMap1");
			System.out.println("in not null");
		}
		if (detailsMap1.get("dgResultEntryHeaderByOrderNo") != null) {
			dgResultEntryHeaderByOrderNo = (List)detailsMap1.get("dgResultEntryHeaderByOrderNo");

		}
		if(dgResultEntryHeaderByOrderNo.size() > 0 ){
			dgResultEntryHeader = dgResultEntryHeaderByOrderNo.get(resultEntryIndex);
		}
		
		dgResultDtSenSet = dgResultEntryHeader.getDgResultEntryDetailSen();
		Set<DgResultEntryDetailSen> organismGroupSet = OrganismGroupComparator.getApplicationTreeSet();
		Set<DgResultEntryDetailSen> organismSet = new HashSet<DgResultEntryDetailSen>();
		
		//Set<DgResultEntryDetailSen> organismSet = OrganismComparator.getApplicationTreeSet();
		//organismGroupSet.addAll(dgResultDtSenSet);
		organismSet.addAll(dgResultDtSenSet);
		List<DgResultEntryDetailSen> dgResSenList = new ArrayList<DgResultEntryDetailSen>();
		for(DgResultEntryDetailSen detailSen : dgResultDtSenSet){
			dgResSenList.add(detailSen);
		}
		OrganismComparator organismComparator = new OrganismComparator();
		Collections.sort(dgResSenList,organismComparator);
		DgResultEntryDetailSen dgResultEntryDetailSenToCheck = dgResultDtSenSet.iterator().next(); 
	%>
<!-- Table Starts -->

<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="jkt.hms.util.OrganismGroupComparator"%>
<%@page import="jkt.hms.util.OrganismComparator"%>
<div class="Clear"></div>
<div class="grid">
<table cellpadding="0" cellspacing="0">
<tr>
<th>Sl No. </th>
<th>Organism Group </th>
<th>Organism</th>
<th>Antibiotic</th>
<th>Result</th>
<th>Remarks</th>
	</tr>
	

<% char srNo = 97; %>
<% 
	if(dgResultEntryDetailSenToCheck.getGrowthOption().equalsIgnoreCase("o")){ %>
	<tr>
<td></td>
<td>-</td>
<td>-</td>
<td>-</td>
<td><%
			String resultAll = "";
			if(dgResultEntryDetailSenToCheck.getResult() != null 
					&& !dgResultEntryDetailSenToCheck.getResult().equals("")){
				resultAll = resultAll + dgResultEntryDetailSenToCheck.getResult();
			} 
			if(dgResultEntryDetailSenToCheck.getResultOther() != null 
					&& !dgResultEntryDetailSenToCheck.getResultOther().equals("")){
				resultAll = resultAll + dgResultEntryDetailSenToCheck.getResultOther();
			}
			%> <%=resultAll%> </td>
<% if(dgResultEntryHeader.getRemarks() != null && !dgResultEntryHeader.getRemarks().equals("")){ %>
<td><%=dgResultEntryHeader.getRemarks()%></td>
<% } else { %>
<td>-</td>
</tr>
<% } %>

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
- <%}  else {%> <%=dgResSenList.get(0).getResult()%> <% } %> </td>
<% if(dgResultEntryHeader.getRemarks() != null && !dgResultEntryHeader.getRemarks().equals("")){ %>
<td><%=dgResultEntryHeader.getRemarks()%></td>
<% } else { %>
<td>-</td>
</tr>
<% } %>
<%srNo++;  
      } 
      for(int ilop=0;ilop<dgResSenList.size()-1;ilop++){
			if(!dgResSenList.get(ilop).getOrganismGroup().getId()
					.equals(dgResSenList.get(ilop+1).getOrganismGroup().getId())){ %>
					<tr>
<td ><%=srNo%>)</td>
<td><%= dgResSenList.get(ilop+1).getOrganismGroup().getOrganismGroupName()%></td>
<td><%= dgResSenList.get(ilop+1).getOrganism().getOrganismName()%></td>
<td>
<%=dgResSenList.get(ilop+1).getSensitivity().getAntibioticLabName()%></td>
<td>
<%if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NON-SENSITIVE")){ %>
RESISTANT <% }else if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NOT APPLICABLE")){ %>
- <%}  else {%> <%=dgResSenList.get(ilop+1).getResult()%> <% } %> </td>
<td>-</td>
</tr>
</table>
</div>
<div class="Clear"></div>
<% srNo++;
			}else {
				if(!dgResSenList.get(ilop).getOrganism().getId()
						.equals(dgResSenList.get(ilop+1).getOrganism().getId())){ %>

<label class="value">&nbsp;</label>
<label class="value">&nbsp;</label>
<label class="value"><%= dgResSenList.get(ilop+1).getOrganism().getOrganismName()%></label>
<label class="value">
<%=dgResSenList.get(ilop+1).getSensitivity().getAntibioticLabName()%></label>

<label class="value">
<%if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NON-SENSITIVE")){ %>
RESISTANT <% }else if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NOT APPLICABLE")){ %>
- <%}  else {%> <%=dgResSenList.get(ilop+1).getResult()%> <% } %> </label>
<label class="value">-</label>
<div class="Clear"></div>

<%}else{ %>
<label>&nbsp;</label>
<label class="value">&nbsp;</label>
<label class="value">&nbsp;</label>
<label class="value"><%=dgResSenList.get(ilop+1).getSensitivity().getAntibioticLabName()%></label>
<label class="value">
<%if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NON-SENSITIVE")){ %>
RESISTANT <% }else if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NOT APPLICABLE")){ %>
- <%}  else {%> <%=dgResSenList.get(ilop+1).getResult()%> <% } %> </label>
<label class="value" >-</label>
<div class="Clear"></div>
<%}
			}

      }
	  
	} %>

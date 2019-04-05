<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		
		DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();	
		Set<DgResultEntryDetailSen> dgResultDtSenSet = new HashSet<DgResultEntryDetailSen>();
		List<DgResultEntryHeader> dgResultEntryHeaderSensitiveLabList = new ArrayList<DgResultEntryHeader>();
		Map<String,Object> orderDetailMap = new HashMap<String,Object>();
		Integer resultEntryIndex = 0;

		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if (map.get("orderDetailMap") != null){
			orderDetailMap =(Map)map.get("orderDetailMap");
		}
		if(request.getParameter("resultEntryIndex") != null){
			resultEntryIndex = Integer.parseInt(request.getParameter("resultEntryIndex"));
		}
		if (orderDetailMap.get("dgResultEntryHeaderSensitiveLabList") != null){
			dgResultEntryHeaderSensitiveLabList = (List)orderDetailMap.get("dgResultEntryHeaderSensitiveLabList");
		}
		
		if(dgResultEntryHeaderSensitiveLabList.size() > 0 ){
			dgResultEntryHeader = dgResultEntryHeaderSensitiveLabList.get(resultEntryIndex);
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
	%>
<!-- Table Starts -->

<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>

<%@page import="jkt.hms.util.OrganismComparator"%>
<div class="Clear"></div>
<label
	style="width: 50px; padding-left: 33px; font-size: 11px; padding-right: 0px;">Sr
No. </label>
<label style="padding-left: 0px; width: 120px; font-size: 11px;">Organism
Group </label>
<label style="padding-left: 44px; width: 80px; font-size: 11px;">Organism</label>
<label style="padding-left: 76px; font-size: 11px; width: 160px;">Antibiotic
</label>
<label style="padding-left: 0px; width: 70px; font-size: 11px;">Result</label>
<div class="Clear"></div>
<% char srNo = 97; %>
<% 
	if(dgResultEntryDetailSenToCheck.getGrowthOption().equalsIgnoreCase("o")){ %>
<label class="value" style="width: 15px; padding-left: 40px;"><%=srNo%>)</label>
<label class="value"
	style="padding-left: 0px; margin-left: 0px; padding-right: 0px; text-align: center; width: 170px;">-</label>
<label class="value"
	style="padding-left: 0px; margin-left: 0px; padding-right: 0px; text-align: center; width: 130px;">-</label>
<label class="value"
	style="text-align: center; padding-left: 0px; margin-left: 0px;">-</label>

<label class="value"
	style="padding-left: 0px; margin-left: 0px; padding-right: 0px; text-align: center; width: 100px;">
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
			%> <%=resultAll%> </label>
<div class="Clear"></div>
<%} else{
      if(dgResSenList.size() > 0){ %>
<label class="value" style="width: 15px; padding-left: 40px;"><%=srNo%>)</label>
<label class="value"
	style="padding-left: 0px; margin-left: 0px; padding-right: 0px; text-align: center; width: 170px;"><%= dgResSenList.get(0).getOrganismGroup().getOrganismGroupName()%></label>
<label class="value"
	style="padding-left: 0px; margin-left: 0px; padding-right: 0px; text-align: center; width: 130px;"><%= dgResSenList.get(0).getOrganism().getOrganismName()%></label>
<label class="value"
	style="text-align: center; padding-left: 0px; margin-left: 0px;"><%=dgResSenList.get(0).getSensitivity().getAntibioticLabName()%></label>

<label class="value"
	style="padding-left: 0px; margin-left: 0px; padding-right: 0px; text-align: center; width: 100px;">
<%if( dgResSenList.get(0).getResult().equalsIgnoreCase("NON-SENSITIVE")){ %>
RESISTANT <% }else if( dgResSenList.get(0).getResult().equalsIgnoreCase("NOT APPLICABLE")){ %>
- <%}  else {%> <%=dgResSenList.get(0).getResult()%> <% } %> </label>
<div class="Clear"></div>
<%srNo++;  
      } 
      for(int ilop=0;ilop<dgResSenList.size()-1;ilop++){
			if(!dgResSenList.get(ilop).getOrganismGroup().getId()
					.equals(dgResSenList.get(ilop+1).getOrganismGroup().getId())){ %>
<label class="value" style="width: 15px; padding-left: 40px;"><%=srNo%>)</label>

<label class="value"
	style="padding-left: 0px; margin-left: 0px; padding-right: 0px; text-align: center; width: 170px;"><%= dgResSenList.get(ilop+1).getOrganismGroup().getOrganismGroupName()%></label>
<label class="value"
	style="padding-left: 0px; margin-left: 0px; padding-right: 0px; text-align: center; width: 130px;"><%= dgResSenList.get(ilop+1).getOrganism().getOrganismName()%></label>
<label class="value"
	style="text-align: center; padding-left: 0px; margin-left: 0px;">
<%=dgResSenList.get(ilop+1).getSensitivity().getAntibioticLabName()%></label>

<label class="value"
	style="padding-left: 0px; margin-left: 0px; padding-right: 0px; text-align: center; width: 100px;">
<%if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NON-SENSITIVE")){ %>
RESISTANT <% }else if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NOT APPLICABLE")){ %>
- <%}  else {%> <%=dgResSenList.get(ilop+1).getResult()%> <% } %> </label>
<div class="Clear"></div>
<% srNo++;
			}else {
				if(!dgResSenList.get(ilop).getOrganism().getId()
						.equals(dgResSenList.get(ilop+1).getOrganism().getId())){ %>

<label class="value" style="width: 15px; padding-left: 40px;">&nbsp;</label>
<label class="value"
	style="padding-left: 0px; margin-left: 0px; padding-right: 0px; text-align: center; width: 170px;">
&nbsp;</label>
<label class="value"
	style="padding-left: 0px; margin-left: 0px; padding-right: 0px; text-align: center; width: 130px;"><%= dgResSenList.get(ilop+1).getOrganism().getOrganismName()%></label>
<label class="value"
	style="text-align: center; padding-left: 0px; margin-left: 0px;">
<%=dgResSenList.get(ilop+1).getSensitivity().getAntibioticLabName()%></label>

<label class="value"
	style="padding-left: 0px; margin-left: 0px; padding-right: 0px; text-align: center; width: 100px;">
<%if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NON-SENSITIVE")){ %>
RESISTANT <% }else if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NOT APPLICABLE")){ %>
- <%}  else {%> <%=dgResSenList.get(ilop+1).getResult()%> <% } %> </label>
<div class="Clear"></div>

<%}else{ %>
<label class="value" style="width: 15px; padding-left: 40px;">&nbsp;</label>
<label class="value"
	style="padding-left: 0px; margin-left: 0px; padding-right: 0px; text-align: center; width: 170px;">
&nbsp;</label>
<label class="value"
	style="padding-left: 0px; margin-left: 0px; padding-right: 0px; text-align: center; width: 130px;">
&nbsp;</label>
<label class="value"
	style="text-align: center; padding-left: 0px; margin-left: 0px;">
<%=dgResSenList.get(ilop+1).getSensitivity().getAntibioticLabName()%></label>
<label class="value"
	style="padding-left: 0px; margin-left: 0px; padding-right: 0px; text-align: center; width: 100px;">
<%if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NON-SENSITIVE")){ %>
RESISTANT <% }else if( dgResSenList.get(ilop+1).getResult().equalsIgnoreCase("NOT APPLICABLE")){ %>
- <%}  else {%> <%=dgResSenList.get(ilop+1).getResult()%> <% } %> </label>
<div class="Clear"></div>
<%}
			}

      }
	  
	} %>

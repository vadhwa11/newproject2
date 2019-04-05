<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%Map<String,Object> map = new HashMap<String,Object>();
	int pageNo=1;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List<DgOrgGrpDtl> organismGrpDetailList = new ArrayList<DgOrgGrpDtl>();
	if(map.get("organismGrpDetailList") != null && !map.get("organismGrpDetailList").equals("")){
		organismGrpDetailList = (List)map.get("organismGrpDetailList");		
	}
	
	
	%>
<%@page import="jkt.hms.masters.business.DgOrgGrpDtl"%>

<label><span>*</span> Organism Group</label>
<select name="<%=ORGANISM_GROUP_ID%>" id="<%=ORGANISM_GROUP_ID%>"
	class="large" validate="Organism Group,string,yes" tabindex="1">
	<option onclick="" value="">Select</option>
	<% for (DgOrgGrpDtl  dgOrgGrpDtl : organismGrpDetailList){ %>
	<option onclick="showSensitivityForSelectedOrgGrpAjax(this);"
		value="<%=dgOrgGrpDtl.getOrganismGroup().getId ()%>"><%=dgOrgGrpDtl.getOrganismGroup().getOrganismGroupName()%></option>
	<%}%>
	<% if(organismGrpDetailList.size() == 0){ %>
	<script type="text/javascript">
				alert('There is no organism group for selected organism.\n\tFirst add organism to the organism group.');
			</script>

	<% } %>
</select>
<div id="sensitivityListView"><input type="hidden"
	name="totalRowsCount" value="0" id="totalRowsCount" /></div>

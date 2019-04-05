<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		
		}
		List<MasAntibioticLab> antibioticList= new ArrayList<MasAntibioticLab>();
		if(map.get("antibioticList") != null){
			antibioticList = (List)map.get("antibioticList");
		}
%>
<%@page import="jkt.hms.masters.business.MasAntibioticLab"%>
<ul>
	<%for (MasAntibioticLab antibioticLab : antibioticList) { %>
	<li><%=antibioticLab.getAntibioticLabName()%>[<%=antibioticLab.getId()%>]</li>
	<%}
 if(antibioticList.size() == 0){%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>
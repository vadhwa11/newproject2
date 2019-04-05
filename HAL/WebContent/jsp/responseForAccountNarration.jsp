<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");

		}
		List<FaMasNarration> voucherNarationList  = new ArrayList<FaMasNarration>();
		if(map.get("voucherNarationList") != null){
			voucherNarationList = (List)map.get("voucherNarationList");
		}
%>

<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaMasNarration"%>

<%@page import="jkt.hms.masters.business.FaMasNarration"%><ul>
	<%	if(voucherNarationList.size() !=0){

		for (FaMasNarration faMasNarration:voucherNarationList) {


%>
	<li><%=faMasNarration.getNarrationDesc()%></li>

	<%}} %>
</ul>




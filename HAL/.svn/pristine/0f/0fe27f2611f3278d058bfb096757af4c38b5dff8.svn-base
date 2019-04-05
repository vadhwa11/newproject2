<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>


<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		
		}
		List chargeCodeList= new ArrayList();
		if(map.get("chargeCodeList") != null){
			chargeCodeList = (List)map.get("chargeCodeList");
		}
		System.out.println("chargeCodeList  in new jsp ----- "+chargeCodeList.size());
%>

<ul>
	<%	if(chargeCodeList.size() !=0){
	
		for (Iterator iterator = chargeCodeList.iterator(); iterator.hasNext();) {
			MasChargeCode masChargeCode = (MasChargeCode)iterator.next();
			
					
%>
	<li><%=masChargeCode.getChargeCodeName()%>[<%=masChargeCode.getId()%>]</li>

	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




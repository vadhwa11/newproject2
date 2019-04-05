<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List chargeCodeList= new ArrayList();
if(map.get("chargeCodeList") != null){
	chargeCodeList = (List)map.get("chargeCodeList");
}
%>
<ul>
	<%	if(chargeCodeList.size() !=0){
		for (Iterator iterator = chargeCodeList.iterator(); iterator.hasNext();) {
			MasChargeCode masChargeCode = (MasChargeCode) iterator.next();
		    String chargeCodeName = masChargeCode.getChargeCodeName();
		    int  chargeCodeId=masChargeCode.getId();
		    
		    
%>
	<li style="width: auto; font: normal 11px tahoma; text-align: left;"><%=chargeCodeName%>[<%=chargeCodeId%>]</li>

	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>



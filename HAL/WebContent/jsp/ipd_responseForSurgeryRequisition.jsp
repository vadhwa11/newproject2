
<%@page import="java.util.*"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List chargeList= new ArrayList();
if(map.get("chargeList") != null){
	chargeList = (List)map.get("chargeList");
}
System.out.println("chargeList --------- "+chargeList.size());
%>


<%@page import="java.util.Iterator"%>


<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<ul>
	<%	if(chargeList.size() !=0){
	
		for (Iterator iterator = chargeList.iterator(); iterator.hasNext();) {
			
			//Object[] pair = (Object[]) iterator.next();
			MasChargeCode masChargeCode=(MasChargeCode)iterator.next();
			
		    String chargeCodeName=masChargeCode.getChargeCodeName();
		    String chargeCode=masChargeCode.getChargeCodeCode();
		    int chargeId=masChargeCode.getId();
		//System.out.println("nomenclature i-------"+itemName);
	
		
%>
	<li style="width: auto;"><%=chargeCodeName%>[<%=chargeId%>]</li>



	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




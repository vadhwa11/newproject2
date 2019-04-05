<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.Disability" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List disabilityList= new ArrayList();
if(map.get("disabilityList") != null){
	disabilityList = (List)map.get("disabilityList");
}System.out.println("DisaiityResult jsp------->>>"+disabilityList.size());
%>
<ul>


	<%	
	if(disabilityList.size() !=0)
	{System.out.println("------------------------");
		for (Iterator iterator = disabilityList.iterator(); iterator.hasNext();) {
			//System.out.println("itemList in jsp >"+disabilityList.size());
			Disability disabilityListItem = (Disability) iterator.next();
		    String itemName = disabilityListItem.getDisability();
		    //System.out.println("itemName   "+itemName);
		    
		  
      %><li style="width: auto;"><%=itemName%></li>
	
	<%}
	}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
	
</ul>





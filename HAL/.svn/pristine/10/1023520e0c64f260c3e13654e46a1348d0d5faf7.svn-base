<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.UserApplications"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<UserApplications> userApplicationsList= new ArrayList<UserApplications>();
if(map.get("userApplicationsList") !=null){
	userApplicationsList=(List<UserApplications>)map.get("userApplicationsList");
}
	System.out.println("===============userApplicationsList  "+userApplicationsList.size());
%>
<ul>
	<%	if(userApplicationsList.size() !=0){
		for (UserApplications userApplications :userApplicationsList) {
			
%>
	<li style="width: auto;"><%=userApplications.getAppName()%>[<%=userApplications.getId()%>]</li>
	<%}}else{%>
	<li style="width: auto;">----------No
	Items found-------------</li>
	<%} %>
</ul>




<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasApplication> applicationsList= new ArrayList<MasApplication>();
if(map.get("applicationsList") !=null){
	applicationsList=(List<MasApplication>)map.get("applicationsList");
}
	System.out.println("===============userApplicationsList  "+applicationsList.size());
%>
<%@page import="jkt.hms.masters.business.UserApplications"%>
<%@page import="jkt.hms.masters.business.MasApplication"%>
<ul>
	<%	if(applicationsList.size() !=0){
		for (MasApplication userApplications :applicationsList) {
			String parentId=userApplications.getParentId();
			if(!parentId.equals("0")){
				String parentName=userApplications.getApplication().getName();
				System.out.println("parent name-----"+parentName);
				%>
	<li style="width: auto;"><%=userApplications.getName()%>[<%=userApplications.getId()%>]----<%=parentName %></li>
	<%
			}else{
			
%>
	<li style="width: auto;"><%=userApplications.getName()%>[<%=userApplications.getId()%>]</li>
	<%}}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




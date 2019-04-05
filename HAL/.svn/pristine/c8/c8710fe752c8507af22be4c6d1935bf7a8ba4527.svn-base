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
List<MasApplication> masApplicationList= new ArrayList<MasApplication>();
if(map.get("masApplicationList") !=null){
	masApplicationList=(List<MasApplication>)map.get("masApplicationList");
}
	System.out.println("===============masApplicationList  "+masApplicationList.size());
%>
<%@page import="jkt.hms.masters.business.UserApplications"%>
<%@page import="jkt.hms.masters.business.MasApplication"%>
<ul>
	<%String parent = "";
String parentId ="";
String applicationId ="";
int inc =0;
if(masApplicationList.size() > 0){
	for (MasApplication masApplication :masApplicationList ) {
		if(masApplication.getUrl().equals("#") || masApplication.getParentId().equals("0")){
	 parentId=masApplication.getParentId();
	if(!parentId.equals("0")){
	for(MasApplication masApp : masApplicationList){
		 
	 applicationId = masApp.getId();
	if(parentId.equals(applicationId)){
	 parent = masApp.getName();
	%>
	<li style="width: auto;"><%=masApplication.getName()%> ---- <%=parent %>[<%=masApplication.getId()%>]</li>
	<%}}}else if(parentId.equals("0")){
	%>
	<li style="width: auto;"><%=masApplication.getName()%>[<%=masApplication.getId()%>]</li>
	<%}
	inc++;
	}}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




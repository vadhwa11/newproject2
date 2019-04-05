<%@page import="jkt.hms.masters.business.Cims"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Drugdetails"%>

<%
List<Cims> drugDetailList = new ArrayList<Cims>();
Cims drugdetail = new Cims();

Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

if(map.get("drugDetailList") != null){
	drugDetailList=( List<Cims>)map.get("drugDetailList");
}	

%>

<ul>
	<%if (drugDetailList != null && drugDetailList.size() > 0) { %>

	<% for(int i=0;i<drugDetailList.size();i++)
{
	drugdetail = (Cims)drugDetailList.get(i);
			if(drugdetail.getItemId()!=null)
			{
				String genericName=drugdetail.getItemId().getNomenclature()+"["+drugdetail.getId()+"]";	
			%>
	<li style="width: auto; font: normal 11px tahoma; text-align: left;" value="<%=genericName%>"><%=genericName%></li>
	<%}}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




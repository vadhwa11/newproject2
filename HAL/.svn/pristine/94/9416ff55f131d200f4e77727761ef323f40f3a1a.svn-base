<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Drugdetails"%>

<%
List<Drugdetails> drugDetailList = new ArrayList<Drugdetails>();
Drugdetails drugdetail = new Drugdetails();

Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

if(map.get("drugDetailList") != null){
	drugDetailList=( List<Drugdetails>)map.get("drugDetailList");
}	

%>

<ul>
	<%if (drugDetailList != null && drugDetailList.size() > 0) { %>

	<% for(int i=0;i<drugDetailList.size();i++)
{
	drugdetail = (Drugdetails)drugDetailList.get(i);
			if(drugdetail.getGenericname()!=null)
			{
				String genericName=drugdetail.getGenericname()+"["+drugdetail.getSno()+"]";	
			%>
	<li style="width: auto; font: normal 11px tahoma; text-align: left;"><%=genericName%></li>
	<%}}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




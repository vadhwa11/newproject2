
<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasImmunization"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasImmunization> immunizationList  = new ArrayList<MasImmunization>();
if(map.get("immunizationList") != null){
	immunizationList = (List)map.get("immunizationList");
}

%>

<ul>
	<%	
if(immunizationList.size() !=0)
{
	for (MasImmunization immunization : immunizationList){ 
					 
%>
	<li style="width: auto;"><%=immunization.getImmunizationName()%>[<%=immunization.getImmunizationCode()%>]
	</li>

	<%
	}
}
else
{%>
	<li>----------No Items found-------------</li>
	<%}%>
</ul>




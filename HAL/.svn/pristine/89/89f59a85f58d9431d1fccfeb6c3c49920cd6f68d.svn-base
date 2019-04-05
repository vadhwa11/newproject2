
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasTherapyType> therapyTypeList = new ArrayList<MasTherapyType>();
if(map.get("therapyTypeList") != null){
	therapyTypeList = (List)map.get("therapyTypeList");
}

%>


<%@page import="jkt.hms.masters.business.MasTherapyType"%><ul>
	<%	
if(therapyTypeList.size() !=0)
{
	for (Iterator iterator = therapyTypeList.iterator(); iterator.hasNext();) 
	{
			MasTherapyType masTherapyType=(MasTherapyType)iterator.next();
			String therapyName=masTherapyType.getTherapyTypeName();
		   String therapyCode=masTherapyType.getTherapyTypeCode();
		    int itemId=masTherapyType.getId();
		 
%>
	<li style="width: auto;"><%=therapyName%>[<%=therapyCode%>]
	</li>

	<%
	}
}
else
{%>
	<li>----------No Items found-------------</li>
	<%}%>
</ul>




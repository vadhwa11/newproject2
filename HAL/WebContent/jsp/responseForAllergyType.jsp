<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasAllergyType> allergyTypeList = new ArrayList<MasAllergyType>();
if(map.get("allergyTypeList") != null){
	allergyTypeList = (List)map.get("allergyTypeList");
}

%>

<%@page import="jkt.hms.masters.business.MasAllergyType"%><ul>
	<%	
if(allergyTypeList.size() !=0)
{
	for (Iterator iterator = allergyTypeList.iterator(); iterator.hasNext();) 
	{
		MasAllergyType masAllergyType=(MasAllergyType)iterator.next();
			String allergyName=masAllergyType.getAllergyTypeName();
		   String allergyCode=masAllergyType.getAllergyTypeCode();
		   
		 
%>
	<li style="width: auto;"><%=allergyName%>[<%=allergyCode%>]
	</li>

	<%
	}
}
else
{%>
	<li>----------No Items found-------------</li>
	<%}%>
</ul>





<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List itemList= new ArrayList();
if(map.get("itemList") != null){
	itemList = (List)map.get("itemList");
}

%>

<ul>
	<%	
if(itemList.size() !=0)
{
	for (Iterator iterator = itemList.iterator(); iterator.hasNext();) 
	{
			MasStoreItem masStoreItem=(MasStoreItem)iterator.next();
			String itemName=masStoreItem.getNomenclature();
		    String pvmsNo=masStoreItem.getPvmsNo();
		    int itemId=masStoreItem.getId();
		 
%>
	<li style="width: auto;"><%=itemName%>[<%=pvmsNo%>]
	</li>

	<%
	}
}
else
{%>
	<li>----------No Items found-------------</li>
	<%}%>
</ul>




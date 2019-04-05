<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

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
<%	if(itemList.size() !=0){
		for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
			MasIcd masIcd = (MasIcd) iterator.next();
		    String icdName=masIcd.getIcdName();
		    int  icdId=masIcd.getId();
		    String icdCode = masIcd.getIcdCode();
%>
	<li style="width: auto; font: normal 11px tahoma; text-align: left;"><%=icdName%>[<%=icdCode %>][<%=icdId%>]</li>
	<%}}else{ %>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




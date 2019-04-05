<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasStoreSupplier> supplierList= new ArrayList<MasStoreSupplier>();
if(map.get("supplierList") != null){
	supplierList = (List)map.get("supplierList");
}
%>

<ul>
	<%	if(supplierList.size() !=0){
		for (MasStoreSupplier list :supplierList ) 
		{
			 
		    String vName=list.getSupplierName();
		    String vAdd1=list.getAddress1()!=null?list.getAddress1():"";
		    String vAdd2=list.getAddress2()!=null?list.getAddress2():"";
		    String vAdd = vAdd1.concat(vAdd2);
		    int  vId=list.getId();
		    
%>
	<li style="width: auto; font: normal 11px tahoma; text-align: left;"><%=vName%>[<%=vId%>](<%=vAdd %>)</li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




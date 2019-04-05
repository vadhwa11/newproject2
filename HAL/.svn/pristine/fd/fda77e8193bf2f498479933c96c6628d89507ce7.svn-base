<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
String pVMS="";
List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
if(map.get("pVMS") != null){
	pVMS =(String) map.get("pVMS");
	
}
System.out.println("pVMS>>>>>>>>>js[p>>>>>>.."+pVMS);
%>

<label>PVMS/NIV No. </label>
<div id="ddd">
<input type="text"  id="pvms" class="textbox_size20" name="pvms" value="<%=pVMS %>" />
</div>
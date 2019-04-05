<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.CssdInstrumentMaster"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List cssdInstrumentMasterList = new ArrayList();
if(map.get("cssdMaterialMasterList") != null){
	cssdInstrumentMasterList = (List)map.get("cssdMaterialMasterList");
}
%>

<%@page import="jkt.hms.masters.business.CssdMaterialMaster"%>
<ul>
	<%	if(cssdInstrumentMasterList.size() !=0){
		for (Iterator iterator = cssdInstrumentMasterList.iterator(); iterator.hasNext();) {
			CssdMaterialMaster cssdInstrumentMaster = (CssdMaterialMaster) iterator.next();
		    String instrumentName = cssdInstrumentMaster.getMaterialName();
		    String instrumentCode  = cssdInstrumentMaster.getMaterialCode();
%>
	<li style="width: auto;"><%=instrumentName%>[<%=instrumentCode%>]</li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>




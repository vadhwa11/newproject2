<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.WardRemarks"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
List<WardRemarks> wardRemarksList = new ArrayList<WardRemarks>();
String wardRemarks ="";
if(request.getAttribute("map") !=null){
	map=(Map<String, Object>)request.getAttribute("map");
}
if(map.get("wardRemarksList") !=null){
	wardRemarksList =(List<WardRemarks>)map.get("wardRemarksList");
}
int i=1;
if(wardRemarksList.size() >0){
	for(WardRemarks remarks :wardRemarksList){
		wardRemarks =wardRemarks+i+" : "+remarks.getRemarks()+"\n";
		i++;
	}
}
%>
<label class="valueNoWidth"> <%=wardRemarks%> </label>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.pacs.controller.PacsPatient"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<!-- Ranjesh Prasad: PACS Integration -->
<%
	Map<String, Object> map=new HashMap<String, Object>();
	List<PacsPatient> pacsPatients=new ArrayList<PacsPatient>();
	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientList")!=null){
		pacsPatients=(List<PacsPatient>)map.get("patientList");
	}
	String viewer="";
	if(map.get("viewer")!=null){
		viewer=(String)map.get("viewer");
	}
	String appUrl="";
	if(map.get("appUrl")!=null){
		appUrl=(String)map.get("appUrl");
	}
	System.out.println(pacsPatients.size()+"---->"+viewer+"====="+appUrl);
%>

<%if(pacsPatients.size()==0){ %>
<span>Requisition Not Send To PACS Server</span>
<%}else{ %>
<a href="<%=appUrl %>"><%=viewer %></a>
<%} %>


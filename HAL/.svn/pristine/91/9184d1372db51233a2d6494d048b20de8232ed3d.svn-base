<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%

Map<String,Object> map = new HashMap<String,Object>();
String reportPath = null;

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}


if(map.get("Report_Path") !=null){
	reportPath=(String)map.get("Report_Path");
}


%>
<html>
<head>    
</head>
<body>
<!-- 
<body onload="window.print()"> -->
<%-- <iframe style="position: absolute; height: 100%" src= "<%=reportPath%>" /> --%>

<iframe src="<%=reportPath%>"
            width="100%" height="100%" onload="this.contentWindow.print();" />
            
<%-- <embed src="<%=reportPath%>"  style="width: 100%;height: 100%;" /> --%>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</body>
</html>

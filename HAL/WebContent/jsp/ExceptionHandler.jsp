<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * ExceptionHandler.jsp  
 * Purpose of the JSP -  This is for Exception Handler.
 * @author  Deepti
 * Create Date: 01st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page isErrorPage="true" import="java.io.*"%>
<html>
<head>
<title>Exceptional Even Occurred!</title>
<style>
body,p {
	font-family: Tahoma;
	font-size: 10pt;
	padding-left: 30;
	
}

pre {
	font-size: 8pt;
}
</style>
</head>
<body>

<%-- Exception Handler --%>
<font color="red"> <%= exception.toString() %><br>
</font>

<%
out.println("<!--");
StringWriter sw = new StringWriter();
PrintWriter pw = new PrintWriter(sw);
exception.printStackTrace(pw);
out.print(sw);
sw.close();
pw.close();
out.println("-->");
%>

</body>
</html>

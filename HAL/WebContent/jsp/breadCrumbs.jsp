<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * breadCrumbs.jsp  
 * Purpose of the JSP -  
 * @author  Deepali
 * @author  Mansi
 * Create Date: 28th Jnu,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.3  
--%>

<%@ taglib prefix="bc"
	uri="http://projects.cofront.net/tablibs/breadcrumbs"%>
<html>
<head>
</head>

<body>
<bc:breadcrumbs separator=">" display="Home" href="/hms/jsp/login.jsp">
</bc:breadcrumbs>
<bc:breadcrumbs separator=">" display="Login" href="/hms/jsp/login.jsp">
</bc:breadcrumbs>
<bc:breadcrumbs separator=" " display="Pharmacy" href="Pharmacy.jsp">
</bc:breadcrumbs>
</body>

</html>








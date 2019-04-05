<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for ADT Message.
 * @author  Ritu
 * Create Date: 14th Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


<!-- <link href="css/hms_style.css" rel="stylesheet" type="text/css"> 
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />-->


<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script> <script
	type="text/javascript" src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
	
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}

int hinId=0;
if(map.get("hinId") != null){
	hinId = (Integer)map.get("hinId");
}
int hinIdMother=0;
if(map.get("hinIdMother") != null){
	hinIdMother = (Integer)map.get("hinIdMother");
}
String babyHin = "";
if(map.get("babyHin") != null){
	babyHin = (String)map.get("babyHin");
}
System.out.println("babyHin=in jsp===="+babyHin);

%>
<div id="contentHolder">
<form name="BabyDetails" method="post">

<h2><font id="error"><%=message%></font></h2>
<input name="hinId" type="hidden" value="<%=hinId%>" />
<input name="hinIdMother" type="hidden" value="<%=hinIdMother%>" />
<input name="babyHin" type="hidden" value="<%=babyHin%>" />
<input name="flag" type="hidden" value="b" />

<!-- <input name="Back" type="button" alt="Back" value="Back"	class="cmnButton" onClick="submitForm('BabyDetails','/hms/hms/ipd?method=showPatientListJsp');" align="right" />
<input name="Back" type="button" alt="Back" value="Admission"	class="cmnButton" onClick="submitForm('BabyDetails','/hms/hms/adt?method=showAdmissionJsp');" align="right" />
 --><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
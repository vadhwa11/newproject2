<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * message.jsp  
 * Purpose of the JSP -  This is for Message.
 * @author  Dipali
 * Create Date: 21 Nov,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 
	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	String url="";
	String url1="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		message=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	if(map.get("url1") !=null){
		url1=""+map.get("url1");
	}
	int sampleId = 0;
	if(map.get("sampleId")!=null){
		sampleId = (Integer)map.get("sampleId");
	}
%>
<form name="message" method="post">
<h4><%=message %></h4>
<div class="Clear"></div>
<input type="button" value="Back" class="button"
	onClick="submitForm('message','<%=url%>');" /> 
	<!--<input type="button"
	class="button" name="next" value="NextPatient"
	onclick="submitForm('message','/hms/hms/lab?method=nextForSampleCollection','checkTargetForNo');" />-->
<input type="button" value="NextScreen " class="button"
	onClick="submitForm('message','<%=url1%>','checkTargetForNo');" />
<input type="button" value="Print Barcode " class="button"	onClick="submitForm('message','/hms/hms/lab?method=printDiagnosticNoBarcode&sampleId=<%=sampleId %>');" />	
</form>

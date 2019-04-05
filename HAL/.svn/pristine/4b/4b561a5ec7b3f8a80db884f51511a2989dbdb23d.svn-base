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
<% 

	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	String url="";
	String nextCombinedIds = "";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		message=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("nextCombinedIds") !=null){
		nextCombinedIds = ""+map.get("nextCombinedIds");
	}

	if(map.get("url") !=null){
		url=""+map.get("url");
	}
%>
<form name="message" method="post">
<h4><%=message %></h4>
<div class="Clear"></div>
<input type="hidden" name="nextCombinedIdsForSampleValidationLab"
	id="nextCombinedIdsForSampleValidationLab" value="<%=nextCombinedIds%>" />
<%-- <input type="button" class="button" value="Back"
	onClick="submitForm('message','<%=url%>');" /> --%> <input type="button"
	class="button" name="next" value="Next Patient"
	onclick="submitForm('message','/hms/hms/lab?method=showPendingSampleValidationLabJsp');" />

</form>

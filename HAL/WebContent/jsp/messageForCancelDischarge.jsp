<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForMaster.jsp  
 * Purpose of the JSP -  This is for Master Message.
 * @author  vikas	 
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By: 			
 * @version 1.6
--%>

<%@ page import="java.util.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<% 	
		Map map = new HashMap();
		String message = "";
		String url = "";
		String title = "";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if( map.get("message") != null){	
			message = (String) map.get("message");
		}
		if( map.get("url") != null){	
			url = (String) map.get("url");
		}
		if( map.get("title") != null){	
			title = (String) map.get("title");
		}
	%>

<div id="contentHolder">
<form name="messsage" method="post" action=""><label
	class="noWidth"><span><%=message %></span></label>
<div class="Clear"></div>
<input type="button" class="button" value="Back" align="center"
	onClick="history.back();" /></form>
</div>
<div class="Clear"></div>

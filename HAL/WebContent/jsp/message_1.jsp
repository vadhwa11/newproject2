<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * message.jsp  
 * Purpose of the JSP -  This is for Message.
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 

	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap=(Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String currentDate =(String)utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTimeWithoutSc");
	String message="";
	String url="";
	String printUrl="";
	String backUrl="";
	String flag="";
	String proformaNo="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		message=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("message")!=null){
		message=""+map.get("message");
	}
	if(map.get("saved") !=null){
		url=""+map.get("url");
	}
	if(map.get("flag") !=null){
		flag=(String)map.get("flag");
	}
	
%>
<form name="message" method="post">
<h4>Prescription records has been updated sucessfully</h4>
<div class="clear"></div>
<input type="button" name="reset" value="Back to List"
	onClick="submitForm('message','opd?method=getFACWaitingList')"
	class="button" />
</form>
<div class="clear"></div>
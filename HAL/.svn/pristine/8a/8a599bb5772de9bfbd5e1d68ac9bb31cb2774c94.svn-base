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
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	if(map.get("flag") !=null){
		flag=(String)map.get("flag");
	}
	int dietFor=0;
	if(map.get("dietFor") !=null){
		dietFor=(Integer)map.get("dietFor");
	}
	int deptId=0;
	if(map.get("deptId") !=null){
		deptId=(Integer)map.get("deptId");
	}
	if(map.get("printUrl") !=null){
		printUrl=""+map.get("printUrl");
	}
	if(map.get("backUrl") !=null){
		backUrl=""+map.get("backUrl");
	}
	
	if(map.get("proformaNo") !=null){
		proformaNo=""+map.get("proformaNo");
		
	}
%>
<form name="message" method="post">
<h4><%=message %></h4>
<div class="clear"></div>
<%
	if(!printUrl.equals("")){
%>
<div class="division"></div>
<input type="button" value="Print" class="button" onClick="submitForm('message','<%=printUrl%>');" />
<%if(!backUrl.equals("")){%>
<input type="button" value="Back" class="button" onClick="submitForm('message','<%=backUrl%>');" />

<%} %>
<input type="button" value="EXPORT TO EXCEL" class="buttonBig" onClick="submitForm('message','/hms/hms/stores?method=ExportExcelForPerformaB');"/>
<input type="hidden" name="proformaNo" value="<%=proformaNo%>">
<div class="division"></div>
<%} %>


<%
	if(!url.equals("")){
%>
<input type="button" value="Back" class="button" onClick="submitForm('message','<%=url%>');" />
<%if(!flag.equals("") && flag.equals("dietSetup")){ %>
<input type="hidden" name="dietFor" value="<%=dietFor %>" >
<input type="hidden" name="dateFor" value="<%=currentDate%>" >
<input type="hidden" name="deptId" value="<%=deptId%>" >
<input type="hidden" name="timeFor" value="<%=time%>" >
<input type="button" value="Print" class="button" onClick="submitForm('message','/hms/hms/ipd?method=printDietReport');" />
<%} %>
<%} %>
</form>
<div class="clear"></div>
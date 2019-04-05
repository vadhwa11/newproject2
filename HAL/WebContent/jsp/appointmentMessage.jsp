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
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>

<%

	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	String url="";
	
	String appointmentNo = null;
	String flag =null;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	if(map.get("message") !=null){
		message=""+map.get("message");
	}
	if(map.get("url")!=null)
	{
		url=(String)map.get("url");
	}
	
	//-----------------------Vishal Code----------------------
	if(map.get("flag")!=null)
	{
		flag =(String)map.get("flag");
	}
	if(map.get("appointmentNo")!=null) 
	{
		appointmentNo =(String)map.get("appointmentNo");
	}
	//-----------------------Vishal Code----------------------
%>
<div id="contentHolder">
<form name="message" method="post"><br />
<label class="noWidth"><span><%=message %></span></label>
<div class="Clear"></div>
<input type="button" value="Back" class="button" onClick="<%=url %>" />

<!-- -----------------------Vishal Code----------------------  -->
<input	type="hidden" name="appointmentNo" value="<%=appointmentNo%>">
<% if(flag.equals("appointment")){%>
<input type="button" name="Print"	value="Generate Slip" target="_blank" class="buttonBig"	onClick="openSlipTab()" /> <%} %> <% if(flag.equals("investigation")){%>
<input	type="button" name="Print" value="Generate Slip" target="_blank"	class="buttonBig"	onClick="submitForm('message','appointment?method=printAppointmentInvestigationSlip');" />
<%} %> <!-- -----------------------Vishal Code----------------------  -->
<script type="text/javascript">
		function openSlipTab(){
		    checkTargetForYes();
		    submitForm('message','appointment?method=printAppointmentSlip');
		    checkTargetForNo();
		}
		</script></form>
</div>
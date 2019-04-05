<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForResult.jsp  
 * Purpose of the JSP -  This is for ResultEntry
 * @author  Abha

 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> infoMap = new HashMap<String,Object>();
	
	String message = "";
	String url = "";
	String resultIdStringForTemplate = "";
	String nextCombinedValidationIds = "";
	
	int deptId= 0;
    String orderNo = "";
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		message=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("url") != null){
		url = (String)map.get("url");
	}
	if(map.get("orderNo") != null){
		orderNo = (String)map.get("orderNo");
	}
	int orderId = 0;
	if(map.get("orderId") != null){
		orderId = (Integer)map.get("orderId");
	}
	
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	if(map.get("resultIdStringForTemplate")!= null){
		resultIdStringForTemplate= (String)map.get("resultIdStringForTemplate");
	}
	if(map.get("nextCombinedValidationIds")!= null){
		nextCombinedValidationIds = (String)map.get("nextCombinedValidationIds");
	}
	
%>
<form name="messageResult" method="post" target="_blank"><br />
<h4><%=message %></h4>
<div class="Clear"></div>
<input type="hidden" name="resultIdStringForTemplate"
	id="resultIdStringForTemplate" value="<%=resultIdStringForTemplate%>" />
<input type="hidden" name="nextCombinedValidationIds"
	id="nextCombinedValidationIds" value="<%=nextCombinedValidationIds%>" />


<!--<input type="button" name="next" value="Next" class="button"
	onclick="submitForm('messageResult','/hms/hms/investigation?method=nextForResultValidationLab','checkTargetForNo');" />
--><%
	if(map.get("template")!=null){
%>
<%}else{ %>
<input type="button" name="HTML" value="HTML" class="button" 
      onclick="submitForm('messageResult','/hms/hms/investigation?method=printResultValidationLab&orderNo=<%=orderId%>');" />
      <%} %>
<!--  <input type="button" value="Report Delivery" class="cmnButton" onClick="submitFormForButton('messageResult','/hms/hms/investigation?method=showReportCollectionJsp','checkTargetForNo');" /> -->
</form>

<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for Lab Message.
 * @author  Naresh
 * Create Date: 17 March,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<style>
#html,body {
	overflow: visible;
}
</style>

<%
Map<String, Object> map = new HashMap<String, Object>();
DgResultEntryDetail dgResultEntryDetail =new DgResultEntryDetail();

String[] orderStatusMsg = null;
String appendedHtml = "";
Boolean resultEntered = false;

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("orderStatusMsg") != null){
	orderStatusMsg = (String[])map.get("orderStatusMsg");
}
if(map.get("dgResultEntryDetail") != null){
	dgResultEntryDetail = (DgResultEntryDetail)map.get("dgResultEntryDetail");
}
if(map.get("appendedHtml") != null){
	appendedHtml = (String)map.get("appendedHtml");
}
if(map.get("resultEntered") != null){
	resultEntered = (Boolean)map.get("resultEntered");
}

%>
<br />
<%if(orderStatusMsg != null){ 
	for(String msg : orderStatusMsg){%>
<label class="value"
	style="FONT-WEIGHT: bold; FONT-SIZE: 11px; COLOR: #F71818; width: 100%; text-align: center; float: right; font-family: Verdana, Arial, Helvetica, sans-serif;">
<%=msg%> </label>
<br />
<%	}
} %>

<%if(resultEntered){ %>
<div id="contentHolder1"><br />

<label>&nbsp;</label><label>&nbsp;</label>


<div id="dataDiv" class="blockFrame1"
	style="border: none; background: white; height: auto; color: black; text-align: left;">
<label style="text-align: left; padding-left: 0px; color: red;">Result
:</label> <br>
<%if(dgResultEntryDetail.getResult() != null){%> <label class="value"><%= dgResultEntryDetail.getResult()%>
</label> <%}else{%> <textarea id="abc" name="test2" class="tableTextareaEditor"></textarea>
<%} %>
</div>
</div>
<%}%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<% 

	System.out.println("message jsp");
	Map<String,Object> map = new HashMap<String,Object>();
	int deptId=0;
	String url="";
	String indentNo="";
	String messageTOBeVisibleToTheUser ="";
	String messageType ="success";
	Box box=null;
	String printUrl = "";
	String poNumber="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if (map.get("box") != null) {
		box = (Box) map.get("box");
	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		messageTOBeVisibleToTheUser=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("messageType") !=null){
		messageType=""+map.get("messageType");
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	/*if(url==""){
		url="hms/hms/stores?method=showSearchIndentToDepo";
	}*/
	if(map.get("indentNo") !=null){
		indentNo=""+map.get("indentNo");
	}
	if(map.get("deptId") !=null){
		deptId=(Integer)map.get("deptId");
	}
	request.setAttribute("box",box);
	
	if(map.get("printUrl") !=null){
		printUrl=""+map.get("printUrl");
	}
	if(map.get("poNumber")!=null){
		poNumber=map.get("poNumber").toString();
	}
%>
<form name="messageNe" method="post">

<%if(!messageTOBeVisibleToTheUser.equals(""))
	{
	if(messageType.equals("success")){
	%>
<h4><%=messageTOBeVisibleToTheUser %></h4>

<%}%> <%if(messageType.equals("failure")){%>

<h4>
<%=messageTOBeVisibleToTheUser %>
</h4>
<%}}%> 
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<%
System.out.println("this is printing url"+printUrl);
if(!printUrl.equals("")){
%>
<input type="button" value="Print Indent" class="button" onClick="submitForm('messageNe','<%=printUrl %>');checkTargetForYes();" />
<%} %>
<input type="button" value="Export To Excel " class="buttonBig" onClick="submitForm('messageNe','neStores?method=generateExcelForDepotNe');" />

<input type="button" value="BACK" class="button"	onClick="submitForm('messageNe','<%=url %>');" />

<input type="hidden" value="<%=poNumber%>" name="exl_po" Id="po1" /> 
<input type="hidden" value="<%=poNumber%>" name="<%=PO_NO%>" Id="<%=PO_NO%>" /> 
<input type="hidden" name="indentNo" id="indentNo" value="<%=indentNo%>">
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</form>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<%
Map<String,Object> map=new HashMap<String,Object>();
String messageTOBeVisibleToTheUser ="";
if(request.getAttribute("map") != null){
	map = (Map<String,Object>) request.getAttribute("map");
}
if(map.get("messageTOBeVisibleToTheUser")!=null){
	messageTOBeVisibleToTheUser=(""+map.get("messageTOBeVisibleToTheUser"));
}
String messageType ="";
if(map.get("messageType")!=null){
	messageType=(""+map.get("messageType"));
}

System.out.print("messageTOBeVisibleToTheUser  in JSp "+messageTOBeVisibleToTheUser);
if(!messageTOBeVisibleToTheUser.equals(""))
{
	if(messageType.equals("success")){
%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; font-weight: bold; height: 23px;">
<%=messageTOBeVisibleToTheUser %></div>
</div>

<%}else{%>

<div id="errorMsg"
	style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div
	style="margin-right: 0px; /*changed from 3px */ text-align: center; font-weight: bold; height: 23px; background-color: #FFE8E8; float: left; width: 100%; color: red; border: 1px solid red;">
<%=messageTOBeVisibleToTheUser %></div>
</div>



<%}}%>
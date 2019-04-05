<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<% 
	Map<String,Object> map = new HashMap<String,Object>();
	int deptId=0;
	String url="";
	String balanceNo="";
	String messageTOBeVisibleToTheUser ="";
	String messageType ="success";
	Box box=null;
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
	if(url==""){
		url="hms/hms/stores?method=showBalanceJsp";
	}
	if(map.get("balanceNo") !=null){
		balanceNo=""+map.get("balanceNo");
	}
	if(map.get("deptId") !=null){
		deptId=(Integer)map.get("deptId");
	}
	request.setAttribute("box",box);
%>
<form name="message" method="post" target="">

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
<input type="button" name="print" type="submit" class="button"	value="Print" onClick="submitForm('message','/hms/hms/stores?method=printOpeningBalanceJsp&balanceNo=<%=balanceNo %>&deptId=<%=deptId %>');" />
<input type="button" value="Back" class="button" onClick="submitForm('message','<%=url%>');" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</form>

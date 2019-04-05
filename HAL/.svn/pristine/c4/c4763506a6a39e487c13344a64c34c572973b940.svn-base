<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<% 
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
<form name="message" method="post">

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

<input type="button" value="PRINT" class="button" onClick="submitForm('message','/hms/hms/neStores?method=printLocalSupplyOrder');" />
<input type="button" value="BACK" class="button"	onClick="submitForm('message','/hms/hms/neStores?method=showNonPurchaseOrderJsp');" />
<input type="hidden" value="<%=poNumber%>" name="exl_po" Id="po1" /> 
<input type="hidden" value="<%=poNumber%>" name="<%=PO_NO%>" Id="<%=PO_NO%>" /> 
<input type="hidden" name="indentNo" id="indentNo" value="<%=indentNo%>">
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</form>

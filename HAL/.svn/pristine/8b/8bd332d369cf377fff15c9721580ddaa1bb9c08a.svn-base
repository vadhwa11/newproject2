<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<% 

	System.out.println("message jsp");
	Map<String,Object> map = new HashMap<String,Object>();
	int deptId=0;
	String url="";
	String grnNo="";
	String messageTOBeVisibleToTheUser ="";
	String messageType ="success";
	Box box=null;
	String printUrl = "";
	int supId=0;
	String chkJsp= "";
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
		url="hms/hms/stores?method=showGrnJsp";
	}
	if(map.get("grnNo") !=null){
		grnNo=""+map.get("grnNo");
	}
	if(map.get("deptId") !=null){
		deptId=(Integer)map.get("deptId");
	}
	if(map.get("sup_id") !=null){
		supId=(Integer)map.get("sup_id");
	
	}
	if(map.get("chkJsp") !=null){
		chkJsp=(String)map.get("chkJsp");
	}
	request.setAttribute("box",box);
	
	if(map.get("printUrl") !=null){
		printUrl=""+map.get("printUrl");
	}

	
%>
<form name="message" method="post">
<input type="hidden" name="chkJsp" value="<%=chkJsp %>"/>
<input type="hidden" name="supId" value="<%=supId%>"/>

<%if(!messageTOBeVisibleToTheUser.equals(""))
	{
	if(messageType.equals("success")){
	%>
<h4><%-- <%=messageTOBeVisibleToTheUser %>--%>
<%="CRV No. "+grnNo+" saved successfully. Do you want to print?"%>
</h4>

<%}%> <%if(messageType.equals("failure")){%>

<h4>
<%=messageTOBeVisibleToTheUser %>
</h4>
<%}}%> 
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<%
if(!printUrl.equals("")){
%>
<input type="button" value="Print Crv" class="button" onClick="checkTargetForYes();submitForm('message','<%=printUrl %>');checkTargetForNo();" />
<%} %>
<input type="button" value="Back" class="button" onClick="submitForm('message','<%=url%>');" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</form>

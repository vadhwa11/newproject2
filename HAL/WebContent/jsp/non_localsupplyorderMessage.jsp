<%@page import="java.util.HashMap"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<% 

	Map<String,Object> map = new HashMap<String,Object>();
	String url="";
	String messageTOBeVisibleToTheUser ="";
	String messageType ="success";
	String po_number = "";
	String f_number = "";
	Box box=null;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if (map.get("box") != null) {
		box = (Box) map.get("box");
		po_number = box.get(PO_NO);
		f_number = box.get("fPoNumber");
		
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
	request.setAttribute("box",box);
%>
<script>
history.forward();
</script>
<form name="message" method="post">
<br />
<%if(!messageTOBeVisibleToTheUser.equals(""))
	{
	if(messageType.equals("success")){
	%>

<h4>
<%=messageTOBeVisibleToTheUser %>
</h4>

<%} %> <%if(messageType.equals("failure")){%>


<h4><%=messageTOBeVisibleToTheUser %></h4>

<%}} %> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" value="<%=po_number %>" name="exl_po" Id="po1" /> 
<input type="hidden" value="<%=po_number %>" name="<%=PO_NO%>" Id="<%= PO_NO%>" /> 
<input type="button" value="Print" class="button" onClick="submitForm('message','/hms/hms/neStores?method=printLocalSupplyOrder');" />
<input type="button" value="Back" class="button"	onClick="submitForm('message','/hms/hms/neStores?method=showNonPurchaseOrderJsp');" />
<div class="clear"></div><div class="division"></div><div class="clear"></div>
</form>

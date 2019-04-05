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
	String flag = "";
	if(map.get("flag") !=null){
		flag=""+map.get("flag");
	}
	
	request.setAttribute("box",box);
%>
<!--<script>
function methodForExcel()
{
	alert("hello");
	var poNo=document.getElementById('poNo').value;
    alert(poNo);
	
	}
}
</script>
-->
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
<%
if(flag.equals("approval")){
%>
<input type="button" value="Print" class="button" onClick="submitForm('message','/hms/hms/purchaseOrder?method=printLocalSupplyOrder');" />
<!--<input type="button" value="Back" class="button"	onClick="submitForm('message','/hms/hms/purchaseOrder?method=showPurchaseOrderJsp');" />-->
<input type="button" value="Export To Excel" name="exportExcel" class="buttonBig" onClick="submitForm('message','/hms/hms/purchaseOrder?method=generateExcelForVendor');"  />
<h6>(Exported Excel file should be in .xls Format)</h6>
<%}else{ %>
<input type="button" value="Back" class="button"	onClick="submitForm('message','/hms/hms/purchaseOrder?method=showPurchaseOrderJsp');" />
<%} %>
<!--<input type="button" value="PRE PROFORMA" name="exportExcel" class="buttonBig" onClick="submitForm('message','/hms/hms/purchaseOrder?method=generatePreProformaBReport');"  />
--><div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>

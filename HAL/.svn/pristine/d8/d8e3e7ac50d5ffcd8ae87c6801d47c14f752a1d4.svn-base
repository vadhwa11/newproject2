<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript">
	function cancelForm(issueId){
	window.opener.document.getElementById('issueId').value=issueId
  	 close();
   	}


</script>

<%
 	int issueId = 0; 
	Map<String,Object> map = new HashMap<String,Object>();
	String url="";
	String messageTOBeVisibleToTheUser ="";
	String messageType ="success";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
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
 	if(map.get("issueId") != null){
 		issueId= Integer.parseInt(""+map.get("issueId"));
 	}
 %>
<div id="contentspace">

<form name="itemBrandForm" method="post"><br />
<br />


<%if(!messageTOBeVisibleToTheUser.equals(""))
	{
	if(messageType.equals("success")){
	%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; font-weight: bold; height: 23px;">
<%=messageTOBeVisibleToTheUser %></div>
</div>
<script>
 			window.opener.document.getElementById('issueId').value="<%=issueId%>";
 		/*	window.opener.location.href = "stores?method=searchIssueCiv&issueUnit=" + <%=issueId%>;
	  		if (window.opener.progressWindow)
		 	{
		    	window.opener.progressWindow.close()
	  	 	} */
	  		window.close();
			</script> <%}%> <%if(messageType.equals("failure")){%>

<div id="errorMsg"
	style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div
	style="margin-right: 0px; /*changed from 3px */ text-align: center; font-weight: bold; height: 23px; background-color: #FFE8E8; float: left; width: 100%; color: red; border: 1px solid red;">
<%=messageTOBeVisibleToTheUser %></div>
</div>
<%}}%> <br />
<br />
<input id="exit" property="exit" type="button" name="exit" value="Exit"
	class="button" onclick="cancelForm(<%=issueId %>);" /></form>

</div>
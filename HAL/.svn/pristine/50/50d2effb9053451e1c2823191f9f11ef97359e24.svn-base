<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />


<%
 	String message= null;
 	int storeGrnReturnMId =0;
 	Map map = new HashMap();
 	String messageTOBeVisibleToTheUser="";
 	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		}
 	if(map.get("message")!=null){
 		message =(String)map.get("message");
	}
 	if(map.get("storeGrnReturnMId")!=null){
 		storeGrnReturnMId =Integer.parseInt(""+map.get("storeGrnReturnMId"))  ;
 		
	}
 %>
<script type="text/javascript">
	function cancelForm(){
	//window.opener.document.getElementById('storeGrnReturnMId').value=<%=storeGrnReturnMId%> ;
  	 close();
   	}
</script>

<form name="" method="post">

<div class="Clear"></div>
<h4><%=message %></h4>
<div class="Clear"></div>
<input id="exit" property="exit" type="button" name="exit" value="Exit"
	class="button" onclick="cancelForm();" /></form>


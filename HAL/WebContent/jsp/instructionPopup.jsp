

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>


<%

Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
String instruction = "";
if(map.get("instruction")!= null){
	instruction = (String)map.get("instruction");
}
System.out.println("instruction==6666==="+instruction);

%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<div id="contentHolder">
<div class="blockFrame">
<form name="investigationInstructions" method="post" action="">
<div class="Clear"></div>
<label>Instructions:</label> 
<%if(instruction != null){ %>
<textarea type="text" name=""id="instructions" class="large2" validate="Investigation Name,string,yes" maxlength="1200" tabindex=1 /><%=instruction %></textarea>
<%}else{ %>
<textarea type="text" name=""id="instructions" class="large2" validate="Investigation Name,string,yes" maxlength="1200" tabindex=1 /></textarea>

<%} %>
</form>
</div>
<div class="Clear"></div>
	<input type="button" name="instruction"  value="Submit" class="button" onClick="returnParent();" accesskey="a" tabindex=1 />
		<input type="button" name="close"  value="Close" class="button" onClick="window.close();" accesskey="a" tabindex=1 />
	

</div>
<script>
function returnParent()
	{
	
	if( document.getElementById("instructions"))
					{	
					
						window.opener.document.getElementById("instructionsParent").value = document.getElementById("instructions").value;
					}
	}
</script>
</form>






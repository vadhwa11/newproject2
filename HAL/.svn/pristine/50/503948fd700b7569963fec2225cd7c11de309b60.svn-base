<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}String message="";
if(map.get("message") != null){
	message = (String)map.get("message");
}
String hinId = "";
if(map.get("hinId")!= null)
  {
	hinId = (String)map.get("hinId");
	System.out.println("hinId in message For MentalPhysicalRetarted----------->>>"+hinId);
  }
%>

<form name="mentalPhysicalRetarded" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>

<input type="button" name="Yes" value="Yes" onclick="submitForm('mentalPhysicalRetarded','/hms/hms/mis?method=printMentalPhysicalRetarded&hinId=<%=hinId%>');" />
<input type="button" name="No" value="No" class="button"	onclick="submitForm('mentalPhysicalRetarded','/hms/hms/mis?method=showMentalPhysicalRetarded');" />

<div class="clear"></div>
<div class="division"></div>
</form>
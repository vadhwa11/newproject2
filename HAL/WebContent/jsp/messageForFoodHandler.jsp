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
int hinId=(Integer) map.get("hinId");

int FhId=0;
if(map.get("FhId")!=null)
{
	FhId=  (Integer) map.get("FhId");
	//System.out.println("FhId---CON->"+FhId);
}

%>

<form name="foodHandler" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>

<input type="hidden" name="FhId" value="<%=FhId%>" />

<input type="button" name="Yes" value="Print" onclick="submitForm('foodHandler','/hms/hms/mis?method=printPerformaFoodHandlerDetail');" />

<input type="button" name="No" value="Back" class="button"	onclick="history.back();" />

<div class="clear"></div>
<div class="division"></div>
</form>
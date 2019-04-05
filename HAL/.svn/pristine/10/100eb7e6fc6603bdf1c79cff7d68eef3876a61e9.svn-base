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
String nameofSchool="";
if(map.get("nameofSchool")!= null)
 {
	nameofSchool = (String)map.get("nameofSchool");
 }
int schInsId = 0;
if(map.get("schInsId")!=null)
{
	 schInsId = (Integer)(map.get("schInsId"));
	 System.out.println("schInsId---jsp->"+schInsId);
}
%>

<form name="messageFoeSchool" method="post">
<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="schInsId" value="<%=schInsId%>" />
<input type="button" name="Yes" value="Print" onclick="submitForm('messageFoeSchool','/hms/hms/mis?method=printSchoolInspectionDetail');" />

<input type="button" name="No" value="No" class="button" onclick="history.back();"  />

<div class="clear"></div>
<div class="division"></div>
</form>
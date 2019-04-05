<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
String message="";
if(map.get("message") != null){
	message = (String)map.get("message");
}

int bioMedicalId = 0;
if(map.get("bioMedicalId") != null){
bioMedicalId = (Integer)map.get("bioMedicalId");
System.out.println("bioMedicalId--JSp->"+bioMedicalId);
}
//int hinId=(Integer) map.get("hinId");
//System.out.println("hinId in message for notification"+hinId);
%>

<form name="messageForBioMedicalWaste" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>

<input type="hidden" name="bioMedicalId" value="<%=bioMedicalId %>" />

<input type="button" name="bmwDisposal" value="BMW Disposal" onclick="submitForm('messageForBioMedicalWaste','/hms/hms/mis?method=printBioMedicalDetailForBMW');" />

<input type="button" name="Yes" value="Visiting Officer" onclick="submitForm('messageForBioMedicalWaste','/hms/hms/mis?method=printBioMedicalDetailForVisitingOfficer');" />

<!--<input type="button" name="Yes" value="Visiting Officer" onclick="submitForm('messageForAccidentalDetail','/hms/hms/mis?method=printPerformaAccidentDetail');" />-->

<input type="button" name="No" value="Back" class="button"	onclick="history.back();" />

<div class="clear"></div>

</form>
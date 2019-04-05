<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.WardRemarks"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>

<%
	Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<WardRemarks>wardList=new ArrayList<WardRemarks>();
if(map.get("wardList")!=null){
	wardList=(List<WardRemarks>)map.get("wardList");
}
String message="";
if(map.get("message")!=null){
	message=(String)map.get("message");
}
String uhid="";
String patientName="";
String Remarks="";
int remarksId=0;
if(wardList.size()>0){
for(WardRemarks WardRemarks:wardList){
	uhid=WardRemarks.getInpatient().getHin().getHinNo();
	patientName=WardRemarks.getInpatient().getHin().getPFirstName();
	Remarks=WardRemarks.getRemarks();
	remarksId=WardRemarks.getId();
}
}
if(message!=null && !message.equals("")){
%>
<h4><%=message %></h4>
<%} %>


<%
if(wardList.size()>0){
%>
<form name="internalReferal" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<label>UHID</label>
<label class="value"><%=uhid %></label>

<label>Patient Name</label>
<label class="value"><%=patientName %></label>
<label>Remarks</label>
<label class="value"><%=Remarks %></label>

<div class="clear"></div>
<label>New Remarks</label>
<textarea name="newRemarks" id="newRemarks"></textarea>
<input type="hidden" name="remarksId" id="remarksId" value="<%=remarksId %>" />
<div class="clear"></div>
<input type="button" value="Update" onclick="submitForm('internalReferal','/hms/hms/ipd?method=updateReferal')" />

<%}%>
</form>
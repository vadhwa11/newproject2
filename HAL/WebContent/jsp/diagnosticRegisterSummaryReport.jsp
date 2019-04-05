<%@page import="static jkt.hms.util.RequestConstants.FROM_DATE"%>
<%@page import="static jkt.hms.util.RequestConstants.TO_DATE"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.MasHospital"%><link rel="stylesheet" type="text/css" href="/hms/jsp/css/report.css" />

<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
List<Object[]> diagnosticRegisterList = new ArrayList<Object[]>();

if(map.get("diagnosticRegisterList")!=null){
	diagnosticRegisterList = (List<Object[]>)map.get("diagnosticRegisterList");
}
List<MasHospital> hospitalList = new ArrayList<MasHospital>();
if(map.get("hospitalList")!=null){
	hospitalList = (List<MasHospital>)map.get("hospitalList");
}
Box box = HMSUtil.getBox(request);
%>


<%@page import="jkt.hms.util.HMSUtil"%>
<h1><%=hospitalList.get(0).getHospitalName() %></h1>
<h2><%=hospitalList.get(0).getAddress() %></h2>
<div class="Clear"></div>
<h3>
	Diagnostic Register Summary  for the period ( <%=box.getString(FROM_DATE)%> - <%=box.getString(TO_DATE)%> )
</h3>

<div class="Clear"></div>
<div class="Clear"></div>
<%if(diagnosticRegisterList.size() > 0){ %>
<div class="grid">
<table width="100%" border="1" cellspacing="1" cellpadding="1">
	<tr>
		<th scope="col">Department</th>
		<th scope="col">Modality</th>
		<th scope="col">Investigations</th>
		<th scope="col">OPD</th>
		<th scope="col">IPD</th>
		<th scope="col">Total</th>
		
	</tr>
	<%
		int i=0;
	int j=0;
		String dept = "";
		String modality = ""; 
		
	
			for(Object[] obj : diagnosticRegisterList){
				if(dept.equals(obj[5])){
					i++;
				}else{
					i=0;
				}
				if(modality.equals(obj[4])){
					j++;
				}else {
					j=0;
				}
	%>
	<tr>
	<%
		
		if(i==0){
	%>
	<td class="border-top"><%= obj[5]%></td>
	<%}else{ %>
	<td class="border-other">&nbsp;</td>
	<%} %>
	<%
		if(j==0){
	%>
	<td class="border-top"><%= obj[4]%></td>
	<%}else{ %>
	<td class="border-other"></td>
	<%} %>
	
	<td><%=obj[3] %></td>
	<td><%=(obj[0]!=null?obj[0]:0 )%></td>
	<td><%=(obj[1]!=null?obj[1]:0 ) %></td>
	<td><%=obj[2] %></td>
	</tr>
	<%		dept = (String)obj[5];
	modality = (String)obj[4];
			}
			%>
	</table>
	</div>
<%}else{ %>

<label>No Data Found!</label>
<%} %>


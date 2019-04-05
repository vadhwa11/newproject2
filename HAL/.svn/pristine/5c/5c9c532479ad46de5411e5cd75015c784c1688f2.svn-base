<%@ page import ="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>


<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Patient"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<div class="clear"></div>

<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
/*List<MasEmployeeDependent> dependentList = new ArrayList<MasEmployeeDependent>();
if(map.get("dependentList") != null){
	dependentList = (List<MasEmployeeDependent>)map.get("dependentList");
}*/
List<Patient> dependentList = new ArrayList<Patient>();
if(map.get("dependentList") != null){
	dependentList = (List<Patient>)map.get("dependentList");
}
int cnt=1;
	if(dependentList.size() > 0){
%>
<h4>Dependent Details</h4>
<div id="reg">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Name</th>
		<th scope="col">DOB</th>
		<th scope="col">Relation</th>
		<th scope="col">Income</th>
		<th scope="col">Employment Status</th>
		<th scope="col">Age</th>
		<th scope="col">Gender</th>
		<th scope="col">Date Of Dependency</th>
		<th scope="col">Authority</th>
		<th scope="col">Date of Removal From Dependency</th>
	</tr>
	<%
		for(Patient patient : dependentList){
			if(patient.getRelation().getId()!=8){
	%>
	<tr onclick=" displayPatientInfo('<%=patient.getId() %>');submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=displaySrPhoto&photoHinId=<%=patient.getId() %>','srPhoto'); checkForCheckUP();">
		<td><%= patient.getPFirstName()+" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"")+" "+(patient.getPLastName()!=null?patient.getPLastName():"")%>
		</td>
		<%
			if(patient.getDateOfBirth()!= null){
		%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(patient.getDateOfBirth()) %>
		</td>
		<%}else{ %>
		<td>&nbsp;
		</td>
		<%} %>
		<td><%=patient.getRelation().getRelationName() %>
		</td>
		<td><%= patient.getIncome()!=null?patient.getIncome():""%>
		</td>
		<td><%= patient.getOccupation()!=null?patient.getOccupation().getOccupationName():""%>
		</td>
		<td><%= patient.getAge()!=null?patient.getAge():""%>
		</td>
		
		<%
			if(patient.getSex()!= null){
		%>
		<td><%=patient.getSex().getAdministrativeSexName() %>
		</td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		<%
			if(patient.getDependencyDate() != null){
		%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(patient.getDependencyDate()) %>
		</td>
		<%}else{ %>
		<td>&nbsp;
		</td>
		<%} %>
		<%
			if(patient.getAuthority() != null){
		%>
		<td><%=patient.getAuthority() %>
		</td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
			<%
			if(patient.getDependencyRemovalDate() != null){
		%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(patient.getDependencyRemovalDate()) %>
		</td>
	<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
	</tr>
	
	
	<%cnt++;}} %>
<%--	<%
		for(MasEmployeeDependent masDependent : dependentList){
	%>
	<tr onclick="getPatientDetails('/hms/hms/registration?method=getPatientDetails&dependentId=<%=masDependent.getId() %>');">
		<td><%= masDependent.getEmployeeDependentName()%></td>
		<td><%=masDependent.getRelation().getRelationName() %></td>
		<%
			if(masDependent.getDateOfBirth()!= null){
		%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(masDependent.getDateOfBirth()) %></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		<%
			if(masDependent.getGender()!= null){
		%>
		<td><%=masDependent.getGender() %></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		<%
			if(masDependent.getDateOfDependency() != null){
		%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(masDependent.getDateOfDependency()) %></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		<%
			if(masDependent.getAuthority() != null){
		%>
		<td><%=masDependent.getAuthority() %></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
			<%
			if(masDependent.getDependencyRemovalDate() != null){
		%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(masDependent.getDependencyRemovalDate()) %></td>
	<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
	</tr>
	<%} %> --%>
</table>
</div>
<%} %>


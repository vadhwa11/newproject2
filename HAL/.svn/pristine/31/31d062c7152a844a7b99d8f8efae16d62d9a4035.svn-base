<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.InjAppointmentDetails"%>
<%@page import="java.util.ArrayList"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
List<InjAppointmentDetails> injectionAppList = new ArrayList<InjAppointmentDetails>();
if(map.get("injectionAppList") != null){
	injectionAppList= (List<InjAppointmentDetails>)map.get("injectionAppList");
}
%>


<table border="0" align="center" cellpadding="0" cellspacing="0" id="injectionApp">

	<tr>
		<th scope="col">Time</th>
		<th scope="col">Injection Name</th>
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th><!--
		<th scope="col"></th>-->
		<th scope="col"></th>
	</tr>
	<% int j=0;
		if(injectionAppList.size() > 0){
			for(InjAppointmentDetails appointmentDetails : injectionAppList){
	%>
	
	<tr>	
		<td><input type="text" name="appTime<%=j %>" id="appTime<%=j %>" value="<%=appointmentDetails.getAppointmentTime() %>" size="10"/>
		</td>
		<td><input type="text" name="appInjectionName<%=j %>" id="appInjectionName<%=j %>" value="<%=appointmentDetails.getItem().getNomenclature() %>" validate="Injection Name,string,yes" onblur="if(this.value!=''){getItemId(this.value,1);}" size="30"/>
		<input type="hidden" name="appInjectionId<%=j %>" id="appInjectionId<%=j %>" value="<%=appointmentDetails.getItem().getId() %>"/></td>
		<td><input type="text" name="appServiceNo<%=j %>" id="appServiceNo<%=j %>" value="<%=appointmentDetails.getInjAppointmentHeader().getHin().getServiceNo()!=null?appointmentDetails.getInjAppointmentHeader().getHin().getServiceNo():"" %>" size="15"/></td>
		<%
		String pName =appointmentDetails.getInjAppointmentHeader().getHin().getPFirstName();
		if(appointmentDetails.getInjAppointmentHeader().getHin().getPMiddleName() != null){
			pName += " "+appointmentDetails.getInjAppointmentHeader().getHin().getPMiddleName();
		}
		if(appointmentDetails.getInjAppointmentHeader().getHin().getPLastName() != null){
			pName += " "+appointmentDetails.getInjAppointmentHeader().getHin().getPLastName();
		}

		%>
		<td>
		<input type="text" name="appPatientName<%=j %>" id="appPatientName<%=j %>" value="<%=pName %>" size="20" maxlength="4" validate="" /></td>
		<td><input type="text" name="appRelation<%=j %>" id="appRelation<%=j %>" value="<%=appointmentDetails.getInjAppointmentHeader().getHin().getRelation().getRelationName() %>" size="10"/></td>
		<td><input type="text" name="appRank<%=j %>" id="appRank<%=j %>" value="<%=appointmentDetails.getInjAppointmentHeader().getHin().getRank().getRankName() %>" size="15"/></td>
		<%
		String sName = "";

		if(appointmentDetails.getInjAppointmentHeader().getHin().getSMiddleName() != null){
			sName += " "+appointmentDetails.getInjAppointmentHeader().getHin().getSMiddleName();
		}
		if(appointmentDetails.getInjAppointmentHeader().getHin().getSLastName() != null){
			sName += " "+appointmentDetails.getInjAppointmentHeader().getHin().getSLastName();
		}
		%>
		<td><input type="text" name="appName<%=j %>" id="appName<%=j %>" value="<%= sName%>" size="20"/></td>
		
		<td>&nbsp;</td>
		
	</tr>
	<%j++;}
			}%>
</table>
	<input type="hidden" name="hdb" value="<%=j %>" id="hdb" />
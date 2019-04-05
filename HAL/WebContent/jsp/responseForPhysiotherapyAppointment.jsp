<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.PhysioAppointmentDetail"%>
<%@page import="java.util.ArrayList"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
List<PhysioAppointmentDetail> physioAppList = new ArrayList<PhysioAppointmentDetail>();
if(map.get("physioAppList") != null){
	physioAppList= (List<PhysioAppointmentDetail>)map.get("physioAppList");
}
%>

<table border="0" align="center" cellpadding="0" cellspacing="0" id="therapyApp">

	<tr>
		<th scope="col">Time</th>
		<th scope="col">Duration</th>
		<th scope="col">Therapy Name</th>
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th><!--
		<th scope="col"></th>-->
		<th scope="col"></th>
	</tr>
	<% int j=0;
		if(physioAppList.size() > 0){
			for(PhysioAppointmentDetail physioAppointmentDetail : physioAppList){
	%>
	
	<tr>	
		<td><input type="text" name="appTime<%=j %>" id="appTime<%=j %>" value="<%=physioAppointmentDetail.getAppointmentTime() %>" size="10"/>
		</td>
		<td><input type="text" name="duration<%=j %>" id="duration<%=j %>" value="<%=physioAppointmentDetail.getDuration() %>" size="10"/>
		</td>
		<td><input type="text" name="appTherapyName<%=j %>" id="appInjectionId<%=j %>" value="<%=physioAppointmentDetail.getTherapy().getTherapyTypeName() %>" validate="Therapy Name,metachar,yes" onblur="if(this.value!=''){getItemId(this.value,1);}" size="30"/>
		<input type="hidden" name="appTherapyId<%=j %>" id="appTherapyId<%=j %>" value="<%=physioAppointmentDetail.getTherapy().getId() %>"/></td>
		<td><input type="text" name="appServiceNo<%=j %>" id="appServiceNo<%=j %>" value="<%=physioAppointmentDetail.getAppointmentHeader().getHin().getServiceNo()!=null?physioAppointmentDetail.getAppointmentHeader().getHin().getServiceNo():"" %>" size="15"/></td>
		<%
		String pName =physioAppointmentDetail.getAppointmentHeader().getHin().getPFirstName();
		if(physioAppointmentDetail.getAppointmentHeader().getHin().getPMiddleName() != null){
			pName += " "+physioAppointmentDetail.getAppointmentHeader().getHin().getPMiddleName();
		}
		if(physioAppointmentDetail.getAppointmentHeader().getHin().getPLastName() != null){
			pName += " "+physioAppointmentDetail.getAppointmentHeader().getHin().getPLastName();
		}

		%>
		<td>
		<input type="text" name="appPatientName<%=j %>" id="appPatientName<%=j %>" value="<%=pName %>" size="20" maxlength="4" validate="" /></td>
		<td><input type="text" name="appRelation<%=j %>" id="appRelation<%=j %>" value="<%=physioAppointmentDetail.getAppointmentHeader().getHin().getRelation().getRelationName() %>" size="10"/></td>
		<td><input type="text" name="appRank<%=j %>" id="appRank<%=j %>" value="<%=physioAppointmentDetail.getAppointmentHeader().getHin().getRank().getRankName() %>" size="15"/></td>
		<%
		String sName =physioAppointmentDetail.getAppointmentHeader().getHin().getSFirstName();
		if(physioAppointmentDetail.getAppointmentHeader().getHin().getSMiddleName() != null){
			sName += " "+physioAppointmentDetail.getAppointmentHeader().getHin().getSMiddleName();
		}
		if(physioAppointmentDetail.getAppointmentHeader().getHin().getSLastName() != null){
			sName += " "+physioAppointmentDetail.getAppointmentHeader().getHin().getSLastName();
		}
		%>
		<td><input type="text" name="appName<%=j %>" id="appName<%=j %>" value="<%= sName%>" size="20"/></td>
		
		<td>&nbsp;</td>
		
	</tr>
	<%j++;}
			}%>
</table>
	<input type="hidden" name="hdb" value="<%=j %>" id="hdb" />
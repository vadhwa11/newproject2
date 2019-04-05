<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>

<%@page import="jkt.hms.masters.business.ProcedureHeader"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
List<ProcedureHeader> opdProcedureList = new ArrayList<ProcedureHeader>();
if(map.get("opdProcedureList") != null)
{
	opdProcedureList=(List<ProcedureHeader>)map.get("opdProcedureList");
}
List<NursingcareSetup> ipProcedureList = new ArrayList<NursingcareSetup>();
if(map.get("ipProcedureList") != null)
{
	ipProcedureList=(List<NursingcareSetup>)map.get("ipProcedureList");
}
if(ipProcedureList.size() > 0){
	System.out.println("ff ghhj"+ipProcedureList.size());
	for(NursingcareSetup nursingcareSetup :ipProcedureList){
%>


<h6><%= HMSUtil.convertDateToStringWithoutTime(nursingcareSetup.getLastChgDate())+" "+(nursingcareSetup.getLastChgTime()) +" "+ (nursingcareSetup.getDepartment()!=null?nursingcareSetup.getDepartment().getDepartmentName():"")%></h6>
<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="opdinvestigationGrid">
	<tr>
		<th scope="col">Procedure</th>
		<th colspan="2">Duration</th>
		<th>Frequency</th>
		<th>No. of Days</th>
		<th>Remarks</th>
	
	</tr>

	<tr>
	<td><%=nursingcareSetup.getNursing().getNursingName() %></td>
	
<td><%=nursingcareSetup.getDuration()!=null?nursingcareSetup.getDuration():"&nbsp;" %>
		<input type="hidden" name="" tabindex="1" id="" value="<%//=nursingcareSetup.getDuration()!=null?nursingcareSetup.getDuration():"" %>"	size="12" maxlength="3" /></td>
		<td width="8%">min</td>
	
	<td width="27%" class="rowcolor"><%=nursingcareSetup.getFrequency()!=null?nursingcareSetup.getFrequency().getFrequencyName():"&nbsp;"%>

		</td>
		<td>
		<%=nursingcareSetup.getNoOfDays()!=null?nursingcareSetup.getNoOfDays():"&nbsp;" %>
		<td><%=nursingcareSetup.getRemarks()!=null?nursingcareSetup.getRemarks():"&nbsp;" %></td>
	</tr>
</table>
</div>
	<%} %>
	
	<div class="paddingTop15"></div>
	<%} if(opdProcedureList.size() >0){
	for(ProcedureHeader procedureHeader :opdProcedureList){
		
		
%>


<h6><%= HMSUtil.convertDateToStringWithoutTime(procedureHeader.getRequisitionDate())+" "+(procedureHeader.getLastChgTime())+" "+(procedureHeader.getOpdPatientDetails().getDepartment()!=null?procedureHeader.getOpdPatientDetails().getDepartment().getDepartmentName():"")%></h6>
<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="opdinvestigationGrid">
	<tr>
		<th scope="col">Procedure</th>
		<!-- <th colspan="2">Duration</th> -->
		<th>Frequency</th>
		<th>No. of Days</th>
		<th>Remarks</th>
	
	</tr>
	<%
	Set<ProcedureDetails> procDetailsSet =procedureHeader.getProcedureDetails();
	for(ProcedureDetails procDetails : procDetailsSet){
		
	%>
	<tr>
	<td><%=procDetails.getNursingCare().getNursingName() %></td>
	<td width="27%" class="rowcolor"><%=procDetails.getFrequency()!=null?procDetails.getFrequency().getFrequencyName():"&nbsp;"%></td>
	<td>
		<%=procDetails.getNoOfDays()!=null?procDetails.getNoOfDays():"&nbsp;" %>
	<%--
<td><%//=nursingcareSetup.getDuration()!=null?nursingcareSetup.getDuration():"&nbsp;" %>
		<input type="hidden" name="duration" tabindex="1" id="durationId" value="<%//=nursingcareSetup.getDuration()!=null?nursingcareSetup.getDuration():"" %>"	size="12" maxlength="3" /></td>
		<td width="8%">min</td>
	
	<td width="27%" class="rowcolor"><%//=nursingcareSetup.getFrequency().getFrequencyName()%>
	<input type="hidden" name="<%//=FREQUENCY%>" id="frequency" />
<%--<select name="<%=FREQUENCY%>" id="frequency<%=j %>"
			validate="Complaint,string,no">
			<option value="0">Select</option>
			<%
			 			for(MasFrequency masFrequency : frequencyList){
			 				
			 		%>
			<option value="<%=masFrequency.getId() %>"><%=masFrequency.getFrequencyName() %></option>
			<%} %>
		</select> 
		<script>
			document.getElementById('frequency').value='<%//=nursingcareSetup.getFrequency().getId()%>'
		</script>
		</td>
		<td>
		<%//=nursingcareSetup.getNoOfDays()!=null?nursingcareSetup.getNoOfDays():"&nbsp;" %>
		<input type="hidden" name="noOfDays" tabindex="1" id="noOfDays"  size="3" value="<%//=nursingcareSetup.getNoOfDays()!=null?nursingcareSetup.getNoOfDays():"" %>"	maxlength="3" validate="No Of Days,num,no" /></td>
		 --%>
		<td><%=procDetails.getRemarks()!=null?procDetails.getRemarks():"" %></td>
	</tr>
	<%} %>
</table>
</div>
<div class="paddingTop15"></div>
<%}
}%>
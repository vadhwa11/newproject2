<%@ page import="static jkt.hms.util.RequestConstants.HIN_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.VISIT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.INPATIENT_ID"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	List<Patient> patientList = new ArrayList<Patient>();
	if(map.get("patientList")!=null){
		patientList = (List<Patient>)map.get("patientList");
	}
	Patient patient = new Patient();
	if(patientList.size() > 0){
		patient = patientList.get(0);
	}
	String pName = patient.getPFirstName();
	if(patient.getPMiddleName() != null){
		pName += " "+patient.getPMiddleName();
	}
	if(patient.getPLastName() != null){
		pName += " "+patient.getPLastName();
	}
	String sName = patient.getSFirstName();
	if(patient.getSMiddleName() != null){
		sName += " "+patient.getSMiddleName();
	}
	if(patient.getSLastName() != null){
		sName += " "+patient.getSLastName();
	}
	String idMark1 ="";
	String idMark2 ="";
	
	if(patient.getRelation().getId()==8){
		if(patient.getSrIdentificationMark1()!=null){
			idMark1 = patient.getSrIdentificationMark1();
		}
		if(patient.getSrIdentificationMark2()!=null){
			idMark2 = patient.getSrIdentificationMark2();
		}
		
	}else{
		if(patient.getDepIdentificationMark1()!=null){
			idMark1 = patient.getDepIdentificationMark1();
		}
		if(patient.getDepIdentificationMark2()!=null){
			idMark2 = patient.getDepIdentificationMark2();
		}
		
	}
		
	
%>


<label>Patient Name</label> 
<label	class="value"><%= pName%></label> 
<label>Relation</label>
<label class="value"><%=patient.getRelation().getRelationName() %></label>
<div class="clear"></div>

<label>Rank</label>
<label class="value"><%=patient.getRank().getRankName() %></label>

<label>Name</label> 
<label class="value"><%= sName%></label> 

<label>Unit</label> 
<label class="value"><%=patient.getUnit().getUnitName() %></label> 
<div class="clear"></div>
<label>Trade/Branch</label> 
<%
	if(patient.getTrade()!= null){
%>
<label class="value"><%=patient.getTrade().getTradeName() %></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %> 
<label>Age</label> 
<%
	if(patient.getAge()!=null){
%>
<label class="value"><%=patient.getAge() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label> 
<%} %>
<label>Gender</label> 
<label class="value"><%=patient.getSex().getAdministrativeSexName() %></label> 

<%
if(patient.getPatientStatus().equalsIgnoreCase("Out Patient")){
%>
<input type="hidden" name="<%=VISIT_ID %>" value="" />
<%} %> 
<%
if(patient.getPatientStatus().equalsIgnoreCase("In Patient")){
%>
<input type="hidden" name="<%=INPATIENT_ID %>" value="" />
<%} %> 
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" />

<script>
document.getElementById('idMark1').value='<%=idMark1%>';
document.getElementById('idMark2').value='<%=idMark2%>';
</script>

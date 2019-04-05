<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * patientInfo.jsp  
 * Purpose of the JSP -  This is for Complete information of Patient.
 * @author  Ritu
 * Create Date: 29th Apr,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.22
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>

<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script>
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>


<%

	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	List<Patient> patientList = new ArrayList<Patient>();
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	
	if(map.get("patientList") != null){
		patientList = (List<Patient>)map.get("patientList");
		session.setAttribute("patientList", patientList);
	}else if(session.getAttribute("patientList") != null){
		patientList = (List<Patient>)session.getAttribute("patientList");
	}
	
		
	if(patientList.size() > 0)
	{
		Patient patient = patientList.get(0);
		if(!patient.getPatientStatus().equals("Expired")){
			String age = "";
			String currentAge = "";
			age = patient.getAge();
			currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());
					
%>
<style>
#contentspace label {
	text-align: right;
	padding-right: 10px;
	width: 96px;
	float: left;
	height: 9px;
}
</style>
<div id="contentspace">
<form name="visitByHin" method="post"><br />

<h2 align="left" class="style1">Patient Information</h2>

<div
	style="width: 15px; height: 20px; BORDER-bottom: #3c8ad7 1px solid; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Service Personnel Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 95px; background-color: #f4f9fe;">


<div style="height: auto; width: auto;"><br />

<label class="bodytextB">Service Type:</label> <span class="wardspan"><%= patient.getServiceType().getServiceTypeName()%></span>

<label class="bodytextB">Service No:</label> <%
				if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
			%> <span class="wardspan"><%= patient.getServiceNo()%></span> <%}else{ %>
<span class="wardspan">-</span> <%}%> <label class="bodytextB">Service
Status:</label> <%if(patient.getServiceStatus() != null){
			%> <span class="wardspan"><%= patient.getServiceStatus().getServiceStatusName()%></span>
<%}else{ %> <span class="wardspan">-</span> <% }%> <label class="bodytextB">Relation:</label>
<%
				if(patient.getRelation() != null){
			%> <span class="wardspan"><%= patient.getRelation().getRelationName()%></span>
<%}else{ %> <span class="wardspan">-</span> <% }%> <br />
<label class="bodytextB">Name:</label> <%
			if(patient.getSFirstName() != null && !(patient.getSFirstName().equals(""))){
			%> <span class="wardspan"><%= patient.getSFirstName()+" "+patient.getSMiddleName()+" "+patient.getSLastName()%></span>
<%}else{ %> <span class="wardspan">-</span> <% }%> <label class="bodytextB">Rank:</label>
<%
			if(patient.getRank() != null){
			%> <span class="wardspan"><%= patient.getRank().getRankName()%></span>
<%} else{ %> <span class="wardspan">-</span> <% }%> <br />

<%	if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
					if(patient.getServiceCardStatus().equals("y")){
			%> <label class="bodytextB">I-Card Verified:</label> <span
	class="wardspan">Yes</span> <%		}else{%> <label class="bodytextB">I-Card
Verified:</label> <span class="wardspan">No</span> <%		} 
				}%> <label class="bodytextB">I-Card Valid:</label> <%
				if(patient.getServiceCardValidityDate() != null){
			%> <span class="wardspan"><%= HMSUtil.convertDateToStringWithoutTime(patient.getServiceCardValidityDate())%></span>
<%}else{ %> <span class="wardspan">-</span> <% }
			%> <label class="bodytextB">D_O_I DCard:</label> <%
				if(patient.getDependentCardIssueDate() != null){
			%> <span class="wardspan"><%= HMSUtil.convertDateToStringWithoutTime(patient.getDependentCardIssueDate())%></span>
<%}else{ %> <span class="wardspan">-</span> <% }%>
</div>
</div>

<br />

<div
	style="width: 15px; height: 20px; BORDER-bottom: #3c8ad7 1px solid; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Patient Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 70px; background-color: #f4f9fe;">


<div style="height: auto; width: auto;"><br />
<label class="bodytextB">HIN No.:</label> <span class="wardspan"><%=patient.getHinNo() %></span>


<label class="bodytextB">Patient Name:</label> <span class="wardspan"><%= patient.getPFirstName()+" "+patient.getPMiddleName()+" "+patient.getPLastName()%></span>

<label class="bodytextB">Sex:</label> <span class="wardspan"><%=patient.getSex().getAdministrativeSexName() %></span>
<label class="bodytextB">Marital Status:</label> <%
					String maritalStatus = "";
				if(patient.getMaritalStatus() != null){
					maritalStatus = patient.getMaritalStatus().getMaritalStatusName();
				
				%> <span class="wardspan"><%=maritalStatus%></span> <%}else{ %> <span
	class="wardspan">-</span> <% }%> <label class="bodytextB">Age:</label> <span
	class="wardspan"><%=currentAge%></span> <%
				String religion = "";
				if(patient.getReligion() != null){
					religion = patient.getReligion().getReligionName();
				%> <label class="bodytextB">Religion:</label> <span class="wardspan"><%= religion%></span>
<%} %> <label class="bodytextB">District:</label> <%
					if(patient.getDistrict() != null){
				%> <span class="wardspan"><%=patient.getDistrict().getDistrictName() %></span>
<%}else{ %> <span class="wardspan">-</span> <% }%>
</div>
</div>
<br />

<div
	style="width: 15px; height: 20px; BORDER-bottom: #3c8ad7 1px solid; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Visit Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 70px; background-color: #f4f9fe;">


<div style="height: auto; width: auto;"><br />

<%
		String visitDate = "";
		String department = "";
		String doctor ="";
		String diagnosis = "";
		String hospitalStaff = "";
		String visitNo = "";
		
		if(patient.getPatientStatus().equals("Out Patient")){
			visitNo = patient.getCurrentVisitNo().toString();
			Set<Visit> visitSet = new HashSet<Visit>();
			visitSet = patient.getVisits();
			for(Visit visit : visitSet){
				if(patient.getCurrentVisitNo().equals(visit.getVisitNo())){
					visitDate = HMSUtil.convertDateToStringWithoutTime(visit.getVisitDate());
					if(visit.getDepartment() != null){
						department = visit.getDepartment().getDepartmentName();
					}else{
						department = "-";
					}
					if(visit.getDoctor() != null){
						doctor = visit.getDoctor().getFirstName();
					}else{
						doctor = "-";
					}
					if(visit.getDiagnosis() != null){
						diagnosis = visit.getDiagnosis().getDiagnosisConclusionName();
					}else{
						diagnosis = "-";
					}
					hospitalStaff = visit.getHospitalStaff();
				}
				
			}
		}else{
			visitNo = "-";
			visitDate = "-";
			department = "-";
			doctor = "-";
			diagnosis = "-";
			
		}
	%> <label class="bodytextB">Visit No.</label> <span class="wardspan"><%=visitNo %></span>

<label class="bodytextB">Visit Date:</label> <span class="wardspan"><%=visitDate %></span>

<label class="bodytextB">Department:</label> <span class="wardspan"><%=department %></span>

<label class="bodytextB">Consulting Doc:</label> <span class="wardspan"><%=doctor %></span>

<br />

<label class="bodytextB">Diagnosis:</label> <span class="wardspan"><%=diagnosis %></span>

<label class="bodytextB">Hospital Staff:</label> <%
		if(hospitalStaff.equals("y")){
			%> <span class="wardspan">Yes</span> <%	}else if(hospitalStaff.equals("n")){
		%> <span class="wardspan">No</span> <%	}else{
%> <span class="wardspan">-</span> <%} %>
</div>
</div>
<br />

<br />

<div
	style="width: 15px; height: 20px; BORDER-bottom: #3c8ad7 1px solid; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Admission Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 70px; background-color: #f4f9fe;">


<div style="height: auto; width: auto;"><br />

<%
		String adNo = "";
		String admDate = "";
		String ward ="";
		String admittedBy = "";
		String provisinalDiagnosis = "";
		String condition = "";
		
		if(patient.getPatientStatus().equals("In Patient")){
		
			Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
			inpatientSet = patient.getInpatients();
			for(Inpatient inpatient : inpatientSet){
				if(inpatient.getAdStatus().equals("A")){
					admDate = HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission());
					adNo = inpatient.getAdNo();
					if(inpatient.getDepartment() != null){
						ward = inpatient.getDepartment().getDepartmentName();
					}else{
						ward = "-";
					}
					if(inpatient.getDoctor() != null){
						admittedBy = inpatient.getDoctor().getFirstName();
					}else{
						admittedBy = "-";
					}
					if(inpatient.getDiagnosis() != null){
						provisinalDiagnosis = inpatient.getDiagnosis().getIcdName();
					}else{
						provisinalDiagnosis = "-";
					}
					if(inpatient.getConditionStatus() != null){
						condition = inpatient.getConditionStatus();
					}else{
						condition = "-";
					}
				}
			}
		}else{
			admDate = "-";
			adNo = "-";
			ward = "-";
			admittedBy = "-";
			provisinalDiagnosis = "-";
			condition = "-";
		}
	%> <label class="bodytextB">A&D No.:</label> <span class="wardspan"><%=adNo %></span>

<label class="bodytextB">Adm Date:</label> <span class="wardspan"><%=admDate %></span>

<label class="bodytextB">Ward:</label> <span class="wardspan"><%=ward%></span>

<label class="bodytextB">Admitted By:</label> <span class="wardspan"><%=admittedBy %></span>

<br />

<label class="bodytextB">Prov. Diagnosis:</label> <span class="wardspan"><%=provisinalDiagnosis %></span>

<label class="bodytextB">Condition:</label> <span class="wardspan"><%=condition %></span>

</div>
</div>
<br />

<% }
	}%>
</form>
</div>
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * visitByHin.jsp
 * Purpose of the JSP -  This is for Visit By HIN.
 * @author  Ritu
 * Create Date: 08th Feb,2008
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
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
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
	Map<String, Object> patientVisitMap = new HashMap<String, Object>();

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	List<Visit> visitList = new ArrayList<Visit>();
	List<MasComplaint> complaintList = new ArrayList<MasComplaint>();
	List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>();
	List<MasDiagnosisConclusion> diagnosisList = new ArrayList<MasDiagnosisConclusion>();
	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");

	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientVisitMap") != null){
		patientVisitMap = (Map<String,Object>)map.get("patientVisitMap");
	}

	if(patientVisitMap.get("visitList") != null){
		visitList = (List<Visit>)patientVisitMap.get("visitList");
	}
	if(patientVisitMap.get("doctorList") != null){
		doctorList = (List<MasEmployee>)patientVisitMap.get("doctorList");
	}
	if(visitList.size() > 0)
	{
		Visit visit = visitList.get(0);
		Patient patient = (Patient)visit.getHin();
		if(!visit.getHin().getPatientStatus().equals("Expired")){

		if(map.get("complaintList") != null){
			complaintList = (List<MasComplaint>)map.get("complaintList");
		}
		if(map.get("caseTypeList") != null){
			caseTypeList = (List<MasCaseType>)map.get("caseTypeList");
		}
		if(map.get("diagnosisList") != null){
			diagnosisList = (List<MasDiagnosisConclusion>)map.get("diagnosisList");
		}
		if(map.get("disposalList") != null){
			disposalList = (List<MasDisposal>)map.get("disposalList");
		}

%>

<div id="contentHolder">
<form name="updateVisit" method="post">

<h6>Update Patient Visit</h6>
<div class="Clear"></div>
<div class="blockTitle">Service Personnel Details</div><div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<%
				if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
			%> <label>Service No:</label> <label
	class="value"><%= patient.getServiceNo()%></label> <%} %> <%
			if(patient.getServiceStatus() != null){
			%> <label>Service Status:</label> <label
	class="value"><%= patient.getServiceStatus().getServiceStatusName()%></label>
<%} %> <label>Service Type:</label> <label
	class="value"><%= patient.getServiceType().getServiceTypeName()%></label>

<%
				if(patient.getRelation() != null){
			%> <label>Relation:</label> <label class="value"><%= patient.getRelation().getRelationName()%></label>
<%} %>
<%
			if(patient.getSFirstName() != null && !(patient.getSFirstName().equals(""))){
			%> <label>Name:</label> <label class="value"><%= patient.getSFirstName()+" "+patient.getSMiddleName()+" "+patient.getSLastName()%></label>
<%}
			if(patient.getRank() != null){
			%> <label>Rank:</label> <label class="value"><%= patient.getRank().getRankName()%></label>


<%} %> <%	if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
					if(patient.getServiceCardStatus().equals("y")){
			%> <label>I-Card Verified:</label> <label
	class="value">Yes</label> <%		}else{%> <label>I-Card
Verified:</label> <label class="value">No</label> <%		}
				}%> <%
				if(patient.getServiceCardValidityDate() != null){
			%> <label>I-Card Valid:</label> <label
	class="value"><%= HMSUtil.convertDateToStringWithoutTime(patient.getServiceCardValidityDate())%></label>
<%}
				if(patient.getDependentCardIssueDate() != null){
			%> <label>D_O_I DCard:</label> <label
	class="value"><%= HMSUtil.convertDateToStringWithoutTime(patient.getDependentCardIssueDate())%></label>
<%}
			%>
</div>
<div class="Clear"></div>
<div class="blockTitle">Patient Details</div><div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">

<label>HIN No.:</label> <label class="value"><%=patient.getHinNo() %></label>


<label>Patient Name:</label> <label class="value"><%= patient.getPFirstName()+" "+patient.getPMiddleName()+" "+patient.getPLastName()%></label>

<label>Sex:</label> <label class="value"><%=patient.getSex().getAdministrativeSexName() %></label>
<%
					String maritalStatus = "";
				if(patient.getMaritalStatus() != null){
					maritalStatus = patient.getMaritalStatus().getMaritalStatusName();

				%> <label>Marital Status:</label> <label
	class="value"><%=maritalStatus%></label> <%} %> <label
	>Age:</label> <label class="value"><%=HMSUtil.calculateAge(visit.getHin().getAge() , visit.getHin().getRegDate(), visit.getHin().getDateOfBirth())%></label>
<%
				String religion = "";
				if(patient.getReligion() != null){
					religion = patient.getReligion().getReligionName();
				%> <label>Religion:</label> <label class="value"><%= religion%></label>
<%} %> <%
					if(patient.getDistrict() != null){
				%> <label>District:</label> <label class="value"><%=patient.getDistrict().getDistrictName() %></label>
<%} %>
</div>
<div class="Clear"></div>

<div class="blockTitle">Visit Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label>Visit	No.</label>
<label class="value"><%=visit.getVisitNo()%></label>
<label>Visit Date</label>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(visit.getVisitDate()) %></label>
<label>Visit Time: </label>
<label class="value"><%=visit.getVisitTime() %></label>
<div class="Clear"></div>

<label>Hospital	Staff:</label> <%if(visit.getHospitalStaff().equals("y")){%>
<label class="value"><input	type="checkbox" name="<%=HOSPITAL_STAFF %>" value="y"	checked="checked" class="radio"></label> <%}else{ %>
<label class="value"><input type="checkbox" name="<%=HOSPITAL_STAFF %>" value="y" class="radio"></label> <%} %>
<label>Complaint:</label>
		<%if(visit.getComplaintString() != null){%>
<input type="text"	name="<%=COMPLAINT_ID%>" value="<%=visit.getComplaintString()%>"	validate="Complaint,string,no"	maxlength="100">
<%}else{ %>
<input type="text" name="<%=COMPLAINT_ID%>" value="" validate="Complaint,string,no" maxlength="100">
<%} %>

<label>Department:</label>
<label class="value"><%=visit.getDepartment().getDepartmentName() %></label>
<div class="Clear"></div>
<label>	Consulting	Doc:</label>
<select name="<%=CONSULTING_DOCTOR %>"	id="<%=CONSULTING_DOCTOR %>" validate="Consulting Doctor,string,no"	onchange="submitProtoAjax('updateVisit','registration?method=getTokenNoForDepartment')"  >//onchange="fillTokenNo(this.value);"
			<option value="0">select</option>
			<%

		for(MasEmployee employee :doctorList){
			if(visit.getDoctor()!=null){
			if(employee.getId().equals(visit.getDoctor().getId())){
	%>
			<option value="<%=employee.getId()%>" selected="selected"><%=employee.getFirstName()+" "+employee.getLastName() %></option>
			<%}else{ %>
			<option value="<%=employee.getId()%>"><%=employee.getFirstName()+" "+employee.getLastName() %></option>
			<%}}else{%>
			<option value="<%=employee.getId()%>"><%=employee.getFirstName()+" "+employee.getLastName() %></option>
			<%}} %>
		</select>

<label>Case Type:</label>
<select name="<%=CASE_TYPE_ID %>" validate="Case Type,string,no">
			<option value="0">Select</option>
			<%for(MasCaseType masCaseType : caseTypeList){%>
			<option value="<%=masCaseType.getId() %>"><%=masCaseType.getCaseTypeName() %></option>
			<%}%>
		</select>
		<script type="text/javascript">
          	<%  if(visit.getCaseType()  != null){
			 			int caseTypeId = visit.getCaseType().getId() ;
					%>
					document.updateVisit.<%=CASE_TYPE_ID%>.value = '<%=caseTypeId %>';
               <%
			 		}%>
    </script>
<label>Diagnosis:</label>
		<%if(visit.getDiagnosisString()!=null){ %>
		<input type="text"		name="<%=DIAGNOSIS_ID%>" value="<%=visit.getDiagnosisString()%>"	validate="Diagnosis,string,no"	maxlength="100">
		<%}else{ %>
		<input type="text" name="<%=DIAGNOSIS_ID%>" value=""	validate="Diagnosis,string,no"	maxlength="100" /> <%} %>


		<%
		int tokenNo = 0;
		if(visit.getTokenNo()!=null && !(visit.getTokenNo().equals(""))){
			tokenNo= visit.getTokenNo();
		}
		%>
			<label><span
			>*</span> Token No.:</label>

		<div id="testDiv">
		<input id="tokenNoId" type="text" name="<%=TOKEN_NO %>" value="<%=visit.getTokenNo() %>" validate="Token no.,string,yes" maxlength="3" readonly="readonly">
		</div>
</div>

<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<div class="Clear"></div>

<div class="bottom">
<div id="edited"></div>
<input type="button" name="Submit" value="Update"	class="button"	onClick="submitForm('updateVisit','/hms/hms/registration?method=updateVisitInformation');" />
<input type="reset" name="Reset" value="Reset" class="button"	onclick="location.reload();" accesskey="r" />
<div class="Clear"></div>
<label	>Changed By:</label>
<label class="value"><%=userName%></label>

<label>Changed Date:</label>
<label class="value"><%=currentDate%></label>

<label>Changed Time:</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>

</form>

<% }
}else{%>

<label class="noWidth"><span>No Record Found !!</span></label>

<%} %>
<div id="statusMessage" class="messagelabel">
</div>

<script type="text/javascript">
function fillTokenNo(obj){
	var invObj;
	<%	for(Visit visit :visitList){
		   if(visit.getDoctor()!=null){
						%>
						invObj ='<%= visit.getDoctor().getId()%>';
						if(invObj == obj){
				document.getElementById('tokenNoId').value='<%=visit.getTokenNo()%>'

				}else{
					submitProtoAjax('updateVisit','registration?method=getTokenNoForDepartment')
				}

		<%}
			} %>
			}
</script>
</div>
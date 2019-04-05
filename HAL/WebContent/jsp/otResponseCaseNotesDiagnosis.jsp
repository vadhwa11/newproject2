<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.DIAGNOSIS_ID"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
List<OpdPatientDetails> caseSheetList = new ArrayList<OpdPatientDetails>();
if(map.get("caseSheetList") != null)
{
	caseSheetList=(List<OpdPatientDetails>)map.get("caseSheetList");
}

List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
if(map.get("icdList") != null){
	icdList=(List<DischargeIcdCode>)map.get("icdList");
}


%>
<%
int m = 1;	
if(caseSheetList.size() > 0){
	System.out.println("caseSheetList"+caseSheetList.size());
		for(OpdPatientDetails patientDetails : caseSheetList){
			if(patientDetails.getVisit()!=null){
%>
<h6>
<%=HMSUtil.convertDateToStringWithoutTime(patientDetails.getOpdDate()) %> <%=patientDetails.getOpdTime() %> <%=patientDetails.getDepartment()!=null?patientDetails.getDepartment().getDepartmentName():""%></h6>
<div class="clear"></div>
<div class="small">

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid1">
	<tr>
		<th scope="col">Case Notes</th>

	</tr>
	<tr>
	<td><%=patientDetails.getCaseNotes()!=null?patientDetails.getCaseNotes():"&nbsp;" %></td>
	</tr>
</table>
</div>
<div class="clear paddingTop15"></div>
<h4>Diagnosis</h4>
<div class="Block">


<label>Working Diagnosis</label>
<label class="value"><%=patientDetails.getInitialDiagnosis()!=null?patientDetails.getInitialDiagnosis():"" %></label>

<label>System Diagnosis</label>
<label class="value"><%=patientDetails.getSystemDiagnosis()!=null?patientDetails.getSystemDiagnosis().getSystemDiagnosisName():"" %></label>
<div class="clear"></div>

<label>ICD Diagnosis</label>
<%-- <%String diagnosis = "";
if(icdList.size() > 0){
	for(DischargeIcdCode dischargeIcdCode : icdList){
		if(!diagnosis.equals("")){
			diagnosis += ",";
		}
		diagnosis += dischargeIcdCode.getIcd()!=null?dischargeIcdCode.getIcd().getIcdName():"";
	}
}
%>  --%>

<%String diagnosis = "";
if(icdList.size() > 0){
	//System.out.println("ipIcdList"+icdList.size());
	for(DischargeIcdCode dischargeIcdCode : icdList){
		//System.out.println("ipIcdList1"+icdList.size());
		/* if(patientDetails.getId() == dischargeIcdCode.getOpdPatientDetails().getId())
		{ */
			System.out.println("ipIcdList2"+icdList.size());
			if(!diagnosis.equals("")){
				diagnosis += ",";
			}
			diagnosis += dischargeIcdCode.getIcd().getIcdName();
		//}
	
	}
}
%> 
<%
	if(!diagnosis.equals("")){
%>
<label class="value"><%=diagnosis %></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>
<div class="clear"></div>
</div>

<%}else if(patientDetails.getInpatient()!=null){ %>
<div class="clear"></div>
<h6><%=HMSUtil.convertDateToStringWithoutTime(patientDetails.getOpdDate()) %> <%=patientDetails.getOpdTime() %> <%=patientDetails.getDepartment()!=null?patientDetails.getDepartment().getDepartmentName():""%></h6>
<div class="clear"></div>
<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid1">
	<tr>
		<th scope="col">Case Notes</th>

	</tr>
	<tr>
	<td><%=patientDetails.getCaseNotes()!=null?patientDetails.getCaseNotes():"&nbsp;" %></td>
	</tr>
</table>
</div>
<div class="clear paddingTop15"></div>
<h4>Diagnosis</h4>
<div class="Block">


<label>Working Diagnosis</label>
<label class="value"><%=patientDetails.getInitialDiagnosis()!=null?patientDetails.getInitialDiagnosis():"" %></label>

<label>System Diagnosis</label>
<label class="value"><%=patientDetails.getSystemDiagnosis()!=null?patientDetails.getSystemDiagnosis().getSystemDiagnosisName():"" %></label>
<div class="clear"></div>

<label>ICD Diagnosis</label>
<%-- <%String diagnosis = "";
if(icdList.size() > 0){
	for(DischargeIcdCode dischargeIcdCode : icdList){
		if(!diagnosis.equals("")){
			diagnosis += ",";
		}
		diagnosis += dischargeIcdCode.getIcd()!=null?dischargeIcdCode.getIcd().getIcdName():"";
	}
}
%>  --%>


<%String diagnosis = "";
System.out.println("ipIcdList.size()"+icdList.size());
if(icdList.size() > 0){
	for(DischargeIcdCode dischargeIcdCode : icdList){
		if(patientDetails.getId() == dischargeIcdCode.getOpdPatientDetails().getId())
		{
			if(!diagnosis.equals("")){
				diagnosis += ",";
			}
			diagnosis += dischargeIcdCode.getIcd().getIcdName();
		}
		
	}
}
%>

<%
	if(!diagnosis.equals("")){
%>
<label class="value"><%=diagnosis %></label>
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %>
<div class="clear"></div>
</div>
<%}
		//	opdPatientDetails = patientDetails;
		m++;}
}%>

<div class="Clear"></div>

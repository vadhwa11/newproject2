<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.DIAGNOSIS_ID"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.PreAnesthesiaConsultDoctorDt"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
List<PreAnesthesiaConsultDoctorDt> consultDoctorDtList = new ArrayList<PreAnesthesiaConsultDoctorDt>();
if(map.get("consultDoctorDtList") != null)
{
	consultDoctorDtList=(List<PreAnesthesiaConsultDoctorDt>)map.get("consultDoctorDtList");
}
int tCount =1;
int tRow =0;
Date date = new Date();
int days = 0;
if(consultDoctorDtList.size() >0){
	String fromDoctor = "";
	String fromDepartment = "";
	String referralNote= "";
	String toDoctor = "";
	String consultationAdvice= "";
	for(PreAnesthesiaConsultDoctorDt consultDoctorDt : consultDoctorDtList){
		tRow =1;
		String str = "";
		if(consultDoctorDt.getConsultDate()!=null )
		{
			str = HMSUtil.convertDateToStringWithoutTime(consultDoctorDt.getConsultDate());
		}
		if(consultDoctorDt.getConsultTime()!=null && consultDoctorDt.getConsultTime().trim().equals(""))
		{
			str += " "+consultDoctorDt.getConsultTime();
		}
		  if(consultDoctorDt.getConsultedDepartment()!=null){
			str += " "+consultDoctorDt.getConsultedDepartment().getDepartmentName();
		}
		
		
%>
<h6><%=str%></h6>
<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="opdgrid">
	<tr>
		<th scope="col">From Doctor</th>
		<th scope="col">Referral Note</th>
		<th scope="col">To Doctor</th>
		<th scope="col">Consultation Advise</th>
		
	
		
	</tr>
	<% 
	fromDoctor = "";
	fromDepartment = "";
	referralNote= "";
	toDoctor = "";
	consultationAdvice="";
fromDoctor = consultDoctorDt.getOpdPatientDetails().getEmployee().getFirstName();
if(consultDoctorDt.getOpdPatientDetails().getEmployee().getMiddleName()!=null && !consultDoctorDt.getOpdPatientDetails().getEmployee().getMiddleName().trim().equals(""))
{
	fromDoctor += " " + consultDoctorDt.getOpdPatientDetails().getEmployee().getMiddleName();
}
if(consultDoctorDt.getOpdPatientDetails().getEmployee().getLastName()!=null && !consultDoctorDt.getOpdPatientDetails().getEmployee().getLastName().trim().equals(""))
{
	fromDoctor += " " + consultDoctorDt.getOpdPatientDetails().getEmployee().getLastName();
}
if(consultDoctorDt.getConsultedDoctor()!=null )
{
	toDoctor = consultDoctorDt.getConsultedDoctor().getFirstName();
	if(consultDoctorDt.getConsultedDoctor().getMiddleName()!=null && !consultDoctorDt.getConsultedDoctor().getMiddleName().trim().equals(""))
	{
		toDoctor += " " + consultDoctorDt.getConsultedDoctor().getMiddleName();
	}
	if(consultDoctorDt.getConsultedDoctor().getLastName()!=null && !consultDoctorDt.getConsultedDoctor().getLastName().trim().equals(""))
	{
		toDoctor += " " + consultDoctorDt.getConsultedDoctor().getLastName();
	}
}
if(consultDoctorDt.getReferralNotes()!=null && !consultDoctorDt.getReferralNotes().trim().equals(""))
{
	referralNote = consultDoctorDt.getReferralNotes();
}
if(consultDoctorDt.getDoctorAdvice()!=null && !consultDoctorDt.getDoctorAdvice().trim().equals(""))
{
	consultationAdvice = consultDoctorDt.getDoctorAdvice();
}
%>

	<tr>
		<td><%=fromDoctor%></td>
		<td><%=referralNote%></td>
		<td><%=toDoctor%></td>
		<td><%=consultationAdvice%></td>
		
		
	</tr>
	
	
	
</table>
</div>
<div class="paddingTop15"></div>
<%
tCount++;}
	}%>
<input type="hidden" name="tCount" value="<%=tCount-1%>"/>	
<input type="hidden" name="tRow" value="<%=tRow-1%>"/>
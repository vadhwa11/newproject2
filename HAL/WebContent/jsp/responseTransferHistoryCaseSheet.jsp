<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.Transfer"%>
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
List<Transfer> transferList = new ArrayList<Transfer>();
if(map.get("transferList") != null)
{
	transferList=(List<Transfer>)map.get("transferList");
}
int tCount =1;
int tRow =0;
Date date = new Date();
int days = 0;
if(transferList.size() >0){
	String fromDepartment = "";
	String fromBed = "";
	String fromDoctor = "";	
	String toDepartment = "";
	String toBed = "";
	String toDoctor = "";
	String transferSummary="";
	for(Transfer transfer : transferList){
		tRow =1;
	
		
		
%>

<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="opdgrid">
	<tr>
		<th scope="col">From Ward</th>
		<th scope="col">From Bed</th>
		<th scope="col">From Doctor</th>
		<th scope="col">To Ward</th>
		<th scope="col">To Bed</th>
		<th scope="col">To Doctor</th>
		<th scope="col">Transfer Summary</th>
	
		
	</tr>
	<% 
	fromDepartment = "";
	fromBed = "";
	fromDoctor = "";	
	toDepartment = "";
	toBed = "";
	toDoctor = "";
	transferSummary="";
	
fromDepartment = transfer.getFromWard()!=null?transfer.getFromWard().getDepartmentName():"";
toDepartment = transfer.getToWard()!=null?transfer.getToWard().getDepartmentName():"";
fromBed = transfer.getFromBed()!=null?transfer.getFromBed().getBedNo():"";
toBed = transfer.getToBed()!=null?transfer.getToBed().getBedNo():"";
transferSummary = transfer.getTransferReason()!=null?transfer.getTransferReason():"";

if(transfer.getFromDoctor()!=null )
{
fromDoctor = transfer.getFromDoctor().getFirstName();
if(transfer.getFromDoctor().getMiddleName()!=null && !transfer.getFromDoctor().getMiddleName().trim().equals(""))
{
	fromDoctor += " " + transfer.getFromDoctor().getMiddleName();
}
if(transfer.getFromDoctor().getLastName()!=null && !transfer.getFromDoctor().getLastName().trim().equals(""))
{
	fromDoctor += " " + transfer.getFromDoctor().getLastName();
}
	}
if(transfer.getToDoctor()!=null )
{
	toDoctor = transfer.getToDoctor().getFirstName();
	if(transfer.getToDoctor().getMiddleName()!=null && !transfer.getToDoctor().getMiddleName().trim().equals(""))
	{
		toDoctor += " " + transfer.getToDoctor().getMiddleName();
	}
	if(transfer.getToDoctor().getLastName()!=null && !transfer.getToDoctor().getLastName().trim().equals(""))
	{
		toDoctor += " " + transfer.getToDoctor().getLastName();
	}
}

%>

	<tr>
		<td><%=fromDepartment%></td>
		<td><%=fromBed%></td>
		<td><%=fromDoctor%></td>
		<td><%=toDepartment%></td>
		<td><%=toBed%></td>
		<td><%=toDoctor%></td>
		<td><%=transferSummary%></td>
		
		
	</tr>
	
	
	
</table>
</div>
<div class="paddingTop15"></div>
<%
tCount++;}
	}%>
<input type="hidden" name="tCount" value="<%=tCount-1%>"/>	
<input type="hidden" name="tRow" value="<%=tRow-1%>"/>
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
<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
List<PatientPrescriptionHeader> prescripionList = new ArrayList<PatientPrescriptionHeader>();
if(map.get("prescripionList") != null)
{
	prescripionList=(List<PatientPrescriptionHeader>)map.get("prescripionList");
}
int tCount =1;
int tRow =0;
Date date = new Date();
int days = 0;
if(prescripionList.size() >0){

	for(PatientPrescriptionHeader prescriptionHeader : prescripionList){
		tRow =1;
		String str = "";
		 if(prescriptionHeader.getOtSurgery()!=null){
			str = (prescriptionHeader.getDepartment()!=null?prescriptionHeader.getDepartment().getDepartmentName():"") + "(OT)";
		}
		 else if(prescriptionHeader.getVisit()!=null){
			str = (prescriptionHeader.getDepartment()!=null?prescriptionHeader.getDepartment().getDepartmentName():"");
		}
		else if(prescriptionHeader.getInpatient()!=null){
			str = (prescriptionHeader.getDepartment()!=null?prescriptionHeader.getDepartment().getDepartmentName():"");
		}
		
		
%>
<h6><%= HMSUtil.convertDateToStringWithoutTime(prescriptionHeader.getPrescriptionDate())+" "+(prescriptionHeader.getPrescriptionTime())+" "+str%></h6>
<div class="small">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="opdgrid">
	<tr>
		<th scope="col">Nomenclature</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<!-- <th scope="col">Route</th> -->
		<th scope="col">Remarks</th>
<!-- 		<th scope="col">Repeat</th>
		<th scope="col">Stop</th> -->
	
		
	</tr>
	
	<%
	    
		if(prescriptionHeader.getPatientPrescriptionDetails()!=null){
		Set<PatientPrescriptionDetails> prescDetailsSet = prescriptionHeader.getPatientPrescriptionDetails();
		for(PatientPrescriptionDetails prescriptionDetails :prescDetailsSet){
	
	%>
	<tr>
		<td><%=prescriptionDetails.getItem().getNomenclature() %>(<%=prescriptionDetails.getItem().getId()%>)[<%=prescriptionDetails.getItem().getPvmsNo()%>]
	    <div id="ac2update1" style=" display:none; " class="autocomplete">
	    <input type="hidden" id="prevnomenclature<%=tCount%><%=tRow%>" value="<%=prescriptionDetails.getItem().getNomenclature() %>(<%=prescriptionDetails.getItem().getId()%>)[<%=prescriptionDetails.getItem().getPvmsNo()%>]"/></div>
	    <input type="hidden" id="pvmsNo<%=tCount%><%=tRow%>" value="<%=prescriptionDetails.getItem().getPvmsNo() %>"/></div>
	    
	    </td>
	   
		<td><%=prescriptionDetails.getDosage()!=null?prescriptionDetails.getDosage():"" %>
		<input type="hidden" id="prevdosage<%=tCount%><%=tRow%>" value="<%=prescriptionDetails.getDosage()!=null?prescriptionDetails.getDosage():"" %>"/></td>
		<td><%=prescriptionDetails.getFrequency()!=null?prescriptionDetails.getFrequency().getFrequencyName():""%>
		<input type="hidden" id="prevfrequency<%=tCount%><%=tRow%>" value="<%=prescriptionDetails.getFrequency()!=null?prescriptionDetails.getFrequency().getId():""%>"/>
		</td>

		<td><%=prescriptionDetails.getNoOfDays()!=null?prescriptionDetails.getNoOfDays():"" %>
		<input type="hidden" id="prevnoOfDays<%=tCount%><%=tRow%>" value="<%=prescriptionDetails.getNoOfDays()!=null?prescriptionDetails.getNoOfDays():"" %>"/>
		</td>
		<%-- <td><%=prescriptionDetails.getRoute()!=null?prescriptionDetails.getRoute():"" %>
		<input type="hidden" id="prevroute<%=tCount%><%=tRow%>" value="<%=prescriptionDetails.getRoute()!=null?prescriptionDetails.getRoute():"" %>"/></td> --%>
		<td><%=prescriptionDetails.getRemarks()!=null?prescriptionDetails.getRemarks():"" %>
		<input type="hidden" id="prevtreatRemarks<%=tCount%><%=tRow%>" value="<%=prescriptionDetails.getRemarks()!=null?prescriptionDetails.getRemarks():"" %>"/></td>
		<%-- <%
		days = HMSUtil.getNoOfDays(prescriptionDetails.getPrescription().getPrescriptionDate(), date);
		System.out.println("days"+days);
		if((prescriptionDetails.getNoOfDays()-days)==0 || (prescriptionDetails.getNoOfDays()-days)<0)
		{
			%>
			<td><input type="checkbox" name="repeat<%=tCount%><%=tRow%>" id="repeat<%=tCount%><%=tRow%>" onChange="repeatTreatment(<%=tCount%>, <%=tRow%>)"/></td>
			<%
		}
		else
		{
			%>
			<td><input type="checkbox" name="repeat<%=tCount%><%=tRow%>" disabled = "true" id="repeat<%=tCount%><%=tRow%>" onChange="repeatTreatment(<%=tCount%>, <%=tRow%>)"/></td>
			<%
		}
		%>
			
		<td><input type="checkbox" name="stop<%=tCount%><%=tRow%>" id="stop<%=tCount%><%=tRow%>" value="<%=prescriptionDetails.getId()%>"/></td>
		 --%>
		
	</tr>
	
	
	<% tRow++;}
		}%>
</table>
</div>
<div class="paddingTop15"></div>
<input type="hidden" name="tRow<%=tCount%>" value="<%=tRow-1%>"/>
<%
tCount++;}
	}%>
<input type="hidden" name="tCount" value="<%=tCount-1%>"/>	

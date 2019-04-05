<%@ page import ="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>


<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>

<%@page import="jkt.hms.masters.business.Patient"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>


<div class="clear"></div>

<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
List<MasEmployee> srEmployeeListGrid = new ArrayList<MasEmployee>();
if (map.get("srEmployeeListGrid") != null) {
	srEmployeeListGrid = (List<MasEmployee>) map.get("srEmployeeListGrid");
}
List<MasRelation> masRelationList = new ArrayList<MasRelation>();
if (map.get("masRelationList") != null) {
	masRelationList = (List<MasRelation>) map.get("masRelationList");
}
String selfRelationName="";
String selfRelationId="";
String sonRelationName="";
Properties propadt = new Properties();
URL resourcePathadt = Thread.currentThread().getContextClassLoader()
.getResource("adt.properties");

try {
	propadt.load(resourcePathadt.openStream());			 
	selfRelationName=propadt.getProperty("selfRelationName");
	sonRelationName=propadt.getProperty("sonRelationName");
} catch (Exception e) {
	e.printStackTrace();
}

for(MasRelation ms : masRelationList)
{
	if(selfRelationName.trim().equals(ms.getRelationName().trim()))
	{
		selfRelationId = ms.getId().toString();
	}
}

%>

<%

	int cnt = 0;
	if(srEmployeeListGrid.size() > 0){
		
	
%>

<h4>Details</h4>
<div id="reg">
<input type="hidden" value="<%=selfRelationId%>" name="reltnId" id="reltnId"/>
<input type="hidden" value="<%=srEmployeeListGrid.get(0)!=null?srEmployeeListGrid.get(0).getGender().getAdministrativeSexName():""%>"  id="sex"/>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Name</th>
		<th scope="col">Relation</th>	
		<th scope="col">DOB</th>				
		<th scope="col">Gender</th>	
		<th scope="col">Division</th>
		<th scope="col">Employee Type</th>		

	</tr>
	<%
	if(srEmployeeListGrid.size()>0)
	{
	for(MasEmployee  emp : srEmployeeListGrid)
	{
		
		String patientName = "";
		if (emp.getFirstName() != null) {
			patientName = emp.getFirstName();
		}

		if (emp.getMiddleName() != null) {
			patientName = patientName + " "
					+ emp.getMiddleName();
		}
		if (emp.getLastName() != null) {
			patientName = patientName + " "
					+ emp.getLastName();
		}
	%>
	<%-- <tr
		onclick="getPatientDetails('/hms/hms/registration?method=getPatientDetails&cnt=<%=cnt %>');"> --%>
		<tr id="selfRow"
			onclick="if(checkStatusEmp('<%=emp.getEmployeeStatus().getEmpStatusName()%>','<%=emp.getEmployeeStatus().getEmpStatusCode()%>', '<%=emp.getContractDate()%>', '<%=emp.getExtensionDate()%>')){changerel('<%=srEmployeeListGrid.get(0).getGender().getAdministrativeSexName()%>',<%=selfRelationId%>, '/hms/hms/personnel?method=displayImage&amp;employeeId=<%=emp.getId()%>');}">
		<td><%= patientName%></td>	
		<td><%=selfRelationName%></td>		
		<td><%=emp.getDateOfBirth() != null ? HMSUtil.convertDateToStringWithoutTime(emp.getDateOfBirth()) : ""	%> </td>					
		<td><%=emp.getGender().getAdministrativeSexName() %></td>	
		<td><%=emp.getDivision().getDivisionName() %></td>
		<td><%=emp.getEmployeeType().getEmployeeTypeName() %></td>		
			
	</tr>
	<% cnt++;}
	}
	
	if(srEmployeeListGrid.get(0).getMasEmployeeDependents().size() > 0){
		boolean sonFlag=true;
		for(MasEmployeeDependent  empdep : srEmployeeListGrid.get(0).getMasEmployeeDependents())
		{
			sonFlag=true;
			if(empdep.getRelation().getRelationName().trim().equals(sonRelationName))
			{
				if(empdep.getDateOfBirth()!=null && HMSUtil.calculateAgeInYears(empdep.getDateOfBirth())<25)
				{
					sonFlag=true;
				}
				else
				{
					sonFlag=false;
				}
			}
			else
			{
				sonFlag = true;
			}
			if(sonFlag)
			{
			if(empdep.getStatus().equalsIgnoreCase("y")){
			String patientName = "";
			if (empdep.getEmployeeDependentFName() != null) {
				patientName = empdep.getEmployeeDependentFName();
			}

			if (empdep.getEmployeeDependentMName() != null) {
				patientName = patientName + " "
						+ empdep.getEmployeeDependentMName();
			}
			if (empdep.getEmployeeDependentLName() != null) {
				patientName = patientName + " "
						+ empdep.getEmployeeDependentLName();
			}
			%>
			<%-- <tr
			onclick="getPatientDetails('/hms/hms/registration?method=getPatientDetails&cnt=<%=cnt %>');"> --%>
			<tr
			onclick="if(checkStatusDependent('<%=empdep.getEmployee().getEmployeeStatus().getEmpStatusName()%>','<%=empdep.getEmployee().getEmployeeStatus().getEmpStatusCode()%>', '<%=empdep.getEmployee().getContractDate()%>', '<%=empdep.getEmployee().getExtensionDate()%>')){changerel('<%=empdep.getGender().getAdministrativeSexName()%>',<%=empdep.getRelation().getId()%>, '/hms/hms/personnel?method=displayImageEmployeeDependent&amp;employeeDependentId=<%=empdep.getId()%>');}">
			<td><%= patientName%></td>	
			<td><%=empdep.getRelation().getNewRelationName() %></td>		
			<td><%=empdep.getDateOfBirth() != null ? HMSUtil.convertDateToStringWithoutTime(empdep.getDateOfBirth()) : ""	%></td>					
			<td><%=empdep.getGender().getAdministrativeSexName() %></td>	
			<td><%=empdep.getEmployee().getDivision().getDivisionName() %></td>
			<td><%=empdep.getEmployee().getEmployeeType().getEmployeeTypeName() %></td>			
				
		</tr>
		<%cnt++;
		}}
		}
		
	
	}
	
	%>
</table>
<script type="text/javascript">

displayPatientInfoHALForFAC(<%=selfRelationId%>);
document.getElementById("reltnId").value= <%=selfRelationId%>;
	
</script>
</div>
<% 

}
else
	{
		%>
		<h3 style="text-align: center;color:red;">No Record Found</h3>
		<%
	}%>


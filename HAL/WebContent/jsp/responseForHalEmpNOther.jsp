<%@ page import ="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>


<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>

<%@page import="jkt.hms.masters.business.Patient"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script>jQuery.noConflict();</script>
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

List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
if (map.get("sexList") != null) {
	sexList = (List<MasAdministrativeSex>) map.get("sexList");
}
String  otherPatient =null;
if (map.get("otherPatient") != null) {
	otherPatient = (String) map.get("otherPatient");
}
String selfRelationName="";
String sonRelationName="";
String selfRelationId="";
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
				onclick="if(checkStatusEmp('<%=emp.getEmployeeStatus().getEmpStatusName()%>','<%=emp.getEmployeeStatus().getEmpStatusCode()%>', '<%=emp.getContractDate()%>', '<%=emp.getExtensionDate()%>')){submitProtoAjaxWithDivName('visitEmployee','/hms/hms/opd?method=getServiceNoDetailsForRegHAL1&relationId=<%=selfRelationId%>','depenedentDiv');}">
			<td><%= patientName%></td>	
			<td><%=selfRelationName%></td>		
			<td><%=emp.getDateOfBirth() != null ? HMSUtil.convertDateToStringWithoutTime(emp.getDateOfBirth()) : ""	%> </td>					
			<td><%=emp.getGender().getAdministrativeSexName() %></td>	
			<td><%=emp.getDivision().getDivisionName() %></td>
			<td><%=emp.getEmployeeType().getEmployeeTypeName() %></td>		
				
		</tr>
		<% cnt++;}
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
				onclick="if(checkStatusDependent('<%=empdep.getEmployee().getEmployeeStatus().getEmpStatusName()%>','<%=empdep.getEmployee().getEmployeeStatus().getEmpStatusCode()%>', '<%=empdep.getEmployee().getContractDate()%>', '<%=empdep.getEmployee().getExtensionDate()%>')){submitProtoAjaxWithDivName('visitEmployee','/hms/hms/opd?method=getServiceNoDetailsForRegHAL1&relationId=<%=empdep.getRelation().getId()%>','depenedentDiv');}">
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

	displayPatientInfoHAL(<%=selfRelationId%>);
	document.getElementById("reltnId").value= <%=selfRelationId%>;
		
	</script>
	</div>
	<% 

	}
	

	else if(otherPatient!=null && otherPatient.equalsIgnoreCase("y")){
%>	
 <div class="Block">

 
 <h4>Fill patient details</h4>
 <label>First Name<span>*</span></label> 
<input id="pFirstName" type="text" name="<%=P_FIRST_NAME %>" value="" tabindex="1"	validate="Patient First Name,string,yes" MAXLENGTH="15" /> 

<label>Middle Name</label> 
<input	id="sMNameId" type="text" name="<%=P_MIDDLE_NAME%>" value=""	tabindex="1" validate="Patient Middle Name,string,no"	MAXLENGTH="15" />

<label>Last Name</label> 
<input id="sLNameId" type="text"	name="<%=P_LAST_NAME %>" value="" tabindex="1"	validate="Patient Last Name,string,no" MAXLENGTH="15"	/>
 	
 	<label> Gender <span>*</span></label>
<select name="<%=GENDER%>" id="<%=GENDER%>" validate="Service Person Gender,metachar,yes" tabindex="1">
<option value="">Select</option>
	<%
		   	 	for(MasAdministrativeSex masAdministrativeSex : sexList){
			%>
	<option value="<%=masAdministrativeSex.getId()%>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
		   	 <%} %>
</select> 
 	<label>DOB<span>*</span></label> 
<input type="text" id="<%=DOB%>" name="<%=DOB%>"	tabindex="1" value="" validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"		onblur="validateExpDate(this,'<%=DOB%>');" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" 	border="0" validate="Pick a date" class="calender"	onClick="setdate('',<%=DOB%>,event)" />
 	
 <!-- <input type="button" name="Reset" value="Submitgg" class="button" tabindex="1" onClick="submitProtoAjaxWithDivName('otherPatientDetails','/hms/hms/registration?method=getServiceNoffDetailsFromHIC','depenedentDiv1');"/> -->
  <input  type="button" value="Submit" class="button" onclick=" if(validateOtherPatient()){submitProtoAjaxWithDivName('visitEmployee','/hms/hms/opd?method=getServiceNoDetailsForRegHAL1&otherPatient=y','depenedentDiv');}" />
 
<%if(otherPatient!=null){ %>
<input type="hidden" value="<%=otherPatient%>" name="otherPatient" id="otherPatient"/>
<%} %>
</div> 	
<%}
	else
	{
		%>
		<h3 style="text-align: center;color:red;">No Record Found</h3>
		<%
	}%>

<input type="hidden" value="" name="hinNoId" id="hinNoId"/>
<input type="hidden" value="" name="pFirstNameId" id="pFirstNameId"/>
<input type="hidden" value="" name="pMiddleNameId" id="pMiddleNameId"/>
<input type="hidden" value="" name="pLastNameId" id="pLastNameId"/>
<input type="hidden" value="" name="gender" id="gender"/>
<input type="hidden" value="" name="dobId" id="dobId"/>
<input type="hidden" value="" name="bldGrp" id="bldGrp"/>
<input type="hidden" value="" name="bloodGroupId" id="bloodGroupId"/>
<input type="hidden" value="visitNo" name="" id="visitNo"/>
<input type="hidden" value="familyHistory" name="" id="familyHistory"/>
<input type="hidden" value="visitEmployee" name="" id="visitEmployee"/>


<input type="hidden" id="hinNoDivId"/>
<script>

</script>


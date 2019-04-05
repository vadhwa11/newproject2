
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseUnitValidate.jsp  
 * Purpose of the JSP -  This is for Country Details.
 * @author  
 * @author  
 * Create Date: 12th september,2008 
 * Revision Date:      
 * Revision By: 
 * @version   
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<%
	Map map = new HashMap();
    Box box = HMSUtil.getBox(request);
  List<MasUnit> masUnitList = new ArrayList<MasUnit>();
  List<Patient> patientList= new ArrayList<Patient>();
  List<Inpatient> inPatientList= new ArrayList<Inpatient>();
  List<MasUnit> allUnitList = new ArrayList<MasUnit>();
  List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
  
    if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("unitList") != null)	{
		masUnitList = (List<MasUnit>)map.get("unitList");
	}
	if(map.get("patientDetailsList") != null)	{
		patientList = (List<Patient>)map.get("patientDetailsList");
	}
	if(map.get("inPatientList") != null)	{
		inPatientList = (List<Inpatient>)map.get("inPatientList");
	} 
	if(map.get("allUnitList") != null)	{
		allUnitList = (List<MasUnit>)map.get("allUnitList");
	}
	if(map.get("employeeList") != null)	{
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
 System.out.println("list data in jsp:::::::"+masUnitList.size());
	if(masUnitList.size() > 0 ){
		MasUnit masUnit=masUnitList.get(0);
%>
<div class="clear"></div>

<div class="Block">
<label class=""> Unit Name </label> 
<input id="unitName" type="text" name="unitName" class="large" value="<%= masUnit.getUnitName()%>" validate="Unit Name,string,no" maxlength="30" /> 
<input type="hidden" name="unitCode" value="<%=masUnit.getId()%>" id="unitCode" /> 
<label class=""> Unit Address </label> 
<input id="unitAddress" type="text" class="large2" name="unitAddress" value="<%= masUnit.getUnitAddress()%>" validate="Unit Name,string,no" maxlength="50" />

<div class="clear"></div>

<label>Local Unit </label> <% if(masUnit.getLocalUnit().equals("n")){ %>
<input type="checkbox" class="radio" id="localUnit" name="localUnit" />

<%}else {%>
<input type="checkbox" class="radio" id="localUnit" name="localUnit" checked="true" /> <%} %>

<div class="clear"></div>

<label> New Unit Name </label> 
<select id="newUnitId" class="large" name="newUnitId" onchange="displayUnitAddress(this.value);" onblur="displayUnitAddress(this.value);">
<option value="">Select Unit Name</option>
	<%
		  for (MasUnit unit :allUnitList) 
		  {
		 %>
<option value="<%=unit.getId()%>"><%=unit.getUnitName()%></option>
	<%
		  }
		 %>
</select> <IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26" style="cursor: pointer; float: left;" onClick="javascript:openPopupWindowForUnit();" title="Click here to Search ICD Codes"> 
<label> Unit Address </label> 
<input id="sUnitAddress" type="text" class="large2" name="unitAdd" value="" readonly="readonly" />

<div class="clear"></div>

<label> Local Unit </label> 
<input type="checkbox" class="radioAuto" id="sLocalUnit" name="sLocalUnit" readonly="readonly" /></div>
<div class="clear"></div>
<h4> Patient </h4>
<div class="tableHholderCmnLarge">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<%
  	int inc=1;
  	System.out.println("patientList.size  ===================="+patientList.size());
  	if (patientList != null && patientList.size() > 0){
  %>
	<thead>
		<tr>
			<th width="20%">Service No</th>
			<th width="40%" class="">Service Name</th>
			<th width="45%" class="">Admission No</th>
			<th width="10%" class=""></th>
		</tr>
	</thead>
	<tbody>
		<%
		 for (Patient patientdetails : patientList) {
	%>
		<tr id="" onmouseover="" onmouseout="" onclick="">
	
		<td height="12"><%=patientdetails.getServiceNo()%></td>
			<td height="12"><%=patientdetails.getSFirstName()+" "+ patientdetails.getSMiddleName()+" "+patientdetails.getSLastName()%></td>
			<td>
			<%
	 	
	 	for(Inpatient inpatientdetails :inPatientList){
			if(inpatientdetails.getHinNo().equals(patientdetails.getHinNo())){%>
			<%=inpatientdetails.getAdNo()%> <% 
		  }
	 	}	
	   %>
			</td>
			<td height="12"><input type="checkbox" class="checkbox"
				id="newLocalUnit<%=inc%>" name="newLocalUnit"
				value="<%=patientdetails.getId()%>" /></td>

		</tr>
		<%	inc++;}
		%>
<script>
		document.getElementById("chackLength").value =<%=inc-1%>
		 document.getElementById('deleteUnitId').style.display = 'none';
</script>
</tbody>

<%	}else{ %>
<tbody>
<tr>
<input type="hidden" id="newLocalUnit" name="newLocalUnit" value="" />

			<td height="16" colspan=6 align="center">No Data Found</td>
		</tr>

	</tbody>
<script>
	       document.getElementById('deleteUnitId').style.display = 'block';
</script>
	<%}%>
<input type="hidden" id="chackLength" name="chackLength" value="" />
<input type="hidden" id="counter" name="counter" value="<%=inc%>" />

</table>

</div>
<h4>Employee</h4>
<div class="tableHholderCmnLarge">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<%
  int i=1;
  System.out.println("patientList.size  ===================="+patientList.size());
  if (employeeList != null && employeeList.size() > 0){
  %>
	<thead>
		<tr>
			<th width="20%">Service No</th>
			<th width="40%" class="">Service Name</th>
			
			<th width="55%" class=""></th>
		</tr>
	</thead>
	<tbody>
		<%
		 for (MasEmployee masEmployee: employeeList) {
	%>
		<tr id="" onmouseover="" onmouseout="" onclick="">
			<td height="12"><%=masEmployee.getServiceNo()%></td>
			<td height="12"><%=masEmployee.getFirstName()+" "+ masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></td>
			
			<%
	 	
	 	//for(Inpatient inpatientdetails :inPatientList){
			//if(inpatientdetails.getHinNo().equals(patientdetails.getHinNo())){
			//inpatientdetails.getAdNo()
		// }
	 	//}	
	   %>
			<td height="12"><input type="checkbox" class="checkbox"
				id="newLocalUnitEmpAfmsf<%=i%>" name="newLocalUnitEmpAfmsf"
				value="<%=masEmployee.getId()%>" /></td>

		</tr>
		<%	i++;}
		%>
		<script>
		document.getElementById("chackLength").value =<%=i-1%>
		 document.getElementById('deleteUnitId').style.display = 'none';
		</script>
	</tbody>

	<%	}else{ %>
	<tbody>
		<tr>
			<input type="hidden" id="newLocalUnit" name="newLocalUnit" value="" />

			<td height="16" colspan=6 align="center">No Data Found</td>
		</tr>

	</tbody>
<script>
	       document.getElementById('deleteUnitId').style.display = 'block';
</script>
	<%}%>
<input type="hidden" id="chackLength" name="chackLength" value="" />
<input type="hidden" id="counter" name="counter" value="<%=i%>" />

</table>

</div>
<div class="clear"></div>
</div>
<% } %>
<div class="clear"></div>
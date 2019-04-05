<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForHinNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Ritu  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>


<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>


<%	
		Map map = new HashMap();
	List<PatientPrescriptionDetails>patientPresriptionDetailList = new ArrayList<PatientPrescriptionDetails>();
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("patientPresriptionDetailList") != null){
			patientPresriptionDetailList =(List<PatientPrescriptionDetails>)map.get("patientPresriptionDetailList");
		}
		if (map.get("frequencyList") != null){
			frequencyList =(List<MasFrequency>)map.get("frequencyList");
		}
		
  	   
%>
<table>
<tr>
			<th>Nomenclature</th>
			<th>Dosage</th>
			<th>Frequency</th>
			<th>No.OfDays</th>
			<th>Route</th>
			<th>1</th>
			<th>2</th>
			<th>3</th>
			<th>4</th>
			<th>5</th>
			<th>6</th>
			<th>7</th>
			<th>8</th>
			<th>9</th>
			<th>10</th>
			<th>11</th>
			<th>12</th>
			<th>Stop</th>

</tr>
<%
	if(patientPresriptionDetailList.size()>0){
		for(PatientPrescriptionDetails patientPrescriptionDetails :patientPresriptionDetailList){
	

%>

<tr>
	<%if(patientPrescriptionDetails.getItem() != null){ %>
		<td> <input type="text" value="<%=patientPrescriptionDetails.getItem().getNomenclature() %>" tabindex="1" id="nomenclature" size="30"  name="nomenclature"  /></td>
	<%} %>
	<% 
		if(patientPrescriptionDetails.getDosage() != null){
	%>
		<td><input type="text" name="dosage" tabindex="1" id="dosage" value="<%=patientPrescriptionDetails.getDosage() %>"	size="5" maxlength="5" /></td>
		<%}else{ %>
		<td><input type="text" name="dosage" tabindex="1" id="dosage" value=""	size="5" maxlength="5" /></td>
		<%} %>

<td><select name="frequency" id="frequency" tabindex="1" >
			<option value="0">Select</option>
		<%if(frequencyList.size()>0){
			for(MasFrequency frequency :frequencyList){
				if(patientPrescriptionDetails.getFrequency()!= null){
					if(patientPrescriptionDetails.getFrequency().getId().equals(frequency.getId())){
				
			%>
			<option value="<%=frequency.getId() %>" selected="selected"><%=frequency.getFrequencyName()%></option>
			<%}else{%>
			<option value="<%=frequency.getId() %>"><%=frequency.getFrequencyName()%></option>
			<%}}}} %>
		</select> 
		</td>
		<%if(patientPrescriptionDetails.getNoOfDays()!= null){ %>
		<td><input type="text" name="noOfDays" tabindex="1" id="noOfDays"  value="<%=patientPrescriptionDetails.getNoOfDays() %>"  size="3"	maxlength="3" validate="No Of Days,num,no" /></td>
		<%}else{ %>
		<td><input type="text" name="noOfDays" tabindex="1" id="noOfDays"   size="3"	maxlength="3" validate="No Of Days,num,no" /></td>
		<%} %>
	<%if(patientPrescriptionDetails.getRoute()!= null){ %>
		<td><input type="text" name="route" tabindex="1" id="route" value="<%=patientPrescriptionDetails.getRoute() %>" size="5" maxlength="20" validate="Route,string,no" /></td>
	<%}else{ %>
	  <td><input type="text" name="route" tabindex="1" id="route"  size="5" maxlength="20"	 validate="Route,string,no" /></td>
	  <%} %>
	

		<td><input type="checkbox" name="one" class="radio" id="one" value="y" /></td>
		
		<td><input type="checkbox" name="two" class="radio" disabled="disabled" id="two" value="y" /></td>
		<td><input type="checkbox" name="three" class="radio" disabled="disabled" id="three" value="y" /></td>
		<td><input type="checkbox" name="four" class="radio" disabled="disabled" id="four" value="y" /></td>
		<td><input type="checkbox" name="five" class="radio" disabled="disabled" id="five" value="y" /></td>
		<td><input type="checkbox" name="six" class="radio" disabled="disabled" id="six" value="y" /></td>
		<td><input type="checkbox" name="seven" class="radio" disabled="disabled" id="seven" value="y" /></td>
		<td><input type="checkbox" name="eight" class="radio" disabled="disabled" id="eight" value="y" /></td>
		<td><input type="checkbox" name="nine" class="radio" disabled="disabled" id="nine" value="y" /></td>
		<td><input type="checkbox" name="ten" class="radio" disabled="disabled" id="ten" value="y" /></td>
		<td><input type="checkbox" name="eleven" class="radio" disabled="disabled" id="eleven" value="y" /></td>
		<td><input type="checkbox" name="twelve" class="radio" disabled="disabled" id="twelve" value="y" /></td>
		<td><input type="checkbox" name="stop" class="radio" disabled="disabled" id="stop" value="y" /></td>



</tr>
<%}} %>
</table>
	
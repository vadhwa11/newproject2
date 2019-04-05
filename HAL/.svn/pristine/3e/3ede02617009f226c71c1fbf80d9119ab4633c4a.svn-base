<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForDischarge.jsp  
 * Purpose of the JSP -  This is for Response Discharge.
 * @author  Abha
* Create Date: 27th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<script>
 var flag;
</script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
	List<Patient> patientList = new ArrayList<Patient>();
	String choice="";
	String flag="";
	
	if(map.get("flag")!=null)
	{
	flag=(String)map.get("flag");
	}

	if(flag.equalsIgnoreCase("s"))
	{
	if(map.get("patientList")!=null)
	{
		patientList=(List)map.get("patientList");
	}
	}
	
	String adNo="";
	if(flag.equalsIgnoreCase("p"))
	{
	if(map.get("inPatientDetailList")!=null)
	{
		inPatientDetailList=(List)map.get("inPatientDetailList");
	}
	
	if(inPatientDetailList.size()>0)
	{
		adNo=inPatientDetailList.get(0).getAdNo();
	}
	}
	

%>

<div id=patient>
<%

if(flag.equalsIgnoreCase("s"))
{
%>
<label>Patient Name.</label> 
<select name="patientName" id="patientName" onchange="getAdNo(this.value);">
<option value="0">Select</option>
<%
				  	for (Patient patient : patientList) {
				%>

		<option value="<%=patient.getId()%>"><%=patient.getPFirstName() +" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"" )+ " " + (patient.getPLastName()!=null?patient.getPLastName():"") %></option>
		<% } %>


</select>


<%} %>
</div>




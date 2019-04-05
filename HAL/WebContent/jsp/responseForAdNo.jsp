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

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
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
	String flag1="";
	
	if(map.get("flag")!=null)
	{
	flag=(String)map.get("flag");
	}
	if(map.get("flag1")!=null)
	{
	flag1=(String)map.get("flag1");
	}
	if(flag.equalsIgnoreCase("s"))
	{
	if(map.get("patientList")!=null)
	{
		patientList=(List)map.get("patientList");
	}
	}
	
	String adNo="";
	if(flag.equalsIgnoreCase("w"))
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
	String discharge = "";
	if(map.get("discharge")!=null){
		discharge = (String)map.get("discharge");
	}

%>

<div id=patient>


<div id=adDiv>

<label>A&D No. <span>*</span></label> 
<select id="adNo" name="adNo" validate="A&D No.,String,yes">
<option value="">Select</option>
<%if(inPatientDetailList!=null && inPatientDetailList.size()>0){
	for (Iterator iterator = inPatientDetailList.iterator(); iterator.hasNext();) {
		Inpatient patient = (Inpatient)iterator.next();
%>
<option value="<%=patient.getId()%>"><%=patient.getAdNo()%></option>
<% }}%>
</select>
<div class="clear"></div>
</div>
</div>

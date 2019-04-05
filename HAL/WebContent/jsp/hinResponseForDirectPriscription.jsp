<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForAdmissionNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Admission Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Vivek  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>


<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<%	
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> hinList = new ArrayList<Patient>();
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		if (map.get("hinList") != null){
			hinList =(List<Patient>)map.get("hinList");
		}
		String serviceNo = "";
		if (map.get("serviceNo") != null){
			serviceNo =(String)map.get("serviceNo");
		}
%>
<div id="hinDiv">
<label>HIN</label>
<select name="<%=HIN_ID %>" validate="Hin No,yes" tabindex="1" onchange="getPatientDetails(this.value);">
	<option value="0">Select</option>
	<%
	for(Patient patient :hinList){
		String hinNoAndRelation="";
		String relation="";
		if(patient.getRelation()!=null){
			relation=patient.getRelation().getRelationName();
		}
		hinNoAndRelation=patient.getHinNo()+"-"+patient.getPFirstName()+" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"")+" "+(patient.getPLastName()!=null?patient.getPLastName():"")+ " ( "+relation+" )";
		%>
	<option value="<%=patient.getId()%>"><%=hinNoAndRelation%></option>
	<%}%>
</select>
</div>

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
		List<Patient> patientList = new ArrayList<Patient>();
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		if (map.get("patientList") != null){
			patientList =(List<Patient>)map.get("patientList");
		}
		String serviceNo = "";
		if (map.get("serviceNo") != null){
			serviceNo =(String)map.get("serviceNo");
		}
%>
<form name="confirmedCasesH1N1" method="post" action="">
<label>Service No:</label> <input
	type="text" id="serviceNo" name="<%=SERVICE_NO%>"
	title="Fill Service No. first." value="<%=serviceNo%>" MAXLENGTH="30"
	tabindex="1"/>
	<!-- onblur="submitProtoAjaxWithDivName('confirmedCasesH1N1','/hms/hms/sHO?method=getHinNoSHO&serviceNo='+this.value,'serviceAndHinDiv');"  -->
<label>Hin No : </label>
<select name="<%=HIN_ID %>" validate="Hin No,,yes" tabindex="2"
	onclick="submitProtoAjaxWithDivName('confirmedCasesH1N1','/hms/hms/sHO?method=confirmedCasesH1N1Response','deficientId');">
	<option value="">Select</option>
	<%for(Patient patient :patientList){
		String hinNoAndRelation="";
		String relation="";
		if(patient.getRelation()!=null){
			relation=patient.getRelation().getRelationName();
		}
		hinNoAndRelation=patient.getHinNo()+ " [ "+relation+" ]";
		%>
	<option value="<%=patient.getId()%>"><%=hinNoAndRelation%></option>
	<%}%>
</select>
</form>

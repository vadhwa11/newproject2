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
		Map map = new HashMap();
		List<Object> admissionNoList = new ArrayList<Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Patient> patientList = new ArrayList<Patient>();
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		String flag="";
		if(map.get("flag") != null)
		{
			flag=""+map.get("flag") ;
		}
		if (map.get("inpatientList") != null)
			inpatientList =(List<Inpatient>)map.get("inpatientList");
		if (map.get("patientList") != null)
			patientList =(List<Patient>)map.get("patientList");
%>
<%if(flag.equals("hin")){ %>
<label class="">Hin No : </label>
<select name="<%=HIN_ID %>" validate="Admission Number,,yes"
	onclick="submitProtoAjaxWithDivName('fatalDocumentPanchnamaReport','mis?method=getHinAdNoFatalPanchanama&flag=admission','testDiv');">
	<option value="">Select</option>
	<%for(Patient patient :patientList){ %>
	<option value="<%=patient.getId()%>"><%=patient.getHinNo()%></option>
	<%}%>
</select>
<%}else{ %>
<label class="">Ad No: </label>
<select name="<%=AD_NO%>" validate="Admission Number,,yes">
	<option value="">Select</option>
	<%for(Inpatient inpatient :inpatientList){ %>
	<option value="<%=inpatient.getId()%>"><%=inpatient.getAdNo()%>
	</option>
	<%} %>
</select>

<%} %>

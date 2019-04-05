<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForAdmissionNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Admission Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Ritu  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>


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



<script>
	<%  String condition = "";
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
List<Patient> patientList = new ArrayList<Patient>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("patientList") != null)
			patientList =(List<Patient>)map.get("patientList");
		
%>
<div id="hinDiv"><label>Hin: </label> <select
	name="<%=HIN_NO%>" id="hinNo" validate="Hin No,string,yes" onblur="ajaxFunctionForDonor(bloodDonationEntry);">
	<option value="">Select</option>
	<% 
	     	
	     	if (patientList!=null && patientList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = patientList.iterator(); iterator.hasNext();) {
	    				Patient patient = (Patient)iterator.next();
				%>
	<option value="<%=patient.getHinNo()%>"><%=patient.getHinNo()%>
	</option>
	<% } 
			} 
	     	 else
	     	 {
			 %>
	<script>
			 	document.getElementById('errorMsg').innerHTML=' No Record Found!!';
			 </script>
	<%
			  } 
	     	 %>
</select></div>
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registeredPatients.jsp  
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Priyanka
 * Create Date: 10th july,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<!--main content placeholder starts here-->
<script type="text/javascript">
<% 	int rowCount=0; %>
	function returnParent(rowCount)
	{
		if( document.getElementById("servicePersonName")!=null)
				window.opener.document.getElementById("servicePerson"+rowCount).value = document.getElementById("servicePersonName").value;
		if( document.getElementById("hinNo")!=null)
				window.opener.document.getElementById("hinNo"+rowCount).value = document.getElementById("hinNo").value;
		if( document.getElementById("patientName")!=null)
				window.opener.document.getElementById("patientName"+rowCount).value = document.getElementById("patientName").value;
		if( document.getElementById("sex")!=null)
				window.opener.document.getElementById("sex"+rowCount).value = document.getElementById("sex").value;
		if( document.getElementById("age")!=null)
				window.opener.document.getElementById("age"+rowCount).value = document.getElementById("age").value;
		if( document.getElementById("hinId")!=null)
				window.opener.document.getElementById("hinId"+rowCount).value = document.getElementById("parent").value;
		
		self.close();
	}
	function newPatient(rowCount)
	{
		if( document.getElementById("servicePersonName")!=null)
			window.opener.document.getElementById("servicePerson"+rowCount).value = document.getElementById("servicePersonName").value;
		
		window.opener.document.getElementById("hinNo"+rowCount).disabled = true;
		self.close();
	}
</script>
<div id="contentHolder">
<form name="registeredPatients" method="post" action="">


<div class="Clear"></div>

<%
			 	Box box=HMSUtil.getBox(request);
			 	boolean noRecordFound=false;
			 	
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 		
			 	List<Patient> registeredPatientList = new ArrayList<Patient>();
			 	List<AppSetup> appSetupList = new ArrayList<AppSetup>();
			 	int counter=0;
			 
			 	
				if (map.get("registeredPatientList") != null) {
					registeredPatientList = (List<Patient>) map.get("registeredPatientList");
			 		
			 	}
				if (map.get("rowCount") != null) {
					rowCount = (Integer)map.get("rowCount");
			 		
			 	}
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					noRecordFound=true;
					%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message %>
</div>
</div>

<%    
					   
					  }		 	
			 %> <input type="radio" id="hinNo" name="<%=SELECTED_RADIO %>"
	value="hinNo" />Hin No. <input type="radio" id="serviceNo"
	name="<%=SELECTED_RADIO %>" value="serviceNo" />Service No.

<div class="bottom">
<div class="Clear"></div>
<%
System.out.println("noRecordFound="+noRecordFound);
if(noRecordFound==false){ %> <input name="" type="button" class="button"
	value="Submit" onclick="returnParent(<%=rowCount%>);" /> <%} %> <input
	name="" type="button" class="button" value="Back"
	onclick="newPatient(<%=rowCount%>);" /></div>
<!--Bottom labels ends--></form>
</div>
<!--main content placeholder ends here-->
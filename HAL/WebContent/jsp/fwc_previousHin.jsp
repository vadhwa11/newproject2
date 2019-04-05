
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showPatientList.jsp  
 * Purpose of the JSP -  This is Show Patient List.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.15
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.SilDilStatus"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> -->
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<%
		Map map = new HashMap();
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		int visitNoForJsp=0;
		if(map.get("visitNoForJsp") != null){
			visitNoForJsp=(Integer)map.get("visitNoForJsp");
		}
		
	List patientPreviousVisitList = new ArrayList();
			
	if(map.get("patientPreviousVisitList") != null){
		patientPreviousVisitList=(List)map.get("patientPreviousVisitList");
	}	
	if(patientPreviousVisitList.size() > 0 ){
		Visit visitObj=(Visit)patientPreviousVisitList.get(0);
		Patient patientObj=visitObj.getHin();
		System.out.println("list of vist for the patient-----"+patientPreviousVisitList.size());
		String pName="";
		if(visitObj.getHin().getPFirstName()!= null){
			pName=visitObj.getHin().getPFirstName();
		}
		if(visitObj.getHin().getPMiddleName()!= null){
			pName=pName+" "+visitObj.getHin().getPMiddleName();
		}
		if(visitObj.getHin().getPLastName()!= null){
			pName=pName+" "+visitObj.getHin().getPLastName();
		}
		 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visitObj.getVisitDate());
		int deptId=visitObj.getDepartment().getId();
		MasAdministrativeSex masAdministrativeSexObj=patientObj.getSex();
	


%>


<div id="contentHolder">
<%if(visitObj.getDepartment()!= null){ %>
<h4><%=visitObj.getDepartment().getDepartmentName() %></h4>
<h6>Patient Previous Visit</h6>
<div class="Clear"></div>
<%} %>
<div class="Clear"></div>
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label>Service Type</label> <%if(visitObj.getHin().getServiceType()!= null){ %>
<label class="value"><%=visitObj.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Service No.</label>
<%if(visitObj.getHin().getServiceNo()!= null){ %> <label class="value"><%=visitObj.getHin().getServiceNo() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label> Service
Status </label> <%if(visitObj.getHin().getServiceStatus()!= null){ %> <label
	class="value"><%=visitObj.getHin().getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="Clear"></div>

<label>Relation</label> <%if(visitObj.getHin().getRelation() != null){ %>
<label class="value"><%=visitObj.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Rank</label> <%if(visitObj.getHin().getRank()!= null){ %>
<label class="value"><%=visitObj.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Name</label> <%if(pName != null){ %>
<label class="value"><%=pName %></label> <%}else{ %> <label class="value">-</label>
<%} %>
<div class="Clear"></div>

<label>Unit</label> <%if(visitObj.getHin().getUnit()!= null){ %> <label
	class="value"><%=visitObj.getHin().getUnit().getUnitName() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Unit Address</label> <% if(visitObj.getHin().getUnit()!= null){%>
<label class="value"><%=visitObj.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label>HIN No.</label> <%if(visitObj.getHin().getHinNo()!= null){ %> <label
	class="value"><%=visitObj.getHin().getHinNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Patient Name. </label> <%if(pName!= null){ %>
<label class="value"><%=pName %> </label> <%}else{ %> <label class="value">-
</label> <%} %> <label>Age</label> <%if(visitObj.getHin().getAge()!= null){ %> <label
	class="value"><%=visitObj.getHin().getAge() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>

<div class="Clear"></div>

<label>Sex </label> <%if(masAdministrativeSexObj != null){ %> <label
	class="value"><%=masAdministrativeSexObj.getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">-</label> <%} 
	
	
	%>
</div>



<jsp:include page="searchResultBlockForIPD.jsp" />


<form name="fwcPatientVisit" method="post" action=""><!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->
<div class="floatLeft">
<div
	style="width: auto; height: 400px; float: left; border: 1px solid #ffffff;">

<div class="navButtHeader">OPD</div>
<input name="patient fast history" type="button" class="navButtons"
	value="Appointments"> <input name="patient fast history3"
	type="button" class="navButtons" value="Investigation Appt."> <input
	name="patient fast history23" type="button" class="navButtons"
	value="Patient Allergic Drugs"> <input
	name="patient fast history22" type="button" class="navButtons"
	value="Admitted Patient"> <input name="patient fast history222"
	type="button" class="navButtons" value="Print Prescription"> <input
	name="patient fast history22" type="button" class="navButtons"
	value="Print Investigation"> <!-- <div><img src="/hms/jsp/images/ward_footer.jpg" width="172" height="1"></div> -->
</div>
</div>



<div id="test" class="wid">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.TOKEN_NO%>"], [3,"<%= RequestConstants.VISIT_NUMBER %>"], [4,"<%= RequestConstants.VISIT_DATE %>"],[5,"<%= RequestConstants.VISIT_TIME %>"],[6,"<%= RequestConstants.SERVICE_NO %>"],[7,"<%=RequestConstants.APPOINTMENT_TYPE%>"],[8,"<%= RequestConstants.PATIENT_NAME %>"],[9,"<%=RequestConstants.AGE%>"],[10,"<%=RequestConstants.SEX%>"],[11,"<%=RequestConstants.DIAGNOSIS_ID%>"] ];
	 statusTd =12;

</script></div>
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
</div>
<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = " "
		data_header[0][1] = "hide";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Token No"
		data_header[1][1] = "hide";
		data_header[1][2] = "8%";
		data_header[1][3] = "<%= RequestConstants.TOKEN_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Visit Number"
		data_header[2][1] = "data";
		data_header[2][2] = "10%";
		data_header[2][3] = "<%= RequestConstants.VISIT_NUMBER %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Visit Date"
		data_header[3][1] = "data";
		data_header[3][2] = "5%";
		data_header[3][3] = "<%=RequestConstants.VISIT_DATE %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Visit Time"
		data_header[4][1] = "data";
		data_header[4][2] = "6%";
		data_header[4][3] = "<%=RequestConstants.VISIT_TIME %>";
		
		data_header[5] = new Array;
		data_header[5][0] = "Service No"
		data_header[5][1] = "data";
		data_header[5][2] = "5%";
		data_header[5][3] = "<%=RequestConstants.SERVICE_NO %>";
		
		
		
		data_header[6] = new Array;
		data_header[6][0] = "Appointment Type"
		data_header[6][1] = "data";
		data_header[6][2] = "5%";
		data_header[6][3] = "<%=RequestConstants.APPOINTMENT_TYPE %>";
		
		data_header[7] = new Array;
		data_header[7][0] = "Patient Name"
		data_header[7][1] = "hide";
		data_header[7][2] = "10%";
		data_header[7][3] = "<%=RequestConstants.PATIENT_NAME %>";
		
		data_header[8] = new Array;
		data_header[8][0] = "Age"
		data_header[8][1] = "hide";
		data_header[8][2] = "6%";
		data_header[8][3] = "<%=RequestConstants.AGE %>";
		
		
		
		data_header[9] = new Array;
		data_header[9][0] = "Sex"
		data_header[9][1] = "hide";
		data_header[9][2] = "1%";
		data_header[9][3] = "<%=RequestConstants.SEX%>";
		
		data_header[10] = new Array;
		data_header[10][0] = "Diagnosis"
		data_header[10][1] = "data";
		data_header[10][2] = "10%";
		data_header[10][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";
		
		
		
		
		
		data_arr = new Array();
		
		<%
		int  i=0;
		try{
			String st="";
		
			Iterator iterator=patientPreviousVisitList.iterator();
		    
		          while(iterator.hasNext())
		           {   
		        	  Visit visit= (Visit) iterator.next();
		        	 
		        	  Patient patientHin=(Patient)visit.getHin();
		        	  MasDepartment deptObj=(MasDepartment)visit.getDepartment();
		        	  String patientName="";
		        	  if(visit.getHin().getPFirstName()!= null){
		        	   patientName=visit.getHin().getPFirstName();
	   	        	  }
					if(visit.getHin().getPMiddleName()!= null){
						patientName=patientName+" "+visit.getHin().getPMiddleName();
					}
					if(visit.getHin().getPLastName()!= null)
					{
						patientName=patientName+" "+visit.getHin().getPLastName();
					}
						
						
		        	  MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
		        	  String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		        	  
		        	  
		        	  
		        	  
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] =<%=visit.getId()%>
			
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%= visit.getId()%>" id="parent" />'
			
			<%
				if(visit.getTokenNo()!=null)
				{
			%>
			data_arr[<%= i%>][2] = "<%=visit.getTokenNo()%>"
			<%
				}else{
			%>
			data_arr[<%= i%>][2] = ""
			<%
				}
			   if(visit.getVisitNo()!=null)
			   {
			%>
			data_arr[<%= i%>][3]="<%=visit.getVisitNo()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][3]=""
			<%
				}
			   if(visit.getVisitDate()!= null )
			   {
			%>
			data_arr[<%= i%>][4] = "<%=visitDate%>"
			<%
			   }else{
			%> 
			data_arr[<%= i%>][4] = ""
			<%
			   }if(visit.getVisitTime()!= null || visit.getVisitTime()!= "")
			   {
			%>
			data_arr[<%= i%>][5] = "<%=visit.getVisitTime()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][5] = ""
			<%
			   }
			   if(visit.getHin().getServiceNo()!= null ||visit.getHin().getServiceNo() != "")
			   {
			%>
			data_arr[<%= i%>][6] = "<%=visit.getHin().getServiceNo()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][6] = ""
			<%
			   }
			   if(visit.getAppointmentType() != null || visit.getAppointmentType() !="")
			   {
			%>
			data_arr[<%= i%>][7] = "<%=visit.getAppointmentType()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][7] = ""
			
			<%
			  }
			   if(patientName!= null )
			   {
			%>
			data_arr[<%= i%>][8] = "<%=patientName%>"
			<%
			   }else{
			 %>
			 data_arr[<%= i%>][8] = ""
		    <%}
			   if(visit.getHin().getAge() != null)
			   {
			%>
			
			data_arr[<%= i%>][9] = "<%=visit.getHin().getAge()%>"
            <%
			   }else{
            %> 			
			data_arr[<%= i%>][9] = ""
		<%   }if(masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""){
		%>
			data_arr[<%= i%>][10] = "<%=masAdministrativeSex.getAdministrativeSexName()%>"
		<%
		  	}else{
		%>
			data_arr[<%= i%>][10] = ""
		<%}
		
			if(visit.getDiagnosis()!= null){
			
		%>
			data_arr[<%= i%>][11] = "<%=visit.getDiagnosis().getDiagnosisConclusionName()%>"
		<%
		  	}else{
		%>
			data_arr[<%= i%>][11] = ""
		<%}%>
		 
		<% 	
			i++;
		  }
		          
		}catch(Exception e){
		e.printStackTrace();	
	
		}
		%>
		 
		formName = "fwcPatientVisit"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeGridForPatient(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

<div class="bottom">

<div class="floatRight"><label><span>Total Patient
Visit</span> </label> <label class="value"><%= i%></label> <input type="hidden"
	name="counter" id="counter" value="<%=i %>" /> <input type="hidden"
	name="visitNoForJsp" id="visitNoForJsp" value="<%=visitNoForJsp%>" />


</div>
<% }else { %>
<form name="fwcPatientVisit" method="post" action=""><label
	style="font: bold 13px arial color : #000; font-weight: bold; color: red; float: right; text-align: center; font-size: 16px; width: 100%; height: 35px; margin-top: 44px;">
No Previous Visit For Patient </label> <% } %> <input name="Back" type="button"
	alt="Back" value="Back" class="button"
	onClick="submitForm('fwcPatientVisit','fwc?method=showSearchPatientPreviousVisit');"
	align="right" />
</div>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script></form>
</div>

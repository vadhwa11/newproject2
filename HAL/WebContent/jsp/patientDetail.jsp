<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * patientDetail.jsp  
 * Purpose of the JSP -  This is for Patient Details.
 * @author  Ritu
 * @author  Deepti
 * Create Date: 09th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>

<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>


<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<div id="contentspace">
<%	
	System.out.println("This is Detail JSP");
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		
		Set inPatientSet = new HashSet();
		try{
			inPatientSet=(Set)map.get("inPatientSet");
			System.out.println("patientList  in JSP "+inPatientSet.size());
			
		}catch(Exception e){
			System.out.println("In Deatail Jsp");
		}
		
				
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	
	%> <br />

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.ADMISSION_NUMBER%>"], [3,"<%= RequestConstants.PATIENT_NAME %>"], [4,"<%= RequestConstants.SERVICE_NUMBER %>"],[5,"<%= RequestConstants.AGE %>"],[6,"<%= RequestConstants.SEX %>"],[7,"<%=RequestConstants.PATIENT_DEPARTMENT%>"],[8,"<%= RequestConstants.PATIENT_DIAGNOSIS %>"],[9,"<%=RequestConstants.DATE_OF_ADMISSION%>"] ];
	 statusTd =9;

</script></div>
<br />
<form name="patientDetails" method="post" action=""><input
	type="button" class="button" value="Clinical Setup" align="left"
	onClick="submitForm('patientList','');" /> <br />
<input type="button" class="button" value="Clinical Details"
	align="left" onClick="submitForm('patientList','');" /> <br />
<input type="button" class="button" value="Food Testing" align="left"
	onClick="submitForm('patientList','');" /> <br />
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
</div>

<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "radio";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Admission No"
		data_header[1][1] = "data";
		data_header[1][2] = "5%";
		data_header[1][3] = "<%= RequestConstants.ADMISSION_NUMBER%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Patient Name"
		data_header[2][1] = "data";
		data_header[2][2] = "5%";
		data_header[2][3] = "<%= RequestConstants.PATIENT_NAME %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Service Number"
		data_header[3][1] = "data";
		data_header[3][2] = "5%";
		data_header[3][3] = "<%=RequestConstants.SERVICE_NUMBER %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Age"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=RequestConstants.AGE %>";
		
		data_header[5] = new Array;
		data_header[5][0] = "Sex"
		data_header[5][1] = "data";
		data_header[5][2] = "5%";
		data_header[5][3] = "<%=RequestConstants.SEX %>";
		
		
		
		data_header[6] = new Array;
		data_header[6][0] = "Ward Name"
		data_header[6][1] = "data";
		data_header[6][2] = "5%";
		data_header[6][3] = "<%=RequestConstants.PATIENT_DEPARTMENT %>";
		
		data_header[7] = new Array;
		data_header[7][0] = "Patient Diagnosis"
		data_header[7][1] = "data";
		data_header[7][2] = "5%";
		data_header[7][3] = "<%=RequestConstants.PATIENT_DIAGNOSIS %>";
		
		data_header[8] = new Array;
		data_header[8][0] = "Date Of Admission"
		data_header[8][1] = "data";
		data_header[8][2] = "5%";
		data_header[8][3] = "<%=RequestConstants.PATIENT_DIAGNOSIS %>";
		
		data_arr = new Array();
		
		<%
			String st="";
			Iterator itr=inPatientSet.iterator();
		    int  i=0;
		          while(itr.hasNext())
		           {           
		        	  Inpatient inpatient= (Inpatient) itr.next();
		        	  if(inpatient.getAdStatus().equalsIgnoreCase("A"))
		        	  {
		        	  Patient patientHin=(Patient)inpatient.getHin();
		        	  MasDepartment deptObj=(MasDepartment)inpatient.getDepartment();
		        	  MasDiagnosisConclusion masDiagnosisConclusion=(MasDiagnosisConclusion)inpatient.getDiagnosis();
		        	  MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
		        	  
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] =<%=patientHin.getId()%>
			
			data_arr[<%= i%>][1] = '<input type="radio"  name="parent" value="<%= patientHin.getId()%>" id="radio" />'
			
			<%
				if(inpatient.getAdNo()!=null || inpatient.getAdNo() !="")
				{
			%>
			data_arr[<%= i%>][2] = "<%=inpatient.getAdNo()%>"
			<%
				}else{
			%>
			data_arr[<%= i%>][2] = ""
			<%
				}
			   if(patientHin.getPFirstName()+patientHin.getPLastName()!= null || patientHin.getPFirstName()+patientHin.getPLastName()!="")
			   {
			%>
			data_arr[<%= i%>][3]="<%=patientHin.getPFirstName()+patientHin.getPMiddleName()+patientHin.getPLastName()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][3]=""
			<%
				}
			   if(patientHin.getServiceNo()!= null || patientHin.getServiceNo()!="")
			   {
			%>
			data_arr[<%= i%>][4] = "<%=patientHin.getServiceNo()%>"
			<%
			   }else{
			%> 
			data_arr[<%= i%>][4] = ""
			<%
			   }if(inpatient.getAge()!= null || inpatient.getAge()!= "")
			   {
			%>
			data_arr[<%= i%>][5] = "<%=inpatient.getAge()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][5] = ""
			<%
			   }
			   if(masAdministrativeSex.getAdministrativeSexName()!= null || masAdministrativeSex.getAdministrativeSexName() != "")
			   {
			%>
			data_arr[<%= i%>][6] = "<%=masAdministrativeSex.getAdministrativeSexName()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][6] = ""
			<%
			   }
			   if(deptObj.getDepartmentName() != null || deptObj.getDepartmentName() !="")
			   {
			%>
			data_arr[<%= i%>][7] = "<%=deptObj.getDepartmentName()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][7] = ""
			<%
			   }
			   if(masDiagnosisConclusion.getDiagnosisConclusionName() != null || masDiagnosisConclusion.getDiagnosisConclusionName()!= "")
			   {
			%>
			data_arr[<%= i%>][8] = "<%=masDiagnosisConclusion.getDiagnosisConclusionName()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][8] = ""
			<%
			   }
			   if(inpatient.getDateOfAddmission() != null)
			   {
			%>
			
			data_arr[<%= i%>][9] = "<%=inpatient.getDateOfAddmission()%>"
            <%
			   }else{
            %> 			
			data_arr[<%= i%>][9] = ""
			
				
		<% 
		  	}
			i++;
			}
		  }
		%>
		 
		formName = "patientDetails"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

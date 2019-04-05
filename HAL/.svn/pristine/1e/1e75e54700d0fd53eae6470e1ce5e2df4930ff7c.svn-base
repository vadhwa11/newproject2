<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * dischargePatientList.jsp  
 * Purpose of the JSP -  This is for Discharge Patient List.
 * @author  Vikas
 * @author  Deepali
 * Create Date: 11th Feb,2008 
 * Revision Date:      
 * Revision By:
 * @version 1.2  
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<%
	Map map = new HashMap();
    Set inPatientSet = new HashSet();
    
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		inPatientSet = (Set) map.get("inPatientSet");
	}
	System.out.println("Size of set (discharge) -------"+inPatientSet.size());
		

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>

<div id="contentspace">



<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>

		</td>
	</tr>
</table>

<div align="center">
<div class="page" style="width: 100%; text-align: left">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="search" action="" method="post">
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><input type="hidden"
			name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
			type="hidden" name="do" value="process" /> <input type="hidden"
			name="searchthread" value="1" /> <input type="hidden"
			name="showposts" value="1" /> <input type="hidden"
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">Service
		Number :</label> <input type="text"
			name="<%= RequestConstants.SERVICE_NUMBER %>" MAXLENGTH="30"
			/ tabindex=1 /> <label class="bodytextB_blue">Admission
		Number:</label> <select name="<%=RequestConstants.ADMISSION_NUMBER%>">
			<option value="0">Select</option>
			<%
				
				Iterator itr=inPatientSet.iterator();
			    while(itr.hasNext()){
			    	Inpatient inpatient= (Inpatient) itr.next();
			    	if(inpatient.getAdStatus().equalsIgnoreCase("D"))
			    	{
			%>

			<option value=<%=inpatient.getId()%>><%=inpatient.getAdNo()%></option>

			<%
				}
			  }	
			%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('search','discharge?method=');" /> <br />
		</td>
	</tr>

</table>
</form>
</div>
<br>
</div>
</div>
</div>
<%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
    %> <jsp:include page="searchResultBlock.jsp" />


<form name="patientList" method="post"><br />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.ADMISSION_NUMBER%>"], [3,"<%= RequestConstants.PATIENT_NAME %>"], [4,"<%= RequestConstants.SERVICE_NUMBER %>"],[5,"<%= RequestConstants.AGE %>"],[6,"<%= RequestConstants.SEX %>"],[7,"<%=RequestConstants.PATIENT_DEPARTMENT%>"],[8,"<%= RequestConstants.PATIENT_DIAGNOSIS %>"],[9,"<%=RequestConstants.DATE_OF_ADMISSION%>"] ];
	 statusTd =9;

</script> <!--  <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->

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
		data_header[1][2] = "8%";
		data_header[1][3] = "<%= RequestConstants.ADMISSION_NUMBER%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Patient Name"
		data_header[2][1] = "data";
		data_header[2][2] = "7%";
		data_header[2][3] = "<%= RequestConstants.PATIENT_NAME %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Service Number"
		data_header[3][1] = "data";
		data_header[3][2] = "5%";
		data_header[3][3] = "<%=RequestConstants.SERVICE_NUMBER %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Age"
		data_header[4][1] = "data";
		data_header[4][2] = "10%";
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
		data_header[8][2] = "6%";
		data_header[8][3] = "<%=RequestConstants.DATE_OF_ADMISSION %>";
		
		data_arr = new Array();
		
		<%
			String st="";
			Iterator iterator=inPatientSet.iterator();
		    int  i=0;
		          while(iterator.hasNext())
		           {           
		        	  Inpatient inpatient= (Inpatient) iterator.next();
		        	  if(inpatient.getAdStatus().equalsIgnoreCase("D"))
		        	  {
		        	  Patient patientHin=(Patient)inpatient.getHin();
		        	  MasDepartment deptObj=(MasDepartment)inpatient.getDepartment();
		        	  
		        	  //MasDiagnosisConclusion masDiagnosisConclusion=(MasDiagnosisConclusion)inpatient.getDiagnosis();
		        	  MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
		        	  
		        	  
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] =<%=patientHin.getId()%>
			
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%= inpatient.getId()%>" id="parent" />'
			
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
			   } %>

			data_arr[<%= i%>][8] = ""
			<%
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
		 
		formName = "patientList"
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script> <script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
</form>
</div>


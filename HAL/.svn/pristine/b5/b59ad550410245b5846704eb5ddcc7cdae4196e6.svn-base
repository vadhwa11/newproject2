<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * clinicalDetails.jsp  
 * Purpose of the JSP -  This is for Clinical Details
 * @author  Deepali
 * @author  Vikas
 * Create Date: 31st Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4  
--%>

<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />

<%	

	
	System.out.println("This is clinical details  JSP");
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		
		List inPatientDetailList = new ArrayList();
		
		
		
		try{
		
			
				
					inPatientDetailList=(List)session.getAttribute("inPatientDetailList");
					//clinicalDetailsList=(List)map.get("clinicalDetailList");
			
			System.out.println("inPatientDetailList  in JSP "+inPatientDetailList.size());
			
			
		}catch(Exception e){
			System.out.println("In Deatail Jsp"+e);
		}
		
		int ipdClinicalId=(Integer)map.get("ipdClinicalId");		
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	   String admissionNumber=null;
	   if(inPatientDetailList != null)
	   {
		   Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
		   int hinId=inPatientDetail.getHin().getId();
		   
	       String patientName=inPatientDetail.getHin().getPFirstName()+inPatientDetail.getHin().getPMiddleName()+inPatientDetail.getHin().getPLastName();
	       String consultantName=inPatientDetail.getDoctor().getFirstName()+inPatientDetail.getDoctor().getMiddleName()+inPatientDetail.getDoctor().getLastName();
	      admissionNumber=inPatientDetail.getAdNo();
	      MasDiagnosisConclusion masDiagnosisConclusion=(MasDiagnosisConclusion)inPatientDetail.getDiagnosis();
	%>
<br />
<%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
    %>
<div id=contentspace>
<form name="clinicalDetails" method="post" action="">
<div class="pateint_header"><label class="bodytextB">Pateint
Name:</label> <span class="intermidatespan"> <%= patientName %></span> <label
	class="bodytextB">Service No.:</label> <span class="intermidatespan">
<%=inPatientDetail.getHin().getServiceNo() %></span> <label class="bodytextB">Admission
No.:</label> <span class="intermidatespan"> <%=inPatientDetail.getAdNo() %></span>

<label class="bodytextB">Ward Name:</label> <span
	class="intermidatespan"> <%=inPatientDetail.getDepartment().getDepartmentName() %></span>
<br />
<br />
<label class="bodytextB">Age:</label> <span class="intermidatespan">
<%=inPatientDetail.getAge() %></span> <label class="bodytextB">Sex:</label> <span
	class="intermidatespan"> <%=inPatientDetail.getHin().getSex().getAdministrativeSexName() %></span>

<label class="bodytextB">Rank:</label> <span class="intermidatespan">
1212</span> <label class="bodytextB">Unit.:</label> <span
	class="intermidatespan"> 12345</span> <br />
<br />
<label class="bodytextB">Consultant:</label> <span
	class="intermidatespan"><%=consultantName %></span> <label
	class="bodytextB">Diagnosis:</label> <%
		if(masDiagnosisConclusion != null )
		{
		%> <span class="intermidatespan"><%=inPatientDetail.getDiagnosis().getDiagnosisConclusionName() %></span>
<%
		}else{
		%> <span class="intermidatespan"></span> <%	
		}
		%> <%
			}
		%>
</div>


<div id="searchbar">
<div class="panelbar">
<div class="paneltext"">Clinical Details</div>
</div>
</div>


<div>

<table border="0" cellpadding="1" cellspacing="1" class="grid_header"
	style="margin-left: 16px; width: 100%;">
	<tr>
		<td width="191" class="rowheader">Daily Entry Records</td>
		<td width="263" class="rowheader">Values</td>
		<td width="186" class="rowheader">Daily Entry Records</td>
		<td width="315" class="rowheader">Values</td>
	</tr>

	<tr>
		<td class="rowcolor">Fahrenheit Temperature</td>

		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="temperature" id=""
			validate="temperature,int,no" MAXLENGTH="3" /></td>
		<td class="rowcolor">Respiration</td>
		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="respiration"
			id="respiration" validate="respiration,int,no" value=""></td>
	</tr>

	<tr>
		<td class="rowcolor">Pulse</td>

		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="pulse" id=""
			validate="pulse,int,no" value=""></td>
		<td class="rowcolor">Blood Pressure</td>
		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="bloodPressure"
			id="bloodPressure" validate="bloodPressure,int,no" value=""></td>
	</tr>
	<tr>
		<td class="rowcolor">Input</td>

		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="input" id="" value="">
		</td>
		<td class="rowcolor">Output</td>
		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="output" id="output" value=""></td>
	</tr>

	<tr>
		<td class="rowcolor">Weight</td>
		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="weight" id="weight"
			validate="weight,int,no" value=""></td>
		<td class="rowcolor">(kgs)</td>
		<td class="rowcolor">&nbsp;</td>
	</tr>
	<tr>
		<td class="rowcolor">Treatment</td>
		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="treatment" id="treatment"
			value=""></td>
		<td class="rowcolor">&nbsp;</td>
		<td class="rowcolor">&nbsp;</td>
	</tr>


	<tr>
		<td class="rowheader">Intake/Output Chart</td>
		<td class="rowheader">Values</td>
		<td class="rowheader">Intake/Output Chart</td>
		<td class="rowheader">Values</td>
	</tr>

	<tr>
		<td class="rowcolor">PTR</td>

		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="ptr" id="" value="">
		</td>
		<td class="rowcolor">BP</td>
		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="bp" id="bp"
			validate="bp,int,no" value=""></td>
	</tr>

	<tr>
		<td class="rowcolor">Intake</td>

		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="intake" id="" value="">
		</td>
		<td class="rowcolor">IV</td>
		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="iv" id="iv" value=""></td>
	</tr>

	<tr>
		<td class="rowcolor">Oral</td>

		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="oral" id="" value="">
		</td>
		<td class="rowcolor">Urine</td>
		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="urine" id="urine" value=""></td>
	</tr>

	<tr>
		<td class="rowcolor">Stool</td>
		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="stool" id="stool" value=""></td>
		<td class="rowcolor">VOM/ASP</td>
		<td class="rowcolor"><input type="text" class="textboxward"
			style="border: 1px solid #8c8c8c;" name="vom" id="vom" value=""></td>
	</tr>
	<tr>
		<td height="24" class="rowcolor">Remarks</td>
		<td colspan="3" class="rowcolor"><input name="stool2" type="text"
			class="textboxwardbig" id="stool2" value="" size="123"></td>
	</tr>

</table>

<br />

<div style="margin-left: 20px;"><input type="button"
	class="button" value="Submit" align="left"
	onClick="submitForm('clinicalDetails','ipd?method=submitClinicalDetails');" />
<input type="button" class="button" value="Back" align="left"
	onClick="submitForm('clinicalDetails','ipd?method=showPatientListJsp');" />
<input type="hidden" name="ipdClinicalId" value="<%=ipdClinicalId %>" />
</div>
</form>


</div>

</div>

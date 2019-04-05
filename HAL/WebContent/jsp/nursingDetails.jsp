<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * nursingDetails.jsp  
 * Purpose of the JSP -  This is for Nursing Details.
 * @author  Vikas
 * @author  Deepali
 * Create Date: 31st Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.3
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

	
	System.out.println("This is Nursing Details  JSP");
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		
		List inPatientDetailList = new ArrayList();
		List clinicalDetailList= new ArrayList();
		
		
		try{
		
			if(map.get("takeSetFromSessionInJsp")!=null)
			{
				String takeSetFromSessionInJsp=(String)map.get("takeSetFromSessionInJsp");
				if(takeSetFromSessionInJsp.equals("false"))
				{
					clinicalDetailList=(List)map.get("clinicalDetailList");
				   session.setAttribute("clinicalDetailList",clinicalDetailList);
				}else{
					clinicalDetailList=(List) session.getAttribute("clinicalDetailList");
				}
			}
			
				
					inPatientDetailList=(List)session.getAttribute("inPatientDetailList");
					//clinicalDetailsList=(List)map.get("clinicalDetailList");
			
			
			
			
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
		  // System.out.println("hin Id of Inpatient----"+hinId);
	       String patientName=inPatientDetail.getHin().getPFirstName()+inPatientDetail.getHin().getPMiddleName()+inPatientDetail.getHin().getPLastName();
	       String consultantName=inPatientDetail.getDoctor().getFirstName()+inPatientDetail.getDoctor().getMiddleName()+inPatientDetail.getDoctor().getLastName();
	      admissionNumber=inPatientDetail.getAdNo();
	      session.setAttribute("admissionNumber",admissionNumber);
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
<form name="nursingDetails" method="post" action="">
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
		%> <br />
<%
			}
		%>
</div>


<div id="searchbar">
<div class="panelbar">
<div class="paneltext"">Nursing Care Details</div>
</div>
</div>
<br />

<div>

<table class="datatableWard">
	<tr>
		<td class="rowheader">Patient Care</td>
		<td class="rowheader">Status</td>
		<td class="rowheader">Remarks</td>
	</tr>
	<% 
						   		int i=0;
						   		if(clinicalDetailList!=null)
						   		{
						       		Iterator listIterator=clinicalDetailList.iterator();
			            			while (listIterator.hasNext()){
			            				 NursingcareSetup nursingCareSetupList=(NursingcareSetup) listIterator.next();
			            				 int id= nursingCareSetupList.getNursing().getId();
			             				 String careName= nursingCareSetupList.getNursing().getNursingName();
			             				
			             				
			                %>
	<tr>
		<td class="rowcolor"><%= careName%></td>

		<td class="rowcolor"><input type="checkbox" name="id<%=i%>"
			id="id<%=i %>" value="<%=careName %>"></td>
		<td class="rowcolor"><input type="text" name="remarks<%=i%>"
			id="remarks<%=i%>" value=""></td>
	</tr>
	<%
		       i++;
	             }
			    }
						   		
               %>
	<tr>
		<td class="rowcolor">Needle Pricked By</td>

		<td class="rowcolor"><input type="checkbox" name="needlePricked"
			value="Needle Pricked"></td>
		<td class="rowcolor"><input type="text" name="remarks">
		</td>
	</tr>

	<tr>
		<td class="rowcolor">SIL</td>

		<td class="rowcolor"><input type="radio" name="radioValue"
			value="SIL"></td>
		<td class="rowcolor"><input type="text" name="sil"></td>
	</tr>
	<tr>
		<td class="rowcolor">DIL</td>

		<td class="rowcolor"><input type="radio" name="radioValue"
			value="DIL"></td>
		<td class="rowcolor"><input type="text" name="dil"></td>
	</tr>
</table>
<br />
<br />

<input type="button" class="button" value="Submit" align="left"
	onClick="submitForm('nursingDetails','ipd?method=submitNursingDetails','validateCare');" />
<input type="button" class="button" value="Clinical Details"
	align="left"
	onClick="submitForm('nursingDetails','ipd?method=showClinicalDetailsJsp');" />
<input type="hidden" name="ipdClinicalId" value="<%=ipdClinicalId %>" />
<input type="hidden" name="counter" id="counter" value="<%=i %>" />
</form>
<script>

function validateCare(){
		var counter=document.getElementById('counter').value
		//alert(counter)
		
		for(var i = 0; i < counter; i++){
			//alert("i-- "+i)
			remVal = eval('document.nursingDetails.remarks' + i + '.value')
			//alert(remVal);
			//var cares=document.getElementById('id'+<%=i%>).value
			//alert(cares)
			 if(remVal != ""){
			 	careVal=eval('document.nursingDetails.id' + i + '.checked ')
			 	//alert(careVal)
	  			if(careVal == false){
	  			
            		alert("Please select the care.");
            		return false;      
          		}
       		}
  		}
		return true;
	
	}

</script></div>

</div>

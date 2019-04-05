<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * admissionByHinNo.jsp  
 * Purpose of the JSP -  
 * @author  Deepti
 * @author  Ritu
 * Create Date: 08th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.23  
--%>


<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasAdmissionType"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasDocument"%>
<%@page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.InpatientDocument"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasDelivery"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<script type="text/javascript">
function checkCancelAdmin(state){
if(state=="no")
{
alert("Can not cancel admission after One Hour...!")
return false
}else{
return  true
}
}
function checkConditionAdward(){
var ward = document.getElementById('adwardId').value
var adno = document.getElementById('adNo').value
var adDate = document.getElementById('adDate').value
   currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "-"
	if(month < 10){
	month = "0"+month;
	}
	if(day < 10){
	day = "0"+day;
	}
	var cDate = year + seperator + month + seperator + day;
	
	if(adDate != cDate)
 	{
	 alert("Adm Date is not equal to current date !!!");
		 for(var i=0;i<document.getElementById("wardId").length;i++)
	     {
		  if (document.getElementById("wardId").options[i].value==ward)
		  {
		 	document.getElementById("wardId").selectedIndex = i;
		  }
	     }
 	}
 	if(adDate == cDate){
 	
 	 var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	   var action = 'adt?method=checkTodayTransactions&adNo='+adno
	    var url= action 
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) 
	      	{
		   	    var item = items.childNodes[loop];
		        var st  = item.getElementsByTagName("status")[0];
		        var status = st.childNodes[0].nodeValue
		       if(status == "true"){
                alert("'"+adno+"'  transactions are done(SILDIL/Transfer/Discharge) \n you can not modify");
                for(var i=0;i<document.getElementById("wardId").length;i++)
	            {
		          if (document.getElementById("wardId").options[i].value==ward)
		          { 
		 	        document.getElementById("wardId").selectedIndex = i;
		          }
	            }
              }		   
	      }
	    }
	  }
 	}
 	
 	
}

//-->
</script>
<div id="contentHolder">
<h6>Update Patient Admission</h6>
<form name="updateAdmission" method="post">
<%
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	int bedId = 0;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> patientAdmissionMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<Inpatient> admissionDetailsList = new ArrayList<Inpatient>();
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasDiet> dietList = new ArrayList<MasDiet>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	List<MasIcd> diagnosisList = new ArrayList<MasIcd>();
	List<MasAdmissionType> admissionTypeList = new ArrayList<MasAdmissionType>();
	List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>();
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	List<MasDocument> documentList = new ArrayList<MasDocument>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	
	List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate"); 
	
	String currentTime = (String)utilMap.get("currentTime");
	List<InpatientDocument> inpatientDocumentList = new ArrayList<InpatientDocument>();
	
	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
	 SimpleDateFormat formatterOut = new  SimpleDateFormat("yyyy-MM-dd");
	 String date4Cancel=formatterOut.format(formatterIn.parse(currentDate));
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientAdmissionMap") != null){
		patientAdmissionMap = (Map<String,Object>)map.get("patientAdmissionMap");
	}
	
	if(patientAdmissionMap.get("admissionDetailsList") != null){
		admissionDetailsList = (List<Inpatient>)patientAdmissionMap.get("admissionDetailsList");
	}
	if(patientAdmissionMap.get("inpatientDocumentList") != null){
		inpatientDocumentList = (List<InpatientDocument>)patientAdmissionMap.get("inpatientDocumentList");
	}
	
	if(admissionDetailsList.size() > 0){
	
		Inpatient inpatient = admissionDetailsList.get(0);
		Patient patient = inpatient.getHin();
				
		if(map.get("employeeList") != null){
			employeeList = (List<MasEmployee>)map.get("employeeList");
		}
		if(map.get("dietList") != null){
			dietList = (List<MasDiet>)map.get("dietList");
		}
		if(map.get("bloodGroupList") != null){
			bloodGroupList = (List<MasBloodGroup>)map.get("bloodGroupList");
		}
		if(map.get("diagnosisList") != null){
			diagnosisList = (List<MasIcd>)map.get("diagnosisList");
		}
		if(map.get("admissionTypeList") != null){
			admissionTypeList = (List<MasAdmissionType>)map.get("admissionTypeList");
		}
		if(map.get("caseTypeList") != null){
			caseTypeList = (List<MasCaseType>)map.get("caseTypeList");
		}
		if(map.get("relationList") != null){
			relationList = (List<MasRelation>)map.get("relationList");
		}
		if(map.get("documentList") != null){
			documentList = (List<MasDocument>)map.get("documentList");
		}
		if(map.get("recordOfficeAddressList") != null){
			recordOfficeAddressList = (List<MasRecordOfficeAddress>)map.get("recordOfficeAddressList");
		}
		
		if(map.get("departmentList") != null){
			departmentList = (List<MasDepartment>)map.get("departmentList");
		}
		String cancelState="yes"; 
		boolean check =false;
		String adDateString =""+inpatient.getDateOfAddmission();
		String adTimeString =""+inpatient.getTimeOfAddmission();
		System.out.println("date4Cancel                  "+date4Cancel);
		System.out.println("adDateString                  "+adDateString);
	
		if(date4Cancel.equals(adDateString)){
			check =true;
		}
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String departmentTypeCodeForWard = properties.getProperty("departmentTypeCodeForWard");
         
		
%>
<div class="Clear"></div>
<input type="button" name="<%=CANCEL_ADMISSION%>" class="buttonbig"
	id="<%=CANCEL_ADMISSION%>" value="Cancel Admn" align="right"
	onclick="checkCancelAdmissionState('<%=inpatient.getId()%>','<%=inpatient.getAdNo()%>');">
<div class="Clear"></div>
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<%
	if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
	%> <label>Service No:</label> <label class="value"><%= patient.getServiceNo()%></label>
<%} %> <%
	if(patient.getServiceStatus() != null){
	%> <label>Service Status:</label> <label class="value"><%= patient.getServiceStatus().getServiceStatusName()%></label>
<%} %> <label>Service Type:</label> <label class="value"><%= patient.getServiceType().getServiceTypeName()%></label>
<div class="Clear"></div>

<%
	if(patient.getRelation() != null){
	%> <label>Relation:</label> <label class="value"><%= patient.getRelation().getRelationName()%></label>
<%} %> <%
	if(patient.getRank() != null){
	%> <label>Rank:</label> <label class="value"><%= patient.getRank().getRankName()%></label>
<%} %> <%
		if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
	 %> <label>Name:</label> <label class="value"><%= patient.getSFirstName()+" "+patient.getSMiddleName()+" "+patient.getSLastName()%></label>
<%} %> <%
		if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
	%>

<div class="Clear"></div>

<label> Unit:</label> <label class="value"><%= patient.getUnit().getUnitName()%></label>

<label> Unit Address:</label> <label class="value"><%= patient.getUnit().getUnitAddress()%></label>

<%if(inpatient.getAttachedUnit() != null){ %> <label>Attached
Unit:</label> <label class="value"><%=inpatient.getAttachedUnit()%> </label> <%}else{ %>
<label>Attached Unit:</label> <label class="value"> </label> <%}%>
<div class="Clear"></div>

<label>Tot Serv.(in yrs):</label> <%if(patient.getServiceYears() != null){ %>
<label class="value"><%=patient.getServiceYears() %> </label> <%}%> <label>AB
64 Available:</label> <%
		if(patient.getAb64Available().equals("y")){
	%> <input type="checkbox" class="radio" name="<%=AB_64_AVAILABLE %>"
	value="y" checked="checked"> <%}else{ %> <input type="checkbox"
	class="radio" name="<%=AB_64_AVAILABLE %>" value="y"> <%} 
	}%> <label>FRW Sl.No.:</label> <%if(inpatient.getFrwSlNo() != null){ %>
<label class="value"><%=inpatient.getFrwSlNo() %> </label> <%} %>
<div class="Clear"></div>

<label>Place Of Issue:</label> <%if(inpatient.getPlaceOfIssue() != null){ %>
<label class="value"><%=inpatient.getPlaceOfIssue() %> </label> <%} %> <label>FRW
Issued:</label> <%if(inpatient.getFrwIssued() != null){ %> <label class="value"><%=inpatient.getFrwIssued() %>
</label> <%} %> <%
	int bed_id=0;
	try
	{
		bed_id = inpatient.getBed().getId();
	}
	catch(Exception e)
	{
		bed_id = 0;
	}
	
	%> <input type="hidden" name="<%=BED_ID%>" id="bedId"
	value="<%=bed_id %>" /> <input type="radio" id="frwIssuedId"
	class="radio" name="<%=FRW_ISSUED %>" value="n"
	onclick="checkFRWIssued(this.value);"> 

<label>Trade:</label>
<%if(patient.getTrade().getStatus().equals("t")){   %>
<label class="value"><%=patient.getTrade().getTradeName() %></label>
<%}else if(patient.getTradeName()!=null && !patient.getTradeName().equals("")){  %>
<label class="value"><%=patient.getTradeName()%></label>
<%} %>

	<br />

<br />
</div>


<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>HIN No.:</label> <label
	class="value"><%=patient.getHinNo() %></label> <%
	if(patient.getSex() != null){
	%> <label>Sex:</label> <label class="value"><%=patient.getSex().getAdministrativeSexName() %></label>
<%} %> <%
	if(patient.getMaritalStatus() != null){
	%> <label>Marital Status:</label> <label class="value"><%=patient.getMaritalStatus().getMaritalStatusName() %></label>
<%} %>
<div class="Clear"></div>

<label>Patient Name:</label> <label class="value"><%= patient.getPFirstName()+" "+patient.getPMiddleName()+" "+patient.getPLastName()%></label>

<label>Age:</label> <label class="value"><%=inpatient.getAge()%></label>
<%
	if(patient.getReligion() != null){
	%> <label>Religion:</label> <label class="value"><%= patient.getReligion().getReligionName()%></label>
<%} %>
<div class="Clear"></div>

<%
	if(patient.getPatientDistrict() != null){
	%> <label>Patient Dist:</label> <label class="value"><%=patient.getPatientDistrict() %></label>
<%} %> <label>Adm Type :</label> <select name="<%=ADMISSION_TYPE_ID %>"
	validate="Admission Type,String,no">
	<option value="0">Select</option>
	<% 
		for (MasAdmissionType obj : admissionTypeList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getAdmissionTypeName()%></option>
	<% }%>
</select> <script type="text/javascript">
          	<%  if(inpatient.getAdmissionType()  != null){
			 			int admissionTypeId = inpatient.getAdmissionType().getId() ;
					%>
					document.updateAdmission.<%=ADMISSION_TYPE_ID%>.value = '<%=admissionTypeId %>';
               <%		
			 		}%>
           </script> <input type="hidden" id="adwardId" name="adwardId"
	value="<%=inpatient.getAdWardId().getId()%>"> <label>Adm
Ward:</label> <select name="<%=DEPARTMENT_ID %>" validate="Ward,String,yes"
	onchange="checkConditionAdward()" id="wardId">
	<option value="0">Select</option>
	<% 
	 		for (MasDepartment  masDepartment : departmentList){
				if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(departmentTypeCodeForWard)){
					if(inpatient.getAdWardId().getId() == masDepartment.getId()){
						
			%>
	<option value="<%=masDepartment.getId ()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%	}else{
		 %>
	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
	<%}}}%>
</select>

<div class="Clear"></div>

<label><font id="error">*</font>Adm Date: </label> <label class="value"><%=inpatient.getDateOfAddmission()%></label>
<input type="hidden" name="adNo" id="adNo"
	value="<%=inpatient.getAdNo()%>"> <input type="hidden"
	name="adDate" id="adDate" value="<%=inpatient.getDateOfAddmission()%>">

<label><font id="error">*</font>Adm Time: </label> <label class="value"><%=inpatient.getTimeOfAddmission()%></label>

<label><font id="error">*</font>Admitted By:</label> <select
	name="<%=CONSULTING_DOCTOR %>" validate="Admitted By,String,yes">
	<option value="0">Select</option>
	<% 
		for (MasEmployee  obj : employeeList){
			//if(obj.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
				String rankName ="";
				if(obj.getRank() != null){
					rankName = obj.getRank().getRankName();
				}
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getFirstName()+" "+obj.getMiddleName()+" "+obj.getLastName()%>
	<%=rankName %></option>
	<%  }%>
</select> <script type="text/javascript">
          	<%  if(inpatient.getDoctor()  != null){
			 			int doctorId = inpatient.getDoctor().getId() ;
					%>
					document.updateAdmission.<%=CONSULTING_DOCTOR%>.value = '<%=doctorId %>';
               <%		
			 		}%>
           </script>

<div class="Clear"></div>


<label> Blood Group:</label> <select name="<%=BLOOD_GROUP_ID %>"
	validate="Blood Group,String,no">
	<option value="0">Select</option>
	<% 
		for (MasBloodGroup  obj : bloodGroupList){
		%>
	<option value="<%=obj.getId ()%>"><%=obj.getBloodGroupName()%></option>
	<% 		}%>
</select> <script type="text/javascript">
          	<%  if(patient.getBloodGroup()  != null){
			 			int bloodGroupId = patient.getBloodGroup().getId() ;
					%>
					document.updateAdmission.<%=BLOOD_GROUP_ID%>.value = '<%=bloodGroupId %>';
               <%		
			 		}%>
           </script> <label><font id="error">*</font>Condition:</label> <label
	class="value"><%=inpatient.getPatientCondition()%></label> <label><font
	id="error">*</font>Condt. Status:</label> <label class="value"><%=inpatient.getConditionStatus()%></label>
<div class="Clear"></div>

<%
		if(inpatient.getListDate() != null){
	%> <label>List Date:</label> <label class="value"><%=inpatient.getListDate()%></label>
<%} %> <%
		if(inpatient.getListTime() != null){
	%> <label>List Time:</label> <label class="value"><%=inpatient.getListTime()%></label>
<%} %> <label><font id="error">*</font>Record Office With
Address:</label> <select name="<%=RECORD_OFFICE_ADDRESS_ID%>"
	validate="Record Office With Address,String,yes">
	<option value="0">Select</option>
	<% 
		for (MasRecordOfficeAddress  obj : recordOfficeAddressList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getAddress()%></option>
	<% }%>
</select> <script type="text/javascript">
          	<%  if(inpatient.getRecordOfficeAddress()  != null){
			 			int roAddId = inpatient.getRecordOfficeAddress().getId() ;
					%>
					document.updateAdmission.<%=RECORD_OFFICE_ADDRESS_ID%>.value = '<%=roAddId %>';
               <%		
			 		}else if(patient.getRecordOfficeAddress()  != null){
			 			int roAddId = patient.getRecordOfficeAddress().getId() ;
						%>
						document.updateAdmission.<%=RECORD_OFFICE_ADDRESS_ID%>.value = '<%=roAddId %>';
	               <%		
				 		}%>
           </script>
<div class="Clear"></div>

<label>Diagnosis :</label> <select name="<%=DIAGNOSIS_ID %>"
	validate="Diagnosis,String,no">
	<option value="0">Select</option>
	<% 
		for (MasIcd  obj : diagnosisList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getIcdName()%></option>
	<% }%>
</select> <script type="text/javascript">
          	<%  if(inpatient.getDiagnosis()  != null){
			 			int diagnosisId = inpatient.getDiagnosis().getId() ;
					%>
					document.updateAdmission.<%=DIAGNOSIS_ID%>.value = '<%=diagnosisId %>';
               <%		
			 		}%>
           </script> <label>Veg/Non-Veg:</label> <select name="<%=DIET_TYPE%>">
	<option value="0">Select</option>
	<option value="Veg">Veg</option>
	<option value="Non-Veg">Non-Veg</option>
</select> <script type="text/javascript">
          	<%  if(inpatient.getDietType()  != null){
			 			String dietType = inpatient.getDietType();
					%>
					document.updateAdmission.<%=DIET_TYPE%>.value = '<%=dietType %>';
               <%		
			 		}%>
	 </script> <label>Patient Diet:</label> <select name="<%=DIET_ID %>"
	validate="Diet,String,no">
	<option value="0">Select</option>
	<% 
		for (MasDiet  obj : dietList){
			//if(currentTime.substring(0,2).equals("00") || currentTime.substring(0,2).)	
		
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getDietName()%></option>
	<% }%>
</select> <script type="text/javascript">
          	<%  if(inpatient.getDiet()  != null){
			 			int  dietId = inpatient.getDiet().getId();
					%>
					document.updateAdmission.<%=DIET_ID%>.value = '<%=dietId %>';
               <%		
			 		}%>
	 </script>
<div class="Clear"></div>

<label>Document Initiated:</label> <select name="<%=DOCUMENT_ID%>"
	validate="Document Initiated,String,no" size="4" multiple="4"
	class="list">
	<option value="0">Select</option>
	<% 
		for (MasDocument  obj : documentList){
			String selectStr="";
		
		for (InpatientDocument  inpatientDocument : inpatientDocumentList){
			if((inpatient.getId()==inpatientDocument.getInpatient().getId())&&(obj.getId()==inpatientDocument.getDocument().getId())){
				selectStr="select";
	%>
	<option value="<%=obj.getId ()%>" selected="selected"><%=obj.getDocumentName()%></option>
	<%
	}}if(!selectStr.equals("select")){%>
	<option value="<%=obj.getId ()%>"><%=obj.getDocumentName()%></option>
	<%}	}%>


</select> <script type="text/javascript">
          	<%  if(inpatient.getDocument()  != null){
			 			int  documentId = inpatient.getDocument().getId();
					%>
					document.updateAdmission.<%=DOCUMENT_ID%>.value = '<%=documentId %>';
               <%		
			 		}%>
	 </script> <label><font id="error">*</font>Case Type:</label> <select
	id="caseId" name="<%=CASE_TYPE_ID %>" validate="Case Type,String,yes">
	<option value="0">Select</option>
	<% 
	 	for (MasCaseType obj : caseTypeList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getCaseTypeName()%></option>
	<% }%>
</select> <label>HSR Receipt No:</label> <%if(inpatient.getHsrReceiptNo() !=null){ %>
<input type="text" name="<%=HSR_RECEIPT_NO %>"
	validate="HSR Receipt No,string,no" maxlength="12"
	class="textbox_size20" value="<%=inpatient.getHsrReceiptNo() %>">
<%}else{ %> <input type="text" name="<%=HSR_RECEIPT_NO %>"
	validate="HSR Receipt No,string,no" maxlength="12"
	class="textbox_size20" value="1"> <%} %>
<div class="Clear"></div>

<label>HSR Amount:</label> <%if(inpatient.getHsrAmount() !=null){ %> <input
	type="text" name="<%=HSR_AMOUNT %>"
	validate="HSR Amount,floatWithoutSpaces,no" maxlength="7"
	class="textbox_size20" value="<%=inpatient.getHsrAmount()%>">
<%}else{ %> <input type="text" name="<%=HSR_AMOUNT %>"
	validate="HSR Amount,floatWithoutSpaces,no" maxlength="7"
	class="textbox_size20" value="<%=inpatient.getHsrAmount()%>"> <%} %> <script
	type="text/javascript">
          	<%  if(inpatient.getCaseType()  != null){
			 			int  caseTypeId = inpatient.getCaseType().getId();
					%>
					document.updateAdmission.<%=CASE_TYPE_ID%>.value = '<%=caseTypeId %>';
               <%		
			 		}%>
	 </script> <%
		if(inpatient.getMotherAdNo() != null){
		%> <label>Mother A & D No:</label> <label class="value"><%=inpatient.getMotherAdNo()%></label>
<%} %>
</div>

<br />

<div class="blockTitle">Next Of Kin Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>NOK Name:</label> <%
if(patient.getNextOfKinName() != null){

    %>

     <input type="text"
name="<%=NEXT_OF_KIN_NAME%>"value="<%=patient.getNextOfKinName()%>"
class="textbox_size20"

    validate="NOK Name,fullName,no" maxlength="30">

    <%}else{ %>

    <input      type="text" name="<%=NEXT_OF_KIN_NAME%>" value=""
class="textbox_size20" validate="NOK Name,fullName,no" maxlength="30">

<%} %>



<label>NOK Relation:</label> <select

    name="<%=NEXT_OF_KIN_RELATION_ID %>" validate="NOK
Relation,String,no">

    <option value="0">Select</option>



    <%

    if(relationList.size()>0){

    for (MasRelation  obj : relationList){

          %>

    <option value="<%=obj.getId()%>"><%=obj.getRelationName()%></option>

    <%    }

    }%>

</select> <script type="text/javascript">

          <%  if(patient.getNextOfKinRelation()  != null){

                                  int  relationId =
patient.getNextOfKinRelation().getId();

                            %>


document.updateAdmission.<%=NEXT_OF_KIN_RELATION_ID%>.value = '<%=relationId
%>';

             <%

                            }%>

     </script>

     <label>NOK Address:</label>

     <%               if(patient.getNextOfKinAddress() != null){  %>

  <textarea name="<%=NEXT_OF_KIN_ADDRESS %>" validate="Kin
Address,string,no"

    oninput="return checkMaxLengthMoz(this)" maxlength="500" /><%=
patient.getNextOfKinAddress() %></textarea>

    <%}else{ %>

    <textarea name="<%=NEXT_OF_KIN_ADDRESS %>" validate="Kin
Address,string,no"

    oninput="return checkMaxLengthMoz(this)"  maxlength="500"
/></textarea>

<%} %>
 
<div class="Clear"></div>

<label>NOK Phone:</label> <%
	if(patient.getNextOfKinPhoneNumber() != null){
	%> <input type="text" name="<%=NEXT_OF_KIN_PHONE_NO%>"
	value="<%=patient.getNextOfKinPhoneNumber()%>" class="textbox_size20"
	validate="NOK Phone No,phone,no" maxlength="16"> <%}else{ %> <input
	type="text" name="<%=NEXT_OF_KIN_PHONE_NO%>" value=""
	class="textbox_size20" validate="NOK Phone No,phone,no" maxlength="16">
<%} %> <%
		if(patient.getServiceCardValidityDate() != null){
	%> <label>I-Card Validity:</label> <label class="value"><%=patient.getServiceCardValidityDate() %></label>
<%} %> <%
		if(patient.getDependentCardIssueDate() != null){
	%> <label>D_O_I DCard:</label> <label class="value"><%=patient.getDependentCardIssueDate() %></label>
<%} 
		if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
	%> <label>I-Card Verified:</label> <%
		if(patient.getServiceCardStatus() != null){ 
			if(patient.getServiceCardStatus().equals("y")){
	%> <input type="checkbox" name="<%=I_CARD_VERIFIED %>"
	checked="checked" value="y" class="radio"> <%  	}else{%> <input
	type="checkbox" name="<%=I_CARD_VERIFIED %>" value="n" class="radio">
<%}
	  }
	}%>
<div class="Clear"></div>

<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>">
<input type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=inpatient.getId() %>"></div>

<div class="Clear"></div>
<div id="edited"></div>

<input type="button" name="Submit" value="Update" class="button"
	onClick="submitForm('updateAdmission','/hms/hms/adt?method=updateAdmissionInformation');" />
<input type="reset" name="Reset" value="Reset" class="button"
	onclick="location.reload();" accesskey="r" />
<div class="Clear"></div>

<% }else{%> No Records Found ! <%} %>

<div class="Clear"></div>
<div id="statusMessage" class="messagelabel"></div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=currentDate%></label> <label>Changed Time:</label> <label
	class="value"><%=currentTime%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /></div>

<div class="Clear"></div>


</form>
</div>

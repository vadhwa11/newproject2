<%--
 * Copyright 2012 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registeredPatients.jsp  
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Dinesh Dubey
 * Create Date: 10th feb,2012
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>

<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<!--main content placeholder starts here-->


<form name="viewDocumentsPopUp" method="post" enctype="multipart/form-data">
<h2>View DOCUMENT</h2>
<div class="Clear"></div>


<%
			 /** 	Box box=HMSUtil.getBox(request);
			 	
                String [] files =null;
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	boolean noRecordFound=false;
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 		
			 	List<Patient> registeredPatientList = new ArrayList<Patient>();
			 	int counter=0;
			 	if(map.get("patientList")!=null)
				{
					patientList=(List<UploadDocuments>)map.get("patientList");	
				} else	if(map.get("inpatientList")!=null)
				{
					patientList=(List<UploadDocuments>)map.get("inpatientList");	
				}
				if(map.get("files")!=null){
					files=(String[])map.get("files");
				}
				
				
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					noRecordFound=true;
				*/Map<String, Object> map = new HashMap<String, Object>();
			 	boolean noRecordFound=false;
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	String message="";
			 	if(map.get("message") != null){
					 message = (String)map.get("message");
			 	}
			 	Patient patient=null;
				if(map.get("patient")!=null)
				{
					patient=(Patient)map.get("patient");	
				}
				Visit visit=null;
				if(map.get("visit")!=null)
				{
					visit=(Visit)map.get("visit");	
				}
				List<MasMedicalUploadDocument> masMedicalUploadDocumentList=new ArrayList<MasMedicalUploadDocument>();
				if(map.get("masMedicalUploadDocumentList")!=null)
				{
					masMedicalUploadDocumentList=(List<MasMedicalUploadDocument>)map.get("masMedicalUploadDocumentList");	
				}
				String flagForm="";
				if(map.get("flagForm") !=null){
					flagForm=(String)map.get("flagForm");
				}
					%>


<h4><%=message %>
</h4>
<div class="clear"></div>
<%if(patient!=null ){ 

%> 

<div class="Block">
<label>Service No.</label>
 <input name="hinNo" type="text" value="<%=patient.getServiceNo()%>" readonly="readonly" />
<input name="hin" type="hidden" value="<%=patient.getId()%>" />
 <label>Name</label> 
 <% 
 String patientName="";
      if(patient.getPFirstName()!= null)
      {
		patientName=patient.getPFirstName();
	   }
		if(patient.getPMiddleName()!= null){
		patientName=patientName+" "+patient.getPMiddleName();
		}
		if(patient.getPLastName()!= null){
		patientName=patientName+" "+patient.getPLastName();
		}
 
 %>
 <%if(patient.getPFirstName()!=null){ %>
<input name="patientName" type="text" value="<%=patientName%>" readonly="readonly" />
<%}else{%>
 <input name="patientName" type="text" value="" readonly="readonly" />
  <%}%>
  <label>Relation </label>
 <%if(patient.getRelation() !=null){ %>
<input name="relation" type="text" value="<%=patient.getRelation().getRelationName() %>" readonly="readonly" />
	 <%}else { %>
<input name="relation" type="text" value="" readonly="readonly" />
 <%} %>
 <div class="Clear"></div>
 <label>Rank </label>
 <%if(patient.getRank() !=null){ %>
<input name="rank" type="text" value="<%=patient.getRank().getRankName() %>" readonly="readonly" />
	 <%}else { %>
<input name="rank" type="text" value="" readonly="readonly" />
 <%} %>
 
 <label>Rank </label>
 <%
	 String servicePersonName="";
		if(patient.getSFirstName()!= null){
			servicePersonName=patient.getSFirstName();
			}
			if(patient.getSMiddleName()!= null){
				servicePersonName=servicePersonName+" "+patient.getSMiddleName();
			}
			if(patient.getSLastName()!= null){
				servicePersonName=servicePersonName+" "+patient.getSLastName();
			}
 
 if(patient.getSFirstName() != null){
 %>
<input name="sFirstName" type="text" value="<%=servicePersonName %>" readonly="readonly" />
	 <%}else { %>
<input name="sFirstName" type="text" value="" readonly="readonly" />
 <%} %>
  <label>Unit</label>
   <%if(patient.getUnit()!=null){ %>
<input name="age" type="text" value="<%=patient.getUnit().getUnitName() %>" readonly="readonly" />
	 <%}else{%> 
<input name="age" type="text" value="" readonly="readonly" />
 <%} %>
 <div class="Clear"></div>
  <label>Age</label>
   <%if(patient.getAge()!=null){ %>
<input name="age" type="text" value="<%=patient.getAge() %>" readonly="readonly" />
	 <%}else{%> 
<input name="age" type="text" value="" readonly="readonly" />
 <%} %>


<label>Gender </label>
 <%if(patient.getSex()!=null){ %>
<input name="sex" type="text" value="<%=patient.getSex().getAdministrativeSexName() %>" readonly="readonly" />
	 <%}else { %>
 <input name="sex" type="text" value="" readonly="readonly" />
	 <%} %>
 
 <label>Medical Officer</label>
 <%
 String doctorName="";
	
 
 %>
<label class="value"><%=doctorName %></label>
</div>
	<%} %>
<!--Block Three Starts-->
<div class="clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">File</th>
		<th scope="col">Document</th>
		<th scope="col">Description</th>
	</tr>

	<%
	
	if(masMedicalUploadDocumentList!=null && masMedicalUploadDocumentList.size()>0 )
	{ 
	    int i=1;	
		for(MasMedicalUploadDocument masMedicalUploadDocument:masMedicalUploadDocumentList)
		{	
	%>
	<tr>
		<td><%=i %></td>
		
	    <td>
	    <%if(masMedicalUploadDocument.getFileName()!=null){ %>
	    <a
			href="#" onclick="parent.location='medicalExam?method=viewMedicalExamUploadDocument&filename=<%=masMedicalUploadDocument.getFileName()%>&fileExt=<%=masMedicalUploadDocument.getFileExtension() %>&folderName=<%=masMedicalUploadDocument.getFileFlag() %>&hinId=<%=masMedicalUploadDocument.getHin().getId() %>&medExamId=<%=masMedicalUploadDocument.getMasMedicalExamReport().getId() %>'">
		<%=masMedicalUploadDocument.getFileName()+"."+masMedicalUploadDocument.getFileExtension()%>
		</a>
		<%} %>
		</td>
		
		<td><img
			src="../upload/"
			alt="" width="50px" height="50px" /></td>
		<%if(masMedicalUploadDocument.getDescription()!=null){ %>
		<td><%=masMedicalUploadDocument.getDescription()%></td>
		<%}else{%>
		<td>-</td>
		<%} %>
	</tr>
	<%	i++;	}
		}else{
	%>
	<tr>
		<td colspan="4">No Record Found</td></tr>
	<%	}
		
	%>
</table>
</div>
<%if(flagForm.equalsIgnoreCase("appExam") || flagForm.equalsIgnoreCase("perExam")) {%>
<input name="Close" type="button" value="Close" class="button"	onclick="window.close();"/>
<%}else{ %>
<input name="" type="hidden" class="button" value="Back" onClick="history.back();" />
<input name="button" type="button"  class="button" value="Close" onClick="window.close();" />
<%} %>
</form>

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
			 	String folderName = "";
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
				System.out.println("masMedicalUploadDocumentList in showViewDocument==>>>"+map.get("masMedicalUploadDocumentList"));
				if(map.get("masMedicalUploadDocumentList")!=null)
				{
					masMedicalUploadDocumentList = (List<MasMedicalUploadDocument>)map.get("masMedicalUploadDocumentList");
					System.out.println("masMedicalUploadDocumentList in showViewDocument==>>>"+ masMedicalUploadDocumentList.size());
				}
				if(map.get("folderName")!=  null)

				  {
					folderName = (String)map.get("folderName");
				  }
					
				if(map.get("uploadId")!=  null)
				{
					int uploadId=0;
					uploadId = (Integer)map.get("uploadId");
				}
				
					%>


<h4><%=message %>
</h4>
<div class="clear"></div>
<%if(masMedicalUploadDocumentList!=null ){ 

%> 

<div class="Block">

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
	    <%if(masMedicalUploadDocument.getFileName()!=null){ 
	    %>
	   		
		<a
			href="/hms/hms/mis?method=viewShoUploadDocument&filename=<%=masMedicalUploadDocument.getFileName()%>&fileExt=<%=masMedicalUploadDocument.getFileExtension() %>&folderName=<%=masMedicalUploadDocument.getFileFlag() %>">
				
		<%=masMedicalUploadDocument.getFileName()+"."+masMedicalUploadDocument.getFileExtension()%>
		</a>
		
		<%} %>
		</td>
		
		<td>
		      <img	src="../upload/" alt="" width="150px" height="150px" />
		</td>
		<%if(masMedicalUploadDocument.getDescription()!=null)
		     { %>
		          <td><%=masMedicalUploadDocument.getDescription()%></td>
		     <%}
		else
		    {%>
		          <td>-</td>
		   <%} %>
	</tr>
	<%	i++;	}
		}else{
	%>
	<tr>
		<td colspan="4">No Record Found</td></tr>
	<%	}}
		
	%>
</table>
</div>
<input name="" type="button" class="button" value="Back" onClick="submitForm('viewDocumentsPopUp','/hms/hms/mis?method=displayFileUploadArea&folderName=<%=folderName %>');" />
</form>

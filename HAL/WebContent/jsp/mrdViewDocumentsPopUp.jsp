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
<%@page import="jkt.hms.masters.business.*"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<!--main content placeholder starts here-->

<div id="contentHolder">
<form name="viewDocumentsPopUp" method="post"
	enctype="multipart/form-data">

<h6>UPLOADED DOCUMENTS</h6>
<div class="Clear"></div>

<%
			 	Box box=HMSUtil.getBox(request);
			 	
			 	
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	List<UploadDocuments>patientList=new ArrayList<UploadDocuments>();
				List<UploadDocuments>inpatientList=new ArrayList<UploadDocuments>();
			 	boolean noRecordFound=false;
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 		
			 	List<Patient> registeredPatientList = new ArrayList<Patient>();
			 	int counter=0;
			 	if(map.get("patientList")!=null)
				{
					patientList=(List<UploadDocuments>)map.get("patientList");	
				}
				if(map.get("inpatientList")!=null)
				{
					inpatientList=(List<UploadDocuments>)map.get("inpatientList");	
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
			 %>




<div class="division"></div>


<!--Block Three Starts-->
<div class="division"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">Sr. No.</th>
		<th scope="col">Upload Date</th>
		<th scope="col">File Name</th>
		<th scope="col">Document</th>
		<th scope="col">Description</th>
	</tr>
	<%if(inpatientList!=null && inpatientList.size()>0){ 
		for(int i=0;i<inpatientList.size();i++){
	%>
	<tr>
		<td><%=i+1 %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(inpatientList.get(i).getUploadDate())%></td>
		<td><a
			href="mrd?method=viewPatientDocuments&filename=<%=inpatientList.get(i).getFileName()%>.<%=inpatientList.get(i).getFileExtension()%>"><%=inpatientList.get(i).getFileName()%>.<%=inpatientList.get(i).getFileExtension()%>
		</a></td>
		<td><img
			src="../upload//<%=inpatientList.get(i).getFileName()%>.<%=inpatientList.get(i).getFileExtension()%>"
			alt="/" width="50px" height="50px" /></td>
		<%if(inpatientList.get(i).getDescription()!=null){ %>
		<td><%=inpatientList.get(i).getDescription()%></td>
		<%}else{%>
		<td>-</td>
		<%} %>
	</tr>
	<%		}
		}
	%>
	<%if(patientList!=null && patientList.size()>0){ 
		for(int i=0;i<patientList.size();i++){
	%>
	<tr>
		<td><%=i+1 %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(patientList.get(i).getUploadDate())%></td>
		<td><a
			href="mrd?method=viewPatientDocuments&filename=<%=patientList.get(i).getFileName()%>.<%=patientList.get(i).getFileExtension()%>">
		<%=patientList.get(i).getFileName()%>.<%=patientList.get(i).getFileExtension()%>
		</a></td>
		<td><img
			src="../upload//<%=patientList.get(i).getFileName()%>.<%=patientList.get(i).getFileExtension()%>"
			alt="/" width="50px" height="50px" /></td>
		<%if(patientList.get(i).getDescription()!=null){ %>
		<td><%=patientList.get(i).getDescription()%></td>
		<%}else{%>
		<td>-</td>
		<%} %>
	</tr>
	<%		}
		}
	%>
</table>
</div>
<input name="" type="button" class="button" value="Back"
	onclick="self.close();" />
</div>
<!--Bottom labels ends-->
</form>
</div>
<!--main content placeholder ends here-->
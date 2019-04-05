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

<!--main content placeholder starts here-->

<div id="contentHolder">
<form name="viewDocumentsPopUp" method="post"
	enctype="multipart/form-data">
<div class="titleBg"><h2>View DOCUMENT</h2></div>
<div class="Clear"></div>

<%
			 	Box box=HMSUtil.getBox(request);
			 	
                String [] files =null;
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
				} else	if(map.get("inpatientList")!=null)
				{
					patientList=(List<UploadDocuments>)map.get("inpatientList");	
				}
				if(map.get("files")!=null){
					files=(String[])map.get("files");
				}
				
				int visitId= box.getInt("visitId");
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					noRecordFound=true;
					%>
<h4><%=message %>
</h4>


<%    
					   
					  }		 	
			 %>




<div class="division"></div>

<input type="hidden" name="flag" value="view" id="flag">
<%if(patientList!=null && patientList.size()>0){ 

%> 
<div class="Block">
<label>Service No.</label>
 <input name="hinNo" type="text" value="<%=patientList.get(0).getHin().getServiceNo()%>" readonly="readonly" />
<input name="hin" type="hidden" value="<%=patientList.get(0).getHin().getId()%>" />
 <label>Patient Name</label> 
 <%if(patientList.get(0).getHin()!=null){ %>
<input name="patientName" type="text" value="<%=patientList.get(0).getHin().getPFirstName()+" "+(patientList.get(0).getHin().getPMiddleName()!=null?patientList.get(0).getHin().getPMiddleName():"")+" "+(patientList.get(0).getHin().getPLastName()!=null?patientList.get(0).getHin().getPLastName():"")%>" readonly="readonly" />
<%}else{%>
 <input name="patientName" type="text" value="" readonly="readonly" />
  <%}%>
  <label>Relation </label>
 <%if(patientList.get(0).getHin().getRelation() !=null){ %>
<input name="relation" type="text" value="<%=patientList.get(0).getHin().getRelation().getRelationName() %>" readonly="readonly" />
	 <%}else { %>
<input name="relation" type="text" value="" readonly="readonly" />
 <%} %>
 <div class="Clear"></div>
 <label>Rank </label>
 <%if(patientList.get(0).getHin().getRank() !=null){ %>
<input name="rank" type="text" value="<%=patientList.get(0).getHin().getRank().getRankName() %>" readonly="readonly" />
	 <%}else { %>
<input name="rank" type="text" value="" readonly="readonly" />
 <%} %>
 
 <label>Name </label>
 <%
	 String servicePersonName="";
		if(patientList.get(0).getHin().getSFirstName()!= null){
			servicePersonName=patientList.get(0).getHin().getSFirstName();
			}
			if(patientList.get(0).getHin().getSMiddleName()!= null){
				servicePersonName=servicePersonName+" "+patientList.get(0).getHin().getSMiddleName();
			}
			if(patientList.get(0).getHin().getSLastName()!= null){
				servicePersonName=servicePersonName+" "+patientList.get(0).getHin().getSLastName();
			}
 
 if(patientList.get(0).getHin() != null){
 %>
<input name="rank" type="text" value="<%=servicePersonName %>" readonly="readonly" />
	 <%}else { %>
<input name="rank" type="text" value="" readonly="readonly" />
 <%} %>
  <label>Unit</label>
   <%if(patientList.get(0).getHin().getUnit()!=null){ %>
<input name="age" type="text" value="<%=patientList.get(0).getHin().getUnit().getUnitName() %>" readonly="readonly" />
	 <%}else{%> 
<input name="age" type="text" value="" readonly="readonly" />
 <%} %>
 <div class="Clear"></div>
  <label>Age</label>
   <%if(patientList.get(0).getAge()!=null){ %>
<input name="age" type="text" value="<%=patientList.get(0).getAge() %>" readonly="readonly" />
	 <%}else{%> 
<input name="age" type="text" value="" readonly="readonly" />
 <%} %>


<label>Gender </label>
 <%if(patientList.get(0).getSex()!=null){ %>
<input name="sex" type="text" value="<%=patientList.get(0).getSex() %>" readonly="readonly" />
	 <%}else { %>
 <input name="sex" type="text" value="" readonly="readonly" />
	 <%} %><%--
 
 <label>Medical Officer</label>
 <%
 String doctorName="";
	
 
 %>
<label class="value"><%=doctorName %></label>
--%></div>
	<%} %>
<!--Block Three Starts-->
<div class="division"></div>
<div class="tableHolderAuto">
<%
if((patientList!=null && patientList.size()>0 && files!=null) || (inpatientList!=null && inpatientList.size()>0 && files!=null)){ 
%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">Date</th>
		<th scope="col">File Name</th>
		<th scope="col">Document</th>
		<th scope="col">Description</th>
	</tr>

	<%
	
	if(inpatientList!=null && inpatientList.size()>0 && files!=null){ 
		for(int i=0;i<inpatientList.size();i++){
		//	for(int i=0;i<files.length;i++){
				
			
	%>
	<tr>
		<td><%=i+1 %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(inpatientList.get(0).getUploadDate())%></td>
		<td>
		<!-- <a
			href="opd?method=viewPatientDocuments&filename=<%="/"+inpatientList.get(0).getHin().getHinNo()+"/"+files[i]%>"><%=files[i]%>
		</a> -->
		<a href="#" onclick="submitFormForButton('viewDocumentsPopUp','opd?method=viewPatientDocuments&filename=<%="/"+inpatientList.get(0).getHin().getHinNo()+"/"+inpatientList.get(0).getFileName()+"."+inpatientList.get(0).getFileExtension()%>')"><%=inpatientList.get(0).getFileName()+"."+inpatientList.get(0).getFileExtension()%>
		</a> 
		</td>
		<td><img
			src="../upload/<%=inpatientList.get(0).getHin().getHinNo()+"/"+files[i]%>"
			alt="/" width="50px" height="50px" /></td>
		<%if(inpatientList.get(0).getDescription()!=null){ %>
		<td><%=inpatientList.get(0).getDescription()%></td>
		<%}else{%>
		<td>-</td>
		<%} %>
	</tr>
	<%		}
		}
	%>
	<%
	if(patientList!=null && patientList.size()>0 && files!=null){ 
		for(int i=0;i<patientList.size();i++){
		//	for(int i=0;i<files.length;i++){
			
	%>
	<tr>
		<td><%=i+1 %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(patientList.get(i).getUploadDate())%></td>
		<td>
		<%--<a
			href="opd?method=viewPatientDocuments&filename=<%="/"+patientList.get(i).getHin().getHinNo()+"/"+files[i]%>">
		<%=files[i]%>
		</a>
		--%>
		<a href="opd?method=viewPatientDocuments&filename=<%="/"+patientList.get(i).getHin().getHinNo()+"/"+patientList.get(i).getFileName()+"."+patientList.get(i).getFileExtension()%>"><%=patientList.get(i).getFileName()+"."+patientList.get(i).getFileExtension()%>
		</a> </td>
		<td><%-- <img
			src="../upload/<%=patientList.get(0).getHin().getHinNo()+"/"+files[0]%>"
			alt="/" width="50px" height="50px" />--%></td>
		<%if(patientList.get(i).getDescription()!=null){ %>
		<td><%=patientList.get(i).getDescription()%></td>
		<%}else{%>
		<td>-</td>
		<%} %>
	</tr>
	<%	}
		}
	%>
</table>
<%} %>
</div>
<input name="" type="button" class="button"
	value="Back" onClick="submitForm('viewDocumentsPopUp','/hms/hms/opd?method=showUploadingDocumentsJsp&&visitId=<%=visitId %>&token=2&backFlag=OPD')" />
<!--Bottom labels ends-->
</form>
<!--main content placeholder ends here-->
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

<h4>View DOCUMENT</h4>
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
				}
			 	System.out.println("patientList"+patientList.size());
				if(map.get("inpatientList")!=null)
				{
					inpatientList=(List<UploadDocuments>)map.get("inpatientList");	
				}
				if(map.get("files")!=null){
					files=(String[])map.get("files");
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

<input type="hidden" name="flag" value="view" id="flag">
<div class="block">
<%if(patientList!=null && patientList.size()>0){ 
%> <label>Service No.</label>
 <input name="hinNo" type="text" value="<%=patientList.get(0).getHin().getServiceNo()%>" readonly="readonly" />
<input name="hin" type="hidden" value="<%=patientList.get(0).getHin().getId()%>" />
 <label>Name</label> 
 <%if(patientList.get(0).getPatientName()!=null){ %>
<input name="patientName" type="text" value="<%=patientList.get(0).getPatientName()%>" readonly="readonly" />
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
 
 <label>Rank </label>
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
	 <%} %>
 
 <label>Medical Officer</label>
 <%
 String doctorName="";
	
 
 %>
<label class="value"><%=doctorName %></label>
</div>

<!--Block Three Starts-->
<div class="division"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">S. No.</th>
		<th scope="col">Date</th>
		<th scope="col">File Name</th>
		<th scope="col">Document</th>
		<th scope="col">Description</th>
	</tr>
	<%} %>
	<%if(inpatientList!=null && inpatientList.size()>0 && files!=null){ 
		//for(int i=0;i<inpatientList.size();i++){
			System.out.println("inpatient-------------->>>>>");
			for(int i=0;i<files.length;i++){
				System.out.println("patientList----------------->>>>+files[i]=====>"+files[i]);
				
			
	%>
	<tr>
		<td><%=i+1 %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(inpatientList.get(0).getUploadDate())%></td>
		<td><a
			href="medicalBoard?method=viewPatientDocuments&filename=<%="/"+patientList.get(0).getHin().getHinNo()+"/"+files[i]%>"><%=files[i]%>
		</a></td>
		<td><img
			src="../upload/<%=patientList.get(0).getHin().getHinNo()+"/"+files[i]%>"
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
		//for(int i=0;i<patientList.size();i++){
			System.out.println("patientList----------------->>>>");
			for(int i=0;i<files.length;i++){
				System.out.println("patientList----------------->>>>+files[i]=====>"+files[i]);
			
	%>
	<tr>
		<td><%=i+1 %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(patientList.get(0).getUploadDate())%></td>
		<td><a
			href="medicalBoard?method=viewPatientDocuments&filename=<%="/"+patientList.get(0).getHin().getHinNo()+"/"+files[i]%>">
		<%=files[i]%>
		</a></td>
		<td><%-- <img
			src="../upload/<%=patientList.get(0).getHin().getHinNo()+"/"+files[0]%>"
			alt="/" width="50px" height="50px" />--%></td>
		<%if(patientList.get(0).getDescription()!=null){ %>
		<td><%=patientList.get(0).getDescription()%></td>
		<%}else{%>
		<td>-</td>
		<%} %>
	</tr>
	<%	}
		}
	%>
</table>
</div>
<input name="" type="button" class="button"
	value="Back" onClick="history.back();" />
</div>
<!--Bottom labels ends-->
</form>
</div>
<!--main content placeholder ends here-->
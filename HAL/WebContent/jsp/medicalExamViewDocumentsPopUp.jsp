<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registeredPatients.jsp  
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Dinesh Dubey
 * Create Date: 10th july,2011
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
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<!--main content placeholder starts here-->

<div id="contentHolder">
<form name="viewDocumentsPopUpMedicalExam" method="post"
	enctype="multipart/form-data">

<h4>View DOCUMENT</h4>
<div class="Clear"></div>

<%
			 	
			 	
                String [] files =null;
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	boolean noRecordFound=false;
			 	if (request.getAttribute("map") != null)
			 	{
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
				
				if(map.get("files")!=null){
					files=(String[])map.get("files");
				}
				String hinNo="";
				if(map.get("hinNo")!=null){
					hinNo=(String)map.get("hinNo");
				}
				int hinId=0;
				if(map.get("hinId")!=null)
				{
					hinId=(Integer)map.get("hinId");
				}
				int visitId=0;
				if(map.get("visitId")!=null)
				{
					visitId=(Integer)map.get("visitId");
				}
				String folderName="";
				if(map.get("folderName")!=null){
					folderName=(String)map.get("folderName");
				}
				String uploadURL="";
				if(map.get("uploadURL")!=null)
				{
					uploadURL=(String)map.get("uploadURL");
				}
			 		 	
			 %>




<div class="division"></div>

<input type="hidden" name="flag" value="view" id="flag">
<div class="block">
 <label>Hin No</label>
 <input name="hinNo" type="text" value="<%=hinNo%>" readonly="readonly" />
 <input name="folderName" type="hidden" value="<%=folderName%>" readonly="readonly" />
<!--Block Three Starts-->
<div class="division"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">S. No.</th>
		<th scope="col">File Name</th>
	</tr>
	<%if(files!=null)
	 { for(int i=0;i<files.length;i++)
	    {%>
	<tr>
		<td><%=i+1 %></td>
		<td><a
			href="medicalExam?method=viewMedicalExamDocuments&filename=<%=files[i]%>&hinNo=<%=hinNo %>&folderName=<%=folderName %>">
		<%=files[i]%>
		</a></td>
		</tr>
		<%}}else{ %>
	<tr><td colspan="2"><h2>No Record Found</h2></td></tr>
	<%}%>
</table>
</div>
<input name="" type="button" class="button"
	value="Back" onClick="history.back();" />
	<input name="button" type="button"  class="button" value="Close" onClick="window.close();" />
	
</div>

</form>
</div>

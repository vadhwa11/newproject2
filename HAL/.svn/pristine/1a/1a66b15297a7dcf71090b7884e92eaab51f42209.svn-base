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
<form name="viewDocumentsInvestPopUpMedicalExam" method="post"
	enctype="multipart/form-data">

<h4>View DOCUMENT</h4>
<div class="Clear"></div>

<%
			 	
			 	
               	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null)
			 	{
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	List<MasMedicalUploadDocument> masMedicalUploadDocumentList=new ArrayList<MasMedicalUploadDocument>();
				if(map.get("masMedicalUploadDocumentList")!=null){
					masMedicalUploadDocumentList=(List<MasMedicalUploadDocument>)map.get("masMedicalUploadDocumentList");
				}
				String hin_no="";
				if(map.get("hin_no")!=null){
					hin_no=(String)map.get("hin_no");
				}	 	
			 %>




<div class="division"></div>

<input type="hidden" name="flag" value="view" id="flag">
<div class="block">
 <label>Hin No</label>
 <input name="hinNo" type="text" value="<%=hin_no%>" readonly="readonly" />

<div class="division"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">S. No.</th>
		<th scope="col">File Name</th>
	</tr>
	<% int i=1;
	  if(masMedicalUploadDocumentList.size()>0)
	 { 
		for(MasMedicalUploadDocument masMedicalUploadDocument:masMedicalUploadDocumentList)
	    {%>
	<tr>
		<td><%=i++ %></td>
		<td><a
			href="#" onclick="parent.location='medicalExam?method=viewMedicalExamInvestDocuments&filename=<%=masMedicalUploadDocument.getFileName()%>&fileExt=<%=masMedicalUploadDocument.getFileExtension() %>&invest_id=<%=masMedicalUploadDocument.getDgMasInvestigation().getId() %>&hinId=<%=masMedicalUploadDocument.getHin().getId() %>&medExamId=<%=masMedicalUploadDocument.getMasMedicalExamReport().getId() %>'">
		<%=masMedicalUploadDocument.getFileName()+"."+masMedicalUploadDocument.getFileExtension()%>
		</a></td>
		</tr>
		<%}}else{ %>
	<tr><td colspan="2"><h2>No Record Found</h2></td></tr>
	<%}%>
</table>
</div>
<input name="" type="hidden" class="button"
	value="Back" onClick="history.back();" />
	<input name="button" type="button"  class="button" value="Close" onClick="window.close();" />
	
</div>

</form>
</div>


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
			 	List<AvMedicalUploadDocument> avUploadDocumentList=new ArrayList<AvMedicalUploadDocument>();
				if(map.get("avUploadDocumentList")!=null){
					avUploadDocumentList=(List<AvMedicalUploadDocument>)map.get("avUploadDocumentList");
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
	  if(avUploadDocumentList.size()>0)
	 { 
		for(AvMedicalUploadDocument avUploadDocument:avUploadDocumentList)
	    {%>
	<tr>
		<td><%=i++ %></td>
		<td><a
			href="aviationMedicine?method=viewMedicalExamInvestDocuments&filename=<%=avUploadDocument.getFileName()%>&fileExt=<%=avUploadDocument.getFileExtension() %>&invest_id=<%=avUploadDocument.getDgMasInvestigation().getId() %>&hinId=<%=avUploadDocument.getHin().getId() %>&avExamId=<%=avUploadDocument.getAvMedicalExamReport().getId() %>">
		<%=avUploadDocument.getFileName()+"."+avUploadDocument.getFileExtension()%>
		</a></td>
		</tr>
		<%}}else{ %>
	<tr><td colspan="2"><h2>No Record Found</h2></td></tr>
	<%}%>
</table>
</div>

	<input name="button" type="button"  class="button" value="Close" onClick="window.close();" />
	
</div>

</form>
</div>

<%@page import="jkt.hms.masters.business.UploadDocuments"%>


<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%-- <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet">
</script> --%>
<script type="text/javascript">
/* var csrfTokenName='<csrf:tokenname />';
var csrfTokenValue='<csrf:tokenvalue />'; */
 var csrfTokenName='${_csrf.parameterName}';
 var csrfTokenValue='${_csrf.token}';
</script>
<script type="text/javascript"  src="/hms/jsp/js/csrfToken.js"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
<%
				Map<String, Object> map = new HashMap<String, Object>();
// 				 List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
				 /*List<TempTickattach> tempTicketAttachList = new ArrayList<TempTickattach>(); */
				 List<UploadDocuments> uploadDocuments=new ArrayList<UploadDocuments>();
				String message = "";
				int hinId=0;
				int visitId=0;
				int inpatientId=0;
				int referralHeaderId=0;
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				if(map.get("uploadDocuments")!= null){
					uploadDocuments = (List)map.get("uploadDocuments");
				}
				if(request.getParameter("hinId")!=null){
					hinId=Integer.parseInt((String)request.getParameter("hinId"));
				}
				if(request.getParameter("inpatientId")!=null){
					inpatientId=Integer.parseInt((String)request.getParameter("inpatientId"));
				}else if(map.get("inpatientId")!= null){
					inpatientId = (Integer) map.get("inpatientId");
				}
				if(request.getParameter("referralHeaderId")!=null){
					referralHeaderId=Integer.parseInt((String)request.getParameter("referralHeaderId"));
				}else if(map.get("referralHeaderId")!= null){
					referralHeaderId = (Integer) map.get("referralHeaderId");
				}
				if(request.getParameter("visitId")!=null){
					visitId=Integer.parseInt((String)request.getParameter("visitId"));
				}else if(map.get("visitId")!= null){
					visitId = (Integer)map.get("visitId");
				}
				
				String uploadFrom ="OPD";
				
				if(inpatientId != 0)
				{
					uploadFrom = "IP";
				}
				
				if(referralHeaderId != 0)
				{
					uploadFrom = "Referral";
				}
				
			int RequestId = 0;	
			int employeeId = 0;
		
		%>
				
	
<script language="javascript">

function jsImport()
{
	if (document.getElementById('fileNameId').value == "")
		
	{
	alert('Please select a file to Upload');
	return;
	}
	var fname = document.getElementById('fileNameId').value;
	var hinId= document.getElementById("hinId").value;
	var ind1 = fname.lastIndexOf("\\");
	var filename = fname.substring(ind1+1);
	document.getElementById("fileName").value=filename;
	document.getElementById("flag").value="y";
	document.attachFile.method="post";
	submitForm('attachFile','opd?method=uploadAndViewDocuments&hinId='+hinId+'&'+csrfTokenName+'='+csrfTokenValue);
	
}

</script>
<div class="popupbg">

<%-- <%@page import="jkt.hms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hms.masters.business.TempTickattach"%> --%>
<form name="attachFile" method="post" action="" enctype="multipart/form-data">
<div class="titleBg"> <h2>Upload File </h2></div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<div class="Block" style="width:978px;">
<div class="clear"></div>
<label>File</label>
<%--  <input type="file" name="<%=UPLOAD_FILENAME %>" id="fileNameId" class="browse">  --%>
 <input type="file" name="<%=UPLOAD_FILENAME %>" id="fileNameId" class="browse"> 
  <input type="hidden" name="flag" id="flag" value="n">
  <input type="hidden" name="hinId" id="hinId" value="<%out.print(hinId);%>">
  <input type="hidden" name="visitId" id="visitId" value="<%out.print(visitId);%>">
  <input type="hidden" name="inpatientId" id="inpatientId" value="<%out.print(inpatientId);%>">  
  <input type="hidden" name="referralHeaderId" id="referralHeaderId" value="<%=referralHeaderId%>">
  <input type="hidden" name="uploadFrom" id="uploadFrom" value="<%out.print(uploadFrom);%>">
<div class="clear"></div>
<label>Comments</label>
<textarea    type="textarea" name="comments" value=""  validate="Comments,string,no"  class="large" MAXLENGTH="480" tabindex=1></textarea>
<div class="clear"></div>
</div>

<input name="add" type="button" class="button" value="Upload" onClick="jsImport();"/>
<input name="add" type="button" class="button" value="Close" onClick="window.close();"/>
<div class="clear"></div>


<table id="searchresulttable">
<tr>
<th>Upload Date</th>

<%
if(visitId!=0)
{
	%>
		<th>Visit No</th>
	<%
}%>
<%
if(inpatientId!=0)
{
	%>
		<th>A&D No.</th>
	<%
}%>
<th>File</th>
<th>Comments</th>

</tr>
 <%
	int i = 0;
	if(uploadDocuments.size()>0){
		for(UploadDocuments uploadDocs :uploadDocuments){
			//requestId=doc.getRequest().getId();
%>
<tr>
<td><%=uploadDocs.getUploadDate()!=null ? HMSUtil.convertDateToStringTypeDateOnly(uploadDocs.getUploadDate()): " - "%></td>

<%-- <td><%=uploadDocs.getVisit()!=null ? uploadDocs.getVisit().getVisitNo(): " - "%></td> --%>
<%-- <td><%=uploadDocs.getInpatient()!=null ? uploadDocs.getInpatient().getAdNo(): " - "%></td> --%>
<%
if(inpatientId!=0)
{
	%>
	<td><%=uploadDocs.getInpatient()!=null ? uploadDocs.getInpatient().getAdNo(): " - "%></td>
		<td><a href="#" onclick="submitFormForButton('attachFile','investigation?method=viewUploadDocuments&viewFrom=IP&uploadedDocumentId=<%=uploadDocs.getId()%>&filename=<%=uploadDocs.getFileName()+"."+uploadDocs.getFileExtension()%>&'+csrfTokenName+'='+csrfTokenValue)"><%=uploadDocs.getFileName()+"."+uploadDocs.getFileExtension()%></a></td>
	<%
}
if(visitId!=0)
{
	%>
		<%-- <td><a href="#" onclick="submitFormForButton('attachFile','investigation?method=viewUploadDocuments&viewFrom=OPD&hinId=<%=uploadDocs.getHin().getId()%>&filename=<%=uploadDocs.getFileName()+"."+uploadDocs.getFileExtension()%>')"><%=uploadDocs.getFileName()+"."+uploadDocs.getFileExtension()%></a></td> --%>
		<td><%=uploadDocs.getVisit()!=null ? uploadDocs.getVisit().getVisitNo(): " - "%></td> 
		<td><a href="#" onclick="submitFormForButton('attachFile','investigation?method=viewUploadDocuments&viewFrom=OPD&uploadedDocumentId=<%=uploadDocs.getId()%>&filename=<%=uploadDocs.getFileName()+"."+uploadDocs.getFileExtension()%>&'+csrfTokenName+'='+csrfTokenValue)"><%=uploadDocs.getFileName()+"."+uploadDocs.getFileExtension()%></a></td>
	<%
}
if(uploadDocs.getReferralHeader()!=null)
{
	%>
		<%-- <td><a href="#" onclick="submitFormForButton('attachFile','investigation?method=viewUploadDocuments&viewFrom=OPD&hinId=<%=uploadDocs.getHin().getId()%>&filename=<%=uploadDocs.getFileName()+"."+uploadDocs.getFileExtension()%>')"><%=uploadDocs.getFileName()+"."+uploadDocs.getFileExtension()%></a></td> --%>
		
		<td><a href="#" onclick="submitFormForButton('attachFile','investigation?method=viewUploadDocuments&viewFrom=Referral&uploadedDocumentId=<%=uploadDocs.getId()%>&filename=<%=uploadDocs.getFileName()+"."+uploadDocs.getFileExtension()%>&'+csrfTokenName+'='+csrfTokenValue)"><%=uploadDocs.getFileName()+"."+uploadDocs.getFileExtension()%></a></td>
	<%
}
	
	
%>


<td><%=!uploadDocs.getDescription().equals( "") ? uploadDocs.getDescription(): " - "%></td>
</tr>
<%i++;
	}}
%> 
</table>

<input type="hidden" id="countId" name="counter" value="<%=i%>">

<input type="hidden"  name="<%=EMPLOYEE_ID %>" value="<%=employeeId %>" />  
<input type="hidden" id="fileName" name="fileName" vale="" />
<div class="clear"></div>


<!-- <input name="Delete" type="button"  class="button" value="Delete" onClick="if(validate()){submitForm('attachFile','maintenance?method=deleteAttachFile');}" />
<input name="add" type="button" class="button" value="Close" onClick="window.close();"/> -->



<script type="text/javascript">

 function validate(){
	 var DocumentId=document.getElementsByName("DocumentId");
	 var checkLength=0;
	 for(var i=0;i<DocumentId.length;i++){
		 if(DocumentId[i].checked){
			 checkLength=checkLength+1;
		 }
	 }
	 if(checkLength>0){
		 return true;
	 }else{
		 alert("Select File");
		 return false;
	 }
 }



</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>

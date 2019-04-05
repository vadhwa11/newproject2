
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.UploadDocuments"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.File"%><link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<div class="Clear"></div>
<form name="invUpload" method="post" enctype="multipart/form-data">
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>) request.getAttribute("map");
	}
	Box box = HMSUtil.getBox(request);
	int hinId = box.getInt("hinId");
	String diagNo = box.getString("diagNo");
	int uploadDocumentId = 0;
	if(map.get("uploadDocumentId")!=null){
		uploadDocumentId = (Integer)map.get("uploadDocumentId");
	}
	String message = "";
	if(map.get("message") != null){
		 message = (String)map.get("message");
	}
	List<UploadDocuments> uploadDocList = new ArrayList<UploadDocuments>();
	if(map.get("uploadDocList")!=null){
		uploadDocList = (List<UploadDocuments>)map.get("uploadDocList");
	}
	String hinNo = "";
	if(map.get("hinNo")!=null){
		hinNo = (String)map.get("hinNo");
	}
%>
<h4><%=message %></h4>
<div class="Clear"></div>
<%
if(uploadDocList.size() == 0){
%>
<table border="0" cellspacing="0" cellpadding="0" id="uploadGrid">
	<tr>
		<th scope="col">File</th>
		<th scope="col">Description:</th>
	</tr>
	<tr>
		<td><input type="file" name="<%=UPLOAD_FILENAME %>"
			id="attachment" class="Browse" onkeypress="javascript:return false;"
			onkeydown="javascript:return false;" />
			
			</td>
		<td><input type="text" name="description"
			id="description" /></td>
			
	</tr>


</table>

<%}else if(uploadDocList.size() > 0){
	String userHome = getServletContext().getRealPath("");
	String fileSeparator = System.getProperty("file.separator");

	String uploadURL = userHome.substring(0, userHome
			.lastIndexOf(fileSeparator))
			+ fileSeparator
			+ "HMSDocumentFolder"
			+ fileSeparator
			+ "upload" + fileSeparator;
	String[] files = null;
	try {
			File fileDir = new File(uploadURL + fileSeparator + hinNo);
			if (fileDir.exists()) {
				files = fileDir.list();
			}
		} catch (Exception exc) {
			exc.printStackTrace();

		}

%>
<div class="Clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">Date</th>
		<th scope="col">File Name</th>
		<th scope="col">Document</th>
		<th scope="col">Description</th>
	</tr>

	<%
		int i = 0;
		for(UploadDocuments uploadDocuments : uploadDocList){
			uploadDocumentId = uploadDocuments.getId();
		%>
	<tr>
		<td><%=i+1 %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(uploadDocuments.getUploadDate())%></td>
		<td>
		<a href="opd?method=viewPatientDocuments&filename=<%="/"+uploadDocuments.getHin().getHinNo()+"/"+uploadDocuments.getFileName()+"."+uploadDocuments.getFileExtension()%>"><%=uploadDocuments.getFileName()+"."+uploadDocuments.getFileExtension()%>
		</a> </td>
	<td><img
			src="../HMSDocumentFolder/upload/<%=uploadDocuments.getHin().getHinNo()+"/"+files[i]%>"
			alt="/" width="50px" height="50px" /></td>
		<%if(uploadDocuments.getDescription()!=null){ %>
		<td><%=uploadDocuments.getDescription()%></td>
		<%}else{%>
		<td>-</td>
		<%} %>
	</tr>
	<%	i++;}
	%>
</table>

<%} %>
<input type="hidden" name="hinId" value="<%=hinId %>"/>
<input type="hidden" name="diagNo" value="<%=diagNo %>"/>
<input type="hidden"	name="hinNo" id="hinNo" value="<%=box.getString("hinNo") %>" />
<input	type="hidden" name="<%=INPATIENT_ID %>" id="<%=INPATIENT_ID %>"	value="<%=(box.getInt("inpatientId"))%>" />
<input	type="hidden" name="<%=VISIT_ID %>" id="<%=VISIT_ID %>"	value="<%=(box.getInt("visitId"))%>" />

<%
	if(uploadDocList.size()== 0){
%>
<input type="button" class="button" name="impbutton" value="Attach"	onClick="uploadDoc()" /> 
<input type="button" class="button" name="close" value="Close"	onClick="setIdInParent();" /> 
<%}else{ %>
<input type="button" class="button" name="close" value="Close"	onClick="setIdInParent();" /> 

<%} %>
	<script>
	function setIdInParent(){
		if(window.opener.document.getElementById('uploadDocumentId')){
			window.opener.document.getElementById('uploadDocumentId').value='<%=uploadDocumentId%>';
		}
		window.close();
	}

	function uploadDoc(){
		var fname = document.getElementById('attachment').value;
		var ind = fname.lastIndexOf("\\");
		var filename = fname.substring(ind+1);
	submitForm('invUpload','/hms/hms/investigation?method=uploadInvDocuments&filename='+filename)
	}
	</script>
</form>
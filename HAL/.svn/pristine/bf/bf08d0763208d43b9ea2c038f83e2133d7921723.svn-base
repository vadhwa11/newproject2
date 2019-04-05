<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasMedicalUploadDocument"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>

<%@page import="jkt.hms.util.Box"%><script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
		
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>


<%
	String date = "";
	String time = "";
	String userName = "";
	Map<String, Object> map = new HashMap<String, Object>();
	
	int visitId = 0;
	int medExamId =0;
	int deptId =0;
	int hospitalId =0;
	
	List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	List<Visit> patientDataList = new ArrayList<Visit>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("deptId")!=null)
	{
		deptId = (Integer) map.get("deptId");
	}
	if(map.get("hospitalId")!=null)
	{
		hospitalId = (Integer) map.get("hospitalId");
	}
	if(map.get("visitId")!=null)
	{
		visitId = (Integer) map.get("visitId");
	}
	if(map.get("medExamId")!=null)
	{
		medExamId = (Integer) map.get("medExamId");
	}
	if(map.get("patientDataList")!=null)
	{
		patientDataList = (List) map.get("patientDataList");
	}
	String mode="";
	if(map.get("flag")!=null)
	{
		mode = (String) map.get("flag");
	}
	
	Visit visit=null;
	int hinId=0;
	if(patientDataList.size()>0){
		visit=(Visit)patientDataList.get(0);
		hinId=visit.getHin().getId();
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 	String message="";
 	%>
<%
if(map.get("message") != null){
	   message = (String)map.get("message");
	    	   %>
	   <h4><%=message %></h4>
	   <% 
	  }%>
<!--main content placeholder starts here-->

<form name="mbUpload" method="post" enctype="multipart/form-data">
<h2>Upload/View Documents</h2>
<%
	if(!mode.equalsIgnoreCase("VIEW")){
%>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<%int inc=1; %>

<table border="0" cellspacing="0" cellpadding="0" id="uploadGrid">
	<tr>
		<th></th>
		<th scope="col">File</th>
		<th scope="col">Description</th>
		<%--<th scope="col">Mode</th> --%>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>
<tr>
	<td><label><%=inc%></label></td>
<td><input type="file" name="<%=UPLOAD_FILENAME + inc%>"
	id="attachment1" class="Browse" onkeypress="javascript:return false;" onkeydown="javascript:return false;" />
	
	</td>
<td><input type="text" name="<%=DESCRIPTION + inc%>" id="description1" />
	<input type="hidden" name="mode<%=inc%>" id="mode1" value="<%=mode%>"/>
	</td>
	<td>
	<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
	</td>
	<td>
	<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow(this);" tabindex="1" />
		</td>
</tr>

</table>
<input type="hidden" name="uploadCount" value="<%=inc %>" id="uploadCount" />
<div class="Clear"></div>
<input type="button" class="button" name="impbutton" value="Attach" onClick="jsImport(<%=visitId %>,<%=medExamId%>)" />
<%if(medExamId !=0){ %> 
<input type="button" class="button" name="impbutton" value="View"
	onClick="viewPatientDocuments(<%=visitId %>,<%=medExamId %>);" /> 	
	<%} %>
<input name="Close" type="button"  alt="Back" value="Close"
class="buttonBig" align="right"  onclick="window.close();" />
<%
}else{
%>
<div class="Clear"></div>
<input type="button" class="button" name="impbutton" value="View"
	onClick="viewPatientDocuments(<%=visitId %>,<%=medExamId %>);" /> 	
	
<input name="Close" type="button"  value="Close"
class="button" align="right"  onclick="window.close();" />
<%	
}
%>
<div class="Clear"></div>
<%
List<MasMedicalUploadDocument> masMedicalUploadDocumentList = new ArrayList<MasMedicalUploadDocument>();
if(map.get("masMedicalUploadDocumentList")!=null)
{
	masMedicalUploadDocumentList = (List) map.get("masMedicalUploadDocumentList");
}
%>

<div class="division"></div>
<%if(masMedicalUploadDocumentList!=null && masMedicalUploadDocumentList.size()>0){  %>
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">File</th>
		<th scope="col">Description</th>
	</tr>
	<%
		//for(int i=0;i<inpatientList.size();i++){
		//for(int i=0;i<files.length;i++){
			int cnt=0;
			for(MasMedicalUploadDocument masMedicalUploadDocument :masMedicalUploadDocumentList){
				++cnt;
				String description="&nbsp;";
				if(masMedicalUploadDocument.getDescription()!=null){
					description=masMedicalUploadDocument.getDescription();
				}
	%>
	<tr>
		<td><%=cnt %></td>
		<td>
		<a href="#"  onclick="submitForm('mbUpload','/hms/hms/medicalBoard?method=viewPatientDocuments&filename=<%=masMedicalUploadDocument.getFileName()%>&fileExt=<%=masMedicalUploadDocument.getFileExtension() %>&folderName=<%=masMedicalUploadDocument.getFileFlag() %>&hinId=<%=masMedicalUploadDocument.getHin().getId() %>&medExamId=<%=masMedicalUploadDocument.getMasMedicalExamReport().getId() %>');">
		<%=masMedicalUploadDocument.getFileName()+"."+masMedicalUploadDocument.getFileExtension()%>
		</a>
		</td>
		<td><%=description%></td>
	</tr>
	<%		}
		
		%>
</table>
<%} %>
<div class="Clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> 
<label>Changed Time</label> <label class="value"><%=time%></label>
<%
String hin_no="";
if(visit.getHin().getHinNo()!= null){ 
hin_no=visit.getHin().getHinNo();

%>
<input type="hidden" name="hinId" value="<%=visit.getHin().getId() %>" />
<input id="visitId" name="visitId" type="hidden" value="<%=visitId%>" readonly="readonly" />
<input type="hidden" name="hin_no" id="hin_no" value="<%=visit.getHin().getHinNo() %>" />
<%} %>
<input type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>" />
<input type="hidden" name="deptId" size="5" value="<%=deptId%>" />
<input type="hidden" name="date" size="5" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" class="textbox_size20" readonly="readonly" MAXLENGTH="8"  tabindex=3 />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" class="textbox_size20" readonly="readonly" tabindex=3 />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" class="textbox_size20" readonly="readonly" tabindex=3 />

<div class="Clear"></div>
</div>

<script type="text/javascript">
function addRow(){
	
	  var tbl = document.getElementById('uploadGrid');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('uploadCount');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cell0 = row.insertCell(0);
	  var e0 = document.createElement('label');
	//  e0.type = 'text';
	//  e0.name='sno'+iteration;
	//  e0.id='sNoId'+iteration
	  e0.innerHTML= (iteration);
	//  e0.size = '2'
	 cell0.appendChild(e0);
	  
	  var cell1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'file';
	  e1.size = '20';
	  e1.className='browse';
	  e1.name='upload_filename'+iteration;
	  e1.id='attachment'+iteration
	  cell1.appendChild(e1);
	   	  
	  var cell2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='description'+iteration;
	  e2.id='description'+iteration
	  e2.size = '20'
	  cell2.appendChild(e2);    

	  var e3x = document.createElement('input');
	  e3x.type = 'hidden';
	  //e3x.type = 'text';
	  e3x.name='mode'+iteration;
	  e3x.id='mode'+iteration;
	  e3x.size='5';
	  e3x.value='<%=mode%>';
	  e3x.setAttribute('tabindex','1');
	  cell2.appendChild(e3x);	  

	  var cell3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonAdd';
	  e3.name='Button'+iteration;
	  e3.onclick = function(){addRow();}; 
	  e3.setAttribute('tabindex','1');
	  cell3.appendChild(e3);

	  var cell4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonDel';
	  e4.name='delete'+iteration;
	  e4.onclick=function(){removeRow(this);}; 
	  e4.setAttribute('tabindex','1');
	  cell4.appendChild(e4);
}

	var upload_number = 2;
	function addFileInput() {
	 	var d = document.createElement("div");
	 	var file = document.createElement("input");
	 	file.setAttribute("type", "file");
	 	file.setAttribute("id", "attachment"+upload_number);
	 	file.setAttribute("name", "upload_filename");
	 	d.appendChild(file);
	 	document.getElementById("moreUploads").appendChild(d);
	 	upload_number++;
	}
</script>
<script language="javascript">
function jsImport(visitId,medExamId)
{
	var inc = document.getElementById('uploadCount').value;
	var flag = '';
	var fileNames = '';
	var filename = '';
	var description='';
	for(i=1;i<=inc;i++ ){
		if (document.getElementById('attachment'+i) && document.getElementById('attachment'+i).value!="")
		{
			flag='exists';
			var fname = document.getElementById('attachment'+i).value;
			var desp=document.getElementById('description'+i).value;
			var ind = fname.lastIndexOf("\\");
			var filename = fname.substring(ind+1);
			
			fileNames +='&filename'+i+'='+filename;
			description +='&description'+i+'='+desp;		
		}
	}
	if(flag==''){
		alert("Please upload atleast one file.");
		return false;
	}
	var changed_by = document.mbUpload.<%=CHANGED_BY%>.value; 
	var changed_date = document.mbUpload.<%=CHANGED_DATE%>.value;
	var changed_time = document.mbUpload.<%=CHANGED_TIME%>.value;
	var hospitalId =  document.mbUpload.hospitalId.value;
	var deptId = document.mbUpload.deptId.value;
	document.mbUpload.method="post";
	
	submitForm('mbUpload','/hms/hms/medicalBoard?method=submitUploadDocumentsMo'+description+fileNames + '&<%=CHANGED_BY%>=' + changed_by + '&<%=CHANGED_DATE%>=' + changed_date + '&<%=CHANGED_TIME%>=' + changed_time + '&hospitalId=' + hospitalId + '&deptId=' + deptId+'&visitId='+visitId+'&medExamId='+medExamId+'&uploadCount='+inc+'&flag='+'<%=mode%>');
	//submitForm('mbUpload','opd?method=submitUploadDocuments'+fileNames + '&<%=CHANGED_BY%>=' + changed_by + '&<%=CHANGED_DATE%>=' + changed_date + '&<%=CHANGED_TIME%>=' + changed_time + '&hospitalId=' + hospitalId + '&deptId=' + deptId+'&visitId='+visitId1+'&uploadCount='+inc);
	//submitForm('mbUpload','opd?method=submitUploadDocuments&filename1='+filename1+'&filename2='+filename2+'&filename3='+filename3+'&filename4='+filename4+'&filename5='+filename5 + '&<%=CHANGED_BY%>=' + changed_by + '&<%=CHANGED_DATE%>=' + changed_date + '&<%=CHANGED_TIME%>=' + changed_time + '&hospitalId=' + hospitalId + '&deptId=' + deptId+'&visitId='+visitId1);
}

	function removeRow(obj)
	{	  		
	  var tbl = document.getElementById('uploadGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	    var i=obj.parentNode.parentNode.rowIndex;
	    tbl.deleteRow(i);
	 // 	tbl.deleteRow(lastRow - 1);
	  //	var iteration = lastRow - 1;
	  //	var hdb = document.getElementById('uploadCount');
	 // 	hdb.value=iteration
	  }
	}
	
	function viewPatientDocuments(visitId,medExamId)
	{
		var num;
		//document.getElementById('flag1').value="viewDocuments";
		var hin_no =document.getElementById("hin_no").value ;
		submitForm('mbUpload','/hms/hms/medicalBoard?method=viewUploadDocumentsMo&hinId=<%=hinId%>&hin_no=<%=hin_no%>&visitId='+visitId+'&medExamId='+medExamId+'&flag=<%=mode%>','mywindow');
	}
	function clearValue()
	{
		if(document.getElementById('flag1')!=null)
			document.getElementById('flag1').value="";
		return true;
	}
		
</script>
</form>
<!--Main div end-->
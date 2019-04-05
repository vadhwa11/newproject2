<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.UploadDocuments"%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"/>
<script>
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
<%String date = "";
String time = "";
String userName = "";
int hospitalId = 0;
Box box = HMSUtil.getBox(request);
Map<String, Object> map = new HashMap<String, Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
List<Patient> patientList = new ArrayList<Patient>();
String message = "";
Object [][]obj=null;
if(request.getAttribute("map") != null){
map = (Map) request.getAttribute("map");
}
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
date = (String)utilMap.get("currentDate");     
time = (String)utilMap.get("currentTime");
if(session.getAttribute("userName") != null)
{
userName = (String)session.getAttribute("userName");
}

if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}

if(patientList.size()>0){
for(Patient patient :patientList){
//hinId = patient.getId();
}
}
List<UploadDocuments>patientList1=new ArrayList<UploadDocuments>();
if(map.get("patientList1")!=null)
{
patientList1=(List<UploadDocuments>)map.get("patientList1");   
}
if (map.get("message") != null) {
message = (String) map.get("message");
}
if(map.get("obj")!=null){
	obj=(Object[][])map.get("obj");
	
}

String serviceNo = "";
String hin_no = "";
int visitId = 0;
int hinid = 0;
if(map.get("serviceNo") != null){
serviceNo = (String)map.get("serviceNo") ;
}
if(map.get("hin_no") != null){
hin_no = (String)map.get("hin_no") ;
}
if(map.get("hinId") != null){
hinid = (Integer)map.get("hinId") ;
}
if(map.get("serviceNo") != null){
visitId = (Integer)map.get("visitId") ;
}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>
	<script language="javascript">
	function addAll(){
		alert("addall");
		}
	</script>


	<script language="javascript">

	function jsImport()
	{

	if (document.getElementById('fileNameId').value == "")
	{
	alert('Pl. Select a photo to upload!.....');
	return;
	}
	var fname = document.getElementById('fileNameId').value;

	var ind1 = fname.lastIndexOf("\\");

	var filename = fname.substring(ind1+1);
	if(filename.lastIndexOf(".xls")==-1){
	alert("File Type is InCorrect choose Another");
	document.getElementById('fileNameId').value="";
	}else{
	alert("filename---"+filename);
	document.attachPhoto.method="post";
	submitForm('attachPhoto','stores?method=extractXmlDocuments&filename='+filename);
	}
	}
</script>
<form name="attachPhoto" method="post" action="" enctype="multipart/form-data">
<%
if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<div class="titleBg"><h2>Upload File </h2></div>
<div class="clear"></div>
<div class="block">
<label>File</label>
<input type="file" name="<%=UPLOAD_FILENAME %>" id="fileNameId" class="browse">
<div class="clear"></div>
<label>&nbsp;</label>
<label class="auto"><span class="sublabel">Only .xls files are accepted</span></label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input name="Submit13" type="button" class="button" value="Upload" onClick="jsImport();"/>


<div class="clear"></div>
<div class="cmntableWithHeight">
<table >
	<thead>
		<tr>
			<th width="10%">Sl 	No.</th>
			<th width="10%">PVMS No.</th>
			<th width="55%">Nomenclature</th>
			<th width="25%">A/U</th>
			<th style="width: 15px;">
			<input type="checkbox" name="checkAll" id="chk_all" value="" onclick="addAll()">
			ADD ALL
			</th>
			</tr>
	</thead>
	<tbody>
		<%
			   // gridData = (HashMap[])pagedArray.getPagedArray();
				//int iFirstRow = pagedArray.getFirstRowIdx();
			if(obj!=null)
				{
				for(int i=0;i<obj.length;i++){
				
			%>
		 <tr>
			<td width="10%"><input type="text" value="<%=obj[i][0]%>" class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" value="<%=obj[i][1]%>" class="medcaption" name="<%=PVMS_NO%>" readonly="readonly" /></td>
			<td width="55%"><input type="text" value='<%=obj[i][2]%>' class="bigcaption" name="<%=NOMENCLATURE%>" readonly="readonly" /></td>
			<td width="25%"><input type="text" value="<%=obj[i][3]%>" name="<%=AU%>" class="medcaption"readonly="readonly" /></td>
			<td width="10%"><input type="checkbox" name="<%=ITEMS_TO_BE_ADDED%>" value="<%=obj[i][4]%>" onclick=""> 
		 </tr>
		<%}
}%>
	</tbody>
</table>
</div>
<div class="clear"></div>
<input name="button" type="hidden"  class="button" value="Close" onClick="window.close();" />
<div class="clear"></div>
<div class="division"></div>
</form>
</div>
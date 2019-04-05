
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/phaseII.css" />
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascrip"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>


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


<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	Box box = HMSUtil.getBox(request);
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 	
  	//Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Vector supplier_ids = null;
	String message = null;
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
    }
	
	
	if(map.get("message") != null){
		 message = (String)map.get("message");
		 
		 
				 
		%>

<h4><%=message %></h4>


<%    
		   
	}
	
	if (session.getAttribute("hospitalId") != null) 
	{
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	
	if (session.getAttribute("deptId") != null) 
	{
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
	Patient patient=null;
	if(map.get("patient")!=null)
	{
		patient=(Patient)map.get("patient");	
	}
	Visit visit=null;
	if(map.get("visit")!=null)
	{
		visit=(Visit)map.get("visit");	
	}
	int visitId=0;
	if(map.get("visitId")!=null)
	{
		visitId=(Integer)map.get("visitId");
	}
	int masExamId=0;
	if(map.get("masExamId")!=null)
	{
		masExamId=(Integer)map.get("masExamId");
	}
	String hinNo ="";
	int hinId = 0;
	if(map.get("hinNo") != null){
		hinNo = (String)map.get("hinNo") ;
	}
	//System.out.println("hinNo jsp#####===>"+hinNo);
	if(map.get("hinId") != null){
		hinId = (Integer)map.get("hinId") ;
	}
	String folderName="";
	if(map.get("folderName") != null){
		folderName = (String)map.get("folderName");
		System.out.println("folderName---in jsp-->"+folderName);
	}
	
	Map<String,Object> mapForDS= new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String consultationDate = (String)utilMap.get("currentDate");	 
	String consultationTime = (String)utilMap.get("currentTime");

	String age = "";
	String servicePersonName="";
	String patientName="";
	String doctorName="";
	int departmentId = 0;
	if(patient !=null && visit!=null)
	{
		
		//int hinId=visit.getHin().getId();
		patient = (Patient) visit.getHin();
	
		if(visit.getHin().getPFirstName()!= null){
		patientName=visit.getHin().getPFirstName();
		}
		if(visit.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+visit.getHin().getPMiddleName();
		}
		if(visit.getHin().getPLastName()!= null){
		patientName=patientName+" "+visit.getHin().getPLastName();
		}
		if(visit.getVisitDate() !=null){
		String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		}
		// departmentId = visit.getDepartment().getId();
		// String departmentName=visit.getDepartment().getDepartmentName();
		if(visit.getHin().getSFirstName()!= null){
		servicePersonName=visit.getHin().getSFirstName();
		}
		if(visit.getHin().getSMiddleName()!= null){
			servicePersonName=servicePersonName+" "+visit.getHin().getSMiddleName();
		}
		if(visit.getHin().getSLastName()!= null){
			servicePersonName=servicePersonName+" "+visit.getHin().getSLastName();
		}
		if(visit.getDoctor()!= null && visit.getDoctor().getFirstName()!=null){
		doctorName=visit.getDoctor().getFirstName();
		}
		if(visit.getDoctor()!= null && visit.getDoctor().getMiddleName()!= null){
			doctorName=doctorName+" "+visit.getDoctor().getMiddleName();
		}
		if(visit.getDoctor()!= null && visit.getDoctor().getLastName()!= null){
			doctorName=doctorName+" "+visit.getDoctor().getLastName();
		}
		age = visit.getAge();
		}
	%>


<!--main content placeholder starts here-->

<form name="appointmentUpload" method="post" enctype="multipart/form-data">

<h4>Upload Documents</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>

<!--Block One Starts-->



<div class="Clear"></div>


 

<%if(patient!= null && patient.getHinNo()!= null){ %>

<input type="hidden" name="hin_no" id="hin_no" value="<%=patient.getHinNo() %>" />

<%} %>



<div class="Clear"></div>


<!--Main div starts-->
 <input type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>" />
 <input id="visitId" name="visitId" type="hidden" value="<%=visitId%>" readonly="readonly" />
 

 
  <input type="hidden" name="date" size="5" value="<%=date%>" /> 
  <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" class="textbox_size20" readonly="readonly" MAXLENGTH="8"  tabindex=3 />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" class="textbox_size20" readonly="readonly" tabindex=3 />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" class="textbox_size20" readonly="readonly" tabindex=3 />

<div class="Clear"></div>
<div class="division">
<input type="hidden" name="flag" value="upload" id="flag"></div>


<div class="Clear"></div>
<%int inc=1; %>

<table border="0" cellspacing="0" cellpadding="0" id="uploadGrid">
	<tr>
		<th>Sl No.</th>
		<th scope="col">File</th>
		<th scope="col">Description</th>
		<th scope="col">Add</th>
			<th scope="col">Delete</th>
	</tr>
	<tr>
		<td><input type="text" value="<%=inc%>" class="auto" size="2" /></td>
		<td><input type="file" name="<%=UPLOAD_FILENAME + inc%>" class="auto" size="22" 
			id="attachment1" class="Browse" onkeypress="javascript:return false;"
			onkeydown="javascript:return false;" />
			
			</td>
		<td><input type="text" name="description<%=inc%>" 	id="description1" class="auto" size="12" /></td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
			</td>
	</tr>

</table>
<input type="hidden" name="uploadCount" value="<%=inc %>" id="uploadCount" />
<%%>
<div class="Clear"></div>
<input type="button" class="buttonBig" name="impbutton" value="Attach" onClick="jsImport()" />
 
 
  <%
 
	int uploadId = 0;
if(map.get("uploadId")!=null)
 {
	 uploadId= (Integer)map.get("uploadId");
	 System.out.println("uploadId--JSp-->"+uploadId);
 }
 %>
 
 <input type="hidden" name="uploadId" id="upload_id" value="<%=uploadId%>" />
 
 
<input type="button" class="buttonBig" name="impbutton" value="View Documents" onClick="viewPatientDocuments();" />
 	
<input name="button" type="button"  class="buttonBig" value="Close" onClick="window.close();" />
<div class="Clear paddingTop15"></div>

<!--
<input type="file" name="" id="attachment" class="Browse" onkeypress="javascript:return false;" onkeydown="javascript:return false;" 
onchange="document.getElementById('moreUploadsLink').style.display = 'block';"/>
<div id="moreUploads"><br/></div>
<div id="moreUploadsLink" style="display:none;"><a href="javascript:addFileInput();">Attach another File</a></div>
<br/>
<input type="button" class="cmnButton" name="impbutton" value="Attach" onClick="jsImport()"/>
-->

<div class="bottom">
<label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label>
<label>Changed Time</label> <label class="value"><%=time%></label>
<div class="Clear"></div>
</div>
<script type="text/javascript">
function addRow(){
	
	  var tbl = document.getElementById('uploadGrid');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('uploadCount');
	 // var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration
	  

	  var cell0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name='sno'+iteration;
	  e0.id='sNoId'+iteration
	  e0.value=(iteration);
	  e0.size = '2'
	  cell0.appendChild(e0);
	  
	  var cell1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'file';
	  e1.size = '22';
	
	  e1.name='upload_filename'+iteration;
	  e1.id='attachment'+iteration
	  cell1.appendChild(e1);
	   
	  
	  var cell2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='description'+iteration;
	  e2.id='description'+iteration
	  e2.size = '12'
	  cell2.appendChild(e2);

	    
	  var cell3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonAdd';
	  e3.name='Button'+iteration;
	  e3.setAttribute('onClick', 'addRow();'); 
	  e3.setAttribute('tabindex','1');
	  cell3.appendChild(e3);

	  var cell4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonDel';
	  e4.name='delete'+iteration;
	  e4.setAttribute('onClick', 'removeRow();'); 
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

function jsImport()
{
	var inc = document.getElementById('uploadCount').value;
	var flag = '';
	var fileNames = '';
	var filename = '';
	for(i=1;i<=inc;i++ ){
		if (document.getElementById('attachment'+i).value!="")
		{
			flag='exists';
			var fname = document.getElementById('attachment'+i).value;
			var ind = fname.lastIndexOf("\\");
			var filename = fname.substring(ind+1);			
			fileNames +='&filename'+i+'='+filename;
		

		}
	}
	if(flag==''){
		alert("Please upload atleast one file.");
		return false;
	}
	var changed_by = document.appointmentUpload.<%=CHANGED_BY%>.value; 
	var changed_date = document.appointmentUpload.<%=CHANGED_DATE%>.value;
	var changed_time = document.appointmentUpload.<%=CHANGED_TIME%>.value;
	//var hospitalId =  document.appointmentUpload.hospitalId.value;
	//var deptId = document.appointmentUpload.deptId.value;
	document.appointmentUpload.method="post";
	folderName='<%=folderName%>';
	submitForm('appointmentUpload','/hms/hms/mis?method=submitUploadDocuments'+fileNames +'&folderName='+folderName+'&uploadCount='+inc);

}
function viewPatientDocuments()
{ 
	folderName='<%=folderName%>';
	document.appointmentUpload.method="post";
   //submitForm('appointmentUpload','/hms/hms/mis?method=viewUploadDocumentsDetails&hinId='+hin_id+'&visitId='+visit_id+'&masExam_Id='+masExam_Id+'&folderName='+folderName);
	submitForm('appointmentUpload','/hms/hms/mis?method=viewUploadDocumentsDetails&folderName='+folderName);
}
	
	function removeRow()
	{
	  var tbl = document.getElementById('uploadGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('uploadCount');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hdb');
	  	hdb.value=iteration
	  }
	}

	
	
	
		
</script>
</form>
<!--Main div end-->


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
	List<Patient>patientList=new ArrayList<Patient>();
	List<Inpatient>inpatientList=new ArrayList<Inpatient>();
	List<Visit>visitList=new ArrayList<Visit>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTimeWithoutSc");
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
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message %>
</div>
</div>

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
	if(map.get("patientList")!=null)
	{
		patientList=(List<Patient>)map.get("patientList");	
	}
	if(map.get("inpatientList")!=null)
	{
		inpatientList=(List<Inpatient>)map.get("inpatientList");	
	}
	if(map.get("visitList")!=null)
	{
		visitList=(List<Visit>)map.get("visitList");	
	}
	int visitId=0;
	if(map.get("visitId")!=null)
	{
		visitId=(Integer)map.get("visitId");
	}
	int token = 0;
	if(map.get("token")!=null)
	{
		token=(Integer)map.get("token");
	}
	String backFlag = "";
	if(map.get("backFlag")!=null)
	{
		backFlag=(String)map.get("backFlag");
	}
	int inpatientId=0;
	if(map.get("inpatientId")!=null)
	{
		inpatientId=(Integer)map.get("inpatientId");
	}
	
	List patientDataList = new ArrayList();
	
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}	
	
	Map<String,Object> mapForDS= new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String consultationDate = (String)utilMap.get("currentDate");	 
	String consultationTime = (String)utilMap.get("currentTime");

	Patient patient = null;
	String age = "";
	String servicePersonName="";
	String patientName="";
	String doctorName="";
	int departmentId = 0;
	System.out.println("inpatientList.size() --"+inpatientList.size() );
	if(patientDataList.size() > 0){
		Visit visit=(Visit)patientDataList.get(0);
		int hinId=visit.getHin().getId();
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
		String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		departmentId = visit.getDepartment().getId();
		String departmentName=visit.getDepartment().getDepartmentName();
		if(visit.getHin().getSFirstName()!= null){
		servicePersonName=visit.getHin().getSFirstName();
		}
		if(visit.getHin().getSMiddleName()!= null){
			servicePersonName=servicePersonName+" "+visit.getHin().getSMiddleName();
		}
		if(visit.getHin().getSLastName()!= null){
			servicePersonName=servicePersonName+" "+visit.getHin().getSLastName();
		}
		if(visit.getDoctor().getFirstName()!= null){
		doctorName=visit.getDoctor().getFirstName();
		}
		if(visit.getDoctor().getMiddleName()!= null){
			doctorName=doctorName+" "+visit.getDoctor().getMiddleName();
		}
		if(visit.getDoctor().getLastName()!= null){
			doctorName=doctorName+" "+visit.getDoctor().getLastName();
		}
		age = visit.getHin().getAge();
		}else if(inpatientList.size() > 0){

			Inpatient inpatient=(Inpatient)inpatientList.get(0);
			int hinId=inpatient.getHin().getId();
			patient = (Patient) inpatient.getHin();
		
			if(patient.getPFirstName()!= null){
			patientName=patient.getPFirstName();
			}
			if(patient.getPMiddleName()!= null){
			patientName=patientName+" "+patient.getPMiddleName();
			}
			if(patient.getPLastName()!= null){
			patientName=patientName+" "+patient.getPLastName();
			}
			String admissionDateInString =HMSUtil.changeDateToddMMyyyy(inpatient.getDateOfAddmission());
			if(patient.getSFirstName()!= null){
			servicePersonName=patient.getSFirstName();
			}
			if(patient.getSMiddleName()!= null){
				servicePersonName=servicePersonName+" "+patient.getSMiddleName();
			}
			if(patient.getSLastName()!= null){
				servicePersonName=servicePersonName+" "+patient.getSLastName();
			}
			if(inpatient.getDoctor().getFirstName()!= null){
			doctorName=inpatient.getDoctor().getRank().getRankName();
				doctorName+=" "+inpatient.getDoctor().getFirstName();
			}
			if(inpatient.getDoctor().getMiddleName()!= null){
				doctorName=doctorName+" "+inpatient.getDoctor().getMiddleName();
			}
			if(inpatient.getDoctor().getLastName()!= null){
				doctorName=doctorName+" "+inpatient.getDoctor().getLastName();
			}
			age = inpatient.getAge();
			
		}
	%>


<!--main content placeholder starts here-->

<form name="appointmentUpload" method="post" enctype="multipart/form-data">

<h4>Upload Documents</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>

<!--Block One Starts-->


<div class="Block">
<div class="Clear"></div>


 <label>Service No.</label>
  <%if(!patient.getServiceNo().equals("")&& !patient.getServiceNo().equals(null)){ %>
<label class="value"><%=patient.getServiceNo() %></label>
 <%}else{ %>
<label class="valuemedium">-</label>
 <%} %>
  
 <label> Name</label>
  <%if(servicePersonName != null){ %>
   <label class="value"><%=servicePersonName %></label>
    <%}else{ %>
     <label class="value">-</label>
<%} %>


<label >Relation</label>
 <%if(patient.getRelation() != null){ %>
<label class="value"><%=patient.getRelation().getRelationName() %></label>
<%}else{ %>
 <label class="value">-</label>
  <%} %> 
  <div class="Clear"></div>
  
  <label>Rank</label> 
  <%if(patient.getRank()!= null){ %>
   <label class="value"><%=patient.getRank().getRankName() %></label>
<%}else{ %> 
<label>-</label> 
<%} %> 
  <label>Patient Name </label> 
 <%if(patientName!= null){ %> 
 <label class="value"><%=patientName %></label>
 <%}else{ %> 
 <label class="value">- </label>
  <%} %>
<%-- <label>Unit</label>
 <%if(patient.getUnit()!= null){ %>
  <label class="value"><%=patient.getUnit().getUnitName() %></label>
<%}else{ %>
 <label>-</label>
  <%} %>  --%>

  <label>Age</label>
    <%if(age!= null){ %>
<label class="value"><%=age %></label>
 <%}else{ %> 
 <label>-</label>
  <%} %>
  
  <label>Medical Officer</label>
<label class="value"><%=doctorName %></label>
<div class="Clear"></div>


<%if(patient.getHinNo()!= null){ %>

<input type="hidden" name="hin_no" id="hin_no" value="<%=patient.getHinNo() %>" />
<%} %>



<div class="Clear"></div>
</div>


<!--Main div starts-->
 <input type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>" />
 <input id="visitId" name="visitId" type="hidden" value="<%=visitId%>" readonly="readonly" />
 <input id="inpatientId" name="inpatientId" type="hidden" value="<%=inpatientId%>" readonly="readonly" />
 <input type="hidden" name="deptId" size="5" value="<%=deptId%>" />
  <input type="hidden" name="date" size="5" value="<%=date%>" /> 
  <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" class="textbox_size20" readonly="readonly" MAXLENGTH="8"  tabindex=3 />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" class="textbox_size20" readonly="readonly" tabindex=3 />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" class="textbox_size20" readonly="readonly" tabindex=3 />

<div class="Clear"></div>

<input type="hidden" name="flag" value="upload" id="flag">
<%if(patientDataList!=null && patientDataList.size()>0){ 
		
%>
  <input type="hidden" name="visitId" id="visitId" value="<%=visitId %>" />
 <input id="hinNo" name="hinNo" type="hidden" value="<%=patient.getHinNo()%>" readonly="readonly" />
  <input name="hin" type="hidden" value="<%=patient.getId()%>" />
   
   <%if(patient.getPFirstName()!=null){ %>
     <input name="patientName" type="hidden" value="<%=patient.getPFirstName()%>" readonly="readonly" />
	 <%}else{%>
 <input name="patientName" type="hidden" value="" readonly="readonly" />
  <%}%> 
  <input name="age" size="10" type="hidden" value="<%=HMSUtil.calculateAge(patient.getAge() , patient.getRegDate(), patient.getDateOfBirth()) %>" readonly="readonly" />
  
  <input name="sex" type="hidden" value="<%=patient.getSex().getAdministrativeSexName() %>"  />

   <input type="hidden" name="flag1" value="" id="flag1" />
    <input type="hidden" name="hinId" value="<%=patient.getId() %>" />
	<%} %> <%
	if(inpatientList!=null && inpatientList.size()>0){ 
	
%>
 <input name="age" size="10" type="hidden" value="<%=HMSUtil.calculateAge(inpatientList.get(0).getHin().getAge() , inpatientList.get(0).getHin().getRegDate(), inpatientList.get(0).getHin().getDateOfBirth()) %>" readonly="readonly" />
      <input type="hidden" name="hinId" value="<%=inpatientList.get(0).getHin().getId() %>" />
  <input id="adNo" name="adNo" type="hidden" value="<%=inpatientList.get(0).getAdNo()%>" readonly="readonly" /> 
<input name="inpatientId" type="hidden" value="<%=inpatientList.get(0).getId()%>" />
   <input name="sex" type="hidden" value="<%=inpatientList.get(0).getHin().getSex().getAdministrativeSexName() %>"  />
<%if(inpatientList.get(0).getHin().getPFirstName()!=null){ %>
 <input name="patientName" type="hidden" value="<%=inpatientList.get(0).getHin().getPFirstName()%>"
	readonly="readonly" />
	 <%}else{%>
<input name="patientName" type="hidden" value="" readonly="readonly" /> 
	<%}%> 
   <input type="hidden" name="flag1" value="" id="flag1" /> 
   <%} %>


<div class="Clear"></div>
<%int inc=1; %>

<table border="0" cellspacing="0" cellpadding="0" id="uploadGrid">
	<tr>
		<th></th>
		<th scope="col">Files:</th>
		<th scope="col">Description:</th>
		<th scope="col">Add</th>
			<th scope="col">Delete</th>
	</tr>
	<tr>
		<td><label><%=inc%></label></td>
		<td><input type="file" name="<%=UPLOAD_FILENAME + inc%>"
			id="attachment1" class="Browse" onkeypress="javascript:return false;"
			onkeydown="javascript:return false;" />
			
			</td>
		<td><input type="text" name="<%=DESCRIPTION + inc%>"
			id="description1" /></td>
			<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
			</td>
	</tr>
<%-- 	<%inc++; %>--%>
	<%-- <tr>
		<td><label><%=inc%></label></td>
		<td><input type="file" name="<%=UPLOAD_FILENAME + inc %>"
			id="attachment2" class="Browse" onkeypress="javascript:return false;"
			onkeydown="javascript:return false;" /></td>
		<td><input type="text" name="<%=DESCRIPTION + inc%>"
			id="description2" /></td>
	</tr>
	<%inc++; %>
	<tr>
		<td><label><%=inc%></label></td>
		<td><input type="file" name="<%=UPLOAD_FILENAME + inc %>"
			id="attachment3" class="Browse" onkeypress="javascript:return false;"
			onkeydown="javascript:return false;" /></td>
		<td><input type="text" name="<%=DESCRIPTION + inc%>"
			id="description3" /></td>
	</tr>
	<%inc++; %>
	<tr>
		<td><label><%=inc%></label></td>
		<td><input type="file" name="<%=UPLOAD_FILENAME + inc %>"
			id="attachment4" class="Browse" onkeypress="javascript:return false;"
			onkeydown="javascript:return false;" /></td>
		<td><input type="text" name="<%=DESCRIPTION + inc%>"
			id="description4" /></td>
	</tr>
	<%inc++; %>
	<tr>
		<td><label><%=inc%></label></td>
		<td><input type="file" name="<%=UPLOAD_FILENAME + inc %>"
			id="attachment5" class="Browse" onkeypress="javascript:return false;"
			onkeydown="javascript:return false;" /></td>
		<td><input type="text" name="<%=DESCRIPTION + inc%>"
			id="description5" /></td>
	</tr>--%>

</table>
<input type="hidden" name="uploadCount" value="<%=inc %>" id="uploadCount" />
<%%>
<div class="Clear"></div>
<div class="paddingTop15"></div>

<div class="Clear"></div>
<input type="button" class="button" name="impbutton" value="Attach"
	onClick="jsImport(<%=visitId %>)" /> 
<input type="button"
	class="buttonBig" name="impbutton" value="View Documents"
	onClick="viewPatientDocuments();" /> 	
<%
if(visitId!=0){
%>
<%if(backFlag.equals("OPD") || backFlag.equals("dental")|| backFlag.equals("fp")){ %>
<!--<input name="Back" type="button"
	src="images/phaseII/delete.gif" alt="Back" value="Back"
	class="button"
	onclick="submitForm('appointmentUpload','opd?method=showOPDMainJsp&visitId=<%=visitId%>&deptId=<%=departmentId%>&token=<%=token%>');"
	align="right" />-->
	<input name="close" type="button" value="close" class="button" onclick="window.close();"/>
	
	<%} %>
<%}else if(inpatientId!=0){ %>
<input type="button" class="button" value="Back" onClick="submitForm('appointmentUpload','ipd?method=showPatientListJsp');" />

<%} %>
<div class="Clear"></div>

<!--
<input type="file" name="" id="attachment" class="Browse" onkeypress="javascript:return false;" onkeydown="javascript:return false;" 
onchange="document.getElementById('moreUploadsLink').style.display = 'block';"/>
<div id="moreUploads"><br/></div>
<div id="moreUploadsLink" style="display:none;"><a href="javascript:addFileInput();">Attach another File</a></div>
<br/>
<input type="button" class="cmnButton" name="impbutton" value="Attach" onClick="jsImport()"/>
-->
<div class="Clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>
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

function jsImport(visitId1)
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
	var hospitalId =  document.appointmentUpload.hospitalId.value;
	var deptId = document.appointmentUpload.deptId.value;
	document.appointmentUpload.method="post";
	submitForm('appointmentUpload','opd?method=submitUploadDocuments'+fileNames + '&<%=CHANGED_BY%>=' + changed_by + '&<%=CHANGED_DATE%>=' + changed_date + '&<%=CHANGED_TIME%>=' + changed_time + '&hospitalId=' + hospitalId + '&deptId=' + deptId+'&visitId='+visitId1+'&uploadCount='+inc);
	//submitForm('appointmentUpload','opd?method=submitUploadDocuments&filename1='+filename1+'&filename2='+filename2+'&filename3='+filename3+'&filename4='+filename4+'&filename5='+filename5 + '&<%=CHANGED_BY%>=' + changed_by + '&<%=CHANGED_DATE%>=' + changed_date + '&<%=CHANGED_TIME%>=' + changed_time + '&hospitalId=' + hospitalId + '&deptId=' + deptId+'&visitId='+visitId1);
}

	function createSoftCopy()
	{

		appointmentUpload.method="post";
		submitForm('appointmentUpload','opd?method=viewUploadDocuments');
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

	
	function viewPatientDocuments()
	{
		var num;
		document.getElementById('flag1').value="viewDocuments";
		var hin_no ='';
		var visitId =0;
		if(document.getElementById("visitId") && document.getElementById("hinNo")){
			visitId = document.getElementById("visitId").value;
			hin_no =document.getElementById("hinNo").value ;
			num=document.getElementById("hinNo").value;
		
		}
		else if(document.getElementById("adNo")!=null)
			num=document.getElementById("adNo").value;
			
				submitForm('appointmentUpload','opd?method=viewPatientDetails&flag1=viewDocuments&fieldValue='+num+'&hin_no='+hin_no+'&visitId='+visitId,'mywindow');
		
		
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
</div>
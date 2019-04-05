
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/phaseII.css" />
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

<link href="css/hms_style.css" rel="stylesheet" type="text/css">

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

<script language="javascript">

function jsImport()
{
	if (appointmentUpload.upload_filename1.value=="" && appointmentUpload.upload_filename2.value==""
		&& appointmentUpload.upload_filename3.value=="" && appointmentUpload.upload_filename4.value==""
		&& appointmentUpload.upload_filename5.value=="" )
	{
	alert('Pl. Select a file to Import!.....');
	return;
	}
	var fname1 = appointmentUpload.upload_filename1.value;
	var fname2 = appointmentUpload.upload_filename2.value;
	var fname3 = appointmentUpload.upload_filename3.value;
	var fname4 = appointmentUpload.upload_filename4.value;
	var fname5 = appointmentUpload.upload_filename5.value;
	//var st = fname.length;
	//st = st-3;
	//if (fname.substring(st)!="zip")
	//{
	//alert('Only zip files are Allowed. Please Zip all the Excel Files and Give the file as input !....For further Help, Refer User Manual.');
	//return;
	//}
	var ind1 = fname1.lastIndexOf("\\");
	var ind2 = fname2.lastIndexOf("\\");
	var ind3 = fname3.lastIndexOf("\\");
	var ind4 = fname4.lastIndexOf("\\");
	var ind5 = fname5.lastIndexOf("\\");
	var filename1 = fname1.substring(ind1+1);
	var filename2 = fname2.substring(ind2+1);
	var filename3 = fname3.substring(ind3+1);
	var filename4 = fname4.substring(ind4+1);
	var filename5 = fname5.substring(ind5+1);
	
	var changed_by = appointmentUpload.<%=CHANGED_BY%>.value; 
	var changed_date = appointmentUpload.<%=CHANGED_DATE%>.value;
	var changed_time = appointmentUpload.<%=CHANGED_TIME%>.value;
	var hospitalId =  appointmentUpload.hospitalId.value;
	var deptId = appointmentUpload.deptId.value;
	
	appointmentUpload.method="post";

	submitForm('appointmentUpload','mrd?method=submitUploadDocuments&filename1='+filename1+'&filename2='+filename2+'&filename3='+filename3+'&filename4='+filename4+'&filename5='+filename5 + '&<%=CHANGED_BY%>=' + changed_by + '&<%=CHANGED_DATE%>=' + changed_date + '&<%=CHANGED_TIME%>=' + changed_time + '&hospitalId=' + hospitalId + '&deptId=' + deptId);
}

	function createSoftCopy()
	{

		appointmentUpload.method="post";
		submitForm('appointmentUpload','mrd?method=viewUploadDocuments');
	}
	
	function viewPatientDocuments()
	{
		var num;
		document.getElementById('flag1').value="viewDocuments";
		if(document.getElementById("hinNo")!=null)
			num=document.getElementById("hinNo").value;
		else if(document.getElementById("adNo")!=null)
			num=document.getElementById("adNo").value;
		window.open('mrd?method=viewPatientDetails&flag1=viewDocuments&fieldValue='+num,'mywindow','location=1,status=1,scrollbars=1,width=500,height=300');
		
	}
	function clearValue()
	{
		if(document.getElementById('flag1')!=null)
			document.getElementById('flag1').value="";
		return true;
	}
		
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
	System.out.println("inpatientList.size()=="+inpatientList.size());
	System.out.println("patientList.size()=="+patientList.size());

	
	List patientDataList = new ArrayList();
	
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}			
	Visit visit=(Visit)patientDataList.get(0);
	int hinId=visit.getHin().getId();
	Patient patient = null;
	patient = (Patient) visit.getHin();
	System.out.print("patient--->"+patient.getHinNo());
	
%>

<!--Main div starts-->
<div id="contentHolder">
<form name="appointmentUpload" method="post"
	enctype="multipart/form-data">
<div class="blockFrame"><input type="hidden" name="hospitalId"
	size="5" value="<%=hospitalId%>" /> <input type="hidden" name="deptId"
	size="5" value="<%=deptId%>" /> <input type="hidden" name="date"
	size="5" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" class="textbox_size20"
	readonly="readonly" MAXLENGTH="8" / tabindex=3 />
</td>
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"
	class="textbox_size20" readonly="readonly" tabindex=3 />
</td>
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 />
</td>

<div class="Clear"></div>
<div class="division"><input type="hidden" name="flag"
	value="upload" id="flag"> <label class="noWidth">&nbsp;&nbsp;HIN
No. or AD No.</label> <input name="inputField" type="text"
	value="<%=patient.getHinNo() %>"
	onblur="if(this.value)submitForm('appointmentUpload','mrd?method=viewPatientDetails','clearValue');" />
<div class="Clear"></div>

</div>
</div>
<%if(patientList!=null && patientList.size()>0){ 
		System.out.println("enterd in if");
%> <label class="medium">Hin No.</label> <input id="hinNo" name="hinNo"
	type="text" value="<%=patient.getHinNo()%>" readonly="readonly" /> <input
	name="hin" type="hidden" value="<%=patientList.get(0).getId()%>" /> <label
	class="medium">Name</label> <%if(patientList.get(0).getPFirstName()!=null){ %>
<input name="patientName" type="text"
	value="<%=patientList.get(0).getPFirstName()%>" readonly="readonly" />
<%}else{%> <input name="patientName" type="text" value=""
	readonly="readonly" /> <%}%> <label class="medium">Age</label> <%if(patientList.get(0).getAge()!=null){ %>
<input name="age" size="8" type="text" class="small"
	value="<%=patientList.get(0).getAge() %>" readonly="readonly" /> <%}else{%>
<input name="age" size="8" type="text" class="small" value=""
	readonly="readonly" /> <%} %>
<div class="Clear"></div>

<label class="medium">Sex </label> <%if(patientList.get(0).getSex()!=null){ %>
<input name="sex" type="text"
	value="<%=patientList.get(0).getSex().getAdministrativeSexName() %>"
	readonly="readonly" /> <%}else { %> <input name="sex" type="text"
	value="" readonly="readonly" /> <%} %> <label class="medium">Address
</label> <%if(patientList.get(0).getAddress()!=null){ %> <input name="address"
	type="text" value="<%=patientList.get(0).getAddress() %>"
	readonly="readonly" /> <%}else{ %> <input name="address" type="text"
	value="" readonly="readonly" /> <%} %> <input type="hidden" name="flag1"
	value="" id="flag1" /> <input type="hidden" name="hinId"
	value="<%=patientList.get(0).getId() %>" /> <input type="hidden"
	name="hinNo" value="<%=patientList.get(0).getHinNo() %>" /> <input
	type="button" class="cmnButton" name="impbutton" value="View Documents"
	onClick="viewPatientDocuments();" /> <%} %> <%if(inpatientList!=null && inpatientList.size()>0){ 
	
%> <label class="medium">Ad No.</label> <input id="adNo" name="adNo"
	type="text" value="<%=inpatientList.get(0).getAdNo()%>"
	readonly="readonly" /> <input name="inpatientId" type="hidden"
	value="<%=inpatientList.get(0).getId()%>" /> <label class="medium">Name</label>
<%if(inpatientList.get(0).getHin().getPFirstName()!=null){ %> <input
	name="patientName" type="text"
	value="<%=inpatientList.get(0).getHin().getPFirstName()%>"
	readonly="readonly" /> <%}else{%> <input name="patientName" type="text"
	value="" readonly="readonly" /> <%}%> <label class="medium">Age</label> <%if(inpatientList.get(0).getHin().getAge()!=null){ %>
<input name="age" type="text" size="8"
	value="<%=inpatientList.get(0).getHin().getAge() %>"
	readonly="readonly" /> <%}else{%> <input name="age" type="text" size="8"
	value="" readonly="readonly" /> <%} %>
<div class="Clear"></div>

<label class="medium">Sex </label> <%if(inpatientList.get(0).getHin().getSex()!=null){ %>
<input name="sex" type="text"
	value="<%=inpatientList.get(0).getHin().getSex().getAdministrativeSexName() %>"
	readonly="readonly" /> <%}else { %> <input name="sex" type="text"
	value="" readonly="readonly" /> <%} %> <label class="medium">Address
</label> <%if(inpatientList.get(0).getHin().getAddress()!=null){ %> <input
	name="address" type="text"
	value="<%=inpatientList.get(0).getHin().getAddress() %>"
	readonly="readonly" /> <%}else{ %> <input name="address" type="text"
	value="" readonly="readonly" /> <%} %> <input type="hidden" name="flag1"
	value="" id="flag1" /> <input type="button" class="cmnButton"
	name="impbutton" value="View Documents"
	onClick="viewPatientDocuments();" /> <%} %>


<div class="Clear"></div>
<%int inc=1; %>
<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th></th>
		<th scope="col">Files:</th>
		<th scope="col">Description:</th>
	</tr>
	<tr>
		<td><label><%=inc%></label></td>
		<td><input type="file" name="<%=UPLOAD_FILENAME + inc%>"
			id="attachment1" class="Browse" onkeypress="javascript:return false;"
			onkeydown="javascript:return false;" /></td>
		<td><input type="text" name="<%=DESCRIPTION + inc%>"
			id="description1" /></td>
	</tr>
	<%inc++; %>
	<tr>
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
	</tr>

</table>
</div>
<div class="Clear"></div>
<input type="button" class="cmnButton" name="impbutton" value="Attach"
	onClick="jsImport()" />
<div class="Clear"></div>

<!--
<input type="file" name="" id="attachment" class="Browse" onkeypress="javascript:return false;" onkeydown="javascript:return false;" 
onchange="document.getElementById('moreUploadsLink').style.display = 'block';"/>
<div id="moreUploads"><br/></div>
<div id="moreUploadsLink" style="display:none;"><a href="javascript:addFileInput();">Attach another File</a></div>
<br/>
<input type="button" class="cmnButton" name="impbutton" value="Attach" onClick="jsImport()"/>
-->
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<!--Main div starts--> <script type="text/javascript">
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

</script></form>

</div>
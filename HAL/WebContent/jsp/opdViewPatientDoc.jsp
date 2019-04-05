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
	

	//window.onload =clearUploadDirectory();
	///window.onunload=clearUploadDirectory();
	
	function clearUploadDirectory()
	{
	
		submitForm('viewDocuments','opd?method=removeFilesInUploadFolder');
	}
</script>



<%
	String date = "";
	String time = "";
	String userName = "";
	String imageUrl="";
	String [] files =null;
	int hospitalId = 0;
	int deptId = 0;
	Box box = HMSUtil.getBox(request);
	Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map")!=null)
	{
		map=(Map)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<UploadDocuments>patientList=new ArrayList<UploadDocuments>();
	List<UploadDocuments>inpatientList=new ArrayList<UploadDocuments>();
	List<Visit>visitList=new ArrayList<Visit>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 	if(map.get("imageUrl")!=null)
 	{
 		imageUrl=(String)map.get("imageUrl");
 	}
 	System.out.println("imageUrl====="+imageUrl);
 	
  	//Map map = new HashMap();
	String message = null;
	if(map.get("files")!=null){
		files=(String[])map.get("files");
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
		patientList=(List<UploadDocuments>)map.get("patientList");	
	}
	System.out.println("patientList in jsp======"+patientList.size());
	if(map.get("inpatientList")!=null)
	{
		inpatientList=(List<UploadDocuments>)map.get("inpatientList");	
	}
	

%>

<!--Main div starts-->

<h4>View Document</h4>
<form name="viewDocuments" method="post" enctype="multipart/form-data">
<div class="Clear"></div>
<input type="hidden" name="flag" value="view" id="flag">
<div class="Clear"></div>

<div class="Block">
<input type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>" /> 
<input type="hidden" name="deptId" size="5" value="<%=deptId%>" />
 <input type="hidden" name="date" size="5" value="<%=date%>" />
 <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" class="textbox_size20" readonly="readonly" MAXLENGTH="8"  tabindex=3 />
 <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" class="textbox_size20" readonly="readonly" tabindex=3 /> 
	<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" class="textbox_size20" readonly="readonly" tabindex=3 />
	 <%if(patientList!=null && patientList.size()>0){ 
%> <label>Service No.</label>
 <input name="hinNo" type="text" value="<%=patientList.get(0).getHin().getServiceNo()%>" readonly="readonly" />
<input name="hin" type="hidden" value="<%=patientList.get(0).getHin().getId()%>" /> 
<label>Name</label>
 <%if(patientList.get(0).getPatientName()!=null){ %>
<input name="patientName" type="text" value="<%=patientList.get(0).getPatientName()%>" readonly="readonly" />
<%}else{%>
 <input name="patientName" type="text" value="" readonly="readonly" />
  <%}%> 
  <label>Relation </label>
 <%if(patientList.get(0).getHin().getRelation() !=null){ %>
<input name="sex" type="text" value="<%=patientList.get(0).getHin().getRelation().getRelationName() %>" readonly="readonly" />
	 <%}else { %>
<input name="sex" type="text" value="" readonly="readonly" />
 <%} %>
  <label>Age</label>
   <%if(patientList.get(0).getAge()!=null){ %>
<input name="age" type="text" value="<%=patientList.get(0).getAge() %>" readonly="readonly" />
 <%}else{%>
  <input name="age" type="text" value="" readonly="readonly" /> 
  <%} %>
<div class="Clear"></div>


  <label>Address</label>
 <%if(patientList.get(0).getAddress()!=null){ %> 
 <input name="address" type="text" value="<%=patientList.get(0).getAddress() %>"
	readonly="readonly" /> 
	<%}else{ %>
	 <input name="address" type="text" value="" readonly="readonly" />
	  <%} %> <%} %>
	   <%if(inpatientList!=null && inpatientList.size()>0){ 
	%>
 <label>Ad No.</label>
  <input name="adNo" type="text" value="<%=inpatientList.get(0).getInpatient().getAdNo()%>" readonly="readonly" /> 
	<input name="inpatient" type="hidden" value="<%=inpatientList.get(0).getInpatient().getId()%>" />
 <label>Name</label>
  <%if(inpatientList.get(0).getPatientName()!=null){ %>
<input name="patientName" type="text" value="<%=inpatientList.get(0).getPatientName()%>" readonly="readonly" />
<%}else{%>
 <input name="patientName" type="text" value="" readonly="readonly" /> 
 <%}%>
  <label>Age</label>
   <%if(inpatientList.get(0).getAge()!=null){ %>
<input name="age" type="text" size="8" value="<%=inpatientList.get(0).getAge() %>" readonly="readonly" /> 
<%}else{%>
<input name="age" type="text" size="8" value="" readonly="readonly" />
 <%} %>
<div class="Clear"></div>

<label>Sex </label> <%if(inpatientList.get(0).getSex()!=null){ %>
<input name="sex" type="text" value="<%=inpatientList.get(0).getSex() %>" readonly="readonly" />
 <%}else { %>
<input name="sex" type="text" value="" readonly="readonly" /> 
<%} %> 
<label>Address </label>
 <%if(inpatientList.get(0).getAddress()!=null){ %>
<input name="address" type="text" value="<%=inpatientList.get(0).getAddress() %>" readonly="readonly" />
<%}else{ %> 
<input name="address" type="text" value="" readonly="readonly" />
<%} %>
 <%} %>
</div>

<div class="division"></div>

<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">Sl. No.</th>
		<th scope="col">Upload Date</th>
		<th scope="col">File Name</th>
		<th scope="col">Document</th>
		<th scope="col">Description</th>
	</tr>
	<%if(inpatientList!=null && inpatientList.size()>0){ 
		//for(int i=0;i<inpatientList.size();i++){
		for(int i=0;i<files.length;i++){	
	%>
	<tr>
		<td><%=i+1 %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(inpatientList.get(i).getUploadDate())%></td>
		<td><a
			href="opd?method=viewPatientDocuments&filename=<%=files[i] %>"><%=files[i]%>
		</a></td>
		<td><img
			src="../upload//<%=patientList.get(0).getHin().getHinNo()+"/"+files[i]%>"
			alt="/" width="50px" height="50px" /></td>
		<%if(inpatientList.get(i).getDescription()!=null){ %>
		<td><%=inpatientList.get(i).getDescription()%></td>
		<%}else{%>
		<td>-</td>
		<%} %>
	</tr>
	<%		}
		}
	%>
	<%
		System.out.println("files.length----"+files.length);
		%>
	<%
	
	if(patientList!=null && patientList.size()>0){ 
		for(int i=0;i<patientList.size();i++){
		//for(int i=0;i<files.length;i++){	
	%>
	<tr>
		<td><%=i+1%></td>
		
		<td><%=HMSUtil.convertDateToStringWithoutTime(patientList.get(i).getUploadDate())%></td>
		<td><a
			href="opd?method=viewPatientDocuments&filename=<%=files[i]%>">
		<%=files[i]%>
		</a></td>
		<td><img
			src="../upload//<%=patientList.get(0).getHin().getHinNo()+"/"+files[0]%>"
			alt="/" width="50px" height="50px" /></td>
		<%if(patientList.get(i).getDescription()!=null){ %>
		<td><%=patientList.get(i).getDescription()%></td>
		<%}else{%>
		<td>-</td>
		<%} %>
	</tr>
	<%		}
		}%>
</table>


<div class="bottom"><input name="" type="button" class="button"
	value="Back" onClick="history.back();" /></div>
</form>

<!--Main div starts-->
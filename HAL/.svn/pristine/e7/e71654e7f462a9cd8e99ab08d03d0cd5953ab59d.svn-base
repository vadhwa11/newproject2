<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">

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
	
	Box box = HMSUtil.getBox(request);
	System.out.println("box inside jsp" + box);
	
	
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
		}
 	
  	Map map = new HashMap();
  	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
	
	if (session.getAttribute("hospitalId") != null) 
	{
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}

	int pageno=1;
	int totalPages=0;
	int totalRecords = 0;
	if (map.get("pageno")!=null)
	{
		 pageno = Integer.parseInt(map.get("pageno").toString());
		 System.out.println("pageno in jsp " + pageno);
	}
	
	if (map.get("totalPages")!=null)
	{
		 totalPages = Integer.parseInt(map.get("totalPages").toString());
	}
	
	if (map.get("totalRecords")!=null)
	{
		totalRecords = Integer.parseInt(map.get("totalRecords").toString());
	}

	List<HrDutyEntry>nightDutyList=new ArrayList<HrDutyEntry>();
	List<HrGuardDutyEntry> guardDutyList = new ArrayList<HrGuardDutyEntry>();
	List<HrWardDutyEntry> wardDutyList = new ArrayList<HrWardDutyEntry>();
	List<HrOrderlyDutyEntry> orderlyDutyList = new ArrayList<HrOrderlyDutyEntry>();
	List<HrRangeFiringDutyEntry> rangeFiringDutyList = new ArrayList<HrRangeFiringDutyEntry>();
	List<OpdHoliday>holidayList=new ArrayList<OpdHoliday>();	

	if (map.get("guardDutyList")!=null)
	{
		guardDutyList = (List)map.get("guardDutyList");
	}
	
	if (map.get("nightDutyList")!=null)
	{
		nightDutyList = (List)map.get("nightDutyList");
	}
	if (map.get("wardDutyList")!=null)
	{
		wardDutyList = (List)map.get("wardDutyList");
	}
	if (map.get("orderlyDutyList")!=null)
	{
		orderlyDutyList = (List)map.get("orderlyDutyList");
	}
	if (map.get("rangeFiringDutyList")!=null)
	{
		rangeFiringDutyList = (List)map.get("rangeFiringDutyList");
	}
	if (map.get("box")!=null)
	{
		box = (Box)map.get("box");
	}
	if (map.get("holidayList")!=null)
	{
		holidayList = (List)map.get("holidayList");
	}
	
String message ="";
%>




<script>
//this function will be called by the Bean (not from JSP)
function GoPage() {	
	var pgno = parseInt(dutyDisplay.gopage.value);
	var totalPages = parseInt(dutyDisplay.totalPages.value);
	if (pgno < 1 || pgno > totalPages)
	{
	alert('Invalid Page No!.....');
	return;
	}  
	dutyDisplay.pageno.value = pgno; 
	dutyDisplay.method="post";
	submitForm('dutyDisplay','hrRelated?method=searchDutyDisplay');
}

function goNext()
{
 var pgno = parseInt(dutyDisplay.pageno.value)+1;
 
 if (pgno > dutyDisplay.totalPages.value)
 {
 alert('End of the File Reached!... ');
 return;
 }
 
 dutyDisplay.pageno.value = pgno;
 dutyDisplay.method="post";
 submitForm('dutyDisplay','hrRelated?method=searchDutyDisplay');
}


function goPrevious()
{
 var pgno = parseInt(dutyDisplay.pageno.value)-1;
 
 if (pgno < 1)
 {
 alert('Beginning of the File Reached!... ');
 return;
 }
 
 dutyDisplay.pageno.value = pgno;
 dutyDisplay.method="post";
 submitForm('dutyDisplay','hrRelated?method=searchDutyDisplay');
}

function jsSearch()
{
	if(document.getElementById('searchServiceNo').value=="" && document.getElementById('searchName').value=="")
	{
		alert("Please enter either Service No. or Employee Name");
		
	}
	else
	{
		dutyDisplay.method="post";
		submitForm('dutyDisplay','hrRelated?method=searchDutyDisplay');
	}		
}			            
    
</script>


<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>

<h2><%=message %></h2>
<%} 
%>
<DIV class="Clear"></DIV>

<div id="contentHolder">
<h6>Duty display for service personnel</h6>
<div class="Clear"></div>
<form name="dutyDisplay"><input type="hidden" name="hospitalId"
	value="<%=hospitalId%>" /> <input type="hidden" name="changedBy"
	value="<%=userName%>" /> <input type="hidden" name="changedDate"
	value="<%=date%>" /> <input type="hidden" name="changedTime"
	value="<%=time%>" /> <input type="hidden" name="pageno"
	value="<%=pageno%>" /> <input type="hidden" name="totalPages"
	value="<%=totalPages%>" /> <input type="hidden" name="totalRecords"
	value="<%=totalRecords%>" /> <input type="hidden" name="numOfRows"
	value="10" /> <input type="hidden" name="quarter"
	value="<%=box.get("quarter")%>" /> <input type="hidden" name="year"
	value="<%=box.get("year")%>" />

<div class="Clear"></div>
<div class="Clear"></div>

<div class="division"></div>
<div class="blockFrame"><label>Service No.</label> <input
	type="text" name="searchServiceNo" id="searchServiceNo" value=""
	maxlength="8" /> <label> Name</label> <input type="text"
	name="searchName" id="searchName" value="" maxlength="8" /> <input
	type="button" name="search" onClick="jsSearch()" value="Search"
	class="cmnButton" /></div>

<div class="blockTitle">Next Duty Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table align="center" width="100%" colspan="7" border="0"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="10%">Service No.</th>
			<th width="10%">Name</th>
			<th width="10%">Rank</th>
			<th>Duty Date</th>
			<th>Duty on Department</th>
			<th>Duty Details</th>
			<th>From Time</th>
			<th>To Time</th>
		</tr>
	</thead>



	<%  if(nightDutyList!=null && nightDutyList.size()>0) { 
      
			    int slno = 0;
			    for(HrDutyEntry hrDutyEntry :nightDutyList){ 
			    	slno=slno+1;
	  %>
	<%	String msg="";
				if(hrDutyEntry.getEmp().getFirstName()!=null && !hrDutyEntry.getEmp().getFirstName().equals(""))
				msg +=hrDutyEntry.getEmp().getFirstName()+" ";
				if(hrDutyEntry.getEmp().getMiddleName()!=null && !hrDutyEntry.getEmp().getMiddleName().equals(""))
					msg +=hrDutyEntry.getEmp().getMiddleName()+" ";
				if(hrDutyEntry.getEmp().getLastName()!=null && !hrDutyEntry.getEmp().getLastName().equals(""))
					msg +=hrDutyEntry.getEmp().getLastName()+" ";
				%>
	<tr>
		<td><%=hrDutyEntry.getEmp().getServiceNo()%></td>
		<td><%=msg%></td>
		<td><%=hrDutyEntry.getEmp().getRank().getRankName()%></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(hrDutyEntry.getDutyDate())%></td>
		<%if(hrDutyEntry.getDepartmentId()!=null){ %>
		<td><%=hrDutyEntry.getDepartmentId().getDepartmentName() %></td>
		<%}else{ %>
		<td></td>
		<%} %>
		<td>Night Duty</td>
		<td><%=hrDutyEntry.getDutyTime().getDutyFromTime() %></td>
		<td><%=hrDutyEntry.getDutyTime().getDutyToTime() %></td>
	</tr>
	<% } 
		} %>
	<%  if(guardDutyList!=null && guardDutyList.size()>0) { 
      
			    int slno = 0;
			    for(HrGuardDutyEntry hrGuardDutyEntry :guardDutyList){ 
			    	slno=slno+1;
	  %>
	<%	String msg="";
				if(hrGuardDutyEntry.getEmp().getFirstName()!=null && !hrGuardDutyEntry.getEmp().getFirstName().equals(""))
				msg +=hrGuardDutyEntry.getEmp().getFirstName()+" ";
				if(hrGuardDutyEntry.getEmp().getMiddleName()!=null && !hrGuardDutyEntry.getEmp().getMiddleName().equals(""))
					msg +=hrGuardDutyEntry.getEmp().getMiddleName()+" ";
				if(hrGuardDutyEntry.getEmp().getLastName()!=null && !hrGuardDutyEntry.getEmp().getLastName().equals(""))
					msg +=hrGuardDutyEntry.getEmp().getLastName()+" ";
				%>
	<tr>
		<td><%=hrGuardDutyEntry.getEmp().getServiceNo()%></td>
		<td><%=msg%></td>
		<td><%=hrGuardDutyEntry.getEmp().getRank().getRankName()%></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(hrGuardDutyEntry.getDutyDate())%></td>
		<%if(hrGuardDutyEntry.getDepartmentId()!=null){ %>
		<td><%=hrGuardDutyEntry.getDepartmentId().getDepartmentName() %></td>
		<%}else{ %>
		<td></td>
		<%} %>
		<td>Guard Duty</td>
		<td><%=hrGuardDutyEntry.getDutyTime().getDutyFromTime() %></td>
		<td><%=hrGuardDutyEntry.getDutyTime().getDutyToTime() %></td>
	</tr>
	<% } 
		} %>
	<%  if(wardDutyList!=null && wardDutyList.size()>0) { 
      
			    int slno = 0;
			    for(HrWardDutyEntry hrWardDutyEntry :wardDutyList){ 
			    	slno=slno+1;
	  %>
	<%	String msg="";
				if(hrWardDutyEntry.getEmp().getFirstName()!=null && !hrWardDutyEntry.getEmp().getFirstName().equals(""))
				msg +=hrWardDutyEntry.getEmp().getFirstName()+" ";
				if(hrWardDutyEntry.getEmp().getMiddleName()!=null && !hrWardDutyEntry.getEmp().getMiddleName().equals(""))
					msg +=hrWardDutyEntry.getEmp().getMiddleName()+" ";
				if(hrWardDutyEntry.getEmp().getLastName()!=null && !hrWardDutyEntry.getEmp().getLastName().equals(""))
					msg +=hrWardDutyEntry.getEmp().getLastName()+" ";
				%>
	<tr>
		<td><%=hrWardDutyEntry.getEmp().getServiceNo()%></td>
		<td><%=msg%></td>
		<td><%=hrWardDutyEntry.getEmp().getRank().getRankName()%></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(hrWardDutyEntry.getDutyDate())%></td>
		<%if(hrWardDutyEntry.getDepartmentId()!=null){ %>
		<td><%=hrWardDutyEntry.getDepartmentId().getDepartmentName() %></td>
		<%}else{ %>
		<td></td>
		<%} %>
		<td>Ward Duty</td>
		<td><%=hrWardDutyEntry.getDutyTime().getDutyFromTime() %></td>
		<td><%=hrWardDutyEntry.getDutyTime().getDutyToTime() %></td>
	</tr>
	<% } 
		} %>
	<%  if(orderlyDutyList!=null && orderlyDutyList.size()>0) { 
      
			    int slno = 0;
			    for(HrOrderlyDutyEntry hrOrderlyDutyEntry :orderlyDutyList){ 
			    	slno=slno+1;
	  %>
	<%	String msg="";
				if(hrOrderlyDutyEntry.getEmp().getFirstName()!=null && !hrOrderlyDutyEntry.getEmp().getFirstName().equals(""))
				msg +=hrOrderlyDutyEntry.getEmp().getFirstName()+" ";
				if(hrOrderlyDutyEntry.getEmp().getMiddleName()!=null && !hrOrderlyDutyEntry.getEmp().getMiddleName().equals(""))
					msg +=hrOrderlyDutyEntry.getEmp().getMiddleName()+" ";
				if(hrOrderlyDutyEntry.getEmp().getLastName()!=null && !hrOrderlyDutyEntry.getEmp().getLastName().equals(""))
					msg +=hrOrderlyDutyEntry.getEmp().getLastName()+" ";
				%>
	<tr>
		<td><%=hrOrderlyDutyEntry.getEmp().getServiceNo()%></td>
		<td><%=msg%></td>
		<td><%=hrOrderlyDutyEntry.getEmp().getRank().getRankName()%></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(hrOrderlyDutyEntry.getDutyDate())%></td>
		<%if(hrOrderlyDutyEntry.getDepartmentId()!=null){ %>
		<td><%=hrOrderlyDutyEntry.getDepartmentId().getDepartmentName() %></td>
		<%}else{ %>
		<td></td>
		<%} %>
		<td>Orderly SGT Duty</td>
		<td><%=hrOrderlyDutyEntry.getDutyTime().getDutyFromTime() %></td>
		<td><%=hrOrderlyDutyEntry.getDutyTime().getDutyToTime() %></td>
	</tr>
	<% } 
		} %>
	<%if(orderlyDutyList.size()==0 && wardDutyList.size()==0 && guardDutyList.size()==0 && nightDutyList.size()==0){ %>

	<tbody>
		<tr>
			<td colspan=8 align="center">No Items Found</td>
		</tr>
	</tbody>
	<%} %>
</table>
</div>
<div class="Clear"></div>
<div class="division"></div>

<div class="blockTitle">Range Firing Duty Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table align="center" width="100%" colspan="7" border="0"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="10%">Service No.</th>
			<th width="10%">Name</th>
			<th width="10%">Rank</th>
			<th>Quarter</th>
			<th>Year</th>
		</tr>
	</thead>



	<%  if(rangeFiringDutyList!=null && rangeFiringDutyList.size()>0) { 
      
			    int slno = 0;
			    for(HrRangeFiringDutyEntry hrRangeFiringDutyEntry :rangeFiringDutyList){ 
			    	slno=slno+1;
	  %>
	<%	String msg="";
				if(hrRangeFiringDutyEntry.getEmployee().getFirstName()!=null && !hrRangeFiringDutyEntry.getEmployee().getFirstName().equals(""))
				msg +=hrRangeFiringDutyEntry.getEmployee().getFirstName()+" ";
				if(hrRangeFiringDutyEntry.getEmployee().getMiddleName()!=null && !hrRangeFiringDutyEntry.getEmployee().getMiddleName().equals(""))
					msg +=hrRangeFiringDutyEntry.getEmployee().getMiddleName()+" ";
				if(hrRangeFiringDutyEntry.getEmployee().getLastName()!=null && !hrRangeFiringDutyEntry.getEmployee().getLastName().equals(""))
					msg +=hrRangeFiringDutyEntry.getEmployee().getLastName()+" ";
				%>
	<tr>
		<td><%=hrRangeFiringDutyEntry.getEmployee().getServiceNo()%></td>
		<td><%=msg%></td>
		<td><%=hrRangeFiringDutyEntry.getEmployee().getRank().getRankName()%></td>
		<td><%=hrRangeFiringDutyEntry.getQaurter()%></td>
		<td><%=hrRangeFiringDutyEntry.getYear()%></td>
	</tr>
	<% } 
		}else{ %>
	<tbody>
		<tr>
			<td colspan=8 align="center">No Items Found</td>
		</tr>
	</tbody>
	<%} %>
</table>
</div>


<div class="Clear"></div>
<div id="pagination">
<% if (totalPages > 0 ) { %> Page <span class="selected"><%=pageno %></span>
of <span class="selected"><%=totalPages %></span> <a
	href="javascript:goPrevious()">Prev<<</a> <a href="javascript:goNext()">>>Next</a>
<input type="button" name="Go Page" type="submit" value="Go Page"
	class="button" onclick="javascript:GoPage();"> <input
	type="text" name="gopage" size="3" /> <% } %>
</div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=date %></label> <label>Changed
Time</label> <label class="value"><%=time %></label>
<div class="Clear"></div>
</div>
</form>
</div>



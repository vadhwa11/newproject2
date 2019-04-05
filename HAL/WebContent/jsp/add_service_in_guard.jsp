<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
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

	List employeeDetailList = new ArrayList();
	List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
	List<HrorderlyGuardDutyEntry>dutyEntryList=new ArrayList<HrorderlyGuardDutyEntry>();
	List<HrorderlyLeaveApplication>employeeLeaveList=new ArrayList<HrorderlyLeaveApplication>();
	List<OpdHoliday>holidayList=new ArrayList<OpdHoliday>();
	
	List<HrDutyExemptionEntry>dutyExemptionList=new ArrayList<HrDutyExemptionEntry>();
	List<HrorderlyLeaveApplication>onLeaveAppList=new ArrayList<HrorderlyLeaveApplication>();
	List<HrorderlyLeaveApplication>onLeaveList=new ArrayList<HrorderlyLeaveApplication>();
	if (map.get("dutyExemptionList")!=null)
	{
		dutyExemptionList = (List)map.get("dutyExemptionList");
	}
	
	if (map.get("onLeaveAppList")!=null)
	{
		onLeaveAppList = (List)map.get("onLeaveAppList");
	}

	if (map.get("employeeDetailList")!=null)
	{
		employeeDetailList = (List)map.get("employeeDetailList");
	}
	if (map.get("dutyTimeMasterList")!=null)
	{
		dutyTimeMasterList = (List)map.get("dutyTimeMasterList");
	}
	if (map.get("dutyEntryList")!=null)
	{
		dutyEntryList = (List)map.get("dutyEntryList");
	}
	if (map.get("employeeLeaveList")!=null)
	{
		employeeLeaveList = (List)map.get("employeeLeaveList");
	}
	if (map.get("onLeaveList")!=null)
	{
		onLeaveList = (List)map.get("onLeaveList");
	}
	if (map.get("holidayList")!=null)
	{
		holidayList = (List)map.get("holidayList");
	}

%>

<title>Employee Details</title>

<script>
var leaveArray=new Array();
function checkForNextDutyDate()
{
	var msg="";
			 for(var i = 0; i < document.getElementsByName('employeeToBeAdded').length; i++){
			  if(document.getElementsByName('employeeToBeAdded')[i].checked == true )
              { 
              	var dutyFrom=document.getElementsByName('nextDutyDate')[i].value;
				if(dutyFrom!="")
				{
					currentDate = new Date();
					var month = currentDate.getMonth() + 1
					var day = currentDate.getDate()
					var year = currentDate.getFullYear()
					var seperator = "/"
					currentDate = new Date(month + seperator + day + seperator + year);
					dutyFrom = new Date(dutyFrom.substring(6),(dutyFrom.substring(3,5) - 1) ,dutyFrom.substring(0,2));
					
					if(currentDate > dutyFrom)
					{	
						msg += "Next Duty Date should be greater than current date in row "+eval(i+1)+".\n"
						document.getElementsByName('nextDutyDate')[i].value="";
					}
					if(leaveArray.length>0)
					{
						for(j=0;j<leaveArray.length;j++)
						{
							if(leaveArray[j][0]==document.getElementsByName('employeeId')[i].value)
							{	
								leaveFromDate=new Date(leaveArray[j][1].substring(6),(leaveArray[j][1].substring(3,5) - 1) ,leaveArray[j][1].substring(0,2));
								dateOfReporting=new Date(leaveArray[j][2].substring(6),(leaveArray[j][2].substring(3,5) - 1) ,leaveArray[j][2].substring(0,2));
								if(dutyFrom>=leaveFromDate && dutyFrom<dateOfReporting)
								{
									msg += leaveArray[j][3]+" is on leave for "+ document.getElementsByName('nextDutyDate')[i].value +" date"+".\n"
								    document.getElementsByName('nextDutyDate')[i].value="";
									
								}
							}
						}
					}
					if(leaveArray.length>0)
					{
						for(j=0;j<leaveArray.length;j++)
						{
							if(leaveArray[j][0]==document.getElementsByName('employeeId')[i].value)
							{	
								dutyFromDate=new Date(leaveArray[j][1].substring(6),(leaveArray[j][1].substring(3,5) - 1) ,leaveArray[j][1].substring(0,2));
								dutyToDate=new Date(leaveArray[j][2].substring(6),(leaveArray[j][2].substring(3,5) - 1) ,leaveArray[j][2].substring(0,2));
								if(dutyFrom>=dutyFromDate && dutyFrom<=dutyToDate)
								{
									msg += dutyArray[j][3]+" is duty exempted for "+ document.getElementsByName('nextDutyDate')[i].value +" date"+".\n"
								    document.getElementsByName('nextDutyDate')[i].value="";
									
								}
							}
						}
					}
			
				}
				else
				{
					msg += "Please Enter Next Duty Date in row "+eval(i+1)+".\n"
				}
            }
           }  
              
       if(msg != ""){
			 	alert(msg);
			 	return false;
		}
		return true;        
   }           
//this function will be called by the Bean (not from JSP)
function GoPage() {	
	var pgno = parseInt(guardDutyAddForm.gopage.value);
	var totalPages = parseInt(guardDutyAddForm.totalPages.value);
	if (pgno < 1 || pgno > totalPages)
	{
	alert('Invalid Page No!.....');
	return;
	}  
	guardDutyAddForm.pageno.value = pgno; 
	guardDutyAddForm.method="post";
	submitForm('guardDutyAddForm','hrOrderly?method=getGridDataForGuardEmployeeAdd');
}

function goNext()
{
 var pgno = parseInt(guardDutyAddForm.pageno.value)+1;
 
 if (pgno > guardDutyAddForm.totalPages.value)
 {
 alert('End of the File Reached!... ');
 return;
 }
 
 guardDutyAddForm.pageno.value = pgno;
 guardDutyAddForm.method="post";
 submitForm('guardDutyAddForm','hrOrderly?method=getGridDataForGuardEmployeeAdd');
}


function goPrevious()
{
 var pgno = parseInt(guardDutyAddForm.pageno.value)-1;
 
 if (pgno < 1)
 {
 alert('Beginning of the File Reached!... ');
 return;
 }
 
 guardDutyAddForm.pageno.value = pgno;
 guardDutyAddForm.method="post";
 submitForm('guardDutyAddForm','hrOrderly?method=getGridDataForGuardEmployeeAdd');
}
function validateButton()
{
	if (guardDutyAddForm.<%=EMPLOYEE_TO_BE_ADDED%>.length)
	{
			 for(var i = 0; i < guardDutyAddForm.<%=EMPLOYEE_TO_BE_ADDED%>.length; i++)
			 {
			  if (guardDutyAddForm.<%=EMPLOYEE_TO_BE_ADDED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (guardDutyAddForm.<%=EMPLOYEE_TO_BE_ADDED%>.checked == true)
			return true;
	}
	return false;
}


function jsAdd()
{
		if (validateButton())
		{
			guardDutyAddForm.method="post";
			if(checkForNextDutyDate())
			{
				submitForm('guardDutyAddForm','hrOrderly?method=AddGuardDutyEntry');
				
			}
		}
		else
		alert('Pl. select Employee to add!......'); 
}

			            
	function jsClose()
	{
	  window.opener.location.href = "hrOrderly?method=showGuardDutyRecords&toDate="+guardDutyAddForm.toDate.value+"&fromDate="+guardDutyAddForm.fromDate.value;
	  if (window.opener.progressWindow)
		 {
	    	window.opener.progressWindow.close()
	  	 } 
	  window.close();
	}
    function getLastDutyDetails(empData)
    {
    	guardDutyAddForm.method="post";
 		submitForm('guardDutyAddForm','hrOrderly?method=getGuardEmployeeLastDutyDetails&empData='+empData);
    }


</script>

<% 
String message="";
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>


<%		int k=0;
				if(dutyExemptionList!=null){
					if(dutyExemptionList.size()>0){
					
							
							Iterator ite = dutyExemptionList.iterator();
							while ( ite.hasNext() ) {
						         HrDutyExemptionEntry hrDutyExemptionEntry=(HrDutyExemptionEntry)  ite.next();
						         if(hrDutyExemptionEntry.getFromDate().after(HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")))){
		%>

<script>
	         		 			
	         					dutyArray[<%=k%>]= new Array();
								dutyArray[<%=k%>][0] = "<%=hrDutyExemptionEntry.getEmployee().getId()%>";
								dutyArray[<%=k%>][1] = "<%=HMSUtil.changeDateToddMMyyyy(hrDutyExemptionEntry.getFromDate())%>";
								dutyArray[<%=k%>][2] = "<%=HMSUtil.changeDateToddMMyyyy(hrDutyExemptionEntry.getToDate())%>";
								dutyArray[<%=k%>][3] = "<%=hrDutyExemptionEntry.getEmployee().getFirstName()%>";
								</script>
<%
						         k++;
						         }
						    }
						}
				}
		%>
<DIV class="Clear"></DIV>



<div id="contentHolder">
<h6>Employee Addition</h6>
<DIV class="Clear"></DIV>
<form name="guardDutyAddForm"><input type="hidden"
	name="hospitalId" value="<%=hospitalId%>" /> <input type="hidden"
	name="changedBy" value="<%=userName%>" /> <input type="hidden"
	name="changedDate" value="<%=date%>" /> <input type="hidden"
	name="changedTime" value="<%=time%>" /> <input type="hidden"
	name="pageno" value="<%=pageno%>" /> <input type="hidden"
	name="totalPages" value="<%=totalPages%>" /> <input type="hidden"
	name="totalRecords" value="<%=totalRecords%>" /> <input type="hidden"
	name="numOfRows" value="10" /> <input type="hidden" name="dutyId"
	value="<%=box.getInt("dutyId")%>" /> <input type="hidden"
	name="entryNo" value="<%=box.getString("entryNo")%>" /> <input
	type="hidden" name="entryDate" value="<%=box.getString("entryDate")%>" />
<input type="hidden" name="toDate" value="<%=box.getString("toDate")%>" />
<input type="hidden" name="fromDate"
	value="<%=box.getString("fromDate")%>" /> <%		
		if (employeeDetailList == null || employeeDetailList.size() == 0) {
		%>

<div class="blockTitle">Employee Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table align="center" width="100%" colspan="7" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="10%">Service No</th>
			<th width="30%">Name</th>
			<th width="10%">Rank</th>
			<th width="10%">Next Duty Date</th>
			<th width="10%">Duty Time</th>
			<th>Type</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>

<%  } else { %>

<div class="blockTitle">Employee Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>


<div class="tableHolderAuto">
<table align="center" width="100%" colspan="7" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>Service No.</th>
			<th>Name</th>
			<th>Rank</th>
			<th colspan="2">Next Duty Date</th>
			<th>Duty Time</th>
			<th>Type</th>
			<th>ADD</th>
		</tr>
	</thead>
	<tbody>
		<%
			    int slno = 0;
			    Iterator ite = employeeDetailList.iterator();
				while ( ite.hasNext() ) {
		         Object[] pair = (Object[]) ite.next();
		         int deptId=0;
		         int empId=0;
		         String serviceNo=null;
		         String rankName=null;
		         String empName=null;
		         Date dutyDate=new Date();
		         
		         if (pair[0]!=null)
		        	 empId=(Integer)pair[0];
		         if (pair[1]!=null)
		        	 serviceNo=(String)pair[1];
		         if (pair[2]!=null)
		        	 empName=(String)pair[2];
		         if (pair[3]!=null)
		        	 deptId=(Integer)pair[3];
		         if (pair[4]!=null)
		        	 dutyDate=(Date)pair[4];
		         if (pair[5]!=null)
		        	 rankName=(String)pair[5];
			    	slno=slno+1;
			    %>
		<tr>
			<td><input type="text" value="<%=serviceNo%>" name="serviceNo"
				readonly="readonly" /></td>
			<td><a href="javascript:getLastDutyDetails(<%=empId%>)"><%=empName%></a></td>
			<td><input type="text" value="<%=rankName%>" name="rank"
				readonly="readonly" /></td>
			<td><input type="text" name="nextDutyDate"
				id="nextDutyDate<%=slno%>" readonly="readonly" /></td>
			<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender" tabindex="1"
				onClick="setdate('',document.getElementById('nextDutyDate<%=slno%>'),event)" />
			</td>
			<td><Select name="dutyTimeId" id="dutyTime<%=slno%>">
				<%for(HrDutyTimeMaster hrDutyTimeMaster:dutyTimeMasterList){ 
					%>
				<option value="<%=hrDutyTimeMaster.getId()%>"><%=hrDutyTimeMaster.getDutyFromTime()%>
				- <%=hrDutyTimeMaster.getDutyToTime()%></option>
				<%} %>
			</select></td>
			<td><select name="typeStatus" id="typeStatus">
				<option value="Main">Main</option>
				<option value="Stand By">Stand By</option>
			</select></td>
			<td><input type="checkbox" name="employeeToBeAdded"
				value="<%=empId%>"></td>
			<td><input type="hidden" value="<%=empId%>" name="employeeId" /></td>
		</tr>
		<% } 
				   } %>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<div id="pagination">
<% if (totalPages > 0 ) { %> Page <span class="selected"><%=pageno %></span>
of <span class="selected"><%=totalPages %></span> <a
	href="javascript:goPrevious()">Prev</a> <a href="javascript:goNext()">Next</a>
<input type="button" name="Go Page" type="submit" class="button"
	value="Go Page" onclick="javascript:GoPage();"> <input
	type="text" name="gopage" size="3" /></div>
<% } %> <%
			Integer indexArray[]=new Integer[2];
		if(dutyEntryList!=null && dutyEntryList.size()>1){ 
				if(holidayList!=null && holidayList.size()>0){
					for(OpdHoliday opdHoliday:holidayList){
						if(dutyEntryList.get(dutyEntryList.size()-1).getDutyDate().equals(opdHoliday.getHolidayDate())){
							indexArray[0]=dutyEntryList.size()-1;
						}
					}
					for(OpdHoliday opdHoliday:holidayList){
						if(dutyEntryList.get(dutyEntryList.size()-2).getDutyDate().equals(opdHoliday.getHolidayDate())){
							indexArray[1]=dutyEntryList.size()-2;
						}
					}
				}
		}
		 
		else if(dutyEntryList!=null && dutyEntryList.size()==1){ 
			if(holidayList!=null && holidayList.size()>0){
				for(OpdHoliday opdHoliday:holidayList){
					if(dutyEntryList.get(dutyEntryList.size()-1).getDutyDate().equals(opdHoliday.getHolidayDate())){
						indexArray[0]=dutyEntryList.size()-1;
					}
				}
				
			}
	}

		
		
		%>
<div class="blockTitle">Last Duty Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table align="center" width="100%" colspan="3" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>Duty Date</th>
			<th>Duty Time</th>

		</tr>
	</thead>
	<tbody>
		<%
			    int slno = 0;
			  	if(dutyEntryList!=null && dutyEntryList.size()>0){
			    for(HrorderlyGuardDutyEntry hrGuardDutyEntry :dutyEntryList){ 
			   
			    %>
		<tr>
			<td><%=HMSUtil.convertDateToStringWithoutTime(hrGuardDutyEntry.getDutyDate()) %></td>
			<td><%=hrGuardDutyEntry.getDutyTime().getDutyFromTime()%>-<%=hrGuardDutyEntry.getDutyTime().getDutyToTime()%></td>
		</tr>
		<%}
			    
			    }%>
	</tbody>
</table>
</div>
<div class="division"></div>
<div class="blockTitle">Duty on Holiday</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table align="center" width="100%" colspan="3" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>Duty Date</th>
			<th>Duty Time</th>

		</tr>
	</thead>
	<tbody>
		<%
			    if(indexArray[0]!=null && dutyEntryList.size()>0){
			    %>
		<tr>
			<td><%=HMSUtil.convertDateToStringWithoutTime(dutyEntryList.get(indexArray[0]).getDutyDate()) %></td>
			<td><%=dutyEntryList.get(indexArray[0]).getDutyTime().getDutyFromTime()%>-<%=dutyEntryList.get(indexArray[0]).getDutyTime().getDutyToTime()%></td>
		</tr>
		<%}%>
		<%
			    if(indexArray[1]!=null && dutyEntryList.size()>0){
			    %>
		<tr>
			<td><%=HMSUtil.convertDateToStringWithoutTime(dutyEntryList.get(indexArray[1]).getDutyDate()) %></td>
			<td><%=dutyEntryList.get(indexArray[1]).getDutyTime().getDutyFromTime()%></td>
		</tr>
		<%}%>
	</tbody>
</table>
</div>
<div class="division"></div>
<div class="blockTitle">Leave Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table align="center" width="100%" colspan="3" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>Start Date</th>
			<th>Date of Reporting</th>

		</tr>
	</thead>
	<tbody>
		<%
			    if(employeeLeaveList!=null && employeeLeaveList.size()>0){
			    	for(HrorderlyLeaveApplication masLeave: onLeaveList){
			    	if(masLeave.getLeaveFromDate().after(HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")))){
			    %>
		<tr>
			<td><%=HMSUtil.convertDateToStringWithoutTime(masLeave.getLeaveFromDate()) %></td>
			<td><%=HMSUtil.convertDateToStringWithoutTime(masLeave.getDateOfReporting())%></td>
		</tr>
		<%}}}%>
	</tbody>
</table>
</div>
<div class="division"></div>
<div class="bottom">
<%	
		if (employeeDetailList != null && employeeDetailList.size() > 0) {
		%> <input type="button" name="Add" onClick="jsAdd()" value="Add"
	class="button" /> <%} %> <input type="button" name="Close"
	onClick="jsClose()" value="Close" class="button" />
<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName %></label> <label>Changed
Date</label> <label class="value"><%=date %></label> <label>Changed Time</label>
<label class="value"><%=time %></label>
<div class="Clear"></div>
</div>

</form>
</div>




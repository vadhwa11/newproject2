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
<style>
html,body {
	overflow: auto;
}
</style>
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

	List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
	List<HrRangeFiringDutyEntry>dutyEntryList=new ArrayList<HrRangeFiringDutyEntry>();
	List<HrLeaveMaintenance>employeeLeaveList=new ArrayList<HrLeaveMaintenance>();
	List<OpdHoliday>holidayList=new ArrayList<OpdHoliday>();	

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
	if (map.get("box")!=null)
	{
		box = (Box)map.get("box");
	}
	if (map.get("employeeLeaveList")!=null)
	{
		employeeLeaveList = (List)map.get("employeeLeaveList");
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
	var pgno = parseInt(rangeFiringDutyAddForm.gopage.value);
	var totalPages = parseInt(rangeFiringDutyAddForm.totalPages.value);
	if (pgno < 1 || pgno > totalPages)
	{
	alert('Invalid Page No!.....');
	return;
	}  
	rangeFiringDutyAddForm.pageno.value = pgno; 
	rangeFiringDutyAddForm.method="post";
	submitForm('rangeFiringDutyAddForm','hrRelated?method=getGridDataForRangeFiringEmployeeAdd');
}

function goNext()
{
 var pgno = parseInt(rangeFiringDutyAddForm.pageno.value)+1;
 
 if (pgno > rangeFiringDutyAddForm.totalPages.value)
 {
 alert('End of the File Reached!... ');
 return;
 }
 
 rangeFiringDutyAddForm.pageno.value = pgno;
 rangeFiringDutyAddForm.method="post";
 submitForm('rangeFiringDutyAddForm','hrRelated?method=getGridDataForRangeFiringEmployeeAdd');
}


function goPrevious()
{
 var pgno = parseInt(rangeFiringDutyAddForm.pageno.value)-1;
 
 if (pgno < 1)
 {
 alert('Beginning of the File Reached!... ');
 return;
 }
 
 rangeFiringDutyAddForm.pageno.value = pgno;
 rangeFiringDutyAddForm.method="post";
 submitForm('rangeFiringDutyAddForm','hrRelated?method=getGridDataForRangeFiringEmployeeAdd');
}

function validateButton()
{
	if (rangeFiringDutyAddForm.<%=EMPLOYEE_TO_BE_ADDED%>.length)
	{
			 for(var i = 0; i < rangeFiringDutyAddForm.<%=EMPLOYEE_TO_BE_ADDED%>.length; i++)
			 {
			  if (rangeFiringDutyAddForm.<%=EMPLOYEE_TO_BE_ADDED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (rangeFiringDutyAddForm.<%=EMPLOYEE_TO_BE_ADDED%>.checked == true)
			return true;
	}
	return false;
}


function jsAdd()
{
		if (validateButton())
		{
			rangeFiringDutyAddForm.method="post";
				submitForm('rangeFiringDutyAddForm','hrRelated?method=AddRangeFiringDutyEntry');
				
		}
		else
		alert('Pl. select Employee to add!......'); 
}
function jsSearch()
{
	if(document.getElementById('searchServiceNo').value=="" && document.getElementById('searchName').value=="")
	{
		alert("Please enter either Service No. or Employee Name");
		
	}
	else
	{
		rangeFiringDutyAddForm.method="post";
		submitForm('rangeFiringDutyAddForm','hrRelated?method=searchRangeFiringDutyEntry');
	}		
}			            
	function jsClose()
	{
	  window.opener.location.href = "hrRelated?method=showRangeFiringDutyEntryJsp";
	  if (window.opener.progressWindow)
		 {
	    	window.opener.progressWindow.close()
	  	 } 
	  window.close();
	}
    
</script>


<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>

<h2><%=message %></h2>
<%} %>
<DIV class="Clear"></DIV>

<div id="contentHolder">
<h6>Range Firing Duty Addition</h6>
<div class="Clear"></div>
<form name="rangeFiringDutyAddForm"><input type="hidden"
	name="hospitalId" value="<%=hospitalId%>" /> <input type="hidden"
	name="changedBy" value="<%=userName%>" /> <input type="hidden"
	name="changedDate" value="<%=date%>" /> <input type="hidden"
	name="changedTime" value="<%=time%>" /> <input type="hidden"
	name="pageno" value="<%=pageno%>" /> <input type="hidden"
	name="totalPages" value="<%=totalPages%>" /> <input type="hidden"
	name="totalRecords" value="<%=totalRecords%>" /> <input type="hidden"
	name="numOfRows" value="10" /> <input type="hidden" name="quarter"
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
<%		
		if (employeeDetailList == null || employeeDetailList.size() == 0) {
		%>

<div class="blockTitle">Employee Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table align="center" width="100%" colspan="7" border="0"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="10%">Sl No.</th>
			<th width="10%">Service No.</th>
			<th width="10%">Name</th>
			<th width="10%">Rank</th>
			<th width="10%">ADD</th>
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
<table align="center" width="100%" colspan="7" border="0"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>Service No.</th>
			<th>Name</th>
			<th>Rank</th>
			<th>ADD</th>
		</tr>
	</thead>
	<tbody>
		<%
      			int counter=0;
      			if(pageno==1)
      			{
      				counter=1;
      			}
      			if(pageno>1)
      			{
      				counter=(10*(pageno-1))+1;
      			}
			    int slno = 0;
			    for(MasEmployee masEmployee :employeeDetailList){ 
			    	slno=slno+1;
			    	String msg="";
			    	if(masEmployee.getFirstName()!=null && !masEmployee.getFirstName().equals(""))
						msg +=masEmployee.getFirstName()+" ";
						if(masEmployee.getMiddleName()!=null && !masEmployee.getMiddleName().equals(""))
							msg +=masEmployee.getMiddleName()+" ";
						if(masEmployee.getLastName()!=null && !masEmployee.getLastName().equals(""))
							msg +=masEmployee.getLastName()+" ";
	  %>
		<tr>
			<td><%=counter++%></td>
			<td><%=masEmployee.getServiceNo()%></td>
			<td><%=msg%></td>
			<td><%=masEmployee.getRank().getRankName()%></td>
			<td><input type="checkbox" class="radio"
				name="employeeToBeAdded" value="<%=masEmployee.getId()%>" /></td>
			<input type="hidden" value="<%=masEmployee.getId()%>"
				name="employeeId" />
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
	href="javascript:goPrevious()">Prev<<</a> <a href="javascript:goNext()">>>Next</a>
<input type="button" name="Go Page" type="submit" value="Go Page"
	class="button" onclick="javascript:GoPage();"> <input
	type="text" name="gopage" size="3" /> <% } %>
</div>

<%	
		if (employeeDetailList != null && employeeDetailList.size() > 0) {
		%>
<div class="bottom">
<div class="division"></div>
<input type="button" name="Add" onClick="jsAdd()" value="Add"
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



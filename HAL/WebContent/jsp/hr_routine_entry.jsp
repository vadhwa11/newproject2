<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * @author  Priyanka Garg
 * Create Date: 27 May 2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.7
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.*"%>

<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.GregorianCalendar"%>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		String time1=String.valueOf(calendar.getTime());
		int year=calendar.get(calendar.YEAR);
		if(month1.length()<2){
			month1="0"+month1;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
			
	%>
		serverdate = '<%=date1+"/"+month1+"/"+year%>'
</script>

<script type="text/javascript">


function add()
{
		if(dailyRoutineDuty.dutyId.value!="" && dailyRoutineDuty.fromDate.value!="" && dailyRoutineDuty.toDate.value!=""){
			var url="/hms/hms/hrRelated?method=showDailyRoutineAddJsp&entryNo="+dailyRoutineDuty.entryNo.value+"&entryDate="+dailyRoutineDuty.entryDate.value+"&dutyId="+dailyRoutineDuty.dutyId.value+"&toDate="+dailyRoutineDuty.toDate.value+"&fromDate="+dailyRoutineDuty.fromDate.value;
			newwindow=window.open(url,'name','top=50, left=50, height=600,width=950,status=1, scrollbars=yes');
		}
		else
				alert("Select Duty Name,Duty Start Date, Duty End Date for adding record!!");
}
//this function will be called by the Bean (not from JSP)
function GoPage() {	
	var pgno = parseInt(guardDuty.gopage.value);
	var totalPages = parseInt(guardDuty.totalPages.value);
	if (pgno < 1 || pgno > totalPages)
	{
	alert('Invalid Page No!.....');
	return;
	}  
	guardDuty.pageno.value = pgno; 
	guardDuty.method="post";
	submitForm('dailyRoutineDuty','hrRelated?method=getGridDataForDailyRoutineEmployee');
}

function goNext()
{
 var pgno = parseInt(dailyRoutineDuty.pageno.value)+1;
 if (pgno > dailyRoutineDuty.totalPages.value)
 {
 alert('End of the File Reached!... ');
 return;
 }
 
 dailyRoutineDuty.pageno.value = pgno;
 dailyRoutineDuty.method="post";
 submitForm('dailyRoutineDuty','hrRelated?method=getGridDataForDailyRoutineEmployee');
}


function goPrevious()
{
 var pgno = parseInt(dailyRoutineDuty.pageno.value)-1;
 
 if (pgno < 1)
 {
 alert('Beginning of the File Reached!... ');
 return;
 }
 
 dailyRoutineDuty.pageno.value = pgno;
 dailyRoutineDuty.method="post";
 submitForm('dailyRoutineDuty','hrRelated?method=getGridDataForDailyRoutineEmployee');
}

function jsUpdate()
{
		if (validateButton())
		{
		dailyRoutineDuty.method="post";
		submitForm('dailyRoutineDuty','hrRelated?method=updateDailyRoutineEntry','checkForNextDutyDate');
		}
		else
		alert('Pl. select Employee to update!......'); 
}

function validateButton()
{
	if (dailyRoutineDuty.dutyToBeUpdated.length)
	{
			 for(var i = 0; i < dailyRoutineDuty.dutyToBeUpdated.length; i++)
			 {
			  if (dailyRoutineDuty.dutyToBeUpdated[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (dailyRoutineDuty.dutyToBeUpdated.checked == true)
			return true;
	}
	return false;
}

function checkForNextDutyDate()
{
	var msg="";
			 for(var i = 0; i < document.getElementsByName('dutyToBeUpdated').length; i++){
			  if(document.getElementsByName('dutyToBeUpdated')[i].checked == true )
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

	function jsDisplay() {
	
		searchPanel.method="post";
		submitForm('searchPanel','hrRelated?method=searchDailyRoutineDutyData&searchEntryNo='+searchPanel.searchEntryNo.value+'&searchEntryDate='+searchPanel.searchEntryDate.value);
	}  
</script>


<%
		StringBuffer orderDateOnly = new StringBuffer();
		GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
	
		int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(dateOfMonth);
		} else {
			orderDateOnly.append(dateOfMonth);
		}
	
		orderDateOnly.append("/");
	
		int monthSearch = gregorianCalendar1.get(Calendar.MONTH) + 1;
		if (monthSearch < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(monthSearch);
		} else {
			orderDateOnly.append(monthSearch);
		}
	
		orderDateOnly.append("/");
		int year1 = gregorianCalendar1.get(Calendar.YEAR);
		orderDateOnly.append(year1);
		String currentDate = new String(orderDateOnly);
	%>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Box box = HMSUtil.getBox(request);
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	int hospitalId = 0;
	int pageno=1;
	int totalPages=0;
	int totalRecords = 0;
	Date fromDate=new Date();
	Date toDate=new Date();
		
	List<HrDailyRoutineDutyEntry> dutyEntryList = new ArrayList<HrDailyRoutineDutyEntry>();
	List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
	List<HrDutyMaster>dutyNameList=new ArrayList<HrDutyMaster>();
	List<HrDailyRoutineDutyEntry> searchDailyRoutineDutyList = new ArrayList<HrDailyRoutineDutyEntry>();
	Set<String>dailyRoutineDutySetForEntryNoSet=new TreeSet<String>();
	if (request.getAttribute("map") != null) 
	{
		map = (Map)request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}
	if (map.get("searchDailyRoutineDutyList")!=null)
	{
		searchDailyRoutineDutyList = (List)map.get("searchDailyRoutineDutyList");
	}
	System.out.println("searchDailyRoutineDutyList="+searchDailyRoutineDutyList.size());
	if (map.get("dailyRoutineSetForEntryNoSet")!=null)
	{
		dailyRoutineDutySetForEntryNoSet = (Set)map.get("dailyRoutineSetForEntryNoSet");
	}
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	String userName = "";
	String entryNo="";
	int dutyId=0;
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(session.getAttribute("hospitalId") != null){
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	if(map.get("dutyEntryList")!=null)
	{
		dutyEntryList = (List)map.get("dutyEntryList");
	}
	if(map.get("dutyId")!=null)
	{
		dutyId = (Integer)map.get("dutyId");
	}
	if(map.get("dutyNameList")!=null)
	{
		dutyNameList = (List)map.get("dutyNameList");
	}
	if(map.get("fromDate")!=null)
	{
		fromDate = (Date)map.get("fromDate");
	}
	if(map.get("entryNo")!=null)
	{
		entryNo = (String)map.get("entryNo");
	}
	if(map.get("toDate")!=null)
	{
		toDate = (Date)map.get("toDate");
	}
	if(map.get("box")!=null)
	{
		box = (Box)map.get("box");
	}
	if (map.get("pageno")!=null)
	{
		 pageno = Integer.parseInt(map.get("pageno").toString());
	}
	
	if (map.get("totalPages")!=null)
	{
		 totalPages = Integer.parseInt(map.get("totalPages").toString());
	}
	
	if (map.get("totalRecords")!=null)
	{
		totalRecords = Integer.parseInt(map.get("totalRecords").toString());
	}
	if (map.get("dutyMasterList")!=null)
	{
		dutyMasterList = (List)map.get("dutyMasterList");
	}
	
		%>
<% 
	String message ="";
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>
<DIV class="Clear"></DIV>

<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
	</tr>
</table>

<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchPanel" method="post">
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB"> Entry No: </label> <select name="searchEntryNo">
			<option value="">Select Entry No</option>
			<%for(String entryString:dailyRoutineDutySetForEntryNoSet){ %>
			<option value="<%=entryString%>"><%=entryString%></option>
			<%} %>
		</select>
		<div class="clear"></div>
		<label>Entry Date</label> <input type="text" id="searchEntryDate"
			name="searchEntryDate" value="" MAXLENGTH="30" readonly="readonly"
			class="textbox_date" /> <img src="/hms/jsp/images/cal.gif"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender"
			onClick="setdate('<%=currentDate%>',document.searchPanel.searchEntryDate,event);" />
		<div class="clear"></div>
		<input type="button" name="Submit" id="addbutton" value="Submit"
			class="button" onClick="jsDisplay();" /></td>
	</tr>


</table>
</form>

</div>
</div>
</div>
<div id="contentHolder">
<form name="dailyRoutineDuty" action="" method="post">
<h6>Detailing of Daily Routine, Scott & Sick transfer duty entry</h6>
<div class="Clear"></div>
<div class="blockFrame"><label>Entry No.</label> <input
	name="entryNo" type="text" id="entryNo" value="<%=entryNo%>"
	readonly="readonly" /> <label>Entry Date</label> <input
	name="entryDate" type="text" class="calDate" id="entryDate"
	value="<%=currentDate%>" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate%>',document.dailyRoutineDuty.entryDate,event);" />
<label>Duty Name</label> <Select name="dutyId" id="dutyId">
	<%if(dutyId!=0){ %>
	<option value="">Select</option>
	<%for(HrDutyMaster hrDutyMaster:dutyNameList){ %>
	<%		if(hrDutyMaster.getId()==dutyId){ %>
	<option value="<%=hrDutyMaster.getId()%>" selected="selected"><%=hrDutyMaster.getDutyName()%></option>
	<%}else{ %>
	<option value="<%=hrDutyMaster.getId()%>"><%=hrDutyMaster.getDutyName()%></option>
	<%} 
	}
}else{%>
	<option value="">Select</option>
	<%for(HrDutyMaster hrDutyMaster:dutyNameList){ %>
	<option value="<%=hrDutyMaster.getId()%>"><%=hrDutyMaster.getDutyName()%></option>
	<% }
}%>
</Select>

<div class="Clear"></div>


<label>Duty Start Date</label> <input type="text" id="fromDate"
	class="calDate" name="<%=FROM_DATE %>" value="<%=box.get(FROM_DATE)%>"
	MAXLENGTH="30" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.dailyRoutineDuty.<%=FROM_DATE%>,event);" />

<%
		String flag= "false";
	%> <label>Duty End Date</label> <input type="text" id="toDate"
	class="calDate" name="<%=TO_DATE %>" value="<%=box.get(TO_DATE)%>"
	MAXLENGTH="30" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.dailyRoutineDuty.<%=TO_DATE%>,event);" />

<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="hospitalId" value="<%=hospitalId%>" /> <input
	type="hidden" name="pageno" value="<%=pageno%>" /> <input
	type="hidden" name="totalPages" value="<%=totalPages%>" /> <input
	type="hidden" name="totalRecords" value="<%=totalRecords%>" /> <input
	type="hidden" name="numOfRows" value="10" /></div>
<div class="Clear"></div>
<input type="button" name="Add" type="submit" value="Add"
	onClick="add();" class="cmnButton">
<div class="division"></div>
<% if ((dutyEntryList.size() ==0)&&(searchDailyRoutineDutyList.size()==0)) { %>
<div class="blockTitle">Employee Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" colspan="7" id="mmfDepartmentDetails"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="13%">Service No.</th>
			<th width="10%">Rank</th>
			<th width="10%">Name</th>
			<th width="10%">Last Duty Date</th>
			<th width="13%">Next Duty Date</th>
			<th width="13%">Duty Time</th>
			<th width="13%">Remarks</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=6>No Data Found</td>
		</tr>
	</tbody>
</table>
</div>

<% } else if(dutyEntryList != null && dutyEntryList.size()>0){ %>

<div class="blockTitle">Detailing of Daily Routine, Scott & Sick
transfer duty entry</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="98%" colspan="7" id="tblSample" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
			<th width="13%">Service No.</th>
			<th width="10%">Rank</th>
			<th width="10%">Name</th>
			<th width="10%">Last Duty Date</th>
			<th width="13%">Next Duty Date</th>
			<th width="13%">Duty Time</th>
			<th width="13%">Remarks</th>
			<th>UPDATE/DELETE</th>
		</tr>
	</thead>
	<tbody>

		<%
			    	int iFirstRow=0;
			    for(HrDailyRoutineDutyEntry hrDailyRoutineEntry:dutyEntryList)
			    { 
			    	iFirstRow++;
			    %>
		<%	String msg="";
				if(hrDailyRoutineEntry.getEmp().getFirstName()!=null && !hrDailyRoutineEntry.getEmp().getFirstName().equals(""))
				msg +=hrDailyRoutineEntry.getEmp().getFirstName()+" ";
				if(hrDailyRoutineEntry.getEmp().getMiddleName()!=null && !hrDailyRoutineEntry.getEmp().getMiddleName().equals(""))
					msg +=hrDailyRoutineEntry.getEmp().getMiddleName()+" ";
				if(hrDailyRoutineEntry.getEmp().getLastName()!=null && !hrDailyRoutineEntry.getEmp().getLastName().equals(""))
					msg +=hrDailyRoutineEntry.getEmp().getLastName()+" ";
				%>
		<tr>
			<td width="10%"><%=hrDailyRoutineEntry.getEmp().getServiceNo()%></td>
			<td width="40%"><%=hrDailyRoutineEntry.getEmp().getRank().getRankName()%></td>
			<td width="12%"><%=msg%></td>
			<td width="40%"><%=HMSUtil.convertDateToStringWithoutTime(hrDailyRoutineEntry.getDutyDate())%></td>
			<td><input type="text" value="" name="nextDutyDate"
				id="nextDutyDate<%=iFirstRow%>" readonly="readonly" /> <img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" tabindex="1"
				onClick="setdate('',document.getElementById('nextDutyDate<%=iFirstRow%>'),event)" />
			</td>
			<td width="40%"><Select name="dutyTime"
				id="dutyTime<%=iFirstRow%>">
				<%for(HrDutyTimeMaster hrDutyTimeMaster:dutyMasterList){ 
							if(hrDutyTimeMaster.getId()==hrDailyRoutineEntry.getDutyTime().getId()){
					%>
				<option selected="selected" value="<%=hrDutyTimeMaster.getId()%>"><%=hrDutyTimeMaster.getDutyFromTime()%>-<%=hrDutyTimeMaster.getDutyToTime()%></option>
				<%}else{ %>
				<option value="<%=hrDutyTimeMaster.getId()%>"><%=hrDutyTimeMaster.getDutyFromTime()%>-<%=hrDutyTimeMaster.getDutyToTime()%></option>
				<%}} %>
			</select></td>
			<td>
			<%if(hrDailyRoutineEntry.getRemarks()!=null){ %> <input type="text"
				value="<%=hrDailyRoutineEntry.getRemarks()%>" name="remarks"
				readonly="readonly" /> <%}else{ %> <input type="text" value=""
				name="remarks" readonly="readonly" /> <%} %>
			</td>
			<td><input type="checkbox" name="dutyToBeUpdated" class="radio"
				value="<%=hrDailyRoutineEntry.getId()%>"></td>
			<td><input type="hidden"
				value="<%=hrDailyRoutineEntry.getId()%>" name="dailyRoutineDutyId" /></td>

		</tr>
		<% } %>



	</tbody>
</table>
<% } else if(searchDailyRoutineDutyList!=null && searchDailyRoutineDutyList.size()>0){ %>

<div class="blockTitle">Detailing of Daily Routine, Scott & Sick
transfer duty entry</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="98%" colspan="7" id="tblSample" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
			<th width="13%">Service No.</th>
			<th width="10%">Rank</th>
			<th width="10%">Name</th>
			<th width="10%">Last Duty Date</th>
			<th width="13%">Next Duty Date</th>
			<th width="13%">Duty Time</th>
			<th width="13%">Remarks</th>
			<th>UPDATE/DELETE</th>
		</tr>
	</thead>
	<tbody>

		<%
			    	int iFirstRow=0;
			    for(HrDailyRoutineDutyEntry hrDailyRoutineEntry:searchDailyRoutineDutyList)
			    { 
			    	iFirstRow++;
			    %>
		<%	String msg="";
				if(hrDailyRoutineEntry.getEmp().getFirstName()!=null && !hrDailyRoutineEntry.getEmp().getFirstName().equals(""))
				msg +=hrDailyRoutineEntry.getEmp().getFirstName()+" ";
				if(hrDailyRoutineEntry.getEmp().getMiddleName()!=null && !hrDailyRoutineEntry.getEmp().getMiddleName().equals(""))
					msg +=hrDailyRoutineEntry.getEmp().getMiddleName()+" ";
				if(hrDailyRoutineEntry.getEmp().getLastName()!=null && !hrDailyRoutineEntry.getEmp().getLastName().equals(""))
					msg +=hrDailyRoutineEntry.getEmp().getLastName()+" ";
				%>
		<tr>
			<td width="10%"><%=hrDailyRoutineEntry.getEmp().getServiceNo()%></td>
			<td width="40%"><%=hrDailyRoutineEntry.getEmp().getRank().getRankName()%></td>
			<td width="12%"><%=msg%></td>
			<td width="40%"><%=HMSUtil.convertDateToStringWithoutTime(hrDailyRoutineEntry.getDutyDate())%></td>
			<td><input type="text" value="" name="nextDutyDate"
				id="nextDutyDate<%=iFirstRow%>" readonly="readonly" /> <img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" tabindex="1"
				onClick="setdate('',document.getElementById('nextDutyDate<%=iFirstRow%>'),event)" />
			</td>
			<td width="40%"><Select name="dutyTime"
				id="dutyTime<%=iFirstRow%>">
				<%for(HrDutyTimeMaster hrDutyTimeMaster:dutyMasterList){ 
							if(hrDutyTimeMaster.getId()==hrDailyRoutineEntry.getDutyTime().getId()){
					%>
				<option selected="selected" value="<%=hrDutyTimeMaster.getId()%>"><%=hrDutyTimeMaster.getDutyFromTime()%>-<%=hrDutyTimeMaster.getDutyToTime()%></option>
				<%}else{ %>
				<option value="<%=hrDutyTimeMaster.getId()%>"><%=hrDutyTimeMaster.getDutyFromTime()%>-<%=hrDutyTimeMaster.getDutyToTime()%></option>
				<%}} %>
			</select></td>
			<td>
			<%if(hrDailyRoutineEntry.getRemarks()!=null){ %> <input type="text"
				value="<%=hrDailyRoutineEntry.getRemarks()%>" name="remarks"
				readonly="readonly" /> <%}else{ %> <input type="text" value=""
				name="remarks" readonly="readonly" /> <%} %>
			</td>
			<td><input type="checkbox" name="dutyToBeUpdated" class="radio"
				value="<%=hrDailyRoutineEntry.getId()%>"></td>
			<td><input type="hidden"
				value="<%=hrDailyRoutineEntry.getId()%>" name="dailyRoutineDutyId" /></td>

		</tr>
		<% } %>



	</tbody>
</table>

<% } %>
</div>



<% if (totalPages > 0 ) { %>
<div class="division"></div>
<div id="pagination">Page <span class="selected"><%=pageno %></span>
of <span class="selected"><%=totalPages %></span> <a
	href="javascript:goPrevious()">Previous</a> <a
	href="javascript:goNext()">Next</a> <input type="text" name="gopage"
	size="3" /> <input type="button" name="Go Page" type="submit"
	class="button" value="Go Page" onclick="javascript:GoPage();">
</div>
<% } %> <% if ((dutyEntryList!=null && dutyEntryList.size()>0)||(searchDailyRoutineDutyList!=null && searchDailyRoutineDutyList.size()>0)) { %>
<div class="division"></div>
<div class="bottom"><input type="button" class="button"
	name="update" onClick="jsUpdate()" value="update" /> <input
	type="button" name="delete"
	onClick="if (validateButton()){submitForm('dailyRoutineDuty','hrRelated?method=deleteDailyRoutineDutyEntry');}else{alert('Pl. Select Employee to delete.');}"
	value="Delete" class="button" />
<div class="division"></div>
</div>
<%} %>

</form>
</div>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
<input type="hidden" name="rows" id="rr" value="1" />




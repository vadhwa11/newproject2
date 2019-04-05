
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * @author  Priyanka Garg
	 * Create Date: 
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
	int dutyId=0;	
	%>
	serverdate = '<%=date1+"/"+month1+"/"+year%>'
	</script>

<script type="text/javascript">
	
	
	function add()
	{
		if(orderlyDuty.fromDate.value!="" && orderlyDuty.toDate.value!="")
		{
			var url="/hms/hms/hrRelated?method=showOrderlyDutyAddJsp&entryNo="+orderlyDuty.entryNo.value+"&entryDate="+orderlyDuty.entryDate.value+"&dutyId="+orderlyDuty.dutyId.value+"&toDate="+orderlyDuty.toDate.value+"&fromDate="+orderlyDuty.fromDate.value;
			newwindow=window.open(url,'name','top=50, left=50, height=600,width=950,status=1,scrollbars=yes');
		}
		else
		{
			alert("Select Duty Start Date and Duty End Date");
		}
			
	}
	//this function will be called by the Bean (not from JSP)
	function GoPage() {	
		var pgno = parseInt(orderlyDuty.gopage.value);
		var totalPages = parseInt(orderlyDuty.totalPages.value);
		if (pgno < 1 || pgno > totalPages)
		{
		alert('Invalid Page No!.....');
		return;
		}  
		orderlyDuty.pageno.value = pgno; 
		orderlyDuty.method="post";
		submitForm('orderlyDuty','hrRelated?method=getGridDataOrderlyForEmployee');
	}
	
	function goNext()
	{
	 var pgno = parseInt(orderlyDuty.pageno.value)+1;
	 if (pgno > orderlyDuty.totalPages.value)
	 {
	 alert('End of the File Reached!... ');
	 return;
	 }
	 
	 orderlyDuty.pageno.value = pgno;
	 orderlyDuty.method="post";
	 submitForm('orderlyDuty','hrRelated?method=getGridDataForOrderlyEmployee');
	}
	
	
	function goPrevious()
	{
	 var pgno = parseInt(orderlyDuty.pageno.value)-1;
	 
	 if (pgno < 1)
	 {
	 alert('Beginning of the File Reached!... ');
	 return;
	 }
	 
	 orderlyDuty.pageno.value = pgno;
	 orderlyDuty.method="post";
	 submitForm('orderlyDuty','hrRelated?method=getGridDataForOrderlyEmployee');
	}
	
	function jsUpdate()
	{
			if (validateButton())
			{
			orderlyDuty.method="post";
			submitForm('orderlyDuty','hrRelated?method=updateOrderlyDutyEntry','checkForNextDutyDate');
			}
			else
			alert('Pl. select Employee to update!......'); 
	}
	
	function validateButton()
	{
		if (orderlyDuty.dutyToBeUpdated.length)
		{
				 for(var i = 0; i < orderlyDuty.dutyToBeUpdated.length; i++)
				 {
				  if (orderlyDuty.dutyToBeUpdated[i].checked == true)
	             		return true;
				 }
		}
		else
		{
			if (orderlyDuty.dutyToBeUpdated.checked == true)
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
		submitForm('searchPanel','hrRelated?method=searchOrderlyDutyData&searchEntryNo='+searchPanel.searchEntryNo.value+'&searchEntryDate='+searchPanel.searchEntryDate.value);
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
	int hospitalId = 0;
	int pageno=1;
	int totalPages=0;
	int totalRecords = 0;
	Date fromDate=new Date();
	Date toDate=new Date();
		
	List<HrOrderlyDutyEntry> dutyEntryList = new ArrayList<HrOrderlyDutyEntry>();
	List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<HrOrderlyDutyEntry> searchOrderlyDutyList = new ArrayList<HrOrderlyDutyEntry>();
	Set<String>orderlyDutySetForEntryNoSet=new TreeSet<String>();
	if (request.getAttribute("map") != null) 
	{
		map = (Map)request.getAttribute("map");
	}
	if (map.get("searchOrderlyDutyList")!=null)
	{
		searchOrderlyDutyList = (List)map.get("searchOrderlyDutyList");
	}
	if (map.get("orderlyDutySetForEntryNoSet")!=null)
	{
		orderlyDutySetForEntryNoSet = (Set)map.get("orderlyDutySetForEntryNoSet");
	}
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String entryNo="";
	String userName = "";
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
	if(map.get("fromDate")!=null)
	{
		fromDate = (Date)map.get("fromDate");
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
	if (map.get("departmentList")!=null)
	{
		departmentList = (List)map.get("departmentList");
	}
	if(map.get("entryNo")!=null)
	{
		entryNo = (String)map.get("entryNo");
	}
	if(map.get("dutyId")!=null)
	{
		dutyId = (Integer)map.get("dutyId");
	}
	String message ="";
	%>


<DIV class="Clear"></DIV>
<br />
<br />
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
			class="bodytextB"> Entry No: </label> <input type="text"
			name="searchEntryNo" id="searchEntryNo" />

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
<% 
	if (map.get("message") != null) {
			 message = (String) map.get("message");
			
		}
	if(!message.equalsIgnoreCase("")){
	%>

<h2><%=message %></h2>
<%} %>
<form name="orderlyDuty" action="" method="post">
<h6>Orderly SGT Duty Entry</h6>
<div class="Clear"></div>
<div class="division"></div>
<div class="blockFrame"><label class="medium">Entry No.</label> <input
	name="entryNo" type="text" class="calDate" id="entryNo"
	value="<%=entryNo%>" readonly="readonly" />
<div class="Clear"></div>
<label class="medium">Entry Date</label> <input name="entryDate"
	type="text" class="calDate" id="entryDate" value="<%=currentDate%>"
	readonly="readonly" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate%>',document.dailyRoutineDuty.entryDate,event);" />

<input type="hidden" name="dutyId" id="dutyId" value="<%=dutyId%>" /> <label
	class="noWidth">Duty Start Date</label> <input type="text"
	id="fromDate" name="<%=FROM_DATE %>" value="<%=box.get(FROM_DATE)%>"
	MAXLENGTH="30" readonly="readonly" class="calDate" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate%>',document.orderlyDuty.<%=FROM_DATE%>,event);" />

<%
	String flag= "false";
	%> <label class="noWidth">Duty End Date</label> <input type="text"
	id="toDate" name="<%=TO_DATE %>" value="<%=box.get(TO_DATE)%>"
	MAXLENGTH="30" readonly="readonly" class="calDate" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate%>',document.orderlyDuty.<%=TO_DATE%>,event);" />
</div>
<div class="Clear"></div>
<input type="button" name="Add" type="submit" value="Add"
	onClick="add();" class="cmnButton"> <input type="hidden"
	name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input type="hidden"
	name="hospitalId" value="<%=hospitalId%>" /> <input type="hidden"
	name="pageno" value="<%=pageno%>" /> <input type="hidden"
	name="totalPages" value="<%=totalPages%>" /> <input type="hidden"
	name="totalRecords" value="<%=totalRecords%>" /> <input type="hidden"
	name="numOfRows" value="10" />

<div class="Clear"></div>
<% if ((dutyEntryList == null || dutyEntryList.size()==0 )&&(searchOrderlyDutyList==null || searchOrderlyDutyList.size()==0)) { %>
<div class="blockTitle">Orderly Duty Entry</div>
<div class="blockTitleCurve"></div>
<div class="tableHolderAuto">
<table width="100%" colspan="7" id="mmfDepartmentDetails" border="0"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="13%">Service No.</th>
			<th width="10%">Rank</th>
			<th width="10%">Name</th>
			<th width="10%">Last Duty Date</th>
			<th width="10%">Department</th>
			<th width="13%">Next Duty Date</th>
			<th width="13%">Duty Time</th>
			<th>Type</th>
			<th width="10%">Remarks</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=6>No Data Found</td>
		</tr>
	</tbody>
</table>
</div>

<% } else if(dutyEntryList != null && dutyEntryList.size()!=0){ %>
<div class="blockTitle">Orderly Duty Entry</div>
<div class="blockTitleCurve"></div>
<div class="tableHolderAuto">
<table width="98%" colspan="7" id="tblSample" border="0" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
			<th width="13%">Service No.</th>
			<th width="40%">Rank</th>
			<th width="12%">Name</th>
			<th width="40%">Last Duty Date</th>
			<th width="40%">Department</th>
			<th colspan="2">Next Duty Date</th>
			<th width="40%">Duty Time</th>
			<th>Type</th>
			<th width="40%">Remarks</th>
			<th>UPDATE/DELETE</th>
		</tr>
	</thead>
	<tbody>

		<%
		int iFirstRow=0;
	for(HrOrderlyDutyEntry hrOrderlyDutyEntry:dutyEntryList)
	{ 
		iFirstRow++;
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
			<td width="13%"><%=hrOrderlyDutyEntry.getEmp().getServiceNo()%></td>
			<td width="40%"><%=hrOrderlyDutyEntry.getEmp().getRank().getRankName()%></td>
			<td width="12%"><%=msg%></td>
			<td width="40%"><%=HMSUtil.convertDateToStringWithoutTime(hrOrderlyDutyEntry.getDutyDate())%></td>
			<td width="40%"><Select name="Location"
				id="Location<%=iFirstRow%>" style="width: 120px">
				<%for(MasDepartment masdepartment:departmentList){ 
					if(hrOrderlyDutyEntry.getDepartmentId() != null){
						if(hrOrderlyDutyEntry.getDepartmentId().getId().equals(masdepartment.getId())){
					    %>
				<option value="<%=masdepartment.getId()%>" selected="selected"><%=masdepartment.getDepartmentName()%></option>
				<%}else{ %>
				<option value="<%=masdepartment.getId()%>"><%=masdepartment.getDepartmentName()%></option>
				<% }} else {%>
				<option value="<%=masdepartment.getId()%>"><%=masdepartment.getDepartmentName()%></option>
				<%}} %>
			</select></td>

			<td width="13%"><input type="text" value="" size="9"
				name="nextDutyDate" id="nextDutyDate<%=iFirstRow%>"
				readonly="readonly" /></td>
			<td width="13%"><img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				tabindex="1"
				onClick="setdate('',document.getElementById('nextDutyDate<%=iFirstRow%>'),event)" />
			</td>
			<td width="40%"><Select name="dutyTime"
				id="dutyTime<%=iFirstRow%>">
				<%for(HrDutyTimeMaster hrDutyTimeMaster:dutyMasterList){ 
	if(hrDutyTimeMaster.getId()==hrOrderlyDutyEntry.getDutyTime().getId()){
	%>
				<option selected="selected" value="<%=hrDutyTimeMaster.getId()%>"><%=hrDutyTimeMaster.getDutyFromTime()%>-<%=hrDutyTimeMaster.getDutyToTime()%></option>
				<%}else{ %>
				<option value="<%=hrDutyTimeMaster.getId()%>"><%=hrDutyTimeMaster.getDutyFromTime()%>-<%=hrDutyTimeMaster.getDutyToTime()%></option>
				<%}} %>
			</select></td>
			<td><input type="text" name="typeStatus" id="typeStatus"
				value="<%=hrOrderlyDutyEntry.getTypeStatus()%>" readonly="readonly" /></td>
			<td width="40%">
			<%if(hrOrderlyDutyEntry.getRemarks()!=null){ %> <input type="text"
				value="<%=hrOrderlyDutyEntry.getRemarks()%>" name="remarks"
				id="remarks<%= iFirstRow%>" maxlength=30 /> <%}else{ %> <input
				type="text" value="" name="remarks" id="remarks<%= iFirstRow%>"
				maxlength=30 /> <%} %>
			<td><input type="checkbox" class="radio" name="dutyToBeUpdated"
				class="smcaption" value="<%=hrOrderlyDutyEntry.getId()%>">
			</td>
			<input type="hidden" value="<%=hrOrderlyDutyEntry.getId()%>"
				name="orderlyDutyId" />
		</tr>
		<% } %>
	</tbody>
</table>
<% } else if(searchOrderlyDutyList != null && searchOrderlyDutyList.size()!=0 ){ %>
<div class="blockTitle">Orderly Duty Entry</div>
<div class="blockTitleCurve"></div>
<div class="tableHolderAuto">
<table width="98%" colspan="7" id="tblSample" border="0" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="13%">Service No.</th>
			<th width="40%">Rank</th>
			<th width="12%">Name</th>
			<th width="40%">Last Duty Date</th>
			<th width="40%">Department</th>
			<th colspan="2">Next Duty Date</th>
			<th width="40%">Duty Time</th>
			<th>Type</th>
			<th width="40%">Remarks</th>
			<th>UPDATE/DELETE</th>
		</tr>
	</thead>
	<tbody>

		<%
		int iFirstRow=0;
	for(HrOrderlyDutyEntry hrOrderlyDutyEntry:searchOrderlyDutyList)
	{ 
		iFirstRow++;
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
			<td width="13%"><%=hrOrderlyDutyEntry.getEmp().getServiceNo()%></td>
			<td width="40%"><%=hrOrderlyDutyEntry.getEmp().getRank().getRankName()%></td>
			<td width="12%"><%=msg%></td>
			<td width="40%"><%=HMSUtil.convertDateToStringWithoutTime(hrOrderlyDutyEntry.getDutyDate())%></td>
			<td width="40%"><Select name="Location"
				id="Location<%=iFirstRow%>" style="width: 120px">
				<%for(MasDepartment masdepartment:departmentList){ 
					if(hrOrderlyDutyEntry.getDepartmentId() != null){
						if(hrOrderlyDutyEntry.getDepartmentId().getId().equals(masdepartment.getId())){
					    %>
				<option value="<%=masdepartment.getId()%>" selected="selected"><%=masdepartment.getDepartmentName()%></option>
				<%}else{ %>
				<option value="<%=masdepartment.getId()%>"><%=masdepartment.getDepartmentName()%></option>
				<% }} else {%>
				<option value="<%=masdepartment.getId()%>"><%=masdepartment.getDepartmentName()%></option>
				<%}} %>
			</select></td>
			<td width="13%"><input type="text" value="" size="9"
				name="nextDutyDate" id="nextDutyDate<%=iFirstRow%>"
				readonly="readonly" /></td>
			<td width="13%"><img src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				tabindex="1"
				onClick="setdate('',document.getElementById('nextDutyDate<%=iFirstRow%>'),event)" />
			</td>
			<td width="40%"><Select name="dutyTime"
				id="dutyTime<%=iFirstRow%>">
				<%for(HrDutyTimeMaster hrDutyTimeMaster:dutyMasterList){ 
	if(hrDutyTimeMaster.getId()==hrOrderlyDutyEntry.getDutyTime().getId()){
	%>
				<option selected="selected" value="<%=hrDutyTimeMaster.getId()%>"><%=hrDutyTimeMaster.getDutyFromTime()%>-<%=hrDutyTimeMaster.getDutyToTime()%></option>
				<%}else{ %>
				<option value="<%=hrDutyTimeMaster.getId()%>"><%=hrDutyTimeMaster.getDutyFromTime()%>-<%=hrDutyTimeMaster.getDutyToTime()%></option>
				<%}} %>
			</select></td>
			<td><input type="text" name="typeStatus" id="typeStatus"
				value="<%=hrOrderlyDutyEntry.getTypeStatus()%>" readonly="readonly" /></td>
			<td width="40%">
			<%if(hrOrderlyDutyEntry.getRemarks()!=null){ %> <input type="text"
				value="<%=hrOrderlyDutyEntry.getRemarks()%>" name="remarks"
				id="remarks<%= iFirstRow%>" maxlength=30 /> <%}else{ %> <input
				type="text" value="" name="remarks" id="remarks<%= iFirstRow%>"
				maxlength=30 /> <%} %>
			<td><input type="checkbox" class="radio" name="dutyToBeUpdated"
				class="smcaption" value="<%=hrOrderlyDutyEntry.getId()%>">
			</td>
			<input type="hidden" value="<%=hrOrderlyDutyEntry.getId()%>"
				name="orderlyDutyId" />
		</tr>
		<% } %>
	</tbody>
</table>
<% } %>
</div>

<div class="Clear"></div>
<div id="pagination">
<% if (totalPages > 0 ) { %> Page <span class="selected"><%=pageno %></span>
of <span class="selected"><%=totalPages %></span> <a
	href="javascript:goPrevious()">Previous</a> <a
	href="javascript:goNext()">Next</a> <input type="button" name="Go Page"
	type="submit" value="Go Page" class="button"
	onclick="javascript:GoPage();"> <input type="text"
	name="gopage" size="3" /> <% } %>
</div>
<div class="Clear"></div>

<% if ((dutyEntryList!=null && dutyEntryList.size()>0)||(searchOrderlyDutyList!=null && searchOrderlyDutyList.size()>0)) { %>
<div class="division"></div>
<div class="bottom"><input type="button" name="update"
	onClick="jsUpdate()" value="update" class="button" /> <input
	type="button" name="delete"
	onClick="if (validateButton()){submitForm('orderlyDuty','hrRelated?method=deleteOrderlyDutyEntry');}else{alert('Pl. Select Employee to delete.');}"
	value="Delete" class="button" />
<div class="division"></div>
</div>
<%} %>
</div>
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" />
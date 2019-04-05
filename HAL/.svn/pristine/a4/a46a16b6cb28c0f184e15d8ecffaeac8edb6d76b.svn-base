
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

<script type="text/javascript" language="javascript">

function GoPage1() {	
		var pgno = parseInt(monthlyRationAccounting.gopage.value);
		var totalPages = parseInt(monthlyRationAccounting.totalPages.value);
		if (pgno < 1 || pgno > totalPages)
		{
		alert('Invalid Page No!.....');
		return;
		}  
		monthlyRationAccounting.pageno.value = pgno; 
		monthlyRationAccounting.method="post";
		submitForm('monthlyRationAccounting','hrOrderly?method=getGridDataForMonthlyRationStrength');
}
function goNext()
{
	 var pgno = parseInt(monthlyRationAccounting.pageno.value)+1;
	 if (pgno > monthlyRationAccounting.totalPages.value)
	 {
	 alert('End of the File Reached!... ');
	 return;
	 }
	 
	 monthlyRationAccounting.pageno.value = pgno;
	 monthlyRationAccounting.method="post";
	 submitForm('monthlyRationAccounting','hrOrderly?method=getGridDataForMonthlyRationStrength');
	}
function goPrevious()
	{
	 var pgno = parseInt(monthlyRationAccounting.pageno.value)-1;
	 if (pgno < 1)
	 {
	 alert('Beginning of the File Reached!... ');
	 return;
	 }
	 
	 monthlyRationAccounting.pageno.value = pgno;
	 monthlyRationAccounting.method="post";
	 submitForm('monthlyRationAccounting','hrOrderly?method=getGridDataForMonthlyRationStrength');
}
function detailEmployee(rationId , month , year )
{
		var url="/hms/hms/hrOrderly?method=getDetailsForEmployeeAbsence&rationId="+rationId+"&month="+month+"&year="+year ;
		newwindow=window.open(url,'name',"top=50, left=50, height=600,width=950,status=1, scrollbars=1,resizable=1");
	
}

		
		</script>

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
		
	List<HrMonthlyRationAccounting> hrMonthlyRationAccountingList = new ArrayList<HrMonthlyRationAccounting>();
	List<HrorderlyMonthlyRationAccounting> rationList = new ArrayList<HrorderlyMonthlyRationAccounting>();
	List<HrDutyTimeMaster> dutyMasterList = new ArrayList<HrDutyTimeMaster>();
	List<HrorderlyLeaveApplication> leaveAppList = new ArrayList<HrorderlyLeaveApplication>();
	List<Object> objectList = new ArrayList<Object>();
	List<MovementOutEntry> moveOutList = new ArrayList<MovementOutEntry>();
	if (request.getAttribute("map") != null) 
	{
		map = (Map)request.getAttribute("map");
	}
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(session.getAttribute("hospitalId") != null){
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	if(map.get("hrMonthlyRationAccountingList")!=null)
	{
		hrMonthlyRationAccountingList = (List<HrMonthlyRationAccounting>)map.get("hrMonthlyRationAccountingList");
	}
	if(map.get("rationList")!=null)
	{
		rationList = (List)map.get("rationList");
	}
	if(map.get("objectList")!=null)
	{
		objectList = (List<Object>)map.get("objectList");
	}
	System.out.println("objectList Size  "+objectList.size());
	if(map.get("leaveAppList")!=null)
	{
		leaveAppList = (List)map.get("leaveAppList");
	}
	if(map.get("moveOutList")!=null)
	{
		moveOutList = (List)map.get("moveOutList");
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
			
	String message ="";
	System.out.println("pageno::"+pageno+"::totalPages::"+totalPages+"::totalRecords::"+totalRecords);
	%>

<% 
	if (map.get("message") != null) {
			 message = (String) map.get("message");
			
		}
	if(!message.equalsIgnoreCase("")){
	%>

<h2><%=message %></h2>
<%} %>
<div class="Clear"></div>
<div id="contentHolder">
<form name="monthlyRationAccounting" action="" method="post">
<h6>Monthly Ration Accounting</h6>
<div class="Clear"></div>

<div class="division"></div>
<div class="blockFrame"><label>Month</label> <select
	name="month" id="month">
	<option value="0">Select</option>
	<%if(box.get("month")!=null  && !box.get("month").equals("")){ 
		if(box.get("month").equals("01")){
	%>
	<option value="01" selected="selected">Jan</option>
	<%	}else{ %>
	<option value="01">Jan</option>
	<%	}if(box.get("month").equals("02")){ %>
	<option value="02" selected="selected">Feb</option>
	<%	}else{ %>
	<option value="02">Feb</option>
	<%	}if(box.get("month").equals("03")){ %>
	<option value="03" selected="selected">Mar</option>
	<%	}else{ %>
	<option value="03">Mar</option>
	<%	}if(box.get("month").equals("04")){ %>
	<option value="04" selected="selected">Apr</option>
	<%	}else{ %>
	<option value="04">Apr</option>
	<%  }if(box.get("month").equals("05")){ %>
	<option value="05" selected="selected">May</option>
	<%  }else{ %>
	<option value="05">May</option>
	<%  }if(box.get("month").equals("06")){ %>
	<option value="06" selected="selected">June</option>
	<%}else{ %>
	<option value="06">June</option>
	<%}		if(box.get("month").equals("07")){ %>
	<option value="07" selected="selected">July</option>
	<%}else{ %>
	<option value="07">July</option>

	<%}		if(box.get("month").equals("08")){ %>
	<option value="08" selected="selected">August</option>
	<%}else{ %>
	<option value="08">August</option>

	<%}		if(box.get("month").equals("09")){ %>
	<option value="09" selected="selected">September</option>
	<%}else{ %>
	<option value="09">September</option>
	<%}		if(box.get("month").equals("10")){ %>
	<option value="10" selected="selected">October</option>
	<%}else{ %>
	<option value="10">October</option>
	<%}		if(box.get("month").equals("11")){ %>
	<option value="11" selected="selected">November</option>
	<%}else{ %>
	<option value="11">November</option>
	<%}		if(box.get("month").equals("12")){ %>
	<option value="12" selected="selected">December</option>
	<%}else{ %>
	<option value="12">December</option>


	<%	}
	  }else{
	%>
	<option value="01">Jan</option>
	<option value="02">Feb</option>
	<option value="03">Mar</option>
	<option value="04">Apr</option>
	<option value="05">May</option>
	<option value="06">June</option>
	<option value="07">July</option>
	<option value="08">August</option>
	<option value="09">September</option>
	<option value="10">October</option>
	<option value="11">November</option>
	<option value="12">December</option>
	<%	} %>
</select> <%
	String flag= "false";
	Date tempDate=new Date();
	int currentYear=1900+tempDate.getYear();
	int pastYear=1900+tempDate.getYear()-1;
	int futureYear=1900+tempDate.getYear()+1;
	%> <label>Year</label> <select name="year" id="year"
	onblur="submitForm('monthlyRationAccounting','hrOrderly?method=showMonthlyRationAccountingRecords&pageno=1&totalPages=0&totalRecords=0')"
	onchange="submitForm('monthlyRationAccounting','hrOrderly?method=showMonthlyRationAccountingRecords&pageno=1&totalPages=0&totalRecords=0')">
	<option value="0">Select</option>
	<%
			if(box.get("year")!=null && !box.get("year").equals("")){
				if(Integer.parseInt(box.get("year"))==pastYear){
		%>
	<option value="<%=pastYear%>" selected="selected"><%=pastYear%></option>
	<%		}else{ %>
	<option value="<%=pastYear%>"><%=pastYear%></option>
	<%		}if(Integer.parseInt(box.get("year"))==currentYear){ %>
	<option value="<%=currentYear%>" selected="selected"><%=currentYear%></option>
	<%		}else{ %>
	<option value="<%=currentYear%>"><%=currentYear%></option>
	<%		
			}
			}else{
		%>
	<option value="<%=pastYear%>"><%=pastYear%></option>
	<option value="<%=currentYear%>"><%=currentYear%></option>

	<%	} %>
</select>
<!-- <input type="button" name="Add" type="submit" value="Import Employee's"
	onClick="add();" class="cmnButton">-->
</div>
<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" />
<input type="hidden" name="monthlyRationId" id="monthlyRationId" value="" />
<input type="hidden" name="pageno" value=<%=pageno%> />
<input type="hidden" name="totalPages" value=<%=totalPages%> />
<input type="hidden" name="totalRecords" value=<%=totalRecords%> />
<input type="hidden" name="numOfRows" value="10" />
<%if(map.get("month")!=null && ! map.get("month").equals("")){ %>
<input type="hidden" name="monthFroPagenation" value="<%=map.get("month").toString() %>" />
<%} %>
<%if(map.get("year")!=null && ! map.get("year").equals("")){%>
<input type="hidden" name="yearFroPagenation" value="<%=map.get("year").toString() %>" />
<%} %>

<div class="Clear"></div>

<% if (hrMonthlyRationAccountingList != null && hrMonthlyRationAccountingList.size()==0) { %>
<div class="blockTitle">Monthly Ration Accounting</div>
<div class="blockTitleCurve"></div>
<div class="tableHolderAuto">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th rowspan="2" scope="col">S. NO.</th>
		<th rowspan="2" scope="col">Service No.</th>
		<th rowspan="2" scope="col">Rank</th>
		<th rowspan="2" scope="col">Name &amp; Initials</th>
		<th rowspan="2" scope="col">Number of Leaves</th>
		<th rowspan="2" scope="col">Number of TD/ DETT</th>
		<th rowspan="2" scope="col">Number of Days Hosp</th>
		<th rowspan="2" scope="col">Number of AWL</th>
		<th rowspan="2" scope="col">No. of Ration drawn</th>
		<th rowspan="2" scope="col">Money drawn in lieu</th>
		<th rowspan="2" scope="col">POR No.</th>
		<th rowspan="2" scope="col">Occu. No.</th>
		<th rowspan="2" scope="col">Click to Get Detail</th>  
	</tr>
	
</table>

</div>

<% } else if(hrMonthlyRationAccountingList != null && hrMonthlyRationAccountingList.size()>0){ 
	 
	 %>
<div class="blockTitle">Monthly Ration Accounting</div>
<div class="blockTitleCurve"></div>
<div class="tableHolderAuto">
<table width="98%" colspan="7" id="tblSample" border="0" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
		<th rowspan="2" scope="col">S. NO.</th>
		<th rowspan="2" scope="col">Service No.</th>
		<th rowspan="2" scope="col">Rank</th>
		<th rowspan="2" scope="col">Name &amp; Initials</th>
		<th rowspan="2" scope="col">Number of Leaves</th>
		<th rowspan="2" scope="col">Number of TD/ DETT</th>
		<th rowspan="2" scope="col">Number of Days Hosp</th>
		<th rowspan="2" scope="col">Number of AWL</th>
		<th rowspan="2" scope="col">Money drawn in lieu</th>
		<th rowspan="2" scope="col">No. of Ration drawn</th>
		<th rowspan="2" scope="col">POR No.</th>
		<th rowspan="2" scope="col">Occu. No.</th>
		<th rowspan="2" scope="col">Click to Get Detail</th>  
	</tr>
	</thead>
	<tbody>

		<%
		 int counter=(pageno-1)*10;
			for(HrMonthlyRationAccounting hrMonthlyRationAccounting :hrMonthlyRationAccountingList){
	%>
		<tr>
			<td><%=++counter%><input type="hidden" values="<%=hrMonthlyRationAccounting.getEmployeeId().getId() %>" name="employeeId" /></td>
			<td width="13%"><input type="text" value="<%=hrMonthlyRationAccounting.getServiceNo()%>"
				size="6" name="pvms" readonly="readonly" style="width:60px;" /></td>
			<td width="20%"><input type="text" value="<%=hrMonthlyRationAccounting.getRankName()%>"
				name="nomenclature" readonly="readonly" style="width:70px;" /></td>
			<td width="12%"><input type="text" value="<%=hrMonthlyRationAccounting.getName()%>"
				name="au" readonly="readonly"  /></td>
			<%if(hrMonthlyRationAccounting.getEmployeeCode().equals("E")){ %>
			<td width="12%"><input type="text" value="<%=hrMonthlyRationAccounting.getEffOfLeaveDays() %>"
				name="au" readonly="readonly" style="width:30px;"/></td>
			<td width="12%"><input type="text" value="<%=hrMonthlyRationAccounting.getEffOfTdDays() %>"
				name="au" readonly="readonly" style="width:30px;"/></td>
			<td width="12%"><input type="text" value="<%=hrMonthlyRationAccounting.getEffOfInpatientDays() %>"
				name="au" readonly="readonly" style="width:30px;"/></td>
			<td width="12%"><input type="text" value="<%=hrMonthlyRationAccounting.getEffOfAwlDays() %>"
				name="au" readonly="readonly" style="width:30px;"/></td>
			<%}else{ %>
			<td colspan="4" ><input type="text" value="<%="TD From other Unit Form " + HMSUtil.convertDateToStringWithoutTime(hrMonthlyRationAccounting.getDateOfJoining())+" To " + HMSUtil.convertDateToStringWithoutTime(hrMonthlyRationAccounting.getDateOfPosting())%>"
				name="au" readonly="readonly" style="width:280px;"/></td>
			<%} %>		
			<td width="12%"><input type="text" value="<%=hrMonthlyRationAccounting.getNoOfMoneyDrawn() %>"
				name="au" readonly="readonly" style="width:50px;"/></td>
			<td width="12%"><input type="text" value="<%=hrMonthlyRationAccounting.getNoOfRationDrawn()  %>"
				name="au" readonly="readonly" style="width:50px;"/></td>
			<td width="12%"><input type="text" value="" name="porNo" style="width:80px;" /></td>
			<td width="12%"><input type="text" value="" name="occurrenceNo" style="width:80px;" /></td>
			<%if(hrMonthlyRationAccounting.getEmployeeCode().equals("E")){ %>
			<td width="12%"><input type="button"  class="cmnButton" value="Get Detail" name="detail" onclick="detailEmployee(<%=hrMonthlyRationAccounting.getId() %> ,<%=hrMonthlyRationAccounting.getMonth() %> ,<%=hrMonthlyRationAccounting.getYear() %> );" /></td>
		    <%}else{ %>
		    <td width="12%"><input type="button"  class="cmnButton" value="Get Detail" name="detail" disabled="disabled" /></td>
		    <%} %>
		</tr>
		<%} %>
	</tbody>
</table>
<% } %>
</div>

<div class="Clear"></div>
<div id="pagination">
<% if (totalPages > 0 ) { %> Page <span class="selected"><%=pageno %></span>
of <span class="selected"><%=totalPages %></span> <a
	href="javascript:goPrevious()">Previous</a> <a
	href="javascript:goNext()">Next</a>
<input type="button" name="GoPage" 	type="submit" value="Go Page" class="button" onclick="GoPage1();">
<input type="text"	name="gopage" id="gopage" size="3" /> <% } %>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="bottom" >
<% if (hrMonthlyRationAccountingList!=null && hrMonthlyRationAccountingList.size()>0) { %>
<div class="division"></div>
<div class="bottom">
<input type="button" class="button"	name="update"
	onClick="submitForm('monthlyRationAccounting','hrOrderly?method=showPrintScreenForMonthlyRationAccounting');"
	value="Print Reports " /> <%} %>
<div class="division"></div>
</div>

</div>

<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" />
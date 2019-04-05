<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.HrLeaveTypeMaster"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasEmployee;"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<!--main content placeholder starts here-->
<div id="contentHolder">
<h6>Leave Maintenance Entry</h6>
<div class="Clear"></div>

<script type="text/javascript" language="javascript"><!--
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		String time=String.valueOf(calendar.getTime());
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
</script> <script type="text/javascript">
function calculateTotalLeaves()
{	
	
	var msg="";
	var leaveFrom=document.getElementById('leaveFromDate').value;
	var dateOfReporting=document.getElementById('dateOfReporting').value;
	leaveDate = new Date(leaveFrom.substring(6),(leaveFrom.substring(3,5) - 1) ,leaveFrom.substring(0,2));
	reportingDate = new Date(dateOfReporting.substring(6),(dateOfReporting.substring(3,5) - 1) ,dateOfReporting.substring(0,2));
		if(leaveFrom!="")
		{
			if(reportingDate < leaveDate)
			{	
				alert("Date of Reporting should be greater than Leave Date!!");
				document.getElementById('dateOfReporting').value="";
				return false;
			}
			
		}
		else
		{
			alert("First fill Leave Date");
			document.getElementById('dateOfReporting').value="";
			return false;
		}
		var one_day=1000*60*60*24;
		var totalLeaves=Math.ceil((reportingDate.getTime()-leaveDate.getTime())/(one_day));
		document.getElementById("totalLeave").value=totalLeaves;
		return true;
		
}
</script> <%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> employeeMap = new HashMap<String, Object>();
		BigDecimal totalAL=new BigDecimal("0");
		BigDecimal totalCL=new BigDecimal("0");
		BigDecimal totalSL=new BigDecimal("0");
		List<HrLeaveTypeMaster> leaveTypeList = new ArrayList<HrLeaveTypeMaster>();
		List<MasEmployee>employeeList=new ArrayList<MasEmployee>();

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("employeeList") != null){
			employeeList= (List<MasEmployee>)map.get("employeeList");
		}
		if(map.get("totalAL") != null){
			totalAL= (BigDecimal)map.get("totalAL");
		}
		if(map.get("totalCL") != null){
			totalCL= (BigDecimal)map.get("totalCL");
		}
		if(map.get("totalSL") != null){
			totalSL= (BigDecimal)map.get("totalSL");
		}
		if(map.get("leaveTypeList") != null){
			leaveTypeList= (List<HrLeaveTypeMaster>)map.get("leaveTypeList");
		}
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
		}
		String userName = "";
	 	if (session.getAttribute("userName") != null) {
	 		userName = (String) session.getAttribute("userName");
	 	}
	 	Map<String, Object> utilMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String currentTime = (String) utilMap.get("currentTime");
	%>


<form name="leaveMaintenanceEntry" action="" method="post">

<div class="blockTitle">Employee Details</div>
<div class="blockTitleCurve"></div>

<div class="blockFrame">
<div class="Clear"></div>
<%for(MasEmployee masEmployee:employeeList){ %> <label>Service No.</label>
<input type="text" name="serviceNo" class="value" id="serviceNo"
	value="<%=masEmployee.getServiceNo()%>" readonly="readonly" /> <input
	type="hidden" name="empId" value="<%=masEmployee.getId()%>" /> <label>Rank</label>
<input type="text" name="rankName" class="value" id="rankName"
	value="<%=masEmployee.getRank().getRankName()%>" readonly="readonly" />

<label>Name</label> <input name="firstName" type="text" class="value"
	id="firstName"
	value="<%=masEmployee.getFirstName()%> <%=masEmployee.getLastName() %>"
	readonly="readonly" />
<div class="Clear"></div>

<label>Leave Choice1</label> <%if(masEmployee.getLeaveChoice1()!=null){ %>
<input name="choice1" type="text" class="value" id="choice1"
	value="<%=masEmployee.getLeaveChoice1() %>" readonly="readonly" /> <%}else{ %>
<input name="choice1" type="text" class="value" id="choice1" value=""
	readonly="readonly" /> <%} %> <label>Leave Choice2</label> <%if(masEmployee.getLeaveChoice2()!=null){ %>
<input name="choice2" type="text" class="value" id="choice2"
	value="<%=masEmployee.getLeaveChoice2() %>" readonly="readonly" /> <%}else{ %>
<input name="choice2" type="text" class="value" id="choice2" value=""
	readonly="readonly" /> <%} %>
<div class="Clear"></div>
<%} %>
</div>
<div class="Clear"></div>

<div class="blockTitle">Leave Available Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Leave Type</th>
		<th scope="col">Available Leaves</th>

	</tr>
	<tr>
		<td>AL</td>
		<td><%=totalAL %></td>
	</tr>
	<tr>
		<td>CL</td>
		<td><%=totalCL %></td>
	</tr>
	<tr>
		<td>SL</td>
		<td><%=totalSL %></td>
	</tr>
</table>
</div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label><span>*</span> Leave Type</label> <select id="leaveType"
	name="leaveType" validate="Leave Type,String,yes">
	<option value="0">Select</option>
	<%for(HrLeaveTypeMaster hrLeaveTypeMaster:leaveTypeList){ %>
	<option value="<%=hrLeaveTypeMaster.getId() %>"><%=hrLeaveTypeMaster.getLeaveType() %></option>
	<%} %>
</select> <label><span>*</span> Leave From</label> <input type="text"
	id="leaveFromDate" class="calDate" name="<%=LEAVE_FROM_DATE %>"
	value="" MAXLENGTH="30" readonly="readonly"
	validate="Leave From Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.leaveMaintenanceEntry.<%=LEAVE_FROM_DATE%>,event);" />

<label><span>*</span> Date of Reporting</label> <input type="text"
	id="dateOfReporting" class="calDate" name="<%=DATE_OF_REPORTING %>"
	value="" MAXLENGTH="30" readonly="readonly"
	validate="Date of Reporting,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" onchange="calculateTotalLeaves();"
	class="calender"
	onClick="setdate('<%=currentDate%>',document.leaveMaintenanceEntry.<%=DATE_OF_REPORTING%>,event);" />

<div class="Clear"></div>
<label>Total Leave</label> <input name="totalLeave"
	onfocus="calculateTotalLeaves();" type="text" id="totalLeave" value=""
	readonly="readonly" />

<div class="Clear"></div>
</div>

<!--table-->
<div class="division"></div>
<div class="bottom"><input name="submitButton" type="button"
	class="button" value="Submit"
	onclick="submitForm('leaveMaintenanceEntry','hrRelated?method=submitLeaveMaintenanceEntry');" />
<input name="Button" type="reset" class="button" value="Reset" /> <input
	name="cancelButton" type="button" class="button" value="Cancel"
	onclick="submitForm('leaveMaintenanceEntry','hrRelated?method=showLeaveMaintenanceSearchJsp');" />
<div class="division"></div>
<!--Bottom labels starts--> <label>Changed By</label> <label
	class="value"><%=userName %></label> <input type="hidden"
	value="<%=userName %>" name="changedBy" /> <label>Changed Date</label>
<label class="value"><%=currentDate %></label> <input type="hidden"
	value="<%=currentDate %>" name="changedDate" /> <label>Changed
Time</label> <label class="value"><%=currentTime %></label> <input type="hidden"
	value="<%=currentTime %>" name="changedTime" />
<div class="Clear"></div>

</div>
<!--Bottom labels starts--> <!--main content placeholder ends here--></form>
</div>


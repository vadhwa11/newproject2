
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.HrDutyMaster"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
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
<h6>Leave Application pending for Recommendation Details</h6>
<div class="Clear"></div>

<script type="text/javascript" language="javascript">
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
				<%
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> employeeMap = new HashMap<String, Object>();
				BigDecimal totalAL=new BigDecimal("0");
				BigDecimal totalCL=new BigDecimal("0");
				BigDecimal totalSL=new BigDecimal("0");
				
				List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
				List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
				List<HrorderlyLeaveApplication>leaveMaintenanceList=new ArrayList<HrorderlyLeaveApplication>();
				
				String entryNo="";
				int hospitalId=0;
				
				if (session.getAttribute("hospitalId") != null) 
				{
					Integer temp =  (Integer)session.getAttribute("hospitalId");
					hospitalId = temp.intValue();
				}
		
				if(request.getAttribute("map") != null){
					map = (Map<String, Object>)request.getAttribute("map");
				}
				if(map.get("employeeList") != null){
					employeeList= (List<MasEmployee>)map.get("employeeList");
				}
				if(map.get("dutyList") != null){
					dutyList= (List<HrDutyMaster>)map.get("dutyList");
				}
				if(map.get("leaveMaintenanceList") != null){
					leaveMaintenanceList= (List<HrorderlyLeaveApplication>)map.get("leaveMaintenanceList");
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
		

	</script>



<form name="leavePendingEntry" action="" method="post">

<div class="blockTitle">Employee Details</div>
<div class="blockTitleCurve"></div>

<div class="blockFrame">
<div class="Clear"></div>
<% System.out.println("leaveMaintenanceList="+leaveMaintenanceList.size());
	for(HrorderlyLeaveApplication hrLeaveMaintenance:leaveMaintenanceList){ %>
<label>Service No.</label> <label class="value"><%=hrLeaveMaintenance.getEmployee().getServiceNo()%></label>
<input type="hidden" name="leaveId"
	value="<%=hrLeaveMaintenance.getId()%>" /> <label>Rank</label> <label
	class="value"><%=hrLeaveMaintenance.getEmployee().getRank().getRankName()%></label>

<label>Name</label> <label class="value"><%=hrLeaveMaintenance.getEmployee().getFirstName()%>
<%=hrLeaveMaintenance.getEmployee().getLastName() %></label>
<div class="Clear"></div>

<label> Application Date</label> <%if(hrLeaveMaintenance.getApplicationDate()!=null){ %>
<label class="value"><%=HMSUtil.convertDateToStringWithoutTime(hrLeaveMaintenance.getApplicationDate())%></label>
<%}else{ %> <label>&nbsp</label> <%} %> <label> Leave From</label> <label
	class="value"><%=HMSUtil.convertDateToStringWithoutTime(hrLeaveMaintenance.getLeaveFromDate())%></label>

<label> Reporting Date</label> <label class="value"><%=HMSUtil.convertDateToStringWithoutTime(hrLeaveMaintenance.getDateOfReporting())%></label>

<div class="Clear"></div>


<label> Total Leaves</label> <label class="value"><%=hrLeaveMaintenance.getLeaveTotalDays()%></label>
<div class="Clear"></div>


<%} %>
</div>
<div class="division"></div>
<div class="blockFrame"><label><span>*</span> Approved</label> <select
	name="approved" id="approved" validate="Approved,String,yes">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select> <label><span>*</span> Approved By</label> <select name="approvedBy"
	id="approvedBy" validate="Approved By,String,yes">
	<option value="">Select</option>
	<%for(MasEmployee masEmployee:employeeList){ %>
	<%
	 String name ="";
	 if(masEmployee.getFirstName()!=null){
		 name=name+masEmployee.getFirstName()+" ";
	 }
	 if(masEmployee.getMiddleName()!=null){
		 name=name+masEmployee.getMiddleName()+" ";
	 }
	 if(masEmployee.getLastName()!=null){
		 name=name+masEmployee.getLastName()+" ";
	 }
	%>
	<option value="<%=masEmployee.getId()%>"><%=name%></option>
	<%} %>
</select> <label><span>*</span> Approved Date</label> <input type="text"
	id="approvedDate" name="approvedDate" value="<%=currentDate%>"
	MAXLENGTH="30" readonly="readonly" class="calDate" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate%>',document.leavePendingEntry.approvedDate,event);" />
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" />
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<!--table-->
<div class="division"></div>
<div class="bottom"><input name="submitButton" type="button"
	class="button" value="Submit"
	onclick="submitForm('leavePendingEntry','hrRelated?method=submitLeavePendingEntry');" />
<input name="Button" type="reset" class="button" value="Reset" /> <input
	name="cancelButton" type="button" class="button" value="Cancel"
	onclick="submitForm('leavePendingEntry','hrRelated?method=searchEmployeeForLeavePending');" />
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


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

	
		List<HrDutyEntry>dutyEntryList=new ArrayList<HrDutyEntry>();
		List<HrorderlyLeaveApplication> employeeLeaveList=new ArrayList<HrorderlyLeaveApplication>();
		List<HrDutyEntry>holidayEntryList=new ArrayList<HrDutyEntry>();
		
	if (map.get("dutyEntryList")!=null)
	{
		dutyEntryList = (List)map.get("dutyEntryList");
	}
	if (map.get("employeeLeaveList")!=null)
	{
		employeeLeaveList = (List)map.get("employeeLeaveList");
	}
	if (map.get("holidayEntryList")!=null)
	{
		holidayEntryList = (List)map.get("holidayEntryList");
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
			    for(HrDutyEntry hrDutyEntry :dutyEntryList){ 
			   
			    %>
		<tr>
			<td><%=HMSUtil.convertDateToStringWithoutTime(hrDutyEntry.getDutyDate()) %></td>
			<td><%=hrDutyEntry.getDutyTime().getDutyFromTime()%>-<%=hrDutyEntry.getDutyTime().getDutyToTime()%></td>
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
			    if(holidayEntryList!=null && holidayEntryList.size()>0){
			    %>
		<tr>
			<td><%=HMSUtil.convertDateToStringWithoutTime(holidayEntryList.get(0).getDutyDate()) %></td>
			<td><%=holidayEntryList.get(0).getDutyTime().getDutyFromTime()%>-<%=holidayEntryList.get(0).getDutyTime().getDutyToTime()%></td>
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
			    	for(HrorderlyLeaveApplication hrorderlyLeaveApplication:employeeLeaveList){
			    	if(hrorderlyLeaveApplication.getLeaveFromDate().after(HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")))){
			    %>
		<tr>
			<td><%=HMSUtil.convertDateToStringWithoutTime(hrorderlyLeaveApplication.getLeaveFromDate()) %></td>
			<td><%=HMSUtil.convertDateToStringWithoutTime(hrorderlyLeaveApplication.getDateOfReporting())%></td>
		</tr>
		<%}}}%>
	</tbody>
</table>
</div>
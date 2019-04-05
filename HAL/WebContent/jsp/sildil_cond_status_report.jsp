<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<div id="contentHolder"><script type="text/javascript"
	language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <%
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> utilMap = new HashMap<String, Object>();
		 	
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currenDate = (String) utilMap.get("currentDate");
		 	String time = (String) utilMap.get("currentTime");
		 	
		 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		 	
		 	if(request.getAttribute("map") != null){
				map = (Map<String, Object>)request.getAttribute("map");
			}
			if(map.get("departmentList") != null){
				departmentList = (List<MasDepartment>) map.get("departmentList");
			}
			if(map.get("serviceTypeList") != null){
				serviceTypeList = (List<MasServiceType>) map.get("serviceTypeList");
			}
			
			

	%>

<h6>SIL/DIL Condition Report </h6>
<div class="Clear"></div>

<form name="sildilCondReport" target="_blank" method="post" action="">
<div class="blockFrame">
<div id="divId"><label> From Date</label> <input type="text"
	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currenDate %>"
	class="calDate" readonly="readonly" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate %>',document.sildilCondReport.<%=FROM_DATE%>,event)" />
<label> To Date:</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currenDate %>" class="calDate"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate %>',document.sildilCondReport.<%=TO_DATE%>,event)" />
</div>

<div class="Clear"></div>

<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('sildilCondReport','mis?method=printSILDILStatusReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /> 
	
	
</form>
</div>



<script type="text/javascript">
</script>


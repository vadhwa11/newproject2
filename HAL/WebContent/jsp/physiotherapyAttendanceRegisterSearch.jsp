<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<%
int loginDeptId = 0;
if(session.getAttribute("deptId") != null){
	loginDeptId = (Integer)session.getAttribute("deptId");
}
%>
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
</script> <script type="text/javascript">
	function generatePhysiotherapyAttendanceRegister(){
				
			submitForm('physiotherapyAttendanceRegister','opd?method=generatePhysiotherapyAttendanceRegister','checkTargetForYes');
			checkTargetForNo();
	}
	
</script> <%
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasServiceStatus> serviceStatusList = new ArrayList<MasServiceStatus>();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String deptType = "";
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 	}
		if (map.get("serviceTypeList") != null) {
			serviceTypeList = (List) map.get("serviceTypeList");
	 	}
		if (map.get("serviceStatusList") != null) {
			serviceStatusList = (List) map.get("serviceStatusList");
	 	}
		if(session.getAttribute("deptType") != null){
			deptType = (String)session.getAttribute("deptType");
		}
		
	%>
<h6>Patient Attendance Register</h6>
<form name="physiotherapyAttendanceRegister" action="" method="post">
<div class="blockFrame"><label><span>*</span> Month</label> <select
	name="<%=MONTH%>" validate="Month,string,yes">
	<option value="0">Select</option>
	<option value="1">January</option>
	<option value="2">February</option>
	<option value="3">March</option>
	<option value="4">April</option>
	<option value="5">May</option>
	<option value="6">June</option>
	<option value="7">July</option>
	<option value="8">August</option>
	<option value="9">September</option>
	<option value="10">October</option>
	<option value="11">November</option>
	<option value="12">December</option>
</select> <label>Service Type </label> <select name="<%=SERVICE_TYPE_ID%>">
	<option value="">Select</option>
	<%for(MasServiceType masServiceType : serviceTypeList){ %>
	<option value="<%=masServiceType.getId()%>"><%=masServiceType.getServiceTypeName()%></option>
	<%} %>
</select>
<div class="Clear"></div>
<label>Service Status:</label> <select name="<%=SERVICE_STATUS_ID%>"
	tabindex=1>
	<option value="">Select</option>
	<% 
				for (MasServiceStatus masServiceStatus : serviceStatusList){
					%>
	<option value="<%=masServiceStatus.getId()%>"><%=masServiceStatus.getServiceStatusName()%></option>
	<%}%>
</select></div>
<div class="Clear"></div>
<div class="bottom"><input type="button" name="OK" value="OK"
	class="button" onClick="generatePhysiotherapyAttendanceRegister();" />
<input type="reset" name="Reset" id="reset" value="Reset" class="button"
	onclick="resetCheck();" accesskey="r" /></div>
</form>
</div>
<script type="text/javascript" language="javascript">		
function validateFromToDate(){
	
	var nowDate=new Date();
	
	obj1 = eval(document.physiotherapyAttendanceRegister.fromDate)
	obj2 = eval(document.physiotherapyAttendanceRegister.toDate)
		
	if(obj1.value != "" && obj2.value != "")
	{
	
	 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
	 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
			
		if(validFromDate<=nowDate)
			{
				if(validFromDate > validToDate)
				{
						alert("From Date should be smaller than To Date\n");
						return false;
				}
			}
			
		else
			{
			alert("From Date should not be greater than Current date\n");
			return false;
			}
	
	}
	return true;
}
</script>
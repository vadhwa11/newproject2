<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
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
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
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
function check()
	{
		var r = document.getElementById('mainChargeCodeId').value;
		if(r=="0")
		{
			alert("Please select Main Group")
			return false;
		}
		else
		{
			return true;
		}
	}
	
</script> <%
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
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
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		if(map.get("subChargeCodeList") != null){
			subChargeCodeList = (List<MasSubChargecode>)map.get("subChargeCodeList");
		}
		if(map.get("departmentList")!= null){
			departmentList = (List<MasDepartment>)map.get("departmentList");
		}
		if(session.getAttribute("deptType") != null){
			deptType = (String)session.getAttribute("deptType");
		}
		
	%>

<h6>Confidential Patient Register</h6>
<form name="confidentialDiagnosticRegisterDoctorWise" target="_blank"
	action="" method="post">
<div class="blockFrame"><label><span>*</span>From Date</label> <input
	type="text" class="calDate" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.confidentialDiagnosticRegisterDoctorWise.<%=FROM_DATE%>,event)" />

<label><span>*</span>To Date</label> <input type="text" class="calDate"
	id="ToDateId" name="<%=TO_DATE %>" value="<%=currentDate %>"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.confidentialDiagnosticRegisterDoctorWise.<%=TO_DATE%>,event)" />

<label>Patient </label> <select name="<%=PATIENT_TYPE%>">
	<option value="0">Select</option>
	<option value="IP">In Patient</option>
	<option value="OP">Out Patient</option>
</select>
<div class="Clear"></div>
<label>Department:</label> <select name="<%= DEPARTMENT_ID%>" tabindex=1>
	<option value="0">Select</option>
	<% 
				for (MasDepartment  masDepartment : departmentList){
					%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%}%>
</select> <label>Sub Group:</label> <select name="<%= SUB_CHARGECODE_ID %>"
	tabindex=1>
	<option value="0">Select</option>
	<% 
				for (MasSubChargecode  masSubChargecode : subChargeCodeList){
					%>
	<option value="<%=masSubChargecode.getId ()%>"><%=masSubChargecode.getSubChargecodeName()%></option>
	<%}%>
</select> <label>Result Type</label> <select id="resultType" name="resultType">
	<%if(deptType.equalsIgnoreCase("DIAG")){ %>
	<option value="s">Single</option>
	<option value="m">Multiple</option>
	<%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
	<option value="t" selected="selected">Template</option>
	<%} %>
</select></div>
<div class="Clear"></div>
<div class="bottom"><input type="button" name="OK" value="OK"
	class="button"
	onClick="submitForm('confidentialDiagnosticRegisterDoctorWise','lab?method=generateConfidentialPatientDiagnosticRegister','validateFromToDate');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="button"
	onclick="resetCheck();" accesskey="r" /></div>
</form>
</div>
<script type="text/javascript" language="javascript">		
function validateFromToDate(){
	
	var nowDate=new Date();
	
	obj1 = eval(document.confidentialDiagnosticRegisterDoctorWise.fromDate)
	obj2 = eval(document.confidentialDiagnosticRegisterDoctorWise.toDate)
		
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
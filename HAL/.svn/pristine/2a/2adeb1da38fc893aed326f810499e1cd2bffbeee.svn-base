<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
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
</script> <%
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
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
		if(map.get("investigationList") != null){
			investigationList=(List)map.get("investigationList");
		}
	%>

<h6>Direct / Indirect Combs Test Register</h6>
<form name="directIndirectRegister" target="_blank" action=""
	method="post">
<div class="blockFrame"><label><span>*</span>From Date</label> <input
	type="text" class="calDate" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.directIndirectRegister.<%=FROM_DATE%>,event)" />

<label><span>*</span>To Date</label> <input type="text" class="calDate"
	id="ToDateId" name="<%=TO_DATE %>" value="<%=currentDate %>"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.directIndirectRegister.<%=TO_DATE%>,event)" />
<label><span>*</span>Test Name</label> <select id="testId"
	name=<%=INVESTIGATION_NAME %> validate="Test Name,string,yes">
	<option value="0">Select</option>

	<%
							         		if(investigationList != null){ 	
							         			for (Iterator iter = investigationList.iterator(); iter.hasNext();) {
							         				DgMasInvestigation masInvestigation = (DgMasInvestigation) iter.next();
							         %>
	<option value="<%=masInvestigation.getInvestigationName() %>"><%=masInvestigation.getInvestigationName()%></option>
	<%		} } %>
</select></div>
<div class="Clear"></div>
<div class="bottom"><input type="button" name="OK" value="OK"
	class="button"
	onClick="submitForm('directIndirectRegister','bloodBank?method=printDirectIndirectRegisterReport','validateFromToDate');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="button"
	onclick="resetCheck();" accesskey="r" /></div>
</form>
</div>
<script type="text/javascript" language="javascript">		
function validateFromToDate(){
	
	var nowDate=new Date();
	
	obj1 = eval(document.directIndirectRegister.fromDate)
	obj2 = eval(document.directIndirectRegister.toDate)
		
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
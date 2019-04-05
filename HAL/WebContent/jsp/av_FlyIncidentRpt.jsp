
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Users"%>
<script type="text/javascript" language="javascript">
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
			
</script>
<script type="text/javascript">
function check(){
var SDate = document.incidentAccidentRpt.<%= FROM_DATE%>.value;
var EDate = document.incidentAccidentRpt.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<%
Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map") != null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		%>
<form name="incidentAccidentRpt" method="post" action="">
<div class="titleBg">
<h2>Flying Incident Report</h2>
</div>
<div class="clear"></div>
<div class="Block">

<label>From Date<span>*</span></label>
<input type="text" name="<%=FROM_DATE %>" value="<%=currentDate %>" MAXLENGTH="11" class="date" id="toAppDate" validate="Date,date,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.incidentAccidentRpt.<%=FROM_DATE %>,event)" />

<label>To Date<span>*</span></label>
<input type="text" name="<%=TO_DATE %>" value="<%=currentDate %>" MAXLENGTH="11" class="date" id="toAppDate" validate="Date,date,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.incidentAccidentRpt.<%=TO_DATE %>,event)" />

</div>
<div class="clear paddingTop10"></div>
<div class="division"></div>
<div class="clear paddingTop10"></div>
<input type="button" class="button" name="report" value="Print"  id="report"
onclick="submitForm('incidentAccidentRpt','/hms/hms/aviationMedicine?method=generateFlyingIncidentRpt','check()');" />
<input tabindex="1" name=Reset type=reset value=Reset class=button id=reset accessKey=r onclick=resetCheck(); />
</form>
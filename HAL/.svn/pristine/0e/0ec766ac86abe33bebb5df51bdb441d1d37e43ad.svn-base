
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

<%
Map<String, Object> utilMap = new HashMap<String, Object>();
String userName="";
if(session.getAttribute("userName")!=null)
 userName=(String)session.getAttribute("userName");
	Users users =null;
	if(session.getAttribute("users")!=null){
		users=(Users)session.getAttribute("users");
	}
		Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map") != null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		%>
<form name="trainingAirCrewRpt" method="post" action="">
<div class="titleBg">
<h2>Training Status of Aircrew Report</h2>
</div>
<div class="clear"></div>
<div class="Block">

<label>From Date<span>*</span></label>
<input type="text" name="<%=FROM_DATE %>" value="<%=currentDate %>" MAXLENGTH="20" class="date" id="toAppDate" validate="From Date,date,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.trainingAirCrewRpt.<%=FROM_DATE %>,event)" />

<label>To Date<span>*</span></label>
<input type="text" name="<%=TO_DATE %>" value="<%=currentDate %>" MAXLENGTH="20" class="date" id="toAppDate" validate="To Date,date,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.trainingAirCrewRpt.<%=TO_DATE %>,event)" />

</div>
<div class="clear paddingTop10"></div>
<div class="division"></div>
<div class="clear paddingTop10"></div>
<input type="button" name="add" id="addbutton" value="Ok" class="button" accesskey="a" tabindex=1
	onClick="submitForm('trainingAirCrewRpt','aviationMedicine?method=generateTrainingStatusRpt');" /> 
<input tabindex="1" name=Reset type=reset value=Reset class=button id=reset accessKey=r onclick=resetCheck(); />
</form>
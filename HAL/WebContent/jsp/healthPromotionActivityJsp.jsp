<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
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
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currenDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");


%>
<h6>Health Promotion Activity Details</h6>
<div class="Clear"></div>

<form name="healthPromotionActivity" target="_blank" method="post" action="">
<div class="Block">

<label>Rank Category</label>
<select name="RankCategory" tabindex="1" >
<option value="">Select</option>
<option value="Officers">Officers</option>
<option value="JCOs">JCO's</option>
<option value="Others">Others</option>
</select>

<label class="medium"> From Date<span>*</span> </label> 
<input	type="text" id="fromDateId" name="<%=FROM_DATE %>" 
	value="<%=currenDate %>" class="date" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currenDate %>',document.healthPromotionActivity.<%=FROM_DATE%>,event)" />

<label> To Date<span>*</span> </label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currenDate %>" class="date"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate %>',document.healthPromotionActivity.<%=TO_DATE%>,event)" />
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<input type="button" name="OK" value="Ok" class="button"
onClick="submitForm('healthPromotionActivity','mis?method=printHealthPromotionActivityReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
onclick="location.reload();" accesskey="r" />
</form>
</div> 
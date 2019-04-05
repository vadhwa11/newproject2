<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
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
		
		String userName = "";
	 	if (session.getAttribute("userName") != null) {
	 		userName = (String) session.getAttribute("userName");
	 	}
	 				 	Map<String, Object> utilMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");

	 	Map<String, Object> map = new HashMap<String, Object>();
	 	if (request.getAttribute("map") != null) {
	 		map = (Map<String, Object>) request.getAttribute("map");
	 	}
			
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<h6>Birth / Death Registration</h6>
<div class="Clear"></div>
<div class="blockFrame">
<form name="BirthDeathRegister" target="_blank" method="post" action="">

<label><span>*</span> From Date:</label> <input type="text"
	id="fromDateId" name="<%=FROM_DATE %>" class="calDate"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.BirthDeathRegister.<%=FROM_DATE%>,event)" />

<label><span>*</span> To Date:</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" class="calDate" readonly="readonly" MAXLENGTH="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.BirthDeathRegister.<%=TO_DATE%>,event)" />

<label>Register:</label> <label class="unit">Birth</label> <input
	type="radio" class="radio" name="<%=SELECTED_RADIO%>" value="birth"
	checked="checked"> <label class="unit">Death</label> <input
	type="radio" class="radio" name="<%=SELECTED_RADIO %>" value="death">
</div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('BirthDeathRegister','mis?method=showBirthDeathRegister');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />


</form>

</div>







<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript"
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
		
   	function checkTheOptions(){
    	    submitForm('injuryReport','adt?method=printInjuryReport');
}
		
</script>
<div class="titleBg">
<h2>Injury Report</h2>
</div>
<div class="Clear"></div>
<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 
			 	
			 	List<Object> list = null;
			 	Date toDate  = null;
				Date fromDate=null;
				
			
			 %>

<form name="injuryReport" target="_blank" method="post" action="">
<div class="Block">
<input type="hidden" name="OutType" id="OutType" value="Pdf" /> 
<label><span>*</span> From Date</label> <input
	type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currenDate %>" class="calDate" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currenDate%>',document.injuryReport.<%=FROM_DATE%>,event)" />


<label><span>*</span> To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currenDate %>" class="calDate"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate%>',document.injuryReport.<%=TO_DATE%>,event)" />
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('injuryReport','/hms/hms/adt?method=PrintInjuryReport');" /> 
	<input type="reset" name="Reset"
	value="Reset" class="button" onclick="location.reload();"
	accesskey="r" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</form>







<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder">
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
</script> <%
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
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
	%>

<h6> General Covering Letter </h6>
<form name="generalCoveringLetter" target="_blank" action="" method="post">
<div class="blockFrame">
<label><span>*</span>From Date</label> 
	<input 	type="text" class="calDate" id="fromDate" name="<%=FROM_DATE %>" value="<%=currentDate %>" validate="From Date,date,yes" MAXLENGTH="10" tabindex="1" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.generalCoveringLetter.<%=FROM_DATE%>,event)" />
	
	 <label><span>*</span>To Date</label>
	 <input type="text" class="calDate" id="toDate" name="<%=TO_DATE %>" value="<%=currentDate %>" validate="To Date,date,yes" MAXLENGTH="10" tabindex="1" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.generalCoveringLetter.<%=TO_DATE%>,event)" />
</div>
<div class="Clear"></div>
<div class="bottom"><input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('generalCoveringLetter','/hms/hms/mediClaim?method=printGeneralCoveringLettereReport','validateFromToDate');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" /></div>
</form>
</div>

<script type="text/javascript">
	function validateFromToDate(){
	
	var nowDate=new Date();
	
	obj1 = eval(document.generalCoveringLetter.fromDate)
	obj2 = eval(document.generalCoveringLetter.toDate)
		
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

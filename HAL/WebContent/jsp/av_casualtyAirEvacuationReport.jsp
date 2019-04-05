<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
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
var SDate = document.casualAirEvacuation.<%= FROM_DATE%>.value;
var EDate = document.casualAirEvacuation.<%= TO_DATE %>.value;
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
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
%>
<form name="casualAirEvacuation" method="post" action=""><br />
<div class="titleBg"><h2>Casualty Air Evacuation</h2></div><div class="clear"></div>
<div class="Block">
<label> From Date <span>*</span> </label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" class="date" MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />
<a	href="javascript:setdate('<%=currentDate%>',document.casualAirEvacuation.<%=FROM_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" /> </a> 

<label> To Date<span>*</span> </label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>" class="date" MAXLENGTH="30"	validate="Pick a to date,date,yes" readonly="readonly" /> 
<a	href="javascript:setdate('<%=currentDate%>',document.casualAirEvacuation.<%=TO_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" /> </a> <br>

</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<center>
<input type="button" name="add" id="addbutton" value="Ok" class="button"	
onClick="submitForm('casualAirEvacuation','aviationMedicine?method=generateCasualtyAirEvacuationReport','check()');"
	accesskey="a" tabindex=1 /> 
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
</center>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<div  id="contentHolder">
<form name="lunchDinnerDistribution" method="post" action="">
	
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
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}

		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");	
		String therapeutic ="";
		
		if(map.get("therapeutic") != null){
			therapeutic = (String)map.get("therapeutic");
		}

		if(therapeutic.equals("no")){
	%>
	<div class="Clear"></div>
		<h6>Lunch/Dinner Distribution Summary </h6>
		<%}else if(therapeutic.equals("yes")){ %>
		<h6>Lunch/Dinner Distribution Summary For Therapeutic</h6>
		<%} %>
		
		
<div class="Clear"></div>
	<div class="blockFrame">
	<input type="hidden" name="therapeutic" value="<%=therapeutic %>">
<label>Date:</label>
<input id="fromDateId" type="text" name="<%=DATE %>" value="<%=currentDate %>" class="calDate" readonly="readonly"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('',document.lunchDinnerDistribution.<%=DATE%>,event)"/> 
	<input type="radio" name="type" value="Lunch" class="radio" /><label class="noWidth">Lunch</label>
		<input type="radio" name="type" value="Dinner" class="radio" /><label class="noWidth">Dinner</label>
		</div>
		<div class="Clear"></div>
			<input type="button" name="OK" value="OK" class="button" onClick="submitForm('lunchDinnerDistribution','diet?method=printLunchDinnerSummaryReport');" />
			<input type="reset" name ="Reset" value ="Cancel" class="button" accesskey="r" />
			
	 </form>
	 </div>
	
		  		 
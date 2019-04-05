<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.net.URL"%>
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
		 	String currentDate = (String) utilMap.get("currentDate");
		 	
	%>
<h6>Ward Duty Entry Report</h6>
<div class="Clear"></div>
<form name="wardReport" target="_blank" method="post" action="">
<div id="divId" class="blockFrame"><label class="bodytextB"><span>*</span>
From Date</label> <input type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" class="textbox_date" readonly="readonly"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.wardReport.<%=FROM_DATE%>,event);" />

<label><span>*</span> To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="textbox_date"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.wardReport.<%=TO_DATE%>,event);" />

</div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="cmnButton"
	onClick="submitForm('wardReport','hrRelated?method=generateWardReport');" />
<input type="reset" name="Reset" value="Cancel" class="cmnButton"
	onclick="location.reload();" accesskey="r" /></form>
</div>

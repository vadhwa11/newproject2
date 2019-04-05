<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<div id="contentspace"><script type="text/javascript"
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
		 	
	%> <br />
<h2 align="left" class="style1">Search Advance</h2>
<br />

<form name="advanceSearch" target="_blank" method="post" action="">
<div id="divId"><label class="bodytextB"> From Date:</label> <input
	type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" class="textbox_date" readonly="readonly"
	MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currentDate %>',document.advanceSearch.<%=FROM_DATE%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <label class="bodytextB">
To Date:</label> <input type="text" id="ToDateId" name="<%=TO_DATE %>"
	value="<%=currentDate %>" class="textbox_date" readonly="readonly"
	MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currentDate %>',document.advanceSearch.<%=TO_DATE%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <br />

<input type="radio" name="reportType" value="advance"> <font
	class="wardspan">Advance</font> <input type="radio" name="reportType"
	value="refund"> <font class="wardspan">Refund</font></div>
<br />
<br />

<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('advanceSearch','billing?method=printAdvanceAndRefundHsrReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>
</div>

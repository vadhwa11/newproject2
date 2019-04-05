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

<h6>Range Firing Duty Entry Report</h6>
<div class="Clear"></div>
<form name="guardReport" target="_blank" method="post" action="">
<div id="divId" class="blockFrame"><label><span>*</span>Quarter
:-</label> <select name="quarter" id="quarter"
	validate="Select Quarter,string,yes">
	<option value="">Select</option>
	<option value="Jan-Mar">Jan-Mar</option>
	<option value="Apr-Jun">Apr-Jun</option>
	<option value="July-Sep">July-Sep</option>
	<option value="Oct-Dec">Oct-Dec</option>
</select> <%
	String flag= "false";
	Date tempDate=new Date();
	int currentYear=1900+tempDate.getYear();
	int pastYear=1900+tempDate.getYear()-1;
	int futureYear=1900+tempDate.getYear()+1;
	%> <label><span>*</span>Year :-</label> <select name="year" id="year"
	validate="Select year,string,yes">
	<option value="">Select</option>
	<option value="<%=pastYear%>"><%=pastYear%></option>
	<option value="<%=currentYear%>"><%=currentYear%></option>
	<option value="<%=futureYear%>"><%=futureYear%></option>
</select></div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="cmnButton"
	onClick="submitForm('guardReport','hrOrderly?method=generateRangeFiringReport');" />
<input type="reset" name="Reset" value="Cancel" class="cmnButton"
	onclick="location.reload();" accesskey="r" /></form>
</div>

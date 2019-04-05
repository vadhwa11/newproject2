<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
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
</script>

<h6>Initial Medical Examination Report</h6>
<form name="initialMedicalExamReport" target="_blank" action=""
	method="post">
<div class="blockFrame"><label><span>*</span>Month</label> <select
	name="<%=MONTH%>" validate="Month,string,yes" tabindex=1>

	<option value="1">Jan</option>
	<option value="2">Feb</option>
	<option value="3">Mar</option>
	<option value="4">Apr</option>
	<option value="5">May</option>
	<option value="6">Jun</option>
	<option value="7">Jul</option>
	<option value="8">Aug</option>
	<option value="9">Sep</option>
	<option value="10">Oct</option>
	<option value="11">Nov</option>
	<option value="12">Dec</option>


</select> <label><span>*</span>Year(yyyy)</label> <input type="text"
	class="calDate" id="ToDateId" name="<%=YEAR %>"
	validate="Year,integer,yes" value="" MAXLENGTH="4" /></div>
<div class="Clear"></div>
<div class="bottom"><input type="button" name="OK" value="OK"
	class="button"
	onClick="submitForm('initialMedicalExamReport','medicalExaminationBoard?method=printInitialMedicalExam');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="button"
	onclick="resetCheck();" accesskey="r" /></div>
</form>
</div>
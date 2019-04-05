
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>


<%@page import="jkt.hms.util.HMSUtil"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>


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
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	int hospitalId = 0;
	Map<String, Object> map = new HashMap<String, Object>();

	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("hospitalId")!=null){
		hospitalId = (Integer)map.get("hospitalId");
	}
%>
<form name="sildilRegister" method="post" action="">
<input type="hidden" value="<%=hospitalId %>" name="hospitalId">
<div class="titleBg">
<h2>SIL/DIL Register</h2>
</div>
<div class="Block">
<label><span>*</span> From Date  </label> 
<input type="text" name="fromDate" value="<%=currentDate %>" MAXLENGTH="30" validate="From date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="To date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.sildilRegister.<%=FROM_DATE%>,event)" />
<label><span>*</span> To Date </label> 
<input type="text" name="toDate" value="<%=currentDate %>" MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.sildilRegister.<%=TO_DATE%>,event)" />

<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" value="Print" class="button" onClick="submitForm('sildilRegister','/hms/hms/mis?method=printSILDILRegisterReport');" accesskey="a" tabindex=1 />
<input type="reset" name="clear" id="clearbutton" value="Reset" class="button" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>








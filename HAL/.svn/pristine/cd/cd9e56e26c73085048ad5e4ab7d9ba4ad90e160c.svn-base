
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

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
%>
<div id="contentHolder">
<form name="workLoadRegister" method="post" action="">

<div class="titleBg">
<h2>Work Load Register</h2>
</div>
<div class="Block">
<label class="noWidth"><span>*</span>Year:</label> <select id="postYear"
	name="postYear" validate="Year,String,yes">
	<option value="">Select</option>
	<option value="<%=year-1 %>"><%=year-1 %></option>
	<option value="<%=year %>"><%=year %></option>
	<option value="<%=year+1 %>"><%=year+1 %></option>
</select> 
<div class="Clear"></div>
<input type="button" name="add" value="Ok" class="button"
	onClick="submitForm('workLoadRegister','ot?method=generateWorkLoadRegisterReport');"
	accesskey="a" tabindex=1 /> <input type="button" name="clear"
	value="Clear" class="button"
	onClick="clearButton('workLoadRegister');" accesskey="a" tabindex=1 />
</div>
</form>
</div>

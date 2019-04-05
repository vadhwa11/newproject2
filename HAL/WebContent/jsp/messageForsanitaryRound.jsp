<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
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
Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}String message="";
if(map.get("message") != null){
	message = (String)map.get("message");
}
int sanitaryId=0;
if(map.get("sanitaryId")!=null)
{
	sanitaryId=  (Integer) map.get("sanitaryId");
	//System.out.println("FhId---CON->"+FhId);
}
%>
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
String currenDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");


%>
<form name="sanitaryRound" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>

<input type="hidden" name="sanitaryId" value="<%=sanitaryId%>" />
<input type="button" name="Yes" value="Print" onclick="submitForm('sanitaryRound','/hms/hms/mis?method=printSanitaryRoundDetail');" />
<input type="button" name="No" value="No" class="button"	onclick="history.back();" />

<div class="clear"></div>
<div class="division"></div>
</form>
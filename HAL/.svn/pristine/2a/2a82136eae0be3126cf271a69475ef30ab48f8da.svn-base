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
<script>serverdate = '<%=date+"/"+month+"/"+year%>'</script>
<%
String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	Box box = HMSUtil.getBox(request);
	date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTimeWithoutSc");
	
%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Calendar"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>

<label >Changed Date</label>
<label class="value"><%=date%></label>

<label >Changed Time</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

</div>
	
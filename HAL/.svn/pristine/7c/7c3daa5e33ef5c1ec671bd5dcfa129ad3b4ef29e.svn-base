<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
	
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
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
				Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
	%>
	
<form name="showAfmsfDispatchDetailsReport"  method="post" >

<div class="titleBg">
<h2>AFMSF-1 Dispatch Details</h2>
</div>
  
<div class="Block">
<label>From Date</label>
<input type="text" name="<%=FROM_DATE %>" value="<%=currentDate %>" class="date" readonly="readonly" maxlength="30" tabindex=1/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"  validate="Pick a date" onclick="setdate('<%=currentDate %>',document.showAfmsfDispatchDetailsReport.<%=FROM_DATE%>,event)" />
<label>To Date</label>
<input type="text"  name="<%=TO_DATE %>" value="<%=currentDate %>" class="date" readonly="readonly" MAXLENGTH="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.showAfmsfDispatchDetailsReport.<%=TO_DATE%>,event)" />
<div class="Clear"></div>	
</div>
<input type="button" name="OK" value="OK" class="button" target="_blank" onClick="submitForm('showAfmsfDispatchDetailsReport','/hms/hms/mis?method=showAfmsfReports&form=Dispatch');" />
<input type="reset" name ="Reset" value ="Cancel" class="button" onclick="location.reload();" accesskey="r" />

<div class="Clear"></div>						
</form>		

	
	
	
	
	
		  		 
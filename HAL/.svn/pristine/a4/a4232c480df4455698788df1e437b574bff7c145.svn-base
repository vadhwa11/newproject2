
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
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
			function fillServiceType(){
			var obj = document.getElementById("serviceType");
			var val = obj.value;
			for(i=0;i<obj.length;i++)
			{
				if(obj.options[i].value == val)
				{
					serviceName = obj.options[i].text
					break;
				}
			}
			if(serviceName !="Select"){
				document.getElementById("serviceTypeName").value =serviceName
			}else{
				document.getElementById("serviceTypeName").value =""
			}
			}
	</script> <br />
<h2 align="left" class="style1">Daily Bed Statistics</h2>
<br />


<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					
			 	
			 	List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
			 	
			 	
			 	List<Object> list = null;
			 	Date toDate  = null;
				Date fromDate=null;
				String category=null;
			 	
				
			 	
			 	if (map.get("serviceTypeList") != null) {
			 		serviceTypeList = (List<MasServiceType>) map.get("serviceTypeList");
			 	}
			 	
			 	
			 %>

<form name="dailyBedStats" target="_blank" method="post" action="">

<label class="bodytextB"><font id="error">*</font> To Date:</label> <input
	type="text" id="ToDateId" name="<%=TO_DATE %>" class="textbox_date"
	readonly="readonly" MAXLENGTH="30" value="<%=currenDate%>" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.dailyBedStats.<%=TO_DATE%>,event)" /> <br />
<br />
<div style="padding-left: 15px;"><input type="button" name="OK"
	value="OK" class="button"
	onClick="submitForm('dailyBedStats','mis?method=printDailyBedStats');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></div>

</form>


</form>
</div>






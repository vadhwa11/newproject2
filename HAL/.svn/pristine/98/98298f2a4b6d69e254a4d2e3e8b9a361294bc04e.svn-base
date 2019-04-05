<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<%@page import="java.net.URL"%>
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
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		int deptId= 0;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
	
		if (map.get("deptId") != null) {
			deptId= (Integer) map.get("deptId");
			}
	%>

<h6>Waiting Register for Pool Wise</h6>
<form name="doctorWise" target="_blank" action="" method="post">
<div class="blockFrame"><label><span>*</span>Category</label> <input
	type="radio" class="radio" name="<%=CATEGORY_NAME %>" value="o"
	checked="checked" /> <label class="valueNoWidth">Officers</label> <input
	type="radio" class="radio" name="<%=CATEGORY_NAME %>" value="a" /> <label
	class="valueNoWidth">Airmen</label>
<div class="Clear"></div>

</div>
<div class="bottom"><input type="button" name="OK" value="OK"
	class="button"
	onClick="submitForm('doctorWise','accom?method=generateWaitingRegisterPoolWise');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="button"
	onclick="resetCheck();" accesskey="r" /></div>
</form>
</div>


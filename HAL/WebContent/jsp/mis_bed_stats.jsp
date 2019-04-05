<%--
 * Copyright 2009 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * mis_bed_stats.jsp  
 * Purpose of the JSP - Bed Status  Report.
 * @author  Vishal Jain
 * Create Date: 15th Dec,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<br />

<div id="contentHolder">
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
	
	<script type="text/javascript">
	function convertMonthInString(month){
	var pMonth = "" ;
		if(month == 0){
			pMonth = "";
		}else if(month == 1){
			pMonth = "January";
		}else if(month == 2){
			pMonth = "February";
		}else if(month == 3){
			pMonth = "March";
		}else if(month == 4){
			pMonth = "April";
		}else if(month == 5){
			pMonth = "May";
		}else if(month == 6){
			pMonth = "June";
		}else if(month == 7){
			pMonth = "July";
		}else if(month == 8){
			pMonth = "August";
		}else if(month == 9){
			pMonth = "September";
		}else if(month == 10){
			pMonth = "October";
		}else if(month == 11){
			pMonth = "November";
		}else if(month == 12){
			pMonth = "December";
		}
		document.getElementById('monthStringId').value = pMonth;
	}
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <br />
<h6 align="left" class="style1">Bed Occupied Report</h6>
<br />


<%
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	List<Object> list = null;
			 	String strYear  = null;
				String strMonth = null;
			 	if (map.get("strYear") != null) {
			 		strYear = (String) map.get("strYear");
			  	}
			 	if (map.get("strMonth") != null) {
			 		strMonth = (String) map.get("strMonth");
			  	}
			 	
			 %>

<form name="misBedStatsReport" method="post" action="">

<div class="clear"></div>

<label> Month</label> <select name="<%=MONTH %>"
	validate="Month,string,yes" onchange="convertMonthInString(this.value)">
	<option value="0">Select</option>
	<option value="1">January</option>
	<option value="2">February</option>
	<option value="3">March</option>
	<option value="4">April</option>
	<option value="5">May</option>
	<option value="6">June</option>
	<option value="7">July</option>
	<option value="8">August</option>
	<option value="9">September</option>
	<option value="10">October</option>
	<option value="11">November</option>
	<option value="12">December</option>
</select> <input type="hidden" name="monthString" id="monthStringId" value="">
<label>Year</label> <select name="<%=YEAR %>" validate="Year,string,yes"">
	<option value="0">Select</option>
	<option value="2009">2009</option>
	<option value="2010">2010</option>
	<option value="2011">2011</option>
	<option value="2012">2012</option>
	<option value="2013">2013</option>
	<option value="2014">2014</option>
	<option value="2015">2015</option>
	<option value="2016">2016</option>
	<option value="2017">2017</option>
	<option value="2018">2018</option>
	<option value="2019">2019</option>
	<option value="2020">2020</option>
	<option value="2021">2021</option>
	<option value="2022">2022</option>
	<option value="2023">2023</option>
	<option value="2024">2024</option>
	<option value="2025">2025</option>
	<option value="2026">2026</option>
	<option value="2027">2027</option>
	<option value="2028">2028</option>
	<option value="2029">2029</option>
	<option value="2030">2030</option>
	<option value="2031">2031</option>
	<option value="2032">2032</option>
	<option value="2033">2033</option>
	<option value="2034">2034</option>
	<option value="2035">2035</option>
	<option value="2036">2036</option>
	<option value="2037">2037</option>
	<option value="2038">2038</option>
	<option value="2039">2039</option>
	<option value="2040">2040</option>

</select> </br>
</br>
</br>

<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('misBedStatsReport','workServiceReport?method=printMisBedReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>

</div>






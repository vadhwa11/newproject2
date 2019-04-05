<%--
 * Copyright 2009 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * medAdmissionDiagReport.jsp  
 * Purpose of the JSP -  Medical Admission Diagnosis Report.
 * @author  Vishal
 * Create Date: 03rd Dec,2009 
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
	</script> <br />
<h2 align="left" class="style1">Medical Admission Diagnosis Report
</h2>
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
			 	Date toDate  = null;
				Date fromDate=null;
			 	if (map.get("toDate") != null) {
			 		toDate = (Date) map.get("toDate");
			 		session.setAttribute("toDate", toDate);
			 	}
			 	if (map.get("fromDate") != null) {
			 		fromDate = (Date) map.get("fromDate");
			 		session.setAttribute("fromDate", fromDate);
			 	}
			 	
			 %>

<form name="med_admission_diag" method="post" action=""><label
	class="bodytextB">From Date:</label> <input type="text" id="fromDateId"
	name="<%=FROM_DATE %>" value="<%=currenDate %>" class="textbox_date"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate%>',document.med_admission_diag.<%=FROM_DATE%>,event)" />

<label class="bodytextB">To Date:</label> <input type="text"
	id="ToDateId" name="<%=TO_DATE %>" value="<%=currenDate %>"
	class="textbox_date" readonly="readonly" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate%>',document.med_admission_diag.<%=TO_DATE%>,event)" />

<br />



<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('med_admission_diag','workServiceReport?method=printMedAdmissionDiagReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>

</div>






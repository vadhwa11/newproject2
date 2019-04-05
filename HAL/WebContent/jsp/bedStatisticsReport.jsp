<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * edReport.jsp  
 * Purpose of the JSP -  This is for Bed Statistics Summary Report.
 * @author  Dipali
 * Create Date: 26th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
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
<h2 align="left" class="style1">Day-Wise Beds Statistics</h2>
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
					
			 	List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
			 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			 	List<Patient> patientList = new ArrayList<Patient>();
			 	List<Visit> visitList = new ArrayList<Visit>();
			 	List<Object> list = null;
			 	Date toDate  = null;
				Date fromDate=null;
				String category=null;
			 	
				
			 	if (map.get("rankCategoryList") != null) {
			 		rankCategoryList = (List<MasRankCategory>) map.get("rankCategoryList");
			 	}
				if (map.get("departmentList") != null) {
					departmentList = (List<MasDepartment>) map.get("departmentList");
			 	}
			 	if (map.get("patientList") != null) {
			 		patientList = (List<Patient>) map.get("patientList");
			 	}
			 	if (map.get("showList") != null) {
			 		visitList = (List<Visit>) map.get("showList");
			 		session.setAttribute("visitList", visitList);
			 	}
			 	if (map.get("showList") != null) {
			 		list = (List<Object>) map.get("showList");
			 		session.setAttribute("list", list);
			 	}
			 	if (map.get("toDate") != null) {
			 		toDate = (Date) map.get("toDate");
			 		session.setAttribute("toDate", toDate);
			 	}
			 	if (map.get("fromDate") != null) {
			 		fromDate = (Date) map.get("fromDate");
			 		session.setAttribute("fromDate", fromDate);
			 	}
			 	if (map.get("category") != null) {
			 		category = (String) map.get("category");
			 		session.setAttribute("category", category);
			 	}
			 	
			 	
			 %>

<form name="bedStatisticsReport" method="post" action=""><label>
From Date:</label> <input type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currenDate %>" class="textbox_date" readonly="readonly"
	MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currenDate %>',document.bedStatisticsReport.<%=FROM_DATE%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <label> To Date:</label> <input
	type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=currenDate %>"
	class="textbox_date" readonly="readonly" MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currenDate %>',document.bedStatisticsReport.<%=TO_DATE%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <br />
<label>Bed-Wise</label> <input type="radio" name="<%=BED_WISE %>"
	class="bodytextB_blue" value="y">Summary <input type="radio"
	name="<%=BED_WISE %>" class="bodytextB_blue" value="n">Detail <br />
<label>Ward :</label> <select id="departmentId"
	name="<%=DEPARTMENT_ID %>">

	<%
							for (MasDepartment masDepartment : departmentList) {
						%>
	<option value="<%=masDepartment.getDepartmentName() %>"><%=masDepartment.getDepartmentName()%></option>
	<%
						}
					%>
</select> <br />
<label>Category :</label> <select id="categoryId"
	name="<%=CATEGORY_ID %>">

	<%
							for (MasRankCategory masRankCategory : rankCategoryList) {
						%>
	<option value="<%=masRankCategory.getRankCategoryName() %>"><%=masRankCategory.getRankCategoryName()%></option>
	<%
						}
					%>
</select> <br />
<br />

<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('bedStatisticsReport','mis?method=searchBedStatisticsReport');" />



</form>


</div>






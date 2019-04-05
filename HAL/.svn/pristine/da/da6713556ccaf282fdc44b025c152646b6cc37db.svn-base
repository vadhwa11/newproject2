<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 *nursingCareReport.jsp  
 * Purpose of the JSP -  This is for Nursing Care Report.
 * @author  Dipali
 * Create Date: 29 March,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>

<script type="text/javascript"
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
	</script>

<div class="titleBg">
<h2>DMA DUTY Report</h2>
</div>
<%
			 	String userName = "";
	 			int deptId =0;
	 			int careType =0;
	 			
	 			String hinNo ="";
	 			String serviceNo ="";
	 			int nursingCareType =0;
	 			
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTimeWithoutSc");

			 	
			 %>

<form name="search" target="_blank" method="post" action="">
<div class="clear"></div>
<div class="Block">

<label class="medium">Date</label>

<label class="medium"> From <span>*</span> </label> 

<input type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" class="calDate" readonly="readonly"
	MAXLENGTH="30" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currentDate %>',document.search.<%=FROM_DATE%>,event)" />

<label class="medium">To </label> 
<input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.search.<%=TO_DATE%>,event)" />
	
	<div class="clear"></div>

<label class="medium">Time</label>

<label class="medium"> From <span>*</span></label> 
 <input	type="text" name="fromTime" id="fromTime" validate="From Time,string,yes" value="<%=time %>" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	 MAXLENGTH="5"  />
 

<label class="medium"> To <span>*</span></label> 
<input	type="text" name="toTime" id="toTime" validate="To Time,string,yes" value="<%=time %>" MAXLENGTH="5" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	 />


</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','/hms/hms/ipd?method=printDMADutyReport')" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>



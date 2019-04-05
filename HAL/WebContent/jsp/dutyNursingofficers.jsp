
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * foodTastingReport.jsp  
 * Purpose of the JSP -  This is for Duty Nursing Officers Report.
 * @author  Dipali
 * Create Date: 19, jUNE,2008 
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
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
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
<div class=" titleBg">
<h2>Duty Nursing Officers Report</h2>
</div>

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
					
			 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			 	List<Object> list = null;
			 	Date date1  = null;
			 	int deptId = 0;
			 	
				if (map.get("departmentList") != null) {
					departmentList = (List<MasDepartment>) map.get("departmentList");
			 	}
			 	if (map.get("date") != null) {
			 		date1 = (Date) map.get("date");
			 		session.setAttribute("date", date1);
			 	}
			 	
			 	if(map.get("deptId") != null){
			 		deptId = (Integer) map.get("deptId");
			 	}
			 	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");  
			 %>
<div class="Clear"></div>
<form name="dutyNursing" target="_blank" method="post" action="">
<div class="Block">
<label>Date</label>
<input type="text"	id="dateId" name="<%=DATE %>" value="<%=currenDate %>" class="calDate"	readonly="readonly" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onClick="setdate('',document.dutyNursing.<%=DATE%>,event)" />
<label> Ward <span>*</span></label>
<select id="departmentId" name="<%=DEPARTMENT_ID %>"	onchange="getDepartmentName();">
	<option value="0">Select</option>
	<%
							for (MasDepartment masDepartment : departmentList) {
				              if(deptId == masDepartment.getId()) { 
								%>
	<option value="<%=masDepartment.getId() %>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{ %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<%
					}}
					%>
</select>
</div>
<div class="Clear"></div>
<div class="division"></div>
<input name="deptName" value="" type="hidden" id="deptName" />
<input	type="button" name="OK" value="OK" class="button"	onClick="submitForm('dutyNursing','ipd?method=showDutyNursingReport');" />
<div class="Clear"></div>
<div class="division"></div>
<script type="text/javascript">
			function getDepartmentName(){
			
			var obj = document.getElementById("departmentId");
			var val = obj.value;
			for(i=0;i<obj.length;i++)
			{
				if(obj.options[i].value == val)
				{
					deptName = obj.options[i].text
					break;
				}
			}
				document.getElementById("deptName").value =deptName
			}
			function getDepartmentNameForRemarks(){
			
			var obj = document.getElementById("departmentIdTemp");
			var val = obj.value;
			for(i=0;i<obj.length;i++)
			{
				if(obj.options[i].value == val)
				{
					deptName = obj.options[i].text
					break;
				}
			}
				document.getElementById("deptNameForRemarks").value =deptName
			}
			
			</script></form>
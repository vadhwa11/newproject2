<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * appointmentInvestigationCancellationList.jsp  
 * Purpose of the JSP -  This is for Investigation Cancellation List.
 * @author  Vishal
 * Create Date: 05th August,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.1  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.AppEquipmentMaster"%>
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
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> utilMap = new HashMap<String, Object>();
		 	
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currentDate = (String) utilMap.get("currentDate");
		 	String time = (String) utilMap.get("currentTime");
		 	
		 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		 	
		 	if(request.getAttribute("map") != null){
				map = (Map<String, Object>)request.getAttribute("map");
			}
			if(map.get("departmentList") != null){
				departmentList = (List<MasDepartment>) map.get("departmentList");
			}
			if(map.get("equipmentList") != null){
				equipmentList = (List<AppEquipmentMaster>) map.get("equipmentList");
			}
			
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			String departmentTypeCodeForWard = properties.getProperty("departmentTypeCodeForWard");

	%>

<div class="Clear"></div>
<h6>OPD Investigation Cancellation List</h6>
<div class="Clear"></div>
<div class="blockFrame">
<form name="opdInvestigationCancellationList" target="_blank"	method="post" action="">
<div id="divId">
<!--  	<label class="bodytextB"> According To:</label></BR>
			<input type="radio" name="<%=REPORT_TYPE%>" value="appointment" checked="checked">
			<font class="wardspan">Investigation Date</font>
			<input type="radio" name= "<%=REPORT_TYPE%>" value="cancellation">
			<font class="wardspan">Cancellation Date</font>
			<br/>
		<br/>
		-->
<label><span>*</span> From Date</label>
<input	type="text" id="fromDateId" name="<%=VALID_FROM_DATE %>"	value="<%=currentDate %>" class="calDate" readonly="readonly"	MAXLENGTH="30" validate="From Date,date,yes" />
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('',document.opdInvestigationCancellationList.<%=VALID_FROM_DATE%>,event)" />

<label><span>*</span> To Date</label>
<input type="text"	id="ToDateId" name="<%=VALID_TO_DATE %>" value="<%=currentDate %>"	class="calDate" readonly="readonly" MAXLENGTH="30"	validate="TO Date,date,yes" /> <img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('',document.opdInvestigationCancellationList.<%=VALID_TO_DATE%>,event)" />
</div>
<div class="Clear"></div>
<label>Equipment</label>
<select id="equipmentList"	name="<%=EQUIPMENT_ID %>">
	<option value=0>Select</option>
	<%
							for (AppEquipmentMaster appEquipmentMaster : equipmentList) {
						%>
	<option value="<%=appEquipmentMaster.getId() %>"><%=appEquipmentMaster.getEquipmentName()%></option>
	<%
						}
					%>
</select>
<label>Department</label>
<select id="departmentd" name="<%=DEPARTMENT_ID %>">
	<option value=0>Select</option>
	<%
							for (MasDepartment masDepartment : departmentList) {
								
						%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<%			
							}
					%>
</select>
<div class="Clear"></div>


</form></div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"	onClick="submitForm('opdInvestigationCancellationList','appointment?method=generateOPDInvestigationCancellationReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"	accesskey="r" />
</div>

<script type="text/javascript">
	function checkAsOn(){

	  if(document.getElementById('hospitalStaffId').value=='y'){
		document.getElementById('divId').style.display = 'none';
		}else{
		alert("-")
		submitForm('opdInvestigationList','/hms/hms/appointment?method=showOPDInvestigationCancellationReportJsp');
		}
		
	}
	

    </script>

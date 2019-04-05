<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * investigationListReport.jsp  
 * Purpose of the JSP -  This is for Investigation List.
 * @author  Vishal
 * Create Date: 03th August,2008 
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
<div class="Clear"></div>
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
	</script> <script type="text/javascript">
	equipmentArray = new Array();

	function populateEquipment(val){
		obj = document.getElementById('equipmentList');
		obj.length = 1;
		for(i=0;i<equipmentArray.length;i++){
			if(equipmentArray[i][0]==val){
				obj.length++;
				obj.options[obj.length-1].value=equipmentArray[i][1];
				obj.options[obj.length-1].text=equipmentArray[i][2];			
			}
		}
	}
	
	</script> <%
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> utilMap = new HashMap<String, Object>();
		 	
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currentDate = (String) utilMap.get("currentDate");
		 	String time = (String) utilMap.get("currentTime");
		 	
		 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		 	List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		 	
			List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
			 	int deptId = 0;
			 	if (session.getAttribute("deptId") != null) {
			 		deptId = (Integer) session.getAttribute("deptId");
			 	}

		 	if(request.getAttribute("map") != null){
				map = (Map<String, Object>)request.getAttribute("map");
			}
			if(map.get("departmentList") != null){
				departmentList = (List<MasDepartment>) map.get("departmentList");
			}
			if(map.get("wardList") != null){
				wardList = (List<MasDepartment>) map.get("wardList");
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
<h6>OPD Investigation List</h6>
<div class="Clear"></div>
<div class="blockFrame">
<form name="opdInvestigationList" target="_blank" method="post" action="">
<div id="divId">
<label><span>*</span> From Date</label>
<input	type="text" id="fromDateId" name="<%=VALID_FROM_DATE %>" value="<%=currentDate %>" class="calDate" readonly="readonly"	MAXLENGTH="30" validate="From Date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('',document.opdInvestigationList.<%=VALID_FROM_DATE%>,event)" />

<label><span>*</span> To Date</label>
<input type="text" id="ToDateId" name="<%=VALID_TO_DATE %>" value="<%=currentDate %>" class="calDate"	readonly="readonly" MAXLENGTH="30" validate="To Date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('',document.opdInvestigationList.<%=VALID_TO_DATE%>,event)" />
</div>

<div class="Clear"></div>

<label>Department</label>
<select id="departmentd"	name="<%=DEPARTMENT_ID %>" onchange="populateEquipment(this.value);">
	<option value="0">Select</option>
	<%
							for (MasDepartment masDepartment : departmentList) {
								
						%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<%			
							}
					%>
</select>
<label>Equipment</label>
<select id="equipmentList"	name="<%=EQUIPMENT_ID %>">
	<option value="0">Select</option>
	<%
							for (AppEquipmentMaster appEquipmentMaster : equipmentList) {
						%>
	<option value="<%=appEquipmentMaster.getId() %>"><%=appEquipmentMaster.getEquipmentName()%></option>
	<%
						}
					%>
</select>
<label>Ward</label>
<select id="wardId" name="<%=WARD_ID%>">
	<option value="0">Select</option>
	<%
							for (MasDepartment ward : wardList) {
						%>
	<option value="<%=ward.getId() %>"><%=ward.getDepartmentName()%></option>
	<%			
							
						}
					%>
</select>
<div class="Clear"></div>
<label>Consulted</label>
<input type="radio" class="radio"	name="<%=SELECTED_RADIO  %>" value="1" />
<label class="noWidth">Non Consulted</label>
<input type="radio" class="radio"	name="<%=SELECTED_RADIO  %>" value="2" />
<label class="noWidth">Both</label>
<input type="radio" class="radio" name="<%=SELECTED_RADIO  %>" value="3"	checked="checked" />
<div class="Clear"></div>

</form>
</div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"	onClick="submitForm('opdInvestigationList','appointment?method=generateOPDInvestigationReport');" />
<input type="reset" name="cancel" value="Cancel" class="button"	accesskey="r" />
</div>


<script type="text/javascript">
	function checkAsOn(){

	  if(document.getElementById('hospitalStaffId').value=='y'){
		document.getElementById('divId').style.display = 'none';
		}else{
		alert("-")
		submitForm('opdInvestigationList','/hms/hms/appointment?method=showOPDAppointmentListReportJsp');
		}
		
	}
	

    </script>
<script type="text/javascript">
<%

	int counter1 = 0;
	
	for (MasDepartment masDepartment : departmentList)
	{
	for (AppEquipmentMaster appEquipmentMaster : equipmentList) 
	{
	if(appEquipmentMaster.getDepartment() != null){
	if(masDepartment.getId().equals(appEquipmentMaster.getDepartment().getId() )){
%>
	equipmentArray[<%=counter1%>] = new Array();
	equipmentArray[<%=counter1%>][0]=<%=masDepartment.getId()%>;
	equipmentArray[<%=counter1%>][1] = <%=appEquipmentMaster.getId()%>;									
	equipmentArray[<%=counter1%>][2] = "<%=appEquipmentMaster.getEquipmentName()%>";
	<%
	counter1++;
	} } } }
	
%>
	
 </script>

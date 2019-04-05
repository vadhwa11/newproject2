<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * investigationAppointments.jsp  
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Priyanka
 * Create Date: 10th july,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdHoliday"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%@page import="java.sql.Time"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.AppEquipmentMaster"%>
<%@page import="jkt.hms.masters.business.AppInvestigationSetup"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="investigationAppointments" method="post" action=""><script
	type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		String time=String.valueOf(calendar.getTime());
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	
		
		function openPopUp(inc)
		{
			
			window.open('appointment?method=showExistingPatients&serviceNo='+document.getElementById("serviceNo"+inc).value+'&counter='+inc,'mywindow','location=1,status=1,scrollbars=1,top=210,left=30,width=960,height=300');
		}
		
		function blankAllFields(inc)
		{
				document.getElementById('serviceNo'+inc).value="";
				document.getElementById('servicePerson'+inc).value="";
				document.getElementById('hinNo'+inc).value="";
				document.getElementById('hinId'+inc).value="";
				document.getElementById('patientName'+inc).value="";
				document.getElementById('mobileNo'+inc).value="";
				document.getElementById('age'+inc).value="";
				document.getElementById('patientType'+inc).value="";
				document.getElementById('sex'+inc).value="M";
				document.getElementById('employeeId'+inc).value="";
				document.getElementById('ageUnit'+inc).value="0";
		}
		function disableFields(counter,inc)
		{
			var i=0;
			for(i=0;i<=counter;i++)
			{
				if(i==inc)
				{
					
					document.getElementById("hin_service"+i).disabled=false;
					if(document.getElementById("fromTimeSlot"+i)!=null)
					{
						document.getElementById("fromTimeSlot"+i).disabled=false;
					}
				}else{
					if(document.getElementById("serviceNo"+i)!=null)
					{
						document.getElementById("serviceNo"+i).value="";
						document.getElementById("serviceNo"+i).disabled=true;
					}
					if(document.getElementById("servicePerson"+i)!=null)
					{
						document.getElementById("servicePerson"+i).value="";
						document.getElementById("servicePerson"+i).disabled=true;
					}
					if(document.getElementById("hinNo"+i)!=null)
					{
						document.getElementById("hinNo"+i).value="";
						document.getElementById("hinNo"+i).disabled=true;
					}
					if(document.getElementById("hinId"+i)!=null)
					{
						document.getElementById("hinId"+i).value="";
						document.getElementById("hinId"+i).disabled=true;
					}
					if(document.getElementById("patientName"+i)!=null)
					{
						document.getElementById("patientName"+i).value="";
						document.getElementById("patientName"+i).disabled=true;
					}
					if(document.getElementById("mobileNo"+i)!=null)
					{
						document.getElementById("mobileNo"+i).value="";
						document.getElementById("mobileNo"+i).disabled=true;
					}
					if(document.getElementById("sex"+i)!=null)
					{
						document.getElementById("sex"+i).value="M";
						document.getElementById("sex"+i).disabled=true;
					}
					if(document.getElementById("age"+i)!=null)
					{
						document.getElementById("age"+i).value="";
						document.getElementById("age"+i).disabled=true;
					}
					if(document.getElementById("patientType"+i)!=null)
					{
						document.getElementById("patientType"+i).value="";
						document.getElementById("patientType"+i).disabled=true;
					}
					
					if(document.getElementById("employeeId"+i)!=null)
					{
						document.getElementById("employeeId"+i).value="";
						document.getElementById("employeeId"+i).disabled=true;
					}
					if(document.getElementById("fromTimeSlot"+i)!=null)
					{
						document.getElementById("fromTimeSlot"+i).disabled=true;
					}
					if(document.getElementById("toTimeSlot"+i)!=null)
					{
						document.getElementById("toTimeSlot"+i).disabled=true;
					}
					if(document.getElementById("hinNo"+i)!=null)
					{
						document.getElementById("hinNo"+i).disabled=true;
					}
					if(document.getElementById("ageUnit"+i)!=null)
					{
						document.getElementById("ageUnit"+i).disabled=true;
					}
					if(document.getElementById("hin_service"+i)!=null)
					{
						document.getElementById("hin_service"+i).disabled=true;
					}
					
				}
				
			}
			
		}
		
		function disableHinService(selectedValue,inc)
		{
			blankAllFields(inc);
			if(selectedValue=='hinNo')
			{
				document.getElementById('serviceNo'+inc).disabled=true;
				document.getElementById('servicePerson'+inc).disabled=true;
				document.getElementById('employeeId'+inc).disabled=false;
				document.getElementById('patientType'+inc).disabled=false;
				document.getElementById("hinNo"+inc).readOnly=false;
				document.getElementById("hinNo"+inc).disabled=false;
				
				
			}
			else if(selectedValue=='serviceNo')
			{
			
				document.getElementById('serviceNo'+inc).disabled=false;
				document.getElementById('servicePerson'+inc).disabled=false;
				document.getElementById('hinNo'+inc).disabled=false;
				document.getElementById('hinId'+inc).disabled=false;
				document.getElementById('patientName'+inc).disabled=false;
				document.getElementById('mobileNo'+inc).disabled=false;
				document.getElementById('age'+inc).disabled=false;
				document.getElementById('patientType'+inc).disabled=false;
				document.getElementById('sex'+inc).disabled=false;
				document.getElementById('employeeId'+inc).disabled=false;
				document.getElementById('ageUnit'+inc).disabled=true;
				
				document.getElementById('servicePerson'+inc).readOnly=true;
				document.getElementById('hinNo'+inc).readOnly=true;
				document.getElementById('hinId'+inc).readOnly=true;
				document.getElementById('patientName'+inc).readOnly=true;
				document.getElementById('mobileNo'+inc).readOnly=true;
				document.getElementById('age'+inc).readOnly=true;
				document.getElementById('sex'+inc).readOnly=true;
				document.getElementById('employeeId'+inc).readOnly=true;
				document.getElementById('ageUnit'+inc).readOnly=true;
				
			}
			else if(selectedValue=='none')
			{
				document.getElementById('hinNo'+inc).disabled=true;
				document.getElementById('hinId'+inc).disabled=true;
				document.getElementById('serviceNo'+inc).disabled=true;
				document.getElementById('servicePerson'+inc).disabled=true;
				if(document.getElementById("patientName"+inc)!=null)
				{
					document.getElementById("patientName"+inc).disabled=false;
					document.getElementById("patientName"+inc).readOnly=false;
				}
				if(document.getElementById("mobileNo"+inc)!=null)
				{
					document.getElementById("mobileNo"+inc).disabled=false;
					document.getElementById("mobileNo"+inc).readOnly=false;
				}
				if(document.getElementById("sex"+inc)!=null)
				{
					document.getElementById("sex"+inc).disabled=false;
					document.getElementById("sex"+inc).readOnly=false;
				}
				if(document.getElementById("age"+inc)!=null)
				{
					document.getElementById("age"+inc).disabled=false;
					document.getElementById("age"+inc).readOnly=false;
				}
				if(document.getElementById("patientType"+inc)!=null)
				{
					document.getElementById("patientType"+inc).disabled=false;
					document.getElementById("patientType"+inc).readOnly=false;
				}
				
				if(document.getElementById("ageUnit"+inc)!=null)
				{
					document.getElementById("ageUnit"+inc).disabled=false;
					document.getElementById("ageUnit"+inc).readOnly=false;
				}
				if(document.getElementById("employeeId"+inc)!=null)
				{
					document.getElementById("employeeId"+inc).disabled=false;
					document.getElementById("employeeId"+inc).readOnly=false;
				}
			}
			else
			{
				if(document.getElementById("serviceNo"+inc)!=null)
					{
						document.getElementById("serviceNo"+inc).disabled=true;
					}
					if(document.getElementById("servicePerson"+inc)!=null)
					{
						document.getElementById("servicePerson"+inc).disabled=true;
					}
					if(document.getElementById("hinNo"+inc)!=null)
					{
						document.getElementById("hinNo"+inc).disabled=true;
					}
					if(document.getElementById("hinId"+inc)!=null)
					{
						document.getElementById("hinId"+inc).disabled=true;
					}
					if(document.getElementById("patientName"+inc)!=null)
					{
						document.getElementById("patientName"+inc).disabled=true;
					}
					if(document.getElementById("mobileNo"+inc)!=null)
					{
						document.getElementById("mobileNo"+inc).disabled=true;
					}
					if(document.getElementById("sex"+inc)!=null)
					{
						document.getElementById("sex"+inc).disabled=true;
					}
					if(document.getElementById("age"+inc)!=null)
					{
						document.getElementById("age"+inc).disabled=true;
					}
					if(document.getElementById("patientType"+inc)!=null)
					{
						document.getElementById("patientType"+inc).disabled=true;
					}
					
					if(document.getElementById("employeeId"+inc)!=null)
					{
						document.getElementById("employeeId"+inc).disabled=true;
					}
					if(document.getElementById("fromTimeSlot"+inc)!=null)
					{
						document.getElementById("fromTimeSlot"+inc).disabled=true;
					}
					if(document.getElementById("toTimeSlot"+inc)!=null)
					{
						document.getElementById("toTimeSlot"+inc).disabled=true;
					}
					if(document.getElementById("hinNo"+inc)!=null)
					{
						document.getElementById("hinNo"+inc).disabled=true;
					}
					if(document.getElementById("ageUnit"+inc)!=null)
					{
						document.getElementById("ageUnit"+inc).disabled=true;
					}
					if(document.getElementById("hin_service"+inc)!=null)
					{
						document.getElementById("hin_service"+inc).disabled=false;
					}
				alert("select Hin No or service No or None");
			}
			
		}
		
		
		
		var holidayArray=new Array();
		
	equipmentArray = new Array();

	function populateEquipment(val){
		obj = document.getElementById('equipmentId');
		obj.length = 1;
		for(i=0;i<equipmentArray.length;i++){
			if(equipmentArray[i][0]==val){
				obj.length++;
				obj.options[obj.length-1].value=equipmentArray[i][1];
				obj.options[obj.length-1].text=equipmentArray[i][2];
				if(obj.options[obj.length-1].value != "0"){
					obj.options[obj.length-1].setAttribute('onclick','showAvailableDaysForAppointment()');
				}
			}
		}
	}
		
		
	</script>
<h6>OPD Investigation Appointment</h6>
<div class="Clear"></div>

<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	Box box=HMSUtil.getBox(request);
			 	
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String currentTime = (String) utilMap.get("currentTime");
			 	//Time sqlCurrentTime=(Time)utilMap.get("currentTime");
			 	//System.out.println("sqlCurrentTime=="+sqlCurrentTime);
			 	boolean showSubmitButton=false;
			 	
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 	List<AppInvestigationSetup> appInvestigationSetupList = new ArrayList<AppInvestigationSetup>();	
			 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			 	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			 	List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
			 	List<OpdHoliday>holidayList=new ArrayList<OpdHoliday>();
			 	List<Patient> registeredPatientList = new ArrayList<Patient>();
			 	String[][] calculatedSlotList=null;
			 	Integer[] noOfEquipmentsList=null;
			 	String breakToTime=null;
			 	boolean patientNameExist = false;
			 	boolean recordExists=false;
			 	String alertMessage=null;
			 	int counter=0;
			 	Calendar c_currentTime=Calendar.getInstance();
    			//c_currentTime.setTime(Time.valueOf(currentTime));
			 	
				if (map.get("departmentList") != null) {
					departmentList = (List<MasDepartment>) map.get("departmentList");
			 		
			 	}
				if (map.get("employeeList") != null) {
					employeeList = (List<MasEmployee>) map.get("employeeList");
			 		
			 	}
				if (map.get("holidayList") != null) {
					holidayList = (List<OpdHoliday>) map.get("holidayList");
			 		
			 	}
				if (map.get("equipmentList") != null) {
					equipmentList = (List<AppEquipmentMaster>) map.get("equipmentList");
			 		
			 	}
				if(map.get("slotList")!=null)
				{
					calculatedSlotList=(String [][])map.get("slotList");
				}
				if(map.get("noOfEquipmentsList")!=null)
				{
					noOfEquipmentsList=(Integer[])map.get("noOfEquipmentsList");
				}
				if(map.get("counter")!=null)
				{
					counter=(Integer)map.get("counter");
				}
				if (map.get("registeredPatientList") != null) {
					registeredPatientList = (List<Patient>) map.get("registeredPatientList");
			 		
			 	}
				if (map.get("appInvestigationSetupList") != null) {
					appInvestigationSetupList = (List<AppInvestigationSetup>) map.get("appInvestigationSetupList");
			 		
			 	}
				
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg"
	style="width: auto; float: none; color: red; font-weight: bold;">
<%=message.toUpperCase() %> <%
						 if(appInvestigationSetupList.size() > 0){ %> <label
	class="common" style="width: auto; float: none; color: red;">
&nbsp;&nbsp;&nbsp;&nbsp;PLEASE CHECK ON DAYS : </label> <% }else{ %> <label
	class="common" style="width: auto; float: none; color: red;">
NO APPOINTMENT SETUP FOR THIS EQUIPMENT </label> <% } %> <label class="large"
	style="color: red; width: 100%; float: none;"> <%if(appInvestigationSetupList.size() == 1){ %>
<%=appInvestigationSetupList.get(0).getDays().toUpperCase()%>. <% }else{
												for(int i=0;i < appInvestigationSetupList.size(); i++){%> <% if(i == appInvestigationSetupList.size()-1){ %>
<%=appInvestigationSetupList.get(i).getDays().toUpperCase()%>. <% }else{ %>
<%=appInvestigationSetupList.get(i).getDays().toUpperCase()%>, <% } %> <%} %>
<% } %> </label></div>
</div>

<%    
					   
				}
			 	else if(map.get("actualAvailableAppointments")!=null)
			 	{
			 		int actualAvailableAppointments= (Integer)map.get("actualAvailableAppointments");
			 	%> <marquee height=20 width=auto align=right direction=left
	behavior=scroll><font color=blue
	style="font-weight: bold; font-size: large"><%=actualAvailableAppointments + 1%>
Appointments are available.. !! </font></marquee> <%	}
			 	
			 	if(map.get("patientNameExist")!=null || map.get("recordExists")!=null)
			 	{
			 		if(map.get("recordExists")!=null)
			 		{
			 			recordExists=(Boolean)map.get("recordExists");
			 		}
			 		System.out.println("recordExists1="+recordExists);
			 		patientNameExist=(Boolean)map.get("patientNameExist");
			 		if(patientNameExist==true || recordExists==true)
			 		{
			 		%> <input type="hidden" id="returnDeptId" name="returnDeptId"
	value="<%=map.get("departmentId")%>" /> <input type="hidden"
	id="returnEquipId" name="returnEquipId" value="<%=map.get("equipId")%>" />
<input type="hidden" id="returnPatientName" name="returnPatientName"
	value="<%=map.get("patientName") %>" /> <input type="hidden"
	id="returnSex" name="returnSex" value="<%=map.get("sex") %>" /> <input
	type="hidden" id="returnAge" name="returnAge"
	value="<%=map.get("age") %>" /> <%if(map.get("ageUnit")!=null){%> <input
	type="hidden" id="returnAgeUnit" name="returnAgeUnit"
	value="<%=map.get("ageUnit") %>" /> <%}else{ %> <input type="hidden"
	id="returnAgeUnit" name="returnAgeUnit" value="" /> <%} %> <input
	type="hidden" id="returnAppointmentDate" name="returnAppointmentDate"
	value="<%=map.get("appointmentDate") %>" /> <input type="hidden"
	id="returnStartTime" name="returnStartTime"
	value="<%=map.get("fromTimeSlot") %>" /> <input type="hidden"
	id="returnEndTime" name="returnEndTime"
	value="<%=map.get("toTimeSlot") %>" /> <%if(map.get("doctorId")!=null){%>
<input type="hidden" id="returnDoctorId" name="returnDoctorId"
	value="<%=map.get("doctorId") %>" /> <%}else{ %> <input type="hidden"
	id="returnDoctorId" name="returnDoctorId" value="" /> <%} %> <%if(map.get("doctorId")!=null){%>
<input type="hidden" id="returnDoctorId" name="returnDoctorId"
	value="<%=map.get("doctorId") %>" /> <%}else{ %> <input type="hidden"
	id="returnDoctorId" name="returnDoctorId" value="" /> <%} %> <%if(map.get("mobileNo")!=null){%>
<input type="hidden" id="returnMobileNo" name="returnMobileNo"
	value="<%=map.get("mobileNo") %>" /> <%}else{ %> <input type="hidden"
	id="returnMobileNo" name="returnMobileNo" value="" /> <%} %> <%if(map.get("serviceNo")!=null){%>
<input type="hidden" id="returnServiceNo" name="returnServiceNo"
	value="<%=map.get("serviceNo") %>" /> <%}else{ %> <input type="hidden"
	id="returnServiceNo" name="returnServiceNo" value="" /> <%} %> <%if(map.get("servicePerson")!=null){%>
<input type="hidden" id="returnServicePerson" name="returnServicePerson"
	value="<%=map.get("servicePerson") %>" /> <%}else{ %> <input
	type="hidden" id="returnServicePerson" name="returnServicePerson"
	value="" /> <%} %> <%if(map.get("hinId")!=null){%> <input type="hidden"
	id="returnHinId" name="returnHinId" value="<%=map.get("hinId") %>" /> <%}else{ %>
<input type="hidden" id="returnHinId" name="returnHinId" value="" /> <%} %>

<%if(recordExists==true)
		 			{ 
		 				alertMessage="You have already taken appointment for Dept:" + map.get("existingDept")+" at "+ map.get("existingStartTime")+ " - "+ map.get("existingEndTime");
		 			}
		 			else
		 			{
		 				alertMessage="Duplicate Patient Name!!!";
		 			}
		 			%> <Script>
			 			
			 			if(confirm('<%=alertMessage%>'))
			 			{
			 				submitForm('investigationAppointments','appointment?method=submitDulicatePatientNameInvAppointment');
			 			}
			 		</script> <%		}
			 	}
			 %> <!--Block One Starts-->

<div class="header"><label>Department</label> <select
	id="departmentId" name="<%=DEPARTMENT_ID%>"
	validate="Department,number,no"
	onchange="populateEquipment(this.value);" />
	<option value="0">Select</option>
	<%	int deptId=(Integer)session.getAttribute("deptId");
				if(departmentList!= null){
				for (MasDepartment masDepartment : departmentList) {
					if(masDepartment.getId()==deptId){
			%>
	<option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%	
					}
			
				}
				}
			%>
</select> <label>Equipment</label> <select id="equipmentId"
	name="<%=EQUIPMENT_ID%>" validate="Equipment,number,no" />
	<option value="0">Select</option>
	<%
				if(equipmentList!= null){
				for (AppEquipmentMaster appEquipmentMaster : equipmentList) {
			%>
	<option value="<%=appEquipmentMaster.getId()%>"><%=appEquipmentMaster.getEquipmentName()%></option>
	<%}
				}
			%>
</select> <label>Investigation Date</label> <input type="text"
	id="appointmentdate" name="<%=APPOINTMENT_DATE %>" value=""
	MAXLENGTH="30" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('<%=currenDate %>',document.investigationAppointments.<%=APPOINTMENT_DATE%>,event);" />


</div>
<div class="Clear"></div>
<div id="appointmentDaysList">
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<label class="common">Department:</label> <input type="hidden"
	id="departmentId" name="<%=WARD_ID%>"
	value="<%=box.getInt(DEPARTMENT_ID)%>" /> <%
    if(departmentList!=null)
    {
    	 Iterator ite=departmentList.iterator();
    	 while ( ite.hasNext() ) {
     		MasDepartment masDepartment=(MasDepartment)ite.next();
     		if(masDepartment.getId()==box.getInt(DEPARTMENT_ID))
     		{
     			
     		
     %> <label class="value"> <%=masDepartment.getDepartmentName()%></label>

<%		}
     		
    	 }
    }else{%> <label class="value"> &nbsp;</label> <% 	}
    
    %> <label class="common">Appointment Date:</label> <input
	type="hidden" id="apmtDate" name="<%=APMT_DATE%>"
	value="<%=box.getString(APPOINTMENT_DATE)%>" /> <%String tempDate= box.getString(APPOINTMENT_DATE); %>
<label class="value"><%= tempDate %></label> <label class="noWidth">Equipment:</label>
<input type="hidden" id="equipmentId" name="<%=EQUIP_ID%>"
	value="<%=box.getInt(EQUIPMENT_ID)%>" /> <%
    if(equipmentList!=null)
    {
    	 Iterator ite=equipmentList.iterator();
    	 while ( ite.hasNext() ) {
     		AppEquipmentMaster appEquipmentMaster=(AppEquipmentMaster)ite.next();
     		if(appEquipmentMaster.getId()==box.getInt(EQUIPMENT_ID))
     		{
     			
     		
     %> <label class="value"> <%=appEquipmentMaster.getEquipmentName()%></label>

<%		}
     		
    	 }
    }else{%> <label class="value"> &nbsp;</label> <% 	}
    
    %> <script type="text/javascript">
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
	  
	  	populateEquipment(<%=deptId%>);

 </script> <!--Block one Ends-->
<div class="division"></div>

<%		
				int i=0;
				if(holidayList!=null){
					if(holidayList.size()>0){
					
							
							Iterator ite = holidayList.iterator();
							while ( ite.hasNext() ) {
						         OpdHoliday opdHoliday=(OpdHoliday)  ite.next();
						         
		%> <script>
	         		 			
	         					holidayArray[<%=i%>]= new Array();
								holidayArray[<%=i%>][0] = "<%=opdHoliday.getHolidayName()%>";
								holidayArray[<%=i%>][1] = "<%=HMSUtil.changeDateToddMMyyyy(opdHoliday.getHolidayDate())%>";
								
								</script> <%
						         i++;
						    }
						 }
				}
		%> <!--Block Three Starts-->
<div class="colsHolder">


<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th></th>
		<th scope="col">Time Slot</th>
		<th scope="col">Slots <br />	Available</th>
		<th scope="col">Appointment <br />		Criteria</th>
		<th scope="col">Service<br />		No.</th>
		<th scope="col">Service Person<br />		Name</th>
		<th scope="col">Hin No.</th>
		<th scope="col">Patient	Name</th>
		<th scope="col">Mobile	No.</th>
		<th scope="col">Sex</th>
		<th scope="col" colspan="2">Age</th>
		<th scope="col">Doctor's <br />		Name</th>
	</tr>

	<%
     	int inc = 0;  
    				Calendar c_calculatedTime=Calendar.getInstance();
    				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    		        String currentTimeinformat=sdf.format(c_currentTime.getTime());
    		        
     	for(inc=0;inc<counter;inc++){ 
    			if(calculatedSlotList[inc][0]!=null || calculatedSlotList[inc][1]!=null)
    			{
    				showSubmitButton=true;
    				c_calculatedTime.setTime(Time.valueOf(calculatedSlotList[inc][0]));
    				String calculatedTimeFormat=sdf.format(c_calculatedTime.getTime());
    				
    				Date apmtDate=HMSUtil.convertStringTypeDateToDateType(box.getString(APPOINTMENT_DATE));

    			%>
	<tr>
		<%	if(noOfEquipmentsList[inc] != null && noOfEquipmentsList[inc] > 0 )
    				{
    				   if (apmtDate.compareTo(HMSUtil.convertStringTypeDateToDateType(currenDate))==0 && c_calculatedTime.getTime().before(Time.valueOf(currentTimeinformat)))
    				   {
    			%>
		<!--Radio button 1-->
		<td><input type="radio" id="parent" name="parent" value=""
			onclick="disableFields(<%=counter%>,<%=inc%>);" disabled="disabled" /></td>

		<%		}else {		%>

		<!--Radio button 2-->
		<td><input type="radio" id="parent" name="parent" value=""
			onclick="disableFields(<%=counter%>,<%=inc%>);" /></td>
		<%		
    					}
    				}
					else{					
    			%>
		<td><input type="radio" id="parent" name="parent" value=""
			onclick="disableFields(<%=counter%>,<%=inc%>);" disabled="disabled" /></td>
		<% }
				%>

		<%StringTokenizer st1=new StringTokenizer(calculatedSlotList[inc][0],":"); %>
		<%StringTokenizer st2=new StringTokenizer(calculatedSlotList[inc][1],":"); %>

		<!--Time Slot-->
		<td><label><%=st1.nextToken()%>:<%=st1.nextToken()%>&nbsp;</label><label>
		- <%=st2.nextToken()%>:<%=st2.nextToken()%></label> <input type="hidden"
			id="fromTimeSlot<%=inc %>" name="<%=FROMTIMESLOT%>"
			value="<%=calculatedSlotList[inc][0]%>" /> <input type="hidden"
			id="toTimeSlot<%=inc %>" name="<%=TOTIMESLOT%>"
			value="<%=calculatedSlotList[inc][1]%>" /></td>
		<%if(noOfEquipmentsList[inc] != null && noOfEquipmentsList[inc] > 0){ %>
		<!--Slots Available 1-->
		<td><%=noOfEquipmentsList[inc]%></td>
		<%}else{%>
		<!--Slots Available 2-->
		<td>NIL</td>
		<%}%>
		<!--App criteria-->
		<td><select id="hin_service<%=inc%>" name="<%=SELECTED_RADIO%>"
			disabled="disabled"
			onchange="disableHinService(this.value,<%=inc%>);" />
			<option value="0">Select</option>
			<option value="serviceNo">Service No.</option>
			<option value="hinNo">Hin No.</option>
			<option value="none">None</option>
		</select></td>
		<input type="hidden" id="hinId<%=inc%>" name="<%=HIN_ID %>"
			disabled="disabled" />
		<!--service No.-->
		<td><input type="text" size=8 name="<%=SERVICE_NO%>"
			id="serviceNo<%=inc %>" MAXLENGTH="8" disabled="disabled"
			onblur="if(this.value!='')openPopUp(<%=inc %>);" /></td>
		<!--Service Person  Name-->
		<td><input type="text" size=16 id="servicePerson<%=inc %>"
			name="servicePerson" disabled="disabled" value="" MAXLENGTH="30"
			validate="Service Person Name,fullName,no" /></td>
		<!--Hin No.-->
		<td><input type="text" size=10 id="hinNo<%=inc %>"
			name="<%=HIN_NO%>" disabled="disabled"
			onblur="if(this.value!='')submitProtoAjaxWithDivName('investigationAppointments','appointment?method=showListBasedonHinNo&inc=<%=inc%>&hinNo='+this.value,'testDiv<%=inc %>');"></td>

		<td id="testDiv<%=inc %>"><!--Patient Name-->
		<input	type="text" size=16 id="patientName<%=inc %>"	name="<%=PATIENT_NAME%>" disabled="disabled" MAXLENGTH="30"		validate="Patient Name,fullName,no" />
		</td>
		<!--Mobile No.-->
		<td>
		<input	type="text" size=10 id="mobileNo<%=inc %>" name="<%=MOBILE_NO%>" disabled="disabled" MAXLENGTH="10" validate="Mobile No.,int,no" />
		</td>
		<!--Sex-->
		<td>
		<select id="sex<%=inc%>" name="<%=SEX%>" disabled="disabled" />
			<option value="M">M</option>
			<option value="F">F</option>
		</select>
		</td>
		<!--Age 1-->
		<td>
		<input type="text" size=1 id="age<%=inc%>"	name="<%=AGE%>" MAXLENGTH="8" disabled="disabled" /></td>
		<input	type="hidden" size=1 id="patientType<%=inc%>"	name="<%=PATIENT_TYPE%>" MAXLENGTH="18" disabled="disabled" />
		<!--Age 2-->
		<td><select id="ageUnit<%=inc%>" name="<%=AGEUNIT%>" disabled="disabled" />
			<option value="0">Select</option>
			<option value="Years">Years</option>
			<option value="Months">Months</option>

		</select>
		</td>
		<!--Doctor's Name-->
		<td><select id="employeeId<%=inc%>" name="<%=EMPLOYEE_ID%>"
			disabled="disabled" />
			<option value="0">Select</option>
			<%
									if(employeeList!= null){
										for (MasEmployee masEmployee : employeeList) {
											String fullName = masEmployee.getFirstName();
											if(masEmployee.getMiddleName() != null){
												fullName = fullName + " " + masEmployee.getMiddleName();
											}
											if(masEmployee.getLastName() != null){
												fullName = fullName + " " + masEmployee.getLastName();
											}
								%>
			<option value="<%=masEmployee.getId()%>"><%=fullName%></option>
			<%	}
									}
									%>
		</select></td>
	</tr>

	<%			}
    			else
    			{
  %>
	<tr>
		<td style="border: none;">&nbsp;</td>
		<td><label>BREAK</label></td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>

	<%  			}
   			 }
   %>
</table>
</div>

</div>



<!--Bottom labels starts-->
<div class="bottom"><label>Changed By </label> <label
	class="value"><%=userName%></label> <label>Changed Date </label> <label
	class="value"><%=currenDate%></label> <label>Changed Time </label> <label
	class="value"><%=currentTime%></label>

<div class="Clear"></div>
<%if(showSubmitButton==true){ %> <input name="" type="button"
	class="button" value="Submit"
	onclick="if(validateAppointmentRadio())submitForm('investigationAppointments','appointment?method=submitInvestigationAppointment','validateAgeOnSubmit');" />
<input name="" type="reset" class="button" value="Reset"
	onclick="resetAppointmentSetup();" /> <%} %>
</div>
<!--Bottom labels ends--></form>

<script type="text/javascript">

function validateAppointmentRadio(){
			var msg="Select a Time Slot !!";
			 for(var i = 0; i < document.getElementsByName('parent').length; i++){
			  if(document.getElementsByName('parent')[i].checked == true )
              { msg="";
              	if(document.getElementsByName('selectedRadio')[i].value == "0" )
              	{	
              		msg += "Select Appointment Criteria";
              	}
              	else
              	{
              		if(document.getElementsByName('patientName')[i].value=="")
					{
						msg += "Patient Name can not be blank in row "+i+".\n";
					}
					if(document.getElementsByName('sex')[i].value=="")
					{
						msg += "Sex can not be blank in row "+i+".\n";
					}
					if(document.getElementsByName('age')[i].value=="")
					{
						msg += "Age can not be blank in row "+i+".\n";
					}
					
              		if(document.getElementsByName('selectedRadio')[i].value=="serviceNo")
					{
						if(document.getElementsByName('serviceNo')[i].value=="")
						{
							msg += "Service No. can not be blank in row "+i+".\n";
						}
					}
					if(document.getElementsByName('selectedRadio')[i].value=="hinNo" )
					{
						if(document.getElementsByName('hinNo')[i].value=="")
						{
							msg += "Hin No. can not be blank in row "+i+".\n";
						}
					}
					if(document.getElementsByName('selectedRadio')[i].value=="none" || document.getElementsByName('hinNo')[i].value=="")
					{
						if(document.getElementsByName('ageUnit')[i].value=="0")
						{
							msg += "Select Age Unit in row "+i+".\n";
						}
					}
					
					
				  }
				}		
  		}
  		 if(msg != ""){
			 	alert(msg);
			 	return false;
		}
		return true;
		
	}
	
	function resetAppointmentSetup(){
			 for(var i = 0; i < document.getElementsByName('parent').length; i++){
			  if(document.getElementsByName('parent')[i].checked == true )
              {
              	document.getElementsByName('selectedRadio')[i].disabled=true;
              	document.getElementsByName('serviceNo')[i].disabled=true;
              	document.getElementsByName('servicePerson')[i].disabled=true;
              	document.getElementsByName('patientName')[i].disabled=true;
				document.getElementsByName('sex')[i].disabled=true;
				document.getElementsByName('patientType')[i].disabled=true;
				document.getElementsByName('age')[i].disabled=true;
				document.getElementsByName('ageUnit')[i].disabled=true;
				document.getElementsByName('hinNo')[i].disabled=true;
				document.getElementsByName('employeeId')[i].disabled=true;
				document.getElementsByName('mobilNo')[i].disabled=true;
					
				  
			}		
  		}
  		return true;
		
	}
	
function validateAgeOnSubmit()
{
 for(var i = 0; i < document.getElementsByName('parent').length; i++)
 {
			  if(document.getElementsByName('parent')[i].checked == true )
              {
              	var submitAge=document.getElementsByName('age')[i].value;
              	
              	var subAge=submitAge.substring(0,2);
              	
              	if(!validateNumeric(subAge))
			  	{
			  		var subAge1 = submitAge.substring(0,1);
			  		if(!validateNumeric(subAge1)){
				  		errors ="Age should be a number .\n";
						alert(errors)
				  		document.getElementsByName('age')[i].value="";
						return false;
			  		}
			  	}
			  }	
			 
  		 }
	
	return true;
}
function showAvailableDaysForAppointment(){
	var equipment = document.getElementById('equipmentId').value;
	if(equipment != '0'){
		submitProtoAjaxWithDivName('investigationAppointments','appointment?method=showInvestigationAppointmentSelectedDeptEquipment','appointmentDaysList');
		return true;
	} else {
		return false;
	}
}
function checkEquipment(){
		var equipment = document.getElementById('equipmentId').value;
		if(equipment == "0"){
			alert('Please Select Equipment.');
			return false;
		}else{
			return true;
		}
}
</script></div>
<!--main content placeholder ends here-->
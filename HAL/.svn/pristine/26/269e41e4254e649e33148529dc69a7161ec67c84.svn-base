<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * patientAppointments.jsp  
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
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.OpdHoliday"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%@page import="java.sql.Time"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<!--main content placeholder starts here-->

<div id="contentHolder">
<form name="patientAppointments" method="post" action=""><script
	type="text/javascript" language="javascript"><!--
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
			var critriaType =  document.getElementById('hin_service'+inc).value;
			if(critriaType == 'serviceNo' ){
				window.open('appointment?method=showExistingPatientsForDoctors&serviceNo='+document.getElementById("serviceNo"+inc).value+'&counter='+inc,'mywindow','location=1,status=1,scrollbars=1,top=210,left=30,width=960,height=300');
			}
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
				document.getElementById('sex'+inc).value="M";
				document.getElementById('employeeId'+inc).value="";
				document.getElementById('ageUnit'+inc).value="0";
		}
		function disableFields(counter,inc)
		{
			var i=0;
			
			for(j=0;j<=counter;j++)
			{
				if(j!=inc)
				{
					var appCr=document.getElementById("hin_service"+j);
			      if(appCr && appCr.value!='0'){
			    	  if(!confirm("Do you want to change without saving ?")){
			    		  document.getElementById("parent"+j).checked=true;
			    		  document.getElementById("parent"+j).focus();
				    	  return;
				       }
				    }		
				}
			}
			for(i=0;i<=counter;i++)
			{
				if(i==inc)
				{
					
					document.getElementById("hin_service"+i).disabled=false;
					
					if(document.getElementById("fromTimeSlot"+i)!=null)
					{
						document.getElementById("fromTimeSlot"+i).disabled=false;
					}

					if(document.getElementById("toTimeSlot"+i)!=null)
					{
						document.getElementById("toTimeSlot"+i).disabled=false;
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
					if(document.getElementById("rank"+i)!=null)
					{
						document.getElementById("rank"+i).value="";
						document.getElementById("rank"+i).disabled=true;
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
					if(document.getElementById("employeeId"+i)!=null)
					{
						document.getElementById("employeeId"+i).value="";
						document.getElementById("employeeId"+i).disabled=true;
					}
					if(document.getElementById("relationId"+i)!=null)
					{
						document.getElementById("relationId"+i).value="0";
						document.getElementById("relationId"+i).disabled=true;
					}
					if(document.getElementById("fromTimeSlot"+i)!=null)
					{
						document.getElementById("fromTimeSlot"+i).disabled=true;
					}
					if(document.getElementById("toTimeSlot"+i)!=null)
					{
						document.getElementById("toTimeSlot"+i).disabled=true;
					}
					if(document.getElementById("hinId"+i)!=null)
					{
						document.getElementById("hinId"+i).disabled=true;
					}
					if(document.getElementById("ageUnit"+i)!=null)
					{
						document.getElementById("ageUnit"+i).disabled=true;
					}
					if(document.getElementById("hin_service"+i)!=null)
					{
						document.getElementById("hin_service"+i).disabled=true;
						document.getElementById("hin_service"+i).value='0';
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
				document.getElementById('rank'+inc).disabled=true;
				document.getElementById('employeeId'+inc).disabled=false;
				
				if(document.getElementById("hinNo"+inc)!=null)
				{
					document.getElementById("hinNo"+inc).disabled=false;
					document.getElementById("hinNo"+inc).readOnly=false;
				}
				
			}
			else if(selectedValue=='serviceNo')
			{
			
				document.getElementById('serviceNo'+inc).disabled=false;
				document.getElementById('servicePerson'+inc).disabled=false;
				document.getElementById('rank'+inc).disabled=false;
				document.getElementById('hinNo'+inc).disabled=false;
				document.getElementById('hinId'+inc).disabled=false;
				document.getElementById('patientName'+inc).disabled=false;
				document.getElementById('mobileNo'+inc).disabled=false;
				document.getElementById('age'+inc).disabled=false;
				document.getElementById('sex'+inc).disabled=false;
				document.getElementById('relationId'+inc).disabled=false;
				document.getElementById('employeeId'+inc).disabled=false;
				document.getElementById('ageUnit'+inc).disabled=true;
				
				document.getElementById('servicePerson'+inc).readOnly=true;
				document.getElementById('hinNo'+inc).readOnly=true;
				document.getElementById('hinId'+inc).readOnly=true;
				document.getElementById('patientName'+inc).readOnly=true;
				document.getElementById('mobileNo'+inc).readOnly=true;
				document.getElementById('age'+inc).readOnly=true;
				//document.getElementById('sex'+inc).readOnly=true;
				//document.getElementById('employeeId'+inc).readOnly=true;
				//document.getElementById('ageUnit'+inc).readOnly=true;
				
			}
			else if(selectedValue=='none')
			{
				document.getElementById('hinNo'+inc).disabled=true;
				document.getElementById('hinId'+inc).disabled=true;
				document.getElementById('serviceNo'+inc).disabled=false;
				document.getElementById('servicePerson'+inc).disabled=false;
				document.getElementById('rank'+inc).disabled=false;
				document.getElementById('servicePerson'+inc).readOnly=false;
				document.getElementById('relationId'+inc).disabled=false;
								
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
					//document.getElementById("sex"+inc).readOnly=false;
				}
				if(document.getElementById("age"+inc)!=null)
				{
					document.getElementById("age"+inc).disabled=false;
					document.getElementById("age"+inc).readOnly=false;
				}
				if(document.getElementById("ageUnit"+inc)!=null)
				{
					document.getElementById("ageUnit"+inc).disabled=false;
					//document.getElementById("ageUnit"+inc).readOnly=false;
				}
				if(document.getElementById("employeeId"+inc)!=null)
				{
					document.getElementById("employeeId"+inc).disabled=false;
					//document.getElementById("employeeId"+inc).readOnly=false;
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
					if(document.getElementById("rank"+inc)!=null)
					{
						document.getElementById("rank"+inc).disabled=true;
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
					if(document.getElementById("hinId"+inc)!=null)
					{
						document.getElementById("hinId"+inc).disabled=true;
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
		
		
		
		
	--></script>
<h6>OPD Patient Appointment</h6>
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
					 	
			 		
			 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			 	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			 	List<OpdHoliday>holidayList=new ArrayList<OpdHoliday>();
			 	List<Patient> registeredPatientList = new ArrayList<Patient>();
			 	List<AppSetup> appSetupList = new ArrayList<AppSetup>();
			 	List<MasRelation> relationList = new ArrayList<MasRelation>();
			 	List<Patient>listBasedonHinNo=new ArrayList<Patient>();
			 	String[][] calculatedSlotList=null;
			 	Integer[] noOfDoctorsList=null;
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
				if(map.get("listBasedonHinNo")!=null){
					listBasedonHinNo=(List<Patient>)map.get("listBasedonHinNo");
				}
				if (map.get("employeeList") != null) {
					employeeList = (List<MasEmployee>) map.get("employeeList");
			 		
			 	}
				if (map.get("holidayList") != null) {
					holidayList = (List<OpdHoliday>) map.get("holidayList");
			 		
			 	}
				if (map.get("appSetupList") != null) {
					appSetupList = (List<AppSetup>) map.get("appSetupList");
			 		
			 	}
				if (map.get("relationList") != null) {
					relationList = (List<MasRelation>) map.get("relationList");
			 	}
				if(map.get("slotList")!=null)
				{
					calculatedSlotList=(String [][])map.get("slotList");
				}
				if(map.get("noOfDoctorsList")!=null)
				{
					noOfDoctorsList=(Integer[])map.get("noOfDoctorsList");
				}
				if(map.get("counter")!=null)
				{
					counter=(Integer)map.get("counter");
				}
				if (map.get("registeredPatientList") != null) {
					registeredPatientList = (List<Patient>) map.get("registeredPatientList");
			 		
			 	}
				Properties properties = new Properties();
				URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
				try {
				 	properties.load(resourcePath.openStream());
				 	} catch (Exception e) {
				 	e.printStackTrace();
				 }
				 String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
				 
				 if(map.get("blockMessage") != null){
						String message = (String)map.get("blockMessage");
						%>

<label class="noWidth"><span><%=message.toUpperCase() %></span></label>
<%    
				 }
				 
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
<label class="noWidth"><span><%=message.toUpperCase() %> <% if(appSetupList.size() > 0){ %>
&nbsp;&nbsp;&nbsp;&nbsp;PLEASE CHECK ON DAYS : <% }else{ %> NO APPOINTMENT
SETUP FOR THIS DEPARTMENT <% } %> <%if(appSetupList.size() == 1){ %> <%=appSetupList.get(0).getDays().toUpperCase()%>.
<% }else{
								for(int i=0;i < appSetupList.size(); i++){%> <% if(i == appSetupList.size()-1){ %>
<%=appSetupList.get(i).getDays().toUpperCase()%>. <% }else{ %> <%=appSetupList.get(i).getDays().toUpperCase()%>,
<% } %> <%} %> <% } %>
</span></label>

<%    
					   
				}
			 	else if(map.get("actualAvailableAppointments")!=null)
			 	{
			 		int actualAvailableAppointments= (Integer)map.get("actualAvailableAppointments");
			 	%>

<div align="left"><FONT color="blue" size="+1"><MARQUEE
	bgcolor="#FFFFFF" direction="left" loop="20" width="100%"><STRONG><%=actualAvailableAppointments+1 %>
Appointments are available.. !!</STRONG></MARQUEE></FONT></div>


<!--<marquee height=20 width="auto" align="right" direction="right"
			 		  behavior="scroll"><font color=blue style="font-weight: bold;font-size: large">
			 		  </font></marquee>--> <%	}
			 		
			 	if(map.get("patientNameExist")!=null || map.get("recordExists")!=null)
			 	{
			 		if(map.get("recordExists")!=null)
			 		{
			 			recordExists=(Boolean)map.get("recordExists");
			 		}
			 		patientNameExist=(Boolean)map.get("patientNameExist");
			 		if(patientNameExist==true || recordExists==true)
			 		{
			 		%> <input type="hidden" id="returnDeptId" name="returnDeptId"
	value="<%=map.get("departmentId")%>" /> <input type="hidden"
	id="returnPatientName" name="returnPatientName"
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
			 				submitForm('patientAppointments','appointment?method=submitDulicatePatientNameAppointment');
			 			}
			 		</script> <%		}
			 	}%> <%		int i=0;
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
		%> <!--Block One Starts-->


<div class="header"><label>Department</label> <select
	id="departmentId" name="<%=DEPARTMENT_ID%>"
	validate="Department,number,no" onchange="checkForAppmtDate()" />
	<option value="0">Select</option>
	<%
				int deptId=(Integer)session.getAttribute("deptId");
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
</select> <label>Appointment Date</label> <input type="text" id="appointmentdate"
	name="<%=APPOINTMENT_DATE %>" value="" MAXLENGTH="30"
	readonly="readonly" class="calDate" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	onchange="isApptGrCurrentDate1();"
	onClick="setdate('<%=currenDate %>',document.patientAppointments.<%=APPOINTMENT_DATE%>,event);" />



</div>

<label>Selected Department:</label>
<input type="hidden"	id="departmentId" name="<%=WARD_ID%>"	value="<%=box.getInt(DEPARTMENT_ID)%>" /> <%
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
    }else{%> <label class="value"> -</label> <% 	}
    
    %> <label class="large2">Selected Appointment Date:</label>
    <input	type="hidden" id="apmtDate" name="<%=APMT_DATE%>"	value="<%=box.getString(APPOINTMENT_DATE)%>" />
    <%String tempDate= box.getString(APPOINTMENT_DATE); %>
<label class="value"><%= tempDate %></label>

<div id="appointmentDaysList">
<div class="Clear"></div>
<% if(appSetupList.size() > 0){ %> <label class="titleMsgs">APPOINTMENT AVAILABLE ON DAYS : </label> <% }else{ %> 
<label class="titleMsgs">NO APPOINTMENT SETUP FOR THIS DEPARTMENT </label> <% } %> 
<label class="large" style="color: red; width: 100%; float: none;"> 
<%if(appSetupList.size() == 1){ %>
<%=appSetupList.get(0).getDays().toUpperCase()%>. <% }else{
								for(i=0;i < appSetupList.size(); i++){%> <% if(i == appSetupList.size()-1){ %>
<%=appSetupList.get(i).getDays().toUpperCase()%>. <% }else{ %> <%=appSetupList.get(i).getDays().toUpperCase()%>,
<% } %> <%} %> <% } %> </label>
</div>
<!--Block one Ends-->
<div class="division"></div>


<!--Block Three Starts-->
<div class="colsHolder">


<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th></th>
		<th scope="col">Time Slot</th>
		<th scope="col">Slots <br />Available</th>
		<th scope="col">Appointment <br />Criteria</th>
		<th scope="col">Service<br />No.</th>
		<th scope="col">Rank</th>
		<th scope="col">Service Person<br />Name</th>
		<th scope="col">HIN No.</th>
		<th scope="col">Relation</th>
		<th scope="col">Patient	Name</th>
		<th scope="col">Mobile	No.</th>
		<th scope="col">Sex</th>
		<th scope="col" colspan="2">Age</th>
		<th scope="col">Doctor's<br />Name</th>
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
		<%	
    			if(noOfDoctorsList[inc] != null && noOfDoctorsList[inc] > 0 )
    				{
    				   if (apmtDate.compareTo(HMSUtil.convertStringTypeDateToDateType(currenDate))==0 && c_calculatedTime.getTime().before(Time.valueOf(currentTimeinformat)))
    				   {
    			%>
		<td><input type="radio" id="parent<%=inc %>" name="parent"
			value="" onclick="disableFields(<%=counter%>,<%=inc%>);"
			disabled="disabled" /></td>

		<%}else { %>
		<td><input type="radio" id="parent<%=inc %>" name="parent"
			value="" onclick="disableFields(<%=counter%>,<%=inc%>);" /></td>
		<%		
    					}
    				}else {
    			%>
		<td><input type="radio" id="parent<%=inc%>" name="parent"
			value="" onclick="disableFields(<%=counter%>,<%=inc%>);"
			disabled="disabled" /></td>
		<%		
    					}
    				%>
		<%StringTokenizer st1=new StringTokenizer(calculatedSlotList[inc][0],":"); %>
		<%StringTokenizer st2=new StringTokenizer(calculatedSlotList[inc][1],":"); %>

		<td><label><%=st1.nextToken()%>:<%=st1.nextToken()%>&nbsp;</label><label>
		- <%=st2.nextToken()%>:<%=st2.nextToken()%></label> <input type="hidden"
			id="fromTimeSlot<%=inc %>" name="<%=FROMTIMESLOT%>"
			value="<%=calculatedSlotList[inc][0]%>" /> <input type="hidden"
			id="toTimeSlot<%=inc %>" name="<%=TOTIMESLOT%>"
			value="<%=calculatedSlotList[inc][1]%>" /></td>
		<%if(noOfDoctorsList[inc] != null && noOfDoctorsList[inc] > 0){ %>
		<td><%=noOfDoctorsList[inc]%></td>
		<%}else{%>
		<td>NIL</td>
		<%}%>
		<td><select id="hin_service<%=inc%>" name="<%=SELECTED_RADIO%>"
			disabled="disabled"
			onchange="disableHinService(this.value,<%=inc%>);">
			<option value="0">Select</option>
			<option value="serviceNo">Service No.</option>
			<option value="hinNo">Hin No.</option>
			<option value="none">None</option>
		</select></td>

		<input type="hidden" id="hinId<%=inc%>" name="<%=HIN_ID %>"		disabled="disabled" />
		<td><input type="text" size=8 name="<%=SERVICE_NO%>"	id="serviceNo<%=inc %>" MAXLENGTH="20" disabled="disabled"	onblur="if(this.value!='')openPopUp(<%=inc %>);" /></td>
		<td><input type="text" size=16 id="rank<%=inc %>" name="rank"	disabled="disabled" value="" MAXLENGTH="30" validate="" /></td>
		<td><input type="text" size=16 id="servicePerson<%=inc %>"	name="servicePerson" disabled="disabled" value="" MAXLENGTH="30" validate="Service Person Name,fullName,no" /></td>
		<td><input type="text" size=10 id="hinNo<%=inc %>"	name="<%=HIN_NO%>" disabled="disabled"	onblur="if(this.value!='')submitProtoAjaxWithDivName('patientAppointments','appointment?method=showListBasedonHinNo&inc=<%=inc%>&hinNo='+this.value,'testDiv<%=inc %>');" /></td>

		<td id="testDiv<%=inc %>">
		<select	id="relationId<%=inc%>" name="<%=RELATION_ID%>" disabled="disabled">
			<option value="0">Select</option>
			<%for(MasRelation relation : relationList){ %>
			<option value="<%=relation.getId()%>"><%=relation.getRelationName()%></option>
			<%} %>
		</select>
		</td>
		<td><input type="text" size=16 id="patientName<%=inc %>" name="<%=PATIENT_NAME%>" disabled="disabled" MAXLENGTH="30" validate="Patient Name,fullName,no" /></td>
		<td><input type="text" size=10	id="mobileNo<%=inc %>" name="<%=MOBILE_NO%>" disabled="disabled"	MAXLENGTH="10" validate="Mobile No.,int,no" /></td>
		<td><select	id="sex<%=inc%>" name="<%=SEX%>" disabled="disabled">
			<option value="M">M</option>
			<option value="F">F</option>
		</select>
		</td>
		<td><input type="text" size=1 id="age<%=inc%>" name="<%=AGE%>"	MAXLENGTH="2" disabled="disabled" /></td>
		<td><select id="ageUnit<%=inc%>" name="<%=AGEUNIT%>" disabled="disabled">
			<option value="0">Select</option>
			<option value="Years">Years</option>
			<option value="Months">Months</option>
		</select>
		</td>

		<td><select id="employeeId<%=inc%>" name="<%=EMPLOYEE_ID%>"	disabled="disabled">
			<option value="0">Select</option>
			<%
									if(employeeList!= null){
										for (MasEmployee masEmployee : employeeList) {
											if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
												String fullName = masEmployee.getFirstName();
												if(masEmployee.getMiddleName() != null){
													fullName = fullName + " " + masEmployee.getMiddleName();
												}
												if(masEmployee.getLastName() != null){
													fullName = fullName + " " + masEmployee.getLastName();
												}
								%>
			<option value="<%=masEmployee.getId()%>"><%=fullName%></option>
			<%		}
										}
									}
									%>
		</select>
		</td>
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
		<td colspan="5">&nbsp;</td>
	</tr>

	<%  			}
   			 }
   %>
</table>
</div>

</div>



<!--Bottom labels starts-->
<div class="bottom">
<div class="Clear"></div>
<%if(showSubmitButton==true){ %> <input name="" type="button"
	class="button" value="Submit"
	onclick="if(validateAppointmentRadio())submitForm('patientAppointments','appointment?method=submitPatientAppointment','validateAgeOnSubmit');" />
<input name="" type="reset" class="button" value="Reset"
	onclick="resetAppointmentSetup();" /> <%} %>


<div class="Clear"></div>
<label>Changed By </label> <label class="value"><%=userName %></label> <label>Changed
Date </label> <label class="value"><%=currenDate %></label> <label>Changed
Time </label> <label class="value"><%=currentTime%></label> <!--Bottom labels ends-->
</form>
</div>
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
function checkForAppmtDate()
{
	var dept=document.getElementById('departmentId').value;
	var appointmentDate=document.getElementById('appointmentdate').value;
	//if(dept!=0 && appointmentDate!="")
	//{
	//	submitForm('patientAppointments','appointment?method=showAppointmentPatientDepartmentWise','isApptGrCurrentDate1','checkForHoliday');
	//	return true;
	//}
	//else
	//{
	//	return false;
	//}
	if(dept != 0){
		submitProtoAjaxWithDivName('patientAppointments','appointment?method=showPatientAppointmentSelectedDepartmentJsp','appointmentDaysList');
		return true;
	} else {
		return false;
	}
}
</script>

</div>
<!--main content placeholder ends here-->
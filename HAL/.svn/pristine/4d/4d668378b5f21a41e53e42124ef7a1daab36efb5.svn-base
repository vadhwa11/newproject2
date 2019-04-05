<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * appInvestigation.jsp  
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
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%@page import="jkt.hms.masters.business.AppEquipmentMaster"%>
<%@page import="jkt.hms.masters.business.AppInvestigationSetup"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<!--main content placeholder starts here-->


<div id="contentHolder">
<form name="appInvestigation" method="post" action=""><script
	type="text/javascript" language="javascript">
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
	
	
	function validateMandatoryFields()
	{
		var inc=0;
		for(inc=0;inc<7;inc++)
		{
			if(document.getElementById("fromTime"+inc).value!="" && document.getElementById("fromTime"+inc).value!=null)
			{
				if(document.getElementById("toTime"+inc).value=="" || document.getElementById("slotDuration"+inc).value=="" )
				{
					alert("Please fill To Time, Slot Duration");
					return false; 
				}
			}
			
			if(document.getElementById("toTime"+inc).value!="" && document.getElementById("toTime"+inc).value!=null )
			{
				if(document.getElementById("fromTime"+inc).value=="" || document.getElementById("slotDuration"+inc).value=="" )
				{
					alert("Please fill From Time, Slot Duration");
					return false; 
				}
			}
			
			if(document.getElementById("slotDuration"+inc).value!="" && document.getElementById("slotDuration"+inc).value!=null )
			{
				if(document.getElementById("fromTime"+inc).value=="" || document.getElementById("toTime"+inc).value=="" )
				{
					alert("Please fill From Time, To Time");
					return false; 
				}
			}
			
			if(document.getElementById('fromTime'+inc).value!="" && document.getElementById('toTime'+inc).value!="")
			{
				if(document.getElementById('fromTime'+inc).value >= document.getElementById('toTime'+inc).value)
				{
					alert("'From Time' should be less than 'To Time' for row "+ eval(inc+1));
					document.getElementById('fromTime'+inc).value="";
					document.getElementById('toTime'+inc).value="";
					return false;
				}
			}
			if(document.getElementById('breakFromTime'+inc).value!="" && document.getElementById('breakToTime'+inc).value!="")
			{
				if(document.getElementById('breakFromTime'+inc).value >= document.getElementById('breakToTime'+inc).value)
				{
					alert("'Break From Time' should be less than 'Break To Time' for row "+ eval(inc+1));
					document.getElementById('breakFromTime'+inc).value="";
					document.getElementById('breakToTime'+inc).value="";
					return false;
				}
			}
						
		}
		return true;
	}

	function showReport(formName)
	{
  		obj = eval('document.'+formName)
  		obj.action = "/hms/hms/appointment?method=printInvestigationSetupJsp";
 		obj.submit();
	}
	function checkDepartment()
	{
		if(document.getElementById('departmentId').value=="0" )
		{
			alert("First select Department");
			return false;
		}
		else
		{
			return true;
		}
	}
	equipmentArray = new Array();

	function populateEquipment(val){
		obj = document.getElementById('equipmentId');
		obj.length = 1;
		for(i=0;i<equipmentArray.length;i++){
			if(equipmentArray[i][0]==val){
				obj.length++;
				obj.options[obj.length-1].value=equipmentArray[i][1];
				obj.options[obj.length-1].text=equipmentArray[i][2];			
			}
		}
	}
	
	function checkEquipment(departmentValue )
	{
		
		populateEquipment(departmentValue);
		if(document.getElementById('equipmentId').value=="0" || document.getSelection("equipmentId").value=="Select" )
		{
			return false;
		}
		else
		{
			return true;
		}
	}
		
	function checkforDepartmentEquipment()
	{
		if(document.getElementById('wardId').value=="0" || document.getElementById('equipId').value=="0")
		{
			alert("Select Department and Equipment!!");
			return false;
		}
		else
		{
			return true;
		}
	}	
	</script>
<h6>Investigation Appointments Setup</h6>
<div class="Clear"></div>

<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	Box box=HMSUtil.getBox(request);

			 	String currenDate = (String) utilMap.get("currentDate");
			 	String currentTime = (String) utilMap.get("currentTime");
			 	
			 	String url=null;
			 	String[] day=new String[7];
			 	
			 	day[0]="Sunday";
			 	day[1]="Monday";
			 	day[2]="Tuesday";
			 	day[3]="Wednesday";
			 	day[4]="Thursday";
			 	day[5]="Friday";
			 	day[6]="Saturday";

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 		
			 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			 	List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
			 	List<AppInvestigationSetup> investigationList = new ArrayList<AppInvestigationSetup>();
			 	
				if (map.get("departmentList") != null) {
					departmentList = (List<MasDepartment>) map.get("departmentList");
			 		
			 	}
				if (map.get("equipmentList") != null) {
					equipmentList = (List<AppEquipmentMaster>) map.get("equipmentList");
			 		
			 	}
				if (map.get("investigationList") != null) {
					investigationList = (List<AppInvestigationSetup>) map.get("investigationList");
			 		
			 	}
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
<label class="noWidth"><span><%=message %></span></label>

<%    
					   
					  }		 	
			 %> <!--Block One Starts-->


<div class="header"><label>Department</label> <!--  <select id="departmentId" name="<%=DEPARTMENT_ID%>" validate="Department,number,no" onchange="if(checkEquipment())submitForm('appInvestigation','appointment?method=showAppointmentInvestigationSetupDetails');"> -->
<select id="departmentId" name="<%=DEPARTMENT_ID%>"
	validate="Department,number,no"
	onchange="if(checkEquipment(this.value))submitForm('appInvestigation','appointment?method=showAppointmentInvestigationSetupDetails');">
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
</select> <label class="noWidth">Equip. Investigation</label> <select
	id="equipmentId" name="<%=EQUIPMENT_ID%>"
	validate="Department,number,no"
	onchange="if(checkDepartment())submitForm('appInvestigation','appointment?method=showAppointmentInvestigationSetupDetails');">
	<option value="0">Select</option>
	<%
				if(equipmentList!= null){
				for (AppEquipmentMaster appEquipmentMaster : equipmentList) {
			%>
	<option value="<%=appEquipmentMaster.getId()%>"><%=appEquipmentMaster.getEquipmentName()%></option>

	<%		}
				}
			%>
</select> <input name="refresh" type="button" value="Generate Report"
	class="cmnButton" onClick="showReport('appInvestigation');"> <script
	type="text/javascript">
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
 </script></div>
<!--Block one Ends-->
<div class="division"></div>


<!--Block Three Starts-->
<div class="colsHolder">
<% if (departmentList!=null)
     {
    %> <label class="common">Department:</label> <input type="hidden"
	id="wardId" name="<%=WARD_ID%>" value="<%=box.getInt(DEPARTMENT_ID)%>" />
<%
    
    	 Iterator ite=departmentList.iterator();
    	 while ( ite.hasNext() ) {
     		MasDepartment masDepartment=(MasDepartment)ite.next();
     		if(masDepartment.getId()==box.getInt(DEPARTMENT_ID))
     		{
     			
     		
     %> <label class="value"> <%=masDepartment.getDepartmentName()%></label>
<%		}
    	 }
     }
    

	 if (equipmentList!=null)
     {
    %> <label class="common">Equipment:</label> <input type="hidden"
	id="equipId" name="<%=EQUIP_ID%>" value="<%=box.getInt(EQUIPMENT_ID)%>" />
<%
    
    	 Iterator ite=equipmentList.iterator();
    	 while ( ite.hasNext() ) {
     		AppEquipmentMaster appEquipmentMaster=(AppEquipmentMaster)ite.next();
     		if(appEquipmentMaster.getId()==box.getInt(EQUIPMENT_ID))
     		{
     			
     		
     %> <label class="value"> <%=appEquipmentMaster.getEquipmentName()%></label>
<input type="hidden" name="<%=NO_OF_EQUIPMENTS %>"
	value="<%=appEquipmentMaster.getNoOfEquipments() %>" /> <%		}
    	 }
     }
    %>

<div class="Clear"></div>
<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Days</th>
		<th scope="col">From Time:</th>
		<th scope="col">To Time</th>
		<th scope="col">Slot </br>
		Duration</th>
		<th scope="col">Break From </br>
		Time</th>
		<th scope="col">Break To </br>
		Time</th>
		<th scope="col">Max No. </br>
		of Days</th>
		<th scope="col">Min No. </br>
		of Days</th>

	</tr>
	<%
    
     	int inc = 0; 
     if(investigationList!=null && investigationList.size()==0)
     {
    	 url="submitForm('appInvestigation','appointment?method=submitAppointmentInvestigationSetup','validateMandatoryFields');";
    	for(inc=0;inc<=6;inc++){
    	%>

	<tr>
		<input type="hidden" id="days<%=inc%>" name="<%=DAYS%>"
			value="<%=day[inc]%>" />
		<td class="colHeader"><%=day[inc]%></td>
		<td><input type="text" size=8 id="fromTime<%=inc%>"
			name="<%=FROMTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /></td>
		<td><input type="text" size=8 id="toTime<%=inc%>"
			name="<%=TOTIME %>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /></td>
		<td><input type="text" size=8 id="slotDuration<%=inc%>"
			name="<%=SLOTTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /> <input
			type="hidden" size=8 id="percentage<%=inc%>" value="99"
			name="<%=PERCENTAGE%>" MAXLENGTH="2" validate="Percentage,num,no" />
		</td>
		<td><input type="text" size=8 id="breakFromTime<%=inc%>"
			name="<%=BREAKFROMTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			id="breakFromTime" /></td>
		<td><input type="text" size=8 id="breakToTime<%=inc%>"
			name="<%=BREAKTOTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			id="breakToTime" /></td>
		<td><input type="text" size=8 id="maxDays<%=inc%>"
			name="<%=MAXDAYS%>" MAXLENGTH="2" validate="Max. no. of Days,num,no" /></td>
		<td><input type="text" size=8 id="minDays<%=inc%>"
			name="<%=MINDAYS%>" MAXLENGTH="2" validate="Min. no. of Days,num,no" /></td>
	</tr>

	<%	}
     } 
     else if (investigationList!=null && investigationList.size()>0)
     {

   		 url="submitForm('appInvestigation','appointment?method=updateAppointmentInvestigationSetup','validateMandatoryFields');";
    	 Iterator ite=investigationList.iterator();
    	 while ( ite.hasNext() ) {
     		AppInvestigationSetup appInvestigationSetup=(AppInvestigationSetup)ite.next();
     %>

	<tr>
		<input type="hidden" name="<%=DAYS%>" value="<%=day[inc]%>" />
		<input type="hidden" name="<%=DEPT_ID%>"
			value="<%=appInvestigationSetup.getDepartment().getId()%>" />
		<input type="hidden" name="<%=INVESTIGATION_ID%>"
			value="<%=appInvestigationSetup.getId()%>" />
		<td class="colHeader"><%=day[inc]%></td>


		<td>
		<%if(appInvestigationSetup.getFromTime()!=null){ %> <input type="text"
			size=8 id="fromTime<%=inc%>" name="<%=FROMTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			value="<%=appInvestigationSetup.getFromTime() %>" /> <%}else{ %> <input
			type="text" size=8 id="fromTime<%=inc%>" name="<%=FROMTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /> <%}%>
		</td>

		<td>
		<%if(appInvestigationSetup.getToTime()!=null){ %> <input type="text"
			size=8 id="toTime<%=inc%>" name="<%=TOTIME %>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			value="<%=appInvestigationSetup.getToTime() %>" /> <%}else{ %> <input
			type="text" size=8 id="toTime<%=inc%>" name="<%=TOTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" />
		<%}%>
		</td>

		<td>
		<%if(appInvestigationSetup.getSlotDuration()!=null){ %> <input
			type="text" size=8 id="slotDuration<%=inc%>" name="<%=SLOTTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			value="<%=appInvestigationSetup.getSlotDuration() %>" /> <%}else{ %>
		<input type="text" size=8 id="slotDuration<%=inc%>"
			name="<%=SLOTTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			id="slotTime" /> <%}%> <%if(appInvestigationSetup.getPercentageForSlots()!=null && appInvestigationSetup.getPercentageForSlots()!=0){ %>
		<input type="hidden" size=8 id="percentageForSlots<%=inc%>"
			name="<%=PERCENTAGE%>" MAXLENGTH="2"
			value="<%=appInvestigationSetup.getPercentageForSlots() %>"
			validate="Percentage,num,no" /> <%}else{ %> <input type="hidden" size=8
			id="percentageForSlots<%=inc%>" value="99" name="<%=PERCENTAGE%>"
			MAXLENGTH="2" validate="Percentage,num,no" /> <%}%>
		</td>

		<td>
		<%if(appInvestigationSetup.getBreakFromTime()!=null){ %> <input
			type="text" size=8 id="breakFromTime<%=inc%>"
			name="<%=BREAKFROMTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			value="<%=appInvestigationSetup.getBreakFromTime() %>" /> <%}else{ %>
		<input type="text" size=8 id="breakFromTime<%=inc%>"
			name="<%=BREAKFROMTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" />
		<%}%>
		</td>

		<td>
		<%if(appInvestigationSetup.getBreakToTime()!=null){ %> <input
			type="text" size=8 id="breakToTime<%=inc%>" name="<%=BREAKTOTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			value="<%=appInvestigationSetup.getBreakToTime() %>" /> <%}else{ %> <input
			type="text" size=8 id="breakToTime<%=inc%>" name="<%=BREAKTOTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" />
		<%}%>
		</td>

		<td>
		<%if(appInvestigationSetup.getMaxNoOfDays()!=null && appInvestigationSetup.getMaxNoOfDays()!=0){ %>
		<input type="text" size=8 id="maxDays<%=inc%>" name="<%=MAXDAYS%>"
			MAXLENGTH="2" value="<%=appInvestigationSetup.getMaxNoOfDays() %>"
			validate="Max. no. of Days,num,no" /> <%}else{ %> <input type="text"
			size=8 id="maxDays<%=inc%>" name="<%=MAXDAYS%>" MAXLENGTH="2"
			validate="Max. no. of Days,num,no" /> <%}%>
		</td>

		<td>
		<%if(appInvestigationSetup.getMinNoOfDays()!=null && appInvestigationSetup.getMinNoOfDays()!=0){ %>
		<input type="text" size=8 id="minDays<%=inc%>" name="<%=MINDAYS%>"
			MAXLENGTH="2" value="<%=appInvestigationSetup.getMinNoOfDays() %>"
			validate="Min. no. of Days,num,no" /> <%}else{ %> <input type="text"
			size=8 id="minDays<%=inc%>" name="<%=MINDAYS%>" MAXLENGTH="2"
			validate="Min. no. of Days,num,no" /> <%}%>
		</td>



	</tr>

	<%	inc++;
   		}
    	
    		inc=7-investigationList.size();
    		for(int i=0;i<inc;i++){
    	    	%>

	<tr>
		<input type="hidden" name="<%=DAYS%>" value="<%=day[i]%>" />
		<td class="colHeader"><%=day[i]%></td>
		<td><input type="text" size=8 id="fromTime<%=inc%>"
			name="<%=FROMTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /></td>
		<td><input type="text" size=8 id="toTime<%=inc%>"
			name="<%=TOTIME %>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /></td>
		<td><input type="text" size=8 id="slotDuration<%=inc%>"
			name="<%=SLOTTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /> <input
			type="hidden" size=8 id="percentage<%=inc%>" value="99"
			name="<%=PERCENTAGE%>" MAXLENGTH="2" validate="Percentage,num,no" />
		</td>
		<td><input type="text" size=8 id="breakFromTime<%=inc%>"
			name="<%=BREAKFROMTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /></td>
		<td><input type="text" size=8 id="breakToTime<%=inc%>"
			name="<%=BREAKTOTIME%>"
			onKeyUp="maskWithBackspaceCheck(this.value,this,'2,5',':',event);"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /></td>
		<td><input type="text" size=8 id="maxDays<%=inc%>"
			name="<%=MAXDAYS%>" MAXLENGTH="2" validate="Max. no. of Days,num,no" /></td>
		<td><input type="text" size=8 id="minDays<%=inc%>"
			name="<%=MINDAYS%>" MAXLENGTH="2" validate="Min. no. of Days,num,no" /></td>
	</tr>

	<%	}
    	
    			
      
     } 
   %>
</table>
</div>

</div>
<!--Bottom labels starts-->
<div class="bottom"><label>Changed By </label> <label
	class="value"><%=userName %></label> <label>Changed Date </label> <label
	class="value"><%=currenDate %></label> <label>Changed Time </label> <label
	class="value"><%=currentTime%></label></div>
<div class="bottom">

<div class="Clear"></div>
<input name="" type="button" class="button" value="Submit"
	onclick="if(checkforDepartmentEquipment())<%=url%>" /> <input name=""
	type="reset" class="button" value="Reset" /></div>
<!--Bottom labels ends--></form>
</div>
<!--main content placeholder ends here-->
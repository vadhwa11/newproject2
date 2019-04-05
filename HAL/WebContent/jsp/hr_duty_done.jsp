<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * appSetup.jsp  
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
<%@ page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<!--main content placeholder starts here-->



<div id="contentHolder">
<form name="guardDutyPerformed" method="post" action=""><script
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
		
	function checkForDate()
	{
	   var currentdate=new Date();
	   var stringdutydate=document.getElementById('dutyDate').value;
	   var dutydate;
	   var message="";
	   if(stringdutydate!=''){
	   dutydate=new Date(stringdutydate.substring(6),stringdutydate.substring(3,5)-1,stringdutydate.substring(0,2));
			  
	   if(dutydate>=currentdate)
	   {
	   message += "Duty Date Should be Less than current Date";
	  
	   }
	   }else
	   {
	   message +="Duty Date should not Empty";
	   }
	   if(message!="")
	   {
	   alert(message);
	   return false;
	   }
		return true;
	}	
	function jsUpdate()
{
		if (validateButton())
		{
		guardDutyPerformed.method="post";
		submitForm('guardDutyPerformed','hrRelated?method=updateDutyPerformed');
		}
		else
		alert('Pl. select the duty  to update!......'); 
}

function validateButton()
{
	
	if (guardDutyPerformed.hrGuardDutyAdded.length)
	{
			 for(var i = 0; i < guardDutyPerformed.hrGuardDutyAdded.length; i++)
			 {
			  if (guardDutyPerformed.hrGuardDutyAdded[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (guardDutyPerformed.hrGuardDutyAdded.checked == true)
			return true;
	}
	return false;
}
	</script>
<h6>Actual Guard Duty Perform Entry</h6>
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
			 	List hrDutyEntryList=new ArrayList();
			 	List<HrDutyMaster> hrDutyMasterList=new ArrayList<HrDutyMaster>();
			 	String url=null;
			 	String searchdutydate="";
                String dutyDate = "";
                String dutyType="";
                int otName = 0;
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	if(map.get("hrDutyEntryList") != null){
			 		hrDutyEntryList = (List)map.get("hrDutyEntryList");
				}	
			 	if(map.get("dutyType") != null){
			 		dutyType = (String)map.get("dutyType");
				}
			 	if(map.get("hrDutyMasterList") != null){
			 		hrDutyMasterList = (List)map.get("hrDutyMasterList");
				}	
			 	if(map.get("searchdutydate") != null){
			 		searchdutydate = (String)map.get("searchdutydate");
				}
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
<div class="Clear"></div>
<div class="Clear"></div>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px; color: red;">
<%=message %></div>
</div>

<%    
					   
					  }		 	
			 %> <!--Block One Starts-->


<div class="header"><label>Duty Type :</label> <select
	name="dutyType" id="dutyType">
	<option value="">select</option>
	<%if(!dutyType.equals("")){ 
   for(HrDutyMaster hrDutyMaster:hrDutyMasterList){
	if(dutyType.equals(hrDutyMaster.getDutyName())){   
   
 %>
	<option value="<%=hrDutyMaster.getDutyName() %>" selected><%=hrDutyMaster.getDutyName() %></option>
	<%}else { %>
	<option value="<%=hrDutyMaster.getDutyName() %>"><%=hrDutyMaster.getDutyName() %></option>
	<%}}}else{ 
	 for(HrDutyMaster hrDutyMaster:hrDutyMasterList){
 %>
	<option value="<%=hrDutyMaster.getDutyName() %>"><%=hrDutyMaster.getDutyName() %></option>
	<%}} %>
</select> <label> Duty Date:</label> <input type="text" id="dutyDate"
	name="dutyDate" value="<%=dutyDate%>" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16"
	onclick="setdate('<%=currentDate %>',document.guardDutyPerformed.dutyDate,event);"
	border="0" validate="Pick a date" class="calender" /> <input
	name="Print" type="button" value="Load Duty Schedule" target="_blank"
	class="cmnButton"
	onclick="if(true)submitForm('guardDutyPerformed','hrRelated?method=searchDutyPerformed');">
</div>
<!--Block one Ends-->
<div class="division"></div>
<div class="Clear"></div>
<div class="Clear"></div>

<!--Block Three Starts-->

<div class="colsHolder">

<div class="Clear"></div>
<input type="hidden" name="dutyTypename" id="dutyTypename"
	value="<%=dutyType %>" />
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<% System.out.println("hrGuardDutyEntryList.size() :"+hrDutyEntryList.size());
if(hrDutyEntryList!=null && hrDutyEntryList.size()>0){
			Iterator itr=hrDutyEntryList.iterator();
          	int  counter=0;%>
	<tr>

		<th scope="col">Service No.</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Duty Date</th>
		<th scope="col">Location</th>
		<th scope="col">Duty Shift</th>

		<th scope="col">Duty Type</th>
		<th scope="col">Actual Duty Preformed</th>

	</tr>

	<%
  
  int i = 1;   
     while(itr.hasNext())
           	{
    	 if(dutyType.equals("Guard Duty")){
    	 HrGuardDutyEntry  hrGuardDutyEntry = (HrGuardDutyEntry)itr.next();
   %>

	<tr>

		<input name="dutyId" id=<%="dutyId"+i %> type="hidden"
			value="<%=hrGuardDutyEntry.getId()%>" />

		<td><%=hrGuardDutyEntry.getEmp().getServiceNo() %> <input
			name="empId" id=<%="empId"+i %> type="hidden"
			value="<%=hrGuardDutyEntry.getEmp().getId() %>" /></td>

		<td><%=hrGuardDutyEntry.getEmp().getRank().getRankName()%></td>
		<% 
    	
    	String Empname = " ";
    	if(hrGuardDutyEntry.getEmp().getFirstName()!=null && !hrGuardDutyEntry.getEmp().getFirstName().equals("")){
    		Empname=Empname+hrGuardDutyEntry.getEmp().getFirstName()+" ";
    	}
    	if(hrGuardDutyEntry.getEmp().getMiddleName()!=null && !hrGuardDutyEntry.getEmp().getMiddleName().equals("")){
    		Empname=Empname+hrGuardDutyEntry.getEmp().getMiddleName()+" ";
    	}
    	if(hrGuardDutyEntry.getEmp().getLastName()!=null && !hrGuardDutyEntry.getEmp().getLastName().equals("")){
    		Empname=Empname+hrGuardDutyEntry.getEmp().getLastName()+" ";
    	}
    	%>
		<td><%=Empname%></td>

		<td><%=HMSUtil.convertDateToStringWithoutTime(hrGuardDutyEntry.getDutyDate())%></td>
		<td><%=hrGuardDutyEntry.getDepartmentId().getDepartmentName() %>
		</td>
		<td><%= hrGuardDutyEntry.getDutyTime().getDutyShiftType()%></td>

		<td><%= hrGuardDutyEntry.getTypeStatus() %></td>

		<td><input type="checkbox" name="hrGuardDutyAdded"
			value="<%=hrGuardDutyEntry.getId()%>"></td>
		<%}else if(dutyType.equals("Night Duty")){
   	 		HrDutyEntry  hrDutyEntry = (HrDutyEntry)itr.next();  %>
		<tr>

			<input name="dutyId" id=<%="dutyId"+i %> type="hidden"
				value="<%=hrDutyEntry.getId()%>" />

			<td><%=hrDutyEntry.getEmp().getServiceNo() %> <input
				name="empId" id=<%="empId"+i %> type="hidden"
				value="<%=hrDutyEntry.getEmp().getId() %>" /></td>

			<td><%=hrDutyEntry.getEmp().getRank().getRankName()%></td>
			<% 
    	
    	String Empname = " ";
    	if(hrDutyEntry.getEmp().getFirstName()!=null && !hrDutyEntry.getEmp().getFirstName().equals("")){
    		Empname=Empname+hrDutyEntry.getEmp().getFirstName()+" ";
    	}
    	if(hrDutyEntry.getEmp().getMiddleName()!=null && !hrDutyEntry.getEmp().getMiddleName().equals("")){
    		Empname=Empname+hrDutyEntry.getEmp().getMiddleName()+" ";
    	}
    	if(hrDutyEntry.getEmp().getLastName()!=null && !hrDutyEntry.getEmp().getLastName().equals("")){
    		Empname=Empname+hrDutyEntry.getEmp().getLastName()+" ";
    	}
    	%>
			<td><%=Empname%></td>

			<td><%=HMSUtil.convertDateToStringWithoutTime(hrDutyEntry.getDutyDate())%></td>
			<td><%=hrDutyEntry.getDepartmentId().getDepartmentName() %></td>
			<td><%= hrDutyEntry.getDutyTime().getDutyShiftType()%></td>

			<td><%= hrDutyEntry.getTypeStatus() %></td>

			<td><input type="checkbox" name="hrGuardDutyAdded"
				value="<%=hrDutyEntry.getId()%>"></td>
			<%}else if(dutyType.equals("Ward Duty")){
   	 		HrWardDutyEntry  hrWardDutyEntry = (HrWardDutyEntry)itr.next();  %>
			<tr>

				<input name="dutyId" id=<%="dutyId"+i %> type="hidden"
					value="<%=hrWardDutyEntry.getId()%>" />

				<td><%=hrWardDutyEntry.getEmp().getServiceNo() %> <input
					name="empId" id=<%="empId"+i %> type="hidden"
					value="<%=hrWardDutyEntry.getEmp().getId() %>" /></td>

				<td><%=hrWardDutyEntry.getEmp().getRank().getRankName()%></td>
				<% 
    	
    	String Empname = " ";
    	if(hrWardDutyEntry.getEmp().getFirstName()!=null && !hrWardDutyEntry.getEmp().getFirstName().equals("")){
    		Empname=Empname+hrWardDutyEntry.getEmp().getFirstName()+" ";
    	}
    	if(hrWardDutyEntry.getEmp().getMiddleName()!=null && !hrWardDutyEntry.getEmp().getMiddleName().equals("")){
    		Empname=Empname+hrWardDutyEntry.getEmp().getMiddleName()+" ";
    	}
    	if(hrWardDutyEntry.getEmp().getLastName()!=null && !hrWardDutyEntry.getEmp().getLastName().equals("")){
    		Empname=Empname+hrWardDutyEntry.getEmp().getLastName()+" ";
    	}
    	%>
				<td><%=Empname%></td>

				<td><%=HMSUtil.convertDateToStringWithoutTime(hrWardDutyEntry.getDutyDate())%></td>
				<td><%=hrWardDutyEntry.getDepartmentId().getDepartmentName() %>
				</td>
				<td><%= hrWardDutyEntry.getDutyTime().getDutyShiftType()%></td>

				<td><%= hrWardDutyEntry.getTypeStatus() %></td>

				<td><input type="checkbox" name="hrGuardDutyAdded"
					value="<%=hrWardDutyEntry.getId()%>"></td>
				<%}else if(dutyType.equals("Orderly Duty")){
    	HrOrderlyDutyEntry  hrOrderlyDutyEntry = (HrOrderlyDutyEntry)itr.next();  %>
				<tr>

					<input name="dutyId" id=<%="dutyId"+i %> type="hidden"
						value="<%=hrOrderlyDutyEntry.getId()%>" />

					<td><%=hrOrderlyDutyEntry.getEmp().getServiceNo() %> <input
						name="empId" id=<%="empId"+i %> type="hidden"
						value="<%=hrOrderlyDutyEntry.getEmp().getId() %>" /></td>

					<td><%=hrOrderlyDutyEntry.getEmp().getRank().getRankName()%></td>
					<% 
    	
    	String Empname = " ";
    	if(hrOrderlyDutyEntry.getEmp().getFirstName()!=null && !hrOrderlyDutyEntry.getEmp().getFirstName().equals("")){
    		Empname=Empname+hrOrderlyDutyEntry.getEmp().getFirstName()+" ";
    	}
    	if(hrOrderlyDutyEntry.getEmp().getMiddleName()!=null && !hrOrderlyDutyEntry.getEmp().getMiddleName().equals("")){
    		Empname=Empname+hrOrderlyDutyEntry.getEmp().getMiddleName()+" ";
    	}
    	if(hrOrderlyDutyEntry.getEmp().getLastName()!=null && !hrOrderlyDutyEntry.getEmp().getLastName().equals("")){
    		Empname=Empname+hrOrderlyDutyEntry.getEmp().getLastName()+" ";
    	}
    	%>
					<td><%=Empname%></td>

					<td><%=HMSUtil.convertDateToStringWithoutTime(hrOrderlyDutyEntry.getDutyDate())%></td>
					<td><%=hrOrderlyDutyEntry.getDepartmentId().getDepartmentName() %>
					</td>
					<td><%= hrOrderlyDutyEntry.getDutyTime().getDutyShiftType()%>
					</td>

					<td><%= hrOrderlyDutyEntry.getTypeStatus() %></td>

					<td><input type="checkbox" name="hrGuardDutyAdded"
						value="<%=hrOrderlyDutyEntry.getId()%>"></td>
					<%} %>
				</tr>
				<%                         	 i++;
							     counter++;
			}//end of WHILE
}else{//end of IF
%>
				<tr colspan="8">
					No Data Found
				</tr>
				<%} %>
			
</table>

</div>
<div class="division"></div>
<%if(hrDutyEntryList!=null && hrDutyEntryList.size()>0){%> <input
	name="Input" type="button" class="cmnButton"
	value="Update Duty performed" onclick="jsUpdate();" /> <%} %>
<div class="Clear"></div>
</div>
<input type="hidden" name="searchdutydate" id="searchdutydate"
	value="<%=searchdutydate %>" /></form>
</div>

<!--main content placeholder ends here-->
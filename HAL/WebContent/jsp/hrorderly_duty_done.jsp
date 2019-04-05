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
		submitForm('guardDutyPerformed','hrOrderly?method=updateGuardDutyPerformed');
		}
		else
		alert('Pl. select the duty  to update!......'); 
}

function validateButton()
{
	
	if (guardDutyPerformed.hrorderlyGuardDutyAdded.length)
	{
			 for(var i = 0; i < guardDutyPerformed.hrorderlyGuardDutyAdded.length; i++)
			 {
			  if (guardDutyPerformed.hrorderlyGuardDutyAdded[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (guardDutyPerformed.hrorderlyGuardDutyAdded.checked == true)
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
			 	List<HrorderlyGuardDutyEntry> hrorderlyGuardDutyEntryList=new ArrayList<HrorderlyGuardDutyEntry>();
			 	String url=null;
			 	String searchdutydate="";
                String dutyDate = "";
                int otName = 0;
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	if(map.get("hrorderlyGuardDutyEntryList") != null){
			 		hrorderlyGuardDutyEntryList = (List)map.get("hrorderlyGuardDutyEntryList");
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


<div class="header"><label>Guard Duty Date:</label> <input
	type="text" id="dutyDate" name="dutyDate" value="<%=dutyDate%>"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16"
	onclick="setdate('<%=currentDate %>',document.guardDutyPerformed.dutyDate,event);"
	border="0" validate="Pick a date" class="calender" /> <input
	name="Print" type="button" value="Load Duty Schedule" target="_blank"
	class="cmnButton"
	onclick="if(true)submitForm('guardDutyPerformed','hrOrderly?method=searchGuardDutyPerformed');">
</div>
<!--Block one Ends-->
<div class="division"></div>
<div class="Clear"></div>
<div class="Clear"></div>

<!--Block Three Starts-->

<div class="colsHolder">

<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<% System.out.println("hrorderlyGuardDutyEntryList.size() :"+hrorderlyGuardDutyEntryList.size());
if(hrorderlyGuardDutyEntryList!=null && hrorderlyGuardDutyEntryList.size()>0){
			Iterator itr=hrorderlyGuardDutyEntryList.iterator();
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
    	 HrorderlyGuardDutyEntry  hrorderlyGuardDutyEntry = (HrorderlyGuardDutyEntry)itr.next();
   %>

	<tr>

		<input name="dutyId" id=<%="dutyId"+i %> type="hidden"
			value="<%=hrorderlyGuardDutyEntry.getId()%>" />

		<td><%=hrorderlyGuardDutyEntry.getEmp().getServiceNo() %> <input
			name="empId" id=<%="empId"+i %> type="hidden"
			value="<%=hrorderlyGuardDutyEntry.getEmp().getId() %>" /></td>

		<td><%=hrorderlyGuardDutyEntry.getEmp().getRank().getRankName()%>
		</td>
		<% 
    	
    	String Empname = " ";
    	if(hrorderlyGuardDutyEntry.getEmp().getFirstName()!=null && !hrorderlyGuardDutyEntry.getEmp().getFirstName().equals("")){
    		Empname=Empname+hrorderlyGuardDutyEntry.getEmp().getFirstName()+" ";
    	}
    	if(hrorderlyGuardDutyEntry.getEmp().getMiddleName()!=null && !hrorderlyGuardDutyEntry.getEmp().getMiddleName().equals("")){
    		Empname=Empname+hrorderlyGuardDutyEntry.getEmp().getMiddleName()+" ";
    	}
    	if(hrorderlyGuardDutyEntry.getEmp().getLastName()!=null && !hrorderlyGuardDutyEntry.getEmp().getLastName().equals("")){
    		Empname=Empname+hrorderlyGuardDutyEntry.getEmp().getFirstName()+" ";
    	}
    	%>
		<td><%=Empname%></td>

		<td><%=HMSUtil.convertDateToStringWithoutTime(hrorderlyGuardDutyEntry.getDutyDate())%></td>
		<td><%=hrorderlyGuardDutyEntry.getDeparmentId().getDepartmentName() %>
		</td>
		<td><%= hrorderlyGuardDutyEntry.getDutyTime().getDutyShiftType()%>
		</td>

		<td><%= hrorderlyGuardDutyEntry.getTypeStatus() %></td>

		<td><input type="checkbox" name="hrorderlyGuardDutyAdded"
			value="<%=hrorderlyGuardDutyEntry.getId()%>"></td>

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
<%if(hrorderlyGuardDutyEntryList!=null && hrorderlyGuardDutyEntryList.size()>0){%>
<input name="Input" type="button" class="cmnButton"
	value="Update Duty performed" onclick="jsUpdate();" /> <%} %>
<div class="Clear"></div>
</div>
<input type="hidden" name="searchdutydate" id="searchdutydate"
	value="<%=searchdutydate %>" /></form>
</div>

<!--main content placeholder ends here-->
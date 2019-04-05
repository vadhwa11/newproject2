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
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<!--main content placeholder starts here-->
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />


<div id="contentHolder">
<form name="OtListChange" method="post" action=""><script
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
		
	function checkForSelection()
	{
	for(var i = 0; i < document.getElementsByName('bookingId').length; i++)
		{
			  if(document.getElementsByName('bookingId')[i].checked == true && document.getElementsByName('bookingId')[i].value!=null)
			  {
					rowSelected=true;
					break;	
		      }
			  else
					rowSelected=false;
		}
		if(rowSelected==false)
		{
			alert("Select a Record!!");
			return false;
		}
		return true;
	}	
	</script>
<div class="titleBg">
<h2>Actual Surgery Perform Entry</h2>
</div>

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
			 	List <OtBooking> otBookingList = new ArrayList<OtBooking>();
			 	List <MasOt> masOtList = new ArrayList<MasOt>();
			 	
			 	String url=null;
                String bookingDate = "";
                int otName = 0;
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	if(map.get("otBookingList") != null){
					otBookingList = (List)map.get("otBookingList");
				}	
			 	
			 	if(map.get("masOtList") != null){
			 		masOtList = (List)map.get("masOtList");
				}
			 	
			 	if(map.get("bookingDate") != null){
			 		bookingDate = (String)map.get("bookingDate");
				}	
			 	
			 	if(map.get("otName") != null){
			 		otName = (Integer)map.get("otName");
				}
			 
			 	System.out.println("message in jsp-- "+map.get("message"));	
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


<div class="Block">
<label>Booking Date:</label> <input
	type="text" id="bookingDate" name="bookingDate"
	value="<%=bookingDate%>" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16"
	onclick="setdate('<%=currentDate %>',document.OtListChange.bookingDate,event);"
	border="0" validate="Pick a date" class="calender" />
	
	<input name="Print" type="button" value="Load All OT Schedule" target="_blank" class="button"
	onclick="if(checkForDate())submitForm('OtListChange','ot?method=getActualOTPerformedSchedule');">
</div>
<!--Block one Ends-->
<div class="Clear"></div>

<!--Block Three Starts-->

<div class="colsHolder">

<div class="Clear"></div>
<div class="tableHolderAuto">
<% System.out.println("otBookingList.size() :"+otBookingList.size());
if(otBookingList!=null && otBookingList.size()>0){
			Iterator itr=otBookingList.iterator();
          	int  counter=0;%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>

		<th scope="col">OT Name</th>
		<th scope="col">Sl.No.</th>
		<th scope="col">Surgeon</th>
		<th scope="col">Relation</th>
		<th scope="col">Service No.</th>
		<th scope="col">Booking Date</th>

		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Age (Yrs)</th>
		<th scope="col">Operation</th>
		<th scope="col">Ward</th>
		<th scope="col">Surgery Done</th>
		<th scope="col">Surgery Status</th>

	</tr>

	<%
  int i = 1;   
     while(itr.hasNext())
           	{
             		OtBooking  otBooking = (OtBooking)itr.next();
   %>

	<tr>

		<input name="bookingId" id=<%="bookingId"+i %> type="hidden"
			value="<%=otBooking.getId()%>" />

		<td><%=otBooking.getOt().getOtName() %> <input name="otId"
			id=<%="otId"+i %> type="hidden"
			value="<%=otBooking.getOt().getId() %>" /></td>

		<td>
		<%if(otBooking.getSlNo()==0){ %> Stand By <%}else{%><%=otBooking.getSlNo() %>
		<input name="seqId" id=<%="seqId"+i %> type="hidden"
			value="<%=otBooking.getSlNo() %>" /> <%} %>
		</td>
		<% 
    	int count = 1;
    	String allNamesSurgeon = "";
    	Set<OtBookSurgeon> surgeonSet = otBooking.getOtBookSurgeons();
    	for(OtBookSurgeon otBookSurgeon : surgeonSet){
        	String fullNameSurgeon = otBookSurgeon.getEmployee().getFirstName();
        	if(otBookSurgeon.getEmployee().getMiddleName() != null){ 
        		fullNameSurgeon = fullNameSurgeon + " " + otBookSurgeon.getEmployee().getMiddleName();
        	}
        	if(otBookSurgeon.getEmployee().getLastName() != null){
        		fullNameSurgeon = fullNameSurgeon + " " + otBookSurgeon.getEmployee().getLastName();
        	} %>
		<% if(count == 1){ 
    		allNamesSurgeon = allNamesSurgeon + fullNameSurgeon;
    	   }else{ 
    		allNamesSurgeon = allNamesSurgeon + ","  + fullNameSurgeon;
 		   } 
    	count++;
   
    	}
    	%>
		<td><%=allNamesSurgeon%></td>

		<td><%=otBooking.getHin().getRelation().getRelationName() %></td>
		<td><%=otBooking.getHin().getServiceNo() %></td>
		<td><%= HMSUtil.convertDateToStringWithoutTime(otBooking.getSurgeryDate())%>
		</td>
		<input type="hidden" name="date"
			value="<%=HMSUtil.convertDateToStringWithoutTime(otBooking.getSurgeryDate()) %>" />
		<td><%=otBooking.getHin().getRank().getRankName() %></td>

		<td>
		<% 
    	String fullNamePatient = otBooking.getHin().getSFirstName();
    	if(otBooking.getHin().getPMiddleName() != null){ 
    		fullNamePatient = fullNamePatient + " " + otBooking.getHin().getSMiddleName();
    	}
    	if(otBooking.getHin().getPLastName() != null){
    		fullNamePatient = fullNamePatient + " " + otBooking.getHin().getSLastName();
    	}
    	%> <%=fullNamePatient%></td>
		<td><%=otBooking.getHin().getAge() %></td>
		<% if(otBooking.getChargeCode() != null && !otBooking.getChargeCode().getChargeCodeName().equals("")){ %>
		<td><%=otBooking.getChargeCode().getChargeCodeName() %></td>
		<% }else{ %>
		<td>-</td>
		<% } %>

		<% if(otBooking.getInpatient() != null ){ %>
		<td><%=otBooking.getInpatient().getAdWardId().getDepartmentName() %></td>
		<% }else {%>
		<td>-</td>
		<% } %>
		<td><select name="surgeryDoneStatus" id="surgeryDoneStatus<%=i%>"
			tabindex="1">
			<option value="y">Yes</option>
			<option value="n">No</option>
		</select> <script type="text/javascript">
			document.getElementById('surgeryDoneStatus<%=i%>').value = '<%=otBooking.getSurgeryDoneStatus()%>';
		</script></td>
		<td><select name="surgeryStatus" id="surgeryStatus<%=i%>"
			tabindex="1" style="width: 110px;">
			<option value="">Select surgery status</option>
			<option value="1">PreOperative care</option>
			<option value="2">Surgery in progress</option>
			<option value="3">PostOperative care</option>
			<option value="4">Surgery Cancelled</option>
			<option value="5">Shifted To Ward</option>

		</select> <script type="text/javascript">
			<%if(otBooking.getSurgeryStatus() != null){%>
			document.getElementById('surgeryStatus<%=i%>').value = '<%=otBooking.getSurgeryStatus()%>';
			<%}else{%>
			document.getElementById('surgeryStatus<%=i%>').value = '';
			<%}%>
		</script></td>
	</tr>
	<%                          i++;
							     counter++;
			}//end of WHILE
}//end of IF
%>
</table>

</div>
<div class="division"></div>
<%if(otBookingList!=null && otBookingList.size()>0){%> <input name="Input"
	type="button" class="cmnButton" value="Update Surgery Status"
	onclick="submitForm('OtListChange','ot?method=updateSurgeryDoneStatus');" />

<%} %>
<div class="Clear"></div>
</div>

</form>
</div>
<script>
function checkForDate()
{
	if(document.getElementById('bookingDate').value==null || document.getElementById('bookingDate').value=="")
	{
		alert("Select OT Date!!");
		return false;
	}
	return true;
}
function printOtListReport(){
	checkTargetForYes();
	submitForm('OtListChange','ot?method=generateOtListReport');
	checkTargetForNo();
}

function orderSeqchange()
	{
	var bookingId;
	var bookingDate;
	var bookingTime;
	var otId; 
	var seqId;
		
	for(var i = 0; i < document.getElementsByName('bookingId').length; i++)
		{
			  if(document.getElementsByName('bookingId')[i].checked == true && document.getElementsByName('bookingId')[i].value!=null)
			  {
					rowSelected=true;
					bookingId = document.getElementsByName('bookingId')[i].value;
					bookingDate = document.getElementsByName('tBookDate')[i].value;
					bookingTime = document.getElementsByName('tBookTime')[i].value;
					otId = document.getElementsByName('otId')[i].value;
					seqId = document.getElementsByName('seqId')[i].value;
					break;	
		      }
			  else
					rowSelected=false;
		}
		if(rowSelected==false)
		{
			alert("Select a Record!!");
			return false;
		}else{
		   if(seqId > 1){
		   if(confirm("Please check the BookingDate & BookingTime. !!")){
		     OtListChange.method="post";	
			   submitForm('OtListChange','ot?method=orderSeqchange&bookingId='+bookingId+'&bookingDate='+bookingDate+'&bookingTime='+bookingTime+'&otId='+otId+'&seqId='+seqId);
		   }	
		else{
			return false;
		}
		}else{
		    alert("You can not move up !!");
		    return false;
		 }
		}
		
		//return true;
	}	
</script>
<!--main content placeholder ends here-->
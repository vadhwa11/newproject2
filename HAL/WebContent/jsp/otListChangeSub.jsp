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
<!-- <link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css"> -->
<!--main content placeholder starts here-->
<!-- <link href="css/hms_style.css" rel="stylesheet" type="text/css" /> -->


<div id="contentHolder">
<form name="otListChangeSub" method="post" action=""><script
	type="text/javascript" language="javascript">
var deptSelected=false;
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
	
	
	
function activateOptions(optionValue)
{
	if(optionValue=='otName')
	{
		document.getElementById('newOt').disabled=false;
		document.getElementById('newSlNo').disabled=true;
		document.getElementById('newBookingDate').disabled=true;
	}
	
	if(optionValue=='slNo')
	{
		document.getElementById('newOt').disabled=true;
		document.getElementById('newSlNo').disabled=false;
		document.getElementById('newBookingDate').disabled=true;
	}
	if(optionValue=='bookingDate')
	{
		document.getElementById('newOt').disabled=true;
		document.getElementById('newSlNo').disabled=true;
		document.getElementById('newBookingDate').disabled=false;
	}
}

function checkForSelection()
{
	for(var i = 0; i < document.getElementsByName('changeCriteria').length; i++){
		if(document.getElementsByName('changeCriteria')[i].checked == true )
        {
			var optionValue=document.getElementsByName('changeCriteria')[i].value;
			if(optionValue=='otName')
			{
				if(document.getElementById('newOt').value=="0")
				{
					alert("Select OT!!");
					return false;
				}
			}
			if(optionValue=='newSlNo')
			{
				if(document.getElementById('newSlNo').value=="0")
				{
					alert("Select Sl No. !!");
					return false;
				}
		
			}
			if(optionValue=='bookingDate')
			{
				if(document.getElementById('newBookingDate').value=="")
				{
					alert("Enter Booking Date!!");
					return false;
				}
			}
		}
	}
		return true;
	
}
	</script>
<h6>OT List Change</h6>
<div class="Clear"></div>

<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	int otId=0;
			 	int slNo=0;
			 	Date bookingDate=new Date();
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	Box box=HMSUtil.getBox(request);
			 	List <OtBooking> otBookingList = new ArrayList<OtBooking>();
			 	List <OtBooking> otBookingList2 = new ArrayList<OtBooking>();
				List <MasOtDistribution> masOtList = new ArrayList<MasOtDistribution>();
			 	int bookingId=0;
			 	String url=null;
			 	
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 		
			 	
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message %>
</div>
</div>

<%    
					   
					  }
			 	if(map.get("otBookingList") != null){
					otBookingList = (List)map.get("otBookingList");
					  }
			 	if(map.get("otBookingList2") != null){
					otBookingList2 = (List)map.get("otBookingList2");
					  }
				if(map.get("masOtList") != null){
					masOtList = (List)map.get("masOtList");
					  }
				//System.out.println("masOtList=="+masOtList.size());
			 %> <!--Block One Starts--> <%
	for (OtBooking otBooking : otBookingList) {
%> <%bookingId= otBooking.getId();%> <input type="hidden"
	name="selectedId" value="<%=bookingId%>" id="selectedId" />
<div class="blockFrame"><label>Service No. </label> <label
	class="valueNoWidth"><%=otBooking.getHin().getServiceNo()%> </label> <label
	class="medium">Name</label> <label class="valueNoWidth"
	style="width: auto;"><%=otBooking.getHin().getPFirstName()%> <%=otBooking.getHin().getPLastName()%></label>

<label class="medium">Age</label> <label class="valueNoWidth"><%=otBooking.getHin().getAge()%></label>

<label class="medium">Current OT</label> <label class="valueNoWidth"><%=otBooking.getOt().getOtName()%></label>
<input type="hidden" name="selectedOtId"
	value="<%=otBooking.getOt().getId() %>" id="selectedOtId" /> <%otId=otBooking.getOt().getId();%>
<div class="Clear"></div>

<%-- <label>Current Sl. No.</label> <label class="valueNoWidth"><%=otBooking.getSlNo()%></label>
<input type="hidden" name="selectedSlNo"
	value="<%=otBooking.getSlNo() %>" id="selectedSlNo" /> <%slNo=otBooking.getSlNo(); %> --%>

<label class="medium">Booking Date</label> <label class="valueNoWidth"><%=HMSUtil.convertDateToStringWithoutTime(otBooking.getSurgeryDate())%></label>
<input type="hidden" name="SelectedBookingDate"
	value="<%=HMSUtil.convertDateToStringWithoutTime(otBooking.getSurgeryDate()) %>"
	id="SelectedBookingDate" /> <%bookingDate=otBooking.getSurgeryDate();%>
</div>
<%} %> <!--Block one Ends-->

<div class="Clear"></div>
<div class="blockFrame"><label class="small">&nbsp;</label> <input
	name="changeCriteria" type="radio" id="changeCriteria" value="otName"
	class="radio" onclick="activateOptions(this.value);" checked="checked">
<label class="large">Change to OT </label> <select id="newOt"
	name="<%=NEW_OT%>" validate="OT,number,no"
	onchange="checkForAppmtDate()" />
	<option value="0">Select</option>
	<%
				for (MasOtDistribution masOtDistribution : masOtList) {
					
					if(masOtDistribution.getOt().getId()!=otId){
			%>
	<option value="<%=masOtDistribution.getOt().getId()%>"><%=masOtDistribution.getOt().getOtName()%></option>
	<%
					}
			}
			%>
</select>

<div class="Clear"></div>
<label class="small">&nbsp;</label> <input name="changeCriteria"
	type="radio" id="changeCriteria" value="slNo" class="radio"
	onclick="activateOptions(this.value);"> <label class="large">Change
Sl No. to</label> <select id="newSlNo" name="<%=NEW_SL_NO%>"
	validate="OT,number,no" onchange="checkForAppmtDate()"
	disabled="disabled" />
	<option value="0">Select</option>
	<%
				for (OtBooking otBooking: otBookingList2) {
					if(otBooking.getOt().getId()==otId && otBooking.getSlNo()!=slNo && otBooking.getSlNo()!=0){
			%>
	<option value="<%=otBooking.getSlNo()%>"><%=otBooking.getSlNo()%></option>
	<%
					}
			}
			%>
	<option value="0">Stand By</option>
</select>

<div class="Clear"></div>
<label class="small">&nbsp;</label> <input name="changeCriteria"
	type="radio" id="changeCriteria" value="bookingDate" class="radio"
	onclick="activateOptions(this.value);"> <label class="large">Change
Booking Date to</label> <input type="text" id="newBookingDate"
	name="newBookingDate" value="" MAXLENGTH="30" readonly="readonly"
	disabled="disabled" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	onchange="isApptGrCurrentDate1();"
	onClick="setdate('<%=currentDate %>',document.otListChangeSub.newBookingDate,event);" />
</div>
<div class="Clear"></div>

<!--Block Three Starts--> <!--Bottom labels starts-->
<div class="division"></div>
<div class="bottom"><label>Changed By </label> <label
	class="value"><%=userName %></label> <label>Changed Date </label> <label
	class="value"><%=currentDate %></label> <label>Changed Time </label> <label
	class="value"><%=time%></label>
<div class="Clear"></div>
<div class="Height10"></div>
<input name="Input" type="button" class="button" value="Submit"
	onClick="if(checkForSelection()){submitForm('otListChangeSub','ot?method=updateOTSchedule','isOtGrCurrentDate1');}" />
<input name="Input" type="button" class="button" value="Back"
	onClick="history.back()" /></div>

<div class="Clear"></div>


<!--Bottom labels ends--></form>
</div>
<!--main content placeholder ends here-->
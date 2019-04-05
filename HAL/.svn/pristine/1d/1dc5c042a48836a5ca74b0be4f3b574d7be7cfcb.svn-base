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
<form name="OtListChange" method="post" action="" target="_blank">
<script type="text/javascript" language="javascript">
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
<h2>OT List Change</h2>
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
			 	
			 	String url=null;

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	if(map.get("otBookingList") != null){
					otBookingList = (List)map.get("otBookingList");
				}	 	
			 	System.out.println("message in jsp-- "+map.get("message"));	
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
<div class="Clear"></div>

<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message %></div>
</div>
<%  
		  }		 	
			 %>
<!--Block One Starts-->
<div class="Block">
<label>Booking Date:</label> <input
	type="text" id="bookingDate" name="bookingDate" value="" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16"
	onclick="setdate('<%=currentDate %>',document.OtListChange.bookingDate,event);"
	border="0" validate="Pick a date" class="calender" />
<!--Block one Ends--> <input name="Input" type="button"
	class="button" value="Print"
	onclick="submitForm('OtListChange','ot?method=generateOtListReport');" />
<div class="Clear"></div>

</div>
</form>
</div>
<!--main content placeholder ends here-->
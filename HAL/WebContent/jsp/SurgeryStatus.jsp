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
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />


<!--main content placeholder starts here-->
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />


<div id="contentHolder">
<form name="OtListChange" method="post" action=""><script
	type="text/javascript" language="javascript">
	<%
			String date ="";
			String time = "";
	        Map<String,Object> utilMap = new HashMap<String,Object>();
	        utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	        date = (String)utilMap.get("currentDate");	 
	        time = (String)utilMap.get("currentTime");
	 
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		//String date=String.valueOf(calendar.get(Calendar.DATE));
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
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	bgcolor="#FFFFFF">
	<tr>
		<td width="8%" rowspan="2"><img src="/hms/jsp/images/bafLogo.gif"
			width="81" height="88"></td>
		<td colspan="3" valign="top">
		<table width="802" border="0" align="right" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="3%"><IMG SRC="/hms/jsp/images/userBar_01.gif"
					WIDTH=28 HEIGHT=26 ALT=""></td>
				<td width="45%" background="/hms/jsp/images/userBar_02.gif"
					class="bodytextB"></td>
				<td width="47%" background="/hms/jsp/images/userBar_04.gif">
				<table width="369" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="204" class="bodytext" style="font: bold 22px Vardana;">
						<script type="text/javascript">
								/*
		 						  var currentDate = new Date()
								  var day = currentDate.getDate()
								  var month = currentDate.getMonth()
								  var year = currentDate.getFullYear()
								  document.write(day + "/" + month + "/" + year)	
								*/
			       				function getCalendarDate()
								{
								   var months = new Array(13);
								   months[0]  = "January";
								   months[1]  = "February";
								   months[2]  = "March";
								   months[3]  = "April";
								   months[4]  = "May";
								   months[5]  = "June";
								   months[6]  = "July";
								   months[7]  = "August";
								   months[8]  = "September";
								   months[9]  = "October";
								   months[10] = "November";
								   months[11] = "December";
								   var now         = new Date();
								   var monthnumber = now.getMonth();
								   var monthname   = months[monthnumber];
								   var monthday    = now.getDate();
								   var year        = now.getYear();
								   if(year < 2000) { year = year + 1900; }
								   var dateString = monthname + ' ' + monthday + ', ' + year;
								   return dateString;
								} // function getCalendarDate()								
													
								
									var calendarDate = getCalendarDate();
									
						</script> &nbsp; <%out.print(date);				
									%> : <script type="text/javascript">
							var currentTime = new Date()
							var hours = currentTime.getHours()
							var minutes = currentTime.getMinutes()
						
							if (minutes < 10)
							minutes = "0" + minutes
						
							var suffix = "AM";
							if (hours >= 12) {
							suffix = "PM";
							hours = hours - 12;
							}
							if (hours == 0) {
							hours = 12;
							}
						
							document.write(hours + ":" + minutes + " " + suffix)
						//-->
						</script></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
		<td width="14%"><img src="/hms/jsp/images/hmsLogo.gif"
			width="103" height="53"></td>
	</tr>
</table>


<%
	    int lengthOfMarquee =0;
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Box box=HMSUtil.getBox(request);
			 	List <OtBooking> otBookingList = new ArrayList<OtBooking>();
			 	List <MasOt> masOtList = new ArrayList<MasOt>();
			 	OtBooking otBooking =null;
			 	
			 	String url=null;
                String bookingDate = "";
                String otName = "";
                int nextOt = 0;
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
			 	if(map.get("otBooking")!=null){
			 		otBooking =(OtBooking)map.get("otBooking");
			 	}
			 	
			 	if(map.get("otName") != null){
					otName = (String)map.get("otName");
				}
			 	
			 	if(map.get("nextsize") != null){
			 		nextOt = (Integer)map.get("nextsize");
				}
			 
			 	System.out.println("message in jsp-- "+map.get("message"));	
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%> <%    
					   
					  }		 	
			 %>
<div style="text-align: center;">
<h6 style="font: bold 40px Vardana; padding-left: 170px">CURRENT OT
STATUS</h6>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="Clear"></div>

<!--Block Three Starts--> <!-- <div class="colsHolder">

    <div class="Clear"></div> 
 <div class="tableHolderAutoDisplay"> --> <br />
<br />
<br />
<br />
<br />
<br />
<%if(otBooking !=null) {%> <marquee width='100%' bhaviour=scroll
	direction=left scrolldelay=4 scrollamount="10">
<table height="300" width="150" border="2" cellspacing="3"
	cellpadding="0" bgcolor=#D5DDE6 NOWRAP>
	<tr height="40" style="font: bold 40px Vardana;">

		<!-- <th scope="col">OT Name </th>    
    <th scope="col">Surgeon</th> -->
		<th scope="col">Relation</th>
		<!-- <th scope="col">Service No. </th> -->
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<!-- <th scope="col">Age (Yrs) </th> -->
		<th scope="col">Surgery Status</th>

	</tr>



	<tr height="200" style="font: 120px Vardana;">

		<input name="bookingId" id=<%="bookingId" %> type="hidden"
			value="<%=otBooking.getId()%>" />

		<!-- <td><%=otBooking.getOt().getOtName() %> -->
		<input name="otId" id=<%="otId" %> type="hidden"
			value="<%=otBooking.getOt().getId() %>" />
		<!-- </td> -->



		<td NOWRAP><%=otBooking.getHin().getRelation().getRelationName() %></td>
		<!-- <td><%=otBooking.getHin().getServiceNo() %></td>-->
		<!--<td>
       <%= HMSUtil.convertDateToStringWithoutTime(otBooking.getSurgeryDate())%>
  </td>-->
		<input type="hidden" name="date"
			value="<%=HMSUtil.convertDateToStringWithoutTime(otBooking.getSurgeryDate()) %>" />
		<td NOWRAP><%=otBooking.getHin().getRank().getRankName() %></td>

		<td NOWRAP>
		<% 
    	String fullNamePatient = otBooking.getHin().getSFirstName();
    	if(otBooking.getHin().getPMiddleName() != null){ 
    		fullNamePatient = fullNamePatient + " " + otBooking.getHin().getSMiddleName();
    	}
    	if(otBooking.getHin().getPLastName() != null){
    		fullNamePatient = fullNamePatient + " " + otBooking.getHin().getSLastName();
    	}
    	%> <%=fullNamePatient%></td>
		<!-- <td><%=otBooking.getHin().getAge() %></td>-->

		<td NOWRAP style="color: red;">
		<%String SurgeryStatusString="    ";
         if(otBooking.getSurgeryStatus()!=null){
        	 if(otBooking.getSurgeryStatus().equals("1")){
        		 SurgeryStatusString="PreOperative Care";
        	 }else if(otBooking.getSurgeryStatus().equals("2")){
        		 SurgeryStatusString="Surgery In Progress";
        	 }else if(otBooking.getSurgeryStatus().equals("3")){
        		 SurgeryStatusString="PostOperative Care";
        	 }else if(otBooking.getSurgeryStatus().equals("4")){
        		 SurgeryStatusString="Surgery Cancelled";
        	 }else if(otBooking.getSurgeryStatus().equals("5")){
        		 SurgeryStatusString="Shifted To Ward ";
        	 }
        	 else{
        		 SurgeryStatusString="  ";
        	 }
         }
        	 
  		%> <%=SurgeryStatusString %></td>
	</tr>
	<%                          
							    lengthOfMarquee=(otBooking.getHin().getRelation().getRelationName()).length() + (otBooking.getHin().getRank().getRankName()).length()+ fullNamePatient.length() + SurgeryStatusString.length() ;
							     System.out.println("-------- marqueee-------" + lengthOfMarquee );
	%>
</table>
</marquee> <%}else{
	%>
<h1>No Record Found</h1>
<%} %> <!-- </div>
 </div> --> <input type="hidden" name="lengthOfMarquee"
	id="lengthOfMarquee" value="<%=lengthOfMarquee%>"> <input
	type="hidden" name="nextOt" id="nextOt" value="<%=nextOt%>"></form>
<!-- </div> --> <script>
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
			  if(document.getElementsByName('bookingId').checked == true && document.getElementsByName('bookingId').value!=null)
			  {
					rowSelected=true;
					bookingId = document.getElementsByName('bookingId').value;
					bookingDate = document.getElementsByName('tBookDate').value;
					bookingTime = document.getElementsByName('tBookTime').value;
					otId = document.getElementsByName('otId').value;
					seqId = document.getElementsByName('seqId').value;
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
function statusChange(){
var nextOt;
nextOt = document.getElementById('nextOt').value;
 OtListChange.method="post";	
submitForm('OtListChange','ot?method=showSurgeryStatus&nextOt='+nextOt);
}
</script> <script type="text/javascript">
<% if(otBooking != null){ %>
var lengthOfMarquee= (parseInt(document.getElementById('lengthOfMarquee').value))*500;
	window.setInterval('statusChange()',lengthOfMarquee);
<%}%>	
</script> <!--main content placeholder ends here-->
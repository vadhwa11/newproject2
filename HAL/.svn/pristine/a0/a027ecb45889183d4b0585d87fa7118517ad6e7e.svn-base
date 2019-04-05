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
	function checkForDate()
{
	if(document.getElementById('bookingDate').value==null || document.getElementById('bookingDate').value=="")
	{
		alert("Select OT Date!!");
		return false;
	}
	return true;
}
function orderSeqchange()
	{
	var bookingId;
	var bookingDate;
	//var bookingTime;
	var otId; 
	var seqId;
		
	for(var i = 0; i < document.getElementsByName('bookingId').length; i++)
		{
		 if(document.getElementsByName('bookingId')[i]){
			  if(document.getElementsByName('bookingId')[i].checked == true && document.getElementsByName('bookingId')[i].value!=null)
			  {
					rowSelected=true;
					bookingId = document.getElementsByName('bookingId')[i].value;
					bookingDate = document.getElementsByName('tBookDate')[i].value;
					//bookingTime = document.getElementsByName('tBookTime')[i].value;
					otId = document.getElementsByName('otId')[i].value;
					seqId = document.getElementsByName('seqId')[i].value;
					break;	
		      }
			  else
					rowSelected=false;
			}		
		}
		if(rowSelected==false)
		{
			alert("Select a Record!!");
			return false;
		}else{
		   if(seqId > 1){
		   if(confirm("Please check the BookingDate & BookingTime. !!")){
		     OtListChange.method="post";	
			   submitForm('OtListChange','ot?method=orderSeqchange&bookingId='+bookingId+'&bookingDate='+bookingDate+'&otId='+otId+'&seqId='+seqId);
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
			 	List <MasOt> masOtList = new ArrayList<MasOt>();
			 	List <MasEmployee> masEmpList = new ArrayList<MasEmployee>();
			 	List <OtAnesthesiologist> anesList = new ArrayList<OtAnesthesiologist>();
			 	
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
			 	
			 	if(map.get("masEmpList") != null){
			 		masEmpList = (List)map.get("masEmpList");
				}
			 	
			 	if(map.get("masAnesList") != null){
			 		anesList = (List)map.get("masAnesList");
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
<div class="mesg" style="width: 100%; height: 23px;"><%=message %>
</div>
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
	border="0" validate="Pick a date" class="calender" /> <label
	class="bodytextB"><font id="error">*</font>OT Name:</label> <select
	name="<%="OtName" %>" id="OtName">
	<option value="0">Select</option>
	<%
							for (MasOt masOt : masOtList) {
							if(masOt.getId() == otName)	{
						%>
	<option value="<%=masOt.getId() %>" selected="selected"><%=masOt.getOtName()%></option>
	<%}else { %>
	<option value="<%=masOt.getId() %>"><%=masOt.getOtName()%></option>
	<%}}
					%>
</select> <input name="Print" type="button" value="Load OT Schedule"
	target="_blank" class="button"
	onclick="if(checkForDate()){submitForm('OtListChange','ot?method=getOTSchedule');}">
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
		<th scope="col">Select</th>
		<th scope="col">Sl.No.</th>
		<th scope="col">Surgeon</th>
		<th scope="col">Relation</th>
		<th scope="col">Service No.</th>
		<th scope="col">Booking Date</th>
		<th scope="col"></th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Age (Yrs)</th>
		<th scope="col">Unit</th>
		<th scope="col">Diagnosis</th>
		<th scope="col">Operation</th>
		<th scope="col">Anesthesia</th>
		<th scope="col">Ward</th>
		<th scope="col">OT Name</th>
	</tr>

	<%
  int i = 1;   
     while(itr.hasNext())
           	{
             		OtBooking  otBooking = (OtBooking)itr.next();
   %>

	<tr>
		<td>
		<%if(otBooking.getSlNo()==0){ %> <input name="bookingId"
			id=<%="bookingId"+i %> type="radio" disabled
			value="<%=otBooking.getId()%>" class="radio" /> <% }else{%> <input
			name="bookingId" id=<%="bookingId"+i %> type="radio"
			value="<%=otBooking.getId()%>" class="radio" /> <%} %>
		</td>
		<td>
		<%if(otBooking.getSlNo()==0){ %> Stand By <input name="seqId"
			id=<%="seqId"+i %> type="hidden" value="<%=otBooking.getSlNo() %>" />
		<%}else{%><%=otBooking.getSlNo() %> <input name="seqId"
			id=<%="seqId"+i %> type="hidden" value="<%=otBooking.getSlNo() %>" />
		<%} %>
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
		<td><input type="text" name="tBookDate" id="<%="tBookDate"+ i %>"
			style="width: 75px"
			value="<%= HMSUtil.convertDateToStringWithoutTime(otBooking.getSurgeryDate())%>">
		</td>
		<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date" class="calender"
			onClick="setdate('<%=currentDate%>',document.getElementById('<%="tBookDate"+i%>'),event);" />
		</td>

		<input type="hidden" name="date"
			value="<%=HMSUtil.convertDateToStringWithoutTime(otBooking.getSurgeryDate()) %>" />
		<td><%=otBooking.getHin().getRank().getRankName() %></td>
		<td>
		<% 
    	String fullNamePatient = otBooking.getHin().getPFirstName();
    	if(otBooking.getHin().getPMiddleName() != null){ 
    		fullNamePatient = fullNamePatient + " " + otBooking.getHin().getPMiddleName();
    	}
    	if(otBooking.getHin().getPLastName() != null){
    		fullNamePatient = fullNamePatient + " " + otBooking.getHin().getPLastName();
    	}
    	%> <%=fullNamePatient%></td>
		<td><%=otBooking.getHin().getAge() %></td>
		<% if(otBooking.getHin().getUnit() != null && !otBooking.getHin().getUnit().getUnitName().equals("") ){%>
		<td><%=otBooking.getHin().getUnit().getUnitName() %></td>
		<% }else{ %>
		<td>-</td>
		<% } %>
		<%if(otBooking.getInpatient()!=null ){%>
		<td><%=otBooking.getInpatient().getInitDiagnosis() %></td>
		<%}else{%>
		<td>-</td>
		<%}%>
		<% if(otBooking.getChargeCode() != null && !otBooking.getChargeCode().getChargeCodeName().equals("")){ %>
		<td><%=otBooking.getChargeCode().getChargeCodeName() %></td>
		<% }else{ %>
		<td>-</td>
		<% } %>

		<td>-</td>
		<% if(otBooking.getInpatient() != null ){ %>
		<td><%=otBooking.getInpatient().getAdWardId().getDepartmentName() %></td>
		<% }else {%>
		<td>-</td>
		<% } %>

		<td><select name="otId" id="otId" style="width: 120px">
			<option value="0">Select</option>
			<%
							for (MasOt masOt : masOtList) {
							if(masOt.getId() == otBooking.getOt().getId() )	{
						%>
			<option value="<%=masOt.getId() %>" selected="selected"><%=masOt.getOtName()%></option>
			<%}else { %>
			<option value="<%=masOt.getId() %>"><%=masOt.getOtName()%></option>
			<%}}
					%>
		</select></td>

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
	type="button" class="cmnButton" value="Update OT Name"
	onclick="otModifications(this.value)" /> <input name="Input"
	type="button" class="cmnButton" value="Stand By"
	onclick="otModifications(this.value)" /> <input name="Input"
	type="button" class="cmnButton" value="Cancel Booking"
	onclick="submitForm('OtListChange','ot?method=cancelOTSchedule','checkForSelection');" />
<input name="Input" type="button" class="cmnButton" value="Move Up"
	onclick="orderSeqchange();" /> <input name="Input" type="button"
	class="cmnButton" value="Print" onclick="printOtListReport();" /> <%} %>
<div class="Clear"></div>
</div>
<div class="division"></div>
<div class="Clear"></div>
<div class="Clear"></div>

<%if(otBookingList!=null && otBookingList.size()>0){%>
<h5>Duties of Anaesthesiologist</h5>
<div class="colsHolder">
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">OT Name</th>
		<th scope="col">Anaesthesiologist I</th>
		<th scope="col">Anaesthesiologist II</th>
	</tr>
	<%  for (MasOt masOt : masOtList) {
   
    %>
	<tr>
		<td><%=masOt.getOtName()%> <input type="hidden" name="otanesId"
			id="otanesId" value="<%=masOt.getId() %>" /></td>
		<td><select name="anesI" id="anesI" style="width: 140px">
			<option value="0">Select Anaesthesiologist</option>
			<%
						
						int anes1 = 0;
						for(OtAnesthesiologist otAnes:anesList){
							if(otAnes.getOt()!=null){
							if(otAnes.getOt().getId() == masOt.getId()){
								if(otAnes.getAnes1Id() != null){
									 anes1 = otAnes.getAnes1Id().getId();		
								}
							}
						 }	
						}
						
						
						for (MasEmployee masEmp : masEmpList) { 
							String empName = "";
							if(masEmp.getFirstName() != null){
								empName = empName + masEmp.getFirstName()+" ";
							}
							if(masEmp.getMiddleName() != null){
								empName = empName + masEmp.getMiddleName()+" ";
							}
							if(masEmp.getLastName() != null){
								empName = empName + masEmp.getLastName();
							}
							
							if(anes1 == masEmp.getId()) {
								%>
			<option value="<%=masEmp.getId()%>" selected="selected"><%=empName%></option>
			<%}else {%>
			<option value="<%=masEmp.getId() %>"><%=empName%></option>
			<%}}
					%>
		</select></td>
		<td><select name="anesII" id="anesII" style="width: 140px">
			<option value="0">Select Anaesthesiologist</option>
			<%
						int anes2 = 0;
						for(OtAnesthesiologist otAnes:anesList){
						  if(otAnes.getOt()!=null){
							if(otAnes.getOt().getId() == masOt.getId()){
								if(otAnes.getAnes2Id() != null){
									anes2 = otAnes.getAnes2Id().getId();		
								}
							  }
						    }
						  }
							for (MasEmployee masEmp : masEmpList) { 
							String empName = "";
							
							if(masEmp.getFirstName() != null){
								empName = empName + masEmp.getFirstName()+" ";
							}
							if(masEmp.getMiddleName() != null){
								empName = empName + masEmp.getMiddleName()+" ";
							}
							if(masEmp.getLastName() != null){
								empName = empName + masEmp.getLastName();
							}
						
								if(anes2 == masEmp.getId()) {
								%>
			<option value="<%=masEmp.getId()%>" selected="selected"><%=empName%></option>
			<%}else {%>
			<option value="<%=masEmp.getId() %>"><%=empName%></option>
			<%}}
					%>
		</select></td>
	</tr>
	<%} %>
</table>
</div>
</div>

<div class="Clear"></div>
<table
	style="border: 1px solid #E1E1E1; margin-bottom: 10px height : auto; width: 100%">
	<tr>
		<td
			style="border-right: 1px solid #DAD6D6; border-bottom: 1px dashed #EEECEC; font: normal 11px Tahoma; color: #000000; text-align: center;"
			width="260px">PAC</td>
		<td
			style="border-right: 1px solid #DAD6D6; height: 20px; margin: 3px 0px 3px 0px; padding-left: 95px; width: 235px; vertical-align: middle;">
		<select name="panesI" id="panesI" style="width: 140px;">
			<option value="0">Select Anaesthesiologist</option>
			<%
						
						int anes1 = 0;
						for(OtAnesthesiologist otAnes:anesList){
							if(otAnes.getPac()!= null && otAnes.getPac().equals("P")){
								if(otAnes.getAnes1Id() != null){
									anes1 = otAnes.getAnes1Id().getId();		
								}
							}
						}
							for (MasEmployee masEmp : masEmpList) { 
							String empName = "";
							if(masEmp.getFirstName() != null){
								empName = empName + masEmp.getFirstName()+" ";
							}
							if(masEmp.getMiddleName() != null){
								empName = empName + masEmp.getMiddleName()+" ";
							}
							if(masEmp.getLastName() != null){
								empName = empName + masEmp.getLastName();
							}
							
							
							if(anes1 == masEmp.getId()) {
								%>
			<option value="<%=masEmp.getId()%>" selected="selected"><%=empName%></option>
			<%}else {%>
			<option value="<%=masEmp.getId() %>"><%=empName%></option>
			<%}}
					%>
		</select></td>
		<td
			style="border-right: 1px solid #DAD6D6; height: 20px; margin: 3px 0px 3px 0px; dashed #EEECEC; padding-left: 95px;">
		<select name="panesII" id="panesII" style="width: 140px">
			<option value="0">Select Anaesthesiologist</option>
			<%
						
						int anes2 = 0;
						for(OtAnesthesiologist otAnes:anesList){
							if(otAnes.getPac()!= null && otAnes.getPac().equals("P")){
								if(otAnes.getAnes2Id() != null){
									anes2 = otAnes.getAnes2Id().getId();		
								}
							 
							}
						}
							for (MasEmployee masEmp : masEmpList) { 
							String empName = "";
							if(masEmp.getFirstName() != null){
								empName = empName + masEmp.getFirstName()+" ";
							}
							if(masEmp.getMiddleName() != null){
								empName = empName + masEmp.getMiddleName()+" ";
							}
							if(masEmp.getLastName() != null){
								empName = empName + masEmp.getLastName();
							}
							
							if(anes2 == masEmp.getId()) {
								%>
			<option value="<%=masEmp.getId()%>" selected="selected"><%=empName%></option>
			<%}else {%>
			<option value="<%=masEmp.getId() %>"><%=empName%></option>
			<%}}
					%>
		</select></td>
	</tr>
</table>

<div class="Clear"></div>
<input name="Input" type="button" class="cmnButton" value="Submit"
	onclick="checkAnesth();" />
<div class="Clear"></div>

<% }%>
</form>
</div>

<script>
function checkAnesth(){
var test = true;
if (OtListChange.anesI.length)
			{
				 for(var i = 0; i < OtListChange.anesI.length; i++)
			 	 {
       		  	  if (OtListChange.anesI[i].value != "0"){
			  	   test=false;
				  }
				 }
			}	  	 
if (OtListChange.anesII.length)
			{
				 for(var i = 0; i < OtListChange.anesII.length; i++)
			 	 {
			  	  if (OtListChange.anesII[i].value != "0"){
				  	 test=false;
			  	  }
			     }
			}	  	 
if (document.getElementById('panesI').value != "0"){
  test=false;
}	  	 
if (document.getElementById('panesII').value != "0"){
  test=false;
}	  	 

if(test){
alert("Please select Anesthesiologist!!");
}else{
submitForm('OtListChange','ot?method=submitAnesthesiologist');
}

}
function printOtListReport(){
	checkTargetForYes();
	submitForm('OtListChange','ot?method=generateOtListReport');
	checkTargetForNo();
}
function otModifications(data){
	var bookingId;
	var bookingDate;
	//var bookingTime;
	var otId; 
	var seqId;
	var Criteria;
	if(data == "Update OT Name"){
	Criteria = "OtName";
	}
	if(data == "Stand By"){
	Criteria = "StandBy";
	}
	
for(var i = 0; i < document.getElementsByName('bookingId').length; i++)
		{
			  if(document.getElementsByName('bookingId')[i]){
			  if(document.getElementsByName('bookingId')[i].checked == true && document.getElementsByName('bookingId')[i].value!=null)
			  {
					rowSelected=true;
					bookingId = document.getElementsByName('bookingId')[i].value;
					bookingDate = document.getElementsByName('tBookDate')[i].value;
				//	bookingTime = document.getElementsByName('tBookTime')[i].value;
					otId = document.getElementsByName('otId')[i].value;
					seqId = document.getElementsByName('seqId')[i].value;
					break;	
		      }
			  else
					rowSelected=false;
			}		
		}
		if(rowSelected==false)
		{
			alert("Select a Record!!");
			return false;
		}else{
		   if(seqId > 0){
	      
		   if(confirm("are you sure ? you want to update the changes. !!")){
		     OtListChange.method="post";	
			 //submitForm('OtListChange','ot?method=changeOTSchedule','checkForSelection');
			  submitForm('OtListChange','ot?method=updateOTChanges&bookingId='+bookingId+'&bookingDate='+bookingDate+'&otId='+otId+'&seqId='+seqId+'&changeCriteria='+Criteria);
		   } else { 
			return false;
		}
		}
		}
}

</script>
<!--main content placeholder ends here-->
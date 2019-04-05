<%@page import="jkt.hms.masters.business.TherapyDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script>
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
	</script>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTimeWithoutSc");
		String diagnosis = "";
		String firstName="";
		String middleName = "";
		String lastName = "";
 		String userName = "";
 		String age="-";
 		String Gendre="";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		
		String depName="";
		if(session.getAttribute("deptName")!=null){
			depName=(String)session.getAttribute("deptName");	
		}
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
		List<TherapyDetails>procedurelist =new ArrayList<TherapyDetails>();
		List<Object[]>procedurelistObject =new ArrayList<Object[]>();
		if(map.get("pendingProcList") != null){
			procedurelist =(List<TherapyDetails>)map.get("pendingProcList");
		}
		System.out.println("dfd "+procedurelist.size());
		if(map.get("procedurelist") != null){
			procedurelistObject =(List<Object[]>)map.get("procedurelist");
		} 
		
		List<Visit> visitList = new ArrayList<Visit>();
		if(map.get("visitList") != null){
			visitList= (List<Visit>)map.get("visitList");
		}
		String departmentCodeForPhychiatrist = HMSUtil.getProperties("adt.properties", "departmentCodeForPhychiatrist");
		String dentalDepartmentCode = HMSUtil.getProperties("adt.properties", "departmentCodeForDental");
	%>
	<h4><%=message %></h4>
	<div class="clear"></div>
	<div class="titleBg">
	<%
	String name="";
	  if(visitList.size()>0)
	  {
		  if(departmentCodeForPhychiatrist.equalsIgnoreCase(visitList.get(0).getDepartment().getDepartmentCode()))
				 name="Therapy";
		  else if(dentalDepartmentCode.equalsIgnoreCase(visitList.get(0).getDepartment().getDepartmentCode()))
			  name="Dental Procedure";
				  
	  }
	%>
	<h2> <%=name%> Details</h2></div>
	<div class="clear"></div>
	
<form name="injectionAdministration" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
//if(injectionList.size() > 0){
%>

<%//}
if(visitList.size()>0){ %>
<input type="hidden" name="appointmentHeaderId" value="@@@"/>
<%} %>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%-- <label>Service No.</label>
<label class="value"><%=prescriptionHeader.getHin().getServiceNo()!=null?prescriptionHeader.getHin().getServiceNo() :"" %></label> --%>

<%
Set<Integer> icdTemp = new HashSet<Integer>();
for(Visit visitObj : visitList){
if(visitObj.getHin()!=null){ %>
<input type="hidden" name="hinId" value="<%=visitObj.getHin().getId() %>" id="hinId"/>

<%}if(visitObj !=null){ %>
<input type="hidden" name="visitId" value="<%=visitObj.getId() %>" id="visitId"/>
<%} %>

<%

if(visitObj.getHin()!=null){
	if(visitObj.getHin().getPFirstName() != null){
		firstName= visitObj.getHin().getPFirstName();
	}	
	
if(visitObj.getHin().getPMiddleName() != null){
	middleName = visitObj.getHin().getPMiddleName();
}
if(visitObj.getHin().getPLastName() != null){
	lastName = visitObj.getHin().getPLastName();
}

if(visitObj.getHin().getAge() != null){
	age= visitObj.getHin().getAge();
}	

if(visitObj.getHin().getSex() != null){
	Gendre= visitObj.getHin().getSex().getAdministrativeSexName();
}	

Set<OpdPatientDetails> patientDetails = new HashSet<OpdPatientDetails>();
Set<DischargeIcdCode> icdSet = new HashSet<DischargeIcdCode>();

	if(visitObj!=null){
		if(visitObj.getDischargeIcdCodes()!= null){
			icdSet = visitObj.getDischargeIcdCodes();
		}
		if(visitObj.getOpdPatientDetails()!= null){
			patientDetails = visitObj.getOpdPatientDetails();
			for(OpdPatientDetails opdPatientDetails : patientDetails){
			      Visit visit=  opdPatientDetails.getVisit();
	    			Set<DischargeIcdCode> dischageIcdSet = new HashSet<DischargeIcdCode>();
	    			dischageIcdSet = visit.getDischargeIcdCodes();
	    			 int count =0;
					for(DischargeIcdCode orderdt : dischageIcdSet){
	       				if(count++>=1)
	       					diagnosis = diagnosis.concat(", ");
	       				diagnosis = diagnosis.concat(orderdt.getIcd().getIcdName());
	       			} 
			}
		}
		
	}
%>

<%} %>
<%} %>
<label>Patient Name</label> 
<label class="value"><%=firstName+" "+middleName+" "+lastName %></label>

<label> Age</label> 
<label class="value"><%=age%></label>


<label> Gender</label> 
<label class="value"><%=Gendre%></label>

<div class="Clear"></div>

<label> Diagnosis</label> 
<label class="valueAuto" style="width:471px"><%=diagnosis %></label>
<div class="clear"></div>
</div>
<div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div>
<div class="Block">
<h4><%=name%> Details</h4>

<%  if(visitList.size()>0)
{
	  if(dentalDepartmentCode.equalsIgnoreCase(visitList.get(0).getDepartment().getDepartmentCode()))
	  {
%>		
  <input name="investigationTemplate" value="Dental Procedure Calendar"onclick="openWindow('/hms/hms/opd?method=showProcedureCalenderDoctorWise&opdFlag=y&dentalFalg=y')" tabindex="1" class="buttonBig" type="button">  
<%	  }
	  else if(departmentCodeForPhychiatrist.equalsIgnoreCase(visitList.get(0).getDepartment().getDepartmentCode()))
		  {
%>		  
     <input name="investigationTemplate" value="Procedure Calendar"onclick="openWindow('/hms/hms/opd?method=showProcedureCalenderDoctorWise&opdFlag=y&psyFlag=y')" tabindex="1" class="buttonBig" type="button">
<%		  }
			  
} %>

<%  //out.print("procedurelist="+procedurelist.size()); %>
<%int i=1; 
if(procedurelist.size() > 0){


%>
<div class="Clear"></div>

<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="procedure">
	<tr>
		<!-- <th scope="col"></th> -->
		<th scope="col"><%=name%> Name</th>
		<%-- <th scope="col"><%=name%> Start Date</th>	 --%>	
		<th>Session Counter</th>
		<th scope="col">Appointment Date/Time</th>	
		<th>Previous Session</th>
		<!-- <th scope="col">OP Remarks</th> -->
		<th scope="col">Remarks</th>
		<th scope="col">Next Appointment/Close</th>
		<th scope="col">Action</th>
	</tr>
		<%	
		boolean completed = false;
		int sessionCounter =0;
		for(TherapyDetails procedureDetails : procedurelist){
			
			if(procedureDetails.getStatus().equalsIgnoreCase("n")){
			if(procedureDetails.getFinalProcedureStatus().trim().equalsIgnoreCase("y"))
				completed = true;
			else
				completed = false;
			
			sessionCounter = 0;
			for(TherapyDetails procedureDetails1 : procedurelist)
			{
				if(procedureDetails1.getProcedure().getId()==procedureDetails.getProcedure().getId())
				  sessionCounter ++; 
			}
	
		%>
		<tr>
			<td><input type="text" class="nomeclatureOpdgridText" disabled="disabled" readonly="readonly" name="procedureName<%=i %>" id="procedureName<%=i %>" value="<%=procedureDetails.getProcedure().getNursingName()%>" /></td>	
			<td><input type="text" size="16" class="small" readonly="readonly" value="<%=sessionCounter%>" size="5"/></td>
			<td><input type="text" size="19" class="small" readonly="readonly" value="<%= procedureDetails.getAppointmentDate()!=null?HMSUtil.convertDateToStringWithoutTime(procedureDetails.getAppointmentDate()) :""%>(<%= procedureDetails.getAppointmentTime()!=null?procedureDetails.getAppointmentTime() :""%>)" size="5"/>
			<input type="hidden" name="currentAppointDate<%=i %>" id ="currentAppointDate<%=i %>" value="<%= procedureDetails.getAppointmentDate()!=null?HMSUtil.convertDateToStringWithoutTime(procedureDetails.getAppointmentDate()) :""%>"/>
			</td>
			
			<%-- <td><input type="text" class="small" readonly="readonly" value="<%= procedureDetails.getFrequency()!=null?procedureDetails.getFrequency().getFrequencyName():"" %>" size="5"/></td>
			<td><input type="text" class="small" readonly="readonly"  id="noOfDays<%=i %>" value="<%= procedureDetails.getNoOfDays()!=null?procedureDetails.getNoOfDays():"" %>" size="5"/></td>
			 --%>
			 <td><input type="button"  id="issue" name="issue" value="History" class="button" onclick="openWindow('/hms/hms/opd?method=getTherapyHistory&therapuHdId=<%=procedureDetails.getProcedureHeader().getId()%>&procedureId=<%=procedureDetails.getProcedure().getId()%>')" /></td>
			 
		<%-- 	 <td>
			 <textarea size="20" class="large" style="width: 250px; height: 50px;" maxlength="300" disabled="disabled"><%=procedureDetails.getOpdRemarks()!=null?procedureDetails.getOpdRemarks():""%></textarea></td>
			 --%> 
			<%-- <td><input type="text" class="small" name="status<%=procedureDetails.getId()%>" id="status<%=procedureDetails.getId()%>" readonly="readonly" value="<%=procedureDetails.getFinalProcedureStatus().trim().equalsIgnoreCase("y")?"Completed":"Not Completed"%>" class="small" size="13"/></td> --%>
			<%-- <td><input type="button" class="button" readonly="readonly" name="save<%=procedureDetails.getId()%>" id="save<%=procedureDetails.getId()%>" value="View and Submit"  onclick="openPopupForProcedure('<% out.print(i); %>@@@<%=procedureDetails.getId()%>@@@<%=procedureDetails.getFrequency().getFeq()%>@@@<%=procedureDetails.getFrequency().getFrequencyName()%>@@@<%=procedureDetails.getProcedureHeader().getId()%>@@@<%=procedureDetails.getFrequency().getId()%>@@@<%=procedureDetails.getNursingCare().getId()%>')" size="20"/></td> --%>
			<td>
			<%if(!completed){ %>
			<input type="hidden" name="therapyDtId<%=i%>" id="therapyDtId<%=i%>" value="<%=procedureDetails.getId()%>"/>
		
			<textarea size="20" class="large" id="therapyRemarks<%=i%>" name="therapyRemarks<%=i%>" validate="Remarks,string,no" value="" tabindex="1" style="width: 250px; height: 50px;" maxlength="1000"></textarea></td>
				<%} %>
			<td>
			<div style="width:270px;">
			<%if(!completed){ %>
			<div style="width:130px; float:left;"><input type="radio" name="close<%=i%>" id="appoint<%=i%>" value="a" style="margin:-3px 5px 0px 0px;" checked="checked">Next Appointment</div>
			<div style="width:110px; float:left;"><input type="radio" name="close<%=i%>" id="close<%=i%>"value="c" style="margin:-3px 5px 0px 0px;" onclick="clearAppointment(<%=i%>);">Close</div>
			
			
			<div class="Clear"></div>
			<div class="paddingTop5"></div>			
			<div style="width:110px; padding-top: 6px; float:left;">Appointment Date</div>
			<input type="text" name="nextAppointment<%=i%>"
			readonly="readonly" id="nextAppointment<%=i%>" value="" />
			<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.getElementById('nextAppointment<%=i%>'),event);" />
						
			<div class="Clear"></div>
			<div class="paddingTop5"></div>
			<div style="width:110px; padding-top: 6px; float:left;">Appointment Time</div>
			<input type="text" name="appointmentTime<%=i%>" id="appointmentTime<%=i%>" onblur="IsValidTime(this.value,this.id)" onkeyup="mask(this.value,this,'2',':');" maxlength="5"/>
			 <%} %>
			 </div>
			 </td>
			<td>  
			
			<%if(!completed){ %>
			<input type="button" class="button"  value="Submit" onclick="validateTherapyRemarks(<%=i%>);"/>
			<%} else{%>Completed<%} %></td>
		</tr>
		<%
			
		i++;
				}
			}%>
		
</table>
</div>


<%}else{%>
<h2><span>Record Not Found!</span></h2>
<%} %>

<div class="Clear"></div><div class="Clear"></div><div class="Clear"></div>
<div class="Clear"></div><div class="Clear"></div>

<div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div>

<div class="Clear"></div>
<div class="division"></div>
<div class="bottom">
<div class="Clear"></div>

</div>
</form>
<script>
	function validateTherapyRemarks(i)
	{
		
		var parts = document.getElementById("currentAppointDate"+i).value.split('/');
		var parts1 = document.getElementById("nextAppointment"+i).value.split('/');
	
	
		
		var currentAppointDate = new Date(parts[1]+"/"+parts[0]+"/"+parts[2]); 
		var nextAppointmentDate = new Date(parts1[1]+"/"+parts1[0]+"/"+parts1[2]); 
		
		
		var therapyDtId=document.getElementById("therapyDtId"+i).value;
		var therapyRemarks=document.getElementById("therapyRemarks"+i).value;
		var nextAppointment = document.getElementById("nextAppointment"+i).value;
		var nextAppointTime = document.getElementById("appointmentTime"+i).value; 
		console.log("i"+i +" "+therapyDtId);
		 
		 if(therapyRemarks=="")
			{
			alert("Please Enter Remarks");
			return false;
			}
		 
		 if (document.getElementById("appoint"+i).checked) {
				var currentDate = new Date();
				
			 if(nextAppointment=="")
				{
				alert("Please enter next appointment Date");
				return false;
				}
			 else if(nextAppointmentDate.getTime() < currentAppointDate.getTime())
				 {
				 alert("Next appointment should be greater than current appointment date");
				 return false;
				 }
			 
			 if(nextAppointTime=="")
				{
				alert("Please Enter next appointment time");
				return false;
				}
			 
			}
		new Ajax.Request(
				'opd?method=saveTherapyAppointmentDetails&therapyDtId='+therapyDtId+'&therapyRemarks='+therapyRemarks+'&nextAppointment='+nextAppointment+'&nextAppointTime='+nextAppointTime,
				{
					onSuccess : function(response) {
						if (response.responseText.trim() != '') {
							if(response.responseText=="y")
							   alert("saved successfully"); 
							else if(response.responseText=="d")
								   alert("Details have already been saved"); 
							else
								alert("An error has occurred.");
							
					     document.getElementById("therapyRemarks"+i).value= this.response.responseText
							.trim();
							
						}
					}
				});
	}

	function openWindow(url){

	    newwindow=window.open(url,'name',"left=2,top=100,height=750,width=1000,status=1,scrollbars=1,resizable=0");
		
	}
	
	function clearAppointment(i)
	{
		document.getElementById("nextAppointment"+i).value="";
		document.getElementById("appointmentTime"+i).value=""; 
	}
</script>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasServiceType"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.ProcedureHeader"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>

<%@page import="jkt.hms.masters.business.InjectionRegister"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>

<%@page import="jkt.hms.masters.business.InjAppointmentHeader"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"language="javascript">
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
		
	function datevalidation(){
	
	
	var fdate = document.getElementById('FromDateId');
	var tdate = document.getElementById('ToDateId');
	
	frdate  = new Date(fdate.value.substring(6),(fdate.value.substring(3,5) - 1) ,fdate.value.substring(0,2));
	todate  = new Date(tdate.value.substring(6),(tdate.value.substring(3,5) - 1) ,tdate.value.substring(0,2));
	
	
	if(fdate.value != "" && todate.value != ""){
	 if(frdate > todate){
	  alert("To Date should be greater than or equal to the From Date.");
	   return false;
	  }
	}else{
	 return false;
	}
	return true;	
		
		}
		
	
	</script>
	<%
	Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	if(map.get("doctorList") != null){
		doctorList= (List<MasEmployee>)map.get("doctorList");
	}
/*	List<PatientPrescriptionHeader> pendingInjectionList = new ArrayList<PatientPrescriptionHeader>();
	if(map.get("pendingInjectionList") != null){
		pendingInjectionList= (List<PatientPrescriptionHeader>)map.get("pendingInjectionList");
	}*/
	List<InjAppointmentHeader> pendingInjectionAppList = new ArrayList<InjAppointmentHeader>();
	if(map.get("pendingInjectionAppList") != null){
		pendingInjectionAppList= (List<InjAppointmentHeader>)map.get("pendingInjectionAppList");
	}
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	Box box= HMSUtil.getBox(request);
	%>

<form name="injectionWaitList" method="post" action="">
	<h4><%=message %></h4>
<div class="Clear"></div>
<div class="titleBg"><h2>Injection Register</h2></div>

<div class="Clear"></div>
<div class="Block">
<div class="Clear"></div>
<label> From Date <span>*</span></label>
<input type="text" id="FromDateId" name="<%=FROM_DATE %>" value="<%=(!box.getString(FROM_DATE).equals("") ? box.getString(FROM_DATE) : currentDate) %>" class="calDate" readonly="readonly"MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate%>',document.injectionWaitList.<%=FROM_DATE%>,event)" />

<label>To Date <span>*</span></label>
 <input type="text" id="ToDateId"name="<%=TO_DATE %>" value="<%=(!box.getString(TO_DATE).equals("") ? box.getString(TO_DATE) : currentDate) %>" class="calDate"	readonly="readonly" MAXLENGTH="30" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.injectionWaitList.<%=TO_DATE%>,event)" />
	
<label>Service No. </label>
<input type="text" name="<%=SERVICE_NO %>" id="serviceNo" value="<%=(!box.getString(SERVICE_NO).equals("") ? box.getString(SERVICE_NO) : "") %>" validate="Service No.,metachar,no" /> 
<div class="Clear"></div>
<label> Medical Officer</label> 
<select name="<%=MEDICAL_OFFICER %>" validate="Medical Officer,string,no">
	<option value="0">Select</option>
	<% 
			for(MasEmployee employee : doctorList)
			{
				String doctorName = employee.getRank().getRankName()+" "+employee.getFirstName();
				if(employee.getMiddleName()!= null){
					doctorName += " "+employee.getMiddleName();
				}
				if(employee.getLastName()!= null){
					doctorName += " "+employee.getLastName();
				}
			%>
	<option value="<%=employee.getId()%>" <%=HMSUtil.isSelected(employee.getId(),Integer.valueOf(box.getInt(MEDICAL_OFFICER)))%>><%=doctorName %></option>
	<%
			}
			%>
</select>

<div class="Clear"></div>	
</div>
<div class="Clear"></div>
<input type="button" name="search" value="Search" class="button"
	onClick="if(datevalidation()){submitForm('injectionWaitList','/hms/hms/registration?method=getPendingInjectionList');}" />

<div class="Clear"></div>

<div class="division"></div>
<%
//	if(pendingInjectionList.size() > 0 || pendingInjectionAppList.size() > 0){
	if(pendingInjectionAppList.size() > 0){
%>
<h4>Waiting List</h4>
<div id="reg">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Date</th>
		<th scope="col">Service No.</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Relation</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Age</th>
		<th scope="col">Medical Officer</th>
	</tr>
	<%--
	if(pendingInjectionList.size() > 0){
		for(PatientPrescriptionHeader prescriptionHeader : pendingInjectionList){
	%>
	<tr onclick="submitForm('injectionWaitList','/hms/hms/registration?method=getInjectionDetails&prescriptionHeaderId=<%=prescriptionHeader.getId() %>');">
	<td><%=HMSUtil.convertDateToStringWithoutTime(prescriptionHeader.getPrescriptionDate()) %></td>
	<td><%=prescriptionHeader.getHin().getServiceNo() %></td>
	<%
	String middleName = "";
	String lastName = "";
	if(prescriptionHeader.getHin().getPMiddleName() != null){
		middleName = prescriptionHeader.getHin().getPMiddleName();
	}
	if(prescriptionHeader.getHin().getPLastName() != null){
		lastName = prescriptionHeader.getHin().getPLastName();
	}

	%>
	<td><%=prescriptionHeader.getHin().getPFirstName()+" "+middleName+" "+lastName %></td>
	<td><%=prescriptionHeader.getHin().getRelation().getRelationName() %></td>
	<td><%=prescriptionHeader.getHin().getRank().getRankName() %></td>
	<%
	String sMiddleName = "";
	String sLastName = "";

	if(prescriptionHeader.getHin().getSMiddleName() != null){
		sMiddleName = prescriptionHeader.getHin().getSMiddleName();
	}
	if(prescriptionHeader.getHin().getSLastName() != null){
		sLastName = prescriptionHeader.getHin().getSLastName();
	}
%>
	<td><%=prescriptionHeader.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName %></td>
	<td><%=prescriptionHeader.getHin().getAge() %></td>
	<%
	String moName = prescriptionHeader.getEmp().getFirstName();
	if(prescriptionHeader.getEmp().getMiddleName()!= null){
		moName += " "+prescriptionHeader.getEmp().getMiddleName();
	}
	if(prescriptionHeader.getEmp().getLastName()!= null){
		moName += " "+prescriptionHeader.getEmp().getLastName();
	}
	%>
	<td><%=moName %></td>
	</tr>
	
	<%}
		}--%>
		<%if(pendingInjectionAppList.size() > 0){
			for(InjAppointmentHeader injAppointmentHeader : pendingInjectionAppList){
				String bgcolor = "";
				System.out.println("prio--"+injAppointmentHeader.getVisit().getPriority());
				if(injAppointmentHeader.getVisit().getPriority()==1){
					bgcolor="#B40404";
				}
				else if(injAppointmentHeader.getVisit().getPriority()==2){
					bgcolor="#FFFF00";
				}
				else if(injAppointmentHeader.getVisit().getPriority()==3){
					bgcolor="#A0E0AA";
				}
				PatientPrescriptionHeader prescriptionHeader = injAppointmentHeader.getPrescription();
		%>
			<tr onclick="getDetails('<%=injAppointmentHeader.getId() %>');">
	<td style="background:<%=bgcolor %>;"><%=HMSUtil.convertDateToStringWithoutTime(injAppointmentHeader.getAppointmentDate()) %></td>
	<td style="background:<%=bgcolor %>;"><%=prescriptionHeader.getHin().getServiceNo() !=null?prescriptionHeader.getHin().getServiceNo():""%></td>
	<%
	String middleName = "";
	String lastName = "";
	if(prescriptionHeader.getHin().getPMiddleName() != null){
		middleName = prescriptionHeader.getHin().getPMiddleName();
	}
	if(prescriptionHeader.getHin().getPLastName() != null){
		lastName = prescriptionHeader.getHin().getPLastName();
	}

	%>
	<td style="background:<%=bgcolor %>;"><%=prescriptionHeader.getHin().getPFirstName()+" "+middleName+" "+lastName %></td>
	<td style="background:<%=bgcolor %>;"><%=prescriptionHeader.getHin().getRelation().getRelationName() %></td>
	<td style="background:<%=bgcolor %>;"><%=prescriptionHeader.getHin().getRank().getRankName() %></td>
	<%
	String sMiddleName = "";
	String sLastName = "";

	if(prescriptionHeader.getHin().getSMiddleName() != null){
		sMiddleName = prescriptionHeader.getHin().getSMiddleName();
	}
	if(prescriptionHeader.getHin().getSLastName() != null){
		sLastName = prescriptionHeader.getHin().getSLastName();
	}
%>
	<td style="background:<%=bgcolor %>;"><%=prescriptionHeader.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName %></td>
	<td style="background:<%=bgcolor %>;"><%=prescriptionHeader.getHin().getAge() %></td>
	<%
	String moName = prescriptionHeader.getEmp().getFirstName();
	if(prescriptionHeader.getEmp().getMiddleName()!= null){
		moName += " "+prescriptionHeader.getEmp().getMiddleName();
	}
	if(prescriptionHeader.getEmp().getLastName()!= null){
		moName += " "+prescriptionHeader.getEmp().getLastName();
	}
	%>
	<td style="background:<%=bgcolor %>;"><%=moName %></td>
	</tr>
		
		<%}
			}%>
	</table>
	<div class="Clear"></div>	
	
<input type="text" class="signPriority1" readonly="readonly">
<label class="valueAutoPriority">Priority-1</label>
<input type="text" class="signPriority2" readonly="readonly">
<label class="valueAutoPriority">Priority-2</label>
<input type="text" class="signPriority3" readonly="readonly">
<label class="valueAutoPriority">Priority-3</label>
<div class="Clear"></div>
</div>
<%}else{ %>
<h4>No Record Found</h4>
<%} %>
</form>
<script>
function getDetails(appointmentId){

	if(validateMetaCharacters(appointmentId)){
		submitForm('injectionWaitList','/hms/hms/registration?method=getInjectionDetails&appointmentId='+appointmentId);
	}
}
</script>
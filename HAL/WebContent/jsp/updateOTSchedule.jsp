<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/opd.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript">
 
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String getDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(getDate.length()<2){
			getDate="0"+getDate;
		}

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>
<%

	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	int surgeryId1=0;
	if(map.get("surgeryId")!=null)
	{
		surgeryId1=(Integer)map.get("surgeryId");
	}
		String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<OtBooking>otBookingList=new ArrayList<OtBooking>();
	/* List<OtMasUnitDay>  masUnitDays=new ArrayList<OtMasUnitDay>();
	List<HospitalDoctorUnitM> doctorUnit=new ArrayList<HospitalDoctorUnitM>(); */
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");

	 List opdSurgeryList = new ArrayList();
	 List <OtBookSurgeon>surgeonList = new ArrayList<OtBookSurgeon>();
	 
	 //List opdSurgeryDetailList= new ArrayList();
/* 	 List otList= new ArrayList();
	 List empList= new ArrayList();
	 List preAnesthesiaList= new ArrayList(); */
	 
	 List<MasDepartment> departmentList=new ArrayList<MasDepartment>();	 
	 
		if(map.get("departmentList") != null){
			departmentList = (List)map.get("departmentList");
		}
	 
	if(map.get("opdSurgeryList") != null){
		opdSurgeryList=(List)map.get("opdSurgeryList");
	}
	
	if(map.get("surgeonList") != null){
		surgeonList=(List)map.get("surgeonList");
	}
	
	
/* 	if(map.get("opdSurgeryDetailList") != null){
		opdSurgeryDetailList=(List)map.get("opdSurgeryDetailList");
	}
	if(map.get("otList") != null){
		otList=(List)map.get("otList");
	}
	if(map.get("empList") != null){
		empList=(List)map.get("empList");
	}
	 */
	//OtBooking otBooking = null;
	
	if(map.get("otBookingList") != null){
		otBookingList=(List<OtBooking>)map.get("otBookingList");
	}
/* 	if(map.get("preAnesthesiaList") != null){
		preAnesthesiaList=(List)map.get("preAnesthesiaList");
	}
 */	
 OpdSurgeryHeader opdSurgeryHeader = null;
 if(otBookingList!=null)
 {
	 
	 Set<OtBookingDt> opdSuregryDetailsSet = new HashSet<OtBookingDt>();
	 opdSuregryDetailsSet = otBookingList.get(0).getOtBookingDt();
	 
	 for(OtBookingDt pacDetail:opdSuregryDetailsSet)
	 {
		  opdSurgeryHeader = pacDetail.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getOpdSurgery();
		 break;
	 }
	
 }
 
	//OpdSurgeryHeader opdSurgeryHeader=(OpdSurgeryHeader)opdSurgeryList.get(0);
	
	String patientName="";
	if(opdSurgeryHeader.getHin().getPFirstName()!= null){
		patientName=opdSurgeryHeader.getHin().getPFirstName();
	}
	if(opdSurgeryHeader.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+opdSurgeryHeader.getHin().getPMiddleName();
	}
	if(opdSurgeryHeader.getHin().getPLastName()!= null){
		patientName=patientName+" "+opdSurgeryHeader.getHin().getPLastName();
	}
	/* String servicePersonName="";
	if(opdSurgeryHeader.getHin().getSFirstName()!= null){
		servicePersonName=opdSurgeryHeader.getHin().getSFirstName();
	}
	if(opdSurgeryHeader.getHin().getSMiddleName()!= null){
		servicePersonName=servicePersonName+" "+opdSurgeryHeader.getHin().getSMiddleName();
	}
	if(opdSurgeryHeader.getHin().getSLastName()!= null){
		servicePersonName=servicePersonName+" "+opdSurgeryHeader.getHin().getSLastName();
	} */
	
	List<MasOt> otlist = new ArrayList<MasOt>();

    if(map.get("otl") != null){
    	otlist = (List<MasOt>)map.get("otl");
    }
    
 /*    if(map.get("otMasUnitDays") != null){
    	masUnitDays = (List<OtMasUnitDay>)map.get("otMasUnitDays");
    }
    
    if(map.get("doctorUnit") != null){
    	doctorUnit = (List<HospitalDoctorUnitM>)map.get("doctorUnit");
    } */
	
	 String requisitionDateInString =HMSUtil.changeDateToddMMyyyy(opdSurgeryHeader.getRequisitionDate());
	int deptId=opdSurgeryHeader.getPrescribedDepartment().getId();
	String departmentName=opdSurgeryHeader.getPrescribedDepartment().getDepartmentName();
	
	Inpatient inpatient=null;
	Visit visit=null;
	Patient patient=null; // added by amit das on 20-09-2016
	if(opdSurgeryHeader!=null)
	{
		visit=opdSurgeryHeader.getVisit();
		if(opdSurgeryHeader.getInpatient()!=null)
		inpatient=opdSurgeryHeader.getInpatient();
		
		// added by amit das on 20-09-2016
		if(visit!=null)
			patient = visit.getHin();
		else if(inpatient!=null)
			patient = inpatient.getHin();
		
	}

	%>
<%-- <%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
 %> --%>

<!--main content placeholder starts here-->
<title>Surgery Scheduling </title>
<form name="updateOtBooking"   method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 <input
	name="patientStatus" type="hidden"
	value="<%=opdSurgeryHeader.getPatientStatus() %>" /> 
	<input name="opdSurgeryHeaderId" type="hidden"
	value="<%=opdSurgeryHeader.getId() %>" /> 
	
	<input
	name="orderNo" type="hidden"
	value="<%=opdSurgeryHeader.getOrderNo() %>" /> <input
	name="hospitalId" type="hidden" value="<%=hospitalId %>" /> <input
	name="changedBy" type="hidden" value="<%=userName %>" /> <input
	name="changedDate" type="hidden" value="<%=currentDate %>" /> <input
	name="changedTime" type="hidden" value="<%=currentTime %>" />

<div class="titleBg">
<h2>Surgery Scheduling</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
 
<!--vk  -->
<h4>Patient Details</h4>
<div class="clear"></div>
<%if(inpatient!=null ||visit!=null) {%>
<%@include file="PatientDetails.jsp" %>
<%} %>
<div class="clear"></div>
 <div class="division"></div>
<div class="clear"></div>
<%-- <input type="button" class="button" tabindex="3" name=""
value="+" onclick="OPDHistoryPopup('<%=opdSurgeryHeader.getHin().getId()%>', '<%=opdSurgeryHeader.getInpatient()!=null?opdSurgeryHeader.getInpatient().getId():"0"%>', '<%=opdSurgeryHeader.getId()%>');" />
<div class="popupTextDiv">Current OPD/IPD/OT History</div> --%>
<div class="floatRight">
				<a href="#"
					onclick="getTodayAllPrescriptionPopup('<%=opdSurgeryHeader.getHin().getId()%>','y','OT');">Current Medication</a>
			</div>
<div class="clear"></div>  


<h2>Surgery Scheduling</h2>

<%
Set<OtBookingDt> OtBookingDtSet = new HashSet<OtBookingDt>();
OtBookingDtSet = otBookingList.get(0).getOtBookingDt();
int count =1;
String procedure = "";
for(OtBookingDt otDt :OtBookingDtSet){
		if(otDt.getStatus() !=null && !otDt.getStatus().equalsIgnoreCase("y") && !otDt.getStatus().equalsIgnoreCase("c"))
		{
			if(count++ >1)
			procedure += " | ";
			procedure += otDt.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getChargeCode().getChargeCodeName();
%>
<input type="checkbox" check name="surgerydt"  onclick="return false;" checked="checked" style="margin-right: 5px;" value="<%=otDt.getId()%>"><div class="labRadiologyDivAuto" ><b><%=otDt.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getChargeCode().getChargeCodeName()%></b></div>
<%
		}
	}
%>

<h4>Scheduling Details</h4>
<div class="clear"></div>
<div class="clear"></div>

<input type="hidden" name="<%=HIN_ID %>"  value="<%=opdSurgeryHeader.getHin()!=null?opdSurgeryHeader.getHin().getId():"" %>"/>
<input type="hidden" name="<%=INPATIENT_ID %>"  value="<%=opdSurgeryHeader.getInpatient()!=null?opdSurgeryHeader.getInpatient().getId():"" %>"  />

<%if(otBookingList!=null && otBookingList.size()>0)
{
	%>
	<input type="hidden" name="<%=OT_BOOKING_ID %>" id="<%=OT_BOOKING_ID %>"  value="<%=otBookingList.get(0).getId() !=null?otBookingList.get(0).getId():"" %>"  />
<%
}
%>
<label>Scheduling Date</label>
<label class="value"><%=currentDate %></label>

<label>Prescribed Department</label> 
<input type="text" value="<%=opdSurgeryHeader.getPrescribedDepartment().getDepartmentName() %>"  readonly="readonly" />
<input type="hidden" name="<%=DEPT_ID%>"
	value="<%=opdSurgeryHeader.getPrescribedDepartment().getId()%>"/> 
<%-- <label>Unit<span>*</span></label>
 <select id="unitId" name="unitId" validate="Unit,number,yes" onchange="displayTable(this.value)">
	<option value="0">Select</option>
	<%if(doctorUnit!=null && doctorUnit.size()>0){
			for(HospitalDoctorUnitM doctorUnitObj :doctorUnit){
		%>
	<option value="<%=doctorUnitObj.getId()%>"><%=doctorUnitObj.getUnitCode()%></option>
	<%}}%>
   </select>

<label>OT<span>*</span></label>
<select name="ot" id="ot" validate="Operation Theator,int,yes"  >
	<option value="">Select</option>
	<%
	List<Integer> otIds=new ArrayList<Integer>();
	
	for(OtMasUnitDay masOt:masUnitDays){
		if(!otIds.contains(masOt.getDepartment().getId())){
			otIds.add(masOt.getDepartment().getId());
		%>
	<option value="<%=masOt.getDepartment().getId() %>"><%=masOt.getDepartment().getDepartmentName() %></option>
	<%}
		} %>
	</select> --%>
	
	<label>Surgery Date</label>

<%if(otBookingList!= null && otBookingList.size() >0 &&  otBookingList.get(0).getSurgeryDate()!=null){
             	        
			%>
				<input type="text" name="tentativeDate" readonly="readonly" id="tentativeDateId" onblur="onSelectSurgeryDate(this.value);" value="<%=HMSUtil.convertDateToStringWithoutTime(otBookingList.get(0).getSurgeryDate()) %>" />
			<%
			  	}else{
			%>
				<input type="text" name="tentativeDate" readonly="readonly" id="tentativeDateId" onblur="onSelectSurgeryDate(this.value);" />
			<%} %>

 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.getElementById('tentativeDateId'),event); "  />

	<div class="clear"></div>

<label>Start Time <span>*</span></label>
<input id="startTime" type="text" validate="Start Time,string,yes" autocomplete="off" maxlength="5" onblur="IsValidTime(this.value,this.id);" onkeyup="checkSurgeryDate('tentativeDateId');mask(this.value,this,'2',':');" name="startTime" value="<%=(otBookingList.get(0).getSurgeryStartTime()!=null?otBookingList.get(0).getSurgeryStartTime().toString().substring(0, 5):"")%>" >

<label>End Time <span>*</span></label>

<input id="endTime" type="text" validate="End Time,string,yes" maxlength="5" autocomplete="off" onblur="IsValidTime(this.value,this.id);checkAvailbilityForSurgeryTime(this.value, startTime,'timeAvailability','<%=OT_BOOKING_ID %>');" onkeyup="mask(this.value,this,'2',':');" name="endTime"  value="<%=(otBookingList.get(0).getSurgeryEndTime()!=null?otBookingList.get(0).getSurgeryEndTime().toString().substring(0, 5):"")%>">
<!-- <input type="text" name="endTime" onblur="checkAvailbilityForSurgeryTime(this.value, startTime);"> -->

<span id="timeAvailability" style="color: green;"></span>
<div class="clear"></div>
	
	<label>Department<span>*</span></label>
			<%if(otBookingList!= null && otBookingList.size() >0 &&  otBookingList.get(0).getDepartment()!=null){
			
			%>
			
						 <select id="deptId1" name="deptId1" validate="department,number,yes" onchange="displayOT(this.value)">
							<option value="0">Select</option>
							<%if(departmentList!=null && departmentList.size()>0){
								System.out.println(otBookingList.get(0).getDepartment().getId());
									for(MasDepartment deptList :departmentList){
										if(deptList.getId()==otBookingList.get(0).getDepartment().getId())
										{
										
								%>
								<option value="<%=deptList.getId()%>" selected="selected"><%=deptList.getDepartmentName()%></option>
								<%	
										}
										else
										{
										%>
							<option value="<%=deptList.getId()%>"><%=deptList.getDepartmentName()%></option>
							<% } }}%>
						   </select>
				
			<%
			  	}
			%>

<label>OT<span>*</span></label>
<select name="otId" id="otId" validate="Operation Theator,int,yes"  onchange="displayTable(this.value)">
	<%if(otBookingList!= null && otBookingList.size() >0 &&  otBookingList.get(0).getOt()!=null){
		
			%>
				<option value="0">Select</option>
			<option value="<%=otBookingList.get(0).getOt().getId() %>" selected="selected"><%=otBookingList.get(0).getOt().getOtName() %></option>
			
				<%-- <input type="text"   value="<%=otBookingList.get(0).getOt().getOtName() %>" readonly="readonly"/> --%>
			<%
			  	}
			%>
	</select>
	
	<label>Table<span>*</span></label>
	<%if(otBookingList!= null && otBookingList.size() >0 &&  otBookingList.get(0).getBed()!=null){
	%>	
			<input type="hidden" name="prevBedId" value="<%=otBookingList.get(0).getBed().getId() %>" />
	<%} %>
	
	  <select name="tableId" id="tableId" validate="Table,int,yes" >
		<%if(otBookingList!= null && otBookingList.size() >0 &&  otBookingList.get(0).getBed()!=null){
			%>
			<option value="0">Select</option>
			<option value="<%=otBookingList.get(0).getBed().getId() %>" selected="selected"><%=otBookingList.get(0).getBed().getBedNo()%></option>
			
			<%
			  	}
			%>
				
	</select>

  <div class="clear"></div>
  <label>Procedure </label> <textarea readonly="readonly" name="procedureName" cols="0" class="large" rows="0"><%=procedure%>

</textarea>
<input type="hidden" name="surgeryId" value="<%=surgeryId1%>"/>
<!-- <div class="clear"></div>
<label>Blood Requisition</label>
<input type="checkbox" name="bloodReq" />
<div class="clear"></div> -->

<div class="clear"></div>
 
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">

function eventCallback(element, entry){
	 //var r;
	// if(document.getElementById('rareCommon1').checked == true){
	// r=document.getElementById('rareCommon1').value;
	// }else {
	// r=document.getElementById('rareCommon2').value;
	// }
				 return entry + "&otId=" + document.getElementById('otId').value;
		}
//getChargeCodeListForAutoComplete
new Ajax.Autocompleter('chargeCodeName','ac2update','ot?method=getChargeCodeListForAutoComplete',{parameters:'requiredField=chargeCodeName', callback: eventCallback});
</script>
 <div class="clear"></div>
 <div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
 <h4>Resource Details</h4>
 <div class="clear"></div>
<div class="clear"></div>


<div class="clear"></div>
<div class="paddingTop5"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="surgeonGrid">
	<tr>
		<th scope="col">SI No.</th>
		<th scope="col">Resource Name</th>
		<th scope="col">Designation</th>
		<th scope="col">Role</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>
	
	<% int inc=1; 
	if(surgeonList!=null && surgeonList.size() >0){  
		for(OtBookSurgeon surgeon :surgeonList)
		{
		%>
		<tr>
		<td><input readonly="readonly" type="text" size="2" value="<%=inc%>" /></td>
		<td>
		<input type="text" value="<%=surgeon.getEmployee().getFirstName()%>[<%=surgeon.getEmployee().getId()%>]" tabindex="1"
			id="surgeonName1" size="43" name="surgeonName1" readonly="readonly"/>
	    </td>
				<td><input type="text" size="43" value="<%=surgeon.getEmployee().getRank().getRankName()%>" name="designation<%=inc-1%>" readonly="readonly" id="designation<%=inc%>"></input></td>
				<td>
				<select name="role<%=inc%>" id="role<%=inc%>"> 
				<option <%=surgeonList.get(inc-1).getRole()%>><%=surgeonList.get(inc-1).getRole()%></option>
				</select></td>
				<td><input type="button" class="button" alt="Add" value="Add" onclick="addRowForSurgeon();"align="right" /></td>
				<td><input type="button" class="button" alt="Delete" value="Delete" onclick="removeRow('surgeonGrid','hiddenValue',this);" align="right" /> </td>
					
	</tr>
		<%	 
		inc++;
		
		 
		}
	}
	else
	{
	%>	
			<tr>
		<td><input readonly="readonly" type="text" size="2" value="1" /></td>
		<td>
	 <input type="text" value="" tabindex="1"
			id="surgeonName1" size="43" name="surgeonName1" 
			 onblur="checkDuplicateResource(this.value,<%=inc%>); fillMemberDetails(this.value,<%=inc%>)"/>
		<div id="ac2update2" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('surgeonName1','ac2update2','ot?method=getSurgeonListForAutoComplete',{parameters:'requiredField=surgeonName1'});
				</script></td>
				<td><input type="text" size="43" name="designation<%=inc%>" readonly="readonly" id="designation<%=inc%>"></input></td>
				<td>
				<select name="role<%=inc%>" id="role<%=inc%>"> 
				<option value="">Select</option>
				<option value="Surgeon">Surgeon</option>
				<option value="First Assistance">First Assistance</option>
				<option value="Second Assistance">Second Assistance</option>
				<option value="Third Assistance">Third Assistance</option>
				<option value="Fourth Assistance">Fourth Assistance</option>
				<option value="Floor Nurse">Floor Nurse</option>
				<option value="Main Nurse">Main Nurse</option>
				<option value="Count Nurse">Count Nurse</option>
				<option value="Anesthetist one">Anesthetist one</option>
				<option value="Anesthetist two">Anesthetist two</option>
				<option value="Anesthetist three">Anesthetist three</option>				
				</select></td>
				<td><input type="button" class="button" alt="Add" value="Add" onclick="addRowForSurgeon();"align="right" /></td>
				<td><input type="button" class="button" alt="Delete" value="Delete" onclick="removeRow('surgeonGrid','hiddenValue',this);" align="right" /> </td>
	</tr>
	<%}%>

</table>
<div class="clear"></div>
		<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />

<div class="clear"></div>
  
<div class="clear"></div>
<!-- To do -->
  <div class="clear"></div>
<%-- 
<h4>Equipment Requirement </h4>
<div class="clear"></div>

<input type="button" class="button" alt="Delete" value="Delete"
	onclick="removeRow();" align="right" /> 
	<input type="button"
	class="button" alt="Add" value="Add" onclick="addRowForEquipment();"
	align="right" />
<div class="clear"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="equipmentGrid">
	<tr>
		<th scope="col">SI No.</th>
		<th scope="col">Equipment  Name</th>
		<th scope="col">Quantity</th>
	</tr>
	<tr>
		<td><input readonly="readonly" type="text" size="2" value="1" /></td>
		<td>
		<%int inc=1; %> <input type="text" value="" tabindex="1"
			id="equipmentName1" size="43" name="equipmentName1" onClick="fillMemberDetails(this.value,<%=inc%>)"
			 onblur="fillMemberDetails(this.value,<%=inc%>)"/>
		<div id="ac2update2" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('equipmentName1','ac2update2','ot?method=getSurgeonListForAutoComplete',{parameters:'requiredField=surgeonName1'});
				</script></td>
				<td><input type="text" name="designation<%=inc%>" id="designation<%=inc%>"></input></td>
	</tr>
</table> --%>
<div class="clear"></div>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<div class="clear"></div>
<%if(otBookingList!= null && otBookingList.size() >0 &&  otBookingList.get(0).getOtRemarks()!=null){%>
	<label>Remarks </label> <textarea name="ot_remarks" class="textareaMediua" maxlength="70" ><%=otBookingList.get(0).getOtRemarks()%></textarea>
<%}else
		{%>
		<label>Remarks </label> <textarea name="ot_remarks" class="textareaMediua" maxlength="70" ></textarea>
		<%} %>
		



<div class="clear"></div>

<input type="button" name="Submit" class="button" value="Submit"
	onclick="if(validateSurgeonForOTBooking()){submitForm ('updateOtBooking','ot?method=updateOTSchedule','validateSurgeryDate','checkTentativeDate');}" />  
 
<input name="back" type="button" class="button" value="Back"
	onclick="showBack('updateOtBooking')" />
<div class="clear"></div>
</div>
</form>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom">

<div class="clear"></div>
<label>Changed By</label> <label class="value"><%=userName %></label> <label>Changed
Date</label> <label class="value"><%=currentDate %></label> <label>Changed
Time</label> <label class="value"><%=currentTime %></label></div>


<div id="rateVal">
<input type=hidden name="hidden" id="hidden" value="0"/>
</div>
<div class="clear"></div>

<%-- <script type="text/javascript">	
	var	masUnitDaysArray= new Array();
                 <%
             	int dayIndex=0;
                 for(OtMasUnitDay masOt:masUnitDays){
     			 %>
     			masUnitDaysArray[<%=dayIndex%>]= new Array();
     			masUnitDaysArray[<%=dayIndex%>][0] = "<%=masOt.getDepartment().getId()%>";
     			masUnitDaysArray[<%=dayIndex%>][1] = "<%=masOt.getMasBed().getId()%>";
     			masUnitDaysArray[<%=dayIndex%>][2] = "<%=masOt.getMasBed().getBedNo()%>";
     			<% 
     			dayIndex++;
                 }%> 
            </script>  --%>
<script type="text/javascript">
function checkTentativeDate(){
	
	currentDate = new Date();
	 var month = currentDate.getMonth() + 1
	 var day = currentDate.getDate()
	 var year = currentDate.getFullYear()
	 var seperator = "/"
	 currentDate = new Date(month + seperator + day + seperator + year);
	 
	var tentativeDateString = document.getElementById('tentativeDateId').value;
	var  tentativeDate = new Date(tentativeDateString.substring(6),(tentativeDateString.substring(3,5) - 1) ,tentativeDateString.substring(0,2))
	if(tentativeDate < currentDate || tentativeDate == currentDate ){
		alert("Tentative Should be Future Date or Current Date.");
		 document.getElementById('tentativeDateId').value ="";
			document.getElementById('endTime').value  = '';
			document.getElementById('startTime').value  = '';
		return false;
	}

	return true;
}

function checkSurgeryDate(tentativeDateId)
{
	var surgeryDate = document.getElementById(tentativeDateId).value;
	if(surgeryDate=="")
	{
	  alert("Select surgery date");
	  var element = document.getElementById('deptId');
      element.value = "0";
      document.getElementById('startTime').value= '';
      document.getElementById('endTime').value= '';
      
	  return false;
	}
	return true;
}

function displayOT(val)
{
	//alert("gh");
	var surgeryDate = document.getElementById('tentativeDateId').value;
	if(checkSurgeryDate('tentativeDateId'))
	   ajaxFunctionDisplayOT('updateOtBooking','ot?method=displayDepartmentOT&deptId='+val+"&surgeryDate="+surgeryDate);
	
} 


function ajaxFunctionDisplayOT(formName,action) {

	  var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

	      //	var brandId="brandId"+rowVal;
	      	var OtId="otId";
	      //	var batchName ="batchName"+rowVal;
	      //	alert(batchName);
		//	obj1 =document.getElementById(brandId);
			obj = document.getElementById(OtId);
			//obj1 = document.getElementById(batchName);
			obj.length = 1;
			//obj1.length =1;

	      	for (loop = 0; loop < items.childNodes.length; loop++) {
	      		var item = items.childNodes[loop];
		         var batchLength  = item.getElementsByTagName("tables")[0];
		      

	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var table = batchLength.childNodes[innerLoop];
		        	var tableId  = table.getElementsByTagName("tableId")[0];
		        	var tableNo  = table.getElementsByTagName("tableNo")[0];
		        	obj.length++;
					obj.options[obj.length-1].value=tableId.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=tableNo.childNodes[0].nodeValue;
					
	        	}

	        	/* for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++){
	        		var brand = brandLength.childNodes[innerLoop];
		        	var brandId  = brand.getElementsByTagName("brandId")[0];
		        	var brandName  = brand.getElementsByTagName("brandName")[0];

		        	obj1.length++;
					obj1.options[obj1.length-1].value=brandId.childNodes[0].nodeValue;
					obj1.options[obj1.length-1].text=brandName.childNodes[0].nodeValue;

	        	}*/

	      	}
	      }
	    }
	   // var url=action+"&"+getNameAndData(formName);
	 //	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	 
	    var url=action+"&"+getNameAndData(formName);
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);


	  }
	 function displayTable(val)
	{
		 var surgeryDate = document.getElementById('tentativeDateId').value;
		ajaxFunctionDisplayOtTable('updateOtBooking','ot?method=displayOtTableForDepartmentWiseOT&otId='+val+"&surgeryDate="+surgeryDate);
    } 
	 function ajaxFunctionDisplayOtTable(formName,action) {

		  var xmlHttp;
		  try {
		    // Firefox, Opera 8.0+, Safari
		    xmlHttp=new XMLHttpRequest();
		  }catch (e){
		    // Internet Explorer
		    try{
		      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		    }catch (e){
		    	alert(e)
		      try{
		        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }catch (e){
		        alert("Your browser does not support AJAX!");
		        return false;
		      }
		     }
		   }
		    xmlHttp.onreadystatechange=function()
		    {
		      if(xmlHttp.readyState==4){

		      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

		      //	var brandId="brandId"+rowVal;
		      	var tableId="tableId";
		      //	var batchName ="batchName"+rowVal;
		      //	alert(batchName);
			//	obj1 =document.getElementById(brandId);
				obj = document.getElementById(tableId);
				//obj1 = document.getElementById(batchName);
				obj.length = 1;
				//obj1.length =1;

		      	for (loop = 0; loop < items.childNodes.length; loop++) {
		      		var item = items.childNodes[loop];
			         var batchLength  = item.getElementsByTagName("tables")[0];
			      

		        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
		        	{
		        		var table = batchLength.childNodes[innerLoop];
			        	var tableId  = table.getElementsByTagName("tableId")[0];
			        	var tableNo  = table.getElementsByTagName("tableNo")[0];
			        	obj.length++;
						obj.options[obj.length-1].value=tableId.childNodes[0].nodeValue;
						obj.options[obj.length-1].text=tableNo.childNodes[0].nodeValue;
						
		        	}

		        	/* for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++){
		        		var brand = brandLength.childNodes[innerLoop];
			        	var brandId  = brand.getElementsByTagName("brandId")[0];
			        	var brandName  = brand.getElementsByTagName("brandName")[0];

			        	obj1.length++;
						obj1.options[obj1.length-1].value=brandId.childNodes[0].nodeValue;
						obj1.options[obj1.length-1].text=brandName.childNodes[0].nodeValue;

		        	}*/

		      	}
		      }
		    }
		    var url=action+"&"+getNameAndData(formName);
		  
		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);


		  }



function setFocusAtEnd()
{
	
	document.getElementById('chargeCodeName').focus();
}
/*function submitProtoAjaxWithDivName(formName,action,divName){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
        	new Ajax.Updater(divName,url,
			   {asynchronous:false, evalScripts:true });
	       	return true;
    }
*/
/*     function removeRow()
	{
	  var tbl = document.getElementById('surgeonGrid');
	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	  else
		      alert("Cannot Delete All Rows");
	 }
 */
 
	function removeRow(idName,countId,obj)
	{
 	  var tbl = document.getElementById(idName);
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  //	tbl.deleteRow(lastRow - 1);
	    var i=obj.parentNode.parentNode.rowIndex;
	    tbl.deleteRow(i);
	  } 
	}
 
 	function addRowForSurgeon(){

	  var tbl = document.getElementById('surgeonGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration

	  var cellRightSel = row.insertCell(0);
	  var sel = document.createElement('input');
	  sel.value=hdb.value;
	  sel.size='2';
	  sel.type = 'text';
	  sel.setAttribute("readonly","readonly");
	  cellRightSel.appendChild(sel);


	  var cellRight1 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'surgeonName' + iteration;
	  e0.id = 'surgeonName' + iteration;
	  e0.size = '43'
	 
		  e0.onclick = function(){
		  fillMemberDetails(this.value,this,'2,5',':');
				  }
		e0.onblur = function(){
			fillMemberDetails(this.value,iteration);
			}
	 
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update2');
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
    cellRight1.appendChild(newdiv);

	  cellRight1.appendChild(e0);
	new Ajax.Autocompleter('surgeonName'+iteration,'ac2update2','ot?method=getSurgeonListForAutoComplete',{parameters:'requiredField=surgeonName'+iteration});
   
	/*  */
	 var cellRight2 = row.insertCell(2);
	  var d = document.createElement('input');
	  d.type = 'text';
	  d.name = 'designation' + iteration;
	  d.id = 'designation' + iteration;
	  d.size = '43'
	   d.readonly='readonly'
		  cellRight2.appendChild(d);
	  
	  
	  
	  var cellRight3 = row.insertCell(3);
	  var d2 = document.createElement('Select');
	  d2.name = 'role' + iteration;
	  d2.id = 'role' + iteration;
	  
	  
	  d2.options[0] = new Option('Select', '');
	  d2.options[1] = new Option('Surgeon', 'Surgeon');
	  d2.options[2] = new Option('First Assistance', 'First Assistance');
	  d2.options[3] = new Option('Second Assistance', 'Second Assistance');
	  d2.options[4] = new Option('Third Assistance', 'Third Assistance');
	  d2.options[5] = new Option('Fourth Assistance', 'Fourth Assistance');
	  d2.options[6] = new Option('Floor Nurse', 'Floor Nurse');
	  d2.options[7] = new Option('Main Nurse', 'Main Nurse');
		d2.options[8] = new Option('Count Nurse', 'Count Nurse');
		d2.options[9] = new Option('Anesthetist one', 'Anesthetist one');
		d2.options[10] = new Option('Anesthetist two', 'Anesthetist two');
		d2.options[11] = new Option('Anesthetist three', 'Anesthetist three');
	   cellRight3.appendChild(d2);
	   
		  var cellRight4 = row.insertCell(4);
		  var e3 = document.createElement('input');
		  e3.type = 'button';
		  e3.className = 'button';
		  e3.name='Button';
		  e3.value='Add';
		  e3.setAttribute('tabindex','1');
		  //e4.setAttribute('onClick','addRowForInvestigation();');
		  e3.onclick = function(){addRowForSurgeon();}; 
		  cellRight4.appendChild(e3);
		  

		  var cellRight5 = row.insertCell(5);
		  var e4 = document.createElement('input');
		  e4.type = 'button';
		  e4.className = 'button';
		  e4.value='Delete';
		  e4.name='remarks'+iteration;
		  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
		  e4.onclick = function(){removeRow("surgeonGrid","hdb",this);};  
		  e4.setAttribute('tabindex','1');
		  cellRight5.appendChild(e4);
		  
	 }


	function showBack(formName)
	{
	  obj = eval('document.'+formName)
	  obj.action = "/hms/hms/ot?method=showPacClearedListForOTBookingJsp";
	  obj.submit();
	}

	function validateSurgeryDate(){

			//var surgeryDate=document.getElementById('surgeryDate').value
			//var surgeryStartTime=document.getElementById('surgeryTime').value
 			//alert("surgeryDate----"+ surgeryDate)
		    /*  if(surgeryDate =="")
		    {
		    	 if(!displayAlert("Please Enter The Surgery Date."))
			    	 alert("Please Enter The Surgery Date.");
		    	 getShadow('surgeryDate');
				return false ;
 			}
			if(surgeryStartTime =="")
		    {
				if(!displayAlert("Please Enter The Surgery Time."))
					alert("Please Enter The Surgery Time.");
				getShadow('surgeryTime');
				return false ;
 			} */
			return true;
		}


		function validateSurgeonForOTBooking(){
			
			var checkboxs=document.getElementsByName("surgerydt");
		    var okay=false;
		    for(var i=0,l=checkboxs.length;i<l;i++)
		    {
		        if(checkboxs[i].checked)
		        {
		            okay=true;
		            break;
		        }
		    }
		    if(!okay)
		    	{
		    	 alert("Please select atleast one surgery");
		    	 return false;
		    	}
		    	
		    
		    for(var i = 1; i <= document.getElementById('hiddenValue').value; i++){
				
		    	if(document.getElementById('surgeonName'+i)!=null){
		    	
		    	var surgeonName=document.getElementById('surgeonName'+i).value
				var role=document.getElementById('role'+i).value
	 			//alert("surgeonName----"+ surgeonName)
			     if(surgeonName !="" && role!="")
			    {
					return true ;
	 			}
		    	}
				

	  		}
					 alert("Surgeon Name and Role both are mandatory");
			return false;

		    
			
			
			//alert("document.getElementById('hiddenValue').value---- "+document.getElementById('hiddenValue').value)
		/* 	 for(var i = 1; i <= document.getElementById('hiddenValue').value; i++){
			var surgeonName=document.getElementById('surgeonName'+i).value
 			//alert("surgeonName----"+ surgeonName)
		     if(surgeonName !="" && checkTentativeDate())
		    {
				return true ;
 			}

  		}
				 alert("Please Enter The Surgeon Name.");
		return false; */
		
		//return true;

	}

		function timeVal(timeStr)
		{

			var durationTime=document.getElementById('hidden').value;
			var durationHours=durationTime.substring(0, 2);
			var durationMinutes=durationTime.substring(3, 5);
			durationHours=parseInt(durationHours);
			durationMinutes=parseInt(durationMinutes);

			var strHours=timeStr.substring(0, 2);
			strHours=parseInt(strHours);
			var strMinute=timeStr.substring(3, 5);
			//strHours=parseInt(strHours);
			strMinute=parseInt(strMinute);

			if(strHours==0)
			{
				strHours=timeStr.substring(1, 2);
			}

			var totalMinutes=parseInt(durationMinutes)+parseInt(strMinute);
			//if(strHours>=8 && strHours<10)

			var totalHours=((durationHours)+(parseInt(strHours)));
var remHour=0;
var remMin=0;
var finalHours=0;
var finalMinutes=0;

			if(totalMinutes>=60)
			{
				remHour=Math.floor(totalMinutes/60);
                remMin=totalMinutes%60;
				finalHours=totalHours+remHour;
				finalMinutes=remMin;
 }
			else
			{
				finalHours=totalHours;
				finalMinutes=totalMinutes;
 }
if(finalMinutes<10)
{
	finalMinutes="0"+finalMinutes;

}
if(finalHours<10)
{
	finalHours="0"+finalHours;

} 	var endtime=finalHours+":"+finalMinutes;
 		document.getElementById('endTime').value=endtime;
 getBookingTime();
  }

/* function getBookingTime()
{
	 var surgeryDate=document.getElementById('surgeryDate').value;
	var surgeryDept=document.getElementById('deptSurgery').value;
	var otIdBooked=document.getElementById('otId').value;	
		submitProtoAjaxWithDivNameForBooking('otBooking','/hms/hms/ot?method=getOtDateList&surgeryDate='+surgeryDate+'&deptSurgery='+surgeryDept+'&otIdBooked='+otIdBooked);
} */
 function submitProtoAjaxWithDivNameForBooking(formName,action) {
	  var xmlHttp;
	
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	    var url=action;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    var surgeryEndTime=document.getElementById('endTime').value
	    var surgeryStartTime=document.getElementById('surgeryTime').value
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

	      	for (loop = 0; loop < items.childNodes.length; loop++)
	      	{
			   	    var item = items.childNodes[loop];

		        var id  = item.getElementsByTagName("id")[0];
		        var stime = item.getElementsByTagName("stime")[0];
		        var etime  = item.getElementsByTagName("etime")[0];
				
			        if(((surgeryStartTime<stime.childNodes[0].nodeValue) && (surgeryEndTime<stime.childNodes[0].nodeValue)) || ((surgeryStartTime>etime.childNodes[0].nodeValue) && (surgeryEndTime>etime.childNodes[0].nodeValue)))
		        {


			    }

			        else
			        {

			        //	alert("OT already Booked for this Time Slot......");
					//	 document.getElementById('surgeryTime').value="";
					//	 document.getElementById('surgeryTime').focus;
						return true
				     }

	      }
	    }
	  }
	}
	
	
function checkDuplicateResource(val, inc) {
	if (val != "") {
		//alert("checkduplicay");
/* 		 for(var i = 1; i <= document.getElementById('hiddenValue').value; i++){
				var surgeonName=document.getElementById('surgeonName'+i).value
				var role=document.getElementById('role'+i).value
	 			//alert("surgeonName----"+ surgeonName)
			     if(surgeonName !="" && role!="")
			    {
					return true ;
	 			}

	  		} */
	  		
	  		var hiddenValue=document.getElementById('hiddenValue').value
		for (var i = 1; i <= hiddenValue; i++) {

			if (inc != i) {
				
				if (document.getElementById('surgeonName' + i)
						&& document.getElementById('surgeonName' + i).value == val) {
					alert("Resource already selected...!");
					document.getElementById('surgeonName' + inc).value = ""
					//document.getElementById('pvmsNo' + inc).value = "";
					var e = eval(document.getElementById('surgeonName' + inc));
					e.focus();
					return false;
				}
			}
		}

	}
}
	
	
function fillMemberDetails(val,inc)
{
	  if(val!=''){
        var xmlHttp;
        try {
          // Firefox, Opera 8.0+, Safari
          xmlHttp=new XMLHttpRequest();
        }catch (e){
          // Internet Explorer
          try{
            xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
          }catch (e){
              alert(e)
            try{
              xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
            }catch (e){
              alert("Your browser does not support AJAX!");
              return false;
            }
           }
         }
            xmlHttp.onreadystatechange=function()
            {
              if(xmlHttp.readyState==4){
              
                  obj = document.getElementById('designation'+inc);
                obj.length = 1;
                  var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
                  for (loop = 0; loop < items.childNodes.length; loop++) {
                       var item = items.childNodes[loop];
                      var idMember = item.getElementsByTagName("idMember")[0];    
                       var nameMember  = item.getElementsByTagName("nameMember")[0];
                      // alert("dfsf"+item.getElementsByTagName("designation")[0]);
                    var designation  = item.getElementsByTagName("designation")[0];
                    if(designation.childNodes[0]!=undefined){
                          for(innerLoop = 0;innerLoop <designation.childNodes.length;innerLoop++)
                        {
                            var dr = designation.childNodes[innerLoop];
                            //var dId  = dr.getElementsByTagName("dId")[0];
                            var dName  = dr.getElementsByTagName("dName")[0];
                              // document.getElementById('emp_id'+inc).value = idMember.childNodes[0].nodeValue
                          obj.length++;
                            //obj.options[obj.length-1].value=dId.childNodes[0].nodeValue;
                            document.getElementById('designation'+inc).value=dName.childNodes[0].nodeValue;
                            
                        }
                        }
              }
        if(items.childNodes.length ==0)
        	{
        	document.getElementById('surgeonName'+inc).value ="";
        	document.getElementById('designation'+inc).value ="";
        	}
        
              }
            }
            var url='/hms/hms/ot?method=fillMemberForName&nameMember='+val;
    	 	//url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
             
            xmlHttp.open("GET",url,true);
            xmlHttp.setRequestHeader("Content-Type", "text/xml");
            xmlHttp.send(null);
        }else{
        	//alert(document.getElementById('surgeonName2').value+inc);
            document.getElementById('surgeonName'+inc).value='';
        }
   
}
function onSelectSurgeryDate(sDate)
{
	var element = document.getElementById('deptId1');
    element.value = "0";
    document.getElementById('startTime').value ="";
    document.getElementById('endTime').value ="";
	return false;
}

function onChangeOt(otid)
{
	var selectField=document.getElementById('tableId');
	selectField.options.length=0;
	if(otid!='' && parseInt(otid)!=0)
		{
		selectField.options[0] = new Option('Select', '0');
		var j=1;
		 for(var i = 0;i<masUnitDaysArray.length;i++ ){
			// alert(masUnitDaysArray[i][0]==otid);
			 if(masUnitDaysArray[i][0]==otid)
				 {
				 selectField.options[j] = new Option(masUnitDaysArray[i][2],masUnitDaysArray[i][1]);
				 j++;
				 }
		      }
		}
	else
		{
		selectField.options[0] = new Option('Select', '0');
		}
}


function checkAvailbilityForSurgeryTime(t1, t2, divName, otBooking){
	 var  endTime = t1;
	 var startTime = t2.value;
	 var surgeryDate = document.getElementById('tentativeDateId').value;
	if( startTime!="")
		{
		
		var now = new Date()
		now = now.toString().substr(16,5);
		if(now > startTime || now >endTime )
			{
			document.getElementById('endTime').value  = '';
			document.getElementById('startTime').value  = '';
			alert("Surgery time should be a future time");
			return false;
			}
		
		
		var otBookingId =0;
		if(otBooking)
		   otBookingId = document.getElementById(otBooking).value;
		
	 var st = startTime.split(":");
	 var stsec = parseInt(st[1]) + 1;
	 if(stsec.toString().length==1)
	     startTime = st[0] +':0'+stsec;
	 else
		 startTime = st[0] +':'+stsec;
		 
		 var st = endTime.split(":");
		 var stsec = parseInt(st[1]) + 1;
		 if(stsec.toString().length==1)
			 endTime = st[0] +':0'+stsec;
		 else
			 endTime = st[0] +':'+stsec;
	//
	//var value1=document.getElementsByName('nomenclature'+inc).value;
	//alert(val+"<<<-------val======inc------>>"+value1);
	
	//var visitId=document.getElementById("visitId").value;
	//var id;

		  var xmlHttp;
		  try {
		    // Firefox, Opera 8.0+, Safari
		    xmlHttp=new XMLHttpRequest();
		  }catch (e){
		    // Internet Explorer
		    try{
		      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		    }catch (e){
		    	alert(e)
		      try{
		        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }catch (e){
		        alert("Your browser does not support AJAX!");
		        return false;
		      }
		     }
		   }

		xmlHttp.onreadystatechange=function()
		{
		  if(xmlHttp.readyState==4){
			  var match="false";
		  	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		  	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var dupl  = item.getElementsByTagName('timeAllotted')[0];
		        //alert("icdString"+icdString);
		         match =dupl.childNodes[0].nodeValue
		     // alert("b-->>"+b);
		       
		        // var val=document.getElementById('icd').value;
		        /*  var index1 = val.lastIndexOf("[");
				    var index2 = val.lastIndexOf("]");
				    index1++;
				    id = val.substring(index1,index2);
				    //alert("id------>>>"+id);
				    if(id ==""){
					  return;
					}
				   */
				    if(match=='true'){
				    	   var startTimeAllotted  = item.getElementsByTagName('startTimeAllotted')[0].childNodes[0].nodeValue;
				    	   var endTimeAllotted  = item.getElementsByTagName('endTimeAllotted')[0].childNodes[0].nodeValue;
						   alert("Time Slot is not available in between "+ startTimeAllotted +" and " + endTimeAllotted);
						  document.getElementById('startTime').value="";
						  document.getElementById('endTime').value="";
						  document.getElementById('timeAvailability').innerText  = '';
					   }
				    else
				    	{
				    	  document.getElementById('timeAvailability').innerText  = 'Time slot is available';
				    	}
				    }
					
		  }
		  }
		//var url="/hms/hms/opd?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)
		  	
		 //var url="/hms/hms/opd?method=checkForAlreadyIssuedPrescribtion&val="+val+"&visitId="+visitId+"&"+csrfTokenName+"="+csrfTokenValue;
				var url="/hms/hms/ot?method=checkAvailabilityForSurgeryTime&startTime=" + startTime+"&endTime="+ endTime+"&surgeryDate="+surgeryDate +"&otBookingId="+otBookingId;
		xmlHttp.open("GET",url,true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
		

			
	}
	
	else
	{
		document.getElementById('timeAvailability').innerText  = '';
		document.getElementById('endTime').value  = '';
	alert("Please enter Start time first");
	return false;
	}
		
}

function OPDHistoryPopup(hinId,inpatientId,opdsurgeryid)
{
//var url='/hms/hms/opd?method=showPopUpPresentComplaint&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
	 var url='/hms/hms/ot?method=openPopupWindowForOPDHistory&hinId='+hinId+"&inpatientId="+inpatientId+"&opdSurgeryId="+opdsurgeryid;;
 //popwindow(url);
window.open(url,'name',"left=170,top=50,height=600,width=850,status=1,scrollbars=1,resizable=0");
} 
  </script>

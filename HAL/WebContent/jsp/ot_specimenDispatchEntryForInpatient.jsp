<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">

function showBack(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=showSpecimenDispatchEntry";
  obj.submit();
}
</script>
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
        int hospitalId=0;
        String entryNo="";
        String userName = "";
        String patientName="";
		Map map = new HashMap();
		
	 List patientDetailList = new ArrayList();
	 List departmentList = new ArrayList();

	 List<MasEmployee> empByList = new ArrayList<MasEmployee>();
	 List<MasEmployee> empRevList = new ArrayList<MasEmployee>();
	 Map<String,Object> utilMap = new HashMap<String,Object>();
		Map<String,Object> utilMapForTime = new HashMap<String,Object>();

		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");	 
		String currentTime = (String)utilMap.get("currentTime");
		
		utilMapForTime = (Map)HMSUtil.getCurrentTimeWithoutSecond();
		String currentTimeWithoutSecond = (String)utilMap.get("currentTime");

	 if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
	if(map.get("patientDetailList") != null){
		patientDetailList=(List)map.get("patientDetailList");
	}
	if(map.get("departmentList") != null){
		departmentList=(List)map.get("departmentList");
		}
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if(map.get("entryNo") != null){
		entryNo = (String)map.get("entryNo");
	}
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	 if(map.get("empByList") != null){
		 empByList = (List<MasEmployee>) map.get("empByList");
	}
	 if(map.get("empRevList") != null){
		 empRevList = (List<MasEmployee>) map.get("empRevList");
	}
	if(patientDetailList!=null && patientDetailList.size() > 0)
	{
			OtBooking patient=(OtBooking)patientDetailList.get(0);
			if(patient.getHin().getPFirstName()!= null){
				patientName=patient.getHin().getPFirstName();
			}
			if(patient.getHin().getPMiddleName()!= null){
				patientName=patientName+" "+patient.getHin().getPMiddleName();
			}
			if(patient.getHin().getPLastName()!= null){
				patientName=patientName+" "+patient.getHin().getPLastName();
			}
			String servicePersonName="";
			if(patient.getHin().getSFirstName()!= null){
				servicePersonName=patient.getHin().getSFirstName();
			}
			if(patient.getHin().getSMiddleName()!= null){
				servicePersonName=servicePersonName+" "+patient.getHin().getSMiddleName();
			}
			if(patient.getHin().getSLastName()!= null){
				servicePersonName=servicePersonName+" "+patient.getHin().getSLastName();
			}
			 
		%>


<div id="contentHolder">
<form name="specimenDispatchEntry" action="" method="post">

<h6>Specimen Dispatch Entry</h6>
<div class="Clear"></div>
<div class="header"><label>Entry No</label> <label class="value"><input
	type="text" value="<%=entryNo %>" name="entryNo" readonly="readonly" /></label>

<label>Date</label> <label class="value"><input type="text"
	value="<%=currentDate %>" name="dateOfDispatch" readonly="readonly" /></label>

</div>
<div class="Clear"></div>
<!--Block One Starts-->

<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service Type</label> <%if(patient.getHin().getServiceType()!= null){ %>
<label class="valuemedium"><%=patient.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Service No.</label> <%if(patient.getHin().getServiceNo()!= null){ %>
<label class="valuemedium"><%=patient.getHin().getServiceNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium"> Serv. Status </label> <%if(patient.getHin().getServiceStatus()!= null){ %>
<label class="valuemedium"><%=patient.getHin().getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Name</label> <%if(servicePersonName != null){ %> <label
	class="valuemedium" style="width: auto;"><%=servicePersonName %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<label class="medium">Relation</label> <%if(patient.getHin().getRelation() != null){ %>
<label class="valuemedium"><%=patient.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Rank</label> <%if(patient.getHin().getRank()!= null){ %> <label
	class="valuemedium"><%=patient.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit</label> <%if(patient.getHin().getUnit()!= null){ %> <label
	class="valuemedium"><%=patient.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="valuemedium">--</label> <%} %> <label
	class="medium">Unit Address</label> <% if(patient.getHin().getUnit()!= null){%>
<label class="valuemedium"><%=patient.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %> <label class="valuemedium">--</label> <%} %>
<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label class="medium">HIN No.</label> <%if(patient.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=patient.getHin().getHinNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Patient
Name. </label> <%if(patientName!= null){ %> <label class="valuemedium"><%=patientName %>
</label> <%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Age</label> <%if(patient.getHin().getAge()!= null){ %> <label
	class="valuemedium"><%=patient.getHin().getAge() %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">Patient
Status </label> <%if(patient.getHin().getPatientStatus() != null){ %> <label
	class="valuemedium"><%=patient.getHin().getPatientStatus() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>
<%if(patient.getVisit() != null){ %> <input name="visitId" type="hidden"
	value="<%=patient.getVisit().getId()%>" /> <%} else{%> <input
	name="visitId" type="hidden" value="" /> <%} %> <label class="medium">Reg.Date
</label> <%if(patient.getHin().getRegDate()!= null){ %> <label class="valuemedium"><%=HMSUtil.changeDateToddMMyyyy(patient.getHin().getRegDate()) %></label>
<%}else{ %> <label class="valuemedium">-</label> <%}%> <input
	name="userName" id="userName" type="hidden" value="<%=userName %>" />
<%if(patient.getOrderNo()  != null){ %> <input type="hidden"
	name="orderNo" value="<%=patient.getOrderNo() %>" /> <%} %> <%if(patient.getHin() != null){ %>
<input name="hinId" type="hidden" value="<%=patient.getHin().getId()%>" />
<%} %> <%if(patient.getDepartment() != null){ %> <input name="departmentId"
	type="hidden" value="<%=patient.getDepartment().getId()%>" /> <%} %> <input
	name="hospitalId" type="hidden" value="<%=hospitalId%>" /> <input
	name="changedDate" type="hidden" value="<%=currentDate %>" /> <input
	name="changedTime" type="hidden" value="<%=currentTime %>" /> <input
	name="otBookingId" type="hidden" value="<%=patient.getId()%>"
	maxlength="50" id="otBookingId" /> <%}%>

<div class="Clear"></div>
</div>
<div class="division"></div>
<div class="Clear"></div>
<label class="noWidth" style="width: 138px;"><span>*</span>
Tissue/Organ</label> <input name="tissueOrgan" type="text" tabindex="1"
	size="43" maxlength="50" validate="Tissue,string,yes" /> <label
	class="noWidth"><span>*</span> Specimen Dispatched By</label> <select
	id="empBy" name="empBy" validate="Specimen Dispatch By,string,yes"
	tabindex="2">
	<option value="0">Select</option>
	<%
							for (MasEmployee masEmployee : empByList) {
						%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "%><%=masEmployee.getMiddleName()+" "%><%=masEmployee.getLastName()%></option>
	<%
						}
					%>
</select> <label class="noWidth"><span>*</span> Time of dispatch</label> <input
	name="timeOfDispatch" id="timeOfDispatch" type="text" tabindex="10"
	value="" maxlength="5"
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	validate="Time of dispatch,string,yes"
	onblur="IsValidTimeWithBlankCheck(this.value,this.id)" />
<div class="Clear"></div>

<label class="noWidth"><span>*</span> Examination Required</label> <input
	name="examinationRequired" type="text" tabindex="10" maxlength="50"
	validate="Examination Required,string,yes" /> <label class="noWidth"
	style="width: 152px;"><span>*</span> Specimen Received By</label> <select
	id="empRev" name="empRev" validate="Specimen Received By,string,yes"
	tabindex="2">
	<option value="0">Select</option>
	<%
					for (MasEmployee masEmployee : empRevList) {
						%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "%><%=masEmployee.getMiddleName()+" "%><%=masEmployee.getLastName()%></option>
	<%
						}
					%>
</select>
<div class="Clear"></div>
<label class="noWidth" style="width: 138px;"><span>*</span>
Clinical Notes</label> <input name="clinicalNotes" type="text" class="large2"
	maxlength="50" validate="Clinical Notes,string,yes" />
<div class="Clear"></div>


<div class="Clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=currentDate %></label>

<label>Changed Time</label> <label class="value"><%=currentTime %></label>
<div class="Clear"></div>
<div class="Height10"></div>

<input type="button" name="Submit" class="button" value="Submit"
	onclick="submitForm('specimenDispatchEntry','ot?method=submitOtSpecimenDispatchEntry')" />
<input type="button" name="Back" class="button" value="Back"
	onclick="showBack('specimenDispatchEntry')" /></div>
</form>
</div>

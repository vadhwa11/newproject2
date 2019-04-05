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
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>

<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
	function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
	}
	</script>
<script type="text/javascript">
	
	function showBack(formName)
	{
	  obj = eval('document.'+formName)
	  obj.action = "/hms/hms/ot?method=showOTPatientSearchForDisposalJsp";
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
		List otHumanBodyPartsList= new ArrayList();
		List patientDetailList = new ArrayList();
		List deptList = new ArrayList();
		List empList = new ArrayList();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		Map<String,Object> utilMapForTime = new HashMap<String,Object>();
		
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");	 
		String currentTime = (String)utilMap.get("currentTime");
		
		utilMapForTime = (Map)HMSUtil.getCurrentTimeWithoutSecond();
		String currentTimeWithoutSecond = (String)utilMap.get("currentTime");

		int hospitalId=0;
		int entryNo=0;
		String userName = "";
		String patientName="";
		Map map = new HashMap();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		if(map.get("patientDetailList") != null){
			patientDetailList=(List)map.get("patientDetailList");
		}
		if(map.get("deptList") != null){
			deptList=(List)map.get("deptList");
		}
		if(map.get("empList") != null){
			empList=(List)map.get("empList");
		}
		if(map.get("otHumanBodyPartsList") != null){
			otHumanBodyPartsList=(List)map.get("otHumanBodyPartsList");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		if(map.get("entryNo") != null){
			entryNo = (Integer)map.get("entryNo");
		}
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if(patientDetailList!=null && patientDetailList.size() >0)
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
<form name="humanBodyDisposal" action="" method="post">

<h6>Human Body Parts Disposal Entry</h6>
<div class="Clear"></div>
<div class="header"><label>Entry No</label> <%if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){ OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);%>
<label class="value"><input type="text"
	value="<%=ot.getEntryNo() %>" name="entryNo" readonly /></label> <%}else{ %> <label
	class="value"><input type="text" value="<%=entryNo %>"
	name="entryNo" readonly /></label> <%} %> <label>Date</label> <%if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){ 
		OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);
		String dateOfDispatch=HMSUtil.convertDateToStringWithoutTime(ot.getDispatchDate());
	%> <input type="text" id="dateOfDispatch" name="dateOfDispatch"
	value="<%=dateOfDispatch %>" class="textbox_date" readonly="readonly"
	validate="Date,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16"
	onclick="setdate('<%=currentDate %>',document.humanBodyDisposal.dateOfDispatch,event);"
	border="0" validate="Pick a date" class="calender" /> <%}else{ %> <input
	type="text" id="dateOfDispatch" name="dateOfDispatch"
	value="<%=currentDate %>" class="textbox_date" readonly="readonly"
	validate="Date,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16"
	onclick="setdate('<%=currentDate %>',document.humanBodyDisposal.dateOfDispatch,event);"
	border="0" validate="Pick a date" class="calender" /> <%} %> <!-- <label class="value"><input type="text" value="<%=currentDate %>" name="dateOfDispatch" readonly /></label> -->


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
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label class="medium">HIN No.</label> <%if(patient.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=patient.getHin().getHinNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Patient
Name. </label> <%if(patientName!= null){ %> <label class="valuemedium"><%=patientName %>
</label> <%}else{ %> <label class="valuemedium">- </label> <%} %> <label
	class="medium">Age</label> <%if(patient.getHin().getAge()!= null){ %> <label
	class="valuemedium"><%=patient.getHin().getAge() %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">Patient
Status </label> <%if(patient.getHin().getPatientStatus() != null){ %> <label
	class="valuemedium"><%=patient.getHin().getPatientStatus() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<input name="otBookingId" type="hidden" value="<%=patient.getId()%>" />

<label class="medium">Reg.Date </label> <%if(patient.getHin().getRegDate()!= null){ %>
<label class="valuemedium"><%=HMSUtil.changeDateToddMMyyyy(patient.getHin().getRegDate()) %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <%if(patient.getHin() != null){%>
<input name="hinId" type="hidden" value="<%=patient.getHin().getId()%>" />
<%} %> <input name="departmentId" type="hidden"
	value="<%=patient.getDepartment().getId()%>" /> <%}%>
<div class="Clear"></div>
</div>
<div class="division"></div>
<div class="Clear"></div>
<label class="noWidth" style="width: 138px;"><span>*</span>Tissue/Organ</label>
<%if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){ OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);%>
<input name="tissueOrgan" type="text" value="<%=ot.getTissueOrgan() %>"
	tabindex="1" size="43" maxlength="50" validate="Tissue,string,yes" />
<%}else{ %> <input name="tissueOrgan" type="text" tabindex="1" size="43"
	maxlength="50" validate="Tissue,string,yes" /> <%} %> <label
	class="noWidth" style="width: 153px;"><span>*</span>Time of
dispatch</label> <%if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){ OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);%>
<input id="timeOfDispatch" name="timeOfDispatch"
	value="<%=ot.getTimeOfDispatch()%>" type="text" tabindex="10"
	maxlength="5" validate="Time,string,yes"
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	onblur="IsValidTimeWithBlankCheck(this.value,this.id)" /> <%}else{ %> <input
	type="text" name="timeOfDispatch" id="timeOfDispatch"
	validate="Time,string,yes" value=""
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	onblur="IsValidTimeWithBlankCheck(this.value,this.id)" maxlength="5" />
<%} %>
<div class="Clear"></div>

<label class="noWidth"><span>*</span>Specimen Received By</label> <select
	id="empId" name="empId" validate="Specimen Received By,string,yes"
	tabindex="2">
	<option value="0">Select</option>
	<%
					
					   Iterator itr= empList.iterator();
						while(itr.hasNext()){
						   MasEmployee masEmployee=(MasEmployee)itr.next();
						   int empId=masEmployee.getId();
						   String empName="";
						   if(masEmployee.getFirstName()!= null){
							   empName=masEmployee.getFirstName();
						   }
						   if(masEmployee.getMiddleName()!= null){
							   empName=empName+" "+masEmployee.getMiddleName();
						   }
							if(masEmployee.getLastName()!= null){
								empName= empName+" "+masEmployee.getLastName();
							}
							if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){
								OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);
								int specimenRecievedBy=ot.getSpecimenRecievedBy().getId();
								if(specimenRecievedBy==empId){
					%>
	<option value="<%=empId %>" selected><%=empName %></option>
	<%}else{%>
	<option value="<%=empId %>"><%=empName %></option>
	<%}}else{%>
	<option value="<%=empId %>"><%=empName %></option>
	<%}} %>
</select> <label class="noWidth"><span>*</span>Specimen Dispatched By</label> <select
	id="deptId" name="deptId" validate="Specimen Dispatch By,string,yes"
	tabindex="2">
	<option value="0">Select</option>
	<%
					  Iterator itr1= deptList.iterator();
					while(itr1.hasNext()){
						MasDepartment masDepartment= (MasDepartment)itr1.next();
						int deptId=masDepartment.getId();
						String deptName=masDepartment.getDepartmentName();
						if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){
							OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);
							int specimenDispatchedBy=ot.getSpecimenDispatchedBy().getId();
							if(specimenDispatchedBy==deptId){
					%>
	<option value="<%=deptId %>" selected><%=deptName %></option>
	<%}else{ %>
	<option value="<%=deptId %>"><%=deptName %></option>
	<%}}else{ %>
	<option value="<%=deptId %>"><%=deptName %></option>
	<%}} %>
</select> <label class="noWidth"><span>*</span>Clinical Notes</label> <%if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){ OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);%>
<input name="clinicalNotes" type="text"
	value="<%=ot.getClinicalNotes() %>" tabindex="2" maxlength="50"
	validate="Clinical Notes,string,yes" /> <%}else{ %> <input
	name="clinicalNotes" type="text" tabindex="2" maxlength="50"
	validate="Clinical Notes,string,yes" /> <%} %>
<div class="Clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=currentDate %></label>

<label>Changed Time</label> <label class="value"><%=currentTime %></label>
<div class="Clear"></div>
<div class="Height10"></div>

<%if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){
		OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);%>
<input id="disposalId" name="disposalId" type="hidden"
	value="<%=ot.getId()%>" /> <input type="button" name="Update"
	class="button" value="Update"
	onclick="submitForm ('humanBodyDisposal','ot?method=updateHumanBodyPartsDisposal')" />
<%}else{ %> <input type="button" name="Submit" class="button"
	value="Submit"
	onclick="submitForm ('humanBodyDisposal','ot?method=submitHumanBodyPartsDisposal')" />
<%} %> <input type="button" name="Back" class="button" value="Back"
	onclick="showBack('humanBodyDisposal')" /> <input name="userName"
	id="userName" type="hidden" value="<%=userName %>" /> <input
	name="entryNo" type="hidden" value="<%=entryNo%>" /> <input
	name="hospitalId" type="hidden" value="<%=hospitalId%>" /> <input
	name="changedDate" type="hidden" value="<%=currentDate %>" /> <input
	name="changedTime" type="hidden" value="<%=currentTime %>" /></div>
</form>
</div>

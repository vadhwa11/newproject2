<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.OpdVaccinMst"%>
<%@page import="jkt.hms.masters.business.OpdVaccinationPlan"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<%--For AutoComplete Through Ajax--%>


<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Patient Allergic Drug</title>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<script type="text/javascript">
	ddaccordion.init({
		headerclass: "expandable", //Shared CSS class name of headers group that are expandable
		contentclass: "categoryitems", //Shared CSS class name of contents group
		revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
		collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
		defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
		onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault: false, //Should contents open by default be animated into view?
		persiststate: true, //persist state of opened contents within browser session?
		toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed: "normal", //speed of animation: "fast", "normal", or "slow"
		oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})
</script>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">


function checkDate(rowVal){

	var vDate = document.getElementById('totalId'+rowVal).value ;
	var dobDate = document.getElementById('startDateId').value ;
	var cDate = document.getElementById('completionDate'+rowVal).value;
	
	var v = new Date(vDate.substring(6),(vDate.substring(3,5) - 1) ,vDate.substring(0,2));
	var c = new Date(cDate.substring(6),(cDate.substring(3,5) - 1) ,cDate.substring(0,2));
	var d = new Date(dobDate.substring(6),(dobDate.substring(3,5) - 1) ,dobDate.substring(0,2));
	if(cDate != ""){
		if ((c > v) || (c < d))
		{
			alert("Please enter valid completion date.");
			document.getElementById('completionDate'+rowVal).value = "";
			return false;
		}
		else
		{
			return true;
		}
	}
	return true;
}
function callTotal(noOfDays,rowVal){
			
			var dateId = document.getElementById('startDateId').value;
       		var dateOB = new Date(dateId.substring(6),(dateId.substring(3,5) - 1) ,dateId.substring(0,2))
       		var vDate =  new Date(dateOB.getTime() + noOfDays*24*60*60*1000);
       		var mth;
       		var dt;
       		var da = vDate.getDate();
       		var m = vDate.getMonth()+1;
       		if(vDate.getDate() < 10){
       			
       			dt = "0"+da;
       		}
       		else
       		{
       			dt = da;
       		}
       		
       		if(vDate.getMonth()+1 < 10){
       			mth = "0"+m
       		}
       		else
       		{
       			mth = m
       		}
       		
       		document.getElementById('totalId'+rowVal).value =dt+"/"+mth+"/"+vDate.getFullYear();
		
       }

</script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	if (map.get("detailsMap") != null) {
		detailsMap = (Map<String, Object>) map.get("detailsMap");
	}
	int orderhdId = 0;
	String buttonFlag = "";
	List patientDataList = new ArrayList();

	if (map.get("patientDataList") != null) {
		patientDataList = (List) map.get("patientDataList");
	}

	List opdVaccinMstList = new ArrayList();
	if (map.get("opdVaccinMstList") != null) {
		opdVaccinMstList = (List) map.get("opdVaccinMstList");
	}

	List opdVaccinationPlanList = new ArrayList();
	if (map.get("opdVaccinationPlanList") != null) {
		opdVaccinationPlanList = (List) map
				.get("opdVaccinationPlanList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	if (map.get("buttonFlag") != null) {
		buttonFlag = (String) map.get("buttonFlag");

	}

	
	List<MasMedicalExaminationReportOnEntry> medicalList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	MasMedicalExaminationReportOnEntry meddata=new MasMedicalExaminationReportOnEntry();
	if(map.get("medicalList") != null){
		medicalList=(List)map.get("medicalList");
		}
	
	if(medicalList.size()>0)
	{
		meddata=(MasMedicalExaminationReportOnEntry)medicalList.get(0);
	}
	Visit visit = (Visit) patientDataList.get(0);
	int hinId = visit.getHin().getId();
	Patient patient = null;
	patient = (Patient) visit.getHin();

	String patientName = "";
	if (visit.getHin().getPFirstName() != null) {
		patientName = visit.getHin().getPFirstName();
	}
	if (visit.getHin().getPMiddleName() != null) {
		patientName = patientName + " "
				+ visit.getHin().getPMiddleName();
	}
	if (visit.getHin().getPLastName() != null) {
		patientName = patientName + " " + visit.getHin().getPLastName();
	}
	String visitDateInString = HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	
	String patientDOBInString="";
	 if(visit.getHin().getDateOfBirth()!= null){
		 patientDOBInString =HMSUtil.changeDateToddMMyyyy(visit.getHin().getDateOfBirth());
	 }

	if (map.get("orderhdId") != null) {
		orderhdId = (Integer) map.get("orderhdId");

	}
	String message = "";
	if (map.get("message") != null) {
		message = (String) map.get("message");
	}

%>


<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="pediatricVaccinationPlan" action="" method="post">

<h2><font id="error"><%=message%></font></h2>

<input type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=visit.getDepartment().getId() %>" /> <%
 	if (visit.getDepartment() != null) {
 %>
<div class="floatLeft">
<h6>Pediatric Vaccination Plan</h6>
</div>
<div class="Clear"></div>
<%
	}
%> <!--Block One Starts-->
<h4>Service Personnel Details</h4>
<div class="clear"></div>
<div class="Block">
<% 

if(visit.getHin().getRelation()!=null&&visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self"))
{ %>
<label>Ser No.</label>
 <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>

<label >Rank</label>
<%if(visit.getHin().getRank()!= null){ %>
<label class="value"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>

<label	>Name</label> 
<%if(visit.getHin() != null){
	if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){

					String sMiddleName = "";
					String sLastName = "";
					if(patient.getSMiddleName() != null){
						sMiddleName = patient.getSMiddleName();
					}
					if(patient.getSLastName() != null){
						sLastName = patient.getSLastName();
					}%> <label
	class="value"><%=patient.getSFirstName()+" "+sMiddleName+" "+sLastName %></label> <%}}else{ %> <label class="value"></label>
<%} %>
<div class="clear"></div>
<label>Trade/Branch</label>
 <%if(visit.getHin().getTrade() != null){ %>
<label class="value"><%=visit.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
<label >Age</label> 
<%if(visit.getAge()!= null){ %>
<label class="value"><%=visit.getAge() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>


 <label>Sex</label>
 <%if(visit.getHin().getSex() != null){ %>
<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
 <div class="clear"></div>
 <label>Unit</label>
 <%if(visit.getHin().getUnit() != null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>

<label >Marital Status</label> 
<%if(visit.getHin().getSrMaritalStatus()!= null){ %>
<label class="value"><%=visit.getHin().getSrMaritalStatus().getMaritalStatusName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label>
<%} %> 

<label >Blood Group</label>
<%if(visit.getHin().getBloodGroup() != null){ %>
<label class="value"><%=visit.getHin().getSrBloodGroup().getBloodGroupName() %></label>
<%}else{ %>
<label class="value">&nbsp;</label> <%} %>
<div class="clear"></div>
<label >Med Cat</label>
<%if(meddata.getPresentMedicalCategory() != null){ %>
<label class="value"><%=meddata.getPresentMedicalCategory().getCategories() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>

<label>Med Exam/Date Board</label>
<%if(meddata.getDateOfReporting() != null){ %>
<label class="value"><%=meddata.getDateOfReporting() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
 
<label >Med Disability</label>
<%if(meddata.getPresentDisability()!= null){ %>
<label class="value"><%=meddata.getPresentDisability().getDisability() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
<div class="clear"></div>
<label >Medication</label>
<%if(meddata.getInstructionByPresident() != null){ %>
<label class="value"><%=meddata.getInstructionByPresident() %></label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label >Allergies</label>
<%if(visit.getHin() != null){ %>
<label class="value">&nbsp;</label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>

<label >Visit No. </label> 

<%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label> 
<%}else{ %> 
<label class="value">&nbsp;</label><%} %>
 <% }else{%>
<label	>Patient Name</label> 
<%if(visit.getHin() != null){
		
	if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){

					String sMiddleName = "";
					String sLastName = "";
					if(patient.getSMiddleName() != null){
						sMiddleName = patient.getSMiddleName();
					}
					if(patient.getSLastName() != null){
						sLastName = patient.getSLastName();
					}%> <label
	class="value"><%=patient.getSFirstName()+" "+sMiddleName+" "+sLastName %></label> <%}}else{ %> <label class="value"></label>
<%} %>
<label>Relation</label>
 <%if(visit.getHin().getRelation()!= null){ %>
<label class="value"><%=visit.getHin().getRelation().getRelationName() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>

<label>Ser No.</label>
 <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<div class="clear"></div>
<label >Rank</label>
<%if(visit.getHin().getRank()!= null){ %>
<label class="value"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="value"></label> <%} %>

 <label>Unit</label>
 <%if(visit.getHin().getUnit() != null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>

<label>Trade/Branch</label>
 <%if(visit.getHin().getTrade() != null){ %>
<label class="value"><%=visit.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
 <div class="clear"></div>
<label >Age</label> 
<%if(visit.getAge()!= null){ %>
<label class="value"><%=visit.getAge() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>


 <label>Sex</label>
 <%if(visit.getHin().getSex() != null){ %>
<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
 
 
<label >Occupation</label> 
<%if(visit.getHin().getOccupation()!= null){ %>
<label class="value"><%=visit.getHin().getOccupation().getOccupationName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
 <div class="clear"></div>
<label >Marital Status</label> 
<%if(visit.getHin().getMaritalStatus() != null){ %>
<label class="value"><%=visit.getHin().getMaritalStatus().getMaritalStatusName() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label> 
<%} %> 

<label >Blood Group</label>
<%if(visit.getHin().getBloodGroup() != null){ %>
<label class="value"><%=visit.getHin().getBloodGroup().getBloodGroupName() %></label>
<%}else{ %>
<label class="value">&nbsp;</label> <%} %>

<label >Allergies</label>
<%if(visit.getHin() != null){ %>
<label class="value">&nbsp;</label>
<%}else{ %>
<label class="value">&nbsp;</label><%} %>
 <div class="clear"></div>
<label >Visit No. </label> 

<%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label> 
<%}else{ %> 
<label class="value">&nbsp;</label><%} %>

<% }%>
<div class="clear"></div>
</div>
<div class="Clear"></div>
<!--Block one Ends-->

<div class="Clear"></div>


<label>Vaccination</label> 
<input TYPE="radio" VALUE="c" NAME="<%=VACCINE_TYPE %>" class="radioCheck" />
<label>Compulsory</label> 
<input TYPE="radio" VALUE="o" NAME="<%=VACCINE_TYPE %>" class="radioCheck" /> 
<label>Optional</label> 
<input TYPE="radio" VALUE="a" NAME="<%=VACCINE_TYPE %>" CHECKED class="radioCheck" />
<label>All</label> 
<div class="clear"></div>
<script type="text/javascript" src="date-nl-BE.js"></script> 
<label>Date Of Birth</label> <%if(visit.getHin().getDateOfBirth()!=null){ %>


<input type="text" class="calDate" id="startDateId"  name="<%=DATE_OF_BIRTH %>" value="<%=patientDOBInString %>" readonly="readonly" MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('',document.pediatricVaccinationPlan.<%=DATE_OF_BIRTH%>,event)" />

<%}else{ %> <label class="value">- </label> <%} %>


<div class="Clear"></div>
<div class="division"></div>
<div class="tableHholderCmnLarge">
<%
	if (opdVaccinMstList.size() > 0
			&& opdVaccinationPlanList.size() == 0) {
		Iterator itr = opdVaccinMstList.iterator();
%>
<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>

			<th width="7%">Vaccine</th>
			<th width="10%">No. of Days</th>
			<th width="10%">Vaccine Date</th>
			<th width="7%">Completion Date</th>
			<th width="7%">Remarks</th>
		</tr>
	</thead>
	<%
		int i = 1;
			while (itr.hasNext()) {
				OpdVaccinMst opdVaccinMstObj = (OpdVaccinMst) itr.next();
	%>
	<tbody>


		<tr>
			<td width="7%">
			<input type="text" tabindex="1" name="<%=VACCINE_NAME%>" value="<%=opdVaccinMstObj.getVaccinName() %>" id="vaccineCode<%=i %>" validate="Vaccine,string,no" readonly />
			</td>

			<td width="10%">
			<input type="text" value="<%=opdVaccinMstObj.getVaccinDuration() %>" size="30" validate="Vaccin Duration,string,no" readonly="readonly" tabindex="1" id="noOfdays<%=i %>" name="<%=NO_OF_DAYS %>" onblur="callTotal(this.value,<%=i %>);" />
			</td>
			
			<td width="10%"><input type="text" value="" id="totalId<%=i %>" size="30" validate="Vaccine Date" tabindex="1" name="<%=VACCINE_DATE %>" readonly="readonly" /></td>
			<input type="hidden" value="<%=opdVaccinMstObj.getId() %>" 	name="<%=VACCINE_ID%>" id="vaccineId<%=i %>"  validate="Vaccine Id,num,no" />
			</td>
						
			<td width="7%">
			<input type="text" onblur="checkDate(<%=i %>);" class="calDate" id="completionDate<%=i %>"	name="<%=COMPLETION_DATE %>" value="" readonly="readonly"	MAXLENGTH="30" />
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onClick="setdate('',document.getElementById('completionDate<%=i %>'),event)" onblur="checkDate(<%=i %>);" />
			</td>

			<td width="7%">
			<input type="text" id="remarks<%=i %>" tabindex="1" name="<%=REMARKS %>" value="" maxlength="50" validate="Remarks,String,no" />
			</td>
		</tr>

		<%
			i++;
				}
		%>
	</tbody>

</table>
</div>




<div class="division"></div>


<input type="hidden" name="<%=HIN_ID %>" value="<%=visit.getHin().getId() %>">
<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<input type="hidden" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>">

<div class="bottom">
<label>Changed By:</label> <label class="value"><%=userName%></label> 
<label>Changed Date:</label> <label class="value"><%=date%></label>
<label>Changed Time:</label> <label class="value"><%=time%></label>

<div class="Clear"></div>

<input type="button" class="button" value="Submit" onclick="submitForm('pediatricVaccinationPlan','opd?method=addPediatricVaccinationPlan');" align="right" /> 
<%
 	} else if (opdVaccinMstList.size() > 0
 			&& opdVaccinationPlanList.size() != 0) {
 		Iterator itrObj = opdVaccinationPlanList.iterator();
 %>


<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>

			<th width="7%">Vaccine</th>
			<th width="10%">No. of Days</th>
			<th width="10%">Vaccine Date</th>
			<th width="7%">Completion Date</th>
			<th width="7%">Remarks</th>
		</tr>
	</thead>
	<%
		int i = 1;
			while (itrObj.hasNext()) {
				OpdVaccinationPlan opdVaccinMstObj = (OpdVaccinationPlan) itrObj
						.next();
	%>
	<tbody>


		<tr>
			<td width="7%"><input type="hidden" name="<%=VACCINATION_ID %>"
				value="<%=opdVaccinMstObj.getId() %>" id="vaccinationId<%=i %>">
			<input type="hidden"
				value="<%=opdVaccinMstObj.getVaccin().getId() %>"
				name="<%=VACCINE_ID%>" id="vaccineId<%=i %>"
				validate="Vaccine Id,num,no" /> <input type="text" tabindex="1"
				name="<%=VACCINE_NAME%>"
				value="<%=opdVaccinMstObj.getVaccin().getVaccinName() %>"
				id="vaccineCode<%=i %>" validate="Vaccine,string,no" readonly /></td>
			<td width="10%"><input type="text"
				value="<%=opdVaccinMstObj.getVaccin().getVaccinDuration() %>"
				size="30" validate="Vaccin Duration,string,no" readonly="readonly"
				tabindex="1" id="noOfdays<%=i %>" name="<%=NO_OF_DAYS %>"
				onblur="callTotal(this.value,<%=i %>);" /></td>
			<td width="10%">
			<%
				if (opdVaccinMstObj.getVaccinDate() == null) {
			%> <input type="text" value="" id="totalId<%=i %>" size="30"
				validate="Vaccine Date" tabindex="1" name="<%=VACCINE_DATE %>"
				readonly="readonly" /> <%
 	} else {
 %> <input type="text"
				value="<%=HMSUtil.changeDateToddMMyyyy(opdVaccinMstObj.getVaccinDate()) %>"
				id="totalId<%=i %>" size="30" validate="Vaccine Date" tabindex="1"
				name="<%=VACCINE_DATE %>" readonly="readonly" /> <%
 	}
 %>
			</td>

			<td width="7%">
			<%
				if (opdVaccinMstObj.getVaccinCompleteDate() == null) {
			%> <input type="text" onblur="checkDate(<%=i %>);" class="calDate"
				id="completionDate<%=i %>" name="<%=COMPLETION_DATE %>" value=""
				readonly="readonly" MAXLENGTH="30" /> <img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date"
				onClick="setdate('',document.getElementById('completionDate<%=i %>'),event)"
				onblur="checkDate(<%=i %>);" /> <%
 	} else {
 %> <input type="text" id="completionDate<%=i %>" tabindex="1"
				name="<%=COMPLETION_DATE %>"
				value="<%=HMSUtil.changeDateToddMMyyyy(opdVaccinMstObj.getVaccinCompleteDate()) %>"
				readonly="readonly" /> <%
 	}
 %>
			</td>
			<td width="7%">
			<%
				if (opdVaccinMstObj.getRemarks() == null) {
			%> <input type="text" id="remarks<%=i %>" tabindex="1"
				name="<%=REMARKS %>" validate="Remarks,String,no" maxlength="50" />

			<%
				} else {
			%> <input type="text" id="remarks<%=i %>" tabindex="1"
				name="<%=REMARKS %>" value="<%=opdVaccinMstObj.getRemarks() %>"
				validate="Remarks,String,no" maxlength="50" /> <%
 	}
 %>
			</td>

		</tr>

		<%
			i++;
				}
		%>
	</tbody>

</table>
</div>

<div class="division"></div>


<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> <input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>">

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label>

<div class="Clear"></div>



<label></label><label></label> 
<input type="button" class="button"	value="Update"	onclick="submitForm('pediatricVaccinationPlan','opd?method=updatePediatricVaccinationPlan');"	align="right" />
	 <% 	} else { %> 
	 <label> No Records !!!</label> <% 	} %> 
	 <input	name="Back" type="button" src="images/phaseII/delete.gif" alt="Back" value="Back" class="button" onclick="submitForm('pediatricVaccinationPlan','opd?method=showPediatricCaseSheetJsp&visitId=<%=visit.getId() %>');"
	align="right" /></div>
</form>
</div>


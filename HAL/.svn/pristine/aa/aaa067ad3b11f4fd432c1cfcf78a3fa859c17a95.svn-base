<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdVaccinationPlan"%>
<%@page import="jkt.hms.masters.business.OpdCaseSheet"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" src="/hms/jsp/js/phase2/tabcontent.js">
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<%--For AutoComplete Through Ajax--%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
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
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">

function patientVisitPrev()
{
	var visitNo =document.getElementById('visitNo').value;
	if(visitNo==1)
	{
		alert("Not Before Visit Number");
		return false;
	}
	return true;
	

}

function patientVisitNext()
{
	var visitId =document.getElementById('visitId').value;
	var visitIdM =document.getElementById('max').value;
	if(visitId==visitIdM)
	{
		alert("Not After Visit Number");
		return false;
	}
	return true;
	

}

</script>
<script type="text/javascript">

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

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

<!--main content placeholder starts here-->

<div id="contentHolder">
<form name="pediatricCaseSheet" action="" method="post">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	List<Visit> patientDataList = new ArrayList<Visit>();
	List<OpdCaseSheet> opdCaseSheetList = new ArrayList<OpdCaseSheet>();
	
	int max=0;
	if(map.get("max") != null){
		max = (Integer)map.get("max");
	}
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	
	if(map.get("patientDataList") != null){
		patientDataList=(List<Visit>)map.get("patientDataList");
	}	
	if(map.get("opdCaseSheetList") != null){
		opdCaseSheetList=(List<OpdCaseSheet>)map.get("opdCaseSheetList");
	}	
	int currentVisitId = 0;
	if(map.get("currentVisitId") != null){
		currentVisitId = (Integer)map.get("currentVisitId");
	}
	 List opdVaccinationPlanList = new ArrayList();
		if(map.get("opdVaccinationPlanList") != null){
			opdVaccinationPlanList=(List)map.get("opdVaccinationPlanList");
		}
%> <%

	Visit visit = new Visit();
	if(patientDataList.size() > 0){
		visit = patientDataList.get(0);
	}

	String patientName="";
	if(visit.getHin().getPFirstName()!= null){
		patientName=visit.getHin().getPFirstName();
	}
	if(visit.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+visit.getHin().getPMiddleName();
	}
	if(visit.getHin().getPLastName()!= null){
		patientName=patientName+" "+visit.getHin().getPLastName();
	}
	 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	String patientDOBInString="";

	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if(map.get("employeeList") != null){
			employeeList = (List<MasEmployee>) map.get("employeeList");
	}

	
%> <!--main content placeholder starts here--> <input type="hidden"
	name="<%=DEPARTMENT_ID %>" value="<%=visit.getDepartment().getId() %>" />


<%if(visit.getDepartment()!= null){ %>
<div class="floatLeft">
<h6>Pediatric Case Sheet</h6>
</div>
<div class="Clear"></div>
<%} %> <!--Block One Starts-->

<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service </label> <%if(visit.getHin().getServiceType()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Service No.</label> <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getServiceNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">
Serv. Status </label> <%if(visit.getHin().getServiceStatus()!= null){ %> <label
	class="valuemedium"><%=visit.getHin().getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Name</label> <%if(patientName != null){ %> <label
	class="value"><%=patientName %></label> <%}else{ %> <label class="value">-</label>
<%} %>
<div class="Clear"></div>

<label class="medium">Relation</label> <%if(visit.getHin().getRelation() != null){ %>
<label class="valuemedium"><%=visit.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Rank</label> <%if(visit.getHin().getRank()!= null){ %> <label
	class="valuemedium"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit</label> <%if(visit.getHin().getUnit()!= null && !visit.getHin().getUnit().getUnitName().equals("")){ %>
<label class="valuemedium"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit Address</label> <% if(visit.getHin().getUnit()!= null&& !visit.getHin().getUnit().getUnitAddress().equals("")){ %>
<label class="valuemedium"><%=visit.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>
<label class="medium">Tel No.</label> <% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
<label class="valuemedium"><%=visit.getHin().getMobileNumber() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>

<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label class="medium">HIN No.</label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getHinNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Age</label>
<%if(visit.getHin().getAge()!= null){ %> <label class="valuemedium"><%=visit.getHin().getAge() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Visit Date </label> <%if(visitDateInString != null){ %> <label
	class="valuemedium"><%=visitDateInString %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">Visit
no. </label> <%if(visit.getVisitNo()!= null){ %> <label class="valuemedium"><%=visit.getVisitNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>


<label class="medium">Token No. </label> <%if(visit.getTokenNo()!= null){ %>
<label class="valuemedium"><%=visit.getTokenNo() %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">ECHS
No. </label> <%if(visit.getHin().getEchsNo()!= null){ %> <label
	class="valuemedium"><%=visit.getHin().getEchsNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Patient
Name</label> <%if(patientName!= null){ %> <label class="value"><%=patientName %>
</label> <%}else{ %> <label class="value">- </label> <%} %> <label class="medium">Prev.
Diag </label> <%if(visit.getDiagnosis()!= null){ %> <label class="valueNoWidth"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>

<div class="Clear"></div>

</div>

<!--Block one Ends--> <% 
if(opdCaseSheetList.size() > 0){
	
	OpdCaseSheet opdCaseSheet = new OpdCaseSheet();
	opdCaseSheet = opdCaseSheetList.get(0);
	if(visit.getHin().getDateOfBirth()!= null){
		patientDOBInString =HMSUtil.changeDateToddMMyyyy(opdCaseSheet.getDob());
	}

	
	 
	%> <!--Block one Ends-->
<div class="Clear"></div>
<div class="floatRight">
<div class="colB">
<div class="Clear"></div>
<h5>Vaccine Plan</h5>
<div class="Clear"></div>
<div class="Height10"></div>

<div class="tableHolderAuto">
<%
if(opdVaccinationPlanList.size()!=0) { 
Iterator itrObj=opdVaccinationPlanList.iterator();
%>


<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">
	<tr>

		<th width="7%">Vaccine</th>
		<th width="10%">Vaccine Date</th>
		<th width="7%">Completion Date</th>
		<th width="7%">Remarks</th>
	</tr>

	<%      int i=1;
while(itrObj.hasNext())
{
OpdVaccinationPlan opdVaccinMstObj=(OpdVaccinationPlan)itrObj.next();


%>



	<tr>
		<td width="7%"><input type="hidden" name="<%=VACCINATION_ID %>"
			value="<%=opdVaccinMstObj.getId() %>" id="vaccinationId<%=i %>">
		<input type="hidden" value="<%=opdVaccinMstObj.getVaccin().getId() %>"
			name="<%=VACCINE_ID%>" id="vaccineId<%=i %>"
			validate="Vaccine 

Id,num,no" /> <input type="text" size="12"
			tabindex="1" name="<%=VACCINE_NAME%>"
			value="<%=opdVaccinMstObj.getVaccin().getVaccinName() %>"
			id="vaccineCode<%=i %>" validate="Vaccine,string,no" readonly /></td>

		<td width="10%">
		<%if(opdVaccinMstObj.getVaccinDate()==null)
	{
	%> <input type="text" value="" id="totalId<%=i %>" size="8"
			validate="Vaccine Date" tabindex="1" name="<%=VACCINE_DATE 

%>"
			readonly="readonly" /> <%} else{%> <input type="text"
			value="<%=HMSUtil.changeDateToddMMyyyy(opdVaccinMstObj.getVaccinDate()) %>"
			id="totalId<%=i %>" size="8" validate="Vaccine Date" tabindex="1"
			name="<%=VACCINE_DATE %>" readonly="readonly" /> <%} %>
		</td>


		<td width="7%">
		<%if(opdVaccinMstObj.getVaccinCompleteDate()==null)
{
%> <input type="text" id="CompletionDate<%=i %>" tabindex="1"
			name="<%=COMPLETION_DATE %>" value="" readonly="readonly"
			onblur="checkDate

(<%=i %>)" size="8" /> <%} else{%> <input
			type="text" id="CompletionDate<%=i %>" tabindex="1"
			name="<%=COMPLETION_DATE %>"
			value="<%=HMSUtil.changeDateToddMMyyyy(opdVaccinMstObj.getVaccinCompleteDate()) %>"
			readonly="readonly" onblur="checkDate(<%=i %>)" size="8" /> <%} %>
		</td>
		<td width="7%">
		<%if(opdVaccinMstObj.getRemarks()==null)
{
%> <input type="text" id="remarks<%=i %>" tabindex="1"
			name="<%=REMARKS %>" value="" size="10" readonly="readonly"
			validate="Remarks,String,no" /> <%} else{%> <input type="text"
			id="remarks<%=i %>" size="10" tabindex="1" name="<%=REMARKS %>"
			value="<%=opdVaccinMstObj.getRemarks() %>" readonly="readonly"
			validate="Remarks,String,no" /> <%} %>
		</td>

	</tr>

	<%
i++;}
}  else {
%>

</table>

<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">
	<tr>

		<th width="7%">Vaccine</th>
		<th width="10%">Vaccine Date</th>
		<th width="7%">Completion Date</th>
		<th width="7%">Remarks</th>
	</tr>

	<tr>
		<td width="7%"><input type="text" tabindex="1"
			name="<%=VACCINE_NAME%>2" value="" size="12" id="vaccineCode"
			validate="Vaccine,string,no" readonly /></td>

		<td width="10%"><input type="text" value="" id="totalId" size="8"
			validate="Vaccine Date" tabindex="1" name="<%=VACCINE_DATE %>"
			readonly="readonly" /></td>

		<td width="7%"><input type="text" id="CompletionDate"
			tabindex="1" name="<%=COMPLETION_DATE %>" value="" size="8"
			readonly="readonly" /></td>
		<td width="7%"><input type="text" id="remarks" tabindex="1"
			name="<%=REMARKS %>" value="" readonly="readonly"
			validate="Remarks,String,no" size="10" /></td>
		<%}%>


	</tr>
</table>


</div>
</div>

</div>



<div class="Clear"></div>
<div class="Height10"></div>
<div class="blockFrame"><label>Date of Birth</label> <%if(opdCaseSheet.getDob()!=null){ %>
<input type="text" class="calDate" id="startDateId"
	name="<%=DATE_OF_BIRTH %>" value="<%=patientDOBInString %>"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=patientDOBInString %>',document.pediatricCaseSheet.<%=DATE_OF_BIRTH%>,event)" />
<%}else{ %> <input type="hidden" class="calDate" id="startDateId"
	name="<%=DATE_OF_BIRTH %>" value="" readonly="readonly" MAXLENGTH="30" />
<label class="value">-</label> <%} %> <label>Referred By</label> <select
	id="b2" name="<%=EMPLOYEE_ID %>" validate="Refered By,string,no">
	<option value="0">Select</option>
	<%
							for (MasEmployee masEmployee : employeeList) {
						%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+ masEmployee.getMiddleName()+" " + masEmployee.getLastName()%></option>
	<%
						}
					%>
</select> <%if(opdCaseSheet.getReferedBy()!=null){ %> <script
	type="text/javascript">
		document.getElementById('b2').value='<%=opdCaseSheet.getReferedBy().getId()%>';	
	</script> <%}%>
<div class="Clear"></div>

<label>Wt</label> <input type="text" id="b10" name="<%=WEIGHT %>"
	value="<%=opdCaseSheet.getWt() %>" class="small" validate="Wt,num,no"
	MAXLENGTH="4" tabindex="1" /><label class="unit">(19.8-39.7)</label> <label>Ht</label>
<input type="text" id="b11" name="<%=HEIGHT %>"
	value="<%=opdCaseSheet.getHt() %>" class="small" validate="Ht,num,no"
	MAXLENGTH="4" tabindex="1" /><label class="unit">(119-144)</label> <label>Hc</label>
<input type="text" id="b12" name="<%=HIV %>"
	value="<%=opdCaseSheet.getHc() %>" class="small" validate="Hc,num,no"
	MAXLENGTH="4" tabindex="1" /><label class="unit">(119-144)</label>


<div class="Clear"></div>

<label>OFC</label> <input type="text" id="b22" name="<%=OFC%>"
	class="calDate" validate="OFC,float,no" MAXLENGTH="5"
	value="<%=opdCaseSheet.getOfc()%>" tabindex="1" /><label class="unit">cm</label>

<label>RR</label> <input type="text" id="b23" name="<%=RR%>"
	class="calDate" validate="RR,float,no"
	value="<%=opdCaseSheet.getRr()%>" MAXLENGTH="5" tabindex="1" /><label
	class="unit">min</label></div>

<div class="division"></div>
<ul id="countrytabs" class="shadetabs1">
	<li><a href="#" rel="country1" class="selected1">Clinical
	Notes</a></li>
	<li><a href="#" rel="country2">Exp. HT</a></li>
	<li><a href="#" rel="country3">BMI</a></li>
</ul>

<div class="tabContainer">

<div id="country1" class="tabcontent1"><label></label> <textarea
	maxlength="1000" onkeyup="return ismaxlength(this)"
	name="<%=CLINICAL_NOTE %>" id="b1"><%=opdCaseSheet.getClinicalNote() %></textarea>
<div class="Clear"></div>

</div>

<div id="country2" class="tabcontent1">
<div class="paddLeft25"><label class="common">Father</label><!--------><label
	class="common">Mother</label></div>
<div class="Clear"></div>
<label>Height in CM</label><!--------> <input id="b3" type="text"
	maxlength="3" value="<%=opdCaseSheet.getHeightInCmFather() %>"
	name="<%=HEIGHT_IN_CM_FATHER %>" class="calDate"
	validate="Height in CM Father,num,no" />
<div class="paddLeft55"><input id="b4" type="text"
	name="<%=HEIGHT_IN_CM_MOTHER %>"
	value="<%=opdCaseSheet.getHeightInCmMother() %>" maxlength="3"
	class="calDate" validate="Height in CM Mother,num,no" /></div>
<div class="Clear"></div>
<label>Child's Age</label> <input id="b5" type="text"
	value="<%=opdCaseSheet.getAge() %>" maxlength="2" name="<%=AGE %>"
	class="calDate" validate="Child's Age,num,no" />
<div class="paddLeft55"><input type="button" class="cmnButton"
	value="Calculate" onclick="calculated();" /></div>
<input type="button" class="cmnButton" value="History"
	onclick="submitForm('pediatricCaseSheet','opd?method=showPatientHistoryJsp&visitId=<%=visit.getId() %>');" />
<div class="Clear"></div>
<div class="Height10"></div>


<div class="paddLeft25"><label class="common">Child</label></div>
<div class="Clear"></div>
<div class="Height10"></div>
<label>Height in CM</label> <input id="b6" type="text"
	name="<%=HEIGHT_IN_CM_CHILD %>"
	value="<%=opdCaseSheet.getHeightInCmChild() %>" maxlength="3"
	class="calDate" validate="Height in CM Child,num,no" />
<div class="Clear"></div>
<label>3rd Percentile</label> <input id="b7" type="text"
	name="<%=RD_PERCENDTILE %>"
	value="<%=opdCaseSheet.getRdPercentile() %>" maxlength="20"
	class="calDate" validate="3rd Percentile,num,no" />
<div class="Clear"></div>
<label>97th Percentile</label> <input id="b8" type="text"
	name="<%=TH_PERCENDTILE %>"
	value="<%=opdCaseSheet.getThPercentile() %>" maxlength="20"
	class="calDate" validate="97th Percentile,num,no" />
<div class="Clear"></div>
<label>Remarks</label> <input id="b9" type="text" value="<%=opdCaseSheet.getRemarks() %>" name="<%=REMARKS_TEMP %>" maxlength="50" />
	
<div class="Clear"></div>
</div>


<div id="country3" class="tabcontent1">
<div class="paddLeft25"><label class="valuenoWidth"> <u>Body
mass index (BMI)</u> is measure of body fat based on height and weight that
applies to both adult men and women. </label>
<div class="Clear"></div>
<label class="valuenoWidth"> <b><u>BMI Categories</u></b> </label>
<div class="Clear"></div>

<li>Normal weight = 18.5-24.9</li>
<li>Overweight = 25-29.9</li>
<li>Obesity = BMI of 30 or greater</li>

</div>

<TABLE WIDTH="600" CELLPADDING="0" CELLSPACING="0" BORDER="0"
	SUMMARY="This table is used for layout purposes only.">
	<TR>
		<TD ALIGN="LEFT"></TD>
	</TR>
	<TR>
		<TD COLSPAN="2" ALIGN="LEFT"></TD>
	</TR>
</TABLE>
<div class="Clear"></div>
<TABLE WIDTH="600"
	SUMMARY="This table is used for layout purposes only.">
	<TR>
		<TD>
		<TABLE BORDER="0" CELLSPACING="0" WIDTH="185" BGCOLOR="#FFFFFF"
			CELLPADDING="2"
			SUMMARY="This table is used for layout purposes only.">
			<TR>
				<TD COLSPAN="2" ALIGN="center">
				<TABLE CELLSPACING="0" CELLPADDING="0" BORDER="0" WIDTH="143"
					SUMMARY="This table is used for layout purposes only.">
					<TR>
						<TD ROWSPAN="3" ALIGN="right" WIDTH="50"><IMG
							SRC="/hms/jsp/images/phaseII/bmi_1-4.gif" ALT=" " WIDTH="36"
							HEIGHT="201"></TD>
						<TD VALIGN="top" WIDTH="50"><img
							src="/hms/jsp/images/phaseII/bmi_2-4.gif" alt=" " width="50"
							height="76" /></TD>
						<TD ROWSPAN="3" ALIGN="left" WIDTH="92"><IMG
							SRC="/hms/jsp/images/phaseII/bmi_4-4.gif" ALT=" " WIDTH="57"
							HEIGHT="201"></TD>
					</TR>
					<TR>
						<TD ALIGN="center"><INPUT NAME="bmiS" TYPE="text"
							value="<%=opdCaseSheet.getBmi()%>" readonly="readonly" SIZE="10"
							STYLE="width: 30px; float: none;" id="yourbmi"></TD>
					</TR>
					<TR>
						<TD VALIGN="bottom"><img
							src="/hms/jsp/images/phaseII/bmi_3-4.gif" alt=" " width="50"
							height="96" /></TD>
					</TR>
				</TABLE>
				</TD>
			</TR>
			<TR>
				<TD WIDTH="50%"><SPAN STYLE="font-size: 10pt;"><B><LABEL
					FOR="htcS">&nbsp;Your Height:</LABEL></B></SPAN></TD>
				<TD WIDTH="50%" ALIGN="left"><INPUT TYPE="text" NAME="htcS"
					size="3" ID="htcS" MAXLENGTH="4" value=""
					validate="Height,num,no" onblur="heightValidation1();"
					onmousedown="heightValidation1();"></TD>
			</TR>
			<TR>
				<TD WIDTH="50%"><SPAN STYLE="font-size: 10pt;">&nbsp;</SPAN></TD>
				<TD WIDTH="50%" ALIGN="left"><B><SPAN
					STYLE="font-size: 10pt;"> (centimeters)</SPAN></B></TD>
			</TR>
			<TR>
				<TD WIDTH="50%"><SPAN STYLE="font-size: 10pt;"><B><LABEL
					FOR="kgS">&nbsp;Your Weight:</LABEL></B></SPAN></TD>
				<TD WIDTH="50%" ALIGN="left">
				<P><INPUT TYPE="text" NAME="kgS" size="3" MAXLENGTH="4" ID="kgS"
					value="" validate="Weight,num,no"
					onblur="weightValidation1();" onmousedown="weightValidation1();"></P>
				</TD>
			</TR>
			<TR>
				<TD WIDTH="50%"><SPAN STYLE="font-size: 10pt;">&nbsp;</SPAN></TD>
				<TD WIDTH="50%" ALIGN="left"><B><SPAN
					STYLE="font-size: 10pt;"> (kilograms)</SPAN></B></TD>
			</TR>
			<TR>
				<TD COLSPAN="2" ALIGN="center"></TD>
			</TR>
			<TR>
				<TD COLSPAN="2" ALIGN="center"><INPUT TYPE="button"
					class="cmnbutton" VALUE="Compute BMI" ONCLICK="self.computeS();">
				</TD>
			</TR>

		</TABLE>
		<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="10" WIDTH="600">
			<TR>
				<TD VALIGN="top" COLSPAN="3"></TD>
			</TR>
			<TR>
				<TD VALIGN="top"></TD>
				<TD ALIGN="center" VALIGN="top"></TD>
				<TD VALIGN="top"></TD>
			</TR>
			<TR>
				<TD VALIGN="top">&nbsp;</TD>
				<TD ALIGN="center" VALIGN="top"></TD>
				<TD VALIGN="top">&nbsp;</TD>
			</TR>
		</TABLE>
		</TD>
	</TR>
</TABLE>

</div>
</div>
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script> <script type="text/javascript">

var countries1=new ddtabcontent("countrytabs1")
countries1.setpersist(true)
countries1.setselectedClassTarget("link") //"link" or "linkparent"
countries1.init()

</script>

<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>

<input name="prev" type="button" class="button" value="Update"
	onclick="submitForm('pediatricCaseSheet','opd?method=updatePediatricCaseSheet');">

<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('pediatricCaseSheet','opd?method=showPediatricCaseSheetJsp&visitId=<%=currentVisitId %>');"
	align="right" /></div>

<%}%> <input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	id="visitNo" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>">
<input type="hidden" id="max" name="currentVisitId"
	value="<%=currentVisitId %>"> <input type="hidden"
	name="visitId" id="visitId" value="<%=visit.getId() %>"> <input
	type="hidden" name="<%=PEDIATRIC_CASE_SHEET_ID%>"
	id="<%=PEDIATRIC_CASE_SHEET_ID%>" value="<%=opdCaseSheet.getId() %>">
<div class="division"></div>

<script type="text/javascript">
function showVaccination(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/opd?method=showPediatricVaccinationPlanJsp&visitId=<%=visit.getId()%>";
  obj.submit();
}
</script> <%}else{%> <label style="width: auto;"><span>No Record
Found!!</span></label>
<div class="Clear"></div>
<div class="bottom"><input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	id="visitNo" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>">
<input type="hidden" id="currentVisitId" name="currentVisitId"
	value="<%=currentVisitId %>"> <input type="hidden"
	name="visitId" id="visitId" value="<%=visit.getId() %>"> <input
	type="hidden" id="max" name="max" value="<%=max %>"> <input
	name="prev" type="button" class="button" value="Prev"
	onclick="submitForm('pediatricCaseSheet','opd?method=viewPediatricCaseSheet&flag=prev','patientVisitPrev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('pediatricCaseSheet','opd?method=viewPediatricCaseSheet&flag=next','patientVisitNext');">
<input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('pediatricCaseSheet','opd?method=showPediatricCaseSheetJsp&visitId=<%=currentVisitId%>');"
	align="right" /></div>

<!--Bottom labels ends--> <%} %>
<div class="Clear"></div>

<label></label><label></label> <script type="text/javascript">

function calculated()
{
	var b3= document.getElementById('b3').value ;
	var b4 = document.getElementById('b4').value ;
	var b5= document.getElementById('b5').value ;
	var cal;
	var cal1;
	var cal2;
	var cal3;
	var b6;
	if((b3!="")&& (b4!="") && (b5!="") )
	{
			
		b3 = parseFloat( b3 );                    
	    b4 = parseFloat( b4 ); 
		
		var cal= b3 + b4;
			                  
    	cal1=(cal + 13)/2;
		document.getElementById('b6').value=cal1; 
		b6 = document.getElementById('b6').value;
		b6 = parseFloat( b6 );                    
	   	
		cal2=(b6)-8;
		cal3=(b6)+8;
		document.getElementById('b7').value=cal2;
		document.getElementById('b8').value=cal3;
		
		return true;
	}
	else if((b3=="")&& (b4!="") && (b5!="") )
	{
		alert("Please give Father Height in CMs ");
	}
	else if((b3!="")&& (b4=="") && (b5!="") )
	{
		alert("Please give Monther Height in CMs ");
	}
	else if((b3!="")&& (b4!="") && (b5=="") )
	{
		alert("Please give Child Age ");
	}
		else if((b3!="")&& (b4=="") && (b5=="") )
	{
		alert("Please give Mother Height in CMs and Child Age ");
	}
	else if((b3=="")&& (b4!="") && (b5=="") )
	{
		alert("Please give Father Height in CMs and Child Age ");
	}
	else if((b3=="")&& (b4=="") && (b5!="") )
	{
		alert("Please give Father and Mother Height in CMs ");
	}
	else
	{
			alert("Please give Both Height in CMs And Child Age ");	
	}
	
}
function computeS(){
   var fS = self.document.pediatricCaseSheet;

   // Set up variables for calculation
   wS = fS.kgS.value;
//   i = parseInt(f.htc.value);
   iS = fS.htcS.value;

   // Do validation checking to ensure existence of values

   if (!chkwS(i)){
     alert("Please enter a number for your height.");
     fS.htcS.focus();
     return;
   }
   if (!chkwS(wS)){
     alert("Please enter a number for your weight.");
     fS.kgS.focus();
     return;
   }

   fS.bmiS.value = cal_bmiS(wS, iS);
   fS.bmiS.focus();
}
function chkwS(wS){
  // if (isNaN(parseInt(wS))){
   if (isNaN(wS)){
	  return false;
   } else if (wS < 0){
  return false;
  }
  else{
  return true;
  }
}

function cal_bmiS(kgS, htcS){


   mS = htcS/100;
   h2S = mS * mS;

   bmiS = kgS/h2S;


   f_bmiS = Math.floor(bmiS);

   diffS  = bmiS - f_bmiS;
   diffS = diffS * 10;

   diffS = Math.round(diffS);
   if (diffS == 10){
      // Need to bump up the whole thing instead
      f_bmiS += 1;
      diffS = 0;
   }
   bmiS = f_bmiS + "." + diffS;

   return bmiS;
}

</script></form>
</div>
</div>
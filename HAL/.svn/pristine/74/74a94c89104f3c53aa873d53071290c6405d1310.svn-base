<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>

<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<script language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></script>

<script language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></script>

<script language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></script>


<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript">

animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

</script>
<script type="text/javascript">
var districtArray=new Array();
function chkLength(field,maxLimit)
   {
   if(field.value.length > maxLimit)
   {
    alert('Maximum Limit is '+maxLimit+' characters.');
    var val=field.value.substring(0,maxLimit);
    field.value=val;
   }
}

function makeChoice(radiobutton)

{
var text = radiobutton.value; 

if( text=="Yes")
{
document.medicalBoardProceeding.<%=DISABILITY_ATTRIBUTABLE_DESC %>.style.display="";
document.getElementById("<%=DISABILITY_ATTRIBUTABLE_LABEL %>").style.display="";
document.medicalBoardProceeding.<%=DISABILITY_ATTRIBUTABLE_DESC %>.focus();
}
else
{
document.medicalBoardProceeding.<%=DISABILITY_ATTRIBUTABLE_DESC %>.style.display="none";
document.getElementById("<%=DISABILITY_ATTRIBUTABLE_LABEL %>").style.display="none";
}
}


function choose(radiobutton)

{
 var text = radiobutton.value; 

if( text=="Yes")
{
document.medicalBoardProceeding.<%=AGGRAVATED_SERVICE_DESC %>.style.display="";
document.getElementById("<%=AGGRAVATED_SERVICE_LABEL %>").style.display="";
document.medicalBoardProceeding.<%=AGGRAVATED_SERVICE_DESC %>.focus();
}
else
{
document.medicalBoardProceeding.<%=AGGRAVATED_SERVICE_DESC %>.style.display="none";
document.getElementById("<%=AGGRAVATED_SERVICE_LABEL %>").style.display="none";
}
}


</script>

</head>
<body>
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
<script>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	   
	</script>



<%	String 	userName="";


String previousPage="no";
int pageNo = 1;
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(session.getAttribute("userName")!=null){
		userName=(String)session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	
	String entryNo="";
	
	if(map.get("medicalEntryNo")!=null)
	{
		entryNo=(String) map.get("medicalEntryNo");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
	
	List<MasMedicalCategory> medicalCategoryList = new ArrayList<MasMedicalCategory>();

	if (map.get("medicalCategoryList") != null) {
		medicalCategoryList = (List) map.get("medicalCategoryList");
	}
	
	List<MasUnit> unitList = new ArrayList<MasUnit>();

	   if (map.get("unitList") != null) {
		   unitList = (List) map.get("unitList");
	   }
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

	if (map.get("employeeList") != null) {
		employeeList = (List) map.get("employeeList");
	}
	
	List<MasDistrict> cityList = new ArrayList<MasDistrict>();

	if (map.get("cityList") != null) {
		cityList = (List) map.get("cityList");
	}
	
	List<MasState> stateList = new ArrayList<MasState>();

	if (map.get("stateList") != null) {
		stateList = (List) map.get("stateList");
	}
	
	List<Patient> patientList = new ArrayList<Patient>();

	if (map.get("patientList") != null) {
	patientList = (List) map.get("patientList");
	}
	
	//List<Inpatient> patientList = new ArrayList<Inpatient>();	
	
	List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();
	
	if(map.get("recordOfficeAddressList") != null)
	{
		recordOfficeAddressList = (List) map.get("recordOfficeAddressList");
	}
	
	%>
<!--main content placeholder starts here-->
<div id="contentHolder">
<h6>Medical Board Proceeding Entry (AFMSF 15)</h6>
<div class="Clear"></div>
<form name="medicalBoardProceeding" action="" method=post><input
	type="hidden" name="<%=POJO_NAME%>" value="MasMedicalBoardProceedings">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="MedicalBoardProceeding"> <input type="hidden"
	name="title" value="Medical Board Proceeding"> <input
	type="hidden" name="<%=JSP_NAME %>" value=medicalBoardProceeding">


<div class="blockFrame">
<div class="Clear"></div>


<label>Entry No.</label> <label class="value"><%=entryNo %></label> <input
	type="hidden" value="<%=entryNo%>" name="<%=ENTRY_NO%>" tabindex="2" />


<label>Entry Date</label> <input tabindex="1" name="<%=ENTRY_DATE %>"
	id="entryDate" type="text" value="<%=date%>" class="calDate"
	validate="Entry Date,date,yes" /> <img height="16" border="0"
	width="16" src="/hms/jsp/images/cal.gif"
	onClick="setdate('<%=date%>',document.medicalBoardProceeding.<%= ENTRY_DATE%>,event);"
	class="calender" /> <label>Hin No.</label> <%if(patientList.size()>0 && patientList.get(0).getHinNo()!=null){%>
<label class="value"><%=patientList.get(0).getHinNo() %></label> <input
	type="hidden" value="<%=patientList.get(0).getHinNo() %>"
	name="<%=HIN_NO%>" tabindex="1" /> <%}else {%> <label class="value">
-</label> <%} %>


<div class="Clear"></div>


<label>Name</label> <%if(patientList.size()>0 && patientList.get(0)!=null) {%>
<%if(patientList.get(0).getPFirstName()!=null && patientList.get(0).getPLastName()!=null){%>
<input type="hidden" value="<%=patientList.get(0).getPFirstName()%>"
	name="<%=P_FIRST_NAME%>" tabindex="1" /> <input type="hidden"
	value="<%=patientList.get(0).getPLastName()%>" name="<%=P_LAST_NAME%>"
	tabindex="1" /> <label class="value"><%=patientList.get(0).getPFirstName()%>
<%=patientList.get(0).getPLastName()%></label> <%}else {%> <label class="value">
-</label> <%   }  %> <label>Service No.</label> <%if(patientList.size()>0 && patientList.get(0).getServiceNo()!=null){%>
<label class="value"><%=patientList.get(0).getServiceNo() %></label> <input
	type="hidden" value="<%=patientList.get(0).getServiceNo() %>"
	name="<%=SERVICE_NO%>" tabindex="1" /> <%}else {%> <label class="value">
-</label> <%} %> <label>Rank</label> <%if(patientList.size()>0 && patientList.get(0).getRank().getRankName()!=null ){%>
<label class="value"><%=patientList.get(0).getRank().getRankName() %></label>
<input type="hidden"
	value="<%=patientList.get(0).getRank().getRankName() %>"
	name="<%=RANK_NAME%>" tabindex="1" /> <%}else {%> <label class="value">-</label>
<%} %>
<div class="Clear"></div>

<label>Unit/Ship</label> <%if(patientList.size()>0 && patientList.get(0).getUnit().getUnitName()!=null ){%>
<label class="value"> <%=patientList.get(0).getUnit().getUnitName()%>-
</label> <input type="hidden"
	value="<%=patientList.get(0).getUnit().getUnitName()%>"
	name="<%=UNIT_NAME%>" tabindex="1" /> <% 
}else {%> <label class="value">-</label> <%} %> <label>Service
Type</label> <%
	    if(patientList.size()>0 && patientList.get(0).getServiceType().getServiceTypeName()!= null){
	    %> <label class="value"> <%=patientList.get(0).getServiceType().getServiceTypeName() %></label>
<input type="hidden"
	value="<%=patientList.get(0).getServiceType().getServiceTypeName()%>"
	name="<%=SERVICE_TYPE_NAME%>" tabindex="1" /> <%
		
		   }else{
		%> <label class="value">-</label> <%} %> <label class="large">Army/
Corps/ Branch/ Trade</label> <%if(patientList.size()>0 && patientList.get(0).getTradeName()!=null ){%>
<label class="value"><%=patientList.get(0).getTradeName() %></label> <input
	type="hidden" value="<%=patientList.get(0).getTradeName() %>"
	name="<%=TRADE_NAME%>" tabindex="1" /> <%}else{ %> <label class="value">
-</label> <%} %>

<div class="Clear"></div>

<label>Age</label> <%if(patientList.size()>0 && patientList.get(0).getAge() !=null ){%>
<label class="value"><%=patientList.get(0).getAge() %></label> <input
	type="hidden" value="<%=patientList.get(0).getAge() %>" name="<%=AGE%>"
	tabindex="1" /> <%}else{ %> <label class="value"> -</label> <%} %> <label>Sex</label>
<%if(patientList.size()>0 && patientList.get(0).getSex().getAdministrativeSexName() !=null ){%>
<label class="value"><%=patientList.get(0).getSex().getAdministrativeSexName() %></label>
<input type="hidden"
	value="<%=patientList.get(0).getSex().getAdministrativeSexName()%>"
	name="<%=SEX%>" tabindex="1" /> <%}else{ %> <label class="value">
-</label> <%} %> <%}else{ %> <%} %> <label>Ceased Duty on</label> <input type="text"
	value="" name="<%=CEASED_DUTY_ON%>" tabindex="1"
	validate="Ceased Duty On," /> <img height="16" border="0" width="16"
	src="/hms/jsp/images/cal.gif"
	onClick="setdate('<%=date%>',document.medicalBoardProceeding.<%= CEASED_DUTY_ON%>,event);"
	class="calender" />

<div class="Clear"></div>
<label>Weight (Kg.) <span>*</span></label> <input name=<%=WEIGHT %>
	type="text" validate="Weight,int,yes" maxlength="10" tabindex="1" /> <label>Height
(Cm.) <span>*</span></label> <input name=<%=HEIGHT %> type="text"
	validate="Height,String,yes" maxlength="10" tabindex="1" />

<div class="Clear"></div>
<label class="large">Date of Commisioning/ Enrollment <span>*</span></label>
<input name=<%=DATE_OF_COMMISSIONING %> value="" type="text"
	tabindex="1" class="calDate" validate="Date of Commisioning,date,yes" />
<img height="16" border="0" width="16" src="/hms/jsp/images/cal.gif"
	onClick="setdate('<%=date%>',document.medicalBoardProceeding.<%= DATE_OF_COMMISSIONING%>,event);"
	class="calender" /> <label class="large">Record Office with
Address <span>*</span></label> <% if(recordOfficeAddressList.size()>0 && recordOfficeAddressList.get(0) != null) {%>
<input name=<%=RECORD_ADDRESS %> tabindex="1"
	value="<%=recordOfficeAddressList.get(0).getAddress() %>" type="text"
	validate="Record Office Address,String,yes" maxlength="50" /> <%}else{ %>
<input name=<%=RECORD_ADDRESS %> tabindex="1" value="" type="text"
	validate="Record Office Address,String,yes" maxlength="50" /> <%}%>
<div class="Clear"></div>
<label class="large">Address On Leave (If Applicable)</label> <textarea
	class="large" name="<%=LOCAL_ADDRESS%>" tabindex="1"
	onkeyup="chkLength(this,500);"></textarea> <label>State</label> <select
	id="<%=STATE %>" name="<%=STATE %>" tabindex="1"
	onChange="populateDistrict(this.value,'medicalBoardProceeding');">
	<option value="0">Select</option>

	<%
				         		if(stateList != null){ 	
				         			for (Iterator iter = stateList.iterator(); iter.hasNext();) {
				         				MasState masState = (MasState) iter.next();
				         %>
	<option value="<%=masState.getId()%>"><%=masState.getStateName()%></option>
	<%		
				        			}
				        		 } 
				        %>
</select> <label>City</label> <select id="<%=DISTRICT %>" name="<%=DISTRICT %>"
	tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(cityList != null){ 	
				         			for (Iterator iter = cityList.iterator(); iter.hasNext();) {
				         				MasDistrict masDistrict = (MasDistrict) iter.next();
				         %>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName()%></option>
	<%		
				        			}
				        		 } 
				        %>
</select>

<div class="Clear"></div>

<div class="Clear"></div>

<div class="Clear"></div>
<label class="large">Past Medical History</label> <textarea
	class="large" name="<%=PAST_MEDICAL_HISTORY %>" tabindex="1"
	onkeyup="chkLength(this,500);"></textarea>
<div class="Clear"></div>

<label class="large2">Medical Category Prior To Present Medical
Board <span>*</span></label> <input tabindex="1" maxlength="40"
	name="<%=MEDICAL_CATEGORY_NAME %>" type="text" /> <!--</div>
<div class="Clear"></div>


<div class="blockTitle"><a href="javascript:animatedcollapse.toggle('slide1')">Click Here >></a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide1">
<div class="blockFrame">-->

<div class="Clear"></div>
<label>Type</label> <label class="unit">Categorisation</label> <input
	type="radio" class="radio" name=<%=MEDICAL_TYPE %>
	value="categorisation" tabindex="1" checked="checked" /> <label
	class="unit">Recategorisation</label> <input type="radio" class="radio"
	name=<%=MEDICAL_TYPE %> value="recategorisation" tabindex="1" /> <label
	class="unit">Sick Leave</label> <input type="radio" class="radio"
	name=<%=MEDICAL_TYPE %> value="sickLeave" tabindex="1" />

<div class="Height10"></div>
<div class="Clear"></div>
</div>

<div class="blockTitle">Board President and Members <a
	href="javascript:animatedcollapse.toggle('slide1')">Click Here >></a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide1">
<div class="blockFrame"><label class="large">Board
President <span>*</span> </label> <select id="employeeCategoryId"
	name=<%=BOARD_PRESIDENT %> tabindex="1"
	validate="Board President,String,yes">
	<option value="0">Select</option>

	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()%>
	<%=masEmployee.getLastName()%></option>
	<%		
				        			}
				        		 } 
				        %>
</select> <label>Member 1 Name <span>*</span> </label> <select
	id="employeeCategoryId" name=<%=MEMBER_1_NAME %>
	validate="Member 1 Name,String,yes" tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()%>
	<%=masEmployee.getLastName()%></option>
	<%		
				        			}
				        		 } 
				        %>
</select> <label>Member 2 Name</label> <select id="employeeCategoryId"
	name=<%=MEMBER_2_NAME %> tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()%>
	<%=masEmployee.getLastName()%></option>
	<%		
				        			}
				        		 } 
				        %>
</select>

<div class="Clear"></div>

</div>
</div>

<div class="division"></div>
<div class="blockTitle">Details of Present &amp; Previous
Disabilities<a href="javascript:animatedcollapse.toggle('slide2')">Click
Here >></a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide2">
<div class="Height10"></div>
<label></label> 
<input type="button" name="service" tabindex="1" class="cmnButton" value="Add" onclick="generateRowMedicalBoard('amcDetailId');" /> 
<input type="button" name="service" tabindex="1" class="cmnButton" value="Remove" onclick="removeRow();" /> 
<input type="hidden" size="2" value="" tabindex="1" name="noOfRecords" id="noOfRecords" />
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" id="amcDetailId" cellspacing="0"
	cellpadding="0">
	<thead>
		<tr>
			<th scope="col">Sr. No.</th>
			<th scope="col">Disabilities (Principles/ Others)</th>
			<th scope="col">Date of Onset</th>
			<th scope="col">Place of Onset</th>
			<th scope="col">Previous Medical Categorisation</th>
			<th scope="col">Previous Medical Categorisation Date</th>
			<th scope="col">Next Medical Categorisation Due Date</th>
		</tr>
	</thead>
	<tbody>

		<tr>

			<td width="5%"><input type="text" size="2" tabindex="1"
				maxlength="2" value="1" name="<%=MEDICAL_BOARD_DETAILS_SRNO%>"
				readonly="readonly" /></td>

			<td width="30%"><input type="text" maxlength="149" tabindex="1"
				value="" name="<%=MEDICAL_BOARD_DISABILITIES%>"
				validate="Disabilities,String,yes"></td>


			<td style="width: 15%"><input type="text" maxlength="12"
				style="width: 75%; float: left; vertical-align: center;" value=""
				name="<%=DATE_OF_ORIGIN%>" tabindex="1"
				validate="Date of Origin,date,yes" /> <img height="16" width="16"
				src="/hms/jsp/images/cal.gif"
				onClick="setdate('<%=date%>',document.medicalBoardProceeding.<%= DATE_OF_ORIGIN%>,event);"
				class="calender" /></td>


			<td width="10%"><input type="text" maxlength="30" value=""
				name="<%=PLACE_OF_ORIGIN%>" tabindex="1"
				validate="Place of Origin,String,yes" /></td>

			<td width="10%"><input tabindex="1" maxlength="40"
				name="<%=PREVIOUS_MEDICAL_CATEGORISATION %>" type="text" /></td>


			<td><input type="text" maxlength="12"
				style="width: 75%; float: left; vertical-align: center;" value=""
				name="<%=PREVIOUS_MEDICAL_CATEGORISATION_DATE%>" tabindex="1"
				validate="Previous medical categorization date,date,no" /> <img
				height="16" width="16" src="/hms/jsp/images/cal.gif"
				onClick="setdate('<%=date%>',document.medicalBoardProceeding.<%= PREVIOUS_MEDICAL_CATEGORISATION_DATE%>,event);"
				class="calender" /></td>



			<td><input type="text" maxlength="12"
				style="width: 75%; float: left; vertical-align: center;" value=""
				name="<%=NEXT_MEDICAL_CATEGORISATION_DUE%>" tabindex="1"
				validate="Next medical categorization due,date,no" /> <img
				height="16" width="16" src="/hms/jsp/images/cal.gif"
				onClick="setdate('<%=date%>',document.medicalBoardProceeding.<%= NEXT_MEDICAL_CATEGORISATION_DUE%>,event);"
				class="calender" /></td>


		</tr>

	</tbody>
	<input type="hidden" name="rows" id="rr" value="1" />
</table>



</div>
</div>


<div class="Clear"></div>

<!--Block Two Starts-->

<div class="division"></div>
<div class="blockTitle">Clinical Summary<a
	href="javascript:animatedcollapse.toggle('slide3')">Click Here >></a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide3">
<div class="blockFrame">
<div class="Clear"></div>
<label class="large">Clinical Summary <span>*</span></label> <textarea
	class="large" name="<%=CLINICAL_SUMMARY %>" tabindex="1"
	validate="Clinical Summary,String,yes" onkeyup="chkLength(this,500);"></textarea>

<div class="Clear"></div>



<label class="large2">Is the disability attributable in service<span>*</span></label>

<label class="small">Yes</label> <input tabindex="1"
	name="<%=DISABILITY_ATTRIBUTABLE_STATUS %>" type="radio" class="radio"
	value="Yes" onclick="makeChoice(this);" /> <label class="small">No</label>
<input tabindex="1" name="<%=DISABILITY_ATTRIBUTABLE_STATUS %>"
	type="radio" checked="true" class="radio" value="No"
	onclick="makeChoice(this);" />
<div class="Clear"></div>
<label id="<%= DISABILITY_ATTRIBUTABLE_LABEL%>" style="display: none">Explain</label>
<textarea tabindex="1" class="large" maxlength="200"
	name="<%=DISABILITY_ATTRIBUTABLE_DESC %>" style="display: none"
	onkeyup="chkLength(this,200);"></textarea>

<div class="Clear"></div>

<label class="large2">If not directly attributable to service,
was it aggravated by service<span>*</span></label> <label class="small">Yes</label>
<input tabindex="1" name="<%=AGGRAVATED_SERVICE_STATUS %>" type="radio"
	class="radio" value="Yes" onclick="choose(this);"> <label
	class="small">No</label> <input tabindex="1"
	name="<%=AGGRAVATED_SERVICE_STATUS %>" type="radio" class="radio"
	value="No" onclick="choose(this);" checked="true" />
<div class="Clear"></div>
<label id="<%= AGGRAVATED_SERVICE_LABEL%>" style="display: none">Explain</label>
<textarea tabindex="1" class="large" maxlength="200"
	name="<%=AGGRAVATED_SERVICE_DESC %>" style="display: none"
	onkeyup="chkLength(this,200);"></textarea>

<div class="Clear"></div>
<div class="Height10"></div>
<div class="Clear"></div>
<div class="Height10"></div>

<label class="large2">Medical category recommended with duration<span>*</span></label>
<input tabindex="1" maxlength="40"
	name="<%=MEDICAL_CATEGORY_NAME_RECOMMENED_WITH_DURATION %>" type="text" />

<input tabindex="1" name="<%=MEDICAL_CATEGORY_DURATION %>" type="text"
	maxlength="15" />

<div class="Clear"></div>

<label class="large2">Date &amp; Place of next recategorisation
Board</label> <input tabindex="1" name="<%=DATE_OF_RECATEGORIZATION %>"
	type="text" validate="Date of recategorization ,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.medicalBoardProceeding.<%=DATE_OF_RECATEGORIZATION%>,event);" />
<input tabindex="1" name="<%=PLACE_OF_RECATEGORIZATION %>" type="text"
	maxlength="30" />

<div class="Clear"></div>
<div class="Height10"></div>

<h5>Percentage of disability (Only for permanent LMC)</h5>
<div class="Clear"></div>
<label class="large">Previous Disablement %</label> <input tabindex="1"
	name="<%=PREVIOUS_DISABLEMENT %>" value="" type="text"
	validate="Previous Disablement,int,no" maxlength="6" /> <label
	class="large">Present Disablement %</label> <input tabindex="1"
	name="<%=PRESENT_DISABLEMENT %>" value=""
	validate="Previous Disablement,int,no" type="text" maxlength="6" />

<div class="Clear"></div>

<label class="large2">Reasons for variation if any</label> <textarea
	tabindex="1" class="large" name="<%=REASON_FOR_VARIATION %>"
	onkeyup="chkLength(this,500);"></textarea>

<div class="Clear"></div>
<label class="large2">Any specified restriction regarding
employment</label> <textarea tabindex="1" class="large"
	name="<%=RESTRICTION_REGARDING_EMPLOYEMENT %>"
	onkeyup="chkLength(this,500);"></textarea>

<div class="Clear"></div>
<label class="large2">Instruction given to the individual by the
president of the medical board</label> <textarea tabindex="1" class="large"
	name="<%=INSTRUCTION_BY_PRESIDENT %>" onkeyup="chkLength(this,500);"></textarea>
</div>
</div>

<div class="Clear"></div>
<!--table-->
<div class="division"></div>
<div class="bottom"><input tabindex="1" name="Button"
	type="button" class="button" value="Submit"
	onClick="submitForm('medicalBoardProceeding','medicalBoardUpdate?method=addMedicalBoardProceeding');" />
<input tabindex="1" name="Button" type="button" class="button"
	value="Reset" onclick=resetCheck(); /> <input tabindex="1"
	name="Button" type="button" class="button" value="Search"
	onClick="submitForMedicalBoard('medicalBoardProceeding');" />
<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden" value="1"
	name="hiddenValue" id="hiddenValue" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="Clear"></div>



</div>


<!--Bottom labels starts--> <!--main content placeholder ends here--> 
<script	type="text/javascript">
    function removeRow()
   {
     var tbl = document.getElementById('amcDetailId');
     document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
     var lastRow = tbl.rows.length;
     if (lastRow > 2) tbl.deleteRow(lastRow - 1);
     else 
     alert("Unfit Explanation should have at least one row");
     
   }
	
	
	function checkFilledRow(){
	var msg ="";
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	  }else{
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('disabilities'+i).value == ""){
	  				msg += "Disabilities can not be blank.\n";
	  			}
	  			if(document.getElementById('date'+i).value == ""){
	  				msg += "Date can not be blank.\n";
	  			}
	  			if(document.getElementById('place'+i).value == ""){
	  				msg += "Place can not be blank.\n";
	  			}
	  			if(document.getElementById('previous'+i).value == "")
	  			{
	  			msg += "Previous Medical Categorisation cnn not be blank";
	  			}
	  			if(msg != ""){
	  				break;
	  			}
	  		}
	  	}
	  	if(msg != ""){
	  		alert(msg)
	  		return false;
	  	}else{
	  		return true;
	  	}
	  }
	  function vBulletin_init()
{
	// don't bother doing any exciting stuff for WebTV
	if (is_webtv)
	{
		return false;
	}

	// set 'title' tags for image elements
	var imgs = fetch_tags(document, 'img');
	for (var i = 0; i < imgs.length; i++)
	{
		if (!imgs[i].title && imgs[i].alt != '')
		{
			imgs[i].title = imgs[i].alt;
		}
	}

	// finalize popup menus
	if (typeof vBmenu == 'object')
	{
		// close all menus on document click
		if (window.attachEvent && !is_saf)
		{
			document.attachEvent('onclick', vbmenu_hide);
			window.attachEvent('onresize', vbmenu_hide);
		}
		else if (document.addEventListener && !is_saf)
		{
			document.addEventListener('click', vbmenu_hide, false);
			window.addEventListener('resize', vbmenu_hide, false);
		}
		else
		{
			window.onclick = vbmenu_hide;
			window.onresize = vbmenu_hide;
		}

		// add popups to pagenav elements
		var pagenavs = fetch_tags(document, 'td');
		for (var n = 0; n < pagenavs.length; n++)
		{
			if (pagenavs[n].hasChildNodes() && pagenavs[n].firstChild.name && pagenavs[n].firstChild.name.indexOf('PageNav') != -1)
			{
				var addr = pagenavs[n].title;
				pagenavs[n].title = '';
				pagenavs[n].innerHTML = '';
				pagenavs[n].id = 'pagenav.' + n;
				var pn = vBmenu.register(pagenavs[n].id);
				if (is_saf)
				{
					pn.controlobj._onclick = pn.controlobj.onclick;
					pn.controlobj.onclick = vBpagenav.prototype.controlobj_onclick;
				}
			}
		}

		// process the pagenavs popup form
		if (typeof addr != 'undefined')
		{
			fetch_object('pagenav_form').addr = addr;
			fetch_object('pagenav_form').gotopage = vBpagenav.prototype.form_gotopage;
			fetch_object('pagenav_ibtn').onclick = vBpagenav.prototype.ibtn_onclick;
			fetch_object('pagenav_itxt').onkeypress = vBpagenav.prototype.itxt_onkeypress;
		}

		// activate the menu system
		vBmenu.activate(true);
	}

	return true;
} 
<%
			int counter1 = 0;
			for (MasState masState : stateList)
			{
				for (MasDistrict masDistrict : cityList) 
				{
					if(masDistrict.getState() != null){
						if(masState.getId().equals(masDistrict.getState().getId() )){
								%>
									districtArray[<%=counter1%>] = new Array();
									districtArray[<%=counter1%>][0]=<%=masState.getId()%>;
									districtArray[<%=counter1%>][1] = <%=masDistrict.getId()%>;									
									districtArray[<%=counter1%>][2] = "<%=masDistrict.getDistrictName()%>";

								<%
								counter1++;
						}
					}
				}
			}
			
		%>
		
	</script></form>
</div>
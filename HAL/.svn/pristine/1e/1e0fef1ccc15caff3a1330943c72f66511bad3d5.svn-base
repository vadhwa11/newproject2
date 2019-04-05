<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties
			.getProperty("empCategoryCodeForDoctor");
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
	List<MasDisposedTo> disposedToList = new ArrayList<MasDisposedTo>();
	List<MasCareType> careTypeList = new ArrayList<MasCareType>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	List<MasDischargeStatus> dischargeStatusList = new ArrayList<MasDischargeStatus>();
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	@SuppressWarnings("unused")
	List<Discharge> dischargeList = new ArrayList<Discharge>();
	List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();

	if (request.getAttribute("map") != null) {
		detailsMap = (Map<String, Object>) request.getAttribute("map");
	}
	if (detailsMap.get("inpatientList") != null) {
		inpatientList = (List<Inpatient>) detailsMap
				.get("inpatientList");
	}
	if (detailsMap.get("dischargeList") != null) {
		dischargeList = (List<Discharge>) detailsMap
				.get("dischargeList");
	}
	if (detailsMap.get("dischargeIcdCodeList") != null) {
		dischargeIcdCodeList = (List<DischargeIcdCode>) detailsMap
				.get("dischargeIcdCodeList");
	}
	if (detailsMap.get("employeeList") != null) {
		employeeList = (List<MasEmployee>) detailsMap
				.get("employeeList");
	}
	if (detailsMap.get("disposedToList") != null) {
		disposedToList = (List<MasDisposedTo>) detailsMap
				.get("disposedToList");
	}
	if (detailsMap.get("disposalList") != null) {
		disposalList = (List<MasDisposal>) detailsMap
				.get("disposalList");
	}
	if (detailsMap.get("careTypeList") != null) {
		careTypeList = (List<MasCareType>) detailsMap
				.get("careTypeList");
	}
	if (detailsMap.get("dischargeStatusList") != null) {
		dischargeStatusList = (List<MasDischargeStatus>) detailsMap
				.get("dischargeStatusList");
	}
	Discharge discharge = null;
	DischargeIcdCode dischargeIcdCode = null;
	System.out.println("dischargeList   " + dischargeList.size());
	int dId =0;
	int doctorId = 0;
	int disposalId = 0;
	int disposedToId = 0;
	int careTypeId = 0;
	String injuryRptInitOn = "";
	String injuryRptInitat = "";
	String boardHeldOn = "";
	String followUpDate = "";
	String dischrgInMedicalCtgry = "";
	int dischargeStatusId = 0;
	String careSummary = "";
	String instructionsToPatient = "";
	String documentInitiated = "";
	String dateofDischarge = "";
	String timerOfDischarge = "";
	String diagnosis ="";
	String workingDiagnosis = "";
	if (dischargeList.size() > 0) {
		discharge = dischargeList.get(0);
		dId = discharge.getId();
		if (discharge.getDoctor() != null)
			doctorId = discharge.getDoctor().getId();
		if (discharge.getDisposal() != null)
			disposalId = discharge.getDisposal().getId();
		if (discharge.getDisposedTo() != null)
			disposedToId = discharge.getDisposedTo().getId();
		if (discharge.getCareType() != null)
			careTypeId = discharge.getCareType().getId();
		if (discharge.getInjuryReportInitiatedOn() != null) {
			SimpleDateFormat formatterIn = new SimpleDateFormat(
					"yyyy-MM-dd");
			SimpleDateFormat formatterOut = new SimpleDateFormat(
					"dd/MM/yyyy");
			injuryRptInitOn = formatterOut.format(formatterIn.parse(""
					+ discharge.getInjuryReportInitiatedOn()));
			System.out.println("injuryRptInitOn  " + injuryRptInitOn);
		}
		if (discharge.getInjuryReportInitAt() != null)
			injuryRptInitat = discharge.getInjuryReportInitAt();
		if (discharge.getBoardHeldOn() != null) {
			SimpleDateFormat formatterIn2 = new SimpleDateFormat(
					"yyyy-MM-dd");
			SimpleDateFormat formatterOut2 = new SimpleDateFormat(
					"dd/MM/yyyy");
			boardHeldOn = formatterOut2.format(formatterIn2.parse(""
					+ discharge.getBoardHeldOn()));
		}
		if (discharge.getFollowUpDate() != null) {
			SimpleDateFormat formatterIn3 = new SimpleDateFormat(
					"yyyy-MM-dd");
			SimpleDateFormat formatterOut3 = new SimpleDateFormat(
					"dd/MM/yyyy");
			followUpDate = formatterOut3.format(formatterIn3.parse(""
					+ discharge.getFollowUpDate()));
		}
		if (discharge.getDischargeInMedicalCategory() != null)
			dischrgInMedicalCtgry = discharge.getDischargeInMedicalCategory();
		if (discharge.getDischargeStatus() != null)
			dischargeStatusId = discharge.getDischargeStatus().getId();
		if (discharge.getCareSummary() != null)
			careSummary = discharge.getCareSummary();
		if (discharge.getInstructionsToPatient() != null)
			instructionsToPatient = discharge.getInstructionsToPatient();
		if (discharge.getDocumentInitiated() != null)
			documentInitiated = discharge.getDocumentInitiated();
		if (discharge.getDateOfDischarge() != null) {
			SimpleDateFormat formatterIn4 = new SimpleDateFormat(
					"yyyy-MM-dd");
			SimpleDateFormat formatterOut4 = new SimpleDateFormat(
					"dd/MM/yyyy");
			dateofDischarge = formatterOut4.format(formatterIn4
					.parse("" + discharge.getDateOfDischarge()));
		}
		if (discharge.getTimeOfDischarge() != null)
			timerOfDischarge = discharge.getTimeOfDischarge();
		
		if (discharge.getWorkingDiagnosis() != null)
			workingDiagnosis = discharge.getWorkingDiagnosis();
		
	}
	int inc =1;
	if (dischargeIcdCodeList.size() > 0) {
		for(DischargeIcdCode dischargeIcdCode2 :dischargeIcdCodeList){
			if(dischargeIcdCode2.getIcd() !=null){
				if(dischargeIcdCode2.getIcd().getIcdSubCategory() !=null)
				diagnosis = diagnosis +inc+" ."+dischargeIcdCode2.getIcd().getIcdSubCategory().getIcdSubCategoryName()+" : "+ dischargeIcdCode2.getIcd().getIcdName()+"["+dischargeIcdCode2.getIcd().getIcdCode()+"]\n";
				else
					diagnosis = diagnosis +inc+" . : "+ dischargeIcdCode2.getIcd().getIcdName()+"["+dischargeIcdCode2.getIcd().getIcdCode()+"]\n";
				inc++;
			}
		}
	}
%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.MasDisposedTo"%>
<%@page import="jkt.hms.masters.business.MasCareType"%>
<%@page import="jkt.hms.masters.business.MasDischargeStatus"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.net.URL"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Discharge"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="java.text.SimpleDateFormat"%>

<label><span>*</span>Doctor:</label>

<select name="<%=DOCTOR_NAME %>" validate="Doctor,String,yes"
	id="doctor">
	<option value="0">Select</option>
	<%
							for (MasEmployee masEmployee : employeeList) {
								if (masEmployee.getEmpCategory() != null) {
									if (masEmployee.getEmpCategory().getEmpCategoryCode()
											.equals(empCategoryCodeForDoctor)) {
										String doctorMiddleName = "";
										String doctorLastName = "";
										if (doctorId == masEmployee.getId()) {
						%>
	<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getFirstName()%>
	<%=doctorMiddleName%> <%=doctorLastName%></option>
	<%
									} else {
								%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()%>
	<%=doctorMiddleName%> <%=doctorLastName%></option>
	<%
									}
								%>
	<%
							}
								}
							}
						%>
</select>
<label><span>*</span>Disposal:</label>
<select name="<%=DISPOSAL_ID %>" validate="Disposal,String,yes"
	id="disposal">
	<option value="0">Select</option>
	<%
				    		for (MasDisposal masDisposal : disposalList) {
				    			if (disposalId == masDisposal.getId()) {
				    	%>
	<option value="<%=masDisposal.getId() %>" selected="selected"><%=masDisposal.getDisposalName()%></option>
	<%
							} else {
						%>
	<option value="<%=masDisposal.getId() %>"><%=masDisposal.getDisposalName()%></option>
	<%
							}
						%>
	<%
				  			}
				  		%>
</select>

<div class="Clear"></div>

<label><span>*</span>Disposed To:</label>
<select name="<%=DISPOSED_TO_ID %>" validate="Disposed To,String,yes"
	class="large" onchange="getOtherHospitalTextBox(this.value);"
	id="disposalTo">
	<option value="0">Select</option>
	<%
								for (MasDisposedTo masDisposedTo : disposedToList) {
									if (disposedToId == masDisposedTo.getId()) {
							%>
	<option value="<%=masDisposedTo.getId()%>" selected="selected"><%=masDisposedTo.getDisposedToName()%></option>
	<%
								} else {
							%>
	<option value="<%=masDisposedTo.getId()%>"><%=masDisposedTo.getDisposedToName()%></option>
	<%
								}
							%>
	<%
					  			}
					  		%>
</select>

<div id="otherHospitalId" style="display: none;"><input
	type="text" name="<%=OTHER_HOSPITAL_NAME%>" id="" maxlength="30"
	validate="Other Hospital Name,String,no"></div>

<div class="Clear"></div>

<label>Care Type:</label>
<select name="<%=CARE_TYPE_ID %>" validate="Care Type,String,no"
	id="careType">
	<option value="0">Select</option>
	<%
							for (MasCareType masCareType : careTypeList) {
								if (careTypeId == masCareType.getId()) {
						%>
	<option value="<%=masCareType.getId() %>" selected="selected"><%=masCareType.getCareTypeName()%></option>
	<%
							} else {
						%>
	<option value="<%=masCareType.getId() %>"><%=masCareType.getCareTypeName()%></option>
	<%
							}
						%>
	<%
				  			}
				  		%>
</select>


<label>Injury Rpt Init On:</label>
<input type="text" id="injuryRptInitOn"
	name="<%=INJURY_REPORT_INITIATED_ON %>" class="calDate"
	readonly="readonly" validate="Injury Report Initiated On,date,no"
	MAXLENGTH="30" value="<%=injuryRptInitOn%>" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.updateDischarge.<%=INJURY_REPORT_INITIATED_ON%>,event)" />

<label>Injury Rpt Init at</label>
<input type="text" name="injury_report_init_at" class="textbox_date"
	validate="Injury Report Initiated At,string,no" MAXLENGTH="50"
	id="injuryRptInitat" value="<%=injuryRptInitat %>" />

<div class="Clear"></div>

<label>Board Held On:</label>
<input type="text" id="boardHeldOn" name="<%=BOARD_HELD_ON %>"
	value="<%=boardHeldOn %>" class="calDate" readonly="readonly"
	validate="Board Held On,date,no" MAXLENGTH="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.updateDischarge.<%=BOARD_HELD_ON%>,event)" />

<label>Follow Up Date:</label>
<input type="text" id="followUpDate" name="<%=FOLLOW_UP %>"
	value="<%=followUpDate %>" class="calDate" readonly="readonly"
	validate="Follow Up Date,date,no" MAXLENGTH="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.updateDischarge.<%=FOLLOW_UP%>,event)" />

<label>Discharge In Medical Ctgry:</label>
<input type="text" name="<%=DISCHARGE_IN_MEDICAL_CATEGORY %>"
	value="<%=dischrgInMedicalCtgry%>" id="dischrgInMedicalCtgry"
	class="textbox_date" validate="Discharge In Medical Category,String,no"
	MAXLENGTH="30" />

<div class="Clear"></div>

<label><span>*</span>Discharge Status:</label>
<select name="<%=DISCHARGE_STATUS_ID %>"
	validate="Discharge Status,String,yes"
	onchange="checkDischargeStatus(this.value);" id="dischargeStatus">
	<option value="0">Select</option>
	<%
							for (MasDischargeStatus masDischargeStatus : dischargeStatusList) {
								if (dischargeStatusId == masDischargeStatus.getId()) {
						%>
	<option value="<%=masDischargeStatus.getId() %>" selected="selected"><%=masDischargeStatus.getDischargeStatusName()%></option>
	<%
							} else {
						%>
	<option value="<%=masDischargeStatus.getId() %>"><%=masDischargeStatus.getDischargeStatusName()%></option>
	<%
							}
						%>
	<%
				  			}
				  		%>
</select>


<label>Care Summary:</label>
<textarea name="<%=CARE_SUMMARY %>" id="careSummary"
	validate="Care Summary,string,no" cols="25" rows="1" class="large" /><%=careSummary%></textarea>

<div class="Clear"></div>

<label>Instructions To Patient:</label>
<textarea name="<%=INSTRUCTIONS %>" id="instructionsToPatient"
	validate="Instructions To Patient,string,no" cols="25" rows="2"
	class="large" /><%=instructionsToPatient %></textarea>

<div class="Clear"></div>

<label>Document Initiated </label>
<textarea name="document_initiated"
	validate="Document Initiated,string,no" cols="25" rows="2"
	id="documentInitiated" class="large" /><%=documentInitiated %></textarea>
<input type="hidden" name="admissionNo" value="1" id="admissionNo" />

<div class="Clear"></div>

<label>Date of Discharge:</label>
<input type="text" class="calDate" name="<%=DISCHARGE_DATE%>"
	value="<%=dateofDischarge %>" id="dDate" readonly="readonly"
	validate="Date of Discharge,date,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.updateDischarge.<%=DISCHARGE_DATE%>,event)" />

<label>Time of Discharge:</label>
<input type="text" name="<%=DISCHARGE_TIME%>"
	value="<%=timerOfDischarge %>" id="dTime"
	onblur="checkTime('updateDischarge','<%=DISCHARGE_TIME%>')"
	validate="Time of Discharge,String,yes" />

<label>Delete Diagnosis:</label>
<input type="checkbox" name="<%=DELETE_DIAGNOSIS %>" value=""
	class="radio">

<div class="Clear"></div>

<label class="noWidth">Working Diagnosis:</label>
<input type="text" maxlength="150" align="right" name="workingDiagnosis"
	id="workingDiagnosis" value="<%=workingDiagnosis %>" class="large2" />

<div class="Clear"></div>

<label>Diagnosis :</label>
<label id="diagnosisId" class="noHeightBig"><%=diagnosis %></label>
<input type="hidden" class="textbox_size20" name="dId" value="<%=dId %>"
	id="dId" />
<div class="Clear"></div>



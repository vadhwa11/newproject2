<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * expiryDetails.jsp  
 * Purpose of the JSP -  This is for Expiry Details.
 * @author  Vikas
 * @author  Deepali
 * Create Date: 05th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Date"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDeathCause"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasBlock"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Discharge"%>
<%@page import="java.text.SimpleDateFormat"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder"><script>
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
</script> <%
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String message = "";
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<Patient> patientList = new ArrayList<Patient>();
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	List<MasDeathCause> deathCauseList = new ArrayList<MasDeathCause>();
	List<MasCountry> countryList = new ArrayList<MasCountry>();
	List<MasState> stateList = new ArrayList<MasState>();
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	List<MasBlock> blockList = new ArrayList<MasBlock>();
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	List<Discharge> dischargeList = new ArrayList<Discharge>();
	List<ExpiryDetails> expireDetailList = new ArrayList<ExpiryDetails>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");

	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientList") != null){
		patientList = (List<Patient>)map.get("patientList");
	}
	if(map.get("expDetailsList") != null){
		expireDetailList = (List<ExpiryDetails>)map.get("expDetailsList");
	}
	if(map.get("inpatientList") != null){
		inpatientList = (List<Inpatient>)map.get("inpatientList");
	}
	if(map.get("relationList") != null){
		relationList = (List<MasRelation>)map.get("relationList");
	}
	if(map.get("blockList") != null){
		blockList = (List<MasBlock>)map.get("blockList");
	}
	if(map.get("districtList") != null){
		districtList = (List<MasDistrict>)map.get("districtList");
	}
	if(map.get("stateList") != null){
		stateList = (List<MasState>)map.get("stateList");
	}
	if(map.get("countryList") != null){
		countryList = (List<MasCountry>)map.get("countryList");
	}
	if(map.get("dischargeList") != null){
		dischargeList = (List<Discharge>)map.get("dischargeList");
	}
	Discharge discharge =dischargeList.get(0);
	 String dischargeDate ="";
	 String dischargeTime =""; 
	try{
		System.out.println("discharge.getDateOfDischarge() "+discharge.getDateOfDischarge());
		 SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
		 dischargeDate=formatterOut.format(formatterIn.parse(""+discharge.getDateOfDischarge()));
		 dischargeTime =""+discharge.getTimeOfDischarge();
		
	}catch(Exception ee){
		ee.printStackTrace();
	}
	if(dischargeTime.equals("")){
		dischargeTime=currentTime;
	}
	if(dischargeDate.equals("")){
		dischargeDate=currentDate;
	}
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	
	Patient patient = new Patient();
	if(patientList.size() > 0){
		 patient = patientList.get(0);
	}
	String age = "";
	String currentAge = "";
	Set<Visit> visitSet = (Set<Visit>)patient.getVisits();
	for(Visit visit : visitSet){
		if(visit.getVisitNo() == 1){
			age = visit.getAge();
			currentAge = HMSUtil.calculateAgeForADT(age, visit.getVisitDate());
		
		}
	}
	Inpatient inpatient = inpatientList.get(0);
	String adNo = inpatient.getAdNo();
		
	
%>



<form name="expiryDetails" method="post"><script
	type="text/javascript">
		<%
			int counter=0;
			for (MasCountry masCountry : countryList) 
			{
				for (MasState masState : stateList) 
				{
					if(masCountry.getId().equals(masState.getCountry().getId())){
								%>
									stateArr[<%=counter%>] = new Array();
									stateArr[<%=counter%>][0] = <%=masCountry.getId()%>;
									stateArr[<%=counter%>][1] = <%=masState.getId()%>;									
									stateArr[<%=counter%>][2] = "<%=masState.getStateName()%>";
								<%
								counter++;
						}
					}
			}
		
			int counter1 = 0;
			for (MasState masState : stateList)
			{
				for (MasDistrict masDistrict : districtList) 
				{
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
	
			int count = 0;
			for (MasDistrict masDistrict : districtList) 
			{
				for (MasBlock masBlock  : blockList) 
				{
					if(masDistrict.getId().equals(masBlock.getDistrict().getId())){
								%>
									blockArray[<%=count%>] = new Array();
									blockArray[<%=count%>][0] = <%=masDistrict.getId()%>;
									blockArray[<%=count%>][1] = <%=masBlock.getId()%>;									
									blockArray[<%=count%>][2] = "<%=masBlock.getBlockName()%>";

								<%
								count++;
						}
					}
				}
			%>
	
	
	
	
	
	</script> <%if( !message.equals("") ){ %> <label class="noWidth"><span><%=message %></label></label>
<input value="Print" type="button" class="button"
	onClick="submitForm('expiryDetails','/hms/hms/ipd?method=showDischargeSlipReport&inpatientId='+<%=inpatient.getId()%>);">
<div class="Clear"></div>
<%} %>
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<%
		if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
	%>
<div class="Clear"></div>
<div class="blockFrame"><label>Service No.:</label> <label
	class="value"><%= patient.getServiceNo()%></label> <%} %> <%
		if(patient.getServiceStatus() != null){
	%> <label>Service Status:</label> <label class="value"><%= patient.getServiceStatus().getServiceStatusName()%></label>
<%} %> <label>Service Type:</label> <label class="value"><%= patient.getServiceType().getServiceTypeName()%></label>

<%
		if(patient.getRelation() != null){
	%>

<div class="Clear"></div>

<label>Relation:</label> <label class="value"><%= patient.getRelation().getRelationName()%></label>
<%} %> <%
	if(patient.getSFirstName() != null && !(patient.getSFirstName().equals(""))){
	%> <label>Name:</label> <label class="value"><%= patient.getSFirstName()+" "+patient.getSMiddleName()+" "+patient.getSLastName()%></label>
<%} %>

<div class="Clear"></div>

</div>
<div class="Clear"></div>

<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>A&D No.:</label> <label
	class="value"><%=adNo %></label> <label>Hin No.:</label> <label
	class="value"><%=patient.getHinNo() %></label> <label>Patient
Name:</label> <label class="value"><%= patient.getPFirstName()+" "+patient.getPMiddleName()+" "+patient.getPLastName()%></label>

<div class="Clear"></div>

<label>Sex:</label> <label class="value"><%=patient.getSex().getAdministrativeSexName() %></label>

<label>Age:</label> <label class="value"><%=currentAge%></label> <label>Admiss.
Date:</label> <label class="value"><%=inpatient.getDateOfAddmission() %></label>

<div class="Clear"></div>
<label>Admiss. Time:</label> <label class="value"><%=inpatient.getTimeOfAddmission() %></label>
<label>Ward:</label> <label class="value"><%=inpatient.getDepartment().getDepartmentName()%></label>
<div class="Clear"></div>

</div>
<div class="Clear"></div>
<div class="blockTitle">Expiry Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="large"><span>*</span>
Cause of Death(Direct):</label> <%if(expireDetailList!=null && expireDetailList.size()>0 &&  expireDetailList.get(0).getDDeathCauseText()!=null){ %>
<textarea name="<%=D_DEATH_CAUSE_ID %>" class="large"
	id="causeOfDeathId" validate="Cause Of Death(Direct),String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	value="<%=expireDetailList.get(0).getDDeathCauseText()  %>"
	maxlength="100" tabindex="1" /><%=expireDetailList.get(0).getDDeathCauseText()  %></textarea>
<%}else{ %> <textarea name="<%=D_DEATH_CAUSE_ID %>" class="large"
	id="causeOfDeathId" validate="Cause Of Death(Direct),String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /></textarea> <%} %>

<div class="Clear"></div>

<label class="large">Cause Of Death(Secondary):</label> <%if(expireDetailList!=null && expireDetailList.size()>0 && expireDetailList.get(0).getSDeathCauseText()!=null){ %>
<textarea name="<%=S_DEATH_CAUSE_ID %>" class="large"
	validate="Cause Of Death(Secondary),String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100"
	value="<%=expireDetailList.get(0).getSDeathCauseText() %>" tabindex="1" /><%=expireDetailList.get(0).getSDeathCauseText() %></textarea>
<%}else{ %> <textarea name="<%=S_DEATH_CAUSE_ID %>" class="large"
	validate="Cause Of Death(Secondary),String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" value="" tabindex="1" /></textarea> <%} %>

<div class="Clear"></div>

<label class="large">Cause Of Death <br>
(Contributing):</label> <%if(expireDetailList!=null && expireDetailList.size()>0 && expireDetailList.get(0).getCDeathCauseText()!=null){ %>
<textarea name="<%=C_DEATH_CAUSE_ID %>" class="large"
	validate="Cause Of Death(Contributing),String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100"
	value="<%=expireDetailList.get(0).getCDeathCauseText() %>" tabindex="1" /><%=expireDetailList.get(0).getCDeathCauseText() %></textarea>
<%}else{ %> <textarea name="<%=C_DEATH_CAUSE_ID %>" class="large"
	validate="Cause Of Death(Contributing),String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /></textarea> <%} %>
<div class="Clear"></div>

<label class="large">Death Certificate No.:</label> <%if(expireDetailList!=null && expireDetailList.size()>0 && expireDetailList.get(0).getDeathCertificateNo()!=null){ %>
<input type="text" name="<%=DEATH_CERTIFICATE_NO %>"
	value="<%=expireDetailList.get(0).getDeathCertificateNo() %>"
	validate="Death Certificate No.,String,no" maxlength="20"> <%}else{ %>
<input type="text" name="<%=DEATH_CERTIFICATE_NO %>" value=""
	validate="Death Certificate No.,String,no" maxlength="20"> <%} %>

<label class="large">Death Certificate Taken By:</label> <%if(expireDetailList!=null && expireDetailList.size()>0 && expireDetailList.get(0).getDeathCertificateTakenBy()!=null){ %>
<input type="text" class="large" name="<%=DEATH_CERTIFICATE_TAKEN_BY %>"
	value="<%= expireDetailList.get(0).getDeathCertificateTakenBy() %>"
	validate="Death Certificate Taken By,String,no" maxlength="50">
<%}else{ %> <input type="text" class="large"
	name="<%=DEATH_CERTIFICATE_TAKEN_BY %>" value=""
	validate="Death Certificate Taken By,String,no" maxlength="50">
<%} %>

<div class="Clear"></div>

<label><span>*</span> Expiry Date:</label> <%if(expireDetailList!=null && expireDetailList.size()>0 && expireDetailList.get(0).getExpiryDate()!=null){ %>
<input type="text" name="<%=DATE_OF_EXPIRY %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(expireDetailList.get(0).getExpiryDate()) %>"
	class="textbox_date" readonly="readonly"
	validate="Expiry Date,date,yes" MAXLENGTH="30" /> <%}else{ %> <input
	type="text" name="<%=DATE_OF_EXPIRY %>" value="<%=dischargeDate %>"
	class="calDate" readonly="readonly" validate="Expiry Date,date,yes"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('',document.expiryDetails.<%=DATE_OF_EXPIRY%>,event)" />
<%} %> <label><span>*</span> Expiry Time:</label> <%if(expireDetailList!=null && expireDetailList.size()>0 && expireDetailList.get(0).getExpiryTime()!=null){ %>
<input type="text" name="<%=TIME_OF_EXPIRY %>"
	value="<%=expireDetailList.get(0).getExpiryTime() %>"
	validate="Expiry Time,String,yes" maxlength="50"> <%}else{ %> <input
	type="text" name="<%=TIME_OF_EXPIRY %>" value="<%=dischargeTime %>"
	validate="Expiry Time,String,yes" maxlength="50"> <%} %>

<div class="Clear"></div>

<label>Consequence of:</label> <%if(expireDetailList!=null && expireDetailList.size()>0 && expireDetailList.get(0).getConsequenceOf()!=null){ %>
<textarea name="<%=CONSQUENCE_OF %>" class="large"
	validate="Cause Of Death(Direct),String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /><%=expireDetailList.get(0).getConsequenceOf() %></textarea>
<%}else{ %> <textarea name="<%=CONSQUENCE_OF %>" class="large"
	validate="Cause Of Death(Direct),String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /></textarea> <%} %>

<div class="Clear"></div>

<label>Id Mark 1:</label> <%if(expireDetailList!=null && expireDetailList.size()>0 && expireDetailList.get(0).getIdMarks1()!=null){ %>
<textarea name="<%=ID_MARK1%>" class="large"
	validate="Id Mark 1,String,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /><%= expireDetailList.get(0).getIdMarks1() %></textarea>
<%}else{ %> <textarea name="<%=ID_MARK1%>" class="large"
	validate="Id Mark 1,String,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /></textarea> <%} %>

<div class="Clear"></div>

<label>Id Mark 2:</label> <%if(expireDetailList!=null && expireDetailList.size()>0 && expireDetailList.get(0).getIdMarks2()!=null){ %>
<textarea name="<%=ID_MARK2%>" class="large"
	validate="Id Mark 2,String,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /><%=expireDetailList.get(0).getIdMarks2() %></textarea>
<%}else{ %> <textarea name="<%=ID_MARK2%>" class="large"
	validate="Id Mark 2,String,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /></textarea> <%} %>

<div class="Clear"></div>
<label>Remarks:</label> <%if(expireDetailList!=null && expireDetailList.size()>0 && expireDetailList.get(0).getRemarks()!=null){ %>
<textarea name="<%=REMARKS%>" class="large" validate="Remarks,String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /><%=expireDetailList.get(0).getRemarks() %></textarea>
<%}else{ %> <textarea name="<%=REMARKS%>" class="large"
	validate="Remarks,String,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /></textarea> <%} %>
</div>
<div class="Clear"></div>


<div class="blockTitle">Informant Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Name:</label> <%if(patient.getNextOfKinName() !=null){ %>
<input type="text" name="<%=INFORMANT_NAME %>"
	value="<%=patient.getNextOfKinName()%>"
	validate="Informant Name,String,no" maxlength="50"> <%}else{ %> <input
	type="text" name="<%=INFORMANT_NAME %>" value=""
	validate="Informant Name,String,no" maxlength="50"> <%} %> <%	int nokRelId =0;
			int nokBlockId =0;
			int nokDistrictId =0;
			int nokStateId =0;
			int nokCountryId =0;
		  if(patient.getNextOfKinRelation() !=null){
			  nokRelId = patient.getNextOfKinRelation().getId();
		  }
		  if(patient.getDistrict() !=null){
			  nokDistrictId = patient.getDistrict().getId();
		  }
		  if(patient.getState() !=null){
			  nokStateId = patient.getState().getId();
		  }
		  if(patient.getCountry() !=null){
			  nokCountryId = patient.getCountry().getId();
		  }
		 
			%> <label>Relation:</label> <select name="<%=RELATION_ID %>"
	validate="Relation Of Informant,String,no">
	<option value="0">Select</option>
	<%
				for(MasRelation masRelation : relationList){
					if(nokRelId ==masRelation.getId()){
			%>
	<option value="<%=masRelation.getId() %>" selected="selected"><%=masRelation.getRelationName() %></option>
	<%}else{ %>
	<option value="<%=masRelation.getId() %>"><%=masRelation.getRelationName() %></option>
	<%}} %>
</select> <label>Address:</label> <%if(patient.getNextOfKinAddress() != null){ %>
<textarea name="<%=ADDRESS %>" validate="Address Of Informant,string,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /><%=patient.getNextOfKinAddress() %></textarea> <%}else{ %>
<textarea name="<%=ADDRESS %>" validate="Address Of Informant,string,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /></textarea> <%} %>

<div class="Clear"></div>

<label> Block:</label> <select name="<%=BLOCK_ID %>"
	validate="Block of Informant,String,no">
	<option value="0">Select</option>
	<%
		    	for(MasBlock masBlock : blockList){
		    		if(masBlock.getDistrict().getDistrictCode().equals("41")){
		    			
		    %>
	<option value="<%=masBlock.getId() %>"><%=masBlock.getBlockName() %></option>
	<%}
		    		} %>
</select> <label>District:</label> <select name="<%=DISTRICT_ID %>"
	validate="District of Informant,String,no"
	onchange="populateBlock(this.value,'expiryDetails')" id="district">
	<option value="0">Select</option>
	<%
				for(MasDistrict masDistrict : districtList){
						if(masDistrict.getId()== nokDistrictId)
						{
			%>
	<option value="<%=masDistrict.getId()%>" selected="selected"><%=masDistrict.getDistrictName()%></option>
	<%			}else{ %>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%			}
				}%>
</select> <label>State:</label> <select name="<%=STATE_ID %>"
	validate="State of Informant,String,no"
	onchange="populateDistrict(this.value,'expiryDetails')" id="state">
	<option value="0">Select</option>
	<%

				for(MasState masState : stateList){
						if(masState.getId() ==nokStateId)
						{
			%>
	<option value="<%=masState.getId() %>" selected="selected"><%=masState.getStateName() %></option>
	<%			}else{ %>
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%			}
					
				}%>
</select>

<div class="Clear"></div>

<label>Country:</label> <select name="<%=COUNTRY_ID %>"
	validate="Country of Informant,String,no"
	onchange="populateState(this.value,'expiryDetails')">
	<option value="0">Select</option>
	<%
			 for(MasCountry cntMaster : countryList)
			 {
				 if(cntMaster.getId() ==nokCountryId){
			%>
	<option value="<%=cntMaster.getId() %>" selected="selected"><%=cntMaster.getCountryName() %></option>
	<%		}else{ %>
	<option value="<%=cntMaster.getId()%>"><%=cntMaster.getCountryName()%></option>
	<%
					}
			}%>
</select>
<div class="Clear"></div>
</div>
<div class="Clear"></div>

<div id="edited"></div>

<input type="button" name="Submit" id="Submit" value="Submit"
	class="button" style="display: none"
	onClick="if(validateExpiryDetails())submitForm('expiryDetails','/hms/hms/adt?method=submitExpiryDetails');" />
<input type="button" name="Update" id="Update" value="Update"
	class="button" style="display: none"
	onClick="if(validateExpiryDetails())submitForm('expiryDetails','/hms/hms/adt?method=updateExpiryDetails');" />
<input type="reset" name="Reset" value="Reset" class="button"
	onclick="location.reload();" accesskey="r" />


<div id="statusMessage" class="messagelabel"><br />
</div>

<div class="Clear"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value" name="<%= CHANGED_BY%>"><%=userName%></label> <!-- <input type="text" name="<%= CHANGED_BY%>" value="<%=userName%>"  readonly="readonly" MAXLENGTH="8" tabindex=3 /> -->

<label id=biglabel> Changed Date:</label> <label class="value"
	name="<%= CHANGED_DATE %>"><%=currentDate%></label> <!--<input type="text" name="<%= CHANGED_DATE %>" value="<%=currentDate%>"   readonly="readonly" tabindex=3 />-->

<label>Changed Time:</label> <label class="value"
	name="<%=CHANGED_TIME %>"><%=currentTime%></label> <!--  <input type="text" name="<%=CHANGED_TIME %>"  value="<%=currentTime%>"  readonly="readonly" tabindex=3 />-->

<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>">
<input type="hidden" name="<%=WARD_ID %>"
	value="<%=inpatient.getDepartment().getId() %>"> <input
	type="hidden" name="<%=BED_ID %>"
	value="<%=inpatient.getBed().getId() %>"> <input type="hidden"
	name="<%=INPATIENT_ID %>" value="<%=inpatient.getId() %>"> <%if(expireDetailList!=null && expireDetailList.size()>0 && expireDetailList.get(0).getId()!=null){ %>
<input type="hidden" name="expireId"
	value="<%=expireDetailList.get(0).getId() %>"> <%} %>
<div class="Clear"></div>
</div>
<div class="Clear"></div>


<script type="text/javascript">
<%if(expireDetailList!=null && expireDetailList.size()>0){ %>
	document.getElementById('Update').style.display = 'inline';
	document.getElementById('Submit').style.display = 'none';
	<%}else{%>
	document.getElementById('Submit').style.display = 'inline';
	document.getElementById('Update').style.display = 'none';
	<%}%>
function validateExpiryDetails(){
if(document.getElementById("causeOfDeathId").value ==""){
alert("Please fill Cause Of Death")
	return false
}else{
	return true
}
}
function displayListDateTime(){
	var list = document.getElementById('list').value;
	date = '<%=currentDate%>';
	time = '<%=currentTime%>';
	if(list != 0){
		document.getElementById('listdateId').value = date;
		document.getElementById('listtimeId').value = time;
	}else{
		document.getElementById('listdateId').value = "";
		document.getElementById('listtimeId').value = "";
	}
}
</script></form>

</div>
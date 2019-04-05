<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * dischargeByHinNo.jsp  
 * Purpose of the JSP -  This is for Discharge process By Hin No.
 * @author  Ritu
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By:
 * @version 1.9  
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDisposedTo"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.MasCareType"%>
<%@page import="jkt.hms.masters.business.Discharge"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.MasDischargeStatus"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.DischargeSummary"%>
<%@page import="jkt.hms.masters.business.UserEmpGroup"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);

function openPopupWindow()
{
 var url="/hms/hms/adt?method=showICDSearchJsp";
 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}

function jsSetIcdData(icd_no)
{
document.getElementById("icdCode").value=icd_no;
document.getElementById("icdCode").focus();
}

// -->
</script>
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
	String userName = "";
    String right = "n";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();
	
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasDisposedTo> disposedToList = new ArrayList<MasDisposedTo>();
	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
	List<MasCareType> careTypeList = new ArrayList<MasCareType>();
	List<Discharge> dischargeNoList = new ArrayList<Discharge>();
	List<MasIcd> icdNoList = new ArrayList<MasIcd>();
	List<MasDischargeStatus> dischargeStatusList = new ArrayList<MasDischargeStatus>();
	List<DischargeIcdCode> dischargeIcdList = new ArrayList<DischargeIcdCode>();
	List<DischargeSummary> dischargeSummaryList = new ArrayList<DischargeSummary>();
	List<UserEmpGroup> userRights = new ArrayList<UserEmpGroup>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientMap") != null){
		patientMap = (Map<String,Object>)map.get("patientMap");
	}
	if(patientMap.get("dischargeSummaryList") != null){
		dischargeSummaryList = (List<DischargeSummary>)patientMap.get("dischargeSummaryList");
	}
	if(map.get("patientDiagnosisMap") != null){
		patientDiagnosisMap = (Map<String,Object>)map.get("patientDiagnosisMap");
	}
	if(patientMap.get("inpatientList") != null){
		inpatientList = (List<Inpatient>)patientMap.get("inpatientList");
		session.setAttribute("inpatientList", inpatientList);
	}else if(session.getAttribute("inpatientList") != null){
		inpatientList = (List<Inpatient>)session.getAttribute("inpatientList");
	}
	
	if(patientDiagnosisMap.get("dischargeIcdList") != null){
		dischargeIcdList = (List<DischargeIcdCode>)patientDiagnosisMap.get("dischargeIcdList");
	}
	
	if(patientMap.get("userRights") != null){
		userRights = (List<UserEmpGroup>) patientMap.get("userRights"); 
	}
	if(userRights.size() > 0){
		right = "y";
	}
	
%>


<form name="dischargeByHin" method="post">

<div class="Clear"></div>
<div class="titleBg"><h2>Patient Discharge</h2></div>
<div class="Clear"></div>

<%
	if(inpatientList != null && inpatientList.size() > 0){
		Inpatient inpatient = inpatientList.get(0);
		Patient patient = inpatient.getHin();
		
		String age = "";
		String currentAge = "";
		age = patient.getAge();
		currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());
		
		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if(detailsMap.get("employeeList") != null){
			employeeList = (List<MasEmployee>)detailsMap.get("employeeList");
		}
		if(detailsMap.get("disposedToList") != null){
			disposedToList = (List<MasDisposedTo>)detailsMap.get("disposedToList");
		}
		if(detailsMap.get("disposalList") != null){
			disposalList = (List<MasDisposal>)detailsMap.get("disposalList");
		}
		if(detailsMap.get("careTypeList") != null){
			careTypeList = (List<MasCareType>)detailsMap.get("careTypeList");
		}
		if(detailsMap.get("dischargeNoList") != null){
			dischargeNoList = (List<Discharge>)detailsMap.get("dischargeNoList");
		}
		if(detailsMap.get("icdNoList") != null){
			icdNoList = (List<MasIcd>)detailsMap.get("icdNoList");
		}
		if(detailsMap.get("dischargeStatusList") != null){
			dischargeStatusList = (List<MasDischargeStatus>)detailsMap.get("dischargeStatusList");
		}
		int dischargeNo = 0;
		
		if(dischargeNoList.size() > 0){
			for(Discharge discharge : dischargeNoList){
				dischargeNo = discharge.getDischargeNo()+1;
			}
		}else{
			dischargeNo = 1;	
		}

		String adNo = "";
		String admissionDate = "";
		String admissionTime = "";
		adNo = inpatient.getAdNo();
		admissionDate = HMSUtil.changeDateToddMMyyyy(inpatient.getDateOfAddmission());
		admissionTime = inpatient.getTimeOfAddmission();
		String careSummary ="";	
		String instructionToPatient ="";	
		try{
			if(dischargeSummaryList.size() >0){
				for(DischargeSummary dischargeSummary :dischargeSummaryList){
			if(dischargeSummary.getLabel().equals("Brief Case Summary"))
		 		careSummary=dischargeSummary.getItemReply();
			if(!dischargeSummary.getItemCode().getCategoryName().equals("N")){
				if(dischargeSummary.getLabel().contains("Advice")){
					instructionToPatient=dischargeSummary.getItemReply();
				}
			}else{
				if(dischargeSummary.getLabel().contains("Advice")){
				instructionToPatient = instructionToPatient + dischargeSummary.getItemReply();
				}
				if(dischargeSummary.getLabel().equals("When & how to obtain urgent care")){
					if(!instructionToPatient.equals("")){
				      instructionToPatient =  instructionToPatient+" \n"+ dischargeSummary.getItemReply();
					}else{
					  instructionToPatient = instructionToPatient + dischargeSummary.getItemReply(); 	
					}
				}
				if(dischargeSummary.getLabel().equals("Brief Case Summary(For Printing on Discharge slip)")){
					  careSummary=dischargeSummary.getItemReply();
				}
			}
  		  }
		 }
		}catch(Exception ee){
			ee.printStackTrace();
		}
%> <script type="text/javascript">
var icdArray = new Array();
</script>


<h4>Discharge Schedule</h4>
<div class="clear"></div>
<div class="Block"><!--<label>Disch. No.:</label> <label
	class="value"><%=dischargeNo %></label> 
	--><label><span>*</span>Disch. Date:</label> 
	<input type="text" id="dobId" name="<%=DISCHARGE_DATE %>"	tabindex="1" value="<%=currentDate %>" class="calDate"
	validate="Disch. Date,date,no" MAXLENGTH="30" onblur="dateCheck();" /> 
	<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"
	          onClick="setdate('',document.dischargeByHin.<%=DISCHARGE_DATE%>,event)" />
<label><span>*</span> Disch. Time:</label> 
 <input type="text"	name="<%=DISCHARGE_TIME%>" id="dischargeTime" value="18:00"	maxlength="5" onKeyUp="mask(this.value,this,'2',':',event);"
	onblur="checkTime('dischargeByHin','<%=DISCHARGE_TIME%>')">
<div class="Clear"></div>
<label>Adm Date:</label> <label class="value"><%=admissionDate%></label>
<label>Adm Time:</label> <label class="value"><%=admissionTime %></label>
<label>Ward:</label> <label class="value"><%=inpatient.getDepartment().getDepartmentName() %></label>
<div class="Clear"></div>

<input type="hidden"	name="flag" id="flag" value="n">
</div>

<div class="Clear"></div>


<h4>Service Personal</h4>
<div class="clear"></div>
<div class="Block">
<label>Service Type:</label> <label
	class="value"><%= patient.getServiceType().getServiceTypeName()%></label>

<label>Service No:</label> <%
			if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
			%> <label class="value"><%= patient.getServiceNo()%></label> <%} else{ %>
<label class="value">-</label> <% }%> <label>Service Status:</label> <%
				if(patient.getServiceStatus() != null){
			%> <label class="value"><%= patient.getServiceStatus().getServiceStatusName()%></label>
<%} else{ %> <label class="value">-</label> <% }%>
<div class="Clear"></div>

<label>Relation:</label> <%
			if(patient.getRelation() != null){
			%> <label class="value"><%= patient.getRelation().getRelationName()%></label>
<%}  else{ %> <label class="value">-</label> <% }%> <label>Name:</label> <%
			if(patient.getSFirstName() != null && !(patient.getSFirstName().equals(""))){
				String sMiddleName = "";
				String sLastName = "";
				if(patient.getSMiddleName() != null){
					sMiddleName = patient.getSMiddleName();
				}
				if(patient.getSLastName() != null){
					sLastName = patient.getSLastName();
				}
				
				
			%> <label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}  else{ %> <label class="value">-</label> <% }%>

<div class="Clear"></div>


</div>


<div class="Clear"></div>


<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label>A&D No.:</label> <label
	class="value"><%=adNo %></label> <label>Hin No.:</label> <label
	class="value"><%=patient.getHinNo() %></label> <%
		String middleName = "";
		String lastName = "";
		if(patient.getPMiddleName() != null){
			middleName = patient.getPMiddleName();
		}
		if(patient.getPLastName() != null){
			lastName = patient.getPLastName();
		}
		
		%> <label>Patient Name:</label> <label class="value"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>
<div class="Clear"></div>

<label>Sex:</label> <label class="value"><%=patient.getSex().getAdministrativeSexName() %></label>

<label>Age:</label> <label class="value"><%=currentAge%></label>
<div class="Clear"></div>

</div>


<div class="Clear"></div>

<h4>Discharge Details</h4>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Doctor:</label> <select
	name="<%=DOCTOR_NAME %>" validate="Doctor,String,yes">
	<option value="0">Select</option>
	<%
							for(MasEmployee masEmployee : employeeList){
								if(masEmployee.getEmpCategory() != null){
									if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
										String doctorMiddleName = "";
										String doctorLastName = "";
										String rankName ="";
										
										if(patient.getPMiddleName() != null){
											doctorMiddleName = masEmployee.getMiddleName();
										}
										if(patient.getPLastName() != null){
											doctorLastName = masEmployee.getLastName();
										}
										if(masEmployee.getRank() != null){
											rankName = masEmployee.getRank().getRankName();
										}
									
										
						%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName() %>
	<%=doctorMiddleName %> <%=doctorLastName %> <%=rankName %></option>
	<% 			}
								}
							}
						%>
</select> <label><span>*</span> Disposal:</label> <select
	name="<%=DISPOSAL_ID %>" id="disposalId" validate="Disposal,String,yes"
	onchange="checkDischargeStatus(); dateandtimeExAb();">
	<option value="0">Select</option>
	<%
							for(MasDisposal masDisposal : disposalList){
						%>
	<option value="<%=masDisposal.getId() %>"><%=masDisposal.getDisposalName() %></option>
	<%} %>
</select> <label><span>*</span> Disposed To:</label> <select
	name="<%=DISPOSED_TO_ID %>" id="disposedTo"
	validate="Disposed To,String,yes"
	onchange="getOtherHospitalTextBox(this.value);checkDischargeStatus();dateandtimeExAb();">
	<option value="0">Select</option>
	<%
								for(MasDisposedTo masDisposedTo : disposedToList){
							%>
	<option value="<%=masDisposedTo.getId() %>"><%=masDisposedTo.getDisposedToName() %></option>
	<%} %>
</select>
<div id="otherHospitalId" style="display: none;"><input
	type="text" name="<%=OTHER_HOSPITAL_NAME%>" id="" maxlength="30"
	validate="Other Hospital Name,String,no"></div>
<div class="Clear"></div>


<label>Care Type:</label> <select name="<%=CARE_TYPE_ID %>"
	validate="Care Type,String,no">
	<option value="0">Select</option>
	<%
							for(MasCareType masCareType : careTypeList){
						%>
	<option value="<%=masCareType.getId() %>"><%=masCareType.getCareTypeName() %></option>
	<%} %>
</select> <label>Injury Rpt Init On:</label> <input type="text"
	id="cardValidityId" name="<%=INJURY_REPORT_INITIATED_ON %>" value=""
	class="calDate" readonly="readonly"
	validate="Injury Report Initiated On,date,no" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.dischargeByHin.<%=INJURY_REPORT_INITIATED_ON%>,event)" />
<label>Injury Rpt Init at</label> <input type="text"
	name="injury_report_init_at"
	validate="Injury Report Initiated At,string,no" MAXLENGTH="50" />
<div class="Clear"></div>

<label>Board Held On:</label> <input type="text" id="cardValidityId"
	name="<%=BOARD_HELD_ON %>" value="" class="calDate" readonly="readonly"
	validate="Board Held On,date,no" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.dischargeByHin.<%=BOARD_HELD_ON%>,event)" />

<label>Follow Up Date:</label> <input type="text" id="cardValidityId"
	name="<%=FOLLOW_UP %>" value="" class="calDate" readonly="readonly"
	validate="Follow Up Date,date,no" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.dischargeByHin.<%=FOLLOW_UP%>,event)" />

<label>Dischrg In Medical Ctgry:</label> <input type="text"
	name="<%=DISCHARGE_IN_MEDICAL_CATEGORY %>"
	validate="Discharge In Medical Category,String,no" MAXLENGTH="30" />
<div class="Clear"></div>

<label><span>*</span> Discharge Status:</label> <select
	name="<%=DISCHARGE_STATUS_ID %>" id="disSatus"
	validate="Discharge Status,String,yes"
	onchange="checkDischargeStatus();dateandtimeExAb();">
	<option value="0">Select</option>
	<%
							for(MasDischargeStatus masDischargeStatus : dischargeStatusList){
						%>
	<option value="<%=masDischargeStatus.getId() %>"><%=masDischargeStatus.getDischargeStatusName() %></option>
	<%} %>
</select> <label>Care Summary:</label> <textarea name="<%=CARE_SUMMARY %>"
	validate="Care Summary,string,no" cols="25" rows="2" /><%=careSummary%></textarea>

<label>Instructions To Patient:</label> <textarea
	name="<%=INSTRUCTIONS %>" validate="Instructions To Patient,string,no"
	cols="25" rows="2" /><%=instructionToPatient %></textarea>

<div class="Clear"></div>


<label>Document Initiated </label> <textarea name="document_initiated"
	validate="Document Initiated,string,no" cols="25" rows="2" /></textarea>



<div class="Clear"></div>


</div>


<div class="Clear"></div>
<h4>Diagnosis</h4>
<div class="clear"></div>
<div class="Block">
<%
			String diagnosis = "";
			if(dischargeIcdList.size() > 0){
				for(DischargeIcdCode dischargeIcdCode : dischargeIcdList){
					if(diagnosis.equals("")){
						if(dischargeIcdCode.getDiagnosisStatus().equals("f"))
						diagnosis = dischargeIcdCode.getIcd().getIcdName();
					}else{
						if(dischargeIcdCode.getDiagnosisStatus().equals("f"))
						diagnosis = diagnosis.concat(" , ").concat(dischargeIcdCode.getIcd().getIcdName());
					}
				}
			}
		%> <label class="large">Diagnosis:</label> <span class="valueAuto"><%=diagnosis %></span>
<input type="hidden" id="diag" value="<%=diagnosis %>">
<div class="Clear"></div>
<label class="large">Working Diagnosis (Optional):</label> <input type="text"
	maxlength="150" align="right" name="workingDiagnosis"
	id="workingDiagnosis" class="large2" />
<div class="Clear"></div>

<label class="small">Z03</label> <input type="checkbox" name="<%=Z03 %>"
	class="radio" value="z03" id="Z03"> <label class="small">Z09</label>
<input type="checkbox" name="<%=Z09%>" class="radio" value="z09"
	id="Z09">

<div class="Clear"></div>
<input type="button" class="buttonDel" value=" "
	onclick="deleteFromCombo();" align="right" /> <input type="button"
	class="buttonAdd" value=" " onclick="fillDiagnosisCombo();"
	align="right" />
<div class="Clear"></div>
<label><span>*</span>Icd Code :</label> <input name="" value="" id="icdCode" /> <input
	name="" value="" id="temp" type="hidden" /> <IMG
	SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer;" onClick="javascript:openPopupWindow();"
	title="Click here to Search ICD Codes">

<div class="Clear"></div>
<div class="tableHholderCmn">
<table width="100%" colspan="7" id="tblSample" cellpadding="0"
	cellspacing="0">
	<tbody>
		<tr>
			<th width="2%"><input type="hidden" class="checkbox"
				name="checkbox" id="checkbox" value="" /></th>
			<th width="1%">Icd Name</th>
			<td width="10%"><input type="text" align="right" name="icd"
				id="icd" size="110" />
			<div id="ac2update"	style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('icd','ac2update','ipd?method=getICDList',{parameters:'requiredField=icd'});
			</script></td>
		</tr>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<label class="medium">&nbsp;</label> <select name="<%=DIAGNOSIS_ID%>"
	size="5" multiple="65" class="listBig2" id="diagnosisId">
</select></div>

<input id="dischargeAddId" type="button" name="Submit12" value="Save" class="button" 	onClick="if(checkSilDilPatient()&& disposedAbsentia() && checkExpiry()&& checkDischargeInAB()&& dischargeDateEmptyCheck()){submitForm('dischargeByHin','/hms/hms/adt?method=submitDischargeInformation')};" />
<input type="reset" name="Reset" value="Reset" class="button"
	accesskey="r" /> 
<!--<input id="expiryDetailsId" type="button" name="expiry" value="Expiry Details" class="buttonbig" style="display: none;"
	onClick="if(checkSilDilPatient() && dateandtimeExAb()){submitForm('dischargeByHin','/hms/hms/adt?method=submitDischargeInformation&flag=expiry');}" />
--><input id="expiryDetailsId" type="button" name="expiry" value="Expiry Details" class="buttonbig" style="display: none;"
	onClick="if(checkSilDilPatient() ){submitForm('dischargeByHin','/hms/hms/adt?method=submitDischargeInformation&flag=expiry');}" />

<input type="button" class="button" value="Back" align="right"
	onClick="history.back();" />

<div class="Clear"></div>

<div class="bottom">
 <label>Changed By</label> 
 <label	class="value"><%=userName%></label> 
 <label>Changed Date</label> 
 <label	class="value"><%=currentDate%></label> 
 <label>Changed Time</label> 
 <label class="value"><%=currentTime%></label> 
 <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
 <input type="hidden" name="<%=CHANGED_DATE %>" id="currentDate" value="<%=currentDate%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
<input type="hidden" name="hdb" value="1" id="hdb" /> 
<input type="hidden" name="<%=DISCHARGE_NO %>" value="<%=dischargeNo%>">
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>">
<input type="hidden" name="<%=AD_NO %>" value="<%=adNo %>"> 
<input type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatient.getId() %>">
<%if(inpatient.getBed()!=null){ %>
<input type="hidden" name="<%=BED_ID%>"	value="<%=inpatient.getBed().getId()%>">
<%}else{ %> 
<input type="hidden" name="<%=BED_ID%>"	value="">
<%} %>
<input type="hidden" name="<%=DEPARTMENT_ID%>" value="<%=inpatient.getDepartment().getId()%>">
<input type="hidden" name="rights" id="rights" value="<%=right%>">
</div>


<script>
function dateCheck(){
    var disDate = document.getElementById('dobId')
    var curDate = document.getElementById('currentDate')
    var right   = document.getElementById('rights').value
    var disDate1   = new Date(disDate.value.substring(6),(disDate.value.substring(3,5) - 1) ,disDate.value.substring(0,2));
	var currdate = new Date(curDate.value.substring(6),(curDate.value.substring(3,5) - 1) ,curDate.value.substring(0,2));
	currdate.setDate(currdate.getDate() - 2);
	if(right == "n"){
		if(disDate1.value != "" && currdate.value != ""){
			 if(disDate1 < currdate){
				  alert("Discharge date should not be less than 2 day before today's date !");
				  document.getElementById('dobId').value ="";
				  return false;
			  }
			  else{ return true;
			  }
		}else{
		   return false;
		}
	}else{
		return true;
	}
}
	
	function DischargeDateCheck(){
	 var disDate = document.getElementById('dobId').value
	if(disDate < '<%=admissionDate%>' ){
	alert("Discharge date should be great or equal to admission date ")
	return false;
	}
	return true;
  }	
		function getIcd(){
 //=========To get Icd String with icd code==========================
var icdCode =document.getElementById("icdCode").value

 if(icdCode !="")
  {
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
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	         icdString  = item.getElementsByTagName("icdString")[0];
	          var val =icdString.childNodes[0].nodeValue
	        	 if(val !="" && val !="NO"){
  				  var index1 = val.lastIndexOf("[");
				  var index2 = val.lastIndexOf("]");
	    		 index1++;
	    		 var id = val.substring(index1,index2);

	        	 obj =document.getElementById('diagnosisId'); 
				 obj.length = document.getElementById('diagnosisId').length;
	        	obj.length++;
	        	if(document.getElementById("Z09").checked == true ){
					id ="["+id+"]" +"{OLD}"
					val =val +"{OLD}"
				}else if(document.getElementById("Z03").checked == true){
				 id ="["+id+"]" +"{NAD}"
					val =val +"{NAD}"
				}
				else{
				id ="["+id+"]" 
				}
				obj.options[obj.length-1].value=id
				obj.options[obj.length-1].text=val
				document.getElementById('icdCode').value =""
				 }else{
				 alert("Wrong Icd Code ...!")
				 document.getElementById('icdCode').value =""
				 return false
				 }
      }
      }
      }
    var url="/hms/hms/adt?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  
  }
  //==================End of Icd String block======================
}
function mask(str,textbox,loc,delim,e){
		keycode = e.which;
			if(keycode != 8){
				var locs = loc.split(','); 
				for (var i = 0; i <= locs.length; i++){
					for (var k = 0; k <= str.length; k++){
						if (k == locs[i]){
							if (str.substring(k, k+1) != delim){
								str = str.substring(0,k) + delim + str.substring(k,str.length)
							}
				 
						}
				 	}
				}
				textbox.value = str
			}
}

function checkExpiry()
{
var disSatus=document.getElementById('disSatus');
var disposedTo=document.getElementById('disposedTo');
var disposalId=document.getElementById('disposalId');

    if(disSatus.value==3 && disposedTo.value==16 && disposalId.value==8){
       return true;
	}
	if(disSatus.value==3 || disposedTo.value==16 || disposalId.value==8){
		alert('Expiry is to be filled in all dispose, dispose to ,discharge Status ');
		return false;
	
	}else{
		return true ;
	}
}
function dischargeDateEmptyCheck(){
    var disDate = document.getElementById('dobId')
    var disTime = document.getElementById('dischargeTime')	
	if(disDate.value == "" || disTime.value == ""){
		alert("Discharge date and Time should not be blank!");
		document.getElementById("dobId").focus();
		return false;
	}
	else{
	    return true;
	}

}
function checkDischargeInAB()
{
var disSatus=document.getElementById('disSatus');
var disposedTo=document.getElementById('disposedTo');
var disposalId=document.getElementById('disposalId');

	if(disSatus.value==15 || disposedTo.value==14 || disposalId.value==9){
		if(disSatus.value==15 && disposedTo.value==14 && disposalId.value==9){
		return true;
		}else{
		alert('Discharge in Absentia is to be filled in all dispose, dispose to ,discharge Status ');
		return false;
		}
	}else{
		return true ;
	}
}
function dateandtimeExAb()
{
var disSatus=document.getElementById('disSatus');
var disposedTo=document.getElementById('disposedTo');
var disposalId=document.getElementById('disposalId');
var dischargeDate= document.getElementById('dobId');
var dischargeTime=document.getElementById('dischargeTime');
var msg=''
if((disSatus.value != 15 && disposedTo.value!=14 && disposalId.value!=9)||(disSatus.value !=3 && disposedTo.value!=16 && disposalId.value!=8))
{
		document.getElementById('flag').value = 'n';
}
if((disSatus.value==15 && disposedTo.value==14 && disposalId.value==9)||(disSatus.value==3 && disposedTo.value==16 && disposalId.value==8))
{
	var a = document.getElementById('flag').value;
	
	
	//if(dischargeDate.value=="<%=currentDate%>" && dischargeTime.value=="18:00") commented by Vishal for removing 18:00 condition
	if(a == 'n')
	
	{
		document.getElementById('flag').value = 'y';
		dischargeDate.value="";
		dischargeTime.value="";
		dischargeDate.focus();
		
		alert("Discharge Date And Discharge Time is to be changed ");
		var a = document.getElementById('flag').value;
		return false;
	} 	
	if(dischargeDate.value=="" || dischargeTime=="")
	{
		
		dischargeDate.focus();
		alert("Discharge Date And Discharge Time is Mandatory");
		return false;
	}	
	
}else{

return true;
}
return true;
}

function disposedAbsentia(){
 var disTo = document.getElementById('disSatus').value;
     var dobId = document.getElementById('dobId').value;
     var disDate = new Date(dobId.substring(6),(dobId.substring(3,5) - 1) ,dobId.substring(0,2));
 	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);
    if(disTo == "15"){
	if(disDate > currentDate)
 	{
     alert("Discharge Date should not be greater than current date \n When disposedTo is Discharge in Absentia");
		return false;
 	}else{
 	    return true;
 	}}else{
 	return true;
 	}
}
		
		function deleteFromCombo(){
		var obj = document.getElementById("diagnosisId");
		var val = obj.value;
		for(i=0;i<obj.length;i++)
		{
			if(obj.options[i].selected == true){
			obj.options[i].text=""
			obj.options[i].value=""
			}
		
			}
		}
		
		function fillDiagnosisCombo() {
		var val =document.getElementById("icd").value
		//By using ICD Name
			if(val !=""){
  			    var index1 = val.lastIndexOf("[");
		        var index2 = val.lastIndexOf("]");
	            index1++;
	            var id = val.substring(index1,index2);
				obj =document.getElementById('diagnosisId'); 
				obj.length = document.getElementById('diagnosisId').length;
		
	        	obj.length++;
	        	
				if(document.getElementById("Z09").checked == true ){
					id ="["+id+"]" +"{OLD}"
					val =val +"{OLD}"
				}else if(document.getElementById("Z03").checked == true ){
				    id ="["+id+"]" +"{NAD}"
					val =val +"{NAD}"
				}else{
					id ="["+id+"]" 
				}
				obj.options[obj.length-1].value=id
				obj.options[obj.length-1].text=val
				document.getElementById('icd').value =""
				}else{
				//By using ICD Code
				getIcd();
				}
  			}
  			
		function checkSilDilPatient(){
		//Check for diagnosis blank
		
		if(document.getElementById('diag').value == ""){
		if(document.getElementById('diagnosisId').length =="0"){
			alert("Diagnosis should not blank ")
			return false
		}else{
		var temp = document.getElementById("diagnosisId");
			ln= temp.length;
			for(i=0;i<temp.length;i++)
			{
    			if(temp.options[i].text =="")
    			ln--;
			}
			if(ln=="0"){
			alert("Diagnosis should not blank ")
			return false
			}
		
			var obj = document.getElementById("diagnosisId");
			var val = obj.value;
			for(i=0;i<obj.length;i++)
			{
    			obj.options[i].selected=true
			}
			
			}
		 }
		<%
		if(inpatient.getConditionStatus().equals("SIL") || inpatient.getConditionStatus().equals("DIL") ){
		%>
			var agree = confirm("Patient is SIL/DIL.Do you want to discharge patient.");
			if (agree)
				return true ;
			else
				return false 
		<%}%>
		return true;
		}
		
		
		</script> <%	
			
		 }else{
		%>
<table width="100%" height="20" border="0" align="center"
	cellpadding="0" cellspacing="0">
	<tr>
		<td>
		<h2><font id="error">Patient is Ready To Discharge </font></h2>
		</td>
	</tr>
</table>


<%}%>
<div id="statusMessage" class="messagelabel"><br />
</div>

<script type="text/javascript">


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

function addRow(){
var icdString =document.getElementById("temp").value;

if(document.getElementById("Z09").checked == true && icdString !="NO" && icdString !=""){
	icdString =icdString +"{OLD}"
}else if(document.getElementById("Z03").checked == true && icdString !="NO" && icdString !=""){
	icdString =icdString +"{NAD}"
}
if(icdString !="NO"){
	if(document.getElementById("icd").value==""){
		document.getElementById("icd").value =icdString
		document.getElementById("temp").value=""
		document.getElementById("icdCode").value =""
		return false;
	}
	}else{
	alert("ICD Code does not exists...!")
  		document.getElementById("icdCode").value =""
  		document.getElementById("temp").value =""
  		return true
	}

	if(icdString != "NO"){
  var tbl = document.getElementById('tblSample');
  var lastRow = tbl.rows.length;
  // if there's no header row in the table, then iteration = lastRow + 1
  var iteration = lastRow+1;
  var row = tbl.insertRow(lastRow);
	if(document.getElementById('hdb').value < iteration){
  			var hdb = document.getElementById('hdb');
  			hdb.value=iteration
  }
 var cellRight2 = row.insertCell(0);
  var e2 = document.createElement('input');
  e2.type = 'checkbox';
  cellRight2.appendChild(e2);
 
  var cellRight0 = row.insertCell(1);
  var e0 = document.createElement('label');
  e0.type = 'label';
  e0.innerHTML = 'Icd Name '+iteration+':';
  e0.className = 'smalllabel'
  cellRight0.appendChild(e0);
  
   var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.name = 'icd' + iteration;
	  sel.id = 'icd' + iteration;
	  sel.type = 'text';
	  sel.value =icdString;
	  sel.className = 'bigcaptionIcd'
	  
	  cellRightSel.appendChild(sel);
	  new Ajax.Autocompleter('icd'+iteration,'ac2update','ipd?method=getICDList',{parameters:'requiredField=icd'+iteration});
  cellRightSel.appendChild(sel);
  document.getElementById("icdCode").value =""
  document.getElementById("temp").value =""
  }else{
  		alert("ICD Code does not exists...!")
  		document.getElementById("icdCode").value =""
  		document.getElementById("temp").value =""
  		return true
  }
    
}

function check(){
alert("@#@!#@")
}

function removeRowForUpdateDischarge(argIndex,idName){
	
	         var table=document.getElementById(idName);
	         var tblRows  = table.getElementsByTagName("tr");
	         var check=0;
	         
	         for(i=tblRows.length-1;i>0;i--)
	        {         
	         var tblCtrl =  tblRows[i].getElementsByTagName("input"); 
	         
	         
	               for(j=0;j<tblCtrl.length;j++)
	               {
	                  if(tblCtrl[j].type == 'checkbox')
	                   {    
	                    if(tblCtrl [j].checked)
	                              check=check+1;
	                   }
	               }
	        }
			
	        for(i=tblRows.length-1;i>0;i--)
	        {         
	         var tblCtrl =  tblRows[i].getElementsByTagName("input"); 
	         
	               for(j=0;j<tblCtrl.length;j++)
	               {
	                  if(tblCtrl[j].type == 'checkbox')
	                   {    
	                    if(tblCtrl [j].checked)
	                              document.getElementById(idName).deleteRow(i);
	                   }
	               }
	        }
     }
     

function removeRow()
{
  var tbl = document.getElementById('tblSample');
  var lastRow = tbl.rows.length;
  if (lastRow >= 2) tbl.deleteRow(lastRow - 1);
}

function getOtherHospitalTextBox(disposalId){

if(disposalId == 12){
	document.getElementById('otherHospitalId').style.display = 'inline';
}else{
	document.getElementById('otherHospitalId').style.display = 'none';
return true;
}
}

</script></form>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>


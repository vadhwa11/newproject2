<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientTransferSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasEcgType"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.PatientDetentionRegister"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>

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
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTimeWithoutSc");
 
 		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		List<PatientDetentionRegister> detentionList = new ArrayList<PatientDetentionRegister>();
		if(map.get("detentionList")!=null){
			detentionList = (List<PatientDetentionRegister>)map.get("detentionList");
		}
		PatientDetentionRegister detentionRegister = new PatientDetentionRegister();
		if(detentionList.size() > 0){
			detentionRegister = detentionList.get(0);
		}
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
		List<PatientInvestigationDetails> investigationList = new ArrayList<PatientInvestigationDetails>();
		List<PatientPrescriptionDetails> prescriptionList = new ArrayList<PatientPrescriptionDetails>();
		List<ProcedureDetails> procedureList = new ArrayList<ProcedureDetails>();
		if(map.get("investigationList")!=null){
			investigationList = (List<PatientInvestigationDetails>)map.get("investigationList");
		}
		if(map.get("prescriptionList")!=null){
			prescriptionList = (List<PatientPrescriptionDetails>)map.get("prescriptionList");
		}
		if(map.get("procedureList")!=null){
			procedureList = (List<ProcedureDetails>)map.get("procedureList");
		}
	%>
	<h4><%=message %></h4>
<h2>Patient Detention Register</h2>
<div class="clear"></div>
<form name="minorSurgery" action="" method="post">
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<!--<label><span>*</span>   Date</label> 
<input	type="text" name="detentionDate" value="<%= currentDate %>" MAXLENGTH="30" id="referralDate" validate="Date,string,yes" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.minorSurgery.referralDate,event)" /> 

-->
<label> Service No. <span>*</span></label>
<label class="value"><%=detentionRegister.getHin().getServiceNo()!=null?detentionRegister.getHin().getServiceNo():"" %></label>

<label>Patient Name</label> 
<%
String middleName = "";
String lastName = "";
if(detentionRegister.getHin().getPMiddleName() != null){
	middleName = detentionRegister.getHin().getPMiddleName();
}
if(detentionRegister.getHin().getPLastName() != null){
	lastName = detentionRegister.getHin().getPLastName();
}

%>
<label class="value"><%=detentionRegister.getHin().getPFirstName()+" "+middleName+" "+lastName %></label>
<div class="Clear"></div>

<label>Relation</label> 
<label class="value"><%=detentionRegister.getHin().getRelation().getRelationName()%></label>

<label>Rank</label> 
<label class="value"><%=detentionRegister.getHin().getRank().getRankName()%></label> 

<label>Name</label> 
<%
String sMiddleName = "";
String sLastName = "";

	if(detentionRegister.getHin().getSMiddleName() != null){
		sMiddleName = detentionRegister.getHin().getSMiddleName();
	}
	if(detentionRegister.getHin().getSLastName() != null){
		sLastName = detentionRegister.getHin().getSLastName();
	}
%>
<label class="value"><%=detentionRegister.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName %></label>  
<div class="Clear"></div>
<label>Unit</label> 
<label class="value"><%=detentionRegister.getHin().getUnit().getUnitName()%></label>

<label>Branch/Trade</label> 
<label class="value"><%=(detentionRegister.getHin().getTrade()!=null?detentionRegister.getHin().getTrade().getTradeName():"")%></label>

<label> Age</label> 
<label class="value"><%=(detentionRegister.getHin().getAge()!=null ? detentionRegister.getHin().getAge(): "")%></label>
<div class="Clear"></div>

<label> Gender</label> 
<label class="value"><%=(detentionRegister.getHin().getSex()!=null ? detentionRegister.getHin().getSex().getAdministrativeSexName(): "")%></label>


<label> Diagnosis <span>*</span>  </label> 
<%
Visit visit = new Visit();
String diagnosis = "";
Set<OpdPatientDetails> patientDetails = new HashSet<OpdPatientDetails>();
Set<DischargeIcdCode> icdSet = new HashSet<DischargeIcdCode>();

	if(detentionRegister.getVisit()!=null){
		visit = detentionRegister.getVisit();
		if(visit.getDischargeIcdCodes()!= null){
			icdSet = visit.getDischargeIcdCodes();
		}
		if(visit.getOpdPatientDetails()!= null){
			patientDetails = visit.getOpdPatientDetails();
			for(OpdPatientDetails opdPatientDetails : patientDetails){
				if(opdPatientDetails.getInitialDiagnosis()!= null){
					diagnosis = opdPatientDetails.getInitialDiagnosis();
				}else{
					if(icdSet.size() > 0){
						for(DischargeIcdCode icdCode : icdSet){
							if(!diagnosis.equals("")){
								diagnosis += ",";
							}
							diagnosis += icdCode.getIcd().getIcdName();
						}
					}
					
				}
			}
		}
		
	}
%>
<label class="value"><%=diagnosis %></label>


<label> Medical Officer</label> 
<%
String doctorName = detentionRegister.getMedicalOfficer().getRank().getRankName()+" "+detentionRegister.getMedicalOfficer().getFirstName();
if(detentionRegister.getMedicalOfficer().getMiddleName()!= null){
	doctorName += " "+detentionRegister.getMedicalOfficer().getMiddleName();
}
if(detentionRegister.getMedicalOfficer().getLastName()!= null){
	doctorName += " "+detentionRegister.getMedicalOfficer().getLastName();
}
%>
<label class="value"><%=doctorName %></label>


<div class="Clear"></div>

<label> Additional Advice <span>*</span></label> 
<textarea rows="" cols="" name="treatment" maxlength="50"  onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=(detentionRegister.getTreatment()!=null?detentionRegister.getTreatment():"") %></textarea>
</div>
<div class="clear"></div>

<div class="paddingTop15"></div>

<div class="clear"></div>
<h4>Treatment Details</h4>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Nomenclature</th>
		<th scope="col">PVMS No.</th>
		<th scope="col">Dose</th>
		<th scope="col">Route</th>
		<th scope="col">Frequency</th>
		<th scope="col">No.of Days</th>
		<th scope="col">Issue Qty</th>
		<th scope="col">Remarks</th>
	</tr>
	<%
		if(investigationList.size() > 0){
			for(PatientPrescriptionDetails prescriptionDetails : prescriptionList){
	%>
	<tr>
	<td><%=prescriptionDetails.getItem().getNomenclature() %></td>
	<td><%=prescriptionDetails.getItem().getPvmsNo() %></td>
	<td><%=(prescriptionDetails.getDosage()!=null?prescriptionDetails.getDosage():"") %></td>
	<td><%=(prescriptionDetails.getRoute()!=null?prescriptionDetails.getRoute():"") %></td>
	<td><%=(prescriptionDetails.getFrequency()!=null?prescriptionDetails.getFrequency().getFrequencyName():"") %></td>
	<td><%=(prescriptionDetails.getNoOfDays()!=null?prescriptionDetails.getNoOfDays():"")%></td>
	<td><%=(prescriptionDetails.getQtyIssued()!=null?prescriptionDetails.getQtyIssued():"") %></td>
	<td><%=(prescriptionDetails.getRemarks()!=null?prescriptionDetails.getRemarks():"") %></td>
	</tr>
	<%}
			}%>
</table>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Investigation</h4>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Test</th>
	</tr>
	<%
		if(investigationList.size() > 0){
			for(PatientInvestigationDetails investigationDetails : investigationList){
	%>
	<tr>
	<td><%=investigationDetails.getChargeCode().getChargeCodeName() %></td>
	</tr>
	<%}
			}%>
</table>
<div class="paddingTop15"></div>
<h4>Procedure Details</h4>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Procedure Name</th>
		<th scope="col">Remarks</th>
	</tr>
	<%
		if(procedureList.size() > 0){
			for(ProcedureDetails procedureDetails : procedureList){
	%>
	<tr>
	<td><%=procedureDetails.getNursingCare().getNursingName() %></td>
	<td><%=procedureDetails.getRemarks()!=null?procedureDetails.getRemarks():"" %></td>
	</tr>
	<%}
			}%>
</table>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Detention Details</h4>
<div class="clear"></div>
<div class="Block">

<label> From Date <span>*</span></label> 
<input	type="text" name="detentionFromDate" id="detentionFromDate" validate="Detained From,string,yes" value="<%=(detentionRegister.getDetainedFrom()!=null?HMSUtil.convertDateToStringWithoutTime(detentionRegister.getDetainedFrom()):"") %>" class="date" readonly="readonly" MAXLENGTH="50"  />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.minorSurgery.detentionFromDate,event)" /> 

<label> Time <span>*</span></label> 
 <input	type="text" name="fromTime" id="fromTime" validate="From Time,string,yes" value="<%=(detentionRegister.getFromTime()!=null?detentionRegister.getFromTime():"") %>" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	 MAXLENGTH="5"  />
 
 
<div class="Clear"></div>

<label> To Date<span>*</span></label> 
<input	type="text" name="detentionToDate" id="detentionToDate" validate="To,string,yes" value="<%=(detentionRegister.getDetainedTo()!=null?HMSUtil.convertDateToStringWithoutTime(detentionRegister.getDetainedTo()):"") %>" MAXLENGTH="8" class="date" readonly="readonly"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.minorSurgery.detentionToDate,event)" /> 


<label> Time <span>*</span></label> 
<input	type="text" name="toTime" id="toTime" validate="To Time,string,yes" value="<%=(detentionRegister.getToTime()!=null?detentionRegister.getToTime():"") %>" MAXLENGTH="5" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	 />
<input type="hidden" name="detentionId" value="<%=detentionRegister.getId() %>"/>
<div class="Clear"></div>
<label> Remarks</label> 
<textarea rows="" cols="" class="large" name="<%=REMARKS %>" maxlength="100"  onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=(detentionRegister.getRemarks()!=null?detentionRegister.getRemarks():"") %></textarea>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton"
	onclick="submitForm('minorSurgery','/hms/hms/registration?method=savePatientDetentionDetails');"
	value="Submit" class="button" accesskey="a" />

<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />
<div class="Clear"></div>
<div class="division"></div>
 <div class="bottom">
<label>Changed By:</label>   
<label class="value"><%=userName%></label>
        
<label>Changed Date:</label>   
<label class="value"><%=currentDate%></label>
 
<label>Changed Time:</label>   
<label class="value"><%=time%></label>
 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=currentDate%>"  />
<input type="hidden" name="<%=LAST_CHANGED_TIME %>"  value="<%=time%>" />
<div class="Clear"></div>

</div>
</form>


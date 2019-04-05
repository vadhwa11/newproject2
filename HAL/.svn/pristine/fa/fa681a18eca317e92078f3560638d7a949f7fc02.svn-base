<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 *intakeOutput.jsp  
 * Purpose of the JSP -  This is for Intake Output.
 * @author  Dipali
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%@page import="jkt.hms.masters.business.AllergyDetail"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.IpdIntakeOutputChart"%>
<%@page import="jkt.hms.masters.business.IpdIntake"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.IpdIntakeOutput"%>
<%@page import="jkt.hms.masters.business.IpdOutput"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<%	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTimeWithoutSc");
	Map map = new HashMap();
	String max="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		List inPatientDetailList = new ArrayList();
		List<IpdIntakeOutputChart> intakeOutputList = new ArrayList<IpdIntakeOutputChart>();
		if(map.get("intakeOutputList")!=null){
			intakeOutputList = (List<IpdIntakeOutputChart>) map.get("intakeOutputList");
		}

		String deptName="";
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		int inpatientId = 0;
		if (map.get("inpatientId") != null) {
			inpatientId = Integer.parseInt(""+map.get("inpatientId")) ;
		}
		try{
			inPatientDetailList=(List)map.get("inPatientDetailList");
							
		}catch(Exception e){
			e.printStackTrace();
		}
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String currenDate = (String) utilMap.get("currentDate");
		int hospitalId = 0;
	
		String admissionNumber = "";
		String patientName = "";
		String serviceno = "";
		String rank = "";
		String unit = "";
		String adNo = "";
		String ward = "";
		String relation = "";
		String diagnosis = "";
		String sex = "";
		String doa = "";
		String serviceType = "";
		int departmentId =0;
		int hinId = 0;
		Inpatient inpatient = null;
		Patient patient = null;
		MasRank masRank = null;
		MasUnit masUnit = null;
		MasDepartment masDepartment=null;
		MasDiagnosisConclusion masDiagnosisConclusion=null;
		MasRelation masRelation = null;
		String category_name = "";
		String consultantName = "";
		
		//-----Details for Report-------
		String hinNo="";
		String andNo ="";
		String initDiagnosis ="";
		
		String currentAge = "";
	   if(inPatientDetailList != null)
	   {
		   
		   inpatient=(Inpatient)inPatientDetailList.get(0);
		   patient = (Patient) inpatient.getHin();
		    hinId=inpatient.getHin().getId();
		    hinNo=inpatient.getHinNo();
		    andNo=inpatient.getAdNo();
		    String age = "";
		    if(patient.getAge()!=null)
				age = patient.getAge();
			try{
				if(!age.equals(""))
				currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
			}catch(Exception ex){
				ex.printStackTrace();
			}
			try
			{
				
				admissionNumber=inpatient.getAdNo();
			    session.setAttribute("admissionNumber",admissionNumber);
				
						try 
						{
							patientName = inpatient.getHin().getPFirstName() ;
							  
							   if(inpatient.getHin().getPMiddleName()!= null){
								   patientName=patientName+" "+inpatient.getHin().getPMiddleName();
							   }
							   if(inpatient.getHin().getPLastName()!= null){
								   patientName=patientName+" "+inpatient.getHin().getPLastName();
							   }
							
						} 
						catch (Exception e) 
						{
							patientName = "";
						}
						
						
						try 
						{
							/* consultantName=inpatient.getDoctor().getRank().getRankName(); */
							consultantName +=" "+ inpatient.getDoctor().getFirstName();
							if(inpatient.getDoctor().getMiddleName() != null){
								consultantName += " "+inpatient.getDoctor().getMiddleName();
							}
							if(inpatient.getDoctor().getLastName() != null){
								consultantName += " "+inpatient.getDoctor().getLastName();
							}
						} 
						catch (Exception e){ 

							consultantName = "";
						}
						
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	   }
	    List<IpdIntake> intakeList = new ArrayList<IpdIntake>();
		List<IpdOutput> outputList = new ArrayList<IpdOutput>();
		if(map.get("intakeList")!=null){
			intakeList = (List<IpdIntake>) map.get("intakeList");
		}
		if(map.get("outputList")!=null){
			outputList = (List<IpdOutput>) map.get("outputList");
		}
	   
	%>
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


<div class="titleBg"><h2>Intake/Output Chart</h2></div>
<div class="Clear"></div>
<!--<h4><%=deptName%></h4>
--><div class="Clear"></div>
<form name="intakeOutput" method="post" action="">
<input	type="hidden" name="inpatientId" value="<%=inpatientId %>">
<input	type="hidden" name="hinNo" value="<%=hinNo%>">
<input	type="hidden" name="andNo" value="<%=andNo %>">
<input type="hidden" name="deptName" id="deptName"	value="<%=deptName %>" />
<div class="Clear"></div>
<h4>Patient Details</h4>
<div class="Clear"></div>
<div class="Block">

<label>A&D No.</label> <%if(inpatient.getAdNo() != null){ %>
<label class="value"><%=inpatient.getAdNo() %></label> <%}else{ %>
<label class="value">-</label>
<%} %>
<label>Employee No.</label> 
<label class="value"> <%=patient.getServiceNo()!=null?patient.getServiceNo():"" %></label>

<label>Ward </label> <%if(inpatient.getDepartment() != null){ %>
<label class="value"> <%=inpatient.getDepartment().getDepartmentName() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<div class="Clear"></div>
<label>Patient Name</label>
<label	class="value"> <%= patientName %></label>

<label>Relation</label> <%
	if(patient.getRelation() != null){
	%> 
<label class="value"><%= patient.getRelation().getRelationName()%></label>
<%} else{ %> <label
	class="value">-</label> 
	<% }%> 

<label>Designation</label>
<label class="value"><%=patient.getRank()!=null?patient.getRank().getRankName():"" %></label>
<div class="Clear"></div>
<label>Employee Name</label> <%
		String sMiddleName = "";
		String sLastName = "";
		if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
		
			if(patient.getSMiddleName() != null){
				sMiddleName = patient.getSMiddleName();
			}
			if(patient.getSLastName() != null){
				sLastName = patient.getSLastName();
			}
	 %> 
<label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> 
<label class="value">-</label> 
<% }%>
<%-- 
<label>Branch/Trade</label>
<%
if(patient.getTrade() != null){
%> 
<label class="value"><%=  patient.getTrade().getTradeName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%>

 --%>
 <%-- 
<label>Unit</label> <%
if(patient.getUnit() != null){
%> <label class="value"><%= patient.getUnit().getUnitName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%> --%>
<!-- <div class="Clear"></div> -->
<label>Age</label> <%if(!currentAge.equals("")){ %>
<label class="value"> <%=currentAge %></label> <%}else{ %>
<label	class="value">-</label> <%} %>
<label>Gender</label> <%if(patient.getSex() != null){ %>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<%-- 
<label>Med Cat</label>
<label class="value"><%=patient.getCategory()!=null?patient.getCategory().getCategories():"-" %></label>
 --%>
<div class="Clear"></div>

<label>Admitting Doctor</label>
<label class="value"><%=consultantName %></label>
<%-- 
<label>Allergies</label>
<%
String allergies = "";
	if(patient.getDrugAllergies()!=null){
/*	for(AllergyDetail allergyDetail : patient.getAllergyDetails()){
		if(!allergies.equals("")){
			allergies += ",";
		}
		allergies += allergyDetail.getDescription();
	}*/
		allergies = patient.getDrugAllergies();
}%>
<%
	if(!allergies.equals("")){
%>
<label class="valueAuto"><%=allergies %></label>
<%}else{ %>
<label class="value"></label>
<%} %> --%>
<!-- <div class="Clear"></div> -->


<label> Diagnosis</label> 
<%
List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
if(map.get("diagnosisList")!=null){
	diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
	
}
if(diagnosisList != null && diagnosisList.size() > 0 && diagnosisList.get(0).getIcd()!=null)
{
%> <label class="valueFixedWidth"><%=diagnosisList.get(0).getIcd().getIcdName()%></label>
<%
		}else{
		%> <label class="value"></label> <%	
		}
		%> 
<%-- 		
<label>Disability</label>
<%
	List<MasMedicalExaminationDetail> disabilityList = new ArrayList<MasMedicalExaminationDetail>();
	if(map.get("disabilityList")!=null){
		disabilityList = (List<MasMedicalExaminationDetail>)map.get("disabilityList");
	}
	
	if(disabilityList != null && disabilityList.size() > 0)
	{
	%> <label class="valueFixedWidth"><%=disabilityList.get(0).getMasIcd()!=null?disabilityList.get(0).getMasIcd().getIcdName():"" %></label>
<%
	}else{
	%> <label class="value"></label> <%	
	}
%> 
 --%>
<div class="Clear"></div>

</div>
<div class="Clear"></div>
<input	type="hidden" name="<%=AD_NO %>"	value="<%=inpatient.getAdNo() %>" /> 
<input type="hidden" name="<%=DEPARTMENT_ID %>"	value="<%=inpatient.getDepartment().getDepartmentName() %>" />

<input type="hidden" value="<%=adNo%>" name="<%=ADMISSION_NUMBER %>" />
<input type="hidden" value="<%=currenDate%>" name="<%=TO_DATE %>" />
<input	type="hidden" value="<%=currenDate%>" name="<%=FROM_DATE %>" />
<input	type="hidden" name="hinId" value="<%=hinId%>" />
<div class="Clear"></div>

<!-- Commented By Ritu -->
<!--
<input	type="button" class="buttonAdd" value=" "	onclick="generateRow('intakeOutputId');" align="right" />
<input	type="button" class="buttonDel" value=" "	onclick="removeRow(this,'intakeOutputId');" align="right" />
<div class="cmntable">
<table width="99%" colspan="7" id="intakeOutputId" border="0"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="2%">&nbsp;</th>
			<th width="3%">Date</th>
			<th width="3%">Time</th>
			<th colspan="2">Temperature</th>
			<th colspan="2">Pulse</th>
			<th colspan="2">Respiration</th>
			<th colspan="2">BP</th>
			<th width="6%">Bowel</th>
			<th width="6%">Pain</th>
			<th colspan="2">FHR</th>
			<th width="16%">Remarks</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td width="2%">
			<input type="checkbox" name="checkbox" value="" />
			</td>
			<td width="3%">
			<input type="hidden" name="srNO" />
			<input	type="text" size="10" value="<%=date%>" name="<%=TEMPERATURE_DATE%>" validate="Date,date,no" />
			</td>
			<td width="3%"><input type="text" size="8" value="<%=time%>"
				name="<%=TEMPERATURE_TIME%>"
				onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);" /></td>
			<td width="8%"><label><sup>&deg;</sup>F</label></td>
			<td width="8%"><select name="<%=TEMPERATURE %>" class="auto">
				<option value="0">Select</option>
				<option value="97">97</option>
				<option value="97.2">97.2</option>
				<option value="97.4">97.4</option>
				<option value="97.6">97.6</option>
				<option value="97.8">97.8</option>
				<option value="98">98</option>
				<option value="98.2">98.2</option>
				<option value="98.4">98.4</option>
				<option value="98.6">98.6</option>
				<option value="98.8">98.8</option>
				<option value="99">99</option>
				<option value="99.2">99.2</option>
				<option value="99.4">99.4</option>
				<option value="99.6">99.6</option>
				<option value="99.8">99.8</option>
				<option value="100">100</option>
				<option value="100.2">100.2</option>
				<option value="100.4">100.4</option>
				<option value="100.6">100.6</option>
				<option value="100.8">100.8</option>
				<option value="101">101</option>
				<option value="101.2">101.2</option>
				<option value="101.4">101.4</option>
				<option value="101.6">101.6</option>
				<option value="101.8">101.8</option>
				<option value="102">102</option>
				<option value="102.2">102.2</option>
				<option value="102.4">102.4</option>
				<option value="102.6">102.6</option>
				<option value="102.8">102.8</option>
				<option value="103">103</option>
				<option value="103.2">103.2</option>
				<option value="103.4">103.4</option>
				<option value="103.6">103.6</option>
				<option value="103.8">103.8</option>
				<option value="104">104</option>
				<option value="104.2">104.2</option>
				<option value="104.4">104.4</option>
				<option value="104.6">104.6</option>
				<option value="104.8">104.8</option>
				<option value="105">105</option>
				<option value="105.2">105.2</option>
				<option value="105.2">105.4</option>
				<option value="105.6">105.6</option>
				<option value="105.8">105.8</option>
				<option value="106">106</option>
			</select></td>
			<td width="15%"><label>/min</label></td>
			<td width="15%"><input type="text" size="5" value=""
				name="<%=PULSE%>" id="pulse" validate="Pulse,int,no"
				onchange="checkPulseIntakeValidation(this.value);" MAXLENGTH="5" /></td>
			<td width="15%"><label>/min</label></td>
			<td width="15%"><input type="text" size="5" value=""
				name="<%=RESPIRATION%>" id="respiration"
				validate="Respiration,int,no"
				onchange="checkRespirationIntakeValidation(this.value);"
				MAXLENGTH="5" /></td>
			<td width="15%"><label>mm/hg</label></td>
			<td width="15%"><input type="text" size="8" value=""
				name="<%=BP%>" id="bp"
				onchange="checkBpIntakeValidation(this.value);"
				onblur="validateBpWithSlash(this.value);" MAXLENGTH="7" /></td>
			<td width="6%"><input name="<%= BOWEL%>"
				onchange="changeStatus();" value="" size="10" maxlength="3"
				tabindex=1> </select></td>
			<td width="6%"><select name="<%= PAIN%>"
				onchange="changeStatus();" tabindex=1 class="auto">
				<option value="0">Select</option>
				<option value="P1">P1</option>
				<option value="P2">P2</option>
				<option value="P3">P3</option>
				<option value="P4">P4</option>
				<option value="P5">P5</option>
				<option value="P6">P6</option>
				<option value="P7">P7</option>
				<option value="P8">P8</option>
				<option value="P9">P9</option>
				<option value="P10">P10</option>
			</select></td>
			<td width="9%"><label>/min</label></td>
			<td width="9%"><input type="text" value="" name="<%=FHR%>" id=""
				onblur="fillClinical();" validate="Fhr,int,no"
				onchange="checkFhrValidation(this.value,'');" tabindex=1
				maxlength="3" size="5" /></td>
			<td width="16%"><input type="text" value=""
				name="<%=TEMPERATURE_REMARKS %>" size="30" id="remarks"
				validate="Remarks,remarks,no" MAXLENGTH="30" /></td>
		</tr>
	</tbody>
</table>
</div>

--><!-- Intake Details  section  starts-->

<div class="Clear"></div>
<h4>Intake Details</h4>
<%
	int i=1;
%>
<div class="Clear"></div>
<div class="cmntable">
<table width="99%" colspan="7" id="intakeOutput1" cellpadding="0"	cellspacing="0">
	<thead>
		<tr>
		
			<th>Date</th>
			<th>Time</th>
			<th>Oral/RT</th>
			<th>Type</th>
			<th colspan="2">Qty</th>
			<th>IV</th>
			<th colspan="2">Qty</th>
			<th colspan="2">Total</th>
			<th>Remarks</th>
			<th>Add</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
	<%
		if(intakeList.size() > 0){
		for(IpdIntake ipdIntake : intakeList){
	%>
	<tr>
			<td width="3%" style="display: none;"><input type="hidden" name="checkbox" value="" class="radioCheck" disabled="disabled"/></td>
			<td width="7%"><input type="hidden" name="srNO" /> 
			<input	type="text" size="10" readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(ipdIntake.getIpdIntakeDate())%>" name="<%=INTAKE_DATE%>" /></td>
			<td width="7%"><input type="text" size="8" value="<%=ipdIntake.getTime()%>" readonly="readonly"
				name="<%=INTAKE_TIME%>" /></td>
			<td>
			<input type="text" value="<%=ipdIntake.getOral()!=null?ipdIntake.getOral():"" %>" name="<%=ORAL%>"
				validate="Oral,String,no"  MAXLENGTH="20" readonly="readonly"/>
		<%--<select name="<%=ORAL%>"  id="oral<%=i %>" validate="Oral/RT,String,no" disabled="disabled">
			<option value="">Select</option>
			<option value="Oral">Oral</option>
			<option value="RT">RT</option>
			</select> --%>	
		
			</td>
			<td><input type="text" size="12" value="<%=ipdIntake.getIntakeType()!=null?ipdIntake.getIntakeType():"" %>" name="intakeType"  id="intakeType<%=i %>"	readonly="readonly" MAXLENGTH="20" /></td>
			<td><input type="text" size="3" value="<%=ipdIntake.getIntake()!=null ?ipdIntake.getIntake():""%>" name="<%=INTAKE%>" validate="Intake,int,no" id="intake<%=i %>"
				readonly="readonly" onchange="checkIntakeValidation(this.value);calculateIntakeTotal(this);calculateIntakeGrandTotal()" MAXLENGTH="5" /></td>

			<td width="19%"><label> ml</label></td>
			
			<td width="26%">
			<%--
			<select name="<%=IV_COMBO%>" class="auto" id="ivSel<%=i %>" disabled="disabled">
				<option value="0">Select</option>
				<option value="Normal">Normal Saline</option>
				<option value="DNS">DNS</option>
				<option value="Reingeri">Reingeri Lactate</option>
				<option value="Glucose">10% Glucose</option>
				<option value="Glucose1">5% Glucose</option>
				<option value="Intralipid">Intralipid</option>
				<option value="sdsd">sdsd</option>
				<option value="Inj">Inj</option>
				<option value="Saline">N/3 Glucose Saline</option>
				<option value="GlucoseSaline">N/5 Glucose Saline</option>
				<option value="GlucoseSaline1">N/2 Glucose Saline</option>
			</select> --%>
			<input type="text" name="<%=IV_COMBO%>" id="ivCombo<%=i %>" readonly="readonly">
			
			<script>
			document.getElementById('ivCombo<%=i %>').value='<%=ipdIntake.getIv()!=null && !ipdIntake.getIv().equals("0")?ipdIntake.getIv():""%>'
		//	document.getElementById('ivSel<%=i %>').value='<%=ipdIntake.getIv()!=null && !ipdIntake.getIv().equals("0")?ipdIntake.getIv():""%>'
			</script>
			</td>
			<td><input type="text" value="<%=ipdIntake.getIvCount()!=null?ipdIntake.getIvCount():"" %>" name="<%=IV%>"
				readonly="readonly" validate="IV,int,no" id="iv<%=i %>" size="3"
				onchange="checkIvValidation(this.value);calculateIntakeTotal(this);calculateIntakeGrandTotal()" MAXLENGTH="20" /></td>
			<td width="19%"><label> ml</label></td>
			<td><input type="text" value="<%=ipdIntake.getIntakeTotal()!=null?ipdIntake.getIntakeTotal():"" %>" name="intakeTotal" id="intakeTotal<%=i %>" size="5" readonly="readonly" /></td>
			
			<td width="19%"><label> ml</label></td>
			<td width="18%"><input type="text" size="20" value="<%=ipdIntake.getRemarks()!=null?ipdIntake.getRemarks():"" %>"
				name="<%=INTAKE_REMARKS%>" id="remarks" MAXLENGTH="50" readonly="readonly" 
				 />
				 	<input type="hidden" name="ipdIntakeId" value="<%=ipdIntake.getId() %>">
				 </td>
				 <td><input type="button" class="buttonAdd"	value=" " onclick="addIntakeRow();" align="right" /></td>
				 <td><input	type="button" class="buttonDel" value=" "	onclick="removeRow(this,'intakeOutput1');" align="right" disabled="disabled"/></td>
			</tr>
	
	<%
		i++;}
	}else{ %>
		<tr>
			<td width="3%"  style="display: none;"><input type="hidden" name="checkbox" value="" class="radioCheck" /></td>
			<td width="7%"><input type="hidden" name="srNO" /> <input 
				type="text" size="10" value="<%=date%>" name="<%=INTAKE_DATE%>" /></td>
			<td width="7%"><input type="text" size="8" value="<%=time%>"
				name="<%=INTAKE_TIME%>" onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);"
				 /></td><!--

			<td><input type="text" value="" name="<%=ORAL%>"
				validate="Oral,String,no" id="oral" MAXLENGTH="20" /></td>
			-->
			<td>
			<select name="<%=ORAL%>" validate="Oral/RT,String,no">
			<option value="">Select</option>
			<option value="Oral">Oral</option>
			<option value="RT">RT</option>
			</select>
			</td>
			<td><input type="text" size="12" value="" name="intakeType"  id="intakeType<%=i %>"	 MAXLENGTH="20" /></td>
			<td><input type="text" size="3" value="" name="<%=INTAKE%>" validate="Intake,int,no" id="intake<%=i %>"
				onchange="checkIntakeValidation(this.value);calculateIntakeTotal(this);calculateIntakeGrandTotal()" MAXLENGTH="5" /></td>
			
			<td width="19%"><label>ml</label></td>
			
			<td width="26%"><select name="<%=IV_COMBO%>" class="auto">
				<option value="0">Select</option>
				<option value="Normal">Normal Saline</option>
				<option value="DNS">DNS</option>
				<option value="Reingeri">Reingeri Lactate</option>
				<option value="Glucose">10% Glucose</option>
				<option value="Glucose1">5% Glucose</option>
				<option value="Intralipid">Intralipid</option>
				<option value="sdsd">sdsd</option>
				<option value="Inj">Inj</option>
				<option value="Saline">N/3 Glucose Saline</option>
				<option value="GlucoseSaline">N/5 Glucose Saline</option>
				<option value="GlucoseSaline1">N/2 Glucose Saline</option>
			</select></td>
			<td><input type="text" value="" name="<%=IV%>"
				validate="IV,int,no" id="iv<%=i %>" size="3"
				onchange="checkIvValidation(this.value);calculateIntakeTotal(this);calculateIntakeGrandTotal()" MAXLENGTH="20" /></td>
				<td width="19%"><label> ml</label></td>
			<td><input type="text" value="" name="intakeTotal" id="intakeTotal<%=i %>" size="5" readonly="readonly" /></td>
			
			<td width="19%"><label> ml</label></td>
			<td width="18%"><input type="text" size="20" value=""
				name="<%=INTAKE_REMARKS%>" id="remarks" MAXLENGTH="50"
				 />
				 	<input type="hidden" name="ipdIntakeId" value="">
				 </td>
				 <td><input type="button" class="buttonAdd"	value=" " onclick="addIntakeRow();" align="right" /></td>
				 <td><input	type="button" class="buttonDel" value=" "	onclick="removeRow(this,'intakeOutput1');" align="right" /></td>
			</tr>
			<%} %>
			
	</tbody>
</table>
</div>
<div class="">
<table cellpadding="0" cellspacing="0">
<tr>

						<td colspan="11">
						<input type="text" size="58" readonly="readonly" value="Total Qty:" class="transparent">
						<input type="text" id="inputGrandTotal1" value="" class="disable" readonly="readonly" size="3"/>
			
<input type="text" size="24" readonly="readonly" value="" class="transparent">
		<input type="text" id="inputGrandTotal2" value="" class="disable" readonly="readonly" size="3"/>
				<input type="text" size="2" readonly="readonly" value="" class="transparent">
			<input type="text" id="inputGrandTotal3" value="" class="disable" readonly="readonly" size="5"/>
				</td>
</tr>

</table>

</div>

<!-- Intake Details  section  ends--> <!-- Output Details  section  starts-->
<div class="Clear"></div>

<h4>Output Details</h4>

<div class="Clear"></div>
<div class="cmntable">

<table width="100%" colspan="7" id="intakeOutput2" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			
			<th>Date</th>
			<th>Time</th>
			<th>Urine</th>
			<th>Stool</th>
			<th>Vom</th>
			<th>As</th>
			<!--<th width="14%">Output</th>
			-->
			<th>Total</th>
			<th>Remarks</th>
			<th>Add</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
	<%
	int j=1;
		if(outputList.size() > 0){
		for(IpdOutput ipdOutput : outputList){
	%>
		<tr>
			<td width="2%"  style="display: none;"><input type="hidden" name="checkbox" value="" class="radioCheck" disabled="disabled"/></td>
			<td width="3%"><input type="hidden" name="srNO" /> 
			<input	type="text" size="10" value="<%=HMSUtil.convertDateToStringWithoutTime(ipdOutput.getIpdOutputDate())%>" name="<%=OUTPUT_DATE%>"
				validate="Date Of OutputDetails,date,no" readonly="readonly"/></td>
			<td width="3%"><input type="text" size="8" value="<%=ipdOutput.getTime()!=null?ipdOutput.getTime():""%>"
				name="<%=OUTPUT_TIME%>"  readonly="readonly" maxlength="5" id="outputTime<%=j %>"
				onKeyUp="mask(this.value,this,'2',':');" onBlur="if(this.value!=''){IsValidTime(this.value,this.id);}" /></td>
			<!--
			<td width="16%"><label>/ml</label></td>
			<td><input id="urineCheckId" name="urineCheck" value=""
				onClick="check(this);" type="checkbox"></td>
			--><td width="16%"><input value="<%=ipdOutput.getUrine()!=null?ipdOutput.getUrine():"" %>" name="urine" id="urine" 
				validate="Urine,int,no" readonly="readonly" onchange="checkStoolValidation(this);calculateOutputTotal(this);calculateIntakeGrandTotal()"
				maxlength="20" type="text" size="8" /></td><!--
			<td width="14%"><input name="stoolCheck" value=""
				type="checkbox"></td>
			--><td width="14%"><input value="<%= ipdOutput.getStool()!=null?ipdOutput.getStool():"" %>" name="stool" id="stool" 
				validate="Stool,int,no" size="8" readonly="readonly" onChange="checkStoolValidation(this);calculateOutputTotal(this);calculateIntakeGrandTotal()"
				maxlength="20" type="text"></td><!--

			<td width="16%"><label>/ml</label></td>
			<td><input name="vomCheck" value="" type="checkbox"></td>
			--><td width="16%"><input value="<%=ipdOutput.getVom()!=null?ipdOutput.getVom() :"" %>" name="vom" id="vom" size="8"
				validate="Vom,int,no" onChange="checkVomValidation(this);calculateOutputTotal(this);calculateIntakeGrandTotal()" readonly="readonly"
				maxlength="20" type="text"></td><!--

			<td width="16%"><label>/ml</label></td>
			<td><input name="aspCheck" value="" type="checkbox"></td>
			--><td width="16%"><input size="8" value="<%=ipdOutput.getAsp()!=null?ipdOutput.getAsp():"" %>" name="asp" id="asp"
				validate="Asp,int,no" onChange="checkAspValidation(this);calculateOutputTotal(this);calculateIntakeGrandTotal()" readonly="readonly"
				type="text"></td>
			<td width="14%"><input type="text" size="10" value="<%=ipdOutput.getOutput()!=null?ipdOutput.getOutput():"" %>" 
				name="<%=OUTPUT%>" id="output" maxlength="20" readonly="readonly"/></td>
			<td width="12%"><input type="text" size="40" value="<%=ipdOutput.getRemarks()!=null?ipdOutput.getRemarks():"" %>"
				name="<%=OUTPUT_REMARKS%>" id="outputRemarks" readonly="readonly"
				validate="Remarks,remarks,no" MAXLENGTH="20" />
				<input type="hidden" name="ipdOutputId" value="<%=ipdOutput.getId() %>">	
			</td>
		<td><input type="button" class="buttonAdd"	value=" " onclick="generateRow('intakeOutput2');" align="right" /></td>
<td><input	type="button" class="buttonDel" value=" "	onclick="removeRow(this,'intakeOutput2');" align="right" disabled="disabled"/></td>
</tr>
<%j++;}
		}else{%>

<tr>
			<td width="2%"  style="display: none;"><input type="hidden" name="checkbox" value="" class="radioCheck" /></td>
			<td width="3%"><input type="hidden" name="srNO" /> <input
				type="text" size="10" value="<%=date%>" name="<%=OUTPUT_DATE%>"
				validate="Date Of OutputDetails,date,no" /></td>
			<td width="3%"><input type="text" size="8" value="<%=time%>" id="outputTime<%=j %>"
				name="<%=OUTPUT_TIME%>"
				onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTime(this.value,this.id);" /></td>
			<!--
			<td width="16%"><label>/ml</label></td>
			<td><input id="urineCheckId" name="urineCheck" value=""
				onClick="check(this);" type="checkbox"></td>
			--><td width="16%"><input value="" name="urine" id="urine"
				validate="Urine,int,no" onchange="checkUrineValidation(this);calculateOutputTotal(this);calculateIntakeGrandTotal()"
				maxlength="20" type="text" size="8" /></td><!--
			<td width="14%"><input name="stoolCheck" value=""
				type="checkbox"></td>
			--><td width="14%"><input value="" name="stool" id="stool" size="8"
				validate="Stool,int,no" onChange="checkStoolValidation(this);calculateOutputTotal(this);calculateIntakeGrandTotal()"
				maxlength="20" type="text"></td><!--

			<td width="16%"><label>/ml</label></td>
			<td><input name="vomCheck" value="" type="checkbox"></td>
			--><td width="16%"><input value="" name="vom" id="vom" size="8"
				validate="Vom,int,no" onChange="checkVomValidation(this);calculateOutputTotal(this);calculateIntakeGrandTotal()"
				maxlength="20" type="text"></td><!--

			<td width="16%"><label>/ml</label></td>
			<td><input name="aspCheck" value="" type="checkbox"></td>
			--><td width="16%"><input size="8" value="" name="asp" id="asp"
				validate="Asp,int,no" onChange="checkAspValidation(this);calculateOutputTotal(this);calculateIntakeGrandTotal()"
				type="text"></td>
			<td width="14%"><input type="text" size="10" value="" 
				name="<%=OUTPUT%>" id="output" maxlength="20" readonly="readonly"/></td>
			<td width="12%"><input type="text" size="40" value=""
				name="<%=OUTPUT_REMARKS%>" id="outputRemarks"
				validate="Remarks,remarks,no" MAXLENGTH="20" />
			<input type="hidden" name="ipdOutputId" value="">		
			</td>
		<td><input type="button" class="buttonAdd"	value=" " onclick="generateRow('intakeOutput2');" align="right" /></td>
<td><input	type="button" class="buttonDel" value=" "	onclick="removeRow(this,'intakeOutput2');" align="right" /></td>
</tr>

<%} %>
</table>
</div>
<div class="">
<table cellpadding="0" cellspacing="0">
<tr>

						<td colspan="11">
						<input type="text" size="24" readonly="readonly" value="Total Qty:" class="transparent">
						<input type="text" id="urineTotal" value="" class="disable" readonly="readonly" size="8"/>
			<input type="text" size="1" readonly="readonly" value="" class="transparent17">
<input type="text" name="stoolTotal" id="stoolTotal" size="8" readonly="readonly" class="disable" value="" >
<input type="text" size="1" readonly="readonly" value="" class="transparent17">
		<input type="text" id="vomTotal" value="" class="disable" readonly="readonly" size="8"/>
		<input type="text" size="1" readonly="readonly" value="" class="transparent17">
	<input type="text" name="aspTotal" id="aspTotal" size="8" class="disable" readonly="readonly" value="">
	<input type="text" size="1" readonly="readonly" value="" class="transparent17">
	<input type="text" id="outputTotal" value="" class="disable" readonly="readonly" size="9"/>
				</td>
</tr>

</table>

</div>

<div class="Clear"></div>
<div class="paddingTop5"></div>
<div class="Clear"></div>

<table border="0" cellpadding="0" cellspacing="0" id="grid" class="center">
	<tr>
	<th>&nbsp;</th>
	<th>Last (Before 24 Hrs)</th>
	<th>Today </th>
	</tr>
	<tr>
	<th>Total Intake</th>
	<td><input type="text" name="" id="lastIntake" disabled="disabled"/></td>
	<td><input type="text" name="" id="todayIntake" disabled="disabled"/></td>
	</tr>
	<tr>
	<th>Total Output</th>
	<td><input type="text" name="" id="lastOutput" disabled="disabled"/></td>
	<td><input type="text" name="" id="todayOutput" disabled="disabled"/></td>
	</tr>
</table>
<!-- Commented By Ritu -->
<!--

<input type="button" class="buttonAdd" value=" "	onclick="generateRow('intakeOutput3');" align="right" />
<input	type="button" class="buttonDel" value=" "	onclick="removeRow(this,'intakeOutput3');" align="right" />

<div class="cmntable">

<table width="100%" colspan="7" id="intakeOutput3" cellpadding="0"	cellspacing="0">
	<thead>
		<tr>
			<th width="2%">&nbsp;</th>
			<th width="3%">Time</th>
			<th colspan="2">Drain</th>
			<th width="3%">Time</th>
			<th colspan="2">Girth</th>
			<th width="3%">Time</th>
			<th colspan="2">Blood Sugar</th>
			<th width="3%">Time</th>
			<th colspan="2">Insulin</th>
			<th width="17%">Remarks</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td width="2%"><input type="checkbox" name="checkbox" value="" /></td>
			<td width="3%"><input type="hidden" name="srNO" /> <input
				type="text" size="8" value="<%=time%>" name="<%=DRAIN_TIME%>"
				id="timeId"onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);"/></td>
			<td width="15%"><input type="text" value="" name="<%=DRAIN%>"
				id="drain" validate="Drain,int,no"
				onchange="checkDrainValidation(this.value);" MAXLENGTH="20"
				size="10" /></td>
			<td width="15%"><label> /ml</label></td>

			<td width="3%"><input type="text" size="8" value="<%=time%>"
				name="<%=GIRTH_TIME%>" id="timeId"
				onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);" /></td>
			<td width="15%"><input type="text" value="" name="<%=GIRTH%>"
				id="girth" validate="Girth,int,no"
				onchange="checkGirthValidation(this.value);" MAXLENGTH="20" size="8" /></td>
			<td width="15%"><label> /cm</label></td>
			<td width="3%"><input type="text" size="8" value="<%=time%>"
				name="<%=BLOOD_SUGAR_TIME%>"
				onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);"/></td>
			<td width="15%"><input type="text" value=""
				name="<%=BLOOD_SUGAR%>" id="bloodsugar" validate="BloodSugar,int,no"
				onchange="checkBloodValidation(this.value);" MAXLENGTH="20" size="8" /></td>
			<td width="15%"><label> /mg%</label></td>
			<td width="3%"><input type="text" size="8" value="<%=time%>"
				name="<%=INSULIN_TIME%>"
				onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);" /></td>
			<td width="15%"><input type="text" value="" name="<%=INSULIN%>"
				id="insulin" validate="Insulin,int,no"
				onchange="checkInsulinValidation(this.value);" MAXLENGTH="20"
				size="10" /></td>
			<td width="15%"><label> /I.V.</label></td>

			<td width="17%"><input type="text" value="" size="30"
				name="<%=DRAIN_REMARKS%>" id="remarks" validate="Remarks,remarks,no"
				MAXLENGTH="20" /></td>
	</tbody>
</table>

</div>
-->
<div class="Clear"></div>


<!-- Output Details  section   ends-->
<div class="Clear"></div>
<!-- Commented By Ritu -->
<!--<div class="Block">
<label class="auto">Treatment</label>
<textarea	name="<%=TREATMENT%>" id="treatment" cols="20" rows="2"	validate="Address,string,no" class="large"></textarea>
<div class="Clear"></div>
</div>
-->
<div class="Clear"></div>
<div class="division"></div>
<input type="button" class="button" name="Submit11" value="Submit" 	onClick="if(test('intakeOutput2')){submitForm('intakeOutput','ipd?method=submitIntakeOutput','validateRow');}" />
<input type="button" class="button" value="Back" onClick="submitForm('intakeOutput','ipd?method=showPatientListJsp');" />
<input type="reset" name="reset" value="Reset"/>
<!--<input type="button" class="button" value="View" align="left"
	onClick="submitForm('intakeOutput','ipd?method=showViewIntakeOutputJsp');" />
<input type="button" class="button" value="Print" align="left"
	onClick="submitForm('intakeOutput','ipd?method=showIntakeOutputChartReportJsp&<%=ADMISSION_NUMBER %>=<%=adNo%>&<%=FROM_DATE %>=<%=currenDate%>&<%=TO_DATE %>=<%=currenDate %>');" />
--><div class="Clear"></div>
<div class="division"></div>
</form>

<div class="Clear"></div>
<div class="paddingTop15"></div>
<div class="Clear"></div>
<div class="paddingTop15"></div>
<div class="Clear"></div>

<script type="text/javascript">
<!--
	function test(idName)
	{
			var u=document.getElementsByName("urineCheck");
			var u1=document.getElementsByName("urine");
			var s=document.getElementsByName("stoolCheck");
			var s1=document.getElementsByName("stool");
			var v=document.getElementsByName("vomCheck");
			var v1=document.getElementsByName("vom");
			var a=document.getElementsByName("aspCheck");
			var a1=document.getElementsByName("asp");
						
			for(var i=0;i<u.length;i++)
			{
				if (u[i].checked == true && u1[i].value.length == 0 || u[i].checked == false && u1[i].value.length > 0)
				{
				alert('Please Check Output Details!... Input Incomplete!....');
				return false;
				}
				
				if (s[i].checked == true && s1[i].value.length == 0 || s[i].checked == false && s1[i].value.length > 0)
				{
				alert('Please Check Output Details!... Input Incomplete!....');
				return false;
				}
				
				if (v[i].checked == true && v1[i].value.length == 0 || v[i].checked == false && v1[i].value.length > 0) 
				{
				alert('Please Check Output Details!... Input Incomplete!....');
				return false;
				}
				
				if (a[i].checked == true && a1[i].value.length == 0 || a[i].checked == false && a1[i].value.length > 0)
				{
				alert('Please Check Output Details!... Input Incomplete!....');
				return false;
				}
			}
			return true;
	}

function validateRow(){
	var flag = false;
	for(var i = 0; i < document.getElementsByName('temperatureDate').length; i++){
		  if(document.getElementsByName('temperature')[i].value != '0')
          {
			flag = true;
		  }
		  if(document.getElementsByName('pulse')[i].value != '')
          {
			flag = true;
		  }	
		  if(document.getElementsByName('respiration')[i].value != '')
          {
			flag = true;
		  }	
		  if(document.getElementsByName('bp')[i].value != '')
          {
			flag = true;
		  }	
		  if(document.getElementsByName('bowel')[i].value != '')
          {
			flag = true;
		  }	
		  if(document.getElementsByName('pain')[i].value != '0')
          {
			flag = true;
		  }	
		  if(document.getElementsByName('fhr')[i].value != '')
          {
			flag = true;
		  }	
		  if(document.getElementsByName('temperatureRemarks')[i].value != '')
          {
			flag = true;
		  }			
	}

	 for(var i = 0; i < document.getElementsByName('intakeDate').length; i++){
		  if(document.getElementsByName('oral')[i].value != '')
          {
			flag = true;
		  }
		  if(document.getElementsByName('intake')[i].value != '')
          {
			flag = true;
		  }	
		  if(document.getElementsByName('ivCombo')[i].value != '0')
          {
			flag = true;
		  }	
		  if(document.getElementsByName('iv')[i].value != '')
          {
			flag = true;
		  }	
	      if(document.getElementsByName('intakeRemarks')[i].value != '')
          {
			flag = true;
		  }	
		
	}

	 for(var i = 0; i < document.getElementsByName('outputDate').length; i++){
		  if(document.getElementsByName('output')[i].value != '')
         {
			flag = true;
		  }
		  if(document.getElementsByName('urine')[i].value != '')
         {
			flag = true;
		  }	
		  if(document.getElementsByName('stool')[i].value != '')
         {
			flag = true;
		  }	
		  if(document.getElementsByName('vom')[i].value != '')
         {
			flag = true;
		  }	
	      if(document.getElementsByName('asp')[i].value != '')
         {
			flag = true;
		  }	
		  if(document.getElementsByName('outputRemarks')[i].value != '')
	         {
				flag = true;
			  }	
	}
	 for(var i = 0; i < document.getElementsByName('drainTime').length; i++){
		  if(document.getElementsByName('drain')[i].value != '')
        {
			flag = true;
		  }
		  if(document.getElementsByName('girth')[i].value != '')
        {
			flag = true;
		  }	
		  if(document.getElementsByName('bloodSugar')[i].value != '')
        {
			flag = true;
		  }	
		  if(document.getElementsByName('insulin')[i].value != '')
        {
			flag = true;
		  }	
	      if(document.getElementsByName('drainRemarks')[i].value != '')
        {
			flag = true;
		  }	
		  
	}
	if(flag==false){
		alert("Please enter value in atleast one row.");
		return false;
		
	}
	return true;
}
function generateRow(idName) {
	
	var d=document.getElementById(idName).getElementsByTagName("tr");
	lastTr = d[d.length-1]
	clone = lastTr.cloneNode(true);
	clone.id = parseInt(lastTr.id);
	lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
	var tblCtrl = d[d.length-1].getElementsByTagName("input"); 
	tblCtrl[1].value=d.length-1;
	for(var i=0;i<tblCtrl.length;i++){
		tblCtrl[i].value="";
		if(i==2){
			tblCtrl[i].value = '<%=date%>';
		}
		if(i==3){
			tblCtrl[i].value = '<%=time%>';
		}
		if(tblCtrl[i].type=='button' || tblCtrl[i].type=='checkbox'){
			tblCtrl[i].disabled=false;
		}else{
			tblCtrl[i].readOnly=false;
			
		}
		if(tblCtrl[i].id.substring(0,(tblCtrl[i].id).length-1)=='ivCombo' || tblCtrl[i].id.substring(0,(tblCtrl[i].id).length-1)=='oral' || tblCtrl[i].id.substring(0,(tblCtrl[i].id).length-1)=='outputTime'){
			tblCtrl[i].id = tblCtrl[i].id.substring(0,(tblCtrl[i].id).length-1)+(parseInt(tblCtrl[i].id.substring((tblCtrl[i].id).length-1))+1);
		}
	}
	var tblCtrlSel = d[d.length-1].getElementsByTagName("select"); 
	for(var i=0;i<tblCtrlSel.length;i++){
		tblCtrlSel[i].value="0";
		tblCtrlSel[i].disabled=false;
	}
}
function calculateIntakeTotal(obj){
	var par=obj.parentNode;
	while(par.nodeName.toLowerCase()!='tr'){
	par=par.parentNode;
	}
	var inc= par.rowIndex;
	var intake = document.getElementsByName('intake')[inc-1].value;
	var iv = document.getElementsByName('iv')[inc-1].value;
	var total =0;
	if( intake != ''){
		total = parseInt(total)+parseInt(intake)
	}
	if( iv != ''){
		total = parseInt(total)+parseInt(iv)
	}
	document.getElementsByName('intakeTotal')[inc-1].value = total;
}
function calculateOutputTotal(obj){
	var par=obj.parentNode;
	while(par.nodeName.toLowerCase()!='tr'){
	par=par.parentNode;
	}
	var inc= par.rowIndex;
	var urine = document.getElementsByName('urine')[inc-1].value;
	var stool = document.getElementsByName('stool')[inc-1].value;
	var vom = document.getElementsByName('vom')[inc-1].value;
	var asp = document.getElementsByName('asp')[inc-1].value;
	var output = 0;
	if(document.getElementsByName('output')[inc-1].value!=''){
		document.getElementsByName('output')[inc-1].value =document.getElementsByName('output')[inc-1].value;
	}
	
	if( urine != ''){
		output = parseInt(output)+parseInt(urine);
	}
	if( stool != ''){
		output = parseInt(output)+parseInt(stool);
	}
	if( vom != ''){
		output = parseInt(output)+parseInt(vom);
	}
	if( asp != ''){
		output = parseInt(output)+parseInt(asp);
	}
	document.getElementsByName('output')[inc-1].value = output;
}
function removeRow(obj,idName)
{
  var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
  }
  calculateIntakeGrandTotal()
}


function addIntakeRow(){

	
	  var tbl = document.getElementById('intakeOutput1');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  
	  var cell0 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '10';
	  e1.tabIndex="1";
	  e1.name='intakeDate';
	  e1.value='<%=date%>'
	  cell0.appendChild(e1);
	  
	  var cell1 = row.insertCell(1);
	  var e21 = document.createElement('input');
	  e21.type = 'text';
	  e21.name='intakeTime';
	  e21.id='intakeTime';
	  e21.maxLength='5';
	  e21.onkeyup=function(event){mask(this.value,this,'2',':')};
	  e21.onblur=function(){IsValidTime(this.value,this.id)}
	  e21.size = '8';
	  e21.value='<%=time%>'
	  e21.setAttribute('tabindex','1');
	  cell1.appendChild(e21);


	  var cell2 = row.insertCell(2);
	  var e3 = document.createElement('select');
	  e3.name='oral';
	  e3.options[0] = new Option('Select', '');
	  e3.options[1] = new Option('Oral', 'Oral');
	  e3.options[2] = new Option('RT', 'RT');
	  e3.setAttribute('tabindex','1');
	  cell2.appendChild(e3);
	
	  
	  var cell3 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='intakeType';
	  e4.id='intakeType'+iteration
	  e4.tabIndex="1";
	  e4.size='12';
	  e4.setAttribute('maxlength', 5); 
	  cell3.appendChild(e4);

	  var cell4 = row.insertCell(4);
	  var e5 = document.createElement('input');
	  e5.type='text'
	  e5.name='intake';
	  e5.id='intake'+iteration;
	  e5.size='3';
	  e5.setAttribute('tabindex','1');
	  e5.onblur=function(){checkIntakeValidation(this.value);calculateIntakeTotal(this);calculateIntakeGrandTotal()};
	  cell4.appendChild(e5);

	  var cellRight5 = row.insertCell(5);
	  cellRight5.innerHTML='ml';
	  

	  var cell6 = row.insertCell(6);
	  var e4 = document.createElement('select');
	  e4.name='ivCombo';
	  e4.id='ivCombo'+iteration
	  e4.tabIndex="1";
	  e4.options[0] = new Option('Select', '');
	  e4.options[1] = new Option('Normal Saline', 'Normal');
	  e4.options[2] = new Option('DNS', 'DNS');
	  e4.options[3] = new Option('Reingeri Lactate', 'Reingeri');
	  e4.options[4] = new Option('10% Glucose', 'Glucose');
	  e4.options[5] = new Option('5% Glucose', 'Glucose1');
	  e4.options[6] = new Option('Intralipid', 'Intralipid');
	  e4.options[7] = new Option('sdsd', 'sdsd');
	  e4.options[8] = new Option('Inj', 'Inj');
	  e4.options[9] = new Option('N/3 Glucose Saline', 'Saline');
	  e4.options[10] = new Option('N/5 Glucose Saline', 'GlucoseSaline');
	  e4.options[11] = new Option('N/2 Glucose Saline', 'GlucoseSaline1');
	  cell6.appendChild(e4);

	  var cell7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='iv';
	  e7.id='iv'+iteration;
	  e7.size='3';
	  e7.onblur=function(){checkIvValidation(this.value);calculateIntakeTotal(this);calculateIntakeGrandTotal()}
	  e7.setAttribute('tabindex','1');
	  cell7.appendChild(e7);


	  var cell8 = row.insertCell(8);
	  cell8.innerHTML='ml';
	 

	  var cell9 = row.insertCell(9);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.name='intakeTotal';
	  e8.id='intakeTotal'+iteration
	  e8.size='5';
	  e8.setAttribute('tabindex','1');
	  cell9.appendChild(e8);

	  var cellRight10 = row.insertCell(10);
	  cellRight10.innerHTML='ml';
		
	  var cell11 = row.insertCell(11);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='intakeRemarks';
	  e11.id='remarks'+iteration
	  e11.size='20';
	  e11.setAttribute('tabindex','1');
	  cell11.appendChild(e11);
	  var e111 = document.createElement('input');
	  e111.type = 'hidden';
	  e111.name='ipdIntakeId';
	  cell11.appendChild(e111);
	  
	  
	  var cellRight11 = row.insertCell(12);
	  var e10 = document.createElement('input');
	  e10.type = 'button';
	  e10.className = 'buttonAdd';
	  e10.name='buttomAdd'+iteration;
	  e10.setAttribute('onClick', 'addIntakeRow();'); 
	  e10.setAttribute('tabindex','1');
	  cellRight11.appendChild(e10);

	  var cellRight12 = row.insertCell(13);
	  var e12= document.createElement('input');
	  e12.type = 'button';
	  e12.className = 'buttonDel';
	  e12.name='remarks'+iteration;
	  e12.setAttribute('onClick', 'removeRow(this,"intakeOutput1");'); 
	  cellRight12.appendChild(e12);
	
}

function calculateIntakeGrandTotal(){
	  var tbl = document.getElementById('intakeOutput1');
	  var cnt = tbl.rows.length;
	
	 var intakeQtyTotal = 0;
	 var ivTotal = 0;
	 var intakeTotal = 0;
	 var lastIntake =0;
	 var todayIntake =0;
	 var currentDate= new Date()
	 var cyear=currentDate.getFullYear()
	 var cmonth=currentDate.getMonth()+1
	 var cday=currentDate.getDate()
	 var cdate =  new Date(cmonth+"/"+cday+"/"+cyear);
		
	 var curDate= new Date()
	 curDate.setDate(curDate.getDate()-1)
	 var theyear=curDate.getFullYear()
	 var themonth=curDate.getMonth()+1
	 var theyesterday=curDate.getDate()

	var previousDate = new Date(themonth+"/"+theyesterday+"/"+theyear);
	
	 for(var i=0;i<cnt-1;i++){
		 if(document.getElementsByName('intake')[i]){
			 if(document.getElementsByName('intake')[i].value!='')
			 	intakeQtyTotal = parseInt(intakeQtyTotal)+parseInt(document.getElementsByName('intake')[i].value);
			 if(document.getElementsByName('iv')[i].value!='')
			 	ivTotal = parseInt(ivTotal)+parseInt(document.getElementsByName('iv')[i].value);
			 if(document.getElementsByName('intakeTotal')[i].value!='')
				 intakeTotal = parseInt(intakeTotal)+parseInt(document.getElementsByName('intakeTotal')[i].value);
	
			 var intakeDateStr = document.getElementsByName('intakeDate')[i].value
			 intakeDate = new Date(intakeDateStr.substring(6),(intakeDateStr.substring(3,5) - 1) ,intakeDateStr.substring(0,2));
		
			 if(previousDate.getTime() == intakeDate.getTime() && document.getElementsByName('intakeTotal')[i].value!=''){
				 lastIntake = parseInt(lastIntake)+parseInt(document.getElementsByName('intakeTotal')[i].value)
			 }
			 if(cdate.getTime() == intakeDate.getTime()  && document.getElementsByName('intakeTotal')[i].value!=''){
				 todayIntake = parseInt(todayIntake)+parseInt(document.getElementsByName('intakeTotal')[i].value)
			 }	
		 }
	 }
	 document.getElementById('inputGrandTotal1').value= intakeQtyTotal;
	 document.getElementById('inputGrandTotal2').value= ivTotal;
	 document.getElementById('inputGrandTotal3').value= intakeTotal;
	 document.getElementById('lastIntake').value= lastIntake;
	 document.getElementById('todayIntake').value= todayIntake;
	 
	 var tbl = document.getElementById('intakeOutput2');
	  var outputcnt = tbl.rows.length;
	 var urineTotal = 0;
	 var stoolTotal = 0;
	 var vomTotal = 0;
	 var aspTotal = 0;
	 var outputTotal = 0;
	 var lastOutput =0;
	 var todayOutput =0;

	 for(var i=0;i<outputcnt-1;i++){
		 if(document.getElementsByName('urine')[i]){
			 if(document.getElementsByName('urine')[i].value!='')
				 urineTotal = parseInt(urineTotal)+parseInt(document.getElementsByName('urine')[i].value);
			 if(document.getElementsByName('stool')[i].value!='')
				 stoolTotal = parseInt(stoolTotal)+parseInt(document.getElementsByName('stool')[i].value);
			 if(document.getElementsByName('vom')[i].value!='')
				 vomTotal = parseInt(vomTotal)+parseInt(document.getElementsByName('vom')[i].value);
			 if(document.getElementsByName('asp')[i].value!='')
				 aspTotal = parseInt(aspTotal)+parseInt(document.getElementsByName('asp')[i].value);
			 if(document.getElementsByName('output')[i].value!='')
				 outputTotal = parseInt(outputTotal)+parseInt(document.getElementsByName('output')[i].value);
	
			 var outputDateStr = document.getElementsByName('outputDate')[i].value
			 outputDate = new Date(outputDateStr.substring(6),(outputDateStr.substring(3,5) - 1) ,outputDateStr.substring(0,2));
		
			 if(previousDate.getTime() == outputDate.getTime()  && document.getElementsByName('output')[i].value!=''){
				 lastOutput = parseInt(lastOutput)+parseInt(document.getElementsByName('output')[i].value)
			 }
			 
			 if(cdate.getTime() == outputDate.getTime()  && document.getElementsByName('output')[i].value!=''){
				 todayOutput = parseInt(todayOutput)+parseInt(document.getElementsByName('output')[i].value)
			 }	
		 }
	 }
	
	 document.getElementById('urineTotal').value= urineTotal;
	 document.getElementById('stoolTotal').value= stoolTotal;
	 document.getElementById('vomTotal').value= vomTotal;
	 document.getElementById('aspTotal').value= aspTotal;
	 document.getElementById('outputTotal').value= outputTotal;
	 document.getElementById('lastOutput').value= lastOutput;
	 document.getElementById('todayOutput').value= todayOutput;
	 
	 
}
calculateIntakeGrandTotal();
//-->
</script>

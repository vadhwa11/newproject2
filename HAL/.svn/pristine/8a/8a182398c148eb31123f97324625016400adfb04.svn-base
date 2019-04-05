<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * modifyMmfDepartment.jsp  
 * Purpose of the JSP -  This is for modify MMF Department.
 * @author  Dipali
 * Create Date: 7th April,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.IpdIntake"%>
<%@page import="jkt.hms.masters.business.IpdOutput"%>
<%@page import="jkt.hms.masters.business.IpdTemperature"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.IpdIntakeOutputChart"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->

<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage="no";
	int nrs=0;
	int pageNo=1;
	int indentId=0;
	int internalIndentId=0;
	String max="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		String deptName="";
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
	List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
	List<IpdIntakeOutputChart> ipdIntakeOutputList = new ArrayList<IpdIntakeOutputChart>();

	try{
			inPatientDetailList=(List)map.get("inPatientDetailList");
						
	}catch(Exception e){
		e.printStackTrace();
	}
	try{
		ipdIntakeOutputList=(List)map.get("ipdIntakeOutputList");
					
	}catch(Exception e){
		e.printStackTrace();
	}
	
	Set<IpdTemperature> ipdTempratureSet = new HashSet<IpdTemperature>();
	Set<IpdIntake> ipdInatkeSet = new HashSet<IpdIntake>();
	Set<IpdOutput> ipdOutputSet = new HashSet<IpdOutput>();
	Set<IpdOutput> ipdOutputSet1 = new HashSet<IpdOutput>();
	
	for(IpdIntakeOutputChart ipdIntakeOutputChart : ipdIntakeOutputList){
		ipdTempratureSet = ipdIntakeOutputChart.getIpdTemperatures();
		
		ipdInatkeSet = ipdIntakeOutputChart.getIpdIntakes();
		ipdOutputSet = ipdIntakeOutputChart.getIpdOutputs();
		ipdOutputSet1 = ipdIntakeOutputChart.getIpdOutputs();
	}
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int hospitalId = 0;
	int inpatientId = 0;
	String admissionNumber = "";
	String patientName = "";
	String serviceno = "";
	String rank = "";
	String unit = "";
	String adNo = "";
	String ward = "";
	String relation = "";
	String diagnosis = "";
	String age = "";
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
   if(inPatientDetailList != null)
   {
	   Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
	    hinId=inPatientDetail.getHin().getId();
		try
		{
			inpatient = (Inpatient) inPatientDetailList.get(0);
			patient = (Patient) inpatient.getHin();
			masRank = (MasRank) patient.getRank();
			masUnit = (MasUnit) patient.getUnit();
			masDepartment=(MasDepartment)inpatient.getDepartment();
			admissionNumber=inPatientDetail.getAdNo();
		    session.setAttribute("admissionNumber",admissionNumber);
			consultantName=inPatientDetail.getDoctor().getFirstName()+inPatientDetail.getDoctor().getMiddleName()+inPatientDetail.getDoctor().getLastName();
					try
				    {
				     serviceType = patient.getServiceType().getServiceTypeName();
				    }
				    catch(Exception e)
				    {
				     serviceType="";
				    }

					try 
					{
						patientName = inpatient.getHin().getPFirstName() + " " + inpatient.getHin().getPMiddleName() + " " 
										+ inpatient.getHin().getPLastName();
					} 
					catch (Exception e) 
					{
						patientName = "";
					}
					
					try 
					{
						admissionNumber = inpatient.getAdNo();
					} 
					catch (Exception e) 
					{
						admissionNumber = "";
					}

					try 
					{
						serviceno = inpatient.getHin().getServiceNo();
					} 
					catch (Exception e) 
					{
						serviceno = "";
					}
					
					try 
					{
						ward = masDepartment.getDepartmentName();
					} 
					catch (Exception e) 
					{
						ward = "";
					}
					
					try 
					{
						diagnosis = masDiagnosisConclusion.getDiagnosisConclusionName();
					} 
					catch (Exception e) 
					{
						diagnosis = "";
					}
					
					try 
					{
						rank = masRank.getRankName();
					} 
					catch (Exception e) 
					{
						rank = "";
					}
					try 
					{
						doa =HMSUtil.changeDateToddMMyyyy(inpatient.getDateOfAddmission());
					} 
					catch (Exception e) 
					{
						doa = "";
					}
					
					try 
					{
						unit = masUnit.getUnitName();
					} 
					catch (Exception e) 
					{
						unit = "";
					}
					
					try 
					{
						age = inpatient.getAge();
					} 
					catch (Exception e) 
					{
						age = "";
					}

					try 
					{
						sex = inpatient.getHin().getSex().getAdministrativeSexName();
					} 
					catch (Exception e) 
					{
						sex = "";
					}

					try 
					{
						adNo = inpatient.getAdNo().toString();
					} 
					catch (Exception e) 
					{
						adNo = "";
					}
					try 
					{
						consultantName = inPatientDetail.getDoctor().getFirstName()+inPatientDetail.getDoctor().getMiddleName()+inPatientDetail.getDoctor().getLastName();
					} 
					catch (Exception e) 
					{
						consultantName = "";
					}
					
		}
		catch(Exception e)
		{
			System.out.println("Exception Raised in dischargeDetailsInput.jsp" + e);
		}

%>

<div id="contentHolder">
<h6>Intake/Output Chart</h6>
<div class="Clear"></div>
<h4><%=deptName%>Ward</h4>
<div class="Clear"></div>
<form name="intakeOutput" method="post" action="">
<div class="Clear"></div>
<div class="blockTitle">Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<input type="hidden" name="deptName" id="deptName"
	value="<%=deptName %>" />
<div class="blockFrame">
<% if (!serviceType.equalsIgnoreCase("civilian")) { %> <label>Patient
Name:</label> <label class="value"><%=patientName.length()>2?patientName:"-"%></label>

<label>Admission No.:</label> <label class="value"> <%=adNo.length()>0?adNo:"-"%></label>

<label>Service No.:</label> <label class="value"><%=serviceno.length()>0?serviceno:"-"%></label>

<div class="Clear"></div>
<label>Ward:</label> <label class="value"><%=ward.length()>0?ward:"-"%></label>

<label>Rank:</label> <label class="value"><%=rank.length()>0?rank:"-" %></label>

<label>Unit:</label> <label class="value"><%=unit.length()>0?unit:"-" %></label>
<div class="Clear"></div>


<label>DOA:</label> <label class="value"><%=doa.length()>0?doa:"-"%></label>

<label>Consultant Name</label> <label class="value"><%=consultantName.length()>0?consultantName:"-"%></label>

<label>Age:</label> <label class="valueMedium"><%=age.length()>0?age:"-"%></label>

<label class="noWidth">Sex:</label> <label class="valueNoWidth"><%=sex.length()>0?sex:"-"%></label>

<div class="Clear"></div>
<label>Diagnosis:</label> <label class="noHeightBig"><%=diagnosis.length()>0?diagnosis:"-"%></label>
<% } else {  %> <label>Patient Name:</label> <label class="value"><%=patientName.length()>2?patientName:"-"%></label>

<label>Admission No.:</label> <label class="value"> <%=adNo.length()>0?adNo:"-"%></label>

<label>Ward:</label> <label class="value"><%=ward.length()>0?ward:"-"%></label>
<div class="Clear"></div>
<label>Consultant Name</label> <label class="value"><%=consultantName.length()>0?consultantName:"-"%></label>

<label>Age:</label> <label class="valueMedium"><%=age.length()>0?age:"-"%></label>

<label>Sex:</label> <label class="value"><%=sex.length()>0?sex:"-"%></label>
<label class="noWidth">DOA:</label> <label class="valueNoWidth"><%=doa.length()>0?doa:"-"%></label>

<div class="Clear"></div>
<label>Diagnosis:</label> <label class="noHeightBig"><%=diagnosis.length()>0?diagnosis:"-"%></label>

<% } %> <%}	%>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="tableHolderAuto">

<table width="100%" colspan="7" id="intakeOutput" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="3%">Date</th>
			<th width="3%">Time</th>
			<th width="8%">Temperature</th>
			<th width="15%">Pulse</th>
			<th width="15%">Respiration</th>
			<th width="15%">BP</th>
			<th width="16%">Remarks</th>
		</tr>
	</thead>

	<tbody>
		<%
					for(IpdTemperature ipdTemperature :ipdTempratureSet){
				%>
		<tr>
			<td width="3%"><input type="text" size="8"
				value="<%=HMSUtil.changeDateToddMMyyyy(ipdTemperature.getDate()) %>"
				readonly /></td>
			<td width="3%"><input type="text" size="8"
				value="<%=ipdTemperature.getTime() %>" readonly /></td>
			<%if(ipdTemperature.getTemperature() !=null){ %>
			<td width="8%"><input type="text" size="8"
				value="<%=ipdTemperature.getTemperature() %>" readonly /></td>
			<%}else{ %>
			<td width="8%"><input type="text" size="8" value="" readonly /></td>
			<%} %>
			<%if(ipdTemperature.getPulse()!=0){ %>
			<td width="15%"><input type="text" size="8"
				value="<%=ipdTemperature.getPulse() %>" readonly /></td>
			<%}else{ %>
			<td width="8%"><input type="text" size="8" value="" readonly /></td>
			<%} %>

			<%if(ipdTemperature.getRespiration()!=0){ %>
			<td width="15%"><input type="text" size="8"
				value="<%=ipdTemperature.getRespiration() %>" readonly /></td>
			<%}else{ %>
			<td width="8%"><input type="text" size="8" value="" readonly /></td>
			<%} %>

			<td width="15%"><input type="text" size="8"
				value="<%=ipdTemperature.getBp() %>" readonly /></td>
			<td width="15%"><input type="text" size="30"
				value="<%=ipdTemperature.getRemarks() %>" readonly /></td>
		</tr>
		<%} %>
	</tbody>
</table>
</div>
<div class="Clear"></div>

<div class="blockTitle">Intake Details</div>
<div class="blockTitleCurve"></div>
<div class="tableHolderAuto">

<table width="100%" colspan="7" id="intakeOutput1" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="4%">Date</th>
			<th width="5%">Time</th>
			<th width="21%">Intake</th>
			<th width="21%">Oral</th>
			<th width="25%">IV</th>
			<th width="19%">Remarks</th>
		</tr>
	</thead>

	<tbody>
		<%
						for(IpdIntake ipdIntake :ipdInatkeSet){
				%>
		<tr>
			<td width="4%"><input type="text" size="8"
				value="<%=HMSUtil.changeDateToddMMyyyy(ipdIntake.getDate()) %>"
				readonly /></td>
			<td width="5%"><input type="text" size="8"
				value="<%=ipdIntake.getTime() %>" readonly /></td>
			<td width="21%"><input type="text" size="8"
				value="<%=ipdIntake.getIntake() %>" readonly /></td>
			<td width="21%"><input type="text" size="8"
				value="<%=ipdIntake.getOral() %>" readonly /></td>
			<td width="25%"><input type="text" size="8"
				value="<%=ipdIntake.getIv() %>" readonly /></td>
			<td width="19%"><input type="text" size=30
				" value="<%=ipdIntake.getRemarks() %>" readonly /></td>
		</tr>
		<%} %>
	</tbody>
</table>
</div>
<div class="Clear"></div>

<div class="blockTitle">Output Details</div>
<div class="blockTitleCurve"></div>
<div class="tableHolderAuto">
<table width="100%" colspan="7" id="intakeOutput2" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="%">Date</th>
			<th width="3%">Time</th>
			<th width="14%">Output</th>
			<th width="16%">Urine</th>
			<th width="14%">Stool</th>
			<th width="16%">Vom</th>
			<th width="16%">ASP</th>
			<th width="12%">Remarks</th>

		</tr>
	</thead>
	<tbody>
		<%
						for(IpdOutput ipdOutput :ipdOutputSet){
				%>
		<td width="3%"><input type="text" size="8"
			value="<%=HMSUtil.changeDateToddMMyyyy(ipdOutput.getDate()) %>"
			readonly /></td>
		<td width="3%"><input type="text" size="8"
			value="<%=ipdOutput.getTime() %>" readonly /></td>
		<td width="14%"><input type="text" size="8"
			value="<%=ipdOutput.getOutput() %>" readonly /></td>
		<td width="16%"><input type="text" size="8"
			value="<%=ipdOutput.getUrine() %>" readonly /></td>
		<td width="14%"><input type="text" size="8"
			value="<%=ipdOutput.getStool() %>" readonly /></td>
		<td width="16%"><input type="text" size="8"
			value="<%=ipdOutput.getVom() %>" readonly /></td>
		<td width="16%"><input type="text" size="8"
			value="<%=ipdOutput.getAsp() %>" readonly /></td>
		<td width="12%"><input type="text" size="30"
			value="<%=ipdOutput.getRemarks() %>" readonly /></td>
		</tr>
		<%} %>
	</tbody>
</table>
</div>
<div class="Clear"></div>

<div class="tableHolderAuto">
<table width="100%" colspan="7" id="intakeOutput3" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="3%">Time</th>
			<th width="15%">Drain</th>
			<th width="3%">Time</th>
			<th width="15%">Girth</th>
			<th width="3%">Time</th>
			<th width="15%">Insulin</th>
			<th width="3%">Time</th>
			<th width="15%">Blood Sugar</th>
			<th width="17%">Remarks</th>

		</tr>
	</thead>

	<tbody>
		<%
						for(IpdOutput ipdOutput :ipdOutputSet1){
				%>
		<td width="3%"><input type="text" size="8"
			value="<%=ipdOutput.getDrainTime() %>" readonly /></td>
		<td width="8%"><input type="text" size="8"
			value="<%=ipdOutput.getDrain() %>" readonly /></td>
		<td width="15%"><input type="text" size="8"
			value="<%=ipdOutput.getGirthTime() %>" readonly /></td>
		<td width="15%"><input type="text" size="8"
			value="<%=ipdOutput.getGirth() %>" readonly /></td>
		<td width="15%"><input type="text" size="8"
			value="<%=ipdOutput.getInsulinTime() %>" readonly /></td>
		<td width="15%"><input type="text" size="8"
			value="<%=ipdOutput.getInsulin() %>" readonly /></td>
		<td width="15%"><input type="text" size="8"
			value="<%=ipdOutput.getBloodSugarTime() %>" readonly /></td>
		<td width="15%"><input type="text" size="8"
			value="<%=ipdOutput.getBloodSugar() %>" readonly /></td>
		<td width="15%"><input type="text" size="30"
			value="<%=ipdOutput.getRemarks() %>" readonly /></td>
		</tr>
		<%} %>
	</tbody>
</table>
</div>

<div class="Clear"></div>
<div class="blockFrame"><label>Treatment:</label> <%
					for(IpdIntakeOutputChart ipdIntakeOutputChart :ipdIntakeOutputList){
				%> <input type="text" class="large2"
	value="<%=ipdIntakeOutputChart.getTreatment() %>" readonly />
<div class="Clear"></div>
</div>
<div class="Clear"></div>

<input type="button" class="button" value="Back" align="left"
	onClick="submitForm('intakeOutput','ipd?method=showPatientListJsp');" />
<%} %>
</form>
<div class="Clear"></div>
</div>
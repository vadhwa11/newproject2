<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * nursingCareEntryDetail.jsp  
 * Purpose of the JSP -  This is for Nursing Care Entry Setup.
 * @author  Vikas
 * @author  Deepali
 * Create Date: 20th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.PatientDietIndoorDetail"%>
<%@page import="jkt.hms.masters.business.Ipdcaredetail"%>
<%@page import="jkt.hms.masters.business.PreAnesthesiaConsultDoctorDt"%>


<%@page import="jkt.hms.masters.business.AllergyDetail"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>

<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script>


<script type="text/javascript">
	vBulletin_init();
</script>

<%	List<PatientDietIndoorDetail> patientDietIndoorDetailList = new ArrayList<PatientDietIndoorDetail>();
    List<PreAnesthesiaConsultDoctorDt> consultDoctorDtList= new ArrayList<PreAnesthesiaConsultDoctorDt>();
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	String deptName="";
	
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	String caretime=(String)map.get("caretime");
	
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();

	if(map.get("patientDietIndoorDetailList") != null)
	{
		patientDietIndoorDetailList=(List<PatientDietIndoorDetail>)map.get("patientDietIndoorDetailList");
	}
	
	if(map.get("consultDoctorDtList") != null)
	{
		consultDoctorDtList=(List<PreAnesthesiaConsultDoctorDt>)map.get("consultDoctorDtList");
	}
	
	if(map.get("inpatientList") != null)
	{
		inpatientList=(List<Inpatient>)map.get("inpatientList");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	 
	Patient patient = new Patient();
	Inpatient inpatient = new Inpatient();
	String patientName ="";
	String consultantName = "";
	String age = "";
	String currentAge = "";
	if(inpatientList.size() >0){
		patient = inpatientList.get(0).getHin();
		inpatient = inpatientList.get(0);
		if(patient.getPFirstName() != null)
		   {
	       patientName=patient.getPFirstName();
		   }
		if(patient.getPMiddleName() != null)
			   {
			   patientName +=patient.getPMiddleName();
			   }
		if(patient.getPLastName() != null)
			   {
			   patientName +=patient.getPLastName();
			   }
		if(inpatient.getDoctor() !=null){
			/* consultantName=inpatient.getDoctor().getRank().getRankName(); */
			if(inpatient.getDoctor().getFirstName() != null)
			{
				consultantName+=" "+inpatient.getDoctor().getFirstName();	
			}
			if(inpatient.getDoctor().getMiddleName() != null)
			{
				consultantName+= " "+inpatient.getDoctor().getMiddleName();
			}
			if(inpatient.getDoctor().getLastName() != null)
			{
				consultantName+=" "+inpatient.getDoctor().getLastName();
			}
		}
		
	    if(patient.getAge()!=null)
			age = patient.getAge();
		try{
			if(!age.equals(""))
			currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
%>
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

<%-- <label>Med Cat</label>
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
%>  --%>
<div class="Clear"></div>

</div>
<div class="Clear"></div>
<div class="division"></div>
<form name="nursingCareEntryDetail" method="post">
<div class="Clear"></div>
<%
if(consultDoctorDtList.size()>0)
{
	

String fromDoctor = "";
String fromDepartment = "";
String referralNote= "";
fromDoctor = consultDoctorDtList.get(0).getOpdPatientDetails().getEmployee().getFirstName();
if(consultDoctorDtList.get(0).getOpdPatientDetails().getEmployee().getMiddleName()!=null && !consultDoctorDtList.get(0).getOpdPatientDetails().getEmployee().getMiddleName().trim().equals(""))
{
	fromDoctor += " " + consultDoctorDtList.get(0).getOpdPatientDetails().getEmployee().getMiddleName();
}
if(consultDoctorDtList.get(0).getOpdPatientDetails().getEmployee().getLastName()!=null && !consultDoctorDtList.get(0).getOpdPatientDetails().getEmployee().getLastName().trim().equals(""))
{
	fromDoctor += " " + consultDoctorDtList.get(0).getOpdPatientDetails().getEmployee().getLastName();
}
if(consultDoctorDtList.get(0).getOpdPatientDetails().getDepartment()!=null )
{
	fromDepartment = consultDoctorDtList.get(0).getOpdPatientDetails().getDepartment().getDepartmentName();
}
if(consultDoctorDtList.get(0).getReferralNotes()!=null && !consultDoctorDtList.get(0).getReferralNotes().trim().equals(""))
{
	referralNote = consultDoctorDtList.get(0).getReferralNotes();
}
%>

<div class="Block">
<label>From Doctor</label>
<label class="value"><%=fromDoctor %></label>


<label>From Department</label>
<label class="value"><%=fromDepartment %></label>

<label>Referral Date</label>
<label class="value"><%=consultDoctorDtList.get(0).getOpdPatientDetails().getReferredDate()%></label>

<label>Referral Note</label>
<label class="value"><%=referralNote %></label>

<label>Consultaion Advice<span>*</span></label>
<textarea name="consultationBYDoc" validate="Consultation ,string,yes"
										id="patientAdvise" cols="0" rows="0" maxlength="500"
										tabindex="5" ></textarea>
</div>

<input type="hidden" name="careDate" value="<%=currentDate %>" readonly="readonly" />
<input type="hidden" name="time" value="<%=time.substring(0,time.lastIndexOf(":")) %>" readonly="readonly" /> 


<div class="Clear"></div>



<input type="hidden" name="careTime1" value="<%=time.substring(0,time.lastIndexOf(":"))  %>" readonly="readonly" />
<input type="hidden" name="careTime" value="<%=time%>" readonly="readonly" />
<input type="hidden" id="parent" name="parent" value="<%=inpatient.getId()%>"/>
<input type="hidden" id="consultDoctorDtId" name="consultDoctorDtId" value="<%=consultDoctorDtList.get(0).getId()%>"/>


<div id="edited"></div>
<div id="statusMessage" class="messagelabel"><br />
</div>



<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" class="button" value="View " align="left"
	onClick="javascript:openCaseSheetPopUp();" />
	
<input type="button" class="button" value="Submit " align="left"
	onClick="submitForm('nursingCareEntryDetail','ipd?method=submitConsultaionEntryDetails');" />
<!--<input type="button" class="button" value="Print " align="left"
	onClick="submitForm('nursingCareEntryDetail','ipd?method=showNursingCareReportJsp');" />
--><input type="button" class="button" value="Back" align="left"
	onClick="submitFormForButton('nursingCareEntryDetail','ipd?method=getReferedPatientList');" />
<input type="reset" name="reset" value="Reset" class="button" onclick="location.reload();"/>
<div class="Clear"></div>

<%} %>

<div class="clear"></div>
<div class="division"></div>	
<div class="paddingTop15"></div>
	<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>

<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>

<script>


function checkTimeFormat(){
	
	var chtime=document.getElementById("caretime").value
 	if(chtime==""){
		alert('Changed Time  can not be blank')
		return false
	}
	 if(chtime!= ""){
	 			var index=chtime.indexOf(':');
	 			//alert(index)
				if(!validateInteger(trimAll(chtime)))
				{
					alert(" Time should be a number(without spaces) without special Characters in HH:MM Format.");
					return false						
				}
				if(index == -1)
				  alert("Please Enter The Time in Correct Format.")
					
	
		 //var indx = chtime.indexOf(':');
		 
		 if (index != -1) {
		 var pairs2 = chtime.substring(0,chtime.length).split(':');
		 }
				 
		 if (pairs2.length!=2) { 
			 alert("Invalid Time Format.It should be HH:MM")
			return false;
			}
		 
		 if (pairs2[0].length != 2 || pairs2[1].length != 2 ) {
				  alert("Invalid Time Format.It should be HH:MM")
				  return false;
				}
		 
		 		 val2=eval(pairs2[0]);
		 			
						  if (val2<0 || val2>23) {
							  alert("Hours should 00-23")
					 		 return false;}
					 		 
					 		 val3=eval(pairs2[1]);
		 		
							  if (val3<0 || val3>59) {
							  alert("Min should 00-59")
					 		 return false;}
			 			
		return true;	  
	}
	}
function openCaseSheetPopUp()
{
 var inpatientId = document.getElementById("parent").value;
 var url="/hms/hms/ipd?method=showDetailsReferalRecord&parent="+inpatientId;
 newwindow=window.open(url,'name',"left=2,top=100,height=500,width=1010,status=1,scrollbars=1,resizable=0");
}

</script>





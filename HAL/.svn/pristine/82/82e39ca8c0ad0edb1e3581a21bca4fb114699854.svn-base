<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<SCRIPT>
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
		Map<String, Object> utilMap = new HashMap<String, Object>();
		String userName="";
		if(session.getAttribute("userName")!=null)
		 userName=(String)session.getAttribute("userName");

		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		//String Session=(String) utilMap.get("session");
		String time = (String) utilMap.get("currentTime");
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';

	</script>
	<%

String Labresult="NotPresent";
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<Inpatient> inpatientList = new ArrayList<Inpatient>();
if(map.get("inpatientList")!=null){
	inpatientList = (List<Inpatient>)map.get("inpatientList");
}
String hinNo="";
String andNo ="";
String initDiagnosis ="";

String currentAge = "";
Inpatient inpatient = new Inpatient();
Patient patient = new Patient();
int hinId = 0;

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
String category_name = "";
String consultantName = "";
int inpatientId =0 ;
if(inpatientList != null)
{
   
   inpatient=(Inpatient)inpatientList.get(0);
   patient = (Patient) inpatient.getHin();
    hinId=inpatient.getHin().getId();
    hinNo=inpatient.getHinNo();
    andNo=inpatient.getAdNo();
    inpatientId= inpatient.getId();
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
%>

<div class="titleBg"><h2>Specialist Opinion</h2></div>
<div class="Clear"></div>
<form name="splOpenion" method="post" action="">
<input	type="hidden" name="inpatientId" value="<%=inpatientId %>">
<input	type="hidden" name="hinNo" value="<%=hinNo%>">
<input	type="hidden" name="andNo" value="<%=andNo %>">
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
<label>Name</label> <%
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
<input type="hidden" name="ageId" id="ageId" value="<%=currentAge %>">
<input type="hidden" name="genderId" id="genderId" value="<%=patient.getSex().getId() %>">
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
		
<label>Doctor</label>
<input type="text" name="mo" value="" maxlength="100" />
<div class="Clear"></div>

</div>
<div class="Clear paddingTop15"></div>
<input	type="hidden" name="<%=AD_NO %>"	value="<%=inpatient.getAdNo() %>" /> 
<input type="hidden" name="<%=DEPARTMENT_ID %>"	value="<%=inpatient.getDepartment().getDepartmentName() %>" />

<input type="hidden" value="<%=adNo%>" name="<%=ADMISSION_NUMBER %>" />
<input	type="hidden" name="hinId" value="<%=hinId%>" />
<div class="Clear"></div>
<div class="Block">


<label>Course of Illness</label>
 <textarea rows="" cols="" class="large" name="courseOfIllness" onkeyup="chkLength(this,200);"></textarea>
<div class="clear"></div>
<label>General Exam</label>
 <textarea rows="" cols="" class="large" name="generalExam" onkeyup="chkLength(this,200);"></textarea>

</div>
 <div class="clear paddingTop15"></div>
<div class="clear"></div>
<!--  Start Of PHYSICAL CAPACITY -->

<div class="clear"></div>
<h4>Vitals</h4>
<div class="Block">
<label class="">Weight</label>
<input name="weight" tabindex="1" type="text" id="weight" value=""  onblur="calculateBMI()" class="auto" size="5" validate="weight,int,no" maxlength="3" />
<label class="unit">kg</label> 

<label  class="">Height</label> 
<input name="height" tabindex="1" type="text" id="height" value="" class="auto" onblur="calculateIdealWeight();calculateBMI();" size="5" validate="height,int,no"  maxlength="3" />
<label class="unit">cm</label>

 <label	class="">BMI</label> 
<input tabindex="1" type="text" id="bmi" name="bmi" readonly="readonly" maxlength="6" value="" onKeyUp="limitText(this,6);" class="auto" size="5" />
<label class="unit">kg/m<sup>2</sup></label> 
  <div class="clear"></div>
<label	class="">Ideal Weight</label>
 <input name="idealWeight" type="text" id="idealWeightId" tabindex="1" class="auto" size="5" value="" tabindex="1" validate="Ideal Weight,string,no" maxlength="3" />
 <label class="unit">kg</label> 
 <label class="">Temperature</label>
 <input name="temperature" id="tempId" type="text" tabindex="1" value="" class="auto" size="5" maxlength="5" />
 <label class="unit">&deg;F</label>
 <label	class="">Pulse</label>
 <input name="pulse" type="text" tabindex="1" value="" class="auto" size="5" tabindex="1" validate="pulse,int,no" maxlength="3" />
 <label class="unit">/min</label> 
   
   <div class="clear"></div>
   
 <label class="">BP</label>
 <input	name="bp" id="bp" type="text" tabindex="1" value="" class="auto" size="5" onblur="validateBpValue(this.value);" maxlength="7" />
 <label class="unit">mm/Hg</label>
 <label class="">RR</label>
 <input	name="rr" id="rr" type="text" tabindex="1" value="" class="auto" size="5" maxlength="3" />
 <label class="unit">/min</label>

<div class="clear"></div>

</div>

<div class="clear paddingTop15"></div>
<!--  End Of PHYSICAL CAPACITY -->

 <div class="clear paddingTop15"></div>
 <div class="clear"></div>
<div id="slide4">
<div class="Block">
 <!-- Code for Exaimination -->
 
 
 <label>General Physical Exam</label>
<input type="text" name="generalPhysicalExam" id="generalPhysicalExam" value="" size="100" class="auto"
   maxlength="49" validate="General Physical Exam,string,no"/>
<div class="clear"></div>
<label>Cardiovascular System</label>
<input type="text" name="cardiovascularSystem" id="cardiovascularSystem" value="" size="100" class="auto"
	maxlength="49" validate="Cardiovascular System,string,no"/>
<div class="clear"></div>

<label>Respiratory System</label>

 <input tabindex="1" type="text" value="NAD" name="respiratorySystem" class="auto" size="100" maxlength="99" validate="Respiratory System,string,no"/>


<div class="clear"></div>

	


<label>Gastro Intestinal System</label>

<input type="text" name="gastroIntestinalSystem" id="gastroIntestinalSystem" value="" size="100" class="auto"
 maxlength="99" validate="Gastro Intestinal System,string,no"/>
<div class="clear"></div>


<label>Central Nervous System </label><%-- 
<% if(medExamObj.getCentralNervousSystemMMHG()!=null){%>
  <input tabindex="1" type="text" maxlength="1"  name="<%=NERVOUS_BRAKDOWN%>" class="auto" size="100"  value="<%=medExamObj.getCentralNervousSystemMMHG()%>" validate="Central Nervous System unit,string,no"/>

 <% }else{%>
 <input tabindex="1" type="text" maxlength="1" value="Normal" name="<%=NERVOUS_BRAKDOWN%>" class="auto" size="100" validate="Central Nervous System,string,no"/>

 <% }%>--%>
 <input type="text" name="centralNervousSystem" id="centralNervousSystem" value="" size="100" class="auto"
 maxlength="99" validate="Central Nervous System,string,no"/>
<div class="clear"></div>

<%-- 
<label>Local Examination</label>
<input type="text" name="localExamination" id="localExamination" value="<%=localExamination%>" size="100" class="auto"
 maxlength="50" validate="Local Examination,string,no"/>
<div class="clear"></div>

<label>Remarks</label>
<input type="text" name="remarksClinical" id="remarksClinical" value="<%=remarksClinical%>" size="100" class="auto" maxlength="100" validate="Clinical Remarks,string,no"/>
 --%>
 
 </div>

<input type="hidden" id="investigationDataStatus" name="investigationDataStatus" value="no"/>
<div class="Clear paddingTop15"></div>
<!--  End Of Investigations -->
<div class="clear"></div>
<div class="Block">

<label>Specialist Opinion</label>
<textarea rows="" cols="" name="SpecilaistOpinion" id="SpecilaistOpinion" onkeyup="chkLength(this,100);" ></textarea>


<label>Treatment Advice</label>
<textarea rows="" cols="" name="SpecilaistTreatmentAdvice"  id="SpecilaistTreatmentAdvice" onkeyup="chkLength(this,200);" ></textarea>
</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" name="Submit11" value="Submit" 	onClick="submitForm('splOpenion','ipd?method=submitIpdSplcialistOpinion')" />
<input type="button" class="button" value="Back" onClick="submitForm('splOpenion','ipd?method=showPatientListJsp');" />
<input type="reset" name="reset" value="Reset"/>

</form>

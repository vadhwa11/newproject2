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

<%@page import="jkt.hms.masters.business.MasImpanneledHospital"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasWardImpanneledHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.PatientDietIndoorDetail"%>
<%@page import="jkt.hms.masters.business.Ipdcaredetail"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>

<%@page import="jkt.hms.masters.business.AllergyDetail"%>

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

<%	

String rankCategoryCodeForWorkmen = HMSUtil.getProperties("adt.properties", "rankCategoryCodeForWorkmen");
List<PatientDietIndoorDetail> patientDietIndoorDetailList = new ArrayList<PatientDietIndoorDetail>();
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	String deptName="";
	
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	String caretime=(String)map.get("caretime");
	
	OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
	if (map.get("opdPatientDetails") != null) {
		opdPatientDetails = (OpdPatientDetails) map.get("opdPatientDetails");
	}
	
	List<MasWardImpanneledHospital> imWardList = new ArrayList<MasWardImpanneledHospital>();
	if (map.get("imWardList") != null) {
		imWardList = (List<MasWardImpanneledHospital>) map.get("imWardList");
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
	String patientName ="";
	String consultantName = "";
	String age = "";
	String currentAge = "";
	String referredFrom = "";
	int hinId = 0;
	int opdPatientDetailsId = 0;

	if(opdPatientDetails.getVisit()!= null)
	{
		patient = opdPatientDetails.getVisit().getHin();
		referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
		
	}
	else
	{
		patient = opdPatientDetails.getInpatient().getHin();
		referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
	}
		
	hinId = patient.getId();
	opdPatientDetailsId= opdPatientDetails.getId();
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
		if(opdPatientDetails.getEmployee() !=null){
			/* consultantName=inpatient.getDoctor().getRank().getRankName(); */
			if(opdPatientDetails.getEmployee().getFirstName() != null)
			{
				consultantName+=" "+opdPatientDetails.getEmployee().getFirstName();	
			}
			if(opdPatientDetails.getEmployee().getMiddleName() != null)
			{
				consultantName+= " "+opdPatientDetails.getEmployee().getMiddleName();
			}
			if(opdPatientDetails.getEmployee().getLastName() != null)
			{
				consultantName+=" "+opdPatientDetails.getEmployee().getLastName();
			}
		}
		
	    if(patient.getAge()!=null)
			age = patient.getAge();
		try{
			if(!age.equals(""))
			currentAge = HMSUtil.calculateAge(patient.getDateOfBirth());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	
	
	
%>
<h4>Patient Details</h4>
<div class="Clear"></div>
<form name="generateReferralLetterPage" method="post">
<div class="Block">

<label>Employee No.</label> 
<label class="value"> <%=patient.getServiceNo()!=null?patient.getServiceNo():"" %></label>





<label>Patient Name</label>
<label	class="value"> <%= patientName %></label>
<input type="hidden" name="opdPatientDetailsId" id="opdPatientDetailsId" value="<%=opdPatientDetailsId%>"/>
<input type="hidden" name="hinId" id="hinId" value="<%=hinId%>"/>

<label>Relation</label> <%
	if(patient.getRelation() != null){
	%> 
<label class="value"><%= patient.getRelation().getRelationName()%></label>
<%} else{ %> <label
	class="value">-</label> 
	<% }%> 
<div class="Clear"></div>
<label>Designation</label>
<label class="value"><%=(patient.getEmployee().getRank()!=null?patient.getEmployee().getRank().getRankName():"")%></label>

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

<label>Age</label> <%if(!currentAge.equals("")){ %>
<label class="value"> <%=currentAge %></label> <%}else{ %>
<label	class="value">-</label> <%} %>
<div class="Clear"></div>
<label>Gender</label> <%if(patient.getSex() != null){ %>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>		
<div class="Clear"></div>
</div>
<h4>Referral Details</h4>
<div class="Clear"></div>
<div class="Block">




<label>Referred From </label> <%if(referredFrom != null){ %>
<label class="value"> <%=referredFrom %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<label>Empanelled Hospital </label> <%if(referredFrom != null){ %>
<label class="value"> <%=opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<label>Treatment Type </label> <%if(opdPatientDetails.getReferralTreatmentType().equals("1")){ %>
<label class="value"> OPD</label>
<%}else{ %>
<label class="value"> Admission</label>
<%} %>

<label>Referred For</label>
<input type="text" value="<%=opdPatientDetails.getReferredFor()!=null?opdPatientDetails.getReferredFor():""%>" name="referredFor" id="referredFor" maxlength="300"/>


<%
	List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
	
	if(map.get("diagnosisList")!=null){
		diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
		
		System.out.println("diagnosisList="+diagnosisList.size());
		System.out.println("opdPatientDetails="+opdPatientDetails.getVisit().getId());
		System.out.println("opdPatientDetails="+opdPatientDetails.getId());
		
	}%>


<label>Working Diagnosis</label> 

	<label class="value"><%=diagnosisList.get(0)!=null?diagnosisList.get(0).getOpdPatientDetails().getInitialDiagnosis():""%></label>	
	
<label>ICD Diagnosis</label> 
	<%
	String icdDiagnosis = "";
	for(DischargeIcdCode dic :diagnosisList)
	{
		icdDiagnosis =  icdDiagnosis + dic.getIcd().getIcdName()+",<br>";
	}
	
	%>
	<label class="value"><%=icdDiagnosis.substring(0, (icdDiagnosis.length()-5))%></label>
	
	
<div class="Clear"></div>
<label>Doctor Note</label>
<textarea class = "large" readonly="readonly"><%=(opdPatientDetails.getReferralNotes()!=null?opdPatientDetails.getReferralNotes():" ")%></textarea>

<div class="Clear"></div>
<label > Note:<span>*</span></label><input type="text" class = "large"  validate="Note,String,yes" maxlength="500" value="OPD/CONSULTATION(INCLUDING PHARMACECUTICALS FOR <%=opdPatientDetails.getReferralDays()!=null?opdPatientDetails.getReferralDays():""%> DAYS)" name ="referral_note" id ="referral_note"/>

<% 
boolean generalWFlag = false; 
if(patient.getEmployee()!=null && patient.getEmployee().getRankCategory().getRankCategoryCode().equalsIgnoreCase(rankCategoryCodeForWorkmen))
{
	generalWFlag = true;
}
if(opdPatientDetails.getReferralTreatmentType().equals("2")){%>
<label  style="margin-left: 42px;"> Ward:<span>*</span></label> 
<select name="wardId" id="wardId" validate="Ward ,String,yes">
<option value="0">Select</option>
	<%
	
	for(MasWardImpanneledHospital mweh: imWardList)
	{
		
		if(generalWFlag)
		{
			
			if(mweh.getWardName().equalsIgnoreCase("General Ward"))
			{
			%>
	<option value="<%=mweh.getId()%>" selected="selected"><%=mweh.getWardName()%></option>
	<%
			}
			else
			{
			%>
	<option value="<%=mweh.getId()%>"><%=mweh.getWardName()%></option>
	<%
			}
			
		}else{
	%>
	<option value="<%=mweh.getId()%>"><%=mweh.getWardName()%></option>
	<%
		}}
		%>
</select> 
<%}%>

<div class="Clear"></div>

		 
		 <label>Doctor Name</label>
         <label class="value"><%=consultantName %></label>
<label> This letter is valid for <span>*</span></label><input type="text" value="" class = "small" name ="validity_period" id="validity_period" validate="Validity Period,int,yes" maxlength="5"/>Days
<div class="Clear"></div>
<label> Subject:<span>*</span></label><input type="text"  class="large" value="" name ="subject" id ="subject" validate="Subject,String,yes" maxlength="250"/>

</div>


<input type="hidden" name="careDate" value="<%=currentDate %>" readonly="readonly" />
<input type="hidden" name="time" value="<%=time.substring(0,time.lastIndexOf(":")) %>" readonly="readonly" /> 


<div class="Clear"></div>



<input type="hidden" name="careTime1" value="<%=time.substring(0,time.lastIndexOf(":"))  %>" readonly="readonly" />
<input type="hidden" name="careTime" value="<%=time%>" readonly="readonly" />
<%-- <input type="hidden" id="inpatientId" name="inpatientId" value="<%=inpatient.getId()%>"/> --%>


<div id="edited"></div>
<div id="statusMessage" class="messagelabel"><br />
</div>


<input type="button" class="button" value="Submit " align="left"
	onClick="submitForm('generateReferralLetterPage','referral?method=submitReferralLetterPage');" />
<input type="button" class="button" value="Back" align="left"
	onClick="submitFormForButton('generateReferralLetterPage','referral?method=referralWaitingList');" />
<input type="reset" name="reset" value="Reset" class="button" onclick="location.reload();"/>
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

</script>





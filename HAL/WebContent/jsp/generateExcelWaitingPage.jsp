
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

<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.ReferralPatientDetails"%>
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

<%	List<PatientDietIndoorDetail> patientDietIndoorDetailList = new ArrayList<PatientDietIndoorDetail>();
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
	int visitId = 0;
	int opdPatientDetailsId = 0;
	int adNo=0;
	String hinNo="";
	String serviceNo = "";
	int inpatientId = 0;

	if(opdPatientDetails.getVisit()!= null)
	{
		patient = opdPatientDetails.getVisit().getHin();
		referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
		visitId = opdPatientDetails.getVisit().getId();
		
	}
	else
	{
		patient = opdPatientDetails.getInpatient().getHin();
		referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
		adNo = opdPatientDetails.getInpatient().getId();
		visitId = opdPatientDetails.getInpatient().getVisit().getId();
		inpatientId = opdPatientDetails.getInpatient().getId();
	}
		
	hinId = patient.getId();
	hinNo = patient.getHinNo();
	serviceNo = patient.getServiceNo();
	opdPatientDetailsId= opdPatientDetails.getId();
		if(patient.getPFirstName() != null)
		   {
	       patientName=patient.getPFirstName()+" ";
		   }
		if(patient.getPMiddleName() != null)
			   {
			   patientName +=patient.getPMiddleName()+" " ;
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
			currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
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




<label> Diagnosis</label> 
	<%
	List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
	List<ReferralPatientDetails> referralPatientDetailsList = new ArrayList<ReferralPatientDetails>();
	String subject = "";
	String note = "";
	int validity_period = 0;
	int referralPatientDetailsId = 0;
	String flag= "";
	String referralTreatmentType = "";
	if(map.get("diagnosisList")!=null){
		diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
		
	}
	if(map.get("referralPatientDetailsList")!=null){
		referralPatientDetailsList = (List<ReferralPatientDetails>)map.get("referralPatientDetailsList");
		subject = referralPatientDetailsList.get(0).getSubject();
		note = referralPatientDetailsList.get(0).getReferralNote();
		validity_period = referralPatientDetailsList.get(0).getLetterValidityPeriod();
		referralPatientDetailsId = referralPatientDetailsList.get(0).getId();
		if(referralPatientDetailsList.get(0).getReferralPatientHeader().getEmployeeDependent()!=null)
		{
			flag="dependent";
		}
		else
		{
			flag="employee";
		}
		
		 referralTreatmentType = referralPatientDetailsList.get(0).getReferralPatientHeader().getOpdPatientDetails().getReferralTreatmentType();
	}
	if(diagnosisList != null && diagnosisList.size() > 0 && diagnosisList.get(0).getIcd()!=null)
	{
	%> <label class="valueFixedWidth"><%=diagnosisList.get(0).getIcd().getIcdName()%></label>
	<%
		}else{
		%> <label class="value"></label> <%	
		}
		%> 
		

  <div class="Clear"></div>
        <label>Doctor Note</label>
         <textarea class = "large" readonly="readonly"><%=(referralPatientDetailsList.get(0).getDoctorRemarks()!=null?referralPatientDetailsList.get(0).getDoctorRemarks():" ")%></textarea>
         <div class="Clear"></div>
<label > Note:<span>*</span></label><input type="text" class = "large"  validate="Note,String,no" maxlength="500" value="<%=note %>" name ="referral_note" id ="referral_note" readOnly = "true"/>

<div class="Clear"></div>

		 
		 <label>Doctor Name</label>
         <label class="value"><%=consultantName %></label>
<label> This letter is valid for <span>*</span></label><input type="text" value="<%=validity_period %>" class = "small" name ="validity_period" id="validity_period" validate="Validity Period,int,no" maxlength="5" readOnly = "true"/>Days
<div class="Clear"></div>
<label> Subject:<span>*</span></label><input type="text"  class="large" value="<%=subject %>" name ="subject" id ="subject" validate="Subject,String,no" maxlength="250" readOnly = "true"/>
<input type = "hidden" value = "<%=referralPatientDetailsId %>" name = "referralPatientDetailsId" id="referralPatientDetailsId"/>
</div>

<%-- <h4>Treatment Details</h4>
<div class="Clear"></div>
<div class="Block">




<label>Total Bill Amount<span>*</span></label><input type="text" validate="Empanelled Bill,int,yes" maxlength="15" name ="impanelled_bill" id ="impanelled_bill" />


<label>Approved Bill Amount<span>*</span></label><input type="text" validate="HAL Bill,int,yes" maxlength="15" name ="hal_bill" id ="hal_bill" />
<div class="Clear"></div>
<label>Remarks</label><textarea validate="Remarks,string,no" maxlength="500" name ="admin_remarks" id ="admin_remarks" /></textarea>
<div class="Clear"></div>

	<input type="button" class="button" value="Referral Note " onClick="submitFormForButton('generateReferralLetterPage','referral?method=showInvoiceReport&referralPatientDetailsId=<%=referralPatientDetailsId%>&flag=<%=flag%>&referralTreatmentType=<%=referralTreatmentType%>');" align="left"
	onClick="" />

    <%if(opdPatientDetails.getInpatient()!=null)
    	{
    	%>
	<input type="button" class="button" value="OPD Case Sheet " align="left"
    			onclick = "submitFormForButton('generateReferralLetterPage','opd?method=showOpdCaseSheetReport&hinNo=<%=hinNo%>&visitId=<%=visitId%>&flagPrint=opd');" />
	
	
	<input type="button" class="button" value="IPD Case Sheet " align="left"
	onClick="submitFormForButton('generateReferralLetterPage','discharge?method=showDischargeSummaryReport&flag=c&adNo=<%=adNo%>&hinNo=<%=hinNo%>&serviceNo=<%=serviceNo%>');" />
	<%}
    else
    {	%>
    	<input type="button" class="button" value="OPD Case Sheet " align="left"
    			onclick = "submitFormForButton('generateReferralLetterPage','opd?method=showOpdCaseSheetReport&hinNo=<%=hinNo%>&visitId=<%=visitId%>&flagPrint=opd');" />
    
    <%}
   	%>
	
	<input type="button" class="button" value="Upload/Download Documents" align="left"
	onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&hinId=<%=hinId%>&backFlag=ipd&inpatientId=<%=inpatientId%>&visitId=<%=visitId%>')" />
	
	
	<a href="#" onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&hinId=<%=hinId%>&backFlag=ipd&inpatientId=<%=inpatientId%>')">Upload Documents </a>
	
	
	

</div> --%>

<h4>Extension Details</h4>
<div class="Clear"></div>
<div class="Block" id="extensionList">
<div id="divExtension1">
  <label>Impannelled Remarks</label>
<textarea rows="" cols="" name="impannelledRemarks1" id="impannelledRemarks1" ></textarea>

			<label>Extension Days<span>*</span> </label>
		<input type ="text" id="extndays1" name="extndays1" value="" validate="Extension Days,int,yes">

	<input name="Button" type="button" class="buttonAdd" value="" onclick="addDivExtension();" tabindex="1" /> 			
	<input type="button" name="delete" value="" class="buttonDel" onclick="removeDivExtension();" tabindex="1" />
		
	
  <div class="clear"></div> 
  </div>
</div>

<h4>Treatment Details</h4>
<div class="Clear"></div>
<div class="Block" id="billingList">
<div id="divBilling1">
    <label>Total Bill Amount<span>*</span></label><input type="text" validate="Empanelled Bill,int,yes" maxlength="15" name ="impanelled_bill1" id ="impanelled_bill1" />

<label>Approved Bill Amount<span>*</span></label><input type="text" validate="HAL Bill,int,yes" maxlength="15" name ="hal_bill1" id ="hal_bill1" />
	<input name="Button" type="button" class="buttonAdd" value="" onclick="addDivBilling();" tabindex="1" /> 			
	<input type="button" name="delete" value="" class="buttonDel" onclick="removeDivBilling();" tabindex="1" />
<div class="Clear"></div>
<label>Remarks</label><textarea validate="Remarks,string,no" maxlength="500" name ="admin_remarks1" id ="admin_remarks1" /></textarea>



		
	
  <div class="clear"></div> 
  </div>
</div>

<input type="hidden" name ="divCountBilling" id="divCountBilling" value="1"/>
<input type="hidden" name ="divCountExtension" id="divCountExtension" value="1"/>

<h4>Download Documents</h4>
<div class="Clear"></div>
<div class="Block">







	<input type="button" class="button" value="Referral Note " onClick="submitFormForButton('generateReferralLetterPage','referral?method=showInvoiceReport&referralPatientDetailsId=<%=referralPatientDetailsId%>&flag=<%=flag%>&referralTreatmentType=<%=referralTreatmentType%>');" align="left"
	onClick="" />

    <%if(opdPatientDetails.getInpatient()!=null)
    	{
    	%>
	<input type="button" class="button" value="OPD Case Sheet " align="left"
    			onclick = "submitFormForButton('generateReferralLetterPage','opd?method=showOpdCaseSheetReport&hinNo=<%=hinNo%>&visitId=<%=visitId%>&flagPrint=opd');" />
	
	
	<input type="button" class="button" value="IPD Case Sheet " align="left"
	onClick="submitFormForButton('generateReferralLetterPage','discharge?method=showDischargeSummaryReport&flag=c&adNo=<%=adNo%>&hinNo=<%=hinNo%>&serviceNo=<%=serviceNo%>');" />
	<%}
    else
    {	%>
    	<input type="button" class="button" value="OPD Case Sheet " align="left"
    			onclick = "submitFormForButton('generateReferralLetterPage','opd?method=showOpdCaseSheetReport&hinNo=<%=hinNo%>&visitId=<%=visitId%>&flagPrint=opd');" />
    
    <%}
   	%>
	
	<input type="button" class="button" value="Upload/Download Documents" align="left"
	onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&hinId=<%=hinId%>&backFlag=ipd&inpatientId=<%=inpatientId%>&visitId=<%=visitId%>')" />
	
	
	<%-- <a href="#" onclick="openWindow('/hms/hms/opd?method=showUploadingDocumentsJsp&hinId=<%=hinId%>&backFlag=ipd&inpatientId=<%=inpatientId%>')">Upload Documents </a> --%>
	
	
	

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


<input type="button" class="button" value="Save " align="left"
	onClick="submitForm('generateReferralLetterPage','referral?method=submitInvoicePage');" />
<!-- <input type="button" class="button" value="Reject " align="left" /> -->
<input type="button" class="button" value="Back" align="left"
	onClick="submitFormForButton('generateReferralLetterPage','referral?method=excelWaitingList');" />
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
	
function openWindow(url){

    newwindow=window.open(url,'name',"left=2,top=100,height=500,width=900,status=1,scrollbars=1,resizable=0");
	
}

function addDivExtension(){
	  
	  var divList = document.getElementById('extensionList');		 
	  var divCount = parseInt(document.getElementById("divCountExtension").value);
	  var iteration = divCount+1;
	  var newdiv = document.createElement('divExtension');
    newdiv.setAttribute('id', 'divExtension'+iteration);
    divList.appendChild(newdiv);
	 
    var e1 = document.createElement('label');
	  e1.innerHTML = "Impannelled Remarks";
	  newdiv.appendChild(e1);
	  
	  var e2 = document.createElement('textarea');
	  e2.name='impannelledRemarks'+iteration;		  
	  e2.id='impannelledRemarks'+iteration;	  
	  newdiv.appendChild(e2);
	  
	  var e3 = document.createElement('label');
	  e3.innerHTML = "Extension Days<span>*<span>";
	  newdiv.appendChild(e3);
	  
	  var e4 = document.createElement('input');
	  e4.name='extndays'+iteration;		  
	  e4.id='extndays'+iteration;
	  e4.type = 'text';	  
	  e4.setAttribute('validate','Extension Days,int,yes');	
	  newdiv.appendChild(e4);
		  
		  var e5 = document.createElement('input');
		  e5.type = 'button';
		  e5.name='Button';
		  e5.onclick=function(){addDivExtension();}
		  e5.setAttribute("class", "buttonAdd");			 
		  newdiv.appendChild(e5);
		  
		  var e6 = document.createElement('input');
		  e6.type = 'button';
		  e6.name='delete';
		  e6.onclick=function(){removeDivExtension();}
		  e6.setAttribute("class", "buttonDel");			 
		  newdiv.appendChild(e6);
		  
		  var newline = document.createElement('div');
		  newline.setAttribute("class", "clear");		
		  newdiv.appendChild(newline);
		  document.getElementById("divCountExtension").value = iteration;


	}
function removeDivExtension()
{
var divCount = parseInt(document.getElementById("divCountExtension").value);
if(divCount>1)
	{
	
	document.getElementById("divExtension"+divCount).remove();
	document.getElementById("divCountExtension").value = (divCount-1);
	}
	

}

function addDivBilling(){
	  
	  var divList = document.getElementById('billingList');		 
	  var divCount = parseInt(document.getElementById("divCountBilling").value);
	  var iteration = divCount+1;
	  var newdiv = document.createElement('divBilling');
  newdiv.setAttribute('id', 'divBilling'+iteration);
  divList.appendChild(newdiv);
	 
     
	  
	  var e1 = document.createElement('label');
	  e1.innerHTML = "Total Bill Amount<span>*<span>";
	  newdiv.appendChild(e1);
	  
	  var e2 = document.createElement('input');
	  e2.name='impanelled_bill'+iteration;		  
	  e2.id='impanelled_bill'+iteration;
	  e2.type = 'text';	  
	  e2.setAttribute('validate','Empanelled Bill,int,yes');	
	  newdiv.appendChild(e2);
	  
	  var e3 = document.createElement('label');
	  e3.innerHTML = "Approved Bill Amount<span>*<span>";
	  newdiv.appendChild(e3);
	  
	  var e4 = document.createElement('input');
	  e4.name='hal_bill'+iteration;		  
	  e4.id='hal_bill'+iteration;
	  e4.type = 'text';	  
	  e4.setAttribute('validate','HAL Bill,int,yes');	
	  newdiv.appendChild(e4);
		  
		  var e5 = document.createElement('input');
		  e5.type = 'button';
		  e5.name='Button';
		  e5.onclick=function(){addDivBilling();}
		  e5.setAttribute("class", "buttonAdd");			 
		  newdiv.appendChild(e5);
		  
		  var e6 = document.createElement('input');
		  e6.type = 'button';
		  e6.name='delete';
		  e6.onclick=function(){removeDivBilling();}
		  e6.setAttribute("class", "buttonDel");
		  
		  newdiv.appendChild(e6);
		  
		  var newline = document.createElement('div');
		  newline.setAttribute("class", "clear");		
		  newdiv.appendChild(newline);
		  
		  var e7 = document.createElement('label');
		  e7.innerHTML = "Remarks";
		  newdiv.appendChild(e7);
		  
		  var e8 = document.createElement('textarea');
		  e8.name='admin_remarks'+iteration;		  
		  e8.id='admin_remarks'+iteration;	  
		  e8.setAttribute('validate','Remarks,string,no');	
		  newdiv.appendChild(e8);
		  
		  var newline1 = document.createElement('div');
		  newline1.setAttribute("class", "clear");		
		  newdiv.appendChild(newline1);
		  document.getElementById("divCountBilling").value = iteration;


	}
function removeDivBilling()
{
var divCount = parseInt(document.getElementById("divCountBilling").value);
if(divCount>1)
	{
	
	document.getElementById("divBilling"+divCount).remove();
	document.getElementById("divCountBilling").value = (divCount-1);
	}
	

}

</script>





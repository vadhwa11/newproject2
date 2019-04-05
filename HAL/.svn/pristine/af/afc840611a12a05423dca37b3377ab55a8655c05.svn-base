<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * visitByHin.jsp
 * Purpose of the JSP -  This is for Visit By HIN.
 * @author  Ritu
 * Create Date: 08th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.22
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>

<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>



<%--For AutoComplete Through Ajax--%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasTherapyType"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.PhysiotherapyDetails"%>

<%@page import="jkt.hms.masters.business.PhysioRequisitionDetail"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>

<%@page import="jkt.hms.masters.business.PhysioAppointmentDetail"%>
<%@page import="jkt.hms.masters.business.PhysioRequisitionHeader"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

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

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

//	List<Visit> visitList = new ArrayList<Visit>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentTimeWithoutSecond();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	List<PhysioRequisitionDetail> physioRequisitionList = new ArrayList<PhysioRequisitionDetail>();
	
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("frequencyList") != null){
		frequencyList = (List<MasFrequency>)map.get("frequencyList");
	}
	
	//if(map.get("patientList") != null){
		//patientList = (List<OpdPatientDetails>)map.get("patientList");
	//}
	List<MasTherapyType> therapyTypeList = new ArrayList<MasTherapyType>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if(map.get("therapyTypeList") != null){
		therapyTypeList = (List<MasTherapyType>)map.get("therapyTypeList");
	}
	if(map.get("employeeList") != null){
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	List<PhysioAppointmentDetail> phyAppointmentList = new ArrayList<PhysioAppointmentDetail>();
	if(map.get("phyAppointmentList") != null){
		phyAppointmentList = (List<PhysioAppointmentDetail>)map.get("phyAppointmentList");
	}
	if(map.get("physioRequisitionList") != null){
		physioRequisitionList = (List<PhysioRequisitionDetail>)map.get("physioRequisitionList");
	}
	
	//OpdPatientDetails opdPatientDetails = patientList.get(0);
	//Visit visit = opdPatientDetails.getVisit();
	//Patient patient = visit.getHin();
	Visit visit = new Visit();
	Patient patient = new Patient();
	int physioRequisitionHeaderId = 0;
	PhysioAppointmentDetail physiotherapyAppDetails = new PhysioAppointmentDetail();
	if(phyAppointmentList.size() > 0){
		physiotherapyAppDetails = phyAppointmentList.get(0);
		 visit = physiotherapyAppDetails.getAppointmentHeader().getVisit();
		 patient = physiotherapyAppDetails.getAppointmentHeader().getHin();
		 physioRequisitionHeaderId = physiotherapyAppDetails.getAppointmentHeader().getId();
	}
%>



<form name="physiotherapyVisitEntryAppintment" method="post">
	<div class="titleBg">
	<h2>Physiotherapy Visit Entry</h2></div>
	<div class="clear"></div>

	<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
			<label>Service No</label>
		  <%
				if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
			%>
			<label class="value"><%= patient.getServiceNo()%></label>
			<%}else{ %>
			<label class="value">-</label>
			<%}%>
		<label>HIN</label>
		<label class="value"><%=patient.getHinNo() %></label>
		<input name="hinNo" value="<%=patient.getHinNo() %>" type="hidden">
				
				
		<div class="clear"></div>

		


<%
					String middleName = "";
					String lastName = "";
					if(patient.getPMiddleName() != null){
						middleName = patient.getPMiddleName();
					}
					if(patient.getPLastName() != null){
						lastName = patient.getPLastName();
					}

					%>
		<label>Patient Name</label>
		<label class="value"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>

		<label>Relation</label>
		<%
			if(patient.getRelation() != null){
		%>
		<label class="value"><%= patient.getRelation().getRelationName()%></label>
			<%}else{ %>
		<label class="value">-</label>
			<% }%>

		
		<label> Rank </label>
		<%
		    if(patient.getRank() != null){
		%>

		<label class="value"><%= patient.getRank().getRankName()%></label>
		<%} else{ %>
		<label class="value">-</label>
		<% }%>
		<div class="clear"></div>

		<%
					String sMiddleName = "";
					String sLastName = "";
					if(patient.getSMiddleName() != null){
						sMiddleName = patient.getSMiddleName();
					}
					if(patient.getSLastName() != null){
						sLastName = patient.getSLastName();
					}

					%>
		<label>Name</label>
		<label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
		
	
		<label >Gender</label>
		<%if(patient.getSex() != null){ %>
		<label class="value"><%=patient.getSex().getAdministrativeSexName()%></label>
		<%}else{ %>
		<label class="value">--</label>
		<%} %>

	
		<%
		String currentAge = "";
		String age = patient.getAge();
		currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());

		%>
		<label>Age</label>
		<label class="value"><%=currentAge%></label>
			<div class="clear"></div>	
		<label>Unit</label>
		 <%
		if(patient.getUnit() != null){
		%> 
		<label class="value"><%= patient.getUnit().getUnitName()%></label>
		<%}else{ %>
		<label class="value">-</label>	
		<%} %>

		<label>Section</label>
		<%
			if(patient.getSection() != null){
		%>
		<label	class="value"><%= patient.getSection().getSectionName()%></label>
		<%}else{ %>
		<label class="value">-</label>	
		<%} %>
		
		
		<label>Trade/Branch</label>
		<%
			if(patient.getTrade() != null){
		%> 
		<label class="value"><%= patient.getTrade().getTradeName()%></label>
		<%}else{ %>
		<label class="value">-</label>	
		<%} %>
		<div class="clear"></div>
		<label >Mobile No.</label>
		<%
			if(patient.getMobileNumber() != null){
		%>
		<label class="value"><%=patient.getMobileNumber()  %></label>	
		<%} else{ %>
		<label class="value">-</label>	
		<%} %>
		
		<label >Telephone No.</label>
		<%
			if(patient.getPhoneNumber() != null){
		%>
		<label class="value"><%=patient.getPhoneNumber()  %></label>	
		<%} else{ %>
		<label class="value">-</label>	
		<%} %>
		<label>Medical Officer</label>
	<%
		String doctorName = "";
	if(visit.getDoctor()!= null){
		doctorName = visit.getDoctor().getFirstName();
	
		if(visit.getDoctor().getMiddleName()!= null){
			doctorName += " "+visit.getDoctor().getMiddleName();
		}
		if(visit.getDoctor().getLastName()!= null){
			doctorName += " "+visit.getDoctor().getLastName();
		}
	}
	%>
	<%if(!doctorName.equals("")){ %>
	<label class="value"><%=doctorName %></label>
	<input type="hidden" name="<%=MEDICAL_OFFICER_ID %>" value="<%= visit.getDoctor()!=null?visit.getDoctor().getId():"0" %>">
	<%}else{ %>
	<label class="value">--</label>
	<%} %>
	<div class="clear"></div>
	<label>Visit/A&D No.</label>
	<%int visitNo = 0;
	if(visit.getVisitNo() != null){
	%>
	<label class="value"><%=visit.getVisitNo() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>
	<label> Diagnosis</label>
		<%
			String diagnosis = "";
		Set<OpdPatientDetails> opdPatientDetails = new HashSet<OpdPatientDetails>();
			if(visit.getOpdPatientDetails() != null){
				  opdPatientDetails =visit.getOpdPatientDetails();
				  for(OpdPatientDetails patientDetails :opdPatientDetails){
					  diagnosis = patientDetails.getInitialDiagnosis();  
				   }
			     }
				%>
		<%if(diagnosis != null){ %>
		<label class="value"><%=diagnosis %></label>
		<%}else{ %>
		<label class="value">--</label>
		<%} %>
		<input type="hidden" name="<%=DIAGNOSIS%>" style="width: 190px" value="<%= diagnosis %>" validate="Diagnosis,metachar,yes" maxlength="100">
	
  </div>
	<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Physiotherapy Details</h4>
<div class="clear"></div>
		
		<input id="hinId" type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>">
		<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId()%>">

	
<script type="text/javascript">var frequencyArray=new Array();</script>
   
        <div class="clear"></div>
               <div class="paddingTop15"></div>

       
       
<div class="Clear"></div>
<table width="90%" colspan="7" cellpadding="0" cellspacing="0" id="tharapyGrid">
	<thead>
		<tr>
		<th>Therapy name</th>
		<th>Duration</th>
		<th>Frequency</th>
		<th>No. of Days</th>
		</tr>
	</thead>
	<%
	 if(physioRequisitionList.size()>0){
	    for(PhysioRequisitionDetail physioRequisitionDetail :physioRequisitionList){
	
	%>
	<tr>
	<%if(physioRequisitionDetail.getTharaphy() != null){ %>
	<td><%=physioRequisitionDetail.getTharaphy().getTherapyTypeName() %>
	</td>
	<%} %>
	<%if(physioRequisitionDetail.getDuration() != null){ %>
	<td><%=physioRequisitionDetail.getDuration() %></td>
	<%} %>
	<%if(physioRequisitionDetail.getFrequency() != null){ %>
	<td><%=physioRequisitionDetail.getFrequency().getFrequencyName() %></td>
	<%} %>
	<%if(physioRequisitionDetail.getNoOfDays() != null){ %>
	<td><%=physioRequisitionDetail.getNoOfDays() %></td>
	<%} %>
	</tr>
	<%}} %>
</table>

<div class="clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<table width="90%" colspan="7" cellpadding="0" cellspacing="0" id="tharapyGrid">
	<thead>
		<tr>
		<th>App. Date</th>
		<th>Time</th>
		<th>Therapy Name</th>
		<th>Visit Date</th>
		<th>Visit Time</th>
		<th>Time Begun</th>
		<th>Time Complete</th>
		<th>Sitting Time</th>
		<th>Remarks</th>
		</tr>
	</thead>
	<%
	int i=0;
	int physioReqHeaderId = 0;
	 if(phyAppointmentList.size()>0){
	    for(PhysioAppointmentDetail physioAppointmentDetail :phyAppointmentList){
		Visit visit2 = physioAppointmentDetail.getAppointmentHeader().getVisit();
		if(physioAppointmentDetail.getAppointmentHeader().getPhysioRequisition()!= null){
			physioReqHeaderId = physioAppointmentDetail.getAppointmentHeader().getPhysioRequisition().getId();
		}
		i++;
	%>
	<tr>
	<%if(physioAppointmentDetail.getAppointmentDate() != null){ %>
	<td><%=HMSUtil.convertDateToStringWithoutTime(physioAppointmentDetail.getAppointmentDate()) %>
	<input type="hidden" name="nextAppointmentDate<%=i %>" value="<%=HMSUtil.convertDateToStringWithoutTime(physioAppointmentDetail.getAppointmentDate())%>" tabindex="1" id="nextAppointmentDate<%=i %>"  size="8"	maxlength="3" />
	</td>
	<%} %>
	<%if(physioAppointmentDetail.getAppointmentTime() != null){ %>
	<td><%=physioAppointmentDetail.getAppointmentTime() %>
	<input type="hidden" name="nextAppointmentTime<%=i %>" value="<%=physioAppointmentDetail.getAppointmentTime() %>" tabindex="1" id="nextAppointmentTime<%=i %>"  size="3" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);"	maxlength="5"  /></td>
	<%} %>
	<%if(physioAppointmentDetail.getTherapy()!= null){ %>
	<td><%=physioAppointmentDetail.getTherapy().getTherapyTypeName() %>
	<input type="hidden" name="therapyId<%=i %>" id="therapyId<%=i %>"	value="<%=physioAppointmentDetail.getTherapy().getId() %>" />
	<input type="hidden" name="physioReqHeaderId<%=i %>" value="<%=physioReqHeaderId%>" tabindex="1" id="physioReqHeaderId<%=i %>"  size="8"	maxlength="3" />
	</td>
	<%} %>
	
	<%if(visit2.getVisitDate()!= null){ %>
	<td><%=HMSUtil.convertDateToStringWithoutTime(visit2.getVisitDate())%></td>
	<%} %>
	<%if(visit2.getVisitTime() != null){ %>
	<td><%=visit2.getVisitTime()%></td>
	<%}else{ %>
	<td>&nbsp;</td>
	<%} %>
	<td>
	<input type="text" name="timeBegin<%=i %>" value="" tabindex="1" id="timeBegin<%=i %>"  size="3" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);"	maxlength="5"  />
	<%if(physioAppointmentDetail.getFrequency() != null){ %>
	<input type="hidden" name="frequency<%=i %>" value="<%=physioAppointmentDetail.getFrequency().getId() %>" tabindex="1" id="frequency<%=i %>"	size="12" maxlength="5" />
	<%} %>
	<%if(physioAppointmentDetail.getDuration() != null){ %>
	<input type="hidden" name="duration<%=i %>" tabindex="1" id="durationId<%=i %>" value="<%=physioAppointmentDetail.getDuration()%>"	size="12" maxlength="5" /></td>
	<%} %>
	<%if(physioAppointmentDetail.getNoOfDays() != null){ %>
	<input type="hidden" name="noOfDays<%=i %>" value="<%=physioAppointmentDetail.getNoOfDays() %>" tabindex="1" id="noOfDays<%=i %>"  size="3"	maxlength="3" /></td>
	<%} %>
	</td>
	<td><input type="text" name="timeComplete<%=i %>" value="" tabindex="1" id="timeComplete<%=i %>"  size="3" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);calculateTime(<%=i %>);"	maxlength="5" /></td>
	<td><input type="text" name="sittingTime<%=i %>" value="" tabindex="1" id="sittingTime<%=i %>"  size="3"	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" maxlength="5"  /></td>
	<td><input type="text" name="remarks<%=i %>" tabindex="1" value="" id="remarks<%=i %>"  size="20"	maxlength="50"  /></td>
	
	</tr>
	<%}} %>
</table>
<input type="hidden" name="tharapyCount" value="<%=i %>" id="tharapyCount" />
<div class="clear"></div>
 
        
   

<div class="division"></div>
<div class="clear"></div>



    <div id="edited"></div>
			<input type="button" name="submitForDisable" id="submitForDisable" value="Save" class="button" onClick="submitForm('physiotherapyVisitEntryAppintment','/hms/hms/physiotherapy?method=saveVisitEntryForAppointmentDetails');" />
			<input type="reset" name ="Reset" value ="Reset" class="button" accesskey="r" />
			<input type="button" class="button"  value="Back" align="right" onClick="history.back();" />
			
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">

		<label>Changed By</label>
		<label class="value"><%=userName%></label>

		<label>Changed Date</label>
		<label class="value"><%=currentDate%></label>

		<label>Changed Time</label>
		<label class="value"><%=time%></label>

		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
		<input type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=currentDate%>"  />
		<input type="hidden" name="<%=LAST_CHANGED_TIME %>"  value="<%=time%>" />

		</div>

		<div id="statusMessage" class="messagelabel">
			<div class="clear"></div>
			</div>
</form>
<script>
function getTheraphyId(val,inc){
	if(val != ""){
			
			var index1 = val.lastIndexOf("[");
			var indexForTheraphyCode = index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var therapyId = val.substring(index1,index2);
			var indexForTheraphyCode = indexForTheraphyCode--;
			var theraphyCode = val.substring(0,indexForTheraphyCode);

			 
			if(therapyId == "" ) {
		      	document.getElementById('therapyTypeId'+inc).value="";
		      	//document.getElementById('pvmsNo'+inc).value="";
		     // 	document.getElementById('clinicalNotes'+inc).value="";
		 	 // 	document.getElementById('qty'+inc).value="";
		      	return;
			}
			
		if(therapyId!=""){
			submitProtoAjaxWithDivName('physiotherapyVisitEntryAppintment','/hms/hms/opd?method=getTheraphyId&counter='+inc+'&therapyId='+therapyId,'therapyDiv'+inc);
		}
	}
		
	}

function calculateTime(inc){

	var time1 = HMStoSec1(document.getElementById('timeBegin'+inc).value);
	var time2 = HMStoSec1(document.getElementById('timeComplete'+inc).value);
	 var totalTime ;
	var diff = time2 - time1;
	if(document.getElementById('timeBegin'+inc).value == "00:00" && document.getElementById('timeComplete'+inc).value == "00:00"){
		alert("Time cannot be 00:00");
		document.getElementById('totalHours').value = "00:00";
		return false;
	}
	else if(document.getElementById('timeComplete'+inc).value >= document.getElementById('timeBegin'+inc).value){
		totalTime = (convertSecondsToHHMM(diff));
		document.getElementById('sittingTime'+inc).value = totalTime;
	return true;
	}else{
	alert("Time Begin should be less than Time Completed");
	return false;
	}

}

function validatePhyFields(){
	var count = document.getElementById('tharapyCount').value;
	var flag ='';
	 for(var i = 1; i <= count; i++){
		 if(document.getElementById('therapyId'+i)){
		var theraphyId = document.getElementById('therapyId'+i).value;
		if(theraphyId!=='0')
	      	 {
	          flag = 'filled';
	          break;
			}
		 }
		}

	 var msg = "";
	 for(var j = 1;j <= count;j++){
		 if(document.getElementById('therapyId'+j)){
				var therapyId = document.getElementById('therapyId'+j).value;
				if( therapyId != '0'){
				if(document.getElementById('durationId'+j).value == 0 )
	            {
					msg += "Please select the Duration in row "+(j)+".\n";
					
				 }	
				if(document.getElementById('frequency'+j).value == 0 && document.getElementById('durationId'+j).value != 0)
	            {
					msg += "Please select the Frequency in row "+(j)+".\n";
					
				 }	
				if(document.getElementById('noOfDays'+j).value == 0 && document.getElementById('durationId'+j).value != 0)
	            {
					msg += "Please select the no of days in row "+(j)+".\n";
					
				 }
				if(document.getElementById('timeBegin'+j).value == 0 && document.getElementById('noOfDays'+j).value != 0 && document.getElementById('durationId'+j).value != 0 )
	            {
					msg += "Please select Time Begin in row "+(j)+".\n";
					
				 }
				if(document.getElementById('timeComplete'+j).value == 0  && document.getElementById('timeBegin'+j).value != 0 && document.getElementById('noOfDays'+j).value != 0 && document.getElementById('durationId'+j).value != 0 )
	            {
					msg += "Please select Time Complete in row "+(j)+".\n";
					
				 }
				if(document.getElementById('sittingTime'+j).value == 0  && document.getElementById('timeComplete'+j).value != 0  && document.getElementById('timeBegin'+j).value != 0 && document.getElementById('noOfDays'+j).value != 0 && document.getElementById('durationId'+j).value != 0 )
	            {
					msg += "Please select Sitting Time in row "+(j)+".\n";
					
				 }	
				}
		 	}
		}
	 if(flag==''){
		 msg += "Please select Therapy Type.\n";;
					
		}
		if(msg!=''){
			alert(msg);
			return false;
		}
	return true;	
	 }
	


function HMStoSec1(T) { // h:m:s

	  var A = T.split(/\D+/) ;
	
	  return (A[0]*60 + +A[1])*60
	}
function calculateTime(inc){

	var time1 = HMStoSec1(document.getElementById('timeBegin'+inc).value);
	var time2 = HMStoSec1(document.getElementById('timeComplete'+inc).value);
	 var totalTime ;
	var diff = time2 - time1;
	if(document.getElementById('timeBegin'+inc).value == "00:00" && document.getElementById('timeComplete'+inc).value == "00:00"){
		alert("Time cannot be 00:00");
		document.getElementById('totalHours').value = "00:00";
		return false;
	}
	else if(document.getElementById('timeComplete'+inc).value >= document.getElementById('timeBegin'+inc).value){
		totalTime = (convertSecondsToHHMM(diff));
		document.getElementById('sittingTime'+inc).value = totalTime;
	return true;
	}else{
	alert("Time Begin should be less than Time Completed");
	return false;
	}
	
	

}

function validateRadio(){
	 for(var i = 0; i < document.getElementsByName('physioRequisitionHeaderId').length; i++){
	//alert("i-- "+i)
	//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
	  if(document.getElementsByName('physioRequisitionHeaderId')[i].checked == true)
    {
		
		return true;
	  }		
	}
	alert("Please select one record.")
	return false;
}

function convertSecondsToHHMM(intSecondsToConvert) {

	var hours = convertHours(intSecondsToConvert);
	hours = (hours<10)?"0"+hours : hours
	var minutes = getRemainingMinutes(intSecondsToConvert);
	minutes = (minutes == 60) ? "00" : minutes;
	minutes = (minutes<10)?"0"+minutes : minutes
//	var seconds = getRemainingSeconds(intSecondsToConvert);
	
 	var time = hours+":"+minutes;
	return time;

}

</script>
<script> calculateTime();</script>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.PhysiotherapyVisitDetails"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<!-- <script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>-->
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%@page import="java.util.Calendar"%>
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
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	String tokenNo = "";
	int physiotherapyVisitNo = 0;
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	
	
	List<PhysiotherapyVisitDetails> physiotherapyVisitDetailsList = new ArrayList<PhysiotherapyVisitDetails>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientMap") != null){
		patientMap = (Map<String,Object>)map.get("patientMap");
	}
	if(map.get("patientMap") != null){
		patientMap = (Map<String,Object>)map.get("patientMap");
	}
	if(patientMap.get("physiotherapyVisitNo") != null){
		physiotherapyVisitNo = (Integer)patientMap.get("physiotherapyVisitNo");
	}
	if(patientMap.get("physiotherapyVisitDetailsList") != null){
		physiotherapyVisitDetailsList = (List<PhysiotherapyVisitDetails>)patientMap.get("physiotherapyVisitDetailsList");
	}

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	String departmentTypeCodeForCR = properties.getProperty("departmentTypeCodeForCR");
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		
	if(physiotherapyVisitDetailsList.size() > 0)
	{
		PhysiotherapyVisitDetails physiotherapyVisitDetails = physiotherapyVisitDetailsList.get(0);
		Patient patient = physiotherapyVisitDetails.getHin();
		if(!patient.getPatientStatus().equals("Expired")){
			String age = "";
			String currentAge = "";
			age = patient.getAge();
			currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());
				
			
		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
		}
		if(detailsMap.get("employeeList") != null){
			employeeList = (List<MasEmployee>)detailsMap.get("employeeList");
		}
		if(map.get("tokenNo") != null){
			tokenNo = ((Integer)map.get("tokenNo")).toString();
		}
		
%>


<div id="contentHolder">

<form name="visitByHinPhysiotherapy" action="" method="post">

<h6>Patient Treatment Visit</h6>
<div class="Clear"></div>

<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Service Type</label> <label
	class="value"><%= patient.getServiceType().getServiceTypeName()%></label>

<label>Service No</label> <%
				if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
			%> <label class="value"><%= patient.getServiceNo()%></label> <%}else{ %>
<label class="value">-</label> <%}%> <label>Service Status</label> <%if(patient.getServiceStatus() != null){
			%> <label class="value"><%= patient.getServiceStatus().getServiceStatusName()%></label>
<%}else{ %> <label class="value">-</label> <% }%>
<div class="Clear"></div>

<label>Relation</label> <%
				if(patient.getRelation() != null){
			%> <label class="value"><%= patient.getRelation().getRelationName()%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Name</label> <%
				if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
				
					String sMiddleName = "";
					String sLastName = "";
					if(patient.getSMiddleName() != null){
						sMiddleName = patient.getSMiddleName();
					}
					if(patient.getSLastName() != null){
						sLastName = patient.getSLastName();
					}
			 %> <label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Rank</label> <%
			if(patient.getRank() != null){
			%> <label class="value"><%= patient.getRank().getRankName()%></label>
<%} else{ %> <label class="value">-</label> <% }%> <%	if(patient.getServiceNo() != null && !(patient.getServiceNo().equals(""))){
					if(patient.getServiceCardStatus().equals("y")){
			%>

<div class="Clear"></div>
<label>I-Card Verified</label> <label class="value">Yes</label> <%		}else{%>
<div class="Clear"></div>
<label>I-Card Verified</label> <label class="value">No</label> <%		} 
				}%> <label>I-Card Valid</label> <%
				if(patient.getServiceCardValidityDate() != null){
			%> <label class="value"><%= HMSUtil.convertDateToStringWithoutTime(patient.getServiceCardValidityDate())%></label>
<%}else{ %> <label class="value">-</label> <% }
			%> <label>D_O_ID Card</label> <%
				if(patient.getDependentCardIssueDate() != null){
			%> <label class="value"><%= HMSUtil.convertDateToStringWithoutTime(patient.getDependentCardIssueDate())%></label>
<%}else{ %> <label class="value">-</label> <% }%>
<div class="Clear"></div>

</div>

<!-- <a href="javascript:animatedcollapse.toggle('slide0')">(Click Here)</a> -->
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<div id="slide0"><label>HIN No.</label> <label class="value"><%=patient.getHinNo() %></label>
<input name="hinNo" value="<%=patient.getHinNo() %>" type="hidden">
<%
					String middleName = "";
					String lastName = "";
					if(patient.getPMiddleName() != null){
						middleName = patient.getPMiddleName();
					}
					if(patient.getPLastName() != null){
						lastName = patient.getPLastName();
					}
					
					%> <label>Patient Name</label> <label class="value"
	style="width: auto"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>


<label>Sex</label> <label class="value"><%=patient.getSex().getAdministrativeSexName() %></label>

<div class="Clear"></div>

<label>Marital Status</label> <%
					String maritalStatus = "";
				if(patient.getMaritalStatus() != null){
					maritalStatus = patient.getMaritalStatus().getMaritalStatusName();
				
				%> <label class="value"><%=maritalStatus%></label> <%}else{ %> <label
	class="value">-</label> <% }%> <label>Age</label> <label class="value"><%=currentAge%></label>
<%
				String religion = "";
				if(patient.getReligion() != null){
					religion = patient.getReligion().getReligionName();
				%> <label>Religion</label> <label class="value"><%= religion%></label>
<%} %>
</div>
</div>


<div class="blockTitle">Treatment Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label><span>*</span>Start Date</label> <input
	type="text" id="startDateId" name="<%=FROM_DATE%>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(physiotherapyVisitDetails.getTreatmentStartDate())%>"
	class="calDate" readonly="readonly" validate="Visit Date,date,yes"
	MAXLENGTH="30" /> <label><span>*</span>End Date</label> <input
	type="text" name="<%=TO_DATE%>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(physiotherapyVisitDetails.getTreatmentEndDate())%>"
	class="calDate" id="endDateId" validate="End Date,String,yes"
	maxlength="10" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.getElementById('endDateId'),event)" />

<div class="Clear"></div>

<label><span>*</span>Token No.</label>

<div id="testDiv"><input id="tokenNoId" type="text"
	name="<%=TOKEN_NO %>" value="<%=tokenNo%>"
	validate="Token no.,string,yes" maxlength="3" readonly="readonly">
</div>

<label class="common">Attended:</label> <input type="checkbox"
	name="<%=ATTENDED%>" id="<%=ATTENDED%>" value="P" class="checkbox"
	tabindex="1" />

<div class="Clear"></div>
<input id="hinId" type="hidden" name="<%=HIN_ID %>"
	value="<%=patient.getId() %>"> <input type="hidden"
	name="<%=AGE %>" value="<%=currentAge %>"></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=time%></label> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=PHYSIOTHERAPY_VISIT_DETAILS_ID%>"
	value="<%=physiotherapyVisitDetails.getId()%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div id="edited"></div>
<input type="button" name="submitForDisable" id="submitForDisable"
	value="Update" class="button"
	onClick="submitFormToDisableSubmit('visitByHinPhysiotherapy','opd?method=updatePhysiotherapyVisitInformation');" />
<input type="reset" name="Reset" value="Reset" class="button"
	accesskey="r" /> <input type="button" class="button" value="Back"
	align="right" onClick="history.back();" /></div>
<% }
	}else{
%>

<div class="Clear"></div>
<label class="common">No Record Found!!</label> <% 
}%>
<div id="statusMessage" class="messagelabel">
<div class="Clear"></div>
</div>
</form>
<script type="text/javascript">
	function addRow(){
	
	  var tbl = document.getElementById('chargeDetails');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration;
 	 
 	  var cellSrNo = row.insertCell(0);
	  var SrNo = document.createElement('input');
	  SrNo.type = 'text';
	  SrNo.name='<%=SR_NO%>'+iteration;
	  SrNo.size = '2';
	  SrNo.value = iteration;
	  SrNo.setAttribute('readonly','readonly');	  
	  cellSrNo.appendChild(SrNo);
 
	  var cellTreatment = row.insertCell(1);
	  var treatment = document.createElement('input');
	  treatment.type = 'text';
	 // e0.innerHTML = iteration+':'
	  treatment.onblur=function(){
	                    var val=treatment.value
						   if(val != "") {
								var index1 = val.lastIndexOf("[");
								var indexForTreatmentCode = index1;
								var index2 = val.lastIndexOf("]");
								index1++;
								var treatmentId = val.substring(index1,index2);
								indexForTreatmentCode = indexForTreatmentCode--;
								
								if(treatmentId == "" ) {
	      							document.getElementById('treatment'+iteration).value="";
						      		return;
								}
								for(i=1;i<iteration;i++){
									if(iteration != 1){
										if(document.getElementById('treatment'+i).value == val) {
											alert("Treatment name already selected...!")
											document.getElementById('treatment'+iteration).value=""
											var e = eval(document.getElementById('treatment'+iteration)); 
											e.focus();
											return false;
										} 
									}  
								}
							}else{
								document.getElementById('treatment'+iteration).value = "";
							}
  					  };
		  treatment.name = 'treatment' + iteration;
		  treatment.id = 'treatment' + iteration;
		 
		  treatment.size = '110';
		  treatment.setAttribute('tabindex','1');	 
		  cellTreatment.appendChild(treatment);
		  new Ajax.Autocompleter('treatment'+iteration,'ac2update','opd?method=getTreatmentListAutoComplete',{parameters:'requiredField=treatment'+iteration});
	}
   function checkForTreatmentCode(val,inc){
		if(val != "")
		{
			var index1 = val.lastIndexOf("[");
			var indexForTreatmentCode = index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var treatmentId = val.substring(index1,index2);
			var indexForTreatmentCode = indexForTreatmentCode--;

			if(treatmentId == "" ) {
	      		document.getElementById('treatment'+inc).value="";
	      		return;
			}
			for(i=1;i<inc;i++){
				if(inc != 1){
					if(document.getElementById('treatment'+i).value==val) {
						alert("Treatment name already selected...!")
						document.getElementById('treatment'+inc).value=""
						var e=eval(document.getElementById('treatment'+inc)); 
						e.focus();
						return false;
					} 
				}  
			}
		}else{
			document.getElementById('treatment'+inc).value = "";
		}
}

</script></div>
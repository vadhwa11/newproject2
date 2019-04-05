<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">

/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>

<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript">


ddaccordion.init({
	headerclass: "expandable", //Shared CSS class name of headers group that are expandable
	contentclass: "categoryitems", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "normal", //speed of animation: "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
})
</script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">

function patientVisitPre()
{
	var visitNo =document.getElementById('visitId').value;
	var visitIdM =document.getElementById('min').value;
	if(visitNo==visitIdM)
	{
		alert("Not After Visit Number");
		//alert("Not Before Visit Number");
		return false;
	}
	return true;
	

}

function patientVisitNext()
{
	var visitId =document.getElementById('visitId').value;
	var visitIdM =document.getElementById('max').value;
	
	
	if(visitId==visitIdM)
	{
		alert("Not Before Visit Number");
		//alert("Not After Visit Number");
		return false;
	}
	return true;
	

}

</script>
<%
	Map map = new HashMap();
	String Nodata = "";
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}

	List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
	List<OpdPatientDetails> opdPatientDetailsList = new ArrayList<OpdPatientDetails>();
	PatientPrescriptionHeader patientPrescriptionHeader = null;
	PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
	List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
	List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
	List<MasEmployee> doctarsList = new ArrayList<MasEmployee>();
	Set<PatientInvestigationDetails> patientInvestigationdetails = null;
	List<MasDisposal> disposalTypeList =new ArrayList<MasDisposal>();
	OpdPatientHistory opdPatientHistory = new OpdPatientHistory();
	OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
	String complaints = "";
	String advice = "";
	String presentIllness = "";
	String pastHistory = "";
	String personalHistory = "";
	String familyHistory = "";

	DgOrderhd dgOrderhd = new DgOrderhd();
	List patientDataList = new ArrayList();
	if (map.get("opdPatientDetailsList") != null) {
		opdPatientDetailsList = (List<OpdPatientDetails>) map
				.get("opdPatientDetailsList");
	//System.out.println("opdPatientDetailsList--->"+opdPatientDetailsList);
	if(opdPatientDetailsList.size()>0 ){
		opdPatientDetails = opdPatientDetailsList.get(0);
	}
	}
	if (map.get("opdPatientHistoryList") != null) {
		opdPatientHistoryList = (List<OpdPatientHistory>) map
				.get("opdPatientHistoryList");
		if(opdPatientHistoryList.size()>0){
		opdPatientHistory = opdPatientHistoryList.get(0);
	 }
	}
	int token = 0;
	if (map.get("token") != null) {
		token = (Integer) map.get("token");
	}
	if (map.get("doctarsList") != null) {
		doctarsList = (List<MasEmployee>) map.get("doctarsList");
	}
	if (map.get("disposalTypeList") != null) {
		disposalTypeList = (List<MasDisposal>) map.get("disposalTypeList");
	}

	if (map.get("dischargeIcdCodeList") != null) {
		dischargeIcdCodeList = (List<DischargeIcdCode>) map
				.get("dischargeIcdCodeList");
	}
	if (map.get("patientPrescriptionHeader") != null) {
		patientPrescriptionHeader = (PatientPrescriptionHeader) map
				.get("patientPrescriptionHeader");
	}
	if (map.get("patientInvestigationHeader") != null) {
		patientInvestigationHeader = (PatientInvestigationHeader) map
				.get("patientInvestigationHeader");
		patientInvestigationdetails = patientInvestigationHeader
				.getPatientInvestigationDetails();
	}
	if (map.get("dgSampleCollectionDetailsList") != null) {
		dgSampleCollectionDetailsList = (List) map
				.get("dgSampleCollectionDetailsList");
	}

	if (map.get("patientDataList") != null) {
		patientDataList = (List) map.get("patientDataList");

	}

	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> mapForDS = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String consultationDate = (String) utilMap.get("currentDate");
	String consultationTime = (String) utilMap.get("currentTime");

	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	List templateList = new ArrayList();
	if (map.get("templateList") != null) {
		templateList = (List) map.get("templateList");
	}
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	if (map.get("frequencyList") != null) {
		frequencyList = (List) map.get("frequencyList");
	}
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	if (map.get("deptList") != null) {
		deptList = (List) map.get("deptList");
	}

	if (map.get("patientPrescriptionHeader") != null) {
		patientPrescriptionHeader = (PatientPrescriptionHeader) map
				.get("patientPrescriptionHeader");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Visit visit = (Visit) map.get("visit");
	String patientName = "";
	if (visit.getHin().getPFirstName() != null) {
		patientName = visit.getHin().getPFirstName();
	}
	if (visit.getHin().getPMiddleName() != null) {
		patientName = patientName + " "
				+ visit.getHin().getPMiddleName();
	}
	if (visit.getHin().getPLastName() != null) {
		patientName = patientName + " " + visit.getHin().getPLastName();
	}
	String visitDateInString = HMSUtil.changeDateToddMMyyyy(visit
			.getVisitDate());
	int deptId = visit.getDepartment()!=null?visit.getDepartment().getId():0;
	String departmentName = visit.getDepartment()!=null?visit.getDepartment().getDepartmentName():"";
	String departmentCode = visit.getDepartment()!=null?visit.getDepartment().getDepartmentCode():"";
%>
<form name="ViewScreen" action="" method="post">
<%
	if (map.get("Nodatafound") != null) {

		Nodata = (String) map.get("Nodatafound");
	}
	if (Nodata.equalsIgnoreCase("yes")) {
%> 


<div class="titleBg">
<!--main content placeholder starts here-->
<h2>Previous Visits</h2>
</div>
<div class="clear"></div>
<script type="text/javascript">
var icdArray=new Array();
</script> <!--Block One Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%
	if (visit.getHin().getRelation() != null
				&& visit.getHin().getRelation().getRelationName()
						.equalsIgnoreCase("Self")) {
%>

<label>Service No.</label>
 <%
 	if (visit.getHin().getServiceNo() != null) {
 %>
<label class="value"><%=visit.getHin().getServiceNo()%></label>
 <%
 	} else {
 %>
<label class="value"></label> <%
 	}
 %>
<label>Patient Name</label> 
<label class="value"><%=patientName%></label>
<label>Relation</label>
 <%
 	if (visit.getHin().getRelation() != null) {
 %>
<label class="value"><%=visit.getHin().getRelation()
								.getRelationName()%></label>
 <%
 	} else {
 %>
<label class="value">&nbsp;</label><%
	}
%>

<div class="clear"></div>
<label >Rank</label>
<%
	if (visit.getHin().getRank() != null) {
%>
<label class="value"><%=visit.getHin().getRank().getRankName()%></label>
<%
	} else {
%> <label class="value"></label> <%
 	}
 %>

<label>Name</label> 
<%
 	if (visit.getHin() != null) {
 				Patient patient = visit.getHin();
 				if (patient.getSFirstName() != null
 						&& !(patient.getSFirstName().equals(""))) {

 					String sMiddleName = "";
 					String sLastName = "";
 					if (patient.getSMiddleName() != null) {
 						sMiddleName = patient.getSMiddleName();
 					}
 					if (patient.getSLastName() != null) {
 						sLastName = patient.getSLastName();
 					}
 %> <label
	class="value"><%=patient.getSFirstName() + " "
									+ sMiddleName + " " + sLastName%></label> <%
 	}
 			} else {
 %> <label class="value"></label>
<%
	}
%>
<label>Trade/Branch</label>
 <%
 	if (visit.getHin().getTrade() != null) {
 %>
<label class="value"><%=visit.getHin().getTrade().getTradeName()%></label>
<%
	} else {
%> <label >  </label> <%
 	}
 %>
<div class="clear"></div>
<label>Unit</label>
 <%
 	if (visit.getHin().getUnit() != null) {
 %>
<label class="value"><%=visit.getHin().getUnit().getUnitName()%></label>
<%
	} else {
%> <label ></label> <%
 	}
 %>
<label >Age</label> 
<%
 	if (visit.getAge() != null) {
 %>
<label class="value"><%=visit.getAge()%></label> 
<%
 	} else {
 %>
<label > </label> 
<%
 	}
 %> 

 <label>Gender</label>
 <%
 	if (visit.getHin().getSex() != null) {
 %>
<label class="value"><%=visit.getHin().getSex()
								.getAdministrativeSexName()%></label>
<%
	} else {
%> <label class="value"></label> <%
 	}
 %>
 <div class="clear"></div>
<%if(visit.getHin().getRelation().getId() != 8){ %>
<label >Occupation</label> 
<%
 	if (visit.getHin().getOccupation() != null) {
 %>
<label class="value"><%=visit.getHin().getOccupation()
								.getOccupationName()%></label> 
<%
 	} else {
 %>
<label class="value"></label> 
<%
 	}}
 %> 
 
<label >Marital Status</label> 
<%
 	if (visit.getHin().getMaritalStatus() != null) {
 %>
<label class="value"><%=visit.getHin().getMaritalStatus()
								.getMaritalStatusName()%></label> 
<%
 	} else {
 %>
<label class="value"></label> 
<%
 	}
 %> 
<label >Blood Group</label>
<%
	if (visit.getHin().getBloodGroup() != null) {
%>
<label class="value"><%=visit.getHin().getBloodGroup()
								.getBloodGroupName()%></label>
<%
	} else {
%>
<label class="value"></label>  <%
 	}
 %>
<div class="clear"></div>
<label >Medical Category</label>
<%
	if (visit.getHin() != null) {
%>
<label class="value"><%="-"%></label>
<%
	} else {
%>
<label class="value"></label>  <%
 	}
 %>

<label>Date</label>
<%
	if (visit.getHin() != null) {
%>
<label class="value"><%=""%></label>
<%
	} else {
%>
<label class="value"></label>  <%
 	}
 %>
<label >Disability</label>
<%
	if (visit.getHin() != null) {
%>
<label class="value"><%="-"%></label>
<%
	} else {
%>
<label class="value"></label>  <%
 	}
 %>
 <div class="clear"></div>
 
<label >Visit No. </label> 

<%
 	if (visit.getVisitNo() != null) {
 %>
<label class="value"><%=visit.getVisitNo()%></label> 
<%
 	} else {
 %> 
<label class="value"></label>  <%
 	}
 %> 
 <%
  	} else {
  %>
  
<label>Service No.</label>
 <%
 	if (visit.getHin().getServiceNo() != null) {
 %>
<label class="value"><%=visit.getHin().getServiceNo()%></label>
 <%
 	} else {
 %>
<label class="value"></label>  <%
 	}
 %>
<label	>Patient Name</label> 
<label class="value"><%=patientName%></label>
<label>Relation</label>
 <%
 	if (visit.getHin().getRelation() != null) {
 %>
<label class="value"><%=visit.getHin().getRelation()
								.getRelationName()%></label>
 <%
 	} else {
 %>
<label class="value"></label>  <%
 	}
 %>

<div class="clear"></div>
<label >Rank</label>
<%
	if (visit.getHin().getRank() != null) {
%>
<label class="value"><%=visit.getHin().getRank().getRankName()%></label>
<%
	} else {
%> <label class="value"></label> <%
 	}
 %>
<label>Name</label>
<%
	if (visit.getHin() != null) {
				Patient patient = visit.getHin();
				if (patient.getSFirstName() != null
						&& !(patient.getSFirstName().equals(""))) {

					String sMiddleName = "";
					String sLastName = "";
					if (patient.getSMiddleName() != null) {
						sMiddleName = patient.getSMiddleName();
					}
					if (patient.getSLastName() != null) {
						sLastName = patient.getSLastName();
					}
%> <label
	class="value"><%=patient.getSFirstName() + " "
									+ sMiddleName + " " + sLastName%></label> <%
 	}
 			} else {
 %> <label class="value"></label>
<%
	}
%>
 <label>Unit</label>
 <%
 	if (visit.getHin().getUnit() != null) {
 %>
<label class="value"><%=visit.getHin().getUnit().getUnitName()%></label>
<%
	} else {
%> <label class="value"></label>  <%
 	}
 %>
 <div class="clear"></div>
<label>Trade/Branch</label>
 <%
 	if (visit.getHin().getTrade() != null) {
 %>
<label class="value"><%=visit.getHin().getTrade().getTradeName()%></label>
<%
	} else {
%> <label class="value"></label>  <%
 	}
 %>

<label >Age</label> 
<%
 	if (visit.getAge() != null) {
 %>
<label class="value"><%=visit.getAge()%></label> 
<%
 	} else {
 %>
<label class="value"></label> 
<%
 	}
 %> 
 <label>Gender</label>
 <%
 	if (visit.getHin().getSex() != null) {
 %>
<label class="value"><%=visit.getHin().getSex()
								.getAdministrativeSexName()%></label>
<%
	} else {
%> <label class="value"></label> <%
 	}
 %>
 
  <div class="clear"></div>
<label >Occupation</label> 
<%
 	if (visit.getHin().getOccupation() != null) {
 %>
<label class="value"><%=visit.getHin().getOccupation()
								.getOccupationName()%></label> 
<%
 	} else {
 %>
<label class="value"></label> 
<%
 	}
 %> 
 
<label >Marital Status</label> 
<%
 	if (visit.getHin().getMaritalStatus() != null) {
 %>
<label class="value"><%=visit.getHin().getMaritalStatus()
								.getMaritalStatusName()%></label> 
<%
 	} else {
 %>
<label class="value"></label> 
<%
 	}
 %> 

<label >Blood Group</label>
<%
	if (visit.getHin().getBloodGroup() != null) {
%>
<label class="value"><%=visit.getHin().getBloodGroup()
								.getBloodGroupName()%></label>
<%
	} else {
%>
<label class="value"></label> <%
 	}
 %>
<div class="clear"></div>
<%--
<label >Allergico</label>
<%if(visit.getHin() != null){ %>
<label class="value"><%="-" %></label>
<%}else{ %>
<label ></label> <%} %>
 <div class="clear"></div> --%>
<label >Visit No. </label> 

<%
 	if (visit.getVisitNo() != null) {
 %>
<label class="value"><%=visit.getVisitNo()%></label> 
<%
 	} else {
 %> 
<label class="value"></label>  <%
 	}
 %> 

<%
 	}
 %>
<div class="clear"></div>
</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label>Main Complaint</label>
<select id="mainCompId" name="mainCompId" validate="Main Complaint,string,no" tabindex="1">
<%if(opdPatientDetails != null && opdPatientDetails.getDMainComplaint() != null){ %>
	<option value="">Select</option>
	<option value="<%=opdPatientDetails.getDMainComplaint()%>" selected="selected"><%=opdPatientDetails.getDMainComplaint()%></option>
	
<%} %>
</select>

<label >Since</label>
<%if(opdPatientDetails != null && opdPatientDetails.getDSince1() != null){ %>
<input tabindex="1"	type="text"  name="since" class="small" value="" onKeyUp="isNumber(this)" maxlength="2" />
<%} %>
<select id="sinceUnit" name="sinceUnit" class="small"	validate="Since,string,no" tabindex="1">
	<option value="0">Select</option>
    <option value="Days">Days</option>
    <option value="Weeks">Weeks</option>
    <option value="Months">Months</option>
    <option value="Year">Year</option>
</select>
<div class="clear"></div>
<label>Remarks</label>
<%if(opdPatientDetails != null && opdPatientDetails.getDRemarks1() != null){ %>
<input type="text" name="sinceRemarks" value="<%=opdPatientDetails.getDRemarks1() %>" tabindex="1" id="sinceRemarks" validate="Remarks,string,no" class="large" maxlength="40"/>
<%} %>
<div class="clear"></div>
<label>Associated Complaint</label>
<select id="associatedComplaint" name="associatedComplaint" validate="Associated Complaint,string,no" tabindex="1">
	<option value="">Select</option>
	<%if(opdPatientDetails != null && opdPatientDetails.getDAssociatedComplaint() != null){ %>
 <option value="<%=opdPatientDetails.getDAssociatedComplaint()%>" selected="selected"><%=opdPatientDetails.getDAssociatedComplaint()%></option>
   <%} %>

</select>
<label >Since</label>
<input tabindex="1"	type="text"   name="associatedSince" class="small" value=""	onKeyUp="isNumber(this)" maxlength="2" />
	<select id="associatedSinceUnit" name="associatedSinceUnit"	validate="Since,string,no" tabindex="1" class="small">
	<option value="0">Select</option>
    <option value="Days">Days</option>
    <option value="Weeks">Weeks</option>
    <option value="Months">Months</option>
    <option value="Year">Year</option>
</select>
<div class="clear"></div>
<label>Remarks</label>
	<%if(opdPatientDetails != null && opdPatientDetails.getDRemarks2() != null){ %>
<input type="text" name="associatedRemarks" tabindex="1" id="associatedRemarks" validate="Remarks,string,no" class="large" maxlength="40"/>
<%} %>
<div class="clear"></div>
<label>Complaint Description</label>
<%
 	if (opdPatientHistory != null && opdPatientHistory.getPresentComplain() != null) {
 %> 
<textarea name="complaintDescriptions" id="complaintDescriptions" cols="20" rows="2" tabindex="1" maxlength="999"
	validate="Complaint Descriptions,string,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=opdPatientHistory.getPresentComplain()%></textarea>
	<%}else{ %>
	<textarea name="complaintDescriptions" id="complaintDescriptions" cols="20" rows="2" tabindex="1" maxlength="999"
	validate="Complaint Descriptions,string,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
	<%} %>
<div class="clear"></div>
</div>

<div class="clear paddingTop15"></div>
<div class="clear"></div>

<h4>Oral Health Condition And Findings</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label >Total No. of Teeth</label>
<%if(opdPatientDetails != null && opdPatientDetails.getNoOfTeeth() != null){ %>
 <input tabindex="1"	type="text"   name="<%=TOTAL_NO_OF_TEETH %>" class="small" value="<%=opdPatientDetails.getNoOfTeeth() %>" onKeyUp="isNumber(this)" maxlength="2" />
 <%}else{ %>
  <input tabindex="1"	type="text"   name="<%=TOTAL_NO_OF_TEETH %>" class="small" value="" onKeyUp="isNumber(this)" maxlength="2" />
 
 <%} %>
<label class="medium3">Total No. of Defective Teeth</label>
<%if(opdPatientDetails != null && opdPatientDetails.getNoOfDefectiveTeeth() != null){ %>
<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" value="<%=opdPatientDetails.getNoOfDefectiveTeeth() %>" onKeyUp="isNumber(this)" maxlength="2" />
<%}else{ %>
<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" value="" onKeyUp="isNumber(this)" maxlength="2" />

<%} %>
<label class="medium3">Total no. of Dental Points</label>
<%if(opdPatientDetails != null && opdPatientDetails.getNoOfDentalPoints() != null){ %>
<input tabindex="1"	type="text"   name="dentalPoints"  class="small" value="<%=opdPatientDetails.getNoOfDentalPoints() %>" onKeyUp="isNumber(this)" maxlength="2" />
<%}else{ %>
<input tabindex="1"	type="text"   name="dentalPoints"  class="small" value="" onKeyUp="isNumber(this)" maxlength="2" />

<%} %>
<div class="clear"></div>
<label >Missing </label>
<%if(opdPatientDetails != null && opdPatientDetails.getMissingTeeth() != null){ %>
<input tabindex="1"	type="text"   name="missingTeeth" class="small" value="<%=opdPatientDetails.getMissingTeeth() %>" onKeyUp="isNumber(this)" maxlength="2" />
<%}else{ %>
<input tabindex="1"	type="text"   name="missingTeeth" class="small" value="" onKeyUp="isNumber(this)" maxlength="2" />
<%} %>
<label class="medium3">Unsaveable</label>
<%if(opdPatientDetails != null && opdPatientDetails.getUnSaveableTeeth() != null){ %>
<input tabindex="1"	type="text"   name="unsaveableTeeth" class="small" value="<%=opdPatientDetails.getUnSaveableTeeth() %>" onKeyUp="isNumber(this)" maxlength="2" />
<%}else{ %>
<input tabindex="1"	type="text"   name="unsaveableTeeth" class="small" value="" onKeyUp="isNumber(this)" maxlength="2" />
<%} %>
 <label class="medium3">Condition of Gums</label>
 <%if(opdPatientDetails != null && opdPatientDetails.getConditionOfGums() != null){ %>
<input tabindex="1"	type="text"   name="conditionOfGums" id="txtAlpha" class="small" value="<%=opdPatientDetails.getConditionOfGums() %>" validate="Condition of Gums,alphaspace,no" maxlength="100" />
<%}else{ %>
<input tabindex="1"	type="text"   name="conditionOfGums" id="txtAlpha" class="small" value="" validate="Condition of Gums,alphaspace,no" maxlength="100" />
<%} %>
</div>


 <div class="clear paddingTop15"></div>
<h4>Diagnosis</h4>
<div class="Block">
<input type="hidden" id="onExamination" class="large"	name="onExamination" maxlength="200" />
<input name="" value="" id="temp" type="hidden" />
<input type="hidden"	name="ageName" value="<%=visit.getHin().getAge()%>" id="ageId" />
<label>System Diagnosis</label>
<%if(opdPatientDetails != null && opdPatientDetails.getSystemDiagnosis()!= null){ %>
<input name="" value="<%=opdPatientDetails.getSystemDiagnosis().getSystemDiagnosisName() %>"	id="systemDiagnosis" tabindex="1" class="auto" size="117" />
<%}else{ %>
<input name="" value=""	id="systemDiagnosis" tabindex="1" class="auto" size="117" />
<%} %>
<div class="clear"></div>
<label>Working Diagnosis </label>
 <%
 	if (opdPatientDetails != null && opdPatientDetails.getInitialDiagnosis() != null) {
 %>
 <input	type="text" id="initialDiagnosis" class="auto" size="69"	value="<%=opdPatientDetails.getInitialDiagnosis()%>"	name="initialDiagnosis" maxlength="100" />
 <%
 	} else {
 %>
 <input	type="text" id="initialDiagnosis"  class="auto" size="69" name="initialDiagnosis" maxlength="100" />
 <%
 	}
 %>
 <div class="clear"></div>
 <label>ICD Diagnosis</label>
<input type="text" tabindex="1"	value="" id="icd"  name="icd"	class="auto"  size="55" readonly="readonly"/>
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
		</script>
<select name="<%=DIAGNOSIS_ID%>" multiple="4" size="5"	id="diagnosisId" class="listBig">
	<option value="0">Select</option>
	<%
		for (DischargeIcdCode dischargeIcdCode : dischargeIcdCodeList) {
	%>
	<option value="<%=dischargeIcdCode.getIcd().getIcdCode()%>" selected="selected"><%=dischargeIcdCode.getIcd().getIcdName()%>[<%=dischargeIcdCode.getIcd().getIcdCode()%>]</option>
	<%
		}
	%>
</select>

</div>
<%
	int inc = 1;
		if (patientInvestigationdetails != null
				&& patientInvestigationdetails.size() > 0) {
%>
<%
	for (PatientInvestigationDetails patientInvestigationdetail : patientInvestigationdetails) {
				String investigationName = "";
				investigationName = patientInvestigationdetail
						.getChargeCode().getChargeCodeName()
						+ "["
						+ patientInvestigationdetail.getChargeCode()
								.getId() + "]";
%>
<input type="hidden"	value="<%=patientInvestigationdetail.getId()%>"	name="dgSampleCollectionDetailsId" id="dgSampleCollectionDetailsId" />
 <%
 	}
 %>
<div class="clear paddingTop15"></div>
<h4>Investigation</h4>
<div class="clear"></div>
<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Investigation Name</th>
		<th scope="col">Refer to MH</th>
	</tr>
	<%
		inc = 1;
				
				for (PatientInvestigationDetails patientInvestigation : patientInvestigationdetails) {
					String investigationName = "";
					investigationName = patientInvestigation
							.getChargeCode().getChargeCodeName()
							+ "["
							+ patientInvestigation.getChargeCode().getId()
							+ "]";
	%>
	<tr>
		<td><input type="text" value="<%=investigationName%>"
			readonly="readonly" readonly="readonly" tabindex="2"
			id="chargeCodeName<%=inc%>" size="180" name="chargeCodeName<%=inc%>" />
			
			<%
			if(patientInvestigation.getReferToMh() != null && !patientInvestigation.getReferToMh().equals("")  && patientInvestigation.getReferToMh().equals("y") ){ %>
		<td><input type="checkbox" name="referToMh1" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio" checked="checked" validate="Refer to MH,string,no" /></td>
		<%}else{ %>
		<td><input type="checkbox" name="referToMh1" tabindex="1" id="referToMhId<%=inc%>" value="n" class="radio"  validate="Refer to MH,string,no" /></td>
		<%} %>
	</tr>
	<%
		inc++;
				}
	%>

</table>
<div class="clear paddingTop15"></div>
<table id="clinicalNoteTable" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">Clinical Notes</th>
	</tr>
	<%
		if (patientInvestigationHeader.getClinicalNotes() != null) {
	%>
	<tr>
		<td><input type="text" name="clinicalNotes1" readonly="readonly"
			value="<%=patientInvestigationHeader
										.getClinicalNotes()%>"
			tabindex="1" size="180" /></td>
		<%
			} else {
		%>
		<td><input type="text" name="clinicalNotes1" readonly="readonly"
			value="<%=""%>" tabindex="1" size="180" /></td>
	</tr>
	<%
		}
	%>


</table>


<div class="clear"></div>

</div>
<%
	} else {
%>
<div class="clear"></div>
<h4>Investigation</h4>
<div class="clear"></div>
<div id="gridview">
<table>
	<tr>
		<th scope="col">Clinical Notes</th>
</tr>

<tr>
		<td><input type="text" name="clinicalNotes1" tabindex="1"
			readonly="readonly" size="180" maxlength="45" /></td>
	</tr>
</table>
<div class="clear paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Investigation Name</th>
		<th scope="col">Refer to MH</th>
	</tr>



	<tr>
		<td><input type="text" value="" tabindex="2" id="chargeCodeName1"
			readonly="readonly" size="180" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc%>')){checkForChargeCode(this.value,'<%=inc%>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter(document.getElementById('chargeCodeName<%=inc%>'),'ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
			</script></td>
		<td><input type="checkbox" name="referToMh1" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td>

	</tr>
</table>
<div class="clear"></div>
</div>
<%
	}
%> <input type="hidden" value="<%=inc%>" name="hiddenValue"
	id="hiddenValue" />




<%
	if (patientPrescriptionHeader != null) {
			//System.out.println("this is if");
%>
<div class="clear paddingTop15"></div>
<h4>Treatment</h4>
<div class="Clear"></div>
<div id="testDivDrug">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid">
	<tr>
		<th colspan="col">PVMS/NIV Nomenclature</th>
		
		<!--  <th scope="col">PVMS No.</th>-->
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<!--  <th scope="col">Intake</th>-->
		<!-- <th scope="col">Type</th> -->
		<th scope="col">Remarks</th>

	</tr>


	<%
		int inc1 = 1;
				if (patientPrescriptionHeader
						.getPatientPrescriptionDetails() != null) {
					for (PatientPrescriptionDetails patientPrescriptionDetails : patientPrescriptionHeader
							.getPatientPrescriptionDetails()) {
	%>
	<tr>
		<td>
		<%
			MasStoreItem item = patientPrescriptionDetails
									.getItem();
							String itemName1 = item.getNomenclature() + "["
									+ item.getPvmsNo() + "]";
							String pvmsNo = "";
							pvmsNo = item.getPvmsNo();

							String dosage = patientPrescriptionDetails
									.getDosage();
							int noOfDays = patientPrescriptionDetails
									.getNoOfDays();
							int total = patientPrescriptionDetails.getTotal();
							String type = patientPrescriptionDetails.getType();
							int frequencyId = patientPrescriptionDetails
									.getFrequency().getId();
							String instruction = patientPrescriptionDetails
									.getInstruction();
							String remark = patientPrescriptionDetails
									.getRemarks();
		%> 
	    
			<input type="text" tabindex="1"	id="nomenclature1" readonly="readonly" value="<%=itemName1%>"
			size="50" name="nomenclature<%=inc%>" /></td>
	

		
		<td>
		<input type="hidden" name="pvmsNo<%=inc%>"
			id="pvmsNo<%=inc%>" value="<%=pvmsNo%>" size="10"
			readonly="readonly" />
			<input type="text" name="dosage<%=inc%>" readonly="readonly"
			id="dosage<%=inc%>" value="<%=dosage%>" size="10" tabindex="1" /></td>
		<td><select name="frequency<%=inc%>" id="frequency<%=inc%>" disabled="disabled"
			tabindex="1">
			<option value="0">Select</option>
			<%
				for (MasFrequency masFrequency : frequencyList) {
									int id = masFrequency.getId();
									String name = masFrequency.getFrequencyName();
			%>

			<option value="<%=id%>" <%=HMSUtil.isSelected(id, frequencyId)%>><%=name%></option>
			<%
				}
			%>
		</select> <%
 	MasFrequency masFrequency = new MasFrequency();

 					for (int i = 0; i < frequencyList.size(); i++) {
 						masFrequency = (MasFrequency) frequencyList
 								.get(i);
 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <%
 	}
 %>
		</td>
        <%
        	if (patientPrescriptionDetails.getNoOfDays() != null) {
        %>
		<td><input type="text" name="noOfDays<%=inc%>" size="8"
			tabindex="1" id="noOfDays<%=inc%>" value="<%=noOfDays%>"
			readonly="readonly" /></td>
		<%
			} else {
		%>
		<td><input type="text" name="noOfDays<%=inc%>" size="8"
			tabindex="1" id="noOfDays<%=inc%>" value=""
			readonly="readonly" /></td>
		<%
			}
		%>
		
		<%-- 
		 <%
		 	if (patientPrescriptionDetails.getInstruction() != null) {
		 %>
		<td><select name="instructionACPC1" id="instructionACPC1" disabled="disabled"
			tabindex="1">
			<option value="<%=instruction%>"><%=instruction%></option>
		</select></td>
		<%
			} else {
		%>
		
		<td><select name="instructionACPC1" id="instructionACPC1" disabled="disabled"
			tabindex="1">
			<option value=""></option>
		</select></td>
		<%
			}
		%> --%>
		 		 <%
		 		 	if (patientPrescriptionDetails.getRemarks() != null) {
		 		 %>
		<td><input type="text" name="remarks1" tabindex="1" id="remarks1" 
			value=<%=remark%> class="small" readonly="readonly" /></td>
			<%
				} else {
			%>
			<td><input type="text" name="remarks1" tabindex="1" id="remarks1" 
			value="" class="small" readonly="readonly" /></td>
			<%
				}
			%>
	</tr>
	<%
		inc1++;
					}
				}
	%>
	<input type="hidden" name="hdb" value="<%=inc - 1%>" id="hdb" />


</table>
<div class="Clear"></div>


</div>
<%
	} else {
			//System.out.println("this is else");
%>
<div class="clear paddingTop15"></div>


<h4>Treatment</h4>
<div class="Clear"></div>
<div id="testDivDrug">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid">
	<tr>
		<th colspan="col">Nomenclature</th>
		<th scope="col">PVMS No.</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">Total</th>
		<!-- <th scope="col">Type</th> -->
		<th scope="col">remark</th>
	</tr>
	<tr>
		
		<td><input type="text" value="" size="50" tabindex="1"
			id="nomenclature1" name="nomenclature1" readonly="readonly" /></td>
		
		<td><input type="text" name="pvmsNo1" id="pvmsNo1" size="10"
			readonly="readonly" /></td>
		<td><input type="text" name="dosage1" id="dosage1" tabindex="1"
			size="10" readonly="readonly" /></td>
		<td><select name="frequency1" id="frequency1" disabled="disabled"  tabindex="1" >
			<option value="0">Select</option>
			
		</td>

		<td><input type="text" name="noOfDays1" tabindex="1" readonly="readonly"
			id="noOfDays1" size="5" /></td>
		<td><input type="text" name="total1" id="total1"
			readonly="readonly" size="8" /></td>
		
        <td><input type="text" name="remarks1" tabindex="1" id="remarks1"
			value="" class="small" readonly="readonly" /></td>
		<input type="hidden" name="hdb" value="1" id="hdb" />
	</tr>

</table>
<div class="Clear"></div>
</div>


<%
	}
%>
<div class="clear paddingTop15"></div>
<h4>Advice</h4>
<div class="clear"></div>
<div class="Block">
<label>Additional Advice</label> <%
 	if (opdPatientHistory != null && opdPatientHistory.getPresentAdvice() != null) {
 %>
<textarea name="presentAdvice" class="auto" cols="50" readonly="readonly"><%=opdPatientHistory.getPresentAdvice()%></textarea>
<%
	} else {
%> <textarea name="presentAdvice" class="auto" cols="50"
	readonly="readonly"></textarea> <%
 	}
 %> <label>Referred To </label>
	 <select name="referredDepartmentId" multiple="4" size="3" disabled="disabled"	id="referredDepartmentId" onclick="getDoctorList();" class="listBig">
	<option value="0">Select</option>
	<%
		//System.out.println("dept List Size :"+deptList.size());
			Iterator itr2 = deptList.iterator();
			while (itr2.hasNext()) {
				MasDepartment masDepartment = (MasDepartment) itr2.next();
				int departmentId = masDepartment.getId();
				String deptName = masDepartment.getDepartmentName();
	%>
	<option value="<%=departmentId%>"><%=deptName%></option>
	<%
		}
	%>
</select>
<%
	String reffredArray1[];
		int len = 0;
		int y = 0;

		if (opdPatientDetails.getReferredDept() != null
				&& opdPatientDetails.getReferredDept().contains(",")) {
			reffredArray1 = opdPatientDetails.getReferredDept().split(
					",");
			len = reffredArray1.length;
		} else {
			reffredArray1 = new String[1];
			len = 1;
			reffredArray1[0] = opdPatientDetails.getReferredDept();
		}

		int refferedCounter = 0;
		for (String reffredDept : reffredArray1) {
%> <input type="hidden"
	name="selectedReferredDepartmentId" multiple="4" size="3"
	value="<%=reffredDept%>"
	id="selectedReferredDepartmentId<%=refferedCounter%>" /> <%
 	refferedCounter++;
 		}
 %> <script type="text/javascript">
	var x=0;
	var y1 = 0;
	var reffredArray= new Array(<%=reffredArray1.length%>);
	if(document.getElementById('selectedReferredDepartmentId'+y1) != null){
		while(x<<%=len%>){
			reffredArray[x]=document.getElementById('selectedReferredDepartmentId'+y1).value;
			x++;y1++;
		}
	}
	obj = document.getElementById("referredDepartmentId");
	var m=0;
	for ( m=0; m <(obj.options.length); m++ )
	{
		for(x=0;x<<%=len%>;x++)
		{
			if(reffredArray[x]==obj.options[m].value)
			{
				obj.options[m].selected=true
			}
		}

	}


</script>
<div class="clear"></div>
<label>Referred To MH</label>
<%
	if(opdPatientDetails != null && opdPatientDetails.getMhRun()!=null)
	{
		if(opdPatientDetails.getMhRun().equalsIgnoreCase("y")){
			%>
			<input type="checkbox" name="referedToMH" class="radio" id="referedToMH" value="y" checked="checked" readonly="readonly"/>	
			<%
		}else{
			%>
			<input type="checkbox" name="referedToMH" class="radio" id="referedToMH" readonly="readonly"/>
			<%
		}
	}else{
%>
		<input type="checkbox" name="referedToMH" class="radio" id="referedToMH" readonly="readonly"/>
<%} %>
<%
if(opdPatientDetails != null && opdPatientDetails.getMhRun()!=null){
if(opdPatientDetails.getMhRun().equalsIgnoreCase("y")){ %>
<label>MH</label>
<%if(opdPatientDetails.getMh()!= null){ %>
<input name="mh" type="text" tabindex="1" value="<%=opdPatientDetails.getMh()%>" maxlength="32" id="mh" size="20"  />
<%}else{ %>
<input name="mh" type="text" tabindex="1" value="" maxlength="32" id="mh" size="20"  />
<%} %>
<label>Department</label>
<%if(opdPatientDetails != null && opdPatientDetails.getMhDepartment() != null){ %>
<input name="mhDepartment" type="text" tabindex="1" value="<%=opdPatientDetails.getMhDepartment() %>" maxlength="32" id="mhDepartment" size="20"  />
<%}else{ %>
<input name="mhDepartment" type="text" tabindex="1" maxlength="32" id="mhDepartment" size="20"  />
<%} %>
<div class="clear"></div>
<%if(opdPatientDetails != null && opdPatientDetails.getMhReferredFor() != null){ %>
<label>Referred For</label>
<input name="mhReferredFor" type="text" value="<%=opdPatientDetails.getMhReferredFor() %>" tabindex="1" maxlength="50" id="mhReferredFor" size="20"  />
<%}else{ %>
<input name="mhReferredFor" type="text" tabindex="1" maxlength="50" id="mhReferredFor" size="20"  />
<%} %>
<%} }%>
<input size="23" class="transparent">
<label>Disposal</label> 
<select name="disposal" id="disposal" size="0" disabled="disabled" >
	<option>select</option>
	<% 
			for(MasDisposal masDisposalType : disposalTypeList){
				if(masDisposalType.getDisposalName().equals(visit.getDisposalName())){
		%>
	<option value="<%=masDisposalType.getDisposalName() %>"  selected="selected"><%=masDisposalType.getDisposalName() %></option>
	<%}else{%>
		<option value="<%=masDisposalType.getDisposalName() %>" ><%=masDisposalType.getDisposalName() %></option>
	
	<%} }%>
</select>
 <script type="text/javascript">
    	<%if (opdPatientDetails.getDisposal() != null) {%>
    		document.getElementById('disposal').value='<%=opdPatientDetails.getDisposal()%>';
    	<%}%>
</script>
<div class="clear"></div>
 <label>Days</label> 
<%
 	if (opdPatientDetails != null && opdPatientDetails.getDays() != null) {
 %>

<input name="days" type="text" class="small" size="48" value="<%=opdPatientDetails.getDays()%>" readonly="readonly" tabindex="1" maxlength="2" />

</div>
<%
	} else {
%>
<input name="days" type="text" class="auto" size="48" readonly="readonly" tabindex="1" value="" maxlength="2" /></div>
<%
	}
%>
<%--<div class="Block">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

	<tr>
		 <td><a href="javascript:openPopupProcedureAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)"> Procedure Advice</a></td>
		<td><a href="javascript:openPopupDetentionAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)"> Detention Advice</a></td>
		<td><a href="javascript:openPopupPhysiotheraphyAdviceWindow(<%=visit.getId() %>,<%=visit.getHin().getId() %>,<%=visit.getDoctor().getId() %>)">  Physiotherapy Advice</a></td>
</tr>
</table>
</div>
 --%>
<div class="division"></div>
<%-- <input type="button" class="button" value="Previous" onclick="showPreviousVisit(<%=visit.getVisitNo()%>);"  />
<input type="button" class="button" value="Next" align="right" onclick="showNextVisit();"
	align="right" />--%>
<input name="Back" type="button" alt="Back" value="Back" class="button" onclick="goBack()" />
<%--
<input type="hidden" name="serviceNoForReport" id="serviceNoForReport"	value="<%=visit.getHin().getServiceNo()%>" />
<input type="hidden" name="visitNumberForReport"	id="visitNumberForReport" value="<%=visit.getVisitNo()%>" />
<input type="hidden"	name="hinNoForReport" id="hinNoForReport" value="<%=visit.getHin().getHinNo()%>" />
 --%>
<input type="button" name="printReport" id="print" 	onclick="submitFormForPrescriptionReportNew(<%=visit.getHin().getServiceNo()%>,<%=visit.getVisitNo()%>,<%=visit.getHin().getHinNo()%>);" value="Case Sheet"	class="buttonBig" accesskey="a" /> 
<%--
<input type="button" name="printButton" onclick="submitFormForPrescriptionReport(<%=visit.getHin().getServiceNo()%>,<%=visit.getVisitNo()%>,<%=visit.getHin().getHinNo()%>);" value="Case Sheet"	class="buttonBig" accesskey="a" />
 --%>
<div class="clear"></div>
<div class="division"></div> 
<%
 	} else {
 %>
<div class="clear"></div>
<h4>No Visit Found</h4>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Previous"
	onclick="showPreviousVisit(<%=visit.getVisitNo()%>);" /> 
<input name="Back" type="button" alt="Back" value="Back" class="button" onclick="goBack()" />

<div class="clear"></div>
<div class="division"></div>
<%
	}
%> <input name="consultationDate" type="hidden"
	value="<%=consultationDate%>" /> <input name="consultationTime"
	type="hidden" value="<%=consultationTime%>" />




</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
function goBack(){
	
	document.ViewScreen.action="opd?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&deptId=<%=visit.getDepartment()!=null?visit.getDepartment().getId():0%>&<%=HIN_ID%>=<%=visit.getHin().getId()%>&token=<%=token%>";
  document.ViewScreen.submit();

} 
function showPreviousVisit(visitNo){
	if(visitNo >=1){
		document.ViewScreen.action="/hms/hms/opd?method=getPatientOpdDetails&flag=prev&hinId=<%=visit.getHin().getId()%>&deptId=<%=visit.getDepartment()!=null?visit.getDepartment().getId():0%>&visitNumber=<%=visit.getVisitNo()%>&token=<%=token%>";
		  document.ViewScreen.submit();
	}else{
	          alert("This Is Patient's first Visit.")
	      } 
  

}
function showNextVisit(){
	 
document.ViewScreen.action="/hms/hms/opd?method=getPatientOpdDetails&flag=next&hinId=<%=visit.getHin().getId()%>&deptId=<%=visit.getDepartment()!=null?visit.getDepartment().getId():0%>&visitNumber=<%=visit.getVisitNo()%>&token=<%=token%>";
document.ViewScreen.submit();

}
function openPopupProcedureAdviceWindow(visitId,hinId,doctorId)
{
 var url="/hms/hms/opd?method=showProcedureListJsp&visitId="+visitId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=";
 newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
}
function openPopupDetentionAdviceWindow(visitId,hinId,doctorId)
{
 var url="/hms/hms/opd?method=showDetentionListJsp&visitId="+visitId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=";
 newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
	 //alert("Detention Advice ....");
}
function openPopupPhysiotheraphyAdviceWindow()
{
 //var url="/hms/hms/opd?method=showProcedureListJsp&visitId="+visitId;
 //newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	 alert("Physiotheraphy Advice ....");
}

function submitFormForPrescriptionReportNew(serviceNo,visitNo,hinNo){
	var url="/hms/hms/opd?method=opdMedicalCaseSheetPrint&serviceNoForReport="+serviceNo+"&visitNumberForReport="+visitNo+"&hinNoForReport="+hinNo;
	 newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
	
}
function submitFormForPrescriptionReport(serviceNo,visitNo,hinNo){
	//submitForm('ViewScreen','/hms/hms/opd?method=opdMedicalCaseSheetPrint');
	
		 
	//document.ViewScreen.action="/hms/hms/opd?method=opdMedicalCaseSheetPrint";
	//document.ViewScreen.submit();
}
	
</script>

<!--main content placeholder ends here-->




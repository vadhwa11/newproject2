<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
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
<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
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
<script type="text/javascript">
function back() {
window.close();
return;

}
</script>
<%
	
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");	 
	String currentTime = (String)utilMap.get("currentTime");

	List<OtPreAnesthesiaDetails> otPreAnesthesiaDetailsList = new ArrayList<OtPreAnesthesiaDetails>();
	
	if(map.get("otPreAnesthesiaDetailsList") != null){
		otPreAnesthesiaDetailsList=(List<OtPreAnesthesiaDetails>)map.get("otPreAnesthesiaDetailsList");
	}	

	List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
	
	if(map.get("opdPatientHistoryList") != null){
		opdPatientHistoryList=(List<OpdPatientHistory>)map.get("opdPatientHistoryList");
	}	
	
	if(otPreAnesthesiaDetailsList.size() > 0){
		
		for (Iterator iter = otPreAnesthesiaDetailsList.iterator(); iter.hasNext();) {
			OtPreAnesthesiaDetails otPreAnesthesiaDetails = (OtPreAnesthesiaDetails) iter.next();
			
		String patientName="";
		if(otPreAnesthesiaDetails.getHin().getPFirstName()!= null){
			patientName=otPreAnesthesiaDetails.getHin().getPFirstName();
		}
		if(otPreAnesthesiaDetails.getHin().getPMiddleName()!= null){
			patientName=patientName+" "+otPreAnesthesiaDetails.getHin().getPMiddleName();
		}
		if(otPreAnesthesiaDetails.getHin().getPLastName()!= null){
			patientName=patientName+" "+otPreAnesthesiaDetails.getHin().getPLastName();
		}
		String servicePersonName="";
		if(otPreAnesthesiaDetails.getHin().getSFirstName()!= null){
			servicePersonName=otPreAnesthesiaDetails.getHin().getSFirstName();
		}
		if(otPreAnesthesiaDetails.getHin().getSMiddleName()!= null){
			servicePersonName=servicePersonName+" "+otPreAnesthesiaDetails.getHin().getSMiddleName();
		}
		if(otPreAnesthesiaDetails.getHin().getSLastName()!= null){
			servicePersonName=servicePersonName+" "+otPreAnesthesiaDetails.getHin().getSLastName();
		}
		
		
		
		
	%>


<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="preAnesthesia" method="post" action="">
<h6>Pre-Anesthesia Form</h6>
<div class="Clear"></div>
<div class="header"><label>Order Number</label> <label
	class="value"><%=otPreAnesthesiaDetails.getOrderNo() %></label> <label>Date</label>
<label class="value"><%=currentDate %></label></div>
<div class="Clear"></div>
<!--Block One Starts-->
<div class="blockTitle">Serving Personal Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service </label> <%if(otPreAnesthesiaDetails.getHin().getServiceType()!= null){ %>
<label class="valuemedium"><%=otPreAnesthesiaDetails.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Service No.</label> <%if(otPreAnesthesiaDetails.getHin().getServiceNo()!= null){ %>
<label class="valuemedium"><%=otPreAnesthesiaDetails.getHin().getServiceNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium"> Serv. Status </label> <%if(otPreAnesthesiaDetails.getHin().getServiceStatus()!= null){ %>
<label class="valuemedium"><%=otPreAnesthesiaDetails.getHin().getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Name</label> <%if(servicePersonName != null){ %> <label
	class="valuemedium" style="width: auto;"><%=servicePersonName %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<label class="medium">Relation</label> <%if(otPreAnesthesiaDetails.getHin().getRelation() != null){ %>
<label class="valuemedium"><%=otPreAnesthesiaDetails.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Rank</label> <%if(otPreAnesthesiaDetails.getHin().getRank()!= null){ %>
<label class="valuemedium"><%=otPreAnesthesiaDetails.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit</label> <%if(otPreAnesthesiaDetails.getHin().getUnit()!= null){ %>
<label class="valuemedium"><%=otPreAnesthesiaDetails.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit Address</label> <% if(otPreAnesthesiaDetails.getHin().getUnit()!= null){%>
<label class="valuemedium"><%=otPreAnesthesiaDetails.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>
<label class="medium">Telephone No</label> <% if(otPreAnesthesiaDetails.getHin().getMobileNumber()!= null && !otPreAnesthesiaDetails.getHin().getMobileNumber().equals("")){%>
<label class="valuemedium"><%=otPreAnesthesiaDetails.getHin().getMobileNumber() %></label>
<%}else{ %> <label class="valuemedium">---</label> <%} %>

<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label class="medium">HIN No.</label> <%if(otPreAnesthesiaDetails.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=otPreAnesthesiaDetails.getHin().getHinNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Patient Name </label> <%if(patientName!= null){ %> <label
	class="valuemedium" style="width: auto;"><%=patientName %> </label> <%}else{ %>
<label class="valuemedium">- </label> <%} %> <label class="medium">Age</label>
<%if(otPreAnesthesiaDetails.getHin().getAge()!= null){ %> <label
	class="valuemedium"><%=otPreAnesthesiaDetails.getHin().getAge() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>


<div class="Clear"></div>

<label class="medium">Patient Type </label> <%if(otPreAnesthesiaDetails.getHin().getPatientStatus()!= null){ %>
<label class="valuemedium"><%=otPreAnesthesiaDetails.getHin().getPatientStatus() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%}
	  if(otPreAnesthesiaDetails.getHin().getPatientStatus().equalsIgnoreCase("Out Patient")){
	%> <label class="medium">Visit No. </label> <%if(otPreAnesthesiaDetails.getVisit()!= null){ %>
<label class="valuemedium"><%=otPreAnesthesiaDetails.getVisit().getVisitNo() %></label>
<input name="visitId" type="hidden"
	value="<%=otPreAnesthesiaDetails.getVisit().getId() %>" /> <%}else{ %> <label
	class="valuemedium">-</label> <%}
	  }else{	
	%> <label class="medium">Admission No. </label> <%if(otPreAnesthesiaDetails.getInpatient()!= null){ %>
<label class="valuemedium"><%=otPreAnesthesiaDetails.getInpatient().getAdNo() %></label>
<input name="inPatientId" type="hidden"
	value="<%=otPreAnesthesiaDetails.getInpatient().getId() %>" /> <%}else{ %>
<label class="valuemedium">-</label> <%}} %> <label class="medium">ECHS
No. </label> <%if(otPreAnesthesiaDetails.getHin().getEchsNo()!= null){ %> <label
	class="valuemedium"><%=otPreAnesthesiaDetails.getHin().getEchsNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

</div>
<div class="division"></div>
<!--Block one Ends--> <% if(opdPatientHistoryList.size() > 0){
		for (Iterator iter1 = opdPatientHistoryList.iterator(); iter1.hasNext();) {
			OpdPatientHistory opdPatientHistory = (OpdPatientHistory) iter1.next();%>
<h5>Patient Past Records :</h5>
<%if(opdPatientHistory.getPersonalOtherDetails() != null){ %> <label
	class="valueNoWidth"><%=opdPatientHistory.getPersonalOtherDetails() %></label>
<% }else{ %> <label class="valueNoWidth">-</label> <% } %>

<h5>Past History :</h5>
<label class="valueNoWidth"><%=opdPatientHistory.getPersonalPastHistory() %></label>

<div class="Clear"></div>
<h5>Present History :</h5>
<label class="valueNoWidth"><%=opdPatientHistory.getPersonalPresentHistory() %></label>
<%}
		} %>
<div class="Clear"></div>
<h5>Drug Prescription</h5>
<textarea name="pastHistory" cols="0" rows="0" class="large" readonly></textarea>

<div class="Clear"></div>

<label class="noWidth">Smoking/ Alcohol :</label> <label class="value"><%=otPreAnesthesiaDetails.getSmokingAlcohol() %></label>

<div class="paddLeft25"><label class="noWidth">Previous
Treatment / Surgery </label></div>

<%if(otPreAnesthesiaDetails.getPrevTreatmentSurgery()!= null){ %> <input
	name="Previous treatment" type="text" class="large"
	value="<%=otPreAnesthesiaDetails.getPrevTreatmentSurgery() %>" /> <%}else{ %>
<label class="valuemedium">-</label> <%} %>


<div class="division"></div>
<div class="blockTitle">General Examination</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="medium">Pulse</label> <input
	name="pulse" type="text" maxlength="15"
	value="<%=otPreAnesthesiaDetails.getPulse() %>" /> <label
	class="medium">Icetrus</label> <input name="icetrus" type="text"
	maxlength="15" value="<%=otPreAnesthesiaDetails.getIcetrus() %>" /> <label
	class="medium">Nourishment</label> <input name="nourishment"
	type="text" maxlength="15"
	value="<%=otPreAnesthesiaDetails.getNourishment() %>" />
<div class="Clear"></div>
<label class="medium">Pallor</label> <input name="pallor" type="text"
	maxlength="15" value="<%=otPreAnesthesiaDetails.getPallor()%>" /> <label
	class="medium">Oedema</label> <input name="oedema" type="text"
	maxlength="15" value="<%=otPreAnesthesiaDetails.getOedema() %>" /> <label
	class="medium">BP</label> <input name="bp" type="text" maxlength="15"
	value="<%=otPreAnesthesiaDetails.getBp()%>" />
<div class="Clear"></div>
<label class="medium">Cyanosis</label> <input name="cyanosis"
	type="text" maxlength="15"
	value="<%=otPreAnesthesiaDetails.getCyanosis() %>" /> <label
	class="medium">Spine</label> <input name="spine" type="text"
	maxlength="15" value="<%=otPreAnesthesiaDetails.getSpine()%>" /> <label
	class="medium">Airway</label> <input name="airway" type="text"
	maxlength="15" value="<%=otPreAnesthesiaDetails.getAirway()%>" />
<div class="Clear"></div>
<label class="medium">Clubbing</label> <input name="clubbing"
	type="text" maxlength="15"
	value="<%=otPreAnesthesiaDetails.getClubbing()%>" /> <label
	class="medium">Thyroid</label> <input name="thyroid" type="text"
	maxlength="15" value="<%=otPreAnesthesiaDetails.getThyroid()%>" /> <label
	class="medium">Venous Access </label> <input name="venous" type="text"
	maxlength="15" value="<%=otPreAnesthesiaDetails.getVenousAccess()%>" />
</div>
<div class="division"></div>
<div class="blockTitle">Respiratory System</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Breath Sound </label> <input
	name="breath" type="text" maxlength="25"
	value="<%=otPreAnesthesiaDetails.getBreathSound()%>" /> <label>Advance
Sound </label> <input name="advance" type="text" maxlength="25"
	value="<%=otPreAnesthesiaDetails.getAdvSound()%>" /></div>
<div class="division"></div>
<div class="blockTitle">Cardio Vascular System</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="medium">S1 </label> <input
	name="s1" type="text" class="calDate" maxlength="10"
	value="<%=otPreAnesthesiaDetails.getS1()%>" /> <label class="medium">S2
</label> <input name="s2" type="text" class="calDate" maxlength="10"
	value="<%=otPreAnesthesiaDetails.getS2()%>" /> <label class="medium">S3
</label> <input name="s3" type="text" class="calDate" maxlength="10"
	value="<%=otPreAnesthesiaDetails.getS3()%>" /> <label class="medium">S4
</label> <input name="s4" type="text" class="calDate" maxlength="10"
	value="<%=otPreAnesthesiaDetails.getS4()%>" />
<div class="Clear"></div>
<label class="medium">Abdomen</label> <%if(otPreAnesthesiaDetails.getAbdomen()!= null){ %>
<label class="value"><%=otPreAnesthesiaDetails.getAbdomen() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Liver</label>
<label class="value"><%=otPreAnesthesiaDetails.getLiver() %></label> <label
	class="medium">Spleen</label> <label class="value"><%=otPreAnesthesiaDetails.getSpleen() %></label>
</div>
<div class="division"></div>

<!-- <label>Investigation</label>
	<input name="investigation" type="button" value="View Investigation Details" class="cmnButton" />-->
<div class="Clear"></div>

<div class="blockTitle">Others</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="noWidth">&nbsp;&nbsp;Accepted
in ASA grade<span>*</span></label> <label class="value"><%=otPreAnesthesiaDetails.getAsaGrade() %></label>
<label>Please Arrange Blood</label> <input name="blood" type="text"
	maxlength="25" value="<%=otPreAnesthesiaDetails.getBlood()%>" /> <label
	class="small">In</label>

<div class="Clear"></div>
<label class="noWidth">&nbsp;&nbsp;Any Special Instruction</label> <label
	class="value"><%=otPreAnesthesiaDetails.getInstructions() %></label></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=currentDate %></label>

<label>Changed Time</label> <label class="value"><%=currentTime %></label>
<div class="Clear"></div>
<div class="Height10"></div>


<%}}else{ %> <label class="value">No record found.</label> <%} %> <input
	name="Back" type="button" alt="Back" value="Back" class="button"
	onclick="history.back();" align="right" /></div>
</form>
<!--main content placeholder ends here--></div>


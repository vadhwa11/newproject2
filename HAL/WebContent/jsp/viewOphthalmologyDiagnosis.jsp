<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdOphDiagnosisHeader"%>
<%@page import="jkt.hms.masters.business.OpdOphDiagnosisDetails"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="viewDiagnosis" method="post" action="">
<h6>OPD Ophthalmology Diagnosis</h6>
<div class="Clear"></div>

<!--Block One Starts--> <%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		
		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<OpdOphDiagnosisHeader> ophDiagnosisList = new ArrayList<OpdOphDiagnosisHeader>();
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}	
		if(detailsMap.get("patientDataList") != null){
			patientDataList=(List<Visit>)detailsMap.get("patientDataList");
		}	
		if(map.get("ophDiagnosisList") != null){
			ophDiagnosisList=(List<OpdOphDiagnosisHeader>)map.get("ophDiagnosisList");
		}	
		int visitId = 0;
		int currentVisitId = 0;
		if(map.get("visitId") != null){
			visitId = (Integer)map.get("visitId");
		}
		if(map.get("currentVisitId") != null){
			currentVisitId = (Integer)map.get("currentVisitId");
		}
		
		Visit visit = new Visit();
		if(patientDataList.size() > 0){
			visit = patientDataList.get(0);
		}

		String patientName="";
		if(visit.getHin().getPFirstName()!= null){
			patientName=visit.getHin().getPFirstName();
		}
		if(visit.getHin().getPMiddleName()!= null){
			patientName=patientName+" "+visit.getHin().getPMiddleName();
		}
		if(visit.getHin().getPLastName()!= null){
			patientName=patientName+" "+visit.getHin().getPLastName();
		}
		 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
%> <%

	if(ophDiagnosisList.size() >0){
		OpdOphDiagnosisHeader diagnosisHeader = ophDiagnosisList.get(0);
		Set<OpdOphDiagnosisDetails> detailsSet = diagnosisHeader.getOpdOphDiagnosisDetails();
%>


<div class="BlockFrame"><label>Name</label> <%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label> <%}else{ %> <label
	class="value">- </label> <%} %> <label>Service No.</label> <%if(visit.getHin().getServiceNo() != null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %> </label> <%}else{ %>
<label class="value">- </label> <%} %> <label>HIN</label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="value"><%=visit.getHin().getHinNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>
<div class="Clear"></div>
<label>Rank</label> <%if(visit.getHin().getRank()!= null){ %> <label
	class="value"><%=visit.getHin().getRank().getRankName() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Age</label> <%if(visit.getAge()!= null){ %>
<label class="value"><%=visit.getAge() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Unit</label> <%if(visit.getHin().getUnit()!= null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="Clear"></div>
<label>Trade</label> <%if(visit.getHin().getTrade()!= null){ %> <label
	class="value"><%=visit.getHin().getTrade().getTradeName() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Visit No.</label> <%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Visit Date</label> <%if(visitDateInString!= null){ %>
<label class="value"><%=visitDateInString%></label> <%}else{ %> <label
	class="value">-</label> <%} %>
</div>
<!--Block one Ends-->
<div class="division"></div>


<!--Block Three Starts-->
<div class="colsHolder">

<div class="floatRight">
<div class="blockFrameSm">
<div class="blockTitle">Diagnosis</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label>Ocular</label> <%
	if(diagnosisHeader.getOcular() != null){
%> <input name="<%=OCULAR %>" type="text"
	value="<%= diagnosisHeader.getOcular()%>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=OCULAR %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %> <label>Systemic</label>
<%
	if(diagnosisHeader.getSystemic() != null){
%> <input name="<%=SYSTEMIC %>" type="text"
	value="<%=diagnosisHeader.getSystemic() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=SYSTEMIC %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %>
<div class="Clear"></div>
<label>Plan</label> <%
	if(diagnosisHeader.getPlan() != null){
%> <input name="<%=PLAN %>" type="text"
	value="<%=diagnosisHeader.getPlan() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=PLAN %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %>
<div class="division"></div>
<div class="blockTitle">Counselling</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<h5>Advice</h5>
<div class="Clear"></div>
<label>Sr.No.</label> <label class="center">Medicine</label> <label
	class="center">UOM</label> <label class="center">Frequency</label> <label
	class="center">Eye</label>
<div class="Clear"></div>
<%
	int i = 1;
	String medicine = "";
	String uom = "";
	String eye = "";
	String frequency = "";
	for(OpdOphDiagnosisDetails detailsObj : detailsSet){
		medicine = detailsObj.getMedicine();
		uom = detailsObj.getDrugType();
		eye = detailsObj.getEye();
		if(detailsObj.getFrequency() != null){
			frequency = detailsObj.getFrequency().getFrequencyName();
		}
%> <label><%=i %>.</label> <input name="<%=MEDICINE %>" type="text"
	value="<%=medicine %>" maxlength="20" readonly="readonly"> <input
	name="<%=UOM %>" type="text" value="<%=uom %>" maxlength="20"
	readonly="readonly"> <input name="<%=FREQUENCY %>" type="text"
	value="<%=eye %>" maxlength="20" readonly="readonly"> <input
	name="<%=MEDICINE %>" type="text" value="<%=frequency %>"
	maxlength="20" readonly="readonly"> <% i++;
} %>
<div class="division"></div>
<div class="blockTitle">Surgery</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label>Right Eye</label> <%
	if(diagnosisHeader.getRightEyeSurgery() != null){
%> <input name="<%=RIGHT_EYE %>" type="text"
	value="<%=diagnosisHeader.getRightEyeSurgery() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=RIGHT_EYE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %> <label>Left
Eye</label> <%
	if(diagnosisHeader.getLeftEyeSurgery() != null){
%> <input name="<%=LEFT_EYE%>" type="text"
	value="<%=diagnosisHeader.getLeftEyeSurgery() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=LEFT_EYE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %>
<div class="Clear"></div>
<label>Anesthesia Type</label> <%
	if(diagnosisHeader.getAnesthesia() != null){
%> <input name="<%=ANESTHESIA_ID%>" type="text"
	value="<%=diagnosisHeader.getAnesthesia().getAnesthesiaName() %>"
	maxlength="20" readonly="readonly"> <%}else{ %> <input
	name="<%=ANESTHESIA_ID %>" type="text" value="" maxlength="20"
	readonly="readonly"> <%} %> <label>Next Review Date</label> <%
	if(diagnosisHeader.getNextReviewDate() != null){
%> <input name="<%=NEXT_REVIEW_DATE %>" type="text"
	value="<%=diagnosisHeader.getNextReviewDate() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=NEXT_REVIEW_DATE %>" type="text" value="" maxlength="20"
	readonly="readonly"> <%} %>
</div>
</div>
</div>

<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> <input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="currentVisitId" value="<%=currentVisitId %>"> <!--Bottom labels starts-->
<div class="bottom"><input name="prev" type="button"
	class="button" value="Prev"
	onclick="submitForm('viewDiagnosis','opd?method=viewOphthalmologyDiagnosis&flag=prev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('viewDiagnosis','opd?method=viewOphthalmologyDiagnosis&flag=next');">
<input name="back" type="button" class="button" value="Back"
	onclick="submitForm('viewDiagnosis','opd?method=showOphthalmologyDiagnosisJsp&visitId=<%=currentVisitId %>');">
</div>
<!--Bottom labels ends--> <%}else{ %> No Record Found!! <!--Bottom labels starts-->
<div class="bottom"><input name="back" type="button"
	class="button" value="Back"
	onclick="submitForm('viewDiagnosis','opd?method=showOphthalmologyDiagnosisJsp&visitId=<%=currentVisitId %>');">
</div>

<!--Bottom labels ends--> <%} %>
</form>
</div>
<!--main content placeholder ends here-->

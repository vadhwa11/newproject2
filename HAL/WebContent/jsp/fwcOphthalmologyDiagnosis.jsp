<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.MasAnesthesia"%>

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
<form name="ophthalmologyDiagnosis" method="post" action="">
<h6>OPD Ophthalmology Diagnosis</h6>
<div class="Clear"></div>

<!--Block One Starts--> <%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<MasAnesthesia> anesthesiaList = new ArrayList<MasAnesthesia>();
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}	
		if(map.get("patientDataList") != null){
			patientDataList=(List<Visit>)map.get("patientDataList");
		}	
		if(detailsMap.get("frequencyList") != null){
			frequencyList=(List<MasFrequency>)detailsMap.get("frequencyList");
		}	
		if(detailsMap.get("anesthesiaList") != null){
			anesthesiaList=(List<MasAnesthesia>)detailsMap.get("anesthesiaList");
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
%>


<div class="blockFrame"><label>Name</label> <%if(patientName!= null){ %>
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
<div class="Clear"></div>
</div>
<!--Block one Ends-->
<div class="division"></div>


<!--Block Three Starts-->
<div class="colsHolder">

<div class="floatLeft"><input name="patient fast history3"
	type="button" class="navButtons" value="Retinal"
	onclick="submitForm('ophthalmologyDiagnosis','/hms/hms/fwc?method=showOphthalmologyRetinalJsp');" />
<input name="patient fast history" type="button" class="navButtons"
	value="Follow Up"
	onclick="submitForm('ophthalmologyDiagnosis','/hms/hms/fwc?method=showOphthalmologyFollowUpJsp');" />
<input name="patient fast history23" type="button" class="navButtons"
	value="Ophthalmology"
	onclick="submitForm('ophthalmologyDiagnosis','fwc?method=showOpdOphthamologyJsp');" />
</div>
<div class="floatRight">
<div class="blockFrameSm">
<div class="blockTitle">Diagnosis</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label>Ocular</label> <input name="<%=OCULAR %>" type="text" value=""
	maxlength="20"> <label>Systemic</label> <input
	name="<%=SYSTEMIC %>" type="text" value="" maxlength="20">
<div class="Clear"></div>
<label>Plan</label> <input name="<%=PLAN %>" type="text" value=""
	maxlength="20">

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
	for(int i=1;i<=8;i++){
%> <label><%=i %>.</label> <input name="<%=MEDICINE %>" type="text"
	value="" maxlength="20"> <select name="<%=UOM %>">
	<option value="">Select</option>
	<option value="eyeDrop">Eye Drop</option>
	<option value="mg">Mg</option>
</select> <select name="<%=FREQUENCY %>">
	<option value="0">Select</option>
	<%
	if(frequencyList.size() > 0){
		for(MasFrequency frequency : frequencyList){	
%>
	<option value="<%=frequency.getId() %>"><%=frequency.getFrequencyName() %></option>
	<%} 
}%>
</select> <select name="<%=EYE %>">
	<option value="">Select</option>
	<option value="RE">Right Eye</option>
	<option value="LE">Left Eye</option>
	<option value="BE">Both Eyes</option>

</select>
<div class="Clear"></div>
<%} %>

<div class="division"></div>
<div class="blockTitle">Surgery</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label>Right Eye</label> <input name="<%=RIGHT_EYE %>" type="text"
	value="" maxlength="20"> <label>Left Eye</label> <input
	name="<%=LEFT_EYE%>" type="text" value="" maxlength="20">
<div class="Clear"></div>
<label>Anesthesia Type</label> <select name="<%=ANESTHESIA_ID %>">
	<option value="0">Select</option>
	<%
	if(anesthesiaList.size() > 0){
		for(MasAnesthesia anesthesia : anesthesiaList){	
%>
	<option value="<%=anesthesia.getId() %>"><%=anesthesia.getAnesthesiaName() %></option>
	<%}
		}%>
</select> <label>Next Review Date</label> <input name="<%=NEXT_REVIEW_DATE %>"
	type="text" value="" maxlength="20"></div>
</div>
</div>

<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> <input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="currentVisitId" value="<%=visit.getId() %>"> <!--Bottom labels starts-->
<div class="bottom"><input name="Save" type="button"
	class="button" value="Submit"
	onclick="if(checkBlankForOphthalmology('ophthalmologyDiagnosis')){submitForm('ophthalmologyDiagnosis','fwc?method=submitOphthalmologyDiagnosis');}">
<input name="view" type="button" class="button" value="View"
	onclick="submitForm('ophthalmologyDiagnosis','fwc?method=viewOphthalmologyDiagnosis&flag=prev');">
<input name="reset" type="reset" class="button" value="Reset"></div>
<!--Bottom labels ends--></form>
</div>
<!--main content placeholder ends here-->

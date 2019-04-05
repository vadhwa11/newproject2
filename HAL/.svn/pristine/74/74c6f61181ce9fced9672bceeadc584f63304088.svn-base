<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdOphthalmology"%>

<%@page import="jkt.hms.masters.business.OpdObg"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="viewObg" method="post" action="">
<h6>OPD OBG</h6>
<div class="Clear"></div>

<!--Block One Starts--> <%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<OpdObg> obgList = new ArrayList<OpdObg>();
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}		
		
		if(detailsMap.get("patientDataList") != null){
			patientDataList=(List<Visit>)detailsMap.get("patientDataList");
		}	
		if(map.get("obgList") != null){
			obgList=(List<OpdObg>)map.get("obgList");
		}	
		int currentVisitId = 0;
		if(map.get("currentVisitId") != null){
			currentVisitId = (Integer)map.get("currentVisitId");
		}
		
		
%> <%
if(obgList.size() > 0){
	
	OpdObg opdObg = new OpdObg();
	opdObg = obgList.get(0);
	
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
	
%> <!--Block One Starts-->
<div class="blockTitle">PAST MEDICAL History <a
	href="javascript:animatedcollapse.toggle('slide0')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide0">
<div class="blockFrame">
<div class="header"><label>&nbsp;</label>
<div class="paddLeft55"><label class="paddLeft25">Personal</label></div>
<label></label>
<div class="paddLeft25"><label>Family</label></div>
</div>

<div class="Clear"></div>
<label>Diabetes Personal</label><label></label> <input
	name="<%=DIABETES_PERSONAL %>"
	value="<%=opdObg.getDiabetesPersonal() %>" maxlength="20" type="text">
<label></label> <input name="<%=DIABETES_FAMILY %>"
	value="<%=opdObg.getDiabetesFamily() %>" maxlength="20" type="text">

<div class="Clear"></div>

<label>Hypertension</label><label></label> <input
	name="<%=HYPERTENSION_PERSONAL %>"
	value="<%=opdObg.getHypertensionPersonal() %>" maxlength="20"
	type="text"> <label></label> <input
	name="<%=HYPERTENSION_FAMILY %>"
	value="<%=opdObg.getHypertensionFamily() %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>Tuberculosis</label><label></label> <input
	name="<%=TUBERCULOSIS_PERSONAL %>"
	value="<%=opdObg.getTuberculosisPersonal() %>" maxlength="20"
	type="text"> <label></label> <input
	name="<%=TUBERCULOSIS_FAMILY %>"
	value="<%=opdObg.getTuberculosisFamily() %>" maxlength="20" type="text">
<div class="Clear"></div>

<label> </label><label>Pulmonary</label> <input
	name="<%=PULMONARY_PERSONAL %>"
	value="<%=opdObg.getPulmonaryPersonal() %>" maxlength="20" type="text">
<label></label> <input name="<%=PULMONARY_FAMILY %>"
	value="<%=opdObg.getPulmonaryFamily() %>" maxlength="20" type="text">
<div class="Clear"></div>

<label></label><label>Abdominal</label> <input
	name="<%=ABDOMINAL_PERSONAL %>"
	value="<%=opdObg.getAbdominalPersonal() %>" maxlength="20" type="text">
<label></label> <input name="<%=ABDOMINAL_FAMILY%>"
	value="<%=opdObg.getAbdominalFamily() %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>Thyroid <span></span></label><label></label> <input
	name="<%=THYROID_PERSONAL %>" value="<%=opdObg.getThyroidPersonal() %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=THYROID_FAMILY %>" value="<%=opdObg.getThyroidFamily() %>"
	maxlength="20" type="text">
<div class="Clear"></div>

<label>Others <span></span></label><label></label> <input
	name="<%=OTHERS_PERSONAL %>" value="<%=opdObg.getOthersPersonal() %>"
	maxlength="25" type="text"> <label></label> <input
	name="<%=OTHERS_FAMILY %>" value="<%=opdObg.getOthersPersonal() %>"
	maxlength="25" type="text">
<div class="Clear"></div>


<div class="Clear"></div>
</div>
</div>

<!--Block One Ends-->
<div class="division"></div>
<!--Block Two Starts-->
<div class="blockTitle">OBSTETRIC HISTORY <a
	href="javascript:animatedcollapse.toggle('slide1')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide1">
<div class="blockFrame">
<div class="Clear"></div>
<label>Normal Delivery</label> <input name="<%=NORMAL_DELIVERY %>"
	value="<%=opdObg.getNormalDelivery() %>" maxlength="20" type="text">
<label></label> <label>Ectopic</label> <input name="<%=ECTOPIC %>"
	value="<%=opdObg.getEctopic() %>" maxlength="20" type="text">

<div class="Clear"></div>
<label>Premature Delivery Baby Alive/Dead Still Births
Fresh/Macerated</label> <input name="<%=PREMATURE_DELIVERY %>"
	value="<%=opdObg.getPrematureDeliveryBabyAliveDead() %>" maxlength="5"
	type="text" /> <label></label> <label>Abortion</label> <input
	name="<%=ABORTION%>" value="<%=opdObg.getAAbortion() %>" maxlength="9"
	type="text"></div>
</div>

<!--Block Two Ends-->
<div class="division"></div>
<!--Block Three Ends-->

<div class="blockTitle">SEXUAL HISTORY <a
	href="javascript:animatedcollapse.toggle('slide2')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide2">
<div class="blockFrame">
<div class="Clear"></div>
<label>Dyspareunia</label> <input name="<%= DYSPAREUNIA%>"
	value="<%=opdObg.getDyspareunia() %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>Awareness of Fertile Period</label> <input name="<%=AWARENESS %>"
	value="<%=opdObg.getAwarenessOfFertilePeriod() %>" maxlength="5"
	type="text">
<div class="Clear"></div>
<label>Trying to conceive for</label> <input
	name="<%=TRYING_TO_CONCERIVE_FOR %>"
	value="<%=opdObg.getTryingToConceiveFor() %>" maxlength="5" type="text">
<div class="Clear"></div>
<label>Frequency of IC</label> <input name="<%=FREQUENCY_OF_IC %>"
	value="<%=opdObg.getFrequencyOfIc() %>" maxlength="10" type="text">/week
for last 6 months</div>
</div>

<!--Block Three Ends-->
<div class="division"></div>
<!--Block Four Ends-->

<div class="blockTitle">CLINICAL EXAMINATION <a
	href="javascript:animatedcollapse.toggle('slide3')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide3">
<div class="blockFrame">
<div class="Clear"></div>
<h5>GENERAL EXAMINATION</h5>
<div class="Clear"></div>
<label>General Apperance:</label> <label>Height:</label> <input
	name="<%=GENERNAL_APPERANCE_HEIGHT %>"
	value="<%=opdObg.getGeneralAppearanceHeight() %>" maxlength="9"
	type="text">
<div class="Clear"></div>
<label></label> <label>Width:</label> <input
	name="<%= GENERNAL_APPERANCE_WIDTH%>"
	value="<%=opdObg.getGeneralAppearanceWeight() %>" maxlength="9"
	type="text">

<div class="Clear"></div>
<label>Secondary Sexual Characters:</label> <label></label> <input
	name="<%=SECONDARY_SEXUAL_CHARACTERS %>"
	value="<%=opdObg.getSecondarySexualCharacters() %>" maxlength="20"
	type="text">

<div class="Clear"></div>
<label>Neck Lymph Glands:</label> <label></label> <input
	name="<%=NECK_LYMPH_GLANDS %>"
	value="<%=opdObg.getNeckLymphGlands() %>" maxlength="20" type="text">

<div class="Clear"></div>
<label>Thyroid:</label> <label></label> <input name="<%=THYROID %>"
	value="<%=opdObg.getThyroid() %>" maxlength="20" type="text">

<div class="Clear"></div>
<label>C.V.S</label> <input name="<%=CVS %>"
	value="<%=opdObg.getCVS() %>" maxlength="20" type="text"> <label>B.P</label>
<input name="<%=B_P%>" value="<%=opdObg.getBP() %>" maxlength="6"
	type="text"> <label>Pulse</label> <input name="<%=PULSE %>"
	value="<%=opdObg.getPulse() %>" maxlength="9" type="text">

<div class="Clear"></div>
<label>RS</label> <input name="<%=RS%>" value="<%=opdObg.getRs() %>"
	maxlength="20" type="text">

<div class="Clear"></div>
<label>CNS</label> <input name="<%=CNS%>" value="<%=opdObg.getCns() %>"
	maxlength="20" type="text"></div>
</div>
<input type="hidden" name="<%=OBG_ID %>" value="<%=opdObg.getId() %>">

<!--Block Five Ends-->


<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><input name="prev" type="button"
	class="button" value="Prev"
	onclick="submitForm('viewObg','opd?method=viewOBGTWO&flag=prev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('viewObg','opd?method=viewOBGTWO&flag=next');">
<input name="button" type="button" class="buttonActive" id="btn2"
	value="Page 2" /> <input name="Button" type="button" class="button"
	value="Page 3"
	onclick="submitForm('viewObg','opd?method=viewOBGTHREE&visitId=<%=currentVisitId %>');" />
<input name="Button" type="button" class="button" value="Back"
	onclick="submitForm('viewObg','opd?method=viewOBGONE&visitId=<%=currentVisitId %>');" />
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <%}%>
</div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> <input
	type="hidden" name="currentVisitId" value="<%=currentVisitId %>">
<!--Bottom labels ends--> <%}else{%> No Record Found!! <!--Bottom labels starts-->
<div class="bottom"><input name="back" type="button"
	class="button" value="Back"
	onclick="submitForm('viewObg','opd?method=showOBGTWOJsp&visitId=<%=currentVisitId %>');">
</div>
<!--Bottom labels ends--> <%} %>

<div class="division"></div>

</form>
</div>
<!--main content placeholder ends here-->
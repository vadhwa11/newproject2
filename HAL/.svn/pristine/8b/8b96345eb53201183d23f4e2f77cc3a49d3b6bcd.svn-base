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
	
%>

<div class="blockTitle">HORMONAL TESTS: <a
	href="javascript:animatedcollapse.toggle('slide1')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide1">
<div class="blockFrame">
<div class="Clear"></div>
<div class="header"><label>&nbsp;</label>
<div class="paddLeft55"><label class="paddLeft25">Wife</label></div>
<label></label>
<div class="paddLeft25"><label>Husband</label></div>
</div>

<div class="Clear"></div>
<label>T3 </label><label></label> <input name="<%=T_THREE_WIFE %>"
	value="<%=opdObg.getTThreeWife() %>" maxlength="20" type="text">
<label></label> <input name="<%=T_THREE_HUSBAND %>"
	value="<%=opdObg.getTThreeHusband() %>" maxlength="20" type="text">

<div class="Clear"></div>

<label>T4 </label><label></label> <input name="<%=T_FOUR_WIFE %>"
	value="<%=opdObg.getTFourWife() %>" maxlength="20" type="text">
<label></label> <input name="<%=T_FOUR_HUSBAND %>"
	value="<%=opdObg.getTFourHusband() %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>TSH </label><label></label> <input name="<%=TSH_WIFE %>"
	value="<%=opdObg.getTshWife() %>" maxlength="20" type="text"> <label></label>
<input name="<%=TSH_HUSBAND %>" value="<%=opdObg.getTshHusband() %>"
	maxlength="20" type="text">
<div class="Clear"></div>

<label>S Prolactin </label><label></label> <input
	name="<%=S_PROLACTIN_WIFE %>" value="<%=opdObg.getSProlactinWife() %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=S_PROLACTIN_HUSBAND %>"
	value="<%=opdObg.getSProlactinHusband() %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>FSH </label><label></label> <input name="<%=FSH_WIFE %>"
	value="<%=opdObg.getFshWife() %>" maxlength="20" type="text"> <label></label>
<input name="<%=FSH_HUSBAND %>" value="<%=opdObg.getFshHusband() %>"
	maxlength="20" type="text">
<div class="Clear"></div>

<label>LH </label><label></label> <input name="<%=LH_WIFE %>"
	value="<%=opdObg.getLhWife() %>" maxlength="20" type="text"> <label></label>
<input name="<%=LH_HUSBAND %>" value="<%=opdObg.getLhHusband() %>"
	maxlength="20" type="text">
<div class="Clear"></div>

<label>S Testosterone </label><label></label> <input
	name="<%=S_TESTOSTERONE_WIFE %>"
	value="<%=opdObg.getSTestosteroneWife() %>" maxlength="20" type="text">
<label></label> <input name="<%=S_TESTOSTERONE_HUSBAND %>"
	value="<%=opdObg.getSTestosteroneHusband() %>" maxlength="20"
	type="text">
<div class="Clear"></div>

<label>DHES </label><label></label> <input name="<%=DHES_WIFE %>"
	value="<%=opdObg.getDhesWife() %>" maxlength="20" type="text">
<label></label> <input name="<%=DHES_HUSBAND %>"
	value="<%=opdObg.getDhesHusband() %>" maxlength="20" type="text">
<div class="Clear"></div>

</div>
</div>
<!--Block one Ends-->
<div class="division"></div>
<!--Block Two Starts-->
<div class="blockTitle">ULTRASONOGRAPHY <a
	href="javascript:animatedcollapse.toggle('slide2')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide2">
<div class="blockFrame">
<div class="Clear"></div>
<label class="noWidth"><U>Test of Tubal Patency</U> </label>
<div class="Clear"></div>
<h5>Hysterosalpingography</h5>
<div class="Clear"></div>
<label>Uterus </label> <label></label> <input
	name="<%=UTERUS_HYSTEROSALIAGOGRAPHY %>"
	value="<%=opdObg.getUterusHysterosaliagography() %>" maxlength="20"
	type="text">

<div class="Clear"></div>
<label>Tubes </label><label>R</label> <input name="<%=TUBES_RIGHT %>"
	value="<%=opdObg.getTubesRight() %>" maxlength="20" type="text">
<label>L</label> <input name="<%=TUBES_LEFT %>"
	value="<%=opdObg.getTubesLeft() %>" maxlength="20" type="text">

<div class="Clear"></div>
<h5>Hysteroscopy</h5>
<div class="Clear"></div>
<label>Endometrical Cavity </label> <label></label> <input
	name="<%=ENDOMETRICAL %>" value="<%=opdObg.getEndometricalCavity() %>"
	maxlength="20" type="text"> <label>Cornual Openings </label> <input
	name="<%=CORNUAL_OPENING %>" value="<%=opdObg.getCornualOpenings() %>"
	maxlength="20" type="text">


<div class="Clear"></div>
<h5>Endoscopy</h5>
<div class="Clear"></div>
<label>Uterus </label> <label></label> <input name="<%=UTERUS %>"
	value="<%=opdObg.getUterus() %>" maxlength="20" type="text"> <label>Pelvis
</label> <input name="<%=PELVIS_ENDOSCOPY_UTERUS %>"
	value="<%=opdObg.getPelvisEndosocopyUterus() %>" maxlength="20"
	type="text">
<div class="Clear"></div>
<label>Tubes </label> <label>R</label> <input
	name="<%=TUBES_RIGHT_ENDOSCOPY %>" value="<%=opdObg.getTubesR() %>"
	maxlength="20" type="text"> <label>L</label> <input
	name="<%=TUBES_LEFT_ENDOSCOPY %>" value="<%=opdObg.getTubesL() %>"
	maxlength="20" type="text">

<div class="Clear"></div>
<label>Ovaries </label> <label>R</label> <input
	name="<%=OVERIES_RIGHT_ENDOSCOPY %>" value="<%=opdObg.getOvariesR() %>"
	maxlength="20" type="text"> <label>L</label> <input
	name="<%=OVERIES_LEFT_ENDOSCOPY %>" value="<%=opdObg.getOvariesL() %>"
	maxlength="20" type="text">
<div class="Clear"></div>
<label>Pelvis </label> <label></label> <input
	name="<%=PELVIS_ENDOSCOPY %>"
	value="<%=opdObg.getPelvisEndosocopy() %>" maxlength="20" type="text">
<div class="Clear"></div>
<h5>Endometrical Biposy</h5>
<div class="Clear"></div>

<label>Date</label> <label></label> <%if(opdObg.getObgDate()==null)
{%> <input type="text" id="startDateId" name="<%=DATE_OBG%>" value=""
	class="calDate" readonly="readonly" validate="DOB,date,no" tabindex="1" />
<a href="javascript:setdate('',document.OBG.<%=DATE_OBG%>)"><img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" tabindex="1" class="calender" /></a> <%}else{%> <input
	type="text" id="startDateId" name="<%=DATE_OBG%>"
	value="<%=HMSUtil.changeDateToddMMyyyy(opdObg.getObgDate()) %>"
	class="calDate" readonly="readonly" validate="DOB,date,no" tabindex="1" />
<a href="javascript:setdate('',document.OBG.<%=DATE_OBG%>)"><img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" tabindex="1" class="calender" /></a> <%} %> <label>Days
of Cycle</label> <input name="<%=DAYS_OF_CYCLE %>"
	value="<%=opdObg.getDaysOfCycle() %>" maxlength="9" type="text">


<div class="Clear"></div>

<label>Proliferative</label> <label></label> <input
	name="<%=PROLIFERATIVE %>" value="<%=opdObg.getProliferative() %>"
	maxlength="20" type="text"> <label>Secretory</label> <input
	name="<%=SECRETORY %>" value="<%=opdObg.getSecretory() %>"
	maxlength="20" type="text" />

<div class="Clear"></div>

<label>Dating</label> <label></label> <input name="<%=DATING %>"
	value="<%=opdObg.getDating() %>" maxlength="20" type="text" /></div>
</div>
<input type="hidden" name="<%=OBG_ID %>" value="<%=opdObg.getId() %>">
<!--Block Three Ends-->
<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><input name="prev" type="button"
	class="button" value="Prev"
	onclick="submitForm('viewObg','opd?method=viewOBGFOUR&flag=prev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('viewObg','opd?method=viewOBGFOUR&flag=next');">
<input name="button" type="button" class="buttonActive" id="btn2"
	value="Page 4" /> <input name="Button" type="button" class="button"
	value="Back"
	onclick="submitForm('viewObg','opd?method=viewOBGTHREE&visitId=<%=currentVisitId %>');" />

<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <%}%> <input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> <input
	type="hidden" name="currentVisitId" value="<%=currentVisitId %>">
<!--Bottom labels ends--> <%}else{%> No Record Found!! <!--Bottom labels starts-->
<input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="history.go(-1);return false;" align="right" /></div>
<!--Bottom labels ends--> <%} %>
<div class="division"></div>

</form>
</div>
<!--main content placeholder ends here-->

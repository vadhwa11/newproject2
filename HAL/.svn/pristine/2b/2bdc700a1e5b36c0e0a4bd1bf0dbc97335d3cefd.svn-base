<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdOphthalmology"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="viewOpdOphthalmology" method="post" action="">
<h6>OPD Ophthalmology</h6>
<div class="Clear"></div>

<!--Block One Starts--> <%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<OpdOphthalmology> ophthalmologyList = new ArrayList<OpdOphthalmology>();
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}		
		
		if(detailsMap.get("patientDataList") != null){
			patientDataList=(List<Visit>)detailsMap.get("patientDataList");
		}	
		if(map.get("ophthalmologyList") != null){
			ophthalmologyList=(List<OpdOphthalmology>)map.get("ophthalmologyList");
		}	
		
		int currentVisitId = 0;
		
		if(map.get("currentVisitId") != null){
			currentVisitId = (Integer)map.get("currentVisitId");
		}
		System.out.println("jkt currentVisitId--"+currentVisitId);
		
%> <%
if(ophthalmologyList.size() > 0){
	
	OpdOphthalmology opdOphthalmology = new OpdOphthalmology();
	opdOphthalmology = ophthalmologyList.get(0);
	
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

<div class="blockTitle">Symptoms &amp; Duration</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<label>Decreased Vision</label> <%
	if(opdOphthalmology.getDecreasedVision() != null){
%> <input name="<%=DECREASED_VISION %>" type="text"
	value="<%=opdOphthalmology.getDecreasedVision() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=DECREASED_VISION %>" type="text" value="" maxlength="20"
	readonly="readonly"> <%} %> <label>Redness</label> <%
	if(opdOphthalmology.getRedness() != null){
%> <input name="<%=REDNESS %>" type="text"
	value="<%=opdOphthalmology.getRedness() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=REDNESS %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %>
<div class="Clear"></div>
<label>Pain</label> <%
	if(opdOphthalmology.getPain() != null){
%> <input name="<%=PAIN %>" type="text"
	value="<%=opdOphthalmology.getPain()  %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=PAIN %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %> <label>Discharge</label>
<%
	if(opdOphthalmology.getDischarge() != null){
%> <input name="<%=DISCHARGE %>" type="text"
	value="<%=opdOphthalmology.getDischarge() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=DISCHARGE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %>
<div class="division"></div>
<label class="NoWidth">Floater/ Trauma/ Epiphora etc</label> <%
	if(opdOphthalmology.getFloaterTraumaEpiphora() != null){
%> <input name="<%=FLOATER_TRAUMA_EPIPHORA %>" type="text"
	value="<%=opdOphthalmology.getFloaterTraumaEpiphora() %>"
	maxlength="30"> <%}else{ %> <input
	name="<%=FLOATER_TRAUMA_EPIPHORA %>" type="text" value=""
	maxlength="20" readonly="readonly"> <%} %>
<div class="division"></div>
<div class="blockTitle">Functional Assessment</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label>Reading</label> <%
	if(opdOphthalmology.getReading() != null && !opdOphthalmology.getReading().equals("")){
%> <input name="<%=READING %>" type="checkbox" value="R"
	class="checkbox" checked="checked"> <%}else{ %> <input
	name="<%=READING %>" type="checkbox" value="R" class="checkbox">
<%} %> <label>Driving</label> <%
	if(opdOphthalmology.getDriving() != null && !opdOphthalmology.getDriving().equals("")){
%> <input name="<%=DRIVING %>" type="checkbox" value="D"
	class="checkbox" checked="checked"> <%}else{ %> <input
	name="<%=DRIVING %>" type="checkbox" value="R" class="checkbox">
<%} %> <label>Cooking</label> <%
	if(opdOphthalmology.getCooking() != null && !opdOphthalmology.getCooking().equals("")){
%> <input name="<%=COOKING %>" type="checkbox" value="C"
	class="checkbox" checked="checked"> <%}else{ %> <input
	name="<%=COOKING %>" type="checkbox" value="R" class="checkbox">
<%} %> <label>Ambulatory</label> <%
	if(opdOphthalmology.getAmbulatry() != null && !opdOphthalmology.getAmbulatry().equals("")){
%> <input name="<%=AMBULATORY %>" type="checkbox" value="A"
	class="checkbox" checked="checked"> <%}else{ %> <input
	name="<%=AMBULATORY %>" type="checkbox" value="R" class="checkbox">
<%} %>
<div class="Clear"></div>
<label>Personal Hygiene</label> <%
	if(opdOphthalmology.getPersonalHygiene() != null && !opdOphthalmology.getPersonalHygiene().equals("")){
%> <input name="<%=PERSONAL_HYGIENE %>" type="checkbox" value="P"
	class="checkbox" checked="checked"> <%}else{ %> <input
	name="<%=PERSONAL_HYGIENE %>" type="checkbox" value="R"
	class="checkbox"> <%} %>
<div class="division"></div>


<div class="blockTitle">Treatment History</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label>DM</label> <%
	if(opdOphthalmology.getDm() != null && !opdOphthalmology.getDm().equals("")){
%> <input name="<%=DM %>" type="checkbox" value="D" class="checkbox"
	checked="checked"> <%}else{ %> <input name="<%=DM %>"
	type="checkbox" value="D" class="checkbox"> <%} %> <label>HTN</label>
<%
	if(opdOphthalmology.getHtn() != null && !opdOphthalmology.getHtn().equals("")){
%> <input name="<%=HTN %>" type="checkbox" value="H" class="checkbox"
	checked="checked"> <%}else{ %> <input name="<%=HTN %>"
	type="checkbox" value="R" class="checkbox"> <%} %> <label>Bronchial
Asthma</label> <%
	if(opdOphthalmology.getBa() != null && !opdOphthalmology.getBa().equals("")){
%> <input name="<%=BA %>" type="checkbox" value="B" class="checkbox"
	checked="checked"> <%}else{ %> <input name="<%=BA %>"
	type="checkbox" value="R" class="checkbox"> <%} %> <label>CAD</label>
<%
	if(opdOphthalmology.getCad() != null && !opdOphthalmology.getCad().equals("")){
%> <input name="<%=CAD%>" type="checkbox" value="C" class="checkbox"
	checked="checked"> <%}else{ %> <input name="<%=CAD%>"
	type="checkbox" value="R" class="checkbox"> <%} %>
<div class="Clear"></div>

<label>Autoimmune</label> <%
	if(opdOphthalmology.getAutoimmune() != null && !opdOphthalmology.getAutoimmune().equals("")){
%> <input name="<%=AUTOIMMUNE %>" type="checkbox" value="A"
	class="checkbox" checked="checked"> <%}else{ %> <input
	name="<%=AUTOIMMUNE %>" type="checkbox" value="R" class="checkbox">
<%} %> <label>Others</label> <%
	if(opdOphthalmology.getOthers() != null && !opdOphthalmology.getOthers().equals("")){
%> <input name="<%=OTHERS %>" type="checkbox" value="O" class="checkbox"
	checked="checked"> <%}else{ %> <input name="<%=OTHERS %>"
	type="checkbox" value="R" class="checkbox"> <%} %>


<div class="division"></div>
<div class="blockTitle">OCULAR EXAMINATION</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<label><u>Vision</u></label> <label>&nbsp;</label> <label class="center">RE</label>
<label class="center">LE</label> <label class="center">PH</label>
<div class="Clear"></div>
<label>Distance</label> <label>&nbsp;</label> <%
if(opdOphthalmology.getDistanceRe() != null){
%> <input name="<%=DISTANCE_RE %>" type="text"
	value="<%=opdOphthalmology.getDistanceRe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=DISTANCE_RE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %> <%
if(opdOphthalmology.getDistanceLe() != null){
%> <input name="<%=DISTANCE_LE %>" type="text"
	value="<%=opdOphthalmology.getDistanceLe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=DISTANCE_LE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %> <%
if(opdOphthalmology.getDistancePh() != null){
%> <input name="<%=DISTANCE_PH %>" type="text"
	value="<%=opdOphthalmology.getDistancePh() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=DISTANCE_PH %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %>
<div class="Clear"></div>
<label>Near</label> <label>&nbsp;</label> <%
if(opdOphthalmology.getNearRe() != null){
%> <input name="<%=NEAR_RE %>" type="text"
	value="<%=opdOphthalmology.getNearRe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=NEAR_RE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %> <%
if(opdOphthalmology.getNearLe() != null){
%> <input name="<%=NEAR_LE %>" type="text"
	value="<%=opdOphthalmology.getNearLe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=NEAR_LE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %> <%
if(opdOphthalmology.getNearPh() != null){
%> <input name="<%=NEAR_PH %>" type="text"
	value="<%=opdOphthalmology.getNearPh() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=NEAR_PH %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %>
<div class="Clear"></div>
<label>Refraction</label> <label>&nbsp;</label> <%
if(opdOphthalmology.getRefractionRe() != null){
%> <input name="<%=REFRACTION_RE %>" type="text"
	value="<%=opdOphthalmology.getRefractionRe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=REFRACTION_RE %>" type="text" value="" maxlength="20"
	readonly="readonly"> <%} %> <%
if(opdOphthalmology.getRefractionLe() != null){
%> <input name="<%=REFRACTION_LE %>" type="text"
	value="<%=opdOphthalmology.getRefractionLe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=REFRACTION_LE %>" type="text" value="" maxlength="20"
	readonly="readonly"> <%} %> <%
if(opdOphthalmology.getRefractionPh() != null){
%> <input name="<%=REFRACTION_PH %>" type="text"
	value="<%=opdOphthalmology.getRefractionPh() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=REFRACTION_PH %>" type="text" value="" maxlength="20"
	readonly="readonly"> <%} %>
<div class="Clear"></div>
<label>Acceptance</label> <label>Distance</label> <%
if(opdOphthalmology.getAcceptanceDistanceRe() != null){
%> <input name="<%=ACCEPTANCE_DISTANCE_RE %>" type="text"
	value="<%=opdOphthalmology.getAcceptanceDistanceRe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=ACCEPTANCE_DISTANCE_RE %>" type="text" value="" maxlength="20"
	readonly="readonly"> <%} %> <%
if(opdOphthalmology.getAcceptanceDistanceLe() != null){
%> <input name="<%=ACCEPTANCE_DISTANCE_LE %>" type="text"
	value="<%=opdOphthalmology.getAcceptanceDistanceLe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=ACCEPTANCE_DISTANCE_LE %>" type="text" value="" maxlength="20"
	readonly="readonly"> <%} %> <%
if(opdOphthalmology.getAcceptanceDistancePh() != null){
%> <input name="<%=ACCEPTANCE_DISTANCE_PH %>" type="text"
	value="<%=opdOphthalmology.getAcceptanceDistancePh() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=ACCEPTANCE_DISTANCE_PH %>" type="text" value="" maxlength="20"
	readonly="readonly"> <%} %>
<div class="Clear"></div>
<label>&nbsp;</label> <label>Near</label> <%
if(opdOphthalmology.getAcceptanceNearRe() != null){
%> <input name="<%=ACCEPTANCE_NEAR_RE %>" type="text"
	value="<%=opdOphthalmology.getAcceptanceNearRe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=ACCEPTANCE_NEAR_RE %>" type="text" value="" maxlength="20"
	readonly="readonly"> <%} %> <%
if(opdOphthalmology.getAcceptanceNearLe() != null){
%> <input name="<%=ACCEPTANCE_NEAR_LE %>" type="text"
	value="<%=opdOphthalmology.getAcceptanceNearLe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=ACCEPTANCE_NEAR_LE %>" type="text" value="" maxlength="20"
	readonly="readonly"> <%} %> <%
if(opdOphthalmology.getAcceptanceNearPh() != null){
%> <input name="<%=ACCEPTANCE_NEAR_PH %>" type="text"
	value="<%=opdOphthalmology.getAcceptanceNearPh() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=ACCEPTANCE_NEAR_PH %>" type="text" value="" maxlength="20"
	readonly="readonly"> <%} %>

<div class="division"></div>
<label>Convergence</label> <label>&nbsp;</label> <select
	name="selConvergence" onchange="checkOption(this);">
	<option value="">Select</option>
	<option value="normal">Normal</option>
	<option value="abnormal">Abnormal</option>
</select> <input name="<%=CONVERGENCE %>" type="text" value="" maxlength="10"
	readonly="readonly">
<div class="Clear"></div>
<label>Color Vision </label> <label>&nbsp;</label> <select
	name="selColorVision" onchange="checkOption(this);">
	<option value="">Select</option>
	<option value="normal">Normal</option>
	<option value="abnormal">Abnormal</option>
</select> <input name="<%=COLOR_VISION %>" type="text" value="" maxlength="10"
	readonly="readonly">
<div class="Clear"></div>
<label>Ocular Movements </label> <label>&nbsp;</label> <select
	name="selOcularMovements" onchange="checkOption(this);">
	<option value="">Select</option>
	<option value="normal">Normal</option>
	<option value="abnormal">Abnormal</option>
</select> <input name="<%=OCULAR_MOVEMENTS %>" type="text" value=""
	maxlength="10" readonly="readonly">
<div class="Clear"></div>
<label>Lids</label> <label>&nbsp;</label> <select name="selLids"
	onchange="checkOption(this);">
	<option value="">Select</option>
	<option value="normal">Normal</option>
	<option value="abnormal">Abnormal</option>
</select> <input name="<%=LIDS %>" type="text" value="" maxlength="10"
	readonly="readonly">
<div class="Clear"></div>
<label>Conjunctiva</label> <label>&nbsp;</label> <select
	name="selConjunctiva" onchange="checkOption(this);">
	<option value="">Select</option>
	<option value="normal">Normal</option>
	<option value="abnormal">Abnormal</option>
</select> <input name="<%=CONJUNCTIVA %>" type="text" value="" maxlength="10"
	readonly="readonly">
<div class="Clear"></div>
<label>Cornea &amp; AC </label> <label>&nbsp;</label> <%
if(opdOphthalmology.getCorneaAcRe() != null){
%> <input name="<%=CORNEA_AC_RE %>" type="text"
	value="<%=opdOphthalmology.getCorneaAcRe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=CORNEA_AC_RE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %> <%
if(opdOphthalmology.getCorneaAcLe() != null){
%> <input name="<%=CORNEA_AC_LE %>" type="text"
	value="<%=opdOphthalmology.getCorneaAcLe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=CORNEA_AC_LE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %>
<div class="division"></div>


<label>Ant chamber depth</label> <label>&nbsp;</label> <%
if(opdOphthalmology.getAntChamberDepthRe() != null){
%> <input name="<%=ANT_CHAMBER_RE %>" type="text"
	value="<%=opdOphthalmology.getAntChamberDepthRe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=ANT_CHAMBER_RE %>" type="text" value="-" maxlength="20"
	readonly="readonly"> <%} %> <%
if(opdOphthalmology.getAntChamberDepthLe() != null){
%> <input name="<%=ANT_CHAMBER_LE %>" type="text"
	value="<%=opdOphthalmology.getAntChamberDepthLe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=ANT_CHAMBER_LE %>" type="text" value="-" maxlength="20"
	readonly="readonly"> <%} %>

<div class="Clear"></div>

<label>Cells/flare</label> <label>&nbsp;</label> <%
if(opdOphthalmology.getCellsFlareRe() != null){
%> <input name="<%=CELLS_FLARE_RE %>" type="text"
	value="<%=opdOphthalmology.getCellsFlareRe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=CELLS_FLARE_RE %>" type="text" value="-" maxlength="20"
	readonly="readonly"> <%} %> <%
if(opdOphthalmology.getCellsFlareLe() != null){
%> <input name="<%=CELLS_FLARE_LE %>" type="text"
	value="<%=opdOphthalmology.getCellsFlareLe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=CELLS_FLARE_LE %>" type="text" value="-" maxlength="20"
	readonly="readonly"> <%} %>

<div class="Clear"></div>
<label>PXF/NVI</label> <label>&nbsp;</label> <%
if(opdOphthalmology.getPxfNviRe() != null){
%> <input name="<%=PXF_NVI_RE %>" type="text"
	value="<%=opdOphthalmology.getPxfNviRe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=PXF_NVI_RE %>"
	type="text" value="-" maxlength="20" readonly="readonly"> <%} %>
<%
if(opdOphthalmology.getPxfNviLe() != null){
%> <input name="<%=PXF_NVI_LE %>" type="text"
	value="<%=opdOphthalmology.getPxfNviLe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=PXF_NVI_LE %>"
	type="text" value="-" maxlength="20" readonly="readonly"> <%} %>
<div class="Clear"></div>
<label>Pupil Reaction </label> <label>Direct</label> <%
	if(opdOphthalmology.getPupilReactionDirect() != null && !opdOphthalmology.getPupilReactionDirect().equals("")){
%> <input name="<%=DIRECT %>" type="checkbox" value="D" class="checkbox"
	checked="checked"> <%}else{ %> <input name="<%=DIRECT %>"
	type="checkbox" value="R" class="checkbox"> <%} %> <label>Consensnal</label>
<%
	if(opdOphthalmology.getPupilReactionConsensnal() != null && !opdOphthalmology.getPupilReactionConsensnal().equals("")){
%> <input name="<%=CONSENSNAL %>" type="checkbox" value="C"
	class="checkbox" checked="checked"> <%}else{ %> <input
	name="<%=CONSENSNAL %>" type="checkbox" value="R" class="checkbox">
<%} %> <label>RAPD</label> <%
	if(opdOphthalmology.getPupilReactionRapd() != null && !opdOphthalmology.getPupilReactionRapd().equals("")){
%> <input name="<%=RAPD %>" type="checkbox" value="P" class="checkbox"
	checked="checked"> <%}else{ %> <input name="<%=RAPD %>"
	type="checkbox" value="R" class="checkbox"> <%} %>




<div class="Clear"></div>
<label>Gonioscopy </label> <label>&nbsp;</label> <%
if(opdOphthalmology.getGonioscopyRe() != null){
%> <input name="<%=GONIOSCOPY_RE %>" type="text"
	value="<%=opdOphthalmology.getGonioscopyRe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=GONIOSCOPY_RE %>" type="text" value="" maxlength="20"
	readonly="readonly"> <%} %> <%
if(opdOphthalmology.getGonioscopyLe() != null){
%> <input name="<%=GONIOSCOPY_LE %>" type="text"
	value="<%=opdOphthalmology.getGonioscopyLe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=GONIOSCOPY_LE %>" type="text" value="" maxlength="20"
	readonly="readonly"> <%} %>
<div class="Clear"></div>
<label>IOP(months)</label> <label>&nbsp;</label> <%
if(opdOphthalmology.getIopRe() != null){
%> <input name="<%=IOP_RE %>" type="text"
	value="<%=opdOphthalmology.getIopRe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=IOP_RE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %> <%
if(opdOphthalmology.getIopLe() != null){
%> <input name="<%=IOP_LE %>" type="text"
	value="<%=opdOphthalmology.getIopLe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=IOP_LE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %>
<div class="division"></div>
<h5>Sac</h5>
<div class="Clear"></div>
<label>Papillary Dilatation </label> <label>&nbsp;</label> <%
if(opdOphthalmology.getDilationRe() != null){
%> <input name="<%=DILATION_RE %>" type="text"
	value="<%=opdOphthalmology.getDilationRe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=DILATION_RE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %> <%
if(opdOphthalmology.getDilationLe() != null){
%> <input name="<%=DILATION_LE %>" type="text"
	value="<%=opdOphthalmology.getDilationLe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=DILATION_LE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %>
<div class="Clear"></div>
<label>Lens </label> <label>&nbsp;</label> <%
if(opdOphthalmology.getLensRe() != null){
%> <input name="<%=LENS_RE %>" type="text"
	value="<%=opdOphthalmology.getLensRe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=LENS_RE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %> <%
if(opdOphthalmology.getLensLe() != null){
%> <input name="<%=LENS_LE %>" type="text"
	value="<%=opdOphthalmology.getLensLe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=LENS_LE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %>
<div class="Clear"></div>
<label>Fundus</label> <label>&nbsp;</label> <%
if(opdOphthalmology.getFundusRe() != null){
%> <input name="<%=FUNDUS_RE %>" type="text"
	value="<%=opdOphthalmology.getFundusRe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=FUNDUS_RE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%} %> <%
if(opdOphthalmology.getFundusLe() != null){
%> <input name="<%=FUNDUS_LE %>" type="text"
	value="<%=opdOphthalmology.getFundusLe() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=FUNDUS_LE %>"
	type="text" value="" maxlength="20" readonly="readonly"> <%}%>
</div>
</div>
</div>
<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><input name="prev" type="button"
	class="button" value="Prev"
	onclick="submitForm('viewOpdOphthalmology','fwc?method=viewPatientOphthalmologyDetails&flag=prev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('viewOpdOphthalmology','fwc?method=viewPatientOphthalmologyDetails&flag=next');">
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <input name="back" type="button" class="button" value="Back"
	onclick="submitForm('viewOpdOphthalmology','<%=url %>');"> <%}%>
</div>

<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> <input
	type="hidden" name="currentVisitId" value="<%=currentVisitId %>">
<!--Bottom labels ends--> <%}else{%> No Record Found!! <!--Bottom labels starts-->

<div class="bottom"><input name="Back" type="button"
	src="images/phaseII/delete.gif" alt="Back" value="Back" class="button"
	onclick="history.go(-1);return false;" align="right" /></div>
<!--Bottom labels ends--> <%} %>

<div class="division"></div>

</form>
</div>
<!--main content placeholder ends here-->

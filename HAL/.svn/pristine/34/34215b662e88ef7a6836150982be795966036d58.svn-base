<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdOphthalmology" %>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="opdOphthalmology" method="post" action="">
<h6>OPD Ophthalmology</h6>
<div class="Clear"></div>

<!--Block One Starts--> <%
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<OpdOphthalmology> opdOphthalmologyList = null ;
		OpdOphthalmology opdOphthalmology =null ; 
		if(map.get("patientDataList") != null){
			patientDataList=(List<Visit>)map.get("patientDataList");
		}
		if(map.get("opdOphthalmologyList")!=null){
			opdOphthalmologyList = (List<OpdOphthalmology>)map.get("opdOphthalmologyList");
			if(opdOphthalmologyList.size()>0)
				opdOphthalmology = (OpdOphthalmology)opdOphthalmologyList.get(0);	
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

<div class="floatLeft"><input name="patient fast history"
	type="button" class="navButtons" value="Follow Up"
	onclick="submitForm('opdOphthalmology','/hms/hms/opd?method=showOphthalmologyFollowUpJsp');">
<input name="patient fast history3" type="button" class="navButtons"
	value="Retinal"
	onclick="submitForm('opdOphthalmology','/hms/hms/opd?method=showOphthalmologyRetinalJsp');">
<input name="patient fast history23" type="button" class="navButtons"
	value="Diagnosis"
	onclick="submitForm('opdOphthalmology','opd?method=showOphthalmologyDiagnosisJsp');">
</div>
<div class="floatRight">
<div class="blockFrameSm">
<div class="blockTitle">Symptoms &amp; Duration</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<%if(opdOphthalmology!=null){ %>
<input type="hidden" name="opdOphthalmologyId" value="<%=opdOphthalmology.getId()%>">
<%}else{ %>
<input type="hidden" name="opdOphthalmologyId" value="0" >
<%} %>
<label>Decreased Vision</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getDecreasedVision()!=null ){ %> 
<input name="<%=DECREASED_VISION %>" type="text" value="<%=opdOphthalmology.getDecreasedVision() %>" maxlength="20">
<%}else{ %>
<input name="<%=DECREASED_VISION %>" type="text" value="" maxlength="20">
<%} %> 
<label>Redness</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getRedness()!=null ){ %> 
<input name="<%=REDNESS %>" type="text" value="<%=opdOphthalmology.getRedness() %>" maxlength="20">
<%}else{ %>
<input name="<%=REDNESS %>" type="text" value="" maxlength="20">
<%} %>
<div class="Clear"></div>
<label>Pain</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getPain()!=null ){ %> 
<input name="<%=PAIN %>" type="text" value="<%=opdOphthalmology.getPain() %>" maxlength="20">
<%}else{ %> 
<input name="<%=PAIN %>" type="text" value="" maxlength="20">
<%} %>
<label>Discharge</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getDischarge()!=null ){ %> 
<input name="<%=DISCHARGE %>" type="text" value="<%=opdOphthalmology.getDischarge() %>" maxlength="20">
<%}else{ %>
<input name="<%=DISCHARGE %>" type="text" value="" maxlength="20">
<%} %>
<div class="division"></div>
<label class="NoWidth">Floater/ Trauma/ Epiphora etc</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getFloaterTraumaEpiphora()!=null ){ %> 
<input name="<%=FLOATER_TRAUMA_EPIPHORA %>" type="text" value="<%=opdOphthalmology.getFloaterTraumaEpiphora() %>" maxlength="30">
<%}else{ %>
<input name="<%=FLOATER_TRAUMA_EPIPHORA %>" type="text" value="" maxlength="30">
<%} %>
<div class="division"></div>
<div class="blockTitle">Functional Assessment</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label>Reading</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getReading()!=null && opdOphthalmology.getReading().equals("R")){ %> 
<input name="<%=READING %>" type="checkbox" value="R" class="checkbox" checked="checked"> 
<%}else{ %>
<input name="<%=READING %>" type="checkbox" value="R" class="checkbox">
<%} %>
<label>Driving</label> 
<%if(opdOphthalmology!=null && opdOphthalmology.getDriving()!=null && opdOphthalmology.getDriving().equals("D") ){ %>
<input name="<%=DRIVING %>" type="checkbox" value="D" class="checkbox" checked="checked">
<%}else{ %>
<input name="<%=DRIVING %>" type="checkbox" value="D" class="checkbox">
<%} %>
<label>Cooking</label> 
<%if(opdOphthalmology!=null && opdOphthalmology.getCooking()!=null && opdOphthalmology.getCooking().equals("C")  ){ %>
<input name="<%=COOKING %>" type="checkbox" value="C" class="checkbox" checked="checked"> 
<%}else{ %>
<input name="<%=COOKING %>" type="checkbox" value="C" class="checkbox">
<%} %>
<label>Ambulatory</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getAmbulatry()!=null && opdOphthalmology.getAmbulatry().equals("A") ){ %> 
<input name="<%=AMBULATORY%>" type="checkbox" value="A" class="checkbox" checked="checked">
<%}else{ %>
<input name="<%=AMBULATORY%>" type="checkbox" value="A" class="checkbox">
<%} %>
<div class="Clear"></div>
<label>Personal Hygiene</label> 
<%if(opdOphthalmology!=null && opdOphthalmology.getPersonalHygiene()!=null && opdOphthalmology.getPersonalHygiene().equals("P")){ %>
<input name="<%=PERSONAL_HYGIENE %>" type="checkbox" value="P" class="checkbox" checked="checked">
<%}else{ %>
<input name="<%=PERSONAL_HYGIENE %>" type="checkbox" value="P" class="checkbox">
<%} %>

<div class="division"></div>

<div class="blockTitle">Treatment History</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label>DM</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getDm()!=null && opdOphthalmology.getDm().equals("D")){ %> 
<input name="<%=DM%>" type="checkbox" value="D" class="checkbox" checked="checked"> 
<%}else{ %>
<input name="<%=DM%>" type="checkbox" value="D" class="checkbox">
<%} %>
<label>HTN</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getHtn()!=null && opdOphthalmology.getHtn().equals("H")){ %> 
<input name="<%=HTN%>" type="checkbox" value="H" class="checkbox" checked="checked"> 
<%}else{ %>
<input name="<%=HTN%>" type="checkbox" value="H" class="checkbox">
<%} %>
<label>Bronchial Asthma</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getBa()!=null && opdOphthalmology.getBa().equals("B")){ %> 
<input name="<%=BA %>" type="checkbox" value="B" class="checkbox" checked="checked">
<%}else{ %>
<input name="<%=BA %>" type="checkbox" value="B" class="checkbox">
<%} %>
<label>CAD</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getCad()!=null && opdOphthalmology.getCad().equals("C")){ %> 
<input name="<%=CAD%>" type="checkbox" value="C" class="checkbox" checked="checked">
<%}else{ %>
<input name="<%=CAD%>" type="checkbox" value="C" class="checkbox">
<%} %>
<div class="Clear"></div>
<label>Autoimmune</label> 
<%if(opdOphthalmology!=null && opdOphthalmology.getAutoimmune()!=null && opdOphthalmology.getAutoimmune().equals("A")){ %>
<input name="<%=AUTOIMMUNE %>" type="checkbox" value="A" class="checkbox" checked="checked">
<%}else{ %> 
<input name="<%=AUTOIMMUNE %>" type="checkbox" value="A" class="checkbox">
<%} %>
<label>Others</label> 
<%if(opdOphthalmology!=null && opdOphthalmology.getOthers()!=null && opdOphthalmology.getOthers().equals("O")){ %>
<input name="<%=OTHERS %>" type="checkbox" value="O" class="checkbox" checked="checked">
<%}else{ %>
<input name="<%=OTHERS %>" type="checkbox" value="O" class="checkbox">
<%} %>

<div class="Clear"></div>

<div class="division"></div>
<div class="blockTitle">OCULAR EXAMINATION</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<label><u>Vision</u></label> <label>&nbsp;</label> <label class="center">RE</label>
<label class="center">LE</label> <label class="center">PH</label>
<div class="Clear"></div>
<div class="Clear"></div>
<label>Distance</label> <label>&nbsp;</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getDistanceRe()!=null ){ %> 
<input	name="<%=DISTANCE_RE %>" type="text" value="<%=opdOphthalmology.getDistanceRe() %>" maxlength="20">
<%}else{ %>
<input	name="<%=DISTANCE_RE %>" type="text" value="" maxlength="20">
<%} if(opdOphthalmology!=null && opdOphthalmology.getDistanceLe()!=null ){ %> 
<input  name="<%=DISTANCE_LE %>" type="text" value="<%=opdOphthalmology.getDistanceLe() %>" maxlength="20">
<%}else{ %>
<input  name="<%=DISTANCE_LE %>" type="text" value="" maxlength="20"> 
<%}if(opdOphthalmology!=null && opdOphthalmology.getDistancePh()!=null ){  %>
<input  name="<%=DISTANCE_PH %>" type="text" value="<%=opdOphthalmology.getDistancePh() %>" maxlength="20">
<%}else{ %>
<input  name="<%=DISTANCE_PH %>" type="text" value="" maxlength="20">
<%}%>
<div class="Clear"></div>
<label>Near</label> <label>&nbsp;</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getNearRe()!=null ){ %> 
<input name="<%=NEAR_RE %>"	type="text" value="<%=opdOphthalmology.getNearRe() %>" maxlength="20">
<%}else{ %>
<input name="<%=NEAR_RE %>"	type="text" value="" maxlength="20">
<%}if(opdOphthalmology!=null && opdOphthalmology.getNearLe()!=null ){ %> 
<input name="<%=NEAR_LE %>" type="text" value="<%=opdOphthalmology.getNearLe() %>" maxlength="20">
<%}else{ %>
<input name="<%=NEAR_LE %>" type="text" value="" maxlength="20">
<%}if(opdOphthalmology!=null && opdOphthalmology.getNearPh()!=null ){ %> 
<input name="<%=NEAR_PH %>" type="text" value="<%=opdOphthalmology.getNearPh() %>" maxlength="20">
<%}else{ %>
<input name="<%=NEAR_PH %>" type="text" value="" maxlength="20">
<%} %>
<div class="Clear"></div>
<label>Refraction</label> <label>&nbsp;</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getRefractionRe()!=null ){ %> 
<input name="<%=REFRACTION_RE %>" type="text" value="<%=opdOphthalmology.getRefractionRe() %>" maxlength="20">
<%}else{ %>
<input name="<%=REFRACTION_RE %>" type="text" value="" maxlength="20">
<%}if(opdOphthalmology!=null && opdOphthalmology.getRefractionLe()!=null ){ %>
<input name="<%=REFRACTION_LE %>" type="text" value="<%=opdOphthalmology.getRefractionLe() %>" maxlength="20">
<%}else{ %>
<input name="<%=REFRACTION_LE %>" type="text" value="" maxlength="20">
<%}if(opdOphthalmology!=null && opdOphthalmology.getRefractionPh()!=null ){ %>
<input name="<%=REFRACTION_PH %>" type="text" value="<%=opdOphthalmology.getRefractionPh() %>" maxlength="20">
<%}else{ %>
<input name="<%=REFRACTION_PH %>" type="text" value="" maxlength="20">
<%} %>
<div class="Clear"></div>
<label>Acceptance</label> <label>Distance</label> 
<%if(opdOphthalmology!=null && opdOphthalmology.getAcceptanceDistanceRe()!=null ){ %>
<input name="<%=ACCEPTANCE_DISTANCE_RE %>" type="text" value="<%=opdOphthalmology.getAcceptanceDistanceRe() %>" maxlength="20">
<%}else{ %>
<input name="<%=ACCEPTANCE_DISTANCE_RE %>" type="text" value="" maxlength="20">
<%}if(opdOphthalmology!=null && opdOphthalmology.getAcceptanceDistanceLe()!=null ){ %>
<input name="<%=ACCEPTANCE_DISTANCE_LE %>" type="text" value="" maxlength="20">
<%}else{ %>
<input name="<%=ACCEPTANCE_DISTANCE_LE %>" type="text" value="" maxlength="20">
<%}if(opdOphthalmology!=null && opdOphthalmology.getAcceptanceDistancePh()!=null ){ %> 
<input name="<%=ACCEPTANCE_DISTANCE_PH %>" type="text" value="<%=opdOphthalmology.getAcceptanceDistancePh() %>" maxlength="20">
<%}else{ %>
<input name="<%=ACCEPTANCE_DISTANCE_PH %>" type="text" value="" maxlength="20">
<%} %>
<div class="Clear"></div>
<label>&nbsp;</label> <label>Near</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getAcceptanceNearRe()!=null ){ %> 
<input name="<%=ACCEPTANCE_NEAR_RE %>" type="text" value="<%=opdOphthalmology.getAcceptanceNearRe() %>" maxlength="20">
<%}else{ %>
<input name="<%=ACCEPTANCE_NEAR_RE %>" type="text" value="" maxlength="20">
<%}if(opdOphthalmology!=null && opdOphthalmology.getAcceptanceNearLe()!=null ){ %>
<input name="<%=ACCEPTANCE_NEAR_LE %>" type="text" value="<%=opdOphthalmology.getAcceptanceNearLe() %>" maxlength="20">
<%}else{ %>
<input name="<%=ACCEPTANCE_NEAR_LE %>" type="text" value="" maxlength="20"> 
<%}if(opdOphthalmology!=null && opdOphthalmology.getAcceptanceNearPh()!=null ){ %>
<input name="<%=ACCEPTANCE_NEAR_PH %>" type="text" value="<%=opdOphthalmology.getAcceptanceNearPh() %>" maxlength="20">
<%}else{ %>
<input name="<%=ACCEPTANCE_NEAR_PH %>" type="text" value="" maxlength="20">
<%} %>

<div class="division"></div>
<label>Convergence</label> <label>&nbsp;</label> 
<select name="selConvergence" onchange="checkOption(this);">
	<option value="">Select</option>
<%if(opdOphthalmology!=null && opdOphthalmology.getConvergence()!=null && opdOphthalmology.getConvergence().equalsIgnoreCase("normal") ){ %>	
	<option value="normal" selected="selected">Normal</option>
<%}else{ %>	
	<option value="normal">Normal</option>
<%}if(opdOphthalmology!=null && opdOphthalmology.getConvergence()!=null && opdOphthalmology.getConvergence().equalsIgnoreCase("abnormal") ){ %>	
	<option value="abnormal" selected="selected">Abnormal</option>
<%}else{ %>	
	<option value="abnormal">Abnormal</option>
<%} %>	
</select> 
<input name="<%=CONVERGENCE %>" type="text" value="" maxlength="10">
<div class="Clear"></div>
<label>Color Vision </label> <label>&nbsp;</label> 
<select name="selColorVision" onchange="checkOption(this);">
	<option value="">Select</option>
<%if(opdOphthalmology!=null && opdOphthalmology.getColorVision()!=null && opdOphthalmology.getColorVision().equalsIgnoreCase("normal") ){ %>	
	<option value="normal">Normal</option>
<%}else{ %>		
	<option value="normal">Normal</option>
<%}if(opdOphthalmology!=null && opdOphthalmology.getColorVision()!=null && opdOphthalmology.getColorVision().equalsIgnoreCase("abnormal") ){ %>	
	<option value="abnormal">Abnormal</option>
<%}else{ %>	
	<option value="abnormal">Abnormal</option>
<%} %>	
</select> 
<input name="<%=COLOR_VISION %>" type="text" value="" maxlength="10">
<div class="Clear"></div>
<label>Ocular Movements </label> <label>&nbsp;</label> 
<select name="selOcularMovements" onchange="checkOption(this);">
	<option value="">Select</option>
<%if(opdOphthalmology!=null && opdOphthalmology.getOcularMovement()!=null && opdOphthalmology.getOcularMovement().equalsIgnoreCase("normal") ){ %>	
	<option value="normal" selected="selected">Normal</option>
<%}else{ %>		
	<option value="normal">Normal</option>
<%}if(opdOphthalmology!=null && opdOphthalmology.getOcularMovement()!=null && opdOphthalmology.getOcularMovement().equalsIgnoreCase("normal") ){ %>	
	<option value="abnormal" selected="selected">Abnormal</option>
<%}else{ %>		
	<option value="abnormal">Abnormal</option>
<%} %>
</select> 
<input name="<%=OCULAR_MOVEMENTS %>" type="text" value="" maxlength="10">
<div class="Clear"></div>
<label>Lids</label> <label>&nbsp;</label> 
<select name="selLids" onchange="checkOption(this);">
	<option value="">Select</option>
<%if(opdOphthalmology!=null && opdOphthalmology.getLids()!=null && opdOphthalmology.getLids().equalsIgnoreCase("normal") ){ %>	
	<option value="normal" selected="selected">Normal</option>
<%}else{ %>		
	<option value="normal">Normal</option>
<%}if(opdOphthalmology!=null && opdOphthalmology.getLids()!=null && opdOphthalmology.getLids().equalsIgnoreCase("normal") ){ %>	
	<option value="abnormal" selected="selected">Abnormal</option>
<%}else{ %>		
	<option value="abnormal">Abnormal</option>
<%} %>	
</select> 
<input name="<%=LIDS %>" type="text" value="" maxlength="10">
<div class="Clear"></div>
<label>Conjunctiva</label> <label>&nbsp;</label> 
<select name="selConjunctiva" onchange="checkOption(this);">
	<option value="">Select</option>
<%if(opdOphthalmology!=null && opdOphthalmology.getConjunctiva()!=null && opdOphthalmology.getConjunctiva().equalsIgnoreCase("normal") ){ %>	
	<option value="normal" selected="selected">Normal</option>
<%}else{ %>	
	<option value="normal">Normal</option>
<%}if(opdOphthalmology!=null && opdOphthalmology.getConjunctiva()!=null && opdOphthalmology.getConjunctiva().equalsIgnoreCase("normal") ){ %>	
	<option value="abnormal" selected="selected">Abnormal</option>
<%}else{ %>	
	<option value="abnormal">Abnormal</option>
<%} %>	
</select> 
<input name="<%=CONJUNCTIVA %>" type="text" value="" maxlength="10">
<div class="Clear"></div>
<label>Cornea &amp; AC </label> <label>&nbsp;</label> 
<%if(opdOphthalmology!=null && opdOphthalmology.getCorneaAcRe()!=null ){%>
<input name="<%=CORNEA_AC_RE %>" type="text" value="<%=opdOphthalmology.getCorneaAcRe() %>" maxlength="20">
<%}else{ %>
<input name="<%=CORNEA_AC_RE %>" type="text" value="" maxlength="20">
<%}if(opdOphthalmology!=null && opdOphthalmology.getCorneaAcLe()!=null ){%>
<input name="<%=CORNEA_AC_LE %>" type="text" value="<%=opdOphthalmology.getCorneaAcLe() %>" maxlength="20">
<%}else{ %>
<input name="<%=CORNEA_AC_LE %>" type="text" value="" maxlength="20">
<%} %>
<div class="division"></div>



<label>Ant chamber depth</label> <label>&nbsp;</label> 
<%if(opdOphthalmology!=null && opdOphthalmology.getAntChamberDepthRe()!=null ){%>
<input name="<%=ANT_CHAMBER_RE %>" type="text" value="<%=opdOphthalmology.getAntChamberDepthRe() %>" maxlength="20">
<%}else{ %>
<input name="<%=ANT_CHAMBER_RE %>" type="text" value="" maxlength="20">
<%}if(opdOphthalmology!=null && opdOphthalmology.getAntChamberDepthLe()!=null ){ %>
<input name="<%=ANT_CHAMBER_LE %>" type="text" value="<%=opdOphthalmology.getAntChamberDepthLe() %>" maxlength="20">
<%}else{ %>
<input name="<%=ANT_CHAMBER_LE %>" type="text" value="" maxlength="20">
<%} %>

<div class="Clear"></div>
<label>Cells/flare</label> <label>&nbsp;</label> 
<%if(opdOphthalmology!=null && opdOphthalmology.getCellsFlareRe()!=null ){%>
<input name="<%=CELLS_FLARE_RE %>" type="text" value="<%=opdOphthalmology.getCellsFlareRe() %>" maxlength="20">
<%}else{ %>
<input name="<%=CELLS_FLARE_RE %>" type="text" value="" maxlength="20">
<%}if(opdOphthalmology!=null && opdOphthalmology.getCellsFlareLe()!=null ){ %>
<input name="<%=CELLS_FLARE_LE %>" type="text" value="<%=opdOphthalmology.getCellsFlareLe() %>" maxlength="20">
<%}else{ %>
<input name="<%=CELLS_FLARE_LE %>" type="text" value="" maxlength="20">
<%} %>
<div class="Clear"></div>
<label>PXF/NVI</label> <label>&nbsp;</label> 
<%if(opdOphthalmology!=null && opdOphthalmology.getPxfNviRe()!=null ){%>
<input name="<%=PXF_NVI_RE %>" type="text" value="<%=opdOphthalmology.getPxfNviRe() %>" maxlength="20">
<%}else{ %>
<input name="<%=PXF_NVI_RE %>" type="text" value="" maxlength="20"> 
<%}if(opdOphthalmology!=null && opdOphthalmology.getPxfNviLe()!=null ){ %>
<input name="<%=PXF_NVI_LE %>" type="text" value="<%=opdOphthalmology.getPxfNviLe() %>" maxlength="20">
<%}else{ %>
<input name="<%=PXF_NVI_LE %>" type="text" value="" maxlength="20">
<%} %>
<div class="Clear"></div>

<label>Pupil Reaction </label> <label>Direct</label> 
<%if(opdOphthalmology!=null && opdOphthalmology.getPupilReactionDirect()!=null && opdOphthalmology.getPupilReactionDirect().equalsIgnoreCase("D") ){%>
<input name="<%=DIRECT %>" type="checkbox" value="D" class="checkbox" checked="checked">
<%}else{ %>
<input name="<%=DIRECT %>" type="checkbox" value="D" class="checkbox">
<%} %>
<label>Consensnal</label> 
<%if(opdOphthalmology!=null && opdOphthalmology.getPupilReactionConsensnal()!=null && opdOphthalmology.getPupilReactionConsensnal().equalsIgnoreCase("C") ){%>
<input name="<%=CONSENSNAL %>" type="checkbox" value="C" class="checkbox" checked="checked">
<%}else{ %> 
<input name="<%=CONSENSNAL %>" type="checkbox" value="C" class="checkbox">
<%} %>
<label>RAPD</label>
 
<input name="<%=RAPD %>" type="checkbox" value="P" class="checkbox">


<div class="Clear"></div>
<label>Gonioscopy </label> <label>&nbsp;</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getGonioscopyRe()!=null){%> 
<input name="<%=GONIOSCOPY_RE %>" type="text" value="<%=opdOphthalmology.getGonioscopyRe() %>" maxlength="20">
<%}else{ %>
<input name="<%=GONIOSCOPY_RE %>" type="text" value="" maxlength="20">
<%} if(opdOphthalmology!=null && opdOphthalmology.getGonioscopyLe()!=null){%>
<input name="<%=GONIOSCOPY_LE %>" type="text" value="<%=opdOphthalmology.getGonioscopyLe() %>" maxlength="20">
<%}else{ %>
<input name="<%=GONIOSCOPY_LE %>" type="text" value="" maxlength="20">
<%} %>
<div class="Clear"></div>
<label>IOP(months)</label> <label>&nbsp;</label> 
<%if(opdOphthalmology!=null && opdOphthalmology.getIopRe()!=null){%>
<input name="<%=IOP_RE %>" type="text" value="<%=opdOphthalmology.getIopRe() %>" maxlength="20"> 
<%}else{ %>
<input name="<%=IOP_RE %>" type="text" value="" maxlength="20">
<%} if(opdOphthalmology!=null && opdOphthalmology.getIopLe()!=null){%>
<input name="<%=IOP_LE %>" type="text" value="<%=opdOphthalmology.getIopLe() %>" maxlength="20">
<%}else{ %>
<input name="<%=IOP_LE %>" type="text" value="" maxlength="20">
<%} %>
<div class="division"></div>
<h5>Sac</h5>
<div class="Clear"></div>
<label>Papillary Dilatation </label> <label>&nbsp;</label>
<%if(opdOphthalmology!=null && opdOphthalmology.getDilationRe()!=null){%> 
<input name="<%=DILATION_RE %>" type="text" value="<%=opdOphthalmology.getDilationRe() %>" class="small"	maxlength="20"> 
<%}else{ %>
<input name="<%=DILATION_RE %>" type="text" value="" class="small"	maxlength="20">
<%} if(opdOphthalmology!=null && opdOphthalmology.getDilationLe()!=null){%> 
<input name="<%=DILATION_LE %>" type="text" value="<%=opdOphthalmology.getDilationLe() %>" class="small" maxlength="20">
<%}else{ %>
<input name="<%=DILATION_LE %>" type="text" value="" class="small" maxlength="20">
<%} %>
<div class="Clear"></div>
<label>Lens </label> <label>&nbsp;</label> 
<%if(opdOphthalmology!=null && opdOphthalmology.getLensRe()!=null){%>
<input name="<%=LENS_RE %>" type="text" value="<%=opdOphthalmology.getLensRe() %>" maxlength="20"> 
<%}else{ %>
<input name="<%=LENS_RE %>" type="text" value="" maxlength="20">
<%}if(opdOphthalmology!=null && opdOphthalmology.getLensLe()!=null){%> 
<input name="<%=LENS_LE %>" type="text" value="<%=opdOphthalmology.getLensLe() %>" maxlength="20">
<%}else{ %>
<input name="<%=LENS_LE %>" type="text" value="" maxlength="20">
<%} %>
<div class="Clear"></div>
<label>Fundus</label> <label>&nbsp;</label> 
<%if(opdOphthalmology!=null && opdOphthalmology.getFundusRe()!=null){%>
<input name="<%=FUNDUS_RE %>" type="text" value="<%=opdOphthalmology.getFundusRe() %>" maxlength="20">
<%}else{ %>
<input name="<%=FUNDUS_RE %>" type="text" value="" maxlength="20">
<%}if(opdOphthalmology!=null && opdOphthalmology.getFundusLe()!=null){%>  
<input name="<%=FUNDUS_LE %>" type="text" value="<%= opdOphthalmology.getFundusLe()%>" maxlength="20">
<%}else{ %>
<input name="<%=FUNDUS_LE %>" type="text" value="" maxlength="20">
<%} %>
</div>
</div>
</div>

<div class="division"></div>

<input type="hidden" name="<%=HIN_ID %>" value="<%=visit.getHin().getId() %>"> 
<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> 
<input type="hidden" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> 
<input type="hidden" name="currentVisitId" value="<%=visit.getId() %>"> <!--Bottom labels starts-->
<div class="bottom">
<input name="Save" type="button" class="button" value="Submit" onclick="if(checkBlankForOphthalmology('opdOphthalmology')){submitForm('opdOphthalmology','opd?method=submitOphthalmologyDetails');}">
<input name="view" type="button" class="button" value="View" onclick="submitForm('opdOphthalmology','opd?method=viewPatientOphthalmologyDetails&flag=prev&viewScreen=no');">
<input name="reset" type="reset" class="button" value="Reset"></div>
<!--Bottom labels ends--> <script type="text/javascript">
function checkOption(obj){
	
	var field = eval('document.opdOphthalmology.'+obj.name);
	if(field.value == "normal"){
		if(obj.name == "selConvergence"){
			document.opdOphthalmology.<%=CONVERGENCE%>.value = "Normal";
		}
		if(obj.name == "selColorVision"){
			document.opdOphthalmology.<%=COLOR_VISION%>.value = "Normal";
		}
		if(obj.name == "selOcularMovements"){
			document.opdOphthalmology.<%=OCULAR_MOVEMENTS%>.value = "Normal";
		}
		if(obj.name == "selLids"){
			document.opdOphthalmology.<%=LIDS%>.value = "Normal";
		}
		if(obj.name == "selConjunctiva"){
			document.opdOphthalmology.<%=CONJUNCTIVA%>.value = "Normal";
		}
	
	}else if(field.value == "abnormal"){
		if(obj.name == "selConvergence"){
			document.opdOphthalmology.<%=CONVERGENCE%>.value = "";
		}
		if(obj.name == "selColorVision"){
			document.opdOphthalmology.<%=COLOR_VISION%>.value = "";
		}
		if(obj.name == "selOcularMovements"){
			document.opdOphthalmology.<%=OCULAR_MOVEMENTS%>.value = "";
		}
		if(obj.name == "selLids"){
			document.opdOphthalmology.<%=LIDS%>.value = "";
		}
		if(obj.name == "selConjunctiva"){
		 document.opdOphthalmology.<%=CONJUNCTIVA%>.value = "";
		}
	}
}

</script></form>
</div>
<!--main content placeholder ends here-->

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdOphthalmology"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>


<%--For AutoComplete Through Ajax--%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

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
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript">

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

</script>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<script type="text/javascript">

function patientVisitPrev()
{
	var visitNo =document.getElementById('visitNo').value;
	if(visitNo==1)
	{
		alert("Not Before Visit Number");
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
		alert("Not After Visit Number");
		return false;
	}
	return true;
	

}

</script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="ent" action="" method="post">
<h6>Ophthalmology Follow Up</h6>
<div class="Clear"></div>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	List<Visit> patientDataList = new ArrayList<Visit>();
	List<OpdOphthalmology> opdophList = new ArrayList<OpdOphthalmology>();
	
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	int max=0;
	if(map.get("max") != null){
		max = (Integer)map.get("max");
	}
	if(map.get("patientDataList") != null){
		patientDataList=(List<Visit>)map.get("patientDataList");
	}	
	if(map.get("opdophList") != null){
		opdophList=(List<OpdOphthalmology>)map.get("opdophList");
	}	
	int currentVisitId=0;
	if(map.get("currentVisitId") != null){
		currentVisitId = (Integer)map.get("currentVisitId");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
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


%> <!--Block One Starts-->

<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>

<label class="medium">Name </label> <%if(patientName!= null){ %> <label
	class="valuemedium" style="width: auto;"><%=patientName %> </label> <%}else{ %>
<label class="valuemedium">- </label> <%} %> <label class="medium">Service
No. </label> <%if(visit.getHin().getServiceNo()!= null){ %> <label
	class="valuemedium"><%=visit.getHin().getServiceNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">HIN
No. </label> <%if(visit.getHin().getHinNo()!= null){ %> <label class="valuemedium"><%=visit.getHin().getHinNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Rank</label> <%if(visit.getHin().getRank()!= null){ %> <label
	class="valuemedium"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>
<label class="medium">Age</label> <%if(visit.getHin().getAge()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getAge() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Unit
</label> <%if(visit.getHin().getUnit()!= null){ %> <label class="valuemedium"><%=visit.getHin().getUnit().getUnitName()%></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Visit Date <span>*</span></label> <%if(visitDateInString != null){ %>
<label class="valuemedium"><%=visitDateInString %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">Visit
no. <span>*</span></label> <%if(visit.getVisitNo()!= null){ %> <label
	class="valuemedium"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">Token
No. </label> <%if(visit.getTokenNo()!= null){ %> <label class="valueNoWidth"><%=visit.getTokenNo() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>
<div class="Clear"></div>

<div class="paddLeft55"><label class="noWidth">Trade/AF/Navy/Army
</label> <%if(visit.getHin().getTrade() != null){ %> <label class="noWidth"><%=visit.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="noWidth">-</label> <%} %> <label class="medium">DOA
</label> <%if(visitDateInString != null){ %> <label class="valuemedium"><%=visitDateInString %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="noWidth">Service Person Name </label> <%if(visit.getHin()!= null){ %>
<label class="valueNoWidth"><%=visit.getHin().getSFirstName()%><%=visit.getHin().getSLastName()%></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>
</div>
<div class="Clear"></div>



</div>

<!--Block one Ends--> <%
if(opdophList.size() > 0){
	
	OpdOphthalmology opht = new OpdOphthalmology();
	opht = opdophList.get(0);
%>
<input name="opdOphtId" type="hidden" value="<%=opht.getId() %>" />
	<!--Block Three Starts-->
<div class="colsHolder">

<div class="floatLeft"><input name="patient fast history"
	type="button" class="navButtons" value="Follow Up"
	onclick="submitForm('ent','/hms/hms/opd?method=showOphthalmologyFollowUpUpdateJsp');">
<input name="patient fast history3" type="button" class="navButtons"
	value="Retinal"
	onclick="submitForm('ent','/hms/hms/opd?method=showOphthalmologyRetinalUpdateJsp');">
<input name="patient fast history23" type="button" class="navButtons"
	value="Diagnosis"
	onclick="submitForm('ent','opd?method=showOphthalmologyDiagnosisUpdateJsp');">
</div>
<div class="floatRight">
<div class="blockFrameSm">
<div class="blockTitle">Symptoms &amp; Duration</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label>Decreased Vision</label> <input name="<%=DECREASED_VISION %>"
	type="text" value="<%=opht.getDecreasedVision()%>" maxlength="20"> 
	
	<label>Redness</label> <input
	name="<%=REDNESS %>" type="text" value="<%=opht.getRedness() %>" maxlength="20">
<div class="Clear"></div>
<label>Pain</label> <input name="<%=PAIN %>" type="text" value="<%=opht.getPain()%>"
	maxlength="20"> <label>Discharge</label> <input
	name="<%=DISCHARGE %>" type="text" value="<%=opht.getDischarge()%>" maxlength="20">
<div class="division"></div>
<label class="NoWidth">Floater/ Trauma/ Epiphora etc</label> <input
	name="<%=FLOATER_TRAUMA_EPIPHORA %>" type="text" value="<%=opht.getFloaterTraumaEpiphora()%>"
	maxlength="30">
<div class="division"></div>
<div class="blockTitle">Functional Assessment</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label>Reading</label> 
<%if(opht.getReading().equals("R")){
	
%>

<input name="<%=READING %>" type="checkbox"	value="R" class="checkbox" checked="checked">
<%}else{

%>
<input name="<%=READING %>" type="checkbox" value="R" class="checkbox"> 
<%} %>	
	
	<label>Driving</label> 
	<%if(opht.getDriving().equals("D")){%>

<input
	name="<%=DRIVING %>" type="checkbox" value="D" class="checkbox" checked="checked">
<%}else{%>
<input
	name="<%=DRIVING %>" type="checkbox" value="D" class="checkbox">
<%} %>	
		
	
	

<label>Cooking</label>

<%if(opht.getCooking().equals("C")){%>

<input name="<%=COOKING %>" type="checkbox" value="C" class="checkbox" checked="checked">
<%}else{%>
<input name="<%=COOKING %>" type="checkbox"	value="C" class="checkbox">
<%} %>	

<label>Ambulatory</label>
<%if(opht.getAmbulatry().equals("A")){%>
<input name="<%=AMBULATORY%>" type="checkbox" value="A" class="checkbox" checked="checked">
<%}else{%>
<input name="<%=AMBULATORY%>" type="checkbox" value="A" class="checkbox">
<%} %>


<div class="Clear"></div>

<label>Personal Hygiene</label> 
<%if(opht.getPersonalHygiene().equals("P")){%>
<input name="<%=PERSONAL_HYGIENE %>" type="checkbox" value="P" class="checkbox" checked="checked">
<%}else{%>
<input name="<%=PERSONAL_HYGIENE %>" type="checkbox" value="P" class="checkbox">
<%} %>


<div class="division"></div>

<div class="blockTitle">Treatment History</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label>DM</label> 
<%if(opht.getDm().equals("D")){%>
<input name="<%=DM%>" type="checkbox" value="D"	class="checkbox" checked="checked">
<%}else{%>
<input name="<%=DM%>" type="checkbox" value="D"	class="checkbox"> 
<%} %>

<label>HTN</label> 
<%if(opht.getHtn().equals("H")){%>
<input name="<%=HTN%>"	type="checkbox" value="H" class="checkbox" checked="checked">
<%}else{%>
<input name="<%=HTN%>"	type="checkbox" value="H" class="checkbox">
<%} %>



<label>Bronchial Asthma</label> 
<%if(opht.getBa().equals("B")){%>
<input name="<%=BA %>" type="checkbox" value="B" class="checkbox"  checked="checked">
<%}else{%>
<input name="<%=BA %>" type="checkbox" value="B" class="checkbox"> 
<%} %>


<label>CAD</label> 
<%if(opht.getCad().equals("C")){%>
<input name="<%=CAD%>" type="checkbox" value="C" class="checkbox" checked="checked">
<%}else{%>
<input name="<%=CAD%>" type="checkbox" value="C" class="checkbox"> 
<%} %>


<div class="Clear"></div>

<label>Autoimmune</label> 
<%if(opht.getAutoimmune().equals("A")){%>
<input name="<%=AUTOIMMUNE %>" type="checkbox" 	value="A" class="checkbox" checked="checked">
<%}else{%>
<input name="<%=AUTOIMMUNE %>" type="checkbox" 	value="A" class="checkbox">  
<%} %>


<label>Others</label> 
<%if(opht.getOthers().equals("O")){%>
<input name="<%=OTHERS %>" type="checkbox" value="O" class="checkbox" checked="checked">
<%}else{%>
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
<input name="<%=DISTANCE_RE %>" type="text" value="<%=opht.getDistanceRe() %>" maxlength="20"> <input
	name="<%=DISTANCE_LE %>" type="text" value="<%=opht.getDistanceLe() %>" maxlength="20"> <input
	name="<%=DISTANCE_PH %>" type="text" value="<%=opht.getDistancePh() %>" maxlength="20">
<div class="Clear"></div>
<label>Near</label> <label>&nbsp;</label> <input name="<%=NEAR_RE %>"
	type="text" value="<%=opht.getNearRe() %>" maxlength="20"> <input
	name="<%=NEAR_LE %>" type="text" value="<%=opht.getNearLe() %>" maxlength="20"> <input
	name="<%=NEAR_PH %>" type="text" value="<%=opht.getNearPh() %>" maxlength="20">
<div class="Clear"></div>
<label>Refraction</label> <label>&nbsp;</label> <input
	name="<%=REFRACTION_RE %>" type="text" value="<%=opht.getRefractionRe() %>"  maxlength="20">
<input name="<%=REFRACTION_LE %>" type="text"  value="<%=opht.getRefractionLe() %>"  maxlength="20">
<input name="<%=REFRACTION_PH %>" type="text"  value="<%=opht.getRefractionPh() %>"  maxlength="20">
<div class="Clear"></div>
<label>Acceptance</label> <label>Distance</label> <input
	name="<%=ACCEPTANCE_DISTANCE_RE %>" type="text"  value="<%=opht.getAcceptanceDistanceRe() %>"  maxlength="20">
<input name="<%=ACCEPTANCE_DISTANCE_LE %>" type="text" value="<%=opht.getAcceptanceDistanceLe() %>" 
	maxlength="20"> <input name="<%=ACCEPTANCE_DISTANCE_PH %>"
	type="text" value="<%=opht.getAcceptanceDistancePh() %>"  maxlength="20">
<div class="Clear"></div>
<label>&nbsp;</label> <label>Near</label> <input
	name="<%=ACCEPTANCE_NEAR_RE %>" type="text" value="<%=opht.getAcceptanceNearRe() %>" maxlength="20">
<input name="<%=ACCEPTANCE_NEAR_LE %>" type="text" value="<%=opht.getAcceptanceNearLe() %>"
	maxlength="20"> <input name="<%=ACCEPTANCE_NEAR_PH %>"
	type="text" value="<%=opht.getAcceptanceNearPh() %>" maxlength="20">

<div class="division"></div>
<label>Convergence</label> <label>&nbsp;</label> <select
	name="selConvergence" onchange="checkOption(this);">
	<option value="">Select</option>
	<option value="normal">Normal</option>
	<option value="abnormal">Abnormal</option>
</select> <input name="<%=CONVERGENCE %>" type="text" value="<%=opht.getConvergence() %>" maxlength="10">
<div class="Clear"></div>
<label>Color Vision </label> <label>&nbsp;</label> <select
	name="selColorVision" onchange="checkOption(this);">
	<option value="">Select</option>
	<option value="normal">Normal</option>
	<option value="abnormal">Abnormal</option>
</select> <input name="<%=COLOR_VISION %>" type="text" value="<%=opht.getColorVision() %>" maxlength="10">
<div class="Clear"></div>
<label>Ocular Movements </label> <label>&nbsp;</label> <select
	name="selOcularMovements" onchange="checkOption(this);">
	<option value="">Select</option>
	<option value="normal">Normal</option>
	<option value="abnormal">Abnormal</option>
</select> <input name="<%=OCULAR_MOVEMENTS %>" type="text" value="<%=opht.getOcularMovement() %>"
	maxlength="10">
<div class="Clear"></div>
<label>Lids</label> <label>&nbsp;</label> <select name="selLids"
	onchange="checkOption(this);">
	<option value="">Select</option>
	<option value="normal">Normal</option>
	<option value="abnormal">Abnormal</option>
</select> <input name="<%=LIDS %>" type="text" value="<%=opht.getLids() %>" maxlength="10">
<div class="Clear"></div>
<label>Conjunctiva</label> <label>&nbsp;</label> <select
	name="selConjunctiva" onchange="checkOption(this);">
	<option value="">Select</option>
	<option value="normal">Normal</option>
	<option value="abnormal">Abnormal</option>
</select> <input name="<%=CONJUNCTIVA %>" type="text" value="<%=opht.getConjunctiva() %>" maxlength="10">
<div class="Clear"></div>
<label>Cornea &amp; AC </label> <label>&nbsp;</label> <input
	name="<%=CORNEA_AC_RE %>" type="text" value="<%=opht.getCorneaAcRe() %>" maxlength="20">
<input name="<%=CORNEA_AC_LE %>" type="text" value="<%=opht.getCorneaAcLe() %>" maxlength="20">
<div class="division"></div>



<label>Ant chamber depth</label> <label>&nbsp;</label> <input
	name="<%=ANT_CHAMBER_RE %>" type="text" value="<%=opht.getAntChamberDepthRe() %>" maxlength="20">
<input name="<%=ANT_CHAMBER_LE %>" type="text" value="<%=opht.getAntChamberDepthLe() %>" maxlength="20">

<div class="Clear"></div>
<label>Cells/flare</label> <label>&nbsp;</label> <input
	name="<%=CELLS_FLARE_RE %>" type="text" value="<%=opht.getCellsFlareRe() %>" maxlength="20">
<input name="<%=CELLS_FLARE_LE %>" type="text" value="<%=opht.getCellsFlareLe() %>" maxlength="20">
<div class="Clear"></div>
<label>PXF/NVI</label> <label>&nbsp;</label> <input
	name="<%=PXF_NVI_RE %>" type="text" value="<%=opht.getPxfNviRe() %>" maxlength="20"> <input
	name="<%=PXF_NVI_LE %>" type="text" value="<%=opht.getPxfNviLe() %>" maxlength="20">
<div class="Clear"></div>

<label>Pupil Reaction </label> 

<label>Direct</label> 
<%if(opht.getPupilReactionDirect().equals("D")){%>
<input 	name="<%=DIRECT %>" type="checkbox" value="D" class="checkbox" checked="checked">
<%}else{%>
<input 	name="<%=DIRECT %>" type="checkbox" value="D" class="checkbox">
<%} %>


<label>Consensnal</label> 
<%if(opht.getPupilReactionConsensnal().equals("C")){%>
<input name="<%=CONSENSNAL %>" type="checkbox" 	value="C" class="checkbox" checked="checked">
<%}else{%>
<input name="<%=CONSENSNAL %>" type="checkbox" 	value="C" class="checkbox"> 
<%} %>


<label>RAPD</label> 
<%if(opht.getPupilReactionRapd().equals("P")){%>
<input name="<%=RAPD%>" type="checkbox" value="P" class="checkbox" checked="checked">
<%}else{%>
<input name="<%=RAPD%>" type="checkbox" value="P" class="checkbox">
<%} %>

<div class="Clear"></div>
<label>Gonioscopy </label> 
<label>&nbsp;</label> 

<input name="<%=GONIOSCOPY_RE %>" type="text" value="<%=opht.getGonioscopyRe() %>" maxlength="20">
<input name="<%=GONIOSCOPY_LE %>" type="text" value="<%=opht.getGonioscopyLe() %>" maxlength="20">


<div class="Clear"></div>
<label>IOP(months)</label> <label>&nbsp;</label> <input
	name="<%=IOP_RE %>" type="text" value="<%=opht.getIopRe() %>" maxlength="20"> <input
	name="<%=IOP_LE %>" type="text" value="<%=opht.getIopLe() %>" maxlength="20">
<div class="division"></div>
<h5>Sac</h5>
<div class="Clear"></div>
<label>Papillary Dilatation </label> <label>&nbsp;</label> <input
	name="<%=DILATION_RE %>" type="text" value="<%=opht.getDilationRe() %>" class="small"
	maxlength="20"> <input name="<%=DILATION_LE %>" type="text"
	value="<%=opht.getDilationLe() %>" class="small" maxlength="20">
<div class="Clear"></div>
<label>Lens </label> <label>&nbsp;</label> <input name="<%=LENS_RE %>"
	type="text" value="<%=opht.getLensRe() %>" maxlength="20"> <input
	name="<%=LENS_LE %>" type="text" value="<%=opht.getLensLe() %>" maxlength="20">
<div class="Clear"></div>
<label>Fundus</label> <label>&nbsp;</label> <input
	name="<%=FUNDUS_RE %>" type="text" value="<%=opht.getFundusRe() %>" maxlength="20"> <input
	name="<%=FUNDUS_LE %>" type="text" value="<%=opht.getFundusLe() %>" maxlength="20"></div>
</div>
</div>

<div class="division"></div>

<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> 
	<input type="hidden" 	name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> <input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="currentVisitId" value="<%=visit.getId() %>"> <!--Bottom labels starts-->




<div class="Clear"></div>
<input name="prev" type="button" class="button" value="Update" onclick="submitForm('ent','opd?method=updateOpdOpht');"> <%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('ent','<%=url%>');" align="right" /></div>
<%}%>


<!--Bottom labels ends--> <script type="text/javascript">
function checkOption(obj){
	
	var field = eval('document.ent.'+obj.name);
	if(field.value == "normal"){
		if(obj.name == "selConvergence"){
			document.ent.<%=CONVERGENCE%>.value = "Normal";
		}
		if(obj.name == "selColorVision"){
			document.ent.<%=COLOR_VISION%>.value = "Normal";
		}
		if(obj.name == "selOcularMovements"){
			document.ent.<%=OCULAR_MOVEMENTS%>.value = "Normal";
		}
		if(obj.name == "selLids"){
			document.ent.<%=LIDS%>.value = "Normal";
		}
		if(obj.name == "selConjunctiva"){
			document.ent.<%=CONJUNCTIVA%>.value = "Normal";
		}
	
	}else if(field.value == "abnormal"){
		if(obj.name == "selConvergence"){
			document.ent.<%=CONVERGENCE%>.value = "";
		}
		if(obj.name == "selColorVision"){
			document.ent.<%=COLOR_VISION%>.value = "";
		}
		if(obj.name == "selOcularMovements"){
			document.ent.<%=OCULAR_MOVEMENTS%>.value = "";
		}
		if(obj.name == "selLids"){
			document.ent.<%=LIDS%>.value = "";
		}
		if(obj.name == "selConjunctiva"){
			document.ent.<%=CONJUNCTIVA%>.value = "";
		}
	}
}

</script>
<%}%>

<div class="division"></div>

</form>
</div>

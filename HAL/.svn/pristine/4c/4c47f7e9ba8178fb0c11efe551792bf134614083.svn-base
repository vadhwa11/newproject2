<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdEnt"%>
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
<h6>OPD ENT</h6>
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
	List<OpdEnt> entList = new ArrayList<OpdEnt>();
	
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	int max=0;
	if(map.get("max") != null){
		max = (Integer)map.get("max");
	}
	if(detailsMap.get("patientDataList") != null){
		patientDataList=(List<Visit>)detailsMap.get("patientDataList");
	}	
	if(map.get("entList") != null){
		entList=(List<OpdEnt>)map.get("entList");
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
if(entList.size() > 0){
	
	OpdEnt ent = new OpdEnt();
	ent = entList.get(0);
%>
<div class="Clear"></div>

<!--Block two Start-->

<div class="blockTitle">Brief History</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>



<div class="blockFrame">
<div class="Clear"></div>
<label>Otorrhoea</label> <input name="<%=OTORRHOEA %>" type="text"
	maxlength="20" value="<%=ent.getOtorrhora() %>" readonly="readonly" />

<label>Hearing Loss</label> <input name="<%=HEARING_LOSS %>" type="text"
	maxlength="20" value="<%=ent.getHearingLoss() %>" readonly="readonly" />

<label>Otalgia</label> <input name="<%=OTALGIA %>" type="text"
	maxlength="20" value="<%=ent.getOtalgia() %>" readonly="readonly" />


<div class="Clear"></div>
<label>Sneezing</label> <input name="<%=SNEEZING %>" type="text"
	maxlength="20" value="<%=ent.getSneezing() %>" readonly="readonly" />

<label>Nasal Obstructions</label> <input name="<%=NASAL_OBSTRUCTIONS %>"
	type="text" maxlength="20" value="<%=ent.getNasalObstructions() %>"
	readonly="readonly" /> <label>Rhinorrhoea</label> <input
	name="<%=RHINORRHOEA %>" type="text" maxlength="20"
	value="<%=ent.getRhinorrhoea() %>" readonly="readonly" />
<div class="Clear"></div>

<label>Epistaxis</label> <input name="<%=EPISTAXIS %>" type="text"
	maxlength="20" value="<%=ent.getEpistaxis() %>" readonly="readonly" />

<label>Facial Pain</label> <input name="<%=FACIAL_PAIN %>" type="text"
	maxlength="20" value="<%=ent.getFacialPain() %>" readonly="readonly" />

<label>Dysphagia</label> <input name="<%=DYSPHAGIA %>" type="text"
	maxlength="20" value="<%=ent.getDysphagia() %>" readonly="readonly" />
<div class="Clear"></div>
<label>Odynophagia</label> <input name="<%=ODYNOPHAGIA %>" type="text"
	maxlength="20" value="<%=ent.getOdynophagia() %>" readonly="readonly" />

<label>Hoarseness</label> <input name="<%=HOARSENESS %>" type="text"
	maxlength="20" value="<%=ent.getHoarseness() %>" readonly="readonly" />

<label>Others</label> <input name="<%=OTHERS_ENT %>" type="text"
	maxlength="20" value="<%=ent.getOthersEnt() %>" readonly="readonly" />
<div class="Clear"></div>
</div>
<div class="division"></div>
<label class="common">General Examination</label> <input type="text"
	value="Normal" name="<%=GENERAL_EXAMINATION %>" maxlength="50"
	value="<%=ent.getGeneralExamination() %>" readonly="readonly" />
<div class="division"></div>
<div class="blockTitle">ENT Examination</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<div class="header">
<div class="paddLeft25">
<h5><u>EAR</u></h5>
</div>
<label></label>
<div class="paddLeft25"><label>RE</label></div>
<label></label>
<div class=""><label>LE</label></div>
</div>

<div class="Clear"></div>

<label>Pre &amp; Post Auricular Pinna</label> <label></label> <input
	type="text" class="calDate" name="<%=PRE_POST_RE %>" maxlength="20"
	value="<%=ent.getPrePostRe() %>" readonly="readonly" /> <label></label>
<input type="text" class="calDate" name="<%=PRE_POST_LE %>"
	maxlength="20" value="<%=ent.getPrePostLe() %>" readonly="readonly" />

<div class="Clear"></div>
<div class="Height10"></div>

<label> EAC </label> <label></label> <input type="text" class="calDate"
	name="<%=EAC_RE %>" maxlength="20" value="<%=ent.getEacRe() %>"
	readonly="readonly" /> <label></label> <input type="text"
	class="calDate" name="<%=EAC_LE %>" maxlength="20"
	value="<%=ent.getEacLe() %>" readonly="readonly" />

<div class="Clear"></div>
<label> TM </label> <label></label> <input type="text" class="calDate"
	name="<%=TM_RE %>" maxlength="20" value="<%=ent.getTmRe() %>"
	readonly="readonly" /> <label></label> <input type="text"
	class="calDate" name="<%=TM_LE %>" maxlength="20"
	value="<%=ent.getTmLe() %>" readonly="readonly" />

<div class="Clear"></div>
<div class="paddLeft55">
<h5>TFT</h5>
</div>
<div class="Clear"></div>
<label>Rinne's</label>
<div class="Clear"></div>
<label class="Sublable">256</label> <label></label> <%if(ent.getTftReTwoFiveSex().equals("+"))
{%> <label class="value">Positive</label> <%}else if(ent.getTftReTwoFiveSex().equals("-"))  {%>

<label class="value">Negative </label> <%}else{ %> <label class="value">
- </label> <%} %> <label></label> <%if(ent.getTftLeTwoFiveSex().equals("+"))
{%> <label class="value">Positive</label> <%}else if(ent.getTftLeTwoFiveSex().equals("-"))  {%>

<label class="value">Negative </label> <%}else{ %> <label class="value">
- </label> <%} %>
<div class="Clear"></div>
<label class="Sublable">512</label> <label></label> <%if(ent.getTftReFiveOneTwo().equals("+"))
{%> <label class="value">Positive</label> <%}else if(ent.getTftReFiveOneTwo().equals("-"))  {%>

<label class="value">Negative </label> <%}else{ %> <label class="value">
- </label> <%} %> <label></label> <%if(ent.getTftLeFiveOneTwo().equals("+"))
{%> <label class="value">Positive</label> <%}else if(ent.getTftLeFiveOneTwo().equals("-"))  {%>

<label class="value">Negative </label> <%}else{ %> <label class="value">
- </label> <%} %>
<div class="Clear"></div>
<label class="Sublable">1024</label> <label></label> <%if(ent.getTftReTenTwoFour().equals("+"))
{%> <label class="value">Positive</label> <%}else if(ent.getTftReTenTwoFour().equals("-"))  {%>

<label class="value">Negative </label> <%}else{ %> <label class="value">
- </label> <%} %> <label></label> <%if(ent.getTftLeTenTwoFour().equals("+"))
{%> <label class="value">Positive</label> <%}else if(ent.getTftLeTenTwoFour().equals("-"))  {%>

<label class="value">Negative </label> <%}else{ %> <label class="value">
- </label> <%} %>
<div class="Clear"></div>
<label>Weber's</label> <label></label> <%if(ent.getTftReWeber().equals("+"))
{%> <label class="value">Positive</label> <%}else if(ent.getTftReWeber().equals("-"))  {%>

<label class="value">Negative </label> <%}else{ %> <label class="value">
- </label> <%} %> <label></label> <%if(ent.getTftLeWeber().equals("+"))
{%> <label class="value">Positive</label> <%}else if(ent.getTftLeWeber().equals("-"))  {%>

<label class="value">Negative </label> <%}else{ %> <label class="value">
- </label> <%} %>
<div class="Clear"></div>
<label>ABC</label> <label></label> <input type="text" class="calDate"
	name="<%=ABC_RE %>" value="<%=ent.getTftReAbc() %>" maxlength="20"
	readonly="readonly" /> <label></label> <input type="text"
	class="calDate" name="<%=ABC_LE %>" value="<%=ent.getTftLeAbc() %>"
	maxlength="20" readonly="readonly" />
<div class="Clear"></div>
<div class="paddLeft55">
<h5>FFH</h5>
</div>
<div class="Clear"></div>
<label>CV</label> <label></label> <input type="text" class="calDate"
	name="<%=FFH_CV_RE %>" maxlength="4" value="<%=ent.getFfhReCv() %>"
	validate="CV Re,num,no" readonly="readonly" /> <label class="unit">cm</label>
<label></label>
<div class="paddLeft25"><input type="text" class="calDate"
	name="<%=FFH_CV_LE %>" maxlength="4" value="<%=ent.getFfhLeCv() %>"
	validate="CV Le,num,no" readonly="readonly" /> <label class="unit">cm</label>
</div>
<div class="Clear"></div>
<label>FW</label> <label></label> <input type="text" class="calDate"
	name="<%=FFH_FW_RE %>" maxlength="4" value="<%=ent.getFfhReFw() %>"
	validate="FW Re,num,no" readonly="readonly" /> <label class="unit">cm</label>
<label></label>
<div class="paddLeft25"><input type="text" class="calDate"
	name="<%=FFH_FW_LE %>" maxlength="4" value="<%=ent.getFfhLeFw() %>"
	validate="FW Le,num,no" readonly="readonly" /> <label class="unit">cm</label>
</div>
<div class="Clear"></div>
<div class="paddLeft55">
<h5>PTA</h5>
</div>
<div class="Clear"></div>
<label>AC</label> <label></label> <input type="text" class="calDate"
	name="<%=PTA_AC_RE %>" maxlength="3" value="<%=ent.getPtaReAc() %>"
	validate="AC RE,num,no" readonly="readonly" /> <label class="unit">db</label>
<label></label>
<div class="paddLeft25"><input type="text" class="calDate"
	name="<%=PTA_AC_LE %>" maxlength="3" value="<%=ent.getPtaLeAc() %>"
	validate="AC Le,num,no" readonly="readonly" /> <label class="unit">db</label>
</div>
<div class="Clear"></div>
<label>BC</label> <label></label> <input type="text" class="calDate"
	name="<%=PTA_BC_RE %>" maxlength="3" value="<%=ent.getPtaReBc() %>"
	validate="BC Re,num,no" readonly="readonly" /> <label class="unit">db</label>
<label></label>
<div class="paddLeft25"><input type="text" class="calDate"
	name="<%=PTA_BC_LE %>" maxlength="3" value="<%=ent.getPtaLeBc() %>"
	validate="BC Le,num,no" readonly="readonly" /> <label class="unit">db</label>
</div>
<div class="Clear"></div>
<label>AB Gap </label> <label></label> <input type="text"
	class="calDate" name="<%=PTA_AB_GAP_RE %>" maxlength="3"
	value="<%=ent.getPtaReAbGap() %>" validate="AB Gap Re,num,no"
	readonly="readonly" /> <label class="unit">db</label> <label></label>
<div class="paddLeft25"><input type="text" class="calDate"
	name="<%=PTA_AB_GAP_LE %>" maxlength="3"
	value="<%=ent.getPtaLeAbGap() %>" validate="AB Gap Le,num,no"
	readonly="readonly" /> <label class="unit">db</label></div>
<div class="Clear"></div>
<label>Impedance<br readonly="readonly" />
Audiometry</label> <label></label> <input type="text" class="calDate"
	name="<%=IMPLEDANCE_AUDIOMEETRY_RE %>"
	value="<%=ent.getImpedenceAudiometryEarRe() %>" maxlength="20"
	readonly="readonly" /> <label></label> <input type="text"
	class="calDate" name="<%=IMPLEDANCE_AUDIOMEETRY_LE %>"
	value="<%=ent.getImpedenceAudiometryEarLe() %>" maxlength="20"
	readonly="readonly" />
<div class="Clear"></div>
<div class="Height10"></div>
<div class="paddLeft55">
<h5>Otoneurological Exams</h5>
</div>
<div class="Clear"></div>
<label>No Spontaneous/ Induced Nystagmus</label> <label></label> <input
	type="text" class="calDate" name="<%=NO_SPONTSNEOUS_RE %>"
	value="<%=ent.getNoSpontaneousRe() %>" maxlength="20"
	readonly="readonly" /> <label></label> <input type="text"
	class="calDate" name="<%=NO_SPONTSNEOUS_LE %>"
	value="<%=ent.getNoSpontaneousLe() %>" maxlength="20"
	readonly="readonly" />
<div class="Clear"></div>
<div class="Height10"></div>

<div class="Clear"></div>
<label>Fistula Test </label> <label></label> <label class="value"><%=ent.getFistualtestRe() %></label>
<label></label> <label class="value"><%=ent.getFistualtestLe() %></label>
<div class="Clear"></div>
<label>Romberg's Test </label> <label></label> <label class="value"><%=ent.getRombergRe() %></label>
<label></label> <label class="value"><%=ent.getRombergLe() %></label>
<div class="Clear"></div>

<label>No Cerebellar</label> <label></label> <input
	name="<%=NO_CEREBELLAR %>" type="text"
	value="<%=ent.getNoCerebellarSign() %>" maxlength="100"
	readonly="readonly" /> <label></label>
<div class="Clear"></div>
<div class="header">
<div class="paddLeft25">
<h5><u>NOSE</u></h5>
</div>
<label></label>
<div class="paddLeft25"><label>RE</label></div>
<label></label>
<div class=""><label>LE</label></div>
</div>
<div class="Clear"></div>
<label>External Nasal Framework</label><label></label> <label
	class="value"><%=ent.getExternalNasalFrameworkRe() %></label> <label></label>
<label class="value"><%=ent.getExternalNasalFrameworkLe() %></label>
<div class="Height10"></div>
<div class="Clear"></div>
<label>Ant Rhinoscopy </label> <label></label> <label class="value"><%=ent.getAntRhinoscopyRe() %></label>
<label></label> <select name="<%=ANT_RHINOSCOPY_LE %>">
	<label class="value"><%=ent.getAntRhinoscopyLe() %></label>



	<div class="Clear"></div>
	<label>Post Rhinoscopy </label>
	<label></label>
	<input name="<%=POST_RHINOSCOPY_RE %>" type="text"
		value="<%=ent.getPostRhinoscopyRe() %>" maxlength="20"
		readonly="readonly" />
	<label></label>
	<input name="<%=POST_RHINOSCOPY_LE %>" type="text"
		value="<%=ent.getPostRhinoscopyLe() %>" maxlength="20"
		readonly="readonly" />
	<div class="Clear"></div>
	<div class="header">
	<div class="paddLeft25">
	<h5><u>Throat</u></h5>
	</div>
	</div>
	<div class="Clear"></div>
	<label> Oral Cavity </label>
	<label></label>
	<input name="<%=ORAL_CAVITY %>" type="text"
		value="<%=ent.getOralCavity() %>" maxlength="20" readonly="readonly" />
	<div class="Clear"></div>
	<label> OralPharynx </label>
	<label></label>
	<input name="<%=ORAL_PHATYNX %>" type="text"
		value="<%=ent.getOroPharynx() %>" maxlength="20" readonly="readonly" />
	<div class="Clear"></div>
	<label> IDL </label>
	<label></label>
	<input name="<%=IDL %>" type="text" value="<%=ent.getIdlThroat() %>"
		maxlength="20" readonly="readonly" />
	<div class="Clear"></div>
	<div class="header">
	<div class="paddLeft25">
	<h5><u>Neck</u></h5>
	</div>
	</div>
	<div class="Clear"></div>
	<label> Neck </label>
	<label></label>
	<input name="<%=NECK %>" type="text" value="<%=ent.getNeck() %>"
		maxlength="20" readonly="readonly" />
	<div class="Clear"></div>
	<h5>Diagnosis</h5>
	<div class="Clear"></div>
	<label> Surgery </label>
	<label></label>
	<input name="<%=SURGERY %>" type="text" value="<%=ent.getSurgery() %>"
		maxlength="20" readonly="readonly" />
	<div class="Clear"></div>
	<label> Post OP </label>
	<label></label>
	<input name="<%=POST_OP %>" type="text" value="<%=ent.getPostOp() %>"
		maxlength="20" readonly="readonly" />
	<div class="Clear"></div>
	<label> Advice </label>
	<label></label>
	<label class="value"><%=ent.getAdvice() %></label>

	<div class="division"></div>
	<input type="hidden" name="<%=HIN_ID %>"
		value="<%=visit.getHin().getId() %>">
	<input type="hidden" name="<%=DEPARTMENT_ID %>"
		value="<%=visit.getDepartment().getId() %>" />
	<input type="hidden" id="visitNo" name="<%=VISIT_NUMBER %>"
		value="<%=visit.getVisitNo() %>">
	<input type="hidden" id="currentVisitId" name="currentVisitId"
		value="<%=currentVisitId %>">
	<input type="hidden" id="max" name="max" value="<%=max %>">
	<input type="hidden" id="visitId" value="<%=visit.getId() %>">
	<!--Bottom labels starts-->
	<div class="bottom"><label>Changed By:</label> <label
		class="value"><%=userName %></label> <label>Changed Date:</label> <label
		class="value"><%=date%></label> <label>Changed Time:</label> <label
		class="value"><%=time%></label>

	<div class="Clear"></div>
	<input name="prev" type="button" class="button" value="Prev"
		onclick="submitForm('ent','opd?method=viewEnt&flag=prev','patientVisitPrev');">
	<input name="next" type="button" class="button" value="Next"
		onclick="submitForm('ent','opd?method=viewEnt&flag=next','patientVisitNext');">
	<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <input name="Back" type="button" src="images/phaseII/delete.gif"
		alt="Back" value="Back" class="button"
		onclick="submitForm('ent','<%=url%>');" align="right" /></div>
	<%}%>
</div>

<!--Bottom labels ends--> <%}else{%> <label style="width: auto;"><span>No
Record Found!!</span></label>
<div class="Clear"></div>
<div class="bottom"><input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	id="visitNo" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>">
<input type="hidden" id="currentVisitId" name="currentVisitId"
	value="<%=currentVisitId %>"> <input type="hidden" id="visitId"
	value="<%=visit.getId() %>"> <input type="hidden" id="max"
	name="max" value="<%=max %>"> <input name="prev" type="button"
	class="button" value="Prev"
	onclick="submitForm('ent','opd?method=viewEnt&flag=prev','patientVisitPrev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('ent','opd?method=viewEnt&flag=next','patientVisitNext');">
<input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('ent','opd?method=showEntJsp&visitId=<%=visit.getId() %>');"
	align="right" /></div>
</div>
<!--Bottom labels ends-->
<%} %>

<div class="division"></div>
</form>
</div>

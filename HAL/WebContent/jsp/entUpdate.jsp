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
	if(map.get("patientDataList") != null){
		patientDataList=(List<Visit>)map.get("patientDataList");
	}	
	if(map.get("opdEntList") != null){
		entList=(List<OpdEnt>)map.get("opdEntList");
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

<input name="<%=ENT_ID%>" type="hidden" value="<%=ent.getId() %>" />

<div class="blockFrame">
<div class="Clear"></div>
<label>Otorrhoea</label> <input name="<%=OTORRHOEA %>" type="text"
	maxlength="20" value="<%=ent.getOtorrhora() %>" /> <label>Hearing
Loss</label> <input name="<%=HEARING_LOSS %>" type="text" maxlength="20"
	value="<%=ent.getHearingLoss() %>" /> <label>Otalgia</label> <input
	name="<%=OTALGIA %>" type="text" maxlength="20"
	value="<%=ent.getOtalgia() %>" />


<div class="Clear"></div>
<label>Sneezing</label> <input name="<%=SNEEZING %>" type="text"
	maxlength="20" value="<%=ent.getSneezing() %>" /> <label>Nasal
Obstructions</label> <input name="<%=NASAL_OBSTRUCTIONS %>" type="text"
	maxlength="20" value="<%=ent.getNasalObstructions() %>" /> <label>Rhinorrhoea</label>
<input name="<%=RHINORRHOEA %>" type="text" maxlength="20"
	value="<%=ent.getRhinorrhoea() %>" />
<div class="Clear"></div>

<label>Epistaxis</label> <input name="<%=EPISTAXIS %>" type="text"
	maxlength="20" value="<%=ent.getEpistaxis() %>" /> <label>Facial
Pain</label> <input name="<%=FACIAL_PAIN %>" type="text" maxlength="20"
	value="<%=ent.getFacialPain() %>" /> <label>Dysphagia</label> <input
	name="<%=DYSPHAGIA %>" type="text" maxlength="20"
	value="<%=ent.getDysphagia() %>" />
<div class="Clear"></div>
<label>Odynophagia</label> <input name="<%=ODYNOPHAGIA %>" type="text"
	maxlength="20" value="<%=ent.getOdynophagia() %>" /> <label>Hoarseness</label>
<input name="<%=HOARSENESS %>" type="text" maxlength="20"
	value="<%=ent.getHoarseness() %>" /> <label>Others</label> <input
	name="<%=OTHERS_ENT %>" type="text" maxlength="20"
	value="<%=ent.getOthersEnt() %>" />
<div class="Clear"></div>
</div>
<div class="division"></div>
<label class="common">General Examination</label> <input type="text"
	value="Normal" name="<%=GENERAL_EXAMINATION %>" maxlength="50"
	value="<%=ent.getGeneralExamination() %>" />
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
	value="<%=ent.getPrePostRe() %>" /> <label></label> <input
	type="text" class="calDate" name="<%=PRE_POST_LE %>" maxlength="20"
	value="<%=ent.getPrePostLe() %>" />

<div class="Clear"></div>
<div class="Height10"></div>

<label> EAC </label> <label></label> <input type="text" class="calDate"
	name="<%=EAC_RE %>" maxlength="20" value="<%=ent.getEacRe() %>" /> <label></label>
<input type="text" class="calDate" name="<%=EAC_LE %>" maxlength="20"
	value="<%=ent.getEacLe() %>" />

<div class="Clear"></div>
<label> TM </label> <label></label> <input type="text" class="calDate"
	name="<%=TM_RE %>" maxlength="20" value="<%=ent.getTmRe() %>" /> <label></label>
<input type="text" class="calDate" name="<%=TM_LE %>" maxlength="20"
	value="<%=ent.getTmLe() %>" />

<div class="Clear"></div>
<div class="paddLeft55">
<h5>TFT</h5>
</div>
<div class="Clear"></div>
<label>Rinne's</label>
<div class="Clear"></div>
<label class="Sublable">256</label> <label style="width: 60px;"></label>
<select name="<%=TFT_RE_TWO_FIVE_SIX %>" id="<%=TFT_RE_TWO_FIVE_SIX %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <label></label> <%if(ent.getTftReTwoFiveSex().equals("+"))
{%> <script type="text/javascript">
	document.getElementById('<%=TFT_RE_TWO_FIVE_SIX %>').value='+';  
  </script> <%}else if(ent.getTftReTwoFiveSex().equals("-"))  {%> <script
	type="text/javascript">
  	document.getElementById('<%=TFT_RE_TWO_FIVE_SIX %>').value='-';
  </script> <%} %> <select name="<%=TFT_LE_TWO_FIVE_SIX %>"
	id="<%=TFT_LE_TWO_FIVE_SIX %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select>
<div class="Clear"></div>

<%if(ent.getTftLeTwoFiveSex().equals("+"))
{%> <script type="text/javascript">
	document.getElementById('<%=TFT_LE_TWO_FIVE_SIX %>').value='+';  
  </script> <%}else if(ent.getTftLeTwoFiveSex().equals("-"))  {%> <script
	type="text/javascript">
	document.getElementById('<%=TFT_LE_TWO_FIVE_SIX %>').value='+';  
  </script> <%} %>
<div class="Clear"></div>

<label class="Sublable">512</label> <label style="width: 60px;"></label>
<select name="<%=TFT_RE_FIVE_ONE_TWO %>" id="<%=TFT_RE_FIVE_ONE_TWO %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <%if(ent.getTftReFiveOneTwo().equals("+"))
{%> <script type="text/javascript">
	document.getElementById('<%=TFT_RE_FIVE_ONE_TWO %>').value='+';  
  </script> <%}else if(ent.getTftReFiveOneTwo().equals("-"))  {%> <script
	type="text/javascript">
	document.getElementById('<%=TFT_RE_FIVE_ONE_TWO %>').value='-';  
  </script> <%}%> <label></label> <select name="<%=TFT_LE_FIVE_ONE_TWO %>"
	id="<%=TFT_LE_FIVE_ONE_TWO %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <%if(ent.getTftLeFiveOneTwo().equals("+"))
{%> <script type="text/javascript">
	document.getElementById('<%=TFT_LE_FIVE_ONE_TWO %>').value='+';  
  </script> <%}else if(ent.getTftLeFiveOneTwo().equals("-"))  {%> <script
	type="text/javascript">
	document.getElementById('<%=TFT_LE_FIVE_ONE_TWO %>').value='-';  
  </script> <%}%>
<div class="Clear"></div>

<label class="Sublable">1024</label> <label style="width: 60px;"></label>
<select name="<%=TFT_RE_TEN_TWO_FOUR %>" id="<%=TFT_RE_TEN_TWO_FOUR %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <%if(ent.getTftReTenTwoFour().equals("+"))
{%> <script type="text/javascript">
	document.getElementById('<%=TFT_RE_TEN_TWO_FOUR %>').value='+';  
  </script> <%}else if(ent.getTftReTenTwoFour().equals("-"))  {%> <script
	type="text/javascript">
	document.getElementById('<%=TFT_RE_TEN_TWO_FOUR %>').value='-';  
  </script> <%}%> <label></label> <select name="<%=TFT_LE_TEN_TWO_FOUR %>"
	id="<%=TFT_LE_TEN_TWO_FOUR %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <%if(ent.getTftLeTenTwoFour().equals("+"))
{%> <script type="text/javascript">
	document.getElementById('<%=TFT_LE_TEN_TWO_FOUR %>').value='+';  
  </script> <%}else if(ent.getTftLeTenTwoFour().equals("-"))  {%> <script
	type="text/javascript">
	document.getElementById('<%=TFT_LE_TEN_TWO_FOUR %>').value='-';  
  </script> <%}%>
<div class="Clear"></div>
<label>Weber's</label> <label></label> <select name="<%=TFT_RE_WEDER %>"
	id="<%=TFT_RE_WEDER %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <%if(ent.getTftReWeber().equals("+"))
{%> <script type="text/javascript">
	document.getElementById('<%=TFT_RE_WEDER %>').value='+';  
  </script> <%}else if(ent.getTftReWeber().equals("-"))  {%> <script
	type="text/javascript">
	document.getElementById('<%=TFT_RE_WEDER %>').value='-';  
  </script> <%}%> <label></label> <select name="<%=TFT_LE_WEDER %>"
	id="<%=TFT_LE_WEDER %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <%if(ent.getTftLeWeber().equals("+"))
{%> <script type="text/javascript">
	document.getElementById('<%=TFT_LE_WEDER %>').value='+';  
  </script> <%}else if(ent.getTftLeWeber().equals("-"))  {%> <script
	type="text/javascript">
	document.getElementById('<%=TFT_LE_WEDER %>').value='-';  
  </script> <%}%>
<div class="Clear"></div>

<label>ABC</label> <label></label> <input type="text"
	name="<%=ABC_RE %>" value="<%=ent.getTftReAbc() %>" maxlength="20" />
<label></label> <input type="text" name="<%=ABC_LE %>"
	value="<%=ent.getTftLeAbc() %>" maxlength="20" />

<div class="Clear"></div>
<div class="paddLeft55">
<h5>FFH</h5>
</div>
<div class="Clear"></div>
<label>CV</label> <label></label> <input type="text" class="calDate"
	name="<%=FFH_CV_RE %>" maxlength="4" value="<%=ent.getFfhReCv() %>"
	validate="CV Re,num,no" /> <label class="unit">cm</label> <label></label>
<div class="paddLeft25"><input type="text" class="calDate"
	name="<%=FFH_CV_LE %>" maxlength="4" value="<%=ent.getFfhLeCv() %>"
	validate="CV Le,num,no" /> <label class="unit">cm</label></div>
<div class="Clear"></div>
<label>FW</label> <label></label> <input type="text" class="calDate"
	name="<%=FFH_FW_RE %>" maxlength="4" value="<%=ent.getFfhReFw() %>"
	validate="FW Re,num,no" /> <label class="unit">cm</label> <label></label>
<div class="paddLeft25"><input type="text" class="calDate"
	name="<%=FFH_FW_LE %>" maxlength="4" value="<%=ent.getFfhLeFw() %>"
	validate="FW Le,num,no" /> <label class="unit">cm</label></div>
<div class="Clear"></div>
<div class="paddLeft55">
<h5>PTA</h5>
</div>
<div class="Clear"></div>
<label>AC</label> <label></label> <input type="text" class="calDate"
	name="<%=PTA_AC_RE %>" maxlength="3" value="<%=ent.getPtaReAc() %>"
	validate="AC RE,num,no" /> <label class="unit">db</label> <label></label>
<div class="paddLeft25"><input type="text" class="calDate"
	name="<%=PTA_AC_LE %>" maxlength="3" value="<%=ent.getPtaLeAc() %>"
	validate="AC Le,num,no" /> <label class="unit">db</label></div>
<div class="Clear"></div>
<label>BC</label> <label></label> <input type="text" class="calDate"
	name="<%=PTA_BC_RE %>" maxlength="3" value="<%=ent.getPtaReBc() %>"
	validate="BC Re,num,no" /> <label class="unit">db</label> <label></label>
<div class="paddLeft25"><input type="text" class="calDate"
	name="<%=PTA_BC_LE %>" maxlength="3" value="<%=ent.getPtaLeBc() %>"
	validate="BC Le,num,no" /> <label class="unit">db</label></div>
<div class="Clear"></div>
<label>AB Gap </label> <label></label> <input type="text"
	class="calDate" name="<%=PTA_AB_GAP_RE %>" maxlength="3"
	value="<%=ent.getPtaReAbGap() %>" validate="AB Gap Re,num,no" /> <label
	class="unit">db</label> <label></label>
<div class="paddLeft25"><input type="text" class="calDate"
	name="<%=PTA_AB_GAP_LE %>" maxlength="3"
	value="<%=ent.getPtaLeAbGap() %>" validate="AB Gap Le,num,no" /> <label
	class="unit">db</label></div>
<div class="Clear"></div>
<label>Impedance<br />
Audiometry</label> <label></label> <input type="text" class="calDate"
	name="<%=IMPLEDANCE_AUDIOMEETRY_RE %>"
	value="<%=ent.getImpedenceAudiometryEarRe() %>" maxlength="20" /> <label></label>
<div class="paddLeft25" style="padding-left: 38px;"><input
	type="text" class="calDate" name="<%=IMPLEDANCE_AUDIOMEETRY_LE %>"
	value="<%=ent.getImpedenceAudiometryEarLe() %>" maxlength="20" /></div>
<div class="Clear"></div>
<div class="Height10"></div>
<div class="paddLeft55">
<h5>Otoneurological Exams</h5>
</div>
<div class="Clear"></div>
<label>No Spontaneous/ Induced Nystagmus</label> <label></label> <input
	type="text" class="calDate" name="<%=NO_SPONTSNEOUS_RE %>"
	value="<%=ent.getNoSpontaneousRe() %>" maxlength="20" /> <label></label>
<div class="paddLeft25" style="padding-left: 38px;"><input
	type="text" class="calDate" name="<%=NO_SPONTSNEOUS_LE %>"
	value="<%=ent.getNoSpontaneousLe() %>" maxlength="20" /></div>
<div class="Clear"></div>
<div class="Height10"></div>

<div class="Clear"></div>
<label>Fistula Test </label> <label></label> <select
	name="<%=FISTULA_RE %>" id="<%=FISTULA_RE %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <%if(ent.getFistualtestRe().equals("+"))
{%> <script type="text/javascript">
	document.getElementById('<%=FISTULA_RE %>').value='+';  
  </script> <%}else if(ent.getFistualtestRe().equals("-"))  {%> <script
	type="text/javascript">
	document.getElementById('<%=FISTULA_RE %>').value='-';  
  </script> <%}%> <label></label> <select name="<%=FISTULA_LE %>"
	id="<%=FISTULA_LE %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <%if(ent.getFistualtestLe().equals("+"))
{%> <script type="text/javascript">
	document.getElementById('<%=FISTULA_LE %>').value='+';  
  </script> <%}else if(ent.getFistualtestLe().equals("-"))  {%> <script
	type="text/javascript">
	document.getElementById('<%=FISTULA_LE %>').value='-';  
  </script> <%}%>
<div class="Clear"></div>

<label>Romberg's Test </label> <label></label> <select
	name="<%=ROMBERG_RE %>" id="<%=ROMBERG_RE %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <%if(ent.getRombergRe().equals("+"))
{%> <script type="text/javascript">
	document.getElementById('<%=ROMBERG_RE %>').value='+';  
  </script> <%}else if(ent.getRombergRe().equals("-"))  {%> <script
	type="text/javascript">
	document.getElementById('<%=ROMBERG_RE %>').value='-';  
  </script> <%}%> <label></label> <select name="<%=ROMBERG_LE %>"
	id="<%=ROMBERG_LE %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <%if(ent.getRombergLe().equals("+"))
{%> <script type="text/javascript">
	document.getElementById('<%=ROMBERG_LE %>').value='+';  
  </script> <%}else if(ent.getRombergLe().equals("-"))  {%> <script
	type="text/javascript">
	document.getElementById('<%=ROMBERG_LE %>').value='-';  
  </script> <%}%>
<div class="Clear"></div>

<label>No Cerebellar</label> <label></label> <input
	name="<%=NO_CEREBELLAR %>" type="text"
	value="<%=ent.getNoCerebellarSign() %>" maxlength="100" /> <label></label>
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
<label class="large">External Nasal Framework</label><label></label> <select
	name="<%=EXTERNAL_NASAL_FRAMEWORK_RE %>"
	id="<%=EXTERNAL_NASAL_FRAMEWORK_RE %>">
	<option value="0">Select one</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select> <%if(ent.getExternalNasalFrameworkRe() != null) {%> <script
	type="text/javascript">
	document.getElementById('<%=EXTERNAL_NASAL_FRAMEWORK_RE %>').value='<%=ent.getExternalNasalFrameworkRe()%>';  
  </script> <%}%> <label></label> <select name="<%=EXTERNAL_NASAL_FRAMEWORK_LE %>"
	id="<%=EXTERNAL_NASAL_FRAMEWORK_LE %>">
	<option value="0">Select one</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select> <%if(ent.getExternalNasalFrameworkLe() != null) {%> <script
	type="text/javascript">
	document.getElementById('<%=EXTERNAL_NASAL_FRAMEWORK_LE%>').value='<%=ent.getExternalNasalFrameworkLe()%>';  
  </script> <%}%>

<div class="Height10"></div>
<div class="Clear"></div>

<label class="large">Ant Rhinoscopy </label> <label></label> <select
	name="<%=ANT_RHINOSCOPY_RE %>" id="<%=ANT_RHINOSCOPY_RE %>">
	<option value="0">Select one</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select> <%if(ent.getAntRhinoscopyRe() != null) {%> <script type="text/javascript">
	document.getElementById('<%=ANT_RHINOSCOPY_RE%>').value='<%=ent.getAntRhinoscopyRe()%>';  
  </script> <%}%> <label></label> <select name="<%=ANT_RHINOSCOPY_LE %>"
	id="<%=ANT_RHINOSCOPY_LE %>">
	<option value="0">Select one</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select>
<div class="Clear"></div>
<%if(ent.getAntRhinoscopyLe() != null) {%> <script type="text/javascript">
	document.getElementById('<%=ANT_RHINOSCOPY_LE%>').value='<%=ent.getAntRhinoscopyLe()%>';  
  </script> <%}%>

<div class="Clear"></div>
<label class="large">Post Rhinoscopy </label> <label></label> <input
	name="<%=POST_RHINOSCOPY_RE %>" type="text"
	value="<%=ent.getPostRhinoscopyRe() %>" maxlength="20" /> <label></label>
<input name="<%=POST_RHINOSCOPY_LE %>" type="text"
	value="<%=ent.getPostRhinoscopyLe() %>" maxlength="20" />
<div class="Clear"></div>
<div class="header">
<div class="paddLeft25">
<h5><u>Throat</u></h5>
</div>
</div>
<div class="Clear"></div>
<label> Oral Cavity </label> <label></label> <input
	name="<%=ORAL_CAVITY %>" type="text" value="<%=ent.getOralCavity() %>"
	maxlength="20" />
<div class="Clear"></div>
<label> OralPharynx </label> <label></label> <input
	name="<%=ORAL_PHATYNX %>" type="text" value="<%=ent.getOroPharynx() %>"
	maxlength="20" />
<div class="Clear"></div>
<label> IDL </label> <label></label> <input name="<%=IDL %>" type="text"
	value="<%=ent.getIdlThroat() %>" maxlength="20" />
<div class="Clear"></div>
<div class="header">
<div class="paddLeft25">
<h5><u>Neck</u></h5>
</div>
</div>
<div class="Clear"></div>
<label> Neck </label> <label></label> <input name="<%=NECK %>"
	type="text" value="<%=ent.getNeck() %>" maxlength="20" />
<div class="Clear"></div>
<h5>Diagnosis</h5>
<div class="Clear"></div>
<label> Surgery </label> <label></label> <input name="<%=SURGERY %>"
	type="text" value="<%=ent.getSurgery() %>" maxlength="20" />
<div class="Clear"></div>
<label> Post OP </label> <label></label> <input name="<%=POST_OP %>"
	type="text" value="<%=ent.getPostOp() %>" maxlength="20" />
<div class="Clear"></div>
<label> Advice </label> <label></label> <%if(ent.getAdvice() != null){ %>
<textarea name="<%=ADVICE %>" maxlength="40"
	onkeyup="return ismaxlength(this)" cols="" rows=""><%=ent.getAdvice()%></textarea>
<% }else { %> <textarea name="<%=ADVICE %>" maxlength="40"
	onkeyup="return ismaxlength(this)" cols="" rows=""></textarea> <%} %>
</div>
<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=DEPARTMENT_ID %>" value="<%=visit.getDepartment().getId() %>" />
<input type="hidden" id="visitNo" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	id="currentVisitId" name="currentVisitId" value="<%=currentVisitId %>">
<input type="hidden" id="max" name="max" value="<%=max %>"> <input
	type="hidden" name="visitId" id="visitId" value="<%=visit.getId() %>">
<!--Bottom labels starts-->
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName %></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label>

<div class="Clear"></div>
<input name="prev" type="button" class="button" value="Update"
	onclick="submitForm('ent','opd?method=updateEnt');"> <%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('ent','<%=url%>');" align="right" /></div>
<%}%>

</div>

<!--Bottom labels ends-->
<% }else{%>

<label style="width: auto;"><span>No Record Found!!</span></label>
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

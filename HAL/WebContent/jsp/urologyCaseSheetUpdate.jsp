<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdUrology"%>
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
<form name="oncosurgeryCaseSheet" action="" method="post">
<h6>OPD Urology Case Sheet</h6>
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
	List<OpdUrology> oncosurgeryCaseSheetList = new ArrayList<OpdUrology>();
	
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
	if(map.get("oncosurgeryCaseSheetList") != null){
		oncosurgeryCaseSheetList=(List<OpdUrology>)map.get("oncosurgeryCaseSheetList");
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
	class="valuemedium"><%=patientName %> </label> <%}else{ %> <label
	class="valuemedium">- </label> <%} %> <label class="medium">Service
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
	class="valuemedium">-</label> <%} %> <label class="noWidth">Token
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
if(oncosurgeryCaseSheetList.size() > 0){
	
	OpdUrology oncosurgeryCaseSheet = new OpdUrology();
	oncosurgeryCaseSheet = oncosurgeryCaseSheetList.get(0);
%>
<div class="Clear"></div>

<!--Block two Start--> <label>Symptomme</label> <label class="value"><%=oncosurgeryCaseSheet.getSymptomme() %></label>
<div class="Clear"></div>
<div class="blockFrame">
<h2>Haematuria :</h2>
<%
	if(oncosurgeryCaseSheet.getHaeTotal() != null && !oncosurgeryCaseSheet.getHaeTotal().equals("")){
%>
<div class="paddLeft25"><input type="checkbox"
	name="<%=HAE_TOTAL %>" value="y" class="radio" checked="checked" /><label
	class="value">Total</label></div>
<%}else{ %>
<div class="paddLeft25"><input type="checkbox"
	name="<%=HAE_TOTAL %>" value="y" class="radio" /><label class="value">Total</label></div>
<%} %> <%
	if(oncosurgeryCaseSheet.getHaeTeriminal() != null && !oncosurgeryCaseSheet.getHaeTeriminal().equals("")){
%> <input type="checkbox" name="<%=HAE_TERIMINAL %>" value="y"
	class="radio" checked="checked" /><label class="value">Terminal</label>
<%}else{ %> <input type="checkbox" name="<%=HAE_TERIMINAL %>" value="y"
	class="radio" /><label class="value">Terminal</label> <%} %> <%
	if(oncosurgeryCaseSheet.getHaeInitial() != null && !oncosurgeryCaseSheet.getHaeInitial().equals("")){
%> <input type="checkbox" name="<%=HAE_INITIAL %>" value="y"
	class="radio" checked="checked" /><label class="value">Initial</label>
<%}else{ %> <input type="checkbox" name="<%=HAE_INITIAL %>" value="y"
	class="radio" /><label class="value">Initial</label> <%} %> <%
	if(oncosurgeryCaseSheet.getHaeClots() != null && !oncosurgeryCaseSheet.getHaeClots().equals("")){
%> <input type="checkbox" name="<%=HAE_CLOTS %>" value="y" class="radio"
	checked="checked" /><label class="value">Clots</label> <%}else{ %> <input
	type="checkbox" name="<%=HAE_CLOTS %>" value="y" class="radio" /><label
	class="value">Clots</label> <%} %>



<div class="Clear"></div>

<h2>Pain :</h2>

<%
	if(oncosurgeryCaseSheet.getUretericLeft() != null && !oncosurgeryCaseSheet.getUretericLeft().equals("")){
%>
<div class="paddLeft25"><input type="checkbox"
	name="<%=URETERIC_LEFT %>" value="y" class="radio" checked="checked" /><label
	class="value">Left</label></div>
<%}else{ %>
<div class="paddLeft25"><input type="checkbox"
	name="<%=URETERIC_LEFT %>" value="y" class="radio" /><label
	class="value">Left</label></div>
<%} %> <%
	if(oncosurgeryCaseSheet.getUretericRight() != null && !oncosurgeryCaseSheet.getUretericRight().equals("")){
%> <input type="checkbox" name="<%=URETERIC_RIGHT %>" value="y"
	class="radio" checked="checked" /><label class="value">Right</label> <%}else{ %>
<input type="checkbox" name="<%=URETERIC_RIGHT %>" value="y"
	class="radio" /><label class="value">Right</label> <%} %>



<div class="Clear"></div>
<h2>&nbsp;</h2>
<%
	if(oncosurgeryCaseSheet.getHypogastricPain() != null && !oncosurgeryCaseSheet.getHypogastricPain().equals("")){
%>
<div class="paddLeft25"><input type="checkbox"
	name="<%=HYPOGASTRIC_PAIN %>" value="y" class="radio" checked="checked" /><label
	class="value">Hypogastric pain</label></div>
<%}else{ %>
<div class="paddLeft25"><input type="checkbox"
	name="<%=HYPOGASTRIC_PAIN %>" value="y" class="radio" /><label
	class="value">Hypogastric pain</label></div>
<%} %> <%
	if(oncosurgeryCaseSheet.getBonePain() != null && !oncosurgeryCaseSheet.getBonePain().equals("")){
%> <input type="checkbox" name="<%=BONE_PAIN %>" value="y" class="radio"
	checked="checked" /><label class="value">Bone Pain </label> <%}else{ %> <input
	type="checkbox" name="<%=BONE_PAIN %>" value="y" class="radio" /><label
	class="value">Bone Pain </label> <%} %> <%
	if(oncosurgeryCaseSheet.getDysuriaPain() != null && !oncosurgeryCaseSheet.getDysuriaPain().equals("")){
%> <input type="checkbox" name="<%=DYSURIA_PAIN %>" value="y"
	class="radio" checked="checked" /><label class="value">Dysuria</label>
<%}else{ %> <input type="checkbox" name="<%=DYSURIA_PAIN %>" value="y"
	class="radio" /><label class="value">Dysuria</label> <%} %> <%
	if(oncosurgeryCaseSheet.getPerinalRectal() != null && !oncosurgeryCaseSheet.getPerinalRectal().equals("")){
%> <input type="checkbox" name="<%=PERINAL_RECTAL %>" value="y"
	class="radio" checked="checked" /><label class="valueNoWidth">Perineal
/ Rectal pain</label> <%}else{ %> <input type="checkbox"
	name="<%=PERINAL_RECTAL %>" value="y" class="radio" /><label
	class="valueNoWidth">Perineal / Rectal pain</label> <%} %>

<div class="Clear"></div>
<h2>Luts :</h2>
<label class="medium">Irritative</label>
<div class="paddLeft55"><label>Obstructive</label></div>
<div class="Clear"></div>
<h2>&nbsp;</h2>
<div class="paddLeft25">
<%
	if(oncosurgeryCaseSheet.getLFrequency() != null && !oncosurgeryCaseSheet.getLFrequency().equals("")){
%> <input type="checkbox" name="<%=L_FREQUENCY %>" value="y"
	class="radio" checked="checked" /><label class="value">Frequency</label>
<%}else{ %> <input type="checkbox" name="<%=L_FREQUENCY %>" value="y"
	class="radio" /><label class="value">Frequency</label> <%} %>
</div>

<div class="paddLeft25">
<%
	if(oncosurgeryCaseSheet.getLHesitanvy() != null && !oncosurgeryCaseSheet.getLHesitanvy().equals("")){
%> <input type="checkbox" name="<%=L_HESITANVY %>" value="y"
	class="radio" checked="checked" /><label class="value">Hesitanvy</label>
<%}else{ %> <input type="checkbox" name="<%=L_HESITANVY %>" value="y"
	class="radio" /><label class="value">Hesitanvy</label> <%} %>
</div>
<div class="Clear"></div>

<h2>&nbsp;</h2>
<div class="paddLeft25">
<%
	if(oncosurgeryCaseSheet.getLNocturia() != null && !oncosurgeryCaseSheet.getLNocturia().equals("")){
%> <input type="checkbox" name="<%=L_NOCTURIA %>" value="y"
	class="radio" checked="checked" /> <label class="value">Nocturia</label>
<%}else{ %> <input type="checkbox" name="<%=L_NOCTURIA %>" value="y"
	class="radio" /> <label class="value">Nocturia</label> <%} %>
</div>

<div class="paddLeft25">
<%
	if(oncosurgeryCaseSheet.getLStraining() != null && !oncosurgeryCaseSheet.getLStraining().equals("")){
%> <input type="checkbox" name="<%=L_STRAINING %>" value="y"
	class="radio" checked="checked" /> <label class="value">Straining</label>
<%}else{ %> <input type="checkbox" name="<%=L_STRAINING %>" value="y"
	class="radio" /> <label class="value">Straining</label> <%} %>
</div>
<div class="Clear"></div>

<h2>&nbsp;</h2>
<div class="paddLeft25">
<%
	if(oncosurgeryCaseSheet.getLUrgency() != null && !oncosurgeryCaseSheet.getLUrgency().equals("")){
%> <input type="checkbox" name="<%=L_URGENCY %>" value="y" class="radio"
	checked="checked" /> <label class="value">Urgency</label> <%}else{ %> <input
	type="checkbox" name="<%=L_URGENCY %>" value="y" class="radio" /> <label
	class="value">Urgency</label> <%} %>
</div>

<div class="paddLeft25">
<%
	if(oncosurgeryCaseSheet.getLSenseComEva() != null && !oncosurgeryCaseSheet.getLSenseComEva().equals("")){
%> <input type="checkbox" name="<%=L_SENSE_COM_EVA %>" value="y"
	class="radio" checked="checked" /><label class="valueNoWidth">Sense
of incomplete evaluation</label> <%}else{ %> <input type="checkbox"
	name="<%=L_SENSE_COM_EVA %>" value="y" class="radio" /><label
	class="valueNoWidth">Sense of incomplete evaluation</label> <%} %>
</div>

<div class="Clear"></div>

<h2>&nbsp;</h2>
<div class="paddLeft25">
<%
	if(oncosurgeryCaseSheet.getLUrgeIncon() != null && !oncosurgeryCaseSheet.getLUrgeIncon().equals("")){
%> <input type="checkbox" name="<%=L_URGE_INCON %>" value="y"
	class="radio" checked="checked" /> <label class="value">Urge
incontinence</label> <%}else{ %> <input type="checkbox" name="<%=L_URGE_INCON %>"
	value="y" class="radio" /> <label class="value">Urge
incontinence</label> <%} %>
</div>

<div class="paddLeft25">
<%
	if(oncosurgeryCaseSheet.getLIntermittency() != null && !oncosurgeryCaseSheet.getLIntermittency().equals("")){
%> <input type="checkbox" name="<%=L_INTERMITTENCY %>" value="y"
	class="radio" checked="checked" /><label class="value">Intermittency</label>
<%}else{ %> <input type="checkbox" name="<%=L_INTERMITTENCY %>" value="y"
	class="radio" /><label class="value">Intermittency</label> <%} %> <%
	if(oncosurgeryCaseSheet.getLDribbling() != null && !oncosurgeryCaseSheet.getLDribbling().equals("")){
%> <input type="checkbox" name="<%=L_DRIBBLING %>" value="y"
	class="radio" checked="checked" /><label class="value">Dribbling</label>
<%}else{ %> <input type="checkbox" name="<%=L_DRIBBLING %>" value="y"
	class="radio" /><label class="value">Dribbling</label> <%} %>
</div>



</div>


<div class="Clear"></div>
<div class="division"></div>
<div class="blockFrame"><label>Calcularia </label> <%
	if(oncosurgeryCaseSheet.getCalculariaCheck() != null && !oncosurgeryCaseSheet.getCalculariaCheck().equals("")){
%> <input type="checkbox" name="<%=CALCULARIA_CHECK %>" value="y"
	class="radio" checked="checked" /> <%}else{ %> <input type="checkbox"
	name="<%=CALCULARIA_CHECK %>" value="y" class="radio" /> <%} %> <input
	type="text" name="<%=CALCULARIA %>"
	value="<%=oncosurgeryCaseSheet.getCalcularia() %>" /> <label>Chyluria
</label> <%
	if(oncosurgeryCaseSheet.getChyluriaCheck() != null && !oncosurgeryCaseSheet.getChyluriaCheck().equals("")){
%> <input type="checkbox" name="<%=CHYLURIA_CHECK %>" value="y"
	class="radio" checked="checked" /> <%}else{ %> <input type="checkbox"
	name="<%=CHYLURIA_CHECK %>" value="y" class="radio" /> <%} %> <input
	type="text" name="<%=CHYLURIA %>"
	value="<%=oncosurgeryCaseSheet.getChyluria() %>" /> <label>Erectile
Dysfunction </label> <%
	if(oncosurgeryCaseSheet.getErectileDysfunctionCheck() != null && !oncosurgeryCaseSheet.getErectileDysfunctionCheck().equals("")){
%> <input type="checkbox" name="<%=ERECTILE_DYSFUNCTION_CHECK %>"
	value="y" class="radio" checked="checked" /> <%}else{ %> <input
	type="checkbox" name="<%=ERECTILE_DYSFUNCTION_CHECK %>" value="y"
	class="radio" /> <%} %> <input type="text"
	name="<%=ERECTILE_DYSFUNCTION %>"
	value="<%=oncosurgeryCaseSheet.getErectileDysfunction() %>">


<div class="Clear"></div>

<h5>Ejaculatory Dysfunction :</h5>
<div class="paddLeft25">
<%
	if(oncosurgeryCaseSheet.getHaemospermia() != null && !oncosurgeryCaseSheet.getHaemospermia().equals("")){
%> <input type="checkbox" name="<%=HAEMOSPERMIA %>" value="y"
	class="radio" checked="checked" /><label class="value">Haemospermia</label>
<%}else{ %> <input type="checkbox" name="<%=HAEMOSPERMIA %>" value="y"
	class="radio" /><label class="value">Haemospermia</label> <%} %>
</div>
<%
	if(oncosurgeryCaseSheet.getPrematureejaculation() != null && !oncosurgeryCaseSheet.getPrematureejaculation().equals("")){
%> <input type="checkbox" name="<%=PREMATUREEJACULATION %>" value="y"
	class="radio" checked="checked" /><label class="valueNoWidth">Premature
Ejaculation</label> <%}else{ %> <input type="checkbox"
	name="<%=PREMATUREEJACULATION %>" value="y" class="radio" /><label
	class="valueNoWidth">Premature Ejaculation</label> <%} %> <%
	if(oncosurgeryCaseSheet.getRetrogradeEjaculation() != null && !oncosurgeryCaseSheet.getRetrogradeEjaculation().equals("")){
%> <input type="checkbox" name="<%=RETROGRADE_EJACULATION %>" value="y"
	class="radio" checked="checked" /> <label class="valueNoWidth">Retrograde
Ejaculation</label> <%}else{ %> <input type="checkbox"
	name="<%=RETROGRADE_EJACULATION %>" value="y" class="radio" /> <label
	class="valueNoWidth">Retrograde Ejaculation</label> <%} %> <%
	if(oncosurgeryCaseSheet.getAnejaculationEjaculation() != null && !oncosurgeryCaseSheet.getAnejaculationEjaculation().equals("")){
%> <input type="checkbox" name="<%=ANEJACULATION_EJACULATION %>"
	value="y" class="radio" checked="checked" /><label class="valueNoWidth">Anejaculation
<%}else{ %> <input type="checkbox" name="<%=ANEJACULATION_EJACULATION %>"
	value="y" class="radio" /><label class="valueNoWidth">Anejaculation
<%} %> Ejaculation</label>



<div class="Clear"></div>

<h5>Incontinence :</h5>
<div class="paddLeft25">
<%
	if(oncosurgeryCaseSheet.getStressIncontinence() != null && !oncosurgeryCaseSheet.getStressIncontinence().equals("")){
%> <input type="checkbox" name="<%=STRESS_INCONTINENCE %>" value="y"
	class="radio" checked="checked" /> <label class="valueNoWidth">Stress
Incontinence</label> <%}else{ %> <input type="checkbox"
	name="<%=STRESS_INCONTINENCE %>" value="y" class="radio" /> <label
	class="valueNoWidth">Stress Incontinence</label> <%} %>
</div>

<%
	if(oncosurgeryCaseSheet.getUrgeIncontinence() != null && !oncosurgeryCaseSheet.getUrgeIncontinence().equals("")){
%> <input type="checkbox" name="<%=URGE_INCONTINENCE %>" value="y"
	class="radio" checked="checked" /> <label class="valueNoWidth">Urge
incontinence</label> <%}else{ %> <input type="checkbox"
	name="<%=URGE_INCONTINENCE %>" value="y" class="radio" /> <label
	class="valueNoWidth">Urge incontinence</label> <%} %> <%
	if(oncosurgeryCaseSheet.getTotalIncontinence() != null && !oncosurgeryCaseSheet.getTotalIncontinence().equals("")){
%> <input type="checkbox" name="<%=TOTAL_INCONTINENCE %>" value="y"
	class="radio" checked="checked" /> <label class="valueNoWidth">Total
incontinence</label> <%}else{ %> <input type="checkbox"
	name="<%=TOTAL_INCONTINENCE %>" value="y" class="radio" /> <label
	class="valueNoWidth">Total incontinence</label> <%} %> <%
	if(oncosurgeryCaseSheet.getOverflowIncontinence() != null && !oncosurgeryCaseSheet.getOverflowIncontinence().equals("")){
%> <input type="checkbox" name="<%=OVERFLOW_INCONTINENCE %>" value="y"
	class="radio" checked="checked" /> <label class="valueNoWidth">Overflow
incontinence</label> <%}else{ %> <input type="checkbox"
	name="<%=OVERFLOW_INCONTINENCE %>" value="y" class="radio" /> <label
	class="valueNoWidth">Overflow incontinence</label> <%} %>


<div class="Clear"></div>
<h5>Acute Urinary Retention :</h5>

<div class="paddLeft25">
<%
	if(oncosurgeryCaseSheet.getAcuteUrinaryCheck() != null && !oncosurgeryCaseSheet.getAcuteUrinaryCheck().equals("")){
%> <input type="checkbox" name="<%=ACUTE_URINARY_CHECK %>" value="y"
	class="radio" checked="checked"> <%}else{ %> <input
	type="checkbox" name="<%=ACUTE_URINARY_CHECK %>" value="y"
	class="radio"> <%} %> <input type="text"
	name="<%=ACUTE_URINARY %>"
	value="<%=oncosurgeryCaseSheet.getAcuteUrinary() %>"></div></div>



<div class="Clear"></div>

<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=DEPARTMENT_ID %>" value="<%=visit.getDepartment().getId() %>" />
<input type="hidden" id="visitNo" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	id="urologyId" name="urologyId"
	value="<%=oncosurgeryCaseSheet.getId()%>"> <input type="hidden"
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
	onclick="submitForm('oncosurgeryCaseSheet','opd?method=updateUrologyCaseSheet');">
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('oncosurgeryCaseSheet','<%=url%>');" align="right" /></div>
<%}%>

</div>

<!--Bottom labels ends-->
<%}else{%>

<label><span>No Record Found!!</span></label>
<div class="Clear"></div>
<div class="bottom"><input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	id="visitNo" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>">
<input type="hidden" id="currentVisitId" name="currentVisitId"
	value="<%=currentVisitId %>"> <input type="hidden" id="visitId"
	value="<%=visit.getId() %>"> <input type="hidden" id="max"
	name="max" value="<%=max %>"> <input name="prev" type="button"
	class="button" value="Prev"
	onclick="submitForm('oncosurgeryCaseSheet','opd?method=viewUrologyCaseSheet&flag=prev','patientVisitPrev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('oncosurgeryCaseSheet','opd?method=viewUrologyCaseSheet&flag=next','patientVisitNext');">
<input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('oncosurgeryCaseSheet','opd?method=showUrologyCaseSheetJsp&visitId=<%=visit.getId() %>');"
	align="right" /></div>


</div>
<!--Bottom labels ends-->
<%} %>

<div class="division"></div>
</form>
</div>

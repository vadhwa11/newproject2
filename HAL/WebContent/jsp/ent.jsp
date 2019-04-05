<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
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
<script type="text/javascript">

animatedcollapse.addDiv('slide0', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide4', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

</script>

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

<%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");

		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
			}
		String buttonFlag="";
		 List patientDataList = new ArrayList();
			
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}			

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	if(map.get("buttonFlag") != null)
	{
	buttonFlag=(String)map.get("buttonFlag");

	}
	
	Visit visit=(Visit)patientDataList.get(0);
	int hinId=visit.getHin().getId();
	Patient patient = null;
	patient = (Patient) visit.getHin();
	
	
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

<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="ent" action="" method="post"><input type="hidden"
	name="<%=DEPARTMENT_ID %>" value="<%=visit.getDepartment().getId() %>" />


<%if(visit.getDepartment()!= null){ %>
<h6>ENT</h6>
<div class="Clear"></div>
<%} %> <!--Block One Starts-->

<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service </label> <%if(visit.getHin().getServiceType()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Service No.</label> <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getServiceNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">
Serv. Status </label> <%if(visit.getHin().getServiceStatus()!= null){ %> <label
	class="valuemedium"><%=visit.getHin().getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Name</label> <%if(patientName != null){ %> <label
	class="value"><%=patientName %></label> <%}else{ %> <label class="value">-</label>
<%} %>
<div class="Clear"></div>

<label class="medium">Relation</label> <%if(visit.getHin().getRelation() != null){ %>
<label class="valuemedium"><%=visit.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Rank</label> <%if(visit.getHin().getRank()!= null){ %> <label
	class="valuemedium"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit</label> <%if(visit.getHin().getUnit()!= null && !visit.getHin().getUnit().getUnitName().equals("")){ %>
<label class="valuemedium"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit Address</label> <% if(visit.getHin().getUnit()!= null&& !visit.getHin().getUnit().getUnitAddress().equals("")){ %>
<label class="valuemedium"><%=visit.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label class="medium">HIN No.</label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getHinNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Age</label>
<%if(visit.getHin().getAge()!= null){ %> <label class="valuemedium"><%=visit.getHin().getAge() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Visit Date </label> <%if(visitDateInString != null){ %> <label
	class="valuemedium"><%=visitDateInString %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">Visit
no. </label> <%if(visit.getVisitNo()!= null){ %> <label class="valuemedium"><%=visit.getVisitNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>


<label class="medium">Token No. </label> <%if(visit.getTokenNo()!= null){ %>
<label class="valuemedium"><%=visit.getTokenNo() %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">ECHS
No. </label> <%if(visit.getHin().getEchsNo()!= null){ %> <label
	class="valuemedium"><%=visit.getHin().getEchsNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Patient
Name</label> <%if(patientName!= null){ %> <label class="value"><%=patientName %>
</label> <%}else{ %> <label class="value">- </label> <%} %> <label class="medium">Prev.
Diag </label> <%if(visit.getDiagnosis()!= null){ %> <label class="valueNoWidth"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>

<div class="Clear"></div>

<label class="medium">Phone Number</label> <% if(visit.getHin().getPhoneNumber()!= null && !visit.getHin().getPhoneNumber().equals("")){%>
<label class="valuemedium"><%=visit.getHin().getPhoneNumber() %></label>
<%}else{ %> <label class="valuemedium">---</label> <%} %> <label
	class="medium">Mobile Number</label> <% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
<label class="valuemedium"><%=visit.getHin().getMobileNumber() %></label>
<%}else{ %> <label class="valuemedium">---</label> <%} %>
<div class="Clear"></div>
</div>

<!--Block one Ends-->
<div class="Clear"></div>

<!--Block two Start-->

<div class="blockTitle">Brief History</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>



<div class="blockFrame">
<div class="Clear"></div>
<label>Otorrhoea</label> <input name="<%=OTORRHOEA %>" type="text"
	maxlength="20" /> <label>Hearing Loss</label> <input
	name="<%=HEARING_LOSS %>" type="text" maxlength="20" /> <label>Otalgia</label>
<input name="<%=OTALGIA %>" type="text" maxlength="20" />


<div class="Clear"></div>
<label>Sneezing</label> <input name="<%=SNEEZING %>" type="text"
	maxlength="20" /> <label>Nasal Obstructions</label> <input
	name="<%=NASAL_OBSTRUCTIONS %>" type="text" maxlength="20" /> <label>Rhinorrhoea</label>
<input name="<%=RHINORRHOEA %>" type="text" maxlength="20" />
<div class="Clear"></div>

<label>Epistaxis</label> <input name="<%=EPISTAXIS %>" type="text"
	maxlength="20" /> <label>Facial Pain</label> <input
	name="<%=FACIAL_PAIN %>" type="text" maxlength="20" /> <label>Dysphagia</label>
<input name="<%=DYSPHAGIA %>" type="text" maxlength="20" />
<div class="Clear"></div>
<label>Odynophagia</label> <input name="<%=ODYNOPHAGIA %>" type="text"
	maxlength="20" /> <label>Hoarseness</label> <input
	name="<%=HOARSENESS %>" type="text" maxlength="20" /> <label>Others</label>
<input name="<%=OTHERS_ENT %>" type="text" maxlength="20" />
<div class="Clear"></div>
</div>
<div class="division"></div>
<label class="common">General Examination</label> <input type="text"
	value="Normal" name="<%=GENERAL_EXAMINATION %>" maxlength="50" />
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
<label></label> <label class="large">RE</label> <label></label> <label>LE</label>
</div>

<div class="Clear"></div>

<label class="large">Pre &amp; Post Auricular Pinna</label> <label></label>
<input type="text" class="calDate" name="<%=PRE_POST_RE %>"
	maxlength="20" /> <label></label><label class="small"></label> <input
	type="text" class="calDate" name="<%=PRE_POST_LE %>" maxlength="20" />

<div class="Clear"></div>
<div class="Height10"></div>

<label class="large"> EAC </label> <label></label> <input type="text"
	class="calDate" name="<%=EAC_RE %>" maxlength="20" /> <label></label><label
	class="small"></label> <input type="text" class="calDate"
	name="<%=EAC_LE %>" maxlength="20" />

<div class="Clear"></div>
<label class="large"> TM </label> <label></label> <input type="text"
	class="calDate" name="<%=TM_RE %>" maxlength="20" /> <label></label><label
	class="small"></label> <input type="text" class="calDate"
	name="<%=TM_LE %>" maxlength="20" />

<div class="Clear"></div>
<div class="paddLeft55">
<h5>TFT</h5>
</div>
<div class="Clear"></div>
<label class="large">Rinne's</label>
<div class="Clear"></div>
<label class="Sublable">256</label> <label></label> <select
	name="<%=TFT_RE_TWO_FIVE_SIX %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <label></label> <select name="<%=TFT_LE_TWO_FIVE_SIX %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select>
<div class="Clear"></div>
<label class="Sublable">512</label> <label></label> <select
	name="<%=TFT_RE_FIVE_ONE_TWO %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <label></label> <select name="<%=TFT_LE_FIVE_ONE_TWO %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select>
<div class="Clear"></div>
<label class="Sublable">1024</label> <label></label> <select
	name="<%=TFT_RE_TEN_TWO_FOUR %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <label></label> <select name="<%=TFT_LE_TEN_TWO_FOUR %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select>
<div class="Clear"></div>
<label class="large">Weber's</label> <label></label> <select
	name="<%=TFT_RE_WEDER %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <label></label> <select name="<%=TFT_LE_WEDER %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select>
<div class="Clear"></div>
<label class="large">ABC</label> <label></label> <input type="text"
	name="<%=ABC_RE %>" maxlength="20" /> <label></label> <input
	type="text" name="<%=ABC_LE %>" maxlength="20" />
<div class="Clear"></div>
<div class="paddLeft55">
<h5>FFH</h5>
</div>
<div class="Clear"></div>
<label class="large">CV</label> <label></label> <input type="text"
	class="calDate" name="<%=FFH_CV_RE %>" maxlength="4"
	validate="CV Re,num,no" /> <label class="unit">cm</label> <label></label>
<div class="paddLeft25"><input type="text" class="calDate"
	name="<%=FFH_CV_LE %>" maxlength="4" validate="CV Le,num,no" /> <label
	class="unit">cm</label></div>
<div class="Clear"></div>
<label class="large">FW</label> <label></label> <input type="text"
	class="calDate" name="<%=FFH_FW_RE %>" maxlength="4"
	validate="FW Re,num,no" /> <label class="unit">cm</label> <label></label>
<div class="paddLeft25"><input type="text" class="calDate"
	name="<%=FFH_FW_LE %>" maxlength="4" validate="FW Le,num,no" /> <label
	class="unit">cm</label></div>
<div class="Clear"></div>
<div class="paddLeft55">
<h5>PTA</h5>
</div>
<div class="Clear"></div>
<label class="large">AC</label> <label></label> <input type="text"
	class="calDate" name="<%=PTA_AC_RE %>" maxlength="3"
	validate="AC RE,num,no" /> <label class="unit">db</label> <label></label>
<div class="paddLeft25"><input type="text" class="calDate"
	name="<%=PTA_AC_LE %>" maxlength="3" validate="AC Le,num,no" /> <label
	class="unit">db</label></div>
<div class="Clear"></div>
<label class="large">BC</label> <label></label> <input type="text"
	class="calDate" name="<%=PTA_BC_RE %>" maxlength="3"
	validate="BC Re,num,no" /> <label class="unit">db</label> <label></label>
<div class="paddLeft25"><input type="text" class="calDate"
	name="<%=PTA_BC_LE %>" maxlength="3" validate="BC Le,num,no" /> <label
	class="unit">db</label></div>
<div class="Clear"></div>
<label class="large">AB Gap </label> <label></label> <input type="text"
	class="calDate" name="<%=PTA_AB_GAP_RE %>" maxlength="3"
	validate="AB Gap Re,num,no" /> <label class="unit">db</label> <label></label>
<div class="paddLeft25"><input type="text" class="calDate"
	name="<%=PTA_AB_GAP_LE %>" maxlength="3" validate="AB Gap Le,num,no" />
<label class="unit">db</label></div>
<div class="Clear"></div>
<label class="large">Impedance Audiometry</label> <label></label> <input
	type="text" name="<%=IMPLEDANCE_AUDIOMEETRY_RE %>" maxlength="20" /> <label></label>
<input type="text" name="<%=IMPLEDANCE_AUDIOMEETRY_LE %>" maxlength="20" />
<div class="Clear"></div>
<div class="Height10"></div>
<div class="paddLeft55">
<h5>Otoneurological Exams</h5>
</div>
<div class="Clear"></div>
<label class="large">No Spontaneous/ Induced Nystagmus</label> <label></label>
<input type="text" name="<%=NO_SPONTSNEOUS_RE %>" maxlength="20" /> <label></label>
<input type="text" name="<%=NO_SPONTSNEOUS_LE %>" maxlength="20" />
<div class="Clear"></div>
<div class="Height10"></div>

<div class="Clear"></div>
<label class="large">Fistula Test </label> <label></label> <select
	name="<%=FISTULA_RE %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <label></label> <select name="<%=FISTULA_LE %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select>
<div class="Clear"></div>
<label class="large">Romberg's Test </label> <label></label> <select
	name="<%=ROMBERG_RE %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <label></label> <select name="<%=ROMBERG_LE %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select>
<div class="Clear"></div>

<label class="large">No Cerebellar</label> <label></label> <input
	name="<%=NO_CEREBELLAR %>" type="text" maxlength="100" /> <label></label>
<div class="Clear"></div>
<div class="division"></div>

<div class="Clear"></div>

<div class="blockTitleFixed">NOSE <a
	href="javascript:animatedcollapse.toggle('slide2')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide2">
<div class="blockFrame">
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
	name="<%=EXTERNAL_NASAL_FRAMEWORK_RE %>">
	<option value="0">Select one</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select> <label></label> <select name="<%=EXTERNAL_NASAL_FRAMEWORK_LE %>">
	<option value="0">Select one</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select>
<div class="Height10"></div>
<div class="Clear"></div>
<label class="large">Ant Rhinoscopy </label> <label></label> <select
	name="<%=ANT_RHINOSCOPY_RE %>">
	<option value="0">Select one</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select> <label></label> <select name="<%=ANT_RHINOSCOPY_LE %>">
	<option value="0">Select one</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select>
<div class="Clear"></div>
<label class="large">Post Rhinoscopy </label> <label></label> <input
	name="<%=POST_RHINOSCOPY_RE %>" type="text" maxlength="20" /> <label></label>
<input name="<%=POST_RHINOSCOPY_LE %>" type="text" maxlength="20" />
<div class="Clear"></div>
</div>
</div>
<div class="division"></div>
<div class="Clear"></div>

<div class="blockTitleFixed">Throat <a
	href="javascript:animatedcollapse.toggle('slide3')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide3">
<div class="blockFrame">
<div class="Clear"></div>

<div class="header">
<div class="paddLeft25">
<h5><u>Throat</u></h5>
</div>
</div>
<div class="Clear"></div>
<label class="large"> Oral Cavity </label> <label></label> <input
	name="<%=ORAL_CAVITY %>" type="text" value="Normal" maxlength="20" />
<div class="Clear"></div>
<label class="large"> OralPharynx </label> <label></label> <input
	name="<%=ORAL_PHATYNX %>" type="text" value="Normal" maxlength="20" />
<div class="Clear"></div>
<label class="large"> IDL </label> <label></label> <input
	name="<%=IDL %>" type="text" value="Normal" maxlength="20" />
<div class="Clear"></div>
</div>
</div>
<div class="division"></div>
<div class="Clear"></div>

<div class="blockTitleFixed">Neck <a
	href="javascript:animatedcollapse.toggle('slide4')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide4">
<div class="blockFrame">
<div class="Clear"></div>

<div class="header">
<div class="paddLeft25">
<h5><u>Neck</u></h5>
</div>
</div>
<div class="Clear"></div>
<label class="large"> Neck </label> <label></label> <input
	name="<%=NECK %>" type="text" value="Normal" maxlength="20" />
<div class="Clear"></div>
<h5>Diagnosis</h5>
<div class="Clear"></div>
<label class="large"> Surgery </label> <label></label> <input
	name="<%=SURGERY %>" type="text" value="Normal" maxlength="20" />
<div class="Clear"></div>
<label class="large"> Post OP </label> <label></label> <input
	name="<%=POST_OP %>" type="text" value="Normal" maxlength="20" />
<div class="Clear"></div>
<label class="large"> Advice </label> <label></label> <textarea
	name="<%=ADVICE %>" maxlength="40" onkeyup="return ismaxlength(this)"
	cols="" rows=""></textarea>
<div class="Clear"></div>

</div>
</div>
<div class="division"></div>
<div class="Clear"></div>

</div>

<!--Block two Ends--> <input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> <input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="currentVisitId" value="<%=visit.getId() %>">
<div class="division"></div>

<div class="bottom">

<div class="Clear"></div>

<input type="button" class="button" value="Submit"
	onclick="submitForm('ent','opd?method=addEnt');" align="right" /> <input
	type="button" class="button" value="View"
	onclick="submitForm('ent','opd?method=viewEnt&viewScreen=no');" /> <input
	name="Back" type="button" src="images/phaseII/delete.gif" alt="Back"
	value="Back" class="button" onclick="history.go(-1);return false;"
	align="right" />
<div class="Height10"></div>
</div>
</form>
</div>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdGynaecology"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
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
<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>

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
<script type="text/javascript">

animatedcollapse.addDiv('slide0', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide4', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

</script>

<script type="text/javascript">

</script>

<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="gynaecology" method="post" action="">
<h6>Labour Room Details</h6>
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
	
	List<Inpatient> inpatientDetailsList = new ArrayList<Inpatient>();
	List<OpdGynaecology> opdGynaecologyList = new ArrayList<OpdGynaecology>();
	
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	if(map.get("inpatientDetailsList") != null){
		inpatientDetailsList = (List<Inpatient>)map.get("inpatientDetailsList");
	}
	if(map.get("opdGynaecologyList") != null){
		opdGynaecologyList = (List<OpdGynaecology>)map.get("opdGynaecologyList");
	}
	OpdGynaecology opdObj = null;
	if(opdGynaecologyList.size() > 0){
		opdObj = (OpdGynaecology)opdGynaecologyList.get(0);
	}
	int currentVisitId=0;
	if(map.get("currentVisitId") != null){
		currentVisitId = (Integer)map.get("currentVisitId");
	}
	int max=0;
	if(map.get("max") != null){
		max = (Integer)map.get("max");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	
	Inpatient inpatient = new Inpatient();
	if(inpatientDetailsList.size() > 0){
		inpatient = inpatientDetailsList.get(0);
	}

	String patientName="";
	if(inpatient.getHin().getPFirstName()!= null){
		patientName=inpatient.getHin().getPFirstName();
	}
	if(inpatient.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+inpatient.getHin().getPMiddleName();
	}
	if(inpatient.getHin().getPLastName()!= null){
		patientName=patientName+" "+inpatient.getHin().getPLastName();
	}
	 
	%> <!--Block One Starts-->

<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service </label> <%if(inpatient.getHin().getServiceType()!= null){ %>
<label class="valuemedium"><%=inpatient.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Service No.</label> <%if(inpatient.getHin().getServiceNo()!= null){ %>
<label class="valuemedium"><%=inpatient.getHin().getServiceNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium"> Serv. Status </label> <%if(inpatient.getHin().getServiceStatus()!= null){ %>
<label class="valuemedium"><%=inpatient.getHin().getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Name</label> <%if(patientName != null){ %> <label
	class="valueNoWidth"><%=patientName %></label> <%}else{ %> <label
	class="valueNoWidth">-</label> <%} %>
<div class="Clear"></div>

<label class="medium">Relation</label> <%if(inpatient.getHin().getRelation() != null){ %>
<label class="valuemedium"><%=inpatient.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Rank</label> <%if(inpatient.getHin().getRank()!= null){ %>
<label class="valuemedium"><%=inpatient.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit</label> <%if(inpatient.getHin().getUnit()!= null && !inpatient.getHin().getUnit().getUnitName().equals("")){ %>
<label class="valuemedium"><%=inpatient.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit Address</label> <% if(inpatient.getHin().getUnit()!= null&& !inpatient.getHin().getUnit().getUnitAddress().equals("")){ %>
<label class="valuemedium"><%=inpatient.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>


<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label class="medium">HIN No.</label> <%if(inpatient.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=inpatient.getHin().getHinNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Age</label>
<%if(inpatient.getHin().getAge()!= null){ %> <label class="valuemedium"><%=inpatient.getHin().getAge() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<label class="medium">ECHS No. </label> <%if(inpatient.getHin().getEchsNo()!= null){ %>
<label class="valuemedium"><%=inpatient.getHin().getEchsNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Patient Name</label> <%if(patientName!= null){ %> <label
	class="valueNoWidth"><%=patientName %> </label> <%}else{ %> <label
	class="valueNoWidth">- </label> <%} %>

<div class="Clear"></div>

<label>Phone Number</label> <% if(inpatient.getHin().getPhoneNumber()!= null && !inpatient.getHin().getPhoneNumber().equals("")){%>
<label class="valueNoWidth"><%=inpatient.getHin().getPhoneNumber() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %> <label>Mobile
Number</label> <% if(inpatient.getHin().getMobileNumber()!= null && !inpatient.getHin().getMobileNumber().equals("")){%>
<label class="valueNoWidth"><%=inpatient.getHin().getMobileNumber() %></label>
<%}else{ %> <label class="valueNoWidth">---</label> <%} %> <input
	type="hidden" id="max" name="max" value="<%=max %>"> <input
	type="hidden" id="<%=HIN_ID %>" name="<%=HIN_ID %>"
	value="<%=inpatient.getHin().getId() %>"> <input type="hidden"
	id="<%=INPATIENT_ID %>" name="<%=INPATIENT_ID %>"
	value="<%=inpatient.getId() %>">
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="blockFrame">
<div class="Clear"></div>
<!--  block for Socio-Economic History   -->
<div class="blockTitle">Socio- Economic History</div>
<div class="blockTitleCurve"></div>
<div class="floatLeft">
<div class="colA">
<div class="Clear"></div>
<label class="small">Menarchy </label> <%if(opdObj != null && opdObj.getMenarchy() != null){%>
<input type="text" class="year" value="<%=opdObj.getMenarchy() %>"
	name="<%=MENARCHY %>" id="<%=MENARCHY %>" validate="Meanrchy,float,no"
	maxlength="4" tabindex="1" /><label class="unit">yrs</label> <%}else{ %>
<input type="text" class="year" value="" name="<%=MENARCHY %>"
	id="<%=MENARCHY %>" validate="Menarchy,float,no" maxlength="4"
	tabindex="1" /><label class="unit">yrs</label> <%}%> <label class="small">Past
MC </label> <%if(opdObj != null && opdObj.getPastMc() != null){%> <input
	type="text" class="text" value="<%=opdObj.getPastMc() %>"
	name="<%=PAST_MC %>" id="<%=PAST_MC %>" maxlength="15" tabindex="1" />
<%}else{ %> <input type="text" class="text" value="" name="<%=PAST_MC %>"
	id="<%=PAST_MC %>" maxlength="15" tabindex="1" /> <%} %> <label
	class="small">Present MC </label> <%if(opdObj != null && opdObj.getPresentMc() != null){%>
<input type="text" class="text" value="<%=opdObj.getPresentMc() %>"
	name="<%=PRESENT_MC %>" id="<%=PRESENT_MC %>" maxlength="15"
	tabindex="1" /> <%}else{ %> <input type="text" class="text" value=""
	name="<%=PRESENT_MC %>" id="<%=PRESENT_MC %>" maxlength="15"
	tabindex="1" /> <%}%>
<div class="Clear"></div>

<label class="small">LMP </label> <%if(opdObj != null && opdObj.getLmp() != null){%>
<input type="text" class="year" value="<%=opdObj.getLmp() %>"
	name="<%=LMP %>" id="<%=LMP %>" maxlength="15" tabindex="1" /> <label
	class="unit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <%}else{ %> <input
	type="text" class="year" value="" name="<%=LMP %>" id="<%=LMP %>"
	maxlength="15" tabindex="1" /> <label class="unit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
<%}%> <label class="small">PMP1 </label> <%if(opdObj != null && opdObj.getPmp1() != null){%>
<input type="text" class="text" value="<%=opdObj.getPmp1() %>"
	name="<%=PMP1 %>" id="<%=PMP1 %>" maxlength="15" tabindex="1" /> <%}else{ %>
<input type="text" class="text" value="" name="<%=PMP1 %>"
	id="<%=PMP1 %>" maxlength="15" tabindex="1" /> <% }%> <label
	class="small">PMP2 </label> <%if(opdObj != null && opdObj.getPmp2() != null){%>
<input type="text" class="text" value="<%=opdObj.getPmp2() %>"
	name="<%=PMP2 %>" id="<%=PMP2 %>" maxlength="15" tabindex="1" /> <%}else{ %>
<input type="text" class="text" value="" name="<%=PMP2 %>"
	id="<%=PMP2 %>" maxlength="15" tabindex="1" /> <% }%>
<div class="Clear"></div>

<label class="nowidth">Obstetric History </label> <%if(opdObj != null && opdObj.getObstetricHistory() != null){
%> <textarea value="<%=opdObj.getObstetricHistory() %>"
	name="<%=OBSTETRIC_HISTORY%>" id="<%=OBSTETRIC_HISTORY %>"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	tabindex="1" class="large" maxlength="250"></textarea> <script>document.gynaecology.<%=OBSTETRIC_HISTORY%>.innerHTML = "<%=opdObj.getObstetricHistory()%>"</script>
<%}else{ %> <textarea value="" name="<%=OBSTETRIC_HISTORY%>"
	id="<%=OBSTETRIC_HISTORY %>" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	tabindex="1" class="large" maxlength="250"></textarea> <%} %>
<div class="Clear"></div>
<div class="paddLeft55"><label class="nowidth">Dyspareunia
</label></div>
<%if(opdObj != null && opdObj.getDyspareunia() != null){%> <input
	type="text" class="year" value="<%=opdObj.getDyspareunia() %>"
	name="<%=DYSPAREUNIA %>" id="<%=DYSPAREUNIA %>" maxlength="15"
	tabindex="1" /> <%}else{ %> <input type="text" class="year" value=""
	name="<%=DYSPAREUNIA %>" id="<%=DYSPAREUNIA %>" maxlength="15"
	tabindex="1" /> <% }%> <label class="nowidth">Awareness Of
Fertile Period </label> <%if(opdObj != null && opdObj.getAwarenessFertilePeriod() != null){%>
<input type="text" class="year"
	value="<%=opdObj.getAwarenessFertilePeriod() %>"
	name="<%=AWARENESS_OF_FERTILE_PERIOD %>"
	id="<%=AWARENESS_OF_FERTILE_PERIOD %>" maxlength="15" tabindex="1" /> <%}else{ %>
<input type="text" class="year" value=""
	name="<%=AWARENESS_OF_FERTILE_PERIOD %>"
	id="<%=AWARENESS_OF_FERTILE_PERIOD %>" maxlength="15" tabindex="1" /> <% }%>
<div class="Clear"></div>
<label class="nowidth">Trying to conceive For </label> <%if(opdObj != null && opdObj.getConceive() != null){%>
<input type="text" class="year" value="<%=opdObj.getConceive() %>"
	name="<%=TRYING_TO_CONCEIVE_FOR %>" id="<%=TRYING_TO_CONCEIVE_FOR %>"
	maxlength="15" tabindex="1" /> <%}else{ %> <input type="text"
	class="year" value="" name="<%=TRYING_TO_CONCEIVE_FOR %>"
	id="<%=TRYING_TO_CONCEIVE_FOR %>" maxlength="15" tabindex="1" /> <%} %> <label
	class="nowidth">Frequency of Coitus per Wk </label> <%if(opdObj != null && opdObj.getFrequencyCoitusWk() != null){%>
<input type="text" class="year"
	value="<%=opdObj.getFrequencyCoitusWk() %>"
	name="<%=FREQUENCY_OF_COITUS_PER_WK %>"
	id="<%=FREQUENCY_OF_COITUS_PER_WK %>" maxlength="15" tabindex="1" /> <%}else{ %>
<input type="text" class="year" value=""
	name="<%=FREQUENCY_OF_COITUS_PER_WK %>"
	id="<%=FREQUENCY_OF_COITUS_PER_WK %>" maxlength="15" tabindex="1" /> <%} %>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
</div>
<!--  block ends  for Socio-Economic History   --> <!-- Complaints Block Start -->
<div class="blockTitleFixed">Complaints <a
	href="javascript:animatedcollapse.toggle('slide1')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide1"><!--  block for Socio-Economic History   -->
<div class="floatLeft">
<div class="colA"><label class="small">Primary Infertility</label>
<%if(opdObj != null && opdObj.getPrimaryInfertility() != null){%> <input
	type="text" class="year" value="<%=opdObj.getPrimaryInfertility() %>"
	name="<%=PRIMARY_INFERTILITY %>" id="<%=PRIMARY_INFERTILITY %>"
	validate="Primary Infertility,float,no" maxlength="4" tabindex="1" /><label
	class="unit">yrs</label> <%}else{ %> <input type="text" class="year"
	value="" name="<%=PRIMARY_INFERTILITY %>"
	id="<%=PRIMARY_INFERTILITY %>" validate="Primary Infertility,float,no"
	maxlength="4" tabindex="1" /><label class="unit">yrs</label> <%} %> <label
	class="small">Secondary Infertility </label> <%if(opdObj != null && opdObj.getSecondaryInfertility() != null){%>
<input type="year" value="<%=opdObj.getSecondaryInfertility() %>"
	name="<%=SECONDARY_INFERTILITY %>" id="<%=SECONDARY_INFERTILITY %>"
	validate="Secondary Infertility,float,no" maxlength="4" tabindex="1" /><label
	class="unit">yrs</label> <%}else{ %> <input type="year" value=""
	name="<%=SECONDARY_INFERTILITY %>" id="<%=SECONDARY_INFERTILITY %>"
	validate="Secondary Infertility,float,no" maxlength="4" tabindex="1" /><label
	class="unit">yrs</label> <%} %>
<div class="Clear"></div>

<label class="small">Hypomenorrhoea </label> <%if(opdObj != null && opdObj.getHypomenorrhoea() != null){%>
<input type="text" class="year" value="<%=opdObj.getHypomenorrhoea() %>"
	name="<%=HYPOMENORRHOEA %>" id="<%=HYPOMENORRHOEA%>"
	validate="Hypomenorrhoea,float,no" maxlength="4" tabindex="1" /><label
	class="unit">yrs</label> <%}else{ %> <input type="text" class="year"
	value="" name="<%=HYPOMENORRHOEA %>" id="<%=HYPOMENORRHOEA%>"
	validate="Hypomenorrhoea,float,no" maxlength="4" tabindex="1" /><label
	class="unit">yrs</label> <%} %> <label class="small">Oligomenorrhoea
</label> <%if(opdObj != null && opdObj.getOligomenorrhoea() != null){%> <input
	type="text" class="year" value="<%=opdObj.getOligomenorrhoea() %>"
	name="<%=OLIGOMENORRHOEA %>" id="<%=OLIGOMENORRHOEA %>"
	validate="Oligomenorrhoea,float,no" maxlength="4" tabindex="1" /><label
	class="unit">yrs</label> <%}else{ %> <input type="text" class="year"
	value="" name="<%=OLIGOMENORRHOEA %>" id="<%=OLIGOMENORRHOEA %>"
	validate="Oligomenorrhoea,float,no" maxlength="4" tabindex="1" /><label
	class="unit">yrs</label> <%} %>
<div class="Clear"></div>

<label class="small">Galactorrhoea </label> <%if(opdObj != null && opdObj.getGalactorrhoea() != null){%>
<input type="text" class="year" value="<%=opdObj.getGalactorrhoea()  %>"
	name="<%=GALACTORRHOEA %>" id="<%=GALACTORRHOEA %>"
	validate="Galactorrhoea,float,no" maxlength="4" tabindex="1" /><label
	class="unit">yrs</label> <%}else{ %> <input type="text" class="year"
	value="" name="<%=GALACTORRHOEA %>" id="<%=GALACTORRHOEA %>"
	validate="Galactorrhoea,float,no" maxlength="4" tabindex="1" /><label
	class="unit">yrs</label> <%} %> <label class="small">Hisrsutism </label>
<%if(opdObj != null && opdObj.getHisrsutism() != null){%> <input
	type="text" class="year" value="<%=opdObj.getHisrsutism() %>"
	name="<%=HISRSUTISM %>" id="<%=HISRSUTISM %>"
	validate="Hisrsutism,float,no" maxlength="4" tabindex="1" /><label
	class="unit">yrs</label> <%}else{ %> <input type="text" class="year"
	value="" name="<%=HISRSUTISM %>" id="<%=HISRSUTISM %>"
	validate="Hisrsutism,float,no" maxlength="4" tabindex="1" /><label
	class="unit">yrs</label> <%}%>
<div class="Clear"></div>

<label class="small">Leucorrhoea </label> <%if(opdObj != null && opdObj.getLeucorrhoea() != null){%>
<input type="text" value="<%=opdObj.getLeucorrhoea() %>"
	name="<%=LEUCORRHOEA %>" id="<%=LEUCORRHOEA %>" maxlength="100"
	tabindex="1" /> <%}else{ %> <input type="text" value=""
	name="<%=LEUCORRHOEA %>" id="<%=LEUCORRHOEA %>" maxlength="100"
	tabindex="1" /> <%} %> <label class="small">Pruritis Vulvae</label> <%if(opdObj != null && opdObj.getPruritisVulvae() != null){%>
<input type="text" value="<%=opdObj.getPruritisVulvae() %>"
	name="<%=PRURITIS_VULVAE %>" id="<%=PRURITIS_VULVAE %>" tabindex="1"
	maxlength="100" /> <%}else{ %> <input type="text" value=""
	name="<%=PRURITIS_VULVAE %>" id="<%=PRURITIS_VULVAE %>" tabindex="1"
	maxlength="100" /> <%} %>
<div class="Clear"></div>

<label class="small">Backache </label> <%if(opdObj != null && opdObj.getBackache() != null){%>
<input type="text" value="<%=opdObj.getBackache() %>"
	name="<%=BACKACHE %>" id="<%=BACKACHE %>" maxlength="100" tabindex="1" />
<%}else{ %> <input type="text" value="" name="<%=BACKACHE %>"
	id="<%=BACKACHE %>" maxlength="100" tabindex="1" /> <% }%> <label
	class="small">Dysmenorrhoea </label> <%if(opdObj != null && opdObj.getDysmenorrhoea() != null){%>
<input type="text" value="<%=opdObj.getDysmenorrhoea() %>"
	name="<%=DYSMENORRHOEA %>" id="<%=DYSMENORRHOEA %>" maxlength="100"
	tabindex="1" /> <%}else{ %> <input type="text" value=""
	name="<%=DYSMENORRHOEA %>" id="<%=DYSMENORRHOEA %>" maxlength="100"
	tabindex="1" /> <%}%>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
</div>
</div>
<!-- Complaints Block Ends --> <!--  block for Medical/Surgical History   -->
<div class="blockTitleFixed">Medical/Surgical History <a
	href="javascript:animatedcollapse.toggle('slide2')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide2">


<div class="floatLeft">
<div class="colA"><label class="nowidth">Past Medical
History&nbsp;&nbsp;&nbsp;</label> <%if(opdObj != null && opdObj.getPastMedicalHistory() != null){ %>
<textarea value="<%=opdObj.getPastMedicalHistory() %>"
	name="<%=PAST_MEDICAL_HISTORY %>" id="<%=PAST_MEDICAL_HISTORY %>"
	tabindex="1" class="large" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea> <script>document.gynaecology.<%=PAST_MEDICAL_HISTORY%>.innerHTML = "<%=opdObj.getPastMedicalHistory()%>"</script>
<%}else{ %> <textarea value="" name="<%=PAST_MEDICAL_HISTORY %>"
	id="<%=PAST_MEDICAL_HISTORY %>" tabindex="1" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea> <%} %>
<div class="Clear"></div>
<label class="nowidth">Past Surgical History&nbsp;&nbsp;</label> <%if(opdObj != null && opdObj.getPastSurgicalHistory() != null){ 
%> <textarea value="<%=opdObj.getPastSurgicalHistory() %>" tabindex="1"
	name="<%=PAST_SURGICAL_HISTORY %>" id="<%=PAST_SURGICAL_HISTORY %>"
	class="large" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea> <script>document.gynaecology.<%=PAST_SURGICAL_HISTORY%>.innerHTML = "<%=opdObj.getPastSurgicalHistory()%>"</script>
<%}else{ %> <textarea value="" tabindex="1"
	name="<%=PAST_SURGICAL_HISTORY %>" id="<%=PAST_SURGICAL_HISTORY %>"
	class="large" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea> <%} %>
<div class="Clear"></div>

<label class="nowidth">Family
History&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
<%if(opdObj != null && opdObj.getFamilyHistory() != null){%> <textarea
	value="<%=opdObj.getFamilyHistory() %>" name="<%=FAMILY_HISTORY %>"
	id="<%=FAMILY_HISTORY %>" tabindex="1" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea> <script>document.gynaecology.<%=FAMILY_HISTORY%>.innerHTML = "<%=opdObj.getFamilyHistory()%>"</script>
<%}else{ %> <textarea value="" name="<%=FAMILY_HISTORY %>"
	id="<%=FAMILY_HISTORY %>" tabindex="1" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea> <%}%>
<div class="Clear"></div>
</div>
</div>

</div>
<!--  block ends  for Medical/Surgical History  --> <!--  block for General Examination History   -->
<div class="blockTitleFixed">General Examination <a
	href="javascript:animatedcollapse.toggle('slide3')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide3">

<div class="floatLeft">
<div class="colA"><label class="nowidth">Height (cm) </label> <%if(opdObj != null && opdObj.getHeight() != null){ %>
<input type="text" class="year" value="<%=opdObj.getHeight() %>"
	name="<%=HEIGHT %>" id="<%=HEIGHT %>" validate="Height,float,no"
	maxlength="4" tabindex="1" /> <%}else{ %> <input type="text" class="year"
	value="" name="<%=HEIGHT %>" id="<%=HEIGHT %>"
	validate="Height,float,no" maxlength="4" tabindex="1" /> <%} %> <label
	class="nowidth">Weight (kg) </label> <%if(opdObj != null && opdObj.getWeight() != null){%>
<input type="text" class="year" value="<%=opdObj.getWeight() %>"
	name="<%=WEIGHT %>" id="<%=WEIGHT %>" validate="Weight,float,no"
	maxlength="4" tabindex="1" /> <%}else{ %> <input type="text" class="year"
	value="" name="<%=WEIGHT %>" id="<%=WEIGHT %>"
	validate="Weight,float,no" maxlength="4" tabindex="1" /> <%} %> <label
	class="small">BMI :</label> <label class="valuenowidth">Obesity</label>
<%if(opdObj != null && opdObj.getObesity() != null){ %> <input type="text"
	class="year" value="<%=opdObj.getObesity() %>" name="<%=OBESITY %>"
	id="<%=OBESITY %>" maxlength="10" tabindex="1" /> <%}else{ %> <input
	type="text" class="year" value="" name="<%=OBESITY %>"
	id="<%=OBESITY %>" maxlength="10" tabindex="1" /> <%} %> <label
	class="valuenowidth">Acne</label> <%if(opdObj != null && opdObj.getAcne() != null){ %>
<input type="text" class="year" value="<%=opdObj.getAcne() %>"
	name="<%=ACNE %>" id="<%=ACNE %>" maxlength="10" tabindex="1" /> <%}else{ %>
<input type="text" class="year" value="" name="<%=ACNE %>"
	id="<%=ACNE %>" maxlength="10" tabindex="1" /> <% }%>
<div class="Clear"></div>

<label class="nowidth">Hair
Distribution&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <%if(opdObj != null && opdObj.getHairDistribution() != null){%>
<textarea value="<%=opdObj.getHairDistribution() %>" tabindex="1"
	name="<%=HAIR_DISTRIBUTION %>" id="<%=HAIR_DISTRIBUTION %>"
	class="large" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="50"></textarea> <script>document.gynaecology.<%=HAIR_DISTRIBUTION%>.innerHTML = "<%=opdObj.getHairDistribution()%>"</script>
<%}else{ %> <textarea value="" tabindex="1" name="<%=HAIR_DISTRIBUTION %>"
	id="<%=HAIR_DISTRIBUTION %>" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="50"></textarea> <%} %>
<div class="Clear"></div>

<label class="nowidth">Breast Development&nbsp;</label> <%if(opdObj != null && opdObj.getBreastDevelopment() != null){%>
<textarea value="<%=opdObj.getBreastDevelopment() %>" tabindex="1"
	name="<%=BREAST_DEVELOPMENT %>" id="<%=BREAST_DEVELOPMENT %>"
	class="large" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="20"></textarea> <script>document.gynaecology.<%=BREAST_DEVELOPMENT%>.innerHTML = "<%=opdObj.getBreastDevelopment()%>"</script>
<%}else{ %> <textarea value="" tabindex="1"
	name="<%=BREAST_DEVELOPMENT %>" id="<%=BREAST_DEVELOPMENT %>"
	class="large" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="20"></textarea> <%} %>
<div class="Clear"></div>

<label class="nowidth">Galactorrhoea&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
<%if(opdObj != null && opdObj.getGalactorrhoeaText() != null){ %> <textarea
	value="<%=opdObj.getGalactorrhoeaText() %>" tabindex="1"
	name="<%=GALACTORRHOEA_TEXT %>" id="<%=GALACTORRHOEA_TEXT %>"
	class="large" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="20"></textarea> <script>document.gynaecology.<%=GALACTORRHOEA_TEXT%>.innerHTML = "<%=opdObj.getGalactorrhoeaText()%>"</script>
<%}else{ %> <textarea value="" tabindex="1"
	name="<%=GALACTORRHOEA_TEXT %>" id="<%=GALACTORRHOEA_TEXT %>"
	class="large" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="20"></textarea> <%}%>
<div class="Clear"></div>

<label class="nowidth">Pigmentation&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
<%if(opdObj != null && opdObj.getPigmentation() != null){ %> <textarea
	value="<%=opdObj.getPigmentation() %>" tabindex="1"
	name="<%=PIGMENTATION %>" id="<%=PIGMENTATION %>" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="50"></textarea> <script>document.gynaecology.<%=PIGMENTATION%>.innerHTML = "<%=opdObj.getPigmentation()%>"</script>
<%}else{ %> <textarea value="" tabindex="1" name="<%=PIGMENTATION %>"
	id="<%=PIGMENTATION %>" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="50"></textarea> <% }%>
<div class="Clear"></div>

<label class="nowidth">Others&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
<%if(opdObj != null && opdObj.getOthers() != null){ %> <textarea
	value="<%=opdObj.getOthers()%>" tabindex="1" name="<%=OTHERS %>"
	id="<%=OTHERS %>" class="large" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="50"></textarea> <script>document.gynaecology.<%=OTHERS%>.innerHTML = "<%=opdObj.getOthers()%>"</script>
<%}else{ %> <textarea value="" tabindex="1" name="<%=OTHERS %>"
	id="<%=OTHERS %>" class="large" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="50"></textarea> <% }%>
<div class="Clear"></div>

</div>
<div class="Clear"></div>
</div>
</div>
<!--  block ends  for General Examination  --> <!--  block for Systemic Examination  -->
<div class="blockTitleFixed">Systemic Examination <a
	href="javascript:animatedcollapse.toggle('slide4')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide4">

<div class="floatLeft">
<div class="colA">
<div class="Clear"></div>
<label class="nowidth">Other
Systems&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
<% 
if(opdObj != null && opdObj.getOtherSystems()!= null){%> <textarea
	value="<%=opdObj.getOtherSystems()%>" name="<%=OTHER_SYSTEMS %>"
	id="<%=OTHER_SYSTEMS %>" tabindex="1" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea> <script>document.gynaecology.<%=OTHER_SYSTEMS%>.innerHTML = "<%=opdObj.getOtherSystems()%>"</script>
<%}else{ %> <textarea value="" name="<%=OTHER_SYSTEMS %>"
	id="<%=OTHER_SYSTEMS %>" tabindex="1" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea> <%} %>
<div class="Clear"></div>

<label class="nowidth">Gynaecological Examination</label> <%if(opdObj != null && opdObj.getGynaecologicalExamination() != null){%>
<textarea value="<%=opdObj.getGynaecologicalExamination() %>"
	name="<%=GYNAECOLOGICAL_EXAMINATION %>"
	id="<%=GYNAECOLOGICAL_EXAMINATION %>" tabindex="1" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea> <script>document.gynaecology.<%=GYNAECOLOGICAL_EXAMINATION%>.innerHTML = "<%=opdObj.getGynaecologicalExamination()%>"</script>
<%}else{ %> <textarea value="" name="<%=GYNAECOLOGICAL_EXAMINATION %>"
	id="<%=GYNAECOLOGICAL_EXAMINATION %>" tabindex="1" class="large"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea> <%} %>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
</div>
</div>
<!--  block ends  for Systemic Examination  --></div>
<!--  start of collapse menu --> <!-- end of collapse menu -->
<div class="Clear"></div>
<div class="bottom">
<div class="paddLeft300">
<div class="paddLeft55">
<div class="paddLeft55"><input name="Submit" type="button"
	alt="Submit" value="Submit" class="button"
	onclick="submitForm('gynaecology','opd?method=submitAllDetailsLabourRoom');" /></div>
</div>
</div>
</div>
<input type="hidden" value="<%=userName%>" /> <input type="hidden"
	value="<%=date%>" /> <input type="hidden" value="<%=time %>"></form>
</div>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdGynaecology"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
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
<form name="gynaecology" method="post" action="">
<h6>Socio-Economic History</h6>
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
	List<OpdGynaecology> opdGynaecologyist = new ArrayList<OpdGynaecology>();
	
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	
	if(detailsMap.get("patientDataList") != null){
		patientDataList=(List<Visit>)detailsMap.get("patientDataList");
	}	
	if(map.get("opdGynaecologyist") != null){
		opdGynaecologyist=(List<OpdGynaecology>)map.get("opdGynaecologyist");
	}
	OpdGynaecology opdObj = null;
	if(opdGynaecologyist.size() > 0){
		opdObj = (OpdGynaecology)opdGynaecologyist.get(0);
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
	 
	 
	 List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	 if(map.get("employeeList") != null){
			employeeList = (List<MasEmployee>) map.get("employeeList");
		}
	%> <!--Block One Starts-->

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
	class="valueNoWidth"><%=patientName %></label> <%}else{ %> <label
	class="valueNoWidth">-</label> <%} %>
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
Name</label> <%if(patientName!= null){ %> <label class="valueNoWidth"><%=patientName %>
</label> <%}else{ %> <label class="valueNoWidth">- </label> <%} %> <label
	class="medium">Prev. Diag </label> <%if(visit.getDiagnosis()!= null){ %>
<label class="valueNoWidth"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>

<div class="Clear"></div>

<label>Phone Number</label> <% if(visit.getHin().getPhoneNumber()!= null && !visit.getHin().getPhoneNumber().equals("")){%>
<label class="valueNoWidth"><%=visit.getHin().getPhoneNumber() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %> <label>Mobile
Number</label> <% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
<label class="valueNoWidth"><%=visit.getHin().getMobileNumber() %></label>
<%}else{ %> <label class="valueNoWidth">---</label> <%} %> <input
	type="hidden" id="max" name="max" value="<%=max %>"> <input
	type="hidden" id="<%=HIN_ID %>" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	id="<%=VISIT_ID %>" name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="division"></div>

<!--  block for Socio-Economic History   -->
<div class="floatRight">
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
<!--  block ends  for Socio-Economic History   --> <!--  start of collapse menu -->
<div class="floatLeft">
<div class="arrowlistmenu">
<h3 class="menuheader expandable">Obstetric & Gynaecology</h3>
<ul class="categoryitems">
	<li><a
		href="opd?method=viewGynaecology&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Socio-
	Economic History </a></li>
	<li><a
		href="opd?method=viewComplaints&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Complaints</a></li>
	<li><a
		href="opd?method=viewMedicalSurgicalHistory&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Medical/Surgical
	History </a></li>
	<li><a
		href="opd?method=viewObstetricMenstrualHistory&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Obstetric/Menstrual
	History </a></li>
	<li><a
		href="opd?method=viewGeneralExamination&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">General
	Examination </a></li>
	<li><a
		href="opd?method=viewSystemicExamination&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Systemic
	Examination </a></li>
</ul>
</div>
</div>
<!-- end of collapse menu -->
<div class="Clear"></div>
<div class="bottom">
<div class="paddLeft300">
<div class="paddLeft55">
<div class="paddLeft55"><input name="Submit" type="button"
	alt="Submit" value="Submit" class="button"
	onclick="submitForm('gynaecology','opd?method=submitSocioEconomicHistory');" /></div>
</div>
</div>
</div>
<input type="hidden" value="<%=userName%>" /> <input type="hidden"
	value="<%=date%>" /> <input type="hidden" value="<%=time %>"></form>
</div>

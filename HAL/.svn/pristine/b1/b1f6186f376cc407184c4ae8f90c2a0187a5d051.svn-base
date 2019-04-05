<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdOncology"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.text.SimpleDateFormat"%>
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

<%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<OpdOncology> opdOncologyList = null;
		OpdOncology opdOncology =null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	
		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
			}
		String buttonFlag="";
		 List patientDataList = new ArrayList();
			
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}		
	if(map.get("opdOncologyList") != null ){
		opdOncologyList=(List)map.get("opdOncologyList");
		if(opdOncologyList.size()>0)
		opdOncology = opdOncologyList.get(0);
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
<form name="oncosurgery" action="" method="post"><input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=visit.getDepartment().getId() %>" /> <%if(visit.getDepartment()!= null){ %>
<h6>Oncosurgery Case Sheet</h6>
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
<div class="blockTitle">Stage:</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label>T</label>
<div class="title"></div>

<label class="small">1</label>
<%if(opdOncology !=null && opdOncology.getStageT().equals("1")){ %>
<input class="radio" type="radio" value="1" name="<%=STAGE_T %>" checked="checked">
<%}else{ %>
<input class="radio" type="radio" value="1" name="<%=STAGE_T %>">
<%} %> 
<label class="small">2</label>
<%if(opdOncology !=null && opdOncology.getStageT().equals("2")){ %>
<input class="radio" type="radio" value="2" name="<%=STAGE_T %>" checked="checked">
<%}else{ %>
<input class="radio" type="radio" value="2" name="<%=STAGE_T %>">
<%} %> 
<label class="small">3</label>
<%if(opdOncology !=null && opdOncology.getStageT().equals("3")){ %>
<input class="radio" type="radio" value="3" name="<%=STAGE_T %>" checked="checked">
<%}else{ %>
<input class="radio" type="radio" value="3" name="<%=STAGE_T %>">
<%} %> 
<label class="small">4</label>
<%if(opdOncology !=null && opdOncology.getStageT().equals("4")){ %>
<input class="radio" type="radio" value="4" name="<%=STAGE_T %>" checked="checked">
<%}else{ %>
<input class="radio" type="radio" value="4" name="<%=STAGE_T %>">
<%} %> 
<div class="Clear"></div>
<label>N</label>
<div class="title"></div>

<label class="small">1</label>
<%if(opdOncology !=null && opdOncology.getStageN().equals("1")){ %>
<input class="radio" type="radio" value="1" name="<%=STAGE_N %>" checked="checked"> 
<%}else{%>
<input class="radio" type="radio" value="1" name="<%=STAGE_N %>"> 
<%} %>
<label class="small">2</label> 
<%if(opdOncology !=null && opdOncology.getStageN().equals("2")){ %>
<input class="radio" type="radio" value="2" name="<%=STAGE_N %>" checked="checked"> 
<%}else{%>
<input class="radio" type="radio" value="2" name="<%=STAGE_N %>"> 
<%} %>
<label class="small">3</label>
<%if(opdOncology !=null && opdOncology.getStageN().equals("3")){ %>
<input class="radio" type="radio" value="3" name="<%=STAGE_N %>" checked="checked"> 
<%}else{%>
<input class="radio" type="radio" value="3" name="<%=STAGE_N %>"> 
<%} %>
<div class="Clear"></div>
<label>M</label>
<div class="title"></div>
<label class="small">0</label>
<%if(opdOncology !=null && opdOncology.getStageM().equals("0")){ %>
<input class="radio" type="radio" value="0" name="<%=STAGE_M %>" checked="checked">  
<%}else{%>
<input class="radio" type="radio" value="0" name="<%=STAGE_M %>"> 
<%} %>
<label class="small">1</label>
<%if(opdOncology !=null && opdOncology.getStageM().equals("1")){ %>
<input class="radio" type="radio" value="1" name="<%=STAGE_M %>" checked="checked">  
<%}else{%>
<input class="radio" type="radio" value="1" name="<%=STAGE_M %>"> 
<%} %>
<label class="small">2</label>
<%if(opdOncology !=null && opdOncology.getStageM().equals("2")){ %>
<input class="radio" type="radio" value="2" name="<%=STAGE_M %>" checked="checked">  
<%}else{%>
<input class="radio" type="radio" value="2" name="<%=STAGE_M %>"> 
<%} %>
<div class="Clear"></div>
<label>NOR</label>
<div class="title"></div>

<label class="small">I</label>
<%if(opdOncology !=null && opdOncology.getStageNor().equals("1")){ %>
<input class="radio" type="radio" value="1" name="<%=STAGE_NOR%>" checked="checked">  
<%}else{%>
<input class="radio" type="radio" value="1" name="<%=STAGE_NOR%>"> 
<%} %>
<label class="small">II</label>
<%if(opdOncology !=null && opdOncology.getStageNor().equals("2")){ %>
<input class="radio" type="radio" value="2" name="<%=STAGE_NOR%>" checked="checked">  
<%}else{%>
<input class="radio" type="radio" value="2" name="<%=STAGE_NOR%>"> 
<%} %> 
<label class="small">III</label>
<%if(opdOncology !=null && opdOncology.getStageNor().equals("3")){ %>
<input class="radio" type="radio" value="3" name="<%=STAGE_NOR%>" checked="checked">  
<%}else{%>
<input class="radio" type="radio" value="3" name="<%=STAGE_NOR%>"> 
<%} %> 
<label class="small">IV</label>
<%if(opdOncology !=null && opdOncology.getStageNor().equals("4")){ %>
<input class="radio" type="radio" value="4" name="<%=STAGE_NOR%>" checked="checked">  
<%}else{%>
<input class="radio" type="radio" value="4" name="<%=STAGE_NOR%>"> 
<%} %>

<div class="Clear"></div>
<label>A</label> 
<%if(opdOncology !=null ){%>
<input type="text" name="<%=STAGE_A %>" value="<%=opdOncology.getStageA() %>" maxlength="20">
<%}else{ %>
<input type="text" name="<%=STAGE_A %>" value="" maxlength="20">
<%} %>
<label>B</label> 
<%if(opdOncology !=null ){%>
<input type="text" name="<%=STAGE_B %>" value="<%=opdOncology.getStageB() %>" maxlength="20">
<%}else{ %>
<input type="text" name="<%=STAGE_B %>" value="" maxlength="20">
<%} %>
</div>
<div class="Clear"></div>
<label>Medical Oncology</label>
<%if(opdOncology !=null ){%> 
<textarea id="b1" rows="" cols=""  maxlength="100" onkeyup="return ismaxlength(this)" name="<%=MEDICAL %>"><%=opdOncology.getMedicalOnco() %></textarea>
<%}else{ %>
<textarea id="b1" rows="" cols=""  maxlength="100" onkeyup="return ismaxlength(this)" name="<%=MEDICAL %>"></textarea>
<%} %>
<div class="Clear"></div>
<label>Surgery Oncology</label>
<%if(opdOncology !=null ){ %> 
<textarea id="b2" rows="" cols=""  maxlength="100" onkeyup="return ismaxlength(this)" name="<%=SURGERY %>"><%=opdOncology.getSurgeryOnco() %></textarea>
<%}else{ %>
<textarea id="b2" rows="" cols=""  maxlength="100" onkeyup="return ismaxlength(this)" name="<%=SURGERY %>"></textarea>
<%} %>

<div class="Clear"></div>
<label>RT</label> 
<%if(opdOncology !=null ){ %> 
<textarea id="b3" rows="" cols=""  maxlength="100" onkeyup="return ismaxlength(this)" name="<%=RT%>"><%=opdOncology.getRt() %></textarea>
<%}else{ %>
<textarea id="b3" rows="" cols=""  maxlength="100" onkeyup="return ismaxlength(this)" name="<%=RT%>"></textarea>
<%} %>
<div class="Clear"></div>

<label>Remarks</label>
<%if(opdOncology !=null ){ %> 
<textarea id="b4" rows=""  cols="" maxlength="100" onkeyup="return ismaxlength(this)" name="<%=REMARKS %>"><%=opdOncology.getRemarks() %></textarea>
<%}else{ %>
<textarea id="b4" rows="" cols=""  maxlength="100" onkeyup="return ismaxlength(this)" name="<%=REMARKS %>"></textarea>
<%} %>
<div class="Clear"></div>

<!--Block two Ends--> <input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> <input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="currentVisitId" value="<%=visit.getId() %>">
	<%if(opdOncology!=null){ %>
	<input type="hidden" name="opdOncologyId" value="<%=opdOncology.getId() %>" />
	<%}else{ %>
	<input type="hidden" name="opdOncologyId" value="0" />
	<%} %>
<div class="division"></div>

<div class="bottom">

<div class="Clear"></div>

<input type="button" class="button" value="Submit"
	onclick="submitForm('oncosurgery','opd?method=addOncosurgery');"
	align="right" /> <input type="button" class="button" value="View"
	onclick="submitForm('oncosurgery','opd?method=viewOncosurgery&flag=prev&viewScreen=no');" />
<input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="history.go(-1);return false;" align="right" /></div>
</form>
</div>
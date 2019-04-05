<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
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
<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String getDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(getDate.length()<2){
			getDate="0"+getDate;
		}
			
	%>
		serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>
<%
	
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");	 
	String currentTime = (String)utilMap.get("currentTime");
	
	 List opdSurgeryList = new ArrayList();
	 List opdSurgeryDetailList= new ArrayList();
	 List otList= new ArrayList();
	 List empList= new ArrayList();
	if(map.get("opdSurgeryList") != null){
		opdSurgeryList=(List)map.get("opdSurgeryList");
	}
	if(map.get("opdSurgeryDetailList") != null){
		opdSurgeryDetailList=(List)map.get("opdSurgeryDetailList");
	}
	if(map.get("otList") != null){
		otList=(List)map.get("otList");
	}
	if(map.get("empList") != null){
		empList=(List)map.get("empList");
	}
	OpdSurgeryHeader opdSurgeryHeader=(OpdSurgeryHeader)opdSurgeryList.get(0);
	
	String patientName="";
	if(opdSurgeryHeader.getHin().getPFirstName()!= null){
		patientName=opdSurgeryHeader.getHin().getPFirstName();
	}
	if(opdSurgeryHeader.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+opdSurgeryHeader.getHin().getPMiddleName();
	}
	if(opdSurgeryHeader.getHin().getPLastName()!= null){
		patientName=patientName+" "+opdSurgeryHeader.getHin().getPLastName();
	}
	String servicePersonName="";
	if(opdSurgeryHeader.getHin().getSFirstName()!= null){
		servicePersonName=opdSurgeryHeader.getHin().getSFirstName();
	}
	if(opdSurgeryHeader.getHin().getSMiddleName()!= null){
		servicePersonName=servicePersonName+" "+opdSurgeryHeader.getHin().getSMiddleName();
	}
	if(opdSurgeryHeader.getHin().getSLastName()!= null){
		servicePersonName=servicePersonName+" "+opdSurgeryHeader.getHin().getSLastName();
	}
	 String requisitionDateInString =HMSUtil.changeDateToddMMyyyy(opdSurgeryHeader.getRequisitionDate());
	int deptId=opdSurgeryHeader.getPrescribedDepartment().getId();
	String departmentName=opdSurgeryHeader.getPrescribedDepartment().getDepartmentName();
	
	%>


<!--main content placeholder starts here-->

<div id="contentHolder">
<form name="otBooking" method="post" action="">
<h6>Pre-Anesthesia Procedure Notes Entry</h6>
<div class="Clear"></div>
<div class="header"><label>Yearly Serial No. </label> <label
	class="value">101/2008</label> <label>Monthly Serial No. </label> <label
	class="value">05/07</label> <input name="Patient Search" type="button"
	value="Patient Search" class="cmnButton" /></div>
<div class="Clear"></div>
<!--Block One Starts-->
<div class="blockTitle">Patient Particulars</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label>Patient Name </label> <label class="value">Mahendra Singh</label>
<label class="medium">HIN No.</label> <label class="valuemedium"></label>
<label class="medium">Service No. </label> <label class="valuemedium"></label>


<label class="medium">Relation</label> <label class="value"></label>
<div class="Clear"></div>

<label>Service Person Name </label> <label class="value"><%=opdSurgeryHeader.getHin().getRelation().getRelationName() %></label>
<label class="medium">Rank</label> <label class="valuemedium"></label> <label
	class="medium">Unit</label> <label class="valuemedium"></label> <label
	class="medium">Age</label> <label class="valueNoWidth"></label> <label
	class="medium">Sex</label> <label class="valueNoWidth"></label>
<div class="Clear"></div>
<label>Date</label> <label class="value">12/12/2008</label> <label
	class="medium">Weight (kg)</label> <label class="valuemedium">55</label>
<div class="Clear"></div>
<label>Diagnosis</label> <label class="valueNoWidth"></label>
<div class="Clear"></div>
<label>Surgery</label> <label class="valueNoWidth"></label>
<div class="Clear"></div>
</div>
<div class="division"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Surgery Name</label> <textarea
	name="surgery name" cols="0" rows="0" class="large"></textarea></div>
<div class="division"></div>

<div class="Clear"></div>
<label class="common">Premedication</label> <input name="Add"
	type="button" class="cmnButton" value="Add" /> <input name="Delete"
	type="button" class="cmnButton" value="Delete" />
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Select</th>
		<th scope="col">PVMS/ NIV No.</th>
		<th scope="col">Nomenclature</th>
		<th scope="col">Dose</th>
		<th scope="col">Route</th>
	</tr>
	<tr>
		<td><input name="radiobutton" type="radio" value="radiobutton" /></td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td><input type="text" name="textfield" /></td>
		<td><select name="select">
		</select></td>
	</tr>
</table>



</div>
<div class="Clear"></div>
<div class="blockFrame"><label>Remarks</label> <textarea
	name="surgery name" cols="0" rows="0" class="large"></textarea></div>
<div class="division"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=currentDate %></label>

<label>Changed Time</label> <label class="value"><%=currentTime %></label>
<div class="Clear"></div>
<div class="Height10"></div>

<input type="button" name="Submit" class="button" value="Submit"
	onclick="submitForm ('otBooking','ot?method=submitOTBookingDetails')" />
<input name="hinId" type="hidden"
	value="<%=opdSurgeryHeader.getHin().getId() %>" /> <input
	name="patientStatus" type="hidden"
	value="<%=opdSurgeryHeader.getPatientStatus() %>" /> <input
	name="orderNo" type="hidden"
	value="<%=opdSurgeryHeader.getOrderNo() %>" /> <input
	name="hospitalId" type="hidden" value="<%=hospitalId %>" /> <input
	name="changedBy" type="hidden" value="<%=userName %>" /> <input
	name="changedDate" type="hidden" value="<%=currentDate %>" /> <input
	name="changedTime" type="hidden" value="<%=currentTime %>" /> <input
	name="back" type="button" class="button" value="Back" /></div>
</form>
</div>


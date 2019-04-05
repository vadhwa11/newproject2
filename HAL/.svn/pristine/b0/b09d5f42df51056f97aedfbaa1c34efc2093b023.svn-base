<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCard"%>
<%@page import="jkt.hms.masters.business.OpdGravidagramHtn"%>
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
animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide4', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide5', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

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
<form name="antenatalCard" method="post" action="">
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
	List<OpdAntenatalCard> antenatalCardList = new ArrayList<OpdAntenatalCard>();
	
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	
	if(detailsMap.get("patientDataList") != null){
		patientDataList=(List<Visit>)detailsMap.get("patientDataList");
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
	 
	 
	 List<OpdGravidagramHtn> opdGravidagramHtnList= new ArrayList<OpdGravidagramHtn> ();
		if(map.get("opdGravidagramHtnList") != null){
			opdGravidagramHtnList=(List)map.get("opdGravidagramHtnList");
		}
		
	%> <script type="text/javascript">
function get_valueForEdit(n)
{
 var url="/hms/hms/opd?method=showAntenatalCardEditJsp&aId="+n+"&visitId=<%=visit.getId() %>";
   popwindow(url);
  
 }  
function get_valueForGravidagramHTN(visitId)
{
 var url="/hms/hms/opd?method=showGravidagramHTNJsp&visitId=<%=visit.getId() %>";
   popwindowGravidagramHTN(url);
  
 } 

var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name',"height=50,width=1000,status=1");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();
 window.close();
}
function popwindowGravidagramHTN(url)
{

 newwindow=window.open(url,'name',"height=200,width=1000,status=1");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();
 window.close();
}		

function back() {
window.close();
return;

}


</script> <input type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=visit.getDepartment().getId() %>" /> <%if(visit.getDepartment()!= null){ %>
<h6>Gravidagram HTN</h6>
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
<label class="medium">Tel No.</label> <% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
<label class="valuemedium"><%=visit.getHin().getMobileNumber() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>

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

</div>

<!--Block one Ends--> <% 
  if(opdGravidagramHtnList.size() > 0){
	
	OpdGravidagramHtn gravidagramHtn = new OpdGravidagramHtn();
	gravidagramHtn = opdGravidagramHtnList.get(0);
	
	%>
<div class="division"></div>
<div class="tableHolderAuto"><label>Present Records</label>
<div class="Clear"></div>
<div class="Height10"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">


	<tr>
		<th scope="col">Date</th>
		<th scope="col">Weeks</th>
		<th scope="col">Days</th>
		<th scope="col">AM</th>
		<th scope="col">PM</th>
		<th scope="col">DFMC</th>
		<th scope="col">FHS</th>
		<th scope="col">FUNDAL HT</th>
		<th scope="col">ABDO GIRTH</th>
		<th scope="col">WT Kg</th>
		<th scope="col">U ALB</th>
		<th scope="col">USB?AFI<br />
		(See Reverse also)</th>
		<th scope="col">NST</th>
		<th scope="col">HAEMAT/BIOCHEM <br />
		INVES TIGATIONS <br />
		(see reverse also)</th>
	</tr>

	<tr>
		<td><input type="text" id="depIssueDateId" name="<%=DATE%>"
			size="10" readonly="readonly"
			value="<%=HMSUtil.changeDateToddMMyyyy(gravidagramHtn.getGravidagramHtnDate()) %>" /></td>
		<td><input name="<%=WEEKS%>" type="text" size=5 maxlength="10"
			value="<%=gravidagramHtn.getPogWeeks()%>" readonly="readonly" /></td>
		<td><input name="<%=DAYS %>" type="text" size=5 maxlength="10"
			value="<%=gravidagramHtn.getPogDays()%>" readonly="readonly" /></td>
		<td><input name="<%=AM%>" type="text" size=3 maxlength="6"
			value="<%=gravidagramHtn.getBpAm()%>" readonly="readonly" /></td>
		<td><input name="<%=PM%>" type="text" size=3 maxlength="6"
			value="<%=gravidagramHtn.getBpPm()%>" readonly="readonly" /></td>
		<td><input name="<%=DFMC %>" type="text" size=10 maxlength="20"
			value="<%=gravidagramHtn.getFetusDffmc()%>" readonly="readonly" /></td>
		<td><input name="<%=FHS %>" type="text" size=10 maxlength="20"
			value="<%=gravidagramHtn.getFetusFhs()%>" readonly="readonly" /></td>
		<td><input name="<%=FUBDAL_HT %>" type="text" size=10
			maxlength="20" value="<%=gravidagramHtn.getFundalHt()%>"
			readonly="readonly" /></td>
		<td><input name="<%=ABDO_GIRTH %>" type="text" size=10
			maxlength="20" value="<%=gravidagramHtn.getAbdoGirth()%>"
			readonly="readonly" /></td>
		<td><input name="<%=WT_KG %>" type="text" size=5 maxlength="10"
			value="<%=gravidagramHtn.getWtKg()%>" readonly="readonly" /></td>
		<td><input name="<%=U_ALB %>" type="text" size=10 maxlength="20"
			value="<%=gravidagramHtn.getUAlb()%>" readonly="readonly" /></td>
		<td><input name="<%=USB_AFI %>" type="text" size=10
			maxlength="20" value="<%=gravidagramHtn.getUsgAfi()%>"
			readonly="readonly" /></td>
		<td><input type="text" id="depIssueDateId" name="<%=NST %>"
			size="10" value="<%=gravidagramHtn.getNst()%>" readonly="readonly" /></td>
		<td><input name="<%=HAEMAT %>" type="text" size=10 maxlength="20"
			value="<%=gravidagramHtn.getHaematBiochemInvestigations()%>"
			readonly="readonly" /></td>
	</tr>

</table>

</div>
<div class="Clear"></div>

<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	id="visitId" name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<input type="hidden" id="visitNo" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="currentVisitId" value="<%=currentVisitId %>"> <input
	type="hidden" id="max" name="max" value="<%=max %>"> <input
	name="prev" type="button" class="cmnButton" value="Prev"
	onclick="submitForm('antenatalCard','opd?method=viewGravidagramHTN&flag=prev','patientVisitPrev');">
<input name="next" type="button" class="cmnButton" value="Next"
	onclick="submitForm('antenatalCard','opd?method=viewGravidagramHTN&flag=next','patientVisitNext');">
<input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Close" class="cmnButton" onclick="back();"
	align="right" /> <% }else
{%> <label><span>No Record Found!!</span></label>

<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	id="visitId" name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<input type="hidden" id="visitNo" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="currentVisitId" value="<%=currentVisitId %>"> <input
	type="hidden" id="max" name="max" value="<%=max %>"> <input
	name="prev" type="button" class="cmnButton" value="Prev"
	onclick="submitForm('antenatalCard','opd?method=viewGravidagramHTN&flag=prev','patientVisitPrev');">
<input name="next" type="button" class="cmnButton" value="Next"
	onclick="submitForm('antenatalCard','opd?method=viewGravidagramHTN&flag=next','patientVisitNext');">
<input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="cmnButton"
	onclick="submitForm('antenatalCard','opd?method=showGravidagramHTNJsp&visitId=<%=visit.getId()%>');"
	align="right" /> <%} %>
</form>
</div>

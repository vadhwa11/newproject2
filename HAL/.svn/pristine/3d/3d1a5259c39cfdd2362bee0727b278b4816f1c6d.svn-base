<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdOncology"%>
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
<form name="oncosurgery" action="" method="post">
<h6>OPD Onco Surgery Case Sheet</h6>
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
	List<OpdOncology> oncosurgeryList = new ArrayList<OpdOncology>();
	
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
	if(map.get("oncosurgeryList") != null){
		oncosurgeryList=(List<OpdOncology>)map.get("oncosurgeryList");
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
if(oncosurgeryList.size() > 0){
	
	OpdOncology oncosurgery = new OpdOncology();
	oncosurgery = oncosurgeryList.get(0);
%> <!--Block two Start-->

<div class="Clear"></div>
<label>Stage:</label>
<div class="Clear"></div>
<label class="valueNoWidth">T:</label> <%if(oncosurgery.getStageT() != "1"){ %>
<label>1</label> <%}else if(oncosurgery.getStageT() != "2"){ %> <label>2</label>
<%}else if(oncosurgery.getStageT() != "3"){ %> <label>3</label> <%}else if(oncosurgery.getStageT() != "4"){ %>
<label>4</label> <%}else{ %> <label class="noWidth">-</label> <%} %>
<div class="Clear"></div>
<label class="valueNoWidth">N:</label> <%if(oncosurgery.getStageT() != "1"){ %>
<label>1</label> <%}else if(oncosurgery.getStageT() != "2"){ %> <label>2</label>
<%}else if(oncosurgery.getStageT() != "3"){ %> <label>3</label> <%}else{ %>
<label class="noWidth">-</label> <%} %>
<div class="Clear"></div>
<label class="valueNoWidth">M:</label> <%if(oncosurgery.getStageT() != "0"){ %>
<label>0</label> <%}else if(oncosurgery.getStageT() != "1"){ %> <label>1</label>
<%}else if(oncosurgery.getStageT() != "2"){ %> <label>2</label> <%}else{ %>
<label class="noWidth">-</label> <%} %>
<div class="Clear"></div>

<%if(oncosurgery.getStageT() != "I"){ %> <label>I</label> <%}else if(oncosurgery.getStageT() != "II"){ %>
<label>II</label> <%}else if(oncosurgery.getStageT() != "III"){ %> <label>III</label>
<%}else if(oncosurgery.getStageT() != "IV"){ %> <label>IV</label> <%}else{ %>
<label class="noWidth">-</label> <%} %>
<div class="Clear"></div>

<label>A</label> <%if(oncosurgery.getStageA() != ""){ %> <label
	class="valueNoWidth"><%=oncosurgery.getStageA() %></label> <%}else{ %> <label
	class="valueNoWidth">-</label> <%} %> <label>B</label> <%if(oncosurgery.getStageB() != ""){ %>
<label class="valueNoWidth"><%=oncosurgery.getStageB() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %>

<div class="Clear"></div>

<label class="valueNoWidth">Medical Oncology</label> <%if(oncosurgery.getMedicalOnco() != ""){ %>
<label class="valueNoWidth"><%=oncosurgery.getMedicalOnco() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %>
<div class="Clear"></div>
<label class="valueNoWidth">Surgery Oncology</label> <%if(oncosurgery.getSurgeryOnco() != ""){ %>
<label class="valueNoWidth"><%=oncosurgery.getSurgeryOnco() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %>
<div class="Clear"></div>

<label class="valueNoWidth">RT</label> <%if(oncosurgery.getRt() != ""){ %>
<label class="valueNoWidth"><%=oncosurgery.getRt() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %>
<div class="Clear"></div>

<label class="valueNoWidth">Remarks</label> <%if(oncosurgery.getRemarks() != ""){ %>
<label class="valueNoWidth"><%=oncosurgery.getRemarks() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %>


<div class="Clear"></div>

<div class="Clear"></div>

<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=DEPARTMENT_ID %>" value="<%=visit.getDepartment().getId() %>" />
<input type="hidden" id="visitNo" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	id="currentVisitId" name="currentVisitId" value="<%=currentVisitId %>">
<input type="hidden" id="max" name="max" value="<%=max %>"> <input
	type="hidden" id="visitId" value="<%=visit.getId() %>"> <!--Bottom labels starts-->
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName %></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label>

<div class="Clear"></div>
<input name="prev" type="button" class="button" value="Prev"
	onclick="submitForm('oncosurgery','opd?method=viewOncosurgery&flag=prev','patientVisitPrev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('oncosurgery','opd?method=viewOncosurgery&flag=next','patientVisitNext');">
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('oncosurgery','<%=url%>');" align="right" /></div>
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
	onclick="submitForm('oncosurgery','opd?method=viewOncosurgery&flag=prev','patientVisitPrev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('oncosurgery','opd?method=viewOncosurgery&flag=next','patientVisitNext');">
<input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('oncosurgery','opd?method=showOncosurgeryJsp&visitId=<%=visit.getId() %>');"
	align="right" /></div>


</div>
<!--Bottom labels ends-->
<%} %>

<div class="division"></div>
</form>
</div>

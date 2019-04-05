<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdOphFollowUp"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="viewOphthalmologyFollowUp" method="post" action="">
<h6>View Ophthalmology Follow Up</h6>
<div class="Clear"></div>

<!--Block One Starts--> <%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		
		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<OpdOphFollowUp> ophFollowUpList = new ArrayList<OpdOphFollowUp>();
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}		
		
		if(detailsMap.get("patientDataList") != null){
			patientDataList=(List<Visit>)detailsMap.get("patientDataList");
		}	
		if(map.get("ophFollowUpList") != null){
			ophFollowUpList=(List<OpdOphFollowUp>)map.get("ophFollowUpList");
		}	
		int visitId = 0;
		int currentVisitId = 0;
		if(map.get("visitId") != null){
			visitId = (Integer)map.get("visitId");
		}
		if(map.get("currentVisitId") != null){
			currentVisitId = (Integer)map.get("currentVisitId");
		}
%> <%
if(ophFollowUpList.size() > 0){
	
	OpdOphFollowUp ophFollowUp = new OpdOphFollowUp();
	ophFollowUp = ophFollowUpList.get(0);
	
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
	
%>
<div class="BlockFrame"><label>Name</label> <%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label> <%}else{ %> <label
	class="value">- </label> <%} %> <label>Service No.</label> <%if(visit.getHin().getServiceNo() != null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %> </label> <%}else{ %>
<label class="value">- </label> <%} %> <label>HIN</label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="value"><%=visit.getHin().getHinNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>
<div class="Clear"></div>
<label>Rank</label> <%if(visit.getHin().getRank()!= null){ %> <label
	class="value"><%=visit.getHin().getRank().getRankName() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Age</label> <%if(visit.getAge()!= null){ %>
<label class="value"><%=visit.getAge() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Unit</label> <%if(visit.getHin().getUnit()!= null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="Clear"></div>
<label>Trade</label> <%if(visit.getHin().getTrade()!= null){ %> <label
	class="value"><%=visit.getHin().getTrade().getTradeName() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Visit No.</label> <%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Visit Date</label> <%if(visitDateInString!= null){ %>
<label class="value"><%=visitDateInString%></label> <%}else{ %> <label
	class="value">-</label> <%} %>
</div>
<!--Block one Ends-->
<div class="division"></div>


<!--Block Three Starts-->
<div class="colsHolder">

<div class="floatRight">
<div class="blockFrameSm">
<div class="blockTitle">System &amp; Functional Assesment</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<h5>Vision</h5>
<div class="Clear"></div>
<label>Ant Segment</label> <label class="valueNoWidth">RE</label> <%
	if(ophFollowUp.getAntSegmentRe() != null){
%> <input name="<%=ANT_SEGMENT_RE %>" type="text"
	value="<%= ophFollowUp.getAntSegmentRe()%>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=ANT_SEGMENT_RE %>" type="text" value="" maxlength="20"
	readonly="readonly"> <%} %> <label class="valueNoWidth">LE</label>
<%
	if(ophFollowUp.getAntSegmentLe() != null){
%> <input name="<%=ANT_SEGMENT_LE%>" type="text"
	value="<%=ophFollowUp.getAntSegmentLe() %>" size="10" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=ANT_SEGMENT_LE%>" type="text" value="" size="10"
	maxlength="20" readonly="readonly"> <%} %>
<div class="Clear"></div>
<label>IOP</label> <label class="valueNoWidth">&nbsp;&nbsp;&nbsp;&nbsp;</label>
<%
	if(ophFollowUp.getIop() != null){
%> <input name="<%=IOP%>" type="text" value="<%=ophFollowUp.getIop() %>"
	size="10" maxlength="20" readonly="readonly"> <%}else{ %> <input
	name="<%=IOP%>" type="text" value="" size="10" maxlength="20"
	readonly="readonly"> <%} %>
<div class="Clear"></div>
<h5>Fundus</h5>
<div class="Clear"></div>
<label>RE</label> <label class="valueNoWidth">&nbsp;&nbsp;&nbsp;&nbsp;</label>
<%
	if(ophFollowUp.getFundusRe() != null){
%> <input name="<%=FUNDUS_RE %>" type="text"
	value="<%=ophFollowUp.getFundusRe() %>" size="10" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=FUNDUS_RE %>"
	type="text" value="" size="10" maxlength="20" readonly="readonly">
<%} %> <label class="noWidth">LE</label> <%
	if(ophFollowUp.getFundusLe() != null){
%> <input name="<%=FUNDUS_LE%>" type="text"
	value="<%=ophFollowUp.getFundusLe() %>" size="10" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=FUNDUS_LE%>"
	type="text" value="" size="10" maxlength="20" readonly="readonly">
<%} %> <label class="noWidth">Adv</label> <%
	if(ophFollowUp.getAdv() != null){
%> <input name="<%=ADV%>" type="text" value="<%=ophFollowUp.getAdv() %>"
	size="10" maxlength="20" readonly="readonly"> <%}else{ %> <input
	name="<%=ADV%>" type="text" value="" size="10" maxlength="20"
	readonly="readonly"> <%} %>
</div>
</div>
</div>
<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><input name="prev" type="button"
	class="button" value="Prev"
	onclick="submitForm('viewOphthalmologyFollowUp','opd?method=viewOphthalmologyFollowUp&flag=prev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('viewOphthalmologyFollowUp','opd?method=viewOphthalmologyFollowUp&flag=next');">
<input name="back" type="button" class="button" value="Back"
	onclick="submitForm('viewOphthalmologyFollowUp','opd?method=showOphthalmologyFollowUpJsp&visitId=<%=currentVisitId %>');">
</div>

<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_ID %>" value="<%=visitId %>"> <input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="currentVisitId" value="<%=currentVisitId %>"> <!--Bottom labels ends-->
<%}else{%> No Record Found!! <!--Bottom labels starts-->
<div class="bottom"><input name="back" type="button"
	class="button" value="Back"
	onclick="submitForm('viewOphthalmologyFollowUp','opd?method=showOphthalmologyFollowUpJsp&visitId=<%=currentVisitId %>');">
</div>
<!--Bottom labels ends--> <%} %>
</form>
</div>
<!--main content placeholder ends here-->

<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdOphRetinalHeader"%>
<%@page import="jkt.hms.masters.business.OpdOphRetinalDetails"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="viewOphthalmologyRetinal" method="post" action="">
<h6>Retinal Laser Proforma</h6>
<div class="Clear"></div>

<!--Block One Starts--> <%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<OpdOphRetinalHeader> ophRetinalList = new ArrayList<OpdOphRetinalHeader>();
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}	
		if(detailsMap.get("patientDataList") != null){
			patientDataList=(List<Visit>)detailsMap.get("patientDataList");
		}	
		if(map.get("ophRetinalList") != null){
			ophRetinalList=(List<OpdOphRetinalHeader>)map.get("ophRetinalList");
		}
		int visitId = 0;
		int currentVisitId = 0;
		if(map.get("visitId") != null){
			visitId = (Integer)map.get("visitId");
		}
		if(map.get("currentVisitId") != null){
			currentVisitId = (Integer)map.get("currentVisitId");
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
%> <%

	if(ophRetinalList.size() >0){
		OpdOphRetinalHeader ophRetinalHeader = ophRetinalList.get(0);
		Set<OpdOphRetinalDetails> detailsSet = ophRetinalHeader.getOpdOphRetinalDetails();
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

<div class="division"></div>
<div class="Clear"></div>
<label>Right Eye</label> <input name="<%=RIGHT_EYE %>" type="text"
	value="" maxlength="25" readonly="readonly"> <script
	type="text/javascript">
<%
	if(ophRetinalHeader.getRightEye() != null){
%>
	document.viewOphthalmologyRetinal.<%=RIGHT_EYE%>.value = '<%=ophRetinalHeader.getRightEye()%>';
<%} %>
</script> <label>Left Eye</label> <input name="<%=LEFT_EYE%>" type="text"
	value="" maxlength="25" readonly="readonly"> <script
	type="text/javascript">
<%
	if(ophRetinalHeader.getLeftEye() != null){
%>
	document.viewOphthalmologyRetinal.<%=LEFT_EYE%>.value = '<%=ophRetinalHeader.getLeftEye()%>';
<%} %>
</script>

<div class="Clear"></div>
<div class="tableHholderCmn">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>Eye</th>
		<th>Power</th>
		<th>Duration</th>
		<th>No. of Spots</th>
		<th>Laser Type</th>
		<th>Dr. Name</th>
		<th>Sign</th>
	</tr>
	<%
  	for(OpdOphRetinalDetails retinalDetails : detailsSet){
  %>
	<tr>
		<td>
		<%
		if(retinalDetails.getEye() != null){
			if(retinalDetails.getEye().equals("LE")){
	%> <input name="<%=EYE%>" type="text" value="Left Eye" size="8"
			readonly="readonly"> <%
			}else if(retinalDetails.getEye().equals("RE")){
	%> <input name="<%=EYE%>" type="text" value="Right Eye" size="8"
			readonly="readonly"> <%	}else{
			%> <input name="<%=EYE%>" type="text" value="" size="8"
			readonly="readonly"> <%}
		}%>
		</td>
		<td>
		<%
    	if(retinalDetails.getPower() != null){
    %> <input type="text" name="<%=POWER %>"
			value="<%= retinalDetails.getPower()%>" size="10"
			validate="Power,string,no" tabindex="1" maxlength="10"
			readonly="readonly" /> <%}else{ %> <input type="text"
			name="<%=POWER %>" value="" size="10" validate="Power,string,no"
			tabindex="1" maxlength="10" readonly="readonly" /> <%} %>
		</td>
		<td>
		<%
    	if(retinalDetails.getDuration() != null){
    %> <input type="text" name="<%=DURATION %>"
			value="<%=retinalDetails.getDuration() %>" size="10"
			validate="Duration,string,no" tabindex="1" maxlength="10"
			readonly="readonly" /> <%}else{ %> <input type="text"
			name="<%=DURATION %>" value="" size="10"
			validate="Duration,string,no" tabindex="1" maxlength="10"
			readonly="readonly" /> <%} %>
		</td>
		<td>
		<%
    	if(retinalDetails.getNoOfSpots() != null){
    %> <input type="text" name="<%=NO_OF_SPOTS %>"
			value="<%=retinalDetails.getNoOfSpots() %>" size="10"
			validate="No.Of Spots,string,no" tabindex="1" maxlength="10"
			readonly="readonly" /> <%}else{ %> <input type="text"
			name="<%=NO_OF_SPOTS %>" value="" size="10"
			validate="No.Of Spots,string,no" tabindex="1" maxlength="10"
			readonly="readonly" /> <%} %>
		</td>
		<td>
		<%
    	if(retinalDetails.getLaserType() != null){
    %> <input type="text" name="<%=LASER_TYPE %>"
			value="<%=retinalDetails.getLaserType() %>" size="20"
			validate="Laser Type,string,no" tabindex="1" maxlength="20"
			readonly="readonly" /> <%}else{ %> <input type="text"
			name="<%=LASER_TYPE %>" value="" size="20"
			validate="Laser Type,string,no" tabindex="1" maxlength="20"
			readonly="readonly" /> <%} %>
		</td>
		<td>
		<%
    	if(retinalDetails.getDoctorName() != null){
    %> <input type="text" name="<%=DOCTOR_NAME %>"
			value="<%=retinalDetails.getDoctorName() %>" size="20"
			validate="Doctor Name,string,no" tabindex="1" maxlength="45"
			readonly="readonly" /> <%}else{ %> <input type="text"
			name="<%=DOCTOR_NAME %>" value="" size="20"
			validate="Doctor Name,string,no" tabindex="1" maxlength="45"
			readonly="readonly" /> <%} %>
		</td>
		<td>
		<%
    	if(retinalDetails.getSign() != null){
    %> <input type="text" name="<%=SIGN %>"
			value="<%=retinalDetails.getSign() %>" size="15"
			validate="Sign,string,no" tabindex="1" maxlength="25"
			readonly="readonly" /> <%}else{ %> <input type="text" name="<%=SIGN %>"
			value="" size="15" validate="Sign,string,no" tabindex="1"
			maxlength="25" readonly="readonly" /> <%} %>
		</td>
	</tr>
	<%} %>

</table>
</div>
</div>
</div>
</div>

<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> <input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="currentVisitId" value="<%=currentVisitId %>"> <!--Bottom labels starts-->
<div class="bottom"><input name="prev" type="button"
	class="button" value="Prev"
	onclick="submitForm('viewOphthalmologyRetinal','opd?method=viewOphthalmologyRetinal&flag=prev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('viewOphthalmologyRetinal','opd?method=viewOphthalmologyRetinal&flag=next');">
<input name="back" type="button" class="button" value="Back"
	onclick="submitForm('viewOphthalmologyRetinal','opd?method=showOphthalmologyRetinalJsp&visitId=<%=currentVisitId %>');">
</div>
<!--Bottom labels ends--> <%}else{ %> No Record Found!! <!--Bottom labels starts-->
<div class="bottom"><input name="back" type="button"
	class="button" value="Back"
	onclick="submitForm('viewOphthalmologyRetinal','opd?method=showOphthalmologyRetinalJsp&visitId=<%=currentVisitId %>');">
</div>
<!--Bottom labels ends--> <%} %>
</form>
</div>
<!--main content placeholder ends here-->

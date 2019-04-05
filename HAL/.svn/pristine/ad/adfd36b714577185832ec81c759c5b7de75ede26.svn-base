<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
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
<form name="ophthalmologyRetinal" method="post" action="">
<h6>Retinal Laser Proforma</h6>
<div class="Clear"></div>

<!--Block One Starts--> <%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		
		List<Visit> patientDataList = new ArrayList<Visit>();
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}	
		if(map.get("patientDataList") != null){
			patientDataList=(List<Visit>)map.get("patientDataList");
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

<div class="floatLeft"><input name="patient fast history3"
	type="button" class="navButtons" value="Ophthalmology"
	onclick="submitForm('ophthalmologyRetinal','opd?method=showOpdOphthamologyJsp&visitId=<%=visit.getId() %>');" />
<input name="patient fast history" type="button" class="navButtons"
	value="Follow Up"
	onclick="submitForm('ophthalmologyRetinal','/hms/hms/opd?method=showOphthalmologyFollowUpJsp');" />
<input name="patient fast history23" type="button" class="navButtons"
	value="Diagnosis"
	onclick="submitForm('ophthalmologyRetinal','opd?method=showOphthalmologyDiagnosisJsp');" />
</div>
<div class="floatRight">
<div class="blockFrameSm">

<div class="division"></div>
<div class="Clear"></div>
<label>Right Eye</label> <input name="<%=RIGHT_EYE %>" type="text"
	value="" maxlength="25"> <label>Left Eye</label> <input
	name="<%=LEFT_EYE%>" type="text" value="" maxlength="25">
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
  	for(int i=1;i<=2;i++){
  
  %>
	<tr>
		<td width="10%"><select name="<%=EYE %>">
			<option value="">Select</option>
			<option value="LE">Left Eye</option>
			<option value="RE">Right Eye</option>
		</select></td>
		<td><input type="text" name="<%=POWER %>" value="" size="10"
			validate="Power,string,no" tabindex="1" maxlength="10" /></td>
		<td><input type="text" name="<%=DURATION %>" value="" size="10"
			validate="Duration,string,no" tabindex="1" maxlength="10" /></td>
		<td><input type="text" name="<%=NO_OF_SPOTS %>" value=""
			size="10" validate="No.Of Spots,string,no" tabindex="1"
			maxlength="10" /></td>
		<td><input type="text" name="<%=LASER_TYPE %>" value="" size="20"
			validate="Laser Type,string,no" tabindex="1" maxlength="20" /></td>
		<td><input type="text" name="<%=DOCTOR_NAME %>" value=""
			size="20" validate="Doctor Name,string,no" tabindex="1"
			maxlength="45" /></td>
		<td><input type="text" name="<%=SIGN %>" value="" size="15"
			validate="Sign,string,no" tabindex="1" maxlength="25" /></td>
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
	type="hidden" name="currentVisitId" value="<%=visit.getId() %>">
<input type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <!--Bottom labels starts-->
<div class="bottom"><input name="Save" type="button"
	class="button" value="Submit"
	onclick="if(checkBlankForOphthalmology('ophthalmologyRetinal')){submitForm('ophthalmologyRetinal','opd?method=submitOphthalmologyRetinal');}">
<input name="view" type="button" class="button" value="View"
	onclick="submitForm('ophthalmologyRetinal','opd?method=viewOphthalmologyRetinal&flag=prev');">
<input name="reset" type="reset" class="button" value="Reset"></div>
<!--Bottom labels ends--></form>
</div>
<!--main content placeholder ends here-->

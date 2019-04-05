<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdOphthalmology"%>

<%@page import="jkt.hms.masters.business.OpdObg"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="viewObg" method="post" action="">
<h6>OPD OBG</h6>
<div class="Clear"></div>

<!--Block One Starts--> <%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<OpdObg> obgList = new ArrayList<OpdObg>();
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}		
		
		if(detailsMap.get("patientDataList") != null){
			patientDataList=(List<Visit>)detailsMap.get("patientDataList");
		}	
		if(map.get("obgList") != null){
			obgList=(List<OpdObg>)map.get("obgList");
		}	
		int currentVisitId = 0;
		if(map.get("currentVisitId") != null){
			currentVisitId = (Integer)map.get("currentVisitId");
		}
		
		
%> <%
if(obgList.size() > 0){
	
	OpdObg opdObg = new OpdObg();
	opdObg = obgList.get(0);
	
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
<div class="blockFrame">

<div class="Clear"></div>

<label>Name </label> <%if(patientName!= null){ %> <label class="value"><%=patientName %>
</label> <%}else{ %> <label class="value">- </label> <%} %> <label>Service
No. </label> <%if(visit.getHin().getServiceNo()!= null){ %> <label class="value"><%=visit.getHin().getServiceNo() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>HIN No. </label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="value"><%=visit.getHin().getHinNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>



<div class="Clear"></div>

<label>Rank</label> <%if(visit.getHin().getRank()!= null){ %> <label
	class="value"><%=visit.getHin().getRank().getRankName() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Age</label> <%if(visit.getHin().getAge()!= null){ %>
<label class="value"><%=visit.getHin().getAge() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Unit </label> <%if(visit.getHin().getUnit()!= null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>



<div class="Clear"></div>

<label>Visit Date <span>*</span></label> <%if(visitDateInString != null){ %>
<label class="value"><%=visitDateInString %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Visit no. <span>*</span></label> <%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Token No. </label> <%if(visit.getTokenNo()!= null){ %>
<label class="value"><%=visit.getTokenNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>
<div class="Clear"></div>

<label>Trade/AF/Navy/Army </label> <%if(visit.getHin().getTrade() != null){ %>
<label class="value"><%=visit.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>DOA </label> <%if(visitDateInString != null){ %>
<label class="value"><%=visitDateInString %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Husband's Name</label> <label
	class="value">-</label></div>
<!--Block one Ends-->

<div class="division"></div>
<!--Block Two Starts-->
<div class="blockTitle">SOCIOECONOMIC HISTORY <a
	href="javascript:animatedcollapse.toggle('slide0')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide0">
<div class="blockFrame">
<div class="header"><label>&nbsp;</label>
<div class="paddLeft55"><label class="paddLeft25">Wife</label></div>
<label></label>
<div class="paddLeft25"><label>Husband</label></div>
</div>

<div class="Clear"></div>
<label>Education</label><label></label> <input
	name="<%=EDUCATION_WIFE%>" value="<%=opdObg.getEducationWife() %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=EDUCATION_HUSBAND %>"
	value="<%=opdObg.getEducationHusband() %>" maxlength="20" type="text">

<div class="Clear"></div>

<label>Religion<span></span></label><label></label> <%if(opdObg.getReligionWife()==null){ %>
<label class="value"></label> <%}else{ %> <label class="value"><%=opdObg.getReligionWife().getReligionName() %></label>
<%} %> <label></label> <%if(opdObg.getReligionWife()==null){ %> <label
	class="value"></label> <%}else{ %> <label class="value"><%=opdObg.getReligionHusband().getReligionName() %></label>
<%} %>
<div class="Clear"></div>

<label>Occupation<span></span></label><label></label> <%if(opdObg.getOccupationHusband()==null){ %>
<label class="value"></label> <%}else{ %> <label class="value"><%=opdObg.getOccupationWife().getOccupationName() %></label>
<%} %> <label></label> <%if(opdObg.getOccupationHusband()==null){ %> <label
	class="value"></label> <%}else{ %> <label class="value"><%=opdObg.getOccupationHusband().getOccupationName() %></label>
<%} %>
<div class="Clear"></div>


<label>Accommodation Type</label><label></label> <input
	name="<%=ACCOMMODATION_TYPE %>"
	value="<%=opdObg.getTypeOfAccommodation() %>" maxlength="15"
	type="text"> <label>Privacy</label> <label class="valueNoWidth">Yes</label>
<input name="<%=PRIVACY %>" value="<%=opdObg.getPrivacy()%>"
	type="radio" class="radio" /> <label class="valueNoWidth">NO</label> <input
	name="<%=PRIVACY %>" value="<%=opdObg.getPrivacy()%>" type="radio"
	class="radio" /></div>
</div>
<!--Block Two Ends-->
<div class="division"></div>
<!--Block Three Starts-->
<div class="blockTitle">COMPLAINTS <a
	href="javascript:animatedcollapse.toggle('slide1')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide1">
<div class="blockFrame">
<div class="Clear"></div>
<label>Infertility</label> <label></label> <label>Primary: Yrs:</label>
<input name="<%=INFERTILITY_PRIMARY_YRS %>"
	value="<%=opdObg.getInfertilityPrimaryYrs()%>" maxlength="5"
	type="text"> <label>Secondary: Yrs:</label> <input
	name="<%=INFERTILITY_SECONDARY_YRS %>"
	value="<%=opdObg.getInfertilitySecondaryYrs()%>" maxlength="5"
	type="text">

<div class="Clear"></div>
<label>Hypomenorrohea</label> <input name="<%=HYPOMENRROHEA %>"
	value="<%=opdObg.getHypomenorrohea()%>" maxlength="5" type="text" /> <label>Yrs:</label>
<input name="<%=HYPOMENRROHEA_YRS %>"
	value="<%=opdObg.getHypomenorroheaYrs()%>" maxlength="5" type="text">
<label>Oligomenorrhoea: Yrs:</label> <input
	name="<%=OLIGOMEORRHOEA_YRS %>"
	value="<%=opdObg.getOligomenorrhoeaYrs()%>" maxlength="5" type="text">
<div class="Clear"></div>
<label> Galactorrhoea</label> <input name="<%=GALACTORRHOEA %>"
	value="<%=opdObg.getGalactorrhoea()%>" maxlength="15" type="text" /> <label>Yrs:</label>
<input name="<%=GALACTORRHOEA_YRS %>"
	value="<%=opdObg.getGalactorrhoeaYrs()%>" maxlength="5" type="text">
<label>Hirsutism : Yrs:</label> <input name="<%=HIRSUTISM_YRS %>"
	value="<%=opdObg.getHirsutismYrs()%>" maxlength="5" type="text">
<div class="Clear"></div>
<label>Leucorrhoea</label> <input name="<%=LEUCORRHOEA %>"
	value="<%=opdObg.getLeucorrhoea()%>" maxlength="15" type="text" /> <label></label>
<label></label> <label>Pruritis Valve</label> <input
	name="<%=PRURITIS_VALUE %>" value="<%=opdObg.getPruritisValue()%>"
	maxlength="15" type="text">
<div class="Clear"></div>

<label>Backaches</label> <input name="<%=BACKACHES %>"
	value="<%=opdObg.getBackaches()%>" maxlength="15" type="text" /> <label></label>
<label></label> <label>Dysmenorrhoea</label> <input
	name="<%=DYSMENORRHOEA %>" value="<%=opdObg.getDysmenorrhoea()%>"
	maxlength="15" type="text">
<div class="Clear"></div>

</div>
</div>

<!--Block Three Ends-->
<div class="division"></div>
<!--Block Four Ends-->

<div class="blockTitle">MENSTRUALl <a
	href="javascript:animatedcollapse.toggle('slide2')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide2">
<div class="blockFrame">
<div class="Clear"></div>
<label>Menarche YRS:</label> <input name="<%=MENARCHE_YRS %>"
	value="<%=opdObg.getMenarcheYrs()%>" maxlength="5" type="text">
<label>Past MC</label> <input name="<%=PAST_MC %>"
	value="<%=opdObg.getPastMc()%>" maxlength="15" type="text"> <label>Present
MC</label> <input name="<%=PRESENT_MC %>" value="<%=opdObg.getPresentMc()%>"
	maxlength="15" type="text">
<div class="Clear"></div>

<label>LMP</label> <input name="<%=LMP %>" value="<%=opdObg.getLmp()%>"
	maxlength="15" type="text"> <label>PMP1</label> <input
	name="<%=PMP_ONE %>" value="<%=opdObg.getPmpOne()%>" maxlength="15"
	type="text"> <label>PMP2</label> <input name="<%=PMP_TWO %>"
	value="<%=opdObg.getPmpTwo()%>" maxlength="15" type="text">
<div class="Clear"></div>
</div>
</div>

<!--Block Four Ends-->
<div class="division"></div>
<!--Block Five Ends-->

<div class="blockTitle">PAST SURGICAL HISTORY <a
	href="javascript:animatedcollapse.toggle('slide3')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide3">
<div class="blockFrame">
<div class="Clear"></div>
<label>Diagnostic Scopy</label> <input name="<%=DIAGNOSTIC_SCOPY %>"
	value="<%=opdObg.getDiagnosticScopy()%>" maxlength="20" type="text">
<label></label> <label>Tubal Surgery</label> <input
	name="<%=TUBAL_SURFERY %>" value="<%=opdObg.getTubalSurgery()%>"
	maxlength="20" type="text">
<div class="Clear"></div>
<label>Exploratory Lap</label> <input name="<%=EXPLORATORY_LAP %>"
	value="<%=opdObg.getExploratoryLaparotomy()%>" maxlength="20"
	type="text"> <label></label> <label>Operative Scopy</label> <input
	name="<%=OPERATIVE_SCOPY %>" value="<%=opdObg.getOperativeScopy()%>"
	maxlength="20" type="text">
<div class="Clear"></div>
<%
System.out.println("opdObg.getId()------------- "+opdObg.getId());
%>
</div>
</div>
<input type="hidden" name="<%=OBG_ID %>" value="<%=opdObg.getId() %>">



<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> <input
	type="hidden" name="currentVisitId" value="<%=currentVisitId %>">
<!--Bottom labels starts-->
<div class="bottom"><input name="prev" type="button"
	class="button" value="Prev"
	onclick="submitForm('viewObg','opd?method=viewOBGONE&flag=prev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('viewObg','opd?method=viewOBGONE&flag=next');">
<input name="button" type="button" class="buttonActive" id="btn2"
	value="Page 1" /> <input name="Button" type="button" class="button"
	value="Page 2"
	onclick="submitForm('viewObg','opd?method=viewOBGTWO&visitId=<%=currentVisitId%>');" />
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('viewObg','<%=url%>');" align="right" /></div>
<%}%> <!--Bottom labels ends--> <%}else{%> No Record Found!! <!--Bottom labels starts-->
<div class="bottom"><input name="Back" type="button"
	src="images/phaseII/delete.gif" alt="Back" value="Back" class="button"
	onclick="history.go(-1);return false;" align="right" /></div>

<!--Bottom labels ends--> <%} %>

<div class="division"></div>

</form>
</div>
<!--main content placeholder ends here-->

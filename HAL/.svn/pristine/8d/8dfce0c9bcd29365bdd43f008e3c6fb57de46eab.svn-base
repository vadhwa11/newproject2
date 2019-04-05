<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.OpdObg"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
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
<div class="blockTitle">Endocrine Status <a
	href="javascript:animatedcollapse.toggle('slide1')">(Click Here)</a></div>

<div class="blockTitleCurve"></div>
<div id="slide1">
<div class="blockFrame">
<div class="Clear"></div>
<label>Hair Distribution</label> <input name="<%=HAIR_DISTRIBUTION %>"
	value="<%=opdObg.getHairDistribution() %>" maxlength="20" type="text">

<label>Breast Development</label> <input
	name="<%=BREAST_DEDVELOPMENT %>"
	value="<%=opdObg.getBreastDevelopment() %>" maxlength="20" type="text">

<label>Galactorrhoea</label> <input
	name="<%=GALACTORRHOEA_ENDORICE_STATUS %>"
	value="<%=opdObg.getGalactorrhoea() %>" maxlength="20" type="text" />

<div class="Clear"></div>

<label>Obesity</label> <input name="<%=OBESITY %>"
	value="<%=opdObg.getObesity() %>" maxlength="20" type="text"> <label>Pigmentation/Abdominal
Striae</label> <input name="<%=PIGMENTATION_ABODOMINAL_STRIAE %>"
	value="<%=opdObg.getPigmentationAbdominalStriae() %>" maxlength="20"
	type="text" /> <label>Acne</label> <input name="<%=ACNE %>"
	value="<%=opdObg.getAcne() %>" maxlength="20" type="text" />

<div class="Clear"></div>

<label>Others</label> <input name="<%=OTHERS_ENDORICE_STATUS %>"
	value="<%=opdObg.getOthers() %>" maxlength="20" type="text" /></div>
</div>
<!--Block one Ends-->
<div class="division"></div>
<!--Block Two Starts-->
<div class="blockTitle">GYNAECOLOGICAL EXAMICATIONAL <a
	href="javascript:animatedcollapse.toggle('slide2')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide2">
<div class="blockFrame">
<div class="header"><label>&nbsp;</label>
<div class="paddLeft55"><label class="paddLeft25">Clitoris</label></div>
<div class="paddLeft25"><label>Majopra</label></div>
<div class="paddLeft25"><label>Minora</label></div>
</div>
<div class="Clear"></div>
<label>P.S </label> <label></label> <input name="<%=P_S_CLITORIS %>"
	value="<%=opdObg.getPSClitoris() %>" maxlength="20" type="text">


<input name="<%=P_S_MAJOPRA %>" value="<%=opdObg.getPSLabiaMajopra() %>"
	maxlength="20" type="text"> <input name="<%=P_S_MINORA %>"
	value="<%=opdObg.getPSLabiaMinora() %>" maxlength="20" type="text">

<div class="Clear"></div>
<label>P.V </label><label></label> <input name="<%=P_V_CLITORIS %>"
	value="<%=opdObg.getPVClitoris() %>" maxlength="20" type="text">

<input name="<%=P_V_MAJOPRA %>" value="<%=opdObg.getPVLabiaMajopra() %>"
	maxlength="20" type="text"> <input name="<%=P_V_MINORA %>"
	value="<%=opdObg.getPVLabiaMinora() %>" maxlength="20" type="text">

</div>
</div>
<!--Block Two Ends-->
<div class="division"></div>
<!--Block Three Starts-->
<div class="blockTitle">INVESTIAGATIONS <a
	href="javascript:animatedcollapse.toggle('slide3')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide3">
<div class="blockFrame">
<div class="Clear"></div>

<label>Hemoglobin </label> <label></label> <input
	name="<%=HEMOGLOBIN %>" value="<%=opdObg.getHemoglobin() %>"
	maxlength="7" type="text"> <label>TLC</label> <label></label> <input
	name="<%=TLC %>" value="<%=opdObg.getTlc() %>" maxlength="20"
	type="text">

<div class="Clear"></div>
<label>DLC </label> <label></label> <input name="<%=DLC %>"
	value="<%=opdObg.getDlc() %>" maxlength="20" type="text"> <label>ESR</label>
<label></label> <input name="<%=ESR %>" value="<%=opdObg.getEsr() %>"
	maxlength="20" type="text">

<div class="Clear"></div>
<div class="header"><label>&nbsp;</label>
<div class="paddLeft55"><label class="paddLeft25">Wife</label></div>
<label></label>
<div class="paddLeft25"><label>Husband</label></div>
</div>

<div class="Clear"></div>
<label>Blood Group </label><label></label> <input
	name="<%=BLOOD_GROUP_HUSBAND %>"
	value="<%=opdObg.getBloodGroupHusband() %>" maxlength="10" type="text">
<label></label> <input name="<%=BLOOD_GROUP_WIFE %>"
	value="<%=opdObg.getBloodGroupWife() %>" maxlength="10" type="text">

<div class="Clear"></div>

<label>Blood Sugar </label><label></label> <input
	name="<%=BLOOD_SUGAR_HUSBAND %>"
	value="<%=opdObg.getBloodSugarHusband() %>" maxlength="10" type="text">
<label></label> <input name="<%=BLOOD_SUGAR_WIFE %>"
	value="<%=opdObg.getBloodSugarWife() %>" maxlength="10" type="text">
<div class="Clear"></div>

<label>VDRL</label><label></label> <%if(opdObg.getVdrlHusband()!= null){ %>
<label class="valueNoWidth"><%=opdObg.getVdrlHusband() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %> <label></label> <%if(opdObg.getVdrlWife()!= null){ %>
<label class="valueNoWidth"><%=opdObg.getVdrlWife() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %>
<div class="Clear"></div>


<label>Urine analysis</label><label></label> <%if(opdObg.getUrineAnalysis()!= null){ %>
<label class="valueNoWidth"><%=opdObg.getUrineAnalysis() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %> <label>Specify</label> <%if(opdObg.getSpecification()!= null){ %>
<label class="valueNoWidth"><%=opdObg.getSpecification() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %>
<div class="Clear"></div>

<label>HIV</label><label></label> <%if(opdObg.getHivHusband()!= null){ %>
<label class="valueNoWidth"><%=opdObg.getHivHusband() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %> <label></label> <%if(opdObg.getHivWife()!= null){ %>
<label class="valueNoWidth"><%=opdObg.getHivWife() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %>
<div class="Clear"></div>

<label>HbsAg</label><label></label> <%if(opdObg.getHbsagHusband()!= null){ %>
<label class="valueNoWidth"><%=opdObg.getHbsagHusband() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %> <label></label> <%if(opdObg.getHbsagWife()!= null){ %>
<label class="valueNoWidth"><%=opdObg.getHbsagWife() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %>
<div class="Clear"></div>
</div>
</div>

<input type="hidden" name="<%=OBG_ID %>" value="<%=opdObg.getId() %>">

<!--Block Three Ends-->


<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><input name="prev" type="button"
	class="button" value="Prev"
	onclick="submitForm('viewObg','opd?method=viewOBGTHREE&flag=prev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('viewObg','opd?method=viewOBGTHREE&flag=next');">
<input name="button" type="button" class="buttonActive" id="btn2"
	value="Page 3" /> <input name="Button" type="button" class="button"
	value="Page 4"
	onclick="submitForm('viewObg','opd?method=viewOBGFOUR&visitId=<%=currentVisitId %>');" />
<input name="Button" type="button" class="button" value="Back"
	onclick="submitForm('viewObg','opd?method=viewOBGTWO&visitId=<%=currentVisitId %>');" />
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <%}%>
</div>

<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> <input
	type="hidden" name="currentVisitId" value="<%=currentVisitId %>">
<!--Bottom labels ends--> <%}else{%> No Record Found!! <!--Bottom labels starts-->
<div class="bottom"><input name="back" type="button"
	class="button" value="Back"
	onclick="submitForm('viewObg','opd?method=showOBGTHREEJsp&visitId=<%=currentVisitId %>');">
</div>
<!--Bottom labels ends--> <%} %>

<div class="division"></div>

</form>
</div>
<!--main content placeholder ends here-->

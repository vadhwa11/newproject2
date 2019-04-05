<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdOphFollowUp"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="ophthalmologyFollowUp" method="post" action="">
<h6>Ophthalmology Follow Up</h6>
<div class="Clear"></div>

<!--Block One Starts--> <%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<OpdOphFollowUp> opdOphFollowUpList = null ;
		OpdOphFollowUp opdOphFollowUp = null ; 
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
		if(map.get("opdOphFollowUpList")!=null){
			opdOphFollowUpList =(List<OpdOphFollowUp>) map.get("opdOphFollowUpList");
			if(opdOphFollowUpList.size()>0)
				opdOphFollowUp = opdOphFollowUpList.get(0);
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
	onclick="submitForm('ophthalmologyFollowUp','fwc?method=showOpdOphthamologyJsp');">
<input name="patient fast history" type="button" class="navButtons"
	value="Retinal"
	onclick="submitForm('ophthalmologyFollowUp','/hms/hms/fwc?method=showOphthalmologyRetinalJsp');">
<input name="patient fast history23" type="button" class="navButtons"
	value="Diagnosis"
	onclick="submitForm('ophthalmologyFollowUp','fwc?method=showOphthalmologyDiagnosisJsp');">
</div>
<div class="floatRight">
<div class="blockFrameSm">
<div class="blockTitle">System &amp; Functional Assesment</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<h5>Vision</h5>
<div class="Clear"></div>
<%if(opdOphFollowUp != null){ %>
<input type="hidden" name="opdOphFollowUpId" value="<%=opdOphFollowUp.getId() %>" />
<%}else{ %>
<input type="hidden" name="opdOphFollowUpId" value="0" />
<%} %>
<label>Ant Segment</label> <label class="valueNoWidth">RE</label>
<%if(opdOphFollowUp !=null && opdOphFollowUp.getAntSegmentRe()!=null){ %> 
<input	name="<%=ANT_SEGMENT_RE %>" type="text" value="<%=opdOphFollowUp.getAntSegmentRe() %>" maxlength="20">
<%}else{ %>
<input	name="<%=ANT_SEGMENT_RE %>" type="text" value="" maxlength="20">
<%} %>
<label class="valueNoWidth">LE</label>
<%if(opdOphFollowUp !=null && opdOphFollowUp.getAntSegmentLe()!=null){ %> 
<input name="<%=ANT_SEGMENT_LE%>" type="text" value="<%=opdOphFollowUp.getAntSegmentLe() %>" size="10" maxlength="20">
<%}else{ %>
<input name="<%=ANT_SEGMENT_LE%>" type="text" value="0" size="10" maxlength="20">
<%} %>

<div class="Clear"></div>
<label>IOP</label> <label class="valueNoWidth">&nbsp;&nbsp;&nbsp;&nbsp;</label>
<%if(opdOphFollowUp !=null && opdOphFollowUp.getIop()!=null){ %>
<input name="<%=IOP%>" type="text" value="<%=opdOphFollowUp.getIop() %>" size="10" maxlength="20">
<%}else{ %>
<input name="<%=IOP%>" type="text" value="" size="10" maxlength="20">
<%} %>
<div class="Clear"></div>
<h5>Fundus</h5>
<div class="Clear"></div>
<label>RE</label> <label class="valueNoWidth">&nbsp;&nbsp;&nbsp;&nbsp;</label>
<%if(opdOphFollowUp !=null && opdOphFollowUp.getFundusRe()!=null){%>
<input name="<%=FUNDUS_RE %>" type="text" value="<%=opdOphFollowUp.getFundusRe() %>" size="10" maxlength="20">
<%}else{ %> 
<input name="<%=FUNDUS_RE %>" type="text" value="" size="10" maxlength="20">
<%} %>
<label class="noWidth">LE</label> 
<%if(opdOphFollowUp !=null && opdOphFollowUp.getFundusLe()!=null){%>
<input name="<%=FUNDUS_LE%>" type="text" value="<%=opdOphFollowUp.getFundusLe() %>" size="10" maxlength="20">
<%}else{ %>
<input name="<%=FUNDUS_LE%>" type="text" value="" size="10" maxlength="20">
<%} %>
<label class="noWidth">Adv</label> 
<%if(opdOphFollowUp !=null && opdOphFollowUp.getFundusLe()!=null){%>
<input name="<%=ADV%>" type="text" value="<%=opdOphFollowUp.getFundusLe() %>" size="10" maxlength="20">
<%}else{ %>
<input name="<%=ADV%>" type="text" value="" size="10" maxlength="20">
<%} %>
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
<div class="bottom">
<input name="Save" type="button" class="button" value="Submit" onclick="if(checkBlankForOphthalmology('ophthalmologyFollowUp')){submitForm('ophthalmologyFollowUp','fwc?method=submitOphthalmologyFollowUp');}" />
<input name="view" type="button" class="button" value="View" onclick="submitForm('ophthalmologyFollowUp','fwc?method=viewOphthalmologyFollowUp&flag=prev');" />
<input name="reset" type="reset" class="button" value="Reset" /></div>
<!--Bottom labels ends--></form>
</div>
<!--main content placeholder ends here-->

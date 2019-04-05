<%@page import="jkt.hms.masters.business.BloodIssueDetail"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<%@page import="jkt.hms.masters.business.BloodReactionEntry"%>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<form name="bloodReaction" method="post" action=""><script
	type="text/javascript">

animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')

animatedcollapse.init()

</script> <script>
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
</script> <%
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
	int bloodReactionId=0;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
		}
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
		List<BloodIssueDetail> issueDtList = new ArrayList<BloodIssueDetail>();
		if(map.get("reactionList") != null){
			reactionList= (List<BloodReactionEntry>)map.get("reactionList");
		}
		if(map.get("issueDtList") != null){
			issueDtList =(List<BloodIssueDetail>)map.get("issueDtList");
		}
		if(map.get("bloodGroupList") != null){
			bloodGroupList= (List<MasBloodGroup>)map.get("bloodGroupList");
		}
		if(map.get("employeeList") != null){
			employeeList= (List<MasEmployee>)map.get("employeeList");
		}
		if(map.get("stockList") != null){
			stockList= (List<BloodStockDetail>)map.get("stockList");
		}
		BloodReactionEntry reactionEntry = new BloodReactionEntry();
		if(reactionList != null && reactionList.size()>0){
			reactionEntry = reactionList.get(0);	
		}
		int hinId=0;
		int reactionId=0;
		if(reactionEntry.getHin()!=null){
			hinId = reactionEntry.getHin().getId();			
		}
		if(map.get("bloodReactionId") != null){
			bloodReactionId =(Integer)map.get("bloodReactionId");
		}
%> <!--main content placeholder starts here-->
<div id="contentHolder">
<h6>Update Blood Reaction Form Entry</h6>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<input id="entryNoId" type=hidden name="<%=BLOOD_REACTION_ID %>"value="<%=reactionEntry.getId() %>" title="Entry Number" />
 <%
		String entrySeqNo="";
		if(map.get("entrySeqNo") != null){
			entrySeqNo = (String)map.get("entrySeqNo");
		}
%>
 <label>Entry No.</label> <label class="value"><%=reactionEntry.getEntryNo() %></label>
<input id="entryNoId" type=hidden name="<%=ENTRY_NO %>"	value="<%=reactionEntry.getEntryNo() %>" title="Entry Number" /> 
	<label>Reaction Date</label> 
	<% if(reactionEntry.getRactionDate() != null){%>
	<input type="text"	id="reactDate" name="<%=REACTION_DATE %>" class="calDate"
	value="<%= HMSUtil.convertDateToStringWithoutTime(reactionEntry.getRactionDate()) %>"
	onblur="validateRequiredDate(bloodReaction);" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodReaction.<%=REACTION_DATE%>,event)"
	onblur="validateRequiredDate(bloodReaction);" /> 
	<%}else{ %>
	<label class="value"><%=currentDate %></label>
	<input type="hidden" name="<%=REACTION_DATE %>" value="<%=currentDate%>" />
	 <%} %>
	 <label>Patient Blood Group</label>
	  <%if(reactionEntry.getHin()!= null){
	if(reactionEntry.getHin().getBloodGroup() !=null){%> <label
	class="value"><%=reactionEntry.getHin().getBloodGroup().getBloodGroupName()%></label>
<%}}else{ %> <label class="value">-</label> <%} %>
<div class="Clear"></div>

<label>Service No.</label> <%if(reactionEntry.getHin() != null){ %> <label
	class="value"><%=reactionEntry.getHin().getServiceNo()%></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>HIN No.</label> <%if(reactionEntry.getHin() != null){ %>
<label class="value"><%=reactionEntry.getHin().getHinNo()%></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Rank</label> <%if(reactionEntry.getHin()!=null){
if(reactionEntry.getHin().getRank()!= null){ %> <label class="value"><%=reactionEntry.getHin().getRank().getRankName()%></label>
<%}}else{ %> <label class="value">-</label> <%} %>
<div class="Clear"></div>

<label>Patient Name</label> <%if(reactionEntry.getHin() != null){ %> <label
	class="value"><%=reactionEntry.getHin().getPFirstName()+" "+reactionEntry.getHin().getPMiddleName()+" "+reactionEntry.getHin().getPLastName()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Unit
Address</label> <%if(reactionEntry.getHin()!=null){ %> <%if(reactionEntry.getHin().getUnit() != null){ %>
<label class="value"><%=reactionEntry.getHin() .getUnit().getUnitAddress()%></label>
<%}}else{ %> <label class="value"> -</label> <%} %> <label>Service
Type</label> <%if(reactionEntry.getHin()!=null){ %> <%if(reactionEntry.getHin().getServiceType()  != null){ %>
<label class="value"><%=reactionEntry.getHin().getServiceType().getServiceTypeName()%></label>
<%}}else{ %> <label class="value">-</label> <%} %>
<div class="Clear"></div>

<label>Sex</label> <%if(reactionEntry.getHin()!=null){ %> <%if(reactionEntry.getHin().getSex() != null){ %>
<label class="value"><%=reactionEntry.getHin() .getSex().getAdministrativeSexName()%></label>
<%}}else{ %> <label class="value">-</label> <%} %> <label>Age</label> <%if(reactionEntry.getHin()  != null){ %>
<label class="value"><%=reactionEntry.getHin().getAge()%></label> <%}else{ %>
<label class="value"> - </label> <%} %> <%
			int inpatientId =0;
			Set<Inpatient> set = new HashSet<Inpatient>();
			
%> <%if(reactionEntry.getInpatient() != null) {%> <input type="hidden"
	name="<%=INPATIENT_ID %>"
	value="<%=reactionEntry.getInpatient().getId()%>" /> <%} %> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=reactionEntry.getDepartment().getId() %>" /> <input
	type="hidden" name="<%=HIN_ID %>" value="<%=hinId %>" />

<div class="Clear"></div>
</div>
<div class="Clear"></div>

<div class="division"></div>
<div class="blockTitle"><a
	href="javascript:animatedcollapse.toggle('slide1')">Click Here >></a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<!--Block Two Starts-->
<div id="slide1">

<div class="blockFrame">
<div class="Clear"></div>
<label> <span>*</span> Blood Bag No.</label> 
<%if(reactionEntry.getBloodBagNo() != null){ %>
<input id="bloodBagNo" name="<%=BLOOD_BAG_NO %>" type="text" value="<%=reactionEntry.getBloodBagNo() %>" readonly="readonly"/>
	 <%}else{ %><label> <span>*</span> Blood Bag No.</label> 

<select name="<%= BLOOD_BAG_NO %>"	validate="Blood Bag No.,string,yes" onchange="checkBloodBag(this.value);" tabindex=1>
	<option value="">Select</option>
	<% 
				if(issueDtList.size()>0){
				for (BloodIssueDetail  bldIssueDt : issueDtList){
				%>
	<option value="<%=bldIssueDt.getStockDetail().getBloodBagNo()%>"><%=bldIssueDt.getStockDetail().getBloodBagNo()%></option>

	<%}
	}%>
</select>  <%} %>

<label> <span>*</span> Issue Date</label> 
<%if(reactionEntry.getIssuedDate() != null){ %>
<input id="bloodBagNo" name="<%=ISSUED_DATE %>" class="calDate"
	type="text"
	value="<%=HMSUtil.convertDateToStringWithoutTime(reactionEntry.getIssuedDate()) %>" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodReaction.<%=ISSUED_DATE%>,event)" />
<%}else{ %> <input type="text" class="calDate" id="issueDate"
	name="<%=ISSUED_DATE %>" value="" readonly="readonly" MAXLENGTH="30"
	validate="Issue Date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodReaction.<%=ISSUED_DATE%>,event)" />
<%} %>

 <label> <span>*</span> Issue Time</label> <%if(reactionEntry.getIssuedTime() != null){ %>
<input id="bloodBagNo" name="<%=ISSUED_TIME %>" type="text"
	value="<%=reactionEntry.getIssuedTime() %>"
	onKeyUp="mask(this.value,this,'2',':');" /> <%}else{ %> <input
	id="issueTime" name="<%=ISSUED_TIME %>" type="text" value=""
	onKeyUp="mask(this.value,this,'2',':');"
	onblur="IsValidTime(this.value,this.id);"
	validate="Issue Time,time,yes" maxlength="8" /> <%} %>
<div class="Clear"></div>
<label> <span>*</span> Donor's Name</label>
 <%if(reactionEntry.getDonorName()!= null){ %>
<input id="bloodBagNo" name="<%=DONOR_NAME %>" type="text"
	value="<%=reactionEntry.getDonorName() %>" />
	 <%}else{ %>
	  <input
	id="donorName" name="<%=DONOR_NAME %>" type="text" value=""
	validate="Donor's Name,string,yes" maxlength="25" /> <%} %>
	 <label><span>*</span> Donor's Group</label>
	 <%if(reactionEntry.getBloodGroup()!=null){ %>
	  <input id="bldGroup" value="<%=reactionEntry.getBloodGroup().getBloodGroupName()%>" name=<%=BLOOD_GROUP_NAME%> tabindex="1" readonly="readonly"/>
<input id="bldGroupId" value="<%=reactionEntry.getBloodGroup().getId() %>" name=<%=BLOOD_GROUP_ID %> type="hidden"/>
	 <%}else{ %>
	  <input id="bldGroup" value="" name=<%=BLOOD_GROUP_NAME%> tabindex="1" readonly="readonly"/>
<input id="bldGroupId" value="" name=<%=BLOOD_GROUP_ID %> type="hidden"/>
<%} %>


 <label> <span>*</span> Cross Matched By</label>
  <%if(reactionEntry.getCrossMatchedBy()!=null){ %>
  	<input id="crossmatchBy" value="<%=reactionEntry.getCrossMatchedBy().getFirstName()+" "+reactionEntry.getCrossMatchedBy().getLastName()%>" name="crossmatch" tabindex="" readonly="readonly">
		<input id="crossmatchById" value="<%=reactionEntry.getCrossMatchedBy().getId()%>" name=<%=CROSS_MATCHED_BY %> type="hidden">
  <%}else{ %>
 	<input id="crossmatchBy" value="" name="crossmatch" tabindex="" readonly="readonly">
		<input id="crossmatchById" value="" name=<%=CROSS_MATCHED_BY %> type="hidden">
		<%} %>
<div class="Clear"></div>
<label> <span>*</span> Issued To</label>
 <%if(reactionEntry.getIssuedTo() != null){ %>
<input id="issueTo" name="<%=ISSUED_TO %>"
	value="<%=reactionEntry.getIssuedTo() %>" type="text" maxlength="25"
	validate="Issued To,string,yes" /> <%}else{ %> <input id="issueTo"
	name="<%=ISSUED_TO %>" value="" type="text" maxlength="25"
	validate="Issued To,string,yes" /> <%} %>
	 <label> <span>*</span>Issued By</label> 
	 <%if(reactionEntry.getIssuedBy()!=null){ %>
	<input id="issuedBy" value="<%=reactionEntry.getIssuedBy().getFirstName()+" "+reactionEntry.getIssuedBy().getLastName()%>" name="issuesBy" tabindex="1" readonly="readonly" />
 <input id="issuedById" value="<%= reactionEntry.getIssuedBy().getId()%>" name=<%=ISSUED_BY %> type="hidden"/>
 <%}else{ %>
 <input id="issuedBy" value="" name="issuesBy" tabindex="1" readonly="readonly" />
 <input id="issuedById" value="" name=<%=ISSUED_BY %> type="hidden"/>
 <%} %>
	 <label>Wd No.</label> <%if(reactionEntry.getWdNo()!=null){ %> <input
	id="wdNo" name="<%=WD_NO %>" value="<%=reactionEntry.getWdNo() %>"
	type="text" maxlength="25" validate="Wd No,int,yes" /> <%}else{ %> <input
	id="wdNo" name="<%=WD_NO %>" value="" type="text" maxlength="25"
	validate="Wd No,int,yes" /> <%} %>
<div class="Clear"></div>
</div>
</div>
<div class="Clear"></div>

<div class="division"></div>
<div class="blockTitle"><a
	href="javascript:animatedcollapse.toggle('slide2')">Click Here >></a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<!--Block Two Starts-->
<div id="slide2">

<div class="blockFrame">
<div class="Clear"></div>
<label class="large"><span>*</span>Temperature of patient Before
Transfusion</label> <%if(reactionEntry.getTransfussion()!=null){ %> <input
	id="tempTransfussion" name="<%=TEMP_TRANSFUSSION %>"
	value="<%=reactionEntry.getTransfussion() %>" type="text"
	maxlength="25"
	validate="Temperature of patient Before Transfusion,string,yes" /> <%}else{ %>
<input id="tempTransfussion" name="<%=TEMP_TRANSFUSSION %>" value=""
	type="text" maxlength="25"
	validate="Temperature of patient Before Transfusion,string,yes" /> <%} %>

<label>Date of Transfusion</label> <%if(reactionEntry.getDateTransfussion()!=null){ %>
<input type="text" class="calDate" id="fromDateId"
	name="<%=TRANSFUSSION_DATE %>" onblur="validateFromToDate();"
	value="<%= HMSUtil.convertDateToStringWithoutTime(reactionEntry.getDateTransfussion()) %>"
	readonly="readonly" MAXLENGTH="30"
	validate="Date of Transfusion,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodReaction.<%=TRANSFUSSION_DATE%>,event)" />
<%}else{ %> <input type="text" class="calDate" id="fromDateId" onblur="validateFromToDate();
	name="<%=TRANSFUSSION_DATE %>" value="" readonly="readonly"
	MAXLENGTH="30" validate="Date of Transfusion,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodReaction.<%=TRANSFUSSION_DATE%>,event)" />

<%} %> <label> Time started</label> <%if(reactionEntry.getTimeStarted()!=null){ %>
<input id="startedTime" name="<%=STARTED_TIME %>"
	value="<%=reactionEntry.getTimeStarted() %>" type="text" maxlength="25"
	onchange="IsValidTime(this.value,this.id);"
	onKeyUp="mask(this.value,this,'2',':');"
	validate="Time started,time,no" maxlength="5"
	onBlur="IsValidTime(this.value,this.id);" /> <%}else{ %> <input
	id="startedTime" name="<%=STARTED_TIME %>" type="text" value=""
	onKeyUp="mask(this.value,this,'2',':');"
	validate="Time started,time,yes" maxlength="5"
	onBlur="IsValidTime(this.value,this.id);" /> <%} %> <label class="unit">hrs</label>

<div class="Clear"></div>

<label class="large">Time Completed</label> <%if(reactionEntry.getTimeCompleted()!=null){ %>
<input id="startedTime" name="<%=COMPLETED_TIME %>"
	value="<%=reactionEntry.getTimeCompleted() %>" type="text"
	maxlength="25" onKeyUp="mask(this.value,this,'2',':');"
	validate="Time Completed,time,no" maxlength="5"
	onBlur="IsValidTime(this.value,this.id);" /> <%}else{ %> <input
	id="completedTime" name="<%=COMPLETED_TIME %>" type="text" value=""
	onKeyUp="mask(this.value,this,'2',':');"
	validate="Time Completed,time,no" maxlength="5"
	onBlur="IsValidTime(this.value,this.id);" /> <%} %> <label class="unit">hrs</label>


<div class="Clear"></div>

<h2>Reaction Noticed</h2>

<div class="Clear"></div>
<div class="Height10"></div>

<div class="paddLeft25"><label class="large2">Pyrexia -
Rise in temperature to 100 0F, but no subjective symptoms :</label></div>

<label class="smallmed">Yes</label> <%if(reactionEntry.getPyrexia().equalsIgnoreCase("y")){ %>
<input name="<%=PYREXIA %>" type="radio" class="radio" value="y"
	checked="checked" /> <%}else { %> <input name="<%=PYREXIA %>"
	type="radio" class="radio" value="y" /> <%} %> <label class="smallmed">No</label>
<%if(reactionEntry.getPyrexia().equalsIgnoreCase("n")){ %> <input
	name="<%=PYREXIA %>" type="radio" class="radio" value="n"
	checked="checked" /> <%}else { %> <input name="<%=PYREXIA %>"
	type="radio" class="radio" value="n" /> <%} %>
<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Rise in
temperature to 100 0F, or above, feeling cold but no rigor :</label></div>
<label class="smallmed">Yes</label> <%if(reactionEntry.getRiseTemp().equalsIgnoreCase("y")){ %>
<input name="<%=RISE_TEMP %>" type="radio" class="radio" value="y"
	checked="checked" /> <%}else{ %> <input name="<%=RISE_TEMP %>"
	type="radio" class="radio" value="y" /> <%} %> <label class="smallmed">No</label>
<%if(reactionEntry.getRiseTemp().equalsIgnoreCase("n")){ %> <input
	name="<%=RISE_TEMP %>" type="radio" class="radio" value="n"
	checked="checked" /> <%}else{ %> <input name="<%=RISE_TEMP %>"
	type="radio" class="radio" value="n" /> <%} %>
<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Rigor :</label></div>
<label class="smallmed">Yes</label> <%if(reactionEntry.getRigor().equalsIgnoreCase("y")){ %>
<input name="<%=RIGOR %>" type="radio" class="radio" value="y"
	checked="checked" /> <%}else{ %> <input name="<%=RIGOR %>" type="radio"
	class="radio" value="y" /> <%} %> <label class="smallmed">No</label> <%if(reactionEntry.getRigor().equalsIgnoreCase("n")){ %>
<input name="<%=RIGOR %>" type="radio" class="radio" value="n"
	checked="checked" /> <%}else{ %> <input name="<%=RIGOR %>" type="radio"
	class="radio" value="n" /> <%} %>
<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Fall of BP :
Systolic ............................ Diastolic
........................... </label></div>
<label class="smallmed">Yes</label> <%if(reactionEntry.getFallOfBp().equalsIgnoreCase("y")){ %>
<input name="<%=FALL_BP %>" type="radio" class="radio" value="y"
	checked="checked" /> <%}else{ %> <input name="<%=FALL_BP %>" type="radio"
	class="radio" value="y" /> <%} %> <label class="smallmed">No</label> <%if(reactionEntry.getFallOfBp().equalsIgnoreCase("n")){ %>
<input name="<%=FALL_BP %>" type="radio" class="radio" value="n"
	checked="checked" /> <%}else{ %> <input name="<%=FALL_BP %>" type="radio"
	class="radio" value="n" /> <%} %>
<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Allergic
Reaction- Itching : </label></div>
<label class="smallmed">Yes</label> <%if(reactionEntry.getItching().equalsIgnoreCase("y")){ %>
<input name="<%=ITCHING %>" type="radio" class="radio" value="y"
	checked="checked" /> <%}else{ %> <input name="<%=ITCHING %>" type="radio"
	class="radio" value="y" /> <%} %> <label class="smallmed">No</label> <%if(reactionEntry.getItching().equalsIgnoreCase("n")){ %>
<input name="<%=ITCHING %>" type="radio" class="radio" value="n"
	checked="checked" /> <%}else{ %> <input name="<%=ITCHING %>" type="radio"
	class="radio" value="n" /> <%} %>

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Urticarla :
</label></div>
<label class="smallmed">Yes</label> <%if(reactionEntry.getUrticarla().equalsIgnoreCase("y")){ %>
<input name="<%=URTICARLA %>" type="radio" class="radio" value="y"
	checked="checked" /> <%}else{ %> <input name="<%=URTICARLA %>"
	type="radio" class="radio" value="y" /> <%} %> <label class="smallmed">No</label>
<%if(reactionEntry.getUrticarla().equalsIgnoreCase("n")){ %> <input
	name="<%=URTICARLA %>" type="radio" class="radio" value="n"
	checked="checked" /> <%}else{ %> <input name="<%=URTICARLA %>"
	type="radio" class="radio" value="n" /> <%} %>
<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Anaphylaxis
: </label></div>
<label class="smallmed">Yes</label> <%if(reactionEntry.getAnaphylaxia().equalsIgnoreCase("y")){ %>
<input name="<%=ANAPHYLAXIA %>" type="radio" class="radio" value="y"
	checked="checked" /> <%}else{ %> <input name="<%=ANAPHYLAXIA %>"
	type="radio" class="radio" value="y" /> <%} %> <label class="smallmed">No</label>
<%if(reactionEntry.getAnaphylaxia().equalsIgnoreCase("n")){ %> <input
	name="<%=ANAPHYLAXIA %>" type="radio" class="radio" value="n"
	checked="checked" /> <%}else{ %> <input name="<%=ANAPHYLAXIA %>"
	type="radio" class="radio" value="n" /> <%} %>
<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Pain- Back :
</label></div>
<label class="smallmed">Yes</label> <%if(reactionEntry.getPainBack().equalsIgnoreCase("y")){ %>
<input name="<%=PAIN_BACK %>" type="radio" class="radio" value="y"
	checked="checked" /> <%}else{ %> <input name="<%=PAIN_BACK %>"
	type="radio" class="radio" value="y" /> <%} %> <label class="smallmed">No</label>
<%if(reactionEntry.getPainBack().equalsIgnoreCase("n")){ %> <input
	name="<%=PAIN_BACK %>" type="radio" class="radio" value="n"
	checked="checked" /> <%}else{ %> <input name="<%=PAIN_BACK %>"
	type="radio" class="radio" value="n" /> <%} %>
<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Head : </label></div>
<label class="smallmed">Yes</label> <%if(reactionEntry.getHead().equalsIgnoreCase("y")){ %>
<input name="<%=HEAD %>" type="radio" class="radio" value="y"
	checked="checked" /> <%}else{ %> <input name="<%=HEAD %>" type="radio"
	class="radio" value="y" /> <%} %> <label class="smallmed">No</label> <%if(reactionEntry.getHead().equalsIgnoreCase("n")){ %>
<input name="<%=HEAD %>" type="radio" class="radio" value="n"
	checked="checked" /> <%}else{ %> <input name="<%=HEAD %>" type="radio"
	class="radio" value="n" /> <%} %>

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Chest :</label></div>
<label class="smallmed">Yes</label> <%if(reactionEntry.getChest().equalsIgnoreCase("y")){ %>
<input name="<%=CHEST %>" type="radio" class="radio" value="y"
	checked="checked" /> <%}else{ %> <input name="<%=CHEST %>" type="radio"
	class="radio" value="y" /> <%} %> <label class="smallmed">No</label> <%if(reactionEntry.getChest().equalsIgnoreCase("n")){ %>
<input name="<%=CHEST %>" type="radio" class="radio" value="n"
	checked="checked" /> <%}else{ %> <input name="<%=CHEST %>" type="radio"
	class="radio" value="n" /> <%} %>

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Elsewhere :</label>
</div>
<label class="smallmed">Yes</label> <%if(reactionEntry.getElseWehere().equalsIgnoreCase("y")){ %>
<input name="<%=ELSE_WHERE %>" type="radio" class="radio" value="y"
	checked="checked" /> <%}else{ %> <input name="<%=ELSE_WHERE %>"
	type="radio" class="radio" value="y" /> <%} %> <label class="smallmed">No</label>
<%if(reactionEntry.getElseWehere().equalsIgnoreCase("n")){ %> <input
	name="<%=ELSE_WHERE %>" type="radio" class="radio" value="n"
	checked="checked" /> <%}else{ %> <input name="<%=ELSE_WHERE %>"
	type="radio" class="radio" value="n" /> <%} %>

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Jaundice :</label></div>
<label class="smallmed">Yes</label> <%if(reactionEntry.getJaundice().equalsIgnoreCase("y")){ %>
<input name="<%=JAUNDICE %>" type="radio" class="radio" value="y"
	checked="checked" /> <%}else{ %> <input name="<%=JAUNDICE %>"
	type="radio" class="radio" value="y" /> <%} %> <label class="smallmed">No</label>
<%if(reactionEntry.getJaundice().equalsIgnoreCase("n")){ %> <input
	name="<%=JAUNDICE %>" type="radio" class="radio" value="n"
	checked="checked" /> <%}else{ %> <input name="<%=JAUNDICE %>"
	type="radio" class="radio" value="n" /> <%} %>

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Haemoglobinuria
:</label></div>
<label class="smallmed">Yes</label> <%if(reactionEntry.getHaemoglobinuria().equalsIgnoreCase("y")){ %>
<input name="<%=HEMOGLOBIN %>" type="radio" class="radio" value="y"
	checked="checked" /> <%}else{ %> <input name="<%=HEMOGLOBIN %>"
	type="radio" class="radio" value="y" /> <%} %> <label class="smallmed">No</label>
<%if(reactionEntry.getHaemoglobinuria().equalsIgnoreCase("n")){ %> <input
	name="<%=HEMOGLOBIN %>" type="radio" class="radio" value="n"
	checked="checked" /> <%}else{ %> <input name="<%=HEMOGLOBIN %>"
	type="radio" class="radio" value="n" /> <%} %>

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Anuria :</label></div>
<label class="smallmed">Yes</label> <%if(reactionEntry.getAnuria().equalsIgnoreCase("y")){ %>
<input name="<%=ANURIA %>" type="radio" class="radio" value="y"
	checked="checked" /> <%}else{ %> <input name="<%=ANURIA %>" type="radio"
	class="radio" value="y" /> <%} %> <label class="smallmed">No</label> <%if(reactionEntry.getAnuria().equalsIgnoreCase("n")){ %>
<input name="<%=ANURIA %>" type="radio" class="radio" value="n"
	checked="checked" /> <%}else{ %> <input name="<%=ANURIA %>" type="radio"
	class="radio" value="n" /> <%} %>
<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Anyother
untoward reactions :</label></div>
<%if(reactionEntry.getUntowardReaction()!= null){ %> <input
	name="<%=UNTOWARD_REACTION %>" type="text"
	value="<%=reactionEntry.getUntowardReaction()%>"
	validate="Untoward reactions,string,no" maxlength="25" /> <%}else{ %> <input
	id="untoWardReaction" name="<%=UNTOWARD_REACTION %>" value=""
	type="text" validate="Untoward reactions,string,no" maxlength="25" /> <%} %>

</div>
</div>
<div class="Clear"></div>

<!--table-->
<div class="division"></div>
<div class="bottom"><input type="button" class="cmnButton"
	value="Update"
	onclick="submitForm('bloodReaction','bloodBank?method=updateBloodReaction');"
	align="right" /> <input type="reset" class="cmnButton" name="Reset"
	id="reset" value="Reset" onclick="resetClicked('bloodReaction',);"
	accesskey="r" />
<div class="division"></div>
<!--Bottom labels starts--> <label>Changed By</label> <label
	class="value"><%=userName%></label> <label>Changed Date</label> <label
	class="value"><%=currentDate%></label> <label>Changed Time</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="Clear"></div>

</div>
<!--Bottom labels starts--> <!--main content placeholder ends here--></div>
</form>
<script type="text/javascript">
			function checkBloodBag(obj){	
		<%		
		if(stockList != null && stockList.size() > 0){
				for (BloodStockDetail bloodStockDetail : stockList) {%>
								var invObj =<%= bloodStockDetail.getBloodBagNo()%>
								
								if(invObj != obj){
								alert("Blood Bag No. is not available");
 								document.getElementById('bloodBagNo').value=""
 							}
 		<%} } %>
 		}
 			function validateRequiredDate(formName){
		
		var nowDate= Date();
		
		obj1 = eval(document.getElementById("reactDate"+inc))
			
		if(obj1.value != "" )
		{
		
		 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
			
			if(nowDate>validFromDate)
				{
				alert("Required Date should not be Past date\n");
				document.getElementById("reactDate"+inc).value=""
				return false;
				}
		
		}
		return true;
	}
 </script>
 
<script type="text/javascript">
	function checkBloodBag(obj){	
				
		<%		
		if(issueDtList != null && issueDtList.size() > 0){
				for (BloodIssueDetail issueDetail : issueDtList) {%>
								if(obj == "<%= issueDetail.getStockDetail().getBloodBagNo().toString()%>"){
								//alert("Blood Bag No. is not available");
 								document.getElementById('issueDate').value="<%=HMSUtil.changeDateToddMMyyyy(issueDetail.getIssueHeader().
 										                                getIssueDate())%>"
 								document.getElementById('donorName').value="<%=issueDetail.getStockDetail().getStockMain().getName()%>"
 								document.getElementById('issueTime').value="<%=issueDetail.getIssueHeader().getIssueTime()%>"
 	 								<%if(issueDetail.getIssueHeader().getBloodGroup()!=null){%>
 								document.getElementById('bldGroup').value="<%=issueDetail.getIssueHeader().getBloodGroup().getBloodGroupName()%>"
 	 							
 								document.getElementById('bldGroupId').value="<%=issueDetail.getIssueHeader().getBloodGroup().getId()%>"
 									<%}else{%>
 									document.getElementById('bldGroupId').value="";
 									<%}%>
 								document.getElementById('issuedBy').value="<%=issueDetail.getIssueHeader().getIssuedBy().getFirstName()+" "
 								+issueDetail.getIssueHeader().getIssuedBy().getLastName()%>"
 								document.getElementById('issuedById').value="<%=issueDetail.getIssueHeader().getIssuedBy().getId()%>"
 								document.getElementById('issueTo').value="<%=issueDetail.getIssueHeader().getDepartment().getDepartmentName()%>"
 	 				<%
 	 								String crossMatchBy="";
 								crossMatchBy=issueDetail.getIssueHeader().getScreeningHd().getCrossMatchBy().getFirstName()+
 								" "+issueDetail.getIssueHeader().getScreeningHd().getCrossMatchBy().getLastName();
 	 					%>
 									document.getElementById('crossmatchBy').value="<%=crossMatchBy%>"
 									document.getElementById('crossmatchById').value="<%=issueDetail.getIssueHeader().getScreeningHd().getCrossMatchBy().getId()%>"
 							}
 		<%} }else{ %>
 		alert("Blood not issued ... ")
 		<%}%>
 		}
 </script>
 <script type="text/javascript" language="javascript">
	
	function validateFromToDate(){
		
		var nowDate=new Date();
		
		obj1 = eval(document.bloodReaction.<%=TRANSFUSSION_DATE%>)
			
		if(obj1.value != "" )
		{
		
		 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
				
			if(validFromDate>nowDate)
				{
							alert("Date of Transfusion should be smaller or equal from Today Date\n");
							document.getElementById('fromDateId').value="";
							return false;
				}
		}
		return true;
	}
</script>
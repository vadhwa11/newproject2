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
<script type="text/javascript" src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<form name="bloodReaction" method="post" action="">
<script	type="text/javascript">

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
	StringTokenizer st = new StringTokenizer(time);
	String currentTime[] =time.split(":");
	String time1 =currentTime[0]+":"+currentTime[1];
	String userName="";
	int hospitalId=0;
	int BloodhdId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
		}
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		BloodReactionEntry bloodReactionEntry = new BloodReactionEntry();
		List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
		List<BloodIssueDetail> issueDtList = new ArrayList<BloodIssueDetail>();
		if(map.get("reactionList") != null){
			reactionList =(List)map.get("reactionList");
		}
		if(map.get("issueDtList") != null){
			issueDtList =(List<BloodIssueDetail>)map.get("issueDtList");
		}
		if(reactionList != null && reactionList.size()>0){
			bloodReactionEntry = reactionList.get(0);	
		}
		int hinId=0;
		if(bloodReactionEntry.getHin()!=null){
			hinId = bloodReactionEntry.getHin().getId();			
		}
		int reactionId=0;
		if(map.get("reactionId") != null){
			reactionId =(Integer)map.get("reactionId");
		}
		if(map.get("inpatientList") != null){
			inpatientList= (List<Inpatient>)map.get("inpatientList");
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
%> <!--main content placeholder starts here-->
<div id="contentHolder">
<h6>Blood Reaction Form Entry</h6>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<%
		String entrySeqNo="";
		if(map.get("entrySeqNo") != null){
			entrySeqNo = (String)map.get("entrySeqNo");
		}
%> <label>Entry No.</label> <label class="value"><%=entrySeqNo %></label>
<input id="entryNoId" type=hidden name="<%=ENTRY_NO %>"
	value="<%=entrySeqNo %>" title="Entry Number" /> <label>Reaction
Date</label> <label class="value"><%=currentDate %></label> <input type="hidden"
	name="<%=REACTION_DATE %>" value="<%=currentDate%>" /> <% for (Inpatient patient:inpatientList) {%>

<label>Patient Blood Group</label> <%if(patient.getHin().getBloodGroup() != null){ %>
<label class="value"><%=patient.getHin().getBloodGroup().getBloodGroupName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="Clear"></div>

<label>Service No.</label> <label class="value"><%=patient.getHin().getServiceNo()%></label>

<label>HIN No.</label> <label class="value"><%=patient.getHin().getHinNo()%></label>

<label>Rank</label> <%if(patient.getHin().getRank() != null){ %> <label
	class="value"><%=patient.getHin().getRank().getRankName()%></label>
	 <%}else{ %>
<label class="value">-</label> 
<%} %>
<div class="Clear"></div>

<label>Patient Name</label> <label class="value"><%=patient.getHin().getPFirstName()+" "+patient.getHin().getPMiddleName()+" "+patient.getHin().getPLastName() %></label>

<label>Unit Address</label> <%if(patient.getHin().getUnit() != null){ %> <label
	class="value"><%=patient.getHin().getUnit().getUnitAddress()%></label>
<%}else{ %> <label class="value"> -</label> <%} %> <label>Service
Type</label> <%if(patient.getHin().getServiceType() != null){ %> <label
	class="value"><%=patient.getHin().getServiceType().getServiceTypeName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="Clear"></div>

<label>Sex</label> <%if(patient.getHin().getSex() != null){ %> <label
	class="value"><%=patient.getHin().getSex().getAdministrativeSexName()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Age</label> <%if(patient.getAge() !=null){ %>
<label class="value"><%=patient.getAge()%></label> <%}else{ %> <label
	class="value"> - </label> <%} %> <input type="hidden"
	name="<%=INPATIENT_ID %>" value="<%=patient.getId()%>" /> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=patient.getDepartment().getId() %>" /> <input type="hidden"
	name="<%=HIN_ID %>" value="<%=patient.getHin().getId() %>" /> <%} %>

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

<select name="<%= BLOOD_BAG_NO %>"	validate="Blood Bag No.,string,yes" onchange="checkBloodBag(this.value);" tabindex=1>
	<option value="">Select</option>
	<% 
				if(issueDtList.size()>0){
				for (BloodIssueDetail  bldIssueDt : issueDtList){
				%>
	<option value="<%=bldIssueDt.getStockDetail().getBloodBagNo()%>"><%=bldIssueDt.getStockDetail().getBloodBagNo()%></option>

	<%}
	}%>
</select> 
			 <label>
Issue Date</label>
<input type="text" class="calDate"	id="issueDate" name="<%=ISSUED_DATE %>" value="" readonly="readonly"
	MAXLENGTH="30" validate="Issue Date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" 	onClick="setdate('<%=currentDate %>',document.bloodReaction.<%=ISSUED_DATE%>,event)" />

<label> Issue Time</label> <input id="issueTime"
	name="<%=ISSUED_TIME %>" type="text" value=""
	onKeyUp="mask(this.value,this,'2',':');" validate="Issue Time,time,yes"
	maxlength="5" onBlur="IsValidTime(this.value,this.id);" />

<div class="Clear"></div>
<label>  Donor's Name</label>
<input id="donorName" name="<%=DONOR_NAME %>" type="text" value="" readonly="readonly" />
<label> Donor's Group</label>
<input id="bldGroup" value="" name=<%=BLOOD_GROUP_NAME%> tabindex="1" readonly="readonly"/>
<input id="bldGroupId" value="" name=<%=BLOOD_GROUP_ID %> type="hidden"/>
<!--   <select id="bloodGroupId" name=<%=BLOOD_GROUP_ID %>
	validate="Donor's Group,string,yes">
	<option value="0">Select</option>

	<%
				         		if(bloodGroupList != null){ 	
				         			for (Iterator iter = bloodGroupList.iterator(); iter.hasNext();) {
				         				MasBloodGroup bloodGroup = (MasBloodGroup) iter.next();
				         %>
	<option value="<%=bloodGroup.getId() %>"><%=bloodGroup.getBloodGroupName() %></option>
	<%		
				        			}
				        		 } 
				        %>
</select> -->
<label>  Cross Matched By</label> 
	<input id="crossmatchBy" value="" name="crossmatch" tabindex="" readonly="readonly">
		<input id="crossmatchById" value="" name=<%=CROSS_MATCHED_BY %> type="hidden">

<div class="Clear"></div>

<label> Issued To</label>
<input id="issueTo"	name="<%=ISSUED_TO %>" value="" type="text" maxlength="25"	readonly="readonly" />
 <label> <span>*</span>Issued By</label>
 <input id="issuedBy" value="" name="issuesBy" tabindex="1" readonly="readonly" />
 <input id="issuedById" value="" name=<%=ISSUED_BY %> type="hidden"/>
  <!--  <select id="issuedBy" name=<%=ISSUED_BY %>
	validate="Issued By,string,yes">
	<option value="0">Select</option>

	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         				String empName= "" ;
				         				empName = masEmployee.getFirstName();
				         				if(masEmployee.getMiddleName() != null)
				         					empName = empName.concat(" ").concat(masEmployee.getMiddleName());
				         				if(masEmployee.getLastName() != null)
				         					empName = empName.concat(" ").concat(masEmployee.getLastName());
				         %>
	<option value="<%=masEmployee.getId() %>"><%=empName%></option>
	<%		} }%>
</select>-->
 <label>Wd No.</label> 
 <input id="wdNo" name="<%=WD_NO %>" value="" type="text" maxlength="25" validate="Wd No,int,no" />

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
<label class="large"><span>*</span>Temperature of patient Before Transfusion</label> <input
	id="tempTransfussion" name="<%=TEMP_TRANSFUSSION %>" value=""
	type="text" maxlength="6"
	validate="Temperature of patient Before Transfusion,string,yes" /> <label>Date of Transfusion</label> <input type="text" class="calDate" id="fromDateId"
	name="<%=TRANSFUSSION_DATE %>" value="" readonly="readonly"
	MAXLENGTH="30" vvalidate="Date of Transfusion,date,yes" onblur="validateFromToDate();"/> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodReaction.<%=TRANSFUSSION_DATE%>,event)" />


<label> <span>*</span> Time Started</label> <input id="startedTime"
	name="<%=STARTED_TIME %>" type="text" value=""
	onKeyUp="mask(this.value,this,'2',':');"
	validate=" Time Started,time,no" maxlength="5"
	onBlur="IsValidTime(this.value,this.id); "/> <label class="unit">hrs</label>

<div class="Clear"></div>

<label class="large">Time Completed</label> <input id="completedTime"
	name="<%=COMPLETED_TIME %>" type="text" value=""
	onKeyUp="mask(this.value,this,'2',':');"
	validate="Time Completed,time,no" maxlength="5"
	onBlur="IsValidTime(this.value,this.id);" /> <label class="unit">hrs</label>


<div class="Clear"></div>

<h2>Reaction Noticed</h2>

<div class="Clear"></div>
<div class="Height10"></div>

<div class="paddLeft25"><label class="large2">Pyrexia -
Rise in temperature to 100 0F, but no subjective symptoms :</label></div>
<label class="smallmed">Yes</label> <input name="<%=PYREXIA %>"
	type="radio" class="radio" value="y" /> <label class="smallmed">No</label>
<input name="<%=PYREXIA %>" type="radio" class="radio" value="n"
	checked="checked" />

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Rise in
temperature to 100 0F, or above, feeling cold but no rigor :</label></div>
<label class="smallmed">Yes</label> <input name="<%=RISE_TEMP %>"
	type="radio" class="radio" value="y" /> <label class="smallmed">No</label>
<input name="<%=RISE_TEMP %>" type="radio" class="radio" value="n"
	checked="checked" />

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Rigor :</label></div>
<label class="smallmed">Yes</label> <input name="<%=RIGOR %>"
	type="radio" class="radio" value="y" /> <label class="smallmed">No</label>
<input name="<%=RIGOR %>" type="radio" class="radio" value="n"
	checked="checked" />

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Fall of BP :
Systolic ............................ Diastolic
........................... </label></div>
<label class="smallmed">Yes</label> <input name="<%=FALL_BP %>"
	type="radio" class="radio" value="y" /> <label class="smallmed">No</label>
<input name="<%=FALL_BP %>" type="radio" class="radio" value="n"
	checked="checked" />

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Allergic
Reaction- Itching : </label></div>
<label class="smallmed">Yes</label> <input name="<%=ITCHING %>"
	type="radio" class="radio" value="y" /> <label class="smallmed">No</label>
<input name="<%=ITCHING %>" type="radio" class="radio" value="n"
	checked="checked" />

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Urticarla :
</label></div>
<label class="smallmed">Yes</label> <input name="<%=URTICARLA %>"
	type="radio" class="radio" value="y" /> <label class="smallmed">No</label>
<input name="<%=URTICARLA %>" type="radio" class="radio" value="n"
	checked="checked" />

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Anaphylaxis
: </label></div>
<label class="smallmed">Yes</label> <input name="<%=ANAPHYLAXIA %>"
	type="radio" class="radio" value="y" /> <label class="smallmed">No</label>
<input name="<%=ANAPHYLAXIA %>" type="radio" class="radio" value="n"
	checked="checked" />

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Pain- Back :
</label></div>
<label class="smallmed">Yes</label> <input name="<%=PAIN_BACK %>"
	type="radio" class="radio" value="y" /> <label class="smallmed">No</label>
<input name="<%=PAIN_BACK %>" type="radio" class="radio" value="n"
	checked="checked" />
<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Head : </label></div>
<label class="smallmed">Yes</label> <input name="<%=HEAD %>"
	type="radio" class="radio" value="y" /> <label class="smallmed">No</label>
<input name="<%=HEAD %>" type="radio" class="radio" value="n"
	checked="checked" />

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Chest :</label></div>
<label class="smallmed">Yes</label> <input name="<%=CHEST %>"
	type="radio" class="radio" value="y" /> <label class="smallmed">No</label>
<input name="<%=CHEST %>" type="radio" class="radio" value="n"
	checked="checked" />

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Elsewhere :</label>
</div>
<label class="smallmed">Yes</label> <input name="<%=ELSE_WHERE %>"
	type="radio" class="radio" value="y" /> <label class="smallmed">No</label>
<input name="<%=ELSE_WHERE %>" type="radio" class="radio" value="n"
	checked="checked" />

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Jaundice :</label></div>
<label class="smallmed">Yes</label> <input name="<%=JAUNDICE %>"
	type="radio" class="radio" value="y" /> <label class="smallmed">No</label>
<input name="<%=JAUNDICE %>" type="radio" class="radio" value="n"
	checked="checked" />

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Haemoglobinuria
:</label></div>
<label class="smallmed">Yes</label> <input name="<%=HEMOGLOBIN %>"
	type="radio" class="radio" value="y" /> <label class="smallmed">No</label>
<input name="<%=HEMOGLOBIN %>" type="radio" class="radio" value="n"
	checked="checked" />

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Anuria :</label></div>
<label class="smallmed">Yes</label> <input name="<%=ANURIA %>"
	type="radio" class="radio" value="y" /> <label class="smallmed">No</label>
<input name="<%=ANURIA %>" type="radio" class="radio" value="n"
	checked="checked" />

<div class="Clear"></div>

<div class="paddLeft25"><label class="large2">Anyother
untoward reactions :</label></div>
<input id="untoWardReaction" name="<%=UNTOWARD_REACTION %>" value=""
	type="text" validate="untoward reactions,string,no" maxlength="25" /></div>
</div>
<div class="Clear"></div>

<!--table-->
<div class="division"></div>
<div class="bottom"><input type="button" class="cmnButton"
	value="Submit"
	onclick="submitForm('bloodReaction','bloodBank?method=submitBloodReactionEntry');"
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
 
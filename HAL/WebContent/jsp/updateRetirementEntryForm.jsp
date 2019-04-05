
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.*"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript">
	
	<%
	Date d=new Date();
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}
	
	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>
<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
	hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	
	List<MasPersonnelDetails> masPersonnelDetailsList= new ArrayList<MasPersonnelDetails>();
	if(map.get("masPersonnelDetailsList") != null){
		masPersonnelDetailsList=(List)map.get("masPersonnelDetailsList");
	}
	List<PensionRetirementEntry> pensionRetirementEntryList= new ArrayList<PensionRetirementEntry>();
	if(map.get("pensionRetirementEntryList") != null){
		pensionRetirementEntryList=(List)map.get("pensionRetirementEntryList");
	}
	PensionRetirementEntry pensionRetirementEntry=pensionRetirementEntryList.get(0);
	MasPersonnelDetails masPersonnelDetails=masPersonnelDetailsList.get(0);	
	
	
	if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
			  }
	%>
<div id="contentHolder">
<form name="updateRetirementEntry" method="post">
<h6>Form 356 Retirement Entry</h6>
<div class="Clear"></div>

<div class="blockFrame"><label>Pass No. </label> <label
	class="value"><%=masPersonnelDetails.getPassNo() %></label> <label>Personnel
Name</label> <label class="value"><%=masPersonnelDetails.getPersonnelName() %></label>
</div>

<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<div class="blockTitle">Page 1</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="small">5.a)</label><label
	class="large">Substantive Appointment </label> <%if(pensionRetirementEntry.getSubstantiveAppointment()!= null && !pensionRetirementEntry.getSubstantiveAppointment().equals("")){ %>
<input name="substantiveAppointment"
	value="<%=pensionRetirementEntry.getSubstantiveAppointment() %>"
	id="substantiveAppointment" type="text" maxlength="30" /> <%}else{ %> <input
	name="substantiveAppointment" id="substantiveAppointment" type="text"
	maxlength="30" /> <%} %>
</div>

<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>


<div class="blockTitle">Page 3</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="small">10.)</label>
<h5>Wheather Nomination made for?</h5>

<div class="Clear"></div>

<label class="small">i.)</label><label class="large">Death cum
Retirement Gratuity</label> <select name="deathRetirementGruatuity" />
	<option value="0">Select</option>
	<%if(pensionRetirementEntry.getDeathCumRetirementGratuity().equals("y")){ %>
	<option value="y" selected>Yes</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<%}if(pensionRetirementEntry.getDeathCumRetirementGratuity().equals("n")){ %>
	<option value="n" selected>No</option>
	<%}else{ %>
	<option value="n">No</option>
	<%} %>
</select>
<div class="Clear"></div>


<label class="small">ii.)</label><label class="large">Family
pension under liberalised pension rules</label> <select name="familyPension" />
	<option value="0">Select</option>
	<%if(pensionRetirementEntry.getFamilyPension().equals("y")){ %>
	<option value="y" selected>Yes</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<%}if(pensionRetirementEntry.getFamilyPension().equals("n")){ %>
	<option value="n" selected>No</option>
	<%}else{ %>
	<option value="n">No</option>
	<%} %>
</select>

<div class="Clear"></div>
<label class="small"> </label><label class="large">Height</label> <label
	class="value"><%=masPersonnelDetails.getHeight() %></label>
<div class="Clear"></div>

<label class="small"> </label><label class="large">Identification
Marks</label> <label class="value"><%=masPersonnelDetails.getIdentificationMark() %></label>


<div class="Clear"></div>

<label class="small"> </label><label class="large">Date of first
Application</label> <%if(pensionRetirementEntry.getApplicationDate()!= null && !pensionRetirementEntry.getApplicationDate().equals("")){ %>
<input type="text" class="calDate" id="firstApplicationDate"
	value="<%=HMSUtil.changeDateToddMMyyyy(pensionRetirementEntry.getApplicationDate()) %>"
	name="firstApplicationDate" readonly /> <%}else{ %> <input
	type="text" class="calDate" id="firstApplicationDate"
	name="firstApplicationDate" readonly /> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.updateRetirementEntry.firstApplicationDate,event)" />
</div>

<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>


<div class="blockTitle">Page 5</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="small">1.a) </label><label
	class="large3">whether the officer is involved in a
desciplinary case/court of inquiry or not?</label> <select name="inquiry" />
	<option value="0">Select</option>
	<%if(pensionRetirementEntry.getInvolveInInquiry().equals("y")){ %>
	<option value="y" selected>Yes</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<%}if(pensionRetirementEntry.getInvolveInInquiry().equals("n")){ %>
	<option value="n" selected>No</option>
	<%}else{ %>
	<option value="n">No</option>
	<%} %>
</select>

<div class="Clear"></div>

<label class="small">2.) </label><label class="large3">
Explanation of any suspension or degradation</label> <input type="text"
	id="suspensionOrDegradation"
	value="<%=pensionRetirementEntry.getSuspensionDegradation() %>"
	name="suspensionOrDegradation" maxlength="30" />
<div class="Clear"></div>

<label class="small">3.) </label><label class="large3">Regarding
any gratuity or pension already recieved by applicant-(See chapter
XXI,C.S Regs)</label> <input type="text" id="pensionRecieved"
	name="pensionRecieved"
	value="<%=pensionRetirementEntry.getGratuityPensionRecieved() %>"
	maxlength="30" />
<div class="Clear"></div>

<label class="small">4.) </label><label class="large3"> Any
Other remarks</label> <input type="text" id="remarks" name="remarks"
	value="<%=pensionRetirementEntry.getRemarks() %>" maxlength="50" />
<div class="Clear"></div>

<label class="small">5.) </label><label class="large3"> Specific
opinion by head office wheather the service claimed is established and
should be admitted or not(See articles 912(ii) and 917(ii),C.S Regs)</label> <input
	type="text" id="headOfficeOpinion" name="headOfficeOpinion"
	value="<%=pensionRetirementEntry.getHeadOfficeOpinion() %>"
	maxlength="50" />
<div class="Clear"></div>
</div>

<div class="bottom">
<div class="division"></div>
<input name="personnelId" type="hidden"
	value="<%=masPersonnelDetails.getId() %>" /> <input
	name="retirementFormId" type="hidden"
	value="<%=pensionRetirementEntry.getId() %>" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input name="Submit"
	type="button" class="button" value="Update"
	onclick="submitForm('updateRetirementEntry','pension?method=updateRetirementEntryForm')" />
<input name="Button" type="button" class="button" value="Back"
	onclick="submitForm('updateRetirementEntry','pension?method=showUpdatePersonnelSearchForRetirementFormJsp')" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="Clear"></div>


</div>

</form>
</div>




<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryHeader"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryDetail"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

animatedcollapse.addDiv('jason', 'fade=1,height=80px')
animatedcollapse.addDiv('kelly', 'fade=1,height=100px')
animatedcollapse.addDiv('michael', 'fade=1,height=120px')

animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide4', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide5', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

</script>

<div id="contentHolder">
<form name="bloodDonationEntry" method="post" action=""><script>
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
String errorMsg = "";
errorMsg = "BloodBagNo. ";
int donationhdId = 0;
	int pageNo=1;
	int hinId=0;
	int bloodDonationId=0;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
 	
 	List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
 	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
 	List<Patient> patientList = new ArrayList<Patient>();
 	List<MasRank> rankList = new ArrayList<MasRank>();
 	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
 	List<MasState> stateList = new ArrayList<MasState>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<BloodDonationEntryHeader> donorList = new ArrayList<BloodDonationEntryHeader>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("occupationList") != null){
	occupationList= (ArrayList) map.get("occupationList");
	}
	if(map.get("patientList") != null){
		patientList= (ArrayList) map.get("patientList");
	}
	if(map.get("donationhdId") != null){
		donationhdId=(Integer)map.get("donationhdId");
	}
	if(map.get("bloodDonationId") != null){
		bloodDonationId=(Integer)map.get("bloodDonationId");
	}
	if(map.get("bloodGroupList") != null){
		bloodGroupList = (ArrayList)map.get("bloodGroupList");
	}
	if(map.get("employeeList") != null){
	    employeeList =(ArrayList) map.get("employeeList");
	}
	if(map.get("rankList") != null){
		rankList= (ArrayList) map.get("rankList");
	}
	if(map.get("sexList") != null){
		sexList= (ArrayList) map.get("sexList");
	}
	if(map.get("stateList") != null){
		stateList= (ArrayList) map.get("stateList");
	}

	if(map.get("donorList") != null){
		donorList =(List)map.get("donorList");
	}
	BloodDonationEntryHeader donationEntryHeader = new BloodDonationEntryHeader();
	if(donorList != null && donorList.size()>0){
		donationEntryHeader = donorList.get(0);	
	}
	
	if(donationEntryHeader.getHin()!=null){
		hinId = donationEntryHeader.getHin().getId();			
	}
	String userName="";
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (session.getAttribute("userName") != null) {
		  userName = (String) session.getAttribute("userName");
		}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
		
%>
<h6>Update Blood Donor Questionnaire And Conset Form Entry</h6>
<div class="Clear"></div>

<!--Block One Starts-->
<div class="blockFrame">
<%
		String donationSeqNo="";
		if(map.get("donationSeqNo") != null){
			donationSeqNo = (String)map.get("donationSeqNo");
		}
%> 

<input type="hidden" name="hinId" value="<%=hinId%>"> 
<label>Blood Donation No. </label> 
<input id="donationNoId" type=hidden name="<%=DONATION_NO %>" value="<%=donationEntryHeader.getDonationNo() %>" title="Blood Donation No." /> 
<label class="value"><%=donationEntryHeader.getDonationNo() %></label> 
<input type="hidden" id="donationhdId" name="donationhdId" value="<%= donationEntryHeader.getId()%>" /> 

<label>HIN No.</label> 
<%if(donationEntryHeader.getHin() != null){ %>
	<input id="hinNo" name="<%=HIN_NO %>" value="<%=donationEntryHeader.getHin().getHinNo() %>" type="text" readonly="readonly" /> 
<%}else{ %> 
	<input id="hinNo" name="<%=HIN_NO %>" value="" type="text" /> 
<%} %> 

<label>Service Number </label> 
<%if(donationEntryHeader.getHin() != null){ %>
	<input id="serviceNo" name="<%=SERVICE_NO %>" value="<%=donationEntryHeader.getHin().getServiceNo() %>" type="text" readonly="readonly" /> 
<%}else{ %> 
	<input id="serviceNo" name="<%=SERVICE_NO %>" type="text" /> 
<%} %>

<div class="Clear"></div>

<label> <span>*</span> Donor Name</label> 
<input type="text" name="<%= DONER_NAME%>" value="<%=donationEntryHeader.getDonerName() %>" validate="Donor Name,string,yes" MAXLENGTH="20" tabindex=1 readonly="readonly" /> 
<label> <span>*</span> Donor Type</label> 
<select name="<%=DONOR_TYPE%>" validate="Donor Type,string,yes"> 
	<option value="">Select</option>
	<%if(donationEntryHeader.getDonerType().equalsIgnoreCase("civilian")){%>
		<option value="<%=donationEntryHeader.getDonerType().equalsIgnoreCase("civilian")%>" selected="selected">Civilian </option>
		<option value="n">Service Person</option>
	<%}else{ %>
		<option value="<%=donationEntryHeader.getDonerType().equalsIgnoreCase("service")%>" selected="selected">Service Person</option>
		<option value="n">Civilian</option>
	<%} %>
</select> 

<label>Father's Name</label> 
<%if(donationEntryHeader.getFatherName() != null){ %>
	<input type="text" name="<%= FATHER_NAME%>"	value="<%=donationEntryHeader.getFatherName() %>" validate="Father's Name,string,no" MAXLENGTH="20" tabindex=1 /> 
<%}else{ %>
	<input type="text" name="<%= FATHER_NAME%>" value=""
	validate="Father's Name,string,no" MAXLENGTH="20" tabindex=1 /> <%} %>
<div class="Clear"></div>

<label>Husband's Name</label> 
<%if(donationEntryHeader.getHusbandName() != null){ %>
	<input type="text" name="<%= HUSBAND_NAME%>" value="<%=donationEntryHeader.getHusbandName() %>" validate="Husband's Name,string,no" MAXLENGTH="20" tabindex=1 /> 
<%}else{ %>
	<input type="text" name="<%= HUSBAND_NAME%>" value="" validate="Husband's Name,string,no" MAXLENGTH="20" tabindex=1 /> 
<%}%> 

<label>Occupation</label>
<%if(donationEntryHeader.getHin()!=null){ 
		if(donationEntryHeader.getHin().getOccupation()!=null){%> 
			<input id="occupId" value="<%=donationEntryHeader.getHin().getOccupation().getOccupationName()%>" name="<%=OCCUPATION_ID%>" id="occupId" disabled="disabled" /> 
		<% } 
}
if(occupationList != null){ 	%>
	<select id="occupId" name=<%=OCCUPATION_ID %> validate="Occupation,string,no"> 
	<option value="0">Select</option>
	<%for (Iterator iter = occupationList.iterator(); iter.hasNext();) { 
			MasOccupation masOccupation = (MasOccupation) iter.next();
	 		if(donationEntryHeader.getOccupation().getId().equals(masOccupation.getId())){ 
	 		%>
	 		
			<option value="<%=donationEntryHeader.getOccupation().getId()%>" selected="selected"><%=donationEntryHeader.getOccupation().getOccupationName()%></option>
		<%}else{ %>
		<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName()%></option>	
	    <%	}
	 } 
} %>
</select> 	
	
	
</select> <label>Organization</label> 
<%if(donationEntryHeader.getOrganization() != null){ %>
	<textarea name="<%=ORGANIZATION%>" id="organization" onkeyup="return ismaxlength(this)" maxlength="30" validate="Organization,string,no"> <%=donationEntryHeader.getOrganization() %></textarea> 
<%}else{ %>
	<textarea value="" name="<%=ORGANIZATION%>" id="organization" onkeyup="return ismaxlength(this)" maxlength="30" validate="Organization,string,no"></textarea> 
<%} %>

<div class="Clear"></div>



    
<label>Rank</label> 
<select id="rankId" name=<%=RANK_ID %> validate="Rank,string,no"> 
	<option value="0">Select</option>
	<%
		if(rankList != null && donationEntryHeader!= null){ 	
			for (Iterator iter = rankList.iterator(); iter.hasNext();) {
				     MasRank masRank = (MasRank) iter.next();
	 %>
	<%if(masRank != null && donationEntryHeader.getRank()!=null && donationEntryHeader.getRank().getId().equals(masRank.getId())){ %>
			<option value="<%=donationEntryHeader.getRank().getId()%>"
		selected="selected"><%=donationEntryHeader.getRank().getRankName()%></option>
	<%}else{ %>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%		}} } %>
</select> 


<label>Sex</label> 
<select id="sexId" name=<%=SEX_ID %> validate="Sex,string,yes">
	<option value="0">Select</option>
	<% if(sexList != null && donationEntryHeader != null) {
		for (Iterator iter = sexList.iterator(); iter.hasNext();) {
			MasAdministrativeSex administrativeSex = (MasAdministrativeSex) iter.next();
	%>	
	 
	<% if(administrativeSex != null && donationEntryHeader.getSex()!=null && donationEntryHeader.getSex().getId().equals(administrativeSex.getId())){ %>
		<option value="<%=donationEntryHeader.getSex().getId()%>" selected="selected"><%=donationEntryHeader.getSex().getAdministrativeSexName()%></option>
	<%}else{ %>	
		<option value="<%=administrativeSex.getId() %>"><%=administrativeSex.getAdministrativeSexName()%></option>
	<%		}} } %>
</select> 	
		
		

<label> <span>*</span> Age</label> 
<%if(donationEntryHeader.getAge() != null){ %>
	<input id="age" name="<%=AGE %>" type="text"
	value="<%=donationEntryHeader.getAge() %>" readonly="readonly"
	validate="Age,int,yes" maxlength="3" /> <%}else{ %> <input id="age"
	name="<%=AGE %>" type="text" class="small" validate="Age,int,yes"
	maxlength="3" /> <%} %>

<div class="Clear"></div>

<label>Unit/ Address for commu.</label> 
<%if(donationEntryHeader.getUnitAddress() != null){ %>
<textarea value="" name="<%=UNIT_ADDRESS%>" id="unitAddress"
	onkeyup="return ismaxlength(this)" maxlength="30"
	validate="Unit/ Address,string,no"><%=donationEntryHeader.getUnitAddress() %></textarea> 
<%}else{ %> <textarea name="<%=UNIT_ADDRESS%>" id="unitAddress"
	onkeyup="return ismaxlength(this)" maxlength="30"
	validate="Unit/ Address,string,no"></textarea> 
<%} %> 

<label> <span>*</span>Tel No.</label> 
<%if(donationEntryHeader.getTelNo() != null){ %> <input
	name="<%=TELE_NO %>" type="text"
	value="<%=donationEntryHeader.getTelNo() %>"
	validate="Tel No.,phone,yes" maxlength="15" value=""
	readonly="readonly" /> <%}else {%> <input name="<%=TELE_NO %>"
	type="text" validate="Tel No.,phone,yes" maxlength="15" value="" /> <%} %>

<label>Mobile No.</label> <%if(donationEntryHeader.getMobNo() != null){ %>
<input name="<%=MOBILE_NO %>" type="text"
	value="<%=donationEntryHeader.getMobNo() %>"
	validate="Mob No.,phone,yes" maxlength="15" value="" /> <%}else {%> <input
	name="<%=MOBILE_NO %>" type="text" validate="Mobile No.,phone,no"
	maxlength="15" value="" /> <%} %>
<div class="Clear"></div>

<label> <span>*</span> Home State</label> <select id="stateId"
	name=<%=STATE_ID %> validate="Home State,string,no">
	<option value="0">Select</option>
	<%
				         		if(stateList != null){ 	
				         			for (Iterator iter = stateList.iterator(); iter.hasNext();) {
				         				MasState masState = (MasState) iter.next();
				         %>
	<%if(donationEntryHeader.getState().getId() .equals(masState.getId())){ %>
	<option value="<%=donationEntryHeader.getState().getId()%>"
		selected="selected"><%=donationEntryHeader.getState().getStateName()%></option>
	<%}else{ %>
	<option value="<%=masState.getId() %>"><%=masState.getStateName()%></option>
	<%		}} } %>
</select> <label> <span>*</span> Blood Group</label> <select id="bloodGroupId"
	name=<%=BLOOD_GROUP_ID %> validate="Blood Group,string,yes">
	<option value="0">Select</option>
	<%
				         		if(bloodGroupList != null){ 	
				         			for (Iterator iter = bloodGroupList.iterator(); iter.hasNext();) {
				         				MasBloodGroup bloodGroup = (MasBloodGroup) iter.next();
				         %>
	<%if(donationEntryHeader.getBloodGroup().getId() .equals(bloodGroup.getId())){ %>
	<option value="<%=donationEntryHeader.getBloodGroup().getId()%>"
		selected="selected"><%=donationEntryHeader.getBloodGroup().getBloodGroupName()%></option>
	<%}else{ %>
	<option value="<%=bloodGroup.getId() %>"><%=bloodGroup.getBloodGroupName()%></option>
	<%		}} } %>
</select>

<div class="Clear"></div>

<label>Previously Donated</label> <select name="<%=PREVIOUSLY_DONATED%>"
	class="small2">
	<%if(donationEntryHeader.getPreviouslyDonated().equalsIgnoreCase("n")){%>
	<option value="" selected="selected">No</option>
	<option value="y">yes</option>
	<%}else{ %>
	<option value="" selected="selected">yes</option>
	<option value="n">No</option>
	<%} %>
</select> <label>If yes, No. of times</label> <%if(donationEntryHeader.getNoTimes() != null){ %>
<input name="" value="<%=donationEntryHeader.getNoTimes() %>"> <%}else{ %>
<input name="" type="text" class="small" validate="No. of times,int,no"
	maxlength="2" /> <%} %> <label class="medium"></label> <label>When
Last Donated</label> <%if(donationEntryHeader.getLastDonated() != null){%> <input
	name="<%=LAST_DONATED_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(donationEntryHeader.getLastDonated()) %>">
<%}else{ %> <input type="text" class="calDate" id="lastDateId"
	name="<%=LAST_DONATED_DATE %>" value=""
	validate="Last Donated Date,date,no" MAXLENGTH="10" /> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodDonationEntry.<%=LAST_DONATED_DATE%>,event)" />
<div class="Clear"></div>


<label>Time of Last Meal</label> <%if(donationEntryHeader.getTimeLastMeal() != null){ %>
<input name="<%=LAST_MEAL_TIME %>"
	value="<%=donationEntryHeader.getTimeLastMeal()%> type="
	text" onblur="IsValidTime(this.value,'lastMealTime')" maxlength="8"%>">
<%}else{ %> <input id="lastMealTime" name="<%=LAST_MEAL_TIME %>"
	type="text" onblur="IsValidTime(this.value,'lastMealTime')"
	maxlength="8" /> <%} %> <label class="noWidth">Any discomfort
during/ after donation</label> <select name="<%=DISCOMFORT %>" class="small2">
	<%if(donationEntryHeader.getDiscomfort().equalsIgnoreCase("n")){%>
	<option value="<%=donationEntryHeader.getDiscomfort()%>"
		selected="selected">No</option>
	<option value="y">yes</option>
	<%}else{ %>
	<option value="<%=donationEntryHeader.getDiscomfort()%>"
		selected="selected">yes</option>
	<option value="n">No</option>
	<%} %>
</select>



<div class="Clear"></div>

</div>
<!--Block one Ends--> <!--Block Two Starts-->
<div class="Clear"></div>
<div class="division"></div>
<div class="blockTitle">Questionnaire 1</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<!--Block Two Starts-->
<div id="slide1">
<div class="blockFrame">

<div class="Height10"></div>
<div class="Clear"></div>
<label class="noHeight">Do you Feel Well Today ?</label> <select
	name="<%=WELL_TODAY %>" class="small2">
	<%if(donationEntryHeader.getWellToday().equalsIgnoreCase("n")){%>
	<option value="n" selected="selected">No</option>
	<option value="y">yes</option>
	<%}else{ %>
	<option value="y" selected="selected">yes</option>
	<option value="n">No</option>
	<%} %>
</select> <label class="noHeight">Did you have something to eat in the last 4 hours ?</label>
 <select name="<%=SOMTHING_EAT %>" class="small2">
	<%if(donationEntryHeader.getSmthingEat().equalsIgnoreCase("n")){%>
	<option value="n" selected="selected">No</option>
	<option value="y">yes</option>
	<%}else{ %>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%} %>
</select> <label class="noHeight">Did you sleep well last night ?</label> <select
	name="<%=SLEEP_LAST%>" class="small2">
	<%if(donationEntryHeader.getSleepLastNight().equalsIgnoreCase("n")){%>
	<option value="n" selected="selected">No</option>
	<option value="n">yes</option>
	<%}else{ %>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%} %>
</select>

<div class="Clear"></div>
<div class="paddLeft55"><label class="valueNoWidth">Have
you any reason to believe that you may be infected by either Hepatitis,
(HBsAg &amp; HCV), Malaria, HIV/ AIDS and/ or venereal disease ?</label>
<select name="<%=INFECTED_DISEASE%>" class="small2" >
	<%if(donationEntryHeader.getHepatitis().equalsIgnoreCase("n")){%>
	<option value="<%=donationEntryHeader.getHepatitis()%>"	selected="selected">No</option>
	<option value="y">Yes</option>
	<%}else{ %>
	<option value="<%=donationEntryHeader.getHepatitis()%>"	selected="selected">Yes</option>
	<option value="n">No</option>
	<%} %>
</select>
</div>
<div class="Clear"></div>
<div class="Height10"></div>
</div>
</div>
<!--Block Two Ends-->
<div class="division"></div>
<!--Block Three Starts-->
<div class="blockTitle">Questionnaire 2</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide2">
<div class="blockFrame">
<div class="Clear"></div>
<div class="paddLeft55"><label class="noWidth">In the last
6 months have you had any history of the following :</label>
<div class="Clear"></div>
<div class="Height10"></div>
<label class="noHeight">Unexpected Weight Loss</label> <%if(donationEntryHeader.getWeightLoss().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=WEIGHT_LOSS %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=WEIGHT_LOSS %>" value="" /> <%} %> <label class="noHeight">Repeated
Diarrhoeas</label> <%if(donationEntryHeader.getDiasrrhoes().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=DIARROCES %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=DIARROCES %>" value="" /> <%} %> <label class="noHeight">Swollen
Glands</label> <%if(donationEntryHeader.getSwollwn().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=SWOLLEN %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=SWOLLEN %>" value="" /> <%} %>

<div class="Clear"></div>

<label class="noHeight">Continuous Low Grade Fever</label> <%if(donationEntryHeader.getLowGradeFever().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=LOW_GRADE_FEVER %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=LOW_GRADE_FEVER %>" value="" /> <%} %> <label
	class="noHeight">N/A</label> <%if(donationEntryHeader.getNA1().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=N_A1 %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=N_A1 %>" value="" /> <%} %>

<div class="Clear"></div>
<div class="paddLeft55"><label class="noWidth">In the last
6 months have you had any :</label></div>
<div class="Clear"></div>
<label class="noHeight">Tattooing</label> <%if(donationEntryHeader.getTattoing().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=TATTOOING %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=TATTOOING %>" value="" /> <%} %> <label class="noHeight">Ear
Piercing</label> <%if(donationEntryHeader.getEarPiercing().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=EAR_PIERCING %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=EAR_PIERCING %>" value="" /> <%} %> <label class="noHeight">Dental
Extraction</label> <%if(donationEntryHeader.getDentalExtraction().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=DENTAL_EXTRACTION %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=DENTAL_EXTRACTION %>" value="" /> <%} %>

<div class="Clear"></div>

<label class="noHeight">N/A</label> <%if(donationEntryHeader.getNA2().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=N_A2 %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=N_A2%>" value="" /> <%} %>

<div class="Clear"></div>
<div class="paddLeft55"><label class="noWidth">Do you
suffer from or have suffered from any of the following ?</label></div>
<div class="Clear"></div>
<label class="noHeight">Heart Disease</label> <%if(donationEntryHeader.getHeartDisease().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=HEART_DISEASE %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=HEART_DISEASE %>" value="" /> <%} %> <label
	class="noHeight">Lung Disease</label> <%if(donationEntryHeader.getLungDisease().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=LUNG_DISEASE %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=LUNG_DISEASE %>" value="" /> <%} %> <label class="noHeight">Kidney
Disease</label> <%if(donationEntryHeader.getKidneyDisease().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=KIDNEY_DISEASE %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=KIDNEY_DISEASE %>" value="" /> <%} %>
<div class="Clear"></div>

<label class="noHeight">Cancer/ Malignant Disease</label> <%if(donationEntryHeader.getCancerDisease().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=CANCER_DISEASE %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=CANCER_DISEASE %>" value="" /> <%} %> <label
	class="noHeight">Epilepsy</label> <%if(donationEntryHeader.getEpilepsy().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=EPILEPSY %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=EPILEPSY %>" value="" /> <%} %> <label class="noHeight">CDiabetes</label>
<%if(donationEntryHeader.getCdiabetes().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=CDIABETES %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=CDIABETES %>" value="" /> <%} %>
<div class="Clear"></div>

<label class="noHeight">Tuberculosis</label> <%if(donationEntryHeader.getTuberculosis().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=TUBERCULOSIS %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=TUBERCULOSIS %>" value="" /> <%} %> <label class="noHeight">Abnormal
Bleeding</label> <%if(donationEntryHeader.getAbnormalBleeding().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=ABNORMAL_BLEEDING %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=ABNORMAL_BLEEDING %>" value="" /> <%} %> <label
	class="noHeight">Hepatitis B/C</label> <%if(donationEntryHeader.getHepatitis().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=HEPATITIS_BC %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=HEPATITIS_BC %>" value="" /> <%} %>
<div class="Clear"></div>

<label class="noHeight">Allergic Disease</label> <%if(donationEntryHeader.getAllergicDisease().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=ALLERGIC_DISEASE %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=ALLERGIC_DISEASE %>" value="" /> <%} %> <label
	class="noHeight">Dental Extraction</label> <%if(donationEntryHeader.getDentalExtraction1().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=DENTAL_EXTRACTION1 %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=DENTAL_EXTRACTION1 %>" value="" /> <%} %> <label
	class="noHeight">Sexually Transmitted Disease</label> <%if(donationEntryHeader.getSexuallyDisease().equals("y") ){ %>
<input type="checkbox" class="radio2"
	name="<%=SEXUALLY_TRANSMITTED_DISEASE %>" value="" checked="checked" />
<%}else{ %> <input type="checkbox" class="radio2"
	name="<%=SEXUALLY_TRANSMITTED_DISEASE %>" value="" /> <%} %>
<div class="Clear"></div>

<label class="noHeight">Jaundice (Last 1 Yr)</label> <%if(donationEntryHeader.getJaundiceLastYear().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=JAUNDICE_LAST %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=JAUNDICE_LAST %>" value="" /> <%} %> <label
	class="noHeight">Typhoid (Last 1 Yr)</label> <%if(donationEntryHeader.getTyphoidLastOne().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=TYPHOID_LAST %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=TYPHOID_LAST %>" value="" /> <%} %> <label class="noHeight">Malaria
(6 Months)</label> <%if(donationEntryHeader.getMalariaSixMonth().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=MALARIA_LAST %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=MALARIA_LAST %>" value="" /> <%} %>
<div class="Clear"></div>

<label class="noHeight">Fainting Spells</label> <%if(donationEntryHeader.getFaintingSpells().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=FAINTING_SPELL %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=FAINTING_SPELL %>" value="" /> <%} %> <label
	class="noHeight">Leprosy</label> <%if(donationEntryHeader.getLeprosy().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=LEPROSY %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=LEPROSY %>" value="" /> <%} %> <label class="noHeight">Schizophernia</label>
<%if(donationEntryHeader.getSchizophernia().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=SCHIZOPHERNIA %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=SCHIZOPHERNIA %>" value="" /> <%} %>
<div class="Clear"></div>

<label class="noHeight">Endocrine Disorders</label> <%if(donationEntryHeader.getEndocrineDisorders().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=ENDOCRING_DISORDERS %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=ENDOCRING_DISORDERS %>" value="" /> <%} %> <label
	class="noHeight">N/A</label> <%if(donationEntryHeader.getNA3().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=N_A3 %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=N_A3 %>" value="" /> <%} %>
</div>
<div class="Clear"></div>
</div>
</div>

<!--Block Three Ends-->
<div class="division"></div>
<!--Block Four Ends-->

<div class="blockTitle">Questionnaire 3</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide3">
<div class="blockFrame">
<div class="Clear"></div>
<div class="paddLeft55"><label class="noWidth">Condition
for deferment of blood donation :</label>
<div class="Clear"></div>
<div class="Height10"></div>
<label class="col1">Condition</label> <label class="col2">Period
of Deferment</label> <label class="col1">Condition</label> <label class="col2">Period
of Deferment</label>

<div class="Clear"></div>
<%if(donationEntryHeader.getAbortion().equals("y") ){ %> <input
	type="checkbox" class="radio" name="<%=ABORTION %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=ABORTION %>" value="" /> <%} %> <label class="col1Value">Abortions</label>
<label class="col2Value">:06 months</label> <%if(donationEntryHeader.getAcuteNephritis().equals("y") ){ %>
<input type="checkbox" class="radio" name="<%=ACUTE_NERPHRITIS %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio" name="<%=ACUTE_NERPHRITIS %>" value="" /> <%} %> <label
	class="col1Value">Acute nephritis</label> <label class="col2Value">:06
months after recovery</label>

<div class="Clear"></div>
<%if(donationEntryHeader.getHoBloodTransfusion().equals("y") ){ %> <input
	type="checkbox" class="radio" name="<%=BLOOD_TRANSFUSION_HO %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio" name="<%=BLOOD_TRANSFUSION_HO %>" value="" /> <%} %> <label
	class="col1Value">H/O Blood Transfusion</label> <label
	class="col2Value">:06 months</label> <%if(donationEntryHeader.getImmunoglobulinNephritis().equals("y") ){ %>
<input type="checkbox" class="radio"
	name="<%=IMMUNOGLOBULIN_NEPHRITIS%>" value="" checked="checked" /> <%}else{ %>
<input type="checkbox" class="radio"
	name="<%=IMMUNOGLOBULIN_NEPHRITIS %>" value="" /> <%} %> <label
	class="col1Value">Immunozalic (cholera, Typhoid, Aiptheria,
Teteinus, Plague, Gammaglobulin)</label> <label class="col2Value">:15
days</label>

<div class="Clear"></div>
<%if(donationEntryHeader.getAlcholism().equals("y") ){ %> <input
	type="checkbox" class="radio" name="<%=ALCHOLISM %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=ALCHOLISM %>" value="" /> <%} %> <label class="col1Value">Alcholism</label>
<label class="col2Value">:Till intoxicated</label> <%if(donationEntryHeader.getRabieVaccination().equals("y") ){ %>
<input type="checkbox" class="radio" name="<%=RABIES_VACCINATION %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio" name="<%=RABIES_VACCINATION %>" value="" /> <%} %> <label
	class="col1Value">Rabies vaccination after bite or rabid animal
</label> <label class="col2Value">:1yr after bite</label>
<div class="Clear"></div>
<%if(donationEntryHeader.getMinorSurgery().equals("y") ){ %> <input
	type="checkbox" class="radio" name="<%=MINOR_SURGERY %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=MINOR_SURGERY %>" value="" /> <%} %> <label class="col1Value">Minor
Surgery</label> <label class="col2Value">:03 Months</label> <%if(donationEntryHeader.getHoHapatitis().equals("y") ){ %>
<input type="checkbox" class="radio" name="<%=HO_HEPATITIS %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=HO_HEPATITIS %>" value="" /> <%} %> <label class="col1Value">H/O
Hepatitis in family or close contact</label> <label class="col2Value">:12
months </label>

<div class="Clear"></div>
<%if(donationEntryHeader.getMajorSurgery().equals("y") ){ %> <input
	type="checkbox" class="radio" name="<%=MAJOR_SURGERY %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=MAJOR_SURGERY %>" value="" /> <%} %> <label class="col1Value">Major
Surgery</label> <label class="col2Value">:05 Months</label> <%if(donationEntryHeader.getIImmunozalic().equals("y") ){ %>
<input type="checkbox" class="radio" name="<%=IMMUNOZALIC %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=IMMUNOZALIC %>" value="" /> <%} %> <label class="col1Value">Immunoglobulin
nephritis</label> <label class="col2Value">:12 months</label>

<div class="Clear"></div>
<%if(donationEntryHeader.getTyphoid().equals("y") ){ %> <input
	type="checkbox" class="radio" name="<%=TYPHOID %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=TYPHOID %>" value="" /> <%} %> <label class="col1Value">Typhoid</label>
<label class="col2Value">:12 months after recovery</label> <%if(donationEntryHeader.getHoMalaria().equals("y") ){ %>
<input type="checkbox" class="radio" name="<%=HO_MALARIA %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=HO_MALARIA %>" value="" /> <%} %> <label class="col1Value">H/O
malaria &amp; duly treated </label> <label class="col2Value">:03 months
(endemic) & 03yrs (non endemic area)</label>
<div class="Clear"></div>
<%if(donationEntryHeader.getTattoing1().equals("y") ){ %> <input
	type="checkbox" class="radio" name="<%=TATTOOING1 %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=TATTOOING1 %>" value="" /> <%} %> <label class="col1Value">Tattooing</label>
<label class="col2Value">:06 months</label> <%if(donationEntryHeader.getBreastFeeding().equals("y") ){ %>
<input type="checkbox" class="radio" name="<%=BREAST_FEEDING %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio" name="<%=BREAST_FEEDING %>" value="" /> <%} %> <label
	class="col1Value">Breast feeding</label> <label class="col2Value">:12
months after delivery</label>

<div class="Clear"></div>
<%if(donationEntryHeader.getNA4().equals("y") ){ %> <input type="checkbox"
	class="radio" name="<%=N_A4 %>" value="" checked="checked" /> <%}else{ %>
<input type="checkbox" class="radio" name="<%=N_A4 %>" value="" /> <%} %>
<label class="col1Value">N/A</label>

<div class="Clear"></div>
</div>
<div class="Clear"></div>
</div>
</div>

<div class="division"></div>
<!--Block Four Ends-->

<div class="blockTitle">Questionnaire 4</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide4">
<div class="blockFrame">
<div class="Clear"></div>
<div class="paddLeft55"><label class="noWidth">Is there
any history of surgery or blood transfusion in the past 6 months ?</label>
<div class="Clear"></div>
<div class="Height10"></div>

<%if(donationEntryHeader.getMajorSurgery().equals("y") ){ %> <input
	type="radio" class="radio2" name="<%=SELECTED_RADIO %>" value=""
	checked="checked" /> <%}else{ %> <input type="radio" class="radio2"
	name="<%=SELECTED_RADIO %>" value="" /> <%} %> <label class="value">Major</label>

<%if(donationEntryHeader.getMinorSurgery().equals("y") ){ %> <input
	type="radio" class="radio2" name="<%=SELECTED_RADIO %>" value=""
	checked="checked" /> <%}else{ %> <input type="radio" class="radio2"
	name="<%=SELECTED_RADIO%>" value="" /> <%} %> <label class="value">Minor</label>


<%if(donationEntryHeader.getBloodTransfusionSix().equals("y") ){ %> <input
	type="radio" class="radio2" name="<%=SELECTED_RADIO %>" value=""
	checked="checked" /> <%}else{ %> <input type="radio" class="radio2"
	name="<%=SELECTED_RADIO %>" value="" /> <%} %> 
	<label class="value">Blood Transfusion</label> 
	
	<%if(donationEntryHeader.getNA5() != null){
		if(donationEntryHeader.getNA5().equalsIgnoreCase("y") ){ %>
			<input type="radio" class="radio2" name="<%=SELECTED_RADIO %>" value=""	checked="checked" /> 
		<%}}else{ %> 
			<input type="radio" class="radio2" 	name="<%=SELECTED_RADIO%>" value="" /> 
	<%} %> 
	<label class="value">N/A</label>
<div class="Clear"></div>

<label class="noWidth">For women donors :</label>
<div class="Clear"></div>
<div class="Height10"></div>

<label class="noHeight">Are you pregnant ?</label> <label class="small">Yes</label>
<%if(donationEntryHeader.getPregnent().equalsIgnoreCase("y")){ %> <input
	type="radio" class="radio" name="<%=PREGNENT %>"
	value="<%=donationEntryHeader.getPregnent() %>" checked="checked" /> <%}else{ %>
<input type="radio" class="radio" name="<%=PREGNENT %>" value="" /> <%} %>
<label class="small">No</label> <%if(donationEntryHeader.getPregnent().equalsIgnoreCase("n")){ %>
<input type="radio" class="radio" name="<%=PREGNENT %>"
	value="<%=donationEntryHeader.getPregnent() %>" checked="checked" /> <%}else{ %>
<input type="radio" class="radio" name="<%=PREGNENT %>" value="" /> <%} %>
<div class="Clear"></div>

<label class="noHeight">Have you had an abortion in the last 3
months ?</label> <label class="small">Yes</label> <%if(donationEntryHeader.getAbortionLastThree().equalsIgnoreCase("y")){ %>
<input type="radio" class="radio" name="<%=ABORTION1 %>"
	value="<%=donationEntryHeader.getAbortionLastThree() %>"
	checked="checked" /> <%}else{ %> <input type="radio" class="radio"
	name="<%=ABORTION1 %>" value="" /> <%} %> <label class="small">No</label>
<%if(donationEntryHeader.getAbortionLastThree().equalsIgnoreCase("n")){ %>
<input type="radio" class="radio" name="<%=ABORTION1 %>"
	value="<%=donationEntryHeader.getAbortionLastThree() %>"
	checked="checked" /> <%}else{ %> <input type="radio" class="radio"
	name="<%=ABORTION1 %>" value="" /> <%} %>
<div class="Clear"></div>

<label class="noHeight">Do you have a child less than one year
old ?</label> <label class="small">Yes</label> <%if(donationEntryHeader.getChildLess().equalsIgnoreCase("y")){ %>
<input type="radio" class="radio" name="<%=CHILD_LESS %>"
	value="<%=donationEntryHeader.getChildLess() %>" checked="checked" /> <%}else{ %>
<input type="radio" class="radio" name="<%=CHILD_LESS %>" value="" /> <%} %>
<label class="small">No</label> <%if(donationEntryHeader.getChildLess().equalsIgnoreCase("n")){ %>
<input type="radio" class="radio" name="<%=CHILD_LESS %>"
	value="<%=donationEntryHeader.getChildLess()%>" checked="checked" /> <%}else{ %>
<input type="radio" class="radio" name="<%=CHILD_LESS %>" value="" /> <%} %>

<div class="Clear"></div>

<label class="noHeight">Are you under menses today ?</label>
<label class="small">Yes</label> 
<%if(donationEntryHeader.getMenses().equalsIgnoreCase("y")){ %>
		<input type="radio" class="radio" name="<%=UNDER_MENSES %>" value="<%=donationEntryHeader.getMenses() %>" checked="checked" /> 
<%}else { %>
		<input type="radio" class="radio" name="<%=UNDER_MENSES %>" value="y" />
<%} %>

<label class="small">No</label> 
<%if(donationEntryHeader.getMenses().equalsIgnoreCase("n")){ System.out.println("check here----"+donationEntryHeader.getMenses());%>
	<input type="radio" class="radio" name="<%=UNDER_MENSES %>" value="<%=donationEntryHeader.getMenses() %>" checked="checked" /> 
<%}else{ %>
	<input type="radio" class="radio" name="<%=UNDER_MENSES %>" value="n" /> <%} %>

<div class="Clear"></div>

<label class="noHeight">N/A</label> 
<label class="small">Yes</label> 
<% if(donationEntryHeader.getNA5() != null){
	if(donationEntryHeader.getNA5().equalsIgnoreCase("y")){ %>
	<input type="radio" class="radio" name="<%=N_A5 %>"	value="<%=donationEntryHeader.getNA5()%>" checked="checked" /> 
<%}}else{ %>
	<input type="radio" class="radio" name="<%=N_A5 %>" value="" /> 
<%} %>
<label class="small">No</label>
 
<%if(donationEntryHeader.getNA5() != null){
if(donationEntryHeader.getNA5().equalsIgnoreCase("n")){ %>
	<input type="radio" class="radio" name="<%=N_A5%>"	value="<%=donationEntryHeader.getNA5() %>" checked="checked" /> 
<%}}else{ %>
	<input type="radio" class="radio" name="<%=N_A5 %>" value="" /> <%} %>
<div class="Clear"></div>
<div class="Height10"></div>

<label class="noWidth">Would you like to be informed about any abnormal test result at the address furnished by you ?</label> 
<label class="small">Yes</label> 
<% if(donationEntryHeader.getAbnormalTestResult() != null){
	if(donationEntryHeader.getAbnormalTestResult().equalsIgnoreCase("y")){%>
		<input type="radio" class="radio" name="<%=ABNORMAL_TEST_RESULT %>" value="<%=donationEntryHeader.getAbnormalTestResult() %>" checked="checked" /> 
<%}}else{ %> 
		<input type="radio" class="radio" name="<%=ABNORMAL_TEST_RESULT %>" value="" /> 
<%} %> 

<label class="small">No</label>
<% if(donationEntryHeader.getAbnormalTestResult() != null){
	if(donationEntryHeader.getAbnormalTestResult().equalsIgnoreCase("n")){ %> 
		<input type="radio" class="radio" name="<%=ABNORMAL_TEST_RESULT %>" value="<%= donationEntryHeader.getAbnormalTestResult()%>" checked="checked" /> 
<%} }else{ %> 
	<input type="radio" class="radio" name="<%=ABNORMAL_TEST_RESULT %>" value="" /> <%} %>

<div class="Clear"></div>
<label>Date of Collection</label> 
<%if(donationEntryHeader.getCollectionDate() != null){ %>
<input type="text" class="calDate" id="collDateId" 	name="<%=COLLECTION_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(donationEntryHeader.getCollectionDate()) %>"
	validate="Date of Collection,date,no" /> <%}else{ %> <input type="text"
	class="calDate" id="collDateId" name="<%=COLLECTION_DATE %>"
	value="<%=currentDate %>" validate="Date of Collection,date,no"
	MAXLENGTH="10" /> <%} %> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodDonationEntry.<%=COLLECTION_DATE%>,event)" />

<label>Collection Time</label> <%if(donationEntryHeader.getCollectionTime() != null){ %>
<input type="text" id="sampleCollectionTime"
	name="<%=COLLECTION_TIME %>"
	value="<%=donationEntryHeader.getCollectionTime() %>"
	onchange="checkTime('bloodDonationEntry','sampleCollectionTime')"
	MAXLENGTH="10" tabindex=1 /> <%}else{ %> <input id="sampleCollectionTime"
	type="text" name="<%= COLLECTION_TIME%>" value="<%=time %>"
	onchange="checkTime('bloodDonationEntry','sampleCollectionTime')"
	MAXLENGTH="10" tabindex=1 /> <%} %>
<div class="Clear"></div>
<div class="Height10"></div>

</div>
<div class="Clear"></div>
</div>
</div>


<div class="division"></div>
<!--Block Four Ends--> <!--Block Four Ends-->

<div class="blockTitle">Physical Examination</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide5">
<div class="blockFrame">
<div class="Clear"></div>

<div class="Height10"></div>
<label class="smallmed">General</label> <%if(donationEntryHeader.getGeneral() != null){ %>
<input type="text" name="<%=GENERAL %>"
	value="<%=donationEntryHeader.getGeneral() %>" maxlength="20" /> <%}else{ %>
<input type="text" name="<%=GENERAL %>" value="" maxlength="20" /> <%} %>

<div class="Clear"></div>

<label class="medium"> <span>*</span> Height</label> <%if(donationEntryHeader.getHeight() != null){ %>
<input type="text" class="small" name="<%=HEIGHT %>"
	value="<%=donationEntryHeader.getHeight() %>" validate="Height,int,yes"
	maxlength="5" /> <%}else{ %> <input type="text" class="small"
	name="<%=HEIGHT %>" value="" validate="Height,int,yes" maxlength="5" />
<%} %> <label class="unit">cm</label> 

<label class="medium"> <span>*</span>Weight</label> 
<%if(donationEntryHeader.getWeight() != null){ %> 
	<input type="text" class="small" name="<%=WEIGHT %>" value="<%=donationEntryHeader.getWeight() %>" validate="Height,int,yes" maxlength="5" /> <%}else{ %> <input type="text" class="small" name="<%=WEIGHT %>" value="" validate="Weight,int,yes" maxlength="5" />
<%} %> 
	
	<label class="unit">kg</label> 
	<label class="smallmed">Pulse</label>
	<%if(donationEntryHeader.getPulse() != null){ %> 
		<input type="text" class="small" name="<%=PULSE %>" value="<%=donationEntryHeader.getPulse() %>" validate="Pulse,flat,no" maxlength="6" /> 
	<%}else{ %> 
		<input type="text" class="small" name="<%=PULSE %>" value="" validate="Pulse,flat,no" maxlength="6" /> 
    <%} %>

	<label class="smallmed">Temp</label> 
	<%if(donationEntryHeader.getTemp() != null){ %>
		<input type="text" class="small" name="<%=TEMPERATURE %>" value="<%=donationEntryHeader.getTemp() %>" validate="Temp,float,no" maxlength="5" /> 
	<%}else{ %> 
		<input type="text" class="small" name="<%=TEMPERATURE %>" value="" validate="Temp,float,no" maxlength="5" /> 
	<%} %>
	 
	<label class="smallmed">HB/ DL</label> 
	<% if(donationEntryHeader.getHbDl() != null){ %>
			<input type="text" class="small" name="<%=HB_DL %>" value="<%=donationEntryHeader.getHbDl() %>" validate="HB/DL,float,no" maxlength="5" /> 
	<%}else{%> 
			<input type="text" class="small" name="<%=HB_DL %>" value="" validate="HB/DL,float,no" maxlength="5" />
	<%}%> 
	
	<label class="unit">gms </label> 
	<label class="smallmed">BP</label>
	
	<%if(donationEntryHeader.getBp() != null){ %> 
		<input type="text"  name="<%=BP %>" value="<%=donationEntryHeader.getBp() %>" validate="BP,string,no" maxlength="5" /> <%}else{ %> <input type="text" class="small" name="<%=BP%>" value="" validate="BP,string,no" maxlength="8" /> 
	<%} %> 
	
	<label class="unit">mm hg</label>

<div class="Clear"></div>

<label>Phlebotomy site</label> 
<select name="<%=PHLEBOTOMY_SITE%>">
    <option value="">Select</option>
    <%if(donationEntryHeader.getPhlebotomy().equalsIgnoreCase("Healthy") ){%>
      <option value="healthy" selected="selected">Healthy</option>
      <option value="Anticubita">Anticubitan</option>
    <% }else if(donationEntryHeader.getPhlebotomy().equalsIgnoreCase("Anticubita")) {%>
      <option value="healthy">Healthy</option>
      <option value="Anticubita" selected="selected">Anticubitan</option>
    <%}else {%>
      <option value="healthy">Healthy</option>
      <option value="Anticubita">Anticubitan</option>
   <% } %>   
</select> 

<input type="hidden" class="calDate" name="<%=BLOOD_DONATION_ENTRY_HEADER_ID %>" value="<%=donationEntryHeader.getId() %>" /> 

<!--   
<label>Expiry Date</label> 
<%// if(donationEntryHeader.getExpiryDate()!= null){ %> 
	<input type="text" class="calDate" name="<%=EXPIRY_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(donationEntryHeader.getExpiryDate()) %>" />
<%// }else{ %> 
<input type="text" class="calDate" id="lastDateId" name="<%=EXPIRY_DATE %>" value="<%=currentDate %>" validate="Date of Collection,date,no" MAXLENGTH="10" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.bloodDonationEntry.<%=EXPIRY_DATE%>,event)" />
<%//} %> 
-->

<label> <span>*</span> Collected By</label> 
<select id="collectedById" name=<%=EMPLOYEE_ID %> validate="Blood Group,string,yes">
	<option value="0">Select</option>
	<%
		if(employeeList != null){ 	
			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				MasEmployee masEmployee = (MasEmployee) iter.next();
	%>
	<%if(donationEntryHeader.getCollectedBy().getId() .equals(masEmployee.getId())){ %>
		<option value="<%=donationEntryHeader.getCollectedBy().getId()%>"  selected="selected"><%=donationEntryHeader.getCollectedBy().getFirstName()+" "+donationEntryHeader.getCollectedBy().getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%		}} } %>
</select>


<label>VOL/REP</label> 
<select name="<%=VOL_REP %>">
	<option value="">Select</option>
	<%if(donationEntryHeader.getVolRep().equalsIgnoreCase("v")) {%>
		<option value="v" selected = "selected">Voluntary</option>
		<option value="r">Repalcement</option>
		<option value="a">Autologous</option>
	<%}else if(donationEntryHeader.getVolRep().equalsIgnoreCase("r")){ %>	
		<option value="v">Voluntary</option>
		<option value="r" selected = "selected">Repalcement</option>
		<option value="a">Autologous</option>
	<%}else if(donationEntryHeader.getVolRep().equalsIgnoreCase("a")){ %>	
		<option value="v">Voluntary</option>
		<option value="r">Repalcement</option>
		<option value="a" selected = "selected">Autologous</option>	
	<%}else { %>	
		<option value="v">Voluntary</option>
		<option value="r">Repalcement</option>
		<option value="a">Autologous</option>
	<% } %>	
</select> 
<div class="Clear"></div>
<input type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" /> 
<input type="hidden" name="pageNo" id="pageNo"
	value="<%=pageNo%>" />
<div class="Height10"></div>
<div class="Clear"></div>
</div>
</div>
<div class="Clear"></div>
<div class="Height10"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<thead>
		<tr>
			<th scope="col">Sr. No.</th>
			<th scope="col">Blood Bag No.</th>
			<th scope="col">Component Name</th>
			<th scope="col">Quantity (ml)</th>
			<th scope="col">Expiry Date</th>
		</tr>
	</thead>
	<tbody>
		<%	
 String bloodBagNo="";
 String componentCode="";
 String quantity="";
 String expiry_date = null;
 String componentNamewithId="";
 int bloodDonationDetailId=0;
    	int detailCounter=8; 
    	int temp=0;
    	int inc = 1;  
    	BloodDonationEntryDetail bloodDonationEntryDetail=new BloodDonationEntryDetail();
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	} 
    	List<BloodDonationEntryDetail>donationEntryDetailList=new ArrayList<BloodDonationEntryDetail>(donationEntryHeader.getBloodDonationEntryDetails());
    	//for(inc=1;inc<=8;inc++){
    		//if(inc<=donationEntryDetailList.size()){
    		if(donationEntryDetailList.size() > 0){
    			bloodDonationEntryDetail=donationEntryDetailList.get(inc-1);
    			bloodBagNo=bloodDonationEntryDetail.getBloodBagNo();
    			componentNamewithId=bloodDonationEntryDetail.getComponent().getComponentName()+"["+bloodDonationEntryDetail.getComponent().getId()+"]";
    			componentCode=bloodDonationEntryDetail.getComponent().getComponentCode();
    			quantity=bloodDonationEntryDetail.getQty().toString();
    			bloodDonationDetailId=bloodDonationEntryDetail.getId();
    			if(bloodDonationEntryDetail.getExpiryDate()!=null){
    			expiry_date = HMSUtil.convertDateToStringWithoutTime(bloodDonationEntryDetail.getExpiryDate());
    			}else{
    				expiry_date = "-";
    			}
    		}		
    		else{
    			bloodBagNo="";
    			componentCode="";
    		    quantity="";
    		    expiry_date = null;
    			componentNamewithId="";
    			bloodDonationDetailId= 0;
    		}
    		%>



		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				name="<%=SR_NO%>" readonly="readonly" /></td>
			<td><input id="bloodDoantionId<%=inc%>" type="hidden"
				name="<%=BLOOD_DONATION_ENTRY_DETAIL_ID%>"
				value="<%=bloodDonationDetailId%>" /> <input
				id="bloodBagId<%=inc%>" type="text" name="<%=BLOOD_BAG_NO%>"  readonly="readonly" 
				value="<%= bloodBagNo%>"
				onblur="checkForBloodBagNo1(this.value, '<%=inc %>');checkBloodBagNo(bloodDonationEntry,'<%=inc %>');"
				size="20" MAXLENGTH="45" tabindex=1 /> 
				<input type="hidden" value="<%=bloodDonationEntryDetail.getComponent().getId() %>" name="<%=BLOOD_COMPONENT_ID%>" id="bloodComponentId<%=inc %>" /></td>
 			<td><input type="text" id="componentName<%=inc%>" name="bloodComponentName" value="<%=componentNamewithId %>" onblur="if(fillSrNo('<%=inc %>')){checkForComponentCode(this.value, '<%=inc %>');}" />

			<div id="ac2update"
				style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
  				new Ajax.Autocompleter(document.getElementById('componentName<%=inc%>'),'ac2update','bloodBank?method=getComponentNameForAutoComplete',{parameters:'requiredField=bloodComponentName'});
			</script></td>
			<td><input type="text" id="quantity<%=inc%>"
				name="<%=QUANTITY %>" value="<%=quantity %>" validate="Qty,int,no"
				MAXLENGTH="3" /> <input type="hidden"
				name="bloodBagNoValueCheckOnSubmit"
				id="bloodBagNoValueCheckOnSubmit<%=inc%>" value="correctBloodBagNo" />
			</td>
			<td>
			<input type="text" class="calDate" id="expiryDate<%=inc%>" name="<%=EXPIRY_DATE %>" value="<%=expiry_date%>" validate="Date of Collection,date,no" MAXLENGTH="10" lostFocus="check()" tabindex="1" />
			<!--  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.bloodDonationEntry.<%=EXPIRY_DATE%>,event)" /> -->
			</td>
		</tr>
		<%//} %>
		<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
	</tbody>

</table>
</div>


<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><input type="button" class="button"
	value="Update" 
	onclick="if(validateCollExpDate())submitForm('bloodDonationEntry','bloodBank?method=updateBloodDonation');"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset"
	onclick="resetClicked('bloodDonationEntry',<%=inc %>);" accesskey="r" />

<div class="division"></div>

<label>Changed By</label> 
<label class="value"><%=userName%></label> 
<input type="hidden" name="changed_by" value="<%=userName%>"> 
<label>Changed Date</label> 
<label class="value"><%=currentDate%></label> 
<input type="hidden" name="changed_date" value="<%=currentDate%>"> 
<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input type="hidden" name="changed_time" value="<%=time%>">
<div class="Clear"></div>


</div>
<!--Bottom labels starts--> <!--main content placeholder ends here-->
</div>

<script type="text/javascript">
function fillSrNo(rowVal){

	if(document.getElementById('componentName'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('componentName'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}
function checkForComponentCode(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForComponentName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var componentId = val.substring(index1,index2);
			var indexForComponentName = indexForComponentName--;
			var componentName = val.substring(0,indexForComponentName);
			var myDate = document.getElementById('collDateId').value;
				var year  = myDate.substring(6);
				var month = myDate.substring(3,5);
				var day   = myDate.substring(0,2);
				
		if(componentId =="")
		{
	     document.getElementById('componentCode'+inc).value="";
	  	 document.getElementById('qty'+inc).value="";
	     return;
		}
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('componentName'+i).value==val)
		{
			alert("Component Name already selected...!")
			document.getElementById('componentName'+inc).value=""
			var e=eval(document.getElementById('componentName'+inc)); 
			e.focus();
			return false;
		} }  }
		
		// ajaxFunctionForAutoCompleteComponentName('bloodDonationEntry','bloodBank?method=fillItemsForComponentname&componentName=' +  componentName , inc);
		ajaxFunctionForAutoCompleteComponentName('bloodDonationEntry','bloodBank?method=fillItemsForComponentname&myDate='+ myDate + '&componentName=' +  componentName , inc);
		}else{
			document.getElementById('componentCode'+inc).value = "";
			document.getElementById('qty'+inc).value = "";
		}
}



	function checkBloodBagNoForExisting(bagNoObj, rowCount) 
	{
  	 	var xmlHttp;
     		try {
    			// Firefox, Opera 8.0+, Safari
   	 			xmlHttp=new XMLHttpRequest();
	  		}catch (e){
    		// Internet Explorer
    			try{
     	 			xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    			}catch (e){
    				alert(e)
     	 			try{
        				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
     	 			}catch (e){
        				alert("Your browser does not support AJAX!");
        				return false;
      				}
     			}
   			}
    	xmlHttp.onreadystatechange=function()
    	{
     	 	if(xmlHttp.readyState==4){
      		var items =xmlHttp.responseXML.getElementsByTagName('bloodBagNoFlags')[0];
       			for (loop = 0; loop < items.childNodes.length; loop++) 
      			{
	   		    	var item = items.childNodes[loop];
	    	    	var flagValue  = item.getElementsByTagName("flagValue")[0];
	    	    	var checkResult = flagValue.childNodes[0].nodeValue;
	    	    	if(checkResult == 'Duplicate'){
	    	    		alert('Blood Bag No. '+ bagNoObj.value + ' already exist.');
	    	    		document.getElementById('bloodBagNoValueCheckOnSubmit'+rowCount).value='duplicateBloodBagNo';
	    	    		return false;
	    	    	}else{
	    	    		document.getElementById('bloodBagNoValueCheckOnSubmit'+rowCount).value='correctBloodBagNo';
						return true;	    	    	
	    	    	}
      			}
    		}
  		}
  		bloodBagNo = bagNoObj.value;
  		// alert(radioNoObj.value);
  		// alert(rowCount);
  		 //return false;
  		var bloodDonationIdToCheck = document.getElementById('bloodComponentId'+rowCount).value;
  		var url="/hms/hms/bloodBank?method=checkForExistingBloodBagNo&bloodbagNoToCheck="+bloodBagNo+"";
    	xmlHttp.open("GET",url,true);
    	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(null);
  		
	}
	

function checkFilledRow(){
	var msg ="";
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	  }else{
	  var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('componentName'+i).value != ""){
	  			if(document.getElementById('bloodBagId'+i).value == ""){
	  				msg += "BloodBag No. can not be blank.\n";
	  			}
	  			if(msg != ""){
	  				break;
	  			}
	  		}
	  	}
	  		if(msg != ""){
	  			alert(msg)
	  			return false;
	  		}else
	  			return true;
	  }
	 }
function checkForBloodBagNo1(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForComponentName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var componentId = val.substring(index1,index2);
			var indexForComponentName = indexForComponentName--;
			var componentName = val.substring(0,indexForComponentName);
			for(i=1;i<inc;i++){
				if(inc != 1){
					if(document.getElementById('bloodBagId'+i).value==val){
						alert("Blood bag already selected...!")
						document.getElementById('bloodBagId'+inc).value=""
						var e=eval(document.getElementById('bloodBagId'+inc)); 
						e.focus();
						return false;
					 } 
				 }  
			}
		}  
	}

</script>

<script type="text/javascript" language="javascript">
	
	function validateCollExpDate(){
		
		var nowDate=new Date();
		
		obj1 = eval(document.bloodDonationEntry.<%=EXPIRY_DATE %>)
		obj2 = eval(document.bloodDonationEntry.<%=COLLECTION_DATE %>)
		
		if(obj1.value != "" && obj2.value != "")
		{
		
		 validExpDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
		 validCollDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
			if(validExpDate < validCollDate)
				{
							alert("Expiry Date should be Greater than Collection Date\n");
							return false;
				}
		
		}
		return true;
	}
</script>
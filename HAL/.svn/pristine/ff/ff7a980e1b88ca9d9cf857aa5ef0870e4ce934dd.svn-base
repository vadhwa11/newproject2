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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
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
<script>
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
</script>

<%
String errorMsg = "";
errorMsg = "BloodBagNo. ";
int donationhdId = 0;
	int pageNo=1;
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
	StringTokenizer st = new StringTokenizer(time);
	String currentTime[] =time.split(":");
	String time1 =currentTime[0]+":"+currentTime[1];
	String message ="";
	if (map.get("message") != null) {
	             message = (String) map.get("message");
	      }
	if(!message.equalsIgnoreCase("")){
	%>
<h2><%=message %></h2>
<%} %>

<div id="contentHolder">
<form name="bloodDonationEntry" method="post" action="">
<h6>Blood Donor Questionnaire And Consent Form</h6>
<div class="Clear"></div>

<!--Block One Starts-->
<div class="blockFrame">
<%
		String donationSeqNo="";
        String[] bagNo=null;
		if(map.get("donationSeqNo") != null){
			donationSeqNo = (String)map.get("donationSeqNo");
			bagNo= donationSeqNo.split("/");
		}
%> <label>Blood Donation No. </label> <input id="donationNoId"
	type=hidden name="<%=DONATION_NO %>" value="<%=donationSeqNo %>"
	title="Blood Donation No." tabindex=1 /> <label class="value"><%=donationSeqNo %>
</label> <input type="hidden" id="donationhdId" name="donationhdId"
	value="<%= donationhdId%>" /> <label>Service Number </label> <input
	type="text" id="serviceNo" name="<%= SERVICE_NO%>" value=""
	validate="Service No,string,no" class="textbox_size20" maxlength="20"
	onblur="ajaxFunctionForDonor(bloodDonationEntry);" tabindex=1 /> <label>HIN
No.</label> <input id="hinNo" name="<%=HIN_NO %>" type="text" value=""
	tabindex=1 maxlength="15" readonly="readonly" /> <input id="hinId"
	name="<%=HIN_ID %>" type="hidden" value="" tabindex=1 />

<div class="Clear"></div>

<label><span>*</span>Donor Name</label> <input id="donorName"
	type="text" name="<%= DONER_NAME%>" value=""
	validate="Donor Name,string,yes" MAXLENGTH="20" tabindex=1 /> <label><span>*</span>Donor
Type</label> <select id="donorType" name="<%=DONOR_TYPE%>"
	validate="Donor Type,string,yes" tabindex=1>
	<option value="">Select</option>
	<option value="civilian">Civilian</option>
	<option value="service">Service Person</option>
</select> <label>Father's Name</label> <input type="text"
	name="<%= FATHER_NAME%>" value="" validate="Father's Name,string,no"
	MAXLENGTH="20" tabindex=1 />
<div class="Clear"></div>

<label>Husband's Name</label> <input type="text"
	name="<%= HUSBAND_NAME%>" value="" validate="Husband's Name,string,no"
	MAXLENGTH="20" tabindex=1 /> <label><span>*</span>Occupation</label> <select
	id="occupId" name=<%=OCCUPATION_ID %> validate="Occupation,string,no"
	tabindex=1 value="">
	<option value="0">Select</option>

	<%
				         		if(occupationList != null){ 	
				         			for (Iterator iter = occupationList.iterator(); iter.hasNext();) {
				         				MasOccupation masOccupation = (MasOccupation) iter.next();
				         %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName() %></option>
	<%		
				        			}
				        		 } 
				        %>
</select> 
<!-- <label>Organization</label> <textarea value="" name="<%=ORGANIZATION%>"
	id="organization" onkeyup="chkLength(this,30);"
	validate="Organization,string,no" tabindex="1"></textarea>-->

<div class="Clear"></div>

<label>Rank</label> <select id="rankId" name=<%=RANK_ID %>
	validate="Rank,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
				         		if(rankList != null){ 	
				         			for (Iterator iter = rankList.iterator(); iter.hasNext();) {
				         				MasRank masRank = (MasRank) iter.next();
				         %>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%		
				        			}
				        		 } 
				        %>
</select> <label><span>*</span> Sex</label> <select id="sexId" name=<%=SEX_ID %>
	validate="sex,string,yes" tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(sexList != null){ 	
				         			for (Iterator iter = sexList.iterator(); iter.hasNext();) {
				         				MasAdministrativeSex administrativeSex = (MasAdministrativeSex) iter.next();
				         %>
	<option value="<%=administrativeSex.getId() %>"><%=administrativeSex.getAdministrativeSexName() %></option>
	<%		
				        			}
				        		 } 
				        %>
</select> <label><span>*</span> Age</label> <input id="age" name="<%=AGE %>"
	type="text" validate="Age,int,yes" maxlength="3" tabindex="1" value="" />

<div class="Clear"></div>

<label>Unit/ Address for commu.</label> <textarea value=""
	name="<%=UNIT_ADDRESS%>" id="unitAddress" onkeyup="chkLength(this,25);"
	validate="Unit/ Address,string,no" tabindex="1"></textarea> <label><span>*</span>Tel
No.</label> 
<input id="teleNo" name="<%=TELE_NO %>" type="text"	validate="Tel No.,phone,yes" maxlength="12" value="" tabindex="1" />
	 <label>Mobile
No.</label> <input id="mobNo" name="<%=MOBILE_NO %>" type="text"
	validate="Mobile No.,phone,no" maxlength="15" value="" tabindex="1" />

<div class="Clear"></div>

<label><span>*</span> Home State</label> <select id="stateId"
	name=<%=STATE_ID %> validate="State,string,no" tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(stateList != null){ 	
				         			for (Iterator iter = stateList.iterator(); iter.hasNext();) {
				         				MasState masState = (MasState) iter.next();
				         %>
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%		
				        			}
				        		 } 
				        %>
</select> <label><span>*</span>Blood Group</label> <select id="bloodGroupId"
	name=<%=BLOOD_GROUP_ID %> validate="Blood Group,string,yes"
	tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(bloodGroupList != null){ 	
				         			for (Iterator iter = bloodGroupList.iterator(); iter.hasNext();) {
				         				MasBloodGroup bloodGroup = (MasBloodGroup) iter.next();
				         %>
	<option value="<%=bloodGroup.getId() %>"><%=bloodGroup.getBloodGroupName()%></option>
	<%		} } %>
</select>


<div class="Clear"></div>

<label>Previously Donated</label> <select name="<%=PREVIOUSLY_DONATED%>"
	class="small" tabindex="1" id="preDonate"
	onchange="preDonated(bloodDonationEntry);">
	<option value="n">No</option>
	<option value="y">Yes</option>

</select> <script type="text/javascript">
function preDonated(formName){
if(document.getElementById('preDonate').value =="n"){
document.getElementById('noOfTimes').disabled=true;
document.getElementById('lastDateId').disabled=true;
document.getElementById('lastMealTime').disabled=true;
}
}
</script> <label>If yes, No. of times</label> <input id="noOfTimes" type="text"
	class="small" name="<%=NUMBER_OF_TIME %>"
	validate="No. of times,int,no" maxlength="2" value="" tabindex="1" /> <label
	class="medium">
	</label> <label>When Last Donated</label> 
	<input 	type="text" class="calDate" id="lastDateId" name="<%=LAST_DONATED_DATE %>" value="" validate="Last Donated Date,date,no" MAXLENGTH="10" tabindex="1" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.bloodDonationEntry.<%=LAST_DONATED_DATE%>,event)" />

<div class="Clear"></div>


<label>Time of Last Meal</label> <input id="lastMealTime"
	name="<%=LAST_MEAL_TIME %>" type="text"
	onKeyUp="mask(this.value,this,'2',':');" maxlength="5" tabindex="1" />

<label class="noWidth">Any discomfort during/ after donation</label> <select
	name="<%=DISCOMFORT%>" class="small" tabindex="1">
	<option value="n">No</option>
	<option value="y">Yes</option>
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
<label class="noHeight">Do you Feel Well Today ?</label>
<select	name="<%=WELL_TODAY %>" class="small2" tabindex="1" id="notWell" >
	<option value="y">yes</option>
	<option value="n">No</option>
</select>
 <label class="noHeight">Did you have something to eat in the last 4 hours ?</label>
  <select name="<%=SOMTHING_EAT %>" class="small2"	tabindex="1">
	<option value="y">yes</option>
	<option value="n">No</option>
</select> 
<label class="noHeight">Did you sleep well last night ?</label>
 <select name="<%=SLEEP_LAST%>" class="small2" tabindex="1">
	<option value="y">yes</option>
	<option value="n">No</option>
</select>

<div class="Clear"></div>
<div class="noHeight"><label class="valueNoWidth">Have
you any reason to believe that you may be infected by either Hepatitis,
(HBsAg &amp; HCV), Malaria, HIV/ AIDS and/ or venereal disease ?</label>
<select name="<%=INFECTED_DISEASE%>" class="small2" tabindex="1" id="infected1">
	<option value="n">No</option>
	<option value="y">Yes</option>
</select></div>
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
<label class="noHeight">Unexpected Weight Loss</label>
<input	type="checkbox" class="radio2" name="<%=WEIGHT_LOSS %>" value=""tabindex="1" id="6months1" onchange="checkForFirstRow();"/>
<label class="noHeight">Repeated Diarrhoeas</label> 
<input type="checkbox" class="radio2" name="<%=DIARROCES %>" value=""tabindex="1"  id="6months2" onchange="checkForRepeated();"/>
<label class="noHeight">Swollen Glands</label>
<input	type="checkbox" class="radio2" name="<%=SWOLLEN %>" value=""	tabindex="1" id="6months3" onchange="checkForSwallon();"/>

<div class="Clear"></div>

<label class="noHeight">Continuous Low Grade Fever</label> <input
	type="checkbox" class="radio2" name="<%=LOW_GRADE_FEVER %>" value=""
	tabindex="1" id="6months4" onchange="checkForLowFever();"/> <label class="noHeight">N/A</label> <input
	type="checkbox" class="radio2" name="<%=N_A1 %>" value="" tabindex="1" id="6months5"/>

<div class="Clear"></div>
<div class="paddLeft55"><label class="noWidth">In the last
6 months have you had any :</label></div>
<div class="Clear"></div>
<label class="noHeight">Tattooing</label> <input type="checkbox"
	class="radio2" name="<%=TATTOOING %>" value="" tabindex="1" /> <label
	class="noHeight">Ear Piercing</label> <input type="checkbox"
	class="radio2" name="<%=EAR_PIERCING %>" value="" tabindex="1" /> <label
	class="noHeight">Dental Extraction</label> <input type="checkbox"
	class="radio2" name="<%=DENTAL_EXTRACTION %>" value="" tabindex="1" />

<div class="Clear"></div>

<label class="noHeight">N/A</label> <input type="checkbox"
	class="radio2" name="<%=N_A2%>" value="" tabindex="1" />

<div class="Clear"></div>
<div class="paddLeft55"><label class="noWidth">Do you
suffer from or have suffered from any of the following ?</label></div>
<div class="Clear"></div>
<label class="noHeight">Heart Disease</label> <input type="checkbox"
	class="radio2" name="<%=HEART_DISEASE %>" value="" tabindex="1" id="heartDisease" />
	
 <label 	class="noHeight">Lung Disease</label>
 <input type="checkbox"	class="radio2" name="<%=LUNG_DISEASE %>" value="" tabindex="1" id="lungDisease" />
 <label class="noHeight">Kidney Disease</label>
 <input type="checkbox"	class="radio2" name="<%=KIDNEY_DISEASE %>" value="" tabindex="1" id="kidneyDisease" />

<div class="Clear"></div>

<label class="noHeight">Cancer/ Malignant Disease</label>
<input	type="checkbox" class="radio2" name="<%=CANCER_DISEASE %>" value=""	tabindex="1" id="CancerDisease" />
<label class="noHeight">Epilepsy</label>
<input type="checkbox" class="radio2" name="<%=EPILEPSY %>" value="" tabindex="1"  id="Epilepsy" />
<label class="noHeight">CDiabetes</label> 
<input type="checkbox" class="radio2" name="<%=CDIABETES %>" value=""	tabindex="1"  id="CDiabetes" />

<div class="Clear"></div>

<label class="noHeight">Tuberculosis</label>
<input type="checkbox"	class="radio2" name="<%=TUBERCULOSIS %>" value="" tabindex="1" id="Tuberculosis" />
<label	class="noHeight">Abnormal Bleeding</label>
<input type="checkbox"	class="radio2" name="<%=ABNORMAL_BLEEDING %>" value="" tabindex="1" id="Abnormalblooding" />

<label class="noHeight">Hepatitis B/C</label> <input type="checkbox"
	class="radio2" name="<%=HEPATITIS_BC %>" value="" tabindex="1" id="Hepatitis"  />

<div class="Clear"></div>

<label class="noHeight">Allergic Disease</label> <input type="checkbox"
	class="radio2" name="<%=ALLERGIC_DISEASE %>" value="" tabindex="1" id="alergicDisease"/> <label
	class="noHeight">Dental Extraction</label> <input type="checkbox"
	class="radio2" name="<%=DENTAL_EXTRACTION1 %>" value="" tabindex="1" id="dentalExtraction"/>

<label class="noHeight">Sexually Transmitted Disease</label> <input
	type="checkbox" class="radio2"
	name="<%=SEXUALLY_TRANSMITTED_DISEASE %>" value="" tabindex="1" />

<div class="Clear"></div>

<label class="noHeight">Jaundice (Last 1 Yr)</label>
 <input
	type="checkbox" class="radio2" name="<%=JAUNDICE_LAST %>" value="" id="Jaundice1"
	tabindex="1" /> 
	<label class="noHeight">Typhoid (Last 1 Yr)</label> <input
	type="checkbox" class="radio2" name="<%=TYPHOID_LAST %>" value="" id="Typhoid1"
	tabindex="1" /> <label class="noHeight">Malaria (6 Months)</label> <input
	type="checkbox" class="radio2" name="<%=MALARIA_LAST %>" value="" id="Malaria6"
	tabindex="1" />

<div class="Clear"></div>

<label class="noHeight">Fainting Spells</label>
 <input type="checkbox"	class="radio2" name="<%=FAINTING_SPELL %>" value="" tabindex="1" id="Faintingsp"/>
 <label	class="noHeight">Leprosy</label> 
 <input type="checkbox" class="radio2"	name="<%=LEPROSY %>" value="" tabindex="1" id="Leprosy"/>
  <label class="noHeight">Schizophernia</label>
<input type="checkbox" class="radio2" name="<%=SCHIZOPHERNIA %>" value="" tabindex="1" id="Schizophernia"/>

<div class="Clear"></div>

<label class="noHeight">Endocrine Disorders</label> <input
	type="checkbox" class="radio2" name="<%=ENDOCRING_DISORDERS %>"
	value="" tabindex="1" /> <label class="noHeight">N/A</label> <input
	type="checkbox" class="radio2" name="<%=N_A3 %>" value="" tabindex="1" />

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
<input type="checkbox" class="radio" name="<%=ABORTION %>" value=""	tabindex="1" id=""/> 
	<label class="col1Value">Abortions</label>
	 <label	class="col2Value">:06 months</label> <input type="checkbox"
	class="radio" name="<%=ACUTE_NERPHRITIS %>" value="" tabindex="1" id="Abortions"/> <label
	class="col1Value">Acute nephritis</label> <label class="col2Value">:06
months after recovery</label>

<div class="Clear"></div>

<input type="checkbox" class="radio" name="<%=BLOOD_TRANSFUSION %>"
	value="" tabindex="1" /> <label class="col1Value">H/O Blood
Transfusion</label> <label class="col2Value">:06 months</label> <input
	type="checkbox" class="radio" name="<%=IMMUNOZALIC %>" value=""
	tabindex="1" id="Immunozalic" /> <label class="col1Value">Immunozalic (cholera,
Typhoid, Aiptheria, Teteinus, Plague, Gammaglobulin)</label> <label
	class="col2Value">:15 days</label>

<div class="Clear"></div>
<input type="checkbox" class="radio" name="<%=ALCHOLISM %>" value=""
	tabindex=1 /> <label class="col1Value">Alcholism</label> <label
	class="col2Value">:Till intoxicated</label> <input type="checkbox"
	class="radio" name="<%=RABIES_VACCINATION %>" value="" tabindex=1 /> <label
	class="col1Value">Rabies vaccination after bite or rabid animal
</label> <label class="col2Value">:1yr after bite</label>
<div class="Clear"></div>
<input type="checkbox" class="radio" name="<%=MINOR_SURGERY %>" value=""
	tabindex=1 /> <label class="col1Value">Minor Surgery</label> <label
	class="col2Value">:03 Months</label> <input type="checkbox" id="minorSurgery"
	class="radio" name="<%=HO_HEPATITIS %>" value="" tabindex=1 /> <label
	class="col1Value">H/O Hepatitis in family or close contact</label> <label
	class="col2Value">:12 months </label>

<div class="Clear"></div>
<input type="checkbox" class="radio" name="<%=MAJOR_SURGERY %>" value=""
	tabindex=1 id="majorSurgery"/> <label class="col1Value">Major Surgery</label> <label
	class="col2Value">:05 Months</label> <input type="checkbox"
	class="radio" name="<%=IMMUNOZALIC %>" value="" tabindex=1 /> <label
	class="col1Value">Immunoglobulin nephritis</label> <label
	class="col2Value">:12 months</label>

<div class="Clear"></div>
<input type="checkbox" class="radio" name="<%=TYPHOID %>" value=""
	tabindex=1 /> <label class="col1Value">Typhoid</label> <label
	class="col2Value">:12 months after recovery</label> <input
	type="checkbox" class="radio" name="<%=HO_MALARIA %>" value="" id="Typhoid2"
	tabindex=1 /> <label class="col1Value">H/O malaria &amp; duly
treated </label> <label class="col2Value">:03 months (endemic) & 03yrs
(non endemic area)</label>
<div class="Clear"></div>
<input type="checkbox" class="radio" name="<%=TATTOOING1 %>" value=""
	tabindex=1 /> <label class="col1Value">Tattooing</label> <label
	class="col2Value">:06 months</label> <input type="checkbox"
	class="radio" name="<%=BREAST_FEEDING %>" value="" tabindex=1 /> <label
	class="col1Value">Breast feeding</label> <label class="col2Value">:12
months after delivery</label>

<div class="Clear"></div>
<input type="checkbox" class="radio" name="<%=N_A4 %>" value=""
	tabindex=1 /> <label class="col1Value">N/A</label>

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
<label class="noHeight">Major</label> <input type="radio" class="radio2"
	name="<%=SELECTED_RADIO %>" value="" tabindex=1 /> <label
	class="noHeight">Minor</label> <input type="radio" class="radio2"
	name="<%=SELECTED_RADIO %>" value="" tabindex=1 /> <label
	class="noHeight">Blood Transfusion</label> <input type="radio"
	class="radio2" name="<%=SELECTED_RADIO %>" value="" tabindex=1 />

<div class="Clear"></div>

<label class="noHeight">N/A</label> <input type="radio" class="radio2"
	name="<%=SELECTED_RADIO %>" value="" tabindex=1 />

<div class="Clear"></div>
<label class="noWidth">For women donors :</label>
<div class="Clear"></div>
<div class="Height10"></div>

<label class="noHeight">Are you pregnant ?</label>
<label class="small">Yes</label>
<input type="radio" class="radio" name="<%=PREGNENT %>" value="y" id="pregnent"	tabindex=1 />
<label class="small">No</label>
<input type="radio"	class="radio" name="<%=PREGNENT %>" value="n"  id="pregnent" tabindex=1 checked="checked"/>

<div class="Clear"></div>

<label class="noHeight">Have you had an abortion in the last 3 months ?</label>
<label class="small">Yes</label>
<input type="radio" id="abortion2" class="radio" name="<%=ABORTION1 %>" value="y" tabindex=1 />
<label class="small">No</label>
<input type="radio" class="radio" name="<%=ABORTION1 %>" value="n" checked="checked" tabindex=1 id="abortion2"/>

<div class="Clear"></div>

<label class="noHeight">Do you have a child less than one year old ?</label>
<label class="small">Yes</label>
<input type="radio" class="radio"name="<%=CHILD_LESS %>" value="y" tabindex=1 />
<label class="small">No</label>
<input type="radio" class="radio" name="<%=CHILD_LESS %>" value="n"	checked="checked" tabindex=1 />

<div class="Clear"></div>

<label class="noHeight">Are you under menses today ?</label>
<label 	class="small">Yes</label> <input type="radio" class="radio" id="menses"
	name="<%=MENSES %>" value="y" tabindex=1 /> <label class="small">No</label>
<input type="radio" class="radio" name="<%=MENSES %>" value="n"  id="menses"
	checked="checked" tabindex=1 />

<div class="Clear"></div>

<label class="noHeight">N/A</label> <label class="small">Yes</label> <input
	type="radio" class="radio" name="<%=N_A5 %>" value="y" tabindex=1 /> <label
	class="small">No</label> <input type="radio" class="radio"
	name="<%=N_A5 %>" value="n" tabindex=1 />

<div class="Clear"></div>
<div class="Height10"></div>
<label class="noWidth" style="display: none;">Would you like to
be informed about any abnormal test result at the address furnished by
you ?</label> <label class="small" style="display: none;">Yes</label> <input
	type="radio" class="radio" name="<%=ABNORMAL_TEST_RESULT %>" value=""
	tabindex=1 style="display: none;" /> <label class="small"
	style="display: none;">No</label> <input type="radio" class="radio"
	name="<%=ABNORMAL_TEST_RESULT %>" value="" tabindex=1
	style="display: none;" />

<div class="Clear"></div>
<label>Date of Collection</label> 
	<input type="text" class="calDate" id="lastDate" name="<%=COLLECTION_DATE %>" value="<%=currentDate %>" validate="Date of Collection,date,no" MAXLENGTH="10" tabindex=1 /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.bloodDonationEntry.<%=COLLECTION_DATE%>,event)"/>


<label>Collection Time</label> <input id="sampleCollectionTime"
	type="text" name="<%= COLLECTION_TIME%>" value="<%=time1 %>"
	onKeyUp="mask(this.value,this,'2',':');"
	onchange="checkTime('bloodDonationEntry','sampleCollectionTime')"
	MAXLENGTH="5" tabindex=1 />

<div class="Clear"></div>
<div class="Height10"></div>

</div>
<div class="Clear"></div>
</div>
</div>


<div class="division"></div>
<!--Block Four Ends-->

<div class="blockTitle">Physical Examination</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide5">
<div class="blockFrame">
<div class="Clear"></div>

<div class="Height10"></div>
<label class="smallmed">General</label> <input type="text"
	name="<%=GENERAL %>" value="Healthy" maxlength="50" tabindex="1" />

<div class="Clear"></div>

<label class="smallmed"><span>*</span>Height</label> <input type="text"
	class="small" name="<%=HEIGHT %>" value="" validate="Height,int,yes"
	maxlength="5" tabindex="1" /> <label class="unit">cm</label> <label
	class="smallmed"><span>*</span>Weight</label> <input type="text"
	class="small" name="<%=WEIGHT %>" value="" validate="Weight,int,yes"
	maxlength="5" tabindex="1" /> <label class="unit">kg</label> <label
	class="smallmed">Pulse</label> <input type="text" class="small"
	name="<%=PULSE %>" value="" validate="Pulse,flat,no" maxlength="6"
	tabindex="1" /> <label class="unit">Per Minute</label> <label
	class="smallmed">Temp</label> <input type="text" class="small"
	name="<%=TEMPERATURE %>" value="" validate="Temp,float,no"
	maxlength="5" tabindex="1" /> <label class="unit">°C</label> <label
	class="smallmed">HB</label> <input type="text" class="small"
	name="<%=HB_DL %>" value="" validate="HB/DL,float,no" maxlength="5"
	tabindex="1" /> <label class="unit">gms %</label> <label
	class="smallmed">BP</label> <input type="text" class="textbox_size4"
	name="<%=BP%>" value="" validate="BPA/BPA,string,no" maxlength="7"
	tabindex="1" /> <label class="unit">mm Hg</label>

<div class="Clear"></div>

<label>Phlebotomy site</label> 
<select name="<%=PHLEBOTOMY_SITE%>" tabindex="1"> 
	<option value="healthy">Healthy</option>
	<option value="anticubita">Anticubital</option>
</select> 
<!--  
<label>Expiry Date</label> 
<input type="text" class="calDate" id="newDateId" name="<%=EXPIRY_DATE %>" value="<%=currentDate %>" validate="Date of Collection,date,no" MAXLENGTH="10" tabindex="1" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.bloodDonationEntry.<%=EXPIRY_DATE%>,event)" />
-->

<label><span>*</span>Collected By</label> <select id="collectedBy"
	name="<%=EMPLOYEE_ID %>" validate="Collected By,string,yes"
	tabindex="1">
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
</select>


<div class="Clear"></div>
<label>VOL/REP/Auto</label> <select name="<%=VOL_REP %>" tabindex="1">
	<option value="0">Select</option>
	<option value="v"> Voluntary</option>
	<option value="r">Repalcement</option>
	<option value="a">Autologous</option>
	
</select> <input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /> <input type="hidden" name="pageNo" id="pageNo"
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

	int detailCounter=8; 
	int temp=0;
	int inc = 0;    	
	if(pageNo!=1){
		temp=detailCounter*(pageNo-1);
	} 
	for(inc=1;inc<=1;inc++){
    		
    	    	  
 %>

		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>" name="<%=SR_NO%>" readonly="readonly" tabindex=1 />
			</td>
			<td><input id="bloodBagId<%=inc%>" type="text" name="<%=BLOOD_BAG_NO%>" value="<%=bagNo[0] %>" onblur="checkForBloodBagNo1(this.value, '<%=inc %>');" size="20" MAXLENGTH="45" tabindex=1 validate="Blood Bag no.,int,yes"/> 
				<input type="hidden" value="" name="<%=BLOOD_COMPONENT_ID%>" id="bloodComponentId<%=inc %>" />
			</td>

			<td>
			    <input type="text" id="componentName<%=inc%>" name="bloodComponentName" onblur="if(fillSrNo('<%=inc %>')){checkForComponentCode(this.value, '<%=inc %>');}" tabindex=1 />
				<div id="ac2update" style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;">	</div>
				<script type="text/javascript" language="javascript" charset="utf-8">
  					new Ajax.Autocompleter(document.getElementById('componentName<%=inc%>'),'ac2update','bloodBank?method=getComponentNameDonationForAutoComplete',{parameters:'requiredField=bloodComponentName'});
				</script></td>
			
			<td>
			    <input type="text" id="quantity<%=inc%>" name="<%=QUANTITY %>" value="" validate="Quantity,int,no" MAXLENGTH="3"  tabindex=1 /> 
				<input type="hidden" name="bloodBagNoValueCheckOnSubmit" id="bloodBagNoValueCheckOnSubmit<%=inc%>" value="correctBloodBagNo" />
			</td>
			<td>
			<input type="text" class="calDate" id="expiryDate<%=inc%>" name="<%=EXPIRY_DATE %>" value="" validate="Date of Collection,date,no" 
			    MAXLENGTH="10" lostFocus="check()" tabindex="1" />
			<!--  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.bloodDonationEntry.<%=EXPIRY_DATE%>,event)" /> -->
			</td>
		</tr>
		<%} %>
		<input type="hidden" name="counter" id="counter" value="<%=inc %>"
			tabindex=1 />
	</tbody>
	<input type="hidden" value="<%=donationhdId %>" name="donationhdId"
		id="donationhdId" tabindex=1 />
</table>
</div>


<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom">
<input type="button" class="button"	value="Submit"	onclick="if(checkFilledRow())if(checkForQue1())if(validateCollExpDate())
	    {submitForm('bloodDonationEntry','bloodBank?method=submitBloodDonationEntry','checkBloodBag');}"
	align="right" tabindex=1 /> <input type="reset" class="button"
	name="Reset" id="reset" value="Reset"
	onclick="resetClicked('bloodDonationEntry',<%=inc %>);" accesskey="r"
	tabindex=1 />

<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="Clear"></div>


</div>
<!--Bottom labels starts--> <!--main content placeholder ends here-->
</div>

<script type="text/javascript"><!--
function myCheck(){
  alert("go here");
}
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
				var myDate = document.getElementById('lastDate').value;
				var year  = myDate.substring(6);
				var month = myDate.substring(3,5);
				var day   = myDate.substring(0,2);
			    
	/*	if(componentId =="")
		{
	  	 document.getElementById('quantity'+inc).value="";
	     return;
		}
		*/
			for(i=0;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('componentName'+i).value==val)
		{
			alert("Component Name already selected...!")
			document.getElementById('componentName'+inc).value=""
			var e=eval(document.getElementById('componentName'+inc)); 
			e.focus();
			return false;
					} 
				} 
		 }
		
		ajaxFunctionForAutoCompleteComponentName('bloodDonationEntry','bloodBank?method=fillItemsForComponentname&myDate='+ myDate + '&componentName=' +  componentName , inc);
		
		}else{
			document.getElementById('quantity'+inc).value = "";
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
      		var items =xmlHttp.responseXML.getElementsByTagName('radioIdFlags')[0];
       			for (loop = 0; loop < items.childNodes.length; loop++) 
      			{
	   		    	var item = items.childNodes[loop];
	    	    	var flagValue  = item.getElementsByTagName("flagValue")[0];
	    	    	var checkResult = flagValue.childNodes[0].nodeValue;
	    	    	if(checkResult == 'Duplicate'){
	    	    		
	    	    			alert('Blood Bag No'+ bagNoObj.value + ' already exist.');
	    	    		
	    	    		
	    	    		document.getElementById('bloodBagId'+rowCount).focus();
	    	    		document.getElementById('bloodBagNoValueCheckOnSubmit'+rowCount).value='duplicateBloodBagNo';
	    	    		return false;
	    	    	}else{
	    	    		document.getElementById('bloodBagNoValueCheckOnSubmit'+rowCount).value='correctBloodBagNo';
						return true;	    	    	
	    	    	}
      			}
    		}
  		}
  		bagNo = bagNoObj.value;
  		// alert(bagNoObj.value);
  		// alert(rowCount);
  		 //return false;
  		var url="/hms/hms/bloodBank?method=checkForExistingBloodBagNo&bagIdToCheck="+bagNo+"&bloodBagId="+bloodBagId;
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
	  	 	if(document.getElementById('bloodBagId'+i).value != ""){
	  			if(document.getElementById('bloodBagId'+i).value == ""){
	  				msg += "BloodBag No. can not be blank.\n";
	  			}
	  			if(document.getElementById('componentName'+i).value == ""){
	  				msg += "Component Name can not be blank.\n";
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
		if(document.getElementById('bloodBagId'+i).value==val)
		{
			alert("Blood bag already selected...!")
			document.getElementById('bloodBagId'+inc).value=""
			var e=eval(document.getElementById('bloodBagId'+inc)); 
			e.focus();
			return false;
		} }  }
		
		}
}
function chkLength(field,maxLimit)
	{
	if(field.value.length > maxLimit)
	{
	 alert('Maximum Limit is '+maxLimit+' characters.');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}
function checkForQue1(){
errorMsg="";
if(document.getElementById('notWell').value=="n" || document.getElementById('infected1').value=="y" 
||document.getElementById("heartDisease").checked == true || document.getElementById("lungDisease").checked == true
||document.getElementById("kidneyDisease").checked == true ||document.getElementById("CancerDisease").checked == true
||document.getElementById("Epilepsy").checked == true || document.getElementById("Tuberculosis").checked == true
||document.getElementById("CDiabetes").checked == true || document.getElementById("Hepatitis").checked == true
|| document.getElementById("Abnormalblooding").checked == true|| document.getElementById("alergicDisease").checked == true
||document.getElementById("Typhoid1").checked == true || document.getElementById("Malaria6").checked == true
||document.getElementById("dentalExtraction").checked == true || document.getElementById("Jaundice1").checked == true
||document.getElementById("Leprosy").checked == true || document.getElementById("Faintingsp").checked == true
|| document.getElementById("Schizophernia").checked == true ||document.getElementById("Abortions").checked == true
||document.getElementById("Immunozalic").checked == true || document.getElementById('majorSurgery').checked == true
||document.getElementById("Typhoid2").checked == true || document.getElementById('minorSurgery').checked == true
){
errorMsg += "Donor Can't Donate .\n"
}
 for(var i = 0; i < document.getElementsByName('pregnent').length; i++){
 if(document.getElementsByName('pregnent')[i].checked == true)
              {
              alert("adasd"+document.getElementsByName('pregnent')[i].value)
              if(document.getElementsByName('pregnent')[i].value="y"){
                 errorMsg += "Donor Can't Donate .\n"
              }
              }
 }
 

if(errorMsg !=""){
alert(errorMsg)
//if(document.getElementById('heartDisease').value==''){
	//document.getElementById('heartDisease').checked = false;
	//}
return true;
}else{
	return true;
}
}
function checkBloodBag(){
	var dupFlag = false;
	var dupFlagAtClietSide = false;
	var counter1 = document.getElementById('counter').value;
		for(var checkBlank = 1;checkBlank < counter1; checkBlank++){
			var isBlank = document.getElementById('bloodBagId'+checkBlank).value;
			
			if(isBlank == undefined || isBlank == ''){
							alert('Blood Bag No. can not be blank.');
					return false;
			}
		}
		return true;
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
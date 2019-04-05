<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>

<%@page import="jkt.hms.masters.business.Users"%>

<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/tabcontentIn.js" type="text/javascript"></script>

<SCRIPT>
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
		Map<String, Object> utilMap = new HashMap<String, Object>();
		String userName="";
		if(session.getAttribute("userName")!=null)
		 userName=(String)session.getAttribute("userName");
		Users users =null;
		if(session.getAttribute("users")!=null){
			users=(Users)session.getAttribute("users");
		}
		int loginEmpId=0;
		if(users!=null){
			if(users.getEmployee()!=null){
				loginEmpId=users.getEmployee().getId();
			}
		}

 		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getAttribute("map") != null){
			map=(Map<String, Object>)request.getAttribute("map");
		}
		
		List<MasUnit> unitList = null;
		List<MasRank> rankList = null;
		
		
		if(map.get("unitList") != null){
			unitList =(List<MasUnit>)map.get("unitList");
		}
		if(map.get("rankList") != null)	{
			rankList = (List<MasRank>)map.get("rankList");
		}
		
	
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		//String Session=(String) utilMap.get("session");
		String time = (String) utilMap.get("currentTime");		
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	
	</script>



<div class="clear"></div>
<div class="titleBg">	<h2>PHYSIOLOGICAL AND PSYCHOLOGICAL FACTORS</h2> </div>


<div class="clear"></div>
<form name="aircraftAccidentInvestigation" action="" method="post">





<div class="clear paddingTop15"></div>
<div class="Block">
<label>Employment</label>
	<select name="Employment"  id="Employment" >
		<option value="Pupil">Pupil</option>
		<option value="1st Squadron Appt">1st Squadron Appt</option>
		<option value="Later Sqdn Appt">Later Sqdn Appt</option>
		<option value="Instructor">Instructor</option>
		<option value="Employed on nonflying Appoinment">Employed on nonflying Appoinment</option>
	</select>


<label>Extra Qualifications</label>
<input tabindex="1" type="text"  name="extraQualifications"	tabindex="2" maxlength="20" >


<label>Date of Renewal</label>
<input	tabindex="1" name="<%=DATE_ONE %>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.<%=DATE_ONE%>,event);" />


</div>
<div class="clear paddingTop15"></div>
<h4>FLYING TIME</h4>

<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
	<TH scope="col">Flying Time</TH>
		<TH scope="col">As 1st Pilot</TH>
		<TH scope="col">As 2st Pilot</TH>
		<TH scope="col">As Crew</TH>
		<TH scope="col">On Type</TH>
	</tr>
	<tr>
		<td><label>In the last 24 hrs.</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
	</tr>
		<tr>
		<td><label>In the last 30 hrs.</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
	</tr>
	<tr>
		<td><label>Since being posted to the flying assignment</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
	</tr>
		<tr>
		<td><label>Other types of a/c flown</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
	</tr>
	</table>
	</div>




<div class="clear paddingTop15"></div>
<h4>PRESENT POSTING</h4>
<div class="Block">
<label class="large">Length of time at station</label>
<input tabindex="1" type="text"  name="lengthOfTimeAtStation"	tabindex="2" maxlength="20" >
<label>Months</label>
<input tabindex="1" type="text"  name="months"	tabindex="2" maxlength="20" >

<div class="clear"></div>


<label class="large"> Accommodation At Station</label>
<input tabindex="1" type="text"  name="atStation"	tabindex="2" maxlength="20" >
<label class="auto">miles away</label>

<div class="clear"></div>
<label class="large">Type of accommodation</label>
<input tabindex="1" type="text"  name="typeOfAccommodation"	tabindex="2" maxlength="20" >
</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label class="large">Current Flying Assessment: (to be obtained from Commanding Officer)</label>

	<select name="flying"  id="flying" >
		<option value="Exceptional">Exceptional</option>
		<option value="Above Average">Above Average</option>
		<option value="Average">Average</option>
		<option value="Below Standard">Below Standard</option>
		
	</select>
	
	<div class="clear"></div>
	<label class="large">Any Relevant Remarks</label>
<textarea rows="" cols="60"	name="relevantRemarks" class="auto" onkeyup="chkLength(this,150);"></textarea>
	
	
</div>



<div class="clear paddingTop15"></div>
<h4>PREVIOUS ACCDIENT HISTORY</h4>
<div class="Block">
<label>Aircraft Accident</label>

	<select name="aircraftAccident"  id="aircraftAccident" onchange="showAircraftAccident();">
	<option value="Yes">Yes</option>
		<option value="None">None</option>
		<option value="Not Known">Not Known</option>
	
		
	</select>
	
	<div id="aircraftAccidentDiv" style="display: none" >
<div class="clear"></div>
	<label>Description</label>
	<input tabindex="1" type="text"	name="damagedTxt" maxlength="10" value="" />


	<label>Date</label>
	<input	tabindex="1" name="<%=DATE_TWO%>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.<%=DATE_TWO%>,event);" />


	<label>Severity</label>

	<select name="severity"  id="severity" >
	<option value=""></option>

	</select>

	<label>Responsibility</label>
	<input tabindex="1" type="text"	name="responsibilityTxt" maxlength="10" value="" />


	</div>
	
	
	
	<label>Motoring Accident</label>

	<select name="motoringAccident"  id="motoringAccident" >
		<option value="None">None</option>
		<option value="Not Known">Not Known</option>
	
		
	</select>
	
		<label>Other Accident Involving Injury</label>

	<select name="otherAccident"  id="otherAccident" >
		<option value="None">None</option>
		<option value="Not Known">Not Known</option>
	
		
	</select>
</div>


<div class="clear paddingTop15"></div>
<h4>FATIGUE</h4>
<div class="Block">
<label class="large">Time at controls this Flight(if assessable)</label>
<input tabindex="1" type="text"	name="timeAtControlsThisFlight" maxlength="10" value="" />
<label class="small">hrs/ Mts</label>


<div class="clear"></div>

<label class="large">Number of take offs/landings during the sorties</label>
<input tabindex="1" type="text"	name="noOfTakeOffs" maxlength="10" value="" />

<div class="clear"></div>

<label class="large">Number of sorties in Last 24 hours</label>
<input tabindex="1" type="text"	name="noOfSorties" maxlength="10" value="" />

<label class="small">7 Days</label>
<input tabindex="1" type="text"	name="7days" maxlength="10" value="" />

<div class="clear"></div>

<label class="large">Number of hours duty in 24 hours preceding start of flight</label>
<input tabindex="1" type="text"	name="noOfSorties" maxlength="10" value="" />
<label class="small">Type duty</label>

<div class="clear"></div>

<label class="large">Amount of sleep(day/night) in 24 hours preceding start of flight</label>
<input tabindex="1" type="text"	name="amountOfSleep" maxlength="10" value="" />
<label class="small">hours.</label>

<select name="amount"  id="amount" >
		<option value="Probably">Probably 8 hours</option>
		<option value="Not Known">Not Known</option>
</select>

<div class="clear"></div>

<label class="large">Specify any recent factors liable to increase fatigue</label>
<select name="factors"  id="factors" onchange="showFactors();">
		<option value="Strenuous Exercise">Strenuous Exercise</option>
		<option value="Celebration">Celebration</option>
		<option value="Poor Transit Arrangements">Poor Transit Arrangements</option>
		<option value="Other">Other</option>
</select>

<div id="factorsDiv" style="display: none" >
	<label>Other</label>
	<input tabindex="1" type="text"	name="otherFactors" maxlength="10" value="" />
</div>


<div class="clear"></div>

<label class="large">Amount of Leave taken in Last 6 months</label>
<input tabindex="1" type="text"	name="amountOfLeave" maxlength="10" value="" />
<label class="small">hours.</label>


</div>



<div class="clear paddingTop15"></div>
<h4>FOOD</h4>
<div class="Block">

<label class="large">Hours since last full meal</label>
<input tabindex="1" type="text"	name="hours" maxlength="10" value="" />
<label class="auto">hr.</label>
<label class="auto">Which was</label>
<input tabindex="1" type="text"	name="whichWas" maxlength="10" value="" />

<div class="clear"></div>

<label class="large">Dispersal Canteen</label>

<select name="dispersalCanteen"  id="dispersalCanteen" >
		<option value="Avilable">Avilable</option>
		<option value="Not Avilable">Not Avilable</option>
		
</select>

<label class="auto">In Flight Feeding</label>
<select name="inFlightFeeding"  id="inFlightFeeding" >
		<option value="Provided">Provided</option>
		<option value="Not Provided">Not Provided</option>
		
</select>

<div class="clear"></div>
<label class="large">Specify any recent abnormalities of feedings</label>
<textarea rows="" cols="78"	name="abnormalitiesOffeeding" class="auto" onkeyup="chkLength(this,150);"></textarea>
	
</div>


<div class="clear paddingTop15"></div>
<h4>OTHER PHYSIOLOGICAL FACTORS</h4>
<div class="Block">

<label>Intoxication by CO/other fumes</label>
<textarea rows="" cols="40"	name="intoxication" class="auto" onkeyup="chkLength(this,150);"></textarea>


<label>Hypoxia</label>
<textarea rows="" cols="40"	name="hypoxia" class="auto" onkeyup="chkLength(this,150);"></textarea>
<div class="clear"></div>
<label>Disorientation in the air</label>
<textarea rows="" cols="40"	name="disorientation" class="auto" onkeyup="chkLength(this,150);"></textarea>


<label>Air Sickness</label>
<textarea rows="" cols="40"	name="airSickness" class="auto" onkeyup="chkLength(this,150);"></textarea>

<div class="clear"></div>
<label>Decompression Sickness</label>
<textarea rows="" cols="40"	name="decompressionSickness" class="auto" onkeyup="chkLength(this,150);"></textarea>



<label>Heat Stress</label>
<textarea rows="" cols="40"	name="heatStress" class="auto" onkeyup="chkLength(this,150);"></textarea>
<div class="clear"></div>

<label>Cold Injury</label>
<textarea rows="" cols="40"	name="coldInjury" class="auto" onkeyup="chkLength(this,150);"></textarea>


<label>Accelerations</label>
<textarea rows="" cols="40"	name="accelerations" class="auto" onkeyup="chkLength(this,150);"></textarea>
<div class="clear"></div>


<label>Hyperventilation</label>
<textarea rows="" cols="40"	name="hyperventilation" class="auto" onkeyup="chkLength(this,150);"></textarea>

<label>Hypoglycaemin</label>
<textarea rows="" cols="40"	name="hypoglycaemin" class="auto" onkeyup="chkLength(this,150);"></textarea>
<div class="clear"></div>
<label>Sycope (Other)</label>
<textarea rows="" cols="40"	name="sycope" class="auto" onkeyup="chkLength(this,150);"></textarea>

<label>Visual Factors in aircraft or environment</label>
<textarea rows="" cols="40"	name="visualFactorsInAircraft" class="auto" onkeyup="chkLength(this,150);"></textarea>
<div class="clear"></div>
<label>Noise/Vibration</label>
<textarea rows="" cols="40"	name="noiseVibration" class="auto" onkeyup="chkLength(this,150);"></textarea>

<label>Alcohol</label>
<textarea rows="" cols="40"	name="alcohol" class="auto" onkeyup="chkLength(this,150);"></textarea>




</div>


<div class="clear paddingTop15"></div>
<h4>PHYCHOLOGICAL STRESS</h4>
<div class="Block">

<label class="large">Willingness or otherwise to fly this trip</label>

<select name="willingness"  id="willingness" onchange="showWillingness()" class="small">
		<option value="Will">Will</option>
		<option value="Unwill">Unwill</option>
		
</select>

<div id="willingnessDiv" style="display: none" >
<label>Reason</label>
	<input tabindex="1" type="text"	name="reason" maxlength="10" value="" />
</div>

<div class="clear"></div>

<label class="large">Attitude towards Service</label>
<input tabindex="1" type="text"	class="large" name="service" maxlength="100" value="" />

<div class="clear"></div>

<label class="large">Attitude towards Shin/Unit</label>
<input tabindex="1" type="text"	class="large" name="shinUnit" maxlength="100" value="" />

<div class="clear"></div>

<label class="large">Attitude towards Flying</label>
<input tabindex="1" type="text"	class="large" name="flying" maxlength="100" value="" />

<div class="clear"></div>

<label class="large">Temperament/Emotional Stability</label>
<input tabindex="1" type="text"	class="large" name="temperamentEmotional" maxlength="100" value="" />

<div class="clear"></div>

<label class="large">Discipline/Recent Punishments</label>
<input tabindex="1" type="text"	class="large" name="discipline" maxlength="100" value="" />


<div class="clear"></div>

<label class="large">Confidence in ability to fly</label>


<select name="confidence"  id="confidence" class="small">
		<option value="Over Confident">Over Confident</option>
		<option value="Confident">Confident</option>
			<option value="Not Confident">Not Confident</option>
		
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksConfidence" maxlength="100" class="auto" size="31" value="" />



<div class="clear"></div>

<label class="large">Any evidence of anxiet prior to accident</label>
<input tabindex="1" type="text"	class="large" name="evidence" maxlength="100" value="" />



<div class="clear"></div>

<label class="large">Trend of conversation after the accident</label>


<select name="trend"  id="trend" class="small">
		<option value="Guild">Guild</option>
		<option value="Fear">Fear</option>
			<option value="Depression">Depression</option>
		
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksTrend" maxlength="100" value="" class="auto" size="31"/>


<div class="clear"></div>

<label class="large">Human Engineering Factors</label>
<input tabindex="1" type="text"	class="large" name="engineeringFactors" maxlength="100" value="" />



<div class="clear"></div>

<label class="auto">Eny haste or hurry in take off or completion of the sortie, apprehension of any malfunction of the aircraft due to its previous history</label>
<input tabindex="1" type="text"	name="haste" maxlength="100" value="" class="auto" size="150" />

<div class="clear"></div>
<label class="auto">This would cover any Human Engineering factor which the M.O. may feel and show that it is involved. Further if any accident pattern is observed the M.O. can state that as well</label>
<input tabindex="1" type="text" class="auto" size="150" name="humanEngineering" maxlength="100" value="" />

</div>

<div class="clear paddingTop15"></div>
<h4>TABLE OF INJURIES</h4>
<div class="Block">



<label>Scalp</label>


<select name="scalp"  id="scalp">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>


<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksScalp" maxlength="100" value="" />



<div class="clear"></div>


<label>Face</label>


<select name="face"  id="face">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>


<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksFace" maxlength="100" value="" />


<div class="clear"></div>


<label>Neck</label>


<select name="neck"  id="neck">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>


<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksNeck" maxlength="100" value="" />


<div class="clear"></div>


<label >Throax</label>
<label class="small">Ant</label>
<select name="ant"  id="ant" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>


<label class="small">Post</label>

<select name="post"  id="post" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>


<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksAntPost" maxlength="100" value="" />

<div class="clear"></div>

<label>Hand and Wrist </label>
<label class="small">Lt</label>
<select name="ltHandWrist"  id="ltHandWrist" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>

<label class="small">Rt.</label>

<select name="rtHandWrist"  id="rtHandWrist" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksLtRtHandWrist" maxlength="100" value="" />


<div class="clear"></div>

<label>Forearm and Elbow</label>
<label class="small">Lt.</label>
<select name="ltForearmAndElbow"  id="ltForearmAndElbow" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>


<label class="small">Rt.</label>
<select name="rtForearmAndElbow"  id="rtForearmAndElbow" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksLtRtForearmAndElbow" maxlength="100" value="" />

<div class="clear"></div>

<label>Arm and Shoulder</label>
<label class="small">Lt.</label>
<select name="ltArmAndShoulder"  id="ltArmAndShoulder" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>


<label class="small">Rt.</label>
<select name="rtArmAndShoulder"  id="rtArmAndShoulder" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksLtRtArmAndShoulder" maxlength="100" value="" />

<div class="clear"></div>




<label>Abdomen/Ant Post</label>


<select name="abdomenAntPost"  id="abdomenAntPost">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>


<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksAbdomenAntPost" maxlength="100" value="" />


<div class="clear"></div>

<label>Foot and Ankle</label>
<label class="small">Lt.</label>
<select name="ltFootAndAnkle"  id="ltFootAndAnkle" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>


<label class="small">Rt.</label>
<select name="rtFootAndAnkle"  id="rtFootAndAnkle" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksLtRtFootAndAnkle" maxlength="100" value="" />

<div class="clear"></div>


<label>Leg and Knee</label>
<label class="small">Lt.</label>
<select name="ltLegAndKnee"  id="ltLegAndKnee" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>

<label class="small">Rt.</label>
<select name="rtLegAndKnee"  id="rtLegAndKnee" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksLtRtLegAndKnee" maxlength="100" value="" />

<div class="clear"></div>

<label>Thigh and Hip</label>
<label class="small">Lt.</label>
<select name="ltThighAndHip"  id="ltThighAndHip" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>


<label class="small">Rt.</label>
<select name="rtThighAndHip"  id="rtThighAndHip" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksLtRtThighAndHip" maxlength="100" value="" />

<div class="clear"></div>


<label>Buttocks</label>
<label class="small">Lt.</label>
<select name="ltButtocks"  id="ltButtocks" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>


<label class="small">Rt.</label>
<select name="rtButtocks"  id="rtButtocks" class="smaller">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksLtRtButtocks" maxlength="100" value="" />

<div class="clear"></div>

<label>Perineum and Genitalia</label>


<select name="perineumAndGenitalia"  id="perineumAndGenitalia">
	<option value="Amputation">Amputation</option>
	<option value="Burns">Burns</option>
	<option value="Haematoma">Haematoma</option>
	<option value="Wound or deep Laceration">Wound or deep Laceration</option>
	<option value="Graze of abrasion">Graze of abrasion</option>
	<option value="Open Fracture">Open Fracture</option>
	<option value="Crushing">Crushing</option>
	<option value="Other Injuries">Other Injuries</option>
	<option value="Not Available for examination">Not Available for examination</option>
</select>


<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksPerineumAndGenitalia" maxlength="100" value="" />

</div>

<input tabindex="1"  type=button value="Submit" class=button  accessKey=r  />
<input tabindex="1" name=Reset type=reset value=Reset class=button id=reset accessKey=r onclick=resetCheck(); />

<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="clear"></div>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<INPUT	type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>">
<INPUT type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>">
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>">
</div>



<script type="text/javascript">
var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()
</script>

</form>
<script type="text/javascript">

function showTympanumExternalEars(){
	if(document.getElementById('tympanumExternalEars').value == 'Abnormal'){
	  	document.getElementById("tympanumExternalEarsDiv").style.display='inline';
	}else{
		document.getElementById("tympanumExternalEarsDiv").style.display='none';
	}
}


function addRowForEnclosurses(){
    
	  var tbl = document.getElementById('gridEnclosurses');
	  var lastRow = tbl.rows.length;
	  document.getElementById('enclosursesDataStatus').value="yes";
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration


	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'SRNo' + iteration;
	  e0.id = 'SRNo' + iteration;
	  e0.setAttribute('tabindex','1');
	  e0.size = '20'
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = 'enclosursesDetails' + iteration;
	  e1.id = 'enclosursesDetails' + iteration;
	  e1.setAttribute('tabindex','1');
	  e1.size = '20'
	  cellRight1.appendChild(e1);

	  
	 var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'button';
	  e2.className = 'buttonAdd';
	  e2.name='Button';
	  e2.setAttribute('onClick','addRowForEnclosurses();');
	  cellRight2.appendChild(e2);

	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonDel';
	  e3.name='delete';
	  e3.setAttribute('onClick','removeRowForEnclosurses();');
	  cellRight3.appendChild(e3);
	  

	}

function removeRowForEnclosurses()
	{
	  var tbl = document.getElementById('gridEnclosurses');
	  var lastRow = tbl.rows.length;
	  document.getElementById('enclosursesDataStatus').value="yes";
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('gridEnclosurses');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hiddenValue');
	  	hdb.value=iteration

	  }
	}
function addRowForCrewAndPassengers(){
    
	  var tbl = document.getElementById('gridCrewAndPassengers');
	  var lastRow = tbl.rows.length;
	  document.getElementById('crewAndPassengersDataStatus').value="yes";
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration


	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'SRNo' + iteration;
	  e0.id = 'SRNo' + iteration;
	  e0.setAttribute('tabindex','1');
	  e0.size = '20'
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = 'enclosursesDetails' + iteration;
	  e1.id = 'enclosursesDetails' + iteration;
	  e1.setAttribute('tabindex','1');
	  e1.size = '20'
	  cellRight1.appendChild(e1);

	  
	 var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'button';
	  e2.className = 'buttonAdd';
	  e2.name='Button';
	  e2.setAttribute('onClick','addRowForCrewAndPassengers();');
	  cellRight2.appendChild(e2);

	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonDel';
	  e3.name='delete';
	  e3.setAttribute('onClick','removeRowForCrewAndPassengers();');
	  cellRight3.appendChild(e3);
	  

	}

function removeRowForCrewAndPassengers()
	{
	  var tbl = document.getElementById('gridCrewAndPassengers');
	  var lastRow = tbl.rows.length;
	  document.getElementById('crewAndPassengersDataStatus').value="yes";
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('gridCrewAndPassengers');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hiddenValue');
	  	hdb.value=iteration

	  }
	}
function fileUploadWindowInvestigation(rowVal)
{
	var medicalExamId='';
 	if(medicalExamId=='0')
 	{
 	 	alert("file can not be uploaded; refferred to MH");
 	 	return false;
 	}else{ 	 
 		var val=document.getElementById('chargeCodeName'+rowVal).value;
		var index1 = val.lastIndexOf("[");
		var index2 = val.lastIndexOf("]");
		index1++;
		var invest_id = val.substring(index1,index2);
		var url="/hms/hms/medicalExam?method=displayFileUploadInvestigation";
		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
 	} 
}


function showPositionOfCasualty(){
	if(document.getElementById('positionOfCasualty').value == 'Other'){
	  	document.getElementById("positionOfCasualtyDiv").style.display='inline';
	}else{
		document.getElementById("positionOfCasualtyDiv").style.display='none';
	}
}

function showDisplacementOfCasualty(){
	if(document.getElementById('displacementOfCasualty').value == 'Other'){
	  	document.getElementById("displacementOfCasualtyDiv").style.display='inline';
	}else{
		document.getElementById("displacementOfCasualtyDiv").style.display='none';
	}
}
function showType(){
	if(document.getElementById('type').value == 'Other'){
	  	document.getElementById("typeDiv").style.display='inline';
	}else{
		document.getElementById("typeDiv").style.display='none';
	}
}

function showOuterClothing(){
	if(document.getElementById('outerClothing').value == 'Damaged'){
	  	document.getElementById("outerClothingDiv").style.display='inline';
	}else{
		document.getElementById("outerClothingDiv").style.display='none';
	}

}

function showAircraftAccident(){
	if(document.getElementById('aircraftAccident').value == 'Yes'){
	  	document.getElementById("aircraftAccidentDiv").style.display='inline';
	}else{
		document.getElementById("aircraftAccidentDiv").style.display='none';
	}

}


function showFactors(){
	if(document.getElementById('factors').value == 'Other'){
	  	document.getElementById("factorsDiv").style.display='inline';
	}else{
		document.getElementById("factorsDiv").style.display='none';
	}

}
function showWillingness(){
	if(document.getElementById('willingness').value == 'Unwill'){
	  	document.getElementById("willingnessDiv").style.display='inline';
	}else{
		document.getElementById("willingnessDiv").style.display='none';
	}

}
function showConditionOfBodywasDiv(){
	if(document.getElementById('conditionOfBodywas').value == 'Other'){
	  	document.getElementById("conditionOfBodywasDiv").style.display='inline';
	}else{
		document.getElementById("conditionOfBodywasDiv").style.display='none';
	}

}
function showHeart(){
	if(document.getElementById('heart').value == 'Any'){
	  	document.getElementById("heartDiv").style.display='inline';
	}else{
		document.getElementById("heartDiv").style.display='none';
	}

}
function showCoronary(){
	if(document.getElementById('coronary').value == 'Short'){
	  	document.getElementById("coronaryDiv").style.display='inline';
	}else{
		document.getElementById("coronaryDiv").style.display='none';
	}

}

function showAorta(){
	if(document.getElementById('aorta').value == 'Any'){
	  	document.getElementById("aortaDiv").style.display='inline';
	}else{
		document.getElementById("aortaDiv").style.display='none';
	}

}
function showOtherGreatVessels(){
	if(document.getElementById('otherGreatVessels').value == 'Any'){
	  	document.getElementById("otherGreatVesselsDiv").style.display='inline';
	}else{
		document.getElementById("otherGreatVesselsDiv").style.display='none';
	}

}

function showDiaphragam(){
	if(document.getElementById('diaphragam').value == 'Herniation'){
	  	document.getElementById("diaphragamDiv").style.display='inline';
	}else{
		document.getElementById("diaphragamDiv").style.display='none';
	}

}
function showPeritoneum(){
	if(document.getElementById('peritoneum').value == 'Any'){
	  	document.getElementById("peritoneumDiv").style.display='inline';
	}else{
		document.getElementById("peritoneumDiv").style.display='none';
	}

}
function showOesophagus(){
	if(document.getElementById('oesophagus').value == 'Any'){
	  	document.getElementById("oesophagusDiv").style.display='inline';
	}else{
		document.getElementById("oesophagusDiv").style.display='none';
	}

}
function showStomach(){
	if(document.getElementById('stomach').value == 'Any'){
	  	document.getElementById("stomachDiv").style.display='inline';
	}else{
		document.getElementById("stomachDiv").style.display='none';
	}

}
function showIntestines(){
	if(document.getElementById('intestines').value == 'Any'){
	  	document.getElementById("intestinesDiv").style.display='inline';
	}else{
		document.getElementById("intestinesDiv").style.display='none';
	}

}
function showLiver(){
	if(document.getElementById('liver').value == 'Any'){
	  	document.getElementById("liverDiv").style.display='inline';
	}else{
		document.getElementById("liverDiv").style.display='none';
	}

}
function showPancreas(){
	if(document.getElementById('pancreas').value == 'Any'){
	  	document.getElementById("pancreasDiv").style.display='inline';
	}else{
		document.getElementById("pancreasDiv").style.display='none';
	}

}
function showPelvicOrgans(){
	if(document.getElementById('pelvicOrgans').value == 'Any'){
	  	document.getElementById("pelvicOrgansDiv").style.display='inline';
	}else{
		document.getElementById("pelvicOrgansDiv").style.display='none';
	}

	if(document.getElementById('pelvicOrgans').value == 'Damaged'){
	  	document.getElementById("pelvicOrgansDamagedDiv").style.display='inline';
	}else{
		document.getElementById("pelvicOrgansDamagedDiv").style.display='none';
	}

}
function showThyroid(){
	if(document.getElementById('thyroid').value == 'Any'){
	  	document.getElementById("thyroidDiv").style.display='inline';
	}else{
		document.getElementById("thyroidDiv").style.display='none';
	}

	if(document.getElementById('thyroid').value == 'AnyTraumaticChanges'){
	  	document.getElementById("thyroidTraumaticDiv").style.display='inline';
	}else{
		document.getElementById("thyroidTraumaticDiv").style.display='none';
	}

}

function showLymphGlands(){
	if(document.getElementById('lymphGlands').value == 'Any'){
	  	document.getElementById("lymphGlandsDiv").style.display='inline';
	}else{
		document.getElementById("lymphGlandsDiv").style.display='none';
	}

	
}
function showCarbon(){
	if(document.getElementById('carbon').value == 'AutopsyEvidence'){
	  	document.getElementById("carbonDiv").style.display='inline';
	}else{
		document.getElementById("carbonDiv").style.display='none';
	}

	
}

function showOtherPoisonings(){
	if(document.getElementById('otherPoisonings').value == 'AutopsyEvidence'){
	  	document.getElementById("otherPoisoningsDiv").style.display='inline';
	}else{
		document.getElementById("otherPoisoningsDiv").style.display='none';
	}

	
}

function showHypoxia(){
	if(document.getElementById('hypoxia').value == 'AutopsyEvidence'){
	  	document.getElementById("hypoxiaDiv").style.display='inline';
	}else{
		document.getElementById("hypoxiaDiv").style.display='none';
	}

	
}

</script>



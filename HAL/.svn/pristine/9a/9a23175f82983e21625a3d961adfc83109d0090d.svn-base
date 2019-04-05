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
<div class="titleBg">	<h2>USE OF EJECTION SEAT</h2> </div>
<div class="clear"></div>
<form name="useOfEjectionSeat" action="" method="post">
<div class="clear paddingTop15"></div>
<div class="Block">
<label>Service No.<span>*</span></label>
<input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO %>" value="" title="Enter Service No" tabindex="1" validate="Service No,metachar,yes" maxlength="20"  
onblur="submitProtoAjaxWithDivName('useOfEjectionSeat','/hms/hms/aviationMedicine?method=getServiceNoDetailsForRegEquipmentInUse&serviceNo='+this.value,'patientDiv');" />
<input 	id="prefix" name="<%=PREFIX%>" type="text" maxlength="3" class="auto" size="1"	tabindex="1" validate="Prefix,metachar,no" /> 

</div>	
	<div class="clear paddingTop15"></div>
<div class="Block">	
<div id="patientDiv">
	<input type="hidden" name="avAccidentId" id="avAccidentId" value=""/>
	<input type="hidden" name="hinId" id="hinId" value=""/>
<label> Surname</label>
<input tabindex="1" type="text"	name="surname" maxlength="30" value="" />	

<label> First Name</label>
<input tabindex="1" type="text"	name="<%=FIRST_NAME %>" maxlength="30" value="" />



<label>Rank</label>
<select	id="<%=RANK %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}	}%>
</select>

<div class="clear"></div>

<label>Crew Duty (or Passenger Seating)</label>
<input tabindex="1" type="text"	name="crewDuty" maxlength="30" value="" />
</div>
<div class="clear paddingTop15"></div>

</div>

<h4>VOLUNTARY EJECTION</h4>
<div class="Block">
<select name="voluntaryEjection" id="voluntaryEjection">
	<option value="f">Involuntary Ejection In Flight</option>
	<option value="g">On Ground Impact</option>
</select>
<select name="voluntaryEjectionOne" id="voluntaryEjectionOne">
		<option value="b">Subject Uninjured</option>
		<option value="s">Subject Injured Slightly</option>
		<option value="v">Severely</option>
		<option value="d">Dangerously</option>
</select>
</div>
<div class="clear paddingTop15"></div>
<h4>DEATH OF SUBJECT</h4>
<div class="Block">
<label class="large">Evidence Of Use Of Ejection Seat</label>
<select name="evidenceEjectionSeat" id="evidenceEjectionSeat" onchange="showEvidenceEjectionSeat();">
		<option value="p">Personel Evidence</option>
		<option value="e">Eyewitness Evidence</option>
		<option value="r">Rescue Evidence</option>
		<option value="o">Other Evidence</option>
				
</select>

<div id="evidenceEjectionSeatDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksEvidenceEjection" maxlength="45" value="" />
</div>
<div class="clear"></div>
<label class="large">Distress Calls</label>
<select name="distressCalls" id="distressCalls" onchange="showDistressCalls();">
				<option value="m">Made</option>
				<option value="n">Not Made</option>
				<option value="s">Substance Of Call</option>				
</select>

<div id="distressCallsDiv" style="display: none" >
<label>If Applicable</label>
	<input tabindex="1" type="text"	name="remarksDistressCalls" maxlength="45" value="" />
</div>
<div class="clear"></div>

<label class="large">Damage To Aircraft Prior To Escape</label>
<select name="damageAircraftPrior" id="damageAircraftPrior" onchange="showDamageAircraftPrior();">
<option value="u">Unknown</option>
<option value="n">Undamaged</option>
<option value="f">On Fire</option>
<option value="b">Break Up</option>
<option value="o">Other Damage</option>
</select>

<div id="damageAircraftPriorDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksDamageAircraft" maxlength="50" value="" />
</div>

<div class="clear"></div>
<label class="large">Damage To Seat Prior To Ejection</label>
<select name="damageToSeatEjection" id="damageToSeatEjection" onchange="showdamageToSeatEjection();">
<option value="u">Unknown</option>
<option value="n">Undamaged</option>
<option value="d">Damaged</option>
<option value="s">Description of Damage</option>
</select>

<div id="damageToSeatEjectionDiv" style="display: none" >
<label>If Applicable</label>
	<input tabindex="1" type="text"	name="appliDamageToSeatEjection" maxlength="45" value="" />
</div>

<div class="clear"></div>
<label class="large">Canopy And/Or Hatch Jettison</label>

<select name="canopyHatchJettison" id="canopyHatchJettison" onchange="showcanopyHatchJettison();">
<option value="i">Independent Action</option>
<option value="w">Wind Blast Release</option>
<option value="f">Forcible Release</option>
<option value="b">Bind Fired</option>
<option value="o">Involuntary Canopy Jettison</option>
<option value="c">Canopy Destoryed Before Ejection</option>
<option value="j">Jettison Efficient</option>
<option value="a">Failed</option>
<option value="d">Difficulty</option>
<option value="y">Canopy was fully Jettisoned Before Ejection</option>
<option value="n">Canopy was not fully Jettisoned Before Ejection</option>
</select>
<div id="canopyHatchJettisonDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksCanopyHatchJettison" maxlength="50" value="" />
</div>
<div class="clear"></div>

<label class="large">Altitude At Canopy Jettison</label>
<input tabindex="1" type="text"	name="altitudeAtCanopyJettison" maxlength="10" value="Not Known" />
<label class="unit">ft</label>

<div class="clear"></div>

<label class="large">Speed At Canopy Jettison(I.A.S)</label>
<input tabindex="1" type="text"	name="speed_canopy" maxlength="30" value="Not Known" />
<label class="unit">Kts</label>

<div class="clear"></div>
<label class="large">Attitude At Canopy Jettison</label>
<input tabindex="1" type="text"	name="attitudeAtCanopyJettison" maxlength="30" value="Not Known" />

<div class="clear"></div>

<label class="large">Distance Of Canopy From Aircraft Wreekage</label>
<input tabindex="1" type="text"	name="distanceOfCanopyWreekage" maxlength="30" value="Not Known" />
<label class="unit">yds</label>

<div class="clear"></div>
<label class="large">Deliberate Delay In Ejection</label>
<select name="deliberateDelayEjection" id="deliberateDelayEjection" onchange="showdeliberateDelayEjection();">
<option value="f">Attempting Foreced Landing</option>
<option value="c">Risk To Civilians</option>
<option value="n">Not Applicable</option>
<option value="p">Preservation Aircraft</option>
<option value="s">So Directed</option>
<option value="o">Other</option>
</select>

<div id="deliberateDelayEjectionDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksDeliberateDelay" maxlength="45" value="" />
</div>
</div>

<div class="clear paddingTop15"></div>
<h4>Condition Of Ejection</h4>
<div class="Block">
<h4>State(indicating wether known or estimated)</h4>
<label class="large" >Time Between Emergency And Ejection</label>
<input tabindex="1" type="text"	name="time_emergency_ejection" maxlength="10" value="" />
<div class="clear"></div>
<label class="large">Altitude At Time Of Ejection</label>
<input tabindex="1" type="text"	name="altitudeEjection" maxlength="30" value="" />


<div class="clear"></div>

<label class="large">Cabin Altitude Immediately Prior To Ejection</label>
<input tabindex="1" type="text"	name="Altitude_immediate_ejection" maxlength="50" value="" />
<div class="clear"></div>
<%---
<label class="large">Speed(I.A.S) At Time Of Ejection</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" />
 --%>
<div class="clear"></div>

<label class="large">Speed(I.A.S) At Time Of Ejection</label>
<select name="speedAtTimeEjection" id="speedAtTimeEjection" >
<option value="l">Level</option>
<option value="c">Climbing</option>
<option value="d">Descending</option>
<option value="o">Diving</option>
<option value="k">Not Known</option>
</select>

<div class="clear"></div>
<label class="large">Aircraft Attitude Of Ejection</label>
<select name="aircraftAttitudeEjection" id="aircraftAttitudeOfEjection" >
<option value="l">Level Pitch</option>
<option value="u">Nose Up</option>
<option value="d">Nose Down</option>
<option value="k">Not Known</option>
</select>
<select name="aircraftAttitudeEjectionOne" id="aircraftAttitudeEjectionOne" >
<option value="b">Level Bank</option>
<option value="p">Banked Port</option>
<option value="s">Banked Starboard</option>
<option value="i">Inverted</option>
<option value="k">Not Known</option>
</select>
<select name="aircraftAttitudeEjectionTwo" id="aircraftAttitudeEjectionTwo" >
<option value="r">Rolling</option>
<option value="s">Spinning</option>
<option value="p">Spiralling</option>
<option value="k">Not Known</option>
</select>

<div class="clear"></div>
<label class="large">Configuration Of Aircraft At Time Of Ejection</label>
<select name="configAircraftTimeEjection" id="configAircraftTimeEjection" >
<option value="u">Wheels Up</option>
<option value="d">Wheels Down</option>
<option value="f">Flaps Up</option>
<option value="l">Flaps Down</option>
<option value="i">Dive Brakes In</option>
<option value="o">Dive Brakes Out</option>

</select>

<div class="clear"></div>


<label class="large">Accelerations At Time Of Ejection</label>
<select name="accelrAircraftTimeEjection" id="accelerationsAtTimeOfEjection" onchange="showAccelerationsAtTimeOfEjection();">
<option value="n">Nones</option>
<option value="p">Positive G</option>
<option value="g">Negative G</option>
<option value="k">Not Known</option>
</select>


<div id="accelerationsAtTimeOfEjectionPositiveGDiv" style="display: none" >
<label>Estimed At</label>
	<input tabindex="1" type="text"	name="accelrAircraftEstimate" maxlength="45" value="" />
</div>
<%--
<div id="accelerationsAtTimeOfEjectionNegativeGDiv" style="display: none" >
<label>Estimed At</label>
	<input tabindex="1" type="text"	name="estimedAtaccelerationsAtTimeOfEjectionNegativeG" maxlength="10" value="" />
</div> --%>

<div class="clear"></div>

<label class="large">Was the Aircraft Under Control At the Time Of Ejection</label>
<input tabindex="1" type="text"	name="aircraftUndercontrolEjection" maxlength="45" value="" class=""/>

</div>
<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">Type Of Seat</label>
<select name="typeOfSeat" id="typeOfSeat" onchange="showTypeOfSeat();">
<option value="n">Nones</option>
<option value="g">Positive G</option>
<option value="m">Muzzle Velocity Of Gun</option>
<option value="s">Survival Pack</option>
<option value="c">Cushion</option>
<option value="a">Any Unofficial Mods Noted</option>
</select>


<div id="typeOfSeatSurvivalPackDiv" style="display: none" >
<label>Type</label>
	<input tabindex="1" type="text"	name="typeSurvivalPack" maxlength="1" value="" />
</div>

<div id="typeOfSeatCushionDiv" style="display: none" >
<label>Type</label>
	<input tabindex="1" type="text"	name="typeCushion" maxlength="45" value="" />
</div>

<div id="typeOfSeatNotedDiv" style="display: none" >
<label>Noted</label>
	<input tabindex="1" type="text"	name="noted" maxlength="45" value="" />
</div>


<div class="clear"></div>

<label class="large">Seat Firing</label>
<select name="seatFiring" id="seatFiring" onchange="showSeatFiring();">
<option value="m">Mechanism</option>
<option value="f">Involuntary Firing</option>
<option value="b">Face Blind</option>
<option value="a">Alernative</option>
<option value="e">Survival Pack</option>
<option value="d">Difficulty</option>
</select>


<div id="seatFiringAlernativeDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="alernativeSeatRemark" maxlength="1" value="" />
</div>
<%---
<div id="seatFiringDifficultyDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="difficultySeatRemark" maxlength="10" value="" />
</div> --%>

<div class="clear"></div>

<label class="large">Leg Restraint</label>
<select name="legRestraint" id="legRestraint" >
<option value="f">Fitted</option>
<option value="n">Not Fitted</option>
<option value="l">Leg Flailing</option>
<option value="o">No Leg Flialing</option>
<option value="k">Not Known</option>

</select>

<div class="clear"></div>

<label class="large">Aircraft Fouling</label>
<select name="aircraftFouling" id="aircraftFouling" >
<option value="c">Cockpit Clearance</option>
<option value="t">Satisfactory</option>
<option value="u">Unsatisfactory</option>
<option value="k">Not Known</option>

</select>

<div class="clear"></div>

<label class="large">Fouling of other parts of aircraft</label>
	<input tabindex="1" type="text"	name="foulingOtherAircraft" maxlength="30" value="" />
	
<select name="aircraftFoulingOne" id="aircraftFoulingOne" onchange="showAircraftFouling();" class="">
<option value="p">Personal Edivence</option>
<option value="o">Other Evidence</option>
</select>

<div id="aircraftFoulingOneDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksAircraftFoulingOne" maxlength="45" value="" />
</div>


</div>


<div class="clear paddingTop15"></div>
<h4>Drogude Development</h4>
<div class="Block">
<label>Delay Seat Drogude Gun</label>
<input tabindex="1" type="text"	name="delayDrogueGun" maxlength="45" value="" />
<label class="unit">secs</label>

<label>Controller Drogude</label>
<select name="controllerDrogude" class="small" id="controllerDrogude" onchange="showControllerDrogude();">
<option value="d">Deployed</option>
<option value="f">Failure</option>
</select>

<div id="controllerDrogudeDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksControllerDrogude" maxlength="10" value="" />
</div>
<div class="clear"></div>

<label>Stabilising Drogude</label>
<select name="stabilisingDrogude" id="stabilisingDrogude" onchange="showStabilisingDrogude();">
<option value="d">Deployed</option>
<option value="f">Failure</option>
</select>

<div id="stabilisingDrogudeDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksStabilisingDrogude" maxlength="10" value="" />
</div>

</div>
<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">Descent Before Separation</label>
<select name="descentBeforeSeparation" id="descentBeforeSeparation" >
<option value="d">Deployed</option>
<option value="r">Rotation</option>
<option value="t">Tumbling</option>
<option value="k">Not Known</option>
</select>

<select name="descentBeforeSeparationOne" id="descentBeforeSeparationOne" onchange="showDescentBeforeSeparationOne();">
<option value="f">Fully Conscious</option>
<option value="l">Conscious Lost</option>
</select>

<div id="descentBeforeSeparationOneDiv" style="display: none" >
<input tabindex="1" type="text"	name="descentBeforeSeparationOne" maxlength="10" value="" />
<label class="unit"> secs.</label>
</div>
<select name="descentBeforeSeparationTwo" id="descentBeforeSeparationTwo" >
<option value="p">Personal Edivence</option>
<option value="i">Inferred</option>
<option value="k">Not Known</option>
</select>
</div>

<div class="clear paddingTop15"></div>
<h4>Separation</h4>
<div class="Block">
<h4>Fully Automatic Seat</h4>
<label class="large">Delay Drogue Gun Separation</label>
<input tabindex="1" type="text"	name="delayDrogueGunSeparation" maxlength="45" value="" />
<label class="unit"> secs.</label>
<div class="clear"></div>
<label class="large">G Stop Setting</label>
<input tabindex="1" type="text"	name="gStopSetting" maxlength="45" value="" />


<div class="clear"></div>
<label class="large">Scissor Shackle</label>
<select name="scissorShackle" id="scissorShackle" onchange="showScissorShackle();">
<option value="s">Satisfactory</option>
<option value="f">Failure</option>
</select>
<div id="scissorShackleDiv" style="display: none" >
<label>Remarks</label>
<input tabindex="1" type="text"	name="scissorShackleRemarks" maxlength="45" value="" />
</div>

<div class="clear"></div>
<label class="large">Head Rest</label>
<select name="headRest" id="headRest" onchange="showHeadRest();">
<option value="s">Satisfactory</option>
<option value="f">Failure</option>
</select>
<div id="headRestDiv" style="display: none" >
<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksHeadRest" maxlength="45" value="" />
</div>

<div class="clear"></div>
<label class="large">Seat Harness</label>
<select name="seatHarness" id="seatHarness" onchange="showSeatHarness();">
<option value="s">Satisfactory</option>
<option value="f">Failure</option>
</select>
<div id="seatHarnessDiv" style="display: none" >
<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksSeatHarness" maxlength="45" value="" />
</div>


<div class="clear"></div>
<label class="large">Altitude At Separation Required</label>
<input tabindex="1" type="text"	name="altitudeAtSeparationRequired" maxlength="30" value="Not Known" />
<label class="unit">ft</label>




<div class="clear paddingTop15"></div>

<h4>Manual Separation</h4>

<label class="large">Separation</label>
<select name="separationManual" id="separationManual" onchange="showSeparationManual();">
<option value="e">Easy</option>
<option value="d">Difficulty</option>
<option value="f">Failure</option>
</select>
<div id="separationManualDiv" style="display: none" >
<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksSeparationManual" maxlength="45" value="" />
</div>

<div class="clear"></div>
<label class="large">Altitude At Separation Required</label>
<input tabindex="1" type="text"	name="manualAltSeparation" maxlength="45" value="Not Known" />
<label class="unit">ft</label>


<div class="clear paddingTop15"></div>
<h4>Emergency Override Used </h4>

<label class="large">Emergency Override Used</label>

<select name="emergencyOverrideUsed" id="emergencyOverrideUsed" onchange="showEmergencyOverrideUsed();">
<option value="d">Deliberate Use</option>
<option value="i">Inadvertent Use</option>

</select>
<div id="emergencyOverrideUsedDiv" style="display: none" >
<label>Cause</label>
<input tabindex="1" type="text"	name="causeEmergencyOverrideUsed" maxlength="30" value="" />
</div>
<div class="clear"></div>
<label class="large">Reason For Use</label>
<input tabindex="1" type="text"	name="reasonForUse" maxlength="30" value="" />

<div class="clear"></div>
<label class="large">Altitude At Which Decision was taken</label>
<input tabindex="1" type="text"	name="altitudeAtWhichDecisionWasTaken" maxlength="10" value="Not Known" />
<label class="unit">ft</label>

<div class="clear"></div>
<label class="large">Separation</label>
<select name="separationEmergency" id="separationEmergency" onchange="showSeparationEmergency();">
<option value="e">Easy</option>
<option value="d">Difficulty</option>
<option value="f">Failure</option>
</select>
<div id="separationEmergencyDiv" style="display: none" >
<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksSeparationEmergency" maxlength="10" value="" />
</div>
<div class="clear"></div>
<label class="large">Altitude At Separation</label>
<input tabindex="1" type="text"	name="altitudeAtSeparationEmergency" maxlength="30" value="Not Known" />
<label class="unit">ft</label>

</div>

<div class="clear paddingTop15"></div>
<h4>Parachute Deployment</h4>
<div class="Block">
<label class="large">Automatic</label>
<select name="automatic" id="automatic" onchange="showAutomatic();">
<option value="e">Efficient</option>
<option value="f">Failure</option>
</select>
<div id="automaticDiv" style="display: none" >
<label>Specify</label>
<input tabindex="1" type="text"	name="specifyAutomatic" maxlength="45" value="" />
</div>

<div class="clear"></div>

<label class="large">Manual operation Required</label>
<input type="checkbox" name="manualOperationRequCheck" class="radioAuto" value="y">
<select name="manualOperCombo" id="manualOperationRequired"  onchange="showManualOperationRequired();">
<option value="s">Satisfacorty</option>
<option value="d">Difficulty</option>
<option value="f">Failure</option>
</select>
<div id="manualOperationRequiredDiv" style="display: none" >
<label>Specify</label>
<input tabindex="1" type="text"	name="manualOperComboSpecify" maxlength="30" value="" />
</div>
<div class="clear"></div>

<label class="large">Altitude At Parachute Deployment</label>
<input tabindex="1" type="text"	name="altitudeParachuteDeployment" maxlength="30" value="Not Known" />
<label class="unit">ft</label>
<div class="clear"></div>

<label class="large">Distance Of Seat From Subject On Ground</label>
<input tabindex="1" type="text"	name="distanceSeatGround" maxlength="30" value="Not Known" />
<label class="auto">yd/ miles</label>

</div>



<div class="clear paddingTop15"></div>

<div class="Block">
<label>Parachute Canopy</label>
<select name="parachuteCanopy" id="parachuteCanopy" >
<option value="p">Remained in Pack</option>
<option value="o">Opened By Ground Impact</option>
<option value="w">Opened by Damage Within Aircraft</option>
<option value="b">Deployment Automatically After By Gorund Impact</option>
</select>

<label>Deployment as in Para 20</label>
<select name="parachute_deployment" id="deployment" >
<option value="p">Partial Deployment</option>
<option value="f">Full Development</option>
<option value="k">Not Known</option>
</select>

<select name="deploymentOne" id="deploymentOne" >
<option value="u">Undamaged</option>
<option value="d">Damaged During Descent</option>
<option value="g">Damaged On Ground</option>
<option value="k">Not Known</option>
</select>
</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">Parachute Harness</label>
<select name="parachuteHarness" id="parachuteHarness" >
<option value="l">Effective to Ground  Level</option>
<option value="c">Failed During Descent</option>
<option value="k">Not Known</option>
</select>

<div class="clear"></div>

<label class="large">Release Box: Type Of Modification</label>
<select name="releasBoxModification" id="typeOfModification" onchange="showTypeOfModification();" >
<option value="g">Effective to Ground  Level</option>
<option value="f">Failed During Descent</option>
</select>
<div id="typeOfModificationDiv" style="display: none" >
<label>Specify</label>
<input tabindex="1" type="text"	name="specifyTypeOfModification" maxlength="30" value="" />
</div>

<select name="typeOfModificationOne" id="typeOfModificationOne" onchange="showTypeOfModificationOne();" >
<option value="u">Unfastended By Subject</option>
<option value="d">Difficulty</option>
<option value="r">Unfastended By Rescuers</option>
</select>
<div id="typeOfModificationOneDiv" style="display: none" >
<label>Specify</label>
<input tabindex="1" type="text"	name="specifyTypeOfModificationOne" maxlength="30" value="" />
</div>

<div class="clear"></div>
<label class="large">Descritption Of Harness,Overrides and Release Box at Rescue</label>
<input tabindex="1" type="text"	name="descritptionOfHarness" maxlength="45" value="" />
</div>


<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">Terrain For Landing</label>
<select name="terrainForLanding" id="terrainForLanding" onchange="showTerrainForLanding();">
<option value="b">Built Up</option>
<option value="w">Wooded</option>
<option value="s">Scrub</option>
<option value="e">Sea</option>
<option value="f">Fresh Water</option>
<option value="o">Open Ground</option>
</select>

<div id="terrainForLandingDiv" style="display: none" >
<label>Specify</label>
<input tabindex="1" type="text"	name="specifyTerrainForLanding" maxlength="30" value="" />
</div>


<div class="clear"></div>
<label class="large">Depth Of Crater Made By Subject</label>
<input tabindex="1" type="text"	name="depthOfCraterMadeBySubject" maxlength="30" value="" />
<label class="unit">c.m.</label>
</div>





<div class="clear paddingTop15"></div>
<h4>Condition For Landing</h4>
<div class="Block">
<label>Wind Speed</label>
<input tabindex="1" type="text"	name=wind_speed maxlength="30" value="Not Known" />

<label>Vertical Visibility</label>
<input tabindex="1" type="text"	name="verticalVisibility" maxlength="30" value="Not Known" />


<select name="conditionForLanding" id="condition_landing" class="small">
<option value="f">Fine</option>
<option value="r">Rain</option>
<option value="s">Strom</option>
<option value="o">Fog</option>
<option value="n">Snow</option>
<option value="k">Not Known</option>
</select>

<div class="clear"></div>
<label>Other Conditions</label>
<input tabindex="1" type="text"	name="otherConditions" maxlength="100" />


</div>


<div class="clear paddingTop15"></div>
<div class="Block">


<label class="large">Effectiveness Of Landing</label>

<select name="effectiveness_landing" id="effectivenessOfLanding" class="">
<option value="s">Free From Seat</option>
<option value="f">Seat Fouled With Rigging Lines</option>
<option value="r">Retained In Seat</option>
<option value="k">Not Known</option>
</select>

<select name="effectivenessOfLandingOne" id="effectivenessOfLandingOne" class="small" >
<option value="c">Conscious</option>
<option value="u">Unconscious</option>
<option value="k">Not Known</option>

</select>

<select name="effectivenessOfLandingTwo" id="effectivenessOfLandingTwo" class="small" onchange="showEffectivenessOfLandingTwo();">
<option value="l">Landing As Planned</option>
<option value="d">Difficulty In Landing</option>
</select>


<div id="effectivenessOfLandingTwoDiv" style="display: none" >
<label>Specify</label>
	<input tabindex="1" type="text"	name="specifyEffectiveLandingTwo" maxlength="30" value="" />
</div>

<div class="clear"></div>


<label class="large">Part of body sustaining initial impact</label>
<input tabindex="1" type="text"	name="partofbodyImpact" maxlength="50" />



<select name="effectiveness" id="effectivenessText" class="small" onchange="showEffectivenessText();">
<option value="n">No Darg</option>
<option value="d">Dargged</option>
<option value="k">Darg Unknown</option>
</select>

<div id="effectivenessTextDiv" style="display: none" >
	<input tabindex="1" type="text"	name="remarksEffectiveness" maxlength="50" value="" />
<label class="unit">yds</label>
</div>
</div>


<div class="clear paddingTop15"></div>
<h4>Degree Of Success</h4>
<div class="Block">
<label class="large">Casualty Fully Mobile </label>
<select name="casualtyContacted" id="casualtyContacted" class="small" >
<option value="y">Yes</option>
<option value="n">No</option>
</select>

<div class="clear"></div>

<label class="large">Contacted assistance after</label>
<input tabindex="1" type="text"	name="casualtyContacted" maxlength="50" value="" />
<label class="unit">min/hrs</label>


<div class="clear"></div>

<label class="large">Casualty incapacitated : Reached after</label>
<input tabindex="1" type="text"	name="casualtyIncapacitated" maxlength="50" value="" />
<label class="unit">min/hrs</label>


<div class="clear"></div>
<label class="large">Rescued By</label>
<input tabindex="1" type="text"	name="rescuedBy" maxlength="30" value="" />

<div class="clear"></div>
<label class="large">Time From Escape To Medical Treatment</label>
<input tabindex="1" type="text"	name="time_scapem_med_treatment" maxlength="6" value="" />
<label class="unit">min/hrs</label>
</div>
<div class="clear paddingTop15"></div>
<h4>Damage To Flying Clothing And Equipment Resulting From Escape</h4>
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<TH scope="col">Item</TH>
		<TH scope="col">Mark And Type</TH>
		<TH scope="col">Status</TH>
		<TH scope="col">Damage(Details)</TH>
	
	</tr>
	<tr>
		<td>Protective Helmet</td>
		<td>
			<input tabindex="1" type="text"	name="DamageProHelmetMark" maxlength="30" value=""/>
				
		</td>
			<td>
			<select name="damage_pro_helmet_status">
			
				<option value="w">Worn</option>
				<option value="n">Not Worn</option>
				<option value="l">Lost</option>
				<option value="d">Damage</option>	
			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="damage_pro_helmet_detail" maxlength="30" value=""/>
		</td>
		
		</tr>
		<tr>
				<td>Flying Helmet</td>
					<td>
			<input tabindex="1" type="text"	name="damage_fly_helmet_mark" maxlength="30" value=""/>
				
		</td>
		<td>
			<select name="damage_fly_helmet_status">
			
				<option value="w">Worn</option>
				<option value="n">Not Worn</option>
				<option value="l">Lost</option>
				<option value="d">Damage</option>	
			</select>
			
		</td>
		<td>
			<input tabindex="1" type="text"	name="damage_fly_helmet_detail" maxlength="30" value=""/>
			
		</td>
		</tr>
		<tr>
			<Td>Vizor/Goggles/Spectacles</Td>
				<td>
			<input tabindex="1" type="text"	name="HELMET_Vizor_Mark" maxlength="30" value=""/>
				
		</td>
		<td>
			<select name="damage_vizor_status">
			
				<option value="w">Worn</option>
				<option value="n">Not Worn</option>
				<option value="l">Lost</option>
				<option value="d">Damage</option>	
			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="damage_vizor_detail" maxlength="30" value=""/>
		</td>
		</tr>
		<tr>
		<Td>Overall/Immersion/Exposure Suit</Td>
			<td>
			<input tabindex="1" type="text"	name="damage_vizor_detail" maxlength="30" value=""/>
				
		</td>
				<td>
			<select name="overall">
			<option value="w">Worn</option>
				<option value="n">Not Worn</option>
				<option value="l">Lost</option>
				<option value="d">Damage</option>	
			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
			
		</td>
		</tr>
		<tr>
		<Td>Life Jacket</Td>
			<td>
			<input tabindex="1" type="text"	name="Equip_life_Jacket_mark" maxlength="45" value=""/>
				
		</td>
				<td>
			<select name="Equip_life_Jacket">
			<option value="w">Worn</option>
				<option value="n">Not Worn</option>
				<option value="l">Lost</option>
				<option value="d">Damage</option>
			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="damage_life_jkt_detail" maxlength="30" value=""/>
		</td>
		</tr>
		<tr>
		
		<Td>Boots</Td>
			<td>
			<input tabindex="1" type="text"	name="damage_boot_mark" maxlength="30" value=""/>
				
		</td>
				<td>
			<select name="damage_boot_status">
			<option value="w">Worn</option>
				<option value="n">Not Worn</option>
				<option value="l">Lost</option>
				<option value="d">Damage</option>
			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="damage_boot_detail" maxlength="30" value=""/>
		</td>
		</tr>
		<tr>
			<Td>Emergency Oxygen</Td>
				<td>
			<input tabindex="1" type="text"	name="damage_oxygen_mark" maxlength="30" value=""/>
		</td>
	<td>
			<select name="damage_oxygen_status">
			<option value="w">Worn</option>
				<option value="n">Not Worn</option>
				<option value="l">Lost</option>
				<option value="d">Damage</option>
			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="damage_oxygen_detail" maxlength="30" value=""/>
		</td>
		</tr>
		<tr>
		
		<Td>Other</Td>
			<td>
			<input tabindex="1" type="text"	name="damage_other_mark" maxlength="30" value=""/>
				
		</td>
				<td>
			<select name="damage_other_status">
				<option value="w">Worn</option>
				<option value="n">Not Worn</option>
				<option value="l">Lost</option>
				<option value="d">Damage</option>			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="damage_other_detail" maxlength="30" value=""/>
		</td>
		</tr>

	</table>
	</div>
	
	
	
<div class="clear paddingTop15"></div>
<h4>Injuries</h4>
<div class="Block">

<label class="large">Damage to Aircraft While in Cocpit or Cabin</label>
<input tabindex="1" type="text"	name="damage_aircraft_in_cocpit" maxlength="50" value="" class="large"/>
<div class="clear"></div>


<label class="large">Aircraft Fouling</label>
<input tabindex="1" type="text"	name="aircraft_fouling" maxlength="30" value="" class="large"/>
<div class="clear"></div>

<label class="large">Acceleration of seat</label>
<input tabindex="1" type="text"	name="acceleration_seat" maxlength="45" value="" class="large"/>
<div class="clear"></div>

<label class="large">Air Blast</label>
<input tabindex="1" type="text"	name="air_blast" maxlength="50" value="" class="large"/>
<div class="clear"></div>

<label class="large">Parachute Opening</label>
<input tabindex="1" type="text"	name="parachute_opening" maxlength="50" value="" class="large"/>
<div class="clear"></div>

<label class="large">Ground Impact</label>
<input tabindex="1" type="text"	name="ground_impact" maxlength="50" value="" class="large"/>
<div class="clear"></div>

<label class="large">Dragging</label>
<input tabindex="1" type="text"	name="dragging" maxlength="50" value="" class="large"/>
<div class="clear"></div>

<label class="large">Other Casuses</label>
<input tabindex="1" type="text"	name="other_causes" maxlength="50" value="" class="large"/>

</div>


<div class="clear paddingTop15"></div>
<h4>Previous Experience:Summarise</h4>
<div class="Block">

<label class="large">Any Practical Traning in the use of the ejection seat received</label>
	<select name="training_ejection_seat">
				<option value="y">Yes</option>
				<option value="n">No</option>
					
			</select>
			
			<div class="clear"></div>
<label class="large">Any Specific Parachute Traning</label>
	<select name="parachute_training">
			<option value="y">Yes</option>
				<option value="n">No</option>
				
			</select>

<div class="clear"></div>
<h4>Previous Escape(give date and degree of success)</h4>

<label class="large">Forced Landing or Ditching</label>
<input tabindex="1" type="text"	name="forced_landing_ditching" maxlength="50" value="" class="large"/>
<div class="clear"></div>
<label class="large">Unassisted Escape</label>
<input tabindex="1" type="text"	name="unassisted_escape" maxlength="50" value="" class="large"/>
<div class="clear"></div>
<label class="large">Ejection Seat Escape</label>
<input tabindex="1" type="text"	name="ejection_seat_escape" maxlength="50" value="" class="large"/>

</div>



<div class="clear paddingTop15"></div>
<h4>Impact With Water</h4>
<div class="Block">

<label class="auto">Speed At Impact</label>
<input tabindex="1" type="text"	name="speed_impact" maxlength="30" value="Not Known" />
<label class="auto">kts(I.A.S)</label>

<label class="auto">Aircraft Attitude at Impact</label>
<input tabindex="1" type="text"	name="aircraft_alt_impact" maxlength="30" value="Not Known" />


<label class="auto">Depth of Water</label>
<input tabindex="1" type="text"	name="depth_water" maxlength="30" value="Not Known" />
<label class="unit">ft</label>
</div>

<div class="clear paddingTop15"></div>
<h4>Cockpit Flooding</h4>
<div class="Block">

<label class="">No Flooding</label>
<input tabindex="1" type="checkbox"	name="no_flooding" maxlength="1" value="y" class="radioAuto" />

<label class="">Flooding Of</label>
<input tabindex="1" type="text"	name="flooding_of" class="auto" size="25" maxlength="30" value="" />

<label class="auto">degree as a result of</label>
<input tabindex="1" type="text"	name="degree_result_of" maxlength="30" class="auto" size="25"  value="" />
<label class="auto">(Indicate Height or Level of Water)</label>


</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">Canopy</label>
<select name="canopy">
<option value="u">Undamaged</option>
<option value="w">Damaged Before Water Impact</option>
<option value="a">Damaged An Water Impact</option>
<option value="k">Not Known</option>
</select>

<div class="clear"></div>

<label class="large">Voluntary Jettison</label>
<select name="voluntaryJettison">
<option value="a">Accidental Removal</option>
<option value="w">Before Water Impact</option>
<option value="s">On Surfacet</option>
<option value="bn">After Submersion</option>
<option value="k">Not Known</option>
</select>

<div class="clear"></div>

<label class="large">Blind Linked Jettison</label>
<input tabindex="1" class="radioAuto"  type="checkbox"	name="blind_linked_jettison" maxlength="1" value="y" />

<div class="clear"></div>

<label class="large">Secure Until Penetrated at Ejection</label>
<input tabindex="1" type="checkbox" class="radioAuto"	name="secureUntilPenetrated" maxlength="1" value="y" />
<div class="clear"></div>
<label class="large">Describe any Difficulties or Observations Relating to the Canopy</label>
<input tabindex="1" type="text"	name="difficult_observa_canopy" maxlength="45" value="" />

</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">Delay in Ejection</label>
<select name="delay_ejection">
<option value="n">No Delay</option>
<option value="i">Involuntary Delay</option>
<option value="d">Deliberate Delay</option>
</select>

<div class="clear"></div>

<label class="large">Reason For Delay</label>
<input tabindex="1" type="text"	name="reason_delay" maxlength="30" value="" />

<div class="clear"></div> 

<label class="large">Extend Of Delay</label>
<input tabindex="1" type="text"	name="extend_delay" maxlength="30" value="" />

<div class="clear"></div>

<div class="clear"></div>
<label class="large">Estimated depth at which ejection was performed</label>
<input tabindex="1" type="text"	name="estimated_depth" maxlength="30" value="Not Known" />

<div class="clear"></div>

<label class="large">Ejection</label>

<select name="ejection" id="ejection"  onchange="showEjection();">
<option value="v">Vertical</option>
<option value="o">Other</option>

</select>

<div id="ejectionDiv" style="display: none" >
<label>Specify</label>
	<input tabindex="1" type="text"	name="specifyEjection" maxlength="30" value="" />
</div>

<div class="clear"></div>

<label class="large">No Rotation</label>
<input tabindex="1" type="checkbox"	name="noRotation" maxlength="1" class="radioAuto" value="y" />

<div class="clear"></div>

<label class="large">Rotation Of</label>
	<input tabindex="1" type="text"	name="rotationOf" maxlength="30" value="Not Known" />



<select name="rotationOf2" id="rotationOf2" class="" >
<option value="n">Not Ejected To Surface</option>
<option value="s">Ejected To Surface</option>
<option value="a">Ejected To Above Surface</option>
</select>

<div class="clear"></div>

<label class="large">Resubmerged to </label>
	<input tabindex="1" type="text"	name="resubmerged" maxlength="30" value="Unknown depth" />
<label class="auto">ft.</label>

<input class="transparent" size="4" />

<select name="resubmerged_consciousnes" id="ejectionTwo" class="small" >
<option value="r">Consciousness Retained</option>
<option value="l">Consciousness Lost</option>
<option value="k">Not Known</option>
</select>



</div>

<div class="clear paddingTop15"></div>
<h4>Harness Release</h4>
<div class="Block">
<label class="large">Manual Release Before Ejection</label>

<select name="manualReleaseEjection" id="manualReleaseEjection" class="" >
<option value="a">Automatic Release</option>
<option value="m">Manual Release After Ejection</option>
<option value="k">Not Known</option>
</select>
<div class="clear"></div>
<label class="large">Describe any Difficulties Assoiated With Harness Release</label>
	<input tabindex="1" type="text"	name="associateHarnessRelease" maxlength="45" value="Not Known" />


</div>



<div class="clear paddingTop15"></div>
<h4>Ascent After Separation</h4>
<div class="Block">
<label class="large">Parachute Harness Released</label>

<select name="parachute_harness" id="parachute_harness" class="" >
<option value="b">Before Ejection</option>
<option value="a">After Ejection</option>

</select>

<select name="parachute_harness2" id="parachute_harness2" class="" >
<option value="b">Below Surface</option>
<option value="o">On Surface</option>
<option value="k">Not Known</option>

</select>
<div class="clear"></div>
<label class="large">Describe any Difficulties Assoiated With Release From Parachute Harness And Rgging Lines</label>
<input tabindex="1" type="text"	name="parachute_harness_ragging" maxlength="30" value="" />

<div class="clear"></div>

<label class="large">Life Jacket</label>
<select name="lifeJacket" id="lifeJacket" class="" >
<option value="n">Not Inflated</option>
<option value="b">Inflated Below Surface</option>
<option value="o">Inflated On Surface</option>
<option value="k">Not Known</option>
</select>


<div class="clear"></div>
<label class="large">Dinghy, if Available</label>
<select name="dinghy" id="dinghy" class="" >
<option value="i">Inflated</option>
<option value="n">Not Inflated</option>
</select>
<select name="dinghyUsed" id="dinghyOne" class="" >
<option value="u">Used</option>
<option value="n">Not Used</option>
</select>

<div class="clear"></div>
<label class="large">Estimated Time From Ejection To Reaching Surface</label>
<input tabindex="1" type="text"	name="timeEjectionSurface" maxlength="10" value="Not Known" />
<label class="unit">secs.</label>


<div class="clear"></div>
<label class="large">Describe Any Shortness of Breath Experienced</label>
<input tabindex="1" type="text"	name="breath_experience" maxlength="45" value="" />




</div>


<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">Survival</label>
<select name="survival" id="survival" class="" >
<option value="i">Immediate Rescue</option>
<option value="f">Appendix 'F' Completed</option>
</select>

</div>
<div class="clear paddingTop15"></div>
<h4>Disabilities</h4>
<div class="Block">
<label class="large">Describe Any Disabilities Sustained As Result Of Under Water Ejection</label>
<input tabindex="1" type="text"	name="disabilities_underwater" maxlength="45" value="" />
</div>

<div class="clear paddingTop15"></div>
<h4>Training</h4>
<div class="Block">
<label class="large">Detail Any Previous Traning Or Experience In Underwater Escape</label>
<input tabindex="1" type="text"	name="pre_train_exp_underwater" maxlength="50" value="" />
</div>

<input tabindex="1"  type=button value="Submit" class=button  accessKey=r  
onclick="submitForm('useOfEjectionSeat','/hms/hms/aviationMedicine?method=submitUseEjectionSeat&flag=ejectionSeat');"/>
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
<INPUT type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>" />
<INPUT type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>" />
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>" />

</form>

<script type="text/javascript">
	var countries=new ddtabcontent("countrytabs")
	countries.setpersist(true)
	countries.setselectedClassTarget("link") //"link" or "linkparent"
	countries.init()
</script>

<script type="text/javascript">

function showAircraftFouling()
{
	if(document.getElementById('aircraftFoulingOne').value == 'o'){
	  	document.getElementById("aircraftFoulingOneDiv").style.display='inline';
	}else{
		document.getElementById("aircraftFoulingOneDiv").style.display='none';
	}	
}
function showAircraftFoulingOne()
{
	if(document.getElementById('aircraftFoulingOne').value == 'o'){
	  	document.getElementById("aircraftFoulingOneDiv").style.display='inline';
	}else{
		document.getElementById("aircraftFoulingOneDiv").style.display='none';
	}
}

function showEffectivenessOfLandingTwo()
{
	if(document.getElementById('effectivenessOfLandingTwo').value == 'd'){
	  	document.getElementById("effectivenessOfLandingTwoDiv").style.display='inline';
	}else{
		document.getElementById("effectivenessOfLandingTwoDiv").style.display='none';
	}
}

function showEffectivenessText()
{
	if(document.getElementById('effectivenessText').value == 'd'){
	  	document.getElementById("effectivenessTextDiv").style.display='inline';
	}else{
		document.getElementById("effectivenessTextDiv").style.display='none';
	}
}
function showEvidenceEjectionSeat()
{
	if(document.getElementById('evidenceEjectionSeat').value == 'o'){
	  	document.getElementById('evidenceEjectionSeatDiv').style.display='inline';
	}else{
		document.getElementById('evidenceEjectionSeatDiv').style.display='none';
	}	
}

function showDistressCalls()
{
	if(document.getElementById('distressCalls').value == 's'){
	  	document.getElementById("distressCallsDiv").style.display='inline';
	}else{
		document.getElementById("distressCallsDiv").style.display='none';
	}
}
function showdamageToSeatEjection()
{
	if(document.getElementById('damageToSeatEjection').value == 's'){
	  	document.getElementById("damageToSeatEjectionDiv").style.display='inline';
	}else{
		document.getElementById("damageToSeatEjectionDiv").style.display='none';
	}	
}
function showcanopyHatchJettison()
{
	if(document.getElementById('canopyHatchJettison').value == 'd'){
	  	document.getElementById("canopyHatchJettisonDiv").style.display='inline';
	}else{
		document.getElementById("canopyHatchJettisonDiv").style.display='none';
	}
}
function showdeliberateDelayEjection()
{
	if(document.getElementById('deliberateDelayEjection').value == 'o'){
	  	document.getElementById("deliberateDelayEjectionDiv").style.display='inline';
	}else{
		document.getElementById("deliberateDelayEjectionDiv").style.display='none';
	}	
}

function showAccelerationsAtTimeOfEjection(){
	if(document.getElementById('accelerationsAtTimeOfEjection').value == 'p'){
	  	document.getElementById("accelerationsAtTimeOfEjectionPositiveGDiv").style.display='inline';
	}else{
		document.getElementById("accelerationsAtTimeOfEjectionPositiveGDiv").style.display='none';
	}
	//if(document.getElementById('accelerationsAtTimeOfEjection').value == 'n'){
	 // 	document.getElementById("accelerationsAtTimeOfEjectionNegativeGDiv").style.display='inline';
	//}else{
//		document.getElementById("accelerationsAtTimeOfEjectionNegativeGDiv").style.display='none';
	//}
}
function showTypeOfSeat(){
	if(document.getElementById('typeOfSeat').value == 's'){
	  	document.getElementById("typeOfSeatSurvivalPackDiv").style.display='inline';
	}else{
		document.getElementById("typeOfSeatSurvivalPackDiv").style.display='none';
	}
	if(document.getElementById('typeOfSeat').value == 'c'){
	  	document.getElementById("typeOfSeatCushionDiv").style.display='inline';
	}else{
		document.getElementById("typeOfSeatCushionDiv").style.display='none';
	}
	if(document.getElementById('typeOfSeat').value == 'a'){
	  	document.getElementById("typeOfSeatNotedDiv").style.display='inline';
	}else{
		document.getElementById("typeOfSeatNotedDiv").style.display='none';
	}
}

function showSeatFiring(){
	if(document.getElementById('seatFiring').value == 'a'){
	  	document.getElementById("seatFiringAlernativeDiv").style.display='inline';
	}else{
		document.getElementById("seatFiringAlernativeDiv").style.display='none';
	}
//	if(document.getElementById('seatFiring').value == 'd'){
	 // 	document.getElementById("seatFiringDifficultyDiv").style.display='inline';
	//}else{
	//	document.getElementById("seatFiringDifficultyDiv").style.display='none';
	//}
}
function showControllerDrogude(){
	if(document.getElementById('controllerDrogude').value == 'f'){
	  	document.getElementById("controllerDrogudeDiv").style.display='inline';
	}else{
		document.getElementById("controllerDrogudeDiv").style.display='none';
	}
}
function showStabilisingDrogude(){
	if(document.getElementById('stabilisingDrogude').value == 'f'){
	  	document.getElementById("stabilisingDrogudeDiv").style.display='inline';
	}else{
		document.getElementById("stabilisingDrogudeDiv").style.display='none';
	}
}
function showDescentBeforeSeparationOne(){
	if(document.getElementById('descentBeforeSeparationOne').value == 'c'){
	  	document.getElementById("descentBeforeSeparationOneDiv").style.display='inline';
	}else{
		document.getElementById("descentBeforeSeparationOneDiv").style.display='none';
	}
}
function showScissorShackle(){
	if(document.getElementById('scissorShackle').value == 'f'){
	  	document.getElementById("scissorShackleDiv").style.display='inline';
	}else{
		document.getElementById("scissorShackleDiv").style.display='none';
	}
}
function showHeadRest(){
	if(document.getElementById('headRest').value == 'f'){
	  	document.getElementById("headRestDiv").style.display='inline';
	}else{
		document.getElementById("headRestDiv").style.display='none';
	}
}
function showSeatHarness(){
	if(document.getElementById('seatHarness').value == 'f'){
	  	document.getElementById("seatHarnessDiv").style.display='inline';
	}else{
		document.getElementById("seatHarnessDiv").style.display='none';
	}
}

function showSeparationManual(){
	if(document.getElementById('separationManual').value == 'f'){
	  	document.getElementById("separationManualDiv").style.display='inline';
	}else{
		document.getElementById("separationManualDiv").style.display='none';
	}
}

function showEmergencyOverrideUsed(){
	if(document.getElementById('emergencyOverrideUsed').value == 'i'){
	  	document.getElementById("emergencyOverrideUsedDiv").style.display='inline';
	}else{
		document.getElementById("emergencyOverrideUsedDiv").style.display='none';
	}
}
function showSeparationEmergency(){
	if(document.getElementById('separationEmergency').value == 'f'){
	  	document.getElementById("separationEmergencyDiv").style.display='inline';
	}else{
		document.getElementById("separationEmergencyDiv").style.display='none';
	}
}
function showAutomatic(){
	if(document.getElementById('automatic').value == 'f'){
	  	document.getElementById("automaticDiv").style.display='inline';
	}else{
		document.getElementById("automaticDiv").style.display='none';
	}
}
function showManualOperationRequired(){
	if(document.getElementById('manualOperationRequired').value == 'f'){
	  	document.getElementById("manualOperationRequiredDiv").style.display='inline';
	}else{
		document.getElementById("manualOperationRequiredDiv").style.display='none';
	}

}
function showTypeOfModification(){
	if(document.getElementById('typeOfModification').value == 'f'){
	  	document.getElementById("typeOfModificationDiv").style.display='inline';
	}else{
		document.getElementById("typeOfModificationDiv").style.display='none';
	}
}
function showTypeOfModificationOne(){
	if(document.getElementById('typeOfModificationOne').value == 'd'){
	  	document.getElementById("typeOfModificationOneDiv").style.display='inline';
	}else{
		document.getElementById("typeOfModificationOneDiv").style.display='none';
	}

}
function showTerrainForLanding(){
	if(document.getElementById('terrainForLanding').value == 'o'){
	  	document.getElementById("terrainForLandingDiv").style.display='inline';
	}else{
		document.getElementById("terrainForLandingDiv").style.display='none';
	}
}
function showEjection(){
	if(document.getElementById('ejection').value == 'o'){
	  	document.getElementById("ejectionDiv").style.display='inline';
	}else{
		document.getElementById("ejectionDiv").style.display='none';
	}

}

function showDamageAircraftPrior()
{
	if(document.getElementById('damageAircraftPrior').value == 'o'){
	  	document.getElementById("damageAircraftPriorDiv").style.display='inline';
	}else{
		document.getElementById("damageAircraftPriorDiv").style.display='none';
	}	
}

</script>



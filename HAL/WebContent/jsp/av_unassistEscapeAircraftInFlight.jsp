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
<div class="titleBg">	<h2>AN UNASSISTED ESCAPE FROM AN AIRCRAFT IN FLIGHT</h2> </div>


<div class="clear"></div>
<form name="unassistedEscapeAircraft" action="" method="post">

<div class="clear paddingTop15"></div>
<div class="Block">
<label>Service No.<span>*</span></label>
<input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO %>" value="" title="Enter Service No" tabindex="1" validate="Service No,metachar,yes" maxlength="20"  
onblur="submitProtoAjaxWithDivName('unassistedEscapeAircraft','/hms/hms/aviationMedicine?method=getServiceNoDetailsForRegEquipmentInUse&serviceNo='+this.value,'patientDiv');" />
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
</div>
<div class="clear paddingTop15"></div>
<div class="Block">
<label>Evidence Of Escape In Flight</label>
<select name="escapeFlight" id="evidenceOfEscapeinFlight" onchange="showEvidenceOfEscapeinFlight();">
<option value="p">Personal Evidence</option>
<option value="e">Eyewithness Evidence</option>
<option value="r">Rescue Evidence</option>
<option value="s">Seat Harness Recovered Unfastended</option>
<option value="o">Other Evidence</option>
</select>


<div id="evidenceOfEscapeinFlightDiv" style="display: none" >
<label>Remarks</label>

	<input tabindex="1" type="text"	name="escapeFlightRemarks" maxlength="20" value="" />

	<input tabindex="1" type="text"	name="remarksEvidenceOfEscapeinFlight" maxlength="30" value="" />

</div>


<label>Brief Description of method of escape</label>
<textarea rows="" cols="60"	name="briefDesEscape" class="auto" onkeyup="chkLength(this,100);"></textarea>

</div>



<div class="clear paddingTop15"></div>
<div class="Block">
<label>Distress Calls</label>
<select name="distressCalls" id="distressCalls">
<option value="m">Made</option>
<option value="n">Not Made</option>
</select>


<label>Damage To Aircraft Prior To Escape</label>
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

	<input tabindex="1" type="text"	name="remarksDamageAircraftPrior" maxlength="50" value="" />

</div>
</div>




<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">Canopy And/Or Jettison</label>
<select name="canopyJettison" id="canopyAndOrJettison" onchange="showCanopyAndOrJettison();">
<option value="c">Clear</option>
<option value="d">Difficulty</option>
</select>
<div id="canopyAndOrJettisonDiv" style="display: none" >
<label>Remarks</label>

	<input tabindex="1" type="text"	name="remarksCanopyJettison" maxlength="50" value="" />

	<input tabindex="1" type="text"	name="remarkscanopyAndOrJettison" maxlength="50" value="" />

</div>

<div class="clear"></div>
<label class="large">Altitude at canopy/hatch jettison</label>
	<input tabindex="1" type="text"	name="attitude_canopy" maxlength="30" value="Not Known" />

<div class="clear"></div>

<label class="large">Speed at canopy / hatch jettison(I.A.S)</label>
	<input tabindex="1" type="text"	name="speed_canopy" maxlength="30" value="Not Known" />
<div class="clear"></div>

<label class="large">Aircraft altitude at canopy/hatch jettison</label>
	<input tabindex="1" type="text"	name="aircraft_canopy" maxlength="30" value="Not Known" />
<div class="clear"></div>

<label class="large">Distance of canopy/hatch from aircraft wreckage</label>
	<input tabindex="1" type="text"	name="distance_canopy" maxlength="30" value="Not Known" />


</div>

<div class="clear paddingTop15"></div>

<h4>Conditions Of Escape</h4>

<div class="Block">
<h4>State (indicating whether known or estimated)</h4>


<label class="large">Time Between Emergency And Escape</label>
<input tabindex="1" type="text"	name="time_emergency_escape" maxlength="50" value="" class="large"/>

<div class="clear"></div>
<label class="large">Altitude at Time Of Escape</label>
<input tabindex="1" type="text"	name="altitude_time_escape" maxlength="50" value="" class="large"/>


<div class="clear"></div>

<label class="large">Cabin Altitude Immediately Prior to Escape</label>

<input tabindex="1" type="text"	name="cabin_immediate_escape" maxlength="50" value="" class="large"/>

<%--<input tabindex="1" type="text"	name="cabin_aimmediate_escape" maxlength="50" value="" class="large"/> --%>


<div class="clear"></div>
<label class="large">Speed (I.A.S) At time of Escape</label>
<input tabindex="1" type="text"	name="speed_time_escape" maxlength="50" value="" class="large"/>

<div class="clear"></div>

<div class="clear"></div>
<label class="large">Flight Path at Time of Escape</label>
<select name="flightPath_time_escape" id="flightPath_time_escape" >
<option value="l">Level</option>
<option value="c">Climbing</option>
<option value="d">Descending</option>
<option value="i">Diving</option>
<option value="s">Spinning</option>
<option value="k">Not Known</option>

</select>
<div class="clear"></div>

<label class="large">Aircraft Attitude at the time of escape</label>
<select name="aircraft_time_escape" id="aircraft_time_escape" >
<option value="l">Level Pitch</option>
<option value="n">Nose Up</option>
<option value="d">Nose Down</option>
<option value="k">Not Known</option>
<option value="b">Level Back</option>
<option value="p">Banked Port</option>
<option value="s">Banked Starboard</option>
<option value="i">Banked Inverted</option>

</select>

<div class="clear"></div>

<label class="large">Configuration Of Aircraft At Time Escape</label>
<select name="config_time_escape" id="config_time_escape" >
<option value="u">Underdercarriage Up</option>
<option value="d">Underdercarriage Down</option>
<option value="f">Flaps Up</option>
<option value="p">Flaps Down</option>
<option value="i">Dive Breakes In</option>
<option value="o">Dive Breakes Out</option>
</select>

<div class="clear"></div>
<label class="large">Aeccelercarriage at Time of Escape</label>

<select name="accele_time_escape" id="accele_time_escape" onchange="showAccelerationsAtTimeOfEscape();">
<option value="o">Nones</option>
<option value="p">Positive G</option>
<option value="n">Negative G</option>
<option value="k">Not Known</option>
</select>


<div id="accelerationsAtTimeOfEscapePositiveGDiv" style="display: none" >
<label>Estimed At</label>

	<input tabindex="1" type="text"	name="accele_time_escape_p" maxlength="50" value="" />

	<input tabindex="1" type="text"	name="estimed_accele_time_escape_p" maxlength="50" value="" />

</div>

<div id="accelerationsAtTimeOfEscapeNegativeGDiv" style="display: none" >
<label>Estimed At</label>

	<input tabindex="1" type="text"	name="accele_time_escape_n" maxlength="50" value="" />

	<input tabindex="1" type="text"	name="estimed_accele_time_escape_n" maxlength="50" value="" />

</div>

<div class="clear"></div>
<label class="large">Was the Aircraft Under Control At The Time Of Escape Attempt?</label>
<input tabindex="1" type="text"	name="aircraftUnderControl" maxlength="50" value="" class="large"/>

</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label>Aircraft Fouling</label>
<select name="aircraftFouling" id="aircraftFouling" class="" onchange="showAircraftFouling();">
<option value="n">Nil</option>
<option value="m">Minor</option>
<option value="o">Moderate</option>
<option value="s">Severe</option>
<option value="e">Personal Evidence</option>
<option value="v">Other Evidence</option>
</select>

<div id="aircraftFoulingDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksAircraftFouling" maxlength="30" value="" />
</div>

</div>
<div class="clear paddingTop15"></div>
<div class="Block">
<label>Type Of Parachute</label>
<select name="type_parachute" id="typeOfParachute" class="" onchange="showTypeOfParachute();">
<option value="n">None</option>
<option value="s">Seat</option>
<option value="b">Back</option>
<option value="c">Chest</option>
<option value="o">Other</option>
<option value="m">Mark</option>
<option value="a">Barostat Control</option>
<option value="t">No Barostat</option>
<option value="l">Static Line</option>
</select>

<div id="typeOfParachuteDiv" style="display: none" >
<label>Remarks</label>

	<input tabindex="1" type="text"	name="remarksTypeParachute" maxlength="30" value="" />

	<input tabindex="1" type="text"	name="remarksTypeOfParachute" maxlength="30" value="" />

</div>
</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label>Parachute 'D' Ring</label>
<select name="parachute" id="parachute" class="">
<option value="p">Pulled</option>
<option value="n">Not Pulled</option>
<option value="f">Foreced From Housing</option>
<option value="k">Not Known</option>
</select>

<label>Parachute Canopy</label>
<select name="parachuteCanopy" id="parachuteCanopy" class="small">
<option value="i">In Pack</option>
<option value="a">Opened by Aircarft Fouling</option>
<option value="g">Opened By Ground  Impact</option>
<option value="s">Released By Subject</option>
<option value="d">Partial Deployment</option>
<option value="f">Fully Developed</option>
<option value="k">Not Known</option>
</select>

<div class="clear"></div>

<label class="auto">Altitude at Parachute Deployment</label>
<input tabindex="1" type="text"	name="parachute_deployment" class="auto" size="18" maxlength="1" value="" />

<label class="unit">ft</label>

<input class="transparent" size="19" />

<select name="altitude" id="altitude" class="small">
<option value="u">Undamaged</option>
<option value="d">Damaged During Descent</option>
<option value="g">Damaged On Ground</option>
<option value="k">Not Known</option>
</select>


<div class="clear"></div>

<label>Parachute Harness</label>

<select name="parachute_harness" id="parachuteHarness" class="">
<option value="g">Effective to Ground Level</option>
<option value="f">Failed ,During Descent</option>
<option value="k">Not Known</option>
<option value="b">Release Box</option>
<option value="u">Type Of Modification-Undamaged</option>
<option value="d">Type Of Modification-Damaged</option>
<option value="s">Unfastened by Subject</option>
<option value="i">Difficulty</option>
<option value="r">Unfastened by Rescuers</option>
<option value="h">Description of harness and release box at rescue</option>
</select>

</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">Terrain For Landing</label>

<select name="terrain_landing" id="terrainForLanding" class="">
<option value="b">Built Up</option>
<option value="w">Wooded</option>
<option value="s">Scrub</option>
<option value="e">Sea</option>
<option value="f">Fresh Water</option>
<option value="g">Open Ground</option>
</select>

<div class="clear"></div>

<label class="large">Depth of Crater made by Subject</label>
<input tabindex="1" type="text"	name="depth_crater_subject" maxlength="30" value="" />
</div>

<div class="clear paddingTop15"></div>
<h4>Condition For Landing</h4>
<div class="Block">
<label>Wind Speed</label>
<input tabindex="1" type="text"	name="wind_speed" maxlength="30" value="Not Known" />

<label>Vertical Visibility</label>
<input tabindex="1" type="text"	name="verticalVisibility" maxlength="30" value="Not Known" />


<select name="condition_landing" id="conditionForLanding" class="small">
<option value="f">Fine</option>
<option value="r">Rain</option>
<option value="s">Strom</option>
<option value="g">Fog</option>
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

<select name="effectiveness_landing" id="effectivenessOfLanding" class="" onchange="showEffectivenessOfLanding();">
<option value="c">Conscious</option>
<option value="u">Unconscious</option>
<option value="k">Not Known</option>
<option value="l">Landing As Planned</option>
<option value="d">Difficulty In Landing</option>

</select>

<div id="effectivenessOfLandingDiv" style="display: none" >
<label>Remarks</label>

	<input tabindex="1" type="text"	name="remarksEffectivLanding" maxlength="30" value="" />

	<%--<input tabindex="1" type="text"	name="remarksEffectivenessOfLanding" maxlength="50" value="" /> --%>

</div>

<div class="clear"></div>

<label class="large">Part of body sustaining initial impact</label>

<input tabindex="1" type="text"	name="partBodySustainInitial" maxlength="50" />

<%--<input tabindex="1" type="text"	name="partOfBodySustainingInitialImpact" maxlength="50" /> --%>




<select name="effectiveness" id="effectiveness" class="small" onchange="showEffectiveness();">
<option value="n">No Darg</option>
<option value="d">Dargged</option>
<option value="k">Darg Unknown</option>
</select>

<div id="effectivenessDiv" style="display: none" >
	<input tabindex="1" type="text"	name="remarksEffectiveness" maxlength="50" value="" />
<label class="unit">yds</label>
</div>

</div>

<div class="clear paddingTop15"></div>
<h4>Degree Of Success</h4>
<div class="Block">

<label class="large">Casualty Fully Mobile : Contacted assistance after</label>

<input tabindex="1" type="text"	name="casualty_contacted" maxlength="50" value="" />

<%--<input tabindex="1" type="text"	name="contacted" maxlength="50" value="" /> --%>

<label class="unit">min/hrs</label>

<div class="clear"></div>
<label class="large">Casualty incapacitated : Reached after</label>

<input tabindex="1" type="text"	name="casualty_incapacitated" maxlength="50" value="" />

<%--<input tabindex="1" type="text"	name="reached" maxlength="50" value="" />--%>

<label class="unit">min/hrs</label>


<div class="clear"></div>
<label class="large">Rescued By</label>

<input tabindex="1" type="text"	name="rescued_by" maxlength="30" value="" />

<%--<input tabindex="1" type="text"	name="rescuedBy" maxlength="30" value="" />--%>


<div class="clear"></div>
<label class="large">Time From Escape To Medical Treatment</label>

<input tabindex="1" type="text"	name="time_scapem_med_treatment" maxlength="6" value="" />

<%--<input tabindex="1" type="text"	name="timeFromEscapeToMedicalTreatment" maxlength="6" value="" />--%>

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

			<input tabindex="1" type="text"	name="damage_fly_helmet_mark" maxlength="10" value=""/>

			

				
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

			<input tabindex="1" type="text"	name="HELMET_Vizor_Mark" maxlength="10" value=""/>

			

				
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
			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>
			
			
			
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

			<input tabindex="1" type="text"	name="damage_oxygen_mark" maxlength="10" value=""/>

			
				

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

<label class="large">Describe the injuries received, with the evidence for their causation as a result of</label>

<input tabindex="1" type="text"	name="InjuryReceiveEvidence" maxlength="50" value="" class="large"/>



<div class="clear"></div>

<label class="large">Damage to Aircraft While in Cocpit or Cabin</label>

<input tabindex="1" type="text"	name="damage_aircraft_in_cocpit" maxlength="50" value="" class="large"/>



<div class="clear"></div>


<label class="large">Aircraft Fouling</label>

<input tabindex="1" type="text"	name="aircraft_fouling" maxlength="30" value="" class="large"/>



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

<label class="large">Parachute Fouling in Sea</label>

<input tabindex="1" type="text"	name="parachute_fouling_sea" maxlength="50" value="" class="large"/>



<div class="clear"></div>

<label class="large">Other Casuses</label>

<input tabindex="1" type="text"	name="other_causes" maxlength="50" value="" class="large"/>




</div>


<div class="clear paddingTop15"></div>
<h4>Previous Experience Describe Any Specific Parachute Training</h4>
<div class="Block">
<label class="large">Previous Escape(give date and degree of success)</label>

<input	tabindex="1" name="pre_escape" class="date"	validate="Previous Escape Date,date,no" maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',unassistedEscapeAircraft.<%=DATE_TWO%>,event);" />
<input tabindex="1" type="text"	name="pre_escape_degree" maxlength="50" value="" />





<div class="clear"></div>

<label class="large">Forced Landing or Ditching</label>

<input tabindex="1" type="text"	name="forced_landing_ditching" maxlength="50" value="" class="large"/>



<label class="large">Unassisted Escape</label>

<input tabindex="1" type="text"	name="unassisted_escape" maxlength="50" value="" class="large"/>




<label class="large">Ejection Seat Escape</label>
<input tabindex="1" type="text"	name="" maxlength="50" value="" class="large"/>

</div>



<input tabindex="1"  type=button value="Submit" class=button  accessKey=r  
onclick="submitForm('unassistedEscapeAircraft','/hms/hms/aviationMedicine?method=submitUnassistedEscape&flag=unassisted');"/>
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


function showEvidenceOfEscapeinFlight()
{
	if(document.getElementById('evidenceOfEscapeinFlight').value == 'o'){
	  	document.getElementById("evidenceOfEscapeinFlightDiv").style.display='inline';
	}else{
		document.getElementById("evidenceOfEscapeinFlightDiv").style.display='none';
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
function showCanopyAndOrJettison()
{
	if(document.getElementById('canopyAndOrJettison').value == 'd'){
	  	document.getElementById("canopyAndOrJettisonDiv").style.display='inline';
	}else{
		document.getElementById("canopyAndOrJettisonDiv").style.display='none';
	}

	
}
function showAircraftFouling()
{
	if(document.getElementById('aircraftFouling').value == 'o'){
	  	document.getElementById("aircraftFoulingDiv").style.display='inline';
	}else{
		document.getElementById("aircraftFoulingDiv").style.display='none';
	}

	
}

function showTypeOfParachute()
{
	if(document.getElementById('typeOfParachute').value == 'o'){
	  	document.getElementById("typeOfParachuteDiv").style.display='inline';
	}else{
		document.getElementById("typeOfParachuteDiv").style.display='none';
	}
}
function showEffectivenessOfLanding()
{
	if(document.getElementById('effectivenessOfLanding').value == 'd'){
	  	document.getElementById("effectivenessOfLandingDiv").style.display='inline';
	}else{
		document.getElementById("effectivenessOfLandingDiv").style.display='none';
	}

}

function showEffectiveness()
{
	if(document.getElementById('effectiveness').value == 'd'){
	  	document.getElementById("effectivenessDiv").style.display='inline';
	}else{
		document.getElementById("effectivenessDiv").style.display='none';
	}
}

function showAccelerationsAtTimeOfEscape(){
	if(document.getElementById('accele_time_escape').value == 'p'){
	  	document.getElementById("accelerationsAtTimeOfEscapePositiveGDiv").style.display='inline';
	}else{
		document.getElementById("accelerationsAtTimeOfEscapePositiveGDiv").style.display='none';
	}

	if(document.getElementById('accele_time_escape').value == 'n'){
	  	document.getElementById("accelerationsAtTimeOfEscapeNegativeGDiv").style.display='inline';
	}else{
		document.getElementById("accelerationsAtTimeOfEscapeNegativeGDiv").style.display='none';
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
</script>

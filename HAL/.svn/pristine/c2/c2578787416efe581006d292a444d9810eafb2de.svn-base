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
<div class="titleBg">	<h2>Aircraft Accident Investigation</h2> </div>

<div class="clear"></div>
<form name="aircraftAccidentInvestigation" action="" method="post">

<ul id="countrytabs" class="shadetabs">
<li><a href="#" rel="country1">ACCIDENT</a></li>
<li><a href="#" rel="country2">EQUIPMENT IN USE</a></li>
<li><a href="#" rel="country3">MEDICAL HISTORY</a></li>
<li><a href="#" rel="country4">PHYSIOLOGICAL AND PSYCHOLOGICAL FACTORS</a></li>
<li><a href="#" rel="country5">EXTERNAL MEDICAL EXAMINATION</a></li>
<li><a href="#" rel="country6">POST MORTEM</a></li>
<li><a href="#" rel="country7">AN UNASSISTED ESCAPE FROM AN AIRCRAFT IN FLIGHT</a></li>
<li><a href="#" rel="country8">USE OF EJECTION SEAT</a></li>
</ul>

<div id="country1" class="tabcontentIn">

<div class="clear paddingTop15"></div>
<h4>Details of Accident</h4>
<div class="clear"></div>
<div class="Block">


<label> Date</label>
<input	tabindex="1" name="<%=DATE %>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.<%=DATE%>,event);" />


<label>Time  </label> 
<input type="text" value="" readonly="readonly" name="<%=TIME%>"	tabindex="2" maxlength="20"/>


<label>Place  </label> 
<input	type="text" value="" readonly="readonly" name="<%=PLACE%>"	tabindex="2" maxlength="20"/>
 
 
 <div class="clear"></div>

<label>Type of Accident  </label> 
<input	type="text" value="" readonly="readonly" name="typeOfAccident"	tabindex="2" maxlength="20"/>

<label>Mark  </label> 

<input	type="text" readonly="readonly" maxlength="20"  value="" name="mark"	tabindex="2" />


<label>Serial Number</label> 
<input	type="text" readonly="readonly" value="" name="<%=SERIAL_NO %>"	tabindex="2" maxlength="20" />


<div class="clear"></div>
<label>Unit</label> 
<select name="<%=UNIT_ID %>"  id="<%=UNIT_ID %>">
<option value="0">Select</option>
	<%

		for(MasUnit masUnit : unitList){
	
	%>
	
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%		
		}%>
</select>


<label>Purpose of Flight  </label> 
<input	type="text" readonly="readonly" value="" name="purposeOfFlight"	tabindex="2" maxlength="20" />


</div>

<div class="clear"></div>

<div class="clear paddingTop15"></div>
<h4> Crew and Passengers<a href="javascript:animatedcollapse.toggle('slide4')"></a></h4>
<div class="clear"></div>
<div id="slide4">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridCrewAndPassengers">
	<tr>
		<TH scope="col">Sr No.</TH>
		<TH scope="col">Rank</TH>
		<TH scope="col">Name</TH>
		<TH scope="col">Crew Station or Passenger Seating</TH>
		<TH scope="col">Result</TH>
		<TH scope="col">Encl used (ring)</TH>
		<th scope="col">Add</th>
        <th scope="col">Delete</th>
	</tr>
	<tr>
		<td>
			<input tabindex="1" type="text"	name="<%=SR_NO %>" maxlength="10" value="" class="small"/>	
		</td>
		
		
		
		<td>
		<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){
	
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}
	}%>
</select>
		
		</td>
			<td>
			<input tabindex="1" type="text"	name="name" maxlength="10" value=""/>	
		</td>
		<td>
			<input tabindex="1" type="text"	name="crewStationPassengerSeating" maxlength="10" value=""/>	
		</td>
		<td>
			<select name="<%=RESULT %>">
				<option value="Uninj">Uninj</option>
				<option value="Inj">Inj</option>
				<option value="Died">Died</option>
				<option value="Miss">Miss</option>
				
			</select>
		</td>
		<td>
			<select name="enclUsedRing">
				<option value="A">A</option>
				<option value="B">B</option>
				<option value="C">C</option>
				<option value="D">D</option>
				<option value="E">E</option>
				<option value="F">F</option>
			</select>
		</td>
		<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForCrewAndPassengers();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForCrewAndPassengers('gridCrewAndPassengers','hiddenValue',this);" /></td>
	</tr>
</table>
<input type="hidden" id="crewAndPassengersDataStatus" name="crewAndPassengersDataStatus" value="no"/>
</div>
</div>



<div class="clear paddingTop15"></div>
<h4> Total Enclosurses <a href="javascript:animatedcollapse.toggle('slide2')"></a></h4>
<div class="clear"></div>
<div id="slide2">
<div class="smallCmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridEnclosurses">
	<tr>
		<TH scope="col">Sr No.</TH>
		<TH scope="col">Enclosurses Details</TH>
		<th scope="col">Add</th>
        <th scope="col">Delete</th>
	</tr>
	<tr>
		<td>
			<input tabindex="1" type="text"	name="<%=SR_NO %>" maxlength="10" value="" class="small"/>	
		</td>
		 <td>
			<input tabindex="1" type="text"	name="enclosursesDetails" maxlength="10" value=""/>	
		</td>
		<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForEnclosurses();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForEnclosurses('gridEnclosurses','hiddenValue',this);" /></td>
	</tr>
</table>
<input type="hidden" id="enclosursesDataStatus" name="enclosursesDataStatus" value="no"/>
</div>
</div>





<div class="clear paddingTop15"></div>
<h4> No. of Photographs <a href="javascript:animatedcollapse.toggle('slide6')"></a></h4>
<div class="clear"></div>
<div id="slide6">
<div class="Block">

<label>Accident</label>
<input tabindex="1" type="text"	name="accident" maxlength="10" value=""/>	

<label>Casualties</label>
<input tabindex="1" type="text"	name="casualties" maxlength="10" value=""/>	


</div>
</div>

<div class="clear paddingTop15"></div>
<div class="Block">

<label> Other Enclosurses</label>
<input tabindex="1" type="text"	name="otherEnclosurses" maxlength="10" value="" class="large"/>	

</div>



<div class="clear paddingTop15"></div>
<div class="Block">

<label>Escape in Flight</label>

		<select name="escapeInFlight">
				<option value="allEscapeInFlight">All Escape In Flight</option>
				<option value="someEscapeInFlight">Some Escape In Flight</option>
				<option value="allPersonnelInAircraftOnImpact">All Personnel In Aircraft On Impact</option>
				
			</select>
</div>


<div class="clear paddingTop15"></div>
<div class="Block">	
			
<label>Circumstances of Accident</label>
<select name="circumstancesOfAccident">
				<option value="Taxying">Taxying</option>
				<option value="Take Off">Take Off</option>
				<option value="Catapult take-off">Catapult take-off</option>
				<option value="Landing normal">Landing normal</option>
				<option value="Emergency">Emergency</option>
				<option value="Ditching">Ditching</option>
				<option value="ArrestedLandingOnCarrierCrashBarrier">Arrested Landing On (Carrier/Crash Barrier)</option>
				<option value="U-carriage up">U-carriage up</option>
				<option value="Down">Down</option>
				<option value="Partially">Partially</option>
			</select>
				<select name="circumstancesOfAccidentOne">
				<option value="FlewIntoGround">Flew into Ground</option>
				<option value="sea">Sea</option>
				<option value="Obstruction">Obstruction</option>
				
			</select>
			<label>Enemy Action</label>
			<input tabindex="1" type="checkbox"	name="enemyAction" maxlength="10" value="c"/>	
			
			<div class="clear"></div>
			
			<h3>Emergency in Flight</h3>
			<label>MajorStructuralFailure</label>
			<select name="majorStructuralFailure">
				<option value="Collision">Collision</option>
				<option value="Fire">Fire</option>
				<option value="Lack of fuel">Lack of Fuel</option>
			</select>
			
			<label>Loss of Control</label>
			<select name="lossOfControl">
				<option value="In Manoenvrel">In Manoenvrel</option>
				<option value="Level Flight">Level Flight</option>
				<option value="Explained">Explained</option>
					<option value="Unexplained">Unexplained</option>
			</select>
			
		
			<div class="clear"></div>
			<label>Loss of Power</label>
			<select name="lossOfPower">
				<option value="Actual">Actual</option>
				<option value="Practice Symmetrical">Practice Symmetrical</option>
				<option value="Asymmetrical">Asymmetrical</option>
			</select>
			
			<label>Loss of Service</label>
			<select name="lossOfService">
				<option value="Actual">Actual</option>
				<option value="Practice Mannual Control">Practice Mannual Control</option>
				<option value="Power Control">Power Control</option>
			</select>
			<div class="clear"></div>
				<label>Instruments</label>
				<label> Radio</label>
			<input tabindex="1" type="radio"	name="instruments" maxlength="10" value="r"/>	
				<label>Others(Specify)</label>
			<input tabindex="1" type="radio"	name="instruments" maxlength="10" value="o"/>	
			
				<div class="clear"></div>
				
			<label>Other Circumstances (Specify)</label>
			<input tabindex="1" type="text"	name="otherCircumstancesSpecify" maxlength="10" value="" class="large"/>	
						
</div>


<div class="clear paddingTop15"></div>

<div class="clear"></div>
<div class="Block">

<label>Operating Conditions</label>

<select name="operatingConditions">
				<option value="Solo">Solo</option>
				<option value="Dual">Dual</option>
				<option value="Autopilot">Autopilot</option>
				<option value="Unknow">Unknow</option>
	
			</select>
				<select name="operatingConditionsOne">
				<option value="Formation Leader">Formation Leader</option>
				<option value="Fromation Member">Fromation Member</option>
				<option value="Under Control of Leader">Under Control of Leader</option>
				<option value="Independent Flying">Independent Flying</option>
			</select>
<div class="clear"></div>
	<label>If Underground Control,Specify Type</label>
			<input tabindex="1" type="text"	name="undergroundControl" maxlength="10" value="" class="large"/>	
		
</div>


<div class="clear paddingTop15"></div>
<h4>Height</h4>
<div class="Block">

<label> Intendered for Sortie</label>
<input tabindex="1" type="text"	name="intenderedForSortie" maxlength="10" value=""/>	
<label class="unit">ft</label>


<label> At Time of Emergency</label>
<input tabindex="1" type="text"	name="atTimeOfEmergency" maxlength="10" value="" />	
<label class="unit">ft</label>


</div>
</div>


<div id="country2" class="tabcontentIn">
<div class="clear paddingTop15"></div>
<div class="Block">

<label> Surname</label>
<input tabindex="1" type="text"	name="Surname" maxlength="10" value="" />	

<label> First Name</label>
<input tabindex="1" type="text"	name="FirstName" maxlength="10" value="" />
	

<label>Crew Duty (or Passenger Seating)</label>
<input tabindex="1" type="text"	name="crewDuty" maxlength="10" value="" />
<div class="clear"></div>

<label>Rank</label>
<select	id="<%=RANK %>" name="<%=RANK %>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){
	
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}
	}%>
</select>


<label>Number</label>
<input tabindex="1" type="text"	name="number" maxlength="10" value="" />
	
	
</div>

<div class="clear paddingTop15"></div>
<div class="Block">

<label>UNINJURED</label>
<input tabindex="1" type="text"	name="uninjured" maxlength="10" value="" />


<label>INJURED/FATAL</label>
<input tabindex="1" type="text"	name="injured" maxlength="10" value="" />

<label>MISSING</label>
<input tabindex="1" type="text"	name="missing" maxlength="10" value="" />





</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">POSITION OF CASUALTY AT TIME OF GROUND IMPACT OF AIRCRAFT</label>
	<select  name="positionOfCasualty"  id="positionOfCasualty" onchange="showPositionOfCasualty();">
		<option value="In normal Seat">In normal Seat</option>
		<option value="In Fuselage Out of Position">In Fuselage Out of Position</option>
		<option value="Using Escape apparatus">Using Escape apparatus</option>
		<option value="Thrown form Aircraft in air">Thrown form Aircraft in air</option>
			<option value="Not Known">Not Known</option>
				<option value="Other">Other</option>
	</select>

<div id="positionOfCasualtyDiv" style="display: none" >

<label>If Other</label>
<input tabindex="1" type="text"	name="otherTxt" maxlength="10" value="" />

</div>
</div>



<div class="clear paddingTop15"></div>
<div class="Block">
	<label class="large">DISPLACEMENT OF CASUALTY</label>
		<select  name="displacementOfCasualty"  id="displacementOfCasualty" onchange="showDisplacementOfCasualty();">
			<option value="Retained in Aircraft">In normal Seat</option>
			<option value="Thrown Clear on Impact">In Fuselage Out of Position</option>
			<option value="Spontaneous seat Ejection on Impact">Using Escape apparatus</option>
			<option value="Not Known">Not Known</option>
			<option value="Other">Other</option>
		</select>
	
	<div id="displacementOfCasualtyDiv" style="display: none" >

	<label>If Other</label>
	<input tabindex="1" type="text"	name="otherTxt" maxlength="10" value="" />

	</div>
</div>



<div class="clear paddingTop15"></div>
<h4>SEAT</h4>
<div class="Block">
	<label> Facing</label>
		<select  name="facing"  id="facing" >
			<option value="Forward">Forward</option>
			<option value="Sideway">Sideway</option>
			<option value="Backward">Backward</option>
			<option value="Stretcher">Stretcher</option>
			<option value="Not Known">Not Known</option>
		</select>
		
		<label> Condition</label>
		<select  name="condition"  id="condition">
			<option value="Undamaged">Undamaged</option>
			<option value="Distorted">Distorted</option>
			<option value="Torn Free">Torn Free</option>
			<option value="Destoryed">Destoryed</option>
			<option value="Spontaneous Ejection">Spontaneous Ejection</option>
			<option value="Not Known">Not Known</option>
		</select>
</div>

<div class="clear paddingTop15"></div>
<h4>HEARNESS</h4>
<div class="Block">
	<label> Type</label>
		<select  name="type"  id="type" onchange="showType();" >
			<option value="Lap Shoulder">Lap Shoulder</option>
			<option value="Combind Parachute">Combind Parachute</option>
			<option value="Other">Other</option>
			
		</select>
			<div id="typeDiv" style="display: none" >

	<label>If Other</label>
	<input tabindex="1" type="text"	name="otherTxt" maxlength="10" value="" class="large"/>

	</div>
	
	<div class="clear"></div>
		<label> Adjustments</label>
		<select  name="adjustments"  id="adjustments">
			<option value="Tight">Undamaged</option>
			<option value="Distorted">Tight</option>
			<option value="Losse">Losse</option>
			<option value="Unfastened">Unfastened</option>
			<option value="Not Known">Not Known</option>
		</select>
		
		
		<label> Release Box</label>
		<select  name="releaseBox"  id="releaseBox">
			<option value="Locked">Locked</option>
			<option value="Open">Open</option>
			<option value="Automatic Separation">Automatic Separation</option>
			<option value="Not Known">Not Known</option>
		</select>
		<div class="clear"></div>
		
			<label> Effectiveness</label>
		<select  name="effectiveness"  id="effectiveness">
			<option value="Effective">Effective</option>
			<option value="Not Effective">Not Effective</option>
			<option value="Not Known">Not Known</option>
		</select>
		
			<label> Cause of Failure</label>
		<select  name="causeOfFailure"  id="causeOfFailure">
			<option value="Not Applicable">Not Applicable</option>
			<option value="Webbing Failure">Webbing Failure</option>
			<option value="Adjustment Slip">Adjustment Slip</option>
			<option value="Attachment Failure">Attachment Failure</option>
			<option value="Destroyed in Fire">Destroyed in Fire</option>
			<option value="Not Known">Not Known</option>
		</select>
</div>

<div class="clear paddingTop15"></div>
<h4>ESCAPE APPARATUS</h4>
<div class="Block">


		<label>Type</label>
		<select  name="typeEscape"  id="typeEscape">
			<option value="No Parachute">No Parachute</option>
			<option value="Parachut Without Ejection Seat">Parachut Without Ejection Seat</option>
		</select>
		
		<label>Stowing</label>
		<select  name="stowing"  id="stowing">
			<option value="Normally Attached to Man">Normally Attached to Man</option>
			<option value="Normally Stowed in AirCraft">Normally Stowed in AirCraft</option>
			<option value="Ejection Seat">Ejection Seat</option>
		</select>
		
		<label>Use</label>
		<select  name="use"  id="use">
			<option value="Unknown">Unknown</option>
			<option value="Not Used">Not Used</option>
			<option value="Apparatus Used Intertionally/Unintertionally">Apparatus Used Intertionally/Unintertionally</option>
		</select>
		
		
</div>


<div class="clear paddingTop15"></div>
<h4>OXYGEN</h4>
<div class="Block">

<h3>Mask</h3>
<label>Mark</label>
<input type="text" name="mask"  tabindex="1" maxlength="45" />

<label>Size</label>
<input type="text" name="size"  tabindex="1" maxlength="45" />

<div class="clear"></div>

<h3>Regulater</h3>
<label>Mark</label>
<input type="text" name="regulater"  tabindex="1" maxlength="45" />

<label>Setting</label>
<input type="text" name="setting"tabindex="1" maxlength="45" />


<label class="auto">Not Proived</label>
<input type="checkbox" name="notProived" tabindex="1" maxlength="45" />


<div class="clear"></div>


<label class="large">Emergency /Portable Equipment</label>
	<input tabindex="1" type="text"	name="emergencyPortableEquipment" maxlength="10" value="" class="large"/>

</div>


<div class="clear paddingTop15"></div>
<div class="Block">
<label>Outer Clothing</label>

<select  name="outerClothing"  id="outerClothing" onchange="showOuterClothing();">
			<option value="Undamaged">Undamaged</option>
			<option value="Removed on impact">Removed on Impact</option>
			<option value="Not available for inspection">Not available for inspection</option>
			<option value="Damaged">Damaged</option>
		</select>
					<div id="outerClothingDiv" style="display: none" >

	<label>If Damaged</label>
	<input tabindex="1" type="text"	name="damagedTxt" maxlength="10" value="" class="large"/>

	</div>
		
</div>



<div class="clear paddingTop15"></div>
<h4>PROTECTIVE HELMET</h4>
<div class="Block">
<label>Mark</label>
<input tabindex="1" type="text"	name="protectiveHelmetMark" value="" >


<label>At the time of Escape/Impact</label>
<select  name="escapeImpact"  id="escapeImpact" >
			<option value="WronPossibly Stowed in Aircraft">Wron/Possibly Stowed in Aircraft</option>
			<option value="Not Wron">Not Wron</option>
			<option value="Not Known">Not Known</option>
			<option value="Off Head When Found">Off Head When Found</option>
			<option value="On Head When Found">On Head When Found</option>
</select>


<label>Chin Step</label>
<select  name="chinStep"  id="chinStep" >
			<option value="Fastened">Fastened</option>
			<option value="Not Fastened">Not Fastened</option>
			<option value="Failed">Failed</option>
			<option value="Not Known">Not Known</option>
			
</select>
<div class="clear"></div>

<label>Inner Helmet</label>
<select  name="innerHelmet"  id="innerHelmet" >
			<option value="Undamaged">Undamaged</option>
			<option value="Slightly Damaged">Slightly Damaged</option>
			<option value="Serverly Damaged">Serverly Damaged</option>
			<option value="Not Known">Not Known</option>
			
</select>

<label>Outer Helmet</label>
<select  name="outerHelmet"  id="outerHelmet" >
			<option value="Undamaged">Undamaged</option>
			<option value="Slightly Damaged">Slightly Damaged</option>
			<option value="Serverly Damaged">Serverly Damaged</option>
			<option value="Not Known">Not Known</option>
			
</select>
<div class="clear"></div>
<label>Vizor Mark</label>
<input tabindex="1" type="text"	name="markVizor" value="" >

<select  name="vizor"  id="vizor" >
			<option value="RaisedLowered">Raised/Lowered</option>
			<option value="Damaged">Damaged</option>
			<option value="Undamaged">Undamaged</option>
			<option value="Destroyed or Lost">Destroyed or Lost</option>
				<option value="Not Known">Not Known</option>
			
</select>
<div class="clear"></div>

<label class="large">Any Comment on the effective of the helmet</label>
<textarea rows="" cols="60"	name="comment" class="auto" onkeyup="chkLength(this,150);"></textarea>

</div>

<div class="clear paddingTop15"></div>
<h4>PRESSURE CLOTHING</h4>
<div class="Block">
<label>Partial Pressuresuit</label>
<select  name="partialPressuresuit"  id="partialPressuresuit" >
			<option value="Not Worn">Not Worn</option>
			<option value="Worn">Worn</option>
</select>
<label>Mark</label>
<input tabindex="1" type="text"	name="markPartialPressuresuit" value="" >

<div class="clear"></div>

<label>Jerkin</label>
<select  name="jerkin"  id="jerkin" >
			<option value="Not Worn">Not Worn</option>
			<option value="Worn">Worn</option>
</select>
<label>Mark</label>
<input tabindex="1" type="text"	name="markJerkin" value="" >


<div class="clear"></div>

<label>Full Pressure Suit</label>
<select  name="fullPressureSuit"  id="fullPressureSuit" >
			<option value="Not Worn">Not Worn</option>
			<option value="Worn">Worn</option>
</select>
<label>Mark</label>
<input tabindex="1" type="text"	name="markFullPressureSuit" value="" >



<div class="clear"></div>

<label>Anti G. Suit</label>
<select  name="antiGSuit"  id="anti GSuit" >
			<option value="Not Worn">Not Worn</option>
			<option value="Worn">Worn</option>
</select>
<label>Mark</label>
<input tabindex="1" type="text"	name="markAntiGSuit" value="" >

<div class="clear"></div>

<label class="large">Specify and Function of these items Relevent to the Accident</label>
<textarea rows="" cols="60"	name="function" class="auto" onkeyup="chkLength(this,150);"></textarea>


</div>






<div class="clear paddingTop15"></div>
<h4>OTHER EQUIPMENT</h4>
<div class="Block">
<label>Air Ventilated Suit</label>
<select  name="airVentilatedSuit"  id="airVentilatedSuit" >
			<option value="Not Worn">Not Worn</option>
			<option value="Worn">Worn</option>
</select>
<label>Mark</label>
<input tabindex="1" type="text"	name="markAirVentilatedSuit" value="" >

<div class="clear"></div>

<label>Life Jacket</label>
<select  name="lifeJacket"  id="lifeJacket" >
			<option value="Not Worn">Not Worn</option>
			<option value="Worn">Worn</option>
</select>
<label>Mark</label>
<input tabindex="1" type="text"	name="markLifeJacket" value="" >


<div class="clear"></div>

<label>Dinghy</label>
<select  name="dinghy"  id="dinghy" >
			<option value="Not Carried">Not Carried</option>
			<option value="Carried">Carried</option>
</select>
<label>Mark</label>
<input tabindex="1" type="text"	name="markDinghy" value="" >



<div class="clear"></div>

<label>Survival Packs</label>
<select  name="survivalPacks"  id="survivalPacks" >
			<option value="Not Carried">Not Carried</option>
			<option value="Carried">Carried</option>
</select>
<label>Type</label>
<input tabindex="1" type="text"	name="typeSurvivalPacks" value="" >

</div>

</div>

<div id="country3" class="tabcontentIn">
<div class="clear paddingTop15"></div>
<div class="Block">



<label>Age <span>*</span></label>
<select id="srAgeId"	name="<%=SR_AGE%>" validate="Age of Service Person,string,yes"	tabindex="1" class="small"	onchange="fillPatientName(this);">
	<option value="">Select</option>
	<%
				for(int age1 = 16;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 
<input type="text" class="readOnlySmall"  id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly"/>
<label>Height</label>
<input	class="auto" tabindex="1" type="text"  name="<%=HEIGHT %>"	tabindex="2" maxlength="20" size="10"/>
<label class="unit">cm</label>
<input class="transparent" size="3">

<label>Weight</label>
<input	class="auto" tabindex="1" type="text"  name="<%=WEIGHT %>"	tabindex="2" maxlength="20" size="10"/>
<label class="unit">Kg</label>


<div class="clear"></div>

<label>Marital Status</label> 
<select name="srMaritalStatus" id="srmrstatus"	validate="Marital Status of service Person,metachar,no" tabindex="1">
<option value="SINGLE">SINGLE</option>
<option value="MARRIED">MARRIED</option>
</select> 


<label>Medical Category </label> 
<select name="medicalCategory" id="medicalCategory"	 tabindex="1">
<option value=""></option>

</select> 


<label> Date</label>
<input	tabindex="1" name="<%=DATE_OF_MB %>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.<%=DATE_OF_MB%>,event);" />


<div class="clear"></div>



<label>Reason</label>
<input	class="large" tabindex="1" type="text"  name="reason"	tabindex="2" maxlength="20" />

<div class="clear"></div>

<label>Medication (Within 4 Weeks Previous To Flight </label> 
<select name="medicalCategory" id="medicalCategory"	 tabindex="1">
<option value="Nil">Nil</option>
<option value="Treatment Given">Treatment Given</option>
<option value="Self Medication">Self Medication</option>
</select> 


<div class="clear"></div>
<label>Body Build</label>
<select  name="bodyBuild"  id="bodyBuild" >
			<option value="Normal">Normal</option>
			<option value="Above Average Physique">Above Average Physique</option>
			<option value="Thin">Thin</option>
			<option value="Obese">Obese</option>
</select>

<div class="clear"></div>

<label>Alcohol</label>
<select  name="alcohol"  id="alcohol" >
			<option value="Does not drink">Does not drink</option>
			<option value="Drinks Occasionally">Drinks Occasionally</option>
			<option value="Drinks Regularly">Drinks Regularly</option>
			<option value="Drinks Wisely">Drinks Wisely</option>
			<option value="Drinks Unwisely">Drinks Unwisely</option>
</select>
<label>Tobacco</label>
<select  name="tobacco"  id="tobacco" >
			<option value="Non Smoker">Non Smoker</option>
			<option value="Smoker">Smoker</option>
			<option value="Cigarettes">Cigarettes</option>
			<option value="Pipes">Pipes</option>
</select>
<input	class="auto" tabindex="1" type="text"  name="tobaccoTxt"	tabindex="2" maxlength="20" size="10"/>
<label class="auto">per day</label>
</div>
</div>
<div id="country4" class="tabcontentIn">
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
</div>


<div id="country5" class="tabcontentIn">
<div class="clear paddingTop15"></div>
<div class="Block">


<label> Surname</label>
<input tabindex="1" type="text"	name="Surname" maxlength="10" value="" />	

<label> First Name</label>
<input tabindex="1" type="text"	name="FirstName" maxlength="10" value="" />
	

<label>Crew Duty (or Passenger Seating)</label>
<input tabindex="1" type="text"	name="crewDuty" maxlength="10" value="" />
<div class="clear"></div>

<label>Rank</label>
<select	id="<%=RANK %>" name="<%=RANK %>"	validate="rank,metacha,no" tabindex="1">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){
	
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}
	}%>
</select>


<label>Number</label>
<input tabindex="1" type="text"	name="number" maxlength="10" value="" />
	
	
</div>


<div class="clear paddingTop15"></div>
<div class="Block">

<label>Burns</label>
<select name="burns" id="burns">
<option value="Nil">Nil</option>
<option value="Slight">Slight</option>
<option value="Severe">Severe</option>
<option value="Incineration">Incineration</option>
<option value="Ante Mortem">Ante Mortem</option>
<option value="Post Mortem">Post Mortem</option>
<option value="Both Periods">Both Periods</option>
<option value="Period Not Known">Period Not Known</option>

</select>


<label>Haemorrhage</label>
<select name="haemorrhage" id="haemorrhage">
<option value="Nil">Nil</option>
<option value="Negligible">Negligible</option>
<option value="Moderate">Moderate</option>
<option value="Severe">Severe</option>
<option value="Not Applicable">Not Applicable</option>
</select>


<label>Shock</label>
<select name="shock" id="shock">
<option value="Nil">Nil</option>
<option value="Mild">Mild</option>
<option value="Moderate">Moderate</option>
<option value="Severe">Severe</option>
<option value="Not Applicable">Not Applicable</option>
</select>


<div class="clear"></div>

<label>Concussion</label>
<select name="concussion" id="concussion">
<option value="Nil">Nil</option>
<option value="Mild">Mild</option>
<option value="Moderate">Moderate</option>
<option value="Severe">Severe</option>
<option value="Not Applicable">Not Applicable</option>
</select>

<label>Duration of Lost Concussion</label>
<input tabindex="1" type="text"	name="lostConcussion" maxlength="10" value="" />
	
	
	
<label>Duration of Retrograde Amnesia</label>
<input tabindex="1" type="text"	name="retrogradeAmnesia" maxlength="10" value="" />
	
</div>


<div class="clear paddingTop15"></div>
<h4>TABLE OF INJURIES</h4>
<div class="Block">


</div>
<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">Medical Officers' Assessment of Cause  of Injuries</label>
<textarea rows="" cols="60"	name="assessment" class="auto" onkeyup="chkLength(this,150);"></textarea>

<div class="clear"></div>
<label>Disposal Of Casualty</label>
<select name="casualty" id="casualty">
<option value="No Treatment">No Treatment</option>
<option value="Ambulant Treatment">Ambulant Treatment</option>
</select>

<label>Admitted SSQ/Sick bay</label>
<input tabindex="1" type="text"	name="admitted" maxlength="10" value="" />




<label>Admitted Hospital</label>
<input tabindex="1" type="text"	name="admittedHospital" maxlength="10" value="" />

<div class="clear"></div>

<label>Dead When First Seen</label>
<input tabindex="1" type="text"	name="deadWhenFirstSeen" maxlength="10" value="" />




<label>Cause Of Death</label>
<textarea rows="" cols="60"	name="causeOfDeath" class="auto" onkeyup="chkLength(this,150);"></textarea>

</div>
</div>



<div id="country6" class="tabcontentIn">
<div class="clear paddingTop15"></div>
<div class="Block">



<label> Surname</label>
<input tabindex="1" type="text"	name="Surname" maxlength="10" value="" />	

<label> First Name</label>
<input tabindex="1" type="text"	name="FirstName" maxlength="10" value="" />
	

<label>Crew Duty (or Passenger Seating)</label>
<input tabindex="1" type="text"	name="crewDuty" maxlength="10" value="" />
<div class="clear"></div>

<label>Rank</label>
<select	id="<%=RANK %>" name="<%=RANK %>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){
	
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}
	}%>
</select>


<label>Number</label>
<input tabindex="1" type="text"	name="number" maxlength="10" value="" />
	
	
</div>


<div class="clear paddingTop15"></div>
<div class="Block">
<label>Date Of Death</label>
<input	tabindex="1" name="<%=DATE_OF_DEATH%>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.<%=DATE_OF_DEATH%>,event);" />

<label>Time Of Death</label>
<input tabindex="1" type="text"	name="timeOfDeath" maxlength="10" value="" />

<div class="clear"></div>

<label>Date Of Autopsy</label>
<input	tabindex="1" name="dateOfAutopsy" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.dateOfAutopsy,event);" />

<label>Time Of Autopsy</label>
<input tabindex="1" type="text"	name="timeOfAutopsy" maxlength="10" value="" />


<div class="clear"></div>

<label>Casualty Survived</label>
<input tabindex="1" type="text"	name="casualtySurvived" maxlength="10" value="" />
<label>mins/hrs/days/following injury or accident</label>


<label>Condition Of body at Autopsy</label>

<select name="conditionOfBodyAtAutopsy" id="conditionOfBodyAtAutopsy">
<option value="Presrved">Presrved</option>
<option value="Dismembered 1 limib">Dismembered 1 limib</option>
<option value="Dismembered 2 limib">Dismembered 2 limib</option>
<option value="Decapited">Decapited</option>
<option value="Disintegrated">Disintegrated</option>
<option value="Incinrated">Incinrated</option>
</select>

<select name="conditionOfBody" id="conditionOfBody">
<option value="Good Condition">Good Condition</option>
<option value="Early Post Mortem Changes">Early Post Mortem Changes</option>
<option value="Advanced Post Mortem Changes">Advanced Post Mortem Changes</option>
<option value="Putrefaction">Putrefaction</option>

</select>


<div class="clear"></div>

<label>Condition in Which Body was FOund</label>

<select name="conditionOfBodywasFound" id="conditionOfBodywasFound">
<option value="Clothed">Clothed</option>
<option value="Partially Clothed">Partially Clothed</option>
<option value="Unclothed">Unclothed</option>
<option value="Not Known">Not Known</option>
</select>

<select name="conditionOfBodywas" id="conditionOfBodywas" onchange="showConditionOfBodywas();">
<option value="Cold">Cold</option>
<option value="Moderate Temperature">Moderate Temperature</option>
<option value="Hot">Hot</option>
<option value="Other">Other</option>
</select>

<div id="conditionOfBodywasDiv" style="display: none" >
<label>Other</label>
	<input tabindex="1" type="text"	name="otherConditionOfBodywas" maxlength="10" value="" />

</div>
</div>

<div class="clear paddingTop15"></div>

<div class="Block">
<label>BRAIN Weight</label>
<select name="weightBrain" id="weightBrain" >
<option value="Normal">Normal</option>
<option value="Any pre-existing lesion">Any pre-existing lesion</option>
<option value="Congestion">Congestion</option>
<option value="Contusion">Contusion</option>
<option value="Haemorrhage">Haemorrhage</option>
<option value="Laceration At">Laceration At</option>
<option value="Aneurysms">Aneurysms</option>
<option value="Anamalous Cerebral Vessels">Anamalous Cerebral Vessels</option>
<option value="Ventricular Cysts">Ventricular Cysts</option>
</select>


<label>Spinal Cord</label>
<select name="spinalCord" id="spinalCord" >
<option value="Normal">Normal</option>
<option value="Not Examined">Not Examined</option>
</select>

<label>Any pre-existing lesion</label>
<input tabindex="1" type="text"	name="AnyPreExistingLesion" maxlength="10" value="" />

<label>Damage Sustained in Accident</label>
<input tabindex="1" type="text"	name="damageSustainedInAccident" maxlength="10" value="" />

<div class="clear"></div>

<label>Middle Ear</label>
<select name="middleEar" id="middleEar" >
<option value="Normal">Normal</option>
<option value="Not Examined">Not Examined</option>
<option value="Unilateral Haemorrhage RT">Unilateral Haemorrhage RT</option>
<option value="Unilateral Haemorrhage LT">Unilateral Haemorrhage LT</option>
<option value="Bilateral Haemorrhage">Unilateral Haemorrhage RT/LT</option>


</select>


<label>Glottis</label>
<select name="glottis" id="glottis" >
<option value="Normal">Normal</option>
<option value="Congestion">Congestion</option>
<option value="Petechiae">Petechiae</option>
<option value="Haemorrhage">Haemorrhage</option>

</select>
<label>Fracture of Cartilage</label>
<input tabindex="1" type="text"	name="FractureOfCartilage" maxlength="10" value="" />
<div class="clear"></div>

<label>Pleural Space</label>
<select name="pleuralSpace" id="pleuralSpace" >
<option value="Normal">Normal</option>
<option value="Any pre-existing lesion RT">Any pre-existing lesion RT</option>
<option value="Any pre-existing lesion LT">Any pre-existing lesion LT</option>
<option value="Pneumothorax Rt">Pneumothorax Rt</option>
<option value="Pneumothorax Lt">Pneumothorax Lt</option>
<option value="Pneumothorax Bilateral">Pneumothorax Bilateral</option>
</select>


<label>Hydrothorax</label>

<input tabindex="1" type="text"	name="hydrothoraxRt" maxlength="10" value="" />
<label class="auto">ccs RT</label>

<input tabindex="1" type="text"	name="hydrothoraxLt" maxlength="10" value="" />
<label class="auto">ccs LT</label>


<label>Petechiae present on pleural surface on lungs</label>
<input tabindex="1" type="text"	name="petechiae" maxlength="10" value="" />


<div class="clear"></div>
<label>Trachea</label>
<select name="trachea" id="trachea" >
<option value="Normal">Normal</option>
<option value="Injured in Accident">Injured in Accident</option>
<option value="Contains vomitus/Blood/other">Contains vomitus</option>
<option value="Blood">Blood</option>
<option value="other">other</option>
<option value="Evidence of ante mortem burning">Evidence of ante mortem burning(Carbon Particles)</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="hydrothoraxRt" maxlength="10" value="" />

</div>

<div class="clear paddingTop15"></div>
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<TH scope="col">Lungs</TH>
		<TH scope="col">Right</TH>
		<TH scope="col">Left</TH>
	</tr>
	<tr>
		<td><label>Result</label>	</td>
		<td>
			<select name="">
				<option value="Normal">Normal</option>
				<option value="Any pre-existing lesion">Any pre-existing lesion</option>
				<option value="Weight Motting with rib marking">Weight Motting with rib marking</option>
				<option value="Weight Motting without rib marking">Weight Motting without rib marking</option>
			</select>
		</td>
		<td>
			<select name="">
				<option value="Normal">Normal</option>
				<option value="Any pre-existing lesion">Any pre-existing lesion</option>
				<option value="Weight Motting with rib marking">Weight Motting with rib marking</option>
				<option value="Weight Motting without rib marking">Weight Motting without rib marking</option>
			</select>
		</td>
		
	</tr>
		<tr>
		<td><label>Oedema/haemorrhagic oedema of </label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree in
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			lobes
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree in
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>	
			lobes
		</td>
	</tr>
		<tr>
		<td><label>Haemorrhage of</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree in
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			lobes
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree in
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>	
			lobes
		</td>
	</tr>
		<tr>
		<td><label>Traumatic emphysema present in</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			lobes
			
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			lobes
			
		</td>
	</tr>
		<tr>
		<td><label>Collapse of </label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
		degree in
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
		lobes
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree in
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			lobes	
		</td>
	</tr>
		<tr>
		<td><label>Rupture/laceration</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>	
		</td>
	</tr>
		<tr>
				<td><label>Fat and marrow emboil and extent</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>	
		</td>
	</tr>
		
		
</table>
</div>

<div class="clear paddingTop15"></div>

<div class="Block">
<label>Pericardium</label>
<select name="Pericardium" id="pericardium"  class="small">
<option value="Normal">Normal</option>
<option value="Any pre-existing lesion">Any pre-existing lesion</option>
<option value="Petechine">Petechine present on visceral surface</option>

</select>




<label>Bruising of</label>
<input tabindex="1" type="text"	name="damageSustainedInAccident" maxlength="10" value="" />
<label class="unit">degree</label>


<div class="clear"></div>

<label>Haemopericardium of</label>
<input tabindex="1" type="text"	name="haemopericardiumOf" maxlength="10" value="" />
<label class="unit">css</label>




<label>Hydropcricardium of</label>
<input tabindex="1" type="text"	name="hydropcricardiumOf" maxlength="10" value="" />
<label class="unit">css.</label>


<div class="clear"></div>

<label>Lacerations at</label>
<input tabindex="1" type="text"	name="lacerations" maxlength="10" value="" />
<label class="auto">with heart in situ/displaced to</label>
<input tabindex="1" type="text"	name="lacerationsAt" maxlength="10" value="" />
<div class="clear"></div>




</div>
<div class="clear paddingTop15"></div>

<div class="Block">
<label>Heart</label>
<select name="heart" id="heart"  onchange="showHeart();">
<option value="Normal">Normal</option>
<option value="Any">Any pre-existing lesion</option>
<option value="Foremen ovale closed">Foremen ovale closed</option>
<option value="Foremen ovale patent">Foremen ovale patent</option>
</select>


<div id="heartDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksHeart" maxlength="10" value="" />

</div>

<label>Weight</label>
<input tabindex="1" type="text"	name="weight" maxlength="10" value="" />

<div class="clear"></div>

<label>Endocardial rupture at</label>
<input tabindex="1" type="text"	name="endocardialRuptureAt" maxlength="10" value="" />


<label>Pentrating wound of</label>
<input tabindex="1" type="text"	name="endocardialRuptureAt" maxlength="10" value="" />
<label>degree caused by</label>
<input tabindex="1" type="text"	name="degree" maxlength="10" value="" />

<div class="clear"></div>
<label>involving</label>
<input tabindex="1" type="text"	name="involving" maxlength="10" value="" />

<label>Full thickness rupture at</label>
<input tabindex="1" type="text"	name="fullThicknessRuptureAt" maxlength="10" value="" />


</div>

<div class="clear paddingTop15"></div>

<div class="Block">
<label>Coronary-Arteries</label>
<select name="coronary" id="coronary"  onchange="showCoronary();">
<option value="Normal">Normal,Atheroma with adequate lumen</option>
<option value="Atheroma with severe restricition of lumen">Atheroma with severe restricition of lumen</option>
<option value="Atheroma with desgenerative changes">Atheroma with desgenerative changes</option>
<option value="Short">Short description of coronary circulation if abnormal</option>
</select>


<div id="coronaryDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksCoronary" maxlength="10" value="" />

</div>
</div>

<div class="clear paddingTop15"></div>

<div class="Block">
<label>Aorta</label>
<select name="aorta" id="aorta"  onchange="showAorta();">
<option value="Normal">Normal</option>
<option value="Any">Any pre-existing lesion</option>
</select>


<div id="aortaDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksAorta" maxlength="10" value="" />

</div>

<label>Trauma Involving</label>
	<input tabindex="1" type="text"	name="traumainvolving" maxlength="10" value="" />

<label>Laceration-Location</label>
	<input tabindex="1" type="text"	name="lacerationLocation" maxlength="10" value="" />


</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label>Other Great Vessels</label>
<select name="otherGreatVessels" id="otherGreatVessels"  onchange="showOtherGreatVessels();">
<option value="Normal">Normal</option>
<option value="Any">Any pre-existing lesion</option>
</select>


<div id="otherGreatVesselsDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksOtherGreatVessels" maxlength="10" value="" />

</div>

<label>Trauma Involving</label>
	<input tabindex="1" type="text"	name="traumainvolvingOtherGreatVessels" maxlength="10" value="" />



</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label>Diaphragam</label>
<select name="diaphragam" id="diaphragam"  onchange="showDiaphragam();">
<option value="Normal">Normal</option>
<option value="Brusing">Brusing</option>
<option value="Rupture RT">Rupture RT</option>
<option value="Rupture LT">Rupture LT</option>
<option value="Rupture Bilateral">Rupture Bilateral</option>
<option value="Herniation">Herniation of Viscera(Specify)</option>
</select>


<div id="diaphragamDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksOtherGreatVessels" maxlength="10" value="" />

</div>
</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label>Peritoneum</label>
<select name="peritoneum" id="peritoneum"  onchange="showPeritoneum();">
<option value="Normal">Normal</option>
<option value="Any">Any pre-existing lesion</option>
</select>


<div id="peritoneumDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksOtherGreatVessels" maxlength="10" value="" />

</div>


<div class="clear"></div>

<label>Retromesenteric Haemorrhange of</label>
	<input tabindex="1" type="text"	name="retromesentericHaemorrhangeOf" maxlength="10" value="" />
<label class="unit">degree</label>



<label>Haemoperitoneum of</label>
	<input tabindex="1" type="text"	name="haemoperitoneumOf" maxlength="10" value="" />
<label class="unit">css</label>


<label>Hydroperitoneum of</label>
	<input tabindex="1" type="text"	name="hydroperitoneumOf" maxlength="10" value="" />
<label class="unit">css</label>


<div class="clear"></div>

<label>Laceration of peritoncum at</label>
	<input tabindex="1" type="text"	name="lacerationOfPeritoncumAt" maxlength="10" value="" />

</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label>Oesophagus</label>
<select name="oesophagus" id="oesophagus"  onchange="showOesophagus();">
<option value="Normal">Normal</option>
<option value="Any">Any pre-existing lesion</option>
<option value="Contains">Contains stomach content</option>
<option value="Evidence">Evidence of ante mortem burning</option>
<option value="Injured">Injured in accident</option>
</select>


<div id="oesophagusDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksOesophagus" maxlength="10" value="" />

</div>


</div>

<div class="clear paddingTop15"></div>

<div class="Block">
<label>Stomach</label>
<select name="stomach" id="stomach"  onchange="showStomach();">
<option value="Normal">Normal</option>
<option value="Any">Any pre-existing lesion</option>
<option value="Distension">Distension</option>
<option value="Rupture into abdomen">Rupture into abdomen</option>
<option value="Rupture into thorax">Rupture into thorax</option>
<option value="Post mortem digestion">Post mortem digestion</option>
</select>


<div id="stomachDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksStomach" maxlength="10" value="" />

</div>

</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label>Intestines</label>
<select name="intestines" id="intestines"  onchange="showIntestines();">
<option value="Normal">Normal</option>
<option value="Any">Any pre-existing lesion</option>

</select>


<div id="intestinesDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksIntestines" maxlength="10" value="" />

</div>

<label>Distension Rupture at</label> 
	<input tabindex="1" type="text"	name="distensionRuptureAt" maxlength="10" value="" />
	
	
<div class="clear"></div>
<label>Haemorrhage of wall/into lumen of</label> 
<input tabindex="1" type="text"	name="haemorrhage" maxlength="10" value="" />
<label class="unit">degree involving</label>
	
</div>



<div class="clear paddingTop15"></div>

<div class="Block">
<label>Liver</label>
<select name="liver" id="liver"  onchange="showLiver();">
<option value="Normal">Normal</option>
<option value="Any">Any pre-existing lesion</option>

</select>


<div id="liverDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksLiver" maxlength="10" value="" />

</div>

<label>Weight</label> 
	<input tabindex="1" type="text"	name="weightLiver" maxlength="10" value="" />
	
	
<div class="clear"></div>
<label>Trauma of </label> 
<input tabindex="1" type="text"	name="traumaOf" maxlength="10" value="" />
<label>degree caused by</label>
<input tabindex="1" type="text"	name="degreeTraumaOf" maxlength="10" value="" />
	
</div>

<div class="clear paddingTop15"></div>

<div class="Block">
<label>Pancreas</label>
<select name="pancreas" id="pancreas"  onchange="showPancreas();">
<option value="Normal">Normal</option>
<option value="Any">Any pre-existing lesion</option>

</select>


<div id="pancreasDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksPancreas" maxlength="10" value="" />

</div>

<label>Weight</label> 
	<input tabindex="1" type="text"	name="weightPancreas" maxlength="10" value="" />
	
	
<div class="clear"></div>
<label>Trauma of </label> 
<input tabindex="1" type="text"	name="traumaOfPancreas" maxlength="10" value="" />
<label>degree caused by</label>
<input tabindex="1" type="text"	name="degreeTraumaOfPancreas" maxlength="10" value="" />
	
</div>




<div class="clear paddingTop15"></div>
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<TH scope="col">Kidney</TH>
		<TH scope="col">Right</TH>
		<TH scope="col">Left</TH>
	</tr>
	<tr>
		<td><label>Result</label>	</td>
		<td>
			<select name="">
				<option value="Normal">Normal</option>
				<option value="Any pre-existing lesion">Any pre-existing lesion</option>
				
			</select>
		</td>
		<td>
			<select name="">
				<option value="Normal">Normal</option>
				<option value="Any pre-existing lesion">Any pre-existing lesion</option>
				
			</select>
		</td>
		
	</tr>
		<tr>
		<td><label>Rupture/Laccration of </label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree casued by
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
	
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree casued by
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>	
		
		</td>
	</tr>
		<tr>
		<td><label>Perirenal haemorrhage of</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree
		
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree
			
		</td>
	</tr>
		<tr>
		<td><label>Intrarenal haemorrhage of</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree
			
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree
			
			
		</td>
	</tr>
	</table>
	</div>
	
	
	
	<div class="clear paddingTop15"></div>
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<TH scope="col">Adrenal</TH>
		<TH scope="col">Right</TH>
		<TH scope="col">Left</TH>
	</tr>
	<tr>
		<td><label>Result</label>	</td>
		<td>
			<select name="">
				<option value="Normal">Normal</option>
				<option value="Any pre-existing lesion">Any pre-existing lesion</option>
				
			</select>
		</td>
		<td>
			<select name="">
				<option value="Normal">Normal</option>
				<option value="Any pre-existing lesion">Any pre-existing lesion</option>
				
			</select>
		</td>
		
	</tr>
		<tr>
		<td><label>Laccration of </label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree casued by
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
	
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree casued by
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>	
		
		</td>
	</tr>
		<tr>
		<td><label>Periglandular haemorrhage  of</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree
		
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree
			
		</td>
	</tr>
		<tr>
		<td><label>Intraglandular haemorrhage of</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree
			
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			degree
			
			
		</td>
	</tr>
	</table>
	</div>
	
	<div class="clear paddingTop15"></div>

<div class="Block">
<label>Pelvic Organs</label>
<select name="pelvicOrgans" id="pelvicOrgans"  onchange="showPelvicOrgans();">
<option value="Normal">Normal</option>
<option value="Any">Any pre-existing lesion</option>
<option value="Damaged">Damaged in accident(Specify)in association with(any bony injury)</option>
</select>


<div id="pelvicOrgansDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksPelvicOrgans" maxlength="10" value="" />

</div>
<div id="pelvicOrgansDamagedDiv" style="display: none" >
<label>any bony injury</label>
	<input tabindex="1" type="text"	name="anyBonyInjury" maxlength="10" value="" />

</div>

</div>
	
	
	
	<div class="clear paddingTop15"></div>

<div class="Block">
<label>Pituitary</label>
<select name="pituitary" id="pituitary"  onchange="showPituitary();">
<option value="Normal">Normal</option>
<option value="Not Examined">Not Examined</option>
<option value="Any">Any pre-existing lesion</option>
</select>


<div id="pituitaryDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksPituitary" maxlength="10" value="" />
</div>

<label>Haemorrhage of</label>
<input tabindex="1" type="text"	name="haemorrhageOf" maxlength="10" value="" />
<label class="unit">degree</label>

</div>

	<div class="clear paddingTop15"></div>

<div class="Block">
<label>Thymus</label>
<select name="thymus" id="thymus" >
<option value="Normal">Normal</option>
<option value="Enlarged">Enlarged</option>
</select>

<label>Weight</label>
	<input tabindex="1" type="text"	name="weightThymus" maxlength="10" value="" />


<label>Haemorrhage of</label>
<input tabindex="1" type="text"	name="haemorrhageOfThymus" maxlength="10" value="" />
<label class="unit">degree</label>

</div>


	<div class="clear paddingTop15"></div>

<div class="Block">
<label>Thyroid</label>
<select name="thyroid" id="thyroid" onchange="showThyroid();">
<option value="Normal">Normal</option>
<option value="Any">Any pre-existing lesion</option>
<option value="AnyTraumaticChanges">Any traumatic changes</option>
</select>


<div id="thyroidDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksThyroid" maxlength="10" value="" />
</div>


<div id="thyroidTraumaticDiv" style="display: none" >

<label>Remarks Traumatic Changes</label>
	<input tabindex="1" type="text"	name="remarksThyroidTraumatic" maxlength="10" value="" />
</div>


<label>Weight</label>
	<input tabindex="1" type="text"	name="weightThyroid" maxlength="10" value="" />

</div>


	<div class="clear paddingTop15"></div>

<div class="Block">
<label>Lymph Glands</label>
<select name="lymphGlands" id="lymphGlands" onchange="showLymphGlands();">
<option value="Normal">Normal</option>
<option value="Any">Any pre-existing lesion</option>
</select>

<div id="lymphGlandsDiv" style="display: none" >
<div class="clear"></div>
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksLymphGlands" maxlength="10" value="" />
</div>

</div>




<div class="clear paddingTop15"></div>

<div class="Block">
<label>Air Embolism</label>

<label>No Evidence</label>
<input tabindex="1" type="checkbox"	name="noEvidence"  />


<label>Found at</label>
<input tabindex="1" type="text"	name="noEvidence" maxlength="10" value="" />
<label class="unit">significance</label>
</div>




	<div class="clear paddingTop15"></div>

<div class="Block">
<label>Fat Embolism</label>
<select name="fatEmbolism" id="fatEmbolism" onchange="showFatEmbolism();">
<option value="No Gross Evidence">No Gross Evidence</option>
<option value="EvidenceFound">Evidence Found</option>
</select>

<div id="fatEmbolismDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksFatEmbolism" maxlength="10" value="" />
</div>

</div>


	<div class="clear paddingTop15"></div>

<div class="Block">
<label>Carbon Monoxide Poisoning</label>
<select name="carbon" id="carbon" onchange="showCarbon();">
<option value="No Evidence">No Evidence</option>
<option value="AutopsyEvidence">Autopsy Evidence</option>
</select>


<div id="carbonDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksCarbon" maxlength="10" value="" />
</div>


<div class="clear"></div>

<label>Estimated at</label>
<input tabindex="1" type="text"	name="estimatedAt" maxlength="10" value="" />

<label>Labratory</label>
<input tabindex="1" type="text"	name="labratory" maxlength="10" value="" />
</div>


<div class="clear paddingTop15"></div>
<div class="Block">
<label>Other Poisonings</label>
<select name="otherPoisonings" id="otherPoisonings" onchange="showOtherPoisonings();">
<option value="No Evidence">No Evidence</option>
<option value="AutopsyEvidence">Autopsy Evidence</option>
</select>


<div id="otherPoisoningsDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksOtherPoisonings" maxlength="10" value="" />
</div>


<div class="clear"></div>

<label>Presence Confirmed At</label>
<input tabindex="1" type="text"	name="presenceConfirmedAt" maxlength="10" value="" />

<label>Labratory</label>
<input tabindex="1" type="text"	name="labratoryOther" maxlength="10" value="" />
</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label>Hypoxia</label>
<select name="hypoxia" id="hypoxia" onchange="showHypoxia();">
<option value="No Evidence">No Evidence</option>
<option value="AutopsyEvidence">Autopsy Evidence</option>
</select>


<div id="hypoxiaDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksHypoxia" maxlength="10" value="" />
</div>
</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label>Causation Of Injuries</label>
<textarea rows="" cols="60"	name="otherConditions" class="auto" onkeyup="chkLength(this,150);"></textarea>
</div>


<div class="clear paddingTop15"></div>
<h3>Causation Of Injuries</h3>

<div class="Block">
<label class="large">Summaries the major injuries sustained by causes</label>
<textarea rows="" cols="60"	name="otherConditions" class="auto" onkeyup="chkLength(this,150);"></textarea>
</div>

<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<TH scope="col"></TH>
		<TH scope="col">Ante Mortem</TH>
		<TH scope="col">Post Mortem</TH>
	</tr>

		<tr>
		<td><label>In Aircraft in air </label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
	
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
		
		</td>
	</tr>
		<tr>
		<td><label>At altitude while escaping</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
		
		
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
		</td>
	</tr>
		<tr>
		<td><label>On ground following escape</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
			
		</td>
	</tr>
			<tr>
		<td><label>While being thrown from aircraft at impact</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
			
		</td>
	</tr>
			<tr>
		<td><label>On spontancous ejection</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
			
		</td>
	</tr>
			<tr>
		<td><label>Other causes</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
			
		</td>
	</tr>
	</table>
	</div>

<div class="clear paddingTop15"></div>
<h3>Pre-Existing Disease</h3>
<div class="Block">
<label class="large">Summaries any physical conditions discovered which may have contributed to pilot error or incapability</label>
<textarea rows="" cols="60"	name="summariesAnyPhysical" class="auto" onkeyup="chkLength(this,150);"></textarea>
</div>



<div class="clear paddingTop15"></div>

<div class="Block">
<label>Histological</label>
<input tabindex="1" type="text"	name="histological" maxlength="10" value=""/>

<label>No Material taken for histology</label>
<input tabindex="1" type="text"	name="noMaterial" maxlength="10" value=""/>
	
<label>Material taken for histology and examinated at</label>
<input tabindex="1" type="text"	name="material" maxlength="10" value=""/>
</div>




<div class="clear paddingTop15"></div>

<div class="Block">
<label>Toxicological & Biohemical</label>
<input tabindex="1" type="text"	name="toxicologicalBiochemical" maxlength="10" value=""/>

<label>No specimens taken for such examination</label>
<input tabindex="1" type="text"	name="noMaterial" maxlength="10" value=""/>
	
<div class="clear"></div>
<label class="auto">The follwoing specimens were taken for estimation of the substances stated and examined at </label>
<div class="clear"></div>
<input tabindex="1" type="text"	name="material" maxlength="10" value=""/><label class="auto">for</label><input tabindex="1" type="text"	name="material" maxlength="10" value=""/>
<div class="clear"></div>
<input tabindex="1" type="text"	name="material" maxlength="10" value=""/><label class="auto">for</label><input tabindex="1" type="text"	name="material" maxlength="10" value=""/>
<div class="clear"></div>
<input tabindex="1" type="text"	name="material" maxlength="10" value=""/><label class="auto">for</label><input tabindex="1" type="text"	name="material" maxlength="10" value=""/>
</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label>Cause Of Death</label>
<input tabindex="1" type="text"	name="toxicologicalBiochemical" maxlength="10" value=""/>

<label>Disease or condition directly leading to dealth</label>
<input tabindex="1" type="text"	name="noMaterial" maxlength="10" value=""/>

<div class="clear"></div>

<label>Antecedent</label>
<input tabindex="1" type="text"	name="noMaterial" maxlength="10" value=""/>
<label>due to or as a consequence of</label>

<label>Causes</label>
<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
<label>due to or as a consequence of</label>

<div class="clear"></div>

<label>Other Significant conditions</label>
<textarea rows="" cols="60"	name="summariesAnyPhysical" class="auto" onkeyup="chkLength(this,150);"></textarea>

</div>


<div class="clear paddingTop15"></div>
<h3>Signature of Pathologist/M.O. Performinh Postmortem</h3>

<div class="Block">
<label>Name in Capitals</label>

<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
<label>Appoinment</label>
<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
</div>

</div>


<div id="country7" class="tabcontentIn">

<div class="clear paddingTop15"></div>
<div class="Block">



<label> Surname</label>
<input tabindex="1" type="text"	name="Surname" maxlength="10" value="" />	

<label> First Name</label>
<input tabindex="1" type="text"	name="FirstName" maxlength="10" value="" />
	

<label>Crew Duty (or Passenger Seating)</label>
<input tabindex="1" type="text"	name="crewDuty" maxlength="10" value="" />
<div class="clear"></div>

<label>Rank</label>
<select	id="<%=RANK %>" name="<%=RANK %>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){
	
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}
	}%>
</select>


<label>Number</label>
<input tabindex="1" type="text"	name="number" maxlength="10" value="" />
	
	
</div>


<div class="clear paddingTop15"></div>
<div class="Block">
<label>Evidence Of Escape In Flight</label>
<select name="evidenceOfEscapeinFlight" id="evidenceOfEscapeinFlight" onchange="showEvidenceOfEscapeinFlight();">
<option value="Personal Evidence">Personal Evidence</option>
<option value="Eyewithness Evidence">Eyewithness Evidence</option>
<option value="Rescue Evidence">Rescue Evidence</option>
<option value="Seat Harness Recovered Unfastended">Seat Harness Recovered Unfastended</option>
<option value="otherEvidence">Other Evidence</option>
</select>


<div id="evidenceOfEscapeinFlightDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksEvidenceOfEscapeinFlight" maxlength="10" value="" />
</div>


<label>Brief Descritption of method of escape</label>
<textarea rows="" cols="60"	name="briefDes" class="auto" onkeyup="chkLength(this,150);"></textarea>

</div>



<div class="clear paddingTop15"></div>
<div class="Block">
<label>Distress Calls</label>
<select name="distressCall" id="distressCall">
<option value="Made">Made</option>
<option value="Not Made">Not Made</option>
</select>


<label>Damage To Aircraft Prior To Escape</label>
<select name="damageToAircraftPriorToEscape" id="damageToAircraftPriorToEscape" onchange="showDamageToAircraftPriorToEscape();">
<option value="Unknown">Unknown</option>
<option value="Undamaged">Undamaged</option>
<option value="On Fire">On Fire</option>
<option value="Break up">Break Up</option>
<option value="otherDamage">Other Damage</option>
</select>

<div id="damageToAircraftPriorToEscapeDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksDamageToAircraftPriorToEscape" maxlength="10" value="" />
</div>
</div>




<div class="clear paddingTop15"></div>
<div class="Block">
<label>Canopy And/Or Jettison</label>
<select name="canopyAndOrJettison" id="canopyAndOrJettison" onchange="showCanopyAndOrJettison();">
<option value="Clear">Clear</option>
<option value="Difficulty">Difficulty</option>
</select>
<div id="canopyAndOrJettisonDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarkscanopyAndOrJettison" maxlength="10" value="" />
</div>


</div>

<h3>Conditions Of Escape</h3>
<div class="clear paddingTop15"></div>
<div class="Block">
<h4>State (indicating whether known or estimated)</h4>


<label class="large">Time Between Emergency And Escape</label>
<input tabindex="1" type="text"	name="timeBetweenEmergencyAndEscape" maxlength="10" value="" class="large"/>

<div class="clear"></div>
<label class="large">Altitude at Time Of Escape</label>
<input tabindex="1" type="text"	name="AltitudeAtTimeOfEscape" maxlength="10" value="" class="large"/>


<div class="clear"></div>

<label class="large">Cabin Altitude Immediately Prior to Escape</label>
<input tabindex="1" type="text"	name="cabinAltitudeImmediatelyPriorToEscape" maxlength="10" value="" class="large"/>

<div class="clear"></div>
<label class="large">Speed (I.A.S) At time of Escape</label>
<input tabindex="1" type="text"	name="SpeedAtTimeOfEscape" maxlength="10" value="" class="large"/>

<div class="clear"></div>

<div class="clear"></div>
<label class="large">Flight Path at Time of Escape</label>
<select name="flightPathAtTimeOfEscape" id="flightPathAtTimeOfEscape" class="small">
<option value="Level">Level</option>
<option value="Climbing">Climbing</option>
<option value="Descending">Descending</option>
<option value="Diving">Diving</option>
<option value="Spinning">Spinning</option>
<option value="Not Known">Not Known</option>

</select>

<label class="large">Aircraft Attitude at the time of escape</label>
<select name="flightPathAtTimeOfEscape" id="flightPathAtTimeOfEscape" class="small">
<option value="Level Pitch">Level Pitch</option>
<option value="Nose Up">Nose Up</option>
<option value="Nose Down">Nose Down</option>
<option value="Not Known">Not Known</option>
<option value="Level Back">Level Back</option>
<option value="Banked Port">Banked Port</option>
<option value="Banked Starboard">Banked Starboard</option>
<option value="Banked Inverted">Banked Inverted</option>

</select>

<div class="clear"></div>

<label class="large">Configuration Of Aircraft At Time Escape</label>
<select name="configurationOfAircraftAtTimeOfEscape" id="configurationOfAircraftAtTimeOfEscape" class="small">
<option value="Underdercarriage Up">Underdercarriage Up</option>
<option value="Underdercarriage Down">Underdercarriage Down</option>
<option value="Flaps Up">Flaps Up</option>
<option value="Flaps Down">Flaps Down</option>
<option value="Dive Breakes In">Dive Breakes In</option>
<option value="Dive Breakes Out">Dive Breakes Out</option>
</select>


<label class="large">Aecelercarriage at Time of Escape</label>
<select name="aecelercarriageAtTimeOfEscape" id="aecelercarriageAtTimeOfEscape" class="small">
<option value="None">None</option>
<option value="Positive G">Positive G(Estimated At)</option>
<option value="Negative G">Negative G(Estimated At)</option>
<option value="Not Known">Not Known</option>
</select>

<div class="clear"></div>
<label class="large">Was the Aircraft Under Control At The Time Of Escape Attempt?</label>
<input tabindex="1" type="text"	name="aircraftUnderControl" maxlength="10" value="" class="large"/>





</div>



<div class="clear paddingTop15"></div>
<div class="Block">
<label>Aircraft Fouling</label>
<select name="aircraftFouling" id="aircraftFouling" class="small" onchange="showAircraftFouling();">
<option value="Nil">Nil</option>
<option value="Minor">Minor</option>
<option value="Moderate">Moderate</option>
<option value="Severe">Severe</option>
<option value="Personal Evidence">Personal Evidence</option>
<option value="otherEvidence">Other Evidence</option>
</select>

<div id="aircraftFoulingDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksAircraftFouling" maxlength="10" value="" />
</div>

</div>



<div class="clear paddingTop15"></div>
<div class="Block">
<label>Type Of Parachute</label>
<select name="typeOfParachute" id="typeOfParachute" class="small" onchange="showTypeOfParachute();">
<option value="None">None</option>
<option value="Seat">Seat</option>
<option value="Back">Back</option>
<option value="Chest">Chest</option>
<option value="Other">Other</option>
<option value="Mark">Mark</option>
<option value="Barostat Control">Barostat Control</option>
<option value="No Barostat">No Barostat</option>
<option value="Static Line">Static Line</option>
</select>

<div id="typeOfParachuteDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksTypeOfParachute" maxlength="10" value="" />
</div>
</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label>Parachute 'D' Ring</label>
<select name="parachute" id="parachute" class="small">
<option value="Pulled">Pulled</option>
<option value="Not Pulled">Not Pulled</option>
<option value="Foreced From Housing">Foreced From Housing</option>
<option value="Not Known">Not Known</option>
</select>





<label>Parachute Canopy</label>
<select name="parachuteCanopy" id="parachuteCanopy" class="small">
<option value="In Pack">In Pack</option>
<option value="Opened by Aircarft Fouling">Opened by Aircarft Fouling</option>
<option value="Opened By Ground  Impact">Opened By Ground  Impact</option>
<option value="Released By Subject">Released By Subject</option>
<option value="Released By Subject">Released By Subject</option>
<option value="Partial Deployment">Partial Deployment</option>
<option value="Fully Developed">Fully Developed</option>
<option value="Not Known">Not Known</option>
</select>


<label>Altitude at Parachute Deployment</label>
<input tabindex="1" type="text"	name="altitudeAtParachuteDeployment" maxlength="10" value="" />
<label class="unit">ft</label>


<select name="altitude" id="altitude" class="small">
<option value="Undamaged">Undamaged</option>
<option value="Damaged During Descent">Damaged During Descent</option>
<option value="Damaged On Ground">Damaged On Ground</option>
<option value="Not Known">Not Known</option>
</select>
</div>



<label>Parachute Harness</label>

<select name="parachuteHarness" id="parachuteHarness" class="small">
<option value="Effective to Ground Level">Effective to Ground Level</option>
<option value="Failed ,During Descent">Failed ,During Descent</option>
<option value="Not Known">Not Known</option>
<option value="Release Box">Release Box</option>
<option value="typeOfModificationUndamaged">Type Of Modification-Undamaged</option>
<option value="typeOfModificationDamaged">Type Of Modification-Damaged</option>
<option value="Unfastened by Subject">Unfastened by Subject</option>
<option value="Difficulty">Difficulty</option>
<option value="Unfastened by Rescuers">Unfastened by Rescuers</option>
<option value="Description of harness and release box at rescue">Description of harness and release box at rescue</option>
</select>



<div class="clear paddingTop15"></div>
<div class="Block">
<label>Terrain For Landing</label>

<select name="terrainForLanding" id="terrainForLanding" class="small">
<option value="Built Up">Built Up</option>
<option value="Wooded">Wooded</option>
<option value="Scrub">Scrub</option>
<option value="Sea">Sea</option>
<option value="Fresh Water">Fresh Water</option>
<option value="Open Ground">Open Ground</option>
</select>

<label>Depth of Crater made by Subject</label>
<input tabindex="1" type="text"	name="depthOfCraterMadeBySubject" maxlength="10" value="" />
</div>




<div class="clear paddingTop15"></div>
<h3>Condition For Landing</h3>
<div class="Block">
<label>Wind Speed</label>
<input tabindex="1" type="text"	name="windSpeed" maxlength="10" value="Not Known" />

<label>Vertical Visibility</label>
<input tabindex="1" type="text"	name="verticalVisibility" maxlength="10" value="Not Known" />


<select name="conditionForLanding" id="conditionForLanding" class="small">
<option value="Fine">Fine</option>
<option value="Rain">Rain</option>
<option value="Storm">Strom</option>
<option value="Fog">Fog</option>
<option value="Snow">Snow</option>
<option value="Not Known">Not Known</option>
</select>


<label>Other Conditions</label>
<input tabindex="1" type="text"	name="otherConditions" maxlength="10" />

</div>

<div class="clear paddingTop15"></div>
<div class="Block">

<label>Effectiveness Of Landing</label>

<select name="effectivenessOfLanding" id="effectivenessOfLanding" class="small" onchange="showEffectivenessOfLanding();">
<option value="Conscious">Conscious</option>
<option value="Unconscious">Unconscious</option>
<option value="Not Known">Not Known</option>
<option value="LandingAsPlanned">Landing As Planned</option>
<option value="Difficulty">Difficulty In Landing</option>

</select>

<div id="effectivenessOfLandingDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksEffectivenessOfLanding" maxlength="10" value="" />
</div>

<label>Part of body sustaining initial impact</label>
<input tabindex="1" type="text"	name="partOfBodySustainingInitialImpact" maxlength="10" />



<select name="effectiveness" id="effectiveness" class="small" onchange="showEffectiveness();">
<option value="No Darg">No Darg</option>
<option value="Dargged">Dargged</option>
<option value="Darg Unknown">Darg Unknown</option>
</select>

<div id="effectivenessDiv" style="display: none" >
	<input tabindex="1" type="text"	name="remarksEffectiveness" maxlength="10" value="" />
<label class="unit">yds</label>
</div>

</div>

<div class="clear paddingTop15"></div>
<h3>Degree Of Success</h3>
<div class="Block">

<label class="large">Casualty Fully Mobile : Contacted assistance after</label>
<input tabindex="1" type="text"	name="contacted" maxlength="10" value="" />
<label class="unit">min/hrs</label>

<label class="large">Casualty incapacitated : Reached after</label>
<input tabindex="1" type="text"	name="reached" maxlength="10" value="" />
<label class="unit">min/hrs</label>


<div class="clear"></div>
<label class="large">Rescued By</label>
<input tabindex="1" type="text"	name="rescuedBy" maxlength="10" value="" />

<label class="large">Time From Escape To Medical Treatment</label>
<input tabindex="1" type="text"	name="timeFromEscapeToMedicalTreatment" maxlength="10" value="" />
<label class="unit">mins/hrs</label>



</div>



<div class="clear paddingTop15"></div>
<h3>Damage To Flying Clothing And Equipment Resulting From Escape</h3>
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
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
				
		</td>
			<td>
			<select name="protectiveHelmet">
			
				<option value="Worn">Worn</option>
				<option value="Not Worn">Not Worn</option>
				<option value="Lost">Lost</option>
				<option value="Damage">Damage</option>	
			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
			
		</td>
		
		</tr>
		<tr>
				<td>Flying Helmet</td>
					<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
				
		</td>
		<td>
			<select name="flyingHelmet">
			
				<option value="Worn">Worn</option>
				<option value="Not Worn">Not Worn</option>
				<option value="Lost">Lost</option>
				<option value="Damage">Damage</option>	
			</select>
			
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
			
		</td>
		</tr>
		<tr>
			<Td>Vizor/Goggles/Spectacles</Td>
				<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
				
		</td>
		<td>
			<select name="vizor">
			
				<option value="Worn">Worn</option>
				<option value="Not Worn">Not Worn</option>
				<option value="Lost">Lost</option>
				<option value="Damage">Damage</option>	
			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
			
		</td>
		</tr>
		<tr>
			<Td>Spectacles</Td>
				<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
				
		</td>
				<td>
			<select name="spectacles">
			
				<option value="Worn">Worn</option>
				<option value="Not Worn">Not Worn</option>
				<option value="Lost">Lost</option>
				<option value="Damage">Damage</option>	
			</select>
		</td>
			<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
			
		</td>
			</tr>
		<tr>
		<Td>Overall/Immersion/Exposure Suit</Td>
			<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
				
		</td>
				<td>
			<select name="overall">
			
				<option value="Worn">Worn</option>
				<option value="Not Worn">Not Worn</option>
				<option value="Lost">Lost</option>
				<option value="Damage">Damage</option>	
			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
			
		</td>
		</tr>
		<tr>
		<Td>Life Jacket</Td>
			<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
				
		</td>
				<td>
			<select name="lifeJacket">
			
				<option value="Worn">Worn</option>
				<option value="Not Worn">Not Worn</option>
				<option value="Lost">Lost</option>
				<option value="Damage">Damage</option>	
			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
			
		</td>
		</tr>
		<tr>
		
		<Td>Boots</Td>
			<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
				
		</td>
				<td>
			<select name="boots">
			
				<option value="Worn">Worn</option>
				<option value="Not Worn">Not Worn</option>
				<option value="Lost">Lost</option>
				<option value="Damage">Damage</option>	
			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
			
		</td>
		</tr>
		<tr>
			<Td>Emergency Oxygen</Td>
				<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
				
		</td>
				<td>
			<select name="emergencyOxygen">
			
				<option value="Worn">Worn</option>
				<option value="Not Worn">Not Worn</option>
				<option value="Lost">Lost</option>
				<option value="Damage">Damage</option>	
			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
			
		</td>
		</tr>
		<tr>
		
		<Td>Other</Td>
			<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
				
		</td>
				<td>
			<select name="Other">
				
				<option value="Worn">Worn</option>
				<option value="Not Worn">Not Worn</option>
				<option value="Lost">Lost</option>
				<option value="Damage">Damage</option>	
			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="10" value=""/>
			
			
			
		</td>
		</tr>

	</table>
	</div>
	
	
	
<div class="clear paddingTop15"></div>
<h3>Injuries</h3>
<div class="Block">

<label class="large">Describe the injuries received, with the evidence for their causation as a result of</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" class="large"/>
<div class="clear"></div>

<label class="large">Damage to Aircraft While in Cocpit or Cabin</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" class="large"/>
<div class="clear"></div>


<label class="large">Aircraft Fouling</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" class="large"/>
<div class="clear"></div>

<label class="large">Parachute Opening</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" class="large"/>
<div class="clear"></div>

<label class="large">Ground Impact</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" class="large"/>
<div class="clear"></div>

<label class="large">Dragging</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" class="large"/>
<div class="clear"></div>

<label class="large">Parachute Fouling in Sea</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" class="large"/>
<div class="clear"></div>

<label class="large">Other Casuses</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" class="large"/>

</div>


<div class="clear paddingTop15"></div>
<h3>Previous Experience Describe Any Specific Parachute Training</h3>
<div class="Block">
<label class="large">Previous Escape(give date and degree of success)</label>
<input	tabindex="1" name="<%=DATE_TWO %>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.<%=DATE_TWO%>,event);" />
<input tabindex="1" type="text"	name="" maxlength="10" value="" />



<div class="clear"></div>

<label class="large">Forced Landing or Ditching</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" class="large"/>

<label class="large">Unassisted Escape</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" class="large"/>

<label class="large">Ejection Seat Escape</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" class="large"/>

</div>
</div>



<div id="country8" class="tabcontentIn">

<div class="clear paddingTop15"></div>
<div class="Block">



<label> Surname</label>
<input tabindex="1" type="text"	name="Surname" maxlength="10" value="" />	

<label> First Name</label>
<input tabindex="1" type="text"	name="FirstName" maxlength="10" value="" />
	

<label>Crew Duty (or Passenger Seating)</label>
<input tabindex="1" type="text"	name="crewDuty" maxlength="10" value="" />
<div class="clear"></div>

<label>Rank</label>
<select	id="<%=RANK %>" name="<%=RANK %>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){
	
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}
	}%>
</select>


<label>Number</label>
<input tabindex="1" type="text"	name="number" maxlength="10" value="" />
	
	
</div>


<div class="clear paddingTop15"></div>
<h3>DEATH OF SUBJECT</h3>
<div class="Block">
<label class="large">Evidence Of Use Of Ejection Seat</label>
<select name="evidenceOfUseOfEjectionSeat" id="evidenceOfUseOfEjectionSeat" onchange="showEvidenceOfUseOfEjectionSeat();">
				<option value="Personel Evidence">Personel Evidence</option>
				<option value="Eyewitness Evidence">Eyewitness Evidence</option>
				<option value="Rescue Evidence">Rescue Evidence</option>
				<option value="otherEvidence">Other Evidence</option>
				
</select>

<div id="evidenceOfUseOfEjectionSeatDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksEvidenceOfUseOfEjectionSeat" maxlength="10" value="" />
</div>

<div class="clear"></div>
<label class="large">Distress Calls</label>
<select name="distressCalls" id="distressCalls" onchange="showDistressCalls();">
				<option value="Made">Made</option>
				<option value="Not Made">Not Made</option>
				<option value="substanceOfCall">Substance Of Call</option>
				
</select>

<div id="distressCallsDiv" style="display: none" >
<label>If Applicable</label>
	<input tabindex="1" type="text"	name="remarksDistressCalls" maxlength="10" value="" />
</div>
<div class="clear"></div>

<label class="large">Damage To Aircraft Prior To Escape</label>
<select name="damageToAircraftPriorToEscapeOne" id="damageToAircraftPriorToEscapeOne" onchange="showDamageToAircraftPriorToEscapeOne();">
<option value="Unknown">Unknown</option>
<option value="Undamaged">Undamaged</option>
<option value="On Fire">On Fire</option>
<option value="Break up">Break Up</option>
<option value="otherDamage">Other Damage</option>
</select>

<div id="damageToAircraftPriorToEscapeOneDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksDamageToAircraftPriorToEscape" maxlength="10" value="" />
</div>

<div class="clear"></div>
<label class="large">Damage To Seat Prior To Ejection</label>
<select name="damageToSeatPriorToEjection" id="damageToSeatPriorToEjection" onchange="showDamageToSeatPriorToEjection();">
<option value="Unknown">Unknown</option>
<option value="Undamaged">Undamaged</option>
<option value="Damaged">Damaged</option>
<option value="descriptionOfDamage">Description of Damage</option>
</select>

<div id="damageToSeatPriorToEjectionDiv" style="display: none" >
<label>If Applicable</label>
	<input tabindex="1" type="text"	name="remarksDamageToSeatPriorToEjection" maxlength="10" value="" />
</div>


<div class="clear"></div>
<label class="large">Canopy And/Or Hatch Jettison</label>

<select name="canopyAndOrHatchJettison" id="canopyAndOrHatchJettison" onchange="showCanopyAndOrHatchJettison();">
<option value="Independent Action">Independent Action</option>
<option value="Wind Blast Release">Wind Blast Release</option>
<option value="Forcible Release">Forcible Release</option>
<option value="Bind Fired">Bind Fired</option>
<option value="Involuntary Canopy Jettison">Involuntary Canopy Jettison</option>
<option value="Canopy Destoryed Before Ejection">Canopy Destoryed Before Ejection</option>
<option value="Jettison Efficient">Jettison Efficient</option>
<option value="Failed">Failed</option>
<option value="Difficulty">Difficulty</option>
<option value="Canopy was fully Jettisoned Before Ejection">Canopy was fully Jettisoned Before Ejection</option>
<option value="Canopy was not fully Jettisoned Before Ejection">Canopy was not fully Jettisoned Before Ejection</option>
</select>
<div id="canopyAndOrHatchJettisonDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksCanopyAndOrHatchJettison" maxlength="10" value="" />
</div>
<div class="clear"></div>


<label class="large">Altitude At Canopy Jettison</label>
<input tabindex="1" type="text"	name="altitudeAtCanopyJettison" maxlength="10" value="Not Known" />
<label class="unit">ft</label>

<div class="clear"></div>

<label class="large">Speed At Canopy Jettison(I.A.S)</label>
<input tabindex="1" type="text"	name="speedAtCanopyJettison" maxlength="10" value="Not Known" />
<label class="unit">Kts</label>

<div class="clear"></div>
<label class="large">Attitude At Canopy Jettison</label>
<input tabindex="1" type="text"	name="attitudeAtCanopyJettison" maxlength="10" value="Not Known" />

<div class="clear"></div>

<label class="large">Distance Of Canopy From Aircraft Wreekage</label>
<input tabindex="1" type="text"	name="distanceOfCanopyFromAircraftWreekage" maxlength="10" value="Not Known" />
<label class="unit">yds</label>

<div class="clear"></div>
<label class="large">Deliberate Delay In Ejection</label>
<select name="deliberateDelayInEjection" id="deliberateDelayInEjection" onchange="showDeliberateDelayInEjection();">
<option value="Attempting Foreced Landing">Attempting Foreced Landing</option>
<option value="Risk To Civilians">Risk To Civilians</option>
<option value="Not Applicable">Not Applicable</option>
<option value="Preservation Aircraft">Preservation Aircraft</option>
<option value="So Directed">So Directed</option>
<option value="Other">Other</option>
</select>

<div id="deliberateDelayInEjectionDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksDeliberateDelayInEjection" maxlength="10" value="" />
</div>

</div>

<div class="clear paddingTop15"></div>
<h3>Condition Of Ejection</h3>
<div class="Block">
<h4>State(indicating wether known or estimated)</h4>
<label class="large" >Time Between Emergency And Ejection</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" />
<div class="clear"></div>
<label class="large">Altitude At Time Of Ejection</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" />


<div class="clear"></div>

<label class="large">Cabin Altitude Immediately Prior To Ejection</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" />
<div class="clear"></div>
<label class="large">Speed(I.A.S) At Time Of Ejection</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" />

<div class="clear"></div>

<label class="large">Speed(I.A.S) At Time Of Ejection</label>
<select name="speedAtTimeOfEjection" id="speedAtTimeOfEjection" onchange="showSpeedAtTimeOfEjection();">
<option value="Level">Level</option>
<option value="Climbing">Climbing</option>
<option value="Descending">Descending</option>
<option value="Diving">Diving</option>
<option value="Not Known">Not Known</option>
</select>


<div class="clear"></div>
<label class="large">Aircraft Attitude Of Ejection</label>
<select name="aircraftAttitudeOfEjection" id="aircraftAttitudeOfEjection" >
<option value="Level Pitch">Level Pitch</option>
<option value="Nose Up">Nose Up</option>
<option value="Nose Down">Nose Down</option>
<option value="Not Known">Not Known</option>
</select>
<select name="aircraftAttitudeOfEjectionOne" id="aircraftAttitudeOfEjectionOne" >
<option value="Level Bank">Level Bank</option>
<option value="Banked Port">Banked Port</option>
<option value="Banked">Banked Starboard</option>
<option value="Inverted">Inverted</option>
<option value="Not Known">Not Known</option>
</select>
<select name="aircraftAttitudeOfEjectionTwo" id="aircraftAttitudeOfEjectionTwo" >
<option value="Rolling">Rolling</option>
<option value="Spinning">Spinning</option>
<option value="Spiralling">Spiralling</option>
<option value="Not Known">Not Known</option>
</select>

<div class="clear"></div>
<label class="large">Configuration Of Aircraft At Time Of Ejection</label>
<select name="configurationOfAircraftAtTimeOfEjection" id="configurationOfAircraftAtTimeOfEjection" >
<option value="Wheels Up">Wheels Up</option>
<option value="Wheels Down">Wheels Down</option>
<option value="Flaps Up">Flaps Up</option>
<option value="Flaps Down">Flaps Down</option>
<option value="Dive Brakes In">Dive Brakes In</option>
<option value="Dive Brakes Out">Dive Brakes Out</option>

</select>

<div class="clear"></div>


<label class="large">Accelerations At Time Of Ejection</label>
<select name="accelerationsAtTimeOfEjection" id="accelerationsAtTimeOfEjection" onchange="showAccelerationsAtTimeOfEjection();">
<option value="Nones">Nones</option>
<option value="PositiveG">Positive G</option>
<option value="NegativeG">Negative G</option>
<option value="Not Known">Not Known</option>
</select>


<div id="accelerationsAtTimeOfEjectionPositiveGDiv" style="display: none" >
<label>Estimed At</label>
	<input tabindex="1" type="text"	name="estimedAtaccelerationsAtTimeOfEjectionPositiveG" maxlength="10" value="" />
</div>

<div id="accelerationsAtTimeOfEjectionNegativeGDiv" style="display: none" >
<label>Estimed At</label>
	<input tabindex="1" type="text"	name="estimedAtaccelerationsAtTimeOfEjectionNegativeG" maxlength="10" value="" />
</div>

<div class="clear"></div>

<label class="large">Was the Aircraft Under Control At the Time Of Ejection</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" class="large"/>

</div>
<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">Type Of Seat</label>
<select name="typeOfSeat" id="typeOfSeat" onchange="showTypeOfSeat();">
<option value="Mark">Nones</option>
<option value="Latest Mod">Positive G</option>
<option value="Muzzle Velocity Of Gun">Muzzle Velocity Of Gun</option>
<option value="SurvivalPack">Survival Pack</option>
<option value="Cushion">Cushion</option>
<option value="anyUnofficialModsNoted">Any Unofficial Mods Noted</option>
</select>


<div id="typeOfSeatSurvivalPackDiv" style="display: none" >
<label>Type</label>
	<input tabindex="1" type="text"	name="typeSurvivalPack" maxlength="10" value="" />
</div>

<div id="typeOfSeatCushionDiv" style="display: none" >
<label>Type</label>
	<input tabindex="1" type="text"	name="typeCushion" maxlength="10" value="" />
</div>

<div id="typeOfSeatNotedDiv" style="display: none" >
<label>Noted</label>
	<input tabindex="1" type="text"	name="noted" maxlength="10" value="" />
</div>



<div class="clear"></div>

<label class="large">Seat Firing</label>
<select name="seatFiring" id="seatFiring" onchange="showSeatFiring();">
<option value="Mechanism">Mechanism</option>
<option value="Involuntary Firing">Involuntary Firing</option>
<option value="Face Blind">Face Blind</option>
<option value="Alernative">Alernative</option>
<option value="Efficient">Survival Pack</option>
<option value="Difficulty">Difficulty</option>
</select>


<div id="seatFiringAlernativeDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="alernative" maxlength="10" value="" />
</div>

<div id="seatFiringDifficultyDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="difficulty" maxlength="10" value="" />
</div>


<div class="clear"></div>

<label class="large">Leg Restraint</label>
<select name="legRestraint" id="legRestraint" >
<option value="Fitted">Fitted</option>
<option value="Not Fitted">Not Fitted</option>
<option value="Leg Flailing">Leg Flailing</option>
<option value="No Leg Flialing">No Leg Flialing</option>
<option value="Not Known">Not Known</option>

</select>

<div class="clear"></div>

<label class="large">Aircraft Fouling</label>
<select name="aircraftFouling" id="aircraftFouling" >
<option value="Cockpit Clearance">Cockpit Clearance</option>
<option value="Satisfactory">Satisfactory</option>
<option value="Unsatisfactory">Unsatisfactory</option>
<option value="Not Known">Not Known</option>

</select>

<div class="clear"></div>

<label class="large">Fouling of other parts of aircraft</label>
	<input tabindex="1" type="text"	name="" maxlength="10" value="" />
	
<select name="aircraftFoulingOne" id="aircraftFoulingOne" onchange="showAircraftFoulingOne();" class="small">
<option value="Personal Edivence">Personal Edivence</option>
<option value="otherEvidence">Other Evidence</option>
</select>

<div id="aircraftFoulingOneDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksAircraftFoulingOne" maxlength="10" value="" />
</div>


</div>


<div class="clear paddingTop15"></div>
<h3>Drogude Development</h3>
<div class="Block">
<label>Delay Seat Drogude Gun</label>
<input tabindex="1" type="text"	name="" maxlength="10" value="" />
<label>Controller Drogude</label>
<select name="controllerDrogude" id="controllerDrogude" onchange="showControllerDrogude();">
<option value="Deployed">Deployed</option>
<option value="Failure">Failure</option>
</select>
<div id="controllerDrogudeDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksControllerDrogude" maxlength="10" value="" />
</div>
<div class="clear"></div>
<label>Stabilising Drogude</label>
<select name="stabilisingDrogude" id="stabilisingDrogude" onchange="showStabilisingDrogude();">
<option value="Deployed">Deployed</option>
<option value="Failure">Failure</option>
</select>
<div id="stabilisingDrogudeDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksStabilisingDrogude" maxlength="10" value="" />
</div>

</div>
<div class="clear paddingTop15"></div>
<div class="Block">
<label>Descent Before Separation</label>
<select name="descentBeforeSeparation" id="descentBeforeSeparation" >
<option value="Stable">Deployed</option>
<option value="Rotation">Rotation</option>
<option value="Tumbling">Tumbling</option>
<option value="Not Known">Not Known</option>
</select>

<select name="descentBeforeSeparationOne" id="descentBeforeSeparationOne" onchange="showDescentBeforeSeparationOne();">
<option value="Fully Conscious">Fully Conscious</option>
<option value="consciousLost">Conscious Lost</option>
</select>

<div id="descentBeforeSeparationOneDiv" style="display: none" >
<input tabindex="1" type="text"	name="descentBeforeSeparationOne" maxlength="10" value="" />
<label class="unit"> secs.</label>
</div>
<select name="descentBeforeSeparationTwo" id="descentBeforeSeparationTwo" >
<option value="Personal Edivence">Personal Edivence</option>
<option value="Inferred">Inferred</option>
<option value="Not Known">Not Known</option>
</select>
</div>

<div class="clear paddingTop15"></div>
<h3>Separation</h3>
<div class="Block">
<h4>Fully Automatic Seat</h4>
<label class="large">Delay Drogue Gun Separation</label>
<input tabindex="1" type="text"	name="delayDrogueGunSeparation" maxlength="10" value="" />
<label class="unit"> secs.</label>
<div class="clear"></div>
<label class="large">G Stop Setting</label>
<input tabindex="1" type="text"	name="gStopSetting" maxlength="10" value="" />


<div class="clear"></div>
<label class="large">Scissor Shackle</label>
<select name="scissorShackle" id="scissorShackle" onchange="showScissorShackle();">
<option value="Satisfactory">Satisfactory</option>
<option value="Failure">Failure</option>
</select>
<div id="scissorShackleDiv" style="display: none" >
<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksScissorShackle" maxlength="10" value="" />
</div>

<div class="clear"></div>
<label class="large">Head Rest</label>
<select name="headRest" id="headRest" onchange="showHeadRest();">
<option value="Satisfactory">Satisfactory</option>
<option value="Failure">Failure</option>
</select>
<div id="headRestDiv" style="display: none" >
<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksHeadRest" maxlength="10" value="" />
</div>

<div class="clear"></div>
<label class="large">Seat Harness</label>
<select name="seatHarness" id="seatHarness" onchange="showSeatHarness();">
<option value="Satisfactory">Satisfactory</option>
<option value="Failure">Failure</option>
</select>
<div id="seatHarnessDiv" style="display: none" >
<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksSeatHarness" maxlength="10" value="" />
</div>


<div class="clear"></div>
<label class="large">Altitude At Separation Required</label>
<input tabindex="1" type="text"	name="altitudeAtSeparationRequired" maxlength="10" value="Not Known" />
<label class="unit">ft</label>




<div class="clear paddingTop15"></div>

<h4>Manual Separation</h4>

<label class="large">Separation</label>
<select name="separationManual" id="separationManual" onchange="showSeparationManual();">
<option value="Easy">Easy</option>
<option value="Difficulty">Difficulty</option>
<option value="Failure">Failure</option>
</select>
<div id="separationManualDiv" style="display: none" >
<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksSeparationManual" maxlength="10" value="" />
</div>

<div class="clear"></div>
<label class="large">Altitude At Separation Required</label>
<input tabindex="1" type="text"	name="altitudeAtSeparationRequiredManual" maxlength="10" value="Not Known" />
<label class="unit">ft</label>


<div class="clear paddingTop15"></div>
<h4>Emergency Override Used </h4>

<label class="large">Emergency Override Used</label>

<select name="emergencyOverrideUsed" id="emergencyOverrideUsed" onchange="showEmergencyOverrideUsed();">
<option value="Deliberate Use">Deliberate Use</option>
<option value="inadvertentUse">Inadvertent Use</option>

</select>
<div id="emergencyOverrideUsedDiv" style="display: none" >
<label>Cause</label>
<input tabindex="1" type="text"	name="causeEmergencyOverrideUsed" maxlength="10" value="" />
</div>
<div class="clear"></div>
<label class="large">Reason For Use</label>
<input tabindex="1" type="text"	name="reasonForUse" maxlength="10" value="" />

<div class="clear"></div>
<label class="large">Altitude At Which Decision was taken</label>
<input tabindex="1" type="text"	name="altitudeAtWhichDecisionWasTaken" maxlength="10" value="Not Known" />
<label class="unit">ft</label>

<div class="clear"></div>
<label class="large">Separation</label>
<select name="separationEmergency" id="separationEmergency" onchange="showSeparationEmergency();">
<option value="Easy">Easy</option>
<option value="Difficulty">Difficulty</option>
<option value="Failure">Failure</option>
</select>
<div id="separationEmergencyDiv" style="display: none" >
<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksSeparationEmergency" maxlength="10" value="" />
</div>
<div class="clear"></div>
<label class="large">Altitude At Separation</label>
<input tabindex="1" type="text"	name="altitudeAtSeparationEmergency" maxlength="10" value="Not Known" />
<label class="unit">ft</label>
</div>
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
function showEvidenceOfEscapeinFlight()
{
	if(document.getElementById('evidenceOfEscapeinFlight').value == 'otherEvidence'){
	  	document.getElementById("evidenceOfEscapeinFlightDiv").style.display='inline';
	}else{
		document.getElementById("evidenceOfEscapeinFlightDiv").style.display='none';
	}

	
}
function showDamageToAircraftPriorToEscape()
{
	if(document.getElementById('damageToAircraftPriorToEscape').value == 'otherDamage'){
	  	document.getElementById("damageToAircraftPriorToEscapeDiv").style.display='inline';
	}else{
		document.getElementById("damageToAircraftPriorToEscapeDiv").style.display='none';
	}

	

}
function showDamageToAircraftPriorToEscapeOne()
{
	if(document.getElementById('damageToAircraftPriorToEscapeOne').value == 'otherDamage'){
	  	document.getElementById("damageToAircraftPriorToEscapeOneDiv").style.display='inline';
	}else{
		document.getElementById("damageToAircraftPriorToEscapeOneDiv").style.display='none';
	}

	
}
function showCanopyAndOrJettison()
{
	if(document.getElementById('canopyAndOrJettison').value == 'Difficulty'){
	  	document.getElementById("canopyAndOrJettisonDiv").style.display='inline';
	}else{
		document.getElementById("canopyAndOrJettisonDiv").style.display='none';
	}

	
}
function showAircraftFouling()
{
	if(document.getElementById('aircraftFouling').value == 'otherEvidence'){
	  	document.getElementById("aircraftFoulingDiv").style.display='inline';
	}else{
		document.getElementById("aircraftFoulingDiv").style.display='none';
	}

	
}
function showAircraftFoulingOne()
{
	if(document.getElementById('aircraftFoulingOne').value == 'otherEvidence'){
	  	document.getElementById("aircraftFoulingOneDiv").style.display='inline';
	}else{
		document.getElementById("aircraftFoulingOneDiv").style.display='none';
	}

	
}

function showTypeOfParachute()
{
	if(document.getElementById('typeOfParachute').value == 'Other'){
	  	document.getElementById("typeOfParachuteDiv").style.display='inline';
	}else{
		document.getElementById("typeOfParachuteDiv").style.display='none';
	}

	
}


function showEffectivenessOfLanding()
{
	if(document.getElementById('effectivenessOfLanding').value == 'Difficulty'){
	  	document.getElementById("effectivenessOfLandingDiv").style.display='inline';
	}else{
		document.getElementById("effectivenessOfLandingDiv").style.display='none';
	}

	
}

function showEffectiveness()
{
	if(document.getElementById('effectiveness').value == 'Dragged'){
	  	document.getElementById("effectivenessDiv").style.display='inline';
	}else{
		document.getElementById("effectivenessDiv").style.display='none';
	}

	
}
function showEvidenceOfUseOfEjectionSeat()
{
	if(document.getElementById('evidenceOfUseOfEjectionSeat').value == 'otherEvidence'){
	  	document.getElementById("evidenceOfUseOfEjectionSeatDiv").style.display='inline';
	}else{
		document.getElementById("evidenceOfUseOfEjectionSeatDiv").style.display='none';
	}

	
}

function showDistressCalls()
{
	if(document.getElementById('distressCalls').value == 'substanceOfCall'){
	  	document.getElementById("distressCallsDiv").style.display='inline';
	}else{
		document.getElementById("distressCallsDiv").style.display='none';
	}

	
}
function showDamageToSeatPriorToEjection()
{
	if(document.getElementById('damageToSeatPriorToEjection').value == 'descriptionOfDamage'){
	  	document.getElementById("damageToSeatPriorToEjectionDiv").style.display='inline';
	}else{
		document.getElementById("damageToSeatPriorToEjectionDiv").style.display='none';
	}

	
}
function showCanopyAndOrHatchJettison()
{
	if(document.getElementById('canopyAndOrHatchJettison').value == 'Difficulty'){
	  	document.getElementById("canopyAndOrHatchJettisonDiv").style.display='inline';
	}else{
		document.getElementById("canopyAndOrHatchJettisonDiv").style.display='none';
	}

	
}
function showDeliberateDelayInEjection()
{
	if(document.getElementById('deliberateDelayInEjection').value == 'Other'){
	  	document.getElementById("deliberateDelayInEjectionDiv").style.display='inline';
	}else{
		document.getElementById("deliberateDelayInEjectionDiv").style.display='none';
	}

	
}

function showAccelerationsAtTimeOfEjection(){
	if(document.getElementById('accelerationsAtTimeOfEjection').value == 'PositiveG'){
	  	document.getElementById("accelerationsAtTimeOfEjectionPositiveGDiv").style.display='inline';
	}else{
		document.getElementById("accelerationsAtTimeOfEjectionPositiveGDiv").style.display='none';
	}

	if(document.getElementById('accelerationsAtTimeOfEjection').value == 'NegativeG'){
	  	document.getElementById("accelerationsAtTimeOfEjectionNegativeGDiv").style.display='inline';
	}else{
		document.getElementById("accelerationsAtTimeOfEjectionNegativeGDiv").style.display='none';
	}

}
function showTypeOfSeat(){
	if(document.getElementById('typeOfSeat').value == 'SurvivalPack'){
	  	document.getElementById("typeOfSeatSurvivalPackDiv").style.display='inline';
	}else{
		document.getElementById("typeOfSeatSurvivalPackDiv").style.display='none';
	}

	if(document.getElementById('typeOfSeat').value == 'Cushion'){
	  	document.getElementById("typeOfSeatCushionDiv").style.display='inline';
	}else{
		document.getElementById("typeOfSeatCushionDiv").style.display='none';
	}

	if(document.getElementById('typeOfSeat').value == 'anyUnofficialModsNoted'){
	  	document.getElementById("typeOfSeatNotedDiv").style.display='inline';
	}else{
		document.getElementById("typeOfSeatNotedDiv").style.display='none';
	}

}

function showSeatFiring(){
	if(document.getElementById('seatFiring').value == 'Alernative'){
	  	document.getElementById("seatFiringAlernativeDiv").style.display='inline';
	}else{
		document.getElementById("seatFiringAlernativeDiv").style.display='none';
	}

	if(document.getElementById('seatFiring').value == 'Difficulty'){
	  	document.getElementById("seatFiringDifficultyDiv").style.display='inline';
	}else{
		document.getElementById("seatFiringDifficultyDiv").style.display='none';
	}



}
function showControllerDrogude(){
	if(document.getElementById('controllerDrogude').value == 'Failure'){
	  	document.getElementById("controllerDrogudeDiv").style.display='inline';
	}else{
		document.getElementById("controllerDrogudeDiv").style.display='none';
	}




}
function showStabilisingDrogude(){
	if(document.getElementById('stabilisingDrogude').value == 'Failure'){
	  	document.getElementById("stabilisingDrogudeDiv").style.display='inline';
	}else{
		document.getElementById("stabilisingDrogudeDiv").style.display='none';
	}

}
function showDescentBeforeSeparationOne(){
	if(document.getElementById('descentBeforeSeparationOne').value == 'consciousLost'){
	  	document.getElementById("descentBeforeSeparationOneDiv").style.display='inline';
	}else{
		document.getElementById("descentBeforeSeparationOneDiv").style.display='none';
	}

}
function showScissorShackle(){
	if(document.getElementById('scissorShackle').value == 'Failure'){
	  	document.getElementById("scissorShackleDiv").style.display='inline';
	}else{
		document.getElementById("scissorShackleDiv").style.display='none';
	}

}
function showHeadRest(){
	if(document.getElementById('headRest').value == 'Failure'){
	  	document.getElementById("headRestDiv").style.display='inline';
	}else{
		document.getElementById("headRestDiv").style.display='none';
	}

}
function showSeatHarness(){
	if(document.getElementById('seatHarness').value == 'Failure'){
	  	document.getElementById("seatHarnessDiv").style.display='inline';
	}else{
		document.getElementById("seatHarnessDiv").style.display='none';
	}

}

function showSeparationManual(){
	if(document.getElementById('separationManual').value == 'Failure'){
	  	document.getElementById("separationManualDiv").style.display='inline';
	}else{
		document.getElementById("separationManualDiv").style.display='none';
	}

}


function showEmergencyOverrideUsed(){
	if(document.getElementById('emergencyOverrideUsed').value == 'inadvertentUse'){
	  	document.getElementById("emergencyOverrideUsedDiv").style.display='inline';
	}else{
		document.getElementById("emergencyOverrideUsedDiv").style.display='none';
	}

}


function showSeparationEmergency(){
	if(document.getElementById('separationEmergency').value == 'Failure'){
	  	document.getElementById("separationEmergencyDiv").style.display='inline';
	}else{
		document.getElementById("separationEmergencyDiv").style.display='none';
	}

}


</script>



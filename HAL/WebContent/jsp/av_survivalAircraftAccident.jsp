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
<div class="titleBg">	

<h2>SURVIVAL FROM AN AIRCRAFT ACCIDENT</h2> </div>
<div class="clear"></div>
<form name="survivalAircraftAccident" action="" method="post">

<div class="clear paddingTop15"></div>
<div class="Block">
<label>Service No.<span>*</span></label>
<input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO %>" value="" title="Enter Service No" tabindex="1" validate="Service No,metachar,yes" maxlength="20"  
onblur="submitProtoAjaxWithDivName('survivalAircraftAccident','/hms/hms/aviationMedicine?method=getServiceNoDetailsForRegEquipmentInUse&serviceNo='+this.value,'patientDiv');" />
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
<h4>Part I - Water Casualty</h4>
<div class="Block">
<select name="waterCasualty" id="waterCasualty">
				<option value="d">Ditching</option>
				<option value="e">Parachute Escape</option>
				<option value="u">Rescue Services Used</option>
				<option value="n">Rescue Services Not Used</option>
				<option value="r">Casualty Not Recovered</option>
				<option value="c">Casualty Recovered</option>
				
</select>

<div class="clear"></div>
<label class="">Uninjured</label>
<input tabindex="1" type="text"	name="uninjured" maxlength="30" value="" />


<label class="">Injured</label>
	<input tabindex="1" type="text"	name="injured" maxlength="30" value="" />


<label class="">Dead</label>
	<input tabindex="1" type="text"	name="dead" maxlength="30" value="" />
</div>

	
<div class="clear paddingTop15"></div>
<h4>Condition Of Escape</h4>
<div class="Block">

<label class="large">Escape/Ditching Witnessed</label>
<select name="escapeDitchingWitnessed" id="escapeDitchingWitnessed" >
				<option value="a">From Air</option>
				<option value="g">From Ground</option>
				<option value="s">From Shore</option>
				<option value="w">Not Witnessed</option>
				<option value="k">Not Known</option>
				
</select>
<div class="clear"></div>
<label class="large">Descent Into Seat</label>
<select name="descentIntoSeat" id="descentIntoSeat" >
	<option value="w">Witnessed</option>
	<option value="n">Not Witnessed</option>
				
</select>
<div class="clear"></div>
<label class="large">Witnessed</label>
	<input tabindex="1" type="checkbox"	name="witnessedChk" maxlength="1" class="radioAuto" value="y" />
	
	<div class="clear"></div>
	
<label class="large">Maintained Contact</label>
	<input tabindex="1" type="checkbox"	name="maintainedContactChk" class="radioAuto" maxlength="1" value="y" />

<div class="clear"></div>

<label class="large">Lost Contact After</label>
<input tabindex="1" type="text"	name="lostContactAfter" maxlength="1" value="" />
<label class="unit">mins</label>



<div class="clear"></div>

<label class="large">Condition of Subject When Last seen By Witness</label>
<input tabindex="1" type="text"	name="conditionSubjectLastSeenWitness" maxlength="30" value="" />
<div class="clear"></div>
<label class="large">Time of Escape/Ditching</label>
<input tabindex="1" type="text"	name="timeEscapeDitchingTxt" maxlength="10" value="" />
<select name="timeOfEscapeDitching" id="timeOfEscapeDitching" >
				<option value="e">Estimated</option>
				<option value="a">Accurate</option>
</select>
</div>

<div class="clear paddingTop15"></div>
<h4>Notification</h4>
<div class="Block">
<label>R/T Call Before Inident</label>
<select name="rTCallBeforeInident" id="rTCallBeforeInident" >
				<option value="n">Not Made</option>
				<option value="m">Made</option>
				
</select>

<label>Substance Of Call</label>
<input tabindex="1" type="text"	name="substanceOfCall" maxlength="30" value="" />


<label>Notification From Witness</label>
<input tabindex="1" type="text"	name="notificationWitness" maxlength="1" value="" />

<div class="clear"></div>

<label>No Delay</label>
<input tabindex="1" type="checkbox"	name="noDelay" maxlength="1" value="" />

<label>After</label>
<input tabindex="1" type="text"	class="auto" size="17" name="after" maxlength="1" value="" />
<label class="unit">mins</label>




<label>Overdue Action Taken At</label>
<input tabindex="1" type="text"	class="auto" size="20" name="overdueActionTakenAt" maxlength="30" value="" />
<label class="auto">hrs</label>


<div class="clear"></div>

<label>Other Notificaton</label>
<input tabindex="1" type="text"	name="otherNotificaton" maxlength="1" value="" />

</div>
<div class="clear paddingTop15"></div>
<h4>Climatic Data</h4>
<div class="Block">

<label>Sea</label>
<select name="sea" id="sea" >
				<option value="f">Fresh Water</option>
				<option value="l">Location</option>
				<option value="o">Open Sea</option>
</select>

<label>Shallow Depth</label>

<input tabindex="1" type="text"	name="shallowDepth" maxlength="30" value="" />


<label>Distance From Shore</label>

<input tabindex="1" type="text"	name="distanceFromShore" maxlength="30" value="Not Known" />

<div class="clear"></div>

<label class="large">Distance From Nearsest Ship or Nearest known Ship</label>

<input tabindex="1" type="text" class="auto" size="24"	name="distanceNearsestShip" maxlength="30" value="Not Known" />

<div class="clear"></div>
<label>Wind</label>

<input tabindex="1" type="text"	name="wind" class="auto" size="18" maxlength="30" value="Not Known" />
<label class="unit">kts</label>



<label>From</label>
<input tabindex="1" type="text"	name="fromWind" maxlength="30" value="Not Known" />

<select name="windList" id="windList" >
				<option value="s">Surface</option>
				<option value="s">Calm</option>
				<option value="h">Choppy</option>
				<option value="r">Rough</option>
				<option value="k">Not Known</option>
						
</select>
<div class="clear"></div>

<label>Water Temp</label>

<input tabindex="1" type="text"	class="auto" size="18" name="waterTemp" maxlength="30" value="Not Known" />

<label class="unit">F</label>

<div class="clear"></div>

<label>Air Temp, at sea level</label>

<input tabindex="1" type="text"	class="auto" size="18" name="airTempAtSeaLevel" maxlength="30" value="Not Known" />
<label class="unit">F</label>



<select name="clouds" id="clouds" onchange="showClouds();" >
				<option value="f">Fine</option>
				<option value="c">Clouds</option>
				<option value="r">Rain Heavy</option>
				<option value="l">Rain Light</option>
				<option value="h">Hail</option>
				<option value="s">Snow</option>
						
</select>


<div id="cloudsDiv" style="display: none" >

<input tabindex="1" type="text"	 name="cloudAt" class="auto" size="15" maxlength="30" value="Not Known" />
<label class="unit">At</label>
<input tabindex="1" type="text"	name="cloudFt" class="auto" size="17"  maxlength="30" value="Not Known" />
<label class="unit">ft</label>
</div>

<div class="clear"></div>
<label>Visibility At Sea Level</label>

<input tabindex="1" type="text"	class="auto" size="18" name="visibilityAtSeaLevel" maxlength="30" value="Not Known" />
<label class="unit">yds</label>

<div class="clear"></div>

<label>Vertical Visibility From Air</label>

<input tabindex="1" type="text" class="auto" size="18"	name="verticalVisibilityFromAir" maxlength="30" value="Not Known" />
<label class="unit">ft</label>


</div>


<div class="clear paddingTop15"></div>
<h4>Clothing And Equipment</h4>
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<TH scope="col">Item</TH>
		<TH scope="col">Mark</TH>
		<TH scope="col">Status</TH>
		<TH scope="col">Describe Briefly Efficient Of article</TH>
	</tr>
	<tr>
		<td>Immersion Suit</td>
		<td>
			<input tabindex="1" type="text"	name="immersionSuitMark" maxlength="30" value=""/>
		</td>
			<td>
			<select name="immersionStatus">
				<option value="w">Worn</option>
				<option value="n">Not Worn</option>
			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="immersionDetails" maxlength="30" value=""/>
		</td>
		
		</tr>
		<tr>
				<td>Exposure Suit</td>
					<td>
			<input tabindex="1" type="text"	name="exposureMark" maxlength="30" value=""/>
				
		</td>
		<td>
			<select name="exposureStatus">
				<option value="p">Provied</option>
				<option value="u">Used</option>
				<option value="n">Not Used</option>
				<option value="o">Not Provied</option>	
			</select>
			
		</td>
		<td>
			<input tabindex="1" type="text"	name="exposureDescribe" maxlength="30" value=""/>
		</td>
		</tr>
		
		<tr>
		<Td>Life Jacket</Td>
			<td>
			<input tabindex="1" type="text"	name="lifeJacketMark" maxlength="45" value=""/>
		</td>
				<td>
			<select name="lifeJacketStatus">
				<option value="w">Worn</option>
				<option value="n">Not Worn</option>
				<option value="a">Activated</option>
				<option value="t">Not Activated</option>	
			</select>
		</td>
		<td>
			<input tabindex="1" type="text"	name="lifeJacketDescribe" maxlength="30" value=""/>
		</td>
		</tr>
	</table>
	</div>
	
	<div class="clear paddingTop15"></div>

<div class="Block">
<label>Dinghy</label>
<select name="dinghy" id="dinghy" class="small">
				<option value="p">Provied</option>
				<option value="u">Used</option>
				<option value="n">Not Used</option>
				<option value="v">Not Provied</option>	
				<option value="k">Not Known</option>
						
</select>

<input class="transparent" size="10" />


<select name="dinghyOne" id="dinghyOne" onchange="showDinghyOne();">
				<option value="a">Activated</option>
				<option value="n">Not Activated</option>	
				<option value="k">Not Known</option>
				<option value="d">Difficulty</option>		
</select>

<div id="dinghyOneDiv" style="display: none" >
<label class="large">Detail Any Diffculty Assoiated With Activation</label>
<input tabindex="1" type="text" class="auto" size="20"	name="detailDiffcultyWithActivation" maxlength="30" value="Not Known" />

		</div>
		<div class="clear"></div>	
<label class="large">Inflatable Floor</label>
		<select name="inflatableFloor" id="inflatableFloor" >
				<option value="u">Used</option>
				<option value="n">Not Used</option>
				<option value="p">Not Provied</option>	
				<option value="k">Not Known</option>
		</select>
		
<div class="clear"></div>
		
		<label class="large">Any Comments on boarding, use, serviceability defects etc.</label>
			<textarea rows="" cols=""	name="commentBoarding" class="" onkeyup="chkLength(this,100);"></textarea>
			</div>
	
		<div class="clear paddingTop15"></div>
<h4>Diet</h4>
<div class="Block">
<label>Ration</label>
	<select name="ration" id="ration" class="small">
				<option value="n">Not Provied</option>	
				<option value="k">Not Known</option>
		</select>
		<label>Type</label>
		<input tabindex="1" type="text"	name="rationtype" maxlength="1" value="" />
		
			<select name="rationOne" id="rationOne" onchange="showRationOne();" class="small">
			<option value="u">Used</option>
			<option value="n">Not Used</option>
		</select>
		
<div id="rationOneDiv" style="display: none" >
<label>Detail</label>
<input tabindex="1" type="text"	name="rationDetail" maxlength="30" value="Not Known" />

		</div>
		
		
			<div class="clear"></div>
		<label>Water Avaiable</label>
	
	<select name="waterAvaiable" id="waterAvaiable" class="small">
				<option value="n">Not Provied</option>	
				<option value="w">In Water Cushion</option>
				<option value="c">In Cans</option>
		</select>
		<label>Quantity</label>
		<input tabindex="1" type="text"	name="quantity" maxlength="30" value="" />
		
			<select name="waterAvaiableOne" id="waterAvaiableOne" onchange="showWaterAvaiableOne();" class="small">
			<option value="u">Used</option>
				<option value="n">Not Used</option>
		</select>
		
		<div id="waterAvaiableOneDiv" style="display: none" >
<label class="auto">Detail</label>
<input tabindex="1" type="text"	name="saterUsedValue" maxlength="10" value="" />

		</div>
		
		
		<div class="clear"></div>
		<label>Water Obtained</label>
		<select name="waterObtained" id="waterObtained" class="small" onchange="showWaterObtained();">
				<option value="d">By Distillation</option>	
				<option value="s">By Solar Stilln</option>
				<option value="r">By Rain Collection</option>
		</select>
	<div id="byDistillationDiv" style="display: none" >

<input tabindex="1" class="auto" size="18" type="text"	name="byDistillationPints" maxlength="30" value="Not Known" />
<label class="auto">pints</label>
		</div>
		<div id="bySolarStillDiv" style="display: none" >
<input tabindex="1" class="auto" size="18" type="text"	name="bySolarStillPints" maxlength="30" value="Not Known" />
<label class="auto">pints</label>
		</div>
		<div id="byRainCollectionDiv" style="display: none" >
<input tabindex="1" class="auto" size="18" type="text"	name="byRainCollectionPints" maxlength="30" value="Not Known" />
<label class="auto">pints</label>
		</div>
		
<label class="large">Food Obtained From Natural Sources</label>
<input tabindex="1" type="text"	name="foodNaturalSources" maxlength="30"  />
		
	</div>

<div class="clear paddingTop15"></div>
<h4>Rescue Calls</h4>
<div class="Block">
<label>Radio Aids</label>
	<select name="radioAids" id="radioAids" class="small">
				<option value="n">Not Provied</option>	
				<option value="k">Not Known</option>
		</select>
		<label>Type</label>
		<input tabindex="1" type="text"	name="radioAidsType" maxlength="30" value="" />
		
			<select name="radioAidsOne" id="radioAidsOne"  class="small">
			<option value="u">Used</option>
				<option value="n">Not Used</option>
					<option value="k">Not Known</option>
		</select>
			<div class="clear"></div>
		<label class="large">Briefly Describe Efficiency Of Item</label>
<input tabindex="1" type="text"	class="auto" size="12" name="describeEfficiencyItem" maxlength="30"  />
	
	
	<div class="clear"></div>
	
	<label>Rescuers Contacted By</label>
	<select name="rescuersContactedBy" id="rescuersContactedBy" class="small" onchange="showRescuersContactedBy();">
				<option value="h">Heliograph</option>	
				<option value="l">Light</option>
				<option value="f">Flare</option>
				<option value="v">Voice</option>
				<option value="o">Other</option>
		</select>
		<div id="rescuersContactedByDiv" style="display: none" >
		<label class="">Detail</label>
<input tabindex="1" type="text"	name="rescuersContactedByDetail" maxlength="30" value="" />
</div>
</div>

<div class="clear paddingTop15"></div>
<h4>Rescue By Helicopter</h4>
<div class="Block">
<label>Helicopter Type</label>
<select>
<option value="helicopterType"></option>
</select>

<label>Mark</label>
<input tabindex="1" type="text"	name="helicopterMark" maxlength="30" value="" />

<div class="clear"></div>
<label>No Contact Made</label>
<input tabindex="1" type="checkbox"	name="helicopterNoContactMade" maxlength="1" value="" />

<label>Casualty Located At</label>
<input tabindex="1" type="text"	class="auto" size="17" name="casualtyLocatedAt" maxlength="30" value="" />
<label class="unit">hrs.</label>

	<div class="clear"></div>

<label>Casualty Maintained</label>
<input tabindex="1" type="checkbox"	name="casualtyMaintained" maxlength="1" value="" />

<label>Contact Lost At</label>
<input tabindex="1" type="text"	class="auto" size="17"  name="casualtyLostAt" maxlength="30" value="" />
<label class="unit">hrs.</label>



<label class="">Casualty Regained At</label>
<input tabindex="1" type="text"	class="auto" size="18"  name="casualtyRegainedAt" maxlength="1" value="" />
<label class="unit">hrs.</label>

	<div class="clear"></div>
<label>Rescued By</label>
	<select name="helicopterRecusedBy" id="rescuedBy" class="" onchange="showRescueBy();">
				<option value="s">Strap Lift</option>	
				<option value="n">Net</option>
				<option value="t">Two Man Lift</option>
				<option value="o">Other</option>
	</select>
	<div id="rescuedByDiv" style="display: none" >
		<label class="">Specify</label>
<input tabindex="1" type="text"	name="rescuedBySpecify" maxlength="30" value="" />
	</div>
	
	<div class="clear"></div>
	
	<label>Rescued</label>
	<input tabindex="1" type="text"	name="rescued" maxlength="30" value="" />
<label class="">mins. After Contact</label>



<label class="">Not Rescued</label>
<input tabindex="1" type="checkbox"	class="radioAuto" name="notRescued" maxlength="1" value="" />
	
		<div class="clear"></div>
<label class="large">Detail any Difficulties Assoiated With the Operation</label>
<input tabindex="1" type="text"	name="detail_assosiate_operation" maxlength="100" value="" />
	
</div>



<div class="clear paddingTop15"></div>
<h4>Rescue By Surface Vessel</h4>
<div class="Block">
<label>Type of Vessel</label>
<select>
<option value="typeOfVessel"></option>
</select>

	<div class="clear"></div>
<label>No Contact Made</label>
<input tabindex="1" type="checkbox"	name="vesselNoContactMade" maxlength="1" value="" />

<label>Casualty Located At</label>
<input tabindex="1" type="text"	class="auto" size="17"  name="vesselCasualtyLocatedAt" maxlength="30" value="" />
<label class="unit">hrs.</label>

<div class="clear"></div>

<label>Casualty Maintained</label>
<input tabindex="1" type="checkbox"	name="vesselCasualtyMaintained" maxlength="1" value="" />

<label>Contact Lost At</label>
<input tabindex="1" type="text" class="auto" size="17" 	name="vesselCasualtyLostAt" maxlength="30" value="" />
<label class="unit">hrs.</label>

<label class="">Casualty Regained At</label>
<input tabindex="1" type="text"	class="auto" size="18" name="vesselCasualtyRegainedAt" maxlength="1" value="" />
<label class="unit">hrs.</label>

	<div class="clear"></div>
<label>Rescued By</label>
	<select name="vessel_recused_by" id="rescuedByOne" class="" onchange="showRescueByOne();">
				<option value="s">Strap Lift</option>	
				<option value="n">Net</option>
				<option value="m">Two Man Lift</option>
				<option value="o">Other</option>
	</select>
	<div id="rescuedByOneDiv" style="display: none" >
<label class="">Specify</label>
<input tabindex="1" type="text"	name="vesselRescuedBySpecify" maxlength="30" value="" />
	</div>
	
	<div class="clear"></div>
	
	<label>Rescued</label>
	<input tabindex="1" type="text"	name="surfaceVesselRescued" maxlength="30" value="" />
<label class="">mins. After Contact</label>


<label class="">Not Rescued</label>
<input tabindex="1" type="checkbox"	class="radioAuto" name="surfaceVesselNotRescued" maxlength="1" value="" />
	
		<div class="clear"></div>
<label class="large">Detail any Difficulties Assoiated With the Operation</label>
<input tabindex="1" type="text"	name="surfaceVesselNotRescuedDetail" maxlength="100" value="" />

</div>

<div class="clear paddingTop15"></div>
<h4>Rescue By Other Means</h4>
<div class="Block">
<label class="auto">Detail Any Rescue Operation Other Than Described In Paras 13 & 14 Above</label>
<textarea rows="" cols="60"	name="detailRescueOperation1314" class="auto" onkeyup="chkLength(this,200);"></textarea>


</div>

<div class="clear paddingTop15"></div>
<h4>Rescue Of Operation</h4>
<div class="Block">
<h4>Success</h4>

<label class="large">Casualty Reached</label>
	<select name="casualtyReached" id="casualtyReached" class="" >
				<option value="e">Rescue Craft</option>	
				<option value="s">Shore Unassisted</option>
				<option value="a">Assisted</option>
	</select>
	
<div class="clear"></div>
	
<label class="large">Total Time in Water not in Dinghy</label>
<input tabindex="1" type="text"	name="totalTimeInWaterNotDinghy" maxlength="30" value="Not Known" />

<div class="clear"></div>

<label class="large">Total Time in Dinghy</label>
<input tabindex="1" type="text"	name="totalTimeInDinghy" maxlength="30" value="Not Known" />


<div class="clear"></div>

<h4>Failure</h4>
	
<label class="large">Search Abandoned At</label>
<input tabindex="1" type="text"	class="auto" size="18" name="failureSearchAbandonedAt" maxlength="30" value="Not Known" />
<label class="unit">hrs.</label>

<div class="clear"></div>

<label class="large">Rescue Abandoned At</label>
<input tabindex="1" type="text"	 class="auto" size="18" name="failureRescueAbandonedAt" maxlength="30" value="Not Known" />
<label class="unit">hrs.</label>

<div class="clear"></div>

<label class="large">Describe Cause Of Failure</label>
<textarea rows="" cols=""	name="describeCauseOfFailure" class="" onkeyup="chkLength(this,100);"></textarea>

</div>

<div class="clear paddingTop15"></div>

<div class="Block">
<label class="large">Condition Of Cascualty On Rescue</label>
<select class="" id="conditionOfCascualtyOnRescue" name="conditionOfCascualtyOnRescue">
<option value="f">Fully Fit </option>
<option value="c">Conscious </option>
<option value="u">Unconscious </option>
<option value="d">Dead </option>

</select>


<div class="clear"></div>

<label class="large">Character And Degree Of Effect Of Exposure</label>
<input tabindex="1" type="text"	name="characterDegreeEffectExposure" maxlength="30" value="" />

<div class="clear"></div>

<label class="large">Effect Of Injuries Sustained in Accident</label>
<input tabindex="1" type="text"	name="effectInjuriesSustainedAccident" maxlength="30" value="" />

<div class="clear"></div>

<label class="large">Condition Static</label>

	<select name="conditionStatic" id="conditionStatic" class="" >
				<option value="i">Improved</option>	
				<option value="d">Deteriorated</option>
				<option value="r">Died on return Journey</option>
	</select>
	
	<div class="clear"></div>
	<label>Reached</label>

	<select name="reached" id="reached" class="small" >
				<option value="q">Sick Quarter</option>	
				<option value="b">Sick Bay</option>
			</select>
			<label class="auto">hospital At</label>
<input tabindex="1" type="text"	class="auto" size="16" name="hospitalAt" maxlength="30" value="" />
<label class="unit">hrs.</label>

<div class="clear"></div>

<label class="large">Treatment Given On Rescue Craft(detail)</label>
<input tabindex="1" type="text"	name="treatmentRescueCraft" maxlength="50" value="" />
		
</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label class="large">Swimming Ability</label>
<select id="swimmingAbility" name="swimmingAbility">
<option value="s">Non Swimmer </option>
<option value="w">Strong Swimmer </option>
<option value="a">Average Swimmer </option>
<option value="p">Poor Swimmer </option>
<option value="k">Not Known </option>

</select>

</div>
<div class="clear paddingTop15"></div>
<h4>Training</h4>
<div class="Block">
<label class="large">Date Of Last Dinghy/Ditching Drill</label>
<input	tabindex="1" name="dateLastDinghy" class="date"	 maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	class="calender"	onclick="setdate('',survivalAircraftAccident.dateLastDinghy,event);" />

<div class="clear"></div>

<label class="large">Describe Any Previous Traning or Actual Ditching With Dates</label>
<input tabindex="1" type="text"	name="detail_prevs_ditching" maxlength="50" value="" />
<input	tabindex="1" name="date_actual_ditching" class="date"	 maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	class="calender"	onclick="setdate('',survivalAircraftAccident.date_actual_ditching,event);" />

	<div class="clear"></div>
	
	
<label class="large">Annotate N/A Where Not Applicable</label>
<input tabindex="1" type="text"	name="annotateNA" maxlength="30" value="" />
	
</div>

<div class="clear paddingTop15"></div>
<h4>Part II - Land Casualty </h4>
<div class="Block">
<select class="" id="landCasualty" name="landCasualty">
<option value="l">Crash Landing </option>
<option value="e">Parachute Esacpe </option>
<option value="k">Not Known </option>
</select>


<div class="clear"></div>

<label class="">Uninjuried</label>
<input tabindex="1" type="text"	name="landUninjuried" maxlength="30" value="" class="auto" size="11"/>

<label class="">Injuried</label>
<input tabindex="1" type="text"	name="landInjuried" maxlength="30" value="" class="auto" size="11"/>


<label class="">Dead</label>
<input tabindex="1" type="text"	name="landCasualtyDead" maxlength="30" value="" class="auto" size="11"/>


<label class="">Missing</label>
<input tabindex="1" type="text"	name="landCasualtyMissing" maxlength="30" value="" class="auto" size="11"/>

</div>



<div class="clear paddingTop15"></div>
<h4>Conditions Of Escape</h4>
<div class="Block">
<select id="conditionsOfEscape" name="conditionsOfEscape">

<option value="e">Escape/Landing Witness</option>
<option value="l">From Land From Air, Not Withnessed</option>
<option value="k">Not Known</option>

</select>

<div class="clear"></div>

<label class="">Witness</label>
<input tabindex="1" type="text"	name="conditionsOfEscapeWithness" maxlength="10" value="" class="" size=""/>

<label class="">Maintained Contact</label>
<select class="" id="conditionsOfEscape"  name="land_maintain_cntct">

<option value="y">Yes</option>
<option value="n">No</option>


</select>


<label>Lost Contact At</label>
<input tabindex="1" type="text"	name="land_lost_contact_min" maxlength="30" value="" class="auto" size="18" />
<label class="unit">mins.</label>

	<div class="clear"></div>
	
	<label class="large">Condition Of Subject When Last seen by Witness</label>
<input tabindex="1" type="text"	name="conditionOfSubject" maxlength="30" value="" class="" size=""/>
	<div class="clear"></div>
	<label class="large">Time Of Escape/Landing</label>
<input tabindex="1" type="text"	name="time_escape_landing" maxlength="10" value="" class="" size=""/>
<select class="" name="time_escape_landing2" id="time_escape_landing2">

<option value="e">Estimated</option>
<option value="a">Accurate</option>
</select>
</div>


<div class="clear paddingTop15"></div>
<h4>Notifications Of Escape</h4>
<div class="Block">
<label>R/T Call Before Incident</label>
<select id="rTCallBeforeIncident" name="rTCallBeforeIncident">

<option value="n">Not Made</option>
<option value="m">Made</option>


</select>

	<label> Substance of Call</label>
<input tabindex="1" type="text"	name="substanceOfCall" maxlength="30" value="" class="" size=""/>



<label class="">Notification From Witness</label>
<select id="notificationFromWithness();" name="notificationFromWithness();" onchange="showNotificationFromWithness();">

<option value="n">No Delay</option>
<option value="a">After</option>


</select>

<div id="notificationFromWithnessDiv" style="display: none" >
	
<input tabindex="1" type="text"	name="notificationFromWithnessMins" maxlength="10" value="" />
	<label class="unit">mins.</label>
	</div>
	
		<div class="clear"></div>
	<label>Overdue Action Taken At</label>
<input tabindex="1" type="text"	name="overdueActionTakenAt" maxlength="30" value="" class="auto" size="17"/>
<label class="unit">hrs.</label>

	
<label>Other Notifications</label>
<input tabindex="1" type="text"	name="otherNotifications" maxlength="1" value="" />

</div>


<div class="clear paddingTop15"></div>
<h4>Climatic Data</h4>
<div class="Block">
<label>Terrain</label>
<select id="land_terrain" name="terrain" onchange="showTerrain();">

<option value="m">Marsh</option>
<option value="s">Swamp</option>
<option value="d">Desert</option>
<option value="f">Forest</option>
<option value="w">Wooded</option>
<option value="p">Plain</option>
<option value="m">Mountainous</option>
<option value="i">Ice Snowy</option>
<option value="o">Other</option>


</select>
<div id="terrainForLandingDiv" style="display: none" >
		<label>Specify</label>
<input tabindex="1" type="text"	name="terrainSpecify" maxlength="50" value="" />
</div>

<label>Location</label>
<input tabindex="1" type="text"	name="terrainLocation" maxlength="30" value="" />

<div class="clear"></div>
<label>Temperature : Day</label>
<input tabindex="1" type="text"	name="temperature_day" maxlength="6" value="" class="auto" size="17" />
	<label class="unit">F</label>
	
		<label>Night</label>
<input tabindex="1" type="text"	name="temperature_night" maxlength="6" value="" class="auto" size="17" />
	<label class="unit">F</label>
	
	<select name="temperature_measure" id="temperature_measure" >
				<option value="e">Estimated</option>
				<option value="m">Measured</option>
</select>
		<div class="clear"></div>
<label>Humdity</label>
<select name="humdity" id="humdity" >
<option value="h">High</option>
<option value="m">Moderate</option>
<option value="l">Low</option>

</select>


<label>Precipitation</label>
<select name="precipitation" id="precipitation" >
<option value="n">None</option>
<option value="r">Rain</option>
<option value="s">Snow</option>
<option value="h">Hail</option>
<option value="l">Sleet</option>
<option value="k">Not Known</option>
</select>

<select name="precipitationOne" id="precipitationOne" >
<option value="l">Light</option>
<option value="h">Heavy</option>
				<option value="v">VeryHeavy</option>
				<option value="k">Not Known</option>
				
</select>
		<select name="precipitationTwo" id="precipitationTwo" >
				<option value="c">Continous</option>
				<option value="r">Rain</option>
				<option value="i">Intermittent</option>
				<option value="k">Not Known</option>
				
</select>

<div class="clear"></div>
<label class="large" >Vertical Visbility From Air Ft</label>
<input tabindex="1" type="text"	name="land_vertical_visibility" maxlength="30" value="Not Known" class="auto" size="24" />

</div>

<div class="clear paddingTop15"></div>
<h4>Survival Kits</h4>
<div class="Block">
<h4>Personal Kit</h4>
<label>Type</label>
<input tabindex="1" type="text"	name="personalKit" maxlength="30" value="" />
<select name="personalKitType" id="personalKitType" >
				<option value="n">Not Carried</option>
				<option value="c">Carried</option>
				<option value="l">Lost</option>
				<option value="r">Retrieved</option>
				
</select>

<h4>Aircraft Survival Kit</h4>
<label>Type</label>
<input tabindex="1" type="text"	name="survivalKit" maxlength="30" value="" />
<select name="personalKitType" id="survivalKitType" >
				<option value="n">Not Carried</option>
				<option value="c">Carried</option>
				<option value="l">Lost</option>
				<option value="r">Retrieved</option>
				
</select>



<div class="clear"></div>
<label class="large" >Describe Items Used And Found Of Value</label>
<input tabindex="1" class="auto" size="25" type="text"	name="item_used_found" maxlength="30" value="" />


<div class="clear"></div>
<label class="large" >Detail Items Not Used</label>
<input tabindex="1" class="auto" size="25" type="text"	name="item_not_used" maxlength="30" value="" />


<div class="clear"></div>
<label class="large" >Deatil Items, Not Provided Which Would Have Been Of Value</label>
<input tabindex="1" class="auto" size="25" type="text"	name="item_not_provide" maxlength="30" value="" />

<div class="clear"></div>
<h4>First Aid Kits</h4>

<label>Mark</label>
<input tabindex="1" type="text"	name="first_aid_mark" maxlength="30" value="" />

<select name="first_aid_mark_combo" id="first_aid_mark_combo" >
					<option value="n">Not Carried</option>
				<option value="c">Carried</option>
				<option value="l">Lost</option>
				<option value="r">Retrieved</option>
				
</select>



<div class="clear"></div>
<label class="large" >Describe Items Used And Any Deficiencies Noted</label>
<input tabindex="1" type="text"	class="auto" size="25" name="itemdeficiencie_noted" maxlength="30" value="" />


</div>



<div class="clear paddingTop15"></div>
<h4>Diet</h4>
<div class="Block">
<label>Ration</label>

<select name=landRation id="landRation" >
				<option value="n">Not Provided</option>
				<option value="p">Provided</option>
							
</select>
<select name="landRation2" id="rationTwo" onchange="showRationTwo();">
				<option value="n">Not Provided</option>
				<option value="p">Provided</option>
				
</select>


<div id="rationTwoDiv" style="display: none" >
		<label>Detail</label>
<input tabindex="1" type="text" class="auto" size="25" 	name="rationTwoDetail" maxlength="30" value="" />
</div>
<div class="clear"></div>
<label class="large" >Water Avaiable (Detail Quantity And Source)</label>
<input tabindex="1" type="text" class="auto" size="25" 	name="waterAvaiable" maxlength="1" value="" />


<div class="clear"></div>
<label class="large" >Purification Method</label>
<input tabindex="1" type="text"	class="auto" size="25"  name="purificationMethod" maxlength="30" value="" />


<div class="clear"></div>
<label class="large" >Food From Natural Source(Detail Quantity And Source)</label>
<input tabindex="1" type="text"	class="auto" size="25"  name="foodFromNaturalSource" maxlength="30" value="" />


</div>

<div class="clear paddingTop15"></div>
<h4>Mobility</h4>
<div class="Block">
<label>Fully Mobile</label>
<input tabindex="1" type="text"	name="fullyMobile" maxlength="10" value="" />


<label>Partially Incapacitated By</label>
<input tabindex="1" type="text"	name="partiallyIncapacitatedBy" maxlength="30" value="" />


<label>Objective</label>
<input tabindex="1" type="text"	name="objective" maxlength="30" value="" />


<label class="auto">Approximate Distance Covered</label>
<input tabindex="1" type="text"	class="auto" size="10"  name="approx_distance_cover" maxlength="30" value="" />
<label class="auto">in days</label>
<input tabindex="1" type="text"	class="auto" size="17" name="approx_distance_cover" maxlength="30" value="" />
<label class="unit">/hrs.</label>


<div class="clear"></div>

<label>Navigation</label>

<select name="navigation" id="navigation" >
				<option value="m">Map</option>
				<option value="c">Compass</option>
				<option value="s">Astro Sights</option>
				<option value="r">Random</option>
							
</select>



<label>Describe Any Difficulties</label>
<input tabindex="1" type="text"	name="any_difficulty" maxlength="30" value="" />


</div>


<div class="clear paddingTop15"></div>
<h4>Rescue Calls</h4>
<div class="Block">
<label>Radio Aids</label>

<select name="land_radio_ads" id="radioAids" class="">
				<option value="n">Not Provided</option>
				<option value="p">Provided</option>
				<option value="k">Not Known</option>
				<option value="o">Not Used</option>
				<option value="u">Used</option>
					<option value="c">Other Calls Used</option>
				
</select>

<select name="land_radio_other" id="radioAidsother" class="">
				<option value="f">Flare</option>
				<option value="s">Smoke</option>
				<option value="h">Heliograph</option>
				<option value="o">Other</option>
				<option value="k">Not Known</option>
				
</select>
<div class="clear"></div>

<label class="large">Briefly Describe Efficiency Of Item Used</label>
<input tabindex="1" type="text"	class="auto" size="25"  name="land_efficiency_item" maxlength="30" value="" />
</div>

<div class="clear paddingTop15"></div>
<h4>Location Of Cascualty</h4>
<div class="Block">

<label>By Radio Aid</label>
<input tabindex="1" class="auto" size="30"  type="text"	name="location_radio_ads" maxlength="30" value="" />


<select name="location_radio_combo" id="location_radio_combo" class="">
				<option value="a">Search From Air</option>
				<option value="c">Conventional</option>
				<option value="h">Heliograph</option>
				<option value="l">Land Party</option>
						
</select>


<div class="clear"></div>

<label class="large">Date And Time Located</label>

<input	tabindex="1" name="located_date" class="date"	 maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	class="calender"	onclick="setdate('',survivalAircraftAccident.located_date,event);" />

<input tabindex="1" type="text"	name="located_time" maxlength="10" value="Not located" />


<label class="large">Supplies Dropped(Detail Time And Content)</label>
<input tabindex="1" type="text"	name="supplies_dropped" maxlength="30" value="" />

</div>



<div class="clear paddingTop15"></div>
<h4>Rescue Of Casualty</h4>
<div class="Block">
<label>Land Party</label>
<input tabindex="1" type="text"	name="landParty" maxlength="30" value="" />


<label>Local Population</label>
<input tabindex="1" type="text"	name="localPopulation" maxlength="30" value="" />


<select name="localConvence" id="rescueOfCasualty" >
				<option value="h">Helicopter</option>
				<option value="a">Aircraft</option>
											
</select>
<div class="clear"></div>


<label>Helicopter/ Aircraft</label>
<input tabindex="1" type="text"	name="helicopter_aircraft" maxlength="30" value="" />


<label>Type</label>
<input tabindex="1" type="text"	name="heli_airt_type" maxlength="30" value="" />

<label>Mark</label>
<input tabindex="1" type="text"	name="heli_airt_mark" maxlength="30" value="" />

<div class="clear"></div>

<label>Landed Winch Rescue</label>
<input tabindex="1" type="text"	name="landed_rescue" maxlength="30" value="" />

<label>Dropped Instructions</label>
<input tabindex="1" type="text"	name="dropped_instructions" maxlength="30" value="" />


<label>Directed Land Party</label>
<input tabindex="1" type="text"	name="directedLandParty" maxlength="30" value="" />


<div class="clear"></div>



<h4>Success</h4>

<label>Reached by Rescuers</label>
<input	tabindex="1" name="reached_rscuers_date" class="date"	 maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	class="calender"	onclick="setdate('',survivalAircraftAccident.reached_rscuers_date,event);" />

<input tabindex="1" type="text"	name="reached_by_rescuers" maxlength="10" value="" />


<div class="clear"></div>

<label class="large">Casualty Reached Help Unassisted</label>
<input	tabindex="1" name="casualty_unassist_date" class="auto" size="18" 	 maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	class="calender"	onclick="setdate('',aircraftAccidentInvestigation.casualty_unassist_date,event);" />

<input tabindex="1" type="text"	name="casualty_unassist" maxlength="10" value="" />


<div class="clear"></div>

<h4>Failure</h4>
	
<label>Search Abandoned</label>
<input	tabindex="1" name="failure_search_date" class="date"	 maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	class="calender"	onclick="setdate('',survivalAircraftAccident.failure_search_date,event);" />

<input tabindex="1" type="text"	name="failure_search_land" maxlength="10" value="Not Known" />


<label>Rescue Abandoned </label>
<input	tabindex="1" name="dateRescueAbandoned" class="date"	 maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	class="calender"	onclick="setdate('',survivalAircraftAccident.dateRescueAbandoned,event);" />

<input tabindex="1" type="text"	name="rescue_abandoned_detail1" maxlength="10" value="Not Known" />


<div class="clear"></div>

<label class="">Describe Cause Of Failure</label>
<textarea rows="" cols="56"	name="cause_failure1" class="auto" onkeyup="chkLength(this,100);"></textarea>


</div>

<div class="clear paddingTop15"></div>
<h4>Condition Of Cascualty On Rescue</h4>
<div class="Block">
<select class="" id="conditionForFit" name="conditionForFit">
<option value="f">Fully Fit </option>
<option value="c">Conscious </option>
<option value="u">Unconscious </option>
<option value="d">Dead </option>

</select>

<div class="clear"></div>

<label class="large">Character And Degree Of Effect Of Exposure</label>
<input tabindex="1" type="text"	name="characterDegreeEffectExpLand" maxlength="30" value="" />

<div class="clear"></div>

<label class="large">Effect Of Injuries Sustained in Accident</label>
<input tabindex="1" type="text"	name="effectInjuriesAccident" maxlength="30" value="" />


<div class="clear"></div>

<label class="large">Injuries/Illnesses Contracted Between Accident and Rescue</label>
<input tabindex="1" type="text"	name="injuriBetAccidentRescue" maxlength="30" value="" />

<div class="clear"></div>

<label class="large">Treatment Given By Rescue</label>
<input tabindex="1" type="text"	name="treatmentByRecuse" maxlength="50" value="" />
		
<select class=""  name="conditionTreatmentByRecuse" id="conditionOfCascualtyOnRescue" 
onchange="showConditionOfCascualtyOnRescue();">
<option value="s">Admiited SSQ </option>
<option value="b">Sick Bay </option>
<option value="h">Hospital </option>
<option value="o">Other </option>

</select>	
		
<div id="conditionOfCascualtyOnRescueDiv" style="display: none" >
<label>Specify</label>
<input tabindex="1" type="text"	name="conditionCascualtySpecify" maxlength="30" value="" />
</div>


<input	tabindex="1" name="dateTreatmentByRecuse" class="date"	 maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	class="calender"	onclick="setdate('',survivalAircraftAccident.dateTreatmentByRecuse,event);" />

<div class="clear"></div>
<label class="large">Approximate Weight Loss</label>
<input tabindex="1" type="text"	name="ApproxWeightLoss" maxlength="10" value="" />
			
</div>

<div class="clear paddingTop15"></div>
<h4>Training</h4>
<div class="Block">

<label class="auto">Detail Nature And Date Of Any Survival Taining Course Or Exercise With Comments On Their Value</label>
<textarea rows="" cols="40"	name="trainingDetailNature" class="auto" onkeyup="chkLength(this,100);"></textarea>
<input	tabindex="1" name="dateOfSurvival" class="date"	 maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	class="calender"	onclick="setdate('',survivalAircraftAccident.dateOfSurvival,event);" />

</div>
<input tabindex="1"  type=button value="Submit" class=button  accessKey=r  name="Submit11"
onclick="submitForm('survivalAircraftAccident','/hms/hms/aviationMedicine?method=submitSurvivalAircraftAccident&flag=survival');"  />
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


function showEffectivenessOfLandingTwo()
{
	if(document.getElementById('effectivenessOfLandingTwo').value == 'Difficulty'){
	  	document.getElementById("effectivenessOfLandingTwoDiv").style.display='inline';
	}else{
		document.getElementById("effectivenessOfLandingTwoDiv").style.display='none';
	}

	
}

function showEffectivenessText()
{
	if(document.getElementById('effectivenessText').value == 'Dargged'){
	  	document.getElementById("effectivenessTextDiv").style.display='inline';
	}else{
		document.getElementById("effectivenessTextDiv").style.display='none';
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
function showAutomatic(){
	if(document.getElementById('automatic').value == 'Failure'){
	  	document.getElementById("automaticDiv").style.display='inline';
	}else{
		document.getElementById("automaticDiv").style.display='none';
	}

}


function showManualOperationRequired(){
	if(document.getElementById('manualOperationRequired').value == 'Failure'){
	  	document.getElementById("manualOperationRequiredDiv").style.display='inline';
	}else{
		document.getElementById("manualOperationRequiredDiv").style.display='none';
	}

}
function showTypeOfModification(){
	if(document.getElementById('typeOfModification').value == 'Damaged'){
	  	document.getElementById("typeOfModificationDiv").style.display='inline';
	}else{
		document.getElementById("typeOfModificationDiv").style.display='none';
	}

}
function showTypeOfModificationOne(){
	if(document.getElementById('typeOfModificationOne').value == 'Difficulty'){
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
	if(document.getElementById('ejection').value == 'Other'){
	  	document.getElementById("ejectionDiv").style.display='inline';
	}else{
		document.getElementById("ejectionDiv").style.display='none';
	}

}


function showClouds(){
	if(document.getElementById('clouds').value == 'c'){
	  	document.getElementById("cloudsDiv").style.display='inline';
	}else{
		document.getElementById("cloudsDiv").style.display='none';
	}

}
function showDinghyOne(){
	if(document.getElementById('dinghyOne').value == 'd'){
	  	document.getElementById("dinghyOneDiv").style.display='inline';
	}else{
		document.getElementById("dinghyOneDiv").style.display='none';
	}

}
function showRationOne(){
	if(document.getElementById('rationOne').value == 'n'){
	  	document.getElementById("rationOneDiv").style.display='inline';
	}else{
		document.getElementById("rationOneDiv").style.display='none';
	}

}
function showWaterAvaiableOne(){
	if(document.getElementById('waterAvaiableOne').value == 'n'){
	  	document.getElementById("waterAvaiableOneDiv").style.display='inline';
	}else{
		document.getElementById("waterAvaiableOneDiv").style.display='none';
	}

}
function showWaterObtained(){
	if(document.getElementById('waterObtained').value == 'd'){
	  	document.getElementById("byDistillationDiv").style.display='inline';
	}else{
		document.getElementById("byDistillationDiv").style.display='none';
	}
	if(document.getElementById('waterObtained').value == 's'){
	  	document.getElementById("bySolarStillDiv").style.display='inline';
	}else{
		document.getElementById("bySolarStillDiv").style.display='none';
	}
	if(document.getElementById('waterObtained').value == 'r'){
	  	document.getElementById("byRainCollectionDiv").style.display='inline';
	}else{
		document.getElementById("byRainCollectionDiv").style.display='none';
	}

}
function showRescuersContactedBy(){
	if(document.getElementById('rescuersContactedBy').value == 'o'){
	  	document.getElementById("rescuersContactedByDiv").style.display='inline';
	}else{
		document.getElementById("rescuersContactedByDiv").style.display='none';
	}

}

function showRescueBy(){
	if(document.getElementById('rescuedBy').value == 'o'){
	  	document.getElementById("rescuedByDiv").style.display='inline';
	}else{
		document.getElementById("rescuedByDiv").style.display='none';
	}

}
function showRescueByOne(){
	if(document.getElementById('rescuedByOne').value == 'o'){
	  	document.getElementById("rescuedByOneDiv").style.display='inline';
	}else{
		document.getElementById("rescuedByOneDiv").style.display='none';
	}

}
function showNotificationFromWithness(){
	if(document.getElementById('notificationFromWithness').value == 'a'){
	  	document.getElementById("notificationFromWithnessDiv").style.display='inline';
	}else{
		document.getElementById("notificationFromWithnessDiv").style.display='none';
	}

}
function showRationTwo(){
	if(document.getElementById('rationTwo').value == 'n'){
	  	document.getElementById("rationTwoDiv").style.display='inline';
	}else{
		document.getElementById("rationTwoDiv").style.display='none';
	}

}
function showConditionOfCascualtyOnRescue(){
	if(document.getElementById('conditionOfCascualtyOnRescue').value == 'o'){
	  	document.getElementById("conditionOfCascualtyOnRescueDiv").style.display='inline';
	}else{
		document.getElementById("conditionOfCascualtyOnRescueDiv").style.display='none';
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



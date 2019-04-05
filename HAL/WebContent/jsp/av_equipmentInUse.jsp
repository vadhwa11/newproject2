<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
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
	<%Calendar calendar = Calendar.getInstance();
			String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String dateCal = String.valueOf(calendar.get(Calendar.DATE));
			int year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (dateCal.length() < 2) {
				dateCal = "0" + dateCal;
			}
			Map<String, Object> utilMap = new HashMap<String, Object>();
			String userName = "";
			if (session.getAttribute("userName") != null)
				userName = (String) session.getAttribute("userName");
			Users users = null;
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			int loginEmpId = 0;
			if (users != null) {
				if (users.getEmployee() != null) {
					loginEmpId = users.getEmployee().getId();
				}
			}
			Map<String, Object> map = new HashMap<String, Object>();
			if (request.getAttribute("map") != null) {
				map = (Map<String, Object>) request.getAttribute("map");
			}
			List<MasUnit> unitList = null;
			List<MasRank> rankList = null;
			List<MasMaritalStatus> maritalStatusList = null;

			if (map.get("unitList") != null) {
				unitList = (List<MasUnit>) map.get("unitList");
			}
			if (map.get("rankList") != null) {
				rankList = (List<MasRank>) map.get("rankList");
			}
			if (map.get("maritalStatusList") != null) {
				maritalStatusList = (List<MasMaritalStatus>) map
						.get("maritalStatusList");
			}
			List<Category> categoryList = new ArrayList<Category>();
			if (map.get("categoryList") != null) {
				categoryList = (List) map.get("categoryList");
			}
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			//String Session=(String) utilMap.get("session");
			String time = (String) utilMap.get("currentTime");%>
	serverdate = '<%=dateCal + "/" + month + "/" + year%>';
	
	</script>
<div class="clear"></div>
<div class="titleBg">	
<h2>EQUIPMENT AND HUMAN FACTORS</h2> </div>
<div class="clear"></div>
<form name="euipmentHumanFactors" action="" method="post">
<div class="clear paddingTop15"></div>
<div class="Block">
<label>Service No.<span>*</span></label>
<input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO%>" value="" title="Enter Service No" tabindex="1" validate="Service No,alphanumeric,yes" maxlength="20"  
onblur="submitProtoAjaxWithDivName('euipmentHumanFactors','/hms/hms/aviationMedicine?method=getServiceNoDetailsForRegEquipmentInUse&serviceNo='+this.value,'patientDiv');" />
<input 	id="prefix" name="<%=PREFIX%>" type="text" maxlength="3" class="auto" size="1"	tabindex="1" validate="Prefix,metachar,no" />
</div>
<div class="clear paddingTop15"></div>
<div class="Block"> 
<div id="patientDiv">
	<input type="hidden" name="avAccidentId" id="avAccidentId" value=""/>
	<input type="hidden" name="hinId" id="hinId" value=""/>
	
<div class="clear"></div>
	
<label> Surname</label>
<input tabindex="1" type="text"	name="surname" maxlength="30" value="" />	

<label> First Name</label>
<input tabindex="1" type="text"	name="<%=FIRST_NAME%>" maxlength="30" value="" />


<label>Rank</label>
<select	id="<%=RANK%>" name="<%=RANK_ID%>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%
		if (rankList != null && rankList.size() > 0) {
			for (MasRank masRank : rankList) {
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
		}
		}
	%>
</select>

<div class="clear"></div>

<label >Crew Duty (or Passenger Seating)</label>
<input tabindex="1" type="text"	name="crewDuty" maxlength="30" value="" />
</div>
</div>
<div class="clear paddingTop15"></div>
<h4>Part I - Equipment in Use</h4>
<div class="Block">

<label>UNINJURED</label>
<input tabindex="1" type="text"	name="<%=UNINJURED%>" maxlength="30" value="" />

<label>INJURED/FATAL</label>
<input tabindex="1" type="text"	name="<%=INJURED_FATAL%>" maxlength="30" value="" />

<label>MISSING</label>
<input tabindex="1" type="text"	name="<%=MISSING%>" maxlength="30" value="" />

</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">POSITION OF CASUALTY AT TIME OF GROUND IMPACT OF AIRCRAFT</label>
	<select  name="<%=GROUND_IMPACT_AIRCRAFT%>"  id="positionOfCasualty" onchange="showPositionOfCasualty();">
		<option value="n">In normal Seat</option>
		<option value="f">In Fuselage Out of Position</option>
		<option value="e">Using Escape apparatus</option>
		<option value="a">Thrown form Aircraft in air</option>
		<option value="k">Not Known</option>
		<option value="o">Other</option>
	</select>

<div id="positionOfCasualtyDiv" style="display: none" >
<label>If Other</label>
<input tabindex="1" type="text"	name="<%=IF_OTHER1%>" maxlength="30" value="" />

</div>
</div>
<div class="clear paddingTop15"></div>
<div class="Block">
	<label class="large">DISPLACEMENT OF CASUALTY</label>
		<select  name="<%=DISPLACEMENT_CASUALTY%>"  id="displacementOfCasualty" onchange="showDisplacementOfCasualty();">
			<option value="n">In normal Seat</option>
			<option value="f">In Fuselage Out of Position</option>
			<option value="e">Using Escape apparatus</option>
			<option value="k">Not Known</option>
			<option value="o">Other</option>
		</select>
	
	<div id="displacementOfCasualtyDiv" style="display: none" >

	<label>If Other</label>
	<input tabindex="1" type="text"	name="<%=IF_OTHER2%>" maxlength="30" value="" />
	</div>
</div>

<div class="clear paddingTop15"></div>
<h4>SEAT</h4>
<div class="Block">
	<label> Facing</label>
		<select  name="<%=SEAT_FACING%>"  id="facing" >
			<option value="f">Forward</option>
			<option value="s">Sideway</option>
			<option value="b">Backward</option>
			<option value="t">Stretcher</option>
			<option value="k">Not Known</option>
		</select>
		
		<label> Condition</label>
		<select  name="<%=SEAT_CONDITION%>"  id="condition">
			<option value="u">Undamaged</option>
			<option value="d">Distorted</option>
			<option value="t">Torn Free</option>
			<option value="e">Destoryed</option>
			<option value="s">Spontaneous Ejection</option>
			<option value="k">Not Known</option>
		</select>
</div>

<div class="clear paddingTop15"></div>
<h4>HEARNESS</h4>
<div class="Block">
	<label> Type</label>
		<select  name="<%=HEAR_TYPE%>"  id="type" onchange="showType();" >
			<option value="l">Lap Shoulder</option>
			<option value="c">Combind Parachute</option>
			<option value="o">Other</option>
			
		</select>
			<div id="typeDiv" style="display: none" >

	<label>If Other</label>
	<input tabindex="1" type="text"	name="hearTypeOther" maxlength="30" value="" class="large"/>

	</div>
	
	<div class="clear"></div>
		<label> Adjustments</label>
		<select  name="<%=HEAR_ADJUSTMENT%>"  id="adjustments">
			<option value="u">Undamaged</option>
			<option value="t">Tight</option>
			<option value="l">Lose</option>
			<option value="n">Unfastened</option>
			<option value="k">Not Known</option>
		</select>
			
		<label> Release Box</label>
		<select  name="releaseBox"  id="releaseBox">
			<option value="l">Locked</option>
			<option value="o">Open</option>
			<option value="a">Automatic Separation</option>
			<option value="k">Not Known</option>
		</select>
		<div class="clear"></div>
		
		<label> Effectiveness</label>
			<select  name="effectiveness"  id="effectiveness">
			<option value="e">Effective</option>
			<option value="n">Not Effective</option>
			<option value="k">Not Known</option>
		</select>
		
	<label> Cause of Failure</label>
		<select  name="causeOfFailure"  id="causeOfFailure">
			<option value="a">Not Applicable</option>
			<option value="w">Webbing Failure</option>
			<option value="s">Adjustment Slip</option>
			<option value="f">Attachment Failure</option>
			<option value="d">Destroyed in Fire</option>
			<option value="k">Not Known</option>
		</select>
</div>

<div class="clear paddingTop15"></div>
<h4>ESCAPE APPARATUS</h4>
<div class="Block">
		<label>Type</label>
		<select  name="typeEscape"  id="typeEscape">
			<option value="n">No Parachute</option>
			<option value="p">Parachut Without Ejection Seat</option>
		</select>
		
		<label>Stowing</label>
		<select  name="stowing"  id="stowing">
			<option value="m">Normally Attached to Man</option>
			<option value="a">Normally Stowed in AirCraft</option>
			<option value="e">Ejection Seat</option>
		</select>
		
		<label>Use</label>
		<select  name="use"  id="use">
			<option value="u">Unknown</option>
			<option value="n">Not Used</option>
			<option value="i">Apparatus Used Intertionally/Unintertionally</option>
		</select>
</div>

<div class="clear paddingTop15"></div>
<h4>OXYGEN</h4>
<div class="Block">

<h4>Mask</h4>
<label>Mark</label>
<input type="text" name="maskMark"  tabindex="1" maxlength="30" />

<label>Size</label>
<input type="text" name="maskSize"  tabindex="1" maxlength="45" />

<div class="clear"></div>

<h4>Regulater</h4>
<label>Mark</label>
<input type="text" name="regulaterMark"  tabindex="1" maxlength="45" />

<label>Setting</label>
<input type="text" name="regulaterSetting"tabindex="1" maxlength="45" />


<label class="auto">Not Proived</label>
<input type="checkbox" name="notProived" tabindex="1" maxlength="45" />

<div class="clear"></div>
<label class="large">Emergency /Portable Equipment</label>
<input tabindex="1" type="text"	name="emergencyPortableEquipment" maxlength="45" value="" class="auto" size="62" />
</div>
<div class="clear paddingTop15"></div>
<div class="Block">
<label>Outer Clothing</label>
<select  name="outerClothing"  id="outerClothing" onchange="showOuterClothing();">
			<option value="u">Undamaged</option>
			<option value="i">Removed on Impact</option>
			<option value="n">Not available for inspection</option>
			<option value="d">Damaged</option>
		</select>
<div id="outerClothingDiv" style="display: none" >
	<label>If Damaged</label>
	<input tabindex="1" type="text"	name="outerClothingDamaged" maxlength="30" value="" class="large"/>
	</div>
</div>
<div class="clear paddingTop15"></div>
<h4>PROTECTIVE HELMET</h4>
<div class="Block">
<label>Mark</label>
<input tabindex="1" type="text"	name="protectiveHelmetMark" value="" maxlength="45">


<label>At the time of Escape/Impact</label>
<select  name="escapeImpact"  id="escapeImpact" >
			<option value="w">Wron/Possibly Stowed in Aircraft</option>
			<option value="n">Not Wron</option>
			<option value="k">Not Known</option>
			<option value="o">Off Head When Found</option>
			<option value="h">On Head When Found</option>
</select>


<label>Chin Step</label>
<select  name="chinStep"  id="chinStep" >
			<option value="f">Fastened</option>
			<option value="n">Not Fastened</option>
			<option value="a">Failed</option>
			<option value="k">Not Known</option>
			
</select>
<div class="clear"></div>

<label>Inner Helmet</label>
<select  name="innerHelmet"  id="innerHelmet" >
			<option value="u">Undamaged</option>
			<option value="d">Slightly Damaged</option>
			<option value="s">Serverly Damaged</option>
			<option value="k">Not Known</option>
			
</select>

<label>Outer Helmet</label>
<select  name="outerHelmet"  id="outerHelmet" >
			<option value="u">Undamaged</option>
			<option value="d">Slightly Damaged</option>
			<option value="s">Serverly Damaged</option>
			<option value="k">Not Known</option>
			
</select>
<div class="clear"></div>
<label>Vizor Mark</label>
<input tabindex="1" type="text"	name="markVizor" value="" maxlength="30" />

<select  name="vizor"  id="vizor" >
			<option value="r">Raised/Lowered</option>
			<option value="d">Damaged</option>
			<option value="u">Undamaged</option>
			<option value="l">Destroyed or Lost</option>
			<option value="k">Not Known</option>
			
</select>
<div class="clear"></div>

<label class="large">Any Comment on the effective of the helmet</label>
<textarea rows="" cols="60"	name="commentHelmet" class="auto" onkeyup="chkLength(this,100);" maxlength="100" ></textarea>

</div>

<div class="clear paddingTop15"></div>
<h4>PRESSURE CLOTHING</h4>
<div class="Block">
<label>Partial Pressuresuit</label>
<select  name="partialPressuresuit"  id="partialPressuresuit" >
			<option value="n">Not Worn</option>
			<option value="w">Worn</option>
</select>
<label>Mark</label>
<input tabindex="1" type="text"	name="markPressuresuit" value="" maxlength="45">

<div class="clear"></div>

<label>Jerkin</label>
<select  name="jerkin"  id="jerkin" >
			<option value="n">Not Worn</option>
			<option value="w">Worn</option>
</select>
<label>Mark</label>
<input tabindex="1" type="text"	name="markJerkin" value="" maxlength="45">


<div class="clear"></div>

<label>Full Pressure Suit</label>
<select  name="fullPressureSuit"  id="fullPressureSuit" >
			<option value="n">Not Worn</option>
			<option value="w">Worn</option>
</select>
<label>Mark</label>
<input tabindex="1" type="text"	name="markFullPressureSuit" value="" maxlength="45">



<div class="clear"></div>

<label>Anti G. Suit</label>
<select  name="antiGSuit"  id="antiGSuit" >
			<option value="n">Not Worn</option>
			<option value="w">Worn</option>
</select>
<label>Mark</label>
<input tabindex="1" type="text"	name="markAntiGSuit" value="" maxlength="45">

<div class="clear"></div>

<label class="large">Specify and Function of these items Relevent to the Accident</label>
<textarea rows="" cols="60"	name="specifyFunction" class="auto" onkeyup="chkLength(this,100);"></textarea>

</div>


<div class="clear paddingTop15"></div>
<h4>OTHER EQUIPMENT</h4>
<div class="Block">
<label>Air Ventilated Suit</label>
<select  name="airVentilatedSuit"  id="airVentilatedSuit" >
			<option value="n">Not Worn</option>
			<option value="w">Worn</option>
</select>
<label>Mark</label>
<input tabindex="1" type="text"	name="markAirVentilated" value="" maxlength="30">

<div class="clear"></div>

<label>Life Jacket</label>
<select  name="lifeJacket"  id="lifeJacket" >
			<option value="n">Not Worn</option>
			<option value="w">Worn</option>
</select>
<label>Mark</label>
<input tabindex="1" type="text"	name="markLifeJacket" value="" maxlength="45" >


<div class="clear"></div>

<label>Dinghy</label>
<select  name="dinghy"  id="dinghy" >
			<option value="n">Not Carried</option>
			<option value="c">Carried</option>
</select>
<label>Mark</label>
<input tabindex="1" type="text"	name="markDinghy" value="" maxlength="45">



<div class="clear"></div>

<label>Survival Packs</label>
<select  name="survivalPacks"  id="survivalPacks" >
			<option value="n">Not Carried</option>
			<option value="c">Carried</option>
</select>
<label>Type</label>
<input tabindex="1" type="text"	name="typeSurvivalPacks" value="" maxlength="30">

</div>

<div class="clear paddingTop15"></div>
<h4>Part I - Medical History</h4>
<div class="Block">

<label>Age <span>*</span></label>
<select id="srAgeId"	name="<%=SR_AGE%>" validate="Age of Service Person,string,yes"	tabindex="1" class="small"	onchange="fillPatientName(this);">
	<option value="">Select</option>
	<%
		for (int age1 = 16; age1 <= 100; age1++) {
	%>
	<option value="<%=age1%>"><%=age1%></option>
	<%
		}
	%>
</select> 
<input type="text" class="readOnlySmall"  id="srAgeUnitId" name="<%=SR_AGE_UNIT%>" value="Years" readonly="readonly"/>
<label>Height</label>
<input	class="auto" tabindex="1" type="text"  name="<%=HEIGHT%>"	tabindex="2" maxlength="6" size="16"/>
<label class="unit">cm</label>

<label>Weight</label>
<input	class="auto" tabindex="1" type="text"  name="<%=WEIGHT%>"	tabindex="2" maxlength="6" size="18"/>
<label class="unit">Kg</label>


<div class="clear"></div>

<label>Marital Status</label> 
<select name="srMaritalStatus" id="srmrstatus"	validate="Marital Status,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%
		for (MasMaritalStatus masMaritalStatus : maritalStatusList) {
	%>
	<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
	<%
		}
	%>
</select> 

<label>Medical Category </label> 
<select name="medicalCategory" id="medicalCategory"	 tabindex="1">
 <option value="0">Select</option>
 <%
 	for (Category category : categoryList) {
 %>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%
		}
	%>
 </select>


<label> Date</label>
<input	tabindex="1" name="<%=DATE_OF_MB%>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=date%>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',euipmentHumanFactors.<%=DATE_OF_MB%>,event);" />


<div class="clear"></div>



<label>Reason</label>
<input	class="auto" tabindex="1" type="text"  name="reason"	tabindex="2" maxlength="45"  size="62" />

<div class="clear"></div>
<label class="large">Medical Condition (At Time Of Flight)</label>
	<select name="<%=MEDICAL_CONDITION%>" id="medicalCondition"
	onchange="();">
	<option value="f">Fully Fit</option>
	<option value="n">Not Fully Fit</option>

</select>

<div id="medicalConditionDiv" style="display: none" >
<label>Reason</label>
<input tabindex="1" type="text"	name="<%=REASON_MEDICAL_CONDITION%>" maxlength="50" value="" />

</div>
<div class="clear"></div>

<label class="large">Medication (Within 4 Weeks Previous To Flight </label> 
<select name="medication" id="medication"	 tabindex="1">
<option value="n">Nil</option>
<option value="t">Treatment Given</option>
<option value="s">Self Medication</option>
</select> 


<div class="clear"></div>
<label>Body Build</label>
<select  name="bodyBuild"  id="bodyBuild" >
			<option value="n">Normal</option>
			<option value="a">Above Average Physique</option>
			<option value="t">Thin</option>
			<option value="o">Obese</option>
</select>

<div class="clear"></div>

<label>Alcohol</label>
<select  name="alcohol"  id="alcohol" >
			<option value="n">Does not drink</option>
			<option value="o">Drinks Occasionally</option>
			<option value="r">Drinks Regularly</option>
			<option value="w">Drinks Wisely</option>
			<option value="u">Drinks Unwisely</option>
</select>
<label >Tobacco</label>
<select  name="tobacco"  id="tobacco" class="small" >
			<option value="n">Non Smoker</option>
			<option value="s">Smoker</option>
			<option value="c">Cigarettes</option>
			<option value="p">Pipes</option>
</select>
<input	class="auto" tabindex="1" type="text"  name="tobaccoTxt"	tabindex="2" maxlength="5" size="5"/>
<label class="auto">per day</label>
</div>


<div class="clear paddingTop15"></div>

<h4>Part III - Physiological And Psychological Factors</h4>
<div class="Block">
<label>Employment</label>
	<select name="employment"  id="Employment" >
		<option value="p">Pupil</option>
		<option value="s">1st Squadron Appt</option>
		<option value="a">Later Sqdn Appt</option>
		<option value="i">Instructor</option>
		<option value="n">Employed on nonflying Appoinment</option>
	</select>


<label>Extra Qualifications</label>
<input tabindex="1" type="text"  name="extraQualifications"	tabindex="2" maxlength="45" >


<label>Date of Renewal</label>
<input	tabindex="1" name="<%=DATE_RENEWAL%>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=date%>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',euipmentHumanFactors.<%=DATE_RENEWAL%>,event);" />


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
		<td><input tabindex="1" type="text"	name="24FlyingfirstPilot" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="24FlyingSecPilot" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="24FlyingCrew" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="24FlyingType" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
	</tr>
		<tr>
		<td><label>In the last 30 days</label>	</td>
		<td><input tabindex="1" type="text"	name="30FlyingfirstPilot" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="30FlyingSecPilot" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="30FlyingCrew" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="30FlyingType" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
	</tr>
	<tr>
		<td><label>Since being posted to the flying assignment</label>	</td>
		<td><input tabindex="1" type="text"	name="flyingfirstPilot" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="flyingSecPilot" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="flyingCrew" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="flyingType" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
	</tr>
		<tr>
		<td><label>Other types of a/c flown</label>	</td>
		<td><input tabindex="1" type="text"	name="flownfirstPilot" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="flownSecPilot" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="flownCrew" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
		<td><input tabindex="1" type="text"	name="flownType" maxlength="10" value=""/><label class="unit">hrs</label>	</td>
	</tr>
	</table>
	</div>




<div class="clear paddingTop15"></div>
<h4>PRESENT POSTING</h4>
<div class="Block">
<label class="large">Length of time at station</label>
<input tabindex="1" type="text"  name="lengthTimeStation"	tabindex="2" maxlength="30" >
<label>Months</label>
<input tabindex="1" type="text"  name="months"	tabindex="2" maxlength="10" >

<div class="clear"></div>


<label class="large"> Accommodation At Station</label>
<input tabindex="1" type="text"  name="accommodationStation"	tabindex="2" maxlength="30" >
<label class="auto">miles away</label>

<div class="clear"></div>
<label class="large">Type of accommodation</label>
<input tabindex="1" type="text"  name="typeAccommodation"	tabindex="2" maxlength="30" >
</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label class="large">Current Flying Assessment: (to be obtained from Commanding Officer)</label>

	<select name="assessmentFlying"  id="flying" >
		<option value="e">Exceptional</option>
		<option value="b">Above Average</option>
		<option value="a">Average</option>
		<option value="s">Below Standard</option>
		
	</select>
	
	<div class="clear"></div>
	<label class="large">Any Relevant Remarks</label>
<textarea rows="" cols="60"	name="relevantRemarks" class="auto" onkeyup="chkLength(this,100);"></textarea>
	
</div>
<div class="clear paddingTop15"></div>
<h4>PREVIOUS ACCDIENT HISTORY</h4>
<div class="Block">
<label>Aircraft Accident</label>

	<select name="aircraftAccident"  id="aircraftAccident" onchange="showAircraftAccident();">
	<option value="y">Yes</option>
	<option value="n">None</option>
	<option value="k">Not Known</option>
	</select>
	
	<div id="aircraftAccidentDiv" style="display: none" >
<div class="clear"></div>
	<label>Description</label>
	<input tabindex="1" type="text"	name="aircraftDescription" maxlength="30" value="" />


	<label>Date</label>
	<input	tabindex="1" name="<%=DATE_TWO%>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=date%>"	onKeyUp="mask(this.value,this,'2,5','/');" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',euipmentHumanFactors.<%=DATE_TWO%>,event);" />


	<label>Severity</label>

	<select name="severity"  id="severity" >
	<option value=""></option>

	</select>

	<label>Responsibility</label>
	<input tabindex="1" type="text"	name="responsibility" maxlength="30" value="" />


	</div>
	<label>Motoring Accident</label>
	<select name="motoringAccident"  id="motoringAccident" >
	<option value="y">Yes</option>
		<option value="n">None</option>
		<option value="k">Not Known</option>
	</select>
	
		<label>Other Accident Involving Injury</label>
	<select name="otherAccident"  id="otherAccident" >
	<option value="y">Yes</option>
		<option value="n">None</option>
		<option value="k">Not Known</option>
	
		
	</select>
</div>


<div class="clear paddingTop15"></div>
<h4>FATIGUE</h4>
<div class="Block">
<label class="large">Time at controls this Flight(if assessable)</label>
<input tabindex="1" type="text"	name="timeControlsFlight" maxlength="6" value="" />
<label class="small">hrs/ Mts</label>


<div class="clear"></div>

<label class="large">Number of take offs/landings during the sorties</label>
<input tabindex="1" type="text"	name="noTakeOffs" maxlength="10" value="" />

<div class="clear"></div>

<label class="large">Number of sorties in Last 24 hours</label>
<input tabindex="1" type="text"	name="noOfSorties" maxlength="10" value="" />

<label class="small">7 Days</label>
<input tabindex="1" type="text"	name="7days" maxlength="30" value="" />

<div class="clear"></div>

<label class="large">Number of hours duty in 24 hours preceding start of flight</label>
<input tabindex="1" type="text"	name="noOfSorties24" maxlength="30" value="" />
<label class="small">Type duty</label>

<div class="clear"></div>

<label class="large">Amount of sleep(day/night) in 24 hours preceding start of flight</label>
<input tabindex="1" type="text"	name="amountOfSleep" maxlength="30" value="" />
<label class="small">hours.</label>

<select name="amount"  id="amount" >
		<option value="p">Probably 8 hours</option>
		<option value="k">Not Known</option>
</select>

<div class="clear"></div>

<label class="large">Specify any recent factors liable to increase fatigue</label>
<select name="recentFactors"  id="factors" onchange="showFactors();">
		<option value="s">Strenuous Exercise</option>
		<option value="c">Celebration</option>
		<option value="p">Poor Transit Arrangements</option>
		<option value="o">Other</option>
</select>

<div id="factorsDiv" style="display: none" >
	<label>Other</label>
	<input tabindex="1" type="text"	name="recentOtherFactors" maxlength="45" value="" />
</div>

<div class="clear"></div>

<label class="large">Amount of Leave taken in Last 6 months</label>
<input tabindex="1" type="text"	name="amountOfLeave" maxlength="10" value="" />

</div>

<div class="clear paddingTop15"></div>
<h4>FOOD</h4>
<div class="Block">

<label class="large">Hours since last full meal</label>
<input tabindex="1" type="text"	name="lastMealHours" maxlength="30" value="" />
<label class="auto">hr.</label>
<label class="auto">Which was</label>
<input tabindex="1" type="text"	name="whichWas" maxlength="30" value="" />

<div class="clear"></div>

<label class="large">Dispersal Canteen</label>

<select name="dispersalCanteen"  id="dispersalCanteen" >
		<option value="a">Avilable</option>
		<option value="n">Not Avilable</option>
		
</select>

<label class="auto">In Flight Feeding</label>
<select name="inFlightFeeding"  id="inFlightFeeding" >
		<option value="p">Provided</option>
		<option value="n">Not Provided</option>
		
</select>

<div class="clear"></div>
<label class="large">Specify any recent abnormalities of feedings</label>
<textarea rows="" cols="78"	name="abnormalfeeding" class="auto" onkeyup="chkLength(this,45);"></textarea>
	
</div>


<div class="clear paddingTop15"></div>
<h4>OTHER PHYSIOLOGICAL FACTORS</h4>
<div class="Block">

<label>Intoxication by CO/other fumes</label>
<textarea rows="" cols="40"	name="intoxication" class="auto" onkeyup="chkLength(this,100);"></textarea>


<label>Hypoxia</label>
<textarea rows="" cols="40"	name="hypoxia" class="auto" onkeyup="chkLength(this,100);"></textarea>
<div class="clear"></div>
<label>Disorientation in the air</label>
<textarea rows="" cols="40"	name="disorientation" class="auto" onkeyup="chkLength(this,100);"></textarea>


<label>Air Sickness</label>
<textarea rows="" cols="40"	name="airSickness" class="auto" onkeyup="chkLength(this,100);"></textarea>

<div class="clear"></div>
<label>Decompression Sickness</label>
<textarea rows="" cols="40"	name="decompressionSickness" class="auto" onkeyup="chkLength(this,100);"></textarea>



<label>Heat Stress</label>
<textarea rows="" cols="40"	name="heatStress" class="auto" onkeyup="chkLength(this,100);"></textarea>
<div class="clear"></div>

<label>Cold Injury</label>
<textarea rows="" cols="40"	name="coldInjury" class="auto" onkeyup="chkLength(this,100);"></textarea>


<label>Accelerations</label>
<textarea rows="" cols="40"	name="accelerations" class="auto" onkeyup="chkLength(this,100);"></textarea>
<div class="clear"></div>


<label>Hyperventilation</label>
<textarea rows="" cols="40"	name="hyperventilation" class="auto" onkeyup="chkLength(this,100);"></textarea>

<label>Hypoglycaemin</label>
<textarea rows="" cols="40"	name="hypoglycaemin" class="auto" onkeyup="chkLength(this,100);"></textarea>
<div class="clear"></div>
<label>Sycope (Other)</label>
<textarea rows="" cols="40"	name="sycope" class="auto" onkeyup="chkLength(this,100);"></textarea>

<label>Visual Factors in aircraft or environment</label>
<textarea rows="" cols="40"	name="visualFactorsInAircraft" class="auto" onkeyup="chkLength(this,100);"></textarea>
<div class="clear"></div>
<label>Noise/Vibration</label>
<textarea rows="" cols="40"	name="noiseVibration" class="auto" onkeyup="chkLength(this,100);"></textarea>

<label>Alcohol</label>
<textarea rows="" cols="40"	name="alcoholDesc" class="auto" onkeyup="chkLength(this,100);"></textarea>

</div>

<div class="clear paddingTop15"></div>
<h4>PHYCHOLOGICAL STRESS</h4>
<div class="Block">

<label class="large">Willingness or otherwise to fly this trip</label>

<select name="willingness"  id="willingness" onchange="showWillingness()" class="small">
		<option value="w">Will</option>
		<option value="u">Unwill</option>
		
</select>

<div id="willingnessDiv" style="display: none" >
<label>Reason</label>
	<input tabindex="1" type="text"	name="willingReason" maxlength="45" value="" />
</div>

<div class="clear"></div>

<label class="large">Attitude towards Service</label>
<input tabindex="1" type="text"	class="large" name="attitudeService" maxlength="45" value="" />

<div class="clear"></div>

<label class="large">Attitude towards Shin/Unit</label>
<input tabindex="1" type="text"	class="large" name="shinUnit" maxlength="45" value="" />

<div class="clear"></div>

<label class="large">Attitude towards Flying</label>
<input tabindex="1" type="text"	class="large" name="attitudeFlying" maxlength="45" value="" />

<div class="clear"></div>

<label class="large">Temperament/Emotional Stability</label>
<input tabindex="1" type="text"	class="large" name="temperamentEmotional" maxlength="45" value="" />

<div class="clear"></div>

<label class="large">Discipline/Recent Punishments</label>
<input tabindex="1" type="text"	class="large" name="discipline" maxlength="45" value="" />


<div class="clear"></div>

<label class="large">Confidence in ability to fly</label>


<select name="confidenceAbility"  id="confidence" class="small">
		<option value="o">Over Confident</option>
		<option value="c">Confident</option>
			<option value="n">Not Confident</option>
		
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksConfidence" maxlength="45" class="auto" size="31" value="" />



<div class="clear"></div>

<label class="large">Any evidence of anxiet prior to accident</label>
<input tabindex="1" type="text"	class="large" name="evidenceAccident" maxlength="45" value="" />



<div class="clear"></div>

<label class="large">Trend of conversation after the accident</label>
<select name="trend"  id="trendConversation" class="small">
		<option value="g">Guild</option>
		<option value="f">Fear</option>
			<option value="d">Depression</option>
		
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksTrend" maxlength="100" value="" class="auto" size="31"/>


<div class="clear"></div>

<label class="large">Human Engineering Factors</label>
<input tabindex="1" type="text"	class="large" name="engineeringFactors" maxlength="45" value="" />



<div class="clear"></div>

<label class="auto">Eny haste or hurry in take off or completion of the sortie, apprehension of any malfunction of the aircraft due to its previous history</label>
<input tabindex="1" type="text"	name="hasteApprehension" maxlength="100" value="" class="auto" size="150" />

<div class="clear"></div>
<label class="auto">This would cover any Human Engineering factor which the M.O. may feel and show that it is involved. Further if any accident pattern is observed the M.O. can state that as well</label>
<input tabindex="1" type="text" class="auto" size="150" name="humanEngineering" maxlength="100" value="" />

</div>

<div class="clear paddingTop15"></div>
<h4>TABLE OF INJURIES</h4>
<div class="Block">



<label>Scalp</label>


<select name="scalp"  id="scalp">
	<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>


<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksScalp" maxlength="45" value="" />



<div class="clear"></div>


<label>Face</label>


<select name="face"  id="face">
	<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>


<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksFace" maxlength="45" value="" />


<div class="clear"></div>


<label>Neck</label>


<select name="neck"  id="neck">
	<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>


<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksNeck" maxlength="45" value="" />


<div class="clear"></div>


<label >Throax</label>
<label class="small">Ant</label>
<select name="throaxAnt"  id="ant" class="smaller">
	<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>



<label class="small">Post</label>

<select name="throaxPost"  id="post" class="smaller">
	<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>


<label>Remarks</label>
<input tabindex="1" type="text"	name="throaxRemarks" maxlength="45" value="" />

<div class="clear"></div>

<label>Hand and Wrist </label>
<label class="small">Lt</label>
<select name="ltHandWrist"  id="ltHandWrist" class="smaller">
	<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>

<label class="small">Rt.</label>

<select name="rtHandWrist"  id="rtHandWrist" class="smaller">
<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksLtRtHandWrist" maxlength="45" value="" />


<div class="clear"></div>

<label>Forearm and Elbow</label>
<label class="small">Lt.</label>
<select name="ltForearmAndElbow"  id="ltForearmAndElbow" class="smaller">
	<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>


<label class="small">Rt.</label>
<select name="rtForearmAndElbow"  id="rtForearmAndElbow" class="smaller">
	<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksLtRtForearmElbow" maxlength="45" value="" />

<div class="clear"></div>

<label>Arm and Shoulder</label>
<label class="small">Lt.</label>
<select name="ltArmAndShoulder"  id="ltArmAndShoulder" class="smaller">
	<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>


<label class="small">Rt.</label>
<select name="rtArmAndShoulder"  id="rtArmAndShoulder" class="smaller">
<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksLtRtArmShoulder" maxlength="45" value="" />

<div class="clear"></div>




<label>Abdomen/Ant Post</label>


<select name="abdomenAntPost"  id="abdomenAntPost">
	<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>


<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksAbdomenAntPost" maxlength="45" value="" />


<div class="clear"></div>

<label>Foot and Ankle</label>
<label class="small">Lt.</label>
<select name="ltFootAndAnkle"  id="ltFootAndAnkle" class="smaller">
	<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>


<label class="small">Rt.</label>
<select name="rtFootAndAnkle"  id="rtFootAndAnkle" class="smaller">
<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksLtRtFootAnkle" maxlength="45" value="" />

<div class="clear"></div>


<label>Leg and Knee</label>
<label class="small">Lt.</label>
<select name="ltLegAndKnee"  id="ltLegAndKnee" class="smaller">
<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>

<label class="small">Rt.</label>
<select name="rtLegAndKnee"  id="rtLegAndKnee" class="smaller">
<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksLtRtLegKnee" maxlength="45" value="" />

<div class="clear"></div>

<label>Thigh and Hip</label>
<label class="small">Lt.</label>
<select name="ltThighAndHip"  id="ltThighAndHip" class="smaller">
<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>


<label class="small">Rt.</label>
<select name="rtThighAndHip"  id="rtThighAndHip" class="smaller">
	<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksLtRtThighHip" maxlength="45" value="" />

<div class="clear"></div>


<label>Buttocks</label>
<label class="small">Lt.</label>
<select name="ltButtocks"  id="ltButtocks" class="smaller">
<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>


<label class="small">Rt.</label>
<select name="rtButtocks"  id="rtButtocks" class="smaller">
	<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksLtRtButtocks" maxlength="45" value="" />

<div class="clear"></div>

<label>Perineum and Genitalia</label>


<select name="perineumGenitalia"  id="perineumAndGenitalia">
	<option value="a">Amputation</option>
	<option value="b">Burns</option>
	<option value="h">Haematoma</option>
	<option value="w">Wound or deep Laceration</option>
	<option value="g">Graze of abrasion</option>
	<option value="o">Open Fracture</option>
	<option value="c">Crushing</option>
	<option value="i">Other Injuries</option>
	<option value="e">Not Available for examination</option>
</select>


<label>Remarks</label>
<input tabindex="1" type="text"	name="remarksPerineumGenitalia" maxlength="45" value="" />

</div>

<input tabindex="1"  type="button" value="Submit" class="button"  accessKey="r" 
onclick="submitForm('euipmentHumanFactors','/hms/hms/aviationMedicine?method=submitEquipmentFactors&flag=equipment');"  />
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


function showPositionOfCasualty(){
	if(document.getElementById('positionOfCasualty').value == 'o'){
	  	document.getElementById("positionOfCasualtyDiv").style.display='inline';
	}else{
		document.getElementById("positionOfCasualtyDiv").style.display='none';
	}
}

function showDisplacementOfCasualty(){
	if(document.getElementById('displacementOfCasualty').value == 'o'){
	  	document.getElementById("displacementOfCasualtyDiv").style.display='inline';
	}else{
		document.getElementById("displacementOfCasualtyDiv").style.display='none';
	}
}
function showType(){
	if(document.getElementById('type').value == 'o'){
	  	document.getElementById("typeDiv").style.display='inline';
	}else{
		document.getElementById("typeDiv").style.display='none';
	}
}

function showOuterClothing(){
	if(document.getElementById('outerClothing').value == 'd'){
	  	document.getElementById("outerClothingDiv").style.display='inline';
	}else{
		document.getElementById("outerClothingDiv").style.display='none';
	}

}

function showAircraftAccident(){
	if(document.getElementById('aircraftAccident').value == 'y'){
	  	document.getElementById("aircraftAccidentDiv").style.display='inline';
	}else{
		document.getElementById("aircraftAccidentDiv").style.display='none';
	}

}


function showFactors(){
	if(document.getElementById('factors').value == 'o'){
	  	document.getElementById("factorsDiv").style.display='inline';
	}else{
		document.getElementById("factorsDiv").style.display='none';
	}

}
function showWillingness(){
	if(document.getElementById('willingness').value == 'u'){
	  	document.getElementById("willingnessDiv").style.display='inline';
	}else{
		document.getElementById("willingnessDiv").style.display='none';
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
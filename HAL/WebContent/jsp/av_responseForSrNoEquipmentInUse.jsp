<%@ page import ="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>


<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.AviFlyingClothingInspection"%>
<%@page import="jkt.hms.masters.business.AvAccident"%>
<%@page import="jkt.hms.masters.business.Category"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<div class="clear"></div>

<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String date = (String) utilMap.get("currentDate");
//String Session=(String) utilMap.get("session");
String time = (String) utilMap.get("currentTime");	

List<MasUnit> unitList = null;
List<MasRank> rankList = null;
List<MasTrade> tradeList = null;


if(map.get("unitList") != null){
	unitList =(List<MasUnit>)map.get("unitList");
}
if(map.get("rankList") != null)	{
	rankList = (List<MasRank>)map.get("rankList");
}
if(map.get("tradeList") != null){
	tradeList =(List<MasTrade>)map.get("tradeList");
}

List<Category> categoryList= new ArrayList<Category>();
if(map.get("categoryList") != null){
	categoryList=(List)map.get("categoryList");
}

List<Patient> patientList = new ArrayList<Patient>();
if(map.get("patientList") != null){
	patientList = (List<Patient>)map.get("patientList");
}

List<AvAccident> avAccidentList = new ArrayList<AvAccident>();
if(map.get("avAccidentList") != null){
	avAccidentList = (List<AvAccident>)map.get("avAccidentList");
}


if(avAccidentList.size() > 0){
	for(AvAccident avAccident : avAccidentList){ %>
<input type="hidden" name="avAccidentId" id="avAccidentId" value="<%=avAccident.getId() %>"/>
<%if(avAccident.getHin() !=null){ %>
<input type="hidden" name="hinId" id="hinId" value="<%=avAccident.getHin().getId()%>"/>
<%}else{ %>
<input type="hidden" name="hinId" id="hinId" value=""/><%} %>
<label> Surname</label>

<%if(avAccident.getSurname()!=null){ %> 
<input type="text"	id="Surname" name="surname" value="<%=avAccident.getSurname() %>" tabindex="1"	 MAXLENGTH="10" />
<%}else{ %>
<input tabindex="1" type="text"	name="surnam




e" maxlength="10" value="" />	
<%} %>

<label> First Name <span>*</span></label>
<%if(avAccident.getFirstName()!=null){ %> 
<input type="text"	id="FirstName" name="<%=FIRST_NAME %>" value="<%=avAccident.getFirstName() %>" tabindex="1"  MAXLENGTH="10" />
<%}else{ %>
<input type="text"	id="FirstName" name="<%=FIRST_NAME %>" value="" tabindex="1" MAXLENGTH="10" />
<%} %>


<div class="clear"></div>

<label> Rank </label> 

<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	
	<%for(MasRank masRank : rankList){
		if(avAccident.getRank() !=null){
	if(avAccident.getRank().getId().equals(masRank.getId())){ %>	
	<option value="<%=avAccident.getRank().getId()%>" selected="selected"><%=avAccident.getRank().getRankName()%></option>
	<%}else{ %>	
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%} }else{ %>	
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>

	<%}
			}
				%>
</select>


<label>Crew Duty (or Passenger Seating)</label>
<%if(avAccident.getCrewDuty()!=null){ %> 
<input tabindex="1" type="text"	name="crewDuty" maxlength="10" value="<%=avAccident.getCrewDuty()%>" />
<%}else{ %>
<input tabindex="1" type="text"	name="crewDuty" maxlength="10" value="" />	
<%} %>
<%---
<div class="clear paddingTop15"></div>
<h3>Part I - Equipment in Use</h3>
<div class="Block">




<label>UNINJURED</label>
<%if(avAccident.getUninjured()!=null){ %> 
<input tabindex="1" type="text"	name="<%=UNINJURED %>" maxlength="30"  value="<%=avAccident.getUninjured() %>"/>
<%}else{ %>
<input tabindex="1" type="text"	name="<%=UNINJURED %>" maxlength="30" value="" />
<%} %>




<label>INJURED/FATAL</label>
<%if(avAccident.getInjuredFatal()!=null){ %> 
<input tabindex="1" type="text"	name="<%=INJURED_FATAL %>" maxlength="10" value="<%=avAccident.getInjuredFatal() %>" />
<%}else{ %>
<input tabindex="1" type="text"	name="<%=INJURED_FATAL %>" maxlength="10" value="" />
<%} %>

<label>MISSING</label>
<%if(avAccident.getMissing()!=null){ %> 
<input tabindex="1" type="text"	name="<%=MISSING %>" maxlength="10" value="<%=avAccident.getMissing() %>" />
<%}else{ %>
<input tabindex="1" type="text"	name="<%=MISSING %>" maxlength="10" value="" />
<%} %>
</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large">POSITION OF CASUALTY AT TIME OF GROUND IMPACT OF AIRCRAFT</label>
	<select  name="<%=GROUND_IMPACT_AIRCRAFT %>"  id="positionOfCasualty" onchange="showPositionOfCasualty();">
		
	<%if(avAccident.getGroundImpactAircraft().equals("n")){ %>	
		<option value="n" selected="selected">In normal Seat</option>
		<option value="f">In Fuselage Out of Position</option>
		<option value="e">Using Escape apparatus</option>
		<option value="a">Thrown form Aircraft in air</option>
		<option value="k">Not Known</option>
		<option value="o">Other</option>
	<%}else if (avAccident.getGroundImpactAircraft().equals("f")){
		%>	
	<option value="f" selected="selected">In Fuselage Out of Position</option>
		<option value="n">In normal Seat</option>
		<option value="e">Using Escape apparatus</option>
		<option value="a">Thrown form Aircraft in air</option>
		<option value="k">Not Known</option>
		<option value="o">Other</option>

	<%} else if(avAccident.getGroundImpactAircraft().equals("e")){ %>	
		<option value="n" >In normal Seat</option>
		<option value="f">In Fuselage Out of Position</option>
		<option value="e" selected="selected">Using Escape apparatus</option>
		<option value="a">Thrown form Aircraft in air</option>
		<option value="k">Not Known</option>
		<option value="o">Other</option>
	<%}else if (avAccident.getGroundImpactAircraft().equals("a")){%>	
	<option value="f">In Fuselage Out of Position</option>
		<option value="n">In normal Seat</option>
		<option value="e">Using Escape apparatus</option>
		<option value="a" selected="selected">Thrown form Aircraft in air</option>
		<option value="k">Not Known</option>
		<option value="o">Other</option>
	<%}else if(avAccident.getGroundImpactAircraft().equals("k")){ %>	
		<option value="n">In normal Seat</option>
		<option value="f">In Fuselage Out of Position</option>
		<option value="e">Using Escape apparatus</option>
		<option value="a">Thrown form Aircraft in air</option>
		<option value="k" selected="selected">Not Known</option>
		<option value="o">Other</option>
	<%}else if (avAccident.getGroundImpactAircraft().equals("o")){%>	
	<option value="f" >In Fuselage Out of Position</option>
		<option value="n">In normal Seat</option>
		<option value="e">Using Escape apparatus</option>
		<option value="a">Thrown form Aircraft in air</option>
		<option value="k">Not Known</option>
		<option value="o" selected="selected">Other</option>
	<%}else{%>
		<option value="n">In normal Seat</option>
		<option value="f">In Fuselage Out of Position</option>
		<option value="e">Using Escape apparatus</option>
		<option value="a">Thrown form Aircraft in air</option>
		<option value="k">Not Known</option>
		<option value="o">Other</option>
		<%} %>
	</select>

<div id="positionOfCasualtyDiv" style="display: none" >
<label>If Other</label>
<%if(avAccident.getIfOther1()!=null){ %> 
<input tabindex="1" type="text"	name="<%=IF_OTHER1 %>" maxlength="10" value="<%=avAccident.getIfOther1() %>" />
<%}else{ %>
<input tabindex="1" type="text"	name="<%=IF_OTHER1 %>" maxlength="10" value="" />
<%} %>
</div>


</div>

<div class="clear paddingTop15"></div>
<div class="Block">
	<label class="large">DISPLACEMENT OF CASUALTY</label>
		<select  name="<%=DISPLACEMENT_CASUALTY %>"  id="displacementOfCasualty" onchange="showDisplacementOfCasualty();">
		<%if(avAccident.getDisplacementCasualty().equals("n")){ %>	
		<option value="n" selected="selected">In normal Seat</option>
		<option value="f">In Fuselage Out of Position</option>
		<option value="e">Using Escape apparatus</option>
		<option value="a">Thrown form Aircraft in air</option>
		<option value="k">Not Known</option>
		<option value="o">Other</option>
	<%}else if (avAccident.getDisplacementCasualty().equals("f")){
		%>	
	<option value="f" selected="selected">In Fuselage Out of Position</option>
		<option value="n">In normal Seat</option>
		<option value="e">Using Escape apparatus</option>
		<option value="a">Thrown form Aircraft in air</option>
		<option value="k">Not Known</option>
		<option value="o">Other</option>

	<%}else if(avAccident.getDisplacementCasualty().equals("e")){ %>	
		<option value="n" >In normal Seat</option>
		<option value="f">In Fuselage Out of Position</option>
		<option value="e" selected="selected">Using Escape apparatus</option>
		<option value="a">Thrown form Aircraft in air</option>
		<option value="k">Not Known</option>
		<option value="o">Other</option>
	<%}else if (avAccident.getDisplacementCasualty().equals("a")){
		%>	
	<option value="f">In Fuselage Out of Position</option>
		<option value="n">In normal Seat</option>
		<option value="e">Using Escape apparatus</option>
		<option value="a" selected="selected">Thrown form Aircraft in air</option>
		<option value="k">Not Known</option>
		<option value="o">Other</option>

	<%} else if(avAccident.getDisplacementCasualty().equals("k")){ %>	
		<option value="n">In normal Seat</option>
		<option value="f">In Fuselage Out of Position</option>
		<option value="e">Using Escape apparatus</option>
		<option value="a">Thrown form Aircraft in air</option>
		<option value="k" selected="selected">Not Known</option>
		<option value="o">Other</option>
	<%}else if (avAccident.getDisplacementCasualty().equals("o")){
		%>	
	<option value="f" >In Fuselage Out of Position</option>
		<option value="n">In normal Seat</option>
		<option value="e">Using Escape apparatus</option>
		<option value="a">Thrown form Aircraft in air</option>
		<option value="k">Not Known</option>
		<option value="o" selected="selected">Other</option>

	<%}else{
				%>
		<option value="n">In normal Seat</option>
		<option value="f">In Fuselage Out of Position</option>
		<option value="e">Using Escape apparatus</option>
		<option value="a">Thrown form Aircraft in air</option>
		<option value="k">Not Known</option>
		<option value="o">Other</option>
		<%} %>
	</select>
	
	<div id="displacementOfCasualtyDiv" style="display: none" >

	<label>If Other</label>
	<%if(avAccident.getIfOther2()!=null){ %> 
<input tabindex="1" type="text"	name="<%=IF_OTHER2 %>" maxlength="10" value="<%=avAccident.getIfOther2() %>" />
<%}else{ %>
<input tabindex="1" type="text"	name="<%=IF_OTHER2 %>" maxlength="10" value="" />
<%} %>
</div>
</div>



<div class="clear paddingTop15"></div>
<h4>SEAT</h4>
<div class="Block">
	<label> Facing</label>
	<select  name="<%=SEAT_FACING %>"  id="facing" >
		<%if(avAccident.getSeatFacing().equals("f")){ %>	
		<option value="f" selected="selected">Forward</option>
		<option value="">Select</option>
			<option value="s">Sideway</option>
			<option value="b">Backward</option>
			<option value="t">Stretcher</option>
			<option value="k">Not Known</option>
	<%}else if (avAccident.getSeatFacing().equals("s")){
		%>	
		<option value="">Select</option>
			<option value="f">Forward</option>
			<option value="s" selected="selected">Sideway</option>
			<option value="b">Backward</option>
			<option value="t">Stretcher</option>
			<option value="k">Not Known</option>
			<%}else if (avAccident.getSeatFacing().equals("b")){
		%>	
		<option value="">Select</option>
		<option value="f">Forward</option>
			<option value="s">Sideway</option>
			<option value="b" selected="selected">Backward</option>
			<option value="t">Stretcher</option>
			<option value="k">Not Known</option>
			<%}else if (avAccident.getSeatFacing().equals("t")){
		%>	<option value="">Select</option>
		<option value="f">Forward</option>
			<option value="s">Sideway</option>
			<option value="b">Backward</option>
			<option value="t" s>Stretcher</option>
			<option value="k">Not Known</option>
			<%}else if (avAccident.getSeatFacing().equals("k")){
		%>	
		<option value="">Select</option>
		<option value="f">Forward</option>
			<option value="s">Sideway</option>
			<option value="b">Backward</option>
			<option value="t">Stretcher</option>
			<option value="k" selected="selected">Not Known</option>
			<%}else{ %>
			<option value="" selected="selected">Select</option>
			<option value="f">Forward</option>
			<option value="s">Sideway</option>
			<option value="b">Backward</option>
			<option value="t">Stretcher</option>
			<option value="k">Not Known</option>
			<%} %>
		</select>
		
		<label> Condition</label>
		<select  name="<%=SEAT_CONDITION %>"  id="condition">
			<option value="u">Undamaged</option>
			<option value="d">Distorted</option>
			<option value="t Free">Torn Free</option>
			<option value="e">Destoryed</option>
			<option value="t">Spontaneous Ejection</option>
			<option value="k">Not Known</option>
		</select>
</div>

<div class="clear paddingTop15"></div>
<h4>HEARNESS</h4>
<div class="Block">
	<label> Type</label>
		<select  name="<%=HEAR_TYPE %>"  id="type" onchange="showType();" >
			<option value="l">Lap Shoulder</option>
			<option value="c">Combind Parachute</option>
			<option value="o">Other</option>
			
		</select>
			<div id="typeDiv" style="display: none" >

	<label>If Other</label>
	<input tabindex="1" type="text"	name="hearTypeOther" maxlength="10" value="" class="large"/>

	</div>
	
	<div class="clear"></div>
		<label> Adjustments</label>
		<select  name="<%=HEAR_ADJUSTMENT %>"  id="adjustments">
			<option value="u">Undamaged</option>
			<option value="t">Tight</option>
			<option value="l">Losse</option>
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

<h3>Mask</h3>
<label>Mark</label>
	<%if(avAccident.getOxygenMask()!=null){ %> 

<input type="text" name="maskMark"  tabindex="1" maxlength="30"  value="<%=avAccident.getOxygenMask() %>"/>
<%}else{ %>
<input type="text" name="maskMark"  tabindex="1" maxlength="30" />
<%} %>


<label>Size</label>
<%if(avAccident.getOxygenSize()!=null){ %> 

<input type="text" name="maskSize"  tabindex="1" maxlength="30"  value="<%=avAccident.getOxygenSize() %>"/>
<%}else{ %>
<input type="text" name="maskSize"  tabindex="1" maxlength="30" />
<%} %>
<div class="clear"></div>

<h3>Regulater</h3>
<label>Mark</label>
<%if(avAccident.getOxygenSize()!=null){ %> 

<input type="text" name="regulaterMark"  tabindex="1" maxlength="45" value="<%=avAccident.getRegulaterMark() %>"/>
<%}else{ %>
<input type="text" name="regulaterMark"  tabindex="1" maxlength="45" />
<%} %>


<label>Setting</label>
<%if(avAccident.getOxygenSize()!=null){ %> 

<input type="text" name="regulaterSetting"tabindex="1" maxlength="45"  value="<%=avAccident.getRegulaterSetting() %>"/>
<%}else{ %>
<input type="text" name="regulaterSetting"tabindex="1" maxlength="45" />
<%} %>



<label class="auto">Not Proived</label>
<%if(avAccident.getOxygenSize()!=null){ %> 


<input type="checkbox" name="notProived" tabindex="1" maxlength="45" value="<%=avAccident.getRegulaterNotProvide() %>"/>
<%}else{ %>
<input type="checkbox" name="notProived" tabindex="1" maxlength="45" />
<%} %>



<div class="clear"></div>


<label class="large">Emergency /Portable Equipment</label>
<%if(avAccident.getEmergencyPortableEquipment()!=null){ %> 


<input tabindex="1" type="text"	name="emergencyPortableEquipment" maxlength="10"  class="large" value="<%=avAccident.getEmergencyPortableEquipment() %>"/>
<%}else{ %>
<input tabindex="1" type="text"	name="emergencyPortableEquipment" maxlength="10" value="" class="large"/>
<%} %>

	

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
	<%if(avAccident.getOuterTypeOther()!=null){ %> 


<input tabindex="1" type="text"	name="outerClothingDamaged" maxlength="10"  class="large" value="<%=avAccident.getOuterTypeOther() %>"/>
<%}else{ %>
<input tabindex="1" type="text"	name="outerClothingDamaged" maxlength="10" value="" class="large"/>
<%} %>
</div>
		
</div>



<div class="clear paddingTop15"></div>
<h4>PROTECTIVE HELMET</h4>
<div class="Block">
<label>Mark</label>

<%if(avAccident.getHelmetMark()!=null){ %> 
<input tabindex="1" type="text"	name="protectiveHelmetMark"  maxlength="30" value="<%=avAccident.getHelmetMark() %>"/>
<%}else{ %>
<input tabindex="1" type="text"	name="protectiveHelmetMark" value="" maxlength="30">
<%} %>

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
<input tabindex="1" type="text"	name="markVizor" value="" >

<select name="vizor"  id="vizor" >
			<option value="r">Raised/Lowered</option>
			<option value="d">Damaged</option>
			<option value="u">Undamaged</option>
			<option value="l">Destroyed or Lost</option>
			<option value="k">Not Known</option>
			
</select>
<div class="clear"></div>

<label class="large">Any Comment on the effective of the helmet</label>
<%if(avAccident.getHelmetComment()!=null){ %> 
<textarea rows="" cols="60"	name="commentHelmet" class="auto" onkeyup="chkLength(this,100);">
<%=avAccident.getHelmetComment()%></textarea>
<%}else{ %>
<textarea rows="" cols="60"	name="commentHelmet" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%} %>
</div>

<div class="clear paddingTop15"></div>
<h4>PRESSURE CLOTHING</h4>
<div class="Block">
<label>Partial Pressuresuit</label>
<select name="partialPressuresuit"  id="partialPressuresuit" >
			<option value="n">Not Worn</option>
			<option value="w">Worn</option>
</select>
<label>Mark</label>
<%if(avAccident.getClothingPressuresuitMark()!=null){ %> 

<input tabindex="1" type="text"	name="markPressuresuit" value="<%=avAccident.getClothingPressuresuitMark() %>" maxlength="45">
<%}else{ %>
<input tabindex="1" type="text"	name="markPressuresuit" value="" maxlength="45">
<%} %>
<div class="clear"></div>

<label>Jerkin</label>
<select name="jerkin"  id="jerkin" >
			<option value="n">Not Worn</option>
			<option value="w">Worn</option>
</select>
<label>Mark</label>

<%if(avAccident.getClothingJerkinMark()!=null){ %> 
<input tabindex="1" type="text"	name="markJerkin" value="<%=avAccident.getClothingJerkinMark() %>" maxlength="45">
<%}else{ %>
<input tabindex="1" type="text"	name="markJerkin" value="" maxlength="45">
<%} %>
<div class="clear"></div>

<label>Full Pressure Suit</label>
<select  name="fullPressureSuit"  id="fullPressureSuit" >
			<option value="n">Not Worn</option>
			<option value="w">Worn</option>
</select>
<label>Mark</label>

<%if(avAccident.getClothingFullSuitMark()!=null){ %> 
<input tabindex="1" type="text"	name="markFullPressureSuit" value="<%=avAccident.getClothingFullSuitMark() %>" maxlength="45">
<%}else{ %>
<input tabindex="1" type="text"	name="markFullPressureSuit" value="" maxlength="45">
<%} %>

<div class="clear"></div>

<label>Anti G. Suit</label>
<select  name="antiGSuit"  id="antiGSuit" >
			<option value="n">Not Worn</option>
			<option value="w">Worn</option>
</select>
<label>Mark</label>
<%if(avAccident.getClothingAntiGMark()!=null){ %> 
<input tabindex="1" type="text"	name="markAntiGSuit" value="<%=avAccident.getClothingAntiGMark() %>" maxlength="45">
<%}else{ %>
<input tabindex="1" type="text"	name="markAntiGSuit" value="" maxlength="45">
<%} %>
<div class="clear"></div>

<label class="large">Specify and Function of these items Relevent to the Accident</label>

<%if(avAccident.getReleventRemarks()!=null){ %> 
<textarea rows="" cols="60"	name="specifyFunction" class="auto" onkeyup="chkLength(this,100);">
<%=avAccident.getReleventRemarks()%></textarea>
<%}else{ %>
<textarea rows="" cols="60"	name="specifyFunction" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%} %>
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
<%if(avAccident.getEquipVentilatedMark()!=null){ %> 
<input tabindex="1" type="text"	name="markAirVentilated" value="<%=avAccident.getEquipVentilatedMark() %>" maxlength="45">
<%}else{ %>
<input tabindex="1" type="text"	name="markAirVentilated" value="" maxlength="45">
<%} %>
<div class="clear"></div>

<label>Life Jacket</label>
<select  name="lifeJacket"  id="lifeJacket" >
			<option value="n">Not Worn</option>
			<option value="w">Worn</option>
</select>
<label>Mark</label>
<%if(avAccident.getEquipLifeJacketMark()!=null){ %> 
<input tabindex="1" type="text"	name="markLifeJacket" value="<%=avAccident.getEquipLifeJacketMark() %>" maxlength="45">
<%}else{ %>
<input tabindex="1" type="text"	name="markLifeJacket" value="" maxlength="45">
<%} %>


<div class="clear"></div>

<label>Dinghy</label>
<select  name="dinghy"  id="dinghy" >
			<option value="n">Not Carried</option>
			<option value="c">Carried</option>
</select>
<label>Mark</label>
<%if(avAccident.getEquipDinghyMark()!=null){ %> 
<input tabindex="1" type="text"	name="markDinghy" value="<%=avAccident.getEquipDinghyMark() %>" maxlength="45">
<%}else{ %>
<input tabindex="1" type="text"	name="markDinghy" value="" maxlength="45">
<%} %>



<div class="clear"></div>

<label>Survival Packs</label>
<select  name="survivalPacks"  id="survivalPacks" >
			<option value="n">Not Carried</option>
			<option value="c">Carried</option>
</select>
<label>Type</label>
<%if(avAccident.getEquipType()!=null){ %> 
<input tabindex="1" type="text"	name="typeSurvivalPacks" value="<%=avAccident.getEquipType() %>" maxlength="45">
<%}else{ %>
<input tabindex="1" type="text"	name="typeSurvivalPacks" value="" maxlength="45">
<%} %>
</div>

<div class="clear paddingTop15"></div>
<h3>Part I - Medical History</h3>
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
<%if(avAccident.getHeight()!=null){ %> 
<input	class="auto" tabindex="1" type="text"  name="<%=HEIGHT %>"	tabindex="2" maxlength="20" size="10" value="<%=avAccident.getHeight() %>" >
<%}else{ %>
<input	class="auto" tabindex="1" type="text"  name="<%=HEIGHT %>"	tabindex="2" maxlength="20" size="10"/>
<%} %>


<label class="unit">cm</label>
<input class="transparent" size="3">

<label>Weight</label>
<%if(avAccident.getWeight()!=null){ %> 
<input	class="auto" tabindex="1" type="text"  name="<%=WEIGHT %>"	tabindex="2" maxlength="20" size="10" value="<%=avAccident.getWeight() %>" >
<%}else{ %>
<input	class="auto" tabindex="1" type="text"  name="<%=WEIGHT %>"	tabindex="2" maxlength="20" size="10"/>
<%} %>

<label class="unit">Kg</label>


<div class="clear"></div>

<label>Marital Status</label> 
<select name="srMaritalStatus" id="srmrstatus"	validate="Marital Status of service Person,string,no" tabindex="1">
<option value="s">SINGLE</option>
<option value="m">MARRIED</option>
</select> 


<label>Medical Category </label> 
<select name="medicalCategory" id="medicalCategory"	 tabindex="1">
 <option value="0">Select</option>
 <%
 for (Category category : categoryList) {
		%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%	}%>
</select>				




<label> Date</label>

<%if(avAccident.getMedicalDate()!=null){ %> 
<input	tabindex="1" name="<%=DATE_OF_MB %>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=HMSUtil.changeDateToddMMyyyy(avAccident.getMedicalDate())%>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.<%=DATE_OF_MB%>,event);" />

<%}else{ %>
<input	tabindex="1" name="<%=DATE_OF_MB %>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.<%=DATE_OF_MB%>,event);" />

<%} %>


<div class="clear"></div>



<label>Reason</label>
<%if(avAccident.getMedicalReason()!=null){ %> 
<input	class="large" tabindex="1" type="text"  name="reason"	tabindex="2" maxlength="45" value="<%=avAccident.getMedicalReason()%>"/>
<%}else{ %>
<input	class="large" tabindex="1" type="text"  name="reason"	tabindex="2" maxlength="45" />
<%} %>

<div class="clear"></div>
<label class="large">Medical Condition (At Time Of Flight)</label>
	<select  name="<%=MEDICAL_CONDITION %>"  id="medicalCondition" onchange="();">
		<option value="f">Fully Fit</option>
		<option value="n">Not Fully Fit</option>
		
	</select>

<div id="medicalConditionDiv" style="display: none" >
<label>Reason</label>

<%if(avAccident.getMedicalReason()!=null){ %> 
<input tabindex="1" type="text"	name="<%=REASON_MEDICAL_CONDITION %>" maxlength="50"  value="<%=avAccident.getMedicalConditionReson()%>"/>
<%}else{ %>
<input tabindex="1" type="text"	name="<%=REASON_MEDICAL_CONDITION %>" maxlength="50" value="" />
<%} %>
</div>
<div class="clear"></div>

<label>Medication (Within 4 Weeks Previous To Flight </label> 
<select name="medication" id="medication"	 tabindex="1">
<option value="Nil">Nil</option>
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
<label>Tobacco</label>
<select  name="tobacco"  id="tobacco" >
			<option value="n">Non Smoker</option>
			<option value="s">Smoker</option>
			<option value="c">Cigarettes</option>
			<option value="p">Pipes</option>
</select>
<input	class="auto" tabindex="1" type="text"  name="tobaccoTxt"	tabindex="2" maxlength="20" size="10"/>
<label class="auto">per day</label>
</div>


<div class="clear paddingTop15"></div>

<h3>Part III - Physiological And Psychological Factors</h3>
<div class="Block">
<label>Employment</label>
	<select name="employment"  id="Employment" >
		<option value="p">Pupil</option>
		<option value="s">1st Squadron Appt</option>
		<option value="a">Later Sqdn Appt</option>
		<option value="i">Instructor</option>
		<option value="a">Employed on nonflying Appoinment</option>
	</select>


<label>Extra Qualifications</label>

<%if(avAccident.getExtraQualifications()!=null){ %> 
<input tabindex="1" type="text"  name="extraQualifications"	tabindex="2" maxlength="20"  value="<%=avAccident.getExtraQualifications()%>"/>
<%}else{ %>
<input tabindex="1" type="text"  name="extraQualifications"	tabindex="2" maxlength="20" >

<%} %>


<label>Date of Renewal</label>
<%if(avAccident.getRenewalDate()!=null){ %> 


<input	tabindex="1" name="<%=DATE_RENEWAL %>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=HMSUtil.changeDateToddMMyyyy(avAccident.getRenewalDate())%>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.<%=DATE_RENEWAL%>,event);" />

<%}else{ %>
<input	tabindex="1" name="<%=DATE_RENEWAL %>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.<%=DATE_RENEWAL%>,event);" />

<%} %>


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
		<td>
		<%if(avAccident.getFly241pilot()!=null){ %> 
<input tabindex="1" type="text"	name="24FlyingfirstPilot" maxlength="10"  value="<%=avAccident.getFly241pilot()%>"/><label class="unit">hrs</label>
<%}else{ %>
<input tabindex="1" type="text"	name="24FlyingfirstPilot" maxlength="10" value=""/><label class="unit">hrs</label>

<%} %>
	</td>
		<td>
<%if(avAccident.getFly242pilot()!=null){ %> 
<input tabindex="1" type="text"	name="24FlyingSecPilot" maxlength="10"  value="<%=avAccident.getFly242pilot()%>"/><label class="unit">hrs</label>
<%}else{ %>
<input tabindex="1" type="text"	name="24FlyingSecPilot" maxlength="10" value=""/><label class="unit">hrs</label>

<%} %>
		</td>
		
		<td>
				<%if(avAccident.getFly24Crew()!=null){ %> 
<input tabindex="1" type="text"	name="24FlyingCrew" maxlength="10"   value="<%=avAccident.getFly24Crew()%>"/>value=""/><label class="unit">hrs</label>	
<%}else{ %>
<input tabindex="1" type="text"	name="24FlyingCrew" maxlength="10" value=""/><label class="unit">hrs</label>	

<%} %>
	</td>	
		<td>
				<%if(avAccident.getFly24Type()!=null){ %> 
<input tabindex="1" type="text"	name="24FlyingType" maxlength="10"   value="<%=avAccident.getFly24Type()%>"/><label class="unit">hrs</label>
<%}else{ %>
<input tabindex="1" type="text"	name="24FlyingType" maxlength="10" value=""/><label class="unit">hrs</label>	

<%} %>
		
		</td>
	</tr>
		<tr>
		<td><label>In the last 30 days</label>	</td>
		
		
		<td>
		<%if(avAccident.getFly301pilot()!=null){ %> 
<input tabindex="1" type="text"	name="30FlyingfirstPilot" maxlength="10"  value="<%=avAccident.getFly301pilot()%>"/><label class="unit">hrs</label>
<%}else{ %>
<input tabindex="1" type="text"	name="30FlyingfirstPilot" maxlength="10" value=""/><label class="unit">hrs</label>

<%} %>
	</td>
		<td>
<%if(avAccident.getFly302pilot()!=null){ %> 
<input tabindex="1" type="text"	name="30FlyingSecPilot" maxlength="10"  value="<%=avAccident.getFly302pilot()%>"/><label class="unit">hrs</label>
<%}else{ %>
<input tabindex="1" type="text"	name="30FlyingSecPilot" maxlength="10" value=""/><label class="unit">hrs</label>

<%} %>
		</td>
		
		<td>
				<%if(avAccident.getFly30Crew()!=null){ %> 
<input tabindex="1" type="text"	name="30FlyingCrew" maxlength="10"   value="<%=avAccident.getFly30Crew()%>"/>value=""/><label class="unit">hrs</label>	
<%}else{ %>
<input tabindex="1" type="text"	name="30FlyingCrew" maxlength="10" value=""/><label class="unit">hrs</label>	

<%} %>
	</td>	
		<td>
				<%if(avAccident.getFly30Type()!=null){ %> 
<input tabindex="1" type="text"	name="30FlyingType" maxlength="10"   value="<%=avAccident.getFly30Type()%>"/><label class="unit">hrs</label>
<%}else{ %>
<input tabindex="1" type="text"	name="30FlyingType" maxlength="10" value=""/><label class="unit">hrs</label>	

<%} %>
		
		</td>
		
	</tr>
	<tr>
		<td><label>Since being posted to the flying assignment</label>	</td>
		
		
		<td>
		<%if(avAccident.getFlyPosted1pilot()!=null){ %> 
<input tabindex="1" type="text"	name="flyingfirstPilot" maxlength="10"  value="<%=avAccident.getFlyPosted1pilot()%>"/><label class="unit">hrs</label>
<%}else{ %>
<input tabindex="1" type="text"	name="flyingfirstPilot" maxlength="10" value=""/><label class="unit">hrs</label>

<%} %>
	</td>
		<td>
<%if(avAccident.getFlyPosted2pilot()!=null){ %> 
<input tabindex="1" type="text"	name="flyingSecPilot" maxlength="10"  value="<%=avAccident.getFlyPosted1pilot()%>"/><label class="unit">hrs</label>
<%}else{ %>
<input tabindex="1" type="text"	name="flyingSecPilot" maxlength="10" value=""/><label class="unit">hrs</label>

<%} %>
		</td>
		
		<td>
				<%if(avAccident.getFlyPostedCrew()!=null){ %> 
<input tabindex="1" type="text"	name="flyingCrew" maxlength="10"   value="<%=avAccident.getFlyPostedCrew()%>"/>value=""/><label class="unit">hrs</label>	
<%}else{ %>
<input tabindex="1" type="text"	name="flyingCrew" maxlength="10" value=""/><label class="unit">hrs</label>	

<%} %>
	</td>	
		<td>
				<%if(avAccident.getFlyPostedType()!=null){ %> 
<input tabindex="1" type="text"	name="flyingType" maxlength="10"   value="<%=avAccident.getFlyPostedType()%>"/><label class="unit">hrs</label>
<%}else{ %>
<input tabindex="1" type="text"	name="flyingType" maxlength="10" value=""/><label class="unit">hrs</label>	

<%} %>
		
		</td>
		
	</tr>
		<tr>
		<td><label>Other types of a/c flown</label>	</td>
		
		<td>
		<%if(avAccident.getFlyOther1pilot()!=null){ %> 
<input tabindex="1" type="text"	name="flyingOtherfirstPilot" maxlength="10"  value="<%=avAccident.getFlyOther1pilot()%>"/><label class="unit">hrs</label>
<%}else{ %>
<input tabindex="1" type="text"	name="flyingOtherfirstPilot" maxlength="10" value=""/><label class="unit">hrs</label>

<%} %>
	</td>
		<td>
<%if(avAccident.getFlyOther2pilot()!=null){ %> 
<input tabindex="1" type="text"	name="flyingOtherSecPilot" maxlength="10"  value="<%=avAccident.getFlyOther1pilot()%>"/><label class="unit">hrs</label>
<%}else{ %>
<input tabindex="1" type="text"	name="flyingOtherSecPilot" maxlength="10" value=""/><label class="unit">hrs</label>

<%} %>
		</td>
		
		<td>
				<%if(avAccident.getFlyOtherCrew()!=null){ %> 
<input tabindex="1" type="text"	name="flyingOtherCrew" maxlength="10"   value="<%=avAccident.getFlyOtherCrew()%>"/>value=""/><label class="unit">hrs</label>	
<%}else{ %>
<input tabindex="1" type="text"	name="flyingOtherCrew" maxlength="10" value=""/><label class="unit">hrs</label>	

<%} %>
	</td>	
		<td>
				<%if(avAccident.getFlyOtherType()!=null){ %> 
<input tabindex="1" type="text"	name="flyingOtherType" maxlength="10"   value="<%=avAccident.getFlyOtherType()%>"/><label class="unit">hrs</label>
<%}else{ %>
<input tabindex="1" type="text"	name="flyingOtherType" maxlength="10" value=""/><label class="unit">hrs</label>	

<%} %>
		
		</td>
		
	</tr>
	</table>
	</div>




<div class="clear paddingTop15"></div>
<h4>PRESENT POSTING</h4>
<div class="Block">
<label class="large">Length of time at station</label>
	<%if(avAccident.getLengthTimeStation()!=null){ %> 
<input tabindex="1" type="text"  name="lengthTimeStation"	tabindex="2" maxlength="20" value="<%=avAccident.getLengthTimeStation()%>">
<%}else{ %>
<input tabindex="1" type="text"  name="lengthTimeStation"	tabindex="2" maxlength="20" >

<%} %>
<label>Months</label>
	<%if(avAccident.getLengthTimeMonth()!=null){ %> 
<input tabindex="1" type="text"  name="months"	tabindex="2" maxlength="20" value="<%=avAccident.getLengthTimeMonth()%>">
<%}else{ %>
<input tabindex="1" type="text"  name="months"	tabindex="2" maxlength="20" >

<%} %>
<div class="clear"></div>


<label class="large"> Accommodation At Station</label>
	<%if(avAccident.getAccommodationStation()!=null){ %> 
<input tabindex="1" type="text"  name="accommodationStation"	tabindex="2" maxlength="20" value="<%=avAccident.getAccommodationStation()%>">
<%}else{ %>
<input tabindex="1" type="text"  name="accommodationStation"	tabindex="2" maxlength="20" >

<%} %>
<label class="auto">miles away</label>

<div class="clear"></div>
<label class="large">Type of accommodation</label>
	<%if(avAccident.getTypeAccommodation()!=null){ %> 
<input tabindex="1" type="text"  name="typeAccommodation"	tabindex="2" maxlength="20" value="<%=avAccident.getTypeAccommodation()%>">
<%}else{ %>
<input tabindex="1" type="text"  name="typeAccommodation"	tabindex="2" maxlength="20" >

<%} %>
</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label class="large">Current Flying Assessment: (to be obtained from Commanding Officer)</label>

	<select name="assessmentFlying"  id="flying" >
		<option value="e">Exceptional</option>
		<option value="b">Above Average</option>
		<option value="a">Average</option>
		<option value="b">Below Standard</option>
		
	</select>
	
	<div class="clear"></div>
	<label class="large">Any Relevant Remarks</label>
	<%if(avAccident.getTypeAccommodation()!=null){ %> 
<textarea rows="" cols="60"	name="relevantRemarks" class="auto" onkeyup="chkLength(this,100);">
<%=avAccident.getReleventRemarks()%>
</textarea>

<%}else{ %>
<textarea rows="" cols="60"	name="relevantRemarks" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%} %>
	
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
		<%if(avAccident.getAirAccidentDescription()!=null){ %> 
	<input tabindex="1" type="text"	name="aircraftDescription" maxlength="50" value="<%=avAccident.getAirAccidentDescription()%>" />
<%}else{ %>
<input tabindex="1" type="text"	name="aircraftDescription" maxlength="50" value="" />
<%} %>
	<label>Date</label>
	<%if(avAccident.getAirAccDate()!=null){ %> 
	<input	tabindex="1" name="<%=DATE_TWO%>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=HMSUtil.changeDateToddMMyyyy(avAccident.getAirAccDate())%>"		onKeyUp="mask(this.value,this,'2,5','/');" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.<%=DATE_TWO%>,event);" />
<%}else{ %>
<input	tabindex="1" name="<%=DATE_TWO%>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.<%=DATE_TWO%>,event);" />
<%} %>
	<label>Severity</label>

	<select name="severity"  id="severity" >
	<option value=""></option>

	</select>

	<label>Responsibility</label>
		<%if(avAccident.getAirAccidentDescription()!=null){ %> 
	<input tabindex="1" type="text"	name="responsibility" maxlength="50" value="<%=avAccident.getResponsibility()%>" />
<%}else{ %>
<input tabindex="1" type="text"	name="responsibility" maxlength="50" value="" />
<%} %>
	</div>
	<label>Motoring Accident</label>
	<select name="motoringAccident"  id="motoringAccident" >
		<option value="n">None</option>
		<option value="k">Not Known</option>
	</select>
	
		<label>Other Accident Involving Injury</label>
	<select name="otherAccident"  id="otherAccident" >
		<option value="n">None</option>
		<option value="k">Not Known</option>
	
		
	</select>
</div>


<div class="clear paddingTop15"></div>
<h4>FATIGUE</h4>
<div class="Block">
<label class="large">Time at controls this Flight(if assessable)</label>
	<%if(avAccident.getTimeControls()!=null){ %> 
	<input tabindex="1" type="text"	name="timeControlsFlight" maxlength="10"  value="<%=avAccident.getTimeControls()%>" />
<%}else{ %>
<input tabindex="1" type="text"	name="timeControlsFlight" maxlength="10" value="" />
<%} %>

<label class="small">hrs/ Mts</label>


<div class="clear"></div>

<label class="large">Number of take offs/landings during the sorties</label>

	<%if(avAccident.getTimeControls()!=null){ %> 
	<input tabindex="1" type="text"	name="noTakeOffs" maxlength="10"   value="<%=avAccident.getTimeControls()%>" />
<%}else{ %>
<input tabindex="1" type="text"	name="noTakeOffs" maxlength="10" value="" />
<%} %>



<div class="clear"></div>

<label class="large">Number of sorties in Last 24 hours</label>

	<%if(avAccident.getTimeControls()!=null){ %> 
	<input tabindex="1" type="text"	name="noOfSorties" maxlength="10"  value="<%=avAccident.getTimeControls()%>" />
<%}else{ %>
<input tabindex="1" type="text"	name="noOfSorties" maxlength="10" value="" />
<%} %>



<label class="small">7 Days</label>

	<%if(avAccident.getTimeControls()!=null){ %> 
	<input tabindex="1" type="text"	name="7days" maxlength="10"  value="<%=avAccident.getTimeControls()%>" />
<%}else{ %>
<input tabindex="1" type="text"	name="7days" maxlength="10" value="" />
<%} %>



<div class="clear"></div>

<label class="large">Number of hours duty in 24 hours preceding start of flight</label>

	<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="noOfSorties24" maxlength="10"  value="<%=avAccident.getTimeControls()%>" />
<%}else{ %>
<input tabindex="1" type="text"	name="noOfSorties24" maxlength="10" value="" />
<%} %>


<label class="small">Type duty</label>

<div class="clear"></div>

<label class="large">Amount of sleep(day/night) in 24 hours preceding start of flight</label>

	<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="amountOfSleep" maxlength="10" value="<%=avAccident.getTimeControls()%>" />
<%}else{ %>
<input tabindex="1" type="text"	name="amountOfSleep" maxlength="10" value="" />
<%} %>


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
	<%if(avAccident.getTimeControls()!=null){ %> 
	<input tabindex="1" type="text"	name="recentOtherFactors" maxlength="10"  value="<%=avAccident.getTimeControls()%>" />
<%}else{ %>
	<input tabindex="1" type="text"	name="recentOtherFactors" maxlength="10" value="" />
<%} %>

</div>

<div class="clear"></div>

<label class="large">Amount of Leave taken in Last 6 months</label>

	<%if(avAccident.getTimeControls()!=null){ %> 
	<input tabindex="1" type="text"	name="amountOfLeave" maxlength="10" value="<%=avAccident.getTimeControls()%>" />
<%}else{ %>
<input tabindex="1" type="text"	name="amountOfLeave" maxlength="10" value="" />
<%} %>
</div>

<div class="clear paddingTop15"></div>
<h4>FOOD</h4>
<div class="Block">

<label class="large">Hours since last full meal</label>
	<%if(avAccident.getTimeControls()!=null){ %> 
	<input tabindex="1" type="text"	name="lastMealHours" maxlength="10"  value="<%=avAccident.getTimeControls()%>" />
<%}else{ %>
<input tabindex="1" type="text"	name="lastMealHours" maxlength="10" value="" />
<%} %>


<label class="auto">hr.</label>
<label class="auto">Which was</label>
	<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="whichWas" maxlength="10"  value="<%=avAccident.getTimeControls()%>" />
<%}else{ %>
<input tabindex="1" type="text"	name="whichWas" maxlength="10" value="" />
<%} %>
</div>


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
	<%if(avAccident.getTimeControls()!=null){ %> 
<textarea rows="" cols="78"	name="abnormalfeeding" class="auto" onkeyup="chkLength(this,150);"></textarea>
	<%}else{ %>
	<textarea rows="" cols="78"	name="abnormalfeeding" class="auto" onkeyup="chkLength(this,150);"></textarea>
	<%} %>
</div>


<div class="clear paddingTop15"></div>
<h4>OTHER PHYSIOLOGICAL FACTORS</h4>
<div class="Block">

<label>Intoxication by CO/other fumes</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<textarea rows="" cols="40"	name="intoxication" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%}else{ %>
<%} %>

<label>Hypoxia</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<textarea rows="" cols="40"	name="hypoxia" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%}else{ %>
<%} %>
<div class="clear"></div>
<label>Disorientation in the air</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<textarea rows="" cols="40"	name="disorientation" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%}else{ %>
<%} %>

<label>Air Sickness</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<textarea rows="" cols="40"	name="airSickness" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%}else{ %>
<%} %>
<div class="clear"></div>
<label>Decompression Sickness</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<textarea rows="" cols="40"	name="decompressionSickness" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%}else{ %>
<%} %>


<label>Heat Stress</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<textarea rows="" cols="40"	name="heatStress" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%}else{ %>
<%} %>
<div class="clear"></div>

<label>Cold Injury</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<textarea rows="" cols="40"	name="coldInjury" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%}else{ %>
<%} %>

<label>Accelerations</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<textarea rows="" cols="40"	name="accelerations" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%}else{ %>
<%} %>
<div class="clear"></div>


<label>Hyperventilation</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<textarea rows="" cols="40"	name="hyperventilation" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%}else{ %>
<%} %>
<label>Hypoglycaemin</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<textarea rows="" cols="40"	name="hypoglycaemin" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%}else{ %>
<%} %>
<div class="clear"></div>
<label>Sycope (Other)</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<textarea rows="" cols="40"	name="sycope" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%}else{ %>
<%} %>
<label>Visual Factors in aircraft or environment</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<textarea rows="" cols="40"	name="visualFactorsInAircraft" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%}else{ %>
<%} %>
<div class="clear"></div>
<label>Noise/Vibration</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<textarea rows="" cols="40"	name="noiseVibration" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%}else{ %>
<%} %>
<label>Alcohol</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<textarea rows="" cols="40"	name="alcoholDesc" class="auto" onkeyup="chkLength(this,100);"></textarea>
<%}else{ %>
<%} %>
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
<%if(avAccident.getTimeControls()!=null){ %> 
	<input tabindex="1" type="text"	name="willingReason" maxlength="10" value="" />
	<%}else{ %>
<%} %>
</div>

<div class="clear"></div>

<label class="large">Attitude towards Service</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	class="large" name="attitudeService" maxlength="50" value="" />
<%}else{ %>
<%} %>
<div class="clear"></div>

<label class="large">Attitude towards Shin/Unit</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	class="large" name="shinUnit" maxlength="100" value="" />
<%}else{ %>
<%} %>
<div class="clear"></div>

<label class="large">Attitude towards Flying</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	class="large" name="attitudeFlying" maxlength="100" value="" />
<%}else{ %>
<%} %>
<div class="clear"></div>

<label class="large">Temperament/Emotional Stability</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	class="large" name="temperamentEmotional" maxlength="100" value="" />
<%}else{ %>
<%} %>
<div class="clear"></div>

<label class="large">Discipline/Recent Punishments</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	class="large" name="discipline" maxlength="100" value="" />
<%}else{ %>
<%} %>

<div class="clear"></div>

<label class="large">Confidence in ability to fly</label>


<select name="confidenceAbility"  id="confidence" class="small">
		<option value="o">Over Confident</option>
		<option value="c">Confident</option>
			<option value="n">Not Confident</option>
		
</select>

<label>Remarks</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="remarksConfidence" maxlength="100" class="auto" size="31" value="" />
<%}else{ %>
<%} %>


<div class="clear"></div>

<label class="large">Any evidence of anxiet prior to accident</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	class="large" name="evidenceAccident" maxlength="100" value="" />
<%}else{ %>
<%} %>


<div class="clear"></div>

<label class="large">Trend of conversation after the accident</label>
<select name="trend"  id="trendConversation" class="small">
		<option value="g">Guild</option>
		<option value="f">Fear</option>
			<option value="d">Depression</option>
		
</select>

<label>Remarks</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="remarksTrend" maxlength="100" value="" class="auto" size="31"/>
<%}else{ %>
<%} %>

<div class="clear"></div>

<label class="large">Human Engineering Factors</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	class="large" name="engineeringFactors" maxlength="100" value="" />
<%}else{ %>
<%} %>


<div class="clear"></div>

<label class="auto">Eny haste or hurry in take off or completion of the sortie, apprehension of any malfunction of the aircraft due to its previous history</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="hasteApprehension" maxlength="100" value="" class="auto" size="150" />
<%}else{ %>
<%} %>
<div class="clear"></div>
<label class="auto">This would cover any Human Engineering factor which the M.O. may feel and show that it is involved. Further if any accident pattern is observed the M.O. can state that as well</label>
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text" class="auto" size="150" name="humanEngineering" maxlength="100" value="" />
<%}else{ %>
<%} %>
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
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="remarksScalp" maxlength="100" value="" />
<%}else{ %>
<%} %>


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
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="remarksFace" maxlength="100" value="" />
<%}else{ %>
<%} %>

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
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="remarksNeck" maxlength="100" value="" />
<%}else{ %>
<%} %>

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
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="throaxRemarks" maxlength="100" value="" />
<%}else{ %>
<%} %>
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
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="remarksLtRtHandWrist" maxlength="100" value="" />
<%}else{ %>
<%} %>

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
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="remarksLtRtForearmElbow" maxlength="100" value="" />
<%}else{ %>
<%} %>
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
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="remarksLtRtArmShoulder" maxlength="100" value="" />
<%}else{ %>
<%} %>
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
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="remarksAbdomenAntPost" maxlength="100" value="" />
<%}else{ %>
<%} %>

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
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="remarksLtRtFootAnkle" maxlength="100" value="" />
<%}else{ %>
<%} %>
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
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="remarksLtRtLegKnee" maxlength="100" value="" />
<%}else{ %>
<%} %>
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
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="remarksLtRtThighHip" maxlength="100" value="" />
<%}else{ %>
<%} %>
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
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="remarksLtRtButtocks" maxlength="100" value="" />
<%}else{ %>
<%} %>
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
<%if(avAccident.getTimeControls()!=null){ %> 
<input tabindex="1" type="text"	name="remarksPerineumGenitalia" maxlength="100" value="" />
<%}else{ %>
<%} %>
</div>
<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>

<input tabindex="1" type="hidden"	name="acAccidentId"  maxlength="100" value="<%=avAccident.getId()%>" />

<input	type="button" name="Submit" class="button"  value="Update"  tabindex="1"	 />
<input type="reset" name="Reset" value="Reset" class="button" 	tabindex="1"  accesskey="r" />

<div class="clear"></div>
<div class="division"></div>

--%>

	<%}}else if(avAccidentList.size()==0 && patientList.size() > 0){
	for(Patient patient : patientList){
	%>
<input type="hidden" name="avAccidentId" id="avAccidentId" value=""/>
	<input type="hidden" name="hinId" id="hinId" value="<%=patient.getId()%>"/>
<label> Surname</label>

<%if(patient.getSLastName()!=null){ %> 
<input type="text"	id="Surname" name="surname" value="<%=patient.getSLastName() %>" tabindex="1"  MAXLENGTH="10" />
<%}else{ %>
<input type="text"	id="Surname" name="surname" value="" tabindex="1" MAXLENGTH="10" />
<%} %>

<label> First Name <span>*</span></label>
<%if(patient.getSFirstName()!=null){ %> 
<input type="text"	id="FirstName" name="<%=FIRST_NAME %>" value="<%=patient.getSFirstName() %>" tabindex="1"  MAXLENGTH="10" />
<%}else{ %>
<input type="text"	id="FirstName" name="<%=FIRST_NAME %>" value="" tabindex="1" MAXLENGTH="10" />
<%} %>

<label> Rank </label> 

<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	
	<%for(MasRank masRank : rankList){
	if(patient.getRank().getId().equals(masRank.getId())){ %>	
	<option value="<%=patient.getRank().getId()%>" selected="selected"><%=patient.getRank().getRankName()%></option>
	<%}else{ %>	
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>

	<%}	}	%>
</select>

<div class="clear"></div>
<label>Crew Duty (or Passenger Seating)</label>
<input tabindex="1" type="text"	name="crewDuty" maxlength="10" value="" />	

<% }
}else if(avAccidentList.size()==0 && patientList.size() ==0) {
	%>
<input type="hidden" name="avAccidentId" id="avAccidentId" value=""/>
	<input type="hidden" name="hinId" id="hinId" value=""/>
<label> Surname</label>
<input type="text"	id="Surname" name="surname" value="" tabindex="1" MAXLENGTH="10" />

<label> First Name <span>*</span></label>
<input type="text"	id="FirstName" name="<%=FIRST_NAME %>" value="" tabindex="1" MAXLENGTH="10" />

<label> Rank </label> 

<select	id="<%=RANK_ID %>" name="<%=RANK_ID %>"	validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	
	<%for(MasRank masRank : rankList){%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%	}	%>
</select><div class="clear"></div>
<label>Crew Duty (or Passenger Seating)</label>
<input tabindex="1" type="text"	name="crewDuty" maxlength="10" value="" />	
<%}%>
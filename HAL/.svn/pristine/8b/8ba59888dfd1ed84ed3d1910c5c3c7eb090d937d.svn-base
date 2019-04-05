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
<div class="titleBg">	<h2>POST MORTEM</h2> </div>


<div class="clear"></div>
<form name="postMortem" action="" method="post">


<div class="clear paddingTop15"></div>
<div class="Block">
<label>Service No.<span>*</span></label>
<input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO %>" value="" title="Enter Service No" tabindex="1" validate="Service No,metachar,yes" maxlength="20"  
onblur="submitProtoAjaxWithDivName('postMortem','/hms/hms/aviationMedicine?method=getServiceNoDetailsForRegEquipmentInUse&serviceNo='+this.value,'patientDiv');" />
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
<label>Date Of Death</label>
<input	tabindex="1" name="<%=DATE_OF_DEATH%>" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.<%=DATE_OF_DEATH%>,event);" />

<label>Time Of Death</label>
<input tabindex="1" type="text"	name="timeOfDeath" maxlength="11" value="" />

<div class="clear"></div>

<label>Date Of Autopsy</label>
<input	tabindex="1" name="dateOfAutopsy" class="date"	validate="Last Menstruation Date,date,no" maxlength="10" value="<%=date %>"	onKeyUp="mask(this.value,this,'2,5','/');" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender"	onclick="setdate('',aircraftAccidentInvestigation.dateOfAutopsy,event);" />

<label>Time Of Autopsy</label>
<input tabindex="1" type="text"	name="timeOfAutopsy" maxlength="11" value="" />


<div class="clear"></div>

<label>Casualty Survived</label>
<input tabindex="1" type="text"	name="casualtySurvived" maxlength="30" value="" />
<label>mins/hrs/days/following injury or accident</label>


<label>Condition Of body at Autopsy</label>

<select name="conditionBody" id="conditionBody">
<option value="p">Presrved</option>
<option value="l">Dismembered 1 limib</option>
<option value="i">Dismembered 2 limib</option>
<option value="d">Decapited</option>
<option value="s">Disintegrated</option>
<option value="n">Incinrated</option>
</select>

<select name="conditionBodyAutopsy" id="conditionBodyAutopsy">
<option value="g">Good Condition</option>
<option value="e">Early Post Mortem Changes</option>
<option value="a">Advanced Post Mortem Changes</option>
<option value="p">Putrefaction</option>

</select>


<div class="clear"></div>

<label>Condition in Which Body was Found</label>

<select name="conditionOfBodyFound" id="conditionBodyFound">
<option value="c">Clothed</option>
<option value="p">Partially Clothed</option>
<option value="u">Unclothed</option>
<option value="k">Not Known</option>
</select>

<select name="conditionBodywas" id="conditionBodywas" onchange="showConditionOfBodywasDiv();">
<option value="c">Cold</option>
<option value="m">Moderate Temperature</option>
<option value="h">Hot</option>
<option value="o">Other</option>
</select>

<div id="conditionOfBodywasDiv" style="display: none" >
<label>Other</label>
	<input tabindex="1" type="text"	name="otherConditionOfBodywas" maxlength="100" value="" />

</div>
</div>

<div class="clear paddingTop15"></div>

<div class="Block">
<label>BRAIN Weight</label>
<select name="brainWeight" id="brain" onchange="showBrain();" >
<option value="n">Normal</option>
<option value="a">Any pre-existing lesion</option>
<option value="c">Congestion</option>
<option value="o">Contusion</option>
<option value="h">Haemorrhage</option>
<option value="l">Laceration At</option>
<option value="e">Aneurysms</option>
<option value="v">Anamalous Cerebral Vessels</option>
<option value="c">Ventricular Cysts</option>
</select>
<div id="brainDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksBrain" maxlength="30" value="" />

</div>

<label>Spinal Cord</label>
<select name="spinalCord" id="spinalCord" >
<option value="n">Normal</option>
<option value="e">Not Examined</option>
</select>
<div class="clear"></div>
<label>Any pre-existing lesion</label>
<input tabindex="1" type="text"	name="anyPreExistingLesion" maxlength="45" value="" />

<label>Damage Sustained in Accident</label>
<input tabindex="1" type="text"	name="damageSustainedInAccident" maxlength="45" value="" />

<div class="clear"></div>

<label>Middle Ear</label>
<select name="middleEar" id="middleEar" >
<option value="n">Normal</option>
<option value="e">Not Examined</option>
<option value="r">Unilateral Haemorrhage RT</option>
<option value="l">Unilateral Haemorrhage LT</option>
<option value="u">Unilateral Haemorrhage RT/LT</option>


</select>


<label>Glottis</label>
<select name="glottis" id="glottis" >
<option value="n">Normal</option>
<option value="c">Congestion</option>
<option value="p">Petechiae</option>
<option value="h">Haemorrhage</option>

</select>
<label>Fracture of Cartilage</label>
<input tabindex="1" type="text"	name="fractureOfCartilage" maxlength="45" value="" />
<div class="clear"></div>

<label>Pleural Space</label>
<select name="pleuralSpace" id="pleuralSpace" onchange="showPleuralSpace();">
<option value="n">Normal</option>
<option value="r">Any pre-existing lesion RT</option>
<option value="l">Any pre-existing lesion LT</option>
<option value="p">Pneumothorax Rt</option>
<option value="e">Pneumothorax Lt</option>
<option value="b">Pneumothorax Bilateral</option>
</select>
<div id="pleuralSpaceRtDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksPleuralSpaceRt" maxlength="50" value="" />

</div>
<div id="pleuralSpaceLtDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksPleuralSpaceLt" maxlength="50" value="" />

</div>
<div class="clear"></div>
<label>Hydrothorax</label>

<input tabindex="1" type="text"	name="hydrothoraxRt" maxlength="30" value="" class="auto" size="15" />
<label class="unit">ccs RT</label>

<input tabindex="1" type="text"	name="hydrothoraxLt" maxlength="30" value="" class="auto" size="15" />
<label class="unit">ccs LT</label>


<div class="clear"></div>
<label>Haemothorax</label>

<input tabindex="1" type="text"	name="haemothoraxRt" maxlength="30" value="" class="auto" size="15"/>
<label class="unit">RT</label>


<input tabindex="1" type="text"	name="haemothoraxLt" maxlength="30" value="" class="auto" size="15"/>
<label class="unit">LT</label>

<div class="clear"></div>
<label class="large">Petechiae present on pleural surface on lungs</label>
<input tabindex="1" type="text"	name="petechiae_present" maxlength="30" value="" />


<div class="clear"></div>
<label>Trachea</label>
<select name="trachea" id="" >
<option value="n">Normal</option>
<option value="i">Injured in Accident</option>
<option value="v">Contains vomitus</option>
<option value="b">Blood</option>
<option value="o">other</option>
<option value="e">Evidence of ante mortem burning(Carbon Particles)</option>
</select>

<label>Remarks</label>
<input tabindex="1" type="text"	name="tracheaRemarks" maxlength="45" value="" />

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
			<select name="lungsRight" id="lungsRight" onchange="showLungsRight();">
				<option value="n">Normal</option>
				<option value="l">Any pre-existing lesion</option>
				<option value="i">Weight Motting with rib marking</option>
				<option value="o">Weight Motting without rib marking</option>
			</select>
<div id="lungsRightDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksLungsRight" maxlength="30" value="" />

</div>
		</td>
		<td>
		<select name="lungsLeft" id="lungsLeft" onchange="showLungsLeft();">
				<option value="n">Normal</option>
				<option value="l">Any pre-existing lesion</option>
				<option value="i">Weight Motting with rib marking</option>
				<option value="o">Weight Motting without rib marking</option>
			</select>
			<div id="lungsLeftDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksLungsLeft" maxlength="30" value="" />

</div>
		</td>
		
	</tr>
		<tr>
		<td><label>Oedema/haemorrhagic oedema of </label>	</td>
		<td>
			<input tabindex="1" type="text"	name="lungOedemaRt" maxlength="30" value=""/>
			degree in
			<input tabindex="1" type="text"	name="lungOedemaDegreeRt" maxlength="30" value=""/>
			lobes
		</td>
		<td>
			<input tabindex="1" type="text"	name="lungOedemaLt" maxlength="30" value=""/>
			degree in
			<input tabindex="1" type="text"	name="lungOedemaDegreeLt" maxlength="30" value=""/>
			lobes
		</td>
	</tr>
		<tr>
		<td><label>Haemorrhage of</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="lungHaemorrhageRt" maxlength="30" value=""/>
			degree in
			<input tabindex="1" type="text"	name="lungHaemorrhageDegreeRt" maxlength="30" value=""/>
			lobes
		</td>
		<td>
			<input tabindex="1" type="text"	name="lungHaemorrhageLt" maxlength="30" value=""/>
			degree in
			<input tabindex="1" type="text"	name="lungHaemorrhageDegreeLt" maxlength="30" value=""/>	
			lobes
		</td>
	</tr>
		<tr>
		<td><label>Traumatic emphysema present in</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="lungTraumaticRt" maxlength="30" value=""/>
			lobes
			
		</td>
		<td>
			<input tabindex="1" type="text"	name="lungTraumaticLt" maxlength="30" value=""/>
			lobes
			
		</td>
	</tr>
		<tr>
		<td><label>Collapse of </label>	</td>
		<td>
			<input tabindex="1" type="text"	name="lungCollapseRt" maxlength="30" value=""/>
		degree in
			<input tabindex="1" type="text"	name="lungCollapseRtDegree" maxlength="30" value=""/>
		lobes
		</td>
		<td>
			<input tabindex="1" type="text"	name="lungCollapseLt" maxlength="30" value=""/>
			degree in
			<input tabindex="1" type="text"	name="lungCollapseLtDegree" maxlength="30" value=""/>
			lobes	
		</td>
	</tr>
		<tr>
		<td><label>Rupture/laceration</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="lungRuptureRt" maxlength="30" value=""/>
		</td>
		<td>
			<input tabindex="1" type="text"	name="lungRuptureLt" maxlength="30" value=""/>	
		</td>
	</tr>
		<tr>
				<td><label>Fat and marrow emboil and extent</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="lungFatMarrowRt" maxlength="30" value=""/>
		</td>
		<td>
			<input tabindex="1" type="text"	name="lungFatMarrowLt" maxlength="30" value=""/>	
		</td>
	</tr>
		
		
</table>
</div>

<div class="clear paddingTop15"></div>

<div class="Block">
<label>Pericardium</label>
<select name="pericardium" id="pericardium"  onchange="showPericardium();">
<option value="n">Normal</option>
<option value="a">Any pre-existing lesion</option>
<option value="p">Petechine present on visceral surface</option>

</select>

<div id="pericardiumDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksPericardium" maxlength="50" value="" />

</div>



<div class="clear"></div>
<label>Bruising of</label>
<input tabindex="1" type="text"	name="bruisingDegree" maxlength="30" value="" />
<label class="unit">degree</label>


<div class="clear"></div>

<label>Haemopericardium of</label>
<input tabindex="1" type="text"	name="haemopericardiumOf" maxlength="30" value="" />
<label class="unit">css</label>




<label>Hydropcricardium of</label>
<input tabindex="1" type="text"	name="hydropcricardiumOf" maxlength="30" value="" />
<label class="unit">css.</label>


<div class="clear"></div>

<label>Lacerations at</label>
<input tabindex="1" type="text"	name="lacerations" maxlength="30" value="" />

<input class="transparent" size="6" />

<label class="auto">with heart in situ/displaced to</label>
<input tabindex="1" type="text"	name="heartSituDisplced" class="auto" size="33" maxlength="30" value="" />
<div class="clear"></div>

</div>
<div class="clear paddingTop15"></div>

<div class="Block">
<label>Heart</label>
<select name="heart" id="heart"  onchange="showHeart();">
<option value="n">Normal</option>
<option value="a">Any pre-existing lesion</option>
<option value="c">Foremen ovale closed</option>
<option value="p">Foremen ovale patent</option>
</select>


<div id="heartDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksHeart" maxlength="30" value="" />

</div>

<label>Weight</label>
<input tabindex="1" type="text"	name="weight" maxlength="6" value="" />

<div class="clear"></div>

<label>Endocardial rupture at</label>
<input tabindex="1" type="text"	name="endocardialRupture" maxlength="30" value="" />


<label>Pentrating wound of</label>
<input tabindex="1" type="text"	name="pentratingWound" maxlength="30" value="" />
<label>degree caused by</label>
<input tabindex="1" type="text"	name="degree_cause" maxlength="15" value="" />

<div class="clear"></div>
<label>involving</label>
<input tabindex="1" type="text"	name="involving" maxlength="15" value="" />

<label>Full thickness rupture at</label>
<input tabindex="1" type="text"	name="fullThickness" maxlength="30" value="" />


</div>

<div class="clear paddingTop15"></div>

<div class="Block">
<label>Coronary-Arteries</label>
<select name="coronaryArteries" id="coronary"  onchange="showCoronary();">
<option value="n">Normal,Atheroma with adequate lumen</option>
<option value="l">Atheroma with severe restricition of lumen</option>
<option value="d">Atheroma with desgenerative changes</option>
<option value="s">Short description of coronary circulation if abnormal</option>
</select>


<div id="coronaryDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksCoronary" maxlength="30" value="" />

</div>
</div>

<div class="clear paddingTop15"></div>

<div class="Block">
<label>Aorta</label>
<select name="aorta" id="aorta"  onchange="showAorta();">
<option value="n">Normal</option>
<option value="a">Any pre-existing lesion</option>
</select>


<div id="aortaDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksAorta" maxlength="50" value="" />

</div>

<label>Trauma Involving</label>
	<input tabindex="1" type="text"	name="traumaInvolving" maxlength="30" value="" />

<label>Laceration-Location</label>
	<input tabindex="1" type="text"	name="lacerationLocation" maxlength="30" value="" />


</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label>Other Great Vessels</label>
<select name="otherGreatVessels" id="otherGreatVessels"  onchange="showOtherGreatVessels();">
<option value="n">Normal</option>
<option value="a">Any pre-existing lesion</option>
</select>


<div id="otherGreatVesselsDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksOtherGreatVessels" maxlength="30" value="" />

</div>

<label>Trauma Involving</label>
	<input tabindex="1" type="text"	name="traumainvolvingOtherGreatVessels" maxlength="30" value="" />
	<input tabindex="1" type="text"	name="traumaInvolvingVessels" maxlength="30" value="" />
</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label>Diaphragam</label>
<select name="diaphragam" id="diaphragam"  onchange="showDiaphragam();">
<option value="n">Normal</option>
<option value="b">Brusing</option>
<option value="r">Rupture RT</option>
<option value="l">Rupture LT</option>
<option value="i">Rupture Bilateral</option>
<option value="h">Herniation of Viscera(Specify)</option>
</select>


<div id="diaphragamDiv" style="display: none" >
<label>Specify</label>

	<input tabindex="1" type="text"	name="specifyOtherGreatVessels" maxlength="30" value="" />

	<input tabindex="1" type="text"	name="specifyDiaphragam" maxlength="30" value="" />


</div>
</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label>Peritoneum</label>
<select name="peritoneum" id="peritoneum"  onchange="showPeritoneum();">
<option value="n">Normal</option>
<option value="a">Any pre-existing lesion</option>
</select>


<div id="peritoneumDiv" style="display: none" >
<label>Remarks</label>

	<input tabindex="1" type="text"	name="remarksOtherGreatVessels" maxlength="45" value="" />

	<input tabindex="1" type="text"	name="remarksPeritoneum" maxlength="45" value="" />


</div>


<div class="clear"></div>

<label>Retromesenteric Haemorrhange of</label>

	<input tabindex="1" type="text"	name="retromesentericHaemorrhangeOf" maxlength="45" value="" />

	<input tabindex="1" type="text"	name="retromesentericHaemo" maxlength="45" value="" />

<label class="unit">degree</label>



<label>Haemoperitoneum of</label>
	<input tabindex="1" type="text"	name="haemoperitoneumOf" maxlength="30" value="" />
<label class="unit">css</label>


<label>Hydroperitoneum of</label>
	<input tabindex="1" type="text"	name="hydroperitoneumOf" maxlength="30" value="" />
<label class="unit">css</label>


<div class="clear"></div>

<label>Laceration of peritoncum at</label>

	<input tabindex="1" type="text"	name="lacerationOfPeritoncumAt" maxlength="30" value="" />

	<input tabindex="1" type="text"	name="lacerationPeritoncumAt" maxlength="30" value="" />


</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label>Oesophagus</label>
<select name="oesophagus" id="oesophagus"  onchange="showOesophagus();">
<option value="n">Normal</option>
<option value="a">Any pre-existing lesion</option>
<option value="c">Contains stomach content</option>
<option value="e">Evidence of ante mortem burning</option>
<option value="i">Injured in accident</option>
</select>


<div id="oesophagusDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksOesophagus" maxlength="30" value="" />

</div>


</div>

<div class="clear paddingTop15"></div>

<div class="Block">
<label>Stomach</label>
<select name="stomach" id="stomach"  onchange="showStomach();">
<option value="n">Normal</option>
<option value="a">Any pre-existing lesion</option>
<option value="d">Distension</option>
<option value="b">Rupture into abdomen</option>
<option value="t">Rupture into thorax</option>
<option value="m">Post mortem digestion</option>
</select>


<div id="stomachDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksStomach" maxlength="30" value="" />

</div>

</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label>Intestines</label>
<select name="intestines" id="intestines"  onchange="showIntestines();">
<option value="n">Normal</option>
<option value="a">Any pre-existing lesion</option>

</select>


<div id="intestinesDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksIntestines" maxlength="30" value="" />

</div>

<label>Distension Rupture at</label> 
	<input tabindex="1" type="text"	name="distensionRuptureAt" maxlength="30" value="" />
	
	
<div class="clear"></div>
<label>Haemorrhage of wall/into lumen of</label> 
<input tabindex="1" type="text"	name="haemorrhage" maxlength="10" value="" />
<label class="auto">degree involving</label>
	
</div>



<div class="clear paddingTop15"></div>

<div class="Block">
<label>Liver</label>
<select name="liver" id="liver"  onchange="showLiver();">
<option value="n">Normal</option>
<option value="a">Any pre-existing lesion</option>

</select>


<div id="liverDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksLiver" maxlength="30" value="" />

</div>

<label>Weight</label> 
	<input tabindex="1" type="text"	name="weightLiver" maxlength="10" value="" />
	
	
<div class="clear"></div>
<label>Trauma of </label> 
<input tabindex="1" type="text"	name="traumaOf" maxlength="15" value="" />
<label>degree caused by</label>
<input tabindex="1" type="text"	name="degreeTraumaOf" maxlength="30" value="" />
	
</div>

<div class="clear paddingTop15"></div>

<div class="Block">
<label>Pancreas</label>
<select name="pancreas" id="pancreas"  onchange="showPancreas();">
<option value="n">Normal</option>
<option value="a">Any pre-existing lesion</option>

</select>


<div id="pancreasDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksPancreas" maxlength="30" value="" />

</div>

<label>Weight</label> 
	<input tabindex="1" type="text"	name="weightPancreas" maxlength="10" value="" />
	
	
<div class="clear"></div>
<label>Trauma of </label> 
<input tabindex="1" type="text"	name="traumaOfPancreas" maxlength="15" value="" />
<label>degree caused by</label>

<input tabindex="1" type="text"	name="degreeTraumaOfPancreas" maxlength="30" value="" />

<input tabindex="1" type="text"	name="degreeTraumaPancreas" maxlength="30" value="" />

	
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
			<select name="kidneyRt" id="kidneyRt" onchange="showKidneyRt();">
				<option value="n">Normal</option>
				<option value="a">Any pre-existing lesion</option>
				
			</select>
			<div id="kidneyRtDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksKidneyRt" maxlength="30" value="" />

</div>
		</td>
		<td>
						<select name="kidneyLt" id="kidneyLt" onchange="showKidneyLt();">
				<option value="n">Normal</option>
				<option value="a">Any pre-existing lesion</option>
				
			</select>
			<div id="kidneyLtDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksKidneyLt" maxlength="30" value="" />

</div>
		</td>
		
		
	</tr>
		<tr>
		<td><label>Rupture/Laccration of </label>	</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="kidneyLaccrationRt" maxlength="30" value=""/>

			degree casued by
			<div class="clear"></div>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="kidneyLaccRtDegree" maxlength="30" value=""/>

	
		</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="kidneyLaccrationLt" maxlength="30" value=""/>

			degree casued by
			<div class="clear"></div>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>	

			<input tabindex="1" type="text"	name="kidneyLaccLtDegree" maxlength="30" value=""/>	

		
		</td>
	</tr>
		<tr>
		<td><label>Perirenal haemorrhage of</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="kidneyPeriglandularRt" maxlength="30" value=""/>
			degree
		
		</td>
		<td>
			<input tabindex="1" type="text"	name="kidneyPeriglandularLt" maxlength="30" value=""/>
			degree
			
		</td>
	</tr>
		<tr>
		<td><label>Intrarenal haemorrhage of</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="kidneyIntraglandularRt" maxlength="30" value=""/>
			degree
			
		</td>
		<td>
			<input tabindex="1" type="text"	name="kidneyIntraglandularLt" maxlength="30" value=""/>
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
		<select name="adrenalRt" id="adrenalRt" onchange="showAdrenalRt();">
				<option value="n">Normal</option>
				<option value="a">Any pre-existing lesion</option>
				
			</select>
			<div id="adrenalRtDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksAdrenalRt" maxlength="30" value="" />

</div>
		</td>
		<td>
			<select name="adrenalLt" id="adrenalLt" onchange="showAdrenalLt();">
				<option value="n">Normal</option>
				<option value="a">Any pre-existing lesion</option>
				
			</select>
			<div id="adrenalLtDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksAdrenalLt" maxlength="30" value="" />

</div>
		</td>
		
	</tr>
		<tr>
		<td><label>Laccration of </label>	</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="adrenalLaccrationRt" maxlength="30" value=""/>

			degree casued by
			<div class="clear"></div>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="adrenalLaccRtDegree" maxlength="30" value=""/>

	
		</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="adrenalLaccrationLt" maxlength="30" value=""/>

			degree casued by
			<div class="clear"></div>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>	

			<input tabindex="1" type="text"	name="adrenalLaccLtDegree" maxlength="30" value=""/>	

		
		</td>
	</tr>
		<tr>
		<td><label>Periglandular haemorrhage  of</label>	</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="adrenalPeriglandularRt" maxlength="30" value=""/>

			degree
		
		</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="adrenalPeriglandularLt" maxlength="30" value=""/>

			degree
			
		</td>
	</tr>
		<tr>
		<td><label>Intraglandular haemorrhage of</label>	</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="adrenalIntraglandularRt" maxlength="30" value=""/>

			degree
			
		</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="adrenalIntraglandularLt" maxlength="30" value=""/>

			degree
			
			
		</td>
	</tr>
	</table>
	</div>
	
	<div class="clear paddingTop15"></div>

<div class="Block">
<label>Pelvic Organs</label>
<select name="pelvicOrgans" id="pelvicOrgans"  onchange="showPelvicOrgans();">
<option value="n">Normal</option>
<option value="a">Any pre-existing lesion</option>
<option value="d">Damaged in accident(Specify)in association with(any bony injury)</option>
</select>


<div id="pelvicOrgansDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksPelvicOrgans" maxlength="30" value="" />

</div>
<div id="pelvicOrgansDamagedDiv" style="display: none" >
<label>any bony injury</label>
	<input tabindex="1" type="text"	name="anyBonyInjury" maxlength="30" value="" />

</div>

</div>
	
	
	
	<div class="clear paddingTop15"></div>

<div class="Block">
<label>Pituitary</label>
<select name="pituitary" id="pituitary"  onchange="showPituitary();">
<option value="n">Normal</option>
<option value="e">Not Examined</option>
<option value="a">Any pre-existing lesion</option>
</select>


<div id="pituitaryDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksPituitary" maxlength="30" value="" />
</div>

<label>Haemorrhage of</label>

<input tabindex="1" type="text"	name="haemorrhageOf" maxlength="30" value="" />

<input tabindex="1" type="text"	name="haemorrhageDegree" maxlength="30" value="" />

<label class="unit">degree</label>

</div>

	<div class="clear paddingTop15"></div>

<div class="Block">
<label>Thymus</label>
<select name="thymus" id="thymus" >
<option value="n">Normal</option>
<option value="e">Enlarged</option>
</select>

<label>Weight</label>
	<input tabindex="1" type="text"	name="weightThymus" maxlength="10" value="" />


<div class="clear"></div>

<label>Haemorrhage of</label>

<input tabindex="1" type="text"	name="haemorrhageOfThymus" maxlength="30" value="" />

<input tabindex="1" type="text"	name="thymusHaemorrhage" maxlength="30" value="" />

<label class="unit">degree</label>

</div>


	<div class="clear paddingTop15"></div>

<div class="Block">
<label>Thyroid</label>
<select name="thyroid" id="thyroid" onchange="showThyroid();">
<option value="n">Normal</option>
<option value="a">Any pre-existing lesion</option>
<option value="t">Any traumatic changes</option>
</select>


<div id="thyroidDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksThyroid" maxlength="30" value="" />
</div>


<div id="thyroidTraumaticDiv" style="display: none" >

<label>Remarks Traumatic Changes</label>
	<input tabindex="1" type="text"	name="remarksThyroidTraumatic" maxlength="30" value="" />
</div>


<label>Weight</label>
	<input tabindex="1" type="text"	name="weightThyroid" maxlength="10" value="" />

</div>


	<div class="clear paddingTop15"></div>

<div class="Block">
<label>Lymph Glands</label>
<select name="lymphGlands" id="lymphGlands" onchange="showLymphGlands();">
<option value="n">Normal</option>
<option value="a">Any pre-existing lesion</option>
</select>

<div id="lymphGlandsDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksLymphGlands" maxlength="30" value="" />
</div>

</div>
<div class="clear paddingTop15"></div>

<div class="Block">
<label>Air Embolism</label>

<label>No Evidence</label>
<input tabindex="1" type="checkbox"	name="noEvidence" class="radioAuto" />


<label>Found at</label>

<input tabindex="1" type="text"	name="noEvidence" maxlength="30" value="" />

<input tabindex="1" type="text"	name="foundAt" maxlength="30" value="" />

<label class="auto">significance</label>
</div>
	<div class="clear paddingTop15"></div>

<div class="Block">
<label>Fat Embolism</label>
<select name="fatEmbolism" id="fatEmbolism" onchange="showFatEmbolism();">
<option value="g">No Gross Evidence</option>
<option value="e">Evidence Found</option>
</select>

<div id="fatEmbolismDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksFatEmbolism" maxlength="45" value="" />
</div>

</div>


	<div class="clear paddingTop15"></div>

<div class="Block">
<label>Carbon Monoxide Poisoning</label>
<select name="carbon" id="carbon" onchange="showCarbon();">
<option value="n">No Evidence</option>
<option value="a">Autopsy Evidence</option>
</select>


<div id="carbonDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksCarbon" maxlength="30" value="" />
</div>


<div class="clear"></div>

<label>Estimated at</label>
<input tabindex="1" type="text"	name="estimatedAt" maxlength="30" value="" />

<label>Labratory</label>
<input tabindex="1" type="text"	name="labratory" maxlength="30" value="" />
</div>


<div class="clear paddingTop15"></div>
<div class="Block">
<label>Other Poisonings</label>
<select name="otherPoisonings" id="otherPoisonings" onchange="showOtherPoisonings();">
<option value="n">No Evidence</option>
<option value="a">Autopsy Evidence</option>
</select>


<div id="otherPoisoningsDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksOtherPoisonings" maxlength="30" value="" />
</div>


<div class="clear"></div>

<label>Presence Confirmed At</label>
<input tabindex="1" type="text"	name="presenceConfirmedAt" maxlength="30" value="" />

<label>Labratory</label>

<input tabindex="1" type="text"	name="labratoryOther" maxlength="30" value="" />

<input tabindex="1" type="text"	name="poisonings_labratory" maxlength="30" value="" />

</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<label>Hypoxia</label>
<select name="hypoxia" id="hypoxia" onchange="showHypoxia();">
<option value="n">No Evidence</option>
<option value="a">Autopsy Evidence</option>
</select>


<div id="hypoxiaDiv" style="display: none" >
<label>Remarks</label>
	<input tabindex="1" type="text"	name="remarksHypoxia" maxlength="30" value="" />
</div>
</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label>Other Conditions</label>
<textarea rows="" cols="60"	name="otherConditions" class="auto" onkeyup="chkLength(this,100);"></textarea>
</div>


<div class="clear paddingTop15"></div>
<h4>Causation Of Injuries</h4>

<div class="Block">
<label class="large">Summaries the major injuries sustained by causes</label>

<textarea rows="" cols="60"	name="otherConditions" class="" onkeyup="chkLength(this,100);"></textarea>

<textarea rows="" cols="60"	name="injuriesSummaries" class="" onkeyup="chkLength(this,100);"></textarea>

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

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="anteMortemAir" maxlength="30" value=""/>

			
	
		</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="postMortemAir" maxlength="30" value=""/>

			
		
		</td>
	</tr>
		<tr>
		<td><label>At altitude while escaping</label>	</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="ante_mortem_alt_escap" maxlength="30" value=""/>

		
		
		</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="post_mortem_alt_escap" maxlength="10" value=""/>

			
		</td>
	</tr>
		<tr>
		<td><label>On ground following escape</label>	</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="ante_ground_impact" maxlength="30" value=""/>

			
			
		</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="post_ground_impact" maxlength="30" value=""/>

			
			
			
		</td>
	</tr>
	
	<tr>
		<td><label>In aircraft at ground impact</label>	</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="ante_ground_escape" maxlength="30" value=""/>

			
			
		</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="post_ground_escape" maxlength="30" value=""/>

			
			
			
		</td>
	</tr>
			<tr>
		<td><label>While being thrown from aircraft at impact</label>	</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

			<input tabindex="1" type="text"	name="ante_aircraft_impact" maxlength="10" value=""/>

			
			
		</td>
		<td>

			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>
			
			
			

			<input tabindex="1" type="text"	name="post_aircraft_impact" maxlength="30" value=""/>

		</td>
	</tr>
			<tr>
		<td><label>On spontancous ejection</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>
			
			
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>
			
			
			
		</td>
	</tr>
			<tr>
		<td><label>Other causes</label>	</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>
			
			
		</td>
		<td>
			<input tabindex="1" type="text"	name="" maxlength="30" value=""/>
			
			
			
		</td>
	</tr>
	</table>
	</div>

<div class="clear paddingTop15"></div>
<h4>Pre-Existing Disease</h4>
<div class="Block">
<label class="large">Summaries any physical conditions discovered which may have contributed to pilot error or incapability</label>

<textarea rows="" cols="60"	name="summariesAnyPhysical" class="" onkeyup="chkLength(this,100);"></textarea>

<textarea rows="" cols="60"	name="summariesPhysicalCondition" class="" onkeyup="chkLength(this,100);"></textarea>

</div>



<div class="clear paddingTop15"></div>

<div class="Block">
<label class="large">Histological</label>
<input tabindex="1" type="text"	name="histological" maxlength="30" value=""/>
<div class="clear"></div>
<label class="large">No Material taken for histology</label>

<input tabindex="1" type="text"	name="noMaterial" maxlength="30" value=""/>

<input tabindex="1" type="text"	name="material_histology" maxlength="30" value=""/>

<div class="clear"></div>
<label class="large">Material taken for histology and examinated at</label>

<input tabindex="1" type="text"	name="material" maxlength="30" value=""/>

<input tabindex="1" type="text"	name="histological_examinated" maxlength="30" value=""/>

</div>
<div class="clear paddingTop15"></div>

<div class="Block">
<label class="large">Toxicological & Biohemical</label>

<input tabindex="1" type="text"	name="toxicologicalBiochemical" maxlength="30" value=""/>

<input tabindex="1" type="text"	name="toxicological" maxlength="30" value=""/>

<div class="clear"></div>
<label class="large">No specimens taken for such examination</label>

<input tabindex="1" type="text"	name="noMaterial" maxlength="30" value=""/>

<input tabindex="1" type="text"	name="specimens_exam" maxlength="30" value=""/>

	
<div class="clear"></div>
<label class="large">The follwoing specimens were taken for estimation of the substances stated and examined at </label>
<div class="clear"></div>

<input tabindex="1" type="text"	name="material" maxlength="30" value=""/><label class="auto">for</label><input tabindex="1" type="text"	name="material" maxlength="10" value=""/>

<input tabindex="1" type="text"	name="specimens_estimation1" maxlength="30" value=""/>
<label class="auto">for</label>
<input tabindex="1" type="text"	name="specimens_estimation_for1" maxlength="30" value=""/>

<div class="clear"></div>

<input tabindex="1" type="text"	name="material" maxlength="30" value=""/><label class="auto">for</label><input tabindex="1" type="text"	name="material" maxlength="10" value=""/>

<input tabindex="1" type="text"	name="specimens_estimation2" maxlength="30" value=""/>
<label class="auto">for</label>
<input tabindex="1" type="text"	name="specimens_estimation_for2" maxlength="30" value=""/>

<div class="clear"></div>

<input tabindex="1" type="text"	name="material" maxlength="30" value=""/><label class="auto">for</label><input tabindex="1" type="text"	name="material" maxlength="10" value=""/>

<input tabindex="1" type="text"	name="specimens_estimation3" maxlength="30" value=""/>
<label class="auto">for</label>
<input tabindex="1" type="text"	name="specimens_estimation_for3" maxlength="30" value=""/>

</div>


<div class="clear paddingTop15"></div>

<div class="Block">
<label>Cause Of Death</label>

<input tabindex="1" type="text"	name="toxicologicalBiochemical" maxlength="30" value=""/>

<input tabindex="1" type="text"	name="causeDeath" maxlength="100" value=""/>


<label class="large">Disease or condition directly leading to dealth</label>

<input tabindex="1" type="text"	name="noMaterial" maxlength="30" value=""/>

<input tabindex="1" type="text"	name="DeathDiseaseCondition" maxlength="30" value=""/>


<div class="clear"></div>

<label>Antecedent</label>

<input tabindex="1" type="text"	name="noMaterial" maxlength="30" value=""/>

<input tabindex="1" type="text"	name="Antecedent" maxlength="30" value=""/>

<label class="auto">due to or as a consequence of</label>

<div class="clear"></div>
<label>Causes</label>

<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

<input tabindex="1" type="text"	name="causes" maxlength="30" value=""/>

<label  class="auto">due to or as a consequence of</label>

<div class="clear"></div>

<label>Other Significant conditions</label>
<textarea rows="" cols="60"	name="summariesAnyPhysical" class="auto" onkeyup="chkLength(this,100);"></textarea>

</div>


<div class="clear paddingTop15"></div>
<h4>Signature of Pathologist/M.O. Performinh Postmortem</h4>

<div class="Block">
<label>Name in Capitals</label>


<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

<input tabindex="1" type="text"	name="capitalName" maxlength="30" value=""/>

<label>Appoinment</label>

<input tabindex="1" type="text"	name="" maxlength="30" value=""/>

<input tabindex="1" type="text"	name="appointment" maxlength="30" value=""/>

</div>



<input tabindex="1"  type=button value="Submit" class=button  accessKey=r  
onclick="submitForm('postMortem','/hms/hms/aviationMedicine?method=submitPostMortem&flag=postMortem');"/>
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
function showConditionOfBodywasDiv(){
	if(document.getElementById('conditionBodywas').value == 'o'){
	  	document.getElementById("conditionOfBodywasDiv").style.display='inline';
	}else{
		document.getElementById("conditionOfBodywasDiv").style.display='none';
	}

}
function showBrain(){
	if(document.getElementById('brain').value == 'a'){
	  	document.getElementById("brainDiv").style.display='inline';
	}else{
		document.getElementById("brainDiv").style.display='none';
	}

}
function showLungsRight(){
	if(document.getElementById('lungsRight').value == 'l'){
	  	document.getElementById("lungsRightDiv").style.display='inline';
	}else{
		document.getElementById("lungsRightDiv").style.display='none';
	}

}
function showLungsLeft(){
	if(document.getElementById('lungsLeft').value == 'l'){
	  	document.getElementById("lungsLeftDiv").style.display='inline';
	}else{
		document.getElementById("lungsLeftDiv").style.display='none';
	}

}
function showPituitary(){
	if(document.getElementById('pituitary').value == 'a'){
	  	document.getElementById("pituitaryDiv").style.display='inline';
	}else{
		document.getElementById("pituitaryDiv").style.display='none';
	}

}

function showPleuralSpace(){
	if(document.getElementById('pleuralSpace').value == 'r'){
	  	document.getElementById("pleuralSpaceRtDiv").style.display='inline';
	}else{
		document.getElementById("pleuralSpaceRtDiv").style.display='none';
	}
	if(document.getElementById('pleuralSpace').value == 'l'){
	  	document.getElementById("pleuralSpaceLtDiv").style.display='inline';
	}else{
		document.getElementById("pleuralSpaceLtDiv").style.display='none';
	}

}
function showKidneyRt(){
	if(document.getElementById('kidneyRt').value == 'a'){
	  	document.getElementById("kidneyRtDiv").style.display='inline';
	}else{
		document.getElementById("kidneyRtDiv").style.display='none';
	}

}
function showKidneyLt(){
	if(document.getElementById('kidneyLt').value == 'a'){
	  	document.getElementById("kidneyLtDiv").style.display='inline';
	}else{
		document.getElementById("kidneyLtDiv").style.display='none';
	}

}
function showAdrenalRt(){
	if(document.getElementById('adrenalRt').value == 'a'){
	  	document.getElementById("adrenalRtDiv").style.display='inline';
	}else{
		document.getElementById("adrenalRtDiv").style.display='none';
	}

}
function showAdrenalLt(){
	if(document.getElementById('adrenalLt').value == 'a'){
	  	document.getElementById("adrenalLtDiv").style.display='inline';
	}else{
		document.getElementById("adrenalLtDiv").style.display='none';
	}

}

function showPericardium(){
	if(document.getElementById('pericardium').value == 'a'){
	  	document.getElementById("pericardiumDiv").style.display='inline';
	}else{
		document.getElementById("pericardiumDiv").style.display='none';
	}

}

function showHeart(){
	if(document.getElementById('heart').value == 'a'){
	  	document.getElementById("heartDiv").style.display='inline';
	}else{
		document.getElementById("heartDiv").style.display='none';
	}

}
function showCoronary(){
	if(document.getElementById('coronary').value == 's'){
	  	document.getElementById("coronaryDiv").style.display='inline';
	}else{
		document.getElementById("coronaryDiv").style.display='none';
	}

}

function showAorta(){
	if(document.getElementById('aorta').value == 'a'){
	  	document.getElementById("aortaDiv").style.display='inline';
	}else{
		document.getElementById("aortaDiv").style.display='none';
	}

}
function showOtherGreatVessels(){
	if(document.getElementById('otherGreatVessels').value == 'a'){
	  	document.getElementById("otherGreatVesselsDiv").style.display='inline';
	}else{
		document.getElementById("otherGreatVesselsDiv").style.display='none';
	}

}

function showDiaphragam(){
	if(document.getElementById('diaphragam').value == 'h'){
	  	document.getElementById("diaphragamDiv").style.display='inline';
	}else{
		document.getElementById("diaphragamDiv").style.display='none';
	}

}
function showPeritoneum(){
	if(document.getElementById('peritoneum').value == 'a'){
	  	document.getElementById("peritoneumDiv").style.display='inline';
	}else{
		document.getElementById("peritoneumDiv").style.display='none';
	}

}
function showOesophagus(){
	if(document.getElementById('oesophagus').value == 'a'){
	  	document.getElementById("oesophagusDiv").style.display='inline';
	}else{
		document.getElementById("oesophagusDiv").style.display='none';
	}

}
function showStomach(){
	if(document.getElementById('stomach').value == 'a'){
	  	document.getElementById("stomachDiv").style.display='inline';
	}else{
		document.getElementById("stomachDiv").style.display='none';
	}

}
function showIntestines(){
	if(document.getElementById('intestines').value == 'a'){
	  	document.getElementById("intestinesDiv").style.display='inline';
	}else{
		document.getElementById("intestinesDiv").style.display='none';
	}

}
function showLiver(){
	if(document.getElementById('liver').value == 'a'){
	  	document.getElementById("liverDiv").style.display='inline';
	}else{
		document.getElementById("liverDiv").style.display='none';
	}

}
function showPancreas(){
	if(document.getElementById('pancreas').value == 'a'){
	  	document.getElementById("pancreasDiv").style.display='inline';
	}else{
		document.getElementById("pancreasDiv").style.display='none';
	}

}
function showPelvicOrgans(){
	if(document.getElementById('pelvicOrgans').value == 'a'){
	  	document.getElementById("pelvicOrgansDiv").style.display='inline';
	}else{
		document.getElementById("pelvicOrgansDiv").style.display='none';
	}

	if(document.getElementById('pelvicOrgans').value == 'd'){
	  	document.getElementById("pelvicOrgansDamagedDiv").style.display='inline';
	}else{
		document.getElementById("pelvicOrgansDamagedDiv").style.display='none';
	}

}
function showThyroid(){
	if(document.getElementById('thyroid').value == 'a'){
	  	document.getElementById("thyroidDiv").style.display='inline';
	}else{
		document.getElementById("thyroidDiv").style.display='none';
	}

	if(document.getElementById('thyroid').value == 't'){
	  	document.getElementById("thyroidTraumaticDiv").style.display='inline';
	}else{
		document.getElementById("thyroidTraumaticDiv").style.display='none';
	}

}

function showLymphGlands(){
	if(document.getElementById('lymphGlands').value == 'a'){
	  	document.getElementById("lymphGlandsDiv").style.display='inline';
	}else{
		document.getElementById("lymphGlandsDiv").style.display='none';
	}

	
}
function showCarbon(){
	if(document.getElementById('carbon').value == 'a'){
	  	document.getElementById("carbonDiv").style.display='inline';
	}else{
		document.getElementById("carbonDiv").style.display='none';
	}

	
}

function showOtherPoisonings(){
	if(document.getElementById('otherPoisonings').value == 'a'){
	  	document.getElementById("otherPoisoningsDiv").style.display='inline';
	}else{
		document.getElementById("otherPoisoningsDiv").style.display='none';
	}

	
}

function showHypoxia(){
	if(document.getElementById('hypoxia').value == 'a'){
	  	document.getElementById("hypoxiaDiv").style.display='inline';
	}else{
		document.getElementById("hypoxiaDiv").style.display='none';
	}

	
}
function showFatEmbolism(){
	if(document.getElementById('fatEmbolism').value == 'e'){
	  	document.getElementById("fatEmbolismDiv").style.display='inline';
	}else{
		document.getElementById("fatEmbolismDiv").style.display='none';
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



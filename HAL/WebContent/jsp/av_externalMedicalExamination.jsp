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
<div class="titleBg">	<h2>EXTERNAL MEDICAL EXAMINATION</h2> </div>


<div class="clear"></div>
<form name="externalMedExam" action="" method="post">

<div class="Block">
<label>Service No.<span>*</span></label>

<input	id="serviceNoId" class="auto" size="20" type="text"	name="<%=SERVICE_NO %>" value="" title="Enter Service No" tabindex="1" validate="Service No,metachar,yes" maxlength="20"
	onblur="submitProtoAjaxWithDivName('externalMedExam','/hms/hms/aviationMedicine?method=getServiceNoDetailsForRegEquipmentInUse&serviceNo='+this.value,'patientDiv');" />

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
	


<div class="clear"></div>

<label>Rank</label>
<select	id="<%=RANK %>" name="<%=RANK_ID %>" validate="rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){
	
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}
	}%>
</select>

<label>Crew Duty (or Passenger Seating)</label>
<input tabindex="1" type="text"	name="crewDuty" maxlength="30" value="" />

</div>
<%--

<label>Number</label>
<input tabindex="1" type="text"	name="number" maxlength="10" value="" /> --%>
</div>

<div class="clear paddingTop15"></div>
<div class="Block">
<select name="<%=FATAL %>" id="fatal">
<option value="n">Non Fatal</option>
<option value="f">Fatal</option>
</select>
	
</div>


<div class="clear paddingTop15"></div>
<div class="Block">

<label>Burns</label>
<select name="burns" id="burns">
<option value="n">Nil</option>
<option value="s">Slight</option>
<option value="v">Severe</option>
<option value="i">Incineration</option>
<option value="a">Ante Mortem</option>
<option value="p">Post Mortem</option>
<option value="b">Both Periods</option>
<option value="k">Period Not Known</option>

</select>

<label>Haemorrhage</label>
<select name="haemorrhage" id="haemorrhage">
<option value="n">Nil</option>
<option value="e">Negligible</option>
<option value="m">Moderate</option>
<option value="s">Severe</option>
<option value="a">Not Applicable</option>
</select>


<label>Shock</label>
<select name="shock" id="shock">
<option value="n">Nil</option>
<option value="m">Mild</option>
<option value="o">Moderate</option>
<option value="s">Severe</option>
<option value="a">Not Applicable</option>
</select>


<div class="clear"></div>

<label>Concussion</label>
<select name="concussion" id="concussion">
<option value="n">Nil</option>
<option value="m">Mild</option>
<option value="o">Moderate</option>
<option value="s">Severe</option>
<option value="a">Not Applicable</option>
</select>

<label>Duration of Lost Concussion</label>
<input tabindex="1" type="text"	name="lostConcussion" maxlength="10" value="" />
	
	
	
<label>Duration of Retrograde Amnesia</label>
<input tabindex="1" type="text"	name="retrogradeAmnesia" maxlength="10" value="" />
	
</div>


<div class="clear paddingTop15"></div>
<h4>TABLE OF INJURIES</h4>

<div class="clear paddingTop15"></div>

<table align="center" class="cmntable" id="grid">
	<tr>
		<th></th>
		<th>Vault</th>
		<th>Base</th>
		<th>Specify If Coher Injuries</th>
	</tr>
	<tr>
		<td><label>Skull</label></td>
		<td>
			<select name="skullVault">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="o">Fracture Opened</option>
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="r">Crushing</option>
				<option value="i">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
			<select name="skullBase">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="o">Fracture Opened</option>
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="r">Crushing</option>
				<option value="i">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
		<input tabindex="1" type="text"	name="skullInjuries" maxlength="45" value=""/>
		</td>
		</tr>
		<tr>
		<td><label>Face</label></td>
		<td>
			<select name="faceVault">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="o">Fracture Opened</option>
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="r">Crushing</option>
				<option value="i">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
			<select name="faceBase">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="o">Fracture Opened</option>
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="r">Crushing</option>
				<option value="i">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
		<input tabindex="1" type="text"	name="faceInjuries" maxlength="45" value=""/>
		</td>
		</tr>
		<tr>
		<td><label>Cervial Spine</label></td>
		<td>
			<select name="cervialSpineVault">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="o">Fracture Opened</option>
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="r">Crushing</option>
				<option value="i">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
			<select name="cervialSpineBase">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="o">Fracture Opened</option>
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="r">Crushing</option>
				<option value="i">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
		<input tabindex="1" type="text"	name="cervialSpineInjuries" maxlength="45" value=""/>
		</td>
		</tr>
		<tr>
		<td><label>Dorsal Spine</label></td>
		<td>
			<select name="dorsalSpineVault">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="o">Fracture Opened</option>
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="r">Crushing</option>
				<option value="i">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
			<select name="dorsalSpineBase">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="o">Fracture Opened</option>
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="r">Crushing</option>
				<option value="i">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
		<input tabindex="1" type="text"	name="dorsalSpineInjuries" maxlength="45" value=""/>
		</td>
		</tr>
		
		<tr>
		<td><label>Lumbar Spine</label></td>
		<td>
			<select name="lumbarSpineVault">
			   <option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="o">Fracture Opened</option>
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="r">Crushing</option>
				<option value="i">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
			<select name="lumbarSpineBase">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="o">Fracture Opened</option>
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="r">Crushing</option>
				<option value="i">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
		<input tabindex="1" type="text"	name="lumbarSpineInjuries" maxlength="45" value=""/>
		</td>
		</tr>
		
		<tr>
		<td><label>Sacrum</label></td>
		<td>
			<select name="sacrumVault">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="o">Fracture Opened</option>
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="r">Crushing</option>
				<option value="i">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
			</select>
		</td>
		<td>
			<select name="sacrumBase">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="o">Fracture Opened</option>
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="r">Crushing</option>
				<option value="i">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
			</select>
		</td>
		<td>
		<input tabindex="1" type="text"	name="sacrumInjuries" maxlength="45" value=""/>
		</td>
		</tr>
		
		<tr>
		<td><label>Pelvis</label></td>
		<td>
			<select name="pelvisVault">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="o">Fracture Opened</option>
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="r">Crushing</option>
				<option value="i">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
			<select name="pelvisBase">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="o">Fracture Opened</option>
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="r">Crushing</option>
				<option value="i">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
		<input tabindex="1" type="text"	name="pelvisInjuries" maxlength="45" value=""/>
		</td>
		</tr>
		</table>
		
<div class="clear paddingTop15"></div>

<table align="center" class="cmntable" id="grid">
	<tr>
		<th></th>
		<th>Left</th>
		<th>Right</th>
		<th>Specify If Coher Injuries</th>
	</tr>
	<tr>
		
	
		<td><label>Hand and Wrist</label></td>
		<td>
			<select name="ltHandWrist"  id="ltHandWrist" class="smaller">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="f">Fracture Opened</option> 
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="c">Crushing</option>
				<option value="j">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
			<select name="rtHandWrist"  id="rtHandWrist" class="smaller">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="f">Fracture Opened</option> 
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="c">Crushing</option>
				<option value="j">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
		<input tabindex="1" type="text"	name="remarksLtRtHandWrist" maxlength="45" value="" />
		</td>
		</tr>
		
		<tr>
		<td><label>Forearm And Elbow</label></td>
		<td>
			<select name="ltForearmAndElbow"  id="ltForearmAndElbow" class="smaller">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="f">Fracture Opened</option> 
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="c">Crushing</option>
				<option value="j">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
			<select name="rtForearmAndElbow"  id="rtForearmAndElbow" class="smaller">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="f">Fracture Opened</option> 
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="c">Crushing</option>
				<option value="j">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
		<input tabindex="1" type="text"	name="remarksLtRtForearmElbow" maxlength="45" value="" />
		</td>
		</tr>
		<tr>
		<td><label>Arm And Shoulder</label></td>
		<td>
			<select name="ltArmAndShoulder"  id="ltArmAndShoulder" class="smaller">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="f">Fracture Opened</option> 
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="c">Crushing</option>
				<option value="j">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
			<select name="rtArmAndShoulder"  id="rtArmAndShoulder" class="smaller">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="f">Fracture Opened</option> 
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="c">Crushing</option>
				<option value="j">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
		<input tabindex="1" type="text"	name="remarksLtRtArmShoulder" maxlength="45" value="" />
		</td>
		</tr>
		<tr>
		<td><label>Foot And Ankle</label></td>
		<td>
		<select name="ltFootAndAnkle"  id="ltFootAndAnkle" class="smaller">
			<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="f">Fracture Opened</option> 
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="c">Crushing</option>
				<option value="j">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
			<select name="rtFootAndAnkle"  id="rtFootAndAnkle" class="smaller">
			<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="f">Fracture Opened</option> 
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="c">Crushing</option>
				<option value="j">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
		<input tabindex="1" type="text"	name="remarksLtRtFootAnkle" maxlength="45" value="" />
		</td>
		</tr>
		<tr>
		<td><label>Leg And Knee</label></td>
		<td>
		<select name="ltLegAndKnee"  id="ltLegAndKnee" class="smaller">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="f">Fracture Opened</option> 
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="c">Crushing</option>
				<option value="j">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
			</select>
		</td>
		<td>
			<select name="rtLegAndKnee"  id="rtLegAndKnee" class="smaller">
			<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="f">Fracture Opened</option> 
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="c">Crushing</option>
				<option value="j">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
			</select>
		</td>
		<td>
		<input tabindex="1" type="text"	name="remarksLtRtLegKnee" maxlength="45" value="" />
		</td>
		</tr>
		<tr>
		<td><label>Thigh And Hip</label></td>
		<td>
			<select name="ltThighAndHip"  id="ltThighAndHip" class="smaller">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="f">Fracture Opened</option> 
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="c">Crushing</option>
				<option value="j">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
			</select>
		</td>
		<td>
			<select name="rtThighAndHip"  id="rtThighAndHip" class="smaller">
				<option value="s">Sprain or Strain</option>
				<option value="c">Fracture(Closed)</option>
				<option value="o">Fracture Opened</option>
				<option value="d">Dislocation</option>
				<option value="a">Amputation</option>
				<option value="r">Crushing</option>
				<option value="i">Coher Injuries</option>
				<option value="e">Not Available For examination</option>
				
			</select>
		</td>
		<td>
		<input tabindex="1" type="text"	name="remarksLtRtThighHip" maxlength="45" value="" />
		</td>
		</tr>
	
		</table>
	


<div class="clear paddingTop15"></div>
<div class="Block">

<label class="large">Internal Injuries Diagnosed Clinically or At Operation</label>
<textarea rows="" cols="60"	name="internalInjuriesDiagnosed" class="auto" onkeyup="chkLength(this,100);"></textarea>

<div class="clear"></div>

<label class="large">Medical Officers' Assessment of Cause  of Injuries</label>
<textarea rows="" cols="60"	name="moAssessment" class="auto" onkeyup="chkLength(this,100);"></textarea>

<div class="clear"></div>
<label>Disposal Of Casualty</label>
<select name="disposalCasualty" id="casualty">
<option value="n">No Treatment</option>
<option value="a">Ambulant Treatment</option>
</select>

<label>Admitted SSQ/Sick bay</label>
<input tabindex="1" type="text"	name="ssqSickBay" maxlength="30" value="" />




<label>Admitted Hospital</label>
<input tabindex="1" type="text"	name="admittedHospital" maxlength="30" value="" />

<div class="clear"></div>

<label>Dead When First Seen</label>
<input tabindex="1" type="text"	name="deadFirstSeen" maxlength="30" value="" />




<label>Cause Of Death</label>
<textarea rows="" cols="60"	name="causeDeath" class="auto" onkeyup="chkLength(this,100);"></textarea>

</div>

<input tabindex="1"  type="button" value="Submit" class="button"  accessKey="r"  
onclick="submitForm('externalMedExam','/hms/hms/aviationMedicine?method=submitExternalMedExam&flag=external');"  />
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

</form>
<script>
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
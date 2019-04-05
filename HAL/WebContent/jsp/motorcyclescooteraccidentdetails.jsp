<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>

<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript"
	language="javascript">
	<%	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
				
	</script>
	
<form name="AccidentDetails" action="" method="post">

   <% Map<String, Object> map = new HashMap<String, Object>();
		
		List<Object[]> unitList = new ArrayList<Object[]>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		
		 List<Category> categoryList = new ArrayList<Category>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
		if(map.get("categoryList") != null){
			categoryList = (List<Category>)map.get("categoryList");
		}
		
		//if(map.get("masSchoolRegistrationList") != null){
			//masSchoolRegistrationList = (ArrayList)map.get("masSchoolRegistrationList");
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTimeWithoutSc");
		%>
	
	
<div class="titleBg"><h2>Two/ Four Wheeler Accident Details</h2></div>

<div class="Block">
<label >Date of Accident</label>
<input type="text"	id="commissionDateId" name="dateOfAccident" tabindex="1" value="<%=currentDate %>"
readonly="readonly" validate="commission Date,date,no" MAXLENGTH="10"	class="calDate" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"  
onClick="setdate('',document.AccidentDetails.dateOfAccident,event)" />

<label >Time of Accident</label>
<input  type="text" name="timeOfAccident" maxlength="49" validate="name,string,no" id="timeOfAccident" value="" tabindex="1" onKeyUp="mask(this.value,this,'2',':');" />

<label >Type of vehicle</label>
<select id="sinceId" name="typeOfVehicle" 	id="vehicleId"   validate="Since,string,no" tabindex="1"  >
	<option value="0">Select</option>
    <option value="Motor cycle">Motor cycle</option>
    <option value="Scooter">Scooter</option>
    <option value="Four wheeler">Four wheeler</option></select>
<div class="clear"></div>

<label >Vehicle No.</label>
<input  type="text" name="vehicleNo"  id ="vehicleId"  maxlength="19"  validate="name , string,no"  tabindex="1" id="rankId" value="" />

<label >How Old is Vehicle</label>
<select name="oldVehicle" tabindex="1">
<option >New</option>
<option>1 year</option>
<option>2 year</option>
<option>3 year</option> 
</select>

</div>
<div class="clear"></div>
<h4>Particulars of Driver</h4>
<div class="clear"></div>
<div class="Block">

<label >Service No.<span>*</span></label>
<input tabindex="1" type="text" name="serviceNoDriver" validate="Driver's Service Number,metachar,yes" id="serviceNoDriver" value="" 
onblur="getPatientDetails();" />

<script>
function getPatientDetails()
{ 
	var hinNo='';
	hinNo=document.getElementById('serviceNoDriver').value;

	if(validateMetaCharacters(hinNo))
	{
		submitProtoAjaxWithDivName('AccidentDetails','mis?method=getServiceNoDetailsForAccident&flag='+hinNo,'hinDivDriver');
	}
}
</script>

<div id="hinDivDriver">
<label>HIN</label> 
<input	type="text" name="hin_id" value=""	MAXLENGTH="30" onchange=""/>
</div>

<div id="DivDriver">

<label >Name</label>
<input tabindex="1" type="text" name="name" validate="name , string,no" id="nameId" value="" />

<label >Rank</label>
<input tabindex="1"  type="text" name="rank" validate="Rank , string,no" id="rankId" value="" />

<label >Branch/ Trade</label>
<input type="text" name="branch/Trade" validate="name , string,no" id="branch/TradeId" value="" tabindex="1" />

<label >Age</label>
<input type="text" name="age" validate="name , number,no" id="ageId" value="" tabindex="1" />

<div class="clear"></div>

<label >Total Service</label>
<input type="text" name="totalService" validate="name , string,no" id="totalServiceId" value="" tabindex="1" />

<label>Marital Status</label>
<input  type="text" name="maritalStatus" validate="name , metachar,no" id="maritalStatusId" value="" tabindex="1" />

<label>Duty Status</label>
<label class="auto">On</label>
<input type="radio" name="driverDutyStatus"  id="DriverDutyOn" class="radioAuto2" tabindex="1" value="On" />

<label class="auto">Off</label>
<input type="radio" name="driverDutyStatus" id="DriverDutyOff" class="radioAuto2" tabindex="1" value="Off" />

</div>
</div>
<div class="clear"></div>


<h4>Particulars of Pillion Rider</h4>
<div class="clear"></div>

<div class="Block">

<label >Service No.</label>
<input tabindex="1" type="text" name="serviceNoRider" validate="name ,metachar,no" id="serviceNoRider" value="" 
onblur="getPatientDetailsRider();"/>

<script>
function getPatientDetailsRider()
{ 
	var hinNo='';
	hinNo=document.getElementById('serviceNoRider').value;
	
	if(validateMetaCharacters(hinNo))
	{
		submitProtoAjaxWithDivName('AccidentDetails','mis?method=getServiceNoDetailsForAccidentRider&flag='+hinNo,'hinDiv');
	}
}
</script>

<div id="hinDiv">
<label>HIN</label> 
<input	type="text" name="<%=HIN_NO%>" value=""	MAXLENGTH="30" onchange=""/>
</div>
<div id="DivPillion">
<label >Name</label>
<input  type="text" name="name" validate="name ,metachar,no" id="nameId" value="" tabindex="1" />

<div class="clear"></div>

<label >Rank</label>
<input  type="text" name="rank" validate="name , metachar,no" id="rankId" value="" tabindex="1" />

<label >Branch/Trade</label>
<input tabindex="1" type="text" name="branch/Trade" validate="name , metachar,no" id="branch/TradeId" value="" />

<label >Age</label>
<input tabindex="1" type="text" name="age" validate="name , number ,no" id="ageId" value="" />

<div class="clear"></div>

<label >Total Service</label>
<input tabindex="1" type="text" name="totalService" validate="name , string,no" id="totalServiceId" value="" />

<label>Marital Status</label>
<input tabindex="1" type="text" name="maritalStatus" validate="name ,metachar,no" id="maritalStatusId" value="" />

</div>

<label>Duty Status</label>
<label class="auto">On</label>
<input type="radio" name="pillionDutyStatus" id="On" class="radioAuto2" tabindex="1" value="On" />
<label class="auto">Off</label>
<input type="radio" name="pillionDutyStatus" id="Off" class="radioAuto2" tabindex="1" value="Off" />

</div>

<div class="Clear"></div>

<h4>Accident Details</h4>
<div class="Clear"></div>

<div class="Block">

<label>Condition of Road</label>
<select name="roadCondition" tabindex="1" tabindex="1">
<option>Good</option>
<option>Fair</option>
<option>Poor</option>
</select>

<label>Type of Accident</label>
<select name="accidentType" tabindex="1">
<option>Skid</option>
<option>Collision</option>
<option>Hit from behind</option>
</select>

<div class="clear"></div>

<label class="large2">Is there any other person(s) injured other then driver/pillion </label>
<select name = "otherPersonInjured" tabindex="1">
<option>No</option>
<option>Yes</option>
</select>

<div class="clear"></div>

<div style="display: none">
<label >Service No.</label>
<input  type="text" name="serviceNo" validate="name , metachar,no" id="serviceNoId" value="" tabindex="1" />

<label >Name</label>
<input  type="text" name="name" validate="name , metachar,no" id="nameId" value="" tabindex="1" />

<label >Rank</label>
<input  type="text" name="rank" validate="name , metachar,no" id="rankId" value="" tabindex="1" />

<div class="clear"></div>

<label >Branch/Trade</label>
<input  type="text" name="branch/Trade" validate="name , metachar,no" id="branch/TradeId" value="" tabindex="1" />

<label >Age</label>
<input  type="text" name="age" validate="name , number ,no" id="ageId" value="" />

<label >Total Service</label>
<input  type="text" name="totalService" validate="name , string,no" id="totalServiceId" value="" tabindex="1" />

<div class="clear"></div>

<label>Marital Status</label>
<input  type="text" name="maritalStatus" validate="name , metachar,no" id="maritalStatusId" value="" tabindex="1" />

<label >Duty Status</label>
<label class="auto">On</label>
<input type="radio" name="dutystatus" id="On" value="On" class="radioAuto2" tabindex="1"/>
<label class="auto">Off</label>
<input type="radio" name="dutystatus" id="Off" value="Off" class="radioAuto2" tabindex="1"/>
</div>
<div class="Clear"></div>

<label>Place of Accident</label>
<select name="placeOfAccident" tabindex="1">
<option>Unit</option>
<option>Highway</option>
<option>Side Road</option>
<option>Main Road</option>
</select>

<label>Cause of Accident</label>
<select name="causeofAccident" id="causeofAccId" onchange="showCauseofAccident();">
<option value="">Select</option>
<option value="Poor Visibility">Poor Visibility</option>
<option value="Break Failure">Break Failure</option>
<option value="Speeding">Speeding</option>
<option value="Loss of Control">Loss of Control</option>
<option value="other">Other</option>
</select>

<div id="causeofAccIdDiv" style="display: none">

<label>Other</label>
<input tabindex="1" type="text" name="OtherCauseofAccident"   maxlength="49"  validate="name , metachar,no" id="causeofAccId" value="" />
</div>

<label>Approx Speed at the time of Accident</label>
<input type="text" name="approxSpeed" tabindex="1"  maxlength="19"  validate="name , string,no" id="approxSpeedId" value="" />
</div>

<div class="clear"></div>

<h4>Details of Injuries sustained</h4>

<table cellpadding="0" cellspacing="0" width="100%">

<tr>
<th>Type of Injury</th>
<th>Driver</th>
<th>Pillion Rider</th>
<th>Person 1</th>
<th>Person 2</th>
<th>Person 3</th>
</tr>

<tr>
<th>Head Injuries</th>
<td><input  type="text" name="headInjuryDriver"  validate="Head Injuries Driver,metachar,no"  maxlength="49"   id="headInjuryDriver" value="" tabindex="1" /></td>
<td><input  type="text" name="headInjuryPillionR"  maxlength="49"  validate="name , metachar,no" id="headInjuryPillionR" value="" tabindex="1" /></td>
<td><input  type="text" name="headInjuryPerson1"   maxlength="49"  validate="name , metachar,no" id="headInjuryPerson1" value="" tabindex="1" /></td>
<td><input  type="text" name="headInjuryPerson2"  maxlength="49"   validate="name , metachar,no" id="headInjuryPerson2" value="" tabindex="1" /></td>
<td><input  type="text" name="headInjuryPerson3"   maxlength="49"  validate="name , metachar,no" id="headInjuryPerson3" value="" tabindex="1" /></td>
</tr>

<tr>
<th>Fractures</th>
<td><input  type="text" name="fracturesDriver"  validate="Head Injuries Driver,metachar,no"  maxlength="49"  validate="name , string,no" id="fracturesDriver" value="" tabindex="1" /></td>
<td><input  type="text" name="fracturesPillorR" maxlength="49"  validate="name , metachar,no" id="fracturesPillorR" value="" tabindex="1" /></td>
<td><input  type="text" name="fracturesPerson1" maxlength="49"   validate="name , metachar,no" id="fracturesPerson1" value="" tabindex="1" /></td>
<td><input  type="text" name="fracturesPerson2" maxlength="49"   validate="name , metachar,no" id="fracturesPerson2" value="" tabindex="1" /></td>
<td><input  type="text" name="fracturesPerson3" maxlength="49"   validate="name , metachar,no" id="fracturesPerson3" value="" tabindex="1" /></td>
</tr>

<tr>
<th>Minor Injuries</th>
<td><input  type="text" name="minorInjDriver"  validate="Head Injuries Driver,String,no"  maxlength="49"  validate="name , string,no" id="minorInjDriver" value="" tabindex="1" /></td>
<td><input  type="text" name="minorInjPillorR"  maxlength="49"  validate="name ,metachar,no" id="minorInjPillorR" value="" tabindex="1" /></td>
<td><input  type="text" name="minorInjPerson1"  maxlength="49"   validate="name , metachar,no" id="minorInjPerson1" value="" tabindex="1" /></td>
<td><input  type="text" name="minorInjPerson2" maxlength="49"     validate="name ,metachar,no" id="minorInjPerson2" value="" tabindex="1" /></td>
<td><input  type="text" name="minorInjPerson3" maxlength="49"     validate="name , metachar,no" id="minorInjPerson3" value="" tabindex="1" /></td>
</tr>

<tr>
<th>Other Injuries</th>
<td><input  type="text" name="otherInjDriver"  validate="Head Injuries Driver,String,no"  maxlength="49"  validate="name , string,no" id="otherInjDriver" value="" tabindex="1" /></td>
<td><input  type="text" name="otherInjPillorR"  maxlength="49"    validate="name ,metachar,no" id="otherInjPillorR" value="" tabindex="1" /></td>
<td><input  type="text" name="otherInjPerson1"  maxlength="49"   validate="name , metachar,no" id="otherInjPerson1" value="" tabindex="1" /></td>
<td><input  type="text" name="otherInjPerson2"  maxlength="49"   validate="name ,metachar,no" id="otherInjPerson2" value="" tabindex="1" /></td>
<td><input  type="text" name="otherInjPerson3"  maxlength="49"   validate="name , metachar,no" id="otherInjPerson3" value="" tabindex="1"/></td>
</tr>

</table>

<div class="clear"></div>
<h4>Other Details</h4>
<div class="Block">

<label class="large2">Whether crash helmet/ seat belt was used by the injured person</label>
<select id="" name="crashHelmetInjuredPerson" 	validate="Since,string,no" tabindex="1"  >
	<option value="0">Select</option>
    <option value="Yes">Yes</option>
    <option value="No">No</option>
    <option value="Sikh">Sikh</option>
</select>
    
<div class="clear"></div>

<label class="large2">Type of crash helmet used by</label>
<div class="clear"></div>	

<label>Driver</label>
<select id="" name="crashHelmetUsedByDriver" 	validate="Since,string,no" tabindex="1"  >
	<option value="" >Select</option>
	<option value="Full" >Full</option>
    <option value="Dome Type">Dome Type</option>
    <option value="Chin Guard Type">Chin Guard Type</option>
</select>
 
<select id=""  name="crashHelmetUsedByisiDriver"  class="small" name="sinceId" 	validate="Since,string,no" tabindex="1"  >
	<option value="" >Select</option>
	<option value="ISI">ISI</option>
    <option value="NON ISI">NON ISI</option>
</select>
     
<label>Pillion Rider</label>
<select id="" name="crashHelmetUsedByPillionR" 	validate="Since,string,no" tabindex="1"  >
	<option value="" >Select</option>
	<option value="Full">Full</option>
    <option value="Dome Type">Dome Type</option>
    <option value="Chin Guard Type">Chin Guard Type</option>
</select>    
     
<select id="" class="small" name="crashHelmetUsedByisiPillionR" validate="Since,string,no" tabindex="1"  >
	<option value="ISI">ISI</option>
    <option value="NON ISI">NON ISI</option>
</select>
  
<div class="clear"></div>

<label class="large2">Was the chin strap fastened properly</label>

<div class="clear"></div>

<label >Driver</label>
<select id="" name="chinStrapDriver"	class="" validate="Since,string,no" tabindex="1"  >
	<option value="Yes">Yes</option>
    <option value="No">No</option>
</select>

<label >Pillion Rider</label>
<select id="" name="chinStrapPillionRider"	class="" validate="Since,string,no" tabindex="1"  >
	<option value="Yes">Yes</option>
    <option value="No">No</option>
</select>

<div class="clear"></div>

<label  class="large2">Did it come off the head during the accident</label>

<div class="clear"></div>

<label>Driver</label>
<select id="" name="comeOfHeadDuringAccidentDriver"	class="" validate="Since,string,no" tabindex="1"  >
	<option value="Yes">Yes</option>
    <option value="No">No</option>
</select>

<label >Pillion Rider</label>
<select id="" name="comeOfHeadDuringAccidentPillionR"	class="" validate="Since,string,no" tabindex="1"  >
	<option value="Yes">Yes</option>
    <option value="No">No</option>
</select>

<div class="clear"></div>

<label class="large2">External damage to the helmet if any and extent of damage</label>

<div class="clear"></div>

<label >Driver</label>
<input  type="text" name="extentDamageDriver"   maxlength="49"    validate="name , metachar,no" id="weatherCrashId" value="" tabindex="1" />

<label >Pillion Rider</label>
<input type="text" name="extentDamagePillionRider"  maxlength="49"   validate="name , metachar,no" id="weatherCrashId" value="" tabindex="1" />

<div class="clear"></div>

<label class="large2"> Whether brakes, light, indicators and horn were in working order</label>

<select id="" name="brakLightWorkingOrder"	class="" validate="Since,string,no" tabindex="1"  >
	<option value="Yes">Yes</option>
    <option value="No">No</option>
</select>

<div class="clear"></div>

<label class="large2">Whether admitted to</label>

<div class="clear"></div>

<label >Driver</label>
<select id="" name="admittedToDriver"	class="" validate="Since,string,no" tabindex="1"  >
	<option value="Hospital">Hospital</option>
    <option value="SMC">SMC</option>
      <option value="SIQ">SIQ</option>
</select>

<label >Pillion Rider</label>
<select id="" name="admittedToPillionR"	class="" validate="Since,string,no" tabindex="1"  >
	<option value="Hospital">Hospital</option>
    <option value="SMC">SMC</option>
    <option value="SIQ">SIQ</option>
 </select>
    
<label >Others</label>
<select id="" name="admittedToOther"	class="" validate="Since,string,no" tabindex="1"  >
	<option value="Hospital">Hospital</option>
    <option value="SMC">SMC</option>
    <option value="SIQ">SIQ</option>
</select>    
<div class="clear"></div>

<label class="large2">Number of days spent in hospital/ SMC/ SIQ</label>

<div class="clear"></div>

<label >Driver</label>
<input class="small" type="text" tabindex="1" name="noDaySpentinHospitalDriver"  maxlength="49"  validate="Hospital Driver,int,no" id="weatherCrashId" value="" />

<label >Pillion Rider</label>
<input class="small" type="text" tabindex="1" name="noDaySpentinHospitalPillionR" maxlength="19"  validate="Hospital Pillion Rider,int,no" id="weatherCrashId" value="" />

<label >Others</label>
<input class="small" type="text" name="noDaySpentinHospitalOther"  maxlength="39"  validate="Hospital Other,int,no" id="weatherCrashId" value="" />

<div class="clear"></div>

<label class="large2">Number of days in lower medical category</label>

<div class="clear"></div>

<label >Driver</label>
<input  class="small"  type="text" tabindex="1" name="noDayLowerMedCatDriver"   maxlength="19" validate="Driver Med Cat,int,no" id="weatherCrashId" value="" />

<label >Pillion Rider</label>
<input  class="small"  type="text" tabindex="1" name="noDayLowerMedCatPillionR" maxlength="19"  validate="Pillion Rider Med Cat,int,no" id="weatherCrashId" value="" />

<label >Others</label>
<input  class="small"  type="text" tabindex="1" name="noDayLowerMedCatOther"  maxlength="19"   validate="Other Med Cat,int,no" id="weatherCrashId" value="" />

<div class="clear"></div>

<label class="large2">Number of flying hours lost in account of injuries </label>

<div class="clear"></div>

<label >Driver</label>
<input  class="small"  tabindex="1" type="text" name="noOfFlyHourDriver"  maxlength="19"  validate="Flying Hour Driver,int,no" id="weatherCrashId" value="" />

<label >Pillion Rider</label>
<input  class="small" tabindex="1" type="text" name="noOfFlyHourPillionR"  maxlength="19"  validate="Flying Hour Pillion Rider,int,no" id="weatherCrashId" value="" />

<label  >Others</label>
<input  class="small" tabindex="1" type="text" name="noOfFlyHourOther"  maxlength="19"   validate="Flying Hour Other,int,no" id="weatherCrashId" value="" />

<div class="clear"></div>

<label class="large2">Final Category of the injuried persons </label>

<div class="clear"></div>

<label>Driver</label>
<select name="finalCatInjDriver">
<option value="0">Select</option>

<%if(categoryList!=null && categoryList.size() >0){
	 for(Category category : categoryList){
%>
<option value="<%=category.getCategoryid()%>"><%=category.getCategories()%></option>
	
<%}}%>
</select>

<label >Pillion Rider</label>
<select name="finalCatInjPillionRider">
<option value="0">Select</option>

<%if(categoryList!=null && categoryList.size() >0){
	 for(Category category : categoryList){
%>
<option value="<%=category.getCategoryid()%>"><%=category.getCategories()%></option>
	
<%}}%>
</select>

<label >Others</label>
<select name="finalCatInjOther">
<option value="0">Select</option>
<%if(categoryList!=null && categoryList.size() >0){
	 for(Category category : categoryList){
%>
<option value="<%=category.getCategoryid()%>"><%=category.getCategories()%></option>
	
<%}}%>
</select>

<div class="clear"></div>

<input type="radio" name="deathCase" value="Dead" class="radioAuto" id="deathCase" onclick="showDeathCase();" /><label class="auto">Dead</label>
<input type="radio" name="deathCase" value="Injured" class="radioAuto" id="InjuredCase"  onclick="showDeathCase();" /><label class="auto">Injured</label>

<div id="deathCaseId" style="display: none">
<div class="clear"></div>
<label class="large2">In case of death, the injuries which were responsible for the same</label>

<div class="clear"></div>

<label>Driver</label>
<input  class="" tabindex="1" type="text" name="deathInjResponsibleDriver" maxlength="49" validate="name,metachar,no" id="weatherCrashId" value="" />

<label>Pillion Rider</label>
<input class="" tabindex="1" type="text" name="deathInjResponsiblePillionR"  maxlength="49" validate="name,metachar,no" id="weatherCrashId" value="" />

<label>Others</label>
<input class="" tabindex="1" type="text" name="deathInjResponsibleOther"  maxlength="49" validate="name ,metachar, no" id="weatherCrashId" value="" />

</div>
<div class="clear"></div>

<label>Remarks</label>
<textarea name="Remarks" tabindex="1" maxlength="49" validate="Remarks ,metachar, no"></textarea>

</div>

<div class="clear"></div>
<div class="division"></div>

<input type="button" name="Submit"  onclick="submitForm('AccidentDetails','/hms/hms/mis?method=submitAccidentalDetailJsp');"   
 value="Submit" class="button" />

<input type="button" name="upload" value="Upload" class="button" onClick="javascript:FileUploadWindow();" />	
	
<div class="clear"></div>
<div class="division"></div>

</form>

<script type="text/javascript">

function showDeathCase(){
	if(document.getElementById('deathCase').checked == true){
	  	document.getElementById("deathCaseId").style.display='inline';
	}else if(document.getElementById('deathCase').checked == false){
		document.getElementById("deathCaseId").style.display='none';
	}
}

function submitProtoAjaxforPatientDetails(formName,action){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
        	
        	new Ajax.Updater('srNoDiv',url,
			   {asynchronous:false, evalScripts:true }); 
	       	return true;
    	}
function submitProtoAjaxforPatientDetailsRider(formName,action){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
        	
        	new Ajax.Updater('DivPillion',url,
			   {asynchronous:false, evalScripts:true }); 
	       	return true;
    	}

function FileUploadWindow()
{ 	
	   var folderName='hearing';
		var url="/hms/hms/mis?method=displayFileUpload";

		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
 	
}

function showCauseofAccident(){
	if(document.getElementById('causeofAccId').value == 'other'){
	  	document.getElementById("causeofAccIdDiv").style.display='inline';
	}else{
		document.getElementById("causeofAccIdDiv").style.display='none';
	}
}

function getDriverDutyStatus()
{
	if(document.getElementById('DriverDutyOn').checked == true){
		document.getElementById('dDutyStatusOn')=='On'
	}
	else{
		document.getElementById('dDutyStatusOn')=='Off'
	}
}
</script>

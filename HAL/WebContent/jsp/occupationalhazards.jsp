<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
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
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">
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


<form name="OccupationalHazards(HIV/HCV/HBV)" action="" method="post">

<% Map<String, Object> map = new HashMap<String, Object>();
		
		List<Object[]> unitList = new ArrayList<Object[]>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");%>


<div class="titleBg">
<h2>Occupational Hazards (HIV/HCV/HBV)</h2>
</div>

<div class="Block">

<div class="clear"></div>
<label style=" width: 310px">Service No.</label>
 <input type="text" name="servceNo"
	validate="name ,number ,no" id="serviceNoId" value="" /> 
<label style=" width: 310px">Name  </label>
<input type="text" name="name" validate="name ,string ,no" id="nameId"
	value="" /> 
	<div class="clear"></div>
<label style=" width: 310px">Personal Number</label> 
<input type="text"
	name="personalNo" validate="name ,number ,no" id="personalNoId"
	value="" />


<label style=" width: 310px">Unit </label> 
<input type="text" name="unit" validate="name ,string ,no" id="unitId" value="" /> 
	<div class="clear"></div>
	<label style=" width: 310px">Date and Time of needle stick injury</label> <input type="text" id="commissionDateId"
	name="commissionDate" tabindex="1" value="" readonly="readonly"
	validate="commission Date,date,no" MAXLENGTH="30" class="calDate"
	onblur="calculateTotalService(this.value);" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> 
	
	<label style=" width: 310px">Date of Reporting</label> <input type="text" id="commissionDateId" name="commissionDate"
	tabindex="1" value="" readonly="readonly"
	validate="commission Date,date,no" MAXLENGTH="30" class="calDate"
	onblur="calculateTotalService(this.value);" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" />
<div class="clear"></div>
<label style=" width: 310px">Anatomical site and depth of injury</label> <input type="text"
	name="name" validate="name ,string ,no" id="nameId" value="" /> 
	
	<label style=" width: 310px">Nature of injury</label> <input style="width: 150px" type="text"
	validate="name ,string ,no" name="unit" id="unitId" value="" /> 
	<div class="clear"></div>
	<label style=" width: 310px">Circumstances of injury</label> <input type="text" name="unit" validate="name ,string ,no"
	id="unitId" value="" />




<label style=" width: 310px"> History of Immunization of HCW against Hepatitis B</label> 
<select  name="" id="boiling"
	tabindex="22" validate="name,string,no">
	<option value="YES">YES</option>
	<option value="NO">NO</option>
</select>


<div class="clear"></div>
<h4>Details of the patient to whom HCW was exposed to the risk</h4>
<div class="clear"></div>
<label style=" width: 310px">Service No</label> 
<input type="text" name="servceNo" validate="name ,number ,no" id="serviceNoId" value="" /> 
<label style=" width: 310px">Name</label>
<input type="text" name="name" validate="name ,string ,no" id="nameId"
	value="" />
	<div class="clear"></div>
 <label style=" width: 310px" >Personal Number</label> 
 <input type="text" name="personalNo" validate="name ,number ,no" id="personalNoId"
	value="" />


<label style=" width: 310px">Unit</label> 
<input type="text" name="unit" validate="name ,string ,no" id="unitId" value="" />
<div class="clear"></div>

<label style=" width: 473px">Date of admission/reporting to hospital </label> 
<input  type="text"	id="commissionDateId" name="commissionDate" tabindex="1" value=""
	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"
	class="calDate" onblur="calculateTotalService(this.value);" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender" />

<div class="clear"></div>
<label style=" width: 473px"> Disease/Disability for which reported/being investigated </label> 
<input  type="text" name="arrangementFor" validate="name ,string ,no" id="arrangementForId"
	value="" />
<div class="clear"></div>
<label style=" width: 473px">Report of MO i/c MI Room/ward/sick bay/SSQ</label> 
<input  type="text" name="actionTak" validate="name ,string ,no" id="actionTakId" value="" />

<div class="clear"></div>
<label style=" width: 473px">Exposure Code as per the given guidelines</label>
 <input type="text" name="remarks" validate="name ,string ,no" id="remarksId" value="" />
<div class="clear"></div>
<label style=" width: 473px">Source status as per the guideline</label> 
<input  type="text" name="remarks" validate="name ,string ,no" id="remarksId" value="" />
<div class="clear"></div>

<label style=" width: 473px">PEP recommended as per the guidelines</label> 
<input  type="text" name="remarks" validate="name ,string ,no" id="remarksId" value="" />
<div class="clear"></div>
<div class="clear"></div>
<label style=" width: 473px">HIV test status of HCW</label>
 <input  type="text" name="remarks" validate="name ,string ,no" id="remarksId" value="" />

<div class="clear"></div>

<h4>The day of the said injury</h4>
<div class="clear"></div>

<label style="width: 200px"> Date blood drawn</label> <input type="text"
	id="commissionDateId" name="commissionDate" tabindex="1" value=""
	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"
	class="calDate" onblur="calculateTotalService(this.value);" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender" />
<div class="clear"></div>
<label class="medium">Positive</label> <input type="checkbox" name=""
	validate="name ,string ,no" tabindex="1" value="Lab" class="radioAuto" />
<label class="medium">Negative</label> <input type="checkbox" name=""
	validate="name ,string ,no" tabindex="1" value="Lab" class="radioAuto" />
<div class="clear"></div>


<h4>Six weeks after injury</h4>
<div class="clear"></div>

<label style="width: 200px"> Date blood drawn</label> <input type="text"
	id="commissionDateId" name="commissionDate" tabindex="1" value=""
	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"
	class="calDate" onblur="calculateTotalService(this.value);" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender" />
<div class="clear"></div>
<label class="medium">Positive</label> <input type="checkbox" name=""
	validate="name ,string ,no" tabindex="1" value="Lab" class="radioAuto" />
<label class="medium">Negative</label> <input type="checkbox" name=""
	validate="name ,string ,no" tabindex="1" value="Lab" class="radioAuto" />
<div class="clear"></div>


<h4>After 12 weeks of said injury</h4>
<div class="clear"></div>

<label style="width: 200px"> Date blood drawn</label> <input type="text"
	id="commissionDateId" name="commissionDate" tabindex="1" value=""
	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"
	class="calDate" onblur="calculateTotalService(this.value);" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender" />
<div class="clear"></div>
<label class="medium">Positive</label> <input type="checkbox" name=""
	validate="name ,string ,no" tabindex="1" value="Lab" class="radioAuto" />
<label class="medium">Negative</label> <input type="checkbox" name=""
	validate="name ,string ,no" tabindex="1" value="Lab" class="radioAuto" />
<div class="clear"></div>

<h4>After 6 month of the said injury</h4>
<div class="clear"></div>

<label style="width: 200px"> Date blood drawn</label> <input type="text"
	id="commissionDateId" name="commissionDate" tabindex="1" value=""
	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"
	class="calDate" onblur="calculateTotalService(this.value);" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender" />
<div class="clear"></div>
<label class="medium">Positive</label> <input type="checkbox" name=""
	validate="name ,string ,no" tabindex="1" value="Lab" class="radioAuto" />
<label class="medium">Negative</label> <input type="checkbox" name=""
	validate="name ,string ,no" tabindex="1" value="Lab" class="radioAuto" />
<div class="clear"></div>



<div class="clear"></div>
<input type="button" name="edit" value="Submit" class="button" /> <input
	type="button" name="edit" value="Print" class="button" /> <input
	type="button" name="Reset"
	onclick="submitForm('lmcPsychiatricPatientCounseling','sHO?method=showLowMedCatPsychiatricPatientCounelingEntry');"
	value="Reset" class="button" /> <input type="button" name="edit"
	value="Back" class="button" /></div>
<div class="clear"></div>

</form>
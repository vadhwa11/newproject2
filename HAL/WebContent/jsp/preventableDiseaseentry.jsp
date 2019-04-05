
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
	
	<form name="PreventableDiseaseEntry" action="" method="post">

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
	
<div class="titleBg"><h2>Preventable Disease Entry</h2>
</div>
<div class="Block">


<div class="clear"></div>


	<label style="margin-left:165px; width: 145px" >Present Quarter</label>
	<label style="margin-left:14px; width: 145px">Last Quarter</label>
	<label style="margin-left:13px; width: 145px ">Remarks</label>
	<div class="clear"></div>
<label>Malaria Fresh</label>	
<input type="hidden" name="MalariaFresh" value="MalariaFresh" />
<input  type="text" name="MalariaPresent"  id="MalariaPresent" value="" />
<input  type="text" name="MalariaLast"     id="MalariaLast" value="" />
<input type="text" name="MalariaRemarks"   id="MalariaRemarks"  maxlength="49"  value="" />
<div class="clear"></div>	
<label>Diarrhoea Dysentry</label>	
<input type="hidden" name="DiarrhoeaDysentry" value="DiarrhoeaDysentry" />
<input type="text" name="DiarrhoeaPresent"  id="DiarrhoeaPresent" value="" />
<input type="text" name="DiarrhoeaLast"      id="DiarrhoeaLast" value="" />
<input type="text" name="DiarrhoeaRemarks"  id="DiarrhoeaRemarks"  maxlength="49"  value="" />
<div class="clear"></div>	
<label>Infectious Hepatitis</label>	
<input type="hidden" name="InfectiousHepatitis" value="InfectiousHepatitis" />
<input type="text" name="InfectiousPresent"   id="InfectiousPresent" value="" />
<input type="text" name="InfectiousLast"  id="InfectiousLast" value="" />
<input type="text" name="InfectiousRemarks"  id="InfectiousRemarks"  maxlength="49"   value="" />
<div class="clear"></div>
<label>Respiratory Group</label>
<input type="hidden" name="RespiratoryGroup" value="RespiratoryGroup" />	
<input  type="text" name="RespiratoryPresent"  id="RespiratoryPresent" value="" />
<input type="text" name="RespiratoryLast"  id="RespiratoryLast" value="" />
<input type="text" name="RespiratoryRemarks" id="RespiratoryRemarks"  maxlength="49"  value="" />
<div class="clear"></div>	
<label>STD</label>	
<input type="hidden" name="STD" value="STD" />
<input type="text" name="STDPresent"  id="STDPresent" value="" />
<input type="text" name="STDLast"  id="STDLast" value="" />
<input type="text" name="STDRemarks"  id="STDRemarks" maxlength="49" value="" />	
<div class="clear"></div>	
<label>Injuries</label>	
<input type="hidden" name="Injuries" value="Injuries" />
<input type="text" name="InjuriesPresent"  id="InjuriesPresent" value="" />
<input type="text" name="InjuriesLast" id="InjuriesLast" value="" />
<input type="text" name="InjuriesRemarks"  id="InjuriesRemarks"  maxlength="49"  value="" />	
<div class="clear"></div>	
<div class="clear"></div>
<h4>Breakdown of Injuries</h4>
<div class="clear"></div>	
<label style="width: 260px">Flying Accidents</label>	
<input  type="text" name="flyingAccidents"  maxlength="19"   validate="name, string,no" id="flyingAccidentsId" value="" />	
		
<label style="width: 260px">Games Accidents</label>	
<input type="text" name="gamesAccidents" maxlength="19"   validate="name, string,no" id="gamesAccidentsId" value="" />	
<div class="Clear"></div>	
<label style="width: 260px">Road Accidents</label>	
<input type="text" name="twoWheelersAccidents"  maxlength="19"  validate="name, string,no" id="twoWheelersAccidentsId" value="" />	

<label style="width: 260px">Mechanical Transport Accident</label>	
<input  type="text" name="mechanicalTransportAccident" maxlength="49" validate="name, string,no" id="mechanicalTransportAccidentId" value="" />	
	<div class="Clear"></div>	
<label style="width: 260px">Other Accidents</label>	
<input type="text" name="otherAccidents"   maxlength="19"  validate="name, string,no"  id="otherAccidentsId" value="" />	
		
<label  style="width: 260px"> Reasons for any increase in incident</label>	
<input type="text" name="reasonsforanyincreaseinIncident"   maxlength="49"   validate="name, string,no" id="reasonsforanyincreaseinIncidentId" value="" />
<div class="clear"></div>
<label style="width: 260px">Preventable Date</label>
<input type="text" id="preventableDate" name="preventableDate" value="<%=currentDate %>" readonly="readonly" class="textbox_date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
   onClick="setdate('<%=currentDate %>',document.PreventableDiseaseEntry.preventableDate,event)" />

<div class="Clear"></div>	

	<input type="button" name="Submit"  class="button"  onclick="submitForm('PreventableDiseaseEntry','/hms/hms/mis?method=submitPreventableDiseaseEntry');"  value="Submit" />
<!--<input type="button" name="edit" value="Print" class="button" />
-->
<!--<input type="button" name="Reset" onclick="submitForm('lmcPsychiatricPatientCounseling','sHO?method=showLowMedCatPsychiatricPatientCounelingEntry');" value="Reset" class="button"/>
-->
<!--<input type="button" name="edit" value="Back" class="button" />	
	-->
	</div>
	
	
	
<div class="Clear"></div>

</form>




	
	
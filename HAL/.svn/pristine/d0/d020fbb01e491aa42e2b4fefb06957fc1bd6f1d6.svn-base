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
	<form name="AutomaticChloroformsBleachingPowderDoserEntry" action="" method="post">

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
	
<div class="titleBg"><h2>Automatic Chloroforms / Bleaching Powder Doser Entry</h2>
</div>
<div class="Block">


<div class="clear"></div>
<label>Chloroform Entry Date</label>
<input type="text" id="antiMalariaDate" name="chloroformEntryDate" value="<%=currentDate %>" readonly="readonly" class="textbox_date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
   onClick="setdate('<%=currentDate %>',document.AutomaticChloroformsBleachingPowderDoserEntry.chloroformEntryDate,event)" />
<label style="width: 312px">No Authorised</label>	
<input  type="text" name="noAuthorised" Validate = "name ,number ,no " id="noAuthorised" value="" />	
	
<label style="width: 312px">No Installed</label>	
<input  type="text" name="noInstalled" Validate = "name ,number ,no " id="noInstalled" value="" />	
<div class="clear"></div>
<label style="width: 312px">No U/S due to Mechanical defect</label>	
<input  type="text" name="noUSduetoMechanicaldefect" Validate = "name ,number ,no " id="noU/SduetoMechanicaldefectId" value="" />

<label style="width: 312px">No U/S due to non availability of chlorine gas</label>
<input  type="text" name="noUSduetononavailabilityofchlorinegas" Validate = "name ,number ,no " id="noU/SduetononavailabilityofchlorinegasId" value="" />	
<div class="clear"></div>
<label style="width: 312px">No U/S due to non availability of cylender</label>
<input type="text" name="noUSduetononavailabilityofcylender" Validate = "name ,number ,no " id="noU/SduetononavailabilityofcylenderId" value="" />

<label style="width: 312px">No of BP doser installed</label>
<input  type="text" name="noofBPdoserinstalled" Validate = "name ,number ,no " id="noofBPdoserinstalledId" value="" />
<div class="clear"></div>
<label style="width: 312px">No of BP doser U/S</label>
<input  type="text" name="noofBPdoserUS" Validate = "name ,number ,no " id="noofBPdoserU/SId" value="" />

<label style="width: 312px">Action Taken</label>	
<input  type="text" name="actionTaken" Validate = "name ,string ,no " id="actionTakenId" value="" />
<div class="clear"></div>
<label style="width: 312px">Remarks</label>	
<input type="text" name="remarks" Validate = "name ,string ,no "id="remarksId" value="" />
<div class="clear"></div>
<div class="Clear"></div>
	<div class="Clear"></div>	

	<input type="button" name="edit" value="Submit" class="button" onclick="submitForm('AutomaticChloroformsBleachingPowderDoserEntry','/hms/hms/mis?method=submitAutomaticChloroform');"/>
<!--<input type="button" name="edit" value="Print" class="button" />
-->
<input type="button" name="Reset" onclick="submitForm('lmcPsychiatricPatientCounseling','sHO?method=showLowMedCatPsychiatricPatientCounelingEntry');" value="Reset" class="button"/>
<input type="button" name="edit" value="Back" class="button" onclick="back.history()"/>	
	</div>

	
	
<div class="Clear"></div>
		
</form>





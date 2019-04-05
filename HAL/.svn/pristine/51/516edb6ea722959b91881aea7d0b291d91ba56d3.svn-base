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
	
	<form name="Accommodation" action="" method="post">

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
	
	
<div class="titleBg"><h2>Accommodation</h2>
</div>
<div class="Block">

<h4>Authorised</h4>
<div class="clear"></div>
<label style="margin-left:200px; width: 70px" >Officers</label>
	<label style="margin-left:80px; width: 70px">Airmen</label>
	
	<div class="clear"></div>
<label style="margin-left:20px; width: 70px"> Single</label>	

<input style="margin-left:100px; width: 80px"   type="text" name="malariaFresh" validate="name, string,no" id="rank/RateId" value="" />
<input  style="margin-left:70px; width: 80px" type="text" name="malariaFresh" validate="name, string,no" id="rank/RateId" value="" />

<div class="clear"></div>
<label style="margin-left:20px; width: 70px">Married</label>
<input style="margin-left:100px; width: 80px"  type="text" name="authorisedMarriedOfficer" id="authorisedMarriedOfficer" value="" />
<input style="margin-left:70px; width: 80px" type="text" name="authorisedMarriedAirmen" id="authorisedMarriedAirmen" vlaue="" />
<h4>Available</h4>
<div class="clear"></div>
<label style="margin-left:200px; width: 70px" >Officers</label>
	<label style="margin-left:80px; width: 70px">Airmen</label>
	
	<div class="clear"></div>
	<label style="margin-left:20px; width: 70px">Single</label>
	<input style="margin-left:100px; width:80px" type="text" name="availablesingleOfficer" id="availablesingleOfficer" value="" />
	<input style="margin-left:70px; width: 80px" type="text" name="availablesingleAirmen" id="availablesingleAirmen" vlaue="" />
    <div class="clear"></div>
    <label style="margin-left:20px; width: 70px"> Married</label>	

<input style="margin-left:100px; width: 80px"  " type="text" name="availableMarriedOfficer"  id="availableMarriedOfficer" value="" />
<input  style="margin-left:70px; width: 80px" type="text" name="availableMarriedAirmen"  id="availableMarriedAirmen" value="" />

<div class="clear"></div>
<label style=" width: 300px"> Action Taken to  work is in progress</label>	
<input style=" width: 300px" type="text" name="actionTakento" validate="name, string,no" id="actionTakentoId" value="" />

<!--<div class="clear"></div>
<label style=" width: 500px"> General Hygiene and Sanitation</label>

<input style=" width: 300px" type="text" name="generalHygiene" validate="name, string,no" id="generalHygieneId" value="" />
<div class="clear"></div>
<label style=" width: 500px"> Arrangement for Disposal of night soil,waste and Refuse</label>
	
<input style=" width: 300px" type="text" name="arrangementFor" validate="name, string,no" id="arrangementForId" value="" />
-->


<!--<label style=" width: 500px"> Action Taken</label>
	
<input style=" width: 300px" type="text" name="actionTak" validate="name, string,no" id="actionTakId" value="" />
-->
<div class="clear"></div>
<label style=" width: 300px"> Remarks</label>	
<input style=" width: 300px" type="text" name="remarksForAccommodation" validate="name, string,no" id="remarksId" value="" />
<div class="clear"></div>
<div class="clear"></div>

<input type="button" name="edit" value="Submit" class="button" />
<!--<input type="button" name="edit" value="Print" class="button" />
-->
<input type="button" name="Reset" onclick="submitForm('lmcPsychiatricPatientCounseling','sHO?method=showLowMedCatPsychiatricPatientCounelingEntry');" value="Reset" class="button"/>
<input type="button" name="edit" value="Back" class="button" />	
	</div>
<div class="clear"></div>
</form>











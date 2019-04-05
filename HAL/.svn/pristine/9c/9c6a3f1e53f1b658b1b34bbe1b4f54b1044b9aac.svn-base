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
	
	<form name="meetingHeldAgency" action="" method="post">

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
	
<div class="titleBg"><h2>Meeting Held with Agencies</h2>
</div>
<div class="Block">


<div class="clear"></div>

<label style=" width: 250px">Particulars of Meeting</label>	
<input  type="text" name="particularsofMeeting"  id="particularsofMeetingId" value="" />	

<label style=" width: 250px">Date of Meeting</label>	
<input type="text"	id="commissionDateId" name="meetingDate" tabindex="1" value=""	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="calDate" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
  onClick="setdate('<%=currentDate %>',document.meetingHeldAgency.meetingDate,event)"/>
<div class="clear"></div>
<label style=" width: 250px">Subject Discussed in Meeting</label>	
<input  type="text" name="subjectDiscussedinMeeting" class="auto" id="subjectDiscussedinMeetingId" value="" size="107" />

<div class="clear"></div>
<label style=" width: 250px">Decision implemented/Follow up action</label>	
<input  type="text" name="decisionimplementedFollow" class="auto" id="decisionimplemented/FollowId" value="" size="107" />
<div class="clear"></div>
<label style=" width: 250px">Summary of decision taken</label>	
<input  type="text" name="summaryofdecisiontaken" class="auto" id="summaryofdecisiontakenId" value="" size="107"/>
<div class="clear"></div>

<div class="clear"></div>
<label style=" width: 250px">Remarks</label>	
<input  type="text" name="remarksinMeeting"  class="auto" id="otherId" value="" size="107"/>
<div class="clear"></div>
<div class="clear"></div>
<input type="button" name="Submit"  onClick="submitForm('meetingHeldAgency','/hms/hms/mis?method=submitMeetingHeldAgency');" value="Submit" class="button" />
<!--<input type="button" name="edit" value="Print" class="button" />
-->
<input type="button" name="Reset" onclick="submitForm('lmcPsychiatricPatientCounseling','sHO?method=showLowMedCatPsychiatricPatientCounelingEntry');" value="Reset" class="button"/>
<input type="button" name="edit" value="Back" class="button" onclick="history.back();"/>	
	</div>
	
	<div class="clear"></div>



</form>










	
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

<form name="ActivitiesDetails" action="" method="post">

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
<h2>Activities Details Against HIV</h2>
</div>
<div class="Block">

<div class="clear"></div>


<label >Date <span>*</span></label>
<input  type="text"	id="" name="activityDate" tabindex="1" value=""	 validate="Date,date,yes" MAXLENGTH="30" class="calDate" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
onClick="setdate('<%=currentDate %>',document.ActivitiesDetails.activityDate,event)"/> 

<label>Activities Details<span>*</span></label>
<select name="activityDetails" validate="Activities Details,String,yes" >
<option value="">Select</option>
<option value="Health">Health</option>
<option value="Flight">Flight</option>
<option value="Safety">Safety</option>
<option value="HIV">HIV</option>
<option value="AIDS">AIDS</option>
</select>

<div class="clear"></div>

<h4>No. Attended</h4>

<div class="clear"></div>

<label>Officers</label>
<input type="text" name="officers"  validate="name, string,no"  value="" maxlength="100" class="auto" size="100" />

<div class="clear"></div>

<label>SNCOs/Airmen</label>
<input type="text" name="sncosAirmen"  validate="name, string,no" value="" maxlength="100" class="auto" size="100" />

<div class="clear"></div>

<label>Families</label>	
<input type="text" name="families"  validate="name, string,no" value="" maxlength="100" class="auto" size="100" />

<div class="clear"></div>

<label>Remarks</label>
<input type="text" name="remarks"  validate="name, string,no" value="" maxlength="100" class="auto" size="100" />	
	</div>
<div class="clear PaddingTop10"></div>	
<input type="button" class="button" name="save" value="Submit" onclick="submitForm('ActivitiesDetails','/hms/hms/mis?method=submitActivityAgainstHiv');" />
<!--<input type="button" name="submit" value="Submit" onclick="submitForm('ActivitiesDetails','/hms/hms/mis?method=submitActivityAgainstHiv');" class="button" />
--><input type="button" name="reset" value="Reset" class="button" />
<input type="button" name="back" value="Back" class="button" onclick="history.back();"/>	

	
</form>	

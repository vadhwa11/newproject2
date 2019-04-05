<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.MasRank"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<div id="contentHolder"><script type="text/javascript" language="javascript">





<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.AviAircrewMedicalLectures"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">



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


Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}


int cmdId=0;
if(map.get("cmdId") != null){
	cmdId=(Integer)map.get("cmdId");

	}
String command="";
if(map.get("command") != null){
	command=(String)map.get("command");

	}



int hospId=0;
if(map.get("hospId") != null){
	hospId=(Integer)map.get("hospId");

	}
String hosp="";
if(map.get("hosp") != null){
	hosp=(String)map.get("hosp");

	}
String f="";
if(map.get("f") != null){
	f=(String)map.get("f");

	}
String t="";
if(map.get("t") != null){
	t=(String)map.get("t");

	}
%>

</script> 

<%
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currenDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");

%>


<%
List<MasHospital> hospitalList = new ArrayList<MasHospital>();


if(map.get("hospitalList")!=null){
	hospitalList = (List<MasHospital>)map.get("hospitalList");
}

%>


<div class="Clear"></div>

<form name="malariaCase" target="_blank" method="post" action="">
<div class="Block">


<label>Date</label>
<label class="medium"> From Date<span>*</span> </label> 
<input	type="text" id="fromDateId" name="<%=FROM_DATE %>" value="<%=f %>" class="date" readonly="readonly" MAXLENGTH="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currenDate %>',document.malariaCase.<%=FROM_DATE%>,event)" />


<label>To Date<span>*</span> </label> 
<input type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=t %>" class="date" readonly="readonly" MAXLENGTH="30" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currenDate %>',document.malariaCase.<%=TO_DATE%>,event)" />

<div class="clear"></div>



<label>Command</label>
<input type="text" class="transparent" size="13" />
<select name="cmdId"  id="cmdId">
<option value="<%=cmdId%>" selected="selected"><%=command %></option>
</select>

<label>SMC</label>
<select>
	<option value=<%=hospId%>><%=hosp %></option>
</select>

<div class="clear"></div>

</div>


<div class="Clear"></div>
 
<input type="button" name="OK" value="Ok" class="button" onClick="submitForm('malariaCase','mis?method=printMonthlyMalariaCaseReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
</form>

</div> 
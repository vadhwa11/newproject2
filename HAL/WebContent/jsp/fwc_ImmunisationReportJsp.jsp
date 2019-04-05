
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

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

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">


<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}

%>
<div class="titleBg">
<h2>Immunization </h2>
</div>

<form name="search" target="_blank" method="post" action="">
<div class="Block">

<label>From Date  <span>*</span> </label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" class="date"
	MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />
<a
	href="javascript:setdate('<%=currentDate%>',document.search.<%=FROM_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> 
<label > To Date<span>*</span> </label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>" class="date" MAXLENGTH="30"
	validate="Pick a to date,date,yes" readonly="readonly" /> <a
	href="javascript:setdate('<%=currentDate%>',document.search.<%=TO_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> 


<div class="clear"></div>

<label>Service No. </label>
<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""	 validate="Service No.,metachar,no" MAXLENGTH="30"	onblur="getHinNo('search','opd?method=getHinNoForpatientpres&flag=visit')" />

<div id="hinDiv">
<label> Patient Name</label>
<input	type="text" name="<%=HIN_NO%>" readonly="readonly" value="" MAXLENGTH="30"	validate="Patient Name,metachar,no" />
</div>

<div class="clear"></div>
	</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="Ok" class="button"
	onClick="submitForm('search','fwc?method=immunisationReportJsp');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
	







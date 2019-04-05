

<%@page import="jkt.hms.masters.business.RcHeader"%>
<%@ page import="jkt.hms.util.RequestConstants"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/hms/jsp/js/jquery.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/controls.js?n=1"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script>
<%
StringBuffer orderDateOnly = new StringBuffer();
GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
if (dateOfMonth < 10) {
	orderDateOnly.append("0");
	orderDateOnly.append(dateOfMonth);
} else {
	orderDateOnly.append(dateOfMonth);
}

orderDateOnly.append("/");

int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
if (month < 10) {
	orderDateOnly.append("0");
	orderDateOnly.append(month);
} else {
	orderDateOnly.append(month);
}

orderDateOnly.append("/");
int year = gregorianCalendar1.get(Calendar.YEAR);
orderDateOnly.append(year);
String currentDate = new String(orderDateOnly);
%>
<%




	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>
<%
    String pageTitle = "";
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	List<RcHeader> ipdRcHeaderList=new ArrayList<RcHeader>();
	if(map.get("ipdRcHeaderList")!=null){
		ipdRcHeaderList = (ArrayList)map.get("ipdRcHeaderList");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	

	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName"); 
	 
	}
	
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId =  (Integer)session.getAttribute("hospitalId");
	}
	
	
	
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId =  (Integer)session.getAttribute("deptId");
	}

%>
<form name="nisDetails" method="post" action="">
<div class="titleBg">
<h2>Receiving Report Entry</h2>
</div>
<!-- <div class="page_title">Medical Exam waiting List</div> -->

<div class="Block">

<label>RC No.<span>*</span> </label>
<select name="rc_id" validate="RC No.,string,yes"  tabindex=1	onchange="submitProtoAjaxWithDivNameToShowStatus('nisDetails','/hms/hms/stores?method=getRRList','RRDiv');">
<option value="0">Select</option>
	<%
	
	
				for (RcHeader  e	 : ipdRcHeaderList){
			
				%>
<option value="<%=e.getId()%>"><%=e.getRcNo()%></option>

	<%}%>
	
</select>

<div id="RRDiv">
<label>RR No. <span>*</span></label>
<select name="grnId" validate="RR No." tabindex=1	validate="RR No.,string,yes" >
<option value="0">Select</option>
</select>
</div>

</div>
	
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="submitForm('nisDetails','/hms/hms/stores?method=generateReceivingReport');"  tabindex=1 />

<input type="reset" name="Reset" id="reset" value="Reset" class="button" onClick="submitFormForButton('nisDetails','/hms/hms/stores?method=showRCReportJsp');" accesskey="r" /> 



</form>
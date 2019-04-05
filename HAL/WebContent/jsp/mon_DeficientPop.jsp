
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.AviAircrewMedicalLectures"%>

<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">

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

<script type="text/javascript">
function check(){
var SDate = document.mon_Deficient.<%= FROM_DATE%>.value;
var EDate = document.mon_Deficient.<%= TO_DATE %>.value;
var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<%

Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}

int cmdId=0;
if(map.get("cmdId") != null && !map.get("cmdId").equals("0")){
	cmdId=(Integer)map.get("cmdId");

	}
String command="";
if(map.get("command") != null && !map.get("command").equals("")){
	command=(String)map.get("command");

	}
String f="";
if(map.get("f") != null){
	f=(String)map.get("f");

	}
String t="";
if(map.get("t") != null){
	t=(String)map.get("t");

	}

List<MasHospital> hospitalList = new ArrayList<MasHospital>();
if(map.get("hospitalList") != null){
	hospitalList= (List<MasHospital>)map.get("hospitalList");
}

	List<MasRank> rankList = new ArrayList<MasRank>();
	if(map.get("rankList") != null){
		rankList= (List<MasRank>)map.get("rankList");
	}
	List<MasTrade> tradeList = new ArrayList<MasTrade>();
	if(map.get("tradeList") != null){
		tradeList= (List<MasTrade>)map.get("tradeList");
	}
%>
<form name="mon_Deficient" method="post" action="" >

<div class="titleBg">
<h2>Deficient</h2>
</div>
<div class="Block">

<label>From Date <span>*</span>  </label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=f %>" class="auto" size="20" MAXLENGTH="30" validate="From date,date,yes" readonly="readonly" id="fromDate"/>
<a	href="javascript:setdate('<%=f%>',document.mon_Deficient.<%=FROM_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" /> </a>
 
<label > To Date <span>*</span> </label> 
<input type="text" name="<%=TO_DATE%>" value="<%=t %>" class="auto" size="20" MAXLENGTH="30"	validate="To date,date,yes" readonly="readonly" id="toDate" /> 
<a href="javascript:setdate('<%=t%>',document.mon_Deficient.<%=TO_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" /> </a> 


<div class="clear"></div>
<label>Command </label> 

<select name="cmdId"  id="cmdId">
<option value="<%=cmdId%>" selected="selected"><%=command %></option>
</select>

<label>SMC </label> 

<select name="hospitalId"  id="hospitalId">
<option value="0">Select</option>
	<%for(MasHospital h : hospitalList){%>
		<option value="<%=h.getId() %>" ><%=h.getHospitalName() %></option>
	<%}%>
</select>
<div class="clear"></div>

<label>Rank </label> 

<select name="rankId"  id="rankId">
<option value="0">Select</option>
	<%for(MasRank r : rankList){%>
		<option value="<%=r.getId() %>" ><%=r.getRankName() %></option>
	<%}%>
</select>

<label>Trade/Branch </label> 

<select name="tardeId"  id=""tardeId"">
<option value="0">Select</option>
	<%for(MasTrade r : tradeList){%>
		<option value="<%=r.getId() %>" ><%=r.getTradeName() %></option>
	<%}%>
</select>
</div>

<div class="division"></div>
<input  type="button"	tabindex="1" align="right" class="button" value="Ok" onclick="submitForm('mon_Deficient','/hms/hms/mis?method=generateDefeicientReport');" />
<input name="Reset" type="reset" tabindex="1" align="right"	class="button" value="Cancel" onclick="" />
<div class="clear"></div>

</form>

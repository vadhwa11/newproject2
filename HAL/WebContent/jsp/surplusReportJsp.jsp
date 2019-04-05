<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'

  function validateDates() 
  {
		var strValue = document.surplusReportJsp.<%=FROM_DATE%>.value;
        
        if(strValue=='')
        {
        	alert("From Date can't be Blank ....");
			return false;
        }      
		var fromDate = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
		strValue = document.surplusReportJsp.<%=TO_DATE%>.value;
		 
		    if(strValue=='')
	        {
	        	alert("To Date can't be Blank ....");
				return false;
	        }      
				
	 	var toDate  = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
			
		if (fromDate > toDate)
	 	{
			alert('From Date cannot be greater than To Date!....');
			return false;
	 	}
	 	
	 	return true; 
		
	}	
</script>

<%
String department ="";
String deptName= "";
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
if(session.getAttribute("deptName") != null){
	deptName = (String)session.getAttribute("deptName");
}
int hospitalId =0;
if(map.get("hospitalId")!=null){
	 hospitalId = (Integer)map.get("hospitalId");
}
List<MasRank> rankList = new ArrayList<MasRank>();
List<MasTrade> tradeList = null;
List<Object[]> unitList = null;

if(map.get("rankList")!=null){
	rankList = (List<MasRank>)map.get("rankList");
}
if(map.get("tradeList") != null){
	tradeList = (List<MasTrade>)map.get("tradeList");
}
if(map.get("unitList") != null){
	unitList= (List<Object[]>)map.get("unitList");
}
%>
<form name="surplusReportJsp" method="post">
<input type="hidden" name="hospitalId" value="<%=hospitalId %>"/>
<div class="titleBg">
<h2>Surplus AFMSF-1</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label> From Date <span>*</span></label> 
<input type="text" name="<%= FROM_DATE %>" value="<%=currentDate%>" class="date" maxlength="30" tabindex=1 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.surplusReportJsp.<%= FROM_DATE%>,event);" />
<label> To Date <span>*</span></label> <input type="text" name="<%= TO_DATE %>" value="<%=currentDate%>" class="date"	maxlength="30" tabindex=1 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.surplusReportJsp.<%= TO_DATE%>,true);" />
<div class="clear"></div><div class="clear"></div>
<!--<label class="medium">Receipt </label> 
 <input type="radio" name="reportType"
	value="yes" class="radioAuto" checked="checked"
	maxlength="30" tabindex=1 /> 
	<label class="medium">Yes</label>
	 <input
	type="radio" name="reportType" value="no" class="radioAuto"
	maxlength="30" tabindex=1 /><label class="medium">No </label>
	--><div class="clear"></div>
	
	<label>Rank</label>
	<select	id="rankId" name="rankId" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		}%>
</select> 

<label> Trade/Branch</label> 
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Trade,string,no" tabindex="1">
	<option value="0">Select</option>
	<%for(MasTrade trade :tradeList){ %>
	<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%} %>
	
</select>
<label>Unit </label> 
<select id="unitId" name="<%=UNIT_ID %>" tabindex="1"	validate="Unit,string,no" >
	<option value="0">Select</option>
	<%
		 for(Object[] masUnit : unitList){
		 %>
	<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>
	<%
	 }%>
	
</select>
	
	<div class="clear"></div>
</div>

<div class="clear"></div>
<input type="button" class="button" value="Ok"
	onclick="if(validateDates()){submitForm('surplusReportJsp','/hms/hms/mis?method=generateSurplusReport');}" />
<input type="button" class="button" value="Cancel" onclick="submitForm('surplusReportJsp','/hms/hms/mis?method=showSurplusReportJsp');"/>
	
</form>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>


<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasRankCategory"%><script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
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
	Map<String, Object> map = new HashMap<String, Object>();
    if (request.getAttribute("map") != null) {
     map = (Map<String, Object>) request.getAttribute("map");
    }
    List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
	if (map.get("rankCategoryList") != null) {
	      rankCategoryList = (List<MasRankCategory>) map.get("rankCategoryList");
	     }
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'

  function validateDates() 
  {
		var strValue = document.edReturnReportJsp.<%=FROM_DATE%>.value;
        
        if(strValue=='')
        {
        	alert("From Date can't be Blank ....");
			return false;
        }      
		var fromDate = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
		strValue = document.edReturnReportJsp.<%=TO_DATE%>.value;
		 
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
if(session.getAttribute("deptName") != null){
	deptName = (String)session.getAttribute("deptName");
}

%>
<form name="edReturnReportJsp" method="post">
<div class="titleBg">
<h2>Excuse Duty Returns for the Officers/Airmen</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date </label> 
<input type="text" name="<%= FROM_DATE %>" value="<%=currentDate%>" class="date" maxlength="30" tabindex=1 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.edReturnReportJsp.<%= FROM_DATE%>,event);" />
<label><span>*</span> To Date </label> <input type="text" name="<%= TO_DATE %>" value="<%=currentDate%>" class="date"	maxlength="30" tabindex=1 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.edReturnReportJsp.<%= TO_DATE%>,true);" />
<div class="clear"></div><div class="clear"></div>

<label>Category :</label> <select id="categoryId"
	name="<%=CATEGORY_ID %>" validate="Category,string,yes">
	<option value="0">Select</option>
	<%for (MasRankCategory masRankCategory : rankCategoryList) {%>
	<option value="<%=masRankCategory.getId() %>"><%=masRankCategory.getRankCategoryName()%></option>
	<%}%>
</select>
</div>

<div class="clear"></div>
<input type="button" class="button" value="Ok"
	onclick="if(validateDates()){submitForm('edReturnReportJsp','/hms/hms/mis?method=generateSurplusReport');}" />
<input type="button" class="button" value="Cancel" onclick="submitForm('edReturnReportJsp','/hms/hms/mis?method=showSurplusReportJsp');"/>
	
</form>
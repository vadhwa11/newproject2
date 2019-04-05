<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>


<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
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
	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
 
	function validateDates() 
	{
		var strValue = document.grReturnRecieptRegister.<%=FROM_DATE%>.value;
        
        if(strValue=='')
        {
        	alert("From Date can't be Blank ....");
			return false;
        }      
		var fromDate = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
		strValue = document.grReturnRecieptRegister.<%=TO_DATE%>.value;
		 
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


//System.out.println("department "+deptName);
%>
<form name="grReturnRecieptRegister" method="post">
<div class="titleBg">
<h2> Receive Item Details</h2>
</div>
<div class="clear"></div>
<div class="Block">
<%-- 
<label> Department</label> 
<input type="text" value="<%=deptName%>" readonly="readonly" />
--%>
<div class="clear"></div>
<label>From Date<span>*</span> </label> <input type="text"
	name="<%= FROM_DATE %>" value="<%=currentDate%>" class="date"
	maxlength="30" tabindex=1   readonly /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.grReturnRecieptRegister.<%= FROM_DATE%>,event);" />
<label>To Date <span>*</span></label> <input type="text"
	name="<%= TO_DATE %>" value="<%=currentDate%>" class="date"
	maxlength="30" tabindex=1 readonly /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.grReturnRecieptRegister.<%= TO_DATE%>,true);" />
<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<input type="button" class="buttonBig" value="Generate Report"
	onclick="if(validateDates()){submitForm('grReturnRecieptRegister','/hms/hms/stores?method=printDispensaryReceiveItemReport&flag=j');}" />
<input type="button" class="buttonBig" value="Print"
	onclick="if(validateDates()){submitForm('grReturnRecieptRegister','/hms/hms/stores?method=printDispensaryReceiveItemReport&flag=p');}" />
<input type="button" class="buttonBig" value="Export to Excel"
	onclick="if(validateDates()){submitForm('grReturnRecieptRegister','/hms/hms/stores?method=printDispensaryReceiveItemReportExcel');}" />
	<div class="clear"></div>
<div class="clear"></div>
	<div class="division"></div>

</form>
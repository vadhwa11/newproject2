<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />


<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script> <script type="text/javascript" language="javascript">
	
function getPendingLATDetails()
{
		 budgetReport.method="post";	
		 submitForm('budgetReport','purchaseOrder?method=pendingLATList');
}

function getPoReg()
{
		 budgetReport.method="post";	
		 submitForm('budgetReport','purchaseOrder?method=generatePORegisterReport');
}

function getRecReg()
{
		 budgetReport.method="post";	
		 submitForm('budgetReport','stores?method=generateReceiptRegisterReport');
}
function getSOPendCRV(){
         budgetReport.method="post";
         submitForm('budgetReport','purchaseOrder?method=pendingSOCRVList');
}
	<%
int dateOfMonth, month1, year1;
Calendar calendar1 = Calendar.getInstance();
StringBuffer dateOnly = new StringBuffer();
month1 = calendar.get(Calendar.MONTH) + 1;
if(month1 > 0 && month1 < 4){
	year1 = calendar.get(Calendar.YEAR) - 1;	
}else{
	year1 = calendar.get(Calendar.YEAR);	
}

dateOnly.append("01");
dateOnly.append("/");
dateOnly.append("04");
dateOnly.append("/");
dateOnly.append(year1);

  String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	Box box = HMSUtil.getBox(request);
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
    }	
 	String message = null;
%>
	</script>
<form name="budgetReport" method="post" action="">
<div class="titleBg">
<h2>Budget Report</h2>
</div>

<h4>Budget Report</h4>

<div class="Block">
<label>Period </label> 
<input type="text" id="FromDateId" name="<%=FROM_DATE %>" value="<%=dateOnly %>" class="textbox_date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('',document.budgetReport.<%=FROM_DATE%>,event)" /> 
<label></label> 
<input type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=currentDate %>" class="textbox_date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('',document.budgetReport.<%=TO_DATE%>,event)" />
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="report" onClick="submitProtoAjaxWithDivName('budgetReport','/hms/hms/purchaseOrder?method=getDetailForBudget','budget');" value="GO" class="button">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="budget"></div>
</form>

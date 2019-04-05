
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		int nextyear = calendar.get(calendar.YEAR) + 1;
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>
<script type="text/javascript">
function check(){
var SDate = document.adjustmentReportJsp.<%= FROM_DATE%>.value;
var EDate = document.adjustmentReportJsp.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");

return false;
}
}
function cancelButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=showItemAdjustmentReportJsp";
  obj.submit();
  }
</script>
<%
	String date = "";
	String time = "";
	String userName = "";
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
<form name="adjustmentReportJsp" method="post">
<div class="titleBg">
<h2>Report For Item Adjustment </h2>
</div>
<div class="clear"></div>
<h4>Report For Item Adjustment</h4>
<div class="clear"></div>
<div class="Block">

<label ><span>*</span> From Date  </label> 
<input type="text" name="<%=FROM_DATE%>" value="" class="textbox_date" MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.adjustmentReportJsp.<%=FROM_DATE%>,event)" />

<label><span>*</span> To Date  </label> 
<input type="text" name="<%=TO_DATE%>" value="" class="textbox_date" MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.adjustmentReportJsp.<%=TO_DATE%>,event)" />
</div>

<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" value="Submit" class="button" name="report" align="right" onClick="submitForm('adjustmentReportJsp','/hms/hms/stores?method=generateItemAdjustmentReport');"	> 
<input type="reset"	name="Reset" value="Reset" class="button" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>


<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=showInternalIssueReportJsp";
  obj.submit();
  }
</script>
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
var SDate = document.inertnalIssue.<%= FROM_DATE%>.value;
var EDate = document.inertnalIssue.<%= TO_DATE %>.value;


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
Map map = new HashMap();
if(request.getAttribute("map") != null){
 map = (Map) request.getAttribute("map");
}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		
		if (map.get("departmentList") != null) {
			departmentList = (List<MasDepartment>) map.get("departmentList");
	 	}
%>

<form name="inertnalIssue" method="post" action="">

<div class="titleBg">
<h2>External Issue Report</h2>
</div>
<div class="Block">
<label><span>*</span> From Date  </label> 
<input
	type="text" name="<%=FROM_DATE%>" value="" class="date"
	MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.inertnalIssue.<%=FROM_DATE%>,event)" />
<label><span>*</span> To Date  </label> 
<input
	type="text" name="<%=TO_DATE%>" value="" class="textbox_date"
	MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.inertnalIssue.<%=TO_DATE%>,event)" />
<div class="clear"></div>	
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
 <input type="button" name="add"
	id="addbutton" value="Ok" class="button"
	onClick="submitForm('inertnalIssue','stores?method=showExternalIssueReport','check()');"
	accesskey="a" tabindex=1 /> 
<input type="button" name="clear"
	id="clearbutton" value="Cancel" class="button"
	onClick="clearButton('inertnalIssue');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>









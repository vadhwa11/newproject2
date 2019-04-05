
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/fwc?method=showFwcOncosurgeryWiseReportJsp";
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
var SDate = document.oncosurgeryWise.<%= FROM_DATE%>.value;
var EDate = document.oncosurgeryWise.<%= TO_DATE %>.value;


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
	List<MasDepartment> searchMasDepartmentList = new ArrayList<MasDepartment>();
	List<MasEmployee> searchMasEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("searchMasDepartmentList")!=null)
		searchMasDepartmentList = (List) map.get("searchMasDepartmentList");
	if(map.get("searchMasEmployeeList")!=null)
		searchMasEmployeeList = (List) map.get("searchMasEmployeeList");


%>
<div id="contentHolder">
<form name="oncosurgeryWise" method="post" action="">
<div class="Clear"></div>
<div class="division"></div>
<div class="panelbar">
<div class="paneltext">Onco Surgery Wise Summary</div>
</div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>

<label><font id="error">*</font>From Date :</label> <input type="text"
	class="calDate" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.oncosurgeryWise.<%=FROM_DATE%>,event)" />

<label><font id="error">*</font>To Date :</label> <input type="text"
	class="calDate" id="toDateId" name="<%=TO_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.oncosurgeryWise.<%=TO_DATE%>,event)" />

<label><font id="error">*</font>Stage T:</label> <select
	name="<%=STAGE_T%>" validate="Stage T,String,yes">
	<option value="">select</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
</select>
<div class="Clear"></div>
<label><font id="error">*</font>Stage N:</label> <select
	name="<%=STAGE_N%>" validate="Stage N,String,yes">
	<option value="">select</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
</select> <label><font id="error">*</font>Stage M:</label> <select
	name="<%=STAGE_M%>" validate="Stage M,String,yes">
	<option value="">select</option>
	<option value="z">0</option>
	<option value="1">1</option>
	<option value="2">2</option>

</select> <label><font id="error">*</font>Stage Nor:</label> <select
	name="<%=STAGE_NOR%>" validate="Stage Nor,String,yes">
	<option value="">select</option>
	<option value="1">I</option>
	<option value="2">II</option>
	<option value="3">III</option>
	<option value="4">IV</option>
</select></div>
<div class="Clear"></div>

<div class="bottom"><input type="button" name="add" id="addbutton"
	value="Ok" class="button"
	onClick="submitForm('oncosurgeryWise','fwc?method=generateFwcOncosurgeryWiseReport','check()');"
	accesskey="a" tabindex=1 /> <input type="button" name="clear"
	id="clearbutton" value="Clear" class="button"
	onClick="clearButton('oncosurgeryWise');" accesskey="a" tabindex=1 /></div>
</form>
</div>







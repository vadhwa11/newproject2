
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.CssdAutoclaveEntryM"%>
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

function check1()
{
var SDate = document.cssdReportForm.<%= FROM_DATE%>.value;
var EDate = document.cssdReportForm.<%= TO_DATE %>.value;

var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}

function report2()
{
var lotNo = document.getElementById("lotNo").value;
if (lotNo==0)
{
	alert('Pl. Select Lot No!..... ');
	return false;
}
submitForm('cssdReportForm','cssd?method=generateMaterialListLotWise');
}

</script>
<%

	Map<String ,Object> map = new HashMap<String ,Object>();
	String entryNo = "";
	String lotNo = "-";
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}

	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<CssdAutoclaveEntryM> cssdAutoclaveEntryMList = new ArrayList<CssdAutoclaveEntryM>();
	
	cssdAutoclaveEntryMList = (ArrayList<CssdAutoclaveEntryM>)map.get("cssdAutoclaveEntryMList");
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
%>
<div id="contentspace">
<form name="cssdReportForm" method="post" action=""><br />
<br />
<div class="panelbar">
<div class="paneltext"">Autoclave Material List</div>
</div>
<br />

<label class="bodytextB1"><font id="error">*</font>From Date :</label> <input
	type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>"
	class="textbox_date" MAXLENGTH="30"
	validate="Pick a from date,date,yes" readonly="readonly" /> <a
	href="javascript:setdate('<%=currentDate%>',document.cssdReportForm.<%=FROM_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <label class="bodytextB1"><font
	id="error">*</font>To Date :</label> <input type="text" name="<%=TO_DATE%>"
	value="<%=currentDate%>" class="textbox_date" MAXLENGTH="30"
	validate="Pick a to date,date,yes" readonly="readonly" /> <a
	href="javascript:setdate('<%=currentDate%>',document.cssdReportForm.<%=TO_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <br />
<br />
<input type="button" name="Generate Report" id="addbutton"
	value="Report - Date Wise" class="buttonbig"
	onClick="submitForm('cssdReportForm','cssd?method=generateMaterialListDateWise','check1()');"
	accesskey="a" tabindex=1 /> <br />
<br />

<label class="bodytextB1"><font id="error">*</font>Lot No:</label> <select
	name="lotNo" id="lotNo">
	<option value="0">Select Lot No</option>
	<% for (CssdAutoclaveEntryM cssdAutoclaveEntryM : cssdAutoclaveEntryMList) { %>
	<option value="<%=cssdAutoclaveEntryM.getLotNo() %>"><%=cssdAutoclaveEntryM.getLotNo()%></option>
	<% } %>
</select> <br />
<br />
<input type="button" name="Generate Report" id="addbutton"
	value="Report - Lot Wise" class="buttonbig" onClick="report2();"
	accesskey="a" tabindex=1 /></form>
</div>

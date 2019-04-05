<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasAgendaPointForWorkServices"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>
<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
			
	%>
<SCRIPT>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	</SCRIPT>
<%	String 	userName="";
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(session.getAttribute("userName")!=null){
		userName=(String)session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String time = (String) utilMap.get("currentTime");
	String currentDate = (String)utilMap.get("currentDate");  

	String sessionPeriod="";
	if(map.get("session")!=null)
	{
		sessionPeriod=(String) map.get("session");
	}
	
	List<MasAgendaPointForWorkServices> masAgendaPointForWorkServices = new ArrayList<MasAgendaPointForWorkServices>();
	if(map.get("masAgendaPointForWorkServices")!=null)
	{
		masAgendaPointForWorkServices = (List) map.get("masAgendaPointForWorkServices");
	}
	
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	
	if(map.get("departmentList")!=null)
	{
		departmentList = (List) map.get("departmentList");
	}
	
	%>

<script type="text/javascript">
function checkd(){
var SDate = document.momRegister.<%= FROM_DATE%>.value;
var EDate = document.momRegister.<%= TO_DATE %>.value;


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
String message ="";
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>
<DIV class="Clear"></DIV>

<DIV id=contentHolder>

<FORM name="momRegister" action="" method=post>
<h6>MOM Register</h6>
<DIV class="Clear"></DIV>

<DIV class="blockFrame"><Label><span>*</span> MOM From
Date</Label> <input type="text" name="<%=FROM_DATE%>" value="" class="calDate"
	readonly="readonly" MAXLENGTH="30" validate="Pick a from date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	onClick="setdate('<%=currentDate%>',document.momRegister.<%= FROM_DATE%>,event);"
	class="calender" /> <LABEL><span>*</span> MOM To Date</LABEL> <input
	type="text" name="<%=TO_DATE%>" value="" class="calDate"
	readonly="readonly" validate="Pick a to date,date,yes" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	onClick="setdate('<%=currentDate%>',document.momRegister.<%= TO_DATE%>,event);"
	class="calender" /> <label>Department</label> <select
	name="<%= DEPARTMENT_ID %>" tabindex=1>
	<option value="">Select</option>
	<% 
				for (MasDepartment  masDepartment : departmentList){
				%>

	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>

	<%}%>
</select></DIV>
<div class="division"></div>
<div class="bottom"><input type="button" class=button value="Ok"
	name="print"
	onclick="submitForm('momRegister','/hms/hms/agendaReport?method=printMomRegister','checkd()');" />
<INPUT class=button id=reset accessKey=r onclick=resetCheck();
	type=reset value=Reset name=Reset>
<div class="division"></div>
</div>
</form>
</DIV>
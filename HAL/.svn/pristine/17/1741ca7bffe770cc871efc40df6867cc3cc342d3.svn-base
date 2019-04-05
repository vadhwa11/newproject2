<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.HrLeaveTypeMaster"%>
<%@page import="jkt.hms.masters.business.LeaveRestrictionEntry"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>


<form name="leaveRestrictionUpdate" method="post" action=""><script
	type="text/javascript">
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
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
	
	
	
	
</script> <script type="text/javascript">	
	function checkd()
{
var SDate = document.leaveRestrictionUpdate.<%= FROM_DATE%>.value;
var EDate = document.leaveRestrictionUpdate.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}

	function checkDate()
{
var SDate = document.leaveRestrictionUpdate.<%= ENTRY_DATE%>.value;
var EDate = document.leaveRestrictionUpdate.<%= FROM_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the From Date is greater than or equal to the Entry Date.");
document.calldate.next_day.focus();
return false;
}
}
function checkMaxDays()
    {  var t1=document.getElementById("date").value
       var t2=document.getElementById("sors").value
       if(t1=="" ||t2==""){
       alert("Please fill the to Date and From date first ");
       return false;
       }
       if(document.getElementById("maxLeave").value=="")
       {
       document.getElementById("maxLeave").value=0;
       return 
       }
       fromDate = new Date(t1.substring(6),(t1.substring(3,5) - 1) ,t1.substring(0,2));
       toDate = new Date(t2.substring(6),(t2.substring(3,5) - 1) ,t2.substring(0,2));
       try
       {
          fromDate =  new Date(fromDate)
          toDate =  new Date(toDate)
          if(fromDate!=NaN&&toDate!=NaN)
          {
            var date = toDate.getTime() - fromDate.getTime(); 
            
            var time = Math.floor(date / (1000 * 60 * 60 * 24));
             
            var maxdays = parseInt(document.getElementById("maxLeave").value);
            if(maxdays>time){
            alert("maximun days leave should be less date difference");
            document.getElementById("maxLeave").value=0;
            document.getElementById("maxLeave").focus();
            }
                       
          }
       }
       catch(e) {}
       return ;
    }	
</script> <%
Map<String,Object> map = new HashMap<String,Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
String userName = "";
if(session.getAttribute("userName") != null)
{
	userName = (String)session.getAttribute("userName");
}
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
	}
List<HrLeaveTypeMaster> leaveTypeList=new ArrayList<HrLeaveTypeMaster>();
List<LeaveRestrictionEntry> leaveRestrictionList=new ArrayList<LeaveRestrictionEntry>();


if(map.get("leaveTypeList") != null){
	leaveTypeList = (List<HrLeaveTypeMaster>)map.get("leaveTypeList");
	}
if(map.get("leaveRestrictionList") != null){
	leaveRestrictionList = (List<LeaveRestrictionEntry>)map.get("leaveRestrictionList");
	}

String entryNo ="";
if(map.get("entryNo") != null){
	entryNo = (String)map.get("entryNo");
	}

String endate = "";
	if(leaveRestrictionList.get(0).getEntryDate() != null)
	{
		endate = HMSUtil.convertDateToStringWithoutTime(leaveRestrictionList.get(0).getEntryDate());
	}
	else
	{
		endate = "";
	}

	String fromDate = "";
	if(leaveRestrictionList.get(0).getFromPeriod() != null)
	{
		fromDate = HMSUtil.convertDateToStringWithoutTime(leaveRestrictionList.get(0).getFromPeriod());
	}
	else
	{
		fromDate = "";
	}

	String toDate = "";
	if(leaveRestrictionList.get(0).getToPeriod() != null)
	{
		toDate = HMSUtil.convertDateToStringWithoutTime(leaveRestrictionList.get(0).getToPeriod());
	}
	else
	{
		toDate = "";
	}


int id = 0;
if(map.get("Id") != null)
{
	id = (Integer)map.get("Id");
}
String message="";
if(map.get("message") != null){
 	message = (String)map.get("message");
 	
 	 	
 	
 	
%>
<h2><%=message %></h2>
<%} %>
<div class="Clear"></div>

<div id="contentHolder">
<h6>Leave Restriction Entry Update
<h6>
<div class="Clear"></div>
<div class="blockFrame"><label>Entry No.</label> <%if(leaveRestrictionList.get(0).getEntryNo() != null) {%>
<input type="text" name="<%=ENTRY_NO %>"
	value="<%= leaveRestrictionList.get(0).getEntryNo() %>"
	readOnly="readOnly" tabindex="1" /> <%}else{ %> <input type="text"
	name="<%=ENTRY_NO %>" value="" readOnly="readOnly" tabindex="1" /> <%} %>
<label>Entry Date</label> <input type="text" class="calDate"
	id="entrydate" name="<%=ENTRY_DATE %>" value="<%=endate %>"
	readonly="readonly" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date,date,yes"
	onClick="setdate('<%=date %>',document.leaveRestrictionUpdate.<%=ENTRY_DATE%>,event)" />


<div class="Clear"></div>
<label> From Period</label> <input type="text" class="calDate" id="date"
	name="<%=FROM_DATE %>" value="<%=fromDate %>" readonly="readonly"
	MAXLENGTH="30" tabindex="1" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date,string,yes"
	onClick="setdate('<%=date %>',document.leaveRestrictionUpdate.<%=FROM_DATE%>,event)" />
<label>To Period</label> <input type="text" class="calDate" id="sors"
	name="<%=TO_DATE %>" value="<%=toDate%>" readonly="readonly"
	MAXLENGTH="30" tabindex="1" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a SORS,string,yes"
	onClick="setdate('<%=date %>',document.leaveRestrictionUpdate.<%=TO_DATE%>,event)" />
<div class="Clear"></div>
<label>Leave Type</label> <select id="<%=LEAVE_TYPE %>"
	name="<%=LEAVE_TYPE%>" tabindex="1"
	validate="Select leave type,string,yes">
	<%if(leaveRestrictionList.get(0).getLeave()!=null){ %>
	<option value="<%=leaveRestrictionList.get(0).getLeave().getId() %>"><%=leaveRestrictionList.get(0).getLeave().getLeaveType() %></option>
	<%}else{%>
	<option value="0">select</option>
	<%}
			for(HrLeaveTypeMaster hrLeaveTypeMaster : leaveTypeList){
			%>
	<option value="<%=hrLeaveTypeMaster.getId() %>"><%=hrLeaveTypeMaster.getLeaveType()%></option>
	<%}%>
</select> <label>Max Leave Days</label> <%if(leaveRestrictionList.get(0).getMaxLeaveDays() != null){ %>
<input type="text" maxlength="3" id="maxLeave"
	name="<%=MAX_LEAVE_DAYS %>" tabindex="1"
	value="<%=leaveRestrictionList.get(0).getMaxLeaveDays() %>"
	onBlur="checkMaxDays();" /> <%}else{ %> <input type="text"
	maxlength="3" id="maxLeave" name="<%=MAX_LEAVE_DAYS %>" tabindex="1"
	value="" onBlur="checkMaxDays();" /> <%} %>


<div class="Clear"></div>
<label>Remarks</label> <%if(leaveRestrictionList.get(0).getRemarks() != null){ %>
<input type="text" maxlength="40" name="<%=REMARKS%>" tabindex="1"
	value="<%=leaveRestrictionList.get(0).getRemarks() %>" /> <%}else{ %>
<input type="text" maxlength="40" name="<%=REMARKS%>" tabindex="1"
	value="" /> <%} %>

<div class="Clear"></div>
<div class="clear"></div>
<div class="bottom"><label>Last Changed By</label> <label
	class="value"><%=userName%></label> <label>Last Changed Date</label> <label
	class="value"><%=date%></label> <label>Last Changed Time</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input type="hidden"
	name="id" value="<%=id %>" />

<div class="Clear"></div>
<input type="button" class="button" id=Update accessKey=a value=Update
	name=Update
	onClick="{submitForm('leaveRestrictionUpdate','hrOrderly?method=editLeaveRestrictionUpdate','checkd()','checkDate()')};">
<input class=button id=reset accessKey=r onclick=resetCheck();
	type=reset value=Reset name=Reset> <input name="Button"
	type="button" class="button" value="Close"
	onclick="javascript:history.back();" /> <input name="Button"
	type="button" class="button" value="Search"
	onclick="window.open('hrOrderly?method=showSearchLeaveRestrictionJsp');" />
</div>
</div>
</form>

<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.HrLeaveTypeMaster"%>
<%@page import="jkt.hms.masters.business.LeaveRestrictionEntry"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">
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
</script>
<script type="text/javascript">	
	function checkd()
{
var SDate = document.leaveRestriction.<%= FROM_DATE%>.value;
var EDate = document.leaveRestriction.<%= TO_DATE %>.value;


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

<script type="text/javascript">
    function calDays()
    {    
       var t1=document.getElementById("fromPeriod").value
       var t2=document.getElementById("toPeriod").value
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
            document.getElementById("maxLeave").value=time;
          }
       }
       catch(e) {}
       return false;
    }
    function checkMaxDays()
    {    
       var t1=document.getElementById("fromPeriod").value
       var t2=document.getElementById("toPeriod").value
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
            document.getElementById("maxLeave").value="";
            document.getElementById("maxLeave").focus();
            }
                       
          }
       }
       catch(e) {}
       return ;
    }
</script>

<script type="text/javascript">	
	function checkDate()
{
var SDate = document.leaveRestriction.<%= ENTRY_DATE%>.value;
var EDate = document.leaveRestriction.<%= FROM_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the From Date is greater than or equal to the Entry Date.");
document.calldate.next_day.focus();
return false;
}
}
	
</script>


<script type="text/javascript">
   

function maxDays()
{
var maxLeave = document.getElementById("maxLeave").value
if(document.getElementById("leaveType").value == 1 && maxLeave > 60)
{
alert("Max. Leave Days for AL must be equal to or less than 60");
return false;
}
else
{
return true;
}
}
</script>
<div id="contentHolder">
<form name="leaveRestriction" method="post" action="">
<%
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

if(map.get("leaveTypeList") != null){
	leaveTypeList = (List<HrLeaveTypeMaster>)map.get("leaveTypeList");
	}
List<LeaveRestrictionEntry> leaverestrictionentryList = new ArrayList<LeaveRestrictionEntry>();
if(map.get("leaverestrictionentryList") != null){
	leaverestrictionentryList = (List<LeaveRestrictionEntry>)map.get("leaverestrictionentryList");
	}
String entryNo ="";
if(map.get("entryNo") != null){
	entryNo = (String)map.get("entryNo");
	}
int id = 0;
if(map.get("Id") != null)
{
	id = (Integer)map.get("Id");
}
String message="";
if(map.get("message") != null){
 	message = (String)map.get("message");
%> <br />
<h2 style="color: #AC1400; width: 300;"><%=message %></h2>

<%} %>


<div class="Clear"></div>


<h6>Leave Restriction entry</h6>
<div class="Clear"></div>
<div class="blockFrame"><label>Entry No.</label> <input
	type="text" name="<%=ENTRY_NO %>" value="<%= entryNo %>" /> <label>Entry
Date</label> <input type="text" class="calDate" id="date"
	name="<%=ENTRY_DATE %>" value="<%=date%>" readonly="readonly"
	MAXLENGTH="30" tabindex="1" validate="Entry Date,string,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a from date,string,yes"
	onClick="setdate('<%=date %>',document.leaveRestriction.<%=ENTRY_DATE%>,event)" />

<div class="Clear"></div>
<label><span>*</span> From Period</label> <input type="text"
	class="calDate" id="fromPeriod" name="<%=FROM_DATE %>" value=""
	readonly="readonly" validate="To Date, string,yes" MAXLENGTH="30"
	tabindex="1" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0"
	onClick="setdate('<%=date %>',document.leaveRestriction.<%=FROM_DATE%>,event)" />
<label><span>*</span> To Period</label> <input type="text"
	class="calDate" id="toPeriod" name="<%=TO_DATE %>" value=""
	readonly="readonly" MAXLENGTH="30" validate="To Date, string,yes"
	tabindex="1" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a to date,date,yes"
	onClick="setdate('<%=date %>',document.leaveRestriction.<%=TO_DATE%>,event)" />
<div class="Clear"></div>
<label><span>*</span>Leave Type</label> <select id="leaveType"
	name="<%=LEAVE_TYPE%>" tabindex="1" validate="Leave Type,string,yes">
	<option value="0">Select</option>
	<%
			for(HrLeaveTypeMaster hrLeaveTypeMaster : leaveTypeList){
			%>
	<option value="<%=hrLeaveTypeMaster.getId() %>"><%=hrLeaveTypeMaster.getLeaveType()%></option>
	<%}%>
</select> <label>Max Leave Days</label> <input type="text"
	name="<%=MAX_LEAVE_DAYS %>" id="maxLeave" value="" tabindex="1"
	maxlength="3" onBlur="checkMaxDays();" />
<div class="Clear"></div>
<label>Remarks</label> <input type="text" name="<%=REMARKS%>" value=""
	maxlength="40" tabindex="1" />
<div class="Clear"></div>
<div class="clear"></div>
</div>
<div class="bottom"><label>Last Changed By</label> <label
	class="value"><%=userName%></label> <label>Last Changed Date</label> <label
	class="value"><%=date%></label> <label>Last Changed Time</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input type="hidden"
	name="id" value="<%=id %>" />

<div class="Clear"></div>
<input type="button" class="button" value="Submit"
	onclick="if(checkLeaveRestriction()){submitForm('leaveRestriction','hrOrderly?method=addLeaveRestrictionEntry','checkd()','checkDate()')};"
	align="right" /> <input class=button id=reset accessKey=r
	onclick=resetCheck(); type=reset value=Reset name=Reset> <input
	name="Button" type="button" class="button" value="Close"
	onclick="javascript:history.back();" /> <input name="Button"
	type="button" class="button" value="Search"
	onclick="window.open('hrOrderly?method=showSearchLeaveRestrictionJsp');" />
</div>

<script type="text/javascript">



leave_type_array = new Array();
<%int  counter=0;%>

<% if (leaveTypeList != null && leaveTypeList.size() > 0) {
%>
<% 	for(HrLeaveTypeMaster leaveType : leaveTypeList){
%>
leave_type_array[<%= counter%>] = new Array();
leave_type_array[<%= counter%>][0] = "<%=leaveType.getId()%>"
leave_type_array[<%= counter%>][1] = "<%=leaveType.getLeaveType()%>"
leave_type_array[<%= counter%>][2] = "<%=leaveType.getDays()%>"
<%
counter++;
}
}
%>
leave_restriction_array=new Array();
<% int counter1=0;
	if(leaverestrictionentryList != null){
	for(LeaveRestrictionEntry leaverestrictionentry :leaverestrictionentryList){
	%>
	leave_restriction_array[<%=counter1%>] = new Array();
	leave_restriction_array[<%=counter1%>][0] ="<%=leaverestrictionentry.getLeave().getId()%>"
	leave_restriction_array[<%=counter1%>][1] ="<%=HMSUtil.convertDateToStringWithoutTime(leaverestrictionentry.getFromPeriod())%>"	
	leave_restriction_array[<%=counter1%>][2] ="<%=HMSUtil.convertDateToStringWithoutTime(leaverestrictionentry.getToPeriod())%>"
	<%counter1++;
	}
	
	}

%>

function checkLeaveAvailed()
{
if(leave_type_array.length > 0)
	{
		for(i=0;i<leave_type_array.length;i++)
		{
		if(document.getElementById('leaveType').value == leave_type_array[i][1])
			{
			alert("maxxxxxxxxxxxxxxxxx"+document.getElementById('maxLeave').value )
			alert(parseInt(document.getElementById('maxLeave').value)  > parseInt(leave_type_array[i][2]))
 				if(parseInt(document.getElementById('maxLeave').value)  > parseInt(leave_type_array[i][2]))
 				{
					alert("You can not take more than"+parseInt(leave_type_array[i][2]) +"leaves");
					return false;
  				}
  			}
  
  		}
   }
   if(document.getElementById("maxLeave").value=="")
   {
   document.getElementById("maxLeave").value="0";
   }
   return true;
 
}
function checkLeaveRestriction(){
var LeavetypeId = document.getElementById('leaveType').value;
var f1=document.getElementById('fromPeriod').value;
var t1=document.getElementById('toPeriod').value;

var frmdate1 =new Date(f1.substring(6),(f1.substring(3,5)-1),f1.substring(0,2));
var todate1=new Date(t1.substring(6),(t1.substring(3,5)-1),t1.substring(0,2));
if(leave_restriction_array.length !=0){
for(i=0;i<leave_restriction_array.length;i++){
if(leave_restriction_array[i][0]==LeavetypeId){
var f2=leave_restriction_array[i][1]
var t2=leave_restriction_array[i][2]
var frmdate2=new Date(f2.substring(6),(f2.substring(3,5)-1),f2.substring(0,2));
var todate2= new Date(t2.substring(6),(t2.substring(3,5)-1),t2.substring(0,2));
if((frmdate2<frmdate1 && frmdate1<todate2) || (frmdate2<todate1 && todate1<todate2))
{
alert('your restriction cannot be in between the present restriction'+f2+' to '+t2);
document.getElementById('fromPeriod').value="";
document.getElementById('toPeriod').value="";
document.getElementById('fromPeriod').focus();
return false;
 }}}}  
 return true;
}
</script></form>
</div>

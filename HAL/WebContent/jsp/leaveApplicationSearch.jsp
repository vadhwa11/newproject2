<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.HrorderlyLeaveApplication"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder">

<form name="leaveApplicationSearch" action="" method="post"><script
	type="text/javascript" language="javascript">
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

</script> <%
Map<String, Object> utilMap = new HashMap<String, Object>();
Map<String, Object> detailsMap = new HashMap<String, Object>();
utilMap = (Map<String,Object>) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
date = (String) utilMap.get("currentDate");
String userName = "";

if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> infoMap = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
map = (Map<String, Object>)request.getAttribute("map");
}
List<HrorderlyLeaveApplication> masLeaveApplicationList = new ArrayList<HrorderlyLeaveApplication>();
List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
if(map.get("masLeaveApplicationList") != null){
	masLeaveApplicationList = (List<HrorderlyLeaveApplication>)map.get("masLeaveApplicationList");
}
if(map.get("masEmployeeList") != null){
	masEmployeeList = (List<MasEmployee>)map.get("masEmployeeList");
}


%>
<h6>Leave Application Search</h6>
<div class="Clear"></div>
<div class="blockTitle">Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>


<label>Entry No</label> <input type="text" name="<%=ENTRY_NO %>"
	value="" MAXLENGTH="20" /> <label> <span>*</span>Service No</label> <input
	type="text" name="<%=SERVICE_NO%>" value="" MAXLENGTH="30" />

<div class="Clear"></div>
</div>
</form>

<div class="Clear"></div>
<input type="button" name="submit" id="addbutton"
	onclick="submitForm('leaveApplicationSearch','/hms/hms/hrOrderly?method=searchleaveApplication');"
	value="Search" class="cmnButton" accesskey="a" />
<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="leaveApplicationUpdate" method="post" action=""><script
	type="text/javascript">
formFields = [
[0, "LeaveAppID", "id"],[1,"<%=ENTRY_NO%>", "entryNo"],[2,"<%=ENTRY_DATE%>","entryDate"],[3,"<%=NAME%>","name"], [4,"<%=SERVICE_NO%>","serviceNo"]];
statusTd = 4;
</script></form>
</div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript" language="javascript">

data_header = new Array();



data_header[0] = new Array;
data_header[0][0] = "Entry No"
data_header[0][1] = "data";
data_header[0][2] = "15%";
data_header[0][3] = "<%=ENTRY_NO%>";

data_header[1] = new Array;
data_header[1][0] = "Entry Date"
data_header[1][1] = "data";
data_header[1][2] = "15%";
data_header[1][3] = "<%=ENTRY_DATE%>";


data_header[2] = new Array;
data_header[2][0] = "Employee Name"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=NAME%>";

data_header[3] = new Array;
data_header[3][0] = "Service No"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%=SERVICE_NO%>";

data_arr = new Array();
<%
Iterator itr=masLeaveApplicationList.iterator();
Iterator itr1=masEmployeeList.iterator();
          int  counter=0;
          while(itr.hasNext() && itr1.hasNext())
           {
        	            
        	  HrorderlyLeaveApplication  masLeaveApplication = (HrorderlyLeaveApplication)itr.next();
        	  MasEmployee masEmployee = (MasEmployee)itr1.next();
        	 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masLeaveApplication.getId()%>
<%if(masLeaveApplication.getEntryNo() != null){%>
data_arr[<%= counter%>][1] = "<%=masLeaveApplication.getEntryNo()%>"
<%}else{%>
data_arr[<%= counter%>][1] = "-"
<%}%>
<% if(masLeaveApplication.getEntryDate()!= null){%>
data_arr[<%= counter%>][2] = "<%= HMSUtil.convertDateToStringWithoutTime(masLeaveApplication.getEntryDate())%>"
<%}else{%>
data_arr[<%= counter%>][2] = "- "
<%}%>
<% if(masLeaveApplication.getEmployee()!=null){%>
data_arr[<%= counter%>][3] = "<%= masLeaveApplication.getEmployee().getFirstName()+""+masLeaveApplication.getEmployee().getMiddleName()+""+masLeaveApplication.getEmployee().getLastName()%>"
<%}else{%>
data_arr[<%= counter%>][3] = "-"
<%}%>
<% if(masLeaveApplication.getEmployee()!=null){%>
data_arr[<%= counter%>][4]="<%=masLeaveApplication.getEmployee().getServiceNo()%>"
<% }else { %>
data_arr[<%= counter%>][4]="-"
<%}%>
<%
counter++;
}
%>

formName = "leaveApplicationUpdate"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}

makeTable(start,end);

</script></div>
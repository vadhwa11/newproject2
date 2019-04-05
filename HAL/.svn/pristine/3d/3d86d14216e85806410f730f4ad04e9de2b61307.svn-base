<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HrorderlyLeaveApplication"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.EmpLeaveBalance"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">

function beforeSave()
{
document.getElementById("refreshCheck").value = true;
return true;
}

function afterSave()
{
alert("Refresh check"+ document.getElementById("refreshCheck").value )
if(document.getElementById("refreshCheck").value)
{
document.getElementById("refreshCheck").value = false;
return true;
}
else
return false;
}

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

function checkd()
{
var EDate = document.leaveAppPending.<%= APPROVED_DATE%>.value;
var SDate = document.leaveAppPending.<%= LEAVE_FROM_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the Approved Date is greater than or equal to the Leave From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1); 
%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	//ArrayList searchMasLeaveApplicationList = (ArrayList)map.get("searchMasLeaveApplicationList");
	//ArrayList searchMasEmployeeList = (ArrayList)map.get("searchMasEmployeeList");
	//ArrayList empLeaveBalanceList = (ArrayList)map.get("empLeaveBalanceList");
	
	
	List<MasEmployee> masEmpList=new ArrayList<MasEmployee>();
	 if(map.get("searchMasEmployeeList")!=null){
	 masEmpList = (ArrayList)map.get("searchMasEmployeeList");
	}
	List<HrorderlyLeaveApplication> searchMasLeaveApplicationList = new ArrayList<HrorderlyLeaveApplication>();
	 if(map.get("searchMasLeaveApplicationList") != null){
		 searchMasLeaveApplicationList= (List<HrorderlyLeaveApplication>)map.get("searchMasLeaveApplicationList");
		}
	 
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
		
	System.out.println("userName==  "+userName);
	String message ="";
	
%>

<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
%>

<div class="Clear"></div>
<div id="contentHolder">
<%if(map.get("message") != null){
 	message = (String)map.get("message");
%> <br />
<h2 style="color: #AC1400; width: 300;"><%=message %></h2>
<div class="Clear"></div>
<%} %>
<h6>Leave Application Pending For Approval</h6>
<div class="Clear"></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchMasLeaveApplicationList.size()>0)
		 {
			String strForCode = (String)map.get("entryDate");
			String strForCodeDescription = (String)map.get("fromPeriod");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <br />
<a href="leaveAppPending?method=showLeaveApplicationPendingJsp">Show
All Records</a> <%
			}
		 }
	if(searchMasLeaveApplicationList.size()==0 && map.get("search") != null)
	  {
    %> <a href="leaveAppPending?method=showLeaveApplicationPendingJsp">Show
All Records</a> <%
	   }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= LEAVE_FROM_DATE %>"],[2,"<%= SERVICE_NO%>"], [3,"<%= NAME %>"],  [4,"<%= RANK%>"], [5,"<%= LEAVE_FROM_DATE %>"],[6,"<%= LEAVE_TO_DATE %>"],[7,"<%=TOTAL_LEAVE_DAYS%>"],[8,"leaveId"] ];
	 statusTd = 8;
	</script></div>

<div class="blockTitle">Leave Details</div>
<div class="blockTitleCurve"></div>

<form name="leaveAppPending" method="post" action="">
<div class="blockFrame">
<div class=Clear></div>
<%if(searchMasLeaveApplicationList != null && searchMasLeaveApplicationList.size()!=0){ %>

<input type="hidden" name="<%= POJO_NAME %>"
	value="HrorderlyLeaveApplication"> <input type="hidden"
	name="<%=POJO_PROPERTY_NAME %>" value="leaveAppPendingName"> <input
	type="hidden" name="title" value="leaveAppPending"> <input
	type="hidden" name="<%=JSP_NAME %>" value="leaveApplicationPending">
<input type="hidden" name="pojoPropertyCode" value="entryDate">

<label class="large"><span>*</span> Service No </label> <input
	id="codeId" type="text" name="<%= SERVICE_NO%>" value=""
	readonly="readOnly" MAXLENGTH="8" tabindex=1 /> <label class="large"><span>*</span>
Name</label> <input type="text" name="<%= NAME %>" value="" readonly="readOnly"
	MAXLENGTH="30" tabindex=1 /> <input type="hidden" name="leaveId"
	id="leaveId" value="" />

<div class=Clear></div>

<label class="large"><span>*</span> Rank </label> <input id="rank"
	type="text" name="<%= RANK%>" value="" readonly="readOnly"
	MAXLENGTH="12" tabindex=1> <!-- <label class="large"><span>*</span> Application Date</label>
<input id="appDate" type="text" name="<%= APPLICATION_DATE %>" value=""  readonly="readOnly" MAXLENGTH="12" tabindex=1 >
 -->
<div class=Clear></div>
<label class="large"><span>*</span>Leave From </label> <input
	id="leaveFromDate" type="text" name="<%= LEAVE_FROM_DATE%>" value=""
	readonly="readOnly" MAXLENGTH="12" tabindex=1> <label
	class="large"><span>*</span> Leave To</label> <input id="leaveToDate"
	type="text" name="<%= LEAVE_TO_DATE %>" value="" readonly="readOnly"
	MAXLENGTH="12" tabindex=1>

<div class=Clear></div>
<label class="large"><span>*</span> Total Leave Days </label> <input
	id="totalLeaveDays" type="text" name="<%= TOTAL_LEAVE_DAYS%>" value=""
	readonly="readOnly" MAXLENGTH="12" tabindex=1> <label
	class="large"><span>*</span> Approved</label> <select id="approved"
	name="approved" validate="Approved,string,yes" tabindex="1">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>

<div class=Clear></div>
<label class="large"><span>*</span> Approved By </label> <select
	id="approvedBy" name="approvedBy" validate="Approved By,string,yes"
	tabindex="1">
	<option value="0">Select</option>
	<%
			for(MasEmployee masEmployee : masEmpList){
			%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName() + masEmployee.getMiddleName() + masEmployee.getLastName()%></option>
	<%}%>
</select> <label class="large"><span>*</span>Approved Date</label> <input
	id="approvedDate" type="text" class="calDate" name="approvedDate"
	value="<%= date %>" MAXLENGTH="12" tabindex=1> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a from date,date,yes"
	onClick="setdate('<%=date %>',document.getElementById('approvedDate'),event)" />
<div class=Clear></div>
<label class="large"><span>*</span> Remarks </label> <input id="remarks"
	type="text" name="remarks" value="" MAXLENGTH="25" tabindex=1>

<div class=Clear></div>

</div>
<div class=Clear></div>

<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div id="edited"></div>
<label>&nbsp;</label> <input type="button" name="add" id="edited"
	value="Submit" class="button"
	onClick="submitForm('leaveAppPending','hrOrderly?method=submitLeavePendingEntry');"
	accesskey="a" tabindex=1 /> <input type="button" name="back" id="back"
	value="Close" class="button" onclick="javascript:history.back()"
	accesskey="b" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" style="visibility: hidden" value="Activate"
	class="button"
	onClick="submitForm('leaveAppPending','leaveAppPending?method=deleteleaveAppPending&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="button" name="edit"
	style="visibility: hidden" id="editbutton" value="Update"
	class="button"
	onClick="submitForm('leaveAppPending','hrOrderly?method=editleaveAppPending','checkd()')"
	accesskey="u" tabindex=1 />


<div class="division"></div>
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <label>Changed
By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="changedBy" value="<%=userName%>" /> <input type="hidden"
	name="changedDate" value="<%=date%>" /> <input type="hidden"
	name="changedTime" value="<%=time%>" /></div>
<%}else{ %>
<h6>There Is No Leave Application</h6>
<div class="clear"></div>
<input type="button" name="back" id="back" value="Close" class="button"
	onclick="javascript:history.back()" accesskey="b" tabindex=1 />
</div>
<%} %>
</form>
<div class=Clear></div>

</div>

<script type="text/javascript">
data_header = new Array();


data_header[0] = new Array;
data_header[0][0] = "Application Date"
data_header[0][1] = "data";
data_header[0][2] = "40%";
data_header[0][3] = "<%= LEAVE_FROM_DATE %>";

data_header[1] = new Array;
data_header[1][0] = "Service No."
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SERVICE_NO %>";

data_header[2] = new Array;
data_header[2][0] = "Name"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= NAME %>";

data_header[3] = new Array;
data_header[3][0] = "Rank"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= RANK %>"

data_header[4] = new Array;
data_header[4][0] = "Leave From date"
data_header[4][1] = "hide";
data_header[4][2] = "40%";
data_header[4][3] = "<%= LEAVE_FROM_DATE %>"

data_header[5] = new Array;
data_header[5][0] = "Leave To Date"
data_header[5][1] = "hide";
data_header[5][2] = "40%";
data_header[5][3] = "<%= LEAVE_TO_DATE%>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "40%";
data_header[6][3] = "<%= TOTAL_LEAVE_DAYS %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "40%";
data_header[7][3] = "<%=CHANGED_DATE %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "0";
data_header[8][3] = "leaveId"


data_arr = new Array();

<%
Iterator itr=searchMasLeaveApplicationList.iterator();

          int  counter=0;
          while(itr.hasNext())
           {
        	            
        	  HrorderlyLeaveApplication  masLeave = (HrorderlyLeaveApplication)itr.next();
        	  
        	              
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%=masLeave.getId() %>

<%if(masLeave.getLeaveFromDate() != null) {%>
data_arr[<%= counter%>][1] = "<%=HMSUtil.convertDateToStringWithoutTime(masLeave.getLeaveFromDate())%>"
<%}else{%>
data_arr[<%= counter%>][1] = "-"
<%}%>


<%if(masLeave.getEmployee().getServiceNo() != null){%>
data_arr[<%= counter%>][2] = "<%= masLeave.getEmployee().getServiceNo()%>"
<%}else{%>
data_arr[<%= counter%>][2] = "-"
<%}%>


<%if(masLeave.getEmployee().getFirstName() != null) {%>
data_arr[<%= counter%>][3] = "<%=masLeave.getEmployee().getFirstName() + " " + masLeave.getEmployee().getLastName() %>"
<%}else{%>
data_arr[<%= counter%>][3] = "-"
<%}%>

<%if(masLeave.getEmployee().getRank() != null) {%>
data_arr[<%= counter%>][4] = "<%= masLeave.getEmployee().getRank().getRankName()%>"
<%}else{%>
data_arr[<%= counter%>][4] = "-"
<%}%>

<%if(masLeave.getLeaveFromDate() != null) {%>
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masLeave.getLeaveFromDate()) %>"
<%}else{%>
data_arr[<%= counter%>][4] = "-"
<%}%>

<%if(masLeave.getDateOfReporting() != null) {%>
data_arr[<%= counter%>][6] = "<%=HMSUtil.convertDateToStringWithoutTime(masLeave.getDateOfReporting()) %>"
<%}else{%>
data_arr[<%= counter%>][6] = "-"
<%}%>

<%if(masLeave.getLeaveTotalDays() != null){%>
data_arr[<%= counter%>][7] = "<%= masLeave.getLeaveTotalDays()%>"
<%}else{%>
data_arr[<%= counter%>][7] = "-"
<%}%>
data_arr[<%= counter%>][8] = "<%= masLeave.getId()%>";

<%
		     counter++;
}
%>
formName = "leaveAppPending"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>


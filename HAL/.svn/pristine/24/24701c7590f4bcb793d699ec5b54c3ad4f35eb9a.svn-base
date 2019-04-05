<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasAgendaPointForWorkServices;"%>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
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
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';

</script>
<script type="text/javascript">
function checkd()
{


var SDate = document.momWorkDetailAgendaSearch1.<%= FROM_DATE%>.value;
var EDate = document.momWorkDetailAgendaSearch1.<%= TO_DATE %>.value;


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
Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	

	
	List<MasAgendaPointForWorkServices> momWorkDetailList = new ArrayList<MasAgendaPointForWorkServices>();
	if (map.get("momWorkDetailList") != null) {
		momWorkDetailList = (List) map.get("momWorkDetailList");
	} else {
		momWorkDetailList = (List) map.get("searchMomAgendaWorkDetailSearchList");
	}
	
	
	List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
	
	if (map.get("departmentList") != null) {
		departmentList = (List) map.get("departmentList");
	}
	
%>

<% 
String message = "";
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>
<div class="Clear"></div>

<div id="contentHolder">
<h6>MOM Details Agenda Search</h6>
<div class="Clear"></div>



<div class="blockFrame">
<form name="momWorkDetailAgendaSearch1" action="" method="post">
<label> From Date </label> <input name="<%=FROM_DATE%>" class="calDate"
	validate="From Date,date,no" value="<%=currentDate %>" MAXLENGTH="12" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="From date,date,no" class="calender"
	onclick="setdate('',document.momWorkDetailAgendaSearch1.<%=FROM_DATE%>,true)" ; />

<label> To Date </label> <input name="<%=TO_DATE%>" class="calDate"
	validate="To Date,date,no" value="<%=currentDate %>" MAXLENGTH="12" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="To Date,date,no" class="calender"
	onclick="setdate('',document.momWorkDetailAgendaSearch1.<%=TO_DATE%>,true)" ; />
<div class="Clear"></div>

<label> Agenda No. </label> <input name="<%= AGENDA_NO%>" value=""
	tabindex=1 maxlength="12" /> <input type="button" name="Search"
	onclick="submitForm('momWorkDetailAgendaSearch1','momWorkDetailSearch?method=searchMomWorkDetailSearch','checkd()');"
	value="Search" class="cmnButton" accesskey="a" /></form>
</div>




<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<div class="Clear"></div>
</div>

<div class="Clear"></div>
<div class="bottom"><LABEL>Changed By</LABEL> <label class="value"><%=userName%></label>
<LABEL>Changed Date</LABEL> <label class="value"><%=currentDate%></label>
<LABEL>Changed Time</LABEL> <label class="value"><%=currentTime%></label>
<INPUT type=hidden value="<%=userName%>" name="<%=CHANGED_BY%>">
<INPUT type=hidden value="<%=currentDate%>" name="<%=CHANGED_DATE %>">
<INPUT type=hidden value="<%=currentTime%>" name="<%=CHANGED_TIME %>">

</div>
</div>
<script type="text/javascript">

	formFields = [[0,"<%= AGENDA_POINT_ID%>"], [1,"<%= AGENDA_NO%>"],[2,"<%= AGENDA_DATE %>"],[3,"<%= AGENDA_TIME %>"],[4,"<%= MOM_DEPARTMENT_ID%>"], [5,"<%= STARTING_TIME %>"],[6,"<%= ENDING_TIME %>"] , [7,"<%= CHANGED_BY%>"], [8,"<%= CHANGED_DATE %>"],[9,"<%=STATUS%>"] ];
	 statusTd = 9;
	

	

data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Sr. No.";
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= AGENDA_POINT_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Agenda No.";
data_header[1][1] = "data";
data_header[1][2] = "20%";
data_header[1][3] = "<%= AGENDA_NO %>";

data_header[2] = new Array;
data_header[2][0] = "Agenda Date";
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%= AGENDA_DATE %>";

data_header[3] = new Array;
data_header[3][0] = "Agenda Time";
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%= AGENDA_TIME %>";

data_header[4] = new Array;
data_header[4][0] = "Department";
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%= MOM_DEPARTMENT_ID %>";

data_header[5] = new Array;
data_header[5][0] = "Starting Time";
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%= STARTING_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Ending Time";
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%= ENDING_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "";
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_BY %>";

data_header[8] = new Array;
data_header[8][0] = "";
data_header[8][1] = "hide";
data_header[8][2] = "0%";
data_header[8][3] = "<%= CHANGED_DATE %>";

data_header[9] = new Array;
data_header[9][0] = "Status"
data_header[9][1] = "hide";
data_header[9][2] = "0%";
data_header[9][3] = "<%=STATUS %>";
<%
Iterator itr=momWorkDetailList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasAgendaPointForWorkServices masMomWorkDetail = (MasAgendaPointForWorkServices)itr.next(); 
			
%>

data_arr[<%= counter%>] = new Array();


data_arr[<%= counter%>][0] = "<%= masMomWorkDetail.getId()%>";
data_arr[<%= counter%>][1] = "<%= masMomWorkDetail.getId()%>";
data_arr[<%= counter%>][2] = "<%= masMomWorkDetail.getAgendaNo()%>";
data_arr[<%= counter%>][3] = "<%= masMomWorkDetail.getAgendaDate()%>";
data_arr[<%= counter%>][4] = "<%= masMomWorkDetail.getAgendaTime()%>";
data_arr[<%= counter%>][5] = "<%= masMomWorkDetail.getDepartmentName()%>";
data_arr[<%= counter%>][6] = "<%= masMomWorkDetail.getStartingTime()%>";
data_arr[<%= counter%>][7] = "<%= masMomWorkDetail.getEndingTime()%>";
data_arr[<%= counter%>][8] = "<%= masMomWorkDetail.getLstChgBy() %>";
<% if(masMomWorkDetail.getMomDate() != null){%>
data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(masMomWorkDetail.getMomDate()) %>";
<%}else{ %>
data_arr[<%= counter%>][9] ="";
<% } %>
<%if(masMomWorkDetail.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}
counter++;
           }
%>
formName = "momWorkDetailAgendaSearch1"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>



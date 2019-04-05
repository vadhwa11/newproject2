<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : agendaPointsUpdateSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 11.05.2009    Name: Vineet Kumar
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasAgendaPointForWorkServices"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="JavaScript">
function checkForm(form)
{
if (document.form.searchField1.value == "") {
alert( "Please enter data" );
document.form.T1.focus();
return false;
}
}

</script>
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
<script type="text/javascript">

	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
</script>

<% 
Map map = new HashMap();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
String message ="";
%>


<% 
if (map.get("message") != null) {
	 message = (String) map.get("message");
	
}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>
<div class="Clear"></div>

<div id="contentHolder">
<h6>Priority For Agenda Points Search</h6>
<div class="Clear"></div>
<form name="agendaPointsUpdateSearch1" action="" method="post">
<div class="blockFrame">
<%
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	List<MasAgendaPointForWorkServices> agendaPointsList = new ArrayList<MasAgendaPointForWorkServices>();
	if (map.get("agendaPointsList") != null) {
		agendaPointsList = (List) map.get("agendaPointsList");
	}
	else
	{
		agendaPointsList = (List) map.get("searchAgendaPointSearchList");
	}
	%> <label>From Date</label> <input id="searchField1" type="text"
	name="<%= FROM_DATE %>" value="<%=currentDate%>" class="calDate"
	tabindex=1 validate="From Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.agendaPointsUpdateSearch1.<%=FROM_DATE%>,event)" ; />

<label>To Date</label> <input type="text" name="<%= TO_DATE %>"
	value="<%=currentDate%>" id="searchField2" class="calDate"
	MAXLENGTH="30" tabindex=1 validate="To Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.agendaPointsUpdateSearch1.<%=TO_DATE%>,event)" ; />
<div class="Clear"></div>
<label>Agenda No.</label> <input id="searchField3" type="text"
	name="<%= AGENDA_NO%>" value="" maxlength="12" tabindex=1 /> <input
	tabindex="1" type="button" name="Search"
	onclick="submitForm('agendaPointsUpdateSearch1','agendaUpdateSearch?method=searchAgendaPointSearch','checkSearchForDate');"
	value="Search" class="cmnButton" accesskey="a" /></div>
<div class="division"></div>
</form>


<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<form name="agendaPointsUpdateSearch" method="post" action="">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script type="text/javascript">
	formFields = [
			[0,"<%= AGENDA_POINT_ID%>"], [1,"<%= AGENDA_NO%>"],[2,"<%= AGENDA_DATE %>"],[3,"<%= AGENDA_TIME %>"],[4,"<%= AGENDA_DEPARTMENT%>"],[5,"<%= STARTING_TIME %>"],[6,"<%= ENDING_TIME %>"], [7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>
<div class="division"></div>
<div class="bottom">
<div id="edited"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=currentTime%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /></div>
</form>
</div>
<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Sr. No.";
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= AGENDA_POINT_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Agenda No";
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
data_header[4][3] = "<%= AGENDA_DEPARTMENT %>";

data_header[5] = new Array;
data_header[5][0] = "Starting Time ";
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%= STARTING_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Ending Time";
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%= ENDING_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "hide";
data_header[7][2] = "0%";
data_header[7][3] = "<%=STATUS %>";
<%
Iterator itr=agendaPointsList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasAgendaPointForWorkServices masAgendaPointsList = (MasAgendaPointForWorkServices)itr.next(); 
        	  
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= masAgendaPointsList.getId()%>";
data_arr[<%= counter%>][1] = "<%= masAgendaPointsList.getId()%>";
data_arr[<%= counter%>][2] = "<%= masAgendaPointsList.getAgendaNo()%>";
<%if(masAgendaPointsList.getAgendaDate() != null){ %>
data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(masAgendaPointsList.getAgendaDate())%>";
<%}else{ %>
data_arr[<%= counter%>][3] = "";
<% }%>
data_arr[<%= counter%>][4] = "<%= masAgendaPointsList.getAgendaTime()%>";
data_arr[<%= counter%>][5] = "<%= masAgendaPointsList.getDepartmentName()%>";
data_arr[<%= counter%>][6] = "<%= masAgendaPointsList.getStartingTime()%>";
data_arr[<%= counter%>][7] = "<%= masAgendaPointsList.getEndingTime()%>";

<%if(masAgendaPointsList.getStatus().equals("a")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}
counter++;
}
%>
formName = "agendaPointsUpdateSearch"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

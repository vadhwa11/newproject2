<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : agendaPointsDetailSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 03.06.2009    Name: Vineet Kumar
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ApMeetingSchedule"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>

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
String date = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");

List<ApMeetingSchedule> apMeetingScheduleMasterList = new ArrayList<ApMeetingSchedule>();

if (map.get("apAgendameetingList") != null) {
	apMeetingScheduleMasterList = (List) map.get("apAgendameetingList");
}
else if (map.get("searchagendaPointsDetailSearchList") != null) {
	apMeetingScheduleMasterList = (List) map.get("searchagendaPointsDetailSearchList");
}
	String message ="";
	Calendar calendar = Calendar.getInstance();
	String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
	String dateCal = String.valueOf(calendar.get(Calendar.DATE));
	int year = calendar.get(calendar.YEAR);
	if (month.length() < 2) {
		month = "0" + month;
	}
	if (dateCal.length() < 2) {
		dateCal = "0" + dateCal;
	}
	%>

</script>
<script type="text/javascript">
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
   </script>
<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>
<DIV class="Clear"></DIV>
<div id="contentHolder">
<h6>Agenda Points Meeting Details</h6>
<div class="Clear"></div>

<div class="blockFrame">
<form name="agendaPointsDetailSearch1" action="" method="post"><label>From
Date</label> <input id="searchField1" type="text" name="<%= FROM_DATE %>"
	value="" tabindex=1 maxlength="5" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.agendaPointsDetailSearch1.<%=FROM_DATE%>,event)" ; />

<label>To Date</label> <input type="text" name="<%= TO_DATE %>"
	id="searchField2" MAXLENGTH="10" tabindex=1 class="calDate" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.agendaPointsDetailSearch1.<%=TO_DATE%>,event)" ; />

<!--  
<label>Batch No</label>
<input maxlength="25" id="searchField3" type="text"	name="<%= BATCH_NO%>" value="" tabindex=1 />

<div class="Clear"></div>
<label> Chest No </label>
<input id="searchField4" type="text" maxlength="25"	name="<%= CHEST_NO%>" value=""  tabindex=1 />


<label>Name</label>
<input id="searchField5" type="text" maxlength="30"	name="<%= NAME%>" value=""  tabindex=1 />
-->
</div>
<div class="division"></div>
<input tabindex="1" type="button" name="Search"
	onclick="submitForm('agendaPointsDetailSearch1','agenda?method=searchAgendaMeetingDetailSearch');"
	value="Search" class="cmnButton" accesskey="a" />
</form>
<div class="division"></div>

<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%       
    if(apMeetingScheduleMasterList!= null &&  apMeetingScheduleMasterList.size()==0)
     {
    %>
<div class="Clear"></div>
<h5><a href="agenda?method=showAgendaMeetingDetailSearchJsp">Show
All Records</a></h5>
<div class="Clear"></div>

<%
     }
   %>


<form name="agendaPointsDetailSearch" method="post" action=""><script
	type="text/javascript">
formFields = [ [0,"<%= COMMON_ID%>"],[1,"<%= PROPOSED_DATE%>"], [2,"<%= MEETING_TITLE%>"],[3,"<%= AGENDA_PLACE %>"],[4,"<%= PROPOSED_TIME_FROM %>"],[5,"<%= PROPOSED_TIME_TO%>"], [6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"] ];
statusTd = 9;
</script>
<div class="Clear"></div>
</form>
</div>
<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><input type="hidden" name="<%=STATUS %>"
	value="" /> <input type="hidden" name="<%= COMMON_ID%>" value="" /> <label>Changed
By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Sr No.";
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= SR_NO %>";


data_header[1] = new Array;
data_header[1][0] = "Proposed Date";
data_header[1][1] = "data";
data_header[1][2] = "20%";
data_header[1][3] = "<%= PROPOSED_DATE %>";

data_header[2] = new Array;
data_header[2][0] = "Meeting Title";
data_header[2][1] = "data";
data_header[2][2] = "20%";
data_header[2][3] = "<%= MEETING_TITLE %>";

data_header[3] = new Array;
data_header[3][0] = "Meeting Venue";
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%= AGENDA_PLACE %>";

data_header[4] = new Array;
data_header[4][0] = "Proposed Time From";
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%= PROPOSED_TIME_FROM %>";

data_header[5] = new Array;
data_header[5][0] = "Proposed Time To";
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%= PROPOSED_TIME_TO %>";

data_header[6] = new Array;
data_header[6][0] = "";
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%= CHANGED_BY %>";

data_header[7] = new Array;
data_header[7][0] = "";
data_header[7][1] = "hide";
data_header[7][2] = "0%";
data_header[7][3] = "<%= CHANGED_DATE %>";

data_header[8] = new Array;
data_header[8][0] = "";
data_header[8][1] = "hide";
data_header[8][2] = "0%";
data_header[8][3] = "<%= CHANGED_TIME %>";

data_header[9] = new Array;
data_header[9][0] = "Status"
data_header[9][1] = "hide";
data_header[9][2] = "0%";
data_header[9][3] = "<%=STATUS %>";
<%
Iterator itr=apMeetingScheduleMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
          {
           ApMeetingSchedule mbAgendaMeetingDetailsMaster = (ApMeetingSchedule)itr.next(); 
        	  
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= mbAgendaMeetingDetailsMaster.getId()%>";
data_arr[<%= counter%>][1] = "<%= mbAgendaMeetingDetailsMaster.getId()%>";
<%
if(mbAgendaMeetingDetailsMaster.getProposedDate() != null && !mbAgendaMeetingDetailsMaster.getProposedDate().equals(""))
{%>
data_arr[<%= counter%>][2] = "<%= HMSUtil.convertDateToStringWithoutTime(mbAgendaMeetingDetailsMaster.getProposedDate())%>"
<%
}
else
{ %>
data_arr[<%= counter%>][2]="";
<%}%>
data_arr[<%= counter%>][3] = "<%= mbAgendaMeetingDetailsMaster.getMeetingTitle()%>";
data_arr[<%= counter%>][4] = "<%= mbAgendaMeetingDetailsMaster.getVenue()%>";
data_arr[<%= counter%>][5] = "<%= mbAgendaMeetingDetailsMaster.getProposedTimeFrom()%>";
data_arr[<%= counter%>][6] = "<%= mbAgendaMeetingDetailsMaster.getProposedTimeTo() %>";
data_arr[<%= counter%>][7] = "<%= mbAgendaMeetingDetailsMaster.getLastChgBy() %>";
data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(mbAgendaMeetingDetailsMaster.getLastChgDate()) %>";
data_arr[<%= counter%>][9] = "<%= mbAgendaMeetingDetailsMaster.getLastChgTime() %>";
<%if(mbAgendaMeetingDetailsMaster.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}
counter++;
}
%>
formName = "agendaPointsDetailSearch"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

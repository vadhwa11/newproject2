<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : agendaMeetingScheduliSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 30.04.2009    Name: Vineet Kumar
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasWorkType"%>
<%@page import="jkt.hms.masters.business.MasWorkCategory"%>
<%@page import="jkt.hms.masters.business.MasMinorWorkDetail"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
Map map = new HashMap();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	
	List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
	   if (map.get("masDepartmentList") != null) {
		   masDepartmentList = (List) map.get("masDepartmentList");
	   }
	   
	   String deptName="";
	   if(session.getAttribute("deptName")!=null){
	      deptName=(String)session.getAttribute("deptName");
	      }
	List<MasMinorWorkDetail> agendaMeetingList = new ArrayList<MasMinorWorkDetail>();
	if (map.get("agendaMeetingList") != null) {
		agendaMeetingList = (List) map.get("agendaMeetingList");
	} else {
		agendaMeetingList = (List) map
				.get("searchAgendaMeetingScheduliSearchList");
	}
	String message ="";
	%>
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
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>
<DIV class="Clear"></DIV>
<div id="contentHolder">
<h6>Minor Work Detail Search</h6>
<div class="Clear"></div>

<div class="blockFrame">
<form name="agendaMeetingScheduliSearch1" action="" method="post">

<label>From Date</label> <input id="searchField1" type="text"
	name="<%= FROM_DATE %>" value="<%=currentDate %>" class="calDate"
	tabindex=1 validate="From Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.agendaMeetingScheduliSearch1.<%=FROM_DATE%>,event)" ; />

<label>To Date</label> <input type="text" name="<%= TO_DATE %>"
	id="searchField2" value="<%=currentDate %>" MAXLENGTH="30" tabindex=1
	class="calDate" validate="To Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.agendaMeetingScheduliSearch1.<%=TO_DATE%>,event)" ; />
<label>Minor Work No.</label> <input id="searchField3" type="text"
	name="<%= MINOR_WORK_NO%>" value="" class="calDate" tabindex=1
	maxlength="12" /> <input type="hidden" id="searchField4"
	name="<%=MINOR_WORK_TYPE_ID %>" tabindex="1""> <label>Proposed
By</label> <select id="searchField5" name="<%= WORK_CATEGORY %>" tabindex="1">
	<option value="<%=deptName%>"><%=deptName%></option>
	<%
      for (MasDepartment masWorkType  :masDepartmentList) {
         if(masWorkType.getStatus().equalsIgnoreCase("y"))
            {
      
   %>

	<option value="<%=masWorkType.getDepartmentName()%>"><%=masWorkType.getDepartmentName()%></option>

	<%
      }else
         {
            continue;
         }
      }
   %>
</select> <label>Department</label> <select id="searchField6"
	name="<%=MINOR_WORK_PROPOSAL_DEPARTMENT %>" tabindex="1"">
	<option value="0">Select</option>
	<%
for (MasDepartment masDepartment : masDepartmentList) {
   if(masDepartment.getStatus().equalsIgnoreCase("y"))
   {
%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%
}else
{
   continue;
}
}
%>
</select> <label>Details Of Work</label> <input id="searchField7" type="text"
	name="<%= MINOR_WORK_DETAIL%>" value="" class="calDate" tabindex=1
	maxlength="12" />


<div class="division"></div>
<input type="button" name="Search"
	onclick="submitForm('agendaMeetingScheduliSearch1','agenda?method=searchAgendaMeetingScheduliSearch','checkSearchForDate');"
	value="Search" class="cmnButton" accesskey="a" tabindex="1" /></form>
</div>
<div class="division"></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%       
    if(agendaMeetingList!= null &&  agendaMeetingList.size()==0)
     {
    %>
<div class="Clear"></div>
<h5><a href="agenda?method=showAgendaMeetingScheduliSearchJsp">Show
All Records</a></h5>
<div class="Clear"></div>

<%
     }
   %>
<form name="agendaMeetingScheduliSearch" method="post" action="">
<script type="text/javascript">
formFields = [ [0,"<%= MINOR_WORK_ID%>"], [1,"<%= MINOR_WORK_NO%>"],[2,"<%= MINOR_WORK_DATE %>"],[3,"<%= MINOR_WORK_TYPE_ID %>"],[4,"<%= MINOR_WORK_ESTIMATED_COST%>"], [5,"<%= MINOR_WORK_PROPOSAL_DEPARTMENT %>"], [6,"<%= MINOR_WORK_DETAIL %>"], [7,"<%= MINOR_WORK_REMARK %>"],  [8,"<%= CHANGED_BY%>"], [9,"<%= CHANGED_DATE %>"],[10,"<%=STATUS%>"] ];
statusTd = 10;
</script>
<div class="Clear"></div>
</form>
</div>
<div class="division"></div>
<!--Bottom labels starts-->
<div id="edited"></div>
<div class="bottom"><input type="hidden" name="<%=STATUS %>"
	value="" /> <input type="hidden" name="<%= COMMON_ID%>" value="" /> <label>Changed
By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=currentTime%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /></div>

</div>

<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Sr. No.";
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= MINOR_WORK_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Minor Work No.";
data_header[1][1] = "data";
data_header[1][2] = "20%";
data_header[1][3] = "<%= MINOR_WORK_NO %>";

data_header[2] = new Array;
data_header[2][0] = "Minor Work Date";
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%= MINOR_WORK_DATE %>";

data_header[3] = new Array;
data_header[3][0] = "Minor Work Type";
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%= MINOR_WORK_TYPE_ID %>";

data_header[4] = new Array;
data_header[4][0] = "Estimated Cost";
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%= MINOR_WORK_ESTIMATED_COST %>";

data_header[5] = new Array;
data_header[5][0] = "Department";
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%= MINOR_WORK_PROPOSAL_DEPARTMENT %>";

data_header[6] = new Array;
data_header[6][0] = "Details of Work";
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%= MINOR_WORK_DETAIL %>";

data_header[7] = new Array;
data_header[7][0] = "Remark";
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%= MINOR_WORK_REMARK %>";

data_header[8] = new Array;
data_header[8][0] = "";
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "<%= CHANGED_BY %>";

data_header[9] = new Array;
data_header[9][0] = "";
data_header[9][1] = "hide";
data_header[9][2] = "0%";
data_header[9][3] = "<%= CHANGED_DATE %>";

data_header[10] = new Array;
data_header[10][0] = "Status"
data_header[10][1] = "hide";
data_header[10][2] = "0%";
data_header[10][3] = "<%=STATUS %>";
<%
Iterator itr=agendaMeetingList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasMinorWorkDetail masMinorWorkDetail = (MasMinorWorkDetail)itr.next(); 
        	  if(masMinorWorkDetail.getStatus().equalsIgnoreCase("y"))
        	  {
        	  
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= masMinorWorkDetail.getId()%>";
data_arr[<%= counter%>][1] = "<%= masMinorWorkDetail.getId()%>";
data_arr[<%= counter%>][2] = "<%= masMinorWorkDetail.getMinorWorkDetailNo()%>";
data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(masMinorWorkDetail.getMinorWorkDetailDate())%>";
data_arr[<%= counter%>][4] = "<%= masMinorWorkDetail.getWorkType().getWorkTypeName()%>";
data_arr[<%= counter%>][5] = "<%=new BigDecimal(masMinorWorkDetail.getMinorWorkDetailEstimatedCost()).intValue()%>";
data_arr[<%= counter%>][6] = "<%= masMinorWorkDetail.getDepartmentName()%>";
data_arr[<%= counter%>][7] = "<%= masMinorWorkDetail.getMinorWorkDetail()%>";
data_arr[<%= counter%>][8] = "<%= masMinorWorkDetail.getMinorWorkDetailRemarks()%>";
data_arr[<%= counter%>][9] = "<%= masMinorWorkDetail.getLastChgBy() %>";
data_arr[<%= counter%>][10] = "<%= HMSUtil.convertDateToStringWithoutTime(masMinorWorkDetail.getLastChgDate()) %>";

<%if(masMinorWorkDetail.getStatus().equals("y")){ %>
data_arr[<%= counter%>][11] = "Active"
<%}else{%>
data_arr[<%= counter%>][11] = "InActive"
<%}
counter++;
}else
{
	continue;
}
           }
%>
formName = "agendaMeetingScheduliSearch"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

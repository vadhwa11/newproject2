<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : minorWorkDetailSearchForCompletionWork.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 06.05.2009    Name: Vineet Kumar
	 * Revision Date:16 July, 2009      Revision By: Vineet
	 * @version 2.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasWorkType"%>
<%@page import="jkt.hms.masters.business.MasWorkCategory"%>
<%@page import="jkt.hms.masters.business.MasMinorWorkDetail"%>
<%@page import="jkt.hms.masters.business.MasDepartmentType"%>
<%@page import="jkt.hms.masters.business.WorkNoDepartment"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>

<script type="text/javascript">
function estimatedDate(){
alert("date1 is here");
var date = document.getElementById("estimatedDate").value
var pdc = document.getElementById("pdc").value
var date1= new Date(date);
if(date1 != "" && pdc != "")
{
var week = date1.getTime() + (24*60*60*1000*pdc*7);
var date2= new Date(week);
document.getElementById("estimate").value = date2;
}else{
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

<h6>Minor Work Details Search For Completion Work</h6>
<div class="Clear"></div>
<div class="blockFrame">
<form name="minorWorkDetailSearchForCompletionWork1" action=""
	method="post">
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String deptName="";
	   if(session.getAttribute("deptName")!=null){
	      deptName=(String)session.getAttribute("deptName");
	      }
	List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();

	if (map.get("workCategoryList") != null) {
		workCategoryList = (List) map.get("workCategoryList");
	}
	ArrayList<WorkNoDepartment> workNoDepartmentList = (ArrayList<WorkNoDepartment>)map.get("workNoDepartmentList");
	   
	List<MasDepartmentType> masDepartmentList = new ArrayList<MasDepartmentType>();
    if (map.get("masDepartmentList") != null) {
       masDepartmentList = (List) map.get("masDepartmentList");
    }
	List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
	if (map.get("workTypeList") != null) {
		worktypeList = (List) map.get("workTypeList");
	}
	List<MasMinorWorkDetail> minorWorkDetailList = new ArrayList<MasMinorWorkDetail>();
	if (map.get("minorWorkDetailList") != null) {
		minorWorkDetailList = (List) map.get("minorWorkDetailList");
	}
	else if(map.get("searchMinorWorkDetailSearchForCompletionWorkList") != null)
	{
		minorWorkDetailList = (List) map.get("searchMinorWorkDetailSearchForCompletionWorkList");
	}
	%> <label>From Date</label> <input id="searchField1" type="text"
	name="<%= FROM_DATE %>" value="" class="calDate" tabindex=1
	validate="From Date,date,no" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',document.minorWorkDetailSearchForCompletionWork1.<%=FROM_DATE%>,event)" ; />

<label>To Date</label> <input type="text" id="searchField2"
	name="<%= TO_DATE %>" class="calDate" MAXLENGTH="30" tabindex=1
	validate="To Date,date,no" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',document.minorWorkDetailSearchForCompletionWork1.<%=TO_DATE%>,event)" ; />



<label>Minor Work No.</label> <input id="searchField3" type="text"
	name="<%= MINOR_WORK_NO%>" value="" tabindex=1 maxlength="12" />

<div class="Clear"></div>

<label> Work Type </label> <select id="searchField4"
	name="<%=MINOR_WORK_TYPE_ID %>" tabindex="1">
	<option value="0">Select</option>
	<%
      for (MasWorkType masWorkType : worktypeList) {if(masWorkType.getStatus().equalsIgnoreCase("y") && masWorkType.getWorkCategory().getWorkCategoryName().equalsIgnoreCase("Minor Work"))
  	{
    	  %>
	<option value="<%=masWorkType.getId()%>"><%=masWorkType.getWorkTypeName()%></option>
	<%
    	  }else
    	  {
    	  	continue;
    	  }
    	  }
    	  %>
</select> <input id="searchField5" type="hidden" name="<%=WORK_CATEGORY %>">
</input> <label>Department</label> <select id="searchField6"
	name="<%=MINOR_WORK_PROPOSAL_DEPARTMENT %>" tabindex="1"">
	<option value="0">Select</option>
	<%
for (MasDepartmentType masDepartment : masDepartmentList) {
   if(masDepartment.getStatus().equalsIgnoreCase("y"))
   {
%>
	<option value="<%=masDepartment.getDepartmentTypeName()%>"><%=masDepartment.getDepartmentTypeName()%></option>
	<%
}else
{
   continue;
}
}
%>
</select> <label>Work Details</label> <input id="searchField7" type="text"
	name="<%= MINOR_WORK_DETAIL%>" value="" tabindex=1 maxlength="12" />
<div class="Clear"></div>
<input type="button" tabindex="1" name="Search"
	onclick="submitForm('minorWorkDetailSearchForCompletionWork1','minorWorkDetailSearchForCompletionWork?method=searchMinorWorkDetailSearchForCompletionWork','checkSearchForWorkService','checkSearchForDate');"
	value="Search" class="cmnButton" accesskey="a" /></form>
</div>
<div class="division"></div>
<div class="Clear"></div>

<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
   
      if(minorWorkDetailList == null || minorWorkDetailList.size() <= 0)
       { %>
<div class="Clear"></div>
<h5><a
	href="minorWorkDetailSearchForCompletionWork?method=showMinorWorkDetailSearchForCompletionWorkJsp">Show
All Records</a></h5>
<div class="Clear"></div>
<%         
       }%>
<form name="minorWorkDetailSearchForCompletionWork" method="post"
	action=""><script type="text/javascript">
   formFields = [ [0,"<%= MINOR_WORK_ID%>"], [1,"<%= MINOR_WORK_NO%>"],[2,"<%= MINOR_WORK_DATE %>"],[3,"<%= MINOR_WORK_TYPE_ID %>"],[4,"<%= MINOR_WORK_ESTIMATED_COST%>"], [5,"<%= MINOR_WORK_PROPOSAL_DEPARTMENT %>"], [6,"<%= MINOR_WORK_DETAIL %>"], [7,"<%= MINOR_WORK_REMARK %>"],  [8,"<%= CHANGED_BY%>"], [9,"<%= CHANGED_DATE %>"],[10,"<%=STATUS%>"] ];
statusTd = 10;
   </script></form>
</div>
<div class="division"></div>
<div id="edited"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=currentDate%></label>
<label>Changed Time</label> <label class="value"><%=currentTime%></label>

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <input type="hidden"
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
Iterator itr=minorWorkDetailList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
           MasMinorWorkDetail masMinorWorkDetail = (MasMinorWorkDetail)itr.next(); 
           if(masMinorWorkDetail.getStatus().equalsIgnoreCase("a"))
           {
           
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= masMinorWorkDetail.getId()%>";
data_arr[<%= counter%>][1] = "<%= masMinorWorkDetail.getId()%>";
data_arr[<%= counter%>][2] = "<%= masMinorWorkDetail.getMinorWorkDetailNo()%>";
data_arr[<%= counter%>][3] = "<%= masMinorWorkDetail.getMinorWorkDetailDate()%>";
data_arr[<%= counter%>][4] = "<%= masMinorWorkDetail.getWorkType().getWorkTypeName()%>";
data_arr[<%= counter%>][5] = "<%= masMinorWorkDetail.getMinorWorkDetailEstimatedCost()%>";
<%
        StringBuffer dept_ids = new StringBuffer();
        StringBuffer dept_names = new StringBuffer();
        for (Iterator<WorkNoDepartment> iterator = workNoDepartmentList.iterator();  iterator.hasNext();)
        {
           WorkNoDepartment workNoDepartment = (WorkNoDepartment) iterator.next();
           if (masMinorWorkDetail.getId() == workNoDepartment.getWorkNoType().getId())
           {
                 if (dept_ids.toString().length() > 0)
              {
                  dept_ids.append(",");
                  dept_ids.append(workNoDepartment.getDepartment().getId());
              }
              else
              {
                 dept_ids.append(workNoDepartment.getDepartment().getId());
              }
              
              if (dept_names.toString().length() > 0)
              {
                 dept_names.append(",");
                 dept_names.append(workNoDepartment.getDepartment().getDepartmentTypeName());
              }
              else
              {
                 dept_names.append(workNoDepartment.getDepartment().getDepartmentTypeName());
              }
           }
         }
    %>
data_arr[<%= counter%>][6] = "<%= dept_names.toString()%>";
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
}
           else{              
              continue;
           }
           }
%>
formName = "minorWorkDetailSearchForCompletionWork"
start = 0
if(data_arr.length < rowsPerPage)
   end = data_arr.length;
else
   end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');    
</script>
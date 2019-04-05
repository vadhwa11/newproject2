<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : minorWorkDetailSearch.jsp 
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
<%@page import="jkt.hms.masters.business.MasMajorWorkDetail"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasDepartmentType"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

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

	List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();

	if (map.get("workCategoryList") != null) {
		workCategoryList = (List) map.get("workCategoryList");
	}

	List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
	if (map.get("workTypeList") != null) {
		worktypeList = (List) map.get("workTypeList");
	}
	List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
    if (map.get("departmentTypeList") != null) {
       masDepartmentList = (List) map.get("departmentTypeList");
    }
    
    String deptName="";
    if(session.getAttribute("deptName")!=null){
       deptName=(String)session.getAttribute("deptName");
       }
	List<MasMajorWorkDetail> majorWorkDetailList = new ArrayList<MasMajorWorkDetail>();
	if (map.get("majorWorkDetailList") != null) {
		majorWorkDetailList = (List) map.get("majorWorkDetailList");
	} else {
		majorWorkDetailList = (List) map
				.get("searchMajorWorkDetailSearchList");
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
<h6>Major Work Detail Search</h6>
<div class="Clear"></div>
<form name="majorWorkDetailSearch1" action="" method="post"><script
	type="text/javascript">
serverdate = '<%=dateCal+"/"+month+"/"+year%>';
function checkd()
{
var SDate = document.majorWorkDetailSearch1.<%= FROM_DATE%>.value;
var EDate = document.majorWorkDetailSearch1.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();

return false;
}
return true
}
</script> <script type="text/javascript">

function checkEdReturnField()
{

  var fromDate1=document.getElementById("fromDate").value;
  var toDate1=document.getElementById("toDate").value;
  var majorWorkNo1=document.getElementById("majorWorkNo").value;
  var workType1=document.getElementById("workType").value;
  var workCategory1=document.getElementById("workCategory").value;
  
  if((fromDate1!="" && fromDate1!= "")||(majorWorkNo1!="" && workType1!="") && (workCategory1!=""))
 	{
  		
  		return true;
  	}
  else
  {
  		alert("Enter Data for mandatory fields");
  		return false;
  }
}


</script>

<div class="blockFrame">

<div class="Clear"></div>
<label>From Date</label> <input id="searchField1" type="text"
	name="<%= FROM_DATE%>" value="<%=currentDate %>" class="calDate"
	tabindex=1 validate="From Date,date,no" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.majorWorkDetailSearch1.<%=FROM_DATE%>,event)" ; />

<label>To Date</label> <input id="searchField2"
	validate="To Date,date,no" type="text" option value="<%=currentDate %>"
	name="<%= TO_DATE %>" class="calDate" MAXLENGTH="30" tabindex=1 /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.majorWorkDetailSearch1.<%=TO_DATE%>,event)" ; />

<label>Major Work No.</label> <input id="searchField3" type="text"
	name="<%= MAJOR_WORK_NO%>" value="" tabindex=1 maxlength="12" />

<div class="Clear"></div>

<label> Work Type </label> <select id="searchField4"
	name="<%=MAJOR_WORK_TYPE_ID %>" tabindex="1">
	<option value="0">Select</option>
	<%
		for (MasWorkType masWorkType : worktypeList) {if(masWorkType.getStatus().equalsIgnoreCase("y") && masWorkType.getWorkCategory().getWorkCategoryName().equalsIgnoreCase("Major Works"))
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
</select> <label>Proposed By</label> <select id="searchField5"
	name="<%= WORK_CATEGORY %>" tabindex="1">
	<option value="<%=deptName%>"><%=deptName%></option>
	<option value="0">Select</option>
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
</select>

<div class="Clear"></div>
<label>Department</label> <select id="searchField6"
	name="<%=MAJOR_WORK_DEPARTMENT %>" tabindex="1"">
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
</select> <label>Work Details</label> <input id="searchField7" type="text"
	name="<%= MAJOR_WORK_DETAIL%>" value="" tabindex=1 maxlength="12" /></div>
<div class="division"></div>
<input type="button" name="Search"
	onclick="submitForm('majorWorkDetailSearch1','majorWorkDetailSearch?method=searchMajorWorkDetailSearch','checkSearchForWorkService','checkSearchForDate');"
	value="Search" class="cmnButton" accesskey="a" /></form>

<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
      if(majorWorkDetailList == null || majorWorkDetailList.size() <= 0)
       { %>
<div class="Clear"></div>
<h5><a
	href="majorWorkDetailSearch?method=searchMajorWorkDetailSearch">Show
All Records</a></h5>
<div class="Clear"></div>
<%         
       }%> <script type="text/javascript">

   formFields = [[0,"<%= MAJOR_WORK_ID%>"], [1,"<%= MAJOR_WORK_NO%>"],[2,"<%= MAJOR_WORK_DATE %>"],[3,"<%= MAJOR_WORK_TYPE_ID %>"],[4,"<%= ESTIMATED_COST%>"], [5,"<%= MAJOR_WORK_DETAIL_UPDATE_PDC %>"],[6,"<%= MAJOR_WORK_REMARK %>"] , [7,"<%= CHANGED_BY%>"], [8,"<%= CHANGED_DATE %>"],[9,"<%=STATUS%>"] ];
    statusTd = 9;
  </script></div>
<div class="division"></div>
<div id="edited"></div>
<div class="bottom"><LABEL>Changed By</LABEL> <label class="value"><%=userName%></label>
<LABEL>Changed Date</LABEL> <label class="value"><%=currentDate%></label>
<LABEL>Changed Time</LABEL> <label class="value"><%=currentTime%></label>
<INPUT type=hidden value="<%=userName%>" name="<%=CHANGED_BY%>">
<INPUT type=hidden value="<%=currentDate%>" name="<%=CHANGED_DATE %>">
<INPUT type=hidden value="<%=currentTime%>" name="<%=CHANGED_TIME %>">
</div>
</div>
<script type="text/javascript">

	
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Sr. No.";
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= MAJOR_WORK_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Major Work No.";
data_header[1][1] = "data";
data_header[1][2] = "20%";
data_header[1][3] = "<%= MAJOR_WORK_NO %>";

data_header[2] = new Array;
data_header[2][0] = "Major Work Date";
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%= MAJOR_WORK_DATE %>";

data_header[3] = new Array;
data_header[3][0] = "Major Work Type";
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%= MAJOR_WORK_TYPE_ID %>";

data_header[4] = new Array;
data_header[4][0] = "Estimated Cost";
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%= ESTIMATED_COST %>";

data_header[5] = new Array;
data_header[5][0] = "PDC";
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%= MAJOR_WORK_DETAIL_UPDATE_PDC %>";

data_header[6] = new Array;
data_header[6][0] = "Remark";
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%= MAJOR_WORK_REMARK %>";

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
Iterator itr=majorWorkDetailList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasMajorWorkDetail masMajorWorkDetail = (MasMajorWorkDetail)itr.next(); 
			
%>

data_arr[<%= counter%>] = new Array();


data_arr[<%= counter%>][0] = "<%= masMajorWorkDetail.getId()%>";
data_arr[<%= counter%>][1] = "<%= masMajorWorkDetail.getId()%>";
data_arr[<%= counter%>][2] = "<%= masMajorWorkDetail.getMajorWorkDetailNo()%>";
data_arr[<%= counter%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetail.getMajorWorkDetailDate())%>";
data_arr[<%= counter%>][4] = "<%= masMajorWorkDetail.getWorkType().getWorkTypeName()%>";

<% if(masMajorWorkDetail.getMajorWorkEstimatedCost() != null && !masMajorWorkDetail.getMajorWorkEstimatedCost().equalsIgnoreCase("")) {%>
data_arr[<%= counter%>][5] = "<%= masMajorWorkDetail.getMajorWorkEstimatedCost()%>";
<%} else{%>
data_arr[<%= counter%>][5] = " ";
<%} %>

<% if(masMajorWorkDetail.getMajorWorkPdc() != null) {%>
data_arr[<%= counter%>][6] = "<%=HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetail.getMajorWorkPdc())%>";
<%} else{%>
data_arr[<%= counter%>][6] = " ";
<%} %>
data_arr[<%= counter%>][7] = "<%= masMajorWorkDetail.getMajorWorkDetailRemarks()%>";
data_arr[<%= counter%>][8] = "<%= masMajorWorkDetail.getLastChangedBy() %>";
data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(masMajorWorkDetail.getLastChangedDate()) %>";

<%if(masMajorWorkDetail.getStatusOfRecord().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}
counter++;
           }
%>
formName = "majorWorkDetailSearch1"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>


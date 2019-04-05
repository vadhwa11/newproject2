<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasPorProgram"%>
<%@page import="java.util.GregorianCalendar"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		String time1=String.valueOf(calendar.getTime());
		int year=calendar.get(calendar.YEAR);
		if(month1.length()<2){
			month1="0"+month1;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
		
		int dutyId=0;
			
	%>
		serverdate = '<%=date1+"/"+month1+"/"+year%>'
</script>

<script type="text/javascript">
function check(){
var SDate = document.porProgram.<%= FROM_DATE%>.value;
var EDate = document.porProgram.<%= TO_DATE %>.value;

if (SDate == '' || EDate == '') {
alert("Plesae enter both....");
return false;
}

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
	Map<String ,Object> map = new HashMap<String ,Object>();
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String ,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList<MasPorProgram> searchPorProgramList = (ArrayList<MasPorProgram>)map.get("searchPorProgramList");
	String userName = "";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
	String message="";
	%>
<div id="contentHolder">
<div class="Clear"></div>
<%if(map.get("message") != null){
	 	message = (String)map.get("message");
%>

<h2><%=message %></h2>

<%} %>
<div class="Clear"></div>
<h6>POR Program Master</h6>
<div class="Clear"></div>
<div class="header">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="blockframe"><label>POR Number</label> <input
	type="text" id="searchField" name="<%=SEARCH_FIELD%>" value=""
	validate="Por Number,string,no" width="10px" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'hrOrderly?method=searchPorProgram')" />
<label> From Date</label> <input type="text" class="calDate"
	id="fromDateField" name="fromDateField" value="<%=date %>"
	readonly="readonly" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=date%>',document.search.fromDateField,event);" />

<label> To Date</label> <input type="text" class="calDate"
	id="toDateField" name="toDateField" value="<%=date %>"
	readonly="readonly" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=date%>',document.search.toDateField,event);" /> <input
	type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','hrOrderly?method=searchPorProgram')"
	tabindex=1 /></div>
</form>
</div>
</div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchPorProgramList.size()>0)
		 {
			String strForCode = (String)map.get("poolCategoryCode");
			String strForCodeDescription = (String)map.get("poolCategoryName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <a href="hrOrderly?method=showPorJsp">Show All Records</a> <%
			}
		 }
	 if(searchPorProgramList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="hrOrderly?method=showPorJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= FROM_DATE%>"], [2,"<%= TO_DATE %>"],[3,"<%= POR_NUMBER%>"], [4,"<%= REMARKS %>"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
	</script></div>
<div class="Clear"></div>
<form name="porProgram" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasPorProgram"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="PoolCategoryName">
<input type="hidden" name="title" value="PoolCategory"> <input
	type="hidden" name="<%=JSP_NAME %>" value="poolCategory"> <input
	type="hidden" name="pojoPropertyCode" value="PoolCategoryCode">

<div class="division"></div>
<div class="blockframe"><label><span>*</span>From Date</label> <input
	type="text" class="calDate" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=date %>" readonly="readonly" MAXLENGTH="30" tabindex="1"
	validate="From Date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	style="padding-left: 5px;" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.porProgram.<%=FROM_DATE%>,event)" />

<label><span>*</span>To Date</label> <input type="text" class="calDate"
	id="ToDateId" name="<%=TO_DATE %>" value="<%=date %>"
	readonly="readonly" MAXLENGTH="30" tabindex="1"
	validate="To Date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=date %>',document.porProgram.<%=TO_DATE%>,event)" />

<div class="Clear"></div>
<label><span>*</span>POR Number</label> <input type="text"
	name="<%=POR_NUMBER %>" id="<%=POR_NUMBER %>" value="" maxlength="10"
	validate="Por Program,string,yes"> <label>Remarks</label> <input
	type="text" name="<%=REMARKS %>" id="<%=REMARKS %>" value=""
	maxlength="25"></div>

<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="division"></div>

<div class="bottom">
<div class="Clear"></div>



<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('porProgram','hrOrderly?method=addPorProgram','check()');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('porProgram','hrOrderly?method=editPorProgram')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('porProgram','hrOrderly?method=deletePorProgram&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="division"></div>
<div id="edited"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>
</div>
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "From Date"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%=FROM_DATE%>"

data_header[1] = new Array;
data_header[1][0] = "To Date"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%=TO_DATE %>";

data_header[2] = new Array;
data_header[2][0] = "POR Number"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%=POR_NUMBER%>"

data_header[3] = new Array;
data_header[3][0] = "Remarks"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%=REMARKS %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_DATE %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator<MasPorProgram> itr=searchPorProgramList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasPorProgram  masPorProgram = (MasPorProgram)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masPorProgram.getId()%>
data_arr[<%= counter%>][1] = "<%=HMSUtil.convertDateToStringWithoutTime(masPorProgram.getFromDate())%>"
data_arr[<%= counter%>][2] = "<%= HMSUtil.convertDateToStringWithoutTime(masPorProgram.getToDate())%>"
data_arr[<%= counter%>][3] = "<%= masPorProgram.getPorNumber()%>"
data_arr[<%= counter%>][4] = "<%= masPorProgram.getRemarks()%>"

data_arr[<%= counter%>][5] = "<%= masPorProgram.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masPorProgram.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= masPorProgram.getLastChgTime() %>"
<%if(masPorProgram.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "porProgram"


start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

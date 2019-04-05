<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasBook"%>
<%@page import="jkt.hms.masters.business.LibBookIssueDetail"%>
<%@page import="jkt.hms.masters.business.LibBookIssueHeader"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript">
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
	</script>
<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("issueDate").value;
	errorMsg=errorMsg+document.getElementById("serviceNo").value;
	errorMsg=errorMsg+document.getElementById("issueNo").value;
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
		 List<LibBookIssueHeader> bookHdList = new ArrayList<LibBookIssueHeader>();
		int bookIssueHdId=0;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("bookHdList") != null){
			bookHdList= (List<LibBookIssueHeader>)patientMap.get("bookHdList");
		}
		if(map.get("bookIssueHdId") != null){
			bookIssueHdId=(Integer)map.get("bookIssueHdId");
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		if (map.get("message") != null) {
	             message = (String) map.get("message");
	      }
			if(!message.equalsIgnoreCase("")){
				%>
<h2><%=message %></h2>
<%} %>
<div id="contentHolder">
<form name="searchBookIssue" action="" method="post">
<h6>Issued Book Search</h6>
<div class="Clear"></div>
<div class="blockFrame"><label>Issue No.</label> 
<input type="text" name="<%=ISSUE_NO %>" value="" class="textbox_size20" MAXLENGTH="50" id="issueNo" /> 

<label>Service No.</label> 
<input type="text" name="<%=SERVICE_NO %>" value="" class="textbox_size20" MAXLENGTH="20" id="serviceNo" /> 

<label>Issue Date</label> <input type="text" id="issueDate" name="<%=ISSUE_DATE %>" value="" class="calDate" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onClick="setdate('<%=currentDate %>',document.searchBookIssue.<%=ISSUE_DATE%>,event)" />
<div class="Clear"></div>
</div>

<input type="button" name="search" id="addbutton"
	onclick="if(checkBlankSearch()){submitForm('searchBookIssue','/hms/hms/lib?method=searchUpdateBookIssueJsp');}"
	value="Search" class="cmnButton" accesskey="a" />
<div class="Clear"></div>
</form>
<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="bookIssue" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "bookIssueHdId", "id"], [1,"issueNo"], [2,"serviceNo"],[3,"Name"], [4,"issueDate"]];
	 statusTd = 4;
	</script>
	
	</form>

</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Issue No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "issueNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "Service No"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "serviceNo";
	
	data_header[2] = new Array;
	data_header[2][0] = "Name"
	data_header[2][1] = "data";
	data_header[2][2] = "30%";
	data_header[2][3] = "empName";
	
	
	data_header[3] = new Array;
	data_header[3][0] = "Issue Date"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "issueDate";

	data_arr = new Array();	
	<%
		
	    int  counter=0;
		if (bookHdList != null && bookHdList.size() > 0) { %>
	
	<% 	for(LibBookIssueHeader bookIssueHeader : bookHdList){
	
	%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= bookIssueHeader.getId()%>
			data_arr[<%= counter%>][1] = "<%=bookIssueHeader.getIssueNo()%>"
			data_arr[<%= counter%>][2] = "<%=bookIssueHeader.getEmployee().getServiceNo()%>"
			<%if(bookIssueHeader.getEmployee() != null){%>
			data_arr[<%= counter%>][3] = "<%=bookIssueHeader.getEmployee().getFirstName()%>"+" "+"<%=bookIssueHeader.getEmployee().getMiddleName()%>"+" "+"<%=bookIssueHeader.getEmployee().getLastName()%>"
			<%}else{%>
				data_arr[<%= counter%>][3] = "-"
			<%}%>
			<%if(bookIssueHeader.getIssueDate() != null){%>
			data_arr[<%= counter%>][4] = "<%=HMSUtil.convertDateToStringWithoutTime(bookIssueHeader.getIssueDate())%>"
			<%}else{%>
				data_arr[<%= counter%>][4] = "-"
			<%}%>
		<%		     counter++;
			}
			}
		%>
		 formName = "bookIssue"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.LibBookReturnHd"%>
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
	errorMsg=errorMsg+document.getElementById("returnNo").value;
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
		 List<LibBookReturnHd> bookHdList = new ArrayList<LibBookReturnHd>();
		int bookIssueHdId=0;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("bookHdList") != null){
			bookHdList= (List<LibBookReturnHd>)patientMap.get("bookHdList");
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
<form name="searchReturn" action="" method="post">
<h6>Returned Book Search</h6>
<div class="Clear"></div>
<div class="blockFrame"><label>Return No.</label> <input
	type="text" name="<%=RETURN_NO %>" value="" class="textbox_size20"
	MAXLENGTH="50" id="returnNo" /> <label>Service No.</label> <input
	type="text" name="<%=SERVICE_NO %>" value="" class="textbox_size20"
	MAXLENGTH="20" id="serviceNo" /> <label>Issue Date</label> <input
	type="text" id="issueDate" name="<%=ISSUE_DATE %>" value=""
	class="calDate" MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.searchReturn.<%=ISSUE_DATE%>,event)" />
<div class="Clear"></div>

<div class="Clear"></div>
</div>
<div class="Clear"></div>
<input type="button" name="search" id="addbutton"
	onclick="if(checkBlankSearch()){submitForm('searchReturn','/hms/hms/lib?method=searchUpdateBookReturnJsp');}"
	value="Search" class="cmnButton" accesskey="a" /></form>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="searchBookReturn" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "bookReturnHdId", "id"], [1,"returnNo"], [2,"serviceNo"],[3,"Name"], [4,"returnDate"]];
	 statusTd = 4;
	</script></form>

</div>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Return No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "returnNo"
	
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
	data_header[3][0] = "Return Date"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "returnDate";

	data_arr = new Array();	
	<%
		
	    int  counter=0;
		if (bookHdList != null && bookHdList.size() > 0) { %>
	
	<% 	for(LibBookReturnHd bookReturnHeader : bookHdList){
	
	%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= bookReturnHeader.getId()%>
			data_arr[<%= counter%>][1] = "<%=bookReturnHeader.getReturnNo()%>"
			data_arr[<%= counter%>][2] = "<%=bookReturnHeader.getIssueHd().getEmployee().getServiceNo()%>"
			<%if(bookReturnHeader.getIssueHd().getEmployee() != null){%>
			data_arr[<%= counter%>][3] = "<%=bookReturnHeader.getIssueHd().getEmployee().getFirstName()%>"+" "+"<%=bookReturnHeader.getIssueHd().getEmployee().getMiddleName()%>"+" "+"<%=bookReturnHeader.getIssueHd().getEmployee().getLastName()%>"
			<%}else{%>
				data_arr[<%= counter%>][3] = "-"
			<%}%>
			<%if(bookReturnHeader.getReturnDate() != null){%>
			data_arr[<%= counter%>][4] = "<%=HMSUtil.convertDateToStringWithoutTime(bookReturnHeader.getReturnDate() )%>"
			<%}else{%>
				data_arr[<%= counter%>][4] = "-"
			<%}%>
		<%		     counter++;
			}
			}
		%>
		 formName = "searchBookReturn"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>
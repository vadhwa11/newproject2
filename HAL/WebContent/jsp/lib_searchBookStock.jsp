<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasBook"%>
<%@page import="jkt.hms.masters.business.LibBookStockTakingHd"%>
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
	errorMsg=errorMsg+document.getElementById("stockNo").value;
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
		 List<LibBookStockTakingHd> bookHdList = new ArrayList<LibBookStockTakingHd>();
		int bookStockHdId=0;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("bookHdList") != null){
			bookHdList= (List<LibBookStockTakingHd>)patientMap.get("bookHdList");
		}
		if(map.get("bookStockHdId") != null){
			bookStockHdId=(Integer)map.get("bookStockHdId");
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
<form name="searchBookStock" action="" method="post">
<h6>Book Stock Taking</h6>
<div class="Clear"></div>
<div class="blockFrame"><label>StockTaking No.</label> <input
	type="text" name="<%=STOCK_NO %>" value="" class="textbox_size20"
	MAXLENGTH="50" id="stockNo" /> <label> Date</label> <input type="text"
	id="issueDate" name="<%=DATE %>" value="" class="calDate"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.searchBookStock.<%=ISSUE_DATE%>,event)" />


<div class="Clear"></div>
</div>

<input type="button" name="search" id="addbutton"
	onclick="if(checkBlankSearch()){submitForm('searchBookStock','/hms/hms/lib?method=searchUpdateBookStock');}"
	value="Search" class="cmnButton" accesskey="a" />
<div class="Clear"></div>
</form>


<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="bookStock" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "bookStockHdId", "id"], [1,"stockNo"], [2,"date"]];
	 statusTd = 2;
	</script></form>

</div>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Stock Taking No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "stockNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "Date"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "date";

	data_arr = new Array();	
	<%
		
	    int  counter=0;
		if (bookHdList != null && bookHdList.size() > 0) { %>
	
	<% 	for(LibBookStockTakingHd bookStockHeader : bookHdList){
	
	%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= bookStockHeader.getId()%>
			data_arr[<%= counter%>][1] = "<%=bookStockHeader.getStockTakingNo()%>"
			<%if(bookStockHeader.getSockTakinDate() != null){%>
			data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(bookStockHeader.getSockTakinDate())%>"
			<%}else{%>
				data_arr[<%= counter%>][2] = "-"
			<%}%>
		<%		     counter++;
			}
			}
		%>
		 formName = "bookStock"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>
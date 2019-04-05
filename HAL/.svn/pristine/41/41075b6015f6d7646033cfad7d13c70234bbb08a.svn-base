<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.LibJournalReceiptEntryDt"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder">
<form name="smqSearch" action="" method="post"><script
	type="text/javascript" language="javascript">
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
</script> <%
Map<String, Object> utilMap = new HashMap<String, Object>();
Map<String, Object> detailsMap = new HashMap<String, Object>();
utilMap = (Map<String,Object>) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
date = (String) utilMap.get("currentDate");
String userName = "";
if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}
int deptId =0;
if(session.getAttribute("deptId") != null){
	deptId = (Integer)session.getAttribute("deptId");
}
int hospitalId =0;
if(session.getAttribute("hospitalId") != null){
	hospitalId = (Integer)session.getAttribute("hospitalId");
}
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
map = (Map<String, Object>)request.getAttribute("map");
}

if(map.get("detailsMap") !=null){
detailsMap=(Map<String, Object>)map.get("detailsMap");
}

Map<String, Object> patientMap = new HashMap<String, Object>();
List<LibJournalReceiptEntryDt> searchLibJournalList = new ArrayList<LibJournalReceiptEntryDt>();
if(map.get("patientMap") != null){
	patientMap= (Map<String, Object>)map.get("patientMap");
	}
if(patientMap.get("searchLibJournalList") != null){
	searchLibJournalList= (List<LibJournalReceiptEntryDt>)patientMap.get("searchLibJournalList");
	}
%>
<h6>Journal Receipt Entry</h6>
<div class="Clear"></div>
<div class="blockTitle">Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>


<label>Receipt No</label> <input type="text" name="<%=RECEIPT_NO %>"
	value="" MAXLENGTH="20"
	onkeypress="return submitenter(this,event,'lib?method=searchJournalReceiptEntry')" />
<label>Issue No</label></label> <input type="text" name="<%=ISSUE_NO %>"
	value="" MAXLENGTH="20"
	onkeypress="return submitenter(this,event,'lib?method=searchJournalReceiptEntry')" />
<div class="Clear"></div>
<label>Book Name</label> <input type="text" name="<%=BOOK_NAME %>"
	value="" MAXLENGTH="30"
	onkeypress="return submitenter(this,event,'lib?method=searchJournalReceiptEntry')" />

<label>Acc No</label> <input type="text" name="<%=BOOK_ACC_NO %>"
	value="" MAXLENGTH="30"
	onkeypress="return submitenter(this,event,'lib?method=searchJournalReceiptEntry')" />


<div class="Clear"></div>
</div>
</form>

<div class="Clear"></div>
<input type="button" name="submit" id="addbutton"
	onclick="submitForm('smqSearch','/hms/hms/lib?method=searchJournalReceiptEntry');"
	value="Search" class="cmnButton" accesskey="a" />

<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="journalReceipt" method="post" action=""><script
	type="text/javascript">
formFields = [
[0, "receiptId", "id"],[1,"<%=RECEIPT_NO%>"],[2,"<%=RECEIPT_DATE%>"],[3,"<%=ISSUE_NO%>"], [4,"<%=BOOK_NAME%>"],[5,"<%=BOOK_ACC_NO%>"]];
statusTd = 5;
</script></form>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript" language="javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Receipt No"
data_header[0][1] = "data";
data_header[0][2] = "7%";
data_header[0][3] = "<%=RECEIPT_NO%>";

data_header[1] = new Array;
data_header[1][0] = "Receipt Date"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "<%=RECEIPT_DATE%>";

data_header[2] = new Array;
data_header[2][0] = "Issue No"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=ISSUE_NO%>";

data_header[3] = new Array;
data_header[3][0] = "Book Name"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=BOOK_NAME%>";


data_header[4] = new Array;
data_header[4][0] = "Acc No"
data_header[4][1] = "data";
data_header[4][2] = "10%";
data_header[4][3] = "<%=BOOK_ACC_NO%>";




data_arr = new Array();
<%
int  counter=0;%>

<% if (searchLibJournalList != null && searchLibJournalList.size() > 0) { 
%>
<% 	for(LibJournalReceiptEntryDt libDt : searchLibJournalList){
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=libDt.getReceipt().getId()%>"
data_arr[<%= counter%>][1] = "<%=libDt.getReceipt().getReceiptNo()%>"
data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(libDt.getReceipt().getReceiptDate())%>"
<%if(libDt.getReceipt() != null){%>
data_arr[<%= counter%>][3] = "<%=libDt.getReceipt().getIssueNo()%>"
<%}else{%>
data_arr[<%= counter%>][3] = ""
<%}%>
<%if(libDt.getBook() != null){%>
data_arr[<%= counter%>][4] = "<%=libDt.getBook().getBookName()%>"
<%}else{%>
data_arr[<%= counter%>][4] ="-"
<%}%>
<%if(libDt.getBook() != null){%>
data_arr[<%= counter%>][5] = "<%=libDt.getBook().getBookNo()%>"
<%}else{%>
data_arr[<%= counter%>][5] ="-"
<%}%>


<%
counter++;
}
}

%>

formName = "journalReceipt"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}

makeTable(start,end);

</script></div>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasVendor"%>
<%@page import="jkt.hms.masters.business.LibCrvDt"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
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
utilMap = (Map<String,Object>) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
date = (String) utilMap.get("currentDate");
String userName = "";
if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
map = (Map<String, Object>)request.getAttribute("map");
}

ArrayList<MasVendor> vendorList = (ArrayList<MasVendor>)map.get("vendorList");
Map<String, Object> patientMap = new HashMap<String, Object>();
List<LibCrvDt> searchCrvList = new ArrayList<LibCrvDt>();
if(map.get("patientMap") != null){
	patientMap= (Map<String, Object>)map.get("patientMap");
	}
if(patientMap.get("searchCrvList") != null){
	searchCrvList= (List<LibCrvDt>)patientMap.get("searchCrvList");
	}
%>
<h6>CRV Entry</h6>
<div class="Clear"></div>
<div class="blockTitle">Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>

<label> From Date</label> <input type="text" class="calDate"
	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currentDate %>"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.smqSearch.<%=FROM_DATE%>,event)" />

<label> To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"
	readonly="readonly" validate="To Date,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.smqSearch.<%=TO_DATE%>,event)" />

<div class="Clear"></div>
<label>Crv No</label> <input type="text" name="<%=SUPPLY_ORDER_NO %>"
	value="" MAXLENGTH="20"
	onkeypress="return submitenter(this,event,'lib?method=searchCrv');" />
<div class="Clear"></div>
</div>
</form>

<div class="Clear"></div>
<input type="button" name="submit" id="addbutton"
	onclick="submitForm('smqSearch','/hms/hms/lib?method=searchCrv');"
	value="Search" class="cmnButton" accesskey="a" />

<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="crv" method="post" action=""><script
	type="text/javascript">
formFields = [
[0, "crvId", "id"],[1,"<%=CRV%>"],[2,"<%=DATE%>"],[3,"<%=VENDOR_ID%>"],[4,"<%=BILL_NO%>"], [5,"<%=BOOK_NAME%>"],[6,"<%=BOOK_ACC_NO%>"]];
statusTd = 6;
</script></form>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript" language="javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "CRV No"
data_header[0][1] = "data";
data_header[0][2] = "7%";
data_header[0][3] = "<%=CRV%>";

data_header[1] = new Array;
data_header[1][0] = "Date"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "<%=DATE%>";

data_header[2] = new Array;
data_header[2][0] = "Vendor"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=VENDOR_ID%>";

data_header[3] = new Array;
data_header[3][0] = "Bill No"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=BILL_NO%>";

data_header[4] = new Array;
data_header[4][0] = "Book Name"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=BOOK_NAME%>";


data_header[5] = new Array;
data_header[5][0] = "Acc No"
data_header[5][1] = "data";
data_header[5][2] = "10%";
data_header[5][3] = "<%=BOOK_ACC_NO%>";




data_arr = new Array();
<%
int  counter=0;%>

<% if (searchCrvList != null && searchCrvList.size() > 0) { 
%>
<% 	for(LibCrvDt libDt : searchCrvList){
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=libDt.getCrvHd().getId()%>"
data_arr[<%= counter%>][1] = "<%=libDt.getCrvHd().getCrvNo()%>"
data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(libDt.getCrvHd().getCrvDate())%>"
<%if(libDt.getCrvHd().getVendor() != null){%>
data_arr[<%= counter%>][3] = "<%=libDt.getCrvHd().getVendor().getVendorName()%>"
<%}else{%>
data_arr[<%= counter%>][3] = "-"
<%}%>
<%if(libDt.getCrvHd() != null){%>
data_arr[<%= counter%>][4] = "<%=libDt.getCrvHd().getBillNo()%>"
<%}else{%>
data_arr[<%= counter%>][4] ="-"
<%}%>
<%if(libDt.getBook() != null){%>
data_arr[<%= counter%>][5] = "<%=libDt.getBook().getBookName()%>"
<%}else{%>
data_arr[<%= counter%>][5] ="-"
<%}%>

<%if(libDt.getBook() != null){%>
data_arr[<%= counter%>][6] = "<%=libDt.getBook().getBookNo()%>"
<%}else{%>
data_arr[<%= counter%>][6] ="-"
<%}%>

<%
counter++;
}
}

%>

formName = "crv"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}

makeTable(start,end);

</script></div>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasPool"%>
<%@page import="jkt.hms.masters.business.MasSmq"%>
<%@page import="jkt.hms.masters.business.AccomAllotment"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
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
<%
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
List<MasRank> rankList = new ArrayList<MasRank>();
if(detailsMap.get("rankList") != null){
rankList = (List<MasRank>)detailsMap.get("rankList");
}
List<MasServiceType> serviceTypeList=  new ArrayList<MasServiceType>();
if(detailsMap.get("serviceTypeList") != null){
	serviceTypeList = (List<MasServiceType>)detailsMap.get("serviceTypeList");
	}
List<MasPool> poolList=  new ArrayList<MasPool>();
if(detailsMap.get("poolList") != null){
	poolList = (List<MasPool>)detailsMap.get("poolList");
	}

List<MasSmq> smqList = new ArrayList<MasSmq>();
if(detailsMap.get("smqList") != null){
	smqList = (List<MasSmq>)detailsMap.get("smqList");
	}
Map<String, Object> patientMap = new HashMap<String, Object>();
List<AccomAllotment> searchAllotmentList = new ArrayList<AccomAllotment>();
if(map.get("patientMap") != null){
	patientMap= (Map<String, Object>)map.get("patientMap");
	}
if(patientMap.get("searchAllotmentList") != null){
	searchAllotmentList= (List<AccomAllotment>)patientMap.get("searchAllotmentList");
	}
String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
%>

<h2><%=message %></h2>

<%} %>
<div id="contentHolder">
<form name="smqSearch" action="" method="post">
<h6>Cancellation of Allotment Order for Airmen</h6>
<div class="Clear"></div>
<div class="blockTitle">Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>

<label>Ho_To From Date</label> <input type="text" class="calDate"
	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currentDate %>"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.smqSearch.<%=FROM_DATE%>,event)" />

<label>Ho_To To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"
	readonly="readonly" validate="To Date,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.smqSearch.<%=TO_DATE%>,event)" />

<div class="Clear"></div>


<label>Allot.Order File No</label> <input type="text"
	name="<%=ALLOTMENT_NO %>" value="" MAXLENGTH="15"
	onkeypress="return submitenter(this,event,'accom?method=searchCancelForAirmen')"
	tabindex="1" /> <script>
			document.smqSearch.<%=ALLOTMENT_NO%>.focus();
			</script> <label>Service No</label></label> <input type="text" name="<%=SERVICE_NO %>"
	value="" MAXLENGTH="15"
	onkeypress="return submitenter(this,event,'accom?method=searchCancelForAirmen')"
	tabindex="1" />

<div class="Clear"></div>

<label>Service Type</label> <select id="serviceTypeId"
	name="<%=SERVICE_TYPE_ID %>" tabindex="1">
	<option value="0">Select</option>
	<%
					for(MasServiceType masServiceType : serviceTypeList){
				%>
	<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName() %></option>
	<%}%>
</select> <label>Rank</label> <select id="rankId" name="<%=RANK_ID %>"
	tabindex="1">
	<option value="0">Select</option>
	<%
					for(MasRank masRank : rankList){
				%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}%>
</select> <label>Pool</label> <select id="poolId" name="<%=POOL_ID %>"
	tabindex="1">
	<option value="0">Select</option>
	<%
					for(MasPool masPool : poolList){
				%>
	<option value="<%=masPool.getId() %>"><%=masPool.getPoolName() %></option>
	<%}%>
</select> <label>Smq</label> <select id="smqId" name="<%=SMQ_ID %>" tabindex="1">
	<option value="0">Select</option>
	<%
					for(MasSmq masSmq : smqList){
				%>
	<option value="<%=masSmq.getId() %>"><%=masSmq.getSmqName() %></option>
	<%}%>
</select>

<div class="Clear"></div>
</div>
</form>

<div class="Clear"></div>
<input type="button" name="submit" id="addbutton"
	onclick="submitForm('smqSearch','/hms/hms/accom?method=searchCancelForAirmen','checkFromNTodata');"
	value="Search" class="cmnButton" accesskey="a" />

<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="cancel" method="post" action=""><script
	type="text/javascript">
formFields = [
[0, "<%= ALLOTMENT_ID%>", "id"],[1,"<%=ALLOTMENT_FILE_NO%>"],[2,"<%=ALLOTMENT_FILE_DATE%>"],[3,"<%=SMQ_NAME%>"], [4,"<%=POOL_ID%>"],[5,"<%=SERVICE_NO%>"],[6,"<%=SERVICE_PERSON_NAME%>"]];
statusTd = 6;
</script></form>
</div>
<div class="Clear"></div>
<div class="division"></div>
</div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<script type="text/javascript" language="javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Allot.Order file No"
data_header[0][1] = "data";
data_header[0][2] = "7%";
data_header[0][3] = "<%=ALLOTMENT_FILE_NO%>";

data_header[1] = new Array;
data_header[1][0] = "Allot.Order File Date"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "<%=ALLOTMENT_FILE_DATE%>";

data_header[2] = new Array;
data_header[2][0] = "SMQ No"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=SMQ_NAME%>";

data_header[3] = new Array;
data_header[3][0] = "Pool Code"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=POOL_ID%>";


data_header[4] = new Array;
data_header[4][0] = "Service No"
data_header[4][1] = "data";
data_header[4][2] = "10%";
data_header[4][3] = "<%=SERVICE_NO%>";

data_header[5] = new Array;
data_header[5][0] = "Name"
data_header[5][1] = "data";
data_header[5][2] = "20%";
data_header[5][3] = "<%=SERVICE_PERSON_NAME%>";
data_arr = new Array();
<%
int  counter=0;%>

<% if (searchAllotmentList != null && searchAllotmentList.size() > 0) { 
%>
<% 	for(AccomAllotment accAlot : searchAllotmentList){
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=accAlot.getId()%>"
data_arr[<%= counter%>][1] = "<%=accAlot.getAllotmentNo()%>"
data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(accAlot.getAllotmentDate())%>"
<%if(accAlot.getSmq() != null){%>
data_arr[<%= counter%>][3] = "<%=accAlot.getSmq().getSmqName()%>"
<%}else{%>
data_arr[<%= counter%>][3] ="-"
<%}%>
<%if(accAlot.getPool() != null){%>
data_arr[<%= counter%>][4] = "<%=accAlot.getPool().getPoolName()%>"
<%}else{%>
data_arr[<%= counter%>][4] ="-"
<%}%>

<%if(accAlot.getAccom().getServiceNo() != null){%>
data_arr[<%= counter%>][5] = "<%=accAlot.getAccom().getServiceNo()%>"
<%}else{%>
data_arr[<%= counter%>][5] ="-"
<%}%>
<%if(accAlot.getAccom().getServicePersonName() != null){%>
data_arr[<%= counter%>][6] = "<%=accAlot.getAccom().getServicePersonName()%>"
<%}else{%>
data_arr[<%= counter%>][6] ="-"
<%}%>


<%
counter++;
}
}

%>

formName = "cancel"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}

makeTable(start,end);

</script>


<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasPool"%>
<%@page import="jkt.hms.masters.business.SmqVacation"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MovementInOtherPerson"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder">
<form name="movementSearch" action="" method="post"><script
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
List<MasRank> rankList = new ArrayList<MasRank>();
Map<String, Object> patientMap = new HashMap<String, Object>();
Map<String, Object> detailsMap = new HashMap<String, Object>();
List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
List<MovementInOtherPerson> searchotherpersoList = new ArrayList<MovementInOtherPerson>();

if(map.get("patientMap") != null){
	patientMap= (Map<String, Object>)map.get("patientMap");
	}
if(map.get("detailsMap") != null){
	detailsMap= (Map<String, Object>)map.get("detailsMap");
	}
if(patientMap.get("rankList") != null){
	rankList = (List<MasRank>)patientMap.get("rankList");
	}
if(rankList==null || rankList.size()==0){
	if(detailsMap.get("rankList") != null){
		rankList = (List<MasRank>)detailsMap.get("rankList");
		}
}
if(patientMap.get("searchEmployeeList") != null){
	searchEmployeeList= (List<MasEmployee>)patientMap.get("searchEmployeeList");
	}
if(patientMap.get("searchotherpersoList") != null){
	searchotherpersoList= (List<MovementInOtherPerson>)patientMap.get("searchotherpersoList");
	}
%>
<h6>Movement Out</h6>
<div class="Clear"></div>
<div class="blockTitle">Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>


<label>Service No</label> <input type="text" name="<%=SERVICE_NO %>"
	value="" MAXLENGTH="20" /> <label>Rank</label> <select id="rankId"
	name="<%=RANK_ID %>">
	<option value="0">Select</option>
	<%
					for(MasRank masRank : rankList){
				%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}%>
</select>

<div class="Clear"></div>
<label>First Name</label> <input type="text" name="<%=S_FIRST_NAME %>"
	id="<%=S_FIRST_NAME %>" value="" MAXLENGTH="30" tabindex="1" /> <label>Last
Name</label> <input type="text" name="<%=S_LAST_NAME %>" id="<%=S_LAST_NAME %>"
	value="" MAXLENGTH="30" tabindex="1" />
<div class="Clear"></div>
<div class="Clear"></div>
</div>
</form>

<div class="Clear"></div>
<input type="button" name="submit" id="addbutton"
	onclick="submitForm('movementSearch','/hms/hms/hrOrderly?method=searchRecordsForMovementOut');"
	value="Search" class="cmnButton" accesskey="a" />

<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="movementOut" method="post" action=""><script
	type="text/javascript">
formFields = [
[0, "<%= EMPLOYEE_ID%>", "id"],[1,"<%=SERVICE_NO%>"],[2,"<%=RANK_ID%>"],[3,"<%=S_FIRST_NAME%>"],[4,"code"]];
statusTd = 4;
</script></form>
</div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript" language="javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Service No"
data_header[0][1] = "data";
data_header[0][2] = "15%";
data_header[0][3] = "<%=SERVICE_NO%>";


data_header[1] = new Array;
data_header[1][0] = "Rank"
data_header[1][1] = "data";
data_header[1][2] = "10%";
data_header[1][3] = "<%=RANK_ID%>";

data_header[2] = new Array;
data_header[2][0] = "Service Person Name"
data_header[2][1] = "data";
data_header[2][2] = "10%";
data_header[2][3] = "<%=S_FIRST_NAME%>";

data_header[3] = new Array;
data_header[3][0] = "CODE"
data_header[3][1] = "hide";
data_header[3][2] = "10%";
data_header[3][3] = "code";


data_arr = new Array();
<%
int  counter=0;%>

<% if (searchEmployeeList != null && searchEmployeeList.size() > 0) { 
%>
<% 	for(MasEmployee emp : searchEmployeeList){
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=emp.getId()%>"
data_arr[<%= counter%>][1] = "<%=emp.getServiceNo()%>"
<%if(emp.getRank() != null){%>
data_arr[<%= counter%>][2] = "<%=emp.getRank().getRankName()%>"
<%}%>
<%
if(emp.getFirstName() != null  && !(emp.getFirstName().equals(""))){

String sMiddleName = "";
String sLastName = "";
if(emp.getMiddleName() != null){
sMiddleName = emp.getMiddleName();
}
if(emp.getLastName() != null){
sLastName = emp.getLastName();
}
String sName = emp.getFirstName()+" "+sMiddleName+" "+sLastName;

%>
data_arr[<%= counter%>][3] = "<%=sName%>"
<%}else{%>
data_arr[<%= counter%>][3] = "-"
<%}%>
data_arr[<%=counter%>][4]="<%=emp.getEmployeeCode() %>"

<%
counter++;
}
}%>
<% if (searchotherpersoList != null && searchotherpersoList.size() > 0) { 
%>
<% 	for(MovementInOtherPerson emp : searchotherpersoList){
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=emp.getId()%>"
data_arr[<%= counter%>][1] = "<%=emp.getServiceNo()%>"
<%if(emp.getRank() != null){%>
data_arr[<%= counter%>][2] = "<%=emp.getRank().getRankName()%>"
<%}%>
<%
if(emp.getFirstName() != null  && !(emp.getFirstName().equals(""))){

String sMiddleName = "";
String sLastName = "";
if(emp.getMiddleName() != null){
sMiddleName = emp.getMiddleName();
}
if(emp.getLastName() != null){
sLastName = emp.getLastName();
}
String sName = emp.getFirstName()+" "+sMiddleName+" "+sLastName;

%>
data_arr[<%= counter%>][3] = "<%=sName%>"
<%}else{%>
data_arr[<%= counter%>][3] = "-"
<%}%>
data_arr[<%=counter%>][4]="<%=emp.getEmployeeCode() %>"
<%
counter++;
}
}

%>

formName = "movementOut"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}

makeTable(start,end);

</script></div>
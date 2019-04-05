<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil" %>
<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PostedOutEntry"%>
<%@page import="jkt.hms.masters.business.ProposalForHroEntry"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder">
<form name="searchProposalForHRO" action="" method="post">

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

List<ProposalForHroEntry> searchProposalList = new ArrayList<ProposalForHroEntry>();
if(map.get("searchProposalList") != null)
{
	searchProposalList = (List<ProposalForHroEntry>)map.get("searchProposalList");
}

Map<String, Object> patientMap = new HashMap<String, Object>();
List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
if(map.get("patientMap") != null){
	patientMap= (Map<String, Object>)map.get("patientMap");
	}
if(patientMap.get("searchEmployeeList") != null){
	searchEmployeeList= (List<MasEmployee>)patientMap.get("searchEmployeeList");
	}




%>
<h6>Search Proposal For HRO</h6>
<div class="Clear"></div>
 <div class="blockTitle">Search</div><div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div> 

			
				<label>Entry No</label>
			<input type="text" name="<%=ENTRY_NO %>" value="" MAXLENGTH="20" />
			
			<label>Entry Date</label>
	<input type="text" class="calDate" id="date" name="<%=ENTRY_DATE %>" value="" readonly="readonly" MAXLENGTH="30" tabindex="1"/>
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,yes" onClick="setdate('<%=date %>',document.searchProposalForHRO.<%=DATE%>,event)"/>
	<div class="Clear"></div>

</div>
</form>

<div class="Clear"></div>
<input type="button" name="submit" id="addbutton" onclick="submitForm('searchProposalForHRO','/hms/hms/hrOrderly?method=searchProposalForHro');"  value="Search" class="cmnButton" accesskey="a" />

<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex="2" >
<div id="searchtable" tabindex="2" ></div>
<form name="updateProposalHRO" method="post" action="">
<script type="text/javascript">
formFields = [
[0, "<%= EMPLOYEE_ID%>", "id"],[1,"<%=ENTRY_NO%>"], [2,"<%=ENTRY_DATE%>"]];
statusTd = 2;
</script>
</form>
</div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
<script type="text/javascript" language="javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Entry No"
data_header[0][1] = "data";
data_header[0][2] = "15%";
data_header[0][3] = "<%=ENTRY_NO%>";


data_header[1] = new Array;
data_header[1][0] = "Entry Date"
data_header[1][1] = "data";
data_header[1][2] = "10%";
data_header[1][3] = "<%=ENTRY_DATE%>";



data_arr = new Array();
<%
int  counter=0;%>

<% if (searchProposalList != null && searchProposalList.size() > 0) { 
%>
<% 	for(ProposalForHroEntry proposal : searchProposalList){
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=proposal.getId()%>"

<%if(proposal.getEntryNo() != null){%>
data_arr[<%= counter%>][1] = "<%=proposal.getEntryNo()%>"
<%}else{%>
data_arr[<%= counter%>][1] = "-"
<%}%>
<%if(proposal.getPropsalDate() != null){%>
data_arr[<%= counter%>][2] = "<%=proposal.getPropsalDate()%>"
<%}else{%>
data_arr[<%= counter%>][2] = "-"
<%}%>


<%
counter++;
}
}

%>

formName = "updateProposalHRO"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}

makeTable(start,end);

</script>

</div>
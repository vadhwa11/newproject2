<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}

	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String userName = "";
	String message = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	List<MasRank> rankList = new ArrayList<MasRank>();
	if (map.get("rankList") != null) {
		rankList = (List) map.get("rankList");
	}

	//List<Inpatient> inpatientList = new ArrayList<Inpatient>();

//	if (map.get("inpatientList") != null) {
//		inpatientList = (List) map.get("inpatientList");
//	}
	
	
	List<Patient> patientList = new ArrayList<Patient>();

	if (map.get("patientList") != null) {
		patientList = (List) map.get("patientList");
	}
%>

<%
	if (map.get("message") != null) {
		message = (String) map.get("message");

	}
	if (!message.equalsIgnoreCase("")) {
%>
<h2><%=message%></h2>
<%
	}
%>

<div class="Clear"></div>
<div id="contentHolder">
<h6>Medical Board Proceedings Search</h6>

<div class="blockFrame">
<form name="medicalBoardProceedingSearch1" action="" method="post">
<div class="Clear"></div>

<label>Service No.</label> <input id="searchField1" type="text"
	maxlength="20" name="<%= SERVICE_NO%>" value="" class="textbox_size20"
	tabindex=1 /> <label>Rank </label> <select id="searchField2"
	name="<%=RANK_ID %>" tabindex="1" class="select_adt">
	<option value="0">Select</option>
	<%
		for (MasRank masRank : rankList) {
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
		}
	%>
</select> <!--<label>Ad No.</label> <input id="searchField3" maxlength="30" type="text" name="<%= AD_NO%>" value="" class="textbox_size20" tabindex=1 />
<div class="Clear"></div>
--> <label>First Name</label> <input id="searchField4" type="text"
	maxlength="30" name="<%= P_FIRST_NAME%>" value=""
	class="textbox_size20" tabindex=1 /> <label>Last Name</label> <input
	type="text" maxlength="30" id="searchField5" name="<%= P_LAST_NAME%>"
	value="" class="textbox_size20" tabindex=1 /> <!--<label>Staff</label>
            <input tabindex="1" id="<%=STAFF%>" type="checkbox" name="<%=STAFF%>" value="" onclick="checkCheckBox();" class="radio2" />
			       <script type="text/javascript">
	       function  checkCheckBox()
	       {
	       var value1=document.getElementById('<%=STAFF%>').value;
	       
	       if(document.getElementById('<%=STAFF%>').checked){
	       document.getElementById('<%=STAFF%>').value='s';	     
	       }else{
	       document.getElementById('<%=STAFF%>').value='p';	     
	       }
	       
	       
	       }   
	          
	          </script>
--><input type="button" name="Search"
	onclick="submitForm('medicalBoardProceedingSearch1','medicalBoard?method=searchMedicalBoardProceeding');"
	value="Search" tabindex="1" class="cmnButton" accesskey="a" /></form>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<form name="medicalBoardProceedingSearch" method="post" action="">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script type="text/javascript">
	formFields = [ [0,"<%= COMMON_ID%>"], [1,"<%= SERVICE_NO%>"], [2,"<%= P_FIRST_NAME %>"], [3,"<%= P_LAST_NAME %>"], [4,"<%=AD_NO%>"], [5,"<%= RANK_ID %>"],  [6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script>

<div class="bottom">
<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=currentTime%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentTime%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /></div>
</form>
</div>
<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Service No.";
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= SERVICE_NO %>";

data_header[1] = new Array;
data_header[1][0] = "First Name";
data_header[1][1] = "data";
data_header[1][2] = "15%";
data_header[1][3] = "<%= P_FIRST_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Last Name";
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%= P_LAST_NAME %>";

data_header[3] = new Array;
data_header[3][0] = "Status"
data_header[3][1] = "hide";
data_header[3][2] = "0%";
data_header[3][3] = "<%=AD_NO %>";

data_header[4] = new Array;
data_header[4][0] = "Rank";
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%= RANK_ID %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "hide";
data_header[5][2] = "0%";
data_header[5][3] = "<%=STATUS %>";
<%
int  counter=0;
if (patientList != null && patientList.size() > 0) { 
for(Patient patient : patientList){
%>
   data_arr[<%= counter%>] = new Array();
   data_arr[<%= counter%>][0] = <%= patient.getId()%>
   data_arr[<%= counter%>][1] = "<%=patient.getServiceNo()%>"  
   data_arr[<%= counter%>][2] = "<%=patient.getPFirstName()%>"
   data_arr[<%= counter%>][3] = "<%=patient.getPLastName()%>"
   data_arr[<%= counter%>][4] = "0"
   data_arr[<%= counter%>][5] = "<%=patient.getRank().getRankName()%>"

<%if(patient.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}
counter++;
}
}
%>
formName = "medicalBoardProceedingSearch"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

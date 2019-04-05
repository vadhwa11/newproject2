<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.ApAgendaRequest"%>


<script language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></script>

<script language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></script>

<script language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></script>


<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript">

animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

</script>


<script type="text/javascript">
    function removeRow()
	{
	  var tbl = document.getElementById('amcDetailId');
	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	  else 
	  alert("There should be at least one row filled");
	  
	}
	
	  
	</script>

<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
	%>
	<script>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	
	</script>


<!--main content placeholder starts here-->

<%
	String userName = "";
String serviceNo="";
String servicePersonName="";
	String previousPage = "no";
	int pageNo = 1;
int id=0;
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	ArrayList<MasEmployee> masEmployee = (ArrayList<MasEmployee>) map
	.get("masEmployee");
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		Users users = (Users) session.getAttribute("users");
		if (users != null) {
			serviceNo = users.getLoginName();
			id=users.getEmployee().getId();
		for(MasEmployee maseployee: masEmployee)
		{
			if(maseployee.getId()==id)
			{
				if(maseployee.getMiddleName()!=null || maseployee.getMiddleName().trim().equalsIgnoreCase("") )
				servicePersonName=	maseployee.getFirstName()+""+maseployee.getMiddleName()+" "+maseployee.getLastName();
				else
					servicePersonName=	maseployee.getFirstName()+""+maseployee.getLastName();
					
			}
		}
			
		}
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	String entryNo = "";
	if (map.get("entryNo") != null) {
		entryNo = (String) map.get("entryNo");
	}
	
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if(map.get("departmentList") != null)
	{
		departmentList = (ArrayList) map.get("departmentList");	
	}
	int userId=0;
	if(session.getAttribute("userId")!=null)
	{
		userId=Integer.parseInt(session.getAttribute("userId").toString());
	}
	List<ApAgendaRequest> agendaRequestList = new ArrayList<ApAgendaRequest>();
	if(map.get("apAgendaList") != null)
	{
		agendaRequestList = (ArrayList) map.get("apAgendaList");	
	}
	else if(map.get("searchAgendaRequestList")!= null)
	{
		agendaRequestList=(ArrayList)map.get("searchAgendaRequestList");
	}
%>
<%
	String message = "";
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
<h6>Agenda Points Request</h6>
<div class="Clear"></div>


<%!int temp = 0;%> <input type="hidden" name="<%=POJO_NAME%>" value="">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value=""> <input
	type="hidden" name="title" value="Agenda Ponits Request"> <input
	type="hidden" name="<%=JSP_NAME %>" value=agendaPointsRequest">
<div class="Clear"></div>


<div class="Clear"></div>
<div class="header">

<form name="search" method="post" action=""><label>Agenda
Points</label> <input type="text" id="searchField1" name="<%=SEARCH_FIELD%>"
	value="" MAXLENGTH="30" tabindex="1" /> <input type="button"
	name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','agenda?method=searchAgendaRequest')"
	tabindex="1" /></form>


</div>

<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults">
<div id="searchtable"></div>
<% 
		if(agendaRequestList.size()==0)
		 {
		
	%>
<div class="Clear"></div>
<h5><a href="agenda?method=showAgendaJsp">Show All Records</a></h5>
<div class="Clear"></div>
<%
		 }
	if(agendaRequestList.size()==0 && map.get("search") != null)
	  {
    %>
<div class="Clear"></div>
<h5><a href="agenda?method=showAgendaJsp">Show All Records</a></h5>
<div class="Clear"></div>

<%
	   }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= AGENDA_POINTS_DETAILS %>"],[2,"<%= ENTRY_DATE%>"],[3,"<%= DEPARTMENT_ID%>"], [4,"<%= EMPLOYEE_ID%>"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"],[9,"<%=STATUS_DISPLAY%>"],[10,"<%=DECISION_IN_MEETING%>"],[11,"<%=ACTIONED_BY%>"],[12,"<%=ACTIONED_TO%>"],[13,"<%=AGENDA_POINTS%>"]  ];
	 statusTd = 8;
	</script></div>

<form name="agendaPointsRequest" action="" method=post>

<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Decision In Meeting</label> <input tabindex="1"
	type="text" size="30" value="" name="<%=DECISION_IN_MEETING%>"
	id="<%=DECISION_IN_MEETING%>" maxlength="30" /> <label class="medium"><span>*</span>Action</label>
<input tabindex="1" type="text" size="30" value=""
	name="<%=ACTIONED_BY%>" id="<%=ACTIONED_BY%>" maxlength="30" /> <label
	class="medium"><span>*</span>Info</label> <input tabindex="1"
	type="text" size="30" value="" name="<%=ACTIONED_TO%>"
	id="<%=ACTIONED_TO%>" maxlength="30" />
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>


</div>
<div class="blockFrame">
<div class="Clear"></div>


<label class="medium"><span>*</span>Agenda Date</label> <input
	tabindex="1" name="<%=ENTRY_DATE %>" type="text" value="<%=date%>"
	class="calDate" readonly="true" maxlength="10"
	validate="Entry Date,date,yes" /> <img height="16" border="0"
	width="16" src="/hms/jsp/images/cal.gif"
	onClick="setdate('<%=date%>',document.agendaPointsRequest.<%= ENTRY_DATE%>,event);"
	class="calender" /> <label>Department </label> <select
	name="<%= DEPARTMENT_ID %>" id="dept" tabindex=1>

	<option value="0">Select</option>
	<%
				int deptId=(Integer)session.getAttribute("deptId");
				if(departmentList!= null){
				for (MasDepartment masDepartment : departmentList) {
					if(masDepartment.getId()==deptId){
			%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>

	<% 	
			}else{%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%	
					}
				}
			}
				%>
</select> <label class="medium">Name</label> <select name="<%= EMPLOYEE_ID %>"
	id="emp_id" tabindex=1>

	<option value="<%=userId%>"><%=servicePersonName%></option>
	<%	if(masEmployee!= null){
			for (MasEmployee masEmp : masEmployee) {
				if(masEmp.getMiddleName()!=null ){
	%>
					<option value="<%=masEmp.getId()%>"><%=masEmp.getFirstName()+ " "%> <%=masEmp.getMiddleName()%> <%=masEmp.getLastName()%></option>
	<%	}else{ %>			
					<option value="<%=masEmp.getId()%>"><%=masEmp.getFirstName()%><%=masEmp.getLastName()%></option>	 
	<%}}}%>
	
</select>
<div class="Clear"></div>

<label class="medium"><span>*</span>Agenda Point</label> <textarea
	name="<%=AGENDA_POINTS%>" id="<%=AGENDA_POINTS%>"
	style="width: 250px; height: 100px;" validate="Agenda Point,String,yes"
	tabindex="1" onkeyup="chkLength(this,500);"></textarea>


<div class="Clear"></div>

<label class="medium"><span>*</span>Description</label> <textarea
	name="<%=AGENDA_POINTS_DETAILS%>" style="width: 250px; height: 100px;"
	validate="Description,String,yes" tabindex="1"
	onkeyup="chkLength(this,500);"></textarea></div>


<div class="Clear"></div>

<!--Block Two Starts--> <!--table-->
<div class="division"></div>
<!--Bottom labels starts-->
<div id="edited"></div>
<div class="bottom"><input type="button" name="add" id="addbutton"
	value="Save" class="button"
	onClick="submitForm('agendaPointsRequest','agenda?method=addAgendaPointsRequest');"
	accesskey="a" tabindex="2" /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('agendaPointsRequest','agenda?method=editAgendaRequest','tValue')"
	accesskey="u" tabindex="2" /> <input type="button" name="back"
	id="back" value="Back" class="button"
	onclick="javascript:history.back()" accesskey="b" tabindex="2" /> <input
	type="button" name="Delete" id="deletebutton" value="Activate"
	class="button"
	onClick="submitForm('agendaPointsRequest','agenda?method=deleteAgendaRequest&flag='+this.value)"
	accesskey="d" tabindex="2" /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="button" onclick="resetCheck();"
	accesskey="r" tabindex="2" />

<div class="division"></div>
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <label>Changed
By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden" value="1"
	name="hiddenValue" id="hiddenValue" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
</form>
</div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Agenda Point Details"
data_header[0][1] = "hide";
data_header[0][2] = "25%";
data_header[0][3] = "<%= AGENDA_POINTS_DETAILS%>";

data_header[1] = new Array;
data_header[1][0] = "Proposed Date"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%=ENTRY_DATE%>";

data_header[2] = new Array;
data_header[2][0] = "Department"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=DEPARTMENT_ID%>";

data_header[3] = new Array;
data_header[3][0] = "Proposed By"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%=NAME%>";


data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%= CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "MainStatus"
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";
data_arr = new Array();

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS_DISPLAY %>";

data_arr = new Array();

data_header[9] = new Array;
data_header[9][0] = "Status"
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%=DECISION_IN_MEETING %>";


data_arr = new Array();

data_header[10] = new Array;
data_header[10][0] = "Status"
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%=ACTIONED_BY %>";


data_arr = new Array();

data_header[11] = new Array;
data_header[11][0] = "Status"
data_header[11][1] = "hide";
data_header[11][2] = "15%";
data_header[11][3] = "<%=ACTIONED_TO %>";

data_arr = new Array();

data_header[12] = new Array;
data_header[12][0] = "Agenda Points"
data_header[12][1] = "data";
data_header[12][2] = "15%";
data_header[12][3] = "<%=AGENDA_POINTS %>";

data_arr = new Array();
<%
Iterator itr=agendaRequestList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  ApAgendaRequest  apAgendaRequest = (ApAgendaRequest)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= apAgendaRequest.getId()%>
data_arr[<%= counter%>][1] = "<%=apAgendaRequest.getAgendaPoint()%>"
data_arr[<%= counter%>][2] = "<%= HMSUtil.convertDateToStringWithoutTime(apAgendaRequest.getAgendaDate())%>"
data_arr[<%= counter%>][3] = "<%= apAgendaRequest.getDepartmentId().getDepartmentName() %>"
data_arr[<%= counter%>][4] = "<%= apAgendaRequest.getEmpId().getFirstName() %> <%= apAgendaRequest.getEmpId().getLastName() %>"

data_arr[<%= counter%>][5] = "<%= apAgendaRequest.getLastChgBy()%>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(apAgendaRequest.getLastChgDate())  %>"
data_arr[<%= counter%>][7] = "<%= apAgendaRequest.getLastChgTime() %>"
<%if(apAgendaRequest.getDecisionInMeeting()!= null){%>
data_arr[<%= counter%>][10] = "<%=apAgendaRequest.getDecisionInMeeting()%>"
<%}else{%>
	data_arr[<%= counter%>][10] = ""
	<%}if(apAgendaRequest.getActionBy()!= null){%>
data_arr[<%= counter%>][11] = "<%= apAgendaRequest.getActionBy()  %>"
<%}else{%>
data_arr[<%= counter%>][11] = ""
<%}%>
<%if(apAgendaRequest.getActionTo()!= null){%>
data_arr[<%= counter%>][12] = "<%=apAgendaRequest.getActionTo() %>"
<%}else{%>
data_arr[<%= counter%>][12] = ""
<%}%>
<%if(apAgendaRequest.getAgendaPoint()!= null){%>
data_arr[<%= counter%>][13] = "<%=apAgendaRequest.getAgendaPoint() %>"
<%}else{%>
data_arr[<%= counter%>][13] = ""
<%}%>
<% if(apAgendaRequest.getStatus().equals("o") || apAgendaRequest.getStatus().equals("s")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>


<% if(apAgendaRequest.getStatus().equals("o")){ %>
data_arr[<%= counter%>][9] = "Open"
<%}else if(apAgendaRequest.getStatus().equals("s") ){%>
data_arr[<%= counter%>][9] = "Selected For Meeting"
<%}else if(apAgendaRequest.getStatus().equals("r") ){%>
data_arr[<%= counter%>][9] = "Rejected"
<%}
		     counter++;
}
%>
formName = "agendaPointsRequest"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
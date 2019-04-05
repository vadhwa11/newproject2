<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasLaundryMachine"%>
<%@page import="jkt.hms.masters.business.MachineActivity"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
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
<script>
function calculateHrs(){
var timeOn ;
var timeOff;
var totaltime;
timeOn = document.getElementById('<%=TIME_ON%>').value;
timeOff = document.getElementById('<%=TIME_OFF%>').value;
if(timeOff > timeOn){
totaltime = timeOff - timeOn;
 document.getElementById('<%=TOTAL_HOURS%>').value = totaltime
 } else{
 alert("Please Check the time")
 }
}
</script>

<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	String entryNo="";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String ,Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList<MachineActivity> machineActivityList = (ArrayList<MachineActivity>)map.get("machineActivityList");
	ArrayList<MasLaundryMachine> laundryList = (ArrayList<MasLaundryMachine>)map.get("laundryList");
	ArrayList<MasLaundryMachine> gridLaundryList = (ArrayList<MasLaundryMachine>)map.get("gridLaundryList");
	String userName = "";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("entryNo") != null){
		entryNo = (String)map.get("entryNo");
	}
	String entryId ="";
	if(map.get("entryId") != null){
		entryId = (String)map.get("entryId");
	}
	String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
%>

<h2><%=message %></h2>

<%} %>
<script>

</script>
<script>
function checkSearchForEntry(){
		if(document.getElementById('<%=ENTRY_ID %>').value == "" && document.getElementById('date').value == "") {
		alert("Please enter value in textfield");
		return false;
}
	else
		return true;
}
</script>
<div id="contentHolder">
<div class="Clear"></div>
<h6>Machine Activity Entry</h6>
<div class="Clear"></div>
<div class="header">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Entry
No.</label> <input type="text" name="<%=ENTRY_ID %>" id="<%=ENTRY_ID %>"
	value=""
	onkeypress="return submitenter(this,event,'laundry?method=searchMachineActivity','checkSearchForEntry')" />
<label>Entry Date</label> <input type="text" class="calDate" id="date"
	name="<%=DATE %>" value="<%=currentDate %>" readonly="readonly"
	MAXLENGTH="30" tabindex="1" validate="Entry Date,date,no"
	onkeypress="return submitenter(this,event,'laundry?method=searchMachineActivity','checkSearchForEntry')" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.search.<%=DATE%>,event)" />
	 <input
	type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','laundry?method=searchMachineActivity','checkSearchForEntry')"
	tabindex=1 /></form>
</div>
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
	if(machineActivityList.size()>0)
	 {
		String strForCode = (String)map.get("entryId");
		Date strForCodeDescription = ((Date)map.get("entryDate"));
		if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null)
		{
	%> <a href="laundry?method=showMachineActivityEntry">Show All
Records</a> <%
			}
		 }
	 if(machineActivityList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="laundry?method=showMachineActivityEntry">Show All
Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],[1,"<%= ENTRY_NO%>"],[2,"<%= ENTRY_DATE%>"],[3,"<%= MACHINE_NAME%>"],[4,"<%= ACTIVITY_DATE%>"],[5,"<%= TIME_ON%>"],[6,"<%= TIME_OFF%>"],[7,"<%= TOTAL_HOURS%>"],[8,"<%= CHANGED_BY%>"],[9,"<%= CHANGED_DATE %>"],[10,"<%= CHANGED_TIME %>"],[11,"<%=STATUS%>"] ];
	 statusTd =11;
	</script></div>
<div class="Clear"></div>
<form name="linen" method="post" action=""><input type="hidden"
	name="<%= POJO_NAME %>" value="MachineActivity"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ItemName">
<input type="hidden" name="title" value="Machine Activity Entry">
<input type="hidden" name="<%=JSP_NAME %>" value="machineActivityEntry">
<input type="hidden" name="pojoPropertyCode" value="ItemCode">

<div class="blockFrame"><label class="common"><span>*</span>
Entry No.</label> <input id="<%=ENTRY_NO%>" type="text" name="<%=ENTRY_NO%>"
	value="<%=entryNo %>" validate="Entry No,string,yes" maxlength="10"
	tabindex=1 readonly="readonly" /> <label><span>*</span> Entry
Date</label> <input type="text" class="calDate" name="<%=ENTRY_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30"
	tabindex="1" validate="Entry Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.linen.<%=ENTRY_DATE%>,event)" />


<label class="common"><span>*</span> Machine Name</label> <select
	name="<%=MACHINE_NAME %>" id="<%=MACHINE_NAME %>"
	validate="Machine Name,string,yes" tabindex=1 />
	<option value="0">Select</option>
	<% 
    			for (MasLaundryMachine  masLaundry : laundryList){
    		%>
	<option value="<%=masLaundry.getId()%>"><%=masLaundry.getMahineName()%></option>
	<%}%>
</select>

<div class="Clear"></div>

<label><span>*</span> Activity Date</label> <input type="text"
	class="calDate" id="<%=ACTIVITY_DATE%>" name="<%=ACTIVITY_DATE%>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30"
	validate="Activity Date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.linen.<%=ACTIVITY_DATE%>,event)" />

<label class="common"><span>*</span> Time On</label> <input type=""
	name="<%=TIME_ON%>" id="<%=TIME_ON%>" validate="Time On,string ,yes"
	onKeyUp="mask(this.value,this,'2,5',':');"
	onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="8"
	tabindex="1" /> <label class="common"><span>*</span> Time Off</label> <input
	type="" name="<%=TIME_OFF%>" id="<%=TIME_OFF%>"
	validate="Time Off,string ,yes"
	onKeyUp="mask(this.value,this,'2,5',':');"
	onBlur="calculateTime();IsValidTimeForSetup(this.value,this.id);"
	maxlength="8" tabindex="1" />

<div class="Clear"></div>

<label class="common"><span>*</span> Total Hours</label> <input type=""
	name="<%=TOTAL_HOURS %>" id="<%=TOTAL_HOURS %>" validate=""
	maxlength="5" tabindex="1" readonly="readonly" /></div>
<div class="Clear"></div>

<div class="division"></div>

<div class="bottom">
<div class="Clear"></div>



<input type="button" name="add" id="addbutton" value="Save"
	class="button"
	onClick="if(calculateTime()){submitForm('linen','laundry?method=addMachineActivity');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button" onClick="if(calculateTime()){submitForm('linen','laundry?method=editMachineActivity');}"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('linen','laundry?method=deleteMachineActivity&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r"
	tabindex=1 /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%=COMMON_ID%>" value="" />
<div class="division"></div>
<div id="edited"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> 
<label>Changed Date</label> <label class="value"><%=currentDate%></label> 
<label>Changed Time</label> <label class="value"><%=time%></label></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Entry No"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= ENTRY_NO%>"

data_header[1] = new Array;
data_header[1][0] = "Entry Date"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= ENTRY_DATE%>"

data_header[2] = new Array;
data_header[2][0] = "Machine Name"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%= MACHINE_NAME%>"

data_header[3] = new Array;
data_header[3][0] = "Activity Date"
data_header[3][1] = "data";
data_header[3][2] = "25%";
data_header[3][3] = "<%= ACTIVITY_DATE%>"

data_header[4] = new Array;
data_header[4][0] = "Time On"
data_header[4][1] = "data";
data_header[4][2] = "25%";
data_header[4][3] = "<%= TIME_ON%>"

data_header[5] = new Array;
data_header[5][0] = "Time Off"
data_header[5][1] = "data";
data_header[5][2] = "25%";
data_header[5][3] = "<%= TIME_OFF%>"

data_header[6] = new Array;
data_header[6][0] = "Total Time"
data_header[6][1] = "data";
data_header[6][2] = "25%";
data_header[6][3] = "<%= TOTAL_HOURS%>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%= CHANGED_BY %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "<%= CHANGED_DATE %>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%= CHANGED_TIME %>";

data_header[10] = new Array;
data_header[10][0] = "Status"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator<MachineActivity> itr=machineActivityList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            MachineActivity  masLinen = (MachineActivity)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= masLinen.getId()%>"
data_arr[<%= counter%>][1] = "<%= masLinen.getEntryNo()%>"
data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateTypeToStringWithoutTime(masLinen.getEntryDate())%>"
<%
		Iterator<MasLaundryMachine> itrGridLaundryList=gridLaundryList.iterator();
		 while(itrGridLaundryList.hasNext())
            {try{
             MasLaundryMachine laundryGrid = (MasLaundryMachine)itrGridLaundryList.next(); 
			 if(masLinen.getMachine().getId().equals(laundryGrid.getId()) && laundryGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=laundryGrid.getMahineName()%>"
			<%}else if(masLinen.getId().equals(laundryGrid.getId()) && laundryGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=laundryGrid.getMahineName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception in  ----> "+e);}}
%>
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateTypeToStringWithoutTime(masLinen.getActivityDate()) %>"
data_arr[<%= counter%>][5] = "<%= masLinen.getTimeOn() %>"
data_arr[<%= counter%>][6] = "<%= masLinen.getTimeOff() %>"
data_arr[<%= counter%>][7] = "<%= masLinen.getTotalHrs() %>"
data_arr[<%= counter%>][8] = "<%=masLinen.getLastChgBy() %>"
data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(masLinen.getLastChgDate()) %>"
data_arr[<%= counter%>][10] = "<%= masLinen.getLastChgTime() %>"

<% if(masLinen.getStatus().equals("y")){ %>
data_arr[<%= counter%>][11] = "Active"
<%}else{%>
data_arr[<%= counter%>][11] = "InActive"
<%}%>
<%
	counter++;
}
%>
 
formName = "linen"
nonEditable = ['<%=ENTRY_NO%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.CarDiaryEntry"%>
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
function checkSpecialChar(){
 var code;
 code = document.getElementById('<%=FROM_PLACE%>').value;
 
 var name ;
 name= document.getElementById('<%=TO_PLACE%>').value;
 if(code.match("\"")|| name.match("\"")){
 alert('Please Do not enter " as Entry field')
 return false;
 }else if(code.match("\<")|| name.match("\<")){
 alert('Please Do not enter < as Entry field')
 return false;
 }
 else{
 return true;
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
	ArrayList<CarDiaryEntry> carDiaryEntryList = (ArrayList<CarDiaryEntry>)map.get("carDiaryEntryList");
	String userName = "";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("entryNo") != null){
		entryNo = (String)map.get("entryNo");
	}
	String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
%>

<h2><%=message %></h2>

<%} %>
<script>
function checkTotalKm(){
var weight;
totalKm = document.getElementById('<%=TOTAL_KM%>').value;
if(totalKm == ""){
alert("Total Km cannot be blank")
return false;
}else if(totalKm == "0"){
alert("Total Km cannot be 0")
return false;
}
else{
return true;
}
}
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
<h6>Drivers Car Diary Entry</h6>
<div class="Clear"></div>
<div class="header">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Entry
No.</label> <input type="text" name="<%=ENTRY_ID %>" id="<%=ENTRY_ID %>"
	value=""
	onkeypress="return submitenter(this,event,'laundry?method=searchCarDiaryEntry','checkSearchForEntry')" />

<label>Entry Date</label> <input type="text" class="calDate" id="date"
	name="<%=DATE %>" value="<%=currentDate %>" readonly="readonly"
	MAXLENGTH="30" tabindex="1" validate="Entry Date,date,no"
	onkeypress="return submitenter(this,event,'laundry?method=searchCarDiaryEntry','checkSearchForEntry')" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.search.<%=DATE%>,event)" /> <input
	type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','laundry?method=searchCarDiaryEntry','checkSearchForEntry')"
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
	if(carDiaryEntryList.size()>0)
	 {
		String strForCode = (String)map.get("entryNo");
		Date strForCodeDescription = (Date)map.get("entryDate");
		if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null)
		{
	%> <a href="laundry?method=showCarDiaryEntry">Show All Records</a> <%
			}
		 }
	 if(carDiaryEntryList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="laundry?method=showCarDiaryEntry">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],[1,"<%= ENTRY_NO%>"],[2,"<%= ENTRY_DATE%>"],[3,"<%= SPECIFICATION_OF_DUTY%>"],[4,"<%= FROM_PLACE%>"],[5,"<%= TO_PLACE%>"],[6,"<%= TOTAL_KM%>"],[7,"<%= CHANGED_BY%>"],[8,"<%= CHANGED_DATE %>"],[9,"<%= CHANGED_TIME %>"],[10,"<%=STATUS%>"] ];
	 statusTd =10;
	</script></div>
<div class="Clear"></div>
<form name="linen" method="post" action="">

<div class="blockFrame"><label class="common"><span>*</span>
Entry No.</label> 
<input id="<%=ENTRY_NO%>" type="text" name="<%=ENTRY_NO%>"	value="<%=entryNo %>" validate="Entry No,string,yes" maxlength="10"
	tabindex=1 readonly="readonly" /> 
	<label><span>*</span> Date</label> <input type="text" class="calDate" id="fromDateId" name="<%=ENTRY_DATE %>"	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30"
	validate="Entry Date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.linen.<%=ENTRY_DATE%>,event)" />


<label class="large"><span>*</span> Specification of Duty</label> <input
	id="<%=SPECIFICATION_OF_DUTY%>" type="text"
	name="<%=SPECIFICATION_OF_DUTY%>" value=""
	validate="Specification Of Duty,string,yes" maxlength="40" tabindex=1 />


<div class="Clear"></div>

<label class="common"><span>*</span> From Place</label> <input type=""
	name="<%=FROM_PLACE%>" id="<%=FROM_PLACE%>" value=""
	validate="From Place,string,yes" maxlength="30" tabindex="1" /> <label
	class="common"><span>*</span> To Place</label> <input type=""
	name="<%=TO_PLACE%>" id="<%=TO_PLACE%>" value=""
	validate="To Place,string,yes" maxlength="30" tabindex="1" /> <label
	class="large"><span>*</span> Total KM</label> <input type=""
	name="<%=TOTAL_KM %>" id="<%=TOTAL_KM %>" value=""
	validate="Total Km,float,no" maxlength="6" tabindex="1" /></div>
<div class="Clear"></div>
<div class="division"></div>

<div class="bottom">
<div class="Clear"></div>

<input type="button" name="add" id="addbutton" value="Save"
	class="button"
	onClick="if(checkTotalKm()&& checkSpecialChar()){submitForm('linen','laundry?method=addCarDiaryEntry');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="if(checkTotalKm()&& checkSpecialChar()){submitForm('linen','laundry?method=editCarDiaryEntry');}"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('linen','laundry?method=deleteCarDiaryEntry&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%=COMMON_ID%>" value="" />

<div class="division"></div>
<div id="edited"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
	<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
	<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>
</div>
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
data_header[2][0] = "Specification"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%= SPECIFICATION_OF_DUTY%>"

data_header[3] = new Array;
data_header[3][0] = "From Place"
data_header[3][1] = "data";
data_header[3][2] = "25%";
data_header[3][3] = "<%=FROM_PLACE%>"

data_header[4] = new Array;
data_header[4][0] = "To Place"
data_header[4][1] = "data";
data_header[4][2] = "25%";
data_header[4][3] = "<%=TO_PLACE%>"

data_header[5] = new Array;
data_header[5][0] = "Total Km"
data_header[5][1] = "data";
data_header[5][2] = "25%";
data_header[5][3] = "<%=TOTAL_KM%>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_BY %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_DATE %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "<%= CHANGED_TIME %>";

data_header[9] = new Array;
data_header[9][0] = "Status"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator<CarDiaryEntry> itr=carDiaryEntryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            CarDiaryEntry  car = (CarDiaryEntry)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= car.getId()%>"
data_arr[<%= counter%>][1] = "<%= car.getEntryNo()%>"
<%if(car.getEntryDate() != null){%>
data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateTypeToStringWithoutTime(car.getEntryDate())%>"
<%}%>
data_arr[<%= counter%>][3] = "<%= car.getSpecificationOfDuty()%>"
data_arr[<%= counter%>][4] = "<%= car.getFromPlace() %>"
data_arr[<%= counter%>][5] = "<%= car.getToPlace()%>"
data_arr[<%= counter%>][6] = "<%= car.getTotalKm() %>"
data_arr[<%= counter%>][7] = "<%= car.getLastChgBy() %>"
data_arr[<%= counter%>][8]= "<%= HMSUtil.convertDateTypeToStringWithoutTime(car.getLastChgDate()) %>"
data_arr[<%= counter%>][9] = "<%= car.getLastChgTime() %>"

<% if(car.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
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

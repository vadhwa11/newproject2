<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page
	import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>


<script type="text/javascript">
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
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';

</script>

<script type="text/javascript">

function checkSearchCriteria1()
{
var serachField1=document.getElementById('searchField1').value;
var searchField2=document.getElementById('searchField2').value;
var searchField3=document.getElementById('searchField3').value;
var searchField4=document.getElementById('searchField4').value;	
var searchField5=document.getElementById('searchField5').value;
if(serachField1==0 && searchField2==0 && searchField3==0 && searchField4==0 && searchField5==0)
{
alert("please select any text criteria");
return false;
}
else
return true;

}



</script>




<%
	

List<MasMedicalExaminationReportOnEntry> medicalExaminationBoardList = new ArrayList<MasMedicalExaminationReportOnEntry>();



Map map = new HashMap();
String message="";


if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	

	if(map.get("medicalExaminationBoardList")!=null)
	{
		medicalExaminationBoardList=(List)map.get("medicalExaminationBoardList");
	}
	
	
	%>




<% 
if (map.get("message") != null) {
       message = (String) map.get("message");
      System.out.println("messssssss"+message);
   }
if(!message.equalsIgnoreCase("")){
	 System.out.println("messssssss bbbbbllllll"+message);
%>
<h2><%=message %></h2>
<%} %>




<div id="contentHolder">
<div class="Clear"></div>
<form name="medicalExaminationBoardPrint" action="" method="post">
<h6>Print Medical Examination Board</h6>
<div class="blockFrame">
<div class="Clear"></div>

<label>Yearly Serial No.</label> <input tabindex="1"
	name="<%=YEARLY_SERIAL_NO %>" type="text" id="searchField1" /> <label>Batch
No</label> <input tabindex="1" name="<%=BATCH_NO %>" type="text"
	id="searchField2" /> <label>Chest No.</label> <input tabindex="1"
	name="<%=CHEST_NO%>" type="text" id="searchField3" />
<div class="Clear"></div>
<label>Roll No</label> <input tabindex="1" name="<%=ROLL_NO%>"
	type="text" id="searchField4" /> <label>Service</label> <select
	name="<%=SERVICE %>" id="searchField5">
	<option value="">select</option>
	<option value="A">ARMY</option>
	<option value="N">NAVY</option>
	<option value="F">AIR FORCE</option>
</select></div>
</form>
<div class="Clear"></div>
<input tabindex="1" type="button" name="Search" id="searchField"
	onclick="submitForm('medicalExaminationBoardPrint','medicalExaminationBoard?method=searchMedicalExaminationBoardSearch','checkSearchCriteria1');"
	value="Search" class="cmnButton" accesskey="a" />

<div class="Clear"></div>
<%
			
		 
	 if(medicalExaminationBoardList.size()==0 && map.get("medicalExaminationBoardList") != null)
	  {
%>
<h5><a
	href="medicalExaminationBoard?method=showMedicalExaminationBoardsSearchJsp">Show
All Records</a></h5>

<%
    }
%>

<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<div class="Clear"></div>





<div class="division"></div>
<div class="bottom"><LABEL>Changed By</LABEL> <label class="value"><%=userName%></label>
<LABEL>Changed Date</LABEL> <label class="value"><%=currentDate%></label>
<LABEL>Changed Time</LABEL> <label class="value"><%=currentTime%></label>
<INPUT type=hidden value="<%=userName%>" name="<%=CHANGED_BY%>">
<INPUT type=hidden value="<%=currentDate%>" name="<%=CHANGED_DATE %>">
<INPUT type=hidden value="<%=currentTime%>" name="<%=CHANGED_TIME %>">
<input name="<%=FLAG_FOR_PRINT%>" type="hidden" value="y" /></div>
</div>
<script type="text/javascript">

	formFields = [[0, "<%= ID%>"],[1,"<%= YEARLY_SERIAL_NO%>"],[2,"<%= BATCH_NO%>"],[3,"<%= CHEST_NO%>"],[4,"<%= ROLL_NO%>"],[5,"<%=SERVICE %>"]];	
		 statusTd = 5;
		</SCRIPT> <script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Yearly Serial No"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= YEARLY_SERIAL_NO%>"

data_header[1] = new Array;
data_header[1][0] = "Batch No"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= BATCH_NO %>";

data_header[2] = new Array;
data_header[2][0] = "Chest No"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= CHEST_NO %>";

data_header[3] = new Array;
data_header[3][0] = "Roll No"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= ROLL_NO %>";

data_header[4] = new Array;
data_header[4][0] = "Service"
data_header[4][1] = "data";
data_header[4][2] = "40%";
data_header[4][3] = "<%= SERVICE %>"

data_header[5] = new Array;
data_header[5][0] = "Changed By"
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_DATE %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_TIME %>";
data_arr = new Array();
<%
Iterator itr=medicalExaminationBoardList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasMedicalExaminationReportOnEntry  masMedicalExaminationReportOnEntry = (MasMedicalExaminationReportOnEntry)itr.next(); 
             %>

data_arr[<%= counter%>] = new Array();
<%if(masMedicalExaminationReportOnEntry.getId()!=null){%>
data_arr[<%= counter%>][0] = <%= masMedicalExaminationReportOnEntry.getId()%>
<%}else{%>
data_arr[<%= counter%>][0] =""
<%}%>
<%if(masMedicalExaminationReportOnEntry.getYearlySerialNo()!=null){%>
data_arr[<%= counter%>][1] = "<%=masMedicalExaminationReportOnEntry.getYearlySerialNo()%>"
<%}else{%>
data_arr[<%= counter%>][1] =""
<%}%>
<%if(masMedicalExaminationReportOnEntry.getBatchNo()!=null){%>
data_arr[<%= counter%>][2] = "<%= masMedicalExaminationReportOnEntry.getBatchNo()%>"
<%}else{%>
data_arr[<%= counter%>][2] ="";
<%}%>
<%if(masMedicalExaminationReportOnEntry.getChestNo()!=null){%>
data_arr[<%= counter%>][3] = "<%=masMedicalExaminationReportOnEntry.getChestNo()%>"
<%}else{%>
data_arr[<%= counter%>][3]=""
<%}%>
<%if(masMedicalExaminationReportOnEntry.getRollNo()!=null){%>
data_arr[<%= counter%>][4] = "<%= masMedicalExaminationReportOnEntry.getRollNo()%>"
<%}else{%>
data_arr[<%= counter%>][4]=""
<%}%>
<%if(masMedicalExaminationReportOnEntry.getService()!=null){%>
data_arr[<%= counter%>][5] = "<%= masMedicalExaminationReportOnEntry.getService()%>"
<%}else{%>
data_arr[<%= counter%>][5] = ""
<%}%>
<%if(masMedicalExaminationReportOnEntry.getLastChangedBy()!=null){%>
data_arr[<%= counter%>][6] = "<%= masMedicalExaminationReportOnEntry.getLastChangedBy() %>"
<%}else{%>
data_arr[<%= counter%>][6] =
<%}%>

<%if(masMedicalExaminationReportOnEntry.getLastChangedDate()!=null){%>
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(masMedicalExaminationReportOnEntry.getLastChangedDate()) %>"
<%}else{%>
data_arr[<%= counter%>][7] = ""
<%}%>
<%if(masMedicalExaminationReportOnEntry.getLastChangedTime()!=null){%>
data_arr[<%= counter%>][8] = "<%= masMedicalExaminationReportOnEntry.getLastChangedTime() %>"
<%}else{%>
data_arr[<%= counter%>][8] = 
<%}%>

<%
		     counter++;
}
%>
formName = "medicalExaminationBoardPrint"

nonEditable = ['<%= YEARLY_SERIAL_NO%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
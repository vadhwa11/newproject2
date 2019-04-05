<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script	type="text/javascript" language="javascript">
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


%>

<%
	if (map.get("message") != null) {
		message = (String) map.get("message");

	}
	if (!message.equalsIgnoreCase("")) {
%>
<h4></h4>
<%
	}
%>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<form name="medicalBoardOpinion" method="post" 	action="">
<div class="clear"></div>
<div class="clear"></div>
 </form>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script type="text/javascript">
	formFields = [ [0,"medExamid","id"],[1,"<%= RequestConstants.SERVICE_NO %>"], [2,"<%= RequestConstants.RANK_NAME %>"], [3,"<%=RANK_ID%>"], [4,"<%= RequestConstants.PATIENT_NAME %>"],[5,"medExamType"]];
	 statusTd = 5;
	</script>
   </div>


<div class="bottom">

<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=currentTime%>"/>
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
</div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Service No.";
data_header[0][1] = "data";
data_header[0][2] = "5%";
data_header[0][3] = "<%=RequestConstants.SERVICE_NO%>";

data_header[1] = new Array;
data_header[1][0] = "Rank "
data_header[1][1] = "data";
data_header[1][2] = "5%";
data_header[1][3] = "<%=RequestConstants.RANK_NAME  %>";

data_header[2] = new Array;
data_header[2][0] = "Name";
data_header[2][1] = "data";
data_header[2][2] = "10%";
data_header[2][3] = "<%=RequestConstants.PATIENT_NAME %>";

data_header[3] = new Array;
data_header[3][0] = "Unit"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%=RequestConstants.UNIT %>";

data_header[4] = new Array;
data_header[4][0] = "Med Cat"
data_header[4][1] = "data";
data_header[4][2] = "10%";
data_header[4][3] = "<%=RequestConstants.MED_CAT%>";



data_header[5] = new Array;
data_header[5][0] = "Date of L Med Board"
data_header[5][1] = "data";
data_header[5][2] = "10%";
data_header[5][3] = "<%=RequestConstants.DATE_OF_MB%>";

data_header[6] = new Array;
data_header[6][0] = "Place of L Med Board"
data_header[6][1] = "data";
data_header[6][2] = "10%";
data_header[6][3] = "<%=RequestConstants.PLACE_OF_MB%>";



data_header[7] = new Array;
data_header[7][0] = "Medical Board Type"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "<%=RequestConstants.MEDICAL_TYPE%>";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "<%=RequestConstants.STATUS%>";
<%
int  counter=0;

%>
  	 data_arr[<%= counter%>] = new Array();   
  
       data_arr[<%= counter%>][0] = 0;
	   
       data_arr[<%= counter%>][1] = '<a href="url">9999</a>'; 
		
	   data_arr[<%= counter%>][2] = '<a href="url">AC</a>'; 
	 
	   data_arr[<%= counter%>][3] ='<a href="url">anuj</a>';   
	
	   data_arr[<%= counter%>][4] = '<a href="url">1 GUJ ANCC</a>';  

	   data_arr[<%= counter%>][5] = '<a href="url">yyy</a>'; 
	   
	   data_arr[<%= counter%>][6] = '<a href="url">2011-06-23</a>'; 
	   		
	   data_arr[<%= counter%>][7] = '<a href="url">xxx</a>'; 

	   data_arr[<%= counter%>][8] = '<a href="url">Medical Board Rel/Invalidment AFMSF 16</a>'; 

	   data_arr[<%= counter%>][9] = '<a href="url">New</a>'; 
	      
<%
counter++;


%>
formName = "medicalBoardOpinion"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<input type="text" class="signPriority3" readonly="readonly" >
<label class="valueAutoPriority">Pending For Result</label>
<input type="text" class="signPriority1" readonly="readonly" >
<label class="valueAutoPriority">Rejected by Approving Authority</label>
<div class="floatRight"><label class="auto">Total Waiting Patient : </label>
		<label	class="valueAuto"><%=counter%></label>
		</div>


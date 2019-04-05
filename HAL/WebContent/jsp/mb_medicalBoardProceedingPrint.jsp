<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasMedicalBoardProceedings;"%>
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
<%
	

List<MasMedicalBoardProceedings> masMedicalBoardProceedingsList = new ArrayList<MasMedicalBoardProceedings>();
List<MasRank> rankList = new ArrayList<MasRank>();


Map map = new HashMap();



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
	
	

	if(map.get("medicalBoardList")!=null)
	{
		masMedicalBoardProceedingsList=(List<MasMedicalBoardProceedings>)map.get("medicalBoardList");
	}
String RANK1="";	
	if(map.get("rankList")!=null)
	{
		rankList=(List)map.get("rankList");
	}
	String message="";
	
	
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
<div id="contentHolder">
<div class="Clear"></div>
<form name="medicalBoardPreceedingsPrint" action="" method="post">

<div class="Clear"></div>






<div class="Clear"></div>
<h6>Print Medical Board Proceedings</h6>
<div class="blockFrame">
<div class="Clear"></div>

<label>Service No.</label> <input name="<%=SERVICE_NO %>" type="text"
	id="searchField1" tabindex="1" /> <label>Rank </label> <select
	id="searchField2" name="<%=RANK_ID %>" tabindex="1" class="select_adt">
	<option value="0">Select</option>
	<%
      for (MasRank masRank : rankList) {
   %>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
      }
   %>
</select> <input name="<%=FLAG_FOR_PRINT%>" type="hidden" id="searchField3"
	value="y" />

<div class="Clear"></div>
<label>First Name</label> <input name="<%=FIRST_NAME%>" type="text"
	id="searchField4" tabindex="1" /> <label>Last Name</label> <input
	name="<%=LAST_NAME %>" type="text" id="searchField5" tabindex="1" />
</form>


</div>
<input type="button" name="Search" id="searchField"
	onclick="submitForm('medicalBoardPreceedingsPrint','medicalboardSearch?method=searchMedicalBoardProceedingSearch','checkSearchForMedicalBoard');"
	value="Search" class="cmnButton" accesskey="a" tabindex="1" />


<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="bottom"><LABEL>Changed By</LABEL> <label class="value"><%=userName%></label>
<LABEL>Changed Date</LABEL> <label class="value"><%=currentDate%></label>
<LABEL>Changed Time</LABEL> <label class="value"><%=currentTime%></label>
<INPUT type=hidden value="<%=userName%>" name="<%=CHANGED_BY%>">
<INPUT type=hidden value="<%=currentDate%>" name="<%=CHANGED_DATE %>">
<INPUT type=hidden value="<%=currentTime%>" name="<%=CHANGED_TIME %>">

</div>
</div>

<script type="text/javascript">

	formFields = [[0,"<%=ID%>"],[1,"<%= SERVICE_NO%>"], [2,"<%= NAME%>"],[3,"<%= MEDICAL_ADMIN_NO %>"],[4,"<%= RANK %>"],[5,"<%=STATUS%>"]  ];
	 statusTd = 5;
	

	

data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "S NO.";
data_header[0][1] = "data";
data_header[0][2] = "0%";
data_header[0][3] = "<%= ID %>";

data_header[1] = new Array;
data_header[1][0] = "Service No.";
data_header[1][1] = "data";
data_header[1][2] = "20%";
data_header[1][3] = "<%= SERVICE_NO %>";

data_header[2] = new Array;
data_header[2][0] = "Patient Name";
data_header[2][1] = "data";
data_header[2][2] = "20%";
data_header[2][3] = "<%= NAME %>";

data_header[3] = new Array;
data_header[3][0] = "AD No";
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%= MEDICAL_ADMIN_NO %>";

data_header[4] = new Array;
data_header[4][0] = "Rank";
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%= RANK %>";

data_header[5] = new Array;
data_header[5][0] = "Status";
data_header[5][1] = "hide";
data_header[5][2] = "0%";
data_header[5][3] = "<%= STATUS %>";


<%
Iterator itr=masMedicalBoardProceedingsList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasMedicalBoardProceedings masMedicalBoardProceedingsList1 = (MasMedicalBoardProceedings)itr.next(); 
			
%>

data_arr[<%= counter%>] = new Array();

<%if(masMedicalBoardProceedingsList1.getId()!=null){%>
data_arr[<%= counter%>][0] = "<%= masMedicalBoardProceedingsList1.getId()%>";

<%System.out.println("idddddddd"+masMedicalBoardProceedingsList1.getId());}else{%>
data_arr[<%= counter%>][0]=""
<%}%>

<%if(masMedicalBoardProceedingsList1.getId()!=null){%>
data_arr[<%= counter%>][1] = "<%= masMedicalBoardProceedingsList1.getId()%>";
<%System.out.println("idddddddd"+masMedicalBoardProceedingsList1.getId());}else{%>
data_arr[<%= counter%>][1]=""
<%}%>

<%if(masMedicalBoardProceedingsList1.getServiceNo()!=null){%>
data_arr[<%= counter%>][2] = "<%= masMedicalBoardProceedingsList1.getServiceNo().toString()%>";
<%System.out.println("service noooooo"+masMedicalBoardProceedingsList1.getServiceNo());}else{%>
data_arr[<%= counter%>][2]=""
<%}%>


<%if(masMedicalBoardProceedingsList1.getFirstName()!=null){%>
data_arr[<%= counter%>][3] = "<%= masMedicalBoardProceedingsList1.getFirstName()%>";
<%}else{%>
data_arr[<%= counter%>][3] = ""
<%}%>
<%if(masMedicalBoardProceedingsList1.getAdNo()!=null){%>
data_arr[<%= counter%>][4] = "<%= masMedicalBoardProceedingsList1.getAdNo()%>";
<%}else{%>
data_arr[<%= counter%>][4]=""
<%}%>
<%if( masMedicalBoardProceedingsList1.getRankName()!=null){%>
data_arr[<%= counter%>][5] = "<%= masMedicalBoardProceedingsList1.getRankName()%>";
<% } else { %>
data_arr[<%= counter%>][5] = ""
<% } %>

<%if(masMedicalBoardProceedingsList1.getStatus()!=null){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}
counter++;
           }
%>
formName = "medicalBoardPreceedingsPrint"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>



<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BloodReactionEntry"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("bloodBagNo").value;
	errorMsg=errorMsg+document.getElementById("reactionNo").value;
	errorMsg=errorMsg+document.getElementById("pLName").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	errorMsg=errorMsg+document.getElementById("donorName").value;
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>
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
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> patientMap = new HashMap<String, Object>();
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
List<MasRank> rankList = new ArrayList<MasRank>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("patientMap") != null){
	patientMap= (Map<String, Object>)map.get("patientMap");
}
if(patientMap.get("reactionList") != null){
	reactionList= (List<BloodReactionEntry>)patientMap.get("reactionList");
}
if(map.get("rankList") != null){
	rankList= (List<MasRank>)map.get("rankList");
}
String message = "";
String deptType = "";
if(map.get("message") != null){
	message= (String)map.get("message");
}
if (map.get("deptType") != null) {
	deptType = (String) map.get("deptType");
}
	if (map.get("message") != null) {
	             message = (String) map.get("message");
	      }
	if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>

<%} %>
<form name="bloodEntry" method="post">
<div id="contentHolder">
<h6>Investigation Pending Transfusion Reaction</h6>
<div class="Clear"></div>
<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>

<div class="blockFrame"><label>Blood Bag No.</label> <input
	type="text" name="<%=BLOOD_BAG_NO %>" value="" MAXLENGTH="50"
	id="bloodBagNo" /> <label>Reaction No.</label> <input type="text"
	name="<%=ENTRY_NO %>" value="" MAXLENGTH="20" id="reactionNo" /> <label>Donor
Name</label> <input type="text" name="<%=DONOR_NAME %>" value="" MAXLENGTH="15"
	id="donorName" />
<div class="Clear"></div>
<label>Patient First Name</label> <input type="text"
	name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" id="pFName" /> <label>Patient
Last Name</label> <input type="text" name="<%=P_LAST_NAME %>" value=""
	MAXLENGTH="15" id="pLName" /></div>
<div class="Clear"></div>
<input type="button" name="search" id="addbutton"
	onclick="if(checkBlankSearch())submitForm('bloodEntry','/hms/hms/bloodBank?method=searchPatientForTransfussionReaction');"
	value="Search" class="cmnButton" accesskey="a" />
</form>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="searchPndTransReaction" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%=BLOOD_REACTION_ID%>", "id"], [1,"bloodBagNo"], [2,"reactionNo"], [3,"reactionDate"],[4,"patName"],[5,"rank"]];
	 statusTd =5;
	</script></form>
</div>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Blood Bag No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "bloodBagNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "Reaction No"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "reactionNo";
	
	data_header[2] = new Array;
	data_header[2][0] = "Reaction Date"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "reactionDate";
	
	data_header[3] = new Array;
	data_header[3][0] = "Patient Name"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "patName";
	
	data_header[4] = new Array;
	data_header[4][0] = "Rank"
	data_header[4][1] = "data";
	data_header[4][2] = "20%";
	data_header[4][3] = "rank";

	data_arr = new Array();	
	<%
		
	    int  counter=0;
		if (reactionList != null && reactionList.size() > 0) { %>
	
	<% 	for(BloodReactionEntry reactionEntry : reactionList){
	%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= reactionEntry.getId()%>
			data_arr[<%= counter%>][1] = "<%=reactionEntry.getBloodBagNo()%>"
			data_arr[<%= counter%>][2] = "<%=reactionEntry.getEntryNo()%>"
			data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(reactionEntry.getRactionDate())%>"
			<%if(reactionEntry.getHin() != null){%>
			data_arr[<%= counter%>][4] = "<%=reactionEntry.getHin().getPFirstName()%>"
			<%}else{%>
				data_arr[<%= counter%>][4] = "<%=reactionEntry.getDonorName()%>"
			<%}%>
			<%try{%>
				<%if(reactionEntry.getHin() != null){%>
			data_arr[<%= counter%>][5] = "<%=reactionEntry.getHin().getRank().getRankName()%>"
			<%}else{%>
				data_arr[<%= counter%>][5] = "-"
			<%}%>

			
		<%
			}catch(Exception e){
				e.printStackTrace();
			}
				     counter++;
			}
			}
		%>
		 formName = "searchPndTransReaction"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>
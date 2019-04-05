
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MdCoveringLetterUnitHd"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("entryNo").value;
	errorMsg=errorMsg+document.getElementById("entryDate").value;
	if(document.getElementById("unitId").value !=0)
	errorMsg=errorMsg+document.getElementById("unitId").value;
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>
<script>
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
<form name="patientSearch" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MdCoveringLetterUnitHd> patientList = new ArrayList<MdCoveringLetterUnitHd>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("unitList") != null){
			unitList= (List<MasUnit>)map.get("unitList");
		}
		if(patientMap.get("patientList") != null){
			patientList= (List<MdCoveringLetterUnitHd>)patientMap.get("patientList");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate"); 
		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		
		 }
		if(!message.equalsIgnoreCase("")){
		%>
<h2><%=message %></h2>
<%} %>

<div id="contentHolder">
<h6>Update Covering Letters to Unit</h6>
<div class="Clear"></div>
<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Entry No</label> <input
	id="entryNo" type="text" name="<%=ENTRY_NO %>" value="" MAXLENGTH="10" />

<label> Entry Date</label> <input type="text" class="calDate"
	id="entryDate" name="<%=ENTRY_DATE %>" value="" readonly="readonly"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',patientSearch.<%=ENTRY_DATE%>,event)" />

<label>Unit Name</label> <select id="unitId" name="<%=UNIT_ID %>">
	<option value="0">Select Unit</option>
	<% for(MasUnit masUnit : unitList){%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}	%>
</select> <input type="button" name="Submit" id="addbutton"
	onclick="if(checkBlankSearch()){submitForm('patientSearch','/hms/hms/mediClaim?method=showPatientUpdateCoveringLetter');}"
	value="Search" class="cmnButton" accesskey="a" />
<div class="Clear"></div>

</div>
</form>
<div class="Clear"></div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="searchUpdateCoveringLetter" method="post" action="">
<script type="text/javascript">
	formFields = [
			[0, "coveringLetterId", "id"], [1,"entryNo"], [2,"entryDate"], [3,"unit"]];
	 statusTd = 3;
</script></form>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Entry No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "entryNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "Entry Date"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "entryDate";
	
	data_header[2] = new Array;
	data_header[2][0] = "Unit"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "unit";
	
	data_arr = new Array();
	<%
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { %>
	
	<% 	for(MdCoveringLetterUnitHd coveringLetterUnitHd : patientList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= coveringLetterUnitHd.getId()%>
			data_arr[<%= counter%>][1] = "<%=coveringLetterUnitHd.getEntryNo()%>"
			data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(coveringLetterUnitHd.getEntryDate())%>"
			<%if(coveringLetterUnitHd.getUnit()!=null){%>
			data_arr[<%= counter%>][3] = "<%=coveringLetterUnitHd.getUnit().getUnitName()%> "
			<%}else {%>
			data_arr[<%= counter%>][3] = ""
			
		<%}
			
				     counter++;
		    	}
		}
		%>
		
    formName = "searchUpdateCoveringLetter"
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	}
	makeTable(start,end);
	</script>
